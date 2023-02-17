 <%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Kitchen Basket</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">


</head>

<body class="bg-light">
	<jsp:include page="/WEB-INF/views/_header.jsp"></jsp:include>


    <!--container for responsive website for 3 cards-->
    <div class="container-fluid">
        <div class="row">

            <!--vegetable card with button for availability-->
            
                <div class="card" style="width: 50%; margin-top: 2%;margin-left: 10%;">
                    <div class="card-body bg-warning">
                        <h5 class="card-title fw-bolder fs-1">Vegetables</h5>
                      
                        <a href="vegetable.html" class="btn btn-dark">Available Products</a>
                    </div>
                </div>
           

            <!--fruits card with button for availability-->
           
                <div class="card" style="width: 50%; margin-top: 2%;margin-left: 10%;">
                    <div class="card-body bg-warning">
                        <h5 class="card-title fw-bolder fs-1">Fruits</h5>
                        <p class="card-text"></p>
                        <a href="fruits.html" class="btn btn-dark">Available Products</a>
                    </div>
                </div>
      

            <!--spices card with button for availability-->
          
                <div class="card" style="width: 50%; margin-top: 2%;margin-left: 10%;">
                    <div class="card-body bg-warning">
                        <h5 class="card-title fw-bolder fs-1">Spices</h5>
                        <p class="card-text"></p>
                        <a href="spices.html" class="btn btn-dark">Available Products</a>
                    </div>
                </div>
           
        </div>
    </div>
    



</body>

</html>