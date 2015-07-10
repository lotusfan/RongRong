package com.rongrong.action.dbaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import com.rongrong.dao.LogInfoMapper;
import com.rongrong.model.LogInfo;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/db/logInfo")
public class LogInfoActionDB {
	@Autowired
	private LogInfoMapper logInfoMapper;
	@RequestMapping(value = "save", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void savem (@RequestBody LogInfo logInfo) {
		logInfoMapper.save(logInfo);
	}
	@RequestMapping(value = "update", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void updatem (@RequestBody LogInfo logInfo) {
		if(logInfo.getId()==null){
			return;
		}
		logInfoMapper.update(logInfo);
	}
	@RequestMapping(value = "getBy", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public ModelAndView getBym () {
		List<LogInfo> list = logInfoMapper.getBy(new LogInfo());
		ModelAndView mav = new ModelAndView("/jspdb/LogInfo.jsp");
		mav.addObject("logInfo", list);
		return mav;
	}

    @RequestMapping(value = "getTest")
    @ResponseBody
    public String getTest(HttpServletRequest httpServletRequest) {
        httpServletRequest.getSession().setAttribute("username", "465798798");
        return "success";
    }

}