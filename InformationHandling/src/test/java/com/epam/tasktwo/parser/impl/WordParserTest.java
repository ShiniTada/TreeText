package com.epam.tasktwo.parser.impl;

import com.epam.tasktwo.entity.Component;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WordParserTest {

    private final static String WORD = "oki";

    @Test
    public void testHandleParserRequest() {
        //given
        WordParser wordParser = new WordParser();
        //when
        Component actual = wordParser.handleParserRequest(WORD);
        //then
        Assert.assertEquals(actual.collectComponents(), WORD);
    }
}