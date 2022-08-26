import os
import shutil
import pymysql
import time

if __name__ == '__main__':
    try:
        os.system('mkdir image\plate')

        os.system('python ./TensorFlow-2.x-YOLOv3-master/detection_custom.py')

        os.system('python ./CRAFT-pytorch-master/test.py --trained_model=./CRAFT-pytorch-master/weights/craft_mlt_25k.pth --test_folder=./image/plate')

        os.system('Python ./deep-text-recognition-benchmark-master/demo.py --saved_model ./deep-text-recognition-benchmark-master/TPS-ResNet-BiLSTM-Attn-case-sensitive.pth --sensitive --image_folder ./image/cut --Transformation TPS --FeatureExtraction ResNet --SequenceModeling BiLSTM --Prediction Attn')

        shutil.rmtree('./image/cut')
        shutil.rmtree('./image/plate')
        os.remove('./image/original/original.jpg')

        with open("result.txt","r") as f:
            data = f.read()
            
        f.close()
        # updata plate number to database 
        os.remove('result.txt')
        data = data.replace('-','')
        print("plate number is "+data)
        # data = "456789"

        db = pymysql.connect(host='localhost',
                            user='admin',
                            password='shao19991031',
                            database='apms')
        cursor = db.cursor()

        sql = "SELECT * FROM pk_record WHERE vehicle_reg_num = '%s' and exit_time is NULL"%(data)
        
        try:
            # 执行SQL语句
            cursor.execute(sql)
            # 获取所有记录列表
            results = cursor.fetchall()
            
            if results==():
                checkSpBlackListUser = "SELECT vehicle_reg_no FROM details_vrn WHERE details_id = ANY(SELECT details_id FROM sys_user WHERE username = ANY(SELECT user_name FROM special_list WHERE `status`=0 AND vehicle_reg_num = 'ALL'))"
                checkSpBlackListVRN = "SELECT vehicle_reg_num FROM special_list WHERE status = 0 AND vehicle_reg_num != 'ALL'"
                try:
                    cursor.execute(checkSpBlackListUser)
                    blackList1 = cursor.fetchall()
                    cursor.execute(checkSpBlackListVRN)
                    blackList2 = cursor.fetchall()
                    inBlackList = False

                    # print(blackList1)
                    # print(blackList2)
                    for row1 in blackList1:
                        if row1[0] == data:
                            inBlackList = True
                    for row1 in blackList2:
                        if row1[0] == data:
                            inBlackList = True
                    
                    if(inBlackList):
                        print("You can in the BLACK list, please contact manager")
                        with open("send.txt","w") as file:
                            file.write("0")
                    else:
                        #enter parking lot, insert data
                        insertRecord = "INSERT INTO pk_record(vehicle_reg_num,entry_time,if_paid) VALUES ('%s','%s',%s)"%(data,time.strftime("%Y-%m-%d %H:%M:%S", time.localtime()),0)
                
                        try:
                                # 执行sql语句
                            cursor.execute(insertRecord)
                            # 提交到数据库执行
                            db.commit()
                            print("open secrity barrier")
                            with open("send.txt","w") as file:
                                file.write("1")
                        except:
                            # 如果发生错误则回滚
                            print("error")
                            db.rollback()


                except:
                    print ("1Error: unable to fetch data")
                
                
            else:
                for row in results:
                    if row[5] == 0:
                        checkSpWhiteListUser = "SELECT vehicle_reg_no FROM details_vrn WHERE details_id = ANY(SELECT details_id FROM sys_user WHERE username = ANY(SELECT user_name FROM special_list WHERE `status`=1 AND vehicle_reg_num = 'ALL'))"
                        checkSpWhiteListVRN = "SELECT vehicle_reg_num FROM special_list WHERE status = 1 AND vehicle_reg_num != 'ALL'"
                        try:
                            cursor.execute(checkSpWhiteListUser)
                            whiteList1 = cursor.fetchall()
                            cursor.execute(checkSpWhiteListVRN)
                            whiteList2 = cursor.fetchall()
                            # print(whiteList1)
                            # print(whiteList2)
                            inWhiteList = False
                            for row2 in whiteList1:
                                if row2[0] == data:
                                    inWhiteList = True
                            for row2 in whiteList2:
                                if row2[0] == data:
                                    inWhiteList = True

                            if(inWhiteList):
                                updateRecord = "UPDATE pk_record SET exit_time = '%s', if_paid = 1 WHERE pk_record_id = %s"%(time.strftime("%Y-%m-%d %H:%M:%S", time.localtime()),row[0])
                                try:
                                    # 执行SQL语句
                                    cursor.execute(updateRecord)
                                    # 提交到数据库执行
                                    db.commit()
                                    print("open secrity barrier")
                                    with open("send.txt","w") as file:
                                        file.write("1")
                                except:
                                    # 发生错误时回滚
                                    db.rollback()
                            else:
                                print("The parking fee not paid")
                                with open("send.txt","w") as file:
                                    file.write("0")
                        except:
                            print ("2Error: unable to fetch data")
                    else:
                        updateRecord = "UPDATE pk_record SET exit_time = '%s', if_paid = 1 WHERE pk_record_id = %s"%(time.strftime("%Y-%m-%d %H:%M:%S", time.localtime()),row[0])
                        try:
                            # 执行SQL语句
                            cursor.execute(updateRecord)
                            # 提交到数据库执行
                            db.commit()
                            print("open secrity barrier")
                            with open("send.txt","w") as file:
                                file.write("1")
                        except:
                            # 发生错误时回滚
                            db.rollback()

        except:
            print ("3Error: unable to fetch data")
        

        db.close()
    except:
        print("No plate detect!")
        with open("send.txt","w") as file:
            file.write("0")