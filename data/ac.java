package com.whatsapp.data;

import android.database.Observable;
import com.whatsapp.protocol.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class ac
  extends Observable<ab>
{
  private static final ac a = new ac();
  
  public static ac a()
  {
    return a;
  }
  
  final void a(j paramj)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((ab)localIterator.next()).a(paramj);
    }
  }
  
  final void a(j paramj, int paramInt)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((ab)localIterator.next()).b(paramj, paramInt);
    }
  }
  
  final void a(j paramj, boolean paramBoolean)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((ab)localIterator.next()).a(paramj, paramBoolean);
    }
  }
  
  final void a(String paramString)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((ab)localIterator.next()).b(paramString);
    }
  }
  
  final void a(Collection<j> paramCollection, String paramString, Map<String, Integer> paramMap, boolean paramBoolean)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((ab)localIterator.next()).a(paramCollection, paramString, paramMap, paramBoolean);
    }
  }
  
  final void a(Collection<j> paramCollection, Map<String, Integer> paramMap)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((ab)localIterator.next()).a(paramCollection, paramMap);
    }
  }
  
  final void b()
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((ab)localIterator.next()).b();
    }
  }
  
  final void b(j paramj)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((ab)localIterator.next()).b(paramj);
    }
  }
  
  final void b(j paramj, int paramInt)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((ab)localIterator.next()).c(paramj, paramInt);
    }
  }
  
  final void b(String paramString)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((ab)localIterator.next()).a(paramString);
    }
  }
  
  final void c(j paramj)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((ab)localIterator.next()).c(paramj);
    }
  }
  
  final void c(j paramj, int paramInt)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((ab)localIterator.next()).a(paramj, paramInt);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/data/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */