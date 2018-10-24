package com.whatsapp;

import android.database.Observable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public final class dh
  extends Observable<a>
{
  private static final dh a = new dh();
  
  public static dh a()
  {
    return a;
  }
  
  public final void a(String paramString)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).a(paramString);
    }
  }
  
  public final void a(Collection<String> paramCollection)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).a(paramCollection);
    }
  }
  
  public final void b()
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).a();
    }
  }
  
  public final void b(String paramString)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).b(paramString);
    }
  }
  
  public final void c()
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).b();
    }
  }
  
  public final void c(String paramString)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).e(paramString);
    }
  }
  
  public final void d(String paramString)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).d(paramString);
    }
  }
  
  public final void e(String paramString)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).c(paramString);
    }
  }
  
  public static class a
  {
    public void a() {}
    
    public void a(String paramString) {}
    
    protected void a(Collection<String> paramCollection) {}
    
    protected void b() {}
    
    public void b(String paramString) {}
    
    protected void c(String paramString) {}
    
    public void d(String paramString) {}
    
    protected void e(String paramString) {}
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/dh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */