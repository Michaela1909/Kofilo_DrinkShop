# insert category
INSERT INTO category VALUES (CategoryID, 'Hot');
INSERT INTO category VALUES (CategoryID, 'Iced');
INSERT INTO category VALUES (CategoryID, 'Signature');

# insert minuman jenis "hot"
INSERT INTO minuman VALUES (MinumanID, 'Hot Americano', '1', 35000);
INSERT INTO minuman VALUES (MinumanID, 'Hot Cappucino', '1', 45000);
INSERT INTO minuman VALUES (MinumanID, 'Hot Espresso', '1', 35000);
INSERT INTO minuman VALUES (MinumanID, 'Hot Latte', '1', 40000);
# insert minuman jenis "iced"
INSERT INTO minuman VALUES (MinumanID, 'Iced Americano', '2', 30000);
INSERT INTO minuman VALUES (MinumanID, 'Iced Cappucino', '2', 30000);
INSERT INTO minuman VALUES (MinumanID, 'Iced Mocaccino', '2', 35000);
INSERT INTO minuman VALUES (MinumanID, 'Iced Vanilla Latte', '2', 45000);
# insert minuman jenis "signature"
INSERT INTO minuman VALUES (MinumanID, 'Caramel Machiato', '3', 45000);
INSERT INTO minuman VALUES (MinumanID, 'Java Chip Frape', '3', 45000);
INSERT INTO minuman VALUES (MinumanID, 'Matcha Frappe', '3', 55000);
INSERT INTO minuman VALUES (MinumanID, 'Salted Caramel Latte', '3', 55000);

#Insert NamaBahan
INSERT INTO NamaBahan VALUES (NamaBahanID, 'Kopi Bubuk', 0, 50);
INSERT INTO NamaBahan VALUES (NamaBahanID, 'Susu Full Cream', 0,30);
INSERT INTO NamaBahan VALUES (NamaBahanID, 'Cokelat Bubuk', 0, 50);
INSERT INTO NamaBahan VALUES (NamaBahanID, 'Sirup Vanilla', 0, 45);
INSERT INTO NamaBahan VALUES (NamaBahanID, 'Saus Karamel', 0, 45);
INSERT INTO NamaBahan VALUES (NamaBahanID, 'Saus Cokelat', 0, 45);
INSERT INTO NamaBahan VALUES (NamaBahanID, 'Whipped Cream', 0, 30);
INSERT INTO NamaBahan VALUES (NamaBahanID, 'Susu Kental Manis', 0, 20);
INSERT INTO NamaBahan VALUES (NamaBahanID, 'Garam', 0, 5);
INSERT INTO NamaBahan VALUES (NamaBahanID, 'Chocolate chips', 0, 30);
INSERT INTO NamaBahan VALUES (NamaBahanID, 'Gula Merah' , 0, 10);
INSERT INTO NamaBahan VALUES (NamaBahanID, 'Gula Putih', 0, 10);
INSERT INTO NamaBahan VALUES (NamaBahanID, 'Susu Fresh Milk', 0, 30);
INSERT INTO NamaBahan VALUES (NamaBahanID, 'Bubuk Matcha', 0, 30);
INSERT INTO NamaBahan VALUES (NamaBahanID, 'Creamer Bubuk', 0, 20);

#insert Bahan pada minuman 
-- Hot Amricano -- 
INSERT INTO Bahan VALUES (BahanID, 1, 1, 20); 

-- Hot Cappucino --
INSERT INTO Bahan VALUES (BahanID, 1, 2, 5); 
INSERT INTO Bahan VALUES (BahanID, 11, 2, 5); 
INSERT INTO Bahan VALUES (BahanID, 3, 2, 2); 
INSERT INTO Bahan VALUES (BahanID, 12, 2, 10); 
INSERT INTO Bahan VALUES (BahanID, 7, 2, 50); 

-- HOT Espresso -- 
INSERT INTO Bahan VALUES (BahanID, 1, 3, 20); 

-- HOT LATTE --
INSERT INTO Bahan VALUES (BahanID, 1, 4, 10); 
INSERT INTO Bahan VALUES (BahanID, 13, 4, 150); 
INSERT INTO Bahan VALUES (BahanID, 12, 4, 25); 

-- Iced Americano --
INSERT INTO Bahan VALUES (BahanID, 1, 5, 20); 

-- Iced Cappucino -- 
INSERT INTO Bahan VALUES (BahanID, 1, 6, 5); 
INSERT INTO Bahan VALUES (BahanID, 11, 6, 5); 
INSERT INTO Bahan VALUES (BahanID, 3, 6, 2); 
INSERT INTO Bahan VALUES (BahanID, 12, 6, 10); 
INSERT INTO Bahan VALUES (BahanID, 7, 6, 50); 

 -- Iced Moccacino -- 
INSERT INTO Bahan VALUES (BahanID, 1, 7, 2); 
INSERT INTO Bahan VALUES (BahanID, 11, 7, 5); 
INSERT INTO Bahan VALUES (BahanID, 3, 7, 5); 
INSERT INTO Bahan VALUES (BahanID, 12, 7, 10); 
INSERT INTO Bahan VALUES (BahanID, 7, 7, 50); 

-- Iced Vanilla Latte --
INSERT INTO Bahan VALUES (BahanID, 1, 8, 5); 
INSERT INTO Bahan VALUES (BahanID, 13, 8, 200); 
INSERT INTO Bahan VALUES (BahanID, 12, 8, 5); 
INSERT INTO Bahan VALUES (BahanID, 4, 8, 20); 

-- Caramel Machiato -- 
INSERT INTO Bahan VALUES (BahanID, 4, 9, 20); 
INSERT INTO Bahan VALUES (BahanID, 2, 9, 150); 
INSERT INTO Bahan VALUES (BahanID, 1, 9, 5); 
INSERT INTO Bahan VALUES (BahanID, 5, 9, 10); 
INSERT INTO Bahan VALUES (BahanID, 7, 9, 100); 

-- Java Chip Frappe -- 
INSERT INTO Bahan VALUES (BahanID, 1, 10, 5); 
INSERT INTO Bahan VALUES (BahanID, 13, 10, 60); 
INSERT INTO Bahan VALUES (BahanID, 6, 10, 20); 
INSERT INTO Bahan VALUES (BahanID, 10, 10, 20); 

-- Matcha Frappe -- 
INSERT INTO Bahan VALUES (BahanID, 14, 11, 10); 
INSERT INTO Bahan VALUES (BahanID, 7, 1, 100); 
INSERT INTO Bahan VALUES (BahanID, 13, 11, 200); 
INSERT INTO Bahan VALUES (BahanID, 15, 11, 20); 
INSERT INTO Bahan VALUES (BahanID, 8, 11, 180); 

-- Salted Caramel Latte -- 
INSERT INTO Bahan VALUES (BahanID, 1, 12, 10); 
INSERT INTO Bahan VALUES (BahanID, 15, 12, 10); 
INSERT INTO Bahan VALUES (BahanID, 13, 12, 55); 
INSERT INTO Bahan VALUES (BahanID, 9, 12, 1); 



