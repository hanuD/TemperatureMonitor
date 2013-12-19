import sys
import urllib2
import smbus
import time
import datetime

bus = smbus.SMBus(1)
address = 0x04
currentDate = datetime.datetime.now()

def readNumber():
    arduinoInput = bus.read_byte(address)
    return arduinoInput

while True:
    rackNum = readNumber()
    if not rackNum:
        continue
    temperature = readNumber()
    
    if not temperature    
        continue

    if ((datetime.datetime.now() - currentDate) / 60 > 5)
        field = urllib2.urlopen("http://localhost:8081/temperature_monitor/storeTemperature/" + rackNum + "/" + temperature)
        continue
