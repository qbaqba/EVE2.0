<%--
  Created by IntelliJ IDEA.
  User: Kuba Gorczyca
  Date: 13.01.2019
  Time: 23:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">


    <title>Eve2</title>
</head>
<body>
<header>
    <jsp:include page="WEB-INF/fragments/header.jspf"></jsp:include>
</header>
<div class="container-fluid">

    <div class="row justify-content-center my-5">
        <div class="col-12 col-md-6 mx-auto justify-content-center">
            <h1 class="display-1 text-center">Rejestracja</h1>
        </div>
    </div>

    <div class="row justify-content-center">
        <div class="col-12 col-md-6">
            <div class="jumbotron jumbotron-fluid border border-success rounded">
                <div class="container text-center">
                    <h1 class="display-4 mx-auto">Wybierz typ konta</h1>
                    <p class="lead">Uczestnik - dołącz do wydarzeń!</p>
                    <p class="lead">Organizator - twórz własne wydarzenia!</p>
                    <div class="row justify-content-center mt-3">
                        <form method="post" action="RegisterController">
                            <button type="submit" class="btn btn-success btn-lg mr-2" name="accountType" value="participant">Uczestnik</button>
                            <button type="submit" class="btn btn-success btn-lg ml-2" name="accountType" value="manager">Organizator</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>


 <!--   <div class="row justify-content-center">
        <div class="col-12 col-md-4 border mt-3 ">
            <form method="post" action="register">
                <div class="form-group row pt-5">
                    <label for="inputLogin1" class="col-sm-2 col-form-label">Login</label>
                    <div class="col-sm-10">
                        <input name="inputLogin" type="text" class="form-control" id="inputLogin1" placeholder="Login">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="inputPassword1" class="col-sm-2 col-form-label">Hasło</label>
                    <div class="col-sm-10">
                        <input name="inputPassword" type="password" class="form-control" id="inputPassword1" placeholder="Hasło  ">
                    </div>
                </div>
                <div class="form-group row ">
                    <div class="mx-auto  ">
                        <button type="submit" class="btn btn-success">Zarejestruj się</button>
                    </div>
                </div>

            </form>
        </div>
    </div>-->
</div>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
</body>
</html>
