package com.epam.tasktwo.entity.impl;

import com.epam.tasktwo.entity.Component;
import com.epam.tasktwo.entity.ComponentType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Symbol implements Component {

  private final static ComponentType TYPE = ComponentType.SYMBOL;
  private char littleSymbol;

  private List<Component> textComponents = new ArrayList<>();


  public Symbol(char littleSymbol) {
    this.littleSymbol = littleSymbol;
  }


  @Override
  public void add(Component textComponent) {
    textComponents.add(textComponent);
  }


  @Override
  public void remove(Component textComponent) {
    textComponents.remove(textComponent);
  }


  @Override
  public List<Component> getAllChildren() {
    return textComponents;
  }

  @Override
  public String collectComponents() {
    return String.valueOf(littleSymbol);
  }

  @Override
  public ComponentType getComponentType() {
    return TYPE;
  }

  @Override
  public String toString() {
    return "Symbol{" +
            "littleSymbol=" + littleSymbol +
            ", textComponents=" + textComponents +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Symbol symbol = (Symbol) o;
    return littleSymbol == symbol.littleSymbol &&
            Objects.equals(textComponents, symbol.textComponents);
  }

  @Override
  public int hashCode() {
    return Objects.hash(littleSymbol, textComponents);
  }
}
