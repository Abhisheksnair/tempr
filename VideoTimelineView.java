package com.whatsapp;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.io.File;
import java.util.ArrayList;

public class VideoTimelineView
  extends View
{
  public File a;
  public long b;
  public long c;
  public long d;
  public ArrayList<Bitmap> e;
  public AsyncTask<Void, Bitmap, Void> f;
  public int g;
  private long h;
  private final Paint i = new Paint(1);
  private final RectF j = new RectF();
  private final Rect k = new Rect();
  private int l;
  private float m;
  private float n;
  private float o;
  private float p;
  private float q = 1.0F;
  private int r = -1;
  private float s = 12.0F;
  private int t = -1;
  private float u = 12.0F;
  private int v = -1;
  private int w = 855638016;
  private a x;
  private c y;
  
  public VideoTimelineView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public VideoTimelineView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public VideoTimelineView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  @TargetApi(21)
  public VideoTimelineView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext, paramAttributeSet);
  }
  
  private int a(long paramLong)
  {
    int i1 = (int)(getPaddingLeft() + getTimelineWidth() * paramLong / this.b);
    return Math.min(getPaddingLeft() + getTimelineWidth(), Math.max(getPaddingLeft(), i1));
  }
  
  private void a(float paramFloat)
  {
    if ((this.m == paramFloat) || (this.g == 0)) {
      return;
    }
    float f1 = paramFloat - this.n;
    switch (2.a[(this.g - 1)])
    {
    }
    for (;;)
    {
      this.m = paramFloat;
      invalidate();
      if (this.x == null) {
        break;
      }
      this.x.a(this.c, this.d);
      return;
      this.c = Math.min(b(f1 + this.o), this.d);
      if (this.d - this.c > this.h)
      {
        this.d = (this.c + this.h);
        continue;
        this.d = Math.max(b(f1 + this.p), this.c);
        if (this.d - this.c > this.h)
        {
          this.c = (this.d - this.h);
          continue;
          long l1 = this.d - this.c;
          this.c = b(this.o + f1);
          if (this.c == 0L)
          {
            this.d = (this.c + l1);
          }
          else
          {
            this.d = b(f1 + this.p);
            if (this.d == this.b) {
              this.c = (this.d - l1);
            }
          }
        }
      }
    }
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, adn.VideoTimelineView);
      this.q = paramContext.getDimension(5, this.q);
      this.r = paramContext.getInteger(4, this.r);
      this.s = paramContext.getDimension(1, this.s);
      this.t = paramContext.getInteger(0, this.t);
      this.u = paramContext.getDimension(3, this.u);
      this.v = paramContext.getInteger(2, this.v);
      this.w = paramContext.getInteger(6, this.w);
      paramContext.recycle();
    }
  }
  
  private long b(float paramFloat)
  {
    long l1 = ((float)this.b * (paramFloat - getPaddingLeft()) / getTimelineWidth());
    return Math.min(this.b, Math.max(l1, 0L));
  }
  
  private int getTimelineHeight()
  {
    return Math.max(0, getHeight() - getPaddingTop() - getPaddingBottom());
  }
  
  private int getTimelineWidth()
  {
    return Math.max(0, getWidth() - getPaddingLeft() - getPaddingRight());
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.a == null) {
      if (isInEditMode())
      {
        this.i.setStyle(Paint.Style.FILL);
        this.i.setColor(this.w);
        this.j.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        paramCanvas.drawRect(this.j, this.i);
      }
    }
    int i1;
    int i2;
    final int i3;
    do
    {
      do
      {
        return;
        i1 = getTimelineWidth();
        i2 = getTimelineHeight();
      } while ((i2 <= 0) || (i1 <= 0));
      if (this.l != i1)
      {
        this.l = i1;
        this.e = null;
        if (this.f != null)
        {
          this.f.cancel(true);
          this.f = null;
        }
      }
      if (this.e != null) {
        break;
      }
      if (this.f == null)
      {
        i3 = i1 / i2;
        f1 = i2;
        f2 = i1 / i3;
        this.e = new ArrayList(i3);
        this.f = new AsyncTask()
        {
          long a;
          
          private Void a()
          {
            MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
            localMediaMetadataRetriever.setDataSource(VideoTimelineView.a(VideoTimelineView.this).getAbsolutePath());
            long l1 = Long.parseLong(localMediaMetadataRetriever.extractMetadata(9));
            this.a = System.currentTimeMillis();
            RectF localRectF = new RectF(0.0F, 0.0F, f2, f1);
            Rect localRect = new Rect();
            int i = 0;
            for (;;)
            {
              long l2;
              if (i < i3)
              {
                if (isCancelled()) {
                  return null;
                }
                l2 = 1000L * l1 * i / i3;
              }
              try
              {
                Bitmap localBitmap = localMediaMetadataRetriever.getFrameAtTime(l2);
                if (localBitmap != null)
                {
                  j = localBitmap.getWidth();
                  k = localBitmap.getHeight();
                  if ((j > f2) && (k > f1))
                  {
                    localObject2 = Bitmap.createBitmap((int)f2, (int)f1, localBitmap.getConfig());
                    if (j > k)
                    {
                      localRect.top = 0;
                      localRect.bottom = k;
                      localRect.left = ((j - k) / 2);
                      localRect.right = (localRect.left + k);
                      new Canvas((Bitmap)localObject2).drawBitmap(localBitmap, localRect, localRectF, VideoTimelineView.b(VideoTimelineView.this));
                      if (localObject2 != localBitmap) {
                        localBitmap.recycle();
                      }
                      publishProgress(new Bitmap[] { localObject2 });
                      i += 1;
                    }
                  }
                }
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  int j;
                  int k;
                  Object localObject1 = null;
                  continue;
                  localRect.left = 0;
                  localRect.right = j;
                  localRect.top = ((k - j) / 2);
                  localRect.bottom = (j + localRect.top);
                }
                localMediaMetadataRetriever.release();
                return null;
              }
              catch (NoSuchMethodError localNoSuchMethodError)
              {
                for (;;)
                {
                  continue;
                  Object localObject2 = localNoSuchMethodError;
                }
              }
            }
          }
        };
        this.f.execute(new Void[0]);
      }
    } while (this.x == null);
    float f3 = a(this.c);
    final float f2 = a(this.d);
    this.i.setStyle(Paint.Style.FILL);
    this.i.setColor(this.w);
    this.j.set(getPaddingLeft(), getPaddingTop(), f3, getHeight() - getPaddingBottom());
    paramCanvas.drawRect(this.j, this.i);
    this.j.set(f2, getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
    paramCanvas.drawRect(this.j, this.i);
    if (this.y != null)
    {
      long l1 = this.y.b();
      if ((l1 >= 0L) && (l1 >= this.c) && (l1 <= this.d))
      {
        this.i.setColor(this.r);
        this.i.setStyle(Paint.Style.STROKE);
        this.i.setStrokeWidth(this.q / 2.0F);
        f1 = a(l1);
        paramCanvas.drawLine(f1, getPaddingTop(), f1, getHeight() - getPaddingBottom(), this.i);
      }
      if (this.y.a()) {
        invalidate();
      }
    }
    this.i.setColor(this.r);
    this.i.setStyle(Paint.Style.STROKE);
    this.i.setStrokeWidth(this.q);
    this.j.set(f3 - 1.0F, getPaddingTop(), f2 + 1.0F, getHeight() - getPaddingBottom());
    paramCanvas.drawRect(this.j, this.i);
    this.i.setStyle(Paint.Style.FILL);
    Object localObject = this.i;
    if (this.g == b.a)
    {
      i1 = this.v;
      label595:
      ((Paint)localObject).setColor(i1);
      float f4 = getPaddingTop() + i2 / 2;
      if (this.g != b.a) {
        break label977;
      }
      f1 = this.u;
      label629:
      paramCanvas.drawCircle(f3, f4, f1, this.i);
      localObject = this.i;
      if (this.g != b.b) {
        break label985;
      }
      i1 = this.v;
      label664:
      ((Paint)localObject).setColor(i1);
      f3 = getPaddingTop() + i2 / 2;
      if (this.g != b.b) {
        break label994;
      }
    }
    label756:
    label917:
    label977:
    label985:
    label994:
    for (final float f1 = this.u;; f1 = this.s)
    {
      paramCanvas.drawCircle(f2, f3, f1, this.i);
      return;
      i3 = i1 / i2;
      f1 = i1 / i3;
      this.j.top = getPaddingTop();
      this.j.bottom = (getPaddingTop() + i2);
      i1 = 0;
      int i4;
      if (i1 < this.e.size())
      {
        this.j.left = (getPaddingLeft() + i1 * f1);
        this.j.right = (this.j.left + f1);
        localObject = (Bitmap)this.e.get(i1);
        if (localObject != null)
        {
          i3 = ((Bitmap)localObject).getWidth();
          i4 = ((Bitmap)localObject).getHeight();
          if (i3 <= i4) {
            break label917;
          }
          this.k.top = 0;
          this.k.bottom = i4;
          this.k.left = ((i3 - i4) / 2);
          this.k.right = (i4 + this.k.left);
        }
      }
      for (;;)
      {
        paramCanvas.drawBitmap((Bitmap)localObject, this.k, this.j, this.i);
        i1 += 1;
        break label756;
        break;
        this.k.left = 0;
        this.k.right = i3;
        this.k.top = ((i4 - i3) / 2);
        this.k.bottom = (i3 + this.k.top);
      }
      i1 = this.t;
      break label595;
      f1 = this.s;
      break label629;
      i1 = this.t;
      break label664;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i3 = 0;
    boolean bool = false;
    if (this.x == null) {
      bool = super.onTouchEvent(paramMotionEvent);
    }
    while (!isEnabled()) {
      return bool;
    }
    int i1 = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    switch (i1 & 0xFF)
    {
    }
    for (;;)
    {
      return true;
      this.n = f1;
      this.o = a(this.c);
      this.p = a(this.d);
      float f2 = a(this.c);
      float f3 = a(this.d);
      float f4 = Math.max(this.s, Math.min(getTimelineWidth() / 3, getTimelineHeight()));
      label168:
      int i2;
      if (Math.abs(f1 - f2) < f4)
      {
        i1 = 1;
        if (Math.abs(f1 - f3) >= f4) {
          break label247;
        }
        i2 = 1;
        label184:
        if ((i1 == 0) || (i2 == 0)) {
          break label341;
        }
        if (f1 >= f2) {
          break label253;
        }
        i1 = b.a;
      }
      for (;;)
      {
        this.g = i1;
        if ((this.g == 0) || (this.x == null)) {
          break;
        }
        this.x.a();
        invalidate();
        break;
        i1 = 0;
        break label168;
        label247:
        i2 = 0;
        break label184;
        label253:
        if (f1 > f3)
        {
          i1 = b.b;
        }
        else
        {
          f2 = Math.abs(f1 - f2) - Math.abs(f1 - f3);
          if (f2 < 0.0F)
          {
            i1 = b.a;
          }
          else if (f2 > 0.0F)
          {
            i1 = b.b;
          }
          else if (f1 / getWidth() > 0.5F)
          {
            i1 = b.a;
          }
          else
          {
            i1 = b.b;
            continue;
            label341:
            if (i1 != 0)
            {
              i1 = b.a;
            }
            else if (i2 != 0)
            {
              i1 = b.b;
            }
            else
            {
              i1 = i3;
              if (f1 > f2 + f4)
              {
                i1 = i3;
                if (f1 < f3 - f4) {
                  i1 = b.c;
                }
              }
            }
          }
        }
      }
      a(f1);
      continue;
      a(f1);
      if (this.x != null) {
        this.x.b();
      }
      this.g = 0;
      invalidate();
    }
  }
  
  public void setMaxTrim(long paramLong)
  {
    this.h = paramLong;
  }
  
  public void setTrimListener(a parama)
  {
    this.x = parama;
  }
  
  public void setVideoPlayback(c paramc)
  {
    this.y = paramc;
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(long paramLong1, long paramLong2);
    
    public abstract void b();
  }
  
  public static enum b
  {
    public static int[] a()
    {
      return (int[])d.clone();
    }
  }
  
  public static abstract interface c
  {
    public abstract boolean a();
    
    public abstract long b();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/VideoTimelineView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */