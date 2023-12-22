package euler.utils;

import java.util.ArrayList;
import java.util.List;

public final class Primes {

    public static boolean isPrime(long n) {
        for (long k = 2; k < Math.sqrt(n); k++) {
            if (n % k == 0) {
                return false;
            }
        }
        return true;
    }

    public static long[] primeFactors(long n) {
        List<Long> factors = new ArrayList<>();
        long originalN = n;
        for (long k = 2; k < Math.sqrt(originalN); k++) {
            while (n % k == 0) {
                factors.add(k);
                n /= k;
            }
        }
        return factors.stream().mapToLong(Long::longValue).toArray();
    }

    private Primes() {}
}
