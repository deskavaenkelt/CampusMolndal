# Lönesystem
Ni skall bygga ett lönesystem. Under utvecklingens gång skall ni skapa tester och köra tester mot systemet. Vilka tester ni använder och varför skall dokumenteras.

## Dokumentation
Dokumentet skall bestå av:
* Projektplanering utifrån TDD.
* Testkrav.
* Vilka tester som ni tar med i projektet och varför.
* Resultat av tester.
* Utvärdering av refaktorering.
* Utvärdering av kvalitetssäkring.

# Programmet
Programmet skall uppfylla följande krav:
1. Har du som användare ett konto då skall det gå att logga in med dina uppgifter.
2. Inne i systemet skall du som användare kunna:
   * Se sitt bank-kontos saldo.
   * Aktuell lön.
   * Roll i företaget.
   * Begära ändring av roll eller aktuell lön.
   * Ta bort sin egna användare genom att skriva in sitt användarnamn och lösenord.
3. Det skall gå att logga in som admin i systemet med user: admin1 och psw: admin1234.
4. Som admin i systemet ska du kunna:
   * Allt som användare kan göra förutom d och e.
   * Se aktuella användare och deras lösenord.
   * Se om användare har begärt ändring av roll eller lön och i så fall ändra dessa värden.
   * Avancera system en månad så att lön betalas ut till användare.
   * Admin skall kunna skapa användare lokalt. Användare skall ha användarnamn och lösenord, dessa måste bestå av både text och siffror.
   * Ta bort användare från systemet genom att skriva ett användarnamn och tillhörande lösenord.
5. I programmet skall det finnas en arvsstruktur i form av account(parent), admin(child) och user(child). Det är fritt att välja hur hierarkin ska se ut.

## Tester
Unit-tester måste finnas med i detta projekt men utöver det så är det upp till er vilka tester ni vill använda er av och hur dessa skall struktureras. Minst 4 testvarianter skall vara med exklusive unit tester.
