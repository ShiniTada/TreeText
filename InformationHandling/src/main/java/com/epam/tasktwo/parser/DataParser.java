package com.epam.tasktwo.parser;

import com.epam.tasktwo.entity.Component;
import com.epam.tasktwo.entity.impl.Composite;

import java.util.List;

/**
 * Получает данные в одной строчке и разделяет их. Разделенные данные помещает в component и возвращает этот component.
 * Takes data in one string and split it. Saves separated data in {@link Component} and return it.
 */
public interface DataParser {

  boolean hasNextParser();

  Component handleParserRequest(String string);


}
