package com.whatsapp.data;

import a.a.a.a.a.a.d;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteStatement;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.provider.MediaStore.Audio.Media;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import android.support.v4.f.f;
import android.text.TextUtils;
import android.util.Base64;
import com.whatsapp.Conversation;
import com.whatsapp.Conversation.l;
import com.whatsapp.MediaData;
import com.whatsapp.MediaView;
import com.whatsapp.MediaView.6;
import com.whatsapp.ado;
import com.whatsapp.adp;
import com.whatsapp.aic;
import com.whatsapp.and;
import com.whatsapp.ane;
import com.whatsapp.ant;
import com.whatsapp.att;
import com.whatsapp.atu;
import com.whatsapp.atv;
import com.whatsapp.auj;
import com.whatsapp.aus;
import com.whatsapp.fieldstats.events.ay;
import com.whatsapp.fieldstats.events.bh;
import com.whatsapp.fieldstats.events.bl;
import com.whatsapp.lt;
import com.whatsapp.messaging.ae;
import com.whatsapp.messaging.w;
import com.whatsapp.ox;
import com.whatsapp.oz;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.protocol.k;
import com.whatsapp.pv;
import com.whatsapp.qz;
import com.whatsapp.rf;
import com.whatsapp.rg;
import com.whatsapp.rh;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils;
import com.whatsapp.util.bd;
import com.whatsapp.util.r.b;
import com.whatsapp.util.x;
import com.whatsapp.va;
import com.whatsapp.va.a;
import com.whatsapp.vk;
import com.whatsapp.vv;
import com.whatsapp.yr;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class ad
{
  private static volatile ad G;
  static boolean a;
  private static final String af = "(needs_push!=" + Integer.toString(2) + " OR key_remote_jid LIKE '%broadcast')";
  private static final String ag = "SELECT key_remote_jid FROM messages WHERE key_from_me=1 AND status=? AND timestamp>? AND " + af + " ORDER BY timestamp ASC";
  private static final String ah = "SELECT key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, raw_data, recipient_count, participant_hash, starred, quoted_row_id, mentioned_jids, multicast_id, edit_version, receipt_server_timestamp, media_enc_hash, _id, key_remote_jid FROM messages WHERE key_from_me=1 AND status<? AND _id>? AND " + af + " ORDER BY _id ASC";
  private static final String ai = "SELECT key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, raw_data, recipient_count, participant_hash, starred, quoted_row_id, mentioned_jids, multicast_id, edit_version, receipt_server_timestamp, media_enc_hash, _id, key_remote_jid FROM messages WHERE key_from_me=1 AND key_remote_jid=? AND status<? AND timestamp>? AND timestamp<? AND " + af + " ORDER BY timestamp ASC";
  private static final String aj = "SELECT " + d("messages", "key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, raw_data, recipient_count, participant_hash, starred, quoted_row_id, mentioned_jids, multicast_id, edit_version, receipt_server_timestamp, media_enc_hash, _id") + ", messages.key_remote_jid AS messages_key_remote_jid FROM messages,chat_list WHERE messages.key_remote_jid=chat_list.key_remote_jid AND messages.key_from_me=0 AND chat_list.last_read_message_table_id>=messages._id AND chat_list.last_read_receipt_sent_message_table_id<messages._id AND chat_list.last_read_receipt_sent_message_table_id>0 AND messages.media_wa_type!=8 AND messages" + ".media_wa_type!=10 ORDER BY messages._id DESC LIMIT 4096";
  private static final String ak = "SELECT key_id, key_from_me, receipt_server_timestamp, receipt_device_timestamp, read_device_timestamp, played_device_timestamp, status FROM messages WHERE key_remote_jid=? AND (key_from_me=1 OR (media_wa_type=" + Integer.toString(2) + " AND origin=" + Integer.toString(1) + ")) AND _id>? ";
  private static final String al = "SELECT " + d("messages", "key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, raw_data, recipient_count, participant_hash, starred, quoted_row_id, mentioned_jids, multicast_id, edit_version, receipt_server_timestamp, media_enc_hash, _id") + " FROM messages,chat_list WHERE messages.key_remote_jid=chat_list.key_remote_jid AND message_table_id=messages._id AND chat_list.key_remote_jid=?";
  private static final String am = "SELECT " + d("c", "key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, raw_data, recipient_count, participant_hash, starred, quoted_row_id, mentioned_jids, multicast_id, edit_version, receipt_server_timestamp, media_enc_hash, _id") + " FROM messages c INNER JOIN ( SELECT remote_resource,max(_id) AS maxid FROM messages  WHERE key_remote_jid=? AND key_from_me=0 AND timestamp>? AND media_wa_type=5 GROUP BY remote_resource ) b ON c.remote_resource=b.remote_resource AND c._id=b.maxid ORDER BY _id DESC";
  final com.whatsapp.a.c A;
  public final lt B;
  public final o C;
  final ck D;
  final rh E;
  final Object F = new Object();
  private final HandlerThread H = new HandlerThread("Messages Async Commit Thread");
  private final File I;
  private final Context J;
  private final z K;
  private final AtomicBoolean L;
  private final ReentrantReadWriteLock M;
  private boolean N;
  private final cm O;
  private final adp P;
  private final e Q;
  private final and R;
  private final aus S;
  private final c T;
  private final u U;
  private final y V;
  private final vv W;
  private final ane X;
  private final cr Y;
  private final cl Z;
  private final atv aa;
  private final cq ab;
  private final m ac;
  private final ci ad;
  private final ae ae;
  public final n b;
  public final cb c;
  public final b d;
  public final File e;
  final f<j.b, ck.a> f;
  public final Map<j.b, j> g;
  final ReentrantReadWriteLock.WriteLock h;
  public final ReentrantReadWriteLock.ReadLock i;
  final ant j;
  final pv k;
  public final va l;
  public final oz m;
  public final d n;
  final att o;
  public final s p;
  final com.whatsapp.messaging.aj q;
  public final q r;
  final com.whatsapp.ba s;
  public final l t;
  final ac u;
  final cj v;
  public final cn w;
  public final co x;
  final aa y;
  public final ch z;
  
  @SuppressLint({"HandlerLeak"})
  private ad(Context paramContext, ant paramant, pv parampv, com.whatsapp.util.a.c paramc, va paramva, d paramd, oz paramoz, ox paramox, cm paramcm, adp paramadp, att paramatt, e parame, s params, and paramand, com.whatsapp.messaging.aj paramaj, aus paramaus, c paramc1, q paramq, com.whatsapp.ba paramba, l paraml, ac paramac, u paramu, y paramy, vv paramvv, cj paramcj, cn paramcn, ane paramane, cr paramcr, co paramco, aa paramaa, ch paramch, cl paramcl, atu paramatu, atv paramatv, com.whatsapp.a.c paramc2, lt paramlt, o paramo, ck paramck, cq paramcq, m paramm, ci paramci, rh paramrh, ae paramae)
  {
    this.H.start();
    this.d = new b(this.H.getLooper(), (byte)0);
    this.J = paramContext;
    this.I = paramContext.getDatabasePath("msgstore.db-backup");
    this.j = paramant;
    this.k = parampv;
    this.l = paramva;
    this.n = paramd;
    this.m = paramoz;
    this.O = paramcm;
    this.P = paramadp;
    this.o = paramatt;
    this.Q = parame;
    this.p = params;
    this.R = paramand;
    this.q = paramaj;
    this.S = paramaus;
    this.T = paramc1;
    this.r = paramq;
    this.s = paramba;
    this.t = paraml;
    this.u = paramac;
    this.U = paramu;
    this.V = paramy;
    this.W = paramvv;
    this.v = paramcj;
    this.w = paramcn;
    this.X = paramane;
    this.Y = paramcr;
    this.x = paramco;
    this.y = paramaa;
    this.z = paramch;
    this.Z = paramcl;
    this.aa = paramatv;
    this.A = paramc2;
    this.B = paramlt;
    this.C = paramo;
    this.D = paramck;
    this.ab = paramcq;
    this.ac = paramm;
    this.ad = paramci;
    this.E = paramrh;
    this.ae = paramae;
    this.e = paramch.c;
    this.b = paramch.a;
    this.M = paramch.b;
    this.i = paramch.b.readLock();
    this.h = paramch.b.writeLock();
    this.K = paramaa.a;
    this.g = paramaa.b;
    this.L = paramaa.c;
    this.f = paramck.a;
    this.c = new cb(this.J, parampv, paramc, paramva, paramox, paramvv, paramatu, this.e);
  }
  
  private void A(String paramString)
  {
    bd localbd = new bd("msgstore/deletemedia");
    this.i.lock();
    Cursor localCursor;
    try
    {
      localCursor = this.b.getReadableDatabase().rawQuery("SELECT key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, raw_data, recipient_count, participant_hash, starred, quoted_row_id, mentioned_jids, multicast_id, edit_version, receipt_server_timestamp, media_enc_hash, _id FROM messages WHERE  media_wa_type in ('2' , '1' , '3' , '13' , '9' ) AND key_remote_jid=? ORDER BY _id DESC", new String[] { paramString });
      if (localCursor != null) {
        try
        {
          while (localCursor.moveToNext())
          {
            b(this.t.a(localCursor, paramString), false);
            continue;
            paramString = finally;
          }
        }
        catch (SQLiteDiskIOException paramString)
        {
          a.a.a.a.d.h(this.J);
          throw paramString;
        }
        finally
        {
          if (localCursor != null) {
            localCursor.close();
          }
        }
      }
      if (localCursor == null) {
        break label113;
      }
    }
    finally
    {
      this.i.unlock();
    }
    localCursor.close();
    label113:
    this.i.unlock();
    Log.i("msgstore/deletemedia " + paramString + " delete-files:false time spent:" + localbd.b());
  }
  
  private boolean B(String paramString)
  {
    return (this.n.a(paramString)) || (w(paramString) != 1L);
  }
  
  private j C(String paramString)
  {
    Log.d("msgstore/last/db/jid " + paramString);
    j localj2 = null;
    j localj1 = null;
    this.i.lock();
    for (;;)
    {
      try
      {
        Cursor localCursor = this.b.getReadableDatabase().rawQuery(al, new String[] { paramString });
        if (localCursor != null) {
          try
          {
            if (localCursor.moveToNext())
            {
              localj2 = this.t.a(localCursor, paramString);
              localj1 = localj2;
              if (qz.g(paramString))
              {
                localj1 = localj2;
                if (localj2.t == 2L)
                {
                  Log.i("msgstore/initialize/update-group-create-failed-msg");
                  localj2.t = 3L;
                  localj1 = localj2;
                }
              }
              localCursor.close();
              return localj1;
            }
            Log.w("msgstore/last/db no message for " + paramString);
            continue;
            paramString = finally;
          }
          finally
          {
            localCursor.close();
          }
        }
        Log.e("msgstore/last/db/cursor is null");
      }
      finally
      {
        this.i.unlock();
      }
      localj1 = localj2;
    }
  }
  
  /* Error */
  private Cursor a(String paramString, String[] paramArrayOfString, android.support.v4.d.a parama)
  {
    // Byte code:
    //   0: getstatic 535	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 16
    //   5: if_icmpge +24 -> 29
    //   8: aload_3
    //   9: ifnull +7 -> 16
    //   12: aload_3
    //   13: invokevirtual 539	android/support/v4/d/a:a	()V
    //   16: aload_0
    //   17: getfield 361	com/whatsapp/data/ad:b	Lcom/whatsapp/data/n;
    //   20: invokevirtual 425	com/whatsapp/data/n:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   23: aload_1
    //   24: aload_2
    //   25: invokevirtual 435	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   28: areturn
    //   29: aload_0
    //   30: getfield 361	com/whatsapp/data/ad:b	Lcom/whatsapp/data/n;
    //   33: invokevirtual 425	com/whatsapp/data/n:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   36: astore 4
    //   38: aload_3
    //   39: ifnull +22 -> 61
    //   42: aload_3
    //   43: invokevirtual 542	android/support/v4/d/a:c	()Ljava/lang/Object;
    //   46: checkcast 544	android/os/CancellationSignal
    //   49: astore_3
    //   50: aload 4
    //   52: aload_1
    //   53: aload_2
    //   54: aload_3
    //   55: invokevirtual 547	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/database/Cursor;
    //   58: astore_1
    //   59: aload_1
    //   60: areturn
    //   61: aconst_null
    //   62: astore_3
    //   63: goto -13 -> 50
    //   66: astore_1
    //   67: aload_1
    //   68: instanceof 549
    //   71: ifeq +11 -> 82
    //   74: new 551	android/support/v4/d/b
    //   77: dup
    //   78: invokespecial 552	android/support/v4/d/b:<init>	()V
    //   81: athrow
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	ad
    //   0	84	1	paramString	String
    //   0	84	2	paramArrayOfString	String[]
    //   0	84	3	parama	android.support.v4.d.a
    //   36	15	4	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   29	38	66	java/lang/Exception
    //   42	50	66	java/lang/Exception
    //   50	59	66	java/lang/Exception
  }
  
  private c a(com.whatsapp.gdrive.ch.a<Void, Integer> parama, r.b paramb, Runnable paramRunnable)
  {
    int i1 = 1;
    com.whatsapp.fieldstats.events.l locall = new com.whatsapp.fieldstats.events.l();
    locall.a = Integer.valueOf(1);
    long l1 = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        parama = this.c.a(parama, paramb, paramRunnable, locall);
        switch (1.a[parama.ordinal()])
        {
        case 2: 
          Log.e("msgstore/backup/unexpected-backup-result/" + parama);
          i1 = 3;
          locall.a = Integer.valueOf(i1);
          return parama;
        }
      }
      finally
      {
        locall.e = Long.valueOf(System.currentTimeMillis() - l1);
        a(locall);
      }
      i1 = 0;
      continue;
      i1 = 2;
      continue;
      i1 = 3;
    }
  }
  
  private n a(n paramn)
  {
    a.d.c();
    Cursor localCursor = this.b.getWritableDatabase().rawQuery("SELECT key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, raw_data, recipient_count, participant_hash, starred, quoted_row_id, mentioned_jids, multicast_id, edit_version, receipt_server_timestamp, media_enc_hash, _id FROM messages WHERE key_remote_jid=? AND remote_resource=? ORDER BY _id ASC", new String[] { "status@broadcast", paramn.a });
    n localn = new n(this.j, paramn);
    localn.f = 1L;
    localn.g = 1L;
    localn.j = 0;
    localn.i = 0;
    label250:
    while (localCursor.moveToNext())
    {
      j localj = this.t.a(localCursor, "status@broadcast");
      if ((localj != null) && (localj.s != 15) && (localj.s != 11))
      {
        localn.b = localj.Q;
        localn.c = localj;
        localn.h = localj.n;
        localn.j += 1;
        if (!TextUtils.isEmpty(localn.a))
        {
          if (localj.Q <= paramn.d) {
            localn.d = localj.Q;
          }
          for (;;)
          {
            if (localj.Q > paramn.e) {
              break label250;
            }
            localn.e = localj.Q;
            break;
            localn.i += 1;
            if (localn.i == 1) {
              localn.f = localj.Q;
            }
            if (localn.i <= 2) {
              localn.g = localj.Q;
            }
          }
        }
      }
    }
    localCursor.close();
    Log.d("msgstore/status-regenerated/ old: " + paramn + " new:" + localn);
    paramn = localn;
    if (localn.j == 0) {
      paramn = null;
    }
    return paramn;
  }
  
  public static ad a()
  {
    if (G == null) {}
    try
    {
      if (G == null) {
        G = new ad(com.whatsapp.u.a(), ant.a(), pv.a(), com.whatsapp.util.a.c.a(), va.a(), d.a(), oz.a(), ox.a(), cm.a(), adp.a(), att.a(), e.a(), s.a(), and.a(), com.whatsapp.messaging.aj.a(), aus.a(), c.a(), q.a(), com.whatsapp.ba.a(), l.a(), ac.a(), u.a(), y.a(), vv.a(), cj.a(), cn.a(), ane.a(), cr.a(), co.a(), aa.a(), ch.a(), cl.a(), atu.a(), atv.a(), com.whatsapp.a.c.a(), lt.a(), o.a(), ck.a(), cq.a(), m.a(), ci.a(), rh.a(), ae.a());
      }
      return G;
    }
    finally {}
  }
  
  public static String a(List<n> paramList)
  {
    Collections.sort(paramList, bm.a());
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        n localn = (n)paramList.next();
        localMessageDigest.update(localn.a.getBytes());
        localMessageDigest.update(a.a.a.a.d.g(localn.i));
        localMessageDigest.update(a.a.a.a.d.g(localn.j));
        long l1 = localn.h;
        byte[] arrayOfByte = new byte[8];
        a.a.a.a.d.a(arrayOfByte, 0, l1);
        localMessageDigest.update(arrayOfByte);
        if (localn.c != null) {
          localMessageDigest.update(localn.c.e.c.getBytes());
        }
      }
      paramList = Base64.encodeToString(localMessageDigest.digest(), 2);
      return paramList;
    }
    catch (NoSuchAlgorithmException paramList) {}
    return null;
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase, j paramj)
  {
    if ((paramj.e.b) && (paramj.a()))
    {
      int i1 = this.x.f();
      Object localObject3 = this.ad.b(paramSQLiteDatabase, "status@broadcast");
      long l1 = this.j.b();
      Object localObject2 = new ArrayList();
      HashSet localHashSet;
      if ((i1 == 2) || (i1 == 0))
      {
        if (i1 == 0) {}
        for (localObject1 = new HashSet();; localObject1 = new HashSet(Arrays.asList(this.x.h())))
        {
          localObject4 = new ArrayList();
          this.Q.d((ArrayList)localObject4);
          localHashSet = new HashSet(((ArrayList)localObject4).size(), 1.0F);
          localObject4 = ((ArrayList)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = (cs)((Iterator)localObject4).next();
            if (!((HashSet)localObject1).contains(((cs)localObject5).t))
            {
              localHashSet.add(((cs)localObject5).t);
              ((ArrayList)localObject2).add(localObject5);
            }
          }
        }
      }
      for (;;)
      {
        localObject1 = new ArrayList();
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (cs)((Iterator)localObject2).next();
          if (((cs)localObject4).E < l1 + 86400000L)
          {
            ((cs)localObject4).E = (this.j.b() + 604800000L);
            ((ArrayList)localObject1).add(localObject4);
          }
        }
        if (i1 != 1) {
          break;
        }
        localHashSet = new HashSet();
        localObject1 = this.x.g();
        int i2 = localObject1.length;
        i1 = 0;
        while (i1 < i2)
        {
          localObject4 = localObject1[i1];
          localObject5 = this.Q.c((String)localObject4);
          if ((localObject5 != null) && (((cs)localObject5).d != null))
          {
            localHashSet.add(localObject4);
            ((ArrayList)localObject2).add(localObject5);
          }
          i1 += 1;
        }
      }
      throw new IllegalStateException("unknown status distribution mode");
      this.Q.d((Collection)localObject1);
      localObject2 = rg.a((Collection)localObject3);
      Object localObject4 = new HashSet((Collection)localObject3);
      ((HashSet)localObject4).removeAll(localHashSet);
      Object localObject5 = new HashSet(localHashSet);
      ((Set)localObject5).removeAll((Collection)localObject3);
      Object localObject1 = localObject2;
      Object localObject6;
      Iterator localIterator;
      if (!((Set)localObject5).isEmpty())
      {
        localObject6 = new HashSet();
        localIterator = ((Set)localObject5).iterator();
        while (localIterator.hasNext())
        {
          localObject3 = (String)localIterator.next();
          localObject1 = localObject3;
          if (this.l.a((String)localObject3)) {
            localObject1 = "";
          }
          localObject3 = new ContentValues(3);
          ((ContentValues)localObject3).put("gjid", "status@broadcast");
          ((ContentValues)localObject3).put("jid", (String)localObject1);
          ((ContentValues)localObject3).put("pending", Boolean.valueOf(false));
          if ((paramSQLiteDatabase.update("group_participants", (ContentValues)localObject3, "gjid=? and jid=?", new String[] { paramj.e.a, localObject1 }) == 0) && (paramSQLiteDatabase.insert("group_participants", null, (ContentValues)localObject3) >= 0L)) {
            ((Set)localObject6).add(localObject1);
          }
        }
        localObject1 = this.ad.a(paramSQLiteDatabase, paramj.e.a);
        if (!TextUtils.equals((CharSequence)localObject2, (CharSequence)localObject1))
        {
          localObject3 = TextUtils.join(",", (Iterable)localObject6);
          localObject6 = new ContentValues(6);
          ((ContentValues)localObject6).put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000L));
          ((ContentValues)localObject6).put("gjid", paramj.e.a);
          ((ContentValues)localObject6).put("jid", (String)localObject3);
          ((ContentValues)localObject6).put("action", Integer.valueOf(1));
          ((ContentValues)localObject6).put("old_phash", (String)localObject2);
          ((ContentValues)localObject6).put("new_phash", (String)localObject1);
          paramSQLiteDatabase.insert("group_participants_history", null, (ContentValues)localObject6);
        }
      }
      localObject2 = localObject1;
      if (!((HashSet)localObject4).isEmpty())
      {
        localObject6 = new HashSet();
        localIterator = ((HashSet)localObject4).iterator();
        label879:
        while (localIterator.hasNext())
        {
          localObject3 = (String)localIterator.next();
          boolean bool = this.l.a((String)localObject3);
          String str = paramj.e.a;
          if (bool) {}
          for (localObject2 = "";; localObject2 = localObject3)
          {
            if (paramSQLiteDatabase.delete("group_participants", "gjid=? and jid=?", new String[] { str, localObject2 }) <= 0) {
              break label879;
            }
            ((Set)localObject6).add(localObject3);
            break;
          }
        }
        localObject2 = this.ad.a(paramSQLiteDatabase, paramj.e.a);
        if (!TextUtils.equals((CharSequence)localObject1, (CharSequence)localObject2))
        {
          localObject3 = new ContentValues();
          ((ContentValues)localObject3).put("sent_sender_key", Boolean.valueOf(false));
          paramSQLiteDatabase.update("group_participants", (ContentValues)localObject3, "gjid=?", new String[] { paramj.e.a });
          localObject3 = TextUtils.join(",", (Iterable)localObject6);
          localObject6 = new ContentValues(6);
          ((ContentValues)localObject6).put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000L));
          ((ContentValues)localObject6).put("gjid", paramj.e.a);
          ((ContentValues)localObject6).put("jid", (String)localObject3);
          ((ContentValues)localObject6).put("action", Integer.valueOf(2));
          ((ContentValues)localObject6).put("old_phash", (String)localObject1);
          ((ContentValues)localObject6).put("new_phash", (String)localObject2);
          paramSQLiteDatabase.insert("group_participants_history", null, (ContentValues)localObject6);
        }
      }
      this.E.a("status@broadcast", (Collection)localObject5, (Collection)localObject4);
      paramj.g = ((String)localObject2);
      paramj.F = localHashSet.size();
      Log.d("msgstore/addmsg/status/ added:" + ((Set)localObject5).size() + " removed:" + ((HashSet)localObject4).size() + " current:" + localHashSet.size());
    }
  }
  
  private static void a(com.whatsapp.fieldstats.events.l paraml)
  {
    Long localLong2 = null;
    Integer localInteger;
    if (paraml.b != null)
    {
      localInteger = Integer.valueOf(paraml.b.intValue());
      if (paraml.c == null) {
        break label116;
      }
    }
    label116:
    for (Long localLong1 = paraml.c;; localLong1 = null)
    {
      if (paraml.e != null) {
        localLong2 = paraml.e;
      }
      Log.i("msgstore/backup/log-chat-db-backup-event overall-result: " + paraml.a + " database-backup-version: " + localInteger + " compression-ratio: " + paraml.d + " backup-file-size: " + localLong1 + " time: " + localLong2);
      return;
      localInteger = null;
      break;
    }
  }
  
  private void a(j paramj1, j paramj2, boolean paramBoolean)
  {
    long l1 = 0L;
    localObject1 = null;
    this.i.lock();
    try
    {
      localSQLiteDatabase = this.b.getWritableDatabase();
      localObject1 = localSQLiteDatabase;
      this.w.b();
      localObject1 = localSQLiteDatabase;
      localSQLiteDatabase.beginTransaction();
      localObject1 = localSQLiteDatabase;
      if (com.whatsapp.protocol.m.a(paramj2.s))
      {
        localObject1 = localSQLiteDatabase;
        b(paramj2, paramBoolean);
        localObject1 = localSQLiteDatabase;
        this.ab.a(paramj2);
      }
      localObject1 = localSQLiteDatabase;
      Object localObject2 = this.w.m;
      localObject1 = localSQLiteDatabase;
      ((SQLiteStatement)localObject2).bindString(1, paramj1.e.c);
      localObject1 = localSQLiteDatabase;
      ((SQLiteStatement)localObject2).bindLong(2, paramj1.d);
      localObject1 = localSQLiteDatabase;
      ((SQLiteStatement)localObject2).bindLong(3, 0L);
      localObject1 = localSQLiteDatabase;
      c.a(paramj1, (SQLiteStatement)localObject2, 5, 4);
      localObject1 = localSQLiteDatabase;
      ((SQLiteStatement)localObject2).bindLong(6, paramj1.n);
      localObject1 = localSQLiteDatabase;
      ((SQLiteStatement)localObject2).bindNull(7);
      localObject1 = localSQLiteDatabase;
      ((SQLiteStatement)localObject2).bindNull(8);
      localObject1 = localSQLiteDatabase;
      ((SQLiteStatement)localObject2).bindLong(9, paramj1.s);
      localObject1 = localSQLiteDatabase;
      ((SQLiteStatement)localObject2).bindLong(10, 0L);
      localObject1 = localSQLiteDatabase;
      ((SQLiteStatement)localObject2).bindString(11, paramj1.y);
      localObject1 = localSQLiteDatabase;
      ((SQLiteStatement)localObject2).bindNull(12);
      localObject1 = localSQLiteDatabase;
      ((SQLiteStatement)localObject2).bindNull(13);
      localObject1 = localSQLiteDatabase;
      ((SQLiteStatement)localObject2).bindLong(14, 0L);
      localObject1 = localSQLiteDatabase;
      ((SQLiteStatement)localObject2).bindLong(15, paramj1.o);
      localObject1 = localSQLiteDatabase;
      ((SQLiteStatement)localObject2).bindDouble(16, 0.0D);
      localObject1 = localSQLiteDatabase;
      ((SQLiteStatement)localObject2).bindDouble(17, 0.0D);
      localObject1 = localSQLiteDatabase;
      ((SQLiteStatement)localObject2).bindNull(18);
      localObject1 = localSQLiteDatabase;
      ((SQLiteStatement)localObject2).bindNull(19);
      localObject1 = localSQLiteDatabase;
      ((SQLiteStatement)localObject2).bindLong(20, paramj1.ab);
      localObject1 = localSQLiteDatabase;
      ((SQLiteStatement)localObject2).bindNull(21);
      localObject1 = localSQLiteDatabase;
      ((SQLiteStatement)localObject2).bindString(22, paramj1.e.a);
      localObject1 = localSQLiteDatabase;
      if (paramj1.e.b) {
        l1 = 1L;
      }
      localObject1 = localSQLiteDatabase;
      ((SQLiteStatement)localObject2).bindLong(23, l1);
      localObject1 = localSQLiteDatabase;
      ((SQLiteStatement)localObject2).bindString(24, paramj1.y);
      localObject1 = localSQLiteDatabase;
      ((SQLiteStatement)localObject2).execute();
      localObject1 = localSQLiteDatabase;
      if (!paramj1.e.b) {
        break label921;
      }
      localObject1 = localSQLiteDatabase;
      if (paramj2.a())
      {
        localObject1 = localSQLiteDatabase;
        localObject2 = (n)this.x.c().get("");
        if (localObject2 != null)
        {
          localObject1 = localSQLiteDatabase;
          localObject2 = ((n)localObject2).b(paramj2);
          paramj2 = (j)localObject2;
          if (localObject2 != null)
          {
            paramj2 = (j)localObject2;
            localObject1 = localSQLiteDatabase;
            if (((n)localObject2).b == -1L)
            {
              localObject1 = localSQLiteDatabase;
              paramj2 = a((n)localObject2);
            }
          }
          if (paramj2 == null) {
            break label841;
          }
          localObject1 = localSQLiteDatabase;
          localObject2 = new ContentValues(7);
          localObject1 = localSQLiteDatabase;
          ((ContentValues)localObject2).put("message_table_id", Long.valueOf(paramj2.b));
          localObject1 = localSQLiteDatabase;
          ((ContentValues)localObject2).put("last_read_message_table_id", Long.valueOf(paramj2.d));
          localObject1 = localSQLiteDatabase;
          ((ContentValues)localObject2).put("last_read_receipt_sent_message_table_id ", Long.valueOf(paramj2.e));
          localObject1 = localSQLiteDatabase;
          ((ContentValues)localObject2).put("first_unread_message_table_id", Long.valueOf(paramj2.f));
          localObject1 = localSQLiteDatabase;
          ((ContentValues)localObject2).put("autodownload_limit_message_table_id", Long.valueOf(paramj2.g));
          localObject1 = localSQLiteDatabase;
          ((ContentValues)localObject2).put("timestamp", Long.valueOf(paramj2.h));
          localObject1 = localSQLiteDatabase;
          ((ContentValues)localObject2).put("unseen_count", Integer.valueOf(paramj2.i));
          localObject1 = localSQLiteDatabase;
          ((ContentValues)localObject2).put("total_count", Integer.valueOf(paramj2.j));
          localObject1 = localSQLiteDatabase;
          if (localSQLiteDatabase.update("status_list", (ContentValues)localObject2, "key_remote_jid=?", new String[] { "" }) == 0)
          {
            localObject1 = localSQLiteDatabase;
            Log.e("msgstore/revoke/statuslist/outgoing-update-failed");
          }
          localObject1 = localSQLiteDatabase;
          this.x.c().put("", paramj2);
        }
      }
    }
    finally
    {
      try
      {
        for (;;)
        {
          this.K.a(paramj1.e, paramj1);
          if (localSQLiteDatabase != null) {}
          try
          {
            if (localSQLiteDatabase.inTransaction()) {
              localSQLiteDatabase.endTransaction();
            }
            return;
          }
          finally
          {
            label841:
            this.i.unlock();
          }
          localObject1 = localSQLiteDatabase;
          localSQLiteDatabase.delete("status_list", "key_remote_jid=?", new String[] { "" });
          localObject1 = localSQLiteDatabase;
          this.x.c().remove("");
        }
      }
      finally
      {
        SQLiteDatabase localSQLiteDatabase;
        label909:
        localObject1 = localSQLiteDatabase;
      }
      paramj1 = finally;
      if ((localObject1 == null) || (!((SQLiteDatabase)localObject1).inTransaction())) {
        break label909;
      }
      ((SQLiteDatabase)localObject1).endTransaction();
    }
    localObject1 = localSQLiteDatabase;
    this.g.put(paramj1.e, paramj1);
    for (;;)
    {
      localObject1 = localSQLiteDatabase;
      localSQLiteDatabase.setTransactionSuccessful();
      localObject1 = localSQLiteDatabase;
      paramj2 = this.K;
      localObject1 = localSQLiteDatabase;
      label921:
      localObject1 = localSQLiteDatabase;
      this.P.a(this, paramj1);
    }
  }
  
  public static void a(File paramFile)
  {
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile != null)
    {
      int i2 = arrayOfFile.length;
      int i1 = 0;
      if (i1 < i2)
      {
        File localFile = arrayOfFile[i1];
        if (localFile.isDirectory()) {
          a(localFile);
        }
        for (;;)
        {
          i1 += 1;
          break;
          a.a.a.a.d.d(localFile);
        }
      }
    }
    a.a.a.a.d.d(paramFile);
  }
  
  static void a(File paramFile, String paramString)
  {
    File[] arrayOfFile = paramFile.getParentFile().listFiles();
    if ((arrayOfFile != null) && (arrayOfFile.length > 0))
    {
      int i2 = arrayOfFile.length;
      int i1 = 0;
      if (i1 < i2)
      {
        File localFile = arrayOfFile[i1];
        StringBuilder localStringBuilder = new StringBuilder().append(paramString).append(localFile.getName()).append(" ").append(localFile.length()).append(" drw=");
        if (localFile.isDirectory())
        {
          paramFile = "1";
          label90:
          localStringBuilder = localStringBuilder.append(paramFile);
          if (!localFile.canRead()) {
            break label156;
          }
          paramFile = "1";
          label110:
          localStringBuilder = localStringBuilder.append(paramFile);
          if (!localFile.canWrite()) {
            break label163;
          }
        }
        label156:
        label163:
        for (paramFile = "1";; paramFile = "0")
        {
          Log.i(paramFile);
          i1 += 1;
          break;
          paramFile = "0";
          break label90;
          paramFile = "0";
          break label110;
        }
      }
    }
  }
  
  private Cursor b(String paramString1, j.b paramb, Integer paramInteger, String paramString2)
  {
    if (paramb == null) {}
    for (long l1 = g(paramString1); l1 == 1L; l1 = e(this.t.a(paramb)))
    {
      Log.i("msgstore/get/newer no id for " + paramb);
      paramString1 = null;
      return paramString1;
    }
    String str;
    if (paramInteger != null)
    {
      str = " LIMIT " + paramInteger;
      label81:
      if (!"document".equals(paramString2)) {
        break label200;
      }
      paramInteger = "SELECT key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, raw_data, recipient_count, participant_hash, starred, quoted_row_id, mentioned_jids, multicast_id, edit_version, receipt_server_timestamp, media_enc_hash, _id FROM messages WHERE  media_wa_type=9 AND key_remote_jid=? ";
    }
    for (;;)
    {
      paramInteger = paramInteger + "AND _id>? ORDER BY _id ASC" + str;
      this.i.lock();
      try
      {
        paramInteger = this.b.getReadableDatabase().rawQuery(paramInteger, new String[] { paramString1, String.valueOf(l1) });
        this.i.unlock();
        paramString1 = paramInteger;
        if (paramInteger != null) {
          break;
        }
        return null;
      }
      finally
      {
        label200:
        int i1;
        Object localObject;
        this.i.unlock();
      }
      str = "";
      break label81;
      if ("url".equals(paramString2))
      {
        paramInteger = "SELECT key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, raw_data, recipient_count, participant_hash, starred, quoted_row_id, mentioned_jids, multicast_id, edit_version, receipt_server_timestamp, media_enc_hash, _id, links.link_index AS link_index FROM messages, (SELECT message_row_id, link_index FROM messages_links WHERE messages_links.key_remote_jid=?) links WHERE messages._id = links.message_row_id ";
      }
      else
      {
        if (!"all_media".equals(paramString2)) {
          break label236;
        }
        paramInteger = "SELECT key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, raw_data, recipient_count, participant_hash, starred, quoted_row_id, mentioned_jids, multicast_id, edit_version, receipt_server_timestamp, media_enc_hash, _id FROM messages WHERE  media_wa_type in ('2' , '1' , '3' , '13' ) AND (origin IS NULL OR origin!=1) AND key_remote_jid=? ";
      }
    }
    label236:
    if ((!cs.e(paramString1)) && (!qz.e(paramString1)))
    {
      i1 = 1;
      label253:
      localObject = new StringBuilder("SELECT key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, raw_data, recipient_count, participant_hash, starred, quoted_row_id, mentioned_jids, multicast_id, edit_version, receipt_server_timestamp, media_enc_hash, _id FROM messages WHERE key_remote_jid=? ");
      if (i1 == 0) {
        break label326;
      }
    }
    label326:
    for (paramInteger = "AND media_wa_type!=8 ";; paramInteger = "")
    {
      localObject = paramInteger;
      paramInteger = (Integer)localObject;
      if (paramString2 == null) {
        break;
      }
      Log.w("msgstore/get/newer unexpected type string=" + paramString2);
      paramInteger = (Integer)localObject;
      break;
      i1 = 0;
      break label253;
    }
  }
  
  private ArrayList<j> b(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    String str = q.c(paramString1);
    if (TextUtils.isEmpty(str)) {
      return localArrayList;
    }
    Object localObject1;
    if (TextUtils.isEmpty(paramString2))
    {
      paramString2 = "SELECT docid, content FROM messages_fts WHERE content MATCH ? ORDER BY docid DESC";
      localObject1 = new String[1];
      localObject1[0] = str;
    }
    for (;;)
    {
      Object localObject2 = this.b.getReadableDatabase();
      try
      {
        paramString2 = ((SQLiteDatabase)localObject2).rawQuery(paramString2 + "  LIMIT " + paramInt2 + " OFFSET " + paramInt1, (String[])localObject1);
        Log.i("msgstore/fts/search/query:" + paramString1 + " match:" + str);
        paramString1 = new bd("msgstore/fts/search");
        if (paramString2 == null) {
          break label261;
        }
        paramInt1 = paramString2.getColumnIndex("docid");
        while (paramString2.moveToNext())
        {
          long l1 = paramString2.getLong(paramInt1);
          localObject1 = this.t.a(l1);
          if (localObject1 != null) {
            localArrayList.add(localObject1);
          }
        }
        localObject2 = "SELECT docid, content FROM messages_fts, messages WHERE content MATCH ? AND messages_fts.docid = messages._id AND messages.key_remote_jid = ? ORDER BY docid DESC";
      }
      catch (SQLiteDatabaseCorruptException paramString1)
      {
        a(new AssertionError(paramString1));
        return null;
      }
      localObject1 = new String[2];
      localObject1[0] = str;
      localObject1[1] = paramString2;
      paramString2 = (String)localObject2;
    }
    paramString2.close();
    label261:
    Log.i("msgstore/fts/search time spent:" + paramString1.b() + " found:" + localArrayList.size());
    return localArrayList;
  }
  
  private void b(SQLiteDatabase paramSQLiteDatabase, j paramj)
  {
    String str = paramj.e.a;
    Object localObject2 = (d)this.n.a.get(str);
    if ((localObject2 == null) && (j(paramj)))
    {
      break label38;
      break label38;
    }
    label38:
    while (paramj.s == 8) {
      return;
    }
    boolean bool4 = l(paramj);
    Object localObject3 = new ContentValues(2);
    if (bool4) {
      ((ContentValues)localObject3).put("message_table_id", Long.valueOf(paramj.Q));
    }
    boolean bool1;
    boolean bool2;
    boolean bool3;
    if (paramj.s == 10)
    {
      bool1 = false;
      bool2 = true;
      bool3 = false;
    }
    for (;;)
    {
      label102:
      if ((localObject2 == null) || (((d)localObject2).d == 0L)) {
        ((ContentValues)localObject3).put("last_read_receipt_sent_message_table_id", Long.valueOf(paramj.Q - 1L));
      }
      label192:
      int i1;
      label240:
      Object localObject1;
      label306:
      Object localObject4;
      int i2;
      label359:
      int i3;
      label368:
      label404:
      label432:
      boolean bool5;
      if (paramj.d == 6)
      {
        if ((paramj.t == 9L) || (paramj.t == 11L))
        {
          ((ContentValues)localObject3).put("subject", paramj.e());
          ((ContentValues)localObject3).put("creation", Long.valueOf(paramj.n));
        }
      }
      else
      {
        if ((localObject2 != null) && (((d)localObject2).e) && (k(paramj)))
        {
          ((d)localObject2).e = false;
          ((ContentValues)localObject3).put("archived", Boolean.valueOf(false));
        }
        if (l(paramj)) {
          break label1275;
        }
        i1 = 0;
        if (i1 != 0) {
          ((ContentValues)localObject3).put("sort_timestamp", Long.valueOf(paramj.n));
        }
        if ((!paramj.e.b) && (x.a(this.S)) && (paramj.s == 0))
        {
          if (!qz.e(paramj.e.a)) {
            break label1453;
          }
          localObject1 = paramj.f;
          localObject4 = (d)this.n.a.get(localObject1);
          if (localObject4 != null)
          {
            double d1 = x.a(this.S, paramj.e());
            if (d1 == 0.0D) {
              break label1477;
            }
            if (((d)localObject4).h <= 0.0D) {
              break label1465;
            }
            i2 = 1;
            if (d1 <= 0.0D) {
              break label1471;
            }
            i3 = 1;
            if (i2 != i3) {
              ((d)localObject4).h *= 0.9D;
            }
            ((d)localObject4).h += d1;
            i2 = 1;
            if (i2 != 0)
            {
              if (localObject4 != localObject2) {
                break label1483;
              }
              ((ContentValues)localObject3).put("gen", Double.valueOf(((d)localObject4).h));
            }
          }
        }
        bool5 = b(paramj);
        if (!bool5) {
          break label1533;
        }
        i3 = 1;
        label447:
        i2 = i3;
        if (localObject2 == null)
        {
          i2 = i3;
          if (!bool5)
          {
            i2 = i3;
            if ((paramj.i() & 0x8) != 0)
            {
              i2 = i3;
              if (paramj.Y != null)
              {
                i2 = i3;
                if (str.endsWith("@s.whatsapp.net"))
                {
                  i2 = i3;
                  if (this.Q.j(str) != null) {
                    i2 = 1;
                  }
                }
              }
            }
          }
        }
        if (localObject2 != null) {
          break label1655;
        }
        if (!this.O.b(str)) {
          break label1768;
        }
        localObject1 = this.O;
        if (!TextUtils.isEmpty(str)) {
          break label1539;
        }
        Log.e("spamManager/removeCallNotSpamProp/invalid jid: " + str);
        label576:
        i2 = 1;
      }
      label596:
      label831:
      label846:
      label1275:
      label1447:
      label1453:
      label1465:
      label1471:
      label1477:
      label1483:
      label1533:
      label1539:
      label1655:
      label1729:
      label1743:
      label1758:
      label1768:
      for (;;)
      {
        ((ContentValues)localObject3).put("my_messages", Integer.valueOf(i2));
        i3 = i2;
        i2 = 0;
        if (localObject2 == null)
        {
          i2 = 1;
          ((ContentValues)localObject3).put("plaintext_disabled", Integer.valueOf(1));
        }
        ((ContentValues)localObject3).put("last_message_table_id", Long.valueOf(paramj.Q));
        if ((localObject2 == null) && (bool4))
        {
          Log.i("msgstore/chat/add " + str + " plaintextdisabled:" + i2);
          localObject1 = new d();
          this.n.a.put(str, localObject1);
          ((d)localObject1).i = i3;
          ((d)localObject1).j = i2;
        }
        for (;;)
        {
          if (localObject1 != null)
          {
            if (i1 != 0) {
              ((d)localObject1).f = paramj.n;
            }
            if (bool4)
            {
              ((d)localObject1).b = paramj;
              ((d)localObject1).a = paramj.Q;
            }
            if (bool1) {
              ((d)localObject1).c = paramj.Q;
            }
            if (((d)localObject1).d == 0L) {
              ((d)localObject1).d = (paramj.Q - 1L);
            }
            if (((d)localObject1).q != 0L) {
              break label1729;
            }
            i1 = this.Q.d(str).s;
            if (!bool3) {
              break label1758;
            }
            i1 += 1;
          }
          for (;;)
          {
            if (bool2)
            {
              i2 = 1;
              ((d)localObject1).a(i1, i2, i1 + i2);
              ((d)localObject1).q = paramj.Q;
              if ((paramSQLiteDatabase.update("chat_list", (ContentValues)localObject3, "key_remote_jid=?", new String[] { str }) == 0) && (bool4))
              {
                ((ContentValues)localObject3).put("key_remote_jid", str);
                if (paramSQLiteDatabase.insert("chat_list", null, (ContentValues)localObject3) == -1L) {
                  Log.e("msgstore/addmsg/chatlist/insert/failed gid=" + str);
                }
              }
              if ((!paramj.e.b) || (paramj.d == 6)) {
                break;
              }
              localObject2 = this.C.c();
              localObject3 = new o.c(str, paramj.s);
              localObject1 = (Integer)((ConcurrentHashMap)localObject2).get(localObject3);
              if (localObject1 != null) {
                break label1743;
              }
            }
            for (localObject1 = Integer.valueOf(1);; localObject1 = Integer.valueOf(((Integer)localObject1).intValue() + 1))
            {
              ((ConcurrentHashMap)localObject2).put(localObject3, localObject1);
              localObject2 = new ContentValues(1);
              ((ContentValues)localObject2).put("message_count", (Integer)localObject1);
              if (paramSQLiteDatabase.update("frequents", (ContentValues)localObject2, "jid=? AND type=?", new String[] { str, Byte.toString(paramj.s) }) != 0) {
                break;
              }
              ((ContentValues)localObject2).put("jid", str);
              ((ContentValues)localObject2).put("type", Byte.valueOf(paramj.s));
              if (paramSQLiteDatabase.insert("frequents", null, (ContentValues)localObject2) != -1L) {
                break;
              }
              Log.e("msgstore/addmsg/frequents/insert/failed jid=" + str + " type=" + paramj.s);
              return;
              if ((o(paramj.e.a) <= 0) && (Conversation.l().a(paramj.e.a)))
              {
                if (!paramj.e.b) {
                  paramj.d = 13;
                }
                paramj.aa = true;
              }
              bool1 = paramj.aa;
              if (bool1)
              {
                ((ContentValues)localObject3).put("last_read_message_table_id", Long.valueOf(paramj.Q));
                bool2 = false;
                bool3 = false;
                break label102;
              }
              if ((paramj.e.b) && (!qz.a(paramj))) {
                break label1771;
              }
              bool2 = false;
              bool3 = true;
              break label102;
              if (paramj.t != 1L) {
                break label192;
              }
              ((ContentValues)localObject3).put("subject", paramj.e());
              break label192;
              if ((paramj.s == 0) && (paramj.d == 6))
              {
                if ((paramj.t == 12L) || (paramj.t == 20L) || (paramj.t == 14L) || (paramj.t == 13L))
                {
                  if (((Collection)paramj.N).contains(this.l.c().t)) {
                    break label1447;
                  }
                  i1 = 0;
                  break label240;
                }
                if ((paramj.t == 4L) || (paramj.t == 7L))
                {
                  if (this.l.a(paramj.f)) {
                    break label1447;
                  }
                  i1 = 0;
                  break label240;
                }
                if ((paramj.t == 5L) || (paramj.t == 10L) || (paramj.t == 21L))
                {
                  i1 = 0;
                  break label240;
                }
              }
              i1 = 1;
              break label240;
              localObject1 = paramj.e.a;
              break label306;
              i2 = 0;
              break label359;
              i3 = 0;
              break label368;
              i2 = 0;
              break label404;
              ContentValues localContentValues = new ContentValues();
              localContentValues.put("gen", Double.valueOf(((d)localObject4).h));
              paramSQLiteDatabase.update("chat_list", localContentValues, "key_remote_jid=?", new String[] { localObject1 });
              break label432;
              i3 = -1;
              break label447;
              localObject4 = ((cm)localObject1).b();
              if ((localObject4 != null) && (((List)localObject4).contains(str)))
              {
                localObject4 = new ArrayList((Collection)localObject4);
                ((List)localObject4).remove(str);
                localObject4 = TextUtils.join(",", (Iterable)localObject4);
                ((cm)localObject1).a.a("call_not_spam_jids", (String)localObject4);
                Log.i("spamManager/removeCallNotSpamProp/true: " + (String)localObject4);
                break label576;
              }
              Log.i("spamManager/removeCallNotSpamProp/false/not spam jids: " + localObject4);
              break label576;
              if (((d)localObject2).i != -1)
              {
                i3 = i2;
                if (((d)localObject2).i != 0) {
                  break label596;
                }
              }
              i3 = i2;
              if (!bool5) {
                break label596;
              }
              ((d)localObject2).i = 1;
              ((ContentValues)localObject3).put("my_messages", Integer.valueOf(1));
              this.q.a(9, str, 0L, 0);
              i3 = i2;
              break label596;
              i2 = 0;
              break label831;
              ((d)localObject1).a(bool3, bool2, (ContentValues)localObject3);
              break label846;
            }
          }
          localObject1 = localObject2;
        }
      }
      label1771:
      bool2 = false;
      bool3 = false;
    }
  }
  
  private void b(j paramj, boolean paramBoolean)
  {
    int i2 = 0;
    MediaData localMediaData = paramj.b();
    int i1 = i2;
    if (localMediaData != null) {
      i1 = i2;
    }
    try
    {
      if (localMediaData.file != null)
      {
        bool = this.m.a(localMediaData.file);
        i1 = i2;
        if (bool) {
          i1 = 1;
        }
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        boolean bool;
        Log.d("msgstore/on-delete-media-message", localIOException);
        i1 = i2;
        continue;
        paramj = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        continue;
        paramj = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        continue;
        paramj = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
      }
    }
    if (i1 != 0)
    {
      bool = paramBoolean;
      if (paramj.s == 2)
      {
        bool = paramBoolean;
        if (paramj.o == 1) {
          bool = true;
        }
      }
      i1 = this.V.b(localMediaData.file.getAbsolutePath());
      if ((i1 == 0) && (bool)) {
        a.a.a.a.d.d(localMediaData.file);
      }
    }
    else
    {
      switch (paramj.s)
      {
      default: 
        paramj = null;
        if (paramj != null)
        {
          ContentResolver localContentResolver = this.R.f;
          if (localContentResolver == null) {
            Log.w("msgstore/on-delete-media-message cr=null");
          }
        }
        else
        {
          return;
        }
        break;
      }
    }
    try
    {
      localIOException.delete(paramj, "_data=?", new String[] { localMediaData.file.getAbsolutePath() });
      return;
    }
    catch (UnsupportedOperationException paramj)
    {
      Log.d("msgstore/on-delete-media-message", paramj);
      return;
      if (i1 == 1)
      {
        paramj = this.w.l;
        paramj.bindString(1, localMediaData.file.getAbsolutePath());
        paramj.execute();
        return;
      }
      paramj = this.w.k;
      paramj.bindLong(1, i1 - 1);
      paramj.bindString(2, localMediaData.file.getAbsolutePath());
      paramj.execute();
      return;
    }
    catch (IllegalArgumentException paramj)
    {
      for (;;) {}
    }
    catch (SecurityException paramj)
    {
      for (;;) {}
    }
  }
  
  public static boolean b(File paramFile)
  {
    try
    {
      if (!paramFile.exists()) {
        return false;
      }
      paramFile = SQLiteDatabase.openDatabase(paramFile.getAbsolutePath(), null, n.h);
      String str = DatabaseUtils.stringForQuery(paramFile, "PRAGMA integrity_check", null);
      paramFile.close();
      Log.i("msgstore/fieldstat/isdatabaseintegrityok " + str);
      boolean bool = "ok".equalsIgnoreCase(str);
      return bool;
    }
    catch (Exception paramFile)
    {
      Log.e("msgstore/fieldstat/isdatabaseintegrityok/error " + paramFile);
    }
    return false;
  }
  
  private long c(String paramString, long paramLong, int paramInt)
  {
    if ((d)this.n.a.get(paramString) == null) {
      return 1L;
    }
    int i1;
    if ((!cs.e(paramString)) && (!qz.e(paramString)))
    {
      i1 = 1;
      this.i.lock();
    }
    label329:
    for (;;)
    {
      try
      {
        bd localbd = new bd("msgstore/startref " + paramString);
        Object localObject2 = new StringBuilder("SELECT _id FROM messages WHERE key_remote_jid=? ");
        if (i1 != 0)
        {
          localObject1 = "AND media_wa_type!=8 ";
          localObject2 = ((StringBuilder)localObject2).append((String)localObject1);
          if (paramLong != 1L) {
            continue;
          }
          localObject1 = "";
          localObject2 = (String)localObject1 + "ORDER BY _id DESC LIMIT " + paramInt;
          localObject1 = new String[1];
          localObject1[0] = paramString;
          SQLiteDatabase localSQLiteDatabase = this.b.getReadableDatabase();
          if (paramLong != 1L) {
            continue;
          }
          localObject1 = localSQLiteDatabase.rawQuery((String)localObject2, (String[])localObject1);
          if (localObject1 == null) {
            break label329;
          }
        }
        try
        {
          if (!((Cursor)localObject1).moveToLast()) {
            continue;
          }
          long l1 = ((Cursor)localObject1).getLong(0);
          paramLong = l1;
        }
        catch (SQLiteDatabaseCorruptException paramString)
        {
          a(new AssertionError(paramString));
          ((Cursor)localObject1).close();
          continue;
        }
        finally
        {
          ((Cursor)localObject1).close();
        }
        localbd.b();
        return paramLong;
        i1 = 0;
        break;
        Object localObject1 = "";
        continue;
        localObject1 = "AND _id<? ";
        continue;
        localObject1 = new String[] { paramString, String.valueOf(paramLong) };
        continue;
        Log.w("msgstore/startref can't get value for " + paramString);
        continue;
        Log.e("msgstore/startref/cursor is null");
      }
      finally
      {
        this.i.unlock();
      }
    }
  }
  
  private ArrayList<j> c(long paramLong)
  {
    Object localObject = this.g.entrySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((j)((Map.Entry)((Iterator)localObject).next()).getValue()).n + 86400000L < paramLong) {
        ((Iterator)localObject).remove();
      }
    }
    Log.i("msgstore/unsendmessages/cached:" + this.g.size());
    localObject = new ArrayList(this.g.size());
    Iterator localIterator = this.g.values().iterator();
    while (localIterator.hasNext()) {
      ((ArrayList)localObject).add((j)localIterator.next());
    }
    Collections.sort((List)localObject, ar.a());
    return (ArrayList<j>)localObject;
  }
  
  /* Error */
  public static int d(File paramFile)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aconst_null
    //   5: astore 4
    //   7: aconst_null
    //   8: astore 7
    //   10: aconst_null
    //   11: astore 6
    //   13: aload_0
    //   14: invokevirtual 1617	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   17: aconst_null
    //   18: getstatic 1660	com/whatsapp/data/n:h	I
    //   21: invokestatic 1664	android/database/sqlite/SQLiteDatabase:openDatabase	(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)Landroid/database/sqlite/SQLiteDatabase;
    //   24: astore 5
    //   26: aload 4
    //   28: astore_3
    //   29: aload 5
    //   31: astore 4
    //   33: aload 7
    //   35: astore 6
    //   37: aload 5
    //   39: ldc_w 1726
    //   42: aconst_null
    //   43: invokevirtual 435	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   46: astore 7
    //   48: aload 7
    //   50: ifnonnull +31 -> 81
    //   53: aload 7
    //   55: ifnull +10 -> 65
    //   58: aload 7
    //   60: invokeinterface 457 1 0
    //   65: iload_2
    //   66: istore_1
    //   67: aload 5
    //   69: ifnull +10 -> 79
    //   72: aload 5
    //   74: invokevirtual 1673	android/database/sqlite/SQLiteDatabase:close	()V
    //   77: iload_2
    //   78: istore_1
    //   79: iload_1
    //   80: ireturn
    //   81: aload 7
    //   83: astore_3
    //   84: aload 5
    //   86: astore 4
    //   88: aload 7
    //   90: astore 6
    //   92: aload 7
    //   94: invokeinterface 441 1 0
    //   99: ifeq +53 -> 152
    //   102: aload 7
    //   104: astore_3
    //   105: aload 5
    //   107: astore 4
    //   109: aload 7
    //   111: astore 6
    //   113: aload 7
    //   115: iconst_0
    //   116: invokeinterface 1730 2 0
    //   121: istore_1
    //   122: iload_1
    //   123: iconst_1
    //   124: isub
    //   125: istore_2
    //   126: aload 7
    //   128: ifnull +10 -> 138
    //   131: aload 7
    //   133: invokeinterface 457 1 0
    //   138: iload_2
    //   139: istore_1
    //   140: aload 5
    //   142: ifnull -63 -> 79
    //   145: aload 5
    //   147: invokevirtual 1673	android/database/sqlite/SQLiteDatabase:close	()V
    //   150: iload_2
    //   151: ireturn
    //   152: aload 7
    //   154: ifnull +10 -> 164
    //   157: aload 7
    //   159: invokeinterface 457 1 0
    //   164: iload_2
    //   165: istore_1
    //   166: aload 5
    //   168: ifnull -89 -> 79
    //   171: aload 5
    //   173: invokevirtual 1673	android/database/sqlite/SQLiteDatabase:close	()V
    //   176: iconst_m1
    //   177: ireturn
    //   178: astore 7
    //   180: aconst_null
    //   181: astore 5
    //   183: aload 6
    //   185: astore_3
    //   186: aload 5
    //   188: astore 4
    //   190: new 162	java/lang/StringBuilder
    //   193: dup
    //   194: ldc_w 1732
    //   197: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   200: aload_0
    //   201: invokevirtual 1617	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   204: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: aload 7
    //   212: invokestatic 1629	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   215: aload 6
    //   217: ifnull +10 -> 227
    //   220: aload 6
    //   222: invokeinterface 457 1 0
    //   227: iload_2
    //   228: istore_1
    //   229: aload 5
    //   231: ifnull -152 -> 79
    //   234: aload 5
    //   236: invokevirtual 1673	android/database/sqlite/SQLiteDatabase:close	()V
    //   239: iconst_m1
    //   240: ireturn
    //   241: astore_0
    //   242: aconst_null
    //   243: astore 4
    //   245: aload_3
    //   246: ifnull +9 -> 255
    //   249: aload_3
    //   250: invokeinterface 457 1 0
    //   255: aload 4
    //   257: ifnull +8 -> 265
    //   260: aload 4
    //   262: invokevirtual 1673	android/database/sqlite/SQLiteDatabase:close	()V
    //   265: aload_0
    //   266: athrow
    //   267: astore_0
    //   268: goto -23 -> 245
    //   271: astore 7
    //   273: goto -90 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	276	0	paramFile	File
    //   66	163	1	i1	int
    //   1	227	2	i2	int
    //   3	247	3	localObject1	Object
    //   5	256	4	localObject2	Object
    //   24	211	5	localSQLiteDatabase	SQLiteDatabase
    //   11	210	6	localCursor1	Cursor
    //   8	150	7	localCursor2	Cursor
    //   178	33	7	localException1	Exception
    //   271	1	7	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   13	26	178	java/lang/Exception
    //   13	26	241	finally
    //   37	48	267	finally
    //   92	102	267	finally
    //   113	122	267	finally
    //   190	215	267	finally
    //   37	48	271	java/lang/Exception
    //   92	102	271	java/lang/Exception
    //   113	122	271	java/lang/Exception
  }
  
  private long d(long paramLong)
  {
    bd localbd = new bd();
    localbd.a("msgstore/getRowIdByTimestamp");
    long l1 = 0L;
    Cursor localCursor = this.b.getReadableDatabase().rawQuery("SELECT _id FROM messages WHERE timestamp<=? ORDER BY _id DESC LIMIT 1", new String[] { Long.toString(paramLong) });
    paramLong = l1;
    if (localCursor != null)
    {
      paramLong = l1;
      if (localCursor.moveToNext()) {
        paramLong = localCursor.getLong(0);
      }
      localCursor.close();
    }
    Log.i("msgstore/getRowIdByTimestamp " + paramLong + " | time spent:" + localbd.b());
    return paramLong;
  }
  
  private static String d(String paramString1, String paramString2)
  {
    return paramString1 + "." + paramString2.replaceAll(",\\s+", new StringBuilder(",").append(paramString1).append(".").toString());
  }
  
  public static long e(j paramj)
  {
    if ((paramj == null) || (paramj.Q == 0L)) {
      return 1L;
    }
    return paramj.Q;
  }
  
  /* Error */
  private a g(j paramj, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 34
    //   3: iconst_0
    //   4: istore 32
    //   6: iconst_0
    //   7: istore 24
    //   9: iconst_0
    //   10: istore 25
    //   12: iconst_0
    //   13: istore 26
    //   15: iconst_0
    //   16: istore 23
    //   18: iconst_0
    //   19: istore 6
    //   21: iconst_0
    //   22: istore 28
    //   24: iconst_0
    //   25: istore 29
    //   27: iconst_0
    //   28: istore 33
    //   30: iconst_0
    //   31: istore 30
    //   33: iconst_0
    //   34: istore 31
    //   36: iconst_0
    //   37: istore 27
    //   39: aload_1
    //   40: getfield 849	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   43: getfield 1059	com/whatsapp/protocol/j$b:a	Ljava/lang/String;
    //   46: astore 47
    //   48: iconst_0
    //   49: istore 5
    //   51: iconst_0
    //   52: istore 20
    //   54: iconst_0
    //   55: istore 21
    //   57: iconst_0
    //   58: istore 22
    //   60: iconst_0
    //   61: istore 19
    //   63: aload 47
    //   65: invokestatic 1774	com/whatsapp/protocol/j:c	(Ljava/lang/String;)Z
    //   68: ifeq +294 -> 362
    //   71: aload_0
    //   72: getfield 325	com/whatsapp/data/ad:x	Lcom/whatsapp/data/co;
    //   75: aload_1
    //   76: invokevirtual 1775	com/whatsapp/data/co:b	(Lcom/whatsapp/protocol/j;)Z
    //   79: ifeq +51 -> 130
    //   82: new 162	java/lang/StringBuilder
    //   85: dup
    //   86: ldc_w 1777
    //   89: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   92: aload_1
    //   93: getfield 849	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   96: invokevirtual 583	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   99: ldc_w 1779
    //   102: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_1
    //   106: getfield 527	com/whatsapp/protocol/j:n	J
    //   109: invokevirtual 470	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   112: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 474	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   118: new 8	com/whatsapp/data/ad$a
    //   121: dup
    //   122: iconst_1
    //   123: iconst_0
    //   124: iconst_0
    //   125: iconst_0
    //   126: invokespecial 1782	com/whatsapp/data/ad$a:<init>	(ZZZZ)V
    //   129: areturn
    //   130: aload_1
    //   131: getfield 849	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   134: getfield 853	com/whatsapp/protocol/j$b:b	Z
    //   137: ifne +225 -> 362
    //   140: aload_1
    //   141: getfield 1437	com/whatsapp/protocol/j:f	Ljava/lang/String;
    //   144: invokestatic 522	com/whatsapp/data/e:b	(Ljava/lang/String;)Z
    //   147: ifne +215 -> 362
    //   150: aload_0
    //   151: getfield 291	com/whatsapp/data/ad:Q	Lcom/whatsapp/data/e;
    //   154: aload_1
    //   155: getfield 1437	com/whatsapp/protocol/j:f	Ljava/lang/String;
    //   158: invokevirtual 1005	com/whatsapp/data/e:c	(Ljava/lang/String;)Lcom/whatsapp/data/cs;
    //   161: astore 38
    //   163: aload 38
    //   165: ifnull +11 -> 176
    //   168: aload 38
    //   170: getfield 1008	com/whatsapp/data/cs:d	Lcom/whatsapp/data/cs$a;
    //   173: ifnonnull +144 -> 317
    //   176: aload 38
    //   178: ifnull +127 -> 305
    //   181: aload 38
    //   183: getfield 996	com/whatsapp/data/cs:E	J
    //   186: aload_0
    //   187: getfield 275	com/whatsapp/data/ad:j	Lcom/whatsapp/ant;
    //   190: invokevirtual 953	com/whatsapp/ant:b	()J
    //   193: lcmp
    //   194: iflt +111 -> 305
    //   197: iconst_1
    //   198: istore 5
    //   200: new 162	java/lang/StringBuilder
    //   203: dup
    //   204: ldc_w 1784
    //   207: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   210: aload_1
    //   211: getfield 849	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   214: getfield 934	com/whatsapp/protocol/j$b:c	Ljava/lang/String;
    //   217: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: ldc_w 1786
    //   223: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: aload_1
    //   227: getfield 1437	com/whatsapp/protocol/j:f	Ljava/lang/String;
    //   230: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: ldc_w 1779
    //   236: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload_1
    //   240: getfield 527	com/whatsapp/protocol/j:n	J
    //   243: invokevirtual 470	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   246: ldc_w 1788
    //   249: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: iload 5
    //   254: invokevirtual 1763	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   257: ldc_w 1790
    //   260: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: astore_1
    //   264: aload 38
    //   266: ifnonnull +45 -> 311
    //   269: iconst_1
    //   270: istore 6
    //   272: aload_1
    //   273: iload 6
    //   275: invokevirtual 1763	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   278: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokestatic 474	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   284: aload_0
    //   285: getfield 263	com/whatsapp/data/ad:J	Landroid/content/Context;
    //   288: iload 5
    //   290: invokestatic 1795	com/whatsapp/pb:a	(Landroid/content/Context;Z)V
    //   293: new 8	com/whatsapp/data/ad$a
    //   296: dup
    //   297: iconst_1
    //   298: iconst_0
    //   299: iconst_0
    //   300: iconst_0
    //   301: invokespecial 1782	com/whatsapp/data/ad$a:<init>	(ZZZZ)V
    //   304: areturn
    //   305: iconst_0
    //   306: istore 5
    //   308: goto -108 -> 200
    //   311: iconst_0
    //   312: istore 6
    //   314: goto -42 -> 272
    //   317: aload 38
    //   319: getfield 996	com/whatsapp/data/cs:E	J
    //   322: aload_1
    //   323: getfield 527	com/whatsapp/protocol/j:n	J
    //   326: ldc2_w 997
    //   329: ladd
    //   330: lcmp
    //   331: ifge +31 -> 362
    //   334: aload 38
    //   336: aload_0
    //   337: getfield 275	com/whatsapp/data/ad:j	Lcom/whatsapp/ant;
    //   340: invokevirtual 953	com/whatsapp/ant:b	()J
    //   343: ldc2_w 999
    //   346: ladd
    //   347: putfield 996	com/whatsapp/data/cs:E	J
    //   350: aload_0
    //   351: getfield 291	com/whatsapp/data/ad:Q	Lcom/whatsapp/data/e;
    //   354: aload 38
    //   356: invokestatic 1799	java/util/Collections:singletonList	(Ljava/lang/Object;)Ljava/util/List;
    //   359: invokevirtual 1015	com/whatsapp/data/e:d	(Ljava/util/Collection;)V
    //   362: aconst_null
    //   363: astore 41
    //   365: aconst_null
    //   366: astore 42
    //   368: aconst_null
    //   369: astore 38
    //   371: aconst_null
    //   372: astore 43
    //   374: aconst_null
    //   375: astore 44
    //   377: aconst_null
    //   378: astore 45
    //   380: aconst_null
    //   381: astore 40
    //   383: aload 47
    //   385: invokestatic 1361	com/whatsapp/qz:e	(Ljava/lang/String;)Z
    //   388: istore 7
    //   390: aload_1
    //   391: getfield 849	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   394: getfield 1059	com/whatsapp/protocol/j$b:a	Ljava/lang/String;
    //   397: invokestatic 1800	com/whatsapp/protocol/j:b	(Ljava/lang/String;)Z
    //   400: ifeq +8331 -> 8731
    //   403: aload_1
    //   404: invokevirtual 947	com/whatsapp/protocol/j:a	()Z
    //   407: ifne +8324 -> 8731
    //   410: iconst_1
    //   411: istore_3
    //   412: iload 7
    //   414: ifeq +43 -> 457
    //   417: aload_1
    //   418: getfield 1437	com/whatsapp/protocol/j:f	Ljava/lang/String;
    //   421: ifnonnull +36 -> 457
    //   424: aload_1
    //   425: getfield 849	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   428: getfield 853	com/whatsapp/protocol/j$b:b	Z
    //   431: ifne +26 -> 457
    //   434: new 162	java/lang/StringBuilder
    //   437: dup
    //   438: ldc_w 1802
    //   441: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   444: aload_1
    //   445: invokestatic 1804	com/whatsapp/util/Log:a	(Lcom/whatsapp/protocol/j;)Ljava/lang/String;
    //   448: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   454: invokestatic 509	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   457: iload 7
    //   459: ifne +7 -> 466
    //   462: iload_3
    //   463: ifeq +50 -> 513
    //   466: aload_0
    //   467: getfield 349	com/whatsapp/data/ad:E	Lcom/whatsapp/rh;
    //   470: aload_1
    //   471: getfield 849	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   474: getfield 1059	com/whatsapp/protocol/j$b:a	Ljava/lang/String;
    //   477: invokevirtual 1807	com/whatsapp/rh:a	(Ljava/lang/String;)Lcom/whatsapp/rg;
    //   480: astore 39
    //   482: aload_1
    //   483: aload 39
    //   485: getfield 1809	com/whatsapp/rg:d	Ljava/lang/String;
    //   488: putfield 1112	com/whatsapp/protocol/j:g	Ljava/lang/String;
    //   491: aload 39
    //   493: invokevirtual 1811	com/whatsapp/rg:c	()I
    //   496: istore 4
    //   498: iload 7
    //   500: ifeq +8236 -> 8736
    //   503: iconst_1
    //   504: istore_3
    //   505: aload_1
    //   506: iload 4
    //   508: iload_3
    //   509: isub
    //   510: putfield 1115	com/whatsapp/protocol/j:F	I
    //   513: aload_0
    //   514: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   517: invokevirtual 419	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   520: iload 19
    //   522: istore 11
    //   524: iload 27
    //   526: istore 7
    //   528: iload 23
    //   530: istore 8
    //   532: iload 20
    //   534: istore 17
    //   536: iload 29
    //   538: istore 14
    //   540: iload 24
    //   542: istore 12
    //   544: iload 21
    //   546: istore 18
    //   548: iload 30
    //   550: istore 15
    //   552: iload 25
    //   554: istore 13
    //   556: iload 22
    //   558: istore 16
    //   560: iload 31
    //   562: istore 10
    //   564: iload 26
    //   566: istore 9
    //   568: aload_0
    //   569: getfield 361	com/whatsapp/data/ad:b	Lcom/whatsapp/data/n;
    //   572: invokevirtual 604	com/whatsapp/data/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   575: astore 39
    //   577: aload 39
    //   579: astore 40
    //   581: iload 19
    //   583: istore 11
    //   585: iload 27
    //   587: istore 7
    //   589: iload 23
    //   591: istore 8
    //   593: aload 39
    //   595: astore 41
    //   597: iload 20
    //   599: istore 17
    //   601: iload 29
    //   603: istore 14
    //   605: iload 24
    //   607: istore 12
    //   609: aload 39
    //   611: astore 42
    //   613: iload 21
    //   615: istore 18
    //   617: iload 30
    //   619: istore 15
    //   621: iload 25
    //   623: istore 13
    //   625: aload 39
    //   627: astore 38
    //   629: aload 39
    //   631: astore 43
    //   633: iload 22
    //   635: istore 16
    //   637: iload 31
    //   639: istore 10
    //   641: iload 26
    //   643: istore 9
    //   645: aload 39
    //   647: astore 44
    //   649: aload 39
    //   651: astore 45
    //   653: aload_0
    //   654: getfield 319	com/whatsapp/data/ad:w	Lcom/whatsapp/data/cn;
    //   657: invokevirtual 1199	com/whatsapp/data/cn:b	()V
    //   660: aload 39
    //   662: astore 40
    //   664: iload 19
    //   666: istore 11
    //   668: iload 27
    //   670: istore 7
    //   672: iload 23
    //   674: istore 8
    //   676: aload 39
    //   678: astore 41
    //   680: iload 20
    //   682: istore 17
    //   684: iload 29
    //   686: istore 14
    //   688: iload 24
    //   690: istore 12
    //   692: aload 39
    //   694: astore 42
    //   696: iload 21
    //   698: istore 18
    //   700: iload 30
    //   702: istore 15
    //   704: iload 25
    //   706: istore 13
    //   708: aload 39
    //   710: astore 38
    //   712: aload 39
    //   714: astore 43
    //   716: iload 22
    //   718: istore 16
    //   720: iload 31
    //   722: istore 10
    //   724: iload 26
    //   726: istore 9
    //   728: aload 39
    //   730: astore 44
    //   732: aload 39
    //   734: astore 45
    //   736: invokestatic 568	java/lang/System:currentTimeMillis	()J
    //   739: lstore 36
    //   741: aload 39
    //   743: astore 40
    //   745: iload 19
    //   747: istore 11
    //   749: iload 27
    //   751: istore 7
    //   753: iload 23
    //   755: istore 8
    //   757: aload 39
    //   759: astore 41
    //   761: iload 20
    //   763: istore 17
    //   765: iload 29
    //   767: istore 14
    //   769: iload 24
    //   771: istore 12
    //   773: aload 39
    //   775: astore 42
    //   777: iload 21
    //   779: istore 18
    //   781: iload 30
    //   783: istore 15
    //   785: iload 25
    //   787: istore 13
    //   789: aload 39
    //   791: astore 38
    //   793: aload 39
    //   795: astore 43
    //   797: iload 22
    //   799: istore 16
    //   801: iload 31
    //   803: istore 10
    //   805: iload 26
    //   807: istore 9
    //   809: aload 39
    //   811: astore 44
    //   813: aload 39
    //   815: astore 45
    //   817: aload 39
    //   819: invokevirtual 1143	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   822: aload 39
    //   824: astore 40
    //   826: iload 19
    //   828: istore 11
    //   830: iload 27
    //   832: istore 7
    //   834: iload 23
    //   836: istore 8
    //   838: aload 39
    //   840: astore 41
    //   842: iload 20
    //   844: istore 17
    //   846: iload 29
    //   848: istore 14
    //   850: iload 24
    //   852: istore 12
    //   854: aload 39
    //   856: astore 42
    //   858: iload 21
    //   860: istore 18
    //   862: iload 30
    //   864: istore 15
    //   866: iload 25
    //   868: istore 13
    //   870: aload 39
    //   872: astore 38
    //   874: aload 39
    //   876: astore 43
    //   878: iload 22
    //   880: istore 16
    //   882: iload 31
    //   884: istore 10
    //   886: iload 26
    //   888: istore 9
    //   890: aload 39
    //   892: astore 44
    //   894: aload 39
    //   896: astore 45
    //   898: invokestatic 568	java/lang/System:currentTimeMillis	()J
    //   901: lload 36
    //   903: lsub
    //   904: lstore 36
    //   906: lload 36
    //   908: ldc2_w 1812
    //   911: lcmp
    //   912: ifle +104 -> 1016
    //   915: aload 39
    //   917: astore 40
    //   919: iload 19
    //   921: istore 11
    //   923: iload 27
    //   925: istore 7
    //   927: iload 23
    //   929: istore 8
    //   931: aload 39
    //   933: astore 41
    //   935: iload 20
    //   937: istore 17
    //   939: iload 29
    //   941: istore 14
    //   943: iload 24
    //   945: istore 12
    //   947: aload 39
    //   949: astore 42
    //   951: iload 21
    //   953: istore 18
    //   955: iload 30
    //   957: istore 15
    //   959: iload 25
    //   961: istore 13
    //   963: aload 39
    //   965: astore 38
    //   967: aload 39
    //   969: astore 43
    //   971: iload 22
    //   973: istore 16
    //   975: iload 31
    //   977: istore 10
    //   979: iload 26
    //   981: istore 9
    //   983: aload 39
    //   985: astore 44
    //   987: aload 39
    //   989: astore 45
    //   991: new 162	java/lang/StringBuilder
    //   994: dup
    //   995: ldc_w 1815
    //   998: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1001: lload 36
    //   1003: ldc2_w 1081
    //   1006: ldiv
    //   1007: invokevirtual 470	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1010: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1013: invokestatic 505	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   1016: aload 39
    //   1018: astore 40
    //   1020: iload 19
    //   1022: istore 11
    //   1024: iload 27
    //   1026: istore 7
    //   1028: iload 23
    //   1030: istore 8
    //   1032: aload 39
    //   1034: astore 41
    //   1036: iload 20
    //   1038: istore 17
    //   1040: iload 29
    //   1042: istore 14
    //   1044: iload 24
    //   1046: istore 12
    //   1048: aload 39
    //   1050: astore 42
    //   1052: iload 21
    //   1054: istore 18
    //   1056: iload 30
    //   1058: istore 15
    //   1060: iload 25
    //   1062: istore 13
    //   1064: aload 39
    //   1066: astore 38
    //   1068: aload 39
    //   1070: astore 43
    //   1072: iload 22
    //   1074: istore 16
    //   1076: iload 31
    //   1078: istore 10
    //   1080: iload 26
    //   1082: istore 9
    //   1084: aload 39
    //   1086: astore 44
    //   1088: aload 39
    //   1090: astore 45
    //   1092: aload_1
    //   1093: getfield 621	com/whatsapp/protocol/j:s	B
    //   1096: invokestatic 860	com/whatsapp/protocol/m:a	(B)Z
    //   1099: istore 35
    //   1101: aload 39
    //   1103: astore 40
    //   1105: iload 19
    //   1107: istore 11
    //   1109: iload 27
    //   1111: istore 7
    //   1113: iload 23
    //   1115: istore 8
    //   1117: aload 39
    //   1119: astore 41
    //   1121: iload 20
    //   1123: istore 17
    //   1125: iload 29
    //   1127: istore 14
    //   1129: iload 24
    //   1131: istore 12
    //   1133: aload 39
    //   1135: astore 42
    //   1137: iload 21
    //   1139: istore 18
    //   1141: iload 30
    //   1143: istore 15
    //   1145: iload 25
    //   1147: istore 13
    //   1149: aload 39
    //   1151: astore 38
    //   1153: aload 39
    //   1155: astore 43
    //   1157: iload 22
    //   1159: istore 16
    //   1161: iload 31
    //   1163: istore 10
    //   1165: iload 26
    //   1167: istore 9
    //   1169: aload 39
    //   1171: astore 44
    //   1173: aload 39
    //   1175: astore 45
    //   1177: aload_1
    //   1178: getfield 849	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   1181: getfield 853	com/whatsapp/protocol/j$b:b	Z
    //   1184: ifeq +725 -> 1909
    //   1187: iload 35
    //   1189: ifeq +720 -> 1909
    //   1192: aload 39
    //   1194: astore 40
    //   1196: iload 19
    //   1198: istore 11
    //   1200: iload 27
    //   1202: istore 7
    //   1204: iload 23
    //   1206: istore 8
    //   1208: aload 39
    //   1210: astore 41
    //   1212: iload 20
    //   1214: istore 17
    //   1216: iload 29
    //   1218: istore 14
    //   1220: iload 24
    //   1222: istore 12
    //   1224: aload 39
    //   1226: astore 42
    //   1228: iload 21
    //   1230: istore 18
    //   1232: iload 30
    //   1234: istore 15
    //   1236: iload 25
    //   1238: istore 13
    //   1240: aload 39
    //   1242: astore 38
    //   1244: aload 39
    //   1246: astore 43
    //   1248: iload 22
    //   1250: istore 16
    //   1252: iload 31
    //   1254: istore 10
    //   1256: iload 26
    //   1258: istore 9
    //   1260: aload 39
    //   1262: astore 44
    //   1264: aload 39
    //   1266: astore 45
    //   1268: aload_1
    //   1269: invokevirtual 877	com/whatsapp/protocol/j:b	()Lcom/whatsapp/MediaData;
    //   1272: astore 46
    //   1274: aload 39
    //   1276: astore 40
    //   1278: iload 19
    //   1280: istore 11
    //   1282: iload 27
    //   1284: istore 7
    //   1286: iload 23
    //   1288: istore 8
    //   1290: aload 39
    //   1292: astore 41
    //   1294: iload 20
    //   1296: istore 17
    //   1298: iload 29
    //   1300: istore 14
    //   1302: iload 24
    //   1304: istore 12
    //   1306: aload 39
    //   1308: astore 42
    //   1310: iload 21
    //   1312: istore 18
    //   1314: iload 30
    //   1316: istore 15
    //   1318: iload 25
    //   1320: istore 13
    //   1322: aload 39
    //   1324: astore 38
    //   1326: aload 39
    //   1328: astore 43
    //   1330: iload 22
    //   1332: istore 16
    //   1334: iload 31
    //   1336: istore 10
    //   1338: iload 26
    //   1340: istore 9
    //   1342: aload 39
    //   1344: astore 44
    //   1346: aload 39
    //   1348: astore 45
    //   1350: aload 46
    //   1352: getfield 1612	com/whatsapp/MediaData:file	Ljava/io/File;
    //   1355: astore 48
    //   1357: aload 39
    //   1359: astore 40
    //   1361: iload 19
    //   1363: istore 11
    //   1365: iload 27
    //   1367: istore 7
    //   1369: iload 23
    //   1371: istore 8
    //   1373: aload 39
    //   1375: astore 41
    //   1377: iload 20
    //   1379: istore 17
    //   1381: iload 29
    //   1383: istore 14
    //   1385: iload 24
    //   1387: istore 12
    //   1389: aload 39
    //   1391: astore 42
    //   1393: iload 21
    //   1395: istore 18
    //   1397: iload 30
    //   1399: istore 15
    //   1401: iload 25
    //   1403: istore 13
    //   1405: aload 39
    //   1407: astore 38
    //   1409: aload 39
    //   1411: astore 43
    //   1413: iload 22
    //   1415: istore 16
    //   1417: iload 31
    //   1419: istore 10
    //   1421: iload 26
    //   1423: istore 9
    //   1425: aload 39
    //   1427: astore 44
    //   1429: aload 39
    //   1431: astore 45
    //   1433: aload_0
    //   1434: getfield 283	com/whatsapp/data/ad:m	Lcom/whatsapp/oz;
    //   1437: aload 46
    //   1439: getfield 1612	com/whatsapp/MediaData:file	Ljava/io/File;
    //   1442: invokevirtual 1614	com/whatsapp/oz:a	(Ljava/io/File;)Z
    //   1445: ifeq +464 -> 1909
    //   1448: iconst_0
    //   1449: istore 4
    //   1451: aload 39
    //   1453: astore 40
    //   1455: iload 19
    //   1457: istore 11
    //   1459: iload 27
    //   1461: istore 7
    //   1463: iload 23
    //   1465: istore 8
    //   1467: aload 39
    //   1469: astore 41
    //   1471: iload 20
    //   1473: istore 17
    //   1475: iload 29
    //   1477: istore 14
    //   1479: iload 24
    //   1481: istore 12
    //   1483: aload 39
    //   1485: astore 42
    //   1487: iload 21
    //   1489: istore 18
    //   1491: iload 30
    //   1493: istore 15
    //   1495: iload 25
    //   1497: istore 13
    //   1499: aload 39
    //   1501: astore 38
    //   1503: aload 39
    //   1505: astore 43
    //   1507: iload 22
    //   1509: istore 16
    //   1511: iload 31
    //   1513: istore 10
    //   1515: iload 26
    //   1517: istore 9
    //   1519: aload 39
    //   1521: astore 44
    //   1523: aload 39
    //   1525: astore 45
    //   1527: aload 46
    //   1529: getfield 1818	com/whatsapp/MediaData:forward	Z
    //   1532: ifeq +1604 -> 3136
    //   1535: iconst_1
    //   1536: istore_3
    //   1537: iload_3
    //   1538: ifle +371 -> 1909
    //   1541: aload 39
    //   1543: astore 40
    //   1545: iload 19
    //   1547: istore 11
    //   1549: iload 27
    //   1551: istore 7
    //   1553: iload 23
    //   1555: istore 8
    //   1557: aload 39
    //   1559: astore 41
    //   1561: iload 20
    //   1563: istore 17
    //   1565: iload 29
    //   1567: istore 14
    //   1569: iload 24
    //   1571: istore 12
    //   1573: aload 39
    //   1575: astore 42
    //   1577: iload 21
    //   1579: istore 18
    //   1581: iload 30
    //   1583: istore 15
    //   1585: iload 25
    //   1587: istore 13
    //   1589: aload 39
    //   1591: astore 38
    //   1593: aload 39
    //   1595: astore 43
    //   1597: iload 22
    //   1599: istore 16
    //   1601: iload 31
    //   1603: istore 10
    //   1605: iload 26
    //   1607: istore 9
    //   1609: aload 39
    //   1611: astore 44
    //   1613: aload 39
    //   1615: astore 45
    //   1617: aload_0
    //   1618: getfield 313	com/whatsapp/data/ad:V	Lcom/whatsapp/data/y;
    //   1621: aload 46
    //   1623: getfield 1612	com/whatsapp/MediaData:file	Ljava/io/File;
    //   1626: invokevirtual 1617	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1629: invokevirtual 1619	com/whatsapp/data/y:b	(Ljava/lang/String;)I
    //   1632: istore 4
    //   1634: iload 4
    //   1636: ifne +1775 -> 3411
    //   1639: aload 39
    //   1641: astore 40
    //   1643: iload 19
    //   1645: istore 11
    //   1647: iload 27
    //   1649: istore 7
    //   1651: iload 23
    //   1653: istore 8
    //   1655: aload 39
    //   1657: astore 41
    //   1659: iload 20
    //   1661: istore 17
    //   1663: iload 29
    //   1665: istore 14
    //   1667: iload 24
    //   1669: istore 12
    //   1671: aload 39
    //   1673: astore 42
    //   1675: iload 21
    //   1677: istore 18
    //   1679: iload 30
    //   1681: istore 15
    //   1683: iload 25
    //   1685: istore 13
    //   1687: aload 39
    //   1689: astore 38
    //   1691: aload 39
    //   1693: astore 43
    //   1695: iload 22
    //   1697: istore 16
    //   1699: iload 31
    //   1701: istore 10
    //   1703: iload 26
    //   1705: istore 9
    //   1707: aload 39
    //   1709: astore 44
    //   1711: aload 39
    //   1713: astore 45
    //   1715: aload_0
    //   1716: getfield 319	com/whatsapp/data/ad:w	Lcom/whatsapp/data/cn;
    //   1719: getfield 1820	com/whatsapp/data/cn:j	Landroid/database/sqlite/SQLiteStatement;
    //   1722: iconst_1
    //   1723: aload 46
    //   1725: getfield 1612	com/whatsapp/MediaData:file	Ljava/io/File;
    //   1728: invokevirtual 1617	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1731: invokevirtual 1211	android/database/sqlite/SQLiteStatement:bindString	(ILjava/lang/String;)V
    //   1734: aload 39
    //   1736: astore 40
    //   1738: iload 19
    //   1740: istore 11
    //   1742: iload 27
    //   1744: istore 7
    //   1746: iload 23
    //   1748: istore 8
    //   1750: aload 39
    //   1752: astore 41
    //   1754: iload 20
    //   1756: istore 17
    //   1758: iload 29
    //   1760: istore 14
    //   1762: iload 24
    //   1764: istore 12
    //   1766: aload 39
    //   1768: astore 42
    //   1770: iload 21
    //   1772: istore 18
    //   1774: iload 30
    //   1776: istore 15
    //   1778: iload 25
    //   1780: istore 13
    //   1782: aload 39
    //   1784: astore 38
    //   1786: aload 39
    //   1788: astore 43
    //   1790: iload 22
    //   1792: istore 16
    //   1794: iload 31
    //   1796: istore 10
    //   1798: iload 26
    //   1800: istore 9
    //   1802: aload 39
    //   1804: astore 44
    //   1806: aload 39
    //   1808: astore 45
    //   1810: aload_0
    //   1811: getfield 319	com/whatsapp/data/ad:w	Lcom/whatsapp/data/cn;
    //   1814: getfield 1820	com/whatsapp/data/cn:j	Landroid/database/sqlite/SQLiteStatement;
    //   1817: iconst_2
    //   1818: iload_3
    //   1819: i2l
    //   1820: invokevirtual 1215	android/database/sqlite/SQLiteStatement:bindLong	(IJ)V
    //   1823: aload 39
    //   1825: astore 40
    //   1827: iload 19
    //   1829: istore 11
    //   1831: iload 27
    //   1833: istore 7
    //   1835: iload 23
    //   1837: istore 8
    //   1839: aload 39
    //   1841: astore 41
    //   1843: iload 20
    //   1845: istore 17
    //   1847: iload 29
    //   1849: istore 14
    //   1851: iload 24
    //   1853: istore 12
    //   1855: aload 39
    //   1857: astore 42
    //   1859: iload 21
    //   1861: istore 18
    //   1863: iload 30
    //   1865: istore 15
    //   1867: iload 25
    //   1869: istore 13
    //   1871: aload 39
    //   1873: astore 38
    //   1875: aload 39
    //   1877: astore 43
    //   1879: iload 22
    //   1881: istore 16
    //   1883: iload 31
    //   1885: istore 10
    //   1887: iload 26
    //   1889: istore 9
    //   1891: aload 39
    //   1893: astore 44
    //   1895: aload 39
    //   1897: astore 45
    //   1899: aload_0
    //   1900: getfield 319	com/whatsapp/data/ad:w	Lcom/whatsapp/data/cn;
    //   1903: getfield 1820	com/whatsapp/data/cn:j	Landroid/database/sqlite/SQLiteStatement;
    //   1906: invokevirtual 1234	android/database/sqlite/SQLiteStatement:execute	()V
    //   1909: aload 39
    //   1911: astore 40
    //   1913: iload 19
    //   1915: istore 11
    //   1917: iload 27
    //   1919: istore 7
    //   1921: iload 23
    //   1923: istore 8
    //   1925: aload 39
    //   1927: astore 41
    //   1929: iload 20
    //   1931: istore 17
    //   1933: iload 29
    //   1935: istore 14
    //   1937: iload 24
    //   1939: istore 12
    //   1941: aload 39
    //   1943: astore 42
    //   1945: iload 21
    //   1947: istore 18
    //   1949: iload 30
    //   1951: istore 15
    //   1953: iload 25
    //   1955: istore 13
    //   1957: aload 39
    //   1959: astore 38
    //   1961: aload 39
    //   1963: astore 43
    //   1965: iload 22
    //   1967: istore 16
    //   1969: iload 31
    //   1971: istore 10
    //   1973: iload 26
    //   1975: istore 9
    //   1977: aload 39
    //   1979: astore 44
    //   1981: aload 39
    //   1983: astore 45
    //   1985: aload_1
    //   1986: getfield 849	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   1989: getfield 1059	com/whatsapp/protocol/j$b:a	Ljava/lang/String;
    //   1992: invokestatic 1360	com/whatsapp/data/cs:e	(Ljava/lang/String;)Z
    //   1995: ifeq +1798 -> 3793
    //   1998: aload 39
    //   2000: astore 40
    //   2002: iload 19
    //   2004: istore 11
    //   2006: iload 27
    //   2008: istore 7
    //   2010: iload 23
    //   2012: istore 8
    //   2014: aload 39
    //   2016: astore 41
    //   2018: iload 20
    //   2020: istore 17
    //   2022: iload 29
    //   2024: istore 14
    //   2026: iload 24
    //   2028: istore 12
    //   2030: aload 39
    //   2032: astore 42
    //   2034: iload 21
    //   2036: istore 18
    //   2038: iload 30
    //   2040: istore 15
    //   2042: iload 25
    //   2044: istore 13
    //   2046: aload 39
    //   2048: astore 38
    //   2050: aload 39
    //   2052: astore 43
    //   2054: iload 22
    //   2056: istore 16
    //   2058: iload 31
    //   2060: istore 10
    //   2062: iload 26
    //   2064: istore 9
    //   2066: aload 39
    //   2068: astore 44
    //   2070: aload 39
    //   2072: astore 45
    //   2074: aload_1
    //   2075: getfield 849	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   2078: getfield 853	com/whatsapp/protocol/j$b:b	Z
    //   2081: ifeq +1712 -> 3793
    //   2084: aload 39
    //   2086: astore 40
    //   2088: iload 19
    //   2090: istore 11
    //   2092: iload 27
    //   2094: istore 7
    //   2096: iload 23
    //   2098: istore 8
    //   2100: aload 39
    //   2102: astore 41
    //   2104: iload 20
    //   2106: istore 17
    //   2108: iload 29
    //   2110: istore 14
    //   2112: iload 24
    //   2114: istore 12
    //   2116: aload 39
    //   2118: astore 42
    //   2120: iload 21
    //   2122: istore 18
    //   2124: iload 30
    //   2126: istore 15
    //   2128: iload 25
    //   2130: istore 13
    //   2132: aload 39
    //   2134: astore 38
    //   2136: aload 39
    //   2138: astore 43
    //   2140: iload 22
    //   2142: istore 16
    //   2144: iload 31
    //   2146: istore 10
    //   2148: iload 26
    //   2150: istore 9
    //   2152: aload 39
    //   2154: astore 44
    //   2156: aload 39
    //   2158: astore 45
    //   2160: aload_1
    //   2161: getfield 871	com/whatsapp/protocol/j:d	I
    //   2164: ifeq +87 -> 2251
    //   2167: aload 39
    //   2169: astore 40
    //   2171: iload 19
    //   2173: istore 11
    //   2175: iload 27
    //   2177: istore 7
    //   2179: iload 23
    //   2181: istore 8
    //   2183: aload 39
    //   2185: astore 41
    //   2187: iload 20
    //   2189: istore 17
    //   2191: iload 29
    //   2193: istore 14
    //   2195: iload 24
    //   2197: istore 12
    //   2199: aload 39
    //   2201: astore 42
    //   2203: iload 21
    //   2205: istore 18
    //   2207: iload 30
    //   2209: istore 15
    //   2211: iload 25
    //   2213: istore 13
    //   2215: aload 39
    //   2217: astore 38
    //   2219: aload 39
    //   2221: astore 43
    //   2223: iload 22
    //   2225: istore 16
    //   2227: iload 31
    //   2229: istore 10
    //   2231: iload 26
    //   2233: istore 9
    //   2235: aload 39
    //   2237: astore 44
    //   2239: aload 39
    //   2241: astore 45
    //   2243: aload_1
    //   2244: getfield 871	com/whatsapp/protocol/j:d	I
    //   2247: iconst_2
    //   2248: if_icmpne +1545 -> 3793
    //   2251: aload 39
    //   2253: astore 40
    //   2255: iload 19
    //   2257: istore 11
    //   2259: iload 27
    //   2261: istore 7
    //   2263: iload 23
    //   2265: istore 8
    //   2267: aload 39
    //   2269: astore 41
    //   2271: iload 20
    //   2273: istore 17
    //   2275: iload 29
    //   2277: istore 14
    //   2279: iload 24
    //   2281: istore 12
    //   2283: aload 39
    //   2285: astore 42
    //   2287: iload 21
    //   2289: istore 18
    //   2291: iload 30
    //   2293: istore 15
    //   2295: iload 25
    //   2297: istore 13
    //   2299: aload 39
    //   2301: astore 38
    //   2303: aload 39
    //   2305: astore 43
    //   2307: iload 22
    //   2309: istore 16
    //   2311: iload 31
    //   2313: istore 10
    //   2315: iload 26
    //   2317: istore 9
    //   2319: aload 39
    //   2321: astore 44
    //   2323: aload 39
    //   2325: astore 45
    //   2327: aload_1
    //   2328: iconst_1
    //   2329: putfield 1601	com/whatsapp/protocol/j:E	Z
    //   2332: aload 39
    //   2334: astore 40
    //   2336: iload 19
    //   2338: istore 11
    //   2340: iload 27
    //   2342: istore 7
    //   2344: iload 23
    //   2346: istore 8
    //   2348: aload 39
    //   2350: astore 41
    //   2352: iload 20
    //   2354: istore 17
    //   2356: iload 29
    //   2358: istore 14
    //   2360: iload 24
    //   2362: istore 12
    //   2364: aload 39
    //   2366: astore 42
    //   2368: iload 21
    //   2370: istore 18
    //   2372: iload 30
    //   2374: istore 15
    //   2376: iload 25
    //   2378: istore 13
    //   2380: aload 39
    //   2382: astore 38
    //   2384: aload 39
    //   2386: astore 43
    //   2388: iload 22
    //   2390: istore 16
    //   2392: iload 31
    //   2394: istore 10
    //   2396: iload 26
    //   2398: istore 9
    //   2400: aload 39
    //   2402: astore 44
    //   2404: aload 39
    //   2406: astore 45
    //   2408: aload_1
    //   2409: getfield 849	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   2412: getfield 1059	com/whatsapp/protocol/j$b:a	Ljava/lang/String;
    //   2415: invokestatic 1774	com/whatsapp/protocol/j:c	(Ljava/lang/String;)Z
    //   2418: ifne +1375 -> 3793
    //   2421: aload 39
    //   2423: astore 40
    //   2425: iload 19
    //   2427: istore 11
    //   2429: iload 27
    //   2431: istore 7
    //   2433: iload 23
    //   2435: istore 8
    //   2437: aload 39
    //   2439: astore 41
    //   2441: iload 20
    //   2443: istore 17
    //   2445: iload 29
    //   2447: istore 14
    //   2449: iload 24
    //   2451: istore 12
    //   2453: aload 39
    //   2455: astore 42
    //   2457: iload 21
    //   2459: istore 18
    //   2461: iload 30
    //   2463: istore 15
    //   2465: iload 25
    //   2467: istore 13
    //   2469: aload 39
    //   2471: astore 38
    //   2473: aload 39
    //   2475: astore 43
    //   2477: iload 22
    //   2479: istore 16
    //   2481: iload 31
    //   2483: istore 10
    //   2485: iload 26
    //   2487: istore 9
    //   2489: aload 39
    //   2491: astore 44
    //   2493: aload 39
    //   2495: astore 45
    //   2497: aload_1
    //   2498: getfield 1437	com/whatsapp/protocol/j:f	Ljava/lang/String;
    //   2501: ldc_w 1074
    //   2504: invokevirtual 1824	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   2507: astore 46
    //   2509: aload 39
    //   2511: astore 40
    //   2513: iload 19
    //   2515: istore 11
    //   2517: iload 27
    //   2519: istore 7
    //   2521: iload 23
    //   2523: istore 8
    //   2525: aload 39
    //   2527: astore 41
    //   2529: iload 20
    //   2531: istore 17
    //   2533: iload 29
    //   2535: istore 14
    //   2537: iload 24
    //   2539: istore 12
    //   2541: aload 39
    //   2543: astore 42
    //   2545: iload 21
    //   2547: istore 18
    //   2549: iload 30
    //   2551: istore 15
    //   2553: iload 25
    //   2555: istore 13
    //   2557: aload 39
    //   2559: astore 38
    //   2561: aload 39
    //   2563: astore 43
    //   2565: iload 22
    //   2567: istore 16
    //   2569: iload 31
    //   2571: istore 10
    //   2573: iload 26
    //   2575: istore 9
    //   2577: aload 39
    //   2579: astore 44
    //   2581: aload 39
    //   2583: astore 45
    //   2585: aload 46
    //   2587: arraylength
    //   2588: istore 4
    //   2590: iconst_0
    //   2591: istore_3
    //   2592: iload_3
    //   2593: iload 4
    //   2595: if_icmpge +1198 -> 3793
    //   2598: aload 46
    //   2600: iload_3
    //   2601: aaload
    //   2602: astore 48
    //   2604: aload 39
    //   2606: astore 40
    //   2608: iload 19
    //   2610: istore 11
    //   2612: iload 27
    //   2614: istore 7
    //   2616: iload 23
    //   2618: istore 8
    //   2620: aload 39
    //   2622: astore 41
    //   2624: iload 20
    //   2626: istore 17
    //   2628: iload 29
    //   2630: istore 14
    //   2632: iload 24
    //   2634: istore 12
    //   2636: aload 39
    //   2638: astore 42
    //   2640: iload 21
    //   2642: istore 18
    //   2644: iload 30
    //   2646: istore 15
    //   2648: iload 25
    //   2650: istore 13
    //   2652: aload 39
    //   2654: astore 38
    //   2656: aload 39
    //   2658: astore 43
    //   2660: iload 22
    //   2662: istore 16
    //   2664: iload 31
    //   2666: istore 10
    //   2668: iload 26
    //   2670: istore 9
    //   2672: aload 39
    //   2674: astore 44
    //   2676: aload 39
    //   2678: astore 45
    //   2680: new 493	com/whatsapp/protocol/j
    //   2683: dup
    //   2684: aload_1
    //   2685: invokespecial 1827	com/whatsapp/protocol/j:<init>	(Lcom/whatsapp/protocol/j;)V
    //   2688: astore 49
    //   2690: aload 39
    //   2692: astore 40
    //   2694: iload 19
    //   2696: istore 11
    //   2698: iload 27
    //   2700: istore 7
    //   2702: iload 23
    //   2704: istore 8
    //   2706: aload 39
    //   2708: astore 41
    //   2710: iload 20
    //   2712: istore 17
    //   2714: iload 29
    //   2716: istore 14
    //   2718: iload 24
    //   2720: istore 12
    //   2722: aload 39
    //   2724: astore 42
    //   2726: iload 21
    //   2728: istore 18
    //   2730: iload 30
    //   2732: istore 15
    //   2734: iload 25
    //   2736: istore 13
    //   2738: aload 39
    //   2740: astore 38
    //   2742: aload 39
    //   2744: astore 43
    //   2746: iload 22
    //   2748: istore 16
    //   2750: iload 31
    //   2752: istore 10
    //   2754: iload 26
    //   2756: istore 9
    //   2758: aload 39
    //   2760: astore 44
    //   2762: aload 39
    //   2764: astore 45
    //   2766: aload 49
    //   2768: aload_1
    //   2769: getfield 849	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   2772: getfield 1059	com/whatsapp/protocol/j$b:a	Ljava/lang/String;
    //   2775: putfield 1437	com/whatsapp/protocol/j:f	Ljava/lang/String;
    //   2778: aload 39
    //   2780: astore 40
    //   2782: iload 19
    //   2784: istore 11
    //   2786: iload 27
    //   2788: istore 7
    //   2790: iload 23
    //   2792: istore 8
    //   2794: aload 39
    //   2796: astore 41
    //   2798: iload 20
    //   2800: istore 17
    //   2802: iload 29
    //   2804: istore 14
    //   2806: iload 24
    //   2808: istore 12
    //   2810: aload 39
    //   2812: astore 42
    //   2814: iload 21
    //   2816: istore 18
    //   2818: iload 30
    //   2820: istore 15
    //   2822: iload 25
    //   2824: istore 13
    //   2826: aload 39
    //   2828: astore 38
    //   2830: aload 39
    //   2832: astore 43
    //   2834: iload 22
    //   2836: istore 16
    //   2838: iload 31
    //   2840: istore 10
    //   2842: iload 26
    //   2844: istore 9
    //   2846: aload 39
    //   2848: astore 44
    //   2850: aload 39
    //   2852: astore 45
    //   2854: aload 49
    //   2856: new 851	com/whatsapp/protocol/j$b
    //   2859: dup
    //   2860: aload 48
    //   2862: iconst_1
    //   2863: aload_1
    //   2864: getfield 849	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   2867: getfield 934	com/whatsapp/protocol/j$b:c	Ljava/lang/String;
    //   2870: invokespecial 1830	com/whatsapp/protocol/j$b:<init>	(Ljava/lang/String;ZLjava/lang/String;)V
    //   2873: putfield 849	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   2876: aload 39
    //   2878: astore 40
    //   2880: iload 19
    //   2882: istore 11
    //   2884: iload 27
    //   2886: istore 7
    //   2888: iload 23
    //   2890: istore 8
    //   2892: aload 39
    //   2894: astore 41
    //   2896: iload 20
    //   2898: istore 17
    //   2900: iload 29
    //   2902: istore 14
    //   2904: iload 24
    //   2906: istore 12
    //   2908: aload 39
    //   2910: astore 42
    //   2912: iload 21
    //   2914: istore 18
    //   2916: iload 30
    //   2918: istore 15
    //   2920: iload 25
    //   2922: istore 13
    //   2924: aload 39
    //   2926: astore 38
    //   2928: aload 39
    //   2930: astore 43
    //   2932: iload 22
    //   2934: istore 16
    //   2936: iload 31
    //   2938: istore 10
    //   2940: iload 26
    //   2942: istore 9
    //   2944: aload 39
    //   2946: astore 44
    //   2948: aload 39
    //   2950: astore 45
    //   2952: aload_0
    //   2953: aload 49
    //   2955: invokespecial 1832	com/whatsapp/data/ad:g	(Lcom/whatsapp/protocol/j;)V
    //   2958: aload 39
    //   2960: astore 40
    //   2962: iload 19
    //   2964: istore 11
    //   2966: iload 27
    //   2968: istore 7
    //   2970: iload 23
    //   2972: istore 8
    //   2974: aload 39
    //   2976: astore 41
    //   2978: iload 20
    //   2980: istore 17
    //   2982: iload 29
    //   2984: istore 14
    //   2986: iload 24
    //   2988: istore 12
    //   2990: aload 39
    //   2992: astore 42
    //   2994: iload 21
    //   2996: istore 18
    //   2998: iload 30
    //   3000: istore 15
    //   3002: iload 25
    //   3004: istore 13
    //   3006: aload 39
    //   3008: astore 38
    //   3010: aload 39
    //   3012: astore 43
    //   3014: iload 22
    //   3016: istore 16
    //   3018: iload 31
    //   3020: istore 10
    //   3022: iload 26
    //   3024: istore 9
    //   3026: aload 39
    //   3028: astore 44
    //   3030: aload 39
    //   3032: astore 45
    //   3034: aload_0
    //   3035: getfield 281	com/whatsapp/data/ad:n	Lcom/whatsapp/data/d;
    //   3038: getfield 1406	com/whatsapp/data/d:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   3041: aload 48
    //   3043: invokevirtual 1835	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   3046: ifeq +5678 -> 8724
    //   3049: aload 39
    //   3051: astore 40
    //   3053: iload 19
    //   3055: istore 11
    //   3057: iload 27
    //   3059: istore 7
    //   3061: iload 23
    //   3063: istore 8
    //   3065: aload 39
    //   3067: astore 41
    //   3069: iload 20
    //   3071: istore 17
    //   3073: iload 29
    //   3075: istore 14
    //   3077: iload 24
    //   3079: istore 12
    //   3081: aload 39
    //   3083: astore 42
    //   3085: iload 21
    //   3087: istore 18
    //   3089: iload 30
    //   3091: istore 15
    //   3093: iload 25
    //   3095: istore 13
    //   3097: aload 39
    //   3099: astore 38
    //   3101: aload 39
    //   3103: astore 43
    //   3105: iload 22
    //   3107: istore 16
    //   3109: iload 31
    //   3111: istore 10
    //   3113: iload 26
    //   3115: istore 9
    //   3117: aload 39
    //   3119: astore 44
    //   3121: aload 39
    //   3123: astore 45
    //   3125: aload_0
    //   3126: aload 39
    //   3128: aload 49
    //   3130: invokespecial 1837	com/whatsapp/data/ad:b	(Landroid/database/sqlite/SQLiteDatabase;Lcom/whatsapp/protocol/j;)V
    //   3133: goto +5591 -> 8724
    //   3136: iload 4
    //   3138: istore_3
    //   3139: aload 39
    //   3141: astore 40
    //   3143: iload 19
    //   3145: istore 11
    //   3147: iload 27
    //   3149: istore 7
    //   3151: iload 23
    //   3153: istore 8
    //   3155: aload 39
    //   3157: astore 41
    //   3159: iload 20
    //   3161: istore 17
    //   3163: iload 29
    //   3165: istore 14
    //   3167: iload 24
    //   3169: istore 12
    //   3171: aload 39
    //   3173: astore 42
    //   3175: iload 21
    //   3177: istore 18
    //   3179: iload 30
    //   3181: istore 15
    //   3183: iload 25
    //   3185: istore 13
    //   3187: aload 39
    //   3189: astore 38
    //   3191: aload 39
    //   3193: astore 43
    //   3195: iload 22
    //   3197: istore 16
    //   3199: iload 31
    //   3201: istore 10
    //   3203: iload 26
    //   3205: istore 9
    //   3207: aload 39
    //   3209: astore 44
    //   3211: aload 39
    //   3213: astore 45
    //   3215: aload_1
    //   3216: getfield 849	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   3219: getfield 1059	com/whatsapp/protocol/j$b:a	Ljava/lang/String;
    //   3222: invokestatic 1360	com/whatsapp/data/cs:e	(Ljava/lang/String;)Z
    //   3225: ifeq -1688 -> 1537
    //   3228: iload 4
    //   3230: istore_3
    //   3231: aload 39
    //   3233: astore 40
    //   3235: iload 19
    //   3237: istore 11
    //   3239: iload 27
    //   3241: istore 7
    //   3243: iload 23
    //   3245: istore 8
    //   3247: aload 39
    //   3249: astore 41
    //   3251: iload 20
    //   3253: istore 17
    //   3255: iload 29
    //   3257: istore 14
    //   3259: iload 24
    //   3261: istore 12
    //   3263: aload 39
    //   3265: astore 42
    //   3267: iload 21
    //   3269: istore 18
    //   3271: iload 30
    //   3273: istore 15
    //   3275: iload 25
    //   3277: istore 13
    //   3279: aload 39
    //   3281: astore 38
    //   3283: aload 39
    //   3285: astore 43
    //   3287: iload 22
    //   3289: istore 16
    //   3291: iload 31
    //   3293: istore 10
    //   3295: iload 26
    //   3297: istore 9
    //   3299: aload 39
    //   3301: astore 44
    //   3303: aload 39
    //   3305: astore 45
    //   3307: aload_1
    //   3308: getfield 849	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   3311: getfield 1059	com/whatsapp/protocol/j$b:a	Ljava/lang/String;
    //   3314: invokestatic 1774	com/whatsapp/protocol/j:c	(Ljava/lang/String;)Z
    //   3317: ifne -1780 -> 1537
    //   3320: aload 39
    //   3322: astore 40
    //   3324: iload 19
    //   3326: istore 11
    //   3328: iload 27
    //   3330: istore 7
    //   3332: iload 23
    //   3334: istore 8
    //   3336: aload 39
    //   3338: astore 41
    //   3340: iload 20
    //   3342: istore 17
    //   3344: iload 29
    //   3346: istore 14
    //   3348: iload 24
    //   3350: istore 12
    //   3352: aload 39
    //   3354: astore 42
    //   3356: iload 21
    //   3358: istore 18
    //   3360: iload 30
    //   3362: istore 15
    //   3364: iload 25
    //   3366: istore 13
    //   3368: aload 39
    //   3370: astore 38
    //   3372: aload 39
    //   3374: astore 43
    //   3376: iload 22
    //   3378: istore 16
    //   3380: iload 31
    //   3382: istore 10
    //   3384: iload 26
    //   3386: istore 9
    //   3388: aload 39
    //   3390: astore 44
    //   3392: aload 39
    //   3394: astore 45
    //   3396: aload_1
    //   3397: getfield 1437	com/whatsapp/protocol/j:f	Ljava/lang/String;
    //   3400: ldc_w 1074
    //   3403: invokevirtual 1824	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   3406: arraylength
    //   3407: istore_3
    //   3408: goto -1871 -> 1537
    //   3411: aload 39
    //   3413: astore 40
    //   3415: iload 19
    //   3417: istore 11
    //   3419: iload 27
    //   3421: istore 7
    //   3423: iload 23
    //   3425: istore 8
    //   3427: aload 39
    //   3429: astore 41
    //   3431: iload 20
    //   3433: istore 17
    //   3435: iload 29
    //   3437: istore 14
    //   3439: iload 24
    //   3441: istore 12
    //   3443: aload 39
    //   3445: astore 42
    //   3447: iload 21
    //   3449: istore 18
    //   3451: iload 30
    //   3453: istore 15
    //   3455: iload 25
    //   3457: istore 13
    //   3459: aload 39
    //   3461: astore 38
    //   3463: aload 39
    //   3465: astore 43
    //   3467: iload 22
    //   3469: istore 16
    //   3471: iload 31
    //   3473: istore 10
    //   3475: iload 26
    //   3477: istore 9
    //   3479: aload 39
    //   3481: astore 44
    //   3483: aload 39
    //   3485: astore 45
    //   3487: aload_0
    //   3488: getfield 319	com/whatsapp/data/ad:w	Lcom/whatsapp/data/cn;
    //   3491: getfield 1652	com/whatsapp/data/cn:k	Landroid/database/sqlite/SQLiteStatement;
    //   3494: iconst_1
    //   3495: iload_3
    //   3496: iload 4
    //   3498: iadd
    //   3499: i2l
    //   3500: invokevirtual 1215	android/database/sqlite/SQLiteStatement:bindLong	(IJ)V
    //   3503: aload 39
    //   3505: astore 40
    //   3507: iload 19
    //   3509: istore 11
    //   3511: iload 27
    //   3513: istore 7
    //   3515: iload 23
    //   3517: istore 8
    //   3519: aload 39
    //   3521: astore 41
    //   3523: iload 20
    //   3525: istore 17
    //   3527: iload 29
    //   3529: istore 14
    //   3531: iload 24
    //   3533: istore 12
    //   3535: aload 39
    //   3537: astore 42
    //   3539: iload 21
    //   3541: istore 18
    //   3543: iload 30
    //   3545: istore 15
    //   3547: iload 25
    //   3549: istore 13
    //   3551: aload 39
    //   3553: astore 38
    //   3555: aload 39
    //   3557: astore 43
    //   3559: iload 22
    //   3561: istore 16
    //   3563: iload 31
    //   3565: istore 10
    //   3567: iload 26
    //   3569: istore 9
    //   3571: aload 39
    //   3573: astore 44
    //   3575: aload 39
    //   3577: astore 45
    //   3579: aload_0
    //   3580: getfield 319	com/whatsapp/data/ad:w	Lcom/whatsapp/data/cn;
    //   3583: getfield 1652	com/whatsapp/data/cn:k	Landroid/database/sqlite/SQLiteStatement;
    //   3586: iconst_2
    //   3587: aload 46
    //   3589: getfield 1612	com/whatsapp/MediaData:file	Ljava/io/File;
    //   3592: invokevirtual 1617	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   3595: invokevirtual 1211	android/database/sqlite/SQLiteStatement:bindString	(ILjava/lang/String;)V
    //   3598: aload 39
    //   3600: astore 40
    //   3602: iload 19
    //   3604: istore 11
    //   3606: iload 27
    //   3608: istore 7
    //   3610: iload 23
    //   3612: istore 8
    //   3614: aload 39
    //   3616: astore 41
    //   3618: iload 20
    //   3620: istore 17
    //   3622: iload 29
    //   3624: istore 14
    //   3626: iload 24
    //   3628: istore 12
    //   3630: aload 39
    //   3632: astore 42
    //   3634: iload 21
    //   3636: istore 18
    //   3638: iload 30
    //   3640: istore 15
    //   3642: iload 25
    //   3644: istore 13
    //   3646: aload 39
    //   3648: astore 38
    //   3650: aload 39
    //   3652: astore 43
    //   3654: iload 22
    //   3656: istore 16
    //   3658: iload 31
    //   3660: istore 10
    //   3662: iload 26
    //   3664: istore 9
    //   3666: aload 39
    //   3668: astore 44
    //   3670: aload 39
    //   3672: astore 45
    //   3674: aload_0
    //   3675: getfield 319	com/whatsapp/data/ad:w	Lcom/whatsapp/data/cn;
    //   3678: getfield 1652	com/whatsapp/data/cn:k	Landroid/database/sqlite/SQLiteStatement;
    //   3681: invokevirtual 1234	android/database/sqlite/SQLiteStatement:execute	()V
    //   3684: goto -1775 -> 1909
    //   3687: astore 39
    //   3689: aload 40
    //   3691: astore 38
    //   3693: aload 39
    //   3695: invokestatic 1169	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   3698: iload 11
    //   3700: istore 6
    //   3702: iload 7
    //   3704: istore 13
    //   3706: iload 8
    //   3708: istore 12
    //   3710: aload 40
    //   3712: ifnull +4958 -> 8670
    //   3715: aload 40
    //   3717: invokevirtual 1163	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   3720: istore 5
    //   3722: iload 11
    //   3724: istore 6
    //   3726: iload 7
    //   3728: istore 13
    //   3730: iload 8
    //   3732: istore 12
    //   3734: iload 5
    //   3736: ifeq +4934 -> 8670
    //   3739: aload 40
    //   3741: invokevirtual 1166	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   3744: iconst_0
    //   3745: istore_3
    //   3746: iconst_0
    //   3747: istore 5
    //   3749: iload 11
    //   3751: istore 6
    //   3753: iload_3
    //   3754: ifeq +4840 -> 8594
    //   3757: iload_2
    //   3758: ifle +4836 -> 8594
    //   3761: aload_0
    //   3762: getfield 361	com/whatsapp/data/ad:b	Lcom/whatsapp/data/n;
    //   3765: invokevirtual 1838	com/whatsapp/data/n:close	()V
    //   3768: aload_0
    //   3769: getfield 319	com/whatsapp/data/ad:w	Lcom/whatsapp/data/cn;
    //   3772: invokevirtual 1839	com/whatsapp/data/cn:c	()V
    //   3775: aload_0
    //   3776: aload_1
    //   3777: iload_2
    //   3778: iconst_1
    //   3779: isub
    //   3780: invokespecial 1841	com/whatsapp/data/ad:g	(Lcom/whatsapp/protocol/j;I)Lcom/whatsapp/data/ad$a;
    //   3783: astore_1
    //   3784: aload_0
    //   3785: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   3788: invokevirtual 460	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   3791: aload_1
    //   3792: areturn
    //   3793: aload 39
    //   3795: astore 40
    //   3797: iload 19
    //   3799: istore 11
    //   3801: iload 27
    //   3803: istore 7
    //   3805: iload 23
    //   3807: istore 8
    //   3809: aload 39
    //   3811: astore 41
    //   3813: iload 20
    //   3815: istore 17
    //   3817: iload 29
    //   3819: istore 14
    //   3821: iload 24
    //   3823: istore 12
    //   3825: aload 39
    //   3827: astore 42
    //   3829: iload 21
    //   3831: istore 18
    //   3833: iload 30
    //   3835: istore 15
    //   3837: iload 25
    //   3839: istore 13
    //   3841: aload 39
    //   3843: astore 38
    //   3845: aload 39
    //   3847: astore 43
    //   3849: iload 22
    //   3851: istore 16
    //   3853: iload 31
    //   3855: istore 10
    //   3857: iload 26
    //   3859: istore 9
    //   3861: aload 39
    //   3863: astore 44
    //   3865: aload 39
    //   3867: astore 45
    //   3869: aload_1
    //   3870: invokevirtual 947	com/whatsapp/protocol/j:a	()Z
    //   3873: ifeq +172 -> 4045
    //   3876: aload 39
    //   3878: astore 40
    //   3880: iload 19
    //   3882: istore 11
    //   3884: iload 27
    //   3886: istore 7
    //   3888: iload 23
    //   3890: istore 8
    //   3892: aload 39
    //   3894: astore 41
    //   3896: iload 20
    //   3898: istore 17
    //   3900: iload 29
    //   3902: istore 14
    //   3904: iload 24
    //   3906: istore 12
    //   3908: aload 39
    //   3910: astore 42
    //   3912: iload 21
    //   3914: istore 18
    //   3916: iload 30
    //   3918: istore 15
    //   3920: iload 25
    //   3922: istore 13
    //   3924: aload 39
    //   3926: astore 38
    //   3928: aload 39
    //   3930: astore 43
    //   3932: iload 22
    //   3934: istore 16
    //   3936: iload 31
    //   3938: istore 10
    //   3940: iload 26
    //   3942: istore 9
    //   3944: aload 39
    //   3946: astore 44
    //   3948: aload 39
    //   3950: astore 45
    //   3952: aload_1
    //   3953: getfield 849	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   3956: getfield 853	com/whatsapp/protocol/j$b:b	Z
    //   3959: ifeq +86 -> 4045
    //   3962: aload 39
    //   3964: astore 40
    //   3966: iload 19
    //   3968: istore 11
    //   3970: iload 27
    //   3972: istore 7
    //   3974: iload 23
    //   3976: istore 8
    //   3978: aload 39
    //   3980: astore 41
    //   3982: iload 20
    //   3984: istore 17
    //   3986: iload 29
    //   3988: istore 14
    //   3990: iload 24
    //   3992: istore 12
    //   3994: aload 39
    //   3996: astore 42
    //   3998: iload 21
    //   4000: istore 18
    //   4002: iload 30
    //   4004: istore 15
    //   4006: iload 25
    //   4008: istore 13
    //   4010: aload 39
    //   4012: astore 38
    //   4014: aload 39
    //   4016: astore 43
    //   4018: iload 22
    //   4020: istore 16
    //   4022: iload 31
    //   4024: istore 10
    //   4026: iload 26
    //   4028: istore 9
    //   4030: aload 39
    //   4032: astore 44
    //   4034: aload 39
    //   4036: astore 45
    //   4038: aload_0
    //   4039: aload 39
    //   4041: aload_1
    //   4042: invokespecial 1843	com/whatsapp/data/ad:a	(Landroid/database/sqlite/SQLiteDatabase;Lcom/whatsapp/protocol/j;)V
    //   4045: aload 39
    //   4047: astore 40
    //   4049: iload 19
    //   4051: istore 11
    //   4053: iload 27
    //   4055: istore 7
    //   4057: iload 23
    //   4059: istore 8
    //   4061: aload 39
    //   4063: astore 41
    //   4065: iload 20
    //   4067: istore 17
    //   4069: iload 29
    //   4071: istore 14
    //   4073: iload 24
    //   4075: istore 12
    //   4077: aload 39
    //   4079: astore 42
    //   4081: iload 21
    //   4083: istore 18
    //   4085: iload 30
    //   4087: istore 15
    //   4089: iload 25
    //   4091: istore 13
    //   4093: aload 39
    //   4095: astore 38
    //   4097: aload 39
    //   4099: astore 43
    //   4101: iload 22
    //   4103: istore 16
    //   4105: iload 31
    //   4107: istore 10
    //   4109: iload 26
    //   4111: istore 9
    //   4113: aload 39
    //   4115: astore 44
    //   4117: aload 39
    //   4119: astore 45
    //   4121: aload_0
    //   4122: aload_1
    //   4123: invokespecial 1832	com/whatsapp/data/ad:g	(Lcom/whatsapp/protocol/j;)V
    //   4126: aload 39
    //   4128: astore 40
    //   4130: iload 19
    //   4132: istore 11
    //   4134: iload 27
    //   4136: istore 7
    //   4138: iload 23
    //   4140: istore 8
    //   4142: aload 39
    //   4144: astore 41
    //   4146: iload 20
    //   4148: istore 17
    //   4150: iload 29
    //   4152: istore 14
    //   4154: iload 24
    //   4156: istore 12
    //   4158: aload 39
    //   4160: astore 42
    //   4162: iload 21
    //   4164: istore 18
    //   4166: iload 30
    //   4168: istore 15
    //   4170: iload 25
    //   4172: istore 13
    //   4174: aload 39
    //   4176: astore 38
    //   4178: aload 39
    //   4180: astore 43
    //   4182: iload 22
    //   4184: istore 16
    //   4186: iload 31
    //   4188: istore 10
    //   4190: iload 26
    //   4192: istore 9
    //   4194: aload 39
    //   4196: astore 44
    //   4198: aload 39
    //   4200: astore 45
    //   4202: aload_1
    //   4203: getfield 623	com/whatsapp/protocol/j:Q	J
    //   4206: ldc2_w 1154
    //   4209: lcmp
    //   4210: ifne +155 -> 4365
    //   4213: aload 39
    //   4215: astore 40
    //   4217: iload 19
    //   4219: istore 11
    //   4221: iload 27
    //   4223: istore 7
    //   4225: iload 23
    //   4227: istore 8
    //   4229: aload 39
    //   4231: astore 41
    //   4233: iload 20
    //   4235: istore 17
    //   4237: iload 29
    //   4239: istore 14
    //   4241: iload 24
    //   4243: istore 12
    //   4245: aload 39
    //   4247: astore 42
    //   4249: iload 21
    //   4251: istore 18
    //   4253: iload 30
    //   4255: istore 15
    //   4257: iload 25
    //   4259: istore 13
    //   4261: aload 39
    //   4263: astore 38
    //   4265: aload 39
    //   4267: astore 43
    //   4269: iload 22
    //   4271: istore 16
    //   4273: iload 31
    //   4275: istore 10
    //   4277: iload 26
    //   4279: istore 9
    //   4281: aload 39
    //   4283: astore 44
    //   4285: aload 39
    //   4287: astore 45
    //   4289: ldc_w 1845
    //   4292: invokestatic 509	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   4295: iload 34
    //   4297: istore 8
    //   4299: iload 6
    //   4301: istore 7
    //   4303: iload 5
    //   4305: istore 9
    //   4307: iload 9
    //   4309: istore 6
    //   4311: iload 7
    //   4313: istore 13
    //   4315: iload 8
    //   4317: istore 12
    //   4319: aload 39
    //   4321: ifnull +4349 -> 8670
    //   4324: aload 39
    //   4326: invokevirtual 1163	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   4329: istore 5
    //   4331: iload 9
    //   4333: istore 6
    //   4335: iload 7
    //   4337: istore 13
    //   4339: iload 8
    //   4341: istore 12
    //   4343: iload 5
    //   4345: ifeq +4325 -> 8670
    //   4348: aload 39
    //   4350: invokevirtual 1166	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   4353: iconst_0
    //   4354: istore_3
    //   4355: iconst_0
    //   4356: istore 5
    //   4358: iload 9
    //   4360: istore 6
    //   4362: goto -609 -> 3753
    //   4365: aload 39
    //   4367: astore 40
    //   4369: iload 19
    //   4371: istore 11
    //   4373: iload 27
    //   4375: istore 7
    //   4377: iload 23
    //   4379: istore 8
    //   4381: aload 39
    //   4383: astore 41
    //   4385: iload 20
    //   4387: istore 17
    //   4389: iload 29
    //   4391: istore 14
    //   4393: iload 24
    //   4395: istore 12
    //   4397: aload 39
    //   4399: astore 42
    //   4401: iload 21
    //   4403: istore 18
    //   4405: iload 30
    //   4407: istore 15
    //   4409: iload 25
    //   4411: istore 13
    //   4413: aload 39
    //   4415: astore 38
    //   4417: aload 39
    //   4419: astore 43
    //   4421: iload 22
    //   4423: istore 16
    //   4425: iload 31
    //   4427: istore 10
    //   4429: iload 26
    //   4431: istore 9
    //   4433: aload 39
    //   4435: astore 44
    //   4437: aload 39
    //   4439: astore 45
    //   4441: aload_1
    //   4442: invokevirtual 947	com/whatsapp/protocol/j:a	()Z
    //   4445: ifeq +2395 -> 6840
    //   4448: aload 39
    //   4450: astore 40
    //   4452: iload 19
    //   4454: istore 11
    //   4456: iload 27
    //   4458: istore 7
    //   4460: iload 23
    //   4462: istore 8
    //   4464: iload 28
    //   4466: istore 6
    //   4468: iload 32
    //   4470: istore 5
    //   4472: aload 39
    //   4474: astore 41
    //   4476: iload 20
    //   4478: istore 17
    //   4480: iload 29
    //   4482: istore 14
    //   4484: iload 24
    //   4486: istore 12
    //   4488: aload 39
    //   4490: astore 42
    //   4492: iload 21
    //   4494: istore 18
    //   4496: iload 30
    //   4498: istore 15
    //   4500: iload 25
    //   4502: istore 13
    //   4504: aload 39
    //   4506: astore 38
    //   4508: aload 39
    //   4510: astore 43
    //   4512: iload 22
    //   4514: istore 16
    //   4516: iload 31
    //   4518: istore 10
    //   4520: iload 26
    //   4522: istore 9
    //   4524: aload 39
    //   4526: astore 44
    //   4528: aload 39
    //   4530: astore 45
    //   4532: aload_1
    //   4533: getfield 621	com/whatsapp/protocol/j:s	B
    //   4536: bipush 11
    //   4538: if_icmpeq +1831 -> 6369
    //   4541: aload 39
    //   4543: astore 40
    //   4545: iload 19
    //   4547: istore 11
    //   4549: iload 27
    //   4551: istore 7
    //   4553: iload 23
    //   4555: istore 8
    //   4557: aload 39
    //   4559: astore 41
    //   4561: iload 20
    //   4563: istore 17
    //   4565: iload 29
    //   4567: istore 14
    //   4569: iload 24
    //   4571: istore 12
    //   4573: aload 39
    //   4575: astore 42
    //   4577: iload 21
    //   4579: istore 18
    //   4581: iload 30
    //   4583: istore 15
    //   4585: iload 25
    //   4587: istore 13
    //   4589: aload 39
    //   4591: astore 38
    //   4593: aload 39
    //   4595: astore 43
    //   4597: iload 22
    //   4599: istore 16
    //   4601: iload 31
    //   4603: istore 10
    //   4605: iload 26
    //   4607: istore 9
    //   4609: aload 39
    //   4611: astore 44
    //   4613: aload 39
    //   4615: astore 45
    //   4617: aload_0
    //   4618: getfield 325	com/whatsapp/data/ad:x	Lcom/whatsapp/data/co;
    //   4621: astore 48
    //   4623: aload 39
    //   4625: astore 40
    //   4627: iload 19
    //   4629: istore 11
    //   4631: iload 27
    //   4633: istore 7
    //   4635: iload 23
    //   4637: istore 8
    //   4639: aload 39
    //   4641: astore 41
    //   4643: iload 20
    //   4645: istore 17
    //   4647: iload 29
    //   4649: istore 14
    //   4651: iload 24
    //   4653: istore 12
    //   4655: aload 39
    //   4657: astore 42
    //   4659: iload 21
    //   4661: istore 18
    //   4663: iload 30
    //   4665: istore 15
    //   4667: iload 25
    //   4669: istore 13
    //   4671: aload 39
    //   4673: astore 38
    //   4675: aload 39
    //   4677: astore 43
    //   4679: iload 22
    //   4681: istore 16
    //   4683: iload 31
    //   4685: istore 10
    //   4687: iload 26
    //   4689: istore 9
    //   4691: aload 39
    //   4693: astore 44
    //   4695: aload 39
    //   4697: astore 45
    //   4699: aload_1
    //   4700: getfield 1437	com/whatsapp/protocol/j:f	Ljava/lang/String;
    //   4703: astore 49
    //   4705: aload 39
    //   4707: astore 40
    //   4709: iload 19
    //   4711: istore 11
    //   4713: iload 27
    //   4715: istore 7
    //   4717: iload 23
    //   4719: istore 8
    //   4721: aload 39
    //   4723: astore 41
    //   4725: iload 20
    //   4727: istore 17
    //   4729: iload 29
    //   4731: istore 14
    //   4733: iload 24
    //   4735: istore 12
    //   4737: aload 39
    //   4739: astore 42
    //   4741: iload 21
    //   4743: istore 18
    //   4745: iload 30
    //   4747: istore 15
    //   4749: iload 25
    //   4751: istore 13
    //   4753: aload 39
    //   4755: astore 38
    //   4757: aload 39
    //   4759: astore 43
    //   4761: iload 22
    //   4763: istore 16
    //   4765: iload 31
    //   4767: istore 10
    //   4769: iload 26
    //   4771: istore 9
    //   4773: aload 39
    //   4775: astore 44
    //   4777: aload 39
    //   4779: astore 45
    //   4781: aload 48
    //   4783: aload 49
    //   4785: invokevirtual 1848	com/whatsapp/data/co:a	(Ljava/lang/String;)Lcom/whatsapp/data/ad$n;
    //   4788: astore 46
    //   4790: aload 39
    //   4792: astore 40
    //   4794: iload 19
    //   4796: istore 11
    //   4798: iload 27
    //   4800: istore 7
    //   4802: iload 23
    //   4804: istore 8
    //   4806: aload 39
    //   4808: astore 41
    //   4810: iload 20
    //   4812: istore 17
    //   4814: iload 29
    //   4816: istore 14
    //   4818: iload 24
    //   4820: istore 12
    //   4822: aload 39
    //   4824: astore 42
    //   4826: iload 21
    //   4828: istore 18
    //   4830: iload 30
    //   4832: istore 15
    //   4834: iload 25
    //   4836: istore 13
    //   4838: aload 39
    //   4840: astore 38
    //   4842: aload 39
    //   4844: astore 43
    //   4846: iload 22
    //   4848: istore 16
    //   4850: iload 31
    //   4852: istore 10
    //   4854: iload 26
    //   4856: istore 9
    //   4858: aload 39
    //   4860: astore 44
    //   4862: aload 39
    //   4864: astore 45
    //   4866: new 1033	android/content/ContentValues
    //   4869: dup
    //   4870: iconst_4
    //   4871: invokespecial 1036	android/content/ContentValues:<init>	(I)V
    //   4874: astore 50
    //   4876: aload 46
    //   4878: ifnonnull +1872 -> 6750
    //   4881: aload 39
    //   4883: astore 40
    //   4885: iload 19
    //   4887: istore 11
    //   4889: iload 27
    //   4891: istore 7
    //   4893: iload 23
    //   4895: istore 8
    //   4897: aload 39
    //   4899: astore 41
    //   4901: iload 20
    //   4903: istore 17
    //   4905: iload 29
    //   4907: istore 14
    //   4909: iload 24
    //   4911: istore 12
    //   4913: aload 39
    //   4915: astore 42
    //   4917: iload 21
    //   4919: istore 18
    //   4921: iload 30
    //   4923: istore 15
    //   4925: iload 25
    //   4927: istore 13
    //   4929: aload 39
    //   4931: astore 38
    //   4933: aload 39
    //   4935: astore 43
    //   4937: iload 22
    //   4939: istore 16
    //   4941: iload 31
    //   4943: istore 10
    //   4945: iload 26
    //   4947: istore 9
    //   4949: aload 39
    //   4951: astore 44
    //   4953: aload 39
    //   4955: astore 45
    //   4957: new 47	com/whatsapp/data/ad$n
    //   4960: dup
    //   4961: aload 48
    //   4963: getfield 1850	com/whatsapp/data/co:a	Lcom/whatsapp/ant;
    //   4966: aload_1
    //   4967: invokespecial 1853	com/whatsapp/data/ad$n:<init>	(Lcom/whatsapp/ant;Lcom/whatsapp/protocol/j;)V
    //   4970: astore 46
    //   4972: aload 39
    //   4974: astore 40
    //   4976: iload 19
    //   4978: istore 11
    //   4980: iload 27
    //   4982: istore 7
    //   4984: iload 23
    //   4986: istore 8
    //   4988: aload 39
    //   4990: astore 41
    //   4992: iload 20
    //   4994: istore 17
    //   4996: iload 29
    //   4998: istore 14
    //   5000: iload 24
    //   5002: istore 12
    //   5004: aload 39
    //   5006: astore 42
    //   5008: iload 21
    //   5010: istore 18
    //   5012: iload 30
    //   5014: istore 15
    //   5016: iload 25
    //   5018: istore 13
    //   5020: aload 39
    //   5022: astore 38
    //   5024: aload 39
    //   5026: astore 43
    //   5028: iload 22
    //   5030: istore 16
    //   5032: iload 31
    //   5034: istore 10
    //   5036: iload 26
    //   5038: istore 9
    //   5040: aload 39
    //   5042: astore 44
    //   5044: aload 39
    //   5046: astore 45
    //   5048: aload 50
    //   5050: ldc_w 1252
    //   5053: aload_1
    //   5054: getfield 623	com/whatsapp/protocol/j:Q	J
    //   5057: lconst_1
    //   5058: lsub
    //   5059: invokestatic 588	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5062: invokevirtual 1085	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   5065: aload 39
    //   5067: astore 40
    //   5069: iload 19
    //   5071: istore 11
    //   5073: iload 27
    //   5075: istore 7
    //   5077: iload 23
    //   5079: istore 8
    //   5081: aload 39
    //   5083: astore 41
    //   5085: iload 20
    //   5087: istore 17
    //   5089: iload 29
    //   5091: istore 14
    //   5093: iload 24
    //   5095: istore 12
    //   5097: aload 39
    //   5099: astore 42
    //   5101: iload 21
    //   5103: istore 18
    //   5105: iload 30
    //   5107: istore 15
    //   5109: iload 25
    //   5111: istore 13
    //   5113: aload 39
    //   5115: astore 38
    //   5117: aload 39
    //   5119: astore 43
    //   5121: iload 22
    //   5123: istore 16
    //   5125: iload 31
    //   5127: istore 10
    //   5129: iload 26
    //   5131: istore 9
    //   5133: aload 39
    //   5135: astore 44
    //   5137: aload 39
    //   5139: astore 45
    //   5141: aload 50
    //   5143: ldc_w 1416
    //   5146: aload_1
    //   5147: getfield 623	com/whatsapp/protocol/j:Q	J
    //   5150: lconst_1
    //   5151: lsub
    //   5152: invokestatic 588	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5155: invokevirtual 1085	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   5158: aload 39
    //   5160: astore 40
    //   5162: iload 19
    //   5164: istore 11
    //   5166: iload 27
    //   5168: istore 7
    //   5170: iload 23
    //   5172: istore 8
    //   5174: aload 39
    //   5176: astore 41
    //   5178: iload 20
    //   5180: istore 17
    //   5182: iload 29
    //   5184: istore 14
    //   5186: iload 24
    //   5188: istore 12
    //   5190: aload 39
    //   5192: astore 42
    //   5194: iload 21
    //   5196: istore 18
    //   5198: iload 30
    //   5200: istore 15
    //   5202: iload 25
    //   5204: istore 13
    //   5206: aload 39
    //   5208: astore 38
    //   5210: aload 39
    //   5212: astore 43
    //   5214: iload 22
    //   5216: istore 16
    //   5218: iload 31
    //   5220: istore 10
    //   5222: iload 26
    //   5224: istore 9
    //   5226: aload 39
    //   5228: astore 44
    //   5230: aload 39
    //   5232: astore 45
    //   5234: aload 48
    //   5236: invokevirtual 1237	com/whatsapp/data/co:c	()Ljava/util/Map;
    //   5239: aload 49
    //   5241: aload 46
    //   5243: invokeinterface 1269 3 0
    //   5248: pop
    //   5249: iconst_1
    //   5250: istore 5
    //   5252: aload 39
    //   5254: astore 40
    //   5256: iload 19
    //   5258: istore 11
    //   5260: iload 27
    //   5262: istore 7
    //   5264: iload 23
    //   5266: istore 8
    //   5268: aload 39
    //   5270: astore 41
    //   5272: iload 20
    //   5274: istore 17
    //   5276: iload 29
    //   5278: istore 14
    //   5280: iload 24
    //   5282: istore 12
    //   5284: aload 39
    //   5286: astore 42
    //   5288: iload 21
    //   5290: istore 18
    //   5292: iload 30
    //   5294: istore 15
    //   5296: iload 25
    //   5298: istore 13
    //   5300: aload 39
    //   5302: astore 38
    //   5304: aload 39
    //   5306: astore 43
    //   5308: iload 22
    //   5310: istore 16
    //   5312: iload 31
    //   5314: istore 10
    //   5316: iload 26
    //   5318: istore 9
    //   5320: aload 39
    //   5322: astore 44
    //   5324: aload 39
    //   5326: astore 45
    //   5328: aload 50
    //   5330: ldc_w 1250
    //   5333: aload_1
    //   5334: getfield 623	com/whatsapp/protocol/j:Q	J
    //   5337: invokestatic 588	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5340: invokevirtual 1085	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   5343: aload 39
    //   5345: astore 40
    //   5347: iload 19
    //   5349: istore 11
    //   5351: iload 27
    //   5353: istore 7
    //   5355: iload 23
    //   5357: istore 8
    //   5359: aload 39
    //   5361: astore 41
    //   5363: iload 20
    //   5365: istore 17
    //   5367: iload 29
    //   5369: istore 14
    //   5371: iload 24
    //   5373: istore 12
    //   5375: aload 39
    //   5377: astore 42
    //   5379: iload 21
    //   5381: istore 18
    //   5383: iload 30
    //   5385: istore 15
    //   5387: iload 25
    //   5389: istore 13
    //   5391: aload 39
    //   5393: astore 38
    //   5395: aload 39
    //   5397: astore 43
    //   5399: iload 22
    //   5401: istore 16
    //   5403: iload 31
    //   5405: istore 10
    //   5407: iload 26
    //   5409: istore 9
    //   5411: aload 39
    //   5413: astore 44
    //   5415: aload 39
    //   5417: astore 45
    //   5419: aload 50
    //   5421: ldc_w 1080
    //   5424: aload 46
    //   5426: getfield 524	com/whatsapp/data/ad$n:h	J
    //   5429: invokestatic 588	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5432: invokevirtual 1085	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   5435: aload 39
    //   5437: astore 40
    //   5439: iload 19
    //   5441: istore 11
    //   5443: iload 27
    //   5445: istore 7
    //   5447: iload 23
    //   5449: istore 8
    //   5451: aload 39
    //   5453: astore 41
    //   5455: iload 20
    //   5457: istore 17
    //   5459: iload 29
    //   5461: istore 14
    //   5463: iload 24
    //   5465: istore 12
    //   5467: aload 39
    //   5469: astore 42
    //   5471: iload 21
    //   5473: istore 18
    //   5475: iload 30
    //   5477: istore 15
    //   5479: iload 25
    //   5481: istore 13
    //   5483: aload 39
    //   5485: astore 38
    //   5487: aload 39
    //   5489: astore 43
    //   5491: iload 22
    //   5493: istore 16
    //   5495: iload 31
    //   5497: istore 10
    //   5499: iload 26
    //   5501: istore 9
    //   5503: aload 39
    //   5505: astore 44
    //   5507: aload 39
    //   5509: astore 45
    //   5511: aload 50
    //   5513: ldc_w 1260
    //   5516: aload 46
    //   5518: getfield 619	com/whatsapp/data/ad$n:i	I
    //   5521: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   5524: invokevirtual 1090	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   5527: aload 39
    //   5529: astore 40
    //   5531: iload 19
    //   5533: istore 11
    //   5535: iload 27
    //   5537: istore 7
    //   5539: iload 23
    //   5541: istore 8
    //   5543: aload 39
    //   5545: astore 41
    //   5547: iload 20
    //   5549: istore 17
    //   5551: iload 29
    //   5553: istore 14
    //   5555: iload 24
    //   5557: istore 12
    //   5559: aload 39
    //   5561: astore 42
    //   5563: iload 21
    //   5565: istore 18
    //   5567: iload 30
    //   5569: istore 15
    //   5571: iload 25
    //   5573: istore 13
    //   5575: aload 39
    //   5577: astore 38
    //   5579: aload 39
    //   5581: astore 43
    //   5583: iload 22
    //   5585: istore 16
    //   5587: iload 31
    //   5589: istore 10
    //   5591: iload 26
    //   5593: istore 9
    //   5595: aload 39
    //   5597: astore 44
    //   5599: aload 39
    //   5601: astore 45
    //   5603: aload 50
    //   5605: ldc_w 1262
    //   5608: aload 46
    //   5610: getfield 617	com/whatsapp/data/ad$n:j	I
    //   5613: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   5616: invokevirtual 1090	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   5619: aload 39
    //   5621: astore 40
    //   5623: iload 19
    //   5625: istore 11
    //   5627: iload 27
    //   5629: istore 7
    //   5631: iload 23
    //   5633: istore 8
    //   5635: aload 39
    //   5637: astore 41
    //   5639: iload 20
    //   5641: istore 17
    //   5643: iload 29
    //   5645: istore 14
    //   5647: iload 24
    //   5649: istore 12
    //   5651: aload 39
    //   5653: astore 42
    //   5655: iload 21
    //   5657: istore 18
    //   5659: iload 30
    //   5661: istore 15
    //   5663: iload 25
    //   5665: istore 13
    //   5667: aload 39
    //   5669: astore 38
    //   5671: aload 39
    //   5673: astore 43
    //   5675: iload 22
    //   5677: istore 16
    //   5679: iload 31
    //   5681: istore 10
    //   5683: iload 26
    //   5685: istore 9
    //   5687: aload 39
    //   5689: astore 44
    //   5691: aload 39
    //   5693: astore 45
    //   5695: aload 50
    //   5697: ldc_w 1256
    //   5700: aload 46
    //   5702: getfield 613	com/whatsapp/data/ad$n:f	J
    //   5705: invokestatic 588	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5708: invokevirtual 1085	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   5711: aload 39
    //   5713: astore 40
    //   5715: iload 19
    //   5717: istore 11
    //   5719: iload 27
    //   5721: istore 7
    //   5723: iload 23
    //   5725: istore 8
    //   5727: aload 39
    //   5729: astore 41
    //   5731: iload 20
    //   5733: istore 17
    //   5735: iload 29
    //   5737: istore 14
    //   5739: iload 24
    //   5741: istore 12
    //   5743: aload 39
    //   5745: astore 42
    //   5747: iload 21
    //   5749: istore 18
    //   5751: iload 30
    //   5753: istore 15
    //   5755: iload 25
    //   5757: istore 13
    //   5759: aload 39
    //   5761: astore 38
    //   5763: aload 39
    //   5765: astore 43
    //   5767: iload 22
    //   5769: istore 16
    //   5771: iload 31
    //   5773: istore 10
    //   5775: iload 26
    //   5777: istore 9
    //   5779: aload 39
    //   5781: astore 44
    //   5783: aload 39
    //   5785: astore 45
    //   5787: aload 50
    //   5789: ldc_w 1258
    //   5792: aload 46
    //   5794: getfield 615	com/whatsapp/data/ad$n:g	J
    //   5797: invokestatic 588	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5800: invokevirtual 1085	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   5803: aload 39
    //   5805: astore 40
    //   5807: iload 19
    //   5809: istore 11
    //   5811: iload 27
    //   5813: istore 7
    //   5815: iload 23
    //   5817: istore 8
    //   5819: aload 39
    //   5821: astore 41
    //   5823: iload 20
    //   5825: istore 17
    //   5827: iload 29
    //   5829: istore 14
    //   5831: iload 24
    //   5833: istore 12
    //   5835: aload 39
    //   5837: astore 42
    //   5839: iload 21
    //   5841: istore 18
    //   5843: iload 30
    //   5845: istore 15
    //   5847: iload 25
    //   5849: istore 13
    //   5851: aload 39
    //   5853: astore 38
    //   5855: aload 39
    //   5857: astore 43
    //   5859: iload 22
    //   5861: istore 16
    //   5863: iload 31
    //   5865: istore 10
    //   5867: iload 26
    //   5869: istore 9
    //   5871: aload 39
    //   5873: astore 44
    //   5875: aload 39
    //   5877: astore 45
    //   5879: aload 39
    //   5881: ldc_w 1264
    //   5884: aload 50
    //   5886: ldc_w 1151
    //   5889: iconst_1
    //   5890: anewarray 429	java/lang/String
    //   5893: dup
    //   5894: iconst_0
    //   5895: aload 49
    //   5897: aastore
    //   5898: invokevirtual 1062	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   5901: ifne +2840 -> 8741
    //   5904: aload 39
    //   5906: astore 40
    //   5908: iload 19
    //   5910: istore 11
    //   5912: iload 27
    //   5914: istore 7
    //   5916: iload 23
    //   5918: istore 8
    //   5920: aload 39
    //   5922: astore 41
    //   5924: iload 20
    //   5926: istore 17
    //   5928: iload 29
    //   5930: istore 14
    //   5932: iload 24
    //   5934: istore 12
    //   5936: aload 39
    //   5938: astore 42
    //   5940: iload 21
    //   5942: istore 18
    //   5944: iload 30
    //   5946: istore 15
    //   5948: iload 25
    //   5950: istore 13
    //   5952: aload 39
    //   5954: astore 38
    //   5956: aload 39
    //   5958: astore 43
    //   5960: iload 22
    //   5962: istore 16
    //   5964: iload 31
    //   5966: istore 10
    //   5968: iload 26
    //   5970: istore 9
    //   5972: aload 39
    //   5974: astore 44
    //   5976: aload 39
    //   5978: astore 45
    //   5980: aload 50
    //   5982: ldc_w 1153
    //   5985: aload 49
    //   5987: invokevirtual 1042	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   5990: aload 39
    //   5992: astore 40
    //   5994: iload 19
    //   5996: istore 11
    //   5998: iload 27
    //   6000: istore 7
    //   6002: iload 23
    //   6004: istore 8
    //   6006: aload 39
    //   6008: astore 41
    //   6010: iload 20
    //   6012: istore 17
    //   6014: iload 29
    //   6016: istore 14
    //   6018: iload 24
    //   6020: istore 12
    //   6022: aload 39
    //   6024: astore 42
    //   6026: iload 21
    //   6028: istore 18
    //   6030: iload 30
    //   6032: istore 15
    //   6034: iload 25
    //   6036: istore 13
    //   6038: aload 39
    //   6040: astore 38
    //   6042: aload 39
    //   6044: astore 43
    //   6046: iload 22
    //   6048: istore 16
    //   6050: iload 31
    //   6052: istore 10
    //   6054: iload 26
    //   6056: istore 9
    //   6058: aload 39
    //   6060: astore 44
    //   6062: aload 39
    //   6064: astore 45
    //   6066: aload 39
    //   6068: ldc_w 1264
    //   6071: aconst_null
    //   6072: aload 50
    //   6074: invokevirtual 1066	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   6077: lstore 36
    //   6079: aload 39
    //   6081: astore 40
    //   6083: iload 19
    //   6085: istore 11
    //   6087: iload 27
    //   6089: istore 7
    //   6091: iload 23
    //   6093: istore 8
    //   6095: aload 39
    //   6097: astore 41
    //   6099: iload 20
    //   6101: istore 17
    //   6103: iload 29
    //   6105: istore 14
    //   6107: iload 24
    //   6109: istore 12
    //   6111: aload 39
    //   6113: astore 42
    //   6115: iload 21
    //   6117: istore 18
    //   6119: iload 30
    //   6121: istore 15
    //   6123: iload 25
    //   6125: istore 13
    //   6127: aload 39
    //   6129: astore 38
    //   6131: aload 39
    //   6133: astore 43
    //   6135: iload 22
    //   6137: istore 16
    //   6139: iload 31
    //   6141: istore 10
    //   6143: iload 26
    //   6145: istore 9
    //   6147: aload 39
    //   6149: astore 44
    //   6151: aload 39
    //   6153: astore 45
    //   6155: aload 48
    //   6157: invokevirtual 1237	com/whatsapp/data/co:c	()Ljava/util/Map;
    //   6160: invokeinterface 1713 1 0
    //   6165: iconst_1
    //   6166: if_icmpne +94 -> 6260
    //   6169: aload 39
    //   6171: astore 40
    //   6173: iload 19
    //   6175: istore 11
    //   6177: iload 27
    //   6179: istore 7
    //   6181: iload 23
    //   6183: istore 8
    //   6185: aload 39
    //   6187: astore 41
    //   6189: iload 20
    //   6191: istore 17
    //   6193: iload 29
    //   6195: istore 14
    //   6197: iload 24
    //   6199: istore 12
    //   6201: aload 39
    //   6203: astore 42
    //   6205: iload 21
    //   6207: istore 18
    //   6209: iload 30
    //   6211: istore 15
    //   6213: iload 25
    //   6215: istore 13
    //   6217: aload 39
    //   6219: astore 38
    //   6221: aload 39
    //   6223: astore 43
    //   6225: iload 22
    //   6227: istore 16
    //   6229: iload 31
    //   6231: istore 10
    //   6233: iload 26
    //   6235: istore 9
    //   6237: aload 39
    //   6239: astore 44
    //   6241: aload 39
    //   6243: astore 45
    //   6245: aload 48
    //   6247: getfield 1855	com/whatsapp/data/co:b	Lcom/whatsapp/data/cj;
    //   6250: ldc_w 1857
    //   6253: aload_1
    //   6254: getfield 527	com/whatsapp/protocol/j:n	J
    //   6257: invokevirtual 1860	com/whatsapp/data/cj:a	(Ljava/lang/String;J)V
    //   6260: lload 36
    //   6262: ldc2_w 1154
    //   6265: lcmp
    //   6266: ifne +2475 -> 8741
    //   6269: aload 39
    //   6271: astore 40
    //   6273: iload 19
    //   6275: istore 11
    //   6277: iload 27
    //   6279: istore 7
    //   6281: iload 23
    //   6283: istore 8
    //   6285: aload 39
    //   6287: astore 41
    //   6289: iload 20
    //   6291: istore 17
    //   6293: iload 29
    //   6295: istore 14
    //   6297: iload 24
    //   6299: istore 12
    //   6301: aload 39
    //   6303: astore 42
    //   6305: iload 21
    //   6307: istore 18
    //   6309: iload 30
    //   6311: istore 15
    //   6313: iload 25
    //   6315: istore 13
    //   6317: aload 39
    //   6319: astore 38
    //   6321: aload 39
    //   6323: astore 43
    //   6325: iload 22
    //   6327: istore 16
    //   6329: iload 31
    //   6331: istore 10
    //   6333: iload 26
    //   6335: istore 9
    //   6337: aload 39
    //   6339: astore 44
    //   6341: aload 39
    //   6343: astore 45
    //   6345: new 162	java/lang/StringBuilder
    //   6348: dup
    //   6349: ldc_w 1862
    //   6352: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   6355: aload 49
    //   6357: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6360: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6363: invokestatic 509	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   6366: goto +2375 -> 8741
    //   6369: aload 39
    //   6371: astore 40
    //   6373: iload 19
    //   6375: istore 11
    //   6377: iload 6
    //   6379: istore 7
    //   6381: iload 5
    //   6383: istore 8
    //   6385: aload 39
    //   6387: astore 41
    //   6389: iload 20
    //   6391: istore 17
    //   6393: iload 6
    //   6395: istore 14
    //   6397: iload 5
    //   6399: istore 12
    //   6401: aload 39
    //   6403: astore 42
    //   6405: iload 21
    //   6407: istore 18
    //   6409: iload 6
    //   6411: istore 15
    //   6413: iload 5
    //   6415: istore 13
    //   6417: aload 39
    //   6419: astore 38
    //   6421: aload 39
    //   6423: astore 43
    //   6425: iload 22
    //   6427: istore 16
    //   6429: iload 6
    //   6431: istore 10
    //   6433: iload 5
    //   6435: istore 9
    //   6437: aload 39
    //   6439: astore 44
    //   6441: aload 39
    //   6443: astore 45
    //   6445: aload 39
    //   6447: invokevirtual 1160	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   6450: aload 39
    //   6452: astore 40
    //   6454: iload 19
    //   6456: istore 11
    //   6458: iload 6
    //   6460: istore 7
    //   6462: iload 5
    //   6464: istore 8
    //   6466: aload 39
    //   6468: astore 41
    //   6470: iload 20
    //   6472: istore 17
    //   6474: iload 6
    //   6476: istore 14
    //   6478: iload 5
    //   6480: istore 12
    //   6482: aload 39
    //   6484: astore 42
    //   6486: iload 21
    //   6488: istore 18
    //   6490: iload 6
    //   6492: istore 15
    //   6494: iload 5
    //   6496: istore 13
    //   6498: aload 39
    //   6500: astore 38
    //   6502: aload 39
    //   6504: astore 43
    //   6506: iload 22
    //   6508: istore 16
    //   6510: iload 6
    //   6512: istore 10
    //   6514: iload 5
    //   6516: istore 9
    //   6518: aload 39
    //   6520: astore 44
    //   6522: aload 39
    //   6524: astore 45
    //   6526: aload_0
    //   6527: getfield 385	com/whatsapp/data/ad:K	Lcom/whatsapp/data/z;
    //   6530: aload_1
    //   6531: getfield 849	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   6534: aload_1
    //   6535: invokevirtual 1274	com/whatsapp/data/z:a	(Lcom/whatsapp/protocol/j$b;Lcom/whatsapp/protocol/j;)V
    //   6538: iconst_1
    //   6539: istore 19
    //   6541: iconst_1
    //   6542: istore 17
    //   6544: iconst_1
    //   6545: istore 18
    //   6547: iconst_1
    //   6548: istore 16
    //   6550: iconst_1
    //   6551: istore 11
    //   6553: aload 39
    //   6555: astore 40
    //   6557: iload 6
    //   6559: istore 7
    //   6561: iload 5
    //   6563: istore 8
    //   6565: aload 39
    //   6567: astore 41
    //   6569: iload 6
    //   6571: istore 14
    //   6573: iload 5
    //   6575: istore 12
    //   6577: aload 39
    //   6579: astore 42
    //   6581: iload 6
    //   6583: istore 15
    //   6585: iload 5
    //   6587: istore 13
    //   6589: aload 39
    //   6591: astore 38
    //   6593: aload 39
    //   6595: astore 43
    //   6597: iload 6
    //   6599: istore 10
    //   6601: iload 5
    //   6603: istore 9
    //   6605: aload 39
    //   6607: astore 44
    //   6609: aload 39
    //   6611: astore 45
    //   6613: new 162	java/lang/StringBuilder
    //   6616: dup
    //   6617: ldc_w 1864
    //   6620: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   6623: aload 47
    //   6625: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6628: ldc_w 1310
    //   6631: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6634: aload_1
    //   6635: getfield 849	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   6638: getfield 934	com/whatsapp/protocol/j$b:c	Ljava/lang/String;
    //   6641: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6644: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6647: invokestatic 487	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   6650: iload 19
    //   6652: istore 9
    //   6654: iload 6
    //   6656: istore 7
    //   6658: iload 5
    //   6660: istore 8
    //   6662: goto -2355 -> 4307
    //   6665: astore 39
    //   6667: aload 41
    //   6669: astore 38
    //   6671: new 162	java/lang/StringBuilder
    //   6674: dup
    //   6675: ldc_w 1866
    //   6678: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   6681: aload_1
    //   6682: getfield 849	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   6685: getfield 934	com/whatsapp/protocol/j$b:c	Ljava/lang/String;
    //   6688: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6691: ldc_w 1310
    //   6694: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6697: aload 39
    //   6699: invokevirtual 583	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6702: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6705: invokestatic 474	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   6708: aload 41
    //   6710: ifnull +1994 -> 8704
    //   6713: aload 41
    //   6715: invokevirtual 1163	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   6718: istore 5
    //   6720: iload 5
    //   6722: ifeq +1982 -> 8704
    //   6725: aload 41
    //   6727: invokevirtual 1166	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   6730: iconst_1
    //   6731: istore 5
    //   6733: iconst_0
    //   6734: istore_3
    //   6735: iload 17
    //   6737: istore 6
    //   6739: iload 14
    //   6741: istore 7
    //   6743: iload 12
    //   6745: istore 8
    //   6747: goto -2994 -> 3753
    //   6750: aload 39
    //   6752: astore 40
    //   6754: iload 19
    //   6756: istore 11
    //   6758: iload 27
    //   6760: istore 7
    //   6762: iload 23
    //   6764: istore 8
    //   6766: aload 39
    //   6768: astore 41
    //   6770: iload 20
    //   6772: istore 17
    //   6774: iload 29
    //   6776: istore 14
    //   6778: iload 24
    //   6780: istore 12
    //   6782: aload 39
    //   6784: astore 42
    //   6786: iload 21
    //   6788: istore 18
    //   6790: iload 30
    //   6792: istore 15
    //   6794: iload 25
    //   6796: istore 13
    //   6798: aload 39
    //   6800: astore 38
    //   6802: aload 39
    //   6804: astore 43
    //   6806: iload 22
    //   6808: istore 16
    //   6810: iload 31
    //   6812: istore 10
    //   6814: iload 26
    //   6816: istore 9
    //   6818: aload 39
    //   6820: astore 44
    //   6822: aload 39
    //   6824: astore 45
    //   6826: aload 46
    //   6828: aload_1
    //   6829: invokevirtual 1868	com/whatsapp/data/ad$n:c	(Lcom/whatsapp/protocol/j;)Lcom/whatsapp/data/ad$n;
    //   6832: astore 46
    //   6834: iconst_0
    //   6835: istore 5
    //   6837: goto -1585 -> 5252
    //   6840: aload 39
    //   6842: astore 40
    //   6844: iload 19
    //   6846: istore 11
    //   6848: iload 27
    //   6850: istore 7
    //   6852: iload 23
    //   6854: istore 8
    //   6856: aload 39
    //   6858: astore 41
    //   6860: iload 20
    //   6862: istore 17
    //   6864: iload 29
    //   6866: istore 14
    //   6868: iload 24
    //   6870: istore 12
    //   6872: aload 39
    //   6874: astore 42
    //   6876: iload 21
    //   6878: istore 18
    //   6880: iload 30
    //   6882: istore 15
    //   6884: iload 25
    //   6886: istore 13
    //   6888: aload 39
    //   6890: astore 38
    //   6892: aload 39
    //   6894: astore 43
    //   6896: iload 22
    //   6898: istore 16
    //   6900: iload 31
    //   6902: istore 10
    //   6904: iload 26
    //   6906: istore 9
    //   6908: aload 39
    //   6910: astore 44
    //   6912: aload 39
    //   6914: astore 45
    //   6916: aload_0
    //   6917: getfield 281	com/whatsapp/data/ad:n	Lcom/whatsapp/data/d;
    //   6920: getfield 1406	com/whatsapp/data/d:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   6923: aload 47
    //   6925: invokevirtual 1409	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   6928: checkcast 17	com/whatsapp/data/ad$d
    //   6931: astore 46
    //   6933: iload 33
    //   6935: istore 6
    //   6937: aload 46
    //   6939: ifnull +173 -> 7112
    //   6942: aload 39
    //   6944: astore 40
    //   6946: iload 19
    //   6948: istore 11
    //   6950: iload 27
    //   6952: istore 7
    //   6954: iload 23
    //   6956: istore 8
    //   6958: aload 39
    //   6960: astore 41
    //   6962: iload 20
    //   6964: istore 17
    //   6966: iload 29
    //   6968: istore 14
    //   6970: iload 24
    //   6972: istore 12
    //   6974: iload 33
    //   6976: istore 6
    //   6978: aload 39
    //   6980: astore 42
    //   6982: iload 21
    //   6984: istore 18
    //   6986: iload 30
    //   6988: istore 15
    //   6990: iload 25
    //   6992: istore 13
    //   6994: aload 39
    //   6996: astore 38
    //   6998: aload 39
    //   7000: astore 43
    //   7002: iload 22
    //   7004: istore 16
    //   7006: iload 31
    //   7008: istore 10
    //   7010: iload 26
    //   7012: istore 9
    //   7014: aload 39
    //   7016: astore 44
    //   7018: aload 39
    //   7020: astore 45
    //   7022: aload 46
    //   7024: getfield 1424	com/whatsapp/data/ad$d:e	Z
    //   7027: ifeq +85 -> 7112
    //   7030: aload 39
    //   7032: astore 40
    //   7034: iload 19
    //   7036: istore 11
    //   7038: iload 27
    //   7040: istore 7
    //   7042: iload 23
    //   7044: istore 8
    //   7046: aload 39
    //   7048: astore 41
    //   7050: iload 20
    //   7052: istore 17
    //   7054: iload 29
    //   7056: istore 14
    //   7058: iload 24
    //   7060: istore 12
    //   7062: aload 39
    //   7064: astore 42
    //   7066: iload 21
    //   7068: istore 18
    //   7070: iload 30
    //   7072: istore 15
    //   7074: iload 25
    //   7076: istore 13
    //   7078: aload 39
    //   7080: astore 38
    //   7082: aload 39
    //   7084: astore 43
    //   7086: iload 22
    //   7088: istore 16
    //   7090: iload 31
    //   7092: istore 10
    //   7094: iload 26
    //   7096: istore 9
    //   7098: aload 39
    //   7100: astore 44
    //   7102: aload 39
    //   7104: astore 45
    //   7106: aload_1
    //   7107: invokestatic 1426	com/whatsapp/data/ad:k	(Lcom/whatsapp/protocol/j;)Z
    //   7110: istore 6
    //   7112: aload 39
    //   7114: astore 40
    //   7116: iload 19
    //   7118: istore 11
    //   7120: iload 6
    //   7122: istore 7
    //   7124: iload 23
    //   7126: istore 8
    //   7128: aload 39
    //   7130: astore 41
    //   7132: iload 20
    //   7134: istore 17
    //   7136: iload 6
    //   7138: istore 14
    //   7140: iload 24
    //   7142: istore 12
    //   7144: aload 39
    //   7146: astore 42
    //   7148: iload 21
    //   7150: istore 18
    //   7152: iload 6
    //   7154: istore 15
    //   7156: iload 25
    //   7158: istore 13
    //   7160: aload 39
    //   7162: astore 38
    //   7164: aload 39
    //   7166: astore 43
    //   7168: iload 22
    //   7170: istore 16
    //   7172: iload 6
    //   7174: istore 10
    //   7176: iload 26
    //   7178: istore 9
    //   7180: aload 39
    //   7182: astore 44
    //   7184: aload 39
    //   7186: astore 45
    //   7188: aload_0
    //   7189: aload 39
    //   7191: aload_1
    //   7192: invokespecial 1837	com/whatsapp/data/ad:b	(Landroid/database/sqlite/SQLiteDatabase;Lcom/whatsapp/protocol/j;)V
    //   7195: aload 46
    //   7197: ifnonnull +256 -> 7453
    //   7200: aload 39
    //   7202: astore 40
    //   7204: iload 19
    //   7206: istore 11
    //   7208: iload 6
    //   7210: istore 7
    //   7212: iload 23
    //   7214: istore 8
    //   7216: aload 39
    //   7218: astore 41
    //   7220: iload 20
    //   7222: istore 17
    //   7224: iload 6
    //   7226: istore 14
    //   7228: iload 24
    //   7230: istore 12
    //   7232: aload 39
    //   7234: astore 42
    //   7236: iload 21
    //   7238: istore 18
    //   7240: iload 6
    //   7242: istore 15
    //   7244: iload 25
    //   7246: istore 13
    //   7248: aload 39
    //   7250: astore 38
    //   7252: aload 39
    //   7254: astore 43
    //   7256: iload 22
    //   7258: istore 16
    //   7260: iload 6
    //   7262: istore 10
    //   7264: iload 26
    //   7266: istore 9
    //   7268: aload 39
    //   7270: astore 44
    //   7272: aload 39
    //   7274: astore 45
    //   7276: aload_0
    //   7277: getfield 281	com/whatsapp/data/ad:n	Lcom/whatsapp/data/d;
    //   7280: getfield 1406	com/whatsapp/data/d:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   7283: aload 47
    //   7285: invokevirtual 1409	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   7288: ifnull +165 -> 7453
    //   7291: iconst_1
    //   7292: istore 5
    //   7294: aload 39
    //   7296: astore 40
    //   7298: iload 19
    //   7300: istore 11
    //   7302: iload 6
    //   7304: istore 7
    //   7306: iload 5
    //   7308: istore 8
    //   7310: aload 39
    //   7312: astore 41
    //   7314: iload 20
    //   7316: istore 17
    //   7318: iload 6
    //   7320: istore 14
    //   7322: iload 5
    //   7324: istore 12
    //   7326: aload 39
    //   7328: astore 42
    //   7330: iload 21
    //   7332: istore 18
    //   7334: iload 6
    //   7336: istore 15
    //   7338: iload 5
    //   7340: istore 13
    //   7342: aload 39
    //   7344: astore 38
    //   7346: aload 39
    //   7348: astore 43
    //   7350: iload 22
    //   7352: istore 16
    //   7354: iload 6
    //   7356: istore 10
    //   7358: iload 5
    //   7360: istore 9
    //   7362: aload 39
    //   7364: astore 44
    //   7366: aload 39
    //   7368: astore 45
    //   7370: aload_0
    //   7371: getfield 347	com/whatsapp/data/ad:ad	Lcom/whatsapp/data/ci;
    //   7374: aload 39
    //   7376: aload_1
    //   7377: invokevirtual 1869	com/whatsapp/data/ci:a	(Landroid/database/sqlite/SQLiteDatabase;Lcom/whatsapp/protocol/j;)V
    //   7380: goto -1011 -> 6369
    //   7383: astore 39
    //   7385: iload_2
    //   7386: ifne +543 -> 7929
    //   7389: aload 42
    //   7391: astore 38
    //   7393: aload 39
    //   7395: invokestatic 1169	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   7398: aload 42
    //   7400: astore 38
    //   7402: aload_0
    //   7403: getfield 263	com/whatsapp/data/ad:J	Landroid/content/Context;
    //   7406: invokestatic 454	a/a/a/a/d:h	(Landroid/content/Context;)V
    //   7409: aload 42
    //   7411: astore 38
    //   7413: aload 39
    //   7415: athrow
    //   7416: astore 39
    //   7418: aload 38
    //   7420: ifnull +20 -> 7440
    //   7423: aload 38
    //   7425: invokevirtual 1163	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   7428: istore 5
    //   7430: iload 5
    //   7432: ifeq +8 -> 7440
    //   7435: aload 38
    //   7437: invokevirtual 1166	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   7440: aload 39
    //   7442: athrow
    //   7443: astore_1
    //   7444: aload_0
    //   7445: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   7448: invokevirtual 460	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   7451: aload_1
    //   7452: athrow
    //   7453: iconst_0
    //   7454: istore 5
    //   7456: goto -162 -> 7294
    //   7459: astore 38
    //   7461: aload 38
    //   7463: invokestatic 1169	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   7466: aload_0
    //   7467: new 1171	java/lang/AssertionError
    //   7470: dup
    //   7471: aload 38
    //   7473: invokespecial 1174	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   7476: invokevirtual 1176	com/whatsapp/data/ad:a	(Ljava/lang/Throwable;)V
    //   7479: iconst_0
    //   7480: istore_3
    //   7481: iconst_0
    //   7482: istore 5
    //   7484: iload 9
    //   7486: istore 6
    //   7488: goto -3735 -> 3753
    //   7491: astore 38
    //   7493: new 162	java/lang/StringBuilder
    //   7496: dup
    //   7497: ldc_w 1871
    //   7500: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   7503: iload_2
    //   7504: invokevirtual 1120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7507: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7510: aload 38
    //   7512: invokestatic 1629	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   7515: aload 38
    //   7517: instanceof 1770
    //   7520: ifne +25 -> 7545
    //   7523: aload 38
    //   7525: invokevirtual 1874	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   7528: ifnull +82 -> 7610
    //   7531: aload 38
    //   7533: invokevirtual 1874	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   7536: ldc_w 1876
    //   7539: invokevirtual 1878	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7542: ifeq +68 -> 7610
    //   7545: iload_2
    //   7546: ifeq +13 -> 7559
    //   7549: aload_0
    //   7550: getfield 303	com/whatsapp/data/ad:r	Lcom/whatsapp/data/q;
    //   7553: invokevirtual 1880	com/whatsapp/data/q:b	()Z
    //   7556: ifne +6 -> 7562
    //   7559: aload 38
    //   7561: athrow
    //   7562: aload_0
    //   7563: getfield 317	com/whatsapp/data/ad:v	Lcom/whatsapp/data/cj;
    //   7566: ldc_w 1882
    //   7569: iconst_0
    //   7570: invokevirtual 1885	com/whatsapp/data/cj:a	(Ljava/lang/String;I)V
    //   7573: aload_0
    //   7574: aload_1
    //   7575: iconst_0
    //   7576: invokespecial 1841	com/whatsapp/data/ad:g	(Lcom/whatsapp/protocol/j;I)Lcom/whatsapp/data/ad$a;
    //   7579: astore_1
    //   7580: aload_0
    //   7581: getfield 303	com/whatsapp/data/ad:r	Lcom/whatsapp/data/q;
    //   7584: invokevirtual 1886	com/whatsapp/data/q:c	()V
    //   7587: aload_0
    //   7588: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   7591: invokevirtual 460	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   7594: aload_1
    //   7595: areturn
    //   7596: astore_1
    //   7597: aload_0
    //   7598: getfield 317	com/whatsapp/data/ad:v	Lcom/whatsapp/data/cj;
    //   7601: ldc_w 1882
    //   7604: iconst_1
    //   7605: invokevirtual 1885	com/whatsapp/data/cj:a	(Ljava/lang/String;I)V
    //   7608: aload_1
    //   7609: athrow
    //   7610: aload 38
    //   7612: athrow
    //   7613: astore 38
    //   7615: aload 38
    //   7617: invokestatic 1169	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   7620: aload_0
    //   7621: new 1171	java/lang/AssertionError
    //   7624: dup
    //   7625: aload 38
    //   7627: invokespecial 1174	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   7630: invokevirtual 1176	com/whatsapp/data/ad:a	(Ljava/lang/Throwable;)V
    //   7633: iconst_0
    //   7634: istore_3
    //   7635: iconst_0
    //   7636: istore 5
    //   7638: iload 11
    //   7640: istore 6
    //   7642: goto -3889 -> 3753
    //   7645: astore 38
    //   7647: new 162	java/lang/StringBuilder
    //   7650: dup
    //   7651: ldc_w 1871
    //   7654: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   7657: iload_2
    //   7658: invokevirtual 1120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7661: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7664: aload 38
    //   7666: invokestatic 1629	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   7669: aload 38
    //   7671: instanceof 1770
    //   7674: ifne +25 -> 7699
    //   7677: aload 38
    //   7679: invokevirtual 1874	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   7682: ifnull +82 -> 7764
    //   7685: aload 38
    //   7687: invokevirtual 1874	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   7690: ldc_w 1876
    //   7693: invokevirtual 1878	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7696: ifeq +68 -> 7764
    //   7699: iload_2
    //   7700: ifeq +13 -> 7713
    //   7703: aload_0
    //   7704: getfield 303	com/whatsapp/data/ad:r	Lcom/whatsapp/data/q;
    //   7707: invokevirtual 1880	com/whatsapp/data/q:b	()Z
    //   7710: ifne +6 -> 7716
    //   7713: aload 38
    //   7715: athrow
    //   7716: aload_0
    //   7717: getfield 317	com/whatsapp/data/ad:v	Lcom/whatsapp/data/cj;
    //   7720: ldc_w 1882
    //   7723: iconst_0
    //   7724: invokevirtual 1885	com/whatsapp/data/cj:a	(Ljava/lang/String;I)V
    //   7727: aload_0
    //   7728: aload_1
    //   7729: iconst_0
    //   7730: invokespecial 1841	com/whatsapp/data/ad:g	(Lcom/whatsapp/protocol/j;I)Lcom/whatsapp/data/ad$a;
    //   7733: astore_1
    //   7734: aload_0
    //   7735: getfield 303	com/whatsapp/data/ad:r	Lcom/whatsapp/data/q;
    //   7738: invokevirtual 1886	com/whatsapp/data/q:c	()V
    //   7741: aload_0
    //   7742: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   7745: invokevirtual 460	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   7748: aload_1
    //   7749: areturn
    //   7750: astore_1
    //   7751: aload_0
    //   7752: getfield 317	com/whatsapp/data/ad:v	Lcom/whatsapp/data/cj;
    //   7755: ldc_w 1882
    //   7758: iconst_1
    //   7759: invokevirtual 1885	com/whatsapp/data/cj:a	(Ljava/lang/String;I)V
    //   7762: aload_1
    //   7763: athrow
    //   7764: aload 38
    //   7766: athrow
    //   7767: astore 38
    //   7769: aload 38
    //   7771: invokestatic 1169	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   7774: aload_0
    //   7775: new 1171	java/lang/AssertionError
    //   7778: dup
    //   7779: aload 38
    //   7781: invokespecial 1174	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   7784: invokevirtual 1176	com/whatsapp/data/ad:a	(Ljava/lang/Throwable;)V
    //   7787: iconst_1
    //   7788: istore 5
    //   7790: iconst_0
    //   7791: istore_3
    //   7792: iload 17
    //   7794: istore 6
    //   7796: iload 14
    //   7798: istore 7
    //   7800: iload 12
    //   7802: istore 8
    //   7804: goto -4051 -> 3753
    //   7807: astore 38
    //   7809: new 162	java/lang/StringBuilder
    //   7812: dup
    //   7813: ldc_w 1871
    //   7816: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   7819: iload_2
    //   7820: invokevirtual 1120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7823: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7826: aload 38
    //   7828: invokestatic 1629	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   7831: aload 38
    //   7833: instanceof 1770
    //   7836: ifne +25 -> 7861
    //   7839: aload 38
    //   7841: invokevirtual 1874	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   7844: ifnull +82 -> 7926
    //   7847: aload 38
    //   7849: invokevirtual 1874	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   7852: ldc_w 1876
    //   7855: invokevirtual 1878	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   7858: ifeq +68 -> 7926
    //   7861: iload_2
    //   7862: ifeq +13 -> 7875
    //   7865: aload_0
    //   7866: getfield 303	com/whatsapp/data/ad:r	Lcom/whatsapp/data/q;
    //   7869: invokevirtual 1880	com/whatsapp/data/q:b	()Z
    //   7872: ifne +6 -> 7878
    //   7875: aload 38
    //   7877: athrow
    //   7878: aload_0
    //   7879: getfield 317	com/whatsapp/data/ad:v	Lcom/whatsapp/data/cj;
    //   7882: ldc_w 1882
    //   7885: iconst_0
    //   7886: invokevirtual 1885	com/whatsapp/data/cj:a	(Ljava/lang/String;I)V
    //   7889: aload_0
    //   7890: aload_1
    //   7891: iconst_0
    //   7892: invokespecial 1841	com/whatsapp/data/ad:g	(Lcom/whatsapp/protocol/j;I)Lcom/whatsapp/data/ad$a;
    //   7895: astore_1
    //   7896: aload_0
    //   7897: getfield 303	com/whatsapp/data/ad:r	Lcom/whatsapp/data/q;
    //   7900: invokevirtual 1886	com/whatsapp/data/q:c	()V
    //   7903: aload_0
    //   7904: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   7907: invokevirtual 460	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   7910: aload_1
    //   7911: areturn
    //   7912: astore_1
    //   7913: aload_0
    //   7914: getfield 317	com/whatsapp/data/ad:v	Lcom/whatsapp/data/cj;
    //   7917: ldc_w 1882
    //   7920: iconst_1
    //   7921: invokevirtual 1885	com/whatsapp/data/cj:a	(Ljava/lang/String;I)V
    //   7924: aload_1
    //   7925: athrow
    //   7926: aload 38
    //   7928: athrow
    //   7929: aload 42
    //   7931: astore 38
    //   7933: new 162	java/lang/StringBuilder
    //   7936: dup
    //   7937: ldc_w 1888
    //   7940: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   7943: aload 39
    //   7945: invokevirtual 583	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7948: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7951: invokestatic 505	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   7954: iconst_1
    //   7955: istore_3
    //   7956: aload 42
    //   7958: ifnull +728 -> 8686
    //   7961: aload 42
    //   7963: invokevirtual 1163	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   7966: istore 5
    //   7968: iload 5
    //   7970: ifeq +716 -> 8686
    //   7973: aload 42
    //   7975: invokevirtual 1166	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   7978: iconst_0
    //   7979: istore 5
    //   7981: iload 18
    //   7983: istore 6
    //   7985: iload 15
    //   7987: istore 7
    //   7989: iload 13
    //   7991: istore 8
    //   7993: goto -4240 -> 3753
    //   7996: astore 38
    //   7998: aload 38
    //   8000: invokestatic 1169	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   8003: aload_0
    //   8004: new 1171	java/lang/AssertionError
    //   8007: dup
    //   8008: aload 38
    //   8010: invokespecial 1174	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   8013: invokevirtual 1176	com/whatsapp/data/ad:a	(Ljava/lang/Throwable;)V
    //   8016: iconst_0
    //   8017: istore 5
    //   8019: iload 18
    //   8021: istore 6
    //   8023: iload 15
    //   8025: istore 7
    //   8027: iload 13
    //   8029: istore 8
    //   8031: goto -4278 -> 3753
    //   8034: astore 38
    //   8036: new 162	java/lang/StringBuilder
    //   8039: dup
    //   8040: ldc_w 1871
    //   8043: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   8046: iload_2
    //   8047: invokevirtual 1120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8050: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8053: aload 38
    //   8055: invokestatic 1629	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   8058: aload 38
    //   8060: instanceof 1770
    //   8063: ifne +25 -> 8088
    //   8066: aload 38
    //   8068: invokevirtual 1874	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   8071: ifnull +82 -> 8153
    //   8074: aload 38
    //   8076: invokevirtual 1874	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   8079: ldc_w 1876
    //   8082: invokevirtual 1878	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8085: ifeq +68 -> 8153
    //   8088: iload_2
    //   8089: ifeq +13 -> 8102
    //   8092: aload_0
    //   8093: getfield 303	com/whatsapp/data/ad:r	Lcom/whatsapp/data/q;
    //   8096: invokevirtual 1880	com/whatsapp/data/q:b	()Z
    //   8099: ifne +6 -> 8105
    //   8102: aload 38
    //   8104: athrow
    //   8105: aload_0
    //   8106: getfield 317	com/whatsapp/data/ad:v	Lcom/whatsapp/data/cj;
    //   8109: ldc_w 1882
    //   8112: iconst_0
    //   8113: invokevirtual 1885	com/whatsapp/data/cj:a	(Ljava/lang/String;I)V
    //   8116: aload_0
    //   8117: aload_1
    //   8118: iconst_0
    //   8119: invokespecial 1841	com/whatsapp/data/ad:g	(Lcom/whatsapp/protocol/j;I)Lcom/whatsapp/data/ad$a;
    //   8122: astore_1
    //   8123: aload_0
    //   8124: getfield 303	com/whatsapp/data/ad:r	Lcom/whatsapp/data/q;
    //   8127: invokevirtual 1886	com/whatsapp/data/q:c	()V
    //   8130: aload_0
    //   8131: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   8134: invokevirtual 460	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   8137: aload_1
    //   8138: areturn
    //   8139: astore_1
    //   8140: aload_0
    //   8141: getfield 317	com/whatsapp/data/ad:v	Lcom/whatsapp/data/cj;
    //   8144: ldc_w 1882
    //   8147: iconst_1
    //   8148: invokevirtual 1885	com/whatsapp/data/cj:a	(Ljava/lang/String;I)V
    //   8151: aload_1
    //   8152: athrow
    //   8153: iload_2
    //   8154: ifne +6 -> 8160
    //   8157: aload 38
    //   8159: athrow
    //   8160: iconst_0
    //   8161: istore 5
    //   8163: iload 18
    //   8165: istore 6
    //   8167: iload 15
    //   8169: istore 7
    //   8171: iload 13
    //   8173: istore 8
    //   8175: goto -4422 -> 3753
    //   8178: astore 39
    //   8180: aload 43
    //   8182: astore 38
    //   8184: aload 39
    //   8186: invokestatic 1169	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   8189: aload 43
    //   8191: astore 38
    //   8193: aload_0
    //   8194: new 1171	java/lang/AssertionError
    //   8197: dup
    //   8198: aload 39
    //   8200: invokespecial 1174	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   8203: invokevirtual 1176	com/whatsapp/data/ad:a	(Ljava/lang/Throwable;)V
    //   8206: iload 16
    //   8208: istore 6
    //   8210: iload 10
    //   8212: istore 13
    //   8214: iload 9
    //   8216: istore 12
    //   8218: aload 43
    //   8220: ifnull +450 -> 8670
    //   8223: aload 43
    //   8225: invokevirtual 1163	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   8228: istore 5
    //   8230: iload 16
    //   8232: istore 6
    //   8234: iload 10
    //   8236: istore 13
    //   8238: iload 9
    //   8240: istore 12
    //   8242: iload 5
    //   8244: ifeq +426 -> 8670
    //   8247: aload 43
    //   8249: invokevirtual 1166	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   8252: iconst_0
    //   8253: istore_3
    //   8254: iconst_0
    //   8255: istore 5
    //   8257: iload 16
    //   8259: istore 6
    //   8261: iload 10
    //   8263: istore 7
    //   8265: iload 9
    //   8267: istore 8
    //   8269: goto -4516 -> 3753
    //   8272: astore 38
    //   8274: aload 38
    //   8276: invokestatic 1169	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   8279: aload_0
    //   8280: new 1171	java/lang/AssertionError
    //   8283: dup
    //   8284: aload 38
    //   8286: invokespecial 1174	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   8289: invokevirtual 1176	com/whatsapp/data/ad:a	(Ljava/lang/Throwable;)V
    //   8292: iconst_0
    //   8293: istore_3
    //   8294: iconst_0
    //   8295: istore 5
    //   8297: iload 16
    //   8299: istore 6
    //   8301: iload 10
    //   8303: istore 7
    //   8305: iload 9
    //   8307: istore 8
    //   8309: goto -4556 -> 3753
    //   8312: astore 38
    //   8314: new 162	java/lang/StringBuilder
    //   8317: dup
    //   8318: ldc_w 1871
    //   8321: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   8324: iload_2
    //   8325: invokevirtual 1120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8328: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8331: aload 38
    //   8333: invokestatic 1629	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   8336: aload 38
    //   8338: instanceof 1770
    //   8341: ifne +25 -> 8366
    //   8344: aload 38
    //   8346: invokevirtual 1874	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   8349: ifnull +82 -> 8431
    //   8352: aload 38
    //   8354: invokevirtual 1874	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   8357: ldc_w 1876
    //   8360: invokevirtual 1878	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8363: ifeq +68 -> 8431
    //   8366: iload_2
    //   8367: ifeq +13 -> 8380
    //   8370: aload_0
    //   8371: getfield 303	com/whatsapp/data/ad:r	Lcom/whatsapp/data/q;
    //   8374: invokevirtual 1880	com/whatsapp/data/q:b	()Z
    //   8377: ifne +6 -> 8383
    //   8380: aload 38
    //   8382: athrow
    //   8383: aload_0
    //   8384: getfield 317	com/whatsapp/data/ad:v	Lcom/whatsapp/data/cj;
    //   8387: ldc_w 1882
    //   8390: iconst_0
    //   8391: invokevirtual 1885	com/whatsapp/data/cj:a	(Ljava/lang/String;I)V
    //   8394: aload_0
    //   8395: aload_1
    //   8396: iconst_0
    //   8397: invokespecial 1841	com/whatsapp/data/ad:g	(Lcom/whatsapp/protocol/j;I)Lcom/whatsapp/data/ad$a;
    //   8400: astore_1
    //   8401: aload_0
    //   8402: getfield 303	com/whatsapp/data/ad:r	Lcom/whatsapp/data/q;
    //   8405: invokevirtual 1886	com/whatsapp/data/q:c	()V
    //   8408: aload_0
    //   8409: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   8412: invokevirtual 460	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   8415: aload_1
    //   8416: areturn
    //   8417: astore_1
    //   8418: aload_0
    //   8419: getfield 317	com/whatsapp/data/ad:v	Lcom/whatsapp/data/cj;
    //   8422: ldc_w 1882
    //   8425: iconst_1
    //   8426: invokevirtual 1885	com/whatsapp/data/cj:a	(Ljava/lang/String;I)V
    //   8429: aload_1
    //   8430: athrow
    //   8431: aload 38
    //   8433: athrow
    //   8434: astore 39
    //   8436: aload 44
    //   8438: astore 38
    //   8440: aload 39
    //   8442: invokestatic 1169	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   8445: aload 44
    //   8447: astore 38
    //   8449: aload 39
    //   8451: athrow
    //   8452: astore_1
    //   8453: aload_1
    //   8454: invokestatic 1169	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   8457: aload_0
    //   8458: new 1171	java/lang/AssertionError
    //   8461: dup
    //   8462: aload_1
    //   8463: invokespecial 1174	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   8466: invokevirtual 1176	com/whatsapp/data/ad:a	(Ljava/lang/Throwable;)V
    //   8469: goto -1029 -> 7440
    //   8472: astore 38
    //   8474: new 162	java/lang/StringBuilder
    //   8477: dup
    //   8478: ldc_w 1871
    //   8481: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   8484: iload_2
    //   8485: invokevirtual 1120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8488: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8491: aload 38
    //   8493: invokestatic 1629	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   8496: aload 38
    //   8498: instanceof 1770
    //   8501: ifne +25 -> 8526
    //   8504: aload 38
    //   8506: invokevirtual 1874	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   8509: ifnull +82 -> 8591
    //   8512: aload 38
    //   8514: invokevirtual 1874	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   8517: ldc_w 1876
    //   8520: invokevirtual 1878	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   8523: ifeq +68 -> 8591
    //   8526: iload_2
    //   8527: ifeq +13 -> 8540
    //   8530: aload_0
    //   8531: getfield 303	com/whatsapp/data/ad:r	Lcom/whatsapp/data/q;
    //   8534: invokevirtual 1880	com/whatsapp/data/q:b	()Z
    //   8537: ifne +6 -> 8543
    //   8540: aload 38
    //   8542: athrow
    //   8543: aload_0
    //   8544: getfield 317	com/whatsapp/data/ad:v	Lcom/whatsapp/data/cj;
    //   8547: ldc_w 1882
    //   8550: iconst_0
    //   8551: invokevirtual 1885	com/whatsapp/data/cj:a	(Ljava/lang/String;I)V
    //   8554: aload_0
    //   8555: aload_1
    //   8556: iconst_0
    //   8557: invokespecial 1841	com/whatsapp/data/ad:g	(Lcom/whatsapp/protocol/j;I)Lcom/whatsapp/data/ad$a;
    //   8560: astore_1
    //   8561: aload_0
    //   8562: getfield 303	com/whatsapp/data/ad:r	Lcom/whatsapp/data/q;
    //   8565: invokevirtual 1886	com/whatsapp/data/q:c	()V
    //   8568: aload_0
    //   8569: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   8572: invokevirtual 460	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   8575: aload_1
    //   8576: areturn
    //   8577: astore_1
    //   8578: aload_0
    //   8579: getfield 317	com/whatsapp/data/ad:v	Lcom/whatsapp/data/cj;
    //   8582: ldc_w 1882
    //   8585: iconst_1
    //   8586: invokevirtual 1885	com/whatsapp/data/cj:a	(Ljava/lang/String;I)V
    //   8589: aload_1
    //   8590: athrow
    //   8591: aload 38
    //   8593: athrow
    //   8594: aload_0
    //   8595: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   8598: invokevirtual 460	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   8601: aload_1
    //   8602: getfield 1890	com/whatsapp/protocol/j:R	Ljava/lang/Integer;
    //   8605: ifnull +34 -> 8639
    //   8608: aload_0
    //   8609: getfield 345	com/whatsapp/data/ad:ac	Lcom/whatsapp/data/m;
    //   8612: astore 39
    //   8614: aload 39
    //   8616: getfield 1893	com/whatsapp/data/m:a	Ljava/util/List;
    //   8619: astore 38
    //   8621: aload 38
    //   8623: monitorenter
    //   8624: aload 39
    //   8626: getfield 1893	com/whatsapp/data/m:a	Ljava/util/List;
    //   8629: aload_1
    //   8630: invokeinterface 1894 2 0
    //   8635: pop
    //   8636: aload 38
    //   8638: monitorexit
    //   8639: new 8	com/whatsapp/data/ad$a
    //   8642: dup
    //   8643: iload 6
    //   8645: iload 8
    //   8647: iload 7
    //   8649: iload 5
    //   8651: invokespecial 1782	com/whatsapp/data/ad$a:<init>	(ZZZZ)V
    //   8654: areturn
    //   8655: astore_1
    //   8656: aload 38
    //   8658: monitorexit
    //   8659: aload_1
    //   8660: athrow
    //   8661: astore 39
    //   8663: aload 45
    //   8665: astore 44
    //   8667: goto -231 -> 8436
    //   8670: iconst_0
    //   8671: istore_3
    //   8672: iconst_0
    //   8673: istore 5
    //   8675: iload 13
    //   8677: istore 7
    //   8679: iload 12
    //   8681: istore 8
    //   8683: goto -4930 -> 3753
    //   8686: iconst_0
    //   8687: istore 5
    //   8689: iload 18
    //   8691: istore 6
    //   8693: iload 15
    //   8695: istore 7
    //   8697: iload 13
    //   8699: istore 8
    //   8701: goto -4948 -> 3753
    //   8704: iconst_1
    //   8705: istore 5
    //   8707: iconst_0
    //   8708: istore_3
    //   8709: iload 17
    //   8711: istore 6
    //   8713: iload 14
    //   8715: istore 7
    //   8717: iload 12
    //   8719: istore 8
    //   8721: goto -4968 -> 3753
    //   8724: iload_3
    //   8725: iconst_1
    //   8726: iadd
    //   8727: istore_3
    //   8728: goto -6136 -> 2592
    //   8731: iconst_0
    //   8732: istore_3
    //   8733: goto -8321 -> 412
    //   8736: iconst_0
    //   8737: istore_3
    //   8738: goto -8233 -> 505
    //   8741: iload 28
    //   8743: istore 6
    //   8745: goto -2376 -> 6369
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	8748	0	this	ad
    //   0	8748	1	paramj	j
    //   0	8748	2	paramInt	int
    //   411	8327	3	i1	int
    //   496	3003	4	i2	int
    //   49	8657	5	bool1	boolean
    //   19	8725	6	bool2	boolean
    //   388	8328	7	bool3	boolean
    //   530	8190	8	bool4	boolean
    //   566	7740	9	bool5	boolean
    //   562	7740	10	bool6	boolean
    //   522	7117	11	bool7	boolean
    //   542	8176	12	bool8	boolean
    //   554	8144	13	bool9	boolean
    //   538	8176	14	bool10	boolean
    //   550	8144	15	bool11	boolean
    //   558	7740	16	bool12	boolean
    //   534	8176	17	bool13	boolean
    //   546	8144	18	bool14	boolean
    //   61	7238	19	bool15	boolean
    //   52	7263	20	bool16	boolean
    //   55	7276	21	bool17	boolean
    //   58	7293	22	bool18	boolean
    //   16	7197	23	bool19	boolean
    //   7	7222	24	bool20	boolean
    //   10	7235	25	bool21	boolean
    //   13	7252	26	bool22	boolean
    //   37	7002	27	bool23	boolean
    //   22	8720	28	bool24	boolean
    //   25	7030	29	bool25	boolean
    //   31	7040	30	bool26	boolean
    //   34	7057	31	bool27	boolean
    //   4	4465	32	bool28	boolean
    //   28	6947	33	bool29	boolean
    //   1	4295	34	bool30	boolean
    //   1099	89	35	bool31	boolean
    //   739	5522	36	l1	long
    //   161	7275	38	localObject1	Object
    //   7459	13	38	localSQLiteDatabaseCorruptException1	SQLiteDatabaseCorruptException
    //   7491	120	38	localSQLiteException1	android.database.sqlite.SQLiteException
    //   7613	13	38	localSQLiteDatabaseCorruptException2	SQLiteDatabaseCorruptException
    //   7645	120	38	localSQLiteException2	android.database.sqlite.SQLiteException
    //   7767	13	38	localSQLiteDatabaseCorruptException3	SQLiteDatabaseCorruptException
    //   7807	120	38	localSQLiteException3	android.database.sqlite.SQLiteException
    //   7931	1	38	localObject2	Object
    //   7996	13	38	localSQLiteDatabaseCorruptException4	SQLiteDatabaseCorruptException
    //   8034	124	38	localSQLiteException4	android.database.sqlite.SQLiteException
    //   8182	10	38	localObject3	Object
    //   8272	13	38	localSQLiteDatabaseCorruptException5	SQLiteDatabaseCorruptException
    //   8312	120	38	localSQLiteException5	android.database.sqlite.SQLiteException
    //   8438	10	38	localObject4	Object
    //   8472	120	38	localSQLiteException6	android.database.sqlite.SQLiteException
    //   480	3191	39	localObject5	Object
    //   3687	2923	39	localIOException	IOException
    //   6665	710	39	localSQLiteConstraintException	SQLiteConstraintException
    //   7383	31	39	localSQLiteDiskIOException	SQLiteDiskIOException
    //   7416	528	39	localObject6	Object
    //   8178	21	39	localSQLiteDatabaseCorruptException6	SQLiteDatabaseCorruptException
    //   8434	16	39	localRuntimeException	RuntimeException
    //   8612	13	39	localm	m
    //   8661	1	39	localError	Error
    //   381	6916	40	localObject7	Object
    //   363	6950	41	localObject8	Object
    //   366	7608	42	localObject9	Object
    //   372	7876	43	localObject10	Object
    //   375	8291	44	localObject11	Object
    //   378	8286	45	localObject12	Object
    //   1272	5924	46	localObject13	Object
    //   46	7238	47	str	String
    //   1355	4891	48	localObject14	Object
    //   2688	3668	49	localObject15	Object
    //   4874	1199	50	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   568	577	3687	java/io/IOException
    //   653	660	3687	java/io/IOException
    //   736	741	3687	java/io/IOException
    //   817	822	3687	java/io/IOException
    //   898	906	3687	java/io/IOException
    //   991	1016	3687	java/io/IOException
    //   1092	1101	3687	java/io/IOException
    //   1177	1187	3687	java/io/IOException
    //   1268	1274	3687	java/io/IOException
    //   1350	1357	3687	java/io/IOException
    //   1433	1448	3687	java/io/IOException
    //   1527	1535	3687	java/io/IOException
    //   1617	1634	3687	java/io/IOException
    //   1715	1734	3687	java/io/IOException
    //   1810	1823	3687	java/io/IOException
    //   1899	1909	3687	java/io/IOException
    //   1985	1998	3687	java/io/IOException
    //   2074	2084	3687	java/io/IOException
    //   2160	2167	3687	java/io/IOException
    //   2243	2251	3687	java/io/IOException
    //   2327	2332	3687	java/io/IOException
    //   2408	2421	3687	java/io/IOException
    //   2497	2509	3687	java/io/IOException
    //   2585	2590	3687	java/io/IOException
    //   2680	2690	3687	java/io/IOException
    //   2766	2778	3687	java/io/IOException
    //   2854	2876	3687	java/io/IOException
    //   2952	2958	3687	java/io/IOException
    //   3034	3049	3687	java/io/IOException
    //   3125	3133	3687	java/io/IOException
    //   3215	3228	3687	java/io/IOException
    //   3307	3320	3687	java/io/IOException
    //   3396	3408	3687	java/io/IOException
    //   3487	3503	3687	java/io/IOException
    //   3579	3598	3687	java/io/IOException
    //   3674	3684	3687	java/io/IOException
    //   3869	3876	3687	java/io/IOException
    //   3952	3962	3687	java/io/IOException
    //   4038	4045	3687	java/io/IOException
    //   4121	4126	3687	java/io/IOException
    //   4202	4213	3687	java/io/IOException
    //   4289	4295	3687	java/io/IOException
    //   4441	4448	3687	java/io/IOException
    //   4532	4541	3687	java/io/IOException
    //   4617	4623	3687	java/io/IOException
    //   4699	4705	3687	java/io/IOException
    //   4781	4790	3687	java/io/IOException
    //   4866	4876	3687	java/io/IOException
    //   4957	4972	3687	java/io/IOException
    //   5048	5065	3687	java/io/IOException
    //   5141	5158	3687	java/io/IOException
    //   5234	5249	3687	java/io/IOException
    //   5328	5343	3687	java/io/IOException
    //   5419	5435	3687	java/io/IOException
    //   5511	5527	3687	java/io/IOException
    //   5603	5619	3687	java/io/IOException
    //   5695	5711	3687	java/io/IOException
    //   5787	5803	3687	java/io/IOException
    //   5879	5904	3687	java/io/IOException
    //   5980	5990	3687	java/io/IOException
    //   6066	6079	3687	java/io/IOException
    //   6155	6169	3687	java/io/IOException
    //   6245	6260	3687	java/io/IOException
    //   6345	6366	3687	java/io/IOException
    //   6445	6450	3687	java/io/IOException
    //   6526	6538	3687	java/io/IOException
    //   6613	6650	3687	java/io/IOException
    //   6826	6834	3687	java/io/IOException
    //   6916	6933	3687	java/io/IOException
    //   7022	7030	3687	java/io/IOException
    //   7106	7112	3687	java/io/IOException
    //   7188	7195	3687	java/io/IOException
    //   7276	7291	3687	java/io/IOException
    //   7370	7380	3687	java/io/IOException
    //   568	577	6665	android/database/sqlite/SQLiteConstraintException
    //   653	660	6665	android/database/sqlite/SQLiteConstraintException
    //   736	741	6665	android/database/sqlite/SQLiteConstraintException
    //   817	822	6665	android/database/sqlite/SQLiteConstraintException
    //   898	906	6665	android/database/sqlite/SQLiteConstraintException
    //   991	1016	6665	android/database/sqlite/SQLiteConstraintException
    //   1092	1101	6665	android/database/sqlite/SQLiteConstraintException
    //   1177	1187	6665	android/database/sqlite/SQLiteConstraintException
    //   1268	1274	6665	android/database/sqlite/SQLiteConstraintException
    //   1350	1357	6665	android/database/sqlite/SQLiteConstraintException
    //   1433	1448	6665	android/database/sqlite/SQLiteConstraintException
    //   1527	1535	6665	android/database/sqlite/SQLiteConstraintException
    //   1617	1634	6665	android/database/sqlite/SQLiteConstraintException
    //   1715	1734	6665	android/database/sqlite/SQLiteConstraintException
    //   1810	1823	6665	android/database/sqlite/SQLiteConstraintException
    //   1899	1909	6665	android/database/sqlite/SQLiteConstraintException
    //   1985	1998	6665	android/database/sqlite/SQLiteConstraintException
    //   2074	2084	6665	android/database/sqlite/SQLiteConstraintException
    //   2160	2167	6665	android/database/sqlite/SQLiteConstraintException
    //   2243	2251	6665	android/database/sqlite/SQLiteConstraintException
    //   2327	2332	6665	android/database/sqlite/SQLiteConstraintException
    //   2408	2421	6665	android/database/sqlite/SQLiteConstraintException
    //   2497	2509	6665	android/database/sqlite/SQLiteConstraintException
    //   2585	2590	6665	android/database/sqlite/SQLiteConstraintException
    //   2680	2690	6665	android/database/sqlite/SQLiteConstraintException
    //   2766	2778	6665	android/database/sqlite/SQLiteConstraintException
    //   2854	2876	6665	android/database/sqlite/SQLiteConstraintException
    //   2952	2958	6665	android/database/sqlite/SQLiteConstraintException
    //   3034	3049	6665	android/database/sqlite/SQLiteConstraintException
    //   3125	3133	6665	android/database/sqlite/SQLiteConstraintException
    //   3215	3228	6665	android/database/sqlite/SQLiteConstraintException
    //   3307	3320	6665	android/database/sqlite/SQLiteConstraintException
    //   3396	3408	6665	android/database/sqlite/SQLiteConstraintException
    //   3487	3503	6665	android/database/sqlite/SQLiteConstraintException
    //   3579	3598	6665	android/database/sqlite/SQLiteConstraintException
    //   3674	3684	6665	android/database/sqlite/SQLiteConstraintException
    //   3869	3876	6665	android/database/sqlite/SQLiteConstraintException
    //   3952	3962	6665	android/database/sqlite/SQLiteConstraintException
    //   4038	4045	6665	android/database/sqlite/SQLiteConstraintException
    //   4121	4126	6665	android/database/sqlite/SQLiteConstraintException
    //   4202	4213	6665	android/database/sqlite/SQLiteConstraintException
    //   4289	4295	6665	android/database/sqlite/SQLiteConstraintException
    //   4441	4448	6665	android/database/sqlite/SQLiteConstraintException
    //   4532	4541	6665	android/database/sqlite/SQLiteConstraintException
    //   4617	4623	6665	android/database/sqlite/SQLiteConstraintException
    //   4699	4705	6665	android/database/sqlite/SQLiteConstraintException
    //   4781	4790	6665	android/database/sqlite/SQLiteConstraintException
    //   4866	4876	6665	android/database/sqlite/SQLiteConstraintException
    //   4957	4972	6665	android/database/sqlite/SQLiteConstraintException
    //   5048	5065	6665	android/database/sqlite/SQLiteConstraintException
    //   5141	5158	6665	android/database/sqlite/SQLiteConstraintException
    //   5234	5249	6665	android/database/sqlite/SQLiteConstraintException
    //   5328	5343	6665	android/database/sqlite/SQLiteConstraintException
    //   5419	5435	6665	android/database/sqlite/SQLiteConstraintException
    //   5511	5527	6665	android/database/sqlite/SQLiteConstraintException
    //   5603	5619	6665	android/database/sqlite/SQLiteConstraintException
    //   5695	5711	6665	android/database/sqlite/SQLiteConstraintException
    //   5787	5803	6665	android/database/sqlite/SQLiteConstraintException
    //   5879	5904	6665	android/database/sqlite/SQLiteConstraintException
    //   5980	5990	6665	android/database/sqlite/SQLiteConstraintException
    //   6066	6079	6665	android/database/sqlite/SQLiteConstraintException
    //   6155	6169	6665	android/database/sqlite/SQLiteConstraintException
    //   6245	6260	6665	android/database/sqlite/SQLiteConstraintException
    //   6345	6366	6665	android/database/sqlite/SQLiteConstraintException
    //   6445	6450	6665	android/database/sqlite/SQLiteConstraintException
    //   6526	6538	6665	android/database/sqlite/SQLiteConstraintException
    //   6613	6650	6665	android/database/sqlite/SQLiteConstraintException
    //   6826	6834	6665	android/database/sqlite/SQLiteConstraintException
    //   6916	6933	6665	android/database/sqlite/SQLiteConstraintException
    //   7022	7030	6665	android/database/sqlite/SQLiteConstraintException
    //   7106	7112	6665	android/database/sqlite/SQLiteConstraintException
    //   7188	7195	6665	android/database/sqlite/SQLiteConstraintException
    //   7276	7291	6665	android/database/sqlite/SQLiteConstraintException
    //   7370	7380	6665	android/database/sqlite/SQLiteConstraintException
    //   568	577	7383	android/database/sqlite/SQLiteDiskIOException
    //   653	660	7383	android/database/sqlite/SQLiteDiskIOException
    //   736	741	7383	android/database/sqlite/SQLiteDiskIOException
    //   817	822	7383	android/database/sqlite/SQLiteDiskIOException
    //   898	906	7383	android/database/sqlite/SQLiteDiskIOException
    //   991	1016	7383	android/database/sqlite/SQLiteDiskIOException
    //   1092	1101	7383	android/database/sqlite/SQLiteDiskIOException
    //   1177	1187	7383	android/database/sqlite/SQLiteDiskIOException
    //   1268	1274	7383	android/database/sqlite/SQLiteDiskIOException
    //   1350	1357	7383	android/database/sqlite/SQLiteDiskIOException
    //   1433	1448	7383	android/database/sqlite/SQLiteDiskIOException
    //   1527	1535	7383	android/database/sqlite/SQLiteDiskIOException
    //   1617	1634	7383	android/database/sqlite/SQLiteDiskIOException
    //   1715	1734	7383	android/database/sqlite/SQLiteDiskIOException
    //   1810	1823	7383	android/database/sqlite/SQLiteDiskIOException
    //   1899	1909	7383	android/database/sqlite/SQLiteDiskIOException
    //   1985	1998	7383	android/database/sqlite/SQLiteDiskIOException
    //   2074	2084	7383	android/database/sqlite/SQLiteDiskIOException
    //   2160	2167	7383	android/database/sqlite/SQLiteDiskIOException
    //   2243	2251	7383	android/database/sqlite/SQLiteDiskIOException
    //   2327	2332	7383	android/database/sqlite/SQLiteDiskIOException
    //   2408	2421	7383	android/database/sqlite/SQLiteDiskIOException
    //   2497	2509	7383	android/database/sqlite/SQLiteDiskIOException
    //   2585	2590	7383	android/database/sqlite/SQLiteDiskIOException
    //   2680	2690	7383	android/database/sqlite/SQLiteDiskIOException
    //   2766	2778	7383	android/database/sqlite/SQLiteDiskIOException
    //   2854	2876	7383	android/database/sqlite/SQLiteDiskIOException
    //   2952	2958	7383	android/database/sqlite/SQLiteDiskIOException
    //   3034	3049	7383	android/database/sqlite/SQLiteDiskIOException
    //   3125	3133	7383	android/database/sqlite/SQLiteDiskIOException
    //   3215	3228	7383	android/database/sqlite/SQLiteDiskIOException
    //   3307	3320	7383	android/database/sqlite/SQLiteDiskIOException
    //   3396	3408	7383	android/database/sqlite/SQLiteDiskIOException
    //   3487	3503	7383	android/database/sqlite/SQLiteDiskIOException
    //   3579	3598	7383	android/database/sqlite/SQLiteDiskIOException
    //   3674	3684	7383	android/database/sqlite/SQLiteDiskIOException
    //   3869	3876	7383	android/database/sqlite/SQLiteDiskIOException
    //   3952	3962	7383	android/database/sqlite/SQLiteDiskIOException
    //   4038	4045	7383	android/database/sqlite/SQLiteDiskIOException
    //   4121	4126	7383	android/database/sqlite/SQLiteDiskIOException
    //   4202	4213	7383	android/database/sqlite/SQLiteDiskIOException
    //   4289	4295	7383	android/database/sqlite/SQLiteDiskIOException
    //   4441	4448	7383	android/database/sqlite/SQLiteDiskIOException
    //   4532	4541	7383	android/database/sqlite/SQLiteDiskIOException
    //   4617	4623	7383	android/database/sqlite/SQLiteDiskIOException
    //   4699	4705	7383	android/database/sqlite/SQLiteDiskIOException
    //   4781	4790	7383	android/database/sqlite/SQLiteDiskIOException
    //   4866	4876	7383	android/database/sqlite/SQLiteDiskIOException
    //   4957	4972	7383	android/database/sqlite/SQLiteDiskIOException
    //   5048	5065	7383	android/database/sqlite/SQLiteDiskIOException
    //   5141	5158	7383	android/database/sqlite/SQLiteDiskIOException
    //   5234	5249	7383	android/database/sqlite/SQLiteDiskIOException
    //   5328	5343	7383	android/database/sqlite/SQLiteDiskIOException
    //   5419	5435	7383	android/database/sqlite/SQLiteDiskIOException
    //   5511	5527	7383	android/database/sqlite/SQLiteDiskIOException
    //   5603	5619	7383	android/database/sqlite/SQLiteDiskIOException
    //   5695	5711	7383	android/database/sqlite/SQLiteDiskIOException
    //   5787	5803	7383	android/database/sqlite/SQLiteDiskIOException
    //   5879	5904	7383	android/database/sqlite/SQLiteDiskIOException
    //   5980	5990	7383	android/database/sqlite/SQLiteDiskIOException
    //   6066	6079	7383	android/database/sqlite/SQLiteDiskIOException
    //   6155	6169	7383	android/database/sqlite/SQLiteDiskIOException
    //   6245	6260	7383	android/database/sqlite/SQLiteDiskIOException
    //   6345	6366	7383	android/database/sqlite/SQLiteDiskIOException
    //   6445	6450	7383	android/database/sqlite/SQLiteDiskIOException
    //   6526	6538	7383	android/database/sqlite/SQLiteDiskIOException
    //   6613	6650	7383	android/database/sqlite/SQLiteDiskIOException
    //   6826	6834	7383	android/database/sqlite/SQLiteDiskIOException
    //   6916	6933	7383	android/database/sqlite/SQLiteDiskIOException
    //   7022	7030	7383	android/database/sqlite/SQLiteDiskIOException
    //   7106	7112	7383	android/database/sqlite/SQLiteDiskIOException
    //   7188	7195	7383	android/database/sqlite/SQLiteDiskIOException
    //   7276	7291	7383	android/database/sqlite/SQLiteDiskIOException
    //   7370	7380	7383	android/database/sqlite/SQLiteDiskIOException
    //   568	577	7416	finally
    //   653	660	7416	finally
    //   736	741	7416	finally
    //   817	822	7416	finally
    //   898	906	7416	finally
    //   991	1016	7416	finally
    //   1092	1101	7416	finally
    //   1177	1187	7416	finally
    //   1268	1274	7416	finally
    //   1350	1357	7416	finally
    //   1433	1448	7416	finally
    //   1527	1535	7416	finally
    //   1617	1634	7416	finally
    //   1715	1734	7416	finally
    //   1810	1823	7416	finally
    //   1899	1909	7416	finally
    //   1985	1998	7416	finally
    //   2074	2084	7416	finally
    //   2160	2167	7416	finally
    //   2243	2251	7416	finally
    //   2327	2332	7416	finally
    //   2408	2421	7416	finally
    //   2497	2509	7416	finally
    //   2585	2590	7416	finally
    //   2680	2690	7416	finally
    //   2766	2778	7416	finally
    //   2854	2876	7416	finally
    //   2952	2958	7416	finally
    //   3034	3049	7416	finally
    //   3125	3133	7416	finally
    //   3215	3228	7416	finally
    //   3307	3320	7416	finally
    //   3396	3408	7416	finally
    //   3487	3503	7416	finally
    //   3579	3598	7416	finally
    //   3674	3684	7416	finally
    //   3693	3698	7416	finally
    //   3869	3876	7416	finally
    //   3952	3962	7416	finally
    //   4038	4045	7416	finally
    //   4121	4126	7416	finally
    //   4202	4213	7416	finally
    //   4289	4295	7416	finally
    //   4441	4448	7416	finally
    //   4532	4541	7416	finally
    //   4617	4623	7416	finally
    //   4699	4705	7416	finally
    //   4781	4790	7416	finally
    //   4866	4876	7416	finally
    //   4957	4972	7416	finally
    //   5048	5065	7416	finally
    //   5141	5158	7416	finally
    //   5234	5249	7416	finally
    //   5328	5343	7416	finally
    //   5419	5435	7416	finally
    //   5511	5527	7416	finally
    //   5603	5619	7416	finally
    //   5695	5711	7416	finally
    //   5787	5803	7416	finally
    //   5879	5904	7416	finally
    //   5980	5990	7416	finally
    //   6066	6079	7416	finally
    //   6155	6169	7416	finally
    //   6245	6260	7416	finally
    //   6345	6366	7416	finally
    //   6445	6450	7416	finally
    //   6526	6538	7416	finally
    //   6613	6650	7416	finally
    //   6671	6708	7416	finally
    //   6826	6834	7416	finally
    //   6916	6933	7416	finally
    //   7022	7030	7416	finally
    //   7106	7112	7416	finally
    //   7188	7195	7416	finally
    //   7276	7291	7416	finally
    //   7370	7380	7416	finally
    //   7393	7398	7416	finally
    //   7402	7409	7416	finally
    //   7413	7416	7416	finally
    //   7933	7954	7416	finally
    //   8184	8189	7416	finally
    //   8193	8206	7416	finally
    //   8440	8445	7416	finally
    //   8449	8452	7416	finally
    //   3715	3722	7443	finally
    //   3739	3744	7443	finally
    //   3761	3784	7443	finally
    //   4324	4331	7443	finally
    //   4348	4353	7443	finally
    //   6713	6720	7443	finally
    //   6725	6730	7443	finally
    //   7423	7430	7443	finally
    //   7435	7440	7443	finally
    //   7440	7443	7443	finally
    //   7461	7479	7443	finally
    //   7493	7545	7443	finally
    //   7549	7559	7443	finally
    //   7559	7562	7443	finally
    //   7562	7573	7443	finally
    //   7573	7587	7443	finally
    //   7597	7610	7443	finally
    //   7610	7613	7443	finally
    //   7615	7633	7443	finally
    //   7647	7699	7443	finally
    //   7703	7713	7443	finally
    //   7713	7716	7443	finally
    //   7716	7727	7443	finally
    //   7727	7741	7443	finally
    //   7751	7764	7443	finally
    //   7764	7767	7443	finally
    //   7769	7787	7443	finally
    //   7809	7861	7443	finally
    //   7865	7875	7443	finally
    //   7875	7878	7443	finally
    //   7878	7889	7443	finally
    //   7889	7903	7443	finally
    //   7913	7926	7443	finally
    //   7926	7929	7443	finally
    //   7961	7968	7443	finally
    //   7973	7978	7443	finally
    //   7998	8016	7443	finally
    //   8036	8088	7443	finally
    //   8092	8102	7443	finally
    //   8102	8105	7443	finally
    //   8105	8116	7443	finally
    //   8116	8130	7443	finally
    //   8140	8153	7443	finally
    //   8157	8160	7443	finally
    //   8223	8230	7443	finally
    //   8247	8252	7443	finally
    //   8274	8292	7443	finally
    //   8314	8366	7443	finally
    //   8370	8380	7443	finally
    //   8380	8383	7443	finally
    //   8383	8394	7443	finally
    //   8394	8408	7443	finally
    //   8418	8431	7443	finally
    //   8431	8434	7443	finally
    //   8453	8469	7443	finally
    //   8474	8526	7443	finally
    //   8530	8540	7443	finally
    //   8540	8543	7443	finally
    //   8543	8554	7443	finally
    //   8554	8568	7443	finally
    //   8578	8591	7443	finally
    //   8591	8594	7443	finally
    //   4348	4353	7459	android/database/sqlite/SQLiteDatabaseCorruptException
    //   4348	4353	7491	android/database/sqlite/SQLiteException
    //   7573	7587	7596	java/lang/Exception
    //   3739	3744	7613	android/database/sqlite/SQLiteDatabaseCorruptException
    //   3739	3744	7645	android/database/sqlite/SQLiteException
    //   7727	7741	7750	java/lang/Exception
    //   6725	6730	7767	android/database/sqlite/SQLiteDatabaseCorruptException
    //   6725	6730	7807	android/database/sqlite/SQLiteException
    //   7889	7903	7912	java/lang/Exception
    //   7973	7978	7996	android/database/sqlite/SQLiteDatabaseCorruptException
    //   7973	7978	8034	android/database/sqlite/SQLiteException
    //   8116	8130	8139	java/lang/Exception
    //   568	577	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   653	660	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   736	741	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   817	822	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   898	906	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   991	1016	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   1092	1101	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   1177	1187	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   1268	1274	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   1350	1357	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   1433	1448	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   1527	1535	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   1617	1634	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   1715	1734	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   1810	1823	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   1899	1909	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   1985	1998	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   2074	2084	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   2160	2167	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   2243	2251	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   2327	2332	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   2408	2421	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   2497	2509	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   2585	2590	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   2680	2690	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   2766	2778	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   2854	2876	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   2952	2958	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   3034	3049	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   3125	3133	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   3215	3228	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   3307	3320	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   3396	3408	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   3487	3503	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   3579	3598	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   3674	3684	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   3869	3876	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   3952	3962	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   4038	4045	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   4121	4126	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   4202	4213	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   4289	4295	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   4441	4448	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   4532	4541	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   4617	4623	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   4699	4705	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   4781	4790	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   4866	4876	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   4957	4972	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   5048	5065	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   5141	5158	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   5234	5249	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   5328	5343	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   5419	5435	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   5511	5527	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   5603	5619	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   5695	5711	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   5787	5803	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   5879	5904	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   5980	5990	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   6066	6079	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   6155	6169	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   6245	6260	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   6345	6366	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   6445	6450	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   6526	6538	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   6613	6650	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   6826	6834	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   6916	6933	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   7022	7030	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   7106	7112	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   7188	7195	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   7276	7291	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   7370	7380	8178	android/database/sqlite/SQLiteDatabaseCorruptException
    //   8247	8252	8272	android/database/sqlite/SQLiteDatabaseCorruptException
    //   8247	8252	8312	android/database/sqlite/SQLiteException
    //   8394	8408	8417	java/lang/Exception
    //   568	577	8434	java/lang/RuntimeException
    //   653	660	8434	java/lang/RuntimeException
    //   736	741	8434	java/lang/RuntimeException
    //   817	822	8434	java/lang/RuntimeException
    //   898	906	8434	java/lang/RuntimeException
    //   991	1016	8434	java/lang/RuntimeException
    //   1092	1101	8434	java/lang/RuntimeException
    //   1177	1187	8434	java/lang/RuntimeException
    //   1268	1274	8434	java/lang/RuntimeException
    //   1350	1357	8434	java/lang/RuntimeException
    //   1433	1448	8434	java/lang/RuntimeException
    //   1527	1535	8434	java/lang/RuntimeException
    //   1617	1634	8434	java/lang/RuntimeException
    //   1715	1734	8434	java/lang/RuntimeException
    //   1810	1823	8434	java/lang/RuntimeException
    //   1899	1909	8434	java/lang/RuntimeException
    //   1985	1998	8434	java/lang/RuntimeException
    //   2074	2084	8434	java/lang/RuntimeException
    //   2160	2167	8434	java/lang/RuntimeException
    //   2243	2251	8434	java/lang/RuntimeException
    //   2327	2332	8434	java/lang/RuntimeException
    //   2408	2421	8434	java/lang/RuntimeException
    //   2497	2509	8434	java/lang/RuntimeException
    //   2585	2590	8434	java/lang/RuntimeException
    //   2680	2690	8434	java/lang/RuntimeException
    //   2766	2778	8434	java/lang/RuntimeException
    //   2854	2876	8434	java/lang/RuntimeException
    //   2952	2958	8434	java/lang/RuntimeException
    //   3034	3049	8434	java/lang/RuntimeException
    //   3125	3133	8434	java/lang/RuntimeException
    //   3215	3228	8434	java/lang/RuntimeException
    //   3307	3320	8434	java/lang/RuntimeException
    //   3396	3408	8434	java/lang/RuntimeException
    //   3487	3503	8434	java/lang/RuntimeException
    //   3579	3598	8434	java/lang/RuntimeException
    //   3674	3684	8434	java/lang/RuntimeException
    //   3869	3876	8434	java/lang/RuntimeException
    //   3952	3962	8434	java/lang/RuntimeException
    //   4038	4045	8434	java/lang/RuntimeException
    //   4121	4126	8434	java/lang/RuntimeException
    //   4202	4213	8434	java/lang/RuntimeException
    //   4289	4295	8434	java/lang/RuntimeException
    //   4441	4448	8434	java/lang/RuntimeException
    //   4532	4541	8434	java/lang/RuntimeException
    //   4617	4623	8434	java/lang/RuntimeException
    //   4699	4705	8434	java/lang/RuntimeException
    //   4781	4790	8434	java/lang/RuntimeException
    //   4866	4876	8434	java/lang/RuntimeException
    //   4957	4972	8434	java/lang/RuntimeException
    //   5048	5065	8434	java/lang/RuntimeException
    //   5141	5158	8434	java/lang/RuntimeException
    //   5234	5249	8434	java/lang/RuntimeException
    //   5328	5343	8434	java/lang/RuntimeException
    //   5419	5435	8434	java/lang/RuntimeException
    //   5511	5527	8434	java/lang/RuntimeException
    //   5603	5619	8434	java/lang/RuntimeException
    //   5695	5711	8434	java/lang/RuntimeException
    //   5787	5803	8434	java/lang/RuntimeException
    //   5879	5904	8434	java/lang/RuntimeException
    //   5980	5990	8434	java/lang/RuntimeException
    //   6066	6079	8434	java/lang/RuntimeException
    //   6155	6169	8434	java/lang/RuntimeException
    //   6245	6260	8434	java/lang/RuntimeException
    //   6345	6366	8434	java/lang/RuntimeException
    //   6445	6450	8434	java/lang/RuntimeException
    //   6526	6538	8434	java/lang/RuntimeException
    //   6613	6650	8434	java/lang/RuntimeException
    //   6826	6834	8434	java/lang/RuntimeException
    //   6916	6933	8434	java/lang/RuntimeException
    //   7022	7030	8434	java/lang/RuntimeException
    //   7106	7112	8434	java/lang/RuntimeException
    //   7188	7195	8434	java/lang/RuntimeException
    //   7276	7291	8434	java/lang/RuntimeException
    //   7370	7380	8434	java/lang/RuntimeException
    //   7435	7440	8452	android/database/sqlite/SQLiteDatabaseCorruptException
    //   7435	7440	8472	android/database/sqlite/SQLiteException
    //   8554	8568	8577	java/lang/Exception
    //   8624	8639	8655	finally
    //   8656	8659	8655	finally
    //   568	577	8661	java/lang/Error
    //   653	660	8661	java/lang/Error
    //   736	741	8661	java/lang/Error
    //   817	822	8661	java/lang/Error
    //   898	906	8661	java/lang/Error
    //   991	1016	8661	java/lang/Error
    //   1092	1101	8661	java/lang/Error
    //   1177	1187	8661	java/lang/Error
    //   1268	1274	8661	java/lang/Error
    //   1350	1357	8661	java/lang/Error
    //   1433	1448	8661	java/lang/Error
    //   1527	1535	8661	java/lang/Error
    //   1617	1634	8661	java/lang/Error
    //   1715	1734	8661	java/lang/Error
    //   1810	1823	8661	java/lang/Error
    //   1899	1909	8661	java/lang/Error
    //   1985	1998	8661	java/lang/Error
    //   2074	2084	8661	java/lang/Error
    //   2160	2167	8661	java/lang/Error
    //   2243	2251	8661	java/lang/Error
    //   2327	2332	8661	java/lang/Error
    //   2408	2421	8661	java/lang/Error
    //   2497	2509	8661	java/lang/Error
    //   2585	2590	8661	java/lang/Error
    //   2680	2690	8661	java/lang/Error
    //   2766	2778	8661	java/lang/Error
    //   2854	2876	8661	java/lang/Error
    //   2952	2958	8661	java/lang/Error
    //   3034	3049	8661	java/lang/Error
    //   3125	3133	8661	java/lang/Error
    //   3215	3228	8661	java/lang/Error
    //   3307	3320	8661	java/lang/Error
    //   3396	3408	8661	java/lang/Error
    //   3487	3503	8661	java/lang/Error
    //   3579	3598	8661	java/lang/Error
    //   3674	3684	8661	java/lang/Error
    //   3869	3876	8661	java/lang/Error
    //   3952	3962	8661	java/lang/Error
    //   4038	4045	8661	java/lang/Error
    //   4121	4126	8661	java/lang/Error
    //   4202	4213	8661	java/lang/Error
    //   4289	4295	8661	java/lang/Error
    //   4441	4448	8661	java/lang/Error
    //   4532	4541	8661	java/lang/Error
    //   4617	4623	8661	java/lang/Error
    //   4699	4705	8661	java/lang/Error
    //   4781	4790	8661	java/lang/Error
    //   4866	4876	8661	java/lang/Error
    //   4957	4972	8661	java/lang/Error
    //   5048	5065	8661	java/lang/Error
    //   5141	5158	8661	java/lang/Error
    //   5234	5249	8661	java/lang/Error
    //   5328	5343	8661	java/lang/Error
    //   5419	5435	8661	java/lang/Error
    //   5511	5527	8661	java/lang/Error
    //   5603	5619	8661	java/lang/Error
    //   5695	5711	8661	java/lang/Error
    //   5787	5803	8661	java/lang/Error
    //   5879	5904	8661	java/lang/Error
    //   5980	5990	8661	java/lang/Error
    //   6066	6079	8661	java/lang/Error
    //   6155	6169	8661	java/lang/Error
    //   6245	6260	8661	java/lang/Error
    //   6345	6366	8661	java/lang/Error
    //   6445	6450	8661	java/lang/Error
    //   6526	6538	8661	java/lang/Error
    //   6613	6650	8661	java/lang/Error
    //   6826	6834	8661	java/lang/Error
    //   6916	6933	8661	java/lang/Error
    //   7022	7030	8661	java/lang/Error
    //   7106	7112	8661	java/lang/Error
    //   7188	7195	8661	java/lang/Error
    //   7276	7291	8661	java/lang/Error
    //   7370	7380	8661	java/lang/Error
  }
  
  private void g(j paramj)
  {
    paramj.U = 0L;
    if (paramj.V != null)
    {
      paramj.V.V = null;
      this.T.a(paramj.V, this.w.c);
      paramj.U = this.w.c.executeInsert();
    }
    this.T.a(paramj, this.w.b);
    paramj.Q = this.w.b.executeInsert();
    Object localObject2;
    String str2;
    if ((this.r.b()) && (!paramj.a()))
    {
      localObject1 = this.r.a(paramj);
      localObject2 = localObject1;
      if (paramj.V != null)
      {
        str2 = this.r.a(paramj.V);
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(str2))
        {
          localObject2 = localObject1;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = (String)localObject1 + " ";
          }
          localObject2 = (String)localObject2 + str2;
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = q.b((String)localObject2);
        localObject2 = new ContentValues(2);
        ((ContentValues)localObject2).put("docid", Long.valueOf(paramj.Q));
        ((ContentValues)localObject2).put("content", (String)localObject1);
        this.b.getWritableDatabase().insert("messages_fts", null, (ContentValues)localObject2);
      }
    }
    Object localObject1 = paramj.f();
    if ((localObject1 != null) && (((com.whatsapp.protocol.l)localObject1).e()) && (((com.whatsapp.protocol.l)localObject1).b() != null))
    {
      this.ab.a(((com.whatsapp.protocol.l)localObject1).b(), paramj.e);
      ((com.whatsapp.protocol.l)localObject1).f();
    }
    localObject1 = paramj.g();
    if ((localObject1 != null) && (((k)localObject1).d()))
    {
      this.Z.a(((k)localObject1).a(), paramj.e);
      ((k)localObject1).e();
    }
    if ((this.Y.b()) && (aic.N) && (paramj.e.a != null))
    {
      if (!qz.e(paramj.e.a)) {
        break label573;
      }
      localObject1 = paramj.f;
      switch (paramj.s)
      {
      }
    }
    for (;;)
    {
      label412:
      if ((this.U.b()) && (!paramj.a())) {
        switch (paramj.s)
        {
        default: 
          localObject1 = null;
          label478:
          localObject1 = com.whatsapp.util.aa.a((String)localObject1);
          if (localObject1 != null)
          {
            int i1 = 0;
            for (;;)
            {
              if (i1 < ((ArrayList)localObject1).size())
              {
                localObject2 = new ContentValues(3);
                ((ContentValues)localObject2).put("message_row_id", Long.valueOf(paramj.Q));
                ((ContentValues)localObject2).put("key_remote_jid", paramj.e.a);
                ((ContentValues)localObject2).put("link_index", Integer.toString(i1));
                this.b.getWritableDatabase().insert("messages_links", null, (ContentValues)localObject2);
                i1 += 1;
                continue;
                label573:
                localObject1 = paramj.e.a;
                break;
                localObject2 = paramj.e();
                this.Y.a((String)localObject2, paramj.Q, (String)localObject1);
                break label412;
              }
            }
          }
          break;
        }
      }
      try
      {
        localObject2 = new ArrayList((List)new ObjectInputStream(new ByteArrayInputStream(paramj.h())).readObject()).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          str2 = (String)((Iterator)localObject2).next();
          this.Y.a(str2, paramj.Q, (String)localObject1);
        }
      }
      catch (IOException localIOException)
      {
        Log.d("messagestore/insertmessage error getting contacts from message", localIOException);
        continue;
        String str1 = paramj.e();
        break label478;
        str1 = paramj.z;
        break label478;
        return;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        for (;;) {}
      }
    }
  }
  
  private static boolean h(j paramj)
  {
    return (paramj.E) && (paramj.e.b) && (!j.b(paramj.e.a));
  }
  
  private static boolean i(j paramj)
  {
    return (paramj.e.b) && (paramj.s == 0) && (paramj.d == 6) && (paramj.t == 19L);
  }
  
  private static boolean j(j paramj)
  {
    return (paramj.e.b) && (paramj.s == 0) && (paramj.d == 6) && (paramj.t == 18L);
  }
  
  static int k()
  {
    return new Random().nextInt(999999) + 1;
  }
  
  private static boolean k(j paramj)
  {
    if ((!h(paramj)) && (paramj.s != 8) && (!i(paramj)) && (!j(paramj)))
    {
      if ((paramj.e.b) && (paramj.s == 0) && (paramj.d == 6) && (paramj.t == 21L)) {}
      for (int i1 = 1; i1 == 0; i1 = 0) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean l(j paramj)
  {
    return (!h(paramj)) && (paramj.s != 8) && (!i(paramj)) && (!j(paramj));
  }
  
  /* Error */
  private boolean r()
  {
    // Byte code:
    //   0: ldc_w 1998
    //   3: invokestatic 474	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   6: aload_0
    //   7: getfield 365	com/whatsapp/data/ad:M	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   10: invokevirtual 377	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   13: invokevirtual 2003	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:isHeldByCurrentThread	()Z
    //   16: invokestatic 2006	a/a/a/a/a/a$d:a	(Z)V
    //   19: aload_0
    //   20: monitorenter
    //   21: aload_0
    //   22: getfield 361	com/whatsapp/data/ad:b	Lcom/whatsapp/data/n;
    //   25: astore_1
    //   26: aload_1
    //   27: getfield 2008	com/whatsapp/data/n:f	Ljava/io/File;
    //   30: invokevirtual 1304	java/io/File:getParentFile	()Ljava/io/File;
    //   33: invokevirtual 1658	java/io/File:exists	()Z
    //   36: ifne +14 -> 50
    //   39: aload_1
    //   40: getfield 2008	com/whatsapp/data/n:f	Ljava/io/File;
    //   43: invokevirtual 1304	java/io/File:getParentFile	()Ljava/io/File;
    //   46: invokevirtual 2011	java/io/File:mkdirs	()Z
    //   49: pop
    //   50: aload_1
    //   51: invokevirtual 2012	com/whatsapp/data/n:a	()Z
    //   54: pop
    //   55: aload_1
    //   56: getfield 2008	com/whatsapp/data/n:f	Ljava/io/File;
    //   59: ldc_w 2014
    //   62: invokestatic 2016	com/whatsapp/data/ad:a	(Ljava/io/File;Ljava/lang/String;)V
    //   65: aload_1
    //   66: aload_1
    //   67: getfield 2008	com/whatsapp/data/n:f	Ljava/io/File;
    //   70: invokevirtual 1617	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   73: aconst_null
    //   74: getstatic 1660	com/whatsapp/data/n:h	I
    //   77: ldc_w 2017
    //   80: ior
    //   81: invokestatic 1664	android/database/sqlite/SQLiteDatabase:openDatabase	(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)Landroid/database/sqlite/SQLiteDatabase;
    //   84: putfield 2020	com/whatsapp/data/n:a	Landroid/database/sqlite/SQLiteDatabase;
    //   87: aload_1
    //   88: getfield 2020	com/whatsapp/data/n:a	Landroid/database/sqlite/SQLiteDatabase;
    //   91: invokevirtual 1143	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   94: aload_1
    //   95: aload_1
    //   96: getfield 2020	com/whatsapp/data/n:a	Landroid/database/sqlite/SQLiteDatabase;
    //   99: invokevirtual 2024	com/whatsapp/data/n:onCreate	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   102: aload_1
    //   103: getfield 2020	com/whatsapp/data/n:a	Landroid/database/sqlite/SQLiteDatabase;
    //   106: invokevirtual 1160	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   109: aload_1
    //   110: getfield 2020	com/whatsapp/data/n:a	Landroid/database/sqlite/SQLiteDatabase;
    //   113: ifnull +20 -> 133
    //   116: aload_1
    //   117: getfield 2020	com/whatsapp/data/n:a	Landroid/database/sqlite/SQLiteDatabase;
    //   120: invokevirtual 1163	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   123: ifeq +10 -> 133
    //   126: aload_1
    //   127: getfield 2020	com/whatsapp/data/n:a	Landroid/database/sqlite/SQLiteDatabase;
    //   130: invokevirtual 1166	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   133: aload_1
    //   134: getfield 2008	com/whatsapp/data/n:f	Ljava/io/File;
    //   137: ldc_w 2026
    //   140: invokestatic 2016	com/whatsapp/data/ad:a	(Ljava/io/File;Ljava/lang/String;)V
    //   143: aload_1
    //   144: iconst_1
    //   145: putfield 2027	com/whatsapp/data/n:b	Z
    //   148: aload_1
    //   149: iconst_1
    //   150: putfield 2029	com/whatsapp/data/n:c	Z
    //   153: aload_1
    //   154: iconst_1
    //   155: putfield 2030	com/whatsapp/data/n:e	Z
    //   158: aload_1
    //   159: iconst_1
    //   160: putfield 2032	com/whatsapp/data/n:d	Z
    //   163: aload_0
    //   164: getfield 361	com/whatsapp/data/ad:b	Lcom/whatsapp/data/n;
    //   167: invokevirtual 604	com/whatsapp/data/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   170: pop
    //   171: aload_0
    //   172: getfield 319	com/whatsapp/data/ad:w	Lcom/whatsapp/data/cn;
    //   175: invokevirtual 1199	com/whatsapp/data/cn:b	()V
    //   178: aload_0
    //   179: getfield 329	com/whatsapp/data/ad:z	Lcom/whatsapp/data/ch;
    //   182: iconst_1
    //   183: putfield 2033	com/whatsapp/data/ch:d	Z
    //   186: aload_0
    //   187: monitorexit
    //   188: iconst_1
    //   189: ireturn
    //   190: astore_2
    //   191: aload_1
    //   192: getfield 2020	com/whatsapp/data/n:a	Landroid/database/sqlite/SQLiteDatabase;
    //   195: ifnull +20 -> 215
    //   198: aload_1
    //   199: getfield 2020	com/whatsapp/data/n:a	Landroid/database/sqlite/SQLiteDatabase;
    //   202: invokevirtual 1163	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   205: ifeq +10 -> 215
    //   208: aload_1
    //   209: getfield 2020	com/whatsapp/data/n:a	Landroid/database/sqlite/SQLiteDatabase;
    //   212: invokevirtual 1166	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   215: aload_1
    //   216: getfield 2008	com/whatsapp/data/n:f	Ljava/io/File;
    //   219: ldc_w 2026
    //   222: invokestatic 2016	com/whatsapp/data/ad:a	(Ljava/io/File;Ljava/lang/String;)V
    //   225: aload_2
    //   226: athrow
    //   227: astore_1
    //   228: aload_0
    //   229: monitorexit
    //   230: aload_1
    //   231: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	this	ad
    //   25	191	1	localn	n
    //   227	4	1	localObject1	Object
    //   190	36	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   26	50	190	finally
    //   50	109	190	finally
    //   21	26	227	finally
    //   109	133	227	finally
    //   133	188	227	finally
    //   191	215	227	finally
    //   215	227	227	finally
    //   228	230	227	finally
  }
  
  private void s()
  {
    Log.i("msgstore-manager/initialize/chats");
    ArrayList localArrayList;
    try
    {
      if (this.N) {
        return;
      }
      Map localMap1 = t();
      localArrayList = new ArrayList();
      localArrayList.addAll(localMap1.keySet());
      try
      {
        if (this.N) {
          return;
        }
      }
      finally {}
      this.n.a.putAll(localMap2);
    }
    finally {}
    this.B.a(localArrayList);
    this.N = true;
    Log.i("msgstore-manager/initialize/chats " + this.n.a.size());
  }
  
  private Map<String, d> t()
  {
    HashMap localHashMap = new HashMap();
    this.M.readLock().lock();
    int i1;
    int i2;
    int i3;
    int i4;
    int i5;
    int i6;
    int i7;
    ArrayList localArrayList;
    String str;
    for (;;)
    {
      try
      {
        Cursor localCursor = this.b.getReadableDatabase().rawQuery("SELECT key_remote_jid, message_table_id, last_read_message_table_id, last_read_receipt_sent_message_table_id, archived, sort_timestamp, mod_tag, gen, my_messages, plaintext_disabled, vcard_ui_dismissed, subject, last_message_table_id, unseen_message_count, unseen_missed_calls_count, unseen_row_count FROM chat_list", null);
        if (localCursor == null) {
          break label500;
        }
        i1 = localCursor.getColumnIndexOrThrow("plaintext_disabled");
        i2 = localCursor.getColumnIndexOrThrow("vcard_ui_dismissed");
        i3 = localCursor.getColumnIndexOrThrow("subject");
        i4 = localCursor.getColumnIndexOrThrow("last_message_table_id");
        i5 = localCursor.getColumnIndexOrThrow("unseen_message_count");
        i6 = localCursor.getColumnIndexOrThrow("unseen_missed_calls_count");
        i7 = localCursor.getColumnIndexOrThrow("unseen_row_count");
        try
        {
          localArrayList = new ArrayList();
          if (!localCursor.moveToNext()) {
            break label493;
          }
          str = localCursor.getString(0);
          if (str == null)
          {
            Log.w("msgstore-manager/initialize/chats/jid is null!");
            continue;
            localObject = finally;
          }
        }
        finally
        {
          localCursor.close();
        }
        if (j.a(str)) {
          continue;
        }
      }
      finally
      {
        this.M.readLock().unlock();
      }
      if (!j.c(str))
      {
        if (!str.contains("group_notice@temp")) {
          break;
        }
        Log.i("msgstore-manager/initialize/update-group-sync-failed-msg");
        m(str);
        this.aa.h(true);
      }
    }
    d locald = new d();
    locald.a = ((Cursor)localObject).getLong(1);
    locald.c = ((Cursor)localObject).getLong(2);
    locald.d = ((Cursor)localObject).getLong(3);
    if (((Cursor)localObject).getInt(4) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      locald.e = bool;
      locald.f = ((Cursor)localObject).getLong(5);
      locald.g = ((Cursor)localObject).getInt(6);
      locald.h = ((Cursor)localObject).getDouble(7);
      locald.i = ((Cursor)localObject).getInt(8);
      locald.j = ((Cursor)localObject).getInt(i1);
      locald.k = ((Cursor)localObject).getInt(i2);
      locald.l = ((Cursor)localObject).getString(i3);
      locald.q = ((Cursor)localObject).getLong(i4);
      locald.n = ((Cursor)localObject).getInt(i5);
      locald.o = ((Cursor)localObject).getInt(i6);
      locald.p = ((Cursor)localObject).getInt(i7);
      localMap.put(str, locald);
      localArrayList.add(str);
      break;
    }
    label493:
    ((Cursor)localObject).close();
    label500:
    this.M.readLock().unlock();
    return localMap;
  }
  
  private Cursor u()
  {
    this.i.lock();
    try
    {
      this.b.e();
      Cursor localCursor = a("SELECT key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, raw_data, recipient_count, participant_hash, starred, quoted_row_id, mentioned_jids, multicast_id, edit_version, receipt_server_timestamp, media_enc_hash, _id, key_remote_jid FROM messages WHERE starred=1 AND media_wa_type=13 ORDER BY _id DESC", null, null);
      return localCursor;
    }
    finally
    {
      this.i.unlock();
    }
  }
  
  private Cursor y(String paramString)
  {
    this.i.lock();
    try
    {
      this.b.e();
      paramString = a("SELECT key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, raw_data, recipient_count, participant_hash, starred, quoted_row_id, mentioned_jids, multicast_id, edit_version, receipt_server_timestamp, media_enc_hash, _id, key_remote_jid FROM messages WHERE key_remote_jid = ? AND starred=1 AND media_wa_type=13 ORDER BY _id DESC", new String[] { paramString }, null);
      return paramString;
    }
    finally
    {
      this.i.unlock();
    }
  }
  
  private void z(String paramString)
  {
    d locald = (d)this.n.a.get(paramString);
    if (locald == null) {
      return;
    }
    this.d.post(as.a(this, paramString, locald));
  }
  
  /* Error */
  final int a(j paramj, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 9
    //   3: iconst_0
    //   4: istore 10
    //   6: iconst_0
    //   7: istore 11
    //   9: iconst_0
    //   10: istore 8
    //   12: aload_0
    //   13: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   16: invokevirtual 419	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   19: aconst_null
    //   20: astore 17
    //   22: aconst_null
    //   23: astore 18
    //   25: aconst_null
    //   26: astore 15
    //   28: aconst_null
    //   29: astore 19
    //   31: aconst_null
    //   32: astore 16
    //   34: aload_0
    //   35: getfield 327	com/whatsapp/data/ad:y	Lcom/whatsapp/data/aa;
    //   38: aload_1
    //   39: getfield 849	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   42: invokevirtual 2124	com/whatsapp/data/aa:a	(Lcom/whatsapp/protocol/j$b;)V
    //   45: aload_1
    //   46: iconst_1
    //   47: putfield 2126	com/whatsapp/protocol/j:af	Z
    //   50: iload 8
    //   52: istore 6
    //   54: iload 9
    //   56: istore 7
    //   58: aload_0
    //   59: getfield 361	com/whatsapp/data/ad:b	Lcom/whatsapp/data/n;
    //   62: invokevirtual 604	com/whatsapp/data/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   65: astore 14
    //   67: iload 8
    //   69: istore 6
    //   71: aload 14
    //   73: astore 16
    //   75: iload 9
    //   77: istore 7
    //   79: aload 14
    //   81: astore 17
    //   83: aload 14
    //   85: astore 18
    //   87: aload 14
    //   89: astore 15
    //   91: aload 14
    //   93: astore 19
    //   95: aload_0
    //   96: getfield 319	com/whatsapp/data/ad:w	Lcom/whatsapp/data/cn;
    //   99: invokevirtual 1199	com/whatsapp/data/cn:b	()V
    //   102: iload 8
    //   104: istore 6
    //   106: aload 14
    //   108: astore 16
    //   110: iload 9
    //   112: istore 7
    //   114: aload 14
    //   116: astore 17
    //   118: aload 14
    //   120: astore 18
    //   122: aload 14
    //   124: astore 15
    //   126: aload 14
    //   128: astore 19
    //   130: aload 14
    //   132: invokevirtual 1143	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   135: iload 8
    //   137: istore 6
    //   139: aload 14
    //   141: astore 16
    //   143: iload 9
    //   145: istore 7
    //   147: aload 14
    //   149: astore 17
    //   151: aload 14
    //   153: astore 18
    //   155: aload 14
    //   157: astore 15
    //   159: aload 14
    //   161: astore 19
    //   163: aload_1
    //   164: getfield 621	com/whatsapp/protocol/j:s	B
    //   167: invokestatic 860	com/whatsapp/protocol/m:a	(B)Z
    //   170: ifeq +37 -> 207
    //   173: iload 8
    //   175: istore 6
    //   177: aload 14
    //   179: astore 16
    //   181: iload 9
    //   183: istore 7
    //   185: aload 14
    //   187: astore 17
    //   189: aload 14
    //   191: astore 18
    //   193: aload 14
    //   195: astore 15
    //   197: aload 14
    //   199: astore 19
    //   201: aload_0
    //   202: aload_1
    //   203: iload_2
    //   204: invokespecial 449	com/whatsapp/data/ad:b	(Lcom/whatsapp/protocol/j;Z)V
    //   207: iload 8
    //   209: istore 6
    //   211: aload 14
    //   213: astore 16
    //   215: iload 9
    //   217: istore 7
    //   219: aload 14
    //   221: astore 17
    //   223: aload 14
    //   225: astore 18
    //   227: aload 14
    //   229: astore 15
    //   231: aload 14
    //   233: astore 19
    //   235: aload 14
    //   237: ldc -51
    //   239: ldc_w 2128
    //   242: iconst_1
    //   243: anewarray 429	java/lang/String
    //   246: dup
    //   247: iconst_0
    //   248: aload_1
    //   249: getfield 623	com/whatsapp/protocol/j:Q	J
    //   252: invokestatic 1742	java/lang/Long:toString	(J)Ljava/lang/String;
    //   255: aastore
    //   256: invokevirtual 1102	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   259: istore 5
    //   261: iload 8
    //   263: istore 6
    //   265: aload 14
    //   267: astore 16
    //   269: iload 9
    //   271: istore 7
    //   273: aload 14
    //   275: astore 17
    //   277: aload 14
    //   279: astore 18
    //   281: aload 14
    //   283: astore 15
    //   285: aload 14
    //   287: astore 19
    //   289: new 162	java/lang/StringBuilder
    //   292: dup
    //   293: ldc_w 2130
    //   296: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   299: aload_1
    //   300: getfield 849	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   303: invokevirtual 583	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   306: ldc_w 2132
    //   309: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: iload 5
    //   314: invokevirtual 1120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   317: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokestatic 487	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   323: iload 5
    //   325: ifle +2644 -> 2969
    //   328: iload 8
    //   330: istore 6
    //   332: aload 14
    //   334: astore 16
    //   336: iload 9
    //   338: istore 7
    //   340: aload 14
    //   342: astore 17
    //   344: aload 14
    //   346: astore 18
    //   348: aload 14
    //   350: astore 15
    //   352: aload 14
    //   354: astore 19
    //   356: aload_0
    //   357: getfield 343	com/whatsapp/data/ad:ab	Lcom/whatsapp/data/cq;
    //   360: aload_1
    //   361: invokevirtual 1202	com/whatsapp/data/cq:a	(Lcom/whatsapp/protocol/j;)Z
    //   364: pop
    //   365: iload 8
    //   367: istore 6
    //   369: aload 14
    //   371: astore 16
    //   373: iload 9
    //   375: istore 7
    //   377: aload 14
    //   379: astore 17
    //   381: aload 14
    //   383: astore 18
    //   385: aload 14
    //   387: astore 15
    //   389: aload 14
    //   391: astore 19
    //   393: aload_1
    //   394: invokevirtual 947	com/whatsapp/protocol/j:a	()Z
    //   397: ifeq +1427 -> 1824
    //   400: iload 8
    //   402: istore 6
    //   404: aload 14
    //   406: astore 16
    //   408: iload 9
    //   410: istore 7
    //   412: aload 14
    //   414: astore 17
    //   416: aload 14
    //   418: astore 18
    //   420: aload 14
    //   422: astore 15
    //   424: aload 14
    //   426: astore 19
    //   428: iload 11
    //   430: istore 5
    //   432: aload_1
    //   433: getfield 621	com/whatsapp/protocol/j:s	B
    //   436: bipush 15
    //   438: if_icmpeq +2611 -> 3049
    //   441: iload 8
    //   443: istore 6
    //   445: aload 14
    //   447: astore 16
    //   449: iload 9
    //   451: istore 7
    //   453: aload 14
    //   455: astore 17
    //   457: aload 14
    //   459: astore 18
    //   461: aload 14
    //   463: astore 15
    //   465: aload 14
    //   467: astore 19
    //   469: iload 11
    //   471: istore 5
    //   473: aload_1
    //   474: getfield 621	com/whatsapp/protocol/j:s	B
    //   477: bipush 11
    //   479: if_icmpeq +2570 -> 3049
    //   482: iload 8
    //   484: istore 6
    //   486: aload 14
    //   488: astore 16
    //   490: iload 9
    //   492: istore 7
    //   494: aload 14
    //   496: astore 17
    //   498: aload 14
    //   500: astore 18
    //   502: aload 14
    //   504: astore 15
    //   506: aload 14
    //   508: astore 19
    //   510: aload_1
    //   511: getfield 1437	com/whatsapp/protocol/j:f	Ljava/lang/String;
    //   514: astore 20
    //   516: iload 8
    //   518: istore 6
    //   520: aload 14
    //   522: astore 16
    //   524: iload 9
    //   526: istore 7
    //   528: aload 14
    //   530: astore 17
    //   532: aload 14
    //   534: astore 18
    //   536: aload 14
    //   538: astore 15
    //   540: aload 14
    //   542: astore 19
    //   544: aload_0
    //   545: getfield 325	com/whatsapp/data/ad:x	Lcom/whatsapp/data/co;
    //   548: aload 20
    //   550: invokevirtual 1848	com/whatsapp/data/co:a	(Ljava/lang/String;)Lcom/whatsapp/data/ad$n;
    //   553: astore 21
    //   555: aload 21
    //   557: ifnull +1212 -> 1769
    //   560: iload 4
    //   562: ifne +617 -> 1179
    //   565: iload 8
    //   567: istore 6
    //   569: aload 14
    //   571: astore 16
    //   573: iload 9
    //   575: istore 7
    //   577: aload 14
    //   579: astore 17
    //   581: aload 14
    //   583: astore 18
    //   585: aload 14
    //   587: astore 15
    //   589: aload 14
    //   591: astore 19
    //   593: aload_1
    //   594: getfield 1437	com/whatsapp/protocol/j:f	Ljava/lang/String;
    //   597: invokestatic 518	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   600: ifne +187 -> 787
    //   603: iload 8
    //   605: istore 6
    //   607: aload 14
    //   609: astore 16
    //   611: iload 9
    //   613: istore 7
    //   615: aload 14
    //   617: astore 17
    //   619: aload 14
    //   621: astore 18
    //   623: aload 14
    //   625: astore 15
    //   627: aload 14
    //   629: astore 19
    //   631: aload_0
    //   632: getfield 291	com/whatsapp/data/ad:Q	Lcom/whatsapp/data/e;
    //   635: aload_1
    //   636: getfield 1437	com/whatsapp/protocol/j:f	Ljava/lang/String;
    //   639: invokevirtual 1496	com/whatsapp/data/e:d	(Ljava/lang/String;)Lcom/whatsapp/data/cs;
    //   642: astore 22
    //   644: iload 8
    //   646: istore 6
    //   648: aload 14
    //   650: astore 16
    //   652: iload 9
    //   654: istore 7
    //   656: aload 14
    //   658: astore 17
    //   660: aload 14
    //   662: astore 18
    //   664: aload 14
    //   666: astore 15
    //   668: aload 14
    //   670: astore 19
    //   672: aload 21
    //   674: invokevirtual 2133	com/whatsapp/data/ad$n:b	()Z
    //   677: ifeq +341 -> 1018
    //   680: iload 8
    //   682: istore 6
    //   684: aload 14
    //   686: astore 16
    //   688: iload 9
    //   690: istore 7
    //   692: aload 14
    //   694: astore 17
    //   696: aload 14
    //   698: astore 18
    //   700: aload 14
    //   702: astore 15
    //   704: aload 14
    //   706: astore 19
    //   708: aload 22
    //   710: getfield 2135	com/whatsapp/data/cs:C	Z
    //   713: ifne +74 -> 787
    //   716: iload 8
    //   718: istore 6
    //   720: aload 14
    //   722: astore 16
    //   724: iload 9
    //   726: istore 7
    //   728: aload 14
    //   730: astore 17
    //   732: aload 14
    //   734: astore 18
    //   736: aload 14
    //   738: astore 15
    //   740: aload 14
    //   742: astore 19
    //   744: aload 22
    //   746: iconst_1
    //   747: putfield 2135	com/whatsapp/data/cs:C	Z
    //   750: iload 8
    //   752: istore 6
    //   754: aload 14
    //   756: astore 16
    //   758: iload 9
    //   760: istore 7
    //   762: aload 14
    //   764: astore 17
    //   766: aload 14
    //   768: astore 18
    //   770: aload 14
    //   772: astore 15
    //   774: aload 14
    //   776: astore 19
    //   778: aload_0
    //   779: getfield 291	com/whatsapp/data/ad:Q	Lcom/whatsapp/data/e;
    //   782: aload 22
    //   784: invokevirtual 2138	com/whatsapp/data/e:e	(Lcom/whatsapp/data/cs;)V
    //   787: iload 8
    //   789: istore 6
    //   791: aload 14
    //   793: astore 16
    //   795: iload 9
    //   797: istore 7
    //   799: aload 14
    //   801: astore 17
    //   803: aload 14
    //   805: astore 18
    //   807: aload 14
    //   809: astore 15
    //   811: aload 14
    //   813: astore 19
    //   815: aload 21
    //   817: aload_1
    //   818: invokevirtual 2140	com/whatsapp/data/ad$n:a	(Lcom/whatsapp/protocol/j;)Lcom/whatsapp/data/ad$n;
    //   821: astore_1
    //   822: aload_1
    //   823: ifnonnull +712 -> 1535
    //   826: iload 8
    //   828: istore 6
    //   830: aload 14
    //   832: astore 16
    //   834: iload 9
    //   836: istore 7
    //   838: aload 14
    //   840: astore 17
    //   842: aload 14
    //   844: astore 18
    //   846: aload 14
    //   848: astore 15
    //   850: aload 14
    //   852: astore 19
    //   854: aload_0
    //   855: getfield 325	com/whatsapp/data/ad:x	Lcom/whatsapp/data/co;
    //   858: invokevirtual 1237	com/whatsapp/data/co:c	()Ljava/util/Map;
    //   861: aload 20
    //   863: invokeinterface 1277 2 0
    //   868: pop
    //   869: iload 8
    //   871: istore 6
    //   873: aload 14
    //   875: astore 16
    //   877: iload 9
    //   879: istore 7
    //   881: aload 14
    //   883: astore 17
    //   885: aload 14
    //   887: astore 18
    //   889: aload 14
    //   891: astore 15
    //   893: aload 14
    //   895: astore 19
    //   897: aload 14
    //   899: ldc_w 1264
    //   902: ldc_w 1151
    //   905: iconst_1
    //   906: anewarray 429	java/lang/String
    //   909: dup
    //   910: iconst_0
    //   911: aload 20
    //   913: aastore
    //   914: invokevirtual 1102	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   917: pop
    //   918: iload 8
    //   920: istore 6
    //   922: aload 14
    //   924: astore 16
    //   926: iload 9
    //   928: istore 7
    //   930: aload 14
    //   932: astore 17
    //   934: aload 14
    //   936: astore 18
    //   938: aload 14
    //   940: astore 15
    //   942: aload 14
    //   944: astore 19
    //   946: new 162	java/lang/StringBuilder
    //   949: dup
    //   950: ldc_w 2142
    //   953: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   956: aload 20
    //   958: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   961: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   964: invokestatic 487	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   967: iconst_0
    //   968: istore 5
    //   970: aload 14
    //   972: astore 18
    //   974: aload 14
    //   976: astore 15
    //   978: aload 14
    //   980: astore 19
    //   982: aload 14
    //   984: invokevirtual 1160	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   987: iload 5
    //   989: istore 6
    //   991: aload 14
    //   993: invokevirtual 1163	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   996: ifeq +12 -> 1008
    //   999: aload 14
    //   1001: invokevirtual 1166	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   1004: iload 5
    //   1006: istore 6
    //   1008: aload_0
    //   1009: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   1012: invokevirtual 460	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   1015: iload 6
    //   1017: ireturn
    //   1018: iload 8
    //   1020: istore 6
    //   1022: aload 14
    //   1024: astore 16
    //   1026: iload 9
    //   1028: istore 7
    //   1030: aload 14
    //   1032: astore 17
    //   1034: aload 14
    //   1036: astore 18
    //   1038: aload 14
    //   1040: astore 15
    //   1042: aload 14
    //   1044: astore 19
    //   1046: aload 22
    //   1048: getfield 2135	com/whatsapp/data/cs:C	Z
    //   1051: ifeq -264 -> 787
    //   1054: iload 8
    //   1056: istore 6
    //   1058: aload 14
    //   1060: astore 16
    //   1062: iload 9
    //   1064: istore 7
    //   1066: aload 14
    //   1068: astore 17
    //   1070: aload 14
    //   1072: astore 18
    //   1074: aload 14
    //   1076: astore 15
    //   1078: aload 14
    //   1080: astore 19
    //   1082: aload 22
    //   1084: iconst_0
    //   1085: putfield 2135	com/whatsapp/data/cs:C	Z
    //   1088: iload 8
    //   1090: istore 6
    //   1092: aload 14
    //   1094: astore 16
    //   1096: iload 9
    //   1098: istore 7
    //   1100: aload 14
    //   1102: astore 17
    //   1104: aload 14
    //   1106: astore 18
    //   1108: aload 14
    //   1110: astore 15
    //   1112: aload 14
    //   1114: astore 19
    //   1116: aload_0
    //   1117: getfield 291	com/whatsapp/data/ad:Q	Lcom/whatsapp/data/e;
    //   1120: aload 22
    //   1122: invokevirtual 2138	com/whatsapp/data/e:e	(Lcom/whatsapp/data/cs;)V
    //   1125: goto -338 -> 787
    //   1128: astore_1
    //   1129: iload 6
    //   1131: istore 5
    //   1133: aload 16
    //   1135: astore 14
    //   1137: aload 14
    //   1139: astore 15
    //   1141: aload_1
    //   1142: invokestatic 1169	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   1145: iload 5
    //   1147: istore 6
    //   1149: aload 14
    //   1151: invokevirtual 1163	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   1154: ifeq -146 -> 1008
    //   1157: aload 14
    //   1159: invokevirtual 1166	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   1162: iload 5
    //   1164: istore 6
    //   1166: goto -158 -> 1008
    //   1169: astore_1
    //   1170: aload_0
    //   1171: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   1174: invokevirtual 460	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   1177: aload_1
    //   1178: athrow
    //   1179: iload 8
    //   1181: istore 6
    //   1183: aload 14
    //   1185: astore 16
    //   1187: iload 9
    //   1189: istore 7
    //   1191: aload 14
    //   1193: astore 17
    //   1195: aload 14
    //   1197: astore 18
    //   1199: aload 14
    //   1201: astore 15
    //   1203: aload 14
    //   1205: astore 19
    //   1207: aload 21
    //   1209: monitorenter
    //   1210: aload 21
    //   1212: aload_1
    //   1213: invokevirtual 1246	com/whatsapp/data/ad$n:b	(Lcom/whatsapp/protocol/j;)Lcom/whatsapp/data/ad$n;
    //   1216: astore 15
    //   1218: aload 15
    //   1220: astore_1
    //   1221: aload 15
    //   1223: ifnull +25 -> 1248
    //   1226: aload 15
    //   1228: astore_1
    //   1229: aload 15
    //   1231: getfield 625	com/whatsapp/data/ad$n:b	J
    //   1234: ldc2_w 1154
    //   1237: lcmp
    //   1238: ifne +10 -> 1248
    //   1241: aload_0
    //   1242: aload 15
    //   1244: invokespecial 1248	com/whatsapp/data/ad:a	(Lcom/whatsapp/data/ad$n;)Lcom/whatsapp/data/ad$n;
    //   1247: astore_1
    //   1248: aload_1
    //   1249: ifnull +196 -> 1445
    //   1252: new 1033	android/content/ContentValues
    //   1255: dup
    //   1256: bipush 7
    //   1258: invokespecial 1036	android/content/ContentValues:<init>	(I)V
    //   1261: astore 15
    //   1263: aload 15
    //   1265: ldc_w 1250
    //   1268: aload_1
    //   1269: getfield 625	com/whatsapp/data/ad$n:b	J
    //   1272: invokestatic 588	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1275: invokevirtual 1085	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   1278: aload 15
    //   1280: ldc_w 1252
    //   1283: aload_1
    //   1284: getfield 630	com/whatsapp/data/ad$n:d	J
    //   1287: invokestatic 588	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1290: invokevirtual 1085	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   1293: aload 15
    //   1295: ldc_w 1254
    //   1298: aload_1
    //   1299: getfield 632	com/whatsapp/data/ad$n:e	J
    //   1302: invokestatic 588	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1305: invokevirtual 1085	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   1308: aload 15
    //   1310: ldc_w 1256
    //   1313: aload_1
    //   1314: getfield 613	com/whatsapp/data/ad$n:f	J
    //   1317: invokestatic 588	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1320: invokevirtual 1085	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   1323: aload 15
    //   1325: ldc_w 1258
    //   1328: aload_1
    //   1329: getfield 615	com/whatsapp/data/ad$n:g	J
    //   1332: invokestatic 588	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1335: invokevirtual 1085	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   1338: aload 15
    //   1340: ldc_w 1080
    //   1343: aload_1
    //   1344: getfield 524	com/whatsapp/data/ad$n:h	J
    //   1347: invokestatic 588	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1350: invokevirtual 1085	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   1353: aload 15
    //   1355: ldc_w 1260
    //   1358: aload_1
    //   1359: getfield 619	com/whatsapp/data/ad$n:i	I
    //   1362: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1365: invokevirtual 1090	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1368: aload 15
    //   1370: ldc_w 1262
    //   1373: aload_1
    //   1374: getfield 617	com/whatsapp/data/ad$n:j	I
    //   1377: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1380: invokevirtual 1090	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1383: aload 14
    //   1385: ldc_w 1264
    //   1388: aload 15
    //   1390: ldc_w 1151
    //   1393: iconst_1
    //   1394: anewarray 429	java/lang/String
    //   1397: dup
    //   1398: iconst_0
    //   1399: aload 20
    //   1401: aastore
    //   1402: invokevirtual 1062	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1405: ifne +24 -> 1429
    //   1408: new 162	java/lang/StringBuilder
    //   1411: dup
    //   1412: ldc_w 2144
    //   1415: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1418: aload 20
    //   1420: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1423: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1426: invokestatic 509	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   1429: aload_0
    //   1430: getfield 325	com/whatsapp/data/ad:x	Lcom/whatsapp/data/co;
    //   1433: invokevirtual 1237	com/whatsapp/data/co:c	()Ljava/util/Map;
    //   1436: aload 20
    //   1438: aload_1
    //   1439: invokeinterface 1269 3 0
    //   1444: pop
    //   1445: aload 21
    //   1447: monitorexit
    //   1448: goto -626 -> 822
    //   1451: astore_1
    //   1452: aload 21
    //   1454: monitorexit
    //   1455: iload 8
    //   1457: istore 6
    //   1459: aload 14
    //   1461: astore 16
    //   1463: iload 9
    //   1465: istore 7
    //   1467: aload 14
    //   1469: astore 17
    //   1471: aload 14
    //   1473: astore 18
    //   1475: aload 14
    //   1477: astore 15
    //   1479: aload 14
    //   1481: astore 19
    //   1483: aload_1
    //   1484: athrow
    //   1485: astore_1
    //   1486: iload 7
    //   1488: istore 5
    //   1490: aload 17
    //   1492: astore 14
    //   1494: aload 14
    //   1496: astore 15
    //   1498: aload_1
    //   1499: invokestatic 1169	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   1502: aload 14
    //   1504: astore 15
    //   1506: aload_0
    //   1507: aload_1
    //   1508: invokevirtual 1176	com/whatsapp/data/ad:a	(Ljava/lang/Throwable;)V
    //   1511: iload 5
    //   1513: istore 6
    //   1515: aload 14
    //   1517: invokevirtual 1163	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   1520: ifeq -512 -> 1008
    //   1523: aload 14
    //   1525: invokevirtual 1166	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   1528: iload 5
    //   1530: istore 6
    //   1532: goto -524 -> 1008
    //   1535: iload 4
    //   1537: ifne +1506 -> 3043
    //   1540: iload 8
    //   1542: istore 6
    //   1544: aload 14
    //   1546: astore 16
    //   1548: iload 9
    //   1550: istore 7
    //   1552: aload 14
    //   1554: astore 17
    //   1556: aload 14
    //   1558: astore 18
    //   1560: aload 14
    //   1562: astore 15
    //   1564: aload 14
    //   1566: astore 19
    //   1568: new 1033	android/content/ContentValues
    //   1571: dup
    //   1572: iconst_2
    //   1573: invokespecial 1036	android/content/ContentValues:<init>	(I)V
    //   1576: astore 21
    //   1578: iload 8
    //   1580: istore 6
    //   1582: aload 14
    //   1584: astore 16
    //   1586: iload 9
    //   1588: istore 7
    //   1590: aload 14
    //   1592: astore 17
    //   1594: aload 14
    //   1596: astore 18
    //   1598: aload 14
    //   1600: astore 15
    //   1602: aload 14
    //   1604: astore 19
    //   1606: aload 21
    //   1608: ldc_w 1260
    //   1611: aload_1
    //   1612: getfield 619	com/whatsapp/data/ad$n:i	I
    //   1615: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1618: invokevirtual 1090	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1621: iload 8
    //   1623: istore 6
    //   1625: aload 14
    //   1627: astore 16
    //   1629: iload 9
    //   1631: istore 7
    //   1633: aload 14
    //   1635: astore 17
    //   1637: aload 14
    //   1639: astore 18
    //   1641: aload 14
    //   1643: astore 15
    //   1645: aload 14
    //   1647: astore 19
    //   1649: aload 21
    //   1651: ldc_w 1262
    //   1654: aload_1
    //   1655: getfield 617	com/whatsapp/data/ad$n:j	I
    //   1658: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1661: invokevirtual 1090	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1664: iload 8
    //   1666: istore 6
    //   1668: aload 14
    //   1670: astore 16
    //   1672: iload 9
    //   1674: istore 7
    //   1676: aload 14
    //   1678: astore 17
    //   1680: aload 14
    //   1682: astore 18
    //   1684: aload 14
    //   1686: astore 15
    //   1688: aload 14
    //   1690: astore 19
    //   1692: aload 14
    //   1694: ldc_w 1264
    //   1697: aload 21
    //   1699: ldc_w 1151
    //   1702: iconst_1
    //   1703: anewarray 429	java/lang/String
    //   1706: dup
    //   1707: iconst_0
    //   1708: aload 20
    //   1710: aastore
    //   1711: invokevirtual 1062	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1714: ifne +1329 -> 3043
    //   1717: iload 8
    //   1719: istore 6
    //   1721: aload 14
    //   1723: astore 16
    //   1725: iload 9
    //   1727: istore 7
    //   1729: aload 14
    //   1731: astore 17
    //   1733: aload 14
    //   1735: astore 18
    //   1737: aload 14
    //   1739: astore 15
    //   1741: aload 14
    //   1743: astore 19
    //   1745: new 162	java/lang/StringBuilder
    //   1748: dup
    //   1749: ldc_w 2146
    //   1752: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1755: aload 20
    //   1757: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1760: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1763: invokestatic 509	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   1766: goto +1277 -> 3043
    //   1769: iload 8
    //   1771: istore 6
    //   1773: aload 14
    //   1775: astore 16
    //   1777: iload 9
    //   1779: istore 7
    //   1781: aload 14
    //   1783: astore 17
    //   1785: aload 14
    //   1787: astore 18
    //   1789: aload 14
    //   1791: astore 15
    //   1793: aload 14
    //   1795: astore 19
    //   1797: new 162	java/lang/StringBuilder
    //   1800: dup
    //   1801: ldc_w 2148
    //   1804: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1807: aload 20
    //   1809: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1812: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1815: invokestatic 509	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   1818: iconst_0
    //   1819: istore 5
    //   1821: goto -851 -> 970
    //   1824: iload 8
    //   1826: istore 6
    //   1828: aload 14
    //   1830: astore 16
    //   1832: iload 9
    //   1834: istore 7
    //   1836: aload 14
    //   1838: astore 17
    //   1840: aload 14
    //   1842: astore 18
    //   1844: aload 14
    //   1846: astore 15
    //   1848: aload 14
    //   1850: astore 19
    //   1852: aload_1
    //   1853: getfield 849	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   1856: getfield 1059	com/whatsapp/protocol/j$b:a	Ljava/lang/String;
    //   1859: astore 22
    //   1861: iload 8
    //   1863: istore 6
    //   1865: aload 14
    //   1867: astore 16
    //   1869: iload 9
    //   1871: istore 7
    //   1873: aload 14
    //   1875: astore 17
    //   1877: aload 14
    //   1879: astore 18
    //   1881: aload 14
    //   1883: astore 15
    //   1885: aload 14
    //   1887: astore 19
    //   1889: aload_0
    //   1890: getfield 281	com/whatsapp/data/ad:n	Lcom/whatsapp/data/d;
    //   1893: getfield 1406	com/whatsapp/data/d:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   1896: aload 22
    //   1898: invokevirtual 1409	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1901: checkcast 17	com/whatsapp/data/ad$d
    //   1904: astore 23
    //   1906: iload 11
    //   1908: istore 5
    //   1910: aload 23
    //   1912: ifnull +1137 -> 3049
    //   1915: iload 10
    //   1917: istore 5
    //   1919: iload_3
    //   1920: ifeq +36 -> 1956
    //   1923: iload 8
    //   1925: istore 6
    //   1927: aload 14
    //   1929: astore 16
    //   1931: iload 9
    //   1933: istore 7
    //   1935: aload 14
    //   1937: astore 17
    //   1939: aload 14
    //   1941: astore 18
    //   1943: aload 14
    //   1945: astore 15
    //   1947: aload 14
    //   1949: astore 19
    //   1951: invokestatic 2150	com/whatsapp/data/ad:k	()I
    //   1954: istore 5
    //   1956: iload 5
    //   1958: istore 6
    //   1960: aload 14
    //   1962: astore 16
    //   1964: iload 5
    //   1966: istore 7
    //   1968: aload 14
    //   1970: astore 17
    //   1972: aload 14
    //   1974: astore 18
    //   1976: aload 14
    //   1978: astore 15
    //   1980: aload 14
    //   1982: astore 19
    //   1984: aload 23
    //   1986: getfield 1490	com/whatsapp/data/ad$d:a	J
    //   1989: aload_1
    //   1990: getfield 623	com/whatsapp/protocol/j:Q	J
    //   1993: lcmp
    //   1994: ifne +676 -> 2670
    //   1997: iload 5
    //   1999: istore 6
    //   2001: aload 14
    //   2003: astore 16
    //   2005: iload 5
    //   2007: istore 7
    //   2009: aload 14
    //   2011: astore 17
    //   2013: aload 14
    //   2015: astore 18
    //   2017: aload 14
    //   2019: astore 15
    //   2021: aload 14
    //   2023: astore 19
    //   2025: aload_0
    //   2026: aload 22
    //   2028: invokevirtual 482	com/whatsapp/data/ad:w	(Ljava/lang/String;)J
    //   2031: lstore 12
    //   2033: iload 5
    //   2035: istore 6
    //   2037: aload 14
    //   2039: astore 16
    //   2041: iload 5
    //   2043: istore 7
    //   2045: aload 14
    //   2047: astore 17
    //   2049: aload 14
    //   2051: astore 18
    //   2053: aload 14
    //   2055: astore 15
    //   2057: aload 14
    //   2059: astore 19
    //   2061: new 1033	android/content/ContentValues
    //   2064: dup
    //   2065: iconst_2
    //   2066: invokespecial 1036	android/content/ContentValues:<init>	(I)V
    //   2069: astore 24
    //   2071: iload 5
    //   2073: istore 6
    //   2075: aload 14
    //   2077: astore 16
    //   2079: iload 5
    //   2081: istore 7
    //   2083: aload 14
    //   2085: astore 17
    //   2087: aload 14
    //   2089: astore 18
    //   2091: aload 14
    //   2093: astore 15
    //   2095: aload 14
    //   2097: astore 19
    //   2099: aload 24
    //   2101: ldc_w 1250
    //   2104: lload 12
    //   2106: invokestatic 588	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2109: invokevirtual 1085	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2112: iload_3
    //   2113: ifeq +44 -> 2157
    //   2116: iload 5
    //   2118: istore 6
    //   2120: aload 14
    //   2122: astore 16
    //   2124: iload 5
    //   2126: istore 7
    //   2128: aload 14
    //   2130: astore 17
    //   2132: aload 14
    //   2134: astore 18
    //   2136: aload 14
    //   2138: astore 15
    //   2140: aload 14
    //   2142: astore 19
    //   2144: aload 24
    //   2146: ldc_w 2152
    //   2149: iload 5
    //   2151: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2154: invokevirtual 1090	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2157: aconst_null
    //   2158: astore 20
    //   2160: lload 12
    //   2162: lconst_1
    //   2163: lcmp
    //   2164: ifeq +137 -> 2301
    //   2167: iload 5
    //   2169: istore 6
    //   2171: aload 14
    //   2173: astore 16
    //   2175: iload 5
    //   2177: istore 7
    //   2179: aload 14
    //   2181: astore 17
    //   2183: aload 14
    //   2185: astore 18
    //   2187: aload 14
    //   2189: astore 15
    //   2191: aload 14
    //   2193: astore 19
    //   2195: aload_0
    //   2196: getfield 307	com/whatsapp/data/ad:t	Lcom/whatsapp/data/l;
    //   2199: lload 12
    //   2201: invokevirtual 1396	com/whatsapp/data/l:a	(J)Lcom/whatsapp/protocol/j;
    //   2204: astore 21
    //   2206: aload 21
    //   2208: astore 20
    //   2210: aload 21
    //   2212: ifnull +89 -> 2301
    //   2215: iload 5
    //   2217: istore 6
    //   2219: aload 14
    //   2221: astore 16
    //   2223: iload 5
    //   2225: istore 7
    //   2227: aload 14
    //   2229: astore 17
    //   2231: aload 14
    //   2233: astore 18
    //   2235: aload 14
    //   2237: astore 15
    //   2239: aload 14
    //   2241: astore 19
    //   2243: aload 23
    //   2245: aload 21
    //   2247: getfield 527	com/whatsapp/protocol/j:n	J
    //   2250: putfield 1486	com/whatsapp/data/ad$d:f	J
    //   2253: iload 5
    //   2255: istore 6
    //   2257: aload 14
    //   2259: astore 16
    //   2261: iload 5
    //   2263: istore 7
    //   2265: aload 14
    //   2267: astore 17
    //   2269: aload 14
    //   2271: astore 18
    //   2273: aload 14
    //   2275: astore 15
    //   2277: aload 14
    //   2279: astore 19
    //   2281: aload 24
    //   2283: ldc_w 1430
    //   2286: aload 21
    //   2288: getfield 527	com/whatsapp/protocol/j:n	J
    //   2291: invokestatic 588	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2294: invokevirtual 1085	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2297: aload 21
    //   2299: astore 20
    //   2301: iload 5
    //   2303: istore 6
    //   2305: aload 14
    //   2307: astore 16
    //   2309: iload 5
    //   2311: istore 7
    //   2313: aload 14
    //   2315: astore 17
    //   2317: aload 14
    //   2319: astore 18
    //   2321: aload 14
    //   2323: astore 15
    //   2325: aload 14
    //   2327: astore 19
    //   2329: aload 14
    //   2331: ldc_w 1149
    //   2334: aload 24
    //   2336: ldc_w 1151
    //   2339: iconst_1
    //   2340: anewarray 429	java/lang/String
    //   2343: dup
    //   2344: iconst_0
    //   2345: aload 22
    //   2347: aastore
    //   2348: invokevirtual 1062	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   2351: ifne +136 -> 2487
    //   2354: iload 5
    //   2356: istore 6
    //   2358: aload 14
    //   2360: astore 16
    //   2362: iload 5
    //   2364: istore 7
    //   2366: aload 14
    //   2368: astore 17
    //   2370: aload 14
    //   2372: astore 18
    //   2374: aload 14
    //   2376: astore 15
    //   2378: aload 14
    //   2380: astore 19
    //   2382: aload 24
    //   2384: ldc_w 1153
    //   2387: aload 22
    //   2389: invokevirtual 1042	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2392: iload 5
    //   2394: istore 6
    //   2396: aload 14
    //   2398: astore 16
    //   2400: iload 5
    //   2402: istore 7
    //   2404: aload 14
    //   2406: astore 17
    //   2408: aload 14
    //   2410: astore 18
    //   2412: aload 14
    //   2414: astore 15
    //   2416: aload 14
    //   2418: astore 19
    //   2420: aload 14
    //   2422: ldc_w 1149
    //   2425: aconst_null
    //   2426: aload 24
    //   2428: invokevirtual 1066	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   2431: ldc2_w 1154
    //   2434: lcmp
    //   2435: ifne +52 -> 2487
    //   2438: iload 5
    //   2440: istore 6
    //   2442: aload 14
    //   2444: astore 16
    //   2446: iload 5
    //   2448: istore 7
    //   2450: aload 14
    //   2452: astore 17
    //   2454: aload 14
    //   2456: astore 18
    //   2458: aload 14
    //   2460: astore 15
    //   2462: aload 14
    //   2464: astore 19
    //   2466: new 162	java/lang/StringBuilder
    //   2469: dup
    //   2470: ldc_w 2154
    //   2473: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2476: aload 22
    //   2478: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2481: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2484: invokestatic 509	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   2487: iload 5
    //   2489: istore 6
    //   2491: aload 14
    //   2493: astore 16
    //   2495: iload 5
    //   2497: istore 7
    //   2499: aload 14
    //   2501: astore 17
    //   2503: aload 14
    //   2505: astore 18
    //   2507: aload 14
    //   2509: astore 15
    //   2511: aload 14
    //   2513: astore 19
    //   2515: aload 23
    //   2517: lload 12
    //   2519: putfield 1490	com/whatsapp/data/ad$d:a	J
    //   2522: iload 5
    //   2524: istore 6
    //   2526: aload 14
    //   2528: astore 16
    //   2530: iload 5
    //   2532: istore 7
    //   2534: aload 14
    //   2536: astore 17
    //   2538: aload 14
    //   2540: astore 18
    //   2542: aload 14
    //   2544: astore 15
    //   2546: aload 14
    //   2548: astore 19
    //   2550: aload 23
    //   2552: aload 20
    //   2554: putfield 1488	com/whatsapp/data/ad$d:b	Lcom/whatsapp/protocol/j;
    //   2557: iload 5
    //   2559: istore 6
    //   2561: aload 14
    //   2563: astore 16
    //   2565: iload 5
    //   2567: istore 7
    //   2569: aload 14
    //   2571: astore 17
    //   2573: aload 14
    //   2575: astore 18
    //   2577: aload 14
    //   2579: astore 15
    //   2581: aload 14
    //   2583: astore 19
    //   2585: aload 23
    //   2587: getfield 2156	com/whatsapp/data/ad$d:m	J
    //   2590: aload_1
    //   2591: getfield 623	com/whatsapp/protocol/j:Q	J
    //   2594: lcmp
    //   2595: ifne +37 -> 2632
    //   2598: iload 5
    //   2600: istore 6
    //   2602: aload 14
    //   2604: astore 16
    //   2606: iload 5
    //   2608: istore 7
    //   2610: aload 14
    //   2612: astore 17
    //   2614: aload 14
    //   2616: astore 18
    //   2618: aload 14
    //   2620: astore 15
    //   2622: aload 14
    //   2624: astore 19
    //   2626: aload 23
    //   2628: lconst_1
    //   2629: putfield 2156	com/whatsapp/data/ad$d:m	J
    //   2632: iload 5
    //   2634: istore 6
    //   2636: aload 14
    //   2638: astore 16
    //   2640: iload 5
    //   2642: istore 7
    //   2644: aload 14
    //   2646: astore 17
    //   2648: aload 14
    //   2650: astore 18
    //   2652: aload 14
    //   2654: astore 15
    //   2656: aload 14
    //   2658: astore 19
    //   2660: aload 23
    //   2662: iload 5
    //   2664: putfield 2086	com/whatsapp/data/ad$d:g	I
    //   2667: goto +382 -> 3049
    //   2670: iload 5
    //   2672: istore 6
    //   2674: aload 14
    //   2676: astore 16
    //   2678: iload 5
    //   2680: istore 7
    //   2682: aload 14
    //   2684: astore 17
    //   2686: aload 14
    //   2688: astore 18
    //   2690: aload 14
    //   2692: astore 15
    //   2694: aload 14
    //   2696: astore 19
    //   2698: new 1033	android/content/ContentValues
    //   2701: dup
    //   2702: iconst_2
    //   2703: invokespecial 1036	android/content/ContentValues:<init>	(I)V
    //   2706: astore 20
    //   2708: iload 5
    //   2710: istore 6
    //   2712: aload 14
    //   2714: astore 16
    //   2716: iload 5
    //   2718: istore 7
    //   2720: aload 14
    //   2722: astore 17
    //   2724: aload 14
    //   2726: astore 18
    //   2728: aload 14
    //   2730: astore 15
    //   2732: aload 14
    //   2734: astore 19
    //   2736: aload 20
    //   2738: ldc_w 2152
    //   2741: iload 5
    //   2743: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2746: invokevirtual 1090	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   2749: iload 5
    //   2751: istore 6
    //   2753: aload 14
    //   2755: astore 16
    //   2757: iload 5
    //   2759: istore 7
    //   2761: aload 14
    //   2763: astore 17
    //   2765: aload 14
    //   2767: astore 18
    //   2769: aload 14
    //   2771: astore 15
    //   2773: aload 14
    //   2775: astore 19
    //   2777: aload 14
    //   2779: ldc_w 1149
    //   2782: aload 20
    //   2784: ldc_w 1151
    //   2787: iconst_1
    //   2788: anewarray 429	java/lang/String
    //   2791: dup
    //   2792: iconst_0
    //   2793: aload 22
    //   2795: aastore
    //   2796: invokevirtual 1062	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   2799: ifne -242 -> 2557
    //   2802: iload 5
    //   2804: istore 6
    //   2806: aload 14
    //   2808: astore 16
    //   2810: iload 5
    //   2812: istore 7
    //   2814: aload 14
    //   2816: astore 17
    //   2818: aload 14
    //   2820: astore 18
    //   2822: aload 14
    //   2824: astore 15
    //   2826: aload 14
    //   2828: astore 19
    //   2830: aload 20
    //   2832: ldc_w 1153
    //   2835: aload 22
    //   2837: invokevirtual 1042	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2840: iload 5
    //   2842: istore 6
    //   2844: aload 14
    //   2846: astore 16
    //   2848: iload 5
    //   2850: istore 7
    //   2852: aload 14
    //   2854: astore 17
    //   2856: aload 14
    //   2858: astore 18
    //   2860: aload 14
    //   2862: astore 15
    //   2864: aload 14
    //   2866: astore 19
    //   2868: aload 14
    //   2870: ldc_w 1149
    //   2873: aconst_null
    //   2874: aload 20
    //   2876: invokevirtual 1066	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   2879: ldc2_w 1154
    //   2882: lcmp
    //   2883: ifne -326 -> 2557
    //   2886: iload 5
    //   2888: istore 6
    //   2890: aload 14
    //   2892: astore 16
    //   2894: iload 5
    //   2896: istore 7
    //   2898: aload 14
    //   2900: astore 17
    //   2902: aload 14
    //   2904: astore 18
    //   2906: aload 14
    //   2908: astore 15
    //   2910: aload 14
    //   2912: astore 19
    //   2914: new 162	java/lang/StringBuilder
    //   2917: dup
    //   2918: ldc_w 2154
    //   2921: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2924: aload 22
    //   2926: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2929: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2932: invokestatic 509	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   2935: goto -378 -> 2557
    //   2938: astore_1
    //   2939: aload 18
    //   2941: astore 15
    //   2943: aload_1
    //   2944: invokestatic 1169	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   2947: aload 18
    //   2949: astore 15
    //   2951: aload_1
    //   2952: athrow
    //   2953: astore_1
    //   2954: aload 15
    //   2956: invokevirtual 1163	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   2959: ifeq +8 -> 2967
    //   2962: aload 15
    //   2964: invokevirtual 1166	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   2967: aload_1
    //   2968: athrow
    //   2969: iload 8
    //   2971: istore 6
    //   2973: aload 14
    //   2975: astore 16
    //   2977: iload 9
    //   2979: istore 7
    //   2981: aload 14
    //   2983: astore 17
    //   2985: aload 14
    //   2987: astore 18
    //   2989: aload 14
    //   2991: astore 15
    //   2993: aload 14
    //   2995: astore 19
    //   2997: new 162	java/lang/StringBuilder
    //   3000: dup
    //   3001: ldc_w 2158
    //   3004: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3007: aload_1
    //   3008: getfield 849	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   3011: invokevirtual 583	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3014: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3017: invokestatic 505	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   3020: iload 11
    //   3022: istore 5
    //   3024: goto +25 -> 3049
    //   3027: astore_1
    //   3028: aload 19
    //   3030: astore 18
    //   3032: goto -93 -> 2939
    //   3035: astore_1
    //   3036: goto -1542 -> 1494
    //   3039: astore_1
    //   3040: goto -1903 -> 1137
    //   3043: iconst_0
    //   3044: istore 5
    //   3046: goto -2076 -> 970
    //   3049: goto -2079 -> 970
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3052	0	this	ad
    //   0	3052	1	paramj	j
    //   0	3052	2	paramBoolean1	boolean
    //   0	3052	3	paramBoolean2	boolean
    //   0	3052	4	paramBoolean3	boolean
    //   259	2786	5	i1	int
    //   52	2920	6	i2	int
    //   56	2924	7	i3	int
    //   10	2960	8	i4	int
    //   1	2977	9	i5	int
    //   4	1912	10	i6	int
    //   7	3014	11	i7	int
    //   2031	487	12	l1	long
    //   65	2929	14	localObject1	Object
    //   26	2966	15	localObject2	Object
    //   32	2944	16	localObject3	Object
    //   20	2964	17	localObject4	Object
    //   23	3008	18	localObject5	Object
    //   29	3000	19	localObject6	Object
    //   514	2361	20	localObject7	Object
    //   553	1745	21	localObject8	Object
    //   642	2283	22	localObject9	Object
    //   1904	757	23	locald	d
    //   2069	358	24	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   58	67	1128	android/database/sqlite/SQLiteDoneException
    //   95	102	1128	android/database/sqlite/SQLiteDoneException
    //   130	135	1128	android/database/sqlite/SQLiteDoneException
    //   163	173	1128	android/database/sqlite/SQLiteDoneException
    //   201	207	1128	android/database/sqlite/SQLiteDoneException
    //   235	261	1128	android/database/sqlite/SQLiteDoneException
    //   289	323	1128	android/database/sqlite/SQLiteDoneException
    //   356	365	1128	android/database/sqlite/SQLiteDoneException
    //   393	400	1128	android/database/sqlite/SQLiteDoneException
    //   432	441	1128	android/database/sqlite/SQLiteDoneException
    //   473	482	1128	android/database/sqlite/SQLiteDoneException
    //   510	516	1128	android/database/sqlite/SQLiteDoneException
    //   544	555	1128	android/database/sqlite/SQLiteDoneException
    //   593	603	1128	android/database/sqlite/SQLiteDoneException
    //   631	644	1128	android/database/sqlite/SQLiteDoneException
    //   672	680	1128	android/database/sqlite/SQLiteDoneException
    //   708	716	1128	android/database/sqlite/SQLiteDoneException
    //   744	750	1128	android/database/sqlite/SQLiteDoneException
    //   778	787	1128	android/database/sqlite/SQLiteDoneException
    //   815	822	1128	android/database/sqlite/SQLiteDoneException
    //   854	869	1128	android/database/sqlite/SQLiteDoneException
    //   897	918	1128	android/database/sqlite/SQLiteDoneException
    //   946	967	1128	android/database/sqlite/SQLiteDoneException
    //   1046	1054	1128	android/database/sqlite/SQLiteDoneException
    //   1082	1088	1128	android/database/sqlite/SQLiteDoneException
    //   1116	1125	1128	android/database/sqlite/SQLiteDoneException
    //   1207	1210	1128	android/database/sqlite/SQLiteDoneException
    //   1483	1485	1128	android/database/sqlite/SQLiteDoneException
    //   1568	1578	1128	android/database/sqlite/SQLiteDoneException
    //   1606	1621	1128	android/database/sqlite/SQLiteDoneException
    //   1649	1664	1128	android/database/sqlite/SQLiteDoneException
    //   1692	1717	1128	android/database/sqlite/SQLiteDoneException
    //   1745	1766	1128	android/database/sqlite/SQLiteDoneException
    //   1797	1818	1128	android/database/sqlite/SQLiteDoneException
    //   1852	1861	1128	android/database/sqlite/SQLiteDoneException
    //   1889	1906	1128	android/database/sqlite/SQLiteDoneException
    //   1951	1956	1128	android/database/sqlite/SQLiteDoneException
    //   1984	1997	1128	android/database/sqlite/SQLiteDoneException
    //   2025	2033	1128	android/database/sqlite/SQLiteDoneException
    //   2061	2071	1128	android/database/sqlite/SQLiteDoneException
    //   2099	2112	1128	android/database/sqlite/SQLiteDoneException
    //   2144	2157	1128	android/database/sqlite/SQLiteDoneException
    //   2195	2206	1128	android/database/sqlite/SQLiteDoneException
    //   2243	2253	1128	android/database/sqlite/SQLiteDoneException
    //   2281	2297	1128	android/database/sqlite/SQLiteDoneException
    //   2329	2354	1128	android/database/sqlite/SQLiteDoneException
    //   2382	2392	1128	android/database/sqlite/SQLiteDoneException
    //   2420	2438	1128	android/database/sqlite/SQLiteDoneException
    //   2466	2487	1128	android/database/sqlite/SQLiteDoneException
    //   2515	2522	1128	android/database/sqlite/SQLiteDoneException
    //   2550	2557	1128	android/database/sqlite/SQLiteDoneException
    //   2585	2598	1128	android/database/sqlite/SQLiteDoneException
    //   2626	2632	1128	android/database/sqlite/SQLiteDoneException
    //   2660	2667	1128	android/database/sqlite/SQLiteDoneException
    //   2698	2708	1128	android/database/sqlite/SQLiteDoneException
    //   2736	2749	1128	android/database/sqlite/SQLiteDoneException
    //   2777	2802	1128	android/database/sqlite/SQLiteDoneException
    //   2830	2840	1128	android/database/sqlite/SQLiteDoneException
    //   2868	2886	1128	android/database/sqlite/SQLiteDoneException
    //   2914	2935	1128	android/database/sqlite/SQLiteDoneException
    //   2997	3020	1128	android/database/sqlite/SQLiteDoneException
    //   34	50	1169	finally
    //   991	1004	1169	finally
    //   1149	1162	1169	finally
    //   1515	1528	1169	finally
    //   2954	2967	1169	finally
    //   2967	2969	1169	finally
    //   1210	1218	1451	finally
    //   1229	1248	1451	finally
    //   1252	1429	1451	finally
    //   1429	1445	1451	finally
    //   1445	1448	1451	finally
    //   1452	1455	1451	finally
    //   58	67	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   95	102	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   130	135	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   163	173	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   201	207	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   235	261	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   289	323	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   356	365	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   393	400	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   432	441	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   473	482	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   510	516	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   544	555	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   593	603	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   631	644	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   672	680	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   708	716	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   744	750	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   778	787	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   815	822	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   854	869	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   897	918	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   946	967	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   1046	1054	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   1082	1088	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   1116	1125	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   1207	1210	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   1483	1485	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   1568	1578	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   1606	1621	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   1649	1664	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   1692	1717	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   1745	1766	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   1797	1818	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   1852	1861	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   1889	1906	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   1951	1956	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   1984	1997	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   2025	2033	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   2061	2071	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   2099	2112	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   2144	2157	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   2195	2206	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   2243	2253	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   2281	2297	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   2329	2354	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   2382	2392	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   2420	2438	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   2466	2487	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   2515	2522	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   2550	2557	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   2585	2598	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   2626	2632	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   2660	2667	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   2698	2708	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   2736	2749	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   2777	2802	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   2830	2840	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   2868	2886	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   2914	2935	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   2997	3020	1485	android/database/sqlite/SQLiteDatabaseCorruptException
    //   58	67	2938	java/lang/RuntimeException
    //   95	102	2938	java/lang/RuntimeException
    //   130	135	2938	java/lang/RuntimeException
    //   163	173	2938	java/lang/RuntimeException
    //   201	207	2938	java/lang/RuntimeException
    //   235	261	2938	java/lang/RuntimeException
    //   289	323	2938	java/lang/RuntimeException
    //   356	365	2938	java/lang/RuntimeException
    //   393	400	2938	java/lang/RuntimeException
    //   432	441	2938	java/lang/RuntimeException
    //   473	482	2938	java/lang/RuntimeException
    //   510	516	2938	java/lang/RuntimeException
    //   544	555	2938	java/lang/RuntimeException
    //   593	603	2938	java/lang/RuntimeException
    //   631	644	2938	java/lang/RuntimeException
    //   672	680	2938	java/lang/RuntimeException
    //   708	716	2938	java/lang/RuntimeException
    //   744	750	2938	java/lang/RuntimeException
    //   778	787	2938	java/lang/RuntimeException
    //   815	822	2938	java/lang/RuntimeException
    //   854	869	2938	java/lang/RuntimeException
    //   897	918	2938	java/lang/RuntimeException
    //   946	967	2938	java/lang/RuntimeException
    //   982	987	2938	java/lang/RuntimeException
    //   1046	1054	2938	java/lang/RuntimeException
    //   1082	1088	2938	java/lang/RuntimeException
    //   1116	1125	2938	java/lang/RuntimeException
    //   1207	1210	2938	java/lang/RuntimeException
    //   1483	1485	2938	java/lang/RuntimeException
    //   1568	1578	2938	java/lang/RuntimeException
    //   1606	1621	2938	java/lang/RuntimeException
    //   1649	1664	2938	java/lang/RuntimeException
    //   1692	1717	2938	java/lang/RuntimeException
    //   1745	1766	2938	java/lang/RuntimeException
    //   1797	1818	2938	java/lang/RuntimeException
    //   1852	1861	2938	java/lang/RuntimeException
    //   1889	1906	2938	java/lang/RuntimeException
    //   1951	1956	2938	java/lang/RuntimeException
    //   1984	1997	2938	java/lang/RuntimeException
    //   2025	2033	2938	java/lang/RuntimeException
    //   2061	2071	2938	java/lang/RuntimeException
    //   2099	2112	2938	java/lang/RuntimeException
    //   2144	2157	2938	java/lang/RuntimeException
    //   2195	2206	2938	java/lang/RuntimeException
    //   2243	2253	2938	java/lang/RuntimeException
    //   2281	2297	2938	java/lang/RuntimeException
    //   2329	2354	2938	java/lang/RuntimeException
    //   2382	2392	2938	java/lang/RuntimeException
    //   2420	2438	2938	java/lang/RuntimeException
    //   2466	2487	2938	java/lang/RuntimeException
    //   2515	2522	2938	java/lang/RuntimeException
    //   2550	2557	2938	java/lang/RuntimeException
    //   2585	2598	2938	java/lang/RuntimeException
    //   2626	2632	2938	java/lang/RuntimeException
    //   2660	2667	2938	java/lang/RuntimeException
    //   2698	2708	2938	java/lang/RuntimeException
    //   2736	2749	2938	java/lang/RuntimeException
    //   2777	2802	2938	java/lang/RuntimeException
    //   2830	2840	2938	java/lang/RuntimeException
    //   2868	2886	2938	java/lang/RuntimeException
    //   2914	2935	2938	java/lang/RuntimeException
    //   2997	3020	2938	java/lang/RuntimeException
    //   58	67	2953	finally
    //   95	102	2953	finally
    //   130	135	2953	finally
    //   163	173	2953	finally
    //   201	207	2953	finally
    //   235	261	2953	finally
    //   289	323	2953	finally
    //   356	365	2953	finally
    //   393	400	2953	finally
    //   432	441	2953	finally
    //   473	482	2953	finally
    //   510	516	2953	finally
    //   544	555	2953	finally
    //   593	603	2953	finally
    //   631	644	2953	finally
    //   672	680	2953	finally
    //   708	716	2953	finally
    //   744	750	2953	finally
    //   778	787	2953	finally
    //   815	822	2953	finally
    //   854	869	2953	finally
    //   897	918	2953	finally
    //   946	967	2953	finally
    //   982	987	2953	finally
    //   1046	1054	2953	finally
    //   1082	1088	2953	finally
    //   1116	1125	2953	finally
    //   1141	1145	2953	finally
    //   1207	1210	2953	finally
    //   1483	1485	2953	finally
    //   1498	1502	2953	finally
    //   1506	1511	2953	finally
    //   1568	1578	2953	finally
    //   1606	1621	2953	finally
    //   1649	1664	2953	finally
    //   1692	1717	2953	finally
    //   1745	1766	2953	finally
    //   1797	1818	2953	finally
    //   1852	1861	2953	finally
    //   1889	1906	2953	finally
    //   1951	1956	2953	finally
    //   1984	1997	2953	finally
    //   2025	2033	2953	finally
    //   2061	2071	2953	finally
    //   2099	2112	2953	finally
    //   2144	2157	2953	finally
    //   2195	2206	2953	finally
    //   2243	2253	2953	finally
    //   2281	2297	2953	finally
    //   2329	2354	2953	finally
    //   2382	2392	2953	finally
    //   2420	2438	2953	finally
    //   2466	2487	2953	finally
    //   2515	2522	2953	finally
    //   2550	2557	2953	finally
    //   2585	2598	2953	finally
    //   2626	2632	2953	finally
    //   2660	2667	2953	finally
    //   2698	2708	2953	finally
    //   2736	2749	2953	finally
    //   2777	2802	2953	finally
    //   2830	2840	2953	finally
    //   2868	2886	2953	finally
    //   2914	2935	2953	finally
    //   2943	2947	2953	finally
    //   2951	2953	2953	finally
    //   2997	3020	2953	finally
    //   58	67	3027	java/lang/Error
    //   95	102	3027	java/lang/Error
    //   130	135	3027	java/lang/Error
    //   163	173	3027	java/lang/Error
    //   201	207	3027	java/lang/Error
    //   235	261	3027	java/lang/Error
    //   289	323	3027	java/lang/Error
    //   356	365	3027	java/lang/Error
    //   393	400	3027	java/lang/Error
    //   432	441	3027	java/lang/Error
    //   473	482	3027	java/lang/Error
    //   510	516	3027	java/lang/Error
    //   544	555	3027	java/lang/Error
    //   593	603	3027	java/lang/Error
    //   631	644	3027	java/lang/Error
    //   672	680	3027	java/lang/Error
    //   708	716	3027	java/lang/Error
    //   744	750	3027	java/lang/Error
    //   778	787	3027	java/lang/Error
    //   815	822	3027	java/lang/Error
    //   854	869	3027	java/lang/Error
    //   897	918	3027	java/lang/Error
    //   946	967	3027	java/lang/Error
    //   982	987	3027	java/lang/Error
    //   1046	1054	3027	java/lang/Error
    //   1082	1088	3027	java/lang/Error
    //   1116	1125	3027	java/lang/Error
    //   1207	1210	3027	java/lang/Error
    //   1483	1485	3027	java/lang/Error
    //   1568	1578	3027	java/lang/Error
    //   1606	1621	3027	java/lang/Error
    //   1649	1664	3027	java/lang/Error
    //   1692	1717	3027	java/lang/Error
    //   1745	1766	3027	java/lang/Error
    //   1797	1818	3027	java/lang/Error
    //   1852	1861	3027	java/lang/Error
    //   1889	1906	3027	java/lang/Error
    //   1951	1956	3027	java/lang/Error
    //   1984	1997	3027	java/lang/Error
    //   2025	2033	3027	java/lang/Error
    //   2061	2071	3027	java/lang/Error
    //   2099	2112	3027	java/lang/Error
    //   2144	2157	3027	java/lang/Error
    //   2195	2206	3027	java/lang/Error
    //   2243	2253	3027	java/lang/Error
    //   2281	2297	3027	java/lang/Error
    //   2329	2354	3027	java/lang/Error
    //   2382	2392	3027	java/lang/Error
    //   2420	2438	3027	java/lang/Error
    //   2466	2487	3027	java/lang/Error
    //   2515	2522	3027	java/lang/Error
    //   2550	2557	3027	java/lang/Error
    //   2585	2598	3027	java/lang/Error
    //   2626	2632	3027	java/lang/Error
    //   2660	2667	3027	java/lang/Error
    //   2698	2708	3027	java/lang/Error
    //   2736	2749	3027	java/lang/Error
    //   2777	2802	3027	java/lang/Error
    //   2830	2840	3027	java/lang/Error
    //   2868	2886	3027	java/lang/Error
    //   2914	2935	3027	java/lang/Error
    //   2997	3020	3027	java/lang/Error
    //   982	987	3035	android/database/sqlite/SQLiteDatabaseCorruptException
    //   982	987	3039	android/database/sqlite/SQLiteDoneException
  }
  
  public final int a(String paramString, long paramLong1, long paramLong2)
  {
    int i1 = 0;
    Object localObject = Long.toString(paramLong1);
    String str = Long.toString(paramLong2);
    localObject = this.b.getReadableDatabase().rawQuery("SELECT count(*) FROM messages WHERE key_remote_jid=?  AND media_wa_type!=8 AND _id>? AND _id<=?", new String[] { paramString, localObject, str });
    if (localObject != null) {
      try
      {
        if (((Cursor)localObject).moveToNext())
        {
          i1 = ((Cursor)localObject).getInt(0);
          Log.i("msgstore/getmessagesatid/pos:" + i1);
        }
        for (;;)
        {
          return i1;
          Log.i("msgstore/getmessagesatid/db no message for " + paramString);
        }
        Log.e("msgstore/getmessagesatid/cursor is null");
      }
      finally
      {
        ((Cursor)localObject).close();
      }
    }
    return 0;
  }
  
  /* Error */
  public final int a(String paramString, j paramj)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore_3
    //   5: new 162	java/lang/StringBuilder
    //   8: dup
    //   9: ldc_w 2170
    //   12: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   15: aload_1
    //   16: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: invokestatic 474	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   25: new 411	com/whatsapp/util/bd
    //   28: dup
    //   29: invokespecial 1734	com/whatsapp/util/bd:<init>	()V
    //   32: astore 6
    //   34: aload 6
    //   36: ldc_w 2172
    //   39: invokevirtual 1738	com/whatsapp/util/bd:a	(Ljava/lang/String;)V
    //   42: aload_0
    //   43: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   46: invokevirtual 419	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   49: aload_0
    //   50: getfield 361	com/whatsapp/data/ad:b	Lcom/whatsapp/data/n;
    //   53: invokevirtual 425	com/whatsapp/data/n:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   56: ldc_w 2174
    //   59: iconst_1
    //   60: anewarray 429	java/lang/String
    //   63: dup
    //   64: iconst_0
    //   65: aload_1
    //   66: aastore
    //   67: invokevirtual 435	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   70: astore 5
    //   72: aload 5
    //   74: ifnull +113 -> 187
    //   77: iload_3
    //   78: istore 4
    //   80: aload 5
    //   82: invokeinterface 441 1 0
    //   87: ifeq +106 -> 193
    //   90: iload_3
    //   91: istore 4
    //   93: aload_2
    //   94: invokeinterface 2175 1 0
    //   99: ifne +94 -> 193
    //   102: aload_0
    //   103: getfield 307	com/whatsapp/data/ad:t	Lcom/whatsapp/data/l;
    //   106: aload 5
    //   108: aload_1
    //   109: invokevirtual 446	com/whatsapp/data/l:a	(Landroid/database/Cursor;Ljava/lang/String;)Lcom/whatsapp/protocol/j;
    //   112: astore 7
    //   114: aload 7
    //   116: invokevirtual 877	com/whatsapp/protocol/j:b	()Lcom/whatsapp/MediaData;
    //   119: ifnull -42 -> 77
    //   122: aload 7
    //   124: invokevirtual 877	com/whatsapp/protocol/j:b	()Lcom/whatsapp/MediaData;
    //   127: astore 8
    //   129: aload 7
    //   131: getfield 849	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   134: getfield 853	com/whatsapp/protocol/j$b:b	Z
    //   137: ifne +11 -> 148
    //   140: aload 8
    //   142: getfield 882	com/whatsapp/MediaData:transferred	Z
    //   145: ifeq -68 -> 77
    //   148: aload 8
    //   150: getfield 1612	com/whatsapp/MediaData:file	Ljava/io/File;
    //   153: ifnull -76 -> 77
    //   156: new 1287	java/io/File
    //   159: dup
    //   160: aload 8
    //   162: getfield 1612	com/whatsapp/MediaData:file	Ljava/io/File;
    //   165: invokestatic 2181	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   168: invokevirtual 2184	android/net/Uri:getPath	()Ljava/lang/String;
    //   171: invokespecial 2185	java/io/File:<init>	(Ljava/lang/String;)V
    //   174: invokevirtual 1658	java/io/File:exists	()Z
    //   177: ifeq -100 -> 77
    //   180: iload_3
    //   181: iconst_1
    //   182: iadd
    //   183: istore_3
    //   184: goto -107 -> 77
    //   187: ldc_w 2187
    //   190: invokestatic 509	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   193: aload 5
    //   195: ifnull +10 -> 205
    //   198: aload 5
    //   200: invokeinterface 457 1 0
    //   205: aload_0
    //   206: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   209: invokevirtual 460	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   212: aload 6
    //   214: invokevirtual 467	com/whatsapp/util/bd:b	()J
    //   217: pop2
    //   218: new 162	java/lang/StringBuilder
    //   221: dup
    //   222: ldc_w 2189
    //   225: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   228: iload 4
    //   230: invokevirtual 1120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   233: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 474	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   239: iload 4
    //   241: ireturn
    //   242: astore_1
    //   243: aload_0
    //   244: getfield 263	com/whatsapp/data/ad:J	Landroid/content/Context;
    //   247: invokestatic 454	a/a/a/a/d:h	(Landroid/content/Context;)V
    //   250: aload_1
    //   251: athrow
    //   252: astore_1
    //   253: aload 5
    //   255: ifnull +10 -> 265
    //   258: aload 5
    //   260: invokeinterface 457 1 0
    //   265: aload_1
    //   266: athrow
    //   267: astore_1
    //   268: aload_0
    //   269: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   272: invokevirtual 460	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   275: aload_1
    //   276: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	277	0	this	ad
    //   0	277	1	paramString	String
    //   0	277	2	paramj	j
    //   4	180	3	i1	int
    //   1	239	4	i2	int
    //   70	189	5	localCursor	Cursor
    //   32	181	6	localbd	bd
    //   112	18	7	localj	j
    //   127	34	8	localMediaData	MediaData
    // Exception table:
    //   from	to	target	type
    //   80	90	242	android/database/sqlite/SQLiteDiskIOException
    //   93	148	242	android/database/sqlite/SQLiteDiskIOException
    //   148	180	242	android/database/sqlite/SQLiteDiskIOException
    //   187	193	242	android/database/sqlite/SQLiteDiskIOException
    //   80	90	252	finally
    //   93	148	252	finally
    //   148	180	252	finally
    //   187	193	252	finally
    //   243	252	252	finally
    //   49	72	267	finally
    //   198	205	267	finally
    //   258	265	267	finally
    //   265	267	267	finally
  }
  
  public final long a(String paramString1, j paramj, boolean paramBoolean, String paramString2)
  {
    bd localbd = new bd("msgstore/fts/searchforjid");
    long l1 = e(paramj);
    if (l1 == 1L) {
      Log.e("msgstore/fts/searchforjid/startid < 0");
    }
    do
    {
      return 0L;
      Log.i("msgstore/fts/searchforjid/start:" + l1 + " up:" + paramBoolean);
      paramString2 = q.c(paramString2);
    } while (TextUtils.isEmpty(paramString2));
    SQLiteDatabase localSQLiteDatabase = this.b.getReadableDatabase();
    if (paramBoolean)
    {
      paramj = "SELECT docid, content FROM messages_fts, messages WHERE content MATCH ? AND messages_fts.docid = messages._id AND messages.key_remote_jid = ?" + " AND _id<" + l1 + " ORDER BY _id DESC";
      paramString1 = localSQLiteDatabase.rawQuery(paramj + " LIMIT 1", new String[] { paramString2, paramString1 });
      if (paramString1 == null) {
        break label284;
      }
    }
    for (;;)
    {
      label284:
      try
      {
        if (!paramString1.moveToNext()) {
          break label296;
        }
        l1 = paramString1.getLong(paramString1.getColumnIndex("docid"));
        paramString1.close();
        return l1;
      }
      finally
      {
        paramString1.close();
      }
      paramj = "SELECT docid, content FROM messages_fts, messages WHERE content MATCH ? AND messages_fts.docid = messages._id AND messages.key_remote_jid = ?" + " AND _id>" + l1 + " ORDER BY _id ASC";
      break;
      l1 = 0L;
      continue;
      label296:
      l1 = 0L;
    }
  }
  
  public final Cursor a(String paramString, android.support.v4.d.a parama)
  {
    Object localObject = null;
    this.i.lock();
    try
    {
      this.b.e();
      if (TextUtils.isEmpty(paramString)) {}
      for (paramString = (String)localObject; !TextUtils.isEmpty(paramString); paramString = q.c(paramString))
      {
        paramString = a("SELECT key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, raw_data, recipient_count, participant_hash, starred, quoted_row_id, mentioned_jids, multicast_id, edit_version, receipt_server_timestamp, media_enc_hash, _id, key_remote_jid FROM messages WHERE _id IN (SELECT docid FROM messages_fts, messages WHERE content MATCH ? AND messages_fts.docid = messages._id AND messages.starred = 1) ORDER BY _id DESC", new String[] { paramString }, parama);
        return paramString;
      }
      paramString = a("SELECT key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, raw_data, recipient_count, participant_hash, starred, quoted_row_id, mentioned_jids, multicast_id, edit_version, receipt_server_timestamp, media_enc_hash, _id, key_remote_jid FROM messages WHERE starred=1 ORDER BY _id DESC", null, parama);
      return paramString;
    }
    finally
    {
      this.i.unlock();
    }
  }
  
  public final Cursor a(String paramString1, String paramString2, android.support.v4.d.a parama)
  {
    this.i.lock();
    try
    {
      this.b.e();
      if (TextUtils.isEmpty(paramString2)) {}
      for (paramString2 = null; !TextUtils.isEmpty(paramString2); paramString2 = q.c(paramString2))
      {
        paramString1 = a("SELECT key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, raw_data, recipient_count, participant_hash, starred, quoted_row_id, mentioned_jids, multicast_id, edit_version, receipt_server_timestamp, media_enc_hash, _id, key_remote_jid FROM messages WHERE _id IN (SELECT docid FROM messages_fts, messages WHERE key_remote_jid = ? AND content MATCH ? AND messages_fts.docid = messages._id AND messages.starred = 1) ORDER BY _id DESC", new String[] { paramString1, paramString2 }, parama);
        return paramString1;
      }
      paramString1 = a("SELECT key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, raw_data, recipient_count, participant_hash, starred, quoted_row_id, mentioned_jids, multicast_id, edit_version, receipt_server_timestamp, media_enc_hash, _id, key_remote_jid FROM messages WHERE key_remote_jid = ? AND starred=1 ORDER BY _id DESC", new String[] { paramString1 }, parama);
      return paramString1;
    }
    finally
    {
      this.i.unlock();
    }
  }
  
  /* Error */
  public final c a(boolean paramBoolean, com.whatsapp.gdrive.ch.a<Void, Integer> parama)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: ldc_w 2225
    //   6: invokestatic 474	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   9: invokestatic 2229	com/whatsapp/r:o	()Z
    //   12: ifne +17 -> 29
    //   15: ldc_w 2231
    //   18: invokestatic 474	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   21: getstatic 2234	com/whatsapp/data/ad$c:d	Lcom/whatsapp/data/ad$c;
    //   24: astore 9
    //   26: aload 9
    //   28: areturn
    //   29: getstatic 2236	com/whatsapp/data/ad$c:b	Lcom/whatsapp/data/ad$c;
    //   32: astore 10
    //   34: ldc_w 2238
    //   37: invokestatic 2243	com/whatsapp/k/c:a	(Ljava/lang/String;)Lcom/whatsapp/k/d;
    //   40: astore 11
    //   42: ldc_w 2245
    //   45: invokestatic 2243	com/whatsapp/k/c:a	(Ljava/lang/String;)Lcom/whatsapp/k/d;
    //   48: astore 12
    //   50: aload 11
    //   52: invokeinterface 2248 1 0
    //   57: aload 12
    //   59: invokeinterface 2248 1 0
    //   64: aload_0
    //   65: getfield 379	com/whatsapp/data/ad:h	Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   68: invokevirtual 2249	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   71: aload_0
    //   72: getfield 357	com/whatsapp/data/ad:e	Ljava/io/File;
    //   75: ldc_w 2251
    //   78: invokestatic 2016	com/whatsapp/data/ad:a	(Ljava/io/File;Ljava/lang/String;)V
    //   81: aload_0
    //   82: getfield 361	com/whatsapp/data/ad:b	Lcom/whatsapp/data/n;
    //   85: invokevirtual 2252	com/whatsapp/data/n:b	()V
    //   88: aload_0
    //   89: getfield 361	com/whatsapp/data/ad:b	Lcom/whatsapp/data/n;
    //   92: invokevirtual 2254	com/whatsapp/data/n:d	()V
    //   95: aload_0
    //   96: getfield 361	com/whatsapp/data/ad:b	Lcom/whatsapp/data/n;
    //   99: invokevirtual 2102	com/whatsapp/data/n:e	()V
    //   102: aload_0
    //   103: getfield 361	com/whatsapp/data/ad:b	Lcom/whatsapp/data/n;
    //   106: invokevirtual 2255	com/whatsapp/data/n:c	()V
    //   109: aload_0
    //   110: getfield 361	com/whatsapp/data/ad:b	Lcom/whatsapp/data/n;
    //   113: invokevirtual 1838	com/whatsapp/data/n:close	()V
    //   116: aload_0
    //   117: getfield 357	com/whatsapp/data/ad:e	Ljava/io/File;
    //   120: ldc_w 2257
    //   123: invokestatic 2016	com/whatsapp/data/ad:a	(Ljava/io/File;Ljava/lang/String;)V
    //   126: iload_1
    //   127: ifeq +117 -> 244
    //   130: aload_0
    //   131: aload_0
    //   132: getfield 357	com/whatsapp/data/ad:e	Ljava/io/File;
    //   135: invokevirtual 2260	com/whatsapp/data/ad:c	(Ljava/io/File;)Lcom/whatsapp/data/ad$h;
    //   138: astore 9
    //   140: aload 9
    //   142: ifnonnull +172 -> 314
    //   145: iconst_m1
    //   146: istore_3
    //   147: new 162	java/lang/StringBuilder
    //   150: dup
    //   151: ldc_w 2262
    //   154: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   157: iload_3
    //   158: invokevirtual 1120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   161: astore 13
    //   163: aload 9
    //   165: ifnull +660 -> 825
    //   168: new 162	java/lang/StringBuilder
    //   171: dup
    //   172: ldc_w 2264
    //   175: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   178: aload 9
    //   180: getfield 2267	com/whatsapp/data/ad$h:b	Ljava/util/HashMap;
    //   183: invokevirtual 2268	java/util/HashMap:size	()I
    //   186: invokevirtual 1120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   189: ldc_w 2270
    //   192: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload 9
    //   197: getfield 2273	com/whatsapp/data/ad$h:c	Ljava/util/ArrayList;
    //   200: invokevirtual 965	java/util/ArrayList:size	()I
    //   203: invokevirtual 1120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   206: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: astore 9
    //   211: aload 13
    //   213: aload 9
    //   215: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokestatic 474	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   224: iload_3
    //   225: ifne +608 -> 833
    //   228: iconst_1
    //   229: istore_1
    //   230: aload_0
    //   231: getfield 263	com/whatsapp/data/ad:J	Landroid/content/Context;
    //   234: sipush 281
    //   237: iload_1
    //   238: invokestatic 1051	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   241: invokestatic 2278	com/whatsapp/fieldstats/l:a	(Landroid/content/Context;ILjava/lang/Object;)V
    //   244: aload_0
    //   245: aload_2
    //   246: getstatic 2281	com/whatsapp/data/cb:a	Lcom/whatsapp/util/r$b;
    //   249: aload_0
    //   250: aload 12
    //   252: invokestatic 2286	com/whatsapp/data/ae:a	(Lcom/whatsapp/data/ad;Lcom/whatsapp/k/d;)Ljava/lang/Runnable;
    //   255: invokespecial 2288	com/whatsapp/data/ad:a	(Lcom/whatsapp/gdrive/ch$a;Lcom/whatsapp/util/r$b;Ljava/lang/Runnable;)Lcom/whatsapp/data/ad$c;
    //   258: astore_2
    //   259: aload_0
    //   260: getfield 379	com/whatsapp/data/ad:h	Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   263: invokevirtual 2003	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:isHeldByCurrentThread	()Z
    //   266: ifeq +78 -> 344
    //   269: aload_0
    //   270: getfield 361	com/whatsapp/data/ad:b	Lcom/whatsapp/data/n;
    //   273: invokevirtual 604	com/whatsapp/data/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   276: ifnonnull +61 -> 337
    //   279: ldc_w 2290
    //   282: invokestatic 509	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   285: aload_2
    //   286: astore 9
    //   288: aload_0
    //   289: getfield 379	com/whatsapp/data/ad:h	Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   292: invokevirtual 2003	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:isHeldByCurrentThread	()Z
    //   295: ifeq -269 -> 26
    //   298: aload_0
    //   299: getfield 379	com/whatsapp/data/ad:h	Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   302: invokevirtual 2291	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   305: aload 12
    //   307: invokeinterface 2292 1 0
    //   312: aload_2
    //   313: areturn
    //   314: aload 9
    //   316: getfield 2294	com/whatsapp/data/ad$h:a	I
    //   319: istore_3
    //   320: goto -173 -> 147
    //   323: astore_2
    //   324: ldc_w 2296
    //   327: aload_2
    //   328: invokestatic 2298	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   331: aload 10
    //   333: astore_2
    //   334: goto -75 -> 259
    //   337: aload_0
    //   338: getfield 319	com/whatsapp/data/ad:w	Lcom/whatsapp/data/cn;
    //   341: invokevirtual 1839	com/whatsapp/data/cn:c	()V
    //   344: aload_0
    //   345: getfield 379	com/whatsapp/data/ad:h	Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   348: invokevirtual 2003	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:isHeldByCurrentThread	()Z
    //   351: ifeq +17 -> 368
    //   354: aload_0
    //   355: getfield 379	com/whatsapp/data/ad:h	Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   358: invokevirtual 2291	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   361: aload 12
    //   363: invokeinterface 2292 1 0
    //   368: aload_0
    //   369: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   372: invokevirtual 419	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   375: aload_0
    //   376: getfield 303	com/whatsapp/data/ad:r	Lcom/whatsapp/data/q;
    //   379: invokevirtual 1880	com/whatsapp/data/q:b	()Z
    //   382: ifne +105 -> 487
    //   385: aload_0
    //   386: getfield 263	com/whatsapp/data/ad:J	Landroid/content/Context;
    //   389: ldc_w 2300
    //   392: iconst_0
    //   393: invokevirtual 2304	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   396: astore 9
    //   398: aload 9
    //   400: ldc_w 2306
    //   403: iconst_0
    //   404: invokeinterface 2311 3 0
    //   409: istore_3
    //   410: iload_3
    //   411: iconst_5
    //   412: if_icmpge +75 -> 487
    //   415: aload 9
    //   417: ldc_w 2313
    //   420: lconst_0
    //   421: invokeinterface 2316 4 0
    //   426: lstore 5
    //   428: aload_0
    //   429: getfield 317	com/whatsapp/data/ad:v	Lcom/whatsapp/data/cj;
    //   432: ldc_w 2318
    //   435: invokevirtual 2320	com/whatsapp/data/cj:b	(Ljava/lang/String;)J
    //   438: lstore 7
    //   440: aload 9
    //   442: invokeinterface 2324 1 0
    //   447: astore 9
    //   449: lload 7
    //   451: lload 5
    //   453: lcmp
    //   454: ifne +306 -> 760
    //   457: iload_3
    //   458: iconst_1
    //   459: iadd
    //   460: istore_3
    //   461: aload 9
    //   463: ldc_w 2306
    //   466: iload_3
    //   467: invokeinterface 2330 3 0
    //   472: pop
    //   473: aload 9
    //   475: invokeinterface 2333 1 0
    //   480: aload_0
    //   481: getfield 303	com/whatsapp/data/ad:r	Lcom/whatsapp/data/q;
    //   484: invokevirtual 2334	com/whatsapp/data/q:d	()V
    //   487: aload_0
    //   488: getfield 323	com/whatsapp/data/ad:Y	Lcom/whatsapp/data/cr;
    //   491: invokevirtual 1944	com/whatsapp/data/cr:b	()Z
    //   494: ifne +111 -> 605
    //   497: getstatic 1948	com/whatsapp/aic:N	Z
    //   500: ifeq +105 -> 605
    //   503: aload_0
    //   504: getfield 263	com/whatsapp/data/ad:J	Landroid/content/Context;
    //   507: ldc_w 2300
    //   510: iconst_0
    //   511: invokevirtual 2304	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   514: astore 9
    //   516: aload 9
    //   518: ldc_w 2336
    //   521: iconst_0
    //   522: invokeinterface 2311 3 0
    //   527: istore_3
    //   528: iload_3
    //   529: iconst_5
    //   530: if_icmpge +75 -> 605
    //   533: aload 9
    //   535: ldc_w 2338
    //   538: lconst_0
    //   539: invokeinterface 2316 4 0
    //   544: lstore 5
    //   546: aload_0
    //   547: getfield 317	com/whatsapp/data/ad:v	Lcom/whatsapp/data/cj;
    //   550: ldc_w 2340
    //   553: invokevirtual 2320	com/whatsapp/data/cj:b	(Ljava/lang/String;)J
    //   556: lstore 7
    //   558: aload 9
    //   560: invokeinterface 2324 1 0
    //   565: astore 9
    //   567: lload 7
    //   569: lload 5
    //   571: lcmp
    //   572: ifne +206 -> 778
    //   575: iload_3
    //   576: iconst_1
    //   577: iadd
    //   578: istore_3
    //   579: aload 9
    //   581: ldc_w 2336
    //   584: iload_3
    //   585: invokeinterface 2330 3 0
    //   590: pop
    //   591: aload 9
    //   593: invokeinterface 2333 1 0
    //   598: aload_0
    //   599: getfield 323	com/whatsapp/data/ad:Y	Lcom/whatsapp/data/cr;
    //   602: invokevirtual 2341	com/whatsapp/data/cr:c	()V
    //   605: aload_0
    //   606: getfield 311	com/whatsapp/data/ad:U	Lcom/whatsapp/data/u;
    //   609: invokevirtual 1949	com/whatsapp/data/u:b	()Z
    //   612: ifne +105 -> 717
    //   615: aload_0
    //   616: getfield 263	com/whatsapp/data/ad:J	Landroid/content/Context;
    //   619: ldc_w 2300
    //   622: iconst_0
    //   623: invokevirtual 2304	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   626: astore 9
    //   628: aload 9
    //   630: ldc_w 2343
    //   633: iconst_0
    //   634: invokeinterface 2311 3 0
    //   639: istore_3
    //   640: iload_3
    //   641: iconst_5
    //   642: if_icmpge +75 -> 717
    //   645: aload 9
    //   647: ldc_w 2345
    //   650: lconst_0
    //   651: invokeinterface 2316 4 0
    //   656: lstore 5
    //   658: aload_0
    //   659: getfield 317	com/whatsapp/data/ad:v	Lcom/whatsapp/data/cj;
    //   662: ldc_w 2347
    //   665: invokevirtual 2320	com/whatsapp/data/cj:b	(Ljava/lang/String;)J
    //   668: lstore 7
    //   670: aload 9
    //   672: invokeinterface 2324 1 0
    //   677: astore 9
    //   679: lload 7
    //   681: lload 5
    //   683: lcmp
    //   684: ifne +112 -> 796
    //   687: iload_3
    //   688: iconst_1
    //   689: iadd
    //   690: istore_3
    //   691: aload 9
    //   693: ldc_w 2343
    //   696: iload_3
    //   697: invokeinterface 2330 3 0
    //   702: pop
    //   703: aload 9
    //   705: invokeinterface 2333 1 0
    //   710: aload_0
    //   711: getfield 311	com/whatsapp/data/ad:U	Lcom/whatsapp/data/u;
    //   714: invokevirtual 2348	com/whatsapp/data/u:c	()V
    //   717: aload_0
    //   718: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   721: invokevirtual 460	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   724: aload 11
    //   726: invokeinterface 2292 1 0
    //   731: aload_2
    //   732: areturn
    //   733: astore_2
    //   734: aload_0
    //   735: getfield 379	com/whatsapp/data/ad:h	Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   738: invokevirtual 2003	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:isHeldByCurrentThread	()Z
    //   741: ifeq +17 -> 758
    //   744: aload_0
    //   745: getfield 379	com/whatsapp/data/ad:h	Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   748: invokevirtual 2291	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   751: aload 12
    //   753: invokeinterface 2292 1 0
    //   758: aload_2
    //   759: athrow
    //   760: aload 9
    //   762: ldc_w 2313
    //   765: lload 7
    //   767: invokeinterface 2352 4 0
    //   772: pop
    //   773: iconst_0
    //   774: istore_3
    //   775: goto -314 -> 461
    //   778: aload 9
    //   780: ldc_w 2338
    //   783: lload 7
    //   785: invokeinterface 2352 4 0
    //   790: pop
    //   791: iconst_0
    //   792: istore_3
    //   793: goto -214 -> 579
    //   796: aload 9
    //   798: ldc_w 2345
    //   801: lload 7
    //   803: invokeinterface 2352 4 0
    //   808: pop
    //   809: iload 4
    //   811: istore_3
    //   812: goto -121 -> 691
    //   815: astore_2
    //   816: aload_0
    //   817: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   820: invokevirtual 460	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   823: aload_2
    //   824: athrow
    //   825: ldc_w 1031
    //   828: astore 9
    //   830: goto -619 -> 211
    //   833: iconst_0
    //   834: istore_1
    //   835: goto -605 -> 230
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	838	0	this	ad
    //   0	838	1	paramBoolean	boolean
    //   0	838	2	parama	com.whatsapp.gdrive.ch.a<Void, Integer>
    //   146	666	3	i1	int
    //   1	809	4	i2	int
    //   426	256	5	l1	long
    //   438	364	7	l2	long
    //   24	805	9	localObject	Object
    //   32	300	10	localc	c
    //   40	685	11	locald1	com.whatsapp.k.d
    //   48	704	12	locald2	com.whatsapp.k.d
    //   161	51	13	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   244	259	323	java/lang/Exception
    //   71	126	733	finally
    //   130	140	733	finally
    //   147	163	733	finally
    //   168	211	733	finally
    //   211	224	733	finally
    //   230	244	733	finally
    //   244	259	733	finally
    //   259	285	733	finally
    //   314	320	733	finally
    //   324	331	733	finally
    //   337	344	733	finally
    //   375	410	815	finally
    //   415	449	815	finally
    //   461	487	815	finally
    //   487	528	815	finally
    //   533	567	815	finally
    //   579	605	815	finally
    //   605	640	815	finally
    //   645	679	815	finally
    //   691	717	815	finally
    //   760	773	815	finally
    //   778	791	815	finally
    //   796	809	815	finally
  }
  
  public final e a(String paramString, long paramLong, int paramInt)
  {
    int i1;
    if ((!cs.e(paramString)) && (!qz.e(paramString)))
    {
      i1 = 1;
      if ((paramLong != 1L) || (!this.b.d)) {
        break label204;
      }
      localObject2 = new StringBuilder("SELECT key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, raw_data, recipient_count, participant_hash, starred, quoted_row_id, mentioned_jids, multicast_id, edit_version, receipt_server_timestamp, media_enc_hash, _id FROM messages WHERE key_remote_jid=? ");
      if (i1 == 0) {
        break label186;
      }
    }
    label186:
    for (Object localObject1 = "AND media_wa_type!=8 ";; localObject1 = "")
    {
      localObject2 = (String)localObject1 + "ORDER BY _id DESC LIMIT " + paramInt;
      localObject1 = new bd("msgstore/messages/indexed " + paramString);
      this.i.lock();
      try
      {
        paramString = this.b.getReadableDatabase().rawQuery((String)localObject2, new String[] { paramString });
        if (paramString.moveToLast()) {
          paramLong = paramString.getLong(29);
        }
        paramString.moveToFirst();
        this.i.unlock();
        ((bd)localObject1).b();
        return new e(paramLong, paramString);
      }
      finally
      {
        this.i.unlock();
      }
      i1 = 0;
      break;
    }
    label204:
    long l1 = paramLong;
    if (paramLong == 1L) {
      l1 = c(paramString, paramLong, paramInt);
    }
    Object localObject2 = new StringBuilder("SELECT key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, raw_data, recipient_count, participant_hash, starred, quoted_row_id, mentioned_jids, multicast_id, edit_version, receipt_server_timestamp, media_enc_hash, _id FROM messages WHERE key_remote_jid=? ");
    if (i1 != 0) {}
    for (localObject1 = "AND media_wa_type!=8 ";; localObject1 = "")
    {
      localObject2 = (String)localObject1 + "AND _id>=? ORDER BY _id DESC";
      localObject1 = new bd("msgstore/messages " + paramString);
      this.i.lock();
      try
      {
        paramString = this.b.getReadableDatabase().rawQuery((String)localObject2, new String[] { paramString, String.valueOf(l1) });
        this.i.unlock();
        ((bd)localObject1).b();
        paramLong = l1;
      }
      finally
      {
        this.i.unlock();
      }
    }
  }
  
  public final ch.a a(boolean paramBoolean1, boolean paramBoolean2, cb.c paramc)
  {
    int i2 = 1;
    cb localcb = this.c;
    localcb.e = paramc;
    this.M.writeLock().lock();
    for (;;)
    {
      Object localObject;
      try
      {
        Log.i("msgstore-manager/initialize");
        try
        {
          if (this.z.d) {
            break label478;
          }
          b();
          if (paramBoolean1)
          {
            i1 = localcb.d();
            if (paramBoolean1)
            {
              i1 = i1 * 100 / (i1 + 1);
              if (!paramBoolean1) {
                break label455;
              }
              paramc = localcb.e();
              com.whatsapp.fieldstats.l.a(localcb.c, 877, Long.valueOf(paramc.size()));
              a.a.a.a.d.a(localcb.c, Boolean.valueOf(vv.i()));
              if (paramc.size() > 0) {
                continue;
              }
              Log.i("msgstore/restore/backupfiles/none-found");
              a.a.a.a.d.c(localcb.c, Boolean.valueOf(false));
              a.a.a.a.d.d(localcb.c, Boolean.valueOf(false));
              paramc = ch.a.a;
              if ((paramc != ch.a.b) || (this.b.getWritableDatabase() == null)) {
                break label496;
              }
              i1 = i2;
              if (i1 == 0) {
                break label402;
              }
              this.w.b();
              this.b.b();
              this.b.d();
              this.b.c();
              this.z.d = true;
              return paramc;
            }
          }
          else
          {
            i1 = 0;
            continue;
          }
          i1 = 0;
          continue;
          localObject = paramc.iterator();
          if (((Iterator)localObject).hasNext())
          {
            File localFile = (File)((Iterator)localObject).next();
            Log.i("msgstore/restore/backupfiles " + localFile.getName() + " (" + localFile.length() + ")");
            continue;
            paramc = finally;
          }
        }
        finally {}
        localObject = localcb.f.getParentFile();
      }
      finally
      {
        this.M.writeLock().unlock();
      }
      if (!((File)localObject).exists())
      {
        Log.d("msgstore/restore/createinternaldir");
        if (!((File)localObject).mkdirs()) {
          Log.w("msgstore/restore/createinternaldir failed");
        }
      }
      for (;;)
      {
        paramc = localcb.a(this, i1, paramc);
        break;
        a.a.a.a.d.d(localcb.f);
      }
      label402:
      if (paramBoolean2)
      {
        Log.i("msgstore-manager/initialize/re-creating db");
        r();
        Log.i("msgstore-manager/initialize/db recreated");
        paramc = ch.a.c;
        this.M.writeLock().unlock();
        return paramc;
      }
      this.M.writeLock().unlock();
      return paramc;
      label455:
      r();
      paramc = ch.a.c;
      this.M.writeLock().unlock();
      return paramc;
      label478:
      paramc = ch.a.a;
      this.M.writeLock().unlock();
      return paramc;
      label496:
      int i1 = 0;
    }
  }
  
  public final j a(String paramString, int paramInt)
  {
    Object localObject1 = null;
    if ((paramString == null) || (paramInt < 0)) {
      return null;
    }
    Object localObject2 = "SELECT key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, raw_data, recipient_count, participant_hash, starred, quoted_row_id, mentioned_jids, multicast_id, edit_version, receipt_server_timestamp, media_enc_hash, _id FROM messages WHERE key_remote_jid=?  AND media_wa_type!=8 ORDER BY _id DESC LIMIT " + paramInt;
    this.i.lock();
    try
    {
      localObject2 = this.b.getReadableDatabase().rawQuery((String)localObject2, new String[] { paramString });
      this.i.unlock();
      if (localObject2 == null)
      {
        Log.i("msgstore/get/nth no message: " + paramString + " " + paramInt);
        return null;
      }
    }
    finally
    {
      this.i.unlock();
    }
    if (((Cursor)localObject2).moveToLast()) {}
    for (paramString = this.t.a((Cursor)localObject2, paramString);; paramString = (String)localObject1)
    {
      ((Cursor)localObject2).close();
      return paramString;
      Log.w("msgstore/get/nth can't get message: " + paramString + " " + paramInt);
    }
  }
  
  public final ArrayList<j> a(int paramInt1, int paramInt2, j paramj)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = Integer.toString(paramInt1);
    String str = Integer.toString(paramInt2);
    this.i.lock();
    for (;;)
    {
      try
      {
        SQLiteDatabase localSQLiteDatabase = this.b.getReadableDatabase();
        if (localSQLiteDatabase == null)
        {
          Log.e("msgstore/calls/db/unavailable");
          return localArrayList;
        }
        localObject = localSQLiteDatabase.rawQuery("SELECT key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, raw_data, recipient_count, participant_hash, starred, quoted_row_id, mentioned_jids, multicast_id, edit_version, receipt_server_timestamp, media_enc_hash, _id, key_remote_jid FROM messages WHERE media_wa_type=8 ORDER BY _id DESC LIMIT ?,?", new String[] { localObject, str });
        if (localObject == null) {
          break label232;
        }
        paramInt1 = ((Cursor)localObject).getColumnIndex("key_remote_jid");
        try
        {
          if ((!((Cursor)localObject).moveToNext()) || (paramj.a())) {
            break;
          }
          str = ((Cursor)localObject).getString(paramInt1);
          if (str == null)
          {
            Log.w("msgstore/calls/jid is null!");
            continue;
            paramj = finally;
          }
        }
        catch (SQLiteDiskIOException paramj)
        {
          a.a.a.a.d.h(this.J);
          throw paramj;
        }
        finally
        {
          ((Cursor)localObject).close();
        }
        localArrayList.add(this.t.a((Cursor)localObject, str));
      }
      finally
      {
        this.i.unlock();
      }
    }
    ((Cursor)localObject).close();
    for (;;)
    {
      this.i.unlock();
      Log.i("msgstore/calls/size:" + localArrayList.size());
      return localArrayList;
      label232:
      Log.e("msgstore/calls/db/cursor is null");
    }
  }
  
  public final ArrayList<j> a(long paramLong)
  {
    localbd = new bd();
    localbd.a("msgstore/getRetryAutodownloadMessages");
    localArrayList = new ArrayList();
    paramLong = d(paramLong);
    localCursor = this.b.getReadableDatabase().rawQuery("SELECT key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, raw_data, recipient_count, participant_hash, starred, quoted_row_id, mentioned_jids, multicast_id, edit_version, receipt_server_timestamp, media_enc_hash, _id, key_remote_jid FROM messages WHERE  +media_wa_type in ('2' , '1' , '3' , '13' , '9' ) AND key_from_me=0 AND _id>? ORDER BY _id ASC", new String[] { Long.toString(paramLong) });
    for (;;)
    {
      try
      {
        i1 = localCursor.getColumnIndex("key_remote_jid");
        if (localCursor == null) {
          continue;
        }
      }
      catch (IllegalStateException localIllegalStateException)
      {
        int i1;
        String str;
        Log.i("msgstore/getRetryAutodownloadMessages/IllegalStateException " + localIllegalStateException);
        if (localCursor == null) {
          continue;
        }
        localCursor.close();
        Log.i("msgstore/getRetryAutodownloadMessages " + localArrayList.size() + " | time spent:" + localbd.b());
        return localArrayList;
        j localj = this.t.a(localCursor, localIllegalStateException);
        if (localj.b() == null) {
          continue;
        }
        MediaData localMediaData = localj.b();
        if ((localMediaData.transferred) || (localMediaData.transferring) || (!localMediaData.autodownloadRetryEnabled)) {
          continue;
        }
        localArrayList.add(localj);
        int i2 = localArrayList.size();
        if (i2 < 32) {
          continue;
        }
        if (localCursor == null) {
          continue;
        }
        localCursor.close();
        continue;
      }
      catch (SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException)
      {
        Log.e(localSQLiteDatabaseCorruptException);
        a(localSQLiteDatabaseCorruptException);
        if (localCursor == null) {
          continue;
        }
        localCursor.close();
        continue;
      }
      catch (SQLiteDiskIOException localSQLiteDiskIOException)
      {
        a.a.a.a.d.h(this.J);
        throw localSQLiteDiskIOException;
      }
      finally
      {
        if (localCursor == null) {
          continue;
        }
        localCursor.close();
      }
      if (!localCursor.moveToNext()) {
        continue;
      }
      str = localCursor.getString(i1);
      if (str != null) {
        continue;
      }
      Log.w("msgstore/getRetryAutodownloadMessages/jid is null!");
    }
  }
  
  public final ArrayList<j> a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (this.r.b()) {
      return b(paramString1, paramInt1, paramInt2, paramString2);
    }
    return new ArrayList();
  }
  
  /* Error */
  public final ArrayList<j> a(String paramString, int paramInt, j paramj)
  {
    // Byte code:
    //   0: new 162	java/lang/StringBuilder
    //   3: dup
    //   4: ldc_w 2464
    //   7: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   10: aload_1
    //   11: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: ldc_w 2466
    //   17: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: iload_2
    //   21: invokevirtual 1120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   24: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokestatic 474	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   30: new 411	com/whatsapp/util/bd
    //   33: dup
    //   34: invokespecial 1734	com/whatsapp/util/bd:<init>	()V
    //   37: astore 6
    //   39: aload 6
    //   41: ldc_w 2468
    //   44: invokevirtual 1738	com/whatsapp/util/bd:a	(Ljava/lang/String;)V
    //   47: new 955	java/util/ArrayList
    //   50: dup
    //   51: invokespecial 956	java/util/ArrayList:<init>	()V
    //   54: astore 7
    //   56: aload_0
    //   57: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   60: invokevirtual 419	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   63: aload_0
    //   64: getfield 361	com/whatsapp/data/ad:b	Lcom/whatsapp/data/n;
    //   67: invokevirtual 425	com/whatsapp/data/n:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   70: ldc_w 2174
    //   73: iconst_1
    //   74: anewarray 429	java/lang/String
    //   77: dup
    //   78: iconst_0
    //   79: aload_1
    //   80: aastore
    //   81: invokevirtual 435	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   84: astore 5
    //   86: aload 5
    //   88: ifnull +181 -> 269
    //   91: aload 5
    //   93: invokeinterface 441 1 0
    //   98: ifeq +119 -> 217
    //   101: aload_3
    //   102: ifnull +12 -> 114
    //   105: aload_3
    //   106: invokeinterface 2175 1 0
    //   111: ifne +106 -> 217
    //   114: aload_0
    //   115: getfield 307	com/whatsapp/data/ad:t	Lcom/whatsapp/data/l;
    //   118: aload 5
    //   120: aload_1
    //   121: invokevirtual 446	com/whatsapp/data/l:a	(Landroid/database/Cursor;Ljava/lang/String;)Lcom/whatsapp/protocol/j;
    //   124: astore 8
    //   126: aload 8
    //   128: invokevirtual 877	com/whatsapp/protocol/j:b	()Lcom/whatsapp/MediaData;
    //   131: ifnull -40 -> 91
    //   134: aload 8
    //   136: invokevirtual 877	com/whatsapp/protocol/j:b	()Lcom/whatsapp/MediaData;
    //   139: astore 9
    //   141: aload 8
    //   143: getfield 849	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   146: getfield 853	com/whatsapp/protocol/j$b:b	Z
    //   149: ifne +11 -> 160
    //   152: aload 9
    //   154: getfield 882	com/whatsapp/MediaData:transferred	Z
    //   157: ifeq -66 -> 91
    //   160: aload 9
    //   162: getfield 1612	com/whatsapp/MediaData:file	Ljava/io/File;
    //   165: ifnull -74 -> 91
    //   168: new 1287	java/io/File
    //   171: dup
    //   172: aload 9
    //   174: getfield 1612	com/whatsapp/MediaData:file	Ljava/io/File;
    //   177: invokestatic 2181	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   180: invokevirtual 2184	android/net/Uri:getPath	()Ljava/lang/String;
    //   183: invokespecial 2185	java/io/File:<init>	(Ljava/lang/String;)V
    //   186: invokevirtual 1658	java/io/File:exists	()Z
    //   189: ifeq -98 -> 91
    //   192: aload 7
    //   194: aload 8
    //   196: invokevirtual 982	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   199: pop
    //   200: iload_2
    //   201: iflt -110 -> 91
    //   204: aload 7
    //   206: invokevirtual 965	java/util/ArrayList:size	()I
    //   209: istore 4
    //   211: iload 4
    //   213: iload_2
    //   214: if_icmplt -123 -> 91
    //   217: aload 5
    //   219: ifnull +10 -> 229
    //   222: aload 5
    //   224: invokeinterface 457 1 0
    //   229: aload_0
    //   230: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   233: invokevirtual 460	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   236: aload 6
    //   238: invokevirtual 467	com/whatsapp/util/bd:b	()J
    //   241: pop2
    //   242: new 162	java/lang/StringBuilder
    //   245: dup
    //   246: ldc_w 2470
    //   249: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   252: aload 7
    //   254: invokevirtual 965	java/util/ArrayList:size	()I
    //   257: invokevirtual 1120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   260: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: invokestatic 474	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   266: aload 7
    //   268: areturn
    //   269: ldc_w 2472
    //   272: invokestatic 509	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   275: goto -58 -> 217
    //   278: astore_1
    //   279: aload_0
    //   280: getfield 263	com/whatsapp/data/ad:J	Landroid/content/Context;
    //   283: invokestatic 454	a/a/a/a/d:h	(Landroid/content/Context;)V
    //   286: aload_1
    //   287: athrow
    //   288: astore_1
    //   289: aload 5
    //   291: ifnull +10 -> 301
    //   294: aload 5
    //   296: invokeinterface 457 1 0
    //   301: aload_1
    //   302: athrow
    //   303: astore_1
    //   304: aload_0
    //   305: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   308: invokevirtual 460	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   311: aload_1
    //   312: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	313	0	this	ad
    //   0	313	1	paramString	String
    //   0	313	2	paramInt	int
    //   0	313	3	paramj	j
    //   209	6	4	i1	int
    //   84	211	5	localCursor	Cursor
    //   37	200	6	localbd	bd
    //   54	213	7	localArrayList	ArrayList
    //   124	71	8	localj	j
    //   139	34	9	localMediaData	MediaData
    // Exception table:
    //   from	to	target	type
    //   91	101	278	android/database/sqlite/SQLiteDiskIOException
    //   105	114	278	android/database/sqlite/SQLiteDiskIOException
    //   114	160	278	android/database/sqlite/SQLiteDiskIOException
    //   160	200	278	android/database/sqlite/SQLiteDiskIOException
    //   204	211	278	android/database/sqlite/SQLiteDiskIOException
    //   269	275	278	android/database/sqlite/SQLiteDiskIOException
    //   91	101	288	finally
    //   105	114	288	finally
    //   114	160	288	finally
    //   160	200	288	finally
    //   204	211	288	finally
    //   269	275	288	finally
    //   279	288	288	finally
    //   63	86	303	finally
    //   222	229	303	finally
    //   294	301	303	finally
    //   301	303	303	finally
  }
  
  public final List<j> a(j.b paramb, int paramInt, String paramString)
  {
    long l1 = e(this.t.a(paramb));
    if (l1 == 1L)
    {
      Log.i("msgstore/get/previous no id for " + paramb);
      return null;
    }
    Object localObject1;
    if ("document".equals(paramString)) {
      localObject1 = "SELECT key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, raw_data, recipient_count, participant_hash, starred, quoted_row_id, mentioned_jids, multicast_id, edit_version, receipt_server_timestamp, media_enc_hash, _id FROM messages WHERE  media_wa_type=9 AND key_remote_jid=? ";
    }
    for (;;)
    {
      paramString = (String)localObject1 + "AND _id<? ORDER BY _id DESC LIMIT " + paramInt;
      localObject1 = paramb.a;
      this.i.lock();
      try
      {
        localObject1 = this.b.getReadableDatabase().rawQuery(paramString, new String[] { localObject1, String.valueOf(l1) });
        this.i.unlock();
        if (localObject1 != null)
        {
          paramString = new LinkedList();
          for (;;)
          {
            if (((Cursor)localObject1).moveToNext())
            {
              Object localObject2 = this.t.a((Cursor)localObject1, paramb.a);
              if (localObject2 != null)
              {
                paramString.addFirst(localObject2);
                continue;
                if ("url".equals(paramString))
                {
                  localObject1 = "SELECT key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, raw_data, recipient_count, participant_hash, starred, quoted_row_id, mentioned_jids, multicast_id, edit_version, receipt_server_timestamp, media_enc_hash, _id, links.link_index AS link_index FROM messages, (SELECT message_row_id, link_index FROM messages_links WHERE messages_links.key_remote_jid=?) links WHERE messages._id = links.message_row_id ";
                  break;
                }
                if ("all_media".equals(paramString))
                {
                  localObject1 = "SELECT key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, raw_data, recipient_count, participant_hash, starred, quoted_row_id, mentioned_jids, multicast_id, edit_version, receipt_server_timestamp, media_enc_hash, _id FROM messages WHERE  media_wa_type in ('2' , '1' , '3' , '13' ) AND (origin IS NULL OR origin!=1) AND key_remote_jid=? ";
                  break;
                }
                int i1;
                if ((!cs.e(paramb.a)) && (!qz.e(paramb.a)))
                {
                  i1 = 1;
                  label244:
                  localObject2 = new StringBuilder("SELECT key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, raw_data, recipient_count, participant_hash, starred, quoted_row_id, mentioned_jids, multicast_id, edit_version, receipt_server_timestamp, media_enc_hash, _id FROM messages WHERE key_remote_jid=? ");
                  if (i1 == 0) {
                    break label319;
                  }
                }
                label319:
                for (localObject1 = "AND media_wa_type!=8 ";; localObject1 = "")
                {
                  localObject2 = (String)localObject1;
                  localObject1 = localObject2;
                  if (paramString == null) {
                    break;
                  }
                  Log.w("msgstore/get/previous unexpected type string=" + paramString);
                  localObject1 = localObject2;
                  break;
                  i1 = 0;
                  break label244;
                }
              }
            }
          }
          paramb = paramString;
        }
      }
      finally
      {
        this.i.unlock();
      }
    }
    for (;;)
    {
      return paramb;
      Log.i("msgstore/get/previous cursor null " + paramb);
      paramb = null;
    }
  }
  
  public final List<j> a(String paramString1, j.b paramb, int paramInt, String paramString2)
  {
    int i3 = 0;
    for (;;)
    {
      int i1;
      try
      {
        ArrayList localArrayList = new ArrayList();
        if (paramString1 != null)
        {
          if ("gif".equals(paramString2))
          {
            paramString1 = y(paramString1);
            break label210;
            if ((paramString1.moveToNext()) && (i3 < paramInt))
            {
              paramString2 = paramString1.getString(paramString1.getColumnIndex("key_remote_jid"));
              paramString2 = this.t.a(paramString1, paramString2);
              int i2 = i3;
              if (paramString2 != null)
              {
                i2 = i3;
                if (i1 != 0)
                {
                  localArrayList.add(paramString2);
                  i2 = i3 + 1;
                }
              }
              i3 = i2;
              if (i1 != 0) {
                continue;
              }
              i3 = i2;
              if (paramString2 == null) {
                continue;
              }
              i3 = i2;
              if (!paramString2.e.equals(paramb)) {
                continue;
              }
              i1 = 1;
              i3 = i2;
              continue;
            }
          }
          else
          {
            paramString1 = a(paramString1, null, null);
            break label210;
          }
        }
        else
        {
          if ("gif".equals(paramString2))
          {
            paramString1 = u();
            break label210;
          }
          paramString1 = a(null, null);
          break label210;
          i1 = 0;
          continue;
        }
        return localArrayList;
      }
      catch (Exception paramString1)
      {
        return null;
      }
      label210:
      if (paramb == null) {
        i1 = 1;
      }
    }
  }
  
  public final List<j> a(String paramString1, j.b paramb, Integer paramInteger, String paramString2)
  {
    paramb = b(paramString1, paramb, paramInteger, paramString2);
    if (paramb == null) {
      return null;
    }
    paramInteger = new ArrayList();
    try
    {
      while (paramb.moveToNext())
      {
        paramString2 = this.t.a(paramb, paramString1);
        if (paramString2 != null) {
          paramInteger.add(paramString2);
        }
      }
    }
    finally
    {
      paramb.close();
    }
    return paramInteger;
  }
  
  public final Map<j.b, i> a(j.b paramb)
  {
    Log.i("msgstore/get/receipts/newer " + paramb);
    HashMap localHashMap = new HashMap();
    long l1 = e(this.t.a(paramb));
    if (l1 == 1L) {
      Log.i("msgstore/get/receipts/newer no id for " + paramb);
    }
    Object localObject;
    do
    {
      return localHashMap;
      localObject = paramb.a;
      localObject = this.b.getReadableDatabase().rawQuery(ak, new String[] { localObject, String.valueOf(l1) });
    } while (localObject == null);
    for (;;)
    {
      try
      {
        if (!((Cursor)localObject).moveToNext()) {
          break;
        }
        i locali = new i();
        String str = ((Cursor)localObject).getString(0);
        boolean bool;
        if (((Cursor)localObject).getLong(1) > 0L)
        {
          bool = true;
          locali.a = ((Cursor)localObject).getLong(2);
          locali.b = ((Cursor)localObject).getLong(3);
          locali.c = ((Cursor)localObject).getLong(4);
          locali.d = ((Cursor)localObject).getLong(5);
          int i1 = ((Cursor)localObject).getInt(6);
          if ((bool) || (j.b(i1))) {
            localHashMap.put(new j.b(paramb.a, bool, str), locali);
          }
        }
        else
        {
          bool = false;
        }
      }
      finally
      {
        ((Cursor)localObject).close();
      }
    }
    ((Cursor)localObject).close();
    return localHashMap;
  }
  
  final void a(int paramInt, j paramj, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    if (paramj.y == null) {
      Log.e("msgstore/revoke/missing-old-id " + paramj.e + " from=" + paramj.f);
    }
    do
    {
      return;
      Object localObject1 = new j.b(paramj.e.a, paramj.e.b, paramj.y);
      Log.d("msgstore/revoke/ old=" + localObject1 + " new=" + paramj.e);
      Object localObject2 = this.t.a(paramj.e);
      if (localObject2 != null)
      {
        Log.w("msgstore/revoking/has-placeholder " + ((j)localObject2).e);
        a((j)localObject2, true, true, false);
      }
      localObject1 = this.t.a((j.b)localObject1);
      if ((localObject1 != null) && (((((j)localObject1).f == null) && (paramj.f == null)) || ((((j)localObject1).f != null) && (((j)localObject1).f.equals(paramj.f)))))
      {
        long l1 = this.j.b();
        if ((j.c(((j)localObject1).e.a)) && (!((j)localObject1).e.b))
        {
          localObject2 = ((j)localObject1).b();
          if (localObject2 != null)
          {
            localObject2 = ((MediaData)localObject2).downloader;
            if (localObject2 != null) {
              ((vk)localObject2).b();
            }
          }
          a((j)localObject1, true, false, true);
          this.P.a(this, paramj);
          this.p.e.post(at.a(this, (j)localObject1, paramj));
        }
        while (((j)localObject1).e.b)
        {
          paramj = new bl();
          paramj.a = Integer.valueOf(a.a.a.a.d.b((j)localObject1));
          paramj.b = Integer.valueOf(a.a.a.a.d.a((j)localObject1));
          paramj.c = Long.valueOf((l1 - ((j)localObject1).n) / 1000L);
          com.whatsapp.fieldstats.l.b(com.whatsapp.u.a(), paramj);
          return;
          if (paramj.s == 15)
          {
            paramj.g = ((j)localObject1).g;
            paramj.Q = ((j)localObject1).Q;
            paramj.n = ((j)localObject1).n;
            if (this.l.a(paramj.e.a)) {
              paramj.d = 13;
            }
            a(paramj, (j)localObject1, paramBoolean2);
            Message.obtain(this.p.c, 5, paramInt, 0, paramj).sendToTarget();
            this.p.e.post(au.a(this, (j)localObject1));
            this.p.d.post(av.a(this, paramj));
            z(paramj.e.a);
          }
        }
        if (!paramBoolean1) {}
        for (paramBoolean1 = bool;; paramBoolean1 = false)
        {
          paramj = new bh();
          paramj.a = Integer.valueOf(a.a.a.a.d.b((j)localObject1));
          paramj.b = Integer.valueOf(a.a.a.a.d.a((j)localObject1));
          paramj.c = Long.valueOf((l1 - ((j)localObject1).n) / 1000L);
          paramj.d = Boolean.valueOf(paramBoolean1);
          com.whatsapp.fieldstats.l.b(com.whatsapp.u.a(), paramj);
          return;
        }
      }
    } while (!paramBoolean1);
    d(paramj);
    this.P.a(this, paramj);
  }
  
  public final void a(j.b paramb, int paramInt, com.whatsapp.util.au<j> paramau)
  {
    this.d.post(af.a(this, paramb, paramInt, paramau));
  }
  
  public final void a(j paramj)
  {
    if ((com.whatsapp.util.a.d()) && (paramj.z != null) && (paramj.z.contains("­"))) {
      paramj.z = paramj.z.replace("­", "");
    }
    if (paramj.a())
    {
      a(paramj, -1);
      return;
    }
    if ((com.whatsapp.util.a.d()) && (paramj.d()) && (paramj.m == 0) && (paramj.e().contains("­"))) {
      paramj.e(paramj.e().replace("­", ""));
    }
    if ((!i(paramj)) && (!B(paramj.e.a)))
    {
      if (this.n.a(paramj.e.a)) {
        break label207;
      }
      if ((!qz.e(paramj.e.a)) || (this.E.b(paramj.e.a))) {
        a(paramj.e.a, paramj.i(), paramj.Y);
      }
    }
    for (;;)
    {
      c(paramj, -1);
      a(paramj, -1);
      return;
      label207:
      if (w(paramj.e.a) == 1L) {
        q(paramj.e.a);
      }
    }
  }
  
  final void a(j paramj, int paramInt)
  {
    int i1 = 0;
    this.i.lock();
    label244:
    label423:
    label523:
    label528:
    label538:
    label543:
    label544:
    for (;;)
    {
      Object localObject1;
      try
      {
        localObject1 = g(paramj, 1);
        if (((a)localObject1).a)
        {
          if ((paramj.e.b) && (com.whatsapp.protocol.s.a(paramj.d, 4) < 0)) {
            this.g.put(paramj.e, paramj);
          }
          if (((a)localObject1).b)
          {
            Message.obtain(this.p.c, 4, paramInt, 0, paramj).sendToTarget();
            return;
          }
          Message.obtain(this.p.c, 5, paramInt, 0, paramj).sendToTarget();
          if (!((a)localObject1).d) {
            continue;
          }
          Message.obtain(this.p.c, 6, paramInt, 0, paramj).sendToTarget();
          continue;
        }
        if (!((a)localObject1).c) {
          continue;
        }
      }
      finally
      {
        this.i.unlock();
      }
      if (!paramj.e.b)
      {
        localObject1 = this.t.a(paramj.e);
        if (((j)localObject1).s == 11)
        {
          Object localObject2;
          if (((j)localObject1).a())
          {
            paramj.n = ((j)localObject1).n;
            a((j)localObject1, true, false, false);
            g(paramj, 1);
            this.p.c.post(ap.a(this, paramj, paramInt));
            paramInt = 1;
            paramj.j();
            localObject1 = this.ae;
            if (!com.whatsapp.protocol.m.c(paramj)) {
              throw new IllegalArgumentException("message thumb not loaded");
            }
          }
          else
          {
            long l1 = ((j)localObject1).Q;
            long l2 = ((j)localObject1).n;
            ((j)localObject1).a(paramj);
            ((j)localObject1).Q = l1;
            ((j)localObject1).n = l2;
            if (!d((j)localObject1, 5)) {
              break label528;
            }
            this.p.a((j)localObject1, 5);
            localObject2 = ((j)localObject1).e.a;
            this.p.d.post(ba.a(this, (String)localObject2));
            if (!this.P.a((String)localObject2)) {
              break label523;
            }
            localObject2 = (d)this.n.a.get(localObject2);
            if (((localObject2 == null) || (((d)localObject2).c < ((j)localObject1).Q)) && (((j)localObject1).d != 13)) {
              break label523;
            }
            ado.a(this, this.o, (j)localObject1);
            paramInt = 1;
            if (paramInt != 0) {
              break label538;
            }
            this.P.a(this, (j)localObject1);
            break label538;
          }
          if (auj.c())
          {
            localObject2 = new ArrayList(1);
            ((List)localObject2).add(paramj);
            ((ae)localObject1).a(null, (List)localObject2, 4, false, false, null, null, 4, null, null);
            i1 = 1;
          }
          if (i1 == 0) {
            break label543;
          }
          z(paramj.e.a);
          break label543;
        }
      }
      for (;;)
      {
        if (paramInt != 0) {
          break label544;
        }
        Message.obtain(this.p.c, 3, paramj).sendToTarget();
        break;
        paramInt = 0;
        break label423;
        paramInt = 0;
        break label244;
        paramInt = 0;
        continue;
        paramInt = 1;
        break label244;
      }
    }
  }
  
  public final void a(j paramj1, j paramj2, j paramj3, boolean paramBoolean1, boolean paramBoolean2)
  {
    Log.i("msgstore/setstatusreadreceiptssent/" + paramj1.f + " rrsent=" + paramBoolean1 + " notifyWeb=" + paramBoolean2);
    n localn = this.x.a(paramj1.f);
    if (localn == null) {
      Log.w("msgstore/setstatusreadreceiptssent/no status for " + paramj1.f);
    }
    do
    {
      return;
      paramj2 = localn.a(paramj1, paramj2, paramj3, paramBoolean1);
    } while (paramj2 == null);
    this.d.post(bi.a(this, paramBoolean1, paramj1, paramj2, paramBoolean2));
  }
  
  public final void a(j paramj, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("msgstore/edit/revoke ");
    Object localObject;
    if (paramj.e.b)
    {
      localObject = "send deleteMedia=" + paramBoolean;
      Log.i((String)localObject + " key=" + paramj.e);
      localObject = this.d;
      if (!paramBoolean) {
        break label101;
      }
    }
    label101:
    for (int i1 = 1;; i1 = 0)
    {
      Message.obtain((Handler)localObject, 14, -1, i1, paramj).sendToTarget();
      return;
      localObject = "recv";
      break;
    }
  }
  
  public final void a(String paramString)
  {
    this.i.lock();
    for (;;)
    {
      try
      {
        SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("starred", Integer.valueOf(0));
        Object localObject2 = new StringBuilder("starred=?");
        if (paramString == null) {
          continue;
        }
        localObject1 = " AND key_remote_jid=?";
        localObject2 = (String)localObject1;
        if (paramString == null) {
          continue;
        }
        localObject1 = new String[2];
        localObject1[0] = "1";
        localObject1[1] = paramString;
        int i1 = localSQLiteDatabase.update("messages", localContentValues, (String)localObject2, (String[])localObject1);
        if (i1 != 0) {
          Log.i("msgstore/unstarall:  " + i1);
        }
      }
      catch (SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException)
      {
        Object localObject1;
        Log.e(localSQLiteDatabaseCorruptException);
        a(new AssertionError(localSQLiteDatabaseCorruptException));
        continue;
      }
      finally
      {
        this.i.unlock();
      }
      this.y.a(new ah(paramString));
      this.i.unlock();
      this.p.d.post(ai.a(this, paramString));
      return;
      localObject1 = "";
      continue;
      localObject1 = new String[1];
      localObject1[0] = "1";
    }
  }
  
  public final void a(String paramString, int paramInt, Long paramLong)
  {
    if (e.b(paramString)) {
      return;
    }
    j localj = new j(this.l, paramString, null);
    localj.n = this.j.b();
    localj.d = 6;
    localj.t = 19L;
    localj.X = paramInt;
    localj.Y = paramLong;
    this.k.a(bc.a(this, localj));
    a(localj, -1);
    Log.i("added plaintext disabled message; jid=" + paramString);
  }
  
  public final void a(String paramString, long paramLong)
  {
    Log.i("msgstore/setchatreadreceiptssent/" + paramString + " " + paramLong);
    d locald = (d)this.n.a.get(paramString);
    if (locald == null) {
      Log.w("msgstore/setchatreadreceiptssent/no chat for " + paramString);
    }
    while (paramLong <= locald.d) {
      return;
    }
    locald.d = paramLong;
    this.d.post(ca.a(this, paramLong, paramString));
  }
  
  public final void a(String paramString, rf paramrf)
  {
    Log.i("msgstore/updateGroupParticipants/" + paramString + " " + paramrf);
    this.d.post(bf.a(this, paramrf, paramString));
  }
  
  public final void a(String paramString1, String paramString2)
  {
    Log.i("msgstore/updategroupchatsubject/" + paramString1);
    g localg = new g((byte)0);
    localg.a = paramString1;
    localg.b = paramString2;
    Message.obtain(this.d, 10, 0, 0, localg).sendToTarget();
  }
  
  public final void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    d locald = (d)this.n.a.get(paramString);
    if (locald == null) {
      Log.w("msgstore/archive/no chat " + paramString + " " + paramBoolean1);
    }
    do
    {
      return;
      if (locald.e == paramBoolean1)
      {
        Log.w("msgstore/archive/nop " + paramString + " " + paramBoolean1);
        return;
      }
      locald.e = paramBoolean1;
      this.B.b();
      this.d.post(am.a(this, paramBoolean1, paramString));
    } while (!paramBoolean2);
    if (paramBoolean1) {}
    for (int i1 = 3;; i1 = 4)
    {
      this.q.a(i1, paramString, 0L, 0);
      return;
    }
  }
  
  final <T extends Throwable> void a(T paramT)
  {
    a = true;
    b();
    throw paramT;
  }
  
  public final void a(Collection<j> paramCollection, boolean paramBoolean1, boolean paramBoolean2)
  {
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext()) {
      ((j)localIterator.next()).T = paramBoolean1;
    }
    this.d.post(ag.a(this, paramBoolean2, paramCollection, paramBoolean1));
  }
  
  final boolean a(j.b paramb, int paramInt, long paramLong)
  {
    int i1 = 0;
    if (!paramb.b)
    {
      Log.e("msgstore/receivedbyserver/error " + paramb.a + " " + paramb.c);
      return false;
    }
    j localj = this.t.a(paramb);
    if (localj == null)
    {
      Log.w("msgstore/receivedbyserver/nosuchmessage: " + paramb);
      return false;
    }
    if (com.whatsapp.protocol.s.a(localj.d, 4) >= 0)
    {
      Log.w("msgstore/receivedbyserver/statusdowngrade: " + paramb + " current:" + localj.d + " new:4");
      return false;
    }
    localj.d = 4;
    localj.I = paramLong;
    localj.F = paramInt;
    if (localj.a())
    {
      localObject = this.x.a("");
      paramInt = i1;
      if (localObject != null)
      {
        paramInt = i1;
        if (((n)localObject).b == localj.Q) {
          ((n)localObject).h = paramLong;
        }
      }
    }
    else
    {
      paramInt = 1;
    }
    long l1 = System.currentTimeMillis() - localj.n;
    Log.i("msgstore/receivedbyserver/receipt/server/delay " + l1 + " id=" + paramb.c);
    Object localObject = this.l;
    if (localj != null)
    {
      paramb = new ay();
      paramb.l = Double.valueOf(l1);
      paramb.c = Integer.valueOf(a.a.a.a.d.a(localj));
      paramb.b = Integer.valueOf(a.a.a.a.d.b(localj));
      if (paramb.b.intValue() == 1)
      {
        localObject = a.a.a.a.d.a((va)localObject, localj);
        if (localObject != null) {
          paramb.g = ((Boolean)localObject);
        }
      }
      paramb.h = Boolean.valueOf(TextUtils.isEmpty(localj.z));
      com.whatsapp.fieldstats.l.b(com.whatsapp.u.a(), paramb);
    }
    this.p.a(localj, -1);
    this.i.lock();
    for (;;)
    {
      try
      {
        this.w.b();
        if (cs.e(localj.e.a))
        {
          paramb = this.w.e;
          paramb.bindLong(1, localj.d);
          paramb.bindLong(2, paramLong);
          paramb.bindLong(3, localj.F);
          paramb.bindLong(4, localj.n);
          if (localj.e.b)
          {
            l1 = 1L;
            paramb.bindLong(5, l1);
            paramb.bindString(6, localj.e.c);
            paramb.execute();
            if (paramInt != 0)
            {
              paramb = new ContentValues(1);
              paramb.put("timestamp", Long.valueOf(paramLong));
              this.b.getWritableDatabase().update("status_list", paramb, "key_remote_jid=?", new String[] { "" });
            }
            if (cs.e(localj.e.a)) {
              this.y.a(new aj(localj));
            }
            return true;
          }
          l1 = 0L;
          continue;
        }
        paramb = this.w.d;
        paramb.bindLong(1, localj.d);
        paramb.bindLong(2, paramLong);
        paramb.bindLong(3, localj.F);
        paramb.bindString(4, localj.e.a);
        if (localj.e.b)
        {
          l1 = 1L;
          paramb.bindLong(5, l1);
          paramb.bindString(6, localj.e.c);
        }
        else
        {
          l1 = 0L;
        }
      }
      finally
      {
        this.i.unlock();
      }
    }
  }
  
  public final boolean a(j paramj, l paraml)
  {
    a.d.c();
    this.i.lock();
    for (;;)
    {
      try
      {
        MediaData localMediaData = paramj.b();
        File localFile;
        if (this.V.b(localMediaData.file.getAbsolutePath()) > 0)
        {
          localFile = MediaFileUtils.a(this.J, this.m, localMediaData.file, (byte)1, 2);
          MediaFileUtils.a(localMediaData.file, localFile);
          MediaView.6 local6 = paraml.a;
          boolean bool = paraml.b;
          paraml = paraml.c;
          Object localObject = MediaView.a(local6.c, localFile, bool);
          if (localObject == null) {
            break label291;
          }
          paraml.f().a((byte[])localObject);
          localObject = paraml.b();
          ((MediaData)localObject).fileSize = localFile.length();
          ((MediaData)localObject).faceX = 0;
          ((MediaData)localObject).faceY = 0;
          MediaFileUtils.b(localFile, (MediaData)localObject);
          MediaView.o(local6.c).b(paraml);
          i1 = 1;
          if (i1 == 0)
          {
            if ((localMediaData.file != localFile) && (!localFile.delete())) {
              Log.e("failed to delete " + localFile.getAbsolutePath());
            }
            return false;
          }
        }
        else
        {
          localFile = localMediaData.file;
          continue;
        }
        paraml = this.b.getWritableDatabase();
        paraml.beginTransaction();
        if (localMediaData.file != localFile)
        {
          b(paramj, false);
          localMediaData.file = localFile;
        }
        e(paramj, -1);
        paraml.setTransactionSuccessful();
        paraml.endTransaction();
        return true;
      }
      finally
      {
        this.i.unlock();
      }
      label291:
      int i1 = 0;
    }
  }
  
  public final boolean a(String paramString, boolean paramBoolean)
  {
    d locald = (d)this.n.a.get(paramString);
    if ((locald != null) && (locald.i != 1))
    {
      locald.i = 1;
      this.d.post(be.a(this, paramString));
    }
    for (boolean bool = true;; bool = false)
    {
      if ((locald != null) && (paramBoolean)) {
        this.q.a(9, paramString, 0L, 0);
      }
      return bool;
    }
  }
  
  public final long b(String paramString1, j paramj, boolean paramBoolean, String paramString2)
  {
    bd localbd = new bd("msgstore/like/searchforjid");
    long l1 = e(paramj);
    if (l1 == 1L)
    {
      Log.e("msgstore/like/searchforjid/startid < 0");
      return 0L;
    }
    String str = paramString2.replace("'", "''").replace("%", "\\%");
    paramj = "(data LIKE '%" + str + "%' ESCAPE '\\' AND media_wa_type=0) ";
    paramString2 = "(media_name LIKE '%" + str + "%' ESCAPE '\\' AND media_wa_type=5) ";
    str = "(media_caption LIKE '%" + str + "%' ESCAPE '\\' AND NOT media_wa_type=0) ";
    paramj = "(" + paramj + " OR " + paramString2 + " OR " + str + ")";
    paramj = "SELECT _id FROM messages WHERE key_remote_jid=? AND media_wa_type!=8 AND " + paramj;
    if (paramBoolean)
    {
      paramj = paramj + " AND _id<" + l1 + " ORDER BY _id DESC";
      paramj = paramj + " LIMIT 1";
      this.i.lock();
    }
    for (;;)
    {
      try
      {
        paramString1 = this.b.getReadableDatabase().rawQuery(paramj, new String[] { paramString1 });
        if (paramString1 != null)
        {
          try
          {
            if (!paramString1.moveToNext()) {
              break label426;
            }
            l1 = paramString1.getLong(paramString1.getColumnIndex("_id"));
            paramString1.close();
            return l1;
          }
          finally
          {
            paramString1.close();
          }
          paramj = paramj + " AND _id>" + l1 + " ORDER BY _id ASC";
          break;
        }
      }
      finally
      {
        this.i.unlock();
      }
      Log.e("msgstore/find/db/cursor is null");
      l1 = 0L;
      continue;
      label426:
      l1 = 0L;
    }
  }
  
  public final Cursor b(String paramString1, String paramString2, android.support.v4.d.a parama)
  {
    Log.d("msgstore/getUrlMessagesByTypeCursor:" + paramString1);
    this.i.lock();
    try
    {
      if (TextUtils.isEmpty(paramString2)) {}
      for (paramString2 = null; !TextUtils.isEmpty(paramString2); paramString2 = q.c(paramString2))
      {
        paramString1 = a("SELECT key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, raw_data, recipient_count, participant_hash, starred, quoted_row_id, mentioned_jids, multicast_id, edit_version, receipt_server_timestamp, media_enc_hash, _id, links.link_index AS link_index FROM messages, (SELECT message_row_id, link_index FROM messages_links WHERE messages_links.key_remote_jid=? AND message_row_id IN ( SELECT docid FROM messages_fts, messages WHERE content MATCH ? AND messages_fts.docid = messages._id)) links WHERE messages._id = links.message_row_id ORDER BY _id DESC", new String[] { paramString1, paramString2 }, parama);
        return paramString1;
      }
      paramString1 = a("SELECT key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, raw_data, recipient_count, participant_hash, starred, quoted_row_id, mentioned_jids, multicast_id, edit_version, receipt_server_timestamp, media_enc_hash, _id, links.link_index AS link_index FROM messages, (SELECT message_row_id, link_index FROM messages_links WHERE messages_links.key_remote_jid=?) links WHERE messages._id = links.message_row_id ORDER BY _id DESC", new String[] { paramString1 }, parama);
      return paramString1;
    }
    finally
    {
      this.i.unlock();
    }
  }
  
  public final e b(String paramString, long paramLong, int paramInt)
  {
    return a(paramString, c(paramString, paramLong, paramInt), paramInt);
  }
  
  public final ArrayList<j> b(String paramString, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if (paramInt == 1)
    {
      localObject = r(paramString);
      if (localObject != null) {}
    }
    label109:
    do
    {
      do
      {
        return localArrayList;
        if (((((j)localObject).e.b) && (!qz.a((j)localObject))) || (((j)localObject).s == 10)) {
          break label109;
        }
        if ((((j)localObject).s != 2) || (((j)localObject).o != 1)) {
          break;
        }
        paramString = ((j)localObject).b();
      } while ((paramString == null) || (!paramString.transferred));
      localArrayList.add(localObject);
      return localArrayList;
      localArrayList.add(localObject);
      return localArrayList;
      localObject = this.b.getReadableDatabase().rawQuery("SELECT key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, raw_data, recipient_count, participant_hash, starred, quoted_row_id, mentioned_jids, multicast_id, edit_version, receipt_server_timestamp, media_enc_hash, _id FROM messages WHERE key_remote_jid=? AND media_wa_type!=8 AND media_wa_type!=10 AND (key_from_me=0 OR (status=6 AND media_size=1) OR (status=6 AND media_size=4 AND media_duration=1) OR (status=6 AND media_size=12 AND media_duration=1)) ORDER BY _id DESC LIMIT " + paramInt, new String[] { paramString });
    } while (localObject == null);
    try
    {
      for (;;)
      {
        if (!((Cursor)localObject).moveToNext()) {
          break label288;
        }
        localj = this.t.a((Cursor)localObject, paramString);
        if (localj != null)
        {
          if ((localj.s != 2) || (localj.o != 1)) {
            break;
          }
          MediaData localMediaData = localj.b();
          if ((localMediaData != null) && (localMediaData.transferred)) {
            localArrayList.add(localj);
          }
        }
      }
    }
    catch (SQLiteDatabaseCorruptException paramString)
    {
      for (;;)
      {
        j localj;
        a(new AssertionError(paramString));
        return localArrayList;
        localArrayList.add(localj);
      }
    }
    catch (IllegalStateException paramString)
    {
      Log.i("msgstore/getlastmessagesfornotification/IllegalStateException " + paramString);
      return localArrayList;
      label288:
      return localArrayList;
    }
    finally
    {
      ((Cursor)localObject).close();
    }
  }
  
  /* Error */
  public final ArrayList<j> b(String paramString, long paramLong)
  {
    // Byte code:
    //   0: new 411	com/whatsapp/util/bd
    //   3: dup
    //   4: invokespecial 1734	com/whatsapp/util/bd:<init>	()V
    //   7: ldc_w 2925
    //   10: invokevirtual 1738	com/whatsapp/util/bd:a	(Ljava/lang/String;)V
    //   13: invokestatic 2930	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   16: astore 4
    //   18: aload 4
    //   20: lload_2
    //   21: invokevirtual 2934	java/util/Calendar:setTimeInMillis	(J)V
    //   24: aload 4
    //   26: bipush 11
    //   28: iconst_0
    //   29: invokevirtual 2938	java/util/Calendar:set	(II)V
    //   32: aload 4
    //   34: bipush 12
    //   36: iconst_0
    //   37: invokevirtual 2938	java/util/Calendar:set	(II)V
    //   40: aload 4
    //   42: bipush 13
    //   44: iconst_0
    //   45: invokevirtual 2938	java/util/Calendar:set	(II)V
    //   48: aload 4
    //   50: bipush 14
    //   52: iconst_0
    //   53: invokevirtual 2938	java/util/Calendar:set	(II)V
    //   56: aload 4
    //   58: invokevirtual 2941	java/util/Calendar:getTimeInMillis	()J
    //   61: lstore_2
    //   62: new 955	java/util/ArrayList
    //   65: dup
    //   66: invokespecial 956	java/util/ArrayList:<init>	()V
    //   69: astore 5
    //   71: aload_0
    //   72: getfield 361	com/whatsapp/data/ad:b	Lcom/whatsapp/data/n;
    //   75: invokevirtual 425	com/whatsapp/data/n:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   78: getstatic 201	com/whatsapp/data/ad:ai	Ljava/lang/String;
    //   81: iconst_4
    //   82: anewarray 429	java/lang/String
    //   85: dup
    //   86: iconst_0
    //   87: aload_1
    //   88: aastore
    //   89: dup
    //   90: iconst_1
    //   91: ldc_w 2943
    //   94: aastore
    //   95: dup
    //   96: iconst_2
    //   97: lload_2
    //   98: invokestatic 1348	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   101: aastore
    //   102: dup
    //   103: iconst_3
    //   104: ldc2_w 997
    //   107: lload_2
    //   108: ladd
    //   109: invokestatic 1348	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   112: aastore
    //   113: invokevirtual 435	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   116: astore 4
    //   118: aload 4
    //   120: ifnull +60 -> 180
    //   123: aload 4
    //   125: invokeinterface 441 1 0
    //   130: ifeq +53 -> 183
    //   133: aload 5
    //   135: aload_0
    //   136: getfield 307	com/whatsapp/data/ad:t	Lcom/whatsapp/data/l;
    //   139: aload 4
    //   141: aload_1
    //   142: invokevirtual 446	com/whatsapp/data/l:a	(Landroid/database/Cursor;Ljava/lang/String;)Lcom/whatsapp/protocol/j;
    //   145: invokevirtual 982	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   148: pop
    //   149: goto -26 -> 123
    //   152: astore_1
    //   153: new 162	java/lang/StringBuilder
    //   156: dup
    //   157: ldc_w 2945
    //   160: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   163: aload_1
    //   164: invokevirtual 583	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 474	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   173: aload 4
    //   175: invokeinterface 457 1 0
    //   180: aload 5
    //   182: areturn
    //   183: aload 4
    //   185: invokeinterface 457 1 0
    //   190: aload 5
    //   192: areturn
    //   193: astore_1
    //   194: aload_0
    //   195: new 1171	java/lang/AssertionError
    //   198: dup
    //   199: aload_1
    //   200: invokespecial 1174	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   203: invokevirtual 1176	com/whatsapp/data/ad:a	(Ljava/lang/Throwable;)V
    //   206: aload 4
    //   208: invokeinterface 457 1 0
    //   213: aload 5
    //   215: areturn
    //   216: astore_1
    //   217: aload_0
    //   218: getfield 263	com/whatsapp/data/ad:J	Landroid/content/Context;
    //   221: invokestatic 2947	a/a/a/a/d:g	(Landroid/content/Context;)V
    //   224: aload_1
    //   225: athrow
    //   226: astore_1
    //   227: aload 4
    //   229: invokeinterface 457 1 0
    //   234: aload_1
    //   235: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	this	ad
    //   0	236	1	paramString	String
    //   0	236	2	paramLong	long
    //   16	212	4	localObject	Object
    //   69	145	5	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   123	149	152	java/lang/IllegalStateException
    //   123	149	193	android/database/sqlite/SQLiteDatabaseCorruptException
    //   123	149	216	android/database/sqlite/SQLiteFullException
    //   123	149	226	finally
    //   153	173	226	finally
    //   194	206	226	finally
    //   217	226	226	finally
  }
  
  /* Error */
  public final ArrayList<File> b(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +13 -> 14
    //   4: aload_1
    //   5: ldc_w 1031
    //   8: invokevirtual 869	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11: ifeq +11 -> 22
    //   14: new 1607	java/lang/IllegalArgumentException
    //   17: dup
    //   18: invokespecial 2952	java/lang/IllegalArgumentException:<init>	()V
    //   21: athrow
    //   22: new 411	com/whatsapp/util/bd
    //   25: dup
    //   26: invokespecial 1734	com/whatsapp/util/bd:<init>	()V
    //   29: astore 18
    //   31: aload 18
    //   33: new 162	java/lang/StringBuilder
    //   36: dup
    //   37: ldc_w 2954
    //   40: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   43: aload_1
    //   44: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokevirtual 1738	com/whatsapp/util/bd:a	(Ljava/lang/String;)V
    //   53: new 162	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 1305	java/lang/StringBuilder:<init>	()V
    //   60: aload_0
    //   61: getfield 263	com/whatsapp/data/ad:J	Landroid/content/Context;
    //   64: ldc_w 2955
    //   67: iconst_1
    //   68: anewarray 4	java/lang/Object
    //   71: dup
    //   72: iconst_0
    //   73: aload_0
    //   74: getfield 291	com/whatsapp/data/ad:Q	Lcom/whatsapp/data/e;
    //   77: aload_1
    //   78: invokevirtual 1496	com/whatsapp/data/e:d	(Ljava/lang/String;)Lcom/whatsapp/data/cs;
    //   81: aload_0
    //   82: getfield 263	com/whatsapp/data/ad:J	Landroid/content/Context;
    //   85: invokevirtual 2958	com/whatsapp/data/cs:a	(Landroid/content/Context;)Ljava/lang/String;
    //   88: aastore
    //   89: invokevirtual 2961	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   92: ldc_w 2963
    //   95: ldc_w 1031
    //   98: invokevirtual 1753	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   101: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc_w 2965
    //   107: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: astore 13
    //   115: aload_0
    //   116: getfield 283	com/whatsapp/data/ad:m	Lcom/whatsapp/oz;
    //   119: aload 13
    //   121: invokevirtual 2967	com/whatsapp/oz:a	(Ljava/lang/String;)Ljava/io/File;
    //   124: astore 14
    //   126: aload 14
    //   128: invokevirtual 2970	java/io/File:createNewFile	()Z
    //   131: pop
    //   132: aload 14
    //   134: invokestatic 1299	a/a/a/a/d:d	(Ljava/io/File;)Z
    //   137: pop
    //   138: new 2972	java/io/OutputStreamWriter
    //   141: dup
    //   142: new 2974	java/io/FileOutputStream
    //   145: dup
    //   146: aload 14
    //   148: invokespecial 2976	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   151: ldc_w 2978
    //   154: invokespecial 2981	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   157: astore 15
    //   159: aload_1
    //   160: invokestatic 1361	com/whatsapp/qz:e	(Ljava/lang/String;)Z
    //   163: istore 5
    //   165: new 955	java/util/ArrayList
    //   168: dup
    //   169: invokespecial 956	java/util/ArrayList:<init>	()V
    //   172: astore 19
    //   174: iload_2
    //   175: ifeq +931 -> 1106
    //   178: sipush 10000
    //   181: istore_3
    //   182: aload_0
    //   183: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   186: invokevirtual 419	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   189: ldc2_w 2982
    //   192: lstore 9
    //   194: aload_0
    //   195: getfield 361	com/whatsapp/data/ad:b	Lcom/whatsapp/data/n;
    //   198: invokevirtual 425	com/whatsapp/data/n:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   201: new 162	java/lang/StringBuilder
    //   204: dup
    //   205: ldc_w 2985
    //   208: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   211: iload_3
    //   212: invokevirtual 1120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   215: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: iconst_1
    //   219: anewarray 429	java/lang/String
    //   222: dup
    //   223: iconst_0
    //   224: aload_1
    //   225: aastore
    //   226: invokevirtual 435	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   229: astore 20
    //   231: lload 9
    //   233: lstore 7
    //   235: aload 20
    //   237: ifnull +280 -> 517
    //   240: aload 20
    //   242: invokeinterface 441 1 0
    //   247: istore 6
    //   249: iload 6
    //   251: ifeq +1464 -> 1715
    //   254: iconst_0
    //   255: istore 4
    //   257: ldc2_w 2982
    //   260: lstore 7
    //   262: lconst_0
    //   263: lstore 9
    //   265: aload_0
    //   266: getfield 307	com/whatsapp/data/ad:t	Lcom/whatsapp/data/l;
    //   269: aload 20
    //   271: aload_1
    //   272: invokevirtual 446	com/whatsapp/data/l:a	(Landroid/database/Cursor;Ljava/lang/String;)Lcom/whatsapp/protocol/j;
    //   275: astore 21
    //   277: aload 21
    //   279: ifnull +2220 -> 2499
    //   282: iload 4
    //   284: iconst_1
    //   285: iadd
    //   286: istore 4
    //   288: ldc2_w 2986
    //   291: lload 9
    //   293: ladd
    //   294: lstore 9
    //   296: aconst_null
    //   297: astore 17
    //   299: aload 21
    //   301: getfield 621	com/whatsapp/protocol/j:s	B
    //   304: tableswitch	default:+2198->2502, 1:+809->1113, 2:+809->1113, 3:+809->1113, 4:+838->1142, 5:+72->376, 6:+72->376, 7:+72->376, 8:+72->376, 9:+809->1113, 10:+72->376, 11:+72->376, 12:+72->376, 13:+809->1113, 14:+1056->1360
    //   376: aload 21
    //   378: invokevirtual 2617	com/whatsapp/protocol/j:d	()Z
    //   381: ifeq +913 -> 1294
    //   384: lload 9
    //   386: aload 21
    //   388: invokevirtual 1969	com/whatsapp/protocol/j:h	()[B
    //   391: arraylength
    //   392: i2l
    //   393: ladd
    //   394: lstore 11
    //   396: aconst_null
    //   397: astore 13
    //   399: lload 11
    //   401: lstore 9
    //   403: aload 13
    //   405: ifnull +25 -> 430
    //   408: lload 11
    //   410: lstore 9
    //   412: aload 13
    //   414: invokevirtual 1658	java/io/File:exists	()Z
    //   417: ifeq +13 -> 430
    //   420: lload 11
    //   422: aload 13
    //   424: invokevirtual 1313	java/io/File:length	()J
    //   427: ladd
    //   428: lstore 9
    //   430: iload 4
    //   432: iload_3
    //   433: if_icmpge +2063 -> 2496
    //   436: lload 9
    //   438: ldc2_w 2988
    //   441: lcmp
    //   442: ifge +2054 -> 2496
    //   445: aload 20
    //   447: bipush 29
    //   449: invokeinterface 1393 2 0
    //   454: lstore 11
    //   456: lload 11
    //   458: lstore 7
    //   460: aload 13
    //   462: ifnull +2043 -> 2505
    //   465: lload 7
    //   467: lstore 11
    //   469: aload 13
    //   471: invokevirtual 1658	java/io/File:exists	()Z
    //   474: ifeq +2031 -> 2505
    //   477: lload 7
    //   479: lstore 11
    //   481: aload 19
    //   483: iconst_0
    //   484: aload 13
    //   486: invokevirtual 2992	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   489: goto +2016 -> 2505
    //   492: lload 7
    //   494: lstore 11
    //   496: aload 20
    //   498: invokeinterface 441 1 0
    //   503: istore 6
    //   505: iload 6
    //   507: ifne +1986 -> 2493
    //   510: aload 20
    //   512: invokeinterface 457 1 0
    //   517: aload_0
    //   518: getfield 361	com/whatsapp/data/ad:b	Lcom/whatsapp/data/n;
    //   521: invokevirtual 425	com/whatsapp/data/n:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   524: ldc_w 2994
    //   527: iconst_2
    //   528: anewarray 429	java/lang/String
    //   531: dup
    //   532: iconst_0
    //   533: aload_1
    //   534: aastore
    //   535: dup
    //   536: iconst_1
    //   537: lload 7
    //   539: invokestatic 1742	java/lang/Long:toString	(J)Ljava/lang/String;
    //   542: aastore
    //   543: invokevirtual 435	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   546: astore 16
    //   548: aload 16
    //   550: ifnull +1891 -> 2441
    //   553: aload 16
    //   555: invokeinterface 2359 1 0
    //   560: istore 6
    //   562: iload 6
    //   564: ifeq +1870 -> 2434
    //   567: new 162	java/lang/StringBuilder
    //   570: dup
    //   571: invokespecial 1305	java/lang/StringBuilder:<init>	()V
    //   574: astore 17
    //   576: lconst_0
    //   577: lstore 7
    //   579: iconst_0
    //   580: istore_3
    //   581: aload_0
    //   582: getfield 307	com/whatsapp/data/ad:t	Lcom/whatsapp/data/l;
    //   585: aload 16
    //   587: aload_1
    //   588: invokevirtual 446	com/whatsapp/data/l:a	(Landroid/database/Cursor;Ljava/lang/String;)Lcom/whatsapp/protocol/j;
    //   591: astore 13
    //   593: aload 13
    //   595: ifnull +1895 -> 2490
    //   598: iload_3
    //   599: iconst_1
    //   600: iadd
    //   601: istore_3
    //   602: lload 7
    //   604: lstore 9
    //   606: aload 17
    //   608: aload_0
    //   609: getfield 263	com/whatsapp/data/ad:J	Landroid/content/Context;
    //   612: invokevirtual 2997	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   615: aload_0
    //   616: getfield 299	com/whatsapp/data/ad:S	Lcom/whatsapp/aus;
    //   619: aload_0
    //   620: getfield 275	com/whatsapp/data/ad:j	Lcom/whatsapp/ant;
    //   623: aload 13
    //   625: invokevirtual 2999	com/whatsapp/ant:a	(Lcom/whatsapp/protocol/j;)J
    //   628: invokestatic 3004	com/whatsapp/util/l:a	(Landroid/content/Context;Lcom/whatsapp/aus;J)Ljava/lang/String;
    //   631: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: pop
    //   635: lload 7
    //   637: lstore 9
    //   639: aload 17
    //   641: ldc_w 3006
    //   644: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: pop
    //   648: lload 7
    //   650: lstore 9
    //   652: aload 13
    //   654: getfield 621	com/whatsapp/protocol/j:s	B
    //   657: ifne +17 -> 674
    //   660: lload 7
    //   662: lstore 9
    //   664: aload 13
    //   666: getfield 871	com/whatsapp/protocol/j:d	I
    //   669: bipush 6
    //   671: if_icmpeq +48 -> 719
    //   674: lload 7
    //   676: lstore 9
    //   678: aload 13
    //   680: getfield 849	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   683: getfield 853	com/whatsapp/protocol/j$b:b	Z
    //   686: ifeq +1043 -> 1729
    //   689: lload 7
    //   691: lstore 9
    //   693: aload 17
    //   695: aload_0
    //   696: getfield 333	com/whatsapp/data/ad:aa	Lcom/whatsapp/atv;
    //   699: invokevirtual 3008	com/whatsapp/atv:l	()Ljava/lang/String;
    //   702: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: pop
    //   706: lload 7
    //   708: lstore 9
    //   710: aload 17
    //   712: ldc_w 3010
    //   715: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: pop
    //   719: lload 7
    //   721: lstore 9
    //   723: aload 13
    //   725: getfield 621	com/whatsapp/protocol/j:s	B
    //   728: tableswitch	default:+1780->2508, 1:+1181->1909, 2:+1181->1909, 3:+1181->1909, 4:+1382->2110, 5:+1489->2217, 6:+72->800, 7:+72->800, 8:+72->800, 9:+1181->1909, 10:+72->800, 11:+72->800, 12:+72->800, 13:+1181->1909, 14:+1382->2110
    //   800: lload 7
    //   802: lstore 9
    //   804: aload 13
    //   806: getfield 621	com/whatsapp/protocol/j:s	B
    //   809: ifeq +31 -> 840
    //   812: lload 7
    //   814: lstore 9
    //   816: new 162	java/lang/StringBuilder
    //   819: dup
    //   820: ldc_w 3012
    //   823: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   826: aload 13
    //   828: getfield 621	com/whatsapp/protocol/j:s	B
    //   831: invokevirtual 1120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   834: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   837: invokestatic 505	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   840: lload 7
    //   842: lstore 9
    //   844: aload 13
    //   846: getfield 871	com/whatsapp/protocol/j:d	I
    //   849: bipush 6
    //   851: if_icmpne +1501 -> 2352
    //   854: lload 7
    //   856: lstore 9
    //   858: aload 17
    //   860: aload_0
    //   861: getfield 277	com/whatsapp/data/ad:k	Lcom/whatsapp/pv;
    //   864: aload_0
    //   865: getfield 279	com/whatsapp/data/ad:l	Lcom/whatsapp/va;
    //   868: aload_0
    //   869: getfield 281	com/whatsapp/data/ad:n	Lcom/whatsapp/data/d;
    //   872: aload_0
    //   873: getfield 291	com/whatsapp/data/ad:Q	Lcom/whatsapp/data/e;
    //   876: aload_0
    //   877: getfield 299	com/whatsapp/data/ad:S	Lcom/whatsapp/aus;
    //   880: aload_0
    //   881: getfield 349	com/whatsapp/data/ad:E	Lcom/whatsapp/rh;
    //   884: aload 13
    //   886: invokestatic 3017	com/whatsapp/ip:a	(Lcom/whatsapp/pv;Lcom/whatsapp/va;Lcom/whatsapp/data/d;Lcom/whatsapp/data/e;Lcom/whatsapp/aus;Lcom/whatsapp/rh;Lcom/whatsapp/protocol/j;)Ljava/lang/String;
    //   889: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   892: pop
    //   893: lload 7
    //   895: lstore 9
    //   897: aload 17
    //   899: invokevirtual 3019	java/lang/StringBuilder:length	()I
    //   902: istore 4
    //   904: iload 4
    //   906: ifle +49 -> 955
    //   909: lload 7
    //   911: lstore 9
    //   913: aload 15
    //   915: new 162	java/lang/StringBuilder
    //   918: dup
    //   919: invokespecial 1305	java/lang/StringBuilder:<init>	()V
    //   922: aload 17
    //   924: invokevirtual 583	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   927: ldc_w 3021
    //   930: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   933: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   936: invokevirtual 3024	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   939: lload 7
    //   941: lstore 9
    //   943: aload 17
    //   945: iconst_0
    //   946: aload 17
    //   948: invokevirtual 3019	java/lang/StringBuilder:length	()I
    //   951: invokevirtual 3027	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   954: pop
    //   955: aload 16
    //   957: invokeinterface 441 1 0
    //   962: istore 6
    //   964: iload 6
    //   966: ifne +1521 -> 2487
    //   969: aload 16
    //   971: invokeinterface 457 1 0
    //   976: aload_0
    //   977: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   980: invokevirtual 460	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   983: aload 15
    //   985: invokevirtual 3030	java/io/OutputStreamWriter:flush	()V
    //   988: aload 15
    //   990: invokevirtual 3031	java/io/OutputStreamWriter:close	()V
    //   993: aload 14
    //   995: invokevirtual 1313	java/io/File:length	()J
    //   998: lstore 9
    //   1000: aload 19
    //   1002: iconst_0
    //   1003: aload 14
    //   1005: invokevirtual 2992	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   1008: new 162	java/lang/StringBuilder
    //   1011: dup
    //   1012: ldc_w 3033
    //   1015: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1018: iload_3
    //   1019: invokevirtual 1120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1022: ldc_w 3035
    //   1025: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1028: aload 19
    //   1030: invokevirtual 965	java/util/ArrayList:size	()I
    //   1033: invokevirtual 1120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1036: ldc_w 3037
    //   1039: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1042: lload 7
    //   1044: lload 9
    //   1046: ladd
    //   1047: invokevirtual 470	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1050: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1053: invokestatic 474	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1056: aload 18
    //   1058: invokevirtual 467	com/whatsapp/util/bd:b	()J
    //   1061: pop2
    //   1062: aload 19
    //   1064: areturn
    //   1065: astore 14
    //   1067: aload_0
    //   1068: getfield 283	com/whatsapp/data/ad:m	Lcom/whatsapp/oz;
    //   1071: aload 13
    //   1073: invokestatic 3042	com/whatsapp/emoji/c:a	(Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1076: invokevirtual 2967	com/whatsapp/oz:a	(Ljava/lang/String;)Ljava/io/File;
    //   1079: astore 14
    //   1081: goto -949 -> 132
    //   1084: astore_1
    //   1085: ldc_w 3044
    //   1088: invokestatic 509	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   1091: aconst_null
    //   1092: areturn
    //   1093: astore 13
    //   1095: aload 13
    //   1097: invokestatic 1169	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   1100: aconst_null
    //   1101: astore 15
    //   1103: goto -944 -> 159
    //   1106: ldc_w 3045
    //   1109: istore_3
    //   1110: goto -928 -> 182
    //   1113: iload_2
    //   1114: ifeq +180 -> 1294
    //   1117: aload 21
    //   1119: invokevirtual 877	com/whatsapp/protocol/j:b	()Lcom/whatsapp/MediaData;
    //   1122: ifnull +172 -> 1294
    //   1125: aload 21
    //   1127: invokevirtual 877	com/whatsapp/protocol/j:b	()Lcom/whatsapp/MediaData;
    //   1130: getfield 1612	com/whatsapp/MediaData:file	Ljava/io/File;
    //   1133: astore 13
    //   1135: lload 9
    //   1137: lstore 11
    //   1139: goto -740 -> 399
    //   1142: aload_0
    //   1143: getfield 283	com/whatsapp/data/ad:m	Lcom/whatsapp/oz;
    //   1146: astore 16
    //   1148: new 162	java/lang/StringBuilder
    //   1151: dup
    //   1152: invokespecial 1305	java/lang/StringBuilder:<init>	()V
    //   1155: astore 17
    //   1157: aload 21
    //   1159: getfield 1223	com/whatsapp/protocol/j:y	Ljava/lang/String;
    //   1162: ifnonnull +142 -> 1304
    //   1165: ldc_w 1031
    //   1168: astore 13
    //   1170: aload 16
    //   1172: aload 17
    //   1174: aload 13
    //   1176: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1179: ldc_w 3047
    //   1182: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1185: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1188: invokevirtual 2967	com/whatsapp/oz:a	(Ljava/lang/String;)Ljava/io/File;
    //   1191: astore 13
    //   1193: aload 13
    //   1195: invokevirtual 1658	java/io/File:exists	()Z
    //   1198: ifeq +25 -> 1223
    //   1201: aload 13
    //   1203: invokevirtual 3050	java/io/File:lastModified	()J
    //   1206: invokestatic 568	java/lang/System:currentTimeMillis	()J
    //   1209: ldc2_w 1812
    //   1212: lsub
    //   1213: lcmp
    //   1214: ifge +9 -> 1223
    //   1217: aload 13
    //   1219: invokestatic 1299	a/a/a/a/d:d	(Ljava/io/File;)Z
    //   1222: pop
    //   1223: aload 13
    //   1225: invokevirtual 1658	java/io/File:exists	()Z
    //   1228: istore 6
    //   1230: iload 6
    //   1232: ifne +111 -> 1343
    //   1235: new 2972	java/io/OutputStreamWriter
    //   1238: dup
    //   1239: new 2974	java/io/FileOutputStream
    //   1242: dup
    //   1243: aload 13
    //   1245: invokespecial 2976	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   1248: ldc_w 2978
    //   1251: invokespecial 2981	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   1254: astore 16
    //   1256: aload 16
    //   1258: aload 21
    //   1260: invokevirtual 1422	com/whatsapp/protocol/j:e	()Ljava/lang/String;
    //   1263: invokevirtual 3024	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   1266: aload 16
    //   1268: invokevirtual 3030	java/io/OutputStreamWriter:flush	()V
    //   1271: aload 16
    //   1273: invokevirtual 3031	java/io/OutputStreamWriter:close	()V
    //   1276: aload 19
    //   1278: aload 13
    //   1280: invokevirtual 3051	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   1283: istore 6
    //   1285: lload 9
    //   1287: lstore 11
    //   1289: iload 6
    //   1291: ifeq -892 -> 399
    //   1294: aconst_null
    //   1295: astore 13
    //   1297: lload 9
    //   1299: lstore 11
    //   1301: goto -902 -> 399
    //   1304: aload 21
    //   1306: getfield 1223	com/whatsapp/protocol/j:y	Ljava/lang/String;
    //   1309: ldc_w 3053
    //   1312: ldc_w 1031
    //   1315: invokevirtual 1753	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1318: astore 13
    //   1320: goto -150 -> 1170
    //   1323: astore 13
    //   1325: ldc_w 3055
    //   1328: aload 13
    //   1330: invokestatic 1629	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1333: aconst_null
    //   1334: astore 13
    //   1336: lload 9
    //   1338: lstore 11
    //   1340: goto -941 -> 399
    //   1343: aload 19
    //   1345: aload 13
    //   1347: invokevirtual 3051	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   1350: ifne -56 -> 1294
    //   1353: lload 9
    //   1355: lstore 11
    //   1357: goto -958 -> 399
    //   1360: aload_0
    //   1361: getfield 283	com/whatsapp/data/ad:m	Lcom/whatsapp/oz;
    //   1364: astore 16
    //   1366: new 162	java/lang/StringBuilder
    //   1369: dup
    //   1370: invokespecial 1305	java/lang/StringBuilder:<init>	()V
    //   1373: astore 22
    //   1375: aload 21
    //   1377: getfield 1223	com/whatsapp/protocol/j:y	Ljava/lang/String;
    //   1380: ifnonnull +179 -> 1559
    //   1383: ldc_w 1031
    //   1386: astore 13
    //   1388: aload 16
    //   1390: aload 22
    //   1392: aload 13
    //   1394: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1397: ldc_w 3047
    //   1400: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1403: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1406: invokevirtual 2967	com/whatsapp/oz:a	(Ljava/lang/String;)Ljava/io/File;
    //   1409: astore 16
    //   1411: aload 16
    //   1413: invokevirtual 1658	java/io/File:exists	()Z
    //   1416: ifeq +25 -> 1441
    //   1419: aload 16
    //   1421: invokevirtual 3050	java/io/File:lastModified	()J
    //   1424: invokestatic 568	java/lang/System:currentTimeMillis	()J
    //   1427: ldc2_w 1812
    //   1430: lsub
    //   1431: lcmp
    //   1432: ifge +9 -> 1441
    //   1435: aload 16
    //   1437: invokestatic 1299	a/a/a/a/d:d	(Ljava/io/File;)Z
    //   1440: pop
    //   1441: aload 16
    //   1443: invokevirtual 1658	java/io/File:exists	()Z
    //   1446: istore 6
    //   1448: iload 6
    //   1450: ifne +187 -> 1637
    //   1453: new 2972	java/io/OutputStreamWriter
    //   1456: dup
    //   1457: new 2974	java/io/FileOutputStream
    //   1460: dup
    //   1461: aload 16
    //   1463: invokespecial 2976	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   1466: ldc_w 2978
    //   1469: invokespecial 2981	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   1472: astore 13
    //   1474: new 955	java/util/ArrayList
    //   1477: dup
    //   1478: new 1965	java/io/ObjectInputStream
    //   1481: dup
    //   1482: new 1967	java/io/ByteArrayInputStream
    //   1485: dup
    //   1486: aload 21
    //   1488: invokevirtual 1969	com/whatsapp/protocol/j:h	()[B
    //   1491: invokespecial 1971	java/io/ByteArrayInputStream:<init>	([B)V
    //   1494: invokespecial 1974	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   1497: invokevirtual 1977	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   1500: checkcast 906	java/util/List
    //   1503: invokespecial 1579	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   1506: invokevirtual 969	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1509: astore 21
    //   1511: aload 21
    //   1513: invokeinterface 915 1 0
    //   1518: ifeq +60 -> 1578
    //   1521: aload 13
    //   1523: aload 21
    //   1525: invokeinterface 918 1 0
    //   1530: checkcast 429	java/lang/String
    //   1533: invokevirtual 3024	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   1536: goto -25 -> 1511
    //   1539: astore 13
    //   1541: ldc_w 3055
    //   1544: aload 13
    //   1546: invokestatic 1629	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1549: aconst_null
    //   1550: astore 13
    //   1552: lload 9
    //   1554: lstore 11
    //   1556: goto -1157 -> 399
    //   1559: aload 21
    //   1561: getfield 1223	com/whatsapp/protocol/j:y	Ljava/lang/String;
    //   1564: ldc_w 3053
    //   1567: ldc_w 1031
    //   1570: invokevirtual 1753	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1573: astore 13
    //   1575: goto -187 -> 1388
    //   1578: aload 13
    //   1580: invokevirtual 3030	java/io/OutputStreamWriter:flush	()V
    //   1583: aload 13
    //   1585: invokevirtual 3031	java/io/OutputStreamWriter:close	()V
    //   1588: aload 19
    //   1590: aload 16
    //   1592: invokevirtual 3051	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   1595: istore 6
    //   1597: aload 17
    //   1599: astore 13
    //   1601: iload 6
    //   1603: ifne +7 -> 1610
    //   1606: aload 16
    //   1608: astore 13
    //   1610: lload 9
    //   1612: lstore 11
    //   1614: goto -1215 -> 399
    //   1617: astore 13
    //   1619: ldc_w 3057
    //   1622: aload 13
    //   1624: invokestatic 1629	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1627: aconst_null
    //   1628: astore 13
    //   1630: lload 9
    //   1632: lstore 11
    //   1634: goto -1235 -> 399
    //   1637: aload 19
    //   1639: aload 16
    //   1641: invokevirtual 3051	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   1644: istore 6
    //   1646: iload 6
    //   1648: ifne -354 -> 1294
    //   1651: aload 16
    //   1653: astore 13
    //   1655: lload 9
    //   1657: lstore 11
    //   1659: goto -1260 -> 399
    //   1662: astore 13
    //   1664: new 162	java/lang/StringBuilder
    //   1667: dup
    //   1668: ldc_w 3059
    //   1671: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1674: aload 13
    //   1676: invokevirtual 583	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1679: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1682: invokestatic 509	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   1685: aload 20
    //   1687: invokeinterface 457 1 0
    //   1692: goto -1175 -> 517
    //   1695: astore_1
    //   1696: aload_0
    //   1697: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   1700: invokevirtual 460	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   1703: aload_1
    //   1704: athrow
    //   1705: astore_1
    //   1706: aload 20
    //   1708: invokeinterface 457 1 0
    //   1713: aload_1
    //   1714: athrow
    //   1715: aload 20
    //   1717: invokeinterface 457 1 0
    //   1722: lload 9
    //   1724: lstore 7
    //   1726: goto -1209 -> 517
    //   1729: iload 5
    //   1731: ifeq +143 -> 1874
    //   1734: lload 7
    //   1736: lstore 9
    //   1738: aload 13
    //   1740: getfield 1437	com/whatsapp/protocol/j:f	Ljava/lang/String;
    //   1743: ifnull +70 -> 1813
    //   1746: lload 7
    //   1748: lstore 9
    //   1750: aload 17
    //   1752: aload_0
    //   1753: getfield 291	com/whatsapp/data/ad:Q	Lcom/whatsapp/data/e;
    //   1756: aload 13
    //   1758: getfield 1437	com/whatsapp/protocol/j:f	Ljava/lang/String;
    //   1761: invokevirtual 1496	com/whatsapp/data/e:d	(Ljava/lang/String;)Lcom/whatsapp/data/cs;
    //   1764: aload_0
    //   1765: getfield 263	com/whatsapp/data/ad:J	Landroid/content/Context;
    //   1768: invokevirtual 2958	com/whatsapp/data/cs:a	(Landroid/content/Context;)Ljava/lang/String;
    //   1771: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1774: pop
    //   1775: goto -1069 -> 706
    //   1778: astore_1
    //   1779: lload 9
    //   1781: lstore 7
    //   1783: new 162	java/lang/StringBuilder
    //   1786: dup
    //   1787: ldc_w 3059
    //   1790: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1793: aload_1
    //   1794: invokevirtual 583	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1797: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1800: invokestatic 509	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   1803: aload 16
    //   1805: invokeinterface 457 1 0
    //   1810: goto -834 -> 976
    //   1813: lload 7
    //   1815: lstore 9
    //   1817: new 162	java/lang/StringBuilder
    //   1820: dup
    //   1821: ldc_w 3061
    //   1824: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1827: aload 13
    //   1829: invokestatic 1804	com/whatsapp/util/Log:a	(Lcom/whatsapp/protocol/j;)Ljava/lang/String;
    //   1832: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1835: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1838: invokestatic 509	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   1841: lload 7
    //   1843: lstore 9
    //   1845: aload 17
    //   1847: aload_0
    //   1848: getfield 263	com/whatsapp/data/ad:J	Landroid/content/Context;
    //   1851: ldc_w 3062
    //   1854: invokevirtual 3063	android/content/Context:getString	(I)Ljava/lang/String;
    //   1857: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1860: pop
    //   1861: goto -1155 -> 706
    //   1864: astore_1
    //   1865: aload 16
    //   1867: invokeinterface 457 1 0
    //   1872: aload_1
    //   1873: athrow
    //   1874: lload 7
    //   1876: lstore 9
    //   1878: aload 17
    //   1880: aload_0
    //   1881: getfield 291	com/whatsapp/data/ad:Q	Lcom/whatsapp/data/e;
    //   1884: aload 13
    //   1886: getfield 849	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   1889: getfield 1059	com/whatsapp/protocol/j$b:a	Ljava/lang/String;
    //   1892: invokevirtual 1496	com/whatsapp/data/e:d	(Ljava/lang/String;)Lcom/whatsapp/data/cs;
    //   1895: aload_0
    //   1896: getfield 263	com/whatsapp/data/ad:J	Landroid/content/Context;
    //   1899: invokevirtual 2958	com/whatsapp/data/cs:a	(Landroid/content/Context;)Ljava/lang/String;
    //   1902: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1905: pop
    //   1906: goto -1200 -> 706
    //   1909: iload_2
    //   1910: ifeq +177 -> 2087
    //   1913: lload 7
    //   1915: lstore 9
    //   1917: aload 13
    //   1919: invokevirtual 877	com/whatsapp/protocol/j:b	()Lcom/whatsapp/MediaData;
    //   1922: ifnull +142 -> 2064
    //   1925: lload 7
    //   1927: lstore 9
    //   1929: aload 13
    //   1931: invokevirtual 877	com/whatsapp/protocol/j:b	()Lcom/whatsapp/MediaData;
    //   1934: getfield 1612	com/whatsapp/MediaData:file	Ljava/io/File;
    //   1937: astore 20
    //   1939: aload 20
    //   1941: ifnull +96 -> 2037
    //   1944: lload 7
    //   1946: lstore 9
    //   1948: aload 20
    //   1950: invokevirtual 1658	java/io/File:exists	()Z
    //   1953: ifeq +84 -> 2037
    //   1956: lload 7
    //   1958: lstore 9
    //   1960: aload 20
    //   1962: invokevirtual 1313	java/io/File:length	()J
    //   1965: lstore 11
    //   1967: lload 11
    //   1969: lload 7
    //   1971: ladd
    //   1972: lstore 7
    //   1974: aload 17
    //   1976: aload_0
    //   1977: getfield 263	com/whatsapp/data/ad:J	Landroid/content/Context;
    //   1980: ldc_w 3064
    //   1983: iconst_1
    //   1984: anewarray 4	java/lang/Object
    //   1987: dup
    //   1988: iconst_0
    //   1989: aload 20
    //   1991: invokevirtual 1308	java/io/File:getName	()Ljava/lang/String;
    //   1994: aastore
    //   1995: invokevirtual 2961	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   1998: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2001: pop
    //   2002: lload 7
    //   2004: lstore 9
    //   2006: aload 13
    //   2008: getfield 1981	com/whatsapp/protocol/j:z	Ljava/lang/String;
    //   2011: ifnull +500 -> 2511
    //   2014: aload 17
    //   2016: ldc_w 3021
    //   2019: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2022: pop
    //   2023: aload 17
    //   2025: aload 13
    //   2027: getfield 1981	com/whatsapp/protocol/j:z	Ljava/lang/String;
    //   2030: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2033: pop
    //   2034: goto -1141 -> 893
    //   2037: lload 7
    //   2039: lstore 9
    //   2041: aload 17
    //   2043: aload_0
    //   2044: getfield 263	com/whatsapp/data/ad:J	Landroid/content/Context;
    //   2047: ldc_w 3065
    //   2050: invokevirtual 3063	android/content/Context:getString	(I)Ljava/lang/String;
    //   2053: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2056: pop
    //   2057: lload 7
    //   2059: lstore 9
    //   2061: goto +450 -> 2511
    //   2064: lload 7
    //   2066: lstore 9
    //   2068: aload 17
    //   2070: aload_0
    //   2071: getfield 263	com/whatsapp/data/ad:J	Landroid/content/Context;
    //   2074: ldc_w 3065
    //   2077: invokevirtual 3063	android/content/Context:getString	(I)Ljava/lang/String;
    //   2080: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2083: pop
    //   2084: goto -1191 -> 893
    //   2087: lload 7
    //   2089: lstore 9
    //   2091: aload 17
    //   2093: aload_0
    //   2094: getfield 263	com/whatsapp/data/ad:J	Landroid/content/Context;
    //   2097: ldc_w 3065
    //   2100: invokevirtual 3063	android/content/Context:getString	(I)Ljava/lang/String;
    //   2103: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2106: pop
    //   2107: goto -1214 -> 893
    //   2110: lload 7
    //   2112: lstore 9
    //   2114: aload_0
    //   2115: getfield 263	com/whatsapp/data/ad:J	Landroid/content/Context;
    //   2118: astore 20
    //   2120: lload 7
    //   2122: lstore 9
    //   2124: new 162	java/lang/StringBuilder
    //   2127: dup
    //   2128: invokespecial 1305	java/lang/StringBuilder:<init>	()V
    //   2131: astore 21
    //   2133: lload 7
    //   2135: lstore 9
    //   2137: aload 13
    //   2139: getfield 1223	com/whatsapp/protocol/j:y	Ljava/lang/String;
    //   2142: ifnonnull +52 -> 2194
    //   2145: ldc_w 1031
    //   2148: astore 13
    //   2150: lload 7
    //   2152: lstore 9
    //   2154: aload 17
    //   2156: aload 20
    //   2158: ldc_w 3064
    //   2161: iconst_1
    //   2162: anewarray 4	java/lang/Object
    //   2165: dup
    //   2166: iconst_0
    //   2167: aload 21
    //   2169: aload 13
    //   2171: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2174: ldc_w 3047
    //   2177: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2180: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2183: aastore
    //   2184: invokevirtual 2961	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   2187: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2190: pop
    //   2191: goto -1298 -> 893
    //   2194: lload 7
    //   2196: lstore 9
    //   2198: aload 13
    //   2200: getfield 1223	com/whatsapp/protocol/j:y	Ljava/lang/String;
    //   2203: ldc_w 3053
    //   2206: ldc_w 1031
    //   2209: invokevirtual 1753	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2212: astore 13
    //   2214: goto -64 -> 2150
    //   2217: lload 7
    //   2219: lstore 9
    //   2221: aload 13
    //   2223: getfield 1223	com/whatsapp/protocol/j:y	Ljava/lang/String;
    //   2226: ifnull +31 -> 2257
    //   2229: lload 7
    //   2231: lstore 9
    //   2233: aload 17
    //   2235: aload 13
    //   2237: getfield 1223	com/whatsapp/protocol/j:y	Ljava/lang/String;
    //   2240: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2243: pop
    //   2244: lload 7
    //   2246: lstore 9
    //   2248: aload 17
    //   2250: ldc_w 3021
    //   2253: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2256: pop
    //   2257: lload 7
    //   2259: lstore 9
    //   2261: aload 13
    //   2263: getfield 855	com/whatsapp/protocol/j:p	Ljava/lang/String;
    //   2266: ifnull +21 -> 2287
    //   2269: lload 7
    //   2271: lstore 9
    //   2273: aload 17
    //   2275: aload 13
    //   2277: getfield 855	com/whatsapp/protocol/j:p	Ljava/lang/String;
    //   2280: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2283: pop
    //   2284: goto -1391 -> 893
    //   2287: lload 7
    //   2289: lstore 9
    //   2291: aload 17
    //   2293: aload_0
    //   2294: getfield 263	com/whatsapp/data/ad:J	Landroid/content/Context;
    //   2297: ldc_w 3066
    //   2300: iconst_1
    //   2301: anewarray 4	java/lang/Object
    //   2304: dup
    //   2305: iconst_0
    //   2306: new 162	java/lang/StringBuilder
    //   2309: dup
    //   2310: ldc_w 3068
    //   2313: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2316: aload 13
    //   2318: getfield 3070	com/whatsapp/protocol/j:B	D
    //   2321: invokevirtual 3073	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   2324: ldc_w 1074
    //   2327: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2330: aload 13
    //   2332: getfield 3075	com/whatsapp/protocol/j:C	D
    //   2335: invokevirtual 3073	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   2338: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2341: aastore
    //   2342: invokevirtual 2961	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   2345: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2348: pop
    //   2349: goto -1456 -> 893
    //   2352: lload 7
    //   2354: lstore 9
    //   2356: aload 17
    //   2358: aload 13
    //   2360: invokevirtual 1422	com/whatsapp/protocol/j:e	()Ljava/lang/String;
    //   2363: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2366: pop
    //   2367: goto -1474 -> 893
    //   2370: astore 13
    //   2372: lload 7
    //   2374: lstore 9
    //   2376: aload 13
    //   2378: invokevirtual 3076	java/io/IOException:getMessage	()Ljava/lang/String;
    //   2381: ifnull +38 -> 2419
    //   2384: lload 7
    //   2386: lstore 9
    //   2388: aload 13
    //   2390: invokevirtual 3076	java/io/IOException:getMessage	()Ljava/lang/String;
    //   2393: ldc_w 3078
    //   2396: invokevirtual 1878	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2399: ifeq +20 -> 2419
    //   2402: lload 7
    //   2404: lstore 9
    //   2406: ldc_w 3080
    //   2409: invokestatic 509	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   2412: lload 7
    //   2414: lstore 9
    //   2416: aload 13
    //   2418: athrow
    //   2419: lload 7
    //   2421: lstore 9
    //   2423: ldc_w 3082
    //   2426: aload 13
    //   2428: invokestatic 1629	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2431: goto -1492 -> 939
    //   2434: aload 16
    //   2436: invokeinterface 457 1 0
    //   2441: lconst_0
    //   2442: lstore 7
    //   2444: iconst_0
    //   2445: istore_3
    //   2446: goto -1470 -> 976
    //   2449: astore_1
    //   2450: aload_1
    //   2451: invokestatic 1169	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   2454: goto -1461 -> 993
    //   2457: astore_1
    //   2458: iconst_0
    //   2459: istore_3
    //   2460: lconst_0
    //   2461: lstore 7
    //   2463: goto -680 -> 1783
    //   2466: astore_1
    //   2467: goto -684 -> 1783
    //   2470: astore_1
    //   2471: goto -688 -> 1783
    //   2474: astore_1
    //   2475: goto -692 -> 1783
    //   2478: astore 13
    //   2480: lload 11
    //   2482: lstore 7
    //   2484: goto -820 -> 1664
    //   2487: goto -1906 -> 581
    //   2490: goto -1535 -> 955
    //   2493: goto -2228 -> 265
    //   2496: goto -1986 -> 510
    //   2499: goto -2007 -> 492
    //   2502: goto -2126 -> 376
    //   2505: goto -2013 -> 492
    //   2508: goto -1708 -> 800
    //   2511: lload 9
    //   2513: lstore 7
    //   2515: goto -1622 -> 893
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2518	0	this	ad
    //   0	2518	1	paramString	String
    //   0	2518	2	paramBoolean	boolean
    //   181	2279	3	i1	int
    //   255	650	4	i2	int
    //   163	1567	5	bool1	boolean
    //   247	1400	6	bool2	boolean
    //   233	2281	7	l1	long
    //   192	2320	9	l2	long
    //   394	2087	11	l3	long
    //   113	959	13	localObject1	Object
    //   1093	3	13	localException	Exception
    //   1133	186	13	localObject2	Object
    //   1323	6	13	localIOException1	IOException
    //   1334	188	13	localObject3	Object
    //   1539	6	13	localIOException2	IOException
    //   1550	59	13	localObject4	Object
    //   1617	6	13	localClassNotFoundException	ClassNotFoundException
    //   1628	26	13	localObject5	Object
    //   1662	476	13	localSQLiteException1	android.database.sqlite.SQLiteException
    //   2148	211	13	str	String
    //   2370	57	13	localIOException3	IOException
    //   2478	1	13	localSQLiteException2	android.database.sqlite.SQLiteException
    //   124	880	14	localFile1	File
    //   1065	1	14	localIOException4	IOException
    //   1079	1	14	localFile2	File
    //   157	945	15	localOutputStreamWriter	java.io.OutputStreamWriter
    //   546	1889	16	localObject6	Object
    //   297	2060	17	localStringBuilder1	StringBuilder
    //   29	1028	18	localbd	bd
    //   172	1466	19	localArrayList	ArrayList
    //   229	1928	20	localObject7	Object
    //   275	1893	21	localObject8	Object
    //   1373	18	22	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   126	132	1065	java/io/IOException
    //   138	159	1084	java/io/FileNotFoundException
    //   138	159	1093	java/lang/Exception
    //   1235	1285	1323	java/io/IOException
    //   1453	1511	1539	java/io/IOException
    //   1511	1536	1539	java/io/IOException
    //   1578	1597	1539	java/io/IOException
    //   1453	1511	1617	java/lang/ClassNotFoundException
    //   1511	1536	1617	java/lang/ClassNotFoundException
    //   1578	1597	1617	java/lang/ClassNotFoundException
    //   265	277	1662	android/database/sqlite/SQLiteException
    //   299	376	1662	android/database/sqlite/SQLiteException
    //   376	396	1662	android/database/sqlite/SQLiteException
    //   412	430	1662	android/database/sqlite/SQLiteException
    //   445	456	1662	android/database/sqlite/SQLiteException
    //   1117	1135	1662	android/database/sqlite/SQLiteException
    //   1142	1165	1662	android/database/sqlite/SQLiteException
    //   1170	1223	1662	android/database/sqlite/SQLiteException
    //   1223	1230	1662	android/database/sqlite/SQLiteException
    //   1235	1285	1662	android/database/sqlite/SQLiteException
    //   1304	1320	1662	android/database/sqlite/SQLiteException
    //   1325	1333	1662	android/database/sqlite/SQLiteException
    //   1343	1353	1662	android/database/sqlite/SQLiteException
    //   1360	1383	1662	android/database/sqlite/SQLiteException
    //   1388	1441	1662	android/database/sqlite/SQLiteException
    //   1441	1448	1662	android/database/sqlite/SQLiteException
    //   1453	1511	1662	android/database/sqlite/SQLiteException
    //   1511	1536	1662	android/database/sqlite/SQLiteException
    //   1541	1549	1662	android/database/sqlite/SQLiteException
    //   1559	1575	1662	android/database/sqlite/SQLiteException
    //   1578	1597	1662	android/database/sqlite/SQLiteException
    //   1619	1627	1662	android/database/sqlite/SQLiteException
    //   1637	1646	1662	android/database/sqlite/SQLiteException
    //   194	231	1695	finally
    //   240	249	1695	finally
    //   510	517	1695	finally
    //   517	548	1695	finally
    //   553	562	1695	finally
    //   969	976	1695	finally
    //   1685	1692	1695	finally
    //   1706	1715	1695	finally
    //   1715	1722	1695	finally
    //   1803	1810	1695	finally
    //   1865	1874	1695	finally
    //   2434	2441	1695	finally
    //   265	277	1705	finally
    //   299	376	1705	finally
    //   376	396	1705	finally
    //   412	430	1705	finally
    //   445	456	1705	finally
    //   469	477	1705	finally
    //   481	489	1705	finally
    //   496	505	1705	finally
    //   1117	1135	1705	finally
    //   1142	1165	1705	finally
    //   1170	1223	1705	finally
    //   1223	1230	1705	finally
    //   1235	1285	1705	finally
    //   1304	1320	1705	finally
    //   1325	1333	1705	finally
    //   1343	1353	1705	finally
    //   1360	1383	1705	finally
    //   1388	1441	1705	finally
    //   1441	1448	1705	finally
    //   1453	1511	1705	finally
    //   1511	1536	1705	finally
    //   1541	1549	1705	finally
    //   1559	1575	1705	finally
    //   1578	1597	1705	finally
    //   1619	1627	1705	finally
    //   1637	1646	1705	finally
    //   1664	1685	1705	finally
    //   606	635	1778	android/database/sqlite/SQLiteException
    //   639	648	1778	android/database/sqlite/SQLiteException
    //   652	660	1778	android/database/sqlite/SQLiteException
    //   664	674	1778	android/database/sqlite/SQLiteException
    //   678	689	1778	android/database/sqlite/SQLiteException
    //   693	706	1778	android/database/sqlite/SQLiteException
    //   710	719	1778	android/database/sqlite/SQLiteException
    //   723	800	1778	android/database/sqlite/SQLiteException
    //   804	812	1778	android/database/sqlite/SQLiteException
    //   816	840	1778	android/database/sqlite/SQLiteException
    //   844	854	1778	android/database/sqlite/SQLiteException
    //   858	893	1778	android/database/sqlite/SQLiteException
    //   897	904	1778	android/database/sqlite/SQLiteException
    //   913	939	1778	android/database/sqlite/SQLiteException
    //   943	955	1778	android/database/sqlite/SQLiteException
    //   1738	1746	1778	android/database/sqlite/SQLiteException
    //   1750	1775	1778	android/database/sqlite/SQLiteException
    //   1817	1841	1778	android/database/sqlite/SQLiteException
    //   1845	1861	1778	android/database/sqlite/SQLiteException
    //   1878	1906	1778	android/database/sqlite/SQLiteException
    //   1917	1925	1778	android/database/sqlite/SQLiteException
    //   1929	1939	1778	android/database/sqlite/SQLiteException
    //   1948	1956	1778	android/database/sqlite/SQLiteException
    //   1960	1967	1778	android/database/sqlite/SQLiteException
    //   2041	2057	1778	android/database/sqlite/SQLiteException
    //   2068	2084	1778	android/database/sqlite/SQLiteException
    //   2091	2107	1778	android/database/sqlite/SQLiteException
    //   2114	2120	1778	android/database/sqlite/SQLiteException
    //   2124	2133	1778	android/database/sqlite/SQLiteException
    //   2137	2145	1778	android/database/sqlite/SQLiteException
    //   2154	2191	1778	android/database/sqlite/SQLiteException
    //   2198	2214	1778	android/database/sqlite/SQLiteException
    //   2221	2229	1778	android/database/sqlite/SQLiteException
    //   2233	2244	1778	android/database/sqlite/SQLiteException
    //   2248	2257	1778	android/database/sqlite/SQLiteException
    //   2261	2269	1778	android/database/sqlite/SQLiteException
    //   2273	2284	1778	android/database/sqlite/SQLiteException
    //   2291	2349	1778	android/database/sqlite/SQLiteException
    //   2356	2367	1778	android/database/sqlite/SQLiteException
    //   2376	2384	1778	android/database/sqlite/SQLiteException
    //   2388	2402	1778	android/database/sqlite/SQLiteException
    //   2406	2412	1778	android/database/sqlite/SQLiteException
    //   2416	2419	1778	android/database/sqlite/SQLiteException
    //   2423	2431	1778	android/database/sqlite/SQLiteException
    //   567	576	1864	finally
    //   581	593	1864	finally
    //   606	635	1864	finally
    //   639	648	1864	finally
    //   652	660	1864	finally
    //   664	674	1864	finally
    //   678	689	1864	finally
    //   693	706	1864	finally
    //   710	719	1864	finally
    //   723	800	1864	finally
    //   804	812	1864	finally
    //   816	840	1864	finally
    //   844	854	1864	finally
    //   858	893	1864	finally
    //   897	904	1864	finally
    //   913	939	1864	finally
    //   943	955	1864	finally
    //   955	964	1864	finally
    //   1738	1746	1864	finally
    //   1750	1775	1864	finally
    //   1783	1803	1864	finally
    //   1817	1841	1864	finally
    //   1845	1861	1864	finally
    //   1878	1906	1864	finally
    //   1917	1925	1864	finally
    //   1929	1939	1864	finally
    //   1948	1956	1864	finally
    //   1960	1967	1864	finally
    //   1974	2002	1864	finally
    //   2006	2034	1864	finally
    //   2041	2057	1864	finally
    //   2068	2084	1864	finally
    //   2091	2107	1864	finally
    //   2114	2120	1864	finally
    //   2124	2133	1864	finally
    //   2137	2145	1864	finally
    //   2154	2191	1864	finally
    //   2198	2214	1864	finally
    //   2221	2229	1864	finally
    //   2233	2244	1864	finally
    //   2248	2257	1864	finally
    //   2261	2269	1864	finally
    //   2273	2284	1864	finally
    //   2291	2349	1864	finally
    //   2356	2367	1864	finally
    //   2376	2384	1864	finally
    //   2388	2402	1864	finally
    //   2406	2412	1864	finally
    //   2416	2419	1864	finally
    //   2423	2431	1864	finally
    //   913	939	2370	java/io/IOException
    //   983	993	2449	java/io/IOException
    //   567	576	2457	android/database/sqlite/SQLiteException
    //   581	593	2466	android/database/sqlite/SQLiteException
    //   1974	2002	2470	android/database/sqlite/SQLiteException
    //   2006	2034	2470	android/database/sqlite/SQLiteException
    //   955	964	2474	android/database/sqlite/SQLiteException
    //   469	477	2478	android/database/sqlite/SQLiteException
    //   481	489	2478	android/database/sqlite/SQLiteException
    //   496	505	2478	android/database/sqlite/SQLiteException
  }
  
  public final List<j> b(j.b paramb, int paramInt, String paramString)
  {
    ??? = this.t.a(paramb);
    if ((??? == null) || (paramString == null) || (!paramString.equals(((j)???).f)))
    {
      Log.w("msgstore/get/statusPrevious invalid");
      return null;
    }
    long l1 = e((j)???);
    if (l1 == 1L)
    {
      Log.i("msgstore/get/statusPrevious no id for " + paramb);
      return null;
    }
    Object localObject2 = "SELECT key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, raw_data, recipient_count, participant_hash, starred, quoted_row_id, mentioned_jids, multicast_id, edit_version, receipt_server_timestamp, media_enc_hash, _id FROM messages WHERE  key_remote_jid=status@broadcast AND remote_resource=? AND _id<? ORDER BY _id DESC LIMIT " + paramInt;
    synchronized (this.b)
    {
      paramString = this.b.getReadableDatabase().rawQuery((String)localObject2, new String[] { paramString, String.valueOf(l1) });
      if (paramString == null) {
        break label201;
      }
      ??? = new LinkedList();
      while (paramString.moveToNext())
      {
        localObject2 = this.t.a(paramString, paramb.a);
        if (localObject2 != null) {
          ((LinkedList)???).addFirst(localObject2);
        }
      }
    }
    paramString.close();
    return (List<j>)???;
    label201:
    Log.i("msgstore/get/previous cursor null " + paramb);
    return null;
  }
  
  public final ConcurrentLinkedQueue<j> b(long paramLong)
  {
    ConcurrentLinkedQueue localConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    this.i.lock();
    for (;;)
    {
      try
      {
        Object localObject = this.b.getReadableDatabase();
        if (localObject == null)
        {
          Log.e("msgstore/missedcalls/db-not-accessible");
          return localConcurrentLinkedQueue;
        }
        localObject = ((SQLiteDatabase)localObject).rawQuery("SELECT key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, raw_data, recipient_count, participant_hash, starred, quoted_row_id, mentioned_jids, multicast_id, edit_version, receipt_server_timestamp, media_enc_hash, _id, key_remote_jid FROM messages WHERE key_from_me=0 AND media_wa_type=8 AND media_duration=0 AND media_size=0 AND timestamp>=? ORDER BY _id DESC LIMIT 100", new String[] { Long.toString(paramLong) });
        if (localObject == null) {
          break label214;
        }
        int i1 = ((Cursor)localObject).getColumnIndex("key_remote_jid");
        String str;
        try
        {
          if (!((Cursor)localObject).moveToNext()) {
            break;
          }
          str = ((Cursor)localObject).getString(i1);
          if (str == null)
          {
            Log.w("msgstore/calls/jid is null!");
            continue;
            localCursor = finally;
          }
        }
        catch (SQLiteDiskIOException localSQLiteDiskIOException)
        {
          a.a.a.a.d.h(this.J);
          throw localSQLiteDiskIOException;
        }
        finally
        {
          ((Cursor)localObject).close();
        }
        localConcurrentLinkedQueue1.add(this.t.a(localCursor, str));
      }
      finally
      {
        this.i.unlock();
      }
    }
    localCursor.close();
    for (;;)
    {
      this.i.unlock();
      Log.i("msgstore/missedcalls/size:" + localConcurrentLinkedQueue1.size());
      return localConcurrentLinkedQueue1;
      label214:
      Log.e("msgstore/missedcalls/db/cursor is null");
    }
  }
  
  public final void b()
  {
    this.b.close();
    e();
    Log.i("msgstore-manager/deletedb/result/" + this.b.a());
  }
  
  public final void b(j paramj, int paramInt)
  {
    if (paramj.a())
    {
      Message.obtain(this.d, 1, paramInt, 0, paramj).sendToTarget();
      return;
    }
    if ((!i(paramj)) && (!B(paramj.e.a)) && (!e.b(paramj.e.a)))
    {
      this.d.post(bt.a(this, paramj, paramInt));
      return;
    }
    c(paramj, paramInt);
    Message.obtain(this.d, 1, paramInt, 0, paramj).sendToTarget();
  }
  
  public final void b(Collection<j> paramCollection, boolean paramBoolean1, boolean paramBoolean2)
  {
    Log.i("msgstore/deletemessages " + paramCollection.size());
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      this.y.a(localj.e);
    }
    this.d.post(ao.a(this, paramCollection, paramBoolean1, paramBoolean2));
  }
  
  public final boolean b(j paramj)
  {
    if (paramj.e.b)
    {
      if ((paramj.s != 0) || (paramj.d != 6)) {}
    }
    else
    {
      switch ((int)paramj.t)
      {
      case 2: 
      case 3: 
      case 7: 
      case 8: 
      case 9: 
      case 10: 
      case 13: 
      case 15: 
      case 16: 
      case 18: 
      case 19: 
      default: 
        return false;
      case 1: 
      case 4: 
      case 5: 
      case 6: 
      case 11: 
      case 12: 
      case 14: 
      case 17: 
        return this.l.a(paramj.f);
      }
      return ((Collection)paramj.N).contains(this.l.c().t);
    }
    return true;
  }
  
  /* Error */
  public final boolean b(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: new 1033	android/content/ContentValues
    //   5: dup
    //   6: invokespecial 1103	android/content/ContentValues:<init>	()V
    //   9: astore_3
    //   10: aload_3
    //   11: ldc_w 3120
    //   14: iconst_0
    //   15: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   18: invokevirtual 1090	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   21: aload_0
    //   22: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   25: invokevirtual 419	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   28: aload_0
    //   29: getfield 361	com/whatsapp/data/ad:b	Lcom/whatsapp/data/n;
    //   32: invokevirtual 604	com/whatsapp/data/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   35: ldc -51
    //   37: aload_3
    //   38: ldc_w 3122
    //   41: iconst_2
    //   42: anewarray 429	java/lang/String
    //   45: dup
    //   46: iconst_0
    //   47: aload_1
    //   48: aastore
    //   49: dup
    //   50: iconst_1
    //   51: ldc_w 3124
    //   54: aastore
    //   55: invokevirtual 1062	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   58: ifle +39 -> 97
    //   61: iload_2
    //   62: ifeq +26 -> 88
    //   65: aload_0
    //   66: getfield 327	com/whatsapp/data/ad:y	Lcom/whatsapp/data/aa;
    //   69: new 3126	com/whatsapp/data/aq
    //   72: dup
    //   73: aload_1
    //   74: invokespecial 3127	com/whatsapp/data/aq:<init>	(Ljava/lang/String;)V
    //   77: invokevirtual 2715	com/whatsapp/data/aa:a	(Lcom/whatsapp/data/ad$k;)V
    //   80: aload_0
    //   81: getfield 393	com/whatsapp/data/ad:L	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   84: iconst_0
    //   85: invokevirtual 3131	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   88: aload_0
    //   89: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   92: invokevirtual 460	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   95: iload_2
    //   96: ireturn
    //   97: iconst_0
    //   98: istore_2
    //   99: goto -38 -> 61
    //   102: astore_1
    //   103: aload_0
    //   104: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   107: invokevirtual 460	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   110: aload_1
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	ad
    //   0	112	1	paramString	String
    //   1	98	2	bool	boolean
    //   9	29	3	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   28	61	102	finally
    //   65	88	102	finally
  }
  
  /* Error */
  public final boolean b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: anewarray 429	java/lang/String
    //   4: astore 5
    //   6: aload 5
    //   8: iconst_0
    //   9: aload_1
    //   10: aastore
    //   11: aconst_null
    //   12: astore_3
    //   13: aload_0
    //   14: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   17: invokevirtual 419	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   20: aload_0
    //   21: getfield 361	com/whatsapp/data/ad:b	Lcom/whatsapp/data/n;
    //   24: invokevirtual 604	com/whatsapp/data/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   27: astore 4
    //   29: aload 4
    //   31: astore_3
    //   32: aload 4
    //   34: invokevirtual 1143	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   37: aload 4
    //   39: astore_3
    //   40: aload 4
    //   42: ldc_w 3134
    //   45: aload 5
    //   47: invokevirtual 3138	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   50: aload 4
    //   52: astore_3
    //   53: aload 4
    //   55: ldc_w 3140
    //   58: aload 5
    //   60: invokevirtual 3138	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   63: aload 4
    //   65: astore_3
    //   66: aload 4
    //   68: ldc_w 3142
    //   71: aload 5
    //   73: invokevirtual 3138	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   76: aload 4
    //   78: astore_3
    //   79: aload_0
    //   80: getfield 281	com/whatsapp/data/ad:n	Lcom/whatsapp/data/d;
    //   83: getfield 1406	com/whatsapp/data/d:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   86: aload_1
    //   87: invokevirtual 3143	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   90: pop
    //   91: aload 4
    //   93: astore_3
    //   94: new 1033	android/content/ContentValues
    //   97: dup
    //   98: iconst_1
    //   99: invokespecial 1036	android/content/ContentValues:<init>	(I)V
    //   102: astore_1
    //   103: aload 4
    //   105: astore_3
    //   106: aload_1
    //   107: ldc_w 1038
    //   110: aload_2
    //   111: invokevirtual 1042	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   114: aload 4
    //   116: astore_3
    //   117: aload 4
    //   119: ldc_w 1056
    //   122: aload_1
    //   123: ldc_w 1107
    //   126: aload 5
    //   128: invokevirtual 1062	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   131: pop
    //   132: aload 4
    //   134: astore_3
    //   135: aload 4
    //   137: invokevirtual 1160	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   140: aload 4
    //   142: ifnull +16 -> 158
    //   145: aload 4
    //   147: invokevirtual 1163	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   150: ifeq +8 -> 158
    //   153: aload 4
    //   155: invokevirtual 1166	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   158: aload_0
    //   159: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   162: invokevirtual 460	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   165: iconst_1
    //   166: ireturn
    //   167: astore_1
    //   168: aload_3
    //   169: ifnull +14 -> 183
    //   172: aload_3
    //   173: invokevirtual 1163	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   176: ifeq +7 -> 183
    //   179: aload_3
    //   180: invokevirtual 1166	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   183: aload_1
    //   184: athrow
    //   185: astore_1
    //   186: aload_0
    //   187: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   190: invokevirtual 460	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   193: aload_1
    //   194: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	this	ad
    //   0	195	1	paramString1	String
    //   0	195	2	paramString2	String
    //   12	168	3	localObject	Object
    //   27	127	4	localSQLiteDatabase	SQLiteDatabase
    //   4	123	5	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   20	29	167	finally
    //   32	37	167	finally
    //   40	50	167	finally
    //   53	63	167	finally
    //   66	76	167	finally
    //   79	91	167	finally
    //   94	103	167	finally
    //   106	114	167	finally
    //   117	132	167	finally
    //   135	140	167	finally
    //   145	158	185	finally
    //   172	183	185	finally
    //   183	185	185	finally
  }
  
  public final int c(String paramString)
  {
    int i2;
    if (paramString != null)
    {
      Iterator localIterator = g().iterator();
      int i1 = 0;
      i2 = i1;
      if (!localIterator.hasNext()) {
        break label59;
      }
      if (!paramString.equals(((j)localIterator.next()).e.a)) {
        break label61;
      }
      i1 += 1;
    }
    label59:
    label61:
    for (;;)
    {
      break;
      i2 = 0;
      return i2;
    }
  }
  
  public final int c(String paramString, long paramLong)
  {
    int i1 = 0;
    Cursor localCursor = this.b.getReadableDatabase().rawQuery("SELECT COUNT(*) FROM messages WHERE key_remote_jid=? AND media_wa_type!=8 AND _id>? ", new String[] { paramString, String.valueOf(paramLong) });
    if (localCursor != null) {
      try
      {
        if (localCursor.moveToNext()) {
          i1 = localCursor.getInt(0);
        }
        for (;;)
        {
          return i1;
          Log.i("msgstore/getnewercount/db no message for " + paramString);
        }
        Log.e("msgstore/getnewercount/cursor is null");
      }
      finally
      {
        localCursor.close();
      }
    }
    return 0;
  }
  
  public final Cursor c(String paramString1, String paramString2, android.support.v4.d.a parama)
  {
    Log.d("msgstore/getDocumentMessagesCursor:" + paramString1);
    this.i.lock();
    try
    {
      if (TextUtils.isEmpty(paramString2)) {}
      for (paramString2 = null; !TextUtils.isEmpty(paramString2); paramString2 = q.c(paramString2))
      {
        paramString1 = a("SELECT key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, raw_data, recipient_count, participant_hash, starred, quoted_row_id, mentioned_jids, multicast_id, edit_version, receipt_server_timestamp, media_enc_hash, _id FROM messages WHERE _id IN (SELECT docid FROM messages_fts, messages WHERE content MATCH ? AND messages_fts.docid = messages._id AND messages.media_wa_type = 9 AND messages.key_remote_jid=?) ORDER BY _id DESC", new String[] { paramString2, paramString1 }, parama);
        return paramString1;
      }
      paramString1 = a("SELECT key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, raw_data, recipient_count, participant_hash, starred, quoted_row_id, mentioned_jids, multicast_id, edit_version, receipt_server_timestamp, media_enc_hash, _id FROM messages WHERE  media_wa_type=9 AND key_remote_jid=? ORDER BY _id DESC", new String[] { paramString1 }, parama);
      return paramString1;
    }
    finally
    {
      this.i.unlock();
    }
  }
  
  /* Error */
  final h c(File paramFile)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: new 29	com/whatsapp/data/ad$h
    //   5: dup
    //   6: invokespecial 3159	com/whatsapp/data/ad$h:<init>	()V
    //   9: astore 6
    //   11: aload 6
    //   13: new 2056	java/util/HashMap
    //   16: dup
    //   17: invokespecial 2057	java/util/HashMap:<init>	()V
    //   20: putfield 2267	com/whatsapp/data/ad$h:b	Ljava/util/HashMap;
    //   23: aload 6
    //   25: new 955	java/util/ArrayList
    //   28: dup
    //   29: invokespecial 956	java/util/ArrayList:<init>	()V
    //   32: putfield 2273	com/whatsapp/data/ad$h:c	Ljava/util/ArrayList;
    //   35: ldc_w 3161
    //   38: invokestatic 3167	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   41: astore 7
    //   43: getstatic 535	android/os/Build$VERSION:SDK_INT	I
    //   46: bipush 11
    //   48: if_icmplt +117 -> 165
    //   51: aload_1
    //   52: invokevirtual 1617	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   55: aconst_null
    //   56: getstatic 1660	com/whatsapp/data/n:h	I
    //   59: aload_1
    //   60: invokestatic 3172	com/whatsapp/data/bh:a	(Ljava/io/File;)Landroid/database/DatabaseErrorHandler;
    //   63: invokestatic 3175	android/database/sqlite/SQLiteDatabase:openDatabase	(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;ILandroid/database/DatabaseErrorHandler;)Landroid/database/sqlite/SQLiteDatabase;
    //   66: astore 5
    //   68: aload 5
    //   70: ldc_w 1666
    //   73: aconst_null
    //   74: invokevirtual 435	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   77: astore 8
    //   79: aload 8
    //   81: ifnull +507 -> 588
    //   84: aload 8
    //   86: invokeinterface 441 1 0
    //   91: ifeq +236 -> 327
    //   94: iload_2
    //   95: iconst_1
    //   96: iadd
    //   97: istore_2
    //   98: aload 8
    //   100: iconst_0
    //   101: invokeinterface 2073 2 0
    //   106: astore 9
    //   108: iload_2
    //   109: iconst_1
    //   110: if_icmpne +92 -> 202
    //   113: ldc_w 1677
    //   116: aload 9
    //   118: invokevirtual 1680	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   121: istore 4
    //   123: iload 4
    //   125: ifeq +77 -> 202
    //   128: aload 8
    //   130: invokeinterface 457 1 0
    //   135: aload 5
    //   137: ifnull +8 -> 145
    //   140: aload 5
    //   142: invokevirtual 1673	android/database/sqlite/SQLiteDatabase:close	()V
    //   145: aload_1
    //   146: invokevirtual 1658	java/io/File:exists	()Z
    //   149: ifne +42 -> 191
    //   152: ldc_w 3177
    //   155: invokestatic 474	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   158: aload_0
    //   159: invokevirtual 3179	com/whatsapp/data/ad:q	()V
    //   162: aload 6
    //   164: areturn
    //   165: ldc_w 3181
    //   168: invokestatic 474	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   171: aload_0
    //   172: invokevirtual 3183	com/whatsapp/data/ad:p	()V
    //   175: aload_1
    //   176: invokevirtual 1617	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   179: aconst_null
    //   180: getstatic 1660	com/whatsapp/data/n:h	I
    //   183: invokestatic 1664	android/database/sqlite/SQLiteDatabase:openDatabase	(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)Landroid/database/sqlite/SQLiteDatabase;
    //   186: astore 5
    //   188: goto -120 -> 68
    //   191: aload_0
    //   192: getfield 273	com/whatsapp/data/ad:I	Ljava/io/File;
    //   195: invokestatic 1299	a/a/a/a/d:d	(Ljava/io/File;)Z
    //   198: pop
    //   199: goto -37 -> 162
    //   202: new 162	java/lang/StringBuilder
    //   205: dup
    //   206: ldc_w 3185
    //   209: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   212: iload_2
    //   213: invokevirtual 1120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   216: ldc_w 1310
    //   219: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: aload 9
    //   224: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokestatic 474	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   233: aload 7
    //   235: aload 9
    //   237: invokevirtual 3189	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   240: astore 10
    //   242: aload 10
    //   244: invokevirtual 3194	java/util/regex/Matcher:find	()Z
    //   247: ifeq +66 -> 313
    //   250: aload 10
    //   252: iconst_1
    //   253: invokevirtual 3197	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   256: astore 9
    //   258: aload 6
    //   260: getfield 2267	com/whatsapp/data/ad$h:b	Ljava/util/HashMap;
    //   263: aload 9
    //   265: invokevirtual 3198	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   268: checkcast 170	java/lang/Integer
    //   271: astore 10
    //   273: aload 6
    //   275: getfield 2267	com/whatsapp/data/ad$h:b	Ljava/util/HashMap;
    //   278: astore 11
    //   280: aload 10
    //   282: ifnonnull +20 -> 302
    //   285: iconst_1
    //   286: istore_3
    //   287: aload 11
    //   289: aload 9
    //   291: iload_3
    //   292: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   295: invokevirtual 3199	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   298: pop
    //   299: goto -215 -> 84
    //   302: aload 10
    //   304: invokevirtual 1598	java/lang/Integer:intValue	()I
    //   307: iconst_1
    //   308: iadd
    //   309: istore_3
    //   310: goto -23 -> 287
    //   313: aload 6
    //   315: getfield 2273	com/whatsapp/data/ad$h:c	Ljava/util/ArrayList;
    //   318: aload 9
    //   320: invokevirtual 982	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   323: pop
    //   324: goto -240 -> 84
    //   327: aload 6
    //   329: iload_2
    //   330: putfield 2294	com/whatsapp/data/ad$h:a	I
    //   333: aload 8
    //   335: invokeinterface 457 1 0
    //   340: aload 6
    //   342: getfield 2267	com/whatsapp/data/ad$h:b	Ljava/util/HashMap;
    //   345: invokevirtual 3200	java/util/HashMap:keySet	()Ljava/util/Set;
    //   348: invokeinterface 1028 1 0
    //   353: astore 7
    //   355: aload 7
    //   357: invokeinterface 915 1 0
    //   362: ifeq +272 -> 634
    //   365: aload 7
    //   367: invokeinterface 918 1 0
    //   372: checkcast 429	java/lang/String
    //   375: astore 8
    //   377: aload 6
    //   379: getfield 2267	com/whatsapp/data/ad$h:b	Ljava/util/HashMap;
    //   382: aload 8
    //   384: invokevirtual 3198	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   387: checkcast 170	java/lang/Integer
    //   390: astore 9
    //   392: new 162	java/lang/StringBuilder
    //   395: dup
    //   396: ldc_w 3202
    //   399: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   402: aload 8
    //   404: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: ldc_w 3204
    //   410: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: aload 9
    //   415: invokevirtual 583	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   418: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   421: invokestatic 474	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   424: goto -69 -> 355
    //   427: astore 6
    //   429: new 162	java/lang/StringBuilder
    //   432: dup
    //   433: ldc_w 3206
    //   436: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   439: aload 6
    //   441: invokevirtual 583	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   444: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   447: invokestatic 509	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   450: aload 5
    //   452: ifnull +8 -> 460
    //   455: aload 5
    //   457: invokevirtual 1673	android/database/sqlite/SQLiteDatabase:close	()V
    //   460: aload_1
    //   461: invokevirtual 1658	java/io/File:exists	()Z
    //   464: ifne +267 -> 731
    //   467: ldc_w 3177
    //   470: invokestatic 474	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   473: aload_0
    //   474: invokevirtual 3179	com/whatsapp/data/ad:q	()V
    //   477: aconst_null
    //   478: areturn
    //   479: astore 6
    //   481: ldc_w 3208
    //   484: aload 6
    //   486: invokestatic 1629	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   489: aload 8
    //   491: invokeinterface 457 1 0
    //   496: aload 5
    //   498: ifnull +8 -> 506
    //   501: aload 5
    //   503: invokevirtual 1673	android/database/sqlite/SQLiteDatabase:close	()V
    //   506: aload_1
    //   507: invokevirtual 1658	java/io/File:exists	()Z
    //   510: ifne +15 -> 525
    //   513: ldc_w 3177
    //   516: invokestatic 474	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   519: aload_0
    //   520: invokevirtual 3179	com/whatsapp/data/ad:q	()V
    //   523: aconst_null
    //   524: areturn
    //   525: aload_0
    //   526: getfield 273	com/whatsapp/data/ad:I	Ljava/io/File;
    //   529: invokestatic 1299	a/a/a/a/d:d	(Ljava/io/File;)Z
    //   532: pop
    //   533: goto -10 -> 523
    //   536: astore 6
    //   538: aload 8
    //   540: invokeinterface 457 1 0
    //   545: aload 6
    //   547: athrow
    //   548: astore 7
    //   550: aload 5
    //   552: astore 6
    //   554: aload 7
    //   556: astore 5
    //   558: aload 6
    //   560: ifnull +8 -> 568
    //   563: aload 6
    //   565: invokevirtual 1673	android/database/sqlite/SQLiteDatabase:close	()V
    //   568: aload_1
    //   569: invokevirtual 1658	java/io/File:exists	()Z
    //   572: ifne +170 -> 742
    //   575: ldc_w 3177
    //   578: invokestatic 474	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   581: aload_0
    //   582: invokevirtual 3179	com/whatsapp/data/ad:q	()V
    //   585: aload 5
    //   587: athrow
    //   588: ldc_w 3210
    //   591: invokestatic 505	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   594: aload 5
    //   596: ifnull +8 -> 604
    //   599: aload 5
    //   601: invokevirtual 1673	android/database/sqlite/SQLiteDatabase:close	()V
    //   604: aload_1
    //   605: invokevirtual 1658	java/io/File:exists	()Z
    //   608: ifne +15 -> 623
    //   611: ldc_w 3177
    //   614: invokestatic 474	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   617: aload_0
    //   618: invokevirtual 3179	com/whatsapp/data/ad:q	()V
    //   621: aconst_null
    //   622: areturn
    //   623: aload_0
    //   624: getfield 273	com/whatsapp/data/ad:I	Ljava/io/File;
    //   627: invokestatic 1299	a/a/a/a/d:d	(Ljava/io/File;)Z
    //   630: pop
    //   631: goto -10 -> 621
    //   634: aload 6
    //   636: getfield 2273	com/whatsapp/data/ad$h:c	Ljava/util/ArrayList;
    //   639: invokevirtual 969	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   642: astore 7
    //   644: aload 7
    //   646: invokeinterface 915 1 0
    //   651: ifeq +39 -> 690
    //   654: aload 7
    //   656: invokeinterface 918 1 0
    //   661: checkcast 429	java/lang/String
    //   664: astore 8
    //   666: new 162	java/lang/StringBuilder
    //   669: dup
    //   670: ldc_w 3212
    //   673: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   676: aload 8
    //   678: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   684: invokestatic 474	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   687: goto -43 -> 644
    //   690: aload 5
    //   692: ifnull +8 -> 700
    //   695: aload 5
    //   697: invokevirtual 1673	android/database/sqlite/SQLiteDatabase:close	()V
    //   700: aload_1
    //   701: invokevirtual 1658	java/io/File:exists	()Z
    //   704: ifne +16 -> 720
    //   707: ldc_w 3177
    //   710: invokestatic 474	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   713: aload_0
    //   714: invokevirtual 3179	com/whatsapp/data/ad:q	()V
    //   717: aload 6
    //   719: areturn
    //   720: aload_0
    //   721: getfield 273	com/whatsapp/data/ad:I	Ljava/io/File;
    //   724: invokestatic 1299	a/a/a/a/d:d	(Ljava/io/File;)Z
    //   727: pop
    //   728: goto -11 -> 717
    //   731: aload_0
    //   732: getfield 273	com/whatsapp/data/ad:I	Ljava/io/File;
    //   735: invokestatic 1299	a/a/a/a/d:d	(Ljava/io/File;)Z
    //   738: pop
    //   739: goto -262 -> 477
    //   742: aload_0
    //   743: getfield 273	com/whatsapp/data/ad:I	Ljava/io/File;
    //   746: invokestatic 1299	a/a/a/a/d:d	(Ljava/io/File;)Z
    //   749: pop
    //   750: goto -165 -> 585
    //   753: astore 5
    //   755: aconst_null
    //   756: astore 6
    //   758: goto -200 -> 558
    //   761: astore 7
    //   763: aload 5
    //   765: astore 6
    //   767: aload 7
    //   769: astore 5
    //   771: goto -213 -> 558
    //   774: astore 6
    //   776: aconst_null
    //   777: astore 5
    //   779: goto -350 -> 429
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	782	0	this	ad
    //   0	782	1	paramFile	File
    //   1	329	2	i1	int
    //   286	24	3	i2	int
    //   121	3	4	bool	boolean
    //   66	630	5	localObject1	Object
    //   753	11	5	localObject2	Object
    //   769	9	5	localObject3	Object
    //   9	369	6	localh	h
    //   427	13	6	localException1	Exception
    //   479	6	6	localException2	Exception
    //   536	10	6	localObject4	Object
    //   552	214	6	localObject5	Object
    //   774	1	6	localException3	Exception
    //   41	325	7	localObject6	Object
    //   548	7	7	localObject7	Object
    //   642	13	7	localIterator	Iterator
    //   761	7	7	localObject8	Object
    //   77	600	8	localObject9	Object
    //   106	308	9	localObject10	Object
    //   240	63	10	localObject11	Object
    //   278	10	11	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   68	79	427	java/lang/Exception
    //   128	135	427	java/lang/Exception
    //   333	355	427	java/lang/Exception
    //   355	424	427	java/lang/Exception
    //   489	496	427	java/lang/Exception
    //   538	548	427	java/lang/Exception
    //   588	594	427	java/lang/Exception
    //   634	644	427	java/lang/Exception
    //   644	687	427	java/lang/Exception
    //   84	94	479	java/lang/Exception
    //   98	108	479	java/lang/Exception
    //   113	123	479	java/lang/Exception
    //   202	280	479	java/lang/Exception
    //   287	299	479	java/lang/Exception
    //   302	310	479	java/lang/Exception
    //   313	324	479	java/lang/Exception
    //   327	333	479	java/lang/Exception
    //   84	94	536	finally
    //   98	108	536	finally
    //   113	123	536	finally
    //   202	280	536	finally
    //   287	299	536	finally
    //   302	310	536	finally
    //   313	324	536	finally
    //   327	333	536	finally
    //   481	489	536	finally
    //   68	79	548	finally
    //   128	135	548	finally
    //   333	355	548	finally
    //   355	424	548	finally
    //   489	496	548	finally
    //   538	548	548	finally
    //   588	594	548	finally
    //   634	644	548	finally
    //   644	687	548	finally
    //   43	68	753	finally
    //   165	188	753	finally
    //   429	450	761	finally
    //   43	68	774	java/lang/Exception
    //   165	188	774	java/lang/Exception
  }
  
  /* Error */
  public final void c()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: new 162	java/lang/StringBuilder
    //   5: dup
    //   6: ldc_w 3214
    //   9: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   12: aload_0
    //   13: getfield 329	com/whatsapp/data/ad:z	Lcom/whatsapp/data/ch;
    //   16: getfield 2033	com/whatsapp/data/ch:d	Z
    //   19: invokevirtual 1763	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   22: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 474	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   28: aload_0
    //   29: monitorenter
    //   30: aload_0
    //   31: getfield 329	com/whatsapp/data/ad:z	Lcom/whatsapp/data/ch;
    //   34: getfield 2033	com/whatsapp/data/ch:d	Z
    //   37: ifne +19 -> 56
    //   40: ldc_w 3216
    //   43: new 3218	java/lang/Throwable
    //   46: dup
    //   47: invokespecial 3219	java/lang/Throwable:<init>	()V
    //   50: invokestatic 2298	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   53: aload_0
    //   54: monitorexit
    //   55: return
    //   56: aload_0
    //   57: invokespecial 3221	com/whatsapp/data/ad:s	()V
    //   60: aload_0
    //   61: getfield 325	com/whatsapp/data/ad:x	Lcom/whatsapp/data/co;
    //   64: astore_2
    //   65: aload_2
    //   66: getfield 1855	com/whatsapp/data/co:b	Lcom/whatsapp/data/cj;
    //   69: ldc_w 1264
    //   72: invokevirtual 3223	com/whatsapp/data/cj:a	(Ljava/lang/String;)Ljava/lang/String;
    //   75: astore_3
    //   76: aload_3
    //   77: ifnull +62 -> 139
    //   80: aload_2
    //   81: getfield 1855	com/whatsapp/data/co:b	Lcom/whatsapp/data/cj;
    //   84: ldc_w 3225
    //   87: invokevirtual 3223	com/whatsapp/data/cj:a	(Ljava/lang/String;)Ljava/lang/String;
    //   90: astore 4
    //   92: aload 4
    //   94: ifnonnull +90 -> 184
    //   97: iload_1
    //   98: ifeq +120 -> 218
    //   101: aload_3
    //   102: invokestatic 518	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   105: ifeq +88 -> 193
    //   108: aload_2
    //   109: getfield 1855	com/whatsapp/data/co:b	Lcom/whatsapp/data/cj;
    //   112: ldc_w 3227
    //   115: iconst_0
    //   116: invokevirtual 1885	com/whatsapp/data/cj:a	(Ljava/lang/String;I)V
    //   119: aload_2
    //   120: getfield 1855	com/whatsapp/data/co:b	Lcom/whatsapp/data/cj;
    //   123: ldc_w 3225
    //   126: invokevirtual 3229	com/whatsapp/data/cj:c	(Ljava/lang/String;)V
    //   129: aload_2
    //   130: getfield 1855	com/whatsapp/data/co:b	Lcom/whatsapp/data/cj;
    //   133: ldc_w 1264
    //   136: invokevirtual 3229	com/whatsapp/data/cj:c	(Ljava/lang/String;)V
    //   139: aload_0
    //   140: getfield 329	com/whatsapp/data/ad:z	Lcom/whatsapp/data/ch;
    //   143: iconst_1
    //   144: putfield 3230	com/whatsapp/data/ch:e	Z
    //   147: aload_0
    //   148: monitorexit
    //   149: return
    //   150: astore_2
    //   151: aload_0
    //   152: monitorexit
    //   153: aload_2
    //   154: athrow
    //   155: astore_2
    //   156: ldc_w 3232
    //   159: aload_2
    //   160: invokestatic 1629	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   163: aload_0
    //   164: getfield 361	com/whatsapp/data/ad:b	Lcom/whatsapp/data/n;
    //   167: invokevirtual 1838	com/whatsapp/data/n:close	()V
    //   170: aload_0
    //   171: getfield 319	com/whatsapp/data/ad:w	Lcom/whatsapp/data/cn;
    //   174: invokevirtual 1839	com/whatsapp/data/cn:c	()V
    //   177: aload_0
    //   178: invokespecial 3221	com/whatsapp/data/ad:s	()V
    //   181: goto -121 -> 60
    //   184: aload 4
    //   186: invokestatic 3235	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   189: istore_1
    //   190: goto -93 -> 97
    //   193: aload_2
    //   194: getfield 1855	com/whatsapp/data/co:b	Lcom/whatsapp/data/cj;
    //   197: ldc_w 3237
    //   200: aload_3
    //   201: invokevirtual 1587	com/whatsapp/data/cj:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   204: aload_2
    //   205: getfield 1855	com/whatsapp/data/co:b	Lcom/whatsapp/data/cj;
    //   208: ldc_w 3227
    //   211: iconst_2
    //   212: invokevirtual 1885	com/whatsapp/data/cj:a	(Ljava/lang/String;I)V
    //   215: goto -96 -> 119
    //   218: aload_2
    //   219: getfield 1855	com/whatsapp/data/co:b	Lcom/whatsapp/data/cj;
    //   222: ldc_w 3239
    //   225: aload_3
    //   226: invokevirtual 1587	com/whatsapp/data/cj:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   229: aload_2
    //   230: getfield 1855	com/whatsapp/data/co:b	Lcom/whatsapp/data/cj;
    //   233: ldc_w 3227
    //   236: iconst_1
    //   237: invokevirtual 1885	com/whatsapp/data/cj:a	(Ljava/lang/String;I)V
    //   240: goto -121 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	ad
    //   1	189	1	bool	boolean
    //   64	66	2	localco	co
    //   150	4	2	localObject	Object
    //   155	75	2	localIllegalStateException	IllegalStateException
    //   75	151	3	str1	String
    //   90	95	4	str2	String
    // Exception table:
    //   from	to	target	type
    //   30	55	150	finally
    //   56	60	150	finally
    //   60	76	150	finally
    //   80	92	150	finally
    //   101	119	150	finally
    //   119	139	150	finally
    //   139	149	150	finally
    //   151	153	150	finally
    //   156	181	150	finally
    //   184	190	150	finally
    //   193	215	150	finally
    //   218	240	150	finally
    //   56	60	155	java/lang/IllegalStateException
  }
  
  final void c(j paramj, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("msgstore/add/");
    if (paramj.e.b) {}
    for (Object localObject = "send";; localObject = "recv")
    {
      Log.i((String)localObject + "; key=" + paramj.e + "; media_wa_type=" + paramj.s + "; status=" + paramj.d);
      if (paramj.a(this.l))
      {
        Log.d("msgstore/add/self-send");
        paramj.d = 13;
      }
      if (Looper.myLooper() == Looper.getMainLooper()) {
        break;
      }
      localObject = new CountDownLatch(1);
      this.k.a(bx.a(this, paramj, paramInt, (CountDownLatch)localObject));
      try
      {
        ((CountDownLatch)localObject).await(5L, TimeUnit.SECONDS);
        return;
      }
      catch (InterruptedException paramj)
      {
        Log.e(paramj);
        return;
      }
    }
    this.u.a(paramj, paramInt);
  }
  
  public final void c(String paramString1, String paramString2)
  {
    this.d.post(az.a(this, paramString1, paramString2));
  }
  
  public final boolean c(j paramj)
  {
    d locald = (d)this.n.a.get(paramj.e.a);
    return (locald != null) && (paramj.Q <= locald.c);
  }
  
  /* Error */
  final ArrayList<j> d(String paramString)
  {
    // Byte code:
    //   0: new 411	com/whatsapp/util/bd
    //   3: dup
    //   4: invokespecial 1734	com/whatsapp/util/bd:<init>	()V
    //   7: astore 7
    //   9: aload 7
    //   11: ldc_w 3290
    //   14: invokevirtual 1738	com/whatsapp/util/bd:a	(Ljava/lang/String;)V
    //   17: new 955	java/util/ArrayList
    //   20: dup
    //   21: invokespecial 956	java/util/ArrayList:<init>	()V
    //   24: astore 8
    //   26: aload_0
    //   27: getfield 287	com/whatsapp/data/ad:P	Lcom/whatsapp/adp;
    //   30: aload_1
    //   31: invokevirtual 2661	com/whatsapp/adp:a	(Ljava/lang/String;)Z
    //   34: ifne +6 -> 40
    //   37: aload 8
    //   39: areturn
    //   40: aload_0
    //   41: getfield 281	com/whatsapp/data/ad:n	Lcom/whatsapp/data/d;
    //   44: getfield 1406	com/whatsapp/data/d:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   47: aload_1
    //   48: invokevirtual 1409	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   51: checkcast 17	com/whatsapp/data/ad$d
    //   54: astore 6
    //   56: aload 6
    //   58: ifnonnull +26 -> 84
    //   61: new 162	java/lang/StringBuilder
    //   64: dup
    //   65: ldc_w 3292
    //   68: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   71: aload_1
    //   72: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 505	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   81: aload 8
    //   83: areturn
    //   84: aload 6
    //   86: getfield 1492	com/whatsapp/data/ad$d:c	J
    //   89: aload 6
    //   91: getfield 1414	com/whatsapp/data/ad$d:d	J
    //   94: lcmp
    //   95: ifne +26 -> 121
    //   98: new 162	java/lang/StringBuilder
    //   101: dup
    //   102: ldc_w 3294
    //   105: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   108: aload_1
    //   109: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 487	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   118: aload 8
    //   120: areturn
    //   121: aload 6
    //   123: getfield 1492	com/whatsapp/data/ad$d:c	J
    //   126: lstore_2
    //   127: aload 6
    //   129: getfield 1414	com/whatsapp/data/ad$d:d	J
    //   132: lstore 4
    //   134: aload_0
    //   135: getfield 361	com/whatsapp/data/ad:b	Lcom/whatsapp/data/n;
    //   138: invokevirtual 425	com/whatsapp/data/n:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   141: ldc_w 3296
    //   144: iconst_3
    //   145: anewarray 429	java/lang/String
    //   148: dup
    //   149: iconst_0
    //   150: aload_1
    //   151: aastore
    //   152: dup
    //   153: iconst_1
    //   154: lload_2
    //   155: invokestatic 1348	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   158: aastore
    //   159: dup
    //   160: iconst_2
    //   161: lload 4
    //   163: invokestatic 1348	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   166: aastore
    //   167: invokevirtual 435	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   170: astore 6
    //   172: aload 6
    //   174: ifnull +76 -> 250
    //   177: aload 6
    //   179: invokeinterface 441 1 0
    //   184: ifeq +107 -> 291
    //   187: aload_0
    //   188: getfield 307	com/whatsapp/data/ad:t	Lcom/whatsapp/data/l;
    //   191: aload 6
    //   193: aload_1
    //   194: invokevirtual 446	com/whatsapp/data/l:a	(Landroid/database/Cursor;Ljava/lang/String;)Lcom/whatsapp/protocol/j;
    //   197: astore 9
    //   199: aload 9
    //   201: getfield 527	com/whatsapp/protocol/j:n	J
    //   204: ldc2_w 3297
    //   207: lcmp
    //   208: ifle -31 -> 177
    //   211: aload 8
    //   213: aload 9
    //   215: invokevirtual 982	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   218: pop
    //   219: goto -42 -> 177
    //   222: astore_1
    //   223: new 162	java/lang/StringBuilder
    //   226: dup
    //   227: ldc_w 3300
    //   230: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   233: aload_1
    //   234: invokevirtual 583	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 474	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   243: aload 6
    //   245: invokeinterface 457 1 0
    //   250: new 162	java/lang/StringBuilder
    //   253: dup
    //   254: ldc_w 3302
    //   257: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   260: aload 8
    //   262: invokevirtual 965	java/util/ArrayList:size	()I
    //   265: invokevirtual 1120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   268: ldc_w 1746
    //   271: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: aload 7
    //   276: invokevirtual 467	com/whatsapp/util/bd:b	()J
    //   279: invokevirtual 470	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   282: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokestatic 474	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   288: aload 8
    //   290: areturn
    //   291: aload 6
    //   293: invokeinterface 457 1 0
    //   298: goto -48 -> 250
    //   301: astore_1
    //   302: aload_0
    //   303: new 1171	java/lang/AssertionError
    //   306: dup
    //   307: aload_1
    //   308: invokespecial 1174	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   311: invokevirtual 1176	com/whatsapp/data/ad:a	(Ljava/lang/Throwable;)V
    //   314: aload 6
    //   316: invokeinterface 457 1 0
    //   321: goto -71 -> 250
    //   324: astore_1
    //   325: aload_0
    //   326: getfield 263	com/whatsapp/data/ad:J	Landroid/content/Context;
    //   329: invokestatic 2947	a/a/a/a/d:g	(Landroid/content/Context;)V
    //   332: aload_1
    //   333: athrow
    //   334: astore_1
    //   335: aload 6
    //   337: invokeinterface 457 1 0
    //   342: aload_1
    //   343: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	344	0	this	ad
    //   0	344	1	paramString	String
    //   126	29	2	l1	long
    //   132	30	4	l2	long
    //   54	282	6	localObject	Object
    //   7	268	7	localbd	bd
    //   24	265	8	localArrayList	ArrayList
    //   197	17	9	localj	j
    // Exception table:
    //   from	to	target	type
    //   177	219	222	java/lang/IllegalStateException
    //   177	219	301	android/database/sqlite/SQLiteDatabaseCorruptException
    //   177	219	324	android/database/sqlite/SQLiteFullException
    //   177	219	334	finally
    //   223	243	334	finally
    //   302	314	334	finally
    //   325	334	334	finally
  }
  
  /* Error */
  final void d(j paramj)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore 6
    //   8: aload_1
    //   9: getfield 849	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   12: astore_3
    //   13: new 162	java/lang/StringBuilder
    //   16: dup
    //   17: ldc_w 3305
    //   20: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   23: aload_3
    //   24: invokevirtual 583	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 487	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   33: aload_0
    //   34: getfield 361	com/whatsapp/data/ad:b	Lcom/whatsapp/data/n;
    //   37: invokevirtual 425	com/whatsapp/data/n:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   40: astore 4
    //   42: aload_3
    //   43: getfield 1059	com/whatsapp/protocol/j$b:a	Ljava/lang/String;
    //   46: astore 7
    //   48: aload_3
    //   49: getfield 853	com/whatsapp/protocol/j$b:b	Z
    //   52: ifeq +5 -> 57
    //   55: iconst_1
    //   56: istore_2
    //   57: aload 4
    //   59: ldc_w 3307
    //   62: iconst_3
    //   63: anewarray 429	java/lang/String
    //   66: dup
    //   67: iconst_0
    //   68: aload 7
    //   70: aastore
    //   71: dup
    //   72: iconst_1
    //   73: iload_2
    //   74: invokestatic 3309	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   77: aastore
    //   78: dup
    //   79: iconst_2
    //   80: aload_3
    //   81: getfield 934	com/whatsapp/protocol/j$b:c	Ljava/lang/String;
    //   84: aastore
    //   85: invokevirtual 435	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   88: astore 4
    //   90: aload 4
    //   92: ifnull +301 -> 393
    //   95: aload 4
    //   97: invokeinterface 1692 1 0
    //   102: ifeq +286 -> 388
    //   105: aload_0
    //   106: getfield 307	com/whatsapp/data/ad:t	Lcom/whatsapp/data/l;
    //   109: aload 4
    //   111: aload_3
    //   112: getfield 1059	com/whatsapp/protocol/j$b:a	Ljava/lang/String;
    //   115: invokevirtual 446	com/whatsapp/data/l:a	(Landroid/database/Cursor;Ljava/lang/String;)Lcom/whatsapp/protocol/j;
    //   118: astore_3
    //   119: aload 4
    //   121: invokeinterface 457 1 0
    //   126: aload_3
    //   127: astore 4
    //   129: aload_0
    //   130: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   133: invokevirtual 419	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   136: aload_0
    //   137: getfield 361	com/whatsapp/data/ad:b	Lcom/whatsapp/data/n;
    //   140: invokevirtual 604	com/whatsapp/data/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   143: astore_3
    //   144: aload_3
    //   145: invokevirtual 1143	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   148: aload 4
    //   150: ifnonnull +62 -> 212
    //   153: aload_3
    //   154: ldc_w 3311
    //   157: invokevirtual 3315	android/database/sqlite/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;
    //   160: astore 4
    //   162: aload_0
    //   163: getfield 301	com/whatsapp/data/ad:T	Lcom/whatsapp/data/c;
    //   166: aload_1
    //   167: aload 4
    //   169: invokevirtual 1905	com/whatsapp/data/c:a	(Lcom/whatsapp/protocol/j;Landroid/database/sqlite/SQLiteStatement;)V
    //   172: aload 4
    //   174: astore_1
    //   175: aload_1
    //   176: invokevirtual 1234	android/database/sqlite/SQLiteStatement:execute	()V
    //   179: aload_3
    //   180: ifnull +14 -> 194
    //   183: aload_3
    //   184: invokevirtual 1163	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   187: ifeq +7 -> 194
    //   190: aload_3
    //   191: invokevirtual 1166	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   194: aload_0
    //   195: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   198: invokevirtual 460	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   201: return
    //   202: astore_1
    //   203: aload 4
    //   205: invokeinterface 457 1 0
    //   210: aload_1
    //   211: athrow
    //   212: aload 4
    //   214: getfield 1231	com/whatsapp/protocol/j:ab	I
    //   217: aload_1
    //   218: getfield 1231	com/whatsapp/protocol/j:ab	I
    //   221: if_icmpge +83 -> 304
    //   224: aload_3
    //   225: ldc_w 3317
    //   228: invokevirtual 3315	android/database/sqlite/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;
    //   231: astore 4
    //   233: aload_0
    //   234: getfield 301	com/whatsapp/data/ad:T	Lcom/whatsapp/data/c;
    //   237: aload_1
    //   238: aload 4
    //   240: invokevirtual 3319	com/whatsapp/data/c:b	(Lcom/whatsapp/protocol/j;Landroid/database/sqlite/SQLiteStatement;)V
    //   243: aload 4
    //   245: astore_1
    //   246: goto -71 -> 175
    //   249: astore 4
    //   251: aload_3
    //   252: astore_1
    //   253: aload 4
    //   255: astore_3
    //   256: new 162	java/lang/StringBuilder
    //   259: dup
    //   260: ldc_w 3321
    //   263: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   266: aload_3
    //   267: invokevirtual 583	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   270: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokestatic 505	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   276: aload_1
    //   277: ifnull -83 -> 194
    //   280: aload_1
    //   281: invokevirtual 1163	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   284: ifeq -90 -> 194
    //   287: aload_1
    //   288: invokevirtual 1166	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   291: goto -97 -> 194
    //   294: astore_1
    //   295: aload_0
    //   296: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   299: invokevirtual 460	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   302: aload_1
    //   303: athrow
    //   304: new 162	java/lang/StringBuilder
    //   307: dup
    //   308: ldc_w 3323
    //   311: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   314: aload 4
    //   316: getfield 1231	com/whatsapp/protocol/j:ab	I
    //   319: invokevirtual 1120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   322: ldc_w 3325
    //   325: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: aload_1
    //   329: getfield 1231	com/whatsapp/protocol/j:ab	I
    //   332: invokevirtual 1120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   335: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokestatic 474	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   341: aload 6
    //   343: astore_1
    //   344: goto -169 -> 175
    //   347: astore_1
    //   348: aload_3
    //   349: ifnull +14 -> 363
    //   352: aload_3
    //   353: invokevirtual 1163	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   356: ifeq +7 -> 363
    //   359: aload_3
    //   360: invokevirtual 1166	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   363: aload_1
    //   364: athrow
    //   365: astore_1
    //   366: aconst_null
    //   367: astore_3
    //   368: goto -20 -> 348
    //   371: astore 4
    //   373: aload_1
    //   374: astore_3
    //   375: aload 4
    //   377: astore_1
    //   378: goto -30 -> 348
    //   381: astore_3
    //   382: aload 5
    //   384: astore_1
    //   385: goto -129 -> 256
    //   388: aconst_null
    //   389: astore_3
    //   390: goto -271 -> 119
    //   393: aconst_null
    //   394: astore 4
    //   396: goto -267 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	399	0	this	ad
    //   0	399	1	paramj	j
    //   1	73	2	i1	int
    //   12	363	3	localObject1	Object
    //   381	1	3	localIOException1	IOException
    //   389	1	3	localObject2	Object
    //   40	204	4	localObject3	Object
    //   249	66	4	localIOException2	IOException
    //   371	5	4	localObject4	Object
    //   394	1	4	localObject5	Object
    //   3	380	5	localObject6	Object
    //   6	336	6	localObject7	Object
    //   46	23	7	str	String
    // Exception table:
    //   from	to	target	type
    //   95	119	202	finally
    //   144	148	249	java/io/IOException
    //   153	172	249	java/io/IOException
    //   175	179	249	java/io/IOException
    //   212	243	249	java/io/IOException
    //   304	341	249	java/io/IOException
    //   183	194	294	finally
    //   280	291	294	finally
    //   352	363	294	finally
    //   363	365	294	finally
    //   144	148	347	finally
    //   153	172	347	finally
    //   175	179	347	finally
    //   212	243	347	finally
    //   304	341	347	finally
    //   136	144	365	finally
    //   256	276	371	finally
    //   136	144	381	java/io/IOException
  }
  
  /* Error */
  public final boolean d()
  {
    // Byte code:
    //   0: ldc_w 3327
    //   3: invokestatic 474	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   6: aload_0
    //   7: getfield 365	com/whatsapp/data/ad:M	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   10: invokevirtual 377	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   13: invokevirtual 2249	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   16: aload_0
    //   17: monitorenter
    //   18: aload_0
    //   19: getfield 357	com/whatsapp/data/ad:e	Ljava/io/File;
    //   22: astore_1
    //   23: aload_0
    //   24: getfield 329	com/whatsapp/data/ad:z	Lcom/whatsapp/data/ch;
    //   27: getfield 2033	com/whatsapp/data/ch:d	Z
    //   30: ifne +169 -> 199
    //   33: new 1287	java/io/File
    //   36: dup
    //   37: aload_1
    //   38: invokevirtual 3330	java/io/File:getParent	()Ljava/lang/String;
    //   41: new 162	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 1305	java/lang/StringBuilder:<init>	()V
    //   48: aload_1
    //   49: invokevirtual 1308	java/io/File:getName	()Ljava/lang/String;
    //   52: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc_w 3332
    //   58: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokespecial 3334	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: astore_2
    //   68: aload_2
    //   69: invokevirtual 1658	java/io/File:exists	()Z
    //   72: ifeq +21 -> 93
    //   75: aload_0
    //   76: getfield 295	com/whatsapp/data/ad:R	Lcom/whatsapp/and;
    //   79: getfield 3337	com/whatsapp/and:b	Landroid/app/ActivityManager;
    //   82: astore_3
    //   83: aload_3
    //   84: ifnonnull +135 -> 219
    //   87: ldc_w 3339
    //   90: invokestatic 505	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   93: new 162	java/lang/StringBuilder
    //   96: dup
    //   97: ldc_w 3341
    //   100: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   103: aload_2
    //   104: invokevirtual 2860	java/io/File:delete	()Z
    //   107: invokevirtual 1763	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   110: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 474	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   116: new 1287	java/io/File
    //   119: dup
    //   120: aload_1
    //   121: invokevirtual 3330	java/io/File:getParent	()Ljava/lang/String;
    //   124: new 162	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 1305	java/lang/StringBuilder:<init>	()V
    //   131: aload_1
    //   132: invokevirtual 1308	java/io/File:getName	()Ljava/lang/String;
    //   135: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: ldc_w 3343
    //   141: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokespecial 3334	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   150: astore_1
    //   151: new 162	java/lang/StringBuilder
    //   154: dup
    //   155: ldc_w 3345
    //   158: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   161: aload_1
    //   162: invokevirtual 2860	java/io/File:delete	()Z
    //   165: invokevirtual 1763	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   168: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokestatic 474	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   174: aload_0
    //   175: getfield 361	com/whatsapp/data/ad:b	Lcom/whatsapp/data/n;
    //   178: invokevirtual 604	com/whatsapp/data/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   181: ifnull +18 -> 199
    //   184: aload_0
    //   185: getfield 319	com/whatsapp/data/ad:w	Lcom/whatsapp/data/cn;
    //   188: invokevirtual 1199	com/whatsapp/data/cn:b	()V
    //   191: aload_0
    //   192: getfield 329	com/whatsapp/data/ad:z	Lcom/whatsapp/data/ch;
    //   195: iconst_1
    //   196: putfield 2033	com/whatsapp/data/ch:d	Z
    //   199: aload_0
    //   200: getfield 365	com/whatsapp/data/ad:M	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   203: invokevirtual 377	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   206: invokevirtual 2291	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   209: aload_0
    //   210: monitorexit
    //   211: aload_0
    //   212: getfield 329	com/whatsapp/data/ad:z	Lcom/whatsapp/data/ch;
    //   215: getfield 2033	com/whatsapp/data/ch:d	Z
    //   218: ireturn
    //   219: aload_3
    //   220: invokevirtual 3350	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   223: invokestatic 3351	com/whatsapp/ane:a	(Ljava/util/List;)V
    //   226: goto -133 -> 93
    //   229: astore_1
    //   230: aload_0
    //   231: getfield 365	com/whatsapp/data/ad:M	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   234: invokevirtual 377	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   237: invokevirtual 2291	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   240: aload_1
    //   241: athrow
    //   242: astore_1
    //   243: aload_0
    //   244: monitorexit
    //   245: aload_1
    //   246: athrow
    //   247: astore_1
    //   248: new 162	java/lang/StringBuilder
    //   251: dup
    //   252: ldc_w 3353
    //   255: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   258: aload_1
    //   259: invokevirtual 583	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   262: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: invokestatic 509	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   268: aload_0
    //   269: invokevirtual 2375	com/whatsapp/data/ad:b	()V
    //   272: goto -73 -> 199
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	this	ad
    //   22	140	1	localFile1	File
    //   229	12	1	localObject1	Object
    //   242	4	1	localObject2	Object
    //   247	12	1	localSQLiteDatabaseCorruptException	SQLiteDatabaseCorruptException
    //   67	37	2	localFile2	File
    //   82	138	3	localActivityManager	android.app.ActivityManager
    // Exception table:
    //   from	to	target	type
    //   18	83	229	finally
    //   87	93	229	finally
    //   93	174	229	finally
    //   174	199	229	finally
    //   219	226	229	finally
    //   248	272	229	finally
    //   199	211	242	finally
    //   230	242	242	finally
    //   243	245	242	finally
    //   174	199	247	android/database/sqlite/SQLiteDatabaseCorruptException
  }
  
  final boolean d(j paramj, int paramInt)
  {
    boolean bool2 = false;
    Object localObject2 = null;
    Object localObject1 = null;
    this.i.lock();
    for (;;)
    {
      SQLiteDatabase localSQLiteDatabase;
      Object localObject3;
      try
      {
        localSQLiteDatabase = this.b.getWritableDatabase();
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        this.w.b();
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localSQLiteDatabase.beginTransaction();
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        int i2;
        String str;
        if (paramj.e.b)
        {
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          if (paramj.E)
          {
            localObject1 = localSQLiteDatabase;
            localObject2 = localSQLiteDatabase;
            if (j.b(paramj.e.a))
            {
              localObject1 = localSQLiteDatabase;
              localObject2 = localSQLiteDatabase;
              if (!j.c(paramj.e.a))
              {
                i1 = 1;
                break label1206;
                if ((i1 == 0) || (paramInt == 0)) {
                  continue;
                }
                localObject1 = localSQLiteDatabase;
                localObject2 = localSQLiteDatabase;
                localObject3 = paramj.f.split(",");
                localObject1 = localSQLiteDatabase;
                localObject2 = localSQLiteDatabase;
                int i3 = localObject3.length;
                i2 = 0;
                if (i2 >= i3) {
                  continue;
                }
                str = localObject3[i2];
                localObject1 = localSQLiteDatabase;
                localObject2 = localSQLiteDatabase;
              }
            }
          }
        }
        try
        {
          j localj = new j(paramj);
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localj.e = new j.b(str, true, paramj.e.c);
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          g(localj);
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          if (this.n.a.containsKey(str))
          {
            localObject1 = localSQLiteDatabase;
            localObject2 = localSQLiteDatabase;
            b(localSQLiteDatabase, localj);
          }
        }
        catch (SQLiteConstraintException localSQLiteConstraintException)
        {
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          Log.b("msgstore/updatemessageinbackground duplicate", localSQLiteConstraintException);
          continue;
        }
        i2 += 1;
        continue;
        i1 = 0;
      }
      catch (IOException paramj)
      {
        int i1;
        localObject2 = localObject1;
        Log.e(paramj);
        boolean bool1 = bool2;
        if (localObject1 == null) {
          continue;
        }
        bool1 = bool2;
        try
        {
          if (((SQLiteDatabase)localObject1).inTransaction())
          {
            ((SQLiteDatabase)localObject1).endTransaction();
            bool1 = bool2;
          }
        }
        finally
        {
          try
          {
            Object localObject4;
            this.K.a(paramj.e, paramj);
            bool2 = true;
            bool1 = bool2;
            if (localSQLiteDatabase == null) {
              continue;
            }
            bool1 = bool2;
            if (!localSQLiteDatabase.inTransaction()) {
              continue;
            }
            localSQLiteDatabase.endTransaction();
            bool1 = bool2;
            continue;
          }
          finally
          {
            long l1;
            localObject1 = localSQLiteDatabase;
            localObject2 = localSQLiteDatabase;
          }
          paramj = finally;
          this.i.unlock();
        }
        this.i.unlock();
        return bool1;
        if ((i1 == 0) || (paramInt != 0)) {
          continue;
        }
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localObject3 = this.w.i;
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localObject4 = this.T;
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        ((SQLiteStatement)localObject3).bindLong(1, paramj.d);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        ((SQLiteStatement)localObject3).bindLong(2, 2L);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        c.a(paramj, (SQLiteStatement)localObject3, 4, 3);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        ((SQLiteStatement)localObject3).bindLong(5, paramj.n);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        n.a(6, paramj.p, (SQLiteStatement)localObject3);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        n.a(7, paramj.r, (SQLiteStatement)localObject3);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        ((SQLiteStatement)localObject3).bindLong(8, paramj.s);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        ((SQLiteStatement)localObject3).bindLong(9, paramj.t);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        n.a(10, paramj.y, (SQLiteStatement)localObject3);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        n.a(11, paramj.z, (SQLiteStatement)localObject3);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        n.a(12, paramj.u, (SQLiteStatement)localObject3);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        if (paramj.s != 9) {
          continue;
        }
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        l1 = paramj.x;
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        ((SQLiteStatement)localObject3).bindLong(13, l1);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        ((SQLiteStatement)localObject3).bindLong(14, paramj.o);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        ((SQLiteStatement)localObject3).bindDouble(15, paramj.B);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        ((SQLiteStatement)localObject3).bindDouble(16, paramj.C);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        n.a(17, yr.a(paramj.P), (SQLiteStatement)localObject3);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        n.a(18, ((c)localObject4).a.a(paramj.N), (SQLiteStatement)localObject3);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        n.a(19, paramj.v, (SQLiteStatement)localObject3);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        ((SQLiteStatement)localObject3).bindString(20, paramj.e.c);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localObject4 = paramj.f();
        if (localObject4 == null) {
          continue;
        }
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        if (!((com.whatsapp.protocol.l)localObject4).e()) {
          continue;
        }
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        if (((com.whatsapp.protocol.l)localObject4).b() == null) {
          break label1172;
        }
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        this.ab.a(((com.whatsapp.protocol.l)localObject4).b(), paramj.e);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        ((com.whatsapp.protocol.l)localObject4).f();
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localObject4 = paramj.g();
        if (localObject4 == null) {
          continue;
        }
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        if (!((k)localObject4).d()) {
          continue;
        }
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        this.Z.a(((k)localObject4).a(), paramj.e);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        ((k)localObject4).e();
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        ((SQLiteStatement)localObject3).execute();
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localSQLiteDatabase.setTransactionSuccessful();
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localObject3 = this.K;
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        l1 = paramj.w;
        continue;
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localObject3 = this.w.h;
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        this.T.b(paramj, (SQLiteStatement)localObject3);
        continue;
      }
      finally
      {
        if ((localObject2 == null) || (!((SQLiteDatabase)localObject2).inTransaction())) {
          continue;
        }
        ((SQLiteDatabase)localObject2).endTransaction();
      }
      paramInt = 0;
      continue;
      label1172:
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      this.ab.a(paramj);
      continue;
      label1206:
      if ((paramInt == 4) || (paramInt == 1)) {
        paramInt = 1;
      }
    }
  }
  
  public final boolean d(String paramString, long paramLong)
  {
    d locald = (d)this.n.a.get(paramString);
    if (locald == null) {
      return false;
    }
    if (locald.m == 1L) {
      locald.m = g(paramString);
    }
    Log.d("msgstore/hasearliermsgs/jid " + paramString + " firstref=" + locald.m + " startref=" + paramLong);
    return (locald.m != 1L) && (locald.m < paramLong);
  }
  
  public final long e(String paramString)
  {
    long l1 = 0L;
    this.i.lock();
    for (;;)
    {
      try
      {
        this.b.e();
        Cursor localCursor = this.b.getReadableDatabase().rawQuery("SELECT count(*) FROM messages WHERE key_remote_jid=?  AND starred=1", new String[] { paramString });
        if (localCursor != null) {
          try
          {
            if (localCursor.moveToNext())
            {
              l1 = localCursor.getLong(0);
              localCursor.close();
              return l1;
            }
            Log.i("msgstore/countStarredMessages/db no message for " + paramString);
            continue;
            paramString = finally;
          }
          finally
          {
            localCursor.close();
          }
        }
        Log.i("msgstore/countStarredMessages/db no cursor for " + paramString);
      }
      finally
      {
        this.i.unlock();
      }
    }
  }
  
  public final void e()
  {
    try
    {
      this.N = false;
      this.w.a = false;
      this.z.d = false;
      this.n.a.clear();
      if (this.x.c != null) {
        this.x.c.clear();
      }
      return;
    }
    finally {}
  }
  
  public final void e(j paramj, int paramInt)
  {
    Message.obtain(this.d, 2, paramInt, 0, paramj).sendToTarget();
  }
  
  public final Collection<String> f()
  {
    HashSet localHashSet = new HashSet();
    long l1 = System.currentTimeMillis();
    Cursor localCursor = this.b.getReadableDatabase().rawQuery(ag, new String[] { "14", String.valueOf(l1 - 86400000L) });
    if (localCursor != null) {
      try
      {
        if (localCursor.moveToNext()) {
          localHashSet.add(localCursor.getString(0));
        }
        return localCollection;
      }
      finally
      {
        localCursor.close();
      }
    }
  }
  
  public final HashMap<String, String> f(String paramString)
  {
    int i5 = 0;
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (;;)
    {
      int i2;
      synchronized (this.b)
      {
        try
        {
          Object localObject = this.b.getWritableDatabase();
          Cursor localCursor = ((SQLiteDatabase)localObject).rawQuery("SELECT media_wa_type, count(*) FROM messages WHERE key_remote_jid=? AND media_wa_type IN (13, 2, 1, 3, 9) GROUP BY media_wa_type", new String[] { paramString });
          paramString = ((SQLiteDatabase)localObject).rawQuery("SELECT COUNT(*) FROM messages_links WHERE key_remote_jid=?", new String[] { paramString });
          localObject = new HashMap();
          if (localCursor == null) {
            break label228;
          }
          i2 = 0;
          int i1 = 0;
          i3 = i2;
          i4 = i1;
          if (localCursor.moveToNext())
          {
            i3 = localCursor.getInt(0);
            i4 = localCursor.getInt(1);
            if (i3 != 9) {
              i1 += i4;
            }
          }
          else
          {
            ((HashMap)localObject).put("media", String.valueOf(i4));
            ((HashMap)localObject).put("document", String.valueOf(i3));
            i1 = i5;
            if (paramString != null)
            {
              i1 = i5;
              if (paramString.moveToFirst()) {
                i1 = paramString.getInt(0);
              }
            }
            ((HashMap)localObject).put("url", String.valueOf(i1));
            return (HashMap<String, String>)localObject;
          }
        }
        catch (Exception paramString)
        {
          return null;
        }
      }
      i2 += i4;
      continue;
      label228:
      int i3 = 0;
      int i4 = 0;
    }
  }
  
  public final void f(j paramj, int paramInt)
  {
    this.u.c(paramj, paramInt);
  }
  
  public final long g(String paramString)
  {
    d locald = (d)this.n.a.get(paramString);
    if (locald == null) {
      return 1L;
    }
    if (locald.m != 1L) {
      return locald.m;
    }
    this.i.lock();
    for (;;)
    {
      try
      {
        Cursor localCursor = this.b.getReadableDatabase().rawQuery("SELECT _id FROM messages WHERE key_remote_jid=? AND media_wa_type!=8 ORDER BY _id ASC LIMIT 1", new String[] { paramString });
        if (localCursor != null) {
          try
          {
            if (localCursor.moveToFirst())
            {
              locald.m = localCursor.getLong(0);
              localCursor.close();
              return locald.m;
            }
            Log.w("msgstore/getfirstref can't get value for " + paramString);
            continue;
            paramString = finally;
          }
          finally
          {
            localCursor.close();
          }
        }
        Log.w("msgstore/getfirstref/cursor is null");
      }
      finally
      {
        this.i.unlock();
      }
    }
  }
  
  public final ArrayList<j> g()
  {
    long l1 = this.j.b();
    if (!this.L.get()) {}
    for (;;)
    {
      Object localObject2;
      bd localbd;
      Object localObject1;
      int i1;
      synchronized (this.L)
      {
        if (this.L.get()) {
          return c(l1);
        }
        localObject2 = new ArrayList();
        localbd = new bd();
        localbd.a("msgstore/unsendmessages");
        long l2 = d(this.j.b() - 86400000L);
        localObject1 = this.b.getReadableDatabase().rawQuery(ah, new String[] { "4", String.valueOf(l2) });
        if (localObject1 != null) {
          i1 = ((Cursor)localObject1).getColumnIndex("key_remote_jid");
        }
      }
      try
      {
        for (;;)
        {
          if (!((Cursor)localObject1).moveToNext()) {
            break label444;
          }
          String str = ((Cursor)localObject1).getString(i1);
          if (str != null) {
            break;
          }
          Log.w("msgstore/unsent/jid is null!");
        }
      }
      catch (IllegalStateException localIllegalStateException)
      {
        for (;;)
        {
          Log.i("msgstore/unsent/IllegalStateException " + localIllegalStateException);
          ((Cursor)localObject1).close();
          Log.i("msgstore/unsent " + ((ArrayList)localObject2).size() + " | time spent:" + localbd.b());
          localObject1 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (j)((Iterator)localObject1).next();
            this.g.put(((j)localObject2).e, localObject2);
          }
          localCursor = finally;
          throw localCursor;
          j localj = this.t.a(localCursor, localIllegalStateException);
          if ((localj.s != 8) && (localj.s != 10) && (localj.s != 7) && ((localj.d != 7) || (!localj.e.a.contains("-"))))
          {
            Log.i("msgstore/unsent/add " + localj.e.c + " " + localj.s);
            ((ArrayList)localObject2).add(localj);
          }
        }
      }
      catch (SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException)
      {
        for (;;)
        {
          a(new AssertionError(localSQLiteDatabaseCorruptException));
          localCursor.close();
          continue;
          localCursor.close();
        }
      }
      catch (SQLiteFullException localSQLiteFullException)
      {
        label444:
        a.a.a.a.d.g(this.J);
        throw localSQLiteFullException;
      }
      finally
      {
        localCursor.close();
      }
      if (!this.L.compareAndSet(false, true)) {
        Log.e("unsent messages cache initialization failed to change the related flag");
      }
    }
  }
  
  /* Error */
  public final m h(String paramString)
  {
    // Byte code:
    //   0: new 162	java/lang/StringBuilder
    //   3: dup
    //   4: ldc_w 3447
    //   7: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   10: aload_1
    //   11: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   17: invokestatic 474	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   20: new 44	com/whatsapp/data/ad$m
    //   23: dup
    //   24: invokespecial 3448	com/whatsapp/data/ad$m:<init>	()V
    //   27: astore_2
    //   28: aload_1
    //   29: ifnull +13 -> 42
    //   32: ldc_w 1031
    //   35: aload_1
    //   36: invokevirtual 869	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   39: ifeq +25 -> 64
    //   42: new 162	java/lang/StringBuilder
    //   45: dup
    //   46: ldc_w 3450
    //   49: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   52: aload_1
    //   53: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 509	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   62: aload_2
    //   63: areturn
    //   64: aload_0
    //   65: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   68: invokevirtual 419	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   71: aload_0
    //   72: getfield 361	com/whatsapp/data/ad:b	Lcom/whatsapp/data/n;
    //   75: invokevirtual 425	com/whatsapp/data/n:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   78: ldc_w 3452
    //   81: iconst_1
    //   82: anewarray 429	java/lang/String
    //   85: dup
    //   86: iconst_0
    //   87: aload_1
    //   88: aastore
    //   89: invokevirtual 435	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   92: astore_3
    //   93: aload_3
    //   94: ifnull +55 -> 149
    //   97: aload_3
    //   98: invokeinterface 441 1 0
    //   103: ifeq +46 -> 149
    //   106: aload_3
    //   107: iconst_0
    //   108: invokeinterface 2073 2 0
    //   113: astore 4
    //   115: aconst_null
    //   116: astore_1
    //   117: aload_3
    //   118: iconst_1
    //   119: invokeinterface 3455 2 0
    //   124: ifne +14 -> 138
    //   127: aload_3
    //   128: iconst_1
    //   129: invokeinterface 1393 2 0
    //   134: invokestatic 588	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   137: astore_1
    //   138: aload_2
    //   139: aload 4
    //   141: putfield 3456	com/whatsapp/data/ad$m:a	Ljava/lang/String;
    //   144: aload_2
    //   145: aload_1
    //   146: putfield 3457	com/whatsapp/data/ad$m:b	Ljava/lang/Long;
    //   149: aload_3
    //   150: ifnull +9 -> 159
    //   153: aload_3
    //   154: invokeinterface 457 1 0
    //   159: aload_0
    //   160: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   163: invokevirtual 460	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   166: aload_2
    //   167: areturn
    //   168: astore_1
    //   169: new 162	java/lang/StringBuilder
    //   172: dup
    //   173: ldc_w 3459
    //   176: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   179: aload_1
    //   180: invokevirtual 583	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 509	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   189: aload_3
    //   190: ifnull -31 -> 159
    //   193: aload_3
    //   194: invokeinterface 457 1 0
    //   199: goto -40 -> 159
    //   202: astore_1
    //   203: aload_0
    //   204: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   207: invokevirtual 460	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   210: aload_1
    //   211: athrow
    //   212: astore_1
    //   213: aload_3
    //   214: ifnull +9 -> 223
    //   217: aload_3
    //   218: invokeinterface 457 1 0
    //   223: aload_1
    //   224: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	this	ad
    //   0	225	1	paramString	String
    //   27	140	2	localm	m
    //   92	126	3	localCursor	Cursor
    //   113	27	4	str	String
    // Exception table:
    //   from	to	target	type
    //   97	115	168	android/database/sqlite/SQLiteDiskIOException
    //   117	138	168	android/database/sqlite/SQLiteDiskIOException
    //   138	149	168	android/database/sqlite/SQLiteDiskIOException
    //   71	93	202	finally
    //   153	159	202	finally
    //   193	199	202	finally
    //   217	223	202	finally
    //   223	225	202	finally
    //   97	115	212	finally
    //   117	138	212	finally
    //   138	149	212	finally
    //   169	189	212	finally
  }
  
  public final ArrayList<j> h()
  {
    bd localbd = new bd();
    localbd.a("msgstore/unsendstatuses");
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.b.getReadableDatabase().rawQuery("SELECT key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, raw_data, recipient_count, participant_hash, starred, quoted_row_id, mentioned_jids, multicast_id, edit_version, receipt_server_timestamp, media_enc_hash, _id, key_remote_jid FROM messages WHERE key_from_me=0 AND status IN(9,11) ORDER BY _id DESC LIMIT 4096", null);
    int i1;
    if (localCursor != null) {
      i1 = localCursor.getColumnIndex("key_remote_jid");
    }
    try
    {
      for (;;)
      {
        if (!localCursor.moveToNext()) {
          break label242;
        }
        String str = localCursor.getString(i1);
        if (str != null) {
          break;
        }
        Log.w("msgstore/unsentmessagestatuses/jid is null!");
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        Log.i("msgstore/unsentmessagestatuses/IllegalStateException " + localIllegalStateException);
        localCursor.close();
        Log.i("msgstore/unsentmessagestatuses " + localArrayList.size() + " | time spent:" + localbd.b());
        return localArrayList;
        j localj = this.t.a(localCursor, localIllegalStateException);
        Log.i("msgstore/unsentmessagestatuses/add " + localj.e.c + " " + localj.s);
        localArrayList.add(localj);
      }
    }
    catch (SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException)
    {
      for (;;)
      {
        a(new AssertionError(localSQLiteDatabaseCorruptException));
        localCursor.close();
        continue;
        localCursor.close();
      }
    }
    catch (SQLiteFullException localSQLiteFullException)
    {
      label242:
      a.a.a.a.d.g(this.J);
      throw localSQLiteFullException;
    }
    finally
    {
      localCursor.close();
    }
  }
  
  public final String i(String paramString)
  {
    paramString = this.b.getReadableDatabase().rawQuery("SELECT remote_resource FROM messages WHERE key_remote_jid=? AND media_wa_type=0 AND key_from_me=1 AND status=6 AND media_size=12 AND media_duration=1 ORDER BY _id DESC LIMIT 1", new String[] { paramString });
    if (paramString != null) {}
    try
    {
      if (paramString.moveToNext())
      {
        String str = paramString.getString(0);
        return str;
      }
    }
    catch (SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException)
    {
      for (;;)
      {
        a(new AssertionError(localSQLiteDatabaseCorruptException));
        paramString.close();
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        Log.i("msgstore/getlastmessagesfornotification/IllegalStateException " + localIllegalStateException);
        paramString.close();
      }
    }
    finally
    {
      paramString.close();
    }
    return null;
  }
  
  public final ArrayList<j> i()
  {
    bd localbd = new bd();
    localbd.a("msgstore/unsendreadreceipts");
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.b.getReadableDatabase().rawQuery(aj, null);
    int i1;
    if (localCursor != null) {
      i1 = localCursor.getColumnIndex("messages_key_remote_jid");
    }
    try
    {
      for (;;)
      {
        if (!localCursor.moveToNext()) {
          break label225;
        }
        String str = localCursor.getString(i1);
        if (str != null) {
          break;
        }
        Log.w("msgstore/unsendreadreceipts/jid is null!");
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        Log.i("msgstore/unsendreadreceipts/IllegalStateException " + localIllegalStateException);
        localCursor.close();
        Log.i("msgstore/unsendreadreceipts " + localArrayList.size() + " | time spent:" + localbd.b());
        return localArrayList;
        if (this.P.a(localIllegalStateException))
        {
          j localj = this.t.a(localCursor, localIllegalStateException);
          if (localj.n > 1415214000000L) {
            localArrayList.add(localj);
          }
        }
      }
    }
    catch (SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException)
    {
      for (;;)
      {
        a(new AssertionError(localSQLiteDatabaseCorruptException));
        localCursor.close();
        continue;
        localCursor.close();
      }
    }
    catch (SQLiteFullException localSQLiteFullException)
    {
      label225:
      a.a.a.a.d.g(this.J);
      throw localSQLiteFullException;
    }
    finally
    {
      localCursor.close();
    }
  }
  
  /* Error */
  public final void j()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc_w 3485
    //   5: invokestatic 474	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   8: new 411	com/whatsapp/util/bd
    //   11: dup
    //   12: ldc_w 3485
    //   15: invokespecial 414	com/whatsapp/util/bd:<init>	(Ljava/lang/String;)V
    //   18: astore_1
    //   19: aload_0
    //   20: getfield 389	com/whatsapp/data/ad:g	Ljava/util/Map;
    //   23: invokeinterface 3406 1 0
    //   28: aload_0
    //   29: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   32: invokevirtual 419	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   35: aload_0
    //   36: getfield 361	com/whatsapp/data/ad:b	Lcom/whatsapp/data/n;
    //   39: invokevirtual 604	com/whatsapp/data/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   42: astore_2
    //   43: aload_2
    //   44: invokevirtual 1143	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   47: aload_2
    //   48: ldc_w 3487
    //   51: invokevirtual 3489	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   54: aload_2
    //   55: ldc_w 3491
    //   58: invokevirtual 3489	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   61: aload_2
    //   62: ldc_w 3493
    //   65: invokevirtual 3489	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   68: aload_2
    //   69: ldc_w 3495
    //   72: aconst_null
    //   73: aconst_null
    //   74: invokevirtual 1102	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   77: pop
    //   78: aload_2
    //   79: ldc_w 3497
    //   82: aconst_null
    //   83: aconst_null
    //   84: invokevirtual 1102	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   87: pop
    //   88: aload_2
    //   89: ldc_w 3499
    //   92: aconst_null
    //   93: aconst_null
    //   94: invokevirtual 1102	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   97: pop
    //   98: aload_2
    //   99: ldc_w 3501
    //   102: aconst_null
    //   103: aconst_null
    //   104: invokevirtual 1102	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   107: pop
    //   108: aload_2
    //   109: ldc_w 1917
    //   112: aconst_null
    //   113: aconst_null
    //   114: invokevirtual 1102	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   117: pop
    //   118: aload_2
    //   119: ldc_w 3503
    //   122: aconst_null
    //   123: aconst_null
    //   124: invokevirtual 1102	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   127: pop
    //   128: aload_2
    //   129: ldc_w 3505
    //   132: aconst_null
    //   133: aconst_null
    //   134: invokevirtual 1102	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   137: pop
    //   138: aload_2
    //   139: ldc_w 1960
    //   142: aconst_null
    //   143: aconst_null
    //   144: invokevirtual 1102	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   147: pop
    //   148: aload_2
    //   149: ldc_w 3507
    //   152: aconst_null
    //   153: aconst_null
    //   154: invokevirtual 1102	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   157: pop
    //   158: aload_2
    //   159: ldc_w 1513
    //   162: aconst_null
    //   163: aconst_null
    //   164: invokevirtual 1102	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   167: pop
    //   168: aload_2
    //   169: ldc_w 1264
    //   172: aconst_null
    //   173: aconst_null
    //   174: invokevirtual 1102	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   177: pop
    //   178: aload_0
    //   179: getfield 339	com/whatsapp/data/ad:C	Lcom/whatsapp/data/o;
    //   182: invokevirtual 3508	com/whatsapp/data/o:b	()V
    //   185: aload_0
    //   186: getfield 281	com/whatsapp/data/ad:n	Lcom/whatsapp/data/d;
    //   189: getfield 1406	com/whatsapp/data/d:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   192: invokevirtual 3509	java/util/concurrent/ConcurrentHashMap:entrySet	()Ljava/util/Set;
    //   195: invokeinterface 1028 1 0
    //   200: astore_3
    //   201: aload_3
    //   202: invokeinterface 915 1 0
    //   207: ifeq +99 -> 306
    //   210: aload_3
    //   211: invokeinterface 918 1 0
    //   216: checkcast 1705	java/util/Map$Entry
    //   219: astore 5
    //   221: aload 5
    //   223: invokeinterface 3512 1 0
    //   228: checkcast 429	java/lang/String
    //   231: astore 4
    //   233: aload 5
    //   235: invokeinterface 1708 1 0
    //   240: checkcast 17	com/whatsapp/data/ad$d
    //   243: astore 5
    //   245: aload 5
    //   247: invokevirtual 3513	com/whatsapp/data/ad$d:a	()V
    //   250: aload 4
    //   252: invokestatic 1361	com/whatsapp/qz:e	(Ljava/lang/String;)Z
    //   255: ifeq -54 -> 201
    //   258: aload 5
    //   260: getfield 1485	com/whatsapp/data/ad$d:j	I
    //   263: iconst_1
    //   264: if_icmpne -63 -> 201
    //   267: aload_0
    //   268: aload 4
    //   270: iconst_0
    //   271: aconst_null
    //   272: invokevirtual 2626	com/whatsapp/data/ad:a	(Ljava/lang/String;ILjava/lang/Long;)V
    //   275: goto -74 -> 201
    //   278: astore_1
    //   279: aload_2
    //   280: ifnull +14 -> 294
    //   283: aload_2
    //   284: invokevirtual 1163	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   287: ifeq +7 -> 294
    //   290: aload_2
    //   291: invokevirtual 1166	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   294: aload_1
    //   295: athrow
    //   296: astore_1
    //   297: aload_0
    //   298: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   301: invokevirtual 460	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   304: aload_1
    //   305: athrow
    //   306: aload_2
    //   307: invokevirtual 1160	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   310: aload_2
    //   311: ifnull +14 -> 325
    //   314: aload_2
    //   315: invokevirtual 1163	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   318: ifeq +7 -> 325
    //   321: aload_2
    //   322: invokevirtual 1166	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   325: aload_0
    //   326: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   329: invokevirtual 460	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   332: new 162	java/lang/StringBuilder
    //   335: dup
    //   336: ldc_w 3515
    //   339: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   342: aload_1
    //   343: invokevirtual 467	com/whatsapp/util/bd:b	()J
    //   346: invokevirtual 470	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   349: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: invokestatic 474	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   355: aload_0
    //   356: getfield 283	com/whatsapp/data/ad:m	Lcom/whatsapp/oz;
    //   359: invokevirtual 3517	com/whatsapp/oz:b	()Ljava/io/File;
    //   362: invokestatic 3520	com/whatsapp/util/bk:a	(Ljava/io/File;)Z
    //   365: pop
    //   366: aload_0
    //   367: getfield 293	com/whatsapp/data/ad:p	Lcom/whatsapp/data/s;
    //   370: getfield 2541	com/whatsapp/data/s:e	Landroid/os/Handler;
    //   373: bipush 9
    //   375: invokestatic 3523	android/os/Message:obtain	(Landroid/os/Handler;I)Landroid/os/Message;
    //   378: invokevirtual 2577	android/os/Message:sendToTarget	()V
    //   381: return
    //   382: astore_1
    //   383: aload_3
    //   384: astore_2
    //   385: goto -106 -> 279
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	388	0	this	ad
    //   18	1	1	localbd	bd
    //   278	17	1	localObject1	Object
    //   296	47	1	localObject2	Object
    //   382	1	1	localObject3	Object
    //   42	343	2	localObject4	Object
    //   1	383	3	localIterator	Iterator
    //   231	38	4	str	String
    //   219	40	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   43	201	278	finally
    //   201	275	278	finally
    //   306	310	278	finally
    //   283	294	296	finally
    //   294	296	296	finally
    //   314	325	296	finally
    //   35	43	382	finally
  }
  
  /* Error */
  public final boolean j(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 7
    //   9: new 411	com/whatsapp/util/bd
    //   12: dup
    //   13: ldc_w 3525
    //   16: invokespecial 414	com/whatsapp/util/bd:<init>	(Ljava/lang/String;)V
    //   19: astore 9
    //   21: aload_0
    //   22: aload_1
    //   23: invokespecial 3527	com/whatsapp/data/ad:A	(Ljava/lang/String;)V
    //   26: iconst_1
    //   27: anewarray 4	java/lang/Object
    //   30: astore 10
    //   32: aload 10
    //   34: iconst_0
    //   35: aload_1
    //   36: aastore
    //   37: aload_0
    //   38: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   41: invokevirtual 419	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   44: aload_0
    //   45: getfield 327	com/whatsapp/data/ad:y	Lcom/whatsapp/data/aa;
    //   48: aload_1
    //   49: invokevirtual 3528	com/whatsapp/data/aa:a	(Ljava/lang/String;)V
    //   52: aload_0
    //   53: getfield 361	com/whatsapp/data/ad:b	Lcom/whatsapp/data/n;
    //   56: invokevirtual 604	com/whatsapp/data/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   59: astore 5
    //   61: aload 5
    //   63: astore 7
    //   65: aload 5
    //   67: astore 6
    //   69: aload 5
    //   71: astore 8
    //   73: aload 5
    //   75: invokevirtual 1143	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   78: aload 5
    //   80: astore 7
    //   82: aload 5
    //   84: astore 6
    //   86: aload 5
    //   88: astore 8
    //   90: aload 5
    //   92: ldc_w 3134
    //   95: aload 10
    //   97: invokevirtual 3138	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   100: aload 5
    //   102: astore 7
    //   104: aload 5
    //   106: astore 6
    //   108: aload 5
    //   110: astore 8
    //   112: aload 5
    //   114: ldc_w 3140
    //   117: aload 10
    //   119: invokevirtual 3138	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   122: aload 5
    //   124: astore 7
    //   126: aload 5
    //   128: astore 6
    //   130: aload 5
    //   132: astore 8
    //   134: new 1033	android/content/ContentValues
    //   137: dup
    //   138: iconst_2
    //   139: invokespecial 1036	android/content/ContentValues:<init>	(I)V
    //   142: astore 10
    //   144: aload 5
    //   146: astore 7
    //   148: aload 5
    //   150: astore 6
    //   152: aload 5
    //   154: astore 8
    //   156: aload 10
    //   158: ldc_w 1250
    //   161: iconst_1
    //   162: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   165: invokevirtual 1090	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   168: aload 5
    //   170: astore 7
    //   172: aload 5
    //   174: astore 6
    //   176: aload 5
    //   178: astore 8
    //   180: aload 10
    //   182: ldc_w 1252
    //   185: iconst_1
    //   186: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   189: invokevirtual 1090	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   192: aload 5
    //   194: astore 7
    //   196: aload 5
    //   198: astore 6
    //   200: aload 5
    //   202: astore 8
    //   204: aload 10
    //   206: ldc_w 1416
    //   209: iconst_1
    //   210: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   213: invokevirtual 1090	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   216: aload 5
    //   218: astore 7
    //   220: aload 5
    //   222: astore 6
    //   224: aload 5
    //   226: astore 8
    //   228: aload 10
    //   230: ldc_w 2066
    //   233: iconst_0
    //   234: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   237: invokevirtual 1090	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   240: aload 5
    //   242: astore 7
    //   244: aload 5
    //   246: astore 6
    //   248: aload 5
    //   250: astore 8
    //   252: aload 10
    //   254: ldc_w 2068
    //   257: iconst_0
    //   258: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   261: invokevirtual 1090	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   264: aload 5
    //   266: astore 7
    //   268: aload 5
    //   270: astore 6
    //   272: aload 5
    //   274: astore 8
    //   276: aload 10
    //   278: ldc_w 2070
    //   281: iconst_0
    //   282: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   285: invokevirtual 1090	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   288: aload 5
    //   290: astore 7
    //   292: aload 5
    //   294: astore 6
    //   296: aload 5
    //   298: astore 8
    //   300: invokestatic 2150	com/whatsapp/data/ad:k	()I
    //   303: istore_2
    //   304: aload 5
    //   306: astore 7
    //   308: aload 5
    //   310: astore 6
    //   312: aload 5
    //   314: astore 8
    //   316: aload 10
    //   318: ldc_w 2152
    //   321: iload_2
    //   322: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   325: invokevirtual 1090	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   328: aload 5
    //   330: astore 7
    //   332: aload 5
    //   334: astore 6
    //   336: aload 5
    //   338: astore 8
    //   340: aload 5
    //   342: ldc_w 1149
    //   345: aload 10
    //   347: ldc_w 1151
    //   350: iconst_1
    //   351: anewarray 429	java/lang/String
    //   354: dup
    //   355: iconst_0
    //   356: aload_1
    //   357: aastore
    //   358: invokevirtual 1062	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   361: istore_3
    //   362: aload 5
    //   364: astore 7
    //   366: aload 5
    //   368: astore 6
    //   370: aload 5
    //   372: astore 8
    //   374: new 162	java/lang/StringBuilder
    //   377: dup
    //   378: ldc_w 3530
    //   381: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   384: iload_3
    //   385: invokevirtual 1120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   388: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: invokestatic 474	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   394: aload 5
    //   396: astore 7
    //   398: aload 5
    //   400: astore 6
    //   402: aload 5
    //   404: astore 8
    //   406: aload_0
    //   407: getfield 339	com/whatsapp/data/ad:C	Lcom/whatsapp/data/o;
    //   410: aload_1
    //   411: invokevirtual 3531	com/whatsapp/data/o:a	(Ljava/lang/String;)V
    //   414: aload 5
    //   416: astore 7
    //   418: aload 5
    //   420: astore 6
    //   422: aload 5
    //   424: astore 8
    //   426: aload_0
    //   427: getfield 281	com/whatsapp/data/ad:n	Lcom/whatsapp/data/d;
    //   430: getfield 1406	com/whatsapp/data/d:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   433: aload_1
    //   434: invokevirtual 1409	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   437: checkcast 17	com/whatsapp/data/ad$d
    //   440: astore 10
    //   442: aload 10
    //   444: ifnull +78 -> 522
    //   447: aload 5
    //   449: astore 7
    //   451: aload 5
    //   453: astore 6
    //   455: aload 5
    //   457: astore 8
    //   459: aload 10
    //   461: invokevirtual 3513	com/whatsapp/data/ad$d:a	()V
    //   464: aload 5
    //   466: astore 7
    //   468: aload 5
    //   470: astore 6
    //   472: aload 5
    //   474: astore 8
    //   476: aload 10
    //   478: iload_2
    //   479: putfield 2086	com/whatsapp/data/ad$d:g	I
    //   482: aload 5
    //   484: astore 7
    //   486: aload 5
    //   488: astore 6
    //   490: aload 5
    //   492: astore 8
    //   494: aload 10
    //   496: getfield 1485	com/whatsapp/data/ad$d:j	I
    //   499: iconst_1
    //   500: if_icmpne +22 -> 522
    //   503: aload 5
    //   505: astore 7
    //   507: aload 5
    //   509: astore 6
    //   511: aload 5
    //   513: astore 8
    //   515: aload_0
    //   516: aload_1
    //   517: iconst_0
    //   518: aconst_null
    //   519: invokevirtual 2626	com/whatsapp/data/ad:a	(Ljava/lang/String;ILjava/lang/Long;)V
    //   522: aload 5
    //   524: astore 7
    //   526: aload 5
    //   528: astore 6
    //   530: aload 5
    //   532: astore 8
    //   534: aload_0
    //   535: getfield 343	com/whatsapp/data/ad:ab	Lcom/whatsapp/data/cq;
    //   538: aload_1
    //   539: invokevirtual 3532	com/whatsapp/data/cq:a	(Ljava/lang/String;)Z
    //   542: pop
    //   543: aload 5
    //   545: astore 7
    //   547: aload 5
    //   549: astore 6
    //   551: aload 5
    //   553: astore 8
    //   555: aload 5
    //   557: invokevirtual 1160	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   560: aload 5
    //   562: ifnull +194 -> 756
    //   565: aload 5
    //   567: invokevirtual 1163	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   570: ifeq +186 -> 756
    //   573: aload 5
    //   575: invokevirtual 1166	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   578: iconst_1
    //   579: istore 4
    //   581: aload_0
    //   582: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   585: invokevirtual 460	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   588: new 162	java/lang/StringBuilder
    //   591: dup
    //   592: ldc_w 3534
    //   595: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   598: aload_1
    //   599: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: ldc_w 3536
    //   605: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: iload 4
    //   610: invokevirtual 1763	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   613: ldc_w 3538
    //   616: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: aload 9
    //   621: invokevirtual 467	com/whatsapp/util/bd:b	()J
    //   624: invokevirtual 470	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   627: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   630: invokestatic 474	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   633: iload 4
    //   635: ireturn
    //   636: astore 6
    //   638: aconst_null
    //   639: astore 5
    //   641: aload 6
    //   643: invokestatic 1169	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   646: aload_0
    //   647: new 1171	java/lang/AssertionError
    //   650: dup
    //   651: aload 6
    //   653: invokespecial 1174	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   656: invokevirtual 1176	com/whatsapp/data/ad:a	(Ljava/lang/Throwable;)V
    //   659: aload 5
    //   661: ifnull +89 -> 750
    //   664: aload 5
    //   666: invokevirtual 1163	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   669: ifeq +81 -> 750
    //   672: aload 5
    //   674: invokevirtual 1166	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   677: iconst_0
    //   678: istore 4
    //   680: goto -99 -> 581
    //   683: astore_1
    //   684: aload 7
    //   686: astore 6
    //   688: aload_1
    //   689: invokestatic 1169	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   692: aload 7
    //   694: astore 6
    //   696: aload_1
    //   697: athrow
    //   698: astore_1
    //   699: aload 6
    //   701: ifnull +16 -> 717
    //   704: aload 6
    //   706: invokevirtual 1163	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   709: ifeq +8 -> 717
    //   712: aload 6
    //   714: invokevirtual 1166	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   717: aload_1
    //   718: athrow
    //   719: astore_1
    //   720: aload_0
    //   721: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   724: invokevirtual 460	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   727: aload_1
    //   728: athrow
    //   729: astore_1
    //   730: aload 5
    //   732: astore 6
    //   734: goto -35 -> 699
    //   737: astore_1
    //   738: aload 8
    //   740: astore 7
    //   742: goto -58 -> 684
    //   745: astore 6
    //   747: goto -106 -> 641
    //   750: iconst_0
    //   751: istore 4
    //   753: goto -172 -> 581
    //   756: iconst_1
    //   757: istore 4
    //   759: goto -178 -> 581
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	762	0	this	ad
    //   0	762	1	paramString	String
    //   303	176	2	i1	int
    //   361	24	3	i2	int
    //   579	179	4	bool	boolean
    //   59	672	5	localSQLiteDatabase	SQLiteDatabase
    //   1	549	6	localObject1	Object
    //   636	16	6	localSQLiteDatabaseCorruptException1	SQLiteDatabaseCorruptException
    //   686	47	6	localObject2	Object
    //   745	1	6	localSQLiteDatabaseCorruptException2	SQLiteDatabaseCorruptException
    //   7	734	7	localObject3	Object
    //   4	735	8	localObject4	Object
    //   19	601	9	localbd	bd
    //   30	465	10	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   52	61	636	android/database/sqlite/SQLiteDatabaseCorruptException
    //   52	61	683	java/lang/RuntimeException
    //   73	78	683	java/lang/RuntimeException
    //   90	100	683	java/lang/RuntimeException
    //   112	122	683	java/lang/RuntimeException
    //   134	144	683	java/lang/RuntimeException
    //   156	168	683	java/lang/RuntimeException
    //   180	192	683	java/lang/RuntimeException
    //   204	216	683	java/lang/RuntimeException
    //   228	240	683	java/lang/RuntimeException
    //   252	264	683	java/lang/RuntimeException
    //   276	288	683	java/lang/RuntimeException
    //   300	304	683	java/lang/RuntimeException
    //   316	328	683	java/lang/RuntimeException
    //   340	362	683	java/lang/RuntimeException
    //   374	394	683	java/lang/RuntimeException
    //   406	414	683	java/lang/RuntimeException
    //   426	442	683	java/lang/RuntimeException
    //   459	464	683	java/lang/RuntimeException
    //   476	482	683	java/lang/RuntimeException
    //   494	503	683	java/lang/RuntimeException
    //   515	522	683	java/lang/RuntimeException
    //   534	543	683	java/lang/RuntimeException
    //   555	560	683	java/lang/RuntimeException
    //   52	61	698	finally
    //   73	78	698	finally
    //   90	100	698	finally
    //   112	122	698	finally
    //   134	144	698	finally
    //   156	168	698	finally
    //   180	192	698	finally
    //   204	216	698	finally
    //   228	240	698	finally
    //   252	264	698	finally
    //   276	288	698	finally
    //   300	304	698	finally
    //   316	328	698	finally
    //   340	362	698	finally
    //   374	394	698	finally
    //   406	414	698	finally
    //   426	442	698	finally
    //   459	464	698	finally
    //   476	482	698	finally
    //   494	503	698	finally
    //   515	522	698	finally
    //   534	543	698	finally
    //   555	560	698	finally
    //   688	692	698	finally
    //   696	698	698	finally
    //   44	52	719	finally
    //   565	578	719	finally
    //   664	677	719	finally
    //   704	717	719	finally
    //   717	719	719	finally
    //   641	659	729	finally
    //   52	61	737	java/lang/Error
    //   73	78	737	java/lang/Error
    //   90	100	737	java/lang/Error
    //   112	122	737	java/lang/Error
    //   134	144	737	java/lang/Error
    //   156	168	737	java/lang/Error
    //   180	192	737	java/lang/Error
    //   204	216	737	java/lang/Error
    //   228	240	737	java/lang/Error
    //   252	264	737	java/lang/Error
    //   276	288	737	java/lang/Error
    //   300	304	737	java/lang/Error
    //   316	328	737	java/lang/Error
    //   340	362	737	java/lang/Error
    //   374	394	737	java/lang/Error
    //   406	414	737	java/lang/Error
    //   426	442	737	java/lang/Error
    //   459	464	737	java/lang/Error
    //   476	482	737	java/lang/Error
    //   494	503	737	java/lang/Error
    //   515	522	737	java/lang/Error
    //   534	543	737	java/lang/Error
    //   555	560	737	java/lang/Error
    //   73	78	745	android/database/sqlite/SQLiteDatabaseCorruptException
    //   90	100	745	android/database/sqlite/SQLiteDatabaseCorruptException
    //   112	122	745	android/database/sqlite/SQLiteDatabaseCorruptException
    //   134	144	745	android/database/sqlite/SQLiteDatabaseCorruptException
    //   156	168	745	android/database/sqlite/SQLiteDatabaseCorruptException
    //   180	192	745	android/database/sqlite/SQLiteDatabaseCorruptException
    //   204	216	745	android/database/sqlite/SQLiteDatabaseCorruptException
    //   228	240	745	android/database/sqlite/SQLiteDatabaseCorruptException
    //   252	264	745	android/database/sqlite/SQLiteDatabaseCorruptException
    //   276	288	745	android/database/sqlite/SQLiteDatabaseCorruptException
    //   300	304	745	android/database/sqlite/SQLiteDatabaseCorruptException
    //   316	328	745	android/database/sqlite/SQLiteDatabaseCorruptException
    //   340	362	745	android/database/sqlite/SQLiteDatabaseCorruptException
    //   374	394	745	android/database/sqlite/SQLiteDatabaseCorruptException
    //   406	414	745	android/database/sqlite/SQLiteDatabaseCorruptException
    //   426	442	745	android/database/sqlite/SQLiteDatabaseCorruptException
    //   459	464	745	android/database/sqlite/SQLiteDatabaseCorruptException
    //   476	482	745	android/database/sqlite/SQLiteDatabaseCorruptException
    //   494	503	745	android/database/sqlite/SQLiteDatabaseCorruptException
    //   515	522	745	android/database/sqlite/SQLiteDatabaseCorruptException
    //   534	543	745	android/database/sqlite/SQLiteDatabaseCorruptException
    //   555	560	745	android/database/sqlite/SQLiteDatabaseCorruptException
  }
  
  /* Error */
  public final boolean k(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: iconst_0
    //   4: istore_3
    //   5: aload_0
    //   6: getfield 281	com/whatsapp/data/ad:n	Lcom/whatsapp/data/d;
    //   9: getfield 1406	com/whatsapp/data/d:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   12: aload_1
    //   13: invokevirtual 1409	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   16: checkcast 17	com/whatsapp/data/ad$d
    //   19: astore 9
    //   21: aload 9
    //   23: ifnonnull +5 -> 28
    //   26: iconst_1
    //   27: ireturn
    //   28: new 411	com/whatsapp/util/bd
    //   31: dup
    //   32: ldc_w 3540
    //   35: invokespecial 414	com/whatsapp/util/bd:<init>	(Ljava/lang/String;)V
    //   38: astore 10
    //   40: aload_0
    //   41: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   44: invokevirtual 419	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   47: aload_0
    //   48: getfield 327	com/whatsapp/data/ad:y	Lcom/whatsapp/data/aa;
    //   51: aload_1
    //   52: invokevirtual 3528	com/whatsapp/data/aa:a	(Ljava/lang/String;)V
    //   55: aload_0
    //   56: getfield 361	com/whatsapp/data/ad:b	Lcom/whatsapp/data/n;
    //   59: invokevirtual 604	com/whatsapp/data/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   62: astore 8
    //   64: aload 8
    //   66: astore 6
    //   68: aload 8
    //   70: invokevirtual 1143	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   73: iload_3
    //   74: istore_2
    //   75: aload 8
    //   77: astore 6
    //   79: aload_1
    //   80: invokestatic 1360	com/whatsapp/data/cs:e	(Ljava/lang/String;)Z
    //   83: ifne +18 -> 101
    //   86: iload_3
    //   87: istore_2
    //   88: aload 8
    //   90: astore 6
    //   92: aload_1
    //   93: invokestatic 1361	com/whatsapp/qz:e	(Ljava/lang/String;)Z
    //   96: ifne +5 -> 101
    //   99: iconst_1
    //   100: istore_2
    //   101: aload 8
    //   103: astore 6
    //   105: new 162	java/lang/StringBuilder
    //   108: dup
    //   109: ldc_w 3542
    //   112: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   115: astore 11
    //   117: iload_2
    //   118: ifeq +484 -> 602
    //   121: ldc_w 3544
    //   124: astore 7
    //   126: aload 8
    //   128: astore 6
    //   130: aload 8
    //   132: ldc -51
    //   134: aload 11
    //   136: aload 7
    //   138: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: ldc_w 3546
    //   144: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: iconst_4
    //   151: anewarray 429	java/lang/String
    //   154: dup
    //   155: iconst_0
    //   156: aload_1
    //   157: aastore
    //   158: dup
    //   159: iconst_1
    //   160: iconst_0
    //   161: invokestatic 174	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   164: aastore
    //   165: dup
    //   166: iconst_2
    //   167: bipush 6
    //   169: invokestatic 174	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   172: aastore
    //   173: dup
    //   174: iconst_3
    //   175: bipush 19
    //   177: invokestatic 174	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   180: aastore
    //   181: invokevirtual 1102	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   184: istore_2
    //   185: aload 8
    //   187: astore 6
    //   189: new 162	java/lang/StringBuilder
    //   192: dup
    //   193: ldc_w 3548
    //   196: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   199: iload_2
    //   200: invokevirtual 1120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   203: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokestatic 474	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   209: aload 8
    //   211: astore 6
    //   213: aload_0
    //   214: aload_1
    //   215: invokevirtual 482	com/whatsapp/data/ad:w	(Ljava/lang/String;)J
    //   218: lstore 4
    //   220: aload 8
    //   222: astore 6
    //   224: invokestatic 2150	com/whatsapp/data/ad:k	()I
    //   227: istore_2
    //   228: aload 8
    //   230: astore 6
    //   232: aload 9
    //   234: invokevirtual 3513	com/whatsapp/data/ad$d:a	()V
    //   237: aload 8
    //   239: astore 6
    //   241: aload 9
    //   243: iload_2
    //   244: putfield 2086	com/whatsapp/data/ad$d:g	I
    //   247: lload 4
    //   249: lconst_1
    //   250: lcmp
    //   251: ifeq +92 -> 343
    //   254: aload 8
    //   256: astore 6
    //   258: aload 9
    //   260: aload_0
    //   261: getfield 307	com/whatsapp/data/ad:t	Lcom/whatsapp/data/l;
    //   264: lload 4
    //   266: invokevirtual 1396	com/whatsapp/data/l:a	(J)Lcom/whatsapp/protocol/j;
    //   269: putfield 1488	com/whatsapp/data/ad$d:b	Lcom/whatsapp/protocol/j;
    //   272: aload 8
    //   274: astore 6
    //   276: aload 9
    //   278: getfield 1488	com/whatsapp/data/ad$d:b	Lcom/whatsapp/protocol/j;
    //   281: ifnull +62 -> 343
    //   284: aload 8
    //   286: astore 6
    //   288: aload 9
    //   290: getfield 1488	com/whatsapp/data/ad$d:b	Lcom/whatsapp/protocol/j;
    //   293: invokestatic 1996	com/whatsapp/data/ad:i	(Lcom/whatsapp/protocol/j;)Z
    //   296: ifne +314 -> 610
    //   299: aload 8
    //   301: astore 6
    //   303: aload 9
    //   305: lload 4
    //   307: putfield 1490	com/whatsapp/data/ad$d:a	J
    //   310: aload 8
    //   312: astore 6
    //   314: aload 9
    //   316: lload 4
    //   318: putfield 1492	com/whatsapp/data/ad$d:c	J
    //   321: aload 8
    //   323: astore 6
    //   325: aload 9
    //   327: lload 4
    //   329: putfield 1414	com/whatsapp/data/ad$d:d	J
    //   332: aload 8
    //   334: astore 6
    //   336: aload 9
    //   338: lload 4
    //   340: putfield 1494	com/whatsapp/data/ad$d:q	J
    //   343: aload 8
    //   345: astore 6
    //   347: new 1033	android/content/ContentValues
    //   350: dup
    //   351: iconst_3
    //   352: invokespecial 1036	android/content/ContentValues:<init>	(I)V
    //   355: astore 7
    //   357: aload 8
    //   359: astore 6
    //   361: aload 7
    //   363: ldc_w 2152
    //   366: aload 9
    //   368: getfield 2086	com/whatsapp/data/ad$d:g	I
    //   371: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   374: invokevirtual 1090	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   377: aload 8
    //   379: astore 6
    //   381: aload 7
    //   383: ldc_w 1250
    //   386: aload 9
    //   388: getfield 1490	com/whatsapp/data/ad$d:a	J
    //   391: invokestatic 588	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   394: invokevirtual 1085	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   397: aload 8
    //   399: astore 6
    //   401: aload 7
    //   403: ldc_w 1477
    //   406: aload 9
    //   408: getfield 1494	com/whatsapp/data/ad$d:q	J
    //   411: invokestatic 588	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   414: invokevirtual 1085	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   417: aload 8
    //   419: astore 6
    //   421: aload 7
    //   423: ldc_w 1252
    //   426: aload 9
    //   428: getfield 1492	com/whatsapp/data/ad$d:c	J
    //   431: invokestatic 588	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   434: invokevirtual 1085	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   437: aload 8
    //   439: astore 6
    //   441: aload 7
    //   443: ldc_w 1416
    //   446: aload 9
    //   448: getfield 1414	com/whatsapp/data/ad$d:d	J
    //   451: invokestatic 588	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   454: invokevirtual 1085	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   457: aload 8
    //   459: astore 6
    //   461: aload 8
    //   463: ldc_w 1149
    //   466: aload 7
    //   468: ldc_w 1151
    //   471: iconst_1
    //   472: anewarray 429	java/lang/String
    //   475: dup
    //   476: iconst_0
    //   477: aload_1
    //   478: aastore
    //   479: invokevirtual 1062	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   482: istore_2
    //   483: aload 8
    //   485: astore 6
    //   487: new 162	java/lang/StringBuilder
    //   490: dup
    //   491: ldc_w 3550
    //   494: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   497: iload_2
    //   498: invokevirtual 1120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   501: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   504: invokestatic 474	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   507: aload 8
    //   509: astore 6
    //   511: aload_0
    //   512: getfield 339	com/whatsapp/data/ad:C	Lcom/whatsapp/data/o;
    //   515: aload_1
    //   516: invokevirtual 3531	com/whatsapp/data/o:a	(Ljava/lang/String;)V
    //   519: aload 8
    //   521: astore 6
    //   523: aload_0
    //   524: getfield 343	com/whatsapp/data/ad:ab	Lcom/whatsapp/data/cq;
    //   527: aload_1
    //   528: invokevirtual 3532	com/whatsapp/data/cq:a	(Ljava/lang/String;)Z
    //   531: pop
    //   532: aload 8
    //   534: astore 6
    //   536: aload 8
    //   538: invokevirtual 1160	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   541: aload 8
    //   543: ifnull +16 -> 559
    //   546: aload 8
    //   548: invokevirtual 1163	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   551: ifeq +8 -> 559
    //   554: aload 8
    //   556: invokevirtual 1166	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   559: aload_0
    //   560: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   563: invokevirtual 460	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   566: new 162	java/lang/StringBuilder
    //   569: dup
    //   570: ldc_w 3552
    //   573: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   576: aload_1
    //   577: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: ldc_w 3554
    //   583: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: aload 10
    //   588: invokevirtual 467	com/whatsapp/util/bd:b	()J
    //   591: invokevirtual 470	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   594: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   597: invokestatic 474	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   600: iconst_1
    //   601: ireturn
    //   602: ldc_w 1031
    //   605: astore 7
    //   607: goto -481 -> 126
    //   610: aload 8
    //   612: astore 6
    //   614: aload 9
    //   616: aconst_null
    //   617: putfield 1488	com/whatsapp/data/ad$d:b	Lcom/whatsapp/protocol/j;
    //   620: goto -310 -> 310
    //   623: astore_1
    //   624: aload 6
    //   626: ifnull +16 -> 642
    //   629: aload 6
    //   631: invokevirtual 1163	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   634: ifeq +8 -> 642
    //   637: aload 6
    //   639: invokevirtual 1166	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   642: aload_1
    //   643: athrow
    //   644: astore_1
    //   645: aload_0
    //   646: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   649: invokevirtual 460	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   652: aload_1
    //   653: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	654	0	this	ad
    //   0	654	1	paramString	String
    //   74	424	2	i1	int
    //   4	83	3	i2	int
    //   218	121	4	l1	long
    //   1	637	6	localObject1	Object
    //   124	482	7	localObject2	Object
    //   62	549	8	localSQLiteDatabase	SQLiteDatabase
    //   19	596	9	locald	d
    //   38	549	10	localbd	bd
    //   115	20	11	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   55	64	623	finally
    //   68	73	623	finally
    //   79	86	623	finally
    //   92	99	623	finally
    //   105	117	623	finally
    //   130	185	623	finally
    //   189	209	623	finally
    //   213	220	623	finally
    //   224	228	623	finally
    //   232	237	623	finally
    //   241	247	623	finally
    //   258	272	623	finally
    //   276	284	623	finally
    //   288	299	623	finally
    //   303	310	623	finally
    //   314	321	623	finally
    //   325	332	623	finally
    //   336	343	623	finally
    //   347	357	623	finally
    //   361	377	623	finally
    //   381	397	623	finally
    //   401	417	623	finally
    //   421	437	623	finally
    //   441	457	623	finally
    //   461	483	623	finally
    //   487	507	623	finally
    //   511	519	623	finally
    //   523	532	623	finally
    //   536	541	623	finally
    //   614	620	623	finally
    //   47	55	644	finally
    //   546	559	644	finally
    //   629	642	644	finally
    //   642	644	644	finally
  }
  
  /* Error */
  public final void l()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: ldc_w 3556
    //   8: invokestatic 474	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   11: aload_0
    //   12: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   15: invokevirtual 419	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   18: aload_0
    //   19: getfield 361	com/whatsapp/data/ad:b	Lcom/whatsapp/data/n;
    //   22: invokevirtual 425	com/whatsapp/data/n:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   25: ldc_w 3558
    //   28: aconst_null
    //   29: invokevirtual 435	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   32: astore 5
    //   34: aload 5
    //   36: ifnull +157 -> 193
    //   39: aload 5
    //   41: astore_3
    //   42: aload 5
    //   44: astore 4
    //   46: aload 5
    //   48: invokeinterface 441 1 0
    //   53: ifeq +140 -> 193
    //   56: aload 5
    //   58: astore_3
    //   59: aload 5
    //   61: astore 4
    //   63: aload 5
    //   65: iconst_0
    //   66: invokeinterface 2073 2 0
    //   71: astore 6
    //   73: aload 5
    //   75: astore_3
    //   76: aload 5
    //   78: astore 4
    //   80: aload 5
    //   82: iconst_1
    //   83: invokeinterface 2073 2 0
    //   88: astore 7
    //   90: lconst_0
    //   91: lstore_1
    //   92: aload 5
    //   94: astore_3
    //   95: aload 5
    //   97: astore 4
    //   99: aload 5
    //   101: iconst_2
    //   102: invokeinterface 3455 2 0
    //   107: ifne +19 -> 126
    //   110: aload 5
    //   112: astore_3
    //   113: aload 5
    //   115: astore 4
    //   117: aload 5
    //   119: iconst_2
    //   120: invokeinterface 1393 2 0
    //   125: lstore_1
    //   126: aload 5
    //   128: astore_3
    //   129: aload 5
    //   131: astore 4
    //   133: aload_0
    //   134: getfield 291	com/whatsapp/data/ad:Q	Lcom/whatsapp/data/e;
    //   137: aload 6
    //   139: aload 7
    //   141: lload_1
    //   142: invokevirtual 3561	com/whatsapp/data/e:a	(Ljava/lang/String;Ljava/lang/String;J)Lcom/whatsapp/data/cs;
    //   145: pop
    //   146: goto -107 -> 39
    //   149: astore 5
    //   151: aload_3
    //   152: astore 4
    //   154: new 162	java/lang/StringBuilder
    //   157: dup
    //   158: ldc_w 3563
    //   161: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   164: aload 5
    //   166: invokevirtual 583	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 509	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   175: aload_3
    //   176: ifnull +9 -> 185
    //   179: aload_3
    //   180: invokeinterface 457 1 0
    //   185: aload_0
    //   186: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   189: invokevirtual 460	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   192: return
    //   193: aload 5
    //   195: ifnull -10 -> 185
    //   198: aload 5
    //   200: invokeinterface 457 1 0
    //   205: goto -20 -> 185
    //   208: astore_3
    //   209: aload_0
    //   210: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   213: invokevirtual 460	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   216: aload_3
    //   217: athrow
    //   218: astore_3
    //   219: aload 4
    //   221: ifnull +10 -> 231
    //   224: aload 4
    //   226: invokeinterface 457 1 0
    //   231: aload_3
    //   232: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	this	ad
    //   91	51	1	l1	long
    //   4	176	3	localObject1	Object
    //   208	9	3	localObject2	Object
    //   218	14	3	localObject3	Object
    //   1	224	4	localObject4	Object
    //   32	98	5	localCursor	Cursor
    //   149	50	5	localSQLiteDiskIOException	SQLiteDiskIOException
    //   71	67	6	str1	String
    //   88	52	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   18	34	149	android/database/sqlite/SQLiteDiskIOException
    //   46	56	149	android/database/sqlite/SQLiteDiskIOException
    //   63	73	149	android/database/sqlite/SQLiteDiskIOException
    //   80	90	149	android/database/sqlite/SQLiteDiskIOException
    //   99	110	149	android/database/sqlite/SQLiteDiskIOException
    //   117	126	149	android/database/sqlite/SQLiteDiskIOException
    //   133	146	149	android/database/sqlite/SQLiteDiskIOException
    //   179	185	208	finally
    //   198	205	208	finally
    //   224	231	208	finally
    //   231	233	208	finally
    //   18	34	218	finally
    //   46	56	218	finally
    //   63	73	218	finally
    //   80	90	218	finally
    //   99	110	218	finally
    //   117	126	218	finally
    //   133	146	218	finally
    //   154	175	218	finally
  }
  
  public final void l(String paramString)
  {
    Log.i("msgstore/deletemsgsasync/jid " + paramString);
    Message.obtain(this.d, 6, paramString).sendToTarget();
  }
  
  public final ArrayList<j> m()
  {
    ArrayList localArrayList = new ArrayList();
    this.i.lock();
    for (;;)
    {
      try
      {
        Object localObject = this.b.getReadableDatabase();
        if (localObject == null)
        {
          Log.e("msgstore/future/db/unavailable");
          return localArrayList;
        }
        localObject = ((SQLiteDatabase)localObject).rawQuery("SELECT key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, raw_data, recipient_count, participant_hash, starred, quoted_row_id, mentioned_jids, multicast_id, edit_version, receipt_server_timestamp, media_enc_hash, _id, key_remote_jid FROM messages WHERE key_from_me=0 AND media_wa_type=12 ORDER BY _id", null);
        if (localObject == null) {
          break label182;
        }
        int i1 = ((Cursor)localObject).getColumnIndex("key_remote_jid");
        String str;
        try
        {
          if (!((Cursor)localObject).moveToNext()) {
            break;
          }
          str = ((Cursor)localObject).getString(i1);
          if (str == null)
          {
            Log.w("msgstore/future/jid is null!");
            continue;
            localCursor = finally;
          }
        }
        catch (SQLiteDiskIOException localSQLiteDiskIOException)
        {
          a.a.a.a.d.h(this.J);
          throw localSQLiteDiskIOException;
        }
        finally
        {
          ((Cursor)localObject).close();
        }
        localArrayList1.add(this.t.a(localCursor, str));
      }
      finally
      {
        this.i.unlock();
      }
    }
    localCursor.close();
    for (;;)
    {
      this.i.unlock();
      Log.i("msgstore/future/size:" + localArrayList1.size());
      return localArrayList1;
      label182:
      Log.e("msgstore/future/db/cursor is null");
    }
  }
  
  /* Error */
  public final boolean m(String paramString)
  {
    // Byte code:
    //   0: new 411	com/whatsapp/util/bd
    //   3: dup
    //   4: ldc_w 3577
    //   7: invokespecial 414	com/whatsapp/util/bd:<init>	(Ljava/lang/String;)V
    //   10: astore 4
    //   12: aload_0
    //   13: aload_1
    //   14: invokespecial 3527	com/whatsapp/data/ad:A	(Ljava/lang/String;)V
    //   17: iconst_1
    //   18: anewarray 429	java/lang/String
    //   21: astore 5
    //   23: aload 5
    //   25: iconst_0
    //   26: aload_1
    //   27: aastore
    //   28: aconst_null
    //   29: astore_2
    //   30: aload_0
    //   31: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   34: invokevirtual 419	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   37: aload_0
    //   38: getfield 327	com/whatsapp/data/ad:y	Lcom/whatsapp/data/aa;
    //   41: aload_1
    //   42: invokevirtual 3528	com/whatsapp/data/aa:a	(Ljava/lang/String;)V
    //   45: aload_0
    //   46: getfield 361	com/whatsapp/data/ad:b	Lcom/whatsapp/data/n;
    //   49: invokevirtual 604	com/whatsapp/data/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   52: astore_3
    //   53: aload_3
    //   54: astore_2
    //   55: aload_3
    //   56: invokevirtual 1143	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   59: aload_3
    //   60: astore_2
    //   61: aload_3
    //   62: ldc_w 3134
    //   65: aload 5
    //   67: invokevirtual 3138	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   70: aload_3
    //   71: astore_2
    //   72: aload_3
    //   73: ldc_w 3140
    //   76: aload 5
    //   78: invokevirtual 3138	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   81: aload_3
    //   82: astore_2
    //   83: aload_3
    //   84: ldc_w 3142
    //   87: aload 5
    //   89: invokevirtual 3138	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   92: aload_3
    //   93: astore_2
    //   94: aload_0
    //   95: getfield 281	com/whatsapp/data/ad:n	Lcom/whatsapp/data/d;
    //   98: getfield 1406	com/whatsapp/data/d:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   101: aload_1
    //   102: invokevirtual 3143	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   105: pop
    //   106: aload_3
    //   107: astore_2
    //   108: aload_1
    //   109: invokestatic 1360	com/whatsapp/data/cs:e	(Ljava/lang/String;)Z
    //   112: ifne +12 -> 124
    //   115: aload_3
    //   116: astore_2
    //   117: aload_1
    //   118: invokestatic 1361	com/whatsapp/qz:e	(Ljava/lang/String;)Z
    //   121: ifeq +18 -> 139
    //   124: aload_3
    //   125: astore_2
    //   126: aload_3
    //   127: ldc_w 1056
    //   130: ldc_w 1107
    //   133: aload 5
    //   135: invokevirtual 1102	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   138: pop
    //   139: aload_3
    //   140: astore_2
    //   141: aload_0
    //   142: getfield 339	com/whatsapp/data/ad:C	Lcom/whatsapp/data/o;
    //   145: aload_1
    //   146: invokevirtual 3531	com/whatsapp/data/o:a	(Ljava/lang/String;)V
    //   149: aload_3
    //   150: astore_2
    //   151: aload_0
    //   152: getfield 343	com/whatsapp/data/ad:ab	Lcom/whatsapp/data/cq;
    //   155: aload_1
    //   156: invokevirtual 3532	com/whatsapp/data/cq:a	(Ljava/lang/String;)Z
    //   159: pop
    //   160: aload_3
    //   161: astore_2
    //   162: aload_3
    //   163: invokevirtual 1160	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   166: aload_3
    //   167: ifnull +14 -> 181
    //   170: aload_3
    //   171: invokevirtual 1163	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   174: ifeq +7 -> 181
    //   177: aload_3
    //   178: invokevirtual 1166	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   181: aload_0
    //   182: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   185: invokevirtual 460	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   188: new 162	java/lang/StringBuilder
    //   191: dup
    //   192: ldc_w 3579
    //   195: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   198: aload_1
    //   199: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: ldc_w 3554
    //   205: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload 4
    //   210: invokevirtual 467	com/whatsapp/util/bd:b	()J
    //   213: invokevirtual 470	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   216: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokestatic 474	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   222: iconst_1
    //   223: ireturn
    //   224: astore_1
    //   225: aload_2
    //   226: ifnull +14 -> 240
    //   229: aload_2
    //   230: invokevirtual 1163	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   233: ifeq +7 -> 240
    //   236: aload_2
    //   237: invokevirtual 1166	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   240: aload_1
    //   241: athrow
    //   242: astore_1
    //   243: aload_0
    //   244: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   247: invokevirtual 460	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   250: aload_1
    //   251: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	this	ad
    //   0	252	1	paramString	String
    //   29	208	2	localObject	Object
    //   52	126	3	localSQLiteDatabase	SQLiteDatabase
    //   10	199	4	localbd	bd
    //   21	113	5	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   45	53	224	finally
    //   55	59	224	finally
    //   61	70	224	finally
    //   72	81	224	finally
    //   83	92	224	finally
    //   94	106	224	finally
    //   108	115	224	finally
    //   117	124	224	finally
    //   126	139	224	finally
    //   141	149	224	finally
    //   151	160	224	finally
    //   162	166	224	finally
    //   37	45	242	finally
    //   170	181	242	finally
    //   229	240	242	finally
    //   240	242	242	finally
  }
  
  public final String n(String paramString)
  {
    paramString = (d)this.n.a.get(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.l;
  }
  
  final boolean n()
  {
    boolean bool2 = true;
    n localn = this.b;
    if (localn.a == null)
    {
      bool1 = true;
      a.d.a(bool1, "database nust be null");
      if (localn.getWritableDatabase() == null) {
        break label43;
      }
    }
    label43:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localn.close();
      return bool1;
      bool1 = false;
      break;
    }
  }
  
  public final int o(String paramString)
  {
    d locald = (d)this.n.a.get(paramString);
    if (locald == null) {
      return 0;
    }
    if (locald.q == 0L) {
      return this.Q.d(paramString).s;
    }
    return locald.n;
  }
  
  public final void o()
  {
    a.d.c();
    int i3 = 0;
    this.i.lock();
    bd localbd;
    HashSet localHashSet;
    ArrayList localArrayList;
    long l1;
    int i4;
    int i6;
    Object localObject3;
    int i1;
    int i2;
    long l2;
    Object localObject2;
    label516:
    label710:
    do
    {
      long l3;
      long l4;
      long l5;
      try
      {
        localbd = new bd("msgstore/deleteoldstatuses");
        Cursor localCursor = this.b.getWritableDatabase().rawQuery("SELECT key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, raw_data, recipient_count, participant_hash, starred, quoted_row_id, mentioned_jids, multicast_id, edit_version, receipt_server_timestamp, media_enc_hash, _id FROM messages WHERE key_remote_jid=? ORDER BY _id ASC", new String[] { "status@broadcast" });
        if (localCursor == null)
        {
          Log.e("msgstore/deleteoldstatuses/cursor-null");
          return;
        }
        l3 = this.j.b();
        l4 = this.v.b("status_psa_viewed_time");
        l5 = this.v.b("status_psa_exipration_time");
        localHashSet = new HashSet();
        localArrayList = new ArrayList();
        l1 = 0L;
        i5 = 0;
        i4 = 0;
        for (;;)
        {
          if (!localCursor.moveToNext()) {
            break label1025;
          }
          i6 = i5 + 1;
          localObject3 = this.t.a(localCursor, "status@broadcast");
          if (localObject3 != null) {
            break;
          }
          Log.w("msgstore/deleteoldstatuses/no message " + ((j)localObject3).e + " " + ((j)localObject3).s + " " + ((j)localObject3).d + " " + ((j)localObject3).n);
          i5 = i6;
        }
        if (!e.b(((j)localObject3).f)) {
          break label516;
        }
      }
      finally
      {
        this.i.unlock();
      }
      i1 = i4;
      i2 = i3;
      l2 = l1;
      if (this.j.b() > l5)
      {
        i1 = i4;
        i2 = i3;
        l2 = l1;
        if (l5 > 0L)
        {
          i1 = i4;
          i2 = i3;
          l2 = l1;
          if (((j)localObject3).n < l4)
          {
            Log.d("msgstore/deleteoldstatuses/psamessage " + ((j)localObject3).e + " " + ((j)localObject3).s + " " + ((j)localObject3).d + " " + ((j)localObject3).n);
            localArrayList.add(localObject3);
            i1 = i4 + 1;
            i2 = 1;
            l2 = l1;
          }
        }
      }
      for (;;)
      {
        i4 = i1;
        i5 = i6;
        i3 = i2;
        l1 = l2;
        if (localArrayList.size() < 256) {
          break;
        }
        Log.i("msgstore/deleteoldstatuses/delete total:" + i6 + " deleted:" + i1 + " current batch:" + localArrayList.size());
        ((Cursor)localObject1).close();
        localObject2 = localArrayList.iterator();
        while (((Iterator)localObject2).hasNext()) {
          a((j)((Iterator)localObject2).next(), true, false, false);
        }
        if ((((j)localObject3).e.b) && (((j)localObject3).I > 0L)) {}
        for (l2 = ((j)localObject3).I;; l2 = ((j)localObject3).n)
        {
          if (l2 >= l3 - 86400000L) {
            break label710;
          }
          Log.d("msgstore/deleteoldstatuses/message " + ((j)localObject3).e + " " + ((j)localObject3).f + " " + ((j)localObject3).s + " " + ((j)localObject3).d + " " + ((j)localObject3).n);
          localArrayList.add(localObject3);
          i4 += 1;
          i1 = i4;
          i2 = i3;
          l2 = l1;
          if (((j)localObject3).s == 15) {
            break;
          }
          i1 = i4;
          i2 = i3;
          l2 = l1;
          if (((j)localObject3).s == 11) {
            break;
          }
          i2 = 1;
          i1 = i4;
          l2 = l1;
          break;
        }
        localHashSet.add(((j)localObject3).f);
        if (l1 != 0L)
        {
          i1 = i4;
          i2 = i3;
          l2 = l1;
          if (l1 <= ((j)localObject3).n) {}
        }
        else
        {
          l2 = ((j)localObject3).n;
          i1 = i4;
          i2 = i3;
        }
      }
      localArrayList.clear();
      localObject3 = this.b.getWritableDatabase().rawQuery("SELECT key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, raw_data, recipient_count, participant_hash, starred, quoted_row_id, mentioned_jids, multicast_id, edit_version, receipt_server_timestamp, media_enc_hash, _id FROM messages WHERE key_remote_jid=? AND _id>? ORDER BY _id ASC", new String[] { "status@broadcast", Long.toString(((j)localObject3).Q) });
      localObject2 = localObject3;
      i4 = i1;
      i5 = i6;
      i3 = i2;
      l1 = l2;
    } while (localObject3 != null);
    Log.e("msgstore/deleteoldstatuses/cursor-null");
    i3 = i2;
    int i5 = i6;
    for (;;)
    {
      if (localObject3 != null) {
        ((Cursor)localObject3).close();
      }
      Log.i("msgstore/deleteoldstatuses/delete total:" + i5 + " deleted:" + i1 + " last batch:" + localArrayList.size());
      localObject2 = localArrayList.iterator();
      while (((Iterator)localObject2).hasNext()) {
        a((j)((Iterator)localObject2).next(), true, false, false);
      }
      this.v.a("earliest_status_time", l2);
      Log.i("msgstore/deleteoldstatuses new earliest time:" + l2 + " active jids:" + localHashSet.size() + " time spent:" + localbd.b());
      this.i.unlock();
      if (i3 == 0) {
        break;
      }
      this.p.e.post(bj.a(this));
      return;
      label1025:
      i1 = i4;
      l2 = l1;
      localObject3 = localObject2;
    }
  }
  
  public final o p(String paramString)
  {
    d locald = (d)this.n.a.get(paramString);
    if (locald == null) {
      return new o(0, 0, 0);
    }
    if (locald.q == 0L)
    {
      int i1 = this.Q.d(paramString).s;
      return new o(i1, 0, i1);
    }
    return locald.c();
  }
  
  final void p()
  {
    if ((this.I.exists()) && (!this.I.delete())) {
      Log.w("msgstore/copydbtobackup/failed to delete backup file before copying from db.");
    }
    if (this.e.exists())
    {
      a.a.a.a.d.a(this.W, this.e, this.I);
      return;
    }
    Log.w("msgstore/copydbtobackup/no db to backup.");
  }
  
  final void q()
  {
    if ((this.e.exists()) && (!this.e.delete())) {
      Log.w("msgstore/copybackuptodb/failed to delete db before copying from backup up.");
    }
    if (this.I.exists())
    {
      a.a.a.a.d.a(this.W, this.I, this.e);
      return;
    }
    Log.w("msgstore/copybackuptodb/no backup db to copy.");
  }
  
  final void q(String paramString)
  {
    this.i.lock();
    for (;;)
    {
      try
      {
        localObject = (d)this.n.a.get(paramString);
        if (localObject != null)
        {
          Log.i("disabling plaintext chat; jid=" + paramString + "; current=" + ((d)localObject).j);
          i1 = ((d)localObject).j;
          if (i1 == 1) {
            return;
          }
          ((d)localObject).j = 1;
          localObject = this.b.getWritableDatabase();
        }
      }
      finally
      {
        int i1;
        ContentValues localContentValues;
        this.i.unlock();
      }
      try
      {
        ((SQLiteDatabase)localObject).beginTransaction();
        localContentValues = new ContentValues();
        localContentValues.put("plaintext_disabled", Integer.valueOf(1));
        i1 = ((SQLiteDatabase)localObject).update("chat_list", localContentValues, "key_remote_jid=?", new String[] { paramString });
        Log.i("disabled plaintext chat; jid=" + paramString + "; numRows=" + i1);
        if (i1 > 0)
        {
          if ((!qz.e(paramString)) || (this.E.b(paramString))) {
            a(paramString, 0, null);
          }
          this.q.a(this.Q, paramString);
        }
        ((SQLiteDatabase)localObject).setTransactionSuccessful();
        if (((SQLiteDatabase)localObject).inTransaction()) {
          ((SQLiteDatabase)localObject).endTransaction();
        }
        this.i.unlock();
        return;
      }
      finally
      {
        if (!((SQLiteDatabase)localObject).inTransaction()) {
          break;
        }
        ((SQLiteDatabase)localObject).endTransaction();
      }
      Log.w("missing chat info; jid=" + paramString);
    }
  }
  
  public final j r(String paramString)
  {
    if (paramString == null)
    {
      Log.e("msgstore/last/message/jid is null");
      return null;
    }
    d locald = (d)this.n.a.get(paramString);
    if (locald == null)
    {
      Log.w("msgstore/last/message/no chat for " + paramString);
      return null;
    }
    if (locald.b != null) {
      return locald.b;
    }
    locald.b = C(paramString);
    return locald.b;
  }
  
  public final j s(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramString == null)
    {
      Log.d("msgstore/last-raw/db/jid is null");
      return null;
    }
    Log.d("msgstore/last-raw/db/jid " + paramString);
    this.i.lock();
    for (;;)
    {
      try
      {
        Cursor localCursor = this.b.getReadableDatabase().rawQuery("SELECT key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, raw_data, recipient_count, participant_hash, starred, quoted_row_id, mentioned_jids, multicast_id, edit_version, receipt_server_timestamp, media_enc_hash, _id FROM messages WHERE key_remote_jid=?  ORDER BY _id DESC LIMIT 1", new String[] { paramString });
        if (localCursor != null) {
          try
          {
            if (localCursor.moveToNext())
            {
              paramString = this.t.a(localCursor, paramString);
              localCursor.close();
              return paramString;
            }
            Log.w("msgstore/last-raw/db no message for " + paramString);
            paramString = (String)localObject1;
            continue;
            paramString = finally;
          }
          finally
          {
            localCursor.close();
          }
        }
        Log.e("msgstore/last-raw/db/cursor is null");
      }
      finally
      {
        this.i.unlock();
      }
      paramString = (String)localObject2;
    }
  }
  
  public final j t(String paramString)
  {
    Log.d("msgstore/last-photo-change/db/jid " + paramString);
    Object localObject2 = null;
    Object localObject1 = null;
    this.i.lock();
    for (;;)
    {
      try
      {
        Cursor localCursor = this.b.getReadableDatabase().rawQuery("SELECT key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, raw_data, recipient_count, participant_hash, starred, quoted_row_id, mentioned_jids, multicast_id, edit_version, receipt_server_timestamp, media_enc_hash, _id FROM messages WHERE key_remote_jid=?  AND key_from_me=1 AND status=6 AND media_wa_type=0 AND media_size=6 ORDER BY _id DESC LIMIT 1", new String[] { paramString });
        if (localCursor != null) {
          try
          {
            if (localCursor.moveToNext())
            {
              paramString = this.t.a(localCursor, paramString);
              localCursor.close();
              return paramString;
            }
            Log.i("msgstore/last-photo-change/db no message for " + paramString);
            paramString = (String)localObject1;
            continue;
            paramString = finally;
          }
          finally
          {
            localCursor.close();
          }
        }
        Log.e("msgstore/last-photo-change/db/cursor is null");
      }
      finally
      {
        this.i.unlock();
      }
      paramString = (String)localObject2;
    }
  }
  
  /* Error */
  public final ArrayList<j> u(String paramString)
  {
    // Byte code:
    //   0: new 955	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 956	java/util/ArrayList:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: getfield 361	com/whatsapp/data/ad:b	Lcom/whatsapp/data/n;
    //   12: invokevirtual 425	com/whatsapp/data/n:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   15: ldc_w 3677
    //   18: iconst_1
    //   19: anewarray 429	java/lang/String
    //   22: dup
    //   23: iconst_0
    //   24: aload_1
    //   25: aastore
    //   26: invokevirtual 435	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   29: astore_2
    //   30: aload_2
    //   31: ifnull +57 -> 88
    //   34: aload_2
    //   35: invokeinterface 441 1 0
    //   40: ifeq +50 -> 90
    //   43: aload_0
    //   44: getfield 307	com/whatsapp/data/ad:t	Lcom/whatsapp/data/l;
    //   47: aload_2
    //   48: aload_1
    //   49: invokevirtual 446	com/whatsapp/data/l:a	(Landroid/database/Cursor;Ljava/lang/String;)Lcom/whatsapp/protocol/j;
    //   52: astore 4
    //   54: aload 4
    //   56: ifnull -22 -> 34
    //   59: aload_3
    //   60: aload 4
    //   62: invokevirtual 982	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   65: pop
    //   66: goto -32 -> 34
    //   69: astore_1
    //   70: aload_0
    //   71: new 1171	java/lang/AssertionError
    //   74: dup
    //   75: aload_1
    //   76: invokespecial 1174	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   79: invokevirtual 1176	com/whatsapp/data/ad:a	(Ljava/lang/Throwable;)V
    //   82: aload_2
    //   83: invokeinterface 457 1 0
    //   88: aload_3
    //   89: areturn
    //   90: aload_2
    //   91: invokeinterface 457 1 0
    //   96: aload_3
    //   97: areturn
    //   98: astore_1
    //   99: new 162	java/lang/StringBuilder
    //   102: dup
    //   103: ldc_w 2919
    //   106: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   109: aload_1
    //   110: invokevirtual 583	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 474	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   119: aload_2
    //   120: invokeinterface 457 1 0
    //   125: aload_3
    //   126: areturn
    //   127: astore_1
    //   128: aload_2
    //   129: invokeinterface 457 1 0
    //   134: aload_1
    //   135: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	ad
    //   0	136	1	paramString	String
    //   29	100	2	localCursor	Cursor
    //   7	119	3	localArrayList	ArrayList
    //   52	9	4	localj	j
    // Exception table:
    //   from	to	target	type
    //   34	54	69	android/database/sqlite/SQLiteDatabaseCorruptException
    //   59	66	69	android/database/sqlite/SQLiteDatabaseCorruptException
    //   34	54	98	java/lang/IllegalStateException
    //   59	66	98	java/lang/IllegalStateException
    //   34	54	127	finally
    //   59	66	127	finally
    //   70	82	127	finally
    //   99	119	127	finally
  }
  
  public final ArrayList<j> v(String paramString)
  {
    Log.d("msgstore/getGroupLocationMessages:" + paramString);
    ArrayList localArrayList = new ArrayList();
    this.i.lock();
    Object localObject;
    try
    {
      localObject = Calendar.getInstance();
      ((Calendar)localObject).add(5, -1);
      localObject = this.b.getReadableDatabase().rawQuery(am, new String[] { paramString, Long.toString(((Calendar)localObject).getTimeInMillis()) });
      if (localObject == null) {
        break label174;
      }
      try
      {
        while (((Cursor)localObject).moveToNext())
        {
          localArrayList.add(this.t.a((Cursor)localObject, paramString));
          continue;
          paramString = finally;
        }
      }
      catch (SQLiteDiskIOException paramString)
      {
        a.a.a.a.d.h(this.J);
        throw paramString;
      }
      finally
      {
        ((Cursor)localObject).close();
      }
      Log.i("msgstore/getGroupLocationMessages/size:" + localArrayList.size());
    }
    finally
    {
      this.i.unlock();
    }
    ((Cursor)localObject).close();
    this.i.unlock();
    return localArrayList;
    label174:
    Log.e("msgstore/getGroupLocationMessages/db/cursor is null");
    this.i.unlock();
    return localArrayList;
  }
  
  /* Error */
  final long w(String paramString)
  {
    // Byte code:
    //   0: lconst_1
    //   1: lstore_2
    //   2: aload_0
    //   3: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   6: invokevirtual 419	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   9: aload_0
    //   10: getfield 361	com/whatsapp/data/ad:b	Lcom/whatsapp/data/n;
    //   13: invokevirtual 425	com/whatsapp/data/n:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   16: ldc_w 3687
    //   19: iconst_1
    //   20: anewarray 429	java/lang/String
    //   23: dup
    //   24: iconst_0
    //   25: aload_1
    //   26: aastore
    //   27: invokevirtual 435	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   30: astore_1
    //   31: lload_2
    //   32: lstore 4
    //   34: aload_1
    //   35: ifnull +54 -> 89
    //   38: new 162	java/lang/StringBuilder
    //   41: dup
    //   42: ldc_w 3689
    //   45: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   48: aload_1
    //   49: invokeinterface 3692 1 0
    //   54: invokevirtual 1120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   57: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 474	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   63: aload_1
    //   64: invokeinterface 441 1 0
    //   69: ifeq +11 -> 80
    //   72: aload_1
    //   73: iconst_0
    //   74: invokeinterface 1393 2 0
    //   79: lstore_2
    //   80: aload_1
    //   81: invokeinterface 457 1 0
    //   86: lload_2
    //   87: lstore 4
    //   89: aload_0
    //   90: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   93: invokevirtual 460	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   96: lload 4
    //   98: lreturn
    //   99: astore 6
    //   101: aload_1
    //   102: invokeinterface 457 1 0
    //   107: aload 6
    //   109: athrow
    //   110: astore_1
    //   111: aload_0
    //   112: getfield 373	com/whatsapp/data/ad:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   115: invokevirtual 460	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   118: aload_1
    //   119: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	ad
    //   0	120	1	paramString	String
    //   1	86	2	l1	long
    //   32	65	4	l2	long
    //   99	9	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   38	63	99	finally
    //   63	80	99	finally
    //   9	31	110	finally
    //   80	86	110	finally
    //   101	110	110	finally
  }
  
  public final List<j> x(String paramString)
  {
    a.d.c();
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.b.getWritableDatabase().rawQuery("SELECT key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, raw_data, recipient_count, participant_hash, starred, quoted_row_id, mentioned_jids, multicast_id, edit_version, receipt_server_timestamp, media_enc_hash, _id FROM messages WHERE key_remote_jid=? AND remote_resource=? ORDER BY _id ASC", new String[] { "status@broadcast", paramString });
    if (this.x.a(paramString) == null) {
      return localArrayList;
    }
    long l1 = this.j.b();
    long l2 = this.v.b("status_psa_exipration_time");
    long l3 = this.v.b("status_psa_viewed_time");
    int i1 = 0;
    while (localCursor.moveToNext())
    {
      j localj = this.t.a(localCursor, "status@broadcast");
      if (localj == null) {
        Log.e("msgstore/status-null-message for " + paramString);
      } else if ((localj.s != 15) && (localj.s != 11)) {
        if (localj.n > l1 - 86400000L) {
          localArrayList.add(localj);
        } else if ((e.b(localj.f)) && ((localj.n > l3) || (l1 < l2) || (l2 == 0L))) {
          localArrayList.add(localj);
        } else {
          i1 = 1;
        }
      }
    }
    localCursor.close();
    if (i1 != 0)
    {
      Log.d("msgstore/status-cleanup/ " + paramString);
      o();
    }
    return localArrayList;
  }
  
  static final class a
  {
    final boolean a;
    final boolean b;
    final boolean c;
    final boolean d;
    
    a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    {
      this.a = paramBoolean1;
      this.b = paramBoolean2;
      this.d = paramBoolean3;
      this.c = paramBoolean4;
    }
    
    public final String toString()
    {
      return "AddResult{wasSuccess=" + this.a + ", chatAdded=" + this.b + ", isDuplicate=" + this.c + ", chatUnarchived=" + this.d + '}';
    }
  }
  
  @SuppressLint({"HandlerLeak"})
  public final class b
    extends Handler
  {
    private b(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message arg1)
    {
      Object localObject1;
      Object localObject3;
      int i;
      switch (???.what)
      {
      case 3: 
      case 4: 
      case 7: 
      case 8: 
      case 9: 
      default: 
        super.handleMessage(???);
      case 1: 
      case 2: 
      case 11: 
      case 5: 
      case 13: 
        do
        {
          do
          {
            do
            {
              return;
              ad.a(ad.this, (j)???.obj, ???.arg1);
              return;
              localObject1 = (j)???.obj;
            } while (!ad.b(ad.this, (j)localObject1, ???.arg1));
            Message.obtain(ad.a(ad.this).d, 2, ???.arg1, ???.arg2, localObject1).sendToTarget();
            return;
            ??? = (j)???.obj;
            localObject1 = ad.a(ad.this, ???);
            localObject3 = ad.a(ad.this).d;
            if (localObject1 == null)
            {
              i = 0;
              if (localObject1 != null) {
                break label215;
              }
            }
            for (;;)
            {
              Message.obtain((Handler)localObject3, 10, i, 0, ???).sendToTarget();
              return;
              i = 1;
              break;
              ??? = (Message)localObject1;
            }
            ??? = (String)???.obj;
            Message.obtain(ad.a(ad.this).e, 1, ???).sendToTarget();
          } while (!ad.a(ad.this, ???));
          Message.obtain(ad.a(ad.this).e, 2, ???).sendToTarget();
          return;
          ??? = (String)???.obj;
          Message.obtain(ad.a(ad.this).e, 1, ???).sendToTarget();
        } while (!ad.b(ad.this, ???));
        Message.obtain(ad.a(ad.this).e, 2, ???).sendToTarget();
        return;
      case 6: 
        ??? = (String)???.obj;
        Message.obtain(ad.a(ad.this).e, 1, ???).sendToTarget();
        ad.this.m(???);
        Message.obtain(ad.a(ad.this).e, 2, ???).sendToTarget();
        return;
      case 10: 
        ??? = (ad.g)???.obj;
        ad.a(ad.this, ???.a, ???.b, ???.c);
        return;
      case 12: 
        label215:
        Message.obtain(ad.a(ad.this).c, 7).sendToTarget();
        localObject3 = w.a();
        localObject1 = ad.this;
      }
      for (;;)
      {
        Cursor localCursor;
        Map localMap;
        long l;
        int k;
        int j;
        Object localObject5;
        synchronized (((ad)localObject1).F)
        {
          ((ad)localObject1).i.lock();
        }
        if (???.arg2 != 0) {}
        for (boolean bool = true;; bool = false)
        {
          ad.a(ad.this, ???.arg1, (j)???.obj, bool);
          return;
        }
      }
    }
  }
  
  public static enum c
  {
    private c() {}
  }
  
  public static final class d
  {
    public long a = 1L;
    j b;
    public long c;
    long d;
    public boolean e;
    long f;
    int g;
    public double h;
    int i;
    public int j;
    public int k;
    String l;
    long m = 1L;
    int n;
    int o;
    int p;
    public long q = 1L;
    
    public final void a()
    {
      this.b = null;
      this.a = 1L;
      this.q = 1L;
      this.c = 1L;
      this.d = 1L;
      this.m = 1L;
      a(0, 0, 0);
    }
    
    final void a(ContentValues paramContentValues)
    {
      try
      {
        paramContentValues.put("unseen_message_count", Integer.valueOf(this.n));
        paramContentValues.put("unseen_missed_calls_count", Integer.valueOf(this.o));
        paramContentValues.put("unseen_row_count", Integer.valueOf(this.p));
        return;
      }
      finally
      {
        paramContentValues = finally;
        throw paramContentValues;
      }
    }
    
    /* Error */
    final void a(boolean paramBoolean1, boolean paramBoolean2, ContentValues paramContentValues)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: iload_1
      //   3: ifeq +28 -> 31
      //   6: aload_0
      //   7: getfield 54	com/whatsapp/data/ad$d:n	I
      //   10: ifge +134 -> 144
      //   13: aload_0
      //   14: iconst_1
      //   15: putfield 54	com/whatsapp/data/ad$d:n	I
      //   18: aload_3
      //   19: ldc 52
      //   21: aload_0
      //   22: getfield 54	com/whatsapp/data/ad$d:n	I
      //   25: invokestatic 60	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   28: invokevirtual 66	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
      //   31: iload_2
      //   32: ifeq +26 -> 58
      //   35: aload_0
      //   36: aload_0
      //   37: getfield 70	com/whatsapp/data/ad$d:o	I
      //   40: iconst_1
      //   41: iadd
      //   42: putfield 70	com/whatsapp/data/ad$d:o	I
      //   45: aload_3
      //   46: ldc 68
      //   48: aload_0
      //   49: getfield 70	com/whatsapp/data/ad$d:o	I
      //   52: invokestatic 60	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   55: invokevirtual 66	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
      //   58: aload_0
      //   59: getfield 54	com/whatsapp/data/ad$d:n	I
      //   62: ifgt +10 -> 72
      //   65: aload_0
      //   66: getfield 70	com/whatsapp/data/ad$d:o	I
      //   69: ifle +26 -> 95
      //   72: aload_0
      //   73: aload_0
      //   74: getfield 74	com/whatsapp/data/ad$d:p	I
      //   77: iconst_1
      //   78: iadd
      //   79: putfield 74	com/whatsapp/data/ad$d:p	I
      //   82: aload_3
      //   83: ldc 72
      //   85: aload_0
      //   86: getfield 74	com/whatsapp/data/ad$d:p	I
      //   89: invokestatic 60	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   92: invokevirtual 66	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
      //   95: new 77	java/lang/StringBuilder
      //   98: dup
      //   99: ldc 79
      //   101: invokespecial 82	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   104: aload_0
      //   105: getfield 74	com/whatsapp/data/ad$d:p	I
      //   108: invokevirtual 86	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   111: ldc 88
      //   113: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   116: aload_0
      //   117: getfield 54	com/whatsapp/data/ad$d:n	I
      //   120: invokevirtual 86	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   123: ldc 88
      //   125: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   128: aload_0
      //   129: getfield 70	com/whatsapp/data/ad$d:o	I
      //   132: invokevirtual 86	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   135: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   138: invokestatic 99	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
      //   141: aload_0
      //   142: monitorexit
      //   143: return
      //   144: aload_0
      //   145: aload_0
      //   146: getfield 54	com/whatsapp/data/ad$d:n	I
      //   149: iconst_1
      //   150: iadd
      //   151: putfield 54	com/whatsapp/data/ad$d:n	I
      //   154: goto -136 -> 18
      //   157: astore_3
      //   158: aload_0
      //   159: monitorexit
      //   160: aload_3
      //   161: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	162	0	this	d
      //   0	162	1	paramBoolean1	boolean
      //   0	162	2	paramBoolean2	boolean
      //   0	162	3	paramContentValues	ContentValues
      // Exception table:
      //   from	to	target	type
      //   6	18	157	finally
      //   18	31	157	finally
      //   35	58	157	finally
      //   58	72	157	finally
      //   72	95	157	finally
      //   95	141	157	finally
      //   144	154	157	finally
    }
    
    /* Error */
    public final boolean a(int paramInt1, int paramInt2, int paramInt3)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 54	com/whatsapp/data/ad$d:n	I
      //   6: iload_1
      //   7: if_icmpne +31 -> 38
      //   10: aload_0
      //   11: getfield 70	com/whatsapp/data/ad$d:o	I
      //   14: iload_2
      //   15: if_icmpne +23 -> 38
      //   18: aload_0
      //   19: getfield 74	com/whatsapp/data/ad$d:p	I
      //   22: istore 4
      //   24: iload 4
      //   26: iload_3
      //   27: if_icmpne +11 -> 38
      //   30: iconst_0
      //   31: istore 5
      //   33: aload_0
      //   34: monitorexit
      //   35: iload 5
      //   37: ireturn
      //   38: aload_0
      //   39: iload_1
      //   40: putfield 54	com/whatsapp/data/ad$d:n	I
      //   43: aload_0
      //   44: iload_2
      //   45: putfield 70	com/whatsapp/data/ad$d:o	I
      //   48: aload_0
      //   49: iload_3
      //   50: putfield 74	com/whatsapp/data/ad$d:p	I
      //   53: iconst_1
      //   54: istore 5
      //   56: goto -23 -> 33
      //   59: astore 6
      //   61: aload_0
      //   62: monitorexit
      //   63: aload 6
      //   65: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	66	0	this	d
      //   0	66	1	paramInt1	int
      //   0	66	2	paramInt2	int
      //   0	66	3	paramInt3	int
      //   22	6	4	i1	int
      //   31	24	5	bool	boolean
      //   59	5	6	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	24	59	finally
      //   38	53	59	finally
    }
    
    public final String b()
    {
      try
      {
        String str = this.p + "/" + this.n + "/" + this.o;
        return str;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    final ad.o c()
    {
      try
      {
        ad.o localo = new ad.o(this.n, this.o, this.p);
        return localo;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
  }
  
  public static final class e
  {
    public long a;
    public Cursor b;
    
    public e(long paramLong, Cursor paramCursor)
    {
      this.a = paramLong;
      this.b = paramCursor;
    }
  }
  
  static final class f
    extends RuntimeException
  {
    f(String paramString)
    {
      super();
    }
  }
  
  public static final class g
  {
    public String a;
    public String b;
    public Long c;
  }
  
  static final class h
  {
    int a;
    HashMap<String, Integer> b;
    ArrayList<String> c;
  }
  
  public static final class i
  {
    public long a;
    public long b;
    public long c;
    public long d;
    
    public final int a()
    {
      if (this.d > 0L) {
        return 8;
      }
      if (this.c > 0L) {
        return 13;
      }
      if (this.b > 0L) {
        return 5;
      }
      return 4;
    }
    
    public final long a(int paramInt)
    {
      switch (paramInt)
      {
      }
      do
      {
        return 0L;
        if (this.b > 0L) {
          return this.b;
        }
        if (this.c > 0L) {
          return this.c;
        }
      } while (this.d <= 0L);
      return this.d;
    }
  }
  
  public static abstract interface j
  {
    public abstract boolean a();
  }
  
  static abstract interface k
  {
    public abstract void a(j paramj);
  }
  
  public static final class l
  {
    public final MediaView.6 a;
    public final boolean b;
    public final j c;
    
    public l(MediaView.6 param6, boolean paramBoolean, j paramj)
    {
      this.a = param6;
      this.b = paramBoolean;
      this.c = paramj;
    }
  }
  
  public static final class m
  {
    public String a;
    public Long b;
  }
  
  public static final class n
  {
    public final String a;
    public long b = 1L;
    public j c;
    long d;
    long e;
    long f;
    long g;
    public long h;
    public int i;
    public int j;
    private final ant k;
    
    n(ant paramant, n paramn)
    {
      this(paramant, paramn.a, paramn.b, paramn.d, paramn.e, paramn.f, paramn.g, paramn.h, paramn.i, paramn.j);
      this.c = paramn.c;
    }
    
    n(ant paramant, j paramj)
    {
      this(paramant, paramj.f, paramj.Q, paramj.Q - 1L, paramj.Q - 1L, paramj.Q, paramj.Q, paramj.n, 0, 0);
      this.c = paramj;
      this.j += 1;
      if (paramj.e.b) {}
      for (this.i = 0;; this.i += 1)
      {
        Log.d("msgstore/status-create/ " + ad.f(this.c) + " unseen:" + this.i + " total:" + this.j);
        return;
      }
    }
    
    public n(ant paramant, String paramString, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, int paramInt1, int paramInt2)
    {
      this.k = paramant;
      this.a = paramString;
      this.b = paramLong1;
      this.d = paramLong2;
      this.e = paramLong3;
      this.f = paramLong4;
      this.g = Math.max(paramLong5, paramLong4);
      this.h = paramLong6;
      this.i = paramInt1;
      this.j = paramInt2;
    }
    
    public final n a()
    {
      try
      {
        n localn = new n(this.k, this);
        return localn;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    /* Error */
    final n a(j paramj)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: aload_0
      //   4: getfield 43	com/whatsapp/data/ad$n:j	I
      //   7: iconst_1
      //   8: isub
      //   9: putfield 43	com/whatsapp/data/ad$n:j	I
      //   12: aload_1
      //   13: getfield 57	com/whatsapp/protocol/j:Q	J
      //   16: aload_0
      //   17: getfield 31	com/whatsapp/data/ad$n:d	J
      //   20: lcmp
      //   21: ifle +13 -> 34
      //   24: aload_0
      //   25: aload_0
      //   26: getfield 41	com/whatsapp/data/ad$n:i	I
      //   29: iconst_1
      //   30: isub
      //   31: putfield 41	com/whatsapp/data/ad$n:i	I
      //   34: new 69	java/lang/StringBuilder
      //   37: dup
      //   38: ldc 113
      //   40: invokespecial 74	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   43: aload_1
      //   44: invokestatic 77	com/whatsapp/data/ad:f	(Lcom/whatsapp/protocol/j;)Ljava/lang/String;
      //   47: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   50: ldc 83
      //   52: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   55: aload_0
      //   56: getfield 41	com/whatsapp/data/ad$n:i	I
      //   59: invokevirtual 86	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   62: ldc 88
      //   64: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   67: aload_0
      //   68: getfield 43	com/whatsapp/data/ad$n:j	I
      //   71: invokevirtual 86	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   74: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   77: invokestatic 96	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
      //   80: aload_0
      //   81: getfield 43	com/whatsapp/data/ad$n:j	I
      //   84: istore_2
      //   85: iload_2
      //   86: ifgt +9 -> 95
      //   89: aconst_null
      //   90: astore_1
      //   91: aload_0
      //   92: monitorexit
      //   93: aload_1
      //   94: areturn
      //   95: aload_0
      //   96: invokevirtual 115	com/whatsapp/data/ad$n:a	()Lcom/whatsapp/data/ad$n;
      //   99: astore_1
      //   100: goto -9 -> 91
      //   103: astore_1
      //   104: aload_0
      //   105: monitorexit
      //   106: aload_1
      //   107: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	108	0	this	n
      //   0	108	1	paramj	j
      //   84	2	2	m	int
      // Exception table:
      //   from	to	target	type
      //   2	34	103	finally
      //   34	85	103	finally
      //   95	100	103	finally
    }
    
    final n a(j paramj1, j paramj2, j paramj3, boolean paramBoolean)
    {
      long l2 = 1L;
      for (;;)
      {
        long l1;
        try
        {
          l1 = paramj1.Q;
          long l3 = this.d;
          if (l1 <= l3)
          {
            paramj1 = null;
            return paramj1;
          }
          if (paramBoolean) {
            this.e = paramj1.Q;
          }
          this.d = paramj1.Q;
          if (this.i <= 0) {
            break label169;
          }
          this.i -= 1;
        }
        finally {}
        this.f = l1;
        if (paramj3 == null)
        {
          l1 = l2;
          this.g = l1;
          Log.d("msgstore/status-seen/ " + ad.f(paramj1) + " unseen:" + this.i + " total:" + this.j);
          paramj1 = a();
          continue;
          l1 = paramj2.Q;
        }
        else
        {
          l1 = paramj3.Q;
          continue;
          label169:
          if (paramj2 == null) {
            l1 = 1L;
          }
        }
      }
    }
    
    /* Error */
    final n b(j paramj)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 43	com/whatsapp/data/ad$n:j	I
      //   6: iconst_1
      //   7: if_icmpgt +36 -> 43
      //   10: new 69	java/lang/StringBuilder
      //   13: dup
      //   14: ldc 120
      //   16: invokespecial 74	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   19: aload_1
      //   20: invokestatic 77	com/whatsapp/data/ad:f	(Lcom/whatsapp/protocol/j;)Ljava/lang/String;
      //   23: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   26: ldc 122
      //   28: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   31: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   34: invokestatic 96	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
      //   37: aconst_null
      //   38: astore_1
      //   39: aload_0
      //   40: monitorexit
      //   41: aload_1
      //   42: areturn
      //   43: aload_0
      //   44: getfield 27	com/whatsapp/data/ad$n:a	Ljava/lang/String;
      //   47: invokestatic 128	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   50: ifeq +73 -> 123
      //   53: aload_1
      //   54: getfield 57	com/whatsapp/protocol/j:Q	J
      //   57: aload_0
      //   58: getfield 29	com/whatsapp/data/ad$n:b	J
      //   61: lcmp
      //   62: ifne +179 -> 241
      //   65: aload_0
      //   66: ldc2_w 129
      //   69: putfield 29	com/whatsapp/data/ad$n:b	J
      //   72: new 69	java/lang/StringBuilder
      //   75: dup
      //   76: ldc -124
      //   78: invokespecial 74	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   81: aload_1
      //   82: invokestatic 77	com/whatsapp/data/ad:f	(Lcom/whatsapp/protocol/j;)Ljava/lang/String;
      //   85: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   88: ldc 83
      //   90: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   93: aload_0
      //   94: getfield 41	com/whatsapp/data/ad$n:i	I
      //   97: invokevirtual 86	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   100: ldc 88
      //   102: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   105: aload_0
      //   106: getfield 43	com/whatsapp/data/ad$n:j	I
      //   109: invokevirtual 86	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   112: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   115: invokestatic 96	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
      //   118: aload_0
      //   119: astore_1
      //   120: goto -81 -> 39
      //   123: aload_1
      //   124: getfield 57	com/whatsapp/protocol/j:Q	J
      //   127: aload_0
      //   128: getfield 31	com/whatsapp/data/ad$n:d	J
      //   131: lcmp
      //   132: ifeq +51 -> 183
      //   135: aload_1
      //   136: getfield 57	com/whatsapp/protocol/j:Q	J
      //   139: aload_0
      //   140: getfield 35	com/whatsapp/data/ad$n:f	J
      //   143: lcmp
      //   144: iflt +15 -> 159
      //   147: aload_1
      //   148: getfield 57	com/whatsapp/protocol/j:Q	J
      //   151: aload_0
      //   152: getfield 37	com/whatsapp/data/ad$n:g	J
      //   155: lcmp
      //   156: ifle +27 -> 183
      //   159: aload_1
      //   160: getfield 57	com/whatsapp/protocol/j:Q	J
      //   163: aload_0
      //   164: getfield 33	com/whatsapp/data/ad$n:e	J
      //   167: lcmp
      //   168: ifeq +15 -> 183
      //   171: aload_1
      //   172: getfield 57	com/whatsapp/protocol/j:Q	J
      //   175: aload_0
      //   176: getfield 29	com/whatsapp/data/ad$n:b	J
      //   179: lcmp
      //   180: ifne +61 -> 241
      //   183: aload_0
      //   184: ldc2_w 129
      //   187: putfield 29	com/whatsapp/data/ad$n:b	J
      //   190: new 69	java/lang/StringBuilder
      //   193: dup
      //   194: ldc -124
      //   196: invokespecial 74	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   199: aload_1
      //   200: invokestatic 77	com/whatsapp/data/ad:f	(Lcom/whatsapp/protocol/j;)Ljava/lang/String;
      //   203: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   206: ldc 83
      //   208: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   211: aload_0
      //   212: getfield 41	com/whatsapp/data/ad$n:i	I
      //   215: invokevirtual 86	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   218: ldc 88
      //   220: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   223: aload_0
      //   224: getfield 43	com/whatsapp/data/ad$n:j	I
      //   227: invokevirtual 86	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   230: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   233: invokestatic 96	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
      //   236: aload_0
      //   237: astore_1
      //   238: goto -199 -> 39
      //   241: aload_0
      //   242: aload_0
      //   243: getfield 43	com/whatsapp/data/ad$n:j	I
      //   246: iconst_1
      //   247: isub
      //   248: putfield 43	com/whatsapp/data/ad$n:j	I
      //   251: aload_1
      //   252: getfield 57	com/whatsapp/protocol/j:Q	J
      //   255: aload_0
      //   256: getfield 31	com/whatsapp/data/ad$n:d	J
      //   259: lcmp
      //   260: ifle +20 -> 280
      //   263: aload_0
      //   264: getfield 41	com/whatsapp/data/ad$n:i	I
      //   267: ifle +13 -> 280
      //   270: aload_0
      //   271: aload_0
      //   272: getfield 41	com/whatsapp/data/ad$n:i	I
      //   275: iconst_1
      //   276: isub
      //   277: putfield 41	com/whatsapp/data/ad$n:i	I
      //   280: new 69	java/lang/StringBuilder
      //   283: dup
      //   284: ldc 120
      //   286: invokespecial 74	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   289: aload_1
      //   290: invokestatic 77	com/whatsapp/data/ad:f	(Lcom/whatsapp/protocol/j;)Ljava/lang/String;
      //   293: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   296: ldc 83
      //   298: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   301: aload_0
      //   302: getfield 41	com/whatsapp/data/ad$n:i	I
      //   305: invokevirtual 86	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   308: ldc 88
      //   310: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   313: aload_0
      //   314: getfield 43	com/whatsapp/data/ad$n:j	I
      //   317: invokevirtual 86	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   320: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   323: invokestatic 96	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
      //   326: aload_0
      //   327: invokevirtual 115	com/whatsapp/data/ad$n:a	()Lcom/whatsapp/data/ad$n;
      //   330: astore_1
      //   331: goto -292 -> 39
      //   334: astore_1
      //   335: aload_0
      //   336: monitorexit
      //   337: aload_1
      //   338: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	339	0	this	n
      //   0	339	1	paramj	j
      // Exception table:
      //   from	to	target	type
      //   2	37	334	finally
      //   43	118	334	finally
      //   123	159	334	finally
      //   159	183	334	finally
      //   183	236	334	finally
      //   241	280	334	finally
      //   280	331	334	finally
    }
    
    /* Error */
    final boolean b()
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_2
      //   2: aload_0
      //   3: monitorenter
      //   4: aload_0
      //   5: getfield 43	com/whatsapp/data/ad$n:j	I
      //   8: iconst_1
      //   9: if_icmpne +17 -> 26
      //   12: aload_0
      //   13: getfield 41	com/whatsapp/data/ad$n:i	I
      //   16: istore_1
      //   17: iload_1
      //   18: iconst_1
      //   19: if_icmpne +7 -> 26
      //   22: aload_0
      //   23: monitorexit
      //   24: iload_2
      //   25: ireturn
      //   26: iconst_0
      //   27: istore_2
      //   28: goto -6 -> 22
      //   31: astore_3
      //   32: aload_0
      //   33: monitorexit
      //   34: aload_3
      //   35: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	36	0	this	n
      //   16	4	1	m	int
      //   1	27	2	bool	boolean
      //   31	4	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   4	17	31	finally
    }
    
    /* Error */
    final n c(j paramj)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: aload_1
      //   4: putfield 48	com/whatsapp/data/ad$n:c	Lcom/whatsapp/protocol/j;
      //   7: aload_0
      //   8: aload_1
      //   9: getfield 57	com/whatsapp/protocol/j:Q	J
      //   12: putfield 29	com/whatsapp/data/ad$n:b	J
      //   15: aload_0
      //   16: aload_1
      //   17: getfield 59	com/whatsapp/protocol/j:n	J
      //   20: putfield 39	com/whatsapp/data/ad$n:h	J
      //   23: aload_0
      //   24: aload_0
      //   25: getfield 43	com/whatsapp/data/ad$n:j	I
      //   28: iconst_1
      //   29: iadd
      //   30: putfield 43	com/whatsapp/data/ad$n:j	I
      //   33: aload_1
      //   34: getfield 62	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
      //   37: getfield 67	com/whatsapp/protocol/j$b:b	Z
      //   40: ifeq +63 -> 103
      //   43: aload_0
      //   44: iconst_0
      //   45: putfield 41	com/whatsapp/data/ad$n:i	I
      //   48: new 69	java/lang/StringBuilder
      //   51: dup
      //   52: ldc -121
      //   54: invokespecial 74	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   57: aload_1
      //   58: invokestatic 77	com/whatsapp/data/ad:f	(Lcom/whatsapp/protocol/j;)Ljava/lang/String;
      //   61: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   64: ldc 83
      //   66: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   69: aload_0
      //   70: getfield 41	com/whatsapp/data/ad$n:i	I
      //   73: invokevirtual 86	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   76: ldc 88
      //   78: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   81: aload_0
      //   82: getfield 43	com/whatsapp/data/ad$n:j	I
      //   85: invokevirtual 86	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   88: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   91: invokestatic 96	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
      //   94: aload_0
      //   95: invokevirtual 115	com/whatsapp/data/ad$n:a	()Lcom/whatsapp/data/ad$n;
      //   98: astore_1
      //   99: aload_0
      //   100: monitorexit
      //   101: aload_1
      //   102: areturn
      //   103: aload_0
      //   104: aload_0
      //   105: getfield 41	com/whatsapp/data/ad$n:i	I
      //   108: iconst_1
      //   109: iadd
      //   110: putfield 41	com/whatsapp/data/ad$n:i	I
      //   113: aload_0
      //   114: getfield 41	com/whatsapp/data/ad$n:i	I
      //   117: iconst_1
      //   118: if_icmpne +11 -> 129
      //   121: aload_0
      //   122: aload_0
      //   123: getfield 29	com/whatsapp/data/ad$n:b	J
      //   126: putfield 35	com/whatsapp/data/ad$n:f	J
      //   129: aload_0
      //   130: getfield 41	com/whatsapp/data/ad$n:i	I
      //   133: iconst_2
      //   134: if_icmpgt -86 -> 48
      //   137: aload_0
      //   138: aload_0
      //   139: getfield 29	com/whatsapp/data/ad$n:b	J
      //   142: putfield 37	com/whatsapp/data/ad$n:g	J
      //   145: goto -97 -> 48
      //   148: astore_1
      //   149: aload_0
      //   150: monitorexit
      //   151: aload_1
      //   152: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	153	0	this	n
      //   0	153	1	paramj	j
      // Exception table:
      //   from	to	target	type
      //   2	48	148	finally
      //   48	99	148	finally
      //   103	129	148	finally
      //   129	145	148	finally
    }
    
    /* Error */
    public final boolean c()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 27	com/whatsapp/data/ad$n:a	Ljava/lang/String;
      //   6: invokestatic 140	com/whatsapp/data/e:b	(Ljava/lang/String;)Z
      //   9: ifne +34 -> 43
      //   12: aload_0
      //   13: getfield 101	com/whatsapp/data/ad$n:k	Lcom/whatsapp/ant;
      //   16: invokevirtual 145	com/whatsapp/ant:b	()J
      //   19: lstore_1
      //   20: aload_0
      //   21: getfield 39	com/whatsapp/data/ad$n:h	J
      //   24: lstore_3
      //   25: lload_1
      //   26: lload_3
      //   27: lsub
      //   28: ldc2_w 146
      //   31: lcmp
      //   32: ifle +11 -> 43
      //   35: iconst_1
      //   36: istore 5
      //   38: aload_0
      //   39: monitorexit
      //   40: iload 5
      //   42: ireturn
      //   43: iconst_0
      //   44: istore 5
      //   46: goto -8 -> 38
      //   49: astore 6
      //   51: aload_0
      //   52: monitorexit
      //   53: aload 6
      //   55: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	56	0	this	n
      //   19	7	1	l1	long
      //   24	3	3	l2	long
      //   36	9	5	bool	boolean
      //   49	5	6	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	25	49	finally
    }
    
    /* Error */
    public final boolean d(j paramj)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_1
      //   3: getfield 57	com/whatsapp/protocol/j:Q	J
      //   6: lstore_2
      //   7: aload_0
      //   8: getfield 31	com/whatsapp/data/ad$n:d	J
      //   11: lstore 4
      //   13: lload_2
      //   14: lload 4
      //   16: lcmp
      //   17: ifle +11 -> 28
      //   20: iconst_1
      //   21: istore 6
      //   23: aload_0
      //   24: monitorexit
      //   25: iload 6
      //   27: ireturn
      //   28: iconst_0
      //   29: istore 6
      //   31: goto -8 -> 23
      //   34: astore_1
      //   35: aload_0
      //   36: monitorexit
      //   37: aload_1
      //   38: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	39	0	this	n
      //   0	39	1	paramj	j
      //   6	8	2	l1	long
      //   11	4	4	l2	long
      //   21	9	6	bool	boolean
      // Exception table:
      //   from	to	target	type
      //   2	13	34	finally
    }
    
    /* Error */
    public final boolean e(j paramj)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_1
      //   3: getfield 57	com/whatsapp/protocol/j:Q	J
      //   6: lstore_2
      //   7: aload_0
      //   8: getfield 37	com/whatsapp/data/ad$n:g	J
      //   11: lstore 4
      //   13: lload_2
      //   14: lload 4
      //   16: lcmp
      //   17: ifgt +11 -> 28
      //   20: iconst_1
      //   21: istore 6
      //   23: aload_0
      //   24: monitorexit
      //   25: iload 6
      //   27: ireturn
      //   28: iconst_0
      //   29: istore 6
      //   31: goto -8 -> 23
      //   34: astore_1
      //   35: aload_0
      //   36: monitorexit
      //   37: aload_1
      //   38: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	39	0	this	n
      //   0	39	1	paramj	j
      //   6	8	2	l1	long
      //   11	4	4	l2	long
      //   21	9	6	bool	boolean
      // Exception table:
      //   from	to	target	type
      //   2	13	34	finally
    }
    
    public final String toString()
    {
      try
      {
        String str = "StausInfo[jid=" + this.a + ", msgid=" + this.b + ", lastread=" + this.d + ", lastsent=" + this.e + ", firstUnread=" + this.f + ", autoDownloadLimit=" + this.g + ", ts=" + this.h + ", unreadcount=" + this.i + ", total=" + this.j + " ]";
        return str;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
  }
  
  public static final class o
  {
    public int a;
    public int b;
    public int c;
    
    o(int paramInt1, int paramInt2, int paramInt3)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/data/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */