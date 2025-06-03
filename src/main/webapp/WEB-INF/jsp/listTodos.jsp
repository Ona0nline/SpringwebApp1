<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@include file="common/header.jsp"%>


</head>
<body>
        <%@include file="common/navigation.jsp"%>

<div class="container">
    <p>Welcome ${name}</p>
    <hr>
    <h1>Your todos are:</h1>

    <table border="1">
        <thead>
        <tr>
            <th>Description</th>
            <th>Target Date</th>
            <th>Is Done?</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="todo" items="${todos}">
            <tr>
                <td>${todo.description}</td>
                <td>${todo.targetDate}</td>
                <td>${todo.done}</td>
<%--                Request parameter == ?--%>
                <td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete </a></td>
                <td><a href="update-todo?id=${todo.id}" class="btn btn-success">Update </a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="add-todo" class="btn btn-success">Add Todo</a>

    <script type="text/javascript">$('#targetDate').datepicker({
        format: 'yyyy-mm                -dd',
        startDate: '-3d'
    });</script>

</div>

</body>
</html>
