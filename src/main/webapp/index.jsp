<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title></title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
</head>

<body>
	<form action="/file/operation/imgsUpload.action" method="post"
		enctype="multipart/form-data">
		文件一：<input type="file" name="file1" /> <br> 文件二：<input
			type="file" name="file2" /> <br> <input type="submit"
			value="提交" />
	</form>
</body>
</html>
