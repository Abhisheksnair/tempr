package com.whatsapp.emoji.search;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class r
  extends SQLiteOpenHelper
{
  public r(Context paramContext)
  {
    super(paramContext, "emojidictionary.db", null, 1);
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE emoji_search_tag (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, type INTEGER NOT NULL, symbol TEXT NOT NULL, tag TEXT NOT NULL)");
    paramSQLiteDatabase.execSQL("CREATE UNIQUE INDEX emoji_search_pack_index on emoji_search_tag (type, symbol, tag)");
  }
  
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS emoji_search_tag");
    onCreate(paramSQLiteDatabase);
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS emoji_search_tag");
    onCreate(paramSQLiteDatabase);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/emoji/search/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */