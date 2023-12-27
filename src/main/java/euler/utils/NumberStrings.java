package euler.utils;

import com.google.common.base.Preconditions;

public final class NumberStrings {

    private static final String[] MAGNITUDES = {
            "thousand",
            "million",
            "billion",
            "trillion",
            "quadrillion",
            "quintillion"
    };
    private static final String[] TENS = {
            "twenty",
            "thirty",
            "forty",
            "fifty",
            "sixty",
            "seventy",
            "eighty",
            "ninety"
    };

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

    public static String longToString(long n) {
        if (n == 0) {
            return "zero";
        } else {
            StringBuilder str = new StringBuilder();
            int magnitude = 0;
            while (n > 0) {
                int hundreds = (int) n % 1000;
                if (hundreds > 0) {
                    String val = intToStringHundreds(hundreds) +
                            (magnitude > 0 ? " " + MAGNITUDES[magnitude - 1] + " " : "");
                    str.insert(0, val);
                }
                n /= 1000;
                magnitude++;
            }
            str.insert(0, n < 0 ? "negative " : "");
            return str.toString();
        }
    }

    private static String intToStringHundreds(int n) {
        Preconditions.checkArgument(n > 0 && n < 1000);
        int tens = n % 100;
        int hundreds = n / 100;
        StringBuilder str = new StringBuilder();
        if (hundreds > 0) {
            str.append(intToStringOnes(hundreds)).append(" hundred");
        }
        if (tens > 0) {
            if (hundreds > 0) {
                str.append(" and ");
            }
            str.append(intToStringTens(tens));
        }
        return str.toString();
    }

    private static String intToStringTens(int n) {
        Preconditions.checkArgument(n > 0 && n < 100);
        // treat 10-19 special
        if (n >= 10 && n <= 19) {
            return switch (n) {
                case 10 -> "ten";
                case 11 -> "eleven";
                case 12 -> "twelve";
                case 13 -> "thirteen";
                case 14 -> "fourteen";
                case 15 -> "fifteen";
                case 16 -> "sixteen";
                case 17 -> "seventeen";
                case 18 -> "eighteen";
                case 19 -> "nineteen";
                default -> throw new IllegalStateException("Should not be reachable.");
            };
        } else {
            int ones = n % 10;
            int tens = n / 10;
            StringBuilder str = new StringBuilder();
            if (tens > 1) {
                str.append(TENS[tens - 2]).append(" ");
            }
            if (ones > 0) {
                str.append(intToStringOnes(ones));
            }
            return str.toString();
        }
    }

    private static String intToStringOnes(int n) {
        Preconditions.checkArgument(n > 0 && n < 10);
        return switch (n) {
            case 1 -> "one";
            case 2 -> "two";
            case 3 -> "three";
            case 4 -> "four";
            case 5 -> "five";
            case 6 -> "six";
            case 7 -> "seven";
            case 8 -> "eight";
            case 9 -> "nine";
            default -> throw new IllegalStateException("Should not be reachable.");
        };
    }

    private NumberStrings() {}
}
