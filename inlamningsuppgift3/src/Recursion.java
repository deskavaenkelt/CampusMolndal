public class Recursion {

    protected static void startRecursion() {
        recursion();
    }

    private static void recursion() {
        //Changes the Arraylist to an Array
        Integer[] numArray = Arrays.getFibonacci().toArray(new Integer[Arrays.getFibonacci().size()]);
        //Prints + calls on findSumOfFibonacci
        System.out.println(findSumOfFibonacci(numArray, numArray.length));

    }
    /**Method that uses recursion to sum the Fibonacci Array*/
    private static int findSumOfFibonacci(Integer Array[], int lenght) {
        if (lenght <= 0)
            return 0;
        return (findSumOfFibonacci(Array, lenght - 1) + Array[lenght - 1]);
    }
}