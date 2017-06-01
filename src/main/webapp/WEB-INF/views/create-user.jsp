<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
    <link href="<c:url value="/resources/css/home.css" />" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>

<body>
<form:form method="POST" modelAttribute="user" class="box login">
    <fieldset class="boxBody">
        <form:label path="name"> Username </form:label>
        <form:input path="name"/>
        <form:label path="password"> Password </form:label>
        <form:password path="password"/>
        <c:if test="${not empty message}">
            <span style="float: right" class="error">${message}</span>
        </c:if>
    </fieldset>

    <footer>
        <input type="submit" class="btnLogin" value="Create" name="_eventId_submit">
        <input type="submit" class="btnLogin" value="Cancel" name="_eventId_cancel">
    </footer>
</form:form>
</body>
</html>
