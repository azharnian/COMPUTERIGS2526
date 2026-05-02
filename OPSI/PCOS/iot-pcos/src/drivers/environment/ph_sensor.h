#ifndef PH_SENSOR_H
#define PH_SENSOR_H

#include <Arduino.h>
#include "../sensor_interface.h"

class PHSensor : public SensorInterface {
    private:
    int pin;

    float voltage;  

    // parameter kalibrasi
    float slope;
    float intercept;

    public:
    PHSensor(int pin);

    void init();
    float read();
    const char* getName();

    // kalibrasi manual
    void calibrate(float v1, float ph1, float v2, float ph2);

};

#endif