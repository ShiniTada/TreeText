package com.epam.tasktwo.reader.impl;

import com.epam.tasktwo.exception.ReadDataException;
import com.epam.tasktwo.reader.DataReader;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class DataReaderImplTest {

  private DataReader reader;


  @BeforeTest
  public void init(){
    reader = DataReaderImpl.getInstance();
  }


  @Test(description = "read data from file")
  public void testReadDataTxtSuccessfully() throws ReadDataException {
    //given
    String expected = "    It has survived - not only (five) centuries, but also the leap into, the electronic " +
                               "Ipsum passages. And more recently with desktop publishing software like Aldus " +
                               "PageMaker including versions of Lorem Ipsum. " +
                               "    It is a (8^5|1&2<<(2|5>>2&71))|1200 established fact that a reader will be of a " +
                               "page when looking at its layout.";
    //when
    String actual = reader.readData("data\\TestText.txt");
    //then
    Assert.assertEquals(actual, expected);
  }


  @Test(description = "file is not exist or empty", expectedExceptions = ReadDataException.class)
  public void testFileExistence() throws ReadDataException {
    String actual = reader.readData("data\\another.txt");
  }

}