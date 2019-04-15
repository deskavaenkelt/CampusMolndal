// Allt som har med navbar och recension att göra, ligger i dennna filen

/**************************  Databas med recensioner **************************/

let recensionBakn = [
    {
        user: "Mickey",
        text: "Trevligt bakning"
    },
    {
        user: "Lars",
        text: "Trevligare bakning"
    }
];
let recensionKall = [
    {
        user: "Mickey",
        text: "Trevlig kall dessert"
    },
    {
        user: "Lars",
        text: "Trevligare kall dessert"
    }
];
let recensionVarm = [
    {
        user: "Mickey",
        text: "Trevlig varm dessert"
    },
    {
        user: "Lars",
        text: "Trevligare varm dessert"
    }
];
let recensionFisk = [
    {
        user: "Mickey",
        text: "Trevlig fisk"
    },
    {
        user: "Lars",
        text: "Trevligare fisk"
    }
];

/**********************************  Navbar  **********************************/

// Funktioner för de olika knapparna
function start() {
    // Startsida läsens in med javascript
    localStorage.setItem("aktuellSida", "start");
    document.getElementById("result").innerHTML = localStorage.getItem("aktuellSida");
    "use strict";
    /* Sätt "start" till active class */
    $(".active").removeClass("active");
    $("#menyStart").addClass("active");
    /* Läs in JSON med javascript */
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            let response = JSON.parse(xhttp.responseText);
            let starttext = response.start;
            //
            let output = '<img src="../img/husmor.jpg" alt="Bild på husmor" id="husmor">';
            for (let i = 0 ; i < starttext.length ; i++){
                output += '<article>';
                output += '<h2>' + starttext[i].rubrik + '</h2>';
                output += '<p>' + starttext[i].brodtext + '</p>';
                output += '</article>';
            }
            document.getElementById('info-box').innerHTML = output;
        }
    };
    xhttp.open("GET", '../data/start.json', true);
    xhttp.send();
}
function bakning() {
    localStorage.setItem("aktuellSida", "bakning");
    document.getElementById("result").innerHTML = localStorage.getItem("aktuellSida");
    /* Sätt active class */
    $( ".active" ).removeClass( "active");
    $( "#menyBakning" ).addClass( "active");
    /* Skapa grid som recept läggs i */
    let output = outputFunction();
    /* Läs in JSON data 0 = bakning*/
    lasInJsonData("0");
    /* Skicka informationen till #info-box */
    $('#info-box').html(output);
    // RecensionsRuta nedanför
    bakningRecentionsRuta();
}
function kallDessert() {
    localStorage.setItem("aktuellSida", "kallDessert");
    document.getElementById("result").innerHTML = localStorage.getItem("aktuellSida");
    $( ".active" ).removeClass( "active");
    $( "#menyKallDessert" ).addClass( "active");
    let output = outputFunction();
    /* Läs in JSON data 1 = KallDessert */
    lasInJsonData("1");
    $('#info-box').html(output);
    kallDessertRecentionsRuta();
}
function varmDessert() {
    localStorage.setItem("aktuellSida", "varmDessert");
    document.getElementById("result").innerHTML = localStorage.getItem("aktuellSida");
    $( ".active" ).removeClass("active");
    $( "#menyVarmDessert" ).addClass("active");
    let output = outputFunction();
    /* Läs in JSON data 2 = VarmDessert*/
    lasInJsonData("2");
    $('#info-box').html(output);
    varmDessertRecentionsRuta();
}
function fisk() {
    localStorage.setItem("aktuellSida", "fisk");
    document.getElementById("result").innerHTML = localStorage.getItem("aktuellSida");
    $( ".active" ).removeClass("active");
    $( "#menyFisk" ).addClass("active");
    let output = outputFunction();
    /* Läs in JSON data 3 = Fisk */
    lasInJsonData("3");
    $('#info-box').html(output);
    fiskRecentionsRuta();
}
// Gemensama funktioner för ovan
function outputFunction() {
    let output =    "<div id=\"recept-grid\">" +
        "<div id=\"receptBild\"></div>" +
        "<div id=\"receptIngredienser\"><h2>Ingredienser</h2><ul id=\"ingredienser\"></ul></div>" +
        "<div id=\"receptTillagning\"><h2>Gör så här</h2><ol id=\"tillagning\"></ol></div>" +
        "</div>";
    return output;
}
function lasInJsonData(val) {
    $.getJSON('../data/bakning.json', function (data){
        let bild = data.bakning[val].bild;
        let titel = data.bakning[val].titel;
        let beskrivning = data.bakning[val].beskrivning;
        let ingredienser =data.bakning[val].ingredienser;
        let tillagning = data.bakning[val].tillagning;
        $('#receptBild').append($("<img id='receptBilden' alt='Bild på sill med äpple rödbeta och pepparrot.' src='" + bild + "'>" + "<h2>" + titel + "</h2>" + "<h3>" + beskrivning + "</h3>"));
        $(ingredienser).each(function (i, item) { $('#ingredienser').append($("<li>").append(item)); });
        $(tillagning).each(function (i, item) { $('#tillagning').append($("<li>").append(item)); });
    }, 'html');
}

/********************************  Recensioner  *******************************/

// Tar fram recentionsrutan på varje sida
// Anropar huvudfunktionen som har 3 underfunktioner
function bakningRecentionsRuta() {
    let gamlaPoster = lasIngamlaPoster(recensionBakn);
    // Läs in recensinsRuta (div)
    let recensionsRuta = fyllPaRecentionsruta(gamlaPoster, 'betygBakning', 'skickarRecensionBakning');
    skickaRecentionsdataTillRecentionsruta(recensionsRuta);
}
function kallDessertRecentionsRuta() {
    let gamlaPoster = lasIngamlaPoster(recensionKall);
    let recensionsRuta = fyllPaRecentionsruta(gamlaPoster, 'betygKall', 'skickarRecensionKall');
    skickaRecentionsdataTillRecentionsruta(recensionsRuta);
}
function varmDessertRecentionsRuta() {
    let gamlaPoster = lasIngamlaPoster(recensionVarm);
    let recensionsRuta = fyllPaRecentionsruta(gamlaPoster, 'betygVarm', 'skickarRecensionVarm');
    skickaRecentionsdataTillRecentionsruta(recensionsRuta);
}
function fiskRecentionsRuta() {
    let gamlaPoster = lasIngamlaPoster(recensionFisk);
    let recensionsRuta = fyllPaRecentionsruta(gamlaPoster, 'betygFisk', 'skickarRecensionFisk');
    skickaRecentionsdataTillRecentionsruta(recensionsRuta)
}
// Delar till varje recencionsruta
function fyllPaRecentionsruta(inGamlaPoster, vilketBetyg, vilkenRecensionSkaSkickas){
    let recensionsRuta =    '<h2> Recensionsdel </h2><textarea rows="4" cols="50" id="' + vilketBetyg + '">Skriv in text</textarea><br>' +
        '<button type="button" id="' + vilkenRecensionSkaSkickas + '">Skicka recension</button><div id="skickadeBetygBakning"></div>' +
        inGamlaPoster;
    return recensionsRuta;
}
function lasIngamlaPoster(recention){
    let gamlaPoster = '<h2>Tidigare recensioner:</h2>';
    for (let i=0 ; i < recention.length ; i++){
        gamlaPoster += '<div class="recIndelning"><p>' + recention[i].text + '</p>'  + '<p><strong>Skrivet av: </strong>' + recention[i].user + '</p></div><br>';
    }
    return gamlaPoster;
}
function skickaRecentionsdataTillRecentionsruta(inRecensionsRuta) {
    if (loggedIn === true){
        $('#recention').html(inRecensionsRuta);
    } else {
        $( "#recention" ).empty();
    }
}

// Skicka in recencion vid knapptryck
$('body').on('click', '#skickarRecensionBakning', function () {
    // Det som finns i textArea ska lagras i en variabel "recention"
    let recention = document.getElementById('betygBakning').value;
    // Lägg till i databasen
    recensionBakn.push({ user: loggedInUser, text: recention });
    // Ladda om rutan
    bakningRecentionsRuta();
} );
$('body').on('click', '#skickarRecensionKall', function () {
    let recention = document.getElementById('betygKall').value;
    recensionKall.push({ user: loggedInUser, text: recention });
    kallDessertRecentionsRuta();
} );
$('body').on('click', '#skickarRecensionVarm', function () {
    let recention = document.getElementById('betygVarm').value;
    recensionVarm.push({ user: loggedInUser, text: recention });
    varmDessertRecentionsRuta();
} );
$('body').on('click', '#skickarRecensionFisk', function () {
    let recention = document.getElementById('betygFisk').value;
    recensionFisk.push({ user: loggedInUser, text: recention });
    fiskRecentionsRuta();
} );

// Reagera när man klicka på menyn
$("#menyStart").on("click", function () {
    $( "#recention" ).empty();
    start();
});      // Kör samma script om någon trycker på start (jQuery)
$( "#menyBakning").on( "click", bakning );
$( "#menyKallDessert").on( "click", kallDessert );
$( "#menyVarmDessert").on( "click", varmDessert );
$( "#menyFisk").on( "click", fisk );

// Topp 5 länkar (ligger här av bekvämlighetsskäl)
$('body').on('click', '#receptLank1', bakning );
$('body').on('click', '#receptLank2', kallDessert );
$('body').on('click', '#receptLank3', varmDessert );
$('body').on('click', '#receptLank4', fisk );
$('body').on('click', '#receptLank5', start );

// Kör vid laddning av sidan
start();