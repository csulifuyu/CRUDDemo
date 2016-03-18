package com.demo.student.util;

public interface SqlInterface {
	
	//查询所有的学生列表
	public static String QUERY_STUDENT_ALL = "SELECT stuId,stuName,stuBirthday FROM student";
	
	//根据stuId查询某个学生信息
	public static String QUERY_STUDENT_ONE = "SELECT * FROM student WHERE stuId = ? ";
	
	//新增一条学生信息
	public static String ADD_STUDENT = "INSERT INTO student(stuName,stuBirthday,stuSex,stuMobile,stuCity) VALUES(?,?,?,?,?) ";
	
	//根据stuId修改某个学生的信息
	public static String UPDATE_STUDENT = "UPDATE student SET stuName = ?,stuBirthday = ?,stuSex = ?,stuMobile = ?,stuCity= ? WHERE stuId = ?";
	
	//根据stuId删除某个学生的记录信息
	public static String DELETE_STUDENT = "DELETE FROM  student  WHERE stuId = ?";
	

}
