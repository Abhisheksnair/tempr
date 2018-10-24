package com.whatsapp;

import a.a.a.a.a.a.d;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.Data;
import android.support.v4.content.b;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.whatsapp.contact.sync.i;
import com.whatsapp.data.ac;
import com.whatsapp.data.ad;
import com.whatsapp.data.cs.a;
import com.whatsapp.data.cs.b;
import com.whatsapp.data.cs.c;
import com.whatsapp.data.e;
import com.whatsapp.k.d.e;
import com.whatsapp.location.bp;
import com.whatsapp.location.bp.c;
import com.whatsapp.location.bp.d;
import com.whatsapp.protocol.ap;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.protocol.m;
import com.whatsapp.util.Log;
import com.whatsapp.util.at;
import com.whatsapp.util.az;
import com.whatsapp.util.bu;
import com.whatsapp.util.l;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UnknownFormatConversionException;

public class ContactInfo
  extends bt
  implements agm.a
{
  private ListView A;
  private View B;
  private View C;
  private c D;
  private com.whatsapp.k.d E;
  private final ant F = ant.a();
  private final va G = va.a();
  private final ad H = ad.a();
  private final com.whatsapp.location.cc I = com.whatsapp.location.cc.a();
  private final e J = e.a();
  private final el K = el.a();
  private final abu L = abu.a();
  private final aq M = aq.a();
  private final cc N = cc.a();
  private final di.e O = di.a().b();
  private final bp P = bp.a();
  private final rh Q = rh.a();
  private CompoundButton.OnCheckedChangeListener R = new CompoundButton.OnCheckedChangeListener()
  {
    public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
    {
      if (paramAnonymousBoolean)
      {
        aam.a(ContactInfo.a(ContactInfo.this).t).a(ContactInfo.this.j_(), null);
        return;
      }
      ContactInfo.b(ContactInfo.this).a(ContactInfo.a(ContactInfo.this).t, true);
    }
  };
  private final hx S = hx.a();
  private final hx.a T = new hx.a()
  {
    public final void a(String paramAnonymousString)
    {
      if ((ContactInfo.a(ContactInfo.this) != null) && (TextUtils.equals(ContactInfo.a(ContactInfo.this).t, paramAnonymousString))) {
        ContactInfo.this.runOnUiThread(cu.a(ContactInfo.this));
      }
    }
  };
  private final dh U = dh.a();
  private final dh.a V = new dh.a()
  {
    public final void a()
    {
      ContactInfo.d(ContactInfo.this);
      ContactInfo.this.g_();
    }
    
    protected final void a(String paramAnonymousString)
    {
      if (paramAnonymousString.equals(ContactInfo.this.getIntent().getStringExtra("jid"))) {
        ContactInfo.d(ContactInfo.this);
      }
      do
      {
        return;
        paramAnonymousString = new cs.b(ContactInfo.e(ContactInfo.this).d(paramAnonymousString));
      } while ((ContactInfo.f(ContactInfo.this) == null) || (!com.whatsapp.data.cs.a(ContactInfo.f(ContactInfo.this).a, paramAnonymousString)));
      ContactInfo.f(ContactInfo.this).notifyDataSetChanged();
    }
    
    public final void a(Collection<String> paramAnonymousCollection)
    {
      ContactInfo.h(ContactInfo.this);
    }
    
    public final void b(String paramAnonymousString)
    {
      if (paramAnonymousString.equals(ContactInfo.this.getIntent().getStringExtra("jid"))) {
        ContactInfo.d(ContactInfo.this);
      }
      do
      {
        return;
        paramAnonymousString = new cs.c(ContactInfo.e(ContactInfo.this).d(paramAnonymousString));
      } while ((ContactInfo.f(ContactInfo.this) == null) || (!com.whatsapp.data.cs.a(ContactInfo.f(ContactInfo.this).a, paramAnonymousString)));
      ContactInfo.f(ContactInfo.this).notifyDataSetChanged();
    }
    
    public final void c(String paramAnonymousString)
    {
      if (paramAnonymousString.equals(ContactInfo.this.getIntent().getStringExtra("jid"))) {
        ContactInfo.d(ContactInfo.this);
      }
    }
    
    public final void d(String paramAnonymousString)
    {
      if (paramAnonymousString.equals(ContactInfo.this.getIntent().getStringExtra("jid")))
      {
        paramAnonymousString = (TextView)ContactInfo.this.findViewById(2131755461);
        String str = ContactInfo.g(ContactInfo.this).b(ContactInfo.a(ContactInfo.this));
        paramAnonymousString.setText(str);
        if (!TextUtils.isEmpty(str)) {
          break label71;
        }
      }
      label71:
      for (int i = 8;; i = 0)
      {
        paramAnonymousString.setVisibility(i);
        return;
      }
    }
  };
  private final ac W = ac.a();
  private final com.whatsapp.data.ab X = new com.whatsapp.data.ab()
  {
    public final void a(j paramAnonymousj, int paramAnonymousInt)
    {
      if ((paramAnonymousj != null) && (paramAnonymousj.e.a.equals(ContactInfo.a(ContactInfo.this).t)) && (!paramAnonymousj.e.b) && (m.a(paramAnonymousj.s)) && (paramAnonymousInt == 3)) {
        ContactInfo.d(ContactInfo.this);
      }
    }
    
    public final void a(Collection<j> paramAnonymousCollection, String paramAnonymousString, Map<String, Integer> paramAnonymousMap, boolean paramAnonymousBoolean)
    {
      if ((paramAnonymousCollection != null) && (!paramAnonymousCollection.isEmpty()))
      {
        paramAnonymousCollection = paramAnonymousCollection.iterator();
        while (paramAnonymousCollection.hasNext()) {
          if (((j)paramAnonymousCollection.next()).e.a.equals(ContactInfo.a(ContactInfo.this).t)) {
            ContactInfo.d(ContactInfo.this);
          }
        }
      }
      while ((paramAnonymousString != null) && (!ContactInfo.a(ContactInfo.this).t.equals(paramAnonymousString))) {
        return;
      }
      ContactInfo.d(ContactInfo.this);
    }
    
    public final void a(Collection<j> paramAnonymousCollection, Map<String, Integer> paramAnonymousMap)
    {
      paramAnonymousCollection = paramAnonymousCollection.iterator();
      while (paramAnonymousCollection.hasNext())
      {
        paramAnonymousMap = (j)paramAnonymousCollection.next();
        if ((paramAnonymousMap.e.a.equals(ContactInfo.a(ContactInfo.this).t)) && ((m.a(paramAnonymousMap.s)) || (paramAnonymousMap.T))) {
          ContactInfo.d(ContactInfo.this);
        }
      }
    }
  };
  private bp.c Y = new bp.c()
  {
    public final void a(String paramAnonymousString)
    {
      if (paramAnonymousString.equals(ContactInfo.this.l())) {
        ContactInfo.this.runOnUiThread(cv.a(ContactInfo.this));
      }
    }
    
    public final void b(String paramAnonymousString)
    {
      if (paramAnonymousString.equals(ContactInfo.this.l())) {
        ContactInfo.this.runOnUiThread(cw.a(ContactInfo.this));
      }
    }
  };
  private bp.d Z = new bp.d()
  {
    public final void a(ap paramAnonymousap) {}
    
    public final void a(String paramAnonymousString)
    {
      if (paramAnonymousString.equals(ContactInfo.this.l())) {
        ContactInfo.this.runOnUiThread(cy.a(ContactInfo.this));
      }
    }
    
    public final void a(String paramAnonymousString1, String paramAnonymousString2)
    {
      if (paramAnonymousString1.equals(ContactInfo.this.l())) {
        ContactInfo.this.runOnUiThread(cx.a(ContactInfo.this));
      }
    }
  };
  private CharSequence aa;
  com.whatsapp.data.cs q;
  a r;
  Handler s = new Handler(Looper.getMainLooper());
  Runnable t = new Runnable()
  {
    public final void run()
    {
      ContactInfo.m(ContactInfo.this);
      ContactInfo.this.s.postDelayed(this, ContactInfo.n(ContactInfo.this));
    }
  };
  private ImageView u;
  private ChatInfoLayout v;
  private View w;
  private LinearLayout x;
  private LinearLayout y;
  private LinearLayout z;
  
  public static void a(com.whatsapp.data.cs paramcs, Activity paramActivity)
  {
    a(paramcs, paramActivity, null);
  }
  
  public static void a(com.whatsapp.data.cs paramcs, Activity paramActivity, android.support.v4.app.c paramc)
  {
    Intent localIntent = new Intent(paramActivity, ContactInfo.class);
    localIntent.putExtra("jid", paramcs.t);
    localIntent.putExtra("circular_transition", true);
    if (paramc == null) {}
    for (paramcs = null;; paramcs = paramc.a())
    {
      android.support.v4.app.a.a(paramActivity, localIntent, paramcs);
      return;
    }
  }
  
  private void a(List<com.whatsapp.data.cs> paramList)
  {
    this.r.a(paramList);
    if (this.r.getCount() == 0)
    {
      findViewById(2131755483).setVisibility(8);
      return;
    }
    findViewById(2131755483).setVisibility(0);
    ((TextView)findViewById(2131755484)).setText(NumberFormat.getInstance().format(this.r.getCount()));
  }
  
  /* Error */
  private String r()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 538	a/a/a/a/a/a
    //   5: dup
    //   6: aload_0
    //   7: aload_0
    //   8: getfield 153	com/whatsapp/ContactInfo:J	Lcom/whatsapp/data/e;
    //   11: invokespecial 541	a/a/a/a/a/a:<init>	(Landroid/content/Context;Lcom/whatsapp/data/e;)V
    //   14: astore_3
    //   15: aload_3
    //   16: getfield 544	a/a/a/a/a/a:c	La/a/a/a/a/a$c;
    //   19: aload_0
    //   20: getfield 266	com/whatsapp/ContactInfo:q	Lcom/whatsapp/data/cs;
    //   23: invokevirtual 546	com/whatsapp/data/cs:j	()Ljava/lang/String;
    //   26: putfield 549	a/a/a/a/a/a$c:a	Ljava/lang/String;
    //   29: aload_3
    //   30: iconst_2
    //   31: aload_0
    //   32: getfield 266	com/whatsapp/ContactInfo:q	Lcom/whatsapp/data/cs;
    //   35: getfield 457	com/whatsapp/data/cs:t	Ljava/lang/String;
    //   38: aload_0
    //   39: getfield 266	com/whatsapp/ContactInfo:q	Lcom/whatsapp/data/cs;
    //   42: getfield 457	com/whatsapp/data/cs:t	Ljava/lang/String;
    //   45: invokestatic 552	com/whatsapp/data/cs:b	(Ljava/lang/String;)Ljava/lang/String;
    //   48: ldc_w 554
    //   51: iconst_1
    //   52: invokevirtual 557	a/a/a/a/a/a:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   55: aload_0
    //   56: getfield 266	com/whatsapp/ContactInfo:q	Lcom/whatsapp/data/cs;
    //   59: bipush 96
    //   61: fconst_0
    //   62: invokevirtual 560	com/whatsapp/data/cs:c	(IF)Landroid/graphics/Bitmap;
    //   65: astore 4
    //   67: aload 4
    //   69: ifnull +99 -> 168
    //   72: new 562	java/io/ByteArrayOutputStream
    //   75: dup
    //   76: invokespecial 563	java/io/ByteArrayOutputStream:<init>	()V
    //   79: astore_1
    //   80: aload_1
    //   81: astore_2
    //   82: aload 4
    //   84: getstatic 569	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   87: bipush 75
    //   89: aload_1
    //   90: invokevirtual 575	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   93: ifeq +13 -> 106
    //   96: aload_3
    //   97: aload_1
    //   98: invokevirtual 579	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   101: putfield 582	a/a/a/a/a/a:f	[B
    //   104: aload_1
    //   105: astore_2
    //   106: aload_2
    //   107: ifnull +7 -> 114
    //   110: aload_2
    //   111: invokevirtual 585	java/io/ByteArrayOutputStream:close	()V
    //   114: new 587	a/a/a/a/a/c
    //   117: dup
    //   118: invokespecial 588	a/a/a/a/a/c:<init>	()V
    //   121: astore_1
    //   122: aload_1
    //   123: aload_0
    //   124: invokevirtual 591	com/whatsapp/ContactInfo:getApplicationContext	()Landroid/content/Context;
    //   127: aload_3
    //   128: invokevirtual 594	a/a/a/a/a/c:a	(Landroid/content/Context;La/a/a/a/a/a;)Ljava/lang/String;
    //   131: astore_1
    //   132: aload_1
    //   133: areturn
    //   134: astore_1
    //   135: aload_2
    //   136: ifnull +7 -> 143
    //   139: aload_2
    //   140: invokevirtual 585	java/io/ByteArrayOutputStream:close	()V
    //   143: aload_1
    //   144: athrow
    //   145: astore_1
    //   146: aload_1
    //   147: invokestatic 599	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   150: aconst_null
    //   151: areturn
    //   152: astore_1
    //   153: goto -39 -> 114
    //   156: astore_2
    //   157: goto -14 -> 143
    //   160: astore_3
    //   161: aload_1
    //   162: astore_2
    //   163: aload_3
    //   164: astore_1
    //   165: goto -30 -> 135
    //   168: aconst_null
    //   169: astore_2
    //   170: goto -64 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	ContactInfo
    //   79	54	1	localObject1	Object
    //   134	10	1	localObject2	Object
    //   145	2	1	locald	a.a.a.a.a.d
    //   152	10	1	localIOException1	java.io.IOException
    //   164	1	1	localObject3	Object
    //   1	139	2	localObject4	Object
    //   156	1	2	localIOException2	java.io.IOException
    //   162	8	2	localObject5	Object
    //   14	114	3	locala	a.a.a.a.a.a
    //   160	4	3	localObject6	Object
    //   65	18	4	localBitmap	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   55	67	134	finally
    //   72	80	134	finally
    //   122	132	145	a/a/a/a/a/d
    //   110	114	152	java/io/IOException
    //   139	143	156	java/io/IOException
    //   82	104	160	finally
  }
  
  private void s()
  {
    TextView localTextView = (TextView)findViewById(2131755481);
    if (this.q.v != 0L) {
      try
      {
        CharSequence localCharSequence = DateUtils.getRelativeTimeSpanString(this.F.a(this.q.v), System.currentTimeMillis(), 0L, 0);
        if (!TextUtils.equals(this.aa, localCharSequence))
        {
          this.aa = localCharSequence;
          localTextView.setText(this.aa);
        }
        return;
      }
      catch (UnknownFormatConversionException localUnknownFormatConversionException)
      {
        Log.e(localUnknownFormatConversionException);
      }
    }
    localTextView.setText("");
  }
  
  private long t()
  {
    if (this.q.v == 0L) {
      return 60000L;
    }
    long l = System.currentTimeMillis() - this.F.a(this.q.v);
    if (l < 60000L) {
      return 500L;
    }
    if (l < 3600000L) {
      return 5000L;
    }
    return 20000L;
  }
  
  private void u()
  {
    Log.i("contactinfo/update");
    this.q = this.J.a(getIntent().getStringExtra("jid"));
    this.v.setTitleText(this.q.a(this));
    Object localObject1 = this.v;
    boolean bool;
    Object localObject2;
    int i;
    label118:
    Object localObject3;
    View localView;
    label247:
    ImageView localImageView2;
    if ((e.b(this.q.t)) || (this.q.f()))
    {
      bool = true;
      ((ChatInfoLayout)localObject1).setTitleVerified(bool);
      localObject1 = (TextView)findViewById(2131755461);
      localObject2 = this.K.b(this.q);
      ((TextView)localObject1).setText((CharSequence)localObject2);
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label576;
      }
      i = 8;
      ((TextView)localObject1).setVisibility(i);
      localObject1 = findViewById(2131755479);
      localObject2 = (TextEmojiLabel)((View)localObject1).findViewById(2131755329);
      localObject3 = (TextView)((View)localObject1).findViewById(2131755481);
      localView = ((View)localObject1).findViewById(2131755482);
      if (this.q.u == null) {
        break label581;
      }
      ((TextEmojiLabel)localObject2).setVisibility(0);
      ((TextView)localObject3).setVisibility(0);
      localView.setVisibility(0);
      s();
      this.s.removeCallbacks(this.t);
      if (this.q.v != 0L) {
        this.s.postDelayed(this.t, t());
      }
      ((TextEmojiLabel)localObject2).a(this.q.u);
      localObject2 = (TextView)((View)localObject1).findViewById(2131755474);
      localObject3 = (TextView)((View)localObject1).findViewById(2131755475);
      localView = ((View)localObject1).findViewById(2131755472);
      ImageView localImageView1 = (ImageView)((View)localObject1).findViewById(2131755477);
      localImageView2 = (ImageView)((View)localObject1).findViewById(2131755478);
      ((TextView)localObject2).setText(com.whatsapp.data.cs.b(this.q.t));
      ((TextView)localObject3).setText(this.q.a(getResources()));
      localView.setOnClickListener(cr.a(this));
      localImageView1.setOnClickListener(cs.a(this));
      if (aic.h()) {
        a.d.b(localImageView1.getDrawable(), getResources().getColor(2131623985));
      }
      if (!br.b()) {
        break label605;
      }
      localImageView2.setVisibility(0);
      localImageView2.setOnClickListener(ct.a(this));
      if (aic.h()) {
        a.d.b(localImageView2.getDrawable(), getResources().getColor(2131624128));
      }
      label422:
      localObject2 = (TextView)findViewById(2131755254);
      localObject3 = (ImageView)findViewById(2131755255);
      ((TextView)localObject2).setText(2131296517);
      ((ImageView)localObject3).setImageDrawable(new az(b.a(this, 2130840154)));
      findViewById(2131755253).setOnClickListener(new at()
      {
        public final void a(View paramAnonymousView)
        {
          paramAnonymousView = new Intent(ContactInfo.this, IdentityVerificationActivity.class);
          paramAnonymousView.putExtra("jid", ContactInfo.a(ContactInfo.this).t);
          ContactInfo.this.startActivity(paramAnonymousView);
        }
      });
      if (e.b(this.q.t)) {
        break label615;
      }
      findViewById(2131755253).setVisibility(0);
      findViewById(2131755252).setVisibility(0);
    }
    for (;;)
    {
      if (this.D != null) {
        this.D.cancel(true);
      }
      o();
      this.D = new c();
      bu.a(this.D, new Void[0]);
      return;
      bool = false;
      break;
      label576:
      i = 0;
      break label118;
      label581:
      ((TextEmojiLabel)localObject2).setVisibility(8);
      ((TextView)localObject3).setVisibility(8);
      localView.setVisibility(8);
      break label247;
      label605:
      localImageView2.setVisibility(8);
      break label422;
      label615:
      findViewById(2131755253).setVisibility(8);
      findViewById(2131755252).setVisibility(8);
      ((View)localObject1).setVisibility(8);
    }
  }
  
  private void v()
  {
    if (this.q == null) {
      return;
    }
    cc.a locala = this.N.a(this.q.t);
    TextView localTextView = (TextView)findViewById(2131755248);
    if (locala.e) {}
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  private void w()
  {
    if (this.q == null) {
      return;
    }
    Object localObject = (TextView)findViewById(2131755487);
    ImageView localImageView = (ImageView)findViewById(2131755486);
    if (this.M.a(this.q.t))
    {
      localImageView.setColorFilter(b.c(getApplicationContext(), 2131624003));
      ((TextView)localObject).setTextColor(b.c(getApplicationContext(), 2131624003));
      ((TextView)localObject).setText(2131298057);
    }
    for (;;)
    {
      localObject = findViewById(2131755488);
      if (!this.q.F) {
        break;
      }
      ((View)localObject).setVisibility(8);
      return;
      localImageView.setColorFilter(b.c(getApplicationContext(), 2131624103));
      ((TextView)localObject).setTextColor(b.c(getApplicationContext(), 2131624103));
      ((TextView)localObject).setText(2131296350);
    }
    ((View)localObject).setVisibility(0);
  }
  
  private void x()
  {
    if (this.q == null) {
      return;
    }
    cc.a locala = this.N.a(this.q.t);
    TextView localTextView = (TextView)findViewById(2131755244);
    SwitchCompat localSwitchCompat = (SwitchCompat)findViewById(2131755245);
    localSwitchCompat.setOnCheckedChangeListener(null);
    if (locala.b())
    {
      localTextView.setVisibility(0);
      localTextView.setText(l.c(this, this.aF, locala.a()));
      localSwitchCompat.setChecked(true);
    }
    for (;;)
    {
      localSwitchCompat.setOnCheckedChangeListener(this.R);
      return;
      localTextView.setVisibility(8);
      localSwitchCompat.setChecked(false);
    }
  }
  
  private void y()
  {
    View localView = (View)a.d.a(findViewById(2131755858));
    TextView localTextView = (TextView)a.d.a(findViewById(2131755859));
    boolean bool = this.P.f(l());
    int i = this.P.a(l());
    if (((i == 0) && (!bool)) || (!aic.u))
    {
      localView.setVisibility(8);
      return;
    }
    localView.setVisibility(0);
    if (bool)
    {
      if (i == 0)
      {
        localTextView.setText(2131296522);
        return;
      }
      localTextView.setText(getString(2131296521, new Object[] { this.q.a(this) }));
      return;
    }
    localTextView.setText(getString(2131296520, new Object[] { this.q.a(this) }));
  }
  
  public void finishAfterTransition()
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.B.setTransitionName(null);
      TransitionSet localTransitionSet = new TransitionSet();
      Slide localSlide = new Slide(48);
      localSlide.addTarget(this.B);
      localTransitionSet.addTransition(localSlide);
      localSlide = new Slide(80);
      localSlide.addTarget(this.A);
      localTransitionSet.addTransition(localSlide);
      getWindow().setReturnTransition(localTransitionSet);
    }
    super.finishAfterTransition();
  }
  
  public final String l()
  {
    if (this.q == null) {
      return null;
    }
    return this.q.t;
  }
  
  final void m()
  {
    super.m();
    if (this.D != null)
    {
      this.D.cancel(true);
      this.D = null;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default: 
      return;
    case 10: 
    case 11: 
      this.aH.b();
      return;
    }
    v();
  }
  
  @SuppressLint({"PrivateResource"})
  public void onCreate(Bundle paramBundle)
  {
    Log.i("contactinfo/create");
    this.E = com.whatsapp.k.c.a("ContactInfoInit");
    this.E.a();
    this.E.a(d.e.b);
    super.onCreate(paramBundle);
    o_();
    this.v = ((ChatInfoLayout)al.a(this.aq, getLayoutInflater(), 2130903110, null, false));
    setContentView(this.v);
    paramBundle = (Toolbar)findViewById(2131755412);
    paramBundle.setTitle("");
    paramBundle.e();
    a(paramBundle);
    android.support.v7.app.a locala = i();
    if (locala != null) {
      locala.a(true);
    }
    paramBundle.setNavigationIcon(new az(b.a(this, 2130840096)));
    this.A = W();
    this.w = al.a(this.aq, getLayoutInflater(), 2130903113, this.A, false);
    this.A.addHeaderView(this.w, null, false);
    this.B = findViewById(2131755386);
    this.v.a();
    this.v.a(getResources().getDimensionPixelSize(2131361843), 0);
    this.x = new LinearLayout(this);
    this.x.setOrientation(1);
    this.z = new LinearLayout(this);
    this.z.setOrientation(1);
    this.x.addView(this.z);
    this.C = al.a(this.aq, getLayoutInflater(), 2130903115, this.A, false);
    this.x.addView(this.C);
    this.A.addFooterView(this.x, null, false);
    this.y = new LinearLayout(this);
    int i = getWindowManager().getDefaultDisplay().getHeight();
    this.y.setPadding(0, 0, 0, i);
    this.A.addFooterView(this.y, null, false);
    this.u = ((ImageView)findViewById(2131755467));
    this.v.setOnPhotoClickListener(ci.a(this));
    paramBundle = cm.a(this);
    findViewById(2131755917).setOnClickListener(paramBundle);
    findViewById(2131755918).setOnClickListener(paramBundle);
    this.A.setOnItemClickListener(cn.a(this));
    this.r = new a(this);
    this.A.setAdapter(this.r);
    a(null);
    a(0L);
    findViewById(2131755250).setOnClickListener(co.a(this));
    b(true);
    u();
    ((View)a.d.a(findViewById(2131755858))).setOnClickListener(new at()
    {
      public final void a(View paramAnonymousView)
      {
        ContactInfo.j(ContactInfo.this).a(ContactInfo.this, ContactInfo.this.l(), null);
      }
    });
    this.P.a(this.Y);
    this.P.a(this.Z);
    y();
    v();
    findViewById(2131755247).setOnClickListener(cp.a(this));
    x();
    w();
    findViewById(2131755243).setOnClickListener(cq.a(this));
    ((SwitchCompat)findViewById(2131755245)).setOnCheckedChangeListener(this.R);
    this.W.registerObserver(this.X);
    this.U.registerObserver(this.V);
    this.S.registerObserver(this.T);
    ((View)a.d.a(findViewById(2131755489))).setOnClickListener(new at()
    {
      public final void a(View paramAnonymousView)
      {
        paramAnonymousView = agm.a(ContactInfo.a(ContactInfo.this).t, "account_info");
        ContactInfo.this.a(paramAnonymousView);
      }
    });
    ((View)a.d.a(findViewById(2131755485))).setOnClickListener(new at()
    {
      public final void a(View paramAnonymousView)
      {
        if (ContactInfo.k(ContactInfo.this).a(ContactInfo.a(ContactInfo.this).t))
        {
          ContactInfo.k(ContactInfo.this).a(ContactInfo.this, false, ContactInfo.a(ContactInfo.this).t);
          return;
        }
        paramAnonymousView = am.a(ContactInfo.a(ContactInfo.this).t);
        ContactInfo.this.a(paramAnonymousView);
      }
    });
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (!getIntent().getBooleanExtra("circular_transition", false)) {
        break label731;
      }
      this.B.setTransitionName(getString(2131298269));
    }
    for (;;)
    {
      a.a.a.a.d.a(W(), this.E);
      this.E.b(d.e.b);
      return;
      label731:
      findViewById(2131755467).setTransitionName(getString(2131298269));
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    if (this.q != null)
    {
      if (e.b(this.q.t)) {
        return super.onCreateOptionsMenu(paramMenu);
      }
      if ((this.q.d != null) || (this.q.f())) {
        paramMenu.add(0, 7, 0, 2131297834);
      }
      if (this.q.d == null) {
        break label120;
      }
      paramMenu.add(0, 6, 0, 2131296694);
      paramMenu.add(0, 1, 0, 2131298121);
    }
    for (;;)
    {
      paramMenu.add(0, 5, 0, getString(2131298084));
      return super.onCreateOptionsMenu(paramMenu);
      label120:
      paramMenu.add(0, 3, 0, getString(2131296292));
      paramMenu.add(0, 4, 0, getString(2131296296));
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.E.c();
    Log.i("contactinfo/destroy");
    this.P.b(this.Y);
    this.P.b(this.Z);
    this.U.unregisterObserver(this.V);
    this.S.unregisterObserver(this.T);
    this.W.unregisterObserver(this.X);
    this.O.a();
    this.s.removeCallbacks(this.t);
    this.u.setImageDrawable(null);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool2 = true;
    boolean bool1;
    switch (paramMenuItem.getItemId())
    {
    default: 
      bool1 = false;
    case 1: 
    case 6: 
    case 7: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return bool1;
                  bool1 = bool2;
                } while (this.q.d == null);
                paramMenuItem = this.q.b(getContentResolver());
                bool1 = bool2;
              } while (paramMenuItem == null);
              paramMenuItem = new Intent("android.intent.action.VIEW", paramMenuItem);
              paramMenuItem.setComponent(paramMenuItem.resolveActivity(getPackageManager()));
              if (paramMenuItem.getComponent() != null)
              {
                startActivity(paramMenuItem);
                return true;
              }
              Log.w("contactinfo/opt system contact list could not found");
              this.aq.b();
              return true;
              bool1 = bool2;
            } while (this.q.d == null);
            paramMenuItem = this.q.b(getContentResolver());
            bool1 = bool2;
          } while (paramMenuItem == null);
          paramMenuItem = new Intent("android.intent.action.EDIT", paramMenuItem);
          paramMenuItem.setComponent(paramMenuItem.resolveActivity(getPackageManager()));
          if (paramMenuItem.getComponent() != null)
          {
            startActivity(paramMenuItem);
            return true;
          }
          Log.w("contactinfo/opt system contact list could not found");
          this.aq.b();
          return true;
          if (this.q.f())
          {
            paramMenuItem = r();
            if (paramMenuItem != null)
            {
              startActivity(new Intent(this, ContactPicker.class).setType("text/x-vcard").putExtra("android.intent.extra.TEXT", paramMenuItem));
              return true;
            }
            pv.a(this, 2131298052, 0);
            return true;
          }
          bool1 = bool2;
        } while (this.q.d == null);
        paramMenuItem = this.q.a(getContentResolver());
        bool1 = bool2;
      } while (paramMenuItem == null);
      startActivity(new Intent(this, ContactPicker.class).setType("text/x-vcard").putExtra("android.intent.extra.STREAM", paramMenuItem));
      return true;
    case 3: 
      paramMenuItem = new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI);
      if (this.q.f()) {
        paramMenuItem.putExtra("name", this.q.j());
      }
      paramMenuItem.putExtra("phone", com.whatsapp.data.cs.b(this.q.t));
      try
      {
        startActivityForResult(paramMenuItem, 10);
        return true;
      }
      catch (ActivityNotFoundException paramMenuItem)
      {
        this.aq.b();
        return true;
      }
    case 4: 
      paramMenuItem = new Intent("android.intent.action.INSERT_OR_EDIT");
      paramMenuItem.setType("vnd.android.cursor.item/contact");
      paramMenuItem.putExtra("phone", com.whatsapp.data.cs.b(this.q.t));
      paramMenuItem.putExtra("phone_type", 2);
      paramMenuItem.setFlags(524288);
      try
      {
        startActivityForResult(paramMenuItem, 11);
        return true;
      }
      catch (ActivityNotFoundException paramMenuItem)
      {
        this.aq.b();
        return true;
      }
    case 5: 
      paramMenuItem = new Intent(this, IdentityVerificationActivity.class);
      paramMenuItem.putExtra("jid", this.q.t);
      startActivity(paramMenuItem);
      return true;
    }
    android.support.v4.app.a.c(this);
    return true;
  }
  
  public void onPause()
  {
    super.onPause();
    this.E.c();
  }
  
  public void onResume()
  {
    this.E.a(d.e.g);
    super.onResume();
    this.L.a(this.q);
    this.E.b(d.e.g);
  }
  
  public final void p()
  {
    this.A.post(cj.a(this));
  }
  
  final class a
    extends ArrayAdapter<com.whatsapp.data.cs>
  {
    protected List<com.whatsapp.data.cs> a;
    private LayoutInflater c;
    
    public a(Context paramContext)
    {
      super(2130903330, null);
      this.c = LayoutInflater.from(paramContext);
      this.a = new ArrayList();
    }
    
    public final com.whatsapp.data.cs a(int paramInt)
    {
      return (com.whatsapp.data.cs)this.a.get(paramInt);
    }
    
    public final void a(List<com.whatsapp.data.cs> paramList)
    {
      this.a = paramList;
      notifyDataSetChanged();
    }
    
    public final int getCount()
    {
      if (this.a == null) {
        return 0;
      }
      return this.a.size();
    }
    
    public final View getView(int paramInt, View paramView, final ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = al.a(ContactInfo.this.aq, this.c, 2130903330, paramViewGroup, false);
        paramViewGroup = new ContactInfo.d((byte)0);
        paramViewGroup.b = ((TextEmojiLabel)paramView.findViewById(2131755507));
        paramViewGroup.c = ((TextEmojiLabel)paramView.findViewById(2131755329));
        paramViewGroup.d = ((ImageView)paramView.findViewById(2131755801));
        paramViewGroup.e = paramView.findViewById(2131755385);
        paramView.setTag(paramViewGroup);
        paramView.setBackgroundColor(b.c(getContext(), 2131624135));
        if (paramInt != getCount() - 1) {
          break label260;
        }
        paramViewGroup.e.setVisibility(8);
      }
      for (;;)
      {
        final com.whatsapp.data.cs localcs = a(paramInt);
        paramViewGroup.a = localcs;
        paramViewGroup.b.setContact(localcs);
        paramViewGroup.c.setTag(localcs.t);
        paramViewGroup.c.setText("");
        android.support.v4.view.ab.a(paramViewGroup.d, ContactInfo.this.getString(2131298268) + localcs.t);
        bu.a(new AsyncTask() {}, new Void[0]);
        ContactInfo.s(ContactInfo.this).a(localcs, paramViewGroup.d);
        paramViewGroup.d.setOnClickListener(cz.a(this, localcs, paramViewGroup));
        return paramView;
        paramViewGroup = (ContactInfo.d)paramView.getTag();
        break;
        label260:
        paramViewGroup.e.setVisibility(0);
      }
    }
    
    public final int getViewTypeCount()
    {
      return 1;
    }
  }
  
  final class b
  {
    String a;
    String b;
    String c;
    com.whatsapp.data.cs d;
    
    b(com.whatsapp.data.cs paramcs)
    {
      this.a = com.whatsapp.data.cs.b(paramcs.t);
      this.b = ((String)paramcs.a(ContactInfo.this.getResources()));
      if (paramcs.h) {
        this.c = paramcs.t;
      }
      this.d = paramcs;
    }
    
    b(String paramString1, String paramString2)
    {
      this.a = paramString1;
      this.b = paramString2;
    }
  }
  
  final class c
    extends AsyncTask<Void, Void, Void>
  {
    c() {}
    
    private void b(ArrayList<ContactInfo.b> paramArrayList)
    {
      if (b.a(u.a(), "android.permission.READ_CONTACTS") != 0) {
        return;
      }
      Object localObject1 = ContactInfo.this.getContentResolver();
      Object localObject2 = ContactsContract.Data.CONTENT_URI;
      long l = ContactInfo.a(ContactInfo.this).g();
      localObject2 = ((ContentResolver)localObject1).query((Uri)localObject2, new String[] { "_id", "contact_id" }, "raw_contact_id=? AND mimetype='vnd.android.cursor.item/phone_v2'", new String[] { String.valueOf(l) }, null);
      label129:
      String str1;
      if (localObject2 != null) {
        if (((Cursor)localObject2).moveToNext())
        {
          localObject1 = ((Cursor)localObject2).getString(((Cursor)localObject2).getColumnIndex("contact_id"));
          Log.d("contact_info/contact_id:" + (String)localObject1);
          ((Cursor)localObject2).close();
          str1 = null;
          localObject2 = localObject1;
          localObject1 = str1;
        }
      }
      for (;;)
      {
        if (localObject2 != null) {
          localObject1 = ContactInfo.this.getContentResolver().query(ContactsContract.Data.CONTENT_URI, new String[] { "_id", "raw_contact_id", "data1", "data2", "data3" }, "contact_id=? AND mimetype='vnd.android.cursor.item/phone_v2'", new String[] { localObject2 }, null);
        }
        while (localObject1 != null)
        {
          int j;
          while (((Cursor)localObject1).moveToNext())
          {
            str1 = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("data1"));
            if (str1 != null) {
              if (!isCancelled())
              {
                l = ((Cursor)localObject1).getLong(((Cursor)localObject1).getColumnIndex("raw_contact_id"));
                j = ((Cursor)localObject1).getInt(((Cursor)localObject1).getColumnIndex("data2"));
                localObject2 = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("data3"));
                if ((j == 0) && (localObject2 != null)) {
                  break label652;
                }
                localObject2 = ContactInfo.this.getResources().getString(ContactsContract.CommonDataKinds.Phone.getTypeLabelResource(j));
              }
            }
          }
          label652:
          for (;;)
          {
            ContactInfo.b localb = new ContactInfo.b(ContactInfo.this, str1, (String)localObject2);
            Object localObject3 = ContactInfo.e(ContactInfo.this).a(new cs.a(l, PhoneNumberUtils.stripSeparators(str1)));
            if ((localObject3 != null) && (((com.whatsapp.data.cs)localObject3).h))
            {
              localb.c = ((com.whatsapp.data.cs)localObject3).t;
              localb.d = ((com.whatsapp.data.cs)localObject3);
            }
            localObject3 = str1.replaceAll("\\D", "");
            Iterator localIterator = paramArrayList.iterator();
            String str2;
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
              str2 = ((ContactInfo.b)localIterator.next()).a.replaceAll("\\D", "");
            } while ((!((String)localObject3).endsWith(str2)) && (!str2.endsWith((String)localObject3)));
            for (int i = 0;; i = 1)
            {
              if ((i != 0) && (localb.c != null)) {
                paramArrayList.add(localb);
              }
              Log.d("contact_info/raw_contact_id:" + l + " number:" + str1 + " type:" + j + " label:" + (String)localObject2);
              break;
              i = 1;
              if (i < paramArrayList.size())
              {
                localObject2 = (ContactInfo.b)paramArrayList.get(i);
                if (((ContactInfo.b)localObject2).c != null) {}
                for (((ContactInfo.b)localObject2).a = com.whatsapp.data.cs.b(((ContactInfo.b)localObject2).c);; ((ContactInfo.b)localObject2).a = com.whatsapp.data.cs.a(((ContactInfo.b)localObject2).a.substring(1))) {
                  do
                  {
                    i += 1;
                    break;
                  } while ((TextUtils.isEmpty(((ContactInfo.b)localObject2).a)) || (((ContactInfo.b)localObject2).a.charAt(0) != '+'));
                }
              }
              ((Cursor)localObject1).close();
              return;
            }
          }
        }
        break;
        localObject1 = null;
        break label129;
        str1 = null;
        localObject1 = localObject2;
        localObject2 = str1;
      }
    }
  }
  
  static final class d
  {
    com.whatsapp.data.cs a;
    TextEmojiLabel b;
    TextEmojiLabel c;
    ImageView d;
    View e;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ContactInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */