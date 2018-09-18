package com.javainlamningsuppgift1vg;
import java.util.Scanner;
public class JavaInlamningsuppgift1Vg {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        char spela = 'j';

        // Hur många spelare?  >>  Lagra i deltagare
        System.out.print("Hur många spelare skall det vara? ");
        int deltagare = scan.nextInt();
        scan.nextLine();                                            // Denna raden rättar till en bugg när man går från nextInt => nextLine

        // Skapa arrayer med antal spelare, spelarNamn och summaSpelare
        int spelare[] = new int[deltagare];                 /*används inte ännu*/        // antalSpelare => Identifiera spelarna med siffror
        String spelarNamn[] = new String[deltagare+1];              // Används för att döpa spelare och innehåller namnen på spelarna
        String summaSpelare[] = new String[deltagare];      /*används inte ännu*/        // Används för de exporterade summorns som senare ska jämföras

        // Fråga efter namn på varje spelare.
        // Loopen för att mata in namn i spelarNamn.
        for(int i = 0 ; i <= deltagare ; i++){                      // Hur löser jag att string börjar på 0 och inte 1?  Strunta i att använda fält 0 i arrayen
            System.out.print("Namn på spelare " + i + ": ");        // Ger dubla utskrifter på första spelaren, varför? bug i Java
            spelarNamn[i] = scan.nextLine();
            //System.out.println();
        }


        // Hur många kast
        System.out.print("Hur många kast skall spelas? ");
        int antalKast = scan.nextInt();

        // Skicka spelare j till tärningen och spara summan i spelare[deltagare]
        /*for(int j ; j <= deltagare ; j++){

        }*/

        // Anropa highScore


        // Fråga om man ska spela igen.
        spela = spelaIgen()
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

    private static int bubblesort(){
        // Här kommer kod senare
    }

    // Skapa High Score Lista
    public static void highScore(String inSpelarNamn, int inSummaSpelare){
        int row = 6;
        int colum = 3;
        int table[][] = new int[row][colum];
        // Bygg upp layout för tabellen, Namn, Poäng & Position
        table[0][0] = "Pos"; table[0][1] = "Namn"; table[0][2] = "Poäng";
        table[1][0] = "1";
        table[2][0] = "2";
        table[3][0] = "3";
        table[4][0] = "4";
        table[5][0] = "5";
        //


        // Skriv ut highScore
        String leftAlignFormat = "| %-3d | %-15s | %-5d |%n";
        System.out.format("+-----+-----------------+-------+%n");
        System.out.format("| Pos | Namn            | Poäng |%n");
        System.out.format("+-----+-----------------+-------+%n");
        for (int i = 0; i <= 5; i++) {
            for(int j = 0 ; j <= 2 ; j++){
                System.out.format(leftAlignFormat, table[i][j] + table[i][j] + table[i][j]);
            }
        }
        System.out.format("+-----------------+------+%n");
    }

    // Spela fler gånger
    public static char spelaIgen(){
        Scanner scan = new Scanner(System.in);
        // Fråga om man vill spela igen
        System.out.print("Vill ni spela igen? (j/n): ");
        char spelaIgen = scan.next().charAt(0);
        return spelaIgen;
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