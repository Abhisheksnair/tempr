package com.whatsapp.util;

public final class StatResult
{
  public final int a;
  public final int b;
  public final int c;
  public final int d;
  public final long e;
  public final long f;
  
  private StatResult(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramLong1;
    this.f = paramLong2;
  }
  
  public static native StatResult statOpenFile(int paramInt);
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/StatResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */