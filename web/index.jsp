<%--
  User: Administrator
  Date: 2016-5-19
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="test.PostDemo" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
  <%
    PostDemo pd = new PostDemo();
    out.println(pd.postData());
  %>
  </body>
</html>
