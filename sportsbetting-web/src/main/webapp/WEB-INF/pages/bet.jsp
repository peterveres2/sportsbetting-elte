<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<div class="box" id="event-box">
	<div class="box-header"><spring:message code="bet.eventheader"/></div>
	<table>
		<tr>
			<th><spring:message code="bet.title"/></th>
			<th><spring:message code="bet.type"/></th>
			<th><spring:message code="bet.time"/></th>
			<th><spring:message code="bet.timeleft"/></th>
		</tr>
		<tr>
			<td>{{event.title}}</td>
			<td>{{event.type}}</td>
			<td>{{event.start.toLocaleString()}} -
				{{event.end.toLocaleTimeString()}}</td>
			<td>{{ event.countdown }}</td>
		</tr>
	</table>
</div>

<div class="box" id="bets-box">
	<div class="box-header"><spring:message code="bet.betheader"/></div>
	<table>
		<tr>
			<th>#</th>
			<th><spring:message code="bet.betdesc"/></th>
			<th><spring:message code="bet.betdesc"/></th>
			<th></th>
		</tr>
		<tr ng-repeat="bet in bets">
			<td>{{ $index + 1 }}</td>
			<td>{{bet.description}}</td>
			<td>{{bet.type}}</td>
			<td><form ng-submit="placeWager(bet)"><button><spring:message code="bet.registerwager"/></button></form></td>
		</tr>
	</table>
</div>