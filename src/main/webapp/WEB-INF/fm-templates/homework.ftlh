<html>
<head>
    <title>Homework_5</title>
</head>
<body>
<h2>${name} ${surname}</h2>
<h2>${teamName}</h2>
<h2>${date}</h2>

<form method="post" action="http://localhost:8080/homework-5/infoShareAcademy">
    parameter1: <input type="text" name="parameter1"/><input type="text" name="parameter1"/><br/><br/>
    parameter2: <input type="text" name="parameter2"/><br/><br/>
    parameter3: <input type="text" name="parameter3"/><br/><br/>
    <input type="submit" value="save"/><br/><br/>
</form>
<#list parameters as parameter>
<ul>
    <li>${parameter1}</li>
    <li>${parameter2}</li>
    <li>${parameter3}</li>
</ul>
</#list>
</body>
</html>