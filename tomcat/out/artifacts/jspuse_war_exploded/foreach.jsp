
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="cm.dao.User" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>foreach</title>
</head>
<body>
    <%
        List list=new ArrayList();
        list.add(new User("葛旭",22,new Date()));
        list.add(new User("李雅琪",20,new Date()));
        list.add(new User("张煜",21,new Date()));
        request.setAttribute("list",list);
    %>
    <table border="1" width="500" align="center">
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>生日</th>
        </tr>
        <c:forEach items="${list}" var="user" varStatus="s">
           <c:if test="${s.count%2==0}">
               <tr bgcolor="#00ffff">
                   <td>${s.count}</td>
                   <td>${user.name}</td>
                   <td>${user.age}</td>
                   <td>${user.birStr}</td>
               </tr>
           </c:if>
            <c:if test="${s.count%2!=0}">
                <tr bgcolor="#db7093">
                    <td>${s.count}</td>
                    <td>${user.name}</td>
                    <td>${user.age}</td>
                    <td>${user.birStr}</td>
                </tr>
            </c:if>
        </c:forEach>
    </table>
</body>
</html>
