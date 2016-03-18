package com.demo.student.action;

import java.util.ArrayList;
import java.util.List;

import com.demo.student.dao.StudentDao;
import com.demo.student.dao.impl.StudentDaoImpl;
import com.demo.student.vo.StudentVo;
import com.opensymphony.xwork2.ActionSupport;

public class StudentAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	private String stuId;
	private List<StudentVo> stuList = new ArrayList<StudentVo>();	
	private StudentVo studentVo;
	private StudentVo newStudent;
	private String stuSex;
	
	//删除学生记录
	public String deleteStu(){
		StudentDao rd = new StudentDaoImpl();
		boolean res = false;
		res = rd.deleteStu(Integer.parseInt(stuId));
		if(res){
			stuList  = rd.getAllStu();
			return "deleteSuccess";
		}
		return "error";
	}
	
	//跳转到添加记录页面
	public String goAdd(){
		return "goAdd";
		
	}
	
	//添加一条记录
	public String addStu(){
		System.out.println(newStudent);
		boolean res = false;
		StudentDao sDao = new StudentDaoImpl();
		
		res = sDao.addStu(newStudent);
		if (res) {		
		   stuList  = sDao.getAllStu();
			return "addSuccess";
		}
		return "error";
	}
	
	//显示一条记录信息
	public String showStu(){
		StudentDao sd = new StudentDaoImpl();
		studentVo = sd.getStu(Integer.parseInt(stuId));	
		
		if(studentVo.getStuSex().equals("男")){
			studentVo.setStuSex("man");
		}
		else{
			studentVo.setStuSex("woman");
		}
		stuSex = studentVo.getStuSex();
		return "showSuccess";
	}
	
	//更新学生信息
	public String updateStu(){
		
		boolean res = false;
		StudentDao sDao = new StudentDaoImpl();
	
		res = sDao.updateInfo(newStudent);
		if (res) {
			 stuList  = sDao.getAllStu();
			return "updateSuccess";
		}

		return "error";
	}
	
	//返回学生列表
	public String goStuList(){
		StudentDao sDao = new StudentDaoImpl();
		stuList  = sDao.getAllStu();
		return "goList";
		
	}
	
	
	
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	
	public StudentVo getStudentVo() {
		return studentVo;
	}
	public void setStudentVo(StudentVo studentVo) {
		this.studentVo = studentVo;
	}
	public StudentVo getNewStudent() {
		return newStudent;
	}
	public void setNewStudent(StudentVo newStudent) {
		this.newStudent = newStudent;
	}
	public List<StudentVo> getStuList() {
		return stuList;
	}
	public void setStuList(List<StudentVo> stuList) {
		this.stuList = stuList;
	}
	public String getStuSex() {
		return stuSex;
	}
	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}
	
}
