#ifndef GAS_BASE_H
#define GAS_BASE_H

#include <Arduino.h>

class GasBase {
    protected:
    int pin;
    float R0;
    float RL; // load resistor (biasanya 10k)

    public:
    GasBase(int analogPin, float rl = 10.0);

    void init();

    float readRaw();        // baca ADC
    float calculateRS(float raw);
    void calibrate(int samples = 50);

    float getR0();

};

#endif