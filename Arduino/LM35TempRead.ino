
float tempC;
int reading;
int tempPin = 0;

void setup()
{
Serial.begin(9600);
  
   
}

void loop()
{
reading = analogRead(tempPin);
Serial.println(reading);
tempC = reading / 9.31;
//tempC = (5.0 * tempC * 100.0)/1024.0;
Serial.println((byte)tempC);
delay(1000);
}


