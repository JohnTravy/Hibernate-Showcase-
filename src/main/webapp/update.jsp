<jsp:include page="include/header.jsp"/>


<h2>UPDATE USERS</h2>

<form action="<%=request.getContextPath()%>/sitecont" method = "post" >

USERNAME:<input type = "text" name = "username" value = "${param.username}" required = "required"><br>
EMAIL   :<input type = "text" name = "email" value = "${param.email}" required = "required"><br>

<input type = "hidden" name = "form" value = "updateuseroperation" >
<input type = "hidden" name = "user_id" value = "${param.user_id }">

<input type = "submit" value = "UPDATE USER">



</form>


<jsp:include page="include/footer.jsp"/>