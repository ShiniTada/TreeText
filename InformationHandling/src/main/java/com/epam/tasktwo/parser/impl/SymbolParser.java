package com.epam.tasktwo.parser.impl;

import com.epam.tasktwo.entity.Component;
import com.epam.tasktwo.entity.impl.Symbol;
import com.epam.tasktwo.parser.DataParser;


public class SymbolParser implements DataParser {

  @Override
  public boolean hasNextParser() {
    return false;
  }


  public  Component handleParserRequest(String string){
    Component symbol = new Symbol(string.charAt(0));
    return symbol;
  }

}
