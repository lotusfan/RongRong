package com.rongrong.dao;
import com.rongrong.model.PrPraiseTb;
import java.util.List;
public interface PrPraiseTbMapper{
	public void save(PrPraiseTb prPraiseTb);
	public void update(PrPraiseTb prPraiseTb);
	public List<PrPraiseTb> getBy(PrPraiseTb prPraiseTb);
	public PrPraiseTb getUniqueBy(PrPraiseTb prPraiseTb);
	public Integer count(PrPraiseTb prPraiseTb);
	public List<PrPraiseTb> getConditionBy(PrPraiseTb prPraiseTb);
}