package com.javainlamningsuppgift1vg;
import java.util.Arrays;
import java.util.Scanner;
public class JavaInlamningsuppgift1Vg {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        char spela = 'j';

        // Hur många spelare?  >>  Lagra i deltagare  >> Deltagae 0 används ej
        System.out.print("Hur många spelare skall det vara? ");
        int deltagare = scan.nextInt();
        //deltagare = deltagare +1;
        scan.nextLine();                                            // Denna raden rättar till en bugg när man går från nextInt => nextLine

        // Skapa arrayer med antal spelare och summaSpelare
        int spelare[] = new int[deltagare];                         // antalSpelare => Identifiera spelarna med siffror
        int summaSpelare[] = new int[deltagare];                    // Används för de exporterade summorns som senare ska jämföras

        // Skapat highScore som anropas senare

        // Hur många kast
        System.out.print("Hur många kast skall spelas? ");
        int antalKast = scan.nextInt();

        // while-loopen börjar här som körs så längs som spelarna inte avslutar.
        do{
            // Skicka spelare j till tärningen och spara summan i spelare[j]
            for(int j = 0 ; j <= deltagare ; j++){
                summaSpelare[j] += tarning(antalKast, j);
            }
            // Skriv ut summor mm i en färdig sträng
            for(int k = 0 ; k <= deltagare ; k++){
                String textOut = spelare[k] + " fick totalt " + summaSpelare[k] + " poäng. \n";
            }
//########################################################################################################
            // Sortera fram högsta resultatet, bubblesort
            Arrays.sort(summaSpelare);
            for (int i = 1; i < summaSpelare.length; i++) {
                System.out.println(summaSpelare[i]);
            }


//########################################################################################################
            // Anropa highScore
            //highScore(spelareBubbleSort, summaBubbleSort);   // highScore(spelare, summaSpelare);

            // Fråga om man ska spela igen.
            spela = spelaIgen();

        } while(spela  != 'n');
        // Program avslut!
        System.out.print("\nTack och välkommen tillbaka!\n");
    }

    /* ########################################################################## */
    /* ########################## Här börjar metoderna ########################## */
    /* ########################################################################## */

    // Skapar tärningskasten för spelarna, Printar dem och gör "return" på summan.  Färdig sedan G uppgift
    private static int tarning(int inAntalKast, int inDeltagare){
        int antalSidor = 6;
        int summa = 0;
        System.out.println("Spelare " + inDeltagare);
        for(int i=1 ; i <= inAntalKast ; i++){
            int kast = (int) (1+antalSidor*Math.random());
            System.out.println("Kast "+ i + " gav: " + kast);
            summa += kast;
        }
        System.out.print("\n");
        return summa;
    }

    // Skapa High Score Lista, returnerar inget värde.     Färdig? ska bekräftas
    public static void highScore(int inSpelarNamn, int inSummaSpelare){
        // Skapa array
        int row = 5;
        int colum = 2;
        int table[][] = new int[row][colum];

        // Bestäm om poängen är tillräckligt hög för att komma in på listan
        if(inSummaSpelare >= table[1][2]){
            table[5][2] = table[4][2];
            table[4][2] = table[3][2];
            table[3][2] = table[2][2];
            table[2][2] = table[1][2];
            table[1][1] = inSpelarNamn;
            table[1][2] = inSummaSpelare;
        } else if(inSummaSpelare >= table[2][2]) {
            table[5][2] = table[4][2];
            table[4][2] = table[3][2];
            table[3][2] = table[2][2];
            table[2][1] = inSpelarNamn;
            table[2][2] = inSummaSpelare;
        } else if(inSummaSpelare >= table[3][2]) {
            table[5][2] = table[4][2];
            table[4][2] = table[3][2];
            table[3][1] = inSpelarNamn;
            table[3][2] = inSummaSpelare;
        } else if(inSummaSpelare >= table[4][2]) {
            table[5][2] = table[4][2];
            table[4][1] = inSpelarNamn;
            table[4][2] = inSummaSpelare;
        } else if(inSummaSpelare >= table[5][2]) {
            table[5][1] = inSpelarNamn;
            table[5][2] = inSummaSpelare;
        } else{
            System.out.print("Du kom inte in på listan");
        }

        // Skriv ut highScore
        String leftAlignFormat = "| %-15s | %-5d |%n";
        System.out.format("+-----------------+-------+%n");
        System.out.format("| Namn            | Poäng |%n");
        System.out.format("+-----------------+-------+%n");
        for (int i = 0; i <= 4; i++) {
            for(int j = 0 ; j <= 1 ; j++){
                System.out.format(leftAlignFormat, table[i][j] + table[i][j]);
            }
        }
        System.out.format("+-----------------+------+%n");
    }

    // Spela fler gånger    Färdig, ska bekräftas
    public static char spelaIgen(){
        Scanner scan = new Scanner(System.in);
        // Fråga om man vill spela igen
        System.out.print("Vill ni spela igen? (j/n): ");
        char spelaIgen = scan.next().charAt(0);
        return spelaIgen;
    }
}

/*

        // Fråga efter namn på varje spelare.
        // Loopen för att mata in namn i spelarNamn.
        for(int i = 0 ; i <= deltagare ; i++){                      // Hur löser jag att string börjar på 0 och inte 1?  Strunta i att använda fält 0 i arrayen
            System.out.print("Namn på spelare " + i + ": ");        // Ger dubla utskrifter på första spelaren, varför? bug i Java
            spelare[i] = scan.nextLine();
            //System.out.println();
        }

//String spelarNamn[] = new String[deltagare+1];              // Används för att döpa spelare och innehåller namnen på spelarna


Från highscore
        int row = 6;
        int colum = 3;
        int table[][] = new int[row][colum];
        // Bygg upp layout för tabellen, Namn, Poäng & Position
        Fungerar ej som tänkt, byter till integer istället
        table[0][0] = Integer.toString(System.out.print("Pos"));        table[0][1] = System.out.print("Namn");        table[0][2] = System.out.print("Poäng");
        table[1][0] = "1";
        table[2][0] = "2";
        table[3][0] = "3";
        table[4][0] = "4";
        table[5][0] = "5";






 */

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
