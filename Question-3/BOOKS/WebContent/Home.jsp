<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DUKE BOOK STORE</title>
</head>
<body>
<h1 align="center">Welcome to Duke books Store</h1>
<table align="left">
<tr>
<td>
<form action="books" method="get"> 
<input type="submit" name="getbooklist" value="List of Books">
</form> 
</td>
</tr>
<tr>
<td>
<form action="books" method="post">
<input type="submit" name="createbooklist" value="Create Book With Author and Category">
</form>
</td>
</tr>
<tr>
<td>
<form action="books" method="get">
<input type="hidden" name="newbookcreate" value="newbookcreate">
<input type="submit" name="createbooklist" value="Create New Book">
</form>
</td>
</tr>
<tr>
<td>
<form action="authors" method="get">
<input type="submit" name="getauthorlist" value="Author List">
</form> 
</td>
</tr>
<tr>
<td>
<form action="authors" method="post">
<input type="submit" name="createauthor" value="Create New Author">
</form>
</td>
</tr>
<tr>
<td>
<form action="category" method="get">
<input type="submit" name="getCategorylist" value="Category List" width="" height="1001111" size="100">
</form>
</td>
</tr>
<tr>
<td> 
<form action="category" method="post">
<input type="submit" name="createcategory" value="Create New Category">
</form>
</td>
</tr>
</table>
</body>
</html>