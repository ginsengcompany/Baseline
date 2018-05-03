<%--
  Created by IntelliJ IDEA.
  User: Antonio Biondillo
  Date: 30/04/2018
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="navigation.jsp" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<main>
    <div class="card card-cascade">

        <!-- Card image -->
        <div class="view gradient-card-header blue-gradient">

            <!-- Title -->
            <h2 class="card-header-title mb-3">Cerca Paziente</h2>
            <!-- Subtitle -->
            <p class="card-header-subtitle mb-0">Inserisci il Codice Fiscale:</p>

        </div>

        <!-- Card content -->
        <div class="card-body ">

            <c:url var="cercaPaziente" value="/dashboard/infoPaziente" />
            <form:form method="POST" action="${cercaPaziente}" name="cercaPaziente">
                <!-- Material input name -->
                <div class="md-form form-sm">
                    <i class="fa fa-address-book prefix"></i>
                    <input type="text" id="materialFormNameModalEx1" class="form-control form-control-sm" name="codiceFiscale" required>
                    <label for="materialFormNameModalEx1">Codice Fiscale</label>
                </div>
                <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
                <span id="alertErr" class="badge badge-danger" style="display: none">Nessun paziente trovato.</span>
                <div class="text-center mt-4 mb-2">
                    <button type="submit" name="submit" value="cercaPaziente" class="btn btn-primary">Cerca
                        <i class="fa fa-search ml-2"></i>
                    </button>
                </div>
            </form:form>
            <hr>

        </div>

    </div>
    <br>
    <div class="card card-cascade wider" id="informazioniPaziente" style="display: none">

        <!-- Card image -->
        <div class="view gradient-card-header peach-gradient">

            <!-- Title -->
            <h2 class="card-header-title mb-3">Informazioni Paziente</h2>

        </div>

        <!-- Card content -->
        <div class="card-body ">

                <div class="md-form form-sm">
                    <i class="fa fa-address-book prefix"></i>
                    <input type="text" id="cognome" class="form-control form-control-sm" name="cognome" disabled>
                    <label for="cognome">Cognome</label>
                 </div>
                <div class="md-form form-sm">
                    <i class="fa fa-address-book prefix"></i>
                    <input type="text" id="nome" class="form-control form-control-sm" name="nome" disabled>
                    <label for="nome">Nome</label>
                </div>

            <hr>

        </div>

    </div>
    <script type="text/javascript">

        var message = "<%= request.getParameter("paziente") %>";

        if(message==='Nessun Paziente'){

            document.getElementById('alertErr').style.display = 'block';
        }
        else if(message!=='null'){
            var json =  message.replace(/'/g, '"', -1);
            var myJson = JSON.parse(json);
            $( "input#nome" ).val(myJson.nome);
            $( "input#cognome" ).val(myJson.cognome);
            document.getElementById('informazioniPaziente').style.display = 'block';
        }
    </script>
</main>