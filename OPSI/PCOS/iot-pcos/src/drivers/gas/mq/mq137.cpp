#include "mq137.h"
#include <math.h>

#define MQ137_CLEAN_AIR_RATIO 3.6

// konstanta kurva (approx)
#define MQ137_M -0.42
#define MQ137_B 1.92

MQ137::MQ137(int pin) : GasBase(pin) {}

void MQ137::init() {
    GasBase::init();
}

void MQ137::calibrate(int samples) {
    float rs_total = 0;

    for (int i = 0; i < samples; i++) {
        float v = readRaw();
        float rs = calculateRS(v);
        rs_total += rs;
        delay(100);
    }

    float rs_avg = rs_total / samples;
    R0 = rs_avg / MQ137_CLEAN_AIR_RATIO;

}

float MQ137::readPPM() {
    float voltage = readRaw();
    float rs = calculateRS(voltage);

    if (R0 == 0) return 0;

    float ratio = rs / R0;

    float ppm = pow(10, (log10(ratio) - MQ137_B) / MQ137_M);

    return ppm;

}

const char* MQ137::getName() {
    return "MQ-137 (NH3)";
}