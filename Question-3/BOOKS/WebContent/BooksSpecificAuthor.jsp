<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="books.CommonBean"%> 
    <%@ page import="java.util.*"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h3><center>BOOKS WITH SPECIFIC AUTHOR</center></h3>
<%CommonBean bean=null;
if(request.getAttribute("coombeanwithaid")!=null)
{
	System.out.println("bb");
	 bean=(CommonBean)request.getAttribute("coombeanwithaid");
	 ArrayList list=bean.getList();
 %> <table border="1" cellpadding="5" width="300" align="center">
    <tr>
    <th>BOOKID</th>
    <th>BOOK NAME</th>
    <th>AUTHOR NAME</th>
    <th>AUTHOR LAST NAME</th>
    <th>AUTHOR BIRTHDATE</th>
    
    </tr>
   
	 <% 
  for(int i=0;i<list.size();i++)
  {
	  CommonBean b=(CommonBean)list.get(i);%>
	  
	  <tr>
	  <td width="10%"><%=b.getBid()%></td>
	  <td width="10%"><%=b.getTitle()%></td>
	  <td width="70%"><%=b.getFname()%></td>
	  <td width="70%"><%=b.getLname()%></td>
	  <td width="70%"><%=b.getDate()%></td>
	  
	  </tr>
	  
	  
  <% }}%>
  </table>
  
  
  <form action="books" method="GET" name="BooksDetail">
   <input type="submit" name="back"  value="BACK" align="center">
  </form>
  
</body>
</html>