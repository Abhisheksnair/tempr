package com.whatsapp;

import a.a.a.a.a.a.d;
import a.a.a.a.d;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.whatsapp.data.ad;
import com.whatsapp.data.ci;
import com.whatsapp.data.cq;
import com.whatsapp.data.cs;
import com.whatsapp.data.s;
import com.whatsapp.fieldstats.events.bo;
import com.whatsapp.j.a.a;
import com.whatsapp.location.bp;
import com.whatsapp.messaging.aj;
import com.whatsapp.messaging.w;
import com.whatsapp.notification.f;
import com.whatsapp.protocol.ah;
import com.whatsapp.protocol.aw;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils;
import com.whatsapp.util.MediaFileUtils.e;
import com.whatsapp.util.af;
import com.whatsapp.util.bu;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class aoj
{
  private static volatile aoj v;
  private final and A;
  private final mf B;
  private final vv C;
  private final atv D;
  private final ka E;
  private final rh F;
  private final ah G;
  private PowerManager.WakeLock H;
  public final Context a;
  public final ant b;
  final pv c;
  public final va d;
  final vp e;
  public final ad f;
  final com.whatsapp.data.e g;
  final com.whatsapp.messaging.m h;
  final aj i;
  final abu j;
  final rk k;
  final cc l;
  final vx m;
  final f n;
  public final atu o;
  final lt p;
  final hx q;
  final vs r;
  public final cq s;
  public final bp t;
  public final ci u;
  private final oz w;
  private final w x;
  private final aic y;
  private final com.whatsapp.l.e z;
  
  private aoj(Context paramContext, ant paramant, pv parampv, va paramva, oz paramoz, w paramw, aic paramaic, vp paramvp, ad paramad, com.whatsapp.l.e parame, com.whatsapp.data.e parame1, com.whatsapp.messaging.m paramm, and paramand, aj paramaj, mf parammf, abu paramabu, rk paramrk, cc paramcc, vv paramvv, vx paramvx, f paramf, atu paramatu, atv paramatv, lt paramlt, hx paramhx, vs paramvs, cq paramcq, bp parambp, ka paramka, ci paramci, rh paramrh, ah paramah)
  {
    this.a = paramContext;
    this.b = paramant;
    this.c = parampv;
    this.d = paramva;
    this.w = paramoz;
    this.x = paramw;
    this.y = paramaic;
    this.e = paramvp;
    this.f = paramad;
    this.z = parame;
    this.g = parame1;
    this.h = paramm;
    this.A = paramand;
    this.i = paramaj;
    this.B = parammf;
    this.j = paramabu;
    this.k = paramrk;
    this.l = paramcc;
    this.C = paramvv;
    this.m = paramvx;
    this.n = paramf;
    this.o = paramatu;
    this.D = paramatv;
    this.p = paramlt;
    this.q = paramhx;
    this.r = paramvs;
    this.s = paramcq;
    this.t = parambp;
    this.E = paramka;
    this.u = paramci;
    this.F = paramrh;
    this.G = paramah;
  }
  
  public static aoj a()
  {
    if (v == null) {}
    try
    {
      if (v == null) {
        v = new aoj(u.a(), ant.a(), pv.a(), va.a(), oz.a(), w.a(), aic.a(), vp.a(), ad.a(), com.whatsapp.l.e.a(), com.whatsapp.data.e.a(), com.whatsapp.messaging.m.a(), and.a(), aj.a(), mf.a(), abu.a(), rk.a(), cc.a(), vv.a(), vx.a(), f.a(), atu.a(), atv.a(), lt.a(), hx.a(), vs.a(), cq.a(), bp.a(), ka.a(), ci.a(), rh.a(), ah.a());
      }
      return v;
    }
    finally {}
  }
  
  public static String e(j paramj)
  {
    if (TextUtils.isEmpty(paramj.r))
    {
      MediaData localMediaData = paramj.b();
      if ((localMediaData != null) && (localMediaData.file != null)) {}
      switch (paramj.s)
      {
      default: 
        switch (paramj.s)
        {
        default: 
          return "*/*";
        }
      case 3: 
      case 13: 
        return af.a(localMediaData.file);
      }
      return af.a(af.f(localMediaData.file));
    }
    return paramj.r;
    return "audio/*";
    return "video/*";
    return "image/jpeg";
  }
  
  public final void a(Activity paramActivity, j paramj)
  {
    Object localObject = paramj.b();
    if ((((MediaData)localObject).file == null) || (!((MediaData)localObject).file.exists()))
    {
      Log.w("app/share/media-does-not-exist");
      pv.a(this.a, vv.h(), 0);
      return;
    }
    localObject = this.a;
    int i1;
    switch (paramj.s)
    {
    default: 
      i1 = 2131297837;
    }
    for (;;)
    {
      localObject = ((Context)localObject).getString(i1, new Object[] { this.D.l() });
      String str1 = paramj.z;
      String str2 = e(paramj);
      paramj = MediaProvider.a(paramj);
      Intent localIntent = new Intent("android.intent.action.SEND");
      localIntent.setType(str2);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localIntent.putExtra("android.intent.extra.SUBJECT", (String)localObject);
      }
      if (!TextUtils.isEmpty(str1)) {
        localIntent.putExtra("android.intent.extra.TEXT", str1);
      }
      localIntent.putExtra("android.intent.extra.STREAM", paramj);
      paramj = Intent.createChooser(localIntent, null);
      paramj.setFlags(1);
      pv.a(paramActivity, paramj);
      return;
      i1 = 2131297835;
      continue;
      i1 = 2131297838;
      continue;
      i1 = 2131297840;
      continue;
      i1 = 2131297839;
      continue;
      i1 = 2131297836;
    }
  }
  
  public final void a(ahx paramahx, j paramj, List<String> paramList)
  {
    Object localObject;
    if ((paramj.s == 1) && (paramj.b() != null))
    {
      localObject = paramj.b();
      if (((MediaData)localObject).file == null) {}
    }
    try
    {
      int i1 = MediaFileUtils.c(((MediaData)localObject).file.getAbsolutePath());
      if ((i1 != 1) && (i1 != 0))
      {
        localObject = Uri.fromFile(((MediaData)localObject).file);
        Log.i("sendmedia/send-image uri:" + localObject + " jids:" + Arrays.deepToString(paramList.toArray()));
        paramahx.a(paramList, (Uri)localObject, 3, null, yr.a(((Uri)localObject).getQueryParameter("mentions")), ((Uri)localObject).getQueryParameter("caption"), false);
        return;
      }
    }
    catch (OutOfMemoryError paramahx)
    {
      for (;;)
      {
        Log.d("userActionForwardMessage", paramahx);
        if (!com.whatsapp.protocol.m.b(paramj))
        {
          this.c.b(this.a, this.a.getString(2131297173), 1);
          return;
        }
        Log.d("userActionForwardMessage/forwarding message; message.key=" + paramj.e);
        if ((paramj.N instanceof MediaData))
        {
          localObject = new MediaData(paramj.b());
          boolean bool;
          ArrayList localArrayList;
          String str1;
          Iterator localIterator;
          if ((paramj.s == 5) || (paramj.s == 16))
          {
            bool = true;
            ((MediaData)localObject).transferred = bool;
            ((MediaData)localObject).forward = true;
            localArrayList = new ArrayList(paramList.size());
            if (paramList.size() <= 1) {
              break label712;
            }
            str1 = this.e.b();
            localIterator = null;
            paramahx = localIterator;
            if (com.whatsapp.protocol.l.a(paramj.s))
            {
              paramahx = localIterator;
              if (paramj.m == 0)
              {
                paramahx = localIterator;
                if (paramj.d())
                {
                  paramahx = localIterator;
                  if (paramj.e().length() <= 0) {}
                }
              }
            }
          }
          try
          {
            paramahx = Base64.decode(paramj.e(), 0);
            localIterator = paramList.iterator();
            for (;;)
            {
              if (!localIterator.hasNext()) {
                break label786;
              }
              String str2 = (String)localIterator.next();
              if (localObject != null) {
                break;
              }
              paramList = null;
              if (paramList != null) {
                paramList.forward = true;
              }
              localj = new j(this.d, str2, paramList);
              localj.n = this.b.b();
              localj.W = str1;
              if (!com.whatsapp.protocol.m.a(paramj.s)) {
                break label741;
              }
              localj.d = 1;
              localj.m = paramj.m;
              if (!com.whatsapp.protocol.m.a(paramj.s)) {
                localj.p = paramj.p;
              }
              localj.s = paramj.s;
              localj.r = paramj.r;
              localj.t = paramj.t;
              localj.y = paramj.y;
              localj.w = paramj.w;
              localj.x = paramj.x;
              if (paramj.s != 0) {
                break label750;
              }
              localj.z = paramj.z;
              localj.N = paramj.N;
              localj.u = paramj.u;
              localj.B = paramj.B;
              localj.C = paramj.C;
              if (paramj.P != null) {
                break label771;
              }
              paramList = null;
              localj.P = paramList;
              localj.o = 3;
              if ((localj.s == 0) && (j.c(str2)))
              {
                paramList = new TextData();
                paramList.backgroundColor = TextStatusComposerActivity.l();
                paramList.textColor = -1;
                paramList.fontStyle = 0;
                localj.N = paramList;
                amt.a().a(localj, 0, 1);
              }
              d(localj);
              if (!com.whatsapp.protocol.l.a(paramj.s))
              {
                localj.a(paramj.h());
                localj.m = paramj.m;
              }
              localArrayList.add(localj);
              bu.a(aov.a(this, str2));
            }
            bool = false;
            break label236;
            str1 = null;
          }
          catch (ArrayIndexOutOfBoundsException paramahx)
          {
            for (;;)
            {
              j localj;
              Log.d("userActionForwardMessage/base64-decode/error", paramahx);
              paramahx = localIterator;
              continue;
              paramList = ((MediaData)localObject).createSerializableCopy();
              continue;
              localj.d = 0;
              continue;
              if (paramj.s == 9)
              {
                localj.z = paramj.z;
                continue;
                paramList = new ArrayList(paramj.P);
              }
            }
            if (com.whatsapp.protocol.m.a(paramj.s))
            {
              a(new aoi(localArrayList), paramahx, paramj);
              return;
            }
            if (paramahx != null)
            {
              paramj = localArrayList.iterator();
              while (paramj.hasNext())
              {
                paramList = (j)paramj.next();
                paramList.f().a(paramahx);
                this.f.b(paramList, -1);
              }
            }
            if (com.whatsapp.protocol.l.a(paramj.s))
            {
              this.G.a(paramj.f(), aox.a(this, localArrayList, paramj));
              return;
            }
            paramahx = localArrayList.iterator();
            while (paramahx.hasNext())
            {
              paramj = (j)paramahx.next();
              this.f.b(paramj, -1);
            }
          }
          catch (IllegalArgumentException paramahx)
          {
            for (;;) {}
          }
          catch (StringIndexOutOfBoundsException paramahx)
          {
            for (;;) {}
          }
        }
      }
    }
    catch (IOException paramahx)
    {
      for (;;) {}
    }
    catch (SecurityException paramahx)
    {
      for (;;) {}
    }
    catch (MediaFileUtils.e paramahx)
    {
      for (;;)
      {
        label236:
        label712:
        label741:
        label750:
        label771:
        label786:
        continue;
        localObject = null;
      }
    }
  }
  
  final void a(aoi paramaoi, boolean paramBoolean)
  {
    this.c.a(apa.a(this, paramaoi, paramBoolean));
  }
  
  public final void a(aoi paramaoi, byte[] paramArrayOfByte, j paramj)
  {
    boolean bool = MediaFileUtils.a(this.w, paramaoi.n());
    if ((bool) && (!MediaFileUtils.a(paramaoi.n())))
    {
      pv.a(this.a, 2131297842, 0);
      return;
    }
    paramaoi.a(new aoy(this, paramaoi));
    if (paramArrayOfByte != null) {
      com.whatsapp.protocol.l.a(paramaoi.o(), paramArrayOfByte);
    }
    while ((paramj == null) || (!com.whatsapp.protocol.l.a(paramj.s)))
    {
      a(paramaoi, bool);
      return;
    }
    this.G.a(paramj.f(), aoz.a(this, paramaoi, paramj, bool));
  }
  
  public final void a(final nh paramnh, j paramj)
  {
    vv.a local1 = new vv.a()
    {
      public final void a()
      {
        nh localnh;
        if (!paramnh.isFinishing())
        {
          localnh = paramnh;
          if (!vv.i()) {
            break label36;
          }
        }
        label36:
        for (int i = 2131296558;; i = 2131296559)
        {
          localnh.a(2131296692, i, new Object[0]);
          return;
        }
      }
      
      public final void b()
      {
        nh localnh;
        if (!paramnh.isFinishing())
        {
          localnh = paramnh;
          if (!vv.i()) {
            break label36;
          }
        }
        label36:
        for (int i = 2131296556;; i = 2131296557)
        {
          localnh.a(2131296692, i, new Object[0]);
          return;
        }
      }
      
      public final void c()
      {
        RequestPermissionActivity.b(paramnh, 2131297431, 2131297430);
      }
      
      public final void d()
      {
        RequestPermissionActivity.b(paramnh, 2131297431, 2131297430);
      }
    };
    if (this.C.a(local1))
    {
      paramnh = vk.a(this.w, this.f, this.z, paramj, vk.a.a, paramnh);
      if (paramnh != null) {
        bu.a(paramnh, new Void[0]);
      }
    }
  }
  
  public final void a(j paramj)
  {
    a(new aoi(Collections.singletonList(paramj)), null, null);
  }
  
  public final void a(j paramj, byte[] paramArrayOfByte)
  {
    a(new aoi(Collections.singletonList(paramj)), paramArrayOfByte, null);
  }
  
  public final void a(String paramString)
  {
    if (cs.e(paramString)) {}
    while (this.d.a(paramString)) {
      return;
    }
    boolean bool = this.j.b(paramString);
    rk localrk = this.k;
    Handler localHandler = localrk.b;
    if (bool) {}
    for (int i1 = 1;; i1 = 0)
    {
      localHandler.obtainMessage(1, i1, 0, localrk.a(paramString)).sendToTarget();
      return;
    }
  }
  
  public final void a(String paramString, int paramInt)
  {
    if (cs.e(paramString)) {}
    do
    {
      return;
      if (qz.e(paramString)) {
        this.j.a(this.g.d(paramString));
      }
    } while (this.d.a(paramString));
    boolean bool = this.j.b(paramString);
    rk localrk = this.k;
    Handler localHandler = localrk.b;
    if (bool) {}
    for (int i1 = 1;; i1 = 0)
    {
      localHandler.obtainMessage(0, i1, paramInt, localrk.a(paramString)).sendToTarget();
      return;
    }
  }
  
  public final void a(String paramString, Location paramLocation, j paramj, boolean paramBoolean)
  {
    j localj = new j(this.d, paramString, new MediaData());
    localj.n = this.b.b();
    localj.m = 1;
    localj.s = 5;
    localj.d = 1;
    if (paramLocation != null)
    {
      localj.B = paramLocation.getLatitude();
      localj.C = paramLocation.getLongitude();
    }
    localj.a(paramj, this.s);
    localj.a(paramBoolean, false);
    d(localj);
    this.f.b(localj, 2);
    bu.a(aol.a(this, this.a.getContentResolver(), paramString));
    paramString = new com.whatsapp.location.ce(this.a, this.f, this.o, this.t, this.u, localj);
    paramString.e = com.whatsapp.location.ce.f;
    bu.a(paramString, new Void[0]);
  }
  
  public final void a(String paramString, aw paramaw)
  {
    if (this.h.d) {
      this.h.a(Message.obtain(null, 0, 3, 0, Pair.create(paramString, paramaw)));
    }
  }
  
  public final void a(String paramString1, String paramString2, aw paramaw)
  {
    
    ArrayList localArrayList;
    Object localObject;
    String str1;
    String str2;
    if (this.h.d)
    {
      localArrayList = this.f.u(paramString1);
      localObject = this.g.c(paramString1);
      if ((localObject == null) || (!((cs)localObject).d())) {
        break label104;
      }
      str1 = ((cs)localObject).q();
      str2 = this.f.i(paramString1);
      localObject = ((cs)localObject).e;
    }
    for (;;)
    {
      this.h.a(Message.obtain(null, 0, 98, 0, new com.whatsapp.messaging.ce(localArrayList, paramString1, str1, str2, (String)localObject, paramString2, paramaw)));
      return;
      label104:
      localObject = null;
      str2 = null;
      str1 = null;
    }
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, j paramj, boolean paramBoolean)
  {
    a(Collections.singletonList(paramString1), paramString2, paramString3, paramj, paramBoolean);
  }
  
  public final void a(String paramString, List<String> paramList, j paramj, boolean paramBoolean)
  {
    a(Collections.singletonList(paramString), paramList, paramj, paramBoolean);
  }
  
  public final void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    pb.a(24);
    cs localcs = this.g.c(paramString);
    this.n.b(paramString, null);
    Object localObject1;
    if (paramBoolean1)
    {
      localObject1 = this.f;
      Log.i("msgstore/deletemsgs/synchronously/jid " + paramString);
      Message.obtain(((ad)localObject1).p.e, 1, paramString).sendToTarget();
      ahe.a("deletemsgs");
      ((ad)localObject1).m(paramString);
      Message.obtain(((ad)localObject1).p.e, 2, paramString).sendToTarget();
      ahe.b("deletemsgs");
      if (localcs != null)
      {
        Object localObject2;
        if ((localcs.d()) || (j.b(localcs.t)))
        {
          localObject1 = this.a;
          localObject2 = d.a((Context)localObject1, localcs, false, false);
          ((Intent)localObject2).setAction("com.android.launcher.action.UNINSTALL_SHORTCUT");
          ((Context)localObject1).sendBroadcast((Intent)localObject2);
        }
        if (localcs.d())
        {
          localObject1 = this.l;
          localObject2 = ((cc)localObject1).a(paramString);
          if (!((cc.a)localObject2).e) {
            break label371;
          }
          ((cc.a)localObject2).b = System.currentTimeMillis();
          ContentValues localContentValues = new ContentValues(1);
          localContentValues.put("deleted", Long.valueOf(((cc.a)localObject2).b));
          ((cc)localObject1).c().getWritableDatabase().update("settings", localContentValues, "jid = ?", new String[] { paramString });
        }
      }
    }
    for (;;)
    {
      if (this.l.c(paramString)) {
        this.c.a(aos.a(this, paramString));
      }
      this.E.a(this.f, this.n, localcs.t);
      this.n.b();
      if ((localcs.d == null) || (localcs.d()) || (j.b(localcs.t))) {
        this.B.a(aot.a(this, localcs));
      }
      if (paramBoolean2) {
        this.i.a(2, paramString, 0L, 0);
      }
      return;
      this.f.l(paramString);
      break;
      label371:
      ((cc)localObject1).a.remove(paramString);
      ((cc)localObject1).c().getWritableDatabase().delete("settings", "jid = ?", new String[] { paramString });
    }
  }
  
  public final void a(Collection<j> paramCollection, boolean paramBoolean)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      j localj = (j)paramCollection.next();
      if ((localj.e.b) && (localj.s != 15))
      {
        if (j.c(localj.e.a))
        {
          localObject = amt.a();
          bo localbo = new bo();
          localbo.a = Long.valueOf(((amt)localObject).c());
          localbo.b = Integer.valueOf(d.a(localj));
          localbo.c = Long.valueOf(((amt)localObject).a.b() - localj.n);
          com.whatsapp.fieldstats.l.a(((amt)localObject).b, localbo);
        }
        Object localObject = new j(this.d, localj.e.a);
        ((j)localObject).n = localj.n;
        ((j)localObject).s = 15;
        ((j)localObject).y = localj.e.c;
        ((j)localObject).f = localj.f;
        ((j)localObject).ab = 7;
        this.f.a((j)localObject, paramBoolean);
      }
    }
  }
  
  public final void a(List<String> paramList1, String paramString, auf paramauf, j paramj, List<String> paramList2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramList1.size() > 1) {}
    for (String str1 = this.e.b();; str1 = null)
    {
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        String str2 = (String)paramList1.next();
        j localj = new j(this.d, str2, paramString);
        localj.n = this.b.b();
        localj.W = str1;
        localj.a(paramj, this.s);
        d(localj);
        if ((paramauf != null) && (paramauf.c()))
        {
          localj.z = paramauf.b;
          localj.y = paramauf.c;
          localj.N = paramauf.g;
          localj.p = paramauf.d;
        }
        if ((paramList2 != null) && (!paramList2.isEmpty())) {
          localj.P = paramList2;
        }
        localj.a(paramBoolean1, paramBoolean2);
        if (j.c(str2))
        {
          TextData localTextData = new TextData();
          localTextData.backgroundColor = TextStatusComposerActivity.l();
          localTextData.textColor = -1;
          localTextData.fontStyle = 0;
          localj.N = localTextData;
          amt.a().a(localj, 0, 1);
        }
        this.f.b(localj, -1);
        bu.a(aok.a(this, str2));
      }
    }
  }
  
  public final void a(List<String> paramList, String paramString1, String paramString2, j paramj, boolean paramBoolean)
  {
    if (paramList.size() > 1) {}
    for (String str1 = this.e.b();; str1 = null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str2 = (String)paramList.next();
        j localj = new j(this.d, str2, paramString2);
        localj.n = this.b.b();
        localj.m = 0;
        localj.s = 4;
        localj.y = paramString1;
        localj.a(paramj, this.s);
        localj.W = str1;
        localj.a(paramBoolean, false);
        d(localj);
        this.f.b(localj, -1);
        bu.a(apc.a(this, str2));
      }
    }
  }
  
  public final void a(List<String> paramList1, List<String> paramList2, j paramj, boolean paramBoolean)
  {
    String str1;
    if (paramList1.size() > 1) {
      str1 = this.e.b();
    }
    for (;;)
    {
      paramList1 = paramList1.iterator();
      label26:
      if (paramList1.hasNext())
      {
        String str2 = (String)paramList1.next();
        j localj = new j(this.d, str2, "");
        localj.n = this.b.b();
        localj.s = 14;
        localj.y = u.a.a(2131230769, paramList2.size(), new Object[] { Integer.valueOf(paramList2.size()) });
        localj.a(paramj, this.s);
        localj.W = str1;
        localj.a(paramBoolean, false);
        try
        {
          ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
          new ObjectOutputStream(localByteArrayOutputStream).writeObject(paramList2);
          localj.a(localByteArrayOutputStream.toByteArray());
          d(localj);
          this.f.b(localj, -1);
          bu.a(apb.a(this, str2));
          break label26;
          str1 = null;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            localj.a(null);
          }
        }
      }
    }
  }
  
  final PowerManager.WakeLock b()
  {
    PowerManager localPowerManager;
    if (this.H == null)
    {
      localPowerManager = this.A.a;
      if (localPowerManager != null) {
        break label30;
      }
      Log.w("useractions/get-web-wakelock pm=null");
    }
    for (;;)
    {
      return this.H;
      label30:
      this.H = localPowerManager.newWakeLock(1, "Web Client");
      this.H.setReferenceCounted(false);
    }
  }
  
  public final void b(j paramj)
  {
    if (!com.whatsapp.protocol.m.a(paramj.s)) {}
    for (boolean bool = true;; bool = false)
    {
      a.d.a(bool);
      this.x.a(paramj, false, 0L);
      this.f.f(paramj, -1);
      return;
    }
  }
  
  public final void b(String paramString, int paramInt)
  {
    Object localObject = b();
    if (localObject != null) {
      ((PowerManager.WakeLock)localObject).acquire(30000L);
    }
    if (cs.e(paramString)) {}
    do
    {
      return;
      if (qz.e(paramString)) {
        this.j.a(this.g.d(paramString));
      }
    } while (this.d.a(paramString));
    boolean bool = this.j.b(paramString);
    localObject = this.k;
    Handler localHandler = ((rk)localObject).b;
    if (bool) {}
    for (int i1 = 1;; i1 = 0)
    {
      localHandler.obtainMessage(3, i1, paramInt, ((rk)localObject).a(paramString)).sendToTarget();
      return;
    }
  }
  
  public final void c(j paramj)
  {
    bu.a(new com.whatsapp.location.ce(this.a, this.f, this.o, this.t, this.u, paramj), new Void[0]);
  }
  
  public final void d(j paramj)
  {
    if (j.c(paramj.e.a)) {
      paramj.f = "";
    }
    for (;;)
    {
      if (paramj.V != null) {
        paramj.V.V = null;
      }
      return;
      if (j.b(paramj.e.a))
      {
        paramj.E = true;
        Object localObject = this.F.a(paramj.e.a);
        StringBuilder localStringBuilder = new StringBuilder();
        localObject = ((rg)localObject).a().iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          if (localStringBuilder.length() > 0) {
            localStringBuilder.append(",");
          }
          localStringBuilder.append(str);
        }
        paramj.D = this.g.a(paramj.e.a).e;
        paramj.f = localStringBuilder.toString();
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/aoj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */