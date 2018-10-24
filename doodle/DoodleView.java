package com.whatsapp.doodle;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.view.g;
import android.util.AttributeSet;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.View;
import android.view.View.BaseSavedState;
import com.whatsapp.doodle.a.b;
import com.whatsapp.doodle.a.d;
import com.whatsapp.doodle.a.e;
import com.whatsapp.doodle.a.e.a;
import com.whatsapp.doodle.a.e.b;
import com.whatsapp.doodle.a.i;
import com.whatsapp.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DoodleView
  extends View
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, ScaleGestureDetector.OnScaleGestureListener, l.a, m.a
{
  private final Paint A = new Paint(1);
  private Bitmap B;
  private int C;
  private Bitmap D;
  private int E;
  private e F;
  private int G;
  private int H;
  public final ArrayList<e> a = new ArrayList();
  int b;
  boolean c = true;
  a d;
  e e;
  final u f = new u();
  e g;
  e.b h;
  public RectF i;
  public RectF j;
  float k;
  public int l;
  public Matrix m = new Matrix();
  public boolean n;
  public long o;
  boolean p;
  private float q;
  private float r;
  private boolean s;
  private g t;
  private n u;
  private m v;
  private l w;
  private float x;
  private float[] y = new float[2];
  private Matrix z = new Matrix();
  
  public DoodleView(Context paramContext)
  {
    super(paramContext);
    f();
  }
  
  public DoodleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    f();
  }
  
  public DoodleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    f();
  }
  
  @TargetApi(21)
  public DoodleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    f();
  }
  
  private e a(MotionEvent paramMotionEvent)
  {
    Object localObject = a(paramMotionEvent.getX(), paramMotionEvent.getY());
    float f4 = ((PointF)localObject).x;
    float f5 = ((PointF)localObject).y;
    int i2 = paramMotionEvent.getPointerCount();
    paramMotionEvent = null;
    float f1 = Float.MAX_VALUE;
    int i1 = this.a.size() - 1;
    if (i1 >= 0)
    {
      localObject = (e)this.a.get(i1);
      if ((localObject instanceof d)) {
        break label187;
      }
      if (((e)localObject).a(f4, f5)) {
        return (e)localObject;
      }
      if ((this.s) && (i2 <= 1)) {
        break label187;
      }
      float f2 = ((e)localObject).d.centerX();
      float f3 = ((e)localObject).d.centerY();
      f3 = (f2 - f4) * (f2 - f4) + (f3 - f5) * (f3 - f5);
      f2 = f3;
      if (localObject == this.e) {
        f2 = f3 / 4.0F;
      }
      if (f2 >= f1) {
        break label187;
      }
      paramMotionEvent = (MotionEvent)localObject;
      f1 = f2;
    }
    label187:
    for (;;)
    {
      i1 -= 1;
      break;
      return paramMotionEvent;
    }
  }
  
  private Bitmap b(Bitmap paramBitmap)
  {
    Bitmap localBitmap;
    if ((paramBitmap != null) && (paramBitmap.getWidth() == getWidth()))
    {
      localBitmap = paramBitmap;
      if (paramBitmap.getHeight() == getHeight()) {}
    }
    else if (paramBitmap != null)
    {
      paramBitmap.recycle();
    }
    try
    {
      localBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
      return localBitmap;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      Log.i("oom trying to create bitmap cache");
    }
    return null;
  }
  
  private PointF b(MotionEvent paramMotionEvent)
  {
    return a(paramMotionEvent.getX(), paramMotionEvent.getY());
  }
  
  private void f()
  {
    this.b = -65536;
    this.q = 8.0F;
    this.r = 8.0F;
    Context localContext = getContext();
    this.t = new g(localContext, this);
    this.u = new n(localContext, this);
    this.v = new m(this);
    this.w = new l(this);
  }
  
  final PointF a(float paramFloat1, float paramFloat2)
  {
    this.z.reset();
    this.z.preRotate(-this.l);
    if (this.l == 90) {
      this.z.preTranslate(-getWidth(), 0.0F);
    }
    do
    {
      for (;;)
      {
        this.y[0] = paramFloat1;
        this.y[1] = paramFloat2;
        this.z.mapPoints(this.y);
        return new PointF(this.i.left - this.j.left + this.y[0] / this.x, this.i.top - this.j.top + this.y[1] / this.x);
        if (this.l == 180)
        {
          this.z.preTranslate(-getWidth(), -getHeight());
        }
        else
        {
          if (this.l != 270) {
            break;
          }
          this.z.preTranslate(0.0F, -getHeight());
        }
      }
    } while (this.l == 0);
    throw new IllegalArgumentException();
  }
  
  public final void a()
  {
    if (this.i == null) {}
    do
    {
      return;
      this.m = new Matrix();
      this.m.preRotate(this.l);
      if (this.l == 90)
      {
        this.m.preTranslate(0.0F, -this.i.height());
        return;
      }
      if (this.l == 180)
      {
        this.m.preTranslate(-this.i.width(), -this.i.height());
        return;
      }
      if (this.l == 270)
      {
        this.m.preTranslate(-this.i.width(), 0.0F);
        return;
      }
    } while (this.l == 0);
    throw new IllegalArgumentException();
  }
  
  public final void a(float paramFloat, int paramInt)
  {
    if ((this.e != null) && (this.e != this.g) && ((this.e.b()) || (this.e.c())))
    {
      this.h = this.e.e();
      this.g = this.e;
    }
    this.r = paramFloat;
    i locali;
    float f1;
    if (this.k == 0.0F)
    {
      this.q = this.r;
      this.b = paramInt;
      if ((!this.c) && (this.e != null) && ((this.e.b()) || (this.e.c())))
      {
        if (this.e.c()) {
          this.e.a(this.b);
        }
        if (this.e.b()) {
          this.e.a(this.q);
        }
        if ((this.e instanceof i))
        {
          locali = (i)this.e;
          f1 = (e.i.f - e.i.e) / 4.0F;
          if (paramFloat >= e.i.e + f1) {
            break label236;
          }
          locali.c(0);
        }
      }
    }
    for (;;)
    {
      invalidate();
      return;
      this.q = (this.r / this.k);
      break;
      label236:
      if (paramFloat < e.i.e + 2.0F * f1) {
        locali.c(1);
      } else if (paramFloat < f1 * 3.0F + e.i.e) {
        locali.c(2);
      } else {
        locali.c(3);
      }
    }
  }
  
  public final void a(Bitmap paramBitmap)
  {
    if (this.i == null) {
      return;
    }
    Canvas localCanvas = new Canvas(paramBitmap);
    float f1;
    label39:
    float f2;
    label60:
    label119:
    e locale;
    if (this.l % 180 == 90)
    {
      f1 = this.i.height();
      if (this.l % 180 != 90) {
        break label192;
      }
      f2 = this.i.width();
      localCanvas.scale(paramBitmap.getWidth() / f1, 1.0F * paramBitmap.getHeight() / f2);
      localCanvas.concat(this.m);
      localCanvas.translate(-this.i.left, -this.i.top);
      paramBitmap = this.a.iterator();
      while (paramBitmap.hasNext())
      {
        locale = (e)paramBitmap.next();
        if (!locale.g) {
          if (!this.n) {
            break label203;
          }
        }
      }
    }
    label192:
    label203:
    for (long l1 = SystemClock.elapsedRealtime() - this.o;; l1 = 0L)
    {
      locale.h = l1;
      locale.a(localCanvas);
      break label119;
      break;
      f1 = this.i.width();
      break label39;
      f2 = this.i.height();
      break label60;
    }
  }
  
  public final void a(e parame)
  {
    this.f.a(new u.c(parame, this.a));
    this.a.remove(parame);
    if (parame == this.e) {
      this.e = null;
    }
    this.p = false;
    invalidate();
  }
  
  public final boolean a(float paramFloat)
  {
    if (this.e != null)
    {
      this.e.b(paramFloat);
      invalidate();
    }
    return true;
  }
  
  public final boolean b()
  {
    return !this.a.isEmpty();
  }
  
  public final boolean b(float paramFloat1, float paramFloat2)
  {
    if ((this.e != null) && (!(this.e instanceof d)))
    {
      this.y[0] = paramFloat1;
      this.y[1] = paramFloat2;
      this.z.reset();
      this.z.setRotate(-this.l);
      this.z.mapPoints(this.y);
      e locale = this.e;
      paramFloat1 = this.y[0] / this.x;
      paramFloat2 = this.y[1] / this.x;
      locale.d.offset(paramFloat1, paramFloat2);
      invalidate();
    }
    return true;
  }
  
  public final boolean c()
  {
    return !this.f.a.isEmpty();
  }
  
  public final void d()
  {
    this.n = true;
    this.o = SystemClock.elapsedRealtime();
    invalidate();
  }
  
  public void draw(Canvas paramCanvas)
  {
    boolean bool1 = false;
    super.draw(paramCanvas);
    if (this.i == null) {}
    label84:
    label161:
    label676:
    do
    {
      return;
      Object localObject1;
      int i1;
      Object localObject2;
      int i2;
      boolean bool2;
      if (this.a.size() >= 3)
      {
        if (this.n)
        {
          localObject1 = this.a.iterator();
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
          } while (!((e)((Iterator)localObject1).next()).i());
          i1 = 1;
          if (i1 == 0) {}
        }
      }
      else
      {
        this.C = 0;
        this.E = 0;
        if (this.C > 0) {
          paramCanvas.drawBitmap(this.B, 0.0F, 0.0F, this.A);
        }
        paramCanvas.save();
        paramCanvas.scale(this.x, this.x);
        paramCanvas.concat(this.m);
        paramCanvas.translate(-this.i.left, -this.i.top);
        localObject1 = this.a.iterator();
        i1 = -1;
        do
        {
          do
          {
            do
            {
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localObject2 = (e)((Iterator)localObject1).next();
              i2 = i1 + 1;
              i1 = i2;
            } while (i2 < this.C);
            i1 = i2;
          } while (i2 >= this.a.size() - this.E);
          i1 = i2;
        } while (((e)localObject2).g);
        bool2 = ((e)localObject2).i();
        if (!this.n) {
          break label676;
        }
      }
      for (long l1 = SystemClock.elapsedRealtime() - this.o;; l1 = 0L)
      {
        ((e)localObject2).h = l1;
        ((e)localObject2).a(paramCanvas);
        bool1 |= bool2;
        i1 = i2;
        break label161;
        i1 = 0;
        break;
        if ((this.e == this.F) && (this.p) && (this.G == getWidth()) && (this.H == getHeight())) {
          break label84;
        }
        this.C = 0;
        this.E = 0;
        this.F = this.e;
        this.G = getWidth();
        this.H = getHeight();
        this.p = true;
        this.B = b(this.B);
        e locale;
        if (this.B != null)
        {
          this.B.eraseColor(0);
          localObject1 = new Canvas(this.B);
          ((Canvas)localObject1).scale(this.x, this.x);
          ((Canvas)localObject1).concat(this.m);
          ((Canvas)localObject1).translate(-this.i.left, -this.i.top);
          localObject2 = this.a.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            locale = (e)((Iterator)localObject2).next();
            if (locale == this.F) {
              break;
            }
            this.C += 1;
            if (!locale.g) {
              locale.a((Canvas)localObject1);
            }
          }
        }
        this.D = b(this.D);
        if (this.D == null) {
          break label84;
        }
        this.D.eraseColor(0);
        localObject1 = new Canvas(this.D);
        ((Canvas)localObject1).scale(this.x, this.x);
        ((Canvas)localObject1).concat(this.m);
        ((Canvas)localObject1).translate(-this.i.left, -this.i.top);
        localObject2 = this.a.iterator();
        i1 = 0;
        while (((Iterator)localObject2).hasNext())
        {
          locale = (e)((Iterator)localObject2).next();
          if (locale == this.F)
          {
            i1 = 1;
          }
          else if (i1 != 0)
          {
            this.E += 1;
            if (!locale.g) {
              locale.a((Canvas)localObject1);
            }
          }
        }
        break label84;
      }
      paramCanvas.restore();
      if (this.E > 0) {
        paramCanvas.drawBitmap(this.D, 0.0F, 0.0F, this.A);
      }
    } while ((!this.n) || (!bool1));
    invalidate();
  }
  
  public final void e()
  {
    this.n = false;
    invalidate();
  }
  
  public RectF getBitmapRect()
  {
    return this.j;
  }
  
  public RectF getCropRect()
  {
    return this.i;
  }
  
  public e getCurrentShape()
  {
    return this.e;
  }
  
  public b getDoodle()
  {
    return new b(this.j, this.i, this.l, this.a);
  }
  
  public int getEditsCount()
  {
    return this.a.size();
  }
  
  public float getStrokeScale()
  {
    return this.k;
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (this.c) {}
    do
    {
      return false;
      this.e = a(paramMotionEvent);
      this.g = null;
      this.h = null;
    } while (this.e == null);
    this.f.a(new u.b(this.e, this.a));
    this.a.remove(this.e);
    this.a.add(this.e);
    this.p = false;
    invalidate();
    return false;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.i == null) {
      return;
    }
    RectF localRectF = new RectF(this.i);
    this.m.mapRect(localRectF);
    paramInt2 = getMeasuredWidth();
    paramInt1 = getMeasuredHeight();
    float f1 = localRectF.width() / localRectF.height();
    if (1.0F * paramInt2 / paramInt1 < f1) {
      paramInt1 = (int)(paramInt2 / f1);
    }
    for (;;)
    {
      this.x = (paramInt2 / localRectF.width());
      if ((this.k == 0.0F) || (this.a.isEmpty()))
      {
        this.k = this.x;
        this.q = (this.r / this.k);
      }
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      paramInt2 = (int)(paramInt1 * f1);
    }
  }
  
  /* Error */
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    // Byte code:
    //   0: aload_1
    //   1: checkcast 16	com/whatsapp/doodle/DoodleView$SavedState
    //   4: astore 4
    //   6: aload 4
    //   8: invokestatic 494	com/whatsapp/doodle/DoodleView$SavedState:a	(Lcom/whatsapp/doodle/DoodleView$SavedState;)Ljava/lang/String;
    //   11: invokestatic 499	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifne +375 -> 389
    //   17: new 446	com/whatsapp/doodle/a/b
    //   20: dup
    //   21: invokespecial 500	com/whatsapp/doodle/a/b:<init>	()V
    //   24: astore_1
    //   25: aload_1
    //   26: aload 4
    //   28: invokestatic 494	com/whatsapp/doodle/DoodleView$SavedState:a	(Lcom/whatsapp/doodle/DoodleView$SavedState;)Ljava/lang/String;
    //   31: aload_0
    //   32: invokevirtual 222	com/whatsapp/doodle/DoodleView:getContext	()Landroid/content/Context;
    //   35: invokevirtual 503	com/whatsapp/doodle/a/b:a	(Ljava/lang/String;Landroid/content/Context;)V
    //   38: aload_0
    //   39: aload_1
    //   40: getfield 505	com/whatsapp/doodle/a/b:b	Landroid/graphics/RectF;
    //   43: putfield 273	com/whatsapp/doodle/DoodleView:j	Landroid/graphics/RectF;
    //   46: aload_0
    //   47: aload_1
    //   48: getfield 507	com/whatsapp/doodle/a/b:c	Landroid/graphics/RectF;
    //   51: putfield 268	com/whatsapp/doodle/DoodleView:i	Landroid/graphics/RectF;
    //   54: aload_0
    //   55: aload_1
    //   56: getfield 509	com/whatsapp/doodle/a/b:d	I
    //   59: putfield 255	com/whatsapp/doodle/DoodleView:l	I
    //   62: aload_0
    //   63: getfield 84	com/whatsapp/doodle/DoodleView:a	Ljava/util/ArrayList;
    //   66: invokevirtual 512	java/util/ArrayList:clear	()V
    //   69: aload_0
    //   70: getfield 84	com/whatsapp/doodle/DoodleView:a	Ljava/util/ArrayList;
    //   73: aload_1
    //   74: getfield 513	com/whatsapp/doodle/a/b:a	Ljava/util/ArrayList;
    //   77: invokevirtual 517	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   80: pop
    //   81: aload_0
    //   82: getfield 91	com/whatsapp/doodle/DoodleView:f	Lcom/whatsapp/doodle/u;
    //   85: astore 5
    //   87: aload 4
    //   89: invokestatic 519	com/whatsapp/doodle/DoodleView$SavedState:b	(Lcom/whatsapp/doodle/DoodleView$SavedState;)Ljava/lang/String;
    //   92: astore_1
    //   93: aload_0
    //   94: getfield 84	com/whatsapp/doodle/DoodleView:a	Ljava/util/ArrayList;
    //   97: astore 6
    //   99: new 521	org/json/JSONObject
    //   102: dup
    //   103: aload_1
    //   104: invokespecial 523	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   107: ldc_w 525
    //   110: invokevirtual 529	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   113: astore 7
    //   115: aload 5
    //   117: getfield 400	com/whatsapp/doodle/u:a	Ljava/util/LinkedList;
    //   120: invokevirtual 530	java/util/LinkedList:clear	()V
    //   123: iconst_0
    //   124: istore_3
    //   125: iload_3
    //   126: aload 7
    //   128: invokevirtual 535	org/json/JSONArray:length	()I
    //   131: if_icmpge +258 -> 389
    //   134: aload 7
    //   136: iload_3
    //   137: invokevirtual 539	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   140: astore 8
    //   142: aload 8
    //   144: ldc_w 541
    //   147: invokevirtual 545	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   150: astore_1
    //   151: iconst_m1
    //   152: istore_2
    //   153: aload_1
    //   154: invokevirtual 550	java/lang/String:hashCode	()I
    //   157: lookupswitch	default:+277->434, 49116392:+116->273, 1021915016:+131->288, 1953129077:+161->318, 1971936087:+146->303
    //   200: aload_1
    //   201: ifnull +54 -> 255
    //   204: aload_1
    //   205: aload 8
    //   207: invokevirtual 555	com/whatsapp/doodle/u$e:b	(Lorg/json/JSONObject;)V
    //   210: aload 8
    //   212: ldc_w 557
    //   215: invokevirtual 561	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   218: istore_2
    //   219: iload_2
    //   220: iflt +35 -> 255
    //   223: iload_2
    //   224: aload 6
    //   226: invokevirtual 150	java/util/ArrayList:size	()I
    //   229: if_icmpge +26 -> 255
    //   232: aload_1
    //   233: aload 6
    //   235: iload_2
    //   236: invokevirtual 154	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   239: checkcast 156	com/whatsapp/doodle/a/e
    //   242: putfield 563	com/whatsapp/doodle/u$e:a	Lcom/whatsapp/doodle/a/e;
    //   245: aload 5
    //   247: getfield 400	com/whatsapp/doodle/u:a	Ljava/util/LinkedList;
    //   250: aload_1
    //   251: invokevirtual 564	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   254: pop
    //   255: iload_3
    //   256: iconst_1
    //   257: iadd
    //   258: istore_3
    //   259: goto -134 -> 125
    //   262: astore_1
    //   263: ldc_w 566
    //   266: aload_1
    //   267: invokestatic 569	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   270: goto -189 -> 81
    //   273: aload_1
    //   274: ldc_w 571
    //   277: invokevirtual 574	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   280: ifeq +154 -> 434
    //   283: iconst_0
    //   284: istore_2
    //   285: goto +149 -> 434
    //   288: aload_1
    //   289: ldc_w 576
    //   292: invokevirtual 574	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   295: ifeq +139 -> 434
    //   298: iconst_1
    //   299: istore_2
    //   300: goto +134 -> 434
    //   303: aload_1
    //   304: ldc_w 578
    //   307: invokevirtual 574	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   310: ifeq +124 -> 434
    //   313: iconst_2
    //   314: istore_2
    //   315: goto +119 -> 434
    //   318: aload_1
    //   319: ldc_w 580
    //   322: invokevirtual 574	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   325: ifeq +109 -> 434
    //   328: iconst_3
    //   329: istore_2
    //   330: goto +104 -> 434
    //   333: new 582	com/whatsapp/doodle/u$a
    //   336: dup
    //   337: iconst_0
    //   338: invokespecial 585	com/whatsapp/doodle/u$a:<init>	(B)V
    //   341: astore_1
    //   342: goto -142 -> 200
    //   345: new 374	com/whatsapp/doodle/u$c
    //   348: dup
    //   349: iconst_0
    //   350: invokespecial 586	com/whatsapp/doodle/u$c:<init>	(B)V
    //   353: astore_1
    //   354: goto -154 -> 200
    //   357: new 588	com/whatsapp/doodle/u$d
    //   360: dup
    //   361: iconst_0
    //   362: invokespecial 589	com/whatsapp/doodle/u$d:<init>	(B)V
    //   365: astore_1
    //   366: goto -166 -> 200
    //   369: new 457	com/whatsapp/doodle/u$b
    //   372: dup
    //   373: iconst_0
    //   374: invokespecial 590	com/whatsapp/doodle/u$b:<init>	(B)V
    //   377: astore_1
    //   378: goto -178 -> 200
    //   381: astore_1
    //   382: ldc_w 592
    //   385: aload_1
    //   386: invokestatic 569	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   389: aload_0
    //   390: aload 4
    //   392: invokestatic 595	com/whatsapp/doodle/DoodleView$SavedState:c	(Lcom/whatsapp/doodle/DoodleView$SavedState;)Z
    //   395: putfield 86	com/whatsapp/doodle/DoodleView:c	Z
    //   398: aload_0
    //   399: aload 4
    //   401: invokestatic 598	com/whatsapp/doodle/DoodleView$SavedState:d	(Lcom/whatsapp/doodle/DoodleView$SavedState;)F
    //   404: putfield 218	com/whatsapp/doodle/DoodleView:r	F
    //   407: aload_0
    //   408: invokevirtual 600	com/whatsapp/doodle/DoodleView:a	()V
    //   411: aload_0
    //   412: invokevirtual 603	com/whatsapp/doodle/DoodleView:requestLayout	()V
    //   415: aload_0
    //   416: iconst_0
    //   417: putfield 386	com/whatsapp/doodle/DoodleView:p	Z
    //   420: aload_0
    //   421: invokevirtual 325	com/whatsapp/doodle/DoodleView:invalidate	()V
    //   424: aload_0
    //   425: aload 4
    //   427: invokevirtual 607	com/whatsapp/doodle/DoodleView$SavedState:getSuperState	()Landroid/os/Parcelable;
    //   430: invokespecial 609	android/view/View:onRestoreInstanceState	(Landroid/os/Parcelable;)V
    //   433: return
    //   434: iload_2
    //   435: tableswitch	default:+29->464, 0:+-102->333, 1:+-90->345, 2:+-78->357, 3:+-66->369
    //   464: aconst_null
    //   465: astore_1
    //   466: goto -266 -> 200
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	469	0	this	DoodleView
    //   0	469	1	paramParcelable	Parcelable
    //   152	283	2	i1	int
    //   124	135	3	i2	int
    //   4	422	4	localSavedState	SavedState
    //   85	161	5	localu	u
    //   97	137	6	localArrayList	ArrayList
    //   113	22	7	localJSONArray	JSONArray
    //   140	71	8	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   25	81	262	org/json/JSONException
    //   81	123	381	org/json/JSONException
    //   125	151	381	org/json/JSONException
    //   153	200	381	org/json/JSONException
    //   204	219	381	org/json/JSONException
    //   223	255	381	org/json/JSONException
    //   273	283	381	org/json/JSONException
    //   288	298	381	org/json/JSONException
    //   303	313	381	org/json/JSONException
    //   318	328	381	org/json/JSONException
    //   333	342	381	org/json/JSONException
    //   345	354	381	org/json/JSONException
    //   357	366	381	org/json/JSONException
    //   369	378	381	org/json/JSONException
  }
  
  public Parcelable onSaveInstanceState()
  {
    Object localObject2 = null;
    Parcelable localParcelable = super.onSaveInstanceState();
    if ((this.j != null) && (this.i != null)) {}
    for (;;)
    {
      try
      {
        str1 = new b(this.j, this.i, this.l, this.a).e();
        try
        {
          Object localObject3 = this.f;
          ArrayList localArrayList = this.a;
          localJSONObject1 = new JSONObject();
          localJSONObject1.put("version", 1);
          localJSONArray = new JSONArray();
          localObject3 = ((u)localObject3).a.iterator();
          if (((Iterator)localObject3).hasNext())
          {
            u.e locale = (u.e)((Iterator)localObject3).next();
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("shape_index", localArrayList.indexOf(locale.a));
            localJSONObject2.put("type", locale.a());
            locale.a(localJSONObject2);
            localJSONArray.put(localJSONObject2);
            continue;
            return new SavedState(localParcelable, str1, (String)localObject2, this.c, this.r, (byte)0);
          }
        }
        catch (JSONException localJSONException2)
        {
          Log.d("error saving undo", localJSONException2);
        }
      }
      catch (JSONException localJSONException1)
      {
        String str1;
        JSONObject localJSONObject1;
        JSONArray localJSONArray;
        Log.d("error saving doodle", localJSONException1);
        localObject1 = null;
        continue;
        localJSONObject1.put("actions", localJSONArray);
        String str2 = localJSONObject1.toString();
        localObject2 = str2;
        continue;
      }
      Object localObject1 = null;
    }
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (this.e != null)
    {
      this.e.b(paramScaleGestureDetector.getScaleFactor(), ((n)paramScaleGestureDetector).a);
      invalidate();
    }
    return true;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (this.c) {}
    do
    {
      return false;
      this.e = a(paramMotionEvent);
      this.g = null;
      this.h = null;
    } while (this.d == null);
    this.d.b(this.e);
    return false;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isEnabled()) {
      return false;
    }
    Object localObject;
    float f1;
    float f2;
    float f3;
    switch (paramMotionEvent.getActionMasked())
    {
    case 4: 
    default: 
      this.t.a(paramMotionEvent);
      this.u.onTouchEvent(paramMotionEvent);
      localObject = this.v;
      if ((paramMotionEvent.getPointerCount() == 2) && (paramMotionEvent.getActionMasked() == 2))
      {
        f1 = paramMotionEvent.getX(1) - paramMotionEvent.getX(0);
        f2 = paramMotionEvent.getY(1) - paramMotionEvent.getY(0);
        f3 = (float)Math.atan2(f2, f1);
        if ((((m)localObject).b != 0.0F) && (((m)localObject).c != 0.0F) && (f3 != ((m)localObject).d)) {
          ((m)localObject).a.a((float)Math.toDegrees(f3 - ((m)localObject).d));
        }
        ((m)localObject).b = f1;
        ((m)localObject).c = f2;
        ((m)localObject).d = f3;
        label204:
        localObject = this.w;
        switch (paramMotionEvent.getActionMasked())
        {
        }
      }
      break;
    }
    for (;;)
    {
      return true;
      if (this.c)
      {
        localObject = new d();
        ((d)localObject).a(this.b);
        ((d)localObject).a(this.q);
        ((d)localObject).a(b(paramMotionEvent));
        this.a.add(localObject);
        this.f.a(new u.a((e)localObject));
        this.g = null;
        this.h = null;
        this.e = ((e)localObject);
        invalidate();
      }
      while (this.d != null)
      {
        this.d.a();
        break;
        this.e = a(paramMotionEvent);
        if (this.e != null)
        {
          if (this.d != null) {
            this.d.a(this.e);
          }
          if (this.e.b()) {
            this.q = this.e.f();
          }
          if ((this.e.c()) && (this.e.f.getColor() != 0)) {
            this.b = this.e.f.getColor();
          }
        }
      }
      if ((this.e instanceof d)) {
        if (this.c)
        {
          ((d)this.e).b(b(paramMotionEvent));
          invalidate();
        }
      }
      while ((this.e != null) && (this.e != this.g) && (this.e.d()))
      {
        this.h = this.e.e();
        this.g = this.e;
        break;
        if ((this.e != null) && (paramMotionEvent.getPointerCount() == 1) && (this.d != null)) {
          this.d.a(paramMotionEvent.getX(), paramMotionEvent.getY());
        }
      }
      if (paramMotionEvent.getPointerCount() != 1) {
        break;
      }
      if ((this.g != null) && (this.g == this.e) && (this.e.d()))
      {
        localObject = this.e;
        e.b localb = this.h;
        if ((localb.b.equals(((e)localObject).d)) && (((e)localObject).e == localb.a) && (((e)localObject).f.getColor() == localb.c) && (((e)localObject).f.getStrokeWidth() == localb.d)) {
          break label800;
        }
      }
      label800:
      for (int i1 = 1;; i1 = 0)
      {
        if (i1 != 0) {
          this.f.a(new u.d(this.e, this.h));
        }
        this.g = null;
        this.h = null;
        if (this.d == null) {
          break;
        }
        this.d.b();
        if ((this.e == null) || (!this.e.d())) {
          break;
        }
        this.d.a(this.e, paramMotionEvent.getX(), paramMotionEvent.getY());
        break;
      }
      ((m)localObject).d = 0.0F;
      ((m)localObject).c = 0.0F;
      ((m)localObject).b = 0.0F;
      break label204;
      l.a(((l)localObject).b, paramMotionEvent);
      ((l)localObject).d = true;
      continue;
      l.a(((l)localObject).c, paramMotionEvent);
      if ((((l)localObject).d) && (((l)localObject).a != null))
      {
        f1 = ((l)localObject).c.x;
        f2 = ((l)localObject).b.x;
        f3 = ((l)localObject).c.y;
        float f4 = ((l)localObject).b.y;
        ((l)localObject).a.b(f1 - f2, f3 - f4);
      }
      ((l)localObject).b.set(((l)localObject).c);
      ((l)localObject).d = true;
      continue;
      ((l)localObject).d = false;
    }
  }
  
  public void setBitmapRect(RectF paramRectF)
  {
    this.j = paramRectF;
    this.k = 0.0F;
  }
  
  public void setCropRect(RectF paramRectF)
  {
    this.i = paramRectF;
    a();
    requestLayout();
    this.p = false;
    invalidate();
  }
  
  public void setCurrentShape(e parame)
  {
    this.e = parame;
  }
  
  public void setDoodle(b paramb)
  {
    this.j = paramb.b;
    this.i = paramb.c;
    this.l = paramb.d;
    this.a.clear();
    this.a.addAll(paramb.a);
    a();
    requestLayout();
    this.p = false;
    invalidate();
  }
  
  public void setListener(a parama)
  {
    this.d = parama;
  }
  
  public void setPenMode(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void setStrictTouch(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }
  
  public void setStrokeColor(int paramInt)
  {
    this.b = paramInt;
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
    private final String a;
    private final String b;
    private final float c;
    private final boolean d;
    
    private SavedState(Parcel paramParcel)
    {
      super();
      this.a = paramParcel.readString();
      this.b = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.d = bool;
        this.c = paramParcel.readFloat();
        return;
        bool = false;
      }
    }
    
    private SavedState(Parcelable paramParcelable, String paramString1, String paramString2, boolean paramBoolean, float paramFloat)
    {
      super();
      this.a = paramString1;
      this.b = paramString2;
      this.d = paramBoolean;
      this.c = paramFloat;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.a);
      paramParcel.writeString(this.b);
      if (this.d) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeFloat(this.c);
        return;
      }
    }
  }
  
  static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(float paramFloat1, float paramFloat2);
    
    public abstract void a(e parame);
    
    public abstract void a(e parame, float paramFloat1, float paramFloat2);
    
    public abstract void b();
    
    public abstract void b(e parame);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/doodle/DoodleView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */