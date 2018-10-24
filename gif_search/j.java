package com.whatsapp.gif_search;

public final class j
{
  public final a a;
  public final a b;
  public final a c;
  public final int d;
  private final String e;
  
  public j(String paramString, a parama1, a parama2, a parama3, int paramInt)
  {
    this.e = paramString;
    this.a = parama1;
    this.b = parama2;
    this.c = parama3;
    this.d = paramInt;
  }
  
  public final String toString()
  {
    return getClass().getName() + "{id='" + this.e + '\'' + ", preview='" + this.a + '\'' + ", staticPreview='" + this.b + '\'' + ", content='" + this.c + '\'' + '}';
  }
  
  public static final class a
  {
    public final String a;
    public final int b;
    public final int c;
    
    public a(String paramString, int paramInt1, int paramInt2)
    {
      this.a = paramString;
      this.b = paramInt1;
      this.c = paramInt2;
    }
    
    public final String toString()
    {
      return getClass().getName() + "{url='" + this.a + '\'' + ", width=" + this.b + ", height=" + this.c + '}';
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gif_search/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */