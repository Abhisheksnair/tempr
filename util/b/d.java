package com.whatsapp.util.b;

public final class d
  extends c
{
  protected c[] c;
  
  protected d(long paramLong, String paramString, c[] paramArrayOfc)
  {
    super(paramLong, paramString);
    this.c = paramArrayOfc;
  }
  
  public final c[] a()
  {
    return this.c;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append(this.b).append(" (").append(this.a).append(" bytes) - ").append(this.c.length);
    if (this.c.length == 1) {}
    for (String str = " child";; str = " children") {
      return str;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */