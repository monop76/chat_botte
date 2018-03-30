<%@page language="java" contentType="application/json; charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object>
	<json:property name="pseudo" value="un pseudo divers"/>
	<json:property name="message" value="un message au hasard"/>
	<json:property name="contact" value="un contact quelconque"/>
	<json:property name="reponse" value="${requestScope.reponse}"/>
</json:object>