package com.whatsapp.location;

import a.a.a.a.d;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.o;
import android.support.v7.app.b;
import android.support.v7.app.b.a;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ZoomButtonsController;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MapView.LayoutParams;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.OverlayItem;
import com.google.android.maps.Projection;
import com.whatsapp.al;
import com.whatsapp.ant;
import com.whatsapp.aoa;
import com.whatsapp.aus;
import com.whatsapp.av;
import com.whatsapp.br;
import com.whatsapp.contact.sync.i;
import com.whatsapp.data.ac;
import com.whatsapp.data.cs;
import com.whatsapp.emoji.c;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.pv;
import com.whatsapp.u;
import com.whatsapp.util.Log;
import com.whatsapp.util.bm;
import com.whatsapp.util.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class GroupChatRecentLocationsActivity
  extends MapActivity
  implements GoogleMapView.a
{
  ArrayList<j> a = new ArrayList();
  MyLocationOverlay b;
  int c;
  GoogleMapView d;
  TextView e;
  cs f;
  final pv g = pv.a();
  final br h = br.a();
  final com.whatsapp.data.e i = com.whatsapp.data.e.a();
  private String j;
  private a k;
  private int l = -1;
  private View.OnLongClickListener m;
  private ArrayList<View> n = new ArrayList();
  private final ant o = ant.a();
  private final com.whatsapp.data.ad p = com.whatsapp.data.ad.a();
  private final aus q = aus.a();
  private final i r = i.a();
  private final ac s = ac.a();
  private final com.whatsapp.data.ab t = new com.whatsapp.data.ab()
  {
    public final void c(j paramAnonymousj, int paramAnonymousInt)
    {
      if ((paramAnonymousj != null) && (paramAnonymousj.e.a.equals(GroupChatRecentLocationsActivity.a(GroupChatRecentLocationsActivity.this))) && (!paramAnonymousj.e.b) && (paramAnonymousj.s == 5))
      {
        j localj = GroupChatRecentLocationsActivity.a(GroupChatRecentLocationsActivity.this, paramAnonymousj.f);
        if (localj != null) {
          GroupChatRecentLocationsActivity.b(GroupChatRecentLocationsActivity.this).remove(localj);
        }
        GroupChatRecentLocationsActivity.b(GroupChatRecentLocationsActivity.this).add(paramAnonymousj);
        GroupChatRecentLocationsActivity.c(GroupChatRecentLocationsActivity.this);
        GroupChatRecentLocationsActivity.d(GroupChatRecentLocationsActivity.this).a();
      }
    }
  };
  
  private void b()
  {
    Log.d("groupchatrecentlocations/update-balloons");
    Object localObject1 = this.n.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (View)((Iterator)localObject1).next();
      this.d.removeView((View)localObject2);
    }
    int i1 = Math.min(this.d.getWidth(), this.d.getHeight()) / 10;
    double d1 = Math.pow(2.0D, this.d.getZoomLevel()) * 256.0D / 2.0D;
    d1 = i1 * 360 / d1;
    double d2 = d1 / 2.0D;
    localObject1 = new HashMap();
    Object localObject2 = new Point();
    Object localObject3 = this.a.iterator();
    Object localObject4;
    Object localObject5;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (j)((Iterator)localObject3).next();
      double d3 = ((j)localObject4).C;
      double d4 = ((j)localObject4).B;
      localObject5 = new GeoPoint((int)(((j)localObject4).B * 1000000.0D), (int)(((j)localObject4).C * 1000000.0D));
      this.d.getProjection().toPixels((GeoPoint)localObject5, (Point)localObject2);
      localObject5 = (int)((d3 + 180.0D) / d1) + " " + (int)((90.0D + d4) / d2);
      if (!((HashMap)localObject1).containsKey(localObject5)) {
        ((HashMap)localObject1).put(localObject5, new ArrayList());
      }
      ((ArrayList)((HashMap)localObject1).get(localObject5)).add(localObject4);
    }
    localObject1 = new ArrayList(((HashMap)localObject1).values());
    Collections.sort((List)localObject1, aj.a());
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (ArrayList)((Iterator)localObject1).next();
      localObject2 = new LinearLayout(this);
      ((LinearLayout)localObject2).setOrientation(0);
      ((LinearLayout)localObject2).setPadding(0, 0, 0, (int)(7.0F * aoa.a().a));
      localObject4 = new LinearLayout(this);
      ((LinearLayout)localObject4).setOrientation(1);
      ((LinearLayout)localObject2).addView((View)localObject4);
      localObject5 = (LayoutInflater)getSystemService("layout_inflater");
      Object localObject6 = new cd();
      ((cd)localObject6).a = ((int)(12.0F * aoa.a().a));
      ((LinearLayout)localObject4).setBackgroundDrawable((Drawable)localObject6);
      localObject6 = ((ArrayList)localObject3).iterator();
      d2 = 0.0D;
      d1 = 0.0D;
      if (((Iterator)localObject6).hasNext())
      {
        j localj = (j)((Iterator)localObject6).next();
        View localView = al.a(this.g, (LayoutInflater)localObject5, 2130903117);
        localView.setClickable(true);
        localView.setBackgroundResource(2130840501);
        cs localcs = this.i.d(localj.f);
        ((TextView)localView.findViewById(2131755493)).setText(localcs.a(this));
        ((TextView)localView.findViewById(2131755494)).setText(l.a(this, this.o.a(localj)));
        ImageView localImageView = (ImageView)localView.findViewById(2131755327);
        Bitmap localBitmap = localcs.a(getResources().getDimensionPixelSize(2131362090), getResources().getDimension(2131361833), true);
        if (localBitmap != null) {
          localImageView.setImageBitmap(localBitmap);
        }
        for (;;)
        {
          localView.setTag(localj.f);
          ((LinearLayout)localObject4).addView(localView);
          localView.setOnLongClickListener(this.m);
          d2 += localj.B;
          d1 = localj.C + d1;
          break;
          localImageView.setImageResource(localcs.e());
        }
      }
      localObject3 = new GeoPoint((int)(d2 / ((ArrayList)localObject3).size() * 1000000.0D), (int)(d1 / ((ArrayList)localObject3).size() * 1000000.0D));
      this.d.addView((View)localObject2, new MapView.LayoutParams(-2, -2, (GeoPoint)localObject3, 81));
      this.n.add(localObject2);
    }
  }
  
  final j a(String paramString)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      if (paramString.equals(localj.f)) {
        return localj;
      }
    }
    return null;
  }
  
  final void a()
  {
    if ((this.c == -1) && (this.b.getMyLocation() == null)) {
      this.c = 0;
    }
    if (this.c == -1)
    {
      this.d.getController().animateTo(this.b.getMyLocation());
      this.d.getController().setZoom(17);
      this.e.setText(getString(2131297236));
    }
    while (this.c >= this.a.size()) {
      return;
    }
    Object localObject = (j)this.a.get(this.c);
    localObject = new GeoPoint((int)(((j)localObject).B * 1000000.0D), (int)(((j)localObject).C * 1000000.0D));
    this.d.getController().animateTo((GeoPoint)localObject);
    this.d.getController().setZoom(17);
    this.e.setText(getString(2131297119, new Object[] { Integer.valueOf(this.c + 1), Integer.valueOf(this.a.size()) }));
  }
  
  public final void a(GeoPoint paramGeoPoint)
  {
    if (this.l != this.d.getZoomLevel())
    {
      this.l = this.d.getZoomLevel();
      b();
    }
  }
  
  protected boolean isRouteDisplayed()
  {
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default: 
      return;
    }
    this.r.b();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.q.e();
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Log.i("groupchatrecentlocations/create");
    al.a(getWindow());
    this.q.e();
    super.onCreate(paramBundle);
    d.a(this, this.g, 2130903252);
    this.j = getIntent().getStringExtra("jid");
    paramBundle = this.i.a(this.j);
    Object localObject = (Toolbar)findViewById(2131755412);
    ((Toolbar)localObject).setTitle(c.a(paramBundle.a(this), this));
    onCreateOptionsMenu(((Toolbar)localObject).getMenu());
    ((Toolbar)localObject).setOnMenuItemClickListener$486aeec7(new ab(this));
    this.d = ((GoogleMapView)findViewById(2131755832));
    this.d.setMapListener(this);
    this.d.setBuiltInZoomControls(true);
    this.e = ((TextView)findViewById(2131755329));
    this.b = new e(this, this.d);
    this.d.getOverlays().add(this.b);
    this.a = this.p.v(this.j);
    Collections.sort(this.a, ad.a());
    this.m = ae.a(this);
    paramBundle = this.a.iterator();
    double d4 = 90.0D;
    double d3 = -90.0D;
    double d2 = 180.0D;
    for (double d1 = -180.0D; paramBundle.hasNext(); d1 = Math.max(d1, ((j)localObject).C))
    {
      localObject = (j)paramBundle.next();
      d4 = Math.min(d4, ((j)localObject).B);
      d3 = Math.max(d3, ((j)localObject).B);
      d2 = Math.min(d2, ((j)localObject).C);
    }
    paramBundle = new GeoPoint((int)((d4 + d3) * 1000000.0D / 2.0D), (int)((d2 + d1) * 1000000.0D / 2.0D));
    this.d.getController().setCenter(paramBundle);
    int i1 = (int)((d3 - d4) * 1.3D * 1000000.0D);
    int i2 = (int)((d1 - d2) * 1.3D * 1000000.0D);
    if (this.a.size() <= 1) {
      this.d.getController().setZoom(17);
    }
    for (;;)
    {
      b();
      this.c = (this.a.size() - 1);
      this.k = new a();
      this.k.a();
      this.d.getOverlays().add(this.k);
      findViewById(2131755834).setOnClickListener(af.a(this));
      findViewById(2131755357).setOnClickListener(ag.a(this));
      findViewById(2131755833).setOnClickListener(ah.a(this));
      paramBundle = this.d.getZoomButtonsController().getZoomControls();
      if (paramBundle != null) {
        paramBundle.setPadding(0, 0, 0, (int)(aoa.a().a * 48.0F));
      }
      this.s.registerObserver(this.t);
      return;
      this.d.getController().zoomToSpan(i1, i2);
    }
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(getString(2131297166, new Object[] { this.f.a(this) }));
    ((ArrayList)localObject2).add(getString(2131296373, new Object[] { this.f.a(this) }));
    if (this.f.d != null) {
      ((ArrayList)localObject2).add(getString(2131298122, new Object[] { this.f.a(this) }));
    }
    for (;;)
    {
      Object localObject1 = new String[((ArrayList)localObject2).size()];
      ((ArrayList)localObject2).toArray((Object[])localObject1);
      localObject2 = new b.a(this);
      ((b.a)localObject2).a((CharSequence[])localObject1, ai.a(this));
      localObject1 = ((b.a)localObject2).a();
      ((b)localObject1).requestWindowFeature(1);
      return (Dialog)localObject1;
      ((ArrayList)localObject2).add(getString(2131296292));
      ((ArrayList)localObject2).add(getString(2131296296));
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    o.a(paramMenu.add(0, 0, 0, 2131297132).setIcon(2130837718), 2);
    if (av.j()) {
      bm.b(this);
    }
    return true;
  }
  
  public void onDestroy()
  {
    Log.i("groupchatrecentlocations/destroy");
    super.onDestroy();
    this.s.unregisterObserver(this.t);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    case 0: 
      paramMenuItem = this.d;
      if (!this.d.isSatellite()) {}
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
    this.b.disableMyLocation();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.b.enableMyLocation();
  }
  
  final class a
    extends ItemizedOverlay<OverlayItem>
  {
    public a()
    {
      super();
    }
    
    public final void a()
    {
      populate();
    }
    
    protected final OverlayItem createItem(int paramInt)
    {
      j localj = (j)GroupChatRecentLocationsActivity.b(GroupChatRecentLocationsActivity.this).get(paramInt);
      OverlayItem localOverlayItem = new OverlayItem(new GeoPoint((int)(localj.B * 1000000.0D), (int)(localj.C * 1000000.0D)), "", "");
      if (localj.n + 3600000L > System.currentTimeMillis())
      {
        localOverlayItem.setMarker(boundCenter(u.a().getResources().getDrawable(2130840337)));
        return localOverlayItem;
      }
      if (localj.n + 43200000L > System.currentTimeMillis())
      {
        localOverlayItem.setMarker(boundCenter(u.a().getResources().getDrawable(2130840338)));
        return localOverlayItem;
      }
      localOverlayItem.setMarker(boundCenter(u.a().getResources().getDrawable(2130840339)));
      return localOverlayItem;
    }
    
    public final void draw(Canvas paramCanvas, MapView paramMapView, boolean paramBoolean)
    {
      if (paramBoolean) {
        return;
      }
      super.draw(paramCanvas, paramMapView, false);
    }
    
    public final int size()
    {
      return GroupChatRecentLocationsActivity.b(GroupChatRecentLocationsActivity.this).size();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/location/GroupChatRecentLocationsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */