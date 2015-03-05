package com.samples.ws;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("sample")
public class SampleService {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getComments(){
		return "My Comments...";
	}
	
	@GET
	@Path("message")
	@Produces(MediaType.APPLICATION_JSON)
	public Welcome getMessage(){
		Welcome wel =new Welcome();
		wel.setAddress("dfdf");
		wel.setName("david");
		try{
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/SampleJndi");
		Connection conn = ds.getConnection();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return wel;
	}
}
