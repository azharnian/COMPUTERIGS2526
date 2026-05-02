#include "logger.h"

void log_info(const String& msg) {
    Serial.print("[INFO] ");
    Serial.println(msg);
}

void log_error(const String& msg) {
    Serial.print("[ERROR] ");
    Serial.println(msg);
}