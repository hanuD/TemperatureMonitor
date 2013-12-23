#include <Wire.h>

#define SLAVE_ADDRESS 0x04

float temperature;
int reading;
int tempPin = 0;

void setup()
{
  Serial.begin(9600);
  Wire.begin(SLAVE_ADDRESS);
  Wire.onRequest(sendData);
}

void loop()
{
reading = analogRead(tempPin);
temperature = reading * 0.488;
}

void sendData(){
    Wire.write((int)temperature);
}



