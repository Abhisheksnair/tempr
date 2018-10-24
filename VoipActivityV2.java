package com.whatsapp;

import a.a.a.a.a.a.d;
import a.a.a.a.d;
import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager.TaskDescription;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import android.os.Vibrator;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.support.v4.app.aw;
import android.support.v4.app.m;
import android.support.v4.app.n;
import android.support.v4.app.r;
import android.support.v4.view.ab;
import android.support.v7.app.b.a;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import b.a.a.c;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.g.l;
import com.whatsapp.messaging.w;
import com.whatsapp.notification.k;
import com.whatsapp.o.a;
import com.whatsapp.protocol.j;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils;
import com.whatsapp.util.at;
import com.whatsapp.util.az;
import com.whatsapp.util.bj;
import com.whatsapp.util.bu;
import com.whatsapp.util.h;
import java.io.File;
import java.util.Arrays;
import org.pjsip.PjCamera;

public class VoipActivityV2
  extends nh
  implements ViewTreeObserver.OnGlobalLayoutListener, VoiceService.f
{
  public static final String n = au.b() + ".intent.action.ACCEPT_CALL";
  public static final String o = au.b() + ".intent.action.SHOW_END_CALL_CONFIRMATION";
  public static final String p = au.b() + ".intent.action.END_CALL_AFTER_CONFIRMATION";
  boolean A;
  boolean B;
  int C;
  j D;
  int E;
  int F;
  bj G;
  TextView H;
  TextView I;
  int J;
  final e K = e.a();
  private View L;
  private View M;
  private View N;
  private TextView O;
  private TextEmojiLabel P;
  private boolean Q;
  private String R;
  private boolean S;
  private boolean T;
  private boolean U;
  private boolean V;
  private m W;
  private m X;
  private Voip.CallState Y;
  private Toast Z;
  private boolean aT;
  private ValueAnimator aU;
  private View.OnClickListener aV;
  private ImageView aW;
  private String aX;
  private long aY = 0L;
  private double aZ = NaN.0D;
  private long aa;
  private boolean ab;
  private int ac;
  private boolean ad;
  private int ae = 1;
  private int af = 0;
  private int ag;
  private int ah;
  private int ai;
  private boolean aj;
  private dh.a bA = null;
  private final ant bB = ant.a();
  private final va bC = va.a();
  private final oz bD = oz.a();
  private final aoj bE = aoj.a();
  private final vp bF = vp.a();
  private final k bG = k.a();
  private final h bH = h.a();
  private di.e bI;
  private double ba = NaN.0D;
  private boolean bb;
  private String bc;
  private boolean bd;
  private i be;
  private android.support.v7.app.b bf;
  private boolean bg;
  private ThumbnailButton bh;
  private View bi;
  private View bj;
  private cs bk;
  private int bl;
  private float bm;
  private boolean bn;
  private ImageView bo;
  private ImageView bp;
  private ImageView bq;
  private ImageButton br;
  private TextView bs;
  private boolean bt;
  private boolean bu;
  private View bv;
  private View bw;
  private c bx = new c((byte)0);
  private ServiceConnection by = new ServiceConnection()
  {
    public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
    {
      Log.i("voip/VoipActivity/onServiceConnected");
      paramAnonymousComponentName = (VoiceService.g)paramAnonymousIBinder;
      VoipActivityV2.a(VoipActivityV2.this, true);
      VoipActivityV2.a(VoipActivityV2.this, paramAnonymousComponentName.a);
      VoipActivityV2.a(VoipActivityV2.this).j = VoipActivityV2.this;
      VoipActivityV2.a(VoipActivityV2.this).a(Voip.getCurrentCallState());
      VoipActivityV2.a(VoipActivityV2.this).v = false;
      paramAnonymousComponentName = Voip.getCallInfo();
      VoipActivityV2.this.a(Voip.CallState.NONE, paramAnonymousComponentName);
      if ((paramAnonymousComponentName != null) && (paramAnonymousComponentName.isVideoEnabled()))
      {
        if (paramAnonymousComponentName.isVideoPreviewReady()) {
          VoipActivityV2.this.t_();
        }
        if (paramAnonymousComponentName.isVideoCaptureStarted()) {
          VoipActivityV2.this.u_();
        }
        if (paramAnonymousComponentName.isVideoRenderStarted())
        {
          VoipActivityV2.this.s_();
          VoipActivityV2.b(VoipActivityV2.this);
          VoipActivityV2.c(VoipActivityV2.this);
        }
      }
    }
    
    public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
    {
      Log.i("voip/VoipActivity/onServiceDisconnected");
      VoipActivityV2.a(VoipActivityV2.this).j = null;
      if (Voip.getCurrentCallState() == Voip.CallState.RECEIVED_CALL) {
        VoipActivityV2.a(VoipActivityV2.this).j();
      }
      VoipActivityV2.a(VoipActivityV2.this, null);
      VoipActivityV2.a(VoipActivityV2.this, false);
    }
  };
  private final dh bz = dh.a();
  VoiceService q;
  Handler r;
  SurfaceView s;
  SurfaceView t;
  Surface u;
  Surface v;
  SurfaceHolder.Callback w;
  SurfaceHolder.Callback x;
  boolean y;
  boolean z = true;
  
  private void A()
  {
    final int i = getWindowManager().getDefaultDisplay().getWidth();
    Log.i("VoipActivityV2 requesting profile image of size: " + i);
    bu.a(new AsyncTask()
    {
      private Bitmap a()
      {
        int i = Thread.currentThread().getPriority();
        Thread.currentThread().setPriority(5);
        Log.d("VoipActivityV2 updateProfilePhoto doInBackground begin old priority :" + i);
        try
        {
          Object localObject1 = Voip.getPeerJid();
          if (localObject1 == null) {
            return null;
          }
          Log.d("VoipActivityV2 updateProfilePhoto doInBackground getPeerJid done");
          localObject1 = VoipActivityV2.u(VoipActivityV2.this).c((String)localObject1);
          if (localObject1 == null) {
            return null;
          }
          Log.d("VoipActivityV2 updateProfilePhoto doInBackground getcontact done");
          localObject1 = ((cs)localObject1).a(i, 0.0F, false);
          Log.d("VoipActivityV2 updateProfilePhoto doInBackground getphoto done");
          return (Bitmap)localObject1;
        }
        finally
        {
          Thread.currentThread().setPriority(i);
        }
      }
    }, new Void[0]);
  }
  
  private void B()
  {
    TextView localTextView = (TextView)findViewById(2131756228);
    if (localTextView != null)
    {
      if (!Voip.isTxNetworkConditionerOn()) {
        break label99;
      }
      localTextView.setText("Tx network conditioner is ON !!!\n" + Voip.getCurrentTxNetworkConditionerParameters());
      localTextView.setVisibility(0);
    }
    for (;;)
    {
      localTextView = (TextView)findViewById(2131756230);
      if (localTextView != null)
      {
        if (!Voip.isRxNetworkConditionerOn()) {
          break;
        }
        localTextView.setText("Rx network conditioner is ON !!!\n" + Voip.getCurrentRxNetworkConditionerParameters());
        localTextView.setVisibility(0);
      }
      return;
      label99:
      localTextView.setVisibility(8);
    }
    localTextView.setVisibility(8);
  }
  
  private void C()
  {
    if (this.bf != null)
    {
      if (this.bf.isShowing()) {
        this.bf.dismiss();
      }
      this.bf = null;
    }
  }
  
  private void D()
  {
    Voip.CallInfo localCallInfo = Voip.getCallInfo();
    boolean bool = j(localCallInfo);
    if ((localCallInfo == null) || (this.ag == 0) || (this.ah == 0) || (this.A) || (!bool)) {
      Log.i("voip/VoipActivityV2/updatePiPLayoutParams skipped. window width " + this.ag + ", pipMoving " + this.A + ", show peer video " + bool);
    }
    RelativeLayout.LayoutParams localLayoutParams1;
    RelativeLayout.LayoutParams localLayoutParams2;
    do
    {
      return;
      localLayoutParams1 = (RelativeLayout.LayoutParams)this.t.getLayoutParams();
      localLayoutParams2 = a(localLayoutParams1, localCallInfo, true);
    } while (localLayoutParams2 == null);
    localLayoutParams1.height = localLayoutParams2.height;
    localLayoutParams1.width = localLayoutParams2.width;
    localLayoutParams1.topMargin = localLayoutParams2.topMargin;
    localLayoutParams1.rightMargin = localLayoutParams2.rightMargin;
    localLayoutParams1.leftMargin = localLayoutParams2.leftMargin;
    Log.i("voip/VoipActivityV2/updatePiPLayoutParams rightMargin: " + localLayoutParams1.rightMargin + ", topMargin: " + localLayoutParams1.topMargin + ", PiP size: " + localLayoutParams1.width + "x" + localLayoutParams1.height + ", previewOnFullSurfaceView: " + this.y + ", window size: " + this.ag + "x" + this.ah + ", peer video size: " + localCallInfo.getPeerVideoWidth() + "x" + localCallInfo.getPeerVideoHeight() + ", peer video orientation: " + localCallInfo.getPeerVideoOrientation());
    this.t.setLayoutParams(localLayoutParams1);
    c(localCallInfo);
    b(localCallInfo);
  }
  
  private void E()
  {
    if ((this.ag == 0) || (this.ah == 0)) {}
    SurfaceView localSurfaceView;
    label37:
    ViewGroup.MarginLayoutParams localMarginLayoutParams;
    label142:
    label397:
    label406:
    label418:
    label424:
    label437:
    do
    {
      for (;;)
      {
        return;
        int i;
        ViewGroup.LayoutParams localLayoutParams;
        float f1;
        float f2;
        boolean bool;
        int j;
        if (!j(Voip.getCallInfo()))
        {
          i = 1;
          if (i == 0) {
            break label397;
          }
          localSurfaceView = this.t;
          localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localSurfaceView.getLayoutParams();
          if ((!this.y) && (i == 0)) {
            break;
          }
          localLayoutParams = PjCamera.getAdjustedPreviewSize();
          if (localLayoutParams == null) {
            continue;
          }
          f1 = localLayoutParams.width / localLayoutParams.height;
          f2 = this.ag / this.ah;
          if ((Math.min(Math.abs(f2 - f1), Math.abs(1.0F / f2 - 1.0F / f1)) > 0.3D) || (f1 > 1.0F) || (f2 > 1.0F)) {
            break label406;
          }
          if (f1 < f2) {
            break label418;
          }
          bool = false;
          if (!bool) {
            break label424;
          }
          j = this.ag;
          i = (int)(j / f1);
        }
        for (;;)
        {
          if ((j == localMarginLayoutParams.width) && (i == localMarginLayoutParams.height)) {
            break label437;
          }
          Log.i("voip/VoipActivityV2/updateFullLayoutParams of " + localSurfaceView + " to " + j + "x" + i + " from " + localMarginLayoutParams.width + "x" + localMarginLayoutParams.height + ", , screen size: " + this.ag + "x" + this.ah + "(" + f2 + "), matchWidth: " + bool + ", adjusted preview size: " + localLayoutParams.width + "x" + localLayoutParams.height + "(" + f1 + ")");
          localMarginLayoutParams.height = i;
          localMarginLayoutParams.width = j;
          j = (this.ag - j) / 2;
          i = (this.ah - i) / 2;
          localMarginLayoutParams.setMargins(j, i, j, i);
          localSurfaceView.setLayoutParams(localMarginLayoutParams);
          return;
          i = 0;
          break;
          localSurfaceView = this.s;
          break label37;
          if (f1 < f2)
          {
            bool = false;
            break label142;
          }
          bool = true;
          break label142;
          i = this.ah;
          j = (int)(i * f1);
        }
      }
    } while ((localMarginLayoutParams.width == -1) && (localMarginLayoutParams.height == -1));
    localMarginLayoutParams.width = -1;
    localMarginLayoutParams.height = -1;
    localMarginLayoutParams.setMargins(0, 0, 0, 0);
    localSurfaceView.setLayoutParams(localMarginLayoutParams);
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 255;
    int k = paramInt1 + paramInt2 * 1;
    int j = paramInt1 - (int)(0.344F * paramInt3 + 0.714F * paramInt2);
    paramInt3 = paramInt3 * 1 + paramInt1;
    if (k > 255)
    {
      paramInt1 = 255;
      if (j <= 255) {
        break label97;
      }
      paramInt2 = 255;
      label59:
      if (paramInt3 <= 255) {
        break label110;
      }
      paramInt3 = i;
    }
    for (;;)
    {
      return paramInt3 | 0xFF000000 | paramInt1 << 16 | paramInt2 << 8;
      paramInt1 = k;
      if (k >= 0) {
        break;
      }
      paramInt1 = 0;
      break;
      label97:
      paramInt2 = j;
      if (j >= 0) {
        break label59;
      }
      paramInt2 = 0;
      break label59;
      label110:
      if (paramInt3 < 0) {
        paramInt3 = 0;
      }
    }
  }
  
  private RelativeLayout.LayoutParams a(RelativeLayout.LayoutParams paramLayoutParams, Voip.CallInfo paramCallInfo, boolean paramBoolean)
  {
    if ((this.ag == 0) || (this.ah == 0))
    {
      Log.i("voip/VoipActivityV2/calculatePiPLayoutParams cancel because windowWidth/windowHeight is not initialized");
      return null;
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(0, 0);
    int j;
    label143:
    float f;
    int k;
    if (paramBoolean)
    {
      if (paramCallInfo == null)
      {
        a.d.a(false, "Call info should be provided");
        return null;
      }
      if (this.y)
      {
        if ((paramCallInfo.getPeerVideoHeight() == 0) || (paramCallInfo.getPeerVideoWidth() == 0))
        {
          Log.e("voip/VoipActivityV2/calculatePiPLayoutParams invalid peer video size: " + paramCallInfo.getPeerVideoWidth() + "x" + paramCallInfo.getPeerVideoHeight());
          return null;
        }
        if (paramCallInfo.getPeerVideoOrientation() % 180 == 0)
        {
          i = paramCallInfo.getPeerVideoWidth();
          if (paramCallInfo.getPeerVideoOrientation() % 180 != 0) {
            break label285;
          }
          j = paramCallInfo.getPeerVideoHeight();
          f = i / j;
          k = Math.min(this.ag, this.ah);
          if (i >= j) {
            break label325;
          }
          j = (int)(k * 0.225F);
          i = (int)(j / f);
          label191:
          localLayoutParams.width = j;
          localLayoutParams.height = i;
          label205:
          paramLayoutParams = a(localLayoutParams);
          if (!this.aj) {
            break label368;
          }
          i = paramLayoutParams.d;
          label225:
          localLayoutParams.topMargin = i;
          if (!this.aT) {
            break label377;
          }
        }
      }
    }
    label285:
    label325:
    label368:
    label377:
    for (int i = paramLayoutParams.a;; i = paramLayoutParams.b)
    {
      localLayoutParams.rightMargin = i;
      localLayoutParams.leftMargin = (this.ag - localLayoutParams.rightMargin - localLayoutParams.width);
      return localLayoutParams;
      i = paramCallInfo.getPeerVideoHeight();
      break;
      j = paramCallInfo.getPeerVideoWidth();
      break label143;
      paramLayoutParams = PjCamera.getAdjustedPreviewSize();
      if (paramLayoutParams == null)
      {
        Log.e("voip/VoipActivityV2/calculatePiPLayoutParams PjCamera.inst.getAdjustedPreviewSize() returns null");
        return null;
      }
      i = paramLayoutParams.width;
      j = paramLayoutParams.height;
      break label143;
      i = (int)(k * 0.225F);
      j = (int)(i * f);
      break label191;
      localLayoutParams.width = paramLayoutParams.width;
      localLayoutParams.height = paramLayoutParams.height;
      break label205;
      i = paramLayoutParams.c;
      break label225;
    }
  }
  
  private f a(RelativeLayout.LayoutParams paramLayoutParams)
  {
    int k = this.ai;
    int m = this.ai;
    int i1 = this.ag;
    int i2 = paramLayoutParams.width;
    int i3 = this.ai;
    int j = this.ah - paramLayoutParams.height - this.ai;
    int i = j;
    if (this.z) {
      i = j - this.N.getHeight();
    }
    return new f(k, i1 - i2 - i3, m, i);
  }
  
  private void a(final long paramLong, final int paramInt1, int paramInt2)
  {
    Log.i("voip/VoipActivityV2/animatePiPView with duration: " + paramLong + ", xOffset: " + paramInt1 + ", yOffset: " + paramInt2 + ", final size: 0x0");
    if ((Build.VERSION.SDK_INT >= 12) && (paramLong > 0L) && (this.bb))
    {
      final View localView1 = findViewById(2131756192);
      final View localView2 = findViewById(2131756193);
      final View localView3 = findViewById(2131756194);
      this.aU = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.aU.setDuration(paramLong);
      this.aU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        float a = 0.0F;
        int b;
        int c;
        int d;
        int e;
        
        @TargetApi(12)
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          float f1 = paramAnonymousValueAnimator.getAnimatedFraction();
          paramAnonymousValueAnimator = (RelativeLayout.LayoutParams)VoipActivityV2.h(VoipActivityV2.this).getLayoutParams();
          if (f1 == 0.0F)
          {
            this.b = paramAnonymousValueAnimator.topMargin;
            this.c = paramAnonymousValueAnimator.rightMargin;
            this.d = VoipActivityV2.h(VoipActivityV2.this).getWidth();
            this.e = VoipActivityV2.h(VoipActivityV2.this).getHeight();
          }
          float f2 = (float)paramLong;
          paramAnonymousValueAnimator.topMargin = (this.b + (int)(paramInt1 * f1));
          paramAnonymousValueAnimator.rightMargin = (this.c - (int)(this.h * f1));
          if ((this.i > 0) && (this.j > 0))
          {
            paramAnonymousValueAnimator.width = (this.d + (int)((this.i - this.d) * f1));
            int m = this.e;
            paramAnonymousValueAnimator.height = ((int)(f1 * (this.j - this.e)) + m);
          }
          paramAnonymousValueAnimator.leftMargin = (VoipActivityV2.p(VoipActivityV2.this) - paramAnonymousValueAnimator.rightMargin - paramAnonymousValueAnimator.width);
          VoipActivityV2.h(VoipActivityV2.this).setLayoutParams(paramAnonymousValueAnimator);
          this.a = (f2 * f1);
        }
      });
      this.aU.addListener(new Animator.AnimatorListener()
      {
        @TargetApi(11)
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          Log.i("voip/VoipActivityV2/animatePiPView onAnimationCancel");
          VoipActivityV2.b(VoipActivityV2.this, false);
          if (this.b != null) {
            this.b.onAnimationCancel(paramAnonymousAnimator);
          }
        }
        
        @TargetApi(11)
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          Log.i("voip/VoipActivityV2/animatePiPView onAnimationEnd");
          VoipActivityV2.b(VoipActivityV2.this, false);
          VoipActivityV2.b(VoipActivityV2.this);
          View localView2;
          VoipActivityV2 localVoipActivityV2;
          if (VoipActivityV2.q(VoipActivityV2.this))
          {
            localView2 = VoipActivityV2.this.findViewById(2131756192);
            localVoipActivityV2 = VoipActivityV2.this;
            if (localView3.getVisibility() != 0) {
              break label101;
            }
          }
          label101:
          for (View localView1 = localView3;; localView1 = localView2)
          {
            VoipActivityV2.a(localVoipActivityV2, localView2, localView1);
            localView2.setVisibility(0);
            VoipActivityV2.c(VoipActivityV2.this, false);
            if (this.b != null) {
              this.b.onAnimationEnd(paramAnonymousAnimator);
            }
            return;
          }
        }
        
        @TargetApi(11)
        public final void onAnimationRepeat(Animator paramAnonymousAnimator)
        {
          Log.i("voip/VoipActivityV2/animatePiPView onAnimationRepeat");
          if (this.b != null) {
            this.b.onAnimationRepeat(paramAnonymousAnimator);
          }
        }
        
        @TargetApi(11)
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          Log.i("voip/VoipActivityV2/animatePiPView onAnimationStart");
          VoipActivityV2.b(VoipActivityV2.this, true);
          if (localView1.getVisibility() == 0)
          {
            VoipActivityV2.c(VoipActivityV2.this, true);
            localView1.setVisibility(8);
          }
          if (this.b != null) {
            this.b.onAnimationStart(paramAnonymousAnimator);
          }
        }
      });
      this.aU.start();
      return;
    }
    D();
    paramInt1 = Build.VERSION.SDK_INT;
  }
  
  private static void a(View paramView, int paramInt)
  {
    Log.i("voip/VoipActivityV2/animateButtonIn delay:" + paramInt);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setInterpolator(new OvershootInterpolator(1.0F));
    localScaleAnimation.setDuration(300L);
    localScaleAnimation.setStartOffset(paramInt);
    paramView.startAnimation(localScaleAnimation);
  }
  
  private void a(View paramView1, View paramView2)
  {
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.t.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)paramView1.getLayoutParams();
    localLayoutParams2.height = localLayoutParams1.height;
    localLayoutParams2.width = localLayoutParams1.width;
    localLayoutParams2.topMargin = localLayoutParams1.topMargin;
    localLayoutParams2.rightMargin = localLayoutParams1.rightMargin;
    localLayoutParams2.leftMargin = localLayoutParams1.leftMargin;
    paramView1.setLayoutParams(localLayoutParams2);
    paramView1 = (FrameLayout.LayoutParams)paramView2.getLayoutParams();
    paramView1.gravity = 17;
    paramView1.topMargin = 0;
    paramView2.setLayoutParams(paramView1);
  }
  
  private void a(String paramString, int paramInt)
  {
    if (this.Z != null) {
      this.Z.cancel();
    }
    int[] arrayOfInt = new int[2];
    findViewById(2131756208).getLocationOnScreen(arrayOfInt);
    int i = getWindow().getDecorView().getHeight();
    int j = arrayOfInt[1];
    this.Z = Toast.makeText(getApplicationContext(), paramString, paramInt);
    this.Z.setGravity(80, 0, i - j);
    this.Z.show();
  }
  
  private void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (paramString == null)
    {
      Log.i("VoipActivityV2 vm updateVoiceMailButtons: cannot show buttons. got null jid");
      finish();
      return;
    }
    if (this.Q) {
      Log.i("VoipActivityV2 vm unbindService");
    }
    try
    {
      unbindService(this.by);
      this.Q = false;
      switch (paramInt)
      {
      case 3: 
      case 6: 
      case 7: 
      case 8: 
      default: 
        this.O.setText(null);
        findViewById(2131756201).setVisibility(8);
        findViewById(2131756209).setVisibility(8);
        ViewGroup localViewGroup = (ViewGroup)findViewById(2131756210);
        ImageButton localImageButton1 = (ImageButton)findViewById(2131756214);
        ImageButton localImageButton2 = (ImageButton)findViewById(2131756216);
        ImageButton localImageButton3 = (ImageButton)findViewById(2131756212);
        if (paramBoolean2)
        {
          localViewGroup.setBackgroundColor(getResources().getColor(2131624129));
          ((ImageButton)findViewById(2131756214)).setImageDrawable(getResources().getDrawable(2130840108));
          Log.i("VoipActivityV2 vm setting up buttons");
          localImageButton1.setOnClickListener(asw.a(this, paramString, paramBoolean2));
          localImageButton2.setOnTouchListener(asx.a(this, paramString, paramBoolean2, paramInt));
          localImageButton3.setOnClickListener(asy.a(this));
          localViewGroup.setVisibility(0);
          findViewById(2131756213).setVisibility(0);
          findViewById(2131756215).setVisibility(0);
          findViewById(2131756211).setVisibility(0);
          if (paramBoolean1) {
            a(localImageButton2, 100);
          }
          a(localImageButton1, 100);
          a(localImageButton3, 100);
          return;
        }
        break;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Log.e(localIllegalArgumentException);
        continue;
        this.O.setText(2131298162);
        continue;
        this.O.setText(2131298155);
        continue;
        this.O.setText(getString(2131297347, new Object[] { this.K.d(paramString).a(this) }));
        continue;
        if ((this.q != null) && (this.q.K == VoiceService.e.g))
        {
          this.O.setText(2131298173);
        }
        else
        {
          this.O.setText(null);
          continue;
          ((ImageView)findViewById(2131755440)).setAlpha(140);
        }
      }
    }
  }
  
  private static int[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int j = 0;
    int k = paramInt1 * paramInt2;
    int[] arrayOfInt = new int[k];
    int i = 0;
    for (paramInt2 = j; paramInt2 < k; paramInt2 = j + 2)
    {
      j = paramArrayOfByte[paramInt2];
      int m = paramArrayOfByte[(paramInt2 + 1)];
      int i1 = paramArrayOfByte[(paramInt1 + paramInt2)];
      int i2 = paramArrayOfByte[(paramInt1 + paramInt2 + 1)];
      int i4 = paramArrayOfByte[(k + i)];
      int i3 = paramArrayOfByte[(k + i + 1)];
      i4 = (i4 & 0xFF) - 128;
      i3 = (i3 & 0xFF) - 128;
      arrayOfInt[paramInt2] = a(j & 0xFF, i4, i3);
      arrayOfInt[(paramInt2 + 1)] = a(m & 0xFF, i4, i3);
      arrayOfInt[(paramInt1 + paramInt2)] = a(i1 & 0xFF, i4, i3);
      arrayOfInt[(paramInt1 + paramInt2 + 1)] = a(i2 & 0xFF, i4, i3);
      j = paramInt2;
      if (paramInt2 != 0)
      {
        j = paramInt2;
        if ((paramInt2 + 2) % paramInt1 == 0) {
          j = paramInt2 + paramInt1;
        }
      }
      i += 2;
    }
    return arrayOfInt;
  }
  
  private void b(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return;
      this.bk = this.K.d(paramString);
      this.P.setContact(this.bk);
    } while (this.bI == null);
    this.bI.a(this.bk, this.bh);
  }
  
  private void c(String paramString)
  {
    this.r.removeMessages(7);
    this.r.removeMessages(8);
    C();
    b.a locala = new b.a(this);
    locala.b(paramString).a(true);
    this.bf = locala.a();
    this.r.sendEmptyMessage(8);
    this.r.sendEmptyMessageDelayed(7, 6000L);
  }
  
  private boolean c(String paramString1, String paramString2)
  {
    Voip.CallInfo localCallInfo = Voip.getCallInfo();
    StringBuilder localStringBuilder = new StringBuilder("voip/VoipActivityV2/shouldShowBatteryLowNotif: batteryState: voiceService: ").append(this.q).append(" info: ").append(localCallInfo).append(" callState = ");
    if (localCallInfo != null) {}
    for (Object localObject = localCallInfo.getCallState();; localObject = "")
    {
      Log.d(localObject + " jid: " + paramString1 + " callid: " + paramString2);
      if ((this.q == null) || (localCallInfo == null) || (localCallInfo.getCallState() == Voip.CallState.NONE) || ((paramString1 != null) && (!paramString1.equals(localCallInfo.getPeerId()))) || ((paramString2 != null) && (!paramString2.equals(localCallInfo.getCallId())))) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private static boolean d(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private static boolean e(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private void f(Voip.CallInfo paramCallInfo)
  {
    if (this.bg) {}
    while (this.bj.getVisibility() == 8) {
      return;
    }
    int i = this.bj.getHeight();
    if (i == 0)
    {
      i = View.MeasureSpec.makeMeasureSpec(0, 0);
      int j = View.MeasureSpec.makeMeasureSpec(0, 0);
      this.bj.measure(i, j);
      i = this.bj.getMeasuredHeight();
    }
    for (;;)
    {
      View localView = findViewById(2131756238);
      if (localView != null)
      {
        ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
        localScaleAnimation.setInterpolator(new DecelerateInterpolator());
        localScaleAnimation.setDuration(125L);
        localScaleAnimation.setFillAfter(true);
        localView.startAnimation(localScaleAnimation);
      }
      d.a(this.bj, 0.0F, -i);
      if (!paramCallInfo.isVideoEnabled()) {
        d.a(this.bi, 0.0F, -i);
      }
      for (;;)
      {
        if (Build.VERSION.SDK_INT < 11) {
          this.N.setVisibility(0);
        }
        d.a(this.N, this.N.getHeight(), 0.0F);
        findViewById(2131756235).setVisibility(8);
        this.bg = true;
        return;
        d.a(this.bi, 125L, 4);
      }
    }
  }
  
  private void g(Voip.CallInfo paramCallInfo)
  {
    int j = 1;
    if ((this.O == null) || (this.ag == 0) || (this.ah == 0)) {}
    while (paramCallInfo == null) {
      return;
    }
    int i;
    switch (5.a[paramCallInfo.getCallState().ordinal()])
    {
    case 7: 
    default: 
      a.d.a(false, "voip/VoipActivityV2/updateCallStatusBar/unknownCallState");
      i = j;
    }
    for (;;)
    {
      paramCallInfo = (TextView)findViewById(2131756236);
      if ((this.t.getVisibility() != 0) || (i == 0)) {
        break;
      }
      paramCallInfo.setVisibility(0);
      paramCallInfo.setText(this.O.getText());
      return;
      String str1 = "";
      if (av.d()) {
        str1 = "AEC:" + paramCallInfo.getECMode() + " RAW:" + paramCallInfo.getEchoLevelBeforeEC() + " OUT:" + paramCallInfo.getEchoLevel() + " \n";
      }
      str1 = str1 + DateUtils.formatElapsedTime(paramCallInfo.getCallDuration() / 1000L);
      if ((paramCallInfo.isSelfInterrupted()) || (paramCallInfo.isPeerInterrupted()))
      {
        this.O.setText(2131298167);
        i = j;
      }
      else if ((paramCallInfo.getBytesReceived() == 0L) || ((paramCallInfo.isVideoEnabled()) && (!paramCallInfo.isVideoRenderStarted())))
      {
        this.O.setText(2131298154);
        i = j;
      }
      else if ((paramCallInfo.isVideoEnabled()) && (i(paramCallInfo)) && (!e(paramCallInfo)))
      {
        this.O.setText(getString(2131298177, new Object[] { this.K.d(paramCallInfo.getPeerId()).k() }));
        i = j;
      }
      else if ((this.q != null) && (this.q.b(paramCallInfo)))
      {
        this.O.setText(2131298171);
        i = j;
      }
      else if (paramCallInfo.isPeerVideoPaused())
      {
        this.O.setText(getString(2131298169, new Object[] { this.K.d(paramCallInfo.getPeerId()).k() }));
        i = j;
      }
      else if (paramCallInfo.isVideoDecodePaused())
      {
        this.O.setText(2131298111);
        i = j;
      }
      else
      {
        if ((this.q != null) && ((this.q.g) || (this.bt)))
        {
          String str2 = getString(2131298168, new Object[] { this.K.d(paramCallInfo.getPeerId()).k() });
          if (paramCallInfo.isVideoEnabled())
          {
            this.O.setText(str2);
            label529:
            b(paramCallInfo);
            if ((!this.bt) || (this.y)) {
              break label592;
            }
          }
          label592:
          for (i = 1;; i = 0)
          {
            break;
            this.O.setText(str1 + " • " + str2.toUpperCase());
            break label529;
          }
        }
        this.O.setText(str1);
        i = 0;
        continue;
        this.O.setText(2131298154);
        i = j;
        continue;
        if ((this.q != null) && (this.q.i))
        {
          this.O.setText(getString(2131297347, new Object[] { this.K.d(paramCallInfo.getPeerId()).a(this) }));
          i = j;
        }
        else
        {
          this.O.setText(2131298151);
          i = j;
          continue;
          if (this.q != null)
          {
            i = j;
            if (this.q.i) {}
          }
          else
          {
            this.O.setText(2131298152);
            i = j;
            continue;
            this.O.setText(2131298148);
            i = j;
          }
        }
      }
    }
    paramCallInfo.setVisibility(8);
  }
  
  private void h(Voip.CallInfo paramCallInfo)
  {
    boolean bool2 = true;
    if (paramCallInfo == null) {}
    Object localObject;
    View localView1;
    ImageButton localImageButton2;
    label175:
    label194:
    label219:
    int i;
    label225:
    do
    {
      do
      {
        return;
        localObject = paramCallInfo.getCallState();
      } while ((localObject == Voip.CallState.NONE) || (localObject == Voip.CallState.RECEIVED_CALL));
      localObject = (ImageButton)findViewById(2131756202);
      localView1 = findViewById(2131756204);
      ImageButton localImageButton1 = (ImageButton)findViewById(2131756205);
      localImageButton2 = (ImageButton)findViewById(2131756206);
      View localView2 = findViewById(2131756203);
      if (!paramCallInfo.isVideoEnabled()) {
        break label298;
      }
      localImageButton2.setBackgroundDrawable(getResources().getDrawable(2130840528));
      ((ImageButton)localObject).setImageResource(2130840533);
      if (Voip.getCameraCount() <= 1) {
        break;
      }
      bool1 = true;
      ((ImageButton)localObject).setEnabled(bool1);
      ((ImageButton)localObject).setSelected(false);
      localImageButton1.setImageResource(2130840535);
      if ((this.q == null) || (!this.q.f)) {
        break label287;
      }
      localImageButton2.setImageDrawable(getResources().getDrawable(2130840537));
      if ((this.q == null) || (!this.q.f)) {
        break label345;
      }
      bool1 = true;
      localImageButton2.setSelected(bool1);
      if ((this.q == null) || (!this.q.o())) {
        break label350;
      }
      bool1 = true;
      if (!bool1) {
        break label355;
      }
      i = 0;
      localView2.setVisibility(i);
      Log.d("voip/VoipActivityV2/audio_route/updateAudioButtonStates show_blue_tooth_buttons " + bool1);
    } while (!bool1);
    if ((this.q != null) && (this.q.n())) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localView1.setSelected(bool1);
      return;
      bool1 = false;
      break;
      label287:
      localImageButton2.setImageResource(2130840538);
      break label175;
      label298:
      ((ImageButton)localObject).setEnabled(true);
      ((ImageButton)localObject).setImageResource(2130840256);
      if ((this.q != null) && (this.q.m())) {}
      for (bool1 = true;; bool1 = false)
      {
        ((ImageButton)localObject).setSelected(bool1);
        break;
      }
      label345:
      bool1 = false;
      break label194;
      label350:
      bool1 = false;
      break label219;
      label355:
      i = 8;
      break label225;
    }
  }
  
  @TargetApi(21)
  private void i(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      setTaskDescription(new ActivityManager.TaskDescription(paramString));
    }
  }
  
  private boolean i(Voip.CallInfo paramCallInfo)
  {
    return (this.U) && (paramCallInfo != null) && (paramCallInfo.isVideoEnabled());
  }
  
  private boolean j(Voip.CallInfo paramCallInfo)
  {
    return (this.U) && (paramCallInfo != null) && (paramCallInfo.isVideoEnabled()) && (paramCallInfo.getCallState() == Voip.CallState.ACTIVE);
  }
  
  static boolean m()
  {
    return av.d();
  }
  
  private void t()
  {
    Log.i("voip/VoipActivityV2/showCallFailedMessage" + this.R);
    if (this.R != null)
    {
      u();
      this.W = d.a(this.R);
      this.W.a(j_(), null);
      return;
    }
    a.d.a(false, "call failed message not defined");
  }
  
  private void u()
  {
    if (this.W != null)
    {
      this.W.b();
      this.W = null;
      this.R = null;
    }
  }
  
  private void v()
  {
    if (this.X != null)
    {
      this.X.b();
      this.X = null;
    }
  }
  
  private void w()
  {
    int i = 1;
    Log.i("voip/VoipActivityV2/call/accept");
    Object localObject = Voip.getCallInfo();
    if ((localObject == null) || (((Voip.CallInfo)localObject).getCallState() == Voip.CallState.NONE)) {}
    label165:
    label238:
    label243:
    label271:
    label350:
    label375:
    label380:
    label400:
    for (;;)
    {
      return;
      if (!this.bn)
      {
        d.a(this.bo, 125L, 8);
        d.a(this.bp, 100L, 8);
        d.a(this.bq, 100L, 8);
        d.a(this.bs, 100L, 8);
        d.a(this.br, 125L, 0);
        f((Voip.CallInfo)localObject);
        this.bn = true;
      }
      this.V = true;
      d((Voip.CallInfo)localObject);
      if (this.q != null)
      {
        boolean bool1;
        if (Build.VERSION.SDK_INT < 23)
        {
          if (!this.aP.e())
          {
            bool1 = true;
            if ((!((Voip.CallInfo)localObject).isVideoEnabled()) || (this.aP.f())) {
              break label238;
            }
            bool2 = true;
            if ((!bool1) && (!bool2)) {
              break label271;
            }
            Log.w("voip/service/accept noRecordPermission = " + bool1 + ", noCameraPermission = " + bool2);
            if ((!bool2) || (!bool1)) {
              break label243;
            }
            str = getString(2131296394);
          }
          for (;;)
          {
            this.q.b(VoiceService.e.w, str);
            return;
            bool1 = false;
            break;
            bool2 = false;
            break label165;
            if (bool2) {
              str = getString(2131296393);
            } else {
              str = getString(2131296397);
            }
          }
        }
        this.q.b();
        String str = ((Voip.CallInfo)localObject).getPeerId();
        boolean bool2 = ((Voip.CallInfo)localObject).isVideoEnabled();
        localObject = (m)j_().a("permission_request");
        if (localObject != null) {
          ((m)localObject).a();
        }
        if (this.aP.a("android.permission.RECORD_AUDIO") != 0)
        {
          bool1 = true;
          if ((!bool2) || (this.aP.a("android.permission.CAMERA") == 0)) {
            break label375;
          }
          bool2 = true;
          if ((bool2) || (bool1)) {
            break label380;
          }
        }
        for (;;)
        {
          if (i == 0) {
            break label400;
          }
          this.q.c();
          return;
          bool1 = false;
          break;
          bool2 = false;
          break label350;
          e.a(str, bool1, bool2).a(j_(), "permission_request");
          i = 0;
        }
      }
    }
  }
  
  private void x()
  {
    if (isFinishing()) {
      Log.i("voip/VoipActivityV2/updateUiState finishing do not update");
    }
    Voip.CallInfo localCallInfo;
    do
    {
      return;
      localCallInfo = Voip.getCallInfo();
    } while ((localCallInfo == null) || (localCallInfo.getCallState() == Voip.CallState.NONE));
    Log.i("voip/VoipActivityV2/updateUiState");
    c();
    View localView;
    if ((Voip.getCallInfo() != null) && ((Voip.getCallInfo().getCallState() == Voip.CallState.CALLING) || (Voip.getCallInfo().getCallState() == Voip.CallState.PRE_ACCEPT_RECEIVED)))
    {
      i = 1;
      if ((i != 0) && (!localCallInfo.isVideoEnabled()))
      {
        findViewById(2131756235).setVisibility(8);
        findViewById(2131756234).setVisibility(8);
        ((RelativeLayout.LayoutParams)findViewById(2131756187).getLayoutParams()).addRule(3, 2131756240);
      }
      boolean bool = i(localCallInfo);
      localView = findViewById(2131756187);
      if ((bool) && ((!j(localCallInfo)) || (e(localCallInfo)))) {
        break label211;
      }
    }
    label211:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      this.P.setContact(this.K.d(localCallInfo.getPeerId()));
      d(localCallInfo);
      g(localCallInfo);
      h(localCallInfo);
      return;
      i = 0;
      break;
    }
  }
  
  private void y()
  {
    Voip.CallInfo localCallInfo = Voip.getCallInfo();
    if ((localCallInfo == null) || (localCallInfo.getCallState() == Voip.CallState.NONE)) {}
    while ((!localCallInfo.isVideoEnabled()) || (!this.T)) {
      return;
    }
    this.r.removeMessages(6);
    this.r.sendEmptyMessageDelayed(6, 500L);
  }
  
  private void z()
  {
    if ((this.P != null) && (this.S)) {
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.P.getWindowToken(), 0);
    }
  }
  
  protected final void U()
  {
    if (this.at.c() != 1) {
      super.U();
    }
  }
  
  public final void a()
  {
    a.d.b();
    h(Voip.getCallInfo());
  }
  
  final void a(long paramLong, Voip.CallInfo paramCallInfo)
  {
    if ((this.B) || (!e(paramCallInfo))) {
      return;
    }
    Log.i("voip/VoipActivityV2/animateFooterInVideoCall Enter showButtons: " + this.z + " footer top: " + this.N.getTop() + " duration: " + paramLong);
    this.B = true;
    int i = this.N.getHeight();
    final int j = this.M.getHeight() + i;
    label101:
    Animation.AnimationListener local12;
    if (this.z)
    {
      i = -1;
      paramCallInfo = new TranslateAnimation(0.0F, 0.0F, 0.0F, i * j);
      local12 = new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          VoipActivityV2.n(VoipActivityV2.this);
          VoipActivityV2.l(VoipActivityV2.this).clearAnimation();
          VoipActivityV2.o(VoipActivityV2.this).clearAnimation();
          paramAnonymousAnimation = (RelativeLayout.LayoutParams)VoipActivityV2.l(VoipActivityV2.this).getLayoutParams();
          if (VoipActivityV2.k(VoipActivityV2.this)) {}
          for (int i = 0;; i = -j)
          {
            paramAnonymousAnimation.bottomMargin = i;
            VoipActivityV2.l(VoipActivityV2.this).setLayoutParams(paramAnonymousAnimation);
            Log.i("voip/VoipActivityV2/animateFooterInVideoCall onAnimationEnd showButtons: " + VoipActivityV2.k(VoipActivityV2.this) + " footer top: " + VoipActivityV2.l(VoipActivityV2.this).getTop());
            return;
          }
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation)
        {
          Log.i("voip/VoipActivityV2/animateFooterInVideoCall onAnimationRepeat showButtons: " + VoipActivityV2.k(VoipActivityV2.this));
        }
        
        public final void onAnimationStart(Animation paramAnonymousAnimation)
        {
          Log.i("voip/VoipActivityV2/animateFooterInVideoCall onAnimationStart showButtons: " + VoipActivityV2.k(VoipActivityV2.this) + " footer top: " + VoipActivityV2.l(VoipActivityV2.this).getTop());
          if ((VoipActivityV2.m(VoipActivityV2.this)) && (!VoipActivityV2.e(VoipActivityV2.this))) {
            VoipActivityV2.this.findViewById(2131756192).setVisibility(8);
          }
        }
      };
      if ((paramLong <= 0L) || (!this.bb)) {
        break label228;
      }
      this.N.clearAnimation();
      this.M.clearAnimation();
      paramCallInfo.setAnimationListener(local12);
      paramCallInfo.setFillAfter(true);
      paramCallInfo.setDuration(paramLong);
      this.N.startAnimation(paramCallInfo);
      this.M.startAnimation(paramCallInfo);
      label189:
      if (!this.aj) {
        break label245;
      }
      if (!this.z) {
        break label247;
      }
    }
    label228:
    label245:
    label247:
    for (i = -this.N.getHeight();; i = this.N.getHeight())
    {
      a(paramLong, 0, i);
      return;
      i = 1;
      break label101;
      local12.onAnimationStart(paramCallInfo);
      local12.onAnimationEnd(paramCallInfo);
      break label189;
      break;
    }
  }
  
  public final void a(Voip.CallInfo paramCallInfo)
  {
    a.d.b();
    g(paramCallInfo);
    long l = System.currentTimeMillis();
    int i;
    double d1;
    double d2;
    if (l - this.aY > 60000L)
    {
      i = 1;
      if (i != 0)
      {
        this.ba = VoiceService.a();
        if ((this.aY == 0L) || (Double.isNaN(this.aZ))) {
          this.aZ = this.ba;
        }
        this.aY = l;
      }
      if ((!Double.isNaN(this.aZ)) && (!Double.isNaN(this.ba)))
      {
        l = paramCallInfo.getCallDuration() / 60000L;
        d1 = this.aZ;
        d2 = this.ba;
        if (l <= 0L) {
          break label300;
        }
      }
    }
    for (;;)
    {
      d1 = (d1 - d2) / l;
      if (i != 0)
      {
        i = Voip.setBatteryState((int)d1, (int)this.ba);
        Log.i("voip/VoipActivityV2/updateOnTimer setting battery state for vid_rc_battery: " + d1 + " " + this.ba + " got result: " + i);
      }
      o();
      B();
      if ((this.q != null) && (this.q.t) && (paramCallInfo.getCallState() == Voip.CallState.ACTIVE) && (this.aa == 0L) && (paramCallInfo.getBytesReceived() > 0L) && (paramCallInfo.isCaller()) && (!paramCallInfo.isVideoEnabled()) && (paramCallInfo.getCallDuration() < 3000L)) {
        a(getString(2131298141), 0);
      }
      this.aa = paramCallInfo.getBytesReceived();
      return;
      i = 0;
      break;
      label300:
      l = 1L;
    }
  }
  
  public final void a(Voip.CallState paramCallState, Voip.CallInfo paramCallInfo)
  {
    
    if (paramCallInfo == null)
    {
      Log.w("voip/VoipActivityV2/callStateChanged info == NULL finishing current activity");
      finish();
      return;
    }
    runOnUiThread(asz.a(this, paramCallInfo, paramCallState));
  }
  
  public final void a(String paramString)
  {
    this.R = paramString;
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if (c(paramString1, paramString2))
    {
      paramString2 = e.a();
      if (paramString1 == null) {
        break label47;
      }
    }
    label47:
    for (paramString1 = paramString2.d(paramString1).a(this);; paramString1 = "Unknown")
    {
      c(getString(2131296376, new Object[] { paramString1 }));
      return;
    }
  }
  
  final void b(Voip.CallInfo paramCallInfo)
  {
    View localView1;
    if (((paramCallInfo == null) || (paramCallInfo.isVideoEnabled())) && (this.t != null))
    {
      paramCallInfo = (TextView)findViewById(2131756194);
      localView1 = findViewById(2131756193);
      View localView2 = findViewById(2131756185);
      if ((this.q == null) || (!this.q.g)) {
        break label119;
      }
      this.bt = true;
      if (!this.y)
      {
        this.bw.setVisibility(8);
        localView2.setVisibility(8);
      }
    }
    else
    {
      return;
    }
    a(this.bv, paramCallInfo);
    this.bv.setVisibility(0);
    localView1.setVisibility(8);
    paramCallInfo.setVisibility(0);
    return;
    label119:
    this.bt = false;
    if (!this.y)
    {
      this.bw.setVisibility(8);
      return;
    }
    this.bv.setVisibility(8);
  }
  
  public final void c()
  {
    a.d.b();
    Voip.CallInfo localCallInfo = Voip.getCallInfo();
    if ((localCallInfo == null) || (localCallInfo.getCallState() == Voip.CallState.NONE)) {
      return;
    }
    Log.i("voip/VoipActivityV2/updateLayoutForAudioAndVideoCall video: " + localCallInfo.isVideoEnabled());
    TextView localTextView = (TextView)findViewById(2131756197);
    boolean bool;
    View localView;
    if (localCallInfo.isVideoEnabled()) {
      if (!Voip.b())
      {
        bool = true;
        this.bb = bool;
        if (Build.VERSION.SDK_INT >= 21) {
          getWindow().setStatusBarColor(android.support.v4.content.b.c(this, 2131624129));
        }
        if (!this.ad)
        {
          this.ad = true;
          localView = getWindow().getDecorView();
          localView.setSystemUiVisibility(localView.getSystemUiVisibility() | 0x400);
          int i = 25;
          int j = getResources().getIdentifier("status_bar_height", "dimen", "android");
          if (j > 0) {
            i = getResources().getDimensionPixelSize(j);
          }
          this.ac = i;
        }
        ((RelativeLayout.LayoutParams)this.bj.getLayoutParams()).topMargin = (this.E + this.ac);
        localTextView.setText(getString(2131298110));
        setTitle(2131298174);
        i(getString(2131298174));
        this.t.setVisibility(0);
        this.t.setClickable(false);
        setRequestedOrientation(1);
        label250:
        if (((localCallInfo.isCaller()) || (localCallInfo.getCallState() != Voip.CallState.RECEIVED_CALL)) && (!VoiceService.a(localCallInfo))) {
          break label444;
        }
        getWindow().addFlags(128);
      }
    }
    for (;;)
    {
      g(localCallInfo);
      return;
      bool = false;
      break;
      Log.i("voip/VoipActivityV2/updateLayoutForAudioAndVideoCall hide video");
      if (Build.VERSION.SDK_INT >= 21) {
        getWindow().setStatusBarColor(android.support.v4.content.b.c(this, 2131624092));
      }
      if (this.ad)
      {
        this.ad = false;
        localView = getWindow().getDecorView();
        localView.setSystemUiVisibility(localView.getSystemUiVisibility() & 0xFBFF);
      }
      localTextView.setText(getString(2131298149));
      setTitle(2131298138);
      i(getString(2131298138));
      this.t.setVisibility(8);
      this.s.setVisibility(8);
      this.aW.setVisibility(8);
      findViewById(2131756182).setVisibility(8);
      this.z = true;
      setRequestedOrientation(1);
      break label250;
      label444:
      getWindow().clearFlags(128);
    }
  }
  
  final void c(Voip.CallInfo paramCallInfo)
  {
    View localView2;
    if (((paramCallInfo == null) || (paramCallInfo.isVideoEnabled())) && (this.t != null))
    {
      paramCallInfo = findViewById(2131756193);
      View localView1 = findViewById(2131756185);
      localView2 = findViewById(2131756194);
      if ((this.q == null) || (!this.q.f)) {
        break label109;
      }
      if (this.y)
      {
        this.bw.setVisibility(0);
        localView1.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    a(this.bv, paramCallInfo);
    this.bv.setVisibility(0);
    localView2.setVisibility(8);
    paramCallInfo.setVisibility(0);
    return;
    label109:
    if (this.y)
    {
      this.bw.setVisibility(8);
      return;
    }
    this.bv.setVisibility(8);
  }
  
  final void d(Voip.CallInfo paramCallInfo)
  {
    Object localObject1 = paramCallInfo.getCallState();
    if ((localObject1 == Voip.CallState.RECEIVED_CALL) && (this.V)) {
      localObject1 = Voip.CallState.ACCEPT_SENT;
    }
    for (;;)
    {
      if (localObject1 != Voip.CallState.NONE) {}
      View localView1;
      View localView2;
      View localView3;
      for (int i = 1;; i = 0)
      {
        localView1 = findViewById(2131756241);
        localView2 = findViewById(2131756201);
        localView3 = findViewById(2131756210);
        if ((localView1 != null) && (this.M != null) && (localView2 != null)) {
          break;
        }
        Log.e("voip/VoipActivityV2/updateButtonStates/null");
        return;
      }
      if (localView1.getVisibility() == 0)
      {
        j = View.MeasureSpec.makeMeasureSpec(0, 0);
        int k = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.N.measure(j, k);
        j = this.N.getMeasuredHeight();
        if (Build.VERSION.SDK_INT < 11) {
          break label469;
        }
        ab.b(this.N, j);
      }
      Object localObject2;
      View localView4;
      for (;;)
      {
        ((AcceptCallLayout)findViewById(2131755333)).setAcceptCallListener(new AcceptCallLayout.a(this));
        ((DeclineCallLayout)findViewById(2131755330)).setDeclineCallListener(new DeclineCallLayout.a(this));
        ((ReplyCallLayout)findViewById(2131755336)).setDeclineCallWithMessageListener(new ReplyCallLayout.b(this));
        this.bo = ((ImageView)findViewById(2131755335));
        if (paramCallInfo.isVideoEnabled()) {
          this.bo.setImageDrawable(getResources().getDrawable(2130840108));
        }
        this.bp = ((ImageView)findViewById(2131755332));
        this.bq = ((ImageView)findViewById(2131755338));
        this.bs = ((TextView)findViewById(2131756243));
        this.H = ((TextView)findViewById(2131756242));
        this.I = ((TextView)findViewById(2131756244));
        localObject2 = findViewById(2131755334);
        localView4 = findViewById(2131755331);
        View localView5 = findViewById(2131755337);
        hideView(localView4);
        hideView(localView5);
        AnimationSet localAnimationSet = d.d(this.bo);
        this.bo.startAnimation(localAnimationSet);
        this.bs.setVisibility(0);
        showView((View)localObject2);
        this.bo.setOnTouchListener(ast.a(this));
        this.bp.setOnTouchListener(asu.a(this, localView4, (View)localObject2));
        this.bq.setOnTouchListener(asv.a(this, localView5, (View)localObject2));
        localObject2 = this.Y;
        this.Y = ((Voip.CallState)localObject1);
        localView3.setVisibility(8);
        s();
        if (this.z) {
          break;
        }
        localView1.setVisibility(8);
        return;
        label469:
        this.N.setVisibility(4);
      }
      if (paramCallInfo.isVideoEnabled())
      {
        localView2.setBackgroundResource(0);
        this.bj.setBackgroundResource(0);
        this.bi.setBackgroundResource(0);
      }
      while (localObject1 == Voip.CallState.RECEIVED_CALL)
      {
        Log.i("voip/VoipActivityV2/updateButtonStates/answerCallView/visible");
        localView1.setVisibility(0);
        this.M.setVisibility(8);
        return;
        localView2.setBackgroundColor(getResources().getColor(2131624102));
        paramCallInfo = (RelativeLayout.LayoutParams)this.N.getLayoutParams();
        paramCallInfo.bottomMargin = 0;
        this.N.setLayoutParams(paramCallInfo);
      }
      Log.i("voip/VoipActivityV2/updateButtonStates");
      localView1.setVisibility(8);
      this.M.setVisibility(0);
      if (Build.VERSION.SDK_INT >= 11)
      {
        ab.b(this.N, 0.0F);
        label618:
        localView2.setVisibility(0);
        paramCallInfo = (ImageButton)findViewById(2131756209);
        localObject1 = findViewById(2131756202);
        localView1 = findViewById(2131756204);
        localView2 = findViewById(2131756205);
        localView3 = findViewById(2131756206);
        localView4 = findViewById(2131756203);
        if (i == 0) {
          break label777;
        }
      }
      label777:
      for (int j = 0;; j = 4)
      {
        paramCallInfo.setVisibility(j);
        if (("disable_animation".equals(this.aX)) || (i == 0) || (localObject2 != Voip.CallState.RECEIVED_CALL)) {
          break;
        }
        Log.i("voip/VoipActivityV2/updateButtonStates/animateButtonIn");
        a(paramCallInfo, 0);
        a((View)localObject1, 100);
        if (localView4.isShown()) {
          a(localView1, 100);
        }
        a(localView2, 150);
        a(localView3, 200);
        return;
        this.N.setVisibility(0);
        break label618;
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.q != null) && (!this.q.m()) && (this.q.e)) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  final boolean e(Voip.CallInfo paramCallInfo)
  {
    return (this.U) && (paramCallInfo != null) && (paramCallInfo.isVideoEnabled()) && (paramCallInfo.isVideoRenderStarted());
  }
  
  public void hideView(View paramView)
  {
    paramView.clearAnimation();
    paramView.setVisibility(4);
  }
  
  public final void j()
  {
    if (c(null, null)) {
      c(getString(2131296382));
    }
  }
  
  @TargetApi(11)
  final void l()
  {
    View localView = getWindow().getDecorView();
    localView.setSystemUiVisibility(localView.getSystemUiVisibility() | 0x4);
  }
  
  final void n()
  {
    View localView = findViewById(2131756226);
    if (localView != null) {
      if (!av.d()) {
        break label26;
      }
    }
    label26:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  final void o()
  {
    TextView localTextView = (TextView)findViewById(2131756232);
    if ((av.d()) && (this.J != a.a))
    {
      if (this.J != a.c) {
        break label45;
      }
      localTextView.setText(Voip.getStreamStatistics());
    }
    label45:
    while (this.J != a.b) {
      return;
    }
    localTextView.setText(Voip.getStreamStatisticsShort());
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    Voip.CallInfo localCallInfo = Voip.getCallInfo();
    if ((localCallInfo == null) || (localCallInfo.getCallState() == Voip.CallState.NONE)) {}
    do
    {
      int i;
      do
      {
        return;
        if (paramConfiguration.orientation != this.ae)
        {
          Log.i("voip/VoipActivityV2/onConfigurationChanged orientation changed from " + this.ae + " to " + paramConfiguration.orientation);
          this.ae = paramConfiguration.orientation;
        }
        i = getWindowManager().getDefaultDisplay().getRotation() * 90;
      } while (i == this.af);
      Log.i("voip/VoipActivityV2/onConfigurationChanged rotation changed from " + this.af + " to " + i);
      this.af = i;
      Voip.stopVideoRenderStream();
      Voip.videoOrientationChanged(i);
      this.N.clearAnimation();
      this.M.clearAnimation();
    } while ((this.aU == null) || (Build.VERSION.SDK_INT < 11));
    this.aU.cancel();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    boolean bool2 = true;
    Log.i("voip/VoipActivity/onCreate " + this);
    super.onCreate(paramBundle);
    CallRatingActivity.a(this.aq);
    CallSpamActivity.a(this.aq);
    paramBundle = Voip.getCallInfo();
    if ((paramBundle == null) || (paramBundle.getCallState() == Voip.CallState.NONE))
    {
      finish();
      if (getIntent().getBooleanExtra("fromCallNotification", false))
      {
        Log.d("voip/VoipActivity/create/redirect_to_voice_service");
        this.bG.b();
        paramBundle = new Intent("start_call", null, u.a(), VoiceService.class);
        paramBundle.putExtra("jid", getIntent().getStringExtra("jid"));
        paramBundle.putExtra("call_from", 5);
        paramBundle.putExtra("video_call", getIntent().getBooleanExtra("video_call", false));
        startService(paramBundle);
        return;
      }
      Log.e("voip/VoipActivity/create/call_not_active");
      return;
    }
    this.ak = false;
    getWindow().addFlags(2621440);
    setContentView(al.a(this.aq, getLayoutInflater(), 2130903399));
    c.a().a(this.bx, false);
    this.bv = findViewById(2131756192);
    this.bw = findViewById(2131756184);
    this.bj = findViewById(2131756234);
    this.bi = findViewById(2131756240);
    if (paramBundle.isVideoEnabled())
    {
      this.E = ((RelativeLayout.LayoutParams)this.bj.getLayoutParams()).topMargin;
      this.F = ((RelativeLayout.LayoutParams)this.bi.getLayoutParams()).topMargin;
    }
    this.O = ((TextView)findViewById(2131756188));
    aoa.b(this.O);
    aoa.b((TextView)findViewById(2131756197));
    this.P = ((TextEmojiLabel)findViewById(2131755507));
    this.P.setOnClickListener(new at()
    {
      public final void a(View paramAnonymousView)
      {
        if (av.d())
        {
          Log.i("voip/marking_bad_audio_quality");
          VoipActivityV2.this.aq.b(VoipActivityV2.this, "marking_bad_audio_quality", 0);
        }
      }
    });
    this.bh = ((ThumbnailButton)findViewById(2131755363));
    this.bl = this.bh.getLayoutParams().width;
    this.bm = this.bh.b;
    this.bI = di.a().a(this.bl, this.bm);
    Object localObject = (ImageButton)findViewById(2131756229);
    this.J = a.a;
    ((ImageButton)localObject).setOnClickListener(ass.a(this));
    B();
    n();
    this.N = findViewById(2131755524);
    this.G = new bj(this);
    this.br = ((ImageButton)findViewById(2131756209));
    this.br.setOnClickListener(ata.a(this));
    localObject = (ImageButton)findViewById(2131756206);
    ((ImageButton)localObject).setOnClickListener(atb.a(this, paramBundle, (ImageButton)localObject));
    findViewById(2131756205).setOnClickListener(atc.a(this));
    findViewById(2131756202).setOnClickListener(atd.a(this));
    findViewById(2131756204).setOnClickListener(ate.a(this));
    localObject = findViewById(2131756241);
    if (paramBundle.isCaller()) {
      ((View)localObject).setVisibility(8);
    }
    this.w = new SurfaceHolder.Callback()
    {
      public final void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        Log.i("voip/VoipActivityV2/video/display/surfaceChanged " + paramAnonymousSurfaceHolder + ", format: 0x" + Integer.toHexString(paramAnonymousInt1) + ", size: " + paramAnonymousInt2 + "x" + paramAnonymousInt3);
        VoipActivityV2.a(VoipActivityV2.this, paramAnonymousSurfaceHolder.getSurface());
        paramAnonymousSurfaceHolder = Voip.getCallInfo();
        if ((paramAnonymousSurfaceHolder == null) || (paramAnonymousSurfaceHolder.getCallState() == Voip.CallState.NONE)) {}
        do
        {
          do
          {
            return;
          } while (!VoipActivityV2.a(VoipActivityV2.this, paramAnonymousSurfaceHolder));
          if (Voip.setVideoDisplaySurface(VoipActivityV2.f(VoipActivityV2.this)) == 0) {
            break;
          }
        } while (VoipActivityV2.a(VoipActivityV2.this) == null);
        VoipActivityV2.a(VoipActivityV2.this).a(VoiceService.e.v, null);
        return;
        Voip.startVideoRenderStream();
      }
      
      public final void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        Log.i("voip/VoipActivityV2/video/display/surfaceCreated " + paramAnonymousSurfaceHolder);
        VoipActivityV2.d(VoipActivityV2.this);
        if (VoipActivityV2.e(VoipActivityV2.this))
        {
          VoipActivityV2.b(VoipActivityV2.this);
          return;
        }
        VoipActivityV2.c(VoipActivityV2.this);
      }
      
      public final void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        Log.i("voip/VoipActivityV2/video/display/surfaceDestroyed " + paramAnonymousSurfaceHolder);
        VoipActivityV2.a(VoipActivityV2.this, null);
        Voip.setVideoDisplaySurface(null);
        Voip.stopVideoRenderStream();
      }
    };
    this.x = new SurfaceHolder.Callback()
    {
      public final void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        Log.i("voip/VoipActivityV2/video/preview/surfaceChanged " + paramAnonymousSurfaceHolder + ", format: 0x" + Integer.toHexString(paramAnonymousInt1) + ", size: " + paramAnonymousInt2 + "x" + paramAnonymousInt3);
      }
      
      public final void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        Log.i("voip/VoipActivityV2/video/preview/surfaceCreated " + paramAnonymousSurfaceHolder);
        VoipActivityV2.b(VoipActivityV2.this, paramAnonymousSurfaceHolder.getSurface());
        if (VoipActivityV2.e(VoipActivityV2.this)) {}
        for (paramAnonymousSurfaceHolder = VoipActivityV2.g(VoipActivityV2.this);; paramAnonymousSurfaceHolder = VoipActivityV2.h(VoipActivityV2.this))
        {
          if (PjCamera.setSurfaceView(paramAnonymousSurfaceHolder) != 0) {
            VoipActivityV2.i(VoipActivityV2.this);
          }
          VoipActivityV2.d(VoipActivityV2.this);
          if (!VoipActivityV2.e(VoipActivityV2.this)) {
            break;
          }
          VoipActivityV2.c(VoipActivityV2.this);
          return;
        }
        VoipActivityV2.b(VoipActivityV2.this);
      }
      
      public final void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        Log.i("voip/VoipActivityV2/video/preview/surfaceDestroyed " + paramAnonymousSurfaceHolder);
        VoipActivityV2.b(VoipActivityV2.this, null);
        PjCamera.setSurfaceView(null);
      }
    };
    this.s = ((SurfaceView)findViewById(2131756183));
    this.s.setOnClickListener(atf.a(this));
    this.t = ((SurfaceView)findViewById(2131756191));
    this.aV = atg.a(this);
    this.t.setOnClickListener(this.aV);
    this.aj = true;
    this.aT = this.aq.d();
    int i = this.aQ.D();
    if (i >= 0)
    {
      if ((i & 0x1) != 0) {
        break label906;
      }
      bool1 = true;
      label709:
      this.aT = bool1;
      if ((i & 0x2) != 0) {
        break label911;
      }
    }
    label906:
    label911:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.aj = bool1;
      this.y = false;
      this.s.getHolder().addCallback(this.w);
      this.t.getHolder().addCallback(this.x);
      this.L = findViewById(16908290);
      this.M = findViewById(2131756208);
      this.aW = ((ImageView)findViewById(2131756195));
      c();
      localObject = getIntent();
      setIntent((Intent)localObject);
      this.aX = ((Intent)localObject).getStringExtra("fixEndCall");
      this.bA = new dh.a()
      {
        public final void b(String paramAnonymousString)
        {
          String str = Voip.getPeerJid();
          if ((str != null) && (TextUtils.equals(paramAnonymousString, str)))
          {
            VoipActivityV2.a(VoipActivityV2.this, str);
            VoipActivityV2.j(VoipActivityV2.this);
          }
        }
      };
      this.bz.registerObserver(this.bA);
      this.r = new Handler(ath.a(this, paramBundle));
      if (!paramBundle.isVideoEnabled()) {
        break;
      }
      this.be = new i(this);
      if (!this.be.canDetectOrientation()) {
        break label916;
      }
      this.be.enable();
      return;
      bool1 = false;
      break label709;
    }
    label916:
    this.be = null;
  }
  
  protected void onDestroy()
  {
    Log.i("voip/VoipActivityV2/onDestroy " + this);
    super.onDestroy();
    c.a().a(this.bx);
    if (this.Z != null) {
      this.Z.cancel();
    }
    if (this.bA != null) {
      this.bz.unregisterObserver(this.bA);
    }
    if (this.q != null) {
      this.q.a(this);
    }
    if (this.be != null) {
      this.be.disable();
    }
    if (this.bI != null) {
      this.bI.a();
    }
  }
  
  public void onGlobalLayout()
  {
    if ((this.L.getWidth() == this.ag) && (this.L.getHeight() == this.ah)) {}
    Voip.CallInfo localCallInfo;
    do
    {
      return;
      Log.i("voip/VoipActivityV2/onGlobalLayout size: " + this.L.getWidth() + "x" + this.L.getHeight() + ", orientation: " + getResources().getConfiguration().orientation);
      this.ag = this.L.getWidth();
      this.ah = this.L.getHeight();
      x();
      localCallInfo = Voip.getCallInfo();
    } while ((localCallInfo == null) || (!i(localCallInfo)));
    if (this.ai == 0) {
      this.ai = ((int)TypedValue.applyDimension(1, 7.0F, getResources().getDisplayMetrics()));
    }
    if ((this.ae == 2) && (e(localCallInfo)) && (this.z) && (!this.A))
    {
      this.z = false;
      l();
      a(0L, localCallInfo);
    }
    PjCamera.updatePreviewOrientation();
    if (j(localCallInfo)) {
      this.t.setOnTouchListener(new g((byte)0));
    }
    D();
    E();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    int j = 0;
    Log.i("voip/VoipActivityV2/onKeyDown " + paramKeyEvent);
    Object localObject = Voip.getCallInfo();
    if ((this.q != null) && (localObject != null) && (((Voip.CallInfo)localObject).getCallState() != Voip.CallState.NONE))
    {
      int i;
      if (((Voip.CallInfo)localObject).getCallState() == Voip.CallState.RECEIVED_CALL) {
        switch (paramInt)
        {
        default: 
          i = 0;
          if (i != 0) {
            this.q.b();
          }
          break;
        }
      }
      do
      {
        return true;
        i = 1;
        break;
        switch (paramInt)
        {
        }
        for (i = j; (i != 0) || (e(paramInt)); i = 1)
        {
          Log.i("voip/VoipActivityV2/onKeyDown accept call from remote control");
          w();
          return true;
        }
        if (!d(paramInt)) {
          break label276;
        }
        Log.i("voip/VoipActivityV2/onKeyDown reject call from remote control");
        q();
        return true;
        if ((d(paramInt)) || ((e(paramInt)) && (paramKeyEvent.getRepeatCount() == 0)))
        {
          Log.i("voip/VoipActivityV2/onKeyDown end call from remote control");
          p();
          return true;
        }
        if ((paramInt != 24) && (paramInt != 25)) {
          break label276;
        }
        localObject = this.q;
        if (paramInt == 24) {
          bool = true;
        }
      } while (((VoiceService)localObject).a(bool));
    }
    label276:
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    String str = paramIntent.getAction();
    Log.i("voip/VoipActivityV2/onNewIntent " + paramIntent + ", action " + str + ", is finishing " + isFinishing());
    super.onNewIntent(paramIntent);
    if (n.equals(str)) {
      w();
    }
    for (;;)
    {
      aw.a(u.a()).a(10);
      return;
      if (o.equals(str))
      {
        paramIntent = paramIntent.getStringExtra("confirmationString");
        if ((this.X == null) && (Voip.e()))
        {
          Log.w("voip/VoipActivityV2/showEndCallConfirmationDialog.");
          this.X = b.a(paramIntent);
          this.X.a(j_(), null);
        }
      }
      else if (p.equals(str))
      {
        if (this.q != null) {
          this.q.a(VoiceService.e.b, null);
        }
      }
      else
      {
        if (isFinishing())
        {
          Log.e("voip/VoipActivityV2/new-intent activity is finishing, do nothing");
          return;
        }
        setIntent(paramIntent);
        x();
        b(Voip.getPeerJid());
        A();
        if (paramIntent.getBooleanExtra("newCall", false))
        {
          Log.i("voip/VoipActivityV2/onNewIntent/NewCall clearing states");
          u();
          this.aX = paramIntent.getStringExtra("fixEndCall");
        }
      }
    }
  }
  
  protected void onPause()
  {
    Log.i("voip/VoipActivityV2/onPause " + this);
    super.onPause();
    if (this.Q) {
      Log.i("voip/VoipActivityV2/unbindService");
    }
    try
    {
      unbindService(this.by);
      this.Q = false;
      s();
      C();
      this.S = false;
      this.bd = false;
      if (this.be != null) {
        this.be.disable();
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Log.e(localIllegalArgumentException);
      }
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int k = 0;
    if (paramInt != 0) {
      super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
    Voip.CallInfo localCallInfo;
    do
    {
      return;
      localCallInfo = Voip.getCallInfo();
    } while ((localCallInfo == null) || (localCallInfo.getCallState() == Voip.CallState.NONE));
    Log.i("voip/VoipActivityV2/onRequestPermissionsResult permissions: " + Arrays.toString(paramArrayOfString) + ", grantResults: " + Arrays.toString(paramArrayOfInt));
    label79:
    int j;
    int i;
    if (paramArrayOfInt.length > 0)
    {
      paramInt = 1;
      j = 0;
      i = 0;
      label85:
      if (j >= paramArrayOfInt.length) {
        break label209;
      }
      if (paramArrayOfInt[0] == 0) {
        break label159;
      }
      paramInt = k;
    }
    label159:
    label209:
    for (;;)
    {
      if (paramInt != 0)
      {
        Log.d("voip/VoipActivityV2/onRequestPermissionsResult granted, starting call");
        if (this.q == null) {
          break;
        }
        if ((localCallInfo.isVideoEnabled()) && (i != 0))
        {
          Voip.refreshVideoDevice();
          if (Voip.setVideoPreviewSurface(null) != 0) {
            y();
          }
        }
        this.q.c();
        return;
        paramInt = 0;
        break label79;
        if ("android.permission.CAMERA".equals(paramArrayOfString[j])) {
          i = 1;
        }
        j += 1;
        break label85;
      }
      Log.w("voip/VoipActivityV2/onRequestPermissionsResult/failed_no_record_audio_permission");
      if (this.q == null) {
        break;
      }
      this.q.b(VoiceService.e.w, null);
      return;
    }
  }
  
  protected void onResume()
  {
    Log.i("voip/VoipActivityV2/onResume " + this);
    super.onResume();
    this.S = true;
    this.T = true;
    Voip.CallInfo localCallInfo = Voip.getCallInfo();
    if ((localCallInfo == null) || (localCallInfo.getCallState() == Voip.CallState.NONE)) {}
    do
    {
      do
      {
        return;
        z();
        this.r.sendEmptyMessageDelayed(1, 500L);
        Log.i("voip/VoipActivityV2/bindService");
        bindService(new Intent(u.a(), VoiceService.class), this.by, 1);
      } while (!localCallInfo.isVideoEnabled());
      Voip.startVideoCaptureStream();
    } while (this.be == null);
    this.be.enable();
  }
  
  protected void onStart()
  {
    Log.i("voip/VoipActivityV2/onStart " + this);
    super.onStart();
    this.U = true;
    this.L.getViewTreeObserver().addOnGlobalLayoutListener(this);
    if (this.q != null) {
      this.q.v = false;
    }
    Voip.CallInfo localCallInfo = Voip.getCallInfo();
    if ((localCallInfo == null) || (localCallInfo.getCallState() == Voip.CallState.NONE)) {
      if (getIntent().hasExtra("showCallFailedMessage")) {
        t();
      }
    }
    do
    {
      return;
      finish();
      Log.e("voip/VoipActivityV2/onStart call_not_active, finishing");
      return;
      x();
      b(localCallInfo.getPeerId());
      A();
    } while ((!this.ab) || (localCallInfo.getCallState() != Voip.CallState.RECEIVED_CALL));
    startService(new Intent("refresh_notification", null, this, VoiceService.class));
    this.ab = false;
  }
  
  protected void onStop()
  {
    Log.i("voip/VoipActivityV2/onStop " + this);
    super.onStop();
    this.U = false;
    Voip.CallInfo localCallInfo;
    if (this.L != null)
    {
      if (Build.VERSION.SDK_INT < 16) {
        this.L.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      }
    }
    else
    {
      if (this.r != null) {
        this.r.removeCallbacksAndMessages(null);
      }
      s();
      C();
      localCallInfo = Voip.getCallInfo();
      if ((localCallInfo != null) && (localCallInfo.getCallState() != Voip.CallState.NONE)) {
        break label111;
      }
    }
    label111:
    do
    {
      return;
      this.L.getViewTreeObserver().removeOnGlobalLayoutListener(this);
      break;
      if ((localCallInfo.getCallState() == Voip.CallState.RECEIVED_CALL) && (Build.VERSION.SDK_INT >= 21))
      {
        Intent localIntent = new Intent("refresh_notification", null, this, VoiceService.class);
        localIntent.putExtra("headsup", true);
        startService(localIntent);
        this.ab = true;
      }
      if (localCallInfo.isVideoEnabled())
      {
        Voip.stopVideoCaptureStream();
        if ((localCallInfo.getCallState() != Voip.CallState.NONE) && (Build.VERSION.SDK_INT < 19) && (this.u != null))
        {
          Log.i("voip/VoipActivityV2/onStop finish current activity, will recreate on foreground");
          if (this.q != null) {
            this.q.a(this);
          }
          finish();
        }
        Log.i("voip/VoipActivityV2/onStop hide FullSurfaceView, to make sure pipSurfaceView will be created first after onResume()");
        this.s.setVisibility(8);
      }
    } while ((this.q == null) || (this.aR.d()));
    Log.i("voip/VoipActivityV2/onStop. App is put to background, mark to show VoipActivity again when foregrounded.");
    this.q.v = true;
  }
  
  public void onUserInteraction()
  {
    this.T = true;
  }
  
  protected void onUserLeaveHint()
  {
    Log.i("voip/VoipActivityV2/onUserLeaveHint");
    this.T = false;
  }
  
  final void p()
  {
    Log.i("voip/VoipActivityV2/call/end");
    if (this.q != null) {
      this.q.a(VoiceService.e.a, null);
    }
    this.bd = true;
  }
  
  public final boolean p_()
  {
    return this.T;
  }
  
  final void q()
  {
    Log.i("voip/VoipActivityV2/call/reject");
    d.a(this.bo, 100L, 4);
    d.a(this.bp, 100L, 4);
    d.a(this.bq, 100L, 4);
    if (this.q != null) {
      this.q.d();
    }
  }
  
  public final void q_()
  {
    this.r.sendEmptyMessage(5);
  }
  
  final void r()
  {
    Voip.CallInfo localCallInfo = Voip.getCallInfo();
    if ((localCallInfo == null) || (localCallInfo.getCallState() == Voip.CallState.NONE)) {}
    while ((!this.z) || (!e(localCallInfo))) {
      return;
    }
    this.r.removeMessages(3);
    this.r.sendEmptyMessageDelayed(3, 8000L);
  }
  
  public final void r_()
  {
    this.r.sendEmptyMessage(5);
  }
  
  final void s()
  {
    if (this.D != null)
    {
      Log.d("VoipActivityV2 vm cancelVoiceMail jid: " + this.bc + " voicemail: " + this.D);
      this.D.a(false);
      this.bc = null;
    }
    this.D = null;
  }
  
  public final void s_()
  {
    a.d.b();
    Log.i("voip/VoipActivityV2/videoRenderStarted.");
    if ((this.y) || (this.s.getVisibility() == 0)) {
      if (!this.y) {
        break label77;
      }
    }
    label77:
    for (SurfaceHolder localSurfaceHolder = this.t.getHolder();; localSurfaceHolder = this.s.getHolder())
    {
      if (localSurfaceHolder != null)
      {
        this.w.surfaceCreated(localSurfaceHolder);
        this.w.surfaceChanged(localSurfaceHolder, 0, 0, 0);
      }
      x();
      r();
      return;
    }
  }
  
  public void showView(View paramView)
  {
    paramView.setVisibility(0);
    if (Build.VERSION.SDK_INT >= 11)
    {
      ((AnimatingArrowsLayout)paramView).b.start();
      return;
    }
    ((anc)paramView).a();
  }
  
  public final void t_()
  {
    a.d.b();
    Log.i("voip/VoipActivityV2/videoPreviewReady.");
    if (this.v != null) {
      if (!this.y) {
        break label55;
      }
    }
    label55:
    for (SurfaceHolder localSurfaceHolder = this.s.getHolder();; localSurfaceHolder = this.t.getHolder())
    {
      this.x.surfaceCreated(localSurfaceHolder);
      this.x.surfaceChanged(localSurfaceHolder, 0, 0, 0);
      return;
    }
  }
  
  public final void u_()
  {
    Log.i("voip/VoipActivityV2/videoCaptureStarted.");
    this.t.setBackgroundResource(0);
  }
  
  public final void v_()
  {
    a.d.b();
    Voip.CallInfo localCallInfo = Voip.getCallInfo();
    if ((localCallInfo == null) || (localCallInfo.getCallState() == Voip.CallState.NONE)) {}
    while (!this.y) {
      return;
    }
    D();
  }
  
  static enum a {}
  
  public static final class b
    extends m
  {
    public final Dialog c(Bundle paramBundle)
    {
      paramBundle = i().getString("message");
      return new b.a(l()).b(paramBundle).a(true).a(2131296364, ati.a(this)).b(2131297023, atj.a(this)).a();
    }
  }
  
  final class c
  {
    private c() {}
    
    public final void onEvent(acz paramacz)
    {
      a.d.b();
      Window localWindow = VoipActivityV2.this.getWindow();
      View localView = ((ViewGroup)localWindow.getDecorView().findViewById(16908290)).getChildAt(0);
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      if (paramacz.a)
      {
        Log.i("voip/voipactivity/ear-near. changing visibility of the window.");
        if (localView.getVisibility() == 0)
        {
          localLayoutParams.flags |= 0x400;
          localLayoutParams.screenBrightness = 0.1F;
          if (Build.VERSION.SDK_INT >= 11) {
            localWindow.getDecorView().setSystemUiVisibility(localWindow.getDecorView().getSystemUiVisibility() | 0x2);
          }
          localView.setVisibility(4);
          localWindow.setAttributes(localLayoutParams);
        }
        VoipActivityV2.z(VoipActivityV2.this).removeMessages(2);
        VoipActivityV2.z(VoipActivityV2.this).sendEmptyMessageDelayed(2, 3000L);
      }
      do
      {
        return;
        Log.i("voip/voipactivity/ear-far. changing visibility of the window.");
        if (localView.getVisibility() == 4)
        {
          localLayoutParams.flags &= 0xFBFF;
          localLayoutParams.screenBrightness = -1.0F;
          if (Build.VERSION.SDK_INT >= 11) {
            localWindow.getDecorView().setSystemUiVisibility(localWindow.getDecorView().getSystemUiVisibility() & 0xFFFFFFFD);
          }
          localView.setVisibility(0);
          localWindow.setAttributes(localLayoutParams);
        }
        VoipActivityV2.z(VoipActivityV2.this).removeMessages(2);
        paramacz = Voip.getCallInfo();
      } while ((VoipActivityV2.a(VoipActivityV2.this) == null) || (!VoipActivityV2.a(VoipActivityV2.this).u) || (paramacz == null) || (paramacz.getBytesReceived() != 0L) || ((paramacz.getCallState() != Voip.CallState.ACTIVE) && (paramacz.getCallState() != Voip.CallState.ACCEPT_SENT) && (paramacz.getCallState() != Voip.CallState.ACCEPT_RECEIVED)));
      VoipActivityV2.b(VoipActivityV2.this, VoipActivityV2.this.getString(2131298154));
    }
    
    public final void onEvent(ag paramag)
    {
      VoipActivityV2.this.setVolumeControlStream(paramag.a);
    }
  }
  
  public static final class d
    extends m
  {
    public final Dialog c(Bundle paramBundle)
    {
      paramBundle = i().getString("message");
      return new b.a(l()).b(paramBundle).a(true).a(2131297331, atk.a(this)).a();
    }
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      if ((l() != null) && (!Voip.e())) {
        l().finish();
      }
    }
  }
  
  public static final class e
    extends m
  {
    private final pv aa = pv.a();
    private final e ab = e.a();
    private final atv ac = atv.a();
    private boolean ad;
    private boolean ae;
    private String[] af;
    
    public final Dialog c(Bundle paramBundle)
    {
      Dialog localDialog = new Dialog(l());
      this.ad = i().getBoolean("microphone");
      this.ae = i().getBoolean("camera");
      boolean bool1;
      String str;
      Object localObject;
      int i;
      Bundle localBundle;
      label225:
      label284:
      boolean bool2;
      if ((this.ad) || (this.ae))
      {
        bool1 = true;
        a.d.a(bool1, "either microphone or camera permission should be needed");
        localDialog.requestWindowFeature(1);
        localDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        localDialog.setCancelable(false);
        localDialog.setCanceledOnTouchOutside(false);
        localDialog.setContentView(al.a(this.aa, l().getLayoutInflater(), 2130903331, null, false));
        if ((!this.ae) || (!this.ad)) {
          break label509;
        }
        ((ImageView)localDialog.findViewById(2131755899)).setImageResource(2130840440);
        localDialog.findViewById(2131755899).setVisibility(0);
        ((ImageView)localDialog.findViewById(2131756004)).setImageResource(2130840441);
        ((ImageView)localDialog.findViewById(2131756005)).setImageResource(2130840436);
        localDialog.findViewById(2131756005).setVisibility(0);
        paramBundle = new String[2];
        paramBundle[0] = "android.permission.CAMERA";
        str = "android.permission.RECORD_AUDIO";
        localObject = paramBundle;
        i = 1;
        localBundle = paramBundle;
        paramBundle = str;
        localObject[i] = paramBundle;
        this.af = localBundle;
        paramBundle = i().getString("jid");
        localDialog.findViewById(2131755378).setOnClickListener(new at()
        {
          public final void a(View paramAnonymousView)
          {
            VoipActivityV2.e.a(VoipActivityV2.e.this);
            VoipActivityV2.e.this.a();
          }
        });
        if (paramBundle == null) {
          break label624;
        }
        paramBundle = this.ab.d(paramBundle).a(l());
        localObject = (Button)localDialog.findViewById(2131755379);
        bool2 = ((l)c.a().a(l.class)).a;
        boolean bool3 = RequestPermissionActivity.a(l(), this.af);
        boolean bool4 = RequestPermissionActivity.a(this.ac, this.af);
        if ((bool3) || (bool4)) {
          break label637;
        }
        bool1 = true;
        label350:
        Log.i("voip/VoipActivityV2/permissions needMicPermission=" + this.ad + ", needCameraPermission=" + this.ae + ", isScreenLocked=" + bool2 + ", showRational=" + bool3 + ", isFistTimeRequest=" + bool4 + ", permanentDenial=" + bool1);
        if (!bool1) {
          break label705;
        }
        if (!bool2) {
          break label663;
        }
        if ((!this.ae) || (!this.ad)) {
          break label642;
        }
        i = 2131297396;
      }
      for (;;)
      {
        ((TextView)localDialog.findViewById(2131756006)).setText(m().getString(i, new Object[] { paramBundle }));
        ((Button)localObject).setText(2131297401);
        ((Button)localObject).setOnClickListener(new at()
        {
          public final void a(View paramAnonymousView)
          {
            VoipActivityV2.e.a(VoipActivityV2.e.this);
            VoipActivityV2.e.this.a();
            d.d(VoipActivityV2.e.this.l());
          }
        });
        return localDialog;
        bool1 = false;
        break;
        label509:
        paramBundle = (ImageView)localDialog.findViewById(2131756004);
        localObject = m();
        if (this.ad) {}
        for (i = 2130840440;; i = 2130840436)
        {
          paramBundle.setImageDrawable(((Resources)localObject).getDrawable(i));
          localDialog.findViewById(2131755899).setVisibility(8);
          localDialog.findViewById(2131756005).setVisibility(8);
          paramBundle = new String[1];
          if (!this.ad) {
            break label606;
          }
          str = "android.permission.RECORD_AUDIO";
          localObject = paramBundle;
          localBundle = paramBundle;
          i = 0;
          paramBundle = str;
          break;
        }
        label606:
        str = "android.permission.CAMERA";
        localObject = paramBundle;
        localBundle = paramBundle;
        i = 0;
        paramBundle = str;
        break label225;
        label624:
        Log.e("voip/VoipActivityV2/permissions/jid is null");
        paramBundle = "Unknown";
        break label284;
        label637:
        bool1 = false;
        break label350;
        label642:
        if (this.ae)
        {
          i = 2131297354;
        }
        else
        {
          i = 2131297389;
          continue;
          label663:
          if ((this.ae) && (this.ad)) {
            i = 2131297395;
          } else if (this.ae) {
            i = 2131297353;
          } else {
            i = 2131297388;
          }
        }
      }
      label705:
      if (bool2) {
        if ((this.ae) && (this.ad)) {
          i = 2131297397;
        }
      }
      for (;;)
      {
        ((TextView)localDialog.findViewById(2131756006)).setText(m().getString(i, new Object[] { paramBundle }));
        ((Button)localObject).setOnClickListener(new at()
        {
          public final void a(View paramAnonymousView)
          {
            VoipActivityV2.e.this.a();
            RequestPermissionActivity.a(VoipActivityV2.e.this.l(), VoipActivityV2.e.b(VoipActivityV2.e.this), VoipActivityV2.e.c(VoipActivityV2.e.this));
          }
        });
        return localDialog;
        if (this.ae)
        {
          i = 2131297355;
        }
        else
        {
          i = 2131297390;
          continue;
          if ((this.ae) && (this.ad)) {
            i = 2131297398;
          } else if (this.ae) {
            i = 2131297356;
          } else {
            i = 2131297391;
          }
        }
      }
    }
    
    public final void e()
    {
      super.e();
      c().getWindow().setLayout(m().getDisplayMetrics().widthPixels, m().getDisplayMetrics().heightPixels);
    }
  }
  
  static final class f
  {
    int a;
    int b;
    int c;
    int d;
    
    public f(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
      this.d = paramInt4;
    }
  }
  
  final class g
    implements View.OnTouchListener
  {
    float a;
    float b;
    int c;
    int d;
    int e;
    int f;
    VoipActivityV2.f g;
    int h;
    int i;
    double j;
    int k;
    float l;
    float m;
    float n;
    float o;
    long p;
    
    private g() {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      if (paramView != VoipActivityV2.h(VoipActivityV2.this))
      {
        Log.i("voip/VoipActivityV2/PiPOnTouchListner/ ignore, wrong view " + paramView);
        return false;
      }
      switch (paramMotionEvent.getAction())
      {
      }
      for (;;)
      {
        return true;
        if (this.g == null)
        {
          Log.i("voip/VoipActivityV2/pipSurfaceView/onTouch ACTION_MOVE dispatched before ACTION_DOWN, ignore");
          return true;
        }
        localLayoutParams.rightMargin = Math.min(this.g.b, Math.max(this.g.a, this.c + (int)(this.a - paramMotionEvent.getRawX())));
        localLayoutParams.leftMargin = (VoipActivityV2.p(VoipActivityV2.this) - localLayoutParams.rightMargin - localLayoutParams.width);
        localLayoutParams.topMargin = Math.min(this.g.d, Math.max(this.g.c, this.d + (int)(paramMotionEvent.getRawY() - this.b)));
        paramView.setLayoutParams(localLayoutParams);
        this.k = Math.max(Math.max(Math.abs(localLayoutParams.rightMargin - this.c), Math.abs(localLayoutParams.topMargin - this.d)), this.k);
        long l1 = paramMotionEvent.getEventTime() - this.p;
        if (l1 > 0L)
        {
          this.n = ((paramMotionEvent.getRawX() - this.l) * 1000.0F / (float)l1);
          this.o = ((paramMotionEvent.getRawY() - this.m) * 1000.0F / (float)l1);
        }
        this.l = paramMotionEvent.getRawX();
        this.m = paramMotionEvent.getRawY();
        this.p = paramMotionEvent.getEventTime();
        continue;
        VoipActivityV2.b(VoipActivityV2.this, false);
        if (this.g == null)
        {
          Log.i("voip/VoipActivityV2/pipSurfaceView/onTouch ACTION_UP dispatched before ACTION_DOWN, ignore");
          return true;
        }
        if (this.k < this.j / 60.0D)
        {
          Log.i("voip/VoipActivityV2/pipSurfaceView/onTouch ACTION_UP treat as click event  maxDistance: " + this.k + ", screenLength: " + this.j);
          VoipActivityV2.b(VoipActivityV2.this);
          VoipActivityV2.B(VoipActivityV2.this).onClick(VoipActivityV2.h(VoipActivityV2.this));
          return true;
        }
        float f5 = (float)Math.sqrt(this.n * this.n + this.o * this.o);
        if (f5 > this.j) {}
        float f3;
        float f4;
        double d1;
        for (boolean bool1 = true;; bool1 = false)
        {
          float f2 = paramMotionEvent.getRawX();
          float f1 = paramMotionEvent.getRawY();
          f3 = f1;
          f4 = f2;
          if (!bool1) {
            break;
          }
          d1 = this.n / f5 * 64.0F;
          double d2 = this.o / f5 * 64.0F;
          for (;;)
          {
            f3 = f1;
            f4 = f2;
            if (f2 < 0.0F) {
              break;
            }
            f3 = f1;
            f4 = f2;
            if (f2 > this.h) {
              break;
            }
            f3 = f1;
            f4 = f2;
            if (f1 < 0.0F) {
              break;
            }
            f3 = f1;
            f4 = f2;
            if (f1 > this.i) {
              break;
            }
            f2 = (float)(f2 + d1);
            f1 = (float)(f1 + d2);
          }
        }
        paramView = VoipActivityV2.this;
        if (f4 >= this.h / 2)
        {
          bool2 = true;
          label630:
          VoipActivityV2.d(paramView, bool2);
          paramView = VoipActivityV2.this;
          if (f3 < this.i / 2) {
            break label920;
          }
        }
        label920:
        for (boolean bool2 = true;; bool2 = false)
        {
          VoipActivityV2.e(paramView, bool2);
          paramView = VoipActivityV2.a(VoipActivityV2.this, localLayoutParams);
          if (paramView == null) {
            break;
          }
          int i1 = localLayoutParams.rightMargin - paramView.rightMargin;
          int i2 = paramView.topMargin - localLayoutParams.topMargin;
          d1 = Math.sqrt(i1 * i1 + i2 * i2);
          l1 = Math.max(200, (int)(500.0D * d1 / this.j));
          Log.i("voip/VoipActivityV2/pipSurfaceView/onTouch ACTION_UP xVelocity: " + this.n + ", yVelocity: " + this.o + ", velocity: " + f5 + ", fling: " + bool1 + ", finalRawX: " + f4 + ", finalRawY: " + f3 + ", window size: " + this.h + "x" + this.i + "(" + this.j + "), pipAtRight: " + VoipActivityV2.C(VoipActivityV2.this) + ", pipAtBottom: " + VoipActivityV2.m(VoipActivityV2.this) + ", moving distance: " + d1 + ", duration: " + l1);
          VoipActivityV2.a(VoipActivityV2.this, l1, i1, i2);
          break;
          bool2 = false;
          break label630;
        }
        this.a = paramMotionEvent.getRawX();
        this.b = paramMotionEvent.getRawY();
        this.c = localLayoutParams.rightMargin;
        this.d = localLayoutParams.topMargin;
        this.e = paramView.getWidth();
        this.f = paramView.getHeight();
        VoipActivityV2.b(VoipActivityV2.this, true);
        paramView = VoipActivityV2.this.getWindowManager().getDefaultDisplay();
        this.h = paramView.getWidth();
        this.i = paramView.getHeight();
        this.j = Math.sqrt(this.h * this.h + this.i * this.i);
        this.k = 0;
        this.g = VoipActivityV2.b(VoipActivityV2.this, localLayoutParams);
        this.o = 0.0F;
        this.n = 0.0F;
        this.m = 0.0F;
        this.l = 0.0F;
        this.p = 0L;
        if (!VoipActivityV2.e(VoipActivityV2.this)) {
          VoipActivityV2.this.findViewById(2131756192).setVisibility(8);
        }
        Log.i("voip/VoipActivityV2/pipSurfaceView/onTouch ACTION_DOWN downX: " + this.a + ", downY: " + this.b + ", rightMargin: " + this.c + ", topMargin: " + this.d);
      }
    }
  }
  
  public static final class h
    extends m
  {
    public final Dialog c(Bundle paramBundle)
    {
      paramBundle = new b.a(l());
      String[] arrayOfString = m().getStringArray(2131689487);
      paramBundle.a(arrayOfString, atl.a(this, arrayOfString));
      paramBundle = paramBundle.a();
      paramBundle.setCanceledOnTouchOutside(true);
      return paramBundle;
    }
  }
  
  final class i
    extends OrientationEventListener
  {
    private int b = -1;
    
    public i(Context paramContext)
    {
      super();
    }
    
    public final void onOrientationChanged(int paramInt)
    {
      int i = 3;
      if (paramInt == -1) {}
      for (;;)
      {
        return;
        paramInt %= 360;
        if ((paramInt >= 330) || (paramInt < 30)) {
          paramInt = 0;
        }
        while ((paramInt != this.b) && (paramInt != -1))
        {
          Log.i("voip/VoipActivityV2/VideoOrientationListener/onOrientationChanged from: " + this.b + " to: " + paramInt);
          this.b = paramInt;
          Voip.videoOrientationChanged(paramInt * 90);
          paramInt = this.b;
          if (paramInt == 1) {
            paramInt = i;
          }
          for (;;)
          {
            paramInt *= 90;
            ImageButton localImageButton = (ImageButton)VoipActivityV2.this.findViewById(2131756209);
            View localView1 = VoipActivityV2.this.findViewById(2131756202);
            View localView2 = VoipActivityV2.this.findViewById(2131756205);
            View localView3 = VoipActivityV2.this.findViewById(2131756206);
            View localView4 = VoipActivityV2.this.findViewById(2131756236);
            View localView5 = VoipActivityV2.this.findViewById(2131756185);
            View localView6 = VoipActivityV2.this.findViewById(2131756193);
            View localView7 = VoipActivityV2.this.findViewById(2131756194);
            localImageButton.setRotation(paramInt);
            localView1.setRotation(paramInt);
            localView2.setRotation(paramInt);
            localView3.setRotation(paramInt);
            localView4.setRotation(paramInt);
            localView5.setRotation(paramInt);
            localView6.setRotation(paramInt);
            localView7.setRotation(paramInt);
            return;
            if ((paramInt >= 60) && (paramInt < 120))
            {
              paramInt = 1;
              break;
            }
            if ((paramInt >= 150) && (paramInt < 210))
            {
              paramInt = 2;
              break;
            }
            if ((paramInt < 240) || (paramInt >= 300)) {
              break label316;
            }
            paramInt = 3;
            break;
            if (paramInt == 3) {
              paramInt = 1;
            }
          }
          label316:
          paramInt = -1;
        }
      }
    }
  }
  
  final class j
  {
    String a;
    Activity b;
    TextView c;
    View d;
    TextView e;
    View f;
    float g;
    float h;
    float i = 0.0F;
    int j;
    Handler k;
    a l;
    aqy m;
    long n;
    long o;
    private boolean q;
    private int r;
    private PowerManager.WakeLock s;
    private final Runnable t = new Runnable()
    {
      public final void run()
      {
        VoipActivityV2.j.this.e.setVisibility(8);
        VoipActivityV2.j.this.e.clearAnimation();
      }
    };
    
    public j(Activity paramActivity, String paramString, boolean paramBoolean, int paramInt)
    {
      this.b = paramActivity;
      this.a = paramString;
      this.q = paramBoolean;
      this.r = paramInt;
      this.c = ((TextView)VoipActivityV2.this.findViewById(2131756221));
      this.e = ((TextView)VoipActivityV2.this.findViewById(2131756217));
      this.f = VoipActivityV2.this.findViewById(2131756222);
      this.d = VoipActivityV2.this.findViewById(2131756225);
      try
      {
        if (Settings.System.getInt(VoipActivityV2.this.getContentResolver(), "haptic_feedback_enabled") != 0) {
          ((Vibrator)VoipActivityV2.this.getSystemService("vibrator")).vibrate(75L);
        }
        VoipActivityV2.this.findViewById(2131756220).setVisibility(8);
        this.j = VoipActivityV2.this.getResources().getDimensionPixelSize(2131362113);
        return;
      }
      catch (Settings.SettingNotFoundException paramActivity)
      {
        for (;;)
        {
          Log.d("VoipActivityV2 vm vibrate exception", paramActivity);
        }
      }
    }
    
    static boolean a(long paramLong)
    {
      return paramLong > aic.s * 1048576L;
    }
    
    private void b()
    {
      if (this.e != null)
      {
        VoipActivityV2.this.aq.b(this.t);
        this.e.clearAnimation();
        this.e.setVisibility(8);
      }
    }
    
    final void a(boolean paramBoolean)
    {
      b();
      VoipActivityV2.r(VoipActivityV2.this).b(VoipActivityV2.this);
      Object localObject;
      if (this.l != null) {
        localObject = this.l.e();
      }
      try
      {
        this.l.c();
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            this.l.d();
            this.l = null;
            this.o = (SystemClock.elapsedRealtime() - this.n);
            l1 = ((File)localObject).length();
            bool = a(l1);
            if ((this.o >= 1000L) && (l1 > 99L)) {
              break;
            }
            i1 = 1;
            if ((!paramBoolean) || (bool) || (i1 != 0)) {
              break label328;
            }
            bool = true;
            Log.i("VoipActivityV2 vm sending: " + bool + " got send: " + paramBoolean + " duration: " + this.o + " filesize:" + l1);
            if (this.m != null)
            {
              this.m.s.w = ((int)(this.o / 1000L));
              this.m.s.t = l1;
              this.m.a(bool);
              this.m = null;
            }
            if (!bool) {
              break label333;
            }
            pb.a(this.b.getApplicationContext(), 1, l1, 1);
            VoipActivityV2.this.startActivity(Conversation.a(VoipActivityV2.u(VoipActivityV2.this).d(this.a)));
            if (this.k != null) {
              this.k.removeMessages(0);
            }
            if ((this.s != null) && (this.s.isHeld())) {
              this.s.release();
            }
            return;
            localException1 = localException1;
            Log.d("VoipActivityV2 vm stop exception:", localException1);
          }
        }
        catch (Exception localException2)
        {
          long l1;
          int i1;
          label328:
          label333:
          do
          {
            for (;;)
            {
              Log.d("VoipActivityV2 vm release exception:", localException2);
              continue;
              i1 = 0;
              continue;
              boolean bool = false;
              continue;
              if (paramBoolean) {
                break;
              }
              pb.a(this.b.getApplicationContext(), 2, l1, 1);
              pv.a(this.b, 2131298135, 0);
            }
          } while (i1 == 0);
          pb.a(this.b, 3, l1, 1);
          this.b.findViewById(2131756218).setVisibility(8);
          Log.i("voip/VoipActivityV2/showVoiceMailTip. start animation. tipId:2131296344");
          this.e.setText(2131296344);
          this.e.setBackgroundDrawable(new az(this.b.getResources().getDrawable(2130840452)));
          this.e.setVisibility(0);
          localObject = new AlphaAnimation(0.0F, 1.0F);
          ((Animation)localObject).setDuration(320L);
          this.e.startAnimation((Animation)localObject);
          VoipActivityV2.this.aq.b(this.t);
          VoipActivityV2.this.aq.a(this.t, 3500L);
          if (this.k != null) {
            this.k.removeMessages(0);
          }
          VoipActivityV2.y(VoipActivityV2.this);
          VoipActivityV2.a(VoipActivityV2.this, this.a, this.q, this.r);
        }
      }
    }
    
    final boolean a()
    {
      if (Voip.e())
      {
        pv.a(this.b, 2131296760, 0);
        return false;
      }
      if (this.l != null)
      {
        Log.e("VoipActivityV2 vm recorder already present");
        return false;
      }
      yx.i();
      b();
      VoipActivityV2.r(VoipActivityV2.this).a(VoipActivityV2.this);
      this.l = a.a(VoipActivityV2.t(VoipActivityV2.this).a(MediaFileUtils.a(VoipActivityV2.s(VoipActivityV2.this)), (byte)2, 1, true).getAbsolutePath(), "audio/ogg; codecs=opus");
      this.n = SystemClock.elapsedRealtime();
      for (;;)
      {
        try
        {
          this.l.a();
          Log.i("VoipActivityV2 vm recorder prepared");
          PowerManager localPowerManager;
          this.s = localException2.newWakeLock(6, "voicemail");
        }
        catch (Exception localException1)
        {
          try
          {
            this.l.b();
            Log.i("VoipActivityV2 vm recorder start");
            if (VoipActivityV2.u(VoipActivityV2.this).d(this.a).d == null) {
              VoipActivityV2.this.ay.a(new String[] { this.a });
            }
            new Handler(Looper.getMainLooper())
            {
              public final void handleMessage(Message paramAnonymousMessage)
              {
                if (VoipActivityV2.j.this.l != null)
                {
                  long l = SystemClock.elapsedRealtime() - VoipActivityV2.j.this.n;
                  Log.i("VoipActivityV2 vm setting up message and uploader: " + l + " " + VoipActivityV2.j.this.l.e().length());
                  if ((VoipActivityV2.j.this.m == null) && (l > 1000L))
                  {
                    paramAnonymousMessage = new MediaData();
                    paramAnonymousMessage.autodownloadRetryEnabled = true;
                    paramAnonymousMessage.file = VoipActivityV2.j.this.l.e();
                    j localj = new j(VoipActivityV2.s(VoipActivityV2.this), VoipActivityV2.j.this.a, paramAnonymousMessage);
                    localj.n = VoipActivityV2.v(VoipActivityV2.this).b();
                    localj.m = 1;
                    localj.s = 2;
                    localj.o = 1;
                    localj.y = paramAnonymousMessage.file.getName();
                    localj.t = 0L;
                    VoipActivityV2.w(VoipActivityV2.this).d(localj);
                    VoipActivityV2.j.this.m = VoipActivityV2.x(VoipActivityV2.this).a(VoipActivityV2.w(VoipActivityV2.this), localj);
                    paramAnonymousMessage.uploader = VoipActivityV2.j.this.m;
                    VoipActivityV2.j.this.m.j();
                    Log.d("VoipActivityV2 vm after setup message and uploader");
                  }
                }
              }
            }.sendEmptyMessageDelayed(0, 1100L);
            this.k = new Handler(Looper.getMainLooper())
            {
              public final void handleMessage(Message paramAnonymousMessage)
              {
                VoipActivityV2.j.this.o = (SystemClock.elapsedRealtime() - VoipActivityV2.j.this.n);
                VoipActivityV2.j.this.c.setText(DateUtils.formatElapsedTime(VoipActivityV2.j.this.o / 1000L));
                if (VoipActivityV2.j.this.l != null)
                {
                  if (VoipActivityV2.j.a(VoipActivityV2.j.this.l.e().length())) {
                    VoipActivityV2.j.this.a(false);
                  }
                }
                else {
                  return;
                }
                VoipActivityV2.j.this.k.sendEmptyMessageDelayed(0, 1000L);
              }
            };
            this.k.sendEmptyMessageDelayed(0, 1100L);
            localPowerManager = VoipActivityV2.this.aE.a;
            if (localPowerManager != null) {
              break label272;
            }
            Log.w("voip/VoipActivityV2/start-recording pm=null");
            return true;
          }
          catch (Exception localException2)
          {
            a(false);
            pv.a(this.b, 2131296754, 0);
            return false;
          }
          localException1 = localException1;
          a(false);
          pv.a(this.b, 2131296754, 0);
          return false;
        }
        label272:
        this.s.acquire();
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/VoipActivityV2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */