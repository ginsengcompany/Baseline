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
            <h2 class="card-header-title mb-3">Fattori Inquinanti</h2>
            <!-- Subtitle -->
            <p class="card-header-subtitle mb-0">Global Annual PM2.5 Grids from MODIS, MISR and SeaWiFS Aerosol Optical Depth (AOD) with GWR, v1 (1998-2016).</p>
            <p class="card-header-subtitle mb-0">Il PM 2,5 è una classificazione numerica data alle polveri sottili in base alla loro grandezza. Più il numero è minore e più sottili sono le polveri e dunque più pericolose per la salute della specie umana ed animale.</p>
            

        </div>

        <!-- Card content -->
        <div class="card-body text-center">

            <div class="text-center mt-4 mb-2">
                <div id="mapid1" class="leaflet-container leaflet-touch leaflet-fade-anim leaflet-grab leaflet-touch-drag leaflet-touch-zoom" style="height: 500px;width: auto;"></div>
            </div>
        </div>

    </div>
 <!--  
    <div class="card card-cascade">

        <div class="view gradient-card-header blue-gradient">

            <h2 class="card-header-title mb-3">Fattori Inquinanti</h2>

            <p class="card-header-subtitle mb-0">Global Annual PM2.5 Grids from MODIS, MISR and SeaWiFS Aerosol Optical Depth (AOD) with GWR, v1 (1998-2016).</p>
            <p class="card-header-subtitle mb-0">Il PM 2,5 è una classificazione numerica data alle polveri sottili in base alla loro grandezza. Più il numero è minore e più sottili sono le polveri e dunque più pericolose per la salute della specie umana ed animale.</p>
            

        </div>


        <div class="card-body text-center">

            <div class="text-center mt-4 mb-2">
                <div id="mapid2" class="leaflet-container leaflet-touch leaflet-fade-anim leaflet-grab leaflet-touch-drag leaflet-touch-zoom" style="height: 500px;width: auto;"></div>
            </div>
        </div>

    </div> -->
    <script>
        var map1 = L.map('mapid1');
        var osmUrl='https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png';
        var osmAttrib = 'Map dati © Baseline';
        var osm = new L.tileLayer.wms('http://sedac.ciesin.columbia.edu/geoserver/wms?', {
                layers: 'sdei:sdei-global-annual-gwr-pm2-5-modis-misr-seawifs-aod_2015'
            }, {minZoom: 6, maxZoom: 15, attribution: osmAttrib});
        map1.setView(new L.LatLng("40.9296228", "14.5373564"), 6);
        map1.addLayer(osm);
        function onEachFeature(feature, layer) {
            layer.bindPopup(feature.properties.name_2 + "<br> popolazione: " + feature.properties.popolazione);
            layer.on('mouseover', function (e) {
                this.openPopup();
            });
            layer.on('mouseout', function (e) {
                this.closePopup();
            });
        }
        var basemaps = {
            'PM2.5 Grids with GWR_2000': L.tileLayer.wms('http://sedac.ciesin.columbia.edu/geoserver/wms?', {
                layers: 'sdei:sdei-global-annual-gwr-pm2-5-modis-misr-seawifs-aod_2000'
            }),

            'PM2.5 Grids with GWR_2005': L.tileLayer.wms('http://sedac.ciesin.columbia.edu/geoserver/wms?', {
                layers: 'sdei:sdei-global-annual-gwr-pm2-5-modis-misr-seawifs-aod_2005'
            }),

            'PM2.5 Grids with GWR_2010': L.tileLayer.wms('http://sedac.ciesin.columbia.edu/geoserver/wms?', {
                layers: 'sdei:sdei-global-annual-gwr-pm2-5-modis-misr-seawifs-aod_2010'
            }),

            'PM2.5 Grids with GWR_2015': L.tileLayer.wms('http://sedac.ciesin.columbia.edu/geoserver/wms?', {
                layers: 'sdei:sdei-global-annual-gwr-pm2-5-modis-misr-seawifs-aod_2015'
            })
        };

        //L.control.layers(basemaps, {}, {collapsed: false}).addTo(map1);
        var legend = L.control({position: 'bottomright'});
        legend.onAdd = function (map1) {
            var div = L.DomUtil.create('div', 'info legend');
            var grades = ["No Data", "0 (micrograms per m3)", "0-2", "2-5", "5-10", "10-20", "20-25", "25-50", "50-100", "> 100"];
            var colors = ["#ffffff", "#feead6", "#fee6ce", "#fdd0a2", "#fdae6b", "#fd8d3c", "#f16913", "#d94801", "#a63603", "#7f2704"];
            for (var i = 0; i < grades.length; i++) {
                div.innerHTML +=
                        '<i style="background:' + colors[i] + '"></i> ' +
                        grades[i] + '<br>';
            }
            return div;
        };
        legend.addTo(map1);
        var comuni;
        comuni = <%=request.getAttribute("comuni")%>;
        var markers = L.markerClusterGroup({
                showCoverageOnHover : false,
                zoomToBoundsOnClick : true
            });
        for(var i=0;i<comuni.length;i++){
            var marker = L.marker(new L.LatLng(comuni[i].coordinate.latitudine,comuni[i].coordinate.longitudine)).bindPopup(comuni[i].nome + "<br>Incidenza: " + comuni[i].incidenza);
            markers.addLayer(marker);
        }
        map1.addLayer(markers);
        legend.addTo(map1);
        var provinceCalabria;
        provinceCalabria = <%=request.getAttribute("provinceCalabria")%>;
        L.geoJSON(provinceCalabria,{
                onEachFeature: onEachFeature
        }).addTo(map1);
            
        // MAP 2
        /*
        var inquinaPm25, stazioni;
            inquinaPm25 = <%=request.getAttribute("pm25")%>;
            stazioni = <%=request.getAttribute("luoghi")%>;
            var map2 = new L.map('mapid2');
            var osmUrl='https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png';
            var osmAttrib = 'Map dati © Baseline';
            var osm = new L.TileLayer(osmUrl, {minZoom: 6, maxZoom: 15, attribution: osmAttrib});
            map2.setView(new L.LatLng("40.9296228","14.5373564"),6);
            map2.addLayer(osm);
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
            var spinner = new Spinner(optionsLoadBar).spin(document.getElementById("mapid2"));
            var inquinamentoPerStazioni = {};
            for(var prop in stazioni.luoghi){
                for(var i=0; i < inquinaPm25.length; i++){
                    if(prop === inquinaPm25[i].stazione && inquinaPm25[i].IQA){
                        inquinamentoPerStazioni[prop] = stazioni.luoghi[prop];
                        inquinamentoPerStazioni[prop].IQA = inquinaPm25[i].IQA;
                        inquinamentoPerStazioni[prop].color = inquinaPm25[i].color;
                        inquinamentoPerStazioni[prop].stazione = inquinaPm25[i].stazione;
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
                    }).bindPopup(max.stazione).addTo(map2);
                }
            }
            var legend2 = L.control({position: 'bottomright'});
            legend2.onAdd = function (map2) {
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
            legend2.addTo(map2); 
            spinner.stop(); */
            
    </script>
</main>