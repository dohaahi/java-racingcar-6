package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.Constants;

class InputValidatorTest {
    @DisplayName("자동차 이름을 ','로 구분되지 않게 입력 하면 예외 발생")
    @Test
    void testValidateNotInputComma() {
        // given
        String input = "carA. carB carC";

        // when
        // then
        assertThatThrownBy(() -> InputValidator.validateNotInputComma(input)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(Constants.WRONG_INPUT_COMMA_MESSAGE);
    }


    @DisplayName("자동차 이름에 문자가 아닌 다른 것을 입력하면 예외 발생")
    @Test
    void testValidateInputCarNameCharacter() {
        // given
        String input = "car1, car2, car3";

        // when
        // then
        assertThatThrownBy(() -> InputValidator.validateInputCarNameCharacter(input)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(Constants.WRONG_INPUT_CAR_NAME_CHARACTER_MASSAGE);
    }

    @DisplayName("자동차 이름이 5자 이상이면 예외 발생")
    @Test
    void testValidateInputCarNameLength() {
        // given
        String input = "carName";

        // when
        // then
        assertThatThrownBy(() -> InputValidator.validateInputCarNameLength(input)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(Constants.WRONG_INPUT_CAR_NAME_LENGTH_MESSAGE);

    }

    @DisplayName("자동차 이름이 중복으로 입력되면 예외 발생")
    @Test
    void testValidateDuplicationCarNames() {
        // given
        String input = "carA, carA, carB";

        // when
        // then
        assertThatThrownBy(() -> InputValidator.validateDuplicationCarNames(input)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(Constants.WRONG_INPUT_CAR_NAME_DUPLICATION_MESSAGE);
    }

    @DisplayName("시도 횟수를 숫자가 아닌 타입으로 입력하면 오류 발생")
    @Test
    void testValidateInputTryCountCharacter() {
        // given
        String input = "abc";

        // when
        // then
        assertThatThrownBy(() -> InputValidator.validateInputTryCountCharacter(input)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(Constants.WRONG_INPUT_TRY_COUNT_CHARACTER_MESSAGE);
    }

    @DisplayName("시도 횟수를 0으로 입력하면 오류 발생")
    @Test
    void testValidateInputTryCountZero() {
        // given
        String input = "0";

        // when
        // then
        assertThatThrownBy(() -> InputValidator.validateInputTryCountZero(input)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(Constants.WRONG_INPUT_TRY_COUNT_ZERO_MESSAGE);
    }
}