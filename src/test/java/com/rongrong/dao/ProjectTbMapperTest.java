package com.rongrong.dao;

import com.rongrong.model.ProjectTb;
import com.rongrong.model.UserTb;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ProjectTbMapperTest {

    @Autowired
    private ProjectTbMapper projectTbMapper;

    @Test
    public void testGetConditionBy() throws Exception {
        ProjectTb project = new ProjectTb();
        project.setUserId(3);
        project.setCurrentPage(2);
        System.out.println(projectTbMapper.getConditionBy(project));
    }

    @Test
    public void testPersonalRelateProjectList() throws Exception {
        UserTb userTb = new UserTb();
        userTb.setId(2);
        List<ProjectTb> list = projectTbMapper.personalRelateProjectList(userTb);
        for(ProjectTb projectTb : list){
            System.out.println(projectTb);
        }
    }
}