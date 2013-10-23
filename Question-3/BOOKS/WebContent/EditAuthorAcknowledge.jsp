<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body> 
<h3><center> AUTHOR UPDATE ACKNOWLEDGEMENT  PAGE</center></h3>


 <table border="1" cellpadding="5" width="300" align="center">
<tr><td>Author ID</td><td><input type="text" name="editaid" readonly="readonly" value="<%=request.getAttribute("editaid")%>"/></td></tr>
<tr><td>Author Name</td><td><input type="text" name="editaname" readonly="readonly" value="<%=request.getAttribute("editafname")%>"></td></tr>
<tr><td>Author Last Name</td><td><input type="text" name="editalname" readonly="readonly" value="<%=request.getAttribute("editalname")%>"></td></tr>
<tr><td>Author Birth Date</td><td><input type="text" name="editabithdate" readonly="readonly" value="<%=request.getAttribute("editadob")%>"></td></tr></table>

<form action="authors" method="get">
  
<input type="submit" name="getAuthorlist" value="GO to Author List">
</form> 
</body>
</html>