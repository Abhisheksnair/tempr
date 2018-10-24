package com.whatsapp.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.f.f;
import android.util.SparseArray;
import com.whatsapp.gif_search.b;
import com.whatsapp.gif_search.q;
import com.whatsapp.u;
import com.whatsapp.util.Log;

public final class a
{
  private static final a f = new a(u.a());
  public final f<String, Bitmap> a;
  public final f<String, Bitmap> b = new f((int)(Runtime.getRuntime().maxMemory() / 8192L)) {};
  public final b c;
  public final b d;
  public final SparseArray<Bitmap> e = new SparseArray();
  
  private a(Context paramContext)
  {
    this.c = new b(256, paramContext, "gif/gif_cache_mem_store", "gif_preview_obj_store");
    this.a = new f((int)(Runtime.getRuntime().maxMemory() / 1024L / 6L)) {};
    this.d = new b(32, paramContext, "gif/gif_cache_mem_store", "gif_content_obj_store");
  }
  
  public static a a()
  {
    return f;
  }
  
  public final void b()
  {
    Runtime localRuntime = Runtime.getRuntime();
    Log.d("caches/state m=" + this.a.b() + "/" + this.a.c() + " c=" + this.b.b() + "/" + this.b.c() + " gp=" + this.c.a.b() + "/" + this.c.a.c() + " gc=" + this.d.a.b() + "/" + this.d.a.c() + " a=" + this.e.size() + " m=" + localRuntime.freeMemory() / 1024L + "/" + localRuntime.totalMemory() / 1024L + "/" + localRuntime.maxMemory() / 1024L);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */