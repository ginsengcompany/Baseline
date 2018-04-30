<%--
  Created by IntelliJ IDEA.
  User: Antonio Biondillo
  Date: 25/04/2018
  Time: 09:18
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="index.jsp"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div class="container-fluid" style="padding-top:50px; width: 42%; ">
	<c:url var="loginUrl" value="/" />
		<form:form method="post" action="${loginUrl}">
			<div class="card mx-xl-5">
				<div class="card-body">

					<!--Header-->
					<div class="form-header deep-blue-gradient rounded">
						<h3><i class="fa fa-lock"></i> Autenticazione:</h3>
						<img src="../../static/images/baselineLogo.png" width="auto" height="150"/>
					</div>
					
					<!-- Material input email -->
					<div class="md-form font-weight-light">
						<i class="fa fa-user prefix grey-text"></i> <input id="materialFormEmailEx" type="text"
							name="ssoId" placeholder="Username" required
							class="form-control"> <label for="materialFormEmailEx"
							class="">Il tuo Username</label>
					</div>

					<!-- Material input password -->
					<div class="md-form font-weight-light">
						<i class="fa fa-lock prefix grey-text"></i> <input id="materialFormPasswordEx" type="password"
							name="password" placeholder="Password" required
							class="form-control"> <label for="materialFormPasswordEx"
							class="">La tua Password</label>
					</div>
					<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
					<div class="text-center mt-4">
						<button class="btn btn-light-blue waves-effect waves-light" type="submit" value="Log in" >Entra</button>
					</div>

				</div>

				<!--Footer-->
				<div class="modal-footer">
					<div class="options font-weight-light">
						<p>
							Password <a href="#">dimenticata?</a>
						</p>
					</div>
				</div>

			</div>
		</form:form>
</div>


