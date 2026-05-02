#ifndef MQ7_H
#define MQ7_H

#include "gas_base.h"

class MQ7 : public GasBase {
    private:
    int heaterPin;
    unsigned long lastSwitchTime;
    bool highPhase;

    public:
    MQ7(int analogPin, int heaterPin);

    void init();
    void updateCycle();   // harus dipanggil di loop

    void calibrate(int samples = 50);

    float readPPM();
    const char* getName();

};

#endif
