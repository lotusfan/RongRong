package com.rongrong.dao.transactionmanager;

import com.rongrong.dao.LogInfoMapper;
import com.rongrong.model.LogInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogInfoTransactionManager {



    @Autowired
    private LogInfoMapper logInfoMapper;


    public void saveLogInfo(LogInfo logInfo) {

        logInfoMapper.save(logInfo);
    }

    public void saveLogInfos(List<LogInfo> logInfos) {

        if (logInfos == null) {
            return;
        }
        for (int i = 0; i < logInfos.size(); i++) {
            logInfoMapper.save(logInfos.get(i));
        }
    }

    public void updateLogInfo(LogInfo logInfo) {
        logInfoMapper.update(logInfo);

    }

    public void updateLogInfos(List<LogInfo> logInfos) {
        if (logInfos == null) {
            return;
        }
        for (int i = 0; i < logInfos.size(); i++) {
            logInfoMapper.update(logInfos.get(i));
        }
    }

    public LogInfo getUniqueBy(LogInfo logInfo) {

        return logInfoMapper.getUniqueBy(logInfo);
    }

    public List<LogInfo> getBy(LogInfo logInfo) {

        return logInfoMapper.getBy(logInfo);
    }

    public Integer count(LogInfo logInfo) {

        return logInfoMapper.count(logInfo);
    }

}
