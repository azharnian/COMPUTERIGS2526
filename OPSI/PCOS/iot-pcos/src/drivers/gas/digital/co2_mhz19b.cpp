#include "co2_mhz19b.h"

CO2_MHZ19B::CO2_MHZ19B(HardwareSerial& serialPort) {
    serial = &serialPort;
}

void CO2_MHZ19B::init() {
    serial->begin(9600);
}

float CO2_MHZ19B::readPPM() {
    byte cmd[9] = {0xFF, 0x01, 0x86, 0, 0, 0, 0, 0, 0x79};
    byte response[9];

    serial->write(cmd, 9);
    serial->readBytes(response, 9);

    int ppm = (response[2] << 8) + response[3];

    return ppm;

}

const char* CO2_MHZ19B::getName() {
    return "MH-Z19B (CO2)";
}