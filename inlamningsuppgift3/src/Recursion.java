/**
 * datalogiUppgift3slutuppgift
 *
 * @author Lars Strömberg, Madeleine Hallqvist, Mattias Ahlström
 * @version 1.0
 * @since 2019-02-18
 * https://github.com/deskavaenkelt/datalogiUppgift3slutuppgift
 */
/**
 * Class for a Recursion method that sums the numbers in the Fibonacci Array
 */
public class Recursion {
    /**
     * Public method that calls on the recursion method.
     */
    protected static void startRecursion(){recursion();}
    /**
     * Recursion method that calls on the method that adds all the numbers in the Fibonacci Array
     */
    private static void recursion() {
        //Changes the Arraylist to an Array
        Integer[] numArray = Arrays.getFibonacci().toArray(new Integer[Arrays.getFibonacci().size()]);
        //Prints + calls on findSumOfFibonacci
        System.out.println("Rekursiv metod applicerad på lagrad Fibonacci serie blir: " + findSumOfFibonacci(numArray, numArray.length));
    }
    /**
     * Method that uses recursion to sum the Fibonacci Array
     */
    private static int findSumOfFibonacci(Integer Array[], int length) {
        if (length <= 0)
            return 0;
        return (findSumOfFibonacci(Array, length - 1) + Array[length - 1]);
    }
}