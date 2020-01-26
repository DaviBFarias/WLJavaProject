<%@ page contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<nav>
	<ul class="lists">
		<li>
			<s:url var="menuRegister" value="index"></s:url>
			<s:a href="%{menuRegister}"><s:text name="text.menuRegister"></s:text></s:a>
		<li/>
		<li>
			<s:url var="menuList" value="list"></s:url>
			<s:a href="%{menuList}"><s:text name="text.menuList"></s:text></s:a>
		<li/>
	</ul>
</nav>