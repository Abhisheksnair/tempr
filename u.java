package com.whatsapp;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Debug;
import android.os.StatFs;
import android.support.v7.app.e;
import com.facebook.buck.android.support.exopackage.DefaultApplicationLike;
import com.whatsapp.g.i;
import com.whatsapp.g.j;
import com.whatsapp.g.o;
import com.whatsapp.memory.dump.b;
import com.whatsapp.util.Log;
import com.whatsapp.util.bu;
import com.whatsapp.util.x;
import java.io.File;
import java.io.IOException;
import java.security.Security;
import org.spongycastle.jce.provider.BouncyCastleProvider;

public final class u
  extends DefaultApplicationLike
{
  public static com.whatsapp.j.a.a a;
  public static u c;
  private static boolean d;
  public final za b;
  private final pv e;
  private final aus f;
  private final Application g;
  
  static
  {
    Security.insertProviderAt(new BouncyCastleProvider(), 1);
    e.k();
    Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
    {
      private final Thread.UncaughtExceptionHandler a = Thread.getDefaultUncaughtExceptionHandler();
      
      public final void uncaughtException(Thread paramAnonymousThread, Throwable paramAnonymousThrowable)
      {
        int j = 1;
        ??? = com.whatsapp.util.a.c.a();
        Thread.UncaughtExceptionHandler localUncaughtExceptionHandler = this.a;
        int i;
        for (;;)
        {
          try
          {
            Log.d("UNCAUGHT EXCEPTION", paramAnonymousThrowable);
          }
          catch (Exception localException2)
          {
            com.whatsapp.memory.dump.d locald;
            label141:
            label146:
            localObject2 = paramAnonymousThrowable;
            if (!(paramAnonymousThrowable instanceof com.whatsapp.protocol.r)) {
              continue;
            }
            paramAnonymousThrowable = (com.whatsapp.protocol.r)paramAnonymousThrowable;
            Log.d(paramAnonymousThrowable.getMessage(), paramAnonymousThrowable.b);
            localObject2 = paramAnonymousThrowable.b;
            Log.h();
            localUncaughtExceptionHandler.uncaughtException(paramAnonymousThread, (Throwable)localObject2);
            return;
            localThrowable2 = ((Throwable)localObject2).getCause();
            localObject2 = localThrowable2;
            if (localThrowable2 != null) {
              continue;
            }
            i = 0;
            continue;
            localObject2 = locald.d;
            l = Runtime.getRuntime().maxMemory();
            localObject2 = new StatFs(((b)localObject2).a());
            if (((StatFs)localObject2).getBlockSize() * ((StatFs)localObject2).getAvailableBlocks() <= l * 3L) {
              break label505;
            }
            i = 1;
            if (i == 0) {
              break label520;
            }
            if (com.whatsapp.memory.a.b()) {
              break label510;
            }
            i = 1;
            if (i == 0) {
              break label520;
            }
            localObject2 = locald.d.a(locald.d.a());
            if ((localObject2 == null) || (localObject2.length <= 0)) {
              break label515;
            }
            i = 1;
            if (i != 0) {
              break label520;
            }
            bool = r.a(locald.b, locald.c);
            if (bool) {
              break label520;
            }
            i = j;
            if (i == 0) {
              break label525;
            }
            try
            {
              Debug.dumpHprofData(String.format("%s/dump.hprof", new Object[] { locald.d.a() }));
              Log.i("OOMHandler/dump successful");
            }
            catch (IOException localIOException)
            {
              Log.c("OOMHandler/IOException trying to write dump", paramAnonymousThrowable);
            }
            continue;
          }
          finally
          {
            localThrowable1 = paramAnonymousThrowable;
            if (!(paramAnonymousThrowable instanceof com.whatsapp.protocol.r)) {
              continue;
            }
            paramAnonymousThrowable = (com.whatsapp.protocol.r)paramAnonymousThrowable;
            Log.d(paramAnonymousThrowable.getMessage(), paramAnonymousThrowable.b);
            localThrowable1 = paramAnonymousThrowable.b;
            Log.h();
            localUncaughtExceptionHandler.uncaughtException(paramAnonymousThread, localThrowable1);
          }
          try
          {
            ((com.whatsapp.util.a.c)???).c.createNewFile();
          }
          catch (Exception localException1)
          {
            Log.d("Unable to create crash sentinel file", localException1);
          }
        }
        synchronized (com.whatsapp.util.a.c.g)
        {
          Log.i("exception/done-waiting");
          locald = new com.whatsapp.memory.dump.d(u.a(), ahc.a(), and.a(), atu.a());
          ??? = paramAnonymousThrowable;
          if ((??? instanceof OutOfMemoryError))
          {
            i = 1;
            if (i != 0)
            {
              Log.i("WhatsAppWorkers state: " + bu.a());
              if (av.f()) {
                break label537;
              }
              if (!av.i()) {
                break label549;
              }
              break label537;
              if (i != 0)
              {
                if (md.a(locald.a) <= 10) {
                  break label554;
                }
                i = 1;
                break label542;
              }
              Log.i("OOMHandler/hprof dump not allowed");
            }
            ??? = paramAnonymousThrowable;
            if ((paramAnonymousThrowable instanceof com.whatsapp.protocol.r))
            {
              paramAnonymousThrowable = (com.whatsapp.protocol.r)paramAnonymousThrowable;
              Log.d(paramAnonymousThrowable.getMessage(), paramAnonymousThrowable.b);
              ??? = paramAnonymousThrowable.b;
            }
            Log.h();
            localUncaughtExceptionHandler.uncaughtException(paramAnonymousThread, (Throwable)???);
          }
        }
        label505:
        label510:
        label515:
        label520:
        label525:
        label537:
        label542:
        label549:
        label554:
        label557:
        for (;;)
        {
          Object localObject2;
          Throwable localThrowable2;
          long l;
          boolean bool;
          Throwable localThrowable1;
          i = 0;
          continue;
          i = 0;
          continue;
          i = 0;
          continue;
          i = 0;
          continue;
          Log.i("OOMHandler/hprof dump conditions not met");
          a.a.a.a.d.e(2);
          break label146;
          i = 1;
          break;
          for (;;)
          {
            if (i == 0) {
              break label557;
            }
            break label141;
            i = 0;
            break;
            i = 0;
          }
        }
      }
    });
  }
  
  public u(Application paramApplication)
  {
    if (c == null) {
      c = this;
    }
    this.g = paramApplication;
    paramApplication = b.a.a.c.a();
    paramApplication.c(new j());
    paramApplication.c(new i(false));
    paramApplication.c(new o(false));
    this.e = pv.a();
    this.f = aus.a();
    this.b = za.a();
  }
  
  public static Context a()
  {
    return c.g;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.f.e();
    this.e.e();
    aoa.c();
    x.a();
  }
  
  @SuppressLint({"HardwareIds"})
  public final void onCreate()
  {
    super.onCreate();
    if (d)
    {
      Log.w("Application onCreate called after application already started");
      return;
    }
    d = true;
    v.a(this.g);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */