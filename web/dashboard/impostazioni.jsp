<%@ include file="navigation.jsp" %>
<main>


    <div class="row">


        <!--Card Gruppi -->
        <div class="col-lg-4 col-md-12 mb-4">

            <div class="card card-cascade wider">

                <!-- Card image -->
                <div class="view gradient-card-header peach-gradient">

                    <!-- Title -->
                    <h2 class="card-header-title mb-3">Gruppi</h2>
                    <!-- Text -->
                    <p class="mb-0"><i class="fa fa fa-group mr-2"></i></p>

                </div>

                <!-- Card content -->
                <div class="card-body text-center">

                    <!-- Text -->
                    <p class="card-text">Pannello di controllo per la configurazione dei gruppi</p>
                    <!-- Link -->
                    <a data-toggle="modal" onclick="setModalGroup()" data-target="#gruppi" class="orange-text d-flex flex-row-reverse p-2">
                        <h5 class="waves-effect waves-light">Apri Configurazione<i class="fa fa-angle-double-right ml-2"></i></h5>
                    </a>

                </div>
                <!-- Card content -->

            </div>    

        </div>

        <!--Card Utenti -->
        <div class="col-lg-4 col-md-6 mb-4">

            <div class="card card-cascade wider">


                <div class="view gradient-card-header peach-gradient">

                    <!-- Title -->
                    <h2 class="card-header-title mb-3">Utenti</h2>

                    <p class="mb-0"><i class="fa fa fa-user mr-2"></i></p>

                </div>


                <div class="card-body text-center">


                    <p class="card-text">Pannello di controllo per la configurazione delle utenze.</p>

                    <a data-toggle="modal" onclick="setModalUser()" data-target="#utenti" class="orange-text d-flex flex-row-reverse p-2">
                        <h5 class="waves-effect waves-light">Apri Configurazione<i class="fa fa-angle-double-right ml-2"></i></h5>
                    </a>

                </div>

            </div>

        </div>
        
        <!--Card Token Applicativi -->
        <div class="col-lg-4 col-md-6 mb-4">

            <div class="card card-cascade wider">


                <div class="view gradient-card-header peach-gradient">

                    <!-- Title -->
                    <h2 class="card-header-title mb-3">Token Applicativi</h2>

                    <p class="mb-0"><i class="fa fa fa-key mr-2"></i></p>

                </div>


                <div class="card-body text-center">


                    <p class="card-text">Pannello di controllo per la generazione di token per gli applicativi.</p>

                    <a data-toggle="modal" onclick="setModaltoken()" data-target="#token" class="orange-text d-flex flex-row-reverse p-2">
                        <h5 class="waves-effect waves-light">Apri Configurazione<i class="fa fa-angle-double-right ml-2"></i></h5>
                    </a>

                </div>

            </div>

        </div>


    </div>    

    <!--Modal Gruppi -->
    <div class="modal fade show" id="gruppi" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="padding-right: 17px; display: none;">
        <div class="modal-dialog modal-fluid" role="document" style="height:100%">
            <!--Content-->
            <div class="modal-content" style="">
                <!--Header-->
                <div class="modal-header">
                    <h4 class="modal-title w-100" id="myModalLabel">Gruppi</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <!--Body-->
                <div class="modal-body">
                    <section id="bf-table" style="height:100%">


                        <p class="description"></p>


                        <section class="bf-table" style="height:100%">

                            <div class="card card-cascade narrower" style="height:95%">


                                <div class="view gradient-card-header blue-gradient narrower py-2 mx-4 mb-3 d-flex justify-content-between align-items-center">


                                    <a href="" class="white-text mx-3">Lista Gruppi</a>

                                    <div>

                                        <button type="button" id="modificaGruppo" onclick="openModalUp()"
                                                class="btn btn-outline-white btn-rounded btn-sm px-2 waves-effect waves-light" data-toggle="modal" data-target="#updateGroup"  data-tooltip="tooltip" data-placement="top" title="Modifica Gruppo"><i
                                                class="fa fa-pencil mt-0"></i></button>
                                        <button type="button" id="aggiungi"
                                                class="btn btn-outline-white btn-rounded btn-sm px-2 waves-effect waves-light" data-toggle="modal" data-target="#addGroup" data-tooltip="tooltip" data-placement="top" title="Aggiungi Gruppo"><i
                                                class="fa fa-plus mt-0"></i></button>

                                    </div>

                                </div>
                                <br>
                                <span id="alertErrUpGp" class="badge badge-danger" style="display: none">Aggiornamento Fallito.</span>
                                <span id="alertSuccUpGp" class="badge badge-success" style="display: none">Aggiornamento Completato.</span>
                                <span id="alertErrInGp" class="badge badge-danger" style="display: none">Inserimento Fallito.</span>
                                <span id="alertSuccInGp" class="badge badge-success" style="display: none">Inserimento Completato.</span>
                                <br>
                                <div class="px-4">
                                    <br>
                                    <div class="table-wrapper" style="max-height:100%">

                                        <table id="customTable" class="table table-hover mb-0">

                                            <thead>
                                                <tr>
                                                    <th class="th-lg"></th>
                                                    <th class="th-lg">Nome</th>
                                                    <th class="th-lg">Descrizione</th>
                                                    <th class="th-lg"></th>
                                                    <th class="th-lg"></th>
                                                    <th class="th-lg"></th>
                                                    <th class="th-lg"></th>
                                                    <th class="th-lg"></th>
                                                    <th class="th-lg"></th>
                                                    <th class="th-lg"></th>
                                                    <th class="th-lg"></th>
                                                </tr>
                                            </thead>

                                        </table>

                                    </div>

                                    <hr class="my-0">


                                    <div class="d-flex justify-content-between">


                                        <nav id="my-4" class="my-4">

                                        </nav>


                                    </div>


                                </div>
                            </div>

                        </section>



                    </section>
                </div>
                <!--Footer-->
                <div class="modal-footer">

                </div>
            </div>
            <!--/.Content-->
        </div>
    </div>

    <!--Modal Add Gruppi -->
    <div class="modal fade show" id="addGroup" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" style="padding-right: 17px; display: none;">
        <div class="modal-dialog modal-dialog-centered" role="document" style="max-width: 1900px;">
            <form id="aggiungiGruppo" class="modal-content">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLongTitle">Aggiungi Gruppo</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="md-form" >
                                    <i class="fa fa-address-card prefix "></i>
                                    <input type="text" id="nomeGruppo" class="form-control form-control-sm"  name="nomeGruppo" required>
                                    <label  for="nomeGruppo">Nome Gruppo</label>
                                </div>
                            </div>

                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="md-form" >
                                    <i class="fa fa-address-card prefix "></i>
                                    <input type="text" id="descrizioneGruppo" class="form-control form-control-sm"  name="descrizioneGruppo" required>
                                    <label  for="descrizioneGruppo">Descrizione Gruppo</label>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="row">
                                    <div class="col-md-12">
                                        <ul class="nav nav-tabs nav-justified blue-gradient narrower py-2 mx-4 mb-3 d-flex justify-content-between align-items-center" role="tablist">
                                            <li class="nav-item">
                                                <a class="nav-link active" data-toggle="tab" href="#panel5" role="tab">
                                                    Menu</a>
                                            </li>
                                        </ul>
                                        <!-- Nav tabs -->
                                        <!-- Tab panels -->
                                        <div class="tab-content">
                                            <!--Panel 1-->
                                            <div class="tab-pane fade in show active" id="panel5" role="tabpanel">
                                                <!-- Nav tabs -->
                                                <div class="row">
                                                    <div class="col-md-12">
                                                        <div class="md-form" >
                                                            <select id="menu" class="mdb-select colorful-select dropdown-primary mx-2 initialized" multiple>
                                                                <option value="" disabled selected>Scegli Menu</option>
                                                            </select>
                                                        </div></div>
                                                </div>
                                                <!-- Nav tabs -->
                                            </div>
                                            <!--/.Panel 1-->
                                        </div>
                                    </div>
                                </div> 
                            </div>
                            <div class="col-md-6">
                                <fieldset class="scheduler-border">
                                    <legend class="scheduler-border">Permessi</legend>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="md-form" >
                                                <select id="sezione" class="mdb-select colorful-select dropdown-primary mx-2 initialized" onchange="changeSezione()">
                                                    <option value="" disabled selected>Sezione</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <ul class="nav nav-tabs nav-justified blue-gradient narrower py-2 mx-4 mb-3 d-flex justify-content-between align-items-center" role="tablist">
                                                <li class="nav-item">
                                                    <a class="nav-link active" data-toggle="tab" href="#panel5" role="tab">
                                                        Permessi</a>
                                                </li>
                                            </ul>
                                            <!-- Nav tabs -->
                                            <!-- Tab panels -->
                                            <div class="tab-content">
                                                <!--Panel 1-->
                                                <div class="tab-pane fade in show active" id="panel5" role="tabpanel">
                                                    <!-- Nav tabs Menu -->
                                                    <div class="row" id="tabsMenu">
                                                        <div class="col-md-12">

                                                            <ul class="list-group">
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="letturaMenu" class="form-control form-control-sm" name="letturaMenu" >
                                                                        <label  for="letturaMenu">Lettura</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="inserimentoMenu" class="form-control form-control-sm" name="inserimentoMenu" >
                                                                        <label  for="inserimentoMenu">Inserimento</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="modificaMenu" class="form-control form-control-sm" name="modificaMenu" >
                                                                        <label  for="modificaMenu">Modifica</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="cancellazioneMenu" class="form-control form-control-sm" name="cancellazioneMenu" >
                                                                        <label  for="cancellazioneMenu">Cancellazione</label>
                                                                    </div>
                                                                </li>
                                                            </ul>

                                                        </div>
                                                    </div>
                                                    <!-- Nav tabs Menu -->

                                                    <!-- Nav tabs Sezioni -->
                                                    <div class="row" id="tabsSezioni">
                                                        <div class="col-md-12">

                                                            <ul class="list-group">
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="letturaSezioni" class="form-control form-control-sm" name="letturaSezioni" >
                                                                        <label  for="letturaSezioni">Lettura</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="inserimentoSezioni" class="form-control form-control-sm" name="inserimentoSezioni" >
                                                                        <label  for="inserimentoSezioni">Inserimento</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="modificaSezioni" class="form-control form-control-sm" name="modificaSezioni" >
                                                                        <label  for="modificaSezioni">Modifica</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="cancellazioneSezioni" class="form-control form-control-sm" name="cancellazioneSezioni" >
                                                                        <label  for="cancellazioneSezioni">Cancellazione</label>
                                                                    </div>
                                                                </li>
                                                            </ul>

                                                        </div>
                                                    </div>
                                                    <!-- Nav tabs Sezioni -->

                                                    <!-- Nav tabs Utenti -->
                                                    <div class="row" id="tabsUtenti">
                                                        <div class="col-md-12">

                                                            <ul class="list-group">
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="letturaUtenti" class="form-control form-control-sm" name="letturaUtenti" >
                                                                        <label  for="letturaUtenti">Lettura</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="inserimentoUtenti" class="form-control form-control-sm" name="inserimentoUtenti" >
                                                                        <label  for="inserimentoUtenti">Inserimento</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="modificaUtenti" class="form-control form-control-sm" name="modificaUtenti" >
                                                                        <label  for="modificaUtenti">Modifica</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="cancellazioneUtenti" class="form-control form-control-sm" name="cancellazioneUtenti" >
                                                                        <label  for="cancellazioneUtenti">Cancellazione</label>
                                                                    </div>
                                                                </li>
                                                            </ul>

                                                        </div>
                                                    </div>
                                                    <!-- Nav tabs Utenti -->

                                                    <!-- Nav tabs Anagrafica -->
                                                    <div class="row" id="tabsAnagrafica">
                                                        <div class="col-md-12">

                                                            <ul class="list-group">
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="letturaAnagrafica" class="form-control form-control-sm" name="letturaAnagrafica" >
                                                                        <label  for="letturaAnagrafica">Lettura</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="inserimentoAnagrafica" class="form-control form-control-sm" name="inserimentoAnagrafica" >
                                                                        <label  for="inserimentoAnagrafica">Inserimento</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="modificaAnagrafica" class="form-control form-control-sm" name="modificaAnagrafica" >
                                                                        <label  for="modificaAnagrafica">Modifica</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="cancellazioneAnagrafica" class="form-control form-control-sm" name="cancellazioneAnagrafica" >
                                                                        <label  for="cancellazioneAnagrafica">Cancellazione</label>
                                                                    </div>
                                                                </li>
                                                            </ul>

                                                        </div>
                                                    </div>
                                                    <!-- Nav tabs Anagrafica -->

                                                    <!-- Nav tabs Gruppi -->
                                                    <div class="row" id="tabsGruppi">
                                                        <div class="col-md-12">

                                                            <ul class="list-group">
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="letturaGruppi" class="form-control form-control-sm" name="letturaGruppi" >
                                                                        <label  for="letturaGruppi">Lettura</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="inserimentoGruppi" class="form-control form-control-sm" name="inserimentoGruppi" >
                                                                        <label  for="inserimentoGruppi">Inserimento</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="modificaGruppi" class="form-control form-control-sm" name="modificaGruppi" >
                                                                        <label  for="modificaGruppi">Modifica</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="cancellazioneGruppi" class="form-control form-control-sm" name="cancellazioneGruppi" >
                                                                        <label  for="cancellazioneGruppi">Cancellazione</label>
                                                                    </div>
                                                                </li>
                                                            </ul>

                                                        </div>
                                                    </div>
                                                    <!-- Nav tabs Gruppi -->

                                                    <!-- Nav tabs Documenti -->
                                                    <div class="row" id="tabsDocumenti">
                                                        <div class="col-md-12">

                                                            <ul class="list-group">
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="letturaDocumenti" class="form-control form-control-sm" name="letturaDocumenti" >
                                                                        <label  for="letturaDocumenti">Lettura</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="inserimentoDocumenti" class="form-control form-control-sm" name="inserimentoDocumenti" >
                                                                        <label  for="inserimentoDocumenti">Inserimento</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="modificaDocumenti" class="form-control form-control-sm" name="modificaDocumenti" >
                                                                        <label  for="modificaDocumenti">Modifica</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="cancellazioneDocumenti" class="form-control form-control-sm" name="cancellazioneDocumenti" >
                                                                        <label  for="cancellazioneDocumenti">Cancellazione</label>
                                                                    </div>
                                                                </li>
                                                            </ul>

                                                        </div>
                                                    </div>
                                                    <!-- Nav tabs Documenti -->

                                                    <!-- Nav tabs Medici -->
                                                    <div class="row" id="tabsMedici">
                                                        <div class="col-md-12">

                                                            <ul class="list-group">
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="letturaMedici" class="form-control form-control-sm" name="letturaMedici" >
                                                                        <label  for="letturaMedici">Lettura</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="inserimentoMedici" class="form-control form-control-sm" name="inserimentoMedici" >
                                                                        <label  for="inserimentoMedici">Inserimento</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="modificaMedici" class="form-control form-control-sm" name="modificaMedici" >
                                                                        <label  for="modificaMedici">Modifica</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="cancellazioneMedici" class="form-control form-control-sm" name="cancellazioneMedici" >
                                                                        <label  for="cancellazioneMedici">Cancellazione</label>
                                                                    </div>
                                                                </li>
                                                            </ul>

                                                        </div>
                                                    </div>
                                                    <!-- Nav tabs Medici -->

                                                    <!-- Nav tabs Allegati -->
                                                    <div class="row" id="tabsAllegati">
                                                        <div class="col-md-12">

                                                            <ul class="list-group">
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="letturaAllegati" class="form-control form-control-sm" name="letturaAllegati" >
                                                                        <label  for="letturaAllegati">Lettura</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="inserimentoAllegati" class="form-control form-control-sm" name="inserimentoAllegati" >
                                                                        <label  for="inserimentoAllegati">Inserimento</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="modificaAllegati" class="form-control form-control-sm" name="modificaAllegati" >
                                                                        <label  for="modificaAllegati">Modifica</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="cancellazioneAllegati" class="form-control form-control-sm" name="cancellazioneAllegati" >
                                                                        <label  for="cancellazioneAllegati">Cancellazione</label>
                                                                    </div>
                                                                </li>
                                                            </ul>

                                                        </div>
                                                    </div>
                                                    <!-- Nav tabs Allegati -->
                                                </div>
                                                <!--/.Panel 1-->
                                            </div>
                                        </div>
                                    </div>    
                                </fieldset>    
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary waves-effect waves-light" data-dismiss="modal">Annulla</button>
                        <button type="submit" class="btn btn-primary waves-effect waves-light" name="submit" value="Submit">Salva</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <!--Modal Update Gruppi -->
    <div class="modal fade show" id="updateGroup" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" style="padding-right: 17px; display: none;">
        <div class="modal-dialog modal-dialog-centered" role="document" style="max-width: 1900px;">
            <form id="updateGruppo" class="modal-content">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLongTitle">Modifica Gruppo</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="md-form" >
                                    <i class="fa fa-address-card prefix "></i>
                                    <input type="text" id="nomeGruppo1" class="form-control form-control-sm"  name="nomeGruppo1" required>
                                    <label  for="nomeGruppo1">Nome Gruppo</label>
                                </div>
                            </div>

                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="md-form" >
                                    <i class="fa fa-address-card prefix "></i>
                                    <input type="text" id="descrizioneGruppo1" class="form-control form-control-sm"  name="descrizioneGruppo1" required>
                                    <label  for="descrizioneGruppo1">Descrizione Gruppo</label>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="row">
                                    <div class="col-md-12">
                                        <ul class="nav nav-tabs nav-justified blue-gradient narrower py-2 mx-4 mb-3 d-flex justify-content-between align-items-center" role="tablist">
                                            <li class="nav-item">
                                                <a class="nav-link active" data-toggle="tab" href="#panel5" role="tab">
                                                    Menu</a>
                                            </li>
                                        </ul>
                                        <!-- Nav tabs -->
                                        <!-- Tab panels -->
                                        <div class="tab-content">
                                            <!--Panel 1-->
                                            <div class="tab-pane fade in show active" id="panel5" role="tabpanel">
                                                <!-- Nav tabs -->
                                                <div class="row">
                                                    <div class="col-md-12">
                                                        <div class="md-form" >
                                                            <select id="menu1" class="mdb-select colorful-select dropdown-primary mx-2 initialized" multiple>
                                                                <option value="" disabled selected>Scegli Menu</option>
                                                            </select>
                                                        </div></div>
                                                </div>
                                                <!-- Nav tabs -->
                                            </div>
                                            <!--/.Panel 1-->
                                        </div>
                                    </div>
                                </div> 
                            </div>
                            <div class="col-md-6">
                                <fieldset class="scheduler-border">
                                    <legend class="scheduler-border">Permessi</legend>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="md-form" >
                                                <select id="sezione1" class="mdb-select colorful-select dropdown-primary mx-2 initialized" onchange="changeSezione1()">
                                                    <option value="" disabled selected>Sezione</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <ul class="nav nav-tabs nav-justified blue-gradient narrower py-2 mx-4 mb-3 d-flex justify-content-between align-items-center" role="tablist">
                                                <li class="nav-item">
                                                    <a class="nav-link active" data-toggle="tab" href="#panel5" role="tab">
                                                        Permessi</a>
                                                </li>
                                            </ul>
                                            <!-- Nav tabs -->
                                            <!-- Tab panels -->
                                            <div class="tab-content">
                                                <!--Panel 1-->
                                                <div class="tab-pane fade in show active" id="panel5" role="tabpanel">
                                                    <!-- Nav tabs Menu -->
                                                    <div class="row" id="tabsMenu1">
                                                        <div class="col-md-12">

                                                            <ul class="list-group">
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="letturaMenu1" class="form-control form-control-sm" name="letturaMenu1" >
                                                                        <label  for="letturaMenu1">Lettura</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="inserimentoMenu1" class="form-control form-control-sm" name="inserimentoMenu1" >
                                                                        <label  for="inserimentoMenu1">Inserimento</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="modificaMenu1" class="form-control form-control-sm" name="modificaMenu1" >
                                                                        <label  for="modificaMenu1">Modifica</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="cancellazioneMenu1" class="form-control form-control-sm" name="cancellazioneMenu1" >
                                                                        <label  for="cancellazioneMenu1">Cancellazione</label>
                                                                    </div>
                                                                </li>
                                                            </ul>

                                                        </div>
                                                    </div>
                                                    <!-- Nav tabs Menu -->

                                                    <!-- Nav tabs Sezioni -->
                                                    <div class="row" id="tabsSezioni1">
                                                        <div class="col-md-12">

                                                            <ul class="list-group">
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="letturaSezioni1" class="form-control form-control-sm" name="letturaSezioni1" >
                                                                        <label  for="letturaSezioni1">Lettura</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="inserimentoSezioni1" class="form-control form-control-sm" name="inserimentoSezioni1" >
                                                                        <label  for="inserimentoSezioni1">Inserimento</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="modificaSezioni1" class="form-control form-control-sm" name="modificaSezioni1" >
                                                                        <label  for="modificaSezioni1">Modifica</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="cancellazioneSezioni1" class="form-control form-control-sm" name="cancellazioneSezioni1" >
                                                                        <label  for="cancellazioneSezioni1">Cancellazione</label>
                                                                    </div>
                                                                </li>
                                                            </ul>

                                                        </div>
                                                    </div>
                                                    <!-- Nav tabs Sezioni -->

                                                    <!-- Nav tabs Utenti -->
                                                    <div class="row" id="tabsUtenti1">
                                                        <div class="col-md-12">

                                                            <ul class="list-group">
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="letturaUtenti1" class="form-control form-control-sm" name="letturaUtenti1" >
                                                                        <label  for="letturaUtenti1">Lettura</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="inserimentoUtenti1" class="form-control form-control-sm" name="inserimentoUtenti1" >
                                                                        <label  for="inserimentoUtenti1">Inserimento</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="modificaUtenti1" class="form-control form-control-sm" name="modificaUtenti1" >
                                                                        <label  for="modificaUtenti1">Modifica</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="cancellazioneUtenti1" class="form-control form-control-sm" name="cancellazioneUtenti1" >
                                                                        <label  for="cancellazioneUtenti1">Cancellazione</label>
                                                                    </div>
                                                                </li>
                                                            </ul>

                                                        </div>
                                                    </div>
                                                    <!-- Nav tabs Utenti -->

                                                    <!-- Nav tabs Anagrafica -->
                                                    <div class="row" id="tabsAnagrafica1">
                                                        <div class="col-md-12">

                                                            <ul class="list-group">
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="letturaAnagrafica1" class="form-control form-control-sm" name="letturaAnagrafica1" >
                                                                        <label  for="letturaAnagrafica1">Lettura</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="inserimentoAnagrafica1" class="form-control form-control-sm" name="inserimentoAnagrafica1" >
                                                                        <label  for="inserimentoAnagrafica1">Inserimento</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="modificaAnagrafica1" class="form-control form-control-sm" name="modificaAnagrafica1" >
                                                                        <label  for="modificaAnagrafica1">Modifica</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="cancellazioneAnagrafica1" class="form-control form-control-sm" name="cancellazioneAnagrafica1" >
                                                                        <label  for="cancellazioneAnagrafica1">Cancellazione</label>
                                                                    </div>
                                                                </li>
                                                            </ul>

                                                        </div>
                                                    </div>
                                                    <!-- Nav tabs Anagrafica -->

                                                    <!-- Nav tabs Gruppi -->
                                                    <div class="row" id="tabsGruppi1">
                                                        <div class="col-md-12">

                                                            <ul class="list-group">
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="letturaGruppi1" class="form-control form-control-sm" name="letturaGruppi1" >
                                                                        <label  for="letturaGruppi1">Lettura</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="inserimentoGruppi1" class="form-control form-control-sm" name="inserimentoGruppi1" >
                                                                        <label  for="inserimentoGruppi1">Inserimento</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="modificaGruppi1" class="form-control form-control-sm" name="modificaGruppi1" >
                                                                        <label  for="modificaGruppi1">Modifica</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="cancellazioneGruppi1" class="form-control form-control-sm" name="cancellazioneGruppi1" >
                                                                        <label  for="cancellazioneGruppi1">Cancellazione</label>
                                                                    </div>
                                                                </li>
                                                            </ul>

                                                        </div>
                                                    </div>
                                                    <!-- Nav tabs Gruppi -->

                                                    <!-- Nav tabs Documenti -->
                                                    <div class="row" id="tabsDocumenti1">
                                                        <div class="col-md-12">

                                                            <ul class="list-group">
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="letturaDocumenti1" class="form-control form-control-sm" name="letturaDocumenti1" >
                                                                        <label  for="letturaDocumenti1">Lettura</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="inserimentoDocumenti1" class="form-control form-control-sm" name="inserimentoDocumenti1" >
                                                                        <label  for="inserimentoDocumenti1">Inserimento</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="modificaDocumenti1" class="form-control form-control-sm" name="modificaDocumenti1" >
                                                                        <label  for="modificaDocumenti1">Modifica</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="cancellazioneDocumenti1" class="form-control form-control-sm" name="cancellazioneDocumenti1" >
                                                                        <label  for="cancellazioneDocumenti1">Cancellazione</label>
                                                                    </div>
                                                                </li>
                                                            </ul>

                                                        </div>
                                                    </div>
                                                    <!-- Nav tabs Documenti -->

                                                    <!-- Nav tabs Medici -->
                                                    <div class="row" id="tabsMedici1">
                                                        <div class="col-md-12">

                                                            <ul class="list-group">
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="letturaMedici1" class="form-control form-control-sm" name="letturaMedici1" >
                                                                        <label  for="letturaMedici1">Lettura</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="inserimentoMedici1" class="form-control form-control-sm" name="inserimentoMedici1" >
                                                                        <label  for="inserimentoMedici1">Inserimento</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="modificaMedici1" class="form-control form-control-sm" name="modificaMedici1" >
                                                                        <label  for="modificaMedici1">Modifica</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="cancellazioneMedici1" class="form-control form-control-sm" name="cancellazioneMedici1" >
                                                                        <label  for="cancellazioneMedici1">Cancellazione</label>
                                                                    </div>
                                                                </li>
                                                            </ul>

                                                        </div>
                                                    </div>
                                                    <!-- Nav tabs Medici -->

                                                    <!-- Nav tabs Allegati -->
                                                    <div class="row" id="tabsAllegati1">
                                                        <div class="col-md-12">

                                                            <ul class="list-group">
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="letturaAllegati1" class="form-control form-control-sm" name="letturaAllegati1" >
                                                                        <label  for="letturaAllegati1">Lettura</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="inserimentoAllegati1" class="form-control form-control-sm" name="inserimentoAllegati1" >
                                                                        <label  for="inserimentoAllegati1">Inserimento</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="modificaAllegati1" class="form-control form-control-sm" name="modificaAllegati1" >
                                                                        <label  for="modificaAllegati1">Modifica</label>
                                                                    </div>
                                                                </li>
                                                                <li class="list-group-item">
                                                                    <div class="form-check checkbox-teal">
                                                                        <input type="checkbox" id="cancellazioneAllegati1" class="form-control form-control-sm" name="cancellazioneAllegati1" >
                                                                        <label  for="cancellazioneAllegati1">Cancellazione</label>
                                                                    </div>
                                                                </li>
                                                            </ul>

                                                        </div>
                                                    </div>
                                                    <!-- Nav tabs Allegati -->
                                                </div>
                                                <!--/.Panel 1-->
                                            </div>
                                        </div>
                                    </div>    
                                </fieldset>    
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary waves-effect waves-light" data-dismiss="modal">Annulla</button>
                        <button type="submit" class="btn btn-primary waves-effect waves-light" name="submit" value="Submit">Salva</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <!--Modal Utenti -->
    <div class="modal fade show" id="utenti" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="padding-right: 17px; display: none;">
        <div class="modal-dialog modal-fluid" role="document" >
            <!--Content-->
            <div class="modal-content" >
                <!--Header-->
                <div class="modal-header">
                    <h4 class="modal-title w-100" id="myModalLabel">Utenti</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <!--Body-->
                <div class="modal-body">
                    <section id="bf-table" >


                        <p class="description"></p>


                        <section class="bf-table">

                            <div class="card card-cascade narrower" >


                                <div class="view gradient-card-header blue-gradient narrower py-2 mx-4 mb-3 d-flex justify-content-between align-items-center">


                                    <a href="" class="white-text mx-3">Lista Utenti</a>

                                    <div>

                                        <button type="button" id="modificaUtente" onclick="openModalUpUsers()"
                                                class="btn btn-outline-white btn-rounded btn-sm px-2 waves-effect waves-light" data-toggle="modal" data-target="#updateUsers"  data-tooltip="tooltip" data-placement="top" title="Modifica Utente"><i
                                                class="fa fa-pencil mt-0"></i></button>
                                        <button type="button" id="aggiungiUtente" onclick="openModalInUsers()"
                                                class="btn btn-outline-white btn-rounded btn-sm px-2 waves-effect waves-light" data-toggle="modal" data-target="#insertUsers" data-tooltip="tooltip" data-placement="top" title="Aggiungi Utente"><i
                                                class="fa fa-plus mt-0"></i></button>
                                    </div>

                                </div>
                                <br>
                                <span id="alertErrUp" class="badge badge-danger" style="display: none">Aggiornamento Fallito.</span>
                                <span id="alertSuccUp" class="badge badge-success" style="display: none">Aggiornamento Completato.</span>
                                <span id="alertErrIn" class="badge badge-danger" style="display: none">Inserimento Fallito.</span>
                                <span id="alertSuccIn" class="badge badge-success" style="display: none">Inserimento Completato.</span>
                                <br>
                                <div class="px-4">
                                    <br>
                                    <div >

                                        <table id="tabUsers" class="table table-hover mb-0">

                                            <thead>
                                                <tr>
                                                    <th class="th-lg">Gruppo</th>
                                                    <th class="th-lg">Cognome</th>
                                                    <th class="th-lg">Nome</th>
                                                    <th class="th-lg">Username</th>
                                                    <th class="th-lg">Attivo</th>
                                                </tr>
                                            </thead>

                                        </table>

                                    </div>

                                    <hr class="my-0">


                                    <div class="d-flex justify-content-between">


                                        <nav id="my-4" class="my-4">

                                        </nav>


                                    </div>


                                </div>
                            </div>

                        </section>



                    </section>
                </div>
                <!--Footer-->
                <div class="modal-footer">

                </div>
            </div>
            <!--/.Content-->
        </div>
    </div>

    <!--Modal Update Utenti -->
    <div class="modal fade right" id="updateUsers" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="display: none;" aria-hidden="true">
        <div class="modal-dialog modal-full-height modal-right" role="document">
            <!--Content-->
            <div class="modal-content">
                <!--Header-->
                <div class="modal-header">
                    <h4 class="modal-title w-100" id="myModalLabe">Modifica Utente</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <!--Body-->
                <form id="utenteForm">
                    <div class="modal-body">
                        <p>In questa sezione &egrave; possibile aggiornare o modificare i dati di un determinato utente.
                        </p>

                        <div class="md-form" hidden>
                            <i class="fa fa-address-card prefix "></i>
                            <input type="text" id="idUser" class="form-control form-control-sm" name="idUser" required>
                            <label  for="idUser">Id</label>
                        </div>
                        <div class="md-form">
                            <i class="fa fa-address-card prefix "></i>
                            <input type="text" id="cognomeUser" class="form-control form-control-sm" name="cognomeUser" required>
                            <label  for="cognomeUser">Cognome</label>
                        </div>
                        <div class="md-form">
                            <i class="fa fa-address-card prefix "></i>
                            <input type="text" id="nomeUser" class="form-control form-control-sm" name="nomeUser" required>
                            <label  for="nomeUser">Nome</label>
                        </div>
                        <div class="md-form">
                            <i class="fa fa-address-book prefix "></i>
                            <input type="text" id="usernameUser" class="form-control form-control-sm" name="usernameUser" required>
                            <label  for="usernameUser">Username</label>
                        </div>
                        <div class="md-form">
                            <i class="fa fa-envelope prefix "></i>
                            <input type="text" id="emailUser" class="form-control form-control-sm" name="emailUser" required>
                            <label  for="emailUser">E-mail</label>
                        </div>
                        <div class="md-form-check">
                            <i class="fa fa-check-square prefix " style="font-size: 1.75rem;"></i>
                            <input type="checkbox" id="attivoUser" class="form-control form-control-sm" name="attivoUser" >
                            <label  for="attivoUser">Attivo</label>
                        </div>
                        <div class="md-form">
                            <i class="fa fa-group prefix "></i>
                            <select id="profiloUser" class="mdb-select colorful-select dropdown-primary mx-5 initialized" name="profiloUser" required>
                                <option value="" disabled selected>Profilo</option>
                            </select>
                        </div>
                        <div class="md-form">
                            <i class="fa fa-calendar prefix "></i>
                            <input type="text" id="dataScadenzaUser" class="form-control form-control-sm datepicker" name="dataScadenzaUser" required>
                            <label  for="dataScadenzaUser">Scadenza Password</label>
                        </div>
                        <div class="md-form">
                            <i class="fa fa-key prefix "></i>
                            <input type="text" id="passwordUser" class="form-control form-control-sm" name="passwordUser">
                            <label  for="passwordUser">Password</label>
                        </div>
                        <div class="md-form">
                            <i class="fa fa-key prefix "></i>
                            <input type="text" id="passwordVerUser" class="form-control form-control-sm" name="passwordVerUser">
                            <label for="passwordVerUser">Verifica Password</label>
                        </div>


                    </div>
                    <!--Footer-->
                    <div class="modal-footer justify-content-center">
                        <button id="closeButtonUp" type="button" class="btn btn-secondary waves-effect waves-light" data-dismiss="modal">Chiudi</button>
                        <button type="submit" class="btn btn-primary waves-effect waves-light" name="submit" value="Submit">Salva Modifiche</button>
                    </div>
                </form>   
            </div>
            <!--/.Content-->
        </div>
    </div>

    <!--Modal Insert Utenti -->
    <div class="modal fade right" id="insertUsers" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="display: none;" aria-hidden="true">
        <div class="modal-dialog modal-full-height modal-right" role="document">
            <!--Content-->
            <div class="modal-content">
                <!--Header-->
                <div class="modal-header">
                    <h4 class="modal-title w-100" id="myModalLabe">Aggiungi Utente</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <!--Body-->
                <form id="utenteFormIns">
                    <div class="modal-body">
                        <p>In questa sezione &egrave; possibile aggiungere un nuovo utente.
                        </p>

                        <div class="md-form" hidden>
                            <i class="fa fa-address-card prefix "></i>
                            <input type="text" id="idUser1" class="form-control form-control-sm" name="idUser1" >
                            <label  for="idUser1">Id</label>
                        </div>
                        <div class="md-form">
                            <i class="fa fa-address-card prefix "></i>
                            <input type="text" id="cognomeUser1" class="form-control form-control-sm" name="cognomeUser1" >
                            <label  for="cognomeUser1">Cognome</label>
                        </div>
                        <div class="md-form">
                            <i class="fa fa-address-card prefix "></i>
                            <input type="text" id="nomeUser1" class="form-control form-control-sm" name="nomeUser1" >
                            <label  for="nomeUser1">Nome</label>
                        </div>
                        <div class="md-form">
                            <i class="fa fa-address-book prefix "></i>
                            <input type="text" id="usernameUser1" class="form-control form-control-sm" name="usernameUser1" >
                            <label  for="usernameUser1">Username</label>
                        </div>
                        <div class="md-form">
                            <i class="fa fa-envelope prefix "></i>
                            <input type="text" id="emailUser1" class="form-control form-control-sm" name="emailUser1" >
                            <label  for="emailUser1">E-mail</label>
                        </div>
                        <div class="md-form-check">
                            <i class="fa fa-check-square prefix " style="font-size: 1.75rem;"></i>
                            <input type="checkbox" id="attivoUser1" class="form-control form-control-sm" name="attivoUser1" >
                            <label  for="attivoUser1">Attivo</label>
                        </div>
                        <div class="md-form">
                            <i class="fa fa-group prefix "></i>
                            <select id="profiloUser1" class="mdb-select colorful-select dropdown-primary mx-5 initialized" name="profiloUser1" >
                                <option value="" disabled selected>Profilo</option>
                            </select>
                        </div>
                        <div class="md-form">
                            <i class="fa fa-calendar prefix "></i>
                            <input type="text" id="dataScadenzaUser1" class="form-control form-control-sm datepicker" name="dataScadenzaUser1" >
                            <label  for="dataScadenzaUser1">Scadenza Password</label>
                        </div>
                        <div class="md-form">
                            <i class="fa fa-key prefix "></i>
                            <input type="text" id="passwordUser1" class="form-control form-control-sm" name="passwordUser1" >
                            <label  for="passwordUser1">Password</label>
                        </div>
                        <div class="md-form">
                            <i class="fa fa-key prefix "></i>
                            <input type="text" id="passwordVerUser1" class="form-control form-control-sm" name="passwordVerUser1" >
                            <label for="passwordVerUser1">Verifica Password</label>
                        </div>


                    </div>
                    <!--Footer-->
                    <div class="modal-footer justify-content-center">
                        <button id="closeButtonUp" type="button" class="btn btn-secondary waves-effect waves-light" data-dismiss="modal">Chiudi</button>
                        <button type="submit" class="btn btn-primary waves-effect waves-light" name="submit" value="Submit">Salva</button>
                    </div>
                </form>   
            </div>
            <!--/.Content-->
        </div>
    </div>

    <!--Modal token -->
    <div class="modal fade show" id="token" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="padding-right: 17px; display: none;">
        <div class="modal-dialog modal-fluid" role="document" >
            <!--Content-->
            <div class="modal-content" >
                <!--Header-->
                <div class="modal-header">
                    <h4 class="modal-title w-100" id="myModalLabel">Generazione Token</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <!--Body-->
                <div class="modal-body">
                    <section id="bf-table" >


                        <p class="description"></p>


                        <section class="bf-table">

                            <div class="card card-cascade narrower" >


                                <div class="view gradient-card-header blue-gradient narrower py-2 mx-4 mb-3 d-flex justify-content-between align-items-center">


                                    <a href="" class="white-text mx-3">Lista token</a>

                                    <div>

                                        <button type="button" id="modificaToken" onclick="openModalUptoken()"
                                                class="btn btn-outline-white btn-rounded btn-sm px-2 waves-effect waves-light" data-toggle="modal" data-target="#updateToken"  data-tooltip="tooltip" data-placement="top" title="Modifica token"><i
                                                class="fa fa-pencil mt-0"></i></button>
                                        <button type="button" id="aggiungiToken" onclick="openModalIntoken()"
                                                class="btn btn-outline-white btn-rounded btn-sm px-2 waves-effect waves-light" data-toggle="modal" data-target="#insertTokens" data-tooltip="tooltip" data-placement="top" title="Aggiungi token"><i
                                                class="fa fa-plus mt-0"></i></button>
                                    </div>

                                </div>
                                <br>
                                <span id="alertErrUp" class="badge badge-danger" style="display: none">Aggiornamento Fallito.</span>
                                <span id="alertSuccUp" class="badge badge-success" style="display: none">Aggiornamento Completato.</span>
                                <span id="alertErrIn" class="badge badge-danger" style="display: none">Inserimento Fallito.</span>
                                <span id="alertSuccIn" class="badge badge-success" style="display: none">Inserimento Completato.</span>
                                <br>
                                <div class="px-4">
                                    <br>
                                    <div >

                                        <table id="tabTokens" class="table table-hover mb-0">

                                            <thead>
                                                <tr>
                                                    <th class="th-lg">Token</th>
                                                    <th class="th-lg">expiresIn</th>
                                                    <th class="th-lg">Create Token</th>
                                                    <th class="th-lg">Expires Token</th>
                                                    <th class="th-lg">tokenType</th>
                                                    <th class="th-lg">Username</th>
                                                    <th class="th-lg">ClientId</th>
                                                    <th class="th-lg">sessionType</th>
                                                    
                                                </tr>
                                            </thead>

                                        </table>

                                    </div>

                                    <hr class="my-0">


                                    <div class="d-flex justify-content-between">


                                        <nav id="my-4" class="my-4">

                                        </nav>


                                    </div>


                                </div>
                            </div>

                        </section>



                    </section>
                </div>
                <!--Footer-->
                <div class="modal-footer">

                </div>
            </div>
            <!--/.Content-->
        </div>
    </div>

    <!--Modal Insert token -->
    <div class="modal fade right" id="insertTokens" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="display: none;" aria-hidden="true">
        <div class="modal-dialog modal-full-height modal-right" role="document">
            <!--Content-->
            <div class="modal-content">
                <!--Header-->
                <div class="modal-header">
                    <h4 class="modal-title w-100" id="myModalLabe">Aggiungi Token Applicativo</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <!--Body-->
                <form id="tokenFormIns">
                    <div class="modal-body">
                        <p>In questa sezione &egrave; possibile aggiungere un nuovo token applicativo.
                        </p>

                        <div class="md-form">
                            <i class="fa fa-bullseye prefix "></i>
                            <input type="text" id="cliendId" class="form-control form-control-sm" name="cliendId" >
                            <label  for="cognomeUser1">Client ID</label>
                        </div>
                        <div class="md-form">
                            <i class="fa fa-calendar prefix "></i>
                            <input type="text" id="dataScadenza" class="form-control form-control-sm datepicker" name="dataScadenza" required>
                            <label  for="dataNascita">Data Scadenza</label>
                        </div>
                        <div class="md-form">
                            <i class="fa fa-key prefix "></i>
                            <input type="text" id="accessToken" class="form-control form-control-sm" name="accessToken" disabled>
                            <label  for="nomeUser1">Token</label>
                        </div>
                        <div class="md-form">
                            <button id="jwtRandom" type="button" class="btn btn-success btn-block waves-effect waves-light" >Genera</button>
                        </div>
                    </div>
                    <!--Footer-->
                    <div class="modal-footer justify-content-center">
                        <button id="closeButtonUp" type="button" class="btn btn-secondary waves-effect waves-light" data-dismiss="modal">Chiudi</button>
                        <button type="submit" class="btn btn-primary waves-effect waves-light" name="submit" value="Submit">Salva</button>
                    </div>
                </form>   
            </div>
            <!--/.Content-->
        </div>
    </div>

    <script>
        $(document).ready(function () {

            var arrayUtenti = {};

            var arrayGruppi = {};

            document.getElementById('tabsMenu').style.display = 'none';
            $('#letturaMenu').prop("checked", false);
            $('#inserimentoMenu').prop("checked", false);
            $('#modificaMenu').prop("checked", false);
            $('#cancellazioneMenu').prop("checked", false);
            document.getElementById('tabsSezioni').style.display = 'none';
            $('#letturaSezioni').prop("checked", false);
            $('#inserimentoSezioni').prop("checked", false);
            $('#modificaSezioni').prop("checked", false);
            $('#cancellazioneSezioni').prop("checked", false);
            document.getElementById('tabsUtenti').style.display = 'none';
            $('#letturaUtenti').prop("checked", false);
            $('#inserimentoUtenti').prop("checked", false);
            $('#modificaUtenti').prop("checked", false);
            $('#cancellazioneUtenti').prop("checked", false);
            document.getElementById('tabsAnagrafica').style.display = 'none';
            $('#letturaAnagrafica').prop("checked", false);
            $('#inserimentoAnagrafica').prop("checked", false);
            $('#modificaAnagrafica').prop("checked", false);
            $('#cancellazioneAnagrafica').prop("checked", false);
            document.getElementById('tabsGruppi').style.display = 'none';
            $('#letturaGruppi').prop("checked", false);
            $('#inserimentoGruppi').prop("checked", false);
            $('#modificaGruppi').prop("checked", false);
            $('#cancellazioneGruppi').prop("checked", false);
            document.getElementById('tabsDocumenti').style.display = 'none';
            $('#letturaDocumenti').prop("checked", false);
            $('#inserimentoDocumenti').prop("checked", false);
            $('#modificaDocumenti').prop("checked", false);
            $('#cancellazioneDocumenti').prop("checked", false);
            document.getElementById('tabsMedici').style.display = 'none';
            $('#letturaMedici').prop("checked", false);
            $('#inserimentoMedici').prop("checked", false);
            $('#modificaMedici').prop("checked", false);
            $('#cancellazioneMedici').prop("checked", false);
            document.getElementById('tabsAllegati').style.display = 'none';
            $('#letturaAllegati').prop("checked", false);
            $('#inserimentoAllegati').prop("checked", false);
            $('#modificaAllegati').prop("checked", false);
            $('#cancellazioneAllegati').prop("checked", false);

            document.getElementById('tabsMenu1').style.display = 'none';
            $('#letturaMenu1').prop("checked", false);
            $('#inserimentoMenu1').prop("checked", false);
            $('#modificaMenu1').prop("checked", false);
            $('#cancellazioneMenu1').prop("checked", false);
            document.getElementById('tabsSezioni1').style.display = 'none';
            $('#letturaSezioni1').prop("checked", false);
            $('#inserimentoSezioni1').prop("checked", false);
            $('#modificaSezioni1').prop("checked", false);
            $('#cancellazioneSezioni1').prop("checked", false);
            document.getElementById('tabsUtenti1').style.display = 'none';
            $('#letturaUtenti1').prop("checked", false);
            $('#inserimentoUtenti1').prop("checked", false);
            $('#modificaUtenti1').prop("checked", false);
            $('#cancellazioneUtenti1').prop("checked", false);
            document.getElementById('tabsAnagrafica1').style.display = 'none';
            $('#letturaAnagrafica1').prop("checked", false);
            $('#inserimentoAnagrafica1').prop("checked", false);
            $('#modificaAnagrafica1').prop("checked", false);
            $('#cancellazioneAnagrafica1').prop("checked", false);
            document.getElementById('tabsGruppi1').style.display = 'none';
            $('#letturaGruppi1').prop("checked", false);
            $('#inserimentoGruppi1').prop("checked", false);
            $('#modificaGruppi1').prop("checked", false);
            $('#cancellazioneGruppi1').prop("checked", false);
            document.getElementById('tabsDocumenti1').style.display = 'none';
            $('#letturaDocumenti1').prop("checked", false);
            $('#inserimentoDocumenti1').prop("checked", false);
            $('#modificaDocumenti1').prop("checked", false);
            $('#cancellazioneDocumenti1').prop("checked", false);
            document.getElementById('tabsMedici1').style.display = 'none';
            $('#letturaMedici1').prop("checked", false);
            $('#inserimentoMedici1').prop("checked", false);
            $('#modificaMedici1').prop("checked", false);
            $('#cancellazioneMedici1').prop("checked", false);
            document.getElementById('tabsAllegati1').style.display = 'none';
            $('#letturaAllegati1').prop("checked", false);
            $('#inserimentoAllegati1').prop("checked", false);
            $('#modificaAllegati1').prop("checked", false);
            $('#cancellazioneAllegati1').prop("checked", false);

            $('.mdb-select').material_select();
            $('[data-tooltip="tooltip"]').tooltip();
            $('.datepicker').pickadate();

            $('.label').addClass('active');

            $('#modificaGruppo').prop('disabled', true);
            $('#modificaUtente').prop('disabled', true);
            $('#modificaToken').prop('disabled', true);

            var url_string = document.URL;

            var url = new URL(url_string);
            var access_token = url.searchParams.get("authToken");

            tabUtenti = $('#tabUsers').DataTable({

                ajax: {
                    url: '../rest/users',
                    type: "GET",
                    headers: {
                        'Content-Type': 'application/json',
                        'Authorization': "Bearer " + access_token},
                    dataSrc: function (json) {
                        return json.object;
                    }
                },
                responsive: true,
                autoWidth: false,
                paging: false,
                searching: false,
                info: false,
                aoColumns: [
                    {'data': "profilo"},
                    {'data': "lastname"},
                    {'data': "firstname"},
                    {'data': "username"},
                    {'data': "attivo", "render": function (data) {
                            if (data === true) {
                                return '<i class="fa fa-check mt-0" style="color: "green"></i>';
                            } else if (data === false) {
                                return '<i class="fa fa-close mt-0" style="color: "red"></i>';
                            }
                        }},
                    {'data': "primaryKey", visible: false},
                    {'data': "createUser", visible: false},
                    {'data': "createDate", visible: false},
                    {'data': "updateUser", visible: false},
                    {'data': "updateDate", visible: false},
                    {'data': "proprietario", visible: false, defaultContent: ""},
                    {'data': "image", visible: false, defaultContent: ""},
                    {'data': "permessi", visible: false, defaultContent: ""},
                    {'data': "scadenzaUtenza", visible: false},
                    {'data': "id", visible: false},
                    {'data': "email", visible: false},
                    {'data': "menu", visible: false, defaultContent: ""},
                    {'data': "idAnagrafica", visible: false, defaultContent: ""}
                ]
            });

            $('#tabUsers tbody').on('click', 'tr', function () {
                if ($(this).hasClass('selected')) {
                    $(this).removeClass('selected');
                    $('#modificaUtente').prop('disabled', true);
                } else {
                    tabUtenti.$('tr.selected').removeClass('selected');
                    $(this).addClass('selected');
                    $('#modificaUtente').prop('disabled', false);
                    ;
                }
            });

            $('#tabUsers tbody').on('click', 'td.details-control', function () {
                var tr = $(this).closest('tr');
                var row = tabUtenti.row(tr);

                if (row.child.isShown()) {
                    // This row is already open - close it
                    row.child.hide();
                    tr.removeClass('shown');
                } else {
                    // Open this row
                    row.child(format(row.data())).show();
                    tr.addClass('shown');
                }
            });

            tabGruppi = $('#customTable').DataTable({

                ajax: {
                    url: '../rest/users/gruppi',
                    type: "GET",
                    headers: {
                        'Content-Type': 'application/json',
                        'Authorization': "Bearer " + access_token},
                    dataSrc: function (json) {
                        return json.object;
                    }
                },
                responsive: true,
                autoWidth: false,
                paging: false,
                searching: false,
                info: false,
                columns: [
                    {'data': "id", visible: false},
                    {'data': "nome"},
                    {'data': "descrizione"},
                    {'data': "primaryKey", visible: false},
                    {'data': "createUser", visible: false},
                    {'data': "createDate", visible: false},
                    {'data': "updateUser", visible: false},
                    {'data': "updateDate", visible: false},
                    {'data': "proprietario", visible: false},
                    {'data': "permessi", visible: false},
                    {'data': "menu", visible: false}
                ]
            });

            $('#customTable tbody').on('click', 'tr', function () {
                if ($(this).hasClass('selected')) {
                    $(this).removeClass('selected');
                    $('#modificaGruppo').prop('disabled', true);
                } else {
                    tabGruppi.$('tr.selected').removeClass('selected');
                    $(this).addClass('selected');
                    $('#modificaGruppo').prop('disabled', false);
                    ;
                }
            });

            $('#customTable tbody').on('click', 'td.details-control', function () {
                var tr = $(this).closest('tr');
                var row = tabGruppi.row(tr);

                if (row.child.isShown()) {
                    // This row is already open - close it
                    row.child.hide();
                    tr.removeClass('shown');
                } else {
                    // Open this row
                    row.child(format(row.data())).show();
                    tr.addClass('shown');
                }
            });

            $.ajax({
                url: '../rest/configurazione/menu',
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': "Bearer " + access_token
                },
                success: function (response) {

                    for (var i = 0; i < response.object.length; i++) {
                        if (response.object[i].leaf === false) {
                            response.object.push(response.object[i].children[0]);
                            response.object.push(response.object[i].children[1]);
                            delete response.object[i];
                        }
                    }


                    var newArray = new Array();
                    for (var i = 0; i < response.object.length; i++) {
                        if (response.object[i]) {
                            newArray.push(response.object[i]);
                        }
                    }

                    $('.mdb-select').material_select('destroy');


                    var arrayUser = newArray;

                    var materialUserAddID = document.getElementById('menu');
                    var materialUserAddID1 = document.getElementById('menu1');
                    $.each(arrayUser, function (i) {
                        var option = document.createElement("option");
                        if (arrayUser[i].idPadre) {
                            option.text = arrayUser[i].idPadre + ' -> ' + arrayUser[i].text;
                        } else {
                            option.text = arrayUser[i].text;
                        }

                        option.value = JSON.stringify(arrayUser[i]);
                        materialUserAddID.add(option);
                        materialUserAddID1.add(option);
                    });

                    $('.mdb-select').material_select();

                },
                failure: function (response) {


                }
            });

            $.ajax({
                url: '../rest/configurazione/sezioni',
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': "Bearer " + access_token
                },
                success: function (response) {

                    $('.mdb-select').material_select('destroy');


                    var arrayUser = response.object;

                    var materialUserAddID = document.getElementById('sezione');
                    var materialUserAddID1 = document.getElementById('sezione1');
                    $.each(arrayUser, function (i) {
                        var option = document.createElement("option");
                        option.text = arrayUser[i].descrizione;
                        option.value = arrayUser[i].id;
                        materialUserAddID.add(option);
                        materialUserAddID1.add(option);
                    });

                    $('.mdb-select').material_select();

                },
                failure: function (response) {

                }
            });

            $.ajax({
                url: '../rest/configurazione/permessi',
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': "Bearer " + access_token
                },
                success: function (response) {

                },
                failure: function (response) {

                }
            });

            $.ajax({
                url: '../rest/users/gruppi',
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': "Bearer " + access_token
                },
                success: function (response) {

                    $('.mdb-select').material_select('destroy');


                    var arrayUser = response.object;

                    var materialUserAddID = document.getElementById('profiloUser');
                    $.each(arrayUser, function (i) {
                        var option = document.createElement("option");
                        option.text = arrayUser[i].descrizione;
                        option.value = arrayUser[i].descrizione;
                        materialUserAddID.add(option);
                    });

                    $('.mdb-select').material_select();

                    $('.mdb-select').material_select('destroy');


                    var arrayUser1 = response.object;

                    var materialUserAddID1 = document.getElementById('profiloUser1');
                    $.each(arrayUser1, function (i) {
                        var option1 = document.createElement("option");
                        option1.text = arrayUser[i].descrizione;
                        option1.value = arrayUser[i].descrizione;
                        materialUserAddID1.add(option1);
                    });

                    $('.mdb-select').material_select();

                },
                failure: function (response) {

                }
            });
            
            tabTokens = $('#tabTokens').DataTable({

                ajax: {
                    url: '../rest/token/applicativi',
                    type: "GET",
                    headers: {
                        'Content-Type': 'application/json',
                        'Authorization': "Bearer " + access_token},
                    dataSrc: function (json) {
                        var a =[];
                        a.push(json);
                        return a;
                    }
                },
                responsive: true,
                autoWidth: false,
                paging: false,
                searching: false,
                info: false,
                columns: [
                    {'data': "accessToken"},
                    {'data': "expiresIn",visible: false},
                    {'data': "createToken"},
                    {'data': "expiresToken","render": function (data) {
                            moment.locale('it');
                            var d = new Date(data);
                            var a = moment(d); 
                            return a.format('LLLL');
                        }},
                    {'data': "tokenType",visible: false},
                    {'data': "username"},
                    {'data': "session.clientId"},
                    {'data': "sessionType",visible: false}
                ]
            });

            $('#tabTokens tbody').on('click', 'tr', function () {
                if ($(this).hasClass('selected')) {
                    $(this).removeClass('selected');
                    $('#modificaToken').prop('disabled', true);
                } else {
                    tabGruppi.$('tr.selected').removeClass('selected');
                    $(this).addClass('selected');
                    $('#modificaToken').prop('disabled', false);
                    ;
                }
            });

            $('#tabTokens tbody').on('click', 'td.details-control', function () {
                var tr = $(this).closest('tr');
                var row = tabGruppi.row(tr);

                if (row.child.isShown()) {
                    // This row is already open - close it
                    row.child.hide();
                    tr.removeClass('shown');
                } else {
                    // Open this row
                    row.child(format(row.data())).show();
                    tr.addClass('shown');
                }
            });
            
            function makeid() {
                var text = "";
                var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

                for (var i = 0; i < 5; i++)
                     text += possible.charAt(Math.floor(Math.random() * possible.length));

                    return text;
            }
            
            document.getElementById('jwtRandom').addEventListener(
             'click',
            function (event) {
                event.preventDefault();
                document.getElementById('accessToken').value = md5(makeid());
            }
            );

        });
        
        function setModalGroup(){
            document.getElementById('alertSuccInGp').style.display = 'none'; 
            document.getElementById('alertErrInGp').style.display = 'none';
            document.getElementById('alertSuccUpGp').style.display = 'none'; 
            document.getElementById('alertErrUpGp').style.display = 'none';
        }
        
        function setModalUser(){
            document.getElementById('alertSuccIn').style.display = 'none'; 
            document.getElementById('alertErrIn').style.display = 'none';
            document.getElementById('alertSuccUp').style.display = 'none'; 
            document.getElementById('alertErrUp').style.display = 'none';
        }
        
        function setModaltoken(){
            document.getElementById('alertSuccIn').style.display = 'none'; 
            document.getElementById('alertErrIn').style.display = 'none';
            document.getElementById('alertSuccUp').style.display = 'none'; 
            document.getElementById('alertErrUp').style.display = 'none';
        }

        function convertDate(data) {
            function pad(s) {
                return (s < 10) ? '0' + s : s;
            }
            ;
            var d = new Date(data);
            return [pad(d.getDate()), pad(d.getMonth() + 1), d.getFullYear()].join('/');
        }

        function openModalUp() {
            var ids1 = $.map(tabGruppi.rows('.selected').data(), function (item) {
                return item;
            });
            arrayGruppi = ids1;

            $('#nomeGruppo1').val(arrayGruppi[0].nome);
            $('#descrizioneGruppo1').val(arrayGruppi[0].descrizione);

            document.getElementById('tabsMenu1').style.display = 'none';
            $('#letturaMenu1').prop("checked", false);
            $('#inserimentoMenu1').prop("checked", false);
            $('#modificaMenu1').prop("checked", false);
            $('#cancellazioneMenu1').prop("checked", false);
            document.getElementById('tabsSezioni1').style.display = 'none';
            $('#letturaSezioni1').prop("checked", false);
            $('#inserimentoSezioni1').prop("checked", false);
            $('#modificaSezioni1').prop("checked", false);
            $('#cancellazioneSezioni1').prop("checked", false);
            document.getElementById('tabsUtenti1').style.display = 'none';
            $('#letturaUtenti1').prop("checked", false);
            $('#inserimentoUtenti1').prop("checked", false);
            $('#modificaUtenti1').prop("checked", false);
            $('#cancellazioneUtenti1').prop("checked", false);
            document.getElementById('tabsAnagrafica1').style.display = 'none';
            $('#letturaAnagrafica1').prop("checked", false);
            $('#inserimentoAnagrafica1').prop("checked", false);
            $('#modificaAnagrafica1').prop("checked", false);
            $('#cancellazioneAnagrafica1').prop("checked", false);
            document.getElementById('tabsGruppi1').style.display = 'none';
            $('#letturaGruppi1').prop("checked", false);
            $('#inserimentoGruppi1').prop("checked", false);
            $('#modificaGruppi1').prop("checked", false);
            $('#cancellazioneGruppi1').prop("checked", false);
            document.getElementById('tabsDocumenti1').style.display = 'none';
            $('#letturaDocumenti1').prop("checked", false);
            $('#inserimentoDocumenti1').prop("checked", false);
            $('#modificaDocumenti1').prop("checked", false);
            $('#cancellazioneDocumenti1').prop("checked", false);
            document.getElementById('tabsMedici1').style.display = 'none';
            $('#letturaMedici1').prop("checked", false);
            $('#inserimentoMedici1').prop("checked", false);
            $('#modificaMedici1').prop("checked", false);
            $('#cancellazioneMedici1').prop("checked", false);
            document.getElementById('tabsAllegati1').style.display = 'none';
            $('#letturaAllegati1').prop("checked", false);
            $('#inserimentoAllegati1').prop("checked", false);
            $('#modificaAllegati1').prop("checked", false);
            $('#cancellazioneAllegati1').prop("checked", false);

            var arrayMenu = JSON.parse(arrayGruppi[0].menu);

            $('.mdb-select').material_select('destroy');

            var select = document.getElementById("menu1");

            for (var i = 0; i < select.options.length; i++) {
                select.options[i].selected = false;

            }

            for (var i = 0; i < select.options.length; i++) {
                for (var j = 0; j < arrayMenu.length; j++) {
                    if (select.options[i].text === arrayMenu[j].text || select.options[i].text === arrayMenu[j].idPadre + ' -> ' + arrayMenu[j].text) {
                        select.options[i].selected = true;
                    }
                }
            }

            $('.mdb-select').material_select();

            var arrayPermessi = JSON.parse(arrayGruppi[0].permessi);

            for (var i = 0; i < arrayPermessi.length; i++) {
                if (arrayPermessi[i].sezione === 'menu') {

                    if (arrayPermessi[i].permessi === 1) {

                        $('#letturaMenu1').prop("checked", true);
                        $('#inserimentoMenu1').prop("checked", false);
                        $('#modificaMenu1').prop("checked", false);
                        $('#cancellazioneMenu1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 2) {

                        $('#letturaMenu1').prop("checked", false);
                        $('#inserimentoMenu1').prop("checked", true);
                        $('#modificaMenu1').prop("checked", false);
                        $('#cancellazioneMenu1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 3) {

                        $('#letturaMenu1').prop("checked", true);
                        $('#inserimentoMenu1').prop("checked", true);
                        $('#modificaMenu1').prop("checked", false);
                        $('#cancellazioneMenu1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 4) {

                        $('#letturaMenu1').prop("checked", false);
                        $('#inserimentoMenu1').prop("checked", false);
                        $('#modificaMenu1').prop("checked", true);
                        $('#cancellazioneMenu1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 5) {

                        $('#letturaMenu1').prop("checked", true);
                        $('#inserimentoMenu1').prop("checked", false);
                        $('#modificaMenu1').prop("checked", true);
                        $('#cancellazioneMenu1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 6) {

                        $('#letturaMenu1').prop("checked", false);
                        $('#inserimentoMenu1').prop("checked", true);
                        $('#modificaMenu1').prop("checked", true);
                        $('#cancellazioneMenu1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 7) {

                        $('#letturaMenu1').prop("checked", true);
                        $('#inserimentoMenu1').prop("checked", true);
                        $('#modificaMenu1').prop("checked", true);
                        $('#cancellazioneMenu1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 8) {

                        $('#letturaMenu1').prop("checked", false);
                        $('#inserimentoMenu1').prop("checked", false);
                        $('#modificaMenu1').prop("checked", false);
                        $('#cancellazioneMenu1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 9) {

                        $('#letturaMenu1').prop("checked", true);
                        $('#inserimentoMenu1').prop("checked", false);
                        $('#modificaMenu1').prop("checked", false);
                        $('#cancellazioneMenu1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 10) {

                        $('#letturaMenu1').prop("checked", false);
                        $('#inserimentoMenu1').prop("checked", true);
                        $('#modificaMenu1').prop("checked", false);
                        $('#cancellazioneMenu1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 11) {

                        $('#letturaMenu1').prop("checked", true);
                        $('#inserimentoMenu1').prop("checked", true);
                        $('#modificaMenu1').prop("checked", false);
                        $('#cancellazioneMenu1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 12) {

                        $('#letturaMenu1').prop("checked", false);
                        $('#inserimentoMenu1').prop("checked", false);
                        $('#modificaMenu1').prop("checked", true);
                        $('#cancellazioneMenu1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 13) {

                        $('#letturaMenu1').prop("checked", true);
                        $('#inserimentoMenu1').prop("checked", false);
                        $('#modificaMenu1').prop("checked", true);
                        $('#cancellazioneMenu1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 14) {

                        $('#letturaMenu1').prop("checked", false);
                        $('#inserimentoMenu1').prop("checked", true);
                        $('#modificaMenu1').prop("checked", true);
                        $('#cancellazioneMenu1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 15) {

                        $('#letturaMenu1').prop("checked", true);
                        $('#inserimentoMenu1').prop("checked", true);
                        $('#modificaMenu1').prop("checked", true);
                        $('#cancellazioneMenu1').prop("checked", true);

                    }

                }
                if (arrayPermessi[i].sezione === 'sezioni') {

                    if (arrayPermessi[i].permessi === 1) {

                        $('#letturaSezioni1').prop("checked", true);
                        $('#inserimentoSezioni1').prop("checked", false);
                        $('#modificaSezioni1').prop("checked", false);
                        $('#cancellazioneSezioni1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 2) {

                        $('#letturaSezioni1').prop("checked", false);
                        $('#inserimentoSezioni1').prop("checked", true);
                        $('#modificaSezioni1').prop("checked", false);
                        $('#cancellazioneSezioni1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 3) {

                        $('#letturaSezioni1').prop("checked", true);
                        $('#inserimentoSezioni1').prop("checked", true);
                        $('#modificaSezioni1').prop("checked", false);
                        $('#cancellazioneSezioni1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 4) {

                        $('#letturaSezioni1').prop("checked", false);
                        $('#inserimentoSezioni1').prop("checked", false);
                        $('#modificaSezioni1').prop("checked", true);
                        $('#cancellazioneSezioni1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 5) {

                        $('#letturaSezioni1').prop("checked", true);
                        $('#inserimentoSezioni1').prop("checked", false);
                        $('#modificaSezioni1').prop("checked", true);
                        $('#cancellazioneSezioni1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 6) {

                        $('#letturaSezioni1').prop("checked", false);
                        $('#inserimentoSezioni1').prop("checked", true);
                        $('#modificaSezioni1').prop("checked", true);
                        $('#cancellazioneSezioni1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 7) {

                        $('#letturaSezioni1').prop("checked", true);
                        $('#inserimentoSezioni1').prop("checked", true);
                        $('#modificaSezioni1').prop("checked", true);
                        $('#cancellazioneSezioni1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 8) {

                        $('#letturaSezioni1').prop("checked", false);
                        $('#inserimentoSezioni1').prop("checked", false);
                        $('#modificaSezioni1').prop("checked", false);
                        $('#cancellazioneSezioni1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 9) {

                        $('#letturaSezioni1').prop("checked", true);
                        $('#inserimentoSezioni1').prop("checked", false);
                        $('#modificaSezioni1').prop("checked", false);
                        $('#cancellazioneSezioni1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 10) {

                        $('#letturaSezioni1').prop("checked", false);
                        $('#inserimentoSezioni1').prop("checked", true);
                        $('#modificaSezioni1').prop("checked", false);
                        $('#cancellazioneSezioni1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 11) {

                        $('#letturaSezioni1').prop("checked", true);
                        $('#inserimentoSezioni1').prop("checked", true);
                        $('#modificaSezioni1').prop("checked", false);
                        $('#cancellazioneSezioni1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 12) {

                        $('#letturaSezioni1').prop("checked", false);
                        $('#inserimentoSezioni1').prop("checked", false);
                        $('#modificaSezioni1').prop("checked", true);
                        $('#cancellazioneSezioni1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 13) {

                        $('#letturaSezioni1').prop("checked", true);
                        $('#inserimentoSezioni1').prop("checked", false);
                        $('#modificaSezioni1').prop("checked", true);
                        $('#cancellazioneSezioni1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 14) {

                        $('#letturaSezioni1').prop("checked", false);
                        $('#inserimentoSezioni1').prop("checked", true);
                        $('#modificaSezioni1').prop("checked", true);
                        $('#cancellazioneSezioni1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 15) {

                        $('#letturaSezioni1').prop("checked", true);
                        $('#inserimentoSezioni1').prop("checked", true);
                        $('#modificaSezioni1').prop("checked", true);
                        $('#cancellazioneSezioni1').prop("checked", true);

                    }

                }
                if (arrayPermessi[i].sezione === 'utenti') {

                    if (arrayPermessi[i].permessi === 1) {

                        $('#letturaUtenti1').prop("checked", true);
                        $('#inserimentoUtenti1').prop("checked", false);
                        $('#modificaUtenti1').prop("checked", false);
                        $('#cancellazioneUtenti1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 2) {

                        $('#letturaUtenti1').prop("checked", false);
                        $('#inserimentoUtenti1').prop("checked", true);
                        $('#modificaUtenti1').prop("checked", false);
                        $('#cancellazioneUtenti1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 3) {

                        $('#letturaUtenti1').prop("checked", true);
                        $('#inserimentoUtenti1').prop("checked", true);
                        $('#modificaUtenti1').prop("checked", false);
                        $('#cancellazioneUtenti1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 4) {

                        $('#letturaUtenti1').prop("checked", false);
                        $('#inserimentoUtenti1').prop("checked", false);
                        $('#modificaUtenti1').prop("checked", true);
                        $('#cancellazioneUtenti1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 5) {

                        $('#letturaUtenti1').prop("checked", true);
                        $('#inserimentoUtenti1').prop("checked", false);
                        $('#modificaUtenti1').prop("checked", true);
                        $('#cancellazioneUtenti1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 6) {

                        $('#letturaUtenti1').prop("checked", false);
                        $('#inserimentoUtenti1').prop("checked", true);
                        $('#modificaUtenti1').prop("checked", true);
                        $('#cancellazioneUtenti1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 7) {

                        $('#letturaUtenti1').prop("checked", true);
                        $('#inserimentoUtenti1').prop("checked", true);
                        $('#modificaUtenti1').prop("checked", true);
                        $('#cancellazioneUtenti1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 8) {

                        $('#letturaUtenti1').prop("checked", false);
                        $('#inserimentoUtenti1').prop("checked", false);
                        $('#modificaUtenti1').prop("checked", false);
                        $('#cancellazioneUtenti1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 9) {

                        $('#letturaUtenti1').prop("checked", true);
                        $('#inserimentoUtenti1').prop("checked", false);
                        $('#modificaUtenti1').prop("checked", false);
                        $('#cancellazioneUtenti1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 10) {

                        $('#letturaUtenti1').prop("checked", false);
                        $('#inserimentoUtenti1').prop("checked", true);
                        $('#modificaUtenti1').prop("checked", false);
                        $('#cancellazioneUtenti1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 11) {

                        $('#letturaUtenti1').prop("checked", true);
                        $('#inserimentoUtenti1').prop("checked", true);
                        $('#modificaUtenti1').prop("checked", false);
                        $('#cancellazioneUtenti1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 12) {

                        $('#letturaUtenti1').prop("checked", false);
                        $('#inserimentoUtenti1').prop("checked", false);
                        $('#modificaUtenti1').prop("checked", true);
                        $('#cancellazioneUtenti1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 13) {

                        $('#letturaUtenti1').prop("checked", true);
                        $('#inserimentoUtenti1').prop("checked", false);
                        $('#modificaUtenti1').prop("checked", true);
                        $('#cancellazioneUtenti1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 14) {

                        $('#letturaUtenti1').prop("checked", false);
                        $('#inserimentoUtenti1').prop("checked", true);
                        $('#modificaUtenti1').prop("checked", true);
                        $('#cancellazioneUtenti1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 15) {

                        $('#letturaUtenti1').prop("checked", true);
                        $('#inserimentoUtenti1').prop("checked", true);
                        $('#modificaUtenti1').prop("checked", true);
                        $('#cancellazioneUtenti1').prop("checked", true);

                    }

                }
                if (arrayPermessi[i].sezione === 'anagrafica') {

                    if (arrayPermessi[i].permessi === 1) {

                        $('#letturaAnagrafica1').prop("checked", true);
                        $('#inserimentoAnagrafica1').prop("checked", false);
                        $('#modificaAnagrafica1').prop("checked", false);
                        $('#cancellazioneAnagrafica1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 2) {

                        $('#letturaAnagrafica1').prop("checked", false);
                        $('#inserimentoAnagrafica1').prop("checked", true);
                        $('#modificaAnagrafica1').prop("checked", false);
                        $('#cancellazioneAnagrafica1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 3) {

                        $('#letturaAnagrafica1').prop("checked", true);
                        $('#inserimentoAnagrafica1').prop("checked", true);
                        $('#modificaAnagrafica1').prop("checked", false);
                        $('#cancellazioneAnagrafica1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 4) {

                        $('#letturaAnagrafica1').prop("checked", false);
                        $('#inserimentoAnagrafica1').prop("checked", false);
                        $('#modificaAnagrafica1').prop("checked", true);
                        $('#cancellazioneAnagrafica1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 5) {

                        $('#letturaAnagrafica1').prop("checked", true);
                        $('#inserimentoAnagrafica1').prop("checked", false);
                        $('#modificaAnagrafica1').prop("checked", true);
                        $('#cancellazioneAnagrafica1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 6) {

                        $('#letturaAnagrafica1').prop("checked", false);
                        $('#inserimentoAnagrafica1').prop("checked", true);
                        $('#modificaAnagrafica1').prop("checked", true);
                        $('#cancellazioneAnagrafica1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 7) {

                        $('#letturaAnagrafica1').prop("checked", true);
                        $('#inserimentoAnagrafica1').prop("checked", true);
                        $('#modificaAnagrafica1').prop("checked", true);
                        $('#cancellazioneAnagrafica1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 8) {

                        $('#letturaAnagrafica1').prop("checked", false);
                        $('#inserimentoAnagrafica1').prop("checked", false);
                        $('#modificaAnagrafica1').prop("checked", false);
                        $('#cancellazioneAnagrafica1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 9) {

                        $('#letturaAnagrafica1').prop("checked", true);
                        $('#inserimentoAnagrafica1').prop("checked", false);
                        $('#modificaAnagrafica1').prop("checked", false);
                        $('#cancellazioneAnagrafica1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 10) {

                        $('#letturaAnagrafica1').prop("checked", false);
                        $('#inserimentoAnagrafica1').prop("checked", true);
                        $('#modificaAnagrafica1').prop("checked", false);
                        $('#cancellazioneAnagrafica1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 11) {

                        $('#letturaAnagrafica1').prop("checked", true);
                        $('#inserimentoAnagrafica1').prop("checked", true);
                        $('#modificaAnagrafica1').prop("checked", false);
                        $('#cancellazioneAnagrafica1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 12) {

                        $('#letturaAnagrafica1').prop("checked", false);
                        $('#inserimentoAnagrafica1').prop("checked", false);
                        $('#modificaAnagrafica1').prop("checked", true);
                        $('#cancellazioneAnagrafica1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 13) {

                        $('#letturaAnagrafica1').prop("checked", true);
                        $('#inserimentoAnagrafica1').prop("checked", false);
                        $('#modificaAnagrafica1').prop("checked", true);
                        $('#cancellazioneAnagrafica1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 14) {

                        $('#letturaAnagrafica1').prop("checked", false);
                        $('#inserimentoAnagrafica1').prop("checked", true);
                        $('#modificaAnagrafica1').prop("checked", true);
                        $('#cancellazioneAnagrafica1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 15) {

                        $('#letturaAnagrafica1').prop("checked", true);
                        $('#inserimentoAnagrafica1').prop("checked", true);
                        $('#modificaAnagrafica1').prop("checked", true);
                        $('#cancellazioneAnagrafica1').prop("checked", true);

                    }

                }
                if (arrayPermessi[i].sezione === 'gruppi') {

                    if (arrayPermessi[i].permessi === 1) {

                        $('#letturaGruppi1').prop("checked", true);
                        $('#inserimentoGruppi1').prop("checked", false);
                        $('#modificaGruppi1').prop("checked", false);
                        $('#cancellazioneGruppi1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 2) {

                        $('#letturaGruppi1').prop("checked", false);
                        $('#inserimentoGruppi1').prop("checked", true);
                        $('#modificaGruppi1').prop("checked", false);
                        $('#cancellazioneGruppi1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 3) {

                        $('#letturaGruppi1').prop("checked", true);
                        $('#inserimentoGruppi1').prop("checked", true);
                        $('#modificaGruppi1').prop("checked", false);
                        $('#cancellazioneGruppi1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 4) {

                        $('#letturaGruppi1').prop("checked", false);
                        $('#inserimentoGruppi1').prop("checked", false);
                        $('#modificaGruppi1').prop("checked", true);
                        $('#cancellazioneGruppi1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 5) {

                        $('#letturaGruppi1').prop("checked", true);
                        $('#inserimentoGruppi1').prop("checked", false);
                        $('#modificaGruppi1').prop("checked", true);
                        $('#cancellazioneGruppi1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 6) {

                        $('#letturaGruppi1').prop("checked", false);
                        $('#inserimentoGruppi1').prop("checked", true);
                        $('#modificaGruppi1').prop("checked", true);
                        $('#cancellazioneGruppi1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 7) {

                        $('#letturaGruppi1').prop("checked", true);
                        $('#inserimentoGruppi1').prop("checked", true);
                        $('#modificaGruppi1').prop("checked", true);
                        $('#cancellazioneGruppi1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 8) {

                        $('#letturaGruppi1').prop("checked", false);
                        $('#inserimentoGruppi1').prop("checked", false);
                        $('#modificaGruppi1').prop("checked", false);
                        $('#cancellazioneGruppi1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 9) {

                        $('#letturaGruppi1').prop("checked", true);
                        $('#inserimentoGruppi1').prop("checked", false);
                        $('#modificaGruppi1').prop("checked", false);
                        $('#cancellazioneGruppi1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 10) {

                        $('#letturaGruppi1').prop("checked", false);
                        $('#inserimentoGruppi1').prop("checked", true);
                        $('#modificaGruppi1').prop("checked", false);
                        $('#cancellazioneGruppi1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 11) {

                        $('#letturaGruppi1').prop("checked", true);
                        $('#inserimentoGruppi1').prop("checked", true);
                        $('#modificaGruppi1').prop("checked", false);
                        $('#cancellazioneGruppi1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 12) {

                        $('#letturaGruppi1').prop("checked", false);
                        $('#inserimentoGruppi1').prop("checked", false);
                        $('#modificaGruppi1').prop("checked", true);
                        $('#cancellazioneGruppi1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 13) {

                        $('#letturaGruppi1').prop("checked", true);
                        $('#inserimentoGruppi1').prop("checked", false);
                        $('#modificaGruppi1').prop("checked", true);
                        $('#cancellazioneGruppi1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 14) {

                        $('#letturaGruppi1').prop("checked", false);
                        $('#inserimentoGruppi1').prop("checked", true);
                        $('#modificaGruppi1').prop("checked", true);
                        $('#cancellazioneGruppi1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 15) {

                        $('#letturaGruppi1').prop("checked", true);
                        $('#inserimentoGruppi1').prop("checked", true);
                        $('#modificaGruppi1').prop("checked", true);
                        $('#cancellazioneGruppi1').prop("checked", true);

                    }

                }
                if (arrayPermessi[i].sezione === 'documenti') {

                    if (arrayPermessi[i].permessi === 1) {

                        $('#letturaDocumenti1').prop("checked", true);
                        $('#inserimentoDocumenti1').prop("checked", false);
                        $('#modificaDocumenti1').prop("checked", false);
                        $('#cancellazioneDocumenti1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 2) {

                        $('#letturaDocumenti1').prop("checked", false);
                        $('#inserimentoDocumenti1').prop("checked", true);
                        $('#modificaDocumenti1').prop("checked", false);
                        $('#cancellazioneDocumenti1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 3) {

                        $('#letturaDocumenti1').prop("checked", true);
                        $('#inserimentoDocumenti1').prop("checked", true);
                        $('#modificaDocumenti1').prop("checked", false);
                        $('#cancellazioneDocumenti1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 4) {

                        $('#letturaDocumenti1').prop("checked", false);
                        $('#inserimentoDocumenti1').prop("checked", false);
                        $('#modificaDocumenti1').prop("checked", true);
                        $('#cancellazioneDocumenti1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 5) {

                        $('#letturaDocumenti1').prop("checked", true);
                        $('#inserimentoDocumenti1').prop("checked", false);
                        $('#modificaDocumenti1').prop("checked", true);
                        $('#cancellazioneDocumenti1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 6) {

                        $('#letturaDocumenti1').prop("checked", false);
                        $('#inserimentoDocumenti1').prop("checked", true);
                        $('#modificaDocumenti1').prop("checked", true);
                        $('#cancellazioneDocumenti1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 7) {

                        $('#letturaDocumenti1').prop("checked", true);
                        $('#inserimentoDocumenti1').prop("checked", true);
                        $('#modificaDocumenti1').prop("checked", true);
                        $('#cancellazioneDocumenti1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 8) {

                        $('#letturaDocumenti1').prop("checked", false);
                        $('#inserimentoDocumenti1').prop("checked", false);
                        $('#modificaDocumenti1').prop("checked", false);
                        $('#cancellazioneDocumenti1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 9) {

                        $('#letturaDocumenti1').prop("checked", true);
                        $('#inserimentoDocumenti1').prop("checked", false);
                        $('#modificaDocumenti1').prop("checked", false);
                        $('#cancellazioneDocumenti1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 10) {

                        $('#letturaDocumenti1').prop("checked", false);
                        $('#inserimentoDocumenti1').prop("checked", true);
                        $('#modificaDocumenti1').prop("checked", false);
                        $('#cancellazioneDocumenti1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 11) {

                        $('#letturaDocumenti1').prop("checked", true);
                        $('#inserimentoDocumenti1').prop("checked", true);
                        $('#modificaDocumenti1').prop("checked", false);
                        $('#cancellazioneDocumenti1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 12) {

                        $('#letturaDocumenti1').prop("checked", false);
                        $('#inserimentoDocumenti1').prop("checked", false);
                        $('#modificaDocumenti1').prop("checked", true);
                        $('#cancellazioneDocumenti1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 13) {

                        $('#letturaDocumenti1').prop("checked", true);
                        $('#inserimentoDocumenti1').prop("checked", false);
                        $('#modificaDocumenti1').prop("checked", true);
                        $('#cancellazioneDocumenti1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 14) {

                        $('#letturaDocumenti1').prop("checked", false);
                        $('#inserimentoDocumenti1').prop("checked", true);
                        $('#modificaDocumenti1').prop("checked", true);
                        $('#cancellazioneDocumenti1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 15) {

                        $('#letturaDocumenti1').prop("checked", true);
                        $('#inserimentoDocumenti1').prop("checked", true);
                        $('#modificaDocumenti1').prop("checked", true);
                        $('#cancellazioneDocumenti1').prop("checked", true);

                    }

                }
                if (arrayPermessi[i].sezione === 'medici') {

                    if (arrayPermessi[i].permessi === 1) {

                        $('#letturaMedici1').prop("checked", true);
                        $('#inserimentoMedici1').prop("checked", false);
                        $('#modificaMedici1').prop("checked", false);
                        $('#cancellazioneMedici1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 2) {

                        $('#letturaMedici1').prop("checked", false);
                        $('#inserimentoMedici1').prop("checked", true);
                        $('#modificaMedici1').prop("checked", false);
                        $('#cancellazioneMedici1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 3) {

                        $('#letturaMedici1').prop("checked", true);
                        $('#inserimentoMedici1').prop("checked", true);
                        $('#modificaMedici1').prop("checked", false);
                        $('#cancellazioneMedici1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 4) {

                        $('#letturaMedici1').prop("checked", false);
                        $('#inserimentoMedici1').prop("checked", false);
                        $('#modificaMedici1').prop("checked", true);
                        $('#cancellazioneMedici1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 5) {

                        $('#letturaMedici1').prop("checked", true);
                        $('#inserimentoMedici1').prop("checked", false);
                        $('#modificaMedici1').prop("checked", true);
                        $('#cancellazioneMedici1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 6) {

                        $('#letturaMedici1').prop("checked", false);
                        $('#inserimentoMedici1').prop("checked", true);
                        $('#modificaMedici1').prop("checked", true);
                        $('#cancellazioneMedici1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 7) {

                        $('#letturaMedici1').prop("checked", true);
                        $('#inserimentoMedici1').prop("checked", true);
                        $('#modificaMedici1').prop("checked", true);
                        $('#cancellazioneMedici1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 8) {

                        $('#letturaMedici1').prop("checked", false);
                        $('#inserimentoMedici1').prop("checked", false);
                        $('#modificaMedici1').prop("checked", false);
                        $('#cancellazioneMedici1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 9) {

                        $('#letturaMedici1').prop("checked", true);
                        $('#inserimentoMedici1').prop("checked", false);
                        $('#modificaMedici1').prop("checked", false);
                        $('#cancellazioneMedici1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 10) {

                        $('#letturaMedici1').prop("checked", false);
                        $('#inserimentoMedici1').prop("checked", true);
                        $('#modificaMedici1').prop("checked", false);
                        $('#cancellazioneMedici1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 11) {

                        $('#letturaMedici1').prop("checked", true);
                        $('#inserimentoMedici1').prop("checked", true);
                        $('#modificaMedici1').prop("checked", false);
                        $('#cancellazioneMedici1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 12) {

                        $('#letturaMedici1').prop("checked", false);
                        $('#inserimentoMedici1').prop("checked", false);
                        $('#modificaMedici1').prop("checked", true);
                        $('#cancellazioneMedici1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 13) {

                        $('#letturaMedici1').prop("checked", true);
                        $('#inserimentoMedici1').prop("checked", false);
                        $('#modificaMedici1').prop("checked", true);
                        $('#cancellazioneMedici1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 14) {

                        $('#letturaMedici1').prop("checked", false);
                        $('#inserimentoMedici1').prop("checked", true);
                        $('#modificaMedici1').prop("checked", true);
                        $('#cancellazioneMedici1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 15) {

                        $('#letturaMedici1').prop("checked", true);
                        $('#inserimentoMedici1').prop("checked", true);
                        $('#modificaMedici1').prop("checked", true);
                        $('#cancellazioneMedici1').prop("checked", true);

                    }

                }
                if (arrayPermessi[i].sezione === 'allegati') {

                    if (arrayPermessi[i].permessi === 1) {

                        $('#letturaAllegati1').prop("checked", true);
                        $('#inserimentoAllegati1').prop("checked", false);
                        $('#modificaAllegati1').prop("checked", false);
                        $('#cancellazioneAllegati1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 2) {

                        $('#letturaAllegati1').prop("checked", false);
                        $('#inserimentoAllegati1').prop("checked", true);
                        $('#modificaAllegati1').prop("checked", false);
                        $('#cancellazioneAllegati1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 3) {

                        $('#letturaAllegati1').prop("checked", true);
                        $('#inserimentoAllegati1').prop("checked", true);
                        $('#modificaAllegati1').prop("checked", false);
                        $('#cancellazioneAllegati1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 4) {

                        $('#letturaAllegati1').prop("checked", false);
                        $('#inserimentoAllegati1').prop("checked", false);
                        $('#modificaAllegati1').prop("checked", true);
                        $('#cancellazioneAllegati1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 5) {

                        $('#letturaAllegati1').prop("checked", true);
                        $('#inserimentoAllegati1').prop("checked", false);
                        $('#modificaAllegati1').prop("checked", true);
                        $('#cancellazioneAllegati1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 6) {

                        $('#letturaAllegati1').prop("checked", false);
                        $('#inserimentoAllegati1').prop("checked", true);
                        $('#modificaAllegati1').prop("checked", true);
                        $('#cancellazioneAllegati1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 7) {

                        $('#letturaAllegati1').prop("checked", true);
                        $('#inserimentoAllegati1').prop("checked", true);
                        $('#modificaAllegati1').prop("checked", true);
                        $('#cancellazioneAllegati1').prop("checked", false);

                    } else if (arrayPermessi[i].permessi === 8) {

                        $('#letturaAllegati1').prop("checked", false);
                        $('#inserimentoAllegati1').prop("checked", false);
                        $('#modificaAllegati1').prop("checked", false);
                        $('#cancellazioneAllegati1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 9) {

                        $('#letturaAllegati1').prop("checked", true);
                        $('#inserimentoAllegati1').prop("checked", false);
                        $('#modificaAllegati1').prop("checked", false);
                        $('#cancellazioneAllegati1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 10) {

                        $('#letturaAllegati1').prop("checked", false);
                        $('#inserimentoAllegati1').prop("checked", true);
                        $('#modificaAllegati1').prop("checked", false);
                        $('#cancellazioneAllegati1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 11) {

                        $('#letturaAllegati1').prop("checked", true);
                        $('#inserimentoAllegati1').prop("checked", true);
                        $('#modificaAllegati1').prop("checked", false);
                        $('#cancellazioneAllegati1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 12) {

                        $('#letturaAllegati1').prop("checked", false);
                        $('#inserimentoAllegati1').prop("checked", false);
                        $('#modificaAllegati1').prop("checked", true);
                        $('#cancellazioneAllegati1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 13) {

                        $('#letturaAllegati1').prop("checked", true);
                        $('#inserimentoAllegati1').prop("checked", false);
                        $('#modificaAllegati1').prop("checked", true);
                        $('#cancellazioneAllegati1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 14) {

                        $('#letturaAllegati1').prop("checked", false);
                        $('#inserimentoAllegati1').prop("checked", true);
                        $('#modificaAllegati1').prop("checked", true);
                        $('#cancellazioneAllegati1').prop("checked", true);

                    } else if (arrayPermessi[i].permessi === 15) {

                        $('#letturaAllegati1').prop("checked", true);
                        $('#inserimentoAllegati1').prop("checked", true);
                        $('#modificaAllegati1').prop("checked", true);
                        $('#cancellazioneAllegati1').prop("checked", true);

                    }


                }
            }


        }

        function openModalInUsers() {

        }

        function openModalUpUsers() {

            var ids1 = $.map(tabUtenti.rows('.selected').data(), function (item) {
                return item;
            });
            arrayUtenti = ids1;

            $('#idUser').val(arrayUtenti[0].id);
            $('#cognomeUser').val(arrayUtenti[0].lastname);
            $('#nomeUser').val(arrayUtenti[0].firstname);
            $('#usernameUser').val(arrayUtenti[0].username);
            $('#emailUser').val(arrayUtenti[0].email);
            $('#attivoUser').prop('checked', arrayUtenti[0].attivo);
            $('#profiloUser').val(arrayUtenti[0].profilo);
            $('#dataScadenzaUser').val(moment(arrayUtenti[0].scadenzaUtenza).subtract(10, 'days').calendar());


        }

        $('#utenteForm').on('submit', function () {

            var arrayUpdate = {};

            arrayUpdate.id = arrayUtenti[0].id;
            arrayUpdate.primaryKey = arrayUtenti[0].primaryKey;
            arrayUpdate.lastname = $('#cognomeUser').val();
            arrayUpdate.firstname = $('#nomeUser').val();
            arrayUpdate.username = $('#usernameUser').val();
            arrayUpdate.email = $('#emailUser').val();
            arrayUpdate.attivo = $('#attivoUser').prop("checked");
            arrayUpdate.profilo = $('#profiloUser').val();
            arrayUpdate.scadenzaUtenza = moment($('#dataScadenzaUser').val()).format();
            arrayUpdate.password = $('#passwordUser').val();
            arrayUpdate.proprietario = arrayUtenti[0].proprietario;
            arrayUpdate.image = arrayUtenti[0].image;
            arrayUpdate.permessi = arrayUtenti[0].permessi;
            arrayUpdate.menu = arrayUtenti[0].menu;
            arrayUpdate.idAnagrafica = arrayUtenti[0].idAnagrafica;
            arrayUpdate.createUser = arrayUtenti[0].createUser;
            arrayUpdate.createDate = arrayUtenti[0].createDate;

            var url_string = document.URL;

            var url = new URL(url_string);
            var access_token = url.searchParams.get("authToken");

            $.ajax({
                url: '../rest/users/' + arrayUpdate.id,
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': "Bearer " + access_token
                },
                dataType: "json",
                data: JSON.stringify(arrayUpdate),
                success: function (response) {
                    if (response.esito === true) {
                        $('#updateUsers').hide();
                        $('.modal-backdrop').remove();
                        tabUtenti.ajax.reload();
                        document.getElementById('alertSuccUp').style.display = 'block';
                        $('#idUser').val('');
                        $('#cognomeUser').val('');
                        $('#nomeUser').val('');
                        $('#usernameUser').val('');
                        $('#emailUser').val('');
                        $('#attivoUser').prop('checked', false);
                        $('#profiloUser').val('');
                        $('#dataScadenzaUser').val('');
                        $('#passwordUser').val('');
                        $('#passwordVerUser').val('');
                        $('#modificaUtente').prop('disabled', true);
                    }
                },
                failure: function (response) {
                    if (response.status === 401 || response.status === 400 || response.status === 500) {
                        $('#updateUsers').hide();
                        $('.modal-backdrop').remove();
                        tabUtenti.ajax.reload();
                        document.getElementById('alertErrUp').style.display = 'block';
                        $('#modificaUtente').prop('disabled', true);
                    }
                }
            });

            return false;

        });

        $('#utenteFormIns').on('submit', function () {

            var arrayInsert = {};

            arrayInsert.lastname = $('#cognomeUser1').val();
            arrayInsert.firstname = $('#nomeUser1').val();
            arrayInsert.username = $('#usernameUser1').val();
            arrayInsert.email = $('#emailUser1').val();
            arrayInsert.attivo = $('#attivoUser1').prop("checked");
            arrayInsert.profilo = $('#profiloUser1').val();
            arrayInsert.scadenzaUtenza = moment($('#dataScadenzaUser1').val()).format();
            arrayInsert.password = $('#passwordUser1').val();


            console.log(arrayInsert);

            var url_string = document.URL;

            var url = new URL(url_string);
            var access_token = url.searchParams.get("authToken");

            $.ajax({
                url: '../rest/users',
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': "Bearer " + access_token
                },
                dataType: "json",
                data: JSON.stringify(arrayInsert),
                success: function (response) {
                    if (response.esito === true) {
                        $('#insertUsers').hide();
                        $('.modal-backdrop').remove();
                        tabUtenti.ajax.reload();
                        document.getElementById('alertSuccIn').style.display = 'block';
                        arrayInsert.lastname = $('#cognomeUser1').val();
                        $('#nomeUser1').val('');
                        $('#usernameUser1').val('');
                        $('#emailUser1').val('');
                        $('#attivoUser1').prop("checked", false);
                        $('#profiloUser1').val('');
                        $('#dataScadenzaUser1').val('');
                        $('#passwordUser1').val('');
                        $('#passwordVerUser1').val('');
                    }
                },
                failure: function (response) {
                    if (response.status === 401 || response.status === 400 || response.status === 500) {
                        $('#insertUsers').hide();
                        $('.modal-backdrop').remove();
                        tabUtenti.ajax.reload();
                        document.getElementById('alertErrIn').style.display = 'block';
                    }
                }
            });

            return false;

        });

        function changeSezione() {

            if ($('#sezione').val() === 'menu') {
                document.getElementById('tabsMenu').style.display = 'block';
                document.getElementById('tabsSezioni').style.display = 'none';
                document.getElementById('tabsUtenti').style.display = 'none';
                document.getElementById('tabsAnagrafica').style.display = 'none';
                document.getElementById('tabsGruppi').style.display = 'none';
                document.getElementById('tabsDocumenti').style.display = 'none';
                document.getElementById('tabsMedici').style.display = 'none';
                document.getElementById('tabsAllegati').style.display = 'none';
            } else if ($('#sezione').val() === 'sezioni') {
                document.getElementById('tabsMenu').style.display = 'none';
                document.getElementById('tabsSezioni').style.display = 'block';
                document.getElementById('tabsUtenti').style.display = 'none';
                document.getElementById('tabsAnagrafica').style.display = 'none';
                document.getElementById('tabsGruppi').style.display = 'none';
                document.getElementById('tabsDocumenti').style.display = 'none';
                document.getElementById('tabsMedici').style.display = 'none';
                document.getElementById('tabsAllegati').style.display = 'none';
            } else if ($('#sezione').val() === 'utenti') {
                document.getElementById('tabsMenu').style.display = 'none';
                document.getElementById('tabsSezioni').style.display = 'none';
                document.getElementById('tabsUtenti').style.display = 'block';
                document.getElementById('tabsAnagrafica').style.display = 'none';
                document.getElementById('tabsGruppi').style.display = 'none';
                document.getElementById('tabsDocumenti').style.display = 'none';
                document.getElementById('tabsMedici').style.display = 'none';
                document.getElementById('tabsAllegati').style.display = 'none';
            } else if ($('#sezione').val() === 'anagrafica') {
                document.getElementById('tabsMenu').style.display = 'none';
                document.getElementById('tabsSezioni').style.display = 'none';
                document.getElementById('tabsUtenti').style.display = 'none';
                document.getElementById('tabsAnagrafica').style.display = 'block';
                document.getElementById('tabsGruppi').style.display = 'none';
                document.getElementById('tabsDocumenti').style.display = 'none';
                document.getElementById('tabsMedici').style.display = 'none';
                document.getElementById('tabsAllegati').style.display = 'none';
            } else if ($('#sezione').val() === 'gruppi') {
                document.getElementById('tabsMenu').style.display = 'none';
                document.getElementById('tabsSezioni').style.display = 'none';
                document.getElementById('tabsUtenti').style.display = 'none';
                document.getElementById('tabsAnagrafica').style.display = 'none';
                document.getElementById('tabsGruppi').style.display = 'block';
                document.getElementById('tabsDocumenti').style.display = 'none';
                document.getElementById('tabsMedici').style.display = 'none';
                document.getElementById('tabsAllegati').style.display = 'none';
            } else if ($('#sezione').val() === 'documenti') {
                document.getElementById('tabsMenu').style.display = 'none';
                document.getElementById('tabsSezioni').style.display = 'none';
                document.getElementById('tabsUtenti').style.display = 'none';
                document.getElementById('tabsAnagrafica').style.display = 'none';
                document.getElementById('tabsGruppi').style.display = 'none';
                document.getElementById('tabsDocumenti').style.display = 'block';
                document.getElementById('tabsMedici').style.display = 'none';
                document.getElementById('tabsAllegati').style.display = 'none';
            } else if ($('#sezione').val() === 'medici') {
                document.getElementById('tabsMenu').style.display = 'none';
                document.getElementById('tabsSezioni').style.display = 'none';
                document.getElementById('tabsUtenti').style.display = 'none';
                document.getElementById('tabsAnagrafica').style.display = 'none';
                document.getElementById('tabsGruppi').style.display = 'none';
                document.getElementById('tabsDocumenti').style.display = 'none';
                document.getElementById('tabsMedici').style.display = 'block';
                document.getElementById('tabsAllegati').style.display = 'none';
            } else if ($('#sezione').val() === 'allegati') {
                document.getElementById('tabsMenu').style.display = 'none';
                document.getElementById('tabsSezioni').style.display = 'none';
                document.getElementById('tabsUtenti').style.display = 'none';
                document.getElementById('tabsAnagrafica').style.display = 'none';
                document.getElementById('tabsGruppi').style.display = 'none';
                document.getElementById('tabsDocumenti').style.display = 'none';
                document.getElementById('tabsMedici').style.display = 'none';
                document.getElementById('tabsAllegati').style.display = 'block';
            } else if ($('#sezione').val() === '') {
                document.getElementById('tabsMenu').style.display = 'none';
                document.getElementById('tabsSezioni').style.display = 'none';
                document.getElementById('tabsUtenti').style.display = 'none';
                document.getElementById('tabsAnagrafica').style.display = 'none';
                document.getElementById('tabsGruppi').style.display = 'none';
                document.getElementById('tabsDocumenti').style.display = 'none';
                document.getElementById('tabsMedici').style.display = 'none';
                document.getElementById('tabsAllegati').style.display = 'none';
            }

        }

        function changeSezione1() {

            if ($('#sezione1').val() === 'menu') {
                document.getElementById('tabsMenu1').style.display = 'block';
                document.getElementById('tabsSezioni1').style.display = 'none';
                document.getElementById('tabsUtenti1').style.display = 'none';
                document.getElementById('tabsAnagrafica1').style.display = 'none';
                document.getElementById('tabsGruppi1').style.display = 'none';
                document.getElementById('tabsDocumenti1').style.display = 'none';
                document.getElementById('tabsMedici1').style.display = 'none';
                document.getElementById('tabsAllegati1').style.display = 'none';
            } else if ($('#sezione1').val() === 'sezioni') {
                document.getElementById('tabsMenu1').style.display = 'none';
                document.getElementById('tabsSezioni1').style.display = 'block';
                document.getElementById('tabsUtenti1').style.display = 'none';
                document.getElementById('tabsAnagrafica1').style.display = 'none';
                document.getElementById('tabsGruppi1').style.display = 'none';
                document.getElementById('tabsDocumenti1').style.display = 'none';
                document.getElementById('tabsMedici1').style.display = 'none';
                document.getElementById('tabsAllegati1').style.display = 'none';
            } else if ($('#sezione1').val() === 'utenti') {
                document.getElementById('tabsMenu1').style.display = 'none';
                document.getElementById('tabsSezioni1').style.display = 'none';
                document.getElementById('tabsUtenti1').style.display = 'block';
                document.getElementById('tabsAnagrafica1').style.display = 'none';
                document.getElementById('tabsGruppi1').style.display = 'none';
                document.getElementById('tabsDocumenti1').style.display = 'none';
                document.getElementById('tabsMedici1').style.display = 'none';
                document.getElementById('tabsAllegati1').style.display = 'none';
            } else if ($('#sezione1').val() === 'anagrafica') {
                document.getElementById('tabsMenu1').style.display = 'none';
                document.getElementById('tabsSezioni1').style.display = 'none';
                document.getElementById('tabsUtenti1').style.display = 'none';
                document.getElementById('tabsAnagrafica1').style.display = 'block';
                document.getElementById('tabsGruppi1').style.display = 'none';
                document.getElementById('tabsDocumenti1').style.display = 'none';
                document.getElementById('tabsMedici1').style.display = 'none';
                document.getElementById('tabsAllegati1').style.display = 'none';
            } else if ($('#sezione1').val() === 'gruppi') {
                document.getElementById('tabsMenu1').style.display = 'none';
                document.getElementById('tabsSezioni1').style.display = 'none';
                document.getElementById('tabsUtenti1').style.display = 'none';
                document.getElementById('tabsAnagrafica1').style.display = 'none';
                document.getElementById('tabsGruppi1').style.display = 'block';
                document.getElementById('tabsDocumenti1').style.display = 'none';
                document.getElementById('tabsMedici1').style.display = 'none';
                document.getElementById('tabsAllegati1').style.display = 'none';
            } else if ($('#sezione1').val() === 'documenti') {
                document.getElementById('tabsMenu1').style.display = 'none';
                document.getElementById('tabsSezioni1').style.display = 'none';
                document.getElementById('tabsUtenti1').style.display = 'none';
                document.getElementById('tabsAnagrafica1').style.display = 'none';
                document.getElementById('tabsGruppi1').style.display = 'none';
                document.getElementById('tabsDocumenti1').style.display = 'block';
                document.getElementById('tabsMedici1').style.display = 'none';
                document.getElementById('tabsAllegati1').style.display = 'none';
            } else if ($('#sezione1').val() === 'medici') {
                document.getElementById('tabsMenu1').style.display = 'none';
                document.getElementById('tabsSezioni1').style.display = 'none';
                document.getElementById('tabsUtenti1').style.display = 'none';
                document.getElementById('tabsAnagrafica1').style.display = 'none';
                document.getElementById('tabsGruppi1').style.display = 'none';
                document.getElementById('tabsDocumenti1').style.display = 'none';
                document.getElementById('tabsMedici1').style.display = 'block';
                document.getElementById('tabsAllegati1').style.display = 'none';
            } else if ($('#sezione1').val() === 'allegati') {
                document.getElementById('tabsMenu1').style.display = 'none';
                document.getElementById('tabsSezioni1').style.display = 'none';
                document.getElementById('tabsUtenti1').style.display = 'none';
                document.getElementById('tabsAnagrafica1').style.display = 'none';
                document.getElementById('tabsGruppi1').style.display = 'none';
                document.getElementById('tabsDocumenti1').style.display = 'none';
                document.getElementById('tabsMedici1').style.display = 'none';
                document.getElementById('tabsAllegati1').style.display = 'block';
            } else if ($('#sezione1').val() === '') {
                document.getElementById('tabsMenu1').style.display = 'none';
                document.getElementById('tabsSezioni1').style.display = 'none';
                document.getElementById('tabsUtenti1').style.display = 'none';
                document.getElementById('tabsAnagrafica1').style.display = 'none';
                document.getElementById('tabsGruppi1').style.display = 'none';
                document.getElementById('tabsDocumenti1').style.display = 'none';
                document.getElementById('tabsMedici1').style.display = 'none';
                document.getElementById('tabsAllegati1').style.display = 'none';
            }

        }

        $('#aggiungiGruppo').on('submit', function () {

            var arrayInsert = {};

            arrayInsert.nome = $('#nomeGruppo').val();
            arrayInsert.descrizione = $('#descrizioneGruppo').val();
            arrayInsert.menu = $('#menu').val();

            for (var i = 0; i < arrayInsert.menu.length; i++) {
                var value = arrayInsert.menu[i];
                var valueJson = JSON.parse(value);
                arrayInsert.menu[i] = valueJson;
            }

            arrayInsert.permessi = [];

            var sommaMenu = 0;
            var sommaSezioni = 0;
            var sommaUtenti = 0;
            var sommaAnagrafica = 0;
            var sommaGruppi = 0;
            var sommaDocumenti = 0;
            var sommaMedici = 0;
            var sommaAllegati = 0;
            var letturaMenu = 0;
            var inserimentoMenu = 0;
            var modificaMenu = 0;
            var cancellazioneMenu = 0;
            var letturaSezioni = 0;
            var inserimentoSezioni = 0;
            var modificaSezioni = 0;
            var cancellazioneSezioni = 0;
            var letturaUtenti = 0;
            var inserimentoUtenti = 0;
            var modificaUtenti = 0;
            var cancellazioneUtenti = 0;
            var letturaAnagrafica = 0;
            var inserimentoAnagrafica = 0;
            var modificaAnagrafica = 0;
            var cancellazioneAnagrafica = 0;
            var letturaGruppi = 0;
            var inserimentoGruppi = 0;
            var modificaGruppi = 0;
            var cancellazioneGruppi = 0;
            var letturaDocumenti = 0;
            var inserimentoDocumenti = 0;
            var modificaDocumenti = 0;
            var cancellazioneDocumenti = 0;
            var letturaMedici = 0;
            var inserimentoMedici = 0;
            var modificaMedici = 0;
            var cancellazioneMedici = 0;
            var letturaAllegati = 0;
            var inserimentoAllegati = 0;
            var modificaAllegati = 0;
            var cancellazioneAllegati = 0;

            if ($('#letturaMenu').prop("checked") === true) {
                letturaMenu = 1;
            }

            if ($('#inserimentoMenu').prop("checked") === true) {
                inserimentoMenu = 2;
            }

            if ($('#modificaMenu').prop("checked") === true) {
                modificaMenu = 4;
            }

            if ($('#cancellazioneMenu').prop("checked") === true) {
                cancellazioneMenu = 8;
            }

            sommaMenu = letturaMenu + inserimentoMenu + modificaMenu + cancellazioneMenu;

            if ($('#letturaSezioni').prop("checked") === true) {
                letturaSezioni = 1;
            }

            if ($('#inserimentoSezioni').prop("checked") === true) {
                inserimentoSezioni = 2;
            }

            if ($('#modificaSezioni').prop("checked") === true) {
                modificaSezioni = 4;
            }

            if ($('#cancellazioneSezioni').prop("checked") === true) {
                cancellazioneSezioni = 8;
            }

            sommaSezioni = letturaSezioni + inserimentoSezioni + modificaSezioni + cancellazioneSezioni;

            if ($('#letturaUtenti').prop("checked") === true) {
                letturaUtenti = 1;
            }

            if ($('#inserimentoUtenti').prop("checked") === true) {
                inserimentoUtenti = 2;
            }

            if ($('#modificaUtenti').prop("checked") === true) {
                modificaUtenti = 4;
            }

            if ($('#cancellazioneUtenti').prop("checked") === true) {
                cancellazioneUtenti = 8;
            }

            sommaUtenti = letturaUtenti + inserimentoUtenti + modificaUtenti + cancellazioneUtenti;

            if ($('#letturaAnagrafica').prop("checked") === true) {
                letturaAnagrafica = 1;
            }

            if ($('#inserimentoAnagrafica').prop("checked") === true) {
                inserimentoAnagrafica = 2;
            }

            if ($('#modificaAnagrafica').prop("checked") === true) {
                modificaAnagrafica = 4;
            }

            if ($('#cancellazioneAnagrafica').prop("checked") === true) {
                cancellazioneAnagrafica = 8;
            }

            sommaAnagrafica = letturaAnagrafica + inserimentoAnagrafica + modificaAnagrafica + cancellazioneAnagrafica;

            if ($('#letturaGruppi').prop("checked") === true) {
                letturaGruppi = 1;
            }

            if ($('#inserimentoGruppi').prop("checked") === true) {
                inserimentoGruppi = 2;
            }

            if ($('#modificaGruppi').prop("checked") === true) {
                modificaGruppi = 4;
            }

            if ($('#cancellazioneGruppi').prop("checked") === true) {
                cancellazioneGruppi = 8;
            }

            sommaGruppi = letturaGruppi + inserimentoGruppi + modificaGruppi + cancellazioneGruppi;

            if ($('#letturaDocumenti').prop("checked") === true) {
                letturaDocumenti = 1;
            }

            if ($('#inserimentoDocumenti').prop("checked") === true) {
                inserimentoDocumenti = 2;
            }

            if ($('#modificaDocumenti').prop("checked") === true) {
                modificaDocumenti = 4;
            }

            if ($('#cancellazioneDocumenti').prop("checked") === true) {
                cancellazioneDocumenti = 8;
            }

            sommaDocumenti = letturaDocumenti + inserimentoDocumenti + modificaDocumenti + cancellazioneDocumenti;

            if ($('#letturaMedici').prop("checked") === true) {
                letturaMedici = 1;
            }

            if ($('#inserimentoMedici').prop("checked") === true) {
                inserimentoMedici = 2;
            }

            if ($('#modificaMedici').prop("checked") === true) {
                modificaMedici = 4;
            }

            if ($('#cancellazioneMedici').prop("checked") === true) {
                cancellazioneMedici = 8;
            }

            sommaMedici = letturaMedici + inserimentoMedici + modificaMedici + cancellazioneMedici;

            if ($('#letturaAllegati').prop("checked") === true) {
                letturaAllegati = 1;
            }

            if ($('#inserimentoAllegati').prop("checked") === true) {
                inserimentoAllegati = 2;
            }

            if ($('#modificaAllegati').prop("checked") === true) {
                modificaAllegati = 4;
            }

            if ($('#cancellazioneAllegati').prop("checked") === true) {
                cancellazioneAllegati = 8;
            }

            sommaAllegati = letturaAllegati + inserimentoAllegati + modificaAllegati + cancellazioneAllegati;

            if (sommaMenu > 0) {

                arrayInsert.permessi.push({"sezione": "menu", "permessi": sommaMenu, "dettagli": []});

            }
            if (sommaSezioni > 0) {

                arrayInsert.permessi.push({"sezione": "sezioni", "permessi": sommaSezioni, "dettagli": []});

            }
            if (sommaUtenti > 0) {

                arrayInsert.permessi.push({"sezione": "utenti", "permessi": sommaUtenti, "dettagli": []});

            }
            if (sommaAnagrafica > 0) {

                arrayInsert.permessi.push({"sezione": "anagrafica", "permessi": sommaAnagrafica, "dettagli": []});

            }
            if (sommaGruppi > 0) {

                arrayInsert.permessi.push({"sezione": "gruppi", "permessi": sommaGruppi, "dettagli": []});

            }
            if (sommaDocumenti > 0) {

                arrayInsert.permessi.push({"sezione": "documenti", "permessi": sommaDocumenti, "dettagli": []});

            }
            if (sommaMedici > 0) {

                arrayInsert.permessi.push({"sezione": "medici", "permessi": sommaMedici, "dettagli": []});

            }
            if (sommaAllegati > 0) {

                arrayInsert.permessi.push({"sezione": "allegati", "permessi": sommaMedici, "dettagli": []});

            }

            var url_string = document.URL;

            var url = new URL(url_string);
            var access_token = url.searchParams.get("authToken");

            arrayInsert.permessi = JSON.stringify(arrayInsert.permessi);
            arrayInsert.menu = JSON.stringify(arrayInsert.menu);

            $.ajax({
                url: '../rest/users/gruppi',
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': "Bearer " + access_token
                },
                dataType: "json",
                data: JSON.stringify(arrayInsert),
                success: function (response) {
                    if (response.esito === true) {
                        $('#addGroup').hide();
                        $('.modal-backdrop').remove();
                        tabGruppi.ajax.reload();
                        document.getElementById('alertSuccInGp').style.display = 'block';
                        document.getElementById('tabsMenu').style.display = 'none';
                        $('#letturaMenu').prop("checked", false);
                        $('#inserimentoMenu').prop("checked", false);
                        $('#modificaMenu').prop("checked", false);
                        $('#cancellazioneMenu').prop("checked", false);
                        document.getElementById('tabsSezioni').style.display = 'none';
                        $('#letturaSezioni').prop("checked", false);
                        $('#inserimentoSezioni').prop("checked", false);
                        $('#modificaSezioni').prop("checked", false);
                        $('#cancellazioneSezioni').prop("checked", false);
                        document.getElementById('tabsUtenti').style.display = 'none';
                        $('#letturaUtenti').prop("checked", false);
                        $('#inserimentoUtenti').prop("checked", false);
                        $('#modificaUtenti').prop("checked", false);
                        $('#cancellazioneUtenti').prop("checked", false);
                        document.getElementById('tabsAnagrafica').style.display = 'none';
                        $('#letturaAnagrafica').prop("checked", false);
                        $('#inserimentoAnagrafica').prop("checked", false);
                        $('#modificaAnagrafica').prop("checked", false);
                        $('#cancellazioneAnagrafica').prop("checked", false);
                        document.getElementById('tabsGruppi').style.display = 'none';
                        $('#letturaGruppi').prop("checked", false);
                        $('#inserimentoGruppi').prop("checked", false);
                        $('#modificaGruppi').prop("checked", false);
                        $('#cancellazioneGruppi').prop("checked", false);
                        document.getElementById('tabsDocumenti').style.display = 'none';
                        $('#letturaDocumenti').prop("checked", false);
                        $('#inserimentoDocumenti').prop("checked", false);
                        $('#modificaDocumenti').prop("checked", false);
                        $('#cancellazioneDocumenti').prop("checked", false);
                        document.getElementById('tabsMedici').style.display = 'none';
                        $('#letturaMedici').prop("checked", false);
                        $('#inserimentoMedici').prop("checked", false);
                        $('#modificaMedici').prop("checked", false);
                        $('#cancellazioneMedici').prop("checked", false);
                        document.getElementById('tabsAllegati').style.display = 'none';
                        $('#letturaAllegati').prop("checked", false);
                        $('#inserimentoAllegati').prop("checked", false);
                        $('#modificaAllegati').prop("checked", false);
                        $('#cancellazioneAllegati').prop("checked", false);
                    }
                },
                failure: function (response) {
                    if (response.status === 401 || response.status === 400 || response.status === 500) {
                        $('#addGroup').hide();
                        $('.modal-backdrop').remove();
                        tabGruppi.ajax.reload();
                        document.getElementById('alertErrInGp').style.display = 'block';
                        document.getElementById('tabsMenu').style.display = 'none';
                        $('#letturaMenu').prop("checked", false);
                        $('#inserimentoMenu').prop("checked", false);
                        $('#modificaMenu').prop("checked", false);
                        $('#cancellazioneMenu').prop("checked", false);
                        document.getElementById('tabsSezioni').style.display = 'none';
                        $('#letturaSezioni').prop("checked", false);
                        $('#inserimentoSezioni').prop("checked", false);
                        $('#modificaSezioni').prop("checked", false);
                        $('#cancellazioneSezioni').prop("checked", false);
                        document.getElementById('tabsUtenti').style.display = 'none';
                        $('#letturaUtenti').prop("checked", false);
                        $('#inserimentoUtenti').prop("checked", false);
                        $('#modificaUtenti').prop("checked", false);
                        $('#cancellazioneUtenti').prop("checked", false);
                        document.getElementById('tabsAnagrafica').style.display = 'none';
                        $('#letturaAnagrafica').prop("checked", false);
                        $('#inserimentoAnagrafica').prop("checked", false);
                        $('#modificaAnagrafica').prop("checked", false);
                        $('#cancellazioneAnagrafica').prop("checked", false);
                        document.getElementById('tabsGruppi').style.display = 'none';
                        $('#letturaGruppi').prop("checked", false);
                        $('#inserimentoGruppi').prop("checked", false);
                        $('#modificaGruppi').prop("checked", false);
                        $('#cancellazioneGruppi').prop("checked", false);
                        document.getElementById('tabsDocumenti').style.display = 'none';
                        $('#letturaDocumenti').prop("checked", false);
                        $('#inserimentoDocumenti').prop("checked", false);
                        $('#modificaDocumenti').prop("checked", false);
                        $('#cancellazioneDocumenti').prop("checked", false);
                        document.getElementById('tabsMedici').style.display = 'none';
                        $('#letturaMedici').prop("checked", false);
                        $('#inserimentoMedici').prop("checked", false);
                        $('#modificaMedici').prop("checked", false);
                        $('#cancellazioneMedici').prop("checked", false);
                        document.getElementById('tabsAllegati').style.display = 'none';
                        $('#letturaAllegati').prop("checked", false);
                        $('#inserimentoAllegati').prop("checked", false);
                        $('#modificaAllegati').prop("checked", false);
                        $('#cancellazioneAllegati').prop("checked", false);
                    }
                }
            });

            return false;

        });

        $('#updateGruppo').on('submit', function () {

            var arrayInsert = {};

            arrayInsert.nome = $('#nomeGruppo1').val();
            arrayInsert.descrizione = $('#descrizioneGruppo1').val();
            arrayInsert.menu = $('#menu1').val();

            for (var i = 0; i < arrayInsert.menu.length; i++) {
                var value = arrayInsert.menu[i];
                var valueJson = JSON.parse(value);
                arrayInsert.menu[i] = valueJson;
            }

            arrayInsert.permessi = [];

            var sommaMenu = 0;
            var sommaSezioni = 0;
            var sommaUtenti = 0;
            var sommaAnagrafica = 0;
            var sommaGruppi = 0;
            var sommaDocumenti = 0;
            var sommaMedici = 0;
            var sommaAllegati = 0;
            var letturaMenu = 0;
            var inserimentoMenu = 0;
            var modificaMenu = 0;
            var cancellazioneMenu = 0;
            var letturaSezioni = 0;
            var inserimentoSezioni = 0;
            var modificaSezioni = 0;
            var cancellazioneSezioni = 0;
            var letturaUtenti = 0;
            var inserimentoUtenti = 0;
            var modificaUtenti = 0;
            var cancellazioneUtenti = 0;
            var letturaAnagrafica = 0;
            var inserimentoAnagrafica = 0;
            var modificaAnagrafica = 0;
            var cancellazioneAnagrafica = 0;
            var letturaGruppi = 0;
            var inserimentoGruppi = 0;
            var modificaGruppi = 0;
            var cancellazioneGruppi = 0;
            var letturaDocumenti = 0;
            var inserimentoDocumenti = 0;
            var modificaDocumenti = 0;
            var cancellazioneDocumenti = 0;
            var letturaMedici = 0;
            var inserimentoMedici = 0;
            var modificaMedici = 0;
            var cancellazioneMedici = 0;
            var letturaAllegati = 0;
            var inserimentoAllegati = 0;
            var modificaAllegati = 0;
            var cancellazioneAllegati = 0;

            if ($('#letturaMenu1').prop("checked") === true) {
                letturaMenu = 1;
            }

            if ($('#inserimentoMenu1').prop("checked") === true) {
                inserimentoMenu = 2;
            }

            if ($('#modificaMenu1').prop("checked") === true) {
                modificaMenu = 4;
            }

            if ($('#cancellazioneMenu1').prop("checked") === true) {
                cancellazioneMenu = 8;
            }

            sommaMenu = letturaMenu + inserimentoMenu + modificaMenu + cancellazioneMenu;

            if ($('#letturaSezioni1').prop("checked") === true) {
                letturaSezioni = 1;
            }

            if ($('#inserimentoSezioni1').prop("checked") === true) {
                inserimentoSezioni = 2;
            }

            if ($('#modificaSezioni1').prop("checked") === true) {
                modificaSezioni = 4;
            }

            if ($('#cancellazioneSezioni1').prop("checked") === true) {
                cancellazioneSezioni = 8;
            }

            sommaSezioni = letturaSezioni + inserimentoSezioni + modificaSezioni + cancellazioneSezioni;

            if ($('#letturaUtenti1').prop("checked") === true) {
                letturaUtenti = 1;
            }

            if ($('#inserimentoUtenti1').prop("checked") === true) {
                inserimentoUtenti = 2;
            }

            if ($('#modificaUtenti1').prop("checked") === true) {
                modificaUtenti = 4;
            }

            if ($('#cancellazioneUtenti1').prop("checked") === true) {
                cancellazioneUtenti = 8;
            }

            sommaUtenti = letturaUtenti + inserimentoUtenti + modificaUtenti + cancellazioneUtenti;

            if ($('#letturaAnagrafica1').prop("checked") === true) {
                letturaAnagrafica = 1;
            }

            if ($('#inserimentoAnagrafica1').prop("checked") === true) {
                inserimentoAnagrafica = 2;
            }

            if ($('#modificaAnagrafica1').prop("checked") === true) {
                modificaAnagrafica = 4;
            }

            if ($('#cancellazioneAnagrafica1').prop("checked") === true) {
                cancellazioneAnagrafica = 8;
            }

            sommaAnagrafica = letturaAnagrafica + inserimentoAnagrafica + modificaAnagrafica + cancellazioneAnagrafica;

            if ($('#letturaGruppi1').prop("checked") === true) {
                letturaGruppi = 1;
            }

            if ($('#inserimentoGruppi1').prop("checked") === true) {
                inserimentoGruppi = 2;
            }

            if ($('#modificaGruppi1').prop("checked") === true) {
                modificaGruppi = 4;
            }

            if ($('#cancellazioneGruppi1').prop("checked") === true) {
                cancellazioneGruppi = 8;
            }

            sommaGruppi = letturaGruppi + inserimentoGruppi + modificaGruppi + cancellazioneGruppi;

            if ($('#letturaDocumenti1').prop("checked") === true) {
                letturaDocumenti = 1;
            }

            if ($('#inserimentoDocumenti1').prop("checked") === true) {
                inserimentoDocumenti = 2;
            }

            if ($('#modificaDocumenti1').prop("checked") === true) {
                modificaDocumenti = 4;
            }

            if ($('#cancellazioneDocumenti1').prop("checked") === true) {
                cancellazioneDocumenti = 8;
            }

            sommaDocumenti = letturaDocumenti + inserimentoDocumenti + modificaDocumenti + cancellazioneDocumenti;

            if ($('#letturaMedici1').prop("checked") === true) {
                letturaMedici = 1;
            }

            if ($('#inserimentoMedici1').prop("checked") === true) {
                inserimentoMedici = 2;
            }

            if ($('#modificaMedici1').prop("checked") === true) {
                modificaMedici = 4;
            }

            if ($('#cancellazioneMedici1').prop("checked") === true) {
                cancellazioneMedici = 8;
            }

            sommaMedici = letturaMedici + inserimentoMedici + modificaMedici + cancellazioneMedici;

            if ($('#letturaAllegati1').prop("checked") === true) {
                letturaAllegati = 1;
            }

            if ($('#inserimentoAllegati1').prop("checked") === true) {
                inserimentoAllegati = 2;
            }

            if ($('#modificaAllegati1').prop("checked") === true) {
                modificaAllegati = 4;
            }

            if ($('#cancellazioneAllegati1').prop("checked") === true) {
                cancellazioneAllegati = 8;
            }

            sommaAllegati = letturaAllegati + inserimentoAllegati + modificaAllegati + cancellazioneAllegati;

            if (sommaMenu > 0) {

                arrayInsert.permessi.push({"sezione": "menu", "permessi": sommaMenu, "dettagli": []});

            }
            if (sommaSezioni > 0) {

                arrayInsert.permessi.push({"sezione": "sezioni", "permessi": sommaSezioni, "dettagli": []});

            }
            if (sommaUtenti > 0) {

                arrayInsert.permessi.push({"sezione": "utenti", "permessi": sommaUtenti, "dettagli": []});

            }
            if (sommaAnagrafica > 0) {

                arrayInsert.permessi.push({"sezione": "anagrafica", "permessi": sommaAnagrafica, "dettagli": []});

            }
            if (sommaGruppi > 0) {

                arrayInsert.permessi.push({"sezione": "gruppi", "permessi": sommaGruppi, "dettagli": []});

            }
            if (sommaDocumenti > 0) {

                arrayInsert.permessi.push({"sezione": "documenti", "permessi": sommaDocumenti, "dettagli": []});

            }
            if (sommaMedici > 0) {

                arrayInsert.permessi.push({"sezione": "medici", "permessi": sommaMedici, "dettagli": []});

            }
            if (sommaAllegati > 0) {

                arrayInsert.permessi.push({"sezione": "allegati", "permessi": sommaMedici, "dettagli": []});

            }

            var url_string = document.URL;

            var url = new URL(url_string);
            var access_token = url.searchParams.get("authToken");

            arrayInsert.permessi = JSON.stringify(arrayInsert.permessi);
            arrayInsert.menu = JSON.stringify(arrayInsert.menu);

            arrayInsert.createDate = arrayGruppi[0].createDate;
            arrayInsert.createUser = arrayGruppi[0].createUser;
            arrayInsert.id = arrayGruppi[0].id;
            arrayInsert.primaryKey = arrayGruppi[0].primaryKey;
            arrayInsert.proprietario = arrayGruppi[0].proprietario;

            console.log(arrayInsert);
            $.ajax({
                url: '../rest/users/gruppi/' + arrayInsert.id,
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': "Bearer " + access_token
                },
                dataType: "json",
                data: JSON.stringify(arrayInsert),
                success: function (response) {
                    if (response.esito === true) {
                        $('#updateGroup').hide();
                        $('.modal-backdrop').remove();
                        tabGruppi.ajax.reload();
                        document.getElementById('alertSuccUpGp').style.display = 'block';
                        document.getElementById('tabsMenu1').style.display = 'none';
                        $('#letturaMenu1').prop("checked", false);
                        $('#inserimentoMenu1').prop("checked", false);
                        $('#modificaMenu1').prop("checked", false);
                        $('#cancellazioneMenu1').prop("checked", false);
                        document.getElementById('tabsSezioni1').style.display = 'none';
                        $('#letturaSezioni1').prop("checked", false);
                        $('#inserimentoSezioni1').prop("checked", false);
                        $('#modificaSezioni1').prop("checked", false);
                        $('#cancellazioneSezioni1').prop("checked", false);
                        document.getElementById('tabsUtenti1').style.display = 'none';
                        $('#letturaUtenti1').prop("checked", false);
                        $('#inserimentoUtenti1').prop("checked", false);
                        $('#modificaUtenti1').prop("checked", false);
                        $('#cancellazioneUtenti1').prop("checked", false);
                        document.getElementById('tabsAnagrafica1').style.display = 'none';
                        $('#letturaAnagrafica1').prop("checked", false);
                        $('#inserimentoAnagrafica1').prop("checked", false);
                        $('#modificaAnagrafica1').prop("checked", false);
                        $('#cancellazioneAnagrafica1').prop("checked", false);
                        document.getElementById('tabsGruppi1').style.display = 'none';
                        $('#letturaGruppi1').prop("checked", false);
                        $('#inserimentoGruppi1').prop("checked", false);
                        $('#modificaGruppi1').prop("checked", false);
                        $('#cancellazioneGruppi1').prop("checked", false);
                        document.getElementById('tabsDocumenti1').style.display = 'none';
                        $('#letturaDocumenti1').prop("checked", false);
                        $('#inserimentoDocumenti1').prop("checked", false);
                        $('#modificaDocumenti1').prop("checked", false);
                        $('#cancellazioneDocumenti1').prop("checked", false);
                        document.getElementById('tabsMedici1').style.display = 'none';
                        $('#letturaMedici1').prop("checked", false);
                        $('#inserimentoMedici1').prop("checked", false);
                        $('#modificaMedici1').prop("checked", false);
                        $('#cancellazioneMedici1').prop("checked", false);
                        document.getElementById('tabsAllegati1').style.display = 'none';
                        $('#letturaAllegati1').prop("checked", false);
                        $('#inserimentoAllegati1').prop("checked", false);
                        $('#modificaAllegati1').prop("checked", false);
                        $('#cancellazioneAllegati1').prop("checked", false);
                        $('#modificaGruppo').prop('disabled', true);

                    }
                },
                failure: function (response) {
                    if (response.status === 401 || response.status === 400 || response.status === 500) {
                        $('#updateGroup').hide();
                        $('.modal-backdrop').remove();
                        tabGruppi.ajax.reload();
                        document.getElementById('alertErrUpGp').style.display = 'block';
                        document.getElementById('tabsMenu1').style.display = 'none';
                        $('#letturaMenu1').prop("checked", false);
                        $('#inserimentoMenu1').prop("checked", false);
                        $('#modificaMenu1').prop("checked", false);
                        $('#cancellazioneMenu1').prop("checked", false);
                        document.getElementById('tabsSezioni1').style.display = 'none';
                        $('#letturaSezioni1').prop("checked", false);
                        $('#inserimentoSezioni1').prop("checked", false);
                        $('#modificaSezioni1').prop("checked", false);
                        $('#cancellazioneSezioni1').prop("checked", false);
                        document.getElementById('tabsUtenti1').style.display = 'none';
                        $('#letturaUtenti1').prop("checked", false);
                        $('#inserimentoUtenti1').prop("checked", false);
                        $('#modificaUtenti1').prop("checked", false);
                        $('#cancellazioneUtenti1').prop("checked", false);
                        document.getElementById('tabsAnagrafica1').style.display = 'none';
                        $('#letturaAnagrafica1').prop("checked", false);
                        $('#inserimentoAnagrafica1').prop("checked", false);
                        $('#modificaAnagrafica1').prop("checked", false);
                        $('#cancellazioneAnagrafica1').prop("checked", false);
                        document.getElementById('tabsGruppi1').style.display = 'none';
                        $('#letturaGruppi1').prop("checked", false);
                        $('#inserimentoGruppi1').prop("checked", false);
                        $('#modificaGruppi1').prop("checked", false);
                        $('#cancellazioneGruppi1').prop("checked", false);
                        document.getElementById('tabsDocumenti1').style.display = 'none';
                        $('#letturaDocumenti1').prop("checked", false);
                        $('#inserimentoDocumenti1').prop("checked", false);
                        $('#modificaDocumenti1').prop("checked", false);
                        $('#cancellazioneDocumenti1').prop("checked", false);
                        document.getElementById('tabsMedici1').style.display = 'none';
                        $('#letturaMedici1').prop("checked", false);
                        $('#inserimentoMedici1').prop("checked", false);
                        $('#modificaMedici1').prop("checked", false);
                        $('#cancellazioneMedici1').prop("checked", false);
                        document.getElementById('tabsAllegati1').style.display = 'none';
                        $('#letturaAllegati1').prop("checked", false);
                        $('#inserimentoAllegati1').prop("checked", false);
                        $('#modificaAllegati1').prop("checked", false);
                        $('#cancellazioneAllegati1').prop("checked", false);
                        $('#modificaGruppo').prop('disabled', true);

                    }
                }
            });

            return false;


        });
        
        function openModalUptoken (){
            
            
        };
        
        function openModalIntoken (){
            
            
        };
        
        $('#tokenFormIns').on('submit', function () {

            var arrayInsert = {};

            arrayInsert.authToken = $('#accessToken').val();
            arrayInsert.expiteToken = $('#dataScadenza').val();
            arrayInsert.session = $('#cliendId').val();

            console.log(arrayInsert);

            var url_string = document.URL;

            var url = new URL(url_string);
            var access_token = url.searchParams.get("authToken");

            $.ajax({
                url: '../rest/token/applicativi',
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': "Bearer " + access_token
                },
                dataType: "json",
                data: JSON.stringify(arrayInsert),
                success: function (response) {
                    if (response.esito === true) {
                        $('#insertTokens').hide();
                        $('.modal-backdrop').remove();
                        tabTokens.ajax.reload();
                        document.getElementById('alertSuccIn').style.display = 'block';
                        $('#accessToken').val('');
                        $('#dataScadenza').val('');
                        $('#cliendId').val('');
                    }
                },
                failure: function (response) {
                    if (response.status === 401 || response.status === 400 || response.status === 500) {
                        $('#insertTokens').hide();
                        $('.modal-backdrop').remove();
                        tabTokens.ajax.reload();
                        document.getElementById('alertErrIn').style.display = 'block';
                    }
                }
            });

            return false;

        });

    </script>




</main>