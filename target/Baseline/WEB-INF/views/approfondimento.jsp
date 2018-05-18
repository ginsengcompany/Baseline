<%--
  Created by IntelliJ IDEA.
  User: Antonio Biondillo
  Date: 17/05/2018
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="navigation.jsp" %>
<main>
    <div class="card card-cascade">

        <!-- Card image -->
        <div class="view gradient-card-header blue-gradient">

            <!-- Title -->
            <h2 class="card-header-title mb-3">Approfondimento</h2>
            <!-- Subtitle -->
            <p class="card-header-subtitle mb-0">Diagnosi su paziente a rischio</p>

        </div>

        <!-- Card content -->
        <div class="card-body text-center">

            <h2 class="card-header-title mb-3">Urgenza ?</h2>

            <div class="row">

                <div class="col-md-6">

                    <small class="text-uppercase text-muted"><b>SI</b></small>
                    <div class="form-check checkbox-rounded checkbox-success-filled">
                        <input type="checkbox" id="checkbox111" class="filled-in form-check-input" >
                        <label class="form-check-label" for="checkbox111">Fai recare il paziente in un Amb, Nefrologico</label>
                    </div>

                </div>

                <div class="col-md-6">

                    <small class="text-uppercase text-muted"><b>NO</b></small>
                    <div class="form-check checkbox-rounded checkbox-success-filled">
                        <input type="checkbox" id="checkbox112" class="filled-in form-check-input" >
                        <label class="form-check-label" for="checkbox112"></label>
                    </div>

                </div>


            </div>

            <div class="text-center mt-4 mb-2">
                <button type="submit" name="submit" class="btn btn-primary">Avanti
                    <i class="fa fa-caret-square-o-right ml-2"></i>
                </button>
            </div>
        </div>

    </div>
</main>