package com.whatsapp.data;

import com.whatsapp.protocol.j;
import java.util.ArrayList;
import java.util.List;

public final class m
{
  private static final m b = new m();
  final List<j> a = new ArrayList();
  
  public static m a()
  {
    return b;
  }
  
  public final boolean b()
  {
    for (;;)
    {
      synchronized (this.a)
      {
        if (this.a.size() > 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public final List<j> c()
  {
    synchronized (this.a)
    {
      ArrayList localArrayList = new ArrayList(this.a);
      return localArrayList;
    }
  }
  
  public final void d()
  {
    synchronized (this.a)
    {
      this.a.clear();
      return;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/data/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */