package com.rongrong.dao;

import com.rongrong.model.PrCommentTb;
import com.rongrong.model.ProjectTb;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class PrCommentTbMapperTest {

    @Autowired
    private PrCommentTbMapper prCommentTbMapper;

    @Test
    public void testGetBy() throws Exception {
        PrCommentTb prCommentTb = new PrCommentTb();
        prCommentTb.setProjectId(1);
        for (PrCommentTb tb : prCommentTbMapper.getBy(prCommentTb)) {
            System.out.println(tb);
        }
    }
}