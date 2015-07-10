package com.rongrong.action.dbaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import com.rongrong.dao.ProjectTbMapper;
import com.rongrong.model.ProjectTb;
@Controller
@RequestMapping(value = "/db/projectTb")
public class ProjectTbActionDB {
	@Autowired
	private ProjectTbMapper projectTbMapper;
	@RequestMapping(value = "save", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void savem (@RequestBody ProjectTb projectTb) {
		projectTbMapper.save(projectTb);
	}
	@RequestMapping(value = "update", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void updatem (@RequestBody ProjectTb projectTb) {
		if(projectTb.getId()==null){
			return;
		}
		projectTbMapper.update(projectTb);
	}
	@RequestMapping(value = "getBy", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public ModelAndView getBym () {
		List<ProjectTb> list = projectTbMapper.getBy(new ProjectTb());
		ModelAndView mav = new ModelAndView("/jspdb/ProjectTb.jsp");
		mav.addObject("projectTb", list);
		return mav;
	}

}