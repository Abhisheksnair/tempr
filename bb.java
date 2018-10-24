package com.whatsapp;

import a.a.a.a.a.a.d;
import android.database.Observable;
import com.whatsapp.protocol.j;
import com.whatsapp.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public final class bb
  extends Observable<a>
{
  private static final bb a = new bb();
  
  public static bb a()
  {
    return a;
  }
  
  public final void a(j paramj)
  {
    Log.i("voip/notifyCallEnded");
    a.d.b();
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).b(paramj);
    }
  }
  
  public final void a(String paramString, long paramLong)
  {
    
    if (paramString == null) {
      Log.e("voip/null_jid");
    }
    for (;;)
    {
      return;
      paramString = this.mObservers.iterator();
      while (paramString.hasNext()) {
        ((a)paramString.next()).a(paramLong);
      }
    }
  }
  
  public final void b(j paramj)
  {
    Log.i("voip/notifyCallMissed");
    a.d.b();
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).c(paramj);
    }
  }
  
  public final void c(j paramj)
  {
    a.d.b();
    Log.i("voip/notifyCallStarted");
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).a(paramj);
    }
  }
  
  public static class a
  {
    protected void a(long paramLong) {}
    
    protected void a(j paramj) {}
    
    protected void b(j paramj) {}
    
    public void c(j paramj) {}
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */