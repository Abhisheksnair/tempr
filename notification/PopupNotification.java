package com.whatsapp.notification;

import a.a.a.a.a.a;
import a.a.a.a.a.a.d;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.support.v4.app.aw;
import android.support.v4.view.ViewPager.f;
import android.support.v7.app.b.a;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.format.DateUtils;
import android.text.format.Formatter;
import android.text.method.TextKeyListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.whatsapp.EmojiPicker.c;
import com.whatsapp.TextEmojiLabel;
import com.whatsapp.ThumbnailButton;
import com.whatsapp.abu;
import com.whatsapp.agq;
import com.whatsapp.ahc;
import com.whatsapp.al;
import com.whatsapp.amb;
import com.whatsapp.and;
import com.whatsapp.ans;
import com.whatsapp.ant;
import com.whatsapp.aoa;
import com.whatsapp.aoj;
import com.whatsapp.aq;
import com.whatsapp.aqs;
import com.whatsapp.atu;
import com.whatsapp.atv;
import com.whatsapp.aus;
import com.whatsapp.cc;
import com.whatsapp.cc.a;
import com.whatsapp.data.cq;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.dh;
import com.whatsapp.dh.a;
import com.whatsapp.el;
import com.whatsapp.emoji.search.i;
import com.whatsapp.hy;
import com.whatsapp.ka;
import com.whatsapp.kc;
import com.whatsapp.lt;
import com.whatsapp.ng;
import com.whatsapp.os;
import com.whatsapp.oz;
import com.whatsapp.pc;
import com.whatsapp.pd;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.pv;
import com.whatsapp.qz;
import com.whatsapp.rh;
import com.whatsapp.rl;
import com.whatsapp.tb;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils;
import com.whatsapp.util.ag;
import com.whatsapp.util.ag.a;
import com.whatsapp.util.az;
import com.whatsapp.util.be;
import com.whatsapp.va;
import com.whatsapp.vp;
import com.whatsapp.vv;
import com.whatsapp.yx;
import com.whatsapp.yx.b;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class PopupNotification
  extends android.support.v4.app.n
{
  private static int H = 200;
  private static String I = "permission_fragment";
  public static PopupNotification n;
  boolean A;
  String B;
  final e C = e.a();
  final com.whatsapp.util.b D = com.whatsapp.util.b.a();
  final aq E = aq.a();
  final pd F = pd.a();
  EmojiPicker.c G = new EmojiPicker.c()
  {
    public final void a() {}
    
    public final void a(int paramAnonymousInt)
    {
      if (PopupNotification.y(PopupNotification.this).e()) {
        return;
      }
      int i = PopupNotification.t(PopupNotification.this).getSelectionStart();
      int j = PopupNotification.t(PopupNotification.this).getSelectionEnd();
      int k;
      if (i > j)
      {
        k = j;
        j = i;
      }
      for (;;)
      {
        StringBuilder localStringBuilder = new StringBuilder(PopupNotification.t(PopupNotification.this).getText().toString());
        localStringBuilder.replace(k, j, com.whatsapp.emoji.c.b(paramAnonymousInt));
        PopupNotification.t(PopupNotification.this).setText(localStringBuilder);
        if (k > PopupNotification.t(PopupNotification.this).length() - com.whatsapp.emoji.c.a(paramAnonymousInt)) {
          break;
        }
        PopupNotification.t(PopupNotification.this).setSelection(k + com.whatsapp.emoji.c.a(paramAnonymousInt));
        return;
        k = i;
      }
    }
  };
  private aoa J;
  private View.OnClickListener K;
  private HashSet<j.b> L = new HashSet();
  private tb M;
  private Button N;
  private TextEmojiLabel O;
  private TextView P;
  private TextView Q;
  private View R;
  private View S;
  private ImageButton T;
  private SensorManager U;
  private Sensor V;
  private SensorEventListener W;
  private i X;
  private Integer Y;
  private int Z;
  private final cq aA = cq.a();
  private final ka aB = ka.a();
  private final rh aC = rh.a();
  private final dh aD = dh.a();
  private final dh.a aE = new dh.a()
  {
    public final void a()
    {
      if (!PopupNotification.a(PopupNotification.this).isEmpty()) {
        PopupNotification.this.b(PopupNotification.b(PopupNotification.this).getCurrentItem());
      }
    }
    
    protected final void a(String paramAnonymousString)
    {
      if ((!PopupNotification.a(PopupNotification.this).isEmpty()) && ((TextUtils.equals(PopupNotification.c(PopupNotification.this).e.a, paramAnonymousString)) || (TextUtils.equals(PopupNotification.c(PopupNotification.this).f, paramAnonymousString)))) {
        PopupNotification.this.b(PopupNotification.b(PopupNotification.this).getCurrentItem());
      }
    }
    
    public final void b(String paramAnonymousString)
    {
      if ((PopupNotification.d(PopupNotification.this) != null) && (paramAnonymousString.equals(PopupNotification.d(PopupNotification.this).t))) {
        PopupNotification.e(PopupNotification.this);
      }
    }
    
    public final void d(String paramAnonymousString)
    {
      if ((PopupNotification.d(PopupNotification.this) != null) && (paramAnonymousString.equals(PopupNotification.d(PopupNotification.this).t)) && (!qz.e(paramAnonymousString)))
      {
        paramAnonymousString = PopupNotification.f(PopupNotification.this).b(PopupNotification.d(PopupNotification.this));
        if (TextUtils.isEmpty(paramAnonymousString)) {
          PopupNotification.g(PopupNotification.this).setVisibility(8);
        }
      }
      else
      {
        return;
      }
      PopupNotification.g(PopupNotification.this).setVisibility(0);
      PopupNotification.g(PopupNotification.this).setText(paramAnonymousString);
    }
  };
  private float aF = 5.0F;
  private Handler aG = new Handler(Looper.getMainLooper());
  private Runnable aH = n.a(this);
  private Handler aI = new Handler(Looper.getMainLooper());
  private Runnable aJ = new Runnable()
  {
    public final void run()
    {
      if (PopupNotification.A(PopupNotification.this) != null) {
        PopupNotification.B(PopupNotification.this).unregisterListener(PopupNotification.A(PopupNotification.this));
      }
      PopupNotification.C(PopupNotification.this);
      if (PopupNotification.D(PopupNotification.this) != null)
      {
        Log.i("popupnotification/proximity:" + PopupNotification.E(PopupNotification.this) + " max:" + PopupNotification.D(PopupNotification.this).getMaximumRange());
        if ((PopupNotification.E(PopupNotification.this) >= 5.0F) || (PopupNotification.E(PopupNotification.this) == PopupNotification.D(PopupNotification.this).getMaximumRange())) {
          PopupNotification.F(PopupNotification.this);
        }
        return;
      }
      Log.i("popupnotification/no proximity sensor");
      PopupNotification.F(PopupNotification.this);
    }
  };
  private final ant aa = ant.a();
  private final pv ab = pv.a();
  private final com.whatsapp.util.a.c ac = com.whatsapp.util.a.c.a();
  private final va ad = va.a();
  private final com.whatsapp.util.h ae = com.whatsapp.util.h.a();
  private final com.whatsapp.data.d af = com.whatsapp.data.d.a();
  private final oz ag = oz.a();
  private final ahc ah = ahc.a();
  private final com.whatsapp.messaging.w ai = com.whatsapp.messaging.w.a();
  private final aoj aj = aoj.a();
  private final vp ak = vp.a();
  private final com.whatsapp.data.ad al = com.whatsapp.data.ad.a();
  private final com.whatsapp.emoji.h am = com.whatsapp.emoji.h.a();
  private final el an = el.a();
  private final and ao = and.a();
  private final aus ap = aus.a();
  private final pc aq = pc.a();
  private final abu ar = abu.a();
  private final cc as = cc.a();
  private final vv at = vv.a();
  private final ag au = ag.a();
  private final rl av = rl.a();
  private final f aw = f.a();
  private final atu ax = atu.a();
  private final atv ay = atv.a();
  private final lt az = lt.a();
  boolean o;
  List<j> p = new ArrayList();
  cs q;
  j r;
  HashSet<j.b> s = new HashSet();
  HashSet<String> t = new HashSet();
  PopupNotificationViewPager u;
  kc v;
  ImageButton w;
  aqs x;
  PowerManager.WakeLock y;
  os z;
  
  private View a(j paramj)
  {
    final ans localans = new ans(this);
    a(localans);
    localans.setIcon(getResources().getDrawable(2130840345));
    this.au.b(paramj, localans, new ag.a()
    {
      public final int a()
      {
        return PopupNotification.z(PopupNotification.this).c();
      }
      
      public final void a(View paramAnonymousView)
      {
        localans.setImageDrawable(new ColorDrawable(-7829368));
      }
      
      public final void a(View paramAnonymousView, Bitmap paramAnonymousBitmap, j paramAnonymousj)
      {
        if (paramAnonymousBitmap != null)
        {
          localans.setImageBitmap(paramAnonymousBitmap);
          return;
        }
        localans.setImageResource(2130840352);
      }
    });
    String str = null;
    for (;;)
    {
      try
      {
        if (paramj.w == 0) {
          continue;
        }
        str = DateUtils.formatElapsedTime(paramj.w);
        localans.setText(str);
      }
      catch (IllegalArgumentException paramj)
      {
        continue;
      }
      localans.setOnClickListener(this.K);
      return localans;
      if (paramj.t > 0L) {
        str = Formatter.formatShortFileSize(com.whatsapp.u.a(), paramj.t);
      }
    }
  }
  
  private void a(ThumbnailButton paramThumbnailButton)
  {
    int i = getResources().getDimensionPixelSize(2131362071);
    paramThumbnailButton.setMinimumHeight(i);
    paramThumbnailButton.setMaxHeight(i);
    paramThumbnailButton.setAdjustViewBounds(true);
    paramThumbnailButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
    int j = (int)this.J.j;
    paramThumbnailButton.setPadding(j, j, j, j);
    paramThumbnailButton.setRadius(this.J.k);
    if ((paramThumbnailButton instanceof ans))
    {
      ((ans)paramThumbnailButton).setTextSize(i / 7.0F);
      ((ans)paramThumbnailButton).setTextGravity(5);
    }
  }
  
  public static void a(String paramString)
  {
    if ((n != null) && (n.o) && (n.q != null) && (paramString.equals(n.q.t))) {
      n.finish();
    }
  }
  
  private View b(j paramj)
  {
    final ans localans = new ans(this);
    a(localans);
    localans.setIcon(getResources().getDrawable(2130840344));
    this.au.b(paramj, localans, new ag.a()
    {
      public final int a()
      {
        return PopupNotification.z(PopupNotification.this).c();
      }
      
      public final void a(View paramAnonymousView)
      {
        localans.setBackgroundColor(-7829368);
      }
      
      public final void a(View paramAnonymousView, Bitmap paramAnonymousBitmap, j paramAnonymousj)
      {
        if (paramAnonymousBitmap != null)
        {
          localans.setImageBitmap(paramAnonymousBitmap);
          return;
        }
        localans.setImageResource(2130840352);
      }
    });
    String str = null;
    for (;;)
    {
      try
      {
        if (paramj.w == 0) {
          continue;
        }
        str = DateUtils.formatElapsedTime(paramj.w);
        localans.setText(str);
      }
      catch (IllegalArgumentException paramj)
      {
        continue;
      }
      localans.setOnClickListener(this.K);
      return localans;
      if (paramj.t > 0L) {
        str = Formatter.formatShortFileSize(com.whatsapp.u.a(), paramj.t);
      }
    }
  }
  
  private View c(j paramj)
  {
    TextView localTextView = new TextView(this);
    localTextView.setText(paramj.y);
    localTextView.setTextSize(hy.a(getResources(), this.ap));
    localTextView.setGravity(17);
    localTextView.setTextColor(-16777216);
    try
    {
      paramj = a.a(com.whatsapp.u.a(), this.C, paramj.e());
      if ((paramj != null) && (paramj.f != null))
      {
        paramj = BitmapFactory.decodeByteArray(paramj.f, 0, paramj.f.length);
        localDrawable = getResources().getDrawable(2130840510);
        if (paramj != null)
        {
          paramj = MediaFileUtils.a(paramj, localDrawable.getIntrinsicWidth(), this.J.k);
          localTextView.setCompoundDrawablesWithIntrinsicBounds(new BitmapDrawable(getResources(), paramj), null, null, null);
          localTextView.setCompoundDrawablePadding((int)this.J.j);
          localTextView.setPadding((int)this.J.j, (int)this.J.j, (int)this.J.j, (int)this.J.j);
          paramj = new RelativeLayout(this);
          paramj.setGravity(17);
          paramj.addView(localTextView);
          return paramj;
        }
      }
    }
    catch (a.a.a.a.a.d paramj)
    {
      for (;;)
      {
        Log.w(paramj);
        paramj = null;
      }
    }
    catch (IOException paramj)
    {
      for (;;)
      {
        Log.e(paramj);
        paramj = null;
      }
    }
    catch (Exception paramj)
    {
      for (;;)
      {
        Drawable localDrawable;
        Log.d("popupnotification/getmessageviewcontact/unexpected error parsing vcard", paramj);
        this.ac.a("PopupNotification getMessageViewContact unexpected vcard parsing exception: " + paramj.getMessage(), false, null, -1);
        paramj = null;
        continue;
        localTextView.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
      }
    }
    catch (UnsupportedEncodingException paramj)
    {
      for (;;)
      {
        continue;
        paramj = null;
      }
    }
  }
  
  private void m()
  {
    Bitmap localBitmap;
    if (this.q != null)
    {
      localBitmap = this.q.a(getResources().getDimensionPixelSize(2131362090), getResources().getDimension(2131361833), true);
      if (localBitmap != null) {
        break label66;
      }
      localBitmap = cs.b(this.q.e());
    }
    label66:
    for (;;)
    {
      ((ImageView)findViewById(2131755998)).setImageBitmap(localBitmap);
      return;
    }
  }
  
  private void n()
  {
    this.aB.a(this.al, this.aw, this.q.t);
    InputMethodManager localInputMethodManager = (InputMethodManager)com.whatsapp.u.a().getSystemService("input_method");
    if (localInputMethodManager.isFullscreenMode()) {
      localInputMethodManager.hideSoftInputFromWindow(this.v.getWindowToken(), 0);
    }
    int j = this.u.getCurrentItem();
    Log.i("popupnotification/moveToNextMessageOrExit/ message_pos:" + j + " messages.size:" + this.p.size());
    this.L.add(((j)this.p.get(j)).e);
    if ((this.p.size() == 1) || ((this.B != null) && (this.Z == 1)))
    {
      i();
      finish();
      return;
    }
    if (j == this.p.size() - 1) {}
    for (int i = j - 1;; i = j + 1)
    {
      this.Y = Integer.valueOf(j);
      this.u.a(i, true);
      if (this.p.size() == 1) {
        o();
      }
      if (this.r != null) {
        this.s.add(this.r.e);
      }
      if (this.q == null) {
        break;
      }
      this.t.add(this.q.t);
      return;
    }
  }
  
  private void o()
  {
    findViewById(2131756012).setVisibility(8);
    findViewById(2131756011).setVisibility(8);
    this.R.setVisibility(8);
    this.S.setVisibility(8);
  }
  
  public final void b(int paramInt)
  {
    while (paramInt < 0) {
      paramInt += this.p.size();
    }
    int i = paramInt % this.p.size();
    this.r = ((j)this.p.get(i));
    this.x.g = this.r.e.a;
    this.q = this.C.a(this.r.e.a);
    if (this.q == null) {
      return;
    }
    if ((this.aq.e()) && (!this.q.d())) {
      this.ar.a(this.q);
    }
    if ((this.p.size() == 1) || (this.A))
    {
      this.s.add(this.r.e);
      this.t.add(this.q.t);
      this.A = false;
    }
    m();
    paramInt = 2131298119;
    label254:
    Object localObject;
    if (this.r.s == 2)
    {
      paramInt = 2131297093;
      this.N.setText(paramInt);
      this.O.setContact(this.q);
      if (!this.q.d()) {
        break label381;
      }
      if (!TextUtils.isEmpty(this.r.f)) {
        break label345;
      }
      this.P.setVisibility(8);
      this.Q.setText(getString(2131297139, new Object[] { Integer.valueOf(i + 1), Integer.valueOf(this.p.size()) }));
      localObject = this.T;
      if (this.v.getText().toString().length() == 0) {
        break label434;
      }
    }
    label345:
    label381:
    label434:
    for (boolean bool = true;; bool = false)
    {
      ((ImageButton)localObject).setEnabled(bool);
      return;
      if (this.r.s != 3) {
        break;
      }
      paramInt = 2131298193;
      break;
      this.P.setText(this.C.d(this.r.f).a(this));
      this.P.setVisibility(0);
      break label254;
      localObject = this.an.b(this.q);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        this.P.setVisibility(8);
        break label254;
      }
      this.P.setVisibility(0);
      this.P.setText((CharSequence)localObject);
      break label254;
    }
  }
  
  public final void b(String paramString)
  {
    Log.i("popupnotification/set-quick-reply-jid:" + paramString);
    this.B = paramString;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return (!yx.g()) && (super.dispatchTouchEvent(paramMotionEvent));
  }
  
  final void i()
  {
    if (n == this)
    {
      Log.i("popupnotification/clearnotifications:" + this.t.size());
      this.F.a(true);
      this.B = null;
      Iterator localIterator1 = this.t.iterator();
      while (localIterator1.hasNext())
      {
        String str = (String)localIterator1.next();
        ArrayList localArrayList = new ArrayList();
        int i = this.al.o(str);
        Iterator localIterator2 = this.s.iterator();
        while (localIterator2.hasNext())
        {
          j.b localb = (j.b)localIterator2.next();
          if ((localb.a != null) && (localb.a.equals(str))) {
            localArrayList.add(localb);
          }
        }
        Log.i("popupnotification/msg:" + localArrayList.size() + "/" + i);
        if (localArrayList.size() == i)
        {
          this.aB.a(this.al, this.aw, str);
          this.s.removeAll(localArrayList);
        }
      }
    }
    this.aw.b();
  }
  
  public final void j()
  {
    Log.i("popupnotification/initpopup");
    this.A = false;
    int j;
    Object localObject1;
    Iterator localIterator;
    if ((this.u.getCurrentItem() == 0) && (this.v.getText().toString().length() == 0))
    {
      j = 1;
      localObject1 = new ArrayList();
      this.Z = 0;
      localIterator = this.az.j().iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label234;
      }
      Object localObject2 = (String)localIterator.next();
      i = this.al.o((String)localObject2);
      if (i > 0)
      {
        Object localObject3 = this.as.a((String)localObject2);
        if (((!TextUtils.isEmpty(this.B)) && (this.B.equals(localObject2))) || ((((cc.a)localObject3).c()) && (Integer.parseInt(((cc.a)localObject3).g()) != 0)))
        {
          localObject2 = this.al.b((String)localObject2, i).iterator();
          for (;;)
          {
            if (((Iterator)localObject2).hasNext())
            {
              localObject3 = (j)((Iterator)localObject2).next();
              if (!this.L.contains(((j)localObject3).e))
              {
                ((ArrayList)localObject1).add(localObject3);
                continue;
                j = 0;
                break;
              }
            }
          }
          this.Z += 1;
        }
      }
    }
    label234:
    Log.i("popupnotification/count:" + ((ArrayList)localObject1).size());
    if (((ArrayList)localObject1).isEmpty())
    {
      finish();
      return;
    }
    if (((ArrayList)localObject1).size() == 1)
    {
      o();
      label284:
      Collections.sort((List)localObject1, u.a());
      this.p = ((List)localObject1);
      this.M.a.c();
      this.u.setAdapter(this.M);
      if (this.r == null) {
        break label740;
      }
      if (j == 0) {
        break label650;
      }
      if (!this.o) {
        break label633;
      }
      this.u.a(1, false, true);
      b(1);
      if (1 < this.p.size()) {
        break label762;
      }
    }
    label397:
    label633:
    label650:
    label740:
    label762:
    for (int i = 0 - this.p.size();; i = 0)
    {
      localObject1 = this.u;
      ((PopupNotificationViewPager)localObject1).h = Integer.valueOf(i);
      ((PopupNotificationViewPager)localObject1).c();
      localObject1 = AnimationUtils.loadAnimation(this, 2130968599);
      if (j != 0) {}
      for (i = 1;; i = 2)
      {
        ((Animation)localObject1).setDuration(i * H);
        ((Animation)localObject1).setFillAfter(true);
        this.Q.startAnimation((Animation)localObject1);
        localObject1 = (j)this.p.get(0);
        localObject1 = this.C.a(((j)localObject1).e.a);
        i = Integer.parseInt(this.as.a(((cs)localObject1).t).g());
        if ((i != 2) && (i != 3)) {
          break;
        }
        getWindow().addFlags(524288);
        Log.i("popupnotification/wakeupifneeded");
        this.aF = 5.0F;
        this.aI.removeCallbacks(this.aJ);
        this.aI.postDelayed(this.aJ, 600L);
        if ((this.W != null) || (this.V == null)) {
          break;
        }
        this.W = new SensorEventListener()
        {
          public final void onAccuracyChanged(Sensor paramAnonymousSensor, int paramAnonymousInt) {}
          
          public final void onSensorChanged(SensorEvent paramAnonymousSensorEvent)
          {
            PopupNotification.a(PopupNotification.this, paramAnonymousSensorEvent.values[0]);
            Log.i("popupnotification/proximity:" + PopupNotification.E(PopupNotification.this));
          }
        };
        this.U.registerListener(this.W, this.V, 0);
        return;
        findViewById(2131756012).setVisibility(0);
        findViewById(2131756011).setVisibility(0);
        this.R.setVisibility(0);
        this.S.setVisibility(0);
        break label284;
        this.u.a(0, false);
        b(0);
        break label397;
        localObject1 = this.p.iterator();
        i = 0;
        while ((((Iterator)localObject1).hasNext()) && (!((j)((Iterator)localObject1).next()).e.equals(this.r.e))) {
          i += 1;
        }
        int k = i;
        if (i == this.p.size()) {
          k = 0;
        }
        this.u.a(k, false);
        b(k);
        break label397;
        this.u.a(0, false);
        b(0);
        break label397;
      }
    }
  }
  
  final void k()
  {
    if (this.q == null) {
      return;
    }
    if (this.E.a(this.q.t))
    {
      a.a.a.a.d.a(this, 106);
      return;
    }
    String str = this.v.getText().toString().trim();
    if (str.length() > 0)
    {
      if (be.b(this, this.ao, str))
      {
        this.aj.a(Collections.singletonList(this.q.t), com.whatsapp.emoji.c.b(str), null, null, null, false, false);
        TextKeyListener.clear(this.v.getText());
      }
      for (;;)
      {
        n();
        return;
        pv.a(this, 2131296401, 1);
      }
    }
    Log.i("popupnotification/sendentry/empty text " + this.p.size());
  }
  
  public void onBackPressed()
  {
    i();
    super.onBackPressed();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.ap.e();
    super.onConfigurationChanged(paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    requestWindowFeature(1);
    if (Build.VERSION.SDK_INT >= 17) {
      getWindow().getDecorView().setLayoutDirection(3);
    }
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(android.support.v4.content.b.c(this, 17170445));
    }
    this.ap.e();
    super.onCreate(paramBundle);
    getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131624090)));
    this.U = ((SensorManager)getSystemService("sensor"));
    this.V = this.U.getDefaultSensor(8);
    Log.i("popupnotification/create");
    paramBundle = this.ao.a;
    Object localObject2;
    Object localObject1;
    int i;
    if (paramBundle == null)
    {
      Log.w("popupnotification/create pm=null");
      paramBundle = al.a(this.ab, getLayoutInflater(), 2130903334, null, false);
      setContentView(paramBundle);
      n = this;
      this.J = aoa.a();
      this.u = ((PopupNotificationViewPager)findViewById(2131756014));
      this.v = ((kc)findViewById(2131755557));
      this.v.setFilters(new InputFilter[] { x.a(this) });
      this.N = ((Button)findViewById(2131756016));
      this.O = ((TextEmojiLabel)findViewById(2131756010));
      this.P = ((TextView)findViewById(2131755461));
      this.Q = ((TextView)findViewById(2131756013));
      localObject2 = (ImageView)findViewById(2131755357);
      ((ImageView)localObject2).setImageDrawable(new az(getResources().getDrawable(2130840499)));
      this.R = findViewById(2131756009);
      localObject1 = (ImageView)findViewById(2131755834);
      ((ImageView)localObject1).setImageDrawable(new az(getResources().getDrawable(2130840500)));
      this.S = findViewById(2131756008);
      this.T = ((ImageButton)findViewById(2131755437));
      this.w = ((ImageButton)findViewById(2131755561));
      this.M = new tb(new a());
      this.u.setAdapter(this.M);
      this.u.a(new ViewPager.f()
      {
        public final void a(int paramAnonymousInt)
        {
          if (paramAnonymousInt == 1) {
            PopupNotification.m(PopupNotification.this);
          }
          if ((paramAnonymousInt == 0) && (PopupNotification.l(PopupNotification.this) != null))
          {
            PopupNotification.a(PopupNotification.this).remove(PopupNotification.l(PopupNotification.this).intValue());
            if (PopupNotification.l(PopupNotification.this).intValue() >= PopupNotification.a(PopupNotification.this).size()) {
              PopupNotification.a(PopupNotification.this, Integer.valueOf(PopupNotification.l(PopupNotification.this).intValue() - 1));
            }
            PopupNotification.n(PopupNotification.this).a.c();
            PopupNotificationViewPager localPopupNotificationViewPager = PopupNotification.b(PopupNotification.this);
            tb localtb = PopupNotification.n(PopupNotification.this);
            paramAnonymousInt = PopupNotification.l(PopupNotification.this).intValue();
            localPopupNotificationViewPager.setAdapter(localtb);
            localPopupNotificationViewPager.setCurrentItem(paramAnonymousInt);
            PopupNotification.this.b(PopupNotification.b(PopupNotification.this).getCurrentItem());
            if (PopupNotification.a(PopupNotification.this).size() == 1) {
              PopupNotification.o(PopupNotification.this);
            }
            PopupNotification.a(PopupNotification.this, null);
          }
        }
        
        public final void a(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2)
        {
          if (PopupNotification.h(PopupNotification.this))
          {
            PopupNotification.i(PopupNotification.this).a(true);
            if (PopupNotification.c(PopupNotification.this) != null) {
              PopupNotification.j(PopupNotification.this).add(PopupNotification.c(PopupNotification.this).e);
            }
            if (PopupNotification.d(PopupNotification.this) != null) {
              PopupNotification.k(PopupNotification.this).add(PopupNotification.d(PopupNotification.this).t);
            }
          }
        }
        
        public final void b(int paramAnonymousInt)
        {
          if (PopupNotification.l(PopupNotification.this) == null) {
            PopupNotification.this.b(PopupNotification.b(PopupNotification.this).getCurrentItem());
          }
        }
      });
      findViewById(2131756015).setOnClickListener(y.a(this));
      this.K = z.a(this);
      this.N.setOnClickListener(this.K);
      View.OnClickListener localOnClickListener = aa.a(this);
      ((ImageView)localObject2).setOnClickListener(localOnClickListener);
      this.R.setOnClickListener(localOnClickListener);
      localObject2 = ab.a(this);
      ((ImageView)localObject1).setOnClickListener((View.OnClickListener)localObject2);
      this.S.setOnClickListener((View.OnClickListener)localObject2);
      this.T.setImageDrawable(new az(android.support.v4.content.b.a(this, 2130840323)));
      localObject1 = findViewById(2131755552);
      ((View)localObject1).setBackgroundResource(2130840040);
      ((View)localObject1).setPadding(0, 0, 0, 0);
      localObject1 = (View)a.d.a(findViewById(2131755551));
      i = Math.max(((View)localObject1).getPaddingLeft(), ((View)localObject1).getPaddingRight());
      localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
      if (!this.ab.d()) {
        break label1014;
      }
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = i;
    }
    for (;;)
    {
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.v.setOnClickListener(ac.a(this));
      al.a(this.ab, getLayoutInflater(), 2130903397, (ViewGroup)findViewById(2131755560), true);
      this.x = new aqs(this, new ng()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, Object... paramAnonymousVarArgs)
        {
          pv.a(com.whatsapp.u.a().getApplicationContext(), PopupNotification.this.getString(paramAnonymousInt2, paramAnonymousVarArgs), 0);
        }
        
        public final boolean b(String paramAnonymousString1, String paramAnonymousString2)
        {
          return false;
        }
        
        public final void b_(int paramAnonymousInt)
        {
          pv.a(com.whatsapp.u.a().getApplicationContext(), paramAnonymousInt, 0);
        }
        
        public final void d() {}
        
        public final void d(String paramAnonymousString)
        {
          pv.a(com.whatsapp.u.a().getApplicationContext(), paramAnonymousString, 0);
        }
        
        public final void e(String paramAnonymousString) {}
        
        public final boolean e()
        {
          return false;
        }
        
        public final boolean f()
        {
          return false;
        }
        
        public final boolean g()
        {
          return false;
        }
      }, findViewById(2131755495), this.aa, this.ab, this.ad, this.ag, this.aj, this.ak, this.ao, this.E, this.at, this.au, this.aA)
      {
        public final void a()
        {
          PopupNotification.r(PopupNotification.this);
        }
        
        protected final boolean b()
        {
          int i;
          if (!PopupNotification.s(PopupNotification.this).b())
          {
            i = 1;
            if (PopupNotification.s(PopupNotification.this).a("android.permission.RECORD_AUDIO") == 0) {
              break label47;
            }
          }
          label47:
          for (int j = 1;; j = 0)
          {
            if ((j != 0) || (i != 0)) {
              break label52;
            }
            return true;
            i = 0;
            break;
          }
          label52:
          agq localagq = new agq();
          Bundle localBundle = new Bundle();
          if ((j != 0) && (i != 0))
          {
            localBundle.putIntArray("drawables", new int[] { 2130840440, 2130840441, 2130840443 });
            localBundle.putStringArray("permissions", new String[] { "android.permission.RECORD_AUDIO", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE" });
            localBundle.putInt("msg_id", 2131297417);
            localBundle.putInt("perm_denial_msg_id", 2131297414);
            localBundle.putInt("locked_msg_id", 2131297416);
            localBundle.putInt("locked_perm_denial_msg_id", 2131297415);
          }
          for (;;)
          {
            localagq.f(localBundle);
            localagq.a(PopupNotification.this.j_(), PopupNotification.l());
            return false;
            if (i != 0)
            {
              localBundle.putIntArray("drawables", new int[] { 2130840443 });
              localBundle.putStringArray("permissions", new String[] { "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE" });
              localBundle.putInt("msg_id", 2131297439);
              localBundle.putInt("perm_denial_msg_id", 2131297436);
              localBundle.putInt("locked_msg_id", 2131297438);
              localBundle.putInt("locked_perm_denial_msg_id", 2131297437);
            }
            else
            {
              localBundle.putIntArray("drawables", new int[] { 2130840440 });
              localBundle.putStringArray("permissions", new String[] { "android.permission.RECORD_AUDIO" });
              localBundle.putInt("msg_id", 2131297387);
              localBundle.putInt("perm_denial_msg_id", 2131297386);
              localBundle.putInt("locked_msg_id", 2131297451);
              localBundle.putInt("locked_perm_denial_msg_id", 2131297452);
            }
          }
        }
        
        public final void c()
        {
          PopupNotification.q(PopupNotification.this);
        }
        
        public final void d()
        {
          PopupNotification.i(PopupNotification.this).a(true);
          yx.i();
          super.d();
        }
      };
      this.w.setOnTouchListener(ad.a(this));
      this.w.setVisibility(0);
      this.T.setVisibility(8);
      localObject1 = new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          PopupNotification.i(PopupNotification.this).a(true);
          String str = paramAnonymousEditable.toString();
          boolean bool;
          if (PopupNotification.d(PopupNotification.this) != null)
          {
            if (str.length() != 0) {
              PopupNotification.u(PopupNotification.this).a(PopupNotification.d(PopupNotification.this).t, 0);
            }
          }
          else
          {
            be.a(PopupNotification.this, PopupNotification.v(PopupNotification.this), paramAnonymousEditable, PopupNotification.t(PopupNotification.this).getPaint());
            if (be.a(str)) {
              break label193;
            }
            bool = true;
            label88:
            PopupNotification.w(PopupNotification.this).setEnabled(bool);
            if ((PopupNotification.x(PopupNotification.this).getVisibility() != 8) || (bool)) {
              break label198;
            }
            PopupNotification.x(PopupNotification.this).startAnimation(aqs.a(true));
            PopupNotification.x(PopupNotification.this).setVisibility(0);
            PopupNotification.w(PopupNotification.this).startAnimation(aqs.a(false));
            PopupNotification.w(PopupNotification.this).setVisibility(8);
          }
          label193:
          label198:
          while ((PopupNotification.x(PopupNotification.this).getVisibility() != 0) || (!bool))
          {
            return;
            PopupNotification.u(PopupNotification.this).a(PopupNotification.d(PopupNotification.this).t);
            break;
            bool = false;
            break label88;
          }
          PopupNotification.x(PopupNotification.this).startAnimation(aqs.a(false));
          PopupNotification.x(PopupNotification.this).setVisibility(8);
          PopupNotification.w(PopupNotification.this).startAnimation(aqs.a(true));
          PopupNotification.w(PopupNotification.this).setVisibility(0);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          al.a(PopupNotification.p(PopupNotification.this), PopupNotification.t(PopupNotification.this), paramAnonymousCharSequence);
        }
      };
      this.v.addTextChangedListener((TextWatcher)localObject1);
      localObject1 = ae.a(this);
      this.v.setOnEditorActionListener((TextView.OnEditorActionListener)localObject1);
      this.T.setOnClickListener(o.a(this));
      this.z = new os(paramBundle, this, this.ab, this.am, this.ay);
      this.z.a(this.G);
      this.z.t = true;
      this.z.setOnDismissListener(p.a(this));
      this.X = new i(this.z, this, getWindow().getDecorView(), false);
      this.X.a(new q(this));
      paramBundle = (ImageButton)findViewById(2131755556);
      paramBundle.setOnClickListener(r.a(this, paramBundle));
      if (getIntent().getBooleanExtra("popup_notification_extra_dismiss_notification", false))
      {
        aw.a(this).a(1);
        this.F.a(true);
      }
      b(getIntent().getStringExtra("popup_notification_extra_quick_reply_jid"));
      j();
      this.aD.registerObserver(this.aE);
      if (amb.a(this.ah, this.ay) > 0) {
        showDialog(115);
      }
      if (!TextUtils.isEmpty(this.B)) {
        getWindow().setSoftInputMode(4);
      }
      return;
      this.y = paramBundle.newWakeLock(268435466, "popupnotification");
      break;
      label1014:
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = i;
    }
  }
  
  public Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    case 115: 
      Log.i("popupnotification/dialog-software-about-to-expire");
      return amb.a(this, this.ah);
    }
    return new b.a(this).b(getString(2131296403, new Object[] { this.q.a(this) })).a(2131298057, v.a(this)).b(2131296398, w.a(this)).a();
  }
  
  public void onDestroy()
  {
    Log.i("popupnotification/destroy");
    super.onDestroy();
    this.B = null;
    this.aG.removeCallbacks(this.aH);
    this.aI.removeCallbacks(this.aJ);
    if ((this.y != null) && (this.y.isHeld())) {
      this.y.release();
    }
    if (this.W != null) {
      this.U.unregisterListener(this.W);
    }
    if (n == this) {
      n = null;
    }
    yx.i();
    this.aD.unregisterObserver(this.aE);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    Log.i("popupnotification/new-intent");
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    b(paramIntent.getStringExtra("popup_notification_extra_quick_reply_jid"));
    if (paramIntent.getBooleanExtra("popup_notification_extra_dismiss_notification", false))
    {
      aw.a(this).a(1);
      this.F.a(true);
    }
    j();
  }
  
  protected void onPause()
  {
    Log.i("popupnotification/pause");
    super.onPause();
    this.x.a(false, false);
    this.F.b();
  }
  
  protected void onResume()
  {
    Log.i("popupnotification/resume");
    super.onResume();
  }
  
  protected void onStart()
  {
    Log.i("popupnotification/start");
    super.onStart();
    this.o = true;
  }
  
  public void onStop()
  {
    Log.i("popupnotification/stop");
    super.onStop();
    this.o = false;
    this.x.a(false, false);
  }
  
  public final class a
    extends android.support.v4.view.w
  {
    public a() {}
    
    public final Object a(ViewGroup paramViewGroup, int paramInt)
    {
      RelativeLayout localRelativeLayout = new RelativeLayout(PopupNotification.this);
      ScrollView localScrollView = new ScrollView(PopupNotification.this);
      View localView = PopupNotification.a(PopupNotification.this, (j)PopupNotification.a(PopupNotification.this).get(paramInt));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(13);
      localScrollView.addView(localView);
      localRelativeLayout.addView(localScrollView, localLayoutParams);
      paramViewGroup.addView(localRelativeLayout);
      return localRelativeLayout;
    }
    
    public final void a(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      paramViewGroup.removeView((View)paramObject);
    }
    
    public final boolean a(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
    
    public final int b()
    {
      if (PopupNotification.a(PopupNotification.this) == null) {
        return 0;
      }
      return PopupNotification.a(PopupNotification.this).size();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/notification/PopupNotification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */