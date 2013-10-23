<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="books.Category"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h3><center>CATEGORY DETAIL PAGE</center></h3>
<%Category bean=null;
if(request.getAttribute("categorydetailbean")!=null)
{
	System.out.println("bb");
	 bean=(Category)request.getAttribute("categorydetailbean");
 %> 
 <form action="category" method="post">
 <input type="hidden" name="editcatid" value="<%=bean.getId()%>"/>
 <input type="hidden" name="editcatname" value="<%=bean.getName()%>"/>
 <table border="1" cellpadding="5" width="300" align="center">
    <tr>
    
    <th>CATEGORY ID</th>
    <th>CATEGORY NAME</th>
    
    
    </tr>
   
	  
	  <tr>
	  <td width="10%"><%=bean.getId()%></a></td>
	  <td width="70%"><%=bean.getName()%></td>
	  
	 
	  </tr>
	  
	  
  <%} %>
  
  </table>
  <input type="submit" name="edit"  value="EDIT" align="center">
  </form>
  <form action="category" method="GET" name="CategoryDetail">
   <input type="submit" name="back"  value="BACK" align="center">
  </form>
  <form action="category" method="get" name="categorydelete" >
   <input type="submit" name="delete"  value="Delete">
   <input type="hidden" name="deleteion" value="bookdeletion"/>
  <input type="hidden" name="cidsend" value="<%=bean.getId()%>"/>
  </form>
</body>
</html>