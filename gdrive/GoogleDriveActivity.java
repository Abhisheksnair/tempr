package com.whatsapp.gdrive;

import a.a.a.a.a.a.d;
import a.a.a.a.d;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.IBinder;
import android.os.Looper;
import android.support.v4.view.ae;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.whatsapp.Main;
import com.whatsapp.RequestPermissionActivity;
import com.whatsapp.SettingsChat;
import com.whatsapp.apf;
import com.whatsapp.atu;
import com.whatsapp.atv;
import com.whatsapp.av;
import com.whatsapp.data.ad;
import com.whatsapp.data.cb;
import com.whatsapp.data.ch.a;
import com.whatsapp.data.n;
import com.whatsapp.i.b;
import com.whatsapp.pv;
import com.whatsapp.registration.RegisterPhone;
import com.whatsapp.registration.au;
import com.whatsapp.registration.aw;
import com.whatsapp.registration.bk;
import com.whatsapp.util.Log;
import com.whatsapp.util.bd;
import com.whatsapp.util.bu;
import com.whatsapp.util.z;
import com.whatsapp.vv;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public final class GoogleDriveActivity
  extends apf
  implements co.b, es.a
{
  boolean N;
  au O = new au(this.ad, this.aE, this.aM, this.aP, this.H);
  final ev P = new ev()
  {
    public final boolean a()
    {
      if (GoogleDriveActivity.d(GoogleDriveActivity.this).get())
      {
        Log.i("gdrive-activity/one-time-setup-task/cancelled");
        return false;
      }
      return GoogleDriveService.o.a();
    }
    
    public final String toString()
    {
      return "one-time-setup-condition";
    }
  };
  private final z<String, bb> Q = new z(100);
  private final List<Account> R = new ArrayList();
  private final Set<Account> S = new HashSet();
  private final ConditionVariable T = new ConditionVariable(false);
  private final AtomicBoolean U = new AtomicBoolean(false);
  private TextView V;
  private long W;
  private int X;
  private String Y;
  private a Z;
  private ch.a aa;
  private int ab = 21;
  private boolean ac = true;
  private final b ad = b.a();
  private final bk ae = bk.a();
  private final ServiceConnection af = new ServiceConnection()
  {
    public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
    {
      GoogleDriveActivity.a(GoogleDriveActivity.this, ((GoogleDriveService.f)paramAnonymousIBinder).a);
      GoogleDriveActivity.a(GoogleDriveActivity.this).open();
      GoogleDriveActivity.c(GoogleDriveActivity.this).a(GoogleDriveActivity.b(GoogleDriveActivity.this));
    }
    
    public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
    {
      GoogleDriveActivity.c(GoogleDriveActivity.this).b(GoogleDriveActivity.b(GoogleDriveActivity.this));
      GoogleDriveActivity.a(GoogleDriveActivity.this, null);
      GoogleDriveActivity.a(GoogleDriveActivity.this).close();
    }
  };
  private final GoogleDriveService.e ag = new GoogleDriveService.c()
  {
    private int b = -1;
    
    public final void b(int paramAnonymousInt, Bundle paramAnonymousBundle)
    {
      Log.i("gdrive-activity-observer/msgstore-download-error/" + ch.a(paramAnonymousInt));
      GoogleDriveActivity.this.runOnUiThread(ao.a(this, paramAnonymousInt, paramAnonymousBundle));
    }
    
    public final void b(boolean paramAnonymousBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder("gdrive-activity-observer/msgstore-download-finished/");
      if (paramAnonymousBoolean) {}
      int i;
      for (String str = "successful";; str = "failed")
      {
        Log.i(str);
        i = GoogleDriveActivity.e(GoogleDriveActivity.this).Q();
        if (i != 10) {
          break;
        }
        GoogleDriveActivity.this.runOnUiThread(ar.a(this, paramAnonymousBoolean));
        return;
      }
      Log.i("gdrive-activity-observer/msgstore-download-finished/get-error/" + ch.a(i));
    }
    
    public final void c()
    {
      GoogleDriveActivity.this.runOnUiThread(ap.a(this));
    }
    
    public final void f(long paramAnonymousLong1, long paramAnonymousLong2)
    {
      int i = (int)(100L * paramAnonymousLong1 / paramAnonymousLong2);
      if (i - this.b > 0)
      {
        this.b = i;
        if (i % 10 == 0) {
          Log.i("gdrive-activity-observer/msgstore-download-progress:" + paramAnonymousLong1 + "/" + paramAnonymousLong2 + " " + i + "%");
        }
        GoogleDriveActivity.this.runOnUiThread(aq.a(this, i, paramAnonymousLong1, paramAnonymousLong2));
      }
    }
  };
  final ConditionVariable n = new ConditionVariable(false);
  final ConditionVariable o = new ConditionVariable(false);
  final AtomicBoolean p = new AtomicBoolean(false);
  ProgressBar q;
  TextView r;
  GoogleDriveRestoreAnimationView s;
  GoogleDriveService t;
  long u;
  boolean v;
  
  private void A()
  {
    a.d.b();
    ((View)a.d.a(findViewById(2131755279))).setVisibility(0);
    ((View)a.d.a(findViewById(2131755270))).setVisibility(0);
    ((View)a.d.a(findViewById(2131755282))).setVisibility(0);
    ((View)a.d.a(findViewById(2131755266))).setVisibility(0);
    ((View)a.d.a(findViewById(2131755273))).setVisibility(8);
    ((View)a.d.a(findViewById(2131755274))).setVisibility(8);
    ((View)a.d.a(findViewById(2131755275))).setVisibility(8);
    ((View)a.d.a(findViewById(2131755267))).setVisibility(8);
    ((View)a.d.a(findViewById(2131755278))).setVisibility(8);
    ((View)a.d.a(findViewById(2131755277))).setVisibility(8);
    ((View)a.d.a(findViewById(2131755276))).setVisibility(8);
    File localFile = com.whatsapp.u.a().getDatabasePath(cb.a());
    if (localFile.exists())
    {
      if (localFile.delete()) {
        break label254;
      }
      Log.w("gdrive-activity/show-msgstore-downloading-view/restore-failed " + localFile + " exists but cannot be deleted, message restore might fail");
    }
    for (;;)
    {
      if (this.y != null) {
        this.y.e();
      }
      d(false);
      return;
      label254:
      Log.i("gdrive-activity/show-msgstore-downloading-view/restore-failed " + localFile + " deleted");
    }
  }
  
  private void B()
  {
    Object localObject = AccountManager.get(this).getAccountsByType("com.google");
    String[] arrayOfString1 = new String[localObject.length + 1];
    int i = 0;
    while (i < localObject.length)
    {
      arrayOfString1[i] = localObject[i].name;
      i += 1;
    }
    arrayOfString1[(arrayOfString1.length - 1)] = getString(2131296918);
    String[] arrayOfString2 = new String[localObject.length + 1];
    boolean[] arrayOfBoolean = new boolean[localObject.length + 1];
    this.R.clear();
    i = 0;
    if (i < localObject.length)
    {
      this.R.add(localObject[i]);
      if (this.S.contains(localObject[i]))
      {
        arrayOfString2[i] = getString(2131296936);
        arrayOfBoolean[i] = false;
      }
      for (;;)
      {
        i += 1;
        break;
        arrayOfString2[i] = null;
        arrayOfBoolean[i] = true;
      }
    }
    arrayOfBoolean[(arrayOfBoolean.length - 1)] = true;
    localObject = new es();
    Bundle localBundle = new Bundle();
    localBundle.putInt("dialog_id", 17);
    localBundle.putString("title", getString(2131296919));
    localBundle.putStringArray("multi_line_list_items_key", arrayOfString1);
    localBundle.putStringArray("multi_line_list_item_values_key", arrayOfString2);
    localBundle.putBooleanArray("list_item_enabled_key", arrayOfBoolean);
    localBundle.putString("disabled_item_toast_key", getString(2131296904));
    ((android.support.v4.app.m)localObject).f(localBundle);
    if (!ch.a(this)) {
      ((android.support.v4.app.m)localObject).a(j_(), null);
    }
  }
  
  private Pair<bb, bb> a(at paramat)
  {
    if (!GoogleDriveService.a(paramat, this.P, 5)) {
      throw new ax(null);
    }
    Object localObject1 = GoogleDriveService.a(this.H);
    Object localObject2 = new ArrayList();
    Object localObject3 = this.y.c.c();
    int j = localObject3.length;
    int i = 0;
    Object localObject4;
    while (i < j)
    {
      localObject4 = localObject3[i];
      ((List)localObject2).add(ch.a(this.ax, (File)localObject4));
      i += 1;
    }
    if (localObject1 == null)
    {
      Log.e("gdrive-activity/get-best-base-folder/primary-base-folder-name-is-null");
      return Pair.create(null, null);
    }
    localObject3 = new ArrayList(Arrays.asList(new String[] { localObject1, "gdrive_file_map" }));
    ((List)localObject3).addAll((Collection)localObject2);
    List localList = paramat.a((List)localObject3, "appDataFolder", GoogleDriveService.o);
    if (localList == null)
    {
      Log.e("gdrive-activity/get-best-base-folder/unable-to-get-file-list (probably a network error?)");
      return Pair.create(null, null);
    }
    paramat = new ArrayList();
    localObject3 = localList.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (bb)((Iterator)localObject3).next();
      if (((String)localObject1).equals(((bb)localObject4).d)) {
        paramat.add(localObject4);
      }
      if ((((List)localObject2).contains(((bb)localObject4).d)) || ("gdrive_file_map".equals(((bb)localObject4).d))) {
        this.Q.put(((bb)localObject4).c, localObject4);
      }
    }
    if (paramat.size() == 0) {
      return Pair.create(null, null);
    }
    Iterator localIterator = paramat.iterator();
    localObject2 = null;
    localObject1 = null;
    bb localbb;
    if (localIterator.hasNext())
    {
      localbb = (bb)localIterator.next();
      paramat = localbb.b("gdrive_file_map_id");
      if (this.Q.containsKey(paramat)) {
        paramat = (bb)this.Q.get(paramat);
      }
    }
    for (;;)
    {
      if (paramat == null)
      {
        Log.e("gdrive-activity/get-best-base-folder/failed-to-get-gdrive-file-map base folder:" + localbb);
        break;
        if (paramat != null) {
          Log.e("gdrive-activity/get-best-base-folder/property-found-but-file-not-found " + paramat);
        }
        localObject3 = localList.iterator();
        do
        {
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          paramat = (bb)((Iterator)localObject3).next();
        } while ((!"gdrive_file_map".equals(paramat.d)) || (!paramat.a(localbb.c)));
        continue;
      }
      Log.i("gdrive-activity/get-best-base-folder " + localbb + " has gdrive_file_map");
      localObject3 = localbb;
      localObject4 = paramat;
      if (localObject1 != null)
      {
        if (paramat.e <= ((bb)localObject1).e) {
          break label588;
        }
        localObject4 = paramat;
        localObject3 = localbb;
      }
      for (;;)
      {
        localObject2 = localObject3;
        localObject1 = localObject4;
        break;
        Log.i("gdrive-activity/get-best-base-folder final baseFolder is " + localObject2 + " with gdriveFileMap " + localObject1);
        return Pair.create(localObject2, localObject1);
        label588:
        localObject3 = localObject2;
        localObject4 = localObject1;
      }
      paramat = null;
    }
  }
  
  /* Error */
  private a a(String paramString, bb parambb1, at paramat, bb parambb2)
  {
    // Byte code:
    //   0: invokestatic 502	a/a/a/a/a/a$d:c	()V
    //   3: aload_3
    //   4: aload_2
    //   5: getstatic 418	com/whatsapp/gdrive/GoogleDriveService:o	Lcom/whatsapp/gdrive/ev;
    //   8: invokestatic 505	com/whatsapp/gdrive/GoogleDriveService:a	(Lcom/whatsapp/gdrive/at;Lcom/whatsapp/gdrive/bb;Lcom/whatsapp/gdrive/ev;)Lcom/whatsapp/gdrive/bb;
    //   11: astore 15
    //   13: aload_0
    //   14: getfield 508	com/whatsapp/gdrive/GoogleDriveActivity:w	Lcom/whatsapp/util/a/c;
    //   17: astore 17
    //   19: aload_0
    //   20: getfield 512	com/whatsapp/gdrive/GoogleDriveActivity:au	Lcom/whatsapp/oz;
    //   23: astore 18
    //   25: aload_0
    //   26: getfield 386	com/whatsapp/gdrive/GoogleDriveActivity:ax	Lcom/whatsapp/ox;
    //   29: astore 19
    //   31: aload_0
    //   32: getfield 253	com/whatsapp/gdrive/GoogleDriveActivity:y	Lcom/whatsapp/data/ad;
    //   35: astore 20
    //   37: aload_0
    //   38: getfield 150	com/whatsapp/gdrive/GoogleDriveActivity:aP	Lcom/whatsapp/atu;
    //   41: astore 21
    //   43: aload_0
    //   44: getfield 154	com/whatsapp/gdrive/GoogleDriveActivity:H	Lcom/whatsapp/atv;
    //   47: astore 22
    //   49: aload_2
    //   50: getfield 448	com/whatsapp/gdrive/bb:c	Ljava/lang/String;
    //   53: astore 23
    //   55: aload 15
    //   57: ifnull +171 -> 228
    //   60: aload 15
    //   62: getfield 448	com/whatsapp/gdrive/bb:c	Ljava/lang/String;
    //   65: astore 16
    //   67: new 514	com/whatsapp/gdrive/bc
    //   70: dup
    //   71: aload 17
    //   73: aload 18
    //   75: aload 19
    //   77: aload 20
    //   79: aload 21
    //   81: aload 22
    //   83: aload_3
    //   84: aload 23
    //   86: aload 16
    //   88: aload 4
    //   90: invokespecial 517	com/whatsapp/gdrive/bc:<init>	(Lcom/whatsapp/util/a/c;Lcom/whatsapp/oz;Lcom/whatsapp/ox;Lcom/whatsapp/data/ad;Lcom/whatsapp/atu;Lcom/whatsapp/atv;Lcom/whatsapp/gdrive/at;Ljava/lang/String;Ljava/lang/String;Lcom/whatsapp/gdrive/bb;)V
    //   93: astore 16
    //   95: aload 16
    //   97: iconst_0
    //   98: aload_0
    //   99: getfield 167	com/whatsapp/gdrive/GoogleDriveActivity:P	Lcom/whatsapp/gdrive/ev;
    //   102: invokevirtual 520	com/whatsapp/gdrive/bc:a	(ZLcom/whatsapp/gdrive/ev;)Z
    //   105: pop
    //   106: new 522	com/whatsapp/util/bd
    //   109: dup
    //   110: ldc_w 524
    //   113: invokespecial 525	com/whatsapp/util/bd:<init>	(Ljava/lang/String;)V
    //   116: astore 17
    //   118: aload_0
    //   119: getfield 253	com/whatsapp/gdrive/GoogleDriveActivity:y	Lcom/whatsapp/data/ad;
    //   122: getfield 379	com/whatsapp/data/ad:c	Lcom/whatsapp/data/cb;
    //   125: invokevirtual 382	com/whatsapp/data/cb:c	()[Ljava/io/File;
    //   128: astore 18
    //   130: aload 18
    //   132: arraylength
    //   133: istore 6
    //   135: iconst_0
    //   136: istore 5
    //   138: iload 5
    //   140: iload 6
    //   142: if_icmpge +285 -> 427
    //   145: aload 18
    //   147: iload 5
    //   149: aaload
    //   150: astore 4
    //   152: aload_0
    //   153: getfield 386	com/whatsapp/gdrive/GoogleDriveActivity:ax	Lcom/whatsapp/ox;
    //   156: aload 4
    //   158: invokestatic 389	com/whatsapp/gdrive/ch:a	(Lcom/whatsapp/ox;Ljava/io/File;)Ljava/lang/String;
    //   161: astore 19
    //   163: aload 19
    //   165: ifnonnull +82 -> 247
    //   168: new 527	java/lang/IllegalStateException
    //   171: dup
    //   172: new 227	java/lang/StringBuilder
    //   175: dup
    //   176: ldc_w 529
    //   179: invokespecial 232	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   182: aload 4
    //   184: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokespecial 530	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   193: athrow
    //   194: astore_1
    //   195: ldc_w 532
    //   198: aload_1
    //   199: invokestatic 535	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   202: aload_0
    //   203: invokespecial 538	com/whatsapp/gdrive/GoogleDriveActivity:z	()V
    //   206: aload_0
    //   207: invokevirtual 541	com/whatsapp/gdrive/GoogleDriveActivity:finish	()V
    //   210: aconst_null
    //   211: areturn
    //   212: astore 15
    //   214: ldc_w 543
    //   217: aload 15
    //   219: invokestatic 535	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   222: aconst_null
    //   223: astore 15
    //   225: goto -212 -> 13
    //   228: aconst_null
    //   229: astore 16
    //   231: goto -164 -> 67
    //   234: astore 4
    //   236: ldc_w 524
    //   239: aload 4
    //   241: invokestatic 535	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   244: goto -138 -> 106
    //   247: aload 16
    //   249: aload 19
    //   251: invokevirtual 546	com/whatsapp/gdrive/bc:a	(Ljava/lang/String;)Lcom/whatsapp/gdrive/bb;
    //   254: astore 4
    //   256: aload 4
    //   258: ifnull +160 -> 418
    //   261: aload_0
    //   262: aload_3
    //   263: aload 4
    //   265: invokespecial 549	com/whatsapp/gdrive/GoogleDriveActivity:a	(Lcom/whatsapp/gdrive/at;Lcom/whatsapp/gdrive/bb;)Z
    //   268: istore 8
    //   270: aload 17
    //   272: invokevirtual 552	com/whatsapp/util/bd:b	()J
    //   275: pop2
    //   276: new 554	java/util/concurrent/ArrayBlockingQueue
    //   279: dup
    //   280: iconst_1
    //   281: invokespecial 555	java/util/concurrent/ArrayBlockingQueue:<init>	(I)V
    //   284: astore 4
    //   286: aload_0
    //   287: aload 16
    //   289: iload 8
    //   291: aload 4
    //   293: invokestatic 560	com/whatsapp/gdrive/l:a	(Lcom/whatsapp/gdrive/GoogleDriveActivity;Lcom/whatsapp/gdrive/bc;ZLjava/util/concurrent/BlockingQueue;)Ljava/lang/Runnable;
    //   296: invokestatic 565	com/whatsapp/util/bu:a	(Ljava/lang/Runnable;)V
    //   299: aload 4
    //   301: invokeinterface 570 1 0
    //   306: checkcast 572	java/lang/Boolean
    //   309: astore 4
    //   311: aload 4
    //   313: ifnull +120 -> 433
    //   316: aload 4
    //   318: invokevirtual 575	java/lang/Boolean:booleanValue	()Z
    //   321: istore 7
    //   323: iload 7
    //   325: ifeq +108 -> 433
    //   328: iconst_1
    //   329: istore 7
    //   331: ldc2_w 576
    //   334: lstore 9
    //   336: aload 16
    //   338: getfield 580	com/whatsapp/gdrive/bc:b	Lcom/whatsapp/gdrive/bb;
    //   341: ifnull +13 -> 354
    //   344: aload 16
    //   346: getfield 580	com/whatsapp/gdrive/bc:b	Lcom/whatsapp/gdrive/bb;
    //   349: getfield 479	com/whatsapp/gdrive/bb:e	J
    //   352: lstore 9
    //   354: aload 16
    //   356: invokevirtual 581	com/whatsapp/gdrive/bc:b	()J
    //   359: lstore 13
    //   361: lload 13
    //   363: lstore 11
    //   365: iload 8
    //   367: ifne +27 -> 394
    //   370: lload 13
    //   372: aload_0
    //   373: getfield 253	com/whatsapp/gdrive/GoogleDriveActivity:y	Lcom/whatsapp/data/ad;
    //   376: getfield 379	com/whatsapp/data/ad:c	Lcom/whatsapp/data/cb;
    //   379: invokevirtual 584	com/whatsapp/data/cb:b	()Ljava/io/File;
    //   382: invokevirtual 587	java/io/File:length	()J
    //   385: aload 16
    //   387: invokevirtual 589	com/whatsapp/gdrive/bc:c	()J
    //   390: lsub
    //   391: ladd
    //   392: lstore 11
    //   394: new 26	com/whatsapp/gdrive/GoogleDriveActivity$a
    //   397: dup
    //   398: aload_1
    //   399: aload_2
    //   400: aload 15
    //   402: aload 16
    //   404: aload_3
    //   405: lload 9
    //   407: lload 11
    //   409: iload 8
    //   411: iload 7
    //   413: iconst_0
    //   414: invokespecial 592	com/whatsapp/gdrive/GoogleDriveActivity$a:<init>	(Ljava/lang/String;Lcom/whatsapp/gdrive/bb;Lcom/whatsapp/gdrive/bb;Lcom/whatsapp/gdrive/bc;Lcom/whatsapp/gdrive/at;JJZZB)V
    //   417: areturn
    //   418: iload 5
    //   420: iconst_1
    //   421: iadd
    //   422: istore 5
    //   424: goto -286 -> 138
    //   427: aconst_null
    //   428: astore 4
    //   430: goto -169 -> 261
    //   433: iconst_0
    //   434: istore 7
    //   436: goto -105 -> 331
    //   439: astore 4
    //   441: aload 4
    //   443: invokestatic 594	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   446: iconst_0
    //   447: istore 7
    //   449: goto -118 -> 331
    //   452: astore 15
    //   454: goto -240 -> 214
    //   457: astore 15
    //   459: goto -245 -> 214
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	462	0	this	GoogleDriveActivity
    //   0	462	1	paramString	String
    //   0	462	2	parambb1	bb
    //   0	462	3	paramat	at
    //   0	462	4	parambb2	bb
    //   136	287	5	i	int
    //   133	10	6	j	int
    //   321	127	7	bool1	boolean
    //   268	142	8	bool2	boolean
    //   334	72	9	l1	long
    //   363	45	11	l2	long
    //   359	12	13	l3	long
    //   11	50	15	localbb1	bb
    //   212	6	15	localax	ax
    //   223	178	15	localbb2	bb
    //   452	1	15	localbl	bl
    //   457	1	15	localf	f
    //   65	338	16	localObject1	Object
    //   17	254	17	localObject2	Object
    //   23	123	18	localObject3	Object
    //   29	221	19	localObject4	Object
    //   35	43	20	localad	ad
    //   41	39	21	localatu	atu
    //   47	35	22	localatv	atv
    //   53	32	23	str	String
    // Exception table:
    //   from	to	target	type
    //   118	135	194	com/whatsapp/gdrive/a
    //   152	163	194	com/whatsapp/gdrive/a
    //   168	194	194	com/whatsapp/gdrive/a
    //   247	256	194	com/whatsapp/gdrive/a
    //   261	270	194	com/whatsapp/gdrive/a
    //   3	13	212	com/whatsapp/gdrive/ax
    //   95	106	234	com/whatsapp/gdrive/ba
    //   299	311	439	java/lang/InterruptedException
    //   316	323	439	java/lang/InterruptedException
    //   3	13	452	com/whatsapp/gdrive/bl
    //   3	13	457	com/whatsapp/gdrive/f
  }
  
  /* Error */
  private a a(Account[] paramArrayOfAccount)
  {
    // Byte code:
    //   0: invokestatic 502	a/a/a/a/a/a$d:c	()V
    //   3: aload_0
    //   4: invokestatic 597	com/whatsapp/gdrive/ch:a	(Landroid/content/Context;)I
    //   7: ifeq +11 -> 18
    //   10: ldc_w 599
    //   13: invokestatic 266	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   16: aconst_null
    //   17: areturn
    //   18: ldc2_w 576
    //   21: lstore 4
    //   23: aconst_null
    //   24: astore 12
    //   26: aconst_null
    //   27: astore 11
    //   29: aconst_null
    //   30: astore 10
    //   32: aconst_null
    //   33: astore 9
    //   35: aload_0
    //   36: getfield 154	com/whatsapp/gdrive/GoogleDriveActivity:H	Lcom/whatsapp/atv;
    //   39: invokestatic 602	com/whatsapp/gdrive/GoogleDriveService:i	(Lcom/whatsapp/atv;)V
    //   42: aload_1
    //   43: arraylength
    //   44: istore_3
    //   45: iconst_0
    //   46: istore_2
    //   47: iload_2
    //   48: iload_3
    //   49: if_icmpge +461 -> 510
    //   52: aload_1
    //   53: iload_2
    //   54: aaload
    //   55: astore 17
    //   57: aload_0
    //   58: getfield 118	com/whatsapp/gdrive/GoogleDriveActivity:U	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   61: invokevirtual 604	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   64: ifeq +14 -> 78
    //   67: ldc_w 606
    //   70: invokestatic 266	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   73: invokestatic 608	com/whatsapp/gdrive/GoogleDriveService:f	()V
    //   76: aconst_null
    //   77: areturn
    //   78: aload_0
    //   79: getfield 100	com/whatsapp/gdrive/GoogleDriveActivity:S	Ljava/util/Set;
    //   82: aload 17
    //   84: invokeinterface 305 2 0
    //   89: ifeq +53 -> 142
    //   92: new 227	java/lang/StringBuilder
    //   95: dup
    //   96: ldc_w 610
    //   99: invokespecial 232	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   102: aload 17
    //   104: getfield 286	android/accounts/Account:name	Ljava/lang/String;
    //   107: invokestatic 612	com/whatsapp/gdrive/ch:a	(Ljava/lang/String;)Ljava/lang/String;
    //   110: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 266	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   119: aload 9
    //   121: astore 8
    //   123: aload 10
    //   125: astore 14
    //   127: aload 11
    //   129: astore 15
    //   131: aload 12
    //   133: astore 16
    //   135: lload 4
    //   137: lstore 6
    //   139: goto +525 -> 664
    //   142: new 420	com/whatsapp/gdrive/at
    //   145: dup
    //   146: aload_0
    //   147: invokevirtual 615	com/whatsapp/gdrive/GoogleDriveActivity:getApplicationContext	()Landroid/content/Context;
    //   150: aload_0
    //   151: getfield 508	com/whatsapp/gdrive/GoogleDriveActivity:w	Lcom/whatsapp/util/a/c;
    //   154: aload_0
    //   155: getfield 386	com/whatsapp/gdrive/GoogleDriveActivity:ax	Lcom/whatsapp/ox;
    //   158: aload_0
    //   159: getfield 150	com/whatsapp/gdrive/GoogleDriveActivity:aP	Lcom/whatsapp/atu;
    //   162: aload 17
    //   164: getfield 286	android/accounts/Account:name	Ljava/lang/String;
    //   167: getstatic 620	com/whatsapp/gdrive/at$d:b	Lcom/whatsapp/gdrive/at$d;
    //   170: invokespecial 623	com/whatsapp/gdrive/at:<init>	(Landroid/content/Context;Lcom/whatsapp/util/a/c;Lcom/whatsapp/ox;Lcom/whatsapp/atu;Ljava/lang/String;Lcom/whatsapp/gdrive/at$d;)V
    //   173: astore 14
    //   175: aload 17
    //   177: getfield 286	android/accounts/Account:name	Ljava/lang/String;
    //   180: astore 13
    //   182: new 227	java/lang/StringBuilder
    //   185: dup
    //   186: ldc_w 625
    //   189: invokespecial 232	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   192: aload 13
    //   194: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokestatic 627	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   203: aload_0
    //   204: aload 14
    //   206: invokespecial 629	com/whatsapp/gdrive/GoogleDriveActivity:a	(Lcom/whatsapp/gdrive/at;)Landroid/util/Pair;
    //   209: astore 15
    //   211: aload 15
    //   213: getfield 633	android/util/Pair:first	Ljava/lang/Object;
    //   216: checkcast 440	com/whatsapp/gdrive/bb
    //   219: astore 8
    //   221: aload 15
    //   223: getfield 636	android/util/Pair:second	Ljava/lang/Object;
    //   226: checkcast 440	com/whatsapp/gdrive/bb
    //   229: astore 15
    //   231: aload 8
    //   233: ifnull +8 -> 241
    //   236: aload 15
    //   238: ifnonnull +185 -> 423
    //   241: new 227	java/lang/StringBuilder
    //   244: dup
    //   245: ldc_w 638
    //   248: invokespecial 232	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   251: aload 13
    //   253: invokestatic 612	com/whatsapp/gdrive/ch:a	(Ljava/lang/String;)Ljava/lang/String;
    //   256: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokestatic 266	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   265: aload_0
    //   266: getfield 100	com/whatsapp/gdrive/GoogleDriveActivity:S	Ljava/util/Set;
    //   269: aload 17
    //   271: invokeinterface 639 2 0
    //   276: pop
    //   277: aload 9
    //   279: astore 8
    //   281: aload 10
    //   283: astore 14
    //   285: aload 11
    //   287: astore 15
    //   289: aload 12
    //   291: astore 16
    //   293: lload 4
    //   295: lstore 6
    //   297: goto +367 -> 664
    //   300: astore 8
    //   302: new 227	java/lang/StringBuilder
    //   305: dup
    //   306: ldc_w 641
    //   309: invokespecial 232	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   312: aload 13
    //   314: invokestatic 612	com/whatsapp/gdrive/ch:a	(Ljava/lang/String;)Ljava/lang/String;
    //   317: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: aload 8
    //   325: invokestatic 643	com/whatsapp/util/Log:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   328: aload 9
    //   330: astore 8
    //   332: aload 10
    //   334: astore 14
    //   336: aload 11
    //   338: astore 15
    //   340: aload 12
    //   342: astore 16
    //   344: lload 4
    //   346: lstore 6
    //   348: aload_0
    //   349: invokespecial 645	com/whatsapp/gdrive/GoogleDriveActivity:y	()Z
    //   352: ifeq +312 -> 664
    //   355: new 227	java/lang/StringBuilder
    //   358: dup
    //   359: ldc_w 647
    //   362: invokespecial 232	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   365: aload 13
    //   367: invokestatic 612	com/whatsapp/gdrive/ch:a	(Ljava/lang/String;)Ljava/lang/String;
    //   370: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: invokestatic 266	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   379: aload_0
    //   380: getfield 100	com/whatsapp/gdrive/GoogleDriveActivity:S	Ljava/util/Set;
    //   383: aload 17
    //   385: invokeinterface 639 2 0
    //   390: pop
    //   391: aload 9
    //   393: astore 8
    //   395: aload 10
    //   397: astore 14
    //   399: aload 11
    //   401: astore 15
    //   403: aload 12
    //   405: astore 16
    //   407: lload 4
    //   409: lstore 6
    //   411: goto +253 -> 664
    //   414: astore_1
    //   415: aload_1
    //   416: athrow
    //   417: astore_1
    //   418: invokestatic 608	com/whatsapp/gdrive/GoogleDriveService:f	()V
    //   421: aload_1
    //   422: athrow
    //   423: new 227	java/lang/StringBuilder
    //   426: dup
    //   427: ldc_w 649
    //   430: invokespecial 232	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   433: aload 13
    //   435: invokestatic 612	com/whatsapp/gdrive/ch:a	(Ljava/lang/String;)Ljava/lang/String;
    //   438: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: ldc_w 651
    //   444: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: aload 15
    //   449: getfield 479	com/whatsapp/gdrive/bb:e	J
    //   452: invokevirtual 654	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   455: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   458: invokestatic 266	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   461: aload 15
    //   463: getfield 479	com/whatsapp/gdrive/bb:e	J
    //   466: lstore 6
    //   468: lload 6
    //   470: lload 4
    //   472: lcmp
    //   473: ifle +172 -> 645
    //   476: aload 15
    //   478: getfield 479	com/whatsapp/gdrive/bb:e	J
    //   481: lstore 6
    //   483: lload 6
    //   485: lstore 4
    //   487: aload 8
    //   489: astore 9
    //   491: aload 15
    //   493: astore 8
    //   495: aload 9
    //   497: astore 15
    //   499: aload 13
    //   501: astore 16
    //   503: lload 4
    //   505: lstore 6
    //   507: goto +157 -> 664
    //   510: aload 10
    //   512: ifnonnull +30 -> 542
    //   515: new 26	com/whatsapp/gdrive/GoogleDriveActivity$a
    //   518: dup
    //   519: aconst_null
    //   520: aconst_null
    //   521: aconst_null
    //   522: aconst_null
    //   523: aconst_null
    //   524: ldc2_w 576
    //   527: ldc2_w 576
    //   530: iconst_0
    //   531: iconst_0
    //   532: iconst_0
    //   533: invokespecial 592	com/whatsapp/gdrive/GoogleDriveActivity$a:<init>	(Ljava/lang/String;Lcom/whatsapp/gdrive/bb;Lcom/whatsapp/gdrive/bb;Lcom/whatsapp/gdrive/bc;Lcom/whatsapp/gdrive/at;JJZZB)V
    //   536: astore_1
    //   537: invokestatic 608	com/whatsapp/gdrive/GoogleDriveService:f	()V
    //   540: aload_1
    //   541: areturn
    //   542: aload_0
    //   543: aload 12
    //   545: aload 11
    //   547: aload 10
    //   549: aload 9
    //   551: invokespecial 656	com/whatsapp/gdrive/GoogleDriveActivity:a	(Ljava/lang/String;Lcom/whatsapp/gdrive/bb;Lcom/whatsapp/gdrive/at;Lcom/whatsapp/gdrive/bb;)Lcom/whatsapp/gdrive/GoogleDriveActivity$a;
    //   554: astore_1
    //   555: invokestatic 608	com/whatsapp/gdrive/GoogleDriveService:f	()V
    //   558: aload_1
    //   559: areturn
    //   560: astore 8
    //   562: goto -260 -> 302
    //   565: astore 16
    //   567: aload 15
    //   569: astore 9
    //   571: aload 14
    //   573: astore 10
    //   575: aload 8
    //   577: astore 11
    //   579: aload 13
    //   581: astore 12
    //   583: aload 16
    //   585: astore 8
    //   587: goto -285 -> 302
    //   590: astore 8
    //   592: goto -290 -> 302
    //   595: astore 16
    //   597: aload 15
    //   599: astore 9
    //   601: aload 14
    //   603: astore 10
    //   605: aload 8
    //   607: astore 11
    //   609: aload 13
    //   611: astore 12
    //   613: aload 16
    //   615: astore 8
    //   617: goto -315 -> 302
    //   620: astore 16
    //   622: aload 15
    //   624: astore 9
    //   626: aload 14
    //   628: astore 10
    //   630: aload 8
    //   632: astore 11
    //   634: aload 13
    //   636: astore 12
    //   638: aload 16
    //   640: astore 8
    //   642: goto -340 -> 302
    //   645: aload 11
    //   647: astore 8
    //   649: aload 10
    //   651: astore 14
    //   653: aload 9
    //   655: astore 15
    //   657: aload 12
    //   659: astore 13
    //   661: goto -174 -> 487
    //   664: iload_2
    //   665: iconst_1
    //   666: iadd
    //   667: istore_2
    //   668: aload 8
    //   670: astore 9
    //   672: aload 14
    //   674: astore 10
    //   676: aload 15
    //   678: astore 11
    //   680: aload 16
    //   682: astore 12
    //   684: lload 6
    //   686: lstore 4
    //   688: goto -641 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	691	0	this	GoogleDriveActivity
    //   0	691	1	paramArrayOfAccount	Account[]
    //   46	622	2	i	int
    //   44	6	3	j	int
    //   21	666	4	l1	long
    //   137	548	6	l2	long
    //   121	159	8	localObject1	Object
    //   300	24	8	localf1	f
    //   330	164	8	localObject2	Object
    //   560	16	8	localax1	ax
    //   585	1	8	localObject3	Object
    //   590	16	8	localbl1	bl
    //   615	54	8	localObject4	Object
    //   33	638	9	localObject5	Object
    //   30	645	10	localObject6	Object
    //   27	652	11	localObject7	Object
    //   24	659	12	localObject8	Object
    //   180	480	13	localObject9	Object
    //   125	548	14	localObject10	Object
    //   129	548	15	localObject11	Object
    //   133	369	16	localObject12	Object
    //   565	19	16	localax2	ax
    //   595	19	16	localbl2	bl
    //   620	61	16	localf2	f
    //   55	329	17	localAccount	Account
    // Exception table:
    //   from	to	target	type
    //   203	231	300	com/whatsapp/gdrive/f
    //   241	277	300	com/whatsapp/gdrive/f
    //   423	468	300	com/whatsapp/gdrive/f
    //   203	231	414	finally
    //   241	277	414	finally
    //   302	328	414	finally
    //   348	391	414	finally
    //   423	468	414	finally
    //   476	483	414	finally
    //   42	45	417	finally
    //   57	73	417	finally
    //   78	119	417	finally
    //   142	203	417	finally
    //   415	417	417	finally
    //   515	537	417	finally
    //   542	555	417	finally
    //   203	231	560	com/whatsapp/gdrive/ax
    //   241	277	560	com/whatsapp/gdrive/ax
    //   423	468	560	com/whatsapp/gdrive/ax
    //   476	483	565	com/whatsapp/gdrive/ax
    //   203	231	590	com/whatsapp/gdrive/bl
    //   241	277	590	com/whatsapp/gdrive/bl
    //   423	468	590	com/whatsapp/gdrive/bl
    //   476	483	595	com/whatsapp/gdrive/bl
    //   476	483	620	com/whatsapp/gdrive/f
  }
  
  private bb a(final at paramat, final String paramString)
  {
    if (this.Q.containsKey(paramString)) {
      return (bb)this.Q.get(paramString);
    }
    Log.i("gdrive-activity/decide making a request to fetch last modified timestamp of remote db file.");
    try
    {
      paramat = (bb)cs.a(GoogleDriveService.o, new cd() {}, "gdrive-activity/decide/failed-to-fetch-db-file");
      return paramat;
    }
    catch (ba paramat)
    {
      Log.d("gdrive-activity/decide/failed-to-fetch-db-file", paramat);
    }
    return null;
  }
  
  private void a(a parama)
  {
    Log.i("gdrive-activity/show-restore-for-gdrive-backup/" + ch.a(parama.a));
    String str = parama.a;
    bc localbc = parama.d;
    at localat = parama.e;
    long l1 = parama.f;
    long l2 = parama.g;
    if ((localbc != null) && (localbc.b != null)) {
      Log.i("gdrive-activity/show-restore/" + localbc.b.g);
    }
    ((View)a.d.a(findViewById(2131755266))).setVisibility(8);
    ((View)a.d.a(findViewById(2131755267))).setVisibility(0);
    this.T.open();
    setTitle(2131296288);
    if (this.s == null) {
      this.s = ((GoogleDriveRestoreAnimationView)findViewById(2131755273));
    }
    Object localObject;
    label202:
    StringBuilder localStringBuilder;
    label263:
    TextView localTextView;
    if (parama.i)
    {
      localObject = (TextView)a.d.a((TextView)findViewById(2131755270));
      if (vv.i())
      {
        i = 2131297630;
        ((TextView)localObject).setText(i);
        localObject = new StringBuilder(getString(2131296839));
        localStringBuilder = new StringBuilder();
        if (l1 > 0L)
        {
          ((StringBuilder)localObject).setLength(0);
          ((StringBuilder)localObject).append(com.whatsapp.util.l.b(this, this.aF, l1));
        }
        if (!parama.i) {
          break label475;
        }
        l1 = 0L;
        this.u = l1;
        if (l2 >= 0L)
        {
          localStringBuilder.setLength(0);
          localStringBuilder.append(com.whatsapp.util.be.a(this, l2));
        }
        if (!parama.h)
        {
          ((StringBuilder)localObject).setLength(0);
          ((StringBuilder)localObject).append(com.whatsapp.util.l.b(this, this.aF, u()));
        }
        localTextView = (TextView)a.d.a((TextView)findViewById(2131755269));
        if (!parama.i) {
          break label481;
        }
      }
    }
    label475:
    label481:
    for (int i = 2131297114;; i = 2131296911)
    {
      localTextView.setText(getString(i, new Object[] { str, ((StringBuilder)localObject).toString(), localStringBuilder.toString() }));
      ((Button)a.d.a((Button)findViewById(2131755281))).setOnClickListener(al.a(this));
      ((Button)a.d.a((Button)findViewById(2131755280))).setOnClickListener(am.a(this, str, l2, localat, parama, localbc));
      return;
      i = 2131297852;
      break;
      ((TextView)a.d.a((TextView)findViewById(2131755270))).setText(2131296910);
      break label202;
      l1 = l2;
      break label263;
    }
  }
  
  private boolean a(at paramat, bb parambb)
  {
    int i = 2;
    Object localObject = null;
    String str;
    if (parambb != null)
    {
      str = parambb.f;
      if (parambb == null) {
        break label94;
      }
    }
    for (parambb = parambb.c;; parambb = null)
    {
      try
      {
        File localFile = this.y.c.g();
        localObject = localFile;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          label94:
          Log.e("gdrive-activity/device unable to access local backup");
          continue;
          i = 4;
        }
        if (((File)localObject).length() != 0L) {
          break label156;
        }
        Log.i("gdrive-activity/decide local msgstore exists but is empty.");
        this.H.i(true);
        if (parambb == null) {
          break label151;
        }
        for (;;)
        {
          k(i);
          return true;
          i = 4;
        }
        if (str != null) {
          break label183;
        }
        Log.e("gdrive-activity/decide remote dbFile does not exist");
        this.H.i(false);
        k(3);
        return false;
        if (!str.equals(ch.a(this.ax, this.aP, (File)localObject))) {
          break label226;
        }
        Log.i("gdrive-activity/decide Local message backup has same md5 as google drive.");
        this.H.i(false);
        k(5);
        return false;
        paramat = a(paramat, parambb);
        if (paramat != null) {
          break label259;
        }
        Log.e("gdrive-activity/decide remote dbFile does not exist");
        this.H.i(false);
        k(3);
        return false;
        if (((File)localObject).lastModified() >= paramat.e) {
          break label375;
        }
        Log.i("gdrive-activity/decide/choose-remote Google Drive (timestamp " + paramat.e + ", time: " + com.whatsapp.util.l.g(this, this.aF, paramat.e) + ") is newer than local message backup (timestamp " + ((File)localObject).lastModified() + ", time: " + com.whatsapp.util.l.g(this, this.aF, ((File)localObject).lastModified()) + ")");
        this.H.i(true);
        k(6);
        return true;
        Log.i("gdrive-activity/decide/choose-local local backup file (timestamp " + ((File)localObject).lastModified() + ", time: " + com.whatsapp.util.l.g(this, this.aF, ((File)localObject).lastModified()) + ") and is newer than one on Google Drive (timestamp " + paramat.e + ", time: " + com.whatsapp.util.l.g(this, this.aF, paramat.e) + ") and the two files are different as well, therefore, we will use the local");
        this.H.i(false);
        k(7);
      }
      if ((localObject != null) && (((File)localObject).exists()) && (this.ac)) {
        break label115;
      }
      Log.i("gdrive-activity/decide local msgstore does not exist or is unusable");
      this.H.i(true);
      if (parambb == null) {
        break label110;
      }
      i = 2;
      k(i);
      return true;
      str = null;
      break;
    }
    label110:
    label115:
    label151:
    label156:
    label183:
    label226:
    label259:
    label375:
    return false;
  }
  
  private void e(boolean paramBoolean)
  {
    setTitle(2131296288);
    Log.i("gdrive-activity/msgstore-download-finished with success: " + paramBoolean + ", now, restoring it.");
    super.c(paramBoolean);
  }
  
  private void k(int paramInt)
  {
    com.whatsapp.fieldstats.l.a(this, 365, Integer.valueOf(paramInt));
  }
  
  private static String l(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalStateException("Unknown state: " + paramInt);
    case 21: 
      return "new";
    case 22: 
      return "restore-from-gdrive";
    case 23: 
      return "restore-from-local";
    case 24: 
      return "restoring-from-gdrive";
    case 27: 
      return "restoring-from-local";
    case 25: 
      return "return-from-auth";
    }
    return "msgstore-restored";
  }
  
  private long u()
  {
    Log.d("gdrive-activity/lastbackup/look at files");
    long l = this.y.c.h();
    if (l != -1L) {
      Log.d("gdrive-activity/lastbackup/fromfiles/set to " + l);
    }
    return l;
  }
  
  private boolean v()
  {
    return (this.S.size() < this.R.size()) || (this.ac);
  }
  
  private void w()
  {
    
    boolean bool;
    TextView localTextView;
    if ((this.Z != null) && (this.Z.a != null) && (!this.Z.i))
    {
      bool = true;
      if (this.s == null) {
        this.s = ((GoogleDriveRestoreAnimationView)a.d.a((GoogleDriveRestoreAnimationView)findViewById(2131755273)));
      }
      this.s.a();
      ((View)a.d.a(findViewById(2131755279))).setVisibility(8);
      if (this.q != null) {
        this.q.setVisibility(8);
      }
      if (this.r != null) {
        this.r.setVisibility(8);
      }
      if (this.V == null) {
        this.V = ((TextView)a.d.a((TextView)findViewById(2131755278)));
      }
      this.V.setVisibility(8);
      localTextView = (TextView)a.d.a((TextView)findViewById(2131755277));
      localTextView.setVisibility(0);
      if (!bool) {
        break label289;
      }
      ch.d(this.H);
    }
    label289:
    for (Object localObject = com.whatsapp.u.a.a(2131230749, this.y.z.a.g, new Object[] { Integer.valueOf(this.y.z.a.g) });; localObject = com.whatsapp.u.a.a(2131230750, this.y.z.a.g, new Object[] { Integer.valueOf(this.y.z.a.g) }))
    {
      Log.i("gdrive-activity/after-msgstore-verified/ " + (String)localObject);
      localTextView.setText((CharSequence)localObject);
      localObject = (Button)a.d.a((Button)findViewById(2131755276));
      ((Button)localObject).setVisibility(0);
      ((Button)localObject).setOnClickListener(ai.a(this, bool));
      return;
      bool = false;
      break;
    }
  }
  
  private void x()
  {
    Log.i("gdrive-activity/show-new-user-settings");
    this.v = true;
    c(false);
    GoogleDriveNewUserSetupActivity.a(System.currentTimeMillis() + 604800000L);
  }
  
  private boolean y()
  {
    boolean bool = this.H.a.getBoolean("new_jid", false);
    Log.i("gdrive-activity/is-new-jid/" + bool);
    return bool;
  }
  
  private void z()
  {
    Object localObject2 = new StringBuilder("gdrive-activity/skip-restore user declined to restore backup from ");
    Object localObject1;
    if (this.Z == null)
    {
      localObject1 = "<unset account>";
      Log.i((String)localObject1);
      Log.i("gdrive-activity/skip-restore/stopping-approx-transfer-size-calc-thread");
      this.p.set(true);
      ch.f(this.H);
      this.H.S();
      this.H.h(0);
      this.H.k(false);
      localObject1 = v.a(this);
      if (Looper.myLooper() != Looper.getMainLooper()) {
        break label198;
      }
      bu.a((Runnable)localObject1);
      label99:
      if (this.t == null) {
        break label207;
      }
      this.t.a(10);
    }
    for (;;)
    {
      localObject1 = this.H.ac();
      if (localObject1 != null)
      {
        localObject2 = new Intent(this, GoogleDriveService.class);
        ((Intent)localObject2).setAction("action_remove_backup_info");
        ((Intent)localObject2).putExtra("account_name", (String)localObject1);
        ((Intent)localObject2).putExtra("remove_account_name", true);
        getApplicationContext().startService((Intent)localObject2);
      }
      setResult(2);
      x();
      return;
      localObject1 = ch.a(this.Z.a);
      break;
      label198:
      ((Runnable)localObject1).run();
      break label99;
      label207:
      Log.e("gdrive-activity/skip-restore/google-drive-service-object-is-null");
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    if (paramInt1 == 17)
    {
      if (paramArrayOfString[paramInt2].equals(getString(2131296918)))
      {
        paramArrayOfString = AccountManager.get(this).addAccount("com.google", null, null, null, this, null, null);
        ch.d().execute(w.a(this, paramArrayOfString));
        Log.i("gdrive-activity/show-accounts/waiting-for-add-account-activity-to-return");
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("authAccount", paramArrayOfString[paramInt2]);
      onActivityResult(3, -1, localIntent);
      return;
    }
    throw new IllegalStateException("Unexpected dialogId: " + paramInt1 + " index:" + paramInt2);
  }
  
  final void a(int paramInt, ch.a parama)
  {
    this.ab = paramInt;
    this.aa = parama;
    Log.i("gdrive-activity/state " + l(this.ab) + " " + this.aa);
    Object localObject = this.H;
    paramInt = this.ab;
    parama = this.aa;
    if (parama == null)
    {
      parama = null;
      localObject = ((atv)localObject).a.edit();
      ((SharedPreferences.Editor)localObject).putInt("gdrive_activity_state", paramInt);
      if (parama == null) {
        break label245;
      }
      ((SharedPreferences.Editor)localObject).putInt("gdrive_activity_msgstore_init_key", parama.intValue());
    }
    for (;;)
    {
      if (!((SharedPreferences.Editor)localObject).commit()) {
        Log.w("washaredpreferences/failed to save state");
      }
      return;
      switch (7.a[parama.ordinal()])
      {
      default: 
        throw new IllegalArgumentException("Unexpected status: " + parama);
      case 3: 
        parama = Integer.valueOf(0);
        break;
      case 4: 
        parama = Integer.valueOf(1);
        break;
      case 5: 
        parama = Integer.valueOf(2);
        break;
      case 1: 
        parama = Integer.valueOf(3);
        break;
      case 2: 
        parama = Integer.valueOf(4);
        break;
      case 6: 
        parama = Integer.valueOf(5);
        break;
        label245:
        ((SharedPreferences.Editor)localObject).remove("gdrive_activity_msgstore_init_key");
      }
    }
  }
  
  final void a(long paramLong1, long paramLong2)
  {
    a.d.c();
    this.u = paramLong1;
    this.W = paramLong2;
    Object localObject = this.H;
    long l = this.W;
    localObject = ((atv)localObject).a.edit().putLong("gdrive_approx_media_download_size", l);
    Log.i("washaredpreferences/save-gdrive-media-download-transfer-size/" + l);
    if (!((SharedPreferences.Editor)localObject).commit()) {
      Log.w("washaredpreferences/save-gdrive-media-download-transfer-size/failed");
    }
    if (paramLong1 <= 0L) {}
    for (localObject = getString(2131296850);; localObject = getString(2131296848, new Object[] { com.whatsapp.util.be.a(this, paramLong1) }))
    {
      this.T.block();
      Log.i("gdrive-activity/update-restore-info/ total download size: " + paramLong1 + " media download size: " + paramLong2);
      runOnUiThread(m.a(this, (String)localObject));
      return;
    }
  }
  
  protected final void a(ch.a parama)
  {
    
    if (this.v)
    {
      setResult(2);
      finish();
    }
    label379:
    label597:
    label604:
    do
    {
      do
      {
        do
        {
          return;
          if (this.ab == 26)
          {
            Log.i("gdrive-activity/after-msgstore-verified/state-is-msgstore-restored/call-ignored " + parama);
            return;
          }
          Log.i("gdrive-activity/after-msgstore-verified/" + parama);
          a(26, parama);
          if (parama != ch.a.c) {}
          for (boolean bool = true;; bool = false)
          {
            a.d.a(bool, parama + " is unexpected here");
            if (parama != ch.a.b) {
              break;
            }
            w();
            return;
          }
          if (parama != ch.a.f) {
            break;
          }
          a.d.b();
        } while (ch.a(this));
        parama = new co.a(this, 19).a(getString(2131296886)).a(false).b(2131297619).c(2131297856).a();
        localObject1 = j_().a();
        ((android.support.v4.app.w)localObject1).a(parama, null);
        ((android.support.v4.app.w)localObject1).e();
        return;
        if ((this.Z == null) || (!this.Z.h)) {
          break;
        }
        this.S.add(new Account(this.Z.a, "com.google"));
        Log.i("gdrive-activity/after-msgstore-verified/failed/unrestorable-gdrive-backup/" + ch.a(this.Z.a));
        if (parama != ch.a.d) {
          break label604;
        }
        a.d.b();
      } while (ch.a(this));
      localObject1 = new co.a(this, 20);
      parama = Collections.unmodifiableSet(this.y.c.d);
      parama = (String[])parama.toArray(new String[parama.size()]);
      Log.i("gdrive-activity/get-jid-mismatch-message " + Arrays.toString(parama));
      if (parama.length == 0)
      {
        parama = getString(2131296884);
        parama = ((co.a)localObject1).a(parama).a(false).b(2131296887);
        if (!v()) {
          break label597;
        }
      }
      for (int i = 2131297618;; i = 2131297856)
      {
        parama = parama.c(i).a();
        localObject1 = j_().a();
        ((android.support.v4.app.w)localObject1).a(parama, null);
        ((android.support.v4.app.w)localObject1).e();
        return;
        this.ac = false;
        Log.i("gdrive-activity/after-msgstore-verified/failed/unrestorable-local-backup");
        break;
        if (parama.length == 1)
        {
          parama = getString(2131296885, new Object[] { com.whatsapp.data.cs.a(this.H.af()), parama[0] });
          break label379;
        }
        Arrays.sort(parama);
        String[] arrayOfString = new String[parama.length - 1];
        Object localObject2 = parama[(parama.length - 1)];
        System.arraycopy(parama, 0, arrayOfString, 0, parama.length - 1);
        parama = getString(2131296883, new Object[] { com.whatsapp.data.cs.a(this.H.af()), TextUtils.join(String.valueOf(com.whatsapp.al.a(this.aF)) + " ", arrayOfString), localObject2 });
        break label379;
      }
      if (!v()) {
        break;
      }
      a.d.b();
    } while (ch.a(this));
    parama = new co.a(this, 18).a(getString(2131296888)).a(false).b(2131297618).c(2131297856).a();
    Object localObject1 = j_().a();
    ((android.support.v4.app.w)localObject1).a(parama, null);
    ((android.support.v4.app.w)localObject1).e();
    return;
    c(false);
    w();
    this.aq.a(this, getString(2131297212));
  }
  
  final boolean a(String paramString, int paramInt)
  {
    a.d.c();
    Log.i("gdrive-activity/auth-request account being used is " + ch.a(paramString));
    bu.a(u.a(this, paramString, paramInt));
    Log.i("gdrive-activity/auth-request blocking on tokenReceived");
    this.o.block(100000L);
    return this.Y != null;
  }
  
  protected final void d(int paramInt)
  {
    if (paramInt - this.X > 0)
    {
      this.X = paramInt;
      if (paramInt % 10 == 0) {
        Log.i("gdrive-activity/msg-restore-progress/" + paramInt + "%");
      }
      if (paramInt <= 100)
      {
        if (this.r != null) {
          this.r.setText(getString(2131297743, new Object[] { Integer.valueOf(paramInt) }));
        }
        if (this.q != null) {
          this.q.setIndeterminate(true);
        }
      }
    }
  }
  
  final void d(boolean paramBoolean)
  {
    a.d.b();
    Log.i("gdrive-activity/perform-one-time-setup");
    int i;
    int j;
    if (this.aP.a("android.permission.GET_ACCOUNTS") != 0)
    {
      i = 1;
      if (this.aP.b()) {
        break label67;
      }
      j = 1;
    }
    for (;;)
    {
      if ((i != 0) || (j != 0))
      {
        if (!paramBoolean) {
          break label155;
        }
        if (j != 0)
        {
          setResult(1);
          finish();
          return;
          i = 0;
          break;
          label67:
          j = 0;
          continue;
        }
        a(23, null);
        q();
      }
    }
    final Timer localTimer = new Timer("perform-one-time-setup");
    final bd localbd = new bd("gdrive-activity/one-time-setup");
    final Account[] arrayOfAccount = s();
    this.R.clear();
    Collections.addAll(this.R, arrayOfAccount);
    bu.a(new AsyncTask()
    {
      protected final void onPreExecute()
      {
        localTimer.schedule(new TimerTask()
        {
          public final void run()
          {
            Log.i("gdrive-activity/one-time-setup/not-finished-in-" + GoogleDriveActivity.5.this.b.c() / 1000L + "-seconds");
            GoogleDriveActivity.this.runOnUiThread(new as(this));
          }
        }, 30000L);
      }
    }, new Object[0]);
    return;
    label155:
    if ((j != 0) && (i != 0))
    {
      startActivityForResult(new Intent(this, RequestPermissionActivity.class).putExtra("drawable_ids", new int[] { 2130840437, 2130840441, 2130840443 }).putExtra("permissions", new String[] { "android.permission.GET_ACCOUNTS", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE" }).putExtra("message_id", 2131297412).putExtra("perm_denial_message_id", 2131297411).putExtra("force_ui", true), 5);
      return;
    }
    if (j != 0)
    {
      RequestPermissionActivity.a(this, 2131297441, 2131297440, true, 5);
      return;
    }
    startActivityForResult(new Intent(this, RequestPermissionActivity.class).putExtra("drawable_id", 2130840437).putExtra("permissions", new String[] { "android.permission.GET_ACCOUNTS" }).putExtra("message_id", 2131297370).putExtra("perm_denial_message_id", 2131297369).putExtra("force_ui", true), 5);
  }
  
  final void e(int paramInt)
  {
    co localco = new co.a(this, paramInt).a(getString(2131296688)).a(true).b(2131297210).c(2131296398).a();
    if (!ch.a(this))
    {
      android.support.v4.app.w localw = j_().a();
      localw.a(localco, null);
      localw.e();
    }
  }
  
  public final void f(int paramInt)
  {
    if (paramInt == 10)
    {
      Log.i("gdrive-activity/show-restore user declined to restore from local backup");
      setResult(2);
      x();
      return;
    }
    if (paramInt == 11)
    {
      Log.i("gdrive-activity/user-confirmed-skip-restore");
      z();
      return;
    }
    if (paramInt == 12)
    {
      Log.i("gdrive-activity/restore-media-on-cellular-dialog, Wi-Fi unavailable and user declined to restore media on cellular.");
      setResult(3);
      finish();
      return;
    }
    if (paramInt == 13)
    {
      Log.i("gdrive-activity/insufficient-storage-for-restore/user-decided-to-visit-storage-settings");
      startActivity(new Intent("android.settings.INTERNAL_STORAGE_SETTINGS"));
      return;
    }
    if (paramInt == 14)
    {
      Log.i("gdrive-activity/one-time-setup no google drive backups found and user decided to add an account or give permission to an existing one.");
      B();
      return;
    }
    if (paramInt == 15)
    {
      Log.i("gdrive-activity/google-play-services-is-broken/user-decided-to-skip");
      setResult(1);
      finish();
      return;
    }
    if (paramInt == 16)
    {
      Log.i("gdrive-activity/one-time-setup-taking-too-long/user-decided-to-wait");
      return;
    }
    if (paramInt == 18)
    {
      Log.i("gdrive-activity/failed-to-restore-from-selected-backup/restore-from-older");
      A();
      return;
    }
    if (paramInt == 19)
    {
      if (this.y != null) {
        this.y.e();
      }
      A();
      return;
    }
    if (paramInt == 20)
    {
      Log.i("gdrive-activity/msgstore-jid-mistmatch/user-decided-to-reregister");
      RegisterPhone.a(this);
      this.G.e();
      Intent localIntent = new Intent(this, Main.class);
      localIntent.setFlags(268435456);
      startActivity(localIntent);
      System.exit(0);
      return;
    }
    throw new IllegalStateException("unexpected dialog box: " + paramInt);
  }
  
  public final void h(int paramInt)
  {
    if ((paramInt == 10) || (paramInt == 11))
    {
      Log.i("gdrive-activity/dialog-negative-click/dialog-id/" + paramInt);
      return;
    }
    if (paramInt == 12)
    {
      Log.i("gdrive-activity/restore-media-on-cellular-dialog Wi-Fi unavailable and user agreed to restore media on cellular.");
      this.H.W();
      n();
      Log.i("gdrive-activity/msgstore-download-finish setting result of Google Drive activity to BACKUP_FOUND_AND_RESTORED.");
      setResult(3);
      finish();
      return;
    }
    if (paramInt == 14)
    {
      Log.i("gdrive-activity/no-local-or-gdrive-backup-found-dialog no google drive backups found and user is not interested in adding an account for that either.");
      x();
      setResult(1);
      return;
    }
    if (paramInt == 16)
    {
      Log.i("gdrive-activity/one-time-setup-is-taking-too-long/user-decided-to-cancel");
      cs.a();
      this.U.set(true);
      if (this.y.c.d() > 0)
      {
        a(23, null);
        q();
        return;
      }
      this.v = true;
      c(false);
      return;
    }
    if (paramInt == 18)
    {
      Log.i("gdrive-activity/failed-to-restore-messages-from-selected-backup/user-decided-to-continue");
      this.v = true;
      c(false);
      w();
      return;
    }
    if (paramInt == 19)
    {
      Log.i("gdrive-activity/failed-to-restore-messages/internal-storage-out-of-free-space/user-decided-to-skip");
      this.v = true;
      c(false);
      return;
    }
    if (paramInt == 20)
    {
      if (v())
      {
        Log.i("gdrive-activity/msgstore-jid-mismatch/restore-from-older");
        A();
        return;
      }
      Log.i("gdrive-activity/msgstore-jid-mismatch/skip");
      c(false);
      w();
      return;
    }
    throw new IllegalStateException("unexpected dialog box: " + paramInt);
  }
  
  public final void i(int paramInt)
  {
    if (paramInt == 13)
    {
      Log.i("gdrive-activity/insufficient-space-dialog/neutral-click");
      return;
    }
    throw new IllegalStateException("unexpected dialog box: " + paramInt);
  }
  
  public final void j(int paramInt)
  {
    if (paramInt == 17)
    {
      Log.i("gdrive-activity/user-dismissed-account-selector-dialog-dismissed");
      d(true);
      return;
    }
    throw new IllegalStateException("Unexpected dialog id:" + paramInt);
  }
  
  final void m()
  {
    Log.i("gdrive-activity/restore-messages");
    if ((this.Z == null) || (!this.Z.i))
    {
      Intent localIntent = new Intent(this, GoogleDriveService.class);
      localIntent.setAction("action_restore");
      getApplicationContext().startService(localIntent);
    }
    for (;;)
    {
      runOnUiThread(ak.a(this));
      return;
      this.ag.b(true);
    }
  }
  
  final void n()
  {
    Log.i("gdrive-activity/restore-media");
    Intent localIntent = new Intent(this, GoogleDriveService.class);
    localIntent.setAction("action_restore_media");
    getApplicationContext().startService(localIntent);
  }
  
  protected final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 5)
    {
      Log.i("gdrive-activity/request-permissions/result/" + paramInt2);
      d(true);
    }
    do
    {
      return;
      if (paramInt1 == 2)
      {
        Log.i("gdrive-activity/request-to-fix-google-play-services/result/" + paramInt2);
        d(false);
        return;
      }
      if (paramInt1 != 1) {
        break;
      }
    } while (paramInt2 != -1);
    this.Y = paramIntent.getStringExtra("authtoken");
    this.o.open();
    bu.a(j.a(this));
    return;
    if (paramInt1 == 3)
    {
      if (paramInt2 == -1)
      {
        paramIntent = paramIntent.getExtras().getString("authAccount");
        Log.d("gdrive-activity/activity-result accountName is " + paramIntent);
        if (paramIntent == null)
        {
          Log.e("gdrive-activity/activity-result/account-picker-returned-null-account");
          return;
        }
        bu.a(k.a(this, paramIntent));
        return;
      }
      Log.e("gdrive-activity/activity-result/account-picker-request/" + paramInt2);
      this.v = true;
      c(false);
      return;
    }
    if (paramInt1 == 4)
    {
      Log.i("gdrive-activity/activity-result/account-added-request/" + paramInt2);
      paramIntent = new Intent(this, GoogleDriveActivity.class);
      paramIntent.setAction("action_show_restore_one_time_setup");
      startActivity(paramIntent);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public final void onBackPressed()
  {
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.addCategory("android.intent.category.HOME");
    localIntent.setFlags(268435456);
    startActivity(localIntent);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Log.i("gdrive-activity/create");
    if (!GoogleDriveService.c())
    {
      Log.i("gdrive-activity/no-google-drive-access-possible");
      setResult(0);
      finish();
      return;
    }
    setContentView(2130903075);
    Object localObject = (Toolbar)findViewById(2131755264);
    if (!ae.a(ViewConfiguration.get(getApplicationContext())))
    {
      a((Toolbar)localObject);
      localObject = i();
      if (localObject != null)
      {
        ((android.support.v7.app.a)localObject).a(false);
        ((android.support.v7.app.a)localObject).b();
      }
    }
    setTitle(2131298232);
    d.a((ProgressBar)findViewById(2131755262), getResources().getColor(2131623944));
    d.a((ProgressBar)findViewById(2131755284), getResources().getColor(2131623944));
    getApplicationContext().bindService(new Intent(this, GoogleDriveService.class), this.af, 1);
    if (paramBundle == null)
    {
      this.ab = 21;
      this.aa = null;
      this.H.a.edit().remove("gdrive_activity_state").remove("gdrive_activity_msgstore_init_key").apply();
      label212:
      if (paramBundle != null) {
        break label544;
      }
    }
    label434:
    label536:
    label544:
    for (localObject = null;; localObject = paramBundle.getBundle("restore_account_data"))
    {
      Log.i("gdrive-activity/create/state/" + l(this.ab));
      switch (this.ab)
      {
      default: 
        throw new IllegalStateException("Unknown state: " + this.ab);
        localObject = this.H;
        localObject = new Pair(Integer.valueOf(((atv)localObject).a.getInt("gdrive_activity_state", -1)), Integer.valueOf(((atv)localObject).a.getInt("gdrive_activity_msgstore_init_key", -1)));
        if (((Integer)((Pair)localObject).first).intValue() != -1) {}
        for (int i = ((Integer)((Pair)localObject).first).intValue();; i = 21)
        {
          this.ab = i;
          if (this.ab != 26) {
            break label536;
          }
          if (((Integer)((Pair)localObject).second).intValue() != -1) {
            break label434;
          }
          this.aa = ch.a.a;
          break;
        }
        switch (((Integer)((Pair)localObject).second).intValue())
        {
        default: 
          localObject = null;
        }
        for (;;)
        {
          this.aa = ((ch.a)localObject);
          break;
          localObject = ch.a.a;
          continue;
          localObject = ch.a.b;
          continue;
          localObject = ch.a.c;
          continue;
          localObject = ch.a.d;
          continue;
          localObject = ch.a.e;
          continue;
          localObject = ch.a.f;
        }
        this.aa = null;
        break label212;
      }
    }
    if (localObject == null) {
      throw new IllegalStateException("restore_account_data cannot be null");
    }
    this.Z = a.a((Bundle)localObject);
    a(22, null);
    a(this.Z);
    a(24, null);
    r();
    if (!ch.b(this.H))
    {
      Log.i("gdrive-activity/create/gdrive-msgstore-download-not-pending");
      e(true);
    }
    for (;;)
    {
      ((View)a.d.a(findViewById(2131755279))).getViewTreeObserver().addOnGlobalLayoutListener(r.a(this));
      return;
      Log.i("gdrive-activity/create/gdrive-msgstore-download-pending");
      continue;
      paramBundle = getIntent();
      if (paramBundle.getAction() == null)
      {
        Log.e("gdrive-activity/create no action provided.");
        finish();
        return;
      }
      onNewIntent(paramBundle);
      continue;
      if (localObject == null) {
        throw new IllegalStateException("restore_account_data cannot be null");
      }
      this.Z = a.a((Bundle)localObject);
      a(22, null);
      a(this.Z);
      bu.a(g.a(this, paramBundle));
      continue;
      a(23, null);
      q();
      continue;
      a(23, null);
      q();
      r();
      e(true);
      a(27, null);
      continue;
      if (localObject != null) {
        this.Z = a.a((Bundle)localObject);
      }
    }
    paramBundle = this.aa;
    if (localObject != null)
    {
      this.Z = a.a((Bundle)localObject);
      a(22, null);
      a(this.Z);
    }
    for (;;)
    {
      r();
      Log.i("gdrive-activity/create/msgstore-init-status/" + paramBundle);
      a(paramBundle);
      break;
      a(23, null);
      q();
    }
  }
  
  public final boolean onCreateOptionsMenu(Menu paramMenu)
  {
    paramMenu.add(0, 0, 0, 2131297595);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public final void onDestroy()
  {
    Log.i("gdrive-activity/destroy");
    this.N = true;
    if (this.t != null) {
      this.t.b(this.ag);
    }
    this.O.a();
    super.onDestroy();
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((av.j()) || (av.d())) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      return super.onKeyDown(paramInt, paramKeyEvent);
      this.t.a(11);
      this.t.b();
      continue;
      this.t.a(12);
      this.t.b();
      continue;
      this.t.a(14);
      this.t.b();
      continue;
      this.t.a(15);
      this.t.b();
    }
  }
  
  protected final void onNewIntent(Intent paramIntent)
  {
    String str1 = paramIntent.getAction();
    int i = -1;
    switch (str1.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        Log.e("gdrive-activity/new-intent unexpected action: " + paramIntent.getAction());
        finish();
        return;
        if (str1.equals("action_show_restore_one_time_setup")) {
          i = 0;
        }
        break;
      }
    }
    paramIntent = ch.a(ch.a(this), this, 2, ac.a(this), false);
    if ((paramIntent != null) && (!ch.a(this)) && (!y()))
    {
      Log.i("gdrive-activity/google-play-service-unavailable/existing-user");
      paramIntent.show();
      return;
    }
    if (this.H.ac() == null)
    {
      d(false);
      return;
    }
    long l1;
    long l2;
    if (ch.b(this.H))
    {
      Log.i("gdrive-activity/create/continue-msgstore-download");
      ((View)a.d.a(findViewById(2131755266))).setVisibility(8);
      ((View)a.d.a(findViewById(2131755267))).setVisibility(0);
      r();
      str1 = this.H.ac();
      l1 = this.H.f(str1);
      l2 = this.H.e(str1);
      paramIntent = getString(2131296839);
      if (l2 > 0L) {
        paramIntent = com.whatsapp.util.l.b(this, this.aF, l2).toString();
      }
      if (this.H.T()) {
        break label490;
      }
      paramIntent = com.whatsapp.util.l.b(this, this.aF, u()).toString();
    }
    label490:
    for (;;)
    {
      String str2 = com.whatsapp.util.be.a(this, l1);
      if (this.Z == null) {
        this.Z = new a(str1, null, null, null, null, l2, l1, this.H.T(), false, (byte)0);
      }
      ((TextView)a.d.a((TextView)findViewById(2131755269))).setText(getString(2131296911, new Object[] { str1, paramIntent, str2 }));
      m();
      return;
      if (this.H.R() != 0)
      {
        Log.i("gdrive-activity/create/msgstore-download-already-finished, restoring");
        ((View)a.d.a(findViewById(2131755266))).setVisibility(8);
        ((View)a.d.a(findViewById(2131755267))).setVisibility(0);
        ((TextView)a.d.a((TextView)findViewById(2131755269))).setText(SettingsChat.a(this.y, this, this.aF));
        r();
        e(true);
        return;
      }
      x();
      setResult(2);
      return;
    }
  }
  
  public final boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    }
    this.ae.a("one-time-restore");
    au localau = this.O;
    bk localbk = this.ae;
    paramMenuItem = "one-time-restore";
    Object localObject = paramMenuItem;
    if (this.aa != null) {}
    switch (7.a[this.aa.ordinal()])
    {
    default: 
      localObject = paramMenuItem;
      paramMenuItem = (MenuItem)localObject;
      switch (ch.a(this))
      {
      default: 
        paramMenuItem = (String)localObject + "-gs-invalid";
      }
      break;
    }
    for (;;)
    {
      localau.a(this, localbk, paramMenuItem);
      return true;
      localObject = "one-time-restore" + "-jid-mismatch";
      break;
      localObject = "one-time-restore" + "-integrity-check-failed";
      break;
      paramMenuItem = (String)localObject + "-no-gs";
      continue;
      paramMenuItem = (String)localObject + "-update-gs";
      continue;
      paramMenuItem = (String)localObject + "-gs-disabled";
    }
  }
  
  public final void onResume()
  {
    super.onResume();
    o();
    Log.i("gdrive-activity/resume");
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      if (this.Z != null)
      {
        Log.i("gdrive-activity/save-state/restore-account-data/ " + this.Z);
        a locala = this.Z;
        Bundle localBundle = new Bundle();
        localBundle.putString("account_name", locala.a);
        localBundle.putLong("total_backup_size", locala.g);
        localBundle.putLong("last_modified", locala.f);
        localBundle.putBoolean("overwrite_local_files", locala.h);
        localBundle.putBoolean("is_download_size_zero", locala.i);
        paramBundle.putBundle("restore_account_data", localBundle);
      }
      Log.i("gdrive-activity/save-state/total-download-size/" + this.u);
      paramBundle.putLong("total_download_size", this.u);
      Log.i("gdrive-activity/save-state/media-download-size/" + this.W);
      paramBundle.putLong("media_download_size", this.W);
    }
  }
  
  final void q()
  {
    Log.i("gdrive-activity/show-restore-for-local-backup");
    ((View)a.d.a(findViewById(2131755266))).setVisibility(8);
    ((View)a.d.a(findViewById(2131755267))).setVisibility(0);
    this.T.open();
    setTitle(2131296288);
    ((View)a.d.a(findViewById(2131755282))).setVisibility(8);
    ((View)a.d.a(findViewById(2131755283))).setVisibility(8);
    ((View)a.d.a(findViewById(2131755284))).setVisibility(8);
    Object localObject = com.whatsapp.util.l.b(this, this.aF, u()).toString();
    ((TextView)a.d.a((TextView)findViewById(2131755269))).setText(getString(2131297115, new Object[] { localObject }));
    if (this.s == null) {
      this.s = ((GoogleDriveRestoreAnimationView)findViewById(2131755273));
    }
    bu.a(an.a(this, (String)localObject));
    localObject = (TextView)a.d.a((TextView)findViewById(2131755270));
    if (vv.i()) {}
    for (int i = 2131297630;; i = 2131297852)
    {
      ((TextView)localObject).setText(i);
      ((Button)a.d.a((Button)findViewById(2131755281))).setOnClickListener(h.a(this));
      ((Button)a.d.a((Button)findViewById(2131755280))).setOnClickListener(i.a(this));
      return;
    }
  }
  
  final void r()
  {
    a.d.b();
    Log.i("gdrive-activity/show-msgstore-downloading-view");
    ((View)a.d.a(findViewById(2131755279))).setVisibility(8);
    ((View)a.d.a(findViewById(2131755270))).setVisibility(8);
    ((View)a.d.a(findViewById(2131755282))).setVisibility(8);
    ((View)a.d.a(findViewById(2131755273))).setVisibility(0);
    this.q = ((ProgressBar)findViewById(2131755274));
    this.r = ((TextView)findViewById(2131755275));
    this.q.setVisibility(0);
    this.q.setIndeterminate(true);
    d.a(this.q, getResources().getColor(2131624069));
    this.r.setVisibility(0);
    this.V = ((TextView)findViewById(2131755278));
    if (this.W == 0L) {
      this.W = this.H.a.getLong("gdrive_approx_media_download_size", 0L);
    }
    if (this.W > 0L)
    {
      String str = com.whatsapp.util.be.a(this, this.W);
      this.V.setText(getString(2131296285, new Object[] { str }));
      this.V.setVisibility(0);
    }
  }
  
  final Account[] s()
  {
    try
    {
      Account[] arrayOfAccount = AccountManager.get(this).getAccountsByType("com.google");
      return arrayOfAccount;
    }
    catch (Exception localException)
    {
      Log.d("gdrive-activity/get-google-accounts", localException);
    }
    return new Account[0];
  }
  
  public final void setTitle(int paramInt)
  {
    ((TextView)a.d.a((TextView)findViewById(2131755265))).setText(paramInt);
  }
  
  static final class a
  {
    final String a;
    final bb b;
    final bb c;
    final bc d;
    final at e;
    final long f;
    final long g;
    final boolean h;
    final boolean i;
    
    private a(String paramString, bb parambb1, bb parambb2, bc parambc, at paramat, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.a = paramString;
      this.b = parambb1;
      this.c = parambb2;
      this.d = parambc;
      this.e = paramat;
      this.f = paramLong1;
      this.g = paramLong2;
      this.h = paramBoolean1;
      this.i = paramBoolean2;
    }
    
    public final String toString()
    {
      return String.format(Locale.ENGLISH, "Account:%s primaryBaseFolder:%s secondaryBaseFolder:%s overwriteLocalFile:%b isDownloadSizeZero:%b lastModified:%s totalBackupSize: %d", new Object[] { ch.a(this.a), this.b, this.c, Boolean.valueOf(this.h), Boolean.valueOf(this.i), Long.valueOf(this.f), Long.valueOf(this.g) });
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gdrive/GoogleDriveActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */