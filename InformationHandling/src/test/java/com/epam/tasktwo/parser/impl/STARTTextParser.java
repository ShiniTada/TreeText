package com.epam.tasktwo.parser.impl;

import com.epam.tasktwo.entity.Component;
import com.epam.tasktwo.exception.ReadDataException;
import com.epam.tasktwo.reader.DataReader;
import com.epam.tasktwo.reader.impl.DataReaderImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

public class STARTTextParser {

    public final static String RIGHT_TEXT = "It has survived - not only (five) centuries, but also the leap into " +
            "the electronic typesetting, remaining 0 essentially 0 unchanged. It was popularised " +
            "in the 5 with the release of Letraset sheets containing Lorem " +
            "Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including " +
            "versions of Lorem Ipsum." +
            " It is a long established fact that a reader will be distracted by the readable content of " +
            "a page when looking at its layout. The point of using 79 " +
            "Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using " +
            "(Content here), content here, making it look like readable English." +
            " It is a 1213 established fact that a reader will be of a " +
            "page when looking at its layout." +
            " Bye.";


    @Test
    public void testHandleParserRequest() throws ReadDataException {
        //given
        DataReader reader = DataReaderImpl.getInstance();
        String textFromFile = reader.readData("data\\Text.txt");
        TextParser textParser = new TextParser();
        //when
        Component actual = textParser.handleParserRequest(textFromFile.trim());
        //then
        Assert.assertEquals(actual.collectComponents(), RIGHT_TEXT);
    }

}