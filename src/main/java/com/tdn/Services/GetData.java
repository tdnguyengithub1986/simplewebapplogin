package com.tdn.Services;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;


@Service
public class GetData {
	
	@Autowired
	private DataSource _dataSource;
	private JdbcTemplate _jdbcTemplate;
	
	
	@Autowired
	public void setJdbcDatasource(){
		this._jdbcTemplate = new JdbcTemplate(_dataSource);
	}
	
	public JdbcTemplate getJdbcTemplate(){
		return _jdbcTemplate;
	}
	
	public SqlRowSet getRowSetbyId(int id){
		String query = String.format("SELECT FROM user WHERE id=\"%d\"", id);
		SqlRowSet srs= _jdbcTemplate.queryForRowSet(query);
		return  srs;
	}
	
	public String CreateJspTableRow(int id){
		SqlRowSet srs = getRowSetbyId(id);
		String tr = "<tr>"
				       + "<td>"+srs.getString(1)+"</td>"
				       + "<td>"+srs.getString(2)+"</td>"
				       + "<td>"+srs.getString(3)+"</td>"
				       + "<td>"+srs.getString(4)+"</td>"
				    +"</tr>";
		return tr;
	}
	
	public String CreateJspTable(){
		SqlRowSet srs = _jdbcTemplate.queryForRowSet("SELECT * FROM user");
		String table ="<table border=\"1\" width =\"60%\" style=\"vertical-align:middle\">"
				+ "<tr>"
					+ "<td width =\"10%\">ID</td>"
					+ "<td width =\"30%\">Role</td>"
					+ "<td width =\"30%\">User Name</td>"
					+ "<td width =\"30%\">Password</td>"
				+ "</tr>";
		while(srs.next()){
			table+= "<tr>"
				       + "<td>"+srs.getString(1)+"</td>"
				       + "<td>"+srs.getString(2)+"</td>"
				       + "<td>"+srs.getString(3)+"</td>"
				       + "<td>"+srs.getString(4)+"</td>"
				    +"</tr>";
		}
		table+= "</table>";
		return table;
	}
	
}
