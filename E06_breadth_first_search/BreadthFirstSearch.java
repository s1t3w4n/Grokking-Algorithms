package E06_breadth_first_search;

import java.util.*;

public class BreadthFirstSearch {
    public static void main(String[] args) {
        graph.put("you", List.of("alice", "bob", "claire"));
        graph.put("bob", List.of("anuj", "peggy"));
        graph.put("alice", List.of("peggy"));
        graph.put("claire", List.of("thom", "jonny"));
        graph.put("anuj", Collections.emptyList());
        graph.put("peggy", Collections.emptyList());
        graph.put("thom", Collections.emptyList());
        graph.put("jonny", Collections.emptyList());
        System.out.println(search("you"));
    }

    private static final Map<String, List<String>> graph = new HashMap<>();

    @SuppressWarnings("SameParameterValue")
    private static boolean search(String name) {
        Queue<String> searchQueue = new ArrayDeque<>(graph.get(name));
        List<String> searched = new ArrayList<>();
        while (!searchQueue.isEmpty()) {
            String person = searchQueue.poll();
            if (!searched.contains(person)) {
                if (person_is_seller(person)) {
                    System.out.println(person + " is a mango seller!");
                } else {
                    searchQueue.addAll(graph.get(person));
                    searched.add(person);
                }
            }
        }
        return false;
    }

    private static boolean person_is_seller(String name) {
        return name.endsWith("m");
    }
}
