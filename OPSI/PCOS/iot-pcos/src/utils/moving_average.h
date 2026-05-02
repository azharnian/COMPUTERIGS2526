#ifndef MOVING_AVERAGE_H
#define MOVING_AVERAGE_H

class MovingAverage {
    private:
    float* buffer;
    int size;
    int index;
    float sum;

    public:
    MovingAverage(int size) {
    this->size = size;
    buffer = new float[size];
    index = 0;
    sum = 0;

        for (int i = 0; i < size; i++) {
            buffer[i] = 0;
        }
    }

    float add(float value) {
        sum -= buffer[index];
        buffer[index] = value;
        sum += value;

        index = (index + 1) % size;

        return sum / size;
    }

};

#endif