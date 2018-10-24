package com.whatsapp.contact.sync;

import a.a.a.a.a.a.d;
import a.a.a.a.d;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.text.TextUtils;
import com.whatsapp.and;
import com.whatsapp.atu;
import com.whatsapp.atv;
import com.whatsapp.cg;
import com.whatsapp.data.cs;
import com.whatsapp.data.cs.a;
import com.whatsapp.data.ct;
import com.whatsapp.data.e;
import com.whatsapp.fieldstats.events.o;
import com.whatsapp.messaging.aj;
import com.whatsapp.u;
import com.whatsapp.util.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ContactSyncManager
{
  private static volatile ContactSyncManager d;
  public final atv a;
  public final Map<String, c> b = new HashMap();
  public final Map<String, a> c = new HashMap();
  private final Context e;
  private final com.whatsapp.messaging.w f;
  private final e g;
  private final and h;
  private final aj i;
  private final atu j;
  
  private ContactSyncManager(Context paramContext, com.whatsapp.messaging.w paramw, e parame, and paramand, aj paramaj, atu paramatu, atv paramatv)
  {
    this.e = paramContext;
    this.f = paramw;
    this.g = parame;
    this.h = paramand;
    this.i = paramaj;
    this.j = paramatu;
    this.a = paramatv;
  }
  
  private b a(String paramString, List<byte[]> paramList)
  {
    Object localObject2 = this.e;
    Object localObject3 = this.h;
    Object localObject4 = this.j;
    Object localObject1;
    if (this.a.b())
    {
      localObject1 = p.a;
      localObject4 = d.b((and)localObject3, (atu)localObject4, (p)localObject1);
      if (localObject4 != null) {
        break label62;
      }
      localObject1 = null;
    }
    for (;;)
    {
      if (localObject1 != null) {
        break label177;
      }
      return null;
      localObject1 = p.b;
      break;
      label62:
      ((Set)localObject4).addAll(d.a((Context)localObject2, (and)localObject3));
      localObject1 = new HashMap();
      localObject2 = ((Set)localObject4).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (n)((Iterator)localObject2).next();
        if (!((Map)localObject1).containsKey(((n)localObject3).c)) {
          ((Map)localObject1).put(((n)localObject3).c, new ArrayList());
        }
        ((List)((Map)localObject1).get(((n)localObject3).c)).add(localObject3);
      }
    }
    label177:
    localObject4 = this.g.b.a();
    Map localMap = m.a(this.e, this.j);
    localObject3 = new b();
    HashSet localHashSet = b();
    if (!paramList.isEmpty()) {}
    for (;;)
    {
      Object localObject5;
      n localn;
      cs localcs;
      try
      {
        localObject2 = MessageDigest.getInstance("MD5");
        Iterator localIterator = ((Map)localObject1).entrySet().iterator();
        if (!localIterator.hasNext()) {
          break label560;
        }
        localObject5 = (Map.Entry)localIterator.next();
        localn = (n)((List)((Map.Entry)localObject5).getValue()).get(0);
        if (((List)((Map.Entry)localObject5).getValue()).size() > 1) {
          Log.d(paramString + "multiple_phones_with_number number=" + (String)((Map.Entry)localObject5).getKey());
        }
        localcs = (cs)((Map)localObject4).get(((Map.Entry)localObject5).getKey());
        if (localcs == null) {
          break label475;
        }
        if ((!paramList.isEmpty()) && (!localcs.h) && (a(localcs, paramList, (MessageDigest)localObject2)))
        {
          ((b)localObject3).e.add(localcs);
          continue;
        }
        if (!localcs.a(localn, (m)localMap.get(Long.valueOf(localn.a)))) {
          break label465;
        }
      }
      catch (NoSuchAlgorithmException paramString)
      {
        throw new AssertionError(paramString);
      }
      ((b)localObject3).b.add(localcs);
      continue;
      label465:
      ((b)localObject3).a(localcs);
      continue;
      label475:
      if (localHashSet.contains(((Map.Entry)localObject5).getKey()))
      {
        ((b)localObject3).a(new cs(localn));
      }
      else
      {
        localObject5 = new cs(localn);
        ((cs)localObject5).a(localn, (m)localMap.get(Long.valueOf(localn.a)));
        ((b)localObject3).a.add(localObject5);
        continue;
        label560:
        paramList = ((Map)localObject4).entrySet().iterator();
        while (paramList.hasNext())
        {
          localObject2 = (Map.Entry)paramList.next();
          if (!((Map)localObject1).containsKey(((Map.Entry)localObject2).getKey()))
          {
            localObject2 = (cs)((Map.Entry)localObject2).getValue();
            ((b)localObject3).c.add(localObject2);
          }
        }
        cs.a(((b)localObject3).a, paramString + "add");
        cs.a(((b)localObject3).b, paramString + "update");
        cs.a(((b)localObject3).c, paramString + "remove");
        cs.a(((b)localObject3).d, paramString + "unchanged");
        cs.a(((b)localObject3).e, paramString + "updateContactsMatchingJidHash");
        return (b)localObject3;
        localObject2 = null;
      }
    }
  }
  
  public static ContactSyncManager a()
  {
    if (d == null) {}
    try
    {
      if (d == null) {
        d = new ContactSyncManager(u.a(), com.whatsapp.messaging.w.a(), e.a(), and.a(), aj.a(), atu.a(), atv.a());
      }
      return d;
    }
    finally {}
  }
  
  private v a(w paramw, o paramo, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = SystemClock.elapsedRealtime();
    b localb;
    Object localObject1;
    HashSet localHashSet1;
    HashSet localHashSet2;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    try
    {
      localb = a("sync/sync_all/", Collections.emptyList());
      if (localb == null) {
        return v.d;
      }
      localObject1 = new ArrayList();
      localHashSet1 = new HashSet();
      localHashSet2 = new HashSet();
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).addAll(localb.a);
      ((ArrayList)localObject2).addAll(localb.b);
      ((ArrayList)localObject2).addAll(localb.d);
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (cs)((Iterator)localObject2).next();
        if ((((cs)localObject3).d != null) && (!TextUtils.isEmpty(((cs)localObject3).d.b)))
        {
          localObject4 = new ParcelableSyncUserRequest((cs)localObject3);
          ((ParcelableSyncUserRequest)localObject4).e = true;
          ((ParcelableSyncUserRequest)localObject4).f = paramBoolean1;
          ((ParcelableSyncUserRequest)localObject4).g = paramBoolean2;
          ((ArrayList)localObject1).add(localObject4);
          if (((cs)localObject3).d.b != null) {
            localHashSet2.add(((cs)localObject3).d.b);
          }
          if (((cs)localObject3).t != null) {
            localHashSet1.add(((cs)localObject3).t);
          }
        }
      }
      localObject2 = new ArrayList();
    }
    catch (Exception paramw)
    {
      Log.d("sync/sync_all/error", paramw);
      Log.i("sync/sync_all/time/" + (SystemClock.elapsedRealtime() - l) + " (error)");
      return v.d;
    }
    if ((paramBoolean1) || (paramBoolean2))
    {
      localObject3 = this.g.f().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (cs)((Iterator)localObject3).next();
        if (((((cs)localObject4).d == null) || (!localHashSet2.contains(((cs)localObject4).d.b))) && (!localHashSet1.contains(((cs)localObject4).t)) && (!e.b(((cs)localObject4).t)))
        {
          ParcelableSyncUserRequest localParcelableSyncUserRequest = new ParcelableSyncUserRequest((cs)localObject4);
          localParcelableSyncUserRequest.f = paramBoolean1;
          localParcelableSyncUserRequest.g = paramBoolean2;
          ((ArrayList)localObject1).add(localParcelableSyncUserRequest);
          ((ArrayList)localObject2).add(localObject4);
        }
      }
    }
    paramo.l = Long.valueOf(((ArrayList)localObject1).size());
    paramw = this.f.a(paramw, a("sync_sid_full"), (ArrayList)localObject1, cg.a);
    if (paramw == null)
    {
      paramw = v.d;
      return paramw;
    }
    try
    {
      paramw.get(64000L, TimeUnit.MILLISECONDS);
      a(this.b, localb.a, null);
      a(this.b, localb.b, null);
      paramw = new ArrayList();
      a(this.b, localb.d, paramw);
      b(this.c, localb.a, null);
      b(this.c, localb.b, null);
      paramo = new ArrayList();
      b(this.c, localb.d, paramo);
      localObject1 = new ArrayList();
      b(this.c, (List)localObject2, (Collection)localObject1);
      Log.i("sync/sync_all/contacts_removed");
      if (!localb.c.isEmpty()) {
        this.g.b(localb.c);
      }
      Log.i("sync/sync_all/contacts_added");
      if (!localb.a.isEmpty())
      {
        this.g.a(localb.a);
        this.i.a(new ArrayList(localb.a));
      }
      Log.i("sync/sync_all/contacts_changed_by_updated");
      if (!localb.b.isEmpty()) {
        this.g.c(localb.b);
      }
      Log.i("sync/sync_all/contacts_changed_by_server");
      if (!paramw.isEmpty()) {
        this.g.c(paramw);
      }
      Log.i("sync/sync_all/contacts_changed_by_status");
      if (!paramo.isEmpty()) {
        this.g.c(paramo);
      }
      Log.i("sync/sync_all/other_individual_contacts/size/" + ((ArrayList)localObject2).size());
      if (!((Collection)localObject1).isEmpty())
      {
        paramo = ((Collection)localObject1).iterator();
        while (paramo.hasNext())
        {
          localObject1 = (cs)paramo.next();
          this.g.a(((cs)localObject1).t, ((cs)localObject1).v, ((cs)localObject1).u);
        }
      }
      Log.i("sync/sync_all/time/" + (SystemClock.elapsedRealtime() - l));
    }
    catch (Exception paramw)
    {
      return v.d;
    }
    if ((!localb.a()) || (!paramw.isEmpty())) {
      return v.c;
    }
    paramw = v.b;
    return paramw;
  }
  
  private v a(w paramw, List<byte[]> paramList, o paramo)
  {
    long l = SystemClock.elapsedRealtime();
    ArrayList localArrayList;
    HashSet localHashSet;
    Object localObject1;
    Object localObject2;
    try
    {
      paramList = a("sync/sync_delta/", paramList);
      if (paramList == null) {
        return v.d;
      }
      localArrayList = new ArrayList();
      localHashSet = new HashSet();
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(paramList.a);
      ((ArrayList)localObject1).addAll(paramList.e);
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (cs)((Iterator)localObject1).next();
        if ((((cs)localObject2).d != null) && (!TextUtils.isEmpty(((cs)localObject2).d.b)) && (!e.b(((cs)localObject2).t)))
        {
          ParcelableSyncUserRequest localParcelableSyncUserRequest = new ParcelableSyncUserRequest((cs)localObject2);
          localParcelableSyncUserRequest.e = true;
          localParcelableSyncUserRequest.f = true;
          localParcelableSyncUserRequest.g = true;
          localArrayList.add(localParcelableSyncUserRequest);
          localHashSet.add(((cs)localObject2).d.b);
        }
      }
      localObject1 = paramList.c.iterator();
    }
    catch (Exception paramw)
    {
      Log.d("sync/sync_delta/error", paramw);
      return v.d;
    }
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (cs)((Iterator)localObject1).next();
      if ((((cs)localObject2).d != null) && (!TextUtils.isEmpty(((cs)localObject2).d.b)) && (!localHashSet.contains(((cs)localObject2).d.b)) && (!e.b(((cs)localObject2).t)))
      {
        localObject2 = new ParcelableSyncUserRequest((cs)localObject2);
        ((ParcelableSyncUserRequest)localObject2).e = true;
        ((ParcelableSyncUserRequest)localObject2).c = true;
        localArrayList.add(localObject2);
      }
    }
    Log.d("sync/sync_delta/request/count " + localArrayList.size());
    paramo.l = Long.valueOf(localArrayList.size());
    if (!localArrayList.isEmpty())
    {
      paramw = this.f.a(paramw, a("sync_sid_delta"), localArrayList, cg.a);
      if (paramw == null)
      {
        paramw = v.d;
        return paramw;
      }
    }
    try
    {
      paramw.get(64000L, TimeUnit.MILLISECONDS);
      a(this.b, paramList.a, null);
      a(this.b, paramList.e, null);
      b(this.c, paramList.e, null);
      b(this.c, paramList.a, null);
      if (!paramList.c.isEmpty()) {
        this.g.b(paramList.c);
      }
      if (!paramList.a.isEmpty())
      {
        this.g.a(paramList.a);
        this.i.a(new ArrayList(paramList.a));
      }
      if (!paramList.e.isEmpty()) {
        this.g.c(paramList.e);
      }
      if (!paramList.b.isEmpty()) {
        this.g.c(paramList.b);
      }
      Log.i("sync/sync_delta/time/" + (SystemClock.elapsedRealtime() - l));
      if (!paramList.a()) {
        return v.c;
      }
    }
    catch (Exception paramw)
    {
      return v.d;
    }
    paramw = v.b;
    return paramw;
  }
  
  /* Error */
  private v a(w paramw, boolean paramBoolean1, boolean paramBoolean2, o paramo)
  {
    // Byte code:
    //   0: invokestatic 312	android/os/SystemClock:elapsedRealtime	()J
    //   3: lstore 5
    //   5: new 123	java/util/ArrayList
    //   8: dup
    //   9: invokespecial 124	java/util/ArrayList:<init>	()V
    //   12: astore 7
    //   14: aload_0
    //   15: getfield 59	com/whatsapp/contact/sync/ContactSyncManager:g	Lcom/whatsapp/data/e;
    //   18: invokevirtual 374	com/whatsapp/data/e:f	()Ljava/util/ArrayList;
    //   21: invokevirtual 330	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   24: astore 8
    //   26: aload 8
    //   28: invokeinterface 106 1 0
    //   33: ifeq +103 -> 136
    //   36: aload 8
    //   38: invokeinterface 110 1 0
    //   43: checkcast 208	com/whatsapp/data/cs
    //   46: astore 9
    //   48: aload 9
    //   50: getfield 355	com/whatsapp/data/cs:t	Ljava/lang/String;
    //   53: invokestatic 378	com/whatsapp/data/e:b	(Ljava/lang/String;)Z
    //   56: ifne -30 -> 26
    //   59: new 11	com/whatsapp/contact/sync/ContactSyncManager$ParcelableSyncUserRequest
    //   62: dup
    //   63: aload 9
    //   65: invokespecial 344	com/whatsapp/contact/sync/ContactSyncManager$ParcelableSyncUserRequest:<init>	(Lcom/whatsapp/data/cs;)V
    //   68: astore 9
    //   70: aload 9
    //   72: iload_2
    //   73: putfield 348	com/whatsapp/contact/sync/ContactSyncManager$ParcelableSyncUserRequest:f	Z
    //   76: aload 9
    //   78: iload_3
    //   79: putfield 350	com/whatsapp/contact/sync/ContactSyncManager$ParcelableSyncUserRequest:g	Z
    //   82: aload 7
    //   84: aload 9
    //   86: invokevirtual 351	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   89: pop
    //   90: goto -64 -> 26
    //   93: astore_1
    //   94: ldc_w 481
    //   97: aload_1
    //   98: invokestatic 360	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   101: new 185	java/lang/StringBuilder
    //   104: dup
    //   105: ldc_w 483
    //   108: invokespecial 364	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   111: invokestatic 312	android/os/SystemClock:elapsedRealtime	()J
    //   114: lload 5
    //   116: lsub
    //   117: invokevirtual 367	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   120: ldc_w 369
    //   123: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 371	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   132: getstatic 460	com/whatsapp/contact/sync/v:c	Lcom/whatsapp/contact/sync/v;
    //   135: areturn
    //   136: aload 4
    //   138: aload 7
    //   140: invokevirtual 379	java/util/ArrayList:size	()I
    //   143: i2l
    //   144: invokestatic 231	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   147: putfield 385	com/whatsapp/fieldstats/events/o:l	Ljava/lang/Long;
    //   150: aload_0
    //   151: getfield 57	com/whatsapp/contact/sync/ContactSyncManager:f	Lcom/whatsapp/messaging/w;
    //   154: aload_1
    //   155: ldc_w 387
    //   158: invokestatic 390	com/whatsapp/contact/sync/ContactSyncManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   161: aload 7
    //   163: getstatic 395	com/whatsapp/cg:a	[Ljava/lang/String;
    //   166: invokevirtual 398	com/whatsapp/messaging/w:a	(Lcom/whatsapp/contact/sync/w;Ljava/lang/String;Ljava/util/ArrayList;[Ljava/lang/String;)Ljava/util/concurrent/Future;
    //   169: astore_1
    //   170: aload_1
    //   171: ifnonnull +40 -> 211
    //   174: getstatic 327	com/whatsapp/contact/sync/v:d	Lcom/whatsapp/contact/sync/v;
    //   177: astore_1
    //   178: new 185	java/lang/StringBuilder
    //   181: dup
    //   182: ldc_w 483
    //   185: invokespecial 364	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   188: invokestatic 312	android/os/SystemClock:elapsedRealtime	()J
    //   191: lload 5
    //   193: lsub
    //   194: invokevirtual 367	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   197: ldc_w 369
    //   200: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokestatic 371	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   209: aload_1
    //   210: areturn
    //   211: aload_1
    //   212: ldc2_w 399
    //   215: getstatic 406	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   218: invokeinterface 411 4 0
    //   223: pop
    //   224: aload_0
    //   225: getfield 53	com/whatsapp/contact/sync/ContactSyncManager:c	Ljava/util/Map;
    //   228: aload_0
    //   229: getfield 59	com/whatsapp/contact/sync/ContactSyncManager:g	Lcom/whatsapp/data/e;
    //   232: invokevirtual 374	com/whatsapp/data/e:f	()Ljava/util/ArrayList;
    //   235: aconst_null
    //   236: invokestatic 416	com/whatsapp/contact/sync/ContactSyncManager:b	(Ljava/util/Map;Ljava/util/List;Ljava/util/Collection;)V
    //   239: new 185	java/lang/StringBuilder
    //   242: dup
    //   243: ldc_w 483
    //   246: invokespecial 364	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   249: invokestatic 312	android/os/SystemClock:elapsedRealtime	()J
    //   252: lload 5
    //   254: lsub
    //   255: invokevirtual 367	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   258: ldc_w 369
    //   261: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokestatic 371	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   270: goto -138 -> 132
    //   273: astore_1
    //   274: getstatic 327	com/whatsapp/contact/sync/v:d	Lcom/whatsapp/contact/sync/v;
    //   277: astore_1
    //   278: new 185	java/lang/StringBuilder
    //   281: dup
    //   282: ldc_w 483
    //   285: invokespecial 364	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   288: invokestatic 312	android/os/SystemClock:elapsedRealtime	()J
    //   291: lload 5
    //   293: lsub
    //   294: invokevirtual 367	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   297: ldc_w 369
    //   300: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: invokestatic 371	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   309: aload_1
    //   310: areturn
    //   311: astore_1
    //   312: new 185	java/lang/StringBuilder
    //   315: dup
    //   316: ldc_w 483
    //   319: invokespecial 364	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   322: invokestatic 312	android/os/SystemClock:elapsedRealtime	()J
    //   325: lload 5
    //   327: lsub
    //   328: invokevirtual 367	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   331: ldc_w 369
    //   334: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokestatic 371	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   343: aload_1
    //   344: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	345	0	this	ContactSyncManager
    //   0	345	1	paramw	w
    //   0	345	2	paramBoolean1	boolean
    //   0	345	3	paramBoolean2	boolean
    //   0	345	4	paramo	o
    //   3	323	5	l	long
    //   12	150	7	localArrayList	ArrayList
    //   24	13	8	localIterator	Iterator
    //   46	39	9	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	26	93	java/lang/Exception
    //   26	90	93	java/lang/Exception
    //   136	170	93	java/lang/Exception
    //   174	178	93	java/lang/Exception
    //   224	239	93	java/lang/Exception
    //   274	278	93	java/lang/Exception
    //   211	224	273	java/lang/Exception
    //   5	26	311	finally
    //   26	90	311	finally
    //   94	101	311	finally
    //   136	170	311	finally
    //   174	178	311	finally
    //   211	224	311	finally
    //   224	239	311	finally
    //   274	278	311	finally
  }
  
  public static String a(String paramString)
  {
    return paramString + '_' + UUID.randomUUID().toString();
  }
  
  private static void a(Map<String, c> paramMap, List<cs> paramList, Collection<cs> paramCollection)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      cs localcs = (cs)paramList.next();
      Object localObject = (c)paramMap.get(localcs.d.b);
      if (localObject == null)
      {
        Log.w("sync/missing_response/" + localcs.d.b);
      }
      else
      {
        if (((c)localObject).c == 1) {}
        for (boolean bool = true;; bool = false)
        {
          localObject = ((c)localObject).a;
          if ((localcs.h == bool) && (TextUtils.equals(localcs.t, (CharSequence)localObject))) {
            break;
          }
          localcs.h = bool;
          localcs.t = ((String)localObject);
          if (paramCollection == null) {
            break;
          }
          paramCollection.add(localcs);
          break;
        }
      }
    }
  }
  
  private static boolean a(cs paramcs, List<byte[]> paramList, MessageDigest paramMessageDigest)
  {
    paramcs = paramcs.t;
    if (paramcs.equals("s.whatsapp.net")) {
      return false;
    }
    paramMessageDigest.update((paramcs.substring(0, paramcs.length() - 15) + "WA_ADD_NOTIF").getBytes());
    paramcs = paramMessageDigest.digest();
    int k = 0;
    label62:
    if (k < paramList.size())
    {
      paramMessageDigest = (byte[])paramList.get(k);
      if (paramcs.length >= paramMessageDigest.length)
      {
        m = 0;
        label93:
        if (m >= paramMessageDigest.length) {
          break label137;
        }
        if (paramcs[m] == paramMessageDigest[m]) {}
      }
    }
    label137:
    for (int m = 0;; m = 1)
    {
      if (m != 0)
      {
        return true;
        m += 1;
        break label93;
      }
      k += 1;
      break label62;
      break;
    }
  }
  
  private static void b(Map<String, a> paramMap, List<cs> paramList, Collection<cs> paramCollection)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      cs localcs = (cs)paramList.next();
      a locala = (a)paramMap.get(localcs.t);
      if ((locala != null) && ((!TextUtils.equals(locala.b, localcs.u)) || (locala.a != localcs.v)))
      {
        localcs.u = locala.b;
        localcs.v = locala.a;
        if (paramCollection != null) {
          paramCollection.add(localcs);
        }
      }
    }
  }
  
  public final v a(w paramw, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, List<byte[]> paramList, o paramo)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    for (;;)
    {
      try
      {
        if (!paramw.a()) {
          break label153;
        }
        if ((!paramBoolean1) && (!paramBoolean3))
        {
          bool1 = bool2;
          if (!paramBoolean2)
          {
            a.d.a(bool1);
            if (paramBoolean1)
            {
              paramw = a(paramw, paramo, paramBoolean2, paramBoolean3);
              if (paramw.a())
              {
                Log.d("sync/success");
                return paramw;
              }
            }
            else
            {
              paramw = a(paramw, paramBoolean2, paramBoolean3, paramo);
              continue;
              a.d.a(paramBoolean1);
              paramw = a(paramw, paramList, paramo);
              continue;
            }
            Log.d("sync/failed");
            continue;
          }
        }
        bool1 = true;
      }
      finally
      {
        this.b.clear();
        this.c.clear();
      }
      continue;
      label153:
      if ((paramBoolean1) && (paramBoolean3) && (paramBoolean2)) {
        paramBoolean1 = bool1;
      } else {
        paramBoolean1 = false;
      }
    }
  }
  
  /* Error */
  public final boolean a(HashSet<String> paramHashSet)
  {
    // Byte code:
    //   0: new 567	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: getfield 55	com/whatsapp/contact/sync/ContactSyncManager:e	Landroid/content/Context;
    //   8: invokevirtual 573	android/content/Context:getFilesDir	()Ljava/io/File;
    //   11: ldc_w 575
    //   14: invokespecial 578	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   17: astore_3
    //   18: aconst_null
    //   19: astore_2
    //   20: new 580	java/io/ObjectOutputStream
    //   23: dup
    //   24: new 582	java/io/FileOutputStream
    //   27: dup
    //   28: aload_3
    //   29: invokespecial 585	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   32: invokespecial 588	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   35: astore_3
    //   36: aload_3
    //   37: astore_2
    //   38: aload_3
    //   39: aload_1
    //   40: invokevirtual 591	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   43: aload_3
    //   44: invokevirtual 594	java/io/ObjectOutputStream:close	()V
    //   47: iconst_1
    //   48: ireturn
    //   49: astore_1
    //   50: aload_1
    //   51: invokestatic 597	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   54: goto -7 -> 47
    //   57: astore 4
    //   59: aconst_null
    //   60: astore_1
    //   61: aload_1
    //   62: astore_2
    //   63: aload 4
    //   65: invokestatic 597	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   68: aload_1
    //   69: ifnull +7 -> 76
    //   72: aload_1
    //   73: invokevirtual 594	java/io/ObjectOutputStream:close	()V
    //   76: iconst_0
    //   77: ireturn
    //   78: astore_1
    //   79: aload_1
    //   80: invokestatic 597	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   83: goto -7 -> 76
    //   86: astore_1
    //   87: aload_2
    //   88: ifnull +7 -> 95
    //   91: aload_2
    //   92: invokevirtual 594	java/io/ObjectOutputStream:close	()V
    //   95: aload_1
    //   96: athrow
    //   97: astore_2
    //   98: aload_2
    //   99: invokestatic 597	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   102: goto -7 -> 95
    //   105: astore_1
    //   106: goto -19 -> 87
    //   109: astore 4
    //   111: aload_3
    //   112: astore_1
    //   113: goto -52 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	ContactSyncManager
    //   0	116	1	paramHashSet	HashSet<String>
    //   19	73	2	localObject1	Object
    //   97	2	2	localIOException1	java.io.IOException
    //   17	95	3	localObject2	Object
    //   57	7	4	localIOException2	java.io.IOException
    //   109	1	4	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   43	47	49	java/io/IOException
    //   20	36	57	java/io/IOException
    //   72	76	78	java/io/IOException
    //   20	36	86	finally
    //   91	95	97	java/io/IOException
    //   38	43	105	finally
    //   63	68	105	finally
    //   38	43	109	java/io/IOException
  }
  
  /* Error */
  public final HashSet<String> b()
  {
    // Byte code:
    //   0: new 567	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: getfield 55	com/whatsapp/contact/sync/ContactSyncManager:e	Landroid/content/Context;
    //   8: invokevirtual 573	android/content/Context:getFilesDir	()Ljava/io/File;
    //   11: ldc_w 575
    //   14: invokespecial 578	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   17: astore_1
    //   18: aload_1
    //   19: invokevirtual 603	java/io/File:exists	()Z
    //   22: ifeq +71 -> 93
    //   25: aload_1
    //   26: invokevirtual 606	java/io/File:canRead	()Z
    //   29: ifeq +64 -> 93
    //   32: aconst_null
    //   33: astore_2
    //   34: aconst_null
    //   35: astore 4
    //   37: new 608	java/io/ObjectInputStream
    //   40: dup
    //   41: new 610	java/io/FileInputStream
    //   44: dup
    //   45: aload_1
    //   46: invokespecial 611	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   49: invokespecial 614	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   52: astore_1
    //   53: aload_1
    //   54: invokevirtual 617	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   57: checkcast 241	java/util/HashSet
    //   60: astore_2
    //   61: aload_1
    //   62: invokevirtual 618	java/io/ObjectInputStream:close	()V
    //   65: aload_2
    //   66: areturn
    //   67: astore_1
    //   68: aload_1
    //   69: invokestatic 597	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   72: aload_2
    //   73: areturn
    //   74: astore_2
    //   75: aconst_null
    //   76: astore_1
    //   77: aload_2
    //   78: astore_3
    //   79: aload_1
    //   80: astore_2
    //   81: aload_3
    //   82: invokestatic 597	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   85: aload_1
    //   86: ifnull +7 -> 93
    //   89: aload_1
    //   90: invokevirtual 618	java/io/ObjectInputStream:close	()V
    //   93: new 241	java/util/HashSet
    //   96: dup
    //   97: invokespecial 328	java/util/HashSet:<init>	()V
    //   100: areturn
    //   101: astore_1
    //   102: aload_1
    //   103: invokestatic 597	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   106: goto -13 -> 93
    //   109: astore_1
    //   110: aload_2
    //   111: ifnull +7 -> 118
    //   114: aload_2
    //   115: invokevirtual 618	java/io/ObjectInputStream:close	()V
    //   118: aload_1
    //   119: athrow
    //   120: astore_2
    //   121: aload_2
    //   122: invokestatic 597	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   125: goto -7 -> 118
    //   128: astore_3
    //   129: aload_1
    //   130: astore_2
    //   131: aload_3
    //   132: astore_1
    //   133: goto -23 -> 110
    //   136: astore_3
    //   137: aload 4
    //   139: astore_1
    //   140: goto -61 -> 79
    //   143: astore_3
    //   144: goto -65 -> 79
    //   147: astore_2
    //   148: goto -71 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	ContactSyncManager
    //   17	45	1	localObject1	Object
    //   67	2	1	localIOException1	java.io.IOException
    //   76	14	1	localObject2	Object
    //   101	2	1	localIOException2	java.io.IOException
    //   109	21	1	localObject3	Object
    //   132	8	1	localObject4	Object
    //   33	40	2	localHashSet	HashSet
    //   74	4	2	localIOException3	java.io.IOException
    //   80	35	2	localObject5	Object
    //   120	2	2	localIOException4	java.io.IOException
    //   130	1	2	localObject6	Object
    //   147	1	2	localIOException5	java.io.IOException
    //   78	4	3	localIOException6	java.io.IOException
    //   128	4	3	localObject7	Object
    //   136	1	3	localClassNotFoundException1	ClassNotFoundException
    //   143	1	3	localClassNotFoundException2	ClassNotFoundException
    //   35	103	4	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   61	65	67	java/io/IOException
    //   37	53	74	java/io/IOException
    //   89	93	101	java/io/IOException
    //   37	53	109	finally
    //   81	85	109	finally
    //   114	118	120	java/io/IOException
    //   53	61	128	finally
    //   37	53	136	java/lang/ClassNotFoundException
    //   53	61	143	java/lang/ClassNotFoundException
    //   53	61	147	java/io/IOException
  }
  
  public static class ParcelableSyncUser
    implements Parcelable
  {
    public static final Parcelable.Creator<ParcelableSyncUser> CREATOR = new Parcelable.Creator() {};
    public final ContactSyncManager.c a;
    
    public ParcelableSyncUser(ContactSyncManager.c paramc)
    {
      if (paramc == null) {
        throw new NullPointerException("syncUser must not be null");
      }
      this.a = paramc;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.a.a);
      paramParcel.writeStringList(this.a.b);
      paramParcel.writeInt(this.a.c);
      paramParcel.writeInt(this.a.d);
      paramParcel.writeLong(this.a.e);
      paramParcel.writeString(this.a.f);
    }
  }
  
  public static class ParcelableSyncUserRequest
    implements Parcelable
  {
    public static final Parcelable.Creator<ParcelableSyncUserRequest> CREATOR = new Parcelable.Creator() {};
    public final String a;
    public final String b;
    public boolean c;
    public long d;
    public boolean e;
    public boolean f;
    public boolean g;
    
    public ParcelableSyncUserRequest(cs paramcs)
    {
      this.a = paramcs.t;
      if (paramcs.d != null) {}
      for (this.b = paramcs.d.b; paramcs.h; this.b = null)
      {
        this.d = paramcs.v;
        return;
      }
      this.d = -1L;
    }
    
    public ParcelableSyncUserRequest(String paramString1, String paramString2, long paramLong)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.d = paramLong;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      paramParcel.writeString(this.a);
      paramParcel.writeString(this.b);
      if (this.c)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        paramParcel.writeLong(this.d);
        if (!this.e) {
          break label88;
        }
        paramInt = 1;
        label49:
        paramParcel.writeInt(paramInt);
        if (!this.f) {
          break label93;
        }
        paramInt = 1;
        label63:
        paramParcel.writeInt(paramInt);
        if (!this.g) {
          break label98;
        }
      }
      label88:
      label93:
      label98:
      for (paramInt = i;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        return;
        paramInt = 0;
        break;
        paramInt = 0;
        break label49;
        paramInt = 0;
        break label63;
      }
    }
  }
  
  public static final class a
  {
    long a;
    String b;
    
    public a(long paramLong, String paramString)
    {
      this.a = paramLong;
      this.b = paramString;
    }
  }
  
  static final class b
  {
    final List<cs> a = new ArrayList();
    final List<cs> b = new ArrayList();
    final List<cs> c = new ArrayList();
    final List<cs> d = new ArrayList();
    final List<cs> e = new ArrayList();
    
    public final void a(cs paramcs)
    {
      this.d.add(paramcs);
    }
    
    public final boolean a()
    {
      return (this.a.isEmpty()) && (this.b.isEmpty()) && (this.c.isEmpty());
    }
  }
  
  public static final class c
  {
    public String a;
    public List<String> b;
    public int c = 0;
    public int d = 0;
    public long e;
    public String f;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/contact/sync/ContactSyncManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */