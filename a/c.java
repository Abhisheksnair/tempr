package com.whatsapp.a;

import a.a.a.a.a.a.d;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import com.whatsapp.aic;
import com.whatsapp.atv;
import com.whatsapp.protocol.aj;
import com.whatsapp.protocol.j.b;
import com.whatsapp.u;
import com.whatsapp.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.whispersystems.a.h.g;
import org.whispersystems.a.h.i;
import org.whispersystems.a.k;

public class c
  implements org.whispersystems.a.h.a, org.whispersystems.a.h.d, g
{
  public static final ExecutorService a = new ThreadPoolExecutor(0, 1, 300L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f.a());
  @SuppressLint({"StaticFieldLeak"})
  private static volatile c g;
  final atv b;
  public final b c;
  public final org.whispersystems.a.c.b.f d;
  public final i e;
  public final org.whispersystems.a.c.b.c f;
  private final Context h;
  
  private c(Context paramContext)
  {
    this.h = ((Context)a.d.a(paramContext));
    this.b = atv.a();
    this.c = new b(paramContext, this);
    this.d = new org.whispersystems.a.c.b.f(this.c);
    this.e = new i(this.c);
    this.f = new org.whispersystems.a.c.b.c(this.c);
  }
  
  private static a a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    org.whispersystems.a.c localc = null;
    Cursor localCursor = paramSQLiteDatabase.query("identities", new String[] { "public_key", "timestamp" }, "recipient_id = ?", new String[] { paramString }, null, null, null);
    if (!localCursor.moveToNext())
    {
      localCursor.close();
      Log.i("axolotl found no identity entry for " + paramString);
      return new a(null, null);
    }
    byte[] arrayOfByte = localCursor.getBlob(0);
    Date localDate = new Date(localCursor.getLong(1) * 1000L);
    localCursor.close();
    if (arrayOfByte != null) {}
    try
    {
      localc = new org.whispersystems.a.c(arrayOfByte);
      Log.i("axolotl found an identity entry for " + paramString + " dated " + localDate);
      return new a(localc, localDate);
    }
    catch (org.whispersystems.a.e locale)
    {
      Log.d("axolotl identity key for " + paramString + " decoded as invalid; deleting", locale);
      paramSQLiteDatabase.delete("identities", "recipient_id = ?", new String[] { paramString });
    }
    return new a(null, null);
  }
  
  public static c a()
  {
    if (g == null) {}
    try
    {
      if (g == null) {
        g = new c(u.a());
      }
      return g;
    }
    finally {}
  }
  
  public static String a(j.b paramb)
  {
    StringBuilder localStringBuilder = new StringBuilder("msg_key_remote_jid = ? AND msg_key_from_me");
    if (paramb.b) {}
    for (paramb = " != ";; paramb = " = ") {
      return paramb + "0 AND msg_key_id = ?";
    }
  }
  
  public static org.whispersystems.a.m a(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("Provided jid must not be null");
    }
    if (!paramString.endsWith("@s.whatsapp.net")) {
      throw new IllegalArgumentException("Jid " + paramString + " is not fully qualified; should end with @s.whatsapp.net");
    }
    return new org.whispersystems.a.m(paramString.substring(0, paramString.indexOf("@s.whatsapp.net")));
  }
  
  public static void a(SQLiteDatabase paramSQLiteDatabase, aj[] paramArrayOfaj, int paramInt1, int paramInt2, ContentValues paramContentValues)
  {
    StringBuilder localStringBuilder = new StringBuilder("?");
    String[] arrayOfString = new String[paramInt2 - paramInt1];
    int i = paramInt1;
    while (i < paramInt2)
    {
      arrayOfString[(i - paramInt1)] = String.valueOf(a.a.a.a.d.e(paramArrayOfaj[i].a));
      if (i != paramInt1) {
        localStringBuilder.append(",?");
      }
      i += 1;
    }
    paramInt1 = paramSQLiteDatabase.update("prekeys", paramContentValues, "prekey_id IN (" + localStringBuilder + ")", arrayOfString);
    Log.i("updated " + paramInt1 + " prekeys; values=" + paramContentValues);
  }
  
  private static void a(org.whispersystems.a.h.e parame)
  {
    parame = parame.a().a();
    if ((parame == null) || (parame.length == 0)) {
      throw new IOException("Alice base key missing from session");
    }
  }
  
  private org.whispersystems.a.h.e c(String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = this.c.getWritableDatabase();
    Object localObject = localSQLiteDatabase.query("sessions", new String[] { "record" }, "recipient_id = ?", new String[] { paramString }, null, null, null);
    if (!((Cursor)localObject).moveToNext())
    {
      ((Cursor)localObject).close();
      Log.i("axolotl cant load a session record for " + paramString);
      return new org.whispersystems.a.h.e();
    }
    byte[] arrayOfByte = ((Cursor)localObject).getBlob(0);
    ((Cursor)localObject).close();
    try
    {
      localObject = new org.whispersystems.a.h.e(arrayOfByte);
      a((org.whispersystems.a.h.e)localObject);
      return (org.whispersystems.a.h.e)localObject;
    }
    catch (IOException localIOException)
    {
      Log.d("error reading session record " + paramString + "; deleting", localIOException);
      localSQLiteDatabase.delete("sessions", "recipient_id = ?", new String[] { paramString });
    }
    return new org.whispersystems.a.h.e();
  }
  
  private boolean d(String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = this.c.getWritableDatabase();
    Cursor localCursor = localSQLiteDatabase.query("sessions", new String[] { "record" }, "recipient_id = ?", new String[] { paramString }, null, null, null);
    if (!localCursor.moveToNext())
    {
      localCursor.close();
      Log.i("axolotl has no session record for " + paramString);
      return false;
    }
    byte[] arrayOfByte = localCursor.getBlob(0);
    localCursor.close();
    try
    {
      a(new org.whispersystems.a.h.e(arrayOfByte));
      return true;
    }
    catch (IOException localIOException)
    {
      Log.d("error reading session record " + paramString + "; deleting", localIOException);
      localSQLiteDatabase.delete("sessions", "recipient_id = ?", new String[] { paramString });
    }
    return false;
  }
  
  public final org.whispersystems.a.h.c a(int paramInt)
  {
    SQLiteDatabase localSQLiteDatabase = this.c.getWritableDatabase();
    Object localObject = localSQLiteDatabase.query("prekeys", new String[] { "record" }, "prekey_id = ?", new String[] { String.valueOf(paramInt) }, null, null, null);
    if (!((Cursor)localObject).moveToNext())
    {
      ((Cursor)localObject).close();
      throw new org.whispersystems.a.f("No prekey found with id " + paramInt);
    }
    byte[] arrayOfByte = ((Cursor)localObject).getBlob(0);
    ((Cursor)localObject).close();
    try
    {
      Log.i("axolotl found a pre key with id " + paramInt);
      localObject = new org.whispersystems.a.h.c(arrayOfByte);
      return (org.whispersystems.a.h.c)localObject;
    }
    catch (IOException localIOException)
    {
      Log.d("error reading prekey " + paramInt + "; deleting", localIOException);
      localSQLiteDatabase.delete("prekeys", "prekey_id = ?", new String[] { String.valueOf(paramInt) });
      throw new org.whispersystems.a.f(localIOException);
    }
  }
  
  public final void a(j.b paramb, byte[] paramArrayOfByte)
  {
    SQLiteDatabase localSQLiteDatabase = this.c.getWritableDatabase();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("msg_key_remote_jid", paramb.a);
    localContentValues.put("msg_key_from_me", Boolean.valueOf(paramb.b));
    localContentValues.put("msg_key_id", paramb.c);
    localContentValues.put("last_alice_base_key", paramArrayOfByte);
    localContentValues.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000L));
    long l = localSQLiteDatabase.replaceOrThrow("message_base_key", null, localContentValues);
    Log.i("axolotl saved a message base key for " + paramb + " with row id " + l);
  }
  
  public final void a(String paramString, byte[] paramArrayOfByte1, byte paramByte, aj paramaj1, aj paramaj2, byte[] paramArrayOfByte2)
  {
    localObject2 = null;
    Object localObject3 = a(paramString);
    try
    {
      localObject1 = new byte[paramArrayOfByte1.length + 1];
      localObject1[0] = paramByte;
      System.arraycopy(paramArrayOfByte1, 0, localObject1, 1, paramArrayOfByte1.length);
      localObject1 = new org.whispersystems.a.c((byte[])localObject1);
    }
    catch (org.whispersystems.a.e paramArrayOfByte1)
    {
      for (;;)
      {
        k localk;
        Log.d("invalid identity key returned from server during prekey fetch; jid=" + paramString, paramArrayOfByte1);
        Object localObject1 = null;
        continue;
        try
        {
          paramArrayOfByte1 = new byte[paramaj1.b.length + 1];
          paramArrayOfByte1[0] = paramByte;
          System.arraycopy(paramaj1.b, 0, paramArrayOfByte1, 1, paramaj1.b.length);
          paramArrayOfByte1 = a.a.a.a.d.b(paramArrayOfByte1);
        }
        catch (org.whispersystems.a.e paramArrayOfByte1)
        {
          for (;;)
          {
            Log.d("invalid prekey returned from server during prekey fetch; jid=" + paramString, paramArrayOfByte1);
            paramArrayOfByte1 = null;
          }
        }
      }
    }
    localk = new k(this, this, this.e, this, (org.whispersystems.a.m)localObject3);
    if ((paramaj1 == null) || (paramaj1.b == null)) {
      paramArrayOfByte1 = null;
    }
    try
    {
      localObject3 = new byte[paramaj2.b.length + 1];
      localObject3[0] = paramByte;
      System.arraycopy(paramaj2.b, 0, localObject3, 1, paramaj2.b.length);
      localObject3 = a.a.a.a.d.b((byte[])localObject3);
      paramString = (String)localObject3;
    }
    catch (org.whispersystems.a.e locale)
    {
      for (;;)
      {
        int j;
        Log.d("invalid signed prekey returned from server during prekey fetch; jid=" + paramString, locale);
        paramString = (String)localObject2;
        continue;
        int i = a.a.a.a.d.e(paramaj1.a);
      }
    }
    j = a.a.a.a.d.f(paramArrayOfByte2);
    if (paramaj1 == null)
    {
      i = -1;
      localk.a(new org.whispersystems.a.h.b(j, i, paramArrayOfByte1, a.a.a.a.d.e(paramaj2.a), paramString, paramaj2.c, (org.whispersystems.a.c)localObject1));
      return;
    }
  }
  
  public final void a(org.whispersystems.a.m paramm, org.whispersystems.a.c paramc)
  {
    SQLiteDatabase localSQLiteDatabase = this.c.getWritableDatabase();
    paramm = paramm.a();
    org.whispersystems.a.c localc = a(localSQLiteDatabase, paramm).a;
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("recipient_id", paramm);
    if (paramc != null) {
      localContentValues.put("public_key", paramc.a().a());
    }
    for (;;)
    {
      localContentValues.put("timestamp", Long.valueOf(System.currentTimeMillis() / 1000L));
      long l = localSQLiteDatabase.replaceOrThrow("identities", null, localContentValues);
      Log.i("axolotl saved identity for " + paramm + " with resultant row id " + l);
      if (((paramc == null) && (localc != null)) || ((paramc != null) && (!paramc.equals(localc)))) {
        b.a.a.c.a().b(new com.whatsapp.g.m(paramm + "@s.whatsapp.net", localc, paramc));
      }
      return;
      localContentValues.putNull("public_key");
    }
  }
  
  /* Error */
  public final void a(org.whispersystems.a.m paramm, org.whispersystems.a.h.e parame)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 499	org/whispersystems/a/m:b	()I
    //   4: ifeq +14 -> 18
    //   7: new 241	java/lang/IllegalArgumentException
    //   10: dup
    //   11: ldc_w 501
    //   14: invokespecial 246	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   17: athrow
    //   18: aload_1
    //   19: invokevirtual 457	org/whispersystems/a/m:a	()Ljava/lang/String;
    //   22: astore 5
    //   24: aload_0
    //   25: getfield 82	com/whatsapp/a/c:c	Lcom/whatsapp/a/b;
    //   28: invokevirtual 326	com/whatsapp/a/b:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   31: astore_1
    //   32: aload_2
    //   33: invokestatic 336	com/whatsapp/a/c:a	(Lorg/whispersystems/a/h/e;)V
    //   36: aload_1
    //   37: invokevirtual 504	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   40: new 363	android/content/ContentValues
    //   43: dup
    //   44: invokespecial 364	android/content/ContentValues:<init>	()V
    //   47: astore 6
    //   49: aload 6
    //   51: ldc_w 464
    //   54: aload 5
    //   56: invokevirtual 373	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: aload 6
    //   61: ldc_w 330
    //   64: aload_2
    //   65: invokevirtual 506	org/whispersystems/a/h/e:d	()[B
    //   68: invokevirtual 392	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   71: aload_1
    //   72: ldc_w 328
    //   75: iconst_1
    //   76: anewarray 106	java/lang/String
    //   79: dup
    //   80: iconst_0
    //   81: ldc_w 508
    //   84: aastore
    //   85: ldc 112
    //   87: iconst_1
    //   88: anewarray 106	java/lang/String
    //   91: dup
    //   92: iconst_0
    //   93: aload 5
    //   95: aastore
    //   96: aconst_null
    //   97: aconst_null
    //   98: aconst_null
    //   99: invokevirtual 118	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   102: astore_2
    //   103: aload_2
    //   104: invokeinterface 124 1 0
    //   109: ifeq +94 -> 203
    //   112: aload_2
    //   113: invokeinterface 127 1 0
    //   118: new 129	java/lang/StringBuilder
    //   121: dup
    //   122: ldc_w 510
    //   125: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   128: aload 5
    //   130: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 147	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   139: aload_1
    //   140: ldc_w 328
    //   143: aload 6
    //   145: ldc 112
    //   147: iconst_1
    //   148: anewarray 106	java/lang/String
    //   151: dup
    //   152: iconst_0
    //   153: aload 5
    //   155: aastore
    //   156: invokevirtual 286	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   159: pop
    //   160: aload_1
    //   161: invokevirtual 513	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   164: aload_1
    //   165: invokevirtual 516	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   168: new 129	java/lang/StringBuilder
    //   171: dup
    //   172: ldc_w 518
    //   175: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   178: aload 5
    //   180: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 147	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   189: return
    //   190: astore_1
    //   191: new 241	java/lang/IllegalArgumentException
    //   194: dup
    //   195: ldc_w 520
    //   198: aload_1
    //   199: invokespecial 522	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   202: athrow
    //   203: aload_2
    //   204: invokeinterface 127 1 0
    //   209: invokestatic 398	java/lang/System:currentTimeMillis	()J
    //   212: ldc2_w 163
    //   215: ldiv
    //   216: lstore_3
    //   217: aload 6
    //   219: ldc 110
    //   221: lload_3
    //   222: invokestatic 403	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   225: invokevirtual 406	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   228: new 129	java/lang/StringBuilder
    //   231: dup
    //   232: ldc_w 524
    //   235: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   238: aload 5
    //   240: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: ldc_w 526
    //   246: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: lload_3
    //   250: invokevirtual 419	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   253: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 147	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   259: aload_1
    //   260: ldc_w 328
    //   263: aconst_null
    //   264: aload 6
    //   266: invokevirtual 529	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   269: pop2
    //   270: goto -110 -> 160
    //   273: astore_2
    //   274: aload_1
    //   275: invokevirtual 516	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   278: aload_2
    //   279: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	this	c
    //   0	280	1	paramm	org.whispersystems.a.m
    //   0	280	2	parame	org.whispersystems.a.h.e
    //   216	34	3	l	long
    //   22	217	5	str	String
    //   47	218	6	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   32	36	190	java/io/IOException
    //   40	160	273	finally
    //   160	164	273	finally
    //   203	270	273	finally
  }
  
  public final boolean a(org.whispersystems.a.m paramm)
  {
    Log.i("axolotl trusting " + paramm.a() + " key pair");
    return true;
  }
  
  public final boolean a(org.whispersystems.a.m paramm, j.b paramb)
  {
    StringBuilder localStringBuilder = null;
    if (paramm.b() != 0) {
      throw new IllegalArgumentException("Multiple device support not implemented");
    }
    String str1 = paramm.a();
    paramm = this.c.getWritableDatabase();
    Object localObject = a(paramb);
    String str2 = paramb.a;
    String str3 = paramb.c;
    localObject = paramm.query("message_base_key", new String[] { "last_alice_base_key" }, (String)localObject, new String[] { str2, str3 }, null, null, null);
    if (!((Cursor)localObject).moveToNext())
    {
      ((Cursor)localObject).close();
      paramm = localStringBuilder;
    }
    while (paramm == null)
    {
      Log.i("axolotl has no saved base key for " + paramb);
      return false;
      paramm = ((Cursor)localObject).getBlob(0);
      ((Cursor)localObject).close();
    }
    boolean bool = Arrays.equals(paramm, c(str1).a().a());
    localStringBuilder = new StringBuilder("axolotl has ");
    if (bool) {}
    for (paramm = "matching";; paramm = "different")
    {
      Log.i(paramm + " saved base key and session for " + paramb + " and " + str1);
      return bool;
    }
  }
  
  public final aj[] a(int[] paramArrayOfInt)
  {
    Object localObject = this.c.getWritableDatabase();
    ArrayList localArrayList = new ArrayList(paramArrayOfInt.length);
    SparseArray localSparseArray = new SparseArray(paramArrayOfInt.length);
    localObject = ((SQLiteDatabase)localObject).query("prekeys", new String[] { "prekey_id", "record" }, null, null, null, null, null);
    while (((Cursor)localObject).moveToNext())
    {
      i = ((Cursor)localObject).getInt(0);
      try
      {
        byte[] arrayOfByte1 = new org.whispersystems.a.h.c(((Cursor)localObject).getBlob(1)).b().a().a();
        byte[] arrayOfByte2 = new byte[arrayOfByte1.length - 1];
        System.arraycopy(arrayOfByte1, 1, arrayOfByte2, 0, arrayOfByte2.length);
        localSparseArray.put(i, new aj(a.a.a.a.d.f(i), arrayOfByte2, null));
      }
      catch (IOException localIOException)
      {
        Log.d("error reading prekey " + i, localIOException);
      }
    }
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      aj localaj = (aj)localSparseArray.get(paramArrayOfInt[i]);
      if (localaj == null) {
        return null;
      }
      localArrayList.add(localaj);
      i += 1;
    }
    ((Cursor)localObject).close();
    Log.i("axolotl reporting back " + localArrayList.size() + " sequenced prekeys");
    return (aj[])localArrayList.toArray(new aj[localArrayList.size()]);
  }
  
  public final a b(String paramString)
  {
    return a(this.c.getWritableDatabase(), paramString);
  }
  
  public final void b()
  {
    a.submit(d.a(this));
  }
  
  public final void b(int paramInt)
  {
    long l = this.c.getWritableDatabase().delete("prekeys", "prekey_id = ?", new String[] { String.valueOf(paramInt) });
    Log.i("axolotl deleted " + l + " pre keys with id " + paramInt);
  }
  
  public final void b(org.whispersystems.a.m paramm)
  {
    if (paramm.b() != 0) {
      throw new IllegalArgumentException("Multiple device support not implemented");
    }
    paramm = paramm.a();
    SQLiteDatabase localSQLiteDatabase = this.c.getWritableDatabase();
    org.whispersystems.a.c localc = a(localSQLiteDatabase, paramm).a;
    long l = localSQLiteDatabase.delete("identities", "recipient_id = ?", new String[] { paramm });
    Log.i("axolotl deleted " + l + " idenities for " + paramm);
    if (localc != null) {
      b.a.a.c.a().b(new com.whatsapp.g.m(paramm + "@s.whatsapp.net", localc, null));
    }
  }
  
  public final org.whispersystems.a.h.e c(org.whispersystems.a.m paramm)
  {
    if (paramm.b() != 0) {
      throw new IllegalArgumentException("Multiple device support not implemented");
    }
    return c(paramm.a());
  }
  
  public final void c()
  {
    Object localObject4 = null;
    SQLiteDatabase localSQLiteDatabase = this.c.getWritableDatabase();
    Cursor localCursor = localSQLiteDatabase.rawQuery("SELECT COUNT(*) FROM prekeys WHERE sent_to_server = 0", null);
    try
    {
      if (!localCursor.moveToNext()) {
        throw new SQLiteException("unable to fetch count from table");
      }
    }
    catch (Throwable localThrowable1)
    {
      Object localObject1;
      try
      {
        throw localThrowable1;
      }
      finally
      {
        localObject4 = localThrowable1;
      }
      if ((localCursor == null) || (localObject4 != null)) {}
      try
      {
        localCursor.close();
        throw ((Throwable)localObject1);
        int i = localCursor.getInt(0);
        if (localCursor != null) {
          localCursor.close();
        }
        if (i >= aic.J) {
          Log.i("skipping key generation because already more than " + aic.J + " are unsent");
        }
        do
        {
          return;
          localCursor.close();
          break;
          i = aic.J - i;
        } while (i <= 0);
        int j = Math.min(i, 50);
        b.a((SQLiteDatabase)localObject1, j);
        i -= j;
      }
      catch (Throwable localThrowable2) {}
    }
    finally
    {
      for (;;) {}
    }
  }
  
  /* Error */
  public final void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 82	com/whatsapp/a/c:c	Lcom/whatsapp/a/b;
    //   6: invokevirtual 657	com/whatsapp/a/b:close	()V
    //   9: aload_0
    //   10: getfield 68	com/whatsapp/a/c:h	Landroid/content/Context;
    //   13: ldc_w 659
    //   16: invokevirtual 663	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   19: astore_1
    //   20: aload_1
    //   21: invokevirtual 667	java/io/File:delete	()Z
    //   24: ifeq +26 -> 50
    //   27: new 129	java/lang/StringBuilder
    //   30: dup
    //   31: ldc_w 669
    //   34: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   37: aload_1
    //   38: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 147	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: new 129	java/lang/StringBuilder
    //   53: dup
    //   54: ldc_w 671
    //   57: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   60: aload_1
    //   61: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 673	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   70: goto -23 -> 47
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	c
    //   19	42	1	localFile	java.io.File
    //   73	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	47	73	finally
    //   50	70	73	finally
  }
  
  public final boolean d(org.whispersystems.a.m paramm)
  {
    if (paramm.b() != 0) {
      throw new IllegalArgumentException("Multiple device support not implemented");
    }
    return d(paramm.a());
  }
  
  public final void e(org.whispersystems.a.m paramm)
  {
    if (paramm.b() != 0) {
      throw new IllegalArgumentException("Multiple device support not implemented");
    }
    paramm = paramm.a();
    long l = this.c.getWritableDatabase().delete("sessions", "recipient_id = ?", new String[] { paramm });
    Log.i("axolotl deleted " + l + " sessions with " + paramm);
  }
  
  public final boolean e()
  {
    boolean bool = false;
    Cursor localCursor = this.c.getWritableDatabase().rawQuery("SELECT COUNT(*) FROM prekeys WHERE sent_to_server = 0", null);
    if (!localCursor.moveToNext())
    {
      localCursor.close();
      throw new SQLiteException("Unable to count unsent entries in prekeys table");
    }
    if (localCursor.getInt(0) != 0) {
      bool = true;
    }
    localCursor.close();
    Log.i("axolotl has unsent prekeys: " + bool);
    return bool;
  }
  
  public final boolean f()
  {
    boolean bool = false;
    SQLiteDatabase localSQLiteDatabase = this.c.getWritableDatabase();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("sent_to_server", Boolean.valueOf(false));
    int i = localSQLiteDatabase.update("prekeys", localContentValues, "sent_to_server != 0", null);
    Log.i("axolotl recorded no prekeys as received by server");
    if (i > 0) {
      bool = true;
    }
    return bool;
  }
  
  public final byte[] g()
  {
    byte[] arrayOfByte1 = h().a().b();
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length - 1];
    System.arraycopy(arrayOfByte1, 1, arrayOfByte2, 0, arrayOfByte2.length);
    Log.i("axolotl fetched identity key for sending");
    return arrayOfByte2;
  }
  
  public final org.whispersystems.a.d h()
  {
    Object localObject2 = this.c.getWritableDatabase().query("identities", new String[] { "public_key", "private_key" }, "recipient_id = ?", new String[] { "-1" }, null, null, null);
    if (!((Cursor)localObject2).moveToNext())
    {
      ((Cursor)localObject2).close();
      throw new SQLiteException("Missing entry for self in identities table");
    }
    byte[] arrayOfByte = ((Cursor)localObject2).getBlob(0);
    Object localObject1 = ((Cursor)localObject2).getBlob(1);
    ((Cursor)localObject2).close();
    try
    {
      localObject2 = new org.whispersystems.a.c(arrayOfByte);
      localObject1 = a.a.a.a.d.c((byte[])localObject1);
      Log.i("axolotl loading identity key pair");
      return new org.whispersystems.a.d((org.whispersystems.a.c)localObject2, (org.whispersystems.a.a.c)localObject1);
    }
    catch (org.whispersystems.a.e locale)
    {
      throw new SQLiteException("Invalid public key stored in identities table");
    }
  }
  
  public final int i()
  {
    Cursor localCursor = this.c.getWritableDatabase().query("identities", new String[] { "registration_id" }, "recipient_id = ?", new String[] { "-1" }, null, null, null);
    if (!localCursor.moveToNext())
    {
      localCursor.close();
      throw new SQLiteException("Missing entry for self in identities table");
    }
    int i = localCursor.getInt(0);
    localCursor.close();
    Log.i("axolotl fetched local registration id: " + i);
    return i;
  }
  
  public final aj[] j()
  {
    Object localObject = this.c.getWritableDatabase();
    ArrayList localArrayList = new ArrayList();
    int i = aic.J;
    localObject = ((SQLiteDatabase)localObject).query("prekeys", new String[] { "prekey_id", "record" }, "sent_to_server = ?", new String[] { "0" }, null, null, null, String.valueOf(i * 5));
    while (((Cursor)localObject).moveToNext())
    {
      i = ((Cursor)localObject).getInt(0);
      try
      {
        byte[] arrayOfByte1 = new org.whispersystems.a.h.c(((Cursor)localObject).getBlob(1)).b().a().a();
        byte[] arrayOfByte2 = new byte[arrayOfByte1.length - 1];
        System.arraycopy(arrayOfByte1, 1, arrayOfByte2, 0, arrayOfByte2.length);
        localArrayList.add(new aj(a.a.a.a.d.f(i), arrayOfByte2, null));
      }
      catch (IOException localIOException)
      {
        Log.d("error reading prekey " + i, localIOException);
      }
    }
    ((Cursor)localObject).close();
    Log.i("axolotl reporting back " + localArrayList.size() + " prekeys for sending to the server");
    return (aj[])localArrayList.toArray(new aj[localArrayList.size()]);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */