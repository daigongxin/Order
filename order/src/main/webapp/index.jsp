<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
<title>主页</title>
<!-- 最新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap.min.css">
<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet"
	href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap-theme.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script
	src="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/js/bootstrap.min.js"></script>
</head>

<body style="background: #eee;">
	<form class="form-horizontal" role="form" name="form1" method="post"
		action="login" namespace="/"
		style="margin: auto;width: 421px;margin-top: 200px;">
		<div class="form-group">
			<label for="inputEmail3" class="col-sm-2 control-label"> Username</label>
			<div class="col-sm-10">
				<input  class="form-control" id="inputEmail3"  name="account" type="text"
					placeholder="username">
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword3"  class="col-sm-2 control-label">Password</label>
			<div class="col-sm-10">
				<input type="password"  name="password" type="password"  class="form-control" id="inputPassword3"
					placeholder="Password">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<div class="checkbox">
					<label> <input type="checkbox"> Remember me </label>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Sign in</button>
			</div>
		</div>
	</form>
</body>

</html>
