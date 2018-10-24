package com.whatsapp.gcm.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.whatsapp.u;

public final class g
  extends SQLiteOpenHelper
{
  public static final String a = a(2);
  
  public g(Context paramContext)
  {
    super(paramContext, a, null, 2);
  }
  
  private static String a(int paramInt)
  {
    return "NetworkTimeline.db." + paramInt;
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE network_timeline (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,timestamp LONG, extra_data TEXT, reason INTEGER)");
    int i = 1;
    while (i < 2)
    {
      u.a().deleteDatabase(a(1));
      i += 1;
    }
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS network_timeline");
    onCreate(paramSQLiteDatabase);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gcm/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */