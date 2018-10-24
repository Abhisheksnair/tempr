package com.whatsapp.protocol;

public final class ar
{
  public String a;
  public long b;
  public int c;
  public long d;
  public int e;
  public j.b f;
  public j.b[] g;
  public long h;
  public long i;
  public boolean j;
  
  public ar(long paramLong, int paramInt, String paramString)
  {
    this(paramString, paramInt, 0, 0L, 0L, paramLong, null);
  }
  
  public ar(String paramString, int paramInt)
  {
    this.a = paramString;
    this.c = paramInt;
  }
  
  public ar(String paramString, int paramInt1, int paramInt2)
  {
    this(paramString, paramInt1, paramInt2, 0L, 0L, 0L, null);
  }
  
  private ar(String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, j.b paramb)
  {
    this.a = paramString;
    this.c = paramInt1;
    this.d = paramLong1;
    this.e = paramInt2;
    this.f = paramb;
    this.h = paramLong2;
    this.i = paramLong3;
  }
  
  public ar(String paramString, int paramInt, long paramLong)
  {
    this(paramString, paramInt, paramLong, 0L);
  }
  
  public ar(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    this(paramString, paramInt, 0, paramLong1, paramLong2, 0L, null);
  }
  
  public ar(String paramString, int paramInt, j.b paramb)
  {
    this(paramString, paramInt, 0, 0L, 0L, 0L, paramb);
  }
  
  public ar(String paramString, int paramInt, j.b paramb, j.b[] paramArrayOfb, boolean paramBoolean)
  {
    this(paramString, paramInt, 0, 0L, 0L, 0L, paramb);
    this.g = paramArrayOfb;
    this.j = paramBoolean;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/protocol/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */