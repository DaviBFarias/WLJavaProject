<%@ page contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title><s:text name="text.titleRegisterScreen"></s:text></title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">
@import url("styles/mainstyles.css");
</style>
</head>
<body>
	<div class="container-home">
		<h2>
			<s:text name="text.register"></s:text>
		</h2>
		<s:include value="navbar.jsp" />
		<p>Page not found</p>
		<s:actionmessage class="lists" />
	</div>
</body>
</html>