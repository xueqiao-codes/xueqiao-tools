package com.longsheng.xueqiao.duck.thriftapi;


import java.util.HashMap;
import java.util.Map; 

public class DuckServiceFunctionMapping {

  private static Map<String, Integer> sMapping = new HashMap<String, Integer>();

  static {
    putEntry("getSession",1);
    putEntry("updateSession",2);
    putEntry("deleteSession",3);
    putEntry("batchGetSession",4);
    putEntry("getAppSession",5);
    putEntry("updateAppSession",6);
    putEntry("deleteAppSession",7);
  }

  public static int getUniqueNumber(String functionName) {
    Integer number = sMapping.get(functionName);
    if (number == null) {
      return -1;    }
    return number.intValue();
  }

  private static void putEntry(String functionName, int uniqueNumber) {
    sMapping.put(functionName, uniqueNumber);
  }

}
