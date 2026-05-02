#include "ph_sensor.h"

PHSensor::PHSensor(int pin) {
    this->pin = pin;

    // default (sementara)
    slope = -5.7;
    intercept = 21.34;

}

void PHSensor::init() {
    pinMode(pin, INPUT);
    }

    float PHSensor::read() {
    int adc = analogRead(pin);

    float voltage = (adc / 4095.0) * 3.3;

    float ph = slope * voltage + intercept;

    return ph;

}

const char* PHSensor::getName() {
    return "pH Sensor";
}

void PHSensor::calibrate(float v1, float ph1, float v2, float ph2) {
    slope = (ph2 - ph1) / (v2 - v1);
    intercept = ph1 - slope * v1;
}