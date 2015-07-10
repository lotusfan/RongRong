package com.rongrong.dao;
import com.rongrong.model.PrCommentTb;
import java.util.List;
public interface PrCommentTbMapper{
	public void save(PrCommentTb prCommentTb);
	public void update(PrCommentTb prCommentTb);
	public List<PrCommentTb> getBy(PrCommentTb prCommentTb);
	public PrCommentTb getUniqueBy(PrCommentTb prCommentTb);
	public Integer count(PrCommentTb prCommentTb);
	public List<PrCommentTb> getConditionBy(PrCommentTb prCommentTb);
}