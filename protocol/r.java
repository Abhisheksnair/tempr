package com.whatsapp.protocol;

public final class r
  extends RuntimeException
{
  String a;
  public Throwable b;
  
  public r(Throwable paramThrowable, String paramString)
  {
    this.a = paramString;
    this.b = paramThrowable;
  }
  
  public final String getMessage()
  {
    return "Wrapping: " + this.b + "\nFunRuntimeException last stanza: " + this.a;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/protocol/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */