package com.whatsapp.f;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class e
{
  public Set<d> a = new HashSet();
  
  public final void a()
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
        d locald = (d)localIterator2.next();
        locald.a();
        localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = new LinkedList();
        }
        ((List)localObject3).add(locald);
        localObject1 = localObject3;
      }
    }
    if (localObject2 != null)
    {
      Iterator localIterator1 = ((List)localObject2).iterator();
      while (localIterator1.hasNext())
      {
        localObject3 = (d)localIterator1.next();
        this.a.remove(localObject3);
      }
    }
  }
  
  public final void a(d paramd)
  {
    synchronized (this.a)
    {
      this.a.add(paramd);
      return;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/f/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */