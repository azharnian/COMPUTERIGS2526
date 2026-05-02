#include <Arduino.h>
#include "core/system_controller.h"

SystemController systemController;

void setup() {
    Serial.begin(115200);
    delay(1000); // kasih waktu serial siap

    Serial.println("=== ESP32 Tank Monitoring System ===");

    systemController.init();

    Serial.println("System initialized.");

}

void loop() {
    Serial.println("Loop running...");
    systemController.update();
    delay(1000); // debug mode
}
