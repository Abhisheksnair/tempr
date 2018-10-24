package com.whatsapp.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.whatsapp.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

public class cj
{
  private static volatile cj a;
  private final Map<String, String> b = new HashMap();
  private final n c;
  private final ReentrantReadWriteLock.ReadLock d;
  
  private cj(ch paramch)
  {
    this.c = paramch.a;
    this.d = paramch.b.readLock();
  }
  
  public static cj a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new cj(ch.a());
      }
      return a;
    }
    finally {}
  }
  
  final String a(String paramString)
  {
    if (this.b.containsKey(paramString)) {
      return (String)this.b.get(paramString);
    }
    this.d.lock();
    Object localObject1 = null;
    Object localObject2 = null;
    try
    {
      Cursor localCursor = this.c.getReadableDatabase().rawQuery("SELECT value FROM props WHERE key=?", new String[] { paramString });
      if (localCursor != null)
      {
        localObject1 = localObject2;
        if (localCursor.moveToNext()) {
          localObject1 = localCursor.getString(0);
        }
        localCursor.close();
      }
      this.b.put(paramString, localObject1);
      Log.i("propsmsgstore/getprop " + paramString + ":" + (String)localObject1);
      return (String)localObject1;
    }
    finally
    {
      this.d.unlock();
    }
  }
  
  public final void a(String paramString, int paramInt)
  {
    a(paramString, String.valueOf(paramInt));
  }
  
  final void a(String paramString, long paramLong)
  {
    a(paramString, String.valueOf(paramLong));
  }
  
  public final void a(String paramString1, String paramString2)
  {
    Log.i("propsmsgstore/setprop " + paramString1 + ":" + paramString2);
    SQLiteDatabase localSQLiteDatabase = this.c.getWritableDatabase();
    ContentValues localContentValues = new ContentValues(2);
    localContentValues.put("key", paramString1);
    localContentValues.put("value", paramString2);
    localSQLiteDatabase.replaceOrThrow("props", null, localContentValues);
    this.b.put(paramString1, paramString2);
  }
  
  public final long b(String paramString)
  {
    paramString = a(paramString);
    if (paramString == null) {
      return 0L;
    }
    return Long.parseLong(paramString);
  }
  
  final void c(String paramString)
  {
    Log.i("propsmsgstore/deleteprop " + paramString);
    this.c.getWritableDatabase().delete("props", "key=?", new String[] { paramString });
    this.b.remove(paramString);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/data/cj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */