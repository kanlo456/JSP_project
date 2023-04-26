<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="com.example.jsp_project.bean.Booking" %>
<%@ page import="com.example.jsp_project.bean.ChartData" %>
<%@ page import="javax.swing.*" %>
<jsp:useBean id="chartData" scope="request" class="com.example.jsp_project.bean.ChartData" />
<html>
<head>
    <title>Report</title>

</head>
<body>
<div>
    <canvas id="myChart"></canvas>
</div>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</body>
</html>
<script>

    const ctx = document.getElementById('myChart');
    var chartData = <%= chartData %>;
    new Chart(ctx, {
        type: 'bar',
        data: {
            labels: chartData.labels,
            datasets: [{
                label: '# of Votes',
                data: chartData.data,
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