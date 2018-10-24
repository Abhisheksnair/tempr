package com.whatsapp.location;

import a.a.a.a.a.a.d;
import a.a.a.a.d;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Point;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.f.h;
import android.support.v4.view.ab;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.b.b;
import com.google.android.gms.maps.f;
import com.google.android.gms.maps.g;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.LatLngBounds.a;
import com.google.android.gms.maps.model.MarkerOptions;
import com.whatsapp.ContactLiveLocationThumbnail;
import com.whatsapp.TextEmojiLabel;
import com.whatsapp.aic;
import com.whatsapp.al;
import com.whatsapp.ant;
import com.whatsapp.aoa;
import com.whatsapp.atu;
import com.whatsapp.aus;
import com.whatsapp.av;
import com.whatsapp.br;
import com.whatsapp.data.cs;
import com.whatsapp.di;
import com.whatsapp.emoji.c;
import com.whatsapp.messaging.w;
import com.whatsapp.nh;
import com.whatsapp.protocol.ap;
import com.whatsapp.pv;
import com.whatsapp.rf;
import com.whatsapp.rh;
import com.whatsapp.u;
import com.whatsapp.util.Log;
import com.whatsapp.util.bm;
import com.whatsapp.va;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class GroupChatLiveLocationsActivity2
  extends nh
{
  boolean A = false;
  boolean B = false;
  private Map<String, com.google.android.gms.maps.model.b> C = new HashMap();
  private final f D = new l(this);
  private volatile boolean E;
  private ImageView F;
  private final ant G = ant.a();
  private final va H = va.a();
  private final di I = di.a();
  private final cc J = cc.a();
  private final com.whatsapp.data.e K = com.whatsapp.data.e.a();
  private final rh L = rh.a();
  private com.google.android.gms.maps.b.a M = new com.google.android.gms.maps.b.a()
  {
    public final void a()
    {
      GroupChatLiveLocationsActivity2.a(GroupChatLiveLocationsActivity2.this, false);
      a.d.a(GroupChatLiveLocationsActivity2.a(GroupChatLiveLocationsActivity2.this));
      if (GroupChatLiveLocationsActivity2.b(GroupChatLiveLocationsActivity2.this).i != null)
      {
        LatLng localLatLng = new LatLng(GroupChatLiveLocationsActivity2.b(GroupChatLiveLocationsActivity2.this).i.b, GroupChatLiveLocationsActivity2.b(GroupChatLiveLocationsActivity2.this).i.c);
        Point localPoint = GroupChatLiveLocationsActivity2.a(GroupChatLiveLocationsActivity2.this).i().a(localLatLng);
        if ((localPoint.x <= 0) || (localPoint.y <= 0) || (localPoint.x >= GroupChatLiveLocationsActivity2.c(GroupChatLiveLocationsActivity2.this).getWidth()) || (localPoint.y >= GroupChatLiveLocationsActivity2.c(GroupChatLiveLocationsActivity2.this).getHeight()))
        {
          Log.i("GroupChatLiveLocationsActivity2/selectedLocationAnimationCallback/onFinish;outside of map, zoom to try get there");
          GroupChatLiveLocationsActivity2.a(GroupChatLiveLocationsActivity2.this, true);
          GroupChatLiveLocationsActivity2.a(GroupChatLiveLocationsActivity2.this).a(d.a(localLatLng, GroupChatLiveLocationsActivity2.d(GroupChatLiveLocationsActivity2.this) * 2.0F), this);
        }
      }
    }
    
    public final void b()
    {
      StringBuilder localStringBuilder = new StringBuilder("GroupChatLiveLocationsActivity2/selectedLocationAnimationCallback/onCancel; selectedLocation.jid=");
      if (GroupChatLiveLocationsActivity2.b(GroupChatLiveLocationsActivity2.this).i == null) {}
      for (String str = null;; str = GroupChatLiveLocationsActivity2.b(GroupChatLiveLocationsActivity2.this).i.a)
      {
        Log.i(str);
        GroupChatLiveLocationsActivity2.a(GroupChatLiveLocationsActivity2.this, false);
        return;
      }
    }
  };
  private Runnable N = n.a(this);
  b n;
  com.google.android.gms.maps.b o;
  Set<com.google.android.gms.maps.model.b> p = new HashSet();
  int q = 0;
  int r = 0;
  float s = -1.0F;
  boolean t;
  MenuItem u;
  final atu v = atu.a();
  final bp w = bp.a();
  Bundle x;
  v y = new v(this.G, this.aq, this.H, this.ay, this.aB, this.I, this.K, this.v, this.w)
  {
    protected final void a()
    {
      k();
    }
    
    final void a(float paramAnonymousFloat, boolean paramAnonymousBoolean)
    {
      if (this.d.getLayoutParams().height != 0) {
        this.d.setLayoutParams(new LinearLayout.LayoutParams(-1, 0));
      }
      int i = (int)(paramAnonymousFloat / 2.0F);
      ab.b(GroupChatLiveLocationsActivity2.b(GroupChatLiveLocationsActivity2.this).e, -i);
      ab.b(GroupChatLiveLocationsActivity2.b(GroupChatLiveLocationsActivity2.this).f, -paramAnonymousFloat);
      if (GroupChatLiveLocationsActivity2.a(GroupChatLiveLocationsActivity2.this) != null)
      {
        GroupChatLiveLocationsActivity2.a(GroupChatLiveLocationsActivity2.this).a(0, i, 0, i);
        if ((paramAnonymousBoolean) && (!GroupChatLiveLocationsActivity2.f(GroupChatLiveLocationsActivity2.this))) {
          GroupChatLiveLocationsActivity2.a(GroupChatLiveLocationsActivity2.this).b(d.a(GroupChatLiveLocationsActivity2.a(GroupChatLiveLocationsActivity2.this).a().b));
        }
        return;
      }
      GroupChatLiveLocationsActivity2.a(GroupChatLiveLocationsActivity2.this, i);
      GroupChatLiveLocationsActivity2.b(GroupChatLiveLocationsActivity2.this, i);
    }
    
    public final void a(ap paramAnonymousap)
    {
      a.d.a(GroupChatLiveLocationsActivity2.a(GroupChatLiveLocationsActivity2.this));
      GroupChatLiveLocationsActivity2.j(GroupChatLiveLocationsActivity2.this).b(GroupChatLiveLocationsActivity2.i(GroupChatLiveLocationsActivity2.this));
      GroupChatLiveLocationsActivity2.a(GroupChatLiveLocationsActivity2.this).b();
      GroupChatLiveLocationsActivity2.k(GroupChatLiveLocationsActivity2.this);
      GroupChatLiveLocationsActivity2.c(GroupChatLiveLocationsActivity2.this).setLocationMode(2);
      LatLng localLatLng = new LatLng(paramAnonymousap.b, paramAnonymousap.c);
      float f = GroupChatLiveLocationsActivity2.a(GroupChatLiveLocationsActivity2.this, paramAnonymousap.e, 17.0F);
      GroupChatLiveLocationsActivity2.a(GroupChatLiveLocationsActivity2.this, true);
      if (GroupChatLiveLocationsActivity2.a(GroupChatLiveLocationsActivity2.this).a().c < f)
      {
        paramAnonymousap = GroupChatLiveLocationsActivity2.a(GroupChatLiveLocationsActivity2.this).i().a(localLatLng);
        if ((paramAnonymousap.x <= 0) || (paramAnonymousap.y <= 0) || (paramAnonymousap.x >= GroupChatLiveLocationsActivity2.c(GroupChatLiveLocationsActivity2.this).getWidth()) || (paramAnonymousap.y >= GroupChatLiveLocationsActivity2.c(GroupChatLiveLocationsActivity2.this).getHeight())) {
          GroupChatLiveLocationsActivity2.a(GroupChatLiveLocationsActivity2.this).a(d.a(localLatLng), GroupChatLiveLocationsActivity2.g(GroupChatLiveLocationsActivity2.this));
        }
      }
      for (;;)
      {
        GroupChatLiveLocationsActivity2.e(GroupChatLiveLocationsActivity2.this);
        return;
        GroupChatLiveLocationsActivity2.a(GroupChatLiveLocationsActivity2.this).a(d.a(localLatLng, f), GroupChatLiveLocationsActivity2.g(GroupChatLiveLocationsActivity2.this));
        continue;
        GroupChatLiveLocationsActivity2.a(GroupChatLiveLocationsActivity2.this).a(d.a(localLatLng), GroupChatLiveLocationsActivity2.g(GroupChatLiveLocationsActivity2.this));
      }
    }
    
    public final void c()
    {
      GroupChatLiveLocationsActivity2.e(GroupChatLiveLocationsActivity2.this);
      if (GroupChatLiveLocationsActivity2.a(GroupChatLiveLocationsActivity2.this) != null)
      {
        if ((this.i == null) || (GroupChatLiveLocationsActivity2.f(GroupChatLiveLocationsActivity2.this))) {
          break label143;
        }
        localLatLng = new LatLng(this.i.b, this.i.c);
        f = GroupChatLiveLocationsActivity2.a(GroupChatLiveLocationsActivity2.this, this.i.e, -1.0F);
        if ((f <= GroupChatLiveLocationsActivity2.a(GroupChatLiveLocationsActivity2.this).a().c) && (f != -1.0F)) {
          break label120;
        }
        GroupChatLiveLocationsActivity2.a(GroupChatLiveLocationsActivity2.this).a(d.a(localLatLng), GroupChatLiveLocationsActivity2.g(GroupChatLiveLocationsActivity2.this));
      }
      label120:
      label143:
      while (GroupChatLiveLocationsActivity2.h(GroupChatLiveLocationsActivity2.this))
      {
        LatLng localLatLng;
        float f;
        return;
        GroupChatLiveLocationsActivity2.a(GroupChatLiveLocationsActivity2.this).a(d.a(localLatLng, f), GroupChatLiveLocationsActivity2.g(GroupChatLiveLocationsActivity2.this));
        return;
      }
      GroupChatLiveLocationsActivity2.b(GroupChatLiveLocationsActivity2.this, true);
    }
    
    final void d()
    {
      super.d();
      GroupChatLiveLocationsActivity2.e(GroupChatLiveLocationsActivity2.this);
    }
    
    public final void onLocationChanged(Location paramAnonymousLocation)
    {
      super.onLocationChanged(paramAnonymousLocation);
      if ((GroupChatLiveLocationsActivity2.b(GroupChatLiveLocationsActivity2.this).m) && (paramAnonymousLocation != null))
      {
        a.d.a(GroupChatLiveLocationsActivity2.a(GroupChatLiveLocationsActivity2.this));
        paramAnonymousLocation = new LatLng(paramAnonymousLocation.getLatitude(), paramAnonymousLocation.getLongitude());
        GroupChatLiveLocationsActivity2.a(GroupChatLiveLocationsActivity2.this).b(d.a(paramAnonymousLocation));
      }
    }
  };
  boolean z = false;
  
  private boolean a(boolean paramBoolean, LatLngBounds.a parama)
  {
    a.d.a(this.o);
    parama = parama.a();
    LatLng localLatLng = parama.a();
    float f = v.a(parama, this.n.getWidth(), this.n.getHeight());
    if (paramBoolean)
    {
      this.E = true;
      if (f > 21.0F)
      {
        this.o.a(d.a(localLatLng, 19.0F), this.M);
        return false;
      }
      this.o.a(d.a(parama, (int)(aoa.a().a * 64.0F)), this.M);
      return true;
    }
    this.o.a(d.a(localLatLng, Math.min(19.0F, f)));
    return true;
  }
  
  private void b(List<com.google.android.gms.maps.model.b> paramList, boolean paramBoolean)
  {
    a.d.a(this.o);
    Object localObject1 = this.y;
    Object localObject2;
    Object localObject3;
    if (!TextUtils.isEmpty(((v)localObject1).n))
    {
      localObject2 = ((v)localObject1).o.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ap)((Iterator)localObject2).next();
        if ((localObject3 != null) && (((ap)localObject3).a()) && (((ap)localObject3).a.equals(((v)localObject1).n))) {
          localObject1 = new LatLng(((ap)localObject3).b, ((ap)localObject3).c);
        }
      }
    }
    int i;
    for (;;)
    {
      if (localObject1 != null) {
        Collections.sort(paramList, p.a(((LatLng)localObject1).b, ((LatLng)localObject1).c));
      }
      localObject1 = new LatLngBounds.a();
      localObject2 = new LatLngBounds.a();
      i = 0;
      while (i < paramList.size())
      {
        localObject3 = (com.google.android.gms.maps.model.b)paramList.get(i);
        ((LatLngBounds.a)localObject2).a(((com.google.android.gms.maps.model.b)localObject3).c());
        if (!v.a(((LatLngBounds.a)localObject2).a())) {
          break;
        }
        ((LatLngBounds.a)localObject1).a(((com.google.android.gms.maps.model.b)localObject3).c());
        i += 1;
      }
      localObject1 = ((v)localObject1).b();
      if (localObject1 != null) {
        localObject1 = new LatLng(((Location)localObject1).getLatitude(), ((Location)localObject1).getLongitude());
      } else {
        localObject1 = null;
      }
    }
    if (i == 1)
    {
      a(((v.c)((com.google.android.gms.maps.model.b)paramList.get(0)).i()).a, paramBoolean);
      return;
    }
    a(paramBoolean, (LatLngBounds.a)localObject1);
  }
  
  private void m()
  {
    
    if (this.o == null) {
      this.o = this.n.b(this.D);
    }
    ImageView localImageView = this.F;
    if (this.v.c()) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  final boolean a(List<ap> paramList, boolean paramBoolean)
  {
    a.d.a(this.o);
    if (paramList.size() == 1)
    {
      if (paramBoolean) {
        this.o.b(d.a(new LatLng(((ap)paramList.get(0)).b, ((ap)paramList.get(0)).c), 17.0F));
      }
      for (;;)
      {
        return true;
        this.o.a(d.a(new LatLng(((ap)paramList.get(0)).b, ((ap)paramList.get(0)).c), 17.0F));
      }
    }
    LatLngBounds.a locala = new LatLngBounds.a();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ap localap = (ap)paramList.next();
      locala.a(new LatLng(localap.b, localap.c));
    }
    return a(paramBoolean, locala);
  }
  
  final void c(boolean paramBoolean)
  {
    if (this.o == null) {}
    do
    {
      do
      {
        return;
      } while ((this.t) || (this.p.isEmpty()));
      if ((this.n.getWidth() <= 0) || (this.n.getHeight() <= 0))
      {
        this.n.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
          public final void onGlobalLayout()
          {
            GroupChatLiveLocationsActivity2.c(GroupChatLiveLocationsActivity2.this).getViewTreeObserver().removeGlobalOnLayoutListener(this);
            if ((GroupChatLiveLocationsActivity2.c(GroupChatLiveLocationsActivity2.this).getWidth() > 0) && (GroupChatLiveLocationsActivity2.c(GroupChatLiveLocationsActivity2.this).getHeight() > 0)) {
              GroupChatLiveLocationsActivity2.b(GroupChatLiveLocationsActivity2.this, false);
            }
          }
        });
        return;
      }
      if ((paramBoolean) && (this.A))
      {
        this.B = true;
        return;
      }
      b(new ArrayList(this.p), paramBoolean);
    } while (!paramBoolean);
    this.A = true;
    this.aq.b(this.N);
    this.aq.a(this.N, 4000L);
  }
  
  @SuppressLint({"MissingPermission"})
  final void l()
  {
    if (this.o == null) {}
    for (;;)
    {
      return;
      if (this.y.j != null) {
        this.o.b(false);
      }
      int i = this.n.getWidth();
      int j = this.n.getHeight();
      if ((i != 0) && (j != 0))
      {
        Object localObject3 = new ArrayList(this.p);
        this.p.clear();
        g localg = this.o.i();
        Object localObject1 = new ArrayList();
        Object localObject2 = this.y.j().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (ap)((Iterator)localObject2).next();
          if (((ap)localObject4).g != 0L) {
            ((List)localObject1).add(h.a(localObject4, localg.a(new LatLng(((ap)localObject4).b, ((ap)localObject4).c))));
          }
        }
        Object localObject4 = this.y.a((List)localObject1).iterator();
        if (((Iterator)localObject4).hasNext())
        {
          v.c localc = (v.c)((Iterator)localObject4).next();
          localObject1 = (com.google.android.gms.maps.model.b)this.C.get(localc.e);
          if (localObject1 == null)
          {
            cs localcs = this.K.d(localc.b.a);
            localObject2 = localcs.a(getResources().getDimensionPixelSize(2131362090), getResources().getDimension(2131361833), true);
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = cs.b(localcs.e());
            }
            this.y.l.setImageBitmap((Bitmap)localObject1);
            if (localc.c)
            {
              this.y.l.setGlowColor(android.support.v4.content.b.c(this, 2131624054));
              label329:
              this.y.l.setStackSize(localc.a.size());
              localObject1 = Bitmap.createBitmap(this.y.k.getWidth(), this.y.k.getHeight(), Bitmap.Config.ARGB_8888);
              this.y.k.draw(new Canvas((Bitmap)localObject1));
              localObject2 = new MarkerOptions();
              ((MarkerOptions)localObject2).a(d.a((Bitmap)localObject1));
              localObject1 = this.o.a(((MarkerOptions)localObject2).a(localc.d));
              this.C.put(localc.e, localObject1);
              label447:
              ((com.google.android.gms.maps.model.b)localObject1).a(localc);
              localObject2 = localg.a(localc.d);
              if ((localc.b != this.y.i) && ((this.y.i != null) || (!((com.google.android.gms.maps.model.b)localObject1).f()) || (((Point)localObject2).x < 0) || (((Point)localObject2).x > this.n.getWidth()) || (((Point)localObject2).y < 0) || (((Point)localObject2).y > this.n.getHeight()))) {
                break label604;
              }
              ((com.google.android.gms.maps.model.b)localObject1).d();
            }
          }
          for (;;)
          {
            this.p.add(localObject1);
            break;
            this.y.l.setGlowColor(android.support.v4.content.b.c(this, 2131624053));
            break label329;
            if (!((com.google.android.gms.maps.model.b)localObject1).h()) {
              ((com.google.android.gms.maps.model.b)localObject1).g();
            }
            ((com.google.android.gms.maps.model.b)localObject1).a(localc.d);
            break label447;
            label604:
            ((com.google.android.gms.maps.model.b)localObject1).e();
          }
        }
        localObject1 = ((List)localObject3).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.google.android.gms.maps.model.b)((Iterator)localObject1).next();
          if (!this.p.contains(localObject2))
          {
            localObject3 = (v.c)((com.google.android.gms.maps.model.b)localObject2).i();
            this.C.remove(((v.c)localObject3).e);
            ((com.google.android.gms.maps.model.b)localObject2).a();
          }
        }
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (!this.y.a(paramInt1, paramInt2)) {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    this.y.a(paramMenuItem);
    return true;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Log.i("grouplocations/create");
    i().a(true);
    setContentView(2130903251);
    Object localObject = this.K.a(getIntent().getStringExtra("jid"));
    i().a(c.a(((cs)localObject).a(this), this));
    this.y.a(this, paramBundle);
    com.google.android.gms.maps.e.a(this);
    localObject = new GoogleMapOptions();
    ((GoogleMapOptions)localObject).a().b().b(true).a(true).d(true).c(true);
    this.n = new b(this, (GoogleMapOptions)localObject)
    {
      public final void a(int paramAnonymousInt)
      {
        switch (paramAnonymousInt)
        {
        default: 
          return;
        case 0: 
          GroupChatLiveLocationsActivity2.k(GroupChatLiveLocationsActivity2.this);
          GroupChatLiveLocationsActivity2.b(GroupChatLiveLocationsActivity2.this).m = true;
          GroupChatLiveLocationsActivity2.l(GroupChatLiveLocationsActivity2.this).setImageResource(2130837660);
          return;
        case 1: 
          GroupChatLiveLocationsActivity2.k(GroupChatLiveLocationsActivity2.this);
          GroupChatLiveLocationsActivity2.b(GroupChatLiveLocationsActivity2.this).m = true;
          GroupChatLiveLocationsActivity2.l(GroupChatLiveLocationsActivity2.this).setImageResource(2130837704);
          return;
        }
        GroupChatLiveLocationsActivity2.l(GroupChatLiveLocationsActivity2.this).setImageResource(2130837703);
        GroupChatLiveLocationsActivity2.b(GroupChatLiveLocationsActivity2.this).m = false;
      }
      
      public final Location getMyLocation()
      {
        if ((GroupChatLiveLocationsActivity2.b(GroupChatLiveLocationsActivity2.this) != null) && (GroupChatLiveLocationsActivity2.b(GroupChatLiveLocationsActivity2.this).b() != null)) {
          return GroupChatLiveLocationsActivity2.b(GroupChatLiveLocationsActivity2.this).b();
        }
        return super.getMyLocation();
      }
    };
    ((ViewGroup)a.d.a((ViewGroup)findViewById(2131755628))).addView(this.n);
    this.n.a(paramBundle);
    this.F = ((ImageView)a.d.a((ImageView)findViewById(2131755820)));
    this.F.setOnClickListener(o.a(this));
    this.x = paramBundle;
    m();
  }
  
  public Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    }
    android.support.v7.app.b localb = new android.support.v7.app.b.a(this).b(2131297111).a(true).b(2131296398, null).a(2131297109, m.a(this)).a();
    localb.requestWindowFeature(1);
    return localb;
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131820547, paramMenu);
    this.u = paramMenu.findItem(2131756290);
    if ((this.u != null) && (this.o != null)) {
      this.u.setChecked(this.o.d());
    }
    if ((this.w.f(this.y.h)) || (!aic.u)) {
      paramMenu.removeGroup(2131756284);
    }
    if (av.j()) {
      bm.b(this);
    }
    return true;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.n.c();
    this.y.e();
    this.aq.b(this.N);
    if (this.o != null)
    {
      SharedPreferences.Editor localEditor = getSharedPreferences("com.whatsapp_preferences", 0).edit();
      CameraPosition localCameraPosition = this.o.a();
      localEditor.putFloat("live_location_lat", (float)localCameraPosition.b.b);
      localEditor.putFloat("live_location_lng", (float)localCameraPosition.b.c);
      localEditor.putFloat("live_location_zoom", localCameraPosition.c);
      localEditor.apply();
    }
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    this.n.d();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    a.d.a(this.o);
    switch (paramMenuItem.getItemId())
    {
    default: 
      return false;
    case 2131756285: 
      this.J.a(this, this.y.h);
      return true;
    case 2131756287: 
      this.o.a(1);
      getSharedPreferences("com.whatsapp_preferences", 0).edit().putInt("live_location_map_type", 1).apply();
      return true;
    case 2131756288: 
      this.o.a(4);
      getSharedPreferences("com.whatsapp_preferences", 0).edit().putInt("live_location_map_type", 4).apply();
      return true;
    case 2131756289: 
      this.o.a(3);
      getSharedPreferences("com.whatsapp_preferences", 0).edit().putInt("live_location_map_type", 3).apply();
      return true;
    case 2131756290: 
      if (!this.o.d()) {}
      for (boolean bool = true;; bool = false)
      {
        this.o.a(bool);
        this.u.setChecked(bool);
        getSharedPreferences("com.whatsapp_preferences", 0).edit().putBoolean("live_location_show_traffic", bool).apply();
        return true;
      }
    }
    finish();
    return true;
  }
  
  protected void onPause()
  {
    super.onPause();
    this.n.b();
    this.n.g();
    this.y.f();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.n.a();
    this.n.f();
    this.y.g();
    m();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (this.o != null)
    {
      localObject = this.o.a();
      paramBundle.putFloat("camera_zoom", ((CameraPosition)localObject).c);
      paramBundle.putDouble("camera_lat", ((CameraPosition)localObject).b.b);
      paramBundle.putDouble("camera_lng", ((CameraPosition)localObject).b.c);
      paramBundle.putBoolean("map_touched", this.t);
      paramBundle.putInt("map_location_mode", this.n.getLocationMode());
    }
    this.n.b(paramBundle);
    Object localObject = this.y;
    paramBundle.putBoolean("map_follow_user", ((v)localObject).m);
    if (((v)localObject).i != null) {
      paramBundle.putString("selected_user_jid", ((v)localObject).i.a);
    }
    super.onSaveInstanceState(paramBundle);
  }
  
  final class a
    implements b.b
  {
    private final View b = al.a(GroupChatLiveLocationsActivity2.m(GroupChatLiveLocationsActivity2.this), GroupChatLiveLocationsActivity2.this.getLayoutInflater(), 2130903267, null, false);
    
    a() {}
    
    public final View a(com.google.android.gms.maps.model.b paramb)
    {
      ap localap = ((v.c)paramb.i()).b;
      paramb = (TextEmojiLabel)this.b.findViewById(2131755571);
      TextView localTextView = (TextView)this.b.findViewById(2131755864);
      Object localObject = this.b.findViewById(2131755865);
      if (GroupChatLiveLocationsActivity2.n(GroupChatLiveLocationsActivity2.this).a(localap.a))
      {
        paramb.setTextColor(-570425344);
        paramb.a(GroupChatLiveLocationsActivity2.this.getString(2131297017));
        ((View)localObject).setVisibility(8);
        paramb = "";
        if (localap.d != ap.h) {
          paramb = "" + String.format(u.a.a(2131230760, localap.d), new Object[] { Integer.valueOf(localap.d) });
        }
        localObject = paramb;
        if (localap.e > 0.5F)
        {
          localObject = paramb;
          if (!TextUtils.isEmpty(paramb)) {
            localObject = paramb + ", ";
          }
          if (!Locale.US.equals(GroupChatLiveLocationsActivity2.q(GroupChatLiveLocationsActivity2.this).b())) {
            break label372;
          }
          localObject = (String)localObject + GroupChatLiveLocationsActivity2.this.getString(2131297127, new Object[] { String.format("%1$,.1f", new Object[] { Float.valueOf(localap.e * 2.23694F) }) });
        }
        label273:
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label432;
        }
        localTextView.setText((CharSequence)localObject);
        localTextView.setVisibility(0);
      }
      for (;;)
      {
        return this.b;
        rf localrf = GroupChatLiveLocationsActivity2.o(GroupChatLiveLocationsActivity2.this).a(GroupChatLiveLocationsActivity2.b(GroupChatLiveLocationsActivity2.this).h, localap.a);
        if (localrf != null) {
          paramb.setTextColor(localrf.e);
        }
        for (;;)
        {
          paramb.setContact(GroupChatLiveLocationsActivity2.p(GroupChatLiveLocationsActivity2.this).d(localap.a));
          ((View)localObject).setVisibility(0);
          break;
          paramb.setTextColor(-1728053248);
        }
        label372:
        localObject = (String)localObject + GroupChatLiveLocationsActivity2.this.getString(2131297126, new Object[] { String.format("%1$,.1f", new Object[] { Float.valueOf(localap.e * 3.6F) }) });
        break label273;
        label432:
        localTextView.setVisibility(8);
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/location/GroupChatLiveLocationsActivity2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */