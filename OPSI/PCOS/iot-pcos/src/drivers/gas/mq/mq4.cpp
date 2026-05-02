#include "mq4.h"
#include <math.h>

#define MQ4_CLEAN_AIR_RATIO 9.83

// konstanta dari kurva datasheet (approx)
#define MQ4_M -0.38
#define MQ4_B 0.30

MQ4::MQ4(int pin) : GasBase(pin) {}

void MQ4::init() {
    GasBase::init();
}

void MQ4::calibrate(int samples) {
    float rs_total = 0;

    for (int i = 0; i < samples; i++) {
        float v = readRaw();
        float rs = calculateRS(v);
        rs_total += rs;
        delay(100);
    }

    float rs_avg = rs_total / samples;

    // gunakan ratio MQ-4
    R0 = rs_avg / MQ4_CLEAN_AIR_RATIO;

}

float MQ4::readPPM() {
    float voltage = readRaw();
    float rs = calculateRS(voltage);

    if (R0 == 0) return 0;

    float ratio = rs / R0;

    // rumus log-log
    float ppm = pow(10, (log10(ratio) - MQ4_B) / MQ4_M);

    return ppm;

}

const char* MQ4::getName() {
    return "MQ-4 (CH4)";
}
