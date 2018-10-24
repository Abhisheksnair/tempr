package com.whatsapp.observablelistview;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class b
{
  private Set<b> a = new HashSet();
  
  public final void a()
  {
    synchronized (this.a)
    {
      if (this.a.isEmpty()) {
        return;
      }
      Iterator localIterator = this.a.iterator();
      if (localIterator.hasNext()) {
        ((b)localIterator.next()).a();
      }
    }
  }
  
  public final void a(b paramb)
  {
    synchronized (this.a)
    {
      this.a.add(paramb);
      return;
    }
  }
  
  public final void b()
  {
    Object localObject3;
    synchronized (this.a)
    {
      if (this.a.isEmpty()) {
        return;
      }
      Iterator localIterator2 = this.a.iterator();
      Object localObject1 = null;
      if (localIterator2.hasNext())
      {
        b localb = (b)localIterator2.next();
        localb.b();
        localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = new LinkedList();
        }
        ((List)localObject3).add(localb);
        localObject1 = localObject3;
      }
    }
    if (localObject2 != null)
    {
      Iterator localIterator1 = ((List)localObject2).iterator();
      while (localIterator1.hasNext())
      {
        localObject3 = (b)localIterator1.next();
        this.a.remove(localObject3);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(b.b paramb);
  }
  
  public static abstract interface b
  {
    public abstract void a();
    
    public abstract boolean b();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/observablelistview/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */