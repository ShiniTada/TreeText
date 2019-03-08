package com.epam.tasktwo.action;

import com.epam.tasktwo.entity.Component;
import com.epam.tasktwo.entity.impl.Composite;

import java.util.Comparator;
import java.util.List;


public class SortParagraphs {

    public Composite sortParagraphsByAmountOfSentences(Composite realText) {
        Composite text = new Composite(realText);
        List<Component> paragraphs = text.getAllChildren();
        paragraphs.sort(Comparator.comparing(par -> par.getAllChildren().size()));
        return text;
    }

}
