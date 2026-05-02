#include "sensor_manager.h"

// gunakan Serial2 untuk CO2 dan Serial1 untuk H2S
HardwareSerial co2Serial(2);
HardwareSerial h2sSerial(1);

SensorManager::SensorManager()
: mq4(34),
mq7(35, 25),
mq137(32),
mq135(33),
mq136(36),
co2(co2Serial),
h2s(h2sSerial),
temp(4),
ph(39) {}

void SensorManager::init() {
    // init serial untuk sensor digital
    co2Serial.begin(9600, SERIAL_8N1, 16, 17);
    h2sSerial.begin(9600, SERIAL_8N1, 4, 5);

    // init semua sensor
    mq4.init();
    mq7.init();
    mq137.init();
    mq135.init();
    mq136.init();

    co2.init();
    h2s.init();

    temp.init();
    ph.init();

    // kalibrasi MQ (opsional: lakukan di udara bersih)
    mq4.calibrate();
    mq137.calibrate();
    mq135.calibrate();
    mq136.calibrate();

}

SensorData SensorManager::readAll() {
    SensorData data;

    // timestamp
    data.timestamp = millis();

    // environment
    data.suhu = temp.read();
    data.ph   = ph.read();

    // gas MQ
    data.ch4 = mq4.readPPM();
    data.co  = mq7.readPPM();
    data.nh3 = mq137.readPPM();

    data.air_quality = mq135.readPPM();
    data.h2s = mq136.readPPM(); // backup

    // digital sensors (utama)
    data.co2 = co2.readPPM();

    float h2s_val = h2s.readPPM();
    if (h2s_val != -1) {
        data.h2s = h2s_val; // override dengan sensor utama
    }

    return data;

}