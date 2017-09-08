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
		String table ="";
		while(srs.next()){
			table+= "<tr>"
				       + "<td>"+srs.getString(1)+"</td>"
				       + "<td>"+srs.getString(2)+"</td>"
				       + "<td>"+srs.getString(3)+"</td>"
				       + "<td>"+srs.getString(4)+"</td>"
				    +"</tr>";
		}
		return table;
	}
	public String CreateJspTable(String role){
		String administrator= "administrator";
		String moderator = "moderator";
		String mask = "**********";
		SqlRowSet srs = _jdbcTemplate.queryForRowSet("SELECT * FROM user");
		String table ="";
		if(role.equals(administrator)){
			while(srs.next()){
				table+= "<tr>"
					       + "<td>"+srs.getString(1)+"</td>"
					       + "<td>"+srs.getString(2)+"</td>"
					       + "<td>"+srs.getString(3)+"</td>"
					       + "<td>"+srs.getString(4)+"</td>"
					    +"</tr>";
			}
		}else if(role.equals(moderator)){
			while(srs.next()){
				if(srs.getString(2).equals(administrator)){
			
				table+= "<tr>"
					       + "<td>"+srs.getString(1)+"</td>"
					       + "<td>"+srs.getString(2)+"</td>"
					       + "<td>"+srs.getString(3)+"</td>"
					       + "<td>"+mask+"</td>"
					    +"</tr>";
				}else{
					table+= "<tr>"
						       + "<td>"+srs.getString(1)+"</td>"
						       + "<td>"+srs.getString(2)+"</td>"
						       + "<td>"+srs.getString(3)+"</td>"
						       + "<td>"+srs.getString(4)+"</td>"
						    +"</tr>";
				}
			}
		}else{
			while(srs.next()){
				if(srs.getString(2).equals(administrator)||srs.getString(2).equals(moderator)){
			
				table+= "<tr>"
					       + "<td>"+srs.getString(1)+"</td>"
					       + "<td>"+srs.getString(2)+"</td>"
					       + "<td>"+srs.getString(3)+"</td>"
					       + "<td>"+mask+"</td>"
					    +"</tr>";
				}else{
					table+= "<tr>"
						       + "<td>"+srs.getString(1)+"</td>"
						       + "<td>"+srs.getString(2)+"</td>"
						       + "<td>"+srs.getString(3)+"</td>"
						       + "<td>"+srs.getString(4)+"</td>"
						    +"</tr>";
				}
			}
		}
		return table;
	}
	
}
