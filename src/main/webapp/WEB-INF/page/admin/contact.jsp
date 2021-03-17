<%@page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <title>简历管理-留言信息</title>
    <%@ include file="common/head.jsp"%>
</head>

<body class="theme-blue">
    <%@ include file="common/middle.jsp"%>

    <section class="content">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="card">
                        <div class="header">
                            <h2>留言信息</h2>
                        </div>
                        <div class="body table-responsive">
                            <form method="post" action="${ctx}/contact/admin">
                                <input type="hidden" name="pageNo" value="${result.pageNo}">
                                <div class="menus">
                                    <div class="search-box input-group">
                                        <select name="alreadyRead">
                                            <option value="2">全部</option>
                                            <option value="1">已读</option>
                                            <option value="0">未读</option>
                                        </select>
                                        <div class="form-line datetime-input">
                                            <input type="date" name="beginDay" class="form-control" placeholder="开始日期">
                                        </div>
                                        <div class="form-line datetime-input">
                                            <input type="date" name="endDay" class="form-control" placeholder="结束日期">
                                        </div>
                                        <span class="input-group-addon">
                                        <i class="material-icons">search</i>
                                    </span>
                                        <div class="form-line keyword">
                                            <input type="text" name="keyWord" class="form-control" placeholder="主题、内容等">
                                        </div>
                                        <button type="submit" class="btn bg-blue waves-effect btn-sm">搜索</button>
                                    </div>
                                </div>

                                <c:choose test="${not empty result.contacts}">
                                    <table class="table table-bordered table-hover table-striped">
                                        <thead>
                                        <tr>
                                            <th>已读</th>
                                            <th>名称</th>
                                            <th>邮箱</th>
                                            <th>日期</th>
                                            <th>主题</th>
                                            <th>内容</th>
                                            <th>操作</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${result.contacts}" var="contact">
                                            <tr>
                                                <td>
                                                    <div class="switch">
                                                        <label>
                                                            <c:choose>
                                                                <c:when test="${contact.alreadyRead}">
                                                                    <input id="read-${contact.id}" type="checkbox" disabled checked>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <input id="read-${contact.id}"  type="checkbox" disabled>
                                                                </c:otherwise>
                                                            </c:choose>

                                                            <span class="lever switch-col-blue">

                                                        </span>
                                                        </label>
                                                    </div>
                                                </td>
                                                <td>${contact.name}</td>
                                                <td>${contact.email}</td>
                                                <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${contact.createdTime}" /></td>
                                                <td>${contact.subject}</td>
                                                <td>${contact.comment}</td>
                                                <td>
                                                    <button type="button" class="btn bg-blue waves-effect btn-xs"
                                                            onclick="view(${contact.JSON})">
                                                        <i class="material-icons">edit</i>
                                                        <span>查看</span>
                                                    </button>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>

                                    <div class="page-box">
                                        <div class="page-size">
                                            共${result.totalCount}条${result.totalPages}页，每页
                                            <select name="pageSize">
                                                <option value="10">10</option>
                                                <option value="20">20</option>
                                                <option value="30">30</option>
                                                <option value="40">40</option>
                                                <option value="50">50</option>
                                            </select>
                                            条
                                        </div>
                                        <nav>
                                            <ul class="pagination">
                                                <li id="prevPage">
                                                    <a onclick="gos(${result.pageNo - 1})">
                                                        <i class="material-icons">chevron_left</i>
                                                    </a>
                                                </li>

                                                <c:forEach begin="1" end="${result.totalPages}" var="idx">
                                                    <c:choose>
                                                        <c:when test="${ids eq pageNo}" >
                                                            <li class="active"><a>${ids}</a></li>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <li><a onclick="gos(${idx})" class="waves-effect">${idx}</a></li>
                                                        </c:otherwise>
                                                    </c:choose>


                                                </c:forEach>
                                                <li id="nextPage">
                                                    <a onclick="gos(${result.pageNo + 1})" class="waves-effect">
                                                        <i class="material-icons">chevron_right</i>
                                                    </a>
                                                </li>

                                            </ul>
                                        </nav>
                                    </div>
                                </c:if>

                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--  add-form-box  -->
    <div class="modal fade" id="view-form-box" style="display: none;">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">查看留言</h4>
                </div>
                <div class="modal-body">
                    <form method="post">
                        <div class="row">
                            <div class="col-lg-2 col-md-2 col-sm-3 col-xs-3 form-control-label">
                                <label for="name">名称</label>
                            </div>
                            <div class="col-lg-10 col-md-10 col-sm-9 col-xs-9">
                                <div class="form-group">
                                    <div class="form-line">
                                        <input type="text" id="name" name="name" maxlength="20" class="form-control"
                                               placeholder="名称"
                                               disabled>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-2 col-md-2 col-sm-3 col-xs-3 form-control-label">
                                <label for="email">邮箱</label>
                            </div>
                            <div class="col-lg-10 col-md-10 col-sm-9 col-xs-9">
                                <div class="form-group">
                                    <div class="form-line">
                                        <input type="email" id="email" name="email" maxlength="50" class="form-control"
                                               placeholder="邮箱"
                                               disabled>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-2 col-md-2 col-sm-3 col-xs-3 form-control-label">
                                <label for="createdTime">时间</label>
                            </div>
                            <div class="col-lg-10 col-md-10 col-sm-9 col-xs-9">
                                <div class="form-group">
                                    <div class="form-line">
                                        <input type="text" id="createdTime" name="createdTime" class="form-control"
                                               placeholder="时间"
                                               disabled>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-2 col-md-2 col-sm-3 col-xs-3 form-control-label">
                                <label for="subject">主题</label>
                            </div>
                            <div class="col-lg-10 col-md-10 col-sm-9 col-xs-9">
                                <div class="form-group">
                                    <div class="form-line">
                                        <input type="text" id="subject" name="subject" class="form-control"
                                               placeholder="主题" maxlength="20"
                                               disabled>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-2 col-md-2 col-sm-3 col-xs-3 form-control-label">
                                <label for="comment">内容</label>
                            </div>
                            <div class="col-lg-10 col-md-10 col-sm-9 col-xs-9">
                                <div class="form-group">
                                    <div class="form-line">
                                        <textarea name="comment" id="comment"
                                                  maxlength="1000"
                                                  cols="30" rows="5" class="form-control no-resize"
                                                  placeholder="内容" disabled></textarea>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-offset-2 col-md-offset-2 col-sm-offset-3 col-xs-offset-3">
                                <button class="btn btn-info waves-effect m-l-15" data-dismiss="modal">关闭</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="common/foot.jsp" %>
    <script>
        $(".menu .list .contact").addClass("active")
        const $viewFormBox = $("#view-form-box")
        const $viewForm = $("#view-form-box").find('form')
        function view(json) {
            $viewFormBox.modal()
            for (const k in json){
                $viewForm.find('[name = '+k+']').val(json[k])
            }

            //修改阅读状态
            $.getJSON("${ctx}/contact/read",{"id":json.id},function (data) {
                if (data.success){
                    $("#read-"+json.id).attr("checked","checked")
                }
            })
        }
        const  $form = $('#list-form');
        const  $pageSize = $('[name = pageSize]');
        $pageSize.change(function () {
            $form.submit()
        })
        //设置每页的大小
        $pageSize.val(${result.pageSize})
        //设置阅读状态
        $('[name=alreadyRead]').change(function () {
            $form.submit()
        }).val(${result.alreadyRead})
        const $pageNo = $form.find('[name=pageNo]')
        function gos(ids) {
            if (ids > ${result.totalPage} || ids < 1) return
            $pageNo.val(ids)
            $form.submit()
        }

        //上一页下一页
        if (${result.pageNo} == 1){
            $('#prevPage').addClass('disabled')
        }
        if (${result.pageNo} == ${result.totalPage}){
            $('#nextPage').addClass('disabled')
        }
    </script>
</body>

</html>
