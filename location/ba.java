package com.whatsapp.location;

import a.a.a.a.d;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.b;
import android.support.v7.app.b.a;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import com.google.android.gms.maps.model.LatLngBounds;
import com.whatsapp.MediaData;
import com.whatsapp.MentionableEntry;
import com.whatsapp.PlaceInfo;
import com.whatsapp.ThumbnailButton;
import com.whatsapp.abn;
import com.whatsapp.aic;
import com.whatsapp.al;
import com.whatsapp.and;
import com.whatsapp.ant;
import com.whatsapp.aoa;
import com.whatsapp.aoj;
import com.whatsapp.aoj.2;
import com.whatsapp.aom;
import com.whatsapp.apd;
import com.whatsapp.atu;
import com.whatsapp.atv;
import com.whatsapp.aus;
import com.whatsapp.av;
import com.whatsapp.data.ad;
import com.whatsapp.data.cs;
import com.whatsapp.data.l;
import com.whatsapp.emoji.h;
import com.whatsapp.g.k;
import com.whatsapp.j.a.a;
import com.whatsapp.pb;
import com.whatsapp.protocol.j;
import com.whatsapp.pv;
import com.whatsapp.u;
import com.whatsapp.ui;
import com.whatsapp.util.Log;
import com.whatsapp.util.WhatsAppLibLoader;
import com.whatsapp.util.at;
import com.whatsapp.util.bi.b;
import com.whatsapp.util.bu;
import com.whatsapp.va;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class ba
{
  private View A;
  private View B;
  private View C;
  private View D;
  private View E;
  private Handler F;
  private Runnable G;
  private boolean H;
  private boolean I = true;
  private final va J;
  private final h K;
  private final and L;
  private final atu M;
  private final atv N;
  private d a;
  Activity b;
  View c;
  View d;
  TextView e;
  ui f;
  com.whatsapp.util.bi g;
  a h;
  ListView i;
  boolean j;
  Bitmap k;
  Location l;
  final PlaceInfo m = new PlaceInfo();
  abn n;
  PlaceInfo o;
  e p;
  String q;
  boolean r = false;
  boolean s = false;
  final pv t;
  final aoj u;
  final aus v;
  final l w;
  private int x = -1;
  private long y;
  private View z;
  
  ba(pv parampv, va paramva, aoj paramaoj, h paramh, aus paramaus, and paramand, l paraml, atu paramatu, atv paramatv)
  {
    this.t = parampv;
    this.J = paramva;
    this.u = paramaoj;
    this.K = paramh;
    this.v = paramaus;
    this.L = paramand;
    this.w = paraml;
    this.M = paramatu;
    this.N = paramatv;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    long l1 = 0L;
    if (this.y > 0L) {
      l1 = Math.max(0L, System.currentTimeMillis() - this.y);
    }
    int i1;
    Activity localActivity;
    int i2;
    label67:
    int i4;
    int i5;
    String str1;
    label96:
    boolean bool;
    String str2;
    if (this.n == null)
    {
      i1 = 3;
      localActivity = this.b;
      if ((this.n != null) && (this.n.b != 0)) {
        break label247;
      }
      i2 = abn.b(this.J);
      i4 = abn.a(i2);
      i5 = abn.a(abn.a(this.J));
      if (this.n != null) {
        break label259;
      }
      str1 = null;
      bool = h();
      if (this.n != null) {
        break label271;
      }
      str2 = null;
      label112:
      if (this.n != null) {
        break label283;
      }
      i2 = 0;
      label122:
      if (this.n != null) {
        break label297;
      }
    }
    label247:
    label259:
    label271:
    label283:
    label297:
    for (int i3 = 0;; i3 = this.n.c.size())
    {
      pb.a(localActivity, i4, i5, paramInt1, i1, str1, bool, str2, i2, i3, paramInt2, l1);
      return;
      if (this.n.b == 0)
      {
        i1 = 2;
        break;
      }
      switch (this.n.f.intValue())
      {
      default: 
        i1 = 1;
        break;
      case 1: 
        i1 = 1;
        break;
      case 4: 
        i1 = 5;
        break;
      case 3: 
        i1 = 4;
        break;
      case 5: 
        i1 = 6;
        break;
      case 2: 
        i1 = 2;
        break;
        i2 = this.n.b;
        break label67;
        str1 = this.n.g;
        break label96;
        str2 = this.n.a;
        break label112;
        i2 = this.n.e + 1;
        break label122;
      }
    }
  }
  
  private void a(Location paramLocation, int paramInt, String paramString, boolean paramBoolean)
  {
    this.F.removeCallbacks(this.G);
    e();
    this.b.findViewById(2131755889).setVisibility(8);
    this.e.setVisibility(8);
    this.d.setVisibility(8);
    this.n = new abn();
    this.h.a = false;
    this.p.notifyDataSetChanged();
    this.a = new d(this.J, paramLocation, paramInt, paramString, paramBoolean);
    bu.a(this.a, new Void[0]);
  }
  
  private void t()
  {
    Object localObject3 = null;
    if (b() == null) {}
    for (Object localObject1 = this.l;; localObject1 = b())
    {
      Object localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((Location)localObject1).getAccuracy() > 200.0F) {
          localObject2 = null;
        }
      }
      long l1 = this.b.getIntent().getLongExtra("quoted_message_row_id", 0L);
      localObject1 = localObject3;
      if (l1 != 0L) {
        localObject1 = this.w.a(l1);
      }
      this.u.a(this.q, (Location)localObject2, (j)localObject1, this.b.getIntent().getBooleanExtra("has_number_from_url", false));
      a(2, 0);
      this.b.setResult(-1);
      this.b.finish();
      return;
    }
  }
  
  private void u()
  {
    if (this.N.a.getBoolean("live_location_is_new_user", true))
    {
      d.a(this.b, 3);
      return;
    }
    if (((k)b.a.a.c.a().a(k.class)).a)
    {
      Log.i("LocationPickerUI/enterLiveLocationMode/powerSaveMode=true; can't change mode");
      d.a(this.b, 4);
      return;
    }
    if (this.M.c())
    {
      this.j = true;
      this.n = new abn();
      g();
    }
    j();
  }
  
  private void v()
  {
    this.j = false;
    View localView = this.b.getCurrentFocus();
    if (localView != null) {
      ((InputMethodManager)this.b.getSystemService("input_method")).hideSoftInputFromWindow(localView.getWindowToken(), 0);
    }
    if (this.s)
    {
      this.b.finish();
      return;
    }
    g();
    a(c(), d(), null, false);
    j();
  }
  
  private void w()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.n != null)
    {
      localObject1 = localObject2;
      if (!this.n.c.isEmpty()) {
        if (this.n.b != 3) {
          break label98;
        }
      }
    }
    label98:
    for (localObject1 = this.b.getString(2131297118, new Object[] { "<a href='https://foursquare.com/'>foursquare</a>" });; localObject1 = this.n.d)
    {
      this.d.setVisibility(8);
      if ((localObject1 == null) || (h())) {
        break;
      }
      this.e.setText(Html.fromHtml((String)localObject1));
      this.e.setVisibility(0);
      return;
    }
    this.e.setVisibility(8);
  }
  
  public final Dialog a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 2: 
      DialogInterface.OnClickListener localOnClickListener = bj.a(this);
      return new b.a(this.b).a(2131296940).b(2131296939).a(true).a(2131297331, localOnClickListener).a();
    case 3: 
      return new b.a(this.b).a(al.a(this.t, this.b.getLayoutInflater(), 2130903268, null, false)).a(true).b(2131296398, bk.a(this)).a(bl.a(this)).a(2131297331, bc.a(this)).a();
    }
    return new b.a(this.b).a(2131296307).a(true).b(2131297095).a(2131297331, null).a(bd.a(this)).a();
  }
  
  protected abstract void a();
  
  final void a(final Activity paramActivity, Bundle paramBundle)
  {
    this.b = paramActivity;
    if (!WhatsAppLibLoader.a(null))
    {
      Log.i("aborting due to native libraries missing");
      this.b.finish();
      return;
    }
    if (this.J.b == null)
    {
      this.b.finish();
      return;
    }
    abn.a();
    if (paramBundle != null)
    {
      this.n = ((abn)paramBundle.getSerializable("places"));
      this.j = paramBundle.getBoolean("show_live_location_setting", false);
      paramBundle.remove("places");
    }
    this.q = this.b.getIntent().getStringExtra("jid");
    this.s = this.b.getIntent().getBooleanExtra("live_location_mode", false);
    boolean bool;
    label148:
    final Object localObject1;
    if ((aic.u) && (!TextUtils.isEmpty(this.q)) && (!j.b(this.q)))
    {
      bool = true;
      this.r = bool;
      this.z = this.b.findViewById(2131755883);
      this.z.setOnClickListener(bb.a(this));
      this.A = this.b.findViewById(2131755886);
      this.A.setOnClickListener(be.a(this));
      if (av.d())
      {
        localObject1 = bf.a(this);
        this.z.setOnLongClickListener((View.OnLongClickListener)localObject1);
        this.A.setOnLongClickListener((View.OnLongClickListener)localObject1);
      }
      this.F = new Handler(Looper.getMainLooper());
      this.G = bg.a(this);
      if (this.n == null) {
        this.F.postDelayed(this.G, 15000L);
      }
      localObject1 = new File(u.a().getCacheDir(), "Places");
      if ((!((File)localObject1).mkdirs()) && (!((File)localObject1).isDirectory())) {
        Log.w("LocationPickerUI/create unable to create places directory");
      }
      localObject1 = new bi.b((File)localObject1);
      ((bi.b)localObject1).f = ((int)(aoa.a().a * 48.0F));
      this.g = ((bi.b)localObject1).b();
      this.B = this.b.findViewById(2131755887);
      this.C = this.b.findViewById(2131755820);
      this.D = this.b.findViewById(2131755890);
      this.E = this.b.findViewById(2131755893);
      localObject1 = View.inflate(this.b, 2130903275, null);
      this.e = ((TextView)((View)localObject1).findViewById(2131755900));
      this.e.setMovementMethod(LinkMovementMethod.getInstance());
      Object localObject2 = View.inflate(this.b, 2130903276, null);
      this.d = ((View)localObject2).findViewById(2131755901);
      this.d.setVisibility(8);
      this.p = new e((byte)0);
      this.i = ((ListView)this.b.findViewById(2131755888));
      if (!this.r) {
        break label980;
      }
      View localView = al.a(this.t, this.b.getLayoutInflater(), 2130903273);
      this.i.addHeaderView(localView, null, false);
      this.c = al.a(this.t, this.b.getLayoutInflater(), 2130903278);
      this.i.addHeaderView(this.c, null, true);
      label583:
      this.i.setAdapter(this.p);
      this.i.setFooterDividersEnabled(true);
      this.i.addFooterView((View)localObject1, null, true);
      this.i.addFooterView((View)localObject2, null, false);
      w();
      this.i.setOnItemClickListener(bh.a(this));
      this.h = new a((byte)0);
      this.i.setOnScrollListener(this.h);
      localObject2 = (RadioGroup)this.b.findViewById(2131755591);
      localObject1 = new f((byte)0);
      ((RadioGroup)localObject2).setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener)localObject1);
      localObject2 = this.b.findViewById(2131755873);
      this.f = new ui(this.b, this.t, this.K, this.N, this.L, (View)localObject2, this.q);
      this.b.findViewById(2131755437).setOnClickListener(new at()
      {
        public final void a(View paramAnonymousView)
        {
          aoj localaoj = null;
          if (((k)b.a.a.c.a().a(k.class)).a)
          {
            Log.i("LocationPickerUI/Send click/powerSaveMode=true; can't change mode");
            new b.a(paramActivity).a(paramActivity.getString(2131296307)).b(paramActivity.getString(2131297095)).a(paramActivity.getString(2131297331), null).a().show();
            return;
          }
          int i;
          switch (localObject1.a)
          {
          default: 
            i = 3600;
            if (ba.this.b() != null) {
              break;
            }
          }
          for (paramAnonymousView = ba.this.l;; paramAnonymousView = ba.this.b())
          {
            View localView = paramAnonymousView;
            if (paramAnonymousView != null)
            {
              localView = paramAnonymousView;
              if (paramAnonymousView.getAccuracy() > 200.0F) {
                localView = null;
              }
            }
            long l = paramActivity.getIntent().getLongExtra("quoted_message_row_id", 0L);
            paramAnonymousView = localaoj;
            if (l != 0L) {
              paramAnonymousView = ba.this.w.a(l);
            }
            localaoj = ba.this.u;
            String str1 = ba.this.q;
            String str2 = com.whatsapp.emoji.c.b(ba.this.f.f.getStringText());
            ArrayList localArrayList = ba.this.f.f.getMentions();
            boolean bool = paramActivity.getIntent().getBooleanExtra("has_number_from_url", false);
            j localj = new j(localaoj.d, str1, new MediaData());
            localj.n = localaoj.b.b();
            localj.m = 1;
            localj.s = 16;
            localj.d = 1;
            if (localView != null)
            {
              localj.B = localView.getLatitude();
              localj.C = localView.getLongitude();
            }
            localj.a(paramAnonymousView, localaoj.s);
            localj.a(bool, false);
            localj.w = i;
            localj.z = str2;
            if ((localArrayList != null) && (!localArrayList.isEmpty())) {
              localj.P = localArrayList;
            }
            localaoj.d(localj);
            localaoj.f.b(localj, 2);
            bu.a(apd.a(localaoj, localaoj.a.getContentResolver(), str1));
            paramAnonymousView = new ce(localaoj.a, localaoj.f, localaoj.o, localaoj.t, localaoj.u, localj);
            paramAnonymousView.e = ce.f;
            bu.a(paramAnonymousView, new Void[0]);
            ba.a(ba.this);
            paramActivity.setResult(1000);
            paramActivity.finish();
            return;
            i = 900;
            break;
            i = 3600;
            break;
            i = 14400;
            break;
          }
        }
      });
      localObject1 = View.inflate(this.b, 2130903118, null);
      localObject2 = this.J.c();
      paramActivity = ((cs)localObject2).a(this.b.getResources().getDimensionPixelSize(2131362090), this.b.getResources().getDimension(2131361833), true);
      if (paramActivity != null) {
        break label991;
      }
      paramActivity = cs.b(((cs)localObject2).e());
    }
    label980:
    label991:
    for (;;)
    {
      ((ThumbnailButton)((View)localObject1).findViewById(2131755363)).setImageBitmap(paramActivity);
      int i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
      ((View)localObject1).measure(i1, i1);
      i1 = ((View)localObject1).getMeasuredWidth();
      int i2 = ((View)localObject1).getMeasuredHeight();
      this.k = Bitmap.createBitmap(i1, i2, Bitmap.Config.ARGB_8888);
      ((View)localObject1).layout(0, 0, i1, i2);
      ((View)localObject1).draw(new Canvas(this.k));
      if ((paramBundle != null) || (!this.M.c())) {
        break;
      }
      paramActivity = (LocationManager)this.b.getSystemService("location");
      if ((paramActivity.isProviderEnabled("gps")) || (paramActivity.isProviderEnabled("network"))) {
        break;
      }
      d.a(this.b, 2);
      return;
      bool = false;
      break label148;
      this.c = this.z;
      break label583;
    }
  }
  
  final void a(Intent paramIntent)
  {
    if ("android.intent.action.SEARCH".equals(paramIntent.getAction()))
    {
      paramIntent = paramIntent.getStringExtra("query");
      a(c(), Math.max(d(), 1500), paramIntent, true);
    }
  }
  
  final void a(Location paramLocation)
  {
    TextView localTextView;
    if (!this.r) {
      localTextView = (TextView)this.b.findViewById(2131755885);
    }
    for (;;)
    {
      int i1;
      if (localTextView != null)
      {
        if (!paramLocation.hasAccuracy()) {
          break label242;
        }
        i1 = Math.max(1, (int)paramLocation.getAccuracy());
        label44:
        if (i1 != this.x)
        {
          this.x = i1;
          if (i1 <= 0) {
            break label247;
          }
          localTextView.setVisibility(0);
          localTextView.setText(String.format(u.a.a(2131230760, i1), new Object[] { Integer.valueOf(i1) }));
        }
      }
      label96:
      if ((this.n != null) && (this.n.c() != null) && (this.I) && (paramLocation.getAccuracy() < 200.0F) && (this.n.c().distanceTo(paramLocation) > 1000.0F)) {
        this.I = false;
      }
      for (boolean bool = true;; bool = false)
      {
        this.l = paramLocation;
        if (((this.n == null) || (bool)) && (((paramLocation.getAccuracy() < 200.0F) && (paramLocation.getTime() + 60000L > System.currentTimeMillis())) || (this.H))) {
          this.b.runOnUiThread(bi.a(this, bool, paramLocation));
        }
        return;
        if (h()) {
          break label262;
        }
        localTextView = (TextView)this.c.findViewById(2131755903);
        break;
        label242:
        i1 = -1;
        break label44;
        label247:
        localTextView.setVisibility(8);
        break label96;
      }
      label262:
      localTextView = null;
    }
  }
  
  protected final void a(Bundle paramBundle)
  {
    paramBundle.putSerializable("places", this.n);
    paramBundle.putBoolean("show_live_location_setting", this.j);
  }
  
  final void a(PlaceInfo paramPlaceInfo, int paramInt)
  {
    boolean bool1 = true;
    long l1 = this.b.getIntent().getLongExtra("quoted_message_row_id", 0L);
    j localj1;
    if (l1 != 0L)
    {
      localj1 = this.w.a(l1);
      aoj localaoj = this.u;
      String str = this.q;
      boolean bool2 = this.b.getIntent().getBooleanExtra("has_number_from_url", false);
      j localj2 = new j(localaoj.d, str, new MediaData());
      localj2.n = localaoj.b.b();
      localj2.m = 1;
      localj2.s = 5;
      localj2.d = 1;
      localj2.B = paramPlaceInfo.lat;
      localj2.C = paramPlaceInfo.lon;
      localj2.p = paramPlaceInfo.url;
      localj2.y = paramPlaceInfo.name;
      if (paramPlaceInfo.address != null) {
        localj2.y = (localj2.y + "\n" + paramPlaceInfo.address);
      }
      localj2.a(localj1, localaoj.s);
      localj2.a(bool2, false);
      localaoj.d(localj2);
      localaoj.f.b(localj2, 2);
      bu.a(aom.a(localaoj, localaoj.a.getContentResolver(), str));
      if (paramPlaceInfo.address != null) {
        break label345;
      }
      label261:
      bu.a(new aoj.2(localaoj, localaoj.a, localaoj.f, localaoj.o, localaoj.t, localaoj.u, localj2, paramPlaceInfo, bool1), new Void[0]);
      if (paramPlaceInfo.source != 0) {
        break label351;
      }
    }
    label345:
    label351:
    for (int i1 = 3;; i1 = 4)
    {
      a(i1, paramInt);
      this.b.setResult(-1);
      this.b.finish();
      return;
      localj1 = null;
      break;
      bool1 = false;
      break label261;
    }
  }
  
  protected abstract void a(boolean paramBoolean);
  
  protected abstract void a(boolean paramBoolean, LatLngBounds paramLatLngBounds);
  
  final boolean a(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return false;
    case 0: 
      this.b.onSearchRequested();
      return true;
    case 1: 
      this.I = false;
      a(c(), d(), null, false);
      return true;
    }
    a(1, 0);
    if (this.j)
    {
      v();
      return true;
    }
    this.b.finish();
    return true;
  }
  
  final boolean a(String paramString)
  {
    this.I = false;
    a(c(), Math.max(d(), 1500), paramString, true);
    return true;
  }
  
  protected abstract Location b();
  
  protected abstract Location c();
  
  protected abstract int d();
  
  protected abstract void e();
  
  protected abstract void f();
  
  protected abstract void g();
  
  protected abstract boolean h();
  
  final void i()
  {
    if (this.s) {
      u();
    }
    j();
    this.y = System.currentTimeMillis();
  }
  
  final void j()
  {
    if (this.M.c())
    {
      this.C.setVisibility(0);
      this.D.setVisibility(8);
      if (this.j)
      {
        this.z.setVisibility(8);
        this.B.setVisibility(8);
        this.A.setVisibility(8);
        this.E.setVisibility(0);
        a(true);
        g();
        return;
      }
      this.B.setVisibility(0);
      if (this.r)
      {
        this.A.setVisibility(0);
        this.z.setVisibility(8);
      }
      for (;;)
      {
        this.E.setVisibility(8);
        break;
        this.A.setVisibility(8);
        this.z.setVisibility(0);
      }
    }
    this.z.setVisibility(8);
    this.A.setVisibility(8);
    this.B.setVisibility(8);
    this.C.setVisibility(8);
    this.D.setVisibility(0);
    this.E.setVisibility(8);
    a(false);
  }
  
  final void k()
  {
    if (this.F != null) {
      this.F.removeCallbacks(this.G);
    }
    if (this.a != null)
    {
      this.a.cancel(true);
      this.a = null;
    }
    this.g.a(false);
    ui localui = this.f;
    localui.a.getViewTreeObserver().removeGlobalOnLayoutListener(localui.h);
    localui.f.a();
  }
  
  final boolean l()
  {
    a(1, 0);
    if (this.j)
    {
      v();
      return true;
    }
    return false;
  }
  
  final void m()
  {
    this.o = null;
    this.p.notifyDataSetChanged();
  }
  
  final void n()
  {
    if (this.o == null) {}
    int i1;
    do
    {
      return;
      abn localabn = this.n;
      PlaceInfo localPlaceInfo = this.o;
      i1 = localabn.c.indexOf(localPlaceInfo);
    } while (i1 < 0);
    this.p.notifyDataSetChanged();
    this.i.smoothScrollToPosition(i1 + this.i.getHeaderViewsCount());
  }
  
  final class a
    implements AbsListView.OnScrollListener
  {
    boolean a = false;
    boolean b = true;
    int c = 0;
    
    private a() {}
    
    public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
    {
      if (this.a)
      {
        paramInt3 -= ((ListView)paramAbsListView).getFooterViewsCount();
        if ((this.b) && (paramInt3 > this.c))
        {
          this.b = false;
          this.c = paramInt3;
        }
        if ((!this.b) && (paramInt1 + paramInt2 >= paramInt3 - 5))
        {
          this.b = true;
          bu.a(new ba.c(ba.this, ba.this.n), new Void[0]);
        }
      }
    }
    
    public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  }
  
  final class b
    implements Runnable
  {
    double a;
    double b;
    
    b(double paramDouble1, double paramDouble2)
    {
      this.a = paramDouble1;
      this.b = paramDouble2;
    }
    
    public final void run()
    {
      Object localObject3 = null;
      Object localObject1 = new Geocoder(u.a(), ba.this.v.b());
      Object localObject2;
      try
      {
        localObject1 = ((Geocoder)localObject1).getFromLocation(this.a, this.b, 1);
        if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
        {
          localObject1 = (Address)((List)localObject1).get(0);
          localObject3 = new StringBuilder();
          int i = 0;
          while (i < ((Address)localObject1).getMaxAddressLineIndex())
          {
            if (i != 0) {
              ((StringBuilder)localObject3).append(", ");
            }
            ((StringBuilder)localObject3).append(((Address)localObject1).getAddressLine(i));
            i += 1;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localObject2 = null;
        }
        localObject3 = ((StringBuilder)localObject3).toString();
      }
      for (;;)
      {
        ba.this.b.runOnUiThread(new bm(this, (Address)localObject2, (String)localObject3));
        return;
        String str = ba.this.b.getString(2131297122);
        localObject2 = localObject3;
        localObject3 = str;
      }
    }
  }
  
  final class c
    extends AsyncTask<Void, Void, Void>
  {
    private final abn b;
    
    c(abn paramabn)
    {
      this.b = paramabn;
    }
    
    protected final void onPreExecute()
    {
      super.onPreExecute();
      ba localba = ba.this;
      localba.e.setVisibility(8);
      localba.d.setVisibility(0);
    }
  }
  
  final class d
    extends AsyncTask<Void, Void, abn>
  {
    private va b;
    private Location c;
    private String d;
    private int e;
    private boolean f;
    
    d(va paramva, Location paramLocation, int paramInt, String paramString, boolean paramBoolean)
    {
      this.b = paramva;
      this.c = paramLocation;
      this.d = paramString;
      this.e = paramInt;
      this.f = paramBoolean;
    }
  }
  
  final class e
    extends BaseAdapter
  {
    private e() {}
    
    public final int getCount()
    {
      if (ba.this.n == null) {
        return 0;
      }
      return ba.this.n.c.size();
    }
    
    public final Object getItem(int paramInt)
    {
      if ((ba.this.n == null) || (paramInt >= ba.this.n.c.size())) {
        return null;
      }
      return ba.this.n.b(paramInt);
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final int getItemViewType(int paramInt)
    {
      return 0;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      paramViewGroup = paramView;
      if (paramView == null) {
        paramViewGroup = al.a(ba.this.t, ba.this.b.getLayoutInflater(), 2130903277);
      }
      paramView = (TextView)paramViewGroup.findViewById(2131755902);
      TextView localTextView = (TextView)paramViewGroup.findViewById(2131755903);
      ImageView localImageView = (ImageView)paramViewGroup.findViewById(2131755884);
      PlaceInfo localPlaceInfo = ba.this.n.b(paramInt);
      paramView.setText(localPlaceInfo.name);
      if (!TextUtils.isEmpty(localPlaceInfo.vicinity))
      {
        localTextView.setVisibility(0);
        localTextView.setText(localPlaceInfo.vicinity);
        localTextView.setSingleLine(true);
        if (localPlaceInfo != ba.this.o) {
          break label236;
        }
        if (!aic.u) {
          break label224;
        }
        paramView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130840449, 0);
        label143:
        switch (localPlaceInfo.source)
        {
        default: 
          paramInt = 0;
        }
      }
      for (;;)
      {
        localImageView.setPadding(paramInt, paramInt, paramInt, paramInt);
        if (localPlaceInfo.icon == null) {
          break label304;
        }
        ba.this.g.a(localPlaceInfo.icon, localImageView);
        return paramViewGroup;
        localTextView.setVisibility(8);
        break;
        label224:
        paramView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130840339, 0);
        break label143;
        label236:
        paramView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        break label143;
        paramInt = ba.this.b.getResources().getDimensionPixelSize(2131362068);
        continue;
        paramInt = ba.this.b.getResources().getDimensionPixelSize(2131362070);
        continue;
        paramInt = ba.this.b.getResources().getDimensionPixelSize(2131362069);
      }
      label304:
      localImageView.setImageDrawable(null);
      return paramViewGroup;
    }
    
    public final int getViewTypeCount()
    {
      return 1;
    }
  }
  
  final class f
    implements RadioGroup.OnCheckedChangeListener
  {
    int a = -1;
    
    private f() {}
    
    public final void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
    {
      if (paramInt != -1) {
        this.a = paramInt;
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/location/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */