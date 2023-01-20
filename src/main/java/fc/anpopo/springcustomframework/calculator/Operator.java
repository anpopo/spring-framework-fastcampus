package fc.anpopo.springcustomframework.calculator;

import java.util.Arrays;

public enum Operator {
    ADD("+") {
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 + operand2;
        }
    },
    SUB("-") {
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 - operand2;
        }
    },
    MULTIPLE("*") {
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 * operand2;
        }
    },
    DIVIDE("/") {
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 / operand2;
        }
    },
    ;

    private final String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    public abstract int arithmeticCalculate(int operand1, int operand2);

    public static int calculate(int operand1, String operator, int operand2) {
        return Arrays.stream(values())
            .filter(v -> v.operator.equals(operator))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("올바른 사칙 연산이 아닙니다."))
            .arithmeticCalculate(operand1, operand2);
    }

}
