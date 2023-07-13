package com.pm.projectManagement.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long projectId;
	private String projectName;
	private String projectDescription;
	private String projectStartDate;
	private String projectEndDate;
	
	@OneToMany(mappedBy = "project",cascade = CascadeType.ALL)
	private List<Task> taskList=new ArrayList<>();
	
	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public String getProjectStartDate() {
		return projectStartDate;
	}

	public void setProjectStartDate(String projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	public String getProjectEndDate() {
		return projectEndDate;
	}

	public void setProjectEndDate(String projectEndDate) {
		this.projectEndDate = projectEndDate;
	}

	public Project(long projectId, String projectName, String projectDescription, String projectStartDate,
			String projectEndDate) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.projectStartDate = projectStartDate;
		this.projectEndDate = projectEndDate;
	}

	public Project() {
		super();
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", projectDescription="
				+ projectDescription + ", projectStartDate=" + projectStartDate + ", projectEndDate=" + projectEndDate
				+ "]";
	}

}
