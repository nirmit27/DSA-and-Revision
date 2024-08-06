import java.util.Scanner;
import java.util.ArrayList;

class Kadane {
    public static void display(ArrayList<Integer> arr){
        if(arr.size() == 0) return;
        
        System.out.print("\nArray status : ");
        for(int i: arr) System.out.print(i + " ");
        System.out.println();
    }
    
    public static int kadane(ArrayList<Integer> arr){
        if(arr.size() == 0) return 0;
        
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        for(int i : arr){
            sum += i;
            if(sum > ans) ans = sum;
            if(sum < 0) sum = 0;
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int size;
        ArrayList<Integer> arr = new ArrayList<>();
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("\nEnter the size : ");
            size = sc.nextInt();
            System.out.print("\nEnter the elements : ");
            for(int i=0; i<size; i++){
                int x = sc.nextInt();
                arr.add(x);
            }
        }
        display(arr);
        System.out.print(String.format("\nMaximum sub-array sum = %d\n", kadane(arr)));
    }
}
