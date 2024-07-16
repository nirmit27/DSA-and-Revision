import java.util.Scanner;
import java.util.ArrayList;

public class Recursion {
    static int linearSearch(ArrayList<Integer> arr, int index, int target) {
        if (arr.size() == 0)
            return -1;
        if (index == arr.size() - 1)
            return -1;
        if (arr.get(index) == target)
            return index;

        return linearSearch(arr, index + 1, target);
    }

    static boolean isSorted(ArrayList<Integer> arr, int index) {
        if (index == arr.size() - 1)
            return true;
        return (arr.get(index) < arr.get(index + 1)) && isSorted(arr, index + 1);
    }

    public static void main(String[] args) {
        int n, target, result;
        ArrayList<Integer> arr = new ArrayList<>();

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the size : ");
            n = sc.nextInt();
            System.out.print("\nEnter the elements : ");
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                arr.add(x);
            }
            System.out.print("\nEnter the target : ");
            target = sc.nextInt();
        }
        if (isSorted(arr, 0))
            System.out.println(String.format("\nThe given array is sorted!"));
        else
            System.out.println(String.format("\nThe given array is NOT sorted."));

        result = linearSearch(arr, 0, target);
        if (result != -1)
            System.out.println(String.format("\n%d found at index : %d", target, result));
        else
            System.out.println(String.format("\n%d not found!", target));
    }
}