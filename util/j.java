package com.whatsapp.util;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public final class j
  implements Comparator<File>
{
  private final String a;
  private final DateFormat b;
  private final String c;
  
  public j(String paramString, SimpleDateFormat paramSimpleDateFormat)
  {
    this.a = paramString;
    this.b = paramSimpleDateFormat;
    this.c = paramSimpleDateFormat.toPattern();
  }
  
  private Date a(File paramFile)
  {
    paramFile = paramFile.getName();
    if (this.a.length() + this.c.length() > paramFile.length()) {
      return null;
    }
    paramFile = paramFile.substring(this.a.length(), this.a.length() + this.c.length());
    try
    {
      paramFile = this.b.parse(paramFile);
      return paramFile;
    }
    catch (ParseException paramFile) {}
    return null;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */