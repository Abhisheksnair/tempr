package com.whatsapp;

import a.a.a.a.a.a.d;
import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import android.provider.ContactsContract.Contacts;
import android.support.v4.app.ag;
import android.support.v4.app.n;
import android.support.v4.view.ab;
import android.support.v4.view.o;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.DisplayMetrics;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.whatsapp.contact.sync.i;
import com.whatsapp.data.ad;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.gdrive.GoogleDriveNewUserSetupActivity;
import com.whatsapp.gdrive.GoogleDriveService;
import com.whatsapp.gdrive.GoogleDriveService.b;
import com.whatsapp.gdrive.GoogleDriveService.f;
import com.whatsapp.gdrive.bk;
import com.whatsapp.gdrive.ch;
import com.whatsapp.k.d.b;
import com.whatsapp.k.d.e;
import com.whatsapp.location.bp;
import com.whatsapp.messaging.w;
import com.whatsapp.notification.f;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.protocol.s;
import com.whatsapp.qrcode.QrCodeActivity;
import com.whatsapp.registration.bb;
import com.whatsapp.registration.x;
import com.whatsapp.util.Log;
import com.whatsapp.util.at;
import com.whatsapp.util.ax;
import com.whatsapp.util.az;
import com.whatsapp.util.bd;
import com.whatsapp.util.be;
import com.whatsapp.util.bh;
import com.whatsapp.util.bu;
import com.whatsapp.util.l;
import com.whatsapp.util.p;
import com.whatsapp.util.undobar.a.b;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class kd
  extends ag
  implements aah, sg
{
  private f aA;
  private final pv aB = pv.a();
  private final com.whatsapp.data.d aC = com.whatsapp.data.d.a();
  private final ahc aD = ahc.a();
  private final ani aE = ani.a();
  private final x aF = x.a();
  private final el aG = el.a();
  private final e aH = e.a();
  private final aus aI = aus.a();
  private final com.whatsapp.util.b aJ = com.whatsapp.util.b.a();
  private final i aK = i.a();
  private final cc aL = cc.a();
  private final com.whatsapp.notification.m aM = com.whatsapp.notification.m.a();
  private final ane aN = ane.a();
  private final f aO = f.a();
  private final atu aP = atu.a();
  private final lt aQ = lt.a();
  private final bp aR = bp.a();
  private final ka aS = ka.a();
  private final rh aT = rh.a();
  private final bb aU = bb.a();
  private final di.e aV = di.a().b();
  private final ServiceConnection aW = new ServiceConnection()
  {
    public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
    {
      kd.a(kd.this, ((GoogleDriveService.f)paramAnonymousIBinder).a);
      kd.a(kd.this, new kd.f(kd.this, (byte)0));
      bu.a(kl.a(this));
      Log.i("conversations/gdrive-service-connected");
    }
    
    public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
    {
      kd.b(kd.this).b(kd.a(kd.this));
      kd.a(kd.this, null);
      Log.i("conversations/gdrive-service-disconnected");
    }
  };
  private final dh aX = dh.a();
  private final dh.a aY = new dh.a()
  {
    public final void a()
    {
      kd.c(kd.this);
      if (kd.d(kd.this) != null)
      {
        if (kd.d(kd.this).getCount() == 0) {
          kd.e(kd.this);
        }
        kd.e.a.a((kd.e.a)kd.d(kd.this).getFilter());
      }
    }
    
    protected final void a(String paramAnonymousString)
    {
      Log.d("conversations/onDisplayNameChanged " + paramAnonymousString);
      kd.a(kd.this, u.a(), paramAnonymousString);
    }
    
    public final void b(String paramAnonymousString)
    {
      Log.d("conversations/onProfilePhotoChanged " + paramAnonymousString);
      kd.a(kd.this, u.a(), paramAnonymousString);
    }
    
    public final void c(String paramAnonymousString)
    {
      kd.a(kd.this, u.a(), paramAnonymousString);
    }
    
    public final void d(String paramAnonymousString)
    {
      kd.a(kd.this, u.a(), paramAnonymousString);
    }
  };
  private final hx.a aZ = new hx.a()
  {
    public final void a()
    {
      kd.this.S();
    }
    
    public final void a(int paramAnonymousInt)
    {
      kd.a(kd.this, paramAnonymousInt);
    }
    
    public final void a(String paramAnonymousString)
    {
      kd.this.l().runOnUiThread(kp.a(kd.this));
    }
    
    public final void a(String paramAnonymousString, boolean paramAnonymousBoolean)
    {
      kd.this.l().runOnUiThread(kq.a(this, paramAnonymousString, paramAnonymousBoolean));
    }
  };
  TextView aa;
  TextView ab;
  View ac;
  final ant ad = ant.a();
  final va ae = va.a();
  final w af = w.a();
  final ad ag = ad.a();
  final qz ah = qz.a();
  final aat ai = aat.a();
  final atv aj = atv.a();
  final hx ak = hx.a();
  boolean al = true;
  android.support.v7.view.b am;
  private ListView an;
  private ArrayList<k> ao;
  private String ap;
  private String aq;
  private int ar;
  private com.whatsapp.k.d as;
  private n at = null;
  private View au;
  private ImageView av;
  private ProgressBar aw;
  private TextView ax;
  private TextView ay;
  private GoogleDriveService az;
  private Set<String> ba = new HashSet();
  private Set<String> bb = new HashSet();
  private android.support.v7.view.b.a bc = new android.support.v7.view.b.a()
  {
    MenuItem a;
    MenuItem b;
    MenuItem c;
    MenuItem d;
    MenuItem e;
    MenuItem f;
    MenuItem g;
    MenuItem h;
    MenuItem i;
    MenuItem j;
    MenuItem k;
    MenuItem l;
    MenuItem m;
    MenuItem n;
    
    private void a()
    {
      Iterator localIterator = kd.q(kd.this).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        kd.p(kd.this).a(str, true);
      }
      kd.a(kd.this, 1);
    }
    
    private void b()
    {
      int i1 = kd.q(kd.this).size();
      if (kd.p(kd.this).f().size() + i1 > 3)
      {
        kd.l(kd.this);
        pv.a(kd.this.l(), u.a.a(2131230734, 3, new Object[] { Integer.valueOf(3) }), 0);
        return;
      }
      Iterator localIterator = kd.q(kd.this).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        kd.p(kd.this).a(str, true, true, -1L);
      }
      kd.a(kd.this, 1);
      kd.l(kd.this);
      pv.a(kd.this.l(), u.a.a(2131230788, i1), 0);
    }
    
    private void c()
    {
      int i1 = kd.q(kd.this).size();
      Iterator localIterator = kd.q(kd.this).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        kd.p(kd.this).a(str, false, true, -1L);
      }
      kd.a(kd.this, 1);
      kd.l(kd.this);
      pv.a(kd.this.l(), u.a.a(2131230811, i1), 0);
    }
    
    private void d()
    {
      Iterator localIterator = kd.q(kd.this).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        kd.L(kd.this).a(kd.i(kd.this), kd.K(kd.this), str);
        kd.K(kd.this).b();
      }
      kd.a(kd.this, 1);
    }
    
    private void e()
    {
      Iterator localIterator = kd.q(kd.this).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        kd.L(kd.this).a(kd.i(kd.this), str, true);
      }
      kd.a(kd.this, 1);
    }
    
    public final void a(android.support.v7.view.b paramAnonymousb)
    {
      kd.I(kd.this);
      kd.J(kd.this);
    }
    
    public final boolean a(android.support.v7.view.b paramAnonymousb, Menu paramAnonymousMenu)
    {
      this.a = paramAnonymousMenu.add(0, 2131755048, 0, null).setIcon(2130840069);
      this.b = paramAnonymousMenu.add(0, 2131755051, 0, null).setIcon(2130840083);
      this.e = paramAnonymousMenu.add(0, 2131755042, 0, null).setIcon(2130840058);
      this.g = paramAnonymousMenu.add(0, 2131755047, 0, null).setIcon(2130840067);
      this.h = paramAnonymousMenu.add(0, 2131755050, 0, null).setIcon(2130840082);
      this.c = paramAnonymousMenu.add(0, 2131755039, 0, null).setIcon(2130840049);
      this.d = paramAnonymousMenu.add(0, 2131755049, 0, null).setIcon(2130840080);
      this.f = paramAnonymousMenu.add(0, 2131755044, 0, null);
      this.i = paramAnonymousMenu.add(0, 2131755041, 0, kd.this.a(2131296301));
      this.j = paramAnonymousMenu.add(0, 2131755040, 0, kd.this.a(2131296515));
      this.k = paramAnonymousMenu.add(0, 2131755037, 0, kd.this.a(2131296292));
      this.l = paramAnonymousMenu.add(0, 2131755038, 0, kd.this.a(2131296296));
      this.n = paramAnonymousMenu.add(0, 2131755045, 0, kd.this.a(2131297136));
      this.m = paramAnonymousMenu.add(0, 2131755046, 0, kd.this.a(2131297137));
      o.a(this.a, 2);
      o.a(this.b, 2);
      o.a(this.c, 2);
      o.a(this.d, 2);
      o.a(this.e, 2);
      o.a(this.g, 2);
      o.a(this.h, 2);
      o.a(this.f, 8);
      o.a(this.i, 8);
      o.a(this.j, 8);
      o.a(this.k, 8);
      o.a(this.l, 8);
      o.a(this.n, 8);
      o.a(this.m, 8);
      return true;
    }
    
    public final boolean a(android.support.v7.view.b paramAnonymousb, MenuItem paramAnonymousMenuItem)
    {
      int i1 = paramAnonymousMenuItem.getItemId();
      if (i1 == 2131755039)
      {
        paramAnonymousb = new ArrayList(kd.q(kd.this));
        paramAnonymousMenuItem = kd.p(kd.this).f();
        kd.a(kd.this, 0);
        kd.f(kd.this).post(km.a(this, paramAnonymousb, paramAnonymousMenuItem));
        return true;
      }
      if (i1 == 2131755049)
      {
        paramAnonymousb = new ArrayList(kd.q(kd.this));
        kd.a(kd.this, 0);
        kd.f(kd.this).post(kn.a(this, paramAnonymousb));
        return true;
      }
      if (i1 == 2131755042)
      {
        kd.c(kd.this, kd.H(kd.this));
        if (!TextUtils.isEmpty(kd.h(kd.this)))
        {
          kd.d(kd.this, kd.h(kd.this));
          return true;
        }
        kd.b(kd.this, new kd.a());
        return true;
      }
      if (i1 == 2131755044)
      {
        kd.c(kd.this, kd.H(kd.this));
        if (!TextUtils.isEmpty(kd.h(kd.this)))
        {
          kd.d(kd.this, kd.h(kd.this));
          return true;
        }
        kd.b(kd.this, new kd.b());
        return true;
      }
      if (i1 == 2131755047)
      {
        kd.c(kd.this, kd.H(kd.this));
        if (!TextUtils.isEmpty(kd.h(kd.this)))
        {
          paramAnonymousb = kd.m(kd.this).d(kd.h(kd.this));
          kd.a(paramAnonymousb, aam.a(paramAnonymousb.t)).a(kd.this.n(), null);
          return true;
        }
        aam.a(new ArrayList(kd.q(kd.this))).a(kd.this.n(), null);
        return true;
      }
      if (i1 == 2131755050)
      {
        a();
        return true;
      }
      if (i1 == 2131755048)
      {
        b();
        return true;
      }
      if (i1 == 2131755051)
      {
        c();
        return true;
      }
      if (i1 == 2131755041)
      {
        kd.c(kd.this, kd.H(kd.this));
        if (!TextUtils.isEmpty(kd.h(kd.this)))
        {
          a.a.a.a.d.a(kd.this.k(), kd.m(kd.this).d(kd.h(kd.this)));
          kd.l(kd.this);
          pv.a(kd.this.l(), 2131296569, 1);
        }
        kd.a(kd.this, 2);
        return true;
      }
      if (i1 == 2131755040)
      {
        kd.c(kd.this, kd.H(kd.this));
        if (!TextUtils.isEmpty(kd.h(kd.this)))
        {
          paramAnonymousb = kd.m(kd.this).d(kd.h(kd.this));
          kd.a(kd.this, 2);
          if (paramAnonymousb.d != null)
          {
            ContactInfo.a(paramAnonymousb, kd.this.l());
            return true;
          }
          if (j.b(paramAnonymousb.t))
          {
            ListChatInfo.a(paramAnonymousb, kd.this.l());
            return true;
          }
          GroupChatInfo.a(paramAnonymousb, kd.this.l());
          return true;
        }
      }
      else if (i1 == 2131755037)
      {
        kd.c(kd.this, kd.H(kd.this));
        if (!TextUtils.isEmpty(kd.h(kd.this)))
        {
          paramAnonymousb = cs.b(kd.m(kd.this).d(kd.h(kd.this)).t);
          paramAnonymousMenuItem = new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI);
          paramAnonymousMenuItem.putExtra("phone", paramAnonymousb);
          paramAnonymousMenuItem.setComponent(paramAnonymousMenuItem.resolveActivity(kd.this.l().getPackageManager()));
          if (paramAnonymousMenuItem.getComponent() != null)
          {
            kd.a(kd.this, 2);
            kd.this.startActivityForResult(paramAnonymousMenuItem, 10);
            return true;
          }
          Log.w("conversations/context system contact list could not found");
          kd.l(kd.this).b();
          return true;
        }
      }
      else
      {
        if (i1 == 2131755038)
        {
          kd.c(kd.this, kd.H(kd.this));
          if (TextUtils.isEmpty(kd.h(kd.this))) {
            break label915;
          }
          paramAnonymousb = new Intent("android.intent.action.INSERT_OR_EDIT");
          paramAnonymousb.setType("vnd.android.cursor.item/contact");
          paramAnonymousb.putExtra("phone", kd.m(kd.this).d(kd.h(kd.this)).a(kd.this.l()));
          paramAnonymousb.putExtra("phone_type", 2);
          paramAnonymousb.setFlags(524288);
          try
          {
            kd.a(kd.this, 2);
            kd.this.startActivityForResult(paramAnonymousb, 11);
            return true;
          }
          catch (ActivityNotFoundException paramAnonymousb)
          {
            kd.l(kd.this);
            pv.a(kd.this.l(), 2131296289, 0);
            return true;
          }
        }
        if (i1 == 2131755045)
        {
          d();
          return true;
        }
        if (i1 == 2131755046)
        {
          e();
          return true;
        }
      }
      label915:
      return false;
    }
    
    public final boolean b(android.support.v7.view.b paramAnonymousb, Menu paramAnonymousMenu)
    {
      if (!kd.this.o())
      {
        Log.i("conversations/actionmode/fragment is not attached to activity.");
        return false;
      }
      if ((kd.q(kd.this) == null) || (kd.q(kd.this).isEmpty()))
      {
        paramAnonymousb.c();
        return true;
      }
      int i1 = kd.q(kd.this).size();
      paramAnonymousb.b(String.format(kd.y(kd.this).b(), "%d", new Object[] { Integer.valueOf(i1) }));
      this.c.setTitle(u.a.a(2131230723, i1));
      this.d.setTitle(u.a.a(2131230731, i1));
      this.e.setTitle(u.a.a(2131230725, i1));
      this.g.setTitle(u.a.a(2131230729, i1));
      this.h.setTitle(u.a.a(2131230732, i1));
      this.f.setTitle(u.a.a(2131230727, i1));
      this.a.setTitle(u.a.a(2131230730, i1));
      this.b.setTitle(u.a.a(2131230733, i1));
      int i6 = aic.g();
      int i7 = aic.g();
      int i2;
      label301:
      int i9;
      label320:
      int i11;
      int i12;
      int i4;
      int i5;
      int i14;
      int i3;
      int i13;
      int i10;
      boolean bool4;
      label365:
      Object localObject;
      int i15;
      if (kd.q(kd.this).size() == 1)
      {
        i2 = 1;
        if (kd.q(kd.this).size() != 1) {
          break label740;
        }
        i8 = 1;
        if (kd.q(kd.this).size() != 1) {
          break label746;
        }
        i9 = 1;
        paramAnonymousb = kd.q(kd.this).iterator();
        i11 = 1;
        i12 = 1;
        i4 = 1;
        i5 = 1;
        i14 = 1;
        i3 = 1;
        i13 = 1;
        i10 = 1;
        bool4 = i2;
        i2 = i14;
        if (!paramAnonymousb.hasNext()) {
          break label1062;
        }
        paramAnonymousMenu = (String)paramAnonymousb.next();
        localObject = kd.m(kd.this).d(paramAnonymousMenu);
        if ((!"broadcast".equals(paramAnonymousMenu)) && (!cs.d(((cs)localObject).t))) {
          break label1301;
        }
        i4 &= 0x1;
        i5 = 0;
        i2 = 0;
        i3 = 0;
        i13 = 0;
        i12 = 0;
        bool4 = false;
        i14 = 0;
        i15 = 0;
        i9 = 0;
        i10 = 0;
        i11 = 0;
      }
      label534:
      int i16;
      for (int i8 = 0;; i8 = i16)
      {
        label554:
        boolean bool1;
        label578:
        boolean bool2;
        if (((cs)localObject).d == null) {
          if (j.b(((cs)localObject).t))
          {
            this.j.setTitle(kd.this.a(2131297090));
            i3 = 0;
            i2 = i14 & 0x1;
            i14 = 0;
            bool4 = false;
            i7 = 0;
            i5 = 0;
            i6 = i4 & 0x1;
            i4 = i3;
            i3 = i14;
            i16 = kd.t(kd.this).d(paramAnonymousMenu);
            if (i16 != 0) {
              break label1033;
            }
            i1 = 1;
            i17 = kd.p(kd.this).a(paramAnonymousMenu).b();
            if (i17 != 0) {
              break label1038;
            }
            bool1 = true;
            i14 = kd.p(kd.this).a(paramAnonymousMenu).m;
            if ((i16 != 0) || (i14 != 0)) {
              break label1044;
            }
            bool2 = true;
            label607:
            i13 &= bool2;
            i15 = i12 & i14;
            if (kd.i(kd.this).o(paramAnonymousMenu) != 0) {
              break label1050;
            }
            bool2 = true;
            label638:
            if (bool2) {
              break label1056;
            }
          }
        }
        label740:
        label746:
        label1033:
        label1038:
        label1044:
        label1050:
        label1056:
        for (boolean bool3 = true;; bool3 = false)
        {
          i14 = i11 & i1;
          i12 = i10 & i16;
          i11 = i6;
          i16 = i7 & bool1;
          i17 = bool4 & i17;
          i18 = i9 & bool3;
          i10 = i8 & bool2;
          i8 = i2;
          i9 = i3;
          bool4 = i4;
          i7 = i15;
          i6 = i13;
          i13 = i18;
          i3 = i17;
          i2 = i16;
          i4 = i11;
          i11 = i14;
          break label365;
          i2 = 0;
          break;
          i8 = 0;
          break label301;
          i9 = 0;
          break label320;
          if (((cs)localObject).d())
          {
            this.j.setTitle(kd.this.a(2131296986));
            if (kd.n(kd.this).b(paramAnonymousMenu))
            {
              i4 = i5 & 0x1;
              i6 = 0;
            }
            for (;;)
            {
              i15 = i3;
              i7 = i2;
              i5 = i4;
              i3 = 0;
              i2 = i14 & 0x1;
              i4 = bool4 & true;
              bool4 = i15;
              break;
              i6 = i4 & 0x1;
              i4 = 0;
            }
          }
          if (e.b(((cs)localObject).t))
          {
            i15 = 0;
            i5 = 0;
            i16 = 0;
            bool4 = i3;
            i7 = i2;
            i14 = 0;
            i6 = i4;
            i2 = i16;
            i3 = i15;
            i4 = i5;
            i5 = i14;
            break label534;
          }
          i5 = bool4 & true;
          i16 = 0;
          i15 &= 0x1;
          bool4 = i3;
          i7 = i2;
          i6 = 0;
          i14 = i4 & 0x1;
          i2 = i16;
          i3 = i15;
          i4 = i5;
          i5 = i6;
          i6 = i14;
          break label534;
          this.j.setTitle(kd.this.a(2131298120));
          i5 = bool4 & true;
          i16 = i14 & 0x1;
          i15 = 0;
          bool4 = i3;
          i7 = i2;
          i6 = 0;
          i14 = i4 & 0x1;
          i2 = i16;
          i3 = i15;
          i4 = i5;
          i5 = i6;
          i6 = i14;
          break label534;
          i1 = 0;
          break label554;
          bool1 = false;
          break label578;
          bool2 = false;
          break label607;
          bool2 = false;
          break label638;
        }
        label1062:
        this.a.setVisible(i6);
        this.b.setVisible(i7);
        this.c.setVisible(i11);
        this.d.setVisible(i12);
        this.e.setVisible(i4);
        this.f.setVisible(i5);
        this.g.setVisible(i2);
        this.h.setVisible(i3);
        this.i.setVisible(bool4);
        this.j.setVisible(i8);
        this.k.setVisible(i9);
        this.l.setVisible(i9);
        this.m.setVisible(i10);
        this.n.setVisible(i13);
        paramAnonymousb = kd.this.l().findViewById(2131755200);
        if ((Build.VERSION.SDK_INT >= 19) && (paramAnonymousb != null))
        {
          paramAnonymousMenu = kd.this.l().getWindowManager().getDefaultDisplay();
          localObject = new Point();
          paramAnonymousMenu.getSize((Point)localObject);
          paramAnonymousb.getLayoutParams().width = ((Point)localObject).x;
        }
        return true;
        label1301:
        int i17 = i13;
        int i18 = i12;
        i16 = i10;
        i14 = i8;
        i15 = i9;
        i12 = i7;
        i13 = i6;
        i9 = i17;
        i10 = i18;
      }
    }
  };
  e i;
  
  private void V()
  {
    startActivityForResult(new Intent(l(), ContactPicker.class), 12);
  }
  
  private void W()
  {
    Object localObject = x();
    TextView localTextView;
    ViewGroup localViewGroup;
    if (localObject != null)
    {
      int j = this.aH.d();
      localTextView = (TextView)((View)localObject).findViewById(2131755649);
      localViewGroup = (ViewGroup)((View)localObject).findViewById(2131755650);
      localObject = (ViewGroup)((View)localObject).findViewById(2131755651);
      if (j > 0)
      {
        localTextView.setVisibility(0);
        this.an.setEmptyView(localTextView);
        localViewGroup.setVisibility(8);
        ((ViewGroup)localObject).setVisibility(8);
        localTextView.setText(bh.a(m().getString(2131298203), android.support.v4.content.b.a(k(), 2130840219), localTextView.getPaint()));
      }
    }
    else
    {
      return;
    }
    if (this.aP.d())
    {
      localViewGroup.setVisibility(0);
      if (localViewGroup.getChildCount() == 0)
      {
        al.a(this.aB, l().getLayoutInflater(), 2130903221, localViewGroup, true);
        localViewGroup.findViewById(2131755770).setOnClickListener(new at()
        {
          public final void a(View paramAnonymousView)
          {
            pb.a(22, Integer.valueOf(6));
            kd.g(kd.this).a(kd.this.l());
          }
        });
      }
      localViewGroup.setVisibility(0);
      ((ViewGroup)localObject).setVisibility(8);
      this.an.setEmptyView(localViewGroup);
    }
    for (;;)
    {
      localTextView.setVisibility(8);
      return;
      if (((ViewGroup)localObject).getChildCount() == 0)
      {
        al.a(this.aB, l().getLayoutInflater(), 2130903220, (ViewGroup)localObject, true);
        ((ViewGroup)localObject).findViewById(2131755769).setOnClickListener(new at()
        {
          public final void a(View paramAnonymousView)
          {
            a.a.a.a.d.d(kd.this.l());
          }
        });
      }
      ((ViewGroup)localObject).setVisibility(0);
      localViewGroup.setVisibility(8);
      this.an.setEmptyView((View)localObject);
    }
  }
  
  private void X()
  {
    Y();
    if (this.am != null) {
      this.am.d();
    }
    if (this.i != null) {
      this.i.notifyDataSetChanged();
    }
  }
  
  private void Y()
  {
    if ((this.ao == null) || (this.ao.isEmpty()) || (((this.ba == null) || (this.ba.isEmpty())) && ((this.bb == null) || (this.bb.isEmpty())))) {
      return;
    }
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    Iterator localIterator = this.ao.iterator();
    while (localIterator.hasNext())
    {
      String str = ((k)localIterator.next()).a();
      if (this.ba.contains(str)) {
        localHashSet1.add(str);
      }
      if (this.bb.contains(str)) {
        localHashSet2.add(str);
      }
    }
    this.ba = localHashSet1;
    this.bb = localHashSet2;
  }
  
  private View a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int j = 0;
    while (j < this.an.getChildCount())
    {
      View localView = this.an.getChildAt(j);
      Object localObject = localView.getTag();
      if ((localObject instanceof p))
      {
        localObject = (p)localObject;
        if (((((p)localObject).o instanceof d)) && (paramString.equals(((d)((p)localObject).o).a))) {
          return localView;
        }
      }
      j += 1;
    }
    return null;
  }
  
  private void b(final cs paramcs, final android.support.v4.app.m paramm)
  {
    ((ng)l()).a(2131297488, 2131297592);
    bu.a(new AsyncTask() {}, new Object[0]);
  }
  
  private static void b(nh paramnh, List<cs> paramList)
  {
    paramnh.g(2131297592);
    bu.a(new AsyncTask()
    {
      private final ant d = ant.a();
      private final va e = va.a();
      private final w f = w.a();
      private final aoj g = aoj.a();
      private final ad h = ad.a();
      private final qz i = qz.a();
      private final atv j = atv.a();
      private final hx k = hx.a();
      
      protected final void onPostExecute(Object paramAnonymousObject)
      {
        if (!this.c.isFinishing()) {
          nh.h.a(this.c.aS);
        }
        paramAnonymousObject = this.a.iterator();
        while (((Iterator)paramAnonymousObject).hasNext())
        {
          cs localcs = (cs)((Iterator)paramAnonymousObject).next();
          if (j.b(localcs.t)) {
            this.f.g(new rj(this.d, this.e, this.h, this.i, this.k, localcs.t, null, null, 60, null));
          }
        }
        this.j.c(this.j.r() + this.a.size());
        this.k.a(0);
      }
    }, new Object[0]);
  }
  
  private void b(String paramString)
  {
    paramString = this.aH.d(paramString);
    if (paramString.d())
    {
      Log.i("conversations/delete/group:" + paramString);
      if (this.ah.b)
      {
        pv.a(l(), 2131297020, 0);
        return;
      }
      if ((this.aT.b(paramString.t)) && (!cs.d(paramString.t)))
      {
        b(paramString, new j());
        return;
      }
      c(paramString, new i()).a(n(), null);
      return;
    }
    if (j.b(paramString.t))
    {
      c(paramString, new g()).a(n(), null);
      return;
    }
    b(paramString, new h());
  }
  
  private static android.support.v4.app.m c(cs paramcs, android.support.v4.app.m paramm)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("jid", paramcs.t);
    paramm.f(localBundle);
    return paramm;
  }
  
  private void e(int paramInt)
  {
    f(paramInt);
    if (this.am != null) {
      this.am.c();
    }
    if (paramInt == 1) {
      X();
    }
  }
  
  private void f(int paramInt)
  {
    if (this.ba.isEmpty()) {
      return;
    }
    int j;
    if (paramInt <= 2)
    {
      j = paramInt;
      if (paramInt >= 0) {}
    }
    else
    {
      Log.w("conversations/undefined animation behaviour. defaulting to IMMEDIATELY_ANIMATE");
      j = 2;
    }
    this.bb.clear();
    paramInt = 0;
    if (paramInt < this.an.getChildCount())
    {
      Object localObject = this.an.getChildAt(paramInt);
      if (localObject != null)
      {
        localObject = (p)((View)localObject).getTag();
        if ((localObject != null) && (this.ba.contains(((p)localObject).o.a()))) {
          switch (j)
          {
          }
        }
      }
      for (;;)
      {
        paramInt += 1;
        break;
        ((p)localObject).p.setBackgroundResource(0);
        ((p)localObject).q.a(false, false);
        continue;
        this.bb.add(((p)localObject).o.a());
        continue;
        ((p)localObject).p.setBackgroundResource(0);
        ((p)localObject).q.a(false, true);
      }
    }
    this.ba.clear();
  }
  
  public final void A()
  {
    Log.i("conversations/destroy");
    super.A();
    this.aX.unregisterObserver(this.aY);
    this.ak.unregisterObserver(this.aZ);
    this.aV.a();
    if ((this.az != null) && (this.aA != null)) {
      this.az.b(this.aA);
    }
  }
  
  protected void R()
  {
    this.ar = this.aQ.e();
    Object localObject;
    int j;
    if (this.ar > 0)
    {
      this.aa.setText(a(2131296330, new Object[] { Integer.valueOf(this.ar) }));
      this.aa.setVisibility(0);
      localObject = this.ab;
      j = 8;
      label63:
      ((TextView)localObject).setVisibility(j);
      j = this.aj.s();
      long l = this.aj.a.getLong("create_group_tip_time", 0L);
      if ((this.aQ.g()) || (this.aQ.i() <= 2) || (j >= 3) || (l + 2592000000L >= System.currentTimeMillis())) {
        break label190;
      }
      this.ac.setVisibility(0);
      a.a.a.a.d.e(u.a(), Boolean.valueOf(true));
    }
    label190:
    do
    {
      return;
      this.aa.setVisibility(8);
      TextView localTextView = this.ab;
      localObject = localTextView;
      if (this.aj.r() >= 3) {
        break;
      }
      localObject = localTextView;
      j = 0;
      break label63;
      this.ac.setVisibility(8);
    } while (j <= 0);
    a.a.a.a.d.e(u.a(), Boolean.valueOf(true));
  }
  
  protected void S()
  {
    if (this.i != null)
    {
      if (!TextUtils.isEmpty(e.a(this.i))) {
        break label72;
      }
      this.ao = c();
    }
    for (;;)
    {
      R();
      Y();
      if (this.am != null) {
        this.am.d();
      }
      this.i.notifyDataSetChanged();
      if (this.i.getCount() == 0) {
        W();
      }
      return;
      label72:
      this.i.getFilter().filter(e.a(this.i));
    }
  }
  
  public final void T()
  {
    this.al = true;
  }
  
  public final void U()
  {
    this.al = false;
  }
  
  public final View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    this.as.a(d.e.c);
    paramLayoutInflater = paramLayoutInflater.inflate(2130903179, paramViewGroup, false);
    paramViewGroup = (ListView)paramLayoutInflater.findViewById(16908298);
    Object localObject = l().getLayoutInflater().inflate(2130903184, paramViewGroup, false);
    paramViewGroup.addFooterView((View)localObject, null, true);
    this.ab = ((TextView)((View)localObject).findViewById(2131755670));
    localObject = l().getLayoutInflater().inflate(2130903184, paramViewGroup, false);
    ((View)localObject).setBackgroundResource(2130840501);
    ((View)localObject).setOnClickListener(ke.a(this));
    paramViewGroup.addFooterView((View)localObject, null, true);
    this.aa = ((TextView)((View)localObject).findViewById(2131755670));
    HomeActivity.a(paramLayoutInflater, this);
    this.ac = al.a(this.aB, l().getLayoutInflater(), 2130903180, paramViewGroup, false);
    this.ac.setBackgroundResource(2130840501);
    aoa.b((TextView)this.ac.findViewById(2131755652));
    ((ImageView)this.ac.findViewById(2131755363)).setImageBitmap(cs.b(2130840406));
    localObject = new FrameLayout(l());
    ((FrameLayout)localObject).setBackgroundColor(-11684180);
    ((FrameLayout)localObject).addView(this.ac);
    ((FrameLayout)localObject).setOnClickListener(kf.a(this));
    this.ac.findViewById(2131755378).setOnClickListener(kg.a(this));
    paramViewGroup.addHeaderView((View)localObject, null, true);
    this.as.b(d.e.c);
    return paramLayoutInflater;
  }
  
  public final void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        return;
      } while (paramInt2 != -1);
      paramIntent = paramIntent.getStringExtra("contact");
      paramIntent = Conversation.a(this.aH.d(paramIntent));
      paramIntent.putExtra("show_keyboard", true);
      paramIntent.putExtra("start_t", SystemClock.uptimeMillis());
      a(paramIntent);
      return;
      this.aK.b();
      return;
    } while (paramInt2 != -1);
    V();
  }
  
  public final void a(Context paramContext)
  {
    Log.i("conversations/attach");
    super.a(paramContext);
    if (this.am != null) {
      this.am.d();
    }
  }
  
  public final void a(Bundle paramBundle)
  {
    this.as = com.whatsapp.k.c.a("ConversationFragmentInit");
    this.as.a();
    this.as.a(d.e.b);
    super.a(paramBundle);
    this.as.b(d.e.b);
  }
  
  public final void a(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    super.a(paramMenu, paramMenuInflater);
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    this.i.getFilter().filter(paramCharSequence);
  }
  
  final void a(String paramString, View paramView, SelectionCheckView paramSelectionCheckView)
  {
    if (!this.al) {}
    for (;;)
    {
      return;
      if (this.ba.contains(paramString))
      {
        this.ba.remove(paramString);
        if ((this.ba.isEmpty()) && (this.am != null)) {
          e(2);
        }
        paramView.setBackgroundResource(0);
        paramSelectionCheckView.a(false, true);
      }
      while (this.am != null)
      {
        this.am.d();
        return;
        this.ba.add(paramString);
        if ((this.am == null) && ((l() instanceof android.support.v7.app.c))) {
          this.am = ((android.support.v7.app.c)l()).a(this.bc);
        }
        paramView.setBackgroundResource(2131624041);
        paramSelectionCheckView.a(true, true);
      }
    }
  }
  
  public final void a(boolean paramBoolean) {}
  
  public final boolean a(MenuItem paramMenuItem)
  {
    boolean bool = false;
    if (paramMenuItem.getItemId() == 2131755062)
    {
      k_();
      bool = true;
      return bool;
    }
    if (paramMenuItem.getItemId() == 2131755059)
    {
      a(new Intent(l(), ListMembersSelector.class));
      return true;
    }
    int j;
    if (paramMenuItem.getItemId() == 2131755063)
    {
      paramMenuItem = this.aQ.j().iterator();
      j = 0;
      label79:
      if (paramMenuItem.hasNext())
      {
        String str = (String)paramMenuItem.next();
        if ((!qz.e(str)) || (!str.equals(this.ae.b() + "@s.whatsapp.net")) || (cs.d(str))) {
          break label344;
        }
        j += 1;
      }
    }
    label344:
    for (;;)
    {
      break label79;
      if (j >= aic.p)
      {
        paramMenuItem = a(2131296952, new Object[] { Integer.valueOf(aic.p) });
        ((ng)l()).d(paramMenuItem);
        return true;
      }
      NewGroup.a(l(), 2, null);
      return true;
      if (paramMenuItem.getItemId() == 2131755071)
      {
        if (auj.d()) {
          a(new Intent(l(), WebSessionsActivity.class));
        }
        for (;;)
        {
          return true;
          if (!this.ai.b()) {
            break;
          }
          a(new Intent(l(), QrCodeActivity.class));
        }
        if (aat.a(l())) {}
        for (j = 2131297244;; j = 2131297243)
        {
          pv.a(l(), j, 0);
          break;
        }
      }
      if (paramMenuItem.getItemId() != 2131755078) {
        break;
      }
      a(new Intent(l(), StarredMessagesActivity.class));
      return true;
    }
  }
  
  public final boolean b(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131755040)
    {
      paramMenuItem = this.aH.d(this.ap);
      if (paramMenuItem.d != null) {
        ContactInfo.a(paramMenuItem, l());
      }
      return true;
    }
    if (paramMenuItem.getItemId() == 2131755042)
    {
      b(this.ap);
      return true;
    }
    Object localObject;
    if (paramMenuItem.getItemId() == 2131755037)
    {
      paramMenuItem = this.aH.d(this.ap);
      localObject = new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI);
      if (paramMenuItem.f()) {
        ((Intent)localObject).putExtra("name", paramMenuItem.j());
      }
      ((Intent)localObject).putExtra("phone", cs.b(paramMenuItem.t));
      ((Intent)localObject).setComponent(((Intent)localObject).resolveActivity(l().getPackageManager()));
      if (((Intent)localObject).getComponent() != null)
      {
        startActivityForResult((Intent)localObject, 10);
        return true;
      }
      Log.w("conversations/context system contact list could not found");
      this.aB.b();
      return true;
    }
    if (paramMenuItem.getItemId() == 2131755038)
    {
      paramMenuItem = new Intent("android.intent.action.INSERT_OR_EDIT");
      paramMenuItem.setType("vnd.android.cursor.item/contact");
      paramMenuItem.putExtra("phone", this.aH.d(this.ap).a(l()));
      paramMenuItem.putExtra("phone_type", 2);
      paramMenuItem.setFlags(524288);
      try
      {
        startActivityForResult(paramMenuItem, 11);
        return true;
      }
      catch (ActivityNotFoundException paramMenuItem)
      {
        pv.a(l(), 2131296289, 0);
        return true;
      }
    }
    if (paramMenuItem.getItemId() == 2131755048)
    {
      if (this.aL.f().size() + 1 > 3)
      {
        pv.a(l(), u.a.a(2131230734, 3, new Object[] { Integer.valueOf(3) }), 0);
        return true;
      }
      this.aL.a(this.ap, true, true, -1L);
      pv.a(l(), u.a.a(2131230788, 1), 0);
      return true;
    }
    if (paramMenuItem.getItemId() == 2131755051)
    {
      this.aL.a(this.ap, false, true, -1L);
      pv.a(l(), u.a.a(2131230811, 1), 0);
      return true;
    }
    if (paramMenuItem.getItemId() == 2131755047)
    {
      paramMenuItem = this.aH.d(this.ap);
      c(paramMenuItem, aam.a(paramMenuItem.t)).a(n(), null);
      return true;
    }
    if (paramMenuItem.getItemId() == 2131755050)
    {
      this.aL.a(this.ap, true);
      return true;
    }
    if (paramMenuItem.getItemId() == 2131755039)
    {
      pb.a(26);
      paramMenuItem = ((AdapterView.AdapterContextMenuInfo)paramMenuItem.getMenuInfo()).targetView;
      localObject = new AnimationSet(true);
      ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      ((AnimationSet)localObject).addAnimation(localScaleAnimation);
      ((AnimationSet)localObject).addAnimation(localAlphaAnimation);
      final int j = paramMenuItem.getTop();
      ((AnimationSet)localObject).setDuration(300L);
      paramMenuItem.startAnimation((Animation)localObject);
      ((AnimationSet)localObject).setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          kd.f(kd.this).post(new Runnable()
          {
            public final void run()
            {
              kd.i(kd.this).a(kd.h(kd.this), true, true);
              Bundle localBundle = new Bundle();
              localBundle.putString("jid", kd.h(kd.this));
              a.b localb = new a.b(kd.this.l());
              localb.b = localb.a.getText(2131296555);
              localb.d = new kr(this);
              localb.c = localBundle;
              localb.a();
              kd.f(kd.this).getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
              {
                public final void onGlobalLayout()
                {
                  kd.f(kd.this).getViewTreeObserver().removeGlobalOnLayoutListener(this);
                  kd.this.d(kd.9.this.a);
                }
              });
            }
          });
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      return true;
    }
    if (paramMenuItem.getItemId() == 2131755049)
    {
      c(((AdapterView.AdapterContextMenuInfo)paramMenuItem.getMenuInfo()).targetView);
      return true;
    }
    if (paramMenuItem.getItemId() == 2131755045)
    {
      this.aS.a(this.ag, this.aO, this.ap);
      this.aO.b();
      return true;
    }
    if (paramMenuItem.getItemId() == 2131755046)
    {
      this.aS.a(this.ag, this.ap, true);
      return true;
    }
    if (paramMenuItem.getItemId() == 2131755041)
    {
      a.a.a.a.d.a(k(), this.aH.d(this.ap));
      pv.a(l(), 2131296569, 1);
      return true;
    }
    if (paramMenuItem.getItemId() == 2131755043)
    {
      paramMenuItem = this.aH.d(this.ap);
      if (j.b(paramMenuItem.t))
      {
        ListChatInfo.a(paramMenuItem, l());
        return true;
      }
      GroupChatInfo.a(paramMenuItem, l());
      return true;
    }
    return super.b(paramMenuItem);
  }
  
  protected ArrayList<k> c()
  {
    Object localObject = this.aQ.a(this.aL);
    ArrayList localArrayList = new ArrayList(((ArrayList)localObject).size());
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(new d((String)((Iterator)localObject).next()));
    }
    return localArrayList;
  }
  
  protected void c(View paramView)
  {
    this.ag.a(this.ap, false, true);
  }
  
  protected final void d(int paramInt)
  {
    int k;
    if (this.an.getLastVisiblePosition() < this.an.getAdapter().getCount() - 1)
    {
      int m = this.an.getChildCount();
      k = 0;
      int j = 0;
      if (k < m)
      {
        View localView = this.an.getChildAt(k);
        if (localView.getTop() < paramInt) {
          break label131;
        }
        TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
        localTranslateAnimation.setDuration(150L);
        localTranslateAnimation.setStartOffset((int)Math.sqrt(j * 300) * 8);
        localTranslateAnimation.setFillAfter(false);
        localView.startAnimation(localTranslateAnimation);
        j += 1;
      }
    }
    label131:
    for (;;)
    {
      k += 1;
      break;
      return;
    }
  }
  
  public final void d(Bundle paramBundle)
  {
    bd localbd = new bd("conversations/create");
    this.as.a(d.e.d);
    super.d(paramBundle);
    s();
    if (this.at == null)
    {
      this.at = new n((byte)0);
      this.at.a = a(2131297019);
      this.at.b = a(2131296950);
      this.at.c = a(2131296951);
      this.at.d = a(2131296577);
      this.at.e = a(2131296570);
      this.at.f = a(2131296585);
      this.at.g = a(2131296581);
      this.at.h = a(2131296576);
      this.at.i = a(2131296579);
      this.at.j = a(2131296578);
      this.at.k = a(2131296572);
      this.at.l = a(2131296573);
      this.at.m = a(2131296575);
      this.at.n = a(2131297017);
    }
    Log.i("conversations/create");
    bu.a(anf.a(this.aN));
    this.aX.registerObserver(this.aY);
    this.ak.registerObserver(this.aZ);
    this.ao = c();
    this.an = b();
    this.an.setDivider(new az(m().getDrawable(2130837766)));
    ListView localListView = this.an;
    if (Build.VERSION.SDK_INT < 11) {}
    for (boolean bool = true;; bool = false)
    {
      localListView.setFastScrollEnabled(bool);
      if (Build.VERSION.SDK_INT < 11) {
        this.an.setSelector(2130840501);
      }
      this.an.setScrollbarFadingEnabled(true);
      R();
      this.an.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          if (paramAnonymousInt != 0) {
            com.whatsapp.util.undobar.a.a(kd.this.l());
          }
        }
      });
      if ((GoogleDriveService.c()) && ((ch.c(this.aj)) || (av.d())))
      {
        this.au = al.a(this.aB, l().getLayoutInflater(), 2130903181, this.an, false);
        this.an.addHeaderView(this.au);
        this.an.findViewById(2131755654).setVisibility(8);
      }
      this.i = new e((byte)0);
      this.an.setAdapter(this.i);
      this.an.setOnItemClickListener(kh.a(this));
      this.an.setOnItemLongClickListener(ki.a(this));
      if (this.i.getCount() == 0) {
        W();
      }
      a(this.an);
      if (paramBundle != null)
      {
        this.ap = paramBundle.getString("LongPressedRowJid");
        if (this.al)
        {
          paramBundle = paramBundle.getStringArrayList("SelectedRowJids");
          if (paramBundle != null)
          {
            this.ba.clear();
            this.ba.addAll(paramBundle);
            if (!this.ba.isEmpty()) {
              this.am = ((android.support.v7.app.c)l()).a(this.bc);
            }
          }
        }
      }
      localbd.b();
      if ((GoogleDriveService.c()) && (GoogleDriveNewUserSetupActivity.a(this.aD, this.aF, this.ag, this.aU, this.aj))) {
        a(new Intent(l(), GoogleDriveNewUserSetupActivity.class));
      }
      this.as.b(d.e.d);
      if (!this.i.isEmpty()) {
        break;
      }
      this.as.a(d.b.b, 0);
      this.as.b();
      return;
    }
    this.as.a(d.b.b, this.i.getCount());
    a.a.a.a.d.a(b(), this.as);
    a.a.a.a.d.b(b(), this.as);
  }
  
  public final void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    paramBundle.putString("LongPressedRowJid", this.ap);
    paramBundle.putStringArrayList("SelectedRowJids", new ArrayList(this.ba));
  }
  
  public final void k_()
  {
    if (this.aP.d())
    {
      V();
      return;
    }
    RequestPermissionActivity.a(this, 2131297379, 2131297380);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.am != null) {
      this.am.d();
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramView = (p)((AdapterView.AdapterContextMenuInfo)paramContextMenuInfo).targetView.getTag();
    if (paramView == null) {
      Log.i("conversations/context/null");
    }
    cs localcs;
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramView.o instanceof d));
        paramContextMenuInfo = ((d)paramView.o).a;
        this.ap = paramContextMenuInfo;
        localcs = this.aH.d(this.ap);
        if ("broadcast".equals(paramContextMenuInfo))
        {
          paramContextMenu.add(0, 2131755042, 0, a(2131296638));
          return;
        }
        if (!cs.d(localcs.t)) {
          break;
        }
      } while (this.ah.d(localcs.t));
      paramContextMenu.add(0, 2131755042, 0, a(2131296644));
      return;
      if (!j.b(localcs.t)) {
        paramContextMenu.add(0, 2131755041, 0, a(2131296301));
      }
      if (localcs.d != null) {
        break label498;
      }
      if (!localcs.d()) {
        break;
      }
    } while (paramView.b.getVisibility() == 0);
    paramContextMenu.add(0, 2131755043, 0, a(2131296986));
    int j;
    if (localcs.d()) {
      if (this.aT.b(localcs.t))
      {
        j = 2131296769;
        label250:
        paramContextMenu.add(0, 2131755042, 0, a(j));
        label268:
        if (!this.aC.d(localcs.t)) {
          break label605;
        }
        if (!j.b(localcs.t)) {
          break label583;
        }
        paramContextMenu.add(0, 2131755049, 0, a(2131298055));
        label313:
        if (!this.aL.a(this.ap).b()) {
          break label660;
        }
        paramContextMenu.add(0, 2131755050, 0, a(2131297146));
        label349:
        aic.g();
        if (!this.aL.a(this.ap).m) {
          break label682;
        }
        paramContextMenu.add(0, 2131755051, 0, a(2131297161));
      }
    }
    for (;;)
    {
      if (this.ag.o(localcs.t) == 0) {
        break label704;
      }
      paramContextMenu.add(0, 2131755045, 0, a(2131297136));
      return;
      if (j.b(localcs.t))
      {
        paramContextMenu.add(0, 2131755043, 0, a(2131297090));
        break;
      }
      paramContextMenu.add(0, 2131755037, 0, a(2131296292));
      paramContextMenu.add(0, 2131755038, 0, a(2131296296));
      break;
      label498:
      paramContextMenu.add(0, 2131755040, 0, a(2131298120));
      break;
      j = 2131296644;
      break label250;
      if (j.b(localcs.t))
      {
        paramContextMenu.add(0, 2131755042, 0, a(2131296647));
        break label268;
      }
      paramContextMenu.add(0, 2131755042, 0, a(2131296639));
      break label268;
      label583:
      paramContextMenu.add(0, 2131755049, 0, a(2131298056));
      break label313;
      label605:
      if (j.b(localcs.t))
      {
        paramContextMenu.add(0, 2131755039, 0, a(2131296327));
        break label313;
      }
      paramContextMenu.add(0, 2131755039, 0, a(2131296328));
      break label313;
      label660:
      paramContextMenu.add(0, 2131755047, 0, a(2131297145));
      break label349;
      label682:
      paramContextMenu.add(0, 2131755048, 0, a(2131297152));
    }
    label704:
    paramContextMenu.add(0, 2131755046, 0, a(2131297137));
  }
  
  public final void y()
  {
    Log.i("conversations/resume");
    super.y();
    this.aM.a.clear();
    this.aJ.b();
    if (GoogleDriveService.c())
    {
      Object localObject = this.an.findViewById(2131755654);
      if (localObject != null)
      {
        if (((View)localObject).getVisibility() != 8) {
          break label302;
        }
        if (ch.c(this.aj))
        {
          ((View)localObject).setVisibility(0);
          Log.i("conversations/gdrive-header/gdrive-media-restore-pending/show-view");
          l().bindService(new Intent(l(), GoogleDriveService.class), this.aW, 1);
          this.au.setVisibility(0);
          this.an.setHeaderDividersEnabled(true);
          this.av = ((ImageView)this.an.findViewById(2131755655));
          this.aw = ((ProgressBar)this.an.findViewById(2131755274));
          a.a.a.a.d.a(this.aw, android.support.v4.content.b.c(k(), 2131624069));
          this.ax = ((TextView)this.an.findViewById(2131755656));
          aoa.b(this.ax);
          this.ay = ((TextView)this.an.findViewById(2131755657));
          this.av.setImageResource(2130840180);
          localObject = this.av;
          ax localax = new ax();
          localax.setDuration(2000L);
          localax.setRepeatCount(-1);
          localax.setInterpolator(new LinearInterpolator());
          localax.a();
          ((ImageView)localObject).setAnimation(localax);
          this.au.setOnClickListener(kj.a(this));
        }
      }
    }
    for (;;)
    {
      W();
      if (this.am != null)
      {
        Y();
        this.am.d();
      }
      return;
      label302:
      if (!ch.c(this.aj))
      {
        Log.i("conversations/resume/gdrive-header/gdrive-media-restore-done/hide-view");
        this.an.findViewById(2131755654).setVisibility(8);
        l().unbindService(this.aW);
      }
    }
  }
  
  public final void z()
  {
    Log.i("conversations/pause");
    super.z();
    com.whatsapp.util.undobar.a.a(l());
  }
  
  public static final class a
    extends android.support.v4.app.m
  {
    final e aa = e.a();
    
    public final Dialog c(Bundle paramBundle)
    {
      Object localObject = i().getStringArrayList("selection_jids");
      paramBundle = (Bundle)localObject;
      if (localObject == null) {
        paramBundle = new ArrayList();
      }
      int i = i().getInt("unsentCount", 0);
      int j = paramBundle.size();
      String str = u.a.a(2131230726, j, new Object[] { Integer.valueOf(j) });
      localObject = str;
      if (i > 0) {
        localObject = str + "\n" + u.a.a(2131230813, i, new Object[] { Integer.valueOf(i) });
      }
      return new android.support.v7.app.b.a(l()).b(com.whatsapp.emoji.c.a((CharSequence)localObject, l().getBaseContext())).a(true).b(2131296398, ks.a(this)).a(2131296609, kt.a(this, paramBundle)).a();
    }
  }
  
  public static final class b
    extends android.support.v4.app.m
  {
    final ant aa = ant.a();
    final va ab = va.a();
    final w ac = w.a();
    final ad ad = ad.a();
    final qz ae = qz.a();
    final aat af = aat.a();
    final atv ag = atv.a();
    final hx ah = hx.a();
    private final pv ai = pv.a();
    private final cc aj = cc.a();
    
    public final Dialog c(Bundle paramBundle)
    {
      paramBundle = i().getStringArrayList("selection_jids");
      if (paramBundle == null) {
        paramBundle = new ArrayList();
      }
      for (;;)
      {
        int i = i().getInt("unsentCount", 0);
        int j = paramBundle.size();
        String str1 = u.a.a(2131230728, j, new Object[] { Integer.valueOf(j) });
        if (i > 0) {
          str1 = str1 + "\n" + u.a.a(2131230813, i, new Object[] { Integer.valueOf(i) });
        }
        for (;;)
        {
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator = paramBundle.iterator();
          i = 1;
          while (localIterator.hasNext())
          {
            String str2 = (String)localIterator.next();
            int k = this.aj.b(str2);
            j = i & k;
            i = j;
            if (k == 0)
            {
              localArrayList.add(str2);
              i = j;
            }
          }
          paramBundle = new android.support.v7.app.b.a(l()).b(com.whatsapp.emoji.c.a(str1, l().getBaseContext())).a(true).b(2131296398, ku.a(this)).a(2131296768, kv.a(this, paramBundle));
          if (i == 0) {
            paramBundle.c(2131297226, kw.a(this, localArrayList));
          }
          return paramBundle.a();
        }
      }
    }
  }
  
  static final class c
    implements kd.k
  {
    String a;
    
    public c(String paramString)
    {
      this.a = paramString;
    }
    
    public final String a()
    {
      return this.a;
    }
  }
  
  static final class d
    implements kd.k
  {
    String a;
    
    public d(String paramString)
    {
      this.a = paramString;
    }
    
    public final String a()
    {
      return this.a;
    }
  }
  
  final class e
    extends BaseAdapter
    implements Filterable
  {
    private Filter b = new a((byte)0);
    private String c;
    private ArrayList<String> d = new ArrayList();
    
    private e() {}
    
    private kd.k a(int paramInt)
    {
      return (kd.k)kd.j(kd.this).get(paramInt);
    }
    
    private void a(Context paramContext, View paramView, kd.d paramd, kd.p paramp)
    {
      paramp.p.setPadding(0, 0, 0, 0);
      cs localcs = kd.m(kd.this).a(paramd.a);
      if (TextUtils.isEmpty(localcs.t)) {
        throw new IllegalStateException("jid must not be empty");
      }
      paramd = localcs.t;
      kd.o(kd.this).a(localcs, paramp.c);
      boolean bool1 = kd.q(kd.this).contains(paramd);
      boolean bool2 = kd.r(kd.this).remove(paramd);
      Object localObject = paramp.p;
      label152:
      label328:
      label441:
      int j;
      if (bool1)
      {
        i = 2131624041;
        ((View)localObject).setBackgroundResource(i);
        paramp.q.a(bool1, bool2);
        localObject = paramp.q;
        if (!bool1) {
          break label1072;
        }
        i = 0;
        ((SelectionCheckView)localObject).setVisibility(i);
        if (("broadcast".equals(localcs.t)) || (cs.d(localcs.t))) {
          break label1079;
        }
        paramp.q.setEnabled(true);
        paramp.c.setEnabled(true);
        localObject = kd.class.getName() + localcs.t;
        ab.a(paramp.c, (String)localObject);
        localObject = new kd.o(kd.this, paramd, paramp.p, paramp.q);
        paramd = ky.a(this, paramd, paramp);
        paramp.q.setOnClickListener((View.OnClickListener)localObject);
        paramp.d.setOnClickListener((View.OnClickListener)localObject);
        paramp.c.setOnClickListener((View.OnClickListener)localObject);
        paramp.q.setOnLongClickListener(paramd);
        paramp.d.setOnLongClickListener(paramd);
        paramp.c.setOnLongClickListener(paramd);
        paramp.d.setVisibility(0);
        paramp.e.setVisibility(0);
        paramp.f.setVisibility(0);
        paramp.n.setVisibility(0);
        paramp.g.setVisibility(0);
        paramp.h.setVisibility(0);
        paramp.i.setVisibility(0);
        paramp.a.setPadding(0, 0, 0, 0);
        if ((!j.b(localcs.t)) || (!TextUtils.isEmpty(localcs.e))) {
          break label1145;
        }
        paramContext = kd.n(kd.this).g(localcs.t);
        paramp.a.a(paramContext, this.d);
        j = kd.i(kd.this).o(localcs.t);
        if (j <= 0) {
          break label1155;
        }
        paramp.g.setText(NumberFormat.getInstance().format(j));
        paramp.g.setVisibility(0);
        label502:
        localObject = kd.i(kd.this).r(localcs.t);
        if ((localObject != null) && (((j)localObject).s == 0) && ((((j)localObject).t == 2L) || (((j)localObject).t == 3L))) {
          paramp.a.setText(((j)localObject).e());
        }
        a((j)localObject, localcs, paramp, null);
        if (paramp.j != null)
        {
          paramContext = paramp.j;
          if (!kd.p(kd.this).b(localcs.t)) {
            break label1197;
          }
          i = 0;
          label615:
          paramContext.setVisibility(i);
        }
        if (paramp.k != null)
        {
          paramContext = paramp.k;
          if (!kd.p(kd.this).c(localcs.t)) {
            break label1204;
          }
          i = 0;
          label656:
          paramContext.setVisibility(i);
        }
        if (paramp.l != null)
        {
          paramContext = paramp.l;
          if (!kd.s(kd.this).f(localcs.t)) {
            break label1211;
          }
          i = 0;
          label697:
          paramContext.setVisibility(i);
        }
        if (paramp.m != null)
        {
          paramContext = paramp.m;
          if (!kd.t(kd.this).d(localcs.t)) {
            break label1218;
          }
          i = 0;
          label738:
          paramContext.setVisibility(i);
        }
        a(paramp, localcs);
        paramContext = null;
        if (!j.b(localcs.t))
        {
          paramd = kd.u(kd.this).a(localcs);
          paramContext = paramd;
          if (paramd != null)
          {
            paramp.e.setText(paramd);
            paramp.f.setVisibility(8);
            paramp.i.setVisibility(8);
            paramContext = paramd;
          }
        }
        aoa.b(paramp.a);
        if (j == 0) {
          break label1225;
        }
        paramp.n.setTextColor(android.support.v4.content.b.c(kd.this.k(), 2131623997));
      }
      for (;;)
      {
        if (paramContext == null) {
          break label1249;
        }
        paramp.h.setVisibility(8);
        paramp.e.setTextColor(android.support.v4.content.b.c(kd.this.k(), 2131623997));
        aoa.b(paramp.e);
        if ("broadcast".equals(localcs.t))
        {
          paramp.e.setVisibility(8);
          paramp.f.setVisibility(8);
          paramp.n.setVisibility(8);
          paramp.g.setVisibility(8);
          paramp.h.setVisibility(8);
          paramp.i.setVisibility(8);
        }
        if ((kd.v(kd.this) != null) && (kd.v(kd.this).equals(localcs.t)))
        {
          kd.b(kd.this, null);
          paramContext = new AnimationSet(true);
          paramd = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
          paramp = new AlphaAnimation(0.0F, 1.0F);
          paramContext.addAnimation(paramd);
          paramContext.addAnimation(paramp);
          paramContext.setDuration(300L);
          paramView.startAnimation(paramContext);
        }
        return;
        i = 0;
        break;
        label1072:
        i = 8;
        break label152;
        label1079:
        paramp.c.setEnabled(false);
        paramp.q.setOnClickListener(null);
        paramp.d.setOnClickListener(null);
        paramp.c.setOnClickListener(null);
        paramp.q.setOnLongClickListener(null);
        paramp.d.setOnLongClickListener(null);
        paramp.c.setOnLongClickListener(null);
        break label328;
        label1145:
        paramContext = localcs.a(paramContext);
        break label441;
        label1155:
        if (j == -1)
        {
          paramp.g.setText("");
          paramp.g.setVisibility(0);
          break label502;
        }
        paramp.g.setVisibility(8);
        break label502;
        label1197:
        i = 8;
        break label615;
        label1204:
        i = 8;
        break label656;
        label1211:
        i = 8;
        break label697;
        label1218:
        i = 8;
        break label738;
        label1225:
        paramp.n.setTextColor(android.support.v4.content.b.c(kd.this.k(), 2131624046));
      }
      label1249:
      paramp.e.setTextColor(android.support.v4.content.b.c(kd.this.k(), 2131624046));
      if ((localObject == null) || (((j)localObject).s != 15)) {}
      for (int i = 0;; i = 2)
      {
        paramp.e.setTypeface(null, i);
        break;
      }
    }
    
    private void a(kd.p paramp, cs paramcs)
    {
      if ((e.b(paramcs.t)) || (paramcs.f()))
      {
        al.a(kd.l(kd.this), paramp.a, 2130840264);
        paramp.a.setCompoundDrawablePadding(kd.this.m().getDimensionPixelSize(2131362112));
        paramp.a.setTextColor(android.support.v4.content.b.c(kd.this.k(), 2131624048));
        return;
      }
      paramp.a.setCompoundDrawables(null, null, null, null);
      paramp.a.setTextColor(android.support.v4.content.b.c(kd.this.k(), 2131624047));
    }
    
    private void a(j paramj, cs paramcs, kd.p paramp, ArrayList<String> paramArrayList)
    {
      paramp.b.setVisibility(8);
      paramp.h.setVisibility(0);
      paramp.i.setVisibility(8);
      int i;
      Object localObject;
      String str;
      if (paramj != null)
      {
        i = paramj.s;
        if (i == 0) {
          if (paramj.d != 6)
          {
            localObject = paramj.e();
            str = l.b(kd.this.l(), kd.z(kd.this).a(paramj));
            if (paramj.s != 10) {
              break label1708;
            }
            i = 2130840395;
            label93:
            if (i == 0) {
              break label1950;
            }
            paramp.h.setImageDrawable(android.support.v4.content.b.a(kd.this.k(), i));
            label117:
            paramp.f.setVisibility(8);
            if ((paramj != null) && ((paramcs.d()) || (j.b(paramcs.t))) && (!TextUtils.isEmpty((CharSequence)localObject)) && (paramj.d != 6))
            {
              if ((paramj.f == null) || ((paramj.e.b) && (paramj.d != 6))) {
                break label2013;
              }
              paramcs = kd.m(kd.this).d(paramj.f);
              if ((paramcs.t != null) && (!paramcs.t.equals(kd.x(kd.this).b() + "@s.whatsapp.net"))) {
                break label1984;
              }
              paramcs = kd.w(kd.this).n;
              label262:
              if (((!kd.l(kd.this).d()) || (!al.a(paramcs))) && ((kd.l(kd.this).d()) || (al.a(paramcs)))) {
                break label1992;
              }
              paramcs = paramcs + ": ";
              label323:
              paramp.f.a(paramcs);
              paramp.f.setVisibility(0);
            }
            label339:
            i = (int)(kd.this.l().getWindow().getDecorView().getWidth() / (3.0F * kd.this.m().getDisplayMetrics().density * kd.this.m().getConfiguration().fontScale));
            if ((paramj == null) || (paramj.P == null)) {
              break label2049;
            }
            paramcs = new SpannableStringBuilder((CharSequence)localObject);
            yr.a(kd.m(kd.this), (SpannableStringBuilder)paramcs, paramj.P, new kz(this));
            label438:
            localObject = paramp.e;
            if ((paramj == null) || (paramj.d == 6)) {
              break label2055;
            }
          }
        }
      }
      label865:
      label878:
      label1708:
      label1950:
      label1984:
      label1992:
      label2013:
      label2049:
      label2055:
      for (boolean bool = true;; bool = false)
      {
        ((TextEmojiLabel)localObject).a(paramcs, paramArrayList, bool, i);
        paramp.n.setText(str);
        return;
        switch ((int)paramj.t)
        {
        default: 
          localObject = ip.a(kd.l(kd.this), kd.x(kd.this), kd.t(kd.this), kd.m(kd.this), kd.y(kd.this), kd.n(kd.this), paramj);
        }
        for (;;)
        {
          paramp.h.setVisibility(8);
          break;
          localObject = kd.w(kd.this).b;
          paramp.b.setVisibility(8);
          continue;
          localObject = kd.w(kd.this).c;
          paramp.b.setVisibility(0);
        }
        if (i == 1)
        {
          paramp.i.setVisibility(0);
          paramp.i.setImageResource(2130840380);
          if (TextUtils.isEmpty(paramj.z))
          {
            localObject = kd.w(kd.this).d;
            break;
          }
          localObject = paramj.z;
          break;
        }
        if (i == 9)
        {
          paramp.i.setVisibility(0);
          paramp.i.setImageResource(2130840385);
          if (TextUtils.isEmpty(paramj.z)) {}
          for (str = kd.w(kd.this).m;; str = paramj.z)
          {
            localObject = str;
            if (paramj.x == 0) {
              break;
            }
            localObject = str + " (" + p.a(paramj) + ")";
            break;
          }
        }
        if (i == 2)
        {
          if (paramj.o == 1)
          {
            if (paramj.w != 0) {}
            for (localObject = DateUtils.formatElapsedTime(paramj.w);; localObject = kd.w(kd.this).f)
            {
              paramp.i.setVisibility(0);
              if (!paramj.e.b) {
                break label878;
              }
              if (paramj.d != 8) {
                break label865;
              }
              paramp.i.setImageResource(2130840392);
              break;
            }
            paramp.i.setImageResource(2130840394);
            break;
            if ((paramj.d == 9) || (paramj.d == 10))
            {
              paramp.i.setImageResource(2130840392);
              break;
            }
            paramp.i.setImageResource(2130840393);
            break;
          }
          localObject = kd.w(kd.this).e;
          paramp.i.setVisibility(0);
          paramp.i.setImageResource(2130840379);
          break;
        }
        if (i == 3)
        {
          paramp.i.setVisibility(0);
          paramp.i.setImageResource(2130840399);
          if (TextUtils.isEmpty(paramj.z))
          {
            localObject = kd.w(kd.this).g;
            break;
          }
          localObject = paramj.z;
          break;
        }
        if (i == 13)
        {
          paramp.i.setVisibility(0);
          paramp.i.setImageResource(2130840387);
          if (TextUtils.isEmpty(paramj.z))
          {
            localObject = kd.w(kd.this).h;
            break;
          }
          localObject = paramj.z;
          break;
        }
        if (i == 4)
        {
          if (TextUtils.isEmpty(paramj.y)) {}
          for (localObject = kd.w(kd.this).k;; localObject = paramj.y)
          {
            paramp.i.setVisibility(0);
            paramp.i.setImageResource(2130840384);
            break;
          }
        }
        if (i == 14)
        {
          localObject = a.a.a.a.d.d(paramj);
          paramp.i.setVisibility(0);
          paramp.i.setImageResource(2130840384);
          break;
        }
        if (i == 5)
        {
          str = kd.w(kd.this).i;
          localObject = str;
          if (paramj.y != null)
          {
            localObject = str;
            if (paramj.y.length() > 0)
            {
              String[] arrayOfString = paramj.y.split("\n");
              localObject = str;
              if (arrayOfString.length > 0)
              {
                localObject = str;
                if (arrayOfString[0].length() > 0) {
                  localObject = arrayOfString[0];
                }
              }
            }
          }
          paramp.i.setVisibility(0);
          paramp.i.setImageResource(2130840391);
          break;
        }
        if (i == 16)
        {
          if (!TextUtils.isEmpty(paramj.z)) {}
          for (localObject = paramj.z;; localObject = kd.w(kd.this).j)
          {
            paramp.i.setVisibility(0);
            paramp.i.setImageResource(2130840183);
            break;
          }
        }
        if (i == 8)
        {
          bool = Voip.b(paramj);
          if ((paramj.w == 0) && (!paramj.e.b))
          {
            localObject = kd.this;
            if (bool) {}
            for (i = 2131296583;; i = 2131296587)
            {
              localObject = ((kd)localObject).a(i);
              break;
            }
          }
          if (paramj.e.b)
          {
            if (bool) {}
            for (i = 2131296584;; i = 2131296588)
            {
              localObject = kd.this.a(i, new Object[] { DateUtils.formatElapsedTime(paramj.w) });
              break;
            }
          }
          if (bool) {}
          for (i = 2131296582;; i = 2131296586)
          {
            localObject = kd.this.a(i, new Object[] { DateUtils.formatElapsedTime(paramj.w) });
            break;
          }
        }
        if (i == 11)
        {
          paramp.i.setVisibility(0);
          paramp.i.setImageResource(2130840388);
          localObject = kd.this.a(2131296574);
          break;
        }
        if (i == 10)
        {
          bool = Voip.b(paramj);
          localObject = kd.this;
          if (bool) {}
          for (i = 2131296583;; i = 2131296587)
          {
            localObject = ((kd)localObject).a(i);
            break;
          }
        }
        if (i == 12)
        {
          paramp.i.setVisibility(0);
          paramp.i.setImageResource(2130840398);
          localObject = kd.this.a(2131296589);
          break;
        }
        if (i == 15)
        {
          if (paramj.e.b)
          {
            localObject = kd.this.a(2131297624);
            break;
          }
          localObject = kd.this.a(2131297623);
          paramp.i.setVisibility(0);
          paramp.i.setImageResource(2130840383);
          break;
        }
        localObject = kd.this.a(2131296580);
        break;
        if ((paramj.s == 15) && (paramj.e.b))
        {
          if (s.a(paramj.d, 4) >= 0)
          {
            i = 2130840383;
            break label93;
          }
          if (paramj.n + 86400000L < kd.z(kd.this).b())
          {
            i = 2130840386;
            break label93;
          }
          i = 2130840389;
          break label93;
        }
        if (paramj.e.b) {
          switch (paramj.d)
          {
          case 1: 
          case 2: 
          case 3: 
          case 7: 
          case 9: 
          case 10: 
          case 11: 
          case 12: 
          default: 
            i = 2130840389;
            break;
          case 6: 
            i = 0;
            break;
          case 0: 
            if (paramj.n + 86400000L < kd.z(kd.this).b())
            {
              i = 2130840386;
              break;
            }
            i = 2130840389;
            break;
          case 4: 
            i = 2130840397;
            break;
          case 5: 
            i = 2130840382;
            break;
          case 8: 
          case 13: 
            i = 2130840381;
            break;
          }
        }
        i = 0;
        break label93;
        paramp.h.setVisibility(8);
        break label117;
        paramp.h.setVisibility(8);
        str = "";
        localObject = "";
        break label117;
        paramcs = paramcs.k();
        break label262;
        paramcs = " :" + paramcs;
        break label323;
        if (paramj.e.b) {
          break label339;
        }
        Log.e("conversations_row/missing_rmt_src:" + Log.a(paramj));
        break label339;
        paramcs = (cs)localObject;
        break label438;
      }
    }
    
    public final int getCount()
    {
      return kd.j(kd.this).size();
    }
    
    public final Filter getFilter()
    {
      return this.b;
    }
    
    public final long getItemId(int paramInt)
    {
      return ((kd.k)kd.j(kd.this).get(paramInt)).hashCode();
    }
    
    public final int getItemViewType(int paramInt)
    {
      if ((a(paramInt) instanceof kd.m)) {
        return 1;
      }
      return 0;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject2 = a(paramInt);
      if ((localObject2 instanceof kd.m))
      {
        localObject1 = paramView;
        if (paramView == null) {
          localObject1 = kd.this.l().getLayoutInflater().inflate(2130903183, paramViewGroup, false);
        }
        paramView = (TextView)((View)localObject1).findViewById(2131755177);
        aoa.b(paramView);
        paramView.setText(((kd.m)localObject2).a);
      }
      label683:
      label840:
      label968:
      label974:
      label986:
      do
      {
        return (View)localObject1;
        if (paramView == null)
        {
          localObject1 = (LayoutInflater)kd.this.l().getSystemService("layout_inflater");
          paramView = new kd.p();
          localObject1 = al.a(kd.l(kd.this), (LayoutInflater)localObject1, 2130903182, paramViewGroup, false);
          paramView.p = ((View)localObject1).findViewById(2131755658);
          paramView.a = ((TextEmojiLabel)((View)localObject1).findViewById(2131755652));
          paramView.b = ((View)localObject1).findViewById(2131755667);
          paramView.c = ((ImageView)((View)localObject1).findViewById(2131755363));
          paramView.d = ((View)localObject1).findViewById(2131755395);
          paramView.e = ((TextEmojiLabel)((View)localObject1).findViewById(2131755663));
          paramView.f = ((TextEmojiLabel)((View)localObject1).findViewById(2131755653));
          paramView.g = ((TextView)((View)localObject1).findViewById(2131755669));
          paramView.h = ((ImageView)((View)localObject1).findViewById(2131755661));
          paramView.i = ((ImageView)((View)localObject1).findViewById(2131755662));
          paramView.j = ((ImageView)((View)localObject1).findViewById(2131755665));
          paramView.k = ((ImageView)((View)localObject1).findViewById(2131755668));
          paramView.l = ((ImageView)((View)localObject1).findViewById(2131755664));
          paramView.m = ((View)localObject1).findViewById(2131755666);
          paramView.n = ((TextView)((View)localObject1).findViewById(2131755660));
          paramView.q = ((SelectionCheckView)((View)localObject1).findViewById(2131755512));
          paramViewGroup = paramView;
          paramView = (View)localObject1;
        }
        for (;;)
        {
          paramViewGroup.o = ((kd.k)localObject2);
          paramView.setTag(paramViewGroup);
          if (!(localObject2 instanceof kd.d)) {
            break;
          }
          a(kd.this.l(), paramView, (kd.d)localObject2, paramViewGroup);
          return paramView;
          paramViewGroup = (kd.p)paramView.getTag();
        }
        if ((localObject2 instanceof kd.c))
        {
          localObject3 = kd.this.l();
          localObject4 = (kd.c)localObject2;
          paramViewGroup.p.setPadding(0, 0, 0, 0);
          localObject2 = kd.m(kd.this).c(((kd.c)localObject4).a);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new cs(((kd.c)localObject4).a);
          }
          kd.o(kd.this).a((cs)localObject1, paramViewGroup.c);
          if ((!"broadcast".equals(((cs)localObject1).t)) && (!cs.d(((cs)localObject1).t)))
          {
            paramViewGroup.c.setEnabled(true);
            localObject2 = kd.class.getName() + ((cs)localObject1).t;
            ab.a(paramViewGroup.c, (String)localObject2);
            localObject2 = new QuickContactActivity.a(kd.this.k(), ((cs)localObject1).t, (String)localObject2);
            paramViewGroup.d.setOnClickListener((View.OnClickListener)localObject2);
            paramViewGroup.c.setOnClickListener((View.OnClickListener)localObject2);
            paramViewGroup.q.setVisibility(8);
            paramViewGroup.d.setVisibility(0);
            paramViewGroup.e.setVisibility(0);
            paramViewGroup.f.setVisibility(8);
            paramViewGroup.n.setVisibility(0);
            paramViewGroup.j.setVisibility(8);
            localObject2 = paramViewGroup.k;
            if (!kd.p(kd.this).c(((cs)localObject1).t)) {
              break label968;
            }
            paramInt = 0;
            ((ImageView)localObject2).setVisibility(paramInt);
            paramViewGroup.g.setVisibility(8);
            paramViewGroup.h.setVisibility(8);
            paramViewGroup.i.setVisibility(8);
            paramViewGroup.b.setVisibility(8);
            paramViewGroup.h.setVisibility(8);
            paramViewGroup.i.setVisibility(8);
            paramViewGroup.l.setVisibility(8);
            paramViewGroup.m.setVisibility(8);
            paramViewGroup.n.setTextColor(android.support.v4.content.b.c(kd.this.k(), 2131624046));
            paramViewGroup.e.setTextColor(android.support.v4.content.b.c(kd.this.k(), 2131624046));
            if ((!j.b(((cs)localObject1).t)) || (!TextUtils.isEmpty(((cs)localObject1).e))) {
              break label974;
            }
            localObject2 = kd.n(kd.this).g(((cs)localObject1).t);
            paramViewGroup.a.a((String)localObject2, this.d);
            a(paramViewGroup, (cs)localObject1);
            localObject2 = ((cs)localObject1).a(kd.this.m());
            if (localObject2 != null) {
              paramViewGroup.n.setText((CharSequence)localObject2);
            }
            localObject2 = paramViewGroup.e;
            if (((cs)localObject1).u == null) {
              break label986;
            }
          }
          for (localObject1 = ((cs)localObject1).u;; localObject1 = "")
          {
            ((TextEmojiLabel)localObject2).a((CharSequence)localObject1);
            paramViewGroup.e.setVisibility(0);
            aoa.b(paramViewGroup.a);
            return paramView;
            paramViewGroup.c.setEnabled(false);
            paramViewGroup.d.setOnClickListener(null);
            paramViewGroup.c.setOnClickListener(null);
            paramViewGroup.q.setOnClickListener(null);
            break;
            paramInt = 8;
            break label683;
            localObject2 = ((cs)localObject1).a((Context)localObject3);
            break label840;
          }
        }
        localObject1 = paramView;
      } while (!(localObject2 instanceof kd.l));
      Object localObject4 = kd.this.l();
      Object localObject3 = (kd.l)localObject2;
      al.a(kd.l(kd.this), paramViewGroup.p, kd.this.m().getDimensionPixelSize(2131362037), 0, 0, 0);
      paramViewGroup.d.setVisibility(8);
      paramViewGroup.g.setVisibility(8);
      paramViewGroup.h.setVisibility(8);
      paramViewGroup.i.setVisibility(8);
      paramViewGroup.k.setVisibility(8);
      paramViewGroup.j.setVisibility(8);
      paramViewGroup.l.setVisibility(8);
      paramViewGroup.m.setVisibility(8);
      paramViewGroup.e.setVisibility(0);
      paramViewGroup.n.setTextColor(android.support.v4.content.b.c(kd.this.k(), 2131624046));
      paramViewGroup.e.setTextColor(android.support.v4.content.b.c(kd.this.k(), 2131624046));
      paramViewGroup.c.setEnabled(false);
      paramViewGroup.d.setOnClickListener(null);
      paramViewGroup.c.setOnClickListener(null);
      localObject2 = kd.m(kd.this).c(((kd.l)localObject3).a.e.a);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new cs(((kd.l)localObject3).a.e.a);
      }
      if ((j.b(((cs)localObject1).t)) && (TextUtils.isEmpty(((cs)localObject1).e))) {}
      for (localObject2 = kd.n(kd.this).g(((cs)localObject1).t);; localObject2 = ((cs)localObject1).a((Context)localObject4))
      {
        paramViewGroup.a.a((CharSequence)localObject2);
        a(paramViewGroup, (cs)localObject1);
        a(((kd.l)localObject3).a, (cs)localObject1, paramViewGroup, this.d);
        aoa.b(paramViewGroup.a);
        return paramView;
      }
    }
    
    public final int getViewTypeCount()
    {
      return 2;
    }
    
    public final boolean hasStableIds()
    {
      return true;
    }
    
    public final boolean isEmpty()
    {
      return (super.isEmpty()) && ((kd.k(kd.this) == 0) || (!TextUtils.isEmpty(this.c)));
    }
    
    final class a
      extends Filter
    {
      private Map<String, cs> b;
      private ArrayList<cs> c;
      private final Object d = new Object();
      
      private a() {}
      
      private ArrayList<cs> a()
      {
        synchronized (this.d)
        {
          if (this.c == null)
          {
            this.c = new ArrayList();
            kd.m(kd.this).b(this.c);
          }
          ArrayList localArrayList = this.c;
          return localArrayList;
        }
      }
      
      private Map<String, cs> b()
      {
        synchronized (this.d)
        {
          if (this.b == null)
          {
            Object localObject2 = a();
            this.b = new HashMap(((ArrayList)localObject2).size(), 1.0F);
            localObject2 = ((ArrayList)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              cs localcs1 = (cs)((Iterator)localObject2).next();
              cs localcs2 = (cs)this.b.get(localcs1.t);
              if ((localcs2 == null) || (localcs2.c > localcs1.c)) {
                this.b.put(localcs1.t, localcs1);
              }
            }
          }
        }
        Map localMap = this.b;
        return localMap;
      }
      
      protected final Filter.FilterResults performFiltering(CharSequence paramCharSequence)
      {
        Filter.FilterResults localFilterResults = new Filter.FilterResults();
        ArrayList localArrayList;
        if (paramCharSequence.length() > 0)
        {
          localArrayList = new ArrayList();
          Object localObject1 = be.c(paramCharSequence.toString());
          Log.d("conversations/filter/chats");
          Object localObject4 = kd.A(kd.this).j();
          Object localObject2 = new HashSet();
          Object localObject3 = b();
          localObject4 = ((ArrayList)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            String str = (String)((Iterator)localObject4).next();
            cs localcs = (cs)((Map)localObject3).get(str);
            if ((localcs != null) && (!cs.d(localcs.t)) && (localcs.a((ArrayList)localObject1)))
            {
              if (localArrayList.isEmpty()) {
                localArrayList.add(new kd.m(kd.this.a(2131297640)));
              }
              localArrayList.add(new kd.d(str));
              ((HashSet)localObject2).add(str);
            }
          }
          localObject3 = a().iterator();
          int j;
          for (int i = 0; ((Iterator)localObject3).hasNext(); i = j)
          {
            localObject4 = (cs)((Iterator)localObject3).next();
            j = i;
            if (((cs)localObject4).d != null)
            {
              j = i;
              if (((cs)localObject4).a((ArrayList)localObject1))
              {
                j = i;
                if (!((HashSet)localObject2).contains(((cs)localObject4).t))
                {
                  if (i == 0) {
                    localArrayList.add(new kd.m(kd.this.a(2131297641)));
                  }
                  j = 1;
                  localArrayList.add(new kd.c(((cs)localObject4).t));
                }
              }
            }
          }
          localObject2 = kd.i(kd.this).a(paramCharSequence.toString(), 0, 100, null);
          localObject1 = new ArrayList();
          paramCharSequence = new ArrayList();
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (j)((Iterator)localObject2).next();
            if (((j)localObject3).T) {
              ((ArrayList)localObject1).add(localObject3);
            } else {
              paramCharSequence.add(localObject3);
            }
          }
          if (((ArrayList)localObject1).size() > 0) {
            localArrayList.add(new kd.m(kd.this.a(2131297643)));
          }
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext()) {
            localArrayList.add(new kd.l((j)((Iterator)localObject1).next()));
          }
          if (paramCharSequence.size() > 0) {
            localArrayList.add(new kd.m(kd.this.a(2131297642)));
          }
          paramCharSequence = paramCharSequence.iterator();
          while (paramCharSequence.hasNext()) {
            localArrayList.add(new kd.l((j)paramCharSequence.next()));
          }
        }
        for (paramCharSequence = localArrayList;; paramCharSequence = kd.this.c())
        {
          localFilterResults.values = paramCharSequence;
          localFilterResults.count = paramCharSequence.size();
          return localFilterResults;
        }
      }
      
      protected final void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
      {
        View localView1 = kd.this.x();
        if (localView1 != null)
        {
          if (paramFilterResults.count != 0) {
            break label315;
          }
          if (paramCharSequence.length() <= 0) {
            break label291;
          }
          View localView2 = localView1.findViewById(2131755391);
          localView2.setVisibility(0);
          kd.f(kd.this).setEmptyView(localView2);
          localView1.findViewById(2131755650).setVisibility(8);
          localView1.findViewById(2131755649).setVisibility(8);
          localView1.findViewById(2131755651).setVisibility(8);
          kd.a(kd.this, (ArrayList)paramFilterResults.values);
          if (kd.j(kd.this) == null) {
            kd.a(kd.this, kd.this.c());
          }
          kd.e.a(kd.e.this, paramCharSequence.toString());
          kd.e.a(kd.e.this, be.c(kd.e.a(kd.e.this)));
          if (!TextUtils.isEmpty(kd.e.a(kd.e.this))) {
            break label347;
          }
          kd.f(kd.this).setDivider(new az(kd.this.m().getDrawable(2130837766)));
          if (kd.k(kd.this) <= 0) {
            break label329;
          }
          kd.this.aa.setVisibility(0);
        }
        for (;;)
        {
          kd.e.this.notifyDataSetChanged();
          if (kd.f(kd.this).getCount() > 0) {
            kd.f(kd.this).setSelection(0);
          }
          return;
          label291:
          localView1.findViewById(2131755391).setVisibility(8);
          kd.e(kd.this);
          break;
          label315:
          localView1.findViewById(2131755391).setVisibility(8);
          break;
          label329:
          kd.this.aa.setVisibility(8);
          continue;
          label347:
          kd.f(kd.this).setDivider(null);
          kd.this.aa.setVisibility(8);
          if (kd.j(kd.this).isEmpty()) {
            ((TextView)localView1.findViewById(2131755391)).setText(localView1.getContext().getString(2131297639, new Object[] { kd.e.a(kd.e.this) }));
          }
        }
      }
    }
  }
  
  final class f
    extends GoogleDriveService.b
  {
    private int b;
    private long c = -1L;
    private int d;
    private boolean e;
    
    private f() {}
    
    private void a(int paramInt1, String paramString1, String paramString2, int paramInt2, boolean paramBoolean)
    {
      if (!kd.this.o()) {}
      for (;;)
      {
        return;
        n localn = kd.this.l();
        if (localn == null)
        {
          Log.d("conversations-gdrive-observer/set-message/activity-is-null");
          return;
        }
        switch (paramInt1)
        {
        }
        while ((paramBoolean != this.e) && (!localn.isFinishing()))
        {
          Log.d("conversations-gdrive-observer/set-message animation: " + this.e + " -> " + paramBoolean);
          localn.runOnUiThread(li.a(this, paramBoolean));
          this.e = paramBoolean;
          return;
          if ((this.d != 1) && (!localn.isFinishing()))
          {
            localn.runOnUiThread(lc.a(this));
            this.d = 1;
          }
          if (!localn.isFinishing())
          {
            localn.runOnUiThread(ld.a(this, paramString1, paramString2));
            continue;
            throw new IllegalStateException("unexpected state");
            a.d.a(paramString2);
            if ((this.d != 3) && (!localn.isFinishing()))
            {
              localn.runOnUiThread(le.a(this));
              this.d = 3;
            }
            if (!localn.isFinishing())
            {
              localn.runOnUiThread(lf.a(this, paramInt2, paramString1, paramString2));
              continue;
              a.d.a(paramString2);
              if (this.d != 4)
              {
                Log.i("conversations-gdrive-observer/set-message/show-indeterminate");
                if (!localn.isFinishing())
                {
                  Log.d("conversations-gdrive-observer/progress-bar-state-change " + this.d + " -> 4");
                  localn.runOnUiThread(lg.a(this));
                  this.d = 4;
                }
              }
              if (!localn.isFinishing()) {
                localn.runOnUiThread(lh.a(this, paramString2, paramString1));
              }
            }
          }
        }
      }
    }
    
    public final void a()
    {
      Log.i("conversations-gdrive-observer/restore-start");
      if (!kd.this.o()) {
        return;
      }
      this.b = 9;
      a(4, kd.this.a(2131296881), kd.this.a(2131296875), -1, true);
    }
    
    public final void a(int paramInt)
    {
      if (!kd.this.o()) {}
      while (paramInt <= 0) {
        return;
      }
      this.b = 10;
      a(4, kd.this.a(2131296881), kd.this.a(2131296876, new Object[] { Integer.valueOf(paramInt) }), paramInt, true);
    }
    
    public final void a(int paramInt, Bundle paramBundle)
    {
      if (!kd.this.o()) {}
      do
      {
        return;
        this.b = 2;
      } while (paramInt == 10);
      Log.i("conversations-gdrive-observer/error-during-restore/" + ch.a(paramInt));
      a(1, kd.this.a(2131296878), kd.this.a(2131298246), 0, false);
      kd.b(kd.this).h.d();
    }
    
    public final void a(long paramLong1, long paramLong2)
    {
      Log.i("conversations-gdrive-observer/restore-paused/no-wifi");
      if (!kd.this.o()) {
        return;
      }
      this.b = 3;
      String str = kd.this.a(2131296874);
      if (paramLong2 > 0L) {}
      for (int i = (int)(100L * paramLong1 / paramLong2);; i = -1)
      {
        a(3, kd.this.a(2131296880), str, i, false);
        return;
      }
    }
    
    public final void a(long paramLong1, long paramLong2, long paramLong3)
    {
      if (!kd.this.o()) {}
      n localn;
      String str;
      do
      {
        do
        {
          return;
          localn = kd.this.l();
        } while (localn == null);
        str = be.a(localn, paramLong1);
      } while ((this.b == 1) && (be.a(localn, paramLong1).equals(be.a(localn, this.c))));
      this.c = paramLong1;
      a(3, kd.this.a(2131296881), kd.this.a(2131296871, new Object[] { str, be.a(localn, paramLong3), Long.valueOf(100L * paramLong1 / paramLong3) }), (int)(100L * paramLong1 / paramLong3), true);
      this.b = 1;
    }
    
    public final void a(boolean paramBoolean, long paramLong1, long paramLong2)
    {
      Log.i("conversations-gdrive-observer/restore-end " + paramBoolean);
      if (!kd.this.o()) {}
      n localn;
      do
      {
        do
        {
          return;
          localn = kd.this.l();
        } while (localn == null);
        this.b = 8;
        this.c = -1L;
        if (paramLong1 > 0L) {}
        for (String str = localn.getString(2131296870, new Object[] { be.a(localn, paramLong2 - paramLong1), be.a(localn, paramLong1) }); paramLong2 > 0L; str = localn.getString(2131296869, new Object[] { be.a(localn, paramLong2) }))
        {
          a(3, kd.this.a(2131296879), str, 100, false);
          return;
        }
        if (paramLong2 != 0L) {
          break;
        }
        Log.i("conversations-gdrive-observer/restore-end/nothing-to-restore");
      } while (localn.isFinishing());
      localn.runOnUiThread(la.a(this));
      return;
      Log.e("conversations-gdrive-observer/restore-end total: " + paramLong2 + " failed: " + paramLong1 + " result: " + paramBoolean);
    }
    
    public final void b()
    {
      Log.i("conversations-gdrive-observer/restore-cancelled");
      if (!kd.this.o()) {}
      n localn;
      do
      {
        return;
        localn = kd.this.l();
      } while (localn.isFinishing());
      localn.runOnUiThread(lb.a(this));
    }
    
    public final void b(long paramLong1, long paramLong2)
    {
      Log.i("conversations-gdrive-observer/restore-paused/no-data-connection");
      if (!kd.this.o()) {
        return;
      }
      this.b = 4;
      String str = kd.this.a(2131296873);
      if (paramLong2 > 0L) {}
      for (int i = (int)(100L * paramLong1 / paramLong2);; i = -1)
      {
        a(3, kd.this.a(2131296880), str, i, false);
        return;
      }
    }
    
    public final void c(long paramLong1, long paramLong2)
    {
      Log.i("conversations-gdrive-observer/restore-paused/low-battery");
      if (!kd.this.o()) {
        return;
      }
      this.b = 5;
      String str = kd.this.a(2131296872);
      if (paramLong2 > 0L) {}
      for (int i = (int)(100L * paramLong1 / paramLong2);; i = -1)
      {
        a(3, kd.this.a(2131296880), str, i, false);
        return;
      }
    }
    
    public final void d(long paramLong1, long paramLong2)
    {
      Log.i("conversations-gdrive-observer/restore-paused/sdcard-unmounted");
      if (!kd.this.o()) {
        return;
      }
      this.b = 6;
      String str = kd.this.a(2131298248);
      if (paramLong2 > 0L) {}
      for (int i = (int)(100L * paramLong1 / paramLong2);; i = -1)
      {
        a(3, kd.this.a(2131296880), str, i, false);
        return;
      }
    }
    
    public final void e(long paramLong1, long paramLong2)
    {
      Log.i("conversations-gdrive-observer/restore-paused/sdcard-missing");
      if (!kd.this.o()) {
        return;
      }
      this.b = 7;
      if (paramLong2 > 0L) {}
      for (int i = (int)(100L * paramLong1 / paramLong2);; i = -1)
      {
        a(4, kd.this.a(2131296880), kd.this.a(2131296907), i, false);
        return;
      }
    }
  }
  
  public static final class g
    extends android.support.v4.app.m
  {
    private final e aa = e.a();
    
    public final Dialog c(Bundle paramBundle)
    {
      cs localcs = this.aa.d((String)a.d.a(i().getString("jid")));
      if (TextUtils.isEmpty(localcs.e)) {}
      for (paramBundle = a(2131296649);; paramBundle = a(2131296648, new Object[] { localcs.a(l()) })) {
        return new android.support.v7.app.b.a(l()).b(com.whatsapp.emoji.c.a(paramBundle, l().getBaseContext())).a(true).b(2131296398, lj.a(this)).a(2131296609, lk.a(this, localcs)).a();
      }
    }
  }
  
  public static final class h
    extends android.support.v4.app.m
  {
    private final e aa = e.a();
    
    public final Dialog c(Bundle paramBundle)
    {
      cs localcs = this.aa.d((String)a.d.a(i().getString("jid")));
      int i = i().getInt("unsentCount");
      if (i == 0) {}
      for (paramBundle = a(2131296643, new Object[] { localcs.a(l()) });; paramBundle = u.a.a(2131230742, i, new Object[] { localcs.a(l()), Integer.valueOf(i) })) {
        return new android.support.v7.app.b.a(l()).b(com.whatsapp.emoji.c.a(paramBundle, l().getBaseContext())).a(true).b(2131296398, ll.a(this)).a(2131296609, lm.a(this, localcs)).a();
      }
    }
  }
  
  public static final class i
    extends android.support.v4.app.m
  {
    private final ad aa = ad.a();
    private final e ab = e.a();
    
    public final Dialog c(Bundle paramBundle)
    {
      cs localcs = this.ab.d((String)a.d.a(i().getString("jid")));
      Object localObject = null;
      paramBundle = (Bundle)localObject;
      if (localcs.e == null)
      {
        j localj = this.aa.r(localcs.t);
        paramBundle = (Bundle)localObject;
        if (localj != null)
        {
          paramBundle = (Bundle)localObject;
          if (localj.s == 0) {
            if (localj.t != 2L)
            {
              paramBundle = (Bundle)localObject;
              if (localj.t != 3L) {}
            }
            else
            {
              paramBundle = localj.e();
            }
          }
        }
      }
      localObject = paramBundle;
      if (paramBundle == null) {
        localObject = localcs.a(l());
      }
      return new android.support.v7.app.b.a(l()).b(com.whatsapp.emoji.c.a(a(2131296645, new Object[] { localObject }), l().getBaseContext())).a(true).b(2131296398, ln.a(this)).a(2131296609, lo.a(this, localcs)).a();
    }
  }
  
  public static final class j
    extends android.support.v4.app.m
  {
    final ant aa = ant.a();
    final va ab = va.a();
    final w ac = w.a();
    final ad ad = ad.a();
    final qz ae = qz.a();
    final cc af = cc.a();
    final aat ag = aat.a();
    final atv ah = atv.a();
    final hx ai = hx.a();
    private final pv aj = pv.a();
    private final e ak = e.a();
    
    public final Dialog c(Bundle paramBundle)
    {
      String str = (String)a.d.a(i().getString("jid"));
      cs localcs = this.ak.d(str);
      int i = i().getInt("unsentCount");
      View localView = al.a(pv.a(), LayoutInflater.from(k()), 2130903223, null, false);
      TextView localTextView = (TextView)localView.findViewById(2131755691);
      CheckBox localCheckBox = (CheckBox)localView.findViewById(2131755773);
      if (this.af.c(str))
      {
        localCheckBox.setChecked(true);
        localCheckBox.setVisibility(0);
      }
      if (i == 0) {}
      for (paramBundle = a(2131296770, new Object[] { localcs.a(l()) });; paramBundle = u.a.a(2131230745, i, new Object[] { localcs.a(l()), Integer.valueOf(i) }))
      {
        localTextView.setText(com.whatsapp.emoji.c.a(paramBundle, l().getBaseContext()));
        boolean bool = this.af.b(str);
        paramBundle = new android.support.v7.app.b.a(l()).a(localView).a(true).b(2131296398, lp.a(this)).a(2131296768, lq.a(this, localcs, localCheckBox, str));
        if (!bool) {
          paramBundle.c(2131297226, lr.a(this, str));
        }
        return paramBundle.a();
      }
    }
  }
  
  static abstract interface k
  {
    public abstract String a();
  }
  
  static final class l
    implements kd.k
  {
    j a;
    
    public l(j paramj)
    {
      this.a = paramj;
    }
    
    public final String a()
    {
      return this.a.e.a;
    }
  }
  
  static final class m
    implements kd.k
  {
    String a;
    
    public m(String paramString)
    {
      this.a = paramString;
    }
    
    public final String a()
    {
      return null;
    }
  }
  
  static final class n
  {
    String a;
    String b;
    String c;
    String d;
    String e;
    String f;
    String g;
    String h;
    String i;
    String j;
    String k;
    String l;
    String m;
    String n;
  }
  
  final class o
    implements View.OnClickListener
  {
    private long b;
    private String c;
    private View d;
    private SelectionCheckView e;
    
    o(String paramString, View paramView, SelectionCheckView paramSelectionCheckView)
    {
      this.c = paramString;
      this.d = paramView;
      this.e = paramSelectionCheckView;
    }
    
    public final void onClick(View paramView)
    {
      long l = SystemClock.elapsedRealtime();
      if (kd.M(kd.this) != null) {
        kd.a(kd.this, this.c, this.d, this.e);
      }
      while (l - this.b <= 1000L) {
        return;
      }
      this.b = l;
      QuickContactActivity.a(kd.this.l(), paramView, this.c, ab.s(this.d.findViewById(2131755363)));
    }
  }
  
  static final class p
  {
    TextEmojiLabel a;
    View b;
    ImageView c;
    View d;
    TextEmojiLabel e;
    TextEmojiLabel f;
    TextView g;
    ImageView h;
    ImageView i;
    ImageView j;
    ImageView k;
    ImageView l;
    View m;
    TextView n;
    kd.k o;
    View p;
    SelectionCheckView q;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/kd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */