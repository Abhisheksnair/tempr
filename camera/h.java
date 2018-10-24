package com.whatsapp.camera;

import a.a.a.a.d;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.hardware.Camera;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Vibrator;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetBehavior.a;
import android.support.v4.app.Fragment;
import android.support.v4.content.b;
import android.support.v4.view.ab;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.p;
import android.text.format.DateUtils;
import android.view.Display;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.whatsapp.CircularProgressBar;
import com.whatsapp.aic;
import com.whatsapp.and;
import com.whatsapp.anz;
import com.whatsapp.atu;
import com.whatsapp.gallerypicker.ae.a;
import com.whatsapp.gallerypicker.ao;
import com.whatsapp.gallerypicker.ao.a;
import com.whatsapp.gallerypicker.ao.b;
import com.whatsapp.nh;
import com.whatsapp.oz;
import com.whatsapp.pv;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils;
import com.whatsapp.util.at;
import com.whatsapp.util.bu;
import java.io.File;
import java.util.List;

public abstract class h
{
  b A;
  ao B;
  boolean C;
  final Handler D = new Handler(Looper.getMainLooper())
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      paramAnonymousMessage = h.this;
      if (paramAnonymousMessage.d.c)
      {
        long l1 = System.currentTimeMillis() - paramAnonymousMessage.j;
        paramAnonymousMessage.g.setText(DateUtils.formatElapsedTime((int)(l1 / 1000L)));
        paramAnonymousMessage.D.sendEmptyMessageDelayed(0, 50L);
        long l2;
        boolean bool;
        if (paramAnonymousMessage.k != null)
        {
          l2 = paramAnonymousMessage.k.length();
          bool = com.whatsapp.protocol.j.c(paramAnonymousMessage.c);
          if ((l2 <= aic.s * 1048576L) && ((!bool) || (l1 < aic.f()))) {
            break label122;
          }
          paramAnonymousMessage.b(true);
        }
        for (;;)
        {
          paramAnonymousMessage.i.setVisibility(0);
          return;
          label122:
          int j = (int)(l2 * 100L / (aic.s * 1048576L));
          int i = j;
          if (bool) {
            i = Math.max(j, (int)(l1 * 100L / aic.f()));
          }
          paramAnonymousMessage.h.setProgress(i);
        }
      }
      paramAnonymousMessage.i.setVisibility(8);
    }
  };
  final Handler E = new Handler(Looper.getMainLooper())
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      if ((h.this.d.e) && (!h.this.d.c) && (!d.a(h.this.b)) && (!h.this.r())) {
        h.this.o();
      }
    }
  };
  oz F;
  and G;
  atu H;
  private boolean I;
  private int J;
  private AsyncTask<Void, Void, com.whatsapp.gallerypicker.r> K;
  private View L;
  private pv M;
  private aic N;
  private Runnable O = new Runnable()
  {
    public final void run()
    {
      h.this.d.setVisibility(4);
      h.this.e.setVisibility(4);
      h.this.f.setVisibility(0);
    }
  };
  private long a;
  nh b;
  String c;
  public CameraView d;
  View e;
  View f;
  TextView g;
  CircularProgressBar h;
  View i;
  long j;
  File k;
  File l;
  ImageView m;
  View n;
  ImageView o;
  a p;
  ba q;
  az r;
  TextView s;
  boolean t = true;
  RecyclerView u;
  boolean v = true;
  BottomSheetBehavior w;
  DragBottomSheetIndicator x;
  View y;
  boolean z;
  
  private void a(Uri paramUri, View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = 2;
    Log.i("cameraui/showpreview " + paramUri + " video:" + paramBoolean1);
    if (d.a(this.b)) {
      return;
    }
    Object localObject = null;
    if (paramView != null)
    {
      localObject = new int[2];
      paramView.getLocationInWindow((int[])localObject);
      int[] arrayOfInt = new int[2];
      this.b.findViewById(16908290).getLocationInWindow(arrayOfInt);
      localObject[0] -= arrayOfInt[0];
      localObject[1] -= arrayOfInt[1];
      localObject = new Rect(localObject[0], localObject[1], localObject[0] + paramView.getWidth(), localObject[1] + paramView.getHeight());
    }
    this.L = paramView;
    switch (c())
    {
    default: 
      throw new IllegalStateException("Invalid camera origin:" + c());
    case 1: 
      if (paramBoolean2) {}
      for (;;)
      {
        paramUri = ai.a(this.c, this.a, paramUri, paramBoolean1, (Rect)localObject, paramBoolean2, this.I, i1);
        this.b.j_().a().b(2131755401, paramUri).e();
        return;
        i1 = 10;
      }
    case 2: 
      if (paramBoolean2) {}
      for (i1 = 12;; i1 = 13) {
        break;
      }
    case 3: 
      if (paramBoolean2) {}
      for (i1 = 7;; i1 = 21) {
        break;
      }
    case 4: 
      if (paramBoolean2) {}
      for (i1 = 15;; i1 = 16) {
        break;
      }
    }
    if (paramBoolean2) {}
    for (i1 = 18;; i1 = 19) {
      break;
    }
  }
  
  public abstract void a();
  
  public final void a(long paramLong)
  {
    if (!d()) {
      return;
    }
    this.C = false;
    Fragment localFragment = this.b.j_().a(2131755401);
    if ((localFragment instanceof ai)) {
      this.b.j_().a().a(localFragment).d();
    }
    this.w.setState(4);
    this.d.removeCallbacks(this.O);
    if (this.d.getVisibility() != 4)
    {
      if (paramLong != 0L) {
        break label105;
      }
      this.d.setVisibility(4);
    }
    for (;;)
    {
      this.f.setVisibility(0);
      return;
      label105:
      this.d.postDelayed(this.O, paramLong);
    }
  }
  
  public final void a(final nh paramnh, final com.whatsapp.c.a parama, final pv parampv, oz paramoz, aic paramaic, and paramand, atu paramatu, String paramString, long paramLong, boolean paramBoolean)
  {
    this.b = paramnh;
    this.M = parampv;
    this.F = paramoz;
    this.N = paramaic;
    this.G = paramand;
    this.H = paramatu;
    this.c = paramString;
    this.a = paramLong;
    this.I = paramBoolean;
    this.e = d(2131755413);
    this.d = ((CameraView)d(2131755414));
    this.d.setCameraCallback(new CameraView.a()
    {
      public final void a()
      {
        h.a(h.this, s.a(this));
      }
      
      public final void a(float paramAnonymousFloat)
      {
        if (!h.this.d.c)
        {
          ba localba = h.this.q;
          localba.setVisibility(0);
          localba.a = paramAnonymousFloat;
          localba.invalidate();
          localba.removeCallbacks(localba.c);
        }
        for (;;)
        {
          h.this.c(false);
          return;
          h.this.q.setVisibility(4);
        }
      }
      
      public final void a(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        h.a(h.this, t.a(this, paramAnonymousFloat1, paramAnonymousFloat2));
      }
      
      public final void a(int paramAnonymousInt)
      {
        h.a(h.this, r.a(this, paramAnonymousInt, parampv));
      }
      
      public final void a(boolean paramAnonymousBoolean)
      {
        h.a(h.this, u.a(this, paramAnonymousBoolean));
      }
      
      public final void b()
      {
        ba localba = h.this.q;
        localba.invalidate();
        localba.postDelayed(localba.c, 300L);
      }
      
      public final void b(float paramAnonymousFloat)
      {
        float f2 = h.this.q.getMaxScale();
        if (f2 < 1.0F) {}
        float f1;
        int i;
        do
        {
          return;
          f1 = paramAnonymousFloat;
          if (paramAnonymousFloat > f2) {
            f1 = f2;
          }
          i = Math.round(h.this.d.getMaxZoom() * (f1 - 1.0F) / (f2 - 1.0F));
          i = h.this.d.a(i);
        } while (h.this.d.c);
        ba localba = h.this.q;
        paramAnonymousFloat = i / 100.0F;
        localba.a = f1;
        localba.b = paramAnonymousFloat;
        localba.invalidate();
      }
      
      public final void c()
      {
        h.this.c(false);
      }
    });
    this.d.getViewTreeObserver().addOnGlobalLayoutListener(i.a(this));
    this.f = d(2131755415);
    paramnh = (ViewGroup)d(2131755416);
    this.p = new a(this.b);
    this.p.setVisibility(8);
    paramnh.addView(this.p, -1, -1);
    this.q = new ba(this.b);
    this.q.setVisibility(8);
    paramnh.addView(this.q, -1, -1);
    this.r = new az(this.b);
    paramnh.addView(this.r, -1, -1);
    this.g = ((TextView)d(2131755419));
    this.h = ((CircularProgressBar)d(2131755418));
    this.h.setMax(100);
    this.i = d(2131755417);
    this.n = d(2131755409);
    paramoz = this.n;
    final int i1;
    if (Camera.getNumberOfCameras() <= 1)
    {
      i1 = 8;
      paramoz.setVisibility(i1);
      this.n.setOnClickListener(j.a(this));
      this.o = ((ImageView)d(2131755410));
      this.o.setOnClickListener(k.a(this));
      paramoz = this.o;
      if (this.d.getStoredFlashModeCount() <= 1) {
        break label715;
      }
      i1 = 0;
      label361:
      paramoz.setVisibility(i1);
      this.A = new b(com.whatsapp.u.a());
      if (!this.A.canDetectOrientation()) {
        break label722;
      }
      this.A.enable();
    }
    for (;;)
    {
      this.m = ((ImageView)d(2131755408));
      this.m.setOnClickListener(new at()
      {
        public final void a(View paramAnonymousView)
        {
          if ((!h.this.d.c) && (!h.this.E.hasMessages(0)) && (h.this.k == null)) {
            h.this.p();
          }
        }
      });
      this.m.setOnLongClickListener(l.a(this, paramatu));
      this.m.setOnTouchListener(new View.OnTouchListener()
      {
        boolean a;
        
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          int i = paramAnonymousMotionEvent.getActionMasked();
          if (h.this.d.c) {
            if (i == 1)
            {
              this.a = false;
              h.this.d.postDelayed(v.a(this), 220L);
              if (i != 0) {
                break label278;
              }
              h.this.m.setImageResource(2130840250);
              paramAnonymousView = new ScaleAnimation(1.0F, 1.5F, 1.0F, 1.5F, 1, 0.5F, 1, 0.5F);
              paramAnonymousView.setDuration(220L);
              paramAnonymousView.setInterpolator(new OvershootInterpolator());
              paramAnonymousView.setFillAfter(true);
              h.this.m.startAnimation(paramAnonymousView);
            }
          }
          for (;;)
          {
            return false;
            if ((i == 2) && (paramAnonymousMotionEvent.getPointerCount() == 1))
            {
              this.a = false;
              if (paramAnonymousMotionEvent.getY() >= 0.0F) {
                break;
              }
              int j = h.this.d.getMaxZoom();
              if (j <= 0) {
                break;
              }
              int k = h.this.d.getHeight() / 2;
              float f = Math.min(k, -paramAnonymousMotionEvent.getY()) / k;
              j = (int)(j * f);
              if (j > 0) {}
              for (boolean bool = true;; bool = false)
              {
                this.a = bool;
                h.this.d.a(j);
                break;
              }
            }
            if ((paramAnonymousMotionEvent.getPointerCount() <= 1) || (this.a)) {
              break;
            }
            h.this.d.onTouchEvent(paramAnonymousMotionEvent);
            break;
            this.a = false;
            break;
            label278:
            if ((i == 1) || (i == 3))
            {
              h.this.m.setImageResource(2130837712);
              paramAnonymousView = new ScaleAnimation(1.5F, 1.0F, 1.5F, 1.0F, 1, 0.5F, 1, 0.5F);
              paramAnonymousView.setDuration(220L);
              paramAnonymousView.setInterpolator(new AccelerateDecelerateInterpolator());
              paramAnonymousView.setFillAfter(true);
              h.this.m.startAnimation(paramAnonymousView);
            }
          }
        }
      });
      this.s = ((TextView)d(2131755411));
      this.m.setEnabled(false);
      this.n.setEnabled(false);
      this.o.setEnabled(false);
      a(this.d.getFlashMode());
      this.B = new ao(parama, this.b.getContentResolver(), new Handler(Looper.getMainLooper()));
      this.u = ((RecyclerView)d(2131755405));
      this.u.setHasFixedSize(true);
      i1 = this.b.getResources().getDimensionPixelSize(2131361906);
      this.u.a(new RecyclerView.f()
      {
        public final void a(Rect paramAnonymousRect, View paramAnonymousView, RecyclerView paramAnonymousRecyclerView)
        {
          if (parampv.d())
          {
            paramAnonymousRect.set(0, 0, i1, 0);
            return;
          }
          paramAnonymousRect.set(i1, 0, 0, 0);
        }
      });
      parama = new LinearLayoutManager(this.b);
      parama.b(0);
      this.u.setLayoutManager(parama);
      parama = d(2131755406);
      parampv = d(2131755403);
      parampv.setVisibility(8);
      ab.c(parampv, 0.0F);
      this.x = ((DragBottomSheetIndicator)d(2131755404));
      this.x.setVisibility(8);
      this.y = d(2131755402);
      this.w = BottomSheetBehavior.from(this.y);
      this.w.setBottomSheetCallback(new BottomSheetBehavior.a()
      {
        public final void a(View paramAnonymousView, float paramAnonymousFloat)
        {
          ab.c(parampv, paramAnonymousFloat);
          ab.c(h.this.u, 1.0F - paramAnonymousFloat);
          ab.c(parama, 1.0F - paramAnonymousFloat);
          paramnh.setBackgroundColor((int)(255.0F * paramAnonymousFloat) << 24);
          h.this.x.setOffset(paramAnonymousFloat);
        }
        
        public final void a(View paramAnonymousView, int paramAnonymousInt)
        {
          boolean bool = false;
          if ((paramAnonymousInt == 1) && (!h.a(h.this)))
          {
            h.this.w.setState(4);
            return;
          }
          if (paramAnonymousInt == 3)
          {
            h.this.x.setVisibility(4);
            h.this.u.setVisibility(4);
            parama.setVisibility(4);
            if (paramAnonymousInt != 4) {
              break label247;
            }
            parampv.setVisibility(4);
            paramnh.setBackgroundColor(0);
            if (h.this.d.getWidth() > h.this.d.getHeight()) {
              h.this.y.setVisibility(8);
            }
          }
          for (;;)
          {
            paramAnonymousView = h.this.x;
            if ((paramAnonymousInt == 1) || (paramAnonymousInt == 2)) {
              bool = true;
            }
            paramAnonymousView.setUpdating(bool);
            if (Build.VERSION.SDK_INT < 16) {
              break;
            }
            paramAnonymousView = h.this.b.findViewById(2131755835);
            if (paramAnonymousView == null) {
              break;
            }
            if (paramAnonymousInt != 4) {
              break label312;
            }
            if (!h.this.C) {
              break;
            }
            paramAnonymousView.setSystemUiVisibility(4);
            return;
            paramAnonymousView = h.this.x;
            if (h.a(h.this)) {}
            for (int i = 0;; i = 8)
            {
              paramAnonymousView.setVisibility(i);
              h.this.u.setVisibility(0);
              parama.setVisibility(0);
              break;
            }
            label247:
            paramAnonymousView = h.this;
            if (paramAnonymousView.b != null)
            {
              android.support.v4.app.r localr = paramAnonymousView.b.j_();
              if (localr.a("cameraMediaPickerFragment") == null) {
                localr.a().a(2131755403, c.a(paramAnonymousView.c), "cameraMediaPickerFragment").e();
              }
            }
            parampv.setVisibility(0);
          }
          label312:
          paramAnonymousView.setSystemUiVisibility(1024);
        }
      });
      i();
      return;
      i1 = 0;
      break;
      label715:
      i1 = 8;
      break label361;
      label722:
      this.A = null;
    }
  }
  
  final void a(String paramString)
  {
    int i1;
    int i2;
    if (!"off".equals(paramString)) {
      if ("on".equals(paramString))
      {
        i1 = 2130840010;
        i2 = 2131296801;
        this.o.setContentDescription(this.b.getString(i2));
        if ((this.J == i1) || (this.J == 0)) {
          break label168;
        }
        paramString = new anz(b.a(this.b, this.J), b.a(this.b, i1));
        i2 = paramString.getIntrinsicHeight();
        int i3 = this.o.getPaddingTop();
        paramString.b = 120;
        paramString.c = (i2 + i3);
        paramString.a = 0;
        paramString.invalidateSelf();
        this.o.setImageDrawable(paramString);
      }
    }
    for (;;)
    {
      this.J = i1;
      return;
      if ("auto".equals(paramString))
      {
        i1 = 2130840008;
        i2 = 2131296799;
        break;
      }
      i1 = 2130840009;
      i2 = 2131296800;
      break;
      label168:
      this.o.setImageResource(i1);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    int i3 = 0;
    Log.i("cameraui/previewstopped");
    c(true);
    if (this.L != null) {
      this.L.setVisibility(0);
    }
    this.m.setVisibility(0);
    this.m.setImageResource(2130837712);
    this.s.setVisibility(0);
    this.t = true;
    if (this.d.getVisibility() != 0) {
      this.d.setVisibility(0);
    }
    boolean bool = this.d.e;
    this.m.setEnabled(bool);
    this.n.setEnabled(bool);
    this.o.setEnabled(bool);
    if ((paramBoolean) && (!bool))
    {
      this.d.requestLayout();
      this.d.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          h.this.d.getViewTreeObserver().removeGlobalOnLayoutListener(this);
          CameraView localCameraView = h.this.d;
          localCameraView.a(localCameraView.a);
        }
      });
    }
    this.i.setVisibility(8);
    int i1;
    Object localObject;
    if (this.n.getVisibility() == 0)
    {
      i1 = 1;
      localObject = this.n;
      if (Camera.getNumberOfCameras() > 1) {
        break label444;
      }
    }
    label444:
    for (int i2 = 8;; i2 = 0)
    {
      ((View)localObject).setVisibility(i2);
      if ((i1 == 0) && (this.n.getVisibility() == 0))
      {
        localObject = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
        ((Animation)localObject).setDuration(200L);
        this.n.startAnimation((Animation)localObject);
      }
      i1 = i3;
      if (this.o.getVisibility() == 0) {
        i1 = 1;
      }
      n();
      if ((i1 == 0) && (this.o.getVisibility() == 0))
      {
        localObject = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
        ((Animation)localObject).setDuration(200L);
        this.o.startAnimation((Animation)localObject);
      }
      if ((paramBoolean) && (this.k != null) && (this.k.exists()) && (!this.k.delete())) {
        Log.e("cameraui/failed to delete video " + this.k.getAbsolutePath());
      }
      this.k = null;
      if ((paramBoolean) && (this.l != null) && (this.l.exists()) && (!this.l.delete())) {
        Log.e("cameraui/failed to delete photo " + this.l.getAbsolutePath());
      }
      this.l = null;
      return;
      i1 = 0;
      break;
    }
  }
  
  public final boolean a(int paramInt)
  {
    if (!d()) {}
    while (((paramInt != 25) && (paramInt != 24)) || (!this.d.e) || (r())) {
      return false;
    }
    if ((!this.d.c) && (!this.E.hasMessages(0)))
    {
      Log.i("cameraui/volume-key-down");
      this.m.setPressed(true);
      this.E.sendMessageDelayed(this.E.obtainMessage(0), 500L);
      return true;
    }
    return true;
  }
  
  public abstract void b();
  
  final void b(boolean paramBoolean)
  {
    Log.i("cameraui/stopvideocapture " + paramBoolean);
    this.d.f();
    c(0);
    this.b.setRequestedOrientation(-1);
    try
    {
      if (Settings.System.getInt(this.b.getContentResolver(), "haptic_feedback_enabled") != 0) {
        ((Vibrator)this.b.getSystemService("vibrator")).vibrate(75L);
      }
      if (paramBoolean)
      {
        a(Uri.fromFile(this.k), null, true, true);
        return;
      }
    }
    catch (Settings.SettingNotFoundException localSettingNotFoundException)
    {
      for (;;)
      {
        Log.d("cameraui/stopvideocapture", localSettingNotFoundException);
      }
      if ((this.k != null) && (this.k.exists()) && (!this.k.delete())) {
        Log.e("cameraui/failed to delete video " + this.k.getAbsolutePath());
      }
      this.k = null;
      a(true);
    }
  }
  
  public final boolean b(int paramInt)
  {
    if (!d()) {}
    do
    {
      do
      {
        return false;
      } while ((paramInt != 25) && (paramInt != 24));
      this.E.removeMessages(0);
    } while (r());
    boolean bool;
    if (this.d.c)
    {
      Log.i("cameraui/volume-key-up/stop-video-capture");
      if (System.currentTimeMillis() - this.j > 1000L)
      {
        bool = true;
        b(bool);
      }
    }
    for (;;)
    {
      this.m.setPressed(false);
      return true;
      bool = false;
      break;
      Log.i("cameraui/volume-key-up/take-picture");
      p();
    }
  }
  
  public abstract int c();
  
  final void c(int paramInt)
  {
    int i2 = 1;
    View localView = d(2131755407);
    int i1;
    if (localView.getVisibility() == 0)
    {
      i1 = 1;
      if (paramInt == 0) {
        break label36;
      }
    }
    for (;;)
    {
      if (i1 != i2) {
        break label41;
      }
      return;
      i1 = 0;
      break;
      label36:
      i2 = 0;
    }
    label41:
    WindowManager.LayoutParams localLayoutParams = this.b.getWindow().getAttributes();
    if (paramInt != 0)
    {
      localView.setVisibility(0);
      localView.setBackgroundColor(paramInt);
    }
    for (localLayoutParams.screenBrightness = 1.0F;; localLayoutParams.screenBrightness = -1.0F)
    {
      this.b.getWindow().setAttributes(localLayoutParams);
      return;
      localView.setVisibility(4);
    }
  }
  
  final void c(boolean paramBoolean)
  {
    this.v = paramBoolean;
    if (paramBoolean) {
      if (this.y.getVisibility() != 0) {
        this.y.setVisibility(0);
      }
    }
    while (this.y.getVisibility() == 8) {
      return;
    }
    this.y.setVisibility(8);
    AnimationSet localAnimationSet = new AnimationSet(true);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    localAnimationSet.addAnimation(new AlphaAnimation(1.0F, 0.0F));
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.setDuration(300L);
    this.y.startAnimation(localAnimationSet);
  }
  
  final View d(int paramInt)
  {
    return this.b.findViewById(paramInt);
  }
  
  public final boolean d()
  {
    return this.b != null;
  }
  
  public final boolean e()
  {
    return (this.w == null) || (this.w.getState() != 3);
  }
  
  public final void f()
  {
    if (!d()) {}
    a locala;
    do
    {
      return;
      if (this.K != null)
      {
        this.K.cancel(true);
        this.K = null;
      }
      if (this.B != null)
      {
        this.B.a();
        this.B = null;
      }
      this.D.removeMessages(0);
      this.E.removeMessages(0);
      locala = (a)this.u.getAdapter();
    } while (locala == null);
    locala.d();
  }
  
  public final void g()
  {
    if (!d()) {
      return;
    }
    if (this.d.c) {
      if (System.currentTimeMillis() - this.j <= 1000L) {
        break label74;
      }
    }
    label74:
    for (boolean bool = true;; bool = false)
    {
      b(bool);
      if (this.d.getVisibility() == 0) {
        this.d.setVisibility(8);
      }
      if (this.A == null) {
        break;
      }
      this.A.disable();
      return;
    }
  }
  
  public final void h()
  {
    if (!d()) {}
    do
    {
      return;
      if (this.d.getVisibility() == 8) {
        this.d.setVisibility(0);
      }
    } while (this.A == null);
    this.A.enable();
  }
  
  public final void i()
  {
    if (this.K != null) {
      this.K.cancel(true);
    }
    this.K = new AsyncTask() {};
    bu.a(this.K, new Void[0]);
  }
  
  public final void j()
  {
    if (!d()) {
      throw new IllegalStateException("need to call onCreate first");
    }
    this.C = true;
    this.d.removeCallbacks(this.O);
    this.e.setVisibility(0);
    if (this.d.getVisibility() == 0) {
      this.f.setVisibility(8);
    }
    for (;;)
    {
      c(true);
      return;
      this.d.setVisibility(0);
    }
  }
  
  public final boolean k()
  {
    int i1 = 0;
    if (d())
    {
      Object localObject = this.b.j_();
      Fragment localFragment = ((android.support.v4.app.r)localObject).a(2131755401);
      if ((localFragment instanceof ai))
      {
        ((ai)localFragment).b();
        return true;
      }
      if (this.w.getState() == 3)
      {
        localObject = ((android.support.v4.app.r)localObject).a(2131755403);
        if ((localObject instanceof c))
        {
          localObject = (c)localObject;
          if (((c)localObject).a())
          {
            ((c)localObject).R();
            i1 = 1;
          }
          if (i1 != 0) {}
        }
        else
        {
          this.w.setState(4);
        }
        return true;
      }
    }
    return false;
  }
  
  final void l()
  {
    Log.i("cameraui/videostarted");
    this.d.setVisibility(4);
  }
  
  final void m()
  {
    Log.i("cameraui/previewstarted");
    if (this.L != null) {
      this.L.setVisibility(4);
    }
  }
  
  final void n()
  {
    if (this.d.getFlashModes().size() <= 1)
    {
      this.o.setVisibility(8);
      return;
    }
    this.o.setVisibility(0);
    a(this.d.getFlashMode());
  }
  
  final void o()
  {
    Log.i("cameraui/startvideocapture");
    this.k = MediaFileUtils.a(this.b, this.F, (byte)3, ".mp4");
    int i1 = this.b.getWindowManager().getDefaultDisplay().getRotation();
    int i2;
    switch (this.b.getResources().getConfiguration().orientation)
    {
    default: 
      if ((this.A != null) && (Settings.System.getInt(this.b.getContentResolver(), "accelerometer_rotation", 0) == 0) && (this.A.a != -1))
      {
        i2 = (this.A.a - (4 - i1) % 4) * 90 % 360;
        i1 = i2;
        if (i2 >= 0) {
          break;
        }
      }
      break;
    }
    for (i1 = i2 + 360;; i1 = 0)
    {
      if (this.d.d()) {
        c(-855638017);
      }
      this.d.setKeepScreenOn(true);
      this.d.a(this.k, i1);
      this.D.sendEmptyMessage(0);
      this.h.setProgress(0);
      this.i.setVisibility(0);
      this.s.setVisibility(8);
      this.t = false;
      ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      localScaleAnimation.setDuration(200L);
      this.n.startAnimation(localScaleAnimation);
      this.n.setVisibility(8);
      localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      localScaleAnimation.setDuration(200L);
      this.o.startAnimation(localScaleAnimation);
      this.o.setVisibility(8);
      c(false);
      this.j = System.currentTimeMillis();
      return;
      if ((i1 == 0) || (i1 == 1))
      {
        this.b.setRequestedOrientation(1);
        break;
      }
      this.b.setRequestedOrientation(9);
      break;
      if ((i1 == 0) || (i1 == 1))
      {
        this.b.setRequestedOrientation(0);
        break;
      }
      this.b.setRequestedOrientation(8);
      break;
    }
  }
  
  final void p()
  {
    Log.i("cameraui/takepicture");
    this.m.setEnabled(false);
    this.n.setEnabled(false);
    this.o.setEnabled(false);
    if (this.y.getVisibility() == 0)
    {
      localObject = new AlphaAnimation(1.0F, 0.0F);
      ((Animation)localObject).setDuration(150L);
      this.y.startAnimation((Animation)localObject);
      this.y.setVisibility(8);
    }
    this.v = false;
    Object localObject = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    ((Animation)localObject).setDuration(150L);
    this.n.startAnimation((Animation)localObject);
    this.n.setVisibility(8);
    localObject = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    ((Animation)localObject).setDuration(150L);
    this.o.startAnimation((Animation)localObject);
    this.o.setVisibility(8);
    if (this.d.d())
    {
      c(61650);
      this.d.postDelayed(m.a(this), 300L);
      return;
    }
    q();
  }
  
  final void q()
  {
    this.d.a(new CameraView.c()
    {
      public final void a()
      {
        h.a(h.this, n.a(this));
      }
      
      public final void a(final byte[] paramAnonymousArrayOfByte, final boolean paramAnonymousBoolean)
      {
        Log.i("cameraui/picturetaken");
        h.a(h.this, o.a(this));
        if (paramAnonymousArrayOfByte == null)
        {
          h.a(h.this, p.a(this));
          return;
        }
        if (d.b(h.this.b, h.this.G) < 2013) {
          h.a(h.this, q.a(this));
        }
        h.this.l = MediaFileUtils.a(h.this.b, h.this.F, ".jpeg", (byte)1, 0, false);
        bu.a(new AsyncTask()
        {
          /* Error */
          private Boolean a()
          {
            // Byte code:
            //   0: getstatic 38	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
            //   3: astore_3
            //   4: aconst_null
            //   5: astore 5
            //   7: aconst_null
            //   8: astore_1
            //   9: aconst_null
            //   10: astore 4
            //   12: new 40	java/io/FileOutputStream
            //   15: dup
            //   16: aload_0
            //   17: getfield 19	com/whatsapp/camera/h$3$1:c	Lcom/whatsapp/camera/h$3;
            //   20: getfield 43	com/whatsapp/camera/h$3:a	Lcom/whatsapp/camera/h;
            //   23: getfield 49	com/whatsapp/camera/h:l	Ljava/io/File;
            //   26: invokespecial 52	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
            //   29: astore_2
            //   30: aload_2
            //   31: aload_0
            //   32: getfield 21	com/whatsapp/camera/h$3$1:a	[B
            //   35: invokevirtual 56	java/io/FileOutputStream:write	([B)V
            //   38: aload_2
            //   39: invokevirtual 59	java/io/FileOutputStream:close	()V
            //   42: aload_3
            //   43: astore_1
            //   44: aload_1
            //   45: areturn
            //   46: astore_1
            //   47: getstatic 62	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
            //   50: astore_2
            //   51: new 64	java/lang/StringBuilder
            //   54: dup
            //   55: ldc 66
            //   57: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
            //   60: aload_1
            //   61: invokevirtual 73	java/io/IOException:getMessage	()Ljava/lang/String;
            //   64: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   67: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
            //   70: invokestatic 85	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
            //   73: aload_2
            //   74: areturn
            //   75: astore_3
            //   76: aload 4
            //   78: astore_2
            //   79: aload_2
            //   80: astore_1
            //   81: getstatic 62	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
            //   84: astore 4
            //   86: aload_2
            //   87: astore_1
            //   88: new 64	java/lang/StringBuilder
            //   91: dup
            //   92: ldc 87
            //   94: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
            //   97: aload_3
            //   98: invokevirtual 88	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
            //   101: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   104: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
            //   107: invokestatic 85	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
            //   110: aload 4
            //   112: astore_1
            //   113: aload_2
            //   114: ifnull -70 -> 44
            //   117: aload_2
            //   118: invokevirtual 59	java/io/FileOutputStream:close	()V
            //   121: aload 4
            //   123: areturn
            //   124: astore_1
            //   125: getstatic 62	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
            //   128: astore_2
            //   129: new 64	java/lang/StringBuilder
            //   132: dup
            //   133: ldc 66
            //   135: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
            //   138: aload_1
            //   139: invokevirtual 73	java/io/IOException:getMessage	()Ljava/lang/String;
            //   142: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   145: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
            //   148: invokestatic 85	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
            //   151: aload_2
            //   152: areturn
            //   153: astore_3
            //   154: aload 5
            //   156: astore_2
            //   157: aload_2
            //   158: astore_1
            //   159: getstatic 62	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
            //   162: astore 4
            //   164: aload_2
            //   165: astore_1
            //   166: new 64	java/lang/StringBuilder
            //   169: dup
            //   170: ldc 90
            //   172: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
            //   175: aload_3
            //   176: invokevirtual 73	java/io/IOException:getMessage	()Ljava/lang/String;
            //   179: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   182: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
            //   185: invokestatic 85	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
            //   188: aload 4
            //   190: astore_1
            //   191: aload_2
            //   192: ifnull -148 -> 44
            //   195: aload_2
            //   196: invokevirtual 59	java/io/FileOutputStream:close	()V
            //   199: aload 4
            //   201: areturn
            //   202: astore_1
            //   203: getstatic 62	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
            //   206: astore_2
            //   207: new 64	java/lang/StringBuilder
            //   210: dup
            //   211: ldc 66
            //   213: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
            //   216: aload_1
            //   217: invokevirtual 73	java/io/IOException:getMessage	()Ljava/lang/String;
            //   220: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   223: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
            //   226: invokestatic 85	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
            //   229: aload_2
            //   230: areturn
            //   231: astore_3
            //   232: aload_1
            //   233: astore_2
            //   234: aload_3
            //   235: astore_1
            //   236: aload_2
            //   237: ifnull +7 -> 244
            //   240: aload_2
            //   241: invokevirtual 59	java/io/FileOutputStream:close	()V
            //   244: aload_1
            //   245: athrow
            //   246: astore_2
            //   247: getstatic 62	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
            //   250: astore_3
            //   251: new 64	java/lang/StringBuilder
            //   254: dup
            //   255: ldc 66
            //   257: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
            //   260: aload_2
            //   261: invokevirtual 73	java/io/IOException:getMessage	()Ljava/lang/String;
            //   264: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   267: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
            //   270: invokestatic 85	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
            //   273: goto -29 -> 244
            //   276: astore_1
            //   277: goto -41 -> 236
            //   280: astore_3
            //   281: goto -124 -> 157
            //   284: astore_3
            //   285: goto -206 -> 79
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	288	0	this	1
            //   8	37	1	localBoolean1	Boolean
            //   46	15	1	localIOException1	java.io.IOException
            //   80	33	1	localObject1	Object
            //   124	15	1	localIOException2	java.io.IOException
            //   158	33	1	localObject2	Object
            //   202	31	1	localIOException3	java.io.IOException
            //   235	10	1	localObject3	Object
            //   276	1	1	localObject4	Object
            //   29	212	2	localObject5	Object
            //   246	15	2	localIOException4	java.io.IOException
            //   3	40	3	localBoolean2	Boolean
            //   75	23	3	localFileNotFoundException1	java.io.FileNotFoundException
            //   153	23	3	localIOException5	java.io.IOException
            //   231	4	3	localObject6	Object
            //   250	1	3	localBoolean3	Boolean
            //   280	1	3	localIOException6	java.io.IOException
            //   284	1	3	localFileNotFoundException2	java.io.FileNotFoundException
            //   10	190	4	localBoolean4	Boolean
            //   5	150	5	localObject7	Object
            // Exception table:
            //   from	to	target	type
            //   38	42	46	java/io/IOException
            //   12	30	75	java/io/FileNotFoundException
            //   117	121	124	java/io/IOException
            //   12	30	153	java/io/IOException
            //   195	199	202	java/io/IOException
            //   12	30	231	finally
            //   81	86	231	finally
            //   88	110	231	finally
            //   159	164	231	finally
            //   166	188	231	finally
            //   240	244	246	java/io/IOException
            //   30	38	276	finally
            //   30	38	280	java/io/IOException
            //   30	38	284	java/io/FileNotFoundException
          }
        }, new Void[0]);
      }
    });
  }
  
  final boolean r()
  {
    return this.b.j_().a(2131755401) instanceof ai;
  }
  
  final class a
    extends RecyclerView.a<a>
  {
    final Drawable c;
    final int d;
    private final com.whatsapp.gallerypicker.r f;
    
    private a(com.whatsapp.gallerypicker.r paramr)
    {
      this.f = paramr;
      this.d = b.c(h.this.b, 2131623987);
      this.c = new ColorDrawable(this.d);
      a(true);
    }
    
    public final int a()
    {
      if (this.f == null) {
        return 0;
      }
      return this.f.b();
    }
    
    public final long b(int paramInt)
    {
      return paramInt;
    }
    
    public final void d()
    {
      if (this.f != null) {
        this.f.d();
      }
    }
    
    final class a
      extends RecyclerView.p
      implements View.OnClickListener
    {
      final ae.a n;
      com.whatsapp.gallerypicker.q o;
      
      public a(ae.a parama)
      {
        super();
        this.n = parama;
        this.n.setOnClickListener(this);
      }
      
      public final void onClick(View paramView)
      {
        if ((this.o != null) && (!h.this.d.c) && (!h.this.E.hasMessages(0))) {
          h.a(h.this, Uri.fromFile(new File(this.o.b())), paramView, d.b(this.o), false);
        }
      }
    }
  }
  
  static final class b
    extends OrientationEventListener
  {
    int a = -1;
    
    b(Context paramContext)
    {
      super();
    }
    
    public final void onOrientationChanged(int paramInt)
    {
      int j = -1;
      int i;
      if ((paramInt >= 330) || (paramInt < 30)) {
        i = 0;
      }
      for (;;)
      {
        this.a = i;
        return;
        if ((paramInt >= 60) && (paramInt < 120))
        {
          i = 1;
        }
        else if ((paramInt >= 150) && (paramInt < 210))
        {
          i = 2;
        }
        else
        {
          i = j;
          if (paramInt >= 240)
          {
            i = j;
            if (paramInt < 300) {
              i = 3;
            }
          }
        }
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/camera/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */