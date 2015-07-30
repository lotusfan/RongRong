package com.rongrong.dao;

import com.rongrong.model.PrPraiseTb;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class PrPraiseTbMapperTest {

    @Autowired
    private PrPraiseTbMapper prPraiseTbMapper;

    @Test
    public void testGetBy() throws Exception {

        PrPraiseTb prPraiseTb = new PrPraiseTb();

        System.out.println(prPraiseTbMapper.getBy(prPraiseTb));

    }
}