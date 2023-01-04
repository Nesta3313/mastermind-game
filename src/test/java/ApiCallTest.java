import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ApiCallTest {

    private String code;

    @Test
    @DisplayName("Given that api call generates a code, then code should be of size four and range from 0 and 7 inclusive")
    void codeShouldBeSizeFourAndRangeZeroToSevenInclusive() {

        code = ApiCall.generateApiCode(4, 7);
        // inline values to clean up code
        int expectedSize = 4;
        int expectedMin = 0;
        int expectedMax = 7;

        assertThat(expectedSize).isEqualTo(code.length());

        for(char c : code.toCharArray()) {
            assertThat(Character.getNumericValue(c) >= expectedMin &&  Character.getNumericValue(c) <= expectedMax).isTrue();
        }
    }

    @Test
    @DisplayName("Non api code returns 4 digits and a max of 7 as upper bound")
    void nonApiCodeShouldBeSizeFourAndRangeZeroToSevenInclusive() {
        code = ApiCall.generateNonApiCode(4, 7);

        int expectedSize = 4;
        int expectedMin = 0;
        int expectedMax = 7;

        assertThat(expectedSize).isEqualTo(code.length());

        for(char c : code.toCharArray()) {
            assertThat(Character.getNumericValue(c) >= expectedMin &&  Character.getNumericValue(c) <= expectedMax).isTrue();
        }
    }
}