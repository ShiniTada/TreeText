package com.epam.tasktwo.validator.impl;

import com.epam.tasktwo.validator.FileValidator;

import java.io.File;


public class FileValidatorImpl implements FileValidator {


  private final static FileValidatorImpl INSTANCE = new FileValidatorImpl();


  private FileValidatorImpl() {
  }


  public static FileValidatorImpl getInstance() {
    return INSTANCE;
  }


  public boolean checkFile(File file) {
    return !(file == null || !file.exists() || file.isDirectory() || file.length() == 0);
  }

}
