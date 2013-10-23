<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function isNumberKey(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode
   if (charCode > 31 && (charCode < 48 || charCode > 57))
      return false;

   return true;
}
function validate(theForm) { // passing the form object
	  var val1 = theForm.aid.value;
	  if (val1==null || val1.trim()=="") { 
	    alert('Please enter AUTHOR ID');
	    theForm.aid.focus();
	    return false; // cancel submission
	  }
	  var val2 = theForm.aname.value;
	  if (val1==null || val1.trim()=="") { 
	    alert('Please enter BOOKID');
	    theForm.aname.focus();
	    return false; // cancel submission
	  }
	  var val3 = theForm.alname.value;
	  if (val1==null || val1.trim()=="") { 
	    alert('Please enter BOOKID');
	    theForm.alname.focus();
	    return false; // cancel submission
	  }
	  var val4 = theForm.abithdate.value;
	  if (val1==null || val1.trim()=="") { 
	    alert('Please enter BOOKID');
	    theForm.abithdate.focus();
	    return false; // cancel submission
	  }
	  return true;
}


</script>
</head>
<body> 
<h3><center>CREATE AUTHOR PAGE</center></h3>
<%if(request.getAttribute("result")!=null){ %>
<h9>Data Inserted</Data>
<%} %>
<form action="authors" method="post" name="authoreditform" onsubmit="return validate(this)">
 <input type="hidden" name="updateAuthor" value="updateAuthor"/>
 <table border="1" cellpadding="5" width="300" align="center">
<tr><td>Author ID</td><td><input type="text" name="editaid" readonly="readonly" value="<%=request.getAttribute("editauthid")%>"/></td></tr>
<tr><td>Author Name</td><td><input type="text" name="editaname" value="<%=request.getAttribute("editauthfname")%>"></td></tr>
<tr><td>Author Last Name</td><td><input type="text" name="editalname" value="<%=request.getAttribute("editauthlname")%>"></td></tr>
<tr><td>Author Birth Date</td><td><input type="text" name="editabithdate" value="<%=request.getAttribute("editauthdob")%>"></td></tr>
</table>
<input type="submit" name="updateAuthor"  value="Update Author"/>

  
</form> 
<form action="authors" method="GET" name="homejsp" >
	<input type="submit" name="home"  value="Home" align="center"/>
   <input type="hidden" name="homesend" value="home"/>
  </form>
</body>
</html>