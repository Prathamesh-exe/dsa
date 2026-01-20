import java.util.*;
public class DijkstraAlgo {
    public static void main(String[] args) {
        int[][] graph = {
            {0, 1, 4},
            {1, 0, 2},
            {4, 2, 0}
        };
        int source = 0;
        int[] distances = dijkstra(graph, source);
        System.out.println("Shortest distances from source " + source + ": " + Arrays.toString(distances));
    }

    private static int[] dijkstra(int[][] graph, int source) {
        int V = graph.length;
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];
        
        // Initialize distances
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        
        // Min-heap to select the vertex with the smallest distance (distance, vertex)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );
        minHeap.add(new int[]{0, source});

        while (!minHeap.isEmpty()) {
            // Extract the vertex with the smallest distance
            int[] current = minHeap.remove();
            int currentDist = current[0];
            int u = current[1]; // current vertex

            if (visited[u]) continue;
            visited[u] = true;
            
            // Relaxation step for all adjacent vertices of u
            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !visited[v]) {
                    int newDist = currentDist + graph[u][v];
                    if (newDist < dist[v]) {
                        dist[v] = newDist;
                        minHeap.add(new int[]{newDist, v});
                    }
                }
            }
        }
        return dist;
    }
}
