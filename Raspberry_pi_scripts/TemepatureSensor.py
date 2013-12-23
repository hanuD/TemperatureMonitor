import sys
import urllib2
import smbus
import time
import datetime
import urllib

bus = smbus.SMBus(1)
address = 0x04
constantDate = datetime.datetime.now().replace(second =0, microsecond =0)
temperature = 0
counter = 0

def readTemperature():
  arduinoInput = bus.read_byte(address)
  return arduinoInput

def sendSMS():
  global constantDate
  global temperature
  global counter
  print "inside sms"
  
  counter = 0
  constantDate = datetime.datetime.now().replace(second =0, microsecond =0)
  
  passman = urllib2.HTTPPasswordMgrWithDefaultRealm()
  passman.add_password(None, "https://twilix.exotel.in/v1/Accounts/thoughtworks1/Sms/send", "thoughtworks1", "4728de4fa3537a94eb50cc5b821d7e0597487204")
  auth_handler = urllib2.HTTPBasicAuthHandler(passman)
  opener = urllib2.build_opener(auth_handler)
  urllib2.install_opener(opener)
  user_agent = "Mozilla/4.0 (compatible; MSIE 5.5s; Windows NT)"
  header = {'User-Agent' : user_agent}
  body = "TWI BLR Temperature is {0}".format(temperature)    
  data = {
    "From" : "TWIBLR",
    "To" : "9535577756",
    "Body" : body
  }
  data = urllib.urlencode(data) 

  request = urllib2.Request("https://twilix.exotel.in/v1/Accounts/thoughtworks1/Sms/send",data, header)
  response = urllib2.urlopen(request)
  print response.read()


while True:
  temperature = readTemperature()
  
  if temperature > 25 and temperature < 30 :
    counter += 1
    if counter > 3 :
      if (datetime.datetime.now().replace(second=0, microsecond=0) - constantDate) >= datetime.timedelta(minutes=1) :
        sendSMS()
    time.sleep(10)  
    continue

  elif temperature >= 30 and temperature < 35 :
    counter += 1
    if counter > 2 :
      if (datetime.datetime.now().replace(second=0, microsecond=0) - constantDate) >= datetime.timedelta(minutes=1) :
        sendSMS()
    time.sleep(10)
    continue

  elif temperature >= 35 :
    counter += 1
    if counter > 1 :
      if (datetime.datetime.now().replace(second=0, microsecond=0) - constantDate) >= datetime.timedelta(minutes=1) :
        sendSMS()
    time.sleep(10)
    continue
    
  time.sleep(10)
