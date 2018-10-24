package com.whatsapp.contact.sync;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Build.VERSION;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import com.whatsapp.and;
import com.whatsapp.util.Log;

public final class n
{
  private static final String[] g;
  private static final String[] h;
  private static boolean i;
  private static final String[] j;
  public final long a;
  public final String b;
  public final String c;
  public final int d;
  public final String e;
  public boolean f;
  private final String k;
  private String l;
  
  static
  {
    boolean bool = true;
    g = new String[] { "raw_contact_id", "display_name", "data1", "data2", "data3" };
    h = new String[] { "raw_contact_id", "display_name", "data1", "data2", "data3", "sort_key" };
    if (Build.VERSION.SDK_INT >= 11)
    {
      i = bool;
      if (Build.VERSION.SDK_INT < 11) {
        break label106;
      }
    }
    label106:
    for (String[] arrayOfString = h;; arrayOfString = g)
    {
      j = arrayOfString;
      return;
      bool = false;
      break;
    }
  }
  
  private n(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    if (paramString2 == null) {
      throw new NullPointerException("number must not be null");
    }
    this.a = paramLong;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramInt;
    this.e = paramString3;
    this.k = paramString4;
    this.f = i;
    if (i) {
      this.l = paramString4;
    }
  }
  
  public static Cursor a(and paramand, p paramp, String paramString)
  {
    Cursor localCursor = null;
    Log.i("phone/getcursor/query/start");
    paramand = paramand.f;
    if (paramand == null)
    {
      Log.w("phone/getcursor/cr null");
      paramand = localCursor;
    }
    do
    {
      return paramand;
      localCursor = paramand.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, j, paramp.a(), paramp.d, null);
      Log.i("phone/getcursor/query/end");
      paramand = localCursor;
    } while (localCursor == null);
    Log.i(paramString + paramp.name() + '/' + localCursor.getCount());
    return localCursor;
  }
  
  public static n a(Context paramContext, String paramString1, String paramString2)
  {
    paramString2 = PhoneNumberUtils.stripSeparators(paramString2);
    if (!PhoneNumberUtils.isGlobalPhoneNumber(paramString2))
    {
      Log.d("phone/sim/not_global/" + paramString2);
      return null;
    }
    return new n(-2L, paramString1, paramString2, 0, paramContext.getString(2131296535), null);
  }
  
  public static n a(Cursor paramCursor)
  {
    String str1 = null;
    String str2 = PhoneNumberUtils.stripSeparators(paramCursor.getString(2));
    if (!PhoneNumberUtils.isGlobalPhoneNumber(str2))
    {
      Log.d("phone/cursor/not_global/" + str2);
      return null;
    }
    long l1 = paramCursor.getLong(0);
    String str3 = paramCursor.getString(1);
    int m = paramCursor.getInt(3);
    String str4 = paramCursor.getString(4);
    if (i) {
      str1 = paramCursor.getString(5);
    }
    return new n(l1, str3, str2, m, str4, str1);
  }
  
  public static boolean a(String paramString)
  {
    return (5 <= paramString.length()) && (paramString.length() <= 20);
  }
  
  /* Error */
  public final String a(and paramand)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 76	com/whatsapp/contact/sync/n:f	Z
    //   4: ifeq +8 -> 12
    //   7: aload_0
    //   8: getfield 78	com/whatsapp/contact/sync/n:l	Ljava/lang/String;
    //   11: areturn
    //   12: aload_1
    //   13: getfield 90	com/whatsapp/and:f	Landroid/content/ContentResolver;
    //   16: astore_1
    //   17: aload_1
    //   18: ifnonnull +13 -> 31
    //   21: ldc -70
    //   23: invokestatic 95	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   26: aload_0
    //   27: getfield 78	com/whatsapp/contact/sync/n:l	Ljava/lang/String;
    //   30: areturn
    //   31: getstatic 189	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   34: astore_2
    //   35: aload_0
    //   36: getfield 64	com/whatsapp/contact/sync/n:a	J
    //   39: invokestatic 194	java/lang/Long:toString	(J)Ljava/lang/String;
    //   42: astore_3
    //   43: aload_1
    //   44: aload_2
    //   45: iconst_2
    //   46: anewarray 25	java/lang/String
    //   49: dup
    //   50: iconst_0
    //   51: ldc -60
    //   53: aastore
    //   54: dup
    //   55: iconst_1
    //   56: ldc -58
    //   58: aastore
    //   59: ldc -56
    //   61: iconst_2
    //   62: anewarray 25	java/lang/String
    //   65: dup
    //   66: iconst_0
    //   67: aload_3
    //   68: aastore
    //   69: dup
    //   70: iconst_1
    //   71: ldc -54
    //   73: aastore
    //   74: aconst_null
    //   75: invokevirtual 114	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   78: astore_1
    //   79: aload_1
    //   80: ifnull +74 -> 154
    //   83: aload_0
    //   84: iconst_1
    //   85: putfield 76	com/whatsapp/contact/sync/n:f	Z
    //   88: aload_1
    //   89: invokeinterface 206 1 0
    //   94: ifeq +60 -> 154
    //   97: aload_1
    //   98: iconst_0
    //   99: invokeinterface 170 2 0
    //   104: astore_2
    //   105: aload_1
    //   106: iconst_1
    //   107: invokeinterface 170 2 0
    //   112: astore_3
    //   113: aload_3
    //   114: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   117: ifne +52 -> 169
    //   120: aload_2
    //   121: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   124: ifne +45 -> 169
    //   127: aload_0
    //   128: new 118	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   135: aload_3
    //   136: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: ldc -42
    //   141: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload_2
    //   145: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: putfield 78	com/whatsapp/contact/sync/n:l	Ljava/lang/String;
    //   154: aload_1
    //   155: ifnull +9 -> 164
    //   158: aload_1
    //   159: invokeinterface 217 1 0
    //   164: aload_0
    //   165: getfield 78	com/whatsapp/contact/sync/n:l	Ljava/lang/String;
    //   168: areturn
    //   169: aload_3
    //   170: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   173: ifne +28 -> 201
    //   176: aload_0
    //   177: aload_3
    //   178: putfield 78	com/whatsapp/contact/sync/n:l	Ljava/lang/String;
    //   181: goto -27 -> 154
    //   184: astore_3
    //   185: aload_1
    //   186: astore_2
    //   187: aload_3
    //   188: astore_1
    //   189: aload_2
    //   190: ifnull +9 -> 199
    //   193: aload_2
    //   194: invokeinterface 217 1 0
    //   199: aload_1
    //   200: athrow
    //   201: aload_2
    //   202: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   205: ifne -51 -> 154
    //   208: aload_0
    //   209: aload_2
    //   210: putfield 78	com/whatsapp/contact/sync/n:l	Ljava/lang/String;
    //   213: goto -59 -> 154
    //   216: astore_1
    //   217: aconst_null
    //   218: astore_2
    //   219: goto -30 -> 189
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	this	n
    //   0	222	1	paramand	and
    //   34	185	2	localObject1	Object
    //   42	136	3	str	String
    //   184	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   83	154	184	finally
    //   169	181	184	finally
    //   201	213	184	finally
    //   31	79	216	finally
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
        if (this == paramObject) {
          return true;
        }
      } while (getClass() != paramObject.getClass());
      paramObject = (n)paramObject;
    } while ((this.a != ((n)paramObject).a) || (!TextUtils.equals(this.b, ((n)paramObject).b)) || (!TextUtils.equals(this.c, ((n)paramObject).c)) || (this.d != ((n)paramObject).d) || (!TextUtils.equals(this.e, ((n)paramObject).e)) || (!TextUtils.equals(this.k, ((n)paramObject).k)));
    return true;
  }
  
  public final int hashCode()
  {
    int n = (int)(this.a >>> 32);
    int i1 = (int)this.a;
    int i2 = this.d;
    if (this.c == null) {}
    for (int m = 0;; m = this.c.hashCode()) {
      return m + (((n + 0) * 31 + i1) * 31 + i2) * 31;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/contact/sync/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */