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


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML >

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete</title>
<center>
<img src="/jsp/htmls/bookstore.jpg" Height = 20% Width = 50% size = 10px200px;" />
</center>
</head>

<body>

<%

   

    int bkid = Integer.parseInt(request.getParameter("bookid"));
System.out.println(bkid);

    
    
    
    try
    {
    	out.println(bkid);
    	out.println("<form method=\"POST\" action=\"DeleteDisplay.jsp\">");
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

    	out.println("</BR>");


    }

catch(Exception e)
    {

}

    %>
    
    
	



</body>
</html>
