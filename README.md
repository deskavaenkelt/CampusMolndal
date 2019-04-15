# Uppgift 2 – Primtal

<article>
<table>
	<tr>
		<th>Område</th>
		<th>G-nivå</th>
		<th>VG-nivå</th>
	</tr>
	<tr>
		<td>Skriva algoritmer</td>
		<td>Eleven kan <strong>med viss säkerhet</strong> skriva algoritmer. En del av algoritmerna samt funktionerna uppvisar genomtänkt struktur.</td>
		<td>Eleven kan <strong>med säkerhet</strong> skriva algoritmer. Samtliga algoritmer samt funktioner uppvisar genomtänkt struktur. </td>
	</tr>
	<tr>
		<td>Förklara algoritmer</td>
		<td>Eleven kan <strong>översiktligt</strong> förklara hur en algoritm fungerar.</td>
		<td>Eleven kan <strong>utförligt</strong> förklara hur en algoritm fungerar.</td>
	</tr>
	<tr>
		<td>Kodkvalitet</td>
		<td>Elevens program uppvisar god kodkvalitet.</td>
		<td></td>
	</tr>
</table>
</article>

<article>
    <h2>I denna uppgift arbetar du ensam och inlämning är senast 23:59 Fredagen 15:e Februari.</h2>
</article>

<article>
	<h2>Introduktion</h2>
	<p>Ett primtal är ett tal som är större än 1 och kan enbart delas med 1 eller en positiv version av sig själv. Tex 2, 3 och 5 är primtal.</p>
	<ul>
		<li>Programmet kommer jobba med primtal, sorteringar och sökningar. </li>
		<li>Programmet kommer behöva en datastruktur som du jobbar med. Vilken datastruktur du väljer är upp till dig.</li>
		<li>Det som står efter (Extra) är inte nödvändigt för ett godkänt betyg men ökar chanserna betydligt för ett väl godkänt.</li>
	</ul>
</article>

<article>
	<h2>Program</h2>
	<p>Initialt skall programmet visa tre alternativ, ”Add”, ”Sort” och ”Search”. Efter att ett val har angivits kommer den köra följande:</p>
	<ul>
		<li><strong>Add</strong> kör: <strong>a) b) c) d)</strong></li>
		<li><strong>Sort</strong> kör: <strong>e)</strong></li>
		<li><strong>Search</strong> kör: <strong>f)</strong></li>
	</ul>
	<p>Efter detta skall programmet återgå till det initiala läget. Läget skall ha något sätt att avsluta programmet och det skall visas för användaren.</p>
</article>

<article>
	<p><strong>Add:</strong></p>
	<ul>
		<li><strong>a) </strong>Skapa ett input fält som sparas i en String. Ett alternativ kan vara en inputDialog. Detta fält skall kunna ta emot all form av input men enbart godkänna input av typen <strong>int</strong>. Om typen inte är en <strong>int</strong> skall programmet återgå till input fältet. </li>
		<li><strong>b) </strong>Programmet skall nu kontrollera den givna inputen om det är ett primtal som har angivits. Om så är fallet skall programmet spara siffran på en ny plats i din datastruktur.</li>
		<li><strong>c) </strong>Nu skall programmet även kontrollera om input som skall sättas in i datastrukturen redan finns. Om så är fallet skall programmet inte sätta in det angivna värdet utan istället meddela användaren: ”The given input already exists”.</li>
		<li><strong>d) </strong>Programmet skall nu addera samtliga värden i datastrukturen och placera summan i en variabel. Variabeln skall kontrolleras om den är ett primtal. Om så är fallet skall den sättas in på en ny plats i din datastruktur. <strong>(Extra)</strong> Om ett nytt värde sätts in skall processen upprepas.</li>
	</ul>
</article>

<article>
	<p><strong>Sort:</strong></p>
	<ul>
		<li><strong>e) </strong>Programmet skall via en separat metod sortera datastrukturen. En utskrift av datastrukturen skall ske innan och efter sortering. <strong>(Extra)</strong> Bubblesort får inte användas. Lägg en kommentar inne i programmet vilken sortering du använder.</li>
	</ul>
</article>

<article>
	<p><strong>Search:</strong></p>
	<ul>
		<li><strong>f) </strong>En sökruta skall nu visas för användaren. Vid input skall programmet kontrollera om det givna värdet finns i datastrukturen. Om den hittar värdet skall den visa det för användaren genom ”X was found”.  Hittar den inte värdet skall den istället ge responsen ”X was not found”. <strong>(Extra)</strong> Dessutom om den inte hittar det angivna värdet skall den istället återge det närmsta värdet som finns, om det finns värden i datastrukturen.</li>
	</ul>
</article>

<article>
	<p><strong>(Extra)</strong></p>
	<ul>
		<li><strong>g) </strong>Öka antalet alternativ i ditt initiala läge till fyra alternativ. Det nya alternativet skall fråga om hur många nya primtal användaren vill hitta och endast ta emot input av typen <strong>int</strong> i sitt input fält. Programmet skall därefter hitta det högsta värdet i datastrukturen och leta efter <strong>x</strong> nya primtal med högre värde och sätta in dessa i datastruktruen.</li>
	</ul>
</article>
