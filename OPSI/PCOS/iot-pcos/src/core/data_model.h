#ifndef DATA_MODEL_H
#define DATA_MODEL_H

#include <Arduino.h>

struct SensorData {
    float suhu;
    float ph;

    float ch4;
    float co;
    float nh3;
    float co2;
    float h2s;

    float air_quality;

    String tank_id;
    unsigned long timestamp;

};

#endif