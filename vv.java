package com.whatsapp;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import com.whatsapp.data.v;
import com.whatsapp.gdrive.SettingsGoogleDrive;
import com.whatsapp.util.Log;
import com.whatsapp.util.a.c;
import com.whatsapp.util.bk;
import com.whatsapp.util.bu;
import com.whatsapp.util.e;
import java.io.File;

public class vv
{
  private static volatile vv e;
  boolean a;
  boolean b;
  public final bk c;
  public final bk d;
  private final c f;
  private final atu g;
  private boolean h;
  
  private vv(Context paramContext, c paramc, ox paramox, atu paramatu)
  {
    this.f = paramc;
    this.g = paramatu;
    this.c = new bk(this, new File(paramox.a, ".trash"));
    this.d = new bk(this, new File(paramContext.getFilesDir(), ".trash"));
    paramContext = Environment.getExternalStorageState();
    if ("mounted".equals(paramContext))
    {
      this.a = false;
      this.b = false;
      return;
    }
    if ("mounted_ro".equals(paramContext))
    {
      this.a = false;
      this.b = true;
      Log.i("media-state-manager/main/media/read-only");
      return;
    }
    this.a = true;
    this.b = false;
    Log.i("media-state-manager/main/media/unavailable " + paramContext);
  }
  
  static long a(StatFs paramStatFs)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return paramStatFs.getBlockCountLong() * paramStatFs.getBlockSizeLong();
    }
    return paramStatFs.getBlockCount() * paramStatFs.getBlockSize();
  }
  
  public static vv a()
  {
    if (e == null) {}
    try
    {
      if (e == null) {
        e = new vv(u.a(), c.a(), ox.a(), atu.a());
      }
      return e;
    }
    finally {}
  }
  
  private static long b(StatFs paramStatFs)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return paramStatFs.getAvailableBlocksLong() * paramStatFs.getBlockSizeLong();
    }
    return paramStatFs.getAvailableBlocks() * paramStatFs.getBlockSize();
  }
  
  public static long e()
  {
    return b(new StatFs(Environment.getDataDirectory().getPath()));
  }
  
  public static long f()
  {
    try
    {
      long l = b(new StatFs(Environment.getExternalStorageDirectory().getPath()));
      return l;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      Log.c("media-state-manager/avail-external-storage/error/illegal-arg", localIllegalArgumentException);
    }
    return 0L;
  }
  
  public static long g()
  {
    try
    {
      long l = a(new StatFs(Environment.getExternalStorageDirectory().getPath()));
      return l;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      Log.c("media-state-manager/total-external-storage/error/illegal-arg", localIllegalArgumentException);
    }
    return 0L;
  }
  
  public static int h()
  {
    if (i()) {
      return 2131296822;
    }
    return 2131296823;
  }
  
  public static boolean i()
  {
    try
    {
      boolean bool = Environment.isExternalStorageRemovable();
      return bool;
    }
    catch (Exception localException)
    {
      Log.w("media-state-manager/checkifremovable/error " + localException);
    }
    return true;
  }
  
  public final e a(File paramFile)
  {
    return new e(this.d, paramFile);
  }
  
  public final boolean a(a parama)
  {
    String str = Environment.getExternalStorageState();
    if ("mounted_ro".equals(str))
    {
      parama.a();
      return false;
    }
    if (!"mounted".equals(str))
    {
      parama.b();
      return false;
    }
    if (this.g.a("android.permission.WRITE_EXTERNAL_STORAGE") == -1)
    {
      parama.d();
      return false;
    }
    return true;
  }
  
  public final File b()
  {
    return this.c.a("");
  }
  
  public final boolean b(a parama)
  {
    String str = Environment.getExternalStorageState();
    if ((!"mounted".equals(str)) && (!"mounted_ro".equals(str)))
    {
      parama.b();
      return false;
    }
    if ((Build.VERSION.SDK_INT >= 23) && (this.g.a("android.permission.READ_EXTERNAL_STORAGE") == -1))
    {
      parama.c();
      return false;
    }
    return true;
  }
  
  public final boolean c()
  {
    return (this.a) || (this.b);
  }
  
  public final void d()
  {
    if (this.a) {
      return;
    }
    if (!this.b) {
      oz.a().j();
    }
    if ((!this.b) && (!this.h))
    {
      this.h = true;
      Log.i("media-state-manager/refresh-media-state/writable-media");
      if ((this.f.e) && (av.m())) {
        this.f.a(true, false, false, true, null, null, null);
      }
      this.c.b();
    }
    SettingsChat.a(pv.a());
    SettingsGoogleDrive.s();
    if (v.a().b())
    {
      Log.d("media-state-manager/refresh-media-state/deferredbackup");
      v.a().a(false);
    }
    bu.a(vw.a(this));
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void b();
    
    public abstract void c();
    
    public abstract void d();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/vv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */