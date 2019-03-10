package com.epam.tasktwo.parser.impl;

import com.epam.tasktwo.entity.Component;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ParagraphParserTest {

  public final static String PARAFRAPH  = "    It has survived - not only (five) centuries, but also the leap " +
          "into the electronic typesetting, remaining 3>>5 essentially 6&9|(3&4) unchanged. It was popularised in the " +
          "5|(1&2&(3|(4&(2^5|6&47)|3)|2)|1) with the release of Letraset sheets containing Lorem " +
          "Ipsum passages, and more recently with desktop publishing software like Aldus " +
          "PageMaker including versions of Lorem Ipsum.";

  public final static String RIGHT_PARAFRAPH =  "It has survived - not only (five) centuries, but also the leap " +
          "into the electronic typesetting, remaining 0 essentially 0 unchanged. It was popularised in the " +
          "5 with the release of Letraset sheets containing Lorem " +
          "Ipsum passages, and more recently with desktop publishing software like Aldus " +
          "PageMaker including versions of Lorem Ipsum.";


  @Test
  public void testHandleParserRequest() {
    //given
    ParagraphParser paragraphParser = new ParagraphParser();
    //when
    Component actual = paragraphParser.handleParserRequest(PARAFRAPH.trim());
    //then
    Assert.assertEquals(actual.collectComponents(), RIGHT_PARAFRAPH);
  }
}