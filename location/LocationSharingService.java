package com.whatsapp.location;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.support.v4.content.b;
import android.support.v7.app.n.b;
import android.text.TextUtils;
import android.util.SparseIntArray;
import b.a.a.c;
import com.whatsapp.LiveLocationPrivacyActivity;
import com.whatsapp.and;
import com.whatsapp.atu;
import com.whatsapp.atv;
import com.whatsapp.fieldstats.events.al;
import com.whatsapp.fieldstats.events.am;
import com.whatsapp.fieldstats.l;
import com.whatsapp.g.d;
import com.whatsapp.g.k;
import com.whatsapp.pg;
import com.whatsapp.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LocationSharingService
  extends Service
  implements LocationListener
{
  private final SparseIntArray a = new SparseIntArray();
  private long b = 0L;
  private final Handler c = new Handler(Looper.getMainLooper());
  private final Runnable d = ca.a(this);
  private pg e;
  private PowerManager.WakeLock f;
  private Location g;
  private Location h;
  private final bp i = bp.a();
  private final and j = and.a();
  private final atu k = atu.a();
  private final atv l = atv.a();
  private int m;
  private int n = 0;
  private al o;
  private am p;
  
  private void a()
  {
    int i1 = 0;
    if (this.b != 0L)
    {
      int i2 = (int)((this.b - this.b % 3600000L) / 1000L);
      int i3 = (int)(System.currentTimeMillis() - this.b);
      this.a.put(i2, i3 + this.a.get(i2, 0));
      Object localObject = new StringBuilder();
      while (i1 < this.a.size())
      {
        i2 = this.a.keyAt(i1);
        i3 = this.a.get(i2);
        if (i1 != 0) {
          ((StringBuilder)localObject).append(";");
        }
        ((StringBuilder)localObject).append(i2);
        ((StringBuilder)localObject).append(",");
        ((StringBuilder)localObject).append(i3);
        i1 += 1;
      }
      atv localatv = this.l;
      localObject = ((StringBuilder)localObject).toString();
      localatv.c().putString("location_shared_duration", (String)localObject).apply();
      this.b = 0L;
    }
  }
  
  private void a(Location paramLocation)
  {
    long l2 = 1L;
    this.h = paramLocation;
    this.i.a(paramLocation, Integer.valueOf(this.m));
    if (this.o != null)
    {
      b();
      paramLocation = this.o;
      if (this.o.b != null) {
        break label103;
      }
      l1 = 1L;
      paramLocation.b = Long.valueOf(l1);
      paramLocation = this.p;
      if (this.p.c != null) {
        break label119;
      }
    }
    label103:
    label119:
    for (long l1 = l2;; l1 = 1L + this.p.c.longValue())
    {
      paramLocation.c = Long.valueOf(l1);
      if (!this.i.m()) {
        this.i.g();
      }
      return;
      l1 = this.o.b.longValue() + 1L;
      break;
    }
  }
  
  private void b()
  {
    if ((this.p != null) && (System.currentTimeMillis() - this.p.a.doubleValue() > 300000.0D)) {
      c();
    }
    Boolean localBoolean;
    if (this.p == null)
    {
      localObject = (d)c.a().a(d.class);
      if (localObject == null) {
        break label160;
      }
      localBoolean = Boolean.valueOf(((d)localObject).b());
      if (localObject == null) {
        break label165;
      }
    }
    label160:
    label165:
    for (Object localObject = Double.valueOf(((d)localObject).a());; localObject = null)
    {
      this.p = new am();
      this.p.g = Integer.valueOf(this.m);
      this.p.a = Double.valueOf(System.currentTimeMillis());
      am localam = this.p;
      int i1 = this.n;
      this.n = (i1 + 1);
      localam.b = Long.valueOf(i1);
      this.p.f = localBoolean;
      this.p.e = ((Double)localObject);
      return;
      localBoolean = null;
      break;
    }
  }
  
  private void c()
  {
    if (this.p != null)
    {
      localObject = (d)c.a().a(d.class);
      if (localObject == null) {
        break label118;
      }
    }
    label118:
    for (Object localObject = Double.valueOf(((d)localObject).a());; localObject = null)
    {
      this.p.a = Double.valueOf(System.currentTimeMillis() - this.p.a.doubleValue());
      if ((this.p.e != null) && (localObject != null))
      {
        am localam = this.p;
        localam.e = Double.valueOf(localam.e.doubleValue() - ((Double)localObject).doubleValue());
      }
      if (this.p.c != null) {
        l.a(this, this.p);
      }
      this.p = null;
      return;
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    Log.i("LocationSharingService/onCreate");
    for (;;)
    {
      try
      {
        localObject = this.j.a;
        if (localObject != null) {
          continue;
        }
        Log.w("LocationSharingService/onCreate pm=null");
      }
      catch (RuntimeException localRuntimeException)
      {
        Object localObject;
        long l1;
        int i2;
        int i1;
        String[] arrayOfString;
        int i3;
        int i4;
        Log.d("LocationSharingService/onCreate/PowerManager exception", localRuntimeException);
        continue;
      }
      this.c.postDelayed(this.d, 42000L);
      this.e = new pg(this, this.k);
      localObject = this.l.a.getString("location_shared_duration", "");
      l1 = System.currentTimeMillis();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
      localObject = ((String)localObject).split(";");
      i2 = localObject.length;
      i1 = 0;
      if (i1 >= i2) {
        break;
      }
      arrayOfString = localObject[i1].split(",");
      if (arrayOfString.length == 2)
      {
        i3 = Integer.valueOf(arrayOfString[0]).intValue();
        if (i3 * 1000L + 86400000L >= l1)
        {
          i4 = Integer.valueOf(arrayOfString[1]).intValue();
          this.a.put(i3, i4);
        }
      }
      i1 += 1;
      continue;
      if (this.f == null) {
        this.f = ((PowerManager)localObject).newWakeLock(1, "ShareLocationService");
      }
      if ((this.f != null) && (!this.f.isHeld())) {
        this.f.acquire();
      }
    }
  }
  
  public void onDestroy()
  {
    Log.i("LocationSharingService/onDestroy");
    a();
    this.c.removeCallbacks(this.d);
    this.e.a(this);
    c();
    if (this.o != null)
    {
      localObject = (d)c.a().a(d.class);
      if (localObject == null) {
        break label180;
      }
    }
    label180:
    for (Object localObject = Double.valueOf(((d)localObject).a());; localObject = null)
    {
      if ((this.o.c != null) && (localObject != null))
      {
        al localal = this.o;
        localal.c = Double.valueOf(localal.c.doubleValue() - ((Double)localObject).doubleValue());
      }
      this.o.a = Double.valueOf(System.currentTimeMillis() - this.o.a.doubleValue());
      if (this.o.b != null) {
        l.a(this, this.o);
      }
      this.o = null;
      if ((this.f != null) && (this.f.isHeld()))
      {
        this.f.release();
        this.f = null;
      }
      return;
    }
  }
  
  public void onLocationChanged(Location paramLocation)
  {
    int i2 = 1;
    Log.i("LocationSharingService/onLocationChanged");
    Location localLocation = this.h;
    int i1;
    if (localLocation == null)
    {
      i1 = i2;
      if (i1 == 0) {
        break label112;
      }
      a(paramLocation);
      this.g = paramLocation;
    }
    label112:
    do
    {
      return;
      i1 = i2;
      if (localLocation.getTime() + 120000L < paramLocation.getTime()) {
        break;
      }
      i1 = i2;
      if (localLocation.getAccuracy() > paramLocation.getAccuracy()) {
        break;
      }
      if (TextUtils.equals(localLocation.getProvider(), paramLocation.getProvider()))
      {
        i1 = i2;
        if (localLocation.distanceTo(paramLocation) > Math.max(10.0F, paramLocation.getAccuracy())) {
          break;
        }
      }
      i1 = 0;
      break;
      if (paramLocation.getAccuracy() < 80.0F) {
        this.g = paramLocation;
      }
    } while ((this.g == null) || (this.h.getTime() + 40000L >= this.g.getTime()));
    a(this.g);
  }
  
  public void onProviderDisabled(String paramString) {}
  
  public void onProviderEnabled(String paramString) {}
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    this.c.removeCallbacks(this.d);
    if ((paramIntent != null) && (paramIntent.getAction().equals("com.whatsapp.ShareLocationService.STOP")))
    {
      Log.i("LocationSharingService/onStartCommand/stop");
      stopSelf();
    }
    for (;;)
    {
      paramIntent = new n.b(this);
      paramIntent.a(2130840189);
      paramIntent.c(getString(2131297328));
      paramIntent.a(getString(2131297328));
      paramIntent.b(getString(2131297324));
      paramIntent.a(PendingIntent.getActivity(this, 0, new Intent(this, LiveLocationPrivacyActivity.class), 0));
      paramIntent.d(-2);
      paramIntent.e(b.c(this, 2131624091));
      startForeground(15, paramIntent.e());
      return 1;
      long l1 = 42000L;
      if (paramIntent != null) {
        l1 = paramIntent.getLongExtra("duration", 42000L);
      }
      this.c.postDelayed(this.d, l1);
      Log.i("LocationSharingService/onStartCommand/start; duration=" + l1);
      Object localObject;
      if ((this.h == null) || (this.h.getTime() + 120000L < System.currentTimeMillis()))
      {
        localObject = this.e.a();
        paramIntent = (Intent)localObject;
        if (localObject != null)
        {
          paramIntent = (Intent)localObject;
          if (((Location)localObject).getTime() + 7200000L < System.currentTimeMillis()) {
            paramIntent = null;
          }
        }
        StringBuilder localStringBuilder = new StringBuilder("LocationSharingService/onStartCommand/start; ");
        if (paramIntent != null) {
          break label419;
        }
        localObject = "location=" + null;
        Log.i((String)localObject);
        if (paramIntent != null) {
          a(paramIntent);
        }
      }
      if (this.b != 0L) {
        a();
      }
      this.b = System.currentTimeMillis();
      paramIntent = new ArrayList();
      paramInt1 = 0;
      long l3 = 0L;
      label353:
      if (paramInt1 < this.a.size())
      {
        paramInt2 = this.a.keyAt(paramInt1);
        int i1 = this.a.get(paramInt2);
        if (paramInt2 * 1000L + 86400000L >= System.currentTimeMillis()) {}
        for (l1 = i1 + l3;; l1 = l3)
        {
          paramInt1 += 1;
          l3 = l1;
          break label353;
          label419:
          localObject = "location.provider=" + paramIntent.getProvider();
          break;
          paramIntent.add(Integer.valueOf(paramInt2));
        }
      }
      paramIntent = paramIntent.iterator();
      while (paramIntent.hasNext())
      {
        localObject = (Integer)paramIntent.next();
        this.a.delete(((Integer)localObject).intValue());
      }
      boolean bool = ((k)c.a().a(k.class)).a;
      paramIntent = (d)c.a().a(d.class);
      label546:
      double d1;
      label556:
      long l2;
      if ((paramIntent != null) && (paramIntent.b()))
      {
        paramInt1 = 1;
        if (paramIntent == null) {
          break label733;
        }
        d1 = paramIntent.a();
        if (!bool) {
          break label741;
        }
        this.m = 3;
        this.b = 0L;
        l1 = 30000L;
        l2 = 10000L;
        paramInt1 = 0;
        label583:
        this.e.a(this);
      }
      try
      {
        Log.i("LocationSharingService/onStartCommand/request location updates; powerSaveMode=" + bool + "; duration=" + l3 + "; locationProviders=" + paramInt1 + "; updateInterval=" + l1);
        this.e.a(paramInt1, l1, l2, this);
        if (this.o == null)
        {
          this.o = new al();
          paramIntent = (d)c.a().a(d.class);
          if (paramIntent != null)
          {
            paramIntent = Double.valueOf(paramIntent.a());
            this.o.a = Double.valueOf(System.currentTimeMillis());
            this.o.c = paramIntent;
          }
        }
        else
        {
          b();
          continue;
          paramInt1 = 0;
          break label546;
          label733:
          d1 = 100.0D;
          break label556;
          label741:
          if ((paramInt1 != 0) && (d1 > 50.0D))
          {
            this.m = 1;
            l1 = 5000L;
            l2 = 1000L;
            paramInt1 = 3;
            this.b = 0L;
            break label583;
          }
          if ((l3 > 7200000L) || ((paramInt1 == 0) && (d1 <= 15.0D)))
          {
            this.m = 3;
            l1 = 30000L;
            l2 = 10000L;
            paramInt1 = 0;
            this.b = 0L;
            break label583;
          }
          if ((l3 > 1800000L) || ((paramInt1 == 0) && (d1 <= 30.0D)))
          {
            this.m = 2;
            l1 = 10000L;
            l2 = 5000L;
            paramInt1 = 2;
            break label583;
          }
          this.m = 1;
          l1 = 5000L;
          l2 = 1000L;
          paramInt1 = 3;
        }
      }
      catch (IllegalArgumentException paramIntent)
      {
        for (;;)
        {
          Log.w("LocationSharingService/onCreate/GPS error " + paramIntent.toString());
          continue;
          paramIntent = null;
        }
      }
    }
  }
  
  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/location/LocationSharingService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */