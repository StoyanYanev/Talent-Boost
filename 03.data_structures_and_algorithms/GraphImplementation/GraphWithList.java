package GraphImplementation;

import java.util.*;

public class GraphWithList implements Graph {
    private Map<Integer, Set<Integer>> graph;

    private void DfsHelper(int s, boolean visited[]) {
        visited[s] = true;
        System.out.print(s + " ");
        for (Integer val : this.graph.get(s)) {
            if (visited[val] == false) {
                DfsHelper(val, visited);
            }
        }
    }

    GraphWithList() {
        this.graph = new HashMap<>();
    }

    @Override
    public void addEdge(int source, int destination) {
        if (!this.graph.containsKey(source)) {
            this.graph.put(source, new HashSet<>());
        }
        this.graph.get(source).add(destination);
    }

    @Override
    public Graph transposingGraph() {
        Graph g = new GraphWithList();
        for (Integer key : this.graph.keySet()) {
            for (Integer val : this.graph.get(key)) {
                g.addEdge(val, key);
            }
        }
        return g;
    }

    @Override
    public void Dfs(int s) {
        boolean visited[] = new boolean[this.graph.size()];
        this.DfsHelper(s, visited);
    }

    @Override
    public void Bfs(int s) {
        boolean visited[] = new boolean[this.graph.size()];
        Queue<Integer> queue = new ArrayDeque<>();
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s + " ");
            for (Integer val : this.graph.get(s)) {
                if (visited[val] == false) {
                    visited[s] = false;
                    queue.add(val);
                }
            }
        }
    }
}