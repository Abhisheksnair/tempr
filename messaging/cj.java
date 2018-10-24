package com.whatsapp.messaging;

import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import com.whatsapp.av;
import com.whatsapp.fieldstats.events.j;
import com.whatsapp.fieldstats.l;
import com.whatsapp.k.h;
import com.whatsapp.u;

public final class cj
{
  public static final h a = new h(2000, -1);
  public static final h b = new h(20, -1);
  
  static void a(Message paramMessage)
  {
    if (!av.k()) {
      return;
    }
    a("send", paramMessage);
  }
  
  private static void a(String paramString, Message paramMessage)
  {
    Object localObject = g(paramMessage);
    int i;
    if ((!paramString.equals("send")) || (((Bundle)localObject).getBoolean("was_previously_queued")))
    {
      i = 1;
      if (i == 0) {
        break label157;
      }
    }
    label157:
    for (localObject = b;; localObject = a)
    {
      if (((h)localObject).a(1))
      {
        i = paramMessage.arg1;
        paramMessage = g(paramMessage);
        j localj = new j();
        localj.b = Boolean.valueOf(paramMessage.getBoolean("was_previously_queued"));
        localj.c = Boolean.valueOf(paramMessage.getBoolean("error_in_flight"));
        localj.d = paramString;
        localj.e = Long.valueOf(SystemClock.elapsedRealtime() - paramMessage.getLong("arrive_time", 0L));
        localj.f = Long.valueOf(paramMessage.getInt("queue_count"));
        localj.a = Long.valueOf(i);
        l.a(u.a(), localj, ((h)localObject).b(1));
      }
      return;
      i = 0;
      break;
    }
  }
  
  static void b(Message paramMessage)
  {
    if (!av.k()) {
      return;
    }
    Bundle localBundle = g(paramMessage);
    if (!localBundle.containsKey("was_previously_queued"))
    {
      a("queue", paramMessage);
      localBundle.putBoolean("was_previously_queued", true);
    }
    localBundle.putInt("queue_count", localBundle.getInt("queue_count", 0) + 1);
  }
  
  static void c(Message paramMessage)
  {
    if (!av.k()) {
      return;
    }
    a("dropped", paramMessage);
  }
  
  static void d(Message paramMessage)
  {
    if (!av.k()) {
      return;
    }
    a("failure", paramMessage);
  }
  
  static void e(Message paramMessage)
  {
    if (!av.k()) {}
    do
    {
      return;
      paramMessage = g(paramMessage);
    } while (paramMessage.containsKey("error_in_flight"));
    paramMessage.putBoolean("error_in_flight", true);
  }
  
  static void f(Message paramMessage)
  {
    if (!av.k()) {}
    do
    {
      return;
      paramMessage = g(paramMessage);
    } while (paramMessage.containsKey("arrive_time"));
    paramMessage.putLong("arrive_time", SystemClock.elapsedRealtime());
  }
  
  private static Bundle g(Message paramMessage)
  {
    Bundle localBundle2 = paramMessage.getData().getBundle("xmpp_logger_data");
    Bundle localBundle1 = localBundle2;
    if (localBundle2 == null)
    {
      localBundle1 = new Bundle();
      paramMessage.getData().putBundle("xmpp_logger_data", localBundle1);
    }
    return localBundle1;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/messaging/cj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */