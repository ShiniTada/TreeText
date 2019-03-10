package com.epam.tasktwo.action;

import com.epam.tasktwo.entity.impl.Composite;
import com.epam.tasktwo.parser.impl.TextParser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortParagraphsTest {


    public final static String TEXT = "    It has survived - not only 5 centuries. But also Lorem Ipsum." +
          "    It is a established fact that a reader will be of a " +
          "page when looking at its layout.    ";


  public final static String RIGHT_TEXT =
          "It is a established fact that a reader will be of a " +
                  "page when looking at its layout." +
                  " It has survived - not only 5 centuries. But also Lorem Ipsum.";


  @Test
  public void testSortParagraphsByAmountOfSentences() {
    //given
    SortParagraphs sortParagraphs = new SortParagraphs();
    TextParser dataParser = new TextParser();

    Composite text = dataParser.handleParserRequest(TEXT.trim());
    //when
    Composite actual = sortParagraphs.sortParagraphsByAmountOfSentences(text);
    //then
    Assert.assertEquals(actual.collectComponents(), RIGHT_TEXT);
  }

}