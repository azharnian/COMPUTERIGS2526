#ifndef H2S_ZE07_H
#define H2S_ZE07_H

#include <Arduino.h>
#include "../gas_interface.h"

class H2S_ZE07 : public GasInterface {
    private:
    HardwareSerial* serial;

    public:
    H2S_ZE07(HardwareSerial& serialPort);

    void init();
    float readPPM();
    const char* getName();

};

#endif
