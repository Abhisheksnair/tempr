package com.whatsapp.util.b;

import java.io.RandomAccessFile;

public final class g
  extends f
{
  int c;
  long d;
  long e;
  long f;
  long g;
  b h = b.j;
  
  public g(long paramLong, String paramString, RandomAccessFile paramRandomAccessFile)
  {
    super(paramLong, paramString);
    this.c = a.a(paramRandomAccessFile);
    a.c(paramRandomAccessFile);
    this.d = a.d(paramRandomAccessFile);
    this.e = a.d(paramRandomAccessFile);
    this.f = a.d(paramRandomAccessFile);
    this.g = a.d(paramRandomAccessFile);
    a.d(paramRandomAccessFile);
    a.b(paramRandomAccessFile);
    a.b(paramRandomAccessFile);
    a.d(paramRandomAccessFile);
    a.d(paramRandomAccessFile);
    this.h = b.a(paramRandomAccessFile);
  }
  
  public final String toString()
  {
    return super.toString() + "[" + a.a(this.d) + "/" + a.a(this.e) + " duration:" + this.g / this.f + "sec (" + this.g + ") " + this.h + "]";
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */