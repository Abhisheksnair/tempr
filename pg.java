package com.whatsapp;

import a.a.a.a.a.a.d;
import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.b;
import com.google.android.gms.common.api.b.a;
import com.google.android.gms.common.api.b.b;
import com.google.android.gms.common.api.b.c;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.c;
import com.google.android.gms.location.f;
import com.google.android.gms.location.h;
import com.whatsapp.gdrive.ch;
import com.whatsapp.util.Log;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class pg
{
  final b a;
  final Map<LocationListener, b> b;
  final atu c;
  private final LocationManager d;
  
  public pg(Context paramContext, atu paramatu)
  {
    this.c = paramatu;
    if (ch.a(paramContext) == 0)
    {
      paramatu = new a((byte)0);
      this.b = new HashMap();
    }
    for (this.a = new b.a(paramContext).a(h.a).a(paramatu).a(paramatu).b();; this.a = null)
    {
      this.d = ((LocationManager)paramContext.getSystemService("location"));
      return;
      this.b = null;
    }
  }
  
  static LocationRequest a(b paramb)
  {
    LocationRequest localLocationRequest = LocationRequest.a();
    if ((paramb.d & 0x1) != 0) {
      localLocationRequest.a(100);
    }
    for (;;)
    {
      localLocationRequest.a(paramb.a);
      localLocationRequest.b(paramb.b);
      localLocationRequest.a(paramb.c);
      return localLocationRequest;
      if ((paramb.d & 0x2) != 0) {
        localLocationRequest.a(102);
      } else {
        localLocationRequest.a(105);
      }
    }
  }
  
  public final Location a()
  {
    Object localObject2 = a(1);
    Location localLocation = a(2);
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localLocation != null)
      {
        localObject1 = localObject2;
        if (((Location)localObject2).getTime() > localLocation.getTime() - 20000L) {}
      }
    }
    else
    {
      localObject1 = localLocation;
    }
    localObject2 = localObject1;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((Location)localObject1).getTime() + 7200000L < System.currentTimeMillis()) {
        localObject2 = null;
      }
    }
    return (Location)localObject2;
  }
  
  @SuppressLint({"MissingPermission"})
  public final Location a(int paramInt)
  {
    if (this.c.c())
    {
      if ((this.a != null) && (this.a.i()))
      {
        c localc = h.b;
        return c.a(this.a);
      }
      if (paramInt == 1)
      {
        if (this.c.a("android.permission.ACCESS_FINE_LOCATION") == 0) {
          return this.d.getLastKnownLocation("gps");
        }
      }
      else if (this.c.a("android.permission.ACCESS_COARSE_LOCATION") == 0) {
        return this.d.getLastKnownLocation("network");
      }
    }
    Log.w("FusedLocationManager/getLastKnownLocation/do not have location permissions");
    return null;
  }
  
  @SuppressLint({"MissingPermission"})
  public final void a(int paramInt, long paramLong1, long paramLong2, LocationListener paramLocationListener)
  {
    if (!this.c.c()) {}
    for (;;)
    {
      return;
      if (this.a != null)
      {
        if (this.b.isEmpty()) {
          this.a.e();
        }
        b localb = new b(paramLong1, paramLong2, paramInt, paramLocationListener);
        this.b.put(paramLocationListener, localb);
        if (this.a.i())
        {
          paramLocationListener = a(localb);
          h.b.a(this.a, paramLocationListener, localb);
        }
      }
      else
      {
        if ((paramInt & 0x1) != 0) {}
        try
        {
          if (this.c.a("android.permission.ACCESS_FINE_LOCATION") == 0) {
            this.d.requestLocationUpdates("gps", paramLong1, 0.0F, paramLocationListener);
          }
          while ((paramInt & 0x2) != 0)
          {
            try
            {
              if (this.c.a("android.permission.ACCESS_COARSE_LOCATION") != 0) {
                break label192;
              }
              this.d.requestLocationUpdates("network", paramLong1, 0.0F, paramLocationListener);
              return;
            }
            catch (RuntimeException paramLocationListener)
            {
              Log.d("FusedLocationManager/requestLocationUpdates", paramLocationListener);
              return;
            }
            Log.w("FusedLocationManager/requestLocationUpdates/do not have fine location permission");
          }
        }
        catch (RuntimeException localRuntimeException)
        {
          for (;;)
          {
            Log.d("FusedLocationManager/requestLocationUpdates", localRuntimeException);
          }
          label192:
          Log.w("FusedLocationManager/requestLocationUpdates/do not have coarse location permission");
        }
      }
    }
  }
  
  public final void a(LocationListener paramLocationListener)
  {
    if (this.a != null)
    {
      paramLocationListener = (b)this.b.remove(paramLocationListener);
      if (paramLocationListener != null)
      {
        if (this.a.i()) {
          h.b.a(this.a, paramLocationListener);
        }
        if (this.b.isEmpty()) {
          this.a.g();
        }
      }
    }
    while (!this.c.c()) {
      return;
    }
    this.d.removeUpdates(paramLocationListener);
  }
  
  final class a
    implements b.b, b.c
  {
    private a() {}
    
    public final void a(Bundle paramBundle)
    {
      if (!pg.this.c.c()) {}
      do
      {
        return;
        a.d.a(pg.this.b);
        paramBundle = pg.this.b.values().iterator();
        while (paramBundle.hasNext())
        {
          pg.b localb = (pg.b)paramBundle.next();
          LocationRequest localLocationRequest = pg.a(localb);
          try
          {
            h.b.a(pg.this.a, localLocationRequest, localb);
          }
          catch (SecurityException localSecurityException)
          {
            Log.c("FusedLocationManager/GmsConnectionCallbacks/onConnected/unable to request location updates", localSecurityException);
          }
        }
      } while (!pg.this.b.isEmpty());
      a.d.a(pg.this.a);
      pg.this.a.g();
    }
    
    public final void a(ConnectionResult paramConnectionResult) {}
    
    public final void c_(int paramInt) {}
  }
  
  static final class b
    implements f
  {
    final long a;
    final long b;
    final float c;
    final int d;
    private final LocationListener e;
    
    b(long paramLong1, long paramLong2, int paramInt, LocationListener paramLocationListener)
    {
      this.e = paramLocationListener;
      this.a = paramLong1;
      this.b = paramLong2;
      this.c = 0.0F;
      this.d = paramInt;
    }
    
    public final void a(Location paramLocation)
    {
      this.e.onLocationChanged(paramLocation);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/pg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */