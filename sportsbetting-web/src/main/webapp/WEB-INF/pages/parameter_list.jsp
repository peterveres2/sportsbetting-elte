<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>

	<div class="box">
		<div class="box-header"><spring:message code="parameterist.header"/></div>
		<table>
			<tr>
				<th><spring:message code="parameterist.parameter"/></th>
				<th><spring:message code="parameterist.value"/></th>
			</tr>
			<tr ng-repeat="(key, value) in parameterList">
				<td>{{ key }}</td>
				<td>{{ value }}</td>
			</tr>
		</table>
	</div>
</html>