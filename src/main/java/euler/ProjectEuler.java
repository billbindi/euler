package euler;

import euler.generators.FibonacciGenerator;
import euler.utils.NumberStrings;
import euler.utils.Primes;

import java.util.stream.LongStream;

public final class ProjectEuler {

    private static final String EULER_8_INPUT = "73167176531330624919225119674426574742355349194934" +
            "96983520312774506326239578318016984801869478851843" +
            "85861560789112949495459501737958331952853208805511" +
            "12540698747158523863050715693290963295227443043557" +
            "66896648950445244523161731856403098711121722383113" +
            "62229893423380308135336276614282806444486645238749" +
            "30358907296290491560440772390713810515859307960866" +
            "70172427121883998797908792274921901699720888093776" +
            "65727333001053367881220235421809751254540594752243" +
            "52584907711670556013604839586446706324415722155397" +
            "53697817977846174064955149290862569321978468622482" +
            "83972241375657056057490261407972968652414535100474" +
            "82166370484403199890008895243450658541227588666881" +
            "16427171479924442928230863465674813919123162824586" +
            "17866458359124566529476545682848912883142607690042" +
            "24219022671055626321111109370544217506941658960408" +
            "07198403850962455444362981230987879927244284909188" +
            "84580156166097919133875499200524063689912560717606" +
            "05886116467109405077541002256983155200055935729725" +
            "71636269561882670428252483600823257530420752963450";

    public static void main(String[] args) {
//        System.out.println(euler1(1000));
//        System.out.println(euler2(4_000_000));
//        System.out.println(euler3(600851475143L));
//        System.out.println(euler4(3));
//        System.out.println(euler5(20));
//        System.out.println(euler6(100));
//        System.out.println(euler7(10_001));
        System.out.println(euler8(EULER_8_INPUT, 13));
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
}
