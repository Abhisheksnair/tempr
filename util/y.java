package com.whatsapp.util;

import java.io.File;
import java.io.FileInputStream;
import java.nio.channels.FileChannel;

public abstract class y
  extends FileInputStream
{
  private long a;
  
  public y(File paramFile)
  {
    super(paramFile);
  }
  
  public abstract boolean a();
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      if ((getChannel().size() >= this.a + paramInt2) || (!a()))
      {
        paramInt1 = super.read(paramArrayOfByte, paramInt1, paramInt2);
        if (paramInt1 >= 0) {
          this.a += paramInt1;
        }
        return paramInt1;
      }
      try
      {
        Thread.sleep(200L);
      }
      catch (InterruptedException paramArrayOfByte) {}
    }
    return 0;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */