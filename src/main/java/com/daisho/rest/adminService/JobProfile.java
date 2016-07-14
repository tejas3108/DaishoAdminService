package com.daisho.rest.adminService;

public class JobProfile {
	
	private int job_profile_id;
	private String job_title;
	private String job_company_name;
	private String job_description;
	private String job_location_name;
	private String job_location_lat;
	private String job_location_long;
	private int job_exp_required;
	private String insert_status;
	
	public String getInsert_status() {
		return insert_status;
	}
	public void setInsert_status(String insert_status) {
		this.insert_status = insert_status;
	}
	public int getJob_profile_id() {
		return job_profile_id;
	}
	public void setJob_profile_id(int job_profile_id) {
		this.job_profile_id = job_profile_id;
	}
	public String getJob_title() {
		return job_title;
	}
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
	public String getJob_company_name() {
		return job_company_name;
	}
	public void setJob_company_name(String job_company_name) {
		this.job_company_name = job_company_name;
	}
	public String getJob_description() {
		return job_description;
	}
	public void setJob_description(String job_description) {
		this.job_description = job_description;
	}
	public String getJob_location_name() {
		return job_location_name;
	}
	public void setJob_location_name(String job_location_name) {
		this.job_location_name = job_location_name;
	}
	public String getJob_location_lat() {
		return job_location_lat;
	}
	public void setJob_location_lat(String job_location_lat) {
		this.job_location_lat = job_location_lat;
	}
	public String getJob_location_long() {
		return job_location_long;
	}
	public void setJob_location_long(String job_location_long) {
		this.job_location_long = job_location_long;
	}
	public int getJob_exp_required() {
		return job_exp_required;
	}
	public void setJob_exp_required(int job_exp_required) {
		this.job_exp_required = job_exp_required;
	}

}
