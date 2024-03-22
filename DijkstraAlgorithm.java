import java.util.Scanner;

public class DijkstraAlgorithm {
    private static final int MAX = 10005;
    private static final int INF = 1000000000;

    private static int[][] graph = new int[MAX][MAX];
    private static int[] dist = new int[MAX];
    private static boolean[] visited = new boolean[MAX];

    private static int V, source;

    private static void dijkstra() {
        for (int i = 0; i < V; i++) {
            dist[i] = INF;
            visited[i] = false;
        }

        dist[source] = 0;

        for (int i = 0; i < V - 1; i++) {
            int u = -1;
            for (int j = 0; j < V; j++) {
                if (!visited[j] && (u == -1 || dist[j] < dist[u])) {
                    u = j;
                }
            }

            visited[u] = true;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] > 0) {
                    int newDist = dist[u] + graph[u][v];
                    if (newDist < dist[v]) {
                        dist[v] = newDist;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of vertices in the graph: ");
        V = input.nextInt();

        System.out.println("Enter the adjacency matrix of the graph:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = input.nextInt();
            }
        }

        System.out.print("Enter the source vertex: ");
        source = input.nextInt();

        dijkstra();

        System.out.println("Shortest paths from source vertex " + source + " to all other vertices:");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " " + dist[i]);
        }

        input.close();
    }
}
