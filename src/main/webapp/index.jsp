<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en-US">

<head>
<meta charset="UTF-8">
<title>文章上传</title>
	<%
		out.print("<h1>上传文章</h1>");
	%>
</head>

<body>
	<!-- 配置文件 -->
	<script type="text/javascript" src="ueditor/ueditor.config.js"></script>
	<!-- 编辑器源码文件 -->
	<script type="text/javascript" src="ueditor/ueditor.all.js"></script>

	<form
		action="${pageContext.request.contextPath}/article/operation/uploadArticle.action"
		method="post">
		<b>文章ID:</b><br>
		<td><input type="number" name="id" value="1"></td><br>
		<!-- 加载编辑器的容器 -->
		<script id="container" type="text/plain">
          	  这里写你的初始化内容
        </script>
		<script type="text/javascript">
			var editor = new baidu.editor.ui.Editor({
				textarea : 'content'
			});
			editor.render("container");//这里的参数要跟容器的id一致
		</script>
		<input type="submit" value="submit"> <br>
	</form>
</body>
</html>
