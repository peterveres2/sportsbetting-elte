<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<div class="box" id="event-box">
	<div class="box-header"><spring:message code="wager.eventheader"/></div>
	<table>
		<tr>
			<th><spring:message code="wager.title"/></th>
			<th><spring:message code="wager.type"/></th>
			<th><spring:message code="wager.time"/></th>
			<th><spring:message code="wager.timeleft"/></th>
			<th><spring:message code="wager.betdesc"/></th>
			<th><spring:message code="wager.bettype"/></th>
		</tr>
		<tr>
			<td>{{event.title}}</td>
			<td>{{event.type}}</td>
			<td>{{event.start.toLocaleString()}} -
				{{event.end.toLocaleTimeString()}}</td>
			<td>{{ event.countdown }}</td>
			<td>{{bet.description}}</td>
			<td>{{bet.type}}</td>
		</tr>
	</table>
</div>

<div class="box" id="wager-in">
	<div class="box-header"><spring:message code="wager.wagerregheader"/></div>
	<form class="box-content" ng-submit="send(wager)" name="wagerForm">
		<table>
			<tr id="input-tr">
			<td><label><spring:message code="wager.outcome"/></label><select ng-model="wager.outcome" ng-required="true">
				<option ng-repeat="outcome in outcomes" ng-value="outcome">{{outcome.value}}</option>
			</select></td>
			<td><label><spring:message code="wager.odd"/></label><label ng-bind="wager.outcome.odd"></label></td>
			<td><label><spring:message code="wager.amount"/></label><input type="number" ng-model="wager.amount" placeholder="Amount" min="1" max="{{limit}}" ng-required="true" name="amount"></input><label>{{wager.currency}}</label></td>
			<td><label><spring:message code="wager.prize"/></label><label ng-bind="(wager.outcome && wager.amount) ? Math.floor(wager.outcome.odd * wager.amount) : ''"></label></td>
			<td><button id="wagerButton"><spring:message code="wager.wagerreg"/></button></td>
		</tr>
	</table>
	<div class="warning" ng-show="wagerForm.amount.$dirty && wagerForm.amount.$error.max"><spring:message code="errors.notenoughbalance"/> ( {{limit}} {{player.currency}}).</div>
	</form>
</div>
