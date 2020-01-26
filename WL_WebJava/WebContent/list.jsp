<%@ page contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title><s:text name="text.titleListScreen"></s:text></title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">
@import url("styles/mainstyles.css");
</style>
</head>
<body>
	<div class="container-others">
		<h2>
			<s:text name="text.list"></s:text>
		</h2>
		<s:include value="navbar.jsp" />
		<div class="box">
			<table id="tableList">
				<tr class="tableTrList">
					<th><s:text name="label.username" /></th>
					<th><s:text name="label.cpf" /></th>
					<th><s:text name="label.datebirthday" /></th>
					<th><s:text name="label.password" /></th>
					<th><s:text name="label.edit" /></th>
				</tr>
				<s:iterator value="list">
					<tr class="tableTrList">
						<td><s:property value="name"/></td>
						<td><s:property value="cpf"/></td>
						<td><s:property value="dateBirthday"/></td>
						<td><s:property value="password"/></td>
						<td>
							<s:url var="excludeOption" action="exclude" ><s:param name="cpf" value="%{cpf}" /></s:url>
							<s:a href="%{excludeOption}" onclick="alert('CPF %{cpf} excluído com sucesso!')"><s:text name="text.delete"></s:text></s:a>
							/
							<s:url var="updateOption" action="update" >
								<s:param name="username" value="%{name}" />
								<s:param name="cpf" value="%{cpf}" />
								<s:param name="datebirthday" value="%{dateBirthday}" />
							</s:url>
							<s:a href="%{updateOption}" ><s:text name="text.edit"></s:text></s:a>
						</td>
					</tr>
				</s:iterator>
			</table>
		</div>
		<s:actionmessage class="lists" />
	</div>
</body>
</html>