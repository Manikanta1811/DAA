import java.util.Scanner;
import java.util.Arrays;
class Job {
    char id;
    int deadline;
    int profit;
    public Job(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}
public class JobSequencing {
    public static void printJobSequence(Job[] jobs) {
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
        int n = jobs.length;
        int maxDeadline = getMaxDeadline(jobs);
        char[] result = new char[maxDeadline];
        boolean[] slot = new boolean[maxDeadline];
        Arrays.fill(slot, false);
        for (int i = 0; i < n; i++) {
            for (int j = Math.min(maxDeadline - 1, jobs[i].deadline - 1); j >= 0; j--) {
                if (!slot[j]) {
                    result[j] = jobs[i].id;
                    slot[j] = true;
                    break;
                }
            }
        }
        for (char job : result) {
            System.out.print(job + " ");
        }
    }
    private static int getMaxDeadline(Job[] jobs) {
        int maxDeadline = Integer.MIN_VALUE;
        for (Job job : jobs) {
            if (job.deadline > maxDeadline) {
                maxDeadline = job.deadline;
            }
        }
        return maxDeadline;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of jobs: ");
        int n = sc.nextInt();
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter job id, deadline, and profit for job " + (i + 1) + ": ");
            char id = sc.next().charAt(0);
            int deadline = sc.nextInt();
            int profit = sc.nextInt();
            jobs[i] = new Job(id, deadline, profit);
        }
        System.out.println("Job sequence:");
        printJobSequence(jobs);
        sc.close();
    }
}
