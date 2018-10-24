package com.whatsapp.statusplayback;

import a.a.a.a.d;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.f;
import android.support.v4.view.ab;
import android.support.v4.view.w;
import android.support.v7.app.b.a;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.whatsapp.ContactPicker;
import com.whatsapp.Conversation;
import com.whatsapp.FMessageKey;
import com.whatsapp.TextEmojiLabel;
import com.whatsapp.aof;
import com.whatsapp.aoj;
import com.whatsapp.cc;
import com.whatsapp.data.ad.n;
import com.whatsapp.data.co;
import com.whatsapp.nh;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.pv;
import com.whatsapp.statusplayback.content.i;
import com.whatsapp.util.Log;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class StatusPlaybackActivity
  extends nh
  implements t.b
{
  private static final Interpolator B = ;
  private final HashMap<String, Long> A = new HashMap();
  private final aoj C = aoj.a();
  private final com.whatsapp.data.l D = com.whatsapp.data.l.a();
  private final cc E = cc.a();
  private final co F = co.a();
  private final Handler G = new Handler(Looper.getMainLooper());
  private final Runnable H = l.a(this);
  final Rect n = new Rect();
  private List<ad.n> o;
  private boolean p;
  private boolean q;
  private FMessageKey r;
  private ViewPager s;
  private c t;
  private AudioManager.OnAudioFocusChangeListener u;
  private Object v;
  private boolean w;
  private j x;
  private long y;
  private float z = 3.5F;
  
  private int a(String paramString)
  {
    Iterator localIterator = this.o.iterator();
    int i = 0;
    while ((localIterator.hasNext()) && (!((ad.n)localIterator.next()).a.equals(paramString))) {
      i += 1;
    }
    return i;
  }
  
  private t b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    Iterator localIterator = S().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Fragment)localIterator.next();
      if ((localObject instanceof t))
      {
        localObject = (t)localObject;
        if (paramString.equals(((t)localObject).a)) {
          return (t)localObject;
        }
      }
    }
    return null;
  }
  
  private void p()
  {
    if (this.v != null)
    {
      Log.i("statusplaybackactivity/abandon-audio-focus");
      this.v = null;
      ((AudioManager)getSystemService("audio")).abandonAudioFocus(q());
    }
  }
  
  private AudioManager.OnAudioFocusChangeListener q()
  {
    if (this.u == null) {
      this.u = p.a();
    }
    return this.u;
  }
  
  private void r()
  {
    if (this.w)
    {
      this.w = false;
      Iterator localIterator = S().iterator();
      while (localIterator.hasNext())
      {
        Fragment localFragment = (Fragment)localIterator.next();
        if ((localFragment instanceof t)) {
          ((t)localFragment).a(false);
        }
      }
    }
  }
  
  public final void a(float paramFloat)
  {
    if (paramFloat < 0.9F) {}
    for (paramFloat = 0.0F;; paramFloat = 1.0F - (1.0F - paramFloat) * 10.0F)
    {
      this.s.setBackgroundColor((int)(paramFloat * 255.0F) << 24);
      return;
    }
  }
  
  public final void a(j paramj)
  {
    if (com.whatsapp.protocol.m.b(paramj))
    {
      this.x = paramj;
      Intent localIntent = new Intent(this, ContactPicker.class);
      localIntent.putExtra("forward", true);
      localIntent.putExtra("forward_jid", paramj.e.a);
      localIntent.putIntegerArrayListExtra("message_types", new ArrayList(Collections.singleton(Integer.valueOf(Byte.valueOf(paramj.s).intValue()))));
      if (paramj.s == 3) {}
      for (long l = paramj.w * 1000L;; l = 0L)
      {
        localIntent.putExtra("forward_video_duration", l);
        startActivityForResult(localIntent, 2);
        return;
      }
    }
    this.aq.b(this, getString(2131297173), 1);
  }
  
  public final void a(Object paramObject)
  {
    Log.i("statusplaybackactivity/on-request-audio-focus ");
    this.G.removeCallbacks(this.H);
    if (this.v == null)
    {
      Log.i("statusplaybackactivity/request-audio-focus");
      ((AudioManager)getSystemService("audio")).requestAudioFocus(q(), 3, 2);
    }
    this.v = paramObject;
  }
  
  public final void a(String paramString, int paramInt)
  {
    if (paramInt == 0)
    {
      paramInt = a(paramString);
      if ((this.q) && (paramInt == this.s.getCurrentItem())) {
        finish();
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (paramInt >= this.o.size());
        this.o.remove(paramInt);
        this.s.getAdapter().c();
        return;
        paramInt = this.s.getCurrentItem();
      } while (!((ad.n)this.o.get(paramInt)).a.equals(paramString));
      paramString = b(paramString);
    } while (paramString == null);
    paramString.R();
  }
  
  public final boolean a(String paramString, boolean paramBoolean)
  {
    int i = a(paramString);
    if (paramBoolean)
    {
      if ((i < this.o.size() - 1) && (!this.q))
      {
        this.t.a = this.z;
        this.z = 3.5F;
        this.s.a(i + 1, true);
        this.t.a = 0.0F;
        return true;
      }
      finish();
      return true;
    }
    if ((i > 0) && (!this.q))
    {
      this.t.a = this.z;
      this.z = 3.5F;
      this.s.a(i - 1, true);
      this.t.a = 0.0F;
      return true;
    }
    return false;
  }
  
  public final void b(j paramj)
  {
    a(a.a(paramj.e));
  }
  
  public final void b(Object paramObject)
  {
    Log.i("statusplaybackactivity/on-abandon-audio-focus ");
    if (this.v == paramObject)
    {
      this.G.removeCallbacks(this.H);
      this.G.postDelayed(this.H, 1000L);
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    int i = paramKeyEvent.getKeyCode();
    if ((paramKeyEvent.getAction() == 0) && ((i == 24) || (i == 25)))
    {
      paramKeyEvent = (AudioManager)getSystemService("audio");
      t localt;
      int j;
      if (paramKeyEvent != null)
      {
        if (!this.w)
        {
          if (i != 24) {
            break label200;
          }
          i = 1;
          paramKeyEvent.adjustSuggestedStreamVolume(i, 3, 16);
        }
        localt = n();
        if (localt != null)
        {
          j = paramKeyEvent.getStreamMaxVolume(3);
          i = paramKeyEvent.getStreamVolume(3);
          Log.i("statusplaybackactivity/volume " + i + "/" + j);
          if (j != 0)
          {
            if (i != 0) {
              break label205;
            }
            i = 0;
          }
        }
      }
      for (;;)
      {
        float f = i * 1.0F / (j + 1);
        localt.b.setVolume(f);
        localt.b.setVisibility(0);
        localt.b.removeCallbacks(localt.d);
        localt.b.postDelayed(localt.d, 1500L);
        if (this.w) {
          r();
        }
        return true;
        label200:
        i = -1;
        break;
        label205:
        i += 1;
      }
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!this.t.isFinished()) && (this.t.timePassed() < this.t.getDuration() / 3)) {
      return false;
    }
    long l;
    if (paramMotionEvent.getActionMasked() == 0)
    {
      l = paramMotionEvent.getEventTime() - this.y;
      if ((l != 0L) && (l <= 1000L)) {
        break label84;
      }
    }
    label84:
    for (float f = 3.5F;; f = (float)l * 2.5F / 1000.0F + 1.0F)
    {
      this.z = f;
      this.y = paramMotionEvent.getEventTime();
      return super.dispatchTouchEvent(paramMotionEvent);
    }
  }
  
  public final void l()
  {
    t localt = n();
    if (localt != null) {
      localt.a();
    }
  }
  
  public final void m()
  {
    t localt = n();
    if (localt != null) {
      localt.b();
    }
  }
  
  final t n()
  {
    if (this.o == null) {}
    int i;
    do
    {
      return null;
      i = this.s.getCurrentItem();
    } while ((i < 0) || (i >= this.o.size()));
    return b(((ad.n)this.o.get(i)).a);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while ((paramInt2 != -1) || (paramIntent == null));
    paramIntent = paramIntent.getStringArrayListExtra("jids");
    this.C.a(this.as, this.x, paramIntent);
    if ((paramIntent.size() == 1) && (!j.c((String)paramIntent.get(0))))
    {
      startActivity(Conversation.a((String)paramIntent.get(0)));
      return;
    }
    pv.a(getBaseContext(), paramIntent);
  }
  
  public void onBackPressed()
  {
    int j = 1;
    Object localObject = n();
    if (localObject != null)
    {
      localObject = ((t)localObject).S();
      if (localObject != null) {
        if (((i)localObject).g.getState() == 3)
        {
          ((i)localObject).g.setState(4);
          i = 1;
          if (i == 0) {
            break label96;
          }
        }
      }
      label96:
      for (int i = j;; i = 0)
      {
        if (i == 0) {
          break label101;
        }
        return;
        if (((i)localObject).p)
        {
          ((i)localObject).g();
          ((i)localObject).p = false;
          ((i)localObject).c.a(((i)localObject).k.z, ((i)localObject).p);
          i = 1;
          break;
        }
        i = 0;
        break;
      }
    }
    label101:
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    boolean bool2 = false;
    Log.i("statusplaybackactivity/create");
    super.onCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    setContentView(2130903374);
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().addFlags(134217728);
      ab.a(findViewById(2131755835), new m(this));
    }
    this.s = ((ViewPager)findViewById(2131755748));
    try
    {
      paramBundle = ViewPager.class.getDeclaredField("d");
      paramBundle.setAccessible(true);
      this.t = new c(this.s.getContext(), B);
      paramBundle.set(this.s, this.t);
      String str = getIntent().getStringExtra("jid");
      this.r = ((FMessageKey)getIntent().getParcelableExtra("message_key"));
      Object localObject;
      int i;
      if (this.r != null)
      {
        this.o = new ArrayList();
        localObject = this.F;
        if (TextUtils.isEmpty(str))
        {
          paramBundle = "";
          paramBundle = ((co)localObject).a(paramBundle);
          if ((paramBundle != null) && (!paramBundle.c())) {
            this.o.add(paramBundle.a());
          }
          i = 0;
        }
      }
      boolean bool1;
      for (;;)
      {
        paramBundle = this.o.iterator();
        while (paramBundle.hasNext())
        {
          localObject = (ad.n)paramBundle.next();
          this.A.put(((ad.n)localObject).a, Long.valueOf(this.A.size()));
        }
        paramBundle = str;
        break;
        if (TextUtils.isEmpty(str))
        {
          this.o = new ArrayList();
          paramBundle = this.F.a("");
          if ((paramBundle != null) && (!paramBundle.c())) {
            this.o.add(paramBundle.a());
          }
          i = 0;
        }
        else if (this.E.f(str))
        {
          this.o = new ArrayList();
          paramBundle = this.F.a(str);
          if ((paramBundle != null) && (!paramBundle.c())) {
            this.o.add(paramBundle.a());
          }
          i = 0;
        }
        else
        {
          this.o = this.F.d();
          Collections.sort(this.o, q.a());
          paramBundle = new ArrayList();
          localObject = this.o.iterator();
          ad.n localn;
          while (((Iterator)localObject).hasNext())
          {
            localn = (ad.n)((Iterator)localObject).next();
            if (str.equals(localn.a))
            {
              if (localn.i <= 0) {
                break label577;
              }
              bool1 = true;
              this.p = bool1;
              if (this.p) {
                break label582;
              }
              bool1 = true;
              label516:
              this.q = bool1;
            }
          }
          localObject = this.o.iterator();
          for (;;)
          {
            if (!((Iterator)localObject).hasNext()) {
              break label641;
            }
            localn = (ad.n)((Iterator)localObject).next();
            if (TextUtils.isEmpty(localn.a))
            {
              paramBundle.add(localn);
              continue;
              label577:
              bool1 = false;
              break;
              label582:
              bool1 = false;
              break label516;
            }
            if ((this.p) && (localn.i == 0)) {
              paramBundle.add(localn);
            } else if (this.E.f(localn.a)) {
              paramBundle.add(localn);
            }
          }
          label641:
          this.o.removeAll(paramBundle);
          i = a(str);
        }
      }
      if (this.o.isEmpty())
      {
        Log.i("statusplaybackactivity/create/no statuses for " + str);
        finish();
        return;
      }
      this.s.setAdapter(new b(j_()));
      this.s.setCurrentItem(i);
      this.s.a(new ViewPager.f()
      {
        public final void a(int paramAnonymousInt) {}
        
        public final void a(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
        
        public final void b(int paramAnonymousInt)
        {
          StatusPlaybackActivity.a(StatusPlaybackActivity.this);
          String str = ((ad.n)StatusPlaybackActivity.b(StatusPlaybackActivity.this).get(paramAnonymousInt)).a;
          Object localObject1 = StatusPlaybackActivity.this.S().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (Fragment)((Iterator)localObject1).next();
            if ((localObject2 instanceof t))
            {
              localObject2 = (t)localObject2;
              if (!str.equals(((t)localObject2).a))
              {
                localObject2 = ((t)localObject2).S();
                if (localObject2 != null) {
                  ((i)localObject2).a(false);
                }
              }
            }
          }
          localObject1 = StatusPlaybackActivity.a(StatusPlaybackActivity.this, str);
          if (localObject1 != null)
          {
            ((t)localObject1).R();
            return;
          }
          Log.e("statusplaybackactivity/ cannot find fragment for " + str);
        }
      });
      this.s.setOnTouchListener(n.a(this));
      if (Build.VERSION.SDK_INT >= 16) {
        this.s.a(true, o.a());
      }
      for (;;)
      {
        paramBundle = (AudioManager)getSystemService("audio");
        if (paramBundle != null)
        {
          bool1 = bool2;
          if (paramBundle.getRingerMode() != 2) {
            bool1 = true;
          }
          this.w = bool1;
        }
        this.s.setKeepScreenOn(true);
        return;
        this.s.setPageMargin(getResources().getDimensionPixelSize(2131362066));
      }
    }
    catch (NoSuchFieldException paramBundle)
    {
      for (;;) {}
    }
    catch (IllegalAccessException paramBundle)
    {
      for (;;) {}
    }
    catch (IllegalArgumentException paramBundle)
    {
      for (;;) {}
    }
  }
  
  public void onDestroy()
  {
    Log.i("statusplaybackactivity/destroy");
    super.onDestroy();
    this.G.removeCallbacks(this.H);
    p();
  }
  
  public void onPause()
  {
    Log.i("statusplaybackactivity/pause");
    super.onPause();
    t localt = n();
    if (localt != null) {
      localt.a();
    }
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    if (paramBundle != null)
    {
      paramBundle = (FMessageKey)paramBundle.getParcelable("forwarded_message");
      if (paramBundle != null) {
        this.x = this.D.a(paramBundle.a);
      }
    }
  }
  
  public void onResume()
  {
    Log.i("statusplaybackactivity/resume");
    super.onResume();
    t localt = n();
    if ((localt != null) && (!localt.c())) {
      localt.b();
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.x != null) {
      paramBundle.putParcelable("forwarded_message", new FMessageKey(this.x.e));
    }
  }
  
  public static final class a
    extends android.support.v4.app.m
  {
    private final pv aa = pv.a();
    private final aoj ab = aoj.a();
    private final com.whatsapp.data.l ac = com.whatsapp.data.l.a();
    
    public static a a(j.b paramb)
    {
      a locala = new a();
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("message_key", new FMessageKey(paramb));
      locala.f(localBundle);
      return locala;
    }
    
    public final Dialog c(Bundle paramBundle)
    {
      Dialog localDialog = null;
      paramBundle = (FMessageKey)i().getParcelable("message_key");
      android.support.v4.app.n localn;
      pv localpv;
      aoj localaoj;
      if (paramBundle == null)
      {
        paramBundle = null;
        localn = l();
        localpv = this.aa;
        localaoj = this.ab;
        if (paramBundle != null) {
          break label100;
        }
      }
      label100:
      for (paramBundle = localDialog;; paramBundle = Collections.singletonList(paramBundle))
      {
        localDialog = d.a(localn, localpv, localaoj, paramBundle, s.b());
        paramBundle = localDialog;
        if (localDialog == null) {
          paramBundle = new b.a(l()).b(2131297909).a();
        }
        return paramBundle;
        paramBundle = this.ac.a(paramBundle.a);
        break;
      }
    }
  }
  
  final class b
    extends aof
  {
    b(android.support.v4.app.r paramr)
    {
      super();
    }
    
    public final int a(Object paramObject)
    {
      int i;
      if ((paramObject instanceof t))
      {
        paramObject = (t)paramObject;
        i = StatusPlaybackActivity.b(StatusPlaybackActivity.this, ((t)paramObject).a);
        if (i < StatusPlaybackActivity.b(StatusPlaybackActivity.this).size()) {}
      }
      else
      {
        return -2;
      }
      return i;
    }
    
    public final Fragment a(int paramInt)
    {
      if (StatusPlaybackActivity.c(StatusPlaybackActivity.this) == null) {}
      for (t localt = t.a(((ad.n)StatusPlaybackActivity.b(StatusPlaybackActivity.this).get(paramInt)).a, StatusPlaybackActivity.d(StatusPlaybackActivity.this));; localt = t.a(((ad.n)StatusPlaybackActivity.b(StatusPlaybackActivity.this).get(paramInt)).a, StatusPlaybackActivity.c(StatusPlaybackActivity.this), StatusPlaybackActivity.this.getIntent().getBooleanExtra("show_details", false)))
      {
        localt.a(StatusPlaybackActivity.e(StatusPlaybackActivity.this));
        localt.a(StatusPlaybackActivity.f(StatusPlaybackActivity.this));
        return localt;
      }
    }
    
    public final int b()
    {
      if (StatusPlaybackActivity.b(StatusPlaybackActivity.this) == null) {
        return 0;
      }
      return StatusPlaybackActivity.b(StatusPlaybackActivity.this).size();
    }
    
    public final long b(int paramInt)
    {
      return ((Long)StatusPlaybackActivity.g(StatusPlaybackActivity.this).get(((ad.n)StatusPlaybackActivity.b(StatusPlaybackActivity.this).get(paramInt)).a)).longValue();
    }
  }
  
  static final class c
    extends Scroller
  {
    float a;
    
    c(Context paramContext, Interpolator paramInterpolator)
    {
      super(paramInterpolator);
    }
    
    public final void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      if (this.a == 0.0F) {}
      for (;;)
      {
        super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
        return;
        paramInt5 = (int)(this.a * paramInt5);
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/statusplayback/StatusPlaybackActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */