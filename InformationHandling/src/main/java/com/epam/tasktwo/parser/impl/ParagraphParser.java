package com.epam.tasktwo.parser.impl;

import com.epam.tasktwo.entity.Component;
import com.epam.tasktwo.entity.ComponentType;
import com.epam.tasktwo.entity.impl.Composite;
import com.epam.tasktwo.parser.DataParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;


public class ParagraphParser implements DataParser {

  private final static Logger LOGGER = LogManager.getLogger(ParagraphParser.class);

  private final static String SPLIT_REGEX = "(\\.\\.\\.)|\\.|\\?|\\!\\s*";

  private SentenceParser nextParser;


  public ParagraphParser() {
    this.nextParser = new SentenceParser();
    LOGGER.info("Took the next parser - SentenceParser.");
  }


  @Override
  public boolean hasNextParser() {
    return nextParser != null;
  }


  @Override
  public Composite handleParserRequest(String string) {
    List<String> sentencesInStrings = Arrays.asList(string.split(SPLIT_REGEX));
    Composite paragraphComposite = new Composite(ComponentType.PARAGRAPH);

    for (String sentence : sentencesInStrings) {
      Component sentenceComposite = nextParser.handleParserRequest(sentence);
      Component dot = nextParser.handleParserRequest(".");
      paragraphComposite.add(sentenceComposite);
      paragraphComposite.add(dot);
      LOGGER.info("Add sentence in paragraph.");
    }
    return paragraphComposite;

  }

}
