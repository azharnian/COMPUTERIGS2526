#ifndef MQ137_H
#define MQ137_H

#include "gas_base.h"

class MQ137 : public GasBase {
    public:
    MQ137(int pin);

    void init();
    void calibrate(int samples = 50);

    float readPPM();   // NH3
    const char* getName();

};

#endif