package com.rongrong.dao;
import com.rongrong.model.LogInfo;
import java.util.List;
public interface LogInfoMapper{
	public void save(LogInfo logInfo);
	public void update(LogInfo logInfo);
	public List<LogInfo> getBy(LogInfo logInfo);
	public LogInfo getUniqueBy(LogInfo logInfo);
	public Integer count(LogInfo logInfo);
	public List<LogInfo> getConditionBy(LogInfo logInfo);
}