<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<head>
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/css/bootstrap-extended.min.css">
<link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/fonts/simple-line-icons/style.min.css">
<link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/css/colors.min.css">
<link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Montserrat&display=swap" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>

</head>

<div class="grey-bg container-fluid">
    <div class="logo col-xl-12 col-sm-12 col-12 text-center">
    <img src="/images/credit-saison-logo.png" />
    </div>
    <section id="minimal-statistics">
        <div class="row text-center">
            <div class="col-12 mt-3 mb-1">
                <h4 class="text-uppercase">Assignment</h4>
                <p>Get your card status instantly</p>
            </div>
        </div>
        <div class="row">

            <div class="col-xl-6 col-sm-6 col-12">
                <div class="card">

                            <div class="media d-flex">
                                <div class="align-self-center" style="margin-left: 15%;">
                                    <i class="icon-pencil success font-large-2 float-left"></i>
                                </div>
                                <div class="media-body text-center py-2">
                                    <a data-toggle="collapse" href="#collapse-verify">  <h1>Verify Card</h1></a>
                                </div>
                            </div>
                </div>
                <div id="collapse-verify" class="panel-collapse collapse">
                    <div class="panel-body">
                        <form id="verifyCardForm" onsubmit="subData()">
                            <div class="form-group px-3 mt-3">
                                <label for="CardNumberVerify" class="py-2">Card Number</label>
                                <input class="form-control" id="CardNumberVerify" aria-describedby="cardHelp" placeholder="Enter Card number">
                                <small class="form-text text-muted py-2">We'll never share your Card Number with anyone else.</small>
                            </div>
                            <button type="submit" class="btn btn-primary ml-3">Submit</button>
                        </form>
                    </div>
                </div>

            </div>
            <div class="col-xl-6 col-sm-6 col-12">
                <div class="card px-md-10">
                            <div class="media d-flex">
                                <div class="align-self-center" style="margin-left: 15%;">
                                    <i class="icon-graph primary font-large-2 float-left"></i>
                                </div>
                                <div class="media-body text-center py-2">
                                    <a data-toggle="collapse" href="#collapse-stats">  <h1>Statistics</h1></a>
                                </div>
                    </div>
                </div>
                <div id="collapse-stats" class="panel-collapse collapse">
                    <div class="panel-body">
                        <form action="/stats" method="get">
                            <div class="form-group px-3 mt-3">
                                <label for="StartIndexStats" class="py-2">Enter Page number</label>
                                <input type="numberDTO" name="start" class="form-control" id="StartIndexStats" aria-describedby="cardHelp" placeholder="Enter Page number">
                                <label for="LimitStats" class="py-2">Enter Limit</label>
                                <input type="numberDTO" name="limit" class="form-control" id="LimitStats" aria-describedby="cardHelp" placeholder="Enter Limit">
                                <small class="form-text text-muted py-2">Get number of requests</small>
                            </div>
                            <button type="submit" class="btn btn-primary ml-3">Submit</button>
                        </form>
                    </div>
                </div>
            </div>

        </div>
        <script>
            function subData(){
                var action_src = "/verify/" + $('#CardNumberVerify').val();
                $('#verifyCardForm').attr('action',action_src);
            }</script>

    </section>
</div>