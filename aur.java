package com.whatsapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.whatsapp.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class aur
{
  private static aur b;
  private static final Object c = new Object();
  a a;
  
  private aur(Context paramContext)
  {
    this.a = new a(paramContext);
  }
  
  public static aur a(Context paramContext)
  {
    if (b == null) {}
    synchronized (c)
    {
      if (b == null) {
        b = new aur(paramContext);
      }
      return b;
    }
  }
  
  public final List<b> a()
  {
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.a.getReadableDatabase().query("sessions", new String[] { "browser_id", "secret", "token", "os", "browser_type", "lat", "lon", "accuracy", "place_name", "last_active", "timeout", "expiration", "fservice" }, null, null, null, null, null);
    if (localCursor != null) {
      for (;;)
      {
        try
        {
          if (!localCursor.moveToNext()) {
            break label335;
          }
          b localb = new b();
          localb.a = localCursor.getString(0);
          localb.b = localCursor.getString(1);
          localb.c = localCursor.getString(2);
          localb.d = localCursor.getString(3);
          localb.e = localCursor.getString(4);
          localb.f = localCursor.getDouble(5);
          localb.g = localCursor.getDouble(6);
          localb.h = localCursor.getDouble(7);
          localb.i = localCursor.getString(8);
          localb.j = localCursor.getLong(9);
          if (localCursor.getInt(10) > 0)
          {
            bool = true;
            localb.k = bool;
            localb.l = localCursor.getLong(11);
            if (localCursor.getInt(12) <= 0) {
              break label330;
            }
            bool = true;
            localb.m = bool;
            localArrayList.add(localb);
            break;
          }
        }
        finally
        {
          if (localCursor != null) {
            localCursor.close();
          }
        }
        boolean bool = false;
        continue;
        label330:
        bool = false;
      }
    }
    label335:
    if (localCursor != null) {
      localCursor.close();
    }
    return localList;
  }
  
  static final class a
    extends SQLiteOpenHelper
  {
    private final Context a;
    
    a(Context paramContext)
    {
      super("web_sessions.db", null, 3);
      this.a = paramContext;
    }
    
    private boolean a()
    {
      try
      {
        close();
        Log.i("websessionstore/delete-database");
        boolean bool = b().delete();
        File localFile = b();
        new File(localFile.getPath(), localFile.getName() + "-journal").delete();
        Log.i("websessionstore/delete-database/result=" + bool);
        return bool;
      }
      finally {}
    }
    
    private File b()
    {
      return this.a.getDatabasePath("web_sessions.db");
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
        Log.w("websessionstore/corrupt/removing");
        a();
        return super.getReadableDatabase();
      }
      catch (SQLiteException localSQLiteException)
      {
        localObject = localSQLiteException.toString();
        if (((String)localObject).contains("file is encrypted"))
        {
          Log.w("websessionstore/encrypted/removing");
          a();
          return super.getReadableDatabase();
        }
        if (((String)localObject).contains("upgrade read-only database"))
        {
          Log.w("websessionstore/switching-to-writable");
          return getWritableDatabase();
        }
        throw localSQLiteException;
      }
      catch (StackOverflowError localStackOverflowError)
      {
        Log.w("websessionstore/stackoverflowerror");
        Object localObject = localStackOverflowError.getStackTrace();
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          if (localObject[i].getMethodName().equals("onCorruption"))
          {
            Log.w("websessionstore/stackoverflowerror/corrupt/removing");
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
        Log.w("websessionstore/corrupt/removing");
        a();
        return super.getWritableDatabase();
      }
      catch (SQLiteException localSQLiteException)
      {
        if (localSQLiteException.toString().contains("file is encrypted"))
        {
          Log.w("websessionstore/encrypted/removing");
          a();
          return super.getWritableDatabase();
        }
        throw localSQLiteException;
      }
      catch (StackOverflowError localStackOverflowError)
      {
        Log.w("websessionstore/stackoverflowerror");
        StackTraceElement[] arrayOfStackTraceElement = localStackOverflowError.getStackTrace();
        int j = arrayOfStackTraceElement.length;
        int i = 0;
        while (i < j)
        {
          if (arrayOfStackTraceElement[i].getMethodName().equals("onCorruption"))
          {
            Log.w("websessionstore/stackoverflowerror/corrupt/removing");
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
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS sessions");
      paramSQLiteDatabase.execSQL("CREATE TABLE sessions (_id INTEGER PRIMARY KEY AUTOINCREMENT,browser_id TEXT,secret TEXT,token TEXT,os TEXT,browser_type TEXT,lat REAL,lon REAL,accuracy REAL,place_name TEXT,last_active INTEGER,timeout BOOLEAN,expiration INTEGER,fservice BOOLEAN);");
      paramSQLiteDatabase.execSQL("CREATE UNIQUE INDEX browser_id_index ON sessions(browser_id);");
    }
    
    public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      Log.i("websessionstore/downgrade from " + paramInt1 + " to " + paramInt2);
      onCreate(paramSQLiteDatabase);
    }
    
    /* Error */
    public final void onOpen(SQLiteDatabase paramSQLiteDatabase)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_3
      //   2: aload_1
      //   3: invokevirtual 162	android/database/sqlite/SQLiteDatabase:getVersion	()I
      //   6: iconst_3
      //   7: if_icmpne +91 -> 98
      //   10: aload_1
      //   11: ldc -92
      //   13: aconst_null
      //   14: invokevirtual 168	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
      //   17: astore 4
      //   19: aload 4
      //   21: invokeinterface 173 1 0
      //   26: ifeq +60 -> 86
      //   29: aload 4
      //   31: iconst_0
      //   32: invokeinterface 177 2 0
      //   37: ldc -77
      //   39: invokevirtual 102	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   42: ifeq +44 -> 86
      //   45: aload_1
      //   46: invokevirtual 182	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
      //   49: aload_1
      //   50: ldc -72
      //   52: invokevirtual 140	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
      //   55: aload_1
      //   56: ldc -70
      //   58: invokevirtual 140	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
      //   61: aload_0
      //   62: aload_1
      //   63: invokevirtual 155	com/whatsapp/aur$a:onCreate	(Landroid/database/sqlite/SQLiteDatabase;)V
      //   66: aload_1
      //   67: ldc -68
      //   69: invokevirtual 140	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
      //   72: aload_1
      //   73: ldc -66
      //   75: invokevirtual 140	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
      //   78: aload_1
      //   79: invokevirtual 193	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
      //   82: aload_1
      //   83: invokevirtual 196	android/database/sqlite/SQLiteDatabase:endTransaction	()V
      //   86: aload 4
      //   88: ifnull +10 -> 98
      //   91: aload 4
      //   93: invokeinterface 197 1 0
      //   98: return
      //   99: astore_2
      //   100: aload_1
      //   101: invokevirtual 196	android/database/sqlite/SQLiteDatabase:endTransaction	()V
      //   104: aload_2
      //   105: athrow
      //   106: astore_1
      //   107: aload_1
      //   108: athrow
      //   109: astore_2
      //   110: aload_1
      //   111: astore_3
      //   112: aload_2
      //   113: astore_1
      //   114: aload 4
      //   116: ifnull +14 -> 130
      //   119: aload_3
      //   120: ifnull +12 -> 132
      //   123: aload 4
      //   125: invokeinterface 197 1 0
      //   130: aload_1
      //   131: athrow
      //   132: aload 4
      //   134: invokeinterface 197 1 0
      //   139: goto -9 -> 130
      //   142: astore_2
      //   143: goto -13 -> 130
      //   146: astore_1
      //   147: goto -33 -> 114
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	150	0	this	a
      //   0	150	1	paramSQLiteDatabase	SQLiteDatabase
      //   99	6	2	localObject1	Object
      //   109	4	2	localObject2	Object
      //   142	1	2	localThrowable	Throwable
      //   1	119	3	localSQLiteDatabase	SQLiteDatabase
      //   17	116	4	localCursor	Cursor
      // Exception table:
      //   from	to	target	type
      //   49	82	99	finally
      //   19	49	106	java/lang/Throwable
      //   82	86	106	java/lang/Throwable
      //   100	106	106	java/lang/Throwable
      //   107	109	109	finally
      //   123	130	142	java/lang/Throwable
      //   19	49	146	finally
      //   82	86	146	finally
      //   100	106	146	finally
    }
    
    public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      Log.i("websessionstore/upgrade from " + paramInt1 + " to " + paramInt2);
      switch (paramInt1)
      {
      default: 
        Log.e("websessionstore/upgrade unknown old version");
        onCreate(paramSQLiteDatabase);
        return;
      case 1: 
        paramSQLiteDatabase.execSQL("ALTER TABLE sessions ADD timeout BOOLEAN");
        paramSQLiteDatabase.execSQL("ALTER TABLE sessions ADD expiration INTEGER");
      }
      paramSQLiteDatabase.execSQL("ALTER TABLE sessions ADD fservice BOOLEAN");
    }
  }
  
  public static final class b
  {
    String a;
    String b;
    String c;
    String d;
    String e;
    double f;
    double g;
    double h;
    String i;
    long j;
    boolean k;
    long l;
    boolean m;
    
    public b() {}
    
    public b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramString3;
      this.d = paramString4;
      this.e = paramString5;
      this.k = paramBoolean1;
      this.m = paramBoolean2;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/aur.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */