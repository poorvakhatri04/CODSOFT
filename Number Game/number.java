import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int RANGE_MIN = 1;
    private static final int RANGE_MAX = 100;
    private static final int MAX_ATTEMPTS = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
        int roundsWon = 0;
        int totalRounds = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Try to guess the number between " + RANGE_MIN + " and " + RANGE_MAX + ".");

        while (playAgain) {
            totalRounds++;
            Random random = new Random();
            int randomNumber = random.nextInt(RANGE_MAX - RANGE_MIN + 1) + RANGE_MIN;
            int attemptsLeft = MAX_ATTEMPTS;
            boolean guessedCorrectly = false;

            System.out.println("\n--- Round " + totalRounds + " ---");
            System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess the number.");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int userGuess;

                try {
                    userGuess = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a number.");
                    continue;
                }

                if (userGuess < RANGE_MIN || userGuess > RANGE_MAX) {
                    System.out.println("Your guess must be between " + RANGE_MIN + " and " + RANGE_MAX + ".");
                    continue;
                }

                attemptsLeft--;

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number: " + randomNumber);
                    guessedCorrectly = true;
                    roundsWon++;
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Attempts left: " + attemptsLeft);
                } else {
                    System.out.println("Too high! Attempts left: " + attemptsLeft);
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all attempts. The correct number was: " + randomNumber);
            }

            System.out.println("Rounds won: " + roundsWon + "/" + totalRounds);

            System.out.print("\nDo you want to play another round? (yes/no): ");
            String userResponse = scanner.nextLine().toLowerCase();
            playAgain = userResponse.equals("yes");
        }

        System.out.println("Thank you for playing! You won " + roundsWon + " out of " + totalRounds + " rounds.");
        scanner.close();
    }
}

