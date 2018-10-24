package com.whatsapp.messaging;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.whatsapp.data.k;
import com.whatsapp.data.n;
import com.whatsapp.util.Log;

public class i
{
  private static volatile i a;
  private final k b;
  
  private i(k paramk)
  {
    this.b = paramk;
  }
  
  public static i a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new i(k.a());
      }
      return a;
    }
    finally {}
  }
  
  public final h a(String paramString)
  {
    return this.b.a(paramString);
  }
  
  public final boolean a(h paramh)
  {
    if (paramh.a())
    {
      k.a(this.b.a.getWritableDatabase(), paramh.a);
      return true;
    }
    return false;
  }
  
  public final void b(h paramh)
  {
    ContentValues localContentValues;
    if (this.b.a(paramh.a) == null)
    {
      localSQLiteDatabase = this.b.a.getWritableDatabase();
      try
      {
        localContentValues = new ContentValues(4);
        localContentValues.put("key_remote_jid", paramh.a);
        localContentValues.put("source", paramh.c);
        localContentValues.put("data", paramh.b);
        localContentValues.put("last_interaction", Long.valueOf(paramh.d));
        localSQLiteDatabase.insert("conversion_tuples", null, localContentValues);
        return;
      }
      catch (Exception paramh)
      {
        Log.d("conversiontuplemsgstore/insertConversionTuple error accessing db", paramh);
        return;
      }
    }
    SQLiteDatabase localSQLiteDatabase = this.b.a.getWritableDatabase();
    try
    {
      localContentValues = new ContentValues(3);
      localContentValues.put("source", paramh.c);
      localContentValues.put("data", paramh.b);
      localContentValues.put("last_interaction", Long.valueOf(paramh.d));
      localSQLiteDatabase.update("conversion_tuples", localContentValues, "key_remote_jid=?", new String[] { paramh.a });
      return;
    }
    catch (Exception paramh)
    {
      Log.d("conversiontuplemsgstore/updateConversionTuple error accessing db", paramh);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/messaging/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */