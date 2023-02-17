<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;500&family=Lora:wght@600;700&display=swap"
        rel="stylesheet">

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/animate/animate.min.css" rel="stylesheet">
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
    
   
</head>

<body>

	<jsp:include page="/WEB-INF/views/_header.jsp"></jsp:include>


    <div class="card" style="margin-top: 50px;">
        <div class="card-body">
            <div class="container mb-5 mt-3">
                <div class="row d-flex align-items-baseline">
                    <div class="col-xl-9">
                        <p style="color: #7e8d9f;font-size: 20px;">Order Cancellation >> <strong>${receipt.orderId}</strong>
                        </p>
                    </div>
                    <div class="col-xl-3 float-end">
                        <a class="btn btn-light text-capitalize border-0" data-mdb-ripple-color="dark"
                            onclick="window.print()">
                            <button onclick="window.print()">Print

                            </button>
                        </a>

                    </div>
                    <hr>
                </div>

                <div class="container">



                    <div class="row">
                        <div class="col-xl-8">
                            <ul class="list-unstyled">
                                <li class="text-muted">To: <span style="color:#5d9fc5 ;">${receipt.preffered_login_Id}</span></li>
                                
                            </ul>
                        </div>
                        <div class="col-xl-4">
                            <p class="text-muted">Cancellation Receipt</p>
                            <ul class="list-unstyled">
                                <li class="text-muted"><i class="fas fa-circle" style="color:#84B0CA ;"></i> <span
                                        class="fw-bold">Cancellation ID:</span>${receipt.cancellationId}</li>
                                <li class="text-muted"><i class="fas fa-circle" style="color:#84B0CA ;"></i> <span
                                        class="fw-bold">Cancellation Date: </span>${receipt.cancellationDate}</li>

                            </ul>
                        </div>
                    </div>

                    <div class="row my-2 mx-1 justify-content-center">
                        <table class="table table-striped table-borderless">
                            <thead style="background-color:#84B0CA ;" class="text-white">
                                <tr>
                                    <th scope="col">Order ID</th>
                                    <th scope="col">Product ID</th>
                                    <th scope="col">Product</th>
                                    <th scope="col">Quantity</th>
                                    <th scope="col">Order Date</th>
                                    <th scope="col">Cancellation Date</th>
                                    <th scope="col">Reason</th>
                                    <th scope="col">Amount</th>             
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td scope="row">${receipt.orderId}</td>
                                    <td>${receipt.productId}</td>
                                    <td>${receipt.productName}</td>
                                    <td>${receipt.quantity}</td>
                                    <td>${receipt.orderDate}</td>
                                    <td>${receipt.cancellationDate}</td>
                                    <td>${receipt.cancellationReason}</td>
                                    <td>${receipt.totalPrice}</td>
                                </tr>

                            </tbody>

                        </table>
                    </div>
                    <div class="row">
                        <div class="col-xl-8">


                        </div>
                        <div class="col-xl-3">

                            <p class="text-black float-start"><span class="text-black me-3"> Total Amount</span><span
                                    style="font-size: 25px;">${receipt.totalPrice}</span></p>
                        </div>
                    </div>
                    <hr>
                   

                </div>
            </div>
        </div>
    </div>







</body>

</html>