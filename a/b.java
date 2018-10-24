package com.whatsapp.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import com.whatsapp.atv;
import com.whatsapp.util.Log;
import com.whatsapp.util.a;
import java.util.Iterator;
import java.util.List;
import org.whispersystems.a.e;
import org.whispersystems.a.h.h;

public final class b
  extends SQLiteOpenHelper
{
  private final c a;
  
  public b(Context paramContext, c paramc)
  {
    super(paramContext, "axolotl.db", null, 7);
    this.a = paramc;
    if ((Build.VERSION.SDK_INT >= 16) && (!a.a())) {
      setWriteAheadLoggingEnabled(true);
    }
  }
  
  static void a(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    if (paramInt > 50) {
      throw new IllegalArgumentException("Too many keys generated at once; requested=" + paramInt + "; max=50");
    }
    paramSQLiteDatabase.beginTransaction();
    try
    {
      Cursor localCursor = paramSQLiteDatabase.query("identities", new String[] { "next_prekey_id" }, "recipient_id = ?", new String[] { "-1" }, null, null, null);
      if (!localCursor.moveToNext())
      {
        localCursor.close();
        throw new SQLiteException("Missing entry for self in identities table");
      }
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
    int i = ((Cursor)localObject1).getInt(0);
    ((Cursor)localObject1).close();
    Log.i("axolotl generating " + paramInt + " new prekeys starting from " + i + " and recording them in the db");
    Object localObject2 = a.a.a.a.d.c(i, paramInt);
    ContentValues localContentValues = new ContentValues();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      org.whispersystems.a.h.c localc = (org.whispersystems.a.h.c)((Iterator)localObject2).next();
      localContentValues.clear();
      localContentValues.put("prekey_id", Integer.valueOf(localc.a()));
      localContentValues.put("record", localc.c());
      localContentValues.put("sent_to_server", Boolean.valueOf(false));
      paramSQLiteDatabase.insertOrThrow("prekeys", null, localContentValues);
    }
    Log.i("axolotl generated " + paramInt + " new prekeys and recorded them in the db");
    localContentValues.clear();
    localContentValues.put("next_prekey_id", Integer.valueOf((i + paramInt) % (org.whispersystems.a.i.b.a - 1) + 1));
    paramSQLiteDatabase.update("identities", localContentValues, "recipient_id = ?", new String[] { "-1" });
    paramSQLiteDatabase.setTransactionSuccessful();
    paramSQLiteDatabase.endTransaction();
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
      Log.d("failed to open axolotl store", localSQLiteException);
      this.a.d();
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
      Log.d("failed to open axolotl store", localSQLiteException);
      this.a.d();
    }
    return super.getWritableDatabase();
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    Log.i("creating axolotl database version 7");
    paramSQLiteDatabase.execSQL("CREATE TABLE identities (_id INTEGER PRIMARY KEY AUTOINCREMENT, recipient_id INTEGER UNIQUE, registration_id INTEGER, public_key BLOB, private_key BLOB, next_prekey_id INTEGER, timestamp INTEGER)");
    paramSQLiteDatabase.execSQL("CREATE TABLE prekeys (_id INTEGER PRIMARY KEY AUTOINCREMENT, prekey_id INTEGER UNIQUE, sent_to_server BOOLEAN, record BLOB)");
    paramSQLiteDatabase.execSQL("CREATE TABLE sessions (_id INTEGER PRIMARY KEY AUTOINCREMENT, recipient_id INTEGER UNIQUE, record BLOB, timestamp INTEGER)");
    paramSQLiteDatabase.execSQL("CREATE TABLE signed_prekeys (_id INTEGER PRIMARY KEY AUTOINCREMENT, prekey_id INTEGER UNIQUE, timestamp INTEGER, record BLOB)");
    paramSQLiteDatabase.execSQL("CREATE TABLE message_base_key (_id INTEGER PRIMARY KEY AUTOINCREMENT, msg_key_remote_jid TEXT NOT NULL, msg_key_from_me BOOLEAN NOT NULL, msg_key_id TEXT NOT NULL, last_alice_base_key BLOB NOT NULL, timestamp INTEGER)");
    paramSQLiteDatabase.execSQL("CREATE UNIQUE INDEX message_base_key_idx ON message_base_key (msg_key_remote_jid, msg_key_from_me, msg_key_id)");
    paramSQLiteDatabase.execSQL("CREATE TABLE sender_keys (_id INTEGER PRIMARY KEY AUTOINCREMENT, group_id TEXT NOT NULL, sender_id INTEGER NOT NULL, record BLOB NOT NULL)");
    paramSQLiteDatabase.execSQL("CREATE UNIQUE INDEX sender_keys_idx ON sender_keys (group_id, sender_id)");
    paramSQLiteDatabase.execSQL("CREATE TABLE fast_ratchet_sender_keys (_id INTEGER PRIMARY KEY AUTOINCREMENT, group_id TEXT NOT NULL, sender_id INTEGER NOT NULL, record BLOB NOT NULL)");
    paramSQLiteDatabase.execSQL("CREATE UNIQUE INDEX fast_ratchet_sender_keys_idx ON fast_ratchet_sender_keys (group_id, sender_id)");
    Log.i("created axolotl database version 7");
    Object localObject = a.a.a.a.d.o();
    localObject = new org.whispersystems.a.d(new org.whispersystems.a.c(((org.whispersystems.a.a.b)localObject).a()), ((org.whispersystems.a.a.b)localObject).b());
    ContentValues localContentValues = new ContentValues();
    long l = System.currentTimeMillis() / 1000L;
    localContentValues.put("recipient_id", Integer.valueOf(-1));
    localContentValues.put("registration_id", Integer.valueOf(a.a.a.a.d.q()));
    localContentValues.put("public_key", ((org.whispersystems.a.d)localObject).a().b());
    localContentValues.put("private_key", ((org.whispersystems.a.d)localObject).b().a());
    localContentValues.put("next_prekey_id", Integer.valueOf(a.a.a.a.d.h(org.whispersystems.a.i.b.a - 1) + 1));
    localContentValues.put("timestamp", Long.valueOf(l));
    paramSQLiteDatabase.insertOrThrow("identities", null, localContentValues);
    Log.i("axolotl inserted identity key pair");
    try
    {
      localObject = a.a.a.a.d.a((org.whispersystems.a.d)localObject, 0);
      localContentValues = new ContentValues();
      localContentValues.put("prekey_id", Integer.valueOf(0));
      localContentValues.put("timestamp", Long.valueOf(l));
      localContentValues.put("record", ((h)localObject).b());
      paramSQLiteDatabase.insertOrThrow("signed_prekeys", null, localContentValues);
      Log.i("axolotl inserted signed prekey");
      this.a.b();
      this.a.b.f(true);
      return;
    }
    catch (e paramSQLiteDatabase)
    {
      throw new RuntimeException(paramSQLiteDatabase);
    }
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
    Log.i("axolotl upgrading db from " + paramInt1 + " to " + paramInt2);
    if (paramInt2 != 7) {
      throw new SQLiteException("Unknown upgrade destination version: " + paramInt1 + " -> " + paramInt2);
    }
    long l = System.currentTimeMillis() / 1000L;
    switch (paramInt1)
    {
    default: 
      throw new SQLiteException("Unknown upgrade from " + paramInt1 + " to " + paramInt2);
    case 1: 
      paramSQLiteDatabase.execSQL("ALTER TABLE sessions ADD COLUMN timestamp INTEGER");
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("timestamp", Long.valueOf(l));
      paramSQLiteDatabase.update("sessions", localContentValues, null, null);
    case 2: 
      paramSQLiteDatabase.execSQL("CREATE TABLE message_base_key (_id INTEGER PRIMARY KEY AUTOINCREMENT, msg_key_remote_jid TEXT NOT NULL, msg_key_from_me BOOLEAN NOT NULL, msg_key_id TEXT NOT NULL, last_alice_base_key BLOB NOT NULL, timestamp INTEGER)");
      paramSQLiteDatabase.execSQL("CREATE UNIQUE INDEX message_base_key_idx ON message_base_key (msg_key_remote_jid, msg_key_from_me, msg_key_id)");
    case 3: 
    case 4: 
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS sender_keys");
      paramSQLiteDatabase.execSQL("CREATE TABLE sender_keys (_id INTEGER PRIMARY KEY AUTOINCREMENT, group_id TEXT NOT NULL, sender_id INTEGER NOT NULL, record BLOB NOT NULL)");
      paramSQLiteDatabase.execSQL("CREATE UNIQUE INDEX sender_keys_idx ON sender_keys (group_id, sender_id)");
    case 5: 
      paramSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS sender_keys_idx ON sender_keys (group_id, sender_id)");
    }
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS fast_ratchet_sender_keys");
    paramSQLiteDatabase.execSQL("CREATE TABLE fast_ratchet_sender_keys (_id INTEGER PRIMARY KEY AUTOINCREMENT, group_id TEXT NOT NULL, sender_id INTEGER NOT NULL, record BLOB NOT NULL)");
    paramSQLiteDatabase.execSQL("CREATE UNIQUE INDEX fast_ratchet_sender_keys_idx ON fast_ratchet_sender_keys (group_id, sender_id)");
    Log.i("axolotl upgraded successfully");
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */