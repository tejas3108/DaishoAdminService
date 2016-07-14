package com.daisho.rest.adminService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.daisho.rest.adminService.JobSeeker;


@Path("/daisho")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class JobSeekerService {
	
	//first screen
	@POST
	@Path("/job_seeker/first_check")
	public JobSeeker checkUser(JobSeeker js){
		return new jobSeekerOperations().first_login(js);
		
	}
	
	//third till fifth screen
	@PUT
	@Path("job_seeker/insert_details")
	public JobSeeker insertDetails(JobSeeker js){
		return new jobSeekerOperations().insertDetails(js);
		
	}
	//seventh screen
		@POST
		@Path("job_profile/new_job")
		public JobProfile new_job(JobProfile jp){
			return new jobProfileOperations().new_job(jp);
		}
}
