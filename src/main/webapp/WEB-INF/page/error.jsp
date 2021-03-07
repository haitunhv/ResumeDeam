<%@page contentType="text/html; charset=utf-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <title>-error</title>
    <%@ include file="admin/common/head.jsp"%>
</head>
<body class="five-zero-zero">
    <div class="five-zero-zero-container">
        <div class="error-title">喔豁，出错了</div>
        <div class="error-msg">${error}</div>
        <div class="button-place">
            <a href="#" class="btn btn-default btn-lg waves-effect">回到首页</a>
        </div>
    </div>
</body>

</html>