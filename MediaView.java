package com.whatsapp;

import a.a.a.a.a.a.d;
import a.a.a.a.d;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.c;
import android.support.v4.content.b;
import android.support.v4.view.ViewPager.f;
import android.support.v4.view.w;
import android.text.format.DateUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.whatsapp.crop.CropImage;
import com.whatsapp.data.ab;
import com.whatsapp.data.ac;
import com.whatsapp.data.ad;
import com.whatsapp.data.ad.l;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.data.y;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.protocol.m;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils;
import com.whatsapp.util.MediaFileUtils.e;
import com.whatsapp.util.ag;
import com.whatsapp.util.ag.a;
import com.whatsapp.util.az;
import com.whatsapp.util.bu;
import com.whatsapp.util.f;
import com.whatsapp.videoplayback.p;
import com.whatsapp.wallpaper.g;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class MediaView
  extends nh
{
  private static final boolean D;
  private static final boolean E;
  private static final boolean F;
  public static final boolean n;
  public boolean A = true;
  boolean B;
  private String G;
  private j.b H;
  private boolean I;
  private f J;
  private e K;
  private int L;
  private j M;
  private View N;
  private TextEmojiLabel O;
  private TextView P;
  private View Q;
  private int R;
  private boolean S = true;
  private boolean T = true;
  private String U;
  private c V;
  private g W;
  private int X;
  private int Y;
  private float Z;
  private final ad aT = ad.a();
  private final di aU = di.a();
  private final e aV = e.a();
  private final dh aW = dh.a();
  private final com.whatsapp.data.l aX = com.whatsapp.data.l.a();
  private final g aY = g.a();
  private final y aZ = y.a();
  private float aa;
  private Drawable ab;
  private boolean ac;
  private int ad;
  private j ae;
  private final Map<j.b, com.whatsapp.videoplayback.o> af = new HashMap();
  private final ant ag = ant.a();
  private final va ah = va.a();
  private final com.whatsapp.util.h ai = com.whatsapp.util.h.a();
  private final aoj aj = aoj.a();
  private final ag ba = ag.a();
  private final ane bb = ane.a();
  private final ac bc = ac.a();
  private final dh.a bd = new dh.a()
  {
    public final void b(String paramAnonymousString)
    {
      if ((MediaView.a(MediaView.this) != null) && (MediaView.a(MediaView.this).equals(paramAnonymousString))) {
        d.b(MediaView.this, 1);
      }
      va.a locala;
      do
      {
        return;
        locala = MediaView.b(MediaView.this).c();
      } while ((locala == null) || (!paramAnonymousString.equals(locala.t)));
      d.b(MediaView.this, 0);
    }
  };
  private boolean be;
  private final ab bf = new ab()
  {
    public final void a(Collection<j> paramAnonymousCollection, Map<String, Integer> paramAnonymousMap)
    {
      paramAnonymousCollection = paramAnonymousCollection.iterator();
      while (paramAnonymousCollection.hasNext())
      {
        paramAnonymousMap = (j)paramAnonymousCollection.next();
        if ((paramAnonymousMap.e.a.equals(MediaView.c(MediaView.this))) && (m.a(paramAnonymousMap.s)))
        {
          if (MediaView.d(MediaView.this).b() != 1) {
            break label78;
          }
          MediaView.this.finish();
        }
      }
      label78:
      do
      {
        return;
        paramAnonymousCollection = MediaView.a(MediaView.this, MediaView.e(MediaView.this));
      } while (paramAnonymousCollection == null);
      if (paramAnonymousCollection.e.equals(paramAnonymousMap.e)) {
        if (MediaView.e(MediaView.this) == MediaView.d(MediaView.this).b() - 1) {
          paramAnonymousCollection = MediaView.a(MediaView.this, MediaView.e(MediaView.this) - 1);
        }
      }
      for (;;)
      {
        if (MediaView.d(MediaView.this) != null) {
          MediaView.d(MediaView.this).a();
        }
        MediaView.a(MediaView.this, new MediaView.d(MediaView.this, paramAnonymousCollection));
        if (MediaView.f(MediaView.this) != null) {
          MediaView.f(MediaView.this).cancel(true);
        }
        MediaView.a(MediaView.this, new MediaView.c(MediaView.this, paramAnonymousCollection));
        bu.a(MediaView.f(MediaView.this), new Void[0]);
        MediaView.g(MediaView.this).c();
        return;
        paramAnonymousCollection = MediaView.a(MediaView.this, MediaView.e(MediaView.this) + 1);
      }
    }
  };
  private boolean bg;
  d o;
  Rect p;
  TextView q;
  VoiceNoteSeekBar r;
  ImageButton s;
  int t;
  f u;
  int v = 0;
  Handler w;
  final Map<j.b, p> x = new HashMap();
  HashMap<j.b, Integer> y = new HashMap();
  p z = null;
  
  static
  {
    boolean bool2 = true;
    if (!MediaView.class.desiredAssertionStatus())
    {
      bool1 = true;
      C = bool1;
      if ((Build.VERSION.SDK_INT < 16) || (!aic.T)) {
        break label86;
      }
      bool1 = true;
      label32:
      D = bool1;
      if ((!bool1) || (!aic.U)) {
        break label91;
      }
      bool1 = true;
      label48:
      E = bool1;
      if (Build.VERSION.SDK_INT < 21) {
        break label96;
      }
      bool1 = true;
      label62:
      n = bool1;
      if (Build.VERSION.SDK_INT <= 23) {
        break label101;
      }
    }
    label86:
    label91:
    label96:
    label101:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      F = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label32;
      bool1 = false;
      break label48;
      bool1 = false;
      break label62;
    }
  }
  
  public static Intent a(j paramj, String paramString, Context paramContext)
  {
    return a(paramj, paramString, paramContext, 5);
  }
  
  public static Intent a(j paramj, String paramString, Context paramContext, int paramInt)
  {
    paramContext = new Intent(paramContext, MediaView.class);
    paramContext.putExtra("jid", paramString);
    paramContext.putExtra("key", new FMessageKey(paramj.e));
    paramContext.putExtra("video_play_origin", paramInt);
    return paramContext;
  }
  
  public static Intent a(j paramj, String paramString, Context paramContext, View paramView)
  {
    return a(paramj, paramString, paramContext, paramView, 5);
  }
  
  public static Intent a(j paramj, String paramString, Context paramContext, View paramView, int paramInt)
  {
    paramContext = new Intent(paramContext, MediaView.class);
    paramContext.putExtra("jid", paramString);
    paramContext.putExtra("key", new FMessageKey(paramj.e));
    paramj = new int[2];
    paramView.getLocationOnScreen(paramj);
    paramContext.putExtra("x", paramj[0]);
    paramContext.putExtra("y", paramj[1]);
    paramContext.putExtra("width", paramView.getWidth());
    paramContext.putExtra("height", paramView.getHeight());
    paramContext.putExtra("has_animation", true);
    paramContext.putExtra("video_play_origin", paramInt);
    return paramContext;
  }
  
  @TargetApi(21)
  private void a(View paramView)
  {
    Log.d("mediaview/setWindowInsets");
    Object localObject;
    if (this.p != null)
    {
      localObject = (LinearLayout)paramView.findViewById(2131756249);
      if (localObject != null) {
        break label264;
      }
    }
    label126:
    label142:
    label264:
    for (paramView = (LinearLayout)paramView.findViewById(2131755524);; paramView = (View)localObject)
    {
      View localView;
      int i;
      if (paramView != null)
      {
        localView = paramView.findViewById(2131755436);
        localObject = (FrameLayout.LayoutParams)paramView.getLayoutParams();
        i = getResources().getConfiguration().orientation;
        if (localView == null) {
          break label142;
        }
        if (i != 1) {
          break label126;
        }
        paramView.setPadding(0, paramView.getPaddingTop(), 0, this.p.bottom);
      }
      for (;;)
      {
        ((FrameLayout.LayoutParams)localObject).leftMargin = this.p.left;
        ((FrameLayout.LayoutParams)localObject).rightMargin = this.p.right;
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
        if (i == 2)
        {
          paramView.setPadding(0, 0, 0, 0);
          continue;
          paramView.setPadding(paramView.getPaddingLeft(), paramView.getPaddingTop(), paramView.getPaddingRight(), 0);
          localView = paramView.findViewWithTag("navigation_protection");
          if (localView != null) {
            paramView.removeViewInLayout(localView);
          }
          if (i == 1)
          {
            localView = new View(this);
            localView.setBackgroundColor(b.c(this, 2131624072));
            localView.setTag("navigation_protection");
            localView.setLayoutParams(new LinearLayout.LayoutParams(-1, this.p.bottom));
            paramView.addView(localView);
          }
          localView = paramView.findViewById(2131755941);
          if (localView != null) {
            localView.setVisibility(8);
          }
        }
      }
    }
  }
  
  private void a(j paramj)
  {
    Log.i("mediaview/prepareaudioplayback/" + paramj.e.c);
    View localView = this.J.findViewWithTag(paramj.e);
    this.q = ((TextView)localView.findViewById(2131755936));
    this.r = ((VoiceNoteSeekBar)localView.findViewById(2131755585));
    this.r.setOnSeekBarChangeListener(new b((byte)0));
    this.s = ((ImageButton)localView.findViewById(2131755935));
    a locala = new a(this.r, this.s);
    this.s.setOnClickListener(locala);
    localView = localView.findViewById(2131755937);
    if (this.A) {
      localView.setOnClickListener(locala);
    }
    for (;;)
    {
      if (this.u != null)
      {
        this.u.h();
        this.u = null;
      }
      try
      {
        this.u = f.a(paramj.b().file, 3);
        this.u.a(yg.a());
        this.u.a();
        Log.i("mediaview/audio duration:" + this.u.g());
        this.v = 5;
        this.q.setText(DateUtils.formatElapsedTime(this.u.g() / 1000));
        this.r.setMax(this.u.g());
        this.r.setProgress(0);
        this.s.setImageDrawable(new az(getResources().getDrawable(2130840401)));
        return;
        localView.setOnClickListener(yf.a(this, locala));
      }
      catch (IOException paramj)
      {
        for (;;)
        {
          Log.e(paramj);
          b_(2131296813);
        }
      }
    }
  }
  
  private void a(j paramj, int paramInt, boolean paramBoolean)
  {
    int i = 4;
    int j = 3;
    yx.j();
    if ((!D) && (paramj.s == 3))
    {
      localObject1 = new Intent("android.intent.action.VIEW");
      ((Intent)localObject1).setDataAndType(MediaProvider.a(paramj), "video/*");
      ((Intent)localObject1).setFlags(1);
      if (Build.MANUFACTURER.startsWith("Sony"))
      {
        Object localObject2 = u.a().getPackageManager().queryIntentActivities((Intent)localObject1, 0);
        if (localObject2 != null)
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            ResolveInfo localResolveInfo = (ResolveInfo)((Iterator)localObject2).next();
            Log.i(localResolveInfo.activityInfo.packageName + " | " + localResolveInfo.activityInfo.name);
            if (localResolveInfo.activityInfo.name.equals("com.sonyericsson.gallery.MovieView")) {
              ((Intent)localObject1).setClassName("com.sonyericsson.gallery", "com.sonyericsson.gallery.MovieView");
            }
          }
        }
      }
      pv.a(this, (Intent)localObject1);
      localObject1 = paramj.b();
      if (this.T)
      {
        if (paramj.e.b)
        {
          paramInt = j;
          if (paramBoolean) {
            i = this.R;
          }
          pb.a(this, paramInt, i, paramj.w, ((MediaData)localObject1).file);
        }
      }
      else {
        this.T = false;
      }
    }
    label403:
    do
    {
      do
      {
        return;
        paramInt = 1;
        break;
        if ((D) && (paramj.s == 3) && (paramBoolean) && (this.z != null))
        {
          this.z.n = this.R;
          this.z.b();
          return;
        }
        if (paramj.s != 2) {
          break label403;
        }
        a(paramj);
      } while (this.u == null);
      this.ai.b();
      try
      {
        this.u.b();
        if (paramInt > 0)
        {
          this.u.a(paramInt);
          this.r.setProgress(this.u.f());
        }
        this.v = 4;
        this.w.sendEmptyMessage(0);
        this.s.setImageResource(2130840400);
        return;
      }
      catch (IOException paramj)
      {
        Log.e(paramj);
        b_(2131296813);
        return;
      }
    } while (paramj.s != 9);
    Object localObject1 = new Intent("android.intent.action.VIEW");
    ((Intent)localObject1).setDataAndType(MediaProvider.a(paramj), paramj.r);
    ((Intent)localObject1).setFlags(1);
    pv.a(this, (Intent)localObject1);
  }
  
  private void a(j paramj, final PhotoView paramPhotoView)
  {
    this.ba.b(paramj, paramPhotoView, new ag.a()
    {
      public final int a()
      {
        return MediaView.o(MediaView.this).c();
      }
      
      public final void a(View paramAnonymousView)
      {
        paramPhotoView.c = null;
      }
      
      public final void a(View arg1, Bitmap paramAnonymousBitmap, j paramAnonymousj)
      {
        paramPhotoView.a(paramAnonymousBitmap);
        MediaView.g localg;
        MediaView.g.a locala;
        if (MediaView.p(MediaView.this) != null)
        {
          localg = MediaView.p(MediaView.this);
          locala = new MediaView.g.a(localg, paramAnonymousj, paramPhotoView);
        }
        do
        {
          synchronized (localg.a)
          {
            localg.a.add(0, locala);
            localg.a.notifyAll();
            if (paramAnonymousj.s == 1)
            {
              if (paramAnonymousBitmap == null) {
                paramPhotoView.a(((BitmapDrawable)MediaView.this.getResources().getDrawable(2130837610)).getBitmap());
              }
              paramPhotoView.setOnClickListener(yl.a(this));
              return;
            }
          }
          if ((paramAnonymousj.s == 3) || (paramAnonymousj.s == 13))
          {
            if (paramAnonymousBitmap == null) {
              paramPhotoView.a(((BitmapDrawable)MediaView.this.getResources().getDrawable(2130837613)).getBitmap());
            }
            paramPhotoView.setOnClickListener(ym.a(this, paramAnonymousj));
            return;
          }
        } while ((paramAnonymousj.s != 9) || (paramAnonymousBitmap != null));
        paramPhotoView.a(((BitmapDrawable)MediaView.this.getResources().getDrawable(2130840278)).getBitmap());
      }
    });
  }
  
  private byte[] a(File paramFile, boolean paramBoolean)
  {
    int i = 8;
    int j = 6;
    int k = 1;
    int m;
    for (;;)
    {
      try
      {
        localObject = new ExifInterface(paramFile.getAbsolutePath());
        m = ((ExifInterface)localObject).getAttributeInt("Orientation", 1);
        switch (m)
        {
        case 0: 
          ((ExifInterface)localObject).setAttribute("Orientation", Integer.toString(i));
          ((ExifInterface)localObject).saveAttributes();
        }
      }
      catch (NoClassDefFoundError paramFile)
      {
        Object localObject;
        Log.d("mediaview/rotate, no class", paramFile);
        return null;
      }
      catch (IOException paramFile)
      {
        Log.d("mediaview/rotate", paramFile);
        return null;
      }
      try
      {
        paramFile = MediaFileUtils.a(this.aE, Uri.fromFile(paramFile), 100, 100);
        localObject = new ByteArrayOutputStream();
        paramFile.compress(Bitmap.CompressFormat.JPEG, 80, (OutputStream)localObject);
        a.d.a((Closeable)localObject);
        localObject = ((ByteArrayOutputStream)localObject).toByteArray();
        paramFile.recycle();
        return (byte[])localObject;
      }
      catch (OutOfMemoryError paramFile)
      {
        Log.d("mediaview/rotate/recreatethumb", paramFile);
        return null;
      }
      catch (IOException paramFile)
      {
        for (;;) {}
      }
      catch (MediaFileUtils.e paramFile)
      {
        for (;;) {}
        i = m;
      }
      i = j;
      if (!paramBoolean)
      {
        i = 8;
        continue;
        if (paramBoolean)
        {
          i = 3;
        }
        else
        {
          i = 1;
          continue;
          if (!paramBoolean)
          {
            i = 6;
            continue;
            if (paramBoolean) {
              i = k;
            } else {
              i = 3;
            }
          }
        }
      }
    }
  }
  
  private PhotoView b(j paramj)
  {
    if (paramj == null) {
      return null;
    }
    paramj = this.J.findViewWithTag(paramj.e);
    if ((paramj != null) && ((paramj instanceof ViewGroup)))
    {
      paramj = ((ViewGroup)paramj).getChildAt(0);
      if ((paramj != null) && ((paramj instanceof PhotoView))) {
        return (PhotoView)paramj;
      }
    }
    return null;
  }
  
  private void c(final boolean paramBoolean)
  {
    final j localj = d(this.L);
    if ((!C) && (localj == null)) {
      throw new AssertionError();
    }
    bu.a(new AsyncTask()
    {
      private Boolean a()
      {
        try
        {
          boolean bool = MediaView.n(MediaView.this).a(localj, new ad.l(this, paramBoolean, localj));
          return Boolean.valueOf(bool);
        }
        catch (IOException localIOException)
        {
          Log.d("mediaview/rotate", localIOException);
        }
        return Boolean.valueOf(false);
      }
    }, new Void[0]);
  }
  
  private j d(int paramInt)
  {
    d locald = this.o;
    paramInt -= locald.d;
    j localj1 = (j)locald.f.get(paramInt);
    j localj2 = localj1;
    if (localj1 == null)
    {
      if (paramInt >= 0) {
        break label167;
      }
      if (locald.a != null) {
        break label77;
      }
      Log.d("mediaview/navigator/ no head cursor");
    }
    for (;;)
    {
      localj1 = null;
      for (;;)
      {
        localj2 = localj1;
        if (localj1 != null)
        {
          locald.f.put(paramInt, localj1);
          localj2 = localj1;
        }
        return localj2;
        label77:
        int i = -paramInt - 1;
        if (i >= locald.a.getCount())
        {
          Log.d("mediaview/navigator/ head pos " + i + " is not less than head cursor count " + locald.a.getCount());
          break;
        }
        if (locald.a.moveToPosition(i))
        {
          localj1 = locald.a.a();
        }
        else
        {
          Log.d("mediaview/navigator/ no message at head cursor");
          break;
          label167:
          if (paramInt == 0)
          {
            localj1 = locald.c;
          }
          else
          {
            if (paramInt <= 0) {
              break;
            }
            if (locald.b == null)
            {
              Log.d("mediaview/navigator/ no tail cursor");
              break;
            }
            i = paramInt - 1;
            if (i >= locald.b.getCount())
            {
              Log.d("mediaview/navigator/ tail pos " + i + " is not less than head cursor count " + locald.b.getCount());
              break;
            }
            if (!locald.b.moveToPosition(paramInt - 1)) {
              break label283;
            }
            localj1 = locald.b.a();
          }
        }
      }
      label283:
      Log.d("mediaview/ no message at tail cursor");
    }
  }
  
  private void e(int paramInt)
  {
    j localj = d(paramInt);
    if (localj == null) {
      return;
    }
    String str;
    if (localj.e.b) {
      str = getString(2131298216);
    }
    for (;;)
    {
      this.O.setText(str);
      str = com.whatsapp.util.l.b(this, this.aF, this.ag.a(localj)).toString();
      this.P.setText(str);
      invalidateOptionsMenu();
      return;
      if ((qz.e(localj.e.a)) && (localj.f != null)) {
        str = this.aV.d(localj.f).a(this);
      } else {
        str = this.aV.d(this.G).a(this);
      }
    }
  }
  
  private static int f(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 2131296824;
    case 2: 
      return 2131296814;
    case 1: 
      return 2131296820;
    case 13: 
      return 2131296819;
    case 3: 
      return 2131296831;
    }
    return 2131296818;
  }
  
  public static boolean l()
  {
    return Build.VERSION.SDK_INT >= 12;
  }
  
  public static void p() {}
  
  @TargetApi(12)
  private void t()
  {
    if (!l()) {
      return;
    }
    Object localObject = this.J;
    j localj = d(this.J.getCurrentItem());
    if ((getResources().getConfiguration().orientation != this.ad) || (localj == null) || (!localj.e.equals(this.H)))
    {
      ((View)localObject).setPivotX(((View)localObject).getWidth() / 2);
      ((View)localObject).setPivotY(((View)localObject).getHeight() / 2);
      this.X = 0;
      this.Y = 0;
    }
    ((View)localObject).animate().setDuration(240L).scaleX(this.Z).scaleY(this.aa).translationX(this.X).translationY(this.Y).alpha(0.0F).setListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        MediaView.this.finish();
      }
    });
    localObject = ObjectAnimator.ofInt(this.ab, "alpha", new int[] { 255, 0 });
    ((ObjectAnimator)localObject).setDuration(240L);
    ((ObjectAnimator)localObject).setInterpolator(new DecelerateInterpolator());
    ((ObjectAnimator)localObject).start();
  }
  
  final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.ac) {}
    for (;;)
    {
      return;
      if (this.A != paramBoolean1)
      {
        this.A = paramBoolean1;
        int j = this.J.getChildCount();
        int i = 0;
        AlphaAnimation localAlphaAnimation;
        if (i < j)
        {
          View localView = this.J.getChildAt(i).findViewById(2131755524);
          if (paramBoolean1)
          {
            localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
            localView.setVisibility(0);
          }
          for (;;)
          {
            localAlphaAnimation.setDuration(400L);
            localView.setAnimation(localAlphaAnimation);
            i += 1;
            break;
            localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
            localView.setVisibility(4);
          }
        }
        if (paramBoolean1)
        {
          i().e();
          localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
          localAlphaAnimation.setDuration(250L);
          this.N.setVisibility(0);
          this.N.setAnimation(localAlphaAnimation);
        }
        while ((paramBoolean2) && (Build.VERSION.SDK_INT >= 11))
        {
          j = 1280;
          i = j;
          if (!paramBoolean1)
          {
            i = j;
            if (Build.VERSION.SDK_INT >= 14)
            {
              i = 1281;
              if (Build.VERSION.SDK_INT >= 16) {
                i = 1285;
              }
            }
          }
          j = i;
          if (Build.VERSION.SDK_INT >= 19) {
            j = i | 0x800;
          }
          i = j;
          if (n)
          {
            j |= 0x200;
            i = j;
            if (!paramBoolean1) {
              i = j | 0x2;
            }
          }
          getWindow().getDecorView().setSystemUiVisibility(i);
          return;
          i().f();
          localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
          localAlphaAnimation.setDuration(250L);
          this.N.setVisibility(4);
          this.N.startAnimation(localAlphaAnimation);
        }
      }
    }
  }
  
  public final void c(int paramInt)
  {
    if (paramInt == 2131296740) {
      finish();
    }
  }
  
  public void finish()
  {
    super.finish();
    if ((l()) && (this.ae != null)) {
      overridePendingTransition(0, 0);
    }
    Iterator localIterator = this.af.keySet().iterator();
    while (localIterator.hasNext())
    {
      j.b localb = (j.b)localIterator.next();
      ((com.whatsapp.videoplayback.o)this.af.get(localb)).d();
    }
    this.af.clear();
  }
  
  @TargetApi(21)
  final void m()
  {
    if (this.J != null)
    {
      int i = 0;
      while (i < this.J.getChildCount())
      {
        a(this.J.getChildAt(i));
        i += 1;
      }
    }
  }
  
  final void n()
  {
    if ((l()) && (getIntent().getBooleanExtra("gallery", false)) && (this.ae != null))
    {
      t();
      return;
    }
    this.ae = null;
    Intent localIntent = new Intent(this, MediaGallery.class);
    localIntent.putExtra("jid", this.G);
    android.support.v4.app.a.a(this, localIntent, c.a(this, new android.support.v4.f.h[0]).a());
    finish();
  }
  
  final void o()
  {
    if (this.u != null)
    {
      this.u.h();
      this.u = null;
      this.v = 0;
    }
    if (this.r != null) {
      this.r.setProgress(0);
    }
    if (this.s != null) {
      this.s.setImageDrawable(new az(getResources().getDrawable(2130840401)));
    }
    if (this.q != null) {
      this.q.setText(DateUtils.formatElapsedTime(0L));
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                } while ((paramInt2 != -1) || (paramIntent == null) || (paramIntent.getData() == null));
                paramIntent = paramIntent.getData();
                if (paramIntent == null) {
                  this.aY.a(this, false, -1, true, -1, null, 0, 0);
                }
                for (;;)
                {
                  MediaFileUtils.a(this, paramIntent);
                  return;
                  this.aY.a(this, false, -1, false, -1, paramIntent, 0, 0);
                }
                if (paramInt2 != -1) {
                  break;
                }
              } while (!this.aO.a(this, this.ah.c()));
              d.a(this, 0);
              return;
            } while ((paramInt2 != 0) || (paramIntent == null));
            this.aO.a(this, paramIntent);
            return;
          } while ((paramInt2 != -1) || (paramIntent == null));
          this.U = paramIntent.getStringExtra("contact");
          paramIntent = new Intent();
          localj = d(this.L);
          if ((!C) && (localj == null)) {
            throw new AssertionError();
          }
          paramIntent.setData(Uri.fromFile(localj.b().file));
          this.aO.a(this, 3, paramIntent);
          return;
          if ((paramInt2 != -1) || (this.U == null)) {
            break;
          }
        } while (!this.aO.a(this, this.aV.e(this.U)));
        d.a(this, 1);
        return;
      } while ((paramInt2 != 0) || (paramIntent == null));
      this.aO.a(this, paramIntent);
      return;
    } while ((paramInt2 != -1) || (paramIntent == null));
    j localj = d(this.L);
    if (localj != null)
    {
      paramIntent = paramIntent.getStringArrayListExtra("jids");
      this.aj.a(this.as, localj, paramIntent);
      if (paramIntent.size() == 1)
      {
        startActivity(Conversation.a(this.aV.d((String)paramIntent.get(0))));
        return;
      }
      pv.a(getBaseContext(), paramIntent);
      return;
    }
    Log.w("mediaview/forward/failed");
    pv.a(this, 2131297172, 0);
  }
  
  public void onBackPressed()
  {
    if ((l()) && (this.ae != null))
    {
      if (this.W != null)
      {
        this.W.a();
        this.W = null;
      }
      if (this.V != null)
      {
        this.V.cancel(true);
        this.V = null;
      }
      t();
      return;
    }
    super.onBackPressed();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (n)
    {
      getWindow().setStatusBarColor(b.c(this, 2131624073));
      if (paramConfiguration.orientation != 2) {
        break label58;
      }
      getWindow().setNavigationBarColor(b.c(this, 2131624072));
    }
    for (;;)
    {
      getWindow().addFlags(Integer.MIN_VALUE);
      return;
      label58:
      if (paramConfiguration.orientation == 1) {
        getWindow().setNavigationBarColor(b.c(this, 17170445));
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Object localObject2 = null;
    Log.i("mediaview/create");
    bu.a(anf.a(this.bb));
    super.onCreate(paramBundle);
    final Object localObject1 = (android.support.v7.app.a)a.d.a(i());
    ((android.support.v7.app.a)localObject1).a(new ColorDrawable(b.c(this, 2131624071)));
    ((android.support.v7.app.a)localObject1).b();
    ((android.support.v7.app.a)localObject1).a(false);
    Intent localIntent;
    for (;;)
    {
      try
      {
        setContentView(2130903289);
        if (n)
        {
          getWindow().getDecorView().setSystemUiVisibility(1792);
          findViewById(2131755835).setOnApplyWindowInsetsListener(xx.a(this));
          localIntent = getIntent();
          if (localIntent != null) {
            break;
          }
          finish();
          return;
        }
      }
      catch (OutOfMemoryError paramBundle)
      {
        Log.e("mediaview/oncreate/oom/heap size:" + Debug.getNativeHeapAllocatedSize() / 1024L + " kB");
        MediaFileUtils.a(this.aU);
        b_(2131296740);
        return;
      }
      if (Build.VERSION.SDK_INT >= 11) {
        getWindow().getDecorView().setSystemUiVisibility(1280);
      }
    }
    this.W = new g((byte)0);
    this.W.b.start();
    localObject1 = (ViewGroup)al.a(this.aq, LayoutInflater.from(i().h()), 2130903290, null, false);
    Object localObject3 = (ViewGroup)((ViewGroup)localObject1).findViewById(2131755932);
    ((ViewGroup)localObject3).setClickable(true);
    ((ViewGroup)localObject3).setOnClickListener(yh.a(this));
    this.O = ((TextEmojiLabel)((ViewGroup)localObject3).findViewById(2131755397));
    this.P = ((TextView)((ViewGroup)localObject3).findViewById(2131755933));
    this.Q = ((ViewGroup)localObject1).findViewById(2131755238);
    ((ViewGroup)localObject1).findViewById(2131755439).setOnClickListener(yi.a(this));
    i().c();
    i().a((View)localObject1);
    this.G = localIntent.getStringExtra("jid");
    this.I = localIntent.getBooleanExtra("nogallery", false);
    if (this.I) {
      this.Q.setVisibility(8);
    }
    this.R = pb.b(localIntent.getIntExtra("video_play_origin", 5));
    if (paramBundle != null) {
      this.T = paramBundle.getBoolean("is_different_video", true);
    }
    localObject1 = (FMessageKey)localIntent.getParcelableExtra("key");
    if (localObject1 == null)
    {
      Log.e("mediaview/message key parameter is missing");
      finish();
      return;
    }
    this.H = ((FMessageKey)localObject1).a;
    Log.i("mediaview/found-key " + this.H.a + " me:" + this.H.b + " id:" + this.H.c);
    localObject3 = this.aX.a(this.H);
    if (localObject3 == null)
    {
      Log.e("mediaview/cannot find message for " + this.H);
      finish();
      return;
    }
    if ((((j)localObject3).s == 2) || (((j)localObject3).s == 3) || (((j)localObject3).s == 9) || (((j)localObject3).s == 13)) {}
    for (localObject1 = localObject3;; localObject1 = null)
    {
      Log.i("mediaview/view message:" + this.H);
      if (!this.I)
      {
        this.V = new c((j)localObject3);
        bu.a(this.V, new Void[0]);
      }
      this.o = new d((j)localObject3);
      this.L = 0;
      this.M = ((j)localObject3);
      PhotoView.b = ((BitmapDrawable)b.a(this, 2130840403)).getBitmap();
      this.w = new Handler(Looper.getMainLooper(), yd.a(this));
      if (paramBundle != null) {
        localObject1 = localObject2;
      }
      for (;;)
      {
        this.M = ((j)localObject1);
        this.N = findViewById(2131755425);
        this.K = new e((j)localObject1);
        this.J = new f(this);
        ((ViewGroup)findViewById(2131755930)).addView(this.J);
        this.J.setAdapter(this.K);
        this.J.a(0, false);
        e(this.L);
        localObject1 = findViewById(2131755930);
        this.ab = new ColorDrawable(-16777216);
        ((View)localObject1).setBackgroundDrawable(this.ab);
        if ((paramBundle == null) && (((j)localObject3).s == 1) && (l()) && (localIntent.getBooleanExtra("has_animation", false)))
        {
          this.ae = ((j)localObject3);
          this.ac = true;
          localObject1 = this.J;
          final int i = localIntent.getIntExtra("x", 0);
          final int j = localIntent.getIntExtra("y", 0);
          final int k = localIntent.getIntExtra("width", 0);
          final int m = localIntent.getIntExtra("height", 0);
          i().f();
          this.A = false;
          ((View)localObject1).getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public final boolean onPreDraw()
            {
              localObject1.getViewTreeObserver().removeOnPreDrawListener(this);
              int[] arrayOfInt = new int[2];
              localObject1.getLocationOnScreen(arrayOfInt);
              MediaView.b(MediaView.this, i - arrayOfInt[0]);
              MediaView.c(MediaView.this, j - arrayOfInt[1]);
              MediaView.a(MediaView.this, k / localObject1.getWidth());
              MediaView.b(MediaView.this, m / localObject1.getHeight());
              float f1;
              float f2;
              if (MediaView.h(MediaView.this) < MediaView.i(MediaView.this))
              {
                MediaView.a(MediaView.this, MediaView.i(MediaView.this));
                f1 = localObject1.getWidth();
                f2 = MediaView.h(MediaView.this);
                MediaView.b(MediaView.this, (int)(MediaView.j(MediaView.this) - (f1 * f2 - k) / 2.0F));
              }
              for (;;)
              {
                MediaView.l(MediaView.this);
                return true;
                MediaView.b(MediaView.this, MediaView.h(MediaView.this));
                f1 = localObject1.getHeight();
                f2 = MediaView.i(MediaView.this);
                MediaView.c(MediaView.this, (int)(MediaView.k(MediaView.this) - (f1 * f2 - m) / 2.0F));
              }
            }
          });
        }
        if (paramBundle != null) {
          this.U = paramBundle.getString("gid");
        }
        this.be = true;
        this.aW.registerObserver(this.bd);
        this.bg = true;
        this.bc.registerObserver(this.bf);
        onConfigurationChanged(getResources().getConfiguration());
        return;
      }
    }
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    case 0: 
      localObject = new ProgressDialog(this);
      ((ProgressDialog)localObject).setMessage(getString(2131298071));
      ((ProgressDialog)localObject).setIndeterminate(true);
      ((ProgressDialog)localObject).setCancelable(false);
      return (Dialog)localObject;
    case 1: 
      localObject = new ProgressDialog(this);
      ((ProgressDialog)localObject).setMessage(getString(2131298070));
      ((ProgressDialog)localObject).setIndeterminate(true);
      ((ProgressDialog)localObject).setCancelable(false);
      return (Dialog)localObject;
    }
    Object localObject = d(this.L);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    return d.a(this, this.aq, this.ag, this.aj, this.aV, localArrayList, this.G, 2, false, new ye(this));
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    android.support.v4.view.o.a(paramMenu.add(0, 11, 0, 2131296303).setIcon(2130840200), 2);
    android.support.v4.view.o.a(paramMenu.add(0, 12, 0, 2131297609).setIcon(2130840199), 2);
    android.support.v4.view.o.a(paramMenu.add(0, 10, 0, 2131296564).setIcon(2130840197), 2);
    android.support.v4.view.o.a(paramMenu.add(0, 8, 0, 2131296310).setIcon(2130840048), 0);
    paramMenu.add(0, 9, 0, 2131297833).setIcon(2130840077);
    paramMenu.add(1, 5, 0, 2131297688);
    paramMenu.add(1, 6, 0, 2131297686);
    paramMenu.add(1, 1, 0, 2131298075);
    paramMenu.add(1, 2, 0, 2131298128);
    paramMenu.add(1, 3, 0, 2131297625);
    paramMenu.add(1, 4, 0, 2131297626);
    paramMenu.add(0, 7, 0, 2131296609);
    return true;
  }
  
  public void onDestroy()
  {
    Log.i("mediaview/destroy");
    o();
    if (this.J != null)
    {
      int i = 0;
      while (i < this.J.getChildCount())
      {
        View localView1 = this.J.getChildAt(i);
        if ((localView1 instanceof FrameLayout))
        {
          int j = 0;
          while (j < ((FrameLayout)localView1).getChildCount())
          {
            View localView2 = ((FrameLayout)localView1).getChildAt(j);
            if ((localView2 instanceof PhotoView)) {
              ((PhotoView)localView2).c();
            }
            j += 1;
          }
        }
        i += 1;
      }
    }
    if (this.W != null)
    {
      this.W.a();
      this.W = null;
    }
    if (this.V != null)
    {
      this.V.cancel(true);
      this.V = null;
    }
    this.M = null;
    if (this.be)
    {
      this.aW.unregisterObserver(this.bd);
      this.be = false;
    }
    if (this.bg)
    {
      this.bc.unregisterObserver(this.bf);
      this.bg = false;
    }
    if (this.o != null) {
      this.o.a();
    }
    bu.a(anf.a(this.bb));
    if (this.z != null) {
      this.z.n();
    }
    super.onDestroy();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    Object localObject;
    switch (paramMenuItem.getItemId())
    {
    default: 
      return true;
    case 1: 
      int j;
      if (getResources().getConfiguration().orientation == 1) {
        j = getWindow().getDecorView().getHeight() - (int)getResources().getDimension(2131362014) - aoa.b();
      }
      for (int i = getWindow().getDecorView().getWidth();; i = getWindow().getDecorView().getHeight())
      {
        paramMenuItem = d(this.L);
        if ((C) || (paramMenuItem != null)) {
          break;
        }
        throw new AssertionError();
        j = getWindow().getDecorView().getWidth() - (int)getResources().getDimension(2131362014) - aoa.b();
      }
      paramMenuItem = Uri.fromFile(paramMenuItem.b().file);
      Log.i("mediaview/wallpaper/crop/height:" + j);
      localObject = new Intent(this, CropImage.class);
      ((Intent)localObject).putExtra("outputX", i);
      ((Intent)localObject).putExtra("outputY", j);
      ((Intent)localObject).putExtra("scale", 1);
      ((Intent)localObject).putExtra("scaleUpIfNeeded", true);
      ((Intent)localObject).putExtra("cropByOutputSize", true);
      ((Intent)localObject).setData(paramMenuItem);
      ((Intent)localObject).putExtra("output", this.aY.b());
      ((Intent)localObject).putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
      startActivityForResult((Intent)localObject, 0);
      return true;
    case 5: 
      paramMenuItem = new Intent();
      localObject = d(this.L);
      if ((!C) && (localObject == null)) {
        throw new AssertionError();
      }
      paramMenuItem.setData(Uri.fromFile(((j)localObject).b().file));
      this.aO.a(this, 1, paramMenuItem);
      return true;
    case 6: 
      paramMenuItem = new Intent(this, ContactPicker.class);
      paramMenuItem.putExtra("set_group_icon", true);
      startActivityForResult(paramMenuItem, 2);
      return true;
    case 2: 
      paramMenuItem = d(this.L);
      if ((!C) && (paramMenuItem == null)) {
        throw new AssertionError();
      }
      localObject = MediaProvider.a(paramMenuItem);
      Log.d("mediaview/uri " + localObject);
      Intent localIntent = new Intent("android.intent.action.VIEW");
      switch (paramMenuItem.s)
      {
      default: 
        localIntent.setData((Uri)localObject);
      }
      for (;;)
      {
        localIntent.setFlags(1);
        pv.a(this, localIntent);
        return true;
        localIntent.setDataAndType((Uri)localObject, "image/*");
        continue;
        localIntent.setDataAndType((Uri)localObject, "video/*");
      }
    case 3: 
      c(false);
      return true;
    case 4: 
      c(true);
      return true;
    case 7: 
      d.a(this, 2);
      return true;
    case 9: 
      paramMenuItem = d(this.L);
      this.aj.a(this, paramMenuItem);
      return true;
    case 10: 
      paramMenuItem = d(this.L);
      if ((!C) && (paramMenuItem == null)) {
        throw new AssertionError();
      }
      localObject = new Intent(this, ContactPicker.class);
      ((Intent)localObject).putExtra("forward", true);
      ((Intent)localObject).putExtra("forward_jid", this.G);
      ((Intent)localObject).putIntegerArrayListExtra("message_types", new ArrayList(Collections.singleton(Integer.valueOf(Byte.valueOf(paramMenuItem.s).intValue()))));
      if (paramMenuItem.s == 3) {}
      for (long l = paramMenuItem.w * 1000L;; l = 0L)
      {
        ((Intent)localObject).putExtra("forward_video_duration", l);
        startActivityForResult((Intent)localObject, 4);
        return true;
      }
    case 11: 
      paramMenuItem = d(this.L);
      this.aT.a(Collections.singleton(paramMenuItem), true, true);
      invalidateOptionsMenu();
      return true;
    case 12: 
      paramMenuItem = d(this.L);
      this.aT.a(Collections.singleton(paramMenuItem), false, true);
      invalidateOptionsMenu();
      return true;
    case 8: 
      n();
      return true;
    }
    if ((l()) && (this.ae != null))
    {
      t();
      return true;
    }
    finish();
    return true;
  }
  
  protected void onPause()
  {
    super.onPause();
    if ((!F) && (this.z != null))
    {
      this.z.d();
      this.z.o();
    }
    if ((isFinishing()) && (this.V != null))
    {
      this.V.cancel(true);
      this.V = null;
    }
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    boolean bool4 = false;
    if (paramMenu.size() == 0) {
      return false;
    }
    Object localObject;
    boolean bool1;
    boolean bool2;
    boolean bool3;
    if (this.J != null)
    {
      localObject = d(this.J.getCurrentItem());
      if (localObject != null) {
        if (((j)localObject).s == 1)
        {
          bool1 = true;
          bool2 = ((j)localObject).T;
          bool3 = bool1;
          bool1 = bool2;
        }
      }
    }
    for (;;)
    {
      paramMenu.setGroupVisible(1, bool3);
      localObject = paramMenu.findItem(7);
      if (this.J != null)
      {
        bool2 = true;
        label89:
        ((MenuItem)localObject).setVisible(bool2);
        localObject = paramMenu.findItem(9);
        if (this.J == null) {
          break label269;
        }
        bool2 = true;
        label117:
        ((MenuItem)localObject).setVisible(bool2);
        localObject = paramMenu.findItem(10);
        if (this.J == null) {
          break label274;
        }
        bool2 = true;
        label145:
        ((MenuItem)localObject).setVisible(bool2);
        localObject = paramMenu.findItem(8);
        if ((this.J == null) || (this.I)) {
          break label279;
        }
        bool2 = true;
        label180:
        ((MenuItem)localObject).setVisible(bool2);
        localObject = paramMenu.findItem(11);
        if ((this.J == null) || (bool1)) {
          break label284;
        }
      }
      label269:
      label274:
      label279:
      label284:
      for (bool2 = true;; bool2 = false)
      {
        ((MenuItem)localObject).setVisible(bool2);
        paramMenu = paramMenu.findItem(12);
        bool2 = bool4;
        if (this.J != null)
        {
          bool2 = bool4;
          if (bool1) {
            bool2 = true;
          }
        }
        paramMenu.setVisible(bool2);
        return true;
        bool1 = false;
        break;
        bool2 = false;
        break label89;
        bool2 = false;
        break label117;
        bool2 = false;
        break label145;
        bool2 = false;
        break label180;
      }
      bool1 = false;
      bool3 = false;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    a(true, true);
    if (this.z != null)
    {
      this.z.m();
      this.z.p();
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.U != null) {
      paramBundle.putString("gid", this.U);
    }
    paramBundle.putBoolean("is_different_video", this.T);
  }
  
  protected void onStart()
  {
    super.onStart();
    Log.i("mediaview/start");
    if ((F) && (this.z != null))
    {
      this.z.m();
      this.z.p();
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    a(true, true);
    Log.i("mediaview/stop");
    if ((F) && (this.z != null))
    {
      this.z.d();
      this.z.o();
    }
  }
  
  final class a
    implements View.OnClickListener
  {
    private VoiceNoteSeekBar b;
    private ImageButton c;
    
    a(VoiceNoteSeekBar paramVoiceNoteSeekBar, ImageButton paramImageButton)
    {
      this.b = paramVoiceNoteSeekBar;
      this.c = paramImageButton;
    }
    
    public final void onClick(View paramView)
    {
      Log.i("mediaview/audioclick " + this.b.getProgress() + " | " + this.b.getMax() + " - " + MediaView.t(MediaView.this) + " | 5");
      if ((MediaView.t(MediaView.this) == 5) && (this.b.getProgress() > 0) && (this.b.getProgress() < this.b.getMax()))
      {
        MediaView.w(MediaView.this).b();
        yx.j();
      }
      for (;;)
      {
        try
        {
          MediaView.r(MediaView.this).b();
          MediaView.s(MediaView.this).sendEmptyMessage(0);
          this.c.setImageResource(2130840400);
          MediaView.f(MediaView.this, 4);
          return;
        }
        catch (IOException paramView)
        {
          Log.e(paramView);
          MediaView.this.b_(2131296813);
          return;
        }
        if (MediaView.t(MediaView.this) == 5) {
          if ((MediaView.r(MediaView.this).f() >= MediaView.r(MediaView.this).g()) && (this.b.getProgress() == this.b.getMax())) {
            this.b.setProgress(0);
          }
        }
        try
        {
          MediaView.r(MediaView.this).a(0);
          MediaView.w(MediaView.this).b();
          yx.j();
        }
        catch (IllegalStateException paramView)
        {
          try
          {
            MediaView.r(MediaView.this).b();
            MediaView.s(MediaView.this).removeMessages(0);
            MediaView.s(MediaView.this).sendEmptyMessage(0);
            this.c.setImageResource(2130840400);
            MediaView.f(MediaView.this, 4);
            return;
          }
          catch (IOException paramView)
          {
            Log.e(paramView);
            MediaView.this.b_(2131296813);
            return;
          }
          paramView = paramView;
          Log.e(paramView);
          MediaView.this.b_(2131296813);
          return;
          if (MediaView.t(MediaView.this) == 4)
          {
            MediaView.r(MediaView.this).d();
            this.c.setImageDrawable(new az(MediaView.this.getResources().getDrawable(2130840401)));
            MediaView.f(MediaView.this, 5);
            return;
          }
          MediaView.c(MediaView.this, MediaView.a(MediaView.this, MediaView.e(MediaView.this)));
          if (MediaView.r(MediaView.this) == null) {
            continue;
          }
          MediaView.w(MediaView.this).b();
          yx.j();
          try
          {
            MediaView.r(MediaView.this).b();
            this.c.setImageResource(2130840400);
            MediaView.s(MediaView.this).sendEmptyMessage(0);
            MediaView.f(MediaView.this, 4);
            return;
          }
          catch (IOException paramView)
          {
            Log.e(paramView);
            MediaView.this.b_(2131296813);
            return;
          }
        }
        catch (IOException paramView)
        {
          for (;;) {}
        }
      }
    }
  }
  
  final class b
    implements SeekBar.OnSeekBarChangeListener
  {
    private b() {}
    
    public final void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {}
    
    public final void onStartTrackingTouch(SeekBar paramSeekBar)
    {
      if ((MediaView.r(MediaView.this) != null) && (MediaView.r(MediaView.this).e())) {
        MediaView.r(MediaView.this).d();
      }
      MediaView.s(MediaView.this).removeMessages(0);
    }
    
    public final void onStopTrackingTouch(SeekBar paramSeekBar)
    {
      if (MediaView.r(MediaView.this) != null)
      {
        if (MediaView.t(MediaView.this) == 4) {
          try
          {
            MediaView.r(MediaView.this).a((int)(MediaView.r(MediaView.this).g() * (MediaView.u(MediaView.this).getProgress() / MediaView.u(MediaView.this).getMax())));
            MediaView.r(MediaView.this).b();
            MediaView.s(MediaView.this).sendEmptyMessage(0);
            MediaView.v(MediaView.this).setImageResource(2130840400);
            return;
          }
          catch (IOException paramSeekBar)
          {
            Log.e(paramSeekBar);
            MediaView.this.b_(2131296813);
            return;
          }
        }
        MediaView.e(MediaView.this, (int)(MediaView.r(MediaView.this).g() * (MediaView.u(MediaView.this).getProgress() / MediaView.u(MediaView.this).getMax())));
        return;
      }
      MediaView.u(MediaView.this).setProgress(0);
    }
  }
  
  final class c
    extends AsyncTask<Void, Void, Integer>
  {
    private vj b;
    private vj c;
    private final j d;
    
    c(j paramj)
    {
      this.d = paramj;
    }
  }
  
  final class d
  {
    vj a;
    vj b;
    final j c;
    int d;
    int e;
    final SparseArray<j> f = new SparseArray();
    
    d(j paramj)
    {
      this.c = paramj;
      this.f.put(0, paramj);
    }
    
    final void a()
    {
      if (this.a != null)
      {
        this.a.close();
        this.a = null;
      }
      if (this.b != null)
      {
        this.b.close();
        this.b = null;
      }
      this.f.clear();
    }
    
    final int b()
    {
      int j = this.d;
      if (this.c != null) {}
      for (int i = 1;; i = 0) {
        return i + j + this.e;
      }
    }
  }
  
  final class e
    extends w
  {
    private j b;
    
    e(j paramj)
    {
      this.b = paramj;
    }
    
    public final int a(Object paramObject)
    {
      if (paramObject == null) {
        return -2;
      }
      paramObject = (j.b)((View)paramObject).getTag();
      MediaView.d locald = MediaView.d(MediaView.this);
      int i = 0;
      while (i < locald.f.size())
      {
        int j = locald.f.keyAt(i);
        if (((j.b)paramObject).equals(((j)locald.f.get(j)).e))
        {
          Log.d("mediaview/adapter/getItemPosition/ " + ((j.b)paramObject).c + " " + (locald.d + j));
          return locald.d + j;
        }
        i += 1;
      }
      Log.d("mediaview/adapter/getItemPosition/ " + ((j.b)paramObject).c + " none");
      return -2;
    }
    
    public final Object a(ViewGroup paramViewGroup, int paramInt)
    {
      j localj = MediaView.a(MediaView.this, paramInt);
      if (localj == null)
      {
        Log.d("mediaview/adapter/instantiateItem/no message " + paramInt);
        return null;
      }
      Log.d("mediaview/instantiateItem/ position:" + paramInt + " message:" + localj.e.c);
      View localView = MediaView.d(MediaView.this, localj);
      if (MediaView.r()) {
        MediaView.a(MediaView.this, localView);
      }
      localView.setTag(localj.e);
      paramViewGroup.addView(localView, 0);
      return localView;
    }
    
    public final void a(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      paramViewGroup.removeView((View)paramObject);
      paramViewGroup = MediaView.a(MediaView.this, paramInt);
      if ((paramViewGroup != null) && (paramViewGroup.s == 13))
      {
        paramViewGroup = (com.whatsapp.videoplayback.o)MediaView.B(MediaView.this).remove(paramViewGroup.e);
        if (paramViewGroup != null) {
          paramViewGroup.d();
        }
      }
      do
      {
        do
        {
          return;
        } while ((!MediaView.s()) || (paramViewGroup == null));
        paramViewGroup = (p)MediaView.C(MediaView.this).remove(paramViewGroup.e);
      } while (paramViewGroup == null);
      paramViewGroup.d();
      paramViewGroup.n();
    }
    
    public final boolean a(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
    
    public final int b()
    {
      return MediaView.d(MediaView.this).b();
    }
    
    public final void b(ViewGroup paramViewGroup)
    {
      if (this.b != null)
      {
        MediaView.e(MediaView.this, this.b);
        this.b = null;
      }
    }
    
    public final CharSequence c(int paramInt)
    {
      return "";
    }
  }
  
  final class f
    extends PhotoViewPager
  {
    public f(Context paramContext)
    {
      super(null);
      setOnPageChangeListener(new ViewPager.f()
      {
        public final void a(int paramAnonymousInt) {}
        
        public final void a(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
        
        public final void b(int paramAnonymousInt)
        {
          MediaView.d(MediaView.this, paramAnonymousInt);
        }
      });
      setOnInterceptTouchListener(new yo(this));
    }
  }
  
  final class g
    implements Runnable
  {
    final Stack<a> a = new Stack();
    final Thread b = new Thread(this, "PhotoLoader");
    boolean c;
    
    private g() {}
    
    final void a()
    {
      this.c = true;
      this.b.interrupt();
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 47	com/whatsapp/MediaView$g:c	Z
      //   4: ifne +307 -> 311
      //   7: aload_0
      //   8: getfield 32	com/whatsapp/MediaView$g:a	Ljava/util/Stack;
      //   11: invokevirtual 61	java/util/Stack:size	()I
      //   14: ifne +22 -> 36
      //   17: aload_0
      //   18: getfield 32	com/whatsapp/MediaView$g:a	Ljava/util/Stack;
      //   21: astore 4
      //   23: aload 4
      //   25: monitorenter
      //   26: aload_0
      //   27: getfield 32	com/whatsapp/MediaView$g:a	Ljava/util/Stack;
      //   30: invokevirtual 64	java/lang/Object:wait	()V
      //   33: aload 4
      //   35: monitorexit
      //   36: aload_0
      //   37: getfield 47	com/whatsapp/MediaView$g:c	Z
      //   40: ifne +271 -> 311
      //   43: aload_0
      //   44: getfield 32	com/whatsapp/MediaView$g:a	Ljava/util/Stack;
      //   47: invokevirtual 61	java/util/Stack:size	()I
      //   50: ifeq -50 -> 0
      //   53: aload_0
      //   54: getfield 32	com/whatsapp/MediaView$g:a	Ljava/util/Stack;
      //   57: astore 4
      //   59: aload 4
      //   61: monitorenter
      //   62: aload_0
      //   63: getfield 32	com/whatsapp/MediaView$g:a	Ljava/util/Stack;
      //   66: invokevirtual 68	java/util/Stack:pop	()Ljava/lang/Object;
      //   69: checkcast 11	com/whatsapp/MediaView$g$a
      //   72: astore 7
      //   74: aload 4
      //   76: monitorexit
      //   77: aconst_null
      //   78: astore 5
      //   80: aconst_null
      //   81: astore 6
      //   83: aconst_null
      //   84: astore 4
      //   86: aload 7
      //   88: getfield 71	com/whatsapp/MediaView$g$a:a	Lcom/whatsapp/protocol/j;
      //   91: invokevirtual 76	com/whatsapp/protocol/j:b	()Lcom/whatsapp/MediaData;
      //   94: astore 8
      //   96: aload 8
      //   98: getfield 82	com/whatsapp/MediaData:file	Ljava/io/File;
      //   101: ifnull -101 -> 0
      //   104: aload 7
      //   106: getfield 71	com/whatsapp/MediaView$g$a:a	Lcom/whatsapp/protocol/j;
      //   109: getfield 86	com/whatsapp/protocol/j:s	B
      //   112: iconst_1
      //   113: if_icmpne +320 -> 433
      //   116: new 88	android/graphics/BitmapFactory$Options
      //   119: dup
      //   120: invokespecial 89	android/graphics/BitmapFactory$Options:<init>	()V
      //   123: astore 6
      //   125: aload 6
      //   127: iconst_1
      //   128: putfield 92	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
      //   131: aload 8
      //   133: getfield 82	com/whatsapp/MediaData:file	Ljava/io/File;
      //   136: invokevirtual 98	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   139: aload 6
      //   141: invokestatic 104	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
      //   144: pop
      //   145: aload 6
      //   147: iconst_0
      //   148: putfield 92	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
      //   151: aload 6
      //   153: iconst_1
      //   154: putfield 107	android/graphics/BitmapFactory$Options:inPurgeable	Z
      //   157: aload 6
      //   159: iconst_1
      //   160: putfield 110	android/graphics/BitmapFactory$Options:inInputShareable	Z
      //   163: aload 7
      //   165: getfield 113	com/whatsapp/MediaView$g$a:b	Lcom/whatsapp/PhotoView;
      //   168: invokevirtual 118	com/whatsapp/PhotoView:getWidth	()I
      //   171: istore_2
      //   172: aload 7
      //   174: getfield 113	com/whatsapp/MediaView$g$a:b	Lcom/whatsapp/PhotoView;
      //   177: invokevirtual 121	com/whatsapp/PhotoView:getHeight	()I
      //   180: istore_3
      //   181: iload_2
      //   182: ifeq +9 -> 191
      //   185: iload_3
      //   186: istore_1
      //   187: iload_3
      //   188: ifne +57 -> 245
      //   191: invokestatic 126	com/whatsapp/u:a	()Landroid/content/Context;
      //   194: ldc -128
      //   196: invokevirtual 134	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
      //   199: checkcast 136	android/view/WindowManager
      //   202: invokeinterface 140 1 0
      //   207: astore 4
      //   209: getstatic 146	android/os/Build$VERSION:SDK_INT	I
      //   212: bipush 13
      //   214: if_icmplt +113 -> 327
      //   217: new 148	android/graphics/Point
      //   220: dup
      //   221: invokespecial 149	android/graphics/Point:<init>	()V
      //   224: astore 9
      //   226: aload 4
      //   228: aload 9
      //   230: invokevirtual 155	android/view/Display:getSize	(Landroid/graphics/Point;)V
      //   233: aload 9
      //   235: getfield 158	android/graphics/Point:x	I
      //   238: istore_2
      //   239: aload 9
      //   241: getfield 161	android/graphics/Point:y	I
      //   244: istore_1
      //   245: aload 6
      //   247: iconst_1
      //   248: putfield 164	android/graphics/BitmapFactory$Options:inSampleSize	I
      //   251: iload_2
      //   252: ifle +90 -> 342
      //   255: iload_1
      //   256: ifle +86 -> 342
      //   259: aload 6
      //   261: getfield 167	android/graphics/BitmapFactory$Options:outWidth	I
      //   264: aload 6
      //   266: getfield 170	android/graphics/BitmapFactory$Options:outHeight	I
      //   269: imul
      //   270: iload_2
      //   271: iload_1
      //   272: imul
      //   273: iconst_2
      //   274: ishl
      //   275: if_icmple +67 -> 342
      //   278: aload 6
      //   280: aload 6
      //   282: getfield 164	android/graphics/BitmapFactory$Options:inSampleSize	I
      //   285: iconst_1
      //   286: ishl
      //   287: putfield 164	android/graphics/BitmapFactory$Options:inSampleSize	I
      //   290: iload_2
      //   291: iconst_1
      //   292: ishl
      //   293: istore_2
      //   294: iload_1
      //   295: iconst_1
      //   296: ishl
      //   297: istore_1
      //   298: goto -39 -> 259
      //   301: astore 5
      //   303: aload 4
      //   305: monitorexit
      //   306: aload 5
      //   308: athrow
      //   309: astore 4
      //   311: aload_0
      //   312: getfield 32	com/whatsapp/MediaView$g:a	Ljava/util/Stack;
      //   315: invokevirtual 173	java/util/Stack:clear	()V
      //   318: return
      //   319: astore 5
      //   321: aload 4
      //   323: monitorexit
      //   324: aload 5
      //   326: athrow
      //   327: aload 4
      //   329: invokevirtual 174	android/view/Display:getWidth	()I
      //   332: istore_2
      //   333: aload 4
      //   335: invokevirtual 175	android/view/Display:getHeight	()I
      //   338: istore_1
      //   339: goto -94 -> 245
      //   342: aload 5
      //   344: astore 4
      //   346: aload 8
      //   348: getfield 82	com/whatsapp/MediaData:file	Ljava/io/File;
      //   351: invokestatic 180	a/a/a/a/d:b	(Ljava/io/File;)[B
      //   354: astore 9
      //   356: aload 5
      //   358: astore 4
      //   360: aload 9
      //   362: iconst_0
      //   363: aload 9
      //   365: arraylength
      //   366: aload 6
      //   368: invokestatic 184	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
      //   371: astore 5
      //   373: aload 5
      //   375: astore 4
      //   377: aload 8
      //   379: getfield 82	com/whatsapp/MediaData:file	Ljava/io/File;
      //   382: invokevirtual 98	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   385: invokestatic 189	com/whatsapp/util/MediaFileUtils:c	(Ljava/lang/String;)I
      //   388: istore_1
      //   389: aload 5
      //   391: astore 4
      //   393: aload 4
      //   395: ifnull -395 -> 0
      //   398: aload_0
      //   399: getfield 24	com/whatsapp/MediaView$g:d	Lcom/whatsapp/MediaView;
      //   402: new 191	com/whatsapp/yp
      //   405: dup
      //   406: aload_0
      //   407: iload_1
      //   408: aload 7
      //   410: aload 4
      //   412: invokespecial 194	com/whatsapp/yp:<init>	(Lcom/whatsapp/MediaView$g;ILcom/whatsapp/MediaView$g$a;Landroid/graphics/Bitmap;)V
      //   415: invokevirtual 198	com/whatsapp/MediaView:runOnUiThread	(Ljava/lang/Runnable;)V
      //   418: goto -418 -> 0
      //   421: astore 5
      //   423: aload 5
      //   425: invokestatic 204	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
      //   428: iconst_1
      //   429: istore_1
      //   430: goto -37 -> 393
      //   433: aload 7
      //   435: getfield 71	com/whatsapp/MediaView$g$a:a	Lcom/whatsapp/protocol/j;
      //   438: getfield 86	com/whatsapp/protocol/j:s	B
      //   441: istore_1
      //   442: iload_1
      //   443: iconst_3
      //   444: if_icmpne +58 -> 502
      //   447: aload 6
      //   449: astore 4
      //   451: aload 8
      //   453: getfield 82	com/whatsapp/MediaData:file	Ljava/io/File;
      //   456: invokevirtual 98	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   459: invokestatic 207	com/whatsapp/util/MediaFileUtils:g	(Ljava/lang/String;)Landroid/graphics/Bitmap;
      //   462: astore 5
      //   464: aload 5
      //   466: ifnonnull +12 -> 478
      //   469: aload 5
      //   471: astore 4
      //   473: ldc -47
      //   475: invokestatic 213	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
      //   478: iconst_1
      //   479: istore_1
      //   480: aload 5
      //   482: astore 4
      //   484: goto -91 -> 393
      //   487: astore 5
      //   489: aload 5
      //   491: invokestatic 204	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
      //   494: iconst_1
      //   495: istore_1
      //   496: invokestatic 216	com/whatsapp/MediaView:p	()V
      //   499: goto -106 -> 393
      //   502: iconst_1
      //   503: istore_1
      //   504: goto -111 -> 393
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	507	0	this	g
      //   186	318	1	i	int
      //   171	162	2	j	int
      //   180	8	3	k	int
      //   309	25	4	localInterruptedException	InterruptedException
      //   344	139	4	localObject2	Object
      //   78	1	5	localObject3	Object
      //   301	6	5	localObject4	Object
      //   319	38	5	localObject5	Object
      //   371	19	5	localBitmap1	Bitmap
      //   421	3	5	localIOException	IOException
      //   462	19	5	localBitmap2	Bitmap
      //   487	3	5	localOutOfMemoryError	OutOfMemoryError
      //   81	367	6	localOptions	android.graphics.BitmapFactory.Options
      //   72	362	7	locala	a
      //   94	358	8	localMediaData	MediaData
      //   224	140	9	localObject6	Object
      // Exception table:
      //   from	to	target	type
      //   26	36	301	finally
      //   303	306	301	finally
      //   0	26	309	java/lang/InterruptedException
      //   36	62	309	java/lang/InterruptedException
      //   86	181	309	java/lang/InterruptedException
      //   191	245	309	java/lang/InterruptedException
      //   245	251	309	java/lang/InterruptedException
      //   259	290	309	java/lang/InterruptedException
      //   306	309	309	java/lang/InterruptedException
      //   324	327	309	java/lang/InterruptedException
      //   327	339	309	java/lang/InterruptedException
      //   346	356	309	java/lang/InterruptedException
      //   360	373	309	java/lang/InterruptedException
      //   377	389	309	java/lang/InterruptedException
      //   398	418	309	java/lang/InterruptedException
      //   423	428	309	java/lang/InterruptedException
      //   433	442	309	java/lang/InterruptedException
      //   451	464	309	java/lang/InterruptedException
      //   473	478	309	java/lang/InterruptedException
      //   489	494	309	java/lang/InterruptedException
      //   496	499	309	java/lang/InterruptedException
      //   62	77	319	finally
      //   321	324	319	finally
      //   346	356	421	java/io/IOException
      //   360	373	421	java/io/IOException
      //   377	389	421	java/io/IOException
      //   451	464	487	java/lang/OutOfMemoryError
      //   473	478	487	java/lang/OutOfMemoryError
    }
    
    final class a
    {
      j a;
      PhotoView b;
      
      a(j paramj, PhotoView paramPhotoView)
      {
        this.a = paramj;
        this.b = paramPhotoView;
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/MediaView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */