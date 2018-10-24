package com.whatsapp;

import android.os.Environment;
import java.io.File;

public final class ox
{
  private static final ox b = new ox();
  public final File a = new File(Environment.getExternalStorageDirectory(), "WhatsApp");
  
  public static ox a()
  {
    return b;
  }
  
  public final File a(String paramString)
  {
    return new File(this.a, paramString);
  }
  
  public final boolean a(File paramFile)
  {
    return paramFile.getAbsolutePath().startsWith(this.a.getAbsolutePath());
  }
  
  public final File b()
  {
    return new File(this.a, "Databases");
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */