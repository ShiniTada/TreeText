package com.epam.tasktwo.parser.impl;

import com.epam.tasktwo.entity.Component;
import com.epam.tasktwo.entity.ComponentType;
import com.epam.tasktwo.entity.impl.Composite;
import com.epam.tasktwo.parser.DataParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class SentenceParser implements DataParser {

  private final static Logger LOGGER = LogManager.getLogger(SentenceParser.class);

  private final static String SPLIT_REGEX = "\\s";

  private LexemeParser nextParser;


  public SentenceParser() {
    this.nextParser = new LexemeParser();
    LOGGER.info("Took the next parser - LexemeParser.");
  }


  @Override
  public boolean hasNextParser() {
    return nextParser != null;
  }


  @Override
  public Composite handleParserRequest(String string) {
    List<String> lexemesInStrings = Arrays.asList(string.split(SPLIT_REGEX));
    Composite sentenceComposite = new Composite(ComponentType.SENTENCE);

    for (String lexeme: lexemesInStrings) {
      Component lexemeComposite = nextParser.handleParserRequest(lexeme);
      sentenceComposite.add(lexemeComposite);
    }
    LOGGER.info("Add lexemes in sentence.");
    return sentenceComposite;
  }

}

