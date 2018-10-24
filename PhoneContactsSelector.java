package com.whatsapp;

import a.a.a.a.a.a.d;
import a.a.a.a.a.c;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.ContactsContract.Data;
import android.support.v4.view.ab;
import android.support.v4.view.o;
import android.support.v4.view.o.e;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.g;
import android.support.v7.widget.SearchView.b;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.util.Log;
import com.whatsapp.util.at;
import com.whatsapp.util.be;
import com.whatsapp.util.bu;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class PhoneContactsSelector
  extends nm
{
  private c A;
  private d B;
  private final e C = e.a();
  private final and D = and.a();
  private final di.e E = di.a().b();
  private ListView F;
  private View G;
  private View H;
  private boolean I;
  private RecyclerView J;
  private String K;
  private long L;
  final ani n = ani.a();
  private b p;
  private final ArrayList<a> q = new ArrayList();
  private final ArrayList<a> r = new ArrayList();
  private ArrayList<String> s;
  private String t;
  private final List<a> u = new ArrayList();
  private f v = new f((byte)0);
  private InputMethodManager w;
  private boolean x;
  private MenuItem y;
  private ahp z;
  
  static
  {
    if (!PhoneContactsSelector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      o = bool;
      return;
    }
  }
  
  private void d(int paramInt)
  {
    android.support.v7.app.a locala = i();
    if ((!o) && (locala == null)) {
      throw new AssertionError();
    }
    locala.b(String.format(u.a.a(2131230771, paramInt), new Object[] { Integer.valueOf(paramInt) }));
  }
  
  protected static int l()
  {
    return 1;
  }
  
  private void m()
  {
    if ((this.G.getVisibility() != 0) && (this.I))
    {
      this.H.setVisibility(0);
      return;
    }
    this.H.setVisibility(8);
  }
  
  /* Error */
  private ArrayList<a> n()
  {
    // Byte code:
    //   0: invokestatic 282	a/a/a/a/a/a$d:c	()V
    //   3: aload_0
    //   4: invokevirtual 286	com/whatsapp/PhoneContactsSelector:getApplicationContext	()Landroid/content/Context;
    //   7: astore 7
    //   9: aload_0
    //   10: getfield 222	com/whatsapp/PhoneContactsSelector:aP	Lcom/whatsapp/atu;
    //   13: astore 9
    //   15: new 288	java/util/HashMap
    //   18: dup
    //   19: invokespecial 289	java/util/HashMap:<init>	()V
    //   22: astore 8
    //   24: aload 9
    //   26: ldc -32
    //   28: invokevirtual 229	com/whatsapp/atu:a	(Ljava/lang/String;)I
    //   31: ifeq +40 -> 71
    //   34: ldc_w 291
    //   37: invokestatic 236	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   40: new 98	java/util/ArrayList
    //   43: dup
    //   44: invokespecial 99	java/util/ArrayList:<init>	()V
    //   47: astore 9
    //   49: aload_0
    //   50: getfield 131	com/whatsapp/PhoneContactsSelector:D	Lcom/whatsapp/and;
    //   53: getfield 294	com/whatsapp/and:f	Landroid/content/ContentResolver;
    //   56: astore 7
    //   58: aload 7
    //   60: ifnonnull +371 -> 431
    //   63: ldc_w 296
    //   66: invokestatic 236	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   69: aconst_null
    //   70: areturn
    //   71: aload 7
    //   73: invokevirtual 302	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   76: getstatic 308	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   79: iconst_3
    //   80: anewarray 209	java/lang/String
    //   83: dup
    //   84: iconst_0
    //   85: ldc_w 310
    //   88: aastore
    //   89: dup
    //   90: iconst_1
    //   91: ldc_w 312
    //   94: aastore
    //   95: dup
    //   96: iconst_2
    //   97: ldc_w 314
    //   100: aastore
    //   101: ldc_w 316
    //   104: iconst_1
    //   105: anewarray 209	java/lang/String
    //   108: dup
    //   109: iconst_0
    //   110: ldc_w 318
    //   113: aastore
    //   114: aconst_null
    //   115: invokevirtual 324	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   118: astore 7
    //   120: aload 7
    //   122: ifnonnull +12 -> 134
    //   125: ldc_w 326
    //   128: invokestatic 328	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   131: goto -91 -> 40
    //   134: aload 7
    //   136: ldc_w 310
    //   139: invokeinterface 333 2 0
    //   144: istore_2
    //   145: iload_2
    //   146: iconst_m1
    //   147: if_icmpne +12 -> 159
    //   150: ldc_w 335
    //   153: invokestatic 328	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   156: goto -116 -> 40
    //   159: aload 7
    //   161: ldc_w 312
    //   164: invokeinterface 333 2 0
    //   169: istore_3
    //   170: iload_3
    //   171: iconst_m1
    //   172: if_icmpne +12 -> 184
    //   175: ldc_w 337
    //   178: invokestatic 328	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   181: goto -141 -> 40
    //   184: aload 7
    //   186: ldc_w 314
    //   189: invokeinterface 333 2 0
    //   194: istore 4
    //   196: iload 4
    //   198: iconst_m1
    //   199: if_icmpne +12 -> 211
    //   202: ldc_w 339
    //   205: invokestatic 328	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   208: goto -168 -> 40
    //   211: aload 7
    //   213: invokeinterface 342 1 0
    //   218: ifeq +203 -> 421
    //   221: aload 7
    //   223: iload_2
    //   224: invokeinterface 346 2 0
    //   229: ifeq +12 -> 241
    //   232: ldc_w 348
    //   235: invokestatic 328	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   238: goto -27 -> 211
    //   241: aload 7
    //   243: iload_3
    //   244: invokeinterface 346 2 0
    //   249: ifeq +12 -> 261
    //   252: ldc_w 350
    //   255: invokestatic 328	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   258: goto -47 -> 211
    //   261: aload 7
    //   263: iload_2
    //   264: invokeinterface 354 2 0
    //   269: lstore 5
    //   271: aload 8
    //   273: lload 5
    //   275: invokestatic 359	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   278: invokeinterface 365 2 0
    //   283: checkcast 209	java/lang/String
    //   286: ifnonnull -75 -> 211
    //   289: aload 7
    //   291: iload_3
    //   292: invokeinterface 369 2 0
    //   297: astore 9
    //   299: aload 9
    //   301: ifnonnull +12 -> 313
    //   304: ldc_w 371
    //   307: invokestatic 328	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   310: goto -99 -> 211
    //   313: aload 9
    //   315: invokevirtual 374	java/lang/String:hashCode	()I
    //   318: tableswitch	default:+18->336, -1079224304:+62->380
    //   336: iconst_m1
    //   337: istore_1
    //   338: iload_1
    //   339: tableswitch	default:+17->356, 0:+57->396
    //   356: new 376	java/lang/StringBuilder
    //   359: dup
    //   360: ldc_w 378
    //   363: invokespecial 380	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   366: aload 9
    //   368: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: invokevirtual 388	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: invokestatic 328	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   377: goto -166 -> 211
    //   380: aload 9
    //   382: ldc_w 318
    //   385: invokevirtual 392	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   388: ifeq -52 -> 336
    //   391: iconst_0
    //   392: istore_1
    //   393: goto -55 -> 338
    //   396: aload 8
    //   398: lload 5
    //   400: invokestatic 359	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   403: aload 7
    //   405: iload 4
    //   407: invokeinterface 369 2 0
    //   412: invokeinterface 396 3 0
    //   417: pop
    //   418: goto -207 -> 211
    //   421: aload 7
    //   423: invokeinterface 399 1 0
    //   428: goto -388 -> 40
    //   431: getstatic 402	android/provider/ContactsContract$Contacts:CONTENT_URI	Landroid/net/Uri;
    //   434: invokevirtual 408	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   437: astore 10
    //   439: getstatic 413	android/os/Build$VERSION:SDK_INT	I
    //   442: bipush 11
    //   444: if_icmplt +15 -> 459
    //   447: aload 10
    //   449: ldc_w 415
    //   452: ldc_w 417
    //   455: invokevirtual 423	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   458: pop
    //   459: aload 7
    //   461: aload 10
    //   463: invokevirtual 427	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   466: iconst_2
    //   467: anewarray 209	java/lang/String
    //   470: dup
    //   471: iconst_0
    //   472: ldc_w 429
    //   475: aastore
    //   476: dup
    //   477: iconst_1
    //   478: ldc_w 431
    //   481: aastore
    //   482: aconst_null
    //   483: aconst_null
    //   484: aconst_null
    //   485: invokevirtual 324	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   488: astore 7
    //   490: aload 7
    //   492: ifnull +122 -> 614
    //   495: aload 7
    //   497: invokeinterface 342 1 0
    //   502: ifeq +97 -> 599
    //   505: aload 7
    //   507: iconst_0
    //   508: invokeinterface 354 2 0
    //   513: invokestatic 359	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   516: astore 10
    //   518: aload 7
    //   520: iconst_1
    //   521: invokeinterface 369 2 0
    //   526: astore 11
    //   528: aload 8
    //   530: aload 10
    //   532: invokeinterface 365 2 0
    //   537: checkcast 209	java/lang/String
    //   540: astore 12
    //   542: aload 11
    //   544: invokestatic 437	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   547: ifne -52 -> 495
    //   550: aload 9
    //   552: new 20	com/whatsapp/PhoneContactsSelector$a
    //   555: dup
    //   556: aload 11
    //   558: aload 10
    //   560: invokevirtual 441	java/lang/Long:longValue	()J
    //   563: aload 12
    //   565: invokespecial 444	com/whatsapp/PhoneContactsSelector$a:<init>	(Ljava/lang/String;JLjava/lang/String;)V
    //   568: invokevirtual 447	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   571: pop
    //   572: goto -77 -> 495
    //   575: astore 8
    //   577: ldc_w 449
    //   580: aload 8
    //   582: invokestatic 452	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   585: aload 7
    //   587: ifnull -518 -> 69
    //   590: aload 7
    //   592: invokeinterface 399 1 0
    //   597: aconst_null
    //   598: areturn
    //   599: aload 7
    //   601: ifnull +10 -> 611
    //   604: aload 7
    //   606: invokeinterface 399 1 0
    //   611: aload 9
    //   613: areturn
    //   614: ldc_w 454
    //   617: invokestatic 328	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   620: aload 7
    //   622: ifnull -553 -> 69
    //   625: aload 7
    //   627: invokeinterface 399 1 0
    //   632: aconst_null
    //   633: areturn
    //   634: astore 8
    //   636: aconst_null
    //   637: astore 7
    //   639: aload 7
    //   641: ifnull +10 -> 651
    //   644: aload 7
    //   646: invokeinterface 399 1 0
    //   651: aload 8
    //   653: athrow
    //   654: astore 8
    //   656: goto -17 -> 639
    //   659: astore 8
    //   661: goto -22 -> 639
    //   664: astore 8
    //   666: aconst_null
    //   667: astore 7
    //   669: goto -92 -> 577
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	672	0	this	PhoneContactsSelector
    //   337	56	1	i	int
    //   144	120	2	j	int
    //   169	123	3	k	int
    //   194	212	4	m	int
    //   269	130	5	l	long
    //   7	661	7	localObject1	Object
    //   22	507	8	localHashMap	java.util.HashMap
    //   575	6	8	localException1	Exception
    //   634	18	8	localObject2	Object
    //   654	1	8	localObject3	Object
    //   659	1	8	localObject4	Object
    //   664	1	8	localException2	Exception
    //   13	599	9	localObject5	Object
    //   437	122	10	localObject6	Object
    //   526	31	11	str1	String
    //   540	24	12	str2	String
    // Exception table:
    //   from	to	target	type
    //   495	572	575	java/lang/Exception
    //   614	620	575	java/lang/Exception
    //   431	459	634	finally
    //   459	490	634	finally
    //   495	572	654	finally
    //   614	620	654	finally
    //   577	585	659	finally
    //   431	459	664	java/lang/Exception
    //   459	490	664	java/lang/Exception
  }
  
  final String a(a parama)
  {
    a.d.c();
    a.a.a.a.a.a locala = new a.a.a.a.a.a(this, this.C);
    String str = Long.valueOf(parama.c).toString();
    locala.c.a = parama.a;
    locala.a(str);
    locala.b(str);
    locala.c(str);
    locala.d(str);
    locala.e(str);
    parama = locala.l.getContentResolver().query(ContactsContract.Data.CONTENT_URI, new String[] { "data15" }, "contact_id = ? AND mimetype = ? ", new String[] { str, "vnd.android.cursor.item/photo" }, null);
    if (parama != null)
    {
      if (parama.moveToFirst()) {
        locala.f = parama.getBlob(0);
      }
      parama.close();
    }
    locala.f(str);
    locala.g(str);
    locala.h(str);
    parama = new c();
    try
    {
      parama = parama.a(getApplicationContext(), locala);
      return parama;
    }
    catch (a.a.a.a.a.d parama)
    {
      Log.d("Could not create VCard", parama);
    }
    return null;
  }
  
  final void b(a parama)
  {
    Object localObject = (SelectionCheckView)this.F.findViewWithTag(parama);
    if (parama.d)
    {
      parama.d = false;
      if (!parama.d) {
        break label289;
      }
      if (this.u.add(parama))
      {
        if (this.u.size() != 1) {
          break label268;
        }
        this.v.c();
      }
      label64:
      if (localObject != null) {
        ((SelectionCheckView)localObject).a(parama.d, false);
      }
      if (!this.u.isEmpty()) {
        break label324;
      }
      this.G.setVisibility(8);
      m();
      if (!this.I)
      {
        localObject = new TranslateAnimation(0.0F, 0.0F, getResources().getDimensionPixelSize(2131362081), 0.0F);
        ((TranslateAnimation)localObject).setDuration(240L);
        this.F.startAnimation((Animation)localObject);
      }
    }
    for (;;)
    {
      d(this.u.size());
      if (parama.h == null) {
        bu.a(abj.a(this, parama));
      }
      do
      {
        return;
        if (this.u.size() != 1000) {
          break;
        }
        pv.a(getApplicationContext(), getString(2131296513, new Object[] { Integer.valueOf(1000) }), 1);
      } while (localObject == null);
      ((SelectionCheckView)localObject).a(false, false);
      return;
      EditText localEditText = (EditText)findViewById(2131755496).findViewById(2131755212);
      if (localEditText != null) {
        localEditText.setText("");
      }
      parama.d = true;
      break;
      label268:
      this.v.c(this.u.size() - 1);
      break label64;
      label289:
      int i = this.u.indexOf(parama);
      if (!this.u.remove(parama)) {
        break label64;
      }
      this.v.d(i);
      break label64;
      label324:
      if (this.G.getVisibility() != 0)
      {
        if (this.H.getVisibility() != 0)
        {
          i = getResources().getDimensionPixelSize(2131362081);
          this.G.setVisibility(0);
          localObject = new TranslateAnimation(0.0F, 0.0F, -i, 0.0F);
          ((TranslateAnimation)localObject).setDuration(240L);
          this.F.startAnimation((Animation)localObject);
        }
        else
        {
          this.H.setVisibility(8);
          this.G.setVisibility(0);
        }
      }
      else if (parama.d) {
        this.J.a(this.u.size() - 1);
      }
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
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (paramInt2 != -1);
    setResult(-1, paramIntent);
    finish();
  }
  
  public void onBackPressed()
  {
    if (this.x)
    {
      this.x = false;
      a.d.b();
      this.r.clear();
      Iterator localIterator = this.q.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        this.r.add(locala);
      }
      if (this.p != null) {
        this.p.notifyDataSetChanged();
      }
      this.z.b();
      return;
    }
    super.onBackPressed();
  }
  
  @SuppressLint({"InflateParams"})
  public void onCreate(Bundle paramBundle)
  {
    Log.i("phonecontactsselector/create");
    super.onCreate(paramBundle);
    setContentView(getLayoutInflater().inflate(2130903304, null, false));
    ((View)a.d.a(findViewById(2131755510))).setVisibility(0);
    Object localObject = (Toolbar)findViewById(2131755412);
    a((Toolbar)localObject);
    android.support.v7.app.a locala = (android.support.v7.app.a)a.d.a(i());
    locala.a(true);
    locala.c();
    this.z = new ahp(this, this.aq, findViewById(2131755496), (Toolbar)localObject, new SearchView.b()
    {
      public final boolean a(String paramAnonymousString)
      {
        return false;
      }
      
      public final boolean b(String paramAnonymousString)
      {
        PhoneContactsSelector.a(PhoneContactsSelector.this, paramAnonymousString);
        PhoneContactsSelector.a(PhoneContactsSelector.this, be.c(paramAnonymousString));
        if (PhoneContactsSelector.a(PhoneContactsSelector.this).isEmpty()) {
          PhoneContactsSelector.a(PhoneContactsSelector.this, null);
        }
        PhoneContactsSelector.b(PhoneContactsSelector.this);
        return false;
      }
    });
    setTitle(2131296553);
    this.K = getIntent().getStringExtra("jid");
    this.L = getIntent().getLongExtra("quoted_message_row_id", 0L);
    this.F = W();
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.F.setFastScrollAlwaysVisible(true);
      this.F.setScrollBarStyle(33554432);
    }
    this.w = ((InputMethodManager)getSystemService("input_method"));
    if (this.B != null) {
      this.B.cancel(true);
    }
    if (this.A != null)
    {
      this.A.cancel(true);
      this.A = null;
    }
    this.B = new d((byte)0);
    bu.a(this.B, new Void[0]);
    this.u.clear();
    this.J = ((RecyclerView)findViewById(2131755964));
    final int i = getResources().getDimensionPixelSize(2131362083);
    if ((!o) && (this.J == null)) {
      throw new AssertionError();
    }
    this.J.a(new RecyclerView.f()
    {
      public final void a(Rect paramAnonymousRect, View paramAnonymousView, RecyclerView paramAnonymousRecyclerView)
      {
        paramAnonymousRect.set(0, i, 0, i);
      }
    });
    localObject = new LinearLayoutManager(this);
    ((LinearLayoutManager)localObject).b(0);
    this.J.setLayoutManager((RecyclerView.g)localObject);
    this.J.setAdapter(this.v);
    this.J.setItemAnimator(new ahs());
    this.F.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      int a = 0;
      
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        if ((this.a == 0) && (paramAnonymousInt != this.a)) {
          PhoneContactsSelector.c(PhoneContactsSelector.this).hideSoftInputFromWindow(paramAnonymousAbsListView.getWindowToken(), 0);
        }
        this.a = paramAnonymousInt;
      }
    });
    if (this.aP.d())
    {
      localObject = findViewById(2131755509);
      if ((!o) && (localObject == null)) {
        throw new AssertionError();
      }
      ((View)localObject).setVisibility(0);
      this.F.setEmptyView((View)localObject);
      this.F.setFastScrollEnabled(true);
      this.F.setScrollbarFadingEnabled(true);
      if (Build.VERSION.SDK_INT < 11) {
        break label666;
      }
      if (!this.aq.a) {
        break label626;
      }
      this.F.setVerticalScrollbarPosition(1);
      this.F.setPadding(getResources().getDimensionPixelSize(2131361817), 0, getResources().getDimensionPixelSize(2131361816), 0);
    }
    for (;;)
    {
      this.F.setOnItemClickListener(abh.a(this));
      d(this.u.size());
      this.G = findViewById(2131755831);
      if ((o) || (this.G != null)) {
        break label679;
      }
      throw new AssertionError();
      localObject = findViewById(2131755393);
      if ((!o) && (localObject == null)) {
        throw new AssertionError();
      }
      ((View)localObject).setVisibility(0);
      this.F.setEmptyView((View)localObject);
      break;
      label626:
      this.F.setVerticalScrollbarPosition(2);
      this.F.setPadding(getResources().getDimensionPixelSize(2131361816), 0, getResources().getDimensionPixelSize(2131361817), 0);
      continue;
      label666:
      this.F.setSelector(2130840501);
    }
    label679:
    if (this.u.isEmpty()) {
      this.G.setVisibility(8);
    }
    this.H = findViewById(2131755962);
    if ((!o) && (this.H == null)) {
      throw new AssertionError();
    }
    localObject = (TextView)findViewById(2131755963);
    if ((!o) && (localObject == null)) {
      throw new AssertionError();
    }
    ((TextView)localObject).setText("");
    if (!TextUtils.isEmpty(((TextView)localObject).getText())) {}
    for (boolean bool = true;; bool = false)
    {
      this.I = bool;
      m();
      this.p = new b(this, this.r);
      a(this.p);
      localObject = (ImageView)a.d.a(findViewById(2131755357));
      ((ImageView)localObject).setImageDrawable(getResources().getDrawable(2130840163));
      ((ImageView)localObject).setContentDescription(getResources().getString(2131297280));
      ((ImageView)localObject).setOnClickListener(new at()
      {
        public final void a(View paramAnonymousView)
        {
          if (PhoneContactsSelector.d(PhoneContactsSelector.this).size() < PhoneContactsSelector.l())
          {
            pv.a(PhoneContactsSelector.this.getBaseContext(), String.format(u.a.a(2131230770, PhoneContactsSelector.l()), new Object[] { Integer.valueOf(PhoneContactsSelector.l()) }), 0);
            return;
          }
          PhoneContactsSelector.e(PhoneContactsSelector.this);
        }
      });
      localObject = findViewById(2131755770);
      if ((o) || (localObject != null)) {
        break;
      }
      throw new AssertionError();
    }
    ((View)localObject).setOnClickListener(abi.a(this));
    localObject = findViewById(2131755769);
    if ((!o) && (localObject == null)) {
      throw new AssertionError();
    }
    ((View)localObject).setOnClickListener(new at()
    {
      public final void a(View paramAnonymousView)
      {
        a.a.a.a.d.d(PhoneContactsSelector.this);
      }
    });
    registerForContextMenu(this.F);
    if ((paramBundle == null) && (!this.aP.d())) {
      RequestPermissionActivity.a(this, 2131297376, 2131297375);
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    boolean bool = false;
    this.y = paramMenu.add(0, 2131755072, 0, 2131297631).setIcon(2130840073);
    o.a(this.y, 10);
    o.a(this.y, new o.e()
    {
      public final boolean a(MenuItem paramAnonymousMenuItem)
      {
        return true;
      }
      
      public final boolean b(MenuItem paramAnonymousMenuItem)
      {
        PhoneContactsSelector.a(PhoneContactsSelector.this, null);
        PhoneContactsSelector.b(PhoneContactsSelector.this);
        return true;
      }
    });
    MenuItem localMenuItem = this.y;
    if (!this.q.isEmpty()) {
      bool = true;
    }
    localMenuItem.setVisible(bool);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public void onDestroy()
  {
    Log.i("phonecontactsselector/destroy");
    super.onDestroy();
    this.q.clear();
    this.r.clear();
    this.E.a();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return true;
    case 2131755072: 
      onSearchRequested();
      return true;
    }
    finish();
    return true;
  }
  
  public boolean onSearchRequested()
  {
    this.z.a();
    this.x = true;
    return false;
  }
  
  public static final class a
  {
    String a;
    String b = null;
    long c;
    boolean d = false;
    Bitmap e = null;
    boolean f = false;
    public cs g = null;
    String h = null;
    
    a()
    {
      this.f = true;
    }
    
    public a(String paramString1, long paramLong, String paramString2)
    {
      this.a = paramString1;
      this.c = paramLong;
      this.b = paramString2;
    }
  }
  
  final class b
    extends ArrayAdapter<PhoneContactsSelector.a>
  {
    public b(int paramInt)
    {
      super(2130903332, localList);
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      PhoneContactsSelector.a locala = (PhoneContactsSelector.a)a.d.a(getItem(paramInt));
      if (PhoneContactsSelector.c(locala))
      {
        paramView = al.a(PhoneContactsSelector.this.aq, PhoneContactsSelector.this.getLayoutInflater(), 2130903306, paramViewGroup, false);
        ((TextView)paramView.findViewById(2131755969)).setText(locala.a);
        paramView.setTag(Integer.valueOf(2));
        return paramView;
      }
      View localView;
      if (paramView != null)
      {
        localView = paramView;
        if (((Integer)paramView.getTag()).intValue() == 1) {}
      }
      else
      {
        localView = al.a(PhoneContactsSelector.this.aq, PhoneContactsSelector.this.getLayoutInflater(), 2130903332, paramViewGroup, false);
      }
      localView.setTag(Integer.valueOf(1));
      paramView = (ImageView)localView.findViewById(2131755511);
      paramView.setImageBitmap(cs.b(2130837625));
      PhoneContactsSelector.h(PhoneContactsSelector.this).a(locala, paramView);
      paramView = (TextEmojiLabel)localView.findViewById(2131755507);
      aoa.b(paramView);
      paramView.a(locala.a, PhoneContactsSelector.a(PhoneContactsSelector.this));
      ab.c(paramView, 2);
      paramView = (SelectionCheckView)localView.findViewById(2131755512);
      paramView.a(locala.d, false);
      paramView.setTag(locala);
      return localView;
    }
  }
  
  final class c
    extends AsyncTask<Void, Void, List<PhoneContactsSelector.a>>
  {
    private final ArrayList<String> b;
    private final List<PhoneContactsSelector.a> c;
    
    c(List<PhoneContactsSelector.a> paramList)
    {
      if (paramList != null) {}
      for (this$1 = new ArrayList(paramList);; this$1 = null)
      {
        this.b = PhoneContactsSelector.this;
        Collection localCollection;
        this.c = new ArrayList(localCollection);
        return;
      }
    }
  }
  
  final class d
    extends AsyncTask<Void, List<PhoneContactsSelector.a>, List<PhoneContactsSelector.a>>
  {
    com.whatsapp.k.d a;
    
    private d() {}
  }
  
  final class e
    implements Comparator<PhoneContactsSelector.a>
  {
    private final Collator b = Collator.getInstance();
    
    e()
    {
      this.b.setStrength(0);
      this.b.setDecomposition(1);
    }
  }
  
  final class f
    extends RecyclerView.a<ahr>
  {
    private f() {}
    
    public final int a()
    {
      return PhoneContactsSelector.d(PhoneContactsSelector.this).size();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/PhoneContactsSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */