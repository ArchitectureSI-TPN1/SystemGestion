<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="mypackage.model.Match"%>  
<%@ page import="mypackage.model.Equipe"%> 
<%@ page import="mypackage.dao.EquipeDao"%>
<%@ page language="java" import="java.util.List"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%List list = (List) request.getAttribute("matchs");%>
<% Match matchInfo = (Match) request.getAttribute("matchInfo");%>
<% String message = (String) request.getAttribute("message");%>
<% String showAdd = (String) request.getAttribute("showAdd");%>
<% Match matchEdit = (Match) request.getAttribute("matchEdit"); %>
<% HttpServletRequest httpRequest= (HttpServletRequest)request; %>
<% boolean admin = false;
   String login = "";
   String password = "";
	Cookie[]  cookies = httpRequest.getCookies();
   if(cookies != null){
	   for(Cookie ck : cookies){
		   if("admin".equals(ck.getValue())){
			   admin = true;
		   }
		   if("login".equals(ck.getName())){
			   login = ck.getValue();
		   }
		   if("password".equals(ck.getName())){
			   password = ck.getValue();
		   }
	   }
   }
%>
<% if(admin==false){%>
<a href="roleServlet?role=visiter">return to page choose table</a>
<% }%>
<% if(admin==true){ %>
<% String web = "loginServlet?login=" + login+ "&password=" + password;%>
<a href="<%= web%>" > return to page choose table </a>
<% } %>

<h2 align = "center">match</h2>  
    <table border = 1px align = "center">
    <% if("showAdd".equals(showAdd)){%>
    <!-- add match windows -->
	<div id="addDialog" style="padding: 10px">  
    	<form action = "matchServlet">
	    	<table cellpadding="8" >
	    		<tr>
	    			<td>id:</td>
	    			<td><input id="add_id" style="width: 200px; height: 30px;" class="easyui-textbox" type="text" name="idmatch" data-options="required:true, missingMessage:'enter id'" /></td>
	    		</tr>
	    		<tr>
	    			<td>nomMatch:</td>
	    			<td>
	    				<input id="add_nom" style="width: 200px; height: 30px;" type="text" name="nomMatch" data-options="required:true, missingMessage:'enter nom'" />
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>date</td>
	    			<td>
	    				<input id="add_date" style="width: 200px; height: 30px;" type="text" name="date" data-options="required:true, missingMessage:'enter date'" />
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>ville</td>
	    			<td>
	    				<input id="add_ville" style="width: 200px; height: 30px;" type="text" name="ville" data-options="required:true, missingMessage:'enter ville'" />
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>stade</td>
	    			<td>
	    				<input id="add_stade" style="width: 200px; height: 30px;" type="text" name="stade" data-options="required:true, missingMessage:'enter stade'" />
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>nomEquipe1</td>
	    			<td>
	    				<input id="add_equipe1" style="width: 200px; height: 30px;" type="text" name="equipe1" data-options="required:true, missingMessage:'enter equipe1'" />
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>nomEquipe2</td>
	    			<td>
	    				<input id="add_equipe2" style="width: 200px; height: 30px;" type="text" name="equipe2" data-options="required:true, missingMessage:'enter equipe2'" />
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>pointEquipe1</td>
	    			<td>
	    				<input id="add_point1" style="width: 200px; height: 30px;" type="text" name="point1" data-options="required:true, missingMessage:'enter point1'" />
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>pointEquipe2</td>
	    			<td>
	    				<input id="add_point2" style="width: 200px; height: 30px;" type="text" name="point2" data-options="required:true, missingMessage:'enter point1'" />
	    			</td>
	    		</tr>
	    	</table>
	    	<input type = "submit" name = "button" value = "submitAdd">
	    </form>
	</div>
	<% }%>
	
	<% if(matchEdit != null){%>
	<div id="addDialog" style="padding: 10px"> 
	<form action = "matchServlet">
	    	<table cellpadding="8" >
	    		<tr>
	    			<td>id:</td>
	    			<td><input id="edit_id" style="width: 200px; height: 30px;" class="easyui-textbox" type="text" name="editIdMatch"  value = <%=matchEdit.getIdMatch() %> data-options="required:true, missingMessage:'enter id'" /></td>
	    		</tr>
	    		<tr>
	    			<td>nomMatch:</td>
	    			<td>
	    				<input id="edit_nom" style="width: 200px; height: 30px;" type="text" name="editNomMatch" value = <%=matchEdit.getNomMatch() %> data-options="required:true, missingMessage:'enter nom'" />
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>date</td>
	    			<td>
	    				<input id="edit_date" style="width: 200px; height: 30px;" type="text" name="editDate" value = <%=matchEdit.getDate()%> data-options="required:true, missingMessage:'enter date'" />
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>ville</td>
	    			<td>
	    				<input id="edit_ville" style="width: 200px; height: 30px;" type="text" name="editVille" value = <%=matchEdit.getVille() %> data-options="required:true, missingMessage:'enter ville'" />
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>stade</td>
	    			<td>
	    				<input id="edit_stade" style="width: 200px; height: 30px;" type="text" name="editStade" value = <%=matchEdit.getStade() %> data-options="required:true, missingMessage:'enter stade'" />
	    			</td>
	    		</tr>
	    		  <%
          		  int idEquipe1=matchEdit.getIdEquipe1();
		          EquipeDao equipeDao = new EquipeDao();
		          Equipe equipe1 = equipeDao.searchEquipe(idEquipe1);
		          int idEquipe2=matchEdit.getIdEquipe2();
		          Equipe equipe2 = equipeDao.searchEquipe(idEquipe2);
		          %> 
	    		<tr>
	    			<td>nomEquipe1</td>
	    			<td>
	    				<input id="edit_equipe1" style="width: 200px; height: 30px;" type="text" name="editEquipe1" value = <%=equipe1.getNomEquipe() %> data-options="required:true, missingMessage:'enter equipe1'" />
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>nomEquipe2</td>
	    			<td>
	    				<input id="edit_equipe2" style="width: 200px; height: 30px;" type="text" name="editEquipe2" value = <%=equipe2.getNomEquipe() %> data-options="required:true, missingMessage:'enter equipe2'" />
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>pointEquipe1</td>
	    			<td>
	    				<input id="edit_point1" style="width: 200px; height: 30px;" type="text" name="editPoint1" value = <%=matchEdit.getPointEquipe1() %> data-options="required:true, missingMessage:'enter point1'" />
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>pointEquipe2</td>
	    			<td>
	    				<input id="edit_point2" style="width: 200px; height: 30px;" type="text" name="editPoint2" value = <%=matchEdit.getPointEquipe2() %> data-options="required:true, missingMessage:'enter point2'" />
	    			</td>
	    		</tr>
	    	</table>
	    	<input type = "submit" name = "button" value = "submitEdit">
		    </form>
	</div>
	<% } %>
	
	
    <% if(!"showAdd".equals(showAdd) && matchEdit == null) {%>
        <form action = "matchServlet">
		please enter the name of the match <input type = "text" name = "searchInfo"><br/>
		<input type = "submit" name = "button" value = "search">
		<input type = "submit" name = "button" value = "ListAll">
		</form>	
     	  <tr>  
     	  	<th></th>
            <th>id</th>  
            <th>nom</th>  
            <th>date</th>  
            <th>ville</th> 
            <th>stade</th> 
            <th>equipe1</th> 
            <th>equipe2</th> 
            <th>point1</th> 
            <th>point2</th> 
        </tr> 
    	<% if(admin){%>
        <form action = "matchServlet">
        <input type = "submit" name = "button" value = "delete">
		<input type = "submit" name = "button" value = "add"> 
        <input type = "submit" name = "button" value = "edit">
        <%} %>
        <%  if(list != null){%>
        <% for(int i = 0;i<list.size();i++){%>
                <%Match match = (Match)list.get(i);%> 
                <tr>
                
                <th><input type = checkbox name = "chk" id="chk" value=<%=match.getIdMatch()%>></th> 
                
                <th><%=match.getIdMatch() %></th>  
                <th><%=match.getNomMatch()%></th>  
                <th><%=match.getDate()%></th>  
                <th><%=match.getVille()%></th>
                <th><%=match.getStade()%></th>
                <%
                int idEquipe1=match.getIdEquipe1();
                EquipeDao equipeDao = new EquipeDao();
                Equipe equipe1 = equipeDao.searchEquipe(idEquipe1);
                %>
                <th><%=equipe1.getNomEquipe()%></th>
                <!-- <th><%=match.getIdEquipe1()%></th>  -->
                <%
                int idEquipe2=match.getIdEquipe2();
                Equipe equipe2 = equipeDao.searchEquipe(idEquipe2);
                %>
                <th><%=equipe2.getNomEquipe()%></th>
                <!-- <th><%=match.getIdEquipe2()%></th>  -->
                <th><%=match.getPointEquipe1()%></th>
                <th><%=match.getPointEquipe2()%></th>
                <br>   
                
        <% }%> 
        <% }%>
        </form>
        <% if(matchInfo != null){%>
         <tr>  
         		<th>     </th>
                <th><%=matchInfo.getIdMatch() %></th>   
                <th><%=matchInfo.getNomMatch()%></th>  
                <th><%=matchInfo.getDate()%></th>  
                <th><%=matchInfo.getVille()%></th>
                <th><%=matchInfo.getStade()%></th>
                <%
                int idEquipe1=matchInfo.getIdEquipe1();
                EquipeDao equipeDao = new EquipeDao();
                Equipe equipe1 = equipeDao.searchEquipe(idEquipe1);
                %>
                <th><%=equipe1.getNomEquipe()%></th>
                <!-- <th><%=matchInfo.getIdEquipe1()%></th> -->
                <%
                int idEquipe2=matchInfo.getIdEquipe2();
                Equipe equipe2 = equipeDao.searchEquipe(idEquipe2);
                %>
                <th><%=equipe2.getNomEquipe()%></th>  
                <!-- <th><%=matchInfo.getIdEquipe2()%></th> --> 
                <th><%=matchInfo.getPointEquipe1()%></th>
                <th><%=matchInfo.getPointEquipe2()%></th>
                <br> 
                <% }  
         %>
          <% if("delSuccess".equals(message)){%>
         		<script>
				alert("congratulation! success deleted!");
				</script>
                <% }  
         %>
         <% }  
         %> 
         <% if("editSuccess".equals(message)){%>
         		<script>
				alert(" success edited!");
				</script>
				
         <% } %> 
         
         
            
    </table>
</body>
</html>
