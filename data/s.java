package com.whatsapp.data;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.whatsapp.hx;
import com.whatsapp.lt;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.qz;
import com.whatsapp.util.Log;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class s
{
  private static volatile s f;
  final ac a;
  final lt b;
  final Handler c;
  public final Handler d;
  public final Handler e;
  
  private s(final d paramd, final ac paramac, final lt paramlt)
  {
    this.a = paramac;
    this.b = paramlt;
    this.c = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        j localj = (j)paramAnonymousMessage.obj;
        switch (paramAnonymousMessage.what)
        {
        default: 
          return;
        case 3: 
          Log.d("msgstore/addhandler/duplicate");
          paramac.a(localj);
          return;
        case 4: 
          Log.d("msgstore/addhandler/chatadded");
          paramlt.a(Collections.singletonList(localj.e.a));
          paramac.b(localj, paramAnonymousMessage.arg1);
          return;
        case 5: 
          Log.d("msgstore/addhandler/chatchanged");
          paramac.b(localj, paramAnonymousMessage.arg1);
          paramlt.a(localj.e.a);
          return;
        case 6: 
          Log.d("msgstore/addhandler/unarchived");
          paramlt.b();
          return;
        }
        Log.d("msgstore/addhandler/offline-completed");
        paramac.b();
      }
    };
    this.d = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        boolean bool = true;
        j localj = (j)paramAnonymousMessage.obj;
        switch (paramAnonymousMessage.what)
        {
        default: 
          return;
        case 2: 
          s.this.a(localj, paramAnonymousMessage.arg1);
          return;
        case 11: 
          paramac.b(localj);
          return;
        }
        Log.d("msgstore/updatehandler/newurl");
        ac localac = paramac;
        if (paramAnonymousMessage.arg1 == 1) {}
        for (;;)
        {
          localac.a(localj, bool);
          return;
          bool = false;
        }
      }
    };
    this.e = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        String str;
        Object localObject;
        switch (paramAnonymousMessage.what)
        {
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        default: 
          return;
        case 1: 
          paramAnonymousMessage = (String)paramAnonymousMessage.obj;
          paramlt.a(paramAnonymousMessage);
          return;
        case 2: 
          paramAnonymousMessage = (String)paramAnonymousMessage.obj;
          paramac.a(paramAnonymousMessage);
          paramlt.a(paramAnonymousMessage);
          return;
        case 8: 
          paramAnonymousMessage = paramd.a.keys();
          while (paramAnonymousMessage.hasMoreElements())
          {
            str = (String)paramAnonymousMessage.nextElement();
            localObject = (ad.d)paramd.a.get(str);
            if (localObject != null) {
              ((ad.d)localObject).a();
            }
            paramac.a(str);
            paramlt.a(str);
          }
        }
        paramAnonymousMessage = paramd.a.keySet().iterator();
        label187:
        if (paramAnonymousMessage.hasNext())
        {
          str = (String)paramAnonymousMessage.next();
          if (qz.e(str)) {
            break label254;
          }
          paramd.a.remove(str);
          localObject = paramlt;
          ((lt)localObject).c(str);
          ((lt)localObject).d.b();
        }
        for (;;)
        {
          paramac.a(str);
          break label187;
          break;
          label254:
          localObject = (ad.d)paramd.a.get(str);
          if (localObject != null) {
            ((ad.d)localObject).a();
          }
          paramlt.a(str);
        }
      }
    };
  }
  
  public static s a()
  {
    if (f == null) {}
    try
    {
      if (f == null) {
        f = new s(d.a(), ac.a(), lt.a());
      }
      return f;
    }
    finally {}
  }
  
  public final void a(j paramj, int paramInt)
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.d.post(t.a(this, paramj, paramInt));
      return;
    }
    this.a.c(paramj, paramInt);
    this.b.a(paramj.e.a);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/data/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */