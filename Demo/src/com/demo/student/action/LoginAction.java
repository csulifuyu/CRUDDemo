package com.demo.student.action;

import java.util.ArrayList;
import java.util.List;

import com.demo.student.dao.StudentDao;
import com.demo.student.dao.impl.StudentDaoImpl;
import com.demo.student.vo.StudentVo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String adminAccount;
	private String adminPwd;
	private String rand;
	private String loginMessage;
	private List<StudentVo> stuList = new ArrayList<StudentVo>();
	public String LoginQuery() {	
		ActionContext actioncontext = ActionContext.getContext();
		String loginrand = null;
		loginrand = (String) actioncontext.getSession().get("loginrand");		
		if (adminAccount.equals("admin")&& adminPwd.equals("admin")) {
			if (rand.equalsIgnoreCase(loginrand)) {
				StudentDao sDao = new StudentDaoImpl();
				stuList = sDao.getAllStu();
				return "loginSuccess";

			} else {
				loginMessage = "验证码错误";
				return "loginFiled";
			   }

		} else {
			adminAccount = "";
			adminPwd = "";
			loginMessage = "用户名或密码错误";
			return "loginFiled";
		}

	}

	public String getAdminAccount() {
		return adminAccount;
	}

	public void setAdminAccount(String adminAccount) {
		this.adminAccount = adminAccount;
	}

	public String getAdminPwd() {
		return adminPwd;
	}

	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}

	public String getRand() {
		return rand;
	}

	public void setRand(String rand) {
		this.rand = rand;
	}

	public String getLoginMessage() {
		return loginMessage;
	}

	public void setLoginMessage(String loginMessage) {
		this.loginMessage = loginMessage;
	}

	public List<StudentVo> getStuList() {
		return stuList;
	}

	public void setStuList(List<StudentVo> stuList) {
		this.stuList = stuList;
	}
	
	
}
