package com.epam.tasktwo.parser.impl;

import com.epam.tasktwo.entity.Component;
import com.epam.tasktwo.entity.ComponentType;
import com.epam.tasktwo.entity.impl.Composite;
import com.epam.tasktwo.parser.DataParser;


public class NumberParser implements DataParser {

    private SymbolParser nextParser;


    public NumberParser() {
        nextParser = new SymbolParser();
    }


    @Override
    public boolean hasNextParser() {
        return nextParser != null;
    }


    @Override
    public Composite handleParserRequest(String number) {
        Composite numberComposite = new Composite(ComponentType.NUMBER);

        char[] digits = number.toCharArray();
        for (char digit : digits) {
            Component numberComponent = nextParser.handleParserRequest(String.valueOf(digit));
            numberComposite.add(numberComponent);
        }
        return numberComposite;
    }

}
