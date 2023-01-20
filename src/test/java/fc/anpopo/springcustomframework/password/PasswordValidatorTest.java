package fc.anpopo.springcustomframework.password;

import fc.anpopo.springcustomframework.password.PasswordValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PasswordValidatorTest {

    @DisplayName("비밀번호 최소 8자 이상, 12자 이하면 예외 발생하지 않는다.")
    @Test
    void validatePasswordTest() {
        Assertions.assertThatCode(() -> PasswordValidator.validate("architectanpopo"))
            .doesNotThrowAnyException();
    }

    @DisplayName("비밀번호가 8자 미만, 12자 초과의 경우 IllegalArgumentException 이 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1234567", "1234567890123"})
    void validatePasswordTestWithException(String password) {
        Assertions.assertThatCode(() -> PasswordValidator.validate(password))
            .isExactlyInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("비밀번호가 유효하지 않습니다.");
    }
}
