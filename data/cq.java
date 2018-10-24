package com.whatsapp.data;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import com.whatsapp.MediaData;
import com.whatsapp.ox;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.util.Log;
import java.io.File;
import java.net.URI;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

public class cq
{
  private static volatile cq a;
  private final ox b;
  private final n c;
  private final ReentrantReadWriteLock.ReadLock d;
  
  private cq(ox paramox, ch paramch)
  {
    this.b = paramox;
    this.c = paramch.a;
    this.d = paramch.b.readLock();
  }
  
  public static cq a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new cq(ox.a(), ch.a());
      }
      return a;
    }
    finally {}
  }
  
  final Object a(Object paramObject)
  {
    Object localObject1 = paramObject;
    if ((paramObject instanceof MediaData))
    {
      Object localObject2 = (MediaData)paramObject;
      localObject1 = paramObject;
      if (((MediaData)localObject2).file != null)
      {
        localObject1 = paramObject;
        if (((MediaData)localObject2).file.isAbsolute())
        {
          localObject1 = ((MediaData)localObject2).createSerializableCopy();
          paramObject = this.b;
          localObject2 = ((MediaData)localObject1).file;
          ((MediaData)localObject1).file = new File(((ox)paramObject).a.toURI().relativize(((File)localObject2).toURI()).getPath());
        }
      }
    }
    return localObject1;
  }
  
  public final boolean a(j paramj)
  {
    localObject2 = null;
    localObject1 = null;
    this.d.lock();
    for (;;)
    {
      try
      {
        localSQLiteDatabase = this.c.getWritableDatabase();
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localSQLiteDatabase.beginTransaction();
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        String str = paramj.e.a;
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        if (paramj.e.b)
        {
          i = 1;
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          i = localSQLiteDatabase.delete("message_thumbnails", "key_remote_jid=? AND key_from_me=? AND key_id=?", new String[] { str, String.valueOf(i), paramj.e.c });
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          Log.i("thumbnailmsgstore/deleteMessageThumbnail/" + i);
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localSQLiteDatabase.setTransactionSuccessful();
          if (localSQLiteDatabase == null) {}
        }
      }
      catch (SQLiteDatabaseCorruptException paramj)
      {
        SQLiteDatabase localSQLiteDatabase;
        int i;
        localObject2 = localObject1;
        Log.d("thumbnailmsgstore/deleteMessageThumbnail", paramj);
        if ((localObject1 != null) && (((SQLiteDatabase)localObject1).inTransaction())) {
          ((SQLiteDatabase)localObject1).endTransaction();
        }
        this.d.unlock();
        return false;
      }
      finally
      {
        if ((localObject2 != null) && (((SQLiteDatabase)localObject2).inTransaction())) {
          ((SQLiteDatabase)localObject2).endTransaction();
        }
      }
      try
      {
        if (localSQLiteDatabase.inTransaction()) {
          localSQLiteDatabase.endTransaction();
        }
        return true;
      }
      finally
      {
        this.d.unlock();
      }
      i = 0;
    }
  }
  
  final boolean a(String paramString)
  {
    this.d.lock();
    try
    {
      int i = this.c.getWritableDatabase().delete("message_thumbnails", "key_remote_jid=?", new String[] { paramString });
      Log.i("msgstore/deleteAllMessageThumbnailsFor-jid/" + i);
      return true;
    }
    catch (SQLiteDatabaseCorruptException paramString)
    {
      Log.d("msgstore/deleteAllMessageThumbnailsFor-jid", paramString);
      return false;
    }
    finally
    {
      this.d.unlock();
    }
  }
  
  /* Error */
  final boolean a(byte[] paramArrayOfByte, j.b paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 36	com/whatsapp/data/cq:d	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   4: invokevirtual 94	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   7: new 183	android/content/ContentValues
    //   10: dup
    //   11: invokespecial 184	android/content/ContentValues:<init>	()V
    //   14: astore 4
    //   16: aload 4
    //   18: ldc -70
    //   20: aload_1
    //   21: invokevirtual 190	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   24: aload 4
    //   26: ldc -64
    //   28: aload_2
    //   29: getfield 116	com/whatsapp/protocol/j$b:a	Ljava/lang/String;
    //   32: invokevirtual 195	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: aload_2
    //   36: getfield 119	com/whatsapp/protocol/j$b:b	Z
    //   39: ifeq +69 -> 108
    //   42: iconst_1
    //   43: istore_3
    //   44: aload 4
    //   46: ldc -59
    //   48: iload_3
    //   49: invokestatic 129	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   52: invokevirtual 195	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: aload 4
    //   57: ldc -57
    //   59: aload_2
    //   60: getfield 131	com/whatsapp/protocol/j$b:c	Ljava/lang/String;
    //   63: invokevirtual 195	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: aload 4
    //   68: ldc -55
    //   70: invokestatic 207	java/lang/System:currentTimeMillis	()J
    //   73: ldc2_w 208
    //   76: ldiv
    //   77: invokestatic 214	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   80: invokevirtual 217	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   83: aload_0
    //   84: getfield 25	com/whatsapp/data/cq:c	Lcom/whatsapp/data/n;
    //   87: invokevirtual 100	com/whatsapp/data/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   90: ldc 121
    //   92: aconst_null
    //   93: aload 4
    //   95: invokevirtual 221	android/database/sqlite/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   98: pop2
    //   99: aload_0
    //   100: getfield 36	com/whatsapp/data/cq:d	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   103: invokevirtual 164	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   106: iconst_1
    //   107: ireturn
    //   108: iconst_0
    //   109: istore_3
    //   110: goto -66 -> 44
    //   113: astore_1
    //   114: ldc -33
    //   116: aload_1
    //   117: invokestatic 169	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   120: aload_0
    //   121: getfield 36	com/whatsapp/data/cq:d	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   124: invokevirtual 164	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   127: iconst_0
    //   128: ireturn
    //   129: astore_1
    //   130: aload_1
    //   131: invokestatic 226	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   134: aload_1
    //   135: athrow
    //   136: astore_1
    //   137: aload_0
    //   138: getfield 36	com/whatsapp/data/cq:d	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   141: invokevirtual 164	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   144: aload_1
    //   145: athrow
    //   146: astore_1
    //   147: goto -17 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	cq
    //   0	150	1	paramArrayOfByte	byte[]
    //   0	150	2	paramb	j.b
    //   43	67	3	i	int
    //   14	80	4	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   7	42	113	android/database/sqlite/SQLiteDatabaseCorruptException
    //   44	99	113	android/database/sqlite/SQLiteDatabaseCorruptException
    //   7	42	129	java/lang/RuntimeException
    //   44	99	129	java/lang/RuntimeException
    //   7	42	136	finally
    //   44	99	136	finally
    //   114	120	136	finally
    //   130	136	136	finally
    //   7	42	146	java/lang/Error
    //   44	99	146	java/lang/Error
  }
  
  public final byte[] a(j.b paramb)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int i = 1;
    if (paramb == null) {
      return null;
    }
    this.d.lock();
    for (;;)
    {
      try
      {
        Object localObject3 = this.c.getReadableDatabase();
        String str = paramb.a;
        if (paramb.b)
        {
          localObject3 = ((SQLiteDatabase)localObject3).rawQuery("SELECT thumbnail FROM message_thumbnails WHERE key_remote_jid=? AND key_from_me=? AND key_id=?", new String[] { str, String.valueOf(i), paramb.c });
          if (localObject3 != null) {
            paramb = (j.b)localObject1;
          }
        }
        else
        {
          try
          {
            if (((Cursor)localObject3).moveToLast()) {
              paramb = ((Cursor)localObject3).getBlob(0);
            }
            ((Cursor)localObject3).close();
            return paramb;
          }
          finally
          {
            ((Cursor)localObject3).close();
          }
          i = 0;
          continue;
        }
        Log.e("thumbnailmsgstore/getMessageThumbnail no cursor");
      }
      finally
      {
        this.d.unlock();
      }
      paramb = (j.b)localObject2;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/data/cq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */