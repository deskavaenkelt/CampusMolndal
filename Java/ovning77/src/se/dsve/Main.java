package se.dsve;

public class Main {

    public static void main(String[] args) {

        boolean play = true;

        while (play) {
            System.out.println("Enter a string:");
            String input = Application.toLowerCase(Application.userInput());

            System.out.println("Score = " + Application.calculateScore(input));

            play = !Application.checkIfExit(input);
        }
    }
}
