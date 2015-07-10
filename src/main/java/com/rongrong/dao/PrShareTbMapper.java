package com.rongrong.dao;
import com.rongrong.model.PrShareTb;
import java.util.List;
public interface PrShareTbMapper{
	public void save(PrShareTb prShareTb);
	public void update(PrShareTb prShareTb);
	public List<PrShareTb> getBy(PrShareTb prShareTb);
	public PrShareTb getUniqueBy(PrShareTb prShareTb);
	public Integer count(PrShareTb prShareTb);
	public List<PrShareTb> getConditionBy(PrShareTb prShareTb);
}