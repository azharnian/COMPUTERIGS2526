#ifndef TEMP_DS18B20_H
#define TEMP_DS18B20_H

#include <Arduino.h>
#include <OneWire.h>
#include <DallasTemperature.h>
#include "../sensor_interface.h"

class TempDS18B20 : public SensorInterface {
    private:
    int pin;
    OneWire* oneWire;
    DallasTemperature* sensors;

    public:
    TempDS18B20(int pin);

    void init();
    float read();
    const char* getName();

};

#endif