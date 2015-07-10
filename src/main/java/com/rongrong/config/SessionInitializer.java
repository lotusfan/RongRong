package com.rongrong.config;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

/**
 * Created by zhangfan on 2015/7/7.
 */

public class SessionInitializer extends AbstractHttpSessionApplicationInitializer
{
    public SessionInitializer()
    {
        super(SessionConfig.class);
    }

}