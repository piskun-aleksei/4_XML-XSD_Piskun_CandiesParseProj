<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="resources.content" var="rb"/>
<html>
<head>
    <title><fmt:message key="Label.errorTitle" bundle="${rb}" /></title>
</head>
<body>
    <h1>${message}</h1>
    <form name="BackForm" action="controller" method="POST">
        <input type="hidden" name="command" value="back">
        <input type="hidden" name="backPage" value="/${page}">
        <input type="submit" name="backButton" value=<fmt:message key="Button.back" bundle="${rb}"/> />
    </form>
</body>
</html>
