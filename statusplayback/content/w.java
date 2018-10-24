package com.whatsapp.statusplayback.content;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.whatsapp.MediaData;
import com.whatsapp.PhotoView;
import com.whatsapp.aic;
import com.whatsapp.doodle.DoodleView;
import com.whatsapp.oz;
import com.whatsapp.protocol.j;
import com.whatsapp.statusplayback.StatusPlaybackProgressView.a;
import com.whatsapp.util.Log;
import com.whatsapp.util.ag;
import com.whatsapp.util.ag.a;
import com.whatsapp.videoplayback.o;
import com.whatsapp.videoplayback.o.c;
import java.io.File;

public class w
  extends c
{
  private final FrameLayout b;
  private final DoodleView c;
  private boolean d;
  private boolean e;
  private final oz f;
  final PhotoView g;
  o h;
  private final aic i;
  private final ag j;
  
  /* Error */
  w(i parami)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 36	com/whatsapp/statusplayback/content/c:<init>	(Lcom/whatsapp/statusplayback/content/i;)V
    //   5: aload_0
    //   6: invokestatic 41	com/whatsapp/oz:a	()Lcom/whatsapp/oz;
    //   9: putfield 43	com/whatsapp/statusplayback/content/w:f	Lcom/whatsapp/oz;
    //   12: aload_0
    //   13: invokestatic 48	com/whatsapp/aic:a	()Lcom/whatsapp/aic;
    //   16: putfield 50	com/whatsapp/statusplayback/content/w:i	Lcom/whatsapp/aic;
    //   19: aload_0
    //   20: invokestatic 55	com/whatsapp/util/ag:a	()Lcom/whatsapp/util/ag;
    //   23: putfield 57	com/whatsapp/statusplayback/content/w:j	Lcom/whatsapp/util/ag;
    //   26: aload_0
    //   27: new 59	android/widget/FrameLayout
    //   30: dup
    //   31: aload_0
    //   32: invokevirtual 62	com/whatsapp/statusplayback/content/w:a	()Landroid/content/Context;
    //   35: invokespecial 65	android/widget/FrameLayout:<init>	(Landroid/content/Context;)V
    //   38: putfield 67	com/whatsapp/statusplayback/content/w:b	Landroid/widget/FrameLayout;
    //   41: aload_0
    //   42: new 69	com/whatsapp/PhotoView
    //   45: dup
    //   46: aload_0
    //   47: invokevirtual 62	com/whatsapp/statusplayback/content/w:a	()Landroid/content/Context;
    //   50: invokespecial 70	com/whatsapp/PhotoView:<init>	(Landroid/content/Context;)V
    //   53: putfield 72	com/whatsapp/statusplayback/content/w:g	Lcom/whatsapp/PhotoView;
    //   56: aload_0
    //   57: getfield 72	com/whatsapp/statusplayback/content/w:g	Lcom/whatsapp/PhotoView;
    //   60: fconst_0
    //   61: invokevirtual 76	com/whatsapp/PhotoView:setInitialFitTolerance	(F)V
    //   64: aload_0
    //   65: getfield 72	com/whatsapp/statusplayback/content/w:g	Lcom/whatsapp/PhotoView;
    //   68: iconst_0
    //   69: invokevirtual 79	com/whatsapp/PhotoView:a	(Z)V
    //   72: aload_0
    //   73: getfield 72	com/whatsapp/statusplayback/content/w:g	Lcom/whatsapp/PhotoView;
    //   76: iconst_0
    //   77: invokevirtual 82	com/whatsapp/PhotoView:setDoubleTapToZoomEnabled	(Z)V
    //   80: aload_0
    //   81: getfield 72	com/whatsapp/statusplayback/content/w:g	Lcom/whatsapp/PhotoView;
    //   84: iconst_0
    //   85: invokevirtual 85	com/whatsapp/PhotoView:setEnabled	(Z)V
    //   88: aload_0
    //   89: getfield 67	com/whatsapp/statusplayback/content/w:b	Landroid/widget/FrameLayout;
    //   92: aload_0
    //   93: getfield 72	com/whatsapp/statusplayback/content/w:g	Lcom/whatsapp/PhotoView;
    //   96: invokevirtual 89	android/widget/FrameLayout:addView	(Landroid/view/View;)V
    //   99: aload_0
    //   100: invokevirtual 92	com/whatsapp/statusplayback/content/w:g	()Z
    //   103: ifeq +7 -> 110
    //   106: aload_0
    //   107: invokespecial 96	com/whatsapp/statusplayback/content/w:r	()V
    //   110: aload_0
    //   111: getfield 99	com/whatsapp/statusplayback/content/c:a	Lcom/whatsapp/statusplayback/content/i;
    //   114: getfield 105	com/whatsapp/statusplayback/content/i:k	Lcom/whatsapp/protocol/j;
    //   117: invokevirtual 110	com/whatsapp/protocol/j:b	()Lcom/whatsapp/MediaData;
    //   120: astore_1
    //   121: aload_0
    //   122: getfield 99	com/whatsapp/statusplayback/content/c:a	Lcom/whatsapp/statusplayback/content/i;
    //   125: getfield 105	com/whatsapp/statusplayback/content/i:k	Lcom/whatsapp/protocol/j;
    //   128: getfield 113	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   131: getfield 117	com/whatsapp/protocol/j$b:b	Z
    //   134: ifeq +161 -> 295
    //   137: aload_1
    //   138: getfield 122	com/whatsapp/MediaData:transferred	Z
    //   141: ifne +154 -> 295
    //   144: aload_1
    //   145: getfield 125	com/whatsapp/MediaData:transcoded	Z
    //   148: ifne +147 -> 295
    //   151: aload_1
    //   152: getfield 129	com/whatsapp/MediaData:doodleId	Ljava/lang/String;
    //   155: ifnull +140 -> 295
    //   158: aload_0
    //   159: getfield 43	com/whatsapp/statusplayback/content/w:f	Lcom/whatsapp/oz;
    //   162: aload_1
    //   163: getfield 129	com/whatsapp/MediaData:doodleId	Ljava/lang/String;
    //   166: invokestatic 134	com/whatsapp/util/MediaFileUtils:a	(Lcom/whatsapp/oz;Ljava/lang/String;)Ljava/io/File;
    //   169: astore_2
    //   170: aload_2
    //   171: invokevirtual 139	java/io/File:exists	()Z
    //   174: ifeq +121 -> 295
    //   177: new 141	com/whatsapp/doodle/a/b
    //   180: dup
    //   181: invokespecial 143	com/whatsapp/doodle/a/b:<init>	()V
    //   184: astore_1
    //   185: aload_1
    //   186: aload_2
    //   187: aload_0
    //   188: invokevirtual 62	com/whatsapp/statusplayback/content/w:a	()Landroid/content/Context;
    //   191: invokevirtual 146	com/whatsapp/doodle/a/b:a	(Ljava/io/File;Landroid/content/Context;)V
    //   194: new 148	com/whatsapp/doodle/DoodleView
    //   197: dup
    //   198: aload_0
    //   199: invokevirtual 62	com/whatsapp/statusplayback/content/w:a	()Landroid/content/Context;
    //   202: invokespecial 149	com/whatsapp/doodle/DoodleView:<init>	(Landroid/content/Context;)V
    //   205: astore_2
    //   206: aload_2
    //   207: iconst_1
    //   208: invokestatic 154	android/support/v4/view/ab:d	(Landroid/view/View;I)V
    //   211: aload_2
    //   212: iconst_0
    //   213: invokevirtual 155	com/whatsapp/doodle/DoodleView:setEnabled	(Z)V
    //   216: aload_2
    //   217: aload_1
    //   218: invokevirtual 159	com/whatsapp/doodle/DoodleView:setDoodle	(Lcom/whatsapp/doodle/a/b;)V
    //   221: aload_0
    //   222: getfield 67	com/whatsapp/statusplayback/content/w:b	Landroid/widget/FrameLayout;
    //   225: aload_2
    //   226: new 161	android/widget/FrameLayout$LayoutParams
    //   229: dup
    //   230: iconst_m1
    //   231: iconst_m1
    //   232: bipush 17
    //   234: invokespecial 164	android/widget/FrameLayout$LayoutParams:<init>	(III)V
    //   237: invokevirtual 167	android/widget/FrameLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   240: aload_0
    //   241: aload_2
    //   242: putfield 169	com/whatsapp/statusplayback/content/w:c	Lcom/whatsapp/doodle/DoodleView;
    //   245: return
    //   246: astore_1
    //   247: aconst_null
    //   248: astore_2
    //   249: new 171	java/lang/StringBuilder
    //   252: dup
    //   253: ldc -83
    //   255: invokespecial 176	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   258: aload_0
    //   259: getfield 99	com/whatsapp/statusplayback/content/c:a	Lcom/whatsapp/statusplayback/content/i;
    //   262: getfield 105	com/whatsapp/statusplayback/content/i:k	Lcom/whatsapp/protocol/j;
    //   265: getfield 113	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   268: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   271: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: aload_1
    //   275: invokestatic 189	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   278: goto -38 -> 240
    //   281: astore_1
    //   282: goto -33 -> 249
    //   285: astore_1
    //   286: aconst_null
    //   287: astore_2
    //   288: goto -39 -> 249
    //   291: astore_1
    //   292: goto -43 -> 249
    //   295: aconst_null
    //   296: astore_2
    //   297: goto -57 -> 240
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	300	0	this	w
    //   0	300	1	parami	i
    //   169	128	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   185	206	246	org/json/JSONException
    //   206	240	281	org/json/JSONException
    //   185	206	285	java/io/IOException
    //   206	240	291	java/io/IOException
  }
  
  private void r()
  {
    if (this.h == null)
    {
      MediaData localMediaData = this.a.k.b();
      if ((localMediaData.file != null) && (!localMediaData.file.exists())) {
        this.h = new a();
      }
    }
    else
    {
      return;
    }
    this.h = o.a(this.b.getContext(), this.a.k);
    this.h.c = new x(this);
    this.h.e = new o.c(this);
    this.h.a(this.d);
    this.h.a(0);
    q();
    this.b.addView(this.h.a(), 0, new FrameLayout.LayoutParams(-1, -1, 17));
  }
  
  private void s()
  {
    if (this.h != null)
    {
      this.h.d = null;
      this.h.e = null;
      this.h.c = null;
      this.b.removeView(this.h.a());
      this.h.d();
      this.h = null;
    }
  }
  
  void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
    if (this.h != null) {
      this.h.a(paramBoolean);
    }
    if ((!paramBoolean) && (!this.e))
    {
      e();
      this.e = true;
    }
  }
  
  void i()
  {
    this.g.setVisibility(0);
    r();
    if (this.h == null) {
      throw new IllegalStateException("video player is null for " + this.a.k.e);
    }
    this.h.a(0);
    this.h.b();
    if (this.c != null) {
      this.c.d();
    }
    a(p());
    if (!this.d)
    {
      e();
      this.e = true;
    }
  }
  
  void j()
  {
    if (this.h != null) {
      this.h.d();
    }
    if (this.c != null) {
      this.c.e();
    }
    f();
    this.e = false;
  }
  
  final void k()
  {
    if (this.h != null) {
      this.h.c();
    }
    if (this.c != null) {
      this.c.e();
    }
    f();
    this.e = false;
  }
  
  final void l()
  {
    if (this.h != null) {
      this.h.b();
    }
    for (;;)
    {
      if (this.c != null) {
        this.c.d();
      }
      if (!this.d)
      {
        e();
        this.e = true;
      }
      return;
      Log.w("statusplaybackvideo/no player for " + this.a.k.e);
    }
  }
  
  final void m()
  {
    if (g())
    {
      r();
      this.h.a().setVisibility(0);
      this.h.a().requestFocus();
    }
    for (;;)
    {
      if (this.g.getVisibility() == 0)
      {
        View localView = ((Activity)this.g.getContext()).getWindow().getDecorView();
        final int k = Math.max(localView.getWidth(), localView.getHeight());
        this.j.a(this.a.k, this.g, new ag.a()
        {
          public final int a()
          {
            return k;
          }
          
          public final void a(View paramAnonymousView)
          {
            w.this.g.c = null;
          }
          
          public final void a(View paramAnonymousView, Bitmap paramAnonymousBitmap, j paramAnonymousj)
          {
            w.this.g.a(paramAnonymousBitmap);
          }
        });
      }
      return;
      s();
      this.g.setVisibility(0);
    }
  }
  
  public final void n()
  {
    s();
    f();
  }
  
  final View o()
  {
    return this.b;
  }
  
  StatusPlaybackProgressView.a p()
  {
    new StatusPlaybackProgressView.a()
    {
      boolean a = true;
      
      public final float a()
      {
        float f1 = 0.0F;
        float f2 = 0.0F;
        if (w.this.h == null) {
          return f2;
        }
        boolean bool;
        if ((w.this.h.f()) || (w.this.a.n))
        {
          long l = w.this.h.i();
          if ((w.this.g.getVisibility() != 8) && (w.this.h.g()) && (w.this.h.a() != w.this.g)) {
            w.this.g.setVisibility(8);
          }
          if (!w.this.h.f())
          {
            bool = true;
            label130:
            this.a = bool;
            f1 = Math.min(100.0F, (float)l * 100.0F / (float)Math.min(aic.f(), w.this.h.h()));
          }
        }
        for (;;)
        {
          if (f1 < 100.0F)
          {
            f2 = f1;
            if (w.this.h.i() < aic.f()) {
              break;
            }
          }
          w.this.k();
          w.this.d();
          return f1;
          bool = false;
          break label130;
          if (!this.a) {
            f1 = 100.0F;
          }
        }
      }
    };
  }
  
  void q() {}
  
  final class a
    extends o
  {
    final a a = new a();
    private final Handler f = new Handler(Looper.getMainLooper(), y.a(this));
    
    a() {}
    
    public final View a()
    {
      return w.this.g;
    }
    
    public final void a(int paramInt)
    {
      this.a.a(paramInt);
      this.f.removeMessages(0);
      this.f.sendEmptyMessageDelayed(0, h() - i());
    }
    
    public final void a(boolean paramBoolean) {}
    
    public final void b()
    {
      this.a.a();
      this.f.removeMessages(0);
      this.f.sendEmptyMessageDelayed(0, h() - i());
    }
    
    public final void c()
    {
      this.a.b();
      this.f.removeMessages(0);
    }
    
    public final void d()
    {
      this.a.b();
      this.f.removeMessages(0);
    }
    
    public final void e() {}
    
    public final boolean f()
    {
      return this.a.a;
    }
    
    public final boolean g()
    {
      return true;
    }
    
    public final int h()
    {
      return (int)this.a.b;
    }
    
    public final int i()
    {
      return (int)this.a.c();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/statusplayback/content/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */