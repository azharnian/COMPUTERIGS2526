#ifndef LOGGER_H
#define LOGGER_H

#include <Arduino.h>

void log_info(const String& msg);
void log_error(const String& msg);

#endif