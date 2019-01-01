/*
    Allt som har med inloggning och dess knappar att göra, ligger i dennna filen
 */

/*********************************  Databaser *********************************/
// Användare
let database = [
    {
        username: "Mickey",
        password: "Mouse"
    },
    {
        username: "Lars",
        password: "12345"
    },
    {
        username: "Jerry",
        password: "12345"
    }
];
// Nyheter
let newsFeed = [
    {
        news: "Nya recept har inkommit",
        date: "2018-12-05"
    },
    {
        news: "Man kan nu logga in och registrera nya användare",
        date: "2018-12-03"
    },
    {
        news: "Vår nya domän är online",
        date: "2018-12-01"
    }
];

/****************************  Inloggningsknappar *****************************/
// Börja med att sätta en flagga om att man inte är inloggad och skapa en contaner för vem som är inloggad
let loggedIn = false;
let loggedInUser = '';

// Visa olika knappar beroende på om man är inloggad eller ej
function loginKnappar() {
    if (loggedIn === false){
        document.getElementById('loginButtons').innerHTML = "<button type=\"button\" id=\"befintlig\">Logga in</button><button type=\"button\" id=\"registerUser\">Registrera</button><button type=\"button\" id=\"hideUser\">Dölj</button>";
    } else {
        document.getElementById('loginButtons').innerHTML = "<button type=\"button\" id=\"logout\">Logga ut</button>";
    }
}
// functionen loginKnappar ska köras vid start!
loginKnappar();

// Fånga knapptryck
// Sign-in User
$('body').on('click', '#befintlig', function () { $( "#signIn" ).load( "../ajax/signIn.html" ); } );
// Register User
$('body').on('click', '#registerUser', function () { $( "#signIn" ).load( "../ajax/signInNewUser.html" ); } );
// Hide User
$('body').on('click', '#hideUser', function () { $( "#signIn" ).empty(); } );
// När man klickar på Logga ut så ska loggedIn = false och köra "Funktionen loginKnappar"
$('body').on('click', '#logout', function () {
    loggedIn = false;
    loginKnappar();
    $( "#signIn" ).empty();
    $( "#recention" ).empty();
} );

/*****************************  Databas med betyg *****************************/
/****************************  Inloggningskontroll ****************************/
// Kontrollera användarnamnet mot databasen "database"
function login(){
    let username = document.getElementById('userName').value;
    let password = document.getElementById('userPassword').value;

    for(let i = 0; i < database.length; i++) {
        // check is user input matches username and password of a current index of the database array
        if(username === database[i].username && password === database[i].password) {
            loggedIn = true;
            loginKnappar();
            // Ladda Nyheter
            let newsOutput ='<h2>Nyheter</h2>';
            for (let j = 0 ; j < newsFeed.length ; j++){
                newsOutput += "<h3><em>" + newsFeed[j].date + "</em></h3>" + "<p>" + newsFeed[j].news + "</p>";
            }
            document.getElementById('signIn').innerHTML = newsOutput;
            loggedInUser = username;

            // Använder localstorage för att hålla reda på vilken sidda jag är på och ladda in rätt Recensionsruta
            if (localStorage.getItem("aktuellSida") === bakning){
                bakningRecentionsRuta();
            } else if (localStorage.getItem("aktuellSida") === kallDessert){
                kallDessertRecentionsRuta();
            } else if (localStorage.getItem("aktuellSida") === varmDessert){
                varmDessertRecentionsRuta();
            } else {
                fiskRecentionsRuta();
            }

            return
        }
    }
    alert("incorrect username or password");



}

// När ajax adderar innehåll som ändrar innehållet i en container så måste man gå via body istället
$('body').on('click', '#loginUserSubmit', login );

// Registrera ny användare
// email används ej i databasen men finns med för kontrollsyfte
function register(){
    let username = document.getElementById('newUserName').value;
    let email = document.getElementById('newUserEmail').value;
    let password = document.getElementById('newUserPassword').value;

    // Lägg till i databasen
    database.push({ username: username, password: password });
}
// Registrera användare
$('body').on('click', '#createUserSubmit', register );