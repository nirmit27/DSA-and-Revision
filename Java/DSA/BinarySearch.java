/* Order-agnostic Binary Search + Ceil element + Floor element */

import java.util.Scanner;
import java.util.ArrayList;

public class BinarySearch {
    static int ceil(ArrayList<Integer> arr, int n) {
        if (arr == null || arr.size() == 0) {
            return -1;
        }

        int l = 0, r = arr.size() - 1;
        if (n > arr.get(r)) {
            return -1;
        }

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr.get(mid) == n) {
                return arr.get(mid);
            }
            if (n < arr.get(mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return arr.get(l);
    }

    static int floor(ArrayList<Integer> arr, int n) {
        if (arr == null || arr.size() == 0) {
            return -1;
        }

        int l = 0, r = arr.size() - 1;
        if (n < arr.get(l)) {
            return -1;
        }

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr.get(mid) == n) {
                return arr.get(mid);
            }

            if (n < arr.get(mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return arr.get(r);
    }

    static int search(ArrayList<Integer> arr, int n) {
        if (arr == null || arr.size() == 0) {
            return -1;
        }

        int l = 0, r = arr.size() - 1;
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
        int n, ch, size, result;
        ArrayList<Integer> arr = new ArrayList<>();

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the array size : ");
            size = sc.nextInt();

            System.out.print("\nEnter the array elements : ");
            for (int i = 0; i < size; i++) {
                int x = sc.nextInt();
                arr.add(x);
            }
            System.out.print("\nEnter the target element : ");
            n = sc.nextInt();

            System.out
                    .print("\nOptions :-\n1 - Binary search\n2 - Ceil value\n3 - Floor value\nEnter your choice : ");
            ch = sc.nextInt();
        }

        switch (ch) {
            case 1:
                result = search(arr, n);
                if (result != -1) {
                    System.out.println(String.format("\nIndex of %d = %d", n, result));
                } else {
                    System.out.println(String.format("\n%d does not exist in the array.", n));
                }
                break;
            case 2:
                result = ceil(arr, n);
                if (result != -1) {
                    System.out.println(String.format("\nCeil value of %d = %d", n, result));
                } else {
                    System.out.println(String.format("\nCeil value of %d does not exist in the array.", n));
                }
                break;
            case 3:
                result = floor(arr, n);
                if (result != -1) {
                    System.out.println(String.format("\nFloor value of %d = %d", n, result));
                } else {
                    System.out.println(String.format("\nFloor value of %d does not exist in the array.", n));
                }
                break;
            default:
                System.out.println("\nWrong choice, please try again!");
        }
    }
}