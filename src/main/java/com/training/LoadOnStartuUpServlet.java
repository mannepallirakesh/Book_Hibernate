package com.training;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LoadOnStartuUpServlet extends HttpServlet 
{


//	private ServletConfig serConfig = null;
	//private ServletContext serContext = null;


	public void init(ServletConfig config) throws ServletException {
//		super.init(config);
//		serConfig = config;
//		serContext = config.getServletContext();
		
		System.out.println("----LoadOnStartUp-init() method executed.....-----");
		SessionFactory sessionFactory  = new Configuration().configure("hibernate-example1.cfg.xml").buildSessionFactory();
		config.getServletContext().setAttribute("sessionFactory","sessionFactory");
	
	
	}

	public void destroy() {
		// Release the database connection.
		System.out.println("-----destroy() method executed.-----");
	}
}
