<%@page contentType="text/html; charset=utf-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" class="crt crt-nav-on crt-nav-type1 crt-main-nav-on crt-sidebar-on crt-layers-2">
<head>
    <meta charset="utf-8">
    <title>${user.name}-首页</title>
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
                    <section class="section">
                        <div class="crt-card crt-card-wide bg-primary text-center">
                            <div class="crt-card-avatar">
                                <c:choose>
                                    <c:when test="${empty user.photo}">
                                        <img lass="avatar avatar-195" width="195" height="195" src="${ctx}/asset/admin/img/noimage.png" alt="">
                                    </c:when>
                                    <c:otherwise>
                                        <img lass="avatar avatar-195" width="195" height="195" src="${ctx}/${user.photo}" alt="">
                                    </c:otherwise>
                                </c:choose>
                               </div>
                            <div class="crt-card-info">
                                <h2 class="text-upper">${user.name}</h2>
                                <p class="text-muted">${user.job}</p>
                                <ul class="crt-social clear-list">
                                    <li><a><span class="crt-icon crt-icon-wechat"></span></a></li>
                                    <li><a><span class="crt-icon crt-icon-qq"></span></a></li>
                                    <li><a><span class="crt-icon crt-icon-weibo"></span></a></li>
                                    <li><a><span class="crt-icon crt-icon-github"></span></a></li>
                                    <li><a><span class="crt-icon crt-icon-blog"></span></a></li>
                                </ul>
                            </div>
                        </div>
                    </section><!-- .section -->
                    <section class="section brd-btm padd-box">
                        <div class="row">
                            <div class="col-sm-12 clear-mrg text-box"><h2 class="title-lg text-upper">关于我</h2>
                                <p><b>哈罗，我是${user.name}！</b><br>${user.intro}</p>
                            </div>
                        </div>
                    </section><!-- .section -->
                    <section class="section brd-btm padd-box">
                        <div class="row">
                            <div class="col-sm-12 clear-mrg">
                                <h2 class="title-thin text-muted">个人信息</h2>
                                <dl class="dl-horizontal clear-mrg">
                                    <dt class="text-upper">姓名</dt>
                                    <dd>${user.name}</dd>
                                    <dt class="text-upper">生日</dt>
                                    <dd>${user.birthday}</dd>
                                    <dt class="text-upper">住址</dt>
                                    <dd>${user.address}</dd>
                                    <dt class="text-upper">邮箱</dt>
                                    <dd><a href="mailto:${user.email}">${user.email}</a></dd>
                                    <dt class="text-upper">电话</dt>
                                    <dd>${user.phone}</dd>
                                </dl>
                            </div><!-- .col-sm-6 -->
                        </div><!-- .row -->
                    </section><!-- .section -->
                    <section class="section brd-btm padd-box">
                        <div class="row">
                            <div class="col-sm-12 clear-mrg">
                                <h2 class="title-thin text-muted">专业技能</h2>
                                <c:forEach items="${skills}" var="skill">
                                    <div class="progress-line crt-animate">
                                        <strong class="progress-title">${skill.name}</strong>
                                        <div class="progress-bar" data-text="${skill.getTypeString}" data-value="${(skill.leave+ 1 * 0.25)}"></div>
                                    </div>
                                </c:forEach>
                            </div><!-- .col-sm-6 -->
                        </div><!-- .row -->
                    </section><!-- .section -->
                    <section class="section brd-btm padd-box">
                        <div class="row">
                            <div class="col-sm-12 clear-mrg">
                                <h2 class="title-thin text-muted">个人特质</h2>
                                <ul class="styled-list icon-list-col3 clear-mrg">
                                    <c:forEach items="${trait}" var="item">
                                        <li>${item}</li>
                                    </c:forEach>
                                </ul>
                            </div><!-- .col-sm-6 --></div><!-- .row --></section><!-- .section -->
                    <section class="section brd-btm padd-box">
                        <div class="row">
                            <div class="col-sm-12 clear-mrg">
                                <h2 class="title-thin text-muted">兴趣爱好</h2>
                                <ul class="icon-list icon-list-col3 clearfix">
                                    <c:forEach items="${interests}" var="item">
                                        <li><span class="crt-icon crt-icon-check-circle"></span>${item}</li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </section><!-- .section -->
                    <section class="section padd-box">
                        <h2 class="title-thin text-muted">获奖成就</h2>
                        <div class="row">
                            <c:forEach items="${awards}" var="award">
                                <div class="col-sm-6 clear-mrg">
                                    <div class="award-box">
                                        <c:choose>
                                            <c:when test="${empty award.photo}">
                                                <img lass="avatar"  src="${ctx}/asset/admin/img/noimage.png" alt="">
                                            </c:when>
                                            <c:otherwise>
                                                <img lass="avatar" src="${ctx}/${award.photo}" alt="">
                                            </c:otherwise>
                                        </c:choose>
                                        <img class="award-img" src="${ctx}/asset/front/img/awards/award00.jpg" alt="">
                                        <h3 class="award-title">${award.name}</h3>
                                        <div class="award-text text-muted clear-mrg"><p>${award.intro}</p></div>
                                    </div>
                                </div><!-- .col-sm-6 -->
                            </c:forEach>
                        </div><!-- .row -->
                    </section><!-- .section -->
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