<%@page contentType="text/html; charset=utf-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en" class="crt crt-nav-on crt-nav-type1 crt-main-nav-on crt-sidebar-on crt-layers-2">
<head>
    <meta charset="utf-8">
    <title>${user.name}-工作经验</title>
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
                        <h2 class="title-lg text-upper padd-box">工作经验</h2>
                        <div class="education">
                            <c:forEach items="${experiences}" var="experience">
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
                                    <h3>${experience.job}</h3>
                                    <c:if test="${not empty experience.company.logo}">
                                        <div class="education-logo">
                                            <img src="${ctx}/${experience.company.logo}" alt="">
                                        </div>
                                    </c:if>

                                    <span class="education-company">${experience.company.name}</span>
                                    <p>${experience.intro}</p></div>
                            </c:forEach>

                        </div>
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