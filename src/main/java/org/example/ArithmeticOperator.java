package org.example;

import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public enum ArithmeticOperator {
    ADDITION("+"){
        @Override
        public int arithmeticCalculate(int operand1, int operand2){
            return operand1 + operand2;
        }
    },
    SUBTRACTION("-"){
        @Override
        public int arithmeticCalculate(int operand1, int operand2){
            return operand1 - operand2;
        }
    },
    MULTIPLICATION("*"){
        @Override
        public int arithmeticCalculate(int operand1, int operand2){
            return operand1 * operand2;
        }
    },
    DIVISION("/"){
        @Override
        public int arithmeticCalculate(int operand1, int operand2){
            if(operand2 == 0) throw new IllegalArgumentException();
            return operand1 / operand2;
        }
    }
    ;

    private final String operator;
    protected abstract int arithmeticCalculate(final int operand1, final int operand2);
    public static int calculate(int operand1, String operator, int operand2){
        return Arrays.stream(ArithmeticOperator.values())
                .filter(arithmeticOperator -> arithmeticOperator.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."))
                .arithmeticCalculate(operand1,operand2);
    }
}
