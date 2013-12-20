import sys
import urllib2
import urllib

import time
import datetime


address = 0x04
currentDate = datetime.datetime.now().replace(second =0, microsecond =0)
temperature = 0


def readNumber():
    arduinoInput = 26
    return arduinoInput

def sendSMS():
	global currentDate
	global temperature
	print "inside sms"
	currentDate = datetime.datetime.now().replace(second =0, microsecond =0)
	passman = urllib2.HTTPPasswordMgrWithDefaultRealm()
	passman.add_password(None, "https://twilix.exotel.in/v1/Accounts/thoughtworks1/Sms/send", "thoughtworks1", "4728de4fa3537a94eb50cc5b821d7e0597487204")
	auth_handler = urllib2.HTTPBasicAuthHandler(passman)
	opener = urllib2.build_opener(auth_handler)
	urllib2.install_opener(opener)
	user_agent = "Mozilla/4.0 (compatible; MSIE 5.5s; Windows NT)"
	header = {'User-Agent' : user_agent}
	data = {
    	'From' : 'TWIBLR',
    	'To' : '9686602556',
    	'Body': 'Please fill your timesheet - ThoughtWorks Bangalore ' + str(temperature)
	}
	data = urllib.urlencode(data) 

	request = urllib2.Request("https://twilix.exotel.in/v1/Accounts/thoughtworks1/Sms/send",data, header)
	response = urllib2.urlopen(request)
	print response.read()


while True:

    temperature = readNumber()

    if temperature > 25 and temperature < 30 :
    	if (datetime.datetime.now().replace(second=0, microsecond=0) - currentDate) >= datetime.timedelta(minutes=1) :
    		sendSMS()
    	time.sleep(10)	
    	continue

    elif temperature >= 30 and temperature < 35 :
    	if (datetime.datetime.now().replace(second=0, microsecond=0) - currentDate) >= datetime.timedelta(minutes=1) :
    		sendSMS()
    	time.sleep(10)
    	continue

    elif temperature >= 35 :
    	if (datetime.datetime.now().replace(second=0, microsecond=0) - currentDate) >= datetime.timedelta(minutes=1) :
    		sendSMS()
    	time.sleep(10)
    	continue
    
    time.sleep(10)

    
