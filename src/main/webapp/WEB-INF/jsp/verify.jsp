<head>
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
<div class="cardVerify">
    <article class="card" style="color: #009c9f">
        <div class="card__body">

            <header class="card__primary-title py-1 text-center" style="background-color: #00cbce;color: rgba(219,239,237,0.8)">
                <h2>Card Details </h2>
            </header>

            <div class="cardDetails py-2 text-center" style="background-color: rgba(0,156,159,0.8);color: rgba(219,239,237,0.8)">
            <div>
            <div class="card__supporting-text">
               <b> Card Scheme : </b> ${cardDetails.payload.scheme}
            </div>
            </div>
                <div>
                    <div class="card__supporting-text">
                        <b>  Card Type :</b> ${cardDetails.payload.type}
                    </div>
                </div>
                <div>
                    <div class="card__supporting-text">
                        <b>  Bank Name :</b> ${cardDetails.payload.bank}
                    </div>
                </div>
            </div>
        </div>
    </article>
</div>

