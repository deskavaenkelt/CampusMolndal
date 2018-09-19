package com.javainlamningsuppgift1vg;
import java.util.Scanner;
public class JavaInlamningsuppgift1Vg {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        char spela = 'j';

        // Hur många spelare?  >>  Lagra i deltagare  >> Deltagae 0 används
        System.out.print("Hur många spelare skall det vara (2-5p)? ");
        int deltagare = scan.nextInt();
        //scan.nextLine();                                            // Denna raden rättar till en bugg när man går från nextInt => nextLine

        // Kontrollera så det inte är fel antal deltagare
        if(deltagare > 5 || deltagare < 2){
            System.out.print("Ni kan bara välja mellan 2-5 spelare? ");
            deltagare = scan.nextInt();
        }
        // Skapa arrayer med antal spelare och summaSpelare
        int spelare[] = {1, 2, 3, 4, 5, 6};                         // antalSpelare => Identifiera spelarna med siffror
        int summaSpelare[] = new int[7];                            // Används för de exporterade summorns som senare ska jämföras

        // Skapat highScore som anropas senare

        System.out.print("Välj antal kast: ");
        int antalKast = scan.nextInt();

        do{
            System.out.println(deltagare + " spelare valdes.\n");
            // Skicka spelare j till tärningen och spara summan i spelare[j]
            for(int j = 0 ; j <= deltagare-1 ; j++){
                summaSpelare[j] += tarning(antalKast, j);
                // Har kontrollerat så summan returneras korrekt
            }
            // Skriv ut summor mm i en färdig sträng
            for(int k = 0 ; k <= deltagare-1 ; k++){
                String textOut = "Spelare " + spelare[k] + " fick totalt " + summaSpelare[k] + " poäng. \n";
                System.out.print(textOut);
            }
            System.out.print("\n");

            // Sortera fram högsta resultatet med if-satser
            if(summaSpelare[0] > summaSpelare[1] && summaSpelare[0] > summaSpelare[2] && summaSpelare[0] > summaSpelare[3] && summaSpelare[0] > summaSpelare[4]){
                System.out.print("Spelare 1 vann!");
                highScore(spelare[0], summaSpelare[0]);
            } else if(summaSpelare[1] > summaSpelare[0] && summaSpelare[1] > summaSpelare[2] && summaSpelare[1] > summaSpelare[3] && summaSpelare[1] > summaSpelare[4]) {
                System.out.print("Spelare 2 vann!");
                highScore(spelare[1], summaSpelare[1]);
            } else if(summaSpelare[2] > summaSpelare[0] && summaSpelare[2] > summaSpelare[1] && summaSpelare[2] > summaSpelare[3] && summaSpelare[2] > summaSpelare[4]) {
                System.out.print("Spelare 3 vann!");
                highScore(spelare[2], summaSpelare[2]);
            } else if(summaSpelare[3] > summaSpelare[0] && summaSpelare[3] > summaSpelare[1] && summaSpelare[3] > summaSpelare[2] && summaSpelare[3] > summaSpelare[4]) {
                System.out.print("Spelare 4 vann!");
                highScore(spelare[3], summaSpelare[3]);
            } else if(summaSpelare[4] > summaSpelare[0] && summaSpelare[4] > summaSpelare[1] && summaSpelare[4] > summaSpelare[2] && summaSpelare[4] > summaSpelare[3]) {
                System.out.print("Spelare 5 vann!");
                highScore(spelare[4], summaSpelare[4]);
            } else {
                System.out.println("2 eller mer likadan högsta resultat, ingen vinner!\n");
            }

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
        System.out.println("Spelare " + (inDeltagare + 1));
        for(int i=1 ; i <= inAntalKast ; i++){
            int kast = (int) (1+antalSidor*Math.random());
            System.out.println("Kast "+ i + " gav: " + kast);
            summa += kast;
        }
        System.out.println("Summa: "+ summa + "p\n");
        return summa;
    }

    // Skapa High Score Lista, returnerar inget värde.     Färdig? ska bekräftas
    public static void highScore(int inSpelare, int inSummaSpelare){
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
            table[1][1] = inSpelare;
            table[1][2] = inSummaSpelare;
        } else if(inSummaSpelare >= table[2][2]) {
            table[5][2] = table[4][2];
            table[4][2] = table[3][2];
            table[3][2] = table[2][2];
            table[2][1] = inSpelare;
            table[2][2] = inSummaSpelare;
        } else if(inSummaSpelare >= table[3][2]) {
            table[5][2] = table[4][2];
            table[4][2] = table[3][2];
            table[3][1] = inSpelare;
            table[3][2] = inSummaSpelare;
        } else if(inSummaSpelare >= table[4][2]) {
            table[5][2] = table[4][2];
            table[4][1] = inSpelare;
            table[4][2] = inSummaSpelare;
        } else if(inSummaSpelare >= table[5][2]) {
            table[5][1] = inSpelare;
            table[5][2] = inSummaSpelare;
        } else{
            System.out.print("Du kom inte in på listan");
        }

        // Skriv ut highScore
        for(int b = 0 ; b <= 4 ; b++){
            for(int c = 0 ; c <= 1 ; c++){
                System.out.print(table[b][1]);
            }
        }
        /*
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
        */
    }

    // Spela fler gånger    Färdig
    public static char spelaIgen(){
        Scanner scan = new Scanner(System.in);
        // Fråga om man vill spela igen
        System.out.print("Vill ni spela igen? (j/n): ");
        char spelaIgen = scan.next().charAt(0);
        return spelaIgen;
    }
}