package com.epam.tasktwo.parser.impl;

import com.epam.tasktwo.entity.Component;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class ExpressionParserTest {

    private final static String ExpressionOne = "5|(1&2&(3|(4&(2^5|6&47)|3)|2)|1)";

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
        expected.add("71");
        expected.add("&");
        expected.add("(");
        expected.add("2");
        expected.add("&");
        expected.add("3");
        expected.add("|");
        expected.add("(");
        expected.add("1");
        expected.add(">>");
        expected.add("10");
        expected.add("&");
        expected.add("2");
        expected.add(")");
        expected.add(")");
        expected.add("|");
        expected.add("78");

        ExpressionParser exceptionParser = new ExpressionParser();
        //when
        List<String> actual = exceptionParser.splitExpression(ExpressionTwo);
        //then
        Assert.assertEquals(actual, expected);
    }
}