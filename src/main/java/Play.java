import java.util.*;

public class Play {

    private String code;
    private int numberOfGuesses;

    private String[] list;

    public Play(String code) {
        this.code = code;
        numberOfGuesses = 1;
        list = new String[10];
    }

//    public static void main(String[] args) {
//        String sb = "";
//        sb = String.format("my name is %s", "nesta");
//        System.out.println(sb);
//        sb = String.format("Age is %s", "37");
//        System.out.println(sb);
//
//    }


    public String getFeedBack(String guess) {
        String string = "";

        int numberCorrect = 0;
        int digitPosition = 0;
        for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == guess.charAt(i) && code.contains(String.valueOf(guess.charAt(i)))) {
                digitPosition++;
                numberCorrect++;
            } else if (code.contains(String.valueOf(guess.charAt(i)))) {
                numberCorrect++;
            }else if(code.charAt(i) == guess.charAt(i)) {
                digitPosition++;
            }
        }

        if(digitPosition > 0 || numberCorrect > 0) {
            string = String.format("You got %s number(s) correct and %s digit(s) in the right position", numberCorrect, digitPosition);
        }

        return string;
    }

    public void populateGuessMap(String guess, String feedback) {
        for(int i = 0; i < numberOfGuesses; i++) {
            list[0] = guess;
            list[1] = feedback;

        }
        numberOfGuesses++;
    }

    public void seeGameHistory() {
        System.out.println("HINT: " + list[0] + " " + list[1]);
    }

}
