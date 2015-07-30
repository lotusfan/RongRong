package com.rongrong.service;

import com.rongrong.model.UserTb;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserManagerServiceTest {

    @Autowired
    private UserManagerService userManagerService;
    
    @Test
    public void testGetReceiveCardViews() throws Exception {
        UserTb userTb = new UserTb();
        userTb.setId(2);
        userTb.setCurrentPage(1);

        System.out.println(userManagerService.getReceiveCardViews(userTb));
    }

    @Test
    public void testSendReceiveCardViews() throws Exception {
        UserTb userTb = new UserTb();
        userTb.setId(1);
        userTb.setCurrentPage(1);

        System.out.println(userManagerService.getSendCardViews(userTb));
    }
}