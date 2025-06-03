<%--
  Created by IntelliJ IDEA.
  User: wtc
  Date: 2025/05/13
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <%@include file="common/header.jsp"%>
<%@include file="common/navigation.jsp"%>

<div class="container">
    <h1>Welcome to the welcome page</h1>
    <div>Your name is: ${name}</div>
    <div><a href="/list_todos">manage</a> your todos </div>
</div>
