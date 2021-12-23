package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class C1 {
	public static void main(String[] args) throws SQLException {
		List<String[]> list = getList("emp2");
		for (int i = 0; i < list.size(); i++) {
			String s[] = list.get(i);
			for (int j = 0; j < s.length; j++) {
				System.out.print(" - " + s[j]);
			}
			System.out.println();
		}

	}

	private static List<String[]> getList(String tableName) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBConnection.getConnection();
		List<String[]> list = new ArrayList<>();
		List<String> cols = getColumns(conn, tableName);
		String sql = "select * from " + tableName;
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while (rs.next()) {
			String[] s = new String[cols.size()];
			for (int i = 0; i < cols.size(); i++) {
				s[i] = rs.getString(cols.get(i));
			}
			list.add(s);
		}
		rs.close();
		ps.close();
		conn.close();
		return list;
	}

	private static List<String> getColumns(Connection conn, String tableName) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<String> list = new ArrayList<>();
		String sql = "select * from " + tableName;
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();

		// The column count starts from 1
		for (int i = 1; i <= columnCount; i++) {
			String name = rsmd.getColumnName(i);
			list.add(name);
		}
		rs.close();
		ps.close();
		return list;
	}

}
