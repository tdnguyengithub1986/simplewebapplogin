package com.tdn.Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import org.springframework.stereotype.Service;

import com.tdn.DAO.DBInfo;

@Service
public class LoginService {
	public boolean validate(String userName, String password){
		
		try{
			Class.forName(DBInfo.getJdbcDriver());
			Connection dbConnection = DriverManager.getConnection(DBInfo.getDbURL(), DBInfo.getRootUserName(), DBInfo.getRootPassword());
			PreparedStatement ps = dbConnection.prepareStatement("SELECT * FROM USER WHERE USERNAME=? AND PASSWORD=?");
			ps.setString(1, userName);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				return true;
			}
			
		}catch(Exception e){
			System.out.println(e);
		}
		
		return false;
	}
}
