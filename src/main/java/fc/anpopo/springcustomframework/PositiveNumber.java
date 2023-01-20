package fc.anpopo.springcustomframework;

public class PositiveNumber {

    private final int value;

    public PositiveNumber(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("음수는 불가능합니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
