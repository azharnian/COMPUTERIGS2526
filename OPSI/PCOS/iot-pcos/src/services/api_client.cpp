#include "api_client.h"
#include <WiFi.h>
#include <HTTPClient.h>
#include "../config/config.h"

void ApiClient::init() {
// tidak ada yang perlu di-init sekarang
}

bool ApiClient::sendData(const SensorData& data) {
    if (WiFi.status() != WL_CONNECTED) {
    Serial.println("WiFi not connected");
    return false;
    }

    HTTPClient http;

    http.begin(API_URL);
    http.addHeader("Content-Type", "application/json");
    http.addHeader("Authorization", DEVICE_TOKEN);

    String json = "{";
    json += "\"tank_id\":\"" + String(TANK_ID) + "\",";
    json += "\"timestamp\":" + String(data.timestamp) + ",";

    json += "\"suhu\":" + String(data.suhu) + ",";
    json += "\"ph\":" + String(data.ph) + ",";

    json += "\"ch4\":" + String(data.ch4) + ",";
    json += "\"co\":" + String(data.co) + ",";
    json += "\"nh3\":" + String(data.nh3) + ",";
    json += "\"co2\":" + String(data.co2) + ",";
    json += "\"h2s\":" + String(data.h2s) + ",";

    json += "\"air_quality\":" + String(data.air_quality);

    json += "}";

    int httpCode = http.POST(json);

    if (httpCode > 0) {
        Serial.print("HTTP Response: ");
        Serial.println(httpCode);

        String response = http.getString();
        Serial.println(response);

        http.end();
        return true;
    } else {
        Serial.print("HTTP Error: ");
        Serial.println(http.errorToString(httpCode));

        http.end();
        return false;
    }

}