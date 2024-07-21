import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n;
        LList ll = new LList();
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the size of the linked list : ");
            n = sc.nextInt();
            System.out.print("\nEnter the node values : ");
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                ll.insertLast(x);
            }
        }
        /*
         * ll.traversal();
         * ll.insert(2, 3);
         * ll.insert(5, 7);
         * ll.traversal();
         * ll.deleteLast();
         * ll.traversal();
         * ll.delete(3);
         */
        ll.traversal();
        ll.reversal();
        ll.traversal();
    }
}
