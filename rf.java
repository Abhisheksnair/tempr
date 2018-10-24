package com.whatsapp;

public final class rf
{
  public final String a;
  public boolean b;
  public boolean c;
  public boolean d;
  public int e;
  
  public rf(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.a = paramString;
    this.b = paramBoolean1;
    this.c = paramBoolean2;
    this.d = paramBoolean3;
  }
  
  public final String toString()
  {
    return "GroupParticipant{jid='" + this.a + '\'' + ", admin=" + this.b + ", pending=" + this.c + ", sentSenderKey=" + this.d + '}';
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/rf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */