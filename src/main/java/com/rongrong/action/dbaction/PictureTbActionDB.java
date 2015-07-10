package com.rongrong.action.dbaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import com.rongrong.dao.PictureTbMapper;
import com.rongrong.model.PictureTb;
@Controller
@RequestMapping(value = "/db/pictureTb")
public class PictureTbActionDB {
	@Autowired
	private PictureTbMapper pictureTbMapper;
	@RequestMapping(value = "save", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void savem (@RequestBody PictureTb pictureTb) {
		pictureTbMapper.save(pictureTb);
	}
	@RequestMapping(value = "update", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void updatem (@RequestBody PictureTb pictureTb) {
		if(pictureTb.getId()==null){
			return;
		}
		pictureTbMapper.update(pictureTb);
	}
	@RequestMapping(value = "getBy", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public ModelAndView getBym () {
		List<PictureTb> list = pictureTbMapper.getBy(new PictureTb());
		ModelAndView mav = new ModelAndView("/jspdb/PictureTb.jsp");
		mav.addObject("pictureTb", list);
		return mav;
	}

}