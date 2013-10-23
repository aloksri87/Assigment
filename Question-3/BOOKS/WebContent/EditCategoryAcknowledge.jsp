<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body> 
<h3><center> CATEGORY ACKNOWLEDGEMENT  PAGE</center></h3>


 <table border="1" cellpadding="5" width="300" align="center">
<tr><td>Category ID</td><td><input type="text" readonly="readonly" name="aid"  value="<%=request.getAttribute("editid")%>"></td></tr>
<tr><td>Category Name</td><td><input type="text" readonly="readonly" name="aname" value="<%=request.getAttribute("editname")%>"></td></tr>
</table>

<form action="category" method="get">
  
<input type="submit" name="getCategorylist" value="GO to Category List">
</form> 
</body>
</html>