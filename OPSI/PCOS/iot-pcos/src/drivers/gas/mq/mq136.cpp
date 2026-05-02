#include "mq136.h"
#include <math.h>

#define MQ136_CLEAN_AIR_RATIO 3.0

// approximate constants
#define MQ136_M -0.48
#define MQ136_B 1.30

MQ136::MQ136(int pin) : GasBase(pin) {}

void MQ136::init() {
    GasBase::init();
}

void MQ136::calibrate(int samples) {
    float rs_total = 0;

    for (int i = 0; i < samples; i++) {
        float v = readRaw();
        float rs = calculateRS(v);
        rs_total += rs;
        delay(100);
    }

    float rs_avg = rs_total / samples;
    R0 = rs_avg / MQ136_CLEAN_AIR_RATIO;

}

float MQ136::readPPM() {
    float voltage = readRaw();
    float rs = calculateRS(voltage);

    if (R0 == 0) return 0;

    float ratio = rs / R0;

    float ppm = pow(10, (log10(ratio) - MQ136_B) / MQ136_M);

    return ppm;

}

const char* MQ136::getName() {
    return "MQ-136 (H2S approx)";
}