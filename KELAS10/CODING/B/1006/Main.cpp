const int LED = 3;
const int RGB[3] = {9, 11, 10};

void fadeInOutLED()
{
  for (int i = 0; i <= 255; i++)
  {
   	analogWrite(LED, i);
    delay(10);
  }
  
  for (int i = 255; i >= 0; i--)
  {
   	analogWrite(LED, i);
    delay(10);
  }
}

void turnOnRGB(int R, int G, int B)
{
  analogWrite(RGB[0], R);
  analogWrite(RGB[1], G);
  analogWrite(RGB[2], B);
  delay(10);
}

void setup()
{
  pinMode(LED, OUTPUT);
  for (auto LAMP : RGB)
  {
   	pinMode(LAMP, OUTPUT); 
  }
}

void loop()
{
  fadeInOutLED();
  turnOnRGB(204, 32, 227);
}