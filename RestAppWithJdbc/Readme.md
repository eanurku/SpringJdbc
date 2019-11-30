
put request:
header:
 Accept:
 content-type:

Request body:
 json/xml format data
------------------

sample xml request body for put call:

<Student>
<student_id>2</student_id>
<student_name>anurag</student_name>
<contact>9007794652</contact>
</Student>


sample json request body for put call:

single value:
{
"student_name":"monu",
"contact":"5343"
}

multiple value:

[{"student_name":"zonu1","contact":"987651"},
{"student_name":"zonu2","contact":"987652"}]

----------------------
batchupdate:

[{"student_id":"250","student_name":"anurag","contact":"9007794652"},
{"student_id":"251","student_name":"anurag","contact":"9007794652"},
{"student_id":"252","student_name":"anurag","contact":"9007794652"}]