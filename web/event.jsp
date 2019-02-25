<%--
  Created by IntelliJ IDEA.
  User: Kuba Gorczyca
  Date: 24.02.2019
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <title>Eve 2.0</title>
</head>
<body>
<header>
    <jsp:include page="WEB-INF/fragments/header.jspf"></jsp:include>
</header>

<div class="container-fluid">
    <div class="row mt-5">
        <div class="col-6 mx-auto">
            <div class="jumbotron border border-success">
                <h4 class="display-4">${requestScope.event.category}</h4>
                <hr class="my-4">
                <p class="lead">nazwa: ${requestScope.event.name}</p>
                <p class="lead">lokalizacja: ${requestScope.event.location}</p>
                <p class="lead">cena: ${requestScope.event.ticketPrice}</p>
                <p class="lead">start: ${requestScope.event.startDate}</p>
                <p class="lead">koniec: ${requestScope.event.endDate}</p>
                <hr class="my-4">
                <p class="lead">opis:</p>
                <p class="lead text-wrap">${requestScope.event.description}</p>
                <hr class="my-4">
                <p class="lead">organizator</p><a href="/DisplayingAccountController?accountType=manager&accountId=${requestScope.event.manager.id}">${requestScope.event.manager.login}</a>
                <hr class="my-4">
                <p><a class="btn btn-success" href="#" role="button">Uczestnicy</a></p>
            </div>
        </div>
    </div>

</div>




<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
</body>
</html>
