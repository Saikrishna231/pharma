package com.app.serviceimpl;


	

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

import com.app.dbutil.DBUtil;
import com.app.service.UserService;

	public class UserServiceImpl implements UserService {
	    int flag = 0;
	    Connection connection;
	    public UserServiceImpl() throws SQLException {
	        connection = DBUtil.getConnection();
	    }
	    @Override
	    public int loginValidation(String username, String password) {
	        try {
	            PreparedStatement statement = connection.prepareStatement("SELECT * FROM APPUSERS WHERE username= '"+username+"'");
	             ResultSet rs = statement.executeQuery();
	             while (rs.next()){
	                 if(rs.getString(4).equals(username) && rs.getString(5).equals(password)){
	                     flag = 1;
	                 }
	                 else {
	                     System.out.println("invalid user or password");
	                     flag = 0;
	                 }
	             }
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return flag;
	    }
	}


