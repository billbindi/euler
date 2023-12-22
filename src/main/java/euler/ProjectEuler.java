package euler;

public class ProjectEuler {

    public static void main(String[] args) {
        System.out.println(euler1(1000));
    }

    /**
     * Find the sum of all the multiples of 3 or 5 below n.
     */
    private static int euler1(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
