import java.util.*;

public class OptimalMergePatterns {
    public static int optimalMerge(int[] files, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.add(files[i]);
        }

        int cost = 0;

        while (pq.size() > 1) {
            int file1 = pq.poll();
            int file2 = pq.poll();
            int mergedFile = file1 + file2;
            cost += mergedFile;
            pq.add(mergedFile);
        }

        return cost;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of files: ");
        int n = input.nextInt();

        int[] files = new int[n];

        System.out.println("Enter the sizes of the files:");
        for (int i = 0; i < n; i++) {
            files[i] = input.nextInt();
        }

        int minCost = optimalMerge(files, n);
        System.out.println("Minimum cost of merging is: " + minCost + " Comparisons");

        input.close();
    }
}
