#ifndef MQ4_H
#define MQ4_H

#include "gas_base.h"

class MQ4 : public GasBase {
    public:
    MQ4(int pin);

    void init();
    void calibrate(int samples = 50);

    float readPPM();   // metana (CH4)
    const char* getName();

};

#endif
