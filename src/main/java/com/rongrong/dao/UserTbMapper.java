package com.rongrong.dao;
import com.rongrong.model.UserTb;
import java.util.List;
public interface UserTbMapper{
	public void save(UserTb userTb);
	public void update(UserTb userTb);
	public List<UserTb> getBy(UserTb userTb);
	public UserTb getUniqueBy(UserTb userTb);
	public Integer count(UserTb userTb);
	public List<UserTb> getConditionBy(UserTb userTb);
}