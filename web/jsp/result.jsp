<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="resources.content" var="rb"/>
<html>
    <head>
        <title><fmt:message key="Label.resultTitle" bundle="${rb}" /></title>
    </head>
    <body>
        <p><fmt:message key="Label.yourLogin" bundle="${rb}" /> ${login} </p>

        <form name="ParseForm" action="controller" method="POST">
            <input type="hidden" name="command" value="parse">
            <input type="hidden" name="page" value="/jsp/result.jsp">
            <select name="selector">
                <option value="DOM">DOM</option>
                <option value="SAX">SAX</option>
                <option value="STAX">STAX</option>
            </select>
            <input type="submit" name="parseButton" value=<fmt:message key="Button.parse" bundle="${rb}" />>
        </form>
        <form name="LocalizeForm" action="controller" method="POST">
            <input type="hidden" name="command" value="locale">
            <input type="hidden" name="page" value="/jsp/result.jsp">
            <input type="submit" name="localizeButtonMainRus" value=<fmt:message key="Button.localizeRus" bundle="${rb}"/> />
            <input type="submit" name="localizeButtonMainEng" value=<fmt:message key="Button.localizeEng" bundle="${rb}"/> />
        </form>
        <form name="BackForm" action="controller" method="POST">
            <input type="hidden" name="command" value="back">
            <input type="hidden" name="backPage" value="/jsp/index.jsp">
            <input type="submit" name="backButton" value=<fmt:message key="Button.back" bundle="${rb}"/> />
        </form>
    </body>
</html>