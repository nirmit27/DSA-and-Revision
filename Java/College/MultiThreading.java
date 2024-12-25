package College;
/* 2 Examples of Multithreading in Java */

import java.util.Scanner;

class MultiThreadingDemo1 implements Runnable { // Type 1 - By implementing the `Runnable` interface
    public void run() {
        try {
            System.out.println(String.format("Runnable %d is running", Thread.currentThread().threadId()));
        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }
    }
}

class MultiThreadingDemo2 extends Thread { // Type 2 - By extending the `Thread` class
    public void run() {
        try {
            System.out.println(String.format("Thread %d is running", Thread.currentThread().threadId()));
        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }
    }
}

public class MultiThreading {
    public static void main(String[] args) {
        int n;
        try (Scanner sc = new Scanner(System.in);) {
            System.out.print("Enter the number of threads to run : ");
            n = sc.nextInt();
        }

        System.out.println(String.format("\nWe are currently running %d runnables ...\n", n));
        for (int i = 0; i < n; i++) {
        Thread thread = new Thread(new MultiThreadingDemo1());
        thread.start();
        }

        // System.out.println(String.format("\nWe are currently running %d threads ...\n", n));
        // for (int i = 0; i < n; i++) {
        //     Thread thread = new MultiThreadingDemo2();
        //     thread.start();
        // }
    }
}