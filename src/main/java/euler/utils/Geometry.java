package euler.utils;

public final class Geometry {

    public static boolean isPythagoreanTriplet(long a, long b, long c) {
        return ((a * a) + (b * b)) == (c * c);
    }

    private Geometry() {}
}
