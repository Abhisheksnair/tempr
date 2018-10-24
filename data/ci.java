package com.whatsapp.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.qz.a;
import com.whatsapp.rf;
import com.whatsapp.rg;
import com.whatsapp.rh;
import com.whatsapp.util.Log;
import com.whatsapp.va;
import com.whatsapp.va.a;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

public class ci
{
  private static volatile ci d;
  public final va a;
  public final n b;
  public final ReentrantReadWriteLock.ReadLock c;
  
  private ci(va paramva, ch paramch)
  {
    this.a = paramva;
    this.b = paramch.a;
    this.c = paramch.b.readLock();
  }
  
  public static ci a()
  {
    if (d == null) {}
    try
    {
      if (d == null) {
        d = new ci(va.a(), ch.a());
      }
      return d;
    }
    finally {}
  }
  
  private Set<String> a(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    Set localSet = b(paramSQLiteDatabase, paramString1);
    if (TextUtils.equals(rg.a(localSet), paramString2)) {
      paramSQLiteDatabase = localSet;
    }
    for (;;)
    {
      return paramSQLiteDatabase;
      Cursor localCursor = paramSQLiteDatabase.query("group_participants_history", new String[] { "jid", "action", "old_phash", "new_phash" }, "gjid = ?", new String[] { paramString1 }, null, null, "timestamp DESC");
      try
      {
        for (;;)
        {
          if (localCursor.moveToNext())
          {
            paramString1 = localCursor.getString(0);
            int i = localCursor.getInt(1);
            paramSQLiteDatabase = localCursor.getString(2);
            boolean bool = TextUtils.equals(localCursor.getString(3), paramString2);
            if (bool)
            {
              if (localCursor != null) {
                localCursor.close();
              }
              return localSet;
            }
            switch (i)
            {
            default: 
              label176:
              i = 0;
            }
            for (;;)
            {
              if (i != 0) {
                break label288;
              }
              paramSQLiteDatabase = (SQLiteDatabase)localObject2;
              if (localCursor == null) {
                break;
              }
              localCursor.close();
              return null;
              localSet.removeAll(Arrays.asList(TextUtils.split(paramString1, ",")));
              i = 1;
              continue;
              localSet.addAll(Arrays.asList(TextUtils.split(paramString1, ",")));
              i = 1;
              continue;
              paramString1 = TextUtils.split(paramString1, ",");
              if (paramString1.length != 2) {
                break label176;
              }
              localSet.remove(paramString1[1]);
              localSet.add(paramString1[0]);
              i = 1;
            }
            label288:
            if (!TextUtils.equals(paramSQLiteDatabase, paramString2))
            {
              bool = TextUtils.equals(rg.a(localSet), paramString2);
              if (!bool) {}
            }
            else
            {
              if (localCursor != null) {
                localCursor.close();
              }
              return localSet;
            }
          }
        }
        paramSQLiteDatabase = (SQLiteDatabase)localObject2;
        if (localCursor == null) {
          continue;
        }
        localCursor.close();
        return null;
      }
      catch (Throwable paramSQLiteDatabase)
      {
        try
        {
          throw paramSQLiteDatabase;
        }
        finally
        {
          paramString2 = paramSQLiteDatabase;
        }
        if ((localCursor == null) || (paramString2 != null)) {}
        try
        {
          localCursor.close();
          for (;;)
          {
            throw paramSQLiteDatabase;
            localCursor.close();
          }
        }
        catch (Throwable paramString1)
        {
          for (;;) {}
        }
      }
      finally
      {
        for (;;)
        {
          paramString2 = (String)localObject1;
        }
      }
    }
  }
  
  public final String a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = paramSQLiteDatabase;
    if (paramSQLiteDatabase == null) {
      localSQLiteDatabase = this.b.getWritableDatabase();
    }
    return rg.a(b(localSQLiteDatabase, paramString));
  }
  
  public final Map<String, rf> a(String paramString)
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    this.c.lock();
    for (;;)
    {
      Cursor localCursor;
      int i;
      try
      {
        localCursor = this.b.getReadableDatabase().rawQuery("SELECT jid, admin, pending, sent_sender_key FROM group_participants WHERE gjid=?", new String[] { paramString });
        if (localCursor == null) {
          break label209;
        }
        try
        {
          if (!localCursor.moveToNext()) {
            break label202;
          }
          paramString = localCursor.getString(0);
          if (!TextUtils.isEmpty(paramString)) {
            break label219;
          }
          paramString = this.a.c().t;
          if (!localCursor.isNull(3)) {
            break label173;
          }
          i = 0;
          if (localCursor.getInt(1) != 1) {
            break label185;
          }
          bool1 = true;
          if (localCursor.getInt(2) != 1) {
            break label190;
          }
          bool2 = true;
        }
        finally
        {
          label125:
          localCursor.close();
        }
        paramString = new rf(paramString, bool1, bool2, bool3);
        localConcurrentHashMap.put(paramString.a, paramString);
        continue;
        i = localCursor.getInt(3);
      }
      finally
      {
        this.c.unlock();
      }
      label173:
      continue;
      label185:
      boolean bool1 = false;
      continue;
      label190:
      boolean bool2 = false;
      label202:
      label209:
      label219:
      while (i != 1)
      {
        bool3 = false;
        break label125;
        localCursor.close();
        this.c.unlock();
        return localConcurrentHashMap;
        break;
      }
      boolean bool3 = true;
    }
  }
  
  public final Set<String> a(String paramString1, String paramString2)
  {
    this.c.lock();
    try
    {
      paramString1 = a(this.b.getWritableDatabase(), paramString1, paramString2);
      return paramString1;
    }
    finally
    {
      this.c.unlock();
    }
  }
  
  final void a(SQLiteDatabase paramSQLiteDatabase, j paramj)
  {
    boolean bool;
    if ((paramj.d == 6) && (paramj.e.b))
    {
      bool = this.a.a(paramj.f);
      switch ((int)paramj.t)
      {
      }
    }
    for (;;)
    {
      return;
      if (bool) {}
      for (Object localObject1 = "";; localObject1 = paramj.f)
      {
        localObject3 = new ContentValues(3);
        ((ContentValues)localObject3).put("gjid", paramj.e.a);
        ((ContentValues)localObject3).put("jid", (String)localObject1);
        ((ContentValues)localObject3).put("pending", Boolean.valueOf(false));
        localObject4 = paramj.e.a;
        localObject2 = a(paramSQLiteDatabase, paramj.e.a);
        if (paramSQLiteDatabase.update("group_participants", (ContentValues)localObject3, "gjid=? and jid=?", new String[] { localObject4, localObject1 }) == 0) {
          paramSQLiteDatabase.insert("group_participants", null, (ContentValues)localObject3);
        }
        localObject1 = a(paramSQLiteDatabase, paramj.e.a);
        if (TextUtils.equals((CharSequence)localObject2, (CharSequence)localObject1)) {
          break;
        }
        localObject3 = new ContentValues(6);
        ((ContentValues)localObject3).put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000L));
        ((ContentValues)localObject3).put("gjid", paramj.e.a);
        ((ContentValues)localObject3).put("jid", paramj.f);
        ((ContentValues)localObject3).put("action", Integer.valueOf(1));
        ((ContentValues)localObject3).put("old_phash", (String)localObject2);
        ((ContentValues)localObject3).put("new_phash", (String)localObject1);
        paramSQLiteDatabase.insert("group_participants_history", null, (ContentValues)localObject3);
        return;
      }
      localObject1 = (Iterable)paramj.N;
      Object localObject2 = a(paramSQLiteDatabase, paramj.e.a);
      Object localObject3 = new HashSet();
      Object localObject4 = ((Iterable)localObject1).iterator();
      label447:
      Object localObject5;
      Object localObject6;
      if (((Iterator)localObject4).hasNext())
      {
        localObject1 = (String)((Iterator)localObject4).next();
        if (this.a.a((String)localObject1))
        {
          localObject1 = "";
          localObject5 = new ContentValues(3);
          ((ContentValues)localObject5).put("gjid", paramj.e.a);
          ((ContentValues)localObject5).put("jid", (String)localObject1);
          ((ContentValues)localObject5).put("pending", Boolean.valueOf(false));
          if ((paramj instanceof qz.a))
          {
            localObject6 = (qz.a)paramj;
            if (((qz.a)localObject6).b != null)
            {
              localObject6 = ((qz.a)localObject6).b.a((String)localObject1);
              if ((localObject6 == null) || (!((rf)localObject6).b)) {
                break label613;
              }
            }
          }
        }
        label613:
        for (bool = true;; bool = false)
        {
          ((ContentValues)localObject5).put("admin", Boolean.valueOf(bool));
          if ((paramSQLiteDatabase.update("group_participants", (ContentValues)localObject5, "gjid=? and jid=?", new String[] { paramj.e.a, localObject1 }) != 0) || (paramSQLiteDatabase.insert("group_participants", null, (ContentValues)localObject5) < 0L)) {
            break;
          }
          ((Set)localObject3).add(localObject1);
          break;
          break label447;
        }
      }
      localObject1 = a(paramSQLiteDatabase, paramj.e.a);
      if (!TextUtils.equals((CharSequence)localObject2, (CharSequence)localObject1))
      {
        localObject3 = TextUtils.join(",", (Iterable)localObject3);
        localObject4 = new ContentValues(6);
        ((ContentValues)localObject4).put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000L));
        ((ContentValues)localObject4).put("gjid", paramj.e.a);
        ((ContentValues)localObject4).put("jid", (String)localObject3);
        ((ContentValues)localObject4).put("action", Integer.valueOf(1));
        ((ContentValues)localObject4).put("old_phash", (String)localObject2);
        ((ContentValues)localObject4).put("new_phash", (String)localObject1);
        paramSQLiteDatabase.insert("group_participants_history", null, (ContentValues)localObject4);
        return;
        localObject3 = paramj.e.a;
        if (bool) {}
        for (localObject1 = "";; localObject1 = paramj.f)
        {
          localObject2 = a(paramSQLiteDatabase, paramj.e.a);
          paramSQLiteDatabase.delete("group_participants", "gjid=? and jid=?", new String[] { localObject3, localObject1 });
          localObject1 = a(paramSQLiteDatabase, paramj.e.a);
          if (TextUtils.equals((CharSequence)localObject2, (CharSequence)localObject1)) {
            break;
          }
          localObject3 = new ContentValues();
          ((ContentValues)localObject3).put("sent_sender_key", Boolean.valueOf(false));
          paramSQLiteDatabase.update("group_participants", (ContentValues)localObject3, "gjid=?", new String[] { paramj.e.a });
          localObject3 = new ContentValues(6);
          ((ContentValues)localObject3).put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000L));
          ((ContentValues)localObject3).put("gjid", paramj.e.a);
          ((ContentValues)localObject3).put("jid", paramj.f);
          ((ContentValues)localObject3).put("action", Integer.valueOf(2));
          ((ContentValues)localObject3).put("old_phash", (String)localObject2);
          ((ContentValues)localObject3).put("new_phash", (String)localObject1);
          paramSQLiteDatabase.insert("group_participants_history", null, (ContentValues)localObject3);
          return;
        }
        localObject1 = (Iterable)paramj.N;
        localObject3 = a(paramSQLiteDatabase, paramj.e.a);
        localObject4 = new HashSet();
        localObject5 = ((Iterable)localObject1).iterator();
        label1104:
        while (((Iterator)localObject5).hasNext())
        {
          localObject2 = (String)((Iterator)localObject5).next();
          bool = this.a.a((String)localObject2);
          localObject6 = paramj.e.a;
          if (bool) {}
          for (localObject1 = "";; localObject1 = localObject2)
          {
            if (paramSQLiteDatabase.delete("group_participants", "gjid=? and jid=?", new String[] { localObject6, localObject1 }) <= 0) {
              break label1104;
            }
            ((Set)localObject4).add(localObject2);
            break;
          }
        }
        localObject1 = a(paramSQLiteDatabase, paramj.e.a);
        if (!TextUtils.equals((CharSequence)localObject3, (CharSequence)localObject1))
        {
          localObject2 = new ContentValues();
          ((ContentValues)localObject2).put("sent_sender_key", Boolean.valueOf(false));
          paramSQLiteDatabase.update("group_participants", (ContentValues)localObject2, "gjid=?", new String[] { paramj.e.a });
          localObject2 = TextUtils.join(",", (Iterable)localObject4);
          localObject4 = new ContentValues(6);
          ((ContentValues)localObject4).put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000L));
          ((ContentValues)localObject4).put("gjid", paramj.e.a);
          ((ContentValues)localObject4).put("jid", (String)localObject2);
          ((ContentValues)localObject4).put("action", Integer.valueOf(2));
          ((ContentValues)localObject4).put("old_phash", (String)localObject3);
          ((ContentValues)localObject4).put("new_phash", (String)localObject1);
          paramSQLiteDatabase.insert("group_participants_history", null, (ContentValues)localObject4);
          return;
          localObject3 = ((Iterable)paramj.N).iterator();
          label1292:
          if (((Iterator)localObject3).hasNext())
          {
            localObject2 = (String)((Iterator)localObject3).next();
            localObject1 = localObject2;
            if (this.a.a((String)localObject2)) {
              localObject1 = "";
            }
            localObject2 = new ContentValues(3);
            ((ContentValues)localObject2).put("gjid", paramj.e.a);
            ((ContentValues)localObject2).put("jid", (String)localObject1);
            ((ContentValues)localObject2).put("pending", Boolean.valueOf(false));
            if (paramj.t != 15L) {
              break label1448;
            }
          }
          label1448:
          for (bool = true;; bool = false)
          {
            ((ContentValues)localObject2).put("admin", Boolean.valueOf(bool));
            if (paramSQLiteDatabase.update("group_participants", (ContentValues)localObject2, "gjid=? and jid=?", new String[] { paramj.e.a, localObject1 }) != 0) {
              break label1292;
            }
            paramSQLiteDatabase.insert("group_participants", null, (ContentValues)localObject2);
            break label1292;
            break;
          }
          localObject2 = new ContentValues(3);
          ((ContentValues)localObject2).put("gjid", paramj.e.a);
          ((ContentValues)localObject2).put("jid", paramj.N.toString());
          ((ContentValues)localObject2).put("pending", Boolean.valueOf(false));
          localObject3 = paramj.e.a;
          if (bool) {}
          for (localObject1 = "";; localObject1 = paramj.f)
          {
            localObject4 = a(paramSQLiteDatabase, paramj.e.a);
            if (paramSQLiteDatabase.update("group_participants", (ContentValues)localObject2, "gjid=? and jid=?", new String[] { localObject3, localObject1 }) == 0) {
              paramSQLiteDatabase.insert("group_participants", null, (ContentValues)localObject2);
            }
            localObject1 = a(paramSQLiteDatabase, paramj.e.a);
            if (TextUtils.equals((CharSequence)localObject4, (CharSequence)localObject1)) {
              break;
            }
            localObject2 = new ContentValues(6);
            ((ContentValues)localObject2).put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000L));
            ((ContentValues)localObject2).put("gjid", paramj.e.a);
            ((ContentValues)localObject2).put("jid", paramj.f + ',' + paramj.N);
            ((ContentValues)localObject2).put("action", Integer.valueOf(3));
            ((ContentValues)localObject2).put("old_phash", (String)localObject4);
            ((ContentValues)localObject2).put("new_phash", (String)localObject1);
            paramSQLiteDatabase.insert("group_participants_history", null, (ContentValues)localObject2);
            return;
          }
          localObject3 = ((Iterable)paramj.N).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject2 = (String)((Iterator)localObject3).next();
            localObject1 = localObject2;
            if (this.a.a((String)localObject2)) {
              localObject1 = "";
            }
            localObject2 = new ContentValues(3);
            ((ContentValues)localObject2).put("gjid", paramj.e.a);
            ((ContentValues)localObject2).put("jid", (String)localObject1);
            ((ContentValues)localObject2).put("pending", Boolean.valueOf(true));
            if (paramSQLiteDatabase.update("group_participants", (ContentValues)localObject2, "gjid=? and jid=?", new String[] { paramj.e.a, localObject1 }) == 0) {
              paramSQLiteDatabase.insert("group_participants", null, (ContentValues)localObject2);
            }
          }
          continue;
          paramSQLiteDatabase.delete("group_participants", "gjid=? and jid=?", new String[] { paramj.e.a, "" });
          localObject1 = new ContentValues();
          ((ContentValues)localObject1).put("gjid", paramj.e.a);
          ((ContentValues)localObject1).put("pending", Boolean.valueOf(false));
          ((ContentValues)localObject1).put("admin", Boolean.valueOf(false));
          ((ContentValues)localObject1).put("sent_sender_key", Boolean.valueOf(false));
          if (paramSQLiteDatabase.update("group_participants", (ContentValues)localObject1, "gjid=?", new String[] { paramj.e.a }) == 0)
          {
            paramSQLiteDatabase.insert("group_participants", null, (ContentValues)localObject1);
            return;
            localObject3 = ((Iterable)paramj.N).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject2 = (String)((Iterator)localObject3).next();
              localObject1 = localObject2;
              if (this.a.a((String)localObject2)) {
                localObject1 = "";
              }
              localObject2 = new ContentValues(3);
              ((ContentValues)localObject2).put("gjid", paramj.e.a);
              ((ContentValues)localObject2).put("jid", (String)localObject1);
              ((ContentValues)localObject2).put("pending", Boolean.valueOf(false));
              if (paramSQLiteDatabase.update("group_participants", (ContentValues)localObject2, "gjid=? and jid=?", new String[] { paramj.e.a, localObject1 }) == 0) {
                paramSQLiteDatabase.insert("group_participants", null, (ContentValues)localObject2);
              }
            }
          }
        }
      }
    }
  }
  
  public final void a(rg paramrg)
  {
    Log.i("msgstore/saveGroupParticipants/" + paramrg);
    this.c.lock();
    for (;;)
    {
      SQLiteDatabase localSQLiteDatabase;
      try
      {
        localSQLiteDatabase = this.b.getWritableDatabase();
        localSQLiteDatabase.beginTransaction();
        rf localrf;
        try
        {
          localSQLiteDatabase.delete("group_participants", "gjid=?", new String[] { paramrg.b });
          Iterator localIterator = paramrg.b().iterator();
          if (!localIterator.hasNext()) {
            break label250;
          }
          localrf = (rf)localIterator.next();
          ContentValues localContentValues = new ContentValues();
          localContentValues.put("gjid", paramrg.b);
          if (this.a.a(localrf.a))
          {
            str = "";
            localContentValues.put("jid", str);
            if (!localrf.b) {
              break label276;
            }
            i = 1;
            localContentValues.put("admin", Integer.valueOf(i));
            if (!localrf.c) {
              break label281;
            }
            i = 1;
            localContentValues.put("pending", Integer.valueOf(i));
            localContentValues.put("sent_sender_key", Boolean.valueOf(localrf.d));
            localSQLiteDatabase.insert("group_participants", null, localContentValues);
            continue;
            paramrg = finally;
          }
        }
        finally
        {
          if (localSQLiteDatabase.inTransaction()) {
            localSQLiteDatabase.endTransaction();
          }
        }
        String str = localrf.a;
      }
      finally
      {
        this.c.unlock();
      }
      continue;
      label250:
      localSQLiteDatabase.setTransactionSuccessful();
      if (localSQLiteDatabase.inTransaction()) {
        localSQLiteDatabase.endTransaction();
      }
      this.c.unlock();
      return;
      label276:
      int i = 0;
      continue;
      label281:
      i = 0;
    }
  }
  
  public final void a(rh paramrh, String paramString, Collection<String> paramCollection)
  {
    Log.i("msgstore/markParticipantsAsHavingSenderKey/" + paramString + '/' + paramCollection);
    this.c.lock();
    SQLiteDatabase localSQLiteDatabase;
    try
    {
      localSQLiteDatabase = this.b.getWritableDatabase();
      SQLiteStatement localSQLiteStatement = localSQLiteDatabase.compileStatement("UPDATE group_participants SET sent_sender_key=1 WHERE gjid=? AND jid=?");
      localSQLiteStatement.bindString(1, paramString);
      localSQLiteDatabase.beginTransaction();
      try
      {
        Iterator localIterator = paramCollection.iterator();
        while (localIterator.hasNext())
        {
          localSQLiteStatement.bindString(2, (String)localIterator.next());
          localSQLiteStatement.execute();
          continue;
          paramrh = finally;
        }
      }
      finally
      {
        if (localSQLiteDatabase.inTransaction()) {
          localSQLiteDatabase.endTransaction();
        }
      }
      localSQLiteDatabase.setTransactionSuccessful();
    }
    finally
    {
      this.c.unlock();
    }
    paramrh = paramrh.a(paramString);
    paramString = paramCollection.iterator();
    while (paramString.hasNext())
    {
      paramCollection = paramrh.a((String)paramString.next());
      if (paramCollection != null) {
        paramCollection.d = true;
      }
    }
    if (localSQLiteDatabase.inTransaction()) {
      localSQLiteDatabase.endTransaction();
    }
    this.c.unlock();
  }
  
  /* Error */
  final Set<String> b(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 293	java/util/HashSet
    //   5: dup
    //   6: invokespecial 294	java/util/HashSet:<init>	()V
    //   9: astore 5
    //   11: aload_1
    //   12: ldc -7
    //   14: iconst_1
    //   15: anewarray 71	java/lang/String
    //   18: dup
    //   19: iconst_0
    //   20: ldc 73
    //   22: aastore
    //   23: ldc_w 334
    //   26: iconst_1
    //   27: anewarray 71	java/lang/String
    //   30: dup
    //   31: iconst_0
    //   32: aload_2
    //   33: aastore
    //   34: aconst_null
    //   35: aconst_null
    //   36: aconst_null
    //   37: invokevirtual 89	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   40: astore 4
    //   42: aload 4
    //   44: invokeinterface 95 1 0
    //   49: ifeq +82 -> 131
    //   52: aload 4
    //   54: iconst_0
    //   55: invokeinterface 99 2 0
    //   60: astore_1
    //   61: aload_1
    //   62: invokestatic 165	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   65: ifeq +50 -> 115
    //   68: aload 5
    //   70: aload_0
    //   71: getfield 19	com/whatsapp/data/ci:a	Lcom/whatsapp/va;
    //   74: invokevirtual 168	com/whatsapp/va:c	()Lcom/whatsapp/va$a;
    //   77: getfield 174	com/whatsapp/va$a:t	Ljava/lang/String;
    //   80: invokeinterface 321 2 0
    //   85: pop
    //   86: goto -44 -> 42
    //   89: astore_1
    //   90: aload_1
    //   91: athrow
    //   92: astore_2
    //   93: aload_1
    //   94: astore_3
    //   95: aload_2
    //   96: astore_1
    //   97: aload 4
    //   99: ifnull +14 -> 113
    //   102: aload_3
    //   103: ifnull +43 -> 146
    //   106: aload 4
    //   108: invokeinterface 106 1 0
    //   113: aload_1
    //   114: athrow
    //   115: aload 5
    //   117: aload_1
    //   118: invokeinterface 321 2 0
    //   123: pop
    //   124: goto -82 -> 42
    //   127: astore_1
    //   128: goto -31 -> 97
    //   131: aload 4
    //   133: ifnull +10 -> 143
    //   136: aload 4
    //   138: invokeinterface 106 1 0
    //   143: aload 5
    //   145: areturn
    //   146: aload 4
    //   148: invokeinterface 106 1 0
    //   153: goto -40 -> 113
    //   156: astore_2
    //   157: goto -44 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	ci
    //   0	160	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	160	2	paramString	String
    //   1	102	3	localSQLiteDatabase	SQLiteDatabase
    //   40	107	4	localCursor	Cursor
    //   9	135	5	localHashSet	HashSet
    // Exception table:
    //   from	to	target	type
    //   42	86	89	java/lang/Throwable
    //   115	124	89	java/lang/Throwable
    //   90	92	92	finally
    //   42	86	127	finally
    //   115	124	127	finally
    //   106	113	156	java/lang/Throwable
  }
  
  /* Error */
  public final boolean b()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 36	com/whatsapp/data/ci:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   6: invokevirtual 152	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   9: aload_0
    //   10: getfield 25	com/whatsapp/data/ci:b	Lcom/whatsapp/data/n;
    //   13: invokevirtual 143	com/whatsapp/data/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   16: astore_3
    //   17: new 225	android/content/ContentValues
    //   20: dup
    //   21: iconst_1
    //   22: invokespecial 228	android/content/ContentValues:<init>	(I)V
    //   25: astore 4
    //   27: aload 4
    //   29: ldc_w 332
    //   32: getstatic 416	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   35: invokevirtual 245	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Boolean;)V
    //   38: aload_3
    //   39: ldc -7
    //   41: aload 4
    //   43: aconst_null
    //   44: aconst_null
    //   45: invokevirtual 255	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   48: istore_1
    //   49: iload_1
    //   50: ifle +12 -> 62
    //   53: aload_0
    //   54: getfield 36	com/whatsapp/data/ci:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   57: invokevirtual 192	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   60: iload_2
    //   61: ireturn
    //   62: iconst_0
    //   63: istore_2
    //   64: goto -11 -> 53
    //   67: astore_3
    //   68: aload_0
    //   69: getfield 36	com/whatsapp/data/ci:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   72: invokevirtual 192	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   75: aload_3
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	ci
    //   48	2	1	i	int
    //   1	63	2	bool	boolean
    //   16	23	3	localSQLiteDatabase	SQLiteDatabase
    //   67	9	3	localObject	Object
    //   25	17	4	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   9	49	67	finally
  }
  
  /* Error */
  public final boolean b(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: new 342	java/lang/StringBuilder
    //   5: dup
    //   6: ldc_w 418
    //   9: invokespecial 360	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   12: aload_1
    //   13: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: invokevirtual 354	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   19: invokestatic 365	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   22: aload_0
    //   23: getfield 36	com/whatsapp/data/ci:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   26: invokevirtual 152	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   29: aload_0
    //   30: getfield 25	com/whatsapp/data/ci:b	Lcom/whatsapp/data/n;
    //   33: invokevirtual 143	com/whatsapp/data/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   36: astore 4
    //   38: new 225	android/content/ContentValues
    //   41: dup
    //   42: iconst_1
    //   43: invokespecial 228	android/content/ContentValues:<init>	(I)V
    //   46: astore 5
    //   48: aload 5
    //   50: ldc_w 332
    //   53: getstatic 416	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   56: invokevirtual 245	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Boolean;)V
    //   59: aload 4
    //   61: ldc -7
    //   63: aload 5
    //   65: ldc_w 420
    //   68: iconst_1
    //   69: anewarray 71	java/lang/String
    //   72: dup
    //   73: iconst_0
    //   74: aload_1
    //   75: aastore
    //   76: invokevirtual 255	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   79: istore_2
    //   80: iload_2
    //   81: ifle +12 -> 93
    //   84: aload_0
    //   85: getfield 36	com/whatsapp/data/ci:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   88: invokevirtual 192	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   91: iload_3
    //   92: ireturn
    //   93: iconst_0
    //   94: istore_3
    //   95: goto -11 -> 84
    //   98: astore_1
    //   99: aload_0
    //   100: getfield 36	com/whatsapp/data/ci:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   103: invokevirtual 192	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   106: aload_1
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	ci
    //   0	108	1	paramString	String
    //   79	2	2	i	int
    //   1	94	3	bool	boolean
    //   36	24	4	localSQLiteDatabase	SQLiteDatabase
    //   46	18	5	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   29	80	98	finally
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/data/ci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */