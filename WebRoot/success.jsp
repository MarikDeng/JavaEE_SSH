<%@ page language="java" import="java.util.*,po.Book" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setCharacterEncoding("GBK");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
<h1>成功</h1>
<%
	Book book = (Book)request.getAttribute("book");
	if(book!=null){
		out.println("bookId:"+book.getBookId()+"<br>");
		out.println("bookName:"+book.getBookName()+"<br>");
		out.println("bookPrice:"+book.getBookPrice()+"<br>");
		out.println("bookNum:"+book.getBookNum()+"<br>");
		
	}
 %>
</body>
</html>