package com.whatsapp.util.b;

import java.io.RandomAccessFile;

public class e
  extends f
{
  int c;
  String d;
  String e;
  String f;
  String g;
  
  public e(long paramLong, String paramString, RandomAccessFile paramRandomAccessFile)
  {
    super(paramLong, paramString);
    this.c = a.a(paramRandomAccessFile);
    a.c(paramRandomAccessFile);
    this.d = a.e(paramRandomAccessFile);
    this.e = a.e(paramRandomAccessFile);
    this.f = a.e(paramRandomAccessFile);
    a.d(paramRandomAccessFile);
    a.d(paramRandomAccessFile);
    int j = a.a(paramRandomAccessFile);
    int i = j;
    if (j != paramLong - 33L)
    {
      i = (int)paramLong - 33;
      paramRandomAccessFile.seek(paramRandomAccessFile.getFilePointer() - 1L);
    }
    paramString = new byte[i];
    paramRandomAccessFile.read(paramString, 0, i);
    this.g = new String(paramString);
  }
  
  public String toString()
  {
    return super.toString() + "[" + this.d + "/" + this.e + " - " + this.g + "]";
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */