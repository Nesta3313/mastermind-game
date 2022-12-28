import java.util.HashMap;
import java.util.Map;

public class Play {

    private String code;
    private int numberOfGuesses;

    private  Map<String, String> map;

    public Play(String code) {
        this.code = code;
        numberOfGuesses = 1;
        map = new HashMap<>();
    }

//    public static void main(String[] args) {
//        Play play = new Play("3425");
//        String feedBack = play.getFeedBack("4217");
//        play.populateGuessMap("4217", feedBack);
//        play.seeGameHistory();
//    }


    public String getFeedBack(String guess) {
        StringBuilder builder = new StringBuilder();

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
            builder.append(String.format("You got %s numbers correct and %s digits in the right position", numberCorrect, digitPosition));
        }

        return builder.toString();
    }

    public void populateGuessMap(String guess, String feedback) {
        for(int i = 0; i < numberOfGuesses; i++) {
            map.put(guess, feedback);
        }
        numberOfGuesses++;
    }

    public void seeGameHistory() {
        for(String key: map.keySet()) {
            System.out.println("HINT: " + key + " " + map.values());
        }
    }

}
