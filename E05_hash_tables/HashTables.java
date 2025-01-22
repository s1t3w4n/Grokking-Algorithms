package E05_hash_tables;

import java.util.HashMap;
import java.util.Map;

public class HashTables {
    private static final Map<String, Boolean> voted = new HashMap<>();

    public static void main(String[] args) {
        checkVoter("tom"); // let them vote!
        checkVoter("mike"); // let them vote!
        checkVoter("mike"); // kick them out!

        Map<String, Double> book = new HashMap<>();

        // an apple costs 67 cents
        book.put("apple", 0.67);
        // milk costs $1.49
        book.put("milk", 1.49);
        book.put("avocado", 1.49);

        System.out.println(book); // {apple=0.67, avocado=1.49, milk=1.49}
    }

    private static void checkVoter(String name) {
        if (voted.containsKey(name)) {
            System.out.println("kick them out!");
        } else {
            voted.put(name, true);
            System.out.println("let them vote!");
        }
    }
}
