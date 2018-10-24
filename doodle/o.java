package com.whatsapp.doodle;

import a.a.a.a.a.a.d;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.p;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.whatsapp.doodle.a.c;
import com.whatsapp.doodle.a.e;
import com.whatsapp.doodle.a.e.a;
import com.whatsapp.doodle.a.f;
import com.whatsapp.doodle.a.g;
import com.whatsapp.doodle.a.h;
import com.whatsapp.doodle.a.j;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public final class o
{
  static d[] a;
  public HandlerThread b;
  public i c;
  public final ConcurrentHashMap<Integer, SoftReference<Drawable>> d = new ConcurrentHashMap();
  private Context e;
  private g f;
  private h g;
  private float h;
  private int i;
  private j j;
  private final ConcurrentHashMap<Integer, SoftReference<e>> k = new ConcurrentHashMap();
  
  static
  {
    boolean bool = true;
    a locala = new a();
    c localc = new c();
    n localn = new n();
    k localk = new k();
    l locall = new l();
    m localm1 = a("e022");
    m localm2 = a("e11c");
    m localm3 = a("e04f");
    m localm4 = a("e335");
    m localm5 = a("e41c");
    m localm6 = a("e05a");
    m localm7 = a("e04e");
    m localm8 = a("e003");
    m localm9 = a("e002");
    m localm10 = a("e001");
    m localm11 = a("e11b");
    m localm12 = a("1f631");
    localm12.b = 2;
    m localm13 = a("1f910");
    localm13.b = 2;
    m localm14 = a("1f911");
    localm14.b = 2;
    m localm15 = a("1f600");
    localm15.b = 2;
    m localm16 = a("1f62c");
    localm16.b = 2;
    m localm17 = a("1f60d");
    localm17.b = 2;
    m localm18 = a("1f618");
    localm18.b = 2;
    m localm19 = a("1f60f");
    localm19.b = 2;
    m localm20 = a("1f636");
    localm20.b = 2;
    m localm21 = a("1f644");
    localm21.b = 2;
    m localm22 = a("1f624");
    localm22.b = 2;
    m localm23 = a("1f621");
    m localm24 = a("1f60a");
    localm24.b = 2;
    m localm25 = a("1f60b");
    localm25.b = 2;
    m localm26 = a("1f60c");
    localm26.b = 2;
    m localm27 = a("1f60e");
    localm27.b = 2;
    m localm28 = a("1f61a");
    localm28.b = 2;
    m localm29 = a("1f61b");
    localm29.b = 2;
    m localm30 = a("1f61c");
    localm30.b = 2;
    m localm31 = a("1f61d");
    localm31.b = 2;
    m localm32 = a("1f61e");
    localm32.b = 2;
    m localm33 = a("1f61f");
    localm33.b = 2;
    m localm34 = a("1f62a");
    localm34.b = 2;
    m localm35 = a("1f62b");
    localm35.b = 2;
    m localm36 = a("1f62d");
    localm36.b = 2;
    m localm37 = a("1f62e");
    localm37.b = 2;
    m localm38 = a("1f62f");
    localm38.b = 2;
    m localm39 = a("1f44d");
    localm39.b = 3;
    m localm40 = a("1f44c");
    localm40.b = 3;
    m localm41 = a("1f44e");
    localm41.b = 3;
    m localm42 = a("270c");
    localm42.b = 3;
    m localm43 = a("1f595");
    localm43.b = 3;
    m localm44 = a("1f590");
    localm44.b = 3;
    m localm45 = a("1f918");
    localm45.b = 3;
    m localm46 = a("1f596");
    localm46.b = 3;
    m localm47 = a("261d");
    localm47.b = 3;
    m localm48 = a("1f446");
    localm48.b = 3;
    m localm49 = a("1f4a7");
    m localm50 = a("1f4a4");
    m localm51 = a("1f608");
    m localm52 = a("1f47f");
    m localm53 = a("1f47e");
    m localm54 = a("1f479");
    m localm55 = a("1f480");
    m localm56 = a("1f47b");
    m localm57 = a("1f47d");
    m localm58 = a("1f916");
    m localm59 = a("1f444");
    m localm60 = a("1f445");
    m localm61 = a("1f442");
    if (!localm61.a) {}
    for (;;)
    {
      localm61.a = bool;
      localm61.b = 3;
      m localm62 = a("1f442");
      localm62.b = 3;
      m localm63 = a("1f443");
      localm63.b = 3;
      a = new d[] { locala, localc, localn, localk, locall, localm1, localm2, localm3, localm4, localm5, localm6, localm7, localm8, localm9, localm10, localm11, localm12, localm13, localm14, localm15, localm16, localm17, localm18, localm19, localm20, localm21, localm22, localm23, localm24, localm25, localm26, localm27, localm28, localm29, localm30, localm31, localm32, localm33, localm34, localm35, localm36, localm37, localm38, localm39, localm40, localm41, localm42, localm43, localm44, localm45, localm46, localm47, localm48, localm49, localm50, localm51, localm52, localm53, localm54, localm55, localm56, localm57, localm58, localm59, localm60, localm61, localm62, localm63, a("1f441"), a("1f440"), a("1f48b"), a("1f455"), a("1f456"), a("1f457"), a("1f459"), a("1f45a"), a("1f452"), a("1f3a9"), a("1f393"), a("1f451"), a("26d1"), a("1f453"), a("1f576"), a("1f302"), a("1f43a"), a("1f436"), a("1f431"), a("1f42d"), a("1f439"), a("1f430"), a("1f43b"), a("1f43c"), a("1f428"), a("1f42f"), a("1f981"), a("1f98b"), a("1f98c"), a("1f42e"), a("1f437"), a("1f43d"), a("1f438"), a("1f419"), a("1f435"), a("1f648"), a("1f649"), a("1f64a"), a("1f423"), a("1f425"), a("1f989"), a("1f41d"), a("1f41b"), a("1f40c"), a("1f41e"), a("1f41c"), a("1f577"), a("1f982"), a("1f980"), a("1f987"), a("1f40d"), a("1f422"), a("1f420"), a("1f41f"), a("1f421"), a("1f42c"), a("1f433"), a("1f40b"), a("1f40a"), a("1f43e"), a("1f335"), a("1f384"), a("1f332"), a("1f333"), a("1f334"), a("1f331"), a("1f33f"), a("2618"), a("1f340"), a("1f343"), a("1f342"), a("1f341"), a("1f33e"), a("1f33a"), a("1f33b"), a("1f339"), a("1f337"), a("1f33c"), a("1f338"), a("1f490"), a("1f344"), a("1f578"), a("1f383"), a("1f31e"), a("1f31d"), a("1f31c"), a("2b50"), a("1f31f"), a("1f4ab"), a("2728"), a("2600"), a("2602"), a("1f4a5"), a("1f525"), a("1f4a8"), a("1f324"), a("26c5"), a("1f325"), a("1f326"), a("2601"), a("1f327"), a("26c8"), a("1f329"), a("26a1"), a("2614"), a("1f4a6"), a("26c4"), a("2603"), a("1f37c"), a("1f37a"), a("1f37f"), a("1f37e"), a("1f379"), a("1f378"), a("1f377"), a("1f95b"), a("1f368"), a("1f36d"), a("1f36c"), a("1f366"), a("1f370"), a("1f382"), a("1f9c0"), a("1f355"), a("1f372"), a("1f357"), a("1f356"), a("1f353"), a("1f352"), a("1f34d"), a("1f34c"), a("1f345"), a("1f955"), a("1f336"), a("1f952"), a("1f950"), a("1f956"), a("26bd"), a("1f3c0"), a("1f3c8"), a("26be"), a("1f3d0"), a("1f3c9"), a("1f3c5"), a("1f396"), a("1f397"), a("1f3b6"), a("1f3bd"), a("2708"), a("1f680"), a("1f3c1"), a("2693"), a("1f3e0"), a("1f4b0"), a("1f380"), a("1f388"), a("2764"), a("1f49b"), a("1f49a"), a("1f499"), a("1f49c"), a("1f494"), a("2763"), a("1f495"), a("1f49e"), a("1f493"), a("1f497"), a("1f496"), a("1f498"), a("1f49d"), a("1f512"), a("1f51e"), a("1f4f5"), a("2757"), a("2753"), a("2660"), a("2663"), a("2665"), a("2666"), a("1f4a1"), a("1f56f"), a("1f399"), a("1f381"), a("1f389"), a("1f38a"), a("2620"), a("1f6ac"), a("1f489"), a("2744"), a("1f3c6"), a("1f5ef"), a("1f6bf"), a("23f0"), a("1f3f7"), a("1f3fa") };
      return;
      bool = false;
    }
  }
  
  public o(Context paramContext, ShapePickerRecyclerView paramShapePickerRecyclerView, g paramg)
  {
    this.e = paramContext;
    this.f = paramg;
    this.g = new h();
    paramShapePickerRecyclerView.setAdapter(this.g);
    this.b = new HandlerThread("Shapes Thread");
    this.b.start();
    this.b.setPriority(4);
    this.j = new j(paramContext, this.b.getLooper(), (byte)0);
    this.c = new i(paramContext.getMainLooper(), (byte)0);
    int m = paramContext.getResources().getDimensionPixelSize(2131361989);
    m = Math.min(paramContext.getResources().getDisplayMetrics().widthPixels * paramContext.getResources().getDisplayMetrics().heightPixels / (m * m) + 1, a.length - 1);
    while (m >= 0)
    {
      Message.obtain(this.j, 0, m, 0, null).sendToTarget();
      m -= 1;
    }
  }
  
  private static m a(String paramString)
  {
    return new m(paramString + ".svg");
  }
  
  public final void a(int paramInt, float paramFloat)
  {
    this.i = paramInt;
    this.h = paramFloat;
    this.g.c();
  }
  
  static final class a
    implements o.d
  {
    public final e a(Context paramContext)
    {
      return new com.whatsapp.doodle.a.a();
    }
  }
  
  static final class b
    extends Drawable
  {
    private final Paint a = new Paint(1);
    
    b()
    {
      this.a.setColor(285212672);
      this.a.setStyle(Paint.Style.FILL);
    }
    
    public final void draw(Canvas paramCanvas)
    {
      Rect localRect = getBounds();
      paramCanvas.drawCircle(localRect.centerX(), localRect.centerY(), localRect.width() / 2, this.a);
    }
    
    public final int getOpacity()
    {
      return -3;
    }
    
    public final void setAlpha(int paramInt) {}
    
    public final void setColorFilter(ColorFilter paramColorFilter) {}
  }
  
  static final class c
    implements o.d
  {
    public final e a(Context paramContext)
    {
      return new c();
    }
  }
  
  static abstract interface d
  {
    public abstract e a(Context paramContext);
  }
  
  static final class e
    extends Drawable
  {
    private e a;
    
    e(e parame)
    {
      this.a = parame;
    }
    
    public final void draw(Canvas paramCanvas)
    {
      Rect localRect = getBounds();
      this.a.a(localRect.left + this.a.f(), localRect.top + this.a.f(), localRect.right - this.a.f(), localRect.bottom - this.a.f());
      this.a.a(paramCanvas);
    }
    
    public final int getOpacity()
    {
      return -3;
    }
    
    public final void setAlpha(int paramInt) {}
    
    public final void setColorFilter(ColorFilter paramColorFilter) {}
  }
  
  static final class f
    extends ImageView
  {
    private int a;
    
    public f(Context paramContext)
    {
      super();
    }
    
    protected final void onMeasure(int paramInt1, int paramInt2)
    {
      paramInt1 = getDefaultSize(getSuggestedMinimumWidth(), paramInt1);
      setMeasuredDimension(paramInt1, paramInt1);
    }
  }
  
  public static final class g
  {
    final a a;
    
    g(a parama)
    {
      this.a = parama;
    }
  }
  
  final class h
    extends RecyclerView.a<a>
  {
    public h()
    {
      a(true);
    }
    
    public final int a()
    {
      return o.a.length;
    }
    
    public final long b(int paramInt)
    {
      return paramInt;
    }
    
    public final class a
      extends RecyclerView.p
      implements View.OnClickListener
    {
      o.d n;
      
      public a(View paramView)
      {
        super();
        paramView.setOnClickListener(this);
      }
      
      public final void onClick(View paramView)
      {
        a locala;
        DoodleView localDoodleView;
        float f2;
        float f1;
        if ((this.n != null) && (o.a(o.this) != null))
        {
          paramView = this.n.a(paramView.getContext());
          if ((paramView.c()) && (paramView.h() == 1)) {
            paramView.a(o.b(o.this));
          }
          paramView.a(o.c(o.this));
          locala = o.a(o.this).a;
          localDoodleView = locala.a;
          f2 = localDoodleView.i.width();
          f1 = localDoodleView.i.height();
          if (!(paramView instanceof h)) {
            break label354;
          }
          f2 /= 3.0F;
        }
        for (f1 /= 3.0F;; f1 /= 2.0F)
        {
          float f3 = localDoodleView.i.centerX();
          float f4 = f2 / 2.0F;
          float f5 = localDoodleView.i.centerY();
          float f6 = f1 / 2.0F;
          float f7 = localDoodleView.i.centerX();
          f2 /= 2.0F;
          float f8 = localDoodleView.i.centerY();
          paramView.a(f3 - f4, f5 - f6, f2 + f7, f1 / 2.0F + f8);
          if ((paramView.c()) && (paramView.h() == 1)) {
            paramView.a(localDoodleView.b);
          }
          if (paramView.b()) {
            paramView.a(e.i.e / localDoodleView.k);
          }
          paramView.b(-localDoodleView.l);
          localDoodleView.a.add(paramView);
          localDoodleView.f.a(new u.a(paramView));
          localDoodleView.invalidate();
          localDoodleView.e = paramView;
          localDoodleView.g = null;
          localDoodleView.h = null;
          localDoodleView.c = false;
          if (localDoodleView.d != null) {
            localDoodleView.d.a(localDoodleView.e);
          }
          locala.d();
          return;
          label354:
          f2 /= 2.0F;
        }
      }
    }
  }
  
  public final class i
    extends Handler
  {
    private i(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      if (paramMessage.obj != null)
      {
        int i = paramMessage.arg1;
        paramMessage = (o.f)paramMessage.obj;
        if (o.f.a(paramMessage) == i) {
          paramMessage.setImageDrawable((Drawable)paramMessage.getTag());
        }
      }
    }
  }
  
  final class j
    extends Handler
  {
    private final Context b;
    
    private j(Context paramContext, Looper paramLooper)
    {
      super();
      this.b = paramContext;
    }
    
    public final void handleMessage(Message paramMessage)
    {
      int i = paramMessage.arg1;
      Drawable localDrawable = o.a(o.this, i);
      if (localDrawable == null) {
        localDrawable = o.a(o.this, this.b, i);
      }
      for (;;)
      {
        if (localDrawable != null)
        {
          o.a(o.this, i, localDrawable);
          paramMessage = (o.f)paramMessage.obj;
          if (paramMessage != null)
          {
            paramMessage.setTag(localDrawable);
            Message.obtain(o.f(o.this), 0, i, 0, paramMessage).sendToTarget();
          }
        }
        return;
      }
    }
  }
  
  static final class k
    implements o.d
  {
    public final e a(Context paramContext)
    {
      return new f();
    }
  }
  
  static final class l
    implements o.d
  {
    public final e a(Context paramContext)
    {
      return new g();
    }
  }
  
  static final class m
    implements o.d
  {
    boolean a;
    int b = 0;
    private String c;
    
    m(String paramString)
    {
      this.c = paramString;
    }
    
    public final e a(Context paramContext)
    {
      paramContext = new h(paramContext, this.c);
      paramContext.a = this.a;
      paramContext.b = this.b;
      return paramContext;
    }
  }
  
  static final class n
    implements o.d
  {
    public final e a(Context paramContext)
    {
      return new j();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/doodle/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */