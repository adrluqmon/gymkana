

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<div>
	<img src="images/logo.png" style="height:150px;width:150px" />
</div>

<div>
	<ul id="jMenu">
		
		
		<security:authorize access="isAnonymous()">
			<li><a class="fNiv" href="movies/**"></a></li>
			

		</security:authorize>
		
	</ul>
</div>

<div>
	<a href="?language=en">en</a> | <a href="?language=es">es</a>
</div>

