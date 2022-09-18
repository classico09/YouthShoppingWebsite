package cn.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.Controller.User;

public class MessDao {
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public MessDao(Connection con) {
		super();
		this.con = con;
	}
	
	public boolean userMess(String name, String email, String mess, String phone) {
		User user = null;
		boolean flag = false;
		try {
			query = "insert into Message(Email, FullName, Message, Mobile) values(?, ?, ?, ?)";
			pst = this.con.prepareStatement(query);
			
			pst.setString(1, email);
			pst.setString(2, name);
			pst.setString(3, mess);
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
