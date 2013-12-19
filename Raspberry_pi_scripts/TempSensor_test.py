import sys
import urllib2
import smbus
import time

bus = smbus.SMBus(1)
address = 0x04
currentDate = datetime.datetime.now()

def readNumber():
    arduinoInput = bus.read_byte(address)
    return arduinoInput

while True:

    temperature = readNumber()
    print temperature
    
    field = urllib2.urlopen("http://localhost:8081/temperature_monitor/storeTemperature/50" + "/" + temperature)
    time.sleep(10)
