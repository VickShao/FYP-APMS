*************************************
Student ID: D18125179
Student Name: Xinyang Shao
Class: TU856/4
*************************************

Final Year Project: Automatically Parking Management System

--- Hardware:
    Device requirement:
    Raspberry Pi 4 Model B
    Raspberry Pi Camera Board - Night Vision & Adjustable-Focus Lens
    Ultrasonic Distance Sensor (HC-SR04) (TRIG -pin 23 ECHO - pin 24)
    LED red - pin 5
    LED Yellow - pin 6
    LED Green - pin 16 
    buzzer - pin 17
    breadboard, resistor and Jumper Bumpers.


    Environment requirement:
    Raspberry PI OS (32bit)
    SHH client service

    EXECUTE ./RaspberryPi/app.py in Raspberry Pi
-----------------------------------------------------------------

--- Software:
    APNR:
    Download newest Anaconda
    Use new_backup.yaml import the FYP environment
    activate environment by run 'conda activate FYP'
    install SSH server

    Web Application:
    install Tomcat 8.5.77
    install mysql 8.0.28.0
    instal maven 3.6.3
    
    The installation pachage in in the ./insrallation_package

    Modify mybatis-config.xml by your MySQL server details

    Execute FYP_SQL.sql on you MySQL server

    Run Web Application on the Tomcat Server
-----------------------------------------------------------------


Note: The Software part is published on the AWS EC2 Serverice
Contact author to get the dynamic public IP address to access the project
Email: d18125179@mytudublin.ie

