package com.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import oracle.jdbc.driver.OracleDriver;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.lang.*;
import java.sql.Driver;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.training.Mem;

import oracle.jdbc.driver.OracleDriver;

public class Delete extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		Long bkid = Long.parseLong(req.getParameter("bookid"));
	//	int bkid = Integer.parseInt(req.getParameter("bookid"));
		System.out.println(bkid);
		
		
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();


		try {
			
			
			out.println("<html><body><form method=\"POST\" action=\"DeleteDisplay\">");
	    	out.println("<div align=\"center\"><br><br><br><br><br><br><br><br><br><br><br>");
	    	out.println("<table cellpadding=2 cellspacing=1 border=\"1\" bgcolor=\"blue\">");

	    	out.println("<th bgcolor=\"blue\" colspan=2><font size=5>Do U Want to DELETE?");

	    	
	    	out.println("<center><tr bgcolor=\"white\"><td valign=top>");
	    	out.println("<input type=\"hidden\" name=\"bookid\" value="+bkid+">");
	    	out.println("</br>");
	    	out.println("<div align=\"center\">YES:<input type=\"radio\" name=\"des\" value=\"yes\">");
	    	out.println("</br>");
	    	out.println("</br>");
	    	out.println("<div align=\"center\">NO:<input type=\"radio\" name=\"des\" value=\"no\">");
	    	out.println("</br>");
	    	out.println("</br>");
	    	
	    	out.println();
	    	out.println("<BR>");
	    	out.println("</BR>");
	    	out.println("<input type=\"submit\"  value=\"Submit\">");
	    	out.println();
	    	out.println("<BR>");
	    	out.println("</BR>");
	    	out.println();
	    	out.println("<BR>");

	    	out.println("</BR></form></body></html>");


			

		} catch (Exception ex) {
			System.out.println("Unknown exception.");

		} finally {

		}
	}

	private static SessionFactory getSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			return new Configuration().configure("hibernate-example1.cfg.xml")
					.buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

}
