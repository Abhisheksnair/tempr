package com.whatsapp;

import a.a.a.a.d;
import android.content.Context;
import java.io.IOException;
import org.whispersystems.jobqueue.Job;

public class att
{
  private static volatile att c;
  org.whispersystems.jobqueue.a a;
  final Context b;
  
  private att(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public static att a()
  {
    if (c == null) {}
    try
    {
      if (c == null) {
        c = new att(u.a());
      }
      return c;
    }
    finally {}
  }
  
  public final void a(Job paramJob)
  {
    this.a.a(paramJob);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/att.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */