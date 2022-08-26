import RPi.GPIO as GPIO
import time 
GPIO.setmode(GPIO.BCM)

from picamera import PiCamera
camera = PiCamera()

import os

from gpiozero import Buzzer
from time import sleep

buzzer = Buzzer(17)

TRIG = 23
ECHO = 24

Red = 5
Yellow = 6
Green = 16

print("Distance Measurement In progress")

GPIO.setup(TRIG,GPIO.OUT)
GPIO.setup(ECHO,GPIO.IN)

GPIO.setup(Red,GPIO.OUT)
GPIO.setup(Yellow,GPIO.OUT)
GPIO.setup(Green,GPIO.OUT)

def use_camera():
    # camera.start_preview()
    # time.sleep(2)
    print("Open camera")
    GPIO.output(Red,False)
    GPIO.output(Yellow,True)
    camera.capture("original.jpg")

def read_result():
    os.system("sshpass -p 'CUfcXx2tMN;-o=$W6Q;AqTt4-x0k1t;t' scp Administrator@54.166.255.244:C:/FYP/send.txt .")
    with open("send.txt","r") as f:
        data = f.read()
    if data=="0":
        return False
    if data=="1":
        return True

def app():
    print("start recognite")
    # send image to server
    os.system("sshpass -p 'CUfcXx2tMN;-o=$W6Q;AqTt4-x0k1t;t' scp original.jpg Administrator@54.166.255.244:C:/FYP/image/original")

    # run the app.py get the reg-number
    os.system("sshpass -p 'CUfcXx2tMN;-o=$W6Q;AqTt4-x0k1t;t' ssh Administrator@54.166.255.244 'cd C:/FYP && conda activate FYP && python app.py'")
    flag = read_result()
    if flag:
        GPIO.output(Yellow,False)
        GPIO.output(Green,True)
        sleep(5)
    else:
        GPIO.output(Yellow,False)
        GPIO.output(Red,True)
    


 
try:
    while True:
        GPIO.output(Green,False)
        GPIO.output(Red,True)

        GPIO.output(TRIG,False)
        print("Waiting For Sensor To Settle")
        time.sleep(2)

        GPIO.output(TRIG,True)
        time.sleep(0.00001)
        GPIO.output(TRIG,False)

        while GPIO.input(ECHO)==0:
            pulse_start = time.time()
        
        while GPIO.input(ECHO)==1:
            pulse_end = time.time()
        
        pulse_duration = pulse_end-pulse_start

        distance = pulse_duration*17150

        distance = round(distance,2)

        print("Distance:",distance,"cm")

        GPIO.output(TRIG,False)
        print("Waiting For Sensor To Settle")
        time.sleep(2)

        GPIO.output(TRIG,True)
        time.sleep(0.00001)
        GPIO.output(TRIG,False)

        while GPIO.input(ECHO)==0:
            pulse_start = time.time()
        
        while GPIO.input(ECHO)==1:
            pulse_end = time.time()
        
        pulse_duration = pulse_end-pulse_start

        distance2 = pulse_duration*17150

        distance2 = round(distance2,2)

        print("Distance2:",distance2,"cm")

        distance_diff = distance2-distance
        print("Distance_diff:",distance_diff,"cm")

        if distance<150 and distance>100:
            buzzer.on()
            sleep(0.3)
            buzzer.off()
            sleep(0.3)
            if(distance_diff<1 and distance_diff>-1):
                use_camera()
                app()
        elif distance<=100 and distance>70:
            buzzer.on()
            sleep(0.2)
            buzzer.off()
            sleep(0.2)
            if(distance_diff<1 and distance_diff>-1):
                use_camera()
                app()
        elif distance<=70 and distance>30:
            buzzer.on()
            sleep(0.1)
            buzzer.off()
            sleep(0.1)
            if(distance_diff<1 and distance_diff>-1):
                use_camera()
                app()
        elif distance<=30:
            buzzer.on()
            if(distance_diff<1 and distance_diff>-1):
                use_camera()
                app()    
except KeyboardInterrupt:
    print("Cleaning up")
    GPIO.cleanup()        

