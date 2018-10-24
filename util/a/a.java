package com.whatsapp.util.a;

import com.whatsapp.and;
import com.whatsapp.atv;
import java.io.File;

public class a
{
  private static volatile a d;
  final c a;
  final and b;
  final atv c;
  
  private a(c paramc, and paramand, atv paramatv)
  {
    this.a = paramc;
    this.b = paramand;
    this.c = paramatv;
  }
  
  public static a a()
  {
    if (d == null) {}
    try
    {
      d = new a(c.a(), and.a(), atv.a());
      return d;
    }
    finally {}
  }
  
  public static File b()
  {
    int i = 0;
    while (i < 2)
    {
      File localFile = new File("/data/anr/", new String[] { "traces.txt", "traces_com.whatsapp.txt" }[i]);
      if (localFile.exists()) {
        return localFile;
      }
      i += 1;
    }
    return null;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */