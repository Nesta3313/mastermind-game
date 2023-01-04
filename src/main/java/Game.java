import java.util.Scanner;

public class Game {
    private static final int NUMBER = 4;
    private static final int UPPERBOUND = 7;

    private static final int REMAINING_GUESS = 10;

    private static int score = 1000;

    private static int totalScore = 0;


    private static final Scanner input = new Scanner(System.in);



    public static void mainPlay() {
        while(true) {
            String code = ApiCall.generateApiCode(NUMBER, UPPERBOUND);

            Play play = new Play(code, score);

            int turn = 0;

            while(turn < REMAINING_GUESS) {

                System.out.printf("Guess the Mastermind code. Choose %d digits from 0 to %d inclusive. " +
                        "Digits can be repeated, You have %d guesses left%n",  NUMBER, UPPERBOUND, REMAINING_GUESS - turn);

                System.out.print("Enter your guess: ");
                String guessedNum = input.nextLine().trim();

                if (!guessedNum.matches("\\d{" + NUMBER + "}")) {
                    System.out.println("Please enter a valid number of " + NUMBER + " digits.");
                    continue;
                }

                if (guessedNum.equals(code)) {
                    System.out.printf("You are correct! Code solved in %s turn(s) %n", turn + 1);
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

            int currentScore = play.getScore();
            System.out.printf("The code was %s%n", code);
            System.out.printf("Current game score: %d%n", currentScore);

            totalScore += currentScore;
            System.out.print("Play again, Y/N? ");


            String choice = input.nextLine().trim().toLowerCase();
            if (choice.equals("n")) {
                System.out.println("Game Over!");
                play.displayTimeTaken();

                System.out.printf("Total game score: %d", totalScore);

                break;
            }

        }
    }




}
