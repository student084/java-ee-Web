package com.amaker.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.amaker.bean.User;
import com.amaker.dao.UserDao;
import com.amaker.util.DBUtil;

public class UserDaoImp implements UserDao{
	
	public boolean register(User user) {
		String login = user.getLogin();
		String password = user.getPassWord();
		
		DBUtil util = new DBUtil();
		Connection conn = util.openConnection();
		
		String sql = "insert into usertable(login, password) values(?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getLogin());
			pstmt.setString(2, user.getPassWord());
			
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		
		return false;
	}

	public boolean check(User user) {
		
		String login = user.getLogin();
		String password = user.getPassWord();
		
		DBUtil util = new DBUtil();
		Connection conn = util.openConnection();
		
		String sql = "select * from usertable where login = ? and password = ?";
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, login);
			pst.setString(2, password);
			
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.closeConnection(conn);
		}
		
		
		
		return false;
	}

	public List search(String name, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
