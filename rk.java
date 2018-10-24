package com.whatsapp;

import a.a.a.a.d;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.whatsapp.messaging.m;
import java.util.HashMap;

public class rk
{
  public static volatile rk a;
  public final Handler b = new Handler(Looper.getMainLooper())
  {
    private final HashMap<String, Long> b = new HashMap();
    
    private void a(String paramAnonymousString, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
    {
      if ((!hasMessages(0, paramAnonymousString)) && (!hasMessages(3, paramAnonymousString)))
      {
        if ((!hasMessages(2, paramAnonymousString)) && (rk.a(rk.this).d) && (paramAnonymousBoolean1) && ((paramAnonymousBoolean2) || (hasMessages(5, paramAnonymousString)))) {
          rk.a(rk.this).a(d.j(paramAnonymousString));
        }
        removeMessages(4, paramAnonymousString);
        removeMessages(5, paramAnonymousString);
      }
    }
    
    public final void handleMessage(Message paramAnonymousMessage)
    {
      boolean bool1 = false;
      int k = 1;
      boolean bool2 = true;
      int j = 1;
      int i;
      switch (paramAnonymousMessage.what)
      {
      default: 
      case 0: 
      case 3: 
        do
        {
          do
          {
            return;
            str = (String)paramAnonymousMessage.obj;
            if (paramAnonymousMessage.arg1 != 1) {
              break;
            }
            i = 1;
            k = paramAnonymousMessage.arg2;
          } while ((hasMessages(1, str)) || (hasMessages(4, str)));
          removeMessages(0, str);
          if ((!hasMessages(2, str)) && (!hasMessages(5, str)))
          {
            if (rk.a(rk.this).d)
            {
              if (i != 0) {
                rk.a(rk.this).a(d.a(str, k));
              }
              this.b.put(str, Long.valueOf(System.currentTimeMillis()));
            }
            removeMessages(2, str);
            if (i == 0) {
              break label299;
            }
          }
          for (i = j;; i = 0)
          {
            sendMessageDelayed(obtainMessage(2, i, 0, str), 2500L);
            return;
            i = 0;
            break;
            paramAnonymousMessage = (Long)this.b.get(str);
            long l = System.currentTimeMillis();
            if ((paramAnonymousMessage == null) || (l - paramAnonymousMessage.longValue() <= 10000L) || (!rk.a(rk.this).d)) {
              break label175;
            }
            if (i != 0) {
              rk.a(rk.this).a(d.a(str, k));
            }
            this.b.put(str, Long.valueOf(l));
            break label175;
          }
          str = (String)paramAnonymousMessage.obj;
          if (paramAnonymousMessage.arg1 != 1) {
            break;
          }
          i = 1;
          j = paramAnonymousMessage.arg2;
        } while ((hasMessages(1, str)) || (hasMessages(4, str)));
        if ((!hasMessages(2, str)) && (rk.a(rk.this).d) && (i != 0)) {
          rk.a(rk.this).a(d.a(str, j));
        }
        if (i != 0) {}
        for (i = k;; i = 0)
        {
          sendMessageDelayed(obtainMessage(5, i, 0, str), 30000L);
          return;
          i = 0;
          break;
        }
      case 1: 
      case 2: 
        str = (String)paramAnonymousMessage.obj;
        if (paramAnonymousMessage.arg1 == 1) {}
        for (i = 1; (!hasMessages(0, str)) && (!hasMessages(3, str)); i = 0)
        {
          if ((!hasMessages(5, str)) && (rk.a(rk.this).d) && (i != 0)) {
            rk.a(rk.this).a(d.j(str));
          }
          removeMessages(1, str);
          removeMessages(2, str);
          return;
        }
      case 4: 
        label175:
        label299:
        str = (String)paramAnonymousMessage.obj;
        if (paramAnonymousMessage.arg1 == 1) {}
        for (bool1 = bool2;; bool1 = false)
        {
          a(str, bool1, false);
          return;
        }
      }
      String str = (String)paramAnonymousMessage.obj;
      if (paramAnonymousMessage.arg1 == 1) {
        bool1 = true;
      }
      a(str, bool1, true);
    }
  };
  private final HashMap<String, String> c = new HashMap();
  private final m d;
  
  private rk(m paramm)
  {
    this.d = paramm;
  }
  
  public static rk a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new rk(m.a());
      }
      return a;
    }
    finally {}
  }
  
  final String a(String paramString)
  {
    String str = (String)this.c.get(paramString);
    if (str != null) {
      return str;
    }
    this.c.put(paramString, paramString);
    return paramString;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/rk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */