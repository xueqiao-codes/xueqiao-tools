package xueqiao.mail.ao.thriftapi.server.impl;


import java.util.Properties;

import org.apache.thrift.TException;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.container.TServiceCntl;
import xueqiao.mail.MailEntity;
import xueqiao.mail.MailSettings;
import xueqiao.mail.ao.handler.MailHandler;
import xueqiao.mail.ao.thriftapi.server.MailAoAdaptor;

public class MailAoHandler extends MailAoAdaptor {
    @Override
    public int InitApp(Properties props) {
        return 0;
    }

    @Override
    protected void sendMail(TServiceCntl oCntl, MailSettings settings, MailEntity mailEntity) throws ErrorInfo, TException {
        MailHandler mailHandler = new MailHandler();
        mailHandler.checkParams(settings, mailEntity);
        mailHandler.sendMail(settings, mailEntity);
    }

    @Override
    public void destroy() {
    }
}
