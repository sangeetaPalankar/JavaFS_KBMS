<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>




<!DOCTYPE html>

<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Reason</title>

<link rel="stylesheet" href="MyOrders.css">

<link href="bootstrap.min.css" rel="stylesheet">

<link href="style.css" rel="stylesheet">

<style>

.textContent{
 font-size: 18px;
}
.textSmall{
 font-size: 16px;
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

</style>
</head>



<body>
	<jsp:include page="/WEB-INF/views/_header.jsp"></jsp:include>



	<!-- <h1>${orderDetail.orderId}</h1> -->

	<!--CONTENT-->


	<div style="justify-content: center;" >
		<div class="center" style="margin-top: 50px; margin-left:100px">
			<div>
				<div class="d-block h5 mb-2">
					<h2>Order Cancellation:</h2>
				</div>
				<div style="background-color: white;
            border-radius: 5px;
            box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
            margin-right: 30px;
             padding:50px;
             width:50%;"
             >


				<div class="cancellationForm-container" >
					<div>
						<div class="cancellableItems-card" style="margin-top: 0px;">
							<div>

								<div class="CancelledCard-Text" style=" background-color: white;">
								 
									<div class="textContent" >Order ID ${orderDetail.orderId}</div><br>
									<div class="textContent" >Product Name: ${orderDetail.productName}</div><br>
									
									<div class="textContent" >Product ID: ${orderDetail.productId}</div><br>
									
									<div class="textContent" >Quantity: ${orderDetail.quantity}</div><br>
									
									<div class="textContent" >Total Price: ${orderDetail.totalPrice}</div><br>
									
									<div class="textContent" >Order Date: ${orderDetail.orderDate}</div><br>
									
								</div>

							</div>

						</div>



						<form method="POST" action="OrderCancellationServlet">
							<div class="CancelledCard-Text">
								<p class="textSmall"><b>Reason for cancellation</b></p>
								<hr>
								<p class="textSmall">Please tell us correct reason for
									cancellation. This information is only used to improve our
									service</p>

								<textarea rows="5" cols="50" placeholder="Type here..." name="reason" value="${cancellationReason}"></textarea>
							</div>
							<br>
							<div>

								<button class="Button" name ="oid"  value="${orderDetail.orderId}" type="submit" >Cancel Order</button>

							</div>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>






	<jsp:include page="/WEB-INF/views/_footer.jsp"></jsp:include>








</body>

</html>







