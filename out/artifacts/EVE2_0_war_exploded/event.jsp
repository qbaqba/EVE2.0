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
                <p class="lead">organizator: <a href="/account?accountId=${requestScope.event.manager.id}">${requestScope.event.manager.login}</a></p>
                <hr class="my-4">

            <div class="row">
                    <button type="button" class="btn btn-primary ml-3" data-toggle="modal" data-target="#exampleModalLong">
                        Uczestnicy
                    </button> </p>
                <div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header text-center">
                                <h5 class="modal-title text-center" id="exampleModalLongTitle">Uczestnicy</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body text-center">
                                <c:forEach items="${requestScope.participants}" var="participant">
                                    <a class="lead" href="/participantAccount">${participant.login}</a>
                                    <hr class="my-1">
                                </c:forEach>
                            </div>
                            <div class="modal-footer mx-auto">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Zamknij</button>
                            </div>
                        </div>
                    </div>
                </div>



                <c:if test="${sessionScope.loggedUser.accountType == 'PARTICIPANT'}">
                    <c:choose>
                        <c:when test="${requestScope.isParticipation == true}">
                            <a class="btn btn-success ml-2" href="/participation?eventId=${requestScope.event.id}&participantId=${sessionScope.loggedUser.id}&action=quit" role="button">Nie bierz udziału</a>
                        </c:when>
                        <c:when test="${requestScope.isParticipation == false}">
                            <a class="btn btn-success ml-2" href="/participation?eventId=${requestScope.event.id}&participantId=${sessionScope.loggedUser.id}&action=join" role="button">Dolacz</a>
                        </c:when>
                    </c:choose>
                </c:if>
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
