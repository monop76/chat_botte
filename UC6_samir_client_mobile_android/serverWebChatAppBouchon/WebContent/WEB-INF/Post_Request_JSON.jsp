<%@page language="java" contentType="application/json; charset=UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object>
	<json:property name="expediteur" value="expediteur lambda"/>
	<json:property name="contenu" value="Un message quelconque pour vérifier que la requête POST avec paramètres en JSON et son retour, fonctionne correctement."/>
</json:object>