<link href="static/css/bpmnJS/css/diagram-js.css" rel="stylesheet">
<link href="static/css/bpmnJS/vendor/bpmn-font/css/bpmn-embedded.css" rel="stylesheet">
<link href="static/css/bpmnJS/css/app.css" rel="stylesheet">
<%@ include file="navigation.jsp" %>
<style>
    [type=checkbox] + label:before {
    content: "";
    position: absolute;
    top: 0;
    left: 0;
    width: 17px;
    height: 17px;
    z-index: 0;
    border: 1.5px solid #8a8a8a;
    -webkit-border-radius: 1px;
    border-radius: 1px;
    margin-top: 2px;
    -webkit-transition: .2s;
    -o-transition: .2s;
    transition: .2s;
    display: none;
}
select {
    font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
    display: block
}
</style>    
<main>

    <div class="card card-cascade">

        <!-- Card image -->
        <div class="view gradient-card-header blue-gradient">

            <!-- Title -->
            <h2 class="card-header-title mb-3">Crazione BPMN</h2>
            <!-- Subtitle -->
            <p class="card-header-subtitle mb-0">Crea</p>

        </div>

        <!-- Card content -->
        <div class="card-body">

            <div class="content with-diagram" id="js-drop-zone" style="height: 800px; font-size: 12px;">

                <div class="message intro">
                    <div class="note">
                        Rilasciare il diagramma BPMN dal desktop o <a id="js-create-diagram" href>creare un Nuovo Diagramma</a> per iniziare.
                    </div>
                </div>

                <div class="message error">
                    <div class="note">
                        <p>Ooops, non è stato possibile visualizzare il diagramma BPMN 2.0</p>

                        <div class="details">
                            <span>Dettagli errore importazione</span>
                            <pre></pre>
                        </div>
                    </div>
                </div>

                <div class="canvas" id="js-canvas"></div>
                <div class="properties-panel-parent" id="js-properties-panel"></div>
            </div>

            <ul class="buttons">
                <li>
                    Esporta
                </li>
                <li>
                    <a id="js-download-diagram" href title="download BPMN diagram">
                        BPMN diagramma
                    </a>
                </li>
                <li>
                    <a id="js-download-svg" href title="download as SVG image">
                        SVG immagine
                    </a>
                </li>
            </ul>

        </div>

    </div>

   
    <script src="static/js/bpmnJS/index.js"></script>
    <script>

        $('.mdb-select').material_select();
         
        var url_string = document.URL;

        var url = new URL(url_string);
        var access_token = url.searchParams.get("authToken");
        
        $('.bjs-powered-by').css("display", "none");

    </script>
</main>