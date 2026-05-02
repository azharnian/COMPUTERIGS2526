#include "system_controller.h"
#include "../services/wifi_service.h"

SystemController::SystemController() {
    lastSendTime = 0;
    sendInterval = 5000; // kirim tiap 5 detik
    }

    void SystemController::init() {
    wifi_init();

    sensorManager.init();
    api.init();

}

void SystemController::update() {
    // pastikan WiFi tetap hidup
    wifi_loop();

    // cek koneksi
    if (!wifi_is_connected()) {
        return;
    }

    unsigned long now = millis();

    // kirim data tiap interval
    if (now - lastSendTime > sendInterval) {
        lastSendTime = now;

        SensorData data = sensorManager.readAll();

        bool success = api.sendData(data);

        if (!success) {
            Serial.println("Failed to send data");
        }
    }

}