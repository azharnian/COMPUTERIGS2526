#ifndef SENSOR_MANAGER_H
#define SENSOR_MANAGER_H

#include "data_model.h"

// include semua sensor
#include "../drivers/gas/mq/mq4.h"
#include "../drivers/gas/mq/mq7.h"
#include "../drivers/gas/mq/mq137.h"
#include "../drivers/gas/mq/mq135.h"
#include "../drivers/gas/mq/mq136.h"

#include "../drivers/gas/digital/co2_mhz19b.h"
#include "../drivers/gas/digital/h2s_ze07.h"

#include "../drivers/environment/temp_ds18b20.h"
#include "../drivers/environment/ph_sensor.h"

class SensorManager {
    private:
    // MQ sensors
    MQ4 mq4;
    MQ7 mq7;
    MQ137 mq137;
    MQ135 mq135;
    MQ136 mq136;

    // digital sensors
    CO2_MHZ19B co2;
    H2S_ZE07 h2s;

    // environment
    TempDS18B20 temp;
    PHSensor ph;

    public:
    SensorManager();

    void init();
    SensorData readAll();

};

#endif