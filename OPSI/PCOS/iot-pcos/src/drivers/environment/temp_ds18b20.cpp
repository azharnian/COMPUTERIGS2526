#include "temp_ds18b20.h"

TempDS18B20::TempDS18B20(int pin) {
    this->pin = pin;
}

void TempDS18B20::init() {
    oneWire = new OneWire(pin);
    sensors = new DallasTemperature(oneWire);

    sensors->begin();

}

float TempDS18B20::read() {
    sensors->requestTemperatures();
    float tempC = sensors->getTempCByIndex(0);

    return tempC;

}

const char* TempDS18B20::getName() {
    return "DS18B20 Temperature";
}