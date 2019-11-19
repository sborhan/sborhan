/*
 * CPSC 5003, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package sborhan_practice;

/**
 * Demonstration empirical analysis of recursion and iterative solutions to
 * getting the nth Fibonacci number.
 *
 * @author lundeenk
 * @version r19
 */
public class QuizPractice {
    /**
     * Nanoseconds per second.
     * (Note the use of underscores to make the literal number more readable.)
     */
    public static double NANOS_PER_SECOND = 1_000_000_000.0;

    /**
     * Main entry point of demonstration.
     *
     * @param args not used
     */
    public static void main(String[] args) {
    	char s = 97;
    	System.out.println(s+"\n");
        // for n > 90 we need more than 64 bits
        // - you could use BigInteger class for that, which has no upper limit
        int[] trials = {10, 20, 30, 40, 50};

        for (int n : trials) {

            long start = System.nanoTime();
            System.out.println("fibIt(" + n + ") = " + fibIt(n));
            long end = System.nanoTime();
            System.out.println("fibIt time: " + (end - start) / NANOS_PER_SECOND + " seconds");


            // for n = 70, the recursive version would take over a year to finish
            // for n = 80, the recursive version would take a millenium
            // for n = 90, a million years, etc.
            start = System.nanoTime();
            System.out.println("fibR(" + n + ") = " + fibR(n));
            end = System.nanoTime();
            System.out.println("fibR time: " + (end - start) / NANOS_PER_SECOND + " seconds");
        }
    }

    /**
     * Recursive solution to Fibonacci numbers.
     *
     * @param n which Fibonacci number (position in sequence)
     * @return the nth number in the Fibonacci sequence
     */
    public static long fibR(int n) {
        if (n == 1 || n == 2)
            return 1;
        else
            return fibR(n - 1) + fibR(n - 2);
    }

    /**
     * Iterative solution to Fibonacci numbers.
     *
     * @param n which Fibonacci number (position in sequence)
     * @return the nth number in the Fibonacci sequence
     */
    public static long fibIt(int n) {
        long prev = 1;
        long prevprev = 0;
        long fib = prev + prevprev;
        for (int i = 2; i < n; i++) {
            prevprev = prev;
            prev = fib;
            fib = prev + prevprev;
            try {
                Thread.sleep(100);  // handicap it so that it takes 100 extra milliseconds each time through loop
            } catch (InterruptedException e) {
                // ignore
            }
        }
        return fib;
    }
}
