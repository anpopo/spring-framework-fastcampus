package fc.anpopo.springcustomframework.calculator.arithmetic;

import fc.anpopo.springcustomframework.calculator.NewArithmeticOperator;

public class AddOperator implements NewArithmeticOperator {


    @Override
    public boolean supports(String operator) {
        return "+".equals(operator);
    }

    @Override
    public int calculate(int operand1, int operand2) {
        return operand1 + operand2;
    }

}
