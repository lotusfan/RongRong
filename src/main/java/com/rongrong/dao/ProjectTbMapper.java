package com.rongrong.dao;
import com.rongrong.model.ProjectTb;
import java.util.List;
public interface ProjectTbMapper{
	public void save(ProjectTb projectTb);
	public void update(ProjectTb projectTb);
	public List<ProjectTb> getBy(ProjectTb projectTb);
	public ProjectTb getUniqueBy(ProjectTb projectTb);
	public Integer count(ProjectTb projectTb);
	public List<ProjectTb> getConditionBy(ProjectTb projectTb);
}