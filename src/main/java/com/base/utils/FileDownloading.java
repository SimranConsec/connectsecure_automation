package com.base.utils;

import java.io.File;

public class FileDownloading {

  /**
   * This method will check if the file is downloaded or not.
   * 
   * @param downloadPath - Path of the downloaded file.
   * @param fileName - Name of the downloaded file.
   * @return - True if file is downloaded, false otherwise.
   * @author sudheer.singh
   */
  public boolean isFileDownloaded(String downloadPath, String fileName) {
    boolean flag = false;
    File dir = new File(downloadPath);
    File[] dirContents = dir.listFiles();
    for (int i = 0; i < dirContents.length; i++) {
      if (dirContents[i].getName().contains(fileName)) {
        return flag = true;
      }
    }
    return flag;
  }
}
