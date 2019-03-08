package com.epam.tasktwo.interpretion.impl;

import com.epam.tasktwo.interpretion.Context;
import com.epam.tasktwo.interpretion.MathExpression;

public class DoubleLeftShiftExpression implements MathExpression {

    @Override
    public void interpret(Context content) {
        content.pushValue(content.popValue() << content.popValue());
    }

}
