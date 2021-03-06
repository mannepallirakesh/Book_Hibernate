package com.training;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
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
import org.hibernate.criterion.Restrictions;

import com.training.Mem;

import oracle.jdbc.driver.OracleDriver;

public class LoginTest extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
//		SessionFactory factory = (SessionFactory)getServletContext().getAttribute("sessionFactory");
//		Session session = factory.openSession();
//		Transaction transaction = session.getTransaction();
//		transaction.begin();
		
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
	

		String username = req.getParameter("userName");
		String password = req.getParameter("passWord");
		
		System.out.println(username);
		System.out.println(password);
		
		
	
    
	try
	{
		System.out.println("enter try");
	
		
			Criteria criteria = session.createCriteria(Mem.class);
			criteria.add(Restrictions.eq("memName",username ));
			criteria.add(Restrictions.eq("memPass", password));
			List result = criteria.list();
            
            if(result.size() >= 1)
            {
			Iterator it = result.iterator();
   			Mem member = (Mem) it.next();
			System.out.println(member.getMemId());
			System.out.println(member.getMemName());
			System.out.println(member.getMemPass());
		
			
			
			Query query = session.createQuery("From Books");

			List<Books> resultList = query.list();
			out.println("<HTML><HEAD><TITLE>ALL BOOKS</TITLE></HEAD>");
			out.println();
			out.println("<style>table {	    font-family: arial, sans-serif;	    border-collapse: collapse;	    width: 100%;	}");
			out.println("td, th {    border: 1px solid #dddddd;    text-align: left;    padding: 8px;}");
			out.println("tr:nth-child(even) {    background-color: #dddddd;}");
			out.println("</style>");
			out.println("<table>");
			out.println(" <tr>  <th>BOOK NAME</th> <th>BOOK AUTHOR</th> <th>BOOK PRICE</th> <th> ACTION </th></tr>");
			
			for (Books next : resultList)
			
			{
				Long bookid = next.getId();
				String BookName=next.getName();
		        String AuthorName=next.getAuthor();
		        int Price = next.getPrice();
				
		        out.println("<form method=\"POST\" action=\"Update\">");
	            out.println("<input type=\"hidden\" name=\"bookid\" value="+bookid+">");
	   			out.println(" <tr>"

	   					+ " <td>" + BookName
	   					+ "</td><td>" + AuthorName + "</td><td>" + Price
	   					+ "</td>  <td>");
	   			
	   			out.println("<input type=\"submit\"  value=\"Update\">");
	   			out.println("</form>");
	   			out.println("<form method=\"POST\" action=\"Delete\">");
	   			out.println("<input type=\"hidden\" name=\"bookid\" value="+bookid+">");
	   					
	   			out.println("<input type=\"submit\"  value=\"Delete\">");
	   			out.println("</form>");
	   			out.println("</td></tr></table>");
	   		 out.println("<form method=\"POST\" action=\"/Boo/htmls/insert.html\">");
	   		out.println(" <div align=\"left\" ><br><br><br><br><br><br><br><br><br>");
	   		 out.println("<p><font color = \"red\" size=\"4\">To Upload a New Book - Click on 'Upload'</font></p>");
	   		   
	   		out.println("<input type=\"submit\"  value=\"Upload\">");
	   		out.println("</div></form></body></html>");
	   		
	   		
	   			
        		     
			}
            }
			
			else{
				
				out.println("<HTML><HEAD><TITLE>Access Denied</TITLE></HEAD>");
				out.println("<BODY>Your User Name and Password are invalid.<BR>");
				out.println("Please click here to try again<A HREF=\"" + req.getContextPath() +"/\">CLICK-ME</A>");
				out.println("</BODY></HTML>");
			}
            
}catch(Exception ex)
{
	System.out.println("Unknown exception.");
	ex.printStackTrace();
}finally
{
	
}
}

	private static SessionFactory getSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			return new Configuration().configure("hibernate-example1.cfg.xml").buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}


}
