package com.rongrong.action.dbaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import com.rongrong.dao.PrShareTbMapper;
import com.rongrong.model.PrShareTb;
@Controller
@RequestMapping(value = "/db/prShareTb")
public class PrShareTbActionDB {
	@Autowired
	private PrShareTbMapper prShareTbMapper;
	@RequestMapping(value = "save", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void savem (@RequestBody PrShareTb prShareTb) {
		prShareTbMapper.save(prShareTb);
	}
	@RequestMapping(value = "update", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void updatem (@RequestBody PrShareTb prShareTb) {
		if(prShareTb.getId()==null){
			return;
		}
		prShareTbMapper.update(prShareTb);
	}
	@RequestMapping(value = "getBy", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public ModelAndView getBym () {
		List<PrShareTb> list = prShareTbMapper.getBy(new PrShareTb());
		ModelAndView mav = new ModelAndView("/jspdb/PrShareTb.jsp");
		mav.addObject("prShareTb", list);
		return mav;
	}

}