# datalogiUppgift1

<h1>Datalogi - uppgift 1 – Arrays</h1>

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
		<td>Funktionell programmering</td>
		<td>Eleven programmerar funktionellt <strong>med viss säkerhet.</strong> Genomtänkt struktur och programmeringsval finns i delar av programmet.</td>
		<td>Eleven programmerar funktionellt <strong>med säkerhet</strong>. Genomtänkt struktur och programmeringsval finns genomgående i hela programmet.</td>
	</tr>
	<tr>
		<td>Kodkvalitet</td>
		<td>Elevens program uppvisar god kodkvalitet.</td>
		<td></td>
	</tr>
</table>
</article>

<p>
	<strong>Ni skall jobba 2 och 2. Inlämning skall ske i form av två textdokument, ett för koden och ett för er output. Dokumenten skall döpas till era namn samt uppgift 1. Inlämning senast kl 16:00 fredag den 8/2.</strong>
</p>

<article>
	<h2>Uppgift 1 - Arrays</h2>
	<p>char[] charArray1 = { ’s’, ’t’, ’r’, ’i’, ’n’, ’g’};</p>
	<p>char[] charArray2 = { ’s’, ’i’, ’n’, ’g’};</p>
	<p>detectTInArray(charArray1);</p>
	<p>detectTInArray(charArray2);</p>
</article>

<article>
	<p>Bygg ett program som kan ta emot en Array med bokstäver. Programmet skall kontrollera om input innehåller ett ’t’. Om programmet hittar ett ’t’ skall programmet skriva true till skärmen annars false. Programmet skall även hantera om inputen ändras till andra char arrays.</p>
	<p>När detta är byggt och fungerar korrekt kan ni börja utveckla programmet genom delpunkterna nedan.<strong>Kom ihåg att printa ut charArray1 och charArray2 samt vilken delpunkt till skärmen efter varje delpunkt fram till e). Detta skall vara en egen funktion.</strong></p>
</article>

<article>
	<ol type="a">
		<li>Programmet skall nu även ändra alla ’r’ den hittar till ’t’.</li>
		<li>Programmet skall efter att den har skrivit ut true hitta ’t’ fältet och ändra det till stor bokstav. Koden för detta skall stå i en separat metod som anropas från inuti detectTInArray().
Exempelvis: toUppercase(char[] x);</li>
		<li>Nu skall ni skapa en metod som tar bort dubbletter i er array. Denna metod skall kallas i slutet av detectTInArray().</li>
		<li>Skapa en funktion som jämför charArray1 och charArray2 och ser om de är lika. Om så är fallet skall programmet skriva ut ”Array 1 and Array 2 are identical”. Denna funktion skall anropas i början av programmet men efter anropen till detectTInArray() är gjorda.</li>
		<li>Programmet skall nu få ett inputfält. Fältet skall ta emot alla former av input men input skall kontrolleras och sedan sättas in i en char array med längd 3. Om denna array är fylld skall programmet fråga om ny input. I denna input skall en siffra skrivas in för vilken plats i er array som skall ersättas med det nya värdet. Programmet skall därefter sätta in det nya värdet på begärd plats och skriva ut er array. När detta är gjort skall programmet begära ny input om input är tom skall programmet brytas.</li>
		<li>Skapa en String-array med en plats. Efter att programmet har satt in ett nytt värde i <strong>e)</strong> skall en ny metod anropas som sätter samtliga värden från <strong>e)</strong> på en plats i er nya String array. Detta skall ske varje gång en ny input kommer in men från och med att input nr 2 och framåt skall er String arrays platser öka och värdet skall föras in på den nya platsen. Skriv sedan ut er array.</li>
		<li>Från metoden i <strong>f)</strong> skall en ny metod anropas varje gång ett nytt värde sätts in i er String array. Metoden skall vara funktionell och använda rekursion. Metoden skall skriva ut samtliga värden i er String array till skärmen. Texten skall skrivas ut som en String.</li>
		<li>(Extra uppgift)<br>
			Nu skall ni bygga in ett val i början av programmet. Antingen kan man starta programmet så tidigare med ett input fält alternativt ges ett input fält där en enbart en <strong>int</strong> får anges. Därefter skall programmet köras som tidigare men istället för user input skall det vara random input från alfabetet <strong>X</strong> gånger där <strong>X</strong> är int värdet i input. När detta fungerar testa gärna att pressa gränserna på ert program och fundera över vart och varför kommer programmet få problem när ni ökar er <strong>int</strong>?</li>
		<li></li>
	</ol>
</article>