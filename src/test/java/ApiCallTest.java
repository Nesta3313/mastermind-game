import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ApiCallTest {

    private String code;

    @BeforeEach
    void setup() {
        code = ApiCall.generateCode(4, 7);
    }

    @DisplayName("Given that api call generates a code, then code should be of size four and range from 0 and 7 inclusive")
    @Test
    void codeShouldBeSizeFourAndRangeZeroToSevenInclusive() {
        // inline values to clean up code
        int expectedSize = 4;
        int expectedMin = 0;
        int expectedMax = 7;

        assertThat(expectedSize).isEqualTo(code.length());

        for(char c : code.toCharArray()) {
            assertThat(Character.getNumericValue(c) >= expectedMin &&  Character.getNumericValue(c) <= expectedMax).isTrue();
        }
    }

    //TODO what if endpoint does not work??? if HttpStatusCode is not 200


}