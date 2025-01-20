package E03_recursion;

public class Recursion {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.print(fibonacciCalc(i) + " ");
        }
        System.out.println();
        int[] numbers = {1, 2, 13, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("simpleSum:" + simpleSum(numbers));
        System.out.println("recursiveSum:" + recursiveSum(numbers));
        System.out.println("size:" + numbers.length);
        System.out.println("recursiveCont:" + recursiveCount(numbers));
        System.out.println("recursiveMax:" + recursiveMax(numbers));
    }

    private static int recursiveMax(int[] numbers) {
        return recursiveMax(numbers, 0);
    }

    private static int recursiveMax(int[] numbers, int index) {
        if (index + 1 == numbers.length) {
            return numbers[index];
        }
        return Math.max(numbers[index], recursiveMax(numbers, index + 1));
    }

    private static long simpleSum(int[] numbers) {
        long sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    private static long recursiveSum(int[] numbers) {
        return recursiveSum(numbers, 0);
    }

    private static long recursiveSum(int[] numbers, int index) {
        if (index == numbers.length) {
            return 0;
        }
        return numbers[index] + (int) recursiveSum(numbers, index + 1);
    }

    private static long recursiveCount(int[] numbers) {
        return recursiveCount(numbers, 0);
    }

    private static long recursiveCount(int[] numbers, int index) {
        if (index == numbers.length) {
            return 0;
        }
        return recursiveCount(numbers, index + 1) + 1;
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
