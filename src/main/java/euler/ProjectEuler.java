package euler;

import euler.generators.CollatzGenerator;
import euler.generators.FibonacciGenerator;
import euler.generators.PrimeGenerator;
import euler.generators.TriangleNumberGenerator;
import euler.utils.Geometry;
import euler.utils.NumberStrings;
import euler.utils.Primes;
import euler.utils.Sequences;
import org.apache.commons.math3.util.CombinatoricsUtils;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.LongStream;

public final class ProjectEuler {

    public static void main(String[] args) {
//        System.out.println(euler1(1000));
//        System.out.println(euler2(4_000_000));
//        System.out.println(euler3(600851475143L));
//        System.out.println(euler4(3));
//        System.out.println(euler5(20));
//        System.out.println(euler6(100));
//        System.out.println(euler7(10_001));
//        System.out.println(euler8(Inputs.EULER_8_INPUT, 13));
//        System.out.println(euler9(1000));
//        System.out.println(euler10(2_000_000));
//        System.out.println(euler11(Inputs.EULER_11_INPUT, 4));
//        System.out.println(euler12(500));
//        System.out.println(euler13(Inputs.EULER_13_INPUT, 10));
//        System.out.println(euler14(1_000_000));
        System.out.println(euler15(20));
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

    /**
     * What is the {@code n}th prime.
     */
    private static long euler7(long n) {
        return Primes.nthPrime(n);
    }

    /**
     * Find the {@code n} adjacent digits in the given number that have the greatest product.
     * What is the value of this product.
     */
    private static long euler8(String number, int n) {
        long max = 0;
        for (int i = 0; i <= number.length() - n; i++) {
            long product = NumberStrings.product(number, i, i + n);
            if (product > max) {
                max = product;
            }
        }
        return max;
    }

    /**
     * Find the product of a Pythagorean triplet for which the sum a + b + c is {@code n}.
     */
    private static long euler9(long n) {
        for (long a = 1; a < n / 2; a++) {
            for (long b = 1; b < n / 2; b++) {
                long c = n - a - b;
                if (Geometry.isPythagoreanTriplet(a, b, c)) {
                    return a * b * c;
                }
            }
        }
        throw new IllegalArgumentException("No triplet whose sum is " + n);
    }

    /**
     * Find the sum of all the primes below {@code n}.
     */
    private static long euler10(long n) {
        PrimeGenerator generator = new PrimeGenerator();
        long sum = 0;
        long prime = generator.next();
        while (prime < n) {
            sum += prime;
            prime = generator.next();
        }
        return sum;
    }

    /**
     * What is the greatest product of {@code n} adjacent numbers in the same direction
     * (up, down, left, right, or diagonally) in the given grid?
     */
    private static long euler11(int[][] grid, int n) {
        long max = 0;

        // vertical
        for (int i = 0; i <= grid.length - n; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                long product = 1;
                for (int k = 0; k < n; k++) {
                    product *= grid[i + k][j];
                }
                if (product > max) {
                    max = product;
                }
            }
        }

        // horizontal
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j <= grid[i].length - n; j++) {
                long product = 1;
                for (int k = 0; k < n; k++) {
                    product *= grid[i][j + k];
                }
                if (product > max) {
                    max = product;
                }
            }
        }

        // diagonal down-right
        for (int i = 0; i <= grid.length - n; i++) {
            for (int j = 0; j <= grid[i].length - n; j++) {
                long product = 1;
                for (int k = 0; k < n; k++) {
                    product *= grid[i + k][j + k];
                }
                if (product > max) {
                    max = product;
                }
            }
        }

        // diagonal up-right
        for (int i = n - 1; i < grid.length; i++) {
            for (int j = 0; j <= grid[i].length - n; j++) {
                long product = 1;
                for (int k = 0; k < n; k++) {
                    product *= grid[i - k][j + k];
                }
                if (product > max) {
                    max = product;
                }
            }
        }

        return max;
    }

    /**
     * What is the value of the first triangle number to have over {@code n} divisors?
     */
    private static long euler12(int n) {
        TriangleNumberGenerator generator = new TriangleNumberGenerator();
        long triangle = generator.next();
        while (Primes.numFactors(triangle) <= n) {
            triangle = generator.next();
        }
        return triangle;
    }

    /**
     * Find the first {@code n} digits of the sum of the given numbers.
     */
    private static String euler13(BigInteger[] numbers, int n) {
        BigInteger sum = Arrays.stream(numbers).reduce((a, b) -> a.add(b)).get();
        return sum.toString().substring(0, n);
    }

    /**
     * Which starting number, under {@code n}, produces the longest Collatz chain?
     */
    private static long euler14(long n) {
        long max = 1;
        long maxNum = 1;
        for (long i = 2; i < n; i++) {
            long length = Sequences.collatzLength(i);
            if (length > max) {
                max = length;
                maxNum = i;
            }
        }
        return maxNum;
    }

    /**
     * Only being able to move right and down, how many are there through an {@code n}x{@code n} grid?
     */
    private static long euler15(int n) {
        return CombinatoricsUtils.binomialCoefficient(2 * n, n);
    }
}
