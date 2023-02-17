<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">


<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login Basket</title>


    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

</head>
<!--100vh for 100% height-->
<body style="height: 100vh;
width: 100%;

background-color: aliceblue;">

    <nav style="background-color: rgb(8, 169, 205);">

        <div class="container-fluid">
            <a class="navbar-brand fw-bolder fs-1" href="index.html"><img src="img/logo_kb.png" alt="" width="80px"
                style="border-radius: 50%;"></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll"
                aria-controls="navbarScroll" aria-esxpasnded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

        </div>
    </nav>




    <section class="vh-80">
        <div class="container py-5 h-100" >
            <div  class="row d-flex justify-content-center align-items-center h-100">
            
            <p style="color: red;">${errorString}</p>
            <p style="color: blue;">${logOutString}</p>

                <div class="col-1"></div>
                <div  class="col-10 col-md-8 col-lg-6 col-xl-5 " style="margin-top: 3%;">
                    <div 
                        style="border-radius: 1rem; border-color: gold;border-radius: 5%; background-color: gold;">
                        <div  class="card-body p-5 text-center" style="border-radius: 5%;background-color: gold;">

                            <h3 class="mb-5 fw-bolder fs-1">Log in</h3>
                            
                            
                            <form method="POST" action="dashboard">
                                <div class="form-outline mb-4">
                                    <input ttype="text" name="userName" value="${user.userLogin}" id="typeEmailX-2" placeholder="Username"
                                        class="form-control form-control-lg" required />
                                </div>

                                <div class="form-outline mb-4">
                                    <input type="password" name="password" value="${user.userPass}" id="typePasswordX-2" placeholder="Password"
                                        class="form-control form-control-lg" required />
                                </div>

                                <!-- Checkbox -->
                                <div class="form-check d-flex justify-content-start mb-4">
                                    <input class="form-check-input" type="checkbox" value="" id="form1Example3" />
                                    <label class="form-check-label" for="form1Example3"> Remember password </label>
                                </div>

                                <button class="btn btn-primary btn-lg btn-block" type="submit">Login</button>

                                <hr class="my-4">
                            </form>

                            <!-- <button class="btn btn-lg btn-block btn-primary" style="background-color: #dd4b39;"
                                type="submit"><i class="fab fa-google me-2"></i> Sign in with google</button>
                            <button class="btn btn-lg btn-block btn-primary mb-2" style="background-color: #3b5998;"
                                type="submit"><i class="fab fa-facebook-f me-2"></i>Sign in with facebook</button> -->

                        </div>
                    </div>
                </div>
                <div class="col-1"></div>
            </div>
        </div>
    </section>


    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
        integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>


	<jsp:include page="/WEB-INF/views/_footer.jsp"></jsp:include>

</body>

</html>

