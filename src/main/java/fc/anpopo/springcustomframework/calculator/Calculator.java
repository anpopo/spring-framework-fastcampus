package fc.anpopo.springcustomframework.calculator;

import fc.anpopo.springcustomframework.calculator.arithmetic.AddOperator;
import fc.anpopo.springcustomframework.calculator.arithmetic.DivOperator;
import fc.anpopo.springcustomframework.calculator.arithmetic.MulOperator;
import fc.anpopo.springcustomframework.calculator.arithmetic.SubOperator;
import java.util.List;

public class Calculator {

    private static final List<NewArithmeticOperator> arithmeticCalculators
        = List.of(new AddOperator(), new SubOperator(), new MulOperator(), new DivOperator());

    public static int calculateV1(int operand1, String operator, int operand2) {

        if ("+".equals(operator)) {
            return operand1 + operand2;
        } else if ("-".equals(operator)) {
            return operand1 - operand2;
        } else if ("*".equals(operator)) {
            return operand1 * operand2;
        } else if ("/".equals(operator)) {
            return operand1 / operand2;
        }
        return operand1 + operand2;
    }

    public static int calculateV2(int operand1, String operator, int operand2) {
        return Operator.calculate(operand1, operator, operand2);
    }

    public static int calculateV3(int operand1, String operator, int operand2) {
        return arithmeticCalculators.stream()
            .filter(o -> o.supports(operator))
            .map(o -> o.calculate(operand1, operand2))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다"));
    }

    public static int calculateV4(PositiveNumber operand1, String operator, PositiveNumber operand2) {
        return arithmeticCalculators.stream()
            .filter(o -> o.supports(operator))
            .map(o -> o.calculate(operand1.getValue(), operand2.getValue()))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다"));
    }

}
