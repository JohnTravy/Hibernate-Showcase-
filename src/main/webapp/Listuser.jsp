<%@page import = "java.util.List" %>
<%@page import = "org.travy.appmodel.Model" %>
<%@page import = "org.travy.entity.Userdets" %>

<jsp:include page="include/header.jsp"/>


<h2>LIST OF USERS</h2>

<table border = "1">
<thead>
<th>user_Id</th>
<th>USERNAME</th>
<th>EMAIL</th>
<th>OPERATION</th>

</thead>


<%

List<Userdets> user = (List)request.getAttribute("Listuser");

for(Userdets usenow : user){
	
	out.print("<tr>");
	out.print("<td>" + usenow.getUser_id() + "</td>");
	out.print("<td>" + usenow.getUsername() + "</td>");
	out.print("<td>" + usenow.getEmail() + "</td>");
	out.print("<td> <a href =" + request.getContextPath()+"/sitecont?page=updateuser&user_id=" +usenow.getUser_id()+"&username=" + usenow.getUsername()+ "&email="+usenow.getEmail()+ ">Update</a>");
	out.print(" | ");
	out.print("<a href =" + request.getContextPath()+ "/sitecont?page=deleteuser&user_id=" + usenow.getUser_id()+ ">Delete</a></td>");
	out.print("</tr>");
	
	
}




%>



</table>




<jsp:include page="include/footer.jsp"/>