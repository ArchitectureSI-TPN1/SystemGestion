<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="mypackage.model.Joueur"%>  
<%@ page language="java" import="java.util.List"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% List list = (List) request.getAttribute("joueurs");%>
<% Joueur joueurInfo = (Joueur) request.getAttribute("joueurInfo");%>
<% String message = (String) request.getAttribute("message");%>
<% Joueur joueurEdit = (Joueur) request.getAttribute("joueurEdit"); %>
<% String showAdd = (String) request.getAttribute("showAdd");%>
<% HttpServletRequest httpRequest= (HttpServletRequest)request; %>
<% boolean admin = false;
	Cookie[]  cookies = httpRequest.getCookies();
   if(cookies != null){
	   for(Cookie ck : cookies){
		   if("admin".equals(ck.getValue())){
			   admin = true;
		   }
	   }
   }
%>
<h2 align = "center">joueurs</h2>  
    <table border = 1px align = "center"> 
    <% if("showAdd".equals(showAdd)){%>
    <!-- add equipe windows -->
	<div id="addDialog" style="padding: 10px">  
    	<form action = "joueurServlet">
	    	<table cellpadding="8" >
	    		<tr>
	    			<td>idjoueur:</td>
	    			<td><input id="add_id" style="width: 200px; height: 30px;" class="easyui-textbox" type="text" name="idJoueur"  data-options="required:true, missingMessage:'enter id'" /></td>
	    		</tr>
	    		<tr>
	    			<td>Nomjoueur:</td>
	    			<td>
	    				<input id="add_nom" style="width: 200px; height: 30px;" type="text" name="Nomjoueur"   data-options="required:true, missingMessage:'enter nom'" />
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>But</td>
	    			<td>
	    				<input id="add_nbPar" style="width: 200px; height: 30px;" type="text" name="But"   data-options="required:true, missingMessage:'enter nbParticipation'" />
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>Role</td>
	    			<td>
	    				<input id="add_nbVic" style="width: 200px; height: 30px;" type="text" name="Role"   data-options="required:true, missingMessage:'enter nbVictoire'" />
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>NotePrese</td>
	    			<td>
	    				<input id="add_nbPar" style="width: 200px; height: 30px;" type="text" name="NotePrese"  data-options="required:true, missingMessage:'enter nbParticipation'" />
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>idEquipe</td>
	    			<td>
	    				<input id="add_nbPar" style="width: 200px; height: 30px;" type="text" name="idEquipe"  data-options="required:true, missingMessage:'enter nbParticipation'" />
	    			</td>
	    		</tr>
	    	</table>
	    	<input type = "submit" name = "button" value = "submitAdd">
	    </form>
	</div>
	<% }%>  
	
	<% if(joueurEdit != null){%>
	<div id="editDialog" style="padding: 10px"> 
	<form action = "joueurServlet">
	    	<table cellpadding="8" >
	    		<tr>
	    			<td>idjoueur:</td>
	    			<td><input id="edit_id" style="width: 200px; height: 30px;" class="easyui-textbox" type="text" name="editIdJoueur" value = <%=joueurEdit.getIdjoueur()%> data-options="required:true, missingMessage:'enter id'" /></td>
	    		</tr>
	    		<tr>
	    			<td>Nomjoueur:</td>
	    			<td>
	    				<input id="edit_nom" style="width: 200px; height: 30px;" type="text" name="editNomjoueur" value = <%=joueurEdit.getNomJoueur() %> data-options="required:true, missingMessage:'enter nom'" />
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>But</td>
	    			<td>
	    				<input id="edit_nbPar" style="width: 200px; height: 30px;" type="text" name="editBut" value = <%=joueurEdit.getBut() %> data-options="required:true, missingMessage:'enter nbParticipation'" />
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>Role</td>
	    			<td>
	    				<input id="edit_nbVic" style="width: 200px; height: 30px;" type="text" name="editRole" value = <%=joueurEdit.getRole() %> data-options="required:true, missingMessage:'enter nbVictoire'" />
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>NotePrese</td>
	    			<td>
	    				<input id="edit_nbPar" style="width: 200px; height: 30px;" type="text" name="editNotePrese" value = <%=joueurEdit.getNotePrese() %> data-options="required:true, missingMessage:'enter nbParticipation'" />
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>idEquipe</td>
	    			<td>
	    				<input id="edit_nbPar" style="width: 200px; height: 30px;" type="text" name="editIdEquipe" value = <%=joueurEdit.getEquipe_idEquipe() %> data-options="required:true, missingMessage:'enter nbParticipation'" />
	    			</td>
	    		</tr>
	    	</table>
	    	<input type = "submit" name = "button" value = "submitedit">
	    </form>
	</div>
	<% } %>
	
	<% if(!"showAdd".equals(showAdd) && joueurEdit == null){%>
		<form action = "joueurServlet">
		please enter the name of the group <input type = "text" name = "searchInfo" ><br/>
		<input type = "submit" name = "button" value = "search">
		</form>	
     	  <tr>  
     	  	<th></th>
            <th>Idjoueur</th> 
             <th>Nomjoueur</th>
            <th>But</th>  
            <th>Role</th>  
            <th>NotePrese</th>
            <th>Equipe_idEquipe</th>    
        </tr>
    	<% if(admin){%>
        <form action = "joueurServlet">
        <input type = "submit" name = "button" value = "delete">
		<input type = "submit" name = "button" value = "add"> 
        <input type = "submit" name = "button" value = "edit">
        <%} %>
        <%  if(list != null){%>
        <% for(int i = 0;i<list.size();i++){%>
                <%Joueur joueur = (Joueur)list.get(i);%> 
                <tr>
                
                <th><input type = checkbox name = "chk" id="chk" value=<%=joueur.getIdjoueur()%>></th> 
                 <th><%=joueur.getIdjoueur() %></th>
                <th><%=joueur.getNomJoueur() %></th>  
                <th><%=joueur.getBut()%></th>  
                <th><%=joueur.getRole()%></th>  
                <th><%=joueur.getNotePrese()%></th>
                <th><%=joueur. getEquipe_idEquipe()%></th><br>   
                
        <% }%> 
        <% }%>
        </form>
        
        </form>
        <% if(joueurInfo != null){%>
         <tr>  
         		<th>     </th>
                <th><%=joueurInfo.getIdjoueur() %></th>
                <th><%=joueurInfo.getNomJoueur() %></th>  
                <th><%=joueurInfo.getBut()%></th>  
                <th><%=joueurInfo.getRole()%></th>  
                <th><%=joueurInfo.getNotePrese()%></th>
                <th><%=joueurInfo. getEquipe_idEquipe()%></th><br> 
                <% }  
         %>
         
           <% if("delSuccess".equals(message)){%>
         		<script>
				alert("congratulation! success deleted!");
				</script>
                <% } %>
                <% } %>
                
           <% if("editSuccess".equals(message)){%>
         		<script>
				alert(" success edited!");
				</script>
           <% } %> 
                
                
        </table>
</body>
</html>