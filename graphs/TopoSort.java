
import java.util.*;

//only for Directed Acyclic Graphs(DAG) no cycles allowed
public class TopoSort {

    public static void main(String[] args) {
        int V = 6; // Number of vertices
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Example edges
        addEdge(adj, 5, 2);
        addEdge(adj, 5, 0);
        addEdge(adj, 4, 0);
        addEdge(adj, 4, 1);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 1);

        List<Integer> topoOrderDFS = topoSortDFS(V, adj);
        System.out.println("Topological Sort Order DFS: " + topoOrderDFS);

        List<Integer> topoOrderBFS = topoSortBFS(V, adj);
        System.out.println("Topological Sort Order BFS: " + topoOrderBFS);
    }

    private static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v); // Directed graph
    }

    private static List<Integer> topoSortDFS(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        // Perform DFS from each unvisited node
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, stack);
            }
        }

        List<Integer> topoOrder = new ArrayList<>();
        while (!stack.isEmpty()) {
            topoOrder.add(stack.pop());
        }
        return topoOrder;
    }

    private static void dfs(int node, List<List<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        // Explore all adjacent nodes
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                // Recursively visit all unvisited neighbors
                dfs(neighbor, adj, visited, stack);
            }
        }
        // After visiting all neighbors, push the node to stack
        stack.push(node);
    }

    private static List<Integer> topoSortBFS(int V, List<List<Integer>> adj) {
        int[] inDegree = new int[V];
        // Calculate in-degrees of all vertices
        for (int i = 0; i < V; i++) {
            for (int neighbor : adj.get(i)) {
                inDegree[neighbor]++;
            }
        }
// push all vertices with in-degree 0 into the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> topoOrder = new ArrayList<>();
        // Process vertices in the queue
        while (!queue.isEmpty()) {
            int node = queue.remove();
            topoOrder.add(node);

// Decrease in-degree of neighboring vertices
            for (int neighbor : adj.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
// Check for cycle (if topoOrder doesn't contain all vertices)
        if (topoOrder.size() != V) {
            throw new IllegalStateException("Graph has a cycle, topological sort not possible");
        }

        return topoOrder;

    }
}
