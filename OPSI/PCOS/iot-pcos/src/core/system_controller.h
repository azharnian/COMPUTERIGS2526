#ifndef SYSTEM_CONTROLLER_H
#define SYSTEM_CONTROLLER_H

#include "sensor_manager.h"
#include "../services/api_client.h"

class SystemController {
    private:
    SensorManager sensorManager;
    ApiClient api;

    unsigned long lastSendTime;
    unsigned long sendInterval;

    public:
    SystemController();

    void init();
    void update();

};

#endif