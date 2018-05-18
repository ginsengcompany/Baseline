<%--
  Created by IntelliJ IDEA.
  User: Antonio Biondillo
  Date: 15/05/2018
  Time: 09:51
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="navigation.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
                    <div class="table-wrapper">

                        <table id="customTable" class="table table-hover mb-0">

                            <thead>
                            <tr>
                                <th class="th-lg">Codice Fiscale</th>
                                <th class="th-lg">Cognome</th>
                                <th class="th-lg">Nome</th>
                                <th class="th-lg">Data Nascita</th>
                                <th class="th-lg">Luogo Nascita</th>
                                <th class="th-lg">Provincia</th>
                                <th class="th-lg">Sesso</th>
                                <th class="th-lg">Altezza</th>
                                <th class="th-lg">Cittadinanza</th>
                                <th class="th-lg">Residenza</th>
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

        function switchSelection(){
            if($('#checkboxSelection').prop('checked')===true){

                tabUtenti.rows().select();

            }
            else if($('#checkboxSelection').prop('checked')===false){

                tabUtenti.rows().deselect();

            }
        }

        function openModalUp(){

            var ids1 = $.map(tabUtenti.rows('.selected').data(), function (item) {
                return item;
            });
            arrayUtenti = ids1;

            $('#id').val(arrayUtenti[0].id);
            $('#codiceFiscale').val(arrayUtenti[0].codiceFiscale);
            $('#cognome').val(arrayUtenti[0].cognome);
            $('#nome').val(arrayUtenti[0].nome);
            $('#dataNascita').val(convertDate(arrayUtenti[0].dataNascita));
            $('#luogoNascita').val(arrayUtenti[0].luogoNascita);
            $('#provincia').val(arrayUtenti[0].provincia);
            $('#sesso').val(arrayUtenti[0].sesso);
            $('#altezza').val(arrayUtenti[0].altezza);
            $('#cittadinanza').val(arrayUtenti[0].cittadinanza);
            $('#residenza').val(arrayUtenti[0].residenza);

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
            $('#codiceFiscale1').val(arrayUtenti[0].codiceFiscale);
            $('#cognome1').val(arrayUtenti[0].cognome);
            $('#nome1').val(arrayUtenti[0].nome);
            $('#dataNascita1').val(arrayUtenti[0].dataNascita);
            $('#luogoNascita1').val(arrayUtenti[0].luogoNascita);
            $('#provincia1').val(arrayUtenti[0].provincia);
            $('#sesso1').val(arrayUtenti[0].sesso);
            $('#altezza1').val(arrayUtenti[0].altezza);
            $('#cittadinanza1').val(arrayUtenti[0].cittadinanza);
            $('#residenza1').val(arrayUtenti[0].residenza);

        }

        function openModalPr() {

            var ids1 = $.map(tabUtenti.rows('.selected').data(), function (item) {
                return item;
            });
            arrayUtenti = ids1;

            $('#id12').val(arrayUtenti[0].id);
            $('#codiceFiscale12').val(arrayUtenti[0].codiceFiscale);
            $('#cognome12').val(arrayUtenti[0].cognome);
            $('#nome12').val(arrayUtenti[0].nome);
            $('#dataNascita12').val(arrayUtenti[0].dataNascita);
            $('#luogoNascita12').val(arrayUtenti[0].luogoNascita);
            $('#provincia12').val(arrayUtenti[0].provincia);
            $('#sesso12').val(arrayUtenti[0].sesso);
            $('#altezza12').val(arrayUtenti[0].altezza);
            $('#cittadinanza12').val(arrayUtenti[0].cittadinanza);
            $('#residenza12').val(arrayUtenti[0].residenza);

        }

        var user =  '${user}';

        if(user ==='[ROLE_ADMIN]'){
            document.getElementById('presaIncarico').style.display = 'none';
        }
        if(user ==='[ROLE_MMG]'){
            document.getElementById('modificaUtente').style.display = 'none';
            document.getElementById('eliminaUtente').style.display = 'none';
        }
        else if(user ==='[ROLE_AMB]'){
            document.getElementById('modificaUtente').style.display = 'none';
            document.getElementById('eliminaUtente').style.display = 'none';
            document.getElementById('presaIncarico').style.display = 'none';
        }

        var message = "<%= request.getParameter("paziente") %>";

        if(message==='Aggiornamento Fallito'){

            document.getElementById('alertErrUp').style.display = 'block';
        }
        else if(message==='Aggiornamento Completato'){
            document.getElementById('alertSuccUp').style.display = 'block';
        }
        else if(message==='Eliminazione Fallita'){
            document.getElementById('alertErrDe').style.display = 'block';
        }
        else if(message==='Eliminazione Completata'){
            document.getElementById('alertSuccDe').style.display = 'block';
        }
        else if(message==='PazienteSi'){
            document.getElementById('alertErrPr').style.display = 'block';
        }
        else if(message==='Paziente preso in carico con successo'){
            document.getElementById('alertSuccPr').style.display = 'block';
        }
        else if(message==='Errore nella presa in carico'){
            document.getElementById('alertErrPr1').style.display = 'block';
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


            tabUtenti = $('#customTable').DataTable({
                ajax: "/dashboard/getUtenti",
                responsive: true,
                autoWidth: false,
                sPaginationType : "full_numbers",
                buttons: [
                    {
                        extend: 'excel',
                        text: 'Excel',
                        exportOptions: {
                            columns: ':visible',
                            orthogonal: 'export'
                        }
                    },
                    {
                        extend: 'pdfHtml5',
                        text: 'PDF',
                        orientation: 'landscape',
                        exportOptions: {
                            columns: ':visible',
                            orthogonal: 'export'
                        }
                    },
                    {
                        extend: 'print',
                        text: 'Stampa',
                        exportOptions: {
                            columns: ':visible',
                            orthogonal: 'export'
                        }
                    }
                ],
                columns: [
                    {"data": "codiceFiscale"},
                    {"data": "cognome"},
                    {"data": "nome"},
                    {"data": "dataNascita","render": function (data) {
                                function pad(s) { return (s < 10) ? '0' + s : s; };
                                var d = new Date(data);
                                return [pad(d.getDate()), pad(d.getMonth()+1), d.getFullYear()].join('/');
                        },},
                    {"data": "luogoNascita"},
                    {"data": "provincia"},
                    {"data": "sesso"},
                    {"data": "altezza"},
                    {"data": "cittadinanza"},
                    {"data": "residenza"}

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

        })

    </script>
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
                                            <c:url var="updatePaziente" value="/dashboard/updateUtenti" />
                                            <form:form method="POST" action="${updatePaziente}" name="updatePaziente">
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
                                                    <input type="text" id="codiceFiscale" class="form-control form-control-sm" name="codiceFiscale" required>
                                                    <label  for="codiceFiscale">Codice Fiscale</label>
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
                                                    <input type="text" id="provincia" class="form-control form-control-sm" name="provincia" required>
                                                    <label for="provincia">Provincia</label>
                                                </div>
                                                <div class="md-form">
                                                    <i class="fa fa-map-marker prefix "></i>
                                                    <input type="text" id="luogoNascita" class="form-control form-control-sm" name="luogoNascita" required>
                                                    <label  for="luogoNascita">Luogo Nascita</label>
                                                </div>
                                                <div class="md-form ">
                                                    <i class="fa fa-group prefix"></i>
                                                    <input type="text" id="sesso" class="form-control form-control-sm" name="sesso" required>
                                                    <label for="sesso">Sesso</label>
                                                </div>
                                                <div class="md-form ">
                                                    <i class="fa fa-info-circle prefix"></i>
                                                    <input type="text" id="altezza" class="form-control form-control-sm" name="altezza" required>
                                                    <label  for="altezza">Altezza</label>
                                                </div>
                                                <div class="md-form">
                                                    <i class="fa fa-institution prefix"></i>
                                                    <input type="text" id="cittadinanza" class="form-control form-control-sm" name="cittadinanza" required>
                                                    <label for="cittadinanza">Cittadinanza</label>
                                                </div>
                                                <div class="md-form ">
                                                    <i class="fa fa-location-arrow prefix"></i>
                                                    <input type="text" id="residenza" class="form-control form-control-sm" name="residenza" required>
                                                    <label for="residenza">Residenza</label>
                                                </div>

                                                <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
                                            </div>
                                            <!--Footer-->
                                            <div class="modal-footer justify-content-center">
                                                <button type="button" class="btn btn-secondary waves-effect waves-light" data-dismiss="modal">Chiudi</button>
                                                <button type="submit" class="btn btn-primary waves-effect waves-light" name="submit">Salva Modifiche</button>
                                            </div>
                                            </form:form>
                                        </div>
                                        <!--/.Content-->
                                    </div>
                                </div>

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

                                <div class="modal fade show" id="delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="display: none; padding-right: 17px;">
                                    <div class="modal-dialog cascading-modal modal-avatar modal-sm" role="document">
                                        <!--Content-->
                                        <div class="modal-content">

                                            <!--Header-->
                                            <div class="modal-header">
                                                <img src="../../static/img/avatar.png" class="rounded-circle img-responsive" alt="Avatar photo">
                                            </div>
                                            <!--Body-->
                                            <div class="modal-body text-center mb-1">

                                                <h5 class="mt-1 mb-2">Sei sicuro di eliminare questo paziente ?</h5>

                                                <c:url var="deletePaziente" value="/dashboard/deleteUtenti" />
                                                <form:form method="POST" action="${deletePaziente}" name="deletePaziente">
                                                <div class="md-form" hidden>
                                                    <i class="fa fa-address-card prefix "></i>
                                                    <input type="text" id="id1" class="form-control form-control-sm" name="id" >
                                                    <label  for="id1">Id</label>
                                                </div>
                                                <div class="md-form" hidden>
                                                    <i class="fa fa-address-card prefix "></i>
                                                    <input type="text" id="codiceFiscale1" class="form-control form-control-sm" name="codiceFiscale" >
                                                    <label  for="codiceFiscale1">Codice Fiscale</label>
                                                </div>
                                                <div class="md-form" hidden>
                                                    <i class="fa fa-address-card prefix "></i>
                                                    <input type="text" id="cognome1" class="form-control form-control-sm" name="cognome" >
                                                    <label  for="cognome1">Cognome</label>
                                                </div>
                                                <div class="md-form" hidden>
                                                    <i class="fa fa-address-card prefix "></i>
                                                    <input type="text" id="nome1" class="form-control form-control-sm" name="nome" >
                                                    <label  for="nome1">Nome</label>
                                                </div>
                                                <div class="md-form" hidden>
                                                    <i class="fa fa-calendar prefix "></i>
                                                    <input type="text" id="dataNascita1" class="form-control form-control-sm datepicker" name="dataNascita" >
                                                    <label  for="dataNascita1">Data Nascita</label>
                                                </div>
                                                <div class="md-form" hidden>
                                                    <i class="fa fa-map-marker prefix "></i>
                                                    <input type="text" id="provincia1" class="form-control form-control-sm" name="provincia" >
                                                    <label for="provincia1">Provincia</label>
                                                </div>
                                                <div class="md-form" hidden>
                                                    <i class="fa fa-map-marker prefix "></i>
                                                    <input type="text" id="luogoNascita1" class="form-control form-control-sm" name="luogoNascita" >
                                                    <label  for="luogoNascita1">Luogo Nascita</label>
                                                </div>
                                                <div class="md-form " hidden>
                                                    <i class="fa fa-group prefix"></i>
                                                    <input type="text" id="sesso1" class="form-control form-control-sm" name="sesso" >
                                                    <label for="sesso1">Sesso</label>
                                                </div>
                                                <div class="md-form " hidden>
                                                    <i class="fa fa-info-circle prefix"></i>
                                                    <input type="text" id="altezza1" class="form-control form-control-sm" name="altezza" >
                                                    <label  for="altezza1">Altezza</label>
                                                </div>
                                                <div class="md-form" hidden>
                                                    <i class="fa fa-institution prefix"></i>
                                                    <input type="text" id="cittadinanza1" class="form-control form-control-sm" name="cittadinanza" >
                                                    <label for="cittadinanza1">Cittadinanza</label>
                                                </div>
                                                <div class="md-form " hidden>
                                                    <i class="fa fa-location-arrow prefix"></i>
                                                    <input type="text" id="residenza1" class="form-control form-control-sm" name="residenza" >
                                                    <label for="residenza1">Residenza</label>
                                                </div>

                                                <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />

                                                <div class="text-center mt-4">
                                                    <button type="submit" name="submit" class="btn btn-primary waves-effect waves-light">Si, Accetto.</button>
                                                    <button type="button" class="btn btn-secondary waves-effect waves-light" data-dismiss="modal">No, Annulla.</button>
                                                </div>
                                                </form:form>
                                            </div>

                                        </div>
                                        <!--/.Content-->
                                    </div>
                                </div>

                                <div class="modal fade show" id="presa" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="display: none; padding-right: 17px;">
                                    <div class="modal-dialog cascading-modal modal-avatar modal-sm" role="document">
                                        <!--Content-->
                                        <div class="modal-content">

                                            <!--Header-->
                                            <div class="modal-header">
                                                <img src="../../static/img/avatar.png" class="rounded-circle img-responsive" alt="Avatar photo">
                                            </div>
                                            <!--Body-->
                                            <div class="modal-body text-center mb-1">

                                                <h5 class="mt-1 mb-2">Sei sicuro di prendere in carico questo paziente ?</h5>

                                                <c:url var="presaPaziente" value="/dashboard/presaIncarico" />
                                                <form:form method="POST" action="${presaPaziente}" name="presaPaziente">
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
                                                </form:form>
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
</main>