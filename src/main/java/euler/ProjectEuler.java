package euler;

import euler.generators.FibonacciGenerator;
import euler.utils.NumberStrings;
import euler.utils.Primes;

import java.util.stream.LongStream;

public final class ProjectEuler {

    public static void main(String[] args) {
//        System.out.println(euler1(1000));
//        System.out.println(euler2(4_000_000));
//        System.out.println(euler3(600851475143L));
//        System.out.println(euler4(3));
//        System.out.println(euler5(20));
        System.out.println(euler6(100));
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

    /**
     * What is the largest prime factor of the number {@code n}.
     */
    private static long euler3(long n) {
        long[] factors = Primes.primeFactors(n);
        return factors[factors.length - 1];
    }

    /**
     * Find the largest palindrome made from the product of two {@code n}-digit numbers.
     */
    private static long euler4(int n) {
        long max = 0;
        long lowerBound = (long) Math.pow(10, n - 1);
        long upperBound = (long) Math.pow(10, n) - 1;
        for (long i = lowerBound; i <= upperBound; i++) {
            for (long j = lowerBound; j <= upperBound; j++) {
                long product = i * j;
                if (NumberStrings.isPalindrome(product) && product > max) {
                    max = product;
                }
            }
        }
        return max;
    }

    /**
     * What is the smallest positive number that is evenly divisible by all of the numbers
     * from 1 to {@code n}.
     */
    private static long euler5(int n) {
        long ret = n % 2 == 0 ? n - 2 : n - 1;
        boolean allDivide = false;
        while (!allDivide) {
            ret += 2; // has to be even
            allDivide = true; // optimism
            for (int divisor = 2; divisor <= n; divisor++) {
                if (ret % divisor != 0) {
                    allDivide = false;
                    break;
                }
            }
        }
        return ret;
    }

    /**
     * Find the difference between the sum of the squares of the first {@code n} natural
     * numbers and the square of the sum.
     */
    private static long euler6(long n) {
        long sumOfSquares = LongStream.range(1, n + 1).map(l -> l * l).sum();
        long squareOfSums = (long) Math.pow(LongStream.range(1, n + 1).sum(), 2);
        return squareOfSums - sumOfSquares;
    }
}
