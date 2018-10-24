package com.whatsapp;

import com.whatsapp.util.Log;
import com.whatsapp.util.bk;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class oz
{
  private static volatile oz m;
  private static SimpleDateFormat s = new SimpleDateFormat("yyyyww", Locale.US);
  public File a;
  public File b;
  public File c;
  public File d;
  public File e;
  public File f;
  public File g;
  public File h;
  public File i;
  File j;
  public File k;
  public boolean l;
  private File n;
  private File o;
  private File p;
  private File q;
  private File r;
  private final ox t;
  
  private oz(ox paramox)
  {
    this.t = paramox;
  }
  
  public static oz a()
  {
    if (m == null) {}
    try
    {
      if (m == null) {
        m = new oz(ox.a());
      }
      return m;
    }
    finally {}
  }
  
  public static File a(File paramFile, String paramString)
  {
    int i2 = 0;
    int i1 = i2;
    if (paramFile.exists())
    {
      if (!paramFile.isFile()) {
        break label62;
      }
      paramFile.delete();
      i1 = i2;
    }
    for (;;)
    {
      if ((i1 == 0) && (!paramFile.mkdirs())) {
        Log.e("app/extsharedfile/folder/created/false");
      }
      File localFile = paramFile;
      if (paramString != null) {
        localFile = new File(paramFile, paramString);
      }
      return localFile;
      label62:
      i1 = i2;
      if (paramFile.isDirectory()) {
        i1 = 1;
      }
    }
  }
  
  private static File a(File paramFile, boolean paramBoolean)
  {
    int i2 = 0;
    int i1 = i2;
    if (paramFile.exists())
    {
      if (!paramFile.isFile()) {
        break label66;
      }
      paramFile.delete();
      i1 = i2;
    }
    for (;;)
    {
      if (i1 == 0) {
        paramFile.mkdirs();
      }
      File localFile;
      if (paramBoolean)
      {
        localFile = new File(paramFile, ".nomedia");
        if (localFile.exists()) {}
      }
      try
      {
        localFile.createNewFile();
        return paramFile;
      }
      catch (IOException localIOException)
      {
        label66:
        Log.e("fmessageio/prepareFolder " + paramFile + " " + localIOException.toString());
      }
      i1 = i2;
      if (paramFile.isDirectory()) {
        i1 = 1;
      }
    }
    return paramFile;
  }
  
  static File c(File paramFile)
  {
    return a(paramFile, false);
  }
  
  public final File a(byte paramByte, int paramInt, boolean paramBoolean)
  {
    if (!this.l) {
      j();
    }
    File localFile;
    if (paramByte == 2) {
      if (paramInt == 1) {
        localFile = new File(this.n, s.format(new Date()));
      }
    }
    for (;;)
    {
      return a(localFile, paramBoolean);
      if (paramBoolean)
      {
        localFile = this.e;
      }
      else
      {
        localFile = this.a;
        continue;
        if (paramByte == 1)
        {
          if (paramBoolean) {
            localFile = this.h;
          } else {
            localFile = this.c;
          }
        }
        else if (paramByte == 3)
        {
          if (paramBoolean) {
            localFile = this.g;
          } else {
            localFile = this.o;
          }
        }
        else if (paramByte == 13)
        {
          if (paramBoolean) {
            localFile = this.f;
          } else {
            localFile = this.b;
          }
        }
        else if (paramByte == 9)
        {
          if (paramBoolean) {
            localFile = this.i;
          } else {
            localFile = this.d;
          }
        }
        else {
          localFile = this.t.a("Media");
        }
      }
    }
  }
  
  public final File a(String paramString)
  {
    return a(i(), paramString);
  }
  
  public final File a(String paramString, byte paramByte, int paramInt, boolean paramBoolean)
  {
    return new File(a(paramByte, paramInt, paramBoolean), paramString);
  }
  
  public final boolean a(File paramFile)
  {
    if (!this.l) {
      j();
    }
    return (paramFile != null) && (paramFile.getCanonicalPath().startsWith(this.r.getCanonicalPath()));
  }
  
  public final File b()
  {
    if (!this.l) {
      j();
    }
    return this.n;
  }
  
  public final boolean b(File paramFile)
  {
    if (!this.l) {
      j();
    }
    return (paramFile != null) && (paramFile.getCanonicalPath().startsWith(this.o.getCanonicalPath()));
  }
  
  public final File c()
  {
    if (!this.l) {
      j();
    }
    return this.q;
  }
  
  public final File d()
  {
    if (!this.l) {
      j();
    }
    return a(this.r, false);
  }
  
  public final File e()
  {
    if (!this.l) {
      j();
    }
    return a(this.p, false);
  }
  
  public final File f()
  {
    if (!this.l) {
      j();
    }
    return this.o;
  }
  
  public final File g()
  {
    if (!this.l) {
      j();
    }
    return a(this.d, false);
  }
  
  public final File h()
  {
    if (!this.l) {
      j();
    }
    return a(this.k, false);
  }
  
  public final File i()
  {
    return this.t.a(".Shared");
  }
  
  public final void j()
  {
    this.r = a(this.t.a("Media"), false);
    this.a = a(new File(this.r, "WhatsApp Audio"), false);
    this.b = a(new File(this.r, "WhatsApp Animated Gifs"), false);
    this.n = a(new File(this.r, "WhatsApp Voice Notes"), true);
    this.o = a(new File(this.r, "WhatsApp Video"), false);
    this.c = a(new File(this.r, "WhatsApp Images"), false);
    this.d = a(new File(this.r, "WhatsApp Documents"), false);
    this.p = a(new File(this.r, "WallPaper"), false);
    this.j = a(new File(this.r, "WhatsApp Profile Photos"), false);
    this.k = a(new File(this.r, ".Statuses"), false);
    File localFile = new File(this.r, "WhatsApp Calls");
    VoiceService.z();
    if (av.d()) {}
    for (this.q = a(localFile, true);; this.q = null)
    {
      this.e = a(new File(this.a, "Sent"), true);
      this.f = a(new File(this.b, "Sent"), true);
      this.g = a(new File(this.o, "Sent"), true);
      this.h = a(new File(this.c, "Sent"), true);
      this.i = a(new File(this.d, "Sent"), true);
      this.l = true;
      return;
      if (localFile.exists())
      {
        bk.a(localFile);
        Log.i("fmessageio/initExternalStorageDirectory calls dir removed");
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/oz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */