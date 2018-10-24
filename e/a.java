package com.whatsapp.e;

public final class a
{
  long a;
  long b;
  
  public a(long paramLong1, long paramLong2)
  {
    this.a = paramLong1;
    this.b = paramLong2;
  }
  
  public final a a(a parama)
  {
    return new a(this.a - parama.a, this.b - parama.b);
  }
  
  public final String toString()
  {
    return "received: " + this.a + ", sent: " + this.b;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */