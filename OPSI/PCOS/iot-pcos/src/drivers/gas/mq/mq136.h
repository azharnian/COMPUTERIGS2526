#ifndef MQ136_H
#define MQ136_H

#include "gas_base.h"

class MQ136 : public GasBase {
    public:
    MQ136(int pin);

    void init();
    void calibrate(int samples = 50);

    float readPPM();   // H2S (kasar)
    const char* getName();

};

#endif