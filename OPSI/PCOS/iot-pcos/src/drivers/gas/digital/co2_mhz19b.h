#ifndef CO2_MHZ19B_H
#define CO2_MHZ19B_H

#include <Arduino.h>
#include "../gas_interface.h"

class CO2_MHZ19B : public GasInterface {
    private:
    HardwareSerial* serial;

    public:
    CO2_MHZ19B(HardwareSerial& serialPort);

    void init();
    float readPPM();
    const char* getName();

};

#endif
