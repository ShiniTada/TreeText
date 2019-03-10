package com.epam.tasktwo.reader.impl;

import com.epam.tasktwo.exception.ReadDataException;
import com.epam.tasktwo.reader.DataReader;
import com.epam.tasktwo.validator.FileValidator;
import com.epam.tasktwo.validator.impl.FileValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;


public class DataReaderImpl implements DataReader {

  private final static Logger LOGGER = LogManager.getLogger(DataReader.class);
  private final static DataReaderImpl INSTANCE = new DataReaderImpl();


  private DataReaderImpl() {
  }


  public static DataReaderImpl getInstance() {
    return INSTANCE;
  }

  @Override
  public String readData(String path) throws ReadDataException {
    File file = new File(path);
    FileValidator fileValidator = FileValidatorImpl.getInstance();
    if(!fileValidator.checkFile(file)) {
      LOGGER.warn("File:" + path + "  is not exist or empty");
      throw new ReadDataException("File is not exist or empty - " + path);
    }
    try {
      List<String> allLines = Files.readAllLines(file.toPath());
      LOGGER.info("File:" + file + " was successfully read");
      String allText = String.join(" ", allLines);
      return allText;
    } catch (IOException e) {
      LOGGER.warn("File:" + path + ". Exception with readAllLines method");
      LOGGER.fatal(e);
      throw new ReadDataException(e);
    }
  }

}