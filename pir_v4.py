#!/usr/bin/env python3

from selenium import webdriver
import RPi.GPIO as GPIO
import time

GPIO.setmode(GPIO.BCM)
PIR_PIN = 7
GPIO.setup(PIR_PIN, GPIO.IN)

profile = webdriver.FirefoxProfile("/root/.mozilla/firefox/83z2lbls.default")
driver = webdriver.Firefox(profile)
driver.get("http://127.0.0.1:8080/mirror/home3")

def MOTION(PIR_PIN):
	print ("Motion Detected!")
	element = driver.find_element_by_id("motion_detect")
	element.click()

print ("PIR Module Test(CTRL+C to exit)")
time.sleep(2)
print ("Ready")

try:
	GPIO.add_event_detect(PIR_PIN, GPIO.RISING, callback=MOTION)
	while 1:
		time.sleep(20)
		element = driver.find_element_by_id("motion_clear")
		element.click()		

except KeyboardInterrupt:
	print ("Quit")
	GPIO.cleanup()
	driver.close()