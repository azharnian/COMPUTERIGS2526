#ifndef MQ135_H
#define MQ135_H

#include "gas_base.h"

class MQ135 : public GasBase {
    public:
    MQ135(int pin);

    void init();
    void calibrate(int samples = 50);

    float readPPM();   // pseudo CO2 / air quality
    const char* getName();

};

#endif