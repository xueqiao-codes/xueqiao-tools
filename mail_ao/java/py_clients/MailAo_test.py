#!/usr/bin/env python
# test for service MailAo
import random
from mail_ao.ttypes import *
from mail_ao.constants import *
from mail_ao.client.MailAoStub import *

stub=MailAoStub()
#using like stub.xxxfunc(routeKey=random.randint(0, 100000), timeout=3000, args...)
#testing...

