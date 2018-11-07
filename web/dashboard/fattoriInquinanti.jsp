<%@ include file="navigation.jsp" %>
<%@page import="it.gesan.inquinamento.inquinamento.DatiInquinamento"%>
<main>
    <style>
        .legend {
            line-height: 18px;
            color: #555;
            text-align: left;
            background: #fff;
            padding: 5px;
            border: 2px solid white;
            border-radius: 5px;
        }
        .legend i {
            width: 18px;
            height: 18px;
            float: left;
            margin-right: 8px;
            opacity: 0.7;
        }
    </style>
    <div class="card card-cascade">

        <!-- Card image -->
        <div class="view gradient-card-header blue-gradient">

            <!-- Title -->
            <h2 class="card-header-title mb-3">PM10 (Particulate Matter o Materia Particolata, cioè in piccole particelle)</h2>
            <!-- Subtitle -->
            <p class="card-header-subtitle mb-0">La mappa presenta delle forme circolari colorate che rappresentano, in base al colore, la qualità dell'aria. I dati sono recuperati dal sito www.arpacampania.it, da questi dati viene calcolato l'IQA (indice di qualità dell'aria) per ognuno di essi.</p>

        </div>

        <!-- Card content -->
        <div class="card-body text-center">

            <div class="text-center mt-4 mb-2">
                <div id="map" class="leaflet-container leaflet-touch leaflet-fade-anim leaflet-grab leaflet-touch-drag leaflet-touch-zoom" style="height: 500px;width: auto;"></div>
            </div>
        </div>

    </div>
    <br>
    <div class="card card-cascade">

        <!-- Card image -->
        <div class="view gradient-card-header blue-gradient">

            <!-- Title -->
            <h2 class="card-header-title mb-3">PM10 (Particulate Matter o Materia Particolata, cioè in piccole particelle)</h2>
            <!-- Subtitle -->
            <p class="card-header-subtitle mb-0">La mappa presenta delle forme circolari colorate che rappresentano, in base al colore, la qualità dell'aria. I dati sono recuperati dal sito www.arpacampania.it, da questi dati viene calcolato l'IQA (indice di qualità dell'aria) per ognuno di essi.</p>

        </div>

        <!-- Card content -->
        <div class="card-body text-center">

            <div class="text-center mt-4 mb-2">
                <div class="embed-responsive embed-responsive-16by9 hoverable">
                    <iframe class="embed-responsive-item" src="http://webgis.arpa.piemonte.it/aria_qualita_stazioni_webapp/" style="height: 101%" allowfullscreen></iframe>
                </div>
            </div>
        </div>

    </div>
    <script>
            var inquinaPm10, stazioni, comuni;
            inquinaPm10 = <%=request.getAttribute("pm10")%>;
            stazioni = <%=request.getAttribute("luoghi")%>;
            comuni = <%=request.getAttribute("comuni")%>;
            var map = new L.map('map');
            var osmUrl='https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png';
            var osmAttrib = 'Map dati © Baseline';
            var osm = new L.TileLayer(osmUrl, {minZoom: 6, maxZoom: 15, attribution: osmAttrib});
            map.setView(new L.LatLng("40.9296228","14.5373564"),8);
            map.addLayer(osm);
            var optionsLoadBar = {
                lines: 7,
                length: 9,
                width: 12,
                radius: 8,
                rotate: 13,
                color: '#3145a3',
                speed: 1,
                trail: 60,
                shadow: false,
                hwaccel: false,
                className: 'spinner',
                zIndex: 2e9,
                top: 'auto',
                left: 'auto'
            };
            var spinner = new Spinner(optionsLoadBar).spin(document.getElementById("map"));
            var inquinamentoPerStazioni = {};
            for(var prop in stazioni.luoghi){
                inquinamentoPerStazioni[prop] = stazioni.luoghi[prop];
                for(var i=0; i < inquinaPm10.length; i++){
                    if(prop === inquinaPm10[i].stazione){
                        inquinamentoPerStazioni[prop].IQA = inquinaPm10[i].IQA;
                        inquinamentoPerStazioni[prop].color = inquinaPm10[i].color;
                        inquinamentoPerStazioni[prop].stazione = inquinaPm10[i].stazione;
                        break;
                    }
                } 
            }
            for(var prop in inquinamentoPerStazioni){
                var max = {
                    val: inquinamentoPerStazioni[prop].IQA,
                    color: inquinamentoPerStazioni[prop].color,
                    stazione : inquinamentoPerStazioni[prop].stazione,
                    latitudine: inquinamentoPerStazioni[prop].latitudine,
                    longitudine: inquinamentoPerStazioni[prop].longitudine
                };
                if(max.val > 0){
                    L.circle([max.latitudine, max.longitudine], {
                        color: max.color,
                        fillColor: max.color,
                        fillOpacity: 0.5,
                        radius: 300
                    }).bindPopup(max.stazione).addTo(map);
                }
            }
            var legend = L.control({position: 'bottomright'});
            legend.onAdd = function (map) {
                var div = L.DomUtil.create('div', 'info legend');
                var grades = ["Ottima", "Buona", "Discreta", "Scadente", "Pessima"];
                var colors = ["#0000ff", "#009900", "#ffff00", "#ff0000", "#cc0099"];
                for (var i = 0; i < grades.length; i++) {
                    div.innerHTML +=
                            '<i style="background:' + colors[i] + '"></i> ' +
                            grades[i] + '<br>';
                }
                return div;
            };
            legend.addTo(map);
            spinner.stop();
    </script>
</main>