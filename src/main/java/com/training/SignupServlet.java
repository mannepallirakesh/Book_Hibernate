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

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import com.training.Mem;

import oracle.jdbc.driver.OracleDriver;

public class SignupServlet extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		// SessionFactory factory =
		// (SessionFactory)getServletContext().getAttribute("sessionFactory");
		// Session session = factory.openSession();
		// Transaction transaction = session.getTransaction();
		// transaction.begin();

		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		String username = req.getParameter("username");
		String password = req.getParameter("password");

		System.out.println(username);
		System.out.println(password);

		try {
			System.out.println("enter try");
			Session session = getSessionFactory().openSession();
			Transaction transaction = session.getTransaction();
			transaction.begin();
			Mem member = new Mem();
			member.setMemName(username);
			member.setMemPass(password);

			session.save(member);
			transaction.commit();

			out.println("<HTML><HEAD><TITLE>Success</TITLE></HEAD>");
			out.println();
			out.println("<BODY>");
			out.println("Congrats! You Registered Successfully");

			out.println();
			out.println("<BR>");
			out.println("</BR>");
			out.println();
			out.println("<BR>");
			out.println("</BR>");
			out.println();
			out.println("<BR>");
			out.println("Please click here to Login!  -->   <A HREF=\""
					+ req.getContextPath()
					+ "/htmls/LoginPage.html\"><input type=\"submit\" value=\"LOGIN\" /></A>");
			out.println("</BR>");

			out.println("</BODY></HTML>");
			out.println("</BODY>");
			out.println("</HTML>");

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
