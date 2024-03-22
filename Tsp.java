import java.util.Scanner;
import java.util.Arrays;

public class Tsp{

    public static int tsp(int[][] graph, int mask, int current, int n, int[][] dp) {
        if (mask == (1 << n) - 1) {
            return graph[current][0];
        }

        if (dp[mask][current] != -1) {
            return dp[mask][current];
        }

        int minCost = Integer.MAX_VALUE;

        for (int city = 0; city < n; city++) {
            if ((mask & (1 << city)) == 0) {
                int newMask = mask | (1 << city);
                int cost = graph[current][city] + tsp(graph, newMask, city, n, dp);

                minCost = Math.min(minCost, cost);
            }
        }

        dp[mask][current] = minCost;

        return minCost;
    }

    public static int solveTSP(int[][] graph) {
        int n = graph.length;
        int[][] dp = new int[1 << n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return tsp(graph, 1, 0, n, dp);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of cities: ");
        int n = scanner.nextInt();

        int[][] graph = new int[n][n];
       
        System.out.println("Enter the adjacency matrix for the graph:");
       
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        int minCost = solveTSP(graph);

        System.out.println("Minimum cost of TSP: " + minCost);
       
        scanner.close();
    }
}