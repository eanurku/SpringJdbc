1.setup the mysql database in local/remote system:
https://dev.mysql.com/doc/mysql-apt-repo-quick-guide/en/#apt-repo-setup

2. add mysql jdbc connector jar in classpath:
mysql-connector-java-8.0.18.jar
download jar from https://www.mysql.com/products/connector/ 

2.setup ant 
   see readme.md in https://github.com/eanurku/AntBasics 
   
3. run main class by ant: 

ant run -Dmainclass=com.resultset.JdbcResultSetInsertRow

