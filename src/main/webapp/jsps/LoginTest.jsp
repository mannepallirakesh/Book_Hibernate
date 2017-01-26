 <%@ page import="java.io.*" %>
<%@ page import="java.text.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.IOException"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="javax.servlet.ServletException"%>
<%@ page import="javax.servlet.http.HttpServlet"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.http.HttpServletResponse"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import = "java.sql.*" %>
<%@ page import = "org.hibernate.Session" %>
<%@ page import = "org.hibernate.SessionFactory" %>
<%@ page import = "org.hibernate.Transaction" %>
<%@ page import = "org.hibernate.*" %>
<%@ page import = "org.hibernate.cfg.Configuration" %>
<%@ page import = "com.training.Mem" %>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML >
   

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        


    </head>
    <body>
<%

Session session = getSessionFactory().openSession();
Transaction transaction = session.getTransaction();
transaction.begin();
         String user = request.getParameter("userName");
        String passwrd= request.getParameter("passWord");
        System.out.println(user);
        System.out.println(passwrd);
       try
               {
           
    	
    	String query = ("select count(USERNAME)AS CS from admin where USERNAME = ? and PASSWORD = ? ");
     
    	PreparedStatement pst  = con.prepareStatement(query);
		
		pst.setString(1, user);
		pst.setString(2, passwrd);
		ResultSet rs = pst.executeQuery();
		con.commit();
		
		         
         
       while( rs.next()){
    	   
    	   int cs = rs.getInt("CS");
        
        System.out.println(user);
        System.out.println("entered while");
         
        	
         
         if(cs == 1)
             {
                        System.out.println("Success"); 

                        %>
            <jsp:forward page="All.jsp"/>
        <%
             }
        
        else
        {
       	 System.out.println("fail");
            
       	 %>
            <jsp:forward page="LoginFailed.jsp"/>
        <%
        }
     
         }
         
         
         
           
       


           }




       catch(Exception e)
               {
    	   System.out.println("Problem while executing sql");
           out.println(e);
           e.printStackTrace();
           }


       %>
       
       <%
       
       try {
			// Create the SessionFactory from hibernate.cfg.xml
			return new Configuration().configure("hibernate-example1.cfg.xml").buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
       
       %>


        </body>
</html>
