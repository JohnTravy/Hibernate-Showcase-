<jsp:include page="include/header.jsp"/>


<h2>ADDUSERS</h2>

<form action="<%=request.getContextPath()%>/sitecont" method = "post" >

USERNAME:<input type = "text" name = "username" required = "required"><br>
EMAIL   :<input type = "text" name = "email" required = "required"><br>

<input type = "hidden" name = "form" value = "operate" >

<input type = "submit" value = "ADDUSER">



</form>


<jsp:include page="include/footer.jsp"/>