<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="resources.content" var="rb"/>
<html>
<head><title><fmt:message key="Label.tablesTitle" bundle="${rb}"/></title></head>
<body>
    <h1> ${parserName} </h1>
    <table border="1" cellspacing="0">
        <tr>
            <td><b> <fmt:message key="Table.candyType" bundle="${rb}"/> </b></td>
            <td><b> <fmt:message key="Table.name" bundle="${rb}"/></b></td>
            <td><b> <fmt:message key="Table.type" bundle="${rb}"/> </b></td>
            <td><b> <fmt:message key="Table.energy" bundle="${rb}"/> </b></td>
            <td><b> <fmt:message key="Table.production" bundle="${rb}"/> </b></td>
            <td><b> <fmt:message key="Table.valueFats" bundle="${rb}"/> </b></td>
            <td><b> <fmt:message key="Table.valueProteins" bundle="${rb}"/> </b></td>
            <td><b> <fmt:message key="Table.valueCarbohydrates" bundle="${rb}"/> </b></td>
            <td><b> <fmt:message key="Table.ingWater" bundle="${rb}"/> </b></td>
            <td><b> <fmt:message key="Table.ingSugar" bundle="${rb}"/> </b></td>
            <td><b> <fmt:message key="Table.ingJelly" bundle="${rb}"/> </b></td>
        </tr>
        <c:forEach var="elem" items="${lstJelly}" varStatus="status">
            <tr>
                <td><fmt:message key="Type.jelly" bundle="${rb}"/></td>
                <td><c:out value="${ elem.name}" /></td>
                <td><c:out value="${ elem.type }" /></td>
                <td><c:out value="${ elem.energy }" /></td>
                <td><c:out value="${ elem.production}" /></td>
                <td><c:out value="${ elem.value.fats }" /></td>
                <td><c:out value="${ elem.value.proteins }" /></td>
                <td><c:out value="${ elem.value.carbohydrates}" /></td>
                <td><c:out value="${ elem.ingredients.water }" /></td>
                <td><c:out value="${ elem.ingredients.sugar }" /></td>
                <td><c:out value="${ elem.ingredients.jelly }" /></td>
            </tr>
        </c:forEach>
    </table>

    <table border="1" cellspacing="0">
        <tr>
            <td><b> <fmt:message key="Table.candyType" bundle="${rb}"/> </b></td>
            <td><b> <fmt:message key="Table.name" bundle="${rb}"/></b></td>
            <td><b> <fmt:message key="Table.type" bundle="${rb}"/> </b></td>
            <td><b> <fmt:message key="Table.energy" bundle="${rb}"/> </b></td>
            <td><b> <fmt:message key="Table.production" bundle="${rb}"/> </b></td>
            <td><b> <fmt:message key="Table.valueFats" bundle="${rb}"/> </b></td>
            <td><b> <fmt:message key="Table.valueProteins" bundle="${rb}"/> </b></td>
            <td><b> <fmt:message key="Table.valueCarbohydrates" bundle="${rb}"/> </b></td>
            <td><b> <fmt:message key="Table.ingWater" bundle="${rb}"/> </b></td>
            <td><b> <fmt:message key="Table.ingSugar" bundle="${rb}"/> </b></td>
            <td><b> <fmt:message key="Table.ingChoc" bundle="${rb}"/> </b></td>
        </tr>
        <c:forEach var="elem" items="${lstChoc}" varStatus="status">
            <tr>
                <td><fmt:message key="Type.choc" bundle="${rb}"/></td>
                <td><c:out value="${ elem.name}" /></td>
                <td><c:out value="${ elem.type }" /></td>
                <td><c:out value="${ elem.energy }" /></td>
                <td><c:out value="${ elem.production}" /></td>
                <td><c:out value="${ elem.value.fats }" /></td>
                <td><c:out value="${ elem.value.proteins }" /></td>
                <td><c:out value="${ elem.value.carbohydrates}" /></td>
                <td><c:out value="${ elem.ingredients.water }" /></td>
                <td><c:out value="${ elem.ingredients.sugar }" /></td>
                <td><c:out value="${ elem.ingredients.cocoa }" /></td>
            </tr>
        </c:forEach>
    </table>
    <form name="BackForm" action="controller" method="POST">
        <input type="hidden" name="command" value="back">
        <input type="hidden" name="backPage" value="/jsp/result.jsp">
        <input type="submit" name="backButton" value=<fmt:message key="Button.back" bundle="${rb}"/> />
    </form>
</body>
</html>
