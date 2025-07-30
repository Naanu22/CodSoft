import java.util.Scanner; // For reading user input
import java.util.Random;  // For generating random numbers

public class NumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int roundsPlayed = 0;
        int roundsWon = 0;
        boolean playAgain = true;

        System.out.println("🎯 Welcome to the Number Guessing Game!");

        // Main game loop — keeps running until the user says "no"
        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1; // Secret number between 1 and 100
            int maxAttempts = 10;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\n I'm thinking of a number between 1 and 100. Can you guess it?");
            System.out.println("You have " + maxAttempts + " attempts. Good luck!");

            // Guessing loop
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess;

                // Validate input
                if (scanner.hasNextInt()) {
                    guess = scanner.nextInt();
                } else {
                    System.out.println("❌ Please enter a valid number.");
                    scanner.next(); // clear invalid input
                    continue;
                }

                attempts++;

                // Check guess and give feedback
                if (guess == numberToGuess) {
                    System.out.println("✅ Correct! You guessed it in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    roundsWon++;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("⬆️ Too low!");
                } else {
                    System.out.println("⬇️ Too high!");
                }

                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            // If player didn’t guess the number
            if (!guessedCorrectly) {
                System.out.println("Out of attempts! The number was: " + numberToGuess);
            }

            roundsPlayed++;

            // Ask to play again
            System.out.print("\n Do you want to play another round? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        // Show final results
        System.out.println("\n Game Over!");
        System.out.println("Rounds played: " + roundsPlayed);
        System.out.println("Rounds won: " + roundsWon);
        System.out.println("Thanks for playing!");

        scanner.close();
    }
}
