package com.whatsapp.protocol;

import java.util.List;

public final class av
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public int i;
  public int j;
  public int k;
  public long l;
  public long m;
  public long n;
  public boolean o;
  public boolean p;
  public boolean q;
  public boolean r;
  public j s;
  public List t;
  public byte[] u;
  public float v;
  public byte[] w;
  public String x;
  public List<av> y;
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id: ").append(this.c);
    localStringBuilder.append(" jid: " + this.d);
    localStringBuilder.append(" url: " + this.h);
    return localStringBuilder.toString();
  }
  
  public static final class a
  {
    public String a;
    public int b;
    public long c;
    public boolean d;
    
    public a(String paramString, int paramInt, long paramLong)
    {
      this(paramString, false, paramInt, paramLong);
    }
    
    public a(String paramString, boolean paramBoolean, int paramInt)
    {
      this(paramString, paramBoolean, paramInt, 0L);
    }
    
    private a(String paramString, boolean paramBoolean, int paramInt, long paramLong)
    {
      if ((paramString == null) || ((paramInt != 1) && (paramInt != 2) && (paramInt != 3) && (paramInt != 4))) {
        throw new IllegalArgumentException("invalid web status");
      }
      this.a = paramString;
      this.b = paramInt;
      this.c = paramLong;
      this.d = paramBoolean;
    }
  }
  
  public static final class b
  {
    public j.b a;
    public boolean b;
    public boolean c;
    public String d;
    public long e;
    public boolean f;
    public int g;
    public int h;
    public boolean i;
    public long j;
    
    public b(j.b paramb, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, boolean paramBoolean3, int paramInt1, int paramInt2, boolean paramBoolean4, long paramLong2)
    {
      this.a = paramb;
      this.d = paramb.a;
      this.b = paramBoolean1;
      this.e = paramLong1;
      this.c = paramBoolean2;
      this.f = paramBoolean3;
      this.g = paramInt1;
      this.h = paramInt2;
      this.i = paramBoolean4;
      this.j = paramLong2;
    }
    
    public b(String paramString, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, boolean paramBoolean3, int paramInt, boolean paramBoolean4, long paramLong2)
    {
      this.d = paramString;
      this.b = paramBoolean1;
      this.e = paramLong1;
      this.c = paramBoolean2;
      this.f = paramBoolean3;
      this.g = paramInt;
      this.i = paramBoolean4;
      this.j = paramLong2;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/protocol/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */