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

<form name="hello" action="${pageContext.request.contextPath}/servlet?hello=hello" method="get">
    <input type="hidden" name="id" value="654321">

    <label>username:</label><input type="text" name="user"/>
    <br>
    <label>password:</label><input type="password" name="password"/>

    <br><br>
    <input type="checkbox" name="check" value="aa"/>
    <input type="checkbox" name="check" value="ab"/>
    <input type="checkbox" name="check" value="ac"/>
    <input type="checkbox" name="check" value="ad"/>

    <br>
    <button type="submit">Submit</button>
</form>

</body>
</html>
