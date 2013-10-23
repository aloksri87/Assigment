<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="books.Author"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h3><center>AUTHOR DETAIL PAGE</center></h3>
<%Author bean=null;
if(request.getAttribute("authordetailbean")!=null)
{
	System.out.println("bb");
	 bean=(Author)request.getAttribute("authordetailbean");
 
 %>
 <form action="authors" method="post">
 <input type="hidden" name="editauthid" value="<%=bean.getAid()%>"/>
 <input type="hidden" name="editauthfname" value="<%=bean.getFname()%>"/>
 <input type="hidden" name="editauthlname" value="<%=bean.getLname()%>"/>
 <input type="hidden" name="editauthdob" value="<%=bean.getDate()%>"/>
  <table border="1" cellpadding="5" width="300" align="center">
    <tr>
    
    <th>AUTHOR ID</th>
    <th>AUTHOR FIRST NAME</th>
    <th>AUTHOR LAST NAME</th>
    <th>AUTHOR BIRTH DATE</th>
    
    </tr>
   
	  
	  <tr>
	  <td width="10%"><%=bean.getAid()%></a></td>
	  <td width="70%"><%=bean.getFname()%></td>
	  <td width="10%"><%=bean.getLname()%></td>
	  <td width="10%"><%=bean.getDate()%></td>
	  
	 
	  </tr>
	  
	  
  <%} %>
  
  </table>
  <input type="submit" name="edit"  value="EDIT" align="center">
  </form>
  <form action="authors" method="GET" name="authorDetail">
   <input type="submit" name="back"  value="BACK" align="center">
  </form>
  <form action="authors" method="get" name="authordelete" >
   <input type="submit" name="delete"  value="Delete">
   <input type="hidden" name="deleteion" value="bookdeletion"/>
  <input type="hidden" name="aidsend" value="<%=bean.getAid()%>"/>
  </form>
</body>
</html>