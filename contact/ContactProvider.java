package com.whatsapp.contact;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import java.util.ArrayList;

public class ContactProvider
  extends ContentProvider
{
  public static final Uri a = Uri.parse("content://com.whatsapp.provider.contact/contacts");
  public static final Uri b = Uri.parse("content://com.whatsapp.provider.contact/contacts/dbfile");
  public static final Uri c = Uri.parse("content://com.whatsapp.provider.contact/contacts/capabilities");
  public static final Uri d = Uri.parse("content://com.whatsapp.provider.contact/contacts/system_version");
  public static final Uri e = Uri.parse("content://com.whatsapp.provider.contact/contacts/vnames");
  public static final Uri f = Uri.parse("content://com.whatsapp.provider.contact/contacts/vnames_localized");
  public static final String[] g = { "count(wa_contacts._id) AS _count" };
  private static final UriMatcher h;
  private a i;
  
  static
  {
    UriMatcher localUriMatcher = new UriMatcher(-1);
    h = localUriMatcher;
    localUriMatcher.addURI("com.whatsapp.provider.contact", "contacts", 1);
    h.addURI("com.whatsapp.provider.contact", "contacts/#", 2);
    h.addURI("com.whatsapp.provider.contact", "contacts/dbfile", 3);
    h.addURI("com.whatsapp.provider.contact", "contacts/capabilities", 4);
    h.addURI("com.whatsapp.provider.contact", "contacts/capabilities/#", 5);
    h.addURI("com.whatsapp.provider.contact", "contacts/system_version", 6);
    h.addURI("com.whatsapp.provider.contact", "contacts/system_version/#", 7);
    h.addURI("com.whatsapp.provider.contact", "contacts/vnames", 8);
    h.addURI("com.whatsapp.provider.contact", "contacts/vnames/#", 9);
    h.addURI("com.whatsapp.provider.contact", "contacts/vnames_localized", 10);
    h.addURI("com.whatsapp.provider.contact", "contacts/vnames_localized/#", 11);
  }
  
  private static String a(Uri paramUri, int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      throw new IllegalArgumentException("Unknown URI " + paramUri);
    case 1: 
    case 2: 
      return "wa_contacts";
    case 4: 
    case 5: 
      return "wa_contact_capabilities";
    case 6: 
    case 7: 
      return "system_contacts_version_table";
    case 8: 
    case 9: 
      return "wa_vnames";
    }
    return "wa_vnames_localized";
  }
  
  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "_id = ?";
    }
    return "_id = ? AND (" + paramString + ")";
  }
  
  public static boolean a(Uri paramUri)
  {
    return (paramUri != null) && (TextUtils.equals(paramUri.getScheme(), "content")) && (TextUtils.equals(paramUri.getAuthority(), "com.whatsapp.provider.contact"));
  }
  
  private static String[] a(String[] paramArrayOfString, long paramLong)
  {
    if (paramArrayOfString == null) {
      return new String[] { String.valueOf(paramLong) };
    }
    String[] arrayOfString = new String[paramArrayOfString.length + 1];
    System.arraycopy(paramArrayOfString, 0, arrayOfString, 1, paramArrayOfString.length);
    arrayOfString[0] = String.valueOf(paramLong);
    return arrayOfString;
  }
  
  public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> paramArrayList)
  {
    SQLiteDatabase localSQLiteDatabase = this.i.getWritableDatabase();
    localSQLiteDatabase.beginTransaction();
    try
    {
      paramArrayList = super.applyBatch(paramArrayList);
      localSQLiteDatabase.setTransactionSuccessful();
      return paramArrayList;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    int j = h.match(paramUri);
    if (j == 3)
    {
      if (this.i.a()) {}
      for (j = 1;; j = 0)
      {
        getContext().getContentResolver().notifyChange(paramUri, null);
        return j;
      }
    }
    String str2 = a(paramUri, j);
    String str1;
    String[] arrayOfString;
    if ((j != 2) && (j != 5) && (j != 7) && (j != 9))
    {
      str1 = paramString;
      arrayOfString = paramArrayOfString;
      if (j != 11) {}
    }
    else
    {
      long l = ContentUris.parseId(paramUri);
      str1 = a(paramString);
      arrayOfString = a(paramArrayOfString, l);
    }
    j = this.i.getWritableDatabase().delete(str2, str1, arrayOfString);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return j;
  }
  
  public String getType(Uri paramUri)
  {
    switch (h.match(paramUri))
    {
    case 3: 
    default: 
      throw new IllegalArgumentException("Unknown URI " + paramUri);
    case 1: 
      return "vnd.android.cursor.dir/vnd.com.whatsapp.provider.contact";
    case 2: 
      return "vnd.android.cursor.item/vnd.com.whatsapp.provider.contact";
    case 4: 
      return "vnd.android.cursor.dir/vnd.com.whatsapp.provider.contact.capability";
    case 5: 
      return "vnd.android.cursor.item/vnd.com.whatsapp.provider.contact.capability";
    case 6: 
      return "vnd.android.cursor.dir/vnd.com.whatsapp.provider.contact.system_version";
    case 7: 
      return "vnd.android.cursor.item/vnd.com.whatsapp.provider.contact.system_version";
    case 8: 
      return "vnd.android.cursor.dir/vnd.com.whatsapp.provider.contact.vname";
    case 9: 
      return "vnd.android.cursor.item/vnd.com.whatsapp.provider.contact.vname";
    case 10: 
      return "vnd.android.cursor.dir/vnd.com.whatsapp.provider.contact.vname_localized";
    }
    return "vnd.android.cursor.item/vnd.com.whatsapp.provider.contact.vname_localized";
  }
  
  /* Error */
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 7
    //   12: getstatic 63	com/whatsapp/contact/ContactProvider:h	Landroid/content/UriMatcher;
    //   15: aload_1
    //   16: invokevirtual 194	android/content/UriMatcher:match	(Landroid/net/Uri;)I
    //   19: istore_3
    //   20: iload_3
    //   21: iconst_3
    //   22: if_icmpne +270 -> 292
    //   25: aload_2
    //   26: ldc_w 258
    //   29: invokevirtual 264	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   32: ifne +14 -> 46
    //   35: new 97	java/lang/IllegalArgumentException
    //   38: dup
    //   39: ldc_w 266
    //   42: invokespecial 113	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   45: athrow
    //   46: aload_0
    //   47: getfield 167	com/whatsapp/contact/ContactProvider:i	Lcom/whatsapp/contact/a;
    //   50: astore 11
    //   52: new 268	java/io/File
    //   55: dup
    //   56: aload_2
    //   57: ldc_w 258
    //   60: invokevirtual 271	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   63: invokespecial 272	java/io/File:<init>	(Ljava/lang/String;)V
    //   66: astore 12
    //   68: aload 11
    //   70: monitorenter
    //   71: aload 11
    //   73: invokevirtual 275	com/whatsapp/contact/a:close	()V
    //   76: new 277	java/io/FileInputStream
    //   79: dup
    //   80: aload 11
    //   82: invokevirtual 280	com/whatsapp/contact/a:b	()Ljava/io/File;
    //   85: invokespecial 283	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   88: invokevirtual 287	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   91: astore_2
    //   92: aload_2
    //   93: astore 8
    //   95: aload 9
    //   97: astore 7
    //   99: aload 12
    //   101: invokevirtual 290	java/io/File:exists	()Z
    //   104: ifne +18 -> 122
    //   107: aload_2
    //   108: astore 8
    //   110: aload 9
    //   112: astore 7
    //   114: aload 12
    //   116: invokevirtual 293	java/io/File:createNewFile	()Z
    //   119: invokestatic 298	com/whatsapp/util/Log:a	(Z)V
    //   122: aload_2
    //   123: astore 8
    //   125: aload 9
    //   127: astore 7
    //   129: new 300	java/io/FileOutputStream
    //   132: dup
    //   133: aload 12
    //   135: invokespecial 301	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   138: invokevirtual 302	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   141: astore 9
    //   143: aload 9
    //   145: aload_2
    //   146: lconst_0
    //   147: aload_2
    //   148: invokevirtual 308	java/nio/channels/FileChannel:size	()J
    //   151: invokevirtual 312	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   154: pop2
    //   155: aload_2
    //   156: ifnull +7 -> 163
    //   159: aload_2
    //   160: invokevirtual 313	java/nio/channels/FileChannel:close	()V
    //   163: aload 9
    //   165: ifnull +8 -> 173
    //   168: aload 9
    //   170: invokevirtual 313	java/nio/channels/FileChannel:close	()V
    //   173: aload 11
    //   175: monitorexit
    //   176: aload_1
    //   177: areturn
    //   178: astore 8
    //   180: aconst_null
    //   181: astore_2
    //   182: ldc_w 315
    //   185: aload 8
    //   187: invokestatic 318	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   190: aload 7
    //   192: ifnull +8 -> 200
    //   195: aload 7
    //   197: invokevirtual 313	java/nio/channels/FileChannel:close	()V
    //   200: aload_2
    //   201: ifnull -28 -> 173
    //   204: aload_2
    //   205: invokevirtual 313	java/nio/channels/FileChannel:close	()V
    //   208: goto -35 -> 173
    //   211: astore_2
    //   212: goto -39 -> 173
    //   215: astore 9
    //   217: aconst_null
    //   218: astore_2
    //   219: aload_2
    //   220: astore 8
    //   222: aload 10
    //   224: astore 7
    //   226: ldc_w 320
    //   229: aload 9
    //   231: invokestatic 318	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   234: aload_2
    //   235: ifnull +7 -> 242
    //   238: aload_2
    //   239: invokevirtual 313	java/nio/channels/FileChannel:close	()V
    //   242: aload 10
    //   244: ifnull -71 -> 173
    //   247: aload 10
    //   249: invokevirtual 313	java/nio/channels/FileChannel:close	()V
    //   252: goto -79 -> 173
    //   255: astore_2
    //   256: goto -83 -> 173
    //   259: astore_1
    //   260: aconst_null
    //   261: astore_2
    //   262: aload 8
    //   264: astore 7
    //   266: aload_2
    //   267: ifnull +7 -> 274
    //   270: aload_2
    //   271: invokevirtual 313	java/nio/channels/FileChannel:close	()V
    //   274: aload 7
    //   276: ifnull +8 -> 284
    //   279: aload 7
    //   281: invokevirtual 313	java/nio/channels/FileChannel:close	()V
    //   284: aload_1
    //   285: athrow
    //   286: astore_1
    //   287: aload 11
    //   289: monitorexit
    //   290: aload_1
    //   291: athrow
    //   292: aload_2
    //   293: ldc_w 322
    //   296: invokevirtual 264	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   299: ifeq +101 -> 400
    //   302: aload_2
    //   303: ldc_w 322
    //   306: invokevirtual 326	android/content/ContentValues:getAsBoolean	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   309: invokevirtual 331	java/lang/Boolean:booleanValue	()Z
    //   312: istore 4
    //   314: aload_2
    //   315: ldc_w 322
    //   318: invokevirtual 334	android/content/ContentValues:remove	(Ljava/lang/String;)V
    //   321: iload_3
    //   322: tableswitch	default:+54->376, 1:+84->406, 2:+54->376, 3:+54->376, 4:+147->469, 5:+54->376, 6:+210->532, 7:+54->376, 8:+273->595, 9:+54->376, 10:+336->658
    //   376: new 97	java/lang/IllegalArgumentException
    //   379: dup
    //   380: new 99	java/lang/StringBuilder
    //   383: dup
    //   384: ldc 101
    //   386: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   389: aload_1
    //   390: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   393: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: invokespecial 113	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   399: athrow
    //   400: iconst_0
    //   401: istore 4
    //   403: goto -89 -> 314
    //   406: iload 4
    //   408: ifeq +42 -> 450
    //   411: aload_0
    //   412: getfield 167	com/whatsapp/contact/ContactProvider:i	Lcom/whatsapp/contact/a;
    //   415: invokevirtual 173	com/whatsapp/contact/a:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   418: ldc 115
    //   420: aconst_null
    //   421: aload_2
    //   422: invokevirtual 338	android/database/sqlite/SQLiteDatabase:replaceOrThrow	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   425: lstore 5
    //   427: getstatic 29	com/whatsapp/contact/ContactProvider:a	Landroid/net/Uri;
    //   430: lload 5
    //   432: invokestatic 342	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   435: astore_1
    //   436: aload_0
    //   437: invokevirtual 201	com/whatsapp/contact/ContactProvider:getContext	()Landroid/content/Context;
    //   440: invokevirtual 207	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   443: aload_1
    //   444: aconst_null
    //   445: invokevirtual 213	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    //   448: aload_1
    //   449: areturn
    //   450: aload_0
    //   451: getfield 167	com/whatsapp/contact/ContactProvider:i	Lcom/whatsapp/contact/a;
    //   454: invokevirtual 173	com/whatsapp/contact/a:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   457: ldc 115
    //   459: aconst_null
    //   460: aload_2
    //   461: invokevirtual 345	android/database/sqlite/SQLiteDatabase:insertOrThrow	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   464: lstore 5
    //   466: goto -39 -> 427
    //   469: iload 4
    //   471: ifeq +42 -> 513
    //   474: aload_0
    //   475: getfield 167	com/whatsapp/contact/ContactProvider:i	Lcom/whatsapp/contact/a;
    //   478: invokevirtual 173	com/whatsapp/contact/a:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   481: ldc 117
    //   483: aconst_null
    //   484: aload_2
    //   485: invokevirtual 338	android/database/sqlite/SQLiteDatabase:replaceOrThrow	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   488: lstore 5
    //   490: getstatic 29	com/whatsapp/contact/ContactProvider:a	Landroid/net/Uri;
    //   493: lload 5
    //   495: invokestatic 342	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   498: astore_1
    //   499: aload_0
    //   500: invokevirtual 201	com/whatsapp/contact/ContactProvider:getContext	()Landroid/content/Context;
    //   503: invokevirtual 207	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   506: aload_1
    //   507: aconst_null
    //   508: invokevirtual 213	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    //   511: aload_1
    //   512: areturn
    //   513: aload_0
    //   514: getfield 167	com/whatsapp/contact/ContactProvider:i	Lcom/whatsapp/contact/a;
    //   517: invokevirtual 173	com/whatsapp/contact/a:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   520: ldc 117
    //   522: aconst_null
    //   523: aload_2
    //   524: invokevirtual 345	android/database/sqlite/SQLiteDatabase:insertOrThrow	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   527: lstore 5
    //   529: goto -39 -> 490
    //   532: iload 4
    //   534: ifeq +42 -> 576
    //   537: aload_0
    //   538: getfield 167	com/whatsapp/contact/ContactProvider:i	Lcom/whatsapp/contact/a;
    //   541: invokevirtual 173	com/whatsapp/contact/a:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   544: ldc 119
    //   546: aconst_null
    //   547: aload_2
    //   548: invokevirtual 338	android/database/sqlite/SQLiteDatabase:replaceOrThrow	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   551: lstore 5
    //   553: getstatic 29	com/whatsapp/contact/ContactProvider:a	Landroid/net/Uri;
    //   556: lload 5
    //   558: invokestatic 342	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   561: astore_1
    //   562: aload_0
    //   563: invokevirtual 201	com/whatsapp/contact/ContactProvider:getContext	()Landroid/content/Context;
    //   566: invokevirtual 207	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   569: aload_1
    //   570: aconst_null
    //   571: invokevirtual 213	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    //   574: aload_1
    //   575: areturn
    //   576: aload_0
    //   577: getfield 167	com/whatsapp/contact/ContactProvider:i	Lcom/whatsapp/contact/a;
    //   580: invokevirtual 173	com/whatsapp/contact/a:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   583: ldc 119
    //   585: aconst_null
    //   586: aload_2
    //   587: invokevirtual 345	android/database/sqlite/SQLiteDatabase:insertOrThrow	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   590: lstore 5
    //   592: goto -39 -> 553
    //   595: iload 4
    //   597: ifeq +42 -> 639
    //   600: aload_0
    //   601: getfield 167	com/whatsapp/contact/ContactProvider:i	Lcom/whatsapp/contact/a;
    //   604: invokevirtual 173	com/whatsapp/contact/a:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   607: ldc 121
    //   609: aconst_null
    //   610: aload_2
    //   611: invokevirtual 338	android/database/sqlite/SQLiteDatabase:replaceOrThrow	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   614: lstore 5
    //   616: getstatic 29	com/whatsapp/contact/ContactProvider:a	Landroid/net/Uri;
    //   619: lload 5
    //   621: invokestatic 342	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   624: astore_1
    //   625: aload_0
    //   626: invokevirtual 201	com/whatsapp/contact/ContactProvider:getContext	()Landroid/content/Context;
    //   629: invokevirtual 207	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   632: aload_1
    //   633: aconst_null
    //   634: invokevirtual 213	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    //   637: aload_1
    //   638: areturn
    //   639: aload_0
    //   640: getfield 167	com/whatsapp/contact/ContactProvider:i	Lcom/whatsapp/contact/a;
    //   643: invokevirtual 173	com/whatsapp/contact/a:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   646: ldc 121
    //   648: aconst_null
    //   649: aload_2
    //   650: invokevirtual 345	android/database/sqlite/SQLiteDatabase:insertOrThrow	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   653: lstore 5
    //   655: goto -39 -> 616
    //   658: iload 4
    //   660: ifeq +42 -> 702
    //   663: aload_0
    //   664: getfield 167	com/whatsapp/contact/ContactProvider:i	Lcom/whatsapp/contact/a;
    //   667: invokevirtual 173	com/whatsapp/contact/a:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   670: ldc 123
    //   672: aconst_null
    //   673: aload_2
    //   674: invokevirtual 338	android/database/sqlite/SQLiteDatabase:replaceOrThrow	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   677: lstore 5
    //   679: getstatic 29	com/whatsapp/contact/ContactProvider:a	Landroid/net/Uri;
    //   682: lload 5
    //   684: invokestatic 342	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   687: astore_1
    //   688: aload_0
    //   689: invokevirtual 201	com/whatsapp/contact/ContactProvider:getContext	()Landroid/content/Context;
    //   692: invokevirtual 207	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   695: aload_1
    //   696: aconst_null
    //   697: invokevirtual 213	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    //   700: aload_1
    //   701: areturn
    //   702: aload_0
    //   703: getfield 167	com/whatsapp/contact/ContactProvider:i	Lcom/whatsapp/contact/a;
    //   706: invokevirtual 173	com/whatsapp/contact/a:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   709: ldc 123
    //   711: aconst_null
    //   712: aload_2
    //   713: invokevirtual 345	android/database/sqlite/SQLiteDatabase:insertOrThrow	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   716: lstore 5
    //   718: goto -39 -> 679
    //   721: astore_2
    //   722: goto -559 -> 163
    //   725: astore_2
    //   726: goto -553 -> 173
    //   729: astore 7
    //   731: goto -531 -> 200
    //   734: astore_2
    //   735: goto -493 -> 242
    //   738: astore_2
    //   739: goto -465 -> 274
    //   742: astore_2
    //   743: goto -459 -> 284
    //   746: astore_1
    //   747: aload 8
    //   749: astore_2
    //   750: goto -484 -> 266
    //   753: astore_1
    //   754: aload 9
    //   756: astore 7
    //   758: goto -492 -> 266
    //   761: astore_1
    //   762: aload_2
    //   763: astore 8
    //   765: aload 7
    //   767: astore_2
    //   768: aload 8
    //   770: astore 7
    //   772: goto -506 -> 266
    //   775: astore 9
    //   777: goto -558 -> 219
    //   780: astore 7
    //   782: aload 9
    //   784: astore 10
    //   786: aload 7
    //   788: astore 9
    //   790: goto -571 -> 219
    //   793: astore 8
    //   795: aload_2
    //   796: astore 7
    //   798: aconst_null
    //   799: astore_2
    //   800: goto -618 -> 182
    //   803: astore 8
    //   805: aload_2
    //   806: astore 7
    //   808: aload 9
    //   810: astore_2
    //   811: goto -629 -> 182
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	814	0	this	ContactProvider
    //   0	814	1	paramUri	Uri
    //   0	814	2	paramContentValues	ContentValues
    //   19	303	3	j	int
    //   312	347	4	bool	boolean
    //   425	292	5	l	long
    //   10	270	7	localObject1	Object
    //   729	1	7	localIOException1	java.io.IOException
    //   756	15	7	localObject2	Object
    //   780	7	7	localIOException2	java.io.IOException
    //   796	11	7	localContentValues1	ContentValues
    //   4	120	8	localContentValues2	ContentValues
    //   178	8	8	localFileNotFoundException1	java.io.FileNotFoundException
    //   220	549	8	localContentValues3	ContentValues
    //   793	1	8	localFileNotFoundException2	java.io.FileNotFoundException
    //   803	1	8	localFileNotFoundException3	java.io.FileNotFoundException
    //   7	162	9	localFileChannel	java.nio.channels.FileChannel
    //   215	540	9	localIOException3	java.io.IOException
    //   775	8	9	localIOException4	java.io.IOException
    //   788	21	9	localObject3	Object
    //   1	784	10	localObject4	Object
    //   50	238	11	locala	a
    //   66	68	12	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   76	92	178	java/io/FileNotFoundException
    //   204	208	211	java/io/IOException
    //   76	92	215	java/io/IOException
    //   247	252	255	java/io/IOException
    //   76	92	259	finally
    //   71	76	286	finally
    //   159	163	286	finally
    //   168	173	286	finally
    //   173	176	286	finally
    //   195	200	286	finally
    //   204	208	286	finally
    //   238	242	286	finally
    //   247	252	286	finally
    //   270	274	286	finally
    //   279	284	286	finally
    //   284	286	286	finally
    //   287	290	286	finally
    //   159	163	721	java/io/IOException
    //   168	173	725	java/io/IOException
    //   195	200	729	java/io/IOException
    //   238	242	734	java/io/IOException
    //   270	274	738	java/io/IOException
    //   279	284	742	java/io/IOException
    //   99	107	746	finally
    //   114	122	746	finally
    //   129	143	746	finally
    //   226	234	746	finally
    //   143	155	753	finally
    //   182	190	761	finally
    //   99	107	775	java/io/IOException
    //   114	122	775	java/io/IOException
    //   129	143	775	java/io/IOException
    //   143	155	780	java/io/IOException
    //   99	107	793	java/io/FileNotFoundException
    //   114	122	793	java/io/FileNotFoundException
    //   129	143	793	java/io/FileNotFoundException
    //   143	155	803	java/io/FileNotFoundException
  }
  
  public boolean onCreate()
  {
    this.i = new a(getContext());
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    SQLiteDatabase localSQLiteDatabase = this.i.getReadableDatabase();
    switch (h.match(paramUri))
    {
    case 3: 
    default: 
      throw new IllegalArgumentException("Unknown URI " + paramUri);
    case 1: 
      localSQLiteQueryBuilder.setTables("wa_contacts LEFT JOIN wa_vnames ON (wa_contacts.jid = wa_vnames.jid)");
    }
    for (;;)
    {
      paramArrayOfString1 = localSQLiteQueryBuilder.query(localSQLiteDatabase, paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
      paramArrayOfString1.setNotificationUri(getContext().getContentResolver(), paramUri);
      return paramArrayOfString1;
      localSQLiteQueryBuilder.setTables("wa_contacts LEFT JOIN wa_vnames ON (wa_contacts.jid = wa_vnames.jid)");
      localSQLiteQueryBuilder.appendWhere("wa_contacts._id = " + ContentUris.parseId(paramUri));
      continue;
      localSQLiteQueryBuilder.setTables("wa_contact_capabilities");
      continue;
      localSQLiteQueryBuilder.setTables("wa_contact_capabilities");
      localSQLiteQueryBuilder.appendWhere("_id = " + ContentUris.parseId(paramUri));
      continue;
      localSQLiteQueryBuilder.setTables("system_contacts_version_table");
      continue;
      localSQLiteQueryBuilder.setTables("system_contacts_version_table");
      localSQLiteQueryBuilder.appendWhere("_id = " + ContentUris.parseId(paramUri));
      continue;
      localSQLiteQueryBuilder.setTables("wa_vnames");
      continue;
      localSQLiteQueryBuilder.setTables("wa_vnames");
      localSQLiteQueryBuilder.appendWhere("_id = " + ContentUris.parseId(paramUri));
      continue;
      localSQLiteQueryBuilder.setTables("wa_vnames_localized");
      continue;
      localSQLiteQueryBuilder.setTables("wa_vnames_localized");
      localSQLiteQueryBuilder.appendWhere("_id = " + ContentUris.parseId(paramUri));
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    int j = h.match(paramUri);
    String str2 = a(paramUri, j);
    String str1;
    String[] arrayOfString;
    if ((j != 2) && (j != 5) && (j != 7) && (j != 9))
    {
      str1 = paramString;
      arrayOfString = paramArrayOfString;
      if (j != 11) {}
    }
    else
    {
      long l = ContentUris.parseId(paramUri);
      str1 = a(paramString);
      arrayOfString = a(paramArrayOfString, l);
    }
    j = this.i.getWritableDatabase().update(str2, paramContentValues, str1, arrayOfString);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return j;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/contact/ContactProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */