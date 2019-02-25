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

    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css">
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="css/mdb.min.css" rel="stylesheet">
    <!-- Your custom styles (optional) -->
    <link href="css/style.css" rel="stylesheet">



    <title>Eve 2.0</title>
</head>

<body>
<header>
    <jsp:include page="WEB-INF/fragments/header.jspf"></jsp:include>
</header>
<div class="container-fluid">

   <div class="row d-flex mt-5">
       <div class="col-8 mx-auto">
           <div class="jumbotron jumbotron-fluid rounded-pill shadow-lg border border-success">
               <div class="container text-center">
                   <h1 class="display-4">Twoje wydarzenia</h1>
               </div>
           </div>
       </div>
   </div>


    <div class="row d-flex mt-5">
        <div class="col-8 border-dark mx-auto ">

            <c:forEach begin="0" end="2" varStatus="loop">
                <div class="row d-flex mt-2">
                    <c:forEach items="${requestScope.listOfEventsForPage}" var="event"
                               begin="${(loop.count - 1) * 3}" end="${(loop.count * 3) - 1}">
                        <c:if test="${!empty event}">
                            <div class="card mx-auto bg-dark text-white border-dark shadow" style="width: 18rem;">
                                <div class="card-header">${event.category}</div>
                                <div class="card-body">
                                    <h5 class="card-title">${event.name}</h5>
                                    <h6 class="card-subtitle mb-2 text-muted">${event.manager.login}</h6>
                                    <ul class="list-group list-group-flush bg-dark">
                                        <li class="list-group-item bg-dark pl-0">Lokalizacja: ${event.location}</li>
                                        <li class="list-group-item bg-dark pl-0">Cena biletu: ${event.ticketPrice}</li>
                                        <li class="list-group-item bg-dark pl-0">Start: ${event.startDate}</li>
                                        <li class="list-group-item bg-dark pl-0">Koniec: ${event.endDate}</li>
                                    </ul>
                                    <a class="btn btn-success" href="/DisplayingThisEventController?eventId=${event.id}" role="button">Więcej</a>
                                </div>
                            </div>
                        </c:if>

                    </c:forEach>
                </div>
            </c:forEach>

            <div class="row d-flex mt-5">
                <div class="col-8">
                    <nav aria-label="Page navigation example">
                        <ul class="pagination">
                            <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                            <c:forEach begin="0" end="${requestScope.countOfPages - 1}" varStatus="loop">
                                <li class="page-item"><a class="page-link" href="/DisplayEventController?events=managerEvents&page=${loop.count}">${loop.count}</a></li>
                            </c:forEach>
                            <li class="page-item"><a class="page-link" href="#">Next</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</div>
<footer>
    <jsp:include page="mdtest.jsp"></jsp:include>
</footer>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
</body>
</html>
