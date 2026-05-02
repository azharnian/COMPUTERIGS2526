#include "h2s_ze07.h"

H2S_ZE07::H2S_ZE07(HardwareSerial& serialPort) {
    serial = &serialPort;
}

void H2S_ZE07::init() {
    serial->begin(9600);
}

float H2S_ZE07::readPPM() {
    byte buffer[9];

    if (serial->available()) {
        serial->readBytes(buffer, 9);

        // cek header (optional tapi bagus)
        if (buffer[0] == 0xFF && buffer[1] == 0x86) {
            int value = (buffer[4] << 8) | buffer[5];
            return value / 100.0;
        }
    }

    return -1; // data belum siap

}

const char* H2S_ZE07::getName() {
    return "ZE07-H2S";
}