package com.epam.tasktwo.interpretion.impl;

import com.epam.tasktwo.interpretion.Context;
import com.epam.tasktwo.interpretion.MathExpression;

public class NumberExpression implements MathExpression {

    private int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public void interpret(Context context) {
        context.pushValue(number);
    }

}