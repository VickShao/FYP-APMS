import os
os.environ['CUDA_VISIBLE_DEVICES'] = '-1'
os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'
import cv2
import numpy as np
import tensorflow as tf
from yolov3.yolov3 import Create_Yolov3
from yolov3.utils import detect_image, detect_realtime, detect_video, Load_Yolo_model, detect_video_realtime_mp
from yolov3.configs import *

input_size = YOLO_INPUT_SIZE
Daeknet_weights = YOLO_V3_WEIGHTS

yolo = Create_Yolov3(input_size=input_size, CLASSES=TRAIN_CLASSES)

yolo.load_weights("./TensorFlow-2.x-YOLOv3-master/checkpoints/yolov3_custom")

i = 1
final_score = 0

for root,dirs,files in os.walk("./image/original/test/"):
    for file in files:
        image_path = os.path.join(root,file)
        result_path = "./image/plate_test/test_"+str(i)+".jpg"
        print(image_path)
        print(result_path)
        
        image, score = detect_image(yolo, image_path, result_path, input_size=YOLO_INPUT_SIZE, show=False, CLASSES=TRAIN_CLASSES, rectangle_colors=(255,0,0))
        final_score = final_score + score
        
        i = i + 1

print("avg IoU:"+str(final_score/i))