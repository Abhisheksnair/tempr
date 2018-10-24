package com.whatsapp.location;

import a.a.a.a.a.a.d;
import android.content.Context;
import android.hardware.GeomagneticField;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.f;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CameraPosition.a;
import com.google.android.gms.maps.model.LatLng;

public class b
  extends com.google.android.gms.maps.c
{
  int a = 2;
  com.google.android.gms.maps.b b;
  private float[] c = new float[16];
  private float[] d = new float[3];
  private float[] e = new float[3];
  private float f;
  private float g;
  private long h;
  private boolean i;
  private SensorManager j;
  private Display k;
  private float l;
  private final f m = new c(this);
  private SensorEventListener n = new SensorEventListener()
  {
    public final void onAccuracyChanged(Sensor paramAnonymousSensor, int paramAnonymousInt) {}
    
    public final void onSensorChanged(SensorEvent paramAnonymousSensorEvent)
    {
      com.google.android.gms.maps.b localb = b.this.b(b.a(b.this));
      if (localb == null) {}
      Location localLocation;
      float f1;
      label170:
      float f2;
      for (;;)
      {
        return;
        if (localb.f())
        {
          localLocation = localb.g();
          if (localLocation == null) {}
        }
        else
        {
          try
          {
            SensorManager.getRotationMatrixFromVector(b.b(b.this), paramAnonymousSensorEvent.values);
            i = b.d(b.this).getRotation();
            if ((System.currentTimeMillis() - localLocation.getTime() < 5000L) && (localLocation.hasBearing()) && (localLocation.getSpeed() > 0.89408D))
            {
              f1 = localLocation.getBearing();
              b.a(b.this, b.a(b.this, f1, b.f(b.this)));
              if ((i != 0) && (i != 2)) {
                break label478;
              }
              b.b(b.this, (float)Math.abs(Math.toDegrees(b.e(b.this)[1])));
              if (b.g(b.this) != 0) {
                continue;
              }
              paramAnonymousSensorEvent = b.a(new LatLng(localLocation.getLatitude(), localLocation.getLongitude()), b.f(b.this));
              localb.a(a.a.a.a.d.a(CameraPosition.a().b(b.a(b.i(b.this))).c(b.f(b.this)).a(Math.max(b.h(b.this), 15.0F)).a(paramAnonymousSensorEvent).a()));
              return;
              localLocation = null;
            }
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            int i;
            for (;;)
            {
              if (paramAnonymousSensorEvent.values.length > 3)
              {
                System.arraycopy(paramAnonymousSensorEvent.values, 0, b.c(b.this), 0, 3);
                SensorManager.getRotationMatrixFromVector(b.b(b.this), b.c(b.this));
              }
            }
            SensorManager.getOrientation(b.b(b.this), b.e(b.this));
            f2 = (float)Math.toDegrees(b.e(b.this)[0]);
            f1 = f2;
            switch (i)
            {
            default: 
              f1 = f2;
            }
          }
        }
      }
      label390:
      if (f1 < 0.0F) {
        f1 += 360.0F;
      }
      for (;;)
      {
        f2 = new GeomagneticField((float)localLocation.getLatitude(), (float)localLocation.getLongitude(), (float)localLocation.getAltitude(), localLocation.getTime()).getDeclination() + f1;
        f1 = f2;
        if (f2 < 360.0F) {
          break;
        }
        f1 = f2 - 360.0F;
        break;
        f1 = f2 + 90.0F;
        break label390;
        f1 = f2 + 180.0F;
        break label390;
        f1 = f2 + 270.0F;
        break label390;
        label478:
        b.b(b.this, (float)Math.abs(Math.toDegrees(b.e(b.this)[2])));
        break label170;
      }
    }
  };
  
  public b(Context paramContext, GoogleMapOptions paramGoogleMapOptions)
  {
    super(paramContext, paramGoogleMapOptions);
    this.j = ((SensorManager)paramContext.getSystemService("sensor"));
    this.k = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
  }
  
  public static float a(float paramFloat)
  {
    return Math.max(Math.min(paramFloat, 67.5F), 0.0F);
  }
  
  public static LatLng a(LatLng paramLatLng, double paramDouble)
  {
    double d1 = Math.toRadians(paramDouble);
    double d5 = Math.toRadians(paramLatLng.b);
    paramDouble = Math.toRadians(paramLatLng.c);
    double d2 = Math.cos(7.83927971443699E-6D);
    double d3 = Math.sin(7.83927971443699E-6D);
    double d4 = Math.sin(d5);
    double d6 = Math.cos(d5);
    d5 = d2 * d4 + d3 * d6 * Math.cos(d1);
    d1 = Math.atan2(Math.sin(d1) * (d6 * d3), d2 - d4 * d5);
    return new LatLng(Math.toDegrees(Math.asin(d5)), Math.toDegrees(d1 + paramDouble));
  }
  
  public void a(int paramInt) {}
  
  public final com.google.android.gms.maps.b b(f paramf)
  {
    
    if (this.b != null)
    {
      paramf.a(this.b);
      return this.b;
    }
    a(paramf);
    return null;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a != 2)
    {
      this.a = 2;
      a(this.a);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public final void e()
  {
    switch (this.a)
    {
    default: 
      return;
    case 0: 
      setLocationMode(1);
      return;
    case 1: 
      setLocationMode(0);
      return;
    }
    setLocationMode(1);
  }
  
  public final void f()
  {
    Sensor localSensor;
    if (this.j != null)
    {
      localSensor = this.j.getDefaultSensor(11);
      if (localSensor == null) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      this.i = bool;
      if (localSensor != null) {
        this.j.registerListener(this.n, localSensor, 16000);
      }
      return;
    }
  }
  
  public final void g()
  {
    if (this.j != null) {
      this.j.unregisterListener(this.n);
    }
  }
  
  public int getLocationMode()
  {
    return this.a;
  }
  
  public Location getMyLocation()
  {
    com.google.android.gms.maps.b localb = b(this.m);
    if (localb == null) {}
    while (!localb.f()) {
      return null;
    }
    return localb.g();
  }
  
  public void setLocationMode(int paramInt)
  {
    com.google.android.gms.maps.b localb = b(this.m);
    if (localb == null) {
      this.a = paramInt;
    }
    CameraPosition localCameraPosition;
    do
    {
      return;
      localCameraPosition = localb.a();
      switch (paramInt)
      {
      default: 
        return;
      }
    } while (!this.i);
    this.l = localCameraPosition.c;
    a(0);
    Object localObject = getMyLocation();
    if (localObject != null) {}
    for (localObject = new LatLng(((Location)localObject).getLatitude(), ((Location)localObject).getLongitude());; localObject = localCameraPosition.b)
    {
      if (localObject != null)
      {
        localObject = a((LatLng)localObject, this.f);
        localb.b(a.a.a.a.d.a(CameraPosition.a().b(a(this.g)).c(this.f).a(Math.max(this.l, 15.0F)).a((LatLng)localObject).a()));
      }
      postDelayed(d.a(this, localb), 1000L);
      return;
    }
    localObject = getMyLocation();
    if (localObject != null) {
      localObject = new LatLng(((Location)localObject).getLatitude(), ((Location)localObject).getLongitude());
    }
    for (this.a = 1;; this.a = 2)
    {
      a(this.a);
      localb.b(a.a.a.a.d.a(CameraPosition.a().a((LatLng)localObject).a(localCameraPosition.c).b(0.0F).c(0.0F).a()));
      return;
      localObject = localCameraPosition.b;
    }
    this.a = 2;
    a(2);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/location/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */