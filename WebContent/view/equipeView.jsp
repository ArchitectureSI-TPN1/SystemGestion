<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="mypackage.model.Equipe"%>  
<%@ page language="java" import="java.util.List"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%List list = (List) request.getAttribute("equipes");%>
<% Equipe equipeInfo = (Equipe) request.getAttribute("equipeInfo");%>
<% String delMess = (String) request.getAttribute("message");%>
<h2 align = "center">equipe</h2>  
    <table border = 1px align = "center">  
        <tr>  
            <th>id</th>  
            <th>nom</th>  
            <th>nbPAR</th>  
            <th>nbvic</th>  
        </tr>   
        <%  if(list != null){%>
        <% 
            for(int i = 0;i<list.size();i++){  
                Equipe equipe = (Equipe)list.get(i);%>  
                <tr>  
                <th><%=equipe.getIdEquipe() %></th>  
                <th><%=equipe.getNomEquipe()%></th>  
                <th><%=equipe. getNbParticipation()%></th>  
                <th><%=equipe.getNbVictore()%></th><br>     
                
        <% }  
         %> 
        <% }%>
        <% if(equipeInfo != null){%>
         <tr>  
                <th><%=equipeInfo.getIdEquipe() %></th>  
                <th><%=equipeInfo.getNomEquipe()%></th>  
                <th><%=equipeInfo. getNbParticipation()%></th>  
                <th><%=equipeInfo.getNbVictore()%></th><br> 
                <% }  
         %>
          <% if("delSuccess".equals(delMess)){%>
         		<script>
				alert("congratulation! success deleted!");
				</script>
                <% }  
         %>
         
    </table>
    <form action = "equipeServlet">
please enter the name of the group <input type = "text" name = "searchInfo"><br/>
<input type = "submit" name = "button" value = "search">	
<input type = "submit" name = "button" value = "delete">	
</form>


</body>
</html>
