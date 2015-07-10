package com.rongrong.action.dbaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import com.rongrong.dao.PrCommentTbMapper;
import com.rongrong.model.PrCommentTb;
@Controller
@RequestMapping(value = "/db/prCommentTb")
public class PrCommentTbActionDB {
	@Autowired
	private PrCommentTbMapper prCommentTbMapper;
	@RequestMapping(value = "save", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void savem (@RequestBody PrCommentTb prCommentTb) {
		prCommentTbMapper.save(prCommentTb);
	}
	@RequestMapping(value = "update", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void updatem (@RequestBody PrCommentTb prCommentTb) {
		if(prCommentTb.getId()==null){
			return;
		}
		prCommentTbMapper.update(prCommentTb);
	}
	@RequestMapping(value = "getBy", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public ModelAndView getBym () {
		List<PrCommentTb> list = prCommentTbMapper.getBy(new PrCommentTb());
		ModelAndView mav = new ModelAndView("/jspdb/PrCommentTb.jsp");
		mav.addObject("prCommentTb", list);
		return mav;
	}

}