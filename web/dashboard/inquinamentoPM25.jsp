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
            <h2 class="card-header-title mb-3">PM 2.5 è una classificazione numerica data alle polveri sottili in base alla loro grandezza.</h2>
            <!-- Subtitle -->
            <p class="card-header-subtitle mb-0">La mappa presenta delle sfumature di colore arancione che rappresentano la classificazione numerica data alle polveri sottili in base alla loro grandezza.</p>
            <p class="card-header-subtitle mb-0">In evidenza le province della calabria con la rispettivia popolazione aggiornata fino al 2016 e i comuni con i rispettivi numeri di incidenza.</p>

        </div>

        <!-- Card content -->
        <div class="card-body text-center">

            <div class="text-center mt-4 mb-2">
                <div id="mapid1" class="leaflet-container leaflet-touch leaflet-fade-anim leaflet-grab leaflet-touch-drag leaflet-touch-zoom" style="height: 500px;width: auto;"></div>
            </div>
        </div>

    </div>
    <script>
        var map1 = L.map('mapid1');
        var osmUrl='https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png';
        var osm = new L.tileLayer.wms('http://sedac.ciesin.columbia.edu/geoserver/wms?', {
                layers: 'sdei:sdei-global-annual-gwr-pm2-5-modis-misr-seawifs-aod_2015'
            }, {minZoom: 6, maxZoom: 15});
        map1.setView(new L.LatLng("39.0565974","16.5249864"), 8);
        map1.addLayer(osm);
        map1.attributionControl.addAttribution('Map dati © Baseline');
        map1.options.minZoom = 6;
        map1.options.maxZoom = 15;
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
            
    </script>
</main>