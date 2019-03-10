package com.epam.tasktwo.parser.impl;

import com.epam.tasktwo.entity.Component;
import com.epam.tasktwo.polishrecord.ExpressionCalculator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;


public class ExpressionParserTest {

  private final static String ExpressionOne ="5|(1&2&(3|(4&(2^5|6&47)|3)|2)|1)";

  private final static String ExpressionTwo = "71&(2&3|(1>>10&2))|78";


  @Test
  public void testHandleParserRequest() {
    //given
    ExpressionParser expressionParser = new ExpressionParser();
    //when
    Component actual = expressionParser.handleParserRequest(ExpressionOne);
    //then
    Assert.assertEquals(actual.collectComponents(), "5");
  }

  @Test
  public void testSplitExpression() {
    //given
    List<String> expected = new ArrayList<>();
    Arrays.asList("71", "&", "(", "2", "&", "3", "|", "(", "1", ">>", "10", "&", "2", ")", ")", "|", "78");

    ExpressionParser exceptionParser = new ExpressionParser();
    //when
    List<String> actual = exceptionParser.splitExpression(ExpressionTwo);
    //then
    Assert.assertEquals(actual, expected);
  }
}