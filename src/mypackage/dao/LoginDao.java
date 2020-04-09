package mypackage.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mypackage.model.Login;

public class LoginDao {
	public static int login(Login login) {
		int result = -1;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/systemgestion?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT","root", "960523");
			String sql = "select count(*) from login where login = ? and password = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, login.getLogin());
			pstmt.setString(2, login.getPassword());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
				System.out.println(result);
			}
			if(result > 0) {
				return 1;
			}else {
				return 0;
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			return -1;
		}catch(SQLException e) {
			e.printStackTrace();
			return -1;
		}
		catch(Exception e) {
			e.printStackTrace();
			return -1;
		}finally{
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)rs.close();
				if(connection!=null)rs.close();
			}catch(SQLException e){
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
