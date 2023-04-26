<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.swing.*" %>
<%@ page import="com.google.gson.JsonElement" %>
<%@ page import="com.google.gson.JsonObject" %>
<%@page import="com.example.jsp_project.bean.Venue"%>
<%@page import="java.util.ArrayList"%>
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
        String chartData1 = (String) request.getAttribute("chartData1");
        String venueID = (String) request.getAttribute("venueID");
        String dateType = (String) request.getAttribute("dateType");
    %>
    <jsp:include page="component/ManagerNav.jsp"></jsp:include>
    <jsp:include page="component/ReportNav.jsp"></jsp:include>


        <div class="main_content">
            <form class="container" method='post' action='showGraphController' >
                <input type="hidden" name="action" value="showGraph">
            <select class="container form-select-lg mb-4 w-25 p-3" name="venueID" id="venueID">
                <option>Open this select menu</option>
                <%
                    ArrayList<Venue> venues = (ArrayList<Venue>)request.getAttribute("venues");
                    if(venues.size() != 0) {
                        for (int i = 0; i < venues.size(); i++) {
                            Venue v = (Venue) venues.get(i);
                            out.println("<option value='"+v.getVenueID()+"'>" + v.getVenueID() + "</option>");
                        }
                    }
                %>

            </select>

            <select class="container form-select-lg mb-4 w-25 p-3"  name="dateType">
                <option value="Monthly">Monthly</option>
                <option value="Yearly">Yearly</option>
            </select>
                <button type="submit" class="btn btn-dark btn-lg">Enter</button>
            </form>
            <div class="container">
                <h1>Venue ID: <%=venueID != null ?venueID : ""%> <%=venueID != null ?dateType : ""%></h1>
            </div>
        <div id="chartDiv" style="width:45%" >
            <canvas id="myChart" ></canvas>
            <div id="chart" >
                <h5 ><%=venueID != null ?"Income by each venue": ""%></h5>
            <canvas id="myChart1" ></canvas>
            </div>
        </div>

        </div>

</div>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</body>
</html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script>

    const ctx = document.getElementById('myChart');
    const ctx1 = document.getElementById('myChart1');

    chartData = JSON.parse('<%= chartData %>');
    chartData1 = JSON.parse('<%= chartData1 %>');

    new Chart(ctx, {
        type: 'bar',
        data: {
            labels: chartData.map(function (d) { return d.labels; }),
            datasets: [{
                label: 'Booking Rate of the Selected Venue',
                data: chartData.map(function (d) { return d.data; }),
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
    new Chart(ctx1, {
        type: 'doughnut',
        data: {
            labels: chartData1.map(function (d) { return d.labels; }),
            datasets: [{
                label: 'Booking Income of the Selected Venue',
                data: chartData1.map(function (d) { return d.data; }),
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
<%--<script src="js/report.js"></script>--%>
<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">--%>
<%--</script>--%>