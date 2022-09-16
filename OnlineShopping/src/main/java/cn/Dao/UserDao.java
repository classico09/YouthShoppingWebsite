package cn.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.Controller.User;

public class UserDao {
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public UserDao(Connection con) {
		this.con = con;
	}
	//login
	public User userLogin(String email, String pass) {
		User user = null;
		try {
			query = "select * from Account where Email=? and Password=?";
			pst = this.con.prepareStatement(query);
			pst.setString(1, email);
			pst.setString(2, pass);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("AccountID"));
				user.setEmail(rs.getString("Email"));
				user.setName(rs.getString("FullName"));
				user.setPhone(rs.getString("Mobile"));	
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return user;
	}
	//register
	public boolean userRegister(String name, String email, String pass, String phone) {
		User user = null;
		boolean flag = false;
		try {
			query = "insert into Account(Email, FullName, Password, Mobile) values(?, ?, ?, ?)";
			pst = this.con.prepareStatement(query);
			
			pst.setString(1, email);
			pst.setString(2, name);
			pst.setString(3, pass);
			pst.setString(4, phone);
			
			int count = pst.executeUpdate();
			
			if(count != 0) {
				flag = true;
			}

			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return flag;
	}
	
}
