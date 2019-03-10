package com.epam.tasktwo.action;

import com.epam.tasktwo.entity.impl.Composite;
import com.epam.tasktwo.parser.impl.TextParser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortLexemesTest {

  public final static String TEXT = "titlet tot it here.";

  public final static String RIGHT_TEXT = "here it tot titlet.";

  @Test
  public void testSortLexemesByDescendingAmountOfSomeCharacter() {
    //given
    SortLexemes sortLexemes = new SortLexemes();
    TextParser dataParser = new TextParser();

    Composite text = dataParser.handleParserRequest(TEXT);
    //when
    Composite actual = sortLexemes.sortLexemesByDescendingAmountOfSomeCharacter(text, 't');
    //then
    Assert.assertEquals(actual.collectComponents(), RIGHT_TEXT);
  }
}