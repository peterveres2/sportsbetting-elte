<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>

	<div class="box" id="events-box">
		<div class="box-header"><spring:message code="events.header"/></div>
		<table>
			<tr>
				<th>#</th>
				<th><spring:message code="events.title"/></th>
				<th><spring:message code="events.type"/></th>
				<th><spring:message code="events.time"/></th>
				<th ng-show="eventLeft()"><spring:message code="events.timeleft"/></th>
				<th ng-show="eventLeft()"></th>
				<th></th>
			</tr>
			<tr ng-repeat="event in events">
				<td>{{ $index + 1 }}</td>
				<td>{{event.title}}</td>
				<td>{{event.type}}</td>
				<td>{{event.start.toLocaleString()}} - {{event.end.toLocaleTimeString()}}</td>
				<td ng-show="yet(event)">{{ event.countdown }}</td>
				<td ng-show="yet(event)"><form ng-submit="betOnEvent(event)"><button><spring:message code="events.bet"/></button></form></td>
			</tr>
			
		</table>
	</div>
</html>