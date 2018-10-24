package com.whatsapp.videoplayback;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import com.whatsapp.MediaData;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.vk;
import java.io.File;

public abstract class o
{
  public b c;
  public a d;
  public c e;
  
  public static o a(Context paramContext, j paramj)
  {
    MediaData localMediaData = paramj.b();
    if ((!paramj.e.b) && (localMediaData.transferring) && (localMediaData.downloader != null) && (localMediaData.downloader.g != null) && (Build.VERSION.SDK_INT >= 16)) {
      return new u(paramContext, paramj);
    }
    return a(paramContext, paramj.b().file.getAbsolutePath());
  }
  
  public static o a(Context paramContext, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return new z(paramContext, paramString);
    }
    return new w(paramContext, paramString);
  }
  
  public abstract View a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void b();
  
  final void b(String paramString, boolean paramBoolean)
  {
    if (this.c != null) {
      this.c.a(paramString, paramBoolean);
    }
  }
  
  public abstract void c();
  
  public abstract void d();
  
  public abstract void e();
  
  public abstract boolean f();
  
  public abstract boolean g();
  
  public abstract int h();
  
  public abstract int i();
  
  public final void v()
  {
    if (this.d != null) {
      this.d.a(this);
    }
  }
  
  final void w()
  {
    if (this.e != null) {
      this.e.a.c();
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(o paramo);
  }
  
  public static abstract interface b
  {
    public abstract void a(String paramString, boolean paramBoolean);
  }
  
  public static final class c
  {
    public final com.whatsapp.statusplayback.content.w a;
    
    public c(com.whatsapp.statusplayback.content.w paramw)
    {
      this.a = paramw;
    }
  }
  
  public static enum d
  {
    public static int[] a()
    {
      return (int[])c.clone();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/videoplayback/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */