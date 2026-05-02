#ifndef GAS_INTERFACE_H
#define GAS_INTERFACE_H

class GasInterface {
    public:
    virtual void init() = 0;

    // baca nilai dalam ppm
    virtual float readPPM() = 0;

    // optional: nama sensor (debugging)
    virtual const char* getName() = 0;

};

#endif