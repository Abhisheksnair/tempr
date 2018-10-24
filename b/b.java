package com.whatsapp.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.whatsapp.util.Log;
import java.io.File;
import java.util.Locale;

public final class b
{
  public a a;
  
  public b(Context paramContext)
  {
    this.a = new a(paramContext);
  }
  
  public final void a(Locale paramLocale, String paramString)
  {
    long l = System.currentTimeMillis() / 1000L;
    SQLiteDatabase localSQLiteDatabase = this.a.getWritableDatabase();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("timestamp", Long.valueOf(l));
    if (localSQLiteDatabase.update("packs", localContentValues, "lg = ? AND lc = ? AND namespace = ?", new String[] { paramLocale.getLanguage(), paramLocale.getCountry(), paramString }) > 0) {
      Log.i("language-pack-store/touch-language-pack updated timestamp for " + paramLocale + " ns=" + paramString);
    }
  }
  
  public final void a(Locale paramLocale, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    long l = System.currentTimeMillis() / 1000L;
    SQLiteDatabase localSQLiteDatabase = this.a.getWritableDatabase();
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      paramString1 = new byte[0];
    }
    paramArrayOfByte = new ContentValues();
    paramArrayOfByte.put("lg", paramLocale.getLanguage());
    paramArrayOfByte.put("lc", paramLocale.getCountry());
    paramArrayOfByte.put("hash", str);
    paramArrayOfByte.put("namespace", paramString2);
    paramArrayOfByte.put("timestamp", Long.valueOf(l));
    paramArrayOfByte.put("data", paramString1);
    localSQLiteDatabase.replaceOrThrow("packs", null, paramArrayOfByte);
    Log.i("language-pack-store/save-language-pack saved pack " + paramLocale + " (" + str + ") ns=" + paramString2);
  }
  
  public final boolean a()
  {
    boolean bool = false;
    Log.i("language-pack-store/delete-unused-language-packs");
    long l2 = System.currentTimeMillis();
    long l1 = (l2 - 2592000000L) / 1000L;
    l2 = (l2 - 5184000000L) / 1000L;
    SQLiteDatabase localSQLiteDatabase = this.a.getWritableDatabase();
    localSQLiteDatabase.beginTransaction();
    try
    {
      int i = localSQLiteDatabase.delete("packs", "length(data) == 0 AND timestamp < ?", new String[] { Long.toString(l1) });
      int j = localSQLiteDatabase.delete("packs", "length(data) > 0 AND timestamp < ?", new String[] { Long.toString(l2) });
      localSQLiteDatabase.setTransactionSuccessful();
      localSQLiteDatabase.endTransaction();
      if ((i > 0) || (j > 0))
      {
        Log.i("language-pack-store/delete-unused-language-packs empty=" + i + " unused=" + j);
        bool = true;
      }
      return bool;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
  }
  
  public static final class a
    extends SQLiteOpenHelper
  {
    private Context a;
    
    public a(Context paramContext)
    {
      super("hsmpacks.db", null, 2);
      this.a = paramContext;
    }
    
    private void a()
    {
      try
      {
        close();
        Log.i("deleting HSM pack database...");
        boolean bool1 = b().delete();
        File localFile = b();
        boolean bool2 = new File(localFile.getPath(), localFile.getName() + "-journal").delete();
        localFile = b();
        boolean bool3 = new File(localFile.getPath(), localFile.getName() + "-wal").delete();
        Log.i("deleted HSM pack database; databaseDeleted=" + bool1 + "; journalDeleted=" + bool2 + "; writeAheadLogDeleted=" + bool3);
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    private File b()
    {
      return this.a.getDatabasePath("hsmpacks.db");
    }
    
    public final SQLiteDatabase getReadableDatabase()
    {
      try
      {
        SQLiteDatabase localSQLiteDatabase = super.getReadableDatabase();
        return localSQLiteDatabase;
      }
      catch (SQLiteException localSQLiteException)
      {
        Log.d("failed to open pack store", localSQLiteException);
        a();
      }
      return super.getReadableDatabase();
    }
    
    public final SQLiteDatabase getWritableDatabase()
    {
      try
      {
        SQLiteDatabase localSQLiteDatabase = super.getWritableDatabase();
        return localSQLiteDatabase;
      }
      catch (SQLiteException localSQLiteException)
      {
        Log.d("failed to open pack store", localSQLiteException);
        a();
      }
      return super.getWritableDatabase();
    }
    
    public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS packs");
      paramSQLiteDatabase.execSQL("CREATE TABLE packs (_id INTEGER PRIMARY KEY AUTOINCREMENT, lg TEXT NOT NULL, lc TEXT NOT NULL, hash TEXT NOT NULL, namespace TEXT NOT NULL, timestamp INTEGER NOT NULL, data BLOB NOT NULL)");
      paramSQLiteDatabase.execSQL("CREATE UNIQUE INDEX pack_index ON packs (lg, lc, namespace)");
    }
    
    public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      Log.i("language-pack-store/downgrade from " + paramInt1 + " to " + paramInt2);
      onCreate(paramSQLiteDatabase);
    }
    
    public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      Log.i("language-pack-store/upgrade from " + paramInt1 + " to " + paramInt2);
      switch (paramInt1)
      {
      default: 
        Log.e("language-pack-store/upgrade unknown old version");
        onCreate(paramSQLiteDatabase);
        return;
      }
      onCreate(paramSQLiteDatabase);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */