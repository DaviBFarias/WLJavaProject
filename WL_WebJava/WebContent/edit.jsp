<%@ page contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title><s:text name="text.titleEditScreen"></s:text></title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">
@import url("styles/mainstyles.css");
</style>
</head>
<body>
	<div class="container-home">
		<h2>
			<s:text name="text.titleEditScreen"></s:text>
		</h2>
		<s:include value="navbar.jsp" />
		<s:form action="updateRegister" namespace="update" method="post" class="form">
			<p>
				<s:textfield name="username" key="label.username" class="input"
					size="100" />
			</p>
			<p>
				<s:textfield name="cpf" key="label.cpf" class="input" size="100" readonly="true" onclick="alert(infos.innerHTML)"/>
			</p>
			<p>
				<s:textfield name="datebirthday" type="date" format="dd-MM-yyyy"
					key="label.datebirthday" />
			</p>
			<s:submit method="updateRegister" key="label.update" align="center"
				class="buttonsubmit" />
			<br />
		</s:form>
		<s:actionmessage class="lists" />
	    <span id="infos" style="display:none;"><s:text name="text.alertcpf" /></span>
	</div>
</body>
</html>