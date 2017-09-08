package com.tdn.Services;

/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.tdn.Models.DBInfo;*/

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;


@Service
public class LoginService {
		
	/*public boolean validate(String userName, String password){
		
		Connection dbConnection = null;
		try{
			
			Class.forName(DBInfo.getJdbcDriver());
			dbConnection = DriverManager.getConnection(DBInfo.getDbURL(), DBInfo.getRootUserName(), DBInfo.getRootPassword());
			PreparedStatement ps = dbConnection.prepareStatement("SELECT * FROM user WHERE username=? AND password=?");
			ps.setString(1, userName);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
						
			if(rs.next()){
				return true;
			}
			rs.close();
			ps.close();
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			try{
				dbConnection.close();
			}catch(SQLException e){
				
			}
		}
		
		return false;
	}*/
	
	@Autowired
	
	private DataSource _datasource;
	private JdbcTemplate _jdbcTemplate;
	private String _loginedUserRole;
	public boolean springValidate(String userName, String password){
		String qr = String.format("SELECT * FROM `user` WHERE `username`=\"%s\" AND `password`=\"%s\"", userName, password);
		SqlRowSet srs = _jdbcTemplate.queryForRowSet(qr);
		if(srs.next()){
			_loginedUserRole=srs.getString(2);
			return true;
		}
		return false;
	}

	public DataSource get_datasource() {
		return _datasource;
	}

	@Autowired
	public void setJdbcDatasource() {
		this._jdbcTemplate = new JdbcTemplate(_datasource);
	}


	public JdbcTemplate get_jdbcTemplate() {
		return _jdbcTemplate;
	}


	public void set_jdbcTemplate(JdbcTemplate _jdbcTemplate) {
		this._jdbcTemplate = _jdbcTemplate;
	}

	public String get_loginedUserRole() {
		return _loginedUserRole;
	}
	
	
}
