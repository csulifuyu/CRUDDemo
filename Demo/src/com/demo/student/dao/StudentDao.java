package com.demo.student.dao;



import java.util.List;

import com.demo.student.vo.StudentVo;

public interface StudentDao {
	
	//得到学生列表
	public  List<StudentVo> getAllStu();
	
	//得到某个学生的信息
	public StudentVo getStu(int id);
	
	//更新某个学生的信息
	public boolean updateInfo(StudentVo vo);
	
	//新增一条学生记录
	public boolean addStu(StudentVo vo);
	
	//删除一条学生记录
	public boolean deleteStu(int id);

}
