<%--
  Created by IntelliJ IDEA.
  User: Kuba Gorczyca
  Date: 25.01.2019
  Time: 20:48
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
    <div class="row justify-content-center mt-2">
        <div class="col-6">
            <div class="jumbotron jumbotron-fluid border border-success text-center rounded">
            <form method="post" action="CreatingEventController">
                <div class="form-group">
                    <label for="inputName">Nazwa wydarzenia</label>
                    <input type="text" name="inputName" class="form-control" id="inputName">
                </div>
                <div class="form-group">
                    <label for="inputLocation">Miejsce wydarzenia</label>
                    <input type="text" name="inputLocation" class="form-control" id="inputLocation">
                </div>
                <div class="form-group">
                    <label for="descriptionArea">Opis wydarzenia</label>
                    <textarea class="form-control" id="descriptionArea" rows="4"></textarea>
                </div>
                <div class="form-group">
                    <label for="inputPrice">Cena</label>
                    <input type="text" name="inputPrice" class="form-control" id="inputPrice">
                </div>
                <div class="form-group">
                    <label for="inputStartDate">Data rozpoczecia</label>
                    <input type="date" name="inputStartDate" class="form-control" id="inputStartDate">
                </div>
                <div class="form-group">
                    <label for="inputStartTime">Godzina rozpoczęcia</label>
                    <input type="time" name="inputStartTime" class="form-control" id="inputStartTime">
                </div>
                <div class="form-group">
                    <label for="inputEndDate">Data zakończenia</label>
                    <input type="date" name="inputEndDate" class="form-control" id="inputEndDate">
                </div>
                <div class="form-group">
                    <label for="inputEndTime">Godzina zakończenia</label>
                    <input type="time" name="inputEndTime" class="form-control" id="inputEndTime">
                </div>
                <div class="form-group">
                    <label for="inputCategory">Wybierz kategorię</label>
                    <select class="custom-select" id="inputCategory">
                        <option selected>Kategoria</option>
                        <option value="sport">Sport</option>
                        <option value="music">Muzyka</option>
                        <option value="culture">Kultura</option>
                        <option value="food">Jedzenie</option>
                        <option value="shopping">Zakupy</option>
                        <option value="hobby">Hobby</option>
                        <option value="learning">Nauka</option>
                        <option value="work">Praca</option>
                        <option value="other">Inne</option>
                    </select>
                </div>
                <div class="form-group row ">
                    <div class="mx-auto  ">
                        <button type="submit" class="btn btn-success">Utwórz wydarzenie</button>
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
