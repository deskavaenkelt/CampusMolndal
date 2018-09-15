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

            // (3a) Ange hur många deltagare (G du & dator = 2).
            int deltagare = 2;                      // Kommer ge spelare 0 & 1.
            int spelare[] = new int[deltagare];     // Skapar array spelare bestående av "deltagare"-antal spelare.

            // (3b) Lagra resultatet i en tvådimensionell array "summa = rader\spelare = koloner".
            int summa = 0;
            int table[][] = new int[summa][spelare[deltagare]];


            // Anropa tärningen, i en loop
            spelare[deltagare] += tarning(antalKast);

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