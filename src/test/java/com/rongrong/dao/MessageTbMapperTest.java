package com.rongrong.dao;

import com.rongrong.model.MessageTb;
import com.rongrong.model.UserTb;
import com.rongrong.model.constant.MESSAGE;
import com.rongrong.model.constant.PAGENUM;
import com.rongrong.model.requestview.CardView;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class MessageTbMapperTest {

    @Autowired
    private MessageTbMapper messageTbMapper;
    @Test
    public void testGetReceiveCardConditionBy() throws Exception {

        UserTb user = new UserTb();
        user.setId(2);
        user.setCurrentPage(1);

        MessageTb message = new MessageTb();
        message.setToUserId(user.getId());
        message.setType(MESSAGE.CARD.getCode());
        message.setStatus(MESSAGE.INITIALIZTIONSTATUS.getCode());
        message.setSkipNum((user.getCurrentPage() - 1) * PAGENUM.messageNum);
        message.setPageNum(PAGENUM.messageNum);


        List<CardView> cardViews = messageTbMapper.getReceiveCardConditionBy(message);

        for (CardView c : cardViews) {
            System.out.println("-------------");
            System.out.println(c);
        }
    }

    @Test
    public void testGetSendCardConditionBy() throws Exception {

    }
}