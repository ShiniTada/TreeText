package com.epam.tasktwo.action;

import com.epam.tasktwo.entity.Component;
import com.epam.tasktwo.entity.impl.Composite;
import com.epam.tasktwo.parser.impl.TextParser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortWordsTest {

    public final static String TEXT = "    It has survived. I hope so.    It will be good.";
    public final static String RIGHT_TEXT = "It has survived. I so hope. It be will good.";


    @Test
    public void testInEachSentenceSortWordsByLength() {
        //given
        SortWords sortWords = new SortWords();
        TextParser dataParser = new TextParser();

        Composite text = dataParser.handleParserRequest(TEXT.trim());
        //when
        Component actual = sortWords.inEachSentenceSortWordsByLength(text);
        //them
        Assert.assertEquals(actual.collectComponents(), RIGHT_TEXT);
    }
}