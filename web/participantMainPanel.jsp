<%--
  Created by IntelliJ IDEA.
  User: Kuba Gorczyca
  Date: 26.02.2019
  Time: 00:11
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
        <div class="col-8 mx-auto">
            <h1 class="display-1 mx-auto text-center">Szukaj wydarzeń</h1>
            <a class="btn btn-success mt-5 d-flex justify-content-center" href="/searchingEventForm.jsp" role="button">Szukaj</a>
        </div>
    </div>

    <!-- MOST POPULAR IN THIS WEEK -->

    <div class="row mt-5">
        <div class="col-8 mx-auto">
            <div class="jumbotron jumbotron-fluid rounded-pill shadow-lg border border-success">
                <div class="container text-center">
                    <h1 class="display-4">Popularne w tym tygodniu</h1>
                </div>
            </div>
        </div>
    </div>

    <div class="row mt-2">
        <div class="col-8 mx-auto">
            <div class="row mt-2">
                <div class="card mx-auto bg-dark text-white border-dark shadow" style="width: 18rem;">
                    <div class="card-header">kategoria</div>
                    <div class="card-body">
                        <h5 class="card-title">nazwa</h5>
                        <h6 class="card-subtitle mb-2 text-muted">organizator</h6>
                        <ul class="list-group list-group-flush bg-dark">
                            <li class="list-group-item bg-dark pl-0">Lokalizacja:</li>
                            <li class="list-group-item bg-dark pl-0">Cena biletu: </li>
                            <li class="list-group-item bg-dark pl-0">Start: </li>
                            <li class="list-group-item bg-dark pl-0">Koniec: </li>
                        </ul>
                        <a class="btn btn-success" href="/DisplayingThisEventController?eventId=0" role="button">Więcej</a>
                    </div>
                </div>

                <div class="card mx-auto bg-dark text-white border-dark shadow" style="width: 18rem;">
                    <div class="card-header">kategoria</div>
                    <div class="card-body">
                        <h5 class="card-title">nazwa</h5>
                        <h6 class="card-subtitle mb-2 text-muted">organizator</h6>
                        <ul class="list-group list-group-flush bg-dark">
                            <li class="list-group-item bg-dark pl-0">Lokalizacja:</li>
                            <li class="list-group-item bg-dark pl-0">Cena biletu: </li>
                            <li class="list-group-item bg-dark pl-0">Start: </li>
                            <li class="list-group-item bg-dark pl-0">Koniec: </li>
                        </ul>
                        <a class="btn btn-success" href="/DisplayingThisEventController?eventId=0" role="button">Więcej</a>
                    </div>
                </div>

                <div class="card mx-auto bg-dark text-white border-dark shadow" style="width: 18rem;">
                    <div class="card-header">kategoria</div>
                    <div class="card-body">
                        <h5 class="card-title">nazwa</h5>
                        <h6 class="card-subtitle mb-2 text-muted">organizator</h6>
                        <ul class="list-group list-group-flush bg-dark">
                            <li class="list-group-item bg-dark pl-0">Lokalizacja:</li>
                            <li class="list-group-item bg-dark pl-0">Cena biletu: </li>
                            <li class="list-group-item bg-dark pl-0">Start: </li>
                            <li class="list-group-item bg-dark pl-0">Koniec: </li>
                        </ul>
                        <a class="btn btn-success" href="/DisplayingThisEventController?eventId=0" role="button">Więcej</a>
                    </div>
                </div>
            </div>
        </div>
    </div>



    <!-- APPROACHING EVENTS -->

    <div class="row mt-5">
        <div class="col-8 mx-auto">
            <div class="jumbotron jumbotron-fluid rounded-pill shadow-lg border border-success">
                <div class="container text-center">
                    <h1 class="display-4">Zbliżające się twoje wydarzenia</h1>
                </div>
            </div>
        </div>
    </div>

    <div class="row mt-2">
        <div class="col-8 mx-auto">
            <div class="row mt-2">
        <div class="card mx-auto bg-dark text-white border-dark shadow" style="width: 18rem;">
            <div class="card-header">kategoria</div>
            <div class="card-body">
                <h5 class="card-title">nazwa</h5>
                <h6 class="card-subtitle mb-2 text-muted">organizator</h6>
                <ul class="list-group list-group-flush bg-dark">
                    <li class="list-group-item bg-dark pl-0">Lokalizacja:</li>
                    <li class="list-group-item bg-dark pl-0">Cena biletu: </li>
                    <li class="list-group-item bg-dark pl-0">Start: </li>
                    <li class="list-group-item bg-dark pl-0">Koniec: </li>
                </ul>
                <a class="btn btn-success" href="/DisplayingThisEventController?eventId=0" role="button">Więcej</a>
            </div>
        </div>

            <div class="card mx-auto bg-dark text-white border-dark shadow" style="width: 18rem;">
                <div class="card-header">kategoria</div>
                <div class="card-body">
                    <h5 class="card-title">nazwa</h5>
                    <h6 class="card-subtitle mb-2 text-muted">organizator</h6>
                    <ul class="list-group list-group-flush bg-dark">
                        <li class="list-group-item bg-dark pl-0">Lokalizacja:</li>
                        <li class="list-group-item bg-dark pl-0">Cena biletu: </li>
                        <li class="list-group-item bg-dark pl-0">Start: </li>
                        <li class="list-group-item bg-dark pl-0">Koniec: </li>
                    </ul>
                    <a class="btn btn-success" href="/DisplayingThisEventController?eventId=0" role="button">Więcej</a>
                </div>
            </div>

            <div class="card mx-auto bg-dark text-white border-dark shadow" style="width: 18rem;">
                <div class="card-header">kategoria</div>
                <div class="card-body">
                    <h5 class="card-title">nazwa</h5>
                    <h6 class="card-subtitle mb-2 text-muted">organizator</h6>
                    <ul class="list-group list-group-flush bg-dark">
                        <li class="list-group-item bg-dark pl-0">Lokalizacja:</li>
                        <li class="list-group-item bg-dark pl-0">Cena biletu: </li>
                        <li class="list-group-item bg-dark pl-0">Start: </li>
                        <li class="list-group-item bg-dark pl-0">Koniec: </li>
                    </ul>
                    <a class="btn btn-success" href="/DisplayingThisEventController?eventId=0" role="button">Więcej</a>
                </div>
            </div>
        </div>
    </div>
    </div>

    <!-- NEWEST EVENTS -->

    <div class="row mt-5">
        <div class="col-8 mx-auto">
            <div class="jumbotron jumbotron-fluid rounded-pill shadow-lg border border-success">
                <div class="container text-center">
                    <h1 class="display-4">Najnowsze wydarzenia</h1>
                </div>
            </div>
        </div>
    </div>

    <div class="row mt-2">
        <div class="col-8 mx-auto">
            <div class="row mt-2">
                <div class="card mx-auto bg-dark text-white border-dark shadow" style="width: 18rem;">
                    <div class="card-header">kategoria</div>
                    <div class="card-body">
                        <h5 class="card-title">nazwa</h5>
                        <h6 class="card-subtitle mb-2 text-muted">organizator</h6>
                        <ul class="list-group list-group-flush bg-dark">
                            <li class="list-group-item bg-dark pl-0">Lokalizacja:</li>
                            <li class="list-group-item bg-dark pl-0">Cena biletu: </li>
                            <li class="list-group-item bg-dark pl-0">Start: </li>
                            <li class="list-group-item bg-dark pl-0">Koniec: </li>
                        </ul>
                        <a class="btn btn-success" href="/DisplayingThisEventController?eventId=0" role="button">Więcej</a>
                    </div>
                </div>

                <div class="card mx-auto bg-dark text-white border-dark shadow" style="width: 18rem;">
                    <div class="card-header">kategoria</div>
                    <div class="card-body">
                        <h5 class="card-title">nazwa</h5>
                        <h6 class="card-subtitle mb-2 text-muted">organizator</h6>
                        <ul class="list-group list-group-flush bg-dark">
                            <li class="list-group-item bg-dark pl-0">Lokalizacja:</li>
                            <li class="list-group-item bg-dark pl-0">Cena biletu: </li>
                            <li class="list-group-item bg-dark pl-0">Start: </li>
                            <li class="list-group-item bg-dark pl-0">Koniec: </li>
                        </ul>
                        <a class="btn btn-success" href="/DisplayingThisEventController?eventId=0" role="button">Więcej</a>
                    </div>
                </div>

                <div class="card mx-auto bg-dark text-white border-dark shadow" style="width: 18rem;">
                    <div class="card-header">kategoria</div>
                    <div class="card-body">
                        <h5 class="card-title">nazwa</h5>
                        <h6 class="card-subtitle mb-2 text-muted">organizator</h6>
                        <ul class="list-group list-group-flush bg-dark">
                            <li class="list-group-item bg-dark pl-0">Lokalizacja:</li>
                            <li class="list-group-item bg-dark pl-0">Cena biletu: </li>
                            <li class="list-group-item bg-dark pl-0">Start: </li>
                            <li class="list-group-item bg-dark pl-0">Koniec: </li>
                        </ul>
                        <a class="btn btn-success" href="/DisplayingThisEventController?eventId=0" role="button">Więcej</a>
                    </div>
                </div>
            </div>
        </div>
    </div>



</div>



<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
</body>
</html>
