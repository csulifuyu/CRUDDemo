package com.demo.student.vo;

public class StudentVo {

	private int stuId;
	private String stuName;
	private String stuSex;
	private String stuBirthday;
	private String stuMobile;
	private String stuCity;
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuSex() {
		return stuSex;
	}
	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}
	public String getStuBirthday() {
		return stuBirthday;
	}
	public void setStuBirthday(String stuBirthday) {
		this.stuBirthday = stuBirthday;
	}
	public String getStuMobile() {
		return stuMobile;
	}
	public void setStuMobile(String stuMobile) {
		this.stuMobile = stuMobile;
	}
	public String getStuCity() {
		return stuCity;
	}
	public void setStuCity(String stuCity) {
		this.stuCity = stuCity;
	}
	@Override
	public String toString() {
		return "StudentVo [stuId=" + stuId + ", stuName=" + stuName
				+ ", stuSex=" + stuSex + ", stuBirthday=" + stuBirthday
				+ ", stuMobile=" + stuMobile + ", stuCity=" + stuCity + "]";
	}
	
	
}
