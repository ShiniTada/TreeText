package com.epam.tasktwo.polishrecord;

import com.epam.tasktwo.parser.impl.ExpressionParser;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class ExpressionCalculatorTest {


    private ExpressionCalculator calculator;

    @DataProvider(name = "dataForExpressionCalculator")
    public static Object[][] initData() {
        return new Object[][]{
                // {"13<<28", 52},
                {"(8^5|1&2<<(2|5>>2&71))|1200", 1213},
                {"3>>5", 0},
                {"6&9|(3&4)", 0},
                {"5|(1&2&(3|(4&(2^5|6&47)|3)|2)|1)", 5},
                {"(71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78", 79}
        };
    }

    @BeforeClass
    public void setUp() {
        calculator = ExpressionCalculator.getInstance();
    }

    @Test(dataProvider = "dataForExpressionCalculator")
    public void testCalculateExpression(String expression, Integer expected) {
        //given
        ExpressionParser expressionParser = new ExpressionParser();
        List<String> splitExpression = expressionParser.splitExpression(expression);
        //when
        Integer actual = calculator.calculateExpression(splitExpression);
        Assert.assertEquals(actual, expected);
    }

}