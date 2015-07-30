package com.rongrong.service;

import com.rongrong.model.ProjectTb;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ProjectManagerServiceTest {

    @Autowired
    private ProjectManagerService projectManagerService;

    @Test
    public void testPersonalProjectList() throws Exception {
        ProjectTb project = new ProjectTb();
        project.setUserId(3);
        project.setCurrentPage(1);
        List<ProjectTb> list = projectManagerService.personalProjectList(project);
        System.out.println(list);

        for (ProjectTb p : list) {
            System.out.println(p);
        }
    }
}