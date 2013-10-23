<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="books.CommonBean"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h3><center>BOOK DETAIL PAGE</center></h3>
<%CommonBean bean=null;
if(request.getAttribute("commonbookbean")!=null)
{
	System.out.println("bb");
	 bean=(CommonBean)request.getAttribute("commonbookbean");
 
 %> <table border="1" cellpadding="5" width="300" align="center">
    <tr>
    <th>BOOKID</th>
    <th>BOOK NAME</th>
    <th>CATEGORY ID</th>
    <th>CATEGORY TYPE</th>
    <th>AUTHOR ID</th>
    <th>AUTHOR FIRST NAME</th>
    <th>AUTHOR LAST NAME</th>
    <th>AUTHOR BIRTH DATE</th>
    
    </tr>
   
	  
	  <tr>
	  <td width="10%"><%=bean.getBid()%></a></td>
	  <td width="70%"><%=bean.getTitle()%></td>
	  <td width="10%"><%=bean.getCid()%></td>
	  <td width="10%"><%=bean.getBooktype()%></td>
	  <td width="70%"><%=bean.getAid()%></td>
	  <td width="10%"><%=bean.getFname()%></td>
	  <td width="10%"><%=bean.getLname()%></td>
	  <td width="10%"><%=bean.getDate()%></td>
	 
	  </tr>
	  
	  
  <%} %>
  
  </table>
  <form action="books" method="GET" name="bookdetail" >
   <input type="submit" name="back"  value="BACK" align="center">
  </form>
  <form action="books" method="get" name="bookdelete" >
   <input type="submit" name="delete"  value="Delete">
   <input type="hidden" name="deleteion" value="bookdeletion"/>
  <input type="hidden" name="bidsend" value="<%=bean.getBid()%>"/>
  </form>
</body>
</html>