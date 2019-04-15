package com.inlamniongsuppgift1;

import java.util.Scanner;

public class InlamningsUppgift1 {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
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

        // Programmet avslutas om man svarar "nej" här.
        //System.out.println("Vill du spela igen? (j/n) ");
        //spela = scan.nextLine();
    }
    // (4) Skapar tärningskasten för spelarna, Printar dem och gör "return" på summan.
    public static int tarning(int inAntalKast, String inSpelarNamn){
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