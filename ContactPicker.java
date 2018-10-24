package com.whatsapp;

import a.a.a.a.a.a.d;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.ContactsContract.Contacts;
import android.support.v4.view.ab;
import android.support.v4.view.o.e;
import android.support.v7.widget.SearchView.b;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Pair;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ListView;
import android.widget.SectionIndexer;
import android.widget.TextView;
import com.whatsapp.contact.sync.ContactSyncManager.c;
import com.whatsapp.contact.sync.v;
import com.whatsapp.data.ad;
import com.whatsapp.data.ch;
import com.whatsapp.data.ch.a;
import com.whatsapp.data.co;
import com.whatsapp.data.cs;
import com.whatsapp.data.cs.b;
import com.whatsapp.data.cs.c;
import com.whatsapp.data.cs.d;
import com.whatsapp.data.e;
import com.whatsapp.fieldstats.events.t;
import com.whatsapp.fieldstats.l;
import com.whatsapp.messaging.i;
import com.whatsapp.messaging.m;
import com.whatsapp.protocol.j;
import com.whatsapp.registration.bb;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils;
import com.whatsapp.util.MediaFileUtils.c;
import com.whatsapp.util.MediaFileUtils.f;
import com.whatsapp.util.WhatsAppLibLoader;
import com.whatsapp.util.aa;
import com.whatsapp.util.at;
import com.whatsapp.util.az;
import com.whatsapp.util.be;
import com.whatsapp.util.bu;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactPicker
  extends apf
{
  private static boolean N;
  private final Handler O = new Handler(Looper.getMainLooper());
  private final Set<String> P = new HashSet();
  private boolean Q;
  private boolean R;
  private boolean S;
  private boolean T;
  private boolean U;
  private boolean V;
  private boolean W;
  private boolean X;
  private byte Y;
  private ArrayList<Uri> Z;
  private c aT;
  private AsyncTask<Void, Void, Pair<v, ContactSyncManager.c>> aU;
  private AsyncTask<Void, Void, Void> aV;
  private b aW;
  private ArrayList<String> aX;
  private String aY;
  private final va aZ = va.a();
  private String aa = "";
  private String ab;
  private String ac;
  private ArrayList<String> ad;
  private HashSet<Integer> ae = new HashSet();
  private String af;
  private List<cs> ag = new ArrayList();
  private List<cs> ah = new ArrayList();
  private List<cs> ai = new ArrayList();
  private g aj;
  private final atv bA;
  private boolean bB;
  private final List<View> bC;
  private final com.whatsapp.data.d ba = com.whatsapp.data.d.a();
  private final aoj bb = aoj.a();
  private final ad bc = ad.a();
  private final e bd = e.a();
  private final aq be = aq.a();
  private final cc bf = cc.a();
  private final co bg = co.a();
  private final com.whatsapp.data.o bh = com.whatsapp.data.o.a();
  private final i bi = i.a();
  private final di.e bj = di.a().b();
  private boolean bk;
  private MenuItem bl;
  private ahp bm;
  private android.support.v7.view.b.a bn;
  private ImageView bo;
  private TextEmojiLabel bp;
  private View bq;
  private View br;
  private Long bs;
  private long bt;
  private final Set<String> bu = new HashSet();
  private final Runnable bv;
  private final dh bw;
  private dh.a bx;
  private final com.whatsapp.contact.sync.a by;
  private final aat bz;
  cs n;
  final Map<String, cs> o = new LinkedHashMap();
  boolean p;
  boolean q;
  boolean r;
  String s;
  final ani t = ani.a();
  android.support.v7.view.b u;
  ListView v;
  
  public ContactPicker()
  {
    Set localSet = this.bu;
    localSet.getClass();
    this.bv = dj.a(localSet);
    this.bw = dh.a();
    this.bx = null;
    this.by = com.whatsapp.contact.sync.a.a();
    this.bz = aat.a();
    this.bA = atv.a();
    this.bC = new ArrayList();
  }
  
  static int a(ListView paramListView, int paramInt)
  {
    paramListView = paramListView.getAdapter();
    int i = paramInt;
    if ((paramListView instanceof HeaderViewListAdapter)) {
      i = paramInt - ((HeaderViewListAdapter)paramListView).getHeadersCount();
    }
    return i;
  }
  
  static b a(ListView paramListView)
  {
    paramListView = paramListView.getAdapter();
    if ((paramListView instanceof HeaderViewListAdapter)) {
      return (b)((HeaderViewListAdapter)paramListView).getWrappedAdapter();
    }
    return (b)paramListView;
  }
  
  private static String a(String paramString)
  {
    try
    {
      String str = ly.a(paramString);
      return str;
    }
    catch (Exception localException)
    {
      Log.w("contactpicker/checkpnvalidity/lookupname/error " + paramString);
    }
    return null;
  }
  
  private void a(Uri paramUri)
  {
    t localt = null;
    String str3 = paramUri.getQueryParameter("phone");
    String str4 = paramUri.getQueryParameter("text");
    String str2 = paramUri.getQueryParameter("data");
    String str1 = str2;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() > 512)
      {
        Log.w("contactpicker/textanddirectchatlink/Stripping data due to being too long. Length = " + str2.length() + ", max = 512.");
        str1 = null;
      }
    }
    paramUri = paramUri.getQueryParameter("source");
    if ((paramUri != null) && (paramUri.length() > 32))
    {
      Log.w("contactpicker/textanddirectchatlink/Stripping source due to being too long. Length = " + paramUri.length() + ", max = 32.");
      paramUri = localt;
    }
    for (;;)
    {
      this.Y = 0;
      this.aa = str4;
      if (TextUtils.isEmpty(this.aa))
      {
        if (TextUtils.isEmpty(str3))
        {
          Log.e("contactpicker/textanddirectchatlink/share-failed/no-text-or-phone");
          pv.a(getBaseContext(), 2131297841, 0);
          finish();
          return;
        }
        localt = new t();
        localt.b = Boolean.valueOf(true);
        localt.a = Boolean.valueOf(false);
        l.a(this, localt);
        if (this.aU != null) {
          Log.i("contactpicker/textanddirectchatlink/skip/synctask-already-exists");
        }
      }
      for (;;)
      {
        this.X = false;
        this.p = true;
        this.ae.add(Integer.valueOf(0));
        return;
        a(str3, false, str1, paramUri);
        continue;
        this.bB = true;
        localt = new t();
        if (!TextUtils.isEmpty(str3)) {}
        for (boolean bool = true;; bool = false)
        {
          localt.b = Boolean.valueOf(bool);
          localt.a = Boolean.valueOf(true);
          l.a(this, localt);
          if (TextUtils.isEmpty(str3)) {
            break;
          }
          if (this.aU == null) {
            break label346;
          }
          Log.i("contactpicker/textanddirectchatlink/skip/synctask-already-exists");
          break;
        }
        label346:
        a(str3, true, str1, paramUri);
      }
    }
  }
  
  private void a(final String paramString1, final boolean paramBoolean, final String paramString2, final String paramString3)
  {
    paramString1 = b(paramString1);
    if (paramString1 == null) {
      return;
    }
    if (!this.bz.b())
    {
      Log.w("handledeeplink/network-unavailable/" + paramString1);
      a(0, 2131296665, new Object[] { paramString1 });
      return;
    }
    this.aU = new AsyncTask()
    {
      static
      {
        if (!ContactPicker.class.desiredAssertionStatus()) {}
        for (boolean bool = true;; bool = false)
        {
          a = bool;
          return;
        }
      }
      
      private Pair<v, ContactSyncManager.c> a()
      {
        for (;;)
        {
          try
          {
            ContactPicker.this.A.a(32000L);
            Pair localPair = a.a.a.a.d.a(ContactPicker.l(ContactPicker.this), paramString1);
            Object localObject = localPair.second;
            switch (com.whatsapp.contact.sync.l.a[((v)localPair.first).ordinal()])
            {
            case 1: 
            default: 
              return localPair;
            }
          }
          catch (zg localzg)
          {
            return null;
          }
          Log.e("existencecheck/failed/general");
        }
      }
      
      protected final void onCancelled()
      {
        Log.i("contactpicker/existencecheck/canceled");
        ContactPicker.m(ContactPicker.this);
        nh.h.a(ContactPicker.this.aS);
      }
      
      protected final void onPreExecute()
      {
        ContactPicker.this.g(2131297645);
      }
    };
    bu.a(this.aU, new Void[0]);
  }
  
  private View b(int paramInt1, int paramInt2)
  {
    View localView = al.a(this.aq, getLayoutInflater(), 2130903124, null, false);
    localView.setBackgroundResource(2130840501);
    Object localObject = (ImageView)localView.findViewById(2131755511);
    ((ImageView)localObject).setImageResource(paramInt1);
    ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER);
    ((ImageView)localObject).setBackgroundResource(2130840027);
    localObject = (TextView)localView.findViewById(2131755517);
    aoa.b((TextView)localObject);
    ((TextView)localObject).setText(paramInt2);
    ((TextView)localView.findViewById(2131755519)).setVisibility(8);
    localObject = new FrameLayout(this);
    ((FrameLayout)localObject).addView(localView);
    this.bC.add(localView);
    return (View)localObject;
  }
  
  private String b(String paramString)
  {
    String str = paramString.replaceAll("\\D", "");
    if (str.length() < 5)
    {
      Log.w("contactpicker/converttointlformat/too-short-no-cc");
      a(0, 2131296671, new Object[] { paramString });
      return null;
    }
    Object localObject = Pattern.compile("^([17]|2[07]|3[0123469]|4[013456789]|5[12345678]|6[0123456]|8[1246]|9[0123458]|\\d{3})\\d*?(\\d{4,6})$").matcher(str);
    if (((Matcher)localObject).find())
    {
      localObject = ((Matcher)localObject).group(1);
      str = str.substring(((String)localObject).length());
      int i = com.whatsapp.registration.u.c((String)localObject, str);
      if (i == 1)
      {
        i = Integer.parseInt((String)localObject);
        try
        {
          paramString = ly.a(i, str.replaceAll("\\D", ""));
          return "+" + (String)localObject + paramString;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            Log.w("contactpicker/converttointlformat/trim/error " + i);
            paramString = str;
          }
        }
      }
      switch (i)
      {
      }
    }
    for (;;)
    {
      return null;
      a(0, 2131296664, new Object[] { paramString });
      Log.w("contactpicker/converttointlformat/invalid-cc/" + paramString + " cc=" + (String)localObject);
      continue;
      str = a((String)localObject);
      Log.w("contactpicker/converttointlformat/invalid-length/" + paramString + " cc=" + (String)localObject);
      if (str != null)
      {
        a(0, 2131296662, new Object[] { paramString, localObject, str });
      }
      else
      {
        a(0, 2131296663, new Object[] { paramString, localObject });
        continue;
        str = a((String)localObject);
        Log.w("contactpicker/converttointlformat/too-long/" + paramString + " cc=" + (String)localObject);
        if (str != null)
        {
          a(0, 2131296668, new Object[] { paramString, localObject, str });
        }
        else
        {
          a(0, 2131296669, new Object[] { paramString, localObject });
          continue;
          str = a((String)localObject);
          Log.w("contactpicker/converttointlformat/too-short/" + paramString + " cc=" + (String)localObject);
          if (str != null) {
            a(0, 2131296670, new Object[] { paramString, localObject, str });
          } else {
            a(0, 2131296672, new Object[] { paramString, localObject });
          }
        }
      }
    }
  }
  
  private void q()
  {
    if (this.bt + 3500L < SystemClock.elapsedRealtime())
    {
      this.bt = SystemClock.elapsedRealtime();
      pv.a(this);
    }
  }
  
  private ArrayList<String> r()
  {
    ArrayList localArrayList = new ArrayList(this.o.size());
    Iterator localIterator = this.o.values().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((cs)localIterator.next()).t);
    }
    return localArrayList;
  }
  
  private void s()
  {
    if (this.aj != null) {
      this.aj.cancel(true);
    }
    if (this.aT != null)
    {
      this.aT.cancel(true);
      this.aT = null;
    }
    this.aj = new g((byte)0);
    bu.a(this.aj, new Void[0]);
  }
  
  public final void a(android.support.v7.view.b paramb)
  {
    super.a(paramb);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(android.support.v4.content.b.c(this, 2131623951));
    }
  }
  
  protected final void a(ch.a parama)
  {
    this.aW.notifyDataSetChanged();
    N = false;
    if (this.bA.b() != this.bk)
    {
      this.bk = this.bA.b();
      if (this.bx != null) {
        this.bx.a();
      }
    }
  }
  
  final void a(final cs paramcs)
  {
    Object localObject = null;
    boolean bool3 = true;
    if ((this.Z != null) && (!this.aP.b())) {
      RequestPermissionActivity.b(this, 2131297447, 2131297446);
    }
    label149:
    label162:
    label318:
    label323:
    label328:
    label617:
    do
    {
      for (;;)
      {
        return;
        if ((this.o.size() == 1) && (!j.c(((cs)this.o.values().iterator().next()).t)))
        {
          this.n = ((cs)this.o.values().iterator().next());
          this.o.clear();
        }
        setResult(-1);
        if ((this.n == null) && (paramcs == null)) {
          break;
        }
        Conversation.s = true;
        cs localcs;
        boolean bool1;
        boolean bool2;
        if (this.n == null)
        {
          localcs = paramcs;
          if (paramcs == null) {
            break label318;
          }
          bool1 = true;
          if (j.c(localcs.t)) {
            break label323;
          }
          bool2 = true;
          a.d.a(bool2);
          if (this.Z == null) {
            break label328;
          }
          paramcs = new Intent(this, Conversation.class);
          paramcs.putExtra("jid", localcs.t);
          paramcs.putExtra("wa_type", this.Y);
          paramcs.putExtra("has_share", true);
          paramcs.putExtra("skip_preview", getIntent().getBooleanExtra("skip_preview", false));
          paramcs.putExtra("origin", getIntent().getIntExtra("origin", 0));
          paramcs.putExtra("android.intent.extra.TEXT", getIntent().getStringExtra("android.intent.extra.TEXT"));
          paramcs.putParcelableArrayListExtra("android.intent.extra.STREAM", this.Z);
          paramcs.addFlags(335544320);
        }
        for (;;)
        {
          if (paramcs == null) {
            break label617;
          }
          startActivity(paramcs);
          finish();
          return;
          localcs = this.n;
          break;
          bool1 = false;
          break label149;
          bool2 = false;
          break label162;
          if (!TextUtils.isEmpty(this.aa))
          {
            paramcs = new Intent(this, Conversation.class);
            paramcs.putExtra("jid", localcs.t);
            paramcs.putExtra("wa_type", this.Y);
            paramcs.putExtra("share_msg", this.aa);
            paramcs.putExtra("has_share", true);
            if (!this.X) {}
            for (bool2 = bool3;; bool2 = false)
            {
              paramcs.putExtra("confirm", bool2);
              paramcs.putExtra("text_from_url", this.bB);
              paramcs.putExtra("number_from_url", bool1);
              paramcs.addFlags(335544320);
              break;
            }
          }
          if (this.ab != null)
          {
            paramcs = new Intent(this, Conversation.class);
            paramcs.putExtra("jid", localcs.t);
            paramcs.putExtra("vcard_str", this.ab);
            paramcs.putExtra("vcard_name", this.ac);
            paramcs.putExtra("wa_type", this.Y);
            paramcs.putExtra("has_share", true);
            paramcs.addFlags(335544320);
          }
          else
          {
            paramcs = (cs)localObject;
            if (this.ad != null)
            {
              paramcs = new Intent(this, Conversation.class);
              paramcs.putExtra("jid", localcs.t);
              paramcs.putStringArrayListExtra("vcard_array_str", this.ad);
              paramcs.putExtra("wa_type", this.Y);
              paramcs.putExtra("has_share", true);
              paramcs.addFlags(335544320);
            }
          }
        }
      }
      paramcs = r();
      if (!TextUtils.isEmpty(this.aa))
      {
        if ((this.o.size() == 1) && (j.c(((cs)this.o.values().iterator().next()).t)))
        {
          paramcs = new Intent(this, TextStatusComposerActivity.class);
          paramcs.putExtra("android.intent.extra.TEXT", this.aa);
          startActivity(paramcs);
        }
        for (;;)
        {
          finish();
          return;
          this.bb.a(paramcs, this.aa, aug.a(aa.c(this.aa)), null, null, false, this.bB);
          pv.a(getBaseContext(), paramcs);
        }
      }
      if (this.ab != null)
      {
        this.bb.a(paramcs, this.ac, a.a.a.a.a.c.a(this, this.bd, this.aP, this.ab), null, false);
        pv.a(getBaseContext(), paramcs);
        finish();
        return;
      }
      if (this.ad != null)
      {
        this.bb.a(paramcs, this.ad, null, false);
        pv.a(getBaseContext(), paramcs);
        finish();
        return;
      }
    } while (this.Z == null);
    this.as.a(true, paramcs, this.Z, getIntent().getStringExtra("android.intent.extra.TEXT"), getIntent().getIntExtra("origin", 0), getIntent().getBooleanExtra("skip_preview", false), this, this, new ahx.a()
    {
      private final ArrayList<Uri> c = new ArrayList();
      private final ArrayList<Uri> d = new ArrayList();
      private boolean e = false;
      
      private void b()
      {
        if (this.c.size() + this.d.size() == ContactPicker.o(ContactPicker.this).size())
        {
          if ((!this.c.isEmpty()) && (!this.e)) {
            pv.a(ContactPicker.this.getBaseContext(), paramcs);
          }
          ContactPicker.this.finish();
        }
      }
      
      public final void a()
      {
        this.e = true;
      }
      
      public final void a(Uri paramAnonymousUri)
      {
        this.c.add(paramAnonymousUri);
        b();
      }
      
      public final void b(Uri paramAnonymousUri)
      {
        this.d.add(paramAnonymousUri);
        b();
      }
    });
  }
  
  final void a(cs paramcs, final View paramView)
  {
    Object localObject;
    if (((this.p) || (this.q) || (this.r)) && (this.o.isEmpty()))
    {
      this.bo.setVisibility(0);
      localObject = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
      ((Animation)localObject).setDuration(125L);
      ((Animation)localObject).setStartOffset(100L);
      ((Animation)localObject).setInterpolator(new AccelerateDecelerateInterpolator());
      ((Animation)localObject).setFillBefore(true);
      this.bo.startAnimation((Animation)localObject);
      this.bq.setVisibility(0);
      localObject = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
      ((Animation)localObject).setDuration(125L);
      ((Animation)localObject).setInterpolator(new DecelerateInterpolator());
      ((Animation)localObject).setFillBefore(true);
      this.bq.startAnimation((Animation)localObject);
    }
    float f;
    if (this.o.containsKey(paramcs.t))
    {
      this.o.remove(paramcs.t);
      paramView.setBackgroundResource(0);
      if ((j.c(paramcs.t)) && (this.br != null) && (this.br.getVisibility() != 8))
      {
        if (!this.aq.d()) {
          break label580;
        }
        f = 1.0F;
        paramView = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, f, 1, 0.0F);
        paramView.setDuration(125L);
        paramView.setStartOffset(100L);
        paramView.setInterpolator(new AccelerateDecelerateInterpolator());
        this.br.findViewById(2131755520).startAnimation(paramView);
        paramView.setAnimationListener(new Animation.AnimationListener()
        {
          public final void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            ContactPicker.t(ContactPicker.this).setVisibility(8);
          }
          
          public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public final void onAnimationStart(Animation paramAnonymousAnimation) {}
        });
      }
    }
    for (;;)
    {
      if ((this.p) || (this.q) || (this.r))
      {
        if (this.o.isEmpty())
        {
          paramView = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
          paramView.setDuration(125L);
          paramView.setInterpolator(new AccelerateDecelerateInterpolator());
          this.bo.startAnimation(paramView);
          this.bo.setVisibility(8);
          paramView = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
          paramView.setDuration(125L);
          paramView.setInterpolator(new AccelerateInterpolator());
          paramView.setFillBefore(true);
          this.bq.startAnimation(paramView);
          this.bq.setVisibility(8);
        }
      }
      else
      {
        label452:
        this.bu.add(paramcs.t);
        this.O.removeCallbacks(this.bv);
        this.O.postDelayed(this.bv, 200L);
        if (((this.p) || (this.q) || (this.r)) && (!TextUtils.isEmpty(this.aY)) && (this.o.containsKey(paramcs.t))) {
          this.bm.d();
        }
        if (this.u != null)
        {
          if (!this.o.isEmpty()) {
            break label1347;
          }
          this.u.c();
        }
        label572:
        this.aW.notifyDataSetChanged();
        return;
        label580:
        f = 0.0F;
        break;
        if ((aic.r > 0) && (this.o.size() >= aic.r))
        {
          a(0, 2131296360, new Object[] { Integer.valueOf(aic.r) });
          continue;
        }
        if ((this.o.isEmpty()) && (!this.p) && (!this.q) && (!this.r) && (this.u == null))
        {
          if (this.bn == null) {
            this.bn = new android.support.v7.view.b.a()
            {
              public final void a(android.support.v7.view.b paramAnonymousb)
              {
                ContactPicker.p(ContactPicker.this).clear();
                ContactPicker.p(ContactPicker.this).addAll(ContactPicker.f(ContactPicker.this).keySet());
                ContactPicker.r(ContactPicker.this).removeCallbacks(ContactPicker.q(ContactPicker.this));
                ContactPicker.r(ContactPicker.this).postDelayed(ContactPicker.q(ContactPicker.this), 200L);
                ContactPicker.f(ContactPicker.this).clear();
                ContactPicker.k(ContactPicker.this);
                ContactPicker.s(ContactPicker.this);
              }
              
              public final boolean a(android.support.v7.view.b paramAnonymousb, Menu paramAnonymousMenu)
              {
                if ((ContactPicker.d(ContactPicker.this)) || (ContactPicker.c(ContactPicker.this)) || (ContactPicker.e(ContactPicker.this))) {
                  android.support.v4.view.o.a(paramAnonymousMenu.add(0, 2131755076, 0, 2131297656).setIcon(2130840323), 2);
                }
                for (;;)
                {
                  return true;
                  android.support.v4.view.o.a(paramAnonymousMenu.add(0, 2131755059, 0, 2131297273), 6);
                  android.support.v4.view.o.a(paramAnonymousMenu.add(0, 2131755063, 0, 2131297143), 6);
                }
              }
              
              public final boolean a(android.support.v7.view.b paramAnonymousb, MenuItem paramAnonymousMenuItem)
              {
                if (paramAnonymousMenuItem.getItemId() == 2131755059)
                {
                  ContactPicker.this.startActivity(new Intent(ContactPicker.this, ListMembersSelector.class).putExtra("selected", new ArrayList(ContactPicker.f(ContactPicker.this).keySet())));
                  ContactPicker.this.finish();
                }
                do
                {
                  return false;
                  if (paramAnonymousMenuItem.getItemId() == 2131755063)
                  {
                    NewGroup.a(ContactPicker.this, 4, ContactPicker.f(ContactPicker.this).keySet());
                    ContactPicker.this.finish();
                    return false;
                  }
                } while (paramAnonymousMenuItem.getItemId() != 2131755076);
                boolean bool = ContactPicker.this.getIntent().getBooleanExtra("skip_preview", false);
                if (ContactPicker.o(ContactPicker.this) != null)
                {
                  paramAnonymousb = ContactPicker.o(ContactPicker.this).iterator();
                  while (paramAnonymousb.hasNext())
                  {
                    paramAnonymousMenuItem = (Uri)paramAnonymousb.next();
                    if (MediaFileUtils.e(ContactPicker.this.aE, paramAnonymousMenuItem) != 1) {
                      bool = true;
                    }
                  }
                }
                for (;;)
                {
                  if (bool)
                  {
                    a.a.a.a.d.a(ContactPicker.this, 1);
                    return false;
                  }
                  ContactPicker.a(ContactPicker.this, null);
                  return false;
                }
              }
              
              public final boolean b(android.support.v7.view.b paramAnonymousb, Menu paramAnonymousMenu)
              {
                return false;
              }
            };
          }
          this.u = a(this.bn);
        }
        this.o.put(paramcs.t, paramcs);
        paramView.setBackgroundResource(2131624041);
        if (!j.c(paramcs.t)) {
          continue;
        }
        if (!this.bg.b())
        {
          if (this.br == null)
          {
            paramView = (ViewGroup)findViewById(2131755495).findViewById(16908290);
            this.br = al.a(this.aq, getLayoutInflater(), 2130903125, null, false);
            this.br.findViewById(2131755520).setBackgroundDrawable(new az(android.support.v4.content.b.a(this, 2130840179)));
            this.br.setVisibility(8);
            paramView.addView(this.br);
          }
          if (this.br.getVisibility() != 0)
          {
            this.br.setVisibility(0);
            if (!this.aq.d()) {
              break label1061;
            }
            f = 1.0F;
            label861:
            paramView = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, f, 1, 0.0F);
            paramView.setDuration(125L);
            paramView.setStartOffset(100L);
            paramView.setInterpolator(new AccelerateDecelerateInterpolator());
            this.br.findViewById(2131755520).startAnimation(paramView);
          }
        }
        if ((this.p) && (this.ae.contains(Integer.valueOf(3))) && (getIntent().getBooleanExtra("skip_preview", false))) {
          if (this.bs == null)
          {
            this.bs = Long.valueOf(0L);
            localObject = this.Z.iterator();
            label975:
            do
            {
              if (!((Iterator)localObject).hasNext()) {
                break;
              }
              paramView = (Uri)((Iterator)localObject).next();
            } while (MediaFileUtils.e(this.aE, paramView) != 3);
          }
        }
      }
      try
      {
        paramView = MediaFileUtils.a(this.aZ, this.au, this.aE, paramView);
        if (paramView == null) {
          break label975;
        }
        this.bs = Long.valueOf(new MediaFileUtils.f(paramView).c);
      }
      catch (IOException paramView)
      {
        Log.d("contactpicker/video/", paramView);
        break label975;
        f = 0.0F;
        break label861;
        if (this.bs.longValue() <= aic.f()) {
          continue;
        }
        q();
        continue;
        if ((!this.q) || (!this.ae.contains(Integer.valueOf(3))) || (getIntent().getLongExtra("forward_video_duration", 0L) <= aic.f())) {
          continue;
        }
        q();
        continue;
        localObject = new ArrayList(this.o.size());
        Iterator localIterator = this.o.values().iterator();
        while (localIterator.hasNext())
        {
          paramView = (cs)localIterator.next();
          if (j.c(paramView.t)) {}
          for (paramView = getString(2131297237);; paramView = paramView.a(this))
          {
            if (paramView == null) {
              break label1227;
            }
            ((ArrayList)localObject).add(0, paramView);
            break;
          }
        }
        paramView = this.K.a((ArrayList)localObject);
        this.bp.a(paramView);
        if (!this.aq.d())
        {
          paramView = (HorizontalScrollView)this.bq.findViewById(2131755498);
          paramView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
          {
            public final void onGlobalLayout()
            {
              paramView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
              paramView.fullScroll(66);
            }
          });
        }
        if (TextUtils.isEmpty(this.aa)) {
          break label452;
        }
        if (this.o.size() == 1)
        {
          this.bo.setImageResource(2130840145);
          break label452;
        }
        this.bo.setImageDrawable(new az(android.support.v4.content.b.a(this, 2130840323)));
        break label452;
        this.u.b(NumberFormat.getInstance().format(this.o.size()));
        break label572;
      }
      catch (MediaFileUtils.c paramView)
      {
        label1061:
        label1227:
        label1347:
        for (;;) {}
      }
    }
  }
  
  final boolean a(cs paramcs, Intent paramIntent)
  {
    Log.i("contactpicker/picked " + paramcs.t);
    if (this.be.a(paramcs.t)) {}
    String str;
    do
    {
      return true;
      str = paramcs.t;
      this.n = paramcs;
    } while (((this.S) && (this.P.contains(str))) || (((this.p) || (this.q) || (this.r) || (this.U)) && (paramcs.d()) && (!this.K.b(str))));
    if ((this.S) && (this.X) && (!j.b(this.s)))
    {
      a.a.a.a.d.a(this, 0);
      return true;
    }
    if (this.T)
    {
      setResult(-1, a.a.a.a.d.a(getApplicationContext(), paramcs, true, true));
      finish();
      return true;
    }
    boolean bool;
    if (this.p) {
      if (this.Z != null)
      {
        bool = getIntent().getBooleanExtra("skip_preview", false);
        if (bool) {
          break label404;
        }
        paramcs = this.Z.iterator();
        while (paramcs.hasNext())
        {
          paramIntent = (Uri)paramcs.next();
          if (MediaFileUtils.e(this.aE, paramIntent) != 1) {
            bool = true;
          }
        }
      }
    }
    label404:
    for (;;)
    {
      if (bool)
      {
        a.a.a.a.d.a(this, 1);
        return true;
      }
      a(null);
      return true;
      if ((this.aa != null) && (this.aa.length() > 0))
      {
        if (this.X)
        {
          a.a.a.a.d.a(this, 1);
          return true;
        }
        a(null);
        return true;
      }
      if (this.ab != null)
      {
        a.a.a.a.d.a(this, 1);
        return true;
      }
      if (this.ad == null) {
        break;
      }
      a.a.a.a.d.a(this, 1);
      return true;
      if (this.q)
      {
        a.a.a.a.d.a(this, 2);
        return true;
      }
      if (this.U)
      {
        a.a.a.a.d.a(this, 3);
        return true;
      }
      if ((this.V) && (paramIntent != null)) {}
      for (;;)
      {
        paramIntent.putExtra("contact", str);
        setResult(-1, paramIntent);
        finish();
        return true;
        paramIntent = new Intent();
      }
    }
  }
  
  public final void b(android.support.v7.view.b paramb)
  {
    super.b(paramb);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(android.support.v4.content.b.c(this, 2131624092));
    }
  }
  
  public final void c(int paramInt)
  {
    if ((paramInt == 2131296666) || (paramInt == 2131296661) || (paramInt == 2131296667) || (paramInt == 2131296665) || (paramInt == 2131296664) || (paramInt == 2131296662) || (paramInt == 2131296663) || (paramInt == 2131296668) || (paramInt == 2131296669) || (paramInt == 2131296670) || (paramInt == 2131296672) || (paramInt == 2131296671))
    {
      startActivity(new Intent(this, Main.class));
      finish();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (IllegalArgumentException paramMotionEvent) {}
    return false;
  }
  
  /* Error */
  protected final void l()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 965	com/whatsapp/ContactPicker:getIntent	()Landroid/content/Intent;
    //   4: astore 17
    //   6: aload_0
    //   7: getfield 213	com/whatsapp/ContactPicker:ae	Ljava/util/HashSet;
    //   10: invokevirtual 1370	java/util/HashSet:clear	()V
    //   13: aload 17
    //   15: invokevirtual 1373	android/content/Intent:getAction	()Ljava/lang/String;
    //   18: ifnull +621 -> 639
    //   21: aload 17
    //   23: invokevirtual 1373	android/content/Intent:getAction	()Ljava/lang/String;
    //   26: ldc_w 1375
    //   29: invokevirtual 1378	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   32: ifeq +607 -> 639
    //   35: aload_0
    //   36: iconst_1
    //   37: putfield 374	com/whatsapp/ContactPicker:T	Z
    //   40: aload 17
    //   42: ldc_w 945
    //   45: invokevirtual 983	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   48: astore 6
    //   50: aload 6
    //   52: ifnull +27 -> 79
    //   55: aload_0
    //   56: getfield 264	com/whatsapp/ContactPicker:bd	Lcom/whatsapp/data/e;
    //   59: aload 6
    //   61: invokevirtual 1380	com/whatsapp/data/e:c	(Ljava/lang/String;)Lcom/whatsapp/data/cs;
    //   64: astore 6
    //   66: aload 6
    //   68: ifnull +11 -> 79
    //   71: aload_0
    //   72: aload 6
    //   74: aconst_null
    //   75: invokevirtual 603	com/whatsapp/ContactPicker:a	(Lcom/whatsapp/data/cs;Landroid/content/Intent;)Z
    //   78: pop
    //   79: ldc_w 1382
    //   82: invokestatic 835	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   85: aload_0
    //   86: invokespecial 749	com/whatsapp/ContactPicker:s	()V
    //   89: aload_0
    //   90: aload_0
    //   91: ldc_w 1383
    //   94: invokevirtual 1181	com/whatsapp/ContactPicker:findViewById	(I)Landroid/view/View;
    //   97: checkcast 407	android/widget/ListView
    //   100: putfield 1310	com/whatsapp/ContactPicker:v	Landroid/widget/ListView;
    //   103: aload_0
    //   104: getfield 538	com/whatsapp/ContactPicker:p	Z
    //   107: ifne +17 -> 124
    //   110: aload_0
    //   111: getfield 744	com/whatsapp/ContactPicker:q	Z
    //   114: ifne +10 -> 124
    //   117: aload_0
    //   118: getfield 746	com/whatsapp/ContactPicker:r	Z
    //   121: ifeq +4345 -> 4466
    //   124: aload_0
    //   125: getfield 1310	com/whatsapp/ContactPicker:v	Landroid/widget/ListView;
    //   128: aconst_null
    //   129: invokevirtual 1386	android/widget/ListView:setDivider	(Landroid/graphics/drawable/Drawable;)V
    //   132: aload_0
    //   133: getfield 1310	com/whatsapp/ContactPicker:v	Landroid/widget/ListView;
    //   136: iconst_0
    //   137: invokevirtual 1389	android/widget/ListView:setHeaderDividersEnabled	(Z)V
    //   140: aload_0
    //   141: getfield 1310	com/whatsapp/ContactPicker:v	Landroid/widget/ListView;
    //   144: iconst_1
    //   145: invokevirtual 1392	android/widget/ListView:setScrollbarFadingEnabled	(Z)V
    //   148: aload_0
    //   149: getfield 1310	com/whatsapp/ContactPicker:v	Landroid/widget/ListView;
    //   152: iconst_1
    //   153: invokevirtual 1395	android/widget/ListView:setTextFilterEnabled	(Z)V
    //   156: aload_0
    //   157: getfield 1310	com/whatsapp/ContactPicker:v	Landroid/widget/ListView;
    //   160: aload_0
    //   161: ldc_w 1396
    //   164: invokevirtual 1181	com/whatsapp/ContactPicker:findViewById	(I)Landroid/view/View;
    //   167: invokevirtual 1399	android/widget/ListView:setEmptyView	(Landroid/view/View;)V
    //   170: aload_0
    //   171: ldc_w 1400
    //   174: invokevirtual 1181	com/whatsapp/ContactPicker:findViewById	(I)Landroid/view/View;
    //   177: checkcast 1184	android/view/ViewGroup
    //   180: astore 6
    //   182: aload 6
    //   184: invokevirtual 1403	android/view/ViewGroup:getChildCount	()I
    //   187: ifne +21 -> 208
    //   190: aload_0
    //   191: getfield 608	com/whatsapp/ContactPicker:aq	Lcom/whatsapp/pv;
    //   194: aload_0
    //   195: invokevirtual 612	com/whatsapp/ContactPicker:getLayoutInflater	()Landroid/view/LayoutInflater;
    //   198: ldc_w 1404
    //   201: aload 6
    //   203: iconst_1
    //   204: invokestatic 618	com/whatsapp/al:a	(Lcom/whatsapp/pv;Landroid/view/LayoutInflater;ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   207: pop
    //   208: getstatic 882	android/os/Build$VERSION:SDK_INT	I
    //   211: bipush 11
    //   213: if_icmplt +4347 -> 4560
    //   216: aload_0
    //   217: getfield 538	com/whatsapp/ContactPicker:p	Z
    //   220: ifne +4278 -> 4498
    //   223: aload_0
    //   224: getfield 744	com/whatsapp/ContactPicker:q	Z
    //   227: ifne +4271 -> 4498
    //   230: aload_0
    //   231: getfield 746	com/whatsapp/ContactPicker:r	Z
    //   234: ifne +4264 -> 4498
    //   237: iconst_1
    //   238: istore_3
    //   239: aload_0
    //   240: getfield 1310	com/whatsapp/ContactPicker:v	Landroid/widget/ListView;
    //   243: iload_3
    //   244: invokevirtual 1407	android/widget/ListView:setFastScrollEnabled	(Z)V
    //   247: aload_0
    //   248: getfield 1310	com/whatsapp/ContactPicker:v	Landroid/widget/ListView;
    //   251: iload_3
    //   252: invokevirtual 1410	android/widget/ListView:setFastScrollAlwaysVisible	(Z)V
    //   255: iload_3
    //   256: ifeq +4279 -> 4535
    //   259: aload_0
    //   260: getfield 1310	com/whatsapp/ContactPicker:v	Landroid/widget/ListView;
    //   263: ldc_w 1411
    //   266: invokevirtual 1414	android/widget/ListView:setScrollBarStyle	(I)V
    //   269: aload_0
    //   270: getfield 608	com/whatsapp/ContactPicker:aq	Lcom/whatsapp/pv;
    //   273: getfield 1416	com/whatsapp/pv:a	Z
    //   276: ifeq +4227 -> 4503
    //   279: aload_0
    //   280: getfield 1310	com/whatsapp/ContactPicker:v	Landroid/widget/ListView;
    //   283: aload_0
    //   284: invokevirtual 1420	com/whatsapp/ContactPicker:getResources	()Landroid/content/res/Resources;
    //   287: ldc_w 1421
    //   290: invokevirtual 1427	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   293: iconst_0
    //   294: aload_0
    //   295: invokevirtual 1420	com/whatsapp/ContactPicker:getResources	()Landroid/content/res/Resources;
    //   298: ldc_w 1428
    //   301: invokevirtual 1427	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   304: iconst_0
    //   305: invokevirtual 1432	android/widget/ListView:setPadding	(IIII)V
    //   308: aload_0
    //   309: getfield 608	com/whatsapp/ContactPicker:aq	Lcom/whatsapp/pv;
    //   312: getfield 1416	com/whatsapp/pv:a	Z
    //   315: ifeq +4234 -> 4549
    //   318: aload_0
    //   319: getfield 1310	com/whatsapp/ContactPicker:v	Landroid/widget/ListView;
    //   322: iconst_1
    //   323: invokevirtual 1435	android/widget/ListView:setVerticalScrollbarPosition	(I)V
    //   326: aload_0
    //   327: getfield 1310	com/whatsapp/ContactPicker:v	Landroid/widget/ListView;
    //   330: aload_0
    //   331: invokestatic 1440	com/whatsapp/dt:a	(Lcom/whatsapp/ContactPicker;)Landroid/widget/AdapterView$OnItemClickListener;
    //   334: invokevirtual 1444	android/widget/ListView:setOnItemClickListener	(Landroid/widget/AdapterView$OnItemClickListener;)V
    //   337: aload_0
    //   338: getfield 870	com/whatsapp/ContactPicker:W	Z
    //   341: ifne +24 -> 365
    //   344: aload_0
    //   345: getfield 744	com/whatsapp/ContactPicker:q	Z
    //   348: ifne +17 -> 365
    //   351: aload_0
    //   352: getfield 538	com/whatsapp/ContactPicker:p	Z
    //   355: ifne +10 -> 365
    //   358: aload_0
    //   359: getfield 746	com/whatsapp/ContactPicker:r	Z
    //   362: ifeq +14 -> 376
    //   365: aload_0
    //   366: getfield 1310	com/whatsapp/ContactPicker:v	Landroid/widget/ListView;
    //   369: aload_0
    //   370: invokestatic 1449	com/whatsapp/du:a	(Lcom/whatsapp/ContactPicker;)Landroid/widget/AdapterView$OnItemLongClickListener;
    //   373: invokevirtual 1453	android/widget/ListView:setOnItemLongClickListener	(Landroid/widget/AdapterView$OnItemLongClickListener;)V
    //   376: aload_0
    //   377: invokestatic 1458	com/whatsapp/dv:a	(Lcom/whatsapp/ContactPicker;)Landroid/view/View$OnClickListener;
    //   380: astore 6
    //   382: aload_0
    //   383: ldc_w 1459
    //   386: invokevirtual 1181	com/whatsapp/ContactPicker:findViewById	(I)Landroid/view/View;
    //   389: aload 6
    //   391: invokevirtual 1463	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   394: aload_0
    //   395: getfield 870	com/whatsapp/ContactPicker:W	Z
    //   398: ifne +10 -> 408
    //   401: aload_0
    //   402: getfield 867	com/whatsapp/ContactPicker:V	Z
    //   405: ifeq +57 -> 462
    //   408: aload_0
    //   409: getfield 608	com/whatsapp/ContactPicker:aq	Lcom/whatsapp/pv;
    //   412: aload_0
    //   413: invokevirtual 612	com/whatsapp/ContactPicker:getLayoutInflater	()Landroid/view/LayoutInflater;
    //   416: ldc_w 1464
    //   419: invokestatic 1467	com/whatsapp/al:a	(Lcom/whatsapp/pv;Landroid/view/LayoutInflater;I)Landroid/view/View;
    //   422: astore 6
    //   424: aload_0
    //   425: getfield 1310	com/whatsapp/ContactPicker:v	Landroid/widget/ListView;
    //   428: aload 6
    //   430: aconst_null
    //   431: iconst_1
    //   432: invokevirtual 1471	android/widget/ListView:addFooterView	(Landroid/view/View;Ljava/lang/Object;Z)V
    //   435: aload_0
    //   436: getfield 608	com/whatsapp/ContactPicker:aq	Lcom/whatsapp/pv;
    //   439: aload_0
    //   440: invokevirtual 612	com/whatsapp/ContactPicker:getLayoutInflater	()Landroid/view/LayoutInflater;
    //   443: ldc_w 1472
    //   446: invokestatic 1467	com/whatsapp/al:a	(Lcom/whatsapp/pv;Landroid/view/LayoutInflater;I)Landroid/view/View;
    //   449: astore 6
    //   451: aload_0
    //   452: getfield 1310	com/whatsapp/ContactPicker:v	Landroid/widget/ListView;
    //   455: aload 6
    //   457: aconst_null
    //   458: iconst_1
    //   459: invokevirtual 1471	android/widget/ListView:addFooterView	(Landroid/view/View;Ljava/lang/Object;Z)V
    //   462: aload_0
    //   463: aload_0
    //   464: getfield 1310	com/whatsapp/ContactPicker:v	Landroid/widget/ListView;
    //   467: invokevirtual 1475	com/whatsapp/ContactPicker:registerForContextMenu	(Landroid/view/View;)V
    //   470: aload_0
    //   471: getfield 386	com/whatsapp/ContactPicker:R	Z
    //   474: ifne +31 -> 505
    //   477: aload_0
    //   478: getfield 365	com/whatsapp/ContactPicker:S	Z
    //   481: ifne +24 -> 505
    //   484: aload_0
    //   485: getfield 361	com/whatsapp/ContactPicker:U	Z
    //   488: ifne +17 -> 505
    //   491: aload_0
    //   492: getfield 867	com/whatsapp/ContactPicker:V	Z
    //   495: ifne +10 -> 505
    //   498: aload_0
    //   499: getfield 870	com/whatsapp/ContactPicker:W	Z
    //   502: ifeq +4079 -> 4581
    //   505: aload_0
    //   506: new 43	com/whatsapp/ContactPicker$d
    //   509: dup
    //   510: aload_0
    //   511: iconst_0
    //   512: invokespecial 1476	com/whatsapp/ContactPicker$d:<init>	(Lcom/whatsapp/ContactPicker;B)V
    //   515: putfield 404	com/whatsapp/ContactPicker:aW	Lcom/whatsapp/ContactPicker$b;
    //   518: aload_0
    //   519: getfield 870	com/whatsapp/ContactPicker:W	Z
    //   522: ifeq +4075 -> 4597
    //   525: aload_0
    //   526: ldc_w 1477
    //   529: ldc_w 1478
    //   532: invokespecial 1480	com/whatsapp/ContactPicker:b	(II)Landroid/view/View;
    //   535: astore 6
    //   537: aload 6
    //   539: aload_0
    //   540: invokestatic 1483	com/whatsapp/dw:a	(Lcom/whatsapp/ContactPicker;)Landroid/view/View$OnClickListener;
    //   543: invokevirtual 1463	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   546: aload_0
    //   547: getfield 1310	com/whatsapp/ContactPicker:v	Landroid/widget/ListView;
    //   550: aload 6
    //   552: aconst_null
    //   553: iconst_1
    //   554: invokevirtual 1486	android/widget/ListView:addHeaderView	(Landroid/view/View;Ljava/lang/Object;Z)V
    //   557: aload_0
    //   558: getfield 1310	com/whatsapp/ContactPicker:v	Landroid/widget/ListView;
    //   561: aload_0
    //   562: getfield 404	com/whatsapp/ContactPicker:aW	Lcom/whatsapp/ContactPicker$b;
    //   565: invokevirtual 1490	android/widget/ListView:setAdapter	(Landroid/widget/ListAdapter;)V
    //   568: aload_0
    //   569: getfield 744	com/whatsapp/ContactPicker:q	Z
    //   572: ifne +17 -> 589
    //   575: aload_0
    //   576: getfield 538	com/whatsapp/ContactPicker:p	Z
    //   579: ifne +10 -> 589
    //   582: aload_0
    //   583: getfield 746	com/whatsapp/ContactPicker:r	Z
    //   586: ifeq +18 -> 604
    //   589: aload_0
    //   590: getfield 1310	com/whatsapp/ContactPicker:v	Landroid/widget/ListView;
    //   593: new 12	com/whatsapp/ContactPicker$12
    //   596: dup
    //   597: aload_0
    //   598: invokespecial 1491	com/whatsapp/ContactPicker$12:<init>	(Lcom/whatsapp/ContactPicker;)V
    //   601: invokevirtual 1495	android/widget/ListView:setOnScrollListener	(Landroid/widget/AbsListView$OnScrollListener;)V
    //   604: aload_0
    //   605: aload_0
    //   606: getfield 354	com/whatsapp/ContactPicker:bA	Lcom/whatsapp/atv;
    //   609: invokevirtual 899	com/whatsapp/atv:b	()Z
    //   612: putfield 901	com/whatsapp/ContactPicker:bk	Z
    //   615: aload_0
    //   616: new 22	com/whatsapp/ContactPicker$6
    //   619: dup
    //   620: aload_0
    //   621: invokespecial 1496	com/whatsapp/ContactPicker$6:<init>	(Lcom/whatsapp/ContactPicker;)V
    //   624: putfield 333	com/whatsapp/ContactPicker:bx	Lcom/whatsapp/dh$a;
    //   627: aload_0
    //   628: getfield 331	com/whatsapp/ContactPicker:bw	Lcom/whatsapp/dh;
    //   631: aload_0
    //   632: getfield 333	com/whatsapp/ContactPicker:bx	Lcom/whatsapp/dh$a;
    //   635: invokevirtual 1500	com/whatsapp/dh:registerObserver	(Ljava/lang/Object;)V
    //   638: return
    //   639: aload 17
    //   641: ldc_w 1502
    //   644: iconst_0
    //   645: invokevirtual 969	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   648: ifeq +11 -> 659
    //   651: aload_0
    //   652: iconst_1
    //   653: putfield 867	com/whatsapp/ContactPicker:V	Z
    //   656: goto -616 -> 40
    //   659: aload 17
    //   661: ldc_w 1504
    //   664: iconst_0
    //   665: invokevirtual 969	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   668: ifeq +55 -> 723
    //   671: aload_0
    //   672: invokevirtual 1507	com/whatsapp/ContactPicker:i	()Landroid/support/v7/app/a;
    //   675: ldc_w 1508
    //   678: invokevirtual 1512	android/support/v7/app/a:a	(I)V
    //   681: aload_0
    //   682: iconst_1
    //   683: putfield 744	com/whatsapp/ContactPicker:q	Z
    //   686: aload_0
    //   687: aload 17
    //   689: ldc_w 1514
    //   692: invokevirtual 983	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   695: putfield 383	com/whatsapp/ContactPicker:af	Ljava/lang/String;
    //   698: aload_0
    //   699: getfield 213	com/whatsapp/ContactPicker:ae	Ljava/util/HashSet;
    //   702: aload 17
    //   704: ldc_w 1516
    //   707: invokevirtual 1519	android/content/Intent:getIntegerArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   710: invokestatic 1521	a/a/a/a/a/a$d:a	(Ljava/lang/Object;)Ljava/lang/Object;
    //   713: checkcast 793	java/util/Collection
    //   716: invokevirtual 1525	java/util/HashSet:addAll	(Ljava/util/Collection;)Z
    //   719: pop
    //   720: goto -680 -> 40
    //   723: aload 17
    //   725: ldc_w 1527
    //   728: iconst_0
    //   729: invokevirtual 969	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   732: ifeq +89 -> 821
    //   735: aload_0
    //   736: invokevirtual 1507	com/whatsapp/ContactPicker:i	()Landroid/support/v7/app/a;
    //   739: ldc_w 1528
    //   742: invokevirtual 1512	android/support/v7/app/a:a	(I)V
    //   745: aload_0
    //   746: iconst_1
    //   747: putfield 746	com/whatsapp/ContactPicker:r	Z
    //   750: aload_0
    //   751: getfield 213	com/whatsapp/ContactPicker:ae	Ljava/util/HashSet;
    //   754: aload 17
    //   756: ldc_w 1516
    //   759: invokevirtual 1519	android/content/Intent:getIntegerArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   762: invokestatic 1521	a/a/a/a/a/a$d:a	(Ljava/lang/Object;)Ljava/lang/Object;
    //   765: checkcast 793	java/util/Collection
    //   768: invokevirtual 1525	java/util/HashSet:addAll	(Ljava/util/Collection;)Z
    //   771: pop
    //   772: aload 17
    //   774: ldc_w 961
    //   777: iconst_0
    //   778: invokevirtual 969	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   781: ifeq +27 -> 808
    //   784: aload_0
    //   785: getfield 1072	com/whatsapp/ContactPicker:bo	Landroid/widget/ImageView;
    //   788: new 1187	com/whatsapp/util/az
    //   791: dup
    //   792: aload_0
    //   793: ldc_w 1292
    //   796: invokestatic 1191	android/support/v4/content/b:a	(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    //   799: invokespecial 1194	com/whatsapp/util/az:<init>	(Landroid/graphics/drawable/Drawable;)V
    //   802: invokevirtual 1295	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   805: goto -765 -> 40
    //   808: aload_0
    //   809: getfield 1072	com/whatsapp/ContactPicker:bo	Landroid/widget/ImageView;
    //   812: ldc_w 1291
    //   815: invokevirtual 632	android/widget/ImageView:setImageResource	(I)V
    //   818: goto -778 -> 40
    //   821: aload 17
    //   823: ldc_w 1530
    //   826: iconst_0
    //   827: invokevirtual 969	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   830: ifeq +21 -> 851
    //   833: aload_0
    //   834: invokevirtual 1507	com/whatsapp/ContactPicker:i	()Landroid/support/v7/app/a;
    //   837: ldc_w 1531
    //   840: invokevirtual 1512	android/support/v7/app/a:a	(I)V
    //   843: aload_0
    //   844: iconst_1
    //   845: putfield 361	com/whatsapp/ContactPicker:U	Z
    //   848: goto -808 -> 40
    //   851: aload 17
    //   853: ldc_w 1533
    //   856: invokevirtual 983	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   859: astore 6
    //   861: aload_0
    //   862: aload 6
    //   864: putfield 371	com/whatsapp/ContactPicker:s	Ljava/lang/String;
    //   867: aload 6
    //   869: ifnull +49 -> 918
    //   872: aload_0
    //   873: iconst_1
    //   874: putfield 365	com/whatsapp/ContactPicker:S	Z
    //   877: aload_0
    //   878: iconst_1
    //   879: putfield 536	com/whatsapp/ContactPicker:X	Z
    //   882: aload_0
    //   883: getfield 207	com/whatsapp/ContactPicker:P	Ljava/util/Set;
    //   886: invokeinterface 1534 1 0
    //   891: aload_0
    //   892: getfield 207	com/whatsapp/ContactPicker:P	Ljava/util/Set;
    //   895: aload_0
    //   896: getfield 1262	com/whatsapp/ContactPicker:K	Lcom/whatsapp/rh;
    //   899: aload_0
    //   900: getfield 371	com/whatsapp/ContactPicker:s	Ljava/lang/String;
    //   903: invokevirtual 1537	com/whatsapp/rh:a	(Ljava/lang/String;)Lcom/whatsapp/rg;
    //   906: invokevirtual 1542	com/whatsapp/rg:a	()Ljava/util/Set;
    //   909: invokeinterface 1543 2 0
    //   914: pop
    //   915: goto -875 -> 40
    //   918: aload 17
    //   920: ldc_w 1545
    //   923: iconst_0
    //   924: invokevirtual 969	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   927: ifeq +21 -> 948
    //   930: aload_0
    //   931: invokevirtual 1507	com/whatsapp/ContactPicker:i	()Landroid/support/v7/app/a;
    //   934: ldc_w 1546
    //   937: invokevirtual 1512	android/support/v7/app/a:a	(I)V
    //   940: aload_0
    //   941: iconst_1
    //   942: putfield 377	com/whatsapp/ContactPicker:Q	Z
    //   945: goto -905 -> 40
    //   948: aload 17
    //   950: ldc_w 1548
    //   953: iconst_0
    //   954: invokevirtual 969	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   957: ifeq +86 -> 1043
    //   960: aload_0
    //   961: iconst_1
    //   962: putfield 386	com/whatsapp/ContactPicker:R	Z
    //   965: aload 17
    //   967: ldc_w 1550
    //   970: invokevirtual 983	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   973: astore 6
    //   975: aload 6
    //   977: ifnull -937 -> 40
    //   980: aload 6
    //   982: invokevirtual 471	java/lang/String:length	()I
    //   985: iconst_1
    //   986: if_icmple -946 -> 40
    //   989: aload 6
    //   991: ldc_w 1552
    //   994: invokevirtual 1556	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   997: astore 6
    //   999: aload 6
    //   1001: arraylength
    //   1002: istore_2
    //   1003: iconst_0
    //   1004: istore_1
    //   1005: iload_1
    //   1006: iload_2
    //   1007: if_icmpge -967 -> 40
    //   1010: aload 6
    //   1012: iload_1
    //   1013: aaload
    //   1014: astore 7
    //   1016: aload 7
    //   1018: invokevirtual 471	java/lang/String:length	()I
    //   1021: ifle +15 -> 1036
    //   1024: aload_0
    //   1025: getfield 207	com/whatsapp/ContactPicker:P	Ljava/util/Set;
    //   1028: aload 7
    //   1030: invokeinterface 1142 2 0
    //   1035: pop
    //   1036: iload_1
    //   1037: iconst_1
    //   1038: iadd
    //   1039: istore_1
    //   1040: goto -35 -> 1005
    //   1043: ldc_w 1558
    //   1046: aload 17
    //   1048: invokevirtual 1561	android/content/Intent:getScheme	()Ljava/lang/String;
    //   1051: invokevirtual 1378	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1054: ifeq +75 -> 1129
    //   1057: aload 17
    //   1059: invokevirtual 1565	android/content/Intent:getData	()Landroid/net/Uri;
    //   1062: astore 6
    //   1064: aload 6
    //   1066: ifnull +26 -> 1092
    //   1069: ldc_w 1527
    //   1072: aload 6
    //   1074: invokevirtual 1568	android/net/Uri:getHost	()Ljava/lang/String;
    //   1077: invokevirtual 1378	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1080: ifeq +12 -> 1092
    //   1083: aload_0
    //   1084: aload 6
    //   1086: invokespecial 1570	com/whatsapp/ContactPicker:a	(Landroid/net/Uri;)V
    //   1089: goto -1049 -> 40
    //   1092: new 431	java/lang/StringBuilder
    //   1095: dup
    //   1096: ldc_w 1572
    //   1099: invokespecial 436	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1102: aload 6
    //   1104: invokevirtual 850	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1107: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1110: invokestatic 496	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   1113: aload_0
    //   1114: invokevirtual 500	com/whatsapp/ContactPicker:getBaseContext	()Landroid/content/Context;
    //   1117: ldc_w 501
    //   1120: iconst_0
    //   1121: invokestatic 506	com/whatsapp/pv:a	(Landroid/content/Context;II)V
    //   1124: aload_0
    //   1125: invokevirtual 509	com/whatsapp/ContactPicker:finish	()V
    //   1128: return
    //   1129: ldc_w 1574
    //   1132: aload 17
    //   1134: invokevirtual 1561	android/content/Intent:getScheme	()Ljava/lang/String;
    //   1137: invokevirtual 1378	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1140: ifne +17 -> 1157
    //   1143: ldc_w 1576
    //   1146: aload 17
    //   1148: invokevirtual 1561	android/content/Intent:getScheme	()Ljava/lang/String;
    //   1151: invokevirtual 1378	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1154: ifeq +89 -> 1243
    //   1157: aload 17
    //   1159: invokevirtual 1565	android/content/Intent:getData	()Landroid/net/Uri;
    //   1162: astore 6
    //   1164: aload 6
    //   1166: ifnull +40 -> 1206
    //   1169: ldc_w 1578
    //   1172: aload 6
    //   1174: invokevirtual 1568	android/net/Uri:getHost	()Ljava/lang/String;
    //   1177: invokevirtual 1378	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1180: ifeq +26 -> 1206
    //   1183: ldc_w 1580
    //   1186: aload 6
    //   1188: invokevirtual 1583	android/net/Uri:getPath	()Ljava/lang/String;
    //   1191: invokevirtual 1378	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1194: ifeq +12 -> 1206
    //   1197: aload_0
    //   1198: aload 6
    //   1200: invokespecial 1570	com/whatsapp/ContactPicker:a	(Landroid/net/Uri;)V
    //   1203: goto -1163 -> 40
    //   1206: new 431	java/lang/StringBuilder
    //   1209: dup
    //   1210: ldc_w 1585
    //   1213: invokespecial 436	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1216: aload 6
    //   1218: invokevirtual 850	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1221: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1224: invokestatic 496	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   1227: aload_0
    //   1228: invokevirtual 500	com/whatsapp/ContactPicker:getBaseContext	()Landroid/content/Context;
    //   1231: ldc_w 501
    //   1234: iconst_0
    //   1235: invokestatic 506	com/whatsapp/pv:a	(Landroid/content/Context;II)V
    //   1238: aload_0
    //   1239: invokevirtual 509	com/whatsapp/ContactPicker:finish	()V
    //   1242: return
    //   1243: aload 17
    //   1245: invokevirtual 1589	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   1248: ifnull +3210 -> 4458
    //   1251: aload_0
    //   1252: invokevirtual 1507	com/whatsapp/ContactPicker:i	()Landroid/support/v7/app/a;
    //   1255: ldc_w 1590
    //   1258: invokevirtual 1512	android/support/v7/app/a:a	(I)V
    //   1261: aload_0
    //   1262: iconst_1
    //   1263: putfield 536	com/whatsapp/ContactPicker:X	Z
    //   1266: aload_0
    //   1267: iconst_1
    //   1268: putfield 538	com/whatsapp/ContactPicker:p	Z
    //   1271: aload_0
    //   1272: invokevirtual 965	com/whatsapp/ContactPicker:getIntent	()Landroid/content/Intent;
    //   1275: invokevirtual 1593	android/content/Intent:getType	()Ljava/lang/String;
    //   1278: astore 6
    //   1280: aload 6
    //   1282: ifnonnull +220 -> 1502
    //   1285: new 431	java/lang/StringBuilder
    //   1288: dup
    //   1289: ldc_w 1595
    //   1292: invokespecial 436	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1295: aload 17
    //   1297: invokevirtual 1596	android/content/Intent:toString	()Ljava/lang/String;
    //   1300: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1303: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1306: invokestatic 534	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1309: aload_0
    //   1310: invokevirtual 965	com/whatsapp/ContactPicker:getIntent	()Landroid/content/Intent;
    //   1313: ldc_w 980
    //   1316: invokevirtual 1599	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   1319: ifeq +167 -> 1486
    //   1322: aload_0
    //   1323: iconst_0
    //   1324: putfield 486	com/whatsapp/ContactPicker:Y	B
    //   1327: aload_0
    //   1328: getfield 1212	com/whatsapp/ContactPicker:aE	Lcom/whatsapp/and;
    //   1331: getfield 1604	com/whatsapp/and:b	Landroid/app/ActivityManager;
    //   1334: astore 6
    //   1336: aload 6
    //   1338: ifnonnull +238 -> 1576
    //   1341: ldc_w 1606
    //   1344: invokestatic 449	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   1347: aload_0
    //   1348: getfield 486	com/whatsapp/ContactPicker:Y	B
    //   1351: ifne +337 -> 1688
    //   1354: aload_0
    //   1355: invokevirtual 965	com/whatsapp/ContactPicker:getIntent	()Landroid/content/Intent;
    //   1358: ldc_w 980
    //   1361: invokevirtual 983	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1364: astore 6
    //   1366: aload 6
    //   1368: ifnull +60 -> 1428
    //   1371: aload 6
    //   1373: invokevirtual 1610	java/lang/String:getBytes	()[B
    //   1376: astore 7
    //   1378: aload 7
    //   1380: arraylength
    //   1381: sipush 4096
    //   1384: if_icmple +18 -> 1402
    //   1387: new 468	java/lang/String
    //   1390: dup
    //   1391: aload 7
    //   1393: iconst_0
    //   1394: sipush 4096
    //   1397: invokespecial 1613	java/lang/String:<init>	([BII)V
    //   1400: astore 6
    //   1402: aload_0
    //   1403: new 431	java/lang/StringBuilder
    //   1406: dup
    //   1407: invokespecial 1614	java/lang/StringBuilder:<init>	()V
    //   1410: aload_0
    //   1411: getfield 211	com/whatsapp/ContactPicker:aa	Ljava/lang/String;
    //   1414: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1417: aload 6
    //   1419: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1422: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1425: putfield 211	com/whatsapp/ContactPicker:aa	Ljava/lang/String;
    //   1428: aload_0
    //   1429: getfield 608	com/whatsapp/ContactPicker:aq	Lcom/whatsapp/pv;
    //   1432: aload_0
    //   1433: getfield 211	com/whatsapp/ContactPicker:aa	Ljava/lang/String;
    //   1436: invokestatic 1029	com/whatsapp/util/aa:c	(Ljava/lang/String;)Ljava/lang/String;
    //   1439: aconst_null
    //   1440: invokestatic 1617	com/whatsapp/aug:a	(Lcom/whatsapp/pv;Ljava/lang/String;Lcom/whatsapp/aug$a;)V
    //   1443: aload_0
    //   1444: iconst_0
    //   1445: putfield 536	com/whatsapp/ContactPicker:X	Z
    //   1448: aload_0
    //   1449: getfield 213	com/whatsapp/ContactPicker:ae	Ljava/util/HashSet;
    //   1452: iconst_0
    //   1453: invokestatic 543	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1456: invokevirtual 547	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   1459: pop
    //   1460: new 431	java/lang/StringBuilder
    //   1463: dup
    //   1464: ldc_w 1619
    //   1467: invokespecial 436	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1470: aload_0
    //   1471: getfield 211	com/whatsapp/ContactPicker:aa	Ljava/lang/String;
    //   1474: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1477: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1480: invokestatic 835	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   1483: goto -1443 -> 40
    //   1486: aload_0
    //   1487: invokevirtual 500	com/whatsapp/ContactPicker:getBaseContext	()Landroid/content/Context;
    //   1490: ldc_w 1620
    //   1493: iconst_0
    //   1494: invokestatic 506	com/whatsapp/pv:a	(Landroid/content/Context;II)V
    //   1497: aload_0
    //   1498: invokevirtual 509	com/whatsapp/ContactPicker:finish	()V
    //   1501: return
    //   1502: aload_0
    //   1503: aload 6
    //   1505: invokestatic 1623	com/whatsapp/util/MediaFileUtils:f	(Ljava/lang/String;)B
    //   1508: putfield 486	com/whatsapp/ContactPicker:Y	B
    //   1511: aload_0
    //   1512: getfield 486	com/whatsapp/ContactPicker:Y	B
    //   1515: ifne +35 -> 1550
    //   1518: aload_0
    //   1519: invokevirtual 965	com/whatsapp/ContactPicker:getIntent	()Landroid/content/Intent;
    //   1522: ldc_w 980
    //   1525: invokevirtual 1599	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   1528: ifne +22 -> 1550
    //   1531: aload_0
    //   1532: invokevirtual 965	com/whatsapp/ContactPicker:getIntent	()Landroid/content/Intent;
    //   1535: ldc_w 985
    //   1538: invokevirtual 1599	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   1541: ifeq +9 -> 1550
    //   1544: aload_0
    //   1545: bipush 9
    //   1547: putfield 486	com/whatsapp/ContactPicker:Y	B
    //   1550: new 431	java/lang/StringBuilder
    //   1553: dup
    //   1554: ldc_w 1625
    //   1557: invokespecial 436	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1560: aload_0
    //   1561: getfield 486	com/whatsapp/ContactPicker:Y	B
    //   1564: invokevirtual 476	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1567: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1570: invokestatic 835	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   1573: goto -246 -> 1327
    //   1576: aload 6
    //   1578: iconst_4
    //   1579: iconst_1
    //   1580: invokevirtual 1631	android/app/ActivityManager:getRecentTasks	(II)Ljava/util/List;
    //   1583: invokeinterface 559 1 0
    //   1588: astore 6
    //   1590: aload 6
    //   1592: invokeinterface 565 1 0
    //   1597: ifeq -250 -> 1347
    //   1600: aload 6
    //   1602: invokeinterface 569 1 0
    //   1607: checkcast 1633	android/app/ActivityManager$RecentTaskInfo
    //   1610: getfield 1637	android/app/ActivityManager$RecentTaskInfo:baseIntent	Landroid/content/Intent;
    //   1613: astore 7
    //   1615: aload 7
    //   1617: ifnull -27 -> 1590
    //   1620: aload 7
    //   1622: invokevirtual 1641	android/content/Intent:getComponent	()Landroid/content/ComponentName;
    //   1625: astore 7
    //   1627: aload 7
    //   1629: ifnull -39 -> 1590
    //   1632: aload 7
    //   1634: invokevirtual 1646	android/content/ComponentName:getPackageName	()Ljava/lang/String;
    //   1637: astore 7
    //   1639: ldc_w 1648
    //   1642: aload 7
    //   1644: invokevirtual 1378	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1647: ifne +14 -> 1661
    //   1650: ldc_w 1650
    //   1653: aload 7
    //   1655: invokevirtual 1378	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1658: ifeq -68 -> 1590
    //   1661: ldc_w 1652
    //   1664: invokestatic 496	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   1667: aload_0
    //   1668: invokevirtual 500	com/whatsapp/ContactPicker:getBaseContext	()Landroid/content/Context;
    //   1671: ldc_w 1653
    //   1674: iconst_0
    //   1675: invokestatic 506	com/whatsapp/pv:a	(Landroid/content/Context;II)V
    //   1678: aload_0
    //   1679: invokevirtual 509	com/whatsapp/ContactPicker:finish	()V
    //   1682: return
    //   1683: astore 6
    //   1685: goto -338 -> 1347
    //   1688: aload_0
    //   1689: getfield 486	com/whatsapp/ContactPicker:Y	B
    //   1692: iconst_4
    //   1693: if_icmpne +2005 -> 3698
    //   1696: aload 17
    //   1698: ldc_w 980
    //   1701: invokevirtual 1599	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   1704: ifeq +72 -> 1776
    //   1707: aload 17
    //   1709: ldc_w 980
    //   1712: invokevirtual 1657	android/content/Intent:getCharSequenceExtra	(Ljava/lang/String;)Ljava/lang/CharSequence;
    //   1715: invokeinterface 1660 1 0
    //   1720: astore 8
    //   1722: new 431	java/lang/StringBuilder
    //   1725: dup
    //   1726: ldc_w 1662
    //   1729: invokespecial 436	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1732: aload 8
    //   1734: invokevirtual 471	java/lang/String:length	()I
    //   1737: invokevirtual 476	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1740: ldc_w 1664
    //   1743: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1746: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1749: invokestatic 534	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1752: aconst_null
    //   1753: astore 7
    //   1755: aload 8
    //   1757: ifnonnull +76 -> 1833
    //   1760: aload 7
    //   1762: ifnonnull +71 -> 1833
    //   1765: ldc_w 1666
    //   1768: invokestatic 449	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   1771: aload_0
    //   1772: invokevirtual 509	com/whatsapp/ContactPicker:finish	()V
    //   1775: return
    //   1776: aload 17
    //   1778: ldc_w 985
    //   1781: invokevirtual 1599	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   1784: ifeq +2988 -> 4772
    //   1787: aload 17
    //   1789: ldc_w 985
    //   1792: invokevirtual 1670	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   1795: invokevirtual 1671	java/lang/Object:toString	()Ljava/lang/String;
    //   1798: invokestatic 1675	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   1801: astore 7
    //   1803: new 431	java/lang/StringBuilder
    //   1806: dup
    //   1807: ldc_w 1677
    //   1810: invokespecial 436	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1813: aload 7
    //   1815: invokevirtual 1678	android/net/Uri:toString	()Ljava/lang/String;
    //   1818: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1821: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1824: invokestatic 534	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1827: aconst_null
    //   1828: astore 8
    //   1830: goto -75 -> 1755
    //   1833: aload 7
    //   1835: ifnull +2920 -> 4755
    //   1838: aload 7
    //   1840: invokevirtual 1679	android/net/Uri:getScheme	()Ljava/lang/String;
    //   1843: ldc_w 1681
    //   1846: invokevirtual 1378	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1849: ifeq +582 -> 2431
    //   1852: new 1683	java/io/File
    //   1855: dup
    //   1856: aload 7
    //   1858: invokevirtual 1686	android/net/Uri:getSchemeSpecificPart	()Ljava/lang/String;
    //   1861: iconst_2
    //   1862: invokevirtual 700	java/lang/String:substring	(I)Ljava/lang/String;
    //   1865: invokespecial 1687	java/io/File:<init>	(Ljava/lang/String;)V
    //   1868: astore 7
    //   1870: aload 7
    //   1872: invokevirtual 1690	java/io/File:exists	()Z
    //   1875: ifeq +522 -> 2397
    //   1878: new 1692	java/io/FileInputStream
    //   1881: dup
    //   1882: aload 7
    //   1884: invokevirtual 1695	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1887: invokespecial 1696	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   1890: astore 6
    //   1892: aload 7
    //   1894: invokevirtual 1698	java/io/File:length	()J
    //   1897: lstore 4
    //   1899: lload 4
    //   1901: l2i
    //   1902: istore_1
    //   1903: aconst_null
    //   1904: astore 9
    //   1906: aload 6
    //   1908: astore 7
    //   1910: aload 9
    //   1912: astore 6
    //   1914: aload 6
    //   1916: astore 14
    //   1918: aload 7
    //   1920: astore 15
    //   1922: aload 6
    //   1924: astore 13
    //   1926: aload 7
    //   1928: astore 12
    //   1930: aload 6
    //   1932: astore 10
    //   1934: aload 7
    //   1936: astore 9
    //   1938: aload 7
    //   1940: invokestatic 1701	com/whatsapp/util/MediaFileUtils:a	(Ljava/io/FileInputStream;)V
    //   1943: iload_1
    //   1944: ifle +641 -> 2585
    //   1947: aload 6
    //   1949: astore 14
    //   1951: aload 7
    //   1953: astore 15
    //   1955: aload 6
    //   1957: astore 13
    //   1959: aload 7
    //   1961: astore 12
    //   1963: aload 6
    //   1965: astore 10
    //   1967: aload 7
    //   1969: astore 9
    //   1971: iload_1
    //   1972: newarray <illegal type>
    //   1974: astore 18
    //   1976: aload 8
    //   1978: astore 16
    //   1980: aload 6
    //   1982: astore 11
    //   1984: aload 7
    //   1986: astore 8
    //   1988: aload 6
    //   1990: astore 14
    //   1992: aload 7
    //   1994: astore 15
    //   1996: aload 6
    //   1998: astore 13
    //   2000: aload 7
    //   2002: astore 12
    //   2004: aload 6
    //   2006: astore 10
    //   2008: aload 7
    //   2010: astore 9
    //   2012: aload 7
    //   2014: aload 18
    //   2016: invokevirtual 1705	java/io/FileInputStream:read	([B)I
    //   2019: ifle +46 -> 2065
    //   2022: aload 6
    //   2024: astore 14
    //   2026: aload 7
    //   2028: astore 15
    //   2030: aload 6
    //   2032: astore 13
    //   2034: aload 7
    //   2036: astore 12
    //   2038: aload 6
    //   2040: astore 10
    //   2042: aload 7
    //   2044: astore 9
    //   2046: new 468	java/lang/String
    //   2049: dup
    //   2050: aload 18
    //   2052: invokespecial 1708	java/lang/String:<init>	([B)V
    //   2055: astore 16
    //   2057: aload 7
    //   2059: astore 8
    //   2061: aload 6
    //   2063: astore 11
    //   2065: aload 11
    //   2067: astore 14
    //   2069: aload 8
    //   2071: astore 15
    //   2073: aload 11
    //   2075: astore 13
    //   2077: aload 8
    //   2079: astore 12
    //   2081: aload 11
    //   2083: astore 10
    //   2085: aload 8
    //   2087: astore 9
    //   2089: new 1710	a/a/a/a/a/f
    //   2092: dup
    //   2093: invokespecial 1711	a/a/a/a/a/f:<init>	()V
    //   2096: astore 6
    //   2098: aload 11
    //   2100: astore 14
    //   2102: aload 8
    //   2104: astore 15
    //   2106: aload 11
    //   2108: astore 13
    //   2110: aload 8
    //   2112: astore 12
    //   2114: aload 11
    //   2116: astore 10
    //   2118: aload 8
    //   2120: astore 9
    //   2122: new 1713	a/a/a/a/c
    //   2125: dup
    //   2126: invokespecial 1714	a/a/a/a/c:<init>	()V
    //   2129: astore 7
    //   2131: aload 11
    //   2133: astore 14
    //   2135: aload 8
    //   2137: astore 15
    //   2139: aload 11
    //   2141: astore 13
    //   2143: aload 8
    //   2145: astore 12
    //   2147: aload 11
    //   2149: astore 10
    //   2151: aload 8
    //   2153: astore 9
    //   2155: aload 6
    //   2157: aload 16
    //   2159: ldc_w 1716
    //   2162: aload 7
    //   2164: invokevirtual 1719	a/a/a/a/a/f:a	(Ljava/lang/String;Ljava/lang/String;La/a/a/a/c;)Z
    //   2167: pop
    //   2168: aload 11
    //   2170: astore 14
    //   2172: aload 8
    //   2174: astore 15
    //   2176: aload 11
    //   2178: astore 13
    //   2180: aload 8
    //   2182: astore 12
    //   2184: aload 11
    //   2186: astore 10
    //   2188: aload 8
    //   2190: astore 9
    //   2192: getstatic 1721	com/whatsapp/aic:M	Z
    //   2195: ifeq +1199 -> 3394
    //   2198: aload 11
    //   2200: astore 14
    //   2202: aload 8
    //   2204: astore 15
    //   2206: aload 11
    //   2208: astore 13
    //   2210: aload 8
    //   2212: astore 12
    //   2214: aload 11
    //   2216: astore 10
    //   2218: aload 8
    //   2220: astore 9
    //   2222: aload 7
    //   2224: getfield 1723	a/a/a/a/c:b	Ljava/util/List;
    //   2227: invokeinterface 1724 1 0
    //   2232: iconst_1
    //   2233: if_icmple +1161 -> 3394
    //   2236: aload 11
    //   2238: astore 14
    //   2240: aload 8
    //   2242: astore 15
    //   2244: aload 11
    //   2246: astore 13
    //   2248: aload 8
    //   2250: astore 12
    //   2252: aload 11
    //   2254: astore 10
    //   2256: aload 8
    //   2258: astore 9
    //   2260: aload 7
    //   2262: getfield 1723	a/a/a/a/c:b	Ljava/util/List;
    //   2265: invokeinterface 1724 1 0
    //   2270: sipush 1000
    //   2273: if_icmple +572 -> 2845
    //   2276: aload 11
    //   2278: astore 14
    //   2280: aload 8
    //   2282: astore 15
    //   2284: aload 11
    //   2286: astore 13
    //   2288: aload 8
    //   2290: astore 12
    //   2292: aload 11
    //   2294: astore 10
    //   2296: aload 8
    //   2298: astore 9
    //   2300: new 431	java/lang/StringBuilder
    //   2303: dup
    //   2304: ldc_w 1726
    //   2307: invokespecial 436	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2310: aload 7
    //   2312: getfield 1723	a/a/a/a/c:b	Ljava/util/List;
    //   2315: invokeinterface 1724 1 0
    //   2320: invokevirtual 476	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2323: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2326: invokestatic 449	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   2329: aload 11
    //   2331: astore 14
    //   2333: aload 8
    //   2335: astore 15
    //   2337: aload 11
    //   2339: astore 13
    //   2341: aload 8
    //   2343: astore 12
    //   2345: aload 11
    //   2347: astore 10
    //   2349: aload 8
    //   2351: astore 9
    //   2353: aload_0
    //   2354: invokevirtual 500	com/whatsapp/ContactPicker:getBaseContext	()Landroid/content/Context;
    //   2357: aload_0
    //   2358: ldc_w 1727
    //   2361: iconst_1
    //   2362: anewarray 313	java/lang/Object
    //   2365: dup
    //   2366: iconst_0
    //   2367: sipush 1000
    //   2370: invokestatic 543	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2373: aastore
    //   2374: invokevirtual 1730	com/whatsapp/ContactPicker:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   2377: iconst_0
    //   2378: invokestatic 1733	com/whatsapp/pv:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   2381: aload 11
    //   2383: ifnull +8 -> 2391
    //   2386: aload 11
    //   2388: invokevirtual 1738	android/content/res/AssetFileDescriptor:close	()V
    //   2391: aload 8
    //   2393: invokestatic 1741	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   2396: return
    //   2397: aload_0
    //   2398: new 431	java/lang/StringBuilder
    //   2401: dup
    //   2402: ldc_w 1743
    //   2405: invokespecial 436	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2408: aload 7
    //   2410: invokevirtual 1744	java/io/File:getPath	()Ljava/lang/String;
    //   2413: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2416: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2419: invokestatic 1747	com/whatsapp/pv:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   2422: aload_0
    //   2423: invokevirtual 509	com/whatsapp/ContactPicker:finish	()V
    //   2426: aconst_null
    //   2427: invokestatic 1741	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   2430: return
    //   2431: aload_0
    //   2432: getfield 1212	com/whatsapp/ContactPicker:aE	Lcom/whatsapp/and;
    //   2435: getfield 1750	com/whatsapp/and:f	Landroid/content/ContentResolver;
    //   2438: astore 6
    //   2440: aload 6
    //   2442: ifnonnull +58 -> 2500
    //   2445: ldc_w 1752
    //   2448: invokestatic 449	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   2451: aconst_null
    //   2452: astore 6
    //   2454: aload 6
    //   2456: ifnonnull +88 -> 2544
    //   2459: aload_0
    //   2460: new 431	java/lang/StringBuilder
    //   2463: dup
    //   2464: ldc_w 1754
    //   2467: invokespecial 436	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2470: aload 7
    //   2472: invokevirtual 850	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2475: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2478: invokestatic 1747	com/whatsapp/pv:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   2481: aload_0
    //   2482: invokevirtual 509	com/whatsapp/ContactPicker:finish	()V
    //   2485: aload 6
    //   2487: ifnull +8 -> 2495
    //   2490: aload 6
    //   2492: invokevirtual 1738	android/content/res/AssetFileDescriptor:close	()V
    //   2495: aconst_null
    //   2496: invokestatic 1741	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   2499: return
    //   2500: aload 6
    //   2502: aload 7
    //   2504: ldc_w 1755
    //   2507: invokevirtual 1761	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   2510: astore 6
    //   2512: goto -58 -> 2454
    //   2515: astore 6
    //   2517: new 431	java/lang/StringBuilder
    //   2520: dup
    //   2521: ldc_w 1763
    //   2524: invokespecial 436	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2527: aload 6
    //   2529: invokevirtual 1764	java/io/IOException:toString	()Ljava/lang/String;
    //   2532: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2535: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2538: invokestatic 449	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   2541: goto -46 -> 2495
    //   2544: aload 6
    //   2546: invokevirtual 1768	android/content/res/AssetFileDescriptor:createInputStream	()Ljava/io/FileInputStream;
    //   2549: astore 7
    //   2551: aload 6
    //   2553: astore 14
    //   2555: aload 7
    //   2557: astore 15
    //   2559: aload 6
    //   2561: astore 13
    //   2563: aload 7
    //   2565: astore 12
    //   2567: aload 6
    //   2569: astore 10
    //   2571: aload 7
    //   2573: astore 9
    //   2575: aload 6
    //   2577: invokevirtual 1771	android/content/res/AssetFileDescriptor:getDeclaredLength	()J
    //   2580: l2i
    //   2581: istore_1
    //   2582: goto -668 -> 1914
    //   2585: aload 6
    //   2587: astore 14
    //   2589: aload 7
    //   2591: astore 15
    //   2593: aload 6
    //   2595: astore 13
    //   2597: aload 7
    //   2599: astore 12
    //   2601: aload 6
    //   2603: astore 10
    //   2605: aload 7
    //   2607: astore 9
    //   2609: new 1773	java/io/ByteArrayOutputStream
    //   2612: dup
    //   2613: invokespecial 1774	java/io/ByteArrayOutputStream:<init>	()V
    //   2616: astore 8
    //   2618: aload 6
    //   2620: astore 14
    //   2622: aload 7
    //   2624: astore 15
    //   2626: aload 6
    //   2628: astore 13
    //   2630: aload 7
    //   2632: astore 12
    //   2634: aload 6
    //   2636: astore 10
    //   2638: aload 7
    //   2640: astore 9
    //   2642: sipush 512
    //   2645: newarray <illegal type>
    //   2647: astore 11
    //   2649: aload 6
    //   2651: astore 14
    //   2653: aload 7
    //   2655: astore 15
    //   2657: aload 6
    //   2659: astore 13
    //   2661: aload 7
    //   2663: astore 12
    //   2665: aload 6
    //   2667: astore 10
    //   2669: aload 7
    //   2671: astore 9
    //   2673: aload 7
    //   2675: aload 11
    //   2677: invokevirtual 1705	java/io/FileInputStream:read	([B)I
    //   2680: istore_1
    //   2681: iload_1
    //   2682: ifle +92 -> 2774
    //   2685: aload 6
    //   2687: astore 14
    //   2689: aload 7
    //   2691: astore 15
    //   2693: aload 6
    //   2695: astore 13
    //   2697: aload 7
    //   2699: astore 12
    //   2701: aload 6
    //   2703: astore 10
    //   2705: aload 7
    //   2707: astore 9
    //   2709: aload 8
    //   2711: aload 11
    //   2713: iconst_0
    //   2714: iload_1
    //   2715: invokevirtual 1777	java/io/ByteArrayOutputStream:write	([BII)V
    //   2718: goto -69 -> 2649
    //   2721: astore 7
    //   2723: aload 15
    //   2725: astore 6
    //   2727: aload 14
    //   2729: astore 8
    //   2731: aload 8
    //   2733: astore 10
    //   2735: aload 6
    //   2737: astore 9
    //   2739: aload 7
    //   2741: invokestatic 1780	com/whatsapp/util/Log:w	(Ljava/lang/Throwable;)V
    //   2744: aload 8
    //   2746: ifnull +8 -> 2754
    //   2749: aload 8
    //   2751: invokevirtual 1738	android/content/res/AssetFileDescriptor:close	()V
    //   2754: aload 6
    //   2756: invokestatic 1741	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   2759: aload_0
    //   2760: getfield 213	com/whatsapp/ContactPicker:ae	Ljava/util/HashSet;
    //   2763: iconst_4
    //   2764: invokestatic 543	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2767: invokevirtual 547	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   2770: pop
    //   2771: goto -2731 -> 40
    //   2774: aload 6
    //   2776: astore 14
    //   2778: aload 7
    //   2780: astore 15
    //   2782: aload 6
    //   2784: astore 13
    //   2786: aload 7
    //   2788: astore 12
    //   2790: aload 6
    //   2792: astore 10
    //   2794: aload 7
    //   2796: astore 9
    //   2798: aload 8
    //   2800: invokevirtual 1781	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
    //   2803: astore 16
    //   2805: aload 6
    //   2807: astore 11
    //   2809: aload 7
    //   2811: astore 8
    //   2813: goto -748 -> 2065
    //   2816: astore 6
    //   2818: new 431	java/lang/StringBuilder
    //   2821: dup
    //   2822: ldc_w 1763
    //   2825: invokespecial 436	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2828: aload 6
    //   2830: invokevirtual 1764	java/io/IOException:toString	()Ljava/lang/String;
    //   2833: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2836: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2839: invokestatic 449	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   2842: goto -451 -> 2391
    //   2845: aload 11
    //   2847: astore 14
    //   2849: aload 8
    //   2851: astore 15
    //   2853: aload 11
    //   2855: astore 13
    //   2857: aload 8
    //   2859: astore 12
    //   2861: aload 11
    //   2863: astore 10
    //   2865: aload 8
    //   2867: astore 9
    //   2869: aload_0
    //   2870: new 215	java/util/ArrayList
    //   2873: dup
    //   2874: invokespecial 216	java/util/ArrayList:<init>	()V
    //   2877: putfield 1016	com/whatsapp/ContactPicker:ad	Ljava/util/ArrayList;
    //   2880: aload 11
    //   2882: astore 14
    //   2884: aload 8
    //   2886: astore 15
    //   2888: aload 11
    //   2890: astore 13
    //   2892: aload 8
    //   2894: astore 12
    //   2896: aload 11
    //   2898: astore 10
    //   2900: aload 8
    //   2902: astore 9
    //   2904: new 1783	com/whatsapp/util/bd
    //   2907: dup
    //   2908: new 431	java/lang/StringBuilder
    //   2911: dup
    //   2912: ldc_w 1785
    //   2915: invokespecial 436	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2918: aload 7
    //   2920: getfield 1723	a/a/a/a/c:b	Ljava/util/List;
    //   2923: invokeinterface 1724 1 0
    //   2928: invokevirtual 476	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2931: ldc_w 1787
    //   2934: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2937: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2940: invokespecial 1788	com/whatsapp/util/bd:<init>	(Ljava/lang/String;)V
    //   2943: astore 6
    //   2945: aload 11
    //   2947: astore 14
    //   2949: aload 8
    //   2951: astore 15
    //   2953: aload 11
    //   2955: astore 13
    //   2957: aload 8
    //   2959: astore 12
    //   2961: aload 11
    //   2963: astore 10
    //   2965: aload 8
    //   2967: astore 9
    //   2969: aload 7
    //   2971: getfield 1723	a/a/a/a/c:b	Ljava/util/List;
    //   2974: invokeinterface 559 1 0
    //   2979: astore 7
    //   2981: aload 11
    //   2983: astore 14
    //   2985: aload 8
    //   2987: astore 15
    //   2989: aload 11
    //   2991: astore 13
    //   2993: aload 8
    //   2995: astore 12
    //   2997: aload 11
    //   2999: astore 10
    //   3001: aload 8
    //   3003: astore 9
    //   3005: aload 7
    //   3007: invokeinterface 565 1 0
    //   3012: ifeq +304 -> 3316
    //   3015: aload 11
    //   3017: astore 14
    //   3019: aload 8
    //   3021: astore 15
    //   3023: aload 11
    //   3025: astore 13
    //   3027: aload 8
    //   3029: astore 12
    //   3031: aload 11
    //   3033: astore 10
    //   3035: aload 8
    //   3037: astore 9
    //   3039: aload 7
    //   3041: invokeinterface 569 1 0
    //   3046: checkcast 1336	a/a/a/a/d
    //   3049: astore 16
    //   3051: aload 11
    //   3053: astore 14
    //   3055: aload 8
    //   3057: astore 15
    //   3059: aload 11
    //   3061: astore 13
    //   3063: aload 8
    //   3065: astore 12
    //   3067: aload 11
    //   3069: astore 10
    //   3071: aload 8
    //   3073: astore 9
    //   3075: invokestatic 1792	com/whatsapp/u:a	()Landroid/content/Context;
    //   3078: aload_0
    //   3079: getfield 264	com/whatsapp/ContactPicker:bd	Lcom/whatsapp/data/e;
    //   3082: aload 16
    //   3084: invokestatic 1797	a/a/a/a/a/a:a	(Landroid/content/Context;Lcom/whatsapp/data/e;La/a/a/a/d;)La/a/a/a/a/a;
    //   3087: astore 16
    //   3089: aload 11
    //   3091: astore 14
    //   3093: aload 8
    //   3095: astore 15
    //   3097: aload 11
    //   3099: astore 13
    //   3101: aload 8
    //   3103: astore 12
    //   3105: aload 11
    //   3107: astore 10
    //   3109: aload 8
    //   3111: astore 9
    //   3113: new 1042	a/a/a/a/a/c
    //   3116: dup
    //   3117: invokespecial 1798	a/a/a/a/a/c:<init>	()V
    //   3120: astore 18
    //   3122: aload 11
    //   3124: astore 13
    //   3126: aload 8
    //   3128: astore 12
    //   3130: aload 11
    //   3132: astore 10
    //   3134: aload 8
    //   3136: astore 9
    //   3138: aload 18
    //   3140: aload_0
    //   3141: aload 16
    //   3143: invokevirtual 1801	a/a/a/a/a/c:a	(Landroid/content/Context;La/a/a/a/a/a;)Ljava/lang/String;
    //   3146: astore 14
    //   3148: aload 11
    //   3150: astore 13
    //   3152: aload 8
    //   3154: astore 12
    //   3156: aload 11
    //   3158: astore 10
    //   3160: aload 8
    //   3162: astore 9
    //   3164: aload_0
    //   3165: aload_0
    //   3166: getfield 264	com/whatsapp/ContactPicker:bd	Lcom/whatsapp/data/e;
    //   3169: aload_0
    //   3170: getfield 909	com/whatsapp/ContactPicker:aP	Lcom/whatsapp/atu;
    //   3173: aload 14
    //   3175: invokestatic 1045	a/a/a/a/a/c:a	(Landroid/content/Context;Lcom/whatsapp/data/e;Lcom/whatsapp/atu;Ljava/lang/String;)Ljava/lang/String;
    //   3178: astore 14
    //   3180: aload 11
    //   3182: astore 13
    //   3184: aload 8
    //   3186: astore 12
    //   3188: aload 11
    //   3190: astore 10
    //   3192: aload 8
    //   3194: astore 9
    //   3196: aload_0
    //   3197: getfield 1016	com/whatsapp/ContactPicker:ad	Ljava/util/ArrayList;
    //   3200: aload 14
    //   3202: invokevirtual 799	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3205: pop
    //   3206: goto -225 -> 2981
    //   3209: astore 6
    //   3211: aload 11
    //   3213: astore 14
    //   3215: aload 8
    //   3217: astore 15
    //   3219: aload 11
    //   3221: astore 13
    //   3223: aload 8
    //   3225: astore 12
    //   3227: aload 11
    //   3229: astore 10
    //   3231: aload 8
    //   3233: astore 9
    //   3235: aload 6
    //   3237: invokestatic 1803	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   3240: aload 11
    //   3242: astore 14
    //   3244: aload 8
    //   3246: astore 15
    //   3248: aload 11
    //   3250: astore 13
    //   3252: aload 8
    //   3254: astore 12
    //   3256: aload 11
    //   3258: astore 10
    //   3260: aload 8
    //   3262: astore 9
    //   3264: aload_0
    //   3265: ldc_w 1804
    //   3268: invokevirtual 1807	com/whatsapp/ContactPicker:b_	(I)V
    //   3271: aload 11
    //   3273: ifnull +8 -> 3281
    //   3276: aload 11
    //   3278: invokevirtual 1738	android/content/res/AssetFileDescriptor:close	()V
    //   3281: aload 8
    //   3283: invokestatic 1741	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   3286: return
    //   3287: astore 6
    //   3289: new 431	java/lang/StringBuilder
    //   3292: dup
    //   3293: ldc_w 1763
    //   3296: invokespecial 436	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3299: aload 6
    //   3301: invokevirtual 1764	java/io/IOException:toString	()Ljava/lang/String;
    //   3304: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3307: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3310: invokestatic 449	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   3313: goto -32 -> 3281
    //   3316: aload 11
    //   3318: astore 14
    //   3320: aload 8
    //   3322: astore 15
    //   3324: aload 11
    //   3326: astore 13
    //   3328: aload 8
    //   3330: astore 12
    //   3332: aload 11
    //   3334: astore 10
    //   3336: aload 8
    //   3338: astore 9
    //   3340: aload 6
    //   3342: invokevirtual 1809	com/whatsapp/util/bd:b	()J
    //   3345: pop2
    //   3346: aload 11
    //   3348: astore 14
    //   3350: aload 8
    //   3352: astore 15
    //   3354: aload 11
    //   3356: astore 13
    //   3358: aload 8
    //   3360: astore 12
    //   3362: aload 11
    //   3364: astore 10
    //   3366: aload 8
    //   3368: astore 9
    //   3370: aload_0
    //   3371: bipush 14
    //   3373: putfield 486	com/whatsapp/ContactPicker:Y	B
    //   3376: aload 11
    //   3378: ifnull +8 -> 3386
    //   3381: aload 11
    //   3383: invokevirtual 1738	android/content/res/AssetFileDescriptor:close	()V
    //   3386: aload 8
    //   3388: invokestatic 1741	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   3391: goto -632 -> 2759
    //   3394: aload 11
    //   3396: astore 14
    //   3398: aload 8
    //   3400: astore 15
    //   3402: aload 11
    //   3404: astore 13
    //   3406: aload 8
    //   3408: astore 12
    //   3410: aload 11
    //   3412: astore 10
    //   3414: aload 8
    //   3416: astore 9
    //   3418: aload_0
    //   3419: iconst_4
    //   3420: putfield 486	com/whatsapp/ContactPicker:Y	B
    //   3423: aload 11
    //   3425: astore 14
    //   3427: aload 8
    //   3429: astore 15
    //   3431: aload 11
    //   3433: astore 13
    //   3435: aload 8
    //   3437: astore 12
    //   3439: aload 11
    //   3441: astore 10
    //   3443: aload 8
    //   3445: astore 9
    //   3447: aload_0
    //   3448: aload 16
    //   3450: putfield 1008	com/whatsapp/ContactPicker:ab	Ljava/lang/String;
    //   3453: aload 11
    //   3455: astore 14
    //   3457: aload 8
    //   3459: astore 15
    //   3461: aload 11
    //   3463: astore 13
    //   3465: aload 8
    //   3467: astore 12
    //   3469: aload 11
    //   3471: astore 10
    //   3473: aload 8
    //   3475: astore 9
    //   3477: aload 7
    //   3479: getfield 1723	a/a/a/a/c:b	Ljava/util/List;
    //   3482: iconst_0
    //   3483: invokeinterface 1810 2 0
    //   3488: checkcast 1336	a/a/a/a/d
    //   3491: astore 6
    //   3493: aload 11
    //   3495: astore 14
    //   3497: aload 8
    //   3499: astore 15
    //   3501: aload 11
    //   3503: astore 13
    //   3505: aload 8
    //   3507: astore 12
    //   3509: aload 11
    //   3511: astore 10
    //   3513: aload 8
    //   3515: astore 9
    //   3517: invokestatic 1792	com/whatsapp/u:a	()Landroid/content/Context;
    //   3520: aload_0
    //   3521: getfield 264	com/whatsapp/ContactPicker:bd	Lcom/whatsapp/data/e;
    //   3524: aload 6
    //   3526: invokestatic 1797	a/a/a/a/a/a:a	(Landroid/content/Context;Lcom/whatsapp/data/e;La/a/a/a/d;)La/a/a/a/a/a;
    //   3529: astore 6
    //   3531: aload 6
    //   3533: ifnull -157 -> 3376
    //   3536: aload 11
    //   3538: astore 14
    //   3540: aload 8
    //   3542: astore 15
    //   3544: aload 11
    //   3546: astore 13
    //   3548: aload 8
    //   3550: astore 12
    //   3552: aload 11
    //   3554: astore 10
    //   3556: aload 8
    //   3558: astore 9
    //   3560: aload_0
    //   3561: aload 6
    //   3563: invokevirtual 1812	a/a/a/a/a/a:a	()Ljava/lang/String;
    //   3566: putfield 1014	com/whatsapp/ContactPicker:ac	Ljava/lang/String;
    //   3569: goto -193 -> 3376
    //   3572: astore 7
    //   3574: aload 13
    //   3576: astore 8
    //   3578: aload 12
    //   3580: astore 6
    //   3582: goto -851 -> 2731
    //   3585: astore 6
    //   3587: new 431	java/lang/StringBuilder
    //   3590: dup
    //   3591: ldc_w 1763
    //   3594: invokespecial 436	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3597: aload 6
    //   3599: invokevirtual 1764	java/io/IOException:toString	()Ljava/lang/String;
    //   3602: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3605: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3608: invokestatic 449	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   3611: goto -225 -> 3386
    //   3614: astore 7
    //   3616: new 431	java/lang/StringBuilder
    //   3619: dup
    //   3620: ldc_w 1763
    //   3623: invokespecial 436	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3626: aload 7
    //   3628: invokevirtual 1764	java/io/IOException:toString	()Ljava/lang/String;
    //   3631: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3634: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3637: invokestatic 449	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   3640: goto -886 -> 2754
    //   3643: astore 7
    //   3645: aconst_null
    //   3646: astore 6
    //   3648: aconst_null
    //   3649: astore 9
    //   3651: aload 6
    //   3653: ifnull +8 -> 3661
    //   3656: aload 6
    //   3658: invokevirtual 1738	android/content/res/AssetFileDescriptor:close	()V
    //   3661: aload 9
    //   3663: invokestatic 1741	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   3666: aload 7
    //   3668: athrow
    //   3669: astore 6
    //   3671: new 431	java/lang/StringBuilder
    //   3674: dup
    //   3675: ldc_w 1763
    //   3678: invokespecial 436	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3681: aload 6
    //   3683: invokevirtual 1764	java/io/IOException:toString	()Ljava/lang/String;
    //   3686: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3689: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3692: invokestatic 449	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   3695: goto -34 -> 3661
    //   3698: aload_0
    //   3699: aload 17
    //   3701: ldc_w 985
    //   3704: invokevirtual 1815	android/content/Intent:getParcelableArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   3707: putfield 765	com/whatsapp/ContactPicker:Z	Ljava/util/ArrayList;
    //   3710: aload_0
    //   3711: getfield 765	com/whatsapp/ContactPicker:Z	Ljava/util/ArrayList;
    //   3714: ifnonnull +123 -> 3837
    //   3717: aload 17
    //   3719: invokevirtual 1589	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   3722: ldc_w 985
    //   3725: invokevirtual 1820	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   3728: checkcast 459	android/net/Uri
    //   3731: astore 6
    //   3733: new 431	java/lang/StringBuilder
    //   3736: dup
    //   3737: ldc_w 1822
    //   3740: invokespecial 436	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3743: aload 6
    //   3745: invokevirtual 850	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3748: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3751: invokestatic 534	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   3754: aload 6
    //   3756: ifnull +24 -> 3780
    //   3759: aload_0
    //   3760: new 215	java/util/ArrayList
    //   3763: dup
    //   3764: invokespecial 216	java/util/ArrayList:<init>	()V
    //   3767: putfield 765	com/whatsapp/ContactPicker:Z	Ljava/util/ArrayList;
    //   3770: aload_0
    //   3771: getfield 765	com/whatsapp/ContactPicker:Z	Ljava/util/ArrayList;
    //   3774: aload 6
    //   3776: invokevirtual 799	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3779: pop
    //   3780: aload_0
    //   3781: getfield 765	com/whatsapp/ContactPicker:Z	Ljava/util/ArrayList;
    //   3784: ifnull +13 -> 3797
    //   3787: aload_0
    //   3788: getfield 765	com/whatsapp/ContactPicker:Z	Ljava/util/ArrayList;
    //   3791: invokevirtual 1823	java/util/ArrayList:isEmpty	()Z
    //   3794: ifeq +124 -> 3918
    //   3797: new 431	java/lang/StringBuilder
    //   3800: dup
    //   3801: ldc_w 1825
    //   3804: invokespecial 436	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3807: aload 17
    //   3809: invokevirtual 1596	android/content/Intent:toString	()Ljava/lang/String;
    //   3812: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3815: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3818: invokestatic 496	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   3821: aload_0
    //   3822: invokevirtual 500	com/whatsapp/ContactPicker:getBaseContext	()Landroid/content/Context;
    //   3825: ldc_w 501
    //   3828: iconst_0
    //   3829: invokestatic 506	com/whatsapp/pv:a	(Landroid/content/Context;II)V
    //   3832: aload_0
    //   3833: invokevirtual 509	com/whatsapp/ContactPicker:finish	()V
    //   3836: return
    //   3837: new 431	java/lang/StringBuilder
    //   3840: dup
    //   3841: ldc_w 1827
    //   3844: invokespecial 436	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3847: aload_0
    //   3848: getfield 765	com/whatsapp/ContactPicker:Z	Ljava/util/ArrayList;
    //   3851: invokevirtual 840	java/util/ArrayList:size	()I
    //   3854: invokevirtual 476	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3857: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3860: invokestatic 534	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   3863: aload_0
    //   3864: getfield 765	com/whatsapp/ContactPicker:Z	Ljava/util/ArrayList;
    //   3867: invokevirtual 819	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   3870: astore 6
    //   3872: aload 6
    //   3874: invokeinterface 565 1 0
    //   3879: ifeq -99 -> 3780
    //   3882: aload 6
    //   3884: invokeinterface 569 1 0
    //   3889: checkcast 459	android/net/Uri
    //   3892: astore 7
    //   3894: new 431	java/lang/StringBuilder
    //   3897: dup
    //   3898: ldc_w 1822
    //   3901: invokespecial 436	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3904: aload 7
    //   3906: invokevirtual 850	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3909: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3912: invokestatic 534	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   3915: goto -43 -> 3872
    //   3918: aload_0
    //   3919: getfield 765	com/whatsapp/ContactPicker:Z	Ljava/util/ArrayList;
    //   3922: invokevirtual 819	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   3925: astore 8
    //   3927: aload 8
    //   3929: invokeinterface 565 1 0
    //   3934: ifeq +330 -> 4264
    //   3937: aload 8
    //   3939: invokeinterface 569 1 0
    //   3944: checkcast 459	android/net/Uri
    //   3947: astore 7
    //   3949: aload 7
    //   3951: invokevirtual 1678	android/net/Uri:toString	()Ljava/lang/String;
    //   3954: ldc_w 1829
    //   3957: invokevirtual 1831	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3960: ifeq +45 -> 4005
    //   3963: new 431	java/lang/StringBuilder
    //   3966: dup
    //   3967: ldc_w 1833
    //   3970: invokespecial 436	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3973: aload 7
    //   3975: invokevirtual 850	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3978: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3981: invokestatic 496	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   3984: aload_0
    //   3985: invokevirtual 500	com/whatsapp/ContactPicker:getBaseContext	()Landroid/content/Context;
    //   3988: ldc_w 1620
    //   3991: iconst_0
    //   3992: invokestatic 506	com/whatsapp/pv:a	(Landroid/content/Context;II)V
    //   3995: aload_0
    //   3996: aconst_null
    //   3997: putfield 765	com/whatsapp/ContactPicker:Z	Ljava/util/ArrayList;
    //   4000: aload_0
    //   4001: invokevirtual 509	com/whatsapp/ContactPicker:finish	()V
    //   4004: return
    //   4005: ldc_w 1681
    //   4008: aload 7
    //   4010: invokevirtual 1679	android/net/Uri:getScheme	()Ljava/lang/String;
    //   4013: invokevirtual 1836	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4016: ifne +11 -> 4027
    //   4019: aload 7
    //   4021: invokevirtual 1679	android/net/Uri:getScheme	()Ljava/lang/String;
    //   4024: ifnonnull +35 -> 4059
    //   4027: aload 7
    //   4029: invokevirtual 1679	android/net/Uri:getScheme	()Ljava/lang/String;
    //   4032: ifnonnull +127 -> 4159
    //   4035: aload 7
    //   4037: invokevirtual 1678	android/net/Uri:toString	()Ljava/lang/String;
    //   4040: astore 6
    //   4042: new 1683	java/io/File
    //   4045: dup
    //   4046: aload 6
    //   4048: invokespecial 1687	java/io/File:<init>	(Ljava/lang/String;)V
    //   4051: astore 6
    //   4053: aload_0
    //   4054: aload 6
    //   4056: invokestatic 1839	com/whatsapp/util/MediaFileUtils:a	(Landroid/content/Context;Ljava/io/File;)V
    //   4059: aload_0
    //   4060: getfield 1212	com/whatsapp/ContactPicker:aE	Lcom/whatsapp/and;
    //   4063: aload 7
    //   4065: invokestatic 1842	com/whatsapp/util/MediaFileUtils:d	(Lcom/whatsapp/and;Landroid/net/Uri;)Ljava/lang/String;
    //   4068: astore 6
    //   4070: aload_0
    //   4071: getfield 1212	com/whatsapp/ContactPicker:aE	Lcom/whatsapp/and;
    //   4074: aload 7
    //   4076: invokestatic 1217	com/whatsapp/util/MediaFileUtils:e	(Lcom/whatsapp/and;Landroid/net/Uri;)B
    //   4079: istore_1
    //   4080: iload_1
    //   4081: iconst_m1
    //   4082: if_icmpne +132 -> 4214
    //   4085: new 431	java/lang/StringBuilder
    //   4088: dup
    //   4089: ldc_w 1844
    //   4092: invokespecial 436	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4095: aload 7
    //   4097: invokevirtual 850	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4100: ldc_w 1846
    //   4103: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4106: aload_0
    //   4107: getfield 1212	com/whatsapp/ContactPicker:aE	Lcom/whatsapp/and;
    //   4110: aload 7
    //   4112: invokestatic 1842	com/whatsapp/util/MediaFileUtils:d	(Lcom/whatsapp/and;Landroid/net/Uri;)Ljava/lang/String;
    //   4115: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4118: ldc_w 1846
    //   4121: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4124: aload 7
    //   4126: invokestatic 1849	com/whatsapp/util/MediaFileUtils:a	(Landroid/net/Uri;)Ljava/lang/String;
    //   4129: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4132: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4135: invokestatic 496	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   4138: aload_0
    //   4139: invokevirtual 500	com/whatsapp/ContactPicker:getBaseContext	()Landroid/content/Context;
    //   4142: ldc_w 1620
    //   4145: iconst_0
    //   4146: invokestatic 506	com/whatsapp/pv:a	(Landroid/content/Context;II)V
    //   4149: aload_0
    //   4150: aconst_null
    //   4151: putfield 765	com/whatsapp/ContactPicker:Z	Ljava/util/ArrayList;
    //   4154: aload_0
    //   4155: invokevirtual 509	com/whatsapp/ContactPicker:finish	()V
    //   4158: return
    //   4159: aload 7
    //   4161: invokevirtual 1686	android/net/Uri:getSchemeSpecificPart	()Ljava/lang/String;
    //   4164: iconst_2
    //   4165: invokevirtual 700	java/lang/String:substring	(I)Ljava/lang/String;
    //   4168: astore 6
    //   4170: goto -128 -> 4042
    //   4173: astore 6
    //   4175: new 431	java/lang/StringBuilder
    //   4178: dup
    //   4179: ldc_w 1851
    //   4182: invokespecial 436	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4185: aload 7
    //   4187: invokevirtual 850	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4190: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4193: invokestatic 496	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   4196: aload_0
    //   4197: ldc_w 1620
    //   4200: iconst_0
    //   4201: invokestatic 506	com/whatsapp/pv:a	(Landroid/content/Context;II)V
    //   4204: aload_0
    //   4205: aconst_null
    //   4206: putfield 765	com/whatsapp/ContactPicker:Z	Ljava/util/ArrayList;
    //   4209: aload_0
    //   4210: invokevirtual 509	com/whatsapp/ContactPicker:finish	()V
    //   4213: return
    //   4214: iload_1
    //   4215: bipush 9
    //   4217: if_icmpne +32 -> 4249
    //   4220: aload 6
    //   4222: invokestatic 1852	com/whatsapp/aic:a	(Ljava/lang/String;)Z
    //   4225: ifne +24 -> 4249
    //   4228: aload_0
    //   4229: invokevirtual 500	com/whatsapp/ContactPicker:getBaseContext	()Landroid/content/Context;
    //   4232: ldc_w 1620
    //   4235: iconst_0
    //   4236: invokestatic 506	com/whatsapp/pv:a	(Landroid/content/Context;II)V
    //   4239: aload_0
    //   4240: aconst_null
    //   4241: putfield 765	com/whatsapp/ContactPicker:Z	Ljava/util/ArrayList;
    //   4244: aload_0
    //   4245: invokevirtual 509	com/whatsapp/ContactPicker:finish	()V
    //   4248: return
    //   4249: aload_0
    //   4250: getfield 213	com/whatsapp/ContactPicker:ae	Ljava/util/HashSet;
    //   4253: iload_1
    //   4254: invokestatic 543	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4257: invokevirtual 547	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   4260: pop
    //   4261: goto -334 -> 3927
    //   4264: aload_0
    //   4265: getfield 213	com/whatsapp/ContactPicker:ae	Ljava/util/HashSet;
    //   4268: iconst_1
    //   4269: invokestatic 543	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4272: invokevirtual 1201	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   4275: ifne +32 -> 4307
    //   4278: aload_0
    //   4279: getfield 213	com/whatsapp/ContactPicker:ae	Ljava/util/HashSet;
    //   4282: iconst_3
    //   4283: invokestatic 543	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4286: invokevirtual 1201	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   4289: ifne +18 -> 4307
    //   4292: aload_0
    //   4293: getfield 213	com/whatsapp/ContactPicker:ae	Ljava/util/HashSet;
    //   4296: bipush 13
    //   4298: invokestatic 543	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4301: invokevirtual 1201	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   4304: ifeq +60 -> 4364
    //   4307: aload_0
    //   4308: invokevirtual 965	com/whatsapp/ContactPicker:getIntent	()Landroid/content/Intent;
    //   4311: ldc_w 961
    //   4314: iconst_0
    //   4315: invokevirtual 969	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   4318: ifne +46 -> 4364
    //   4321: aload_0
    //   4322: getfield 1072	com/whatsapp/ContactPicker:bo	Landroid/widget/ImageView;
    //   4325: ldc_w 1291
    //   4328: invokevirtual 632	android/widget/ImageView:setImageResource	(I)V
    //   4331: aload_0
    //   4332: getfield 765	com/whatsapp/ContactPicker:Z	Ljava/util/ArrayList;
    //   4335: invokevirtual 840	java/util/ArrayList:size	()I
    //   4338: bipush 30
    //   4340: if_icmple +48 -> 4388
    //   4343: aload_0
    //   4344: invokevirtual 500	com/whatsapp/ContactPicker:getBaseContext	()Landroid/content/Context;
    //   4347: ldc_w 1853
    //   4350: iconst_0
    //   4351: invokestatic 506	com/whatsapp/pv:a	(Landroid/content/Context;II)V
    //   4354: aload_0
    //   4355: aconst_null
    //   4356: putfield 765	com/whatsapp/ContactPicker:Z	Ljava/util/ArrayList;
    //   4359: aload_0
    //   4360: invokevirtual 509	com/whatsapp/ContactPicker:finish	()V
    //   4363: return
    //   4364: aload_0
    //   4365: getfield 1072	com/whatsapp/ContactPicker:bo	Landroid/widget/ImageView;
    //   4368: new 1187	com/whatsapp/util/az
    //   4371: dup
    //   4372: aload_0
    //   4373: ldc_w 1292
    //   4376: invokestatic 1191	android/support/v4/content/b:a	(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    //   4379: invokespecial 1194	com/whatsapp/util/az:<init>	(Landroid/graphics/drawable/Drawable;)V
    //   4382: invokevirtual 1295	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   4385: goto -54 -> 4331
    //   4388: aload_0
    //   4389: getfield 765	com/whatsapp/ContactPicker:Z	Ljava/util/ArrayList;
    //   4392: invokevirtual 819	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   4395: astore 6
    //   4397: aload 6
    //   4399: invokeinterface 565 1 0
    //   4404: ifeq -4364 -> 40
    //   4407: aload 6
    //   4409: invokeinterface 569 1 0
    //   4414: checkcast 459	android/net/Uri
    //   4417: astore 7
    //   4419: aload_0
    //   4420: ldc_w 1855
    //   4423: aload 7
    //   4425: iconst_1
    //   4426: invokevirtual 1859	com/whatsapp/ContactPicker:grantUriPermission	(Ljava/lang/String;Landroid/net/Uri;I)V
    //   4429: goto -32 -> 4397
    //   4432: astore 7
    //   4434: new 431	java/lang/StringBuilder
    //   4437: dup
    //   4438: ldc_w 1861
    //   4441: invokespecial 436	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4444: aload 7
    //   4446: invokevirtual 850	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4449: invokevirtual 444	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4452: invokestatic 449	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   4455: goto -58 -> 4397
    //   4458: aload_0
    //   4459: iconst_1
    //   4460: putfield 870	com/whatsapp/ContactPicker:W	Z
    //   4463: goto -4423 -> 40
    //   4466: aload_0
    //   4467: getfield 1310	com/whatsapp/ContactPicker:v	Landroid/widget/ListView;
    //   4470: new 1187	com/whatsapp/util/az
    //   4473: dup
    //   4474: aload_0
    //   4475: ldc_w 1862
    //   4478: invokestatic 1191	android/support/v4/content/b:a	(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    //   4481: invokespecial 1194	com/whatsapp/util/az:<init>	(Landroid/graphics/drawable/Drawable;)V
    //   4484: invokevirtual 1386	android/widget/ListView:setDivider	(Landroid/graphics/drawable/Drawable;)V
    //   4487: aload_0
    //   4488: getfield 1310	com/whatsapp/ContactPicker:v	Landroid/widget/ListView;
    //   4491: iconst_1
    //   4492: invokevirtual 1389	android/widget/ListView:setHeaderDividersEnabled	(Z)V
    //   4495: goto -4355 -> 140
    //   4498: iconst_0
    //   4499: istore_3
    //   4500: goto -4261 -> 239
    //   4503: aload_0
    //   4504: getfield 1310	com/whatsapp/ContactPicker:v	Landroid/widget/ListView;
    //   4507: aload_0
    //   4508: invokevirtual 1420	com/whatsapp/ContactPicker:getResources	()Landroid/content/res/Resources;
    //   4511: ldc_w 1428
    //   4514: invokevirtual 1427	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   4517: iconst_0
    //   4518: aload_0
    //   4519: invokevirtual 1420	com/whatsapp/ContactPicker:getResources	()Landroid/content/res/Resources;
    //   4522: ldc_w 1421
    //   4525: invokevirtual 1427	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   4528: iconst_0
    //   4529: invokevirtual 1432	android/widget/ListView:setPadding	(IIII)V
    //   4532: goto -4224 -> 308
    //   4535: aload_0
    //   4536: getfield 1310	com/whatsapp/ContactPicker:v	Landroid/widget/ListView;
    //   4539: iconst_0
    //   4540: iconst_0
    //   4541: iconst_0
    //   4542: iconst_0
    //   4543: invokevirtual 1432	android/widget/ListView:setPadding	(IIII)V
    //   4546: goto -4238 -> 308
    //   4549: aload_0
    //   4550: getfield 1310	com/whatsapp/ContactPicker:v	Landroid/widget/ListView;
    //   4553: iconst_2
    //   4554: invokevirtual 1435	android/widget/ListView:setVerticalScrollbarPosition	(I)V
    //   4557: goto -4231 -> 326
    //   4560: aload_0
    //   4561: getfield 1310	com/whatsapp/ContactPicker:v	Landroid/widget/ListView;
    //   4564: iconst_1
    //   4565: invokevirtual 1407	android/widget/ListView:setFastScrollEnabled	(Z)V
    //   4568: aload_0
    //   4569: getfield 1310	com/whatsapp/ContactPicker:v	Landroid/widget/ListView;
    //   4572: ldc_w 619
    //   4575: invokevirtual 1865	android/widget/ListView:setSelector	(I)V
    //   4578: goto -4252 -> 326
    //   4581: aload_0
    //   4582: new 33	com/whatsapp/ContactPicker$b
    //   4585: dup
    //   4586: aload_0
    //   4587: iconst_0
    //   4588: invokespecial 1866	com/whatsapp/ContactPicker$b:<init>	(Lcom/whatsapp/ContactPicker;B)V
    //   4591: putfield 404	com/whatsapp/ContactPicker:aW	Lcom/whatsapp/ContactPicker$b;
    //   4594: goto -4076 -> 518
    //   4597: aload_0
    //   4598: getfield 365	com/whatsapp/ContactPicker:S	Z
    //   4601: ifeq -4044 -> 557
    //   4604: aload_0
    //   4605: getfield 371	com/whatsapp/ContactPicker:s	Ljava/lang/String;
    //   4608: ifnull -4051 -> 557
    //   4611: aload_0
    //   4612: getfield 371	com/whatsapp/ContactPicker:s	Ljava/lang/String;
    //   4615: invokestatic 1870	com/whatsapp/qz:e	(Ljava/lang/String;)Z
    //   4618: ifeq -4061 -> 557
    //   4621: aload_0
    //   4622: ldc_w 1871
    //   4625: ldc_w 1872
    //   4628: invokespecial 1480	com/whatsapp/ContactPicker:b	(II)Landroid/view/View;
    //   4631: astore 6
    //   4633: aload 6
    //   4635: aload_0
    //   4636: invokestatic 1875	com/whatsapp/dx:a	(Lcom/whatsapp/ContactPicker;)Landroid/view/View$OnClickListener;
    //   4639: invokevirtual 1463	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   4642: aload_0
    //   4643: getfield 1310	com/whatsapp/ContactPicker:v	Landroid/widget/ListView;
    //   4646: aload 6
    //   4648: aconst_null
    //   4649: iconst_1
    //   4650: invokevirtual 1486	android/widget/ListView:addHeaderView	(Landroid/view/View;Ljava/lang/Object;Z)V
    //   4653: goto -4096 -> 557
    //   4656: astore 7
    //   4658: aload 6
    //   4660: astore 9
    //   4662: aconst_null
    //   4663: astore 6
    //   4665: goto -1014 -> 3651
    //   4668: astore 7
    //   4670: aconst_null
    //   4671: astore 9
    //   4673: goto -1022 -> 3651
    //   4676: astore 7
    //   4678: aload 10
    //   4680: astore 6
    //   4682: goto -1031 -> 3651
    //   4685: astore 7
    //   4687: aconst_null
    //   4688: astore 8
    //   4690: aconst_null
    //   4691: astore 6
    //   4693: goto -1962 -> 2731
    //   4696: astore 7
    //   4698: aconst_null
    //   4699: astore 8
    //   4701: goto -1970 -> 2731
    //   4704: astore 7
    //   4706: aconst_null
    //   4707: astore 9
    //   4709: aload 6
    //   4711: astore 8
    //   4713: aload 9
    //   4715: astore 6
    //   4717: goto -1986 -> 2731
    //   4720: astore 7
    //   4722: aconst_null
    //   4723: astore 8
    //   4725: aconst_null
    //   4726: astore 6
    //   4728: goto -1997 -> 2731
    //   4731: astore 7
    //   4733: aconst_null
    //   4734: astore 8
    //   4736: goto -2005 -> 2731
    //   4739: astore 7
    //   4741: aconst_null
    //   4742: astore 9
    //   4744: aload 6
    //   4746: astore 8
    //   4748: aload 9
    //   4750: astore 6
    //   4752: goto -2021 -> 2731
    //   4755: aconst_null
    //   4756: astore 11
    //   4758: aconst_null
    //   4759: astore 6
    //   4761: aload 8
    //   4763: astore 16
    //   4765: aload 6
    //   4767: astore 8
    //   4769: goto -2704 -> 2065
    //   4772: aconst_null
    //   4773: astore 7
    //   4775: aconst_null
    //   4776: astore 8
    //   4778: goto -3023 -> 1755
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4781	0	this	ContactPicker
    //   1004	3250	1	i	int
    //   1002	6	2	j	int
    //   238	4262	3	bool	boolean
    //   1897	3	4	l	long
    //   48	1553	6	localObject1	Object
    //   1683	1	6	localException	Exception
    //   1890	621	6	localObject2	Object
    //   2515	187	6	localIOException1	IOException
    //   2725	81	6	localObject3	Object
    //   2816	13	6	localIOException2	IOException
    //   2943	1	6	localbd	com.whatsapp.util.bd
    //   3209	27	6	locald1	a.a.a.a.a.d
    //   3287	54	6	localIOException3	IOException
    //   3491	90	6	localObject4	Object
    //   3585	13	6	localIOException4	IOException
    //   3646	11	6	localObject5	Object
    //   3669	13	6	localIOException5	IOException
    //   3731	438	6	localObject6	Object
    //   4173	48	6	localIOException6	IOException
    //   4395	371	6	localObject7	Object
    //   1014	1692	7	localObject8	Object
    //   2721	249	7	locald2	a.a.a.a.a.d
    //   2979	499	7	localIterator	Iterator
    //   3572	1	7	localIOException7	IOException
    //   3614	13	7	localIOException8	IOException
    //   3643	24	7	localObject9	Object
    //   3892	532	7	localUri	Uri
    //   4432	13	7	localSecurityException	SecurityException
    //   4656	1	7	localObject10	Object
    //   4668	1	7	localObject11	Object
    //   4676	1	7	localObject12	Object
    //   4685	1	7	locald3	a.a.a.a.a.d
    //   4696	1	7	locald4	a.a.a.a.a.d
    //   4704	1	7	locald5	a.a.a.a.a.d
    //   4720	1	7	localIOException9	IOException
    //   4731	1	7	localIOException10	IOException
    //   4739	1	7	localIOException11	IOException
    //   4773	1	7	localObject13	Object
    //   1720	3057	8	localObject14	Object
    //   1904	2845	9	localObject15	Object
    //   1932	2747	10	localObject16	Object
    //   1982	2775	11	localObject17	Object
    //   1928	1651	12	localObject18	Object
    //   1924	1651	13	localObject19	Object
    //   1916	1623	14	localObject20	Object
    //   1920	1623	15	localObject21	Object
    //   1978	2786	16	localObject22	Object
    //   4	3804	17	localIntent	Intent
    //   1974	1165	18	localObject23	Object
    // Exception table:
    //   from	to	target	type
    //   1327	1336	1683	java/lang/Exception
    //   1341	1347	1683	java/lang/Exception
    //   1576	1590	1683	java/lang/Exception
    //   1590	1615	1683	java/lang/Exception
    //   1620	1627	1683	java/lang/Exception
    //   1632	1661	1683	java/lang/Exception
    //   1661	1682	1683	java/lang/Exception
    //   2490	2495	2515	java/io/IOException
    //   1938	1943	2721	a/a/a/a/a/d
    //   1971	1976	2721	a/a/a/a/a/d
    //   2012	2022	2721	a/a/a/a/a/d
    //   2046	2057	2721	a/a/a/a/a/d
    //   2089	2098	2721	a/a/a/a/a/d
    //   2122	2131	2721	a/a/a/a/a/d
    //   2155	2168	2721	a/a/a/a/a/d
    //   2192	2198	2721	a/a/a/a/a/d
    //   2222	2236	2721	a/a/a/a/a/d
    //   2260	2276	2721	a/a/a/a/a/d
    //   2300	2329	2721	a/a/a/a/a/d
    //   2353	2381	2721	a/a/a/a/a/d
    //   2575	2582	2721	a/a/a/a/a/d
    //   2609	2618	2721	a/a/a/a/a/d
    //   2642	2649	2721	a/a/a/a/a/d
    //   2673	2681	2721	a/a/a/a/a/d
    //   2709	2718	2721	a/a/a/a/a/d
    //   2798	2805	2721	a/a/a/a/a/d
    //   2869	2880	2721	a/a/a/a/a/d
    //   2904	2945	2721	a/a/a/a/a/d
    //   2969	2981	2721	a/a/a/a/a/d
    //   3005	3015	2721	a/a/a/a/a/d
    //   3039	3051	2721	a/a/a/a/a/d
    //   3075	3089	2721	a/a/a/a/a/d
    //   3113	3122	2721	a/a/a/a/a/d
    //   3235	3240	2721	a/a/a/a/a/d
    //   3264	3271	2721	a/a/a/a/a/d
    //   3340	3346	2721	a/a/a/a/a/d
    //   3370	3376	2721	a/a/a/a/a/d
    //   3418	3423	2721	a/a/a/a/a/d
    //   3447	3453	2721	a/a/a/a/a/d
    //   3477	3493	2721	a/a/a/a/a/d
    //   3517	3531	2721	a/a/a/a/a/d
    //   3560	3569	2721	a/a/a/a/a/d
    //   2386	2391	2816	java/io/IOException
    //   3138	3148	3209	a/a/a/a/a/d
    //   3164	3180	3209	a/a/a/a/a/d
    //   3196	3206	3209	a/a/a/a/a/d
    //   3276	3281	3287	java/io/IOException
    //   1938	1943	3572	java/io/IOException
    //   1971	1976	3572	java/io/IOException
    //   2012	2022	3572	java/io/IOException
    //   2046	2057	3572	java/io/IOException
    //   2089	2098	3572	java/io/IOException
    //   2122	2131	3572	java/io/IOException
    //   2155	2168	3572	java/io/IOException
    //   2192	2198	3572	java/io/IOException
    //   2222	2236	3572	java/io/IOException
    //   2260	2276	3572	java/io/IOException
    //   2300	2329	3572	java/io/IOException
    //   2353	2381	3572	java/io/IOException
    //   2575	2582	3572	java/io/IOException
    //   2609	2618	3572	java/io/IOException
    //   2642	2649	3572	java/io/IOException
    //   2673	2681	3572	java/io/IOException
    //   2709	2718	3572	java/io/IOException
    //   2798	2805	3572	java/io/IOException
    //   2869	2880	3572	java/io/IOException
    //   2904	2945	3572	java/io/IOException
    //   2969	2981	3572	java/io/IOException
    //   3005	3015	3572	java/io/IOException
    //   3039	3051	3572	java/io/IOException
    //   3075	3089	3572	java/io/IOException
    //   3113	3122	3572	java/io/IOException
    //   3138	3148	3572	java/io/IOException
    //   3164	3180	3572	java/io/IOException
    //   3196	3206	3572	java/io/IOException
    //   3235	3240	3572	java/io/IOException
    //   3264	3271	3572	java/io/IOException
    //   3340	3346	3572	java/io/IOException
    //   3370	3376	3572	java/io/IOException
    //   3418	3423	3572	java/io/IOException
    //   3447	3453	3572	java/io/IOException
    //   3477	3493	3572	java/io/IOException
    //   3517	3531	3572	java/io/IOException
    //   3560	3569	3572	java/io/IOException
    //   3381	3386	3585	java/io/IOException
    //   2749	2754	3614	java/io/IOException
    //   1838	1892	3643	finally
    //   2397	2426	3643	finally
    //   2431	2440	3643	finally
    //   2445	2451	3643	finally
    //   2500	2512	3643	finally
    //   3656	3661	3669	java/io/IOException
    //   4053	4059	4173	java/io/IOException
    //   4419	4429	4432	java/lang/SecurityException
    //   1892	1899	4656	finally
    //   2459	2485	4668	finally
    //   2544	2551	4668	finally
    //   1938	1943	4676	finally
    //   1971	1976	4676	finally
    //   2012	2022	4676	finally
    //   2046	2057	4676	finally
    //   2089	2098	4676	finally
    //   2122	2131	4676	finally
    //   2155	2168	4676	finally
    //   2192	2198	4676	finally
    //   2222	2236	4676	finally
    //   2260	2276	4676	finally
    //   2300	2329	4676	finally
    //   2353	2381	4676	finally
    //   2575	2582	4676	finally
    //   2609	2618	4676	finally
    //   2642	2649	4676	finally
    //   2673	2681	4676	finally
    //   2709	2718	4676	finally
    //   2739	2744	4676	finally
    //   2798	2805	4676	finally
    //   2869	2880	4676	finally
    //   2904	2945	4676	finally
    //   2969	2981	4676	finally
    //   3005	3015	4676	finally
    //   3039	3051	4676	finally
    //   3075	3089	4676	finally
    //   3113	3122	4676	finally
    //   3138	3148	4676	finally
    //   3164	3180	4676	finally
    //   3196	3206	4676	finally
    //   3235	3240	4676	finally
    //   3264	3271	4676	finally
    //   3340	3346	4676	finally
    //   3370	3376	4676	finally
    //   3418	3423	4676	finally
    //   3447	3453	4676	finally
    //   3477	3493	4676	finally
    //   3517	3531	4676	finally
    //   3560	3569	4676	finally
    //   1838	1892	4685	a/a/a/a/a/d
    //   2397	2426	4685	a/a/a/a/a/d
    //   2431	2440	4685	a/a/a/a/a/d
    //   2445	2451	4685	a/a/a/a/a/d
    //   2500	2512	4685	a/a/a/a/a/d
    //   1892	1899	4696	a/a/a/a/a/d
    //   2459	2485	4704	a/a/a/a/a/d
    //   2544	2551	4704	a/a/a/a/a/d
    //   1838	1892	4720	java/io/IOException
    //   2397	2426	4720	java/io/IOException
    //   2431	2440	4720	java/io/IOException
    //   2445	2451	4720	java/io/IOException
    //   2500	2512	4720	java/io/IOException
    //   1892	1899	4731	java/io/IOException
    //   2459	2485	4739	java/io/IOException
    //   2544	2551	4739	java/io/IOException
  }
  
  final void m()
  {
    startActivity(new Intent(this, ContactPickerHelp.class));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      do
      {
        return;
      } while (paramInt2 != -1);
      a(null);
      return;
      if ((this.bg.b()) && (this.br != null))
      {
        this.br.setVisibility(8);
        this.br = null;
      }
    }
  }
  
  public void onBackPressed()
  {
    if (this.bm.c())
    {
      this.bm.b();
      return;
    }
    super.onBackPressed();
  }
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    Object localObject = (AdapterView.AdapterContextMenuInfo)paramMenuItem.getMenuInfo();
    if (this.v == null) {
      this.v = ((ListView)findViewById(16908298));
    }
    localObject = ((e)this.v.getItemAtPosition(((AdapterView.AdapterContextMenuInfo)localObject).position)).a();
    if (localObject != null) {}
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onContextItemSelected(paramMenuItem);
    }
    this.be.a(this, false, ((cs)localObject).t);
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().addFlags(Integer.MIN_VALUE);
    }
    super.onCreate(paramBundle);
    setContentView(2130903119);
    Object localObject = (Toolbar)findViewById(2131755412);
    a((Toolbar)localObject);
    this.bm = new ahp(this, this.aq, findViewById(2131755496), (Toolbar)localObject, new SearchView.b()
    {
      public final boolean a(String paramAnonymousString)
      {
        return false;
      }
      
      public final boolean b(String paramAnonymousString)
      {
        ContactPicker.a(ContactPicker.this, paramAnonymousString);
        ContactPicker.a(ContactPicker.this, be.c(paramAnonymousString));
        if (ContactPicker.a(ContactPicker.this).isEmpty()) {
          ContactPicker.a(ContactPicker.this, null);
        }
        ContactPicker.b(ContactPicker.this);
        return false;
      }
    });
    localObject = i();
    ((android.support.v7.app.a)localObject).a(true);
    ((android.support.v7.app.a)localObject).a(2131298205);
    Log.i("contactpicker/create");
    if (!WhatsAppLibLoader.a(null))
    {
      Log.i("aborting due to native libraries missing");
      finish();
    }
    do
    {
      return;
      if ((this.aZ.b == null) || (!this.L.b()))
      {
        pv.a(this, 2131296797, 1);
        startActivity(new Intent(this, Main.class));
        finish();
        return;
      }
      if (ahc.e())
      {
        Log.w("contactpicker/device-not-supported");
        a(new nh.k());
      }
      b(this.by.d.get());
      this.bo = ((ImageView)findViewById(2131755437));
      this.bo.setImageDrawable(new az(android.support.v4.content.b.a(this, 2130840323)));
      this.bo.setOnClickListener(new at()
      {
        public final void a(View paramAnonymousView)
        {
          if (ContactPicker.c(ContactPicker.this)) {
            ContactPicker.a(ContactPicker.this, null);
          }
          while ((!ContactPicker.d(ContactPicker.this)) && (!ContactPicker.e(ContactPicker.this))) {
            return;
          }
          paramAnonymousView = new Intent();
          paramAnonymousView.putStringArrayListExtra("jids", new ArrayList(ContactPicker.f(ContactPicker.this).keySet()));
          ContactPicker.this.setResult(-1, paramAnonymousView);
          ContactPicker.this.finish();
        }
      });
      this.bp = ((TextEmojiLabel)findViewById(2131755499));
      this.bq = findViewById(2131755497);
      if (paramBundle != null)
      {
        localObject = paramBundle.getString("jid");
        if (localObject != null) {
          this.n = this.bd.d((String)localObject);
        }
        paramBundle = paramBundle.getStringArrayList("selected_jids");
        if ((paramBundle != null) && (!paramBundle.isEmpty()))
        {
          this.o.clear();
          paramBundle = paramBundle.iterator();
          while (paramBundle.hasNext())
          {
            localObject = (String)paramBundle.next();
            cs localcs = this.bd.c((String)localObject);
            if (localcs != null) {
              this.o.put(localObject, localcs);
            }
          }
        }
      }
      if (this.bc.z.d) {
        break;
      }
      N = true;
    } while (!this.M.d());
    p();
    return;
    l();
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    Object localObject = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    localObject = (e)((ListView)paramView).getItemAtPosition(((AdapterView.AdapterContextMenuInfo)localObject).position);
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((e)localObject).a();
    } while ((localObject == null) || (!this.be.a(((cs)localObject).t)));
    paramContextMenu.add(0, 0, 0, String.format(getString(2131296354), new Object[] { ((cs)localObject).a(this) }));
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    case 0: 
      localObject = getString(2131297466, new Object[] { this.n.a(this), this.bd.e(this.s).a(this) });
      return new android.support.v7.app.b.a(this).b(com.whatsapp.emoji.c.a((CharSequence)localObject, getBaseContext())).a(true).b(2131296398, dy.a(this)).a(2131297331, dz.a(this)).a(ea.a(this)).a();
    case 1: 
      if (this.o.size() == 1)
      {
        this.n = ((cs)this.o.values().iterator().next());
        this.o.clear();
      }
      if (!this.o.isEmpty())
      {
        localObject = new ArrayList();
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.o.values().iterator();
        while (localIterator.hasNext())
        {
          cs localcs = (cs)localIterator.next();
          String str = localcs.k();
          if (str != null) {
            if (str.equals(cs.b(localcs.t))) {
              localArrayList.add(str);
            } else {
              ((ArrayList)localObject).add(str);
            }
          }
        }
        Collections.sort((List)localObject);
        Collections.sort(localArrayList);
        ((ArrayList)localObject).addAll(localArrayList);
        if (((ArrayList)localObject).size() == 1)
        {
          localObject = (String)((ArrayList)localObject).get(0);
          if ((this.Z == null) || (this.Z.size() <= 1)) {
            break label611;
          }
          localObject = String.format(u.a.a(2131230736, this.Z.size()), new Object[] { Integer.valueOf(this.Z.size()), localObject });
        }
      }
      for (;;)
      {
        return new android.support.v7.app.b.a(this).b(com.whatsapp.emoji.c.a((CharSequence)localObject, getBaseContext())).a(true).b(2131296398, dk.a(this)).a(2131297331, dl.a(this)).a(dm.a(this)).a();
        if (((ArrayList)localObject).size() == 2)
        {
          localObject = getString(2131297239, new Object[] { ((ArrayList)localObject).get(0), ((ArrayList)localObject).get(1) });
          break;
        }
        if (((ArrayList)localObject).size() == 3)
        {
          localObject = getString(2131297240, new Object[] { ((ArrayList)localObject).get(0), ((ArrayList)localObject).get(1), ((ArrayList)localObject).get(2) });
          break;
        }
        localObject = u.a.a(2131230774, ((ArrayList)localObject).size() - 2, new Object[] { (String)((ArrayList)localObject).get(0) + al.a(this.aF) + " " + (String)((ArrayList)localObject).get(1), Integer.valueOf(((ArrayList)localObject).size() - 2) });
        break;
        localObject = getString(2131296502, new Object[] { localObject });
        continue;
        if (this.n.d())
        {
          if ((this.Z != null) && (this.Z.size() > 1)) {
            localObject = String.format(u.a.a(2131230752, this.Z.size()), new Object[] { Integer.valueOf(this.Z.size()), this.n.a(this) });
          } else {
            localObject = getString(2131296947, new Object[] { this.n.a(this) });
          }
        }
        else if ((this.Z != null) && (this.Z.size() > 1)) {
          localObject = String.format(u.a.a(2131230736, this.Z.size()), new Object[] { Integer.valueOf(this.Z.size()), this.n.a(this) });
        } else {
          localObject = getString(2131296502, new Object[] { this.n.a(this) });
        }
      }
    case 2: 
      label611:
      if (this.n.d()) {}
      for (localObject = getString(2131296944, new Object[] { this.n.a(this) });; localObject = getString(2131296500, new Object[] { this.n.a(this) })) {
        return new android.support.v7.app.b.a(this).b(com.whatsapp.emoji.c.a((CharSequence)localObject, getBaseContext())).a(true).b(2131296398, dn.a(this)).a(2131297331, do.a(this)).a(dp.a(this)).a();
      }
    }
    Object localObject = getString(2131296946, new Object[] { this.n.a(this) });
    return new android.support.v7.app.b.a(this).b(com.whatsapp.emoji.c.a((CharSequence)localObject, getBaseContext())).a(true).b(2131296398, dq.a(this)).a(2131297331, dr.a(this)).a(ds.a(this)).a();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    this.bl = paramMenu.add(0, 2131755072, 0, 2131297631).setIcon(2130840073);
    android.support.v4.view.o.a(this.bl, 10);
    android.support.v4.view.o.a(this.bl, new o.e()
    {
      public final boolean a(MenuItem paramAnonymousMenuItem)
      {
        return true;
      }
      
      public final boolean b(MenuItem paramAnonymousMenuItem)
      {
        ContactPicker.a(ContactPicker.this, null);
        ContactPicker.b(ContactPicker.this);
        return true;
      }
    });
    MenuItem localMenuItem = this.bl;
    if (!this.ag.isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      localMenuItem.setVisible(bool);
      if ((this.W) || (this.V))
      {
        android.support.v4.view.o.a(paramMenu.add(0, 2131755061, 0, 2131297149).setIcon(2130840046).setAlphabeticShortcut('n'), 2);
        paramMenu.add(0, 2131755081, 0, 2131297978);
        paramMenu.add(0, 2131755035, 0, 2131297141);
        paramMenu.add(0, 2131755067, 0, 2131297153);
        paramMenu.add(0, 2131755036, 0, 2131297777);
      }
      return super.onCreateOptionsMenu(paramMenu);
    }
  }
  
  public void onDestroy()
  {
    Log.i("contactpicker/destroy");
    super.onDestroy();
    if (this.bx != null)
    {
      this.bw.unregisterObserver(this.bx);
      this.bx = null;
    }
    this.bj.a();
    if (this.aV != null)
    {
      this.aV.cancel(true);
      this.aV = null;
    }
    if (this.aj != null)
    {
      this.aj.cancel(true);
      this.aj = null;
    }
    if (this.aT != null)
    {
      this.aT.cancel(true);
      this.aT = null;
    }
    if (this.aU != null)
    {
      this.aU.cancel(true);
      this.aU = null;
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return true;
    case 2131755067: 
      b(true);
      if (this.aZ.b == null)
      {
        pv.a(this, 2131296797, 1);
        return true;
      }
      b(true);
      if (this.aV != null) {
        this.aV.cancel(true);
      }
      this.aV = new AsyncTask() {};
      bu.a(this.aV, new Void[0]);
      return true;
    case 2131755035: 
      paramMenuItem = new Intent("android.intent.action.VIEW", ContactsContract.Contacts.CONTENT_URI);
      paramMenuItem.setComponent(paramMenuItem.resolveActivity(getPackageManager()));
      if (paramMenuItem.getComponent() != null)
      {
        startActivity(paramMenuItem);
        return true;
      }
      try
      {
        paramMenuItem = getPackageManager().getLaunchIntentForPackage("com.android.contacts");
        if (paramMenuItem == null)
        {
          this.aq.c();
          return true;
        }
      }
      catch (ActivityNotFoundException paramMenuItem)
      {
        Log.w("contact_picker/options/system contacts app could not found");
        this.aq.c();
        return true;
      }
      startActivity(paramMenuItem);
      return true;
    case 2131755061: 
      paramMenuItem = new Intent("android.intent.action.INSERT");
      paramMenuItem.setType("vnd.android.cursor.dir/contact");
      try
      {
        startActivity(paramMenuItem);
        return true;
      }
      catch (ActivityNotFoundException paramMenuItem)
      {
        this.aq.b();
        return true;
      }
    case 2131755081: 
      pb.a(22, Integer.valueOf(5));
      this.t.a(this);
      return true;
    case 2131755072: 
      onSearchRequested();
      return true;
    case 2131755036: 
      m();
      return true;
    }
    finish();
    return true;
  }
  
  public void onResume()
  {
    super.onResume();
    if (!N) {
      a(ch.a.b);
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.n != null) {
      paramBundle.putCharSequence("jid", this.n.t);
    }
    if (!this.o.isEmpty()) {
      paramBundle.putStringArrayList("selected_jids", new ArrayList(this.o.keySet()));
    }
  }
  
  public boolean onSearchRequested()
  {
    this.bm.a();
    return false;
  }
  
  static final class a
    implements ContactPicker.e
  {
    final cs a;
    
    a(cs paramcs)
    {
      this.a = paramcs;
    }
    
    public final cs a()
    {
      return this.a;
    }
  }
  
  class b
    extends BaseAdapter
  {
    List<ContactPicker.e> a = new ArrayList();
    
    private b() {}
    
    public final ContactPicker.e a(int paramInt)
    {
      return (ContactPicker.e)this.a.get(paramInt);
    }
    
    public int getCount()
    {
      return this.a.size();
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt << 10;
    }
    
    public int getItemViewType(int paramInt)
    {
      if ((a(paramInt) instanceof ContactPicker.i)) {
        return 1;
      }
      return 0;
    }
    
    public View getView(int paramInt, View paramView, final ViewGroup paramViewGroup)
    {
      final Object localObject = a(paramInt);
      View localView;
      if ((localObject instanceof ContactPicker.i))
      {
        localView = paramView;
        if (paramView == null) {
          localView = ContactPicker.this.getLayoutInflater().inflate(2130903183, paramViewGroup, false);
        }
        paramView = (TextView)localView.findViewById(2131755177);
        aoa.b(paramView);
        paramView.setText(((ContactPicker.i)localObject).a);
        paramView = localView;
        return paramView;
      }
      if (paramView == null)
      {
        localView = al.a(ContactPicker.this.aq, ContactPicker.this.getLayoutInflater(), 2130903124, paramViewGroup, false);
        paramViewGroup = new ContactPicker.j((byte)0);
        localView.setTag(paramViewGroup);
        paramViewGroup.b = ((ImageView)localView.findViewById(2131755511));
        paramViewGroup.c = localView.findViewById(2131755395);
        paramViewGroup.d = ((TextEmojiLabel)localView.findViewById(2131755517));
        paramViewGroup.e = ((TextEmojiLabel)localView.findViewById(2131755519));
        paramViewGroup.f = ((TextView)localView.findViewById(2131755518));
        paramViewGroup.g = ((ImageView)localView.findViewById(2131755515));
        paramViewGroup.h = ((ImageView)localView.findViewById(2131755516));
        paramViewGroup.i = ((SelectionCheckView)localView.findViewById(2131755512));
        if ((ContactPicker.v(ContactPicker.this)) && (br.b())) {
          al.a(ContactPicker.this.aq, localView.findViewById(2131755513), 0, ContactPicker.this.getResources().getDimensionPixelSize(2131361940));
        }
        if (!aic.h()) {
          break label1798;
        }
        a.d.b(paramViewGroup.g.getDrawable(), ContactPicker.this.getResources().getColor(2131623985));
        a.d.b(paramViewGroup.h.getDrawable(), ContactPicker.this.getResources().getColor(2131624128));
      }
      label637:
      label914:
      label1047:
      label1094:
      label1329:
      label1772:
      label1785:
      label1798:
      for (;;)
      {
        localView.setClickable(false);
        localView.setLongClickable(false);
        if ((localObject instanceof ContactPicker.h))
        {
          localView.setBackgroundResource(0);
          paramViewGroup.a = null;
          paramViewGroup.f.setVisibility(8);
          paramViewGroup.e.setVisibility(8);
          paramViewGroup.b.setVisibility(4);
          paramViewGroup.d.setTypeface(null, 0);
          paramViewGroup.d.setText(((ContactPicker.h)localObject).a);
          paramViewGroup.i.a(false, false);
          paramViewGroup.h.setVisibility(8);
          paramViewGroup.g.setVisibility(8);
          paramViewGroup.c.setOnClickListener(null);
          paramViewGroup.b.setOnClickListener(null);
          paramViewGroup.c.setClickable(false);
          paramViewGroup.b.setClickable(false);
          return localView;
          paramViewGroup = (ContactPicker.j)paramView.getTag();
          localView = paramView;
        }
        else
        {
          localObject = ((ContactPicker.e)localObject).a();
          paramViewGroup.a = ((cs)localObject).t;
          paramViewGroup.b.setVisibility(0);
          paramViewGroup.b.setEnabled(true);
          paramViewGroup.d.setTextColor(android.support.v4.content.b.c(ContactPicker.this.getBaseContext(), 2131624047));
          if ((ContactPicker.w(ContactPicker.this) == null) && (!j.c(((cs)localObject).t)) && ((ContactPicker.x(ContactPicker.this)) || (ContactPicker.v(ContactPicker.this))))
          {
            paramView = ContactPicker.class.getName() + ((cs)localObject).t;
            ab.a(paramViewGroup.b, paramView);
            paramView = new QuickContactActivity.a(ContactPicker.this, ((cs)localObject).t, paramView);
            paramViewGroup.c.setOnClickListener(paramView);
            paramViewGroup.b.setOnClickListener(paramView);
            if ((!ContactPicker.v(ContactPicker.this)) || (!br.b())) {
              break label914;
            }
            paramViewGroup.f.setVisibility(8);
            paramViewGroup.h.setVisibility(0);
            paramViewGroup.h.setOnClickListener(ec.a(this, (cs)localObject));
            paramViewGroup.g.setVisibility(0);
            paramViewGroup.g.setOnClickListener(ed.a(this, (cs)localObject));
            paramViewGroup.e.setVisibility(8);
          }
          for (;;)
          {
            aoa.b(paramViewGroup.d);
            ContactPicker.y(ContactPicker.this).a((cs)localObject, paramViewGroup.b);
            paramViewGroup.e.setTag(((cs)localObject).t);
            if (!j.c(((cs)localObject).t)) {
              break label1329;
            }
            paramViewGroup.d.setText(2131297237);
            paramViewGroup.f.setText("");
            paramViewGroup.h.setVisibility(0);
            paramViewGroup.h.setImageResource(2130840102);
            paramViewGroup.h.setContentDescription(ContactPicker.this.getString(2131297155));
            paramViewGroup.h.setOnClickListener(ee.a(this));
            paramViewGroup.h.setFocusable(false);
            switch (ContactPicker.z(ContactPicker.this).f())
            {
            default: 
              throw new IllegalStateException("unknown status distribution mode");
              paramViewGroup.c.setOnClickListener(null);
              paramViewGroup.b.setOnClickListener(null);
              paramViewGroup.c.setClickable(false);
              paramViewGroup.b.setClickable(false);
              break label637;
              paramViewGroup.e.setVisibility(0);
              paramViewGroup.e.setTypeface(null, 0);
              paramViewGroup.e.setTextColor(android.support.v4.content.b.c(ContactPicker.this.getBaseContext(), 2131624046));
              paramViewGroup.h.setVisibility(8);
              paramViewGroup.g.setVisibility(8);
              paramViewGroup.f.setVisibility(0);
              paramViewGroup.f.setTextColor(android.support.v4.content.b.c(ContactPicker.this.getBaseContext(), 2131623998));
            }
          }
          paramView = ContactPicker.this.getString(2131297663);
          paramViewGroup.e.setText(paramView);
          final boolean bool = ContactPicker.f(ContactPicker.this).containsKey(((cs)localObject).t);
          if (bool)
          {
            paramInt = 2131624041;
            localView.setBackgroundResource(paramInt);
            if (!ContactPicker.p(ContactPicker.this).remove(((cs)localObject).t)) {
              break label1772;
            }
            paramViewGroup.i.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
            {
              public final boolean onPreDraw()
              {
                paramViewGroup.i.getViewTreeObserver().removeOnPreDrawListener(this);
                paramViewGroup.i.a(bool, true);
                return false;
              }
            });
            paramView = localView;
            if (!ContactPicker.C(ContactPicker.this)) {
              break;
            }
            paramView = localView;
            if (!ContactPicker.D(ContactPicker.this).contains(((cs)localObject).t)) {
              break;
            }
            if (!cs.e(ContactPicker.E(ContactPicker.this))) {
              break label1785;
            }
            paramViewGroup.e.setText(2131296511);
          }
          for (;;)
          {
            paramViewGroup.b.setEnabled(false);
            localView.setClickable(true);
            localView.setLongClickable(true);
            paramViewGroup.e.setTypeface(null, 2);
            paramViewGroup.e.setTextColor(1073741824);
            paramViewGroup.d.setTextColor(1073741824);
            paramViewGroup.f.setTextColor(1073741824);
            return localView;
            paramView = ContactPicker.z(ContactPicker.this).h();
            if (paramView.length == 0)
            {
              paramView = ContactPicker.this.getString(2131297663);
              break;
            }
            paramView = u.a.a(2131230795, paramView.length, new Object[] { Integer.valueOf(paramView.length) });
            break;
            paramView = ContactPicker.z(ContactPicker.this).g();
            if (paramView.length == 0)
            {
              paramView = ContactPicker.this.getString(2131297285);
              break;
            }
            paramView = u.a.a(2131230796, paramView.length, new Object[] { Integer.valueOf(paramView.length) });
            break;
            paramViewGroup.d.a((cs)localObject, ContactPicker.a(ContactPicker.this));
            if ((((cs)localObject).d()) || (j.b(((cs)localObject).t)))
            {
              if (((ContactPicker.c(ContactPicker.this)) || (ContactPicker.d(ContactPicker.this)) || (ContactPicker.e(ContactPicker.this)) || (ContactPicker.A(ContactPicker.this))) && (((cs)localObject).d()) && (!ContactPicker.this.K.b(((cs)localObject).t)))
              {
                paramViewGroup.b.setEnabled(false);
                localView.setClickable(true);
                localView.setLongClickable(true);
                paramViewGroup.e.setText(2131297313);
                paramViewGroup.e.setTypeface(null, 2);
                paramViewGroup.e.setTextColor(1073741824);
                paramViewGroup.d.setTextColor(1073741824);
              }
              for (;;)
              {
                paramViewGroup.f.setText("");
                localView.setLongClickable(false);
                break;
                String str = ContactPicker.this.K.f(((cs)localObject).t);
                if (!TextUtils.isEmpty(str))
                {
                  TextEmojiLabel localTextEmojiLabel = paramViewGroup.e;
                  if ((j.b(((cs)localObject).t)) && (TextUtils.isEmpty(((cs)localObject).e))) {}
                  for (paramView = ContactPicker.a(ContactPicker.this);; paramView = null)
                  {
                    localTextEmojiLabel.a(str, paramView);
                    break;
                  }
                }
                paramViewGroup.e.setText("");
                bu.a(new AsyncTask() {}, new Void[0]);
              }
            }
            if (ContactPicker.B(ContactPicker.this).a(((cs)localObject).t))
            {
              paramView = paramViewGroup.e;
              if (ContactPicker.v(ContactPicker.this)) {}
              for (paramInt = 2131297974;; paramInt = 2131297975)
              {
                paramView.setText(paramInt);
                paramViewGroup.d.setTextColor(1073741824);
                localView.setLongClickable(true);
                paramView = ((cs)localObject).a(ContactPicker.this.getResources());
                if (paramView == null) {
                  break;
                }
                paramViewGroup.f.setText(paramView);
                break;
              }
            }
            if (((cs)localObject).u != null) {}
            for (paramView = ((cs)localObject).u + "  ";; paramView = "  ")
            {
              paramViewGroup.e.a(paramView);
              localView.setLongClickable(false);
              break;
            }
            paramInt = 0;
            break label1047;
            paramViewGroup.i.a(bool, false);
            break label1094;
            paramViewGroup.e.setText(2131296512);
          }
        }
      }
    }
    
    public int getViewTypeCount()
    {
      return 2;
    }
    
    public boolean hasStableIds()
    {
      return true;
    }
  }
  
  final class c
    extends AsyncTask<Void, Void, List<ContactPicker.e>>
  {
    private final ArrayList<String> b;
    private final List<cs> c;
    private final List<cs> d;
    private final List<cs> e;
    
    c(List<cs> paramList1, List<cs> paramList2, List<cs> paramList3)
    {
      if (paramList1 != null) {}
      for (this$1 = new ArrayList(paramList1);; this$1 = null)
      {
        this.b = ContactPicker.this;
        this.c = paramList2;
        this.d = paramList3;
        List localList;
        this.e = localList;
        return;
      }
    }
  }
  
  final class d
    extends ContactPicker.b
    implements SectionIndexer
  {
    private ArrayList<String> d = new ArrayList();
    private ArrayList<Integer> e = new ArrayList();
    
    private d()
    {
      super((byte)0);
    }
    
    public final int getPositionForSection(int paramInt)
    {
      if ((this.e == null) || (paramInt >= this.e.size()) || (paramInt < 0)) {
        return -1;
      }
      return ((Integer)this.e.get(paramInt)).intValue();
    }
    
    public final int getSectionForPosition(int paramInt)
    {
      if (paramInt < 0) {
        return 0;
      }
      if (paramInt >= this.a.size()) {
        return this.d.size() - 1;
      }
      int i = this.e.size() - 1;
      while (i >= 0)
      {
        if (((Integer)this.e.get(i)).intValue() <= paramInt) {
          return i;
        }
        i -= 1;
      }
      return 0;
    }
    
    public final Object[] getSections()
    {
      return this.d.toArray(new String[1]);
    }
    
    public final void notifyDataSetChanged()
    {
      super.notifyDataSetChanged();
      this.d = new ArrayList();
      this.e = new ArrayList();
      int j = this.a.size();
      Object localObject1 = "";
      int i = 0;
      Object localObject2;
      if (i < j)
      {
        localObject2 = ((ContactPicker.e)this.a.get(i)).a();
        if (localObject2 == null) {
          break label175;
        }
        localObject2 = ((cs)localObject2).a(ContactPicker.this);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label175;
        }
        String str = ((String)localObject2).substring(0, 1).toUpperCase();
        if (!Character.isDigit(str.charAt(0)))
        {
          localObject2 = str;
          if (str.charAt(0) != '+') {}
        }
        else
        {
          localObject2 = "#";
        }
        if (((String)localObject1).equals(localObject2)) {
          break label175;
        }
        this.d.add(localObject2);
        this.e.add(Integer.valueOf(i));
      }
      for (;;)
      {
        i += 1;
        localObject1 = localObject2;
        break;
        return;
        label175:
        localObject2 = localObject1;
      }
    }
  }
  
  static abstract interface e
  {
    public abstract cs a();
  }
  
  static final class f
  {
    final ArrayList<cs> a;
    final ArrayList<cs> b;
    final ArrayList<cs> c;
    
    f(ArrayList<cs> paramArrayList1, ArrayList<cs> paramArrayList2, ArrayList<cs> paramArrayList3)
    {
      this.a = paramArrayList1;
      this.b = paramArrayList2;
      this.c = paramArrayList3;
    }
  }
  
  final class g
    extends AsyncTask<Void, ContactPicker.f, ContactPicker.f>
  {
    private g() {}
    
    private void a(ContactPicker.f paramf)
    {
      ContactPicker.a(ContactPicker.this, paramf.b);
      ContactPicker.b(ContactPicker.this, paramf.a);
      ContactPicker.c(ContactPicker.this, paramf.c);
      if (ContactPicker.M(ContactPicker.this) != null)
      {
        paramf = ContactPicker.M(ContactPicker.this);
        if (ContactPicker.j(ContactPicker.this).isEmpty()) {
          break label87;
        }
      }
      label87:
      for (boolean bool = true;; bool = false)
      {
        paramf.setVisible(bool);
        ContactPicker.b(ContactPicker.this);
        return;
      }
    }
  }
  
  static final class h
    implements ContactPicker.e
  {
    final String a;
    
    h(String paramString)
    {
      this.a = paramString;
    }
    
    public final cs a()
    {
      return null;
    }
  }
  
  static final class i
    implements ContactPicker.e
  {
    final String a;
    
    i(String paramString)
    {
      this.a = paramString;
    }
    
    public final cs a()
    {
      return null;
    }
  }
  
  static final class j
  {
    String a;
    ImageView b;
    View c;
    TextEmojiLabel d;
    TextEmojiLabel e;
    TextView f;
    ImageView g;
    ImageView h;
    SelectionCheckView i;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ContactPicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */