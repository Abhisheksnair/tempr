package com.whatsapp.contact.sync;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Build.VERSION;
import android.provider.ContactsContract.Data;
import com.whatsapp.atu;
import com.whatsapp.util.Log;
import java.util.HashMap;
import java.util.Map;

public final class m
{
  public final long a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  
  private m(long paramLong)
  {
    this.a = paramLong;
  }
  
  public static Map<Long, m> a(Context paramContext, atu paramatu)
  {
    HashMap localHashMap = new HashMap();
    if (paramatu.a("android.permission.READ_CONTACTS") != 0)
    {
      Log.w("returning empty name map because contact permissions are denied");
      return localHashMap;
    }
    if (Build.VERSION.SDK_INT < 11)
    {
      paramatu = new String[8];
      paramatu[0] = "raw_contact_id";
      paramatu[1] = "mimetype";
      paramatu[2] = "data1";
      paramatu[3] = "data2";
      paramatu[4] = "data3";
      paramatu[5] = "data4";
      paramatu[6] = "data7";
      paramatu[7] = "data9";
    }
    Cursor localCursor;
    for (;;)
    {
      localCursor = paramContext.getContentResolver().query(ContactsContract.Data.CONTENT_URI, paramatu, "mimetype IN (?,?,?)", new String[] { "vnd.android.cursor.item/name", "vnd.android.cursor.item/nickname", "vnd.android.cursor.item/organization" }, null);
      if (localCursor != null) {
        break;
      }
      Log.e("null cursor returned from structured name query");
      return localHashMap;
      paramatu = new String[6];
      paramatu[0] = "raw_contact_id";
      paramatu[1] = "mimetype";
      paramatu[2] = "data1";
      paramatu[3] = "data2";
      paramatu[4] = "data3";
      paramatu[5] = "data4";
    }
    int m = localCursor.getColumnIndex("raw_contact_id");
    if (m == -1)
    {
      Log.e("invalid column index for the raw contact id");
      return localHashMap;
    }
    int n = localCursor.getColumnIndex("mimetype");
    if (n == -1)
    {
      Log.e("invalid column index for the mimetype");
      return localHashMap;
    }
    int i1 = localCursor.getColumnIndex("data2");
    if (i1 == -1)
    {
      Log.e("invalid column index for the given name");
      return localHashMap;
    }
    int i2 = localCursor.getColumnIndex("data3");
    if (i2 == -1)
    {
      Log.e("invalid column index for the family name");
      return localHashMap;
    }
    int i3 = localCursor.getColumnIndex("data1");
    if (i3 == -1)
    {
      Log.e("invalid column index for the nickname");
      return localHashMap;
    }
    int i4 = localCursor.getColumnIndex("data1");
    if (i4 == -1)
    {
      Log.e("invalid column index for the company");
      return localHashMap;
    }
    int i5 = localCursor.getColumnIndex("data4");
    if (i5 == -1)
    {
      Log.e("invalid column index for the title");
      return localHashMap;
    }
    int k;
    int j;
    if (Build.VERSION.SDK_INT < 11)
    {
      k = localCursor.getColumnIndex("data7");
      if (k == -1)
      {
        Log.e("invalid column index for the phonetic given name");
        return localHashMap;
      }
      j = localCursor.getColumnIndex("data9");
      if (j == -1)
      {
        Log.e("invalid column index for the phonetic family name");
        return localHashMap;
      }
    }
    else
    {
      k = -1;
      j = -1;
    }
    for (;;)
    {
      label405:
      if (localCursor.moveToNext())
      {
        if (localCursor.isNull(m))
        {
          Log.e("null raw contact id for record; skipping");
        }
        else if (localCursor.isNull(n))
        {
          Log.e("null mimetype for record; skipping");
        }
        else
        {
          long l = localCursor.getLong(m);
          Long localLong = Long.valueOf(l);
          paramatu = (m)localHashMap.get(localLong);
          paramContext = paramatu;
          if (paramatu == null)
          {
            paramContext = new m(l);
            localHashMap.put(localLong, paramContext);
          }
          paramatu = localCursor.getString(n);
          if (paramatu == null)
          {
            Log.e("mimetype was returned as null even though cursor said it wasn't null; skipping");
          }
          else
          {
            int i = -1;
            switch (paramatu.hashCode())
            {
            }
            for (;;)
            {
              switch (i)
              {
              default: 
                Log.e("unrecognized mimetype; skipping; mimetype=" + paramatu);
                break label405;
                if (paramatu.equals("vnd.android.cursor.item/name"))
                {
                  i = 0;
                  continue;
                  if (paramatu.equals("vnd.android.cursor.item/nickname"))
                  {
                    i = 1;
                    continue;
                    if (paramatu.equals("vnd.android.cursor.item/organization")) {
                      i = 2;
                    }
                  }
                }
                break;
              }
            }
            paramContext.b = localCursor.getString(i1);
            paramContext.c = localCursor.getString(i2);
            if (Build.VERSION.SDK_INT < 11)
            {
              paramContext.h = localCursor.getString(j);
              paramContext.g = localCursor.getString(k);
              continue;
              paramContext.d = localCursor.getString(i3);
              continue;
              paramContext.e = localCursor.getString(i4);
              paramContext.f = localCursor.getString(i5);
            }
          }
        }
      }
      else
      {
        localCursor.close();
        return localHashMap;
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/contact/sync/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */