package partha.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ProjectId implements Serializable{

	  
	private static final long serialVersionUID = 1L;
	
	private Integer pid;
	private Integer projectId;
	
		
	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getProjectId() {
		return projectId;
	}


	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	@Override
	public String toString() {
		return "ProjectId [pid=" + pid + ", projectId=" + projectId + "]";
	}
	
	
	
	
	

}
