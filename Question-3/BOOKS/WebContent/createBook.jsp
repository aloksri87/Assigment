<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="books.BookBean"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function isNumberKey(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode
   if (charCode > 31 && (charCode < 48 || charCode > 57))
      return false;

   return true;
}


</script>
</head>

<body> 
<% BookBean bean=(BookBean)getServletContext().getAttribute("categorybookbean") ;BookBean view=(BookBean)getServletContext().getAttribute("authorbookbean");
if(bean!=null && view !=null){
	getServletContext().setAttribute("dropdowncatbean", bean);
	getServletContext().setAttribute("dropdownaaidbean", view);
%>
<h3><center>CREATE BOOK PAGE</center></h3>
<form action="books" method="post" name="bookform" >
 <input type="hidden" name="bookcreate" value="bookcreate"/>
 <table border="1" cellpadding="5" width="300" align="center">
 <tr>
<td>Book ID</td><td><input type="text" id="bid" onkeypress="return isNumberKey(event);" name="bid"></td>
</tr>
<tr><td>Title</td><td><input type="text" name="title"></td></tr>
<tr>
<td>Category ID</td>
<td>
<select name="categorydropdown" >
<%=bean.getCategoryHtmlList() %>
</select>
</td>
</tr>

<tr><td>Author ID</td>
<td>
<select name="authordropdown" >
<%=view.getAuthorHtmlList() %>
</select>
</td>
</tr>

</table>



<input type="submit" name="createbook"  value="Create Book"/>

</form> 
<%} else{%>
<form action="books" method="post">

<input type="submit" name="createbooklist" value="No Existing Record Go to Create Book Author and Category">
</form>
<%} %>
<form action="books" method="GET" name="home" >
   <input type="submit" name="home"  value="Home" align="center"/>
   <input type="hidden" name="homesend" value="home"/>
  </form>
</body>
</html>