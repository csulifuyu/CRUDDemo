package com.demo.student.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.struts2.ServletActionContext;

public class DBUtil {
	static String driver = "";
	static String url = "";
	static String userName = "";
	static String psw = "";
	
//静态代码块
	static {
		Properties pro = new Properties();
		try {
			System.out.println(ServletActionContext.getServletContext().getRealPath("/"));
			String path = ServletActionContext.getServletContext().getRealPath("/")+"WEB-INF\\classes\\";
			System.out.println(path);
			InputStream is = new FileInputStream(new File(path+"db.properties"));
			pro.load(is);
			driver = pro.getProperty("driver");
			url = pro.getProperty("url");
			userName = pro.getProperty("userName");
			psw = pro.getProperty("password");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userName, psw);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	
		return conn;
	}
	

	//关闭资源方法
	public static void close(Connection conn, Statement stmt, ResultSet res) {
		close(res);
		close(stmt);
		close(conn);
	}

	public static void close(Connection conn, Statement stmt) {
		
		close(stmt);
		close(conn);
	}

	//关闭语句
	private static void close(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			stmt = null;
		}
	}

	//关闭结果集
	private static void close(ResultSet res) {
		if (res != null) {
			try {
				res.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			res = null;
		}
	}

	//关闭数据库连接
	protected static void close(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conn = null;
	}
}
