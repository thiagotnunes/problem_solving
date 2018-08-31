package graph.examples.example_1;

import graph.types.Graph;

import java.util.HashSet;
import java.util.Set;

/**
 * Check if path exists from v to u
 */
public class Solution {
    /**
     * Time complexity - O(V + E)
     * Space complexity - O(V)
     */
    public boolean solve1(Graph graph, int from, int to) {
        Set<Integer> seen = new HashSet<>();

        return dfs(graph, from, to, seen);
    }

    private boolean dfs(Graph graph, int from, int to, Set<Integer> seen) {
        if (from == to) return true;

        for (Integer neighbour : graph.neighbours(from)) {
            if (seen.contains(neighbour)) continue;

            seen.add(neighbour);

            if (dfs(graph, neighbour, to, seen)) return true;
        }

        return false;
    }
}
