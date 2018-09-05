<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
	<div class="box" id="player-info">
		<div class="box-header"><spring:message code="status.accountdetails"/></div>
		<form class="box-content" ng-submit="send(player)" name="registerForm" ng-model-options="{ updateOn: 'submit' }">
				<div class="input-with-label">
				<label><spring:message code="status.name"/></label>
				<input type="text" ng-model="player.name" ng-required="true" name="name"></input><br/>
				</div>
				<div class="warning" ng-show="registerForm.name.$dirty && registerForm.name.$error.required">Name required for registration.</div>
				<div class="input-with-label">
				<label><spring:message code="status.dateofbirth"/></label>
				<input type="date" ng-model="player.dateOfBirth"></input>
				</div>
				<div class="input-with-label">
				<label><spring:message code="status.accountnumber"/></label>
				<input type="text" ng-model="player.accountNumber" name="accountNumber" ng-pattern="/[\s-\d]+$/" ng-readonly="player.accountNumber!=null"></input>
				</div>
				<div class="warning" ng-show="registerForm.accountNumber.$dirty && registerForm.accountNumber.$invalid">Please enter valid account number.</div>
				<div class="input-with-label">
				<label><spring:message code="status.balance"/></label>
				<input type="number" ng-model="player.balance" min="0"  ng-readonly="true"></input><br/>
				</div>
				<div class="input-with-label">
				<label><spring:message code="status.currency"/></label>
				<select ng-model="player.currency" ng-readonly="player.currency!=null">
 				    <option value="HUF" ng-show="player.currency==null || player.currency=='HUF'">HUF</option>
  					<option value="EUR" ng-show="player.currency==null || player.currency=='EUR'">EUR</option>
 						<option value="USD" ng-show="player.currency==null || player.currency=='USD'">USD</option>
				</select>
				</div>
				<button>Save</button>
		</form>
	</div>

	<div class="box" id="wagers-box">
		<div class="box-header"><spring:message code="status.wagers"/></div>
		<table>
			<tr>
				<th>#</th>
				<th><spring:message code="status.eventtitle"/></th>
				<th><spring:message code="status.eventtype"/></th>
				<th><spring:message code="status.bettype"/></th>
				<th><spring:message code="status.betdesc"/></th>
				<th><spring:message code="status.outcomevalue"/></th>
				<th><spring:message code="status.outcomeodd"/></th>
				<th><spring:message code="status.amount"/></th>
				<th><spring:message code="status.winner"/></th>
				<th><spring:message code="status.processed"/></th>
				<th></th>
			</tr>
			<tr ng-repeat="wager in wagers">
				<td>{{ $index + 1 }}</td>
				<td>{{wager.eventTitle}}</td>
				<td>{{wager.eventType}}</td>
				<td>{{wager.betType}}</td>
				<td>{{wager.betDescription}}</td>
				<td>{{wager.outcomeValue}}</td>
				<td>{{wager.oddValue}}</td>
				<td>{{wager.amount}} {{wager.currency}}</td>
				<td>{{wager.winner ? 'Yes' : 'No'}}</td>
				<td>{{wager.processed ? 'Yes' : 'No'}}</td>
				<td ng-hide="{{wager.processed}}">
				<form ng-submit="removeWager(wager.id)"><button id="removeButton"><spring:message code="status.remove"/></button></form>
				</td>
			</tr>

		</table>
	</div>
</html>
