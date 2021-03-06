package com.rongrong.dao;

import com.rongrong.model.PrShareTb;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class PrShareTbMapperTest {

    @Autowired
    private PrShareTbMapper prShareTbMapper;

    @Test
    public void testGetBy() throws Exception {

        PrShareTb prShareTb = new PrShareTb();

        System.out.println(prShareTbMapper.getBy(prShareTb));
    }
}