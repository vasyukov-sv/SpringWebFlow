<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
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
        <form:label path="name"> Username </form:label>
        <form:input path="name"/>
        <form:label path="password"> Password </form:label>
        <form:password path="password"/>
    </fieldset>

    <footer>
        <input type="submit" class="btnLogin" value="Login" name="_eventId_submit">
    </footer>
</form:form>
</body>
</html>
