

<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/css/bootstrap-extended.min.css">
    <link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/fonts/simple-line-icons/style.min.css">
    <link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/css/colors.min.css">
    <link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat&display=swap" rel="stylesheet">
</head>
<div class="logo col-xl-12 col-sm-12 col-12 text-center">
    <img src="/images/credit-saison-logo.png" />
</div>
<div class="cardStats">
    <article class="card" style="color: #009c9f">
        <div class="card__body">

            <header class="card__primary-title py-1 text-center" style="background-color: #00cbce;color: rgba(219,239,237,0.8)">
                <h2>Showing Card numbers with total hits </h2>
                <h4>Showing page no. ${currentPage} of ${totalPages}</h4>
            </header>

            <div class="cardDetails py-2 text-center mx-auto" style="background-color: rgba(0,156,159,0.8);color: rgba(219,239,237,0.8)">
                <table border="2" width="70%" cellpadding="2" table border="2" width="70%" cellpadding="2" class="text-center" style="color: rgba(219,239,237,0.8);border-color: #f3f5f8;margin-left: 15%;margin-right: 10%;">
                    <tr><th>Card Number</th><th>Total Hits</th></tr>
                    <c:forEach var="cd" items="${verifyCardRequestLog}">
                        <tr>
                            <td>${cd.key}</td>
                            <td>${cd.value}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </article>
</div>


