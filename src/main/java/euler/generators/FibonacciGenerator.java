package euler.generators;

/**
 * Generate the Fibonacci sequence. It is defined to have the first 5
 * values of:<br>
 * 1, 2, 3, 5, 8, ...<br>
 */
public final class FibonacciGenerator implements SequenceGenerator {

    private long prev;
    private long prevPrev;
    private long count;

    public FibonacciGenerator() {
        reset();
    }

    @Override
    public long next() {
        count++;
        long next = prev + prevPrev;
        prevPrev = prev;
        prev = next;
        return next;
    }

    @Override
    public long count() {
        return count;
    }

    @Override
    public void reset() {
        prev = 1;
        prevPrev = 0;
        count = 0;
    }
}
