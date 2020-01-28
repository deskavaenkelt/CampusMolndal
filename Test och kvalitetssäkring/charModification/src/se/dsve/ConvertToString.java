package se.dsve;

public class ConvertToString {
    public static String convertMyChar(char myChar){
//        System.out.println(myChar);

        int myAscii = (int)myChar;
//        System.out.println(myAscii);

        int myNewAscii = myAscii + 10;
        if (myNewAscii > 126) {
            myNewAscii -= (126 - 33);
        }
//        System.out.println(myNewAscii);

        char myNewChar = (char)myNewAscii;
//        System.out.println(myNewChar);

        return String.valueOf(myNewChar);
    }
}
