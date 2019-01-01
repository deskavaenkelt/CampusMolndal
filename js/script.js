// JavaScript Document
// Lagra vilken sida vi är på
localStorage.setItem("aktuellSida", "start");
// Hämta sida
document.getElementById("result").innerHTML = localStorage.getItem("aktuellSida");
