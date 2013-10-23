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
	  var val1 = theForm.bid.value;
	  if (val1==null || val1.trim()=="") { 
	    alert('Please enter BOOKID');
	    theForm.bid.focus();
	    return false; // cancel submission
	  }
	  var val2 = theForm.title.value;
	  if (val2==null || val2.trim()=="") { 
		    alert('Please enter BOOK TITLE');
		    theForm.title.focus();
		    return false; // cancel submission
		  }
	  var val3 = theForm.cid.value;
	  if (val3==null || val3.trim()=="") { 
		    alert('Please enter Category ID');
		    theForm.cid.focus();
		    return false; // cancel submission
		  }
	  var val4 = theForm.cname.value;
	  if (val4==null || val4.trim()=="") { 
		    alert('Please enter Category Name');
		    theForm.cname.focus();
		    return false; // cancel submission
		  }
	  var val5 = theForm.aid.value;
	  if (val5==null || val5.trim()=="") { 
		    alert('Please enter Author ID');
		    theForm.aid.focus();
		    return false; // cancel submission
		  }
	  var val6 = theForm.aname.value;
	  if (val6==null || val6.trim()=="") { 
		    alert('Please enter Author name');
		    theForm.aname.focus();
		    return false; // cancel submission
		  }
	  var val7 = theForm.alname.value;
	  if (val7==null || val7.trim()=="") { 
		    alert('Please enter Author Last name');
		    theForm.alname.focus();
		    return false; // cancel submission
		  }
	  
	  var val8 = theForm.abithdate.value;
	  if (val8==null || val8.trim()=="") { 
		    alert('Please enter Author Birthdate');
		    theForm.abithdate.focus();
		    return false; // cancel submission
		  }
	  return true; // allow submit
	}
</script>
</head>
<body> 
<h3 align="center">CREATE BOOK PAGE</h3>
<P align="center"><B>BOOK ID ,CATEGORY ID ,AUTHOR ID Should be numeric and AUTHOR BIRTDATE should be YYYY-MM-DD format</B></p>
<%if(request.getAttribute("b1")!=null && request.getAttribute("b2")!=null && request.getAttribute("b3")!=null )
{Boolean b1=(Boolean)request.getAttribute("b1");
Boolean b2=(Boolean)request.getAttribute("b2");
Boolean b3=(Boolean)request.getAttribute("b3");
System.out.println(b1+" "+b2+" "+b3);
if(!(b1.booleanValue() && b2.booleanValue() && b3.booleanValue()))
{%>
<b>DATA IS INSERTED IN TABLE</b>
<%}}%>
<form action="books" method="post" name="bookcreationform" onsubmit="return validate(this)">
 <input type="hidden" name="bookhidden" value="bookcreationform"/>
 <table border="1" cellpadding="5" width="300" align="center">
 <tr>
<td>Book ID</td><td><input type="text" onkeypress="return isNumberKey(event);" name="bid"></td>
</tr>
<tr><td>Title</td><td><input type="text" name="title"></td></tr>
<tr><td>Category ID</td><td><input type="text" onkeypress="return isNumberKey(event);" name="cid"></td></tr>
<tr><td>Category Name</td><td><input type="text" name="cname"></td></tr>
<tr><td>Author ID</td><td><input type="text" onkeypress="return isNumberKey(event);" name="aid"></td></tr>
<tr><td>Author Name</td><td><input type="text" name="aname"></td></tr>
<tr><td>Author Last Name</td><td><input type="text" name="alname"></td></tr>
<tr><td>Author Birth Date</td><td><input type="text" name="abithdate"></td></tr>
</table>
<input type="submit" name="createbooklist"  value="Create"/>

</form> 
<form action="books" method="GET" name="home" >
   <input type="submit" name="home"  value="Home" align="center"/>
   <input type="hidden" name="homesend" value="home"/>
  </form>
</body>
</html>