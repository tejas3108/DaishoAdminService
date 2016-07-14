package com.daisho.rest.adminService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jobProfileOperations {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/daisho";

	static final String USER = "root";
	static final String PASS = "";
	
	ResultSet rs = null;
	Connection conn = null;
	Statement stmt = null;
	
	public JobProfile new_job(JobProfile jp){
		JobProfile newJP = new JobProfile();
		try{
		Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
        stmt = conn.createStatement();
        String query = "INSERT INTO tb_job_profile_009 "
        		+ "(job_title, job_company_name, job_description, job_location_name, job_location_lat, job_location_long, job_exp_required)"
				+ " VALUES (\'"+ jp.getJob_title() + "\', \'" + jp.getJob_company_name() + "\', \'" + jp.getJob_description() 
				+ "\', \'" + jp.getJob_location_name() + "\', \'" + jp.getJob_location_lat()
				+ "\', \'" + jp.getJob_location_long() + "\' ," + jp.getJob_exp_required() + ");";

        				
        System.out.println(query);
        if(stmt.executeUpdate(query) == 1)
        	newJP.setInsert_status("true");
        else
        	newJP.setInsert_status("false");
       
	}
	catch (Exception e) {
		System.out.println("Inside catch");
		System.out.println(e.getMessage() + " " + e.getCause());
		newJP.setInsert_status("false");
	}
	
	finally{
		try{
		stmt.close();
		conn.close();
		}catch (Exception e){}
	}
	return newJP;
	}

}
