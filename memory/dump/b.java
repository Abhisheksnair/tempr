package com.whatsapp.memory.dump;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;

public final class b
{
  static final Pattern a = Pattern.compile("dump\\.hprof.*");
  private final Context b;
  
  public b(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
  }
  
  static void a(File paramFile1, File paramFile2)
  {
    paramFile1 = new FileInputStream(paramFile1);
    try
    {
      paramFile2 = new FileOutputStream(paramFile2);
      try
      {
        GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(paramFile2);
        try
        {
          byte[] arrayOfByte = new byte['Ѐ'];
          for (;;)
          {
            int i = paramFile1.read(arrayOfByte);
            if (i == -1) {
              break;
            }
            localGZIPOutputStream.write(arrayOfByte, 0, i);
          }
          localObject1 = finally;
        }
        finally {}
        paramFile2 = finally;
      }
      finally {}
      ((GZIPOutputStream)localObject1).flush();
    }
    finally
    {
      paramFile1.close();
    }
    ((GZIPOutputStream)localObject1).close();
    paramFile2.close();
    paramFile1.close();
  }
  
  public final String a()
  {
    return this.b.getCacheDir().getPath();
  }
  
  public final File[] a(String paramString)
  {
    new File(paramString).listFiles(new FilenameFilter()
    {
      public final boolean accept(File paramAnonymousFile, String paramAnonymousString)
      {
        return b.a.matcher(paramAnonymousString).matches();
      }
    });
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/memory/dump/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */