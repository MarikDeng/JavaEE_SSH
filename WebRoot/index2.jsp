<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setCharacterEncoding("GBK");
%>
<jsp:useBean id = "book" class="po.Book"></jsp:useBean>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <form action="/JavaEETask3/doInsert2.action" method="post">
    	bookId<input type="text" name="bookId"/><br>
    	bookName<input type="text" name="bookName"/><br>
    	bookPrice<input type="text" name="bookPrice"/><br>
    	bookNum<input type="text" name="bookNum"/><br>
    	<input type="submit" value="提交" name="submit" />
    </form>
    
    <form action="/JavaEETask3/doQuery2.action" method="post">
    	搜索书目：<input type="text" name="bookId"/><input type="submit" value="搜索">
    </form>
    
    <form action="/JavaEETask3/doUpdate2.action" method="post">
    	要更改的书目ID：<input type="text" name="bookId"/>
    	数量：<input type="text" name="bookNum" />
    	<input type="submit" value="更新">
    </form>
    
  </body>
</html>
