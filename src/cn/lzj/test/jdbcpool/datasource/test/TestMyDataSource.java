package cn.lzj.test.jdbcpool.datasource.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import cn.lzj.test.jdbc.JDBCUtils_V2;
import cn.lzj.test.jdbcpool.datasource.MyDataSource;

public class TestMyDataSource {

	@Test
	public void testAdd() {
		Connection connection = null;
		PreparedStatement pstmt = null;
		MyDataSource dataSource = new MyDataSource();
		
		try {
			connection = dataSource.getConnection();
			String sql = "insert into tbl_user values(null,?,?)";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, "dfjak");
			pstmt.setString(2, "1234555");
			int rows = pstmt.executeUpdate();
			if (rows > 0) {
				System.out.println("添加成功");
			} else {
				System.out.println("添加失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils_V2.realease(connection, pstmt, null);
		}
		
	}
}
