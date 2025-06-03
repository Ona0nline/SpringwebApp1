
<html>
<head>
  <%@include file="common/header.jsp"%>

</head>
<body>
  <%@include file="common/navigation.jsp"%>
<h1>Enter ToDo Details</h1>
<%--  Do this to bind this form to the todo bean--%>
<form:form method="post" modelAttribute="todo">
  <%--  desceriptrions--%>
  <fieldset class="mb-3">
    <form:label path="description" required="required">Description</form:label>
    <form:input type="text" name="description" required="required" path="description"/>
    <form:errors path="description" cssClass="text-warning"/>
  </fieldset>

  <%--  target date--%>
  <fieldset class="mb-3">
    <form:label path="targetDate" required="required">Target date</form:label>
    <form:input type="text" name="targetDate" required="required" path="targetDate"/>
    <form:errors path="targetDate" cssClass="text-warning"/>
  </fieldset>

  <form:input type="hidden" name="id" path="id"/>
  <form:input type="hidden" name="done" path="done"/>
  <input type="submit" class="btn btn-success">
</form:form>

<script type="text/javascript">$('#targetDate').datepicker({
  format: 'yyyy-mm-dd',
  startDate: '-3d'
});</script>

</body>
</html>
