package com.fethi.jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) {
		
		String jdbcUrl="jdbc:oracle:thin:@localhost:1521:xe";
		String user="hr";
		String pass ="hr";

		try {
		Connection myconn= DriverManager.getConnection(jdbcUrl,user,pass);
		System.out.println("connection success");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
