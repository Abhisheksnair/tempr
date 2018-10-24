package com.whatsapp;

import a.a.a.a.d;
import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.TriggerEvent;
import android.hardware.TriggerEventListener;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Base64;
import com.whatsapp.data.cs;
import com.whatsapp.data.l;
import com.whatsapp.messaging.aj;
import com.whatsapp.messaging.m;
import com.whatsapp.notification.f;
import com.whatsapp.protocol.ar;
import com.whatsapp.protocol.av;
import com.whatsapp.protocol.i;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.protocol.x;
import com.whatsapp.service.WebClientService;
import com.whatsapp.util.Log;
import com.whatsapp.util.bu;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.whispersystems.a.a.a;
import org.whispersystems.a.a.b;
import org.whispersystems.a.d.c;

public final class auj
{
  private static final List<s> A;
  public static String a;
  public static byte[] b;
  public static byte[] c;
  public static byte[] d;
  public static String e;
  public static String f;
  public static String g;
  public static boolean h;
  public static boolean i;
  public static final Map<String, Integer> j;
  public static final List<q> k;
  public static e l;
  private static final SecureRandom m;
  private static final AtomicInteger n;
  private static AtomicReference<h> o;
  private static boolean p;
  private static final File q;
  private static final a r;
  private static final b s;
  private static boolean t;
  private static boolean u;
  private static Sensor v;
  private static SensorManager w;
  private static TriggerEventListener x;
  private static aur y;
  private static Map<String, aur.b> z;
  
  static
  {
    bool = true;
    Object localObject2 = null;
    m = new SecureRandom();
    n = new AtomicInteger();
    o = new AtomicReference();
    p = false;
    a = null;
    b = null;
    c = null;
    d = null;
    e = null;
    f = null;
    g = null;
    j = Collections.synchronizedMap(new LinkedHashMap()
    {
      protected final boolean removeEldestEntry(Map.Entry<String, Integer> paramAnonymousEntry)
      {
        return size() > 100;
      }
    });
    r = new a();
    s = new b();
    k = Collections.synchronizedList(new ArrayList());
    l = null;
    Object localObject3 = u.a().getSharedPreferences("qr_data", 0);
    a = ((SharedPreferences)localObject3).getString("ref", null);
    Object localObject1 = ((SharedPreferences)localObject3).getString("key", null);
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = Base64.decode((String)localObject1, 0))
    {
      b = (byte[])localObject1;
      c = null;
      d = null;
      if (b != null)
      {
        c = new byte[32];
        d = new byte[32];
        System.arraycopy(b, 0, c, 0, 32);
        System.arraycopy(b, 32, d, 0, 32);
      }
      e = ((SharedPreferences)localObject3).getString("token", null);
      f = ((SharedPreferences)localObject3).getString("browser", null);
      g = ((SharedPreferences)localObject3).getString("epoch", null);
      h = ((SharedPreferences)localObject3).getBoolean("browser_changed", false);
      try
      {
        Class.forName("android.hardware.TriggerEventListener");
        i1 = 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i1 = 0;
          continue;
          bool = false;
        }
      }
      if ((Build.VERSION.SDK_INT >= 18) && (i1 != 0))
      {
        localObject3 = (SensorManager)u.a().getSystemService("sensor");
        w = (SensorManager)localObject3;
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = w.getDefaultSensor(17);
        }
        v = (Sensor)localObject1;
        x = new TriggerEventListener()
        {
          public final void onTrigger(TriggerEvent paramAnonymousTriggerEvent)
          {
            if (auj.r())
            {
              auj.s();
              return;
            }
            auj.t();
          }
        };
      }
      if ((w == null) || (v == null)) {
        break;
      }
      u = bool;
      localObject1 = new File(u.a().getCacheDir(), "WebActionIdCache");
      q = (File)localObject1;
      if (((File)localObject1).exists()) {
        E();
      }
      A = new ArrayList();
      return;
    }
  }
  
  private static aur A()
  {
    if (y == null) {
      y = aur.a(u.a());
    }
    return y;
  }
  
  private static Map<String, aur.b> B()
  {
    if (z == null)
    {
      z = new LinkedHashMap();
      Iterator localIterator = A().a().iterator();
      while (localIterator.hasNext())
      {
        aur.b localb = (aur.b)localIterator.next();
        z.put(localb.a, localb);
      }
    }
    return z;
  }
  
  @TargetApi(18)
  private static void C()
  {
    if (u) {
      w.requestTriggerSensor(x, v);
    }
  }
  
  private static void D()
  {
    j.clear();
    r.sendEmptyMessage(2);
  }
  
  private static void E()
  {
    try
    {
      synchronized (j)
      {
        ObjectInputStream localObjectInputStream = new ObjectInputStream(new FileInputStream(q));
        Iterator localIterator = ((Map)localObjectInputStream.readObject()).entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (((Integer)localEntry.getValue()).intValue() > 0) {
            j.put(localEntry.getKey(), localEntry.getValue());
          }
        }
      }
      ((ObjectInputStream)localObject).close();
    }
    catch (Exception localException)
    {
      return;
    }
  }
  
  private static void F()
  {
    if (Build.VERSION.SDK_INT >= 23) {
      s.sendEmptyMessage(1);
    }
  }
  
  public static h a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    h localh = new h(paramInt, paramBoolean1, paramBoolean2, (byte)0);
    if (localh.equals((h)o.getAndSet(localh))) {
      return null;
    }
    return localh;
  }
  
  private static aur.b a(aur.b paramb)
  {
    if (paramb != null)
    {
      aur.b localb = paramb;
      if (paramb.k)
      {
        localb = paramb;
        if (paramb.l != 0L)
        {
          localb = paramb;
          if (paramb.l < System.currentTimeMillis())
          {
            Log.i("webSession/getUnexpiredSession browser timed out " + paramb.a);
            a(null, false, paramb.a);
            localb = null;
          }
        }
      }
      return localb;
    }
    return null;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = (aur.b)B().get(paramString1);
    if (paramString1 == null) {
      return null;
    }
    byte[] arrayOfByte1 = Base64.decode(paramString1.b, 0);
    byte[] arrayOfByte2 = new byte[32];
    System.arraycopy(arrayOfByte1, 32, arrayOfByte2, 0, 32);
    paramString3 = atx.a(arrayOfByte2, Base64.decode(paramString3, 0));
    if (paramString3 == null) {
      return null;
    }
    if (Base64.encodeToString(paramString3, 2).equals(paramString2)) {
      return paramString1.b;
    }
    return null;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (l != null)
    {
      localObject = l;
      if ((paramString2 != null) && (paramString2.equals(((e)localObject).c)) && (paramString1 != null) && (paramString1.equals(((e)localObject).b)) && (((e)localObject).a(paramString3, paramString4))) {}
      for (int i1 = 1; i1 != 0; i1 = 0) {
        return l.a;
      }
    }
    Object localObject = f();
    l = new e((String)localObject, paramString1, paramString2, paramString3, paramString4);
    return (String)localObject;
  }
  
  public static String a(String paramString, byte[] paramArrayOfByte)
  {
    boolean bool2 = true;
    Object localObject = d.o();
    for (;;)
    {
      try
      {
        paramString = Base64.decode(paramString, 0);
        paramString = d.a(d.b(atx.b(new byte[] { 5 }, paramString)), ((b)localObject).b());
        byte[] arrayOfByte1 = c.a(3).a(paramString, null, 80);
        byte[] arrayOfByte2 = new byte[32];
        System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, 32);
        paramString = new byte[32];
        System.arraycopy(arrayOfByte1, 32, paramString, 0, 32);
        byte[] arrayOfByte3 = new byte[16];
        System.arraycopy(arrayOfByte1, 64, arrayOfByte3, 0, 16);
        paramArrayOfByte = atx.a(arrayOfByte2, arrayOfByte3, paramArrayOfByte);
        localObject = ((a)((b)localObject).a()).b();
        paramString = atx.a(paramString, atx.b((byte[])localObject, paramArrayOfByte));
        if ((paramString != null) && (paramArrayOfByte != null)) {
          break;
        }
        localObject = new StringBuilder("qrsession/encryptSecret fail null enc: ");
        if (paramArrayOfByte == null)
        {
          bool1 = true;
          paramArrayOfByte = ((StringBuilder)localObject).append(bool1).append(" hmac: ");
          if (paramString != null) {
            break label219;
          }
          bool1 = bool2;
          Log.e(bool1);
          return null;
        }
      }
      catch (Exception paramString)
      {
        Log.e("qrsession/encryptSecret/curve error " + paramString);
        return null;
      }
      boolean bool1 = false;
      continue;
      label219:
      bool1 = false;
    }
    return Base64.encodeToString(atx.b((byte[])localObject, atx.b(paramString, paramArrayOfByte)), 2);
  }
  
  public static List<aur.b> a()
  {
    Iterator localIterator = new ArrayList(B().values()).iterator();
    while (localIterator.hasNext()) {
      a((aur.b)localIterator.next());
    }
    return new ArrayList(B().values());
  }
  
  public static void a(long paramLong)
  {
    p = false;
    if (Build.VERSION.SDK_INT >= 23)
    {
      b localb = s;
      if ((!localb.hasMessages(2)) && (!localb.hasMessages(3)))
      {
        localb.a = Math.min(localb.a + 30000L, 240000L);
        Log.i("qrsession/fservice/delayed timeout=" + localb.a);
        localb.sendEmptyMessageDelayed(3, localb.a);
      }
    }
    a(paramLong, f);
  }
  
  public static void a(long paramLong, String paramString)
  {
    if ((paramString == null) || (paramLong <= 0L)) {}
    do
    {
      return;
      localObject = (aur.b)B().get(paramString);
    } while (localObject == null);
    ((aur.b)localObject).j = paramLong;
    aur localaur = A();
    paramLong = ((aur.b)localObject).j;
    Object localObject = new ContentValues();
    ((ContentValues)localObject).put("last_active", Long.valueOf(paramLong));
    localaur.a.getWritableDatabase().update("sessions", (ContentValues)localObject, "browser_id = ?", new String[] { paramString });
    z();
  }
  
  public static void a(s params)
  {
    if (!A.contains(params)) {
      A.add(params);
    }
  }
  
  public static void a(aj paramaj, String paramString1, String paramString2)
  {
    if ((paramString2 != null) && (paramString2.equals(a))) {}
    for (boolean bool = true;; bool = false)
    {
      if (paramaj.d.d)
      {
        paramaj = paramaj.d;
        Bundle localBundle = new Bundle();
        localBundle.putString("id", paramString1);
        localBundle.putString("ref", paramString2);
        localBundle.putBoolean("active", bool);
        paramaj.a(Message.obtain(null, 0, 94, 0, localBundle));
      }
      return;
    }
  }
  
  public static void a(aj paramaj, boolean paramBoolean, String paramString)
  {
    Log.i("qrsession/deleteSession bid=" + paramString);
    if (b(paramString))
    {
      D();
      b = null;
      c = null;
      d = null;
      e = null;
      f = null;
      if (paramaj != null) {
        paramaj.a(true);
      }
    }
    B().remove(paramString);
    A().a.getWritableDatabase().delete("sessions", "browser_id = ?", new String[] { paramString });
    if (paramBoolean) {
      z();
    }
  }
  
  public static void a(j paramj, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!c()) {
      return;
    }
    Log.d("qrsession/renotify/schedule " + paramBoolean1 + ' ' + paramBoolean2);
    Intent localIntent = new Intent("com.whatsapp.alarm.WEB_RENOTIFY").setPackage(au.b());
    AlarmManager localAlarmManager = (AlarmManager)u.a().getSystemService("alarm");
    PendingIntent localPendingIntent = PendingIntent.getBroadcast(u.a(), 0, localIntent, 536870912);
    if (localPendingIntent != null)
    {
      Log.d("qrsession/renotify/cancelexisting");
      localAlarmManager.cancel(localPendingIntent);
      localPendingIntent.cancel();
    }
    localIntent.putExtra("noPopup", paramBoolean1);
    localIntent.putExtra("isAndroidWearRefresh", paramBoolean2);
    localIntent.putExtra("messageKeyBytes", FMessageKey.a(paramj.e));
    paramj = PendingIntent.getBroadcast(u.a(), 0, localIntent, 268435456);
    if (Build.VERSION.SDK_INT >= 23)
    {
      localAlarmManager.setExactAndAllowWhileIdle(2, SystemClock.elapsedRealtime() + 20000L, paramj);
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      localAlarmManager.setExact(2, SystemClock.elapsedRealtime() + 20000L, paramj);
      return;
    }
    localAlarmManager.set(2, SystemClock.elapsedRealtime() + 20000L, paramj);
  }
  
  public static void a(pv parampv, final aus paramaus, final atu paramatu, final String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean1, boolean paramBoolean2)
  {
    l = null;
    if (!b(paramString3))
    {
      Log.i("qrsession/onQrSync/clear epoch idcache");
      g = null;
      D();
    }
    boolean bool;
    int i1;
    if (!b(paramString3))
    {
      bool = true;
      h = bool;
      Object localObject = u.a().getSharedPreferences("qr_data", 0).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("browser_changed", bool);
      if (!((SharedPreferences.Editor)localObject).commit()) {
        Log.e("qrsession/onQrSync/success/commit_failed_browser_change");
      }
      a = paramString1;
      if (!c("qr_data", "ref", paramString1)) {
        Log.e("qrsession/onQrSync/success/commit_failed_ref");
      }
      e = paramString4;
      if (!c("qr_data", "token", paramString4)) {
        Log.e("qrsession/onQrSync/success/commit_failed_token");
      }
      if ((paramString2 != null) && (!a(paramString2, true))) {
        Log.e("qrsession/onQRSync/success/commit_failed_secret");
      }
      if (paramString3 != null)
      {
        f = paramString3;
        if (!c("qr_data", "browser", paramString3)) {
          Log.e("qrsession/onQRSync/success/commit_failed_curr_browser");
        }
      }
      if (paramString3 != null)
      {
        Log.i("qrsession/set_browser " + paramString3 + ' ' + paramString4 + ' ' + paramString5 + ' ' + paramString6 + ' ' + paramBoolean2);
        paramString1 = (aur.b)B().get(paramString3);
        if (paramString1 != null) {
          break label528;
        }
        paramString1 = new aur.b(paramString3, paramString2, paramString4, paramString5, paramString6, paramBoolean1, paramBoolean2);
        B().put(paramString3, paramString1);
        i1 = 1;
        paramString1.j = System.currentTimeMillis();
        localObject = A();
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("browser_id", paramString3);
        localContentValues.put("secret", paramString2);
        localContentValues.put("token", paramString4);
        localContentValues.put("os", paramString5);
        localContentValues.put("browser_type", paramString6);
        localContentValues.put("last_active", Long.valueOf(System.currentTimeMillis()));
        localContentValues.put("timeout", Boolean.valueOf(paramBoolean1));
        localContentValues.put("fservice", Boolean.valueOf(paramBoolean2));
        ((aur)localObject).a.getWritableDatabase().replaceOrThrow("sessions", null, localContentValues);
        z();
        if (i1 != 0)
        {
          paramatu = new pg(u.a(), paramatu);
          paramString2 = paramatu.a(2);
          if ((paramString2 == null) || (paramString2.getTime() + 120000L <= System.currentTimeMillis())) {
            break label590;
          }
          Log.i("qrsession/location/last " + paramString2.getTime());
          bu.a(new c(parampv, paramaus, paramString1, paramString2));
        }
      }
    }
    for (;;)
    {
      i = paramBoolean2;
      F();
      return;
      bool = false;
      break;
      label528:
      paramString1.b = paramString2;
      paramString1.c = paramString4;
      paramString1.d = paramString5;
      paramString1.e = paramString6;
      paramString1.k = paramBoolean1;
      paramString1.l = 0L;
      if ((paramString1.m) || (paramBoolean2)) {}
      for (paramBoolean2 = true;; paramBoolean2 = false)
      {
        i1 = 0;
        break;
      }
      label590:
      paramaus = new LocationListener()
      {
        public final void onLocationChanged(Location paramAnonymousLocation)
        {
          if (paramAnonymousLocation != null)
          {
            Log.i("qrsession/location/changed " + paramAnonymousLocation.getTime() + " " + paramAnonymousLocation.getAccuracy());
            bu.a(new auj.c(this.a, paramaus, paramString1, paramAnonymousLocation));
            paramatu.a(this);
          }
        }
        
        public final void onProviderDisabled(String paramAnonymousString) {}
        
        public final void onProviderEnabled(String paramAnonymousString) {}
        
        public final void onStatusChanged(String paramAnonymousString, int paramAnonymousInt, Bundle paramAnonymousBundle) {}
      };
      paramatu.a(2, 0L, 0L, paramaus);
      parampv.a(aul.a(paramatu, paramaus), 60000L);
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    if ((a != null) && (!a.equals(paramString))) {}
    for (;;)
    {
      return;
      if (!a(false)) {
        Log.e("qrsession/onQrSync/error/commit_failed");
      }
      paramString = A.iterator();
      while (paramString.hasNext()) {
        ((s)paramString.next()).a(paramInt);
      }
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    Object localObject = (aur.b)B().get(paramString1);
    if (localObject != null)
    {
      localObject = Base64.decode(((aur.b)localObject).b, 0);
      byte[] arrayOfByte1 = new byte[32];
      System.arraycopy(localObject, 0, arrayOfByte1, 0, 32);
      byte[] arrayOfByte2 = new byte[32];
      System.arraycopy(localObject, 32, arrayOfByte2, 0, 32);
      localObject = atx.a(arrayOfByte2, arrayOfByte1);
      if ((localObject != null) && (Base64.encodeToString((byte[])localObject, 2).equals(paramString2)))
      {
        a(null, false, paramString1);
        z();
      }
    }
  }
  
  public static void a(boolean paramBoolean, long paramLong)
  {
    a(paramLong);
    if (!a(paramBoolean)) {
      Log.e("qrsession/onQrTerminate/error/commit_failed");
    }
  }
  
  public static boolean a(String paramString)
  {
    return (paramString != null) && (paramString.equals(a));
  }
  
  private static boolean a(String paramString, boolean paramBoolean)
  {
    boolean bool = false;
    byte[] arrayOfByte = Base64.decode(paramString, 0);
    b = arrayOfByte;
    if (arrayOfByte.length == 64)
    {
      c = new byte[32];
      d = new byte[32];
      System.arraycopy(b, 0, c, 0, 32);
      System.arraycopy(b, 32, d, 0, 32);
    }
    if (paramBoolean)
    {
      paramBoolean = bool;
      if (!c("qr_data", "key", paramString)) {}
    }
    else
    {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  private static boolean a(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = u.a().getSharedPreferences("qr_data", 0).edit();
    a = null;
    localEditor.remove("ref");
    if (paramBoolean)
    {
      a(null, false, f);
      b = null;
      c = null;
      d = null;
      e = null;
      f = null;
      localEditor.remove("key");
      localEditor.remove("token");
      localEditor.remove("browser");
      z();
      s.sendEmptyMessage(2);
    }
    for (;;)
    {
      k.clear();
      t = false;
      i = false;
      if (u) {
        w.cancelTriggerSensor(x, v);
      }
      return localEditor.commit();
      Object localObject = (aur.b)B().get(f);
      if ((localObject != null) && (((aur.b)localObject).k))
      {
        ((aur.b)localObject).l = (System.currentTimeMillis() + 600000L);
        aur localaur = A();
        String str = f;
        long l1 = ((aur.b)localObject).l;
        localObject = new ContentValues();
        ((ContentValues)localObject).put("expiration", Long.valueOf(l1));
        localaur.a.getWritableDatabase().update("sessions", (ContentValues)localObject, "browser_id = ?", new String[] { str });
      }
    }
  }
  
  public static e b(String paramString1, String paramString2)
  {
    e locale = l;
    if ((locale != null) && (locale.a(paramString1, paramString2)))
    {
      l = null;
      return locale;
    }
    return null;
  }
  
  public static void b(s params)
  {
    A.remove(params);
  }
  
  public static void b(String paramString, int paramInt)
  {
    j.put(paramString, Integer.valueOf(paramInt));
    r.sendEmptyMessageDelayed(1, 2000L);
    Log.d("caching epoch=" + g);
  }
  
  public static boolean b()
  {
    return e != null;
  }
  
  public static boolean b(String paramString)
  {
    return (f != null) && (f.equals(paramString));
  }
  
  public static String c(String paramString1, String paramString2)
  {
    paramString1 = a((aur.b)B().get(paramString1));
    if (paramString1 != null)
    {
      if (paramString1.c.equals(paramString2)) {
        return paramString1.b;
      }
      return null;
    }
    return null;
  }
  
  public static boolean c()
  {
    return a != null;
  }
  
  public static boolean c(String paramString)
  {
    return (paramString != null) && (paramString.equals(f)) && (j());
  }
  
  private static boolean c(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = u.a().getSharedPreferences(paramString1, 0).edit();
    paramString1.putString(paramString2, paramString3);
    return paramString1.commit();
  }
  
  public static boolean d()
  {
    return !B().isEmpty();
  }
  
  public static boolean d(String paramString)
  {
    return B().containsKey(paramString);
  }
  
  public static void e()
  {
    if (!a(false)) {
      Log.e("qrsession/resetState/error/commit_failed");
    }
  }
  
  public static void e(String paramString)
  {
    if (!a(paramString, false)) {
      Log.e("qrsession/beforeQRSync/commit_failed_secret");
    }
  }
  
  public static String f()
  {
    byte[] arrayOfByte = new byte[32];
    m.nextBytes(arrayOfByte);
    return Base64.encodeToString(arrayOfByte, 2);
  }
  
  public static void f(String paramString)
  {
    if (d(paramString))
    {
      a(null, false, paramString);
      z();
    }
  }
  
  public static d g(String paramString)
  {
    Object localObject = null;
    String[] arrayOfString = paramString.split(",");
    if (arrayOfString.length < 2)
    {
      Log.e("qrsession/processQR/error/invalid_code parts");
      return null;
    }
    String str1 = arrayOfString[0];
    String str2 = arrayOfString[1];
    paramString = (String)localObject;
    if (arrayOfString.length >= 3) {
      paramString = arrayOfString[2];
    }
    return new d(str1, str2, paramString);
  }
  
  public static void g()
  {
    SharedPreferences.Editor localEditor = u.a().getSharedPreferences("qr_data", 0).edit();
    e = null;
    localEditor.remove("token");
    if (!localEditor.commit()) {
      Log.e("qrsession/clearLoginToken/error/commit_failed");
    }
  }
  
  public static void h()
  {
    if (k.size() > 0) {
      bu.a(auk.a());
    }
  }
  
  public static void h(String paramString)
  {
    if ((paramString != null) && (!paramString.equals(g)))
    {
      Log.d("epoch new=" + paramString + " old=" + g + ", clearing");
      g = paramString;
      j.clear();
    }
  }
  
  public static void i()
  {
    p = true;
    F();
    z();
  }
  
  public static boolean j()
  {
    return (c()) && (p);
  }
  
  public static boolean k()
  {
    return (c()) && (t);
  }
  
  public static void l()
  {
    if (c())
    {
      t = true;
      C();
    }
  }
  
  public static void m()
  {
    if (!c()) {}
    Object localObject;
    do
    {
      return;
      localObject = new Intent("com.whatsapp.alarm.WEB_RENOTIFY").setPackage(au.b());
      localObject = PendingIntent.getBroadcast(u.a(), 0, (Intent)localObject, 536870912);
    } while (localObject == null);
    Log.d("qrsession/renotify/cancel");
    ((AlarmManager)u.a().getSystemService("alarm")).cancel((PendingIntent)localObject);
    ((PendingIntent)localObject).cancel();
  }
  
  public static void n()
  {
    if (Build.VERSION.SDK_INT >= 23) {
      s.sendEmptyMessage(2);
    }
  }
  
  public static void o()
  {
    Log.i("qrsession/deleteAllSessions");
    u.a().getSharedPreferences("qr_data", 0).edit().clear().apply();
    B().clear();
    A().a.getWritableDatabase().delete("sessions", null, null);
    D();
    b = null;
    c = null;
    d = null;
    e = null;
    f = null;
    z();
  }
  
  public static String p()
  {
    return ".--" + Integer.toHexString(n.getAndIncrement());
  }
  
  private static void z()
  {
    Iterator localIterator = A.iterator();
    while (localIterator.hasNext()) {
      ((s)localIterator.next()).a();
    }
  }
  
  static final class a
    extends Handler
  {
    public a()
    {
      super();
    }
    
    /* Error */
    public final void handleMessage(Message arg1)
    {
      // Byte code:
      //   0: aload_1
      //   1: getfield 31	android/os/Message:what	I
      //   4: tableswitch	default:+24->28, 1:+25->29, 2:+136->140
      //   28: return
      //   29: aload_0
      //   30: iconst_1
      //   31: invokevirtual 35	com/whatsapp/auj$a:removeMessages	(I)V
      //   34: aload_0
      //   35: iconst_2
      //   36: invokevirtual 39	com/whatsapp/auj$a:hasMessages	(I)Z
      //   39: ifne -11 -> 28
      //   42: getstatic 43	com/whatsapp/auj:j	Ljava/util/Map;
      //   45: astore 4
      //   47: aload 4
      //   49: monitorenter
      //   50: new 45	java/io/ObjectOutputStream
      //   53: dup
      //   54: new 47	java/io/FileOutputStream
      //   57: dup
      //   58: invokestatic 51	com/whatsapp/auj:w	()Ljava/io/File;
      //   61: invokespecial 54	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   64: invokespecial 57	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   67: astore 5
      //   69: aconst_null
      //   70: astore_3
      //   71: aload 5
      //   73: getstatic 43	com/whatsapp/auj:j	Ljava/util/Map;
      //   76: invokevirtual 61	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
      //   79: aload 5
      //   81: invokevirtual 64	java/io/ObjectOutputStream:close	()V
      //   84: aload 4
      //   86: monitorexit
      //   87: ldc 66
      //   89: ldc 68
      //   91: getstatic 72	com/whatsapp/auj:g	Ljava/lang/String;
      //   94: invokestatic 76	com/whatsapp/auj:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
      //   97: pop
      //   98: return
      //   99: astore_1
      //   100: ldc 78
      //   102: aload_1
      //   103: invokestatic 84	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   106: return
      //   107: astore_1
      //   108: aload_1
      //   109: athrow
      //   110: astore_2
      //   111: aload_1
      //   112: astore_3
      //   113: aload_2
      //   114: astore_1
      //   115: aload_3
      //   116: ifnull +16 -> 132
      //   119: aload 5
      //   121: invokevirtual 64	java/io/ObjectOutputStream:close	()V
      //   124: aload_1
      //   125: athrow
      //   126: astore_1
      //   127: aload 4
      //   129: monitorexit
      //   130: aload_1
      //   131: athrow
      //   132: aload 5
      //   134: invokevirtual 64	java/io/ObjectOutputStream:close	()V
      //   137: goto -13 -> 124
      //   140: aload_0
      //   141: iconst_1
      //   142: invokevirtual 35	com/whatsapp/auj$a:removeMessages	(I)V
      //   145: aload_0
      //   146: iconst_2
      //   147: invokevirtual 35	com/whatsapp/auj$a:removeMessages	(I)V
      //   150: getstatic 43	com/whatsapp/auj:j	Ljava/util/Map;
      //   153: astore_1
      //   154: aload_1
      //   155: monitorenter
      //   156: invokestatic 51	com/whatsapp/auj:w	()Ljava/io/File;
      //   159: invokevirtual 90	java/io/File:delete	()Z
      //   162: pop
      //   163: aload_1
      //   164: monitorexit
      //   165: ldc 66
      //   167: ldc 68
      //   169: invokestatic 93	com/whatsapp/auj:d	(Ljava/lang/String;Ljava/lang/String;)Z
      //   172: pop
      //   173: return
      //   174: astore_2
      //   175: aload_1
      //   176: monitorexit
      //   177: aload_2
      //   178: athrow
      //   179: astore_2
      //   180: goto -56 -> 124
      //   183: astore_1
      //   184: goto -69 -> 115
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	187	0	this	a
      //   110	4	2	localObject1	Object
      //   174	4	2	localObject2	Object
      //   179	1	2	localThrowable	Throwable
      //   70	46	3	localMessage	Message
      //   67	66	5	localObjectOutputStream	java.io.ObjectOutputStream
      // Exception table:
      //   from	to	target	type
      //   42	50	99	java/lang/Exception
      //   87	98	99	java/lang/Exception
      //   130	132	99	java/lang/Exception
      //   71	79	107	java/lang/Throwable
      //   108	110	110	finally
      //   50	69	126	finally
      //   79	87	126	finally
      //   119	124	126	finally
      //   124	126	126	finally
      //   127	130	126	finally
      //   132	137	126	finally
      //   156	165	174	finally
      //   175	177	174	finally
      //   119	124	179	java/lang/Throwable
      //   71	79	183	finally
    }
  }
  
  static final class b
    extends Handler
  {
    long a = 60000L;
    
    public b()
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      Context localContext = u.a();
      switch (paramMessage.what)
      {
      default: 
        return;
      case 3: 
        Log.i("qrsession/fservice/delayed exec");
      case 2: 
        Log.i("qrsession/fservice/kill");
        removeMessages(2);
        removeMessages(3);
        this.a = 60000L;
        localContext.stopService(new Intent(localContext, WebClientService.class));
        return;
      }
      Log.i("qrsession/fservice/start");
      removeMessages(2);
      removeMessages(1);
      removeMessages(3);
      localContext.startService(new Intent(localContext, WebClientService.class));
    }
  }
  
  static final class c
    implements Runnable
  {
    private aur.b a;
    private Location b;
    private final pv c;
    private final aus d;
    
    public c(pv parampv, aus paramaus, aur.b paramb, Location paramLocation)
    {
      this.c = parampv;
      this.d = paramaus;
      this.a = paramb;
      this.b = paramLocation;
      paramb.f = paramLocation.getLatitude();
      paramb.g = paramLocation.getLongitude();
      paramb.h = paramLocation.getAccuracy();
    }
    
    public final void run()
    {
      Object localObject = new Geocoder(u.a(), this.d.b());
      try
      {
        localObject = ((Geocoder)localObject).getFromLocation(this.b.getLatitude(), this.b.getLongitude(), 1);
        if ((localObject != null) && (!((List)localObject).isEmpty()))
        {
          localObject = (Address)((List)localObject).get(0);
          this.a.i = ((Address)localObject).getLocality();
        }
      }
      catch (Exception localException)
      {
        String str1;
        double d1;
        double d2;
        double d3;
        String str2;
        ContentValues localContentValues;
        for (;;) {}
      }
      localObject = auj.u();
      str1 = this.a.a;
      d1 = this.a.f;
      d2 = this.a.g;
      d3 = this.a.h;
      str2 = this.a.i;
      localContentValues = new ContentValues();
      localContentValues.put("lat", Double.valueOf(d1));
      localContentValues.put("lon", Double.valueOf(d2));
      localContentValues.put("accuracy", Double.valueOf(d3));
      localContentValues.put("place_name", str2);
      ((aur)localObject).a.getWritableDatabase().update("sessions", localContentValues, "browser_id = ?", new String[] { str1 });
      this.c.a(aum.a());
    }
  }
  
  public static final class d
  {
    public String a;
    public String b;
    public byte[] c;
    public String d;
    public String e;
    
    public d(String paramString1, String paramString2, String paramString3)
    {
      this.a = paramString1;
      this.d = paramString3;
      this.e = paramString2;
      paramString1 = new byte[64];
      auj.x().nextBytes(paramString1);
      this.b = Base64.encodeToString(paramString1, 2);
      this.c = paramString1;
    }
  }
  
  public static final class e
  {
    String a;
    String b;
    String c;
    String d;
    String e;
    
    public e(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramString3;
      this.d = paramString4;
      this.e = paramString5;
    }
    
    public final boolean a(String paramString1, String paramString2)
    {
      return (paramString1 != null) && (paramString1.equals(this.d)) && (paramString2 != null) && (paramString2.equals(this.e));
    }
  }
  
  public static final class f
    extends BroadcastReceiver
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = l.a();
      f localf = f.a();
      auj.t();
      boolean bool1 = paramIntent.getBooleanExtra("noPopup", true);
      boolean bool2 = paramIntent.getBooleanExtra("isAndroidWearRefresh", false);
      paramIntent = FMessageKey.a(paramIntent.getByteArrayExtra("messageKeyBytes"));
      if (paramIntent != null)
      {
        paramIntent = paramContext.a(paramIntent);
        StringBuilder localStringBuilder = new StringBuilder("qrsession/renotify/onReceive ");
        if (paramIntent == null) {}
        for (paramContext = "null";; paramContext = Log.a(paramIntent))
        {
          Log.d(paramContext + ' ' + bool1 + ' ' + bool2);
          if (paramIntent == null) {
            break;
          }
          localf.a(paramIntent, false, bool1, bool2);
          return;
        }
        Log.i("qrsession/renotify/no-message");
        return;
      }
      Log.e("qrsession/renotify/no-messag-key");
    }
  }
  
  public static final class g
    extends auj.q
  {
    String a;
    boolean b;
    private final aj c;
    private final rh e;
    
    public g(aj paramaj, rh paramrh, String paramString, boolean paramBoolean)
    {
      this.c = paramaj;
      this.e = paramrh;
      this.a = paramString;
      this.b = paramBoolean;
    }
    
    public final void a()
    {
      this.c.a(this.e, this.a, this.b);
    }
    
    public final String b()
    {
      return "qr_bclist_recipients " + this.a;
    }
    
    public final boolean c()
    {
      return (this.b) || (super.c());
    }
  }
  
  public static final class h
  {
    public final int a;
    public final boolean b;
    public final boolean c;
    
    private h(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.a = paramInt;
      this.b = paramBoolean1;
      this.c = paramBoolean2;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass())) {
          return false;
        }
        paramObject = (h)paramObject;
      } while ((this.a == ((h)paramObject).a) && (this.b == ((h)paramObject).b) && (this.c == ((h)paramObject).c));
      return false;
    }
    
    public final int hashCode()
    {
      int j = 1;
      int k = this.a;
      int i;
      if (this.b)
      {
        i = 1;
        if (!this.c) {
          break label40;
        }
      }
      for (;;)
      {
        return (i + k * 31) * 31 + j;
        i = 0;
        break;
        label40:
        j = 0;
      }
    }
  }
  
  public static final class i
    extends auj.q
  {
    List<cs> a;
    String b;
    private final aj c;
    
    public i(aj paramaj, List<cs> paramList, String paramString)
    {
      this.c = paramaj;
      this.a = paramList;
      this.b = paramString;
    }
    
    public final void a()
    {
      this.c.a(this.a, this.b);
    }
    
    public final String b()
    {
      return "qr_contacts count: " + this.a.size() + " checksum: " + this.b;
    }
  }
  
  public static final class j
    extends auj.q
  {
    String a;
    boolean b;
    private final aj c;
    
    public j(aj paramaj, String paramString, boolean paramBoolean)
    {
      this.c = paramaj;
      this.a = paramString;
      this.b = paramBoolean;
    }
    
    public final void a()
    {
      this.c.a(this.a, this.b);
    }
    
    public final String b()
    {
      return "qr_chat_seen/" + this.a + "/" + this.b;
    }
  }
  
  public static final class k
    extends auj.q
  {
    ar a;
    private final aj b;
    
    public k(aj paramaj, ar paramar)
    {
      this.b = paramaj;
      this.a = paramar;
    }
    
    public final void a()
    {
      this.b.a(this.a.c, this.a.a, this.a.d, 0);
    }
    
    public final String b()
    {
      return "qr_chat_update " + this.a.a + " op: " + this.a.c + " ts: " + this.a.d;
    }
  }
  
  public static final class l
    extends auj.q
  {
    String a;
    Collection<j> b;
    int c;
    private final aj e;
    
    public l(aj paramaj, String paramString, Collection<j> paramCollection, int paramInt)
    {
      this.e = paramaj;
      this.a = paramString;
      this.b = paramCollection;
      this.c = paramInt;
    }
    
    public final void a()
    {
      this.e.a(this.a, this.b, this.c);
    }
    
    public final String b()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        j localj = (j)localIterator.next();
        localStringBuilder.append(" ");
        localStringBuilder.append(localj.e);
      }
      return "qr_del_msgs " + this.a + localStringBuilder + " " + this.c;
    }
  }
  
  public static final class m
    implements i, x
  {
    auj.q a;
    
    public m(auj.q paramq)
    {
      paramq.d = auj.a;
      this.a = paramq;
    }
    
    public final void a(int paramInt)
    {
      if (paramInt >= 500)
      {
        if (this.a.c())
        {
          Log.e("qr_error 500 queueing: " + this.a);
          auj.k.add(this.a);
          return;
        }
        Log.e("qr_error 500 op invalid dropping: " + this.a);
        return;
      }
      if (paramInt >= 400)
      {
        auj.y();
        return;
      }
      Log.e("unexpected return code: " + paramInt + " op: " + this.a);
    }
    
    public final void a(Exception paramException)
    {
      Log.d("qr_exception: " + this.a, paramException);
    }
  }
  
  public static final class n
    extends auj.q
  {
    private final aj a;
    private final String b;
    
    public n(aj paramaj, String paramString)
    {
      this.a = paramaj;
      this.b = paramString;
    }
    
    public final void a()
    {
      this.a.b(this.b);
    }
    
    public final String b()
    {
      return "web-frequent-contacts";
    }
  }
  
  public static final class o
    extends auj.q
  {
    String a;
    private final aj b;
    
    public o(aj paramaj, String paramString)
    {
      this.b = paramaj;
      this.a = paramString;
    }
    
    public final void a()
    {
      this.b.a(this.a);
    }
    
    public final String b()
    {
      return "web_identity_changed/" + this.a;
    }
  }
  
  public static final class p
    extends auj.q
  {
    j.b a;
    int b;
    private final aj c;
    
    public p(aj paramaj, j.b paramb, int paramInt)
    {
      this.c = paramaj;
      this.a = paramb;
      this.b = paramInt;
    }
    
    public final void a()
    {
      this.c.a(this.a, this.b);
    }
    
    public final String b()
    {
      return "qr_msg_recv " + this.a;
    }
  }
  
  public static abstract class q
  {
    String d;
    
    public abstract void a();
    
    public abstract String b();
    
    public boolean c()
    {
      return (this.d != null) && (this.d.equals(auj.a));
    }
    
    public String toString()
    {
      return b();
    }
  }
  
  public static final class r
    extends auj.q
  {
    String a;
    List<av> b;
    int c;
    boolean e;
    String f;
    private final aj g;
    
    public r(aj paramaj, String paramString1, List<av> paramList, int paramInt, boolean paramBoolean, String paramString2)
    {
      this.g = paramaj;
      this.a = paramString1;
      this.b = paramList;
      this.c = paramInt;
      this.e = paramBoolean;
      this.f = paramString2;
    }
    
    public final void a()
    {
      this.g.a(this.a, this.b, this.c, this.e, this.f);
    }
    
    public final String b()
    {
      StringBuilder localStringBuilder = new StringBuilder("qr_response type: ").append(this.c).append(" id: ").append(this.a).append(" #details: ");
      if (this.b != null) {}
      for (Object localObject = Integer.valueOf(this.b.size());; localObject = "-") {
        return (String)localObject;
      }
    }
    
    public final boolean c()
    {
      return (this.e) || (super.c());
    }
  }
  
  public static abstract interface s
  {
    public abstract void a();
    
    public abstract void a(int paramInt);
  }
  
  public static final class t
    extends auj.q
  {
    private final aj a;
    private final j b;
    private final String c;
    
    public t(aj paramaj, j paramj, String paramString)
    {
      this.a = paramaj;
      this.b = paramj;
      this.c = paramString;
    }
    
    public final void a()
    {
      this.a.a(this.b, this.c);
    }
    
    public final String b()
    {
      return "web-status-seen";
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/auj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */