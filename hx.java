package com.whatsapp;

import android.database.Observable;
import java.util.ArrayList;
import java.util.Iterator;

public final class hx
  extends Observable<a>
{
  private static final hx a = new hx();
  
  public static hx a()
  {
    return a;
  }
  
  public final void a(int paramInt)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).a(paramInt);
    }
  }
  
  public final void a(String paramString)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).a(paramString);
    }
  }
  
  public final void a(String paramString, boolean paramBoolean)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).a(paramString, paramBoolean);
    }
  }
  
  public final void b()
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).a();
    }
  }
  
  public static class a
  {
    public void a() {}
    
    public void a(int paramInt) {}
    
    public void a(String paramString) {}
    
    public void a(String paramString, boolean paramBoolean) {}
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/hx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */