<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/3/12 0012
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品列表</title>
</head>
<body>
    <table class="easyui-datagrid" style="width:400px;height:250px"
       data-options="url:'datagrid_data.json',fitColumns:true,singleSelect:true">
    <thead>
    <tr>
        <th data-options="field:'code',width:100">Code</th>
        <th data-options="field:'name',width:100">Name</th>
        <th data-options="field:'price',width:100,align:'right'">Price</th>
    </tr>
    </thead>
    </table>
</body>
</html>
