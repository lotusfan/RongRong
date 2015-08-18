package com.rongrong.dao;
import com.rongrong.model.MessageTb;
import com.rongrong.model.requestview.CardView;
import com.rongrong.model.requestview.MessageView;

import java.util.List;
public interface MessageTbMapper{
	public void save(MessageTb messageTb);
	public void update(MessageTb messageTb);
	public List<MessageTb> getBy(MessageTb messageTb);
	public MessageTb getUniqueBy(MessageTb messageTb);
	public Integer count(MessageTb messageTb);
	public List<MessageTb> getConditionBy(MessageTb messageTb);

    public List<CardView> getReceiveCardConditionBy(MessageTb messageTb);

    public List<CardView> getSendCardConditionBy(MessageTb messageTb);

	public List<MessageView> getMessageBoxConditionBy(MessageTb messageTb);

	public void clearMessageBox(MessageTb messageTb);

}