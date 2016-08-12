CREATE PROCEDURE booksByPrice(IN fromPrice decimal(8,2),IN toPrice decimal(8,2) )
 BEGIN
 SELECT isbn,autor,titel,preis
 FROM buch
 WHERE preis >= fromPrice and preis <= toPrice;
 END//