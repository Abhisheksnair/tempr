package com.whatsapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.support.v4.view.g;
import android.support.v4.view.q;
import android.util.AttributeSet;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation.AnimationListener;

public class PhotoView
  extends View
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, ScaleGestureDetector.OnScaleGestureListener
{
  public static Bitmap b;
  private e A;
  private RectF B;
  private Paint C = new Paint();
  private Rect D = new Rect();
  private a E;
  private float F;
  private int G = c.a;
  private boolean H;
  private boolean I;
  private int J;
  private int K;
  private int L;
  private RectF M = new RectF();
  private RectF N = new RectF();
  private RectF O = new RectF();
  private final Runnable P = new Runnable()
  {
    public final void run()
    {
      if (PhotoView.a(PhotoView.this) != null) {
        PhotoView.a(PhotoView.this).onClick(PhotoView.this);
      }
    }
  };
  private Matrix a;
  public BitmapDrawable c;
  float d;
  private Matrix e = new Matrix();
  private Matrix f = new Matrix();
  private boolean g;
  private boolean h = false;
  private boolean i;
  private g j;
  private ScaleGestureDetector k;
  private View.OnClickListener l;
  private boolean m;
  private boolean n = true;
  private boolean o;
  private boolean p;
  private boolean q;
  private b r;
  private float s;
  private float t;
  private float u;
  private float v;
  private float w;
  private float x = Float.MAX_VALUE;
  private f y;
  private d z;
  
  public PhotoView(Context paramContext)
  {
    super(paramContext);
    e();
  }
  
  public PhotoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    e();
  }
  
  public PhotoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    e();
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean)
  {
    paramFloat1 = Math.min(Math.max(paramFloat1, this.s), this.t);
    float f1 = paramFloat1 / getScale();
    this.e.postRotate(-this.d, getWidth() / 2, getHeight() / 2);
    this.e.postScale(f1, f1, paramFloat2, paramFloat3);
    this.u = paramFloat1;
    this.e.postRotate(this.d, getWidth() / 2, getHeight() / 2);
    c(paramBoolean);
    invalidate();
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    this.O.set(this.M);
    this.e.mapRect(this.O);
    float f1 = getWidth();
    float f2 = this.O.left;
    float f3 = this.O.right;
    float f4;
    if (f3 - f2 < f1)
    {
      f1 = (f1 - (f2 + f3)) / 2.0F + 0.0F;
      f2 = getHeight();
      f3 = this.O.top;
      f4 = this.O.bottom;
      if (f4 - f3 >= f2) {
        break label168;
      }
    }
    label168:
    for (f2 = (f2 - (f3 + f4)) / 2.0F + 0.0F;; f2 = Math.max(f2 - f4, Math.min(0.0F - f3, paramFloat2)))
    {
      this.e.postTranslate(f1, f2);
      invalidate();
      if ((f1 != paramFloat1) || (f2 != paramFloat2)) {
        break label189;
      }
      return true;
      f1 = Math.max(f1 - f3, Math.min(0.0F - f2, paramFloat1));
      break;
    }
    label189:
    return false;
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.c == null) || (!this.g)) {
      return;
    }
    int i1 = this.c.getIntrinsicWidth();
    int i2 = this.c.getIntrinsicHeight();
    this.c.setBounds(0, 0, i1, i2);
    int i3;
    int i4;
    float f1;
    label292:
    float f2;
    float f3;
    if ((paramBoolean) || ((this.s == 0.0F) && (this.c != null) && (this.g)))
    {
      i2 = this.c.getIntrinsicWidth();
      i3 = this.c.getIntrinsicHeight();
      i4 = getWidth();
      i1 = getHeight();
      this.v = 0.0F;
      this.e.reset();
      this.M.set(0.0F, 0.0F, i2, i3);
      this.N.set(0.0F, 0.0F, i4, i1);
      this.e.setTranslate(i4 / 2 - i2 / 2, i1 / 2 - i3 / 2);
      if (this.L != 0) {
        i1 = this.L;
      }
      if (!this.h) {
        break label567;
      }
      if (Math.abs(this.d % 180.0F) != 90.0F) {
        break label546;
      }
      f1 = Math.max(i4 / i3, i1 / i2);
      this.s = f1;
      this.s = Math.min(this.s, this.x);
      if (this.G != c.d) {
        break label652;
      }
      if (Math.abs(this.d % 180.0F) != 90.0F) {
        break label631;
      }
      f1 = Math.max(i4 / i3, i1 / i2);
      if (Math.abs(this.d % 180.0F) != 90.0F) {
        break label758;
      }
      f2 = i4 / i3;
      f3 = i1 / i2;
      if (Math.abs(f2 / f3 - 1.0F) < this.F)
      {
        this.v = Math.max(f2, f3);
        f1 = this.v;
      }
      label358:
      if (this.u == 0.0F) {
        this.u = Math.min(f1, this.x);
      }
      if ((!this.H) || (!this.I))
      {
        if (!this.I) {
          break label810;
        }
        if (this.J == i4) {}
      }
    }
    for (;;)
    {
      label409:
      this.u = Math.min(f1, this.x);
      label546:
      label567:
      label631:
      label652:
      label758:
      label810:
      do
      {
        this.J = i4;
        this.K = i1;
        this.v = Math.min(this.v, this.x);
        this.e.preScale(this.u, this.u, i2 / 2, i3 / 2);
        this.t = Math.max(this.s * 8.0F, 8.0F);
        this.e.postRotate(this.d, getWidth() / 2, getHeight() / 2);
        this.w = this.u;
        this.f.set(this.e);
        this.a = this.e;
        return;
        f1 = Math.max(i4 / i2, i1 / i3);
        break;
        if (Math.abs(this.d % 180.0F) == 90.0F) {}
        for (f1 = Math.min(i4 / i3, i1 / i2);; f1 = Math.min(i4 / i2, i1 / i3))
        {
          this.s = f1;
          break;
        }
        f1 = Math.max(i4 / i2, i1 / i3);
        break label292;
        if (this.G == c.b)
        {
          if (Math.abs(this.d % 180.0F) == 90.0F)
          {
            f1 = i4 / i3;
            break label292;
          }
          f1 = i4 / i2;
          break label292;
        }
        if (this.G == c.c)
        {
          if (Math.abs(this.d % 180.0F) == 90.0F)
          {
            f1 = i1 / i2;
            break label292;
          }
          f1 = i1 / i3;
          break label292;
        }
        f1 = this.s;
        break label292;
        f2 = i4 / i2;
        f3 = i1 / i3;
        if (Math.abs(f2 / f3 - 1.0F) >= this.F) {
          break label358;
        }
        this.v = Math.max(f2, f3);
        f1 = this.v;
        break label358;
        if (!this.H) {
          break label409;
        }
      } while (this.K == i1);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    float f2 = 0.0F;
    this.O.set(this.M);
    this.e.mapRect(this.O);
    float f1 = getWidth();
    float f3 = this.O.left;
    float f4 = this.O.right;
    float f5;
    if (f4 - f3 < f1)
    {
      f1 = (f1 - (f3 + f4)) / 2.0F + 0.0F;
      f3 = getHeight();
      f5 = this.O.top;
      f4 = this.O.bottom;
      if (f4 - f5 >= f3) {
        break label242;
      }
      f2 = 0.0F + (f3 - (f5 + f4)) / 2.0F;
    }
    for (;;)
    {
      if (((Math.abs(f1) <= 20.0F) && (Math.abs(f2) <= 20.0F)) || (paramBoolean)) {
        break label274;
      }
      d locald = this.z;
      if (!locald.e)
      {
        locald.d = -1L;
        locald.b = f1;
        locald.c = f2;
        locald.f = false;
        locald.e = true;
        locald.a.postDelayed(locald, 250L);
      }
      return;
      if (f3 > 0.0F)
      {
        f1 = 0.0F - f3;
        break;
      }
      if (f4 < f1)
      {
        f1 -= f4;
        break;
      }
      f1 = 0.0F;
      break;
      label242:
      if (f5 > 0.0F) {
        f2 = 0.0F - f5;
      } else if (f4 < f3) {
        f2 = f3 - f4;
      }
    }
    label274:
    this.e.postTranslate(f1, f2);
    invalidate();
  }
  
  private void e()
  {
    Context localContext = getContext();
    this.j = new g(localContext, this);
    this.k = new ScaleGestureDetector(localContext, this);
    if (Build.VERSION.SDK_INT >= 19) {
      this.k.setQuickScaleEnabled(false);
    }
    this.r = new b(this);
    this.y = new f(this);
    this.z = new d(this);
    this.E = new a(this);
    this.A = new e(this);
  }
  
  public final void a()
  {
    this.r.a(getScale(), this.s, getWidth() / 2, getHeight() / 2);
  }
  
  public final void a(float paramFloat, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a locala = this.E;
      if (locala.f) {
        locala.b += paramFloat;
      }
      for (;;)
      {
        locala.d = (locala.b / 300.0F);
        locala.g = false;
        locala.f = true;
        return;
        locala.b = paramFloat;
        locala.c = 0.0F;
        locala.e = -1L;
        locala.a.post(locala);
      }
    }
    this.d += paramFloat;
    this.e.postRotate(paramFloat, getWidth() / 2, getHeight() / 2);
    invalidate();
  }
  
  public final void a(Bitmap paramBitmap)
  {
    boolean bool;
    if (this.c != null)
    {
      if (paramBitmap == this.c.getBitmap()) {
        return;
      }
      if ((paramBitmap != null) && ((this.c.getIntrinsicWidth() != paramBitmap.getWidth()) || (this.c.getIntrinsicHeight() != paramBitmap.getHeight())))
      {
        bool = true;
        this.s = 0.0F;
        this.c = null;
      }
    }
    for (;;)
    {
      if ((this.c == null) && (paramBitmap != null)) {
        this.c = new BitmapDrawable(getResources(), paramBitmap);
      }
      if (bool)
      {
        this.J = 0;
        this.K = 0;
      }
      b(bool);
      invalidate();
      return;
      bool = false;
      break;
      bool = false;
    }
  }
  
  public final void a(Rect paramRect, boolean paramBoolean, Animation.AnimationListener paramAnimationListener)
  {
    if (this.c == null) {
      return;
    }
    RectF localRectF = new RectF(this.c.getBounds());
    this.e.mapRect(localRectF);
    if (paramBoolean)
    {
      this.A.a(new RectF(paramRect), localRectF, paramAnimationListener);
      return;
    }
    this.A.a(localRectF, new RectF(paramRect), paramAnimationListener);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.m = paramBoolean;
    if (!this.m) {
      d();
    }
  }
  
  public final boolean b()
  {
    if (!this.m) {}
    do
    {
      do
      {
        return false;
        if (f.a(this.y)) {
          return true;
        }
        if (this.v != 0.0F) {
          break;
        }
      } while (getScale() == this.s);
      return true;
    } while (getScale() <= this.v);
    return true;
  }
  
  public final void c()
  {
    this.j = null;
    this.k = null;
    this.c = null;
    if (this.r != null) {
      this.r.a();
    }
    this.r = null;
    if (this.y != null) {
      this.y.a();
    }
    this.y = null;
    if (this.z != null) {
      this.z.a();
    }
    this.z = null;
    if (this.E != null) {
      this.E.a();
    }
    this.E = null;
    if (this.A != null) {
      this.A.a();
    }
    this.A = null;
    setOnClickListener(null);
    this.l = null;
  }
  
  public final void d()
  {
    this.e.set(this.f);
    this.u = this.w;
    invalidate();
  }
  
  public Bitmap getFullViewCroppedBitmap()
  {
    Object localObject;
    if (!this.h) {
      localObject = null;
    }
    Bitmap localBitmap;
    Canvas localCanvas;
    Matrix localMatrix;
    do
    {
      return (Bitmap)localObject;
      localBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
      localCanvas = new Canvas(localBitmap);
      localMatrix = new Matrix(this.a);
      localObject = localBitmap;
    } while (this.c == null);
    localCanvas.concat(localMatrix);
    this.c.draw(localCanvas);
    return localBitmap;
  }
  
  protected float getMaxScale()
  {
    return this.t;
  }
  
  protected float getMinScale()
  {
    return this.s;
  }
  
  public Bitmap getPhoto()
  {
    if (this.c != null) {
      return this.c.getBitmap();
    }
    return null;
  }
  
  protected float getScale()
  {
    return this.u;
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    float f2;
    float f1;
    if ((this.n) && (this.m)) {
      if (!this.o)
      {
        f2 = getScale();
        if (f2 != this.s) {
          break label100;
        }
        f1 = 2.0F * this.s;
        f1 = Math.max(this.s, f1);
        f1 = Math.min(this.t, f1);
        if (f1 != this.s) {
          break label108;
        }
        this.r.a(f2, f1, getWidth() / 2, getHeight() / 2);
      }
    }
    for (;;)
    {
      this.o = false;
      return true;
      label100:
      f1 = this.s;
      break;
      label108:
      this.r.a(f2, f1, paramMotionEvent.getX(), paramMotionEvent.getY());
    }
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    if (this.m)
    {
      this.y.a();
      this.z.a();
    }
    return true;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f1;
    Object localObject;
    float f2;
    if (this.B != null) {
      if (this.c != null)
      {
        if (this.c.getIntrinsicHeight() * this.B.width() <= this.B.height() * this.c.getIntrinsicWidth()) {
          break label176;
        }
        f1 = this.c.getIntrinsicWidth() * this.B.height() / this.B.width();
        this.D.left = 0;
        this.D.right = this.c.getIntrinsicWidth();
        this.D.top = ((int)(this.c.getIntrinsicHeight() / 2 - f1 / 2.0F));
        localObject = this.D;
        f2 = this.c.getIntrinsicHeight() / 2;
        ((Rect)localObject).bottom = ((int)(f1 / 2.0F + f2));
        paramCanvas.drawBitmap(this.c.getBitmap(), this.D, this.B, this.C);
      }
    }
    label176:
    do
    {
      do
      {
        return;
        f1 = this.c.getIntrinsicHeight() * this.B.width() / this.B.height();
        this.D.top = 0;
        this.D.bottom = this.c.getIntrinsicHeight();
        this.D.left = ((int)(this.c.getIntrinsicWidth() / 2 - f1 / 2.0F));
        localObject = this.D;
        f2 = this.c.getIntrinsicWidth() / 2;
        ((Rect)localObject).right = ((int)(f1 / 2.0F + f2));
        break;
      } while (this.c == null);
      int i1 = paramCanvas.getSaveCount();
      paramCanvas.save();
      if (this.a != null) {
        paramCanvas.concat(this.a);
      }
      this.c.draw(paramCanvas);
      paramCanvas.restoreToCount(i1);
      if (this.i)
      {
        localObject = b;
        i1 = (getWidth() - ((Bitmap)localObject).getWidth()) / 2;
        int i2 = (getHeight() - ((Bitmap)localObject).getHeight()) / 2;
        paramCanvas.drawBitmap((Bitmap)localObject, i1, i2, null);
      }
      this.O.set(this.c.getBounds());
      if (Math.abs(this.d % 180.0F) == 90.0F)
      {
        f1 = this.O.right;
        this.O.right = this.O.bottom;
        this.O.bottom = f1;
      }
    } while (this.a == null);
    this.a.mapRect(this.O);
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (this.m)
    {
      paramMotionEvent1 = this.y;
      if (!paramMotionEvent1.e)
      {
        paramMotionEvent1.d = -1L;
        paramMotionEvent1.b = paramFloat1;
        paramMotionEvent1.c = paramFloat2;
        paramMotionEvent1.f = false;
        paramMotionEvent1.e = true;
        paramMotionEvent1.a.post(paramMotionEvent1);
      }
    }
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.g = true;
    b(paramBoolean);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (this.m)
    {
      this.p = false;
      a(getScale() * paramScaleGestureDetector.getScaleFactor(), paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY(), false);
    }
    return true;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (this.m)
    {
      this.r.a();
      this.p = true;
    }
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    if ((this.m) && (this.p))
    {
      this.o = true;
      d();
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (this.m) {
      a(-paramFloat1, -paramFloat2);
    }
    return true;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if ((this.l != null) && (!this.p) && (this.n)) {
      this.l.onClick(this);
    }
    this.p = false;
    return true;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    if ((this.k == null) || (this.j == null)) {
      bool = true;
    }
    while (!isEnabled()) {
      return bool;
    }
    this.k.onTouchEvent(paramMotionEvent);
    this.j.a(paramMotionEvent);
    int i1 = q.a(paramMotionEvent);
    int i2 = q.c(paramMotionEvent);
    if (i2 > 1) {
      this.q = true;
    }
    switch (i1)
    {
    }
    for (;;)
    {
      return true;
      if ((this.l != null) && (!this.p) && (!this.q) && (!this.n)) {
        post(this.P);
      }
      if (i2 == 1) {
        this.q = false;
      }
      if (!f.a(this.y)) {
        c(false);
      }
    }
  }
  
  public void setAllowFullViewCrop(boolean paramBoolean)
  {
    if (paramBoolean != this.h)
    {
      this.h = paramBoolean;
      requestLayout();
      invalidate();
    }
  }
  
  public void setDoubleTapToZoomEnabled(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public void setHeightForInitialScaleCalculation(int paramInt)
  {
    this.L = paramInt;
  }
  
  public void setIgnoreRescaleOnHeightChange(boolean paramBoolean)
  {
    this.I = paramBoolean;
  }
  
  public void setIgnoreRescaleOnWidthChange(boolean paramBoolean)
  {
    this.H = paramBoolean;
  }
  
  public void setInitialFitTolerance(float paramFloat)
  {
    this.F = paramFloat;
  }
  
  public void setInitialScaleType$56cf5d5c(int paramInt)
  {
    this.G = paramInt;
  }
  
  public void setIsLongpressEnabled(boolean paramBoolean)
  {
    this.j.a(paramBoolean);
  }
  
  public void setIsVideo(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void setMaxInitialScale(float paramFloat)
  {
    this.x = paramFloat;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.l = paramOnClickListener;
  }
  
  static final class a
    implements Runnable
  {
    final PhotoView a;
    float b;
    float c;
    float d;
    long e;
    boolean f;
    boolean g;
    
    public a(PhotoView paramPhotoView)
    {
      this.a = paramPhotoView;
    }
    
    public final void a()
    {
      this.f = false;
      this.g = true;
      PhotoView.a(this.a, Math.round(PhotoView.d(this.a)));
      PhotoView.e(this.a);
      this.a.requestLayout();
      this.a.invalidate();
    }
    
    public final void run()
    {
      if (this.g) {
        return;
      }
      long l2;
      if (this.c != this.b)
      {
        l2 = System.currentTimeMillis();
        if (this.e == -1L) {
          break label178;
        }
      }
      label178:
      for (long l1 = l2 - this.e;; l1 = 0L)
      {
        float f1 = this.d;
        float f2 = (float)l1 * f1;
        if ((this.c >= this.b) || (this.c + f2 <= this.b))
        {
          f1 = f2;
          if (this.c > this.b)
          {
            f1 = f2;
            if (this.c + f2 >= this.b) {}
          }
        }
        else
        {
          f1 = this.b - this.c;
        }
        this.a.a(f1, false);
        this.c = (f1 + this.c);
        if (this.c == this.b) {
          a();
        }
        this.e = l2;
        if (this.g) {
          break;
        }
        this.a.post(this);
        return;
      }
    }
  }
  
  static final class b
    implements Runnable
  {
    private final PhotoView a;
    private float b;
    private float c;
    private boolean d;
    private float e;
    private float f;
    private float g;
    private long h;
    private boolean i;
    private boolean j;
    
    public b(PhotoView paramPhotoView)
    {
      this.a = paramPhotoView;
    }
    
    public final void a()
    {
      this.i = false;
      this.j = true;
    }
    
    public final boolean a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      if (this.i) {
        return false;
      }
      this.b = paramFloat3;
      this.c = paramFloat4;
      this.e = paramFloat2;
      this.h = System.currentTimeMillis();
      this.f = paramFloat1;
      if (this.e > this.f) {}
      for (boolean bool = true;; bool = false)
      {
        this.d = bool;
        this.g = ((this.e - this.f) / 200.0F);
        this.i = true;
        this.j = false;
        this.a.post(this);
        return true;
      }
    }
    
    public final void run()
    {
      if (this.j) {
        return;
      }
      long l1 = System.currentTimeMillis();
      long l2 = this.h;
      float f1 = this.f;
      float f2 = this.g;
      f1 = (float)(l1 - l2) * f2 + f1;
      PhotoView.a(this.a, f1, this.b, this.c);
      boolean bool2;
      if (f1 != this.e)
      {
        bool2 = this.d;
        if (f1 <= this.e) {
          break label128;
        }
      }
      label128:
      for (boolean bool1 = true;; bool1 = false)
      {
        if (bool2 == bool1)
        {
          PhotoView.a(this.a, this.e, this.b, this.c);
          a();
        }
        if (this.j) {
          break;
        }
        this.a.post(this);
        return;
      }
    }
  }
  
  public static enum c {}
  
  static final class d
    implements Runnable
  {
    final PhotoView a;
    float b;
    float c;
    long d = -1L;
    boolean e;
    boolean f;
    
    public d(PhotoView paramPhotoView)
    {
      this.a = paramPhotoView;
    }
    
    public final void a()
    {
      this.e = false;
      this.f = true;
    }
    
    public final void run()
    {
      if (this.f) {
        return;
      }
      long l = System.currentTimeMillis();
      if (this.d != -1L) {}
      for (float f1 = (float)(l - this.d);; f1 = 0.0F)
      {
        if (this.d == -1L) {
          this.d = l;
        }
        if (f1 < 100.0F) {
          break label145;
        }
        f2 = this.b;
        f1 = this.c;
        f3 = f2;
        f2 = f1;
        label71:
        PhotoView.a(this.a, f3, f2);
        this.b -= f3;
        this.c -= f2;
        if ((this.b == 0.0F) && (this.c == 0.0F)) {
          a();
        }
        if (this.f) {
          break;
        }
        this.a.post(this);
        return;
      }
      label145:
      float f2 = this.b / (100.0F - f1) * 10.0F;
      float f3 = this.c / (100.0F - f1) * 10.0F;
      if ((Math.abs(f2) > Math.abs(this.b)) || (f2 == NaN.0F)) {}
      for (f1 = this.b;; f1 = f2)
      {
        f2 = f1;
        if (Math.abs(f3) > Math.abs(this.c)) {
          break;
        }
        f2 = f1;
        if (f3 == NaN.0F) {
          break;
        }
        f2 = f3;
        f3 = f1;
        break label71;
      }
    }
  }
  
  static final class e
    implements Runnable
  {
    private final PhotoView a;
    private boolean b;
    private boolean c;
    private long d;
    private RectF e;
    private RectF f;
    private long g;
    private Animation.AnimationListener h;
    
    public e(PhotoView paramPhotoView)
    {
      this.a = paramPhotoView;
    }
    
    public final void a()
    {
      this.b = false;
      this.c = true;
      PhotoView.a(this.a, null);
      if (this.h != null) {
        this.h.onAnimationEnd(null);
      }
    }
    
    public final boolean a(RectF paramRectF1, RectF paramRectF2, Animation.AnimationListener paramAnimationListener)
    {
      if (this.b) {
        return false;
      }
      this.g = 200L;
      this.h = paramAnimationListener;
      this.e = paramRectF1;
      this.f = paramRectF2;
      this.c = false;
      this.d = 0L;
      PhotoView.a(this.a, new RectF(paramRectF1));
      this.a.post(this);
      return true;
    }
    
    public final void run()
    {
      if (this.c) {
        return;
      }
      if (this.d == 0L) {
        this.d = System.currentTimeMillis();
      }
      float f1 = (float)(System.currentTimeMillis() - this.d) / (float)this.g;
      if (f1 >= 1.0F) {
        a();
      }
      for (;;)
      {
        this.a.invalidate();
        if (this.c) {
          break;
        }
        this.a.post(this);
        return;
        f1 = 1.0F - (f1 - 1.0F) * (f1 - 1.0F);
        PhotoView.b(this.a).left = (this.e.left - (this.e.left - this.f.left) * f1);
        PhotoView.b(this.a).right = (this.e.right + (this.f.right - this.e.right) * f1);
        PhotoView.b(this.a).top = (this.e.top - (this.e.top - this.f.top) * f1);
        RectF localRectF = PhotoView.b(this.a);
        float f2 = this.e.bottom;
        localRectF.bottom = (f1 * (this.f.bottom - this.e.bottom) + f2);
      }
    }
  }
  
  static final class f
    implements Runnable
  {
    final PhotoView a;
    float b;
    float c;
    long d = -1L;
    boolean e;
    boolean f;
    
    public f(PhotoView paramPhotoView)
    {
      this.a = paramPhotoView;
    }
    
    public final void a()
    {
      this.e = false;
      this.f = true;
    }
    
    public final void run()
    {
      if (this.f) {
        return;
      }
      long l = System.currentTimeMillis();
      float f1;
      label34:
      boolean bool;
      if (this.d != -1L)
      {
        f1 = (float)(l - this.d) / 1000.0F;
        bool = PhotoView.a(this.a, this.b * f1, this.c * f1);
        this.d = l;
        f1 *= 1000.0F;
        if (this.b <= 0.0F) {
          break label187;
        }
        this.b -= f1;
        if (this.b < 0.0F) {
          this.b = 0.0F;
        }
        label98:
        if (this.c <= 0.0F) {
          break label214;
        }
        this.c -= f1;
        if (this.c < 0.0F) {
          this.c = 0.0F;
        }
      }
      for (;;)
      {
        if (((this.b == 0.0F) && (this.c == 0.0F)) || (!bool))
        {
          a();
          PhotoView.c(this.a);
        }
        if (this.f) {
          break;
        }
        this.a.post(this);
        return;
        f1 = 0.0F;
        break label34;
        label187:
        this.b += f1;
        if (this.b <= 0.0F) {
          break label98;
        }
        this.b = 0.0F;
        break label98;
        label214:
        this.c = (f1 + this.c);
        if (this.c > 0.0F) {
          this.c = 0.0F;
        }
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/PhotoView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */