package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class T1 {

	public static void main(String[] args) throws SQLException {
		long start = System.currentTimeMillis();
		Connection conn = null;
		conn = DBConnection.getConnection();
		for (int i = 1; i <= 1000000; i++) {
			Employee e = new Employee("ename" + i, "eid" + i, "email" + i, "dept" + i, "address" + i);
			boolean isInsert = insertData(e, conn);
			System.out.println(" Rows " + i + " inserted. " + isInsert);
		}
		conn.close();
		long end = System.currentTimeMillis();
		System.out.println("Total Time Taken " + TimeUnit.MILLISECONDS.toSeconds(end-start));
	}

	private static boolean insertData(Employee e1, Connection conn) throws SQLException {
		PreparedStatement ps = null;
		String sql = "insert into emp2(ename,eid,email,dept,address) values(?,?,?,?,?)";
		ps = conn.prepareStatement(sql);
		ps.setString(1, e1.getName());
		ps.setString(2, e1.getEid());
		ps.setString(3, e1.getEmail());
		ps.setString(4, e1.getDept());
		ps.setString(5, e1.getAddress());
		int rs = ps.executeUpdate();
		ps.close();
		return rs > 0;
	}

}
