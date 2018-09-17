package com.javainlamningsuppgift1vg;
import java.util.Scanner;
public class JavaInlamningsuppgift1Vg {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        char spela = 'j';

        System.out.print("Hur många spelare skall det vara? ");
        int deltagare = scan.nextInt();

        // Spelararrayen skapas
        int spelare[] = new int[deltagare];                         // Används för att numrera spelare
        String spelarNamn[] = new String[deltagare];                // Används för att döpa spelare

        for(int i = 0 ; i <= deltagare ; i++){                      // Hur löser jag att string börjar på 0 och inte 1?
            System.out.print("Namn på spelare " + i + ": ");        // Ger dubla utskrifter på första spelaren, varför?
            spelarNamn[i] = scan .nextLine();
        }

        System.out.print("Hur många kast skall spelas? ");
        int antalKast = scan.nextInt();

        // Skicka spelare j till tärningen och spara summan i spelare[deltagare]
        for(int j ; j <= deltagare ; j++){

        }

    }
    // (4) Skapar tärningskasten för spelarna, Printar dem och gör "return" på summan.
    private static int tarning(int inAntalKast, String inSpelarNamn){
        // int antalKast = inAntalKast;
        int antalSidor = 6;
        int summa = 0;
        System.out.println(inSpelarNamn + ":");
        for(int i=1 ; i <= inAntalKast ; i++){
            int kast = (int) (1+antalSidor*Math.random());
            System.out.println("Kast "+ i + " gav: " + kast);
            summa += kast;
        }
        System.out.print("\n");
        return summa;
    }
}
/*
// (1) Programet avslutas inte förens det akivt väljs.
        char spela = 'j';
        // Bonus
        System.out.print("Skriv in ditt namn: ");
        String spelarNamn = scan.nextLine();
        System.out.print("\nHej " + spelarNamn + " du kommer att spela mot Datorn. \n");

        do{
            // (2) Antal kast
            System.out.print("\nVälj antal kast som ska spelas: ");
            int antalKast = scan.nextInt();
            System.out.print("\n");

            // (3) Spelare skickar antalKast till tarning()
            int summaSpelare = 0;
            summaSpelare += tarning(antalKast, spelarNamn);

            // (4) Dator skickar antalKast till tarning()
            int summaDator = 0;
            String datorNamn = "Dator";
            summaDator += tarning(antalKast, datorNamn);

            // Skriv ut summor mm i en färdig sträng
            String textOut = spelarNamn + " fick totalt " + summaSpelare + " poäng. \nDatorn fick totalt " + summaDator + " poäng. \n";

            // (5) Jämför resultaten och skriv ut vinnaren
            if(summaSpelare == summaDator){
                System.out.println(textOut + "\n" + "Det blev lika, ingen vann!\n");
            } else if (summaSpelare > summaDator){
                System.out.println(textOut + "\n" + spelarNamn + " vann!\n");
            } else {
                System.out.println(textOut + "\n" +"Datorn vann!\n");
            }
            System.out.println("Vill du spela igen? (j/n) ");
            spela = scan.next().charAt(0);
        } while(spela  != 'n');
        // Program avslut!
        System.out.print("\nTack och välkommen tillbaka!\n");
 */