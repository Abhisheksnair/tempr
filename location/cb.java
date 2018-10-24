package com.whatsapp.location;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import com.whatsapp.protocol.ap;
import com.whatsapp.protocol.j.b;
import com.whatsapp.util.Log;
import com.whatsapp.util.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class cb
{
  private volatile b a;
  private final Context b;
  
  public cb(Context paramContext)
  {
    this.b = paramContext;
  }
  
  /* Error */
  private List<c> a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: invokestatic 32	java/lang/System:currentTimeMillis	()J
    //   6: lstore_2
    //   7: new 34	java/util/ArrayList
    //   10: dup
    //   11: invokespecial 35	java/util/ArrayList:<init>	()V
    //   14: astore 6
    //   16: aload_0
    //   17: invokevirtual 38	com/whatsapp/location/cb:a	()Lcom/whatsapp/location/cb$b;
    //   20: invokevirtual 42	com/whatsapp/location/cb$b:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   23: astore 7
    //   25: getstatic 45	com/whatsapp/location/cb$c:a	[Ljava/lang/String;
    //   28: astore 8
    //   30: iload_1
    //   31: ifeq +65 -> 96
    //   34: ldc 47
    //   36: astore 4
    //   38: aload 7
    //   40: ldc 49
    //   42: aload 8
    //   44: ldc 51
    //   46: iconst_1
    //   47: anewarray 53	java/lang/String
    //   50: dup
    //   51: iconst_0
    //   52: aload 4
    //   54: aastore
    //   55: aconst_null
    //   56: aconst_null
    //   57: aconst_null
    //   58: invokevirtual 59	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   61: astore 4
    //   63: aload 4
    //   65: astore 5
    //   67: aload 5
    //   69: ifnonnull +34 -> 103
    //   72: aload 5
    //   74: astore 4
    //   76: ldc 61
    //   78: invokestatic 67	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   81: aload 5
    //   83: ifnull +10 -> 93
    //   86: aload 5
    //   88: invokeinterface 72 1 0
    //   93: aload 6
    //   95: areturn
    //   96: ldc 74
    //   98: astore 4
    //   100: goto -62 -> 38
    //   103: aload 5
    //   105: astore 4
    //   107: aload 5
    //   109: invokeinterface 78 1 0
    //   114: ifeq +75 -> 189
    //   117: aload 5
    //   119: astore 4
    //   121: aload 6
    //   123: aload 5
    //   125: invokestatic 81	com/whatsapp/location/cb$c:a	(Landroid/database/Cursor;)Lcom/whatsapp/location/cb$c;
    //   128: invokeinterface 87 2 0
    //   133: pop
    //   134: goto -31 -> 103
    //   137: astore 6
    //   139: aload 5
    //   141: astore 4
    //   143: ldc 89
    //   145: aload 6
    //   147: invokestatic 93	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   150: aload 5
    //   152: astore 4
    //   154: new 95	java/lang/RuntimeException
    //   157: dup
    //   158: aload 6
    //   160: invokespecial 98	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   163: athrow
    //   164: astore 6
    //   166: aload 4
    //   168: astore 5
    //   170: aload 6
    //   172: astore 4
    //   174: aload 5
    //   176: ifnull +10 -> 186
    //   179: aload 5
    //   181: invokeinterface 72 1 0
    //   186: aload 4
    //   188: athrow
    //   189: aload 5
    //   191: ifnull +10 -> 201
    //   194: aload 5
    //   196: invokeinterface 72 1 0
    //   201: new 100	java/lang/StringBuilder
    //   204: dup
    //   205: ldc 102
    //   207: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   210: aload 6
    //   212: invokeinterface 108 1 0
    //   217: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   220: ldc 114
    //   222: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: iload_1
    //   226: invokevirtual 120	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   229: ldc 122
    //   231: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: invokestatic 32	java/lang/System:currentTimeMillis	()J
    //   237: lload_2
    //   238: lsub
    //   239: invokevirtual 125	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   242: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: invokestatic 132	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   248: aload 6
    //   250: areturn
    //   251: astore 4
    //   253: goto -79 -> 174
    //   256: astore 6
    //   258: aconst_null
    //   259: astore 5
    //   261: goto -122 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	this	cb
    //   0	264	1	paramBoolean	boolean
    //   6	232	2	l	long
    //   36	151	4	localObject1	Object
    //   251	1	4	localObject2	Object
    //   1	259	5	localObject3	Object
    //   14	108	6	localArrayList	ArrayList
    //   137	22	6	localException1	Exception
    //   164	85	6	localList	List<c>
    //   256	1	6	localException2	Exception
    //   23	16	7	localSQLiteDatabase	SQLiteDatabase
    //   28	15	8	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   76	81	137	java/lang/Exception
    //   107	117	137	java/lang/Exception
    //   121	134	137	java/lang/Exception
    //   76	81	164	finally
    //   107	117	164	finally
    //   121	134	164	finally
    //   143	150	164	finally
    //   154	164	164	finally
    //   16	30	251	finally
    //   38	63	251	finally
    //   16	30	256	java/lang/Exception
    //   38	63	256	java/lang/Exception
  }
  
  final b a()
  {
    if (this.a == null) {}
    try
    {
      if (this.a == null) {
        this.a = new b(this.b);
      }
      return this.a;
    }
    finally {}
  }
  
  final void a(ap paramap)
  {
    SQLiteDatabase localSQLiteDatabase = a().getWritableDatabase();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("jid", paramap.a);
    localContentValues.put("latitude", Double.valueOf(paramap.b));
    localContentValues.put("longitude", Double.valueOf(paramap.c));
    localContentValues.put("accuracy", Integer.valueOf(paramap.d));
    localContentValues.put("speed", Float.valueOf(paramap.e));
    localContentValues.put("bearing", Integer.valueOf(paramap.f));
    localContentValues.put("location_ts", Long.valueOf(paramap.g));
    localSQLiteDatabase.replaceOrThrow("location_cache", null, localContentValues);
    Log.i("LocationSharingStore/saveUserLocation/saved user location; jid=" + paramap.a + "; timestamp=" + paramap.g);
  }
  
  final void a(Iterable<String> paramIterable)
  {
    a(true, paramIterable);
  }
  
  final void a(String paramString1, long paramLong, String paramString2, List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new c(paramString1, (String)paramList.next(), paramLong, new j.b(paramString1, true, paramString2), (byte)0));
    }
    a(localArrayList);
  }
  
  final void a(String paramString1, String paramString2)
  {
    if (paramString2 != null)
    {
      a(false, paramString1, Collections.singletonList(paramString2));
      return;
    }
    a(false, Collections.singletonList(paramString1));
  }
  
  public final void a(String paramString, List<String> paramList)
  {
    a(true, paramString, paramList);
  }
  
  final void a(Collection<String> paramCollection)
  {
    long l = System.currentTimeMillis();
    SQLiteDatabase localSQLiteDatabase = a().getWritableDatabase();
    try
    {
      localSQLiteDatabase.beginTransaction();
      paramCollection = paramCollection.iterator();
      for (int i = 0; paramCollection.hasNext(); i = localSQLiteDatabase.delete("location_cache", "jid = ?", new String[] { (String)paramCollection.next() }) + i) {}
      localSQLiteDatabase.setTransactionSuccessful();
      localSQLiteDatabase.endTransaction();
      Log.i("LocationSharingStore/deleteUserLocations/deleted " + i + " location sharers | time: " + (System.currentTimeMillis() - l));
      return;
    }
    catch (Exception paramCollection)
    {
      Log.d("LocationSharingStore/deleteUserLocations/delete failed", paramCollection);
      throw new RuntimeException(paramCollection);
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
  }
  
  final void a(List<c> paramList)
  {
    long l = System.currentTimeMillis();
    SQLiteDatabase localSQLiteDatabase = a().getWritableDatabase();
    try
    {
      localSQLiteDatabase.beginTransaction();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("remote_jid", localc.b);
        localContentValues.put("from_me", Boolean.valueOf(localc.e.b));
        localContentValues.put("remote_resource", localc.c);
        localContentValues.put("expires", Long.valueOf(localc.d));
        localContentValues.put("message_id", localc.e.c);
        localSQLiteDatabase.replaceOrThrow("location_sharer", null, localContentValues);
      }
    }
    catch (Exception paramList)
    {
      Log.d("LocationSharingStore/saveLocationSharer/save failed", paramList);
      throw new RuntimeException(paramList);
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
    localSQLiteDatabase.endTransaction();
    Log.i("LocationSharingStore/saveLocationSharer/saved " + paramList.size() + " location sharers | time: " + (System.currentTimeMillis() - l));
  }
  
  final void a(List<String> paramList, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    SQLiteDatabase localSQLiteDatabase = a().getWritableDatabase();
    try
    {
      localSQLiteDatabase.beginTransaction();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("jid", str);
        localContentValues.put("sent_to_server", Boolean.valueOf(paramBoolean));
        localSQLiteDatabase.replaceOrThrow("location_key_distribution", null, localContentValues);
      }
    }
    catch (Exception paramList)
    {
      Log.d("LocationSharingStore/storeLocationReceiverHasKey/save failed", paramList);
      throw new RuntimeException(paramList);
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
    localSQLiteDatabase.endTransaction();
    Log.i("LocationSharingStore/storeLocationReceiverHasKey/saved " + paramList.size() + " location receiver has key: " + paramBoolean + " | time: " + (System.currentTimeMillis() - l));
  }
  
  /* Error */
  final void a(boolean paramBoolean, long paramLong)
  {
    // Byte code:
    //   0: invokestatic 32	java/lang/System:currentTimeMillis	()J
    //   3: lstore 5
    //   5: aload_0
    //   6: invokevirtual 38	com/whatsapp/location/cb:a	()Lcom/whatsapp/location/cb$b;
    //   9: invokevirtual 142	com/whatsapp/location/cb$b:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   12: astore 8
    //   14: lload_2
    //   15: invokestatic 352	java/lang/Long:toString	(J)Ljava/lang/String;
    //   18: astore 9
    //   20: lconst_0
    //   21: invokestatic 352	java/lang/Long:toString	(J)Ljava/lang/String;
    //   24: astore 10
    //   26: iload_1
    //   27: ifeq +75 -> 102
    //   30: ldc 47
    //   32: astore 7
    //   34: aload 8
    //   36: ldc 49
    //   38: ldc_w 354
    //   41: iconst_3
    //   42: anewarray 53	java/lang/String
    //   45: dup
    //   46: iconst_0
    //   47: aload 9
    //   49: aastore
    //   50: dup
    //   51: iconst_1
    //   52: aload 10
    //   54: aastore
    //   55: dup
    //   56: iconst_2
    //   57: aload 7
    //   59: aastore
    //   60: invokevirtual 287	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   63: istore 4
    //   65: new 100	java/lang/StringBuilder
    //   68: dup
    //   69: ldc_w 356
    //   72: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   75: iload 4
    //   77: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   80: ldc_w 297
    //   83: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokestatic 32	java/lang/System:currentTimeMillis	()J
    //   89: lload 5
    //   91: lsub
    //   92: invokevirtual 125	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   95: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 132	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   101: return
    //   102: ldc 74
    //   104: astore 7
    //   106: goto -72 -> 34
    //   109: astore 7
    //   111: ldc_w 358
    //   114: aload 7
    //   116: invokestatic 93	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   119: new 95	java/lang/RuntimeException
    //   122: dup
    //   123: aload 7
    //   125: invokespecial 98	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   128: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	cb
    //   0	129	1	paramBoolean	boolean
    //   0	129	2	paramLong	long
    //   63	13	4	i	int
    //   3	87	5	l	long
    //   32	73	7	str1	String
    //   109	15	7	localException	Exception
    //   12	23	8	localSQLiteDatabase	SQLiteDatabase
    //   18	30	9	str2	String
    //   24	29	10	str3	String
    // Exception table:
    //   from	to	target	type
    //   14	26	109	java/lang/Exception
    //   34	65	109	java/lang/Exception
  }
  
  final void a(boolean paramBoolean, Iterable<String> paramIterable)
  {
    long l = System.currentTimeMillis();
    SQLiteDatabase localSQLiteDatabase = a().getWritableDatabase();
    for (;;)
    {
      try
      {
        localSQLiteDatabase.beginTransaction();
        Iterator localIterator = paramIterable.iterator();
        int i = 0;
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (paramBoolean)
          {
            paramIterable = "1";
            i = localSQLiteDatabase.delete("location_sharer", "remote_jid = ? AND from_me = ?", new String[] { str, paramIterable }) + i;
          }
        }
        else
        {
          localSQLiteDatabase.setTransactionSuccessful();
          localSQLiteDatabase.endTransaction();
          Log.i("LocationSharingStore/deleteLocationSharers/deleted " + i + " location sharers | time: " + (System.currentTimeMillis() - l));
          return;
        }
      }
      catch (Exception paramIterable)
      {
        Log.d("LocationSharingStore/deleteLocationSharers/delete failed", paramIterable);
        throw new RuntimeException(paramIterable);
      }
      finally
      {
        localSQLiteDatabase.endTransaction();
      }
      paramIterable = "0";
    }
  }
  
  final void a(boolean paramBoolean, String paramString, Collection<String> paramCollection)
  {
    long l = System.currentTimeMillis();
    SQLiteDatabase localSQLiteDatabase = a().getWritableDatabase();
    for (;;)
    {
      try
      {
        localSQLiteDatabase.beginTransaction();
        Iterator localIterator = paramCollection.iterator();
        int i = 0;
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (paramBoolean)
          {
            paramCollection = "1";
            i = localSQLiteDatabase.delete("location_sharer", "remote_jid = ? AND remote_resource = ? AND from_me = ?", new String[] { paramString, str, paramCollection }) + i;
          }
        }
        else
        {
          localSQLiteDatabase.setTransactionSuccessful();
          localSQLiteDatabase.endTransaction();
          Log.i("LocationSharingStore/deleteLocationSharers/deleted " + i + " location sharers | time: " + (System.currentTimeMillis() - l));
          return;
        }
      }
      catch (Exception paramString)
      {
        Log.d("LocationSharingStore/deleteLocationSharers/delete failed", paramString);
        throw new RuntimeException(paramString);
      }
      finally
      {
        localSQLiteDatabase.endTransaction();
      }
      paramCollection = "0";
    }
  }
  
  final Map<String, bp.a> b()
  {
    Object localObject = a(true);
    HashMap localHashMap = new HashMap(((List)localObject).size());
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      c localc = (c)((Iterator)localObject).next();
      if (!localHashMap.containsKey(localc.b)) {
        localHashMap.put(localc.b, new bp.a(localc.d, null, localc.e));
      }
      ((bp.a)localHashMap.get(localc.b)).b.add(localc.c);
    }
    return localHashMap;
  }
  
  final Map<String, Map<String, bp.b>> c()
  {
    Object localObject = a(false);
    HashMap localHashMap = new HashMap();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      c localc = (c)((Iterator)localObject).next();
      if (!localHashMap.containsKey(localc.b)) {
        localHashMap.put(localc.b, new HashMap());
      }
      ((Map)localHashMap.get(localc.b)).put(localc.c, new bp.b(localc.c, localc.d, localc.e));
    }
    return localHashMap;
  }
  
  /* Error */
  final java.util.Set<String> d()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: invokestatic 32	java/lang/System:currentTimeMillis	()J
    //   6: lstore_1
    //   7: new 408	java/util/HashSet
    //   10: dup
    //   11: invokespecial 409	java/util/HashSet:<init>	()V
    //   14: astore 5
    //   16: aload_0
    //   17: invokevirtual 38	com/whatsapp/location/cb:a	()Lcom/whatsapp/location/cb$b;
    //   20: invokevirtual 42	com/whatsapp/location/cb$b:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   23: ldc_w 341
    //   26: iconst_1
    //   27: anewarray 53	java/lang/String
    //   30: dup
    //   31: iconst_0
    //   32: ldc -109
    //   34: aastore
    //   35: ldc_w 411
    //   38: iconst_1
    //   39: anewarray 53	java/lang/String
    //   42: dup
    //   43: iconst_0
    //   44: ldc 47
    //   46: aastore
    //   47: aconst_null
    //   48: aconst_null
    //   49: aconst_null
    //   50: invokevirtual 59	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   53: astore_3
    //   54: aload_3
    //   55: astore 4
    //   57: aload 4
    //   59: ifnonnull +27 -> 86
    //   62: aload 4
    //   64: astore_3
    //   65: ldc_w 413
    //   68: invokestatic 67	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   71: aload 4
    //   73: ifnull +10 -> 83
    //   76: aload 4
    //   78: invokeinterface 72 1 0
    //   83: aload 5
    //   85: areturn
    //   86: aload 4
    //   88: astore_3
    //   89: aload 4
    //   91: invokeinterface 78 1 0
    //   96: ifeq +73 -> 169
    //   99: aload 4
    //   101: astore_3
    //   102: aload 5
    //   104: aload 4
    //   106: iconst_0
    //   107: invokeinterface 417 2 0
    //   112: invokeinterface 420 2 0
    //   117: pop
    //   118: goto -32 -> 86
    //   121: astore 5
    //   123: aload 4
    //   125: astore_3
    //   126: ldc_w 422
    //   129: aload 5
    //   131: invokestatic 93	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   134: aload 4
    //   136: astore_3
    //   137: new 95	java/lang/RuntimeException
    //   140: dup
    //   141: aload 5
    //   143: invokespecial 98	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   146: athrow
    //   147: astore 5
    //   149: aload_3
    //   150: astore 4
    //   152: aload 5
    //   154: astore_3
    //   155: aload 4
    //   157: ifnull +10 -> 167
    //   160: aload 4
    //   162: invokeinterface 72 1 0
    //   167: aload_3
    //   168: athrow
    //   169: aload 4
    //   171: ifnull +10 -> 181
    //   174: aload 4
    //   176: invokeinterface 72 1 0
    //   181: new 100	java/lang/StringBuilder
    //   184: dup
    //   185: ldc_w 424
    //   188: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   191: aload 5
    //   193: invokeinterface 425 1 0
    //   198: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   201: ldc_w 427
    //   204: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokestatic 32	java/lang/System:currentTimeMillis	()J
    //   210: lload_1
    //   211: lsub
    //   212: invokevirtual 125	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   215: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 132	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   221: aload 5
    //   223: areturn
    //   224: astore_3
    //   225: goto -70 -> 155
    //   228: astore 5
    //   230: aconst_null
    //   231: astore 4
    //   233: goto -110 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	this	cb
    //   6	205	1	l	long
    //   53	115	3	localObject1	Object
    //   224	1	3	localObject2	Object
    //   1	231	4	localObject3	Object
    //   14	89	5	localHashSet	java.util.HashSet
    //   121	21	5	localException1	Exception
    //   147	75	5	localSet	java.util.Set<String>
    //   228	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   65	71	121	java/lang/Exception
    //   89	99	121	java/lang/Exception
    //   102	118	121	java/lang/Exception
    //   65	71	147	finally
    //   89	99	147	finally
    //   102	118	147	finally
    //   126	134	147	finally
    //   137	147	147	finally
    //   16	54	224	finally
    //   16	54	228	java/lang/Exception
  }
  
  /* Error */
  final Map<String, ap> e()
  {
    // Byte code:
    //   0: invokestatic 32	java/lang/System:currentTimeMillis	()J
    //   3: lstore_1
    //   4: new 376	java/util/HashMap
    //   7: dup
    //   8: invokespecial 399	java/util/HashMap:<init>	()V
    //   11: astore 5
    //   13: aload_0
    //   14: invokevirtual 38	com/whatsapp/location/cb:a	()Lcom/whatsapp/location/cb$b;
    //   17: invokevirtual 42	com/whatsapp/location/cb$b:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   20: ldc -35
    //   22: getstatic 429	com/whatsapp/location/cb$a:a	[Ljava/lang/String;
    //   25: aconst_null
    //   26: aconst_null
    //   27: aconst_null
    //   28: aconst_null
    //   29: aconst_null
    //   30: invokevirtual 59	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   33: astore 4
    //   35: aload 4
    //   37: ifnonnull +27 -> 64
    //   40: aload 4
    //   42: astore_3
    //   43: ldc_w 431
    //   46: invokestatic 67	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   49: aload 4
    //   51: ifnull +10 -> 61
    //   54: aload 4
    //   56: invokeinterface 72 1 0
    //   61: aload 5
    //   63: areturn
    //   64: aload 4
    //   66: astore_3
    //   67: aload 4
    //   69: invokeinterface 78 1 0
    //   74: ifeq +88 -> 162
    //   77: aload 4
    //   79: astore_3
    //   80: aload 4
    //   82: invokestatic 434	com/whatsapp/location/cb$a:a	(Landroid/database/Cursor;)Lcom/whatsapp/location/cb$a;
    //   85: astore 6
    //   87: aload 4
    //   89: astore_3
    //   90: aload 5
    //   92: aload 6
    //   94: getfield 437	com/whatsapp/location/cb$a:b	Lcom/whatsapp/protocol/ap;
    //   97: getfield 152	com/whatsapp/protocol/ap:a	Ljava/lang/String;
    //   100: aload 6
    //   102: getfield 437	com/whatsapp/location/cb$a:b	Lcom/whatsapp/protocol/ap;
    //   105: invokeinterface 390 3 0
    //   110: pop
    //   111: goto -47 -> 64
    //   114: astore 5
    //   116: aload 4
    //   118: astore_3
    //   119: ldc_w 439
    //   122: aload 5
    //   124: invokestatic 93	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   127: aload 4
    //   129: astore_3
    //   130: new 95	java/lang/RuntimeException
    //   133: dup
    //   134: aload 5
    //   136: invokespecial 98	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   139: athrow
    //   140: astore 5
    //   142: aload_3
    //   143: astore 4
    //   145: aload 5
    //   147: astore_3
    //   148: aload 4
    //   150: ifnull +10 -> 160
    //   153: aload 4
    //   155: invokeinterface 72 1 0
    //   160: aload_3
    //   161: athrow
    //   162: aload 4
    //   164: ifnull +10 -> 174
    //   167: aload 4
    //   169: invokeinterface 72 1 0
    //   174: new 100	java/lang/StringBuilder
    //   177: dup
    //   178: ldc_w 441
    //   181: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   184: aload 5
    //   186: invokeinterface 442 1 0
    //   191: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   194: ldc_w 444
    //   197: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: invokestatic 32	java/lang/System:currentTimeMillis	()J
    //   203: lload_1
    //   204: lsub
    //   205: invokevirtual 125	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   208: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokestatic 132	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   214: aload 5
    //   216: areturn
    //   217: astore_3
    //   218: aconst_null
    //   219: astore 4
    //   221: goto -73 -> 148
    //   224: astore 5
    //   226: aconst_null
    //   227: astore 4
    //   229: goto -113 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	this	cb
    //   3	201	1	l	long
    //   42	119	3	localObject1	Object
    //   217	1	3	localObject2	Object
    //   33	195	4	localObject3	Object
    //   11	80	5	localHashMap	HashMap
    //   114	21	5	localException1	Exception
    //   140	75	5	localMap	Map<String, ap>
    //   224	1	5	localException2	Exception
    //   85	16	6	locala	a
    // Exception table:
    //   from	to	target	type
    //   43	49	114	java/lang/Exception
    //   67	77	114	java/lang/Exception
    //   80	87	114	java/lang/Exception
    //   90	111	114	java/lang/Exception
    //   43	49	140	finally
    //   67	77	140	finally
    //   80	87	140	finally
    //   90	111	140	finally
    //   119	127	140	finally
    //   130	140	140	finally
    //   13	35	217	finally
    //   13	35	224	java/lang/Exception
  }
  
  static final class a
  {
    static final String[] a = { "jid", "latitude", "longitude", "accuracy", "speed", "bearing", "location_ts" };
    final ap b = new ap();
    
    private a(Cursor paramCursor)
    {
      this.b.a = paramCursor.getString(0);
      this.b.b = paramCursor.getDouble(1);
      this.b.c = paramCursor.getDouble(2);
      this.b.d = paramCursor.getInt(3);
      this.b.e = paramCursor.getFloat(4);
      this.b.f = paramCursor.getInt(5);
      this.b.g = paramCursor.getLong(6);
    }
    
    static a a(Cursor paramCursor)
    {
      return new a(paramCursor);
    }
  }
  
  static final class b
    extends SQLiteOpenHelper
  {
    private final Context a;
    
    b(Context paramContext)
    {
      super("location.db", null, 1);
      if ((Build.VERSION.SDK_INT >= 16) && (!a.a())) {
        setWriteAheadLoggingEnabled(true);
      }
      this.a = paramContext;
    }
    
    private boolean a()
    {
      try
      {
        close();
        Log.i("LocationSharingStore/DatabaseHelper/deleteDatabaseFiles");
        boolean bool1 = b().delete();
        File localFile = b();
        boolean bool2 = new File(localFile.getPath(), localFile.getName() + "-journal").delete();
        localFile = b();
        boolean bool3 = new File(localFile.getPath(), localFile.getName() + "-wal").delete();
        Log.i("LocationSharingStore/DatabaseHelper/deleteDatabaseFiles/deleted location database; databaseDeleted=" + bool1 + "; journalDeleted=" + bool2 + "; writeAheadLogDeleted=" + bool3);
        return bool1;
      }
      finally {}
    }
    
    private File b()
    {
      return this.a.getDatabasePath("location.db");
    }
    
    public final SQLiteDatabase getReadableDatabase()
    {
      try
      {
        SQLiteDatabase localSQLiteDatabase = super.getReadableDatabase();
        return localSQLiteDatabase;
      }
      catch (SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException)
      {
        Log.w("LocationSharingStore/DatabaseHelper/getReadableDatabase/Locations database is corrupt. Removing...");
        a();
        return super.getReadableDatabase();
      }
      catch (SQLiteException localSQLiteException)
      {
        localObject = localSQLiteException.toString();
        if (((String)localObject).contains("file is encrypted"))
        {
          Log.w("LocationSharingStore/DatabaseHelper/getReadableDatabase/Locations database is encrypted. Removing...");
          a();
          return super.getReadableDatabase();
        }
        if (((String)localObject).contains("upgrade read-only database"))
        {
          Log.w("LocationSharingStore/DatabaseHelper/getReadableDatabase/Client actually opened database as read-only and can't upgrade. Switching to writable...");
          return getWritableDatabase();
        }
        throw localSQLiteException;
      }
      catch (StackOverflowError localStackOverflowError)
      {
        Log.w("LocationSharingStore/DatabaseHelper/getReadableDatabase/StackOverflowError during db init check");
        Object localObject = localStackOverflowError.getStackTrace();
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          if (localObject[i].getMethodName().equals("onCorruption"))
          {
            Log.w("LocationSharingStore/DatabaseHelper/getReadableDatabase/Locations database is corrupt. Found via StackOverflowError. Removing...");
            a();
            return super.getReadableDatabase();
          }
          i += 1;
        }
        throw localStackOverflowError;
      }
    }
    
    public final SQLiteDatabase getWritableDatabase()
    {
      try
      {
        SQLiteDatabase localSQLiteDatabase = super.getWritableDatabase();
        return localSQLiteDatabase;
      }
      catch (SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException)
      {
        Log.w("LocationSharingStore/DatabaseHelper/getWritableDatabase/Locations database is corrupt. Removing...");
        a();
        return super.getWritableDatabase();
      }
      catch (SQLiteException localSQLiteException)
      {
        if (localSQLiteException.toString().contains("file is encrypted"))
        {
          Log.w("LocationSharingStore/DatabaseHelper/getWritableDatabase/Locations database is encrypted. Removing...");
          a();
          return super.getWritableDatabase();
        }
        throw localSQLiteException;
      }
      catch (StackOverflowError localStackOverflowError)
      {
        Log.w("LocationSharingStore/DatabaseHelper/getWritableDatabase/StackOverflowError during db init check");
        StackTraceElement[] arrayOfStackTraceElement = localStackOverflowError.getStackTrace();
        int j = arrayOfStackTraceElement.length;
        int i = 0;
        while (i < j)
        {
          if (arrayOfStackTraceElement[i].getMethodName().equals("onCorruption"))
          {
            Log.w("LocationSharingStore/DatabaseHelper/getWritableDatabase/Locations database is corrupt. Found via StackOverflowError. Removing...");
            a();
            return super.getWritableDatabase();
          }
          i += 1;
        }
        throw localStackOverflowError;
      }
    }
    
    public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      Log.i("LocationSharingStore/DatabaseHelper/onCreate; version=1");
      Log.i("LocationSharingStore/DatabaseHelper/createLocationSharerTable/creating location_sharer table; version=1");
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS location_sharer");
      paramSQLiteDatabase.execSQL("CREATE TABLE location_sharer (_id INTEGER PRIMARY KEY AUTOINCREMENT, remote_jid TEXT NOT NULL, from_me BOOLEAN NOT NULL, remote_resource TEXT NOT NULL, expires INTEGER NOT NULL, message_id TEXT NOT NULL)");
      paramSQLiteDatabase.execSQL("CREATE UNIQUE INDEX location_sharer_index ON location_sharer(remote_jid, from_me, remote_resource)");
      Log.i("LocationSharingStore/DatabaseHelper/createLocationKeyDistributionTable/creating location_key_distribution table; version=1");
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS location_key_distribution");
      paramSQLiteDatabase.execSQL("CREATE TABLE location_key_distribution (_id INTEGER PRIMARY KEY AUTOINCREMENT, jid TEXT NOT NULL, sent_to_server BOOLEAN NOT NULL)");
      paramSQLiteDatabase.execSQL("CREATE UNIQUE INDEX location_key_distribution_index ON location_key_distribution(jid)");
      Log.i("LocationSharingStore/DatabaseHelper/createUserLocationsTable/creating location_cache table; version=1");
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS location_cache");
      paramSQLiteDatabase.execSQL("CREATE TABLE location_cache (_id INTEGER PRIMARY KEY AUTOINCREMENT, jid TEXT NOT NULL, latitude REAL NOT NULL, longitude REAL NOT NULL, accuracy INTEGER NOT NULL, speed REAL NOT NULL, bearing INTEGER NOT NULL, location_ts INTEGER NOT NULL)");
      paramSQLiteDatabase.execSQL("CREATE UNIQUE INDEX user_location_index ON location_cache(jid)");
    }
    
    public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      Log.w("LocationSharingStore/DatabaseHelper/onDowngrade; oldVersion=" + paramInt1 + "; newVersion=" + paramInt2);
      onCreate(paramSQLiteDatabase);
    }
    
    public final void onOpen(SQLiteDatabase paramSQLiteDatabase)
    {
      super.onOpen(paramSQLiteDatabase);
      if ((Build.VERSION.SDK_INT >= 11) && (Build.VERSION.SDK_INT < 16) && (!a.a())) {
        paramSQLiteDatabase.enableWriteAheadLogging();
      }
    }
    
    public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      Log.i("LocationSharingStore/DatabaseHelper/onUpgrade; oldVersion=" + paramInt1 + "; newVersion=" + paramInt2);
      Log.i("LocationSharingStore/DatabaseHelper/onUpgrade/unknown old version");
      onCreate(paramSQLiteDatabase);
    }
  }
  
  static final class c
  {
    static final String[] a = { "remote_jid", "from_me", "remote_resource", "expires", "message_id" };
    public final String b;
    public final String c;
    public final long d;
    public final j.b e;
    
    private c(Cursor paramCursor)
    {
      this.b = paramCursor.getString(0);
      this.c = paramCursor.getString(2);
      this.d = paramCursor.getLong(3);
      String str = this.b;
      if (paramCursor.getInt(1) == 1) {}
      for (;;)
      {
        this.e = new j.b(str, bool, paramCursor.getString(4));
        return;
        bool = false;
      }
    }
    
    private c(String paramString1, String paramString2, long paramLong, j.b paramb)
    {
      this.b = paramString1;
      this.c = paramString2;
      this.d = paramLong;
      this.e = paramb;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/location/cb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */