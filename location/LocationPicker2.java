package com.whatsapp.location;

import a.a.a.a.a.a.d;
import a.a.a.a.d;
import android.animation.LayoutTransition;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v4.view.o;
import android.support.v7.widget.SearchView.b;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.b.a;
import com.google.android.gms.common.api.b.c;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.c;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.e;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CameraPosition.a;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.whatsapp.PlaceInfo;
import com.whatsapp.abn;
import com.whatsapp.ahp;
import com.whatsapp.aic;
import com.whatsapp.al;
import com.whatsapp.and;
import com.whatsapp.aoa;
import com.whatsapp.aoj;
import com.whatsapp.atu;
import com.whatsapp.atv;
import com.whatsapp.aus;
import com.whatsapp.data.l;
import com.whatsapp.nh;
import com.whatsapp.pv;
import com.whatsapp.util.Log;
import com.whatsapp.util.bm;
import com.whatsapp.va;
import java.util.Iterator;
import java.util.List;

public class LocationPicker2
  extends nh
  implements com.google.android.gms.common.api.b.b, b.c, com.google.android.gms.location.f
{
  private static final LocationRequest G = LocationRequest.a().a(5000L).b(16L).a(100);
  final atu A = atu.a();
  final ba B = new ba(this.P, this.O, this.Q, this.R, this.S, this.T, this.U, this.A, this.V)
  {
    public final void a()
    {
      LocationPicker2.a(LocationPicker2.this);
    }
    
    protected final void a(boolean paramAnonymousBoolean)
    {
      View localView = LocationPicker2.this.findViewById(2131755891);
      if (paramAnonymousBoolean)
      {
        if (localView != null) {
          localView.setVisibility(8);
        }
        return;
      }
      if (LocationPicker2.e(LocationPicker2.this))
      {
        if (localView != null) {
          localView.setVisibility(0);
        }
        ((View)a.d.a(LocationPicker2.this.findViewById(2131755890))).setVisibility(8);
        return;
      }
      if (localView != null) {
        localView.setVisibility(8);
      }
      ((View)a.d.a(LocationPicker2.this.findViewById(2131755890))).setVisibility(0);
    }
    
    public final void a(boolean paramAnonymousBoolean, LatLngBounds paramAnonymousLatLngBounds)
    {
      a.d.a(LocationPicker2.b(LocationPicker2.this));
      if (paramAnonymousBoolean)
      {
        LocationPicker2.b(LocationPicker2.this).b(d.a(paramAnonymousLatLngBounds.a(), 15.0F));
        return;
      }
      LocationPicker2.b(LocationPicker2.this).b(d.a(paramAnonymousLatLngBounds, (int)(aoa.a().a * 16.0F)));
    }
    
    protected final Location b()
    {
      return null;
    }
    
    protected final Location c()
    {
      return LocationPicker2.c(LocationPicker2.this);
    }
    
    protected final int d()
    {
      return LocationPicker2.d(LocationPicker2.this);
    }
    
    protected final void e()
    {
      if (LocationPicker2.e(LocationPicker2.this)) {
        LocationPicker2.f(LocationPicker2.this).setVisibility(0);
      }
      for (;;)
      {
        if (LocationPicker2.b(LocationPicker2.this) != null) {
          LocationPicker2.b(LocationPicker2.this).c();
        }
        this.o = null;
        return;
        LocationPicker2.g(LocationPicker2.this).setVisibility(0);
      }
    }
    
    protected final void f()
    {
      LocationPicker2.g(LocationPicker2.this).setVisibility(8);
      LocationPicker2.f(LocationPicker2.this).setVisibility(8);
    }
    
    protected final void g()
    {
      if (LocationPicker2.b(LocationPicker2.this) == null) {
        return;
      }
      Object localObject;
      if (this.j)
      {
        LocationPicker2.h(LocationPicker2.this);
        LocationPicker2.i(LocationPicker2.this);
        LocationPicker2.j(LocationPicker2.this).setVisibility(8);
        LocationPicker2.k(LocationPicker2.this).setVisibility(8);
        LocationPicker2.l(LocationPicker2.this).setVisibility(8);
        LocationPicker2.b(LocationPicker2.this).c();
        if (this.l != null)
        {
          localObject = new LatLng(this.l.getLatitude(), this.l.getLongitude());
          LocationPicker2.a(LocationPicker2.this, (LatLng)localObject);
          LocationPicker2.b(LocationPicker2.this).b(false);
          localObject = CameraPosition.a().a((LatLng)localObject).a(15.0F).b(0.0F).c(0.0F).a();
          LocationPicker2.b(LocationPicker2.this).b(d.a((CameraPosition)localObject));
        }
        LocationPicker2.m(LocationPicker2.this).setVisibility(8);
      }
      for (;;)
      {
        LocationPicker2.this.invalidateOptionsMenu();
        return;
        if (LocationPicker2.n(LocationPicker2.this).c()) {
          LocationPicker2.b(LocationPicker2.this).b(true);
        }
        LocationPicker2.o(LocationPicker2.this);
        LocationPicker2.a(LocationPicker2.this);
        LocationPicker2.j(LocationPicker2.this).setVisibility(0);
        LocationPicker2.p(LocationPicker2.this).setLocationMode(2);
        if (!LocationPicker2.e(LocationPicker2.this)) {
          break;
        }
        LocationPicker2.j(LocationPicker2.this).setImageResource(2130837691);
        LocationPicker2.j(LocationPicker2.this).setContentDescription(LocationPicker2.this.getResources().getString(2131297854));
        if (LocationPicker2.q(LocationPicker2.this).r)
        {
          localObject = (ImageView)this.i.findViewById(2131755905);
          if (localObject != null) {
            ((ImageView)localObject).setImageResource(2130840142);
          }
        }
        if ((LocationPicker2.b(LocationPicker2.this) != null) && (LocationPicker2.q(LocationPicker2.this).o != null) && (LocationPicker2.q(LocationPicker2.this).o.tag != null))
        {
          localObject = (com.google.android.gms.maps.model.b)LocationPicker2.q(LocationPicker2.this).o.tag;
          ((com.google.android.gms.maps.model.b)localObject).a(LocationPicker2.r(LocationPicker2.this));
          ((com.google.android.gms.maps.model.b)localObject).d();
        }
        if ((LocationPicker2.this.getResources().getConfiguration().orientation == 1) && (LocationPicker2.q(LocationPicker2.this).r))
        {
          LocationPicker2.k(LocationPicker2.this).setVisibility(0);
          this.i.setAdapter(null);
          this.i.setOnScrollListener(null);
          localObject = new LinearLayout.LayoutParams(-1, this.i.findViewById(2131755871).getHeight() + this.i.findViewById(2131755904).getHeight());
          LocationPicker2.k(LocationPicker2.this).setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        for (;;)
        {
          if ((this.o != null) && (this.o.tag != null)) {
            break label546;
          }
          LocationPicker2.l(LocationPicker2.this).setVisibility(0);
          break;
          LocationPicker2.k(LocationPicker2.this).setVisibility(8);
        }
        label546:
        LocationPicker2.l(LocationPicker2.this).setVisibility(8);
      }
      if (LocationPicker2.q(LocationPicker2.this).r)
      {
        localObject = (ImageView)this.i.findViewById(2131755905);
        if (localObject != null) {
          ((ImageView)localObject).setImageResource(2130837711);
        }
      }
      LocationPicker2.j(LocationPicker2.this).setImageResource(2130837694);
      LocationPicker2.j(LocationPicker2.this).setContentDescription(LocationPicker2.this.getResources().getString(2131297024));
      if ((LocationPicker2.b(LocationPicker2.this) != null) && (LocationPicker2.q(LocationPicker2.this).o != null) && (LocationPicker2.q(LocationPicker2.this).o.tag != null))
      {
        localObject = (com.google.android.gms.maps.model.b)LocationPicker2.q(LocationPicker2.this).o.tag;
        ((com.google.android.gms.maps.model.b)localObject).a(LocationPicker2.r(LocationPicker2.this));
        ((com.google.android.gms.maps.model.b)localObject).e();
      }
      if (LocationPicker2.n(LocationPicker2.this).c()) {
        LocationPicker2.k(LocationPicker2.this).setVisibility(0);
      }
      for (;;)
      {
        if ((LocationPicker2.this.getResources().getConfiguration().orientation == 1) && (LocationPicker2.q(LocationPicker2.this).r))
        {
          localObject = new LinearLayout.LayoutParams(-1, 0);
          ((LinearLayout.LayoutParams)localObject).weight = 0.5F;
          LocationPicker2.k(LocationPicker2.this).setLayoutParams((ViewGroup.LayoutParams)localObject);
          this.i.setAdapter(this.p);
          this.i.setOnScrollListener(this.h);
          n();
        }
        LocationPicker2.l(LocationPicker2.this).setVisibility(8);
        LocationPicker2.m(LocationPicker2.this).setVisibility(8);
        break;
        LocationPicker2.k(LocationPicker2.this).setVisibility(8);
      }
    }
    
    protected final boolean h()
    {
      return LocationPicker2.e(LocationPicker2.this);
    }
  };
  private View C;
  private ProgressBar D;
  private ProgressBar E;
  private com.google.android.gms.common.api.b F;
  private com.google.android.gms.maps.f H = new aq(this);
  private ImageView I;
  private HandlerThread J;
  private boolean K = true;
  private ahp L;
  private com.google.android.gms.maps.model.a M;
  private boolean N;
  private final va O = va.a();
  private final pv P = pv.a();
  private final aoj Q = aoj.a();
  private final com.whatsapp.emoji.h R = com.whatsapp.emoji.h.a();
  private final aus S = aus.a();
  private final and T = and.a();
  private final l U = l.a();
  private final atv V = atv.a();
  private Bundle W;
  ImageView n;
  b o;
  com.google.android.gms.maps.b p;
  View q;
  View r;
  View s;
  View t;
  ba.b u;
  Handler v;
  boolean w = false;
  com.google.android.gms.maps.model.a x;
  com.google.android.gms.maps.model.a y;
  boolean z;
  
  private void a(LatLng paramLatLng)
  {
    a.d.a(this.p);
    paramLatLng = new MarkerOptions().a(paramLatLng);
    paramLatLng.a(this.M);
    this.p.a(paramLatLng);
  }
  
  @TargetApi(16)
  private void l()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      ((LinearLayout)findViewById(2131755873)).getLayoutTransition().enableTransitionType(4);
    }
  }
  
  private void m()
  {
    if (this.p == null) {
      this.p = this.o.b(this.H);
    }
  }
  
  private Location n()
  {
    a.d.a(this.p);
    LatLng localLatLng = this.p.a().b;
    Location localLocation = new Location("");
    localLocation.setLatitude(localLatLng.b);
    localLocation.setLongitude(localLatLng.c);
    return localLocation;
  }
  
  private void o()
  {
    a.d.a(this.p);
    this.p.c();
    if ((!this.B.j) && (this.B.n != null))
    {
      Iterator localIterator = this.B.n.c.iterator();
      while (localIterator.hasNext())
      {
        PlaceInfo localPlaceInfo = (PlaceInfo)localIterator.next();
        Object localObject = new MarkerOptions().a(new LatLng(localPlaceInfo.lat, localPlaceInfo.lon));
        if (!TextUtils.isEmpty(localPlaceInfo.name)) {
          ((MarkerOptions)localObject).a(localPlaceInfo.name);
        }
        if (!TextUtils.isEmpty(localPlaceInfo.vicinity)) {
          ((MarkerOptions)localObject).b(localPlaceInfo.vicinity);
        }
        ((MarkerOptions)localObject).a(this.x);
        ((MarkerOptions)localObject).a();
        localObject = this.p.a((MarkerOptions)localObject);
        ((com.google.android.gms.maps.model.b)localObject).a(localPlaceInfo);
        localPlaceInfo.tag = localObject;
      }
    }
  }
  
  public final void a(Location paramLocation)
  {
    if ((this.B.l == null) && (this.p != null))
    {
      this.o.setLocationMode(1);
      this.p.a(d.a(new LatLng(paramLocation.getLatitude(), paramLocation.getLongitude())));
    }
    if ((this.B.j) && (this.p != null))
    {
      this.p.c();
      a(new LatLng(paramLocation.getLatitude(), paramLocation.getLongitude()));
    }
    if (this.w)
    {
      LatLng localLatLng = new LatLng(paramLocation.getLatitude(), paramLocation.getLongitude());
      this.p.b(d.a(localLatLng));
    }
    this.B.a(paramLocation);
  }
  
  public final void a(Bundle paramBundle)
  {
    if (this.A.a("android.permission.ACCESS_FINE_LOCATION") != 0) {
      Log.i("location/picker/on/connected/permission_denied");
    }
    do
    {
      Object localObject;
      do
      {
        return;
        com.google.android.gms.location.h.b.a(this.F, G, this);
        paramBundle = this.B;
        localObject = com.google.android.gms.location.h.b;
        paramBundle.l = c.a(this.F);
      } while ((this.p == null) || (this.B.l == null));
      paramBundle = new LatLng(this.B.l.getLatitude(), this.B.l.getLongitude());
      if ((this.K) && (this.B.r))
      {
        this.K = false;
        localObject = CameraPosition.a().a(paramBundle).a(15.0F).b(0.0F).c(0.0F).a();
        this.p.b(d.a((CameraPosition)localObject));
      }
    } while (!this.B.j);
    this.p.b(false);
    this.p.c();
    a(paramBundle);
  }
  
  public final void a(ConnectionResult paramConnectionResult) {}
  
  public final void c_(int paramInt) {}
  
  public void onBackPressed()
  {
    if (this.L.c()) {
      this.L.b();
    }
    while (this.B.l()) {
      return;
    }
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Log.i("locationpicker/create");
    setContentView(al.a(this.P, getLayoutInflater(), 2130903274, null, false));
    Object localObject = (Toolbar)findViewById(2131755412);
    a((Toolbar)localObject);
    this.L = new ahp(this, this.P, findViewById(2131755496), (Toolbar)localObject, new SearchView.b()
    {
      public final boolean a(String paramAnonymousString)
      {
        LocationPicker2.q(LocationPicker2.this).a(paramAnonymousString);
        return false;
      }
      
      public final boolean b(String paramAnonymousString)
      {
        return false;
      }
    });
    localObject = i();
    ((android.support.v7.app.a)localObject).a(true);
    ((android.support.v7.app.a)localObject).a(2131297660);
    this.F = new b.a(this).a(com.google.android.gms.location.h.a).a(this).a(this).b();
    this.C = findViewById(2131755887);
    this.q = findViewById(2131755875);
    this.r = findViewById(2131755879);
    if (paramBundle != null)
    {
      this.K = paramBundle.getBoolean("zoom_to_user", false);
      this.z = paramBundle.getBoolean("fullscreen", false);
    }
    this.B.a(this, paramBundle);
    l();
    this.r.setOnClickListener(as.a(this));
    this.s = findViewById(2131755880);
    this.t = ((View)a.d.a(findViewById(2131755877)));
    this.t.setOnClickListener(at.a(this));
    e.a(this);
    Bitmap localBitmap;
    if (aic.u)
    {
      localBitmap = BitmapFactory.decodeResource(getResources(), 2130840447);
      localObject = BitmapFactory.decodeResource(getResources(), 2130840449);
      this.x = d.a(localBitmap);
      this.y = d.a((Bitmap)localObject);
      this.M = d.a(this.B.k);
      localObject = new GoogleMapOptions();
      ((GoogleMapOptions)localObject).a().e().b().b(true).a(false).d(true).c(true);
      this.o = new b(this, (GoogleMapOptions)localObject)
      {
        public final void a(int paramAnonymousInt)
        {
          switch (paramAnonymousInt)
          {
          default: 
            return;
          case 0: 
            LocationPicker2.s(LocationPicker2.this).setImageResource(2130837660);
            LocationPicker2.a(LocationPicker2.this, true);
            return;
          case 1: 
            LocationPicker2.s(LocationPicker2.this).setImageResource(2130837704);
            LocationPicker2.a(LocationPicker2.this, true);
            return;
          }
          LocationPicker2.s(LocationPicker2.this).setImageResource(2130837703);
          LocationPicker2.a(LocationPicker2.this, false);
        }
      };
      ((ViewGroup)a.d.a((ViewGroup)findViewById(2131755628))).addView(this.o);
      this.o.a(paramBundle);
      this.W = paramBundle;
      m();
      this.D = ((ProgressBar)a.d.a((ProgressBar)findViewById(2131755667)));
      paramBundle = this.D;
      if (this.B.n != null) {
        break label630;
      }
    }
    label630:
    for (int i = 0;; i = 8)
    {
      paramBundle.setVisibility(i);
      this.E = ((ProgressBar)findViewById(2131755881));
      this.I = ((ImageView)a.d.a((ImageView)findViewById(2131755882)));
      this.I.setOnClickListener(au.a(this));
      this.n = ((ImageView)a.d.a((ImageView)findViewById(2131755820)));
      this.n.setOnClickListener(av.a(this));
      this.J = new HandlerThread("GeoCode");
      this.J.start();
      this.v = new Handler(this.J.getLooper());
      paramBundle = new com.whatsapp.util.at()
      {
        public final void a(View paramAnonymousView)
        {
          d.d(LocationPicker2.this);
        }
      };
      ((View)a.d.a(findViewById(2131755769))).setOnClickListener(paramBundle);
      localObject = findViewById(2131755892);
      if (localObject != null) {
        ((View)localObject).setOnClickListener(paramBundle);
      }
      return;
      localBitmap = BitmapFactory.decodeResource(getResources(), 2130840337);
      localObject = BitmapFactory.decodeResource(getResources(), 2130840339);
      break;
    }
  }
  
  public Dialog onCreateDialog(int paramInt)
  {
    Dialog localDialog = this.B.a(paramInt);
    if (localDialog != null) {
      return localDialog;
    }
    return super.onCreateDialog(paramInt);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    o.a(paramMenu.add(0, 0, 0, 2131297631).setIcon(2130840073), 2);
    o.a(paramMenu.add(0, 1, 0, 2131297518).setIcon(2130840070), 1);
    if (com.whatsapp.av.j()) {
      bm.b(this);
    }
    return true;
  }
  
  protected void onDestroy()
  {
    this.o.c();
    this.B.k();
    if (this.p != null)
    {
      SharedPreferences.Editor localEditor = getSharedPreferences("com.whatsapp_preferences", 0).edit();
      CameraPosition localCameraPosition = this.p.a();
      localEditor.putFloat("share_location_lat", (float)localCameraPosition.b.b);
      localEditor.putFloat("share_location_lon", (float)localCameraPosition.b.c);
      localEditor.putFloat("share_location_zoom", localCameraPosition.c);
      localEditor.apply();
    }
    this.J.quit();
    super.onDestroy();
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    this.o.d();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    this.B.a(paramIntent);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    return (this.B.a(paramMenuItem)) || (super.onOptionsItemSelected(paramMenuItem));
  }
  
  protected void onPause()
  {
    this.o.b();
    this.o.g();
    if ((this.F != null) && (this.F.i()))
    {
      com.google.android.gms.location.h.b.a(this.F, this);
      this.F.g();
    }
    this.N = this.A.c();
    super.onPause();
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    if (this.B.j)
    {
      paramMenu.findItem(0).setVisible(false);
      paramMenu.findItem(1).setVisible(false);
    }
    while (this.A.c()) {
      return true;
    }
    paramMenu.findItem(0).setVisible(false);
    return true;
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.A.c() != this.N)
    {
      invalidateOptionsMenu();
      if ((this.A.c()) && (this.p != null) && (!this.B.j)) {
        this.p.b(true);
      }
    }
    this.o.a();
    this.o.f();
    m();
    this.F.e();
    this.B.i();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (this.p != null)
    {
      CameraPosition localCameraPosition = this.p.a();
      paramBundle.putFloat("camera_zoom", localCameraPosition.c);
      paramBundle.putDouble("camera_lat", localCameraPosition.b.b);
      paramBundle.putDouble("camera_lng", localCameraPosition.b.c);
      paramBundle.putInt("map_location_mode", this.o.getLocationMode());
    }
    paramBundle.putBoolean("fullscreen", this.z);
    paramBundle.putBoolean("zoom_to_user", this.K);
    this.o.b(paramBundle);
    this.B.a(paramBundle);
    super.onSaveInstanceState(paramBundle);
  }
  
  public boolean onSearchRequested()
  {
    this.L.a();
    return false;
  }
  
  final class a
    implements com.google.android.gms.maps.b.b
  {
    private final View b = al.a(LocationPicker2.t(LocationPicker2.this), LocationPicker2.this.getLayoutInflater(), 2130903333, null, false);
    
    a() {}
    
    public final View a(com.google.android.gms.maps.model.b paramb)
    {
      TextView localTextView1 = (TextView)this.b.findViewById(2131755632);
      TextView localTextView2 = (TextView)this.b.findViewById(2131755633);
      if ((paramb.i() instanceof PlaceInfo))
      {
        paramb = (PlaceInfo)paramb.i();
        localTextView1.setText(paramb.name);
        localTextView2.setText(paramb.vicinity);
      }
      return this.b;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/location/LocationPicker2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */