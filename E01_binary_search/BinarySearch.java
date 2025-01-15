package E01_binary_search;

import java.util.List;
import java.util.Optional;

public class BinarySearch {
    public static void main(String[] args) {
        List<Integer> myList = List.of(1, 3, 5, 6, 7, 9);
        System.out.println("TEXT 1: index of value 3 eq 1: " + binarySearch(myList, 3).equals(Optional.of(1)));
        System.out.println("TEXT 2: no value with -1 in list: " + binarySearch(myList, -1).equals(Optional.empty()));
        System.out.println("TEXT 3: index of value 6 eq 3: " + binarySearch(myList, 6).equals(Optional.of(3)));
        System.out.println("TEXT 4: index of value 9 eq 5: " + binarySearch(myList, 9).equals(Optional.of(5)));
    }

    public static Optional<Integer> binarySearch(List<Integer> list, Integer item) {
        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            Integer guess = list.get(mid);
            if (guess.equals(item)) {
                return Optional.of(mid);
            } else if (guess > item) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return Optional.empty();
    }
}
