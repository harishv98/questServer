package com.questions.dbInitializer;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyservletListener implements ServletContextListener{

	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		String url = "jdbc:mysql://localhost:3306/customer?autoReconnect=true&useSSL=false";
		String userName = "root";
		String password = "root";
		DbManager db = new DbManager(url, userName, password);
		sc.setAttribute("db", db);
	}

	public void contextDestroyed(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		DbManager db = (DbManager) sc.getAttribute("db");
		try {
			db.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
