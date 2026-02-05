package org.travy.appmodel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.travy.database.Database;
import org.travy.entity.Userdets;

public class Model {
	
	public List<Userdets> Userme(){
		
		List<Userdets> listusers = new ArrayList<>();
		
		Connection con = Database.Connectme();
		Statement stmt = null;
		ResultSet rs = null;
		
		
		String query = "Select * from users";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				
				listusers.add(new Userdets(rs.getInt("user_id"), rs.getString("username"), rs.getString("email")));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listusers;
		
	}
	
	public void Adduser(Userdets usenow) {
		
		Connection con = Database.Connectme();
		PreparedStatement ps = null;
		
		String username = usenow.getUsername();
		String email = usenow.getEmail();
		
		String query = "insert into users(username, email)values(?, ?)";
		
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, email);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public void updateuser(Userdets upuser) {
		
		Connection con = Database.Connectme();
		PreparedStatement ps = null;
		
		String username = upuser.getUsername();
		String email = upuser.getEmail();
		int user_id = upuser.getUser_id();
		
		String query = "update users set username = ?, email = ? where user_id = ?";
		
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, email);
			ps.setInt(3, user_id);
			
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
public void Deleteuser(int userid) {
		
		Connection con = Database.Connectme();
		PreparedStatement ps = null;
		
		
	
		
		String query = "delete from users where user_id = ?";
		
		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, userid);	
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
