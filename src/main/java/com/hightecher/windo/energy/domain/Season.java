package com.hightecher.windo.energy.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum Season {

    SPRING("봄"),
    SUMMER("여름"),
    AUTUMN("가을"),
    WINTER("겨울");

    private final String korean;

    public static Season fromKorean(String korean) {
        return Arrays.stream(values())
                .filter(s -> s.korean.equals(korean))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 계절: " + korean));
    }
}
