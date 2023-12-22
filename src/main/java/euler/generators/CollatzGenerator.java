package euler.generators;

public final class CollatzGenerator implements SequenceGenerator {

    private long n;
    private long count;

    public CollatzGenerator(long n) {
        this.n = n;
        this.count = 1;
    }

    @Override
    public long next() {
        // if already at 1, just stay there and don't increase count
        if (n != 1) {
            if (n % 2 == 0) {
                count++;
                n = n / 2;
            } else {
                count++;
                n =  (3 * n) + 1;
            }
        }
        return n;
    }

    @Override
    public long peek() {
        return n;
    }

    @Override
    public long count() {
        return count;
    }

    @Override
    public void reset() {
        throw new IllegalStateException("Cannot reset Collatz generator. Must make a new one with a new start.");
    }
}
