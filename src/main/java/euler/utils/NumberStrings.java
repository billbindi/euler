package euler.utils;

import com.google.common.base.Preconditions;

public final class NumberStrings {

    public static boolean isPalindrome(long n) {
        String stringN = String.valueOf(n);
        String reverse = new StringBuilder(stringN).reverse().toString();
        return stringN.equals(reverse);
    }

    public static long product(String number, int startInclusive, int endExclusive) {
        Preconditions.checkArgument(startInclusive >= 0 &&
                startInclusive < endExclusive &&
                endExclusive <= number.length(),
                "Invalid indices [%d, %d).",
                startInclusive,
                endExclusive);
        long product = 1;
        for (int i = startInclusive; i < endExclusive; i++) {
            product *= Character.getNumericValue(number.charAt(i));
        }
        return product;
    }

    private NumberStrings() {}
}
