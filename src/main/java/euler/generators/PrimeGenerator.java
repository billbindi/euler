package euler.generators;

import euler.utils.Primes;

/**
 * Generate the prime numbers in order. The first prime number is 2.
 */
public final class PrimeGenerator implements SequenceGenerator {

    private long prime;
    private long count;

    public PrimeGenerator() {
        reset();
    }

    @Override
    public long next() {
        count++;
        long next = prime + 1;
        while (!Primes.isPrime(next)) {
            next++;
        }
        prime = next;
        return prime;
    }

    @Override
    public long peek() {
        if (count == 0) {
            throw new IllegalStateException("Cannot peek before running.");
        }
        return prime;
    }

    @Override
    public long count() {
        return count;
    }

    @Override
    public void reset() {
        prime = 1;
        count = 0;
    }
}
