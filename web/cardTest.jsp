<%--
  Created by IntelliJ IDEA.
  User: Kuba Gorczyca
  Date: 21.02.2019
  Time: 16:35
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
    <div class="row d-flex mt-5">
        <div class="col-8 border-dark mx-auto">

            <div class="card mx-auto bg-dark text-white border-dark" style="width: 18rem;">
                <div class="card-header">${sessionScope.currentEvent.category}</div>
                <div class="card-body">
                    <h5 class="card-title">${sessionScope.currentEvent.name}</h5>
                    <h6 class="card-subtitle mb-2 text-muted">${sessionScope.currentEvent.manager.login}</h6>
                    <ul class="list-group list-group-flush bg-dark">
                        <li class="list-group-item bg-dark pl-0">Lokalizacja: ${sessionScope.loggedUser.listOfCreatedEvents.size}</li>
                        <li class="list-group-item bg-dark pl-0">Cena biletu: 27,00</li>
                        <li class="list-group-item bg-dark pl-0">Data początek: 23.02.2018</li>
                        <li class="list-group-item bg-dark pl-0">Data koniec: 24.02.2018</li>
                    </ul>
                    <a href="#" class="card-link pt-3">Więcej</a>
                    <a href="#" class="card-link pt-3">Dołącz</a>
                </div>
            </div>

            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <li class="page-item"><a class="page-link" href="#">Previous</a></li>

                    <c:forEach begin="0" end="2" varStatus="loop">
                        <li class="page-item"><a class="page-link" href="#">${loop.count}</a></li>
                    </c:forEach>
                    <li class="page-item"><a class="page-link" href="#">Next</a></li>
                </ul>
            </nav>

            <c:forEach items="${sessionScope.collection}">

            </c:forEach>



            <c:forEach begin="0" end="2">
                <div class="row d-flex mt-2">
                <c:forEach begin="0" end="2">
                    <div class="card mx-auto bg-info text-white border-dark" style="width: 18rem;">
                        <div class="card-header">Header</div>
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                            <a href="#" class="card-link">Card link</a>
                            <a href="#" class="card-link">Another link</a>
                        </div>
                    </div>
                </c:forEach>
                </div>
            </c:forEach>

            <c:forEach begin="0" end="2">
                <p> Cos tam</p>
            </c:forEach>

        </div>
    </div>
</div>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
</body>
</html>
