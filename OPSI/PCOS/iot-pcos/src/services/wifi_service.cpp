#include "wifi_service.h"
#include <WiFi.h>
#include "../config/config.h"

unsigned long lastReconnectAttempt = 0;
const unsigned long reconnectInterval = 10000; // 10 detik

void wifi_connect() {
    Serial.println("Connecting to WiFi...");
    WiFi.begin(WIFI_SSID, WIFI_PASS);
}

void wifi_init() {
    WiFi.mode(WIFI_STA);
    wifi_connect();
}

bool wifi_is_connected() {
    return WiFi.status() == WL_CONNECTED;
}

void wifi_loop() {
    if (WiFi.status() == WL_CONNECTED) {
        return;
    }

    unsigned long now = millis();

    if (now - lastReconnectAttempt > reconnectInterval) {
        lastReconnectAttempt = now;

        Serial.println("Reconnecting WiFi...");
        WiFi.disconnect();
        wifi_connect();
    }

}