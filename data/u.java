package com.whatsapp.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.whatsapp.util.Log;
import com.whatsapp.util.aa;
import com.whatsapp.util.bd;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

public class u
{
  private static volatile u a;
  private final cj b;
  private final File c;
  private final n d;
  private final ReentrantReadWriteLock.ReadLock e;
  
  private u(cj paramcj, ch paramch)
  {
    this.b = paramcj;
    this.c = paramch.c;
    this.d = paramch.a;
    this.e = paramch.b.readLock();
  }
  
  public static u a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new u(cj.a(), ch.a());
      }
      return a;
    }
    finally {}
  }
  
  private int d()
  {
    this.e.lock();
    for (;;)
    {
      int j;
      int k;
      try
      {
        SQLiteDatabase localSQLiteDatabase = this.d.getWritableDatabase();
        Cursor localCursor = localSQLiteDatabase.rawQuery("SELECT _id, key_remote_jid, data, media_caption, media_wa_type FROM messages WHERE _id>? ORDER BY _id ASC LIMIT 2048", new String[] { String.valueOf(this.b.b("links_index_start")) });
        int m = 0;
        j = 0;
        k = 0;
        i = 0;
        if (localCursor != null) {}
        try
        {
          localSQLiteDatabase.beginTransaction();
          int n = localCursor.getColumnIndex("_id");
          int i1 = localCursor.getColumnIndex("key_remote_jid");
          int i2 = localCursor.getColumnIndex("data");
          int i3 = localCursor.getColumnIndex("media_caption");
          int i4 = localCursor.getColumnIndex("media_wa_type");
          long l = 0L;
          Object localObject1;
          if (localCursor.moveToNext())
          {
            k = localCursor.getInt(i4);
            localObject1 = null;
          }
          switch (k)
          {
          case 0: 
            l = localCursor.getLong(n);
            String str = localCursor.getString(i1);
            localObject1 = aa.a((String)localObject1);
            k = i;
            if (localObject1 == null) {
              break;
            }
            m = 0;
            k = i;
            if (m >= ((ArrayList)localObject1).size()) {
              break;
            }
            ContentValues localContentValues = new ContentValues(3);
            localContentValues.put("message_row_id", Long.valueOf(l));
            localContentValues.put("key_remote_jid", str);
            localContentValues.put("link_index", Integer.toString(m));
            localSQLiteDatabase.insert("messages_links", null, localContentValues);
            m += 1;
            i += 1;
            continue;
            localObject1 = localCursor.getString(i2);
            break;
          case 1: 
          case 3: 
          case 13: 
            localObject1 = localCursor.getString(i3);
            continue;
            if (l != 0L) {
              this.b.a("links_index_start", l);
            }
            localSQLiteDatabase.setTransactionSuccessful();
            localCursor.close();
            k = i;
            m = j;
            if (localSQLiteDatabase.inTransaction())
            {
              localSQLiteDatabase.endTransaction();
              m = j;
              k = i;
            }
            Log.d("linkmsgstore/added:" + k);
            return m;
          }
        }
        finally
        {
          localCursor.close();
          if (localSQLiteDatabase.inTransaction()) {
            localSQLiteDatabase.endTransaction();
          }
        }
        continue;
      }
      finally
      {
        this.e.unlock();
      }
      j += 1;
      int i = k;
    }
  }
  
  public final boolean b()
  {
    return this.b.b("links_ready") != 0L;
  }
  
  public final void c()
  {
    long l1 = this.c.length();
    Log.i("linkmsgstore/populate/beging/db size:" + l1 + " start:" + this.b.b("fts_index_start"));
    bd localbd = new bd("msgstore/fts/populate");
    while (d() == 2048) {}
    Log.i("linkmsgstore/populate time spent:" + localbd.b());
    this.b.a("links_ready", 1);
    this.b.a("links_version", 1);
    long l2 = this.c.length();
    Log.i("linkmsgstore/populate/end/db size:" + l2 + " increase:" + l2 / l1);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/data/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */