/* Implementation of Sieve of Eratosthenes */
import java.util.Arrays;
import java.util.Scanner;

public class PrimeSeive {
    public static void main(String[] args) {
        int n;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the limit : ");
            n = sc.nextInt();
        }

        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        for (int i = 2; (i * i) <= n; i++) {
            if (isPrime[i]) {
                for (int k = (i * i); k <= n; k += i)
                    isPrime[k] = false;
            }
        }

        System.out.println(String.format("\nAll prime numbers from 1 to %d are :", n));
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i])
                System.out.print(i + " ");
        }
        System.out.println("\n");
    }
}
