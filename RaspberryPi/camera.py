from picamera import PiCamera
import time

camera = PiCamera()

camera.start_preview()
time.sleep(5)

camera.capture("original.jpg")