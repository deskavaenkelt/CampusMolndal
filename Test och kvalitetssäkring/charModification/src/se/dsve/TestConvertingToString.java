package se.dsve;

public class TestConvertingToString {

    // a -> k
    public boolean testCharConvertingToString() {

        char testThisChar = 'a';
        String resultingString = ConvertToString.convertMyChar(testThisChar);
        String stringShouldBe = "k";

        if (resultingString.equals(stringShouldBe)) {
            return true;
        } else {
            return false;
        }
    }
}
