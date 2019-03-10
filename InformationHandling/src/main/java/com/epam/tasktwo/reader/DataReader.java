package com.epam.tasktwo.reader;

import com.epam.tasktwo.exception.ReadDataException;

public interface DataReader {

  public String readData(String path) throws ReadDataException;

}