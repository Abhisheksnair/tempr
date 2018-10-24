package com.whatsapp.doodle;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextPaint;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.whatsapp.pv;
import java.util.ArrayList;

public final class a
{
  public DoodleView a;
  View b;
  public ColorPickerView c;
  public o d;
  t e;
  t f;
  t g;
  ImageView h;
  ImageView i;
  ImageView j;
  ImageView k;
  View l;
  View m;
  View n;
  b o;
  a p;
  Handler q = new Handler(Looper.getMainLooper());
  private FrameLayout r;
  private View s;
  private Activity t;
  private View u;
  private final pv v;
  
  public a(Activity paramActivity, pv parampv, View paramView, a parama)
  {
    this.t = paramActivity;
    this.v = parampv;
    this.u = paramView;
    this.p = parama;
    b(2131755714).setVisibility(0);
    com.whatsapp.doodle.a.e.i.b = paramActivity.getResources().getDimension(2131361985);
    com.whatsapp.doodle.a.e.i.c = paramActivity.getResources().getDimension(2131361987);
    com.whatsapp.doodle.a.e.i.d = paramActivity.getResources().getDimension(2131361984);
    com.whatsapp.doodle.a.e.i.e = paramActivity.getResources().getDimension(2131361986);
    com.whatsapp.doodle.a.e.i.f = paramActivity.getResources().getDimension(2131361983);
    com.whatsapp.doodle.a.e.i.g = paramActivity.getResources().getDimension(2131361982);
    this.a = ((DoodleView)b(2131755715));
    this.a.setPenMode(false);
    this.c = ((ColorPickerView)b(2131755721));
    this.a.a(this.c.getSize(), this.c.getColor());
    this.c.setListener(new ColorPickerView.a()
    {
      public final void a()
      {
        DoodleView localDoodleView = a.this.a;
        if ((localDoodleView.g != null) && (localDoodleView.g == localDoodleView.e))
        {
          localDoodleView.f.a(new u.d(localDoodleView.e, localDoodleView.h));
          localDoodleView.g = null;
          localDoodleView.h = null;
        }
        a.this.g();
      }
      
      public final void a(float paramAnonymousFloat, int paramAnonymousInt)
      {
        a.this.a.a(paramAnonymousFloat, paramAnonymousInt);
        a.this.g();
      }
    });
    this.e = new t(paramActivity, 2130840126);
    this.f = new t(paramActivity, 2130840127);
    this.g = new t(paramActivity, 2130840128);
    this.r = ((FrameLayout)b(2131755717));
    this.d = new o(paramActivity, (ShapePickerRecyclerView)b(2131755718), new o.g(this));
    this.d.a(this.c.getColor(), this.c.getMinSize());
    b(2131755719).setOnClickListener(d.a(this));
    this.n = b(2131755722);
    this.o = new b((byte)0);
    this.n.setBackgroundDrawable(this.o);
    this.b = b(2131755720);
    if (b(2131755438) != null) {
      a(paramView);
    }
  }
  
  private View b(int paramInt)
  {
    return this.u.findViewById(paramInt);
  }
  
  final void a()
  {
    this.p.c();
    d();
    DoodleView localDoodleView = this.a;
    boolean bool;
    if (!this.a.c)
    {
      bool = true;
      localDoodleView.setPenMode(bool);
      if (!this.a.c) {
        break label75;
      }
      e();
    }
    for (;;)
    {
      this.c.setColorPalette(1);
      this.a.setCurrentShape(null);
      g();
      return;
      bool = false;
      break;
      label75:
      f();
    }
  }
  
  public final void a(int paramInt)
  {
    DoodleView localDoodleView = this.a;
    localDoodleView.l = ((localDoodleView.l + paramInt) % 360);
    localDoodleView.a();
    localDoodleView.requestLayout();
    localDoodleView.p = false;
    localDoodleView.invalidate();
  }
  
  public final void a(RectF paramRectF)
  {
    this.a.setBitmapRect(paramRectF);
  }
  
  public final void a(final View paramView)
  {
    this.m = paramView.findViewById(2131755439);
    this.s = paramView.findViewById(2131755440);
    this.l = paramView.findViewById(2131755441);
    final View localView = this.l;
    if (this.a.c()) {}
    for (int i1 = 0;; i1 = 8)
    {
      localView.setVisibility(i1);
      this.l.setOnClickListener(e.a(this));
      this.l.setOnLongClickListener(f.a(this));
      this.h = ((ImageView)paramView.findViewById(2131755445));
      this.i = ((ImageView)paramView.findViewById(2131755443));
      this.j = ((ImageView)paramView.findViewById(2131755444));
      this.k = ((ImageView)paramView.findViewById(2131755442));
      this.h.setImageDrawable(this.e);
      this.i.setImageDrawable(this.f);
      this.j.setImageDrawable(this.g);
      localView = paramView.findViewById(2131755438);
      paramView = paramView.findViewById(2131755425);
      final Runnable localRunnable = g.a(this, localView, paramView);
      this.a.setListener(new DoodleView.a()
      {
        boolean a;
        
        private boolean b(float paramAnonymousFloat1, float paramAnonymousFloat2)
        {
          paramAnonymousFloat1 = a.this.a.getLeft() + paramAnonymousFloat1;
          paramAnonymousFloat2 = a.this.a.getTop() + paramAnonymousFloat2;
          return (paramAnonymousFloat1 >= a.this.n.getLeft()) && (paramAnonymousFloat1 <= a.this.n.getRight()) && (paramAnonymousFloat2 >= a.this.n.getTop()) && (paramAnonymousFloat2 <= a.this.n.getBottom());
        }
        
        public final void a()
        {
          a.this.q.removeCallbacks(localRunnable);
          Handler localHandler = a.this.q;
          Runnable localRunnable = localRunnable;
          if (a.this.a.c) {}
          for (long l = 1100L;; l = 600L)
          {
            localHandler.postDelayed(localRunnable, l);
            return;
          }
        }
        
        public final void a(float paramAnonymousFloat1, float paramAnonymousFloat2)
        {
          a.this.n.setVisibility(0);
          a.this.m.setVisibility(4);
          if (b(paramAnonymousFloat1, paramAnonymousFloat2))
          {
            if (!this.a) {
              a.this.o.a(-65536);
            }
            this.a = true;
            return;
          }
          if (this.a) {
            a.this.o.a(100663296);
          }
          this.a = false;
        }
        
        public final void a(com.whatsapp.doodle.a.e paramAnonymouse)
        {
          if ((paramAnonymouse.b()) || (paramAnonymouse.c()))
          {
            a.this.e();
            if (paramAnonymouse.c())
            {
              int i = paramAnonymouse.f.getColor();
              if (i != 0) {
                a.this.c.setColor(i);
              }
              a.this.c.setColorPalette(paramAnonymouse.h());
            }
            if (paramAnonymouse.b()) {
              a.this.c.setSize(paramAnonymouse.f() * a.this.a.getStrokeScale());
            }
            a.this.f.a(a.this.c.getSize(), a.this.c.getColor());
            a.this.e.a(a.this.c.getSize(), 0);
            a.this.g.a(a.this.c.getSize(), 0);
          }
          for (;;)
          {
            a.this.g();
            return;
            a.this.f();
          }
        }
        
        public final void a(com.whatsapp.doodle.a.e paramAnonymouse, float paramAnonymousFloat1, float paramAnonymousFloat2)
        {
          a.this.n.setVisibility(4);
          a.this.m.setVisibility(0);
          if (b(paramAnonymousFloat1, paramAnonymousFloat2))
          {
            a.this.a.a(paramAnonymouse);
            a.this.g();
          }
          a.this.o.a(100663296);
          this.a = false;
        }
        
        public final void b()
        {
          int i = 0;
          a.this.q.removeCallbacks(localRunnable);
          if (a.this.b.getVisibility() != 0)
          {
            a.this.b.setVisibility(0);
            localView.setVisibility(0);
            paramView.setVisibility(0);
            localObject = new AlphaAnimation(0.0F, 1.0F);
            ((Animation)localObject).setDuration(300L);
            a.this.b.startAnimation((Animation)localObject);
            localView.startAnimation((Animation)localObject);
            paramView.startAnimation((Animation)localObject);
            if (Build.VERSION.SDK_INT >= 11) {
              a.this.a.setSystemUiVisibility(1280);
            }
          }
          Object localObject = a.this.l;
          if (a.this.a.c()) {}
          for (;;)
          {
            ((View)localObject).setVisibility(i);
            a.this.p.b();
            return;
            i = 8;
          }
        }
        
        public final void b(com.whatsapp.doodle.a.e paramAnonymouse)
        {
          if ((paramAnonymouse instanceof com.whatsapp.doodle.a.i)) {
            a.this.a((com.whatsapp.doodle.a.i)paramAnonymouse);
          }
          a.this.p.a(paramAnonymouse);
        }
      });
      this.h.setOnClickListener(h.a(this));
      this.i.setOnClickListener(i.a(this));
      this.j.setOnClickListener(j.a(this));
      this.k.setOnClickListener(k.a(this));
      g();
      return;
    }
  }
  
  public final void a(com.whatsapp.doodle.a.b paramb)
  {
    this.a.setDoodle(paramb);
  }
  
  final void a(com.whatsapp.doodle.a.i parami)
  {
    boolean bool = false;
    this.p.c();
    d();
    this.a.setPenMode(false);
    this.q.postDelayed(b.a(this), 200L);
    this.f.a(0);
    this.g.a(this.c.getColor());
    this.e.a(0);
    Activity localActivity = this.t;
    Object localObject;
    int i1;
    label96:
    float f1;
    if (parami == null)
    {
      localObject = "";
      if (parami != null) {
        break label214;
      }
      i1 = this.c.getColor();
      if (parami != null) {
        break label225;
      }
      f1 = 0.0F;
      label102:
      if (parami != null) {
        break label236;
      }
    }
    label214:
    label225:
    label236:
    for (int i2 = 0;; i2 = parami.m)
    {
      localObject = new p(localActivity, (String)localObject, i1, f1, i2);
      ((p)localObject).h = this.c.getHeight();
      if (this.c.getVisibility() != 0) {
        bool = true;
      }
      ((p)localObject).i = bool;
      if (parami != null)
      {
        parami.g = true;
        this.a.invalidate();
      }
      ((p)localObject).show();
      ((p)localObject).g = new p.b(this);
      ((p)localObject).setOnDismissListener(c.a(this, parami, (p)localObject));
      return;
      localObject = parami.a;
      break;
      i1 = parami.f.getColor();
      break label96;
      f1 = parami.b.getTextSize();
      break label102;
    }
  }
  
  public final boolean a(float paramFloat1, float paramFloat2)
  {
    DoodleView localDoodleView = this.a;
    if (localDoodleView.i != null)
    {
      if (localDoodleView.c) {
        return true;
      }
      if (localDoodleView.g != null) {
        return true;
      }
      Object localObject = localDoodleView.a(paramFloat1, paramFloat2);
      paramFloat1 = ((PointF)localObject).x;
      paramFloat2 = ((PointF)localObject).y;
      int i1 = localDoodleView.a.size() - 1;
      while (i1 >= 0)
      {
        localObject = (com.whatsapp.doodle.a.e)localDoodleView.a.get(i1);
        if ((!(localObject instanceof com.whatsapp.doodle.a.d)) && (((com.whatsapp.doodle.a.e)localObject).a(paramFloat1, paramFloat2))) {
          return true;
        }
        i1 -= 1;
      }
    }
    return false;
  }
  
  final void b()
  {
    this.p.c();
    d();
    this.a.setPenMode(false);
    this.a.setCurrentShape(null);
    g();
    this.p.d();
  }
  
  public final void b(RectF paramRectF)
  {
    this.a.setCropRect(paramRectF);
  }
  
  final void c()
  {
    this.p.c();
    if (this.r.getVisibility() == 0)
    {
      d();
      return;
    }
    this.d.a(this.c.getColor(), this.c.getMinSize());
    this.r.setVisibility(0);
    this.c.setVisibility(4);
    this.a.setPenMode(false);
    g();
    this.p.a();
    this.f.a(this.c.getSize(), this.c.getColor());
  }
  
  final void d()
  {
    int i1 = 8;
    if (this.r.getVisibility() == 8) {
      return;
    }
    this.r.setVisibility(8);
    this.p.b();
    View localView = this.l;
    if (this.a.c()) {
      i1 = 0;
    }
    localView.setVisibility(i1);
    g();
  }
  
  final void e()
  {
    if (this.c.getVisibility() != 0)
    {
      this.c.setVisibility(0);
      if (!this.v.d()) {
        break label73;
      }
    }
    label73:
    for (float f1 = 1.0F;; f1 = -1.0F)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, f1, 1, 0.0F, 1, 0.0F, 1, 0.0F);
      localTranslateAnimation.setDuration(180L);
      localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
      this.c.startAnimation(localTranslateAnimation);
      return;
    }
  }
  
  final void f()
  {
    if (this.c.getVisibility() != 4)
    {
      this.c.setVisibility(4);
      if (!this.v.d()) {
        break label74;
      }
    }
    label74:
    for (float f1 = 1.0F;; f1 = -1.0F)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, f1, 1, 0.0F, 1, 0.0F);
      localTranslateAnimation.setDuration(180L);
      localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
      this.c.startAnimation(localTranslateAnimation);
      return;
    }
  }
  
  public final void g()
  {
    float f1 = this.c.getSize();
    int i1 = this.c.getColor();
    boolean bool2 = this.c.a;
    this.f.a = false;
    this.e.a = false;
    if (this.a.c)
    {
      this.f.a(f1, 0);
      this.g.a(f1, 0);
      this.e.a(f1, i1);
      this.e.a = bool2;
      e();
      if (this.r.getVisibility() != 0) {
        break label448;
      }
      if (Build.VERSION.SDK_INT >= 11)
      {
        this.h.setAlpha(0.5F);
        this.j.setAlpha(0.5F);
        this.k.setAlpha(0.5F);
        this.m.setAlpha(0.5F);
        this.s.setAlpha(0.5F);
      }
      this.f.a(f1, i1);
      this.f.a = bool2;
      this.g.a(f1, 0);
      this.e.a(f1, 0);
      this.l.setVisibility(4);
      this.c.clearAnimation();
      this.c.setVisibility(4);
      if ((!this.a.c) && (!this.a.b()) && (!this.a.c())) {
        break label528;
      }
      if (this.a.getVisibility() != 0)
      {
        this.a.setVisibility(0);
        this.p.e();
      }
    }
    label448:
    label528:
    while (this.a.getVisibility() == 4)
    {
      return;
      Object localObject = this.a.getCurrentShape();
      if ((localObject instanceof com.whatsapp.doodle.a.i))
      {
        this.f.a(f1, 0);
        this.g.a(f1, i1);
        this.e.a(f1, 0);
        e();
        break;
      }
      if ((localObject != null) && ((((com.whatsapp.doodle.a.e)localObject).b()) || (((com.whatsapp.doodle.a.e)localObject).c())))
      {
        this.f.a(f1, i1);
        t localt = this.f;
        if ((bool2) && (((com.whatsapp.doodle.a.e)localObject).b())) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          localt.a = bool1;
          this.g.a(f1, 0);
          this.e.a(f1, 0);
          e();
          break;
        }
      }
      this.f.a(f1, 0);
      this.g.a(f1, 0);
      this.e.a(f1, 0);
      f();
      break;
      if (Build.VERSION.SDK_INT >= 11)
      {
        this.h.setAlpha(1.0F);
        this.j.setAlpha(1.0F);
        this.k.setAlpha(1.0F);
        this.m.setAlpha(1.0F);
        this.s.setAlpha(1.0F);
      }
      localObject = this.l;
      if (this.a.c()) {}
      for (i1 = 0;; i1 = 4)
      {
        ((View)localObject).setVisibility(i1);
        break;
      }
    }
    this.a.setVisibility(4);
    this.p.f();
  }
  
  public final boolean h()
  {
    if (this.r.getVisibility() == 0)
    {
      d();
      return true;
    }
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(com.whatsapp.doodle.a.e parame);
    
    public abstract void b();
    
    public abstract void c();
    
    public abstract void d();
    
    public abstract void e();
    
    public abstract void f();
  }
  
  static final class b
    extends Drawable
  {
    private final Paint a = new Paint(1);
    private int b = 100663296;
    
    public final void a(int paramInt)
    {
      this.b = paramInt;
      invalidateSelf();
    }
    
    public final void draw(Canvas paramCanvas)
    {
      this.a.setStyle(Paint.Style.FILL);
      this.a.setColor(this.b);
      Rect localRect = getBounds();
      paramCanvas.drawCircle(0.0F, 0.0F, Math.min(localRect.width(), localRect.height()), this.a);
    }
    
    public final int getOpacity()
    {
      return -3;
    }
    
    public final void setAlpha(int paramInt) {}
    
    public final void setColorFilter(ColorFilter paramColorFilter) {}
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/doodle/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */