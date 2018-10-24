package com.whatsapp.memory.dump.a;

import java.util.HashMap;
import java.util.Map;

public enum f
{
  private static Map<Integer, f> l;
  int j;
  int k;
  
  static
  {
    int n = 0;
    a = new f("OBJECT", 0, 2, 0);
    b = new f("BOOLEAN", 1, 4, 1);
    c = new f("CHAR", 2, 5, 2);
    d = new f("FLOAT", 3, 6, 4);
    e = new f("DOUBLE", 4, 7, 8);
    f = new f("BYTE", 5, 8, 1);
    g = new f("SHORT", 6, 9, 2);
    h = new f("INT", 7, 10, 4);
    i = new f("LONG", 8, 11, 8);
    m = new f[] { a, b, c, d, e, f, g, h, i };
    l = new HashMap();
    f[] arrayOff = values();
    int i1 = arrayOff.length;
    while (n < i1)
    {
      f localf = arrayOff[n];
      l.put(Integer.valueOf(localf.j), localf);
      n += 1;
    }
  }
  
  private f(int paramInt1, int paramInt2)
  {
    this.j = paramInt1;
    this.k = paramInt2;
  }
  
  public static f a(int paramInt)
  {
    return (f)l.get(Integer.valueOf(paramInt));
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/memory/dump/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */