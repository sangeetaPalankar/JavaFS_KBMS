USE KBMS_PROJECT;
INSERT INTO PRODUCT 
(PRODUCT_ID, PRODUCT_NAME, PRODUCT_COUNT, TOTAL_STOCK, BEST_BEFORE, PRICE_PER_UNIT,TYPE_OF_PRODUCT)
VALUES
(101, "Apple", 200, 500, '2023-03-23', 150,"fruit"),
(102, "orange", 80, 600, '2023-03-30', 50,"fruit"),
(103, "Mango", 40, 800, '2023-05-23', 250,"fruit"),
(104, "Grapes", 50, 30, '2023-03-23', 150,"fruit"),
(105, "Potato", 200, 500, '2023-03-23', 150,"vegitable"),
(106, "Carrot", 80, 600, '2023-03-30', 50,"vegitable"),
(107, "Lady Finger", 40, 800, '2023-05-23', 250,"vegitable"),
(108, "onion", 50, 30, '2023-03-23', 150,"vegitable"),
(109, "Nutmeg", 200, 500, '2023-03-23', 150,"Spices"),
(110, "Black Pepper", 80, 600, '2023-03-30', 50,"Spices"),
(111, "Cardamom", 40, 800, '2023-05-23', 250,"Spices"),
(112, "Saffron", 50, 30, '2023-03-23', 150,"Spices");

INSERT INTO Customer
(
`Customer_name`, 
`email` , 
`phone` ,
`address` , 
`date_of_birth`, 
`age` ,
`password`,
`identity_proof`,
`preferred_login_id`)
VALUES
("Alexa","al9090@hmail.com", 9090787856, "Street 12, green tower, Jordan", 
    "1989-10-10", 32, "xxxxxxx", "visa card", "al9090@hmail.com"),
    
    ("Alexander","polo90@hmail.com", 9898990908, "Street 3, twin tower, tordan", 
    "1978-02-19", 43, "xxxxxxx", "visa card", "polo90@hmail.com"),
    
    ("Marie","al9090@hmail.com", 9898989907, "Street 3, twin tower, Jordan", 
    "2001-10-28", 21, "xxxxxxx", "visa card", "al9090@hlmail.com"),
    
    ("Jacky","loki0@hmail.com", 9897856489, "Street 2,quad tower, london", 
    "1978-09-23", 44, "xxxxxxx", "visa card", "loki@hmail.com"),
    
    ("Bob","bob@hmail.com", 9898907869, "Street 3, twin tower, Jordan", 
    "2002-09-11",20, "xxxxxxx", "visa card", "bob@hmail.com"),
    
    ("Alexa","al9090@hmail.com", 9894523889, "Street 3, twin tower, Jordan", 
    "1999-11-10", 23, "xxxxxxx", "visa card", "alexa_9090"),
    
    ("Sonail","sonail@hmail.com", 9897890589, "Street 3, twin tower, Jordan", 
    "1993-12-12", 29, "xxxxxxx", "visa card", "sonail_675");


INSERT INTO ORDER_DETAILS
(ORDER_ID, preferred_login_id, PRODUCT_ID, QUANTITY, TOTAL_PRICE, ORDER_DATE, STATUS, CANCELLATION_DATE, CANCELLATION_REASON)
VALUES 
(10001,"sonail_675", 101 , 1, 100.00,'2022-10-23',"Confirmed", null, null),
(10002,"alexa_9090",106 , 2, 200.00 , '2022-10-20',"Confirmed",null,null),
(10003,"bob@hmail.com",108,1,300.00, '2022-11-23',"Confirmed", null,null);