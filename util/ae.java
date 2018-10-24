package com.whatsapp.util;

public class ae
{
  public int a;
  public int b;
  public int c;
  public boolean d;
  public int e = -1;
  public int f = -1;
  
  public ae()
  {
    this(0, 0, 0, false);
  }
  
  public ae(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramBoolean;
  }
  
  public String toString()
  {
    return "container: " + this.a + ", video: " + this.b + ", audio: " + this.c + ", problems: " + this.d;
  }
  
  public static final class a
    extends ae
  {
    public a()
    {
      this(0, 0, false);
    }
    
    public a(int paramInt1, int paramInt2)
    {
      this(paramInt1, paramInt2, false);
    }
    
    public a(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      super(0, paramInt2, paramBoolean);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */