package com.rongrong.dao;
import com.rongrong.model.PictureTb;
import java.util.List;
public interface PictureTbMapper{
	public void save(PictureTb pictureTb);
	public void update(PictureTb pictureTb);
	public List<PictureTb> getBy(PictureTb pictureTb);
	public PictureTb getUniqueBy(PictureTb pictureTb);
	public Integer count(PictureTb pictureTb);
	public List<PictureTb> getConditionBy(PictureTb pictureTb);
}