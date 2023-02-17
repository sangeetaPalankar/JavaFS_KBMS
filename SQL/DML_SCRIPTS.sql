USE KBMS_PROJECT;

/*INSERT QUERIES*/
INSERT INTO PRODUCT 
(PRODUCT_NAME, PRODUCT_COUNT, TOTAL_STOCK, BEST_BEFORE, PRICE_PER_UNIT,TYPE_OF_PRODUCT)
VALUES
("Apple", 200, 500, '2023-03-23', 150,"fruit"),
( "orange", 80, 600, '2023-03-30', 50,"fruit"),
( "Mango", 40, 800, '2023-05-23', 250,"fruit"),
( "Grapes", 50, 30, '2023-03-23', 150,"fruit"),
( "Potato", 200, 500, '2023-03-23', 150,"vegitable"),
( "Carrot", 80, 600, '2023-03-30', 50,"vegitable"),
( "Lady Finger", 40, 800, '2023-05-23', 250,"vegitable"),
( "onion", 50, 30, '2023-03-23', 150,"vegitable"),
("Nutmeg", 200, 500, '2023-03-23', 150,"Spices"),
("Black Pepper", 80, 600, '2023-03-30', 50,"Spices"),
("Cardamom", 40, 800, '2023-05-23', 250,"Spices"),
("Saffron", 50, 30, '2023-03-23', 150,"Spices");

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
    "1989-10-10", 32, "alexa123", "visa card", "al9090@hmail.com"),
    
    ("Alexander","polo90@hmail.com", 9898990908, "Street 3, twin tower, tordan", 
    "1978-02-19", 43, "xxxxxxx", "visa card", "polo90@hmail.com"),
    
    ("Marie","al9090@hmail.com", 9898989907, "Street 3, twin tower, Jordan", 
    "2001-10-28", 21, "xxxxxxx", "visa card", "al9090@hlmail.com"),
    
    ("Jacky","loki0@hmail.com", 9897856489, "Street 2,quad tower, london", 
    "1978-09-23", 44, "xxxxxxx", "visa card", "loki@hmail.com"),
    
    ("Bob","bob@hmail.com", 9898907869, "Street 3, twin tower, Jordan", 
    "2002-09-11",20, "xxxxxxx", "visa card", "bob@hmail.com"),
    
    ("Alexa","al9090@hmail.com", 9894523889, "Street 3, twin tower, Jordan", 
    "1999-11-10", 23, "pass123", "visa card", "alexa_"),
    
    ("Sonail","sonail@hmail.com", 9897890589, "Street 3, twin tower, Jordan", 
    "1993-12-12", 29, "xxxxxxx", "visa card", "sonail_675");

INSERT INTO ORDER_DETAILS
(preferred_login_id, PRODUCT_ID, QUANTITY, TOTAL_PRICE, ORDER_DATE, STATUS, CANCELLATION_DATE, CANCELLATION_REASON)
VALUES 
("sonail_675", 101 , 3, 100.00,'2022-10-23',"Confirmed", null, null),
("alexa_",106 , 2, 200.00 , '2022-10-20',"Confirmed",null,null),
("bob@hmail.com",108,1,300.00, '2022-11-23',"Confirmed", null,null),
("loki@hmail.com", 104 , 5, 100.00,'2022-10-23',"Confirmed", null, null),
("sonail_675", 103 , 3, 100.00,'2022-10-23',"Confirmed", null, null),
("polo90@hmail.com", 112 , 3, 600.00,'2022-10-23',"Confirmed", null, null),
("sonail_675", 103 , 1, 200.00,'2022-10-23',"Confirmed", null, null),
("alexa_", 102 , 3, 150.00,'2022-10-23',"Confirmed", null, null),
("alexa_", 109 , 3, 100.00,'2022-10-23',"Confirmed", null, null),
("alexa_",102 , 4, 200.00 , '2022-10-20',"Confirmed",null,null);


UPDATE order_details SET STATUS ="Cancelled",
CANCELLATION_ID =102544, 
CANCELLATION_DATE ='2022-10-04',
 CANCELLATION_REASON = "HRUGU" 
WHERE ORDER_ID= 10001;

UPDATE PRODUCT p join order_details o on p.PRODUCT_ID=o.PRODUCT_ID set PRODUCT_COUNT=(p.PRODUCT_COUNT+o.QUANTITY ) where p.PRODUCT_ID=101;

DELETE FROM ORDER_DETAILS where order_id = 10001;
DELETE FROM  PRODUCT;
DELETE FROM CUSTOMER;
DELETE FROM ORDER_DETAILS;