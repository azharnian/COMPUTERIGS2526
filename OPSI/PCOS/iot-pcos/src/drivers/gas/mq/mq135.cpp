#include "mq135.h"
#include <math.h>

#define MQ135_CLEAN_AIR_RATIO 3.6

// approximate constants
#define MQ135_M -0.42
#define MQ135_B 1.92

MQ135::MQ135(int pin) : GasBase(pin) {}

void MQ135::init() {
    GasBase::init();
}

void MQ135::calibrate(int samples) {
    float rs_total = 0;

    for (int i = 0; i < samples; i++) {
        float v = readRaw();
        float rs = calculateRS(v);
        rs_total += rs;
        delay(100);
    }

    float rs_avg = rs_total / samples;
    R0 = rs_avg / MQ135_CLEAN_AIR_RATIO;

}

float MQ135::readPPM() {
    float voltage = readRaw();
    float rs = calculateRS(voltage);

    if (R0 == 0) return 0;

    float ratio = rs / R0;

    float ppm = pow(10, (log10(ratio) - MQ135_B) / MQ135_M);

    return ppm;

}

const char* MQ135::getName() {
    return "MQ-135 (Air Quality)";
}