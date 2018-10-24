package com.whatsapp.util;

import java.io.File;

public final class ac
{
  public final File a;
  public final int b;
  
  public ac(File paramFile)
  {
    if (!paramFile.isDirectory()) {
      throw new IllegalArgumentException("root must be a directory");
    }
    this.a = paramFile;
    this.b = Integer.MAX_VALUE;
  }
  
  public static long a(int paramInt1, String paramString, File paramFile, int paramInt2)
  {
    Object localObject = new char[2];
    Object tmp7_5 = localObject;
    tmp7_5[0] = 45;
    Object tmp12_7 = tmp7_5;
    tmp12_7[1] = 45;
    tmp12_7;
    if (paramFile.canRead()) {
      tmp7_5[0] = 114;
    }
    if (paramFile.canWrite()) {
      tmp7_5[1] = 119;
    }
    tmp7_5 = new String((char[])tmp7_5);
    if (paramFile.isDirectory())
    {
      if (paramInt2 > 0) {
        Log.a(paramInt1, paramString + "/ls d" + (String)tmp7_5 + ' ' + paramFile.getAbsolutePath());
      }
      File[] arrayOfFile = paramFile.listFiles();
      if (arrayOfFile == null) {
        throw new IllegalStateException("empty file list from directory " + paramFile);
      }
      int j = arrayOfFile.length;
      long l1 = 0L;
      int i = 0;
      while (i < j)
      {
        long l2 = a(paramInt1, paramString, arrayOfFile[i], paramInt2 - 1);
        i += 1;
        l1 = l2 + l1;
      }
      if (paramInt2 >= 0) {
        Log.a(paramInt1, paramString + "/ls d" + (String)tmp7_5 + ' ' + paramFile.getAbsolutePath() + " total " + l1);
      }
      return l1;
    }
    if (paramInt2 >= 0) {
      Log.a(paramInt1, paramString + "/ls -" + (String)tmp7_5 + ' ' + paramFile.getAbsolutePath() + ' ' + paramFile.length());
    }
    return paramFile.length();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */