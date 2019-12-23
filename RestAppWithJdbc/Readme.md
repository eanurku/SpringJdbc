1.setup the mysql database in local/remote system:
https://dev.mysql.com/doc/mysql-apt-repo-quick-guide/en/#apt-repo-setup

2. add mysql jdbc connector jar in classpath:
  mysql-connector-java-8.0.18.jar
  download jar from https://www.mysql.com/products/connector/ 

add other Jars.
//TO DO

3.ant setup
   see readme.md in https://github.com/eanurku/AntBasics 
   
4. run main class by ant: 

    ant run -Dmainclass=com.jdbctemplate.selectquery.SpringJdbcGetAllStudent 

5.Start/Stop Rest Web  Service

 start the tomcat service:
  go to apache-tomcat-9.0.16/bin/
  run ./startup.sh
 
 install application war file in tomcat:
  ant  install

  uninstall previous war file and install latest war in tomcat:
  ant uninstall install
  
 launch the rest service now.....
   http://localhost:8080//RestAppWithJdbc/plainjdbc/testget
   
   
 stop tomcat service:
  go to apache-tomcat-9.0.16/bin/
  run ./shutdown.sh
  
--------------------------------------------------------------------
StudentRestControllerWithPlainJdbc
--------------------------------------------------------------------
1.Get Request:Test
 method   url
  GET     http://localhost:8080//RestAppWithJdbc/plainjdbc/testget
 Headers:
   Accept:application/xml
 
 response:
 <List>
 <item>
 <student_id>0</student_id>
 <student_name>monu</student_name>
 <contact>232</contact>
  </item>
 <item>
 <student_id>0</student_id>
 <student_name>gonu</student_name>
 <contact>321</contact>
  </item>
  </List>
   
2. POST Request:Test
 *  json content:
    method  Url
     POST    http://localhost:8080//RestAppWithJdbc/plainjdbc/testpost 
    Headers:
     Accept:application/xml
     Content-Type:application/json
    Body:
     {"student_name":"monu","contact":"5343"}
     
    response:
     <Boolean>true</Boolean>
     
 *  xml content:
    method  Url
     POST    http://localhost:8080//RestAppWithJdbc/plainjdbc/testpost 
    Headers:
     Accept:application/json
     Content-Type:application/xml
    Body:
     <Student>
     <student_name>anurag</student_name>
     <contact>9007794652</contact>
     </Student>
    
    response:
     true
    
3.POST Request:Insert in DB
 *  xml content:
      method  Url
           POST    http://localhost:8080//RestAppWithJdbc/plainjdbc/addStudent
      Headers:
           Accept:application/json
           Content-Type:application/xml
      Body:
        <Student>
         <student_name>anuragx</student_name>
         <contact>9007732</contact>
         </Student>
      response:
         true
 *  json content:
     method  Url
      POST    http://localhost:8080//RestAppWithJdbc/plainjdbc/addStudent 
     Headers:
      Accept:application/xml
      Content-Type:application/json
     
     Body:
       {"student_name": "monu","contact": "5343"}
       
     response:
      <Boolean>true</Boolean>   
            
4.GET Request:get from DB
   method  Url
   GET     http://localhost:8080//RestAppWithJdbc/plainjdbc/getStudent/anuragx
  
   Headers:
    Accept:application/xml
   
   Response:
    <List>
         <item>
             <student_id>32</student_id>
             <student_name>anuragx</student_name>
             <contact>9007732</contact>
         </item>
         <item>
             <student_id>33</student_id>
             <student_name>anuragx</student_name>
             <contact>9007732</contact>
         </item>
         <item>
             <student_id>34</student_id>
             <student_name>anuragx</student_name>
             <contact>9007732</contact>
         </item>
     </List>
-----------------------------------------------------------
StudentRestControllerWithJdbcTemplate
-----------------------------------------------------------
1.Get Request: Test
*XML response:
   method  Url
   GET     http://localhost:8080//RestAppWithJdbc/test
   
   Headers:
    Accept:application/xml
    
   Response:
    <Student>
        <student_id>0</student_id>
        <student_name>anurag</student_name>
        <contact>542</contact>
    </Student>
    
*Json Response:
   Method  Url
   GET     http://localhost:8080//RestAppWithJdbc/test
   
   Headers:
    Accept:application/json
    
   Response:
        {
        "student_id": 0,
        "student_name": "anurag",
        "contact": 542
        }
        
2 Get Request: Read from DB
*XML Respsonse:
   method  Url
   GET     http://localhost:8080//RestAppWithJdbc/getStudents
   
   Headers:
    Accept:application/xml

   Response:
    <List>
    <item>
    <student_id>1</student_id>
    <student_name>s1</student_name>
    <contact>231</contact>
     </item>
    <item>
    <student_id>2</student_id>
    <student_name>ss</student_name>
    <contact>12</contact>
     </item>
     </List>
*Json Response:
   method  Url
   GET     http://localhost:8080//RestAppWithJdbc/getStudents
   
   Headers:
    Accept:application/json
   Response:
    [{"student_id":1,"student_name":"s1","contact":231},
    {"student_id":2,"student_name":"ss","contact":12},
    {"student_id":3,"student_name":"sx1","contact":543}
    ]
    
    
    
3.GET Request:Read from DB
*XML Response:
   method  Url
    GET     http://localhost:8080//RestAppWithJdbc/getStudent/32
   
   Headers:
     Accept:application/xml
    
   Response:
    <Student>
      <student_id>32</student_id>
      <student_name>anuragx</student_name>
      <contact>9007732</contact>
    </Student> 
*Json Response
   method  Url
    GET     http://localhost:8080//RestAppWithJdbc/getStudent/32
   
   Headers:
     Accept:application/json
    
   Response:
    {"student_id":32,"student_name":"anuragx","contact":9007732}
    
    
4.POST Request:insert in DB
*XML Request Body
   Method  Url
   POST     http://localhost:8080//RestAppWithJdbc/addStudent
   
   Headers:
     Accept:application/xml
     Content-Type:application/xml
     
   Body:
    <Student>
      <student_name>anuragx1</student_name>
      <contact>9007732</contact>
    </Student>    
    
   response:
    <Integer>1</Integer>
    
*Json Request Body
   Method  Url
   POST     http://localhost:8080//RestAppWithJdbc/addStudent
   
   Headers:
     Accept:application/json
     Content-Type:application/json
   Body:
       {"student_name":"anuragxx","contact":9007732}
   Response:
    1

5.POST Request:Insert in DB
*XML RequestBody
   Method  Url
   POST     http://localhost:8080//RestAppWithJdbc/addStudents
   
   Headers:
     Accept:application/xml
     Content-Type:application/xml
     
   Body:
    <List>
     <item>
       <student_name>ax1</student_name>
       <contact>231</contact>
     </item>
     <item>
       <student_name>ax2</student_name>
       <contact>12</contact>
     </item>
    </List>
                 or 
    <List>
	 <Student>
         <student_name>ax1</student_name>
         <contact>231</contact>
	 </Student>
     <Student>
        <student_name>ax2</student_name>
         <contact>12</contact>
     </Student>
     </List>
    
   Response:
    <Integer>2</Integer>

*Json Request Body
   Method  Url
   POST     http://localhost:8080//RestAppWithJdbc/addStudents
   
   Headers:
     Accept:application/json
     Content-Type:application/json
   Body:
   [
       {"student_name":"sq1","contact":231},
       {"student_name":"qss","contact":12},
       {"student_name":"qsx1","contact":543}
    ]
   Response:
    3
      
--------------------------------------------------