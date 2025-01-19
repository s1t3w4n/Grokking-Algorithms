package E03_recursion;

public class Recursion {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(fibonacciCalc(i));
        }
    }

    private static long fibonacciCalc(int count) {
        if (count <= 0) {
            return 0;
        }
        return recursion(0, 1, 1, count);
    }

    private static long recursion(long val1, long val2, int count, int target) {
        if (count == target) {
            return val2;
        }
        return recursion(val2, val1 + val2, count + 1, target);
    }
}
