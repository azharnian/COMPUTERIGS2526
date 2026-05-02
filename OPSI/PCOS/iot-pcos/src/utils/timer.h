#ifndef TIMER_H
#define TIMER_H

class Timer {
    private:
    unsigned long lastTime;
    unsigned long interval;

    public:
    Timer(unsigned long intervalMs) {
    interval = intervalMs;
    lastTime = 0;
    }

    bool isReady() {
        unsigned long now = millis();
        if (now - lastTime >= interval) {
            lastTime = now;
            return true;
        }
        return false;
    }

};

#endif