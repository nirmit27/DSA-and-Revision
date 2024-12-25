package GfG.BinarySearch;
/* 
GfG problem - "Allocate Minimum Pages" solution
Link : https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1
 */

import java.util.Arrays;
import java.util.Scanner;

public class AllocMinPages {
    private static boolean canAllocate(int[] arr, int pageLimit, int students) {
        int count = 1, pageCount = 0;
        for (int pages : arr) {
            if (pageCount + pages <= pageLimit)
                pageCount += pages;
            else {
                count++;
                pageCount = pages;
            }
        }
        return count <= students;
    }
    
    public static int allocatePages(int[] arr, int students) {
        if (students > arr.length)
            return -1;
        if (students == 1)
            return Arrays.stream(arr).sum();
        if (students == arr.length)
            return Arrays.stream(arr).max().getAsInt();
        
        int res = -1;
        int low = Arrays.stream(arr).max().getAsInt(), high = Arrays.stream(arr).sum();
        int mid = low + (high - low) / 2;
        
        while (low <= high) {
            if (canAllocate(arr, mid, students)) {
                res = mid;
                high = mid - 1;
            } else 
                low = mid + 1;
            mid = low + (high - low) / 2;
        }
        return res;        
    }

    public static void main(String[] args) {
        int[] books;
        int size, students, result;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the number of books : ");
            size = sc.nextInt();
            books = new int[size];

            System.out.print("\nEnter the page count of books : ");
            for (int i = 0; i < size; i++)
                books[i] = sc.nextInt();
            
            System.out.print("\nEnter the number of students : ");
            students = sc.nextInt();
        }
        result = allocatePages(books, students);
        if (result != -1)
            System.out.println(String.format("\nMinimized maximum number of allocated pages : %d", result));
        else
            System.out.println("\nBook allocation not possbile.");
    }
}
