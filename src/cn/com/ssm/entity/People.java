package cn.com.ssm.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class People {

	private Integer id;
	private String name;
	private Integer age;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;
	private String address;
	private String hobby;
	private String phone;
	private Integer sex;
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "People [id=" + id + ", name=" + name + ", age=" + age + ", birthday=" + birthday + ", address="
				+ address + ", hobby=" + hobby + ", phone=" + phone + ", sex=" + sex + "]";
	}

	
	
	
}
