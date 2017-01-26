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

public class UpdateDisplay extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		Long bkid = Long.parseLong(req.getParameter("bookid"));
	//	int bkid = Integer.parseInt(req.getParameter("bookid"));
		System.out.println(bkid);
		
		String bookname = req.getParameter("bookname");
		System.out.println(bookname);
		
		String authorname = req.getParameter("authorname");
		System.out.println(authorname);
		
		int bkprice = Integer.parseInt(req.getParameter("bkprice"));
		System.out.println(bkprice);
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();


		try {
			System.out.println("enter try");
			Session session = getSessionFactory().openSession();
			Transaction transaction = session.getTransaction();
			transaction.begin();
			
			Books bk = (Books)session.get(Books.class, new Long(bkid));
			bk.setName(bookname);
			bk.setAuthor(authorname);
			bk.setPrice(bkprice);
			session.update(bk);
			
			transaction.commit();
			out.println("Your Book is Updated");
			out.println("Click here for homepage<br></br><A HREF=\"" + req.getContextPath() +"/Home\">HOME</A>");

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
