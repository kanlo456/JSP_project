<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.swing.*" %>
<%@ page import="com.google.gson.JsonElement" %>
<%@ page import="com.google.gson.JsonObject" %>
<%--<jsp:useBean id="chartData" scope="page" class="com.example.jsp_project.bean.ChartData" />--%>
<html>
<head>
    <title>Report</title>
    <link rel="stylesheet" href="css/report.css">
    <link rel="stylesheet" href="css/ManagerNav.css">
    <link rel="stylesheet" href="bootstrap-5.3.0/css/bootstrap.css">

</head>
<body>
<div>
    <%
        String chartData = (String) request.getAttribute("chartData");
    %>
    <jsp:include page="component/ManagerNav.jsp"></jsp:include>
    <div class="main_content">
        <jsp:include page="component/ReportNar.jsp"></jsp:include>
    </div>
    <div id="chartDiv" style="width:70%">
        <canvas id="myChart"></canvas>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</body>
</html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script>

    const ctx = document.getElementById('myChart');

    chartData = JSON.parse('<%= chartData %>');

    new Chart(ctx, {
        type: 'bar',
        data: {
            labels: chartData.map(function (d) {
                return d.labels;
            }),
            datasets: [{
                label: 'Booking Records of the Selected Venue',
                data: chartData.map(function (d) {
                    return d.data;
                }),
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
</script>
<script src="js/report.js"></script>