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

public class Update extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		Long bkid = Long.parseLong(req.getParameter("bookid"));
//		int bkid = Integer.parseInt(req.getParameter("bookid"));
		System.out.println(bkid);
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();


		try {
			System.out.println("enter try");
			Session session = getSessionFactory().openSession();
			Transaction transaction = session.getTransaction();
			transaction.begin();
			
			Books bk = (Books)session.get(Books.class, new Long(bkid));
			
			String bkn=bk.getName();
	        String an=bk.getAuthor();
	        int newprice = bk.getPrice();

	        out.println("<html><body><form method=\"POST\" action=\"UpdateDisplay\">");
	        out.println("<div align=\"center\"><br><br><br><br><br><br><br><br><br><br><br>");
	        out.println("<table cellpadding=2 cellspacing=1 border=\"1\" bgcolor=\"blue\">");

	        out.println("<th bgcolor=\"blue\" colspan=2><font size=5>Udate");

	        out.println("Page</font> <br></th>");
	        out.println("<center><tr bgcolor=\"white\"><td valign=top>");
	        out.println("<input type=\"hidden\" name=\"bookid\" value="+bkid+">");
	        out.println("</br>");
	        out.println("Book Name:<input type=\"text\" name=\"bookname\" value="+bkn+">");
	        out.println("</br>");
	        out.println("</br>");
	        out.println("Author Name:<input type=\"text\" name=\"authorname\" value="+an+">");
	        out.println("</br>");
	        out.println("</br>");
	        out.println("Book Price:<input type=\"text\" name=\"bkprice\" value="+newprice+">");

	        out.println();
	        out.println("<BR>");
	        out.println("</BR>");
	        out.println("<input type=\"submit\"  value=\"Update\">");
	        out.println();
	        out.println("<BR>");
	        out.println("</BR>");
	        out.println();
	        out.println("<BR>");

	        out.println("</BR></body></html>");

		} catch (Exception ex) {
			ex.printStackTrace();
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
