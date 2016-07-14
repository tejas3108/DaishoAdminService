package com.daisho.rest.adminService;

import java.sql.*;



public class jobSeekerOperations {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/daisho";

	static final String USER = "root";
	static final String PASS = "";
	
	ResultSet rs = null;
	Connection conn = null;
	Statement stmt = null;

	public JobSeeker first_login(JobSeeker js){
		JobSeeker newJS = new JobSeeker();
		try {
	    	Class.forName("com.mysql.jdbc.Driver");
	        conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        stmt = conn.createStatement();
	        String query = "SELECT * FROM tb_job_seeker_profile_008 WHERE job_seeker_email = \'" + js.getJob_seeker_email() + "\';";
	        System.out.println(query);
	        rs = stmt.executeQuery(query);
	        if(rs.next())
	        {
	        	//if user already exists
	        	newJS.setJob_seeker_profile_id(rs.getInt("job_seeker_profile_id"));
		    	newJS.setJob_seeker_already_reg(true);
		    }
	        else {
	        	String s = "INSERT INTO tb_job_seeker_profile_008 (job_seeker_name, job_seeker_email) VALUES (\'"+ js.getJob_seeker_name() + "\', \'" + js.getJob_seeker_email() + "\');";
	            stmt.executeUpdate(s);
	            rs = stmt.executeQuery("SELECT MAX(job_seeker_profile_id) as ID FROM tb_job_seeker_profile_008;");
	            rs.next();
	            newJS.setJob_seeker_profile_id(rs.getInt("ID"));
	            newJS.setJob_seeker_already_reg(false);
	        }
			}
	    	
	    
	    	catch (Exception e) {
	    		System.out.println("Inside catch");
	    		System.out.println(e.getMessage() + " " + e.getCause());
	    	}
	    	
	    	finally{
	    		try{
	    		stmt.close();
	    		conn.close();
	    		}catch (Exception e){}
	    	}
		return newJS;
	}
	
	public JobSeeker insertDetails(JobSeeker js){
		JobSeeker newJS = new JobSeeker();
		try {
	    	Class.forName("com.mysql.jdbc.Driver");
	        conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        stmt = conn.createStatement();
	        String query = "UPDATE tb_job_seeker_profile_008 SET "
	        		+ "job_seeker_last_company_worked_name = \'" + js.getJob_seeker_last_company_worked_name() + "\'"
	        		+ ", job_seeker_title_in_last_company = \'" + js.getJob_seeker_title_in_last_company() + "\'"
	        		+ ", job_seeker_last_company_joining_date = \'" + js.getJob_seeker_last_company_joining_date() + "\'"
	        		+ ", job_seeker_phone_number_primary = " + js.getJob_seeker_phone_number_primary() 
	        		+ ", job_seeker_phone_number_secondary = " + js.getJob_seeker_phone_number_secondary()
	        		+ ", job_seeker_curr_ctc = " + js.getJob_seeker_curr_ctc()
	        		+ ", job_seeker_expec_ctc = " + js.getJob_seeker_expec_ctc()
	        		+ ", job_seeker_total_years_of_exp = " + js.getJob_seeker_total_years_of_exp()
	        		+ ", job_seeker_best_time_to_contact = \'" + js.getJob_seeker_best_time_to_contact() + "\'"
	        		+ ", job_seeker_best_mode_of_contact = \'" + js.getJob_seeker_best_mode_of_contact() + "\'"
	        		+ ", job_seeker_highest_qualification = \'" + js.getJob_seeker_highest_qualification() + "\'"
	        		+ ", job_seeker_year_of_passing = \'" + js.getJob_seeker_year_of_passing() + "\'"
	        		+ ", job_seeker_curr_location = \'" + js.getJob_seeker_curr_location() + "\'"
	        		+ ", job_seeker_prefered_location = \'" + js.getJob_seeker_prefered_location() + "\'"
	        		+ " WHERE job_seeker_email = \'" + js.getJob_seeker_email() + "\';";
	        				
	        System.out.println(query);
	        if(stmt.executeUpdate(query) == 1)
	        	newJS.setInsert_status("true");
	        else
	        	newJS.setInsert_status("false");
	       
		}
		catch (Exception e) {
    		System.out.println("Inside catch");
    		System.out.println(e.getMessage() + " " + e.getCause());
    		newJS.setInsert_status("false");
    	}
    	
    	finally{
    		try{
    		stmt.close();
    		conn.close();
    		}catch (Exception e){}
    	}
		return newJS;
	}

}
