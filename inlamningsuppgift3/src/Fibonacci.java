public class Fibonacci {

    //https://www.java-examples.com/fibonacci-series-java-example

    private static int counter = 0;

    /** Call this function to add a new fibonacci number to the series */
    protected void addNewFibonacci() {
        createAnewFibonacciElement();
    }

    private static void createAnewFibonacciElement() {
        if (0 == counter || 1 == counter) {
            Arrays.setFibonacci(counter);
            counter++;
        } else {
            Arrays.setFibonacci(Arrays.getFibonacci().get(counter-1) + Arrays.getFibonacci().get(counter-2));
            counter++;
        }
    }
}