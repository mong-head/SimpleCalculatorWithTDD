package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

/**
 * 요구사항
 * * 간단한 사칙연산 가능하다
 * * 양수로만 계산가능하다
 * * 나눗셈에서 0을 나누는 경우 IllegalArgument 예외로 발생시킨다.
 * * MVC 패턴 기반으로 구현한다.
 */
public class CalculatorTest {

    @DisplayName("연산 수행")
    @ParameterizedTest
    @MethodSource("formulateAndResult")
    void calculateTest(int operand1, String operator, int operand2, int result){
        int calculateResult = Calculator.calculate(operand1,operator,operand2);
        assertThat(result).isEqualTo(calculateResult);
    }

    private static Stream<Arguments> formulateAndResult(){
        return Stream.of(
                Arguments.arguments(1, "+", 2, 3),
                Arguments.arguments(3, "*", 2, 6),
                Arguments.arguments(1, "-", 2, -1),
                Arguments.arguments(4, "/", 2, 2)
        );
    }

    @DisplayName("나눗셈에서 0을 나누는 경우 IllegalArgument 예외로 발생시킨다.")
    @Test
    void calculateExceptionTest(){
        assertThatCode(() -> Calculator.calculate(10,"/",0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
