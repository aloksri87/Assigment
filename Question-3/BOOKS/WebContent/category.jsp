<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page import="books.Category"%> 
  <%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3><center>CATEGORY LIST PAGE</center></h3>
<%
if(request.getAttribute("categorybean")!=null)
{
	
	Category bean=(Category)request.getAttribute("categorybean");
  ArrayList list=bean.getList();
 %> <table border="1" cellpadding="5" width="300" align="center">
    <tr>
    <th>CATEGORY ID</th>
    <th>CATEGORY NAME</th>
    </tr>
   <% 
  for(int i=0;i<list.size();i++)
  {
	  Category b=(Category)list.get(i);%>
	  
	  <tr>
	  <td width="10%"><a href="category?id=<%=b.getId()%>"><%=b.getId()%></a></td>
	  <td width="70%"><%=b.getName()%></td>
	  
	  </tr>
	  
	  
  <%}%>
  </table>
  <%}else{ %>
  <b>THERE IS NO CATEGORY LIST GO FOR CATEGORY CREATION</b>
  <form action="category" method="post">
<input type="submit" name="createauthor" value="Create New Category">
</form>
  <%} %>
  <form action="category" method="GET" name="home" >
  <input type="hidden" name="homesend" value="home"/>
   <input type="submit" name="home"  value="Home" align="center">
   
  </form>
  
</body>
</html>