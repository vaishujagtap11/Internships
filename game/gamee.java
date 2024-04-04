package game;

import java.util.Random;
import java.util.Scanner;

public class gamee {
	public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        int no = rand.nextInt(100) + 1; // Generate random number between 1 and 100
        int guess, attempt = 0;
        System.out.println("Enter a number between 1 to 100:");

        do {
            guess = sc.nextInt();
            attempt++;
            if (guess == no) {
                System.out.format("Congratulations! You guessed it correctly in %d attempts\n", attempt);
                break;
            } else if (guess < no) {
                System.out.println("Oops! Too Low");
                System.out.println("Guess a higher number:");
            } else {
                System.out.println("Oops! Too High");
                System.out.println("Guess a lower number:");
            }
        } while (attempt < 10);

        if (attempt >= 10) {
            System.out.println("You have attempted more than 10 times. The number was: " + no);
        }

        sc.close(); // Close the scanner
    }
}
