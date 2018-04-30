<%--
  Created by IntelliJ IDEA.
  User: Antonio Biondillo
  Date: 30/04/2018
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="navigation.jsp" %>
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

            <form id="frmContact" name="frmContact" action="ControllerJavaEmail" method="POST" novalidate="novalidate">
                <!-- Material input name -->
                <div class="md-form form-sm">
                    <i class="fa fa-address-book prefix"></i>
                    <input type="text" id="materialFormNameModalEx1" class="form-control form-control-sm" name="name" required>
                    <label for="materialFormNameModalEx1">Codice Fiscale</label>
                </div>

                <div class="text-center mt-4 mb-2">
                    <button type="submit" name="submit" class="btn btn-primary">Cerca
                        <i class="fa fa-search ml-2"></i>
                    </button>
                </div>
            </form>
            <hr>

        </div>

    </div>
</main>