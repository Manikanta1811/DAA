import java.util.Scanner;
public class BinarySearch {
    public static int binarySearch(int[] arr, int target, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid; 
            } else if (arr[mid] < target) {
                return binarySearch(arr, target, mid + 1, right); 
            } else {
                return binarySearch(arr, target, left, mid - 1); 
            }
        }
        return -1; 
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] sortedArray = new int[size];
        System.out.println("Enter the elements of the sorted array:");
        for (int i = 0; i < size; i++) {
            sortedArray[i] = scanner.nextInt();
        }
        System.out.print("Enter the target value to search: ");
        int target = scanner.nextInt();
        int result = binarySearch(sortedArray, target, 0, size - 1);
        if (result != -1) {
            System.out.println("Element " + target + " found at index " + result);
        } else {
            System.out.println("Element " + target + " not found in the array");
        }
        scanner.close();
    }
}