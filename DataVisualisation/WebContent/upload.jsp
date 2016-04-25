<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
<title>Upload File</title>
</head>
<body>
	<center>
	<div>
	 <h3>File Upload</h3>
		<form action="upload.do" method="POST" enctype="multipart/form-data">
			 Select file to upload: <input type="file" name="file"  /><br />
        <br /> <input type="submit" value="Upload" />
        </form>
        
        <p>${message}</p>
        
      <c:if test="${not empty images }">
      	 	 <c:forEach var="img" items="${images}">
    
      		<table>
      			
      			<c:forEach var="i" begin="0" end="27">
      				<c:forEach var="j" begin="0" end="27">
      				    <td style="background-color: rgb(${img[i][j]},${img[i][j]},${img[i][j]});"></td>
      				</c:forEach> 
      				<tr></tr>     			
      			</c:forEach>
      		</table>
      		
      		</c:forEach>
      	<form action="upload.do" method="GET">
      		
      	</form>
      </c:if>  
    </div>    
	</center>
</body>
</html>