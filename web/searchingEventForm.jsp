<%--
  Created by IntelliJ IDEA.
  User: Kuba Gorczyca
  Date: 28.02.2019
  Time: 17:46
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

    <!-- JUMBOTRON -->
    <div class="row d-flex mt-5">
        <div class="col-8 mx-auto">
            <div class="jumbotron jumbotron-fluid rounded-pill shadow-lg border border-success">
                <div class="container text-center">
                    <h1 class="display-4">Wybierz kryteria</h1>
                </div>
            </div>
        </div>
    </div>

    <!-- SETTING FILTERS -->
    <div class="row justify-content-center mt-2">
        <div class="col-6">
            <div class="jumbotron jumbotron-fluid border border-success text-center rounded">
                <form method="get" action="searchEvents">
                    <h5 class="h5 my-4">Kategoria</h5>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" name="category" type="checkbox" id="inlineCheckbox1" value="sport">
                        <label class="form-check-label" for="inlineCheckbox1">Sport</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" name="category" type="checkbox" id="inlineCheckbox2" value="music">
                        <label class="form-check-label" for="inlineCheckbox2">Muzyka</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" name="category" type="checkbox" id="inlineCheckbox3" value="culture">
                        <label class="form-check-label" for="inlineCheckbox3">Kultura</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" name="category" type="checkbox" id="inlineCheckbox4" value="food">
                        <label class="form-check-label" for="inlineCheckbox4">Jedzenie</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" name="category" type="checkbox" id="inlineCheckbox5" value="learning">
                        <label class="form-check-label" for="inlineCheckbox5">Nauka</label>
                    </div>
                    <p></p>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" name="category" type="checkbox" id="inlineCheckbox6" value="work">
                        <label class="form-check-label" for="inlineCheckbox6">Praca</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" name="category" type="checkbox" id="inlineCheckbox7" value="hobby">
                        <label class="form-check-label" for="inlineCheckbox7">Hobby</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" name="category" type="checkbox" id="inlineCheckbox8" value="shopping">
                        <label class="form-check-label" for="inlineCheckbox8">Zakupy</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" name="category" type="checkbox" id="inlineCheckbox9" value="other">
                        <label class="form-check-label" for="inlineCheckbox9">Inne</label>
                    </div>
                    <hr class="my-4">
                    <h5 class="h5">Cena biletu</h5>
                    <input class="form-control my-4 text-center" name="minTicketPrice" type="text" placeholder="cena minimalna">
                    <input class="form-control my-4 text-center" name="maxTicketPrice" type="text" placeholder="cena maksymalna">
                    <hr class="my-4">
                    <h5 class="h5">Data</h5>
                    <div class="form-group">
                        <label for="inputStartDate">Od</label>
                        <input type="date" name="startDate" class="form-control text-center" id="inputStartDate">
                    </div>
                    <div class="form-group">
                        <label for="inputEndDate">Do</label>
                        <input type="date" name="endDate" class="form-control text-center" id="inputEndDate">
                    </div>
                    <div class="form-group">
                        <div class="mx-auto my-4">
                            <button type="submit" class="btn btn-success">Szukaj</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>


</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
</body>
</html>
