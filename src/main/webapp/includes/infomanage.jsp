<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<script>
    const chartDom = document.getElementById('chart');
    const myChart = echarts.init(chartDom);
    let option;

    option = {
        title: {
            text: "专业信息"
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow'
            }
        },
        legend: {
            data: ['计划招生人数', '实际报考人数', '录取人数']
        },
        toolbox: {
            show: true,
            orient: 'vertical',
            left: 'right',
            top: 'center',
            feature: {
                mark: {show: true},
                dataView: {show: true, readOnly: false},
                magicType: {show: true, type: ['line', 'bar', 'stack']},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        xAxis: [
            {
                type: 'category',
                axisTick: {show: false},
                data: [
                    <c:forEach items="${applicationScope.majors}" var="major" varStatus="row">
                    <c:choose>
                    <c:when test="${row.index == 0}">
                    '${major.mname}'
                    </c:when>
                    <c:otherwise>
                    , '${major.mname}'
                    </c:otherwise>
                    </c:choose>
                    </c:forEach>
                ]
            }
        ],
        yAxis: [
            {
                type: 'value'
            }
        ],
        series: [
            {
                name: '计划招生人数',
                type: 'bar',
                barGap: 0,
                emphasis: {
                    focus: 'series'
                },
                data: [
                    <c:forEach items="${applicationScope.majors}" var="major" varStatus="row">
                    <c:choose>
                    <c:when test="${row.index == 0}">
                    '${major.plannum}'
                    </c:when>
                    <c:otherwise>
                    , '${major.plannum}'
                    </c:otherwise>
                    </c:choose>
                    </c:forEach>
                ]
            },
            {
                name: '实际报考人数',
                type: 'bar',
                emphasis: {
                    focus: 'series'
                },
                data: [
                    <c:forEach items="${applicationScope.majors}" var="major" varStatus="row">
                    <c:choose>
                    <c:when test="${row.index == 0}">
                    '${major.applynum}'
                    </c:when>
                    <c:otherwise>
                    , '${major.applynum}'
                    </c:otherwise>
                    </c:choose>
                    </c:forEach>
                ]
            },
            {
                name: '录取人数',
                type: 'bar',
                emphasis: {
                    focus: 'series'
                },
                data: [
                    <c:forEach items="${applicationScope.majors}" var="major" varStatus="row">
                    <c:choose>
                    <c:when test="${row.index == 0}">
                    '${major.admitnum}'
                    </c:when>
                    <c:otherwise>
                    , '${major.admitnum}'
                    </c:otherwise>
                    </c:choose>
                    </c:forEach>
                ]
            }
        ]
    };

    option && myChart.setOption(option);
</script>