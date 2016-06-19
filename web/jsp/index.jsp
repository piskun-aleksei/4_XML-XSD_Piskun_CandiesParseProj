<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="resources.content" var="rb"/>
<html>
    <head>
        <title><fmt:message key="Label.title" bundle="${rb}"/></title>
    </head>
    <body>
        <h5><fmt:message key="Label.welcome" bundle="${rb}" /></h5>
        <form name="LoginForm" action="controller" method="POST">
            <input type="hidden" name="command" value="login">
            <input type="hidden" name="page" value="/jsp/index.jsp">
            <input type="text" name="login"/>
            <input type="password" name="password"/>
            <input type="submit" name="loginButton" value=<fmt:message key="Button.login" bundle="${rb}" /> />
        </form>
        <form name="RegisterForm" action="controller" method="POST">
            <input type="hidden" name="command" value="register">
            <input type="hidden" name="page" value="/jsp/index.jsp">
            <input type="text" name="login"/>
            <input type="password" name="password"/>
            <input type="submit" name="registerButton" value=<fmt:message key="Button.register" bundle="${rb}" /> />
        </form>
        <form name="LocalizeForm" action="controller" method="POST">
            <input type="hidden" name="command" value="locale">
            <input type="hidden" name="page" value="/jsp/index.jsp">
            <input type="submit" name="localizeButtonMainRus" value=<fmt:message key="Button.localizeRus" bundle="${rb}"/> />
            <input type="submit" name="localizeButtonMainEng" value=<fmt:message key="Button.localizeEng" bundle="${rb}"/> />
        </form>

    </body>
</html>