package com.rongrong.dao.transactionmanager;

import com.rongrong.dao.ProjectTbMapper;
import com.rongrong.model.ProjectTb;
import com.rongrong.model.UserTb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectTbTransactionManager {



    @Autowired
    private ProjectTbMapper projectTbMapper;


    public void saveProjectTb(ProjectTb projectTb) {

        projectTbMapper.save(projectTb);
    }

    public void saveProjectTbs(List<ProjectTb> projectTbs) {

        if (projectTbs == null) {
            return;
        }
        for (int i = 0; i < projectTbs.size(); i++) {
            projectTbMapper.save(projectTbs.get(i));
        }
    }

    public void updateProjectTb(ProjectTb projectTb) {
        projectTbMapper.update(projectTb);

    }

    public void updateProjectTbs(List<ProjectTb> projectTbs) {
        if (projectTbs == null) {
            return;
        }
        for (int i = 0; i < projectTbs.size(); i++) {
            projectTbMapper.update(projectTbs.get(i));
        }
    }

    public ProjectTb getUniqueBy(ProjectTb projectTb) {

        return projectTbMapper.getUniqueBy(projectTb);
    }

    public ProjectTb getUserIdUniqueBy(ProjectTb projectTb) {

        return projectTbMapper.getUserIdUniqueBy(projectTb);
    }

    public List<ProjectTb> getBy(ProjectTb projectTb) {

        return projectTbMapper.getBy(projectTb);
    }
    public List<ProjectTb> getConditionBy(ProjectTb projectTb) {

        return projectTbMapper.getConditionBy(projectTb);
    }

    public Integer count(ProjectTb projectTb) {

        return projectTbMapper.count(projectTb);
    }

    public List<ProjectTb> personalRelateProjectList(UserTb user) {
        return projectTbMapper.personalRelateProjectList(user);
    }


}
