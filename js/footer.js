// Läses in med JSON
function footer() {
    $.getJSON('../data/bakning.json', function (data){
        $('#foot1').append($("<h2>" + data.bakning[0].titel + "</h2>" + "<p>" + data.bakning[0].beskrivning + "</p>"));
        $('#foot2').append($("<h2>" + data.bakning[1].titel + "</h2>" + "<p>" + data.bakning[1].beskrivning + "</p>"));
        $('#foot3').append($("<h2>" + data.bakning[2].titel + "</h2>" + "<p>" + data.bakning[2].beskrivning + "</p>"));
        $('#foot4').append($("<h2>" + data.bakning[3].titel + "</h2>" + "<p>" + data.bakning[3].beskrivning + "</p>"));
    }, 'html');
}
window.onload = footer();