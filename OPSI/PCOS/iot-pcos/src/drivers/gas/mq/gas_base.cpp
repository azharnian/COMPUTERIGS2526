#include "gas_base.h"

GasBase::GasBase(int analogPin, float rl) {
    pin = analogPin;
    RL = rl;
    R0 = 10.0; // default sementara
}

void GasBase::init() {
    pinMode(pin, INPUT);
}

float GasBase::readRaw() {
    int adc = analogRead(pin);

    // ESP32 ADC max 4095
    float voltage = (adc / 4095.0) * 3.3;

    return voltage;

    }

    float GasBase::calculateRS(float voltage) {
    if (voltage == 0) return 0;

    float rs = ((3.3 - voltage) / voltage) * RL;
    return rs;

}

void GasBase::calibrate(int samples) {
    float rs_total = 0;

    for (int i = 0; i < samples; i++) {
        float v = readRaw();
        float rs = calculateRS(v);
        rs_total += rs;
        delay(100);
    }

    float rs_avg = rs_total / samples;

    // ratio udara bersih (default 9.83 → contoh MQ-4)
    R0 = rs_avg / 9.83;

}

float GasBase::getR0() {
    return R0;
}