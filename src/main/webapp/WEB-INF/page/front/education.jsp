<%@page contentType="text/html; charset=utf-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en" class="crt crt-nav-on crt-nav-type1 crt-main-nav-on crt-sidebar-on crt-layers-2">
<head>
    <meta charset="utf-8">
    <title>${user.name}-教育经验</title>
<%@include file="common/head.jsp"%>
</head>
<body class="">
<div class="crt-wrapper">
    <%@include file="common/smallNav.jsp"%>
    <div id="crt-container" class="crt-container">
        <%@include file="common/bigNav.jsp"%>
        <div class="crt-container-sm">
            <div class="crt-paper-layers">
                <div class="crt-paper clear-mrg">
                    <div class="crt-paper-cont paper-padd clear-mrg">
                        <h2 class="title-lg text-upper padd-box">教育经验</h2>
                        <c:forEach items="${educations}" var="education">
                            <div class="education">
                                <div class="education-box">
                                    <time class="education-date">
                                    <span>
                                        <strong class="text-upper">
                                            <fmt:formatDate value="${education.beginDay}" pattern="yyyy"/>
                                        </strong>/ <fmt:formatDate value="${education.beginDay}" pattern="MM"/> -
                                        <strong>
                                             <fmt:formatDate value="${education.endDay}" pattern="yyyy"/>
                                        </strong>/ <fmt:formatDate value="${education.endDay}" pattern="MM"/>
                                    </span>
                                    </time>
                                    <h3>${education.typeString}</h3>
                                    <span class="education-company">${education.name}</span>
                                    <p>${education.intro}</p>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <!-- .crt-paper -->
            </div><!-- .crt-paper-layers -->
        </div><!-- .crt-container-sm -->
    </div>
    <!-- .crt-container -->
    <%@include file="common/website.jsp"%>
</div><!-- .crt-wrapper --><!-- Scripts -->
<%@include file="common/foot.jsp"%>
</body>
</html>