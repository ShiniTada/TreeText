package com.epam.tasktwo.polishrecord;


public enum Operator {

    OPEN_BRACKET("(", 1),
    CLOSE_BRAKCET(")", 1),
    DOUBLE_LEFT_SHIFT("<<", 2),
    DOUBLE_RIGHT_SHIFT(">>", 2),
    AND("&", 3),
    CAP("^", 4),
    OR("|", 5);

    private String value;
    private int priority;


    Operator(String value, int priority) {
        this.value = value;
        this.priority = priority;
    }


    public String getValue() {
        return value;
    }


    public int getPriority() {
        return priority;
    }
}
