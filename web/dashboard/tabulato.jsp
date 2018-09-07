<%@ include file="navigation.jsp" %>
<main>

    <section id="bf-table">


        <h2 class="title"><strong>Tabulato Pazienti</strong></h2>


        <p class="description"></p>


        <section class="bf-table">


            <div class="card p-2 mb-5">


                <div class="row">


                    <div class="col-lg-3 col-md-12">

                            <select id="export" class="mdb-select colorful-select dropdown-primary mx-2 initialized" onchange="switchExport()">
                                <option value="" disabled="" selected="">Esporta</option>
                                <option value="1">PDF</option>
                                <option value="2">Excel</option>
                                <option value="3">Stampa</option>
                            </select>

                    </div>



                    <div class="col-lg-3 col-md-6">


                    </div>



                    <div class="col-lg-3 col-md-6">


                    </div>



                    <div class="col-lg-3 col-md-6">


                    </div>


                </div>


            </div>


            <div class="card card-cascade narrower">


                <div class="view gradient-card-header blue-gradient narrower py-2 mx-4 mb-3 d-flex justify-content-between align-items-center">


                    <a href="" class="white-text mx-3">Lista Pazienti</a>

                    <div>
                        <button type="button" id="presaIncarico" onclick="openModalPr()"
                                class="btn btn-outline-white btn-rounded btn-sm px-2 waves-effect waves-light" data-toggle="modal" data-target="#presa" data-tooltip="tooltip" data-placement="top" title="Presa in carico Paziente"><i
                                class="fa fa-check mt-0"></i></button>
                        <button type="button" id="modificaUtente" onclick="openModalUp()"
                                class="btn btn-outline-white btn-rounded btn-sm px-2 waves-effect waves-light" data-toggle="modal" data-target="#update"  data-tooltip="tooltip" data-placement="top" title="Modifica Paziente"><i
                                class="fa fa-pencil mt-0"></i></button>
                        <button type="button" id="eliminaUtente" onclick="openModalDel()"
                                class="btn btn-outline-white btn-rounded btn-sm px-2 waves-effect waves-light" data-toggle="modal" data-target="#delete" data-tooltip="tooltip" data-placement="top" title="Elimina Paziente"><i
                                class="fa fa-remove mt-0"></i></button>
                        <button type="button" id="historyUtente"
                                class="btn btn-outline-white btn-rounded btn-sm px-2 waves-effect waves-light" data-toggle="modal" data-target="#history" data-tooltip="tooltip" data-placement="top" title="History Paziente"><i
                                class="fa fa-history mt-0"></i></button>
                    </div>

                </div>
                <br>
                <span id="alertErrUp" class="badge badge-danger" style="display: none">Aggiornamento Fallito.</span>
                <span id="alertSuccUp" class="badge badge-success" style="display: none">Aggiornamento Completato.</span>
                <span id="alertErrDe" class="badge badge-danger" style="display: none">Eliminazione Fallita.</span>
                <span id="alertSuccDe" class="badge badge-success" style="display: none">Eliminazione Completata.</span>
                <span id="alertErrPr" class="badge badge-danger" style="display: none">Paziente gi&aacute; preso in carico da un'altro MMG/PLS/Altre Strutture.</span>
                <span id="alertSuccPr" class="badge badge-success" style="display: none">Paziente preso in carico con successo.</span>
                <span id="alertErrPr1" class="badge badge-danger" style="display: none">Errore nella presa in carico.</span>
                <br>
                <div class="px-4">
                    <br>
                    <div class="table-wrapper" style="max-height:100%">

                        <table id="customTable" class="table table-hover mb-0">

                            <thead>
                            <tr>
                                <th class="th-lg"></th>
                                <th class="th-lg">Cognome</th>
                                <th class="th-lg">Nome</th>
                                <th class="th-lg">Data Nascita</th>
                                <th class="th-lg">Provincia Nascita</th>
                                <th class="th-lg">Localit&aacute; Nascita</th>
                                <th class="th-lg">create_user</th>
                                <th class="th-lg">create_date</th>
                                <th class="th-lg">update_user</th>
                                <th class="th-lg">update_date</th>
                                <th class="th-lg">Proprietario</th>
                              
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
    <div class="main-wrapper">
        <div class="container-fluid">

            <div class="row">

                <div class="col-lg-10 col-md-12">

                    <section class="documentation">

                        <section id="position">

                            <section>

                                <div class="modal fade right" id="update" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="display: none;" aria-hidden="true">
                                    <div class="modal-dialog modal-full-height modal-right" role="document">
                                        <!--Content-->
                                        <div class="modal-content">
                                            <!--Header-->
                                            <div class="modal-header">
                                                <h4 class="modal-title w-100" id="myModalLabe">Modifica Anagrafia Paziente</h4>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <!--Body-->
                                            <form id="pazienteForm">
                                            <div class="modal-body">
                                                <p>In questa sezione &egrave; possibile aggiornare o modificare l'anagrafica di un determinato paziente.
                                                </p>
                                                
                                                <div class="md-form" hidden>
                                                    <i class="fa fa-address-card prefix "></i>
                                                    <input type="text" id="id" class="form-control form-control-sm" name="id" required>
                                                    <label  for="id">Id</label>
                                                </div>
                                                <div class="md-form">
                                                    <i class="fa fa-address-card prefix "></i>
                                                    <input type="text" id="cognome" class="form-control form-control-sm" name="cognome" required>
                                                    <label  for="cognome">Cognome</label>
                                                </div>
                                                <div class="md-form">
                                                    <i class="fa fa-address-card prefix "></i>
                                                    <input type="text" id="nome" class="form-control form-control-sm" name="nome" required>
                                                    <label  for="nome">Nome</label>
                                                </div>
                                                <div class="md-form">
                                                    <i class="fa fa-calendar prefix "></i>
                                                    <input type="text" id="dataNascita" class="form-control form-control-sm datepicker" name="dataNascita" required>
                                                    <label  for="dataNascita">Data Nascita</label>
                                                </div>
                                                <div class="md-form">
                                                    <i class="fa fa-map-marker prefix "></i>
                                                    <input type="text" id="localitaNascita" class="form-control form-control-sm" name="localitaNascita" required>
                                                    <label for="localitaNascita">Localit&aacute; Nascita</label>
                                                </div>
                                                <div class="md-form">
                                                    <i class="fa fa-map-marker prefix "></i>
                                                    <input type="text" id="provinciaNascita" class="form-control form-control-sm" name="provinciaNascita" required>
                                                    <label  for="provinciaNascita">Provincia Nascita</label>
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

                                <div class="modal fade show" id="delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="display: none; padding-right: 17px;">
                                    <div class="modal-dialog cascading-modal modal-avatar modal-sm" role="document">
                                        <!--Content-->
                                        <div class="modal-content">

                                            <!--Header-->
                                            <div class="modal-header">
                                                <img src="static/img/avatar.png" class="rounded-circle img-responsive" alt="Avatar photo">
                                            </div>
                                            <!--Body-->
                                            <div class="modal-body text-center mb-1">

                                                <h5 class="mt-1 mb-2">Sei sicuro di eliminare questo paziente ?</h5>

                                                <form id="deletePaziente">
                                                <div class="md-form" hidden>
                                                    <i class="fa fa-address-card prefix "></i>
                                                    <input type="text" id="id1" class="form-control form-control-sm" name="id" required>
                                                    <label  for="id1">Id</label>
                                                </div>
                                                <div class="md-form" hidden>
                                                    <i class="fa fa-address-card prefix "></i>
                                                    <input type="text" id="cognome1" class="form-control form-control-sm" name="cognome" required>
                                                    <label  for="cognome1">Cognome</label>
                                                </div>
                                                <div class="md-form" hidden>
                                                    <i class="fa fa-address-card prefix "></i>
                                                    <input type="text" id="nome1" class="form-control form-control-sm" name="nome" required>
                                                    <label  for="nome1">Nome</label>
                                                </div>
                                                <div class="md-form" hidden>
                                                    <i class="fa fa-calendar prefix "></i>
                                                    <input type="text" id="dataNascita1" class="form-control form-control-sm datepicker" name="dataNascita" required>
                                                    <label  for="dataNascita1">Data Nascita</label>
                                                </div>
                                                <div class="md-form" hidden>
                                                    <i class="fa fa-map-marker prefix "></i>
                                                    <input type="text" id="localitaNascita1" class="form-control form-control-sm" name="localitaNascita" required>
                                                    <label for="localitaNascita1">Localit&aacute; Nascita</label>
                                                </div>
                                                <div class="md-form" hidden>
                                                    <i class="fa fa-map-marker prefix "></i>
                                                    <input type="text" id="provinciaNascita1" class="form-control form-control-sm" name="provinciaNascita" required>
                                                    <label  for="provinciaNascita1">Provincia Nascita</label>
                                                </div>

                                                <div class="text-center mt-4">
                                                    <button type="submit" name="submit" class="btn btn-primary waves-effect waves-light">Si, Accetto.</button>
                                                    <button type="button" class="btn btn-secondary waves-effect waves-light" data-dismiss="modal">No, Annulla.</button>
                                                </div>
                                                </form>
                                            </div>

                                        </div>
                                        <!--/.Content-->
                                    </div>
                                </div>

                                <!-- <div class="modal fade show" id="presa" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="display: none; padding-right: 17px;">
                                    <div class="modal-dialog cascading-modal modal-avatar modal-sm" role="document">
                                        Content
                                        <div class="modal-content">

                                            Header
                                            <div class="modal-header">
                                                <img src="static/img/avatar.png" class="rounded-circle img-responsive" alt="Avatar photo">
                                            </div>
                                            Body
                                            <div class="modal-body text-center mb-1">

                                                <h5 class="mt-1 mb-2">Sei sicuro di prendere in carico questo paziente ?</h5>


                                                <form method="POST" action="/" name="presaPaziente">
                                                    <div class="md-form" hidden>
                                                        <i class="fa fa-address-card prefix "></i>
                                                        <input type="text" id="id12" class="form-control form-control-sm" name="id" >
                                                        <label  for="id12">Id</label>
                                                    </div>
                                                    <div class="md-form" hidden>
                                                        <i class="fa fa-address-card prefix "></i>
                                                        <input type="text" id="codiceFiscale12" class="form-control form-control-sm" name="codiceFiscale" >
                                                        <label  for="codiceFiscale12">Codice Fiscale</label>
                                                    </div>
                                                    <div class="md-form" hidden>
                                                        <i class="fa fa-address-card prefix "></i>
                                                        <input type="text" id="cognome12" class="form-control form-control-sm" name="cognome" >
                                                        <label  for="cognome12">Cognome</label>
                                                    </div>
                                                    <div class="md-form" hidden>
                                                        <i class="fa fa-address-card prefix "></i>
                                                        <input type="text" id="nome12" class="form-control form-control-sm" name="nome" >
                                                        <label  for="nome12">Nome</label>
                                                    </div>
                                                    <div class="md-form" hidden>
                                                        <i class="fa fa-calendar prefix "></i>
                                                        <input type="text" id="dataNascita12" class="form-control form-control-sm datepicker" name="dataNascita" >
                                                        <label  for="dataNascita12">Data Nascita</label>
                                                    </div>
                                                    <div class="md-form" hidden>
                                                        <i class="fa fa-map-marker prefix "></i>
                                                        <input type="text" id="provincia12" class="form-control form-control-sm" name="provincia" >
                                                        <label for="provincia12">Provincia</label>
                                                    </div>
                                                    <div class="md-form" hidden>
                                                        <i class="fa fa-map-marker prefix "></i>
                                                        <input type="text" id="luogoNascita12" class="form-control form-control-sm" name="luogoNascita" >
                                                        <label  for="luogoNascita12">Luogo Nascita</label>
                                                    </div>
                                                    <div class="md-form " hidden>
                                                        <i class="fa fa-group prefix"></i>
                                                        <input type="text" id="sesso12" class="form-control form-control-sm" name="sesso" >
                                                        <label for="sesso12">Sesso</label>
                                                    </div>
                                                    <div class="md-form " hidden>
                                                        <i class="fa fa-info-circle prefix"></i>
                                                        <input type="text" id="altezza12" class="form-control form-control-sm" name="altezza" >
                                                        <label  for="altezza12">Altezza</label>
                                                    </div>
                                                    <div class="md-form" hidden>
                                                        <i class="fa fa-institution prefix"></i>
                                                        <input type="text" id="cittadinanza12" class="form-control form-control-sm" name="cittadinanza" >
                                                        <label for="cittadinanza12">Cittadinanza</label>
                                                    </div>
                                                    <div class="md-form " hidden>
                                                        <i class="fa fa-location-arrow prefix"></i>
                                                        <input type="text" id="residenza12" class="form-control form-control-sm" name="residenza" >
                                                        <label for="residenza12">Residenza</label>
                                                    </div>

                                                    <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />

                                                    <div class="text-center mt-4">
                                                        <button type="submit" name="submit" class="btn btn-primary waves-effect waves-light">Si, Accetto.</button>
                                                        <button type="button" class="btn btn-secondary waves-effect waves-light" data-dismiss="modal">No, Annulla.</button>
                                                    </div>
                                                </form>
                                            </div>

                                        </div>
                                        /.Content
                                    </div>
                                </div>-->

                                <div class="modal fade right" id="history" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="display: none;" aria-hidden="true">
                                    <div class="modal-dialog modal-full-height modal-right" role="document">
                                        <!--Content-->
                                        <div class="modal-content">
                                            <!--Header-->
                                            <div class="modal-header">
                                                <h4 class="modal-title w-100" id="myModalLabel">History Paziente</h4>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <!--Body-->
                                            <div class="modal-body">
                                                <p>In questa sezione &egrave; possibile visualizzare l'history di un determinato paziente.
                                                </p>



                                            </div>
                                            <!--Footer-->
                                            <div class="modal-footer justify-content-center">
                                                <button type="button" class="btn btn-secondary waves-effect waves-light" data-dismiss="modal">Chiudi</button>
                                            </div>
                                        </div>
                                        <!--/.Content-->
                                    </div>
                                </div>

                            </section>

                        </section>


                    </section>

                </div>

            </div>
        </div>
    </div>
    <script type="text/javascript">

        var arrayUtenti = {};

        function switchExport(){
            if($('#export').val()==='1'){
                tabUtenti.buttons('.buttons-pdf').trigger();
            }
            else if($('#export').val()==='2'){

                tabUtenti.buttons('.buttons-excel').trigger();

            }
            else if($('#export').val()==='3'){

                tabUtenti.buttons('.buttons-print').trigger();

            }
        }

        function openModalUp(){
            
            var ids1 = $.map(tabUtenti.rows('.selected').data(), function (item) {
                return item;
            });
            arrayUtenti = ids1;

            $('#id').val(arrayUtenti[0].id);
            $('#cognome').val(arrayUtenti[0].cognome);
            $('#nome').val(arrayUtenti[0].nome);
            $('#dataNascita').val(moment(arrayUtenti[0].dataNascita).subtract(10, 'days').calendar());
            $('#localitaNascita').val(arrayUtenti[0].localitaNascita);
            $('#provinciaNascita').val(arrayUtenti[0].provinciaNascita);
            $('#createUser').val(arrayUtenti[0].createUser);
            $('#createDate').val(arrayUtenti[0].createDate);
            $('#updateUser').val(arrayUtenti[0].updateUser);
            $('#updateDate').val(arrayUtenti[0].updateDate);

        }

        function convertDate(data){
            function pad(s) { return (s < 10) ? '0' + s : s; };
            var d = new Date(data);
            return [pad(d.getDate()), pad(d.getMonth()+1), d.getFullYear()].join('/');
        }

        function openModalDel() {

            var ids1 = $.map(tabUtenti.rows('.selected').data(), function (item) {
                return item;
            });
            arrayUtenti = ids1;

            $('#id1').val(arrayUtenti[0].id);
            $('#cognome1').val(arrayUtenti[0].cognome);
            $('#nome1').val(arrayUtenti[0].nome);
            $('#dataNascita1').val(convertDate(arrayUtenti[0].dataNascita));
            $('#localitaNascita1').val(arrayUtenti[0].localitaNascita);
            $('#provinciaNascita1').val(arrayUtenti[0].provinciaNascita);
            $('#createUser1').val(arrayUtenti[0].createUser);
            $('#createDate1').val(arrayUtenti[0].createDate);
            $('#updateUser1').val(arrayUtenti[0].updateUser);
            $('#updateDate1').val(arrayUtenti[0].updateDate);

        }

        function openModalPr() {

            var ids1 = $.map(tabUtenti.rows('.selected').data(), function (item) {
                return item;
            });
            arrayUtenti = ids1;

            $('#id12').val(arrayUtenti[0].id);
            $('#cognome12').val(arrayUtenti[0].cognome);
            $('#nome12').val(arrayUtenti[0].nome);
            $('#dataNascita12').val(convertDate(arrayUtenti[0].dataNascita));
            $('#localitaNascita12').val(arrayUtenti[0].localitaNascita);
            $('#provinciaNascita12').val(arrayUtenti[0].provinciaNascita);
            $('#createUser12').val(arrayUtenti[0].createUser);
            $('#createDate12').val(arrayUtenti[0].createDate);
            $('#updateUser12').val(arrayUtenti[0].updateUser);
            $('#updateDate12').val(arrayUtenti[0].updateDate);

        }

        $(document).ready(function() {
           
            $('.mdb-select').material_select();
            $('[data-tooltip="tooltip"]').tooltip();
            $('.datepicker').pickadate();

            $('.label').addClass('active');

            $('#modificaUtente').prop('disabled', true);
            $('#eliminaUtente').prop('disabled', true);
            $('#historyUtente').prop('disabled', true);
            $('#presaIncarico').prop('disabled', true);

            var url_string = document.URL; 
            
            var url = new URL(url_string);
            var access_token = url.searchParams.get("authToken");
           

            tabUtenti = $('#customTable').DataTable({
               
                ajax :{
                url: '../rest/anagrafica',
                type: "GET",
                headers: { 
                    'Content-Type': 'application/json',
                    'Authorization': "Bearer " +access_token },
                dataSrc: function (json) {
                    return json.object;
                    }
                },
                responsive: true,
                autoWidth: true,
                sPaginationType : "full_numbers",
                buttons: [
                    {
                        extend: 'excel',
                        text: 'Excel',
                        exportOptions: {
                            columns: [ 1, 2, 3, 4, 5, 6, 7, 8, 9 ],
                            orthogonal: 'export'
                        }
                    },
                    {
                        extend: 'pdfHtml5',
                        text: 'PDF',
                        orientation: 'landscape',
                        exportOptions: {
                            columns: [ 1, 2, 3, 4, 5, 6, 7, 8, 9 ],
                            orthogonal: 'export'
                        }
                    },
                    {
                        extend: 'print',
                        text: 'Stampa',
                        exportOptions: {
                            columns: [ 1, 2, 3, 4, 5, 6, 7, 8, 9 ],
                            orthogonal: 'export'
                        }
                    }
                ],
                columns: [
                    {'data': "id", visible:false},
                    {'data': "cognome", width:"1px"},
                    {'data': "nome", width:"1px"},
                    {'data': "dataNascita","render": function (data) {
                                function pad(s) { return (s < 10) ? '0' + s : s; };
                                var d = new Date(data);
                                return [pad(d.getDate()), pad(d.getMonth()+1), d.getFullYear()].join('/');
                        },width:"1px"},
                    {'data': "provinciaNascita", width:"1px"},
                    {'data': "localitaNascita", width:"1px"},
                    {'data': "createUser", width:"1px"},
                    {'data': "createDate","render": function (data) {
                            moment.locale('it');
                            var d = new Date(data);
                            var a = moment(d); 
                            return a.format('LLLL');
                        }},
                    {'data': "updateUser"},
                    {'data': "updateDate","render": function (data) {
                            moment.locale('it');
                            var d = new Date(data);
                            var a = moment(d); 
                            return a.format('LLLL');
                        }},
                    {'data': "proprietario"}
                ]
            });

            $('#customTable tbody').on('click', 'tr', function () {
                if ($(this).hasClass('selected')) {
                    $(this).removeClass('selected');
                    $('#modificaUtente').prop('disabled', true);
                    $('#eliminaUtente').prop('disabled', true);
                    $('#historyUtente').prop('disabled', true);
                    $('#presaIncarico').prop('disabled', true);
                }
                else {
                    tabUtenti.$('tr.selected').removeClass('selected');
                    $(this).addClass('selected');
                    $('#modificaUtente').prop('disabled', false);
                    $('#eliminaUtente').prop('disabled', false);
                    $('#historyUtente').prop('disabled', false);
                    $('#presaIncarico').prop('disabled', false);
                }
            });

            $('#customTable tbody').on('click', 'td.details-control', function () {
                var tr = $(this).closest('tr');
                var row = tabUtenti.row(tr);

                if (row.child.isShown()) {
                    // This row is already open - close it
                    row.child.hide();
                    tr.removeClass('shown');
                }
                else {
                    // Open this row
                    row.child(format(row.data())).show();
                    tr.addClass('shown');
                }
            });

            $("#my-4").append($(".dataTables_paginate"));

        });
        
        $('#pazienteForm').on('submit',function(){
            
            var arrayUpdate = {};
            
            arrayUpdate.id = arrayUtenti[0].id;
            arrayUpdate.cognome =  $('#cognome').val();
            arrayUpdate.nome = $('#nome').val();
            arrayUpdate.dataNascita = moment($('#dataNascita').val()).format();
            arrayUpdate.localitaNascita = $('#localitaNascita').val();
            arrayUpdate.provinciaNascita = $('#provinciaNascita').val();
            arrayUpdate.proprietario = arrayUtenti[0].proprietario;
            arrayUpdate.createDate = arrayUtenti[0].createDate;
            arrayUpdate.createUser = arrayUtenti[0].createUser;
            arrayUpdate.denominazione = arrayUtenti[0].denominazione;
            arrayUpdate.codiceFiscale = arrayUtenti[0].codiceFiscale;
            
            var url_string = document.URL; 
            
            var url = new URL(url_string);
            var access_token = url.searchParams.get("authToken");
            
            $.ajax({
            url: '../rest/anagrafica/modifica/'+arrayUpdate.id,
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': "Bearer " +access_token
            },
            dataType: "json",
            data: JSON.stringify(arrayUpdate),
            success: function (response) {
               if(response.esito=== true){  
                   $('#update').hide();
                   $('.modal-backdrop').remove();
                   tabUtenti.ajax.reload();
                   document.getElementById('alertSuccUp').style.display = 'block';
                   $('#modificaUtente').prop('disabled', true);
                    $('#eliminaUtente').prop('disabled', true);
                    $('#historyUtente').prop('disabled', true);
                    $('#presaIncarico').prop('disabled', true);
               }
            },
            failure: function (response) { 
                if (response.status === 401 || response.status === 400 || response.status === 500) {  
                    $('#update').hide();
                   $('.modal-backdrop').remove();
                   tabUtenti.ajax.reload();
                   document.getElementById('alertErrUp').style.display = 'block';
                   $('#modificaUtente').prop('disabled', true);
                    $('#eliminaUtente').prop('disabled', true);
                    $('#historyUtente').prop('disabled', true);
                    $('#presaIncarico').prop('disabled', true);
                }      
            }
            });
     
            return false;
            
        });
        
        $('#deletePaziente').on('submit',function(){
            
            var arrayDelete = {};
            
            arrayDelete.id = arrayUtenti[0].id;
            
            var url_string = document.URL; 
            
            var url = new URL(url_string);
            var access_token = url.searchParams.get("authToken");
            
            $.ajax({
            url: '../rest/anagrafica/delete/'+arrayDelete.id,
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': "Bearer " +access_token
            },
            dataType: "json",
            data: JSON.stringify(arrayDelete),
            success: function (response) {
               if(response.esito === true){  
                   $('#delete').hide();
                   $('.modal-backdrop').remove();
                   tabUtenti.ajax.reload();
                   document.getElementById('alertSuccDe').style.display = 'block';
               }
            },
            failure: function (response) { 
                if (response.status === 401 || response.status === 400 || response.status === 500) {  
                    $('#delete').hide();
                    $('.modal-backdrop').remove();
                    tabUtenti.ajax.reload();
                    document.getElementById('alertErrDe').style.display = 'block';
                }      
            }
            });
     
            return false;
            
        });
        
    </script>
</main>