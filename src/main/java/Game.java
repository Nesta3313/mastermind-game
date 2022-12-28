import java.util.Scanner;

public class Game {
    private static final int NUMBER = 4;
    private static final int UPPERBOUND = 7;

    private static final int REMAINING_GUESS = 10;

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        while(true) {
            String code = ApiCall.generateApiCode(NUMBER, UPPERBOUND);

            System.out.println(code);

            Play play = new Play(code);

            int turn = 0;

            while(turn < REMAINING_GUESS) {

                System.out.printf("Guess the Mastermind code. Choose %d digits between 0 and %d inclusive.", NUMBER, UPPERBOUND);
//                if (turn > 0) {
//                    play.seeGameHistory();
//                }

                System.out.println(String.format("You have %d guesses left", REMAINING_GUESS - turn));

                System.out.print("Enter your choice: ");
                String guessedNum = input.nextLine().trim();
                if (!guessedNum.matches("\\d{" + NUMBER + "}")) {
                    System.out.println("Please enter a valid guessedNum of " + NUMBER + " digits.");
                    continue;
                }

                if (guessedNum.equals(code)) {
                    System.out.printf("Congratulations! You solved it in %d guesses!", turn + 1);
                    break;
                } else {
                    String feedBack = play.getFeedBack(guessedNum);
                    play.populateGuessMap(guessedNum, feedBack);
                    turn++;

                    if (feedBack.isEmpty()) {
                        System.out.println("None of the numbers you guessed were correct or in the right place");
                    } else {
                        System.out.println("Sorry, try again!");
                        play.seeGameHistory();
                    }
                }

            }

            System.out.printf("The code was %s%n", code);
            System.out.print("Do you want to try again, Y/N? ");
            String choice = input.nextLine().trim().toLowerCase();
            if (choice.equals("n")) {
                System.out.println("Goodbye!!");
                break;
            }

        }
    }
}
