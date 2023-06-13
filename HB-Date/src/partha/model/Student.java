package partha.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

 
@Entity
public class Student implements Serializable 
{
	private static final long serialVersionUID = 1L;

	public Student()
	{
		System.out.println("Hibernate uses zero argument constructor internally.");
	}
	 
	@Id
 	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private LocalDate dob;
	private LocalDateTime dom;
	private LocalTime doj;
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", dob=" + dob + ", dom=" + dom + ", doj=" + doj + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public LocalDateTime getDom() {
		return dom;
	}
	public void setDom(LocalDateTime dom) {
		this.dom = dom;
	}
	public LocalTime getDoj() {
		return doj;
	}
	public void setDoj(LocalTime doj) {
		this.doj = doj;
	}
	
	
	
	
}
