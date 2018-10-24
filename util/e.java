package com.whatsapp.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class e
  extends OutputStream
{
  final File a;
  final File b;
  final FileOutputStream c;
  boolean d;
  
  public e(bk parambk, File paramFile)
  {
    this(parambk, paramFile, (byte)0);
  }
  
  private e(bk parambk, File paramFile, byte paramByte)
  {
    this.a = parambk.a("");
    this.b = paramFile;
    this.c = new FileOutputStream(this.a);
  }
  
  public final void close()
  {
    try
    {
      if (!this.d)
      {
        this.d = true;
        this.c.close();
        this.b.delete();
        if (!this.a.renameTo(this.b)) {
          throw new IOException("File.renameTo failed");
        }
      }
    }
    finally {}
  }
  
  public final void flush()
  {
    this.c.flush();
  }
  
  public final void write(int paramInt)
  {
    this.c.write(paramInt);
  }
  
  public final void write(byte[] paramArrayOfByte)
  {
    this.c.write(paramArrayOfByte);
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.c.write(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */