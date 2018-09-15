package com.inlamniongsuppgift1;

import java.util.Scanner;

public class InlamningsUppgift1 {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        // (1) Programet avslutas inte förens det akivt väljs.
        String spela = "j";
        while (spela.equals("j")) {

            // Bonus
            System.out.print("Skriv in ditt namn: ");
            String spelarNamn = scan.nextLine();
            // (2) Antal kast
            System.out.print("Hej " + spelarNamn + " du kommer att spela mot Datorn. \nVälj antal kast som ska spelas: ");
            int antalKast = scan.nextInt();

            // (3) Spelare skickar antalKast till tarning()
            int summaSpelare = 0;
            summaSpelare += tarning(antalKast);

            // (4) Dator skickar antalKast till tarning()
            int summaDator = 0;
            summaDator += tarning(antalKast);

            String textOut = spelarNamn + " fick totalt " + summaSpelare + " poäng. \nDatorn fick totalt " + summaDator + " poäng.";

            // (5) Jämför resultaten och skriv ut vinnaren
            if(summaSpelare == summaDator){
                System.out.println(textOut + "\n" + "Det blev lika, ingen vann.");
            } else if (summaSpelare > summaDator){
                System.out.println(textOut + "\n" + spelarNamn + " vann.");
            } else {
                System.out.println(textOut + "\n" +"Datorn vann.");
            }

            // Programmet avslutas om man svarar "nej" här.
            System.out.println("Vill du spela igen? (j/n) ");
            spela = scan.nextLine();
        }
        System.out.print("Tack och välkommen tillbaka!");
    }
    // (4) Skapar tärningskasten för spelarna, Printar dem och gör "return" på summan.
    public static int tarning(int inAntalKast){
        // int antalKast = inAntalKast;
        int antalSidor = 6;
        int kastArray[] = new int[inAntalKast];
        int summa = 0;
        for(int i=1 ; i <= inAntalKast ; i++){
            kastArray[i] = (int) (1+antalSidor*Math.random());
            System.out.println("Kast "+ i + " gav: " + kastArray[i]);
            summa += kastArray[i];
        }
        return summa;
    }
}