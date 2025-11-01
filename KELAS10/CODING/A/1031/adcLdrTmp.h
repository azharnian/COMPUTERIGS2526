const int ldrPin = A0;
const int ledLdr = 3;

const int tmpPin = A1;
const int ledTmp = 5;

void ldrJob() {
  int adcLdr = analogRead(ldrPin);          
  float percent = (adcLdr / 1023.0) * 100.0;
  int pwmLdr = map(adcLdr, 0, 1023, 0, 255);
  analogWrite(ledLdr, pwmLdr);

  Serial.print("LDR -> ADC: ");
  Serial.print(adcLdr);
  Serial.print(" | Brightness: ");
  Serial.print(percent, 1);
  Serial.println(" %");
}

void temperatureJob() {
  int adcTmp = analogRead(tmpPin);
  float voltage = (adcTmp * 5.0) / 1023.0;
  float temperatureC = (voltage - 0.5) * 100.0;

  int pwmTmp = map((int)temperatureC, 20, 40, 0, 255);
  if (pwmTmp < 0) pwmTmp = 0;
  if (pwmTmp > 255) pwmTmp = 255;
  analogWrite(ledTmp, pwmTmp);

  Serial.print("TMP -> ADC: ");
  Serial.print(adcTmp);
  Serial.print(" | Volt: ");
  Serial.print(voltage, 2);
  Serial.print(" V | Temp: ");
  Serial.print(temperatureC, 1);
  Serial.println(" C");
}

void setup() {
  Serial.begin(9600);
  pinMode(ledLdr, OUTPUT);
  pinMode(ledTmp, OUTPUT);
}

void loop() {
  ldrJob();
  temperatureJob();
  delay(200);
}
