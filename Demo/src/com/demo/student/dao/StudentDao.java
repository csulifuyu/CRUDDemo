package com.demo.student.dao;



import java.util.List;

import com.demo.student.vo.StudentVo;

public interface StudentDao {
	
	//�õ�ѧ���б�
	public  List<StudentVo> getAllStu();
	
	//�õ�ĳ��ѧ������Ϣ
	public StudentVo getStu(int id);
	
	//����ĳ��ѧ������Ϣ
	public boolean updateInfo(StudentVo vo);
	
	//����һ��ѧ����¼
	public boolean addStu(StudentVo vo);
	
	//ɾ��һ��ѧ����¼
	public boolean deleteStu(int id);

}
