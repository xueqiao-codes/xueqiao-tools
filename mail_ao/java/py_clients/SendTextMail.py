#!/usr/bin/env python
#coding=utf-8
# test for service MailAo
import random
from mail_ao.ttypes import *
from mail_ao.constants import *
from mail_ao.client.MailAoStub import *

stub=MailAoStub()
#using like stub.xxxfunc(routeKey=random.randint(0, 100000), timeout=3000, args...)
#testing...

settings = MailSettings(smtpHost="smtp.xueqiao.cn", sender="service@xueqiao.cn", passwd="SerVice1919")

mail = MailEntity()
mail.receivers = ["lijianqiang@xueqiao.cn"]
# mail.receivers = ["lijianqiang@xueqiao.com"]
mail.subject = "测试邮件"
# content = MailContent(contentType=0, content="这是文字邮件")
content1 = MailContent(contentType=0, content="这是文字邮件，来自雪橇")
content2 = MailContent(contentType=1, content="<html><head><title>邮件</title></head><body><h1></h1><p>这是HTML邮件</body></html>")
mail.content = content1
# mail.content = content2
mail.attachments = ["/data/home/lijianqiang/mail_ao_py/SendTextMail.py", "/data/home/lijianqiang/mail_ao_py/MailAo_test.py"]

stub.sendMail(0, 3000, settings, mail)