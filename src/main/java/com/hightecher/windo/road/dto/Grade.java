package com.hightecher.windo.road.dto;

//A빼고 priority
public enum Grade {
    S(5),
    A(4),
    B(3),
    C(2),
    D(1),
    E(0);

    private final int priority;

    Grade(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
