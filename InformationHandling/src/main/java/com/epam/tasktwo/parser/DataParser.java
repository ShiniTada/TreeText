package com.epam.tasktwo.parser;

import com.epam.tasktwo.entity.Component;


public interface DataParser {

    boolean hasNextParser();

    Component handleParserRequest(String string);


}
