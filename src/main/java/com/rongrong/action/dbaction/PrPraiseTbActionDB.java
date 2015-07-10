package com.rongrong.action.dbaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import com.rongrong.dao.PrPraiseTbMapper;
import com.rongrong.model.PrPraiseTb;
@Controller
@RequestMapping(value = "/db/prPraiseTb")
public class PrPraiseTbActionDB {
	@Autowired
	private PrPraiseTbMapper prPraiseTbMapper;
	@RequestMapping(value = "save", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void savem (@RequestBody PrPraiseTb prPraiseTb) {
		prPraiseTbMapper.save(prPraiseTb);
	}
	@RequestMapping(value = "update", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void updatem (@RequestBody PrPraiseTb prPraiseTb) {
		if(prPraiseTb.getId()==null){
			return;
		}
		prPraiseTbMapper.update(prPraiseTb);
	}
	@RequestMapping(value = "getBy", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public ModelAndView getBym () {
		List<PrPraiseTb> list = prPraiseTbMapper.getBy(new PrPraiseTb());
		ModelAndView mav = new ModelAndView("/jspdb/PrPraiseTb.jsp");
		mav.addObject("prPraiseTb", list);
		return mav;
	}

}