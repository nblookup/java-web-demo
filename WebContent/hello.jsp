<%@ page import="org.sonyue.web.Person" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Hello World</title>
</head>
<body>
<%
    Person person = new Person();
    person.setName("alex");
    System.out.println("Hello: " + person.getName());
%>
<p>Hello World</p>
</body>
</html>
