import java.util.Scanner;

public class Game {
    private static final int NUMBER = 4;
    private static final int UPPERBOUND = 7;

    private static final int REMAINING_GUESS = 3;

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        while(true) {
            String code = ApiCall.generateApiCode(NUMBER, UPPERBOUND);

            System.out.println(code);

            Play play = new Play(code);

            int turn = 0;

            while(turn < REMAINING_GUESS) {

                System.out.println(String.format("Guess the Mastermind code. Choose %d digits between 0 and %d inclusive. " +
                        "Digits can be repeated, You have %d guesses left",  NUMBER, UPPERBOUND, REMAINING_GUESS - turn));

                System.out.println("Enter your guess: ");
                String guessedNum = input.nextLine().trim();
                if (!guessedNum.matches("\\d{" + NUMBER + "}")) {
                    System.out.println("Please enter a valid number of " + NUMBER + " digits.");
                    continue;
                }

                if (guessedNum.equals(code)) {
                    System.out.printf("You are correct! code solved in %s turns", turn + 1);
                    break;
                } else {
                    String feedBack = play.getFeedBack(guessedNum);
                    play.populateGuessMap(guessedNum, feedBack);
                    turn++;

                    if (feedBack.isEmpty()) {
                        System.out.println("You did not guess the correct number(s) or any digit(s) in the right position");
                    } else {
                        System.out.println("Try again!");
                        play.seeGameHistory();
                    }
                }

            }

            System.out.println("You ran out of turns");
            System.out.println(String.format("The code was %s", code));
            System.out.print("Play again, Y/N? ");

            String choice = input.nextLine().trim().toLowerCase();
            if (choice.equals("n")) {
                System.out.println("Game Over!");
                play.displayTimeTaken();
                break;
            }

        }
    }
}
