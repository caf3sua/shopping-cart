-- Insert CUSTOMER
DELETE FROM CUSTOMER;
INSERT INTO CUSTOMER (ID, FIRSTNAME, LASTNAME, EMAIL, PASSWORD) values (0, 'NAM', 'NGUYEN HOAI', 'caf3sua@gmail.com', '123456');

-- Insert FAQ
DELETE FROM FAQ;
INSERT INTO FAQ (ID, QUESTION, ANSWER) values (0, 'Gift Orders', 'Our system will allow you to shop for products for yourself and for gifts to others, for delivery at a different shipping address. ');
INSERT INTO FAQ (ID, QUESTION, ANSWER) values (1, 'How do I request a refund?', 'If you are not satisfied with the product you purchased, please contact the vendor to let them know that youd like a refund, and the reason for refund. The vendors contact information is found on your order confirmation email and on the invoice enclosed with your purchase.');
INSERT INTO FAQ (ID, QUESTION, ANSWER) values (2, 'Is the shipping charge included in the refund?', 'If the refund is due to damage or loss of the package, both the cost of the product and the shipping will be refunded.');
INSERT INTO FAQ (ID, QUESTION, ANSWER) values (3, 'How long does it take to process my refund?', 'Refunds are processed through LocalHarvest shortly after we are notified. Refunds usually appear on your online banking records 1-4 days after the refund date. The transaction record will state that the refund is from "LocalHarvest, Inc".');

-- Insert OrderStatus
DELETE FROM OrderStatus;
INSERT INTO OrderStatus (ID, NAME, DESCRIPTION) values (0, 'WAITING', 'waiting to purchase or ship');
INSERT INTO OrderStatus (ID, NAME, DESCRIPTION) values (1, 'SHIPPING', 'purcharsed, wait for shipping');
INSERT INTO OrderStatus (ID, NAME, DESCRIPTION) values (2, 'REFUND', 'return the product');
INSERT INTO OrderStatus (ID, NAME, DESCRIPTION) values (3, 'FINISHED', 'customer received the product');

-- Insert Role
DELETE FROM Role;
INSERT INTO Role (RoleId, RoleName, DESCRIPTION) values (0, 'ROLE_ADMIN', 'administator of system');
INSERT INTO Role (RoleId, RoleName, DESCRIPTION) values (1, 'ROLE_STAFF', 'staff can upload/manager the website');
INSERT INTO Role (RoleId, RoleName, DESCRIPTION) values (2, 'ROLE_USER', 'using the website');
INSERT INTO Role (RoleId, RoleName, DESCRIPTION) values (3, 'ROLE_GUEST', 'only view');

-- Insert User
DELETE FROM User;
INSERT INTO User (UserId, UserName, Password, FirstName, LastName, Address, Email) values (0, 'admin', 'admin', '', '', 'Hanoi, Vietname', 'admin@gmail.com');
INSERT INTO User (UserId, UserName, Password, FirstName, LastName, Address, Email) values (1, 'staff01', 'staff01', '', '', 'Hanoi, Vietname', 'staff01@gmail.com');
INSERT INTO User (UserId, UserName, Password, FirstName, LastName, Address, Email) values (2, 'user01', 'user01', '', '', 'Hanoi, Vietname', 'user01@gmail.com');
INSERT INTO User (UserId, UserName, Password, FirstName, LastName, Address, Email) values (3, 'guest01', 'guest01', '', '', 'Hanoi, Vietname', 'guest01@gmail.com');
INSERT INTO User (UserId, UserName, Password, FirstName, LastName, Address, Email) values (4, 'guest02', 'guest02', '', '', 'Hanoi, Vietname', 'guest02@gmail.com');

-- Insert UserRole
DELETE FROM UserRole;
INSERT INTO UserRole (Id, UserId, RoleId) values (0, 0, 0);
INSERT INTO UserRole (Id, UserId, RoleId) values (1, 0, 1);
INSERT INTO UserRole (Id, UserId, RoleId) values (2, 0, 2);
INSERT INTO UserRole (Id, UserId, RoleId) values (3, 1, 1);
INSERT INTO UserRole (Id, UserId, RoleId) values (4, 2, 2);
INSERT INTO UserRole (Id, UserId, RoleId) values (5, 3, 3);

-- Insert Category
DELETE FROM Category;
INSERT INTO Category (Id, CategoryName, CategoryCode, Image, Description) values (0, 'Apple', 'CAT000', 'cat_apple.jpg', 'Delicious and Crunchy, Apples are packed with rich Phyto-Nutrients that in the true sense are Indispensable for Optimal Health. The Antioxidants in Apple have many health promoting and disease preventing properties; thus justifying the axiom, �an Apple a day keeps the Doctor Away.�');
INSERT INTO Category (Id, CategoryName, CategoryCode, Image, Description) values (1, 'Orange', 'CAT001', 'cat_orange.jpg', 'Orange is one of the most widely consumed Fruits in the World which is juicy, sweet and renowned for its concentration of Vitamin C. The abundance of Antioxidants, vitamins, fiber and Phytonutrients in Oranges are good for skin, eyes and heart.');
INSERT INTO Category (Id, CategoryName, CategoryCode, Image, Description) values (2, 'Grapes', 'CAT002', 'cat_grapes.jpg', 'Grapes are popular mid-meal snack as well as a refreshing addition to both fruit and vegetable salads. Grapes are an outstanding source of Phytonutrients, bone-healthy Vitamin K, heart-healthy Vitamin B6 and Potassium.');
INSERT INTO Category (Id, CategoryName, CategoryCode, Image, Description) values (3, 'Pear', 'CAT003', 'cat_pear.jpg', 'Juicy and sweet, with a soft, buttery white to cream-colored flesh of Pears was once referred to as the "Gift of the Gods". They are an excellent source of fiber and a good source of Vitamin C. Pears is sodium free, fat free, and cholesterol free.');

-- Insert Brand
DELETE FROM Brand;
INSERT INTO Brand (Id, BrandName, BrandCode, ImageLogo, Description) values (0, 'Frrutto Inc.', 'INC001', '', 'Frrutto Fresh India Pvt. Ltd introduces the customers to a whole new shopping Experience to buy Fresh Fruits online. Free Home Delivery in Chennai.');

-- Insert Product
DELETE FROM Product;
INSERT INTO Product (Id, Name, Code, PurchasePrice, SalePrice, BrandId, CategoryId, Quantity, Description, Image) values (0, 'US Washington Red Delicious', 'FS001', 1 , 1.5, 0, 0, 1000, 'Red Delicious is one of the most famous American apples. Ruby red in color with a classic heart shape these Apples are Sweet, Crunchy and Juicy. The dark and intense crimson color makes it look great.', 'pro_apple_1.jpg');
INSERT INTO Product (Id, Name, Code, PurchasePrice, SalePrice, BrandId, CategoryId, Quantity, Description, Image) values (1, 'Indian Apple', 'FS002', 2 , 3, 0, 0, 1000, 'Crisp, sweet and aromatic Apples indigenous to Shimla, continues to remain most sought after fruit in the valley. Russeting on apples is a particular type of skin, slightly rough, usually with a greenish-brown to yellowish-brown colour.', 'pro_apple_2.jpg');
INSERT INTO Product (Id, Name, Code, PurchasePrice, SalePrice, BrandId, CategoryId, Quantity, Description, Image) values (2, 'France Gala', 'FS003', 3 , 3.75, 0, 0, 1000, 'Gala is a round France Apple that has its own unique flavor. It is Dense, Sweet, Aromatic and Crunchy with a White Flesh. With a blush of pink of the skin, the color varies from Yellow to almost Orange with Deep Orange Stripes.', 'pro_apple_3.jpg');
INSERT INTO Product (Id, Name, Code, PurchasePrice, SalePrice, BrandId, CategoryId, Quantity, Description, Image) values (3, 'Imported Orange', 'FS004', 1 , 1.25, 0, 1, 1000, 'Navel Oranges are fleshy and the thick rinds are easy to peel. The segments separate easily, and they have no seeds. Navel Oranges are rich in Beta Carotene that prevents and repairs cell damage.', 'pro_orange_1.jpg');
INSERT INTO Product (Id, Name, Code, PurchasePrice, SalePrice, BrandId, CategoryId, Quantity, Description, Image) values (4, 'Sathukudi / Mausambi', 'FS005', 1 , 1.25, 0, 1, 1000, 'Grown in the Indian soil, Sathukudi is very rich in essential oils that are required to sustain the immense heat of the Indian summer. The fruit can be eaten fresh but serves great when used as a Juice fruit.', 'pro_orange_2.jpg');
INSERT INTO Product (Id, Name, Code, PurchasePrice, SalePrice, BrandId, CategoryId, Quantity, Description, Image) values (5, 'Oranges - Valencia - South Africa', 'FS006', 1 , 1.25, 0, 1, 1000, 'Known as the �Ultimate Juicer�, these late season Oranges are heavy with juice and have a sweet, delicate texture. Valencia Oranges are great choices for both eating and juicing.', 'pro_orange_3.jpg');
INSERT INTO Product (Id, Name, Code, PurchasePrice, SalePrice, BrandId, CategoryId, Quantity, Description, Image) values (6, 'Red Globe Grapes - California - with seed', 'FS007', 1 , 1.5, 0, 2, 1000, 'Light pink to dark, Red Globe Grapes one of the most satisfying grape varieties. These grapes are large, plump, sweet, crunchy and juicy seeded sweet bombs.', 'pro_grapes_1.jpg');
INSERT INTO Product (Id, Name, Code, PurchasePrice, SalePrice, BrandId, CategoryId, Quantity, Description, Image) values (7, 'Green Grapes - Indian - with seed', 'FS008', 1 , 1.75, 0, 2, 1000, 'This variety is grown in Karnataka. Berries are greenish yellow, elongated and medium large, seeded with medium thick skin. Juice is clear and sweet with TSS 14-16%. Variety has a poor keeping quality and is used for table purpose. It is susceptible to rust and downy mildew.', 'pro_grapes_2.jpg');
INSERT INTO Product (Id, Name, Code, PurchasePrice, SalePrice, BrandId, CategoryId, Quantity, Description, Image) values (8, 'Panneer Grapes -Indian Gulabi - with seed', 'FS009', 1 , 2, 0, 2, 1000, 'This variety is grown in Tamil Nadu. Berries are small in size, deep purple, spherical and seeded. The sugar level in TSS is 18-20%. This variety has a good keeping quality and is used for table purpose. Variety is susceptible to rust and downy mildew.', 'pro_grapes_3.jpg');
INSERT INTO Product (Id, Name, Code, PurchasePrice, SalePrice, BrandId, CategoryId, Quantity, Description, Image) values (9, 'Pear - Shangdong', 'FS010', 1 , 2.25, 0, 3, 1000, 'This medium sized inverted oval shape Pear hails from the land of China. The flesh color is white and the fruit is a crispy, juicy, and scented that may taste both sweet and sour.', 'pro_pear_1.jpg');
INSERT INTO Product (Id, Name, Code, PurchasePrice, SalePrice, BrandId, CategoryId, Quantity, Description, Image) values (10, 'Pear - Ya Pear', 'FS011', 1 , 2.5, 0, 3, 1000, 'A large bell-shaped Pear with a greenish-yellow skin, these Pears looks a little rusty. The fruit has a tender white flesh with a sweet-tart flavor.', 'pro_pear_2.jpg');

-- Insert SHoppingCart

-- Insert Attribute

-- Insert ProductAttribute

-- Insert OrderProduct

-- Insert OrderDetail
