#ifndef SENSOR_INTERFACE_H
#define SENSOR_INTERFACE_H

class SensorInterface {
    public:
    virtual void init() = 0;
    virtual float read() = 0;
    virtual const char* getName() = 0;
};

#endif