package com.whatsapp;

import a.a.a.a.d;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.media.audiofx.Visualizer;
import android.media.audiofx.Visualizer.OnDataCaptureListener;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.whatsapp.data.ab;
import com.whatsapp.data.ac;
import com.whatsapp.data.ad;
import com.whatsapp.messaging.w;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.util.Log;
import com.whatsapp.util.b;
import com.whatsapp.util.f;
import com.whatsapp.util.h;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class yx
{
  private static String[] F = { "GT-I9505", "GT-I9506", "GT-I9505G", "SGH-I337", "SGH-M919", "SCH-I545", "SPH-L720", "SCH-R970", "GT-I9508", "SGH-N045", "SC-04E" };
  public static yx a;
  private static byte[] v;
  private static AudioManager w;
  private final h A;
  private final w B;
  private final ad C;
  private final b D;
  private final rl E;
  private int G;
  public j b;
  public b c;
  public int d;
  c e;
  private Activity f;
  private f g;
  private boolean h;
  private int i;
  private final BroadcastReceiver j;
  private boolean k = false;
  private boolean l;
  private final PowerManager.WakeLock m;
  private SensorManager n;
  private Sensor o;
  private SensorEventListener p;
  private boolean q;
  private float r;
  private long s;
  private Visualizer t;
  private MediaPlayer u;
  private Handler x = new Handler(Looper.getMainLooper())
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      if (yx.b(yx.this) == null) {}
      do
      {
        return;
        if (yx.b(yx.this).e()) {
          break;
        }
      } while (yx.c(yx.this));
      yx.this.d();
      return;
      yx.a(yx.this, yx.this.e());
      sendEmptyMessageDelayed(0, 50L);
    }
  };
  private AudioManager.OnAudioFocusChangeListener y;
  private final pv z;
  
  public yx(Activity paramActivity, pv parampv, h paramh, w paramw, ad paramad, and paramand, b paramb, rl paramrl)
  {
    this.f = paramActivity;
    this.z = parampv;
    this.A = paramh;
    this.B = paramw;
    this.C = paramad;
    this.D = paramb;
    this.E = paramrl;
    if (w == null) {
      w = (AudioManager)this.f.getApplicationContext().getSystemService("audio");
    }
    if (p() != -1)
    {
      paramActivity = paramand.a;
      if (paramActivity != null) {
        break label136;
      }
      Log.w("messageaudioplayer pm=null");
    }
    label136:
    for (this.m = null;; this.m = paramActivity.newWakeLock(p(), "WhatsApp MessageAudioPlayer ProximityWakeLock"))
    {
      this.l = paramrl.c;
      this.j = new BroadcastReceiver()
      {
        public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          boolean bool = false;
          paramAnonymousContext = yx.this;
          if (paramAnonymousIntent.getIntExtra("state", 0) > 0) {
            bool = true;
          }
          yx.a(paramAnonymousContext, bool);
          Log.i("messageaudioplayer/broadcastreceiver HeadsetPluggedInState: " + yx.d(yx.this));
          if (yx.d(yx.this))
          {
            yx.e(yx.this);
            return;
          }
          yx.f(yx.this);
        }
      };
      return;
    }
  }
  
  public static void a(ac paramac)
  {
    paramac.registerObserver(new ab()
    {
      public final void a(Collection<j> paramAnonymousCollection, Map<String, Integer> paramAnonymousMap)
      {
        if (yx.a != null)
        {
          paramAnonymousCollection = paramAnonymousCollection.iterator();
          while (paramAnonymousCollection.hasNext())
          {
            paramAnonymousMap = (j)paramAnonymousCollection.next();
            if (yx.a.a(paramAnonymousMap)) {
              yx.a.d();
            }
          }
        }
      }
      
      public final void b(String paramAnonymousString)
      {
        if ((yx.a != null) && (yx.a(yx.a) != null) && (yx.a(yx.a).e.a.equals(paramAnonymousString))) {
          yx.a.d();
        }
      }
    });
  }
  
  public static boolean b(j paramj)
  {
    return (a != null) && (a.a(paramj));
  }
  
  public static boolean g()
  {
    return (a != null) && (a.q);
  }
  
  public static boolean h()
  {
    return (a != null) && (a.f());
  }
  
  public static void i()
  {
    if (a != null) {
      a.d();
    }
  }
  
  public static void j()
  {
    if (a != null) {
      a.c();
    }
  }
  
  private void l()
  {
    if ((Build.VERSION.SDK_INT >= 21) && (!this.k))
    {
      u.a().registerReceiver(this.j, new IntentFilter("android.intent.action.HEADSET_PLUG"));
      this.k = true;
    }
  }
  
  private void m()
  {
    if (this.k)
    {
      u.a().unregisterReceiver(this.j);
      this.k = false;
    }
  }
  
  private void n()
  {
    w.abandonAudioFocus(o());
  }
  
  private AudioManager.OnAudioFocusChangeListener o()
  {
    if (this.y == null) {
      this.y = new a((byte)0);
    }
    return this.y;
  }
  
  private static int p()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return 32;
    }
    try
    {
      int i1 = PowerManager.class.getDeclaredField("PROXIMITY_SCREEN_OFF_WAKE_LOCK").getInt(null);
      return i1;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      Log.w("no PROXIMITY_SCREEN_OFF_WAKE_LOCK field in PowerManager");
      return -1;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        Log.w("unable to access PROXIMITY_SCREEN_OFF_WAKE_LOCK field in PowerManager");
      }
    }
  }
  
  private void q()
  {
    if ((this.m != null) && (!this.m.isHeld()) && (!this.l) && (this.g.e()))
    {
      this.m.acquire();
      Log.i("messageaudioplayer/startProximityListener acquired proximityWakeLock");
    }
  }
  
  private void r()
  {
    q();
    if (this.n == null)
    {
      this.n = ((SensorManager)this.f.getSystemService("sensor"));
      this.o = this.n.getDefaultSensor(8);
      this.p = new SensorEventListener()
      {
        public final void onAccuracyChanged(Sensor paramAnonymousSensor, int paramAnonymousInt) {}
        
        public final void onSensorChanged(SensorEvent paramAnonymousSensorEvent)
        {
          if (yx.a == null)
          {
            yx.this.a(false);
            yx.h(yx.this);
            return;
          }
          if (yx.a != yx.this)
          {
            yx.h(yx.this);
            return;
          }
          float f = paramAnonymousSensorEvent.values[0];
          if ((f >= 5.0F) || (f == yx.i(yx.this).getMaximumRange()))
          {
            yx.this.a(false);
            return;
          }
          yx.this.a(true);
        }
      };
      this.n.registerListener(this.p, this.o, 2);
    }
  }
  
  private void s()
  {
    if (this.n != null)
    {
      this.n.unregisterListener(this.p, this.o);
      this.n = null;
    }
    t();
  }
  
  private void t()
  {
    if ((this.m != null) && (this.m.isHeld()))
    {
      if (Build.VERSION.SDK_INT < 21) {
        break label40;
      }
      this.m.release(1);
    }
    for (;;)
    {
      Log.i("messageaudioplayer/stopproximitylistener released proximityWakeLock");
      return;
      label40:
      this.m.release();
    }
  }
  
  private void u()
  {
    if (this.c != null) {
      this.c.d();
    }
  }
  
  public final void a()
  {
    if ((a != this) && (a != null)) {
      a.d();
    }
    if ((this.g == null) || (!this.g.e()))
    {
      b();
      return;
    }
    c();
  }
  
  public final void a(int paramInt)
  {
    try
    {
      if (this.g != null) {
        this.g.a(paramInt);
      }
      this.i = paramInt;
      return;
    }
    catch (IOException localIOException)
    {
      Log.e(localIOException);
    }
  }
  
  protected final void a(boolean paramBoolean)
  {
    if (this.E.c) {
      paramBoolean = false;
    }
    if (this.q == paramBoolean) {
      break label20;
    }
    label20:
    while ((paramBoolean) && ((this.g == null) || (!this.g.e()))) {
      return;
    }
    Log.i("messageaudioplayer/onearproximity " + paramBoolean);
    this.q = paramBoolean;
    Object localObject;
    WindowManager.LayoutParams localLayoutParams;
    if (this.m == null)
    {
      localObject = this.f.getWindow();
      localLayoutParams = ((Window)localObject).getAttributes();
      if (!paramBoolean) {
        break label303;
      }
      this.r = localLayoutParams.screenBrightness;
      localLayoutParams.screenBrightness = 0.1F;
    }
    for (;;)
    {
      ((Window)localObject).setAttributes(localLayoutParams);
      if (this.c != null) {
        this.c.a(paramBoolean);
      }
      if ((this.g == null) || (!this.g.e())) {
        break;
      }
      int i2 = this.g.f();
      this.g.h();
      this.g = null;
      localObject = this.b.b();
      int i1;
      if (paramBoolean) {
        i1 = 0;
      }
      try
      {
        this.g = f.a(((MediaData)localObject).file, i1);
        this.f.setVolumeControlStream(i1);
        if (paramBoolean) {
          ((AudioManager)this.f.getSystemService("audio")).setSpeakerphoneOn(false);
        }
        this.g.a();
        this.i = Math.max(0, i2 - 1000);
        this.g.a(this.i);
        if ((paramBoolean) || (System.currentTimeMillis() - this.s < 1500L))
        {
          this.g.b();
          return;
        }
      }
      catch (IllegalStateException localIllegalStateException)
      {
        for (;;)
        {
          pv.a(this.f.getApplicationContext(), 2131296813, 0);
          return;
          localLayoutParams.screenBrightness = this.r;
          break;
          i1 = 3;
        }
        this.h = true;
        u();
        m();
        t();
        n();
        return;
      }
      catch (IOException localIOException)
      {
        label303:
        for (;;) {}
      }
    }
  }
  
  public final boolean a(j paramj)
  {
    return paramj.e.equals(this.b.e);
  }
  
  public final void b()
  {
    int i2 = 1;
    if ((a != this) && (a != null)) {
      a.d();
    }
    this.D.b();
    if (!this.A.b()) {
      this.f.setVolumeControlStream(3);
    }
    Object localObject = w;
    AudioManager.OnAudioFocusChangeListener localOnAudioFocusChangeListener = o();
    int i1;
    if (this.b.o == 1)
    {
      i1 = 3;
      ((AudioManager)localObject).requestAudioFocus(localOnAudioFocusChangeListener, 3, i1);
      l();
      this.s = System.currentTimeMillis();
      if (this.g != null) {
        break label505;
      }
      Log.i("messageaudioplayer/start");
      if ((this.e == null) || (Build.VERSION.SDK_INT < 17) || (Build.VERSION.SDK_INT > 18) || (!"samsung".equals(Build.MANUFACTURER)) || (!d.a(F, Build.MODEL))) {}
    }
    for (;;)
    {
      try
      {
        localObject = this.b.b();
        this.u = new MediaPlayer();
        this.u.setDataSource(((MediaData)localObject).file.getAbsolutePath());
        this.u.setAudioStreamType(3);
        this.u.prepare();
      }
      catch (IOException localIOException2)
      {
        try
        {
          this.g = f.a(this.b.b().file, 3);
          this.g.a();
          this.g.a(this.i);
          this.g.b();
          this.d = this.g.g();
          this.x.sendEmptyMessage(0);
          i1 = i2;
          if (!this.b.e.b)
          {
            i1 = i2;
            if (this.b.o == 1)
            {
              i1 = i2;
              if (this.b.d != 9)
              {
                i1 = i2;
                if (this.b.d != 10)
                {
                  this.C.a(this.b.e, 9, null);
                  this.B.a(this.b);
                  i1 = i2;
                }
              }
            }
          }
          if (i1 != 0) {
            if (this.e == null) {}
          }
        }
        catch (IOException localIOException2)
        {
          try
          {
            this.t = new Visualizer(0);
            this.t.setCaptureSize(Visualizer.getCaptureSizeRange()[1]);
            this.t.setDataCaptureListener(new Visualizer.OnDataCaptureListener()
            {
              public final void onFftDataCapture(Visualizer paramAnonymousVisualizer, byte[] paramAnonymousArrayOfByte, int paramAnonymousInt) {}
              
              public final void onWaveFormDataCapture(Visualizer paramAnonymousVisualizer, byte[] paramAnonymousArrayOfByte, int paramAnonymousInt)
              {
                if (yx.g(yx.this) != null) {
                  yx.g(yx.this).a(paramAnonymousArrayOfByte);
                }
              }
            }, Visualizer.getMaxCaptureRate() / 2, true, true);
            this.t.setEnabled(true);
            if (this.c != null) {
              this.c.a();
            }
            r();
            a = this;
            return;
            i1 = 1;
            break;
            localIOException1 = localIOException1;
            Log.e(localIOException1);
            continue;
            localIOException2 = localIOException2;
            Log.e(localIOException2);
            pv.a(this.f.getApplicationContext(), 2131296813, 0);
            i1 = 0;
          }
          catch (Exception localException)
          {
            Log.e("visualmediaplayer/start " + localException);
            continue;
          }
          d();
          return;
        }
      }
      label505:
      Log.i("messageaudioplayer/resume");
      try
      {
        this.g.a(this.i);
        this.g.b();
        this.h = false;
        this.x.sendEmptyMessage(0);
        l();
        r();
        if (this.c == null) {
          continue;
        }
        this.c.c();
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        pv.a(this.f.getApplicationContext(), 2131296813, 0);
        return;
      }
      catch (IOException localIOException3)
      {
        for (;;) {}
      }
    }
  }
  
  public final void c()
  {
    if ((this.g != null) && (this.g.e()))
    {
      this.g.d();
      this.h = true;
      u();
      m();
      t();
    }
    n();
  }
  
  public final void d()
  {
    Log.i("messageaudioplayer/stop");
    if (this.g != null)
    {
      this.g.h();
      this.g = null;
    }
    if (this.u != null)
    {
      this.u.reset();
      this.u.release();
      this.u = null;
    }
    if (this.t != null)
    {
      this.t.setEnabled(false);
      this.t = null;
    }
    if ((this.m != null) || (!this.q)) {
      s();
    }
    n();
    this.f.setVolumeControlStream(Integer.MIN_VALUE);
    this.i = 0;
    this.h = false;
    this.x.removeMessages(0);
    a = null;
    m();
    if (this.c != null) {
      this.c.b();
    }
  }
  
  public final int e()
  {
    if (this.g == null) {
      return 0;
    }
    return Math.max(this.i, this.g.f());
  }
  
  public final boolean f()
  {
    return (this.g != null) && (this.g.e());
  }
  
  public final boolean k()
  {
    return this.m != null;
  }
  
  static final class a
    implements AudioManager.OnAudioFocusChangeListener
  {
    public final void onAudioFocusChange(int paramInt) {}
  }
  
  public static abstract interface b
  {
    public abstract void a();
    
    public abstract void a(int paramInt);
    
    public abstract void a(boolean paramBoolean);
    
    public abstract void b();
    
    public abstract void c();
    
    public abstract void d();
  }
  
  static abstract interface c
  {
    public abstract void a(byte[] paramArrayOfByte);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/yx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */