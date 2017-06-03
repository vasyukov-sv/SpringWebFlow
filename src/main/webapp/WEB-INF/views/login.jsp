<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/home.css" />" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>

<body>
<form:form method="POST" modelAttribute="user" class="box login">
    <fieldset class="boxBody">
        <span style="float: right">
            <a href="?lang=en"><spring:message code="en"/></a>
            <a href="?lang=ru"><spring:message code="ru"/></a>
        </span>

        <form:label path="name">
            <spring:message code="username"/>
        </form:label>
        <form:input path="name"/>

        <form:label path="password">
            <spring:message code="password"/>
        </form:label>
        <form:password path="password"/>

        <c:if test="${not empty message}">
            <span style="float: right" class="error">${message}</span>
        </c:if>
    </fieldset>

    <footer>
        <a href="${flowExecutionUrl}&_eventId=createUser"><spring:message code="create-user"/></a>
        <input type="submit" class="btnLogin" value="<spring:message code="login"/>" name="_eventId_submit">
    </footer>
</form:form>
</body>
</html>