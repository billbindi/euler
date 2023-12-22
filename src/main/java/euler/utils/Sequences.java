package euler.utils;

import euler.generators.CollatzGenerator;

public final class Sequences {

    public static long collatzLength(long n) {
        CollatzGenerator generator = new CollatzGenerator(n);
        while (generator.peek() != 1) {
            generator.next();
        }
        return generator.count();
    }

    private Sequences() {}
}
