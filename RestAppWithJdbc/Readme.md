1.mysql setup
2.ant setup
    run mainclass with  command like this :
    ant run -Dmainclass=com.jdbctemplate.selectquery.SpringJdbcGetAllStudent 

3.json/xml format for GET/POST/PUT request.

put request:
header:
 Accept:
 content-type:

request body:
<Student>
<student_id>2</student_id>
<student_name>anurag</student_name>
<contact>9007794652</contact>
</Student>

<List>
<item>
<student_id>1</student_id>
<student_name>p31</student_name>
<contact>2134</contact>
</item>
<item>
<student_id>249</student_id>
<student_name>p31</student_name>
<contact>2134</contact>
</item>
<item>
<student_id>252</student_id>
<student_name>p31</student_name>
<contact>2134</contact>
</item>
<item>
<student_id>254</student_id>
<student_name>p31</student_name>
<contact>2134</contact>
</item>
<item>
<student_id>256</student_id>
<student_name>p31</student_name>
<contact>2134</contact>
</item>
<item>
<student_id>257</student_id>
<student_name>p31</student_name>
<contact>2134</contact>
</item>
<item>
<student_id>258</student_id>
<student_name>p31</student_name>
<contact>2134</contact>
</item>
</List>
{
"student_name":"monu",
"contact":"5343"
}

[{"student_name":"zonu1","contact":"987651"},
{"student_name":"zonu2","contact":"987652"}]

[{"student_id":"250","student_name":"anurag","contact":"9007794652"},
{"student_id":"251","student_name":"anurag","contact":"9007794652"},
{"student_id":"252","student_name":"anurag","contact":"9007794652"}]