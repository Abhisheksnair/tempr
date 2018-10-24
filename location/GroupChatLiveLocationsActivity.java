package com.whatsapp.location;

import a.a.a.a.d;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.view.o;
import android.support.v7.app.b.a;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.LatLngBounds.a;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MapView.LayoutParams;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.OverlayItem;
import com.google.android.maps.Projection;
import com.whatsapp.ContactLiveLocationThumbnail;
import com.whatsapp.QuickContactActivity;
import com.whatsapp.TextEmojiLabel;
import com.whatsapp.al;
import com.whatsapp.ant;
import com.whatsapp.atu;
import com.whatsapp.aus;
import com.whatsapp.av;
import com.whatsapp.br;
import com.whatsapp.data.cs;
import com.whatsapp.di;
import com.whatsapp.emoji.c;
import com.whatsapp.messaging.w;
import com.whatsapp.protocol.ap;
import com.whatsapp.pv;
import com.whatsapp.rf;
import com.whatsapp.rh;
import com.whatsapp.u;
import com.whatsapp.util.Log;
import com.whatsapp.util.at;
import com.whatsapp.util.bm;
import com.whatsapp.va;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class GroupChatLiveLocationsActivity
  extends MapActivity
  implements GoogleMapView.a
{
  MyLocationOverlay a;
  GoogleMapView b;
  ap c;
  final bp d = bp.a();
  final v e = new v(this.j, this.k, this.l, this.m, this.n, this.o, this.q, this.s, this.d)
  {
    boolean a;
    
    protected final void a()
    {
      k();
    }
    
    final void a(float paramAnonymousFloat, boolean paramAnonymousBoolean)
    {
      if (GroupChatLiveLocationsActivity.c(GroupChatLiveLocationsActivity.this).d.getLayoutParams().height != (int)paramAnonymousFloat) {
        GroupChatLiveLocationsActivity.c(GroupChatLiveLocationsActivity.this).d.setLayoutParams(new LinearLayout.LayoutParams(-1, (int)paramAnonymousFloat));
      }
    }
    
    public final void a(ap paramAnonymousap)
    {
      GroupChatLiveLocationsActivity.a(GroupChatLiveLocationsActivity.this, paramAnonymousap);
      paramAnonymousap = new GeoPoint((int)(paramAnonymousap.b * 1000000.0D), (int)(paramAnonymousap.c * 1000000.0D));
      GroupChatLiveLocationsActivity.f(GroupChatLiveLocationsActivity.this).getController().animateTo(paramAnonymousap);
      if (GroupChatLiveLocationsActivity.f(GroupChatLiveLocationsActivity.this).getZoomLevel() < 17) {
        GroupChatLiveLocationsActivity.f(GroupChatLiveLocationsActivity.this).getController().setZoom(17);
      }
      GroupChatLiveLocationsActivity.b(GroupChatLiveLocationsActivity.this);
    }
    
    public final Location b()
    {
      if (GroupChatLiveLocationsActivity.a(GroupChatLiveLocationsActivity.this) != null)
      {
        GeoPoint localGeoPoint = GroupChatLiveLocationsActivity.a(GroupChatLiveLocationsActivity.this).getMyLocation();
        if (localGeoPoint != null)
        {
          Location localLocation = new Location("");
          localLocation.setLatitude(localGeoPoint.getLatitudeE6() / 1000000.0D);
          localLocation.setLongitude(localGeoPoint.getLongitudeE6() / 1000000.0D);
          return localLocation;
        }
      }
      return null;
    }
    
    public final void c()
    {
      GroupChatLiveLocationsActivity.b(GroupChatLiveLocationsActivity.this);
      if ((!this.a) && (!GroupChatLiveLocationsActivity.c(GroupChatLiveLocationsActivity.this).j().isEmpty()))
      {
        this.a = true;
        GroupChatLiveLocationsActivity.d(GroupChatLiveLocationsActivity.this);
      }
      if (GroupChatLiveLocationsActivity.e(GroupChatLiveLocationsActivity.this) != null)
      {
        GeoPoint localGeoPoint = new GeoPoint((int)(GroupChatLiveLocationsActivity.e(GroupChatLiveLocationsActivity.this).b * 1000000.0D), (int)(GroupChatLiveLocationsActivity.e(GroupChatLiveLocationsActivity.this).c * 1000000.0D));
        GroupChatLiveLocationsActivity.f(GroupChatLiveLocationsActivity.this).getController().animateTo(localGeoPoint);
      }
    }
  };
  private a f;
  private Toolbar g;
  private List<v.c> h = new ArrayList();
  private int i = -1;
  private final ant j = ant.a();
  private final pv k = pv.a();
  private final va l = va.a();
  private final w m = w.a();
  private final br n = br.a();
  private final di o = di.a();
  private final cc p = cc.a();
  private final com.whatsapp.data.e q = com.whatsapp.data.e.a();
  private final aus r = aus.a();
  private final atu s = atu.a();
  private final rh t = rh.a();
  private boolean u = false;
  
  private void a()
  {
    int i1 = this.b.getWidth();
    int i2 = this.b.getHeight();
    if ((i1 == 0) || (i2 == 0)) {
      return;
    }
    Math.min(i1, i2);
    Math.pow(2.0D, this.b.getZoomLevel());
    new HashMap();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.e.j().iterator();
    while (localIterator.hasNext())
    {
      ap localap = (ap)localIterator.next();
      if (localap.g != 0L)
      {
        GeoPoint localGeoPoint = new GeoPoint((int)(localap.b * 1000000.0D), (int)(localap.c * 1000000.0D));
        Point localPoint = new Point();
        this.b.getProjection().toPixels(localGeoPoint, localPoint);
        localArrayList.add(android.support.v4.f.h.a(localap, localPoint));
      }
    }
    this.h = new ArrayList(this.e.a(localArrayList));
    Collections.sort(this.h, j.a());
    this.f.a();
  }
  
  public final void a(GeoPoint paramGeoPoint)
  {
    int i1 = 2;
    int i2 = this.b.getZoomLevel();
    if (i2 <= 1) {
      this.b.getController().setZoom(2);
    }
    for (;;)
    {
      if (this.i != i1)
      {
        this.i = i1;
        a();
      }
      if (this.u)
      {
        this.e.d();
        this.u = false;
      }
      return;
      i1 = i2;
    }
  }
  
  public void invalidateOptionsMenu()
  {
    super.invalidateOptionsMenu();
    if (this.g.getMenu() != null) {
      onCreateOptionsMenu(this.g.getMenu());
    }
  }
  
  protected boolean isRouteDisplayed()
  {
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.b.requestLayout();
    if (!this.e.a(paramInt1, paramInt2)) {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.r.e();
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    this.e.a(paramMenuItem);
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Log.i("grouplocations/create");
    al.a(getWindow());
    this.r.e();
    super.onCreate(paramBundle);
    d.a(this, this.k, 2130903251);
    cs localcs = this.q.a(getIntent().getStringExtra("jid"));
    this.e.a(this, paramBundle);
    this.g = ((Toolbar)findViewById(2131755412));
    this.g.setTitle(c.a(localcs.a(this), this));
    onCreateOptionsMenu(this.g.getMenu());
    this.g.setOnMenuItemClickListener$486aeec7(new f(this));
    this.b = new GoogleMapView(this)
    {
      public final boolean dispatchTouchEvent(MotionEvent paramAnonymousMotionEvent)
      {
        GroupChatLiveLocationsActivity.a(GroupChatLiveLocationsActivity.this, null);
        GroupChatLiveLocationsActivity.g(GroupChatLiveLocationsActivity.this);
        return super.dispatchTouchEvent(paramAnonymousMotionEvent);
      }
    };
    this.b.setClickable(true);
    this.b.setEnabled(true);
    this.b.setMapListener(this);
    this.b.setBuiltInZoomControls(false);
    this.b.getController().setZoom(17);
    ((ViewGroup)findViewById(2131755628)).addView(this.b);
    this.a = new e(this, this.b);
    this.b.getOverlays().add(this.a);
    this.f = new a((byte)0);
    this.f.a();
    this.b.getOverlays().add(this.f);
    this.b.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
    {
      public final boolean onPreDraw()
      {
        GroupChatLiveLocationsActivity.f(GroupChatLiveLocationsActivity.this).getViewTreeObserver().removeOnPreDrawListener(this);
        GroupChatLiveLocationsActivity.b(GroupChatLiveLocationsActivity.this);
        return true;
      }
    });
    findViewById(2131755820).setOnClickListener(g.a(this));
    android.support.v4.app.a.a(this);
  }
  
  public Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    }
    android.support.v7.app.b localb = new b.a(this).b(2131297111).a(true).b(2131296398, null).a(2131297109, h.a(this)).a();
    localb.requestWindowFeature(1);
    return localb;
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    paramMenu.clear();
    if ((this.e.h != null) && (!this.d.f(this.e.h)))
    {
      o.a(paramMenu.add(2131756284, 1, 0, 2131297106), 0);
      o.a(paramMenu.add(2131756286, 0, 0, 2131297132), 0);
    }
    for (;;)
    {
      if (av.j()) {
        bm.b(this);
      }
      return true;
      o.a(paramMenu.add(0, 0, 0, 2131297132).setIcon(2130837718), 2);
    }
  }
  
  public void onDestroy()
  {
    Log.i("grouplocations/destroy");
    super.onDestroy();
    this.e.e();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    case 1: 
      this.p.a(this, this.e.h);
      return true;
    case 0: 
      paramMenuItem = this.b;
      if (!this.b.isSatellite()) {}
      for (boolean bool = true;; bool = false)
      {
        paramMenuItem.setSatellite(bool);
        return true;
      }
    }
    finish();
    return true;
  }
  
  protected void onPause()
  {
    super.onPause();
    this.a.disableMyLocation();
    this.e.f();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.a.enableMyLocation();
    this.e.g();
  }
  
  final class a
    extends ItemizedOverlay<OverlayItem>
  {
    private final FrameLayout b = new FrameLayout(u.a());
    private final TextEmojiLabel c;
    private final TextView d;
    private final View e;
    private String f = null;
    
    private a()
    {
      super();
      this.b.setPadding(GroupChatLiveLocationsActivity.this.getResources().getDimensionPixelSize(2131362037), 0, GroupChatLiveLocationsActivity.this.getResources().getDimensionPixelSize(2131362037), GroupChatLiveLocationsActivity.c(GroupChatLiveLocationsActivity.this).k.getMeasuredHeight());
      View localView = al.a(GroupChatLiveLocationsActivity.h(GroupChatLiveLocationsActivity.this), GroupChatLiveLocationsActivity.this.getLayoutInflater(), 2130903267, null, false);
      localView.setOnClickListener(new at()
      {
        public final void a(View paramAnonymousView)
        {
          GroupChatLiveLocationsActivity.a.a(GroupChatLiveLocationsActivity.a.this);
        }
      });
      this.b.addView(localView);
      this.c = ((TextEmojiLabel)this.b.findViewById(2131755571));
      this.d = ((TextView)this.b.findViewById(2131755864));
      this.e = this.b.findViewById(2131755865);
      GroupChatLiveLocationsActivity.f(GroupChatLiveLocationsActivity.this).addView(this.b, new MapView.LayoutParams(-2, -2, new GeoPoint(0, 0), 81));
    }
    
    private void a(ap paramap, GeoPoint paramGeoPoint)
    {
      this.f = paramap.a;
      Object localObject1;
      Object localObject2;
      if (GroupChatLiveLocationsActivity.k(GroupChatLiveLocationsActivity.this).a(paramap.a))
      {
        this.c.setTextColor(-570425344);
        this.c.a(GroupChatLiveLocationsActivity.this.getString(2131297017));
        this.e.setVisibility(8);
        localObject1 = "";
        if (paramap.d != ap.h) {
          localObject1 = "" + String.format(u.a.a(2131230760, paramap.d), new Object[] { Integer.valueOf(paramap.d) });
        }
        localObject2 = localObject1;
        if (paramap.e > 0.5F)
        {
          localObject2 = localObject1;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = (String)localObject1 + ", ";
          }
          if (!Locale.US.equals(GroupChatLiveLocationsActivity.m(GroupChatLiveLocationsActivity.this).b())) {
            break label398;
          }
          localObject2 = (String)localObject2 + GroupChatLiveLocationsActivity.this.getString(2131297127, new Object[] { String.format("%1$,.1f", new Object[] { Float.valueOf(paramap.e * 2.23694F) }) });
        }
        label241:
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label461;
        }
        this.d.setText((CharSequence)localObject2);
        this.d.setVisibility(0);
      }
      for (;;)
      {
        this.b.setVisibility(0);
        this.b.setLayoutParams(new MapView.LayoutParams(-2, -2, paramGeoPoint, 81));
        return;
        localObject1 = GroupChatLiveLocationsActivity.l(GroupChatLiveLocationsActivity.this).a(GroupChatLiveLocationsActivity.c(GroupChatLiveLocationsActivity.this).h, paramap.a);
        if (localObject1 != null) {
          this.c.setTextColor(((rf)localObject1).e);
        }
        for (;;)
        {
          localObject1 = GroupChatLiveLocationsActivity.j(GroupChatLiveLocationsActivity.this).d(paramap.a);
          this.c.setContact((cs)localObject1);
          this.e.setVisibility(0);
          this.e.setOnClickListener(new at()
          {
            public final void a(View paramAnonymousView)
            {
              QuickContactActivity.a(GroupChatLiveLocationsActivity.this, GroupChatLiveLocationsActivity.a.b(GroupChatLiveLocationsActivity.a.this), GroupChatLiveLocationsActivity.a.c(GroupChatLiveLocationsActivity.a.this), null);
            }
          });
          break;
          this.c.setTextColor(-1728053248);
        }
        label398:
        localObject2 = (String)localObject2 + GroupChatLiveLocationsActivity.this.getString(2131297126, new Object[] { String.format("%1$,.1f", new Object[] { Float.valueOf(paramap.e * 3.6F) }) });
        break label241;
        label461:
        this.d.setVisibility(8);
      }
    }
    
    private void b()
    {
      this.f = null;
      this.b.setVisibility(8);
    }
    
    public final void a()
    {
      setLastFocusedIndex(-1);
      populate();
    }
    
    protected final OverlayItem createItem(int paramInt)
    {
      v.c localc = (v.c)GroupChatLiveLocationsActivity.i(GroupChatLiveLocationsActivity.this).get(paramInt);
      GeoPoint localGeoPoint = new GeoPoint((int)(localc.d.b * 1000000.0D), (int)(localc.d.c * 1000000.0D));
      OverlayItem localOverlayItem = new OverlayItem(localGeoPoint, "", "");
      cs localcs = GroupChatLiveLocationsActivity.j(GroupChatLiveLocationsActivity.this).d(localc.b.a);
      Bitmap localBitmap2 = localcs.a(GroupChatLiveLocationsActivity.this.getResources().getDimensionPixelSize(2131362090), GroupChatLiveLocationsActivity.this.getResources().getDimension(2131361833), true);
      Bitmap localBitmap1 = localBitmap2;
      if (localBitmap2 == null) {
        localBitmap1 = cs.b(localcs.e());
      }
      GroupChatLiveLocationsActivity.c(GroupChatLiveLocationsActivity.this).l.setImageBitmap(localBitmap1);
      if (localc.c)
      {
        GroupChatLiveLocationsActivity.c(GroupChatLiveLocationsActivity.this).l.setGlowColor(android.support.v4.content.b.c(u.a(), 2131624054));
        GroupChatLiveLocationsActivity.c(GroupChatLiveLocationsActivity.this).l.setStackSize(localc.a.size());
        localBitmap1 = Bitmap.createBitmap(GroupChatLiveLocationsActivity.c(GroupChatLiveLocationsActivity.this).k.getWidth(), GroupChatLiveLocationsActivity.c(GroupChatLiveLocationsActivity.this).k.getHeight(), Bitmap.Config.ARGB_8888);
        GroupChatLiveLocationsActivity.c(GroupChatLiveLocationsActivity.this).k.draw(new Canvas(localBitmap1));
        localOverlayItem.setMarker(boundCenterBottom(new BitmapDrawable(u.a().getResources(), localBitmap1)));
        if ((localc.a.size() != 1) || (!localc.b.a.equals(this.f))) {
          break label350;
        }
        a(localc.b, localGeoPoint);
      }
      label350:
      while (!localc.b.a.equals(this.f))
      {
        return localOverlayItem;
        GroupChatLiveLocationsActivity.c(GroupChatLiveLocationsActivity.this).l.setGlowColor(android.support.v4.content.b.c(u.a(), 2131624053));
        break;
      }
      b();
      return localOverlayItem;
    }
    
    public final void draw(Canvas paramCanvas, MapView paramMapView, boolean paramBoolean)
    {
      if (paramBoolean) {
        return;
      }
      super.draw(paramCanvas, paramMapView, paramBoolean);
    }
    
    protected final boolean onTap(int paramInt)
    {
      v.c localc = (v.c)GroupChatLiveLocationsActivity.i(GroupChatLiveLocationsActivity.this).get(paramInt);
      GeoPoint localGeoPoint = new GeoPoint((int)(localc.d.b * 1000000.0D), (int)(localc.d.c * 1000000.0D));
      if (localc.a.size() == 1)
      {
        GroupChatLiveLocationsActivity.f(GroupChatLiveLocationsActivity.this).getController().animateTo(localGeoPoint);
        GroupChatLiveLocationsActivity.a(GroupChatLiveLocationsActivity.this, localc.b);
        GroupChatLiveLocationsActivity.c(GroupChatLiveLocationsActivity.this).b(GroupChatLiveLocationsActivity.e(GroupChatLiveLocationsActivity.this));
        a(GroupChatLiveLocationsActivity.e(GroupChatLiveLocationsActivity.this), localGeoPoint);
      }
      for (;;)
      {
        GroupChatLiveLocationsActivity.b(GroupChatLiveLocationsActivity.this);
        return true;
        b();
        Object localObject = new LatLngBounds.a();
        Iterator localIterator = localc.a.iterator();
        while (localIterator.hasNext())
        {
          ap localap = (ap)localIterator.next();
          ((LatLngBounds.a)localObject).a(new LatLng(localap.b, localap.c));
        }
        localObject = ((LatLngBounds.a)localObject).a();
        float f1 = v.a((LatLngBounds)localObject, GroupChatLiveLocationsActivity.f(GroupChatLiveLocationsActivity.this).getWidth(), GroupChatLiveLocationsActivity.f(GroupChatLiveLocationsActivity.this).getHeight());
        if ((GroupChatLiveLocationsActivity.f(GroupChatLiveLocationsActivity.this).getZoomLevel() > 18) && (f1 > 21.0F))
        {
          Log.i("break up cluster " + f1);
          GroupChatLiveLocationsActivity.f(GroupChatLiveLocationsActivity.this).getController().animateTo(localGeoPoint);
          GroupChatLiveLocationsActivity.c(GroupChatLiveLocationsActivity.this).a(localc);
          return true;
        }
        paramInt = (int)((((LatLngBounds)localObject).c.b - ((LatLngBounds)localObject).b.b) * 1000000.0D * 1.2D);
        double d2 = ((LatLngBounds)localObject).c.c - ((LatLngBounds)localObject).b.c;
        double d1 = d2;
        if (d2 < 0.0D) {
          d1 = d2 + 360.0D;
        }
        int i = (int)(d1 * 1000000.0D * 1.2D);
        GroupChatLiveLocationsActivity.f(GroupChatLiveLocationsActivity.this).getController().animateTo(localGeoPoint);
        GroupChatLiveLocationsActivity.f(GroupChatLiveLocationsActivity.this).getController().zoomToSpan(paramInt, i);
      }
    }
    
    public final int size()
    {
      return GroupChatLiveLocationsActivity.i(GroupChatLiveLocationsActivity.this).size();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/location/GroupChatLiveLocationsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */