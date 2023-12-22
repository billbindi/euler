package euler.generators;

/**
 * Generate a sequence of integers. Very stateful.
 */
public interface SequenceGenerator {

    /**
     * Return the next number in the sequence.
     */
    long next();

    /**
     * The position of the sequence as it currently stands. A value of
     * 0 indicates that no numbers have been generated.
     */
    long count();

    /**
     * Reset the internal state of the generator. The count should be 0
     * and the value of the next call to {@link SequenceGenerator#next()}
     * should return the first value in the sequence.
     */
    void reset();
}
