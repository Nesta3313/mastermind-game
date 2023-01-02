import java.util.*;

public class Play {
    private String code;
    private Map<String, String> guessMap;
    private long startTime;
    private long endTime;

    public Play(String code) {
        this.code = code;
        this.guessMap = new HashMap<>();
        this.startTime = System.currentTimeMillis();
        this.endTime = 0;
    }

    public String getFeedBack(String guess) {
        String string = "";

        int correctNumber = 0;
        int correctPosition = 0;
        for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == guess.charAt(i)) {
                correctPosition++;
            } else if (code.contains(String.valueOf(guess.charAt(i)))) {
                correctNumber++;
                code.replace(guess.charAt(i), '#');
            }
        }

        if(correctPosition > 0 || correctNumber > 0) {
            string = String.format("You got %d number(s) correct and %d digit(s) in the right position", correctNumber, correctPosition);
        }
        return string;
    }

    public void populateGuessMap(String guess, String feedback) {
        this.guessMap.put(guess, feedback);
    }

    public void seeGameHistory() {
        for (Map.Entry<String, String> entry : this.guessMap.entrySet()) {
            System.out.println("HINT: " + entry.getKey() + " " + entry.getValue());
        }
    }


    public void displayTimeTaken() {
        endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        //convert time to sec or not
        System.out.println("Time taken: " + timeTaken + " milliseconds");
    }
}

