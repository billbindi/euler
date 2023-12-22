package euler;

import euler.generators.FibonacciGenerator;

public final class ProjectEuler {

    public static void main(String[] args) {
        System.out.println(euler2(4_000_000));
    }

    /**
     * Find the sum of all the multiples of 3 or 5 below {@code n}.
     */
    private static long euler1(long n) {
        long sum = 0;
        for (long i = 1; i < n; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    /**
     * By considering the terms in the Fibonacci sequence whose values do not exceed {@code n},
     * find the sum of the even-valued terms.
     */
    private static long euler2(long n) {
        FibonacciGenerator generator = new FibonacciGenerator();
        long fib = generator.next();
        long sum = 0;
        while (fib < n) {
            if (fib % 2 == 0) {
                sum += fib;
            }
            fib = generator.next();
        }
        return sum;
    }
}
