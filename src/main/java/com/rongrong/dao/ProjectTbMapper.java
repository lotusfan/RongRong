package com.rongrong.dao;
import com.rongrong.model.ProjectTb;
import com.rongrong.model.UserTb;

import java.util.List;
public interface ProjectTbMapper{
	public void save(ProjectTb projectTb);
	public void update(ProjectTb projectTb);
	public List<ProjectTb> getBy(ProjectTb projectTb);
	public ProjectTb getUniqueBy(ProjectTb projectTb);
	public ProjectTb getUserIdUniqueBy(ProjectTb projectTb);
	public Integer count(ProjectTb projectTb);
	public List<ProjectTb> getConditionBy(ProjectTb projectTb);
    public List<ProjectTb> personalRelateProjectList(UserTb userTb);

}