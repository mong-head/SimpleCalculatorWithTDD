package org.example.calculate;

/**
 * Value Object
 * 매번 함수에서 양수인지 체크 비효율적임
 */
public class PositiveNumber {
    private final int value;

    /* 생성자 */
    public PositiveNumber(int value){
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if(isNegativeNumber(value)){
            throw new IllegalArgumentException("0또는 음수를 전달할 수 없습니다.");
        }
    }
    private boolean isNegativeNumber(int value) {
        return value <= 0;
    }

    public int toInt(){
        return this.value;
    }
}
