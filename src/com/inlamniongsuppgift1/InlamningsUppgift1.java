package com.inlamniongsuppgift1;

import java.util.Scanner;

public class InlamningsUppgift1 {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        // Programet avslutas inte förens det akivt väljs.
        String spela = "j";
        while (spela.equals("j")) {

            System.out.print("Skriv in ditt namn: ");
            String spelarNamn = scan.nextLine();

            System.out.print("Hej " + spelarNamn + " du kommer att spela mot Datorn. \nVälj antal kast som ska spelas: ");
            int antalKast = scan.nextInt();

            // Varsin array för att lagra tärningskasten och summorna
            int deltagare = 2;
            int spelare[deltagare] = new int[antalKast];
            int summaSpelare[deltagare];

            // Anropa tärningen
            tarning(antalKast, spelare, deltagare);

            // Programmet avslutas om man svarar "nej" här.
            System.out.println("Vill du spela igen? (j/n) ");
            spela = scan.nextLine();
        }
        System.out.print("Tack och välkommen tillbaka!");
    }

    // Skapar tärningskasten för de 2 spelarna
    static void tarning(int inAntalKast, int inSpelare, int inDeltagare){
        int antalSidor = 6;
        for(int i=1 ; i <= inAntalKast ; i++){
            int kastArray[i] = (int) (1+antalSidor*Math.random());

        }
    }
}
