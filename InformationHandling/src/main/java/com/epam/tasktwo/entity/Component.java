package com.epam.tasktwo.entity;

import java.util.List;

public interface Component {

  public void add(Component textComponent);


  public void remove(Component textComponent);


  public List<Component> getAllChildren();

  String collectComponents();

  ComponentType getComponentType();


}
