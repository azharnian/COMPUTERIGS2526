#include "mq7.h"
#include <math.h>

#define MQ7_CLEAN_AIR_RATIO 27.0

// konstanta dari datasheet (approx)
#define MQ7_M -0.77
#define MQ7_B 1.70

// timing (ms)
#define HIGH_TIME 60000
#define LOW_TIME  90000

MQ7::MQ7(int analogPin, int heaterPin)
: GasBase(analogPin) {
    this->heaterPin = heaterPin;
    highPhase = true;
    lastSwitchTime = 0;
}

void MQ7::init() {
    GasBase::init();
    pinMode(heaterPin, OUTPUT);
    digitalWrite(heaterPin, HIGH); // mulai dari HIGH
}

void MQ7::updateCycle() {
    unsigned long now = millis();

    if (highPhase && (now - lastSwitchTime > HIGH_TIME)) {
        digitalWrite(heaterPin, LOW);
        highPhase = false;
        lastSwitchTime = now;
    }
    else if (!highPhase && (now - lastSwitchTime > LOW_TIME)) {
        digitalWrite(heaterPin, HIGH);
        highPhase = true;
        lastSwitchTime = now;
    }

}

void MQ7::calibrate(int samples) {
    // kalibrasi hanya valid saat LOW phase
    if (highPhase) return;

    float rs_total = 0;

    for (int i = 0; i < samples; i++) {
        float v = readRaw();
        float rs = calculateRS(v);
        rs_total += rs;
        delay(100);
    }

    float rs_avg = rs_total / samples;
    R0 = rs_avg / MQ7_CLEAN_AIR_RATIO;

}

float MQ7::readPPM() {
    // hanya baca saat LOW phase
    if (highPhase) return -1;

    float voltage = readRaw();
    float rs = calculateRS(voltage);

    if (R0 == 0) return 0;

    float ratio = rs / R0;

    float ppm = pow(10, (log10(ratio) - MQ7_B) / MQ7_M);

    return ppm;

}

const char* MQ7::getName() {
    return "MQ-7 (CO)";
}
