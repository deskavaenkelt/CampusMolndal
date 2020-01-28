package se.dsve;

public class Main {
    /*
    * Ta char och gör om till 10 högre i ASCII-tabellen
    * Skriv ut resultatet i en string
    * Skapa testpaket som kör tester mot programmet
    * Försök täcka alla fall
    */

    public static void main(String[] args) {
        TestConvertingToString testConvertingToString = new TestConvertingToString();
//        ConvertToString convertToString = new ConvertToString();

//        testConvertingToString('e');

        System.out.println(testConvertingToString.testCharConvertingToString());
    }
    @Test
    public void testMethodThatShouldBeTested(){
        Klass klass = new Klass;
        klass.methodThatShouldBeTested("Hej");
        Assert.assertEquals(Equals())
    }
}

