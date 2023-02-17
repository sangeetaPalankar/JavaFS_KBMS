<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<head>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<div >
<nav class="navbar navbar-expand-lg  " style="background-color: gold ;" >
        <div class="container-fluid " >
            <a class="navbar-brand fw-bolder fs-1" href=""><img src="img/logo_kb.png" alt="" width="80px"
                    style="border-radius: 50%;"></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target=""
                aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarScroll">
                <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="allOrders">

                            <!-- Button trigger modal -->

                            <button type="button" class="btn btn-dark" data-bs-toggle="modal"
                                data-bs-target="#exampleModal" id="category">
                                Shop by Category
                            </button>

                        </a>

                        <!-- Modal pop down category of veg fruits spices -->

                        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                            aria-hidden="true">
                            <div class="modal-dialog modal-xl">
                                <div class="modal-content " style="height: 400px;">

                                    <!--header for modal-->
                                    <div class="modal-header bg-primary">
                                        <h1 class="modal-title fs-3 " id="exampleModalLabel">Shop Category
                                        </h1>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                            aria-label="Close"></button>
                                    </div>

                                    <!---body for modal-->
                                    <div class="modal-body bg-dark">
                                        <div class="container-fluid">
                                            <div class="row">

                                                <!---card for vegetable to connect to vegetable page -->
                                                <a href="allOrders">
                                                    <div class=" col-md-4 col-sm-12 card mb-3 h-75 w-25 position-absolute top-0"
                                                        style="margin-top: 3%;margin-left: 3%; ">

                                                        <!---card for vegess-->
                                                        <div class="card-body"
                                                            style="background-image: url('product-1.jpg'); background-size:cover; ">
                                                            <h5
                                                                class="card-title text-dark fs-2 fw-bolder position-absolute top-0 start-0">
                                                                VEGETABLES
                                                            </h5>

                                                        </div>
                                                    </div>
                                                </a>

                                                <!---card to connect fruit_html page -->
                                                <a href="allOrders">

                                                    <div class=" col-md-4 col-sm-12 card mb-3  h-75 w-25  position-absolute top-0"
                                                        style="margin-left: 35%;margin-top: 3%;">

                                                        <!---cards for fruit -->
                                                        <div class="card-body"
                                                            style="background-image:url(img/tina-bach-WooBe_2VOcA-unsplash.jpg);background-size: cover;">
                                                            <h5
                                                                class="card-title text-dark fs-2 fw-bolder position-absolute top-0 start-0">
                                                                FRUITS</h5>

                                                        </div>
                                                    </div>
                                                </a>



                                                <!---card to connect spices_html page-->
                                                <a href="allOrders">
                                                    <div class=" col-md-4 col-sm-12 card mb-3 h-75 w-25  position-absolute top-0"
                                                        style="margin-top: 3%;margin-left: 67%;">

                                                        <!---cards for spices -->
                                                        <div class="card-body"
                                                            style="background-image:url(img/ratul-ghosh-NPrWYa69Mz0-unsplash.jpg);background-size: cover;">
                                                            <h5
                                                                class="card-title text-dark fs-2 fw-bolder position-absolute top-0 start-0">
                                                                SPICES</h5>

                                                        </div>
                                                    </div>
                                                </a>

                                            </div>
                                        </div>
                                    </div>

                                    <!--footer modal include close button-->
                                    <div class="modal-footer bg-primary">
                                        <button type="button" class="btn btn-dark"
                                            data-bs-dismiss="modal">Close</button>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>

                    <!--basket button to jump on my basket page-->
                    <li class="nav-item">
                        <a class="nav-link" href="allOrders">
                            <button class="btn btn-dark" type="button">My
                                Basket</button></a>
                    </li>

                    <!---for address button to choose address-->
                    <div style="margin-top: 2.3%;">
                        <li class="nav-item ">
                            <label for="address">Address</label>
                            <select class="bg-light text-dark" name="address" id="address" aria-placeholder="Address">
                                <option value="mumbai">Mumbai</option>
                                <option value="pune">Pune</option>
                                <option value="delhi">Delhi</option>
                                <option value="banglore">Banglore</option>
                            </select>
                        </li>
                    </div>

                    <!-- myorder button to jump on my my order page-->

                    <li class="nav-item">
                        <a class="nav-link " href="allOrders" >
                            <!-- Button trigger modal -->
                            <button type="button" class="btn btn-dark ">
                                My Orders
                            </button>
                        </a>


                    </li>
                </ul>

                <!--for search button-->
                <form class="d-flex" role="search">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-dark" type="submit">Search</button>
                </form>
            </div>
        </div>
    </nav>
    </div>