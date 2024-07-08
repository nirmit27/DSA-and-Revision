import java.util.Scanner;
import java.util.ArrayList;

public class BinarySearch {
    public static int search(ArrayList<Integer> arr, int n) {
        if (arr == null || arr.size() == 0) {
            return -1;
        }

        int l = 0;
        int r = arr.size() - 1;

        boolean isAsc = arr.get(l) < arr.get(r);

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr.get(mid) == n) {
                return mid;
            }

            if (isAsc) {
                if (n < arr.get(mid)) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (n < arr.get(mid)) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int n, size, index;
        ArrayList<Integer> arr = new ArrayList<>();

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the array size : ");
            size = sc.nextInt();

            System.out.print("\nEnter the array elements : ");
            for (int i = 0; i < size; i++) {
                int x = sc.nextInt();
                arr.add(x);
            }
            System.out.print("\nEnter the element to be searched : ");
            n = sc.nextInt();
        }
        index = search(arr, n);
        if (index != -1) {
            System.out.println(String.format("\nIndex of %d = %d", n, index));
        } else {
            System.out.println(String.format("\n%d does not exist in the array.", n));
        }
    }
}