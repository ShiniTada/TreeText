package com.epam.tasktwo.interpretion.impl;

import com.epam.tasktwo.interpretion.InterpreterContext;
import com.epam.tasktwo.interpretion.MathExpression;

public class OrExpression implements MathExpression {

  @Override
  public void interpret(InterpreterContext content) {
    content.pushValue(content.popValue() | content.popValue());
  }
}
