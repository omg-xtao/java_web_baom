<%--
  Created by IntelliJ IDEA.
  User: xtaod
  Date: 2023/12/22
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<c:set var="title" value="我的报名信息"/>
<c:set var="webroot" value="${pageContext.request.contextPath}"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>${title}</title>
    <link rel="stylesheet" href="${webroot}/styles/bootstrap.min.css" crossorigin="anonymous">
    <script src="${webroot}/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="${webroot}/styles/sidebar.css" crossorigin="anonymous">
    <link rel="stylesheet" href="${webroot}/styles/index.css" crossorigin="anonymous">
    <link rel="stylesheet" href="${webroot}/styles/entry.css" crossorigin="anonymous">
</head>
<body>
<main class="d-flex flex-nowrap">
    <%@ include file="../includes/header.jsp" %>

    <main class="form-signin w-100 m-auto scrollspy" style="min-width: 600px">
        <form action="${webroot}/stu/entry.do?action=entry" method="post">
            <img class="mb-4" src="${webroot}/images/logo.jpg" alt="" width="72" height="72">
            <h1 class="h3 mb-3 fw-normal">请填写报考信息</h1>

            <c:if test="${not empty requestScope.stuEntryMess}">
                <div class="alert alert-warning" role="alert">
                        ${requestScope.stuEntryMess}
                </div>
            </c:if>

            <h5>报考信息</h5>
            <div class="input-group mb-3">
                <span class="input-group-text">报考专业</span>
                <select class="form-select" name="mname" id="mname">
                    <c:forEach items="${applicationScope.majors}" var="major">
                        <c:choose>
                            <c:when test="${major.mname == requestScope.reginfo.mname}">
                                <option value="${major.mname}" selected='selected'> ${major.mname}
                                </option>
                            </c:when>
                            <c:otherwise>
                                <option value="${major.mname}">${major.mname}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>
            <h5>个人基本信息</h5>
            <div class="input-group mb-3">
                <span class="input-group-text">姓名</span>
                <input type="text" class="form-control" name="sname" id="sname" value="${requestScope.reginfo.sname}">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">性别</span>
                <select class="form-select" name="ssex" id="ssex">
                    <c:choose>
                        <c:when test="${requestScope.reginfo.ssex == '男'}">
                            <option value="男" selected='selected'>男</option>
                            <option value="女">女</option>
                        </c:when>
                        <c:otherwise>
                            <option value="男">男</option>
                            <option value="女" selected='selected'>女</option>
                        </c:otherwise>
                    </c:choose>
                </select>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">出生日期</span>
                <input type="date" class="form-control" name="birthday" id="birthday"
                       value="${requestScope.reginfo.birthday}">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">民族</span>
                <input type="text" class="form-control" name="nation" id="nation"
                       value="${requestScope.reginfo.nation}">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">身份证号</span>
                <input type="text" class="form-control" name="idcode" id="idcode"
                       value="${requestScope.reginfo.idcode}">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">政治面貌</span>
                <select class="form-select" name="political" id="political">
                    <c:set var="politicals" value="${{'群众', '共青团员', '共产党员'}}"/>
                    <c:forEach items="${politicals}" var="pol">
                        <c:choose>
                            <c:when test="${pol == requestScope.reginfo.political}">
                                <option value="${pol}" selected='selected'>${pol}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${pol}">${pol}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">生源地</span>
                <input type="text" class="form-control" name="source" id="source"
                       value="${requestScope.reginfo.source}">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">家庭住址</span>
                <input type="text" class="form-control" name="homeaddr" id="homeaddr"
                       value="${requestScope.reginfo.homeaddr}">
            </div>
            <h5>教育背景</h5>
            <div class="input-group mb-3">
                <span class="input-group-text">毕业院校</span>
                <input type="text" class="form-control" name="school" id="school"
                       value="${requestScope.reginfo.school}">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">毕业时间</span>
                <input type="date" class="form-control" name="gradutetime" id="gradutetime"
                       value="${requestScope.reginfo.gradutetime}">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">是否应届</span>
                <select class="form-select" ame="isnew" id="isnew">
                    <c:choose>
                        <c:when test="${requestScope.reginfo.isnew}">
                            <option value="1" selected='selected'>应届</option>
                            <option value="0">往届</option>
                        </c:when>
                        <c:otherwise>
                            <option value="1">应届</option>
                            <option value="0" selected='selected'>往届</option>
                        </c:otherwise>
                    </c:choose>
                </select>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">文理科</span>
                <select class="form-select" name="aos" id="aos">
                    <c:choose>
                        <c:when test="${requestScope.reginfo.aos == '理科'}">
                            <option value="理科" selected='selected'>理科</option>
                            <option value="文科">文科</option>
                        </c:when>
                        <c:otherwise>
                            <option value="理科">理科</option>
                            <option value="文科" selected='selected'>文科</option>
                        </c:otherwise>
                    </c:choose>
                </select>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">所学专业</span>
                <input type="text" class="form-control" name="major" id="major" value="${requestScope.reginfo.major}">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">英语等级</span>
                <select class="form-select" name="cet" id="cet">
                    <c:set var="cets" value="${{'无', '四级', '六级'}}"/>
                    <c:forEach items="${cets}" var="cet">
                        <c:choose>
                            <c:when test="${cet == requestScope.reginfo.cet}">
                                <option value="${cet}" selected='selected'>${cet}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${cet}">${cet}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>
            <h5>联系人信息</h5>
            <div class="input-group mb-3">
                <span class="input-group-text">收件人姓名</span>
                <input type="text" class="form-control" name="receiver" id="receiver"
                       value="${requestScope.reginfo.receiver}">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">收件人地址</span>
                <input type="text" class="form-control" name="conaddr" id="conaddr"
                       value="${requestScope.reginfo.conaddr}">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">邮编</span>
                <input type="text" class="form-control" name="zipcode" id="zipcode"
                       value="${requestScope.reginfo.zipcode}">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">手机号</span>
                <input type="text" class="form-control" name="mobile" id="mobile"
                       value="${requestScope.reginfo.mobile}">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">备用电话</span>
                <input type="text" class="form-control" name="telphone" id="telphone"
                       value="${requestScope.reginfo.telphone}">
            </div>

            <input class="btn btn-primary w-100 py-2" type="submit" id="submit" value="保存并下一步">
            <br/><br/>
            <input class="btn btn-primary w-100 py-2" type="reset" id="reset">
            <br/><br/>
        </form>
    </main>
</main>
</body>
</html>
