<%@ include file="navigation.jsp" %>
<main>
    <style>
      html, body, #canvas {
        height: 100%;
        padding: 0;
        margin: 0;
      }
      .diagram-note {
        background-color: rgba(66, 180, 21, 0.7);
        color: White;
        border-radius: 5px;
        font-family: Arial;
        font-size: 12px;
        padding: 5px;
        min-height: 16px;
        width: 50px;
        text-align: center;
      }
     .highlight:not(.djs-connection) .djs-visual > :nth-child(1) {
        fill: green !important; /* color elements as green */
     }
    </style>
    <div class="card card-cascade">

        <!-- Card image -->
        <div class="view gradient-card-header blue-gradient">

            <!-- Title -->
            <h2 class="card-header-title mb-3">Valutazione</h2>
            <!-- Subtitle -->
            <p class="card-header-subtitle mb-0">Prima valutazione del paziente</p>

        </div>

        <!-- Card content -->
        <div class="card-body text-center">



            <div class="text-center mt-4 mb-2">
                <button type="submit" name="submit" class="btn btn-primary">Avanti
                    <i class="fa fa-caret-square-o-right ml-2"></i>
                </button>
            </div>
        </div>

    </div>
    
    <br>
    
    <form id="uploadPdta" class="md-form">
    <div class="file-field">
        <div class="btn btn-primary btn-sm float-left">
            <span>Scegli PDTA</span>
            <input id="pdta" type="file" required>
        </div>
        <div class="file-path-wrapper">
            <input class="file-path validate" type="text" placeholder="Carica il tuo PDTA" >
        </div>
    </div>
    <div class="text-center mt-4 mb-2">
        <button type="submit" name="submit" class="btn btn-primary">Carica
            <i class="fa fa-upload ml-2"></i>
        </button>
    </div>    
    </form>
    
    <div id="canvas" style="height: 3000px;"></div> 
    
    <script>
      var bpmnViewer = new BpmnJS({
        container: '#canvas'
      });  
      
       $('.bjs-powered-by').hide();
        
      function openDiagram(bpmnXML) {
        // import diagram
        bpmnViewer.importXML(bpmnXML, function(err) {
          if (err) {
            return console.error('could not import BPMN 2.0 diagram', err);
          }
          // access viewer components
          var canvas = bpmnViewer.get('canvas');
                    
          // add marker
          canvas.addMarker('Task_1hdc93y', 'highlight');
        });
      }
      
      function loadFileAsText(){
          
        var fileToLoad = document.getElementById("pdta").files[0];

        var reader = new FileReader;
        reader.readAsText(fileToLoad);
        reader.onload = function(e) {
        var rawLog = reader.result;
        console.log(rawLog);
        openDiagram(rawLog);
        };
   }
      
      $('#uploadPdta').on('submit', function () {
            loadFileAsText();
            return false;
      });
      
    </script>
</main>