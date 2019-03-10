package com.epam.tasktwo.parser.impl;

import com.epam.tasktwo.entity.Component;
import com.epam.tasktwo.entity.ComponentType;
import com.epam.tasktwo.entity.impl.Composite;
import com.epam.tasktwo.parser.DataParser;
import com.epam.tasktwo.polishrecord.ExpressionCalculator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * {@inheritDoc}
 *
 */
public class ExpressionParser implements DataParser {

  private final static Logger LOGGER = LogManager.getLogger(SentenceParser.class);

  private ExpressionCalculator calculator = ExpressionCalculator.getInstance();

  private NumberParser nextParser;


  private final static String EXPRESSION_SPLIT_REGEX = "(?<=((>>)|(<<)|(&)|(\\^)|(\\|)|\\(|\\)))|(?=((>){2}|(<){2}|(&)|(\\^)|(\\|)|\\(|\\)))";


  public ExpressionParser() {
    this.nextParser = new NumberParser();
  }

  @Override
  public boolean hasNextParser() {
    return nextParser != null;
  }

  @Override
  public Component handleParserRequest(String expression) {
    List<String> splitExpression = splitExpression(expression);
    Integer expressionResult = calculator.calculateExpression(splitExpression);

    LOGGER.info("Expression transferred to number.");
    return nextParser.handleParserRequest(String.valueOf(expressionResult));

  }


  public List<String> splitExpression(String expression) {

    List<String> splitExpression = new ArrayList<>();
    List<String> array = Arrays.asList(expression.split(EXPRESSION_SPLIT_REGEX));
    splitExpression.addAll(array);
    return splitExpression;
  }
}
