package com.rongrong.dao.transactionmanager;


import com.rongrong.model.MessageTb;
import com.rongrong.model.UserTb;
import com.rongrong.model.constant.MESSAGE;
import com.rongrong.model.requestview.MessageView;
import com.rongrong.service.ProjectManagerService;
import com.rongrong.service.UserManagerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@WebAppConfiguration

public class MessageTbTransactionManagerTest {


    @Autowired
    private UserManagerService userManagerService;

    @Test
    public void testGetMessageBoxConditionBy() throws Exception {
        UserTb userTb = new UserTb();
        userTb.setId(3);
        userTb.setCurrentPage(1);
        List<MessageView> list = userManagerService.getMessageBoxListView(userTb, MESSAGE.HAVEREADEDSTATUS.getCode());

        for (MessageView messageView : list) {
            System.out.println(messageView);
        }
    }
    @Test
    public void testClearMessageBox() throws Exception {
        UserTb userTb = new UserTb();
        userTb.setId(3);
        userManagerService.clearMessageBox(userTb);
    }
}