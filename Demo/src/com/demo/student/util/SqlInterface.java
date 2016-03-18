package com.demo.student.util;

public interface SqlInterface {
	
	//��ѯ���е�ѧ���б�
	public static String QUERY_STUDENT_ALL = "SELECT stuId,stuName,stuBirthday FROM student";
	
	//����stuId��ѯĳ��ѧ����Ϣ
	public static String QUERY_STUDENT_ONE = "SELECT * FROM student WHERE stuId = ? ";
	
	//����һ��ѧ����Ϣ
	public static String ADD_STUDENT = "INSERT INTO student(stuName,stuBirthday,stuSex,stuMobile,stuCity) VALUES(?,?,?,?,?) ";
	
	//����stuId�޸�ĳ��ѧ������Ϣ
	public static String UPDATE_STUDENT = "UPDATE student SET stuName = ?,stuBirthday = ?,stuSex = ?,stuMobile = ?,stuCity= ? WHERE stuId = ?";
	
	//����stuIdɾ��ĳ��ѧ���ļ�¼��Ϣ
	public static String DELETE_STUDENT = "DELETE FROM  student  WHERE stuId = ?";
	

}
