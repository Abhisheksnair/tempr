package com.whatsapp.data;

import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import android.os.SystemClock;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.RawContacts;
import android.support.design.widget.AppBarLayout.b;
import android.text.TextUtils;
import android.util.Base64;
import com.google.protobuf.q;
import com.whatsapp.a.a;
import com.whatsapp.and;
import com.whatsapp.ant;
import com.whatsapp.atu;
import com.whatsapp.atv;
import com.whatsapp.contact.ContactProvider;
import com.whatsapp.dh;
import com.whatsapp.g.n;
import com.whatsapp.lt;
import com.whatsapp.messaging.aj;
import com.whatsapp.messaging.w;
import com.whatsapp.proto.c.b;
import com.whatsapp.protocol.z;
import com.whatsapp.pv;
import com.whatsapp.qz;
import com.whatsapp.u;
import com.whatsapp.util.Log;
import com.whatsapp.util.bu;
import com.whatsapp.va;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import org.whispersystems.a.m;

public class e
{
  private static volatile e d;
  private static a o;
  public final Map<String, cs> a = Collections.synchronizedMap(new HashMap());
  public final ct b;
  public final Map<String, Long> c = Collections.synchronizedMap(new HashMap());
  private final ant e;
  private final pv f;
  private final va g;
  private final w h;
  private final aj i;
  private final dh j;
  private final r k;
  private final atu l;
  private final atv m;
  private final lt n;
  
  private e(ant paramant, pv parampv, va paramva, w paramw, aj paramaj, dh paramdh, r paramr, atu paramatu, atv paramatv, lt paramlt, ct paramct)
  {
    this.e = paramant;
    this.f = parampv;
    this.g = paramva;
    this.h = paramw;
    this.i = paramaj;
    this.j = paramdh;
    this.k = paramr;
    this.l = paramatu;
    this.m = paramatv;
    this.n = paramlt;
    this.b = paramct;
  }
  
  public static e a()
  {
    if (d == null) {}
    try
    {
      if (d == null) {
        d = new e(ant.a(), pv.a(), va.a(), w.a(), aj.a(), dh.a(), r.a(), atu.a(), atv.a(), lt.a(), new ct(u.a(), ant.a(), va.a(), and.a()));
      }
      return d;
    }
    finally {}
  }
  
  public static a b()
  {
    if ((o == null) || (!o.t.equals("0@s.whatsapp.net"))) {
      o = new a();
    }
    return o;
  }
  
  public static boolean b(String paramString)
  {
    return b().t.equals(paramString);
  }
  
  public final cs a(Uri paramUri)
  {
    cs localcs1 = null;
    Object localObject2;
    long l1;
    synchronized (this.a)
    {
      localObject2 = this.a.values().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        cs localcs2 = (cs)((Iterator)localObject2).next();
        if (paramUri.equals(localcs2.o())) {
          return localcs2;
        }
      }
      ??? = this.b;
      l1 = System.currentTimeMillis();
      localObject2 = ((ct)???).c.a(paramUri, cs.b, null, null, null);
      if (localObject2 == null)
      {
        Log.e("unable to get contact by uri " + paramUri);
        return null;
      }
    }
    if (((Cursor)localObject2).moveToNext()) {
      localcs1 = cs.b((Cursor)localObject2);
    }
    int i1 = ((Cursor)localObject2).getCount();
    ((Cursor)localObject2).close();
    ((ct)???).d(localcs1);
    Log.i("fetched " + i1 + " contacts by uri=" + paramUri + ' ' + localcs1 + " | time: " + (System.currentTimeMillis() - l1));
    return localcs1;
  }
  
  public final cs a(cs.a parama)
  {
    cs localcs1 = null;
    Object localObject2;
    long l1;
    synchronized (this.a)
    {
      localObject2 = this.a.values().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        cs localcs2 = (cs)((Iterator)localObject2).next();
        if (parama.equals(localcs2.d)) {
          return localcs2;
        }
      }
      ??? = this.b;
      l1 = System.currentTimeMillis();
      localObject2 = ((ct)???).c.a(ContactProvider.a, cs.b, "raw_contact_id = ? AND number = ?", new String[] { String.valueOf(parama.a), parama.b }, null);
      if (localObject2 == null)
      {
        Log.e("unable to get contact by key " + parama);
        return null;
      }
    }
    if (((Cursor)localObject2).moveToNext()) {
      localcs1 = cs.b((Cursor)localObject2);
    }
    int i1 = ((Cursor)localObject2).getCount();
    ((Cursor)localObject2).close();
    ((ct)???).d(localcs1);
    Log.i("fetched " + i1 + " contacts by key=" + parama + ' ' + localcs1 + " | time: " + (System.currentTimeMillis() - l1));
    return localcs1;
  }
  
  public final cs a(String paramString)
  {
    Object localObject;
    if (!qz.e(paramString)) {
      localObject = d(paramString);
    }
    cs localcs;
    label90:
    do
    {
      do
      {
        do
        {
          return (cs)localObject;
          localcs = e(paramString);
          if (localcs == null) {
            break label90;
          }
          if (localcs.h()) {
            break;
          }
          localObject = localcs;
        } while (!TextUtils.isEmpty(localcs.g));
        localObject = localcs;
      } while (cs.d(localcs.t));
      Log.e("conversation/sendgetGroupInfo: " + localcs.t);
      this.h.d(paramString, null);
      return localcs;
      Log.e("convmgr/getconversationcontact/groupchat/create-contact " + paramString);
      localcs = new cs(paramString);
      a(localcs);
      localObject = localcs;
    } while (cs.d(paramString));
    this.h.d(paramString, null);
    return localcs;
  }
  
  public final cs a(String paramString1, String paramString2, long paramLong)
  {
    Log.i("addGroupChatContact");
    paramString1 = new cs(paramString1);
    paramString1.e = paramString2;
    paramString1.g = Long.toString(paramLong);
    paramString2 = this.b;
    paramLong = System.currentTimeMillis();
    if (paramString1.t == null)
    {
      Log.w("unable to add group chat with null jid");
      return paramString1;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("jid", paramString1.t);
    localContentValues.put("is_whatsapp_user", Boolean.valueOf(true));
    localContentValues.put("status", paramString1.u);
    localContentValues.put("status_timestamp", Long.valueOf(paramString1.v));
    localContentValues.put("display_name", paramString1.e);
    localContentValues.put("phone_label", paramString1.g);
    try
    {
      paramString1.c = ContentUris.parseId(paramString2.c.a(ContactProvider.a, localContentValues));
      Log.i("group chat added: " + paramString1 + " | time: " + (System.currentTimeMillis() - paramLong));
      return paramString1;
    }
    catch (IllegalArgumentException paramString2)
    {
      for (;;)
      {
        Log.e("unable to add group chat " + paramString1 + ' ' + paramString2);
      }
    }
  }
  
  public final ArrayList<cs> a(int paramInt)
  {
    ArrayList localArrayList1 = this.n.j();
    ArrayList localArrayList2 = new ArrayList(Math.min(localArrayList1.size(), paramInt));
    int i1 = 0;
    while ((i1 < localArrayList1.size()) && (localArrayList2.size() < paramInt))
    {
      cs localcs = a((String)localArrayList1.get(i1));
      if ((localcs != null) && (!TextUtils.isEmpty(localcs.e))) {
        localArrayList2.add(localcs);
      }
      i1 += 1;
    }
    return localArrayList2;
  }
  
  public final void a(ContentResolver paramContentResolver, String paramString)
  {
    if ((cs.e(paramString)) || (qz.e(paramString))) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (!this.l.d());
        localObject = c(paramString);
      } while ((localObject == null) || (((cs)localObject).d == null) || (((cs)localObject).d.a <= 0L));
      paramString = ContactsContract.RawContacts.CONTENT_URI;
      Object localObject = Long.toString(((cs)localObject).d.a);
      paramString = paramContentResolver.query(paramString, new String[] { "contact_id" }, "_id=?", new String[] { localObject }, null);
    } while (paramString == null);
    try
    {
      if (paramString.moveToNext()) {
        ContactsContract.Contacts.markAsContacted(paramContentResolver, paramString.getLong(0));
      }
      return;
    }
    finally
    {
      paramString.close();
    }
  }
  
  public final void a(cs paramcs)
  {
    this.b.a(paramcs);
  }
  
  public final void a(String paramString1, long paramLong, String paramString2)
  {
    this.b.a(paramString1, paramLong, paramString2);
    f(paramString1);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    paramString1 = d(paramString1);
    paramString1.e = paramString2;
    this.b.b(paramString1);
    g(paramString1);
  }
  
  public final void a(ArrayList<cs> paramArrayList)
  {
    Object localObject = this.b;
    if (paramArrayList.isEmpty()) {
      Log.i("delete contacts called without any contacts");
    }
    for (;;)
    {
      paramArrayList = paramArrayList.iterator();
      long l1;
      ArrayList localArrayList;
      while (paramArrayList.hasNext())
      {
        localObject = (cs)paramArrayList.next();
        ((cs)localObject).l();
        ((cs)localObject).m();
        f(((cs)localObject).t);
        continue;
        l1 = System.currentTimeMillis();
        localArrayList = new ArrayList(paramArrayList.size() << 1);
        Iterator localIterator = paramArrayList.iterator();
        while (localIterator.hasNext()) {
          ct.a((cs)localIterator.next(), localArrayList);
        }
      }
      try
      {
        ((ct)localObject).c.a(localArrayList);
        Log.i("deleted contacts | time: " + (System.currentTimeMillis() - l1));
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          Log.d("unable to delete contacts " + paramArrayList, localIllegalArgumentException);
        }
      }
      catch (RemoteException paramArrayList)
      {
        throw new RuntimeException(paramArrayList);
        return;
      }
      catch (OperationApplicationException paramArrayList)
      {
        for (;;) {}
      }
    }
  }
  
  public final void a(Collection<cs> paramCollection)
  {
    ct localct = this.b;
    if (paramCollection.isEmpty())
    {
      Log.i("add contacts called without any contacts");
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = SystemClock.elapsedRealtime();
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    Iterator localIterator1 = paramCollection.iterator();
    int i1 = 0;
    cs localcs;
    while (localIterator1.hasNext())
    {
      localcs = (cs)localIterator1.next();
      if (TextUtils.isEmpty(localcs.t))
      {
        Log.i("skipped adding contact due to empty jid: " + localcs);
      }
      else
      {
        if (!localcs.h) {
          break label575;
        }
        i1 += 1;
      }
    }
    label575:
    for (;;)
    {
      localArrayList.add(ContentProviderOperation.newInsert(ContactProvider.a).withYieldAllowed(true).withValue("jid", localcs.t).withValue("is_whatsapp_user", Boolean.valueOf(localcs.h)).withValue("status", localcs.u).withValue("status_timestamp", Long.valueOf(localcs.v)).withValue("number", localcs.d.b).withValue("raw_contact_id", Long.valueOf(localcs.d.a)).withValue("display_name", localcs.e).withValue("phone_type", localcs.f).withValue("phone_label", localcs.g).withValue("given_name", localcs.o).withValue("family_name", localcs.p).withValue("sort_name", localcs.r).withValue("nickname", localcs.w).withValue("company", localcs.x).withValue("title", localcs.y).withValue("is_spam_reported", Boolean.valueOf(localcs.F)).build());
      Iterator localIterator2 = localcs.p().values().iterator();
      while (localIterator2.hasNext())
      {
        AppBarLayout.b localb = (AppBarLayout.b)localIterator2.next();
        localArrayList.add(ContentProviderOperation.newInsert(ContactProvider.c).withValue("jid", localcs.t).withValue("capability", ct.a(localb.getClass())).withValue("value", localb.r()).withValue("updated_at", Long.valueOf(l1)).withValue("__insert_or_replace__", Boolean.valueOf(true)).build());
      }
      break;
      try
      {
        localct.c.a(localArrayList);
        Log.i("added " + paramCollection.size() + " contacts (" + i1 + " whatsapp) | time: " + (SystemClock.elapsedRealtime() - l2));
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          Log.e("unable to add " + paramCollection.size() + " contacts " + localIllegalArgumentException);
        }
      }
      catch (RemoteException paramCollection)
      {
        throw new RuntimeException(paramCollection);
      }
      catch (OperationApplicationException paramCollection)
      {
        for (;;) {}
      }
    }
  }
  
  public final void a(Map<String, List<z>> paramMap)
  {
    ct localct = this.b;
    long l1 = SystemClock.elapsedRealtime();
    System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList(paramMap.size());
    paramMap = paramMap.entrySet().iterator();
    for (;;)
    {
      if (paramMap.hasNext())
      {
        Object localObject = (Map.Entry)paramMap.next();
        String str1 = (String)((Map.Entry)localObject).getKey();
        if (TextUtils.isEmpty(str1)) {
          Log.w("skipping updating capabilities for empty jid");
        }
        localObject = ((List)((Map.Entry)localObject).getValue()).iterator();
        if (((Iterator)localObject).hasNext())
        {
          z localz = (z)((Iterator)localObject).next();
          if (TextUtils.isEmpty(localz.a)) {
            Log.w("skipping updating capability due to empty key or value; jid=" + str1 + "; capability=" + localz);
          }
          String str2 = localz.a;
          int i1 = -1;
          switch (str2.hashCode())
          {
          }
          for (;;)
          {
            switch (i1)
            {
            }
            Log.w("unrecognized capability; jid=" + str1 + "; capability=" + localz);
            break;
            if (str2.equals("voip")) {
              i1 = 0;
            }
          }
        }
        if (localArrayList.size() <= 400) {
          continue;
        }
      }
      try
      {
        localct.c.a(localArrayList);
        localArrayList.clear();
      }
      catch (RemoteException paramMap)
      {
        throw new RuntimeException(paramMap);
        try
        {
          localct.c.a(localArrayList);
          Log.i("updated capabilities | time: " + (SystemClock.elapsedRealtime() - l1));
          return;
        }
        catch (RemoteException paramMap)
        {
          throw new RuntimeException(paramMap);
        }
        catch (OperationApplicationException paramMap)
        {
          for (;;) {}
        }
      }
      catch (OperationApplicationException paramMap)
      {
        for (;;) {}
      }
    }
  }
  
  public final boolean a(String paramString, byte[] paramArrayOfByte)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool1 = true;
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject7 = null;
    Object localObject4 = null;
    Object localObject2 = localObject5;
    Object localObject3 = localObject6;
    Object localObject1 = localObject7;
    for (;;)
    {
      try
      {
        Object localObject8 = com.whatsapp.proto.c.a(paramArrayOfByte);
        paramArrayOfByte = (byte[])localObject4;
        localObject2 = localObject5;
        localObject3 = localObject6;
        localObject1 = localObject7;
        if (((com.whatsapp.proto.c)localObject8).c())
        {
          paramArrayOfByte = (byte[])localObject4;
          localObject2 = localObject5;
          localObject3 = localObject6;
          localObject1 = localObject7;
          if (((com.whatsapp.proto.c)localObject8).b())
          {
            localObject2 = localObject5;
            localObject3 = localObject6;
            localObject1 = localObject7;
            paramArrayOfByte = ((com.whatsapp.proto.c)localObject8).c.d();
            localObject2 = localObject5;
            localObject3 = localObject6;
            localObject1 = localObject7;
            localObject8 = ((com.whatsapp.proto.c)localObject8).b.d();
            localObject2 = localObject5;
            localObject3 = localObject6;
            localObject1 = localObject7;
            Object localObject9 = com.whatsapp.a.c.a().b(com.whatsapp.a.c.a(paramString).a());
            if (localObject9 == null) {
              continue;
            }
            localObject2 = localObject5;
            localObject3 = localObject6;
            localObject1 = localObject7;
            if (((a)localObject9).a == null) {
              continue;
            }
            localObject2 = localObject5;
            localObject3 = localObject6;
            localObject1 = localObject7;
            localObject9 = ((a)localObject9).a.a();
            if (localObject9 == null) {
              continue;
            }
            localObject2 = localObject5;
            localObject3 = localObject6;
            localObject1 = localObject7;
            if (!a.a.a.a.d.a((org.whispersystems.a.a.d)localObject9, (byte[])localObject8, paramArrayOfByte)) {
              continue;
            }
            localObject2 = localObject5;
            localObject3 = localObject6;
            localObject1 = localObject7;
            Log.d("vname verified signature for jid " + paramString);
            localObject2 = localObject5;
            localObject3 = localObject6;
            localObject1 = localObject7;
            paramArrayOfByte = c.b.a((byte[])localObject8);
          }
        }
      }
      catch (q paramArrayOfByte)
      {
        localObject1 = localObject2;
        Log.w("vname invalidproto:" + paramArrayOfByte);
        if (localObject2 == null) {
          continue;
        }
        this.b.a(paramString, (c.b)localObject2);
        f(paramString);
        bu.a(h.a(this, paramString));
        bool1 = bool2;
        this.c.put(paramString, Long.valueOf(System.currentTimeMillis()));
        b.a.a.c.a().b(new n(paramString));
        return bool1;
        localObject2 = localObject5;
        localObject3 = localObject6;
        localObject1 = localObject7;
        Log.w("vname no identity key for jid " + paramString);
        paramArrayOfByte = (byte[])localObject4;
        continue;
      }
      catch (org.whispersystems.a.e paramArrayOfByte)
      {
        localObject1 = localObject3;
        Log.w("vname invalidkey:" + paramArrayOfByte);
        if (localObject3 == null) {
          continue;
        }
        this.b.a(paramString, (c.b)localObject3);
        f(paramString);
        bu.a(i.a(this, paramString));
        bool1 = bool3;
        this.c.put(paramString, Long.valueOf(System.currentTimeMillis()));
        b.a.a.c.a().b(new n(paramString));
        return bool1;
        Log.w("vname certificate details could no be found or validated for jid " + paramString);
        bool1 = false;
        continue;
        Log.w("vname certificate details could no be found or validated for jid " + paramString);
        bool1 = false;
        continue;
        Log.w("vname certificate details could no be found or validated for jid " + paramString);
        bool1 = false;
        continue;
      }
      finally
      {
        if (localObject1 == null) {
          break label742;
        }
      }
      localObject2 = paramArrayOfByte;
      localObject3 = paramArrayOfByte;
      localObject1 = paramArrayOfByte;
      i();
      if (paramArrayOfByte == null) {
        continue;
      }
      this.b.a(paramString, paramArrayOfByte);
      f(paramString);
      bu.a(g.a(this, paramString));
      this.c.put(paramString, Long.valueOf(System.currentTimeMillis()));
      b.a.a.c.a().b(new n(paramString));
      return bool1;
      localObject2 = localObject5;
      localObject3 = localObject6;
      localObject1 = localObject7;
      Log.w("vname failed to verify signature for jid " + paramString);
      paramArrayOfByte = (byte[])localObject4;
    }
    this.b.a(paramString, (c.b)localObject1);
    f(paramString);
    bu.a(j.a(this, paramString));
    for (;;)
    {
      this.c.put(paramString, Long.valueOf(System.currentTimeMillis()));
      b.a.a.c.a().b(new n(paramString));
      throw paramArrayOfByte;
      label742:
      Log.w("vname certificate details could no be found or validated for jid " + paramString);
    }
  }
  
  public final void b(cs paramcs)
  {
    c(Collections.singletonList(paramcs));
    g(paramcs);
  }
  
  public final void b(ArrayList<cs> paramArrayList)
  {
    this.b.a(paramArrayList, ct.a.a);
  }
  
  public final void b(Collection<cs> paramCollection)
  {
    cs.a(paramCollection, "dbinfo/manager/deleteContacts");
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      cs localcs = (cs)paramCollection.next();
      if ((localcs != null) && ((localcs.t == null) || (!localcs.t.equals("Server@s.whatsapp.net"))) && (!localcs.d()))
      {
        localArrayList2.add(localcs);
        if (localcs.h)
        {
          Object localObject = this.b;
          long l1 = System.currentTimeMillis();
          localObject = ((ct)localObject).c.a(ContactProvider.a, ContactProvider.g, "wa_contacts.jid = ?", new String[] { localcs.t }, null);
          int i1;
          label175:
          ContentValues localContentValues;
          if (localObject == null)
          {
            Log.e("has duplicate check failed " + localcs);
            i1 = 0;
            if (i1 != 0) {
              break label746;
            }
            if ((!this.n.d(localcs.t)) && (!this.k.a(localcs.t)) && (localcs.E < this.e.b())) {
              break label714;
            }
            if (localcs.d == null) {
              continue;
            }
            localObject = this.b;
            l1 = System.currentTimeMillis();
            localContentValues = new ContentValues(7);
            if (localcs.E <= ((ct)localObject).a.b()) {
              break label673;
            }
            i1 = 1;
            localContentValues.put("raw_contact_id", Integer.valueOf(-1));
            if (i1 == 0) {
              localContentValues.put("display_name", null);
            }
            localContentValues.put("given_name", null);
            localContentValues.put("family_name", null);
            localContentValues.put("sort_name", null);
            localContentValues.put("phone_type", Integer.valueOf(-1));
            localContentValues.put("phone_label", null);
            localContentValues.put("nickname", null);
            localContentValues.put("company", null);
            localContentValues.put("title", null);
          }
          try
          {
            ((ct)localObject).c.a(ContentUris.withAppendedId(ContactProvider.a, localcs.c), localContentValues, null, null);
            localcs.d = null;
            if (i1 != 0) {
              localcs.D = localcs.e;
            }
            localcs.e = null;
            localcs.f = Integer.valueOf(-1);
            localcs.g = null;
            localcs.o = null;
            localcs.p = null;
            localcs.r = null;
            localcs.w = null;
            localcs.x = null;
            localcs.y = null;
            Log.i("android info nullified for contact " + localcs + " | time: " + (System.currentTimeMillis() - l1));
            f(localcs.t);
            continue;
            if (((Cursor)localObject).moveToNext())
            {
              long l2 = ((Cursor)localObject).getLong(0);
              if (l2 > 1L)
              {
                Log.i(Long.toString(l2) + " duplicate contacts detected with jid (" + localcs.t + ") | time: " + (System.currentTimeMillis() - l1));
                ((Cursor)localObject).close();
                i1 = 1;
                break label175;
              }
              ((Cursor)localObject).close();
              i1 = 0;
              break label175;
            }
            ((Cursor)localObject).close();
            Log.w("failed during duplicate contact detection for jid (" + localcs.t + ") | time: " + (System.currentTimeMillis() - l1));
            i1 = 0;
            break label175;
            label673:
            i1 = 0;
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            for (;;)
            {
              Log.e("unable to nullify contact android info " + localcs + ' ' + localIllegalArgumentException);
            }
          }
          label714:
          Log.d("deleteContacts:not in conversation list" + localcs);
          localArrayList1.add(localcs);
          continue;
        }
        label746:
        localArrayList1.add(localcs);
      }
    }
    if (localArrayList1.size() > 0) {
      a(localArrayList1);
    }
    if (localArrayList2.size() > 0) {
      this.i.b(localArrayList2);
    }
  }
  
  public final cs c(String paramString)
  {
    Object localObject;
    if ((this.g.b() != null) && (paramString.equals(this.g.b() + "@s.whatsapp.net"))) {
      localObject = this.g.c();
    }
    cs localcs;
    do
    {
      return (cs)localObject;
      if (paramString.equals("0@s.whatsapp.net")) {
        return b();
      }
      localcs = (cs)this.a.get(paramString);
      localObject = localcs;
    } while (localcs != null);
    paramString = this.b.a(paramString);
    f(paramString);
    return paramString;
  }
  
  public final ArrayList<cs> c()
  {
    Object localObject = this.b;
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    localObject = ((ct)localObject).c.a(ContactProvider.a, new String[] { "wa_contacts._id", "wa_contacts.jid", "is_whatsapp_user", "number", "raw_contact_id", "display_name", "phone_type", "phone_label" }, "is_whatsapp_user = 1", null, null);
    if (localObject == null)
    {
      Log.e("unable to get wacontacts for account sync");
      return localArrayList;
    }
    while (((Cursor)localObject).moveToNext())
    {
      cs localcs = cs.a((Cursor)localObject);
      if (!localcs.d()) {
        localArrayList.add(localcs);
      }
    }
    ((Cursor)localObject).close();
    Log.i("retrieved " + localArrayList.size() + " whatsapp contacts for account sync | time: " + (System.currentTimeMillis() - l1));
    return localArrayList;
  }
  
  public final void c(cs paramcs)
  {
    ct localct = this.b;
    long l1 = System.currentTimeMillis();
    ContentValues localContentValues = new ContentValues(3);
    localContentValues.put("photo_ts", Integer.valueOf(paramcs.l));
    localContentValues.put("thumb_ts", Integer.valueOf(paramcs.m));
    localContentValues.put("photo_id_timestamp", Long.valueOf(paramcs.n));
    localct.a(localContentValues, paramcs.t);
    Log.i("updated photo id for contact jid=" + paramcs.t + ' ' + localContentValues + " | time: " + (System.currentTimeMillis() - l1));
    g(paramcs);
  }
  
  public final void c(ArrayList<cs> paramArrayList)
  {
    Object localObject = this.b;
    long l1 = System.currentTimeMillis();
    int i1 = paramArrayList.size();
    localObject = ((ct)localObject).c.a(ContactProvider.a, cs.b, "wa_contacts.jid LIKE '%broadcast'", null, null);
    if (localObject == null)
    {
      Log.e("unable to get all broadcastlist chats");
      return;
    }
    while (((Cursor)localObject).moveToNext()) {
      paramArrayList.add(cs.b((Cursor)localObject));
    }
    ((Cursor)localObject).close();
    Log.i("returned " + (paramArrayList.size() - i1) + " broadcast list chats | time: " + (System.currentTimeMillis() - l1));
  }
  
  public final void c(Collection<cs> paramCollection)
  {
    ct localct = this.b;
    long l1 = System.currentTimeMillis();
    long l2 = SystemClock.elapsedRealtime();
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    Iterator localIterator = paramCollection.iterator();
    int i1 = 0;
    Object localObject1;
    while (localIterator.hasNext())
    {
      cs localcs = (cs)localIterator.next();
      if (TextUtils.isEmpty(localcs.t))
      {
        Log.i("update or add contact skipped for jid=" + localcs.t);
      }
      else
      {
        Object localObject2 = ContentProviderOperation.newInsert(ContactProvider.a);
        ((ContentProviderOperation.Builder)localObject2).withYieldAllowed(true);
        if (localcs.c > 0L) {
          ((ContentProviderOperation.Builder)localObject2).withValue("_id", Long.valueOf(localcs.c));
        }
        ((ContentProviderOperation.Builder)localObject2).withValue("jid", localcs.t);
        ((ContentProviderOperation.Builder)localObject2).withValue("is_whatsapp_user", Boolean.valueOf(localcs.h));
        ((ContentProviderOperation.Builder)localObject2).withValue("status", localcs.u);
        ((ContentProviderOperation.Builder)localObject2).withValue("status_timestamp", Long.valueOf(localcs.v));
        if (localcs.d != null)
        {
          localObject1 = localcs.d.b;
          ((ContentProviderOperation.Builder)localObject2).withValue("number", localObject1);
          if (localcs.d == null) {
            break label618;
          }
        }
        label618:
        for (localObject1 = Long.valueOf(localcs.d.a);; localObject1 = null)
        {
          ((ContentProviderOperation.Builder)localObject2).withValue("raw_contact_id", localObject1);
          ((ContentProviderOperation.Builder)localObject2).withValue("display_name", localcs.e);
          ((ContentProviderOperation.Builder)localObject2).withValue("phone_type", localcs.f);
          ((ContentProviderOperation.Builder)localObject2).withValue("phone_label", localcs.g);
          ((ContentProviderOperation.Builder)localObject2).withValue("given_name", localcs.o);
          ((ContentProviderOperation.Builder)localObject2).withValue("family_name", localcs.p);
          ((ContentProviderOperation.Builder)localObject2).withValue("sort_name", localcs.r);
          ((ContentProviderOperation.Builder)localObject2).withValue("photo_ts", Integer.valueOf(localcs.l));
          ((ContentProviderOperation.Builder)localObject2).withValue("thumb_ts", Integer.valueOf(localcs.m));
          ((ContentProviderOperation.Builder)localObject2).withValue("photo_id_timestamp", Long.valueOf(localcs.n));
          ((ContentProviderOperation.Builder)localObject2).withValue("wa_name", localcs.q);
          ((ContentProviderOperation.Builder)localObject2).withValue("nickname", localcs.w);
          ((ContentProviderOperation.Builder)localObject2).withValue("company", localcs.x);
          ((ContentProviderOperation.Builder)localObject2).withValue("title", localcs.y);
          ((ContentProviderOperation.Builder)localObject2).withValue("is_spam_reported", Boolean.valueOf(localcs.F));
          ((ContentProviderOperation.Builder)localObject2).withValue("__insert_or_replace__", Boolean.valueOf(true));
          localArrayList.add(((ContentProviderOperation.Builder)localObject2).build());
          localObject1 = localcs.p().values().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (AppBarLayout.b)((Iterator)localObject1).next();
            localArrayList.add(ContentProviderOperation.newInsert(ContactProvider.c).withValue("jid", localcs.t).withValue("capability", ct.a(localObject2.getClass())).withValue("value", ((AppBarLayout.b)localObject2).r()).withValue("updated_at", Long.valueOf(l1)).withValue("__insert_or_replace__", Boolean.valueOf(true)).build());
          }
          localObject1 = null;
          break;
        }
        i1 += 1;
      }
    }
    try
    {
      localct.c.a(localArrayList);
      Log.i("updated or added " + i1 + " contacts from a list of " + paramCollection.size() + " contacts | time: " + (SystemClock.elapsedRealtime() - l2));
      localObject1 = paramCollection.iterator();
      while (((Iterator)localObject1).hasNext()) {
        g((cs)((Iterator)localObject1).next());
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Log.e("unable to update or add contacts " + localIllegalArgumentException);
      }
    }
    catch (RemoteException paramCollection)
    {
      throw new RuntimeException(paramCollection);
      this.i.a(new ArrayList(paramCollection));
      return;
    }
    catch (OperationApplicationException paramCollection)
    {
      for (;;) {}
    }
  }
  
  public final int d()
  {
    Object localObject = this.b;
    long l1 = System.currentTimeMillis();
    String str = ((ct)localObject).b.b() + "@s.whatsapp.net";
    localObject = ((ct)localObject).c.a(ContactProvider.a, ContactProvider.g, "is_whatsapp_user = 1 AND raw_contact_id NOT NULL AND raw_contact_id != -1 AND wa_contacts.jid != ?", new String[] { str }, null);
    int i1;
    if (localObject == null)
    {
      Log.e("unable to get individual contact count");
      i1 = 0;
    }
    for (;;)
    {
      Log.i("indivcount/count " + i1);
      return i1;
      if (((Cursor)localObject).moveToNext())
      {
        i1 = ((Cursor)localObject).getInt(0);
        Log.i("individual contact count: " + i1 + " | time: " + (System.currentTimeMillis() - l1));
        ((Cursor)localObject).close();
      }
      else
      {
        ((Cursor)localObject).close();
        Log.w("individual contact count missing cursor");
        i1 = -1;
      }
    }
  }
  
  public final cs d(String paramString)
  {
    cs localcs = c(paramString);
    if (localcs != null) {
      return localcs;
    }
    paramString = new cs(paramString);
    this.b.a(paramString);
    return paramString;
  }
  
  public final void d(cs paramcs)
  {
    this.b.b(paramcs);
    g(paramcs);
    paramcs = this.f;
    dh localdh = this.j;
    localdh.getClass();
    paramcs.a(f.a(localdh));
  }
  
  public final void d(ArrayList<cs> paramArrayList)
  {
    this.b.a(paramArrayList, ct.a.b);
  }
  
  public final void d(Collection<cs> paramCollection)
  {
    Object localObject1 = this.b;
    long l1;
    Object localObject2;
    if (!paramCollection.isEmpty())
    {
      l1 = System.currentTimeMillis();
      localObject2 = new ArrayList(paramCollection.size());
      Iterator localIterator = paramCollection.iterator();
      while (localIterator.hasNext())
      {
        cs localcs = (cs)localIterator.next();
        if (TextUtils.isEmpty(localcs.t))
        {
          Log.i("update contact skipped for jid=" + localcs.t);
        }
        else
        {
          ContentProviderOperation.Builder localBuilder = ContentProviderOperation.newUpdate(ContactProvider.a);
          localBuilder.withSelection("_id = ?", new String[] { String.valueOf(localcs.c) });
          localBuilder.withValue("keep_timestamp", Long.valueOf(localcs.E));
          ((ArrayList)localObject2).add(localBuilder.build());
        }
      }
    }
    try
    {
      ((ct)localObject1).c.a((ArrayList)localObject2);
      Log.i("updated 0 contacts from a list of " + paramCollection.size() + " contacts | time: " + (SystemClock.elapsedRealtime() - l1));
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        localObject1 = (cs)paramCollection.next();
        localObject2 = (cs)this.a.get(((cs)localObject1).t);
        if (localObject2 != null) {
          ((cs)localObject2).E = ((cs)localObject1).E;
        }
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Log.e("unable to update keep timestamp " + localIllegalArgumentException);
      }
    }
    catch (RemoteException paramCollection)
    {
      throw new RuntimeException(paramCollection);
      return;
    }
    catch (OperationApplicationException paramCollection)
    {
      for (;;) {}
    }
  }
  
  public final cs e(String paramString)
  {
    cs localcs = (cs)this.a.get(paramString);
    if (localcs != null)
    {
      Log.d("dbinfo/groupchatbyjid/get from cache");
      return localcs;
    }
    paramString = this.b.a(paramString);
    f(paramString);
    return paramString;
  }
  
  public final ArrayList<cs> e()
  {
    ct localct = this.b;
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = localct.c.a(ContactProvider.a, cs.b, null, null, null);
    if (localCursor == null)
    {
      Log.e("unable to get all db contacts");
      return localArrayList;
    }
    while (localCursor.moveToNext()) {
      localArrayList.add(cs.b(localCursor));
    }
    localCursor.close();
    localct.a(localArrayList);
    Log.i("returned " + localArrayList.size() + " db contacts | time: " + (System.currentTimeMillis() - l1));
    return localArrayList;
  }
  
  public final void e(cs paramcs)
  {
    int i1 = 1;
    ct localct = this.b;
    long l1 = System.currentTimeMillis();
    ContentValues localContentValues = new ContentValues(1);
    if (paramcs.C) {}
    for (;;)
    {
      localContentValues.put("status_autodownload_disabled", Integer.valueOf(i1));
      localct.a(localContentValues, paramcs.t);
      Log.i("updated contact status autodownload jid=" + paramcs.t + ' ' + localContentValues + " | time: " + (System.currentTimeMillis() - l1));
      return;
      i1 = 0;
    }
  }
  
  public final ArrayList<cs> f()
  {
    ct localct = this.b;
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    Object localObject = localct.b.b() + "@s.whatsapp.net";
    localObject = localct.c.a(ContactProvider.a, cs.b, "is_whatsapp_user = 1 AND wa_contacts.jid NOT LIKE '%-%' AND wa_contacts.jid != ? AND wa_contacts.jid NOT LIKE ? AND wa_contacts.jid != ?", new String[] { "broadcast", "%@broadcast", localObject }, null);
    if (localObject == null)
    {
      Log.e("unable to get all individual chats");
      return localArrayList;
    }
    while (((Cursor)localObject).moveToNext()) {
      localArrayList.add(cs.b((Cursor)localObject));
    }
    ((Cursor)localObject).close();
    localct.a(localArrayList);
    Log.i("returned " + localArrayList.size() + " individual contacts | time: " + (System.currentTimeMillis() - l1));
    return localArrayList;
  }
  
  public final void f(String paramString)
  {
    this.a.remove(paramString);
  }
  
  public final boolean f(cs paramcs)
  {
    return (paramcs != null) && (this.a.put(paramcs.t, paramcs) == null);
  }
  
  public final ArrayList<cs> g()
  {
    Object localObject = this.b;
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    localObject = ((ct)localObject).c.a(ContactProvider.a, cs.b, "wa_contacts.jid LIKE '%-%'", null, null);
    if (localObject == null)
    {
      Log.e("unable to get all group chats");
      return localArrayList;
    }
    while (((Cursor)localObject).moveToNext()) {
      localArrayList.add(cs.b((Cursor)localObject));
    }
    ((Cursor)localObject).close();
    Log.i("returned " + localArrayList.size() + " group chats | time: " + (System.currentTimeMillis() - l1));
    return localArrayList;
  }
  
  public final ArrayList<cs> g(String paramString)
  {
    ct localct = this.b;
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = localct.c.a(ContactProvider.a, cs.b, "wa_contacts.jid = ?", new String[] { paramString }, null);
    if (localCursor == null)
    {
      Log.e("unable to get contacts by jid " + paramString);
      return localArrayList;
    }
    while (localCursor.moveToNext()) {
      localArrayList.add(cs.b(localCursor));
    }
    localCursor.close();
    localct.a(localArrayList);
    Log.i("fetched " + localArrayList.size() + " contacts by jid=" + paramString + " | time: " + (System.currentTimeMillis() - l1));
    return localArrayList;
  }
  
  public final void g(cs paramcs)
  {
    cs localcs = (cs)this.a.get(paramcs.t);
    if ((localcs != null) && (localcs != paramcs)) {
      this.a.remove(paramcs.t);
    }
  }
  
  public final ArrayList<cs> h(String paramString)
  {
    ct localct = this.b;
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = localct.c.a(ContactProvider.a, cs.b, "wa_contacts.jid LIKE ?", new String[] { "%" + paramString + "%" }, null);
    if (localCursor == null)
    {
      Log.e("unable to get contacts by phone number " + paramString);
      return localArrayList;
    }
    while (localCursor.moveToNext()) {
      localArrayList.add(cs.b(localCursor));
    }
    localCursor.close();
    localct.a(localArrayList);
    Log.i("fetched " + localArrayList.size() + " contacts by phone number " + paramString + " | time: " + (System.currentTimeMillis() - l1));
    return localArrayList;
  }
  
  public final void h()
  {
    this.a.clear();
  }
  
  public final void i()
  {
    Object localObject = new Random();
    byte[] arrayOfByte = new byte[12];
    ((Random)localObject).nextBytes(arrayOfByte);
    localObject = Base64.encodeToString(arrayOfByte, 8);
    this.m.a.edit().putString("web_contact_checksum", (String)localObject).apply();
  }
  
  public final void i(String paramString)
  {
    this.c.remove(paramString);
  }
  
  public final cu j(String paramString)
  {
    Object localObject = this.b;
    Cursor localCursor;
    if (paramString == null)
    {
      Log.w("cannot get verified name details by null jid");
      localObject = null;
      if ((localObject != null) && (((cu)localObject).f > 0L) && (((cu)localObject).f <= System.currentTimeMillis() / 1000L))
      {
        Log.i("vname: clearing due to expiration; jid=" + paramString + " expires=" + ((cu)localObject).f);
        k(paramString);
        return null;
      }
    }
    else
    {
      localCursor = ((ct)localObject).c.a(ContactProvider.e, cu.a, "jid = ?", new String[] { paramString }, null);
      if (!localCursor.moveToNext()) {
        break label138;
      }
    }
    label138:
    for (localObject = cu.a(localCursor);; localObject = null)
    {
      localCursor.close();
      break;
      return (cu)localObject;
    }
  }
  
  public final void k(String paramString)
  {
    ct localct = this.b;
    ArrayList localArrayList = new ArrayList();
    ct.a(localArrayList, paramString);
    try
    {
      localct.c.a(localArrayList);
      this.c.remove(paramString);
      f(paramString);
      i();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Log.d("unable to store vname details " + paramString, localIllegalArgumentException);
      }
    }
    catch (RemoteException paramString)
    {
      throw new RuntimeException(paramString);
    }
    catch (OperationApplicationException paramString)
    {
      for (;;) {}
    }
  }
  
  public static final class a
    extends cs
  {
    public a()
    {
      super();
      this.e = "WhatsApp";
      this.A = u.a().getString(2131298233);
    }
    
    public final int e()
    {
      return 2130837630;
    }
    
    public final boolean f()
    {
      return true;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/data/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */