<%@ include file="navigation.jsp" %>
<main>
<div class="card card-cascade">

  <!-- Card image -->
  <div class="view gradient-card-header blue-gradient">

    <!-- Title -->
    <h2 class="card-header-title mb-3">Supporto</h2>
    <!-- Subtitle -->
    <p class="card-header-subtitle mb-0">Inviaci una email per chiedere supporto:</p>

  </div>

  <!-- Card content -->
  <div class="card-body ">

    <form id="frmContact" name="frmContact" action="ControllerJavaEmail" method="POST" novalidate="novalidate">
    <!-- Material input name -->
                <div class="md-form form-sm">
                    <i class="fa fa-envelope prefix"></i>
                    <input type="text" id="materialFormNameModalEx1" class="form-control form-control-sm" name="name" required>
                    <label for="materialFormNameModalEx1">Il tuo Nome</label>
                </div>

                <!-- Material input email -->
                <div class="md-form form-sm">
                    <i class="fa fa-lock prefix"></i>
                    <input type="text" id="materialFormEmailModalEx1" class="form-control form-control-sm" name="email" required>
                    <label for="materialFormEmailModalEx1">La tua Email</label>
                </div>

                <!-- Material input subject -->
                <div class="md-form form-sm">
                    <i class="fa fa-tag prefix"></i>
                    <input type="text" id="materialFormSubjectModalEx1" class="form-control form-control-sm" name="oggetto" required>
                    <label for="materialFormSubjectModalEx1">Oggetto</label>
                </div>

                <!-- Material textarea message -->
                <div class="md-form form-sm">
                    <i class="fa fa-pencil prefix"></i>
                    <textarea type="text" id="materialFormMessageModalEx1" class="md-textarea form-control" name="message" required></textarea>
                    <label for="materialFormMessageModalEx1">Messaggio</label>
                </div>

                <div class="text-center mt-4 mb-2">
                    <button type="submit" name="submit" class="btn btn-primary">Invia
                        <i class="fa fa-send ml-2"></i>
                    </button>
                </div>
    </form>
    <hr>

  </div>

</div>           
</main>