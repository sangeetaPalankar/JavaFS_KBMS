<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cancellation Successful</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="MyOrders.css">

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
    

</style>
</head>
<style>
.center {
            margin: auto;
            width: 60%;
            /* border: 1px solid black; */
            padding: 10px;
          }
        .Button{
            background-color: #F65005; 
            border: none;
            color: white;
            padding: 5px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 12px;
            margin-top: 30px;
            margin-right: 30px;

        }

        .Date{
            font-size: 12px;
            color: #000;
            font-weight:lighter;
            font-family: Arial, Helvetica, sans-serif;
        }

        .ProductDetails{
            font-size: 16px;
            font-weight:normal;
            justify-content: center;


        }
        .Productname{
        font-size: 22px;
            font-weight:normal;
            justify-content: center;
            color:darkorange;
        }

        .BoldDetails{
            font-weight: bold;
            font-size: 16px;
        }
        .CancelledCard-Text{
            background-color: white;
            border-radius: 5px;
            box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
            margin-right: 30px;
        }
        .SmallDetails{
            font-size: 14px;
            font-weight: lighter;
        }
        .Heading{
            font-size: 20px;
            color: #000;
            justify-content: center;
    

        }
        .textContent{
 font-size: 18px;
}
.textSmall{
 font-size: 16px;
}
</style>

<body>



	<jsp:include page="/WEB-INF/views/_header.jsp"></jsp:include>




    <!--CONTENT-->
    <div>
        <div class="center" style="margin-top: 50px;">
            <div>
                <div class="d-block h5 mb-2">
                    <h4>Order Cancellation</h4>
                </div>


                <div style="background-color: rgb(255, 252, 245);">
                    <div class="CancellationConfirmation-outerDiv">
                        <div class="CancellationConfirmation-firstDoneDiv"><img
                                class="icon-m CancellationConfirmation-cancellationRequestedImage "
                                src="https://myntraweb.blob.core.windows.net/selfserveui/assets/images/done.png"
                                alt="doneImage" style="align-items: center;">
                            <p class="BoldDetails" style="text-align: center;">Order Cancelled Successfully</p>
                        </div>
                        <div class="CancellationConfirmation-cancelledItems">
                            <p class="text-common text-subHead1 CancellationConfirmation-cancelledItemText "
                                style="text-align: center;">1 Item is
                                cancelled</p>
                            <div style="margin-top: 12px;">
                                <div class="ProductList-itemInfoForItemList false">
                                    <div role="link" tabindex="0">
                                        <div class="ProductList-imageAndDetails">
                                           
                                            <div class="ProductList-details" style="text-align: center;">
                                                <div class="BoldDetails"><span class="Text-Text">Order ID: <b>${cancelDetail.orderId}</b></span>
                                                </div><br>
                                                <div class="Productname"><span class="Text-Text"><b>${cancelDetail.productName}</b></span></div>
                                                <div class="ProductDetails"><span class="Text-Text">Product ID: <b>${cancelDetail.productId}</b></span>
                                                    <div class="ProductDetails"><span class="Text-Text">Quantity: <b>${cancelDetail.quantity}</b></span>
                                                    </div>
                                                     <div class="ProductDetails"><span class="Text-Text">Total Price: <b>${cancelDetail.totalPrice}</b></span>
                                                    </div>
                                                     <div class="ProductDetails"><span class="Text-Text">Order Date: <b>${cancelDetail.orderDate}</b></span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div style="padding-left: 400px;">
                            <form method="POST" action ="OrderReceiptServlet">
                                
                                    <button class="Button" value="${cancelDetail.orderId}" name ="receiptOid" type="submit" >RECEIPT</button>
                                  
                            </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

	<jsp:include page="/WEB-INF/views/_footer.jsp"></jsp:include>



</body>

</html>