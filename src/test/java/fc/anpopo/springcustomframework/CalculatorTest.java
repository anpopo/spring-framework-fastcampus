package fc.anpopo.springcustomframework;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CalculatorTest {

    @DisplayName("덧셈 연산 수행")
    @Test
    void additionTest() {
        int result = Calculator.calculateV1(1, "+", 2);
        Assertions.assertThat(result).isEqualTo(3);
    }

    @DisplayName("뺄셈 연산 수행")
    @Test
    void subtractionTest() {
        int result = Calculator.calculateV1(1, "-", 2);
        Assertions.assertThat(result).isEqualTo(-1);
    }


    @DisplayName("사칙 연산을 수행한다.v1")
    @ParameterizedTest
    @MethodSource("formula")
    void totalCalculateTestV1(int operand1, String operator, int operand2, int result) {
        int calculateResult = Calculator.calculateV1(operand1, operator, operand2);
        Assertions.assertThat(calculateResult).isEqualTo(result);
    }

    @DisplayName("사칙 연산을 수행한다.v2")
    @ParameterizedTest
    @MethodSource("formula")
    void totalCalculateTestV2(int operand1, String operator, int operand2, int result) {
        int calculateResult = Calculator.calculateV2(operand1, operator, operand2);
        Assertions.assertThat(calculateResult).isEqualTo(result);
    }

    @DisplayName("사칙 연산을 수행한다.v3")
    @ParameterizedTest
    @MethodSource("formula")
    void totalCalculateTestV3(int operand1, String operator, int operand2, int result) {
        int calculateResult = Calculator.calculateV3(operand1, operator, operand2);
        Assertions.assertThat(calculateResult).isEqualTo(result);
    }

    private static Stream<Arguments> formula() {
        return Stream.of(
            Arguments.arguments(1, "+", 2, 3),
            Arguments.arguments(1, "-", 2, -1),
            Arguments.arguments(4, "*", 2, 8),
            Arguments.arguments(4, "/", 2, 2)
        );
    }


    @DisplayName("0으로 나누는 경우 IllegalArgumentException 을 발생한다.")
    @Test
    void divideWith0AndException() {
        Assertions.assertThatThrownBy(() -> Calculator.calculateV3(100, "/", 0))
            .isExactlyInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("0으로 나눌 수 없습니다.");
    }

    @DisplayName("양수만 사칙 연산이 가능하다.")
    @ParameterizedTest
    @MethodSource("positiveNumber")
    void calculateWithOOP(int operand1, String operator, int operand2) {
        Assertions.assertThatThrownBy(
                () -> Calculator.calculateV4(new PositiveNumber(operand1), operator, new PositiveNumber(operand2)))
            .isExactlyInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("음수는 불가능합니다.");

    }

    private static Stream<Arguments> positiveNumber() {
        return Stream.of(
                Arguments.arguments(-1, "+", -1),
                Arguments.arguments(1, "-", -1),
                Arguments.arguments(-1, "*", 2),
                Arguments.arguments(4, "/", -1)
        );
    }

}
