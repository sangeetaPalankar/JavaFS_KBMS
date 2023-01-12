/*  
	Author Sangeeta Palankar
    date 28/12/2022
    DML
*/
#INSERT COMMANDS
USE KBMS_PROJECT;
INSERT INTO USER
(FNAME, LNAME, EMAIL, PHONE_NO, ADDRESS, DATE_OF_BIRTH, ID_PROOF, LOGIN_ID, PASSWORD)
VALUES
("Sangeeta", "Palankar", "sangita123@gmail.com", '9845655245',"HNO. 47 Belgaum", "2000-10-18", '458769523541',"sangita123", "qwfsrt56"),
("Mrunal", "Barade", "mrunal23@gmail.com", "9845855245","HNO. 42 Pune", "2000-12-12", "458775623541","__mrunal_", "qowusrt56"),
("Eshwari", "Burlawar", "eshari01@gmail.com", "4585655245","HNO. 37 Mumbai", "2001-10-18", "458762623541","eshwari04", "iofsrt56"),
("Rahul", "Joshi", "rahul23@gmail.com", "4545655245","HNO. 23 Bangalore", "2000-02-28", "569769523541","_rahuk09", "q5fsrt56"),
("Aanchal", "Joshi", "aanchal1@gmail.com", "9845755245","HNO. 67 Delhi", "2001-10-14", "458756523541","anchal32_", "kwfsrt56");

INSERT INTO PRODUCT 
(PRODUCT_ID, PRODUCT_NAME, PRODUCT_COUNT, TOTAL_STOCK, BEST_BEFORE, PRICE_PER_UNIT)
VALUES
(10001, "Apple", 200, 500, '2023-03-23', 150),
(10002, "Tomato", 80, 600, '2023-03-30', 50),
(10003, "Coffe", 40, 800, '2023-05-23', 250),
(10004, "Turmeric", 50, 30, '2023-03-23', 150);

INSERT INTO ORDER_DETAILS
(ORDER_ID, PRODUCT_NAME, QUANTITY, TOTAL_PRICE, PRODUCT_ID, LOGIN_ID)
VALUES 
("1001","Coffee", 5 ," #trigger ", 10003, "anchal32"),
("1002","Coffee", 5 ," #trigger ", 10003, "anchal32"),
("1003","Coffee", 5 ," #trigger ", 10003, "_mrunal_");

#DELETE COMMANDS
DELETE FROM PRODUCT 