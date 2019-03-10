package com.epam.tasktwo.interpretion.impl;

import com.epam.tasktwo.interpretion.InterpreterContext;
import com.epam.tasktwo.interpretion.MathExpression;

public class NumberExpression implements MathExpression {

  private int number;

  public NumberExpression(int number) {
    this.number = number;
  }

  @Override
  public void interpret(InterpreterContext context) {
    context.pushValue(number);
  }

}