package com.demo.student.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.demo.student.dao.StudentDao;
import com.demo.student.util.DBUtil;
import com.demo.student.util.SqlInterface;
import com.demo.student.vo.StudentVo;


public class StudentDaoImpl implements StudentDao {

	private Connection conn = null;

	public List<StudentVo> getAllStu() {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		StudentVo stuVo = null;
		List<StudentVo> stuList = new ArrayList<StudentVo>();
		try {
			pst = conn.prepareStatement(SqlInterface.QUERY_STUDENT_ALL);
			rs = pst.executeQuery();
			while (rs.next()) {

				stuVo = new StudentVo();
				stuVo.setStuId(rs.getInt("stuId"));
				stuVo.setStuName(rs.getString("stuName"));
				stuVo.setStuBirthday(rs.getString("stuBirthday"));
				stuList.add(stuVo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, pst, rs);
		}

		return stuList;

	}

	public StudentVo getStu(int id) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection();
		PreparedStatement pst=null;
		ResultSet rs = null;
		StudentVo stuVo = null;
		try {
			pst = conn.prepareStatement(SqlInterface.QUERY_STUDENT_ONE);
			pst.setInt(1,id);
			rs = pst.executeQuery();
			if(rs.next()){
				
				stuVo = new StudentVo();
				stuVo.setStuId(rs.getInt("stuId"));
				stuVo.setStuName(rs.getString("stuName"));
				stuVo.setStuBirthday(rs.getString("stuBirthday"));
				stuVo.setStuSex(rs.getString("stuSex"));
				stuVo.setStuMobile(rs.getString("stuMobile"));
				stuVo.setStuCity(rs.getString("stuCity"));
				
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, pst, rs);
		}			
		return stuVo;
	}

	public boolean updateInfo(StudentVo vo) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection();
		PreparedStatement pst=null;
		ResultSet rs = null;
		boolean flag =false;
		try {
			pst = conn.prepareStatement(SqlInterface.UPDATE_STUDENT);			
			pst.setString(1, vo.getStuName());
			pst.setString(2, vo.getStuBirthday());
			pst.setString(3, vo.getStuSex());
			pst.setString(4, vo.getStuMobile());
			pst.setString(5, vo.getStuCity());
			pst.setInt(6, vo.getStuId());
		int length = pst.executeUpdate();
			if(length>0){
				flag=true;	 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, pst, rs);
		}
			
		return flag;
	}

	public boolean addStu(StudentVo vo) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean flag = false;
		try {
			pstmt = conn.prepareStatement(SqlInterface.ADD_STUDENT);
			pstmt.setString(1,vo.getStuName());
			pstmt.setString(2,vo.getStuBirthday());
			pstmt.setString(3,vo.getStuSex());
			pstmt.setString(4,vo.getStuMobile());
			pstmt.setString(5,vo.getStuCity());			
			int length = pstmt.executeUpdate();
			if(length>0){
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, pstmt, rs);
		}
		return flag;
	}

	public boolean deleteStu(int id) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection();
		PreparedStatement pst=null;
		ResultSet rs = null;
		boolean flag =false;
		try {
			pst = conn.prepareStatement(SqlInterface.DELETE_STUDENT);			
			pst.setInt(1,id);
			System.out.println("id:"+id);
			int length = pst.executeUpdate();
			if(length>0){
				flag=true;	 
				System.out.println("delect success");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, pst, rs);
		}			
		return flag;
	}

}
