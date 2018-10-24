package com.whatsapp;

import android.content.Context;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.protocol.j;
import com.whatsapp.util.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class el
{
  private static volatile el d;
  final ant a;
  final aus b;
  final abu c;
  private final pv e;
  private final e f;
  
  private el(ant paramant, pv parampv, e parame, aus paramaus, abu paramabu)
  {
    this.a = paramant;
    this.e = parampv;
    this.f = parame;
    this.b = paramaus;
    this.c = paramabu;
  }
  
  public static el a()
  {
    if (d == null) {}
    try
    {
      if (d == null) {
        d = new el(ant.a(), pv.a(), e.a(), aus.a(), abu.a());
      }
      return d;
    }
    finally {}
  }
  
  public final String a(cs paramcs)
  {
    int i = -1;
    if (j.b(paramcs.t)) {
      return null;
    }
    Object localObject1;
    Object localObject2;
    long l;
    if (paramcs.d())
    {
      localObject1 = this.c;
      paramcs = paramcs.t;
      localObject2 = (abu.d)((abu)localObject1).c.get(paramcs);
      if (localObject2 != null) {
        if (qz.e(paramcs))
        {
          if (((abu.d)localObject2).e == null) {
            break label289;
          }
          l = 0L;
          localObject1 = ((abu.d)localObject2).e.entrySet().iterator();
          paramcs = null;
          label85:
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (Map.Entry)((Iterator)localObject1).next();
            if (((abu.a)((Map.Entry)localObject2).getValue()).a <= l) {
              break label409;
            }
            paramcs = (String)((Map.Entry)localObject2).getKey();
            l = ((abu.a)((Map.Entry)localObject2).getValue()).a;
            i = ((abu.a)((Map.Entry)localObject2).getValue()).b;
          }
        }
      }
    }
    label184:
    label289:
    label292:
    label294:
    label300:
    label409:
    for (;;)
    {
      break label85;
      if (abu.a(l))
      {
        paramcs = new abu.b(paramcs, i);
        if (paramcs == null) {
          break label292;
        }
        localObject1 = this.f.d(paramcs.a);
        if (paramcs.b != 0) {
          break label300;
        }
        localObject2 = new StringBuilder();
        if (!this.e.a) {
          break label294;
        }
      }
      for (paramcs = "‏";; paramcs = "")
      {
        return paramcs + u.a().getString(2131296565, new Object[] { ((cs)localObject1).k() });
        i = ((abu)localObject1).a(paramcs, null);
        if (i != -1)
        {
          paramcs = new abu.b(paramcs, i);
          break label184;
        }
        paramcs = null;
        break label184;
        break;
      }
      if (paramcs.b != 1) {
        break;
      }
      localObject2 = new StringBuilder();
      if (this.e.a) {}
      for (paramcs = "‏";; paramcs = "") {
        return paramcs + u.a().getString(2131296566, new Object[] { ((cs)localObject1).k() });
      }
      i = this.c.a(paramcs.t, null);
      if (i == 0) {
        return u.a().getString(2131296561);
      }
      if (i != 1) {
        break;
      }
      return u.a().getString(2131296562);
    }
  }
  
  public final String b(cs paramcs)
  {
    String str = a(paramcs);
    if (str != null) {
      return str;
    }
    long l = this.c.a(paramcs.t);
    if (l == 0L) {
      return "";
    }
    if (l == 1L) {
      return u.a().getString(2131296560);
    }
    return paramcs.a(u.a(), this.b, new Object[0]) + " " + l.d(u.a(), this.b, this.a.a(l));
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/el.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */