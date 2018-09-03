package com.questions.test;

import javax.servlet.http.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.Subject;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.questions.dbInitializer.DbManager;
import com.questions.questionsUtil.SubjectUtil;
import com.questions.test.bean.SubjectBean;
import com.questions.test.bean.Track;

@Path("subnames")
public class JSONService {
	@Context
	public ServletContext context;
	@GET
	@Path("/subjects")
	@Produces(MediaType.APPLICATION_JSON)
	public SubjectBean getTrackInJSON(@QueryParam("dept")String dept,@QueryParam("sem")String sem) throws SQLException {
		SubjectBean sb = new SubjectBean();
		DbManager db = (DbManager) context.getAttribute("db");
		sb=new SubjectUtil().getSubjectNames(db,dept,sem);
		return sb;
	}
}
