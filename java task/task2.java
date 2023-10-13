/*2. Create a program that generates and prints the Fibonacci sequence up to a specified number of terms. 
The Fibonacci sequence is a series of numbers where each number is the sum of the two preceding ones, typically starting with 0 and 1. */

import java.util.Scanner;

public class FibonacciSequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of terms in the Fibonacci sequence: ");
        int numTerms = scanner.nextInt();

        generateFibonacci(numTerms);
    }

    public static void generateFibonacci(int numTerms) {
        int firstTerm = 0;
        int secondTerm = 1;

        System.out.println("Fibonacci Sequence:");

        for (int i = 1; i <= numTerms; i++) {
            System.out.print(firstTerm + " ");

            int nextTerm = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = nextTerm;
        }
    }
}
