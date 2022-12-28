import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayTest {

    String code;

    Play play;

    @BeforeEach
    void setup() {
        code = "2345";
        play = new Play(code);
    }

    @Test
    @DisplayName("all numbers are found and in right digits")
    void allNumbersAndDigitsFoundInRightPosition() {

        String guess = code;

        String expected = "You got 4 numbers correct and 4 digits in the right position";

        String actual = play.getFeedBack(guess);

        assertThat(expected).matches(actual);
    }

    @Test
    @DisplayName("one numbers is found and in right digit")
    void oneNumbersAndDigitFoundInRightPosition() {
        String guess = "6310";

        String expected = "You got 1 numbers correct and 1 digits in the right position";

        String actual = play.getFeedBack(guess);

        assertThat(expected).matches(actual);

    }

    @Test
    @DisplayName("all numbers found and zero digits in right position")
    void allNumbersFoundAndZeroDigitFoundInRightPosition() {
        String guess = "5432";

        String expected = "You got 4 numbers correct and 0 digits in the right position";

        String actual = play.getFeedBack(guess);

        assertThat(expected).matches(actual);
    }

    @Test
    @DisplayName("no numbers found and zero digits in right position")
    void noNumbersFoundAndZeroDigitFoundInRightPosition() {
        String guess = "6017";

        String actual = play.getFeedBack(guess);

        assertThat(actual).isEmpty();

    }

}