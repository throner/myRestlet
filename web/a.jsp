<%--
  User: Administrator
  Date: 2016-5-23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <form name="testForm" action="api/1/2/hello" method="post" target="_blank" enctype="multipart/form-data">
        <!--<input type="text" name="test_name" value=""/>-->
        <input type="file" name="f1"/>
        <input type="button" name="test" value="TEST" onclick="document.testForm.submit()"/>
    </form>

    <form name="testForm1" action="api/1/2/hello" method="post" target="_blank">
        <!--<input type="text" name="test_name" value=""/>-->
        <input type="text" name="testName" value=""/>
        <input type="button" name="test1" value="TEST" onclick="document.testForm1.submit()"/>
    </form>
</body>
</html>
