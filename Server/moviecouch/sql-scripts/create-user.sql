CREATE USER 'moviecouch'@'localhost' IDENTIFIED BY 'moviecouch';

GRANT ALL PRIVILEGES ON * . * TO 'moviecouch'@'localhost';

ALTER USER 'moviecouch'@'localhost' IDENTIFIED WITH mysql_native_password BY 'moviecouch';
