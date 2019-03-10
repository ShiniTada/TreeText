package com.epam.tasktwo.parser.impl;

import com.epam.tasktwo.entity.Component;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class NumberParserTest {

  private final static String NUM = "42";

  @Test
  public void testHandleParserRequest() {
    //given
    NumberParser numberParser = new NumberParser();
    //when
    Component actual = numberParser.handleParserRequest(NUM);
    //then
    Assert.assertEquals(actual.collectComponents(), NUM);
  }
}