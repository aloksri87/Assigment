<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page import="books.Author"%> 
  <%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3><center>AUTHOR LIST PAGE</center></h3>
<%
if(request.getAttribute("authorbean")!=null)
{
	
	Author bean=(Author)request.getAttribute("authorbean");
  ArrayList list=bean.getList();
 %> <table border="1" cellpadding="5" width="300" align="center">
    <tr>
    <th>AUTHOR ID</th>
    <th>AUTHOR FIRST NAME</th>
    <th>AUTHOR LAST NAME</th>
    <th>AUTHOR BIRTH DATE</th>
    </tr>
   <% 
  for(int i=0;i<list.size();i++)
  {
	  Author b=(Author)list.get(i);%>
	  
	  <tr>
	  <td width="10%"><a href="authors?id=<%=b.getAid()%>"><%=b.getAid()%></a></td>
	  <td width="70%"><%=b.getFname()%></td>
	  <td width="10%"><%=b.getLname()%></td>
	  <td width="10%"><%=b.getDate()%></td>
	  </tr>
	  
	  
  <% }%>
  </table>
  <%}else {%>
  <b>THERE IS NO AUTHOR LIST GO FOR AUTHOR CREATION</b>
  <form action="authors" method="post">
<input type="submit" name="createauthor" value="Create New Author">
</form>
  <%} %>
  <form action="books" method="GET" name="home" >
   <input type="submit" name="home"  value="Home" align="center">
   <input type="hidden" name="homesend" value="home"/>
  </form>
  
</body>
</html>