package com.epam.tasktwo.action;

import com.epam.tasktwo.entity.Component;
import com.epam.tasktwo.entity.ComponentType;
import com.epam.tasktwo.entity.impl.Composite;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class SortWords {


    public Composite inEachSentenceSortWordsByLength(Composite realText) {
        Composite text = new Composite(realText);
        List<Component> paragraphs = text.getAllChildren();
        for (Component paragraph : paragraphs) {
            for (Component sentence : paragraph.getAllChildren()) {
                sortWordsInSentence(sentence);
            }
        }
        return text;
    }


    public void sortWordsInSentence(Component sentence) {
        List<Component> words = new ArrayList<>();
        for (Component lexeme : sentence.getAllChildren()) {
            for (Component lexElement : lexeme.getAllChildren()) {
                if (lexElement.getComponentType() == ComponentType.WORD) {
                    words.add(lexElement);
                }
            }
        }
        words.sort(Comparator.comparingInt(s -> s.getAllChildren().size()));
        pasteSortedSentence(sentence, words);
    }


    private void pasteSortedSentence(Component sentence, List<Component> sortedSentence) {
        for (Component lexeme : sentence.getAllChildren()) {
            List<Component> lexemeElements = lexeme.getAllChildren();
            for (int position = 0; position < lexemeElements.size(); position++) {
                if (lexemeElements.get(position).getComponentType() == ComponentType.WORD) {
                    lexemeElements.set(position, sortedSentence.get(0));
                    sortedSentence.remove(0);
                }
            }
        }
    }

}