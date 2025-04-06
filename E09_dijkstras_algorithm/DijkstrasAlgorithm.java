package E09_dijkstras_algorithm;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class DijkstrasAlgorithm {
    public static final String START = "start";
    public static final String END = "end";

    public static void main(String[] args) {
        Map<String, Map<String, Integer>> weightedGraph =
                Map.of(
                        START, Map.of("A", 6, "B", 2),
                        "B", Map.of("A", 3, END, 5),
                        "A", Map.of(END, 1),
                        END, Map.of()

                );
        Map<String, Integer> costs = new HashMap<>(weightedGraph.get(START));
        costs.put(END, Integer.MAX_VALUE);
        PriorityQueue<String> queue = weightedGraph.get(START).keySet().stream()
                .collect(Collectors.toCollection(
                        () -> new PriorityQueue<>(Comparator.comparingInt(costs::get))
                ));


        Map<String, String> parents = new HashMap<>();
        weightedGraph.get(START).keySet().forEach(k -> parents.put(k, START));
        parents.put(END, null);

        while (Boolean.FALSE.equals(queue.isEmpty())) {
            String currentNode = queue.poll();
            for (Map.Entry<String, Integer> e: weightedGraph.get(currentNode).entrySet()) {
                int newCost = costs.get(currentNode) + e.getValue();
                if (costs.get(e.getKey()) > newCost) {
                    queue.remove(e.getKey());
                    costs.put(e.getKey(), newCost);
                    parents.put(e.getKey(), currentNode);
                    queue.add(e.getKey());
                }
            }
        }
        StringBuilder pathBuilder = new StringBuilder();
        String currentStep = END;
        while (Boolean.FALSE.equals(START.equals(currentStep))) {
            pathBuilder.insert(0, "-" + costs.get(currentStep) + ">" + currentStep);
            currentStep = parents.get(currentStep);
        }
        pathBuilder.insert(0, currentStep);
        System.out.println(parents);
        System.out.println(costs);
        System.out.println(pathBuilder);
    }
}
