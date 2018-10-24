package com.whatsapp.data;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.whatsapp.util.Log;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

public class cn
{
  private static volatile cn n;
  private static final String o = "UPDATE messages SET status=?, needs_push=?, data=?, raw_data=?, timestamp=?, media_url=?, media_mime_type=?, media_wa_type=?, media_size=?, media_name=?, media_caption=?, media_hash=?, media_duration=?, origin=?, latitude=?, longitude=?, mentioned_jids=?, thumb_image=?, media_enc_hash=? WHERE needs_push=" + Integer.toString(2) + " AND key_from_me=1 AND key_id=?";
  boolean a;
  SQLiteStatement b;
  SQLiteStatement c;
  SQLiteStatement d;
  SQLiteStatement e;
  public SQLiteStatement f;
  public SQLiteStatement g;
  SQLiteStatement h;
  SQLiteStatement i;
  SQLiteStatement j;
  SQLiteStatement k;
  SQLiteStatement l;
  SQLiteStatement m;
  private final n p;
  private final ReentrantReadWriteLock.ReadLock q;
  private SQLiteStatement r;
  private SQLiteStatement s;
  
  private cn(ch paramch)
  {
    this.p = paramch.a;
    this.q = paramch.b.readLock();
  }
  
  private SQLiteStatement a(SQLiteStatement paramSQLiteStatement, String paramString)
  {
    if (paramSQLiteStatement != null) {
      paramSQLiteStatement.close();
    }
    return this.p.getWritableDatabase().compileStatement(paramString);
  }
  
  public static cn a()
  {
    if (n == null) {}
    try
    {
      if (n == null) {
        n = new cn(ch.a());
      }
      return n;
    }
    finally {}
  }
  
  public final void b()
  {
    if (this.a) {
      return;
    }
    this.q.lock();
    try
    {
      boolean bool = this.a;
      if (bool) {
        return;
      }
      Log.i("statementsmanager/preparestatements");
      SQLiteDatabase localSQLiteDatabase = this.p.getWritableDatabase();
      if (localSQLiteDatabase == null)
      {
        Log.e("statementsmanager/preparestatements/failed-to-get-database");
        return;
      }
      this.b = localSQLiteDatabase.compileStatement("INSERT INTO messages (key_remote_jid, key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, received_timestamp, send_timestamp, receipt_server_timestamp, receipt_device_timestamp, raw_data, participant_hash, recipient_count, quoted_row_id, mentioned_jids, multicast_id, edit_version, media_enc_hash) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, -1, -1, -1, ?, ?, ?, ?, ?, ?, ?, ?)");
      this.c = localSQLiteDatabase.compileStatement("INSERT INTO messages_quotes (key_remote_jid, key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, received_timestamp, send_timestamp, receipt_server_timestamp, receipt_device_timestamp, raw_data, participant_hash, recipient_count, quoted_row_id, mentioned_jids, multicast_id, edit_version, media_enc_hash) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, -1, -1, -1, ?, ?, ?, ?, ?, ?, ?, ?)");
      this.r = localSQLiteDatabase.compileStatement("UPDATE messages SET status=?, send_timestamp=?, recipient_count=?, remote_resource=? WHERE key_remote_jid=? AND key_from_me=? AND key_id=?");
      this.d = localSQLiteDatabase.compileStatement("UPDATE messages SET status=?, receipt_server_timestamp=?, recipient_count=? WHERE key_remote_jid=? AND key_from_me=? AND key_id=?");
      this.e = localSQLiteDatabase.compileStatement("UPDATE messages SET status=?, receipt_server_timestamp=?, recipient_count=? WHERE timestamp=? AND key_from_me=? AND key_id=?");
      this.f = localSQLiteDatabase.compileStatement("UPDATE messages SET status=? WHERE key_remote_jid=? AND key_from_me=? AND key_id=?");
      this.g = localSQLiteDatabase.compileStatement("UPDATE messages SET status=?, played_device_timestamp=? WHERE key_remote_jid=? AND key_from_me=? AND key_id=?");
      this.h = localSQLiteDatabase.compileStatement("UPDATE messages SET status=?, needs_push=?, data=?, raw_data=?, timestamp=?, media_url=?, media_mime_type=?, media_wa_type=?, media_size=?, media_name=?, media_caption=?, media_hash=?, media_duration=?, origin=?, latitude=?, longitude=?, mentioned_jids=?, thumb_image=?, edit_version=?, media_enc_hash=? WHERE key_remote_jid=? AND key_from_me=? AND key_id=?");
      this.i = localSQLiteDatabase.compileStatement(o);
      this.s = localSQLiteDatabase.compileStatement("SELECT _id FROM messages WHERE key_remote_jid=? AND key_from_me=? AND key_id=?");
      this.j = localSQLiteDatabase.compileStatement("INSERT INTO media_refs (path, ref_count) VALUES (?, ?)");
      this.k = localSQLiteDatabase.compileStatement("UPDATE media_refs SET ref_count=? WHERE path=?");
      this.l = localSQLiteDatabase.compileStatement("DELETE FROM media_refs WHERE path=?");
      this.m = localSQLiteDatabase.compileStatement("UPDATE messages SET key_id=?, status=?, needs_push=?, data=?, raw_data=?, timestamp=?, media_url=?, media_mime_type=?, media_wa_type=?, media_size=?, media_name=?, media_caption=?, media_hash=?, media_duration=?, origin=?, latitude=?, longitude=?, mentioned_jids=?, thumb_image=?, edit_version=?, media_enc_hash=? WHERE key_remote_jid=? AND key_from_me=? AND key_id=?");
      this.a = true;
      return;
    }
    finally
    {
      this.q.unlock();
    }
  }
  
  final void c()
  {
    Log.i("statementsmanager/resetstatements");
    this.q.lock();
    try
    {
      this.b = a(this.b, "INSERT INTO messages (key_remote_jid, key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, received_timestamp, send_timestamp, receipt_server_timestamp, receipt_device_timestamp, raw_data, participant_hash, recipient_count, quoted_row_id, mentioned_jids, multicast_id, edit_version, media_enc_hash) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, -1, -1, -1, ?, ?, ?, ?, ?, ?, ?, ?)");
      this.c = a(this.c, "INSERT INTO messages_quotes (key_remote_jid, key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_caption, media_hash, media_duration, origin, latitude, longitude, thumb_image, remote_resource, received_timestamp, send_timestamp, receipt_server_timestamp, receipt_device_timestamp, raw_data, participant_hash, recipient_count, quoted_row_id, mentioned_jids, multicast_id, edit_version, media_enc_hash) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, -1, -1, -1, ?, ?, ?, ?, ?, ?, ?, ?)");
      this.r = a(this.r, "UPDATE messages SET status=?, send_timestamp=?, recipient_count=?, remote_resource=? WHERE key_remote_jid=? AND key_from_me=? AND key_id=?");
      this.d = a(this.d, "UPDATE messages SET status=?, receipt_server_timestamp=?, recipient_count=? WHERE key_remote_jid=? AND key_from_me=? AND key_id=?");
      this.e = a(this.e, "UPDATE messages SET status=?, receipt_server_timestamp=?, recipient_count=? WHERE timestamp=? AND key_from_me=? AND key_id=?");
      this.f = a(this.f, "UPDATE messages SET status=? WHERE key_remote_jid=? AND key_from_me=? AND key_id=?");
      this.g = a(this.g, "UPDATE messages SET status=?, played_device_timestamp=? WHERE key_remote_jid=? AND key_from_me=? AND key_id=?");
      this.h = a(this.h, "UPDATE messages SET status=?, needs_push=?, data=?, raw_data=?, timestamp=?, media_url=?, media_mime_type=?, media_wa_type=?, media_size=?, media_name=?, media_caption=?, media_hash=?, media_duration=?, origin=?, latitude=?, longitude=?, mentioned_jids=?, thumb_image=?, edit_version=?, media_enc_hash=? WHERE key_remote_jid=? AND key_from_me=? AND key_id=?");
      this.i = a(this.i, o);
      this.s = a(this.s, "SELECT _id FROM messages WHERE key_remote_jid=? AND key_from_me=? AND key_id=?");
      this.j = a(this.j, "INSERT INTO media_refs (path, ref_count) VALUES (?, ?)");
      this.k = a(this.k, "UPDATE media_refs SET ref_count=? WHERE path=?");
      this.l = a(this.l, "DELETE FROM media_refs WHERE path=?");
      this.m = a(this.m, "UPDATE messages SET key_id=?, status=?, needs_push=?, data=?, raw_data=?, timestamp=?, media_url=?, media_mime_type=?, media_wa_type=?, media_size=?, media_name=?, media_caption=?, media_hash=?, media_duration=?, origin=?, latitude=?, longitude=?, mentioned_jids=?, thumb_image=?, edit_version=?, media_enc_hash=? WHERE key_remote_jid=? AND key_from_me=? AND key_id=?");
      this.q.unlock();
      this.a = true;
      return;
    }
    finally
    {
      this.q.unlock();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/data/cn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */