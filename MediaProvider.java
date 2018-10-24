package com.whatsapp;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.whatsapp.data.e;
import com.whatsapp.data.l;
import com.whatsapp.data.y;
import com.whatsapp.protocol.j;
import com.whatsapp.util.Log;
import java.io.File;

public class MediaProvider
  extends ContentProvider
{
  private static final UriMatcher a;
  private static final String[] f = { "_display_name", "_size" };
  private e b;
  private l c;
  private y d;
  private lt e;
  
  static
  {
    UriMatcher localUriMatcher = new UriMatcher(-1);
    a = localUriMatcher;
    localUriMatcher.addURI("com.whatsapp.provider.media", "buckets", 1);
    a.addURI("com.whatsapp.provider.media", "items", 2);
    a.addURI("com.whatsapp.provider.media", "item/#", 3);
  }
  
  public static Uri a(j paramj)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return Uri.fromFile(paramj.b().file);
    }
    return ContentUris.appendId(new Uri.Builder().scheme("content").authority("com.whatsapp.provider.media").appendPath("item"), paramj.Q).build();
  }
  
  private j a(Uri paramUri)
  {
    try
    {
      long l = ContentUris.parseId(paramUri);
      paramUri = this.c.a(l);
      return paramUri;
    }
    catch (NumberFormatException paramUri)
    {
      Log.b("mediaprovider/getmediamessage", paramUri);
    }
    return null;
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException();
  }
  
  public String getType(Uri paramUri)
  {
    switch (a.match(paramUri))
    {
    default: 
      throw new IllegalArgumentException("Unknown URI " + paramUri);
    case 1: 
      return "vnd.android.cursor.dir/vnd.com.whatsapp.provider.media.buckets";
    case 2: 
      return "vnd.android.cursor.dir/vnd.com.whatsapp.provider.media.items";
    }
    paramUri = a(paramUri);
    if (paramUri == null) {
      return "application/octet-stream";
    }
    return aoj.e(paramUri);
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean onCreate()
  {
    this.b = e.a();
    this.c = l.a();
    this.d = y.a();
    this.e = lt.a();
    return true;
  }
  
  /* Error */
  public android.os.ParcelFileDescriptor openFile(Uri paramUri, String paramString)
  {
    // Byte code:
    //   0: ldc -55
    //   2: aload_2
    //   3: invokevirtual 205	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: ifeq +29 -> 35
    //   9: ldc -50
    //   11: istore_3
    //   12: aload_0
    //   13: aload_1
    //   14: invokespecial 160	com/whatsapp/MediaProvider:a	(Landroid/net/Uri;)Lcom/whatsapp/protocol/j;
    //   17: astore_1
    //   18: aload_1
    //   19: ifnonnull +109 -> 128
    //   22: ldc -48
    //   24: invokestatic 210	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   27: new 212	java/io/FileNotFoundException
    //   30: dup
    //   31: invokespecial 213	java/io/FileNotFoundException:<init>	()V
    //   34: athrow
    //   35: ldc -41
    //   37: aload_2
    //   38: invokevirtual 205	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   41: ifne +12 -> 53
    //   44: ldc -39
    //   46: aload_2
    //   47: invokevirtual 205	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   50: ifeq +9 -> 59
    //   53: ldc -38
    //   55: istore_3
    //   56: goto -44 -> 12
    //   59: ldc -36
    //   61: aload_2
    //   62: invokevirtual 205	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   65: ifeq +9 -> 74
    //   68: ldc -35
    //   70: istore_3
    //   71: goto -59 -> 12
    //   74: ldc -33
    //   76: aload_2
    //   77: invokevirtual 205	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   80: ifeq +9 -> 89
    //   83: ldc -32
    //   85: istore_3
    //   86: goto -74 -> 12
    //   89: ldc -30
    //   91: aload_2
    //   92: invokevirtual 205	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   95: ifeq +9 -> 104
    //   98: ldc -29
    //   100: istore_3
    //   101: goto -89 -> 12
    //   104: new 138	java/lang/IllegalArgumentException
    //   107: dup
    //   108: new 140	java/lang/StringBuilder
    //   111: dup
    //   112: ldc -27
    //   114: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   117: aload_2
    //   118: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokespecial 154	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   127: athrow
    //   128: aload_1
    //   129: getfield 236	com/whatsapp/protocol/j:N	Ljava/lang/Object;
    //   132: instanceof 63
    //   135: ifne +33 -> 168
    //   138: new 140	java/lang/StringBuilder
    //   141: dup
    //   142: ldc -18
    //   144: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   147: aload_1
    //   148: getfield 241	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   151: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 210	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   160: new 212	java/io/FileNotFoundException
    //   163: dup
    //   164: invokespecial 213	java/io/FileNotFoundException:<init>	()V
    //   167: athrow
    //   168: aload_1
    //   169: invokevirtual 61	com/whatsapp/protocol/j:b	()Lcom/whatsapp/MediaData;
    //   172: getfield 67	com/whatsapp/MediaData:file	Ljava/io/File;
    //   175: astore_2
    //   176: aload_2
    //   177: ifnonnull +33 -> 210
    //   180: new 140	java/lang/StringBuilder
    //   183: dup
    //   184: ldc -13
    //   186: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   189: aload_1
    //   190: getfield 241	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   193: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   196: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokestatic 210	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   202: new 212	java/io/FileNotFoundException
    //   205: dup
    //   206: invokespecial 213	java/io/FileNotFoundException:<init>	()V
    //   209: athrow
    //   210: aload_0
    //   211: invokevirtual 247	com/whatsapp/MediaProvider:getContext	()Landroid/content/Context;
    //   214: aload_2
    //   215: invokestatic 252	com/whatsapp/util/MediaFileUtils:a	(Landroid/content/Context;Ljava/io/File;)V
    //   218: aload_2
    //   219: iload_3
    //   220: invokestatic 258	android/os/ParcelFileDescriptor:open	(Ljava/io/File;I)Landroid/os/ParcelFileDescriptor;
    //   223: astore_2
    //   224: aload_2
    //   225: invokestatic 261	com/whatsapp/util/MediaFileUtils:a	(Landroid/os/ParcelFileDescriptor;)V
    //   228: aload_2
    //   229: areturn
    //   230: astore_2
    //   231: new 140	java/lang/StringBuilder
    //   234: dup
    //   235: ldc_w 263
    //   238: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   241: aload_1
    //   242: getfield 241	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   245: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   248: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: aload_2
    //   252: invokestatic 265	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   255: new 212	java/io/FileNotFoundException
    //   258: dup
    //   259: invokespecial 213	java/io/FileNotFoundException:<init>	()V
    //   262: athrow
    //   263: astore_2
    //   264: new 140	java/lang/StringBuilder
    //   267: dup
    //   268: ldc_w 267
    //   271: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   274: aload_1
    //   275: getfield 241	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   278: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   281: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: aload_2
    //   285: invokestatic 265	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   288: new 212	java/io/FileNotFoundException
    //   291: dup
    //   292: invokespecial 213	java/io/FileNotFoundException:<init>	()V
    //   295: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	this	MediaProvider
    //   0	296	1	paramUri	Uri
    //   0	296	2	paramString	String
    //   11	209	3	i	int
    // Exception table:
    //   from	to	target	type
    //   210	218	230	java/io/IOException
    //   224	228	263	java/io/IOException
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    int i;
    switch (a.match(paramUri))
    {
    default: 
      throw new IllegalArgumentException("Unknown URI " + paramUri);
    case 1: 
      return new vf(getContext(), this.b, this.e);
    case 2: 
      paramArrayOfString1 = paramUri.getQueryParameter("bucketId");
      paramUri = paramUri.getQueryParameter("include");
      if (paramUri == null) {
        return new vj(this.c, paramArrayOfString1, this.d.a(paramArrayOfString1, new Byte[] { Byte.valueOf(1), Byte.valueOf(3), Byte.valueOf(13) }));
      }
      i = -1;
      switch (paramUri.hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          return new vj(this.c, paramArrayOfString1, this.d.a(paramArrayOfString1, new Byte[] { Byte.valueOf(1), Byte.valueOf(3), Byte.valueOf(13) }));
          if (paramUri.equals("video"))
          {
            i = 0;
            continue;
            if (paramUri.equals("images"))
            {
              i = 1;
              continue;
              if (paramUri.equals("gif")) {
                i = 2;
              }
            }
          }
          break;
        }
      }
      return new vj(this.c, paramArrayOfString1, this.d.a(paramArrayOfString1, (byte)3));
      return new vj(this.c, paramArrayOfString1, this.d.a(paramArrayOfString1, (byte)1));
      return new vj(this.c, paramArrayOfString1, this.d.a(paramArrayOfString1, (byte)13));
    }
    paramString1 = paramArrayOfString1;
    if (paramArrayOfString1 == null) {
      paramString1 = f;
    }
    paramArrayOfString2 = a(paramUri);
    String[] arrayOfString;
    int j;
    if ((paramArrayOfString2 != null) && ((paramArrayOfString2.N instanceof MediaData)))
    {
      paramArrayOfString1 = paramArrayOfString2.b().file;
      arrayOfString = new String[paramString1.length];
      paramString2 = new Object[paramString1.length];
      i = 0;
      int m = paramString1.length;
      j = 0;
      label440:
      if (j >= m) {
        break label598;
      }
      paramUri = paramString1[j];
      if (!"_display_name".equals(paramUri)) {
        break label543;
      }
      arrayOfString[i] = "_display_name";
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.s != 9) || (TextUtils.isEmpty(paramArrayOfString2.z))) {
        break label526;
      }
      paramUri = paramArrayOfString2.z;
      label500:
      paramString2[i] = paramUri;
      i += 1;
    }
    for (;;)
    {
      j += 1;
      break label440;
      paramArrayOfString1 = null;
      break;
      label526:
      if (paramArrayOfString1 != null)
      {
        paramUri = paramArrayOfString1.getName();
        break label500;
      }
      paramUri = null;
      break label500;
      label543:
      if ("_size".equals(paramUri))
      {
        arrayOfString[i] = "_size";
        int k = i + 1;
        if (paramArrayOfString1 == null) {}
        for (long l = 0L;; l = paramArrayOfString1.length())
        {
          paramString2[i] = Long.valueOf(l);
          i = k;
          break;
        }
        label598:
        paramUri = new String[i];
        System.arraycopy(arrayOfString, 0, paramUri, 0, i);
        paramArrayOfString1 = new Object[i];
        System.arraycopy(paramString2, 0, paramArrayOfString1, 0, i);
        paramUri = new MatrixCursor(paramUri, 1);
        paramUri.addRow(paramArrayOfString1);
        return paramUri;
      }
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/MediaProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */