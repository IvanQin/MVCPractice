package com.ivanqin.shared;

public class Logger {
  private static Logger sLogger;

  public static Logger getInstance() {
    if (sLogger == null) {
      sLogger = new Logger();
    }
    return sLogger;
  }

  public void speak(Class clazz, String words) {
    System.out.println(String.format("%s says: %s", clazz.getCanonicalName(), words));
  }
}
