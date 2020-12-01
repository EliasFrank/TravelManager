<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<%--${pageContext.request.contextPath}--%>
<%--<a href="${pageContext.request.contextPath}/product/findAll.do">查询所有商品</a>--%>
    <jsp:forward page="/pages/main.jsp"></jsp:forward>
</body>
</html>
