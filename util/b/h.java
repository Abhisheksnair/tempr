package com.whatsapp.util.b;

import java.io.RandomAccessFile;

public final class h
  extends f
{
  int c;
  long d;
  long e;
  long f;
  b g = b.j;
  double h;
  double i;
  
  public h(long paramLong, String paramString, RandomAccessFile paramRandomAccessFile)
  {
    super(paramLong, paramString);
    this.c = a.a(paramRandomAccessFile);
    a.c(paramRandomAccessFile);
    this.d = a.d(paramRandomAccessFile);
    this.e = a.d(paramRandomAccessFile);
    a.d(paramRandomAccessFile);
    a.d(paramRandomAccessFile);
    this.f = a.d(paramRandomAccessFile);
    a.d(paramRandomAccessFile);
    a.d(paramRandomAccessFile);
    a.b(paramRandomAccessFile);
    a.b(paramRandomAccessFile);
    a.b(paramRandomAccessFile);
    a.b(paramRandomAccessFile);
    this.g = b.a(paramRandomAccessFile);
    this.h = a.f(paramRandomAccessFile);
    this.i = a.f(paramRandomAccessFile);
  }
  
  public final String toString()
  {
    return super.toString() + "[" + a.a(this.d) + "/" + a.a(this.e) + " duration:" + this.f + "units " + this.g + " " + this.h + "x" + this.i + " rotation:" + this.g.a() + "]";
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/b/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */