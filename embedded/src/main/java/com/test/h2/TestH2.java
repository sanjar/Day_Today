package com.test.h2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class TestH2 {

	public static void main(String[] args) {
		try {
			Class.forName("org.h2.Driver");
			Connection con = DriverManager.getConnection("jdbc:h2:C:\\Users\\msaniar/test2;;MV_STORE=FALSE;MVCC=FALSE",
					"test", "");

			/*
			 * By default, the MV_STORE option is enabled, so it is using the
			 * new MVStore storage. The MVCC setting is by default set to the
			 * same values as the MV_STORE setting, so it is also enabled by
			 * default. For testing, both settings can be disabled by appending
			 * ";MV_STORE=FALSE" and/or ";MVCC=FALSE" to the database URL.
			 * 
			 * if you dont provide these, it will generate test2.mv.db file
			 */
			Statement stmt = con.createStatement();
			// stmt.executeUpdate( "DROP TABLE user" );
			stmt.executeUpdate("CREATE TABLE user ( user_id varchar(50) , user_name varchar(50))");
			stmt.executeUpdate("INSERT INTO user ( user_id , user_name ) VALUES ( 'emp1','sadique' )");
			stmt.executeUpdate("INSERT INTO user ( user_id , user_name ) VALUES ( 'emp2', 'sanjar' )");

			ResultSet rs = stmt.executeQuery("SELECT * FROM user");
			while (rs.next()) {
				ResultSetMetaData md = rs.getMetaData();
				int count = md.getColumnCount();
				for(int i=1 ;i<=count;i++){
					System.out.print(rs.getString(md.getColumnName(i)) +"     " );
				}
				
				System.out.println();
			}
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
