<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function validate(theForm) {
var val3 = theForm.aid.value;
if (val3==null || val3.trim()=="") { 
	    alert('Please enter Category ID');
	    theForm.aid.focus();
	    return false; // cancel submission
	  }
var val4 = theForm.aname.value;
if (val4==null || val4.trim()=="") { 
	    alert('Please enter Category Name');
	    theForm.aname.focus();
	    return false; // cancel submission
	  }
	  
	  return true;
}
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
<h3><center>CREATE CATEGORY PAGE</center></h3>
<%if(request.getAttribute("result")!=null){ %>
<h9>Data Inserted</Data>
<%} %>
<form action="category" method="post" name="editcategorycreationform" onsubmit="return validate(this)" >
 <%-- <input type="hidden" name="editcategoryidhidden" value="<%=request.getParameter("aid")%>"/>
 <input type="hidden" name="editcategorynamehidden" value="<%=request.getParameter("aname")%>"/> --%>
 <table border="1" cellpadding="5" width="300" align="center">
<tr><td>Category ID</td><td><input type="text" readonly="readonly" name="aid"  value="<%=request.getParameter("editcatid")%>"></td></tr>
<tr><td>Category Name</td><td><input type="text" name="aname" value="<%=request.getParameter("editcatname")%>"></td></tr>
</table>
<input type="submit" name="Editbooklist"  value="Update Category"/>
</form> 
<form action="category" method="GET" name="home" >
   <input type="submit" name="home"  value="Home" align="center"/>
   <input type="hidden" name="homesend" value="home"/>
  </form>
</body>
</html>