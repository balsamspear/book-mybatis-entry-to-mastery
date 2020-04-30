<%@ page import="java.util.Date" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<p>
    Hello Spring MVC!
</p>
<p>
    <%
        Date now = new Date();
    %>
    服务器时间：<fmt:formatDate value="<%=now%>" pattern="yyyy-MM-dd HH:mm:ss"/>
</p>
</body>
</html>