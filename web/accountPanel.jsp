<%--
  Created by IntelliJ IDEA.
  User: Kuba Gorczyca
  Date: 06.03.2019
  Time: 21:49
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
        <div class="col-8 mx-auto">
            <div class="jumbotron jumbotron-fluid rounded-pill shadow-lg border border-success">
                <div class="container text-center">
                    <h1 class="display-4">${requestScope.manager.login}</h1>
                </div>
            </div>
        </div>
    </div>

    <div class="row mt-5">
        <div class="col-8 mx-auto">
            <div class="d-flex justify-content-center">
                <p> <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#collapseExample1" aria-expanded="false" aria-controls="collapseExample1">
                    Nadchodzące wydarzenia  <span class="badge badge-light">${requestScope.notStartedEventsSize}</span>
                </button>
                    <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#collapseExample2" aria-expanded="false" aria-controls="collapseExample2">
                        Ubiegłe wydarzenia  <span class="badge badge-light">${requestScope.endedEventsSize}</span>
                    </button>
                </p>
            </div>


            <div class="collapse" id="collapseExample1">

                <c:if test="${requestScope.notStartedEventsSize eq 0}">
                    <div class="card card-body">
                        Brak wydarzeń
                    </div>
                </c:if>

                <c:if test="${requestScope.notStartedEventsSize < 4}">
                    <div class="card card-body">
                        <div class="card-deck">
                            <c:forEach items="${requestScope.notStartedEvents}" var="event">
                                <div class="card border-success mb-3" style="max-width: 18rem;">
                                    <div class="card-header">${event.category}</div>
                                    <div class="card-body text-success">
                                        <h5 class="card-title">${event.name}</h5>
                                        <p class="card-text">${event.location}<hr>
                                            ${event.startDate}<hr>
                                            ${event.endDate}<hr>
                                            ${event.ticketPrice}</p>
                                        <p> <a class="btn btn-success" href="/event?eventId=${event.id}" role="button">Więcej</a> </p>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </c:if>

                <c:if test="${requestScope.notStartedEventsSize > 3}">
                    <div class="card card-body">
                        <div class="card-deck">
                            <c:forEach items="${requestScope.notStartedEvents}" var="event"
                                       begin="0" end="2">
                                <div class="card border-success mb-3" style="max-width: 18rem;">
                                    <div class="card-header">${event.category}</div>
                                    <div class="card-body text-success">
                                        <h5 class="card-title">${event.name}</h5>
                                        <p class="card-text">${event.location}<hr>
                                            ${event.startDate}<hr>
                                            ${event.endDate}<hr>
                                            ${event.ticketPrice}</p>
                                            <p> <a class="btn btn-success" href="/event?eventId=${event.id}" role="button">Więcej</a> </p>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                        <a class="btn btn-success ml-2" href="/#" role="button">Więcej</a>
                    </div>
                </c:if>
            </div>

            <div class="collapse" id="collapseExample2">

                <c:if test="${requestScope.endedEventsSize eq 0}">
                    <div class="card card-body">
                        Brak wydarzeń
                    </div>
                </c:if>

                <c:if test="${requestScope.endedEventsSize < 4}">
                    <div class="card card-body">
                        <div class="card-deck">
                            <c:forEach items="${requestScope.endedEvents}" var="event">
                                <div class="card border-success mb-3" style="max-width: 18rem;">
                                    <div class="card-header">${event.category}</div>
                                    <div class="card-body text-success">
                                        <h5 class="card-title">${event.name}</h5>
                                        <p class="card-text">${event.location}<hr>
                                            ${event.startDate}<hr>
                                            ${event.endDate}<hr>
                                            ${event.ticketPrice}</p>
                                        <p> <a class="btn btn-success" href="/event?eventId=${event.id}" role="button">Więcej</a> </p>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </c:if>

                <c:if test="${requestScope.endedEventsSize > 3}">
                    <div class="card card-body">
                        <div class="card-deck">
                            <c:forEach items="${requestScope.endedEvents}" var="event"
                                       begin="0" end="2">
                                <div class="card border-success mb-3" style="max-width: 18rem;">
                                    <div class="card-header">${event.category}</div>
                                    <div class="card-body text-success">
                                        <h5 class="card-title">${event.name}</h5>
                                        <p class="card-text">${event.location}<hr>
                                            ${event.startDate}<hr>
                                            ${event.endDate}<hr>
                                            ${event.ticketPrice}</p>
                                        <p> <a class="btn btn-success" href="/event?eventId=${event.id}" role="button">Więcej</a> </p>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                        <a class="btn btn-success ml-2" href="/#" role="button">Więcej</a>
                    </div>
                </c:if>

            </div>
        </div>
    </div>


    <div class="row mt-5">
        <div class="col-8 mx-auto">
            <div class="card-deck d-flex justify-content-center">

                <c:choose>
                    <c:when test="${requestScope.isFollowed == false}">
                        <div class="card text-white bg-success mb-3" style="max-width: 18rem;">
                            <div class="card-header">Obserwacja</div>
                            <div class="card-body">
                                <p class="card-text">Obserwuj użytkownika i otrzymuj powiadomienia o nowych eventach!</p>
                                <p><a class="btn btn-outline-light mx-auto" href="/follow?action=follow&managerId=${requestScope.manager.id}&participantId=${sessionScope.loggedUser.id}" role="button">Obserwuj</a></p>
                            </div>
                        </div>
                    </c:when>
                    <c:when test="${requestScope.isFollowed == true}">
                        <div class="card text-white bg-success mb-3" style="max-width: 18rem;">
                            <div class="card-header">Obserwacja</div>
                            <div class="card-body">
                                <p class="card-text">Przestań obserwować tego użytkownika.</p>
                                <p><a class="btn btn-outline-light mx-auto" href="/unfollow?action=follow&managerId=${requestScope.manager.id}&participantId=${sessionScope.loggedUser.id}" role="button">Przestań obserwować</a></p>
                            </div>
                        </div>
                    </c:when>
                </c:choose>






                <div class="card text-white bg-success mb-3" style="max-width: 18rem;">
                    <div class="card-header">Obserwujący</div>
                    <div class="card-body">
                        <p class="card-text">Sprawdź obserwujących tego użytkownika. </p>
                        <p><a class="btn btn-outline-light mx-auto" href="#" role="button">Obserwujący</a></p>
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
