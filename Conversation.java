package com.whatsapp;

import a.a.a.a.a.a.d;
import a.a.a.a.a.a.e;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.KeyguardManager;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.DataSetObserver;
import android.database.StaleDataException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.ContactsContract.Contacts;
import android.support.v4.view.o;
import android.support.v7.widget.Toolbar;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.format.DateUtils;
import android.text.method.TextKeyListener;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SubMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewOutlineProvider;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.CheckBox;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.whatsapp.camera.CameraActivity;
import com.whatsapp.contact.ContactProvider;
import com.whatsapp.data.ab;
import com.whatsapp.data.ad;
import com.whatsapp.data.ad.b;
import com.whatsapp.data.ad.d;
import com.whatsapp.data.ad.e;
import com.whatsapp.data.ad.o;
import com.whatsapp.data.ch;
import com.whatsapp.data.cm;
import com.whatsapp.data.cq;
import com.whatsapp.data.cr;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.emoji.h;
import com.whatsapp.emoji.search.EmojiSearchContainer;
import com.whatsapp.emoji.search.i.a;
import com.whatsapp.emoji.search.i.c;
import com.whatsapp.f.a.a;
import com.whatsapp.fieldstats.events.q;
import com.whatsapp.gallerypicker.MediaPreviewActivity;
import com.whatsapp.gif_search.GifSearchContainer;
import com.whatsapp.gif_search.f.a;
import com.whatsapp.gif_search.j.a;
import com.whatsapp.k.d.a;
import com.whatsapp.k.d.e;
import com.whatsapp.location.LocationPicker;
import com.whatsapp.location.LocationPicker2;
import com.whatsapp.location.bp;
import com.whatsapp.location.bp.c;
import com.whatsapp.location.bp.d;
import com.whatsapp.messaging.aj;
import com.whatsapp.notification.AndroidWear;
import com.whatsapp.notification.k;
import com.whatsapp.protocol.ap;
import com.whatsapp.protocol.j.b;
import com.whatsapp.registration.x;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils;
import com.whatsapp.util.WhatsAppLibLoader;
import com.whatsapp.util.aa;
import com.whatsapp.util.ag;
import com.whatsapp.util.az;
import com.whatsapp.util.ba;
import com.whatsapp.util.be;
import com.whatsapp.util.bm;
import com.whatsapp.util.bu;
import com.whatsapp.wallpaper.WallPaperView;
import com.whatsapp.wallpaper.WallPaperView.a;
import com.whatsapp.wallpaper.g;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

public class Conversation
  extends jw
  implements agm.a, i.a, i.c, f.a, jz
{
  private static final String[] aU = { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" };
  private static boolean aV;
  private static final HashMap<String, Long> aX;
  private static boolean bu;
  private static final aoa bv = aoa.a();
  private static AtomicReference<l> cd = new AtomicReference(new l(null, false));
  public static final String n = au.b() + ".intent.action.PLAY";
  public static final ArrayList<String> o;
  public static final HashMap<String, String> p;
  public static final HashMap<String, String> q;
  public static boolean s;
  static boolean u;
  public static boolean v;
  public static boolean w;
  boolean A;
  long B = 1L;
  View C;
  public com.whatsapp.k.d D;
  public boolean E;
  public boolean F = true;
  com.whatsapp.gif_search.a G;
  ac H;
  boolean I;
  boolean J;
  ConversationContentLayout K;
  com.whatsapp.protocol.j L;
  j.b M;
  public aqs N;
  public boolean O = true;
  final Runnable P = new Runnable()
  {
    public final void run()
    {
      Conversation.c(Conversation.this).a();
      Conversation.c(Conversation.this).requestLayout();
    }
  };
  final ad Q = ad.a();
  final aq R = aq.a();
  final ame S = ame.a();
  final bp T = bp.a();
  ListView U;
  d V;
  public cs W;
  final TextView.OnEditorActionListener X = new TextView.OnEditorActionListener()
  {
    private boolean b;
    
    public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
    {
      if (paramAnonymousKeyEvent != null) {
        Log.d("conversation/editor/enter :" + paramAnonymousKeyEvent.getKeyCode());
      }
      if (paramAnonymousInt == 4)
      {
        Conversation.q(Conversation.this);
        return true;
      }
      if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getKeyCode() == 66))
      {
        if (this.b)
        {
          this.b = false;
          return true;
        }
        if (Conversation.v) {
          Conversation.q(Conversation.this);
        }
        for (;;)
        {
          this.b = true;
          return true;
          paramAnonymousInt = Conversation.g(Conversation.this).getSelectionStart();
          int i = Conversation.g(Conversation.this).getSelectionEnd();
          if (paramAnonymousInt != Conversation.g(Conversation.this).length()) {
            Conversation.g(Conversation.this).getText().replace(Math.min(paramAnonymousInt, i), Math.max(paramAnonymousInt, i), "\n", 0, 1);
          } else {
            Conversation.g(Conversation.this).append("\n");
          }
        }
      }
      return false;
    }
  };
  EmojiPicker.c Y = new EmojiPicker.c()
  {
    public final void a()
    {
      Conversation.g(Conversation.this).dispatchKeyEvent(new KeyEvent(0, 67));
    }
    
    public final void a(int paramAnonymousInt)
    {
      if (Conversation.aN(Conversation.this)) {
        return;
      }
      int i = Conversation.g(Conversation.this).getSelectionStart();
      int j = Conversation.g(Conversation.this).getSelectionEnd();
      int k;
      if (i > j)
      {
        k = j;
        j = i;
      }
      for (;;)
      {
        Conversation.g(Conversation.this).getText().replace(k, j, com.whatsapp.emoji.c.b(paramAnonymousInt));
        Conversation.g(Conversation.this).setSelection(k + com.whatsapp.emoji.c.a(paramAnonymousInt));
        return;
        k = i;
      }
    }
  };
  private final InputMethodManager aW = (InputMethodManager)u.a().getSystemService("input_method");
  private boolean aY;
  private int aZ;
  private View bA;
  private int bB = 0;
  private View bC;
  private TextView bD;
  private View bE;
  private View bF;
  private View bG;
  private TextView bH;
  private ViewGroup bI;
  private View bJ;
  private int bK;
  private auf bL;
  private String bM;
  private String bN;
  private View bO;
  private ViewGroup bP;
  private com.whatsapp.gif_search.f bQ;
  private View bR;
  private WallPaperView bS;
  private e bT;
  private EditText bU;
  private k bV;
  private String bW;
  private ArrayList<String> bX;
  private String bY;
  private j.b bZ;
  private final HashSet<j.b> ba = new HashSet();
  private boolean bb;
  private boolean bc;
  private boolean bd = true;
  private boolean be;
  private int bf;
  private int bg;
  private int bh;
  private int bi = 0;
  private android.support.v7.view.b bj;
  private android.support.v7.view.b.a bk;
  private long bl = 1L;
  private int bm;
  private TextView bn;
  private Boolean bo;
  private boolean bp;
  private boolean bq;
  private com.whatsapp.f.a br;
  private final long bs = SystemClock.elapsedRealtime();
  private Handler bt;
  private ViewGroup bw;
  private View bx;
  private View by;
  private View bz;
  private final el cA = el.a();
  private final aj cB = aj.a();
  private final abu cC = abu.a();
  private final com.whatsapp.util.b cD = com.whatsapp.util.b.a();
  private final com.whatsapp.data.l cE = com.whatsapp.data.l.a();
  private final qz cF = qz.a();
  private final ba cG = ba.a();
  private final g cH = g.a();
  private final cc cI = cc.a();
  private final ag cJ = ag.a();
  private final com.whatsapp.notification.m cK = com.whatsapp.notification.m.a();
  private final cr cL = cr.a();
  private final com.whatsapp.notification.f cM = com.whatsapp.notification.f.a();
  private final cq cN = cq.a();
  private final k cO = k.a();
  private final ka cP = ka.a();
  private final rh cQ = rh.a();
  private final com.whatsapp.registration.bb cR = com.whatsapp.registration.bb.a();
  private FrameLayout cS;
  private BroadcastReceiver cT;
  private MentionableEntry cU;
  private View cV;
  private ImageButton cW;
  private ImageButton cX;
  private ImageButton cY;
  private ImageButton cZ;
  private ViewStub ca;
  private ProgressBar cb;
  private a.a.a.a.a.a cc;
  private int ce;
  private boolean cf = true;
  private int cg;
  private int ch;
  private Handler ci = new Handler(Looper.getMainLooper())
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage.what == 1) {
        Conversation.a(Conversation.this);
      }
      Conversation.b(Conversation.this).setTranscriptMode(0);
    }
  };
  private final vv.a cj = new vv.a()
  {
    public final void a()
    {
      a.a.a.a.d.a(Conversation.this, 15);
    }
    
    public final void b()
    {
      a.a.a.a.d.a(Conversation.this, 15);
    }
    
    public final void c()
    {
      Conversation.this.a(2131296307, 2131297418, new Object[0]);
    }
    
    public final void d()
    {
      Conversation.this.a(2131296307, 2131297418, new Object[0]);
    }
  };
  private boolean ck;
  private final dh cl = dh.a();
  private final dh.a cm = new dh.a()
  {
    public final void a()
    {
      if (!Conversation.this.isFinishing())
      {
        Conversation.d(Conversation.this);
        Conversation.e(Conversation.this).notifyDataSetChanged();
        Conversation.f(Conversation.this);
        if (Conversation.g(Conversation.this) != null)
        {
          MentionableEntry localMentionableEntry = Conversation.g(Conversation.this);
          if (localMentionableEntry.c != null) {
            localMentionableEntry.c.a();
          }
        }
      }
    }
    
    protected final void a(String paramAnonymousString)
    {
      Log.d("conversation/onDisplayNameChanged " + paramAnonymousString);
      if (paramAnonymousString.equals(Conversation.h(Conversation.this))) {
        Conversation.f(Conversation.this);
      }
    }
    
    public final void a(Collection<String> paramAnonymousCollection)
    {
      if ((Conversation.l(Conversation.this) != null) || (Conversation.m(Conversation.this) != null))
      {
        paramAnonymousCollection = paramAnonymousCollection.iterator();
        while (paramAnonymousCollection.hasNext()) {
          if (((String)paramAnonymousCollection.next()).equals(Conversation.h(Conversation.this))) {
            Conversation.n(Conversation.this);
          }
        }
      }
    }
    
    public final void b(String paramAnonymousString)
    {
      Log.d("conversation/onProfilePhotoChanged " + paramAnonymousString);
      if (paramAnonymousString.equals(Conversation.h(Conversation.this)))
      {
        Conversation.i(Conversation.this).setVisibility(8);
        Conversation.j(Conversation.this).setVisibility(0);
        Conversation.f(Conversation.this);
      }
      Conversation.b(Conversation.this).post(hs.a(this, paramAnonymousString));
    }
    
    public final void c(String paramAnonymousString)
    {
      if (paramAnonymousString.equals(Conversation.h(Conversation.this))) {
        Conversation.f(Conversation.this);
      }
    }
    
    public final void d(String paramAnonymousString)
    {
      if (paramAnonymousString.equals(Conversation.h(Conversation.this))) {
        Conversation.k(Conversation.this);
      }
    }
  };
  private final bb cn = bb.a();
  private final bb.a co = new bb.a()
  {
    public final void a(long paramAnonymousLong)
    {
      if (Conversation.o(Conversation.this).getVisibility() != 0) {
        Conversation.o(Conversation.this).setVisibility(0);
      }
      Conversation.p(Conversation.this).setText(DateUtils.formatElapsedTime(paramAnonymousLong / 1000L));
    }
    
    public final void a(com.whatsapp.protocol.j paramAnonymousj) {}
    
    public final void b(com.whatsapp.protocol.j paramAnonymousj)
    {
      Conversation.o(Conversation.this).setVisibility(8);
    }
  };
  private final bp.d cp = new bp.d()
  {
    public final void a(ap paramAnonymousap) {}
    
    public final void a(String paramAnonymousString)
    {
      Conversation.a(Conversation.this, paramAnonymousString);
    }
    
    public final void a(String paramAnonymousString1, String paramAnonymousString2)
    {
      Conversation.a(Conversation.this, paramAnonymousString1);
    }
  };
  private final bp.c cq = new bp.c()
  {
    public final void a(String paramAnonymousString)
    {
      Conversation.a(Conversation.this, paramAnonymousString);
    }
    
    public final void b(String paramAnonymousString)
    {
      Conversation.a(Conversation.this, paramAnonymousString);
    }
  };
  private final boolean cr = br.b();
  private final va cs = va.a();
  private final com.whatsapp.data.d ct = com.whatsapp.data.d.a();
  private final cm cu = cm.a();
  private final aoj cv = aoj.a();
  private final x cw = x.a();
  private final vp cx = vp.a();
  private final h cy = h.a();
  private final com.whatsapp.location.cc cz = com.whatsapp.location.cc.a();
  private boolean dA;
  private f dB;
  private ImageButton da;
  private ViewGroup db;
  private TextEmojiLabel dc;
  private View dd;
  private TextView de;
  private TextView df;
  private ImageView dg;
  private String dh;
  private final Handler di = new Handler(Looper.getMainLooper());
  private final Runnable dj = new Runnable()
  {
    public final void run()
    {
      if ((Conversation.r(Conversation.this) != null) && (Conversation.r(Conversation.this).getVisibility() != 8))
      {
        Conversation.r(Conversation.this).setVisibility(8);
        TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -1.0F);
        localTranslateAnimation.setDuration(200L);
        Conversation.r(Conversation.this).startAnimation(localTranslateAnimation);
      }
    }
  };
  private final AbsListView.OnScrollListener dk = new AbsListView.OnScrollListener()
  {
    private int b;
    
    @SuppressLint({"NewApi"})
    public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      Conversation.a(Conversation.this, paramAnonymousInt1);
      Conversation.a(Conversation.this, false);
      AlphaAnimation localAlphaAnimation;
      AnimationSet localAnimationSet;
      if (paramAnonymousInt1 + paramAnonymousInt2 >= Conversation.e(Conversation.this).getCount() + Conversation.b(Conversation.this).getHeaderViewsCount())
      {
        Conversation.a(Conversation.this, true);
        if (Conversation.s(Conversation.this) != null)
        {
          if (paramAnonymousInt1 + paramAnonymousInt2 < Conversation.e(Conversation.this).getCount() + Conversation.b(Conversation.this).getHeaderViewsCount() - 2) {
            break label486;
          }
          if (Conversation.s(Conversation.this).getVisibility() == 0)
          {
            paramAnonymousAbsListView = new ScaleAnimation(1.0F, 0.5F, 1.0F, 0.5F, 1, 0.5F, 1, 0.5F);
            localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
            localAnimationSet = new AnimationSet(true);
            localAnimationSet.addAnimation(paramAnonymousAbsListView);
            localAnimationSet.addAnimation(localAlphaAnimation);
            localAnimationSet.setDuration(100L);
            Conversation.s(Conversation.this).startAnimation(localAnimationSet);
            Conversation.s(Conversation.this).setVisibility(8);
          }
          Conversation.t(Conversation.this);
          Conversation.u(Conversation.this).setVisibility(8);
        }
        label212:
        if ((Conversation.v(Conversation.this) != 0) && (this.b != paramAnonymousInt1) && (paramAnonymousInt2 != 0))
        {
          paramAnonymousInt2 = paramAnonymousInt1 - Conversation.b(Conversation.this).getHeaderViewsCount();
          if (paramAnonymousInt2 < 0) {
            break label604;
          }
          paramAnonymousAbsListView = Conversation.e(Conversation.this).a(paramAnonymousInt2);
          if ((paramAnonymousAbsListView == null) || (com.whatsapp.util.l.a(paramAnonymousAbsListView.n, System.currentTimeMillis()))) {
            break label589;
          }
          Conversation.r(Conversation.this).setText(com.whatsapp.util.l.e(Conversation.this, paramAnonymousAbsListView.n).toUpperCase());
          Conversation.r(Conversation.this).setTextSize(hy.a(Conversation.this.getResources()));
          if (Conversation.r(Conversation.this).getVisibility() != 0)
          {
            Conversation.r(Conversation.this).setVisibility(0);
            paramAnonymousAbsListView = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -1.0F, 1, 0.0F);
            paramAnonymousAbsListView.setDuration(200L);
            Conversation.r(Conversation.this).startAnimation(paramAnonymousAbsListView);
          }
        }
      }
      for (;;)
      {
        if ((this.b != paramAnonymousInt1) && (Conversation.v(Conversation.this) != 0)) {
          a.a.a.a.d.e(true);
        }
        this.b = paramAnonymousInt1;
        if (this.b < Math.min(100, Conversation.e(Conversation.this).getCount()) / 2) {
          Conversation.w(Conversation.this);
        }
        return;
        Conversation.a(Conversation.this, false);
        if ((Build.VERSION.SDK_INT >= 18) && (Conversation.b(Conversation.this).isInLayout())) {
          break;
        }
        Conversation.b(Conversation.this).setTranscriptMode(0);
        break;
        label486:
        if (Conversation.s(Conversation.this).getVisibility() != 8) {
          break label212;
        }
        Conversation.s(Conversation.this).setVisibility(0);
        paramAnonymousAbsListView = new ScaleAnimation(0.5F, 1.0F, 0.5F, 1.0F, 1, 0.5F, 1, 0.5F);
        localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
        localAnimationSet = new AnimationSet(true);
        localAnimationSet.addAnimation(paramAnonymousAbsListView);
        localAnimationSet.addAnimation(localAlphaAnimation);
        localAnimationSet.setDuration(100L);
        Conversation.s(Conversation.this).startAnimation(localAnimationSet);
        break label212;
        label589:
        Conversation.r(Conversation.this).setVisibility(8);
        continue;
        label604:
        Conversation.r(Conversation.this).setVisibility(8);
      }
    }
    
    public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
    {
      if (paramAnonymousInt != 0)
      {
        Conversation.y(Conversation.this).removeCallbacks(Conversation.x(Conversation.this));
        Conversation.b(Conversation.this, paramAnonymousInt);
        if (paramAnonymousInt == 0) {
          break label65;
        }
      }
      label65:
      for (boolean bool = true;; bool = false)
      {
        a.a.a.a.d.e(bool);
        return;
        Conversation.y(Conversation.this).postDelayed(Conversation.x(Conversation.this), 1000L);
        break;
      }
    }
  };
  private final TextWatcher dl = new TextWatcher()
  {
    public final void afterTextChanged(Editable paramAnonymousEditable)
    {
      if (!Conversation.z(Conversation.this))
      {
        if (paramAnonymousEditable.toString().length() != 0) {
          Conversation.A(Conversation.this).a(Conversation.this.W.t, 0);
        }
      }
      else {
        return;
      }
      Conversation.B(Conversation.this);
      Conversation.A(Conversation.this).a(Conversation.this.W.t);
    }
    
    public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
  };
  private final TextWatcher dm = new TextWatcher()
  {
    public final void afterTextChanged(Editable paramAnonymousEditable)
    {
      String str = paramAnonymousEditable.toString();
      boolean bool;
      label156:
      Object localObject;
      if (!be.a(str))
      {
        bool = true;
        Conversation.C(Conversation.this).setEnabled(bool);
        if ((Conversation.D(Conversation.this).getVisibility() != 8) || (bool)) {
          break label286;
        }
        Conversation.D(Conversation.this).startAnimation(aqs.a(true));
        Conversation.D(Conversation.this).setVisibility(0);
        Conversation.E(Conversation.this).startAnimation(Conversation.a(Conversation.this.aq.d(), true, false));
        Conversation.F(Conversation.this).startAnimation(Conversation.a(Conversation.this.aq.d(), true, true));
        Conversation.F(Conversation.this).setVisibility(0);
        Conversation.C(Conversation.this).startAnimation(aqs.a(false));
        Conversation.C(Conversation.this).setVisibility(8);
        str = aa.c(str);
        localObject = Conversation.G(Conversation.this);
        Conversation.b(Conversation.this, str);
        if ((str == null) || (str.equals(Conversation.H(Conversation.this)))) {
          break label424;
        }
        Conversation.c(Conversation.this, null);
        if (!TextUtils.equals((CharSequence)localObject, str))
        {
          Conversation.this.a(aug.a(str));
          if (Conversation.I(Conversation.this) == null) {
            aug.a(Conversation.this.aq, str, new hl(this));
          }
        }
      }
      for (;;)
      {
        be.a(Conversation.this, Conversation.this.aE, paramAnonymousEditable, Conversation.g(Conversation.this).getPaint());
        return;
        bool = false;
        break;
        label286:
        if ((Conversation.D(Conversation.this).getVisibility() != 0) || (!bool)) {
          break label156;
        }
        Conversation.D(Conversation.this).startAnimation(aqs.a(false));
        Conversation.D(Conversation.this).setVisibility(8);
        Conversation.E(Conversation.this).startAnimation(Conversation.a(Conversation.this.aq.d(), false, false));
        localObject = Conversation.a(Conversation.this.aq.d(), false, true);
        ((Animation)localObject).setAnimationListener(new Animation.AnimationListener()
        {
          public final void onAnimationEnd(Animation paramAnonymous2Animation)
          {
            Conversation.F(Conversation.this).setVisibility(8);
          }
          
          public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
          
          public final void onAnimationStart(Animation paramAnonymous2Animation) {}
        });
        Conversation.F(Conversation.this).startAnimation((Animation)localObject);
        Conversation.C(Conversation.this).startAnimation(aqs.a(true));
        Conversation.C(Conversation.this).setVisibility(0);
        break label156;
        label424:
        Conversation.this.a(null);
      }
    }
    
    public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      al.a(Conversation.this.aq, Conversation.g(Conversation.this), paramAnonymousCharSequence);
    }
  };
  private final ViewTreeObserver.OnPreDrawListener dn = es.a(this);
  private final View.OnClickListener jdField_do = fd.a(this);
  private final DataSetObserver dp = new DataSetObserver()
  {
    public final void onChanged()
    {
      StringBuilder localStringBuilder;
      if (av.k())
      {
        localStringBuilder = new StringBuilder("conversation/adapterobserver/changed cursor=");
        if (Conversation.e(Conversation.this).getCursor() != null) {
          break label62;
        }
      }
      label62:
      for (Object localObject = "null";; localObject = Integer.valueOf(Conversation.e(Conversation.this).getCursor().getCount()))
      {
        Log.d(localObject + " appended=" + Conversation.W(Conversation.this).size());
        return;
      }
    }
    
    public final void onInvalidated()
    {
      Log.d("conversation/adapterobserver/invalidated");
      Conversation.b(Conversation.this, false);
    }
  };
  private boolean dq;
  private final com.whatsapp.data.ac dr = com.whatsapp.data.ac.a();
  private final ab ds = new ab()
  {
    public final void a(com.whatsapp.protocol.j paramAnonymousj, int paramAnonymousInt)
    {
      if ((paramAnonymousj != null) && (paramAnonymousj.e.a.equals(Conversation.h(Conversation.this))) && (paramAnonymousj.s != 8))
      {
        Conversation.a(Conversation.this, paramAnonymousj, paramAnonymousInt);
        if ((paramAnonymousInt == 3) && (paramAnonymousj.s == 1) && (Conversation.b(Conversation.this).getLastVisiblePosition() >= Conversation.b(Conversation.this).getCount() - 2) && (Conversation.b(Conversation.this).getChildCount() > 0) && (paramAnonymousj.equals(Conversation.b(Conversation.this).getChildAt(Conversation.b(Conversation.this).getChildCount() - 1).getTag()))) {
          Conversation.a(Conversation.this);
        }
      }
    }
    
    public final void a(String paramAnonymousString)
    {
      if ((paramAnonymousString != null) && (paramAnonymousString.equals(Conversation.h(Conversation.this))))
      {
        Conversation.d(Conversation.this);
        Conversation.ao(Conversation.this);
      }
    }
    
    public final void a(Collection<com.whatsapp.protocol.j> paramAnonymousCollection, String paramAnonymousString, Map<String, Integer> paramAnonymousMap, boolean paramAnonymousBoolean)
    {
      if ((paramAnonymousCollection != null) && (!paramAnonymousCollection.isEmpty()))
      {
        paramAnonymousCollection = paramAnonymousCollection.iterator();
        while (paramAnonymousCollection.hasNext())
        {
          paramAnonymousString = (com.whatsapp.protocol.j)paramAnonymousCollection.next();
          Conversation.an(Conversation.this).add(paramAnonymousString.e);
        }
        Conversation.ao(Conversation.this);
        return;
      }
      Conversation.d(Conversation.this);
    }
    
    public final void a(Collection<com.whatsapp.protocol.j> paramAnonymousCollection, Map<String, Integer> paramAnonymousMap)
    {
      paramAnonymousMap = paramAnonymousCollection.iterator();
      do
      {
        if (!paramAnonymousMap.hasNext()) {
          break;
        }
      } while (!((com.whatsapp.protocol.j)paramAnonymousMap.next()).e.a.equals(Conversation.h(Conversation.this)));
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          if (Conversation.Y(Conversation.this) > 0)
          {
            i = Conversation.d.a(Conversation.e(Conversation.this));
            if (Conversation.e(Conversation.this).getCount() > i + 1)
            {
              paramAnonymousMap = Conversation.e(Conversation.this).a(i + 1);
              paramAnonymousCollection = paramAnonymousCollection.iterator();
              while (paramAnonymousCollection.hasNext())
              {
                com.whatsapp.protocol.j localj = (com.whatsapp.protocol.j)paramAnonymousCollection.next();
                if ((localj.e.a.equals(Conversation.h(Conversation.this))) && (localj.Q >= paramAnonymousMap.Q)) {
                  Conversation.aa(Conversation.this);
                }
              }
            }
          }
          Conversation.ao(Conversation.this);
        }
        return;
      }
    }
    
    public final void b(com.whatsapp.protocol.j paramAnonymousj, int paramAnonymousInt)
    {
      StringBuilder localStringBuilder;
      if ((paramAnonymousj != null) && (paramAnonymousj.e.a.equals(Conversation.h(Conversation.this))) && (paramAnonymousj.e.b) && (paramAnonymousj.s != 8))
      {
        Log.d("conversation/observer/beforemsgadded/add " + paramAnonymousj.e.c + " " + paramAnonymousj.s);
        if ((Conversation.X(Conversation.this)) && (paramAnonymousj.d == 6) && ((paramAnonymousj.t == 1L) || (paramAnonymousj.t == 4L) || (paramAnonymousj.t == 5L) || (paramAnonymousj.t == 7L) || (paramAnonymousj.t == 12L) || (paramAnonymousj.t == 20L) || (paramAnonymousj.t == 13L) || (paramAnonymousj.t == 14L) || (paramAnonymousj.t == 17L))) {
          Conversation.f(Conversation.this);
        }
        if ((Conversation.Y(Conversation.this) != 0) && (Conversation.Z(Conversation.this).b(paramAnonymousj))) {
          Conversation.aa(Conversation.this);
        }
        Log.i("conversation/beforemsgadded/unseen/" + Conversation.Y(Conversation.this) + "/" + Conversation.ab(Conversation.this) + "/" + Conversation.ac(Conversation.this));
        if (Conversation.e(Conversation.this).getCursor() != null) {
          Conversation.W(Conversation.this).add(paramAnonymousj);
        }
        localStringBuilder = new StringBuilder("conversation/observer/beforemsgadded: cursor=");
        if (Conversation.e(Conversation.this).getCursor() != null) {
          break label476;
        }
      }
      label476:
      for (Object localObject = "null";; localObject = Integer.valueOf(Conversation.e(Conversation.this).getCursor().getCount()))
      {
        Log.d(localObject + " appended=" + Conversation.W(Conversation.this).size());
        if ((paramAnonymousj.d != 6) && (paramAnonymousInt != 7))
        {
          Conversation.L(Conversation.this).setVisibility(8);
          if (Conversation.ad(Conversation.this) != null)
          {
            Conversation.ae(Conversation.this);
            Conversation.J(Conversation.this);
          }
          Conversation.M().remove(Conversation.h(Conversation.this));
          if (Conversation.K(Conversation.this) != null) {
            Conversation.K(Conversation.this).h = null;
          }
        }
        Conversation.e(Conversation.this).notifyDataSetChanged();
        Conversation.a(Conversation.this);
        return;
      }
    }
    
    public final void b(String paramAnonymousString)
    {
      if ((paramAnonymousString != null) && (paramAnonymousString.equals(Conversation.h(Conversation.this))))
      {
        Conversation.aa(Conversation.this);
        Conversation.ao(Conversation.this);
      }
    }
    
    public final void c(com.whatsapp.protocol.j paramAnonymousj, int paramAnonymousInt)
    {
      if ((paramAnonymousj != null) && (paramAnonymousj.e.a.equals(Conversation.h(Conversation.this))) && (paramAnonymousj.s != 8))
      {
        Log.d("conversation/observer/msgadded " + paramAnonymousj.e.c + " " + paramAnonymousj.s);
        if (paramAnonymousj.e.b) {
          break label685;
        }
        if (paramAnonymousj.Q == -1L) {
          break label400;
        }
      }
      label224:
      label349:
      label400:
      for (boolean bool = true;; bool = false)
      {
        a.d.a(bool, "row id must be present");
        try
        {
          paramAnonymousInt = Conversation.e(Conversation.this).getCount();
          if ((paramAnonymousInt <= 0) || (Conversation.e(Conversation.this).a(paramAnonymousInt - 1).Q < paramAnonymousj.Q)) {
            break;
          }
          Log.i("conversation/addreceived/skip/" + Log.a(paramAnonymousj));
          if (Conversation.g(Conversation.this) != null)
          {
            Object localObject2 = Conversation.g(Conversation.this);
            localObject1 = paramAnonymousj.f;
            if (((MentionableEntry)localObject2).c != null)
            {
              localObject2 = ((MentionableEntry)localObject2).c.c;
              if (((yv)localObject2).e != null) {
                yv.b.a(((yv)localObject2).e, (String)localObject1);
              }
            }
          }
        }
        catch (StaleDataException localStaleDataException1)
        {
          for (;;)
          {
            Object localObject1;
            Log.i("conversation/addreceived/staledata " + localStaleDataException1.toString());
            Conversation.W(Conversation.this).add(paramAnonymousj);
          }
        }
        Conversation.e(Conversation.this).notifyDataSetChanged();
        if (Conversation.s(Conversation.this).getVisibility() != 0) {
          break label886;
        }
        Conversation.ai(Conversation.this);
        Conversation.u(Conversation.this).setVisibility(0);
        Conversation.u(Conversation.this).setText(NumberFormat.getInstance().format(Conversation.aj(Conversation.this)));
        if (Conversation.aj(Conversation.this) == 1)
        {
          Conversation.ak(Conversation.this);
          localObject1 = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
          ((Animation)localObject1).setDuration(100L);
          Conversation.u(Conversation.this).startAnimation((Animation)localObject1);
        }
        if ((Conversation.al(Conversation.this)) && (paramAnonymousj.e.b) && (paramAnonymousj.d != 6))
        {
          Log.i("conversation/spam/message-from-me");
          Conversation.n(Conversation.this);
          Conversation.am(Conversation.this);
        }
        return;
      }
      if ((!Conversation.Z(Conversation.this).c(paramAnonymousj)) || (paramAnonymousj.R != null))
      {
        if ((Conversation.Y(Conversation.this) == 0) || (Conversation.e(Conversation.this).getCount() <= 0)) {
          break label901;
        }
        localObject1 = Conversation.e(Conversation.this).a(Conversation.e(Conversation.this).getCount() - 1);
        if ((localObject1 != null) && (!Conversation.Z(Conversation.this).b((com.whatsapp.protocol.j)localObject1)) && (!Conversation.Z(Conversation.this).c((com.whatsapp.protocol.j)localObject1))) {
          break label901;
        }
        Conversation.aa(Conversation.this);
      }
      for (;;)
      {
        label518:
        if (paramAnonymousInt != 0)
        {
          Conversation.af(Conversation.this);
          if (paramAnonymousj.s != 10) {
            break label674;
          }
          Conversation.ag(Conversation.this);
        }
        for (;;)
        {
          Log.i("conversation/addreceived/unseen/" + Conversation.Y(Conversation.this) + "/" + Conversation.ab(Conversation.this) + "/" + Conversation.ac(Conversation.this));
          Conversation.W(Conversation.this).add(paramAnonymousj);
          break;
          if (Conversation.Y(Conversation.this) == 0) {
            break label896;
          }
          paramAnonymousInt = 1;
          break label518;
          label674:
          Conversation.ah(Conversation.this);
        }
        try
        {
          label685:
          paramAnonymousInt = Conversation.e(Conversation.this).getCount();
          if (paramAnonymousInt != 0) {
            break label773;
          }
          Log.i("conversation/addsent/skipped/" + Log.a(paramAnonymousj) + " adapter-count:0");
          Conversation.W(Conversation.this).add(paramAnonymousj);
        }
        catch (StaleDataException localStaleDataException2)
        {
          Log.i("conversation/addsent/staledata " + localStaleDataException2.toString());
        }
        break label224;
        label773:
        com.whatsapp.protocol.j localj = Conversation.e(Conversation.this).a(paramAnonymousInt - 1);
        if ((localj.Q < 0L) || (localj.Q >= paramAnonymousj.Q)) {
          break label224;
        }
        Log.i("conversation/addsent/skipped/" + Log.a(paramAnonymousj) + " adapter-count:" + paramAnonymousInt + " las-row-id:" + localj.Q + " cur-row-id:" + paramAnonymousj.Q);
        Conversation.W(Conversation.this).add(paramAnonymousj);
        break label224;
        label886:
        Conversation.ak(Conversation.this);
        break label349;
        label896:
        paramAnonymousInt = 0;
        continue;
        label901:
        paramAnonymousInt = 1;
      }
    }
  };
  private MenuItem dt;
  private final int[] du = new int[2];
  private g dv;
  private boolean dw = true;
  private final TextWatcher dx = new TextWatcher()
  {
    public final void afterTextChanged(Editable paramAnonymousEditable)
    {
      Conversation.d(Conversation.this, paramAnonymousEditable.toString());
      Conversation.a(Conversation.this, be.c(Conversation.aD(Conversation.this)));
      Conversation.e(Conversation.this, Conversation.aD(Conversation.this));
      if (TextUtils.isEmpty(Conversation.aD(Conversation.this))) {
        Conversation.aE(Conversation.this);
      }
      Conversation.e(Conversation.this).notifyDataSetChanged();
    }
    
    public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      al.a(Conversation.this.aq, Conversation.aC(Conversation.this), paramAnonymousCharSequence);
    }
  };
  private boolean dy;
  private boolean dz;
  boolean r;
  public String t;
  final SparseArray<com.whatsapp.protocol.j> x = new SparseArray();
  final ArrayList<com.whatsapp.protocol.j> y = new ArrayList();
  final HashSet<j.b> z = new HashSet();
  
  static
  {
    aV = true;
    o = new ArrayList();
    p = new HashMap();
    q = new HashMap();
    aX = new HashMap();
    u = true;
    v = true;
    w = true;
  }
  
  public static void B()
  {
    b(null);
  }
  
  public static void E()
  {
    bu = true;
  }
  
  private void X()
  {
    this.cU.removeTextChangedListener(this.dl);
    this.bb = false;
    try
    {
      this.cU.setText("");
      TextKeyListener.clear(this.cU.getText());
      return;
    }
    finally
    {
      this.cU.addTextChangedListener(this.dl);
    }
  }
  
  private boolean Y()
  {
    if ((this.U.getLastVisiblePosition() < this.U.getHeaderViewsCount() + this.V.getCount() - 1) || (this.U.getChildCount() == 0)) {}
    while (this.U.getChildAt(this.U.getChildCount() - 1).getBottom() != this.U.getHeight()) {
      return false;
    }
    return true;
  }
  
  private void Z()
  {
    if ((this.bI.getVisibility() == 0) && (this.bK >= 0))
    {
      Log.i("conversation/hidelinkpreview/start " + this.bK);
      b(this.bI, this.bJ);
    }
  }
  
  public static Intent a(Context paramContext, cs paramcs)
  {
    return new Intent(null, paramcs.o(), paramContext, Conversation.class).addFlags(335544320);
  }
  
  public static Intent a(cs paramcs)
  {
    return a(paramcs.t);
  }
  
  public static Intent a(String paramString)
  {
    return new Intent(u.a(), Conversation.class).putExtra("jid", paramString).addFlags(335544320);
  }
  
  private static MenuItem a(Menu paramMenu, int paramInt1, int paramInt2)
  {
    return paramMenu.add(0, paramInt1, 0, paramInt2);
  }
  
  private static SubMenu a(Menu paramMenu)
  {
    paramMenu = paramMenu.addSubMenu(0, 3, 0, 2131297190);
    paramMenu.clearHeader();
    return paramMenu;
  }
  
  public static Animation a(boolean paramBoolean1, boolean paramBoolean2)
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    Object localObject;
    if (paramBoolean2)
    {
      localObject = new AlphaAnimation(0.0F, 1.0F);
      ((Animation)localObject).setDuration(100L);
      localAnimationSet.addAnimation((Animation)localObject);
      if (!paramBoolean2) {
        break label107;
      }
      if (!paramBoolean1) {
        break label102;
      }
    }
    label102:
    for (float f = 1.0F;; f = 0.0F)
    {
      localObject = new ScaleAnimation(0.0F, 1.0F, 1.0F, 1.0F, 1, f, 1, 0.5F);
      ((ScaleAnimation)localObject).setDuration(100L);
      localAnimationSet.addAnimation((Animation)localObject);
      localAnimationSet.setDuration(100L);
      return localAnimationSet;
      localObject = new AlphaAnimation(1.0F, 0.0F);
      break;
    }
    label107:
    if (paramBoolean1) {}
    for (f = 1.0F;; f = 0.0F)
    {
      localObject = new ScaleAnimation(1.0F, 0.0F, 1.0F, 1.0F, 1, f, 1, 0.5F);
      break;
    }
  }
  
  public static Animation a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    Object localObject;
    float f1;
    label50:
    float f2;
    if (paramBoolean3)
    {
      if (paramBoolean2)
      {
        localObject = new AlphaAnimation(0.0F, 1.0F);
        ((Animation)localObject).setDuration(100L);
        localAnimationSet.addAnimation((Animation)localObject);
      }
    }
    else
    {
      if (!paramBoolean1) {
        break label121;
      }
      f1 = 1.0F;
      if (!paramBoolean2) {
        break label128;
      }
      f2 = f1;
      label57:
      if (!paramBoolean2) {
        break label134;
      }
      f1 = 0.0F;
    }
    label121:
    label128:
    label134:
    for (;;)
    {
      localObject = new TranslateAnimation(1, f2, 1, f1, 1, 0.0F, 1, 0.0F);
      ((Animation)localObject).setDuration(100L);
      localAnimationSet.addAnimation((Animation)localObject);
      localAnimationSet.setDuration(100L);
      return localAnimationSet;
      localObject = new AlphaAnimation(1.0F, 0.0F);
      break;
      f1 = -1.0F;
      break label50;
      f2 = 0.0F;
      break label57;
    }
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent != null) {}
    for (paramIntent = paramIntent.getData().getLastPathSegment();; paramIntent = null)
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      if ((this.cc != null) && (this.cc.h != null))
      {
        Iterator localIterator = this.cc.h.iterator();
        while (localIterator.hasNext())
        {
          a.e locale = (a.e)localIterator.next();
          localArrayList2.add(locale.b);
          if (locale.e != null) {
            localArrayList1.add(locale.e + "@s.whatsapp.net");
          } else {
            localArrayList1.add(null);
          }
        }
        this.cG.a(localArrayList2, localArrayList1, this.cc.a(), paramIntent);
      }
      return;
    }
  }
  
  private void a(Drawable paramDrawable)
  {
    int i = this.cV.getPaddingLeft();
    int j = this.cV.getPaddingRight();
    this.cV.setBackgroundDrawable(paramDrawable);
    this.cV.setPadding(i, 0, j, 0);
  }
  
  private void a(Uri paramUri, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Drawable localDrawable;
    if (this.bd)
    {
      if ((paramUri == null) && (paramInt2 == -1)) {
        localDrawable = this.cH.a(this, true, paramInt1, false, -1, null, 0, 0);
      }
      for (;;)
      {
        b(localDrawable);
        MediaFileUtils.a(this, paramUri);
        return;
        if (paramUri == null) {
          localDrawable = this.cH.a(this, false, -1, true, paramInt2, null, paramInt3, paramInt4);
        } else {
          localDrawable = this.cH.a(this, false, -1, false, -1, paramUri, 0, 0);
        }
      }
    }
    if (paramUri == null) {
      if (paramInt2 == -1) {
        g.a(this, this.W.t, paramInt1, false, -1, null);
      }
    }
    for (;;)
    {
      localDrawable = this.cH.a(this, this.W.t);
      break;
      g.a(this, this.W.t, -1, true, paramInt2, null);
      continue;
      g.a(this, this.W.t, -1, false, -1, paramUri);
    }
  }
  
  @SuppressLint({"RtlHardcoded"})
  @TargetApi(11)
  private void a(MenuItem paramMenuItem, int paramInt)
  {
    View localView = paramMenuItem.getActionView();
    if (this.aq.d()) {
      localView.setOnTouchListener(new agl(0.0F, 0.0F, 0.2F, 0.0F));
    }
    for (;;)
    {
      localView.setOnClickListener(fo.a(this, paramMenuItem));
      localView.setOnLongClickListener(fy.a(this, paramInt));
      return;
      localView.setOnTouchListener(new agl(0.2F, 0.0F, 0.0F, 0.0F));
    }
  }
  
  private void a(final ViewGroup paramViewGroup, final View paramView)
  {
    final boolean bool = Y();
    this.bK = 1;
    this.K.setClipChildren(false);
    final int i = this.U.getTranscriptMode();
    if (bool) {
      this.U.setTranscriptMode(2);
    }
    for (;;)
    {
      e(d(0));
      paramViewGroup.setVisibility(0);
      paramViewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          paramViewGroup.getViewTreeObserver().removeGlobalOnLayoutListener(this);
          final int i = paramViewGroup.getHeight();
          final Object localObject = new TranslateAnimation(0.0F, 0.0F, i, 0.0F);
          ((Animation)localObject).setDuration(250L);
          if (bool) {
            Conversation.b(Conversation.this).startAnimation((Animation)localObject);
          }
          if ((paramViewGroup == Conversation.S(Conversation.this)) && (Conversation.L(Conversation.this).getVisibility() == 0)) {
            Conversation.L(Conversation.this).startAnimation((Animation)localObject);
          }
          if (Conversation.g(Conversation.this).getIsMentionPickerVisible()) {
            Conversation.T(Conversation.this).startAnimation((Animation)localObject);
          }
          paramView.startAnimation((Animation)localObject);
          localObject = Conversation.U(Conversation.this).getBackground();
          if (!(localObject instanceof Conversation.h)) {
            Conversation.a(Conversation.this, new Conversation.h((Drawable)localObject));
          }
          ((Conversation.h)Conversation.U(Conversation.this).getBackground()).a(i);
          localObject = new Animation()
          {
            protected final void applyTransformation(float paramAnonymous2Float, Transformation paramAnonymous2Transformation)
            {
              int i = i;
              int j = (int)(i * paramAnonymous2Float);
              paramAnonymous2Transformation = Conversation.U(Conversation.this).getBackground();
              if ((paramAnonymous2Transformation instanceof Conversation.h))
              {
                if (paramAnonymous2Float == 1.0F) {
                  Conversation.a(Conversation.this, localObject);
                }
              }
              else {
                return;
              }
              ((Conversation.h)paramAnonymous2Transformation).a(i - j);
            }
            
            public final boolean willChangeBounds()
            {
              return false;
            }
          };
          ((Animation)localObject).setStartTime(-1L);
          ((Animation)localObject).setDuration(250L);
          ((Animation)localObject).setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymous2Animation)
            {
              Log.i("conversation/showinputextension/end");
              Conversation.c(Conversation.this).setClipChildren(true);
              Conversation.V(Conversation.this);
              Conversation.b(Conversation.this).setTranscriptMode(Conversation.8.this.d);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
            
            public final void onAnimationStart(Animation paramAnonymous2Animation) {}
          });
          Conversation.U(Conversation.this).startAnimation((Animation)localObject);
        }
      });
      return;
      this.U.setTranscriptMode(0);
    }
  }
  
  public static void a(ad paramad)
  {
    Object localObject = (l)cd.get();
    if (((l)localObject).b) {
      localObject = ((l)localObject).a();
    }
    for (;;)
    {
      if (localObject != null)
      {
        paramad = paramad.a(((Conversation)localObject).t, ((Conversation)localObject).B, ((Conversation)localObject).d(false));
        ((Conversation)localObject).y.clear();
        ((Conversation)localObject).x.clear();
        ((Conversation)localObject).bc = true;
        ((Conversation)localObject).B = paramad.a;
        ((Conversation)localObject).V.changeCursor(paramad.b);
      }
      return;
      Conversation localConversation = ((l)localObject).a;
      if (localConversation != null)
      {
        localObject = localConversation;
        if (!localConversation.isFinishing()) {}
      }
      else
      {
        localObject = null;
      }
    }
  }
  
  private void a(cs paramcs, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.ag.O() < 5)
    {
      paramcs = new a();
      Bundle localBundle = new Bundle();
      localBundle.putString("jid", this.W.t);
      localBundle.putBoolean("is_video_call", paramBoolean2);
      paramcs.f(localBundle);
      a(paramcs);
      return;
    }
    this.aB.a(paramcs, this, Integer.valueOf(8), paramBoolean1, paramBoolean2);
  }
  
  static void a(pv parampv, od paramod, ad paramad, vv paramvv, Activity paramActivity, ng paramng, cs paramcs, boolean paramBoolean)
  {
    paramng.a(2131297593, 2131297592);
    bu.a(hd.a(paramad, paramcs, paramBoolean, parampv, paramng, paramActivity, paramod, paramvv));
  }
  
  private boolean a(Bundle paramBundle)
  {
    com.whatsapp.util.bd localbd = new com.whatsapp.util.bd("conversation/createconversation");
    this.t = getIntent().getStringExtra("jid");
    Object localObject1;
    String str;
    Object localObject2;
    if (this.t == null)
    {
      localObject1 = getIntent();
      if ((((Intent)localObject1).getData() != null) && (((Intent)localObject1).getData().getScheme() != null) && ((((Intent)localObject1).getData().getScheme().equals("smsto")) || (((Intent)localObject1).getData().getScheme().equals("sms"))))
      {
        str = getIntent().getData().toString();
        if (str == null) {
          return false;
        }
        localObject1 = str.split(":");
        if (localObject1.length == 2)
        {
          Log.i("conversation/sms-jid/raw-number" + localObject1[1]);
          localObject2 = PhoneNumberUtils.stripSeparators(URLDecoder.decode(localObject1[1]));
          localObject1 = localObject2;
          if (((String)localObject2).length() > 0)
          {
            localObject1 = localObject2;
            if (!Character.isDigit(((String)localObject2).charAt(0))) {
              localObject1 = ((String)localObject2).substring(1);
            }
          }
          localObject1 = (String)localObject1 + "@s.whatsapp.net";
          localObject1 = this.ae.h((String)localObject1);
          if ((((ArrayList)localObject1).size() > 0) && (((cs)((ArrayList)localObject1).get(0)).h))
          {
            this.W = ((cs)((ArrayList)localObject1).get(0));
            this.t = this.W.t;
            Log.i("conversation/sms-jid:" + this.t);
          }
        }
      }
    }
    for (int i = 0;; i = 1)
    {
      if (i != 0) {
        this.W = this.ae.a(this.t);
      }
      this.I = this.W.d();
      this.J = com.whatsapp.protocol.j.b(this.W.t);
      bo(this);
      if (this.W == null)
      {
        Log.e("conversation/start no contact for " + this.t);
        return false;
        paramBundle = new Intent(this, SmsDefaultAppWarning.class);
        paramBundle.setData(Uri.parse(str));
        startActivity(paramBundle);
        finish();
        return false;
        Log.e("conversation/sms/no jid");
        return false;
        Log.e("conversation/start no jid");
        return false;
      }
      this.V = new d(this);
      this.V.registerDataSetObserver(this.dp);
      if (aic.O)
      {
        i = this.cL.b(this.t);
        this.bB = i;
        if (Build.VERSION.SDK_INT <= 13)
        {
          if (this.bB <= 0) {
            break label772;
          }
          ae();
        }
      }
      for (;;)
      {
        this.cU = ((MentionableEntry)findViewById(2131755557));
        if (Build.VERSION.SDK_INT >= 13)
        {
          localObject1 = new String[1];
          localObject1[0] = "image/gif";
          this.cU.setAcceptedMimeTypes((String[])localObject1);
          localObject2 = new tc();
          this.cU.setOnCommitContentListener(new gf(this, (tc)localObject2, (String[])localObject1));
        }
        e(2130840040);
        if (this.I)
        {
          this.cS = ((FrameLayout)findViewById(2131755447));
          this.cU.a = findViewById(2131755552);
          this.cU.setMentionPickerVisibilityChangeListener(new gg(this));
          this.cU.a(this.cS, this.t, false, false);
        }
        this.cU.setHint(getString(2131298046));
        this.cU.setFilters(new InputFilter[] { new j(this.N) });
        this.U.setAdapter(this.V);
        this.cM.c();
        if (!AndroidWear.a()) {
          break label779;
        }
        localObject1 = this.ah.j().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if (this.Q.o((String)localObject2) > 0) {
            this.cM.a((String)localObject2);
          }
        }
        i = 0;
        break;
        label772:
        ad();
      }
      label779:
      Log.d("conversation/createconv/statusbar/cancel");
      this.E = false;
      if (!this.dq)
      {
        this.dr.registerObserver(this.ds);
        this.dq = true;
      }
      localObject1 = getIntent();
      boolean bool;
      if (((Intent)localObject1).getBooleanExtra("number_from_url", false)) {
        if ((!this.r) || (((Bundle)a.d.a(paramBundle)).getBoolean("has_number_from_url")))
        {
          bool = true;
          this.A = bool;
          label861:
          if (!((Intent)localObject1).getBooleanExtra("text_from_url", false)) {
            break label1516;
          }
          if ((this.r) && (!((Bundle)a.d.a(paramBundle)).getBoolean("has_text_from_url"))) {
            break label1511;
          }
          bool = true;
          label898:
          this.bb = bool;
          label903:
          if ((((Intent)localObject1).getBooleanExtra("has_share", false)) && (!this.r) && (s))
          {
            ((Intent)localObject1).putExtra("has_share", false);
            s = false;
            bool = this.at.e();
            aX.remove(this.t);
            this.dy = true;
            paramBundle = ((Intent)localObject1).getParcelableArrayListExtra("android.intent.extra.STREAM");
            if (paramBundle == null) {
              break label1524;
            }
            if (bool) {
              this.as.a(false, new ArrayList(Collections.singleton(this.t)), paramBundle, getIntent().getStringExtra("android.intent.extra.TEXT"), getIntent().getIntExtra("origin", 0), getIntent().getBooleanExtra("skip_preview", false), this, this, new ahx.a()
              {
                public final void a() {}
                
                public final void a(Uri paramAnonymousUri) {}
                
                public final void b(Uri paramAnonymousUri) {}
              });
            }
          }
          label1048:
          paramBundle = (String)p.get(this.W.t);
          if (TextUtils.isEmpty(paramBundle)) {
            break label1736;
          }
          localObject1 = yr.a((String)q.get(this.W.t));
          this.cU.a(paramBundle, (Collection)localObject1);
          be.a(this, this.aE, this.cU.getEditableText(), this.cU.getPaint());
          localObject1 = aa.c(paramBundle);
          this.bM = ((String)localObject1);
          if (localObject1 != null)
          {
            long l = SystemClock.elapsedRealtime();
            aug.a(this.aq, (String)localObject1, new gs(this, l));
          }
          label1166:
          if (!be.a(paramBundle)) {
            break label1747;
          }
          this.cY.setVisibility(0);
          this.cZ.setVisibility(0);
          this.cW.setVisibility(8);
          label1198:
          paramBundle = (ViewGroup)al.a(this.aq, LayoutInflater.from(i().h()), 2130903128, null, false);
          this.db = ((ViewGroup)paramBundle.findViewById(2131755535));
          this.db.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
          {
            int a;
            Runnable b = hr.a(this);
            
            public final void onGlobalLayout()
            {
              int i = Conversation.bk(Conversation.this).getWidth();
              if (i != this.a)
              {
                this.a = i;
                Conversation.this.aq.b(this.b);
                Conversation.this.aq.a(this.b);
              }
            }
          });
          this.dc = ((TextEmojiLabel)this.db.findViewById(2131755460));
          this.dd = this.db.findViewById(2131755536);
          this.df = ((TextView)this.db.findViewById(2131755461));
          this.de = ((TextView)this.db.findViewById(2131755537));
          this.dg = ((ImageView)paramBundle.findViewById(2131755532));
          if ((!this.aq.d()) && (Build.VERSION.SDK_INT >= 11) && (Build.VERSION.SDK_INT < 19)) {
            this.db.setLayoutTransition(null);
          }
          this.db.setClickable(true);
          if ((this.I) || (this.J))
          {
            localObject1 = this.df;
            if (!this.I) {
              break label1776;
            }
            i = 2131297970;
            label1408:
            ((TextView)localObject1).setText(getString(i));
          }
          paramBundle.findViewById(2131755439).setOnClickListener(ha.a(this));
          this.ca = ((ViewStub)paramBundle.findViewById(2131755534));
          this.db.setOnClickListener(hb.a(this));
          i().c();
          i().a(paramBundle);
          this.cU.requestFocus();
          if (!Voip.e()) {
            break label1783;
          }
          as();
        }
      }
      for (;;)
      {
        localbd.b();
        return true;
        bool = false;
        break;
        this.A = false;
        break label861;
        label1511:
        bool = false;
        break label898;
        label1516:
        this.bb = false;
        break label903;
        label1524:
        if (((Intent)localObject1).getExtras().getByte("wa_type") == 4)
        {
          if (!bool) {
            break label1048;
          }
          this.cv.a(this.t, ((Intent)localObject1).getStringExtra("vcard_name"), a.a.a.a.a.c.a(this, this.ae, this.aP, ((Intent)localObject1).getStringExtra("vcard_str")), null, this.A);
          break label1048;
        }
        if (((Intent)localObject1).getExtras().getByte("wa_type") == 14)
        {
          if (!bool) {
            break label1048;
          }
          paramBundle = ((Intent)localObject1).getStringArrayListExtra("vcard_array_str");
          this.cv.a(this.t, paramBundle, null, this.A);
          break label1048;
        }
        paramBundle = ((Intent)localObject1).getStringExtra("share_msg");
        if ((paramBundle == null) || (paramBundle.length() <= 0)) {
          break label1048;
        }
        if ((((Intent)localObject1).getBooleanExtra("confirm", false)) || (!bool))
        {
          p.put(this.W.t, paramBundle);
          break label1048;
        }
        this.cv.a(Collections.singletonList(this.W.t), paramBundle, aug.a(aa.c(paramBundle)), null, null, this.A, this.bb);
        this.bb = false;
        break label1048;
        label1736:
        this.cU.setText(null);
        break label1166;
        label1747:
        this.cY.setVisibility(8);
        this.cZ.setVisibility(8);
        this.cW.setVisibility(0);
        break label1198;
        label1776:
        i = 2131297971;
        break label1408;
        label1783:
        this.bC.setVisibility(8);
      }
    }
  }
  
  private int aa()
  {
    if (this.cI.b(this.t)) {
      return 2131297146;
    }
    return 2131297145;
  }
  
  private void ab()
  {
    if ((this.dv == null) && (this.dw))
    {
      this.dv = new g(d(true));
      Log.i("conversation/more-messages/time to load more");
      bu.a(this.dv, new Void[0]);
    }
  }
  
  private void ac()
  {
    if (this.by == null)
    {
      this.by = al.a(this.aq, getLayoutInflater(), 2130903131, this.U, false);
      this.by.findViewById(2131755543).setOnClickListener(gh.a(this));
      this.by.findViewById(2131755545).setOnClickListener(gi.a(this));
      this.bw.addView(this.by, 0);
    }
  }
  
  private void ad()
  {
    if (this.bz == null)
    {
      this.bz = al.a(this.aq, getLayoutInflater(), 2130903130, this.U, false);
      this.bz.findViewById(2131755539).setOnClickListener(gk.a(this));
      this.bz.findViewById(2131755543).setOnClickListener(gl.a(this));
      this.bz.findViewById(2131755545).setOnClickListener(gm.a(this));
      this.bz.findViewById(2131755541).setOnClickListener(gn.a(this));
      aoa.b((TextView)this.bz.findViewById(2131755540));
      aoa.b((TextView)this.bz.findViewById(2131755542));
      aoa.b((TextView)this.bz.findViewById(2131755544));
      aoa.b((TextView)this.bz.findViewById(2131755546));
      this.U.addFooterView(this.bz);
    }
  }
  
  private void ae()
  {
    if (this.bA == null)
    {
      this.bA = al.a(this.aq, getLayoutInflater(), 2130903390, this.U, false);
      aoa.b((TextView)this.bA.findViewById(2131756149));
      aoa.b((TextView)this.bA.findViewById(2131756151));
      aoa.b((TextView)this.bA.findViewById(2131755546));
      this.U.addFooterView(this.bA);
    }
  }
  
  private void af()
  {
    Object localObject;
    if (this.cz.c()) {
      localObject = LocationPicker2.class;
    }
    for (;;)
    {
      if (localObject != null)
      {
        localObject = new Intent(this, (Class)localObject);
        ((Intent)localObject).putExtra("jid", this.W.t);
        if (this.L == null) {}
        for (long l = 0L;; l = this.L.Q)
        {
          ((Intent)localObject).putExtra("quoted_message_row_id", l);
          ((Intent)localObject).putExtra("has_number_from_url", this.A);
          startActivity((Intent)localObject);
          u = false;
          return;
          if (!com.whatsapp.location.cc.b()) {
            break label148;
          }
          localObject = LocationPicker.class;
          break;
        }
      }
      if (this.aP.c())
      {
        this.cv.a(this.W.t, null, this.L, this.A);
        return;
      }
      Log.w("conversation/attach-location/no activity and no permissions.");
      return;
      label148:
      localObject = null;
    }
  }
  
  private void ag()
  {
    if ((RequestPermissionActivity.a(this, this.aP, 32)) && (this.aI.a(this.cj)))
    {
      MediaFileUtils.a(this.au, 4, this);
      u = false;
    }
  }
  
  private void ah()
  {
    if ((RequestPermissionActivity.a(this, this.aP, 31)) && (this.aI.a(this.cj)))
    {
      MediaFileUtils.a(this.au, 23, this);
      u = false;
    }
  }
  
  private boolean ai()
  {
    return (this.N != null) && (this.N.e());
  }
  
  private void aj()
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (this.W.d())
    {
      localObject1 = this.ae.d(this.W.q());
      if ((!this.cs.a(((cs)localObject1).t)) && (((cs)localObject1).d == null) && (!this.cF.a(this.W.t)) && (this.cu.a(this.W.t) == -1))
      {
        ad();
        this.bz.findViewById(2131755543).setVisibility(8);
        this.bz.findViewById(2131755545).setVisibility(8);
        this.bz.findViewById(2131755340).setVisibility(0);
        bool1 = true;
      }
    }
    for (;;)
    {
      if (bool1 != this.bp)
      {
        Log.i("conversation/spam/" + bool1);
        this.bp = bool1;
        if (!this.bp) {
          break;
        }
        b(null);
        this.K.setBackgroundResource(2130840456);
      }
      return;
      bool1 = bool2;
      if (this.bz != null)
      {
        this.bz.findViewById(2131755340).setVisibility(8);
        bool1 = bool2;
        continue;
        if ((!com.whatsapp.protocol.j.b(this.W.t)) && (this.W.d == null) && (!e.b(this.W.t)))
        {
          Object localObject2;
          int i;
          if (this.bB > 0)
          {
            ae();
            localObject1 = this.Q;
            localObject2 = this.W.t;
            localObject1 = (ad.d)((ad)localObject1).n.a.get(localObject2);
            if (localObject1 != null) {
              i = ((ad.d)localObject1).k;
            }
            for (;;)
            {
              if (i != 1)
              {
                this.bA.findViewById(2131756150).setOnClickListener(new com.whatsapp.util.at()
                {
                  public final void a(View paramAnonymousView)
                  {
                    paramAnonymousView = Conversation.Z(Conversation.this);
                    String str = Conversation.this.W.t;
                    ad.d locald = (ad.d)paramAnonymousView.n.a.get(str);
                    if ((locald != null) && (locald.k != 1))
                    {
                      locald.k = 1;
                      paramAnonymousView.d.post(com.whatsapp.data.bd.a(paramAnonymousView, str));
                    }
                    Conversation.aK(Conversation.this).setVisibility(8);
                  }
                });
                if (this.bB == 1)
                {
                  this.bA.findViewById(2131755601).setVisibility(8);
                  localObject1 = this.bA.findViewById(2131755545);
                  ((View)localObject1).setVisibility(0);
                  ((View)localObject1).setOnClickListener(new com.whatsapp.util.at()
                  {
                    public final void a(View paramAnonymousView)
                    {
                      Object localObject = null;
                      paramAnonymousView = Conversation.aL(Conversation.this).a(Conversation.this.W.t);
                      try
                      {
                        a.a.a.a.a.a locala = a.a.a.a.a.a.a(Conversation.this, Conversation.this.ae, paramAnonymousView);
                        paramAnonymousView = (View)localObject;
                        if (locala.f != null)
                        {
                          paramAnonymousView = (View)localObject;
                          if (locala.f.length > 0) {
                            paramAnonymousView = BitmapFactory.decodeByteArray(locala.f, 0, locala.f.length);
                          }
                        }
                        if (Build.VERSION.SDK_INT < 11)
                        {
                          Conversation.aM(Conversation.this).a(locala, paramAnonymousView, null, null, Conversation.this);
                          Conversation.aK(Conversation.this).setVisibility(8);
                          return;
                        }
                        Conversation.this.a(locala, paramAnonymousView, 1);
                        return;
                      }
                      catch (a.a.a.a.a.d paramAnonymousView)
                      {
                        Log.d("conversation/updateblockheaderfooter add_btn onclick error parsing vcard", paramAnonymousView);
                        return;
                      }
                      catch (IOException paramAnonymousView)
                      {
                        for (;;) {}
                      }
                    }
                  });
                  bool1 = bool2;
                  break;
                  i = 0;
                  continue;
                }
                this.bA.findViewById(2131755601).setVisibility(0);
                this.bA.findViewById(2131755545).setVisibility(8);
                bool1 = bool2;
                break;
              }
            }
            bool1 = bool2;
            if (this.bA != null)
            {
              this.bA.setVisibility(8);
              bool1 = bool2;
            }
          }
          else
          {
            bool2 = this.R.a(this.W.t);
            if (bool2) {}
            for (i = 2131298057;; i = 2131296350)
            {
              localObject1 = getString(i);
              if (!this.W.f())
              {
                ac();
                localObject2 = (TextView)this.by.findViewById(2131755543);
                ((TextView)localObject2).setText((CharSequence)localObject1);
                if ((!bool2) && (!TextUtils.isEmpty(this.Q.n(this.W.t))))
                {
                  ((TextView)localObject2).setVisibility(8);
                  ((TextView)this.by.findViewById(2131755545)).setText(2131296292);
                  localObject2 = this.by.findViewById(2131755385);
                  if (localObject2 != null) {
                    ((View)localObject2).setVisibility(8);
                  }
                }
              }
              if (this.cu.a(this.W.t) != -1) {
                break label748;
              }
              if (this.by != null) {
                this.by.findViewById(2131755340).setVisibility(8);
              }
              ad();
              this.bz.findViewById(2131755340).setVisibility(0);
              bool2 = true;
              bool1 = bool2;
              if (this.bz == null) {
                break;
              }
              ((TextView)this.bz.findViewById(2131755544)).setText((CharSequence)localObject1);
              this.bz.findViewById(2131755541).setVisibility(8);
              localObject1 = (TextView)this.bz.findViewById(2131755386);
              if (!this.W.f()) {
                break label831;
              }
              ((TextView)localObject1).setText(2131297669);
              bool1 = bool2;
              break;
            }
            label748:
            if ((this.W.f()) && (this.by != null))
            {
              this.bw.removeView(this.by);
              this.by = null;
            }
            for (;;)
            {
              bool2 = bool1;
              if (this.bz == null) {
                break;
              }
              this.bz.findViewById(2131755340).setVisibility(8);
              bool2 = bool1;
              break;
              ac();
              this.by.findViewById(2131755340).setVisibility(0);
            }
            label831:
            ((TextView)localObject1).setText(2131297668);
            bool1 = bool2;
          }
        }
        else
        {
          if (this.by != null) {
            this.by.findViewById(2131755340).setVisibility(8);
          }
          bool1 = bool2;
          if (this.bz != null)
          {
            this.bz.findViewById(2131755340).setVisibility(8);
            bool1 = bool2;
          }
        }
      }
    }
    this.Q.a(this.W.t, true);
    if (this.bd) {}
    for (Object localObject1 = this.cH.d(this);; localObject1 = this.cH.a(this, this.W.t))
    {
      if (localObject1 != null) {
        b((Drawable)localObject1);
      }
      am();
      return;
    }
  }
  
  private boolean ak()
  {
    Cursor localCursor = this.V.getCursor();
    if ((localCursor != null) && (localCursor.moveToFirst())) {
      do
      {
        com.whatsapp.protocol.j localj = this.cE.a(localCursor, this.t);
        if ((!localj.e.b) || (localj.d != 6)) {
          return false;
        }
      } while (localCursor.moveToNext());
    }
    return true;
  }
  
  private void al()
  {
    bu.a(new AsyncTask() {}, new Void[0]);
  }
  
  private void am()
  {
    this.U.post(gw.a(this));
  }
  
  private void an()
  {
    Object localObject;
    if (this.I)
    {
      localObject = this.cA.a(this.W);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.df.setText((CharSequence)localObject);
      }
    }
    while (this.J)
    {
      do
      {
        return;
      } while (this.dh == null);
      this.df.setText(this.dh);
      return;
    }
    String str = this.cA.b(this.W);
    if (!TextUtils.isEmpty(str))
    {
      this.dd.setVisibility(0);
      localObject = this.cA;
      cs localcs = this.W;
      if (((el)localObject).a(localcs) == null)
      {
        long l = ((el)localObject).c.a(localcs.t);
        if (1L != ((el)localObject).c.a(localcs.t)) {
          localObject = com.whatsapp.util.l.d(u.a(), ((el)localObject).b, ((el)localObject).a.a(l));
        }
      }
      for (;;)
      {
        if (localObject != null)
        {
          int i = this.db.getWidth();
          if (i == 0) {
            break;
          }
          if (this.df.getPaint().measureText(str) >= i - this.db.getPaddingLeft() - this.db.getPaddingRight())
          {
            if (this.dB == null)
            {
              this.de.setText(this.W.a(this, this.aF, new Object[0]));
              this.de.setVisibility(0);
              this.dB = new f((byte)0);
              this.aq.a(this.dB, 1500L);
            }
            this.df.setText((CharSequence)localObject);
            return;
            localObject = null;
          }
          else
          {
            if (this.dB != null) {
              this.aq.b(this.dB);
            }
            this.de.setVisibility(8);
            this.df.setText(str);
            return;
          }
        }
      }
      if (this.dB != null) {
        this.aq.b(this.dB);
      }
      this.de.setVisibility(8);
      this.df.setText(str);
      return;
    }
    if (this.dB != null) {
      this.aq.b(this.dB);
    }
    this.de.setVisibility(8);
    this.dd.setVisibility(8);
  }
  
  private void ao()
  {
    boolean bool2 = true;
    this.W = this.ae.a(this.W.t);
    this.dc.setContact(this.W);
    boolean bool1;
    if (this.bT == null)
    {
      bool1 = true;
      if (this.bT != null)
      {
        this.bT.a();
        this.bT = null;
      }
      an();
      if ((this.I) || (this.J))
      {
        this.bT = new e(this.W.t, bool1);
        bu.a(this.bT, new Void[0]);
      }
      aj();
      if ((!this.I) || (this.cQ.b(this.W.t))) {
        break label241;
      }
      this.bE.setVisibility(8);
      this.bF.setVisibility(8);
      this.bG.setVisibility(0);
      if (this.dt == null) {
        break label374;
      }
      this.dt.setVisible(false);
      bool1 = false;
    }
    for (;;)
    {
      label183:
      if (bool1)
      {
        al.a(this.aq, this.dc, 2130840264);
        this.dc.setCompoundDrawablePadding(getResources().getDimensionPixelSize(2131362112));
      }
      for (;;)
      {
        bu.a(new i((byte)0), new Void[0]);
        return;
        bool1 = false;
        break;
        label241:
        if (e.b(this.W.t))
        {
          this.bE.setVisibility(8);
          this.bF.setVisibility(0);
          this.bG.setVisibility(8);
          bool1 = bool2;
          if (this.dt == null) {
            break label183;
          }
          this.dt.setVisible(false);
          bool1 = bool2;
          break label183;
        }
        this.bE.setVisibility(0);
        this.bF.setVisibility(8);
        this.bG.setVisibility(8);
        if (this.dt != null) {
          this.dt.setVisible(true);
        }
        bool1 = this.W.f();
        break label183;
        this.dc.setCompoundDrawables(null, null, null, null);
      }
      label374:
      bool1 = false;
    }
  }
  
  private ProgressBar ap()
  {
    if (this.cb == null) {
      this.cb = ((ProgressBar)this.ca.inflate());
    }
    return this.cb;
  }
  
  private void aq()
  {
    this.aW.hideSoftInputFromWindow(this.cU.getWindowToken(), 0);
  }
  
  private boolean ar()
  {
    if (this.G.isShowing()) {}
    int[] arrayOfInt;
    do
    {
      return false;
      arrayOfInt = new int[2];
      this.bE.getLocationOnScreen(arrayOfInt);
    } while (getWindow().getDecorView().getHeight() - (arrayOfInt[1] + this.bE.getHeight()) <= 128.0F * bv.a);
    return true;
  }
  
  private void as()
  {
    this.bC.setVisibility(0);
    this.bD.setText("");
  }
  
  private void b(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      Log.d("conversation/wallpaper/set/drawable");
      this.bS.setDrawable(paramDrawable);
      this.K.setBackgroundResource(0);
      return;
    }
    Log.d("conversation/wallpaper/clear/toggle_view");
    this.bS.a();
    this.K.setBackgroundResource(2131623999);
  }
  
  private void b(final ViewGroup paramViewGroup, final View paramView)
  {
    e(d(1));
    final boolean bool = Y();
    this.bK = -1;
    this.K.setClipChildren(false);
    final int i = this.U.getTranscriptMode();
    final int j = paramViewGroup.getHeight();
    Object localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, j);
    ((Animation)localObject).setDuration(250L);
    paramView.startAnimation((Animation)localObject);
    if ((paramViewGroup == this.bI) && (this.bP.getVisibility() == 0)) {
      this.bP.startAnimation((Animation)localObject);
    }
    if (this.cU.getIsMentionPickerVisible()) {
      this.cS.startAnimation((Animation)localObject);
    }
    if (bool)
    {
      this.U.setTranscriptMode(2);
      this.U.startAnimation((Animation)localObject);
    }
    localObject = this.cV.getBackground();
    if (!(localObject instanceof h)) {
      a(new h((Drawable)localObject));
    }
    localObject = new Animation()
    {
      protected final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        int i = (int)(j * paramAnonymousFloat);
        paramAnonymousTransformation = Conversation.U(Conversation.this).getBackground();
        if ((paramAnonymousTransformation instanceof Conversation.h)) {
          ((Conversation.h)paramAnonymousTransformation).a(i);
        }
      }
      
      public final boolean willChangeBounds()
      {
        return false;
      }
    };
    ((Animation)localObject).setDuration(250L);
    this.cV.startAnimation((Animation)localObject);
    ((Animation)localObject).setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        Log.i("conversation/hideinputextension/end");
        paramViewGroup.setVisibility(8);
        Conversation.U(Conversation.this).getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
          public final void onGlobalLayout()
          {
            Conversation.U(Conversation.this).getViewTreeObserver().removeGlobalOnLayoutListener(this);
            Object localObject = Conversation.U(Conversation.this).getBackground();
            if ((localObject instanceof Conversation.h)) {
              Conversation.a(Conversation.this, ((Conversation.h)localObject).a());
            }
            localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, 0.0F);
            ((Animation)localObject).setDuration(0L);
            Conversation.10.this.b.startAnimation((Animation)localObject);
            if ((Conversation.10.this.a == Conversation.S(Conversation.this)) && (Conversation.L(Conversation.this).getVisibility() == 0)) {
              Conversation.L(Conversation.this).startAnimation((Animation)localObject);
            }
            if (Conversation.g(Conversation.this).getIsMentionPickerVisible()) {
              Conversation.T(Conversation.this).startAnimation((Animation)localObject);
            }
            if (Conversation.10.this.c) {
              Conversation.b(Conversation.this).startAnimation((Animation)localObject);
            }
            Conversation.V(Conversation.this);
          }
        });
        Conversation.c(Conversation.this).setClipChildren(true);
        Conversation.b(Conversation.this).setTranscriptMode(i);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
  }
  
  public static void b(String paramString)
  {
    Object localObject = (l)cd.get();
    if (((l)localObject).b) {
      if ((paramString == null) || (paramString.equals(((l)localObject).a().t))) {
        ((l)localObject).a().finish();
      }
    }
    do
    {
      return;
      localObject = ((l)localObject).a;
    } while ((localObject == null) || (((Conversation)localObject).isFinishing()) || ((paramString != null) && (!paramString.equals(((Conversation)localObject).t))));
    ((Conversation)localObject).finish();
  }
  
  private static void bo(Conversation paramConversation)
  {
    Log.d("conversation/session/active/jid " + paramConversation.t);
    cd.set(new l(paramConversation, true));
  }
  
  private static void bp(Conversation paramConversation)
  {
    l locall = (l)cd.get();
    if (locall.a == paramConversation)
    {
      Log.d("conversation/session/inactive/jid " + paramConversation.t);
      cd.compareAndSet(locall, new l(paramConversation, false));
    }
  }
  
  private void f(com.whatsapp.protocol.j paramj)
  {
    this.L = paramj;
    aX.put(this.t, Long.valueOf(paramj.Q));
    if (this.N != null) {
      this.N.h = paramj;
    }
    if (this.bO == null)
    {
      this.bO = al.a(this.aq, getLayoutInflater(), 2130903342, null, false);
      this.bP.addView(this.bO);
      al.a(this.aq, this.bO.findViewById(2131756047), 0, (int)(aoa.a().a * 24.0F));
      this.bO.findViewById(2131755378).setVisibility(0);
      this.bO.findViewById(2131755378).setOnClickListener(new com.whatsapp.util.at()
      {
        public final void a(View paramAnonymousView)
        {
          Conversation.J(Conversation.this);
          Conversation.M().remove(Conversation.h(Conversation.this));
          if (Conversation.K(Conversation.this) != null) {
            Conversation.K(Conversation.this).h = null;
          }
          if ((Conversation.L(Conversation.this).getVisibility() == 0) && (Conversation.M(Conversation.this) >= 0))
          {
            Log.i("conversation/hidelinkpreview/start " + Conversation.M(Conversation.this));
            Conversation.a(Conversation.this, Conversation.L(Conversation.this), Conversation.N(Conversation.this));
          }
        }
      });
      TextView localTextView = (TextView)this.bO.findViewById(2131756047);
      localTextView.setTextSize(hy.b(getResources(), this.aF));
      aoa.b(localTextView);
    }
    hy.a(this.aq, this.cs, this.ct, this.ae, this.aE, this.aF, this.cJ, this.cQ, this.bO, paramj.e.a, paramj, null);
    if (this.bO.findViewById(2131756051).getVisibility() == 0) {
      this.bO.findViewById(2131756052).setBackgroundResource(2130840504);
    }
    for (;;)
    {
      if ((this.bP.getVisibility() != 0) || (this.bK < 0))
      {
        Log.i("conversation/replypreview/start");
        a(this.bP, this.bO);
      }
      a.a.a.a.d.a(this, false);
      return;
      this.bO.findViewById(2131756052).setBackgroundColor(0);
    }
  }
  
  private boolean h(int paramInt)
  {
    if (!this.aP.b())
    {
      RequestPermissionActivity.a(this, 2131297445, 2131297444, paramInt);
      return false;
    }
    return true;
  }
  
  private void i(String paramString)
  {
    paramString = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + paramString));
    try
    {
      startActivity(paramString);
      return;
    }
    catch (ActivityNotFoundException paramString)
    {
      pv.a(this, 2131296289, 0);
    }
  }
  
  public static l l()
  {
    return (l)cd.get();
  }
  
  final void A()
  {
    this.R.a(this, false, this.W.t);
  }
  
  final void C()
  {
    this.U.setTranscriptMode(0);
    int i = d.a(this.V);
    int j = (getWindowManager().getDefaultDisplay().getHeight() - getResources().getDimensionPixelSize(2131362014) * 2) / 5;
    Log.d("conversation/center divider pos:" + d.a(this.V) + " yOffset:" + j);
    this.U.setSelectionFromTop(i + this.U.getHeaderViewsCount(), j);
    this.dz = false;
    this.be = false;
  }
  
  final void D()
  {
    if (this.be)
    {
      this.dz = false;
      this.dA = false;
      Log.d("conversation/dbgscroll/scrolltobottom/scrolltotop/false freezelistpos=false dividercentered=true");
    }
    this.cf = true;
    this.U.post(gy.a(this));
  }
  
  final void F()
  {
    this.bh = 0;
    this.bf = 0;
    this.bg = 0;
  }
  
  @TargetApi(11)
  protected final void a(a.a.a.a.a.a parama, Bitmap paramBitmap)
  {
    a(parama, paramBitmap, 41);
  }
  
  @TargetApi(11)
  protected final void a(a.a.a.a.a.a parama, Bitmap paramBitmap, int paramInt)
  {
    this.cc = parama;
    new android.support.v7.app.b.a(this).b(2131296293).a(2131297274, gq.a(this, parama, paramBitmap, paramInt)).b(2131296767, gr.a(this, parama, paramBitmap, paramInt)).a().show();
  }
  
  final void a(Uri paramUri, int paramInt)
  {
    if (paramUri != null)
    {
      Intent localIntent = new Intent(this, MediaPreviewActivity.class);
      localIntent.putExtra("jid", this.W.t);
      localIntent.putExtra("max_items", 0);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramUri);
      localIntent.putExtra("android.intent.extra.STREAM", localArrayList);
      if (this.L != null) {
        localIntent.putExtra("quoted_message_row_id", this.L.Q);
      }
      localIntent.putExtra("origin", paramInt);
      localIntent.putExtra("send", true);
      startActivityForResult(localIntent, 22);
      return;
    }
    Log.e("conversation/setuppreview/share-failed");
    pv.a(getBaseContext(), 2131297841, 0);
  }
  
  public final void a(auf paramauf)
  {
    boolean bool = false;
    if (a.a.a.a.d.a(this)) {}
    do
    {
      return;
      if (paramauf == null) {
        break;
      }
    } while (!TextUtils.equals(this.bM, paramauf.a));
    if (paramauf.c())
    {
      this.bL = paramauf;
      Log.i("conversation/showlinkpreview");
      final Object localObject;
      if (this.bJ == null)
      {
        this.bJ = al.a(this.aq, getLayoutInflater(), 2130903409, null, false);
        this.bI.addView(this.bJ);
        al.a(this.aq, this.bJ.findViewById(2131755177), 0, (int)(aoa.a().a * 24.0F));
        this.bJ.findViewById(2131755224).setVisibility(8);
        localObject = this.bJ.findViewById(2131755378);
        ((View)localObject).setVisibility(0);
        ((View)localObject).setOnClickListener(new com.whatsapp.util.at()
        {
          public final void a(View paramAnonymousView)
          {
            Conversation.c(Conversation.this, Conversation.G(Conversation.this));
            Conversation.O(Conversation.this);
            Conversation.P(Conversation.this);
          }
        });
        localObject = this.bJ.findViewById(2131755327);
        ((View)localObject).setOnClickListener(new com.whatsapp.util.at()
        {
          public final void a(View paramAnonymousView)
          {
            if ((Conversation.I(Conversation.this) == null) || (Conversation.I(Conversation.this).f == null) || (Conversation.I(Conversation.this).f.a == null) || ((!"video/mp4".equals(Conversation.I(Conversation.this).f.c)) && (!"image/gif".equals(Conversation.I(Conversation.this).f.c)))) {
              return;
            }
            paramAnonymousView = Conversation.Q(Conversation.this).findViewById(2131755224);
            paramAnonymousView.setVisibility(0);
            localObject.setVisibility(8);
            bu.a(new abg(Conversation.R(Conversation.this), Conversation.this.au, Conversation.I(Conversation.this).f.a, Conversation.I(Conversation.this).f.c, new hm(this, paramAnonymousView, localObject)), new String[0]);
          }
        });
      }
      if ((this.bI.getVisibility() != 0) || (this.bK < 0))
      {
        Log.i("conversation/showlinkpreview/start");
        a(this.bI, this.bJ);
      }
      if (!TextUtils.isEmpty(AcceptInviteLinkActivity.a(Uri.parse(this.bL.a)))) {
        bool = true;
      }
      View localView = this.bJ;
      String str1 = paramauf.b;
      String str2 = paramauf.c;
      byte[] arrayOfByte;
      if (TextUtils.isEmpty(paramauf.d))
      {
        localObject = paramauf.a;
        arrayOfByte = paramauf.g;
        if (paramauf.f == null) {
          break label323;
        }
      }
      label323:
      for (int i = paramauf.f.b;; i = -1)
      {
        jr.a(localView, str1, str2, bool, (String)localObject, arrayOfByte, null, i);
        return;
        localObject = paramauf.d;
        break;
      }
    }
    this.bL = null;
    Z();
    return;
    this.bL = null;
    Z();
  }
  
  public final void a(com.whatsapp.emoji.a parama)
  {
    parama = parama.a;
    int j = parama.length;
    int i = 0;
    while (i < j)
    {
      int k = parama[i];
      this.Y.a(k);
      i += 1;
    }
  }
  
  public final void a(com.whatsapp.gif_search.j paramj)
  {
    if (this.R.a(this.W.t))
    {
      a.a.a.a.d.a(this, 106);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.t);
    int i;
    if (paramj.c.b > 0)
    {
      i = paramj.c.b;
      if (paramj.c.c <= 0) {
        break label159;
      }
    }
    label159:
    for (int j = paramj.c.c;; j = paramj.a.c)
    {
      startActivityForResult(GifVideoPreviewActivity.a(this, localArrayList, paramj.a.a, paramj.c.a, paramj.b.a, paramj.d, this.A, false, 22).putExtra("media_width", i).putExtra("media_height", j).putExtra("jid", this.t), 25);
      return;
      i = paramj.a.b;
      break;
    }
  }
  
  final void a(String paramString1, String paramString2)
  {
    try
    {
      Intent localIntent = new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI);
      localIntent.putExtra("phone", paramString1);
      if (paramString2 != null) {
        localIntent.putExtra("name", paramString2);
      }
      startActivityForResult(localIntent, 11);
      u = false;
      return;
    }
    catch (ActivityNotFoundException paramString1)
    {
      Log.c("conversation/opt system contact list could not found", paramString1);
      a.a.a.a.d.a(this, 12);
      return;
    }
    catch (SecurityException paramString1)
    {
      for (;;) {}
    }
  }
  
  final boolean a(int paramInt, String paramString)
  {
    boolean bool = false;
    if (paramInt == 2131755029) {
      if (paramString != null)
      {
        String str = paramString.substring(0, paramString.indexOf("@"));
        cs localcs = this.ae.c(paramString);
        if ((localcs != null) && (localcs.f()))
        {
          paramString = localcs.j();
          a("+" + str, paramString);
          label79:
          bool = true;
        }
      }
    }
    do
    {
      return bool;
      paramString = this.Q.n(paramString);
      break;
      Log.w("conversation/add-contact-failed");
      pv.a(this, 2131296941, 0);
      break label79;
      if (paramInt == 2131755030)
      {
        if (paramString != null)
        {
          paramString = paramString.substring(0, paramString.indexOf("@"));
          c("+" + paramString);
        }
        for (;;)
        {
          return true;
          Log.w("conversation/add-contact-failed");
          pv.a(this, 2131296941, 0);
        }
      }
      if (paramInt == 2131755058)
      {
        if (paramString != null)
        {
          startActivity(a(this.ae.d(paramString).t));
          finish();
        }
        for (;;)
        {
          return true;
          Log.e("conversation/message-contact/error no-resource");
        }
      }
      if (paramInt == 2131755086)
      {
        if (paramString != null)
        {
          paramString = this.ae.d(paramString);
          this.aB.a(paramString, this, Integer.valueOf(8), false, false);
        }
        for (;;)
        {
          return true;
          Log.e("conversation/call-contact/error no-resource");
        }
      }
    } while (paramInt != 2131755085);
    if (paramString != null)
    {
      paramString = this.ae.d(paramString);
      this.aB.a(paramString, this, Integer.valueOf(8), false, true);
    }
    for (;;)
    {
      return true;
      Log.e("conversation/call-contact/error no-resource");
    }
  }
  
  public void animateStar(final View paramView)
  {
    final ImageView localImageView = new ImageView(this);
    localImageView.setImageResource(2130840368);
    localImageView.setVisibility(4);
    localImageView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        localImageView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        int i = localImageView.getDrawable().getIntrinsicWidth();
        int j = localImageView.getDrawable().getIntrinsicHeight();
        Object localObject1 = new int[2];
        paramView.getLocationOnScreen((int[])localObject1);
        Object localObject2 = new int[2];
        Conversation.b(Conversation.this).getLocationOnScreen((int[])localObject2);
        int n = localObject1[0];
        int i1 = localObject2[0];
        int k = localObject1[1];
        int m = localObject2[1];
        n = n - i1 - (i - paramView.getWidth()) / 2;
        k = k - m - (j - paramView.getHeight()) / 2;
        localImageView.setVisibility(0);
        localObject1 = new AnimationSet(true);
        localObject2 = new TranslateAnimation(n, n, k, k - j * 2.0F);
        float f = ((ImageView)paramView).getDrawable().getIntrinsicWidth() / i;
        ScaleAnimation localScaleAnimation = new ScaleAnimation(f, 1.0F, f, 1.0F, 1, 0.5F, 1, 0.5F);
        ((AnimationSet)localObject1).addAnimation(new AlphaAnimation(0.5F, 0.0F));
        ((AnimationSet)localObject1).addAnimation(localScaleAnimation);
        ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
        ((AnimationSet)localObject1).setDuration(2000L);
        ((AnimationSet)localObject1).setInterpolator(new DecelerateInterpolator(2.0F));
        ((AnimationSet)localObject1).setAnimationListener(new Animation.AnimationListener()
        {
          public final void onAnimationEnd(Animation paramAnonymous2Animation)
          {
            Conversation.22.this.a.post(hq.a(this, Conversation.22.this.a));
          }
          
          public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
          
          public final void onAnimationStart(Animation paramAnonymous2Animation) {}
        });
        localImageView.startAnimation((Animation)localObject1);
      }
    });
    this.K.addView(localImageView);
  }
  
  final void c(String paramString)
  {
    try
    {
      Intent localIntent = new Intent("android.intent.action.INSERT_OR_EDIT");
      localIntent.setType("vnd.android.cursor.item/contact");
      localIntent.putExtra("phone", paramString);
      localIntent.putExtra("phone_type", 2);
      localIntent.setFlags(524288);
      startActivityForResult(localIntent, 13);
      u = false;
      return;
    }
    catch (ActivityNotFoundException paramString)
    {
      a.a.a.a.d.a(this, 12);
    }
  }
  
  final void c(boolean paramBoolean)
  {
    if (this.R.a(this.W.t))
    {
      a.a.a.a.d.a(this, 106);
      return;
    }
    String str2 = this.cU.getStringText().trim();
    String str1 = str2;
    if (this.bb)
    {
      str1 = str2;
      if (com.whatsapp.util.a.d())
      {
        str1 = str2;
        if (str2.contains("­")) {
          str1 = str2.replace("­", "");
        }
      }
    }
    if (!be.b(this, this.aE, str1))
    {
      pv.a(this, 2131296401, 1);
      return;
    }
    if (paramBoolean) {
      str1 = be.b(str1);
    }
    for (;;)
    {
      this.bN = null;
      this.bI.setVisibility(8);
      this.bP.setVisibility(8);
      e(2130840040);
      if (str1.length() > 0)
      {
        this.cv.a(Collections.singletonList(this.W.t), com.whatsapp.emoji.c.b(str1), this.bL, this.L, this.cU.getMentions(), this.A, this.bb);
        X();
        v();
      }
      this.bL = null;
      if ((!this.aW.isFullscreenMode()) && ((this.cU.getHeight() + this.U.getHeight() << 2 >= getWindow().getDecorView().getHeight()) || (getResources().getConfiguration().orientation != 2))) {
        break;
      }
      aq();
      if (!this.G.isShowing()) {
        break;
      }
      this.G.dismiss();
      return;
      if (str1.codePointCount(0, str1.length()) > 65536)
      {
        a.a.a.a.d.a(this, 17);
        return;
      }
    }
  }
  
  final int d(int paramInt)
  {
    int i = 1;
    int j = 2130840037;
    switch (paramInt)
    {
    default: 
      paramInt = 2130840040;
    case 0: 
      do
      {
        return paramInt;
        paramInt = j;
      } while (!this.cU.getIsMentionPickerVisible());
      return 2130840038;
    case 1: 
      if (this.cU.getIsMentionPickerVisible()) {
        return 2130840038;
      }
      if ((this.bP.getVisibility() == 0) && (this.bI.getVisibility() == 0)) {}
      for (;;)
      {
        paramInt = j;
        if (i != 0) {
          break;
        }
        return 2130840040;
        i = 0;
      }
    }
    if ((this.bP.getVisibility() == 0) || (this.bI.getVisibility() == 0)) {}
    for (i = 1;; i = 0)
    {
      paramInt = j;
      if (i != 0) {
        break;
      }
      return 2130840040;
    }
  }
  
  final int d(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 100;
    }
    int i = getWindowManager().getDefaultDisplay().getHeight() * 2 / getResources().getDimensionPixelSize(2131361938);
    if (this.bh > i - 10)
    {
      Log.i("conversation/page size (from unseen):" + (this.bh + 10));
      return this.bh + 10;
    }
    Log.i("conversation/page size:" + i);
    return i;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.bc) {}
    while (yx.g()) {
      return false;
    }
    if ((paramMotionEvent.getAction() == 1) && (this.bQ.a()))
    {
      this.bE.getLocationOnScreen(this.du);
      if ((paramMotionEvent.getRawY() >= this.du[1]) && (paramMotionEvent.getRawY() < this.du[1] + this.bE.getHeight()))
      {
        this.bQ.a(true);
        this.bE.requestFocus();
      }
    }
    try
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (ActivityNotFoundException paramMotionEvent)
    {
      Log.e("conversation/dispatch-touch-event " + paramMotionEvent.toString());
      pv.a(this, 2131296289, 0);
      return false;
    }
    catch (IllegalArgumentException paramMotionEvent)
    {
      Log.e("conversation/dispatch-touch-event " + paramMotionEvent.toString());
      return false;
    }
    catch (ArrayIndexOutOfBoundsException paramMotionEvent)
    {
      Log.e("conversation/dispatch-touch-event " + paramMotionEvent.toString());
    }
    return false;
  }
  
  final void e(int paramInt)
  {
    a(new az(android.support.v4.content.b.a(this, paramInt)));
  }
  
  final void e(boolean paramBoolean)
  {
    if (!RequestPermissionActivity.a(this, this.aP, 30)) {}
    while (!this.aI.a(this.cj)) {
      return;
    }
    if (vv.f() < aic.s << 10 << 10)
    {
      b_(2131296742);
      return;
    }
    if (this.R.a(this.t))
    {
      a.a.a.a.d.a(this, 106);
      return;
    }
    Intent localIntent = new Intent(this, CameraActivity.class);
    localIntent.putExtra("jid", this.t);
    long l;
    if (this.L == null)
    {
      l = 0L;
      localIntent.putExtra("quoted_message_row_id", l);
      localIntent.putExtra("chat_opened_from_url", this.A);
      if (!paramBoolean) {
        break label166;
      }
    }
    label166:
    for (int i = 3;; i = 2)
    {
      localIntent.putExtra("origin", i);
      startActivity(localIntent);
      return;
      l = this.L.Q;
      break;
    }
  }
  
  final void f(int paramInt)
  {
    int j;
    int i;
    if ((this.U.getFirstVisiblePosition() >= paramInt) || (this.U.getLastVisiblePosition() <= paramInt))
    {
      j = getResources().getDimensionPixelSize(2131361938);
      this.U.setTranscriptMode(0);
      if (Build.VERSION.SDK_INT < 11) {
        break label100;
      }
      ListView localListView = this.U;
      if (this.U.getFirstVisiblePosition() < paramInt) {
        break label95;
      }
      i = 1;
      localListView.setSelectionFromTop(i + paramInt, j);
      this.U.smoothScrollToPositionFromTop(paramInt, j);
    }
    for (;;)
    {
      this.C.setVisibility(0);
      return;
      label95:
      i = -1;
      break;
      label100:
      this.U.setSelectionFromTop(paramInt, j);
    }
  }
  
  public final void m()
  {
    this.U.setTranscriptMode(2);
    this.ci.sendEmptyMessageDelayed(0, 1000L);
    v();
  }
  
  public final void n()
  {
    u();
  }
  
  final void o()
  {
    if ((h(37)) && (this.aI.a(this.cj)))
    {
      MediaFileUtils.a(this.au, 5, this);
      u = false;
    }
  }
  
  /* Error */
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifne +109 -> 110
    //   4: aload_3
    //   5: ifnull +105 -> 110
    //   8: aload_3
    //   9: ldc_w 3134
    //   12: iconst_0
    //   13: invokevirtual 1795	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   16: ifeq +26 -> 42
    //   19: ldc_w 3136
    //   22: invokestatic 1661	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   25: aload_0
    //   26: getfield 1196	com/whatsapp/Conversation:aq	Lcom/whatsapp/pv;
    //   29: aload_0
    //   30: invokestatic 493	com/whatsapp/u:a	()Landroid/content/Context;
    //   33: ldc_w 3137
    //   36: invokevirtual 1492	android/content/Context:getString	(I)Ljava/lang/String;
    //   39: invokevirtual 3139	com/whatsapp/pv:a	(Lcom/whatsapp/ng;Ljava/lang/String;)V
    //   42: aload_3
    //   43: ldc_w 3141
    //   46: iconst_0
    //   47: invokevirtual 1795	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   50: ifeq +26 -> 76
    //   53: ldc_w 3143
    //   56: invokestatic 1661	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   59: aload_0
    //   60: getfield 1196	com/whatsapp/Conversation:aq	Lcom/whatsapp/pv;
    //   63: aload_0
    //   64: invokestatic 493	com/whatsapp/u:a	()Landroid/content/Context;
    //   67: ldc_w 3110
    //   70: invokevirtual 1492	android/content/Context:getString	(I)Ljava/lang/String;
    //   73: invokevirtual 3139	com/whatsapp/pv:a	(Lcom/whatsapp/ng;Ljava/lang/String;)V
    //   76: aload_3
    //   77: ldc_w 3145
    //   80: iconst_0
    //   81: invokevirtual 1795	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   84: ifeq +26 -> 110
    //   87: ldc_w 3147
    //   90: invokestatic 1661	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   93: aload_0
    //   94: getfield 1196	com/whatsapp/Conversation:aq	Lcom/whatsapp/pv;
    //   97: aload_0
    //   98: invokestatic 493	com/whatsapp/u:a	()Landroid/content/Context;
    //   101: ldc_w 3148
    //   104: invokevirtual 1492	android/content/Context:getString	(I)Ljava/lang/String;
    //   107: invokevirtual 3139	com/whatsapp/pv:a	(Lcom/whatsapp/ng;Ljava/lang/String;)V
    //   110: iload_1
    //   111: lookupswitch	default:+225->336, 1:+2070->2181, 2:+237->348, 4:+972->1083, 5:+482->593, 6:+851->962, 7:+1113->1224, 8:+1100->1211, 11:+412->523, 13:+412->523, 17:+1235->1346, 18:+1184->1295, 19:+1844->1955, 20:+1908->2019, 21:+461->572, 23:+422->533, 25:+568->679, 27:+834->945, 30:+1966->2077, 31:+1979->2090, 32:+1991->2102, 34:+2015->2126, 35:+2022->2133, 36:+2034->2145, 37:+2046->2157, 38:+2058->2169, 41:+2099->2210, 150:+2003->2114
    //   336: aload_0
    //   337: iload_1
    //   338: iload_2
    //   339: aload_3
    //   340: invokespecial 3150	com/whatsapp/jw:onActivityResult	(IILandroid/content/Intent;)V
    //   343: iconst_1
    //   344: putstatic 465	com/whatsapp/Conversation:u	Z
    //   347: return
    //   348: iload_2
    //   349: iconst_m1
    //   350: if_icmpne -7 -> 343
    //   353: aload_0
    //   354: invokevirtual 3153	com/whatsapp/Conversation:Q	()Ljava/util/Collection;
    //   357: astore 5
    //   359: aload 5
    //   361: invokeinterface 3157 1 0
    //   366: ifne +140 -> 506
    //   369: aload_3
    //   370: ldc_w 3159
    //   373: invokevirtual 2020	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   376: astore_3
    //   377: aload 5
    //   379: invokestatic 3162	com/whatsapp/lt:a	(Ljava/util/Collection;)Ljava/util/ArrayList;
    //   382: invokevirtual 1527	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   385: astore 5
    //   387: aload 5
    //   389: invokeinterface 1127 1 0
    //   394: ifeq +32 -> 426
    //   397: aload 5
    //   399: invokeinterface 1131 1 0
    //   404: checkcast 1347	com/whatsapp/protocol/j
    //   407: astore 6
    //   409: aload_0
    //   410: getfield 623	com/whatsapp/Conversation:cv	Lcom/whatsapp/aoj;
    //   413: aload_0
    //   414: getfield 1837	com/whatsapp/Conversation:as	Lcom/whatsapp/ahx;
    //   417: aload 6
    //   419: aload_3
    //   420: invokevirtual 3165	com/whatsapp/aoj:a	(Lcom/whatsapp/ahx;Lcom/whatsapp/protocol/j;Ljava/util/List;)V
    //   423: goto -36 -> 387
    //   426: aload_3
    //   427: invokevirtual 1524	java/util/ArrayList:size	()I
    //   430: iconst_1
    //   431: if_icmpne +64 -> 495
    //   434: aload_3
    //   435: iconst_0
    //   436: invokevirtual 1642	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   439: checkcast 420	java/lang/String
    //   442: invokestatic 3167	com/whatsapp/protocol/j:c	(Ljava/lang/String;)Z
    //   445: ifne +50 -> 495
    //   448: aload_0
    //   449: getfield 1303	com/whatsapp/Conversation:t	Ljava/lang/String;
    //   452: aload_3
    //   453: iconst_0
    //   454: invokevirtual 1642	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   457: invokevirtual 1367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   460: ifne +28 -> 488
    //   463: aload_0
    //   464: aload_0
    //   465: getfield 1634	com/whatsapp/Conversation:ae	Lcom/whatsapp/data/e;
    //   468: aload_3
    //   469: iconst_0
    //   470: invokevirtual 1642	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   473: checkcast 420	java/lang/String
    //   476: invokevirtual 2220	com/whatsapp/data/e:d	(Ljava/lang/String;)Lcom/whatsapp/data/cs;
    //   479: getfield 1023	com/whatsapp/data/cs:t	Ljava/lang/String;
    //   482: invokestatic 1026	com/whatsapp/Conversation:a	(Ljava/lang/String;)Landroid/content/Intent;
    //   485: invokevirtual 1674	com/whatsapp/Conversation:startActivity	(Landroid/content/Intent;)V
    //   488: aload_0
    //   489: invokevirtual 3169	com/whatsapp/Conversation:P	()V
    //   492: goto -149 -> 343
    //   495: aload_0
    //   496: invokevirtual 2843	com/whatsapp/Conversation:getBaseContext	()Landroid/content/Context;
    //   499: aload_3
    //   500: invokestatic 3172	com/whatsapp/pv:a	(Landroid/content/Context;Ljava/util/List;)V
    //   503: goto -15 -> 488
    //   506: ldc_w 3174
    //   509: invokestatic 2192	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   512: aload_0
    //   513: ldc_w 3175
    //   516: iconst_0
    //   517: invokestatic 2726	com/whatsapp/pv:a	(Landroid/content/Context;II)V
    //   520: goto -32 -> 488
    //   523: aload_0
    //   524: getfield 3178	com/whatsapp/Conversation:aH	Lcom/whatsapp/contact/sync/i;
    //   527: invokevirtual 3181	com/whatsapp/contact/sync/i:b	()V
    //   530: goto -187 -> 343
    //   533: iload_2
    //   534: iconst_m1
    //   535: if_icmpne +26 -> 561
    //   538: aload_0
    //   539: invokestatic 3184	com/whatsapp/util/MediaFileUtils:b	(Landroid/content/Context;)Ljava/io/File;
    //   542: invokestatic 1313	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   545: astore_3
    //   546: aload_0
    //   547: aload_3
    //   548: invokestatic 1172	com/whatsapp/util/MediaFileUtils:a	(Landroid/content/Context;Landroid/net/Uri;)V
    //   551: aload_0
    //   552: aload_3
    //   553: bipush 8
    //   555: invokevirtual 3186	com/whatsapp/Conversation:a	(Landroid/net/Uri;I)V
    //   558: goto -215 -> 343
    //   561: iload_2
    //   562: ifne -219 -> 343
    //   565: aload_0
    //   566: invokestatic 3188	com/whatsapp/util/MediaFileUtils:a	(Landroid/content/Context;)V
    //   569: goto -226 -> 343
    //   572: aload_3
    //   573: ifnull -230 -> 343
    //   576: iload_2
    //   577: iconst_m1
    //   578: if_icmpne -235 -> 343
    //   581: aload_0
    //   582: aload_3
    //   583: invokevirtual 1104	android/content/Intent:getData	()Landroid/net/Uri;
    //   586: iconst_1
    //   587: invokevirtual 3186	com/whatsapp/Conversation:a	(Landroid/net/Uri;I)V
    //   590: goto -247 -> 343
    //   593: iload_2
    //   594: iconst_m1
    //   595: if_icmpne -252 -> 343
    //   598: aload_3
    //   599: invokevirtual 1104	android/content/Intent:getData	()Landroid/net/Uri;
    //   602: astore 5
    //   604: aload 5
    //   606: ifnonnull +23 -> 629
    //   609: ldc_w 3190
    //   612: invokestatic 2192	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   615: aload_0
    //   616: invokevirtual 2843	com/whatsapp/Conversation:getBaseContext	()Landroid/content/Context;
    //   619: ldc_w 2844
    //   622: iconst_0
    //   623: invokestatic 2726	com/whatsapp/pv:a	(Landroid/content/Context;II)V
    //   626: goto -283 -> 343
    //   629: aload_3
    //   630: ldc_w 3192
    //   633: iconst_1
    //   634: invokevirtual 1795	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   637: istore 4
    //   639: aload_0
    //   640: getfield 1196	com/whatsapp/Conversation:aq	Lcom/whatsapp/pv;
    //   643: aload_0
    //   644: getfield 602	com/whatsapp/Conversation:cs	Lcom/whatsapp/va;
    //   647: aload_0
    //   648: getfield 2207	com/whatsapp/Conversation:au	Lcom/whatsapp/oz;
    //   651: aload_0
    //   652: getfield 1875	com/whatsapp/Conversation:aE	Lcom/whatsapp/and;
    //   655: aload 5
    //   657: aload_0
    //   658: new 3194	com/whatsapp/gz
    //   661: dup
    //   662: aload_0
    //   663: iload 4
    //   665: invokespecial 3195	com/whatsapp/gz:<init>	(Lcom/whatsapp/Conversation;Z)V
    //   668: invokestatic 3198	com/whatsapp/util/MediaFileUtils:a	(Lcom/whatsapp/pv;Lcom/whatsapp/va;Lcom/whatsapp/oz;Lcom/whatsapp/and;Landroid/net/Uri;Lcom/whatsapp/ng;Lcom/whatsapp/util/MediaFileUtils$d;)V
    //   671: aload_0
    //   672: iconst_1
    //   673: putfield 1830	com/whatsapp/Conversation:dy	Z
    //   676: goto -333 -> 343
    //   679: iload_2
    //   680: iconst_m1
    //   681: if_icmpne -338 -> 343
    //   684: aload_3
    //   685: ldc_w 3200
    //   688: invokevirtual 1588	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   691: astore 5
    //   693: aload_3
    //   694: ldc_w 3202
    //   697: invokevirtual 1588	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   700: astore 8
    //   702: aload 5
    //   704: invokestatic 1865	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   707: ifeq +11 -> 718
    //   710: aload 8
    //   712: invokestatic 1865	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   715: ifne +157 -> 872
    //   718: aconst_null
    //   719: astore 6
    //   721: new 3204	com/whatsapp/MediaData
    //   724: dup
    //   725: invokespecial 3205	com/whatsapp/MediaData:<init>	()V
    //   728: astore 7
    //   730: aload 5
    //   732: invokestatic 1865	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   735: ifne +144 -> 879
    //   738: aload 7
    //   740: new 1289	java/io/File
    //   743: dup
    //   744: aload 5
    //   746: invokespecial 1309	java/io/File:<init>	(Ljava/lang/String;)V
    //   749: putfield 3209	com/whatsapp/MediaData:file	Ljava/io/File;
    //   752: aload 7
    //   754: getfield 3209	com/whatsapp/MediaData:file	Ljava/io/File;
    //   757: invokevirtual 1292	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   760: invokestatic 3212	com/whatsapp/util/MediaFileUtils:d	(Ljava/lang/String;)[B
    //   763: astore 5
    //   765: aload 6
    //   767: ifnonnull +11 -> 778
    //   770: aload 7
    //   772: getfield 3209	com/whatsapp/MediaData:file	Ljava/io/File;
    //   775: ifnull +97 -> 872
    //   778: aload 7
    //   780: aload_3
    //   781: ldc_w 3214
    //   784: iconst_0
    //   785: invokevirtual 1850	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   788: invokestatic 3217	com/whatsapp/MediaData:toGifAttribution	(I)I
    //   791: putfield 3220	com/whatsapp/MediaData:gifAttribution	I
    //   794: aload_0
    //   795: getfield 623	com/whatsapp/Conversation:cv	Lcom/whatsapp/aoj;
    //   798: aload_0
    //   799: getfield 637	com/whatsapp/Conversation:cx	Lcom/whatsapp/vp;
    //   802: aload_0
    //   803: getfield 1303	com/whatsapp/Conversation:t	Ljava/lang/String;
    //   806: aload 7
    //   808: bipush 13
    //   810: iconst_0
    //   811: aload_3
    //   812: ldc_w 3222
    //   815: invokevirtual 1588	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   818: aload 6
    //   820: aload_0
    //   821: getfield 893	com/whatsapp/Conversation:L	Lcom/whatsapp/protocol/j;
    //   824: aconst_null
    //   825: aload_3
    //   826: ldc_w 1335
    //   829: invokevirtual 2020	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   832: aload_0
    //   833: getfield 1809	com/whatsapp/Conversation:A	Z
    //   836: invokevirtual 3225	com/whatsapp/vp:a	(Ljava/lang/String;Lcom/whatsapp/MediaData;BILjava/lang/String;Landroid/net/Uri;Lcom/whatsapp/protocol/j;Ljava/lang/String;Ljava/util/List;Z)Lcom/whatsapp/protocol/j;
    //   839: aload 5
    //   841: invokevirtual 3228	com/whatsapp/aoj:a	(Lcom/whatsapp/protocol/j;[B)V
    //   844: aload_0
    //   845: iconst_1
    //   846: putfield 1830	com/whatsapp/Conversation:dy	Z
    //   849: aload_0
    //   850: getfield 3080	com/whatsapp/Conversation:bQ	Lcom/whatsapp/gif_search/f;
    //   853: iconst_0
    //   854: invokevirtual 3089	com/whatsapp/gif_search/f:a	(Z)V
    //   857: aload_3
    //   858: ldc_w 3230
    //   861: iconst_0
    //   862: invokevirtual 1795	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   865: ifeq +7 -> 872
    //   868: aload_0
    //   869: invokespecial 3039	com/whatsapp/Conversation:X	()V
    //   872: aload_0
    //   873: invokevirtual 3041	com/whatsapp/Conversation:v	()V
    //   876: goto -533 -> 343
    //   879: aload 8
    //   881: invokestatic 1667	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   884: astore 6
    //   886: aload 7
    //   888: aload_3
    //   889: ldc_w 2927
    //   892: iconst_m1
    //   893: invokevirtual 1850	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   896: putfield 3233	com/whatsapp/MediaData:width	I
    //   899: aload 7
    //   901: aload_3
    //   902: ldc_w 2929
    //   905: iconst_m1
    //   906: invokevirtual 1850	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   909: putfield 3236	com/whatsapp/MediaData:height	I
    //   912: aload_3
    //   913: ldc_w 3238
    //   916: invokevirtual 1588	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   919: astore 5
    //   921: aload 5
    //   923: ifnull +16 -> 939
    //   926: invokestatic 3243	com/whatsapp/gif_search/h:a	()Lcom/whatsapp/gif_search/h;
    //   929: aload 5
    //   931: invokevirtual 3245	com/whatsapp/gif_search/h:a	(Ljava/lang/String;)[B
    //   934: astore 5
    //   936: goto -171 -> 765
    //   939: aconst_null
    //   940: astore 5
    //   942: goto -177 -> 765
    //   945: iload_2
    //   946: iconst_m1
    //   947: if_icmpne -604 -> 343
    //   950: aload_0
    //   951: iconst_1
    //   952: putfield 1830	com/whatsapp/Conversation:dy	Z
    //   955: aload_0
    //   956: invokespecial 3039	com/whatsapp/Conversation:X	()V
    //   959: goto -616 -> 343
    //   962: iload_2
    //   963: iconst_m1
    //   964: if_icmpne -621 -> 343
    //   967: aload_3
    //   968: invokevirtual 1104	android/content/Intent:getData	()Landroid/net/Uri;
    //   971: astore 5
    //   973: aload 5
    //   975: ifnull +37 -> 1012
    //   978: aload_0
    //   979: getfield 1837	com/whatsapp/Conversation:as	Lcom/whatsapp/ahx;
    //   982: aload_0
    //   983: getfield 1303	com/whatsapp/Conversation:t	Ljava/lang/String;
    //   986: aload 5
    //   988: aload_0
    //   989: getfield 1875	com/whatsapp/Conversation:aE	Lcom/whatsapp/and;
    //   992: aload 5
    //   994: invokestatic 3248	com/whatsapp/util/MediaFileUtils:d	(Lcom/whatsapp/and;Landroid/net/Uri;)Ljava/lang/String;
    //   997: aload_0
    //   998: getfield 893	com/whatsapp/Conversation:L	Lcom/whatsapp/protocol/j;
    //   1001: aload_0
    //   1002: aload_0
    //   1003: getfield 1809	com/whatsapp/Conversation:A	Z
    //   1006: invokevirtual 3251	com/whatsapp/ahx:a	(Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;Lcom/whatsapp/protocol/j;Lcom/whatsapp/ng;Z)V
    //   1009: goto -666 -> 343
    //   1012: aload_3
    //   1013: ldc_w 1315
    //   1016: invokevirtual 1833	android/content/Intent:getParcelableArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   1019: astore_3
    //   1020: aload_3
    //   1021: ifnull -678 -> 343
    //   1024: aload_3
    //   1025: invokevirtual 1527	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1028: astore_3
    //   1029: aload_3
    //   1030: invokeinterface 1127 1 0
    //   1035: ifeq -692 -> 343
    //   1038: aload_3
    //   1039: invokeinterface 1131 1 0
    //   1044: checkcast 1106	android/net/Uri
    //   1047: astore 5
    //   1049: aload_0
    //   1050: getfield 1837	com/whatsapp/Conversation:as	Lcom/whatsapp/ahx;
    //   1053: aload_0
    //   1054: getfield 1303	com/whatsapp/Conversation:t	Ljava/lang/String;
    //   1057: aload 5
    //   1059: aload_0
    //   1060: getfield 1875	com/whatsapp/Conversation:aE	Lcom/whatsapp/and;
    //   1063: aload 5
    //   1065: invokestatic 3248	com/whatsapp/util/MediaFileUtils:d	(Lcom/whatsapp/and;Landroid/net/Uri;)Ljava/lang/String;
    //   1068: aload_0
    //   1069: getfield 893	com/whatsapp/Conversation:L	Lcom/whatsapp/protocol/j;
    //   1072: aload_0
    //   1073: aload_0
    //   1074: getfield 1809	com/whatsapp/Conversation:A	Z
    //   1077: invokevirtual 3251	com/whatsapp/ahx:a	(Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;Lcom/whatsapp/protocol/j;Lcom/whatsapp/ng;Z)V
    //   1080: goto -51 -> 1029
    //   1083: iload_2
    //   1084: iconst_m1
    //   1085: if_icmpne +107 -> 1192
    //   1088: aconst_null
    //   1089: astore 5
    //   1091: aload_3
    //   1092: ifnull +39 -> 1131
    //   1095: aload_3
    //   1096: invokevirtual 1104	android/content/Intent:getData	()Landroid/net/Uri;
    //   1099: ifnull +32 -> 1131
    //   1102: aload_3
    //   1103: invokevirtual 1104	android/content/Intent:getData	()Landroid/net/Uri;
    //   1106: astore_3
    //   1107: aload_3
    //   1108: ifnonnull +74 -> 1182
    //   1111: ldc_w 3253
    //   1114: invokestatic 2192	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   1117: aload_0
    //   1118: invokevirtual 2843	com/whatsapp/Conversation:getBaseContext	()Landroid/content/Context;
    //   1121: ldc_w 2844
    //   1124: iconst_0
    //   1125: invokestatic 2726	com/whatsapp/pv:a	(Landroid/content/Context;II)V
    //   1128: goto -785 -> 343
    //   1131: aload_0
    //   1132: invokestatic 3184	com/whatsapp/util/MediaFileUtils:b	(Landroid/content/Context;)Ljava/io/File;
    //   1135: astore_3
    //   1136: aload_3
    //   1137: invokevirtual 3256	java/io/File:exists	()Z
    //   1140: ifeq +16 -> 1156
    //   1143: aload_3
    //   1144: invokestatic 1313	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   1147: astore_3
    //   1148: aload_0
    //   1149: aload_3
    //   1150: invokestatic 1172	com/whatsapp/util/MediaFileUtils:a	(Landroid/content/Context;Landroid/net/Uri;)V
    //   1153: goto -46 -> 1107
    //   1156: new 428	java/lang/StringBuilder
    //   1159: dup
    //   1160: ldc_w 3258
    //   1163: invokespecial 990	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1166: aload_3
    //   1167: invokevirtual 3261	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1170: invokevirtual 445	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1173: invokestatic 1661	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   1176: aload 5
    //   1178: astore_3
    //   1179: goto -72 -> 1107
    //   1182: aload_0
    //   1183: aload_3
    //   1184: bipush 8
    //   1186: invokevirtual 3186	com/whatsapp/Conversation:a	(Landroid/net/Uri;I)V
    //   1189: goto -846 -> 343
    //   1192: iload_2
    //   1193: ifne -850 -> 343
    //   1196: getstatic 1699	android/os/Build$VERSION:SDK_INT	I
    //   1199: bipush 18
    //   1201: if_icmplt -858 -> 343
    //   1204: aload_0
    //   1205: invokestatic 3188	com/whatsapp/util/MediaFileUtils:a	(Landroid/content/Context;)V
    //   1208: goto -865 -> 343
    //   1211: iload_2
    //   1212: iconst_m1
    //   1213: if_icmpne -870 -> 343
    //   1216: aload_0
    //   1217: iconst_1
    //   1218: putfield 1830	com/whatsapp/Conversation:dy	Z
    //   1221: goto -878 -> 343
    //   1224: iload_2
    //   1225: iconst_m1
    //   1226: if_icmpne -883 -> 343
    //   1229: aload_0
    //   1230: getfield 2005	com/whatsapp/Conversation:aP	Lcom/whatsapp/atu;
    //   1233: ldc_w 3263
    //   1236: invokevirtual 3264	com/whatsapp/atu:a	(Ljava/lang/String;)I
    //   1239: ifeq +10 -> 1249
    //   1242: ldc_w 3266
    //   1245: invokestatic 2192	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   1248: return
    //   1249: aload_0
    //   1250: getfield 1174	com/whatsapp/Conversation:W	Lcom/whatsapp/data/cs;
    //   1253: getfield 1023	com/whatsapp/data/cs:t	Ljava/lang/String;
    //   1256: aload_3
    //   1257: invokevirtual 1104	android/content/Intent:getData	()Landroid/net/Uri;
    //   1260: aload_0
    //   1261: getfield 893	com/whatsapp/Conversation:L	Lcom/whatsapp/protocol/j;
    //   1264: aload_0
    //   1265: getfield 1809	com/whatsapp/Conversation:A	Z
    //   1268: aload_0
    //   1269: getfield 1634	com/whatsapp/Conversation:ae	Lcom/whatsapp/data/e;
    //   1272: aload_0
    //   1273: getfield 1875	com/whatsapp/Conversation:aE	Lcom/whatsapp/and;
    //   1276: aload_0
    //   1277: invokestatic 3271	com/whatsapp/ViewSharedContactArrayActivity:a	(Ljava/lang/String;Landroid/net/Uri;Lcom/whatsapp/protocol/j;ZLcom/whatsapp/data/e;Lcom/whatsapp/and;Landroid/app/Activity;)Landroid/content/Intent;
    //   1280: astore_3
    //   1281: aload_3
    //   1282: ifnull -939 -> 343
    //   1285: aload_0
    //   1286: aload_3
    //   1287: bipush 8
    //   1289: invokevirtual 1363	com/whatsapp/Conversation:startActivityForResult	(Landroid/content/Intent;I)V
    //   1292: goto -949 -> 343
    //   1295: iload_2
    //   1296: iconst_m1
    //   1297: if_icmpne +29 -> 1326
    //   1300: aload_3
    //   1301: ifnull +25 -> 1326
    //   1304: aload_3
    //   1305: invokevirtual 1104	android/content/Intent:getData	()Landroid/net/Uri;
    //   1308: ifnull +18 -> 1326
    //   1311: aload_0
    //   1312: aload_3
    //   1313: invokevirtual 1104	android/content/Intent:getData	()Landroid/net/Uri;
    //   1316: iconst_m1
    //   1317: iconst_m1
    //   1318: iconst_0
    //   1319: iconst_0
    //   1320: invokespecial 3273	com/whatsapp/Conversation:a	(Landroid/net/Uri;IIII)V
    //   1323: goto -980 -> 343
    //   1326: iload_2
    //   1327: ifne -984 -> 343
    //   1330: aload_3
    //   1331: ifnull -988 -> 343
    //   1334: aload_0
    //   1335: getfield 1196	com/whatsapp/Conversation:aq	Lcom/whatsapp/pv;
    //   1338: aload_3
    //   1339: aload_0
    //   1340: invokestatic 3278	com/whatsapp/crop/CropImage:a	(Lcom/whatsapp/pv;Landroid/content/Intent;Lcom/whatsapp/ng;)V
    //   1343: goto -1000 -> 343
    //   1346: iload_2
    //   1347: iconst_m1
    //   1348: if_icmpne +294 -> 1642
    //   1351: aload_3
    //   1352: ifnull +290 -> 1642
    //   1355: aload_0
    //   1356: invokestatic 3281	com/whatsapp/wallpaper/g:f	(Landroid/content/Context;)Landroid/graphics/Point;
    //   1359: astore 8
    //   1361: aload_3
    //   1362: invokevirtual 1104	android/content/Intent:getData	()Landroid/net/Uri;
    //   1365: ifnull +325 -> 1690
    //   1368: new 428	java/lang/StringBuilder
    //   1371: dup
    //   1372: ldc_w 3283
    //   1375: invokespecial 990	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1378: aload_3
    //   1379: invokevirtual 1104	android/content/Intent:getData	()Landroid/net/Uri;
    //   1382: invokevirtual 1596	android/net/Uri:toString	()Ljava/lang/String;
    //   1385: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1388: invokevirtual 445	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1391: invokestatic 997	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1394: aload_0
    //   1395: getfield 1875	com/whatsapp/Conversation:aE	Lcom/whatsapp/and;
    //   1398: getfield 3288	com/whatsapp/and:f	Landroid/content/ContentResolver;
    //   1401: astore 7
    //   1403: aload 7
    //   1405: ifnonnull +155 -> 1560
    //   1408: ldc_w 3290
    //   1411: invokestatic 2192	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   1414: aconst_null
    //   1415: astore 6
    //   1417: aload 6
    //   1419: ifnull +164 -> 1583
    //   1422: aload 6
    //   1424: invokeinterface 2307 1 0
    //   1429: pop
    //   1430: aload 6
    //   1432: ldc_w 3292
    //   1435: invokeinterface 3295 2 0
    //   1440: istore_1
    //   1441: iload_1
    //   1442: iflt +141 -> 1583
    //   1445: aload 6
    //   1447: iload_1
    //   1448: invokeinterface 3296 2 0
    //   1453: ldc_w 3298
    //   1456: invokevirtual 1367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1459: ifeq +124 -> 1583
    //   1462: new 3300	android/graphics/BitmapFactory$Options
    //   1465: dup
    //   1466: invokespecial 3301	android/graphics/BitmapFactory$Options:<init>	()V
    //   1469: astore 9
    //   1471: aload 9
    //   1473: iconst_1
    //   1474: putfield 3304	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1477: aconst_null
    //   1478: astore 5
    //   1480: aload 7
    //   1482: aload_3
    //   1483: invokevirtual 1104	android/content/Intent:getData	()Landroid/net/Uri;
    //   1486: invokevirtual 3310	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   1489: astore 7
    //   1491: aload 7
    //   1493: astore 5
    //   1495: aload 5
    //   1497: aconst_null
    //   1498: aload 9
    //   1500: invokestatic 3316	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1503: pop
    //   1504: aload 9
    //   1506: getfield 3319	android/graphics/BitmapFactory$Options:outWidth	I
    //   1509: aload 8
    //   1511: getfield 3323	android/graphics/Point:x	I
    //   1514: if_icmpne +64 -> 1578
    //   1517: aload 9
    //   1519: getfield 3326	android/graphics/BitmapFactory$Options:outHeight	I
    //   1522: aload 8
    //   1524: getfield 3328	android/graphics/Point:y	I
    //   1527: if_icmpne +51 -> 1578
    //   1530: aload_0
    //   1531: aload_3
    //   1532: invokevirtual 1104	android/content/Intent:getData	()Landroid/net/Uri;
    //   1535: iconst_m1
    //   1536: iconst_m1
    //   1537: iconst_0
    //   1538: iconst_0
    //   1539: invokespecial 3273	com/whatsapp/Conversation:a	(Landroid/net/Uri;IIII)V
    //   1542: aload 5
    //   1544: invokestatic 3331	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   1547: aload 6
    //   1549: ifnull -1202 -> 347
    //   1552: aload 6
    //   1554: invokeinterface 3334 1 0
    //   1559: return
    //   1560: aload 7
    //   1562: aload_3
    //   1563: invokevirtual 1104	android/content/Intent:getData	()Landroid/net/Uri;
    //   1566: aconst_null
    //   1567: aconst_null
    //   1568: aconst_null
    //   1569: aconst_null
    //   1570: invokevirtual 3338	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1573: astore 6
    //   1575: goto -158 -> 1417
    //   1578: aload 5
    //   1580: invokestatic 3331	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   1583: aload 6
    //   1585: ifnull +10 -> 1595
    //   1588: aload 6
    //   1590: invokeinterface 3334 1 0
    //   1595: new 1007	android/content/Intent
    //   1598: dup
    //   1599: aload_0
    //   1600: ldc_w 3340
    //   1603: invokespecial 1029	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   1606: astore 5
    //   1608: aload 5
    //   1610: aload_3
    //   1611: invokevirtual 1104	android/content/Intent:getData	()Landroid/net/Uri;
    //   1614: invokevirtual 1671	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   1617: pop
    //   1618: aload 5
    //   1620: ldc_w 3342
    //   1623: aload_0
    //   1624: getfield 721	com/whatsapp/Conversation:cH	Lcom/whatsapp/wallpaper/g;
    //   1627: invokevirtual 3344	com/whatsapp/wallpaper/g:b	()Landroid/net/Uri;
    //   1630: invokevirtual 3347	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   1633: pop
    //   1634: aload_0
    //   1635: aload 5
    //   1637: bipush 18
    //   1639: invokevirtual 1363	com/whatsapp/Conversation:startActivityForResult	(Landroid/content/Intent;I)V
    //   1642: aload_0
    //   1643: invokevirtual 1268	com/whatsapp/Conversation:D	()V
    //   1646: goto -1303 -> 343
    //   1649: astore 7
    //   1651: aload 7
    //   1653: invokestatic 3350	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   1656: aload 5
    //   1658: invokestatic 3331	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   1661: goto -78 -> 1583
    //   1664: astore_3
    //   1665: aload 6
    //   1667: ifnull +10 -> 1677
    //   1670: aload 6
    //   1672: invokeinterface 3334 1 0
    //   1677: aload_3
    //   1678: athrow
    //   1679: astore_3
    //   1680: aconst_null
    //   1681: astore 5
    //   1683: aload 5
    //   1685: invokestatic 3331	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   1688: aload_3
    //   1689: athrow
    //   1690: ldc_w 3352
    //   1693: invokestatic 1782	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   1696: aload_0
    //   1697: getfield 2544	com/whatsapp/Conversation:bS	Lcom/whatsapp/wallpaper/WallPaperView;
    //   1700: invokevirtual 2552	com/whatsapp/wallpaper/WallPaperView:a	()V
    //   1703: aload_3
    //   1704: ldc_w 3354
    //   1707: iconst_0
    //   1708: invokevirtual 1850	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1711: istore_1
    //   1712: iload_1
    //   1713: ifeq +77 -> 1790
    //   1716: new 428	java/lang/StringBuilder
    //   1719: dup
    //   1720: ldc_w 3356
    //   1723: invokespecial 990	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1726: iload_1
    //   1727: invokevirtual 993	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1730: ldc_w 3358
    //   1733: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1736: aload 8
    //   1738: getfield 3323	android/graphics/Point:x	I
    //   1741: invokevirtual 993	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1744: ldc_w 3360
    //   1747: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1750: aload 8
    //   1752: getfield 3328	android/graphics/Point:y	I
    //   1755: invokevirtual 993	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1758: ldc_w 3362
    //   1761: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1764: invokevirtual 445	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1767: invokestatic 997	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1770: aload_0
    //   1771: aconst_null
    //   1772: iconst_m1
    //   1773: iload_1
    //   1774: aload 8
    //   1776: getfield 3323	android/graphics/Point:x	I
    //   1779: aload 8
    //   1781: getfield 3328	android/graphics/Point:y	I
    //   1784: invokespecial 3273	com/whatsapp/Conversation:a	(Landroid/net/Uri;IIII)V
    //   1787: goto -145 -> 1642
    //   1790: aload_3
    //   1791: ldc_w 3364
    //   1794: invokevirtual 3367	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   1797: ifeq +44 -> 1841
    //   1800: aload_3
    //   1801: ldc_w 3364
    //   1804: iconst_0
    //   1805: invokevirtual 1850	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1808: istore_1
    //   1809: new 428	java/lang/StringBuilder
    //   1812: dup
    //   1813: ldc_w 3369
    //   1816: invokespecial 990	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1819: iload_1
    //   1820: invokevirtual 993	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1823: invokevirtual 445	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1826: invokestatic 997	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1829: aload_0
    //   1830: aconst_null
    //   1831: iload_1
    //   1832: iconst_m1
    //   1833: iconst_0
    //   1834: iconst_0
    //   1835: invokespecial 3273	com/whatsapp/Conversation:a	(Landroid/net/Uri;IIII)V
    //   1838: goto -196 -> 1642
    //   1841: aload_3
    //   1842: ldc_w 3371
    //   1845: iconst_0
    //   1846: invokevirtual 1795	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   1849: ifeq +25 -> 1874
    //   1852: aload_0
    //   1853: getfield 721	com/whatsapp/Conversation:cH	Lcom/whatsapp/wallpaper/g;
    //   1856: aload_0
    //   1857: invokevirtual 3373	com/whatsapp/wallpaper/g:b	(Landroid/content/Context;)V
    //   1860: aload_0
    //   1861: aconst_null
    //   1862: invokespecial 1167	com/whatsapp/Conversation:b	(Landroid/graphics/drawable/Drawable;)V
    //   1865: ldc_w 3375
    //   1868: invokestatic 997	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1871: goto -229 -> 1642
    //   1874: aload_3
    //   1875: ldc_w 3377
    //   1878: iconst_0
    //   1879: invokevirtual 1795	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   1882: ifeq +32 -> 1914
    //   1885: aload_0
    //   1886: getfield 721	com/whatsapp/Conversation:cH	Lcom/whatsapp/wallpaper/g;
    //   1889: aload_0
    //   1890: invokevirtual 3379	com/whatsapp/wallpaper/g:c	(Landroid/content/Context;)V
    //   1893: aload_0
    //   1894: aload_0
    //   1895: getfield 721	com/whatsapp/Conversation:cH	Lcom/whatsapp/wallpaper/g;
    //   1898: aload_0
    //   1899: invokevirtual 2282	com/whatsapp/wallpaper/g:d	(Landroid/content/Context;)Landroid/graphics/drawable/Drawable;
    //   1902: invokespecial 1167	com/whatsapp/Conversation:b	(Landroid/graphics/drawable/Drawable;)V
    //   1905: ldc_w 3381
    //   1908: invokestatic 997	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1911: goto -269 -> 1642
    //   1914: aload_0
    //   1915: invokevirtual 2843	com/whatsapp/Conversation:getBaseContext	()Landroid/content/Context;
    //   1918: aload_0
    //   1919: ldc_w 3382
    //   1922: invokevirtual 1742	com/whatsapp/Conversation:getString	(I)Ljava/lang/String;
    //   1925: iconst_0
    //   1926: invokestatic 3385	com/whatsapp/pv:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   1929: new 428	java/lang/StringBuilder
    //   1932: dup
    //   1933: ldc_w 3387
    //   1936: invokespecial 990	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1939: aload_3
    //   1940: invokevirtual 3388	android/content/Intent:toString	()Ljava/lang/String;
    //   1943: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1946: invokevirtual 445	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1949: invokestatic 1661	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   1952: goto -310 -> 1642
    //   1955: iload_2
    //   1956: iconst_m1
    //   1957: if_icmpne -1614 -> 343
    //   1960: aload_3
    //   1961: ifnull +44 -> 2005
    //   1964: aload_3
    //   1965: ldc_w 3371
    //   1968: iconst_0
    //   1969: invokevirtual 1795	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   1972: ifeq +33 -> 2005
    //   1975: aload_0
    //   1976: invokespecial 2713	com/whatsapp/Conversation:ap	()Landroid/widget/ProgressBar;
    //   1979: iconst_0
    //   1980: invokevirtual 3389	android/widget/ProgressBar:setVisibility	(I)V
    //   1983: aload_0
    //   1984: getfield 1951	com/whatsapp/Conversation:dg	Landroid/widget/ImageView;
    //   1987: iconst_4
    //   1988: invokevirtual 3008	android/widget/ImageView:setVisibility	(I)V
    //   1991: aload_0
    //   1992: getfield 3392	com/whatsapp/Conversation:aO	Lcom/whatsapp/acw;
    //   1995: aload_0
    //   1996: getfield 1174	com/whatsapp/Conversation:W	Lcom/whatsapp/data/cs;
    //   1999: invokevirtual 3396	com/whatsapp/acw:a	(Lcom/whatsapp/data/cs;)V
    //   2002: goto -1659 -> 343
    //   2005: aload_0
    //   2006: getfield 3392	com/whatsapp/Conversation:aO	Lcom/whatsapp/acw;
    //   2009: aload_0
    //   2010: bipush 20
    //   2012: aload_3
    //   2013: invokevirtual 3399	com/whatsapp/acw:a	(Lcom/whatsapp/nh;ILandroid/content/Intent;)V
    //   2016: goto -1673 -> 343
    //   2019: aload_0
    //   2020: getfield 3392	com/whatsapp/Conversation:aO	Lcom/whatsapp/acw;
    //   2023: invokevirtual 3402	com/whatsapp/acw:b	()Ljava/io/File;
    //   2026: invokevirtual 3405	java/io/File:delete	()Z
    //   2029: ifne +9 -> 2038
    //   2032: ldc_w 3407
    //   2035: invokestatic 1661	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   2038: iload_2
    //   2039: iconst_m1
    //   2040: if_icmpne -1697 -> 343
    //   2043: aload_0
    //   2044: getfield 3392	com/whatsapp/Conversation:aO	Lcom/whatsapp/acw;
    //   2047: aload_0
    //   2048: aload_0
    //   2049: getfield 1174	com/whatsapp/Conversation:W	Lcom/whatsapp/data/cs;
    //   2052: invokevirtual 3410	com/whatsapp/acw:a	(Landroid/app/Activity;Lcom/whatsapp/data/cs;)Z
    //   2055: ifeq -1712 -> 343
    //   2058: aload_0
    //   2059: invokespecial 2713	com/whatsapp/Conversation:ap	()Landroid/widget/ProgressBar;
    //   2062: iconst_0
    //   2063: invokevirtual 3389	android/widget/ProgressBar:setVisibility	(I)V
    //   2066: aload_0
    //   2067: getfield 1951	com/whatsapp/Conversation:dg	Landroid/widget/ImageView;
    //   2070: iconst_4
    //   2071: invokevirtual 3008	android/widget/ImageView:setVisibility	(I)V
    //   2074: goto -1731 -> 343
    //   2077: iload_2
    //   2078: iconst_m1
    //   2079: if_icmpne -1736 -> 343
    //   2082: aload_0
    //   2083: iconst_0
    //   2084: invokevirtual 3412	com/whatsapp/Conversation:e	(Z)V
    //   2087: goto -1744 -> 343
    //   2090: iload_2
    //   2091: iconst_m1
    //   2092: if_icmpne -1749 -> 343
    //   2095: aload_0
    //   2096: invokespecial 2592	com/whatsapp/Conversation:ah	()V
    //   2099: goto -1756 -> 343
    //   2102: iload_2
    //   2103: iconst_m1
    //   2104: if_icmpne -1761 -> 343
    //   2107: aload_0
    //   2108: invokespecial 2594	com/whatsapp/Conversation:ag	()V
    //   2111: goto -1768 -> 343
    //   2114: iload_2
    //   2115: iconst_m1
    //   2116: if_icmpne -1773 -> 343
    //   2119: aload_0
    //   2120: invokevirtual 3414	com/whatsapp/Conversation:t	()V
    //   2123: goto -1780 -> 343
    //   2126: aload_0
    //   2127: invokespecial 2801	com/whatsapp/Conversation:af	()V
    //   2130: goto -1787 -> 343
    //   2133: iload_2
    //   2134: iconst_m1
    //   2135: if_icmpne -1792 -> 343
    //   2138: aload_0
    //   2139: invokevirtual 3416	com/whatsapp/Conversation:r	()V
    //   2142: goto -1799 -> 343
    //   2145: iload_2
    //   2146: iconst_m1
    //   2147: if_icmpne -1804 -> 343
    //   2150: aload_0
    //   2151: invokevirtual 3418	com/whatsapp/Conversation:q	()V
    //   2154: goto -1811 -> 343
    //   2157: iload_2
    //   2158: iconst_m1
    //   2159: if_icmpne -1816 -> 343
    //   2162: aload_0
    //   2163: invokevirtual 3420	com/whatsapp/Conversation:o	()V
    //   2166: goto -1823 -> 343
    //   2169: iload_2
    //   2170: iconst_m1
    //   2171: if_icmpne -1828 -> 343
    //   2174: aload_0
    //   2175: invokevirtual 3422	com/whatsapp/Conversation:s	()V
    //   2178: goto -1835 -> 343
    //   2181: iload_2
    //   2182: iconst_m1
    //   2183: if_icmpne -1840 -> 343
    //   2186: aload_0
    //   2187: getfield 2073	com/whatsapp/Conversation:bA	Landroid/view/View;
    //   2190: ifnull +12 -> 2202
    //   2193: aload_0
    //   2194: getfield 2073	com/whatsapp/Conversation:bA	Landroid/view/View;
    //   2197: bipush 8
    //   2199: invokevirtual 2041	android/view/View:setVisibility	(I)V
    //   2202: aload_0
    //   2203: aload_3
    //   2204: invokespecial 3424	com/whatsapp/Conversation:a	(Landroid/content/Intent;)V
    //   2207: goto -1864 -> 343
    //   2210: iload_2
    //   2211: iconst_m1
    //   2212: if_icmpne -1869 -> 343
    //   2215: aload_0
    //   2216: aload_3
    //   2217: invokespecial 3424	com/whatsapp/Conversation:a	(Landroid/content/Intent;)V
    //   2220: goto -1877 -> 343
    //   2223: astore_3
    //   2224: goto -541 -> 1683
    //   2227: astore_3
    //   2228: goto -545 -> 1683
    //   2231: astore 7
    //   2233: goto -582 -> 1651
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2236	0	this	Conversation
    //   0	2236	1	paramInt1	int
    //   0	2236	2	paramInt2	int
    //   0	2236	3	paramIntent	Intent
    //   637	27	4	bool	boolean
    //   357	1327	5	localObject1	Object
    //   407	1264	6	localObject2	Object
    //   728	833	7	localObject3	Object
    //   1649	3	7	localFileNotFoundException1	java.io.FileNotFoundException
    //   2231	1	7	localFileNotFoundException2	java.io.FileNotFoundException
    //   700	1080	8	localObject4	Object
    //   1469	49	9	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   1480	1491	1649	java/io/FileNotFoundException
    //   1422	1441	1664	finally
    //   1445	1477	1664	finally
    //   1542	1547	1664	finally
    //   1578	1583	1664	finally
    //   1656	1661	1664	finally
    //   1683	1690	1664	finally
    //   1480	1491	1679	finally
    //   1495	1542	2223	finally
    //   1651	1656	2227	finally
    //   1495	1542	2231	java/io/FileNotFoundException
  }
  
  public void onBackPressed()
  {
    if (this.bQ.b()) {
      return;
    }
    u = true;
    if (isTaskRoot())
    {
      Intent localIntent = new Intent(this, Main.n());
      if (Build.VERSION.SDK_INT >= 21)
      {
        finishAndRemoveTask();
        startActivity(localIntent);
        return;
      }
      startActivity(localIntent);
    }
    super.onBackPressed();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.cf)
    {
      this.U.setTranscriptMode(2);
      this.ci.sendEmptyMessageDelayed(1, 1000L);
    }
    while (paramConfiguration.orientation == 1)
    {
      bv.a(this.cU);
      return;
      this.U.setSelection(this.ce);
    }
    this.cU.setMaxLines(2);
  }
  
  @SuppressLint({"NewApi"})
  public void onCreate(Bundle paramBundle)
  {
    boolean bool2 = false;
    Log.i("conversation/create");
    bu.a(anf.a(this.aK));
    this.D = com.whatsapp.k.c.a("ConversationActivityInit");
    this.D.a(this.bs);
    this.D.a(d.e.a, this.bs);
    this.D.b(d.e.a);
    this.D.a(d.e.b);
    Object localObject1 = this.D;
    Object localObject2 = d.a.d;
    com.whatsapp.util.bd localbd;
    if (paramBundle != null)
    {
      bool1 = true;
      ((com.whatsapp.k.d)localObject1).a((d.a)localObject2, bool1);
      this.D.a(d.a.c, aV);
      aV = false;
      localbd = new com.whatsapp.util.bd("conversation/create");
      if (av.j()) {
        bm.c(this);
      }
      localObject1 = getWindow();
      ((Window)localObject1).requestFeature(13);
      ((Window)localObject1).requestFeature(12);
      ((Window)localObject1).setBackgroundDrawable(new ColorDrawable(0));
      if (Build.VERSION.SDK_INT >= 21) {
        ((Window)localObject1).addFlags(Integer.MIN_VALUE);
      }
      super.onCreate(paramBundle);
      V();
      if (paramBundle == null) {
        break label254;
      }
    }
    label254:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.r = bool1;
      if (!this.r) {
        jv.p();
      }
      if (WhatsAppLibLoader.a(null)) {
        break label259;
      }
      Log.i("conversation/aborting due to native libraries missing");
      finish();
      return;
      bool1 = false;
      break;
    }
    label259:
    if ((this.cs.b == null) || (!this.Q.z.d) || (!this.cR.b()))
    {
      Log.i("conversation/create/no-me-or-msgstore-db");
      this.aq.a("conversation bounce to main");
      startActivity(new Intent(this, Main.class));
      finish();
      return;
    }
    localObject2 = getIntent().getStringExtra("jid");
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      if (ContactProvider.a(getIntent().getData()))
      {
        cs localcs = this.ae.a(getIntent().getData());
        localObject1 = localObject2;
        if (localcs != null)
        {
          localObject1 = localcs.t;
          getIntent().putExtra("jid", (String)localObject1);
        }
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = this.ae.d((String)localObject1);
      if (((((cs)localObject2).d()) || (cs.d(((cs)localObject2).t))) && (((cs)localObject2).e == null))
      {
        this.cP.a(this.Q, this.cM, (String)localObject1);
        localObject2 = getIntent().getStringExtra("displayname");
        if (localObject2 != null)
        {
          Log.w("conversation/create/group-shortcut-removed");
          pv.a(this, getString(2131296992, new Object[] { localObject2 }), 1);
          startActivity(new Intent(this, Main.n()));
          finish();
          return;
        }
      }
    }
    if (com.whatsapp.protocol.j.c((String)localObject1))
    {
      finish();
      return;
    }
    if (getIntent().getBooleanExtra("fromCallNotification", false)) {
      this.cO.b();
    }
    this.aY = true;
    this.D.a(d.e.h);
    setContentView(2130903127);
    this.D.b(d.e.h);
    localObject1 = (android.support.v7.app.a)a.d.a(i());
    ((android.support.v7.app.a)localObject1).a(false);
    ((android.support.v7.app.a)localObject1).b();
    ((Toolbar)a.d.a(findViewById(2131755412))).e();
    this.bC = ((View)a.d.a(findViewById(2131755530)));
    this.bC.setOnClickListener(fv.a(this));
    this.bD = ((TextView)findViewById(2131755531));
    this.K = ((ConversationContentLayout)findViewById(2131755521));
    this.bE = findViewById(2131755550);
    this.bF = findViewById(2131755548);
    this.bG = findViewById(2131755547);
    this.bR = findViewById(2131755549);
    this.bH = ((TextView)findViewById(2131755525));
    this.bI = ((ViewGroup)findViewById(2131755554));
    this.bP = ((ViewGroup)findViewById(2131755553));
    this.bS = ((WallPaperView)a.d.a(findViewById(2131755523)));
    this.bS.setOnSizeChangedListener(new WallPaperView.a(this));
    b(null);
    al();
    v = this.ag.a.getBoolean("input_enter_send", true);
    w = this.ag.a.getBoolean("conversation_sound", true);
    this.U = W();
    this.U.setDividerHeight(0);
    this.U.getViewTreeObserver().addOnPreDrawListener(this.dn);
    this.cW = ((ImageButton)findViewById(2131755437));
    this.cW.setImageDrawable(new az(android.support.v4.content.b.a(this, 2130840323)));
    this.cV = ((View)a.d.a(findViewById(2131755552)));
    this.cV.setBackgroundResource(2130840040);
    this.cV.setPadding(0, 0, 0, 0);
    localObject1 = (View)a.d.a(findViewById(2131755551));
    int i = Math.max(((View)localObject1).getPaddingLeft(), ((View)localObject1).getPaddingRight());
    localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
    if (this.aq.d()) {
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = i;
    }
    for (;;)
    {
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      if (Build.VERSION.SDK_INT >= 21)
      {
        localObject1 = new ViewOutlineProvider()
        {
          @TargetApi(21)
          public final void getOutline(View paramAnonymousView, Outline paramAnonymousOutline)
          {
            int i = (int)(Conversation.N().a * 48.0F);
            paramAnonymousOutline.setOval(0, 0, i, i);
          }
        };
        this.cW.setOutlineProvider((ViewOutlineProvider)localObject1);
      }
      this.da = ((ImageButton)a.d.a(findViewById(2131755558)));
      this.da.setVisibility(0);
      this.da.setOnClickListener(new com.whatsapp.util.at()
      {
        public final void a(View paramAnonymousView)
        {
          if (Conversation.ap(Conversation.this).a(Conversation.h(Conversation.this)))
          {
            a.a.a.a.d.a(Conversation.this, 106);
            return;
          }
          Conversation.aq(Conversation.this);
          Conversation.ar(Conversation.this);
          Conversation.as(Conversation.this).a(Conversation.this, Conversation.E(Conversation.this), Conversation.c(Conversation.this));
        }
      });
      this.cY = ((ImageButton)a.d.a(findViewById(2131755561)));
      this.cY.setOnTouchListener(fw.a(this));
      this.cZ = ((ImageButton)a.d.a(findViewById(2131755559)));
      this.cZ.setOnClickListener(fx.a(this));
      this.cZ.setOnLongClickListener(fz.a(this));
      this.bw = ((ViewGroup)al.a(this.aq, getLayoutInflater(), 2130903133, this.U, false));
      this.bx = this.bw.findViewById(2131755224);
      this.U.addHeaderView(this.bw);
      if (a(paramBundle)) {
        break;
      }
      Log.e("conversation/create failed to start new conversation");
      finish();
      return;
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = i;
    }
    this.bn = ((TextView)findViewById(2131755528));
    this.C = ((View)a.d.a(findViewById(2131755527)));
    this.C.setVisibility(8);
    this.C.setOnClickListener(ga.a(this));
    this.U.setScrollbarFadingEnabled(true);
    this.U.setOnScrollListener(this.dk);
    registerForContextMenu(this.U);
    this.cU.setScrollbarFadingEnabled(true);
    this.cU.addTextChangedListener(this.dm);
    this.cU.addTextChangedListener(this.dl);
    this.cU.setOnEditorActionListener(this.X);
    this.cU.setOnClickListener(this.jdField_do);
    this.cU.setInputEnterSend(v);
    al.b(this.aq, this.cU);
    this.cU.setOnKeyListener(gb.a(this));
    this.cW.setOnClickListener(gc.a(this));
    localObject1 = this.cU.getText().toString();
    localObject2 = this.cW;
    bool1 = bool2;
    if (!be.a((CharSequence)localObject1)) {
      bool1 = true;
    }
    ((ImageButton)localObject2).setEnabled(bool1);
    this.cX = ((ImageButton)a.d.a(findViewById(2131755556)));
    this.cX.setOnClickListener(gd.a(this));
    this.G = new com.whatsapp.gif_search.a(this.an, this, this.aq, this.cy, this.aE, this.ag);
    this.bQ = new com.whatsapp.gif_search.f((GifSearchContainer)findViewById(2131755562), (EmojiSearchContainer)findViewById(2131755563), this.G, this);
    this.G.a(this.Y);
    this.G.setOnDismissListener(ge.a(this));
    this.bQ.e = this;
    this.bQ.a(this);
    this.bQ.h = this;
    bv.a(this.cU);
    this.cl.registerObserver(this.cm);
    this.cn.registerObserver(this.co);
    this.ck = true;
    if (ahc.e())
    {
      Log.w("conversation/device-not-supported");
      a(new nh.k());
      if (aX.containsKey(this.t))
      {
        localObject1 = this.cE.a(((Long)aX.get(this.t)).longValue());
        if (localObject1 != null) {
          f((com.whatsapp.protocol.j)localObject1);
        }
      }
      if (paramBundle != null)
      {
        localObject1 = (FMessageKey)paramBundle.getParcelable("reply_message_key");
        if (localObject1 != null)
        {
          localObject1 = this.cE.a(((FMessageKey)localObject1).a);
          if (localObject1 != null) {
            f((com.whatsapp.protocol.j)localObject1);
          }
        }
        this.B = paramBundle.getLong("start_ref", 1L);
        this.bo = Boolean.valueOf(paramBundle.getBoolean("keyboard_visible"));
      }
      localbd.b();
      if (((Build.VERSION.SDK_INT >= 23) || ((Build.VERSION.SDK_INT == 21) && ("samsung".equalsIgnoreCase(Build.MANUFACTURER)))) && (((KeyguardManager)getSystemService("keyguard")).isKeyguardLocked()))
      {
        Log.i("conversation/locked");
        this.cT = new BroadcastReceiver()
        {
          public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
          {
            try
            {
              Conversation.this.unregisterReceiver(this);
              Log.i("conversation/reset-ime");
              Conversation.at(Conversation.this).restartInput(Conversation.g(Conversation.this));
              Conversation.au(Conversation.this);
              return;
            }
            catch (Exception paramAnonymousContext)
            {
              Log.d("conversation/unregister user present receiver ", paramAnonymousContext);
            }
          }
        };
        registerReceiver(this.cT, new IntentFilter("android.intent.action.USER_PRESENT"));
      }
      this.T.a(this.cp);
      this.T.a(this.cq);
      this.br = new com.whatsapp.f.a(getWindow());
      paramBundle = this.br;
      localObject1 = new a.a(this);
      a.d.b();
      a.d.b();
      if (!paramBundle.c) {
        break label2044;
      }
      ((a.a)localObject1).a(paramBundle.b);
    }
    for (;;)
    {
      a.a.a.a.d.a(W(), this.D);
      this.D.b(d.e.b);
      return;
      if (this.av.b())
      {
        Log.w("conversation/clock-wrong");
        f();
        break;
      }
      if (this.av.c())
      {
        Log.w("conversation/software-expired");
        g();
        break;
      }
      if (amb.a(this.av, this.ag) <= 0) {
        break;
      }
      Log.w("conversation/software-about-to-expire");
      a.a.a.a.d.a(this, 115);
      break;
      label2044:
      paramBundle.a.add(localObject1);
    }
  }
  
  public Dialog onCreateDialog(int paramInt)
  {
    if (ai())
    {
      this.N.i = paramInt;
      return null;
    }
    Object localObject;
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    case 0: 
      localObject = View.inflate(this, 2130903261, null);
      DialogInterface.OnClickListener localOnClickListener = ew.a(this, (CheckBox)((View)localObject).findViewById(2131755194));
      localObject = new android.support.v7.app.b.a(this).b(2131296433).a((View)localObject).b(2131296398, ex.a(this)).a(2131296430, localOnClickListener).a();
      ((android.support.v7.app.b)localObject).show();
      return (Dialog)localObject;
    case 1: 
      localObject = ey.a(this);
      localObject = new android.support.v7.app.b.a(this).b(getString(2131296351, new Object[] { this.W.a(this) })).a(2131296350, (DialogInterface.OnClickListener)localObject).b(2131296398, null);
      if (!this.W.F) {
        ((android.support.v7.app.b.a)localObject).c(2131297612, ez.a(this));
      }
      return ((android.support.v7.app.b.a)localObject).a();
    case 2: 
      localObject = fa.a(this);
      return new android.support.v7.app.b.a(this).a(2131296940).b(2131296939).a(2131297331, (DialogInterface.OnClickListener)localObject).a();
    case 106: 
      return new android.support.v7.app.b.a(this).b(getString(2131296403, new Object[] { this.W.a(this) })).a(2131298057, fb.a(this)).b(2131296398, fc.a(this)).a();
    case 7: 
      Log.w("conversation/dialog/oom");
      return new android.support.v7.app.b.a(this).b(2131296746).a(2131297331, fe.a(this)).a();
    case 8: 
      Log.e("conversation/dialog/not-an-image");
      return new android.support.v7.app.b.a(this).b(2131296734).a(2131297331, ff.a(this)).a();
    case 9: 
      Log.i("conversation/warned-about-call-charges");
      return new android.support.v7.app.b.a(this).b(2131296372).a(2131296369, fg.a(this)).b(2131296398, fh.a(this)).a();
    case 10: 
      return new android.support.v7.app.b.a(this).b(2131296702).a(2131296337, fi.a(this)).c(2131298211, fj.a(this)).a();
    case 11: 
      Log.i("conversation/dialog-add-contact");
      return new android.support.v7.app.b.a(this).b(2131296293).a(2131297274, fk.a(this)).c(2131296767, fl.a(this)).a();
    case 115: 
      Log.i("conversation/dialog software-about-to-expire");
      return amb.a(this, this.av);
    case 12: 
      Log.w("conversation/add existing contact: activity not found, probably tablet");
      return new android.support.v7.app.b.a(this).b(2131296289).a(2131297331, fm.a(this)).a();
    case 13: 
      if ((this.aa == null) || (this.aa.isEmpty()))
      {
        Log.e("conversation/dialog/delete no messages");
        return super.onCreateDialog(paramInt);
      }
      Log.i("conversation/dialog/delete/" + this.aa.size());
      return a.a.a.a.d.a(this, this.aq, this.ao, this.cv, this.ae, this.aa.values(), this.W.t, 13, true, new fn(this));
    case 15: 
      localObject = new android.support.v7.app.b.a(this);
      if (vv.i())
      {
        paramInt = 2131297515;
        localObject = ((android.support.v7.app.b.a)localObject).a(paramInt);
        if (!vv.i()) {
          break label809;
        }
      }
      for (paramInt = 2131297513;; paramInt = 2131297514)
      {
        return ((android.support.v7.app.b.a)localObject).b(paramInt).a(2131297331, fp.a(this)).a();
        paramInt = 2131297516;
        break;
      }
    case 17: 
      return new android.support.v7.app.b.a(this).b(2131296409).a(2131297656, fq.a(this)).b(2131296398, fr.a(this)).a();
    case 18: 
      label809:
      if ((this.aa == null) || (this.aa.isEmpty()))
      {
        Log.e("conversation/dialog/revoke-no-messages");
        return super.onCreateDialog(paramInt);
      }
      Log.i("conversation/dialog/revoke/" + this.aa.size());
      return a.d.a(this, this.aq, this.cv, this.aa.values(), new fs(this));
    }
    return new android.support.v7.app.b.a(this).b(2131297111).a(2131297331, ft.a(this)).b(2131296398, fu.a(this)).a();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    Log.i("conversation/oncreateoptionsmenu");
    Object localObject;
    if (this.W != null)
    {
      if (!this.I) {
        break label175;
      }
      a(paramMenu, 9, 2131296986);
      a(paramMenu, 12, 2131298127);
      a(paramMenu, 14, 2131297631);
      a(paramMenu, 10, aa());
      a(paramMenu, 11, 2131298180);
      localObject = a(paramMenu);
      a((Menu)localObject, 17, 2131296436);
      a((Menu)localObject, 8, 2131296701);
      a((Menu)localObject, 6, 2131296302);
    }
    for (;;)
    {
      if (this.dt != null)
      {
        o.a(this.dt, 2);
        if (((this.I) && (!this.cQ.b(this.W.t))) || (e.b(this.W.t))) {
          this.dt.setVisible(false);
        }
      }
      return super.onCreateOptionsMenu(paramMenu);
      label175:
      if (this.J)
      {
        a(paramMenu, 9, 2131297090);
        a(paramMenu, 12, 2131298130);
        a(paramMenu, 14, 2131297631);
        a(paramMenu, 11, 2131298180);
        localObject = a(paramMenu);
        a((Menu)localObject, 17, 2131296436);
        a((Menu)localObject, 8, 2131296701);
        a((Menu)localObject, 6, 2131296302);
      }
      else if (e.b(this.W.t))
      {
        a(paramMenu, 1, 2131298120);
        a(paramMenu, 12, 2131298125);
        a(paramMenu, 14, 2131297631);
        a(paramMenu, 10, aa());
        a(paramMenu, 11, 2131298180);
        localObject = a(paramMenu);
        ((SubMenu)localObject).clearHeader();
        a((Menu)localObject, 17, 2131296436);
        a((Menu)localObject, 8, 2131296701);
      }
      else
      {
        localObject = null;
        label418:
        MenuItem localMenuItem;
        if (Build.VERSION.SDK_INT >= 11)
        {
          if (this.cr)
          {
            localObject = a(paramMenu, 16, 2131298106);
            ((MenuItem)localObject).setActionView(2130903392);
            a((MenuItem)localObject, 2131298106);
          }
          this.bq = true;
          if (this.cr)
          {
            i = 2131296341;
            localMenuItem = a(paramMenu, 15, i);
            localMenuItem.setActionView(2130903087);
            if (!this.cr) {
              break label622;
            }
          }
          label622:
          for (i = 2131296341;; i = 2131296369)
          {
            a(localMenuItem, i);
            if (this.cr) {
              o.a((MenuItem)localObject, 2);
            }
            o.a(localMenuItem, 2);
            if (!this.W.i()) {
              break label681;
            }
            a(paramMenu, 1, 2131298120);
            a(paramMenu, 2, 2131296292);
            a(paramMenu, 18, 2131297611);
            a(paramMenu, 4, 2131296350);
            a(paramMenu, 5, 2131298057);
            a(paramMenu, 14, 2131297631);
            a(paramMenu, 10, aa());
            a(paramMenu, 11, 2131298180);
            localObject = a(paramMenu);
            ((SubMenu)localObject).clearHeader();
            a((Menu)localObject, 12, 2131298125);
            a((Menu)localObject, 17, 2131296436);
            a((Menu)localObject, 8, 2131296701);
            a((Menu)localObject, 6, 2131296302);
            break;
            i = 2131296369;
            break label418;
          }
        }
        this.bq = false;
        if (this.cr) {}
        for (int i = 2131296341;; i = 2131296369)
        {
          localMenuItem = paramMenu.add(0, 15, 0, i);
          localMenuItem.setIcon(2130840052);
          localObject = null;
          break;
        }
        label681:
        a(paramMenu, 1, 2131298120);
        a(paramMenu, 2, 2131296292);
        a(paramMenu, 12, 2131298125);
        a(paramMenu, 14, 2131297631);
        a(paramMenu, 10, aa());
        a(paramMenu, 11, 2131298180);
        localObject = a(paramMenu);
        ((SubMenu)localObject).clearHeader();
        a((Menu)localObject, 4, 2131296350);
        a((Menu)localObject, 5, 2131298057);
        a((Menu)localObject, 17, 2131296436);
        a((Menu)localObject, 8, 2131296701);
        a((Menu)localObject, 6, 2131296302);
      }
    }
  }
  
  public void onDestroy()
  {
    Log.i("conversation/destroy");
    super.onDestroy();
    this.D.c();
    if (this.G != null) {
      v();
    }
    if (this.N != null) {
      this.N.a(false, this.A);
    }
    this.T.b(this.cp);
    this.T.b(this.cq);
    if (this.U != null) {
      this.U.getViewTreeObserver().removeOnPreDrawListener(this.dn);
    }
    if ((this.H != null) && (this.H.isShowing())) {
      this.H.a();
    }
    if (this.dq)
    {
      this.dr.unregisterObserver(this.ds);
      this.dq = false;
    }
    u = true;
    if (this.V != null) {
      this.V.unregisterDataSetObserver(this.dp);
    }
    bp(this);
    l locall = (l)cd.get();
    if (locall.a == this)
    {
      Log.d("conversation/clearsession/jid " + this.t);
      cd.compareAndSet(locall, new l(null, false));
    }
    if ((this.V != null) && (this.V.getCursor() != null)) {
      this.V.getCursor().close();
    }
    if (this.bV != null) {
      this.bV.cancel(true);
    }
    if (this.ck)
    {
      this.cl.unregisterObserver(this.cm);
      this.cn.unregisterObserver(this.co);
    }
    if (this.bT != null)
    {
      this.bT.a();
      this.bT = null;
    }
    if (this.cU != null)
    {
      this.cU.removeTextChangedListener(this.dm);
      this.cU.removeTextChangedListener(this.dl);
      this.cU.setFilters(new InputFilter[0]);
      this.cU.a();
      this.cU = null;
    }
    if (this.bU != null) {
      this.bU.removeTextChangedListener(this.dx);
    }
    if (this.cT != null) {
      unregisterReceiver(this.cT);
    }
    yx.i();
    bu.a(anf.a(this.aK));
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.isPrintingKey()) && (this.cU.isShown()) && (!this.cU.hasFocus()) && ((this.N == null) || (!this.N.e())))
    {
      this.cU.requestFocus();
      dispatchKeyEvent(paramKeyEvent);
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (((paramInt == 82) || (paramInt == 4)) && (this.G.isShowing()))
    {
      this.G.t = false;
      this.G.dismiss();
      return false;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i;
    switch (paramMenuItem.getItemId())
    {
    default: 
      return false;
    case 16908332: 
      finish();
      return true;
    case 0: 
      if (this.ag.a.getBoolean("warned_about_call_charges", false)) {
        i(cs.b(this.W.t));
      }
      for (;;)
      {
        return true;
        this.ag.c().putBoolean("warned_about_call_charges", true).apply();
        a.a.a.a.d.a(this, 9);
      }
    case 1: 
      ContactInfo.a(this.W, this, android.support.v4.app.c.a(this, findViewById(2131755533), getString(2131298269)));
      return true;
    case 2: 
      a.a.a.a.d.a(this, 11);
      return true;
    case 4: 
      a.a.a.a.d.a(this, 1);
      return true;
    case 5: 
      if (!this.aM.b()) {
        if (aat.a(this))
        {
          i = 2131297299;
          pv.a(getBaseContext(), i, 0);
        }
      }
      for (;;)
      {
        return true;
        i = 2131297298;
        break;
        A();
      }
    case 17: 
      a.a.a.a.d.a(this, 0);
      return true;
    case 14: 
      onSearchRequested();
      return true;
    case 8: 
      if (this.aI.c())
      {
        Log.w("conversation/email-attachment/need-sd-card");
        if (vv.i())
        {
          i = 2131297241;
          b_(i);
        }
      }
      for (;;)
      {
        return true;
        i = 2131297242;
        break;
        if (this.Q.a(this.W.t, 1, null).size() > 0) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label410;
          }
          a.a.a.a.d.a(this, 10);
          break;
        }
        a(this.aq, this.aw, this.Q, this.aI, this, this, this.W, false);
      }
    case 6: 
      a.a.a.a.d.a(getApplicationContext(), this.W);
      pv.a(this, 2131296569, 1);
      return true;
    case 9: 
      if (this.J) {
        ListChatInfo.a(this.W, this, android.support.v4.app.c.a(this, findViewById(2131755533), getString(2131298269)));
      }
      for (;;)
      {
        return true;
        GroupChatInfo.a(this.W, this, android.support.v4.app.c.a(this, findViewById(2131755533), getString(2131298269)));
      }
    case 10: 
      if (this.cI.b(this.t)) {
        this.cI.a(this.t, true);
      }
      for (;;)
      {
        return true;
        aam.a(this.t).a(j_(), null);
      }
    case 11: 
      Log.i("conversation/menu/wallpaper/" + this.bS.getWidth() + "x" + this.bS.getHeight());
      startActivityForResult(g.g(this), 17);
      return true;
    case 12: 
      paramMenuItem = new Intent(this, MediaGallery.class);
      paramMenuItem.putExtra("jid", this.W.t);
      startActivity(paramMenuItem);
      u = true;
      return true;
    case 15: 
      a(this.W, this.bq, false);
      return true;
    case 16: 
      label410:
      a(this.W, this.bq, true);
      return true;
    }
    a(agm.a(this.W.t, "chat"));
    return true;
  }
  
  public void onPause()
  {
    Log.i("conversation/pause");
    super.onPause();
    this.D.c();
    if (this.N != null) {
      this.N.a(false, this.A);
    }
    p.put(this.W.t, com.whatsapp.emoji.c.b(this.cU.getStringText()));
    q.put(this.W.t, yr.a(this.cU.getMentions()));
    Log.d("conversation/pause/cursor/count " + this.V.getCursor().getCount());
    Log.d("conversation/pause/appended/count " + this.y.size());
    if ((this.bt != null) && (this.bt.hasMessages(0)))
    {
      this.bt.removeMessages(0);
      localObject = this.aE.a;
      if (localObject != null) {
        break label228;
      }
      Log.w("conversation/pause pm=null");
    }
    for (;;)
    {
      if (this.U.getHeight() != 0)
      {
        if (this.U.getLastVisiblePosition() != this.U.getCount() - 1) {
          break;
        }
        this.O = true;
        Log.d("conversation/dbgscroll/resumescrolltobottom/true");
      }
      return;
      label228:
      if (((PowerManager)localObject).isScreenOn()) {
        this.bt.sendEmptyMessage(0);
      }
    }
    this.cg = this.U.getFirstVisiblePosition();
    Log.d("conversation/dbgscroll/resumescrolltopos/" + this.cg);
    Object localObject = this.U.getChildAt(0);
    this.ch = 0;
    if (localObject != null) {
      this.ch = ((View)localObject).getTop();
    }
    Log.d("conversation/dbgscroll/resumeyoffset/" + this.ch);
    this.O = false;
    Log.d("conversation/dbgscroll/resumescrolltobottom/false");
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    Log.i("conversation/onprepareoptionsmenu " + paramMenu.size());
    if (paramMenu.size() == 0) {
      return false;
    }
    MenuItem localMenuItem;
    boolean bool1;
    if (this.W != null)
    {
      if (!this.J) {
        paramMenu.findItem(10).setTitle(aa());
      }
      if ((!this.I) && (!this.J) && (!e.b(this.W.t)))
      {
        localMenuItem = paramMenu.findItem(1);
        if (this.W.d == null) {
          break label361;
        }
        bool1 = true;
        localMenuItem.setVisible(bool1);
        localMenuItem = paramMenu.findItem(2);
        if (this.W.d != null) {
          break label366;
        }
        bool1 = true;
        label146:
        localMenuItem.setVisible(bool1);
        boolean bool2 = this.R.a(this.W.t);
        localMenuItem = paramMenu.findItem(4);
        if (bool2) {
          break label371;
        }
        bool1 = true;
        label185:
        localMenuItem.setVisible(bool1);
        paramMenu.findItem(5).setVisible(bool2);
      }
      if (this.V.getCount() <= 0) {
        break label376;
      }
      paramMenu.findItem(17).setVisible(true);
      paramMenu.findItem(8).setVisible(true);
      paramMenu.findItem(14).setVisible(true);
      label263:
      if ((Build.VERSION.SDK_INT >= 26) || ("O".equalsIgnoreCase(Build.VERSION.RELEASE))) {
        paramMenu.findItem(6).setVisible(false);
      }
      localMenuItem = paramMenu.findItem(18);
      if (localMenuItem != null) {
        localMenuItem.setVisible(true);
      }
      localMenuItem = paramMenu.findItem(3);
      if (!localMenuItem.getSubMenu().hasVisibleItems()) {
        break label424;
      }
      localMenuItem.setVisible(true);
    }
    for (;;)
    {
      return super.onPrepareOptionsMenu(paramMenu);
      label361:
      bool1 = false;
      break;
      label366:
      bool1 = false;
      break label146;
      label371:
      bool1 = false;
      break label185;
      label376:
      paramMenu.findItem(17).setVisible(false);
      paramMenu.findItem(8).setVisible(false);
      paramMenu.findItem(14).setVisible(false);
      break label263;
      label424:
      localMenuItem.setVisible(false);
    }
  }
  
  public void onResume()
  {
    this.D.a(d.e.g);
    Log.i("conversation/resume " + this.W.t);
    com.whatsapp.util.bd localbd = new com.whatsapp.util.bd("conversation/resume");
    super.onResume();
    Log.d("conversation/resume/cursor/count " + this.V.getCursor().getCount());
    Log.d("conversation/resume/appended/count " + this.y.size());
    this.cK.a.clear();
    if (this.cH.b)
    {
      al();
      this.cH.b = false;
    }
    this.W = this.ae.a(this.W.t);
    if (!this.at.d()) {
      this.cP.a(this.Q, this.cM, this.W.t);
    }
    ao();
    if (!this.W.d()) {
      this.cC.a(this.W);
    }
    if ((this.by != null) || (this.bz != null)) {
      aj();
    }
    if ((bu) && (!this.aY) && (!this.E)) {
      this.cM.c();
    }
    bu = false;
    if (o.remove(this.W.t))
    {
      Log.i("conversation/dialog_ask_gps");
      a.a.a.a.d.a(this, 2);
    }
    try
    {
      this.cD.b();
      if (this.aY)
      {
        this.aY = false;
        if (!this.dz) {
          break label501;
        }
        this.U.post(gv.a(this));
        this.be = true;
        Log.d("conversation/dbgscroll/onresume/freezelistpos/true setselectionfromtop dividerpos=" + d.a(this.V));
        this.df.setSelected(true);
        if (amb.a(this.av, this.ag) > 0)
        {
          Log.i("conversation/dialog_software_expire_warning");
          a.a.a.a.d.a(this, 115);
        }
        if (this.cw.a)
        {
          Log.i("conversation/dialog_login_failed");
          e();
        }
        if (Voip.e())
        {
          Log.i("conversation/dialog_voip_call_active");
          as();
        }
        localbd.b();
        this.D.b(d.e.g);
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        Log.e("conversation/ap/stateerror");
        continue;
        if (this.E)
        {
          Log.d("conversation/resume/refreshstatusdelayed");
          this.bt = new m();
          this.bt.sendEmptyMessageDelayed(0, 3000L);
          continue;
          label501:
          if (this.dA)
          {
            this.U.setSelection(0);
            this.be = true;
            this.dz = true;
            Log.d("conversation/dbgscroll/onresume/scrolltotop/true dividercentered=true freezelistpos=true");
          }
          else if (this.O)
          {
            Log.d("conversation/dbgscroll/resumescrolltobottom true");
            D();
          }
          else
          {
            Log.d("conversation/dbgscroll/resumescrollpos/" + this.cg + " yoff=" + this.ch);
            this.U.setSelectionFromTop(this.cg, this.ch);
          }
        }
      }
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.L != null) {
      paramBundle.putParcelable("reply_message_key", new FMessageKey(this.L.e));
    }
    this.bo = Boolean.valueOf(ar());
    paramBundle.putBoolean("keyboard_visible", this.bo.booleanValue());
    paramBundle.putBoolean("has_number_from_url", this.A);
    paramBundle.putBoolean("has_text_from_url", this.bb);
    paramBundle.putLong("start_ref", this.B);
  }
  
  public boolean onSearchRequested()
  {
    if (this.bj != null) {}
    int[] arrayOfInt;
    do
    {
      return false;
      if (this.Z != null) {
        this.Z.c();
      }
      if (this.bk == null) {
        this.bk = new android.support.v7.view.b.a()
        {
          public final void a(android.support.v7.view.b paramAnonymousb)
          {
            paramAnonymousb.a(null);
            Conversation.aH(Conversation.this);
            Conversation.d(Conversation.this, null);
            Conversation.a(Conversation.this, null);
            if ((!Conversation.X(Conversation.this)) || (Conversation.aB(Conversation.this).b(Conversation.this.W.t))) {
              Conversation.aI(Conversation.this).setVisibility(0);
            }
            Conversation.aE(Conversation.this);
            Conversation.e(Conversation.this).notifyDataSetChanged();
            Conversation.g(Conversation.this).requestFocus();
          }
          
          public final boolean a(android.support.v7.view.b paramAnonymousb, Menu paramAnonymousMenu)
          {
            paramAnonymousMenu = (LayoutInflater)Conversation.this.i().h().getSystemService("layout_inflater");
            paramAnonymousMenu = (ViewGroup)al.a(Conversation.this.aq, paramAnonymousMenu, 2130903177, null, false);
            paramAnonymousb.a(paramAnonymousMenu);
            Conversation.a(Conversation.this, (EditText)paramAnonymousMenu.findViewById(2131755212));
            Conversation.aC(Conversation.this).addTextChangedListener(Conversation.aF(Conversation.this));
            Conversation.aC(Conversation.this).setOnEditorActionListener(hn.a(this));
            paramAnonymousMenu.findViewById(2131755646).setOnClickListener(ho.a(this));
            ((View)a.d.a(Conversation.this.findViewById(2131755647))).setOnClickListener(hp.a(this));
            Conversation.aC(Conversation.this).setText(Conversation.aG(Conversation.this));
            Conversation.aC(Conversation.this).selectAll();
            Conversation.aC(Conversation.this).requestFocus();
            Conversation.aC(Conversation.this).setSelected(true);
            return true;
          }
          
          public final boolean a(android.support.v7.view.b paramAnonymousb, MenuItem paramAnonymousMenuItem)
          {
            return false;
          }
          
          public final boolean b(android.support.v7.view.b paramAnonymousb, Menu paramAnonymousMenu)
          {
            return false;
          }
        };
      }
      this.bE.setVisibility(8);
      this.bj = a(this.bk);
      arrayOfInt = new int[2];
      this.bE.getLocationOnScreen(arrayOfInt);
    } while (getWindowManager().getDefaultDisplay().getHeight() - (arrayOfInt[1] + this.bE.getHeight()) >= 128.0F * bv.a);
    this.aW.toggleSoftInput(0, 0);
    return false;
  }
  
  protected void onStart()
  {
    boolean bool2 = false;
    this.D.a(d.e.e);
    Log.d("conversation/start " + this.t);
    com.whatsapp.util.bd localbd = new com.whatsapp.util.bd("conversation/start");
    super.onStart();
    com.whatsapp.preference.WaFontListPreference.a = Integer.parseInt(this.ag.a.getString("interface_font_size", "0"));
    if (u) {
      bo(this);
    }
    this.y.clear();
    this.x.clear();
    Object localObject = this.Q.p(this.t);
    this.bf = ((ad.o)localObject).a;
    this.bg = ((ad.o)localObject).b;
    long l;
    if ((this.bf > 0) || (this.bg > 0))
    {
      this.bh = ((ad.o)localObject).c;
      Log.i("conversation/start/unseen " + this.bh + "/" + this.bf + "/" + this.bg);
      l = getIntent().getLongExtra("row_id", 0L);
      if (l <= 0L) {
        break label977;
      }
      getIntent().putExtra("row_id", 0L);
      localObject = (FMessageKey)getIntent().getParcelableExtra("key");
      if (localObject != null) {
        this.M = ((FMessageKey)localObject).a;
      }
      this.bW = getIntent().getStringExtra("query");
      this.bX = be.c(this.bW);
      this.bY = this.bW;
      localObject = this.Q.b(this.t, l, 51);
      if (((ad.e)localObject).b != null) {
        break label1283;
      }
      localObject = this.Q.a(this.t, this.B, d(false));
    }
    label393:
    label411:
    label622:
    label666:
    label766:
    label858:
    label874:
    label977:
    label1040:
    label1131:
    label1137:
    label1143:
    label1193:
    label1215:
    label1244:
    label1278:
    label1283:
    for (;;)
    {
      Log.i("conversation/start/count");
      int i = this.Q.a(this.t, ((ad.e)localObject).a, l);
      Log.i("conversation/start/count/result " + i);
      int j = 1;
      boolean bool1;
      if (((ad.e)localObject).b == null)
      {
        Log.w("conversation/start/cursor is null");
        F();
        this.bc = true;
        this.B = ((ad.e)localObject).a;
        this.V.changeCursor(((ad.e)localObject).b);
        if (this.V.getCount() == 0) {
          this.br.a(this.cU);
        }
        if (j == 0) {
          break label1215;
        }
        if ((((ad.e)localObject).b != null) && (((ad.e)localObject).b.moveToFirst()))
        {
          localObject = this.cE.a(((ad.e)localObject).b, this.t);
          if (localObject != null) {
            this.bl = ((com.whatsapp.protocol.j)localObject).Q;
          }
        }
        if ((this.bh > 0) && (this.bh == this.V.getCursor().getCount()))
        {
          this.dA = true;
          F();
          Log.d("conversation/start/scrolltotop/true");
        }
        if ((this.bh > 0) && (this.I) && (ak()))
        {
          F();
          Log.d("conversation/start/reset-unseen");
        }
        if (this.bh > 0) {
          this.dz = true;
        }
        if (this.V.getCursor().getCount() < d(false)) {
          break label1131;
        }
        bool1 = true;
        this.dw = bool1;
        Log.d("conversation/start/has-earlier " + this.dw);
        localObject = this.bx;
        if (!this.dw) {
          break label1137;
        }
        j = 0;
        ((View)localObject).setVisibility(j);
        aj();
        if ((this.bz != null) && (this.W.d())) {
          ((TextView)this.bz.findViewById(2131755386)).setText(2131296943);
        }
        if (i < 0) {
          break label1143;
        }
        this.U.setSelection(i);
        this.dz = false;
        this.dA = false;
        this.O = false;
        this.cg = (this.U.getHeaderViewsCount() + i);
        this.ch = getResources().getDimensionPixelSize(2131361938);
        localObject = getIntent();
        if ((n.equals(((Intent)localObject).getAction())) && (!this.r) && (this.V.getCount() > 0))
        {
          localObject = (FMessageKey)((Intent)localObject).getParcelableExtra("key");
          if (localObject != null)
          {
            localObject = this.cE.a(((FMessageKey)localObject).a);
            if (localObject != null)
            {
              if (((com.whatsapp.protocol.j)localObject).s != 2) {
                break label1193;
              }
              this.bZ = ((com.whatsapp.protocol.j)localObject).e;
            }
          }
        }
        if (this.bo == null) {
          break label1244;
        }
        bool1 = this.bo.booleanValue();
        localObject = getWindow();
        if (!bool1) {
          break label1278;
        }
      }
      for (i = 4;; i = 2)
      {
        ((Window)localObject).setSoftInputMode(i);
        if ((bool1) && (this.dz))
        {
          Log.d("conversation/schedule scroll to divider after keyboard visible");
          localObject = new ViewTreeObserver.OnGlobalLayoutListener()
          {
            public final void onGlobalLayout()
            {
              if (Conversation.aO(Conversation.this))
              {
                Conversation.b(Conversation.this).getViewTreeObserver().removeGlobalOnLayoutListener(this);
                Conversation.aP(Conversation.this);
              }
            }
          };
          this.U.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)localObject);
          this.U.postDelayed(gt.a(this, (ViewTreeObserver.OnGlobalLayoutListener)localObject), 2000L);
        }
        localbd.b();
        this.D.b(d.e.e);
        return;
        this.bh = 0;
        break;
        if (this.V.getCursor() == null) {}
        for (i = 1;; i = 0)
        {
          if ((i == 0) || (this.bh <= 90)) {
            break label1040;
          }
          localObject = this.Q.a(this.t, this.B, this.bh + 10);
          k = -1;
          j = i;
          i = k;
          break;
        }
        localObject = this.Q.a(this.t, this.B, d(false));
        int k = -1;
        j = i;
        i = k;
        break label393;
        if ((this.bh <= 0) || (this.bh <= ((ad.e)localObject).b.getCount())) {
          break label411;
        }
        Log.i("conversation/start/unseen greater than cursor count " + ((ad.e)localObject).b.getCount());
        F();
        break label411;
        bool1 = false;
        break label622;
        j = 8;
        break label666;
        if (this.dz)
        {
          this.U.setSelection(d.a(this.V));
          break label766;
        }
        if (this.dA) {
          break label766;
        }
        this.U.setSelection(this.V.getCount() - 1);
        break label766;
        startActivity(MediaView.a((com.whatsapp.protocol.j)localObject, ((com.whatsapp.protocol.j)localObject).e.a, this, 1));
        break label858;
        if (this.bh <= 0) {
          break label858;
        }
        this.dz = true;
        this.U.setSelection(d.a(this.V));
        break label858;
        if (this.V.getCount() != 0)
        {
          bool1 = bool2;
          if (!getIntent().getBooleanExtra("show_keyboard", false)) {
            break label874;
          }
        }
        bool1 = true;
        break label874;
      }
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    this.bo = Boolean.valueOf(ar());
    if (this.N != null) {
      this.N.a(false, this.A);
    }
    if (u) {
      bp(this);
    }
    if (this.dv != null)
    {
      Log.i("conversation/cancel-load-messages");
      this.dv.cancel(true);
    }
    Log.i("conversation/stop/release " + SQLiteDatabase.releaseMemory() + " jid=" + this.t);
    if (this.V.getCursor() != null) {
      this.V.getCursor().deactivate();
    }
  }
  
  public final void p()
  {
    this.U.post(gp.a(this));
  }
  
  final void q()
  {
    if ((h(36)) && (this.aI.a(this.cj)))
    {
      MediaFileUtils.a(this.au, 21, this);
      u = false;
    }
  }
  
  final void r()
  {
    String str;
    if ((h(35)) && (this.aI.a(this.cj)))
    {
      str = this.W.t;
      if (this.L != null) {
        break label55;
      }
    }
    label55:
    for (long l = 0L;; l = this.L.Q)
    {
      MediaFileUtils.a(this, str, l, this.A);
      u = false;
      return;
    }
  }
  
  final void s()
  {
    if ((h(38)) && (this.aI.a(this.cj))) {
      MediaFileUtils.a(this, this.W.t);
    }
  }
  
  final void t()
  {
    if (aic.M)
    {
      localIntent = new Intent(this, PhoneContactsSelector.class);
      localIntent.putExtra("jid", this.t);
      if (this.L == null) {}
      for (long l = 0L;; l = this.L.Q)
      {
        localIntent.putExtra("quoted_message_row_id", l);
        localIntent.putExtra("has_number_from_url", this.A);
        startActivityForResult(localIntent, 9);
        u = false;
        return;
      }
    }
    Intent localIntent = new Intent("android.intent.action.PICK");
    localIntent.setType("vnd.android.cursor.dir/contact");
    try
    {
      startActivityForResult(localIntent, 7);
      u = false;
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      pv.a(this, 2131296289, 0);
    }
  }
  
  final void u()
  {
    this.K.removeCallbacks(this.P);
    if (ar()) {}
    for (this.G.t = true;; this.G.t = false)
    {
      aq();
      this.K.setEmojiPopup(this.G);
      this.G.a(this.bR, this.cX, this.cU);
      return;
      this.U.setTranscriptMode(2);
      this.ci.sendEmptyMessageDelayed(0, 1000L);
    }
  }
  
  final void v()
  {
    if (this.G.isShowing()) {
      this.G.dismiss();
    }
  }
  
  final boolean w()
  {
    if (this.Z != null) {
      return false;
    }
    if (this.bj != null) {
      this.bj.c();
    }
    Log.i("conversation/selectionrequested");
    this.U.setTranscriptMode(0);
    this.V.notifyDataSetChanged();
    this.Z = a(new aaf(this, this.ao, this.aq, this.cv, this.aB, this.Q, this.ae, this.ag, this.ah)
    {
      public final Map<j.b, com.whatsapp.protocol.j> a()
      {
        return Conversation.this.aa;
      }
      
      public final void a(android.support.v7.view.b paramAnonymousb)
      {
        super.a(paramAnonymousb);
        Conversation.this.aa = null;
        Conversation.e(Conversation.this).notifyDataSetChanged();
        Conversation.this.Z = null;
      }
      
      public final boolean a(android.support.v7.view.b paramAnonymousb, MenuItem paramAnonymousMenuItem)
      {
        if ((Conversation.this.aa == null) || (Conversation.this.aa.size() == 0)) {
          return true;
        }
        if ((paramAnonymousMenuItem.getItemId() == 2131755029) || (paramAnonymousMenuItem.getItemId() == 2131755030) || (paramAnonymousMenuItem.getItemId() == 2131755058) || (paramAnonymousMenuItem.getItemId() == 2131755086) || (paramAnonymousMenuItem.getItemId() == 2131755085))
        {
          Conversation.this.a(paramAnonymousMenuItem.getItemId(), qz.b(c()));
          b();
          return true;
        }
        if (paramAnonymousMenuItem.getItemId() == 2131755068)
        {
          Conversation.a(Conversation.this, c());
          b();
          return true;
        }
        return super.a(paramAnonymousb, paramAnonymousMenuItem);
      }
      
      public final void b()
      {
        if (Conversation.this.Z != null) {
          Conversation.this.Z.c();
        }
      }
      
      public final boolean b(android.support.v7.view.b paramAnonymousb, Menu paramAnonymousMenu)
      {
        super.b(paramAnonymousb, paramAnonymousMenu);
        if ((Conversation.X(Conversation.this)) && (!Conversation.aB(Conversation.this).b(Conversation.this.W.t))) {
          this.q.setVisible(false);
        }
        return true;
      }
    });
    return true;
  }
  
  public final ArrayList<String> x()
  {
    return this.bX;
  }
  
  public final String y()
  {
    return this.bW;
  }
  
  public final int z()
  {
    return 0;
  }
  
  public static final class a
    extends android.support.v4.app.m
  {
    final br aa = br.a();
    final atv ab = atv.a();
    private final e ac = e.a();
    
    public final Dialog c(Bundle paramBundle)
    {
      paramBundle = l();
      boolean bool = i().getBoolean("is_video_call");
      Object localObject = (String)a.d.a(i().getString("jid"));
      localObject = this.ac.d((String)localObject);
      if (bool) {}
      for (int i = 2131298107;; i = 2131296342)
      {
        android.support.v7.app.b.a locala = new android.support.v7.app.b.a(paramBundle);
        locala.b(i);
        locala.a(2131296369, ht.a(this, (cs)localObject, paramBundle, bool));
        locala.b(2131296398, null);
        paramBundle = locala.a();
        paramBundle.setCanceledOnTouchOutside(true);
        return paramBundle;
      }
    }
  }
  
  public static final class b
    extends android.support.v4.app.m
  {
    public final Dialog c(Bundle paramBundle)
    {
      paramBundle = new android.support.v7.app.b.a(l());
      paramBundle.a(m().getStringArray(2131689478), hu.a(this));
      paramBundle = paramBundle.a();
      paramBundle.setCanceledOnTouchOutside(true);
      return paramBundle;
    }
  }
  
  final class c
    extends BitmapDrawable
  {
    private Paint b;
    
    public c(Resources paramResources, Bitmap paramBitmap)
    {
      super(paramBitmap);
    }
    
    public final void draw(Canvas paramCanvas)
    {
      if (this.b == null)
      {
        this.b = new Paint();
        this.b.setAntiAlias(true);
        this.b.setStrokeJoin(Paint.Join.ROUND);
        this.b.setStrokeCap(Paint.Cap.ROUND);
        this.b.setStrokeWidth(1.0F * Conversation.N().a);
      }
      super.draw(paramCanvas);
      float f = Conversation.this.getResources().getDimension(2131361833);
      RectF localRectF = new RectF(getBounds());
      this.b.setStyle(Paint.Style.STROKE);
      this.b.setColor(1493172224);
      if (f > 0.0F)
      {
        paramCanvas.drawRoundRect(localRectF, f, f, this.b);
        return;
      }
      paramCanvas.drawArc(localRectF, 0.0F, 360.0F, true, this.b);
    }
  }
  
  final class d
    extends CursorAdapter
  {
    private com.whatsapp.protocol.j b;
    private int c;
    
    public d(Context paramContext)
    {
      super(null, false);
    }
    
    private int a()
    {
      return getCursor().getCount() + Conversation.W(Conversation.this).size() - Conversation.Y(Conversation.this);
    }
    
    private int a(com.whatsapp.protocol.j paramj, int paramInt)
    {
      int k = 0;
      if (!av.d()) {
        return -1;
      }
      if (!b(paramj, paramInt)) {
        return -1;
      }
      int j = paramInt - 1;
      int i = 0;
      com.whatsapp.protocol.j localj;
      for (Object localObject = paramj; (j >= 0) && (i < 3); localObject = localj)
      {
        localj = a(j);
        if ((localj == null) || (Math.abs(((com.whatsapp.protocol.j)localObject).n - localj.n) > 610000L) || (!b(localj, j)) || (!com.whatsapp.util.l.a(localj.n, paramj.n)) || (!a(paramj, localj))) {
          break;
        }
        j -= 1;
        i += 1;
      }
      paramInt += 1;
      localObject = paramj;
      j = k;
      while ((paramInt < getCount()) && (j < 102))
      {
        localj = a(paramInt);
        if ((localj == null) || (Math.abs(((com.whatsapp.protocol.j)localObject).n - localj.n) > 610000L) || (!b(localj, paramInt)) || (!com.whatsapp.util.l.a(localj.n, paramj.n)) || (!a(paramj, localj))) {
          break;
        }
        j += 1;
        paramInt += 1;
        localObject = localj;
      }
      if ((i + 1 + j < 4) || (j >= 102)) {
        return -1;
      }
      if (j == 101) {
        return 1;
      }
      if (i == 0) {
        return 1;
      }
      if (j == 0) {
        return 3;
      }
      return 2;
    }
    
    private static boolean a(com.whatsapp.protocol.j paramj1, com.whatsapp.protocol.j paramj2)
    {
      if (paramj1.e.b != paramj2.e.b) {}
      do
      {
        return false;
        if (paramj1.e.b) {
          return true;
        }
      } while ((paramj1.f != null) && (!paramj1.f.equals(paramj2.f)));
      return true;
    }
    
    private boolean b(com.whatsapp.protocol.j paramj, int paramInt)
    {
      return (paramj.Q > 0L) && (paramj.Q <= Conversation.bj(Conversation.this)) && ((paramj.s == 1) || (paramj.s == 3)) && (paramInt < a()) && (TextUtils.isEmpty(paramj.z));
    }
    
    public final com.whatsapp.protocol.j a(int paramInt)
    {
      Object localObject;
      if ((Conversation.Y(Conversation.this) > 0) && (paramInt == a()))
      {
        if (this.b == null) {
          this.b = new com.whatsapp.protocol.j(Conversation.R(Conversation.this), null, "dummy msg!");
        }
        localObject = this.b;
        return (com.whatsapp.protocol.j)localObject;
      }
      if (paramInt > a()) {}
      int j;
      for (int i = paramInt - 1;; i = paramInt)
      {
        j = getCursor().getCount();
        if (i >= j) {
          break label355;
        }
        com.whatsapp.protocol.j localj = (com.whatsapp.protocol.j)Conversation.ay(Conversation.this).get(i);
        localObject = localj;
        if (localj != null) {
          break;
        }
        int k = getCursor().getPosition();
        getCursor().moveToPosition(j - 1 - i);
        int m = getCursor().getPosition();
        try
        {
          localObject = Conversation.ax(Conversation.this).a(getCursor(), Conversation.h(Conversation.this));
          if ((m < k) && ((m <= this.c) || (m > this.c + 50)))
          {
            this.c = Math.max(0, m - 50);
            getCursor().moveToPosition(this.c);
          }
          Conversation.ay(Conversation.this).put(i, localObject);
          return (com.whatsapp.protocol.j)localObject;
        }
        catch (CursorIndexOutOfBoundsException localCursorIndexOutOfBoundsException)
        {
          Log.e("conversation/cursor-out-of-bounds cursorCount:" + j + " dataPosition:" + i + " viewPosition:" + paramInt + " appended:" + Conversation.W(Conversation.this).size() + " unseenRowCount:" + Conversation.Y(Conversation.this) + " old_pos:" + k + " new_pos:" + m + " cursor-count:" + getCursor().getCount());
          throw localCursorIndexOutOfBoundsException;
        }
      }
      label355:
      paramInt = i - j;
      if ((paramInt >= 0) && (paramInt < Conversation.W(Conversation.this).size())) {
        return (com.whatsapp.protocol.j)Conversation.W(Conversation.this).get(i - j);
      }
      return null;
    }
    
    public final void bindView(View paramView, Context paramContext, Cursor paramCursor)
    {
      throw new IllegalStateException("should not be called, getView is defined");
    }
    
    public final int getCount()
    {
      int i = 0;
      if ((!Conversation.bb(Conversation.this)) || (getCursor() == null))
      {
        Log.d("conversation/adapter/getcount/nocursor 0");
        return 0;
      }
      int j = getCursor().getCount();
      int k = Conversation.W(Conversation.this).size();
      if (Conversation.Y(Conversation.this) > 0) {
        i = 1;
      }
      return i + (j + k);
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      if (!Conversation.bb(Conversation.this)) {
        return -1;
      }
      if ((Conversation.Y(Conversation.this) > 0) && (paramInt == a())) {
        return 20;
      }
      com.whatsapp.protocol.j localj = a(paramInt);
      paramInt = a(localj, paramInt);
      if (paramInt == -1) {
        return jd.a(localj);
      }
      if (paramInt == 1)
      {
        if (localj.e.b) {
          return 34;
        }
        return 35;
      }
      return 36;
    }
    
    public final View getView(int paramInt, View paramView, final ViewGroup paramViewGroup)
    {
      Object localObject1;
      if (paramInt == a())
      {
        if (paramView != null)
        {
          paramViewGroup = paramView;
          localObject1 = (TextView)paramViewGroup.findViewById(2131755648);
          if ((Conversation.ab(Conversation.this) <= 0) || (Conversation.ac(Conversation.this) <= 0)) {
            break label178;
          }
          paramView = String.format(u.a.a(2131230812, Conversation.ab(Conversation.this)), new Object[] { Integer.valueOf(Conversation.ab(Conversation.this)) });
          localObject2 = String.format(u.a.a(2131230766, Conversation.ac(Conversation.this)), new Object[] { Integer.valueOf(Conversation.ac(Conversation.this)) });
          paramView = Conversation.this.getString(2131298066, new Object[] { paramView, localObject2 });
        }
        for (;;)
        {
          ((TextView)localObject1).setText(paramView);
          return paramViewGroup;
          paramViewGroup = al.a(Conversation.this.aq, Conversation.this.getLayoutInflater(), 2130903178, paramViewGroup, false);
          break;
          label178:
          if (Conversation.ab(Conversation.this) > 0) {
            paramView = String.format(u.a.a(2131230812, Conversation.ab(Conversation.this)), new Object[] { Integer.valueOf(Conversation.ab(Conversation.this)) });
          } else if (Conversation.ac(Conversation.this) > 0) {
            paramView = String.format(u.a.a(2131230766, Conversation.ac(Conversation.this)), new Object[] { Integer.valueOf(Conversation.ac(Conversation.this)) });
          } else {
            paramView = "";
          }
        }
      }
      Object localObject2 = a(paramInt);
      if ((((com.whatsapp.protocol.j)localObject2).s == 8) && (av.d())) {
        throw new IllegalStateException("presenting call log in conversation page");
      }
      int k = a((com.whatsapp.protocol.j)localObject2, paramInt);
      ConversationRowAlbum localConversationRowAlbum;
      ArrayList localArrayList;
      int i;
      boolean bool;
      if (paramView != null)
      {
        paramViewGroup = (hy)paramView;
        if (!(paramViewGroup instanceof ConversationRowAlbum)) {
          break label1121;
        }
        localConversationRowAlbum = (ConversationRowAlbum)paramViewGroup;
        localArrayList = new ArrayList(4);
        localArrayList.add(localObject2);
        i = paramInt + 1;
        bool = false;
        paramView = (View)localObject2;
        label379:
        if (i >= getCount()) {
          break label664;
        }
        localObject1 = a(i);
        if ((localObject1 == null) || (Math.abs(paramView.n - ((com.whatsapp.protocol.j)localObject1).n) > 610000L) || (!b((com.whatsapp.protocol.j)localObject1, i)) || (!com.whatsapp.util.l.a(((com.whatsapp.protocol.j)localObject1).n, ((com.whatsapp.protocol.j)localObject2).n)) || (!a((com.whatsapp.protocol.j)localObject2, (com.whatsapp.protocol.j)localObject1))) {
          break label664;
        }
        localArrayList.add(localObject1);
        if ((!Conversation.an(Conversation.this).contains(((com.whatsapp.protocol.j)localObject1).e)) && (!Conversation.bc(Conversation.this).contains(((com.whatsapp.protocol.j)localObject1).e)) && (Conversation.this.Z == null) && (Conversation.bd(Conversation.this) == null) && (paramViewGroup.s == Conversation.be(Conversation.this))) {
          break label658;
        }
      }
      label658:
      for (int j = 1;; j = 0)
      {
        Conversation.bc(Conversation.this).remove(((com.whatsapp.protocol.j)localObject1).e);
        Conversation.an(Conversation.this).remove(((com.whatsapp.protocol.j)localObject1).e);
        i += 1;
        bool = j | bool;
        paramView = (View)localObject1;
        break label379;
        paramViewGroup = Conversation.this.ai;
        localObject1 = Conversation.this;
        if (k == -1)
        {
          paramViewGroup = paramViewGroup.a((Context)localObject1, (com.whatsapp.protocol.j)localObject2);
          break;
        }
        if (k == 1)
        {
          paramViewGroup = new ConversationRowAlbum((Context)localObject1, (com.whatsapp.protocol.j)localObject2);
          break;
        }
        paramViewGroup = new iw((Context)localObject1, (com.whatsapp.protocol.j)localObject2);
        break;
      }
      label664:
      localConversationRowAlbum.a(localArrayList, bool);
      paramViewGroup.s = Conversation.be(Conversation.this);
      Conversation.bf(Conversation.this).a(paramViewGroup);
      if (Conversation.an(Conversation.this).contains(((com.whatsapp.protocol.j)localObject2).e))
      {
        Conversation.an(Conversation.this).remove(((com.whatsapp.protocol.j)localObject2).e);
        if (!Conversation.this.T()) {
          paramViewGroup.b(((com.whatsapp.protocol.j)localObject2).T);
        }
      }
      if ((Conversation.bg(Conversation.this) != null) && (Conversation.bg(Conversation.this).equals(((com.whatsapp.protocol.j)localObject2).e)))
      {
        Conversation.bh(Conversation.this);
        paramViewGroup.b();
      }
      if ((Conversation.bi(Conversation.this) != null) && (paramViewGroup.a(Conversation.bi(Conversation.this))))
      {
        Conversation.a(Conversation.this, null);
        paramViewGroup.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
        {
          public final boolean onPreDraw()
          {
            paramViewGroup.getViewTreeObserver().removeOnPreDrawListener(this);
            hy localhy = paramViewGroup;
            at.a locala = new at.a(localhy, (byte)0);
            locala.setDuration(2400L);
            locala.setInterpolator(new AccelerateInterpolator());
            localhy.startAnimation(locala);
            return true;
          }
        });
      }
      if ((k == -1) || (k == 1)) {
        if (paramInt == 0)
        {
          paramViewGroup.a(true);
          paramView = null;
          bool = false;
        }
      }
      for (;;)
      {
        label863:
        if (k == -1)
        {
          j = 0;
          i = j;
          if (bool)
          {
            i = j;
            if (paramView != null)
            {
              i = j;
              if (paramView.e.b == ((com.whatsapp.protocol.j)localObject2).e.b)
              {
                i = j;
                if (((com.whatsapp.protocol.j)localObject2).d != 6)
                {
                  i = j;
                  if (paramView.d != 6)
                  {
                    if ((!((com.whatsapp.protocol.j)localObject2).e.b) && (((com.whatsapp.protocol.j)localObject2).f != null) && (!((com.whatsapp.protocol.j)localObject2).f.equals(paramView.f))) {
                      break label1354;
                    }
                    i = 1;
                  }
                }
              }
            }
          }
          label975:
          paramView = a(paramInt + 1);
          if ((paramView == null) || (com.whatsapp.util.l.a(paramView.n, ((com.whatsapp.protocol.j)localObject2).n)))
          {
            j = 1;
            label1005:
            k = 0;
            paramInt = k;
            if (j != 0)
            {
              paramInt = k;
              if (paramView != null)
              {
                paramInt = k;
                if (paramView.e.b == ((com.whatsapp.protocol.j)localObject2).e.b)
                {
                  paramInt = k;
                  if (((com.whatsapp.protocol.j)localObject2).d != 6)
                  {
                    paramInt = k;
                    if (paramView.d != 6)
                    {
                      if ((!((com.whatsapp.protocol.j)localObject2).e.b) && (((com.whatsapp.protocol.j)localObject2).f != null) && (!((com.whatsapp.protocol.j)localObject2).f.equals(paramView.f))) {
                        break label1366;
                      }
                      paramInt = 1;
                    }
                  }
                }
              }
            }
            label1105:
            if ((i == 0) || (paramInt == 0)) {
              break label1371;
            }
            paramViewGroup.b(2);
          }
        }
        for (;;)
        {
          return paramViewGroup;
          label1121:
          if ((paramViewGroup instanceof iw))
          {
            paramView = (iw)paramViewGroup;
            if (k == 3) {}
            for (i = 1;; i = 0)
            {
              paramView.setFixedHeight(i);
              paramViewGroup.a((com.whatsapp.protocol.j)localObject2, false);
              break;
            }
          }
          if (paramView == null) {
            break;
          }
          if ((Conversation.an(Conversation.this).contains(((com.whatsapp.protocol.j)localObject2).e)) || (Conversation.bc(Conversation.this).contains(((com.whatsapp.protocol.j)localObject2).e)) || (Conversation.this.Z != null) || (Conversation.bd(Conversation.this) != null) || (paramViewGroup.s != Conversation.be(Conversation.this)) || (com.whatsapp.protocol.m.d((com.whatsapp.protocol.j)localObject2))) {}
          for (bool = true;; bool = false)
          {
            paramViewGroup.a((com.whatsapp.protocol.j)localObject2, bool);
            Conversation.bc(Conversation.this).remove(((com.whatsapp.protocol.j)localObject2).e);
            break;
          }
          paramView = a(paramInt - 1);
          if ((paramView == this.b) && (paramInt > 1)) {}
          for (localObject1 = a(paramInt - 2);; localObject1 = paramView)
          {
            bool = com.whatsapp.util.l.a(((com.whatsapp.protocol.j)localObject1).n, ((com.whatsapp.protocol.j)localObject2).n);
            if (bool) {
              break label1346;
            }
            paramViewGroup.a(true);
            break;
          }
          label1346:
          paramViewGroup.a(false);
          break label863;
          label1354:
          i = 0;
          break label975;
          j = 0;
          break label1005;
          label1366:
          paramInt = 0;
          break label1105;
          label1371:
          if (i != 0)
          {
            paramViewGroup.b(3);
          }
          else if (paramInt != 0)
          {
            paramViewGroup.b(1);
          }
          else
          {
            paramViewGroup.b(-1);
            continue;
            paramViewGroup.b(-1);
          }
        }
        paramView = null;
        bool = false;
      }
    }
    
    public final int getViewTypeCount()
    {
      if (Conversation.Y(Conversation.this) > 0) {}
      for (int i = 1;; i = 0) {
        return i + 37;
      }
    }
    
    public final boolean hasStableIds()
    {
      return true;
    }
    
    public final View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
    {
      throw new IllegalStateException("should not be called, getView is defined");
    }
    
    public final void notifyDataSetChanged()
    {
      super.notifyDataSetChanged();
      if (Conversation.aY(Conversation.this))
      {
        Conversation.aZ(Conversation.this);
        Conversation.ba(Conversation.this);
        Log.d("conversation/adapter/dbgscroll/notifydatasetchanged/dividercentered/true freeze=false scrolltotop=false");
      }
    }
    
    protected final void onContentChanged() {}
  }
  
  final class e
    extends AsyncTask<Void, Void, String>
  {
    String a;
    private Handler c;
    private Runnable d;
    private long e;
    private boolean f;
    
    public e(String paramString, boolean paramBoolean)
    {
      this.a = paramString;
      this.f = paramBoolean;
      this.e = SystemClock.uptimeMillis();
    }
    
    protected final void a()
    {
      super.cancel(false);
      if (this.c != null) {
        this.c.removeCallbacks(this.d);
      }
      this.c = null;
      this.d = null;
    }
  }
  
  final class f
    implements Runnable
  {
    private f() {}
    
    public final void run()
    {
      int i = Conversation.aW(Conversation.this).getWidth();
      TranslateAnimation localTranslateAnimation;
      if (Conversation.this.aq.d())
      {
        f = -i;
        localTranslateAnimation = new TranslateAnimation(0, 0.0F, 0, f, 0, 0.0F, 0, 0.0F);
        localTranslateAnimation.setFillAfter(true);
        localTranslateAnimation.setDuration(800L);
        Conversation.aW(Conversation.this).startAnimation(localTranslateAnimation);
        Conversation.aW(Conversation.this).setVisibility(8);
        if (!Conversation.this.aq.d()) {
          break label141;
        }
      }
      label141:
      for (float f = i;; f = -i)
      {
        localTranslateAnimation = new TranslateAnimation(0, f, 0, 0.0F, 0, 0.0F, 0, 0.0F);
        localTranslateAnimation.setFillAfter(true);
        localTranslateAnimation.setDuration(800L);
        Conversation.aX(Conversation.this).startAnimation(localTranslateAnimation);
        return;
        f = i;
        break;
      }
    }
  }
  
  final class g
    extends AsyncTask<Void, Void, ad.e>
  {
    private int b;
    private boolean c;
    
    g(int paramInt)
    {
      this.b = paramInt;
    }
    
    protected final void onCancelled()
    {
      Conversation.aw(Conversation.this);
    }
  }
  
  static final class h
    extends android.support.v7.c.a.a
  {
    int a;
    int b;
    int c;
    int d;
    
    public h(Drawable paramDrawable)
    {
      super();
    }
    
    final void a(int paramInt)
    {
      this.a = 0;
      this.b = paramInt;
      this.c = 0;
      this.d = 0;
      invalidateSelf();
    }
    
    public final void draw(Canvas paramCanvas)
    {
      Rect localRect = getBounds();
      a().setBounds(localRect.left + this.a, localRect.top + this.b, localRect.right - this.c, localRect.bottom - this.d);
      a().draw(paramCanvas);
    }
  }
  
  final class i
    extends AsyncTask<Void, Void, Bitmap>
  {
    private i() {}
  }
  
  static final class j
    implements InputFilter
  {
    private WeakReference<aqs> a;
    
    j(aqs paramaqs)
    {
      this.a = new WeakReference(paramaqs);
    }
    
    public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      paramCharSequence = (aqs)this.a.get();
      if ((paramCharSequence != null) && (paramCharSequence.e())) {
        return "";
      }
      return null;
    }
  }
  
  final class k
    extends AsyncTask<Void, Void, Void>
  {
    private final ProgressDialog b;
    private final String c;
    private final boolean d;
    private final com.whatsapp.protocol.j e;
    private ad.e f;
    private com.whatsapp.protocol.j g;
    private int h;
    
    public k(String paramString, boolean paramBoolean, com.whatsapp.protocol.j paramj)
    {
      this.c = paramString;
      this.d = paramBoolean;
      this.e = paramj;
      this.b = ProgressDialog.show(Conversation.this, "", Conversation.this.getString(2131297645), true, false);
      this.b.setCancelable(true);
      com.whatsapp.fieldstats.l.a(u.a(), new q());
    }
  }
  
  public static final class l
  {
    final Conversation a;
    public final boolean b;
    
    public l(Conversation paramConversation, boolean paramBoolean)
    {
      this.a = paramConversation;
      this.b = paramBoolean;
    }
    
    public final Conversation a()
    {
      if (!this.b) {
        throw new AssertionError("no active session");
      }
      return this.a;
    }
    
    public final boolean a(String paramString)
    {
      return (this.b) && (Conversation.h(this.a).equals(paramString)) && (!((com.whatsapp.g.l)b.a.a.c.a().a(com.whatsapp.g.l.class)).a);
    }
  }
  
  final class m
    extends Handler
  {
    public m()
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      if (!((com.whatsapp.g.l)b.a.a.c.a().a(com.whatsapp.g.l.class)).a)
      {
        Conversation.aQ(Conversation.this).b();
        Log.d("conversation/statusbarrefresher/refresh");
        if (Conversation.aR(Conversation.this))
        {
          Conversation.aQ(Conversation.this).c();
          Log.d("conversation/statusbarrefresher/statusbar/cancel");
        }
        Conversation.aS(Conversation.this);
        Conversation.aT(Conversation.this);
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/Conversation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */