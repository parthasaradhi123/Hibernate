package partha.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

 
@Entity
public class CustomerMobile implements Serializable 
{
	private static final long serialVersionUID = 1L;

	public CustomerMobile()
	{
		System.out.println("Hibernate uses zero argument constructor internally.");
	}
	 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cno;
	
	private String cname;
	private Long cnumber;
	private String callerTune;
	
	@Version
	private Integer versionCount;
	
	
	public Integer getCno() {
		return cno;
	}

	public void setCno(Integer cno) {
		this.cno = cno;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Long getCnumber() {
		return cnumber;
	}

	public void setCnumber(Long cnumber) {
		this.cnumber = cnumber;
	}

	public String getCallerTune() {
		return callerTune;
	}

	public void setCallerTune(String callerTune) {
		this.callerTune = callerTune;
	}

	public Integer getVersionCount() {
		return versionCount;
	}

	public void setVersionCount(Integer versionCount) {
		this.versionCount = versionCount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CustomerMobile [cno=" + cno + ", cname=" + cname + ", cnumber=" + cnumber + ", callerTune=" + callerTune
				+ ", versionCount=" + versionCount + "]";
	}

	
	
}
