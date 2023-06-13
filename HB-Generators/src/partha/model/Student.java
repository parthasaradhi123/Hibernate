package partha.model;

 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

@Entity
@DynamicInsert(value=true)
public class Student 
{
	public Student()
	{
		System.out.println("Hibernate uses zero argument constructor internally.");
	}
	
	@Id
//	@GenericGenerator(name="gen1" ,strategy="increment")
//	@GeneratedValue(generator ="gen1")
	@GenericGenerator(name="gen1",strategy="identity")
	@GeneratedValue(generator="gen1")
	private Integer id;
	private String name;
	private Integer age;
	private String address;
	
	
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
