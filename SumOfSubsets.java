import java.util.*;

public class SumOfSubsets {
    
    public static void findSubsets(int[] arr, int targetSum, int index, List<Integer> subset, int currentSum) {
        if (currentSum == targetSum) {
            System.out.println("Subset with sum " + targetSum + ": " + subset);
            return;
        }
        
        if (currentSum > targetSum || index == arr.length) {
            return;
        }
        
        subset.add(arr[index]);
        currentSum += arr[index];
        
        findSubsets(arr, targetSum, index + 1, subset, currentSum);
        
        subset.remove(subset.size() - 1);
        currentSum -= arr[index];
        
        findSubsets(arr, targetSum, index + 1, subset, currentSum);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        System.out.print("Enter the target sum: ");
        int targetSum = scanner.nextInt();
        
        List<Integer> subset = new ArrayList<>();
        findSubsets(arr, targetSum, 0, subset, 0);
        
        scanner.close();
    }
}