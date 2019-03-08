package com.epam.tasktwo.interpretion.impl;

import com.epam.tasktwo.interpretion.Context;
import com.epam.tasktwo.interpretion.MathExpression;

public class AndExpression implements MathExpression {

    @Override
    public void interpret(Context content) {
        content.pushValue(content.popValue() & content.popValue());
    }

}
