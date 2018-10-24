package com.whatsapp.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public final class bf
{
  private static final bf b = new bf();
  private static final String[] c = { "biz.stachibana.TaskKiller", "cn.com.android.opda.taskman", "com.arron.taskManager", "com.arron.taskManagerFree", "com.bright.taskcleaner.activity", "com.cool.taskkiller", "com.elnware.ActiveAppsAds", "com.estrongs.android.taskmanager", "com.gau.go.launcherex.gowidget.taskmanagerex", "com.ijinshan.kbatterydoctor", "com.ijinshan.kbatterydoctor_en", "com.iobit.mobilecare", "com.james.SmartTaskManager", "com.james.SmartTaskManagerLite", "com.james.SmartTaskManagerPro", "com.latedroid.juicedefender", "com.latedroid.juicedefender.beta", "com.latedroid.juicedefender.plus", "com.latedroid.ultimatejuice", "com.latedroid.ultimatejuice.root", "com.lookout.zapper", "com.mobo.task.killer", "com.netqin.aotkiller", "com.netqin.mobileguard", "com.rechild.advancedtaskkiller", "com.rechild.advancedtaskkillerfroyo", "com.rechild.advancedtaskkillerpro", "com.rechild.cleaner", "com.rhythm.hexise.task", "com.sand.taskmanager", "com.sta_beers.auto_task", "com.symantec.monitor", "com.task.killer", "com.tni.TasKiller", "com.zdworks.android.toolbox", "com.zomut.watchdog", "com.zomut.watchdoglite", "gpc.myweb.hinet.net.TaskManager", "imoblife.memorybooster.lite", "jp.co.aplio.simpletaskkiller", "jp.co.aplio.simpletaskkillerfree", "jp.smapho.quicktaskkiller", "mobi.infolife.taskmanager", "mobi.infolife.taskmanagerpro", "net.lepeng.batterydoctor", "net.lepeng.superboxss" };
  private static final String[] d = { "com.agilesoftresource", "com.antivirus", "com.cleanmaster.mguard", "com.electricsheep.asi", "com.estrongs.android.pop", "com.estrongs.android.pop.cupcake", "com.metago.astro", "com.smartwho.SmartFileManager", "com.smartwho.SmartFileManagerPro", "nextapp.systempanel", "nextapp.systempanel.r1" };
  public c a;
  private final CountDownLatch e = new CountDownLatch(1);
  private final AtomicReference<b> f = new AtomicReference(new b(null, null));
  
  public static bf a()
  {
    return b;
  }
  
  private static Set<a> b(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (localPackageManager == null) {
      return null;
    }
    HashSet localHashSet = new HashSet();
    int j = paramArrayOfString.length;
    int i = 0;
    for (;;)
    {
      String str;
      if (i < j) {
        str = paramArrayOfString[i];
      }
      try
      {
        paramContext = localPackageManager.getApplicationInfo(str, 0);
        try
        {
          paramContext = paramContext.loadLabel(localPackageManager);
          Log.w(paramString + ' ' + str);
          localHashSet.add(new a(paramContext, str));
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            Log.e("exception during task-killer name lookup: " + paramContext);
            paramContext = str;
          }
        }
      }
      catch (RuntimeException paramContext)
      {
        Log.e(paramString + ' ' + paramContext.getMessage());
        break label176;
        if (localHashSet.isEmpty()) {
          break;
        }
        return localHashSet;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        label176:
        i += 1;
      }
    }
  }
  
  public final b a(int paramInt, TimeUnit paramTimeUnit)
  {
    Log.d("taskkillers/scan timeout=" + paramInt);
    b localb = this.a.a(paramInt, paramTimeUnit);
    StringBuilder localStringBuilder = new StringBuilder("taskkillers/scan results=");
    if (localb.a != null)
    {
      paramTimeUnit = Integer.valueOf(localb.a.size());
      localStringBuilder = localStringBuilder.append(paramTimeUnit).append(" ");
      if (localb.b == null) {
        break label117;
      }
    }
    label117:
    for (paramTimeUnit = Integer.valueOf(localb.b.size());; paramTimeUnit = "null")
    {
      Log.d(paramTimeUnit);
      return localb;
      paramTimeUnit = "null";
      break;
    }
  }
  
  public static final class a
  {
    public final CharSequence a;
    public final CharSequence b;
    
    public a(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
    {
      this.a = paramCharSequence1;
      this.b = paramCharSequence2;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass())) {
          return false;
        }
        paramObject = (a)paramObject;
      } while ((TextUtils.equals(this.a, ((a)paramObject).a)) && (TextUtils.equals(this.b, ((a)paramObject).b)));
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      if (this.a != null) {}
      for (int i = this.a.hashCode();; i = 0)
      {
        if (this.b != null) {
          j = this.b.hashCode();
        }
        return (i + 0) * 31 + j;
      }
    }
  }
  
  public static final class b
  {
    public final Set<bf.a> a;
    public final Set<bf.a> b;
    
    public b(Set<bf.a> paramSet1, Set<bf.a> paramSet2)
    {
      this.a = paramSet1;
      this.b = paramSet2;
    }
  }
  
  public final class c
    implements Runnable, Future<bf.b>
  {
    private final Context b;
    
    public c(Context paramContext)
    {
      this.b = paramContext;
    }
    
    public final bf.b a()
    {
      bf.b(bf.this).await();
      return (bf.b)bf.a(bf.this).get();
    }
    
    public final bf.b a(long paramLong, TimeUnit paramTimeUnit)
    {
      if (bf.b(bf.this).await(paramLong, paramTimeUnit)) {
        return (bf.b)bf.a(bf.this).get();
      }
      throw new TimeoutException();
    }
    
    public final boolean cancel(boolean paramBoolean)
    {
      return false;
    }
    
    public final boolean isCancelled()
    {
      return false;
    }
    
    public final boolean isDone()
    {
      return bf.b(bf.this).getCount() == 0L;
    }
    
    public final void run()
    {
      Set localSet2 = null;
      Set localSet1 = bf.a(this.b, bf.b(), "primary-task-killer");
      Set localSet3 = bf.a(this.b, bf.c(), "secondary-task-killer");
      AtomicReference localAtomicReference = bf.a(bf.this);
      if (localSet1 != null) {}
      for (localSet1 = Collections.unmodifiableSet(localSet1);; localSet1 = null)
      {
        if (localSet3 != null) {
          localSet2 = Collections.unmodifiableSet(localSet3);
        }
        localAtomicReference.set(new bf.b(localSet1, localSet2));
        bf.b(bf.this).countDown();
        return;
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */