package com.epam.tasktwo.parser.impl;

import com.epam.tasktwo.entity.Component;
import com.epam.tasktwo.entity.ComponentType;
import com.epam.tasktwo.entity.impl.Composite;
import com.epam.tasktwo.parser.DataParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;


public class TextParser implements DataParser {

  private final static Logger LOGGER = LogManager.getLogger(TextParser.class);

  private final static String SPLIT_REGEX = "\\s{4}\\s*";

  private ParagraphParser nextParser;

  public TextParser() {
    this.nextParser = new ParagraphParser();
    LOGGER.info("Took the next parser - ParagraphParser.");
  }


  @Override
  public boolean hasNextParser(){
    return nextParser != null;
  }


  @Override
  public Composite handleParserRequest(String string) {
    List<String> paragraphsInStrings = Arrays.asList(string.split(SPLIT_REGEX));
    Composite textComposite = new Composite(ComponentType.TEXT);
    for (String paragraph : paragraphsInStrings) {
        Component paragraphComposite = nextParser.handleParserRequest(paragraph.trim());
        textComposite.add(paragraphComposite);
        LOGGER.info("Add paragraph in text.");
      }
      return textComposite;
    }
}

