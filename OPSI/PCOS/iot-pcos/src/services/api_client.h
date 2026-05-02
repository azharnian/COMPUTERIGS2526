#ifndef API_CLIENT_H
#define API_CLIENT_H

#include <Arduino.h>
#include "../core/data_model.h"

class ApiClient {
    public:
    void init();
    bool sendData(const SensorData& data);
};

#endif