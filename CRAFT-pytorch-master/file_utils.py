# -*- coding: utf-8 -*-
import os
import numpy as np
import cv2
import imgproc

# borrowed from https://github.com/lengstrom/fast-style-transfer/blob/master/src/utils.py
def get_files(img_dir):
    imgs, masks, xmls = list_files(img_dir)
    return imgs, masks, xmls

def list_files(in_path):
    img_files = []
    mask_files = []
    gt_files = []
    for (dirpath, dirnames, filenames) in os.walk(in_path):
        for file in filenames:
            filename, ext = os.path.splitext(file)
            ext = str.lower(ext)
            if ext == '.jpg' or ext == '.jpeg' or ext == '.gif' or ext == '.png' or ext == '.pgm':
                img_files.append(os.path.join(dirpath, file))
            elif ext == '.bmp':
                mask_files.append(os.path.join(dirpath, file))
            elif ext == '.xml' or ext == '.gt' or ext == '.txt':
                gt_files.append(os.path.join(dirpath, file))
            elif ext == '.zip':
                continue
    # img_files.sort()
    # mask_files.sort()
    # gt_files.sort()
    return img_files, mask_files, gt_files

def saveResult(img_file, img, boxes, dirname='./result/', verticals=None, texts=None):
        """ save text detection result one by one
        Args:
            img_file (str): image file name
            img (array): raw image context
            boxes (array): array of result file
                Shape: [num_detections, 4] for BB output / [num_detections, 4] for QUAD output
        Return:
            None
        """
        img = np.array(img)

        # make result file list
        filename, file_ext = os.path.splitext(os.path.basename(img_file))

        # result directory
        res_file = dirname + "res_" + filename + '.txt'
        res_img_file = dirname + "res_" + filename + '.jpg'
        res_img_file_final = dirname + "res_" + filename + '_final.jpg'

        if not os.path.isdir(dirname):
            os.mkdir(dirname)

        largestarea = 0
        largestbox = 0
        # with open(res_file, 'w') as f:
        for i, box in enumerate(boxes):
            w=box[1][0]-box[0][0]
            h=box[2][1]-box[0][1]
            area = w*h

            if(area>largestarea):
                largestarea = area
                largestbox = box

                # print(largestbox)
                # print(box)
                # print(box[0][1])
        poly = np.array(largestbox).astype(np.int32).reshape((-1))
            # strResult = ','.join([str(p) for p in poly]) + '\r\n'
            # f.write(strResult)

        y1 = largestbox[0][1].astype(np.int32)
        y2 = largestbox[2][1].astype(np.int32)
        x1 = largestbox[0][0].astype(np.int32)
        x2 = largestbox[1][0].astype(np.int32)
        cv2.imwrite(res_img_file_final, img[y1:y2,x1:x2])

        poly = poly.reshape(-1, 2)
        cv2.polylines(img, [poly.reshape((-1, 1, 2))], True, color=(0, 0, 255), thickness=2)

        ptColor = (0, 255, 255)
        if verticals is not None:
            if verticals[i]:
                ptColor = (255, 0, 0)

        if texts is not None:
            font = cv2.FONT_HERSHEY_SIMPLEX
            font_scale = 0.5
            cv2.putText(img, "{}".format(texts[i]), (poly[0][0]+1, poly[0][1]+1), font, font_scale, (0, 0, 0), thickness=1)
            cv2.putText(img, "{}".format(texts[i]), tuple(poly[0]), font, font_scale, (0, 255, 255), thickness=1)    
                

        # Save result image
        # cv2.imwrite(res_img_file, img)
        

