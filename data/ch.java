package com.whatsapp.data;

import android.content.Context;
import com.whatsapp.registration.bb;
import com.whatsapp.u;
import com.whatsapp.vv;
import java.io.File;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ch
{
  private static volatile ch f;
  public final n a;
  final ReentrantReadWriteLock b;
  final File c;
  public boolean d;
  public boolean e;
  
  private ch(Context paramContext, vv paramvv, bb parambb, String paramString)
  {
    this.c = paramContext.getDatabasePath(paramString);
    this.a = new n(paramContext, paramvv, parambb, this.c);
    this.b = new ReentrantReadWriteLock();
  }
  
  public static ch a()
  {
    if (f == null) {}
    try
    {
      if (f == null) {
        f = new ch(u.a(), vv.a(), bb.a(), "msgstore.db");
      }
      return f;
    }
    finally {}
  }
  
  public static enum a
  {
    private a() {}
    
    public final boolean a()
    {
      return (this == a) || (this == d) || (this == e) || (this == f);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/data/ch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */