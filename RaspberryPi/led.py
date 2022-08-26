import RPi.GPIO as GPIO
import time 
GPIO.setmode(GPIO.BCM)

Red = 5
Yellow = 6
Green = 16

GPIO.setup(Red,GPIO.OUT)
GPIO.setup(Yellow,GPIO.OUT)
GPIO.setup(Green,GPIO.OUT)


try:
    while True:
        GPIO.output(Red,True)
        time.sleep(2)
        GPIO.output(Red,False)
        time.sleep(2)
        GPIO.output(Yellow,True)
        time.sleep(2)
        GPIO.output(Yellow,False)
        time.sleep(2)
        GPIO.output(Green,True)
        time.sleep(2)
        GPIO.output(Green,False)
        time.sleep(2)
except KeyboardInterrupt:
    print("Cleaning up")
    GPIO.cleanup()  