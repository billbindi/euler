package euler.utils;

public final class NumberStrings {

    public static boolean isPalindrome(long n) {
        String stringN = String.valueOf(n);
        String reverse = new StringBuilder(stringN).reverse().toString();
        return stringN.equals(reverse);
    }

    private NumberStrings() {}
}
