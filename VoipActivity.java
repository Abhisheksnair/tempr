package com.whatsapp;

import a.a.a.a.a.a.d;
import a.a.a.a.d;
import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
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
import com.whatsapp.util.bu;
import java.io.File;
import java.util.Arrays;
import org.pjsip.PjCamera;

public class VoipActivity
  extends nh
  implements ViewTreeObserver.OnGlobalLayoutListener, VoiceService.f
{
  public static final String n = au.b() + ".intent.action.ACCEPT_CALL";
  public static final String o = au.b() + ".intent.action.SHOW_END_CALL_CONFIRMATION";
  public static final String p = au.b() + ".intent.action.END_CALL_AFTER_CONFIRMATION";
  boolean A = true;
  boolean B;
  boolean C;
  int D;
  i E;
  int F;
  final e G = e.a();
  private View H;
  private View I;
  private View J;
  private TextView K;
  private boolean L;
  private TextEmojiLabel M;
  private boolean N;
  private String O;
  private boolean P;
  private boolean Q;
  private boolean R;
  private m S;
  private m T;
  private Voip.CallState U;
  private Toast V;
  private long W;
  private boolean X;
  private int Y;
  private boolean Z;
  private String aT;
  private long aU = 0L;
  private double aV = NaN.0D;
  private double aW = NaN.0D;
  private boolean aX;
  private String aY;
  private boolean aZ;
  private int aa = 1;
  private int ab = 0;
  private int ac;
  private int ad;
  private int ae;
  private boolean af;
  private boolean ag;
  private ValueAnimator ah;
  private View.OnClickListener ai;
  private ImageView aj;
  private h ba;
  private android.support.v7.app.b bb;
  private final Runnable bc = arx.a(this);
  private ServiceConnection bd = new ServiceConnection()
  {
    public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
    {
      Log.i("voip/VoipActivity/onServiceConnected");
      paramAnonymousComponentName = (VoiceService.g)paramAnonymousIBinder;
      VoipActivity.a(VoipActivity.this, true);
      VoipActivity.a(VoipActivity.this, paramAnonymousComponentName.a);
      VoipActivity.a(VoipActivity.this).j = VoipActivity.this;
      VoipActivity.a(VoipActivity.this).a(Voip.getCurrentCallState());
      VoipActivity.a(VoipActivity.this).v = false;
      paramAnonymousComponentName = Voip.getCallInfo();
      VoipActivity.this.a(Voip.CallState.NONE, paramAnonymousComponentName);
      if ((paramAnonymousComponentName != null) && (paramAnonymousComponentName.isVideoEnabled()))
      {
        if (paramAnonymousComponentName.isVideoPreviewReady()) {
          VoipActivity.this.t_();
        }
        if (paramAnonymousComponentName.isVideoCaptureStarted()) {
          VoipActivity.this.u_();
        }
        if (paramAnonymousComponentName.isVideoRenderStarted())
        {
          VoipActivity.this.s_();
          VoipActivity.b(VoipActivity.this);
          VoipActivity.c(VoipActivity.this);
        }
      }
    }
    
    public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
    {
      if (VoipActivity.a(VoipActivity.this) == null) {
        return;
      }
      Log.i("voip/VoipActivity/onServiceDisconnected");
      VoipActivity.a(VoipActivity.this).j = null;
      if (Voip.getCurrentCallState() == Voip.CallState.RECEIVED_CALL) {
        VoipActivity.a(VoipActivity.this).j();
      }
      VoipActivity.a(VoipActivity.this, null);
      VoipActivity.a(VoipActivity.this, false);
    }
  };
  private final dh be = dh.a();
  private dh.a bf = null;
  private final ant bg = ant.a();
  private final va bh = va.a();
  private final oz bi = oz.a();
  private final aoj bj = aoj.a();
  private final vp bk = vp.a();
  private final k bl = k.a();
  private boolean bm;
  private boolean bn;
  private View bo;
  private View bp;
  VoiceService q;
  boolean r;
  Handler s;
  SurfaceView t;
  SurfaceView u;
  Surface v;
  Surface w;
  SurfaceHolder.Callback x;
  SurfaceHolder.Callback y;
  boolean z;
  
  private void A()
  {
    final int i = getWindowManager().getDefaultDisplay().getWidth();
    Log.i("VoipActivity requesting profile image of size: " + i);
    bu.a(new AsyncTask()
    {
      private Bitmap a()
      {
        int i = Thread.currentThread().getPriority();
        Thread.currentThread().setPriority(5);
        Log.d("VoipActivity updateProfilePhoto doInBackground begin old priority :" + i);
        try
        {
          Object localObject1 = Voip.getPeerJid();
          if (localObject1 == null) {
            return null;
          }
          Log.d("VoipActivity updateProfilePhoto doInBackground getPeerJid done");
          localObject1 = VoipActivity.x(VoipActivity.this).c((String)localObject1);
          if (localObject1 == null) {
            return null;
          }
          Log.d("VoipActivity updateProfilePhoto doInBackground getcontact done");
          localObject1 = ((cs)localObject1).a(i, 0.0F, false);
          Log.d("VoipActivity updateProfilePhoto doInBackground getphoto done");
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
    if (this.bb != null)
    {
      if (this.bb.isShowing()) {
        this.bb.dismiss();
      }
      this.bb = null;
    }
  }
  
  private void D()
  {
    Voip.CallInfo localCallInfo = Voip.getCallInfo();
    boolean bool = i(localCallInfo);
    if ((localCallInfo == null) || (this.ac == 0) || (this.ad == 0) || (this.B) || (!bool)) {
      Log.i("voip/VoipActivity/updatePiPLayoutParams skipped. window width " + this.ac + ", pipMoving " + this.B + ", show peer video " + bool);
    }
    RelativeLayout.LayoutParams localLayoutParams1;
    RelativeLayout.LayoutParams localLayoutParams2;
    do
    {
      return;
      localLayoutParams1 = (RelativeLayout.LayoutParams)this.u.getLayoutParams();
      localLayoutParams2 = a(localLayoutParams1, localCallInfo, true);
    } while (localLayoutParams2 == null);
    localLayoutParams1.height = localLayoutParams2.height;
    localLayoutParams1.width = localLayoutParams2.width;
    localLayoutParams1.topMargin = localLayoutParams2.topMargin;
    localLayoutParams1.rightMargin = localLayoutParams2.rightMargin;
    localLayoutParams1.leftMargin = localLayoutParams2.leftMargin;
    Log.i("voip/VoipActivity/updatePiPLayoutParams rightMargin: " + localLayoutParams1.rightMargin + ", topMargin: " + localLayoutParams1.topMargin + ", PiP size: " + localLayoutParams1.width + "x" + localLayoutParams1.height + ", previewOnFullSurfaceView: " + this.z + ", window size: " + this.ac + "x" + this.ad + ", peer video size: " + localCallInfo.getPeerVideoWidth() + "x" + localCallInfo.getPeerVideoHeight() + ", peer video orientation: " + localCallInfo.getPeerVideoOrientation());
    this.u.setLayoutParams(localLayoutParams1);
    c(localCallInfo);
    b(localCallInfo);
  }
  
  private void E()
  {
    if ((this.ac == 0) || (this.ad == 0)) {}
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
        if (!i(Voip.getCallInfo()))
        {
          i = 1;
          if (i == 0) {
            break label397;
          }
          localSurfaceView = this.u;
          localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localSurfaceView.getLayoutParams();
          if ((!this.z) && (i == 0)) {
            break;
          }
          localLayoutParams = PjCamera.getAdjustedPreviewSize();
          if (localLayoutParams == null) {
            continue;
          }
          f1 = localLayoutParams.width / localLayoutParams.height;
          f2 = this.ac / this.ad;
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
          j = this.ac;
          i = (int)(j / f1);
        }
        for (;;)
        {
          if ((j == localMarginLayoutParams.width) && (i == localMarginLayoutParams.height)) {
            break label437;
          }
          Log.i("voip/VoipActivity/updateFullLayoutParams of " + localSurfaceView + " to " + j + "x" + i + " from " + localMarginLayoutParams.width + "x" + localMarginLayoutParams.height + ", , screen size: " + this.ac + "x" + this.ad + "(" + f2 + "), matchWidth: " + bool + ", adjusted preview size: " + localLayoutParams.width + "x" + localLayoutParams.height + "(" + f1 + ")");
          localMarginLayoutParams.height = i;
          localMarginLayoutParams.width = j;
          j = (this.ac - j) / 2;
          i = (this.ad - i) / 2;
          localMarginLayoutParams.setMargins(j, i, j, i);
          localSurfaceView.setLayoutParams(localMarginLayoutParams);
          return;
          i = 0;
          break;
          localSurfaceView = this.t;
          break label37;
          if (f1 < f2)
          {
            bool = false;
            break label142;
          }
          bool = true;
          break label142;
          i = this.ad;
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
    if ((this.ac == 0) || (this.ad == 0))
    {
      Log.i("voip/VoipActivity/calculatePiPLayoutParams cancel because windowWidth/windowHeight is not initialized");
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
      if (this.z)
      {
        if ((paramCallInfo.getPeerVideoHeight() == 0) || (paramCallInfo.getPeerVideoWidth() == 0))
        {
          Log.e("voip/VoipActivity/calculatePiPLayoutParams invalid peer video size: " + paramCallInfo.getPeerVideoWidth() + "x" + paramCallInfo.getPeerVideoHeight());
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
          k = Math.min(this.ac, this.ad);
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
          if (!this.af) {
            break label368;
          }
          i = paramLayoutParams.d;
          label225:
          localLayoutParams.topMargin = i;
          if (!this.ag) {
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
      localLayoutParams.leftMargin = (this.ac - localLayoutParams.rightMargin - localLayoutParams.width);
      return localLayoutParams;
      i = paramCallInfo.getPeerVideoHeight();
      break;
      j = paramCallInfo.getPeerVideoWidth();
      break label143;
      paramLayoutParams = PjCamera.getAdjustedPreviewSize();
      if (paramLayoutParams == null)
      {
        Log.e("voip/VoipActivity/calculatePiPLayoutParams PjCamera.inst.getAdjustedPreviewSize() returns null");
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
  
  private e a(RelativeLayout.LayoutParams paramLayoutParams)
  {
    int k = this.ae;
    int m = this.ae;
    int i1 = this.ac;
    int i2 = paramLayoutParams.width;
    int i3 = this.ae;
    int j = this.ad - paramLayoutParams.height - this.ae;
    int i = j;
    if (this.A) {
      i = j - this.J.getHeight();
    }
    return new e(k, i1 - i2 - i3, m, i);
  }
  
  private void a(final long paramLong, final int paramInt1, int paramInt2)
  {
    Log.i("voip/VoipActivity/animatePiPView with duration: " + paramLong + ", xOffset: " + paramInt1 + ", yOffset: " + paramInt2 + ", final size: 0x0");
    if ((Build.VERSION.SDK_INT >= 12) && (paramLong > 0L) && (this.aX))
    {
      final View localView1 = findViewById(2131756192);
      final View localView2 = findViewById(2131756193);
      final View localView3 = findViewById(2131756194);
      this.ah = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.ah.setDuration(paramLong);
      this.ah.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
          paramAnonymousValueAnimator = (RelativeLayout.LayoutParams)VoipActivity.k(VoipActivity.this).getLayoutParams();
          if (f1 == 0.0F)
          {
            this.b = paramAnonymousValueAnimator.topMargin;
            this.c = paramAnonymousValueAnimator.rightMargin;
            this.d = VoipActivity.k(VoipActivity.this).getWidth();
            this.e = VoipActivity.k(VoipActivity.this).getHeight();
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
          paramAnonymousValueAnimator.leftMargin = (VoipActivity.t(VoipActivity.this) - paramAnonymousValueAnimator.rightMargin - paramAnonymousValueAnimator.width);
          VoipActivity.k(VoipActivity.this).setLayoutParams(paramAnonymousValueAnimator);
          this.a = (f2 * f1);
        }
      });
      this.ah.addListener(new Animator.AnimatorListener()
      {
        @TargetApi(11)
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          Log.i("voip/VoipActivity/animatePiPView onAnimationCancel");
          VoipActivity.b(VoipActivity.this, false);
          if (this.b != null) {
            this.b.onAnimationCancel(paramAnonymousAnimator);
          }
        }
        
        @TargetApi(11)
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          Log.i("voip/VoipActivity/animatePiPView onAnimationEnd");
          VoipActivity.b(VoipActivity.this, false);
          VoipActivity.b(VoipActivity.this);
          View localView2;
          VoipActivity localVoipActivity;
          if (VoipActivity.u(VoipActivity.this))
          {
            localView2 = VoipActivity.this.findViewById(2131756192);
            localVoipActivity = VoipActivity.this;
            if (localView3.getVisibility() != 0) {
              break label101;
            }
          }
          label101:
          for (View localView1 = localView3;; localView1 = localView2)
          {
            VoipActivity.a(localVoipActivity, localView2, localView1);
            localView2.setVisibility(0);
            VoipActivity.c(VoipActivity.this, false);
            if (this.b != null) {
              this.b.onAnimationEnd(paramAnonymousAnimator);
            }
            return;
          }
        }
        
        @TargetApi(11)
        public final void onAnimationRepeat(Animator paramAnonymousAnimator)
        {
          Log.i("voip/VoipActivity/animatePiPView onAnimationRepeat");
          if (this.b != null) {
            this.b.onAnimationRepeat(paramAnonymousAnimator);
          }
        }
        
        @TargetApi(11)
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          Log.i("voip/VoipActivity/animatePiPView onAnimationStart");
          VoipActivity.b(VoipActivity.this, true);
          if (localView1.getVisibility() == 0)
          {
            VoipActivity.c(VoipActivity.this, true);
            localView1.setVisibility(8);
          }
          if (this.b != null) {
            this.b.onAnimationStart(paramAnonymousAnimator);
          }
        }
      });
      this.ah.start();
      return;
    }
    D();
    paramInt1 = Build.VERSION.SDK_INT;
  }
  
  private static void a(View paramView, int paramInt)
  {
    Log.i("voip/VoipActivity/animateButtonIn delay:" + paramInt);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setInterpolator(new OvershootInterpolator(1.0F));
    localScaleAnimation.setDuration(300L);
    localScaleAnimation.setStartOffset(paramInt);
    paramView.startAnimation(localScaleAnimation);
  }
  
  private void a(View paramView1, View paramView2)
  {
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.u.getLayoutParams();
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
    if (this.V != null) {
      this.V.cancel();
    }
    int[] arrayOfInt = new int[2];
    findViewById(2131756208).getLocationOnScreen(arrayOfInt);
    int i = getWindow().getDecorView().getHeight();
    int j = arrayOfInt[1];
    this.V = Toast.makeText(getApplicationContext(), paramString, paramInt);
    this.V.setGravity(80, 0, i - j);
    this.V.show();
  }
  
  private void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (paramString == null)
    {
      Log.i("VoipActivity vm updateVoiceMailButtons: cannot show buttons. got null jid");
      finish();
      return;
    }
    if (this.N) {
      Log.i("VoipActivity vm unbindService");
    }
    try
    {
      unbindService(this.bd);
      this.N = false;
      switch (paramInt)
      {
      case 3: 
      case 6: 
      case 7: 
      case 8: 
      default: 
        this.K.setText(null);
        findViewById(2131756201).setVisibility(8);
        findViewById(2131756209).setVisibility(8);
        ViewGroup localViewGroup = (ViewGroup)findViewById(2131756210);
        ImageButton localImageButton1 = (ImageButton)findViewById(2131756214);
        ImageButton localImageButton2 = (ImageButton)findViewById(2131756216);
        ImageButton localImageButton3 = (ImageButton)findViewById(2131756212);
        if (paramBoolean2)
        {
          localViewGroup.setBackgroundColor(getResources().getColor(2131624129));
          Log.i("VoipActivity vm setting up buttons");
          localImageButton1.setOnClickListener(asa.a(this, paramString, paramBoolean2));
          localImageButton2.setOnTouchListener(asb.a(this, paramString, paramBoolean2, paramInt));
          localImageButton3.setOnClickListener(asc.a(this));
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
        this.K.setText(2131298162);
        continue;
        this.K.setText(2131298155);
        continue;
        this.K.setText(getString(2131297347, new Object[] { this.G.d(paramString).a(this) }));
        continue;
        if ((this.q != null) && (this.q.K == VoiceService.e.g))
        {
          this.K.setText(2131298173);
        }
        else
        {
          this.K.setText(null);
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
    this.s.removeMessages(7);
    this.s.removeMessages(8);
    C();
    b.a locala = new b.a(this);
    locala.b(paramString).a(true);
    this.bb = locala.a();
    this.s.sendEmptyMessage(8);
    this.s.sendEmptyMessageDelayed(7, 6000L);
  }
  
  @TargetApi(21)
  private void c(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      setTaskDescription(new ActivityManager.TaskDescription(paramString));
    }
  }
  
  private boolean c(String paramString1, String paramString2)
  {
    Voip.CallInfo localCallInfo = Voip.getCallInfo();
    StringBuilder localStringBuilder = new StringBuilder("voip/voipactivity/shouldShowBatteryLowNotif: batteryState: voiceService: ").append(this.q).append(" info: ").append(localCallInfo).append(" callState = ");
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
    if ((this.K == null) || (this.ac == 0) || (this.ad == 0))
    {
      break label21;
      break label21;
    }
    label21:
    while (paramCallInfo == null) {
      return;
    }
    int i;
    switch (4.a[paramCallInfo.getCallState().ordinal()])
    {
    case 7: 
    default: 
      a.d.a(false, "voip/VoipActivity/updateCallStatusBar/unknownCallState");
      i = 1;
    }
    for (;;)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.K.getLayoutParams();
      if (this.u.getVisibility() == 0)
      {
        if (!e(paramCallInfo))
        {
          this.K.setBackgroundColor(getResources().getColor(2131624129));
          this.K.setVisibility(0);
          return;
          if ((paramCallInfo.isSelfInterrupted()) || (paramCallInfo.isPeerInterrupted()))
          {
            this.K.setText(2131298167);
            i = 1;
            continue;
          }
          if ((paramCallInfo.getBytesReceived() == 0L) || ((paramCallInfo.isVideoEnabled()) && (!paramCallInfo.isVideoRenderStarted())))
          {
            this.K.setText(2131298154);
            i = 1;
            continue;
          }
          if ((paramCallInfo.isVideoEnabled()) && (h(paramCallInfo)) && (!e(paramCallInfo)))
          {
            this.K.setText(getString(2131298177, new Object[] { this.G.d(paramCallInfo.getPeerId()).k() }));
            i = 1;
            continue;
          }
          if ((this.q != null) && (this.q.b(paramCallInfo)))
          {
            this.K.setText(2131298171);
            i = 1;
            continue;
          }
          if (paramCallInfo.isPeerVideoPaused())
          {
            this.K.setText(getString(2131298169, new Object[] { this.G.d(paramCallInfo.getPeerId()).k() }));
            i = 1;
            continue;
          }
          if (paramCallInfo.isVideoDecodePaused())
          {
            this.K.setText(2131298111);
            i = 1;
            continue;
          }
          if ((this.q != null) && ((this.q.g) || (this.bm)))
          {
            this.K.setVisibility(8);
            b(paramCallInfo);
            return;
          }
          if (av.d())
          {
            this.K.setText(DateUtils.formatElapsedTime(paramCallInfo.getCallDuration() / 1000L) + "  AEC:" + paramCallInfo.getECMode() + " RAW:" + paramCallInfo.getEchoLevelBeforeEC() + " OUT:" + paramCallInfo.getEchoLevel());
            i = 0;
            continue;
          }
          this.K.setText(DateUtils.formatElapsedTime(paramCallInfo.getCallDuration() / 1000L));
          i = 0;
          continue;
          this.K.setText(2131298154);
          i = 1;
          continue;
          if ((this.q != null) && (this.q.i))
          {
            this.K.setText(getString(2131297347, new Object[] { this.G.d(paramCallInfo.getPeerId()).a(this) }));
            i = 1;
            continue;
          }
          this.K.setText(2131298151);
          i = 1;
          continue;
          if ((this.q != null) && (this.q.i)) {
            break label895;
          }
          this.K.setText(2131298152);
          i = 1;
          continue;
          this.K.setText(2131298148);
          i = 1;
          continue;
        }
        if (i != 0)
        {
          this.K.setVisibility(0);
          paramCallInfo = findViewById(2131756231);
          if ((paramCallInfo != null) && (paramCallInfo.getVisibility() == 0)) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label740;
            }
            if (!this.L) {
              break;
            }
            localLayoutParams.addRule(13, 0);
            localLayoutParams.addRule(3, 2131755507);
            this.K.setLayoutParams(localLayoutParams);
            this.K.setGravity(3);
            this.L = false;
            return;
          }
          label740:
          if (this.L) {
            break;
          }
          this.K.setBackgroundColor(getResources().getColor(2131624129));
          this.K.setTextColor(getResources().getColor(2131624135));
          localLayoutParams.addRule(13, 1);
          localLayoutParams.addRule(3, 0);
          this.K.setLayoutParams(localLayoutParams);
          this.K.setGravity(1);
          this.L = true;
          return;
        }
        this.K.setVisibility(8);
        return;
      }
      this.K.setBackgroundColor(getResources().getColor(2131624091));
      this.K.setVisibility(0);
      if (!this.L) {
        break;
      }
      localLayoutParams.addRule(13, 0);
      localLayoutParams.addRule(3, 2131755507);
      this.K.setLayoutParams(localLayoutParams);
      this.K.setGravity(3);
      this.L = false;
      return;
      label895:
      i = 1;
    }
  }
  
  private void g(Voip.CallInfo paramCallInfo)
  {
    boolean bool2 = true;
    if (paramCallInfo == null) {}
    Object localObject;
    View localView1;
    label155:
    label180:
    int i;
    label186:
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
      ImageButton localImageButton2 = (ImageButton)findViewById(2131756206);
      View localView2 = findViewById(2131756203);
      if (!paramCallInfo.isVideoEnabled()) {
        break label248;
      }
      ((ImageButton)localObject).setImageResource(2130840532);
      if (Voip.getCameraCount() <= 1) {
        break;
      }
      bool1 = true;
      ((ImageButton)localObject).setEnabled(bool1);
      ((ImageButton)localObject).setSelected(false);
      localImageButton1.setImageResource(2130840534);
      localImageButton2.setImageResource(2130840536);
      if ((this.q == null) || (!this.q.f)) {
        break label295;
      }
      bool1 = true;
      localImageButton2.setSelected(bool1);
      if ((this.q == null) || (!this.q.o())) {
        break label300;
      }
      bool1 = true;
      if (!bool1) {
        break label305;
      }
      i = 0;
      localView2.setVisibility(i);
      Log.d("voip/VoipActivity/audio_route/updateAudioButtonStates show_blue_tooth_buttons " + bool1);
    } while (!bool1);
    if ((this.q != null) && (this.q.n())) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localView1.setSelected(bool1);
      return;
      bool1 = false;
      break;
      label248:
      ((ImageButton)localObject).setEnabled(true);
      ((ImageButton)localObject).setImageResource(2130840256);
      if ((this.q != null) && (this.q.m())) {}
      for (bool1 = true;; bool1 = false)
      {
        ((ImageButton)localObject).setSelected(bool1);
        break;
      }
      label295:
      bool1 = false;
      break label155;
      label300:
      bool1 = false;
      break label180;
      label305:
      i = 8;
      break label186;
    }
  }
  
  private boolean h(Voip.CallInfo paramCallInfo)
  {
    return (this.Q) && (paramCallInfo != null) && (paramCallInfo.isVideoEnabled());
  }
  
  private boolean i(Voip.CallInfo paramCallInfo)
  {
    return (this.Q) && (paramCallInfo != null) && (paramCallInfo.isVideoEnabled()) && (paramCallInfo.getCallState() == Voip.CallState.ACTIVE);
  }
  
  static boolean m()
  {
    return av.d();
  }
  
  private void t()
  {
    Log.i("voip/VoipActivity/showCallFailedMessage" + this.O);
    if (this.O != null)
    {
      u();
      this.S = c.a(this.O);
      this.S.a(j_(), null);
      return;
    }
    a.d.a(false, "call failed message not defined");
  }
  
  private void u()
  {
    if (this.S != null)
    {
      this.S.b();
      this.S = null;
      this.O = null;
    }
  }
  
  private void v()
  {
    if (this.T != null)
    {
      this.T.b();
      this.T = null;
    }
  }
  
  private void w()
  {
    int i = 1;
    Log.i("voip/VoipActivity/call/accept");
    Object localObject = Voip.getCallInfo();
    if ((localObject == null) || (((Voip.CallInfo)localObject).getCallState() == Voip.CallState.NONE)) {}
    label88:
    label161:
    label166:
    label194:
    label273:
    label298:
    label303:
    label323:
    for (;;)
    {
      return;
      this.R = true;
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
              break label161;
            }
            bool2 = true;
            if ((!bool1) && (!bool2)) {
              break label194;
            }
            Log.w("voip/service/accept noRecordPermission = " + bool1 + ", noCameraPermission = " + bool2);
            if ((!bool2) || (!bool1)) {
              break label166;
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
            break label88;
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
            break label298;
          }
          bool2 = true;
          if ((bool2) || (bool1)) {
            break label303;
          }
        }
        for (;;)
        {
          if (i == 0) {
            break label323;
          }
          this.q.c();
          return;
          bool1 = false;
          break;
          bool2 = false;
          break label273;
          d.a(str, bool1, bool2).a(j_(), "permission_request");
          i = 0;
        }
      }
    }
  }
  
  private void x()
  {
    int j = 8;
    if (isFinishing()) {
      Log.i("voip/VoipActivity/updateUiState finishing do not update");
    }
    Voip.CallInfo localCallInfo;
    do
    {
      return;
      localCallInfo = Voip.getCallInfo();
    } while ((localCallInfo == null) || (localCallInfo.getCallState() == Voip.CallState.NONE));
    Log.i("voip/VoipActivity/updateUiState");
    c();
    boolean bool = h(localCallInfo);
    View localView = findViewById(2131756187);
    int i;
    label114:
    label116:
    int k;
    if ((!bool) || ((i(localCallInfo)) && (!e(localCallInfo))))
    {
      i = 0;
      localView.setVisibility(i);
      if (!bool) {
        break label188;
      }
      i = j;
      if (!e(localCallInfo)) {
        i = -1;
      }
      j = 0;
      if (j >= 3) {
        break label244;
      }
      k = new int[] { 2131756196, 2131756198, 2131756199 }[j];
      if (i != -1) {
        break label214;
      }
      if (k != 2131756199) {
        break label193;
      }
      findViewById(k).setBackgroundResource(0);
      label166:
      findViewById(k).setVisibility(0);
    }
    for (;;)
    {
      j += 1;
      break label116;
      i = 8;
      break;
      label188:
      i = 0;
      break label114;
      label193:
      findViewById(k).setBackgroundColor(getResources().getColor(2131624129));
      break label166;
      label214:
      findViewById(k).setBackgroundColor(getResources().getColor(2131624091));
      findViewById(k).setVisibility(i);
    }
    label244:
    this.M.setContact(this.G.d(localCallInfo.getPeerId()));
    d(localCallInfo);
    f(localCallInfo);
    g(localCallInfo);
  }
  
  private void y()
  {
    Voip.CallInfo localCallInfo = Voip.getCallInfo();
    if ((localCallInfo == null) || (localCallInfo.getCallState() == Voip.CallState.NONE)) {}
    while ((!localCallInfo.isVideoEnabled()) || (!this.P)) {
      return;
    }
    this.s.removeMessages(6);
    this.s.sendEmptyMessageDelayed(6, 500L);
  }
  
  private void z()
  {
    if ((this.M != null) && (this.r)) {
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.M.getWindowToken(), 0);
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
    g(Voip.getCallInfo());
  }
  
  final void a(long paramLong, Voip.CallInfo paramCallInfo)
  {
    if ((this.C) || (!e(paramCallInfo))) {
      return;
    }
    Log.i("voip/VoipActivity/animateFooterInVideoCall Enter showButtons: " + this.A + " footer top: " + this.J.getTop() + " duration: " + paramLong);
    this.C = true;
    int i = this.J.getHeight();
    final int j = this.I.getHeight() + i;
    label101:
    Animation.AnimationListener local10;
    if (this.A)
    {
      i = -1;
      paramCallInfo = new TranslateAnimation(0.0F, 0.0F, 0.0F, i * j);
      local10 = new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          VoipActivity.r(VoipActivity.this);
          VoipActivity.p(VoipActivity.this).clearAnimation();
          VoipActivity.s(VoipActivity.this).clearAnimation();
          paramAnonymousAnimation = (RelativeLayout.LayoutParams)VoipActivity.p(VoipActivity.this).getLayoutParams();
          if (VoipActivity.o(VoipActivity.this)) {}
          for (int i = 0;; i = -j)
          {
            paramAnonymousAnimation.bottomMargin = i;
            VoipActivity.p(VoipActivity.this).setLayoutParams(paramAnonymousAnimation);
            Log.i("voip/VoipActivity/animateFooterInVideoCall onAnimationEnd showButtons: " + VoipActivity.o(VoipActivity.this) + " footer top: " + VoipActivity.p(VoipActivity.this).getTop());
            return;
          }
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation)
        {
          Log.i("voip/VoipActivity/animateFooterInVideoCall onAnimationRepeat showButtons: " + VoipActivity.o(VoipActivity.this));
        }
        
        public final void onAnimationStart(Animation paramAnonymousAnimation)
        {
          Log.i("voip/VoipActivity/animateFooterInVideoCall onAnimationStart showButtons: " + VoipActivity.o(VoipActivity.this) + " footer top: " + VoipActivity.p(VoipActivity.this).getTop());
          if ((VoipActivity.q(VoipActivity.this)) && (!VoipActivity.h(VoipActivity.this))) {
            VoipActivity.this.findViewById(2131756192).setVisibility(8);
          }
        }
      };
      if ((paramLong <= 0L) || (!this.aX)) {
        break label228;
      }
      this.J.clearAnimation();
      this.I.clearAnimation();
      paramCallInfo.setAnimationListener(local10);
      paramCallInfo.setFillAfter(true);
      paramCallInfo.setDuration(paramLong);
      this.J.startAnimation(paramCallInfo);
      this.I.startAnimation(paramCallInfo);
      label189:
      if (!this.af) {
        break label245;
      }
      if (!this.A) {
        break label247;
      }
    }
    label228:
    label245:
    label247:
    for (i = -this.J.getHeight();; i = this.J.getHeight())
    {
      a(paramLong, 0, i);
      return;
      i = 1;
      break label101;
      local10.onAnimationStart(paramCallInfo);
      local10.onAnimationEnd(paramCallInfo);
      break label189;
      break;
    }
  }
  
  public final void a(Voip.CallInfo paramCallInfo)
  {
    a.d.b();
    f(paramCallInfo);
    long l = System.currentTimeMillis();
    int i;
    double d1;
    double d2;
    if (l - this.aU > 60000L)
    {
      i = 1;
      if (i != 0)
      {
        this.aW = VoiceService.a();
        if ((this.aU == 0L) || (Double.isNaN(this.aV))) {
          this.aV = this.aW;
        }
        this.aU = l;
      }
      if ((!Double.isNaN(this.aV)) && (!Double.isNaN(this.aW)))
      {
        l = paramCallInfo.getCallDuration() / 60000L;
        d1 = this.aV;
        d2 = this.aW;
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
        i = Voip.setBatteryState((int)d1, (int)this.aW);
        Log.i("voip/VoipActivity/updateOnTimer setting battery state for vid_rc_battery: " + d1 + " " + this.aW + " got result: " + i);
      }
      o();
      B();
      if ((this.q != null) && (this.q.t) && (paramCallInfo.getCallState() == Voip.CallState.ACTIVE) && (this.W == 0L) && (paramCallInfo.getBytesReceived() > 0L) && (paramCallInfo.isCaller()) && (!paramCallInfo.isVideoEnabled()) && (paramCallInfo.getCallDuration() < 3000L)) {
        a(getString(2131298141), 0);
      }
      this.W = paramCallInfo.getBytesReceived();
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
      Log.w("voip/VoipActivity/callStateChanged info == NULL finishing current activity");
      finish();
      return;
    }
    runOnUiThread(asd.a(this, paramCallInfo, paramCallState));
  }
  
  public final void a(String paramString)
  {
    this.O = paramString;
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
      b(getString(2131296376, new Object[] { paramString1 }));
      return;
    }
  }
  
  final void b(Voip.CallInfo paramCallInfo)
  {
    TextView localTextView1;
    View localView1;
    if (((paramCallInfo == null) || (paramCallInfo.isVideoEnabled())) && (this.u != null))
    {
      localTextView1 = (TextView)findViewById(2131756194);
      TextView localTextView2 = (TextView)findViewById(2131756186);
      localView1 = findViewById(2131756193);
      View localView2 = findViewById(2131756185);
      if ((this.q == null) || (!this.q.g)) {
        break label170;
      }
      this.bm = true;
      if (!this.z)
      {
        this.bp.setVisibility(0);
        localTextView2.setText(getString(2131298168, new Object[] { this.G.d(paramCallInfo.getPeerId()).k() }));
        localView2.setVisibility(8);
        localTextView2.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    a(this.bo, localTextView1);
    this.bo.setVisibility(0);
    localView1.setVisibility(8);
    localTextView1.setVisibility(0);
    return;
    label170:
    this.bm = false;
    if (!this.z)
    {
      this.bp.setVisibility(8);
      return;
    }
    this.bo.setVisibility(8);
  }
  
  public final void c()
  {
    a.d.b();
    Voip.CallInfo localCallInfo = Voip.getCallInfo();
    if ((localCallInfo == null) || (localCallInfo.getCallState() == Voip.CallState.NONE)) {
      return;
    }
    Log.i("voip/VoipActivity/updateLayoutForAudioAndVideoCall video: " + localCallInfo.isVideoEnabled());
    TextView localTextView = (TextView)findViewById(2131756197);
    boolean bool;
    View localView;
    if (localCallInfo.isVideoEnabled()) {
      if (!Voip.b())
      {
        bool = true;
        this.aX = bool;
        if (Build.VERSION.SDK_INT >= 21) {
          getWindow().setStatusBarColor(android.support.v4.content.b.c(this, 2131624129));
        }
        if (!this.Z)
        {
          this.Z = true;
          localView = getWindow().getDecorView();
          localView.setSystemUiVisibility(localView.getSystemUiVisibility() | 0x400);
          int i = 25;
          int j = getResources().getIdentifier("status_bar_height", "dimen", "android");
          if (j > 0) {
            i = getResources().getDimensionPixelSize(j);
          }
          this.Y = i;
        }
        localTextView.setText(getString(2131298110));
        setTitle(2131298174);
        c(getString(2131298174));
        this.u.setVisibility(0);
        this.u.setClickable(false);
        setRequestedOrientation(1);
        label228:
        if (((localCallInfo.isCaller()) || (localCallInfo.getCallState() != Voip.CallState.RECEIVED_CALL)) && (!VoiceService.a(localCallInfo))) {
          break label422;
        }
        getWindow().addFlags(128);
      }
    }
    for (;;)
    {
      f(localCallInfo);
      return;
      bool = false;
      break;
      Log.i("voip/VoipActivity/updateLayoutForAudioAndVideoCall hide video");
      if (Build.VERSION.SDK_INT >= 21) {
        getWindow().setStatusBarColor(android.support.v4.content.b.c(this, 2131624092));
      }
      if (this.Z)
      {
        this.Z = false;
        localView = getWindow().getDecorView();
        localView.setSystemUiVisibility(localView.getSystemUiVisibility() & 0xFBFF);
      }
      localTextView.setText(getString(2131298149));
      setTitle(2131298138);
      c(getString(2131298138));
      this.u.setVisibility(8);
      this.t.setVisibility(8);
      this.aj.setVisibility(8);
      findViewById(2131756182).setVisibility(8);
      this.A = true;
      setRequestedOrientation(1);
      break label228;
      label422:
      getWindow().clearFlags(128);
    }
  }
  
  final void c(Voip.CallInfo paramCallInfo)
  {
    View localView2;
    if (((paramCallInfo == null) || (paramCallInfo.isVideoEnabled())) && (this.u != null))
    {
      paramCallInfo = findViewById(2131756193);
      View localView1 = findViewById(2131756185);
      localView2 = findViewById(2131756194);
      View localView3 = findViewById(2131756186);
      if ((this.q == null) || (!this.q.f)) {
        break label125;
      }
      if (this.z)
      {
        this.bp.setVisibility(0);
        localView3.setVisibility(8);
        localView1.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    a(this.bo, paramCallInfo);
    this.bo.setVisibility(0);
    localView2.setVisibility(8);
    paramCallInfo.setVisibility(0);
    return;
    label125:
    if (this.z)
    {
      this.bp.setVisibility(8);
      return;
    }
    this.bo.setVisibility(8);
  }
  
  final void d(Voip.CallInfo paramCallInfo)
  {
    int j = 8;
    Voip.CallState localCallState = paramCallInfo.getCallState();
    Object localObject = localCallState;
    if (localCallState == Voip.CallState.RECEIVED_CALL)
    {
      localObject = localCallState;
      if (this.R) {
        localObject = Voip.CallState.ACCEPT_SENT;
      }
    }
    if (localObject != Voip.CallState.NONE) {}
    View localView1;
    View localView2;
    View localView3;
    View localView4;
    for (int i = 1;; i = 0)
    {
      localView1 = findViewById(2131756207);
      localView2 = findViewById(2131756199);
      localView3 = findViewById(2131756201);
      localView4 = findViewById(2131756210);
      if ((localView1 != null) && (localView2 != null) && (this.I != null) && (localView3 != null)) {
        break;
      }
      Log.e("voip/VoipActivity/updateButtonStates/null");
      return;
    }
    localCallState = this.U;
    this.U = ((Voip.CallState)localObject);
    localView4.setVisibility(8);
    s();
    if (!this.A)
    {
      localView1.setVisibility(8);
      localView2.setVisibility(8);
      return;
    }
    if (localObject == Voip.CallState.RECEIVED_CALL)
    {
      Log.i("voip/VoipActivity/updateButtonStates/answerCallView/visible");
      localView1.setVisibility(0);
      localView2.setVisibility(0);
      this.I.setVisibility(8);
      localView3.setVisibility(8);
      return;
    }
    Log.i("voip/VoipActivity/updateButtonStates");
    localView1.setVisibility(8);
    localView2.setVisibility(8);
    this.I.setVisibility(0);
    localView3.setVisibility(0);
    if (paramCallInfo.isVideoEnabled()) {
      localView3.setBackgroundResource(0);
    }
    for (;;)
    {
      paramCallInfo = (ImageButton)findViewById(2131756209);
      localObject = findViewById(2131756202);
      localView1 = findViewById(2131756204);
      localView2 = findViewById(2131756205);
      localView3 = findViewById(2131756206);
      localView4 = findViewById(2131756203);
      if (i != 0) {
        j = 0;
      }
      paramCallInfo.setVisibility(j);
      if (("disable_animation".equals(this.aT)) || (i == 0) || (localCallState != Voip.CallState.RECEIVED_CALL)) {
        break;
      }
      Log.i("voip/VoipActivity/updateButtonStates/animateButtonIn");
      a(paramCallInfo, 0);
      a((View)localObject, 100);
      if (localView4.isShown()) {
        a(localView1, 100);
      }
      a(localView2, 150);
      a(localView3, 200);
      return;
      localView3.setBackgroundColor(getResources().getColor(2131624091));
      paramCallInfo = (RelativeLayout.LayoutParams)this.J.getLayoutParams();
      paramCallInfo.bottomMargin = 0;
      this.J.setLayoutParams(paramCallInfo);
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
    return (this.Q) && (paramCallInfo != null) && (paramCallInfo.isVideoEnabled()) && (paramCallInfo.isVideoRenderStarted());
  }
  
  public final void j()
  {
    if (c(null, null)) {
      b(getString(2131296382));
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
    if ((av.d()) && (this.F != a.a))
    {
      if (this.F != a.c) {
        break label45;
      }
      localTextView.setText(Voip.getStreamStatistics());
    }
    label45:
    while (this.F != a.b) {
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
        if (paramConfiguration.orientation != this.aa)
        {
          Log.i("voip/VoipActivity/onConfigurationChanged orientation changed from " + this.aa + " to " + paramConfiguration.orientation);
          this.aa = paramConfiguration.orientation;
        }
        i = getWindowManager().getDefaultDisplay().getRotation() * 90;
      } while (i == this.ab);
      Log.i("voip/VoipActivity/onConfigurationChanged rotation changed from " + this.ab + " to " + i);
      this.ab = i;
      Voip.stopVideoRenderStream();
      Voip.videoOrientationChanged(i);
      this.J.clearAnimation();
      this.I.clearAnimation();
    } while ((this.ah == null) || (Build.VERSION.SDK_INT < 11));
    this.ah.cancel();
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
        this.bl.b();
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
    setContentView(al.a(this.aq, getLayoutInflater(), 2130903398));
    c.a().a(this, false);
    this.bo = findViewById(2131756192);
    this.bp = findViewById(2131756184);
    this.K = ((TextView)findViewById(2131756188));
    aoa.b(this.K);
    aoa.b((TextView)findViewById(2131756197));
    this.M = ((TextEmojiLabel)findViewById(2131755507));
    this.M.setOnClickListener(new at()
    {
      public final void a(View paramAnonymousView)
      {
        if (av.d())
        {
          Log.i("voip/marking_bad_audio_quality");
          VoipActivity.this.aq.b(VoipActivity.this, "marking_bad_audio_quality", 0);
        }
      }
    });
    Object localObject = (ImageButton)findViewById(2131756229);
    this.F = a.a;
    ((ImageButton)localObject).setOnClickListener(ase.a(this));
    B();
    n();
    findViewById(2131756209).setOnClickListener(asf.a(this));
    findViewById(2131756206).setOnClickListener(asg.a(this, paramBundle));
    findViewById(2131756205).setOnClickListener(ash.a(this));
    findViewById(2131756202).setOnClickListener(asi.a(this));
    findViewById(2131756204).setOnClickListener(asj.a(this));
    localObject = (AnswerCallView)findViewById(2131756207);
    ((AnswerCallView)localObject).setAnswerCallListener(new AnswerCallView.a()
    {
      public final void a()
      {
        VoipActivity.e(VoipActivity.this);
      }
      
      public final void a(boolean paramAnonymousBoolean)
      {
        Log.i("voip/VoipActivity/onUserNeedsEducation start animation. accept:" + paramAnonymousBoolean);
        TextView localTextView = (TextView)VoipActivity.this.findViewById(2131756189);
        localTextView.clearAnimation();
        if (paramAnonymousBoolean) {}
        for (int i = 2131297857;; i = 2131297858)
        {
          localTextView.setText(i);
          localTextView.setVisibility(0);
          AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
          localAlphaAnimation.setDuration(200L);
          localTextView.setAnimation(localAlphaAnimation);
          localTextView.removeCallbacks(VoipActivity.f(VoipActivity.this));
          localTextView.postDelayed(VoipActivity.f(VoipActivity.this), 3000L);
          return;
        }
      }
      
      public final void b()
      {
        VoipActivity.d(VoipActivity.this);
      }
    });
    if (paramBundle.isCaller()) {
      ((AnswerCallView)localObject).setVisibility(8);
    }
    findViewById(2131756200).setOnClickListener(ask.a(this));
    this.x = new SurfaceHolder.Callback()
    {
      public final void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        Log.i("voip/VoipActivity/video/display/surfaceChanged " + paramAnonymousSurfaceHolder + ", format: 0x" + Integer.toHexString(paramAnonymousInt1) + ", size: " + paramAnonymousInt2 + "x" + paramAnonymousInt3);
        VoipActivity.a(VoipActivity.this, paramAnonymousSurfaceHolder.getSurface());
        paramAnonymousSurfaceHolder = Voip.getCallInfo();
        if ((paramAnonymousSurfaceHolder == null) || (paramAnonymousSurfaceHolder.getCallState() == Voip.CallState.NONE)) {}
        do
        {
          do
          {
            return;
          } while (!VoipActivity.a(VoipActivity.this, paramAnonymousSurfaceHolder));
          if (Voip.setVideoDisplaySurface(VoipActivity.i(VoipActivity.this)) == 0) {
            break;
          }
        } while (VoipActivity.a(VoipActivity.this) == null);
        VoipActivity.a(VoipActivity.this).a(VoiceService.e.v, null);
        return;
        Voip.startVideoRenderStream();
      }
      
      public final void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        Log.i("voip/VoipActivity/video/display/surfaceCreated " + paramAnonymousSurfaceHolder);
        VoipActivity.g(VoipActivity.this);
        if (VoipActivity.h(VoipActivity.this))
        {
          VoipActivity.b(VoipActivity.this);
          return;
        }
        VoipActivity.c(VoipActivity.this);
      }
      
      public final void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        Log.i("voip/VoipActivity/video/display/surfaceDestroyed " + paramAnonymousSurfaceHolder);
        VoipActivity.a(VoipActivity.this, null);
        Voip.setVideoDisplaySurface(null);
        Voip.stopVideoRenderStream();
      }
    };
    this.y = new SurfaceHolder.Callback()
    {
      public final void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        Log.i("voip/VoipActivity/video/preview/surfaceChanged " + paramAnonymousSurfaceHolder + ", format: 0x" + Integer.toHexString(paramAnonymousInt1) + ", size: " + paramAnonymousInt2 + "x" + paramAnonymousInt3);
      }
      
      public final void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        Log.i("voip/VoipActivity/video/preview/surfaceCreated " + paramAnonymousSurfaceHolder);
        VoipActivity.b(VoipActivity.this, paramAnonymousSurfaceHolder.getSurface());
        if (VoipActivity.h(VoipActivity.this)) {}
        for (paramAnonymousSurfaceHolder = VoipActivity.j(VoipActivity.this);; paramAnonymousSurfaceHolder = VoipActivity.k(VoipActivity.this))
        {
          if (PjCamera.setSurfaceView(paramAnonymousSurfaceHolder) != 0) {
            VoipActivity.l(VoipActivity.this);
          }
          VoipActivity.g(VoipActivity.this);
          if (!VoipActivity.h(VoipActivity.this)) {
            break;
          }
          VoipActivity.c(VoipActivity.this);
          return;
        }
        VoipActivity.b(VoipActivity.this);
      }
      
      public final void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        Log.i("voip/VoipActivity/video/preview/surfaceDestroyed " + paramAnonymousSurfaceHolder);
        VoipActivity.b(VoipActivity.this, null);
        PjCamera.setSurfaceView(null);
      }
    };
    this.t = ((SurfaceView)findViewById(2131756183));
    this.t.setOnClickListener(asl.a(this));
    this.u = ((SurfaceView)findViewById(2131756191));
    this.ai = ary.a(this);
    this.u.setOnClickListener(this.ai);
    this.af = true;
    this.ag = this.aq.d();
    int i = this.aQ.D();
    if (i >= 0)
    {
      if ((i & 0x1) != 0) {
        break label781;
      }
      bool1 = true;
      label573:
      this.ag = bool1;
      if ((i & 0x2) != 0) {
        break label786;
      }
    }
    label781:
    label786:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.af = bool1;
      this.z = false;
      this.t.getHolder().addCallback(this.x);
      this.u.getHolder().addCallback(this.y);
      this.H = findViewById(16908290);
      this.I = findViewById(2131756208);
      this.J = findViewById(2131755524);
      this.aj = ((ImageView)findViewById(2131756195));
      c();
      localObject = getIntent();
      setIntent((Intent)localObject);
      this.aT = ((Intent)localObject).getStringExtra("fixEndCall");
      this.bf = new dh.a()
      {
        public final void b(String paramAnonymousString)
        {
          String str = Voip.getPeerJid();
          if ((str != null) && (TextUtils.equals(paramAnonymousString, str))) {
            VoipActivity.m(VoipActivity.this);
          }
        }
      };
      this.be.registerObserver(this.bf);
      this.s = new Handler(arz.a(this, paramBundle));
      if (!paramBundle.isVideoEnabled()) {
        break;
      }
      this.ba = new h(this);
      if (!this.ba.canDetectOrientation()) {
        break label791;
      }
      this.ba.enable();
      return;
      bool1 = false;
      break label573;
    }
    label791:
    this.ba = null;
  }
  
  protected void onDestroy()
  {
    Log.i("voip/VoipActivity/onDestroy " + this);
    super.onDestroy();
    c.a().a(this);
    if (this.V != null) {
      this.V.cancel();
    }
    if (this.bf != null)
    {
      this.be.unregisterObserver(this.bf);
      this.bf = null;
    }
    if (this.q != null) {
      this.q.a(this);
    }
    if (this.ba != null) {
      this.ba.disable();
    }
  }
  
  public void onEvent(acz paramacz)
  {
    a.d.b();
    Window localWindow = getWindow();
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
      this.s.removeMessages(2);
      this.s.sendEmptyMessageDelayed(2, 3000L);
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
      this.s.removeMessages(2);
      paramacz = Voip.getCallInfo();
    } while ((this.q == null) || (!this.q.u) || (paramacz == null) || (paramacz.getBytesReceived() != 0L) || ((paramacz.getCallState() != Voip.CallState.ACTIVE) && (paramacz.getCallState() != Voip.CallState.ACCEPT_SENT) && (paramacz.getCallState() != Voip.CallState.ACCEPT_RECEIVED)));
    a(getString(2131298154), 1);
  }
  
  public void onEvent(ag paramag)
  {
    setVolumeControlStream(paramag.a);
  }
  
  public void onGlobalLayout()
  {
    if ((this.H.getWidth() == this.ac) && (this.H.getHeight() == this.ad)) {}
    do
    {
      do
      {
        return;
        Log.i("voip/VoipActivity/onGlobalLayout size: " + this.H.getWidth() + "x" + this.H.getHeight() + ", orientation: " + getResources().getConfiguration().orientation);
        this.ac = this.H.getWidth();
        this.ad = this.H.getHeight();
        x();
        localObject = Voip.getCallInfo();
      } while ((localObject == null) || (!h((Voip.CallInfo)localObject)));
      if (this.ae == 0) {
        this.ae = ((int)TypedValue.applyDimension(1, 7.0F, getResources().getDisplayMetrics()));
      }
      if ((this.aa == 2) && (e((Voip.CallInfo)localObject)) && (this.A) && (!this.B))
      {
        this.A = false;
        l();
        a(0L, (Voip.CallInfo)localObject);
      }
      PjCamera.updatePreviewOrientation();
      if (i((Voip.CallInfo)localObject)) {
        this.u.setOnTouchListener(new f((byte)0));
      }
      D();
      E();
    } while (this.Y <= 0);
    Object localObject = findViewById(2131756196);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
    localLayoutParams.topMargin += this.Y;
    ((View)localObject).setLayoutParams(localLayoutParams);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    int j = 0;
    Log.i("voip/VoipActivity/onKeyDown " + paramKeyEvent);
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
          Log.i("voip/VoipActivity/onKeyDown accept call from remote control");
          w();
          return true;
        }
        if (!d(paramInt)) {
          break label276;
        }
        Log.i("voip/VoipActivity/onKeyDown reject call from remote control");
        q();
        return true;
        if ((d(paramInt)) || ((e(paramInt)) && (paramKeyEvent.getRepeatCount() == 0)))
        {
          Log.i("voip/VoipActivity/onKeyDown end call from remote control");
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
    Object localObject = paramIntent.getAction();
    Log.i("voip/VoipActivity/onNewIntent " + paramIntent + ", action " + (String)localObject + ", is finishing " + isFinishing());
    super.onNewIntent(paramIntent);
    if (n.equals(localObject)) {
      w();
    }
    for (;;)
    {
      aw.a(u.a()).a(10);
      return;
      if (o.equals(localObject))
      {
        paramIntent = paramIntent.getStringExtra("confirmationString");
        if ((this.T == null) && (Voip.e()))
        {
          Log.w("voip/VoipActivity/showEndCallConfirmationDialog.");
          this.T = b.a(paramIntent);
          this.T.a(j_(), null);
        }
      }
      else if (p.equals(localObject))
      {
        if (this.q != null) {
          this.q.a(VoiceService.e.b, null);
        }
      }
      else
      {
        if (isFinishing())
        {
          Log.e("voip/VoipActivity/new-intent activity is finishing, do nothing");
          return;
        }
        setIntent(paramIntent);
        x();
        A();
        if (paramIntent.getBooleanExtra("newCall", false))
        {
          Log.i("voip/VoipActivity/onNewIntent/NewCall clearing states");
          localObject = (AnswerCallView)findViewById(2131756207);
          if (localObject != null)
          {
            ((AnswerCallView)localObject).a = false;
            ((AnswerCallView)localObject).b = false;
          }
          u();
          this.aT = paramIntent.getStringExtra("fixEndCall");
        }
      }
    }
  }
  
  protected void onPause()
  {
    Log.i("voip/VoipActivity/onPause " + this);
    super.onPause();
    if (this.N) {
      Log.i("voip/VoipActivity/unbindService");
    }
    try
    {
      unbindService(this.bd);
      this.N = false;
      s();
      C();
      this.r = false;
      this.aZ = false;
      if (this.ba != null) {
        this.ba.disable();
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
    Log.i("voip/VoipActivity/onRequestPermissionsResult permissions: " + Arrays.toString(paramArrayOfString) + ", grantResults: " + Arrays.toString(paramArrayOfInt));
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
        Log.d("voip/VoipActivity/onRequestPermissionsResult granted, starting call");
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
      Log.w("voip/VoipActivity/onRequestPermissionsResult/failed_no_record_audio_permission");
      if (this.q == null) {
        break;
      }
      this.q.b(VoiceService.e.w, null);
      return;
    }
  }
  
  protected void onResume()
  {
    Log.i("voip/VoipActivity/onResume " + this);
    super.onResume();
    this.r = true;
    this.P = true;
    Voip.CallInfo localCallInfo = Voip.getCallInfo();
    if ((localCallInfo == null) || (localCallInfo.getCallState() == Voip.CallState.NONE)) {}
    do
    {
      do
      {
        return;
        z();
        this.s.sendEmptyMessageDelayed(1, 500L);
        Log.i("voip/VoipActivity/bindService");
        bindService(new Intent(u.a(), VoiceService.class), this.bd, 1);
      } while (!localCallInfo.isVideoEnabled());
      Voip.startVideoCaptureStream();
    } while (this.ba == null);
    this.ba.enable();
  }
  
  protected void onStart()
  {
    Log.i("voip/VoipActivity/onStart " + this);
    super.onStart();
    this.Q = true;
    this.H.getViewTreeObserver().addOnGlobalLayoutListener(this);
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
      Log.e("voip/VoipActivity/onStart call_not_active, finishing");
      return;
      x();
      A();
    } while ((!this.X) || (localCallInfo.getCallState() != Voip.CallState.RECEIVED_CALL));
    startService(new Intent("refresh_notification", null, this, VoiceService.class));
    this.X = false;
  }
  
  protected void onStop()
  {
    Log.i("voip/VoipActivity/onStop " + this);
    super.onStop();
    this.Q = false;
    Voip.CallInfo localCallInfo;
    if (this.H != null)
    {
      if (Build.VERSION.SDK_INT < 16) {
        this.H.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      }
    }
    else
    {
      this.s.removeCallbacksAndMessages(null);
      s();
      C();
      localCallInfo = Voip.getCallInfo();
      if ((localCallInfo != null) && (localCallInfo.getCallState() != Voip.CallState.NONE)) {
        break label104;
      }
    }
    label104:
    do
    {
      return;
      this.H.getViewTreeObserver().removeOnGlobalLayoutListener(this);
      break;
      if ((localCallInfo.getCallState() == Voip.CallState.RECEIVED_CALL) && (Build.VERSION.SDK_INT >= 21))
      {
        Intent localIntent = new Intent("refresh_notification", null, this, VoiceService.class);
        localIntent.putExtra("headsup", true);
        startService(localIntent);
        this.X = true;
      }
      if (localCallInfo.isVideoEnabled())
      {
        Voip.stopVideoCaptureStream();
        if ((localCallInfo.getCallState() != Voip.CallState.NONE) && (Build.VERSION.SDK_INT < 19) && (this.v != null))
        {
          Log.i("voip/VoipActivity/onStop finish current activity, will recreate on foreground");
          if (this.q != null) {
            this.q.a(this);
          }
          finish();
        }
        Log.i("voip/VoipActivity/onStop hide FullSurfaceView, to make sure pipSurfaceView will be created first after onResume()");
        this.t.setVisibility(8);
      }
    } while ((this.q == null) || (this.aR.d()));
    Log.i("voip/VoipActivity/onStop. App is put to background, mark to show VoipActivity again when foregrounded.");
    this.q.v = true;
  }
  
  public void onUserInteraction()
  {
    this.P = true;
  }
  
  protected void onUserLeaveHint()
  {
    Log.i("voip/VoipActivity/onUserLeaveHint");
    this.P = false;
  }
  
  final void p()
  {
    Log.i("voip/VoipActivity/call/end");
    if (this.q != null) {
      this.q.a(VoiceService.e.a, null);
    }
    this.aZ = true;
  }
  
  public final boolean p_()
  {
    return this.P;
  }
  
  final void q()
  {
    Log.i("voip/VoipActivity/call/reject");
    if (this.q != null) {
      this.q.d();
    }
  }
  
  public final void q_()
  {
    this.s.sendEmptyMessage(5);
  }
  
  final void r()
  {
    Voip.CallInfo localCallInfo = Voip.getCallInfo();
    if ((localCallInfo == null) || (localCallInfo.getCallState() == Voip.CallState.NONE)) {}
    while ((!this.A) || (!e(localCallInfo))) {
      return;
    }
    this.s.removeMessages(3);
    this.s.sendEmptyMessageDelayed(3, 8000L);
  }
  
  public final void r_()
  {
    this.s.sendEmptyMessage(5);
  }
  
  final void s()
  {
    if (this.E != null)
    {
      Log.d("VoipActivity vm cancelVoiceMail jid: " + this.aY + " voicemail: " + this.E);
      this.E.a(false);
      this.aY = null;
    }
    this.E = null;
  }
  
  public final void s_()
  {
    a.d.b();
    Log.i("voip/VoipActivity/videoRenderStarted.");
    if ((this.z) || (this.t.getVisibility() == 0)) {
      if (!this.z) {
        break label77;
      }
    }
    label77:
    for (SurfaceHolder localSurfaceHolder = this.u.getHolder();; localSurfaceHolder = this.t.getHolder())
    {
      if (localSurfaceHolder != null)
      {
        this.x.surfaceCreated(localSurfaceHolder);
        this.x.surfaceChanged(localSurfaceHolder, 0, 0, 0);
      }
      x();
      r();
      return;
    }
  }
  
  public final void t_()
  {
    a.d.b();
    Log.i("voip/VoipActivity/videoPreviewReady.");
    if (this.w != null) {
      if (!this.z) {
        break label55;
      }
    }
    label55:
    for (SurfaceHolder localSurfaceHolder = this.t.getHolder();; localSurfaceHolder = this.u.getHolder())
    {
      this.y.surfaceCreated(localSurfaceHolder);
      this.y.surfaceChanged(localSurfaceHolder, 0, 0, 0);
      return;
    }
  }
  
  public final void u_()
  {
    Log.i("voip/VoipActivity/videoCaptureStarted.");
    this.u.setBackgroundResource(0);
  }
  
  public final void v_()
  {
    a.d.b();
    Voip.CallInfo localCallInfo = Voip.getCallInfo();
    if ((localCallInfo == null) || (localCallInfo.getCallState() == Voip.CallState.NONE)) {}
    while (!this.z) {
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
      return new b.a(l()).b(paramBundle).a(true).a(2131296364, asm.a(this)).b(2131297023, asn.a(this)).a();
    }
  }
  
  public static final class c
    extends m
  {
    public final Dialog c(Bundle paramBundle)
    {
      paramBundle = i().getString("message");
      return new b.a(l()).b(paramBundle).a(true).a(2131297331, aso.a(this)).a();
    }
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      if ((l() != null) && (!Voip.e())) {
        l().finish();
      }
    }
  }
  
  public static final class d
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
            VoipActivity.d.a(VoipActivity.d.this);
            VoipActivity.d.this.a();
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
        Log.i("voip/VoipActivity/permissions needMicPermission=" + this.ad + ", needCameraPermission=" + this.ae + ", isScreenLocked=" + bool2 + ", showRational=" + bool3 + ", isFistTimeRequest=" + bool4 + ", permanentDenial=" + bool1);
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
            VoipActivity.d.a(VoipActivity.d.this);
            VoipActivity.d.this.a();
            d.d(VoipActivity.d.this.l());
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
        Log.e("voip/VoipActivity/permissions/jid is null");
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
            VoipActivity.d.this.a();
            RequestPermissionActivity.a(VoipActivity.d.this.l(), VoipActivity.d.b(VoipActivity.d.this), VoipActivity.d.c(VoipActivity.d.this));
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
  
  static final class e
  {
    int a;
    int b;
    int c;
    int d;
    
    public e(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
      this.d = paramInt4;
    }
  }
  
  final class f
    implements View.OnTouchListener
  {
    float a;
    float b;
    int c;
    int d;
    int e;
    int f;
    VoipActivity.e g;
    int h;
    int i;
    double j;
    int k;
    float l;
    float m;
    float n;
    float o;
    long p;
    
    private f() {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      if (paramView != VoipActivity.k(VoipActivity.this))
      {
        Log.i("voip/VoipActivity/PiPOnTouchListner/ ignore, wrong view " + paramView);
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
          Log.i("voip/VoipActivity/pipSurfaceView/onTouch ACTION_MOVE dispatched before ACTION_DOWN, ignore");
          return true;
        }
        localLayoutParams.rightMargin = Math.min(this.g.b, Math.max(this.g.a, this.c + (int)(this.a - paramMotionEvent.getRawX())));
        localLayoutParams.leftMargin = (VoipActivity.t(VoipActivity.this) - localLayoutParams.rightMargin - localLayoutParams.width);
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
        VoipActivity.b(VoipActivity.this, false);
        if (this.g == null)
        {
          Log.i("voip/VoipActivity/pipSurfaceView/onTouch ACTION_UP dispatched before ACTION_DOWN, ignore");
          return true;
        }
        if (this.k < this.j / 60.0D)
        {
          Log.i("voip/VoipActivity/pipSurfaceView/onTouch ACTION_UP treat as click event  maxDistance: " + this.k + ", screenLength: " + this.j);
          VoipActivity.b(VoipActivity.this);
          VoipActivity.D(VoipActivity.this).onClick(VoipActivity.k(VoipActivity.this));
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
        paramView = VoipActivity.this;
        if (f4 >= this.h / 2)
        {
          bool2 = true;
          label630:
          VoipActivity.d(paramView, bool2);
          paramView = VoipActivity.this;
          if (f3 < this.i / 2) {
            break label920;
          }
        }
        label920:
        for (boolean bool2 = true;; bool2 = false)
        {
          VoipActivity.e(paramView, bool2);
          paramView = VoipActivity.a(VoipActivity.this, localLayoutParams);
          if (paramView == null) {
            break;
          }
          int i1 = localLayoutParams.rightMargin - paramView.rightMargin;
          int i2 = paramView.topMargin - localLayoutParams.topMargin;
          d1 = Math.sqrt(i1 * i1 + i2 * i2);
          l1 = Math.max(200, (int)(500.0D * d1 / this.j));
          Log.i("voip/VoipActivity/pipSurfaceView/onTouch ACTION_UP xVelocity: " + this.n + ", yVelocity: " + this.o + ", velocity: " + f5 + ", fling: " + bool1 + ", finalRawX: " + f4 + ", finalRawY: " + f3 + ", window size: " + this.h + "x" + this.i + "(" + this.j + "), pipAtRight: " + VoipActivity.E(VoipActivity.this) + ", pipAtBottom: " + VoipActivity.q(VoipActivity.this) + ", moving distance: " + d1 + ", duration: " + l1);
          VoipActivity.a(VoipActivity.this, l1, i1, i2);
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
        VoipActivity.b(VoipActivity.this, true);
        paramView = VoipActivity.this.getWindowManager().getDefaultDisplay();
        this.h = paramView.getWidth();
        this.i = paramView.getHeight();
        this.j = Math.sqrt(this.h * this.h + this.i * this.i);
        this.k = 0;
        this.g = VoipActivity.b(VoipActivity.this, localLayoutParams);
        this.o = 0.0F;
        this.n = 0.0F;
        this.m = 0.0F;
        this.l = 0.0F;
        this.p = 0L;
        if (!VoipActivity.h(VoipActivity.this)) {
          VoipActivity.this.findViewById(2131756192).setVisibility(8);
        }
        Log.i("voip/VoipActivity/pipSurfaceView/onTouch ACTION_DOWN downX: " + this.a + ", downY: " + this.b + ", rightMargin: " + this.c + ", topMargin: " + this.d);
      }
    }
  }
  
  public static final class g
    extends m
  {
    public final Dialog c(Bundle paramBundle)
    {
      paramBundle = new b.a(l());
      String[] arrayOfString = m().getStringArray(2131689487);
      paramBundle.a(arrayOfString, asp.a(this, arrayOfString));
      paramBundle = paramBundle.a();
      paramBundle.setCanceledOnTouchOutside(true);
      return paramBundle;
    }
  }
  
  final class h
    extends OrientationEventListener
  {
    private int b = -1;
    
    public h(Context paramContext)
    {
      super();
    }
    
    public final void onOrientationChanged(int paramInt)
    {
      if (paramInt == -1) {}
      label27:
      label292:
      label298:
      label301:
      for (;;)
      {
        return;
        paramInt %= 360;
        if ((paramInt >= 330) || (paramInt < 30)) {
          paramInt = 0;
        }
        for (;;)
        {
          if ((paramInt == this.b) || (paramInt == -1)) {
            break label301;
          }
          Log.i("voip/VoipActivity/VideoOrientationListener/onOrientationChanged from: " + this.b + " to: " + paramInt);
          this.b = paramInt;
          Voip.videoOrientationChanged(paramInt * 90);
          int i = this.b;
          if (i == 1) {
            paramInt = 3;
          }
          Object localObject;
          for (;;)
          {
            paramInt *= 90;
            localObject = (ImageButton)VoipActivity.this.findViewById(2131756209);
            View localView1 = VoipActivity.this.findViewById(2131756202);
            View localView2 = VoipActivity.this.findViewById(2131756205);
            View localView3 = VoipActivity.this.findViewById(2131756206);
            ((ImageButton)localObject).setRotation(paramInt);
            localView1.setRotation(paramInt);
            localView2.setRotation(paramInt);
            localView3.setRotation(paramInt);
            if (!VoipActivity.n(VoipActivity.this)) {
              break;
            }
            localObject = (TextView)VoipActivity.this.findViewById(2131756188);
            ((TextView)localObject).setRotation(paramInt);
            if ((this.b != 1) && (this.b != 3)) {
              break label292;
            }
            ((TextView)localObject).setGravity(17);
            return;
            if ((paramInt >= 60) && (paramInt < 120))
            {
              paramInt = 1;
              break label27;
            }
            if ((paramInt >= 150) && (paramInt < 210))
            {
              paramInt = 2;
              break label27;
            }
            if ((paramInt < 240) || (paramInt >= 300)) {
              break label298;
            }
            paramInt = 3;
            break label27;
            paramInt = i;
            if (i == 3) {
              paramInt = 1;
            }
          }
          ((TextView)localObject).setGravity(1);
          return;
          paramInt = -1;
        }
      }
    }
  }
  
  final class i
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
        VoipActivity.i.this.e.setVisibility(8);
        VoipActivity.i.this.e.clearAnimation();
      }
    };
    
    public i(Activity paramActivity, String paramString, boolean paramBoolean, int paramInt)
    {
      this.b = paramActivity;
      this.a = paramString;
      this.q = paramBoolean;
      this.r = paramInt;
      this.c = ((TextView)VoipActivity.this.findViewById(2131756221));
      this.e = ((TextView)VoipActivity.this.findViewById(2131756217));
      this.f = VoipActivity.this.findViewById(2131756222);
      this.d = VoipActivity.this.findViewById(2131756225);
      try
      {
        if (Settings.System.getInt(VoipActivity.this.getContentResolver(), "haptic_feedback_enabled") != 0) {
          ((Vibrator)VoipActivity.this.getSystemService("vibrator")).vibrate(75L);
        }
        VoipActivity.this.findViewById(2131756220).setVisibility(8);
        this.j = VoipActivity.this.getResources().getDimensionPixelSize(2131362113);
        return;
      }
      catch (Settings.SettingNotFoundException paramActivity)
      {
        for (;;)
        {
          Log.d("VoipActivity vm vibrate exception", paramActivity);
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
        VoipActivity.this.aq.b(this.t);
        this.e.clearAnimation();
        this.e.setVisibility(8);
      }
    }
    
    final void a(boolean paramBoolean)
    {
      b();
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
              break label314;
            }
            bool = true;
            Log.i("VoipActivity vm sending: " + bool + " got send: " + paramBoolean + " duration: " + this.o + " filesize:" + l1);
            if (this.m != null)
            {
              this.m.s.w = ((int)(this.o / 1000L));
              this.m.s.t = l1;
              this.m.a(bool);
              this.m = null;
            }
            if (!bool) {
              break label319;
            }
            pb.a(this.b.getApplicationContext(), 1, l1, 1);
            VoipActivity.this.startActivity(Conversation.a(VoipActivity.x(VoipActivity.this).d(this.a)));
            if (this.k != null) {
              this.k.removeMessages(0);
            }
            if ((this.s != null) && (this.s.isHeld())) {
              this.s.release();
            }
            return;
            localException1 = localException1;
            Log.d("VoipActivity vm stop exception:", localException1);
          }
        }
        catch (Exception localException2)
        {
          long l1;
          int i1;
          label314:
          label319:
          do
          {
            for (;;)
            {
              Log.d("VoipActivity vm release exception:", localException2);
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
          Log.i("voip/VoipActivity/showVoiceMailTip. start animation. tipId:2131296344");
          this.e.setText(2131296344);
          this.e.setBackgroundDrawable(new az(this.b.getResources().getDrawable(2130840452)));
          this.e.setVisibility(0);
          localObject = new AlphaAnimation(0.0F, 1.0F);
          ((Animation)localObject).setDuration(320L);
          this.e.startAnimation((Animation)localObject);
          VoipActivity.this.aq.b(this.t);
          VoipActivity.this.aq.a(this.t, 3500L);
          if (this.k != null) {
            this.k.removeMessages(0);
          }
          VoipActivity.B(VoipActivity.this);
          VoipActivity.a(VoipActivity.this, this.a, this.q, this.r);
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
        Log.e("VoipActivity vm recorder already present");
        return false;
      }
      yx.i();
      b();
      this.l = a.a(VoipActivity.w(VoipActivity.this).a(MediaFileUtils.a(VoipActivity.v(VoipActivity.this)), (byte)2, 1, true).getAbsolutePath(), "audio/ogg; codecs=opus");
      this.n = SystemClock.elapsedRealtime();
      for (;;)
      {
        try
        {
          this.l.a();
          Log.i("VoipActivity vm recorder prepared");
          PowerManager localPowerManager;
          this.s = localException2.newWakeLock(6, "voicemail");
        }
        catch (Exception localException1)
        {
          try
          {
            this.l.b();
            Log.i("VoipActivity vm recorder start");
            if (VoipActivity.x(VoipActivity.this).d(this.a).d == null) {
              VoipActivity.this.ay.a(new String[] { this.a });
            }
            new Handler(Looper.getMainLooper())
            {
              public final void handleMessage(Message paramAnonymousMessage)
              {
                if (VoipActivity.i.this.l != null)
                {
                  long l = SystemClock.elapsedRealtime() - VoipActivity.i.this.n;
                  Log.i("VoipActivity vm setting up message and uploader: " + l + " " + VoipActivity.i.this.l.e().length());
                  if ((VoipActivity.i.this.m == null) && (l > 1000L))
                  {
                    paramAnonymousMessage = new MediaData();
                    paramAnonymousMessage.autodownloadRetryEnabled = true;
                    paramAnonymousMessage.file = VoipActivity.i.this.l.e();
                    j localj = new j(VoipActivity.v(VoipActivity.this), VoipActivity.i.this.a, paramAnonymousMessage);
                    localj.n = VoipActivity.y(VoipActivity.this).b();
                    localj.m = 1;
                    localj.s = 2;
                    localj.o = 1;
                    localj.y = paramAnonymousMessage.file.getName();
                    localj.t = 0L;
                    VoipActivity.z(VoipActivity.this).d(localj);
                    VoipActivity.i.this.m = VoipActivity.A(VoipActivity.this).a(VoipActivity.z(VoipActivity.this), localj);
                    paramAnonymousMessage.uploader = VoipActivity.i.this.m;
                    VoipActivity.i.this.m.j();
                    Log.d("VoipActivity vm after setup message and uploader");
                  }
                }
              }
            }.sendEmptyMessageDelayed(0, 1100L);
            this.k = new Handler(Looper.getMainLooper())
            {
              public final void handleMessage(Message paramAnonymousMessage)
              {
                VoipActivity.i.this.o = (SystemClock.elapsedRealtime() - VoipActivity.i.this.n);
                VoipActivity.i.this.c.setText(DateUtils.formatElapsedTime(VoipActivity.i.this.o / 1000L));
                if (VoipActivity.i.this.l != null)
                {
                  if (VoipActivity.i.a(VoipActivity.i.this.l.e().length())) {
                    VoipActivity.i.this.a(false);
                  }
                }
                else {
                  return;
                }
                VoipActivity.i.this.k.sendEmptyMessageDelayed(0, 1000L);
              }
            };
            this.k.sendEmptyMessageDelayed(0, 1100L);
            localPowerManager = VoipActivity.this.aE.a;
            if (localPowerManager != null) {
              break label258;
            }
            Log.w("voip/VoipActivity/start-recording pm=null");
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
        label258:
        this.s.acquire();
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/VoipActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */