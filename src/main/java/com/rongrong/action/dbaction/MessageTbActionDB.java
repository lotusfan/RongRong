package com.rongrong.action.dbaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import com.rongrong.dao.MessageTbMapper;
import com.rongrong.model.MessageTb;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/db/messageTb")
public class MessageTbActionDB {
	@Autowired
	private MessageTbMapper messageTbMapper;
	@RequestMapping(value = "save", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void savem (@RequestBody MessageTb messageTb) {
		messageTbMapper.save(messageTb);
	}
	@RequestMapping(value = "update", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void updatem (@RequestBody MessageTb messageTb) {
		if(messageTb.getId()==null){
			return;
		}
		messageTbMapper.update(messageTb);
	}

    @RequestMapping(value = "getBy", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public ModelAndView getBym(HttpServletRequest httpServletRequest) {
        List<MessageTb> list = messageTbMapper.getBy(new MessageTb());
        ModelAndView mav = new ModelAndView("/jspdb/MessageTb.jsp");
        mav.addObject("messageTb", list);
        return mav;
    }

}