1.setup the mysql database in local/remote system:
https://dev.mysql.com/doc/mysql-apt-repo-quick-guide/en/#apt-repo-setup

2. add mysql jdbc connector jar in classpath:
mysql-connector-java-8.0.18.jar
download jar from https://www.mysql.com/products/connector/ 

2.setup ant 
   see readme.md in https://github.com/eanurku/AntBasics 
   
3. run main class by ant: 

ant run -Dmainclass=com.resultset.JdbcResultSetInsertRow

commands
-----------------------
1. install mysql server(mysqld is daemon to run server)
2. login by mysql client (provided in  ~\bin folder of mysql server)
 $ mysql -u root -p
3. see all databases;
 show databases;
4. switch to a database
 use <DB>
4. see all tables in a DB
 show tables;
5. CREATE DATABASE <DB name>;

6.get all store procs in a DB:
 SHOW PROCEDURE STATUS WHERE Db = 'testdb';