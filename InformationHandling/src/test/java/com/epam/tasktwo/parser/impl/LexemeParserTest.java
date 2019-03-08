package com.epam.tasktwo.parser.impl;

import com.epam.tasktwo.entity.Component;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LexemeParserTest {

    private LexemeParser lexemeParser;


    @BeforeTest
    public void setUp() {
        lexemeParser = new LexemeParser();
    }


    @DataProvider(name = "dataForParser")
    public Object[][] initData() {
        return new Object[][]{
                {"o"},
                {"oki"},
                {"(here"},
                {"we)"},
                {"tetrahedron,"},
                {"(happy)"},
                {"ho-ho-ho-hoh"}
        };
    }


    @Test(dataProvider = "dataForParser")
    public void testHandleParserRequestAllVariants(String lexeme) {
        //when
        Component actual = lexemeParser.handleParserRequest(lexeme);
        //then
        Assert.assertEquals(actual.collectComponents(), lexeme);
    }
}