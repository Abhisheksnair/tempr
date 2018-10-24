package com.whatsapp;

import android.database.Observable;
import com.whatsapp.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public final class ba
  extends Observable<a>
{
  private static final ba a = new ba();
  
  public static ba a()
  {
    return a;
  }
  
  public final void b()
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext())
    {
      bk localbk = ((a)localIterator.next()).a;
      Log.i("voip/CallsFragment/onCallLogDeleted");
      localbk.S();
    }
  }
  
  public static final class a
  {
    final bk a;
    
    a(bk parambk)
    {
      this.a = parambk;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */