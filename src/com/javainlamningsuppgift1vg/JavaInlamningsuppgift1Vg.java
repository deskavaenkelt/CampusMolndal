package com.javainlamningsuppgift1vg;
import java.util.Scanner;
public class JavaInlamningsuppgift1Vg {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        char spela = 'j';

        System.out.print("Hur många spelare skall det vara (2-5p)? ");
        int deltagare = scan.nextInt();

        if(deltagare > 5 || deltagare < 2){                                     // Kontrollera så det inte är fel antal deltagare
            System.out.print("Ni kan bara välja mellan 2-5 spelare? ");
            deltagare = scan.nextInt();
        }
        int spelarId[] = {1, 2, 3, 4, 5, 6, 7};                                 // spelarId används senare för att länka ihop med spelarNamn
        int summaSpelare[] = new int[7];                                        // Används för de exporterade summorns som senare ska jämföras

        // Möjlig gör länkning av spelarNamn och spelarId
        String spelarNamn[] = new String[9];
        scan.nextLine();                                                        // Denna raden rättar till en bugg när man går från nextInt => nextLine
        for(int e = 0 ; e <= deltagare-1 ; e++){
            System.out.print("Namn på spelare " + (e+1) + ": ");
            spelarNamn[e] = scan.nextLine();
        }
        spelarNamn[6] = "null";                                                 // Möjlig gör att fylla highScore med "null" för att tydligt visa att den är tom

        System.out.print("Välj antal kast: ");
        int antalKast = scan.nextInt();

        // Bygger upp alla element till highScore samt sätter namnen till null
        int forstaPlats[] = new int[2];     forstaPlats[0] = spelarId[6];
        int andraPlats[] = new int[2];      andraPlats[0] = spelarId[6];
        int tredjePlats[] = new int[2];     tredjePlats[0] = spelarId[6];
        int fjardePlats[] = new int[2];     fjardePlats[0] = spelarId[6];
        int femtePlats[] = new int[2];      femtePlats[0] = spelarId[6];

        // Nedan används för att jämföra vinnarens resultat med highscore elementen
        int resultatSummaSpelare = 0;
        int resultatSpelarId = 0;

        do{
            // Skicka antalKast, deltagare (för Id) & spelarNamn[j] till tärningen och spara summan i summaSpelare[j]
            for(int j = 0 ; j <= deltagare-1 ; j++){
                summaSpelare[j] += tarning(antalKast, spelarNamn[j]);
            }
            // Skriv ut summor för alla spelare i en färdig sträng
            for(int k = 0 ; k <= deltagare-1 ; k++){
                String textOut = spelarNamn[k] + " fick totalt " + summaSpelare[k] + "/" + (antalKast*6) +" poäng. \n";
                System.out.print(textOut);
            }
            System.out.print("\n");                                             // Extra radbrytning

            // Sortera fram högsta resultatet och utser vinnaren. Enbart vinnarens resultat skickas till highScore, om två högsta resultat finns vinner ingen.
            if(summaSpelare[0] > summaSpelare[1] && summaSpelare[0] > summaSpelare[2] && summaSpelare[0] > summaSpelare[3] && summaSpelare[0] > summaSpelare[4]){
                System.out.println(spelarNamn[0] + " vann!\n");
                resultatSpelarId = spelarId[0];
                resultatSummaSpelare = summaSpelare[0];
            } else if(summaSpelare[1] > summaSpelare[0] && summaSpelare[1] > summaSpelare[2] && summaSpelare[1] > summaSpelare[3] && summaSpelare[1] > summaSpelare[4]) {
                System.out.println(spelarNamn[1] + " vann!\n");
                resultatSpelarId = spelarId[1];
                resultatSummaSpelare = summaSpelare[1];
            } else if(summaSpelare[2] > summaSpelare[0] && summaSpelare[2] > summaSpelare[1] && summaSpelare[2] > summaSpelare[3] && summaSpelare[2] > summaSpelare[4]) {
                System.out.println(spelarNamn[2] + " vann!\n");
                resultatSpelarId = spelarId[2];
                resultatSummaSpelare = summaSpelare[2];
            } else if(summaSpelare[3] > summaSpelare[0] && summaSpelare[3] > summaSpelare[1] && summaSpelare[3] > summaSpelare[2] && summaSpelare[3] > summaSpelare[4]) {
                System.out.println(spelarNamn[3] + " vann!\n");
                resultatSpelarId = spelarId[3];
                resultatSummaSpelare = summaSpelare[3];
            } else if(summaSpelare[4] > summaSpelare[0] && summaSpelare[4] > summaSpelare[1] && summaSpelare[4] > summaSpelare[2] && summaSpelare[4] > summaSpelare[3]) {
                System.out.println(spelarNamn[4] + " vann!\n");
                resultatSpelarId = spelarId[4];
                resultatSummaSpelare = summaSpelare[4];
            } else {
                System.out.println("2 eller mer likadan högsta resultat, ingen vinner!\n");
            }

            // Jämför vinnarens resultat med befintlig highScore och sorterar in vinnaren.
            if(resultatSummaSpelare >= forstaPlats[1]){
                System.out.println(spelarNamn[resultatSpelarId-1] + " slog högsta resultatet i High Score Listan!!!\n");
                femtePlats[0] = fjardePlats[0];
                femtePlats[1] = fjardePlats[1];
                fjardePlats[0] = tredjePlats[0];
                fjardePlats[1] = tredjePlats[1];
                tredjePlats[0] = andraPlats[0];
                tredjePlats[1] = andraPlats[1];
                andraPlats [0]= forstaPlats[0];
                andraPlats [1]= forstaPlats[1];
                forstaPlats [0] = resultatSpelarId-1;             // Lagrar spelarens id som är kopplat till namn för att kunna ta fram i highScore senare
                forstaPlats [1] = resultatSummaSpelare;           // Lagrar spelarens summa i samma arry som ovan.
            } else if(resultatSummaSpelare < forstaPlats[1] && resultatSummaSpelare >= andraPlats[1]){
                System.out.println(spelarNamn[resultatSpelarId-1] + " kom två på High Score Listan. (First looser)\n");
                femtePlats[0] = fjardePlats[0];
                femtePlats[1] = fjardePlats[1];
                fjardePlats[0] = tredjePlats[0];
                fjardePlats[1] = tredjePlats[1];
                tredjePlats[0] = andraPlats[0];
                tredjePlats[1] = andraPlats[1];
                andraPlats[0] = resultatSpelarId-1;
                andraPlats[1] = resultatSummaSpelare;
            } else if(resultatSummaSpelare < andraPlats[1] && resultatSummaSpelare >= tredjePlats[1]){
                System.out.println(spelarNamn[resultatSpelarId-1] + " kom trea på High Score Listan.\n");
                femtePlats[0] = fjardePlats[0];
                femtePlats[1] = fjardePlats[1];
                fjardePlats[0] = tredjePlats[0];
                fjardePlats[1] = tredjePlats[1];
                tredjePlats[0] = resultatSpelarId-1;
                tredjePlats[1] = resultatSummaSpelare;
            } else if(resultatSummaSpelare < tredjePlats[1] && resultatSummaSpelare >= fjardePlats[1]){
                System.out.println(spelarNamn[resultatSpelarId-1] + " kom fyra på High Score Listan.\n");
                femtePlats[0] = fjardePlats[0];
                femtePlats[1] = fjardePlats[1];
                fjardePlats[0] = resultatSpelarId-1;
                fjardePlats[1] = resultatSummaSpelare;
            } else if(resultatSummaSpelare < fjardePlats[1] && resultatSummaSpelare >= femtePlats[1]){
                System.out.println(spelarNamn[resultatSpelarId-1] + " kom sist på High Score Listan.\n");
                femtePlats[0] = resultatSpelarId-1;
                femtePlats[1] = resultatSummaSpelare;
            } else {
                System.out.println(spelarNamn[resultatSpelarId-1] + "'s resultat var för dåligt för High Score Listan. (Biggest looser)\n");
            }

            // Formartering av highScore listan
            String leftAlignFormat = "| %-15s | %-5d |%n";
            System.out.format("+-----------------+-------+%n");
            System.out.format("+       High Score        +%n");
            System.out.format("+-----------------+-------+%n");
            System.out.format("| Namn            | Poäng |%n");
            System.out.format("+-----------------+-------+%n");
            System.out.format(leftAlignFormat, spelarNamn[forstaPlats[0]], forstaPlats[1]);
            System.out.format(leftAlignFormat, spelarNamn[andraPlats[0]], andraPlats[1]);
            System.out.format(leftAlignFormat, spelarNamn[tredjePlats[0]], tredjePlats[1]);
            System.out.format(leftAlignFormat, spelarNamn[fjardePlats[0]], fjardePlats[1]);
            System.out.format(leftAlignFormat, spelarNamn[femtePlats[0]], femtePlats[1]);
            System.out.format("+-----------------+-------+%n");

            // Fråga om man ska spela igen.
            spela = spelaIgen();
            // Sätt summorna i summaSpelare till noll
            for(int d = 0 ; d < 7 ; d++){
                summaSpelare[d] = 0;
            }

        } while(spela  != 'n');
        // Program avslut!
        System.out.print("\nTack och välkommen tillbaka!\n");
    }

    // Metoden för tärningen, skickar in: antalKast & spelarnamnet, Printar kasten och gör "return" på summan.
    private static int tarning(int inAntalKast, String inSpelarnamn){
        int antalSidor = 6;
        int summa = 0;
        System.out.println(inSpelarnamn);
        for(int i=1 ; i <= inAntalKast ; i++){
            int kast = (int) (1+antalSidor*Math.random());
            System.out.println("Kast "+ i + " gav: " + kast);
            summa += kast;
        }
        System.out.println("Summa: "+ summa + "p\n");
        return summa;
    } //Färdig

    // Metod för att spela fler gånger.
    public static char spelaIgen(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Vill ni spela igen? (j/n): ");
        char spelaIgen = scan.next().charAt(0);
        return spelaIgen;
    } //Färdig
}