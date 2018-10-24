package com.whatsapp.statusplayback.content;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.Window;
import com.whatsapp.PhotoView;
import com.whatsapp.data.e;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.util.ag;
import com.whatsapp.util.ag.a;

final class g
  extends c
{
  final a b;
  final PhotoView c;
  boolean d;
  private final ag e = ag.a();
  
  g(i parami)
  {
    super(parami);
    parami = this.a.k.z;
    long l = 4500L;
    if (e.b(this.a.k.f)) {
      l = 6750L;
    }
    while (this.a.k.e.b)
    {
      this.b = new a(l);
      this.c = new PhotoView(a())
      {
        public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
        {
          return super.onDoubleTap(paramAnonymousMotionEvent);
        }
        
        public final boolean onScaleBegin(ScaleGestureDetector paramAnonymousScaleGestureDetector)
        {
          g.this.a.c(true);
          g.this.a.f();
          g.this.d = true;
          return super.onScaleBegin(paramAnonymousScaleGestureDetector);
        }
        
        public final void onScaleEnd(ScaleGestureDetector paramAnonymousScaleGestureDetector)
        {
          super.onScaleEnd(paramAnonymousScaleGestureDetector);
        }
        
        public final boolean onTouchEvent(MotionEvent paramAnonymousMotionEvent)
        {
          int i = paramAnonymousMotionEvent.getActionMasked();
          if (((i == 1) && (paramAnonymousMotionEvent.getPointerCount() == 1)) || ((g.this.d) && (i == 3)))
          {
            g.this.d = false;
            g.this.a.j();
            g.this.a.g();
            a();
          }
          return super.onTouchEvent(paramAnonymousMotionEvent);
        }
      };
      this.c.setInitialFitTolerance(0.2F);
      this.c.a(true);
      this.c.setDoubleTapToZoomEnabled(false);
      this.c.setIsLongpressEnabled(false);
      return;
    }
    int i;
    if (TextUtils.isEmpty(parami))
    {
      i = 0;
      label138:
      if (i < 89) {
        break label171;
      }
    }
    label171:
    for (double d1 = 1.0D;; d1 = Math.sqrt(i / 89))
    {
      l = (d1 * 3000.0D + 4500.0D);
      break;
      i = com.whatsapp.emoji.c.c(parami);
      break label138;
    }
  }
  
  final boolean h()
  {
    return this.d;
  }
  
  public final void i()
  {
    this.b.a(0L);
    this.b.a();
    a(new h(this));
    c();
  }
  
  public final void j()
  {
    this.b.b();
  }
  
  final void k()
  {
    this.b.b();
  }
  
  final void l()
  {
    this.b.a();
  }
  
  final void m()
  {
    View localView = ((Activity)this.c.getContext()).getWindow().getDecorView();
    final int i = Math.max(localView.getWidth(), localView.getHeight());
    this.e.a(this.a.k, this.c, new ag.a()
    {
      public final int a()
      {
        return i;
      }
      
      public final void a(View paramAnonymousView)
      {
        g.this.c.c = null;
      }
      
      public final void a(View paramAnonymousView, Bitmap paramAnonymousBitmap, j paramAnonymousj)
      {
        g.this.c.a(paramAnonymousBitmap);
      }
    });
  }
  
  final void n() {}
  
  final View o()
  {
    return this.c;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/statusplayback/content/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */