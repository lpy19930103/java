<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<c:if test="${empty loginUser}">
    <li><a href="${pageContext.request.contextPath}/UserServlet?method=loginUI">登录</a></li>
    <li><a href="${pageContext.request.contextPath}/UserServlet?method=registUI">注册</a></li>
</c:if>
<c:if test="${not empty loginUser}">
    欢迎：${loginUser.name},
    <li><a href="${pageContext.request.contextPath}/jsp/cart.jsp">购物车</a></li>
    <li><a href="${pageContext.request.contextPath}/jsp/order_list.jsp">我的订单</a></li>
    <li><a href="${pageContext.request.contextPath}/UserServlet?method=logout">退出</a></li>

</c:if>


