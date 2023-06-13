package partha.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ProjectInfo implements Serializable
{
	@EmbeddedId
	private ProjectId id; 
	
	public ProjectId getId() {
		return id;
	}


	public void setId(ProjectId id) {
		this.id = id;
	}


	private Integer deptno;
	private String pname;
	private String projName;
	
	
	public Integer getDeptno() {
		return deptno;
	}


	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}


	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	public String getProjName() {
		return projName;
	}


	public void setProjName(String projName) {
		this.projName = projName;
	}


	@Override
	public String toString() {
		return "ProjectInfo [id=" + id + ", deptno=" + deptno + ", pname=" + pname + ", projName=" + projName + "]";
	}

 

	
	
	
	
	
	
	
	
}
