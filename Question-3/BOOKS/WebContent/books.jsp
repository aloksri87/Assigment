<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page import="books.BookBean"%> 
  <%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3><center>BOOK LIST PAGE</center></h3>
<%
if(request.getAttribute("bookbean")!=null)
{
	System.out.println("bb");
  BookBean bean=(BookBean)request.getAttribute("bookbean");
  ArrayList list=bean.getBooksList();
 %> <table border="1" cellpadding="5" width="300" align="center">
    <tr>
    <th>BOOKID</th>
    <th>BOOK NAME</th>
    <th>Category</th>
    <th>Author</th>
    </tr>
   <% 
  for(int i=0;i<list.size();i++)
  {
	  BookBean b=(BookBean)list.get(i);%>
	  
	  <tr>
	  <td width="10%"><a href="books?id=<%=b.getBid()%>"><%=b.getBid()%></a></td>
	  <td width="70%"><%=b.getName()%></td>
	  <td width="10%"><a href="books?cid=<%=b.getCid()%>"><%=b.getCid()%></a></td>
	  <td width="10%"><a href="books?aid=<%=b.getAid()%>"><%=b.getAid()%></a></td>
	  </tr>
	  
	  
  <% }%>
  </table>
  <form action="books" method="GET" name="home" >
   <input type="submit" name="home"  value="Home" align="center">
   <input type="hidden" name="homesend" value="home"/>
  </form>
  <%}else{ %>
  <b>There is no book go for creation</b>
  <form action="books" method="post">

<input type="submit" name="createbooklist" value="No Existing Record Go to Create Book Author and Category">
</form>
<%} %>
</body>
</html>