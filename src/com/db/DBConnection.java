package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static void main(String[] args) {

	}

	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/wangxun?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC&useSSL=false";
	String user = "root";
	String password = "root";

	public Connection conn;

	public DBConnection() {

		try {
			// ��������jar��
			Class.forName(driver);   // ���䣺��ȡ�����Ϣ
			conn = (Connection) DriverManager.getConnection(url, user, password);

			// if(!conn.isClosed())
			// System.out.println("Succeeded connecting to the Database!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			this.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
