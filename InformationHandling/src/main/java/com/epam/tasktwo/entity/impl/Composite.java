package com.epam.tasktwo.entity.impl;

import com.epam.tasktwo.entity.Component;
import com.epam.tasktwo.entity.ComponentType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Composite implements Component {

  private ComponentType TYPE;
  private List<Component> textComponents = new ArrayList<>();

  public Composite(ComponentType TYPE) {
    this.TYPE = TYPE;
  }

  public Composite(Composite composite) {
    if (composite != null) {
      this.TYPE = composite.getComponentType();
      textComponents = new ArrayList<>(composite.getAllChildren());
    }//Runtime exception
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
    String result = " ";
    switch (TYPE) {
      case WORD:
      case NUMBER:
      case EXPRESSION:
      case LEXEMA:
        result = textComponents.stream()
                .map(Component::collectComponents)
                .collect(Collectors.joining());
        break;
      case SENTENCE:
        result = textComponents.stream()
                .map(Component::collectComponents)
                .collect(Collectors.joining(" "));
        break;
      case PARAGRAPH:
        result = textComponents.stream()
                .map(Component::collectComponents)
                .collect(Collectors.joining(""));
        break;
      case TEXT:
        result = textComponents.stream()
                .map(Component::collectComponents)
                .collect(Collectors.joining(" "));

        break;
    }
    return result;
  }

  @Override
  public ComponentType getComponentType() {
    return TYPE;
  }

  @Override
  public String toString() {
    return "Composite{" +
            "TYPE=" + TYPE +
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
    Composite composite = (Composite) o;
    return TYPE == composite.TYPE &&
            Objects.equals(textComponents, composite.textComponents);
  }

  @Override
  public int hashCode() {
    return Objects.hash(TYPE, textComponents);
  }
}
