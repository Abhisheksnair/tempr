package com.whatsapp.location;

import a.a.a.a.d;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v4.view.o;
import android.support.v7.widget.SearchView.b;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.OverlayItem;
import com.whatsapp.PlaceInfo;
import com.whatsapp.abn;
import com.whatsapp.ahp;
import com.whatsapp.and;
import com.whatsapp.aoa;
import com.whatsapp.aoj;
import com.whatsapp.atu;
import com.whatsapp.atv;
import com.whatsapp.aus;
import com.whatsapp.data.l;
import com.whatsapp.emoji.h;
import com.whatsapp.pv;
import com.whatsapp.u;
import com.whatsapp.util.Log;
import com.whatsapp.util.at;
import com.whatsapp.va;
import java.util.ArrayList;
import java.util.List;

public class LocationPicker
  extends MapActivity
  implements GoogleMapView.a
{
  GoogleMapView a;
  MyLocationOverlay b;
  a c;
  a d;
  View e;
  final ba f = new ba(this.r, this.s, this.t, this.u, this.v, this.w, this.x, this.y, this.z)
  {
    public final void a()
    {
      LocationPicker.a(LocationPicker.this).a();
      LocationPicker.b(LocationPicker.this).invalidate();
    }
    
    protected final void a(boolean paramAnonymousBoolean)
    {
      if ((!this.j) && ((this.o == null) || (this.o.tag == null)))
      {
        LocationPicker.f(LocationPicker.this).setVisibility(0);
        return;
      }
      LocationPicker.f(LocationPicker.this).setVisibility(8);
    }
    
    public final void a(boolean paramAnonymousBoolean, LatLngBounds paramAnonymousLatLngBounds)
    {
      Object localObject = paramAnonymousLatLngBounds.a();
      localObject = new GeoPoint((int)(((LatLng)localObject).b * 1000000.0D), (int)(((LatLng)localObject).c * 1000000.0D));
      LocationPicker.b(LocationPicker.this).getController().setCenter((GeoPoint)localObject);
      int i = (int)((paramAnonymousLatLngBounds.c.b - paramAnonymousLatLngBounds.b.b) * 1.2D * 1000000.0D);
      int j = (int)((paramAnonymousLatLngBounds.c.c - paramAnonymousLatLngBounds.b.c) * 1.2D * 1000000.0D);
      if (paramAnonymousBoolean)
      {
        LocationPicker.b(LocationPicker.this).getController().setZoom(15);
        return;
      }
      LocationPicker.b(LocationPicker.this).getController().zoomToSpan(i, j);
    }
    
    protected final Location b()
    {
      if (this.j)
      {
        if (LocationPicker.c(LocationPicker.this) != null) {
          return LocationPicker.c(LocationPicker.this).getLastFix();
        }
      }
      else if (LocationPicker.d(LocationPicker.this) != null) {
        return LocationPicker.d(LocationPicker.this).getLastFix();
      }
      return null;
    }
    
    protected final Location c()
    {
      return LocationPicker.b(LocationPicker.this).getCenterLocation();
    }
    
    protected final int d()
    {
      return LocationPicker.b(LocationPicker.this).getRadius();
    }
    
    protected final void e()
    {
      LocationPicker.e(LocationPicker.this).setVisibility(0);
    }
    
    protected final void f()
    {
      LocationPicker.e(LocationPicker.this).setVisibility(8);
    }
    
    protected final void g()
    {
      List localList = LocationPicker.b(LocationPicker.this).getOverlays();
      localList.clear();
      if (this.j)
      {
        localList.add(LocationPicker.c(LocationPicker.this));
        LocationPicker.b(LocationPicker.this).a(LocationPicker.c(LocationPicker.this).getMyLocation());
        LocationPicker.b(LocationPicker.this).getController().setZoom(15);
      }
      for (;;)
      {
        LocationPicker.this.invalidateOptionsMenu();
        return;
        localList.add(LocationPicker.a(LocationPicker.this));
        localList.add(LocationPicker.d(LocationPicker.this));
      }
    }
    
    protected final boolean h()
    {
      return false;
    }
  };
  private ProgressBar g;
  private android.support.v7.app.e h;
  private ahp i;
  private View j;
  private View k;
  private ba.b l;
  private HandlerThread m;
  private Handler n;
  private boolean o;
  private float p;
  private float q;
  private final pv r = pv.a();
  private final va s = va.a();
  private final aoj t = aoj.a();
  private final h u = h.a();
  private final aus v = aus.a();
  private final and w = and.a();
  private final l x = l.a();
  private final atu y = atu.a();
  private final atv z = atv.a();
  
  private android.support.v7.app.e a()
  {
    if (this.h == null) {
      this.h = android.support.v7.app.e.a(this, null);
    }
    return this.h;
  }
  
  public final void a(GeoPoint paramGeoPoint)
  {
    this.f.m.lat = (paramGeoPoint.getLatitudeE6() / 1000000.0D);
    this.f.m.lon = (paramGeoPoint.getLongitudeE6() / 1000000.0D);
    this.f.m.name = null;
    this.f.m.address = null;
    if (!this.f.j)
    {
      this.n.removeCallbacks(this.l);
      paramGeoPoint = this.f;
      paramGeoPoint.getClass();
      this.l = new ba.b(paramGeoPoint, this.f.m.lat, this.f.m.lon);
      this.n.post(this.l);
    }
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    a().b(paramView, paramLayoutParams);
  }
  
  public MenuInflater getMenuInflater()
  {
    return a().b();
  }
  
  public void invalidateOptionsMenu()
  {
    a().g();
  }
  
  protected boolean isRouteDisplayed()
  {
    return false;
  }
  
  public void onBackPressed()
  {
    if (this.i.c()) {
      this.i.b();
    }
    while (this.f.l()) {
      return;
    }
    super.onBackPressed();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.v.e();
    super.onConfigurationChanged(paramConfiguration);
    a().a(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Log.i("LocationPicker/onCreate");
    com.whatsapp.al.a(getWindow());
    this.v.e();
    a().i();
    a().a(paramBundle);
    super.onCreate(paramBundle);
    setContentView(com.whatsapp.al.a(this.r, getLayoutInflater(), 2130903274, null, false));
    Object localObject = (Toolbar)findViewById(2131755412);
    a().a((Toolbar)localObject);
    this.i = new ahp(this, this.r, findViewById(2131755496), (Toolbar)localObject, new SearchView.b()
    {
      public final boolean a(String paramAnonymousString)
      {
        LocationPicker.g(LocationPicker.this).a(paramAnonymousString);
        return false;
      }
      
      public final boolean b(String paramAnonymousString)
      {
        return false;
      }
    });
    localObject = a().a();
    ((android.support.v7.app.a)localObject).a(true);
    ((android.support.v7.app.a)localObject).a(2131297660);
    this.e = findViewById(2131755875);
    this.j = findViewById(2131755879);
    this.k = findViewById(2131755880);
    this.f.a(this, paramBundle);
    this.a = new GoogleMapView(this)
    {
      public final boolean dispatchTouchEvent(MotionEvent paramAnonymousMotionEvent)
      {
        if (!LocationPicker.g(LocationPicker.this).j) {
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
        }
        for (;;)
        {
          return super.dispatchTouchEvent(paramAnonymousMotionEvent);
          if (!LocationPicker.h(LocationPicker.this))
          {
            LocationPicker.a(LocationPicker.this, paramAnonymousMotionEvent.getX());
            LocationPicker.b(LocationPicker.this, paramAnonymousMotionEvent.getY());
            continue;
            if (LocationPicker.g(LocationPicker.this).o != null)
            {
              LocationPicker.a(LocationPicker.this).a();
              LocationPicker.g(LocationPicker.this).m();
            }
            if (!LocationPicker.h(LocationPicker.this))
            {
              float f1 = paramAnonymousMotionEvent.getX();
              float f2 = paramAnonymousMotionEvent.getY();
              float f3 = LocationPicker.i(LocationPicker.this);
              float f4 = LocationPicker.i(LocationPicker.this);
              float f5 = LocationPicker.j(LocationPicker.this);
              if ((f1 - f4) * (f1 - f3) + (f2 - LocationPicker.j(LocationPicker.this)) * (f2 - f5) > aoa.a().a * 6.0F)
              {
                LocationPicker.a(LocationPicker.this, true);
                LocationPicker.k(LocationPicker.this).setVisibility(0);
                TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, LocationPicker.k(LocationPicker.this).getHeight(), 0.0F);
                localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
                localTranslateAnimation.setDuration(120L);
                LocationPicker.l(LocationPicker.this).startAnimation(localTranslateAnimation);
                LocationPicker.f(LocationPicker.this).setVisibility(0);
                LocationPicker.b(LocationPicker.this).getOverlays().clear();
                LocationPicker.b(LocationPicker.this).getOverlays().add(LocationPicker.a(LocationPicker.this));
                LocationPicker.b(LocationPicker.this).getOverlays().add(LocationPicker.d(LocationPicker.this));
                continue;
                LocationPicker.a(LocationPicker.this, 0.0F);
                LocationPicker.b(LocationPicker.this, 0.0F);
                if (LocationPicker.h(LocationPicker.this))
                {
                  LocationPicker.a(LocationPicker.this, false);
                  LocationPicker.k(LocationPicker.this).setVisibility(8);
                  localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -LocationPicker.k(LocationPicker.this).getHeight(), 0.0F);
                  localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
                  localTranslateAnimation.setDuration(120L);
                  LocationPicker.l(LocationPicker.this).startAnimation(localTranslateAnimation);
                }
              }
            }
          }
        }
      }
    };
    this.a.setClickable(true);
    this.a.setEnabled(true);
    this.a.setMapListener(this);
    this.a.setBuiltInZoomControls(false);
    this.a.getController().setZoom(15);
    ((ViewGroup)findViewById(2131755628)).addView(this.a);
    this.b = new e(this, this.a)
    {
      public final void onLocationChanged(Location paramAnonymousLocation)
      {
        super.onLocationChanged(paramAnonymousLocation);
        if (paramAnonymousLocation == null) {
          return;
        }
        LocationPicker.g(LocationPicker.this).a(paramAnonymousLocation);
      }
    };
    localObject = new BitmapDrawable(getResources(), this.f.k);
    this.d = new a(this, this.a, (BitmapDrawable)localObject)
    {
      public final void onLocationChanged(Location paramAnonymousLocation)
      {
        super.onLocationChanged(paramAnonymousLocation);
        if (paramAnonymousLocation == null) {
          return;
        }
        LocationPicker.g(LocationPicker.this).a(paramAnonymousLocation);
      }
    };
    if (paramBundle != null)
    {
      i1 = paramBundle.getInt("zoom");
      if (i1 > 0)
      {
        paramBundle = new GeoPoint(paramBundle.getInt("lat"), paramBundle.getInt("lon"));
        this.a.getController().setCenter(paramBundle);
        this.a.getController().setZoom(i1);
      }
      this.c = new a();
      this.c.a();
      if (!this.f.j) {
        break label556;
      }
      this.a.getOverlays().add(this.d);
      label409:
      this.g = ((ProgressBar)findViewById(2131755667));
      paramBundle = this.g;
      if (this.f.n != null) {
        break label593;
      }
    }
    label556:
    label593:
    for (int i1 = 0;; i1 = 8)
    {
      paramBundle.setVisibility(i1);
      findViewById(2131755882).setVisibility(8);
      paramBundle = (ImageView)findViewById(2131755820);
      paramBundle.setImageResource(2130837703);
      paramBundle.setOnClickListener(am.a(this));
      this.m = new HandlerThread("GeoCode");
      this.m.start();
      this.n = new Handler(this.m.getLooper());
      findViewById(2131755769).setOnClickListener(new at()
      {
        public final void a(View paramAnonymousView)
        {
          d.d(LocationPicker.this);
        }
      });
      return;
      this.b.runOnFirstFix(al.a(this));
      break;
      this.a.getOverlays().add(this.c);
      this.a.getOverlays().add(this.b);
      break label409;
    }
  }
  
  public Dialog onCreateDialog(int paramInt)
  {
    Dialog localDialog = this.f.a(paramInt);
    if (localDialog != null) {
      return localDialog;
    }
    return super.onCreateDialog(paramInt);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    o.a(paramMenu.add(0, 0, 0, 2131297631).setIcon(2130840073), 2);
    o.a(paramMenu.add(0, 1, 0, 2131297518).setIcon(2130840070), 1);
    return true;
  }
  
  public void onDestroy()
  {
    this.f.k();
    this.m.quit();
    super.onDestroy();
    a().h();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    this.f.a(paramIntent);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    return (this.f.a(paramMenuItem)) || (super.onOptionsItemSelected(paramMenuItem));
  }
  
  protected void onPause()
  {
    super.onPause();
    this.b.disableMyLocation();
    this.d.disableMyLocation();
  }
  
  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    a().c();
  }
  
  protected void onPostResume()
  {
    super.onPostResume();
    a().f();
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    if (this.f.j)
    {
      paramMenu.findItem(0).setVisible(false);
      paramMenu.findItem(1).setVisible(false);
    }
    return true;
  }
  
  protected void onResume()
  {
    super.onResume();
    this.b.enableMyLocation();
    this.d.enableMyLocation();
    this.f.i();
    invalidateOptionsMenu();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    GeoPoint localGeoPoint = this.a.getMapCenter();
    paramBundle.putInt("lat", localGeoPoint.getLatitudeE6());
    paramBundle.putInt("lon", localGeoPoint.getLongitudeE6());
    paramBundle.putInt("zoom", this.a.getZoomLevel());
    this.f.a(paramBundle);
  }
  
  public boolean onSearchRequested()
  {
    this.i.a();
    return false;
  }
  
  protected void onStop()
  {
    super.onStop();
    a().e();
  }
  
  protected void onTitleChanged(CharSequence paramCharSequence, int paramInt)
  {
    super.onTitleChanged(paramCharSequence, paramInt);
    a().a(paramCharSequence);
  }
  
  public void setContentView(int paramInt)
  {
    a().b(paramInt);
  }
  
  public void setContentView(View paramView)
  {
    a().a(paramView);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    a().a(paramView, paramLayoutParams);
  }
  
  final class a
    extends ItemizedOverlay<OverlayItem>
  {
    a()
    {
      super();
      setOnFocusChangeListener(ap.a(this));
    }
    
    public final void a()
    {
      setLastFocusedIndex(-1);
      populate();
    }
    
    protected final OverlayItem createItem(int paramInt)
    {
      Object localObject = LocationPicker.g(LocationPicker.this).n.b(paramInt);
      localObject = new OverlayItem(new GeoPoint((int)(((PlaceInfo)localObject).lat * 1000000.0D), (int)(((PlaceInfo)localObject).lon * 1000000.0D)), "", "");
      ((OverlayItem)localObject).setMarker(boundCenter(u.a().getResources().getDrawable(2130840502)));
      return (OverlayItem)localObject;
    }
    
    public final void draw(Canvas paramCanvas, MapView paramMapView, boolean paramBoolean)
    {
      if (paramBoolean) {
        return;
      }
      super.draw(paramCanvas, paramMapView, false);
    }
    
    protected final boolean onTap(int paramInt)
    {
      ba localba = LocationPicker.g(LocationPicker.this);
      localba.o = localba.n.b(paramInt);
      localba.n();
      return true;
    }
    
    public final int size()
    {
      if (LocationPicker.g(LocationPicker.this).n == null) {
        return 0;
      }
      return LocationPicker.g(LocationPicker.this).n.c.size();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/location/LocationPicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */