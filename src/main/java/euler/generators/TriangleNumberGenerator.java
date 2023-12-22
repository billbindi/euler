package euler.generators;

public class TriangleNumberGenerator implements SequenceGenerator {

    private long triangle;
    private long count;

    public TriangleNumberGenerator() {
        reset();
    }
    @Override
    public long next() {
        count++;
        triangle += count;
        return triangle;
    }

    @Override
    public long peek() {
        return triangle;
    }

    @Override
    public long count() {
        return count;
    }

    @Override
    public void reset() {
        count = 0;
        triangle = 0;
    }
}
