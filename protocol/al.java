package com.whatsapp.protocol;

import java.util.ArrayList;

public class al
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public ArrayList<z> g;
  
  public al() {}
  
  public al(al paramal)
  {
    this.a = paramal.a;
    this.b = paramal.b;
    this.c = paramal.c;
    this.d = paramal.d;
    this.e = paramal.e;
    this.f = paramal.f;
    if (paramal.g != null) {}
    for (paramal = new ArrayList(paramal.g);; paramal = null)
    {
      this.g = paramal;
      return;
    }
  }
  
  public ak a()
  {
    return null;
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if (paramString2 == null) {}
    for (;;)
    {
      return;
      try
      {
        if (this.g == null) {
          this.g = new ArrayList();
        }
        this.g.add(new z(paramString1, paramString2));
      }
      finally {}
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (al)paramObject;
        if (this.b == null)
        {
          if (((al)paramObject).b != null) {
            return false;
          }
        }
        else if (!this.b.equals(((al)paramObject).b)) {
          return false;
        }
        if (this.a == null)
        {
          if (((al)paramObject).a != null) {
            return false;
          }
        }
        else if (!this.a.equals(((al)paramObject).a)) {
          return false;
        }
        if (this.c == null)
        {
          if (((al)paramObject).c != null) {
            return false;
          }
        }
        else if (!this.c.equals(((al)paramObject).c)) {
          return false;
        }
        if (this.e == null)
        {
          if (((al)paramObject).e != null) {
            return false;
          }
        }
        else if (!this.e.equals(((al)paramObject).e)) {
          return false;
        }
        if (this.d == null)
        {
          if (((al)paramObject).d != null) {
            return false;
          }
        }
        else if (!this.d.equals(((al)paramObject).d)) {
          return false;
        }
        if (this.f == null)
        {
          if (((al)paramObject).f != null) {
            return false;
          }
        }
        else if (!this.f.equals(((al)paramObject).f)) {
          return false;
        }
        if (this.g != null) {
          break;
        }
      } while (((al)paramObject).g == null);
      return false;
    } while (this.g.equals(((al)paramObject).g));
    return false;
  }
  
  public int hashCode()
  {
    int i2 = 0;
    int i;
    int j;
    label21:
    int k;
    label30:
    int m;
    label40:
    int n;
    label50:
    int i1;
    if (this.b == null)
    {
      i = 0;
      if (this.a != null) {
        break label117;
      }
      j = 0;
      if (this.c != null) {
        break label128;
      }
      k = 0;
      if (this.e != null) {
        break label139;
      }
      m = 0;
      if (this.d != null) {
        break label151;
      }
      n = 0;
      if (this.f != null) {
        break label163;
      }
      i1 = 0;
      label60:
      if (this.g != null) {
        break label175;
      }
    }
    for (;;)
    {
      return (i1 + (n + (m + (k + (j + (i + 31) * 31) * 31) * 31) * 31) * 31) * 31 + i2;
      i = this.b.hashCode();
      break;
      label117:
      j = this.a.hashCode();
      break label21;
      label128:
      k = this.c.hashCode();
      break label30;
      label139:
      m = this.e.hashCode();
      break label40;
      label151:
      n = this.d.hashCode();
      break label50;
      label163:
      i1 = this.f.hashCode();
      break label60;
      label175:
      i2 = this.g.hashCode();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("[StanzaKey");
    if (this.a == null)
    {
      str = "";
      localStringBuilder = localStringBuilder.append(str);
      if (this.b != null) {
        break label137;
      }
      str = "";
      label36:
      localStringBuilder = localStringBuilder.append(str);
      if (this.c != null) {
        break label160;
      }
      str = "";
      label52:
      localStringBuilder = localStringBuilder.append(str);
      if (this.d != null) {
        break label183;
      }
      str = "";
      label68:
      localStringBuilder = localStringBuilder.append(str);
      if (this.e != null) {
        break label206;
      }
      str = "";
      label84:
      localStringBuilder = localStringBuilder.append(str);
      if (this.f != null) {
        break label229;
      }
    }
    label137:
    label160:
    label183:
    label206:
    label229:
    for (String str = "";; str = " editVersion=" + this.f)
    {
      return str + "]";
      str = " from=" + this.a;
      break;
      str = " cls=" + this.b;
      break label36;
      str = " id=" + this.c;
      break label52;
      str = " type=" + this.d;
      break label68;
      str = " participant=" + this.e;
      break label84;
    }
  }
  
  public static final class a
    extends al
  {
    public long h;
    public int i;
    
    public a(al paramal, long paramLong, int paramInt)
    {
      super();
      this.h = paramLong;
      this.i = paramInt;
    }
    
    public final ak a()
    {
      if (this.h > 0L) {
        return new ak("terminate", new z[] { new z("duration", String.valueOf(this.h)), new z("videostate", String.valueOf(this.i)) });
      }
      return null;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/protocol/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */