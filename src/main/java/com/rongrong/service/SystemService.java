package com.rongrong.service;

import com.jcabi.aspects.Loggable;
import com.rongrong.dao.transactionmanager.LogInfoTransactionManager;
import com.rongrong.model.LogInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhangfan on 2015/7/15.
 *
 * 系统基础服务  登录、登出日志，
 */
@Service
@Loggable(trim = false)
public class SystemService {

    @Autowired
    private LogInfoTransactionManager logInfoTransactionManager;

    /**
     * 登录 登出日志
     *
     * @param logInfo
     */
    public void loginInfo(LogInfo logInfo) {
        try {
            logInfoTransactionManager.saveLogInfo(logInfo);
        } catch (Exception e) {

        }
    }
}
