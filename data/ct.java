package com.whatsapp.data;

import android.content.ContentProvider;
import android.content.ContentProviderClient;
import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.protobuf.e;
import com.whatsapp.and;
import com.whatsapp.ant;
import com.whatsapp.aus;
import com.whatsapp.contact.ContactProvider;
import com.whatsapp.proto.b;
import com.whatsapp.proto.c.b;
import com.whatsapp.protocol.j;
import com.whatsapp.util.Log;
import com.whatsapp.va;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class ct
{
  private static final String[] e = { "lc", "verified_name" };
  final ant a;
  final va b;
  public final b c;
  final and d;
  
  public ct(Context paramContext, ant paramant, va paramva, and paramand)
  {
    this.a = paramant;
    this.b = paramva;
    this.d = paramand;
    paramant = paramContext.getContentResolver().acquireContentProviderClient(ContactProvider.a);
    if (paramant != null)
    {
      this.c = new d(paramant, (byte)0);
      return;
    }
    Log.e("unable to find contact provider client by uri " + ContactProvider.a);
    paramant = new ContactProvider();
    paramant.attachInfo(paramContext, null);
    this.c = new c(paramant);
  }
  
  static String a(Class paramClass)
  {
    Log.w("unknown capability class during string lookup; capabilityClass=" + paramClass);
    return null;
  }
  
  static void a(cs paramcs, ArrayList<ContentProviderOperation> paramArrayList)
  {
    paramArrayList.add(ContentProviderOperation.newDelete(ContactProvider.a).withSelection("_id = ?", new String[] { String.valueOf(paramcs.c) }).build());
    paramArrayList.add(ContentProviderOperation.newDelete(ContactProvider.c).withSelection("jid = ? AND NOT EXISTS (SELECT 1 FROM wa_contacts WHERE jid = ?)", new String[] { paramcs.t, paramcs.t }).build());
  }
  
  private void a(cs paramcs, Locale paramLocale)
  {
    localObject3 = null;
    if ((paramcs == null) || (!paramcs.f())) {}
    do
    {
      for (;;)
      {
        return;
        Object localObject1 = paramLocale.getLanguage();
        String str1 = paramLocale.getCountry();
        Cursor localCursor = this.c.a(ContactProvider.f, e, "jid = ? AND lg = ?", new String[] { paramcs.t, localObject1 }, null);
        if (localCursor == null) {}
        try
        {
          Log.e("unable to get localized vname by jid " + paramcs.t);
          if (localCursor != null)
          {
            localCursor.close();
            return;
          }
        }
        catch (Throwable paramcs)
        {
          try
          {
            String str2;
            throw paramcs;
          }
          finally
          {
            localObject1 = paramcs;
          }
          if ((localCursor != null) && (localObject1 == null)) {
            break label212;
          }
          try
          {
            localCursor.close();
            for (;;)
            {
              throw paramcs;
              localCursor.close();
            }
          }
          catch (Throwable paramLocale)
          {
            for (;;) {}
          }
        }
        finally
        {
          for (;;)
          {
            localObject1 = localObject3;
            continue;
            Object localObject2 = localObject1;
          }
        }
      }
      localObject1 = null;
      do
      {
        for (;;)
        {
          if (!localCursor.moveToNext()) {
            break label233;
          }
          str2 = localCursor.getString(0);
          localObject2 = localCursor.getString(1);
          if (!TextUtils.isEmpty(str2)) {
            break;
          }
          localObject1 = localObject2;
        }
      } while (!str2.equals(str1));
      if (localObject2 != null) {
        paramcs.A = ((String)localObject2);
      }
      paramcs.B = paramLocale;
    } while (localCursor == null);
    localCursor.close();
  }
  
  static void a(ArrayList<ContentProviderOperation> paramArrayList, String paramString)
  {
    paramArrayList.add(ContentProviderOperation.newDelete(ContactProvider.e).withSelection("jid = ?", new String[] { paramString }).build());
    paramArrayList.add(ContentProviderOperation.newDelete(ContactProvider.f).withSelection("jid = ?", new String[] { paramString }).build());
  }
  
  public final int a(ContentValues paramContentValues, String paramString)
  {
    try
    {
      int i = this.c.a(ContactProvider.a, paramContentValues, "jid = ?", new String[] { paramString });
      return i;
    }
    catch (IllegalArgumentException paramContentValues)
    {
      Log.e("unable to update contact by jid " + paramString + ' ' + paramContentValues);
    }
    return 0;
  }
  
  public final cs a(String paramString)
  {
    Object localObject5 = null;
    long l1 = System.currentTimeMillis();
    if (paramString == null)
    {
      Log.w("cannot get contact by null jid");
      return null;
    }
    Cursor localCursor = this.c.a(ContactProvider.a, cs.b, "wa_contacts.jid = ?", new String[] { paramString }, null);
    if (localCursor == null)
    {
      Log.e("unable to get contact by jid " + paramString);
      return null;
    }
    for (;;)
    {
      Object localObject1;
      Object localObject3;
      if (localCursor.moveToNext())
      {
        localObject1 = cs.b(localCursor);
        if ((localObject5 == null) || ((((cs)localObject5).d == null) && (((cs)localObject1).d != null)))
        {
          localObject3 = localObject1;
          label114:
          if (((cs)localObject1).d != null) {
            break label550;
          }
        }
      }
      for (;;)
      {
        localObject4 = localObject1;
        localObject5 = localObject3;
        break;
        if ((Build.MANUFACTURER.equalsIgnoreCase("lge")) && (((cs)localObject5).d != null) && (((cs)localObject5).d.a == -2L) && (((cs)localObject1).d != null) && (((cs)localObject1).d.a != -2L))
        {
          Log.d("replacing sim contact " + ((cs)localObject5).d + " with " + ((cs)localObject1).d);
          localObject3 = localObject1;
          break label114;
        }
        if ((!((cs)localObject5).h) && (((cs)localObject1).h))
        {
          localObject3 = localObject1;
          break label114;
        }
        localObject3 = localObject5;
        if (!((cs)localObject5).h) {
          break label114;
        }
        localObject3 = localObject5;
        if (!((cs)localObject1).h) {
          break label114;
        }
        localObject3 = localObject5;
        if (((cs)localObject1).c >= ((cs)localObject5).c) {
          break label114;
        }
        Log.d("replacing contact " + localObject5 + " with " + localObject1 + " because of lower id ");
        localObject3 = localObject1;
        break label114;
        int i = localCursor.getCount();
        localCursor.close();
        long l2;
        if ((localObject4 != null) && (localObject4 != localObject5))
        {
          l2 = System.currentTimeMillis();
          localObject1 = new ArrayList();
          a((cs)localObject4, (ArrayList)localObject1);
        }
        try
        {
          this.c.a((ArrayList)localObject1);
          Log.i("delete contact " + localObject4 + " | time : " + (System.currentTimeMillis() - l2));
          d((cs)localObject5);
          Log.i("contact fetched by jid=" + paramString + " result=" + localObject5 + " count=" + i + " | time: " + (System.currentTimeMillis() - l1));
          return (cs)localObject5;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          for (;;)
          {
            Log.d("unable to delete contact " + ((cs)localObject4).c, localIllegalArgumentException);
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
        label550:
        Object localObject2 = localObject4;
      }
      Object localObject4 = null;
    }
  }
  
  public final List<Long> a(Map<Long, Integer> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.c.a(ContactProvider.d, new String[] { "id", "version" }, null, new String[0], null);
    if (localCursor != null)
    {
      while (localCursor.moveToNext())
      {
        long l = localCursor.getInt(0);
        int i = localCursor.getInt(1);
        if (!paramMap.containsKey(Long.valueOf(l))) {
          localArrayList.add(Long.valueOf(l));
        } else if (((Integer)paramMap.get(Long.valueOf(l))).equals(Integer.valueOf(i))) {
          paramMap.remove(Long.valueOf(l));
        }
      }
      localCursor.close();
    }
    return localArrayList;
  }
  
  public final Map<String, cs> a()
  {
    long l = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    Cursor localCursor = this.c.a(ContactProvider.a, cs.b, null, null, null);
    if (localCursor == null)
    {
      Log.e("unable to get all db contacts for sync");
      return localHashMap;
    }
    while (localCursor.moveToNext())
    {
      cs localcs = cs.b(localCursor);
      if ((localcs.d != null) && (!TextUtils.isEmpty(localcs.d.b))) {
        localHashMap.put(localcs.d.b, localcs);
      }
    }
    localCursor.close();
    Log.i("returned " + localHashMap.size() + " db contacts for sync | time: " + (System.currentTimeMillis() - l));
    return localHashMap;
  }
  
  public final void a(cp paramcp)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = paramcp.b;
    if (!((Map)localObject).isEmpty())
    {
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        localArrayList.add(ContentProviderOperation.newInsert(ContactProvider.d).withValue("id", localEntry.getKey()).withValue("version", localEntry.getValue()).withValue("__insert_or_replace__", Boolean.valueOf(true)).withYieldAllowed(true).build());
        if (localArrayList.size() > 100) {
          try
          {
            this.c.a(localArrayList);
            localArrayList.clear();
          }
          catch (Exception localException2)
          {
            Log.d("system-version; apply-failed", localException2);
            localArrayList.clear();
          }
          finally
          {
            localArrayList.clear();
          }
        }
      }
    }
    if (!paramcp.a.isEmpty())
    {
      paramcp = paramcp.a.iterator();
      while (paramcp.hasNext())
      {
        localObject = (Long)paramcp.next();
        localArrayList.add(ContentProviderOperation.newDelete(ContactProvider.d).withSelection("id = ?", new String[] { String.valueOf(localObject) }).withYieldAllowed(true).build());
        if (localArrayList.size() > 100) {
          try
          {
            this.c.a(localArrayList);
            localArrayList.clear();
          }
          catch (Exception localException1)
          {
            Log.d("system-version; apply-failed", localException1);
            localArrayList.clear();
          }
          finally
          {
            localArrayList.clear();
          }
        }
      }
    }
    try
    {
      this.c.a(localArrayList);
      return;
    }
    catch (RemoteException paramcp)
    {
      throw new RuntimeException(paramcp);
    }
    catch (OperationApplicationException paramcp)
    {
      for (;;) {}
    }
  }
  
  public final void a(cs paramcs)
  {
    long l = System.currentTimeMillis();
    if (paramcs.t == null)
    {
      Log.w("unable to add unknown contact with null jid");
      return;
    }
    Object localObject = this.b.b();
    if (localObject == null)
    {
      Log.w("unable to add unknown contact due to null me record");
      return;
    }
    if ((!paramcs.d()) && (paramcs.t.startsWith((String)localObject)))
    {
      Log.i("unable to add unknown contact due to matching jid prefix");
      return;
    }
    localObject = new ContentValues(3);
    ((ContentValues)localObject).put("jid", paramcs.t);
    ((ContentValues)localObject).put("is_whatsapp_user", Boolean.valueOf(true));
    ((ContentValues)localObject).put("status", paramcs.u);
    ((ContentValues)localObject).put("status_timestamp", Long.valueOf(paramcs.v));
    try
    {
      paramcs.c = ContentUris.parseId(this.c.a(ContactProvider.a, (ContentValues)localObject));
      Log.i("unknown contact added: " + paramcs + " | time: " + (System.currentTimeMillis() - l));
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Log.e("unable to add unknown contact " + paramcs + ' ' + localIllegalArgumentException);
      }
    }
  }
  
  public final void a(String paramString1, long paramLong, String paramString2)
  {
    long l = System.currentTimeMillis();
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put("status", paramString2);
    localContentValues.put("status_timestamp", Long.valueOf(paramLong));
    try
    {
      this.c.a(ContactProvider.a, localContentValues, "jid = ?", new String[] { paramString1 });
      Log.i("updated contact status jid=" + paramString1 + ' ' + localContentValues + " | time: " + (System.currentTimeMillis() - l));
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Log.e("unable to update contact status " + paramString1 + ", " + paramString2 + ' ' + localIllegalArgumentException);
      }
    }
  }
  
  public final void a(String paramString, c.b paramb)
  {
    ArrayList localArrayList = new ArrayList();
    a(localArrayList, paramString);
    Object localObject2 = new ContentValues(8);
    ((ContentValues)localObject2).put("jid", paramString);
    ((ContentValues)localObject2).put("serial", Long.valueOf(paramb.c));
    Object localObject1 = paramb.d;
    label119:
    label145:
    label171:
    label210:
    Object localObject3;
    if ((localObject1 instanceof String))
    {
      localObject1 = (String)localObject1;
      ((ContentValues)localObject2).put("issuer", (String)localObject1);
      ((ContentValues)localObject2).put("expires", Long.valueOf(paramb.e));
      ((ContentValues)localObject2).put("verified_name", paramb.b());
      localObject1 = paramb.f;
      if (!(localObject1 instanceof String)) {
        break label395;
      }
      localObject1 = (String)localObject1;
      ((ContentValues)localObject2).put("industry", (String)localObject1);
      localObject1 = paramb.g;
      if (!(localObject1 instanceof String)) {
        break label423;
      }
      localObject1 = (String)localObject1;
      ((ContentValues)localObject2).put("city", (String)localObject1);
      localObject1 = paramb.h;
      if (!(localObject1 instanceof String)) {
        break label451;
      }
      localObject1 = (String)localObject1;
      ((ContentValues)localObject2).put("country", (String)localObject1);
      localArrayList.add(ContentProviderOperation.newInsert(ContactProvider.e).withValues((ContentValues)localObject2).build());
      localObject1 = paramb.i.iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (b)((Iterator)localObject1).next();
      } while (TextUtils.isEmpty(((b)localObject2).b()));
      localObject3 = ((b)localObject2).b();
      if (TextUtils.isEmpty(((b)localObject2).c())) {
        break label479;
      }
      paramb = ((b)localObject2).c();
      label265:
      paramb = new Locale((String)localObject3, paramb);
      localObject3 = new ContentValues(4);
      ((ContentValues)localObject3).put("jid", paramString);
      ((ContentValues)localObject3).put("lg", paramb.getLanguage());
      ((ContentValues)localObject3).put("lc", paramb.getCountry());
      paramb = ((b)localObject2).c;
      if (!(paramb instanceof String)) {
        break label486;
      }
      paramb = (String)paramb;
    }
    for (;;)
    {
      ((ContentValues)localObject3).put("verified_name", paramb);
      localArrayList.add(ContentProviderOperation.newInsert(ContactProvider.f).withValues((ContentValues)localObject3).build());
      break label210;
      localObject3 = (e)localObject1;
      localObject1 = ((e)localObject3).e();
      if (((e)localObject3).f()) {
        paramb.d = localObject1;
      }
      break;
      label395:
      localObject3 = (e)localObject1;
      localObject1 = ((e)localObject3).e();
      if (((e)localObject3).f()) {
        paramb.f = localObject1;
      }
      break label119;
      label423:
      localObject3 = (e)localObject1;
      localObject1 = ((e)localObject3).e();
      if (((e)localObject3).f()) {
        paramb.g = localObject1;
      }
      break label145;
      label451:
      localObject3 = (e)localObject1;
      localObject1 = ((e)localObject3).e();
      if (((e)localObject3).f()) {
        paramb.h = localObject1;
      }
      break label171;
      label479:
      paramb = "";
      break label265;
      label486:
      e locale = (e)paramb;
      paramb = locale.e();
      if (locale.f()) {
        ((b)localObject2).c = paramb;
      }
    }
    try
    {
      this.c.a(localArrayList);
      return;
    }
    catch (IllegalArgumentException paramb)
    {
      Log.d("unable to store vname details " + paramString, paramb);
      return;
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
  
  final void a(ArrayList<cs> paramArrayList)
  {
    Locale localLocale = aus.a().b();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      a((cs)paramArrayList.next(), localLocale);
    }
  }
  
  public final void a(ArrayList<cs> paramArrayList, a parama)
  {
    long l = System.currentTimeMillis();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("is_whatsapp_user");
    ((StringBuilder)localObject1).append(" = 1 AND ");
    ((StringBuilder)localObject1).append("wa_contacts.jid");
    ((StringBuilder)localObject1).append(" != ?");
    if ((parama == a.b) || (parama == a.c))
    {
      ((StringBuilder)localObject1).append(" AND (");
      ((StringBuilder)localObject1).append("raw_contact_id");
      ((StringBuilder)localObject1).append(" > 0 OR ");
      ((StringBuilder)localObject1).append("raw_contact_id");
      ((StringBuilder)localObject1).append(" = ");
      ((StringBuilder)localObject1).append(-2L);
      ((StringBuilder)localObject1).append(')');
    }
    Object localObject2 = this.c.a(ContactProvider.a, cs.b, ((StringBuilder)localObject1).toString(), new String[] { this.b.b() + "@s.whatsapp.net" }, "display_name, wa_contacts.jid, phone_type ASC");
    if (localObject2 == null)
    {
      Log.e("unable to get contact picker list");
      return;
    }
    localObject1 = new ArrayList();
    Object localObject3 = new HashMap();
    int i = 0;
    for (;;)
    {
      int k;
      cs localcs1;
      Object localObject4;
      Object localObject5;
      if (((Cursor)localObject2).moveToNext())
      {
        k = i + 1;
        localcs1 = cs.b((Cursor)localObject2);
        if ((localcs1.t == null) || (j.a(localcs1.t))) {
          break label1519;
        }
        if (((Map)localObject3).containsKey(localcs1.t))
        {
          localObject4 = (List)((Map)localObject3).get(localcs1.t);
          if (localcs1.d != null) {
            break label1514;
          }
          if (((List)localObject4).isEmpty()) {
            throw new IllegalStateException("same jid contacts must not be empty");
          }
          localObject5 = (cs)((List)localObject4).get(0);
          if (((cs)localObject5).d == null) {
            if (((cs)localObject5).E >= localcs1.E) {
              a(localcs1, (ArrayList)localObject1);
            }
          }
        }
      }
      label1514:
      for (i = 1;; i = 0)
      {
        localObject5 = new ArrayList();
        int j = i;
        Object localObject6;
        cs localcs2;
        if (i == 0)
        {
          localObject6 = ((List)localObject4).iterator();
          do
          {
            j = i;
            if (!((Iterator)localObject6).hasNext()) {
              break;
            }
            localcs2 = (cs)((Iterator)localObject6).next();
          } while (localcs2.d != null);
          Log.i("removing duplicate contact with null key " + localcs2);
          j = 1;
          ((List)localObject5).add(localcs2);
          a(localcs2, (ArrayList)localObject1);
          ((List)localObject4).add(localcs1);
        }
        if (j == 0)
        {
          localObject6 = ((List)localObject4).iterator();
          while (((Iterator)localObject6).hasNext())
          {
            localcs2 = (cs)((Iterator)localObject6).next();
            if (localcs1.d.equals(localcs2.d))
            {
              Log.i("removing duplicate contact with matching key " + localcs1);
              j = 1;
              a(localcs1, (ArrayList)localObject1);
            }
          }
        }
        for (;;)
        {
          i = j;
          if (j == 0)
          {
            localObject6 = ((List)localObject4).iterator();
            i = j;
            for (;;)
            {
              if (((Iterator)localObject6).hasNext())
              {
                localcs2 = (cs)((Iterator)localObject6).next();
                j = i;
                if (localcs1.d.a != -2L)
                {
                  j = i;
                  if (localcs2.d.a == -2L)
                  {
                    Log.i("removing sim card duplicate contact " + localcs2);
                    j = 1;
                    ((List)localObject5).add(localcs2);
                    a(localcs2, (ArrayList)localObject1);
                  }
                }
                i = j;
                continue;
                ((List)localObject4).remove(localObject5);
                a((cs)localObject5, (ArrayList)localObject1);
                ((List)localObject4).add(localcs1);
                break;
                Log.i("removing duplicate contact with null key " + localcs1);
                a(localcs1, (ArrayList)localObject1);
                break;
              }
            }
            if (i != 0) {
              ((List)localObject4).add(localcs1);
            }
          }
          j = i;
          if (i == 0)
          {
            localObject6 = ((List)localObject4).iterator();
            while (((Iterator)localObject6).hasNext())
            {
              localcs2 = (cs)((Iterator)localObject6).next();
              j = i;
              if (localcs2.e == null)
              {
                j = i;
                if (localcs1.e != null)
                {
                  Log.i("deduping null display name contact " + localcs2);
                  j = 1;
                  ((List)localObject5).add(localcs2);
                }
              }
              i = j;
            }
            if (i != 0) {
              ((List)localObject4).add(localcs1);
            }
            j = i;
          }
          if (j == 0)
          {
            localObject6 = ((List)localObject4).iterator();
            for (i = j; ((Iterator)localObject6).hasNext(); i = j)
            {
              localcs2 = (cs)((Iterator)localObject6).next();
              j = i;
              if (localcs2.e != null)
              {
                j = i;
                if (localcs2.e.equals(localcs1.e))
                {
                  j = i;
                  if (localcs1.c < localcs2.c)
                  {
                    Log.d("deduping duplicate contact with preference for lower id " + localcs2);
                    j = 1;
                    ((List)localObject5).add(localcs2);
                  }
                }
              }
            }
            j = i;
            if (i != 0)
            {
              ((List)localObject4).add(localcs1);
              j = i;
            }
          }
          for (;;)
          {
            if ((j == 0) && (localcs1.e != null))
            {
              localObject6 = ((List)localObject4).iterator();
              do
              {
                if (!((Iterator)localObject6).hasNext()) {
                  break;
                }
                localcs2 = (cs)((Iterator)localObject6).next();
              } while (!localcs1.e.equals(localcs2.e));
            }
            for (i = 0;; i = 1)
            {
              if (i != 0)
              {
                Log.d("adding contact for same jid because names are different " + localcs1);
                ((List)localObject4).add(localcs1);
              }
              for (i = 1;; i = j)
              {
                ((List)localObject4).removeAll((Collection)localObject5);
                if (i == 0)
                {
                  localObject5 = new StringBuilder("existing_contacts: ");
                  localObject4 = ((List)localObject4).iterator();
                  while (((Iterator)localObject4).hasNext())
                  {
                    localObject6 = (cs)((Iterator)localObject4).next();
                    ((StringBuilder)localObject5).append(localObject6 + ", ");
                  }
                  Log.w("contacts are identical, yet not (" + localObject5 + " and " + localcs1 + ')');
                }
                i = k;
                break;
                localObject4 = new ArrayList();
                ((List)localObject4).add(localcs1);
                ((Map)localObject3).put(localcs1.t, localObject4);
                i = k;
                break;
                ((Cursor)localObject2).close();
                localObject2 = ((Map)localObject3).entrySet().iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  localObject3 = ((List)((Map.Entry)((Iterator)localObject2).next()).getValue()).iterator();
                  while (((Iterator)localObject3).hasNext()) {
                    paramArrayList.add((cs)((Iterator)localObject3).next());
                  }
                }
                a(paramArrayList);
                try
                {
                  this.c.a((ArrayList)localObject1);
                  Log.i(paramArrayList.size() + " contacts selected for picker (context=" + parama + ") from " + i + " rows, " + ((ArrayList)localObject1).size() + " duplicates deleted | time: " + (System.currentTimeMillis() - l));
                  return;
                }
                catch (IllegalArgumentException localIllegalArgumentException)
                {
                  for (;;)
                  {
                    Log.e("unable to apply contact picker list de-dupe batch " + localIllegalArgumentException);
                  }
                }
                catch (RemoteException paramArrayList)
                {
                  throw new RuntimeException(paramArrayList);
                }
                catch (OperationApplicationException paramArrayList)
                {
                  for (;;) {}
                }
              }
            }
          }
        }
      }
      label1519:
      i = k;
    }
  }
  
  /* Error */
  public final void a(ArrayList<cs> paramArrayList, Set<String> paramSet)
  {
    // Byte code:
    //   0: new 661	java/util/HashSet
    //   3: dup
    //   4: invokespecial 662	java/util/HashSet:<init>	()V
    //   7: astore 7
    //   9: aload_0
    //   10: getfield 43	com/whatsapp/data/ct:d	Lcom/whatsapp/and;
    //   13: getfield 667	com/whatsapp/and:f	Landroid/content/ContentResolver;
    //   16: astore 6
    //   18: aload 6
    //   20: ifnonnull +81 -> 101
    //   23: ldc_w 669
    //   26: invokestatic 98	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   29: invokestatic 225	java/lang/System:currentTimeMillis	()J
    //   32: lstore_3
    //   33: aload_0
    //   34: getfield 65	com/whatsapp/data/ct:c	Lcom/whatsapp/data/ct$b;
    //   37: getstatic 54	com/whatsapp/contact/ContactProvider:a	Landroid/net/Uri;
    //   40: getstatic 229	com/whatsapp/data/cs:b	[Ljava/lang/String;
    //   43: ldc_w 671
    //   46: iconst_1
    //   47: anewarray 26	java/lang/String
    //   50: dup
    //   51: iconst_0
    //   52: new 67	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 578	java/lang/StringBuilder:<init>	()V
    //   59: aload_0
    //   60: getfield 41	com/whatsapp/data/ct:b	Lcom/whatsapp/va;
    //   63: invokevirtual 449	com/whatsapp/va:b	()Ljava/lang/String;
    //   66: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: ldc_w 599
    //   72: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: aastore
    //   79: ldc_w 673
    //   82: invokeinterface 164 6 0
    //   87: astore 5
    //   89: aload 5
    //   91: ifnonnull +148 -> 239
    //   94: ldc_w 675
    //   97: invokestatic 84	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   100: return
    //   101: aconst_null
    //   102: astore 5
    //   104: getstatic 680	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   107: astore 8
    //   109: invokestatic 225	java/lang/System:currentTimeMillis	()J
    //   112: lstore_3
    //   113: aload 6
    //   115: aload 8
    //   117: iconst_1
    //   118: anewarray 26	java/lang/String
    //   121: dup
    //   122: iconst_0
    //   123: ldc_w 593
    //   126: aastore
    //   127: ldc_w 682
    //   130: iconst_1
    //   131: anewarray 26	java/lang/String
    //   134: dup
    //   135: iconst_0
    //   136: lload_3
    //   137: ldc2_w 683
    //   140: lsub
    //   141: invokestatic 116	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   144: aastore
    //   145: ldc_w 686
    //   148: invokevirtual 689	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   151: astore 6
    //   153: aload 6
    //   155: astore 5
    //   157: aload 5
    //   159: ifnull +50 -> 209
    //   162: aload 5
    //   164: invokeinterface 177 1 0
    //   169: ifeq +40 -> 209
    //   172: aload 7
    //   174: aload 5
    //   176: iconst_0
    //   177: invokeinterface 693 2 0
    //   182: invokestatic 330	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   185: invokevirtual 694	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   188: pop
    //   189: goto -27 -> 162
    //   192: astore 6
    //   194: aload 5
    //   196: ifnull -167 -> 29
    //   199: aload 5
    //   201: invokeinterface 174 1 0
    //   206: goto -177 -> 29
    //   209: aload 5
    //   211: ifnull -182 -> 29
    //   214: aload 5
    //   216: invokeinterface 174 1 0
    //   221: goto -192 -> 29
    //   224: astore_1
    //   225: aload 5
    //   227: ifnull +10 -> 237
    //   230: aload 5
    //   232: invokeinterface 174 1 0
    //   237: aload_1
    //   238: athrow
    //   239: aload 5
    //   241: invokeinterface 177 1 0
    //   246: ifeq +147 -> 393
    //   249: aload 5
    //   251: invokestatic 236	com/whatsapp/data/cs:b	(Landroid/database/Cursor;)Lcom/whatsapp/data/cs;
    //   254: astore 6
    //   256: aload 6
    //   258: getfield 140	com/whatsapp/data/cs:t	Ljava/lang/String;
    //   261: invokestatic 696	com/whatsapp/data/cs:e	(Ljava/lang/String;)Z
    //   264: ifne -25 -> 239
    //   267: aload 6
    //   269: invokevirtual 453	com/whatsapp/data/cs:d	()Z
    //   272: ifne -33 -> 239
    //   275: aload_2
    //   276: aload 6
    //   278: getfield 629	com/whatsapp/data/cs:e	Ljava/lang/String;
    //   281: invokeinterface 699 2 0
    //   286: ifne -47 -> 239
    //   289: aload 7
    //   291: aload 6
    //   293: invokevirtual 701	com/whatsapp/data/cs:g	()J
    //   296: invokestatic 330	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   299: invokevirtual 702	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   302: ifne +11 -> 313
    //   305: aload 7
    //   307: invokevirtual 703	java/util/HashSet:isEmpty	()Z
    //   310: ifeq -71 -> 239
    //   313: aload_1
    //   314: invokevirtual 704	java/util/ArrayList:isEmpty	()Z
    //   317: ifeq +13 -> 330
    //   320: aload_1
    //   321: aload 6
    //   323: invokevirtual 132	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   326: pop
    //   327: goto -88 -> 239
    //   330: aload_1
    //   331: aload_1
    //   332: invokevirtual 428	java/util/ArrayList:size	()I
    //   335: iconst_1
    //   336: isub
    //   337: invokevirtual 705	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   340: checkcast 109	com/whatsapp/data/cs
    //   343: astore 8
    //   345: aload 8
    //   347: getfield 629	com/whatsapp/data/cs:e	Ljava/lang/String;
    //   350: aload 6
    //   352: getfield 629	com/whatsapp/data/cs:e	Ljava/lang/String;
    //   355: invokevirtual 250	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   358: ifeq +25 -> 383
    //   361: aload 8
    //   363: getfield 239	com/whatsapp/data/cs:d	Lcom/whatsapp/data/cs$a;
    //   366: getfield 360	com/whatsapp/data/cs$a:b	Ljava/lang/String;
    //   369: aload 6
    //   371: getfield 239	com/whatsapp/data/cs:d	Lcom/whatsapp/data/cs$a;
    //   374: getfield 360	com/whatsapp/data/cs$a:b	Ljava/lang/String;
    //   377: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   380: ifne -141 -> 239
    //   383: aload_1
    //   384: aload 6
    //   386: invokevirtual 132	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   389: pop
    //   390: goto -151 -> 239
    //   393: aload 5
    //   395: invokeinterface 174 1 0
    //   400: aload_0
    //   401: aload_1
    //   402: invokevirtual 647	com/whatsapp/data/ct:a	(Ljava/util/ArrayList;)V
    //   405: new 67	java/lang/StringBuilder
    //   408: dup
    //   409: ldc_w 707
    //   412: invokespecial 72	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   415: aload_1
    //   416: invokevirtual 428	java/util/ArrayList:size	()I
    //   419: invokevirtual 302	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   422: ldc_w 709
    //   425: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: invokestatic 225	java/lang/System:currentTimeMillis	()J
    //   431: lload_3
    //   432: lsub
    //   433: invokevirtual 287	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   436: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   439: invokestatic 290	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   442: return
    //   443: astore_1
    //   444: goto -219 -> 225
    //   447: astore 5
    //   449: aconst_null
    //   450: astore 5
    //   452: goto -258 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	455	0	this	ct
    //   0	455	1	paramArrayList	ArrayList<cs>
    //   0	455	2	paramSet	Set<String>
    //   32	400	3	l	long
    //   87	307	5	localObject1	Object
    //   447	1	5	localException1	Exception
    //   450	1	5	localObject2	Object
    //   16	138	6	localObject3	Object
    //   192	1	6	localException2	Exception
    //   254	131	6	localcs	cs
    //   7	299	7	localHashSet	java.util.HashSet
    //   107	255	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   162	189	192	java/lang/Exception
    //   104	153	224	finally
    //   162	189	443	finally
    //   104	153	447	java/lang/Exception
  }
  
  public final void a(Collection<String> paramCollection, Map<String, cs> paramMap)
  {
    long l = System.currentTimeMillis();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("wa_contacts.jid IN (");
    Object localObject2 = paramCollection.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      DatabaseUtils.appendEscapedSQLString((StringBuilder)localObject1, (String)((Iterator)localObject2).next());
      ((StringBuilder)localObject1).append(',');
    }
    ((StringBuilder)localObject1).replace(((StringBuilder)localObject1).length() - 1, ((StringBuilder)localObject1).length(), ")");
    localObject1 = this.c.a(ContactProvider.a, cs.b, ((StringBuilder)localObject1).toString(), null, null);
    if (localObject1 == null)
    {
      Log.e("unable to load conversations list contacts " + paramCollection);
      return;
    }
    for (;;)
    {
      if (((Cursor)localObject1).moveToNext())
      {
        localObject2 = cs.b((Cursor)localObject1);
        cs localcs = (cs)paramMap.get(((cs)localObject2).t);
        if ((localcs != null) && ((localcs.d != null) || (((cs)localObject2).d == null)) && ((localcs.d == null) || (((cs)localObject2).d == null) || (localcs.d.a != -2L)) && ((!((cs)localObject2).h) || (localcs.h))) {
          break label338;
        }
        d((cs)localObject2);
        paramMap.put(((cs)localObject2).t, localObject2);
        i += 1;
      }
      label338:
      for (;;)
      {
        break;
        ((Cursor)localObject1).close();
        Log.i("loaded " + i + '/' + paramMap.size() + " conversations list contacts from " + paramCollection.size() + " jids | time: " + (System.currentTimeMillis() - l));
        return;
      }
      int i = 0;
    }
  }
  
  public final ArrayList<cu> b()
  {
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.c.a(ContactProvider.e, cu.a, null, null, null);
    if (localCursor != null)
    {
      while (localCursor.moveToNext()) {
        localArrayList.add(cu.a(localCursor));
      }
      localCursor.close();
    }
    return localArrayList;
  }
  
  public final void b(cs paramcs)
  {
    long l = System.currentTimeMillis();
    ContentValues localContentValues = new ContentValues(5);
    localContentValues.put("display_name", paramcs.e);
    localContentValues.put("phone_label", paramcs.g);
    localContentValues.put("number", paramcs.j);
    localContentValues.put("is_whatsapp_user", Boolean.valueOf(paramcs.h));
    a(localContentValues, paramcs.t);
    Log.i("updated group info for jid=" + paramcs.t + ' ' + localContentValues + " | time: " + (System.currentTimeMillis() - l));
  }
  
  public final void c(cs paramcs)
  {
    long l = SystemClock.elapsedRealtime();
    Object localObject1 = this.c;
    Object localObject2 = ContactProvider.c;
    String str = paramcs.t;
    localObject1 = ((b)localObject1).a((Uri)localObject2, new String[] { "jid", "capability", "value" }, "jid=?", new String[] { str }, null);
    if (localObject1 == null)
    {
      Log.e("unable to load contact capabilities; contact=" + paramcs);
      return;
    }
    try
    {
      while (((Cursor)localObject1).moveToNext())
      {
        localObject2 = ((Cursor)localObject1).getString(0);
        str = ((Cursor)localObject1).getString(1);
        ((Cursor)localObject1).getString(2);
        str.hashCode();
        Log.w("skipping unknown capability in contacts database; jid=" + (String)localObject2 + "; capability=" + str);
      }
      Log.i("loaded capabilities for " + paramcs.t + " | time: " + (SystemClock.elapsedRealtime() - l));
    }
    finally
    {
      ((Cursor)localObject1).close();
    }
  }
  
  public final void d(cs paramcs)
  {
    a(paramcs, aus.a().b());
  }
  
  public static enum a
  {
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract int a(Uri paramUri);
    
    public abstract int a(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString);
    
    public abstract Cursor a(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2);
    
    public abstract Uri a(Uri paramUri, ContentValues paramContentValues);
    
    public abstract ContentProviderResult[] a(ArrayList<ContentProviderOperation> paramArrayList);
  }
  
  static final class c
    implements ct.b
  {
    private final ContentProvider a;
    
    c(ContentProvider paramContentProvider)
    {
      this.a = paramContentProvider;
    }
    
    public final int a(Uri paramUri)
    {
      return this.a.delete(paramUri, null, null);
    }
    
    public final int a(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
    {
      return this.a.update(paramUri, paramContentValues, paramString, paramArrayOfString);
    }
    
    public final Cursor a(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
    {
      return this.a.query(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
    }
    
    public final Uri a(Uri paramUri, ContentValues paramContentValues)
    {
      return this.a.insert(paramUri, paramContentValues);
    }
    
    public final ContentProviderResult[] a(ArrayList<ContentProviderOperation> paramArrayList)
    {
      return this.a.applyBatch(paramArrayList);
    }
  }
  
  static final class d
    implements ct.b
  {
    private final ContentProviderClient a;
    
    private d(ContentProviderClient paramContentProviderClient)
    {
      this.a = paramContentProviderClient;
    }
    
    public final int a(Uri paramUri)
    {
      try
      {
        int i = this.a.delete(paramUri, null, null);
        return i;
      }
      catch (RemoteException paramUri) {}
      return -1;
    }
    
    public final int a(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
    {
      try
      {
        int i = this.a.update(paramUri, paramContentValues, paramString, paramArrayOfString);
        return i;
      }
      catch (RemoteException paramUri) {}
      return -1;
    }
    
    public final Cursor a(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
    {
      try
      {
        paramUri = this.a.query(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
        return paramUri;
      }
      catch (RemoteException paramUri) {}
      return null;
    }
    
    public final Uri a(Uri paramUri, ContentValues paramContentValues)
    {
      try
      {
        paramUri = this.a.insert(paramUri, paramContentValues);
        return paramUri;
      }
      catch (RemoteException paramUri) {}
      return null;
    }
    
    public final ContentProviderResult[] a(ArrayList<ContentProviderOperation> paramArrayList)
    {
      return this.a.applyBatch(paramArrayList);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/data/ct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */