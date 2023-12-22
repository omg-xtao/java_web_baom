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
    <link rel="stylesheet" type="text/css" href="../styles/basic.css"/>
</head>
<body>
<%@ include file="../includes/header.jsp" %>
<div id="content">
    <div id="left">
    </div>
    <div id="right">
        <h1>${title}</h1>
        <div class="operation">请您认真填写报考信息↓：
            <span class="mess">
                <c:if test="${'stuEntryMess' eq sessionScope.mess.name}">${sessionScope.mess.content}</c:if>
            </span>
        </div>
        <div class="ft">
            <form method="post" action="${pageContext.request.contextPath}/stu/entry.do?action=entry">
                <fieldset>
                    <legend> 报考信息 </legend>
                    <table>
                        <tr>
                            <td class="label">报考专业：</td>
                            <td>
                                <select name="mname" id="mname">
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
                            </td>
                        </tr>
                    </table>
                </fieldset>
                <fieldset>
                    <legend> 个人基本信息 </legend>
                    <table>
                        <tr>
                            <td class="label">姓名：</td>
                            <td>
                                <input type="text" name="sname" id="sname" value="${requestScope.reginfo.sname}"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="label">性别：</td>
                            <td>
                                <c:choose>
                                    <c:when test="${requestScope.reginfo.ssex == '男'}">
                                        <input type="radio" name="ssex" id="ssex" value="男" checked="checked"/>男
                                        <input type="radio" name="ssex" id="ssex" value="女"/>女
                                    </c:when>
                                    <c:otherwise>
                                        <input type="radio" name="ssex" id="ssex" value="男"/>男
                                        <input type="radio" name="ssex" id="ssex" value="女" checked="checked"/>女
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                        <tr>
                            <td class="label">出生日期：</td>
                            <td><input type="date" name="birthday" id="birthday" value="${requestScope.reginfo.birthday}"></td>
                        </tr>
                        <tr>
                            <td class="label">民族：</td>
                            <td><input type="text" name="nation" id="nation" value="${requestScope.reginfo.nation}" ></td>
                        </tr>
                        <tr>
                            <td class="label">身份证号：</td>
                            <td><input type="text" name="idcode" id="idcode" value="${requestScope.reginfo.idcode}" ></td>
                        </tr>
                        <tr>
                            <td class="label">政治面貌：</td>
                            <td><input type="text" name="political" id="political" value="${requestScope.reginfo.political}"></td>
                        </tr>
                        <tr>
                            <td class="label">生源地：</td>
                            <td><input type="text" name="source" id="source" value="${requestScope.reginfo.source}"></td>
                        </tr>
                        <tr>
                            <td class="label">家庭住址：</td>
                            <td><input type="text" name="homeaddr" id="homeaddr" value="${requestScope.reginfo.homeaddr}"></td>
                        </tr>
                    </table>
                </fieldset>
                <fieldset>
                    <legend> 教育背景 </legend>
                    <table>
                        <tr>
                            <td class="label">毕业院校</td>
                            <td><input type="text" name="school" id="school" value="${requestScope.reginfo.school}"></td>
                        </tr>
                        <tr>
                            <td class="label">毕业时间</td>
                            <td><input type="date" name="gradutetime" id="gradutetime" value="${requestScope.reginfo.gradutetime}"></td>
                        </tr>
                        <tr>
                            <td class="label">是否应届</td>
                            <td>
                                <c:choose>
                                    <c:when test="${requestScope.reginfo.isnew}">
                                        <input type="radio" name="isnew" id="isnew" value="1" checked="checked"/>应届
                                        <input type="radio" name="isnew" id="isnew" value="0"/>往届
                                    </c:when>
                                    <c:otherwise>
                                        <input type="radio" name="isnew" id="isnew" value="1"/>应届
                                        <input type="radio" name="isnew" id="isnew" value="0" checked="checked"/>往届
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                        <tr>
                            <td class="label">文理科</td>
                            <td>
                                <c:choose>
                                    <c:when test="${requestScope.reginfo.aos == '理科'}">
                                        <input type="radio" name="aos" id="aos" value="理科" checked="checked"/>理科
                                        <input type="radio" name="aos" id="aos" value="文科"/>文科
                                    </c:when>
                                    <c:otherwise>
                                        <input type="radio" name="aos" id="aos" value="理科"/>理科
                                        <input type="radio" name="aos" id="aos" value="文科" checked="checked"/>文科
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                        <tr>
                            <td class="label">所学专业</td>
                            <td><input type="text" name="major" id="major" value="${requestScope.reginfo.major}"></td>
                        </tr>
                        <tr>
                            <td class="label">英语46级</td>
                            <td>
                                <c:choose>
                                    <c:when test="${requestScope.reginfo.cet == '无'}">
                                        <input type="radio" name="cet" id="cet" value="无" checked="checked"/>无
                                        <input type="radio" name="cet" id="cet" value="四级"/>四级
                                        <input type="radio" name="cet" id="cet" value="六级"/>六级
                                    </c:when>
                                    <c:when test="${requestScope.reginfo.cet == '四级'}">
                                        <input type="radio" name="cet" id="cet" value="无"/>无
                                        <input type="radio" name="cet" id="cet" value="四级" checked="checked"/>四级
                                        <input type="radio" name="cet" id="cet" value="六级"/>六级
                                    </c:when>
                                    <c:otherwise>
                                        <input type="radio" name="cet" id="cet" value="无"/>无
                                        <input type="radio" name="cet" id="cet" value="四级"/>四级
                                        <input type="radio" name="cet" id="cet" value="六级" checked="checked"/>六级
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </table>
                </fieldset>
                <fieldset>
                    <legend> 联系信息 </legend>
                    <table>
                        <tr>
                            <td class="label">手机号</td>
                            <td><input type="text" name="mobile" id="mobile" value="${requestScope.reginfo.mobile}"></td>
                        </tr>
                        <tr>
                            <td class="label">联系电话</td>
                            <td><input type="text" name="telphone" id="telphone" value="${requestScope.reginfo.telphone}"></td>
                        </tr>
                        <tr>
                            <td class="label">邮编</td>
                            <td><input type="text" name="zipcode" id="zipcode" value="${requestScope.reginfo.zipcode}"></td>
                        </tr>
                        <tr>
                            <td class="label">联系地址</td>
                            <td><input type="text" name="conaddr" id="conaddr" value="${requestScope.reginfo.conaddr}"></td>
                        </tr>
                        <tr>
                            <td class="label">接收人</td>
                            <td><input type="text" name="receiver" id="receiver" value="${requestScope.reginfo.receiver}"></td>
                        </tr>
                    </table>
                </fieldset>
                <table>
                    <tr>
                        <td colspan="2">
                            <input type="submit" value="保存并下一步" class="button" />
                            <input type="reset" value="重置" class="button" />
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    <%@ include file="../includes/footer.jsp" %>
</body>
</html>
