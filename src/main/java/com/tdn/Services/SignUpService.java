package com.tdn.Services;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {
	@Autowired
	private DataSource _datasource;
	private JdbcTemplate _jdbcTemplate;
	private int _numberCount=0;
	private int _alphabetLowerCaseCount=0;
	private int _alphabetUperCaseCount=0;
	private int _specialCharCount=0;
	private int _spaceCount=0;
	private int _consecutiveSpaceCount=0;
	private int _totalChar = 0;
	private String _userNameError ="";
	private String _passwordError ="";
	private String _confirmPasswordError ="";
	
	@Autowired
	public void setJdbcDatasource() {
		this._jdbcTemplate = new JdbcTemplate(_datasource);
	}
	
	public void countCharType(String string){
		char[] charArray = string.toCharArray();
		for( int i =0; i<charArray.length; i++){
			if(Character.isDigit(charArray[i])){
				_numberCount++;
				
			}else if(Character.isLowerCase(charArray[i])){
				_alphabetLowerCaseCount++;
				
			}else if(Character.isUpperCase(charArray[i])){
				_alphabetUperCaseCount++;
				
			}else if(Character.isSpaceChar(charArray[i])){
				_spaceCount++;
				if(Character.isSpaceChar(charArray[i-1])){
					_consecutiveSpaceCount++;
				}
			}else{
				_specialCharCount++;
				
			}
		}
		_totalChar = _numberCount+_alphabetLowerCaseCount+ _alphabetUperCaseCount +_specialCharCount;
	}
	public void setCharCountToDefault(){
		_numberCount =0;
		_alphabetLowerCaseCount =0;
		_alphabetUperCaseCount =0;
		_specialCharCount=0;
		_spaceCount=0;
		_consecutiveSpaceCount=0;
	}
	public void resetErrorMessage(){
		_userNameError = "";
		_passwordError = "";
		_confirmPasswordError = "";
		
	}
	public boolean validateUserNameInput(String userName){
		countCharType(userName);
		String qr = String.format("SELECT * FROM `user` WHERE `username`=\"%s\"", userName);
		SqlRowSet srs = _jdbcTemplate.queryForRowSet(qr);
		if(srs.next()){
			_userNameError="The user name you have chosen is already used, please choose other user name";
			
			return false;
		}else if(_totalChar<4||_totalChar>24||_specialCharCount>0||_consecutiveSpaceCount>0){
			_userNameError ="User name must be more than 3 and less than 25 character length, must contain only letters or digits, "
					+ "and must not contain more than two space between two consecutive characters";
			setCharCountToDefault();
			return false;
		}
		setCharCountToDefault();
		return true;
	}
	
	public boolean validatePasswordInput(String password){
		countCharType(password);
		if(_totalChar<8||_totalChar>24||_specialCharCount>0||_spaceCount>0||_alphabetLowerCaseCount==0||_numberCount==0||_alphabetUperCaseCount==0){
			
			_passwordError="Password must be more than 8 and less than 25 character length, must contain at least one upper case letter, "
			+ "one lower case letter, one digit, no space, and no special character";
			setCharCountToDefault();
			return false;
		}
		setCharCountToDefault();
		return true;
	}
	
	public boolean validateConfirmPassword(String password, String confirmPassword){
		if(!confirmPassword.equals(password)){
			_confirmPasswordError ="The confirmed password does not match the password your entered!";
			return false;
		}
		return true;
	}
	
	public void registerNewUser(String userName, String password){
		String qr = String.format("INSERT INTO user(role, username, password) VALUE(\"user\",\"%s\", \"%s\")", userName, password);
		_jdbcTemplate.execute(qr);
	}

	public String get_userNameError() {
		return _userNameError;
	}

	public String get_passwordError() {
		return _passwordError;
	}

	public String get_confirmPasswordError() {
		return _confirmPasswordError;
	}
	
	public void countCheck(){
		System.out.println("Count Check: \n" +"number: "+_numberCount+"\n"+"uperCase: "+_alphabetUperCaseCount +"\n"+"lowerCase: "+ _alphabetLowerCaseCount +"\n"+
				"space: "+ _spaceCount+"\n"+"consecutiveSpace: " +_consecutiveSpaceCount +"\n"+ "special characters: "+_specialCharCount+"\n"+
				"total char: "+_totalChar);
	}
	
}
