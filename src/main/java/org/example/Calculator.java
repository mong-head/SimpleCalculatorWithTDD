package org.example;

import org.example.calculate.*;

import java.util.List;

public class Calculator {

    // #1 : 위임 X 내부에서 모든 로직 실행
//    public static int calculate(int operand1, String operator, int operand2) {
//        switch (operator){
//            case "+":
//                return operand1 + operand2;
//            case "-":
//                return operand1 - operand2;
//            case "*":
//                return operand1 * operand2;
//            case "/":
//                if(operand2 == 0) throw new IllegalArgumentException();
//                return operand1 / operand2;
//        }
//        return operand1;
//    }

    // #2 : 위임O enum 에서 로직 실행
//    public static int calculate(int operand1, String operator, int operand2) {
//        return ArithmeticOperator.calculate(operand1,operator,operand2);
//    }

    // #3 : 위임O interface 구현
    private static final List<NewArithmeticOperator> arithmeticOperatorList = List.of(new AdditionOperator(), new SubtractionOperator(), new MultiplicationOperator(), new DivisionOperator());
    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2) {
        return arithmeticOperatorList.stream()
                .filter(newArithmeticOperator -> newArithmeticOperator.supports(operator))
                .map(arithmeticOperator -> arithmeticOperator.calculate(operand1, operand2))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
    }
}
