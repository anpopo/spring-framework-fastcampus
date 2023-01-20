package fc.anpopo.springcustomframework.password;

public class PasswordValidator {


    public static void validate(String password) {
        int length = password.length();

        if (length < 8 || length > 12) {
            throw new IllegalArgumentException("비밀번호가 유효하지 않습니다.");
        }
    }
}
