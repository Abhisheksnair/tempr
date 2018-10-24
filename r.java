package com.whatsapp;

import a.a.a.a.a.a.d;
import a.a.a.a.d;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.Base64;
import com.whatsapp.util.Log;
import dalvik.system.DexFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidParameterException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class r
{
  private static final String[] a = { "com.bluestacks.searchapp", "com.bluestacks.home", "com.bluestacks.setup", "com.bluestacks.appfinder", "com.bluestacks.settings", "com.bluestacks.bstfolder", "com.bluestacks.appsettings", "com.bluestacks.appmart", "com.bluestacks.accelerometerui", "com.bluestacks.BstCommandProcessor", "com.bluestacks.s2p" };
  private static final byte[] b = { 0, 2 };
  private static final byte[] c = { 0, 1 };
  private static final byte[] d = { 0, 2 };
  private static final byte[] e = { 0, 1 };
  private static String f = null;
  private static String g = null;
  private static Boolean h;
  private static Boolean i;
  private static Boolean j;
  private static Boolean k;
  private static int l = 0;
  
  /* Error */
  public static a a(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 86	java/io/File:exists	()Z
    //   4: ifne +10 -> 14
    //   7: ldc 88
    //   9: invokestatic 94	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   12: aconst_null
    //   13: areturn
    //   14: new 96	java/io/FileInputStream
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 100	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   22: astore_2
    //   23: aload_2
    //   24: astore_1
    //   25: aload_2
    //   26: invokestatic 103	com/whatsapp/r:a	(Ljava/io/InputStream;)Lcom/whatsapp/r$a;
    //   29: astore_3
    //   30: aload_2
    //   31: invokevirtual 106	java/io/FileInputStream:close	()V
    //   34: aload_3
    //   35: areturn
    //   36: astore_0
    //   37: new 108	java/lang/StringBuilder
    //   40: dup
    //   41: ldc 110
    //   43: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   46: aload_0
    //   47: invokevirtual 116	java/lang/Exception:toString	()Ljava/lang/String;
    //   50: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 123	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   59: aload_3
    //   60: areturn
    //   61: astore_0
    //   62: aconst_null
    //   63: astore_2
    //   64: aload_2
    //   65: astore_1
    //   66: ldc 125
    //   68: invokestatic 94	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   71: aload_2
    //   72: ifnull -60 -> 12
    //   75: aload_2
    //   76: invokevirtual 106	java/io/FileInputStream:close	()V
    //   79: aconst_null
    //   80: areturn
    //   81: astore_0
    //   82: new 108	java/lang/StringBuilder
    //   85: dup
    //   86: ldc 110
    //   88: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   91: aload_0
    //   92: invokevirtual 116	java/lang/Exception:toString	()Ljava/lang/String;
    //   95: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 123	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   104: aconst_null
    //   105: areturn
    //   106: astore_1
    //   107: aconst_null
    //   108: astore_2
    //   109: aload_2
    //   110: astore_1
    //   111: new 108	java/lang/StringBuilder
    //   114: dup
    //   115: ldc 127
    //   117: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   120: aload_0
    //   121: invokevirtual 130	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   124: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 123	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   133: aload_2
    //   134: ifnull -122 -> 12
    //   137: aload_2
    //   138: invokevirtual 106	java/io/FileInputStream:close	()V
    //   141: aconst_null
    //   142: areturn
    //   143: astore_0
    //   144: new 108	java/lang/StringBuilder
    //   147: dup
    //   148: ldc 110
    //   150: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   153: aload_0
    //   154: invokevirtual 116	java/lang/Exception:toString	()Ljava/lang/String;
    //   157: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 123	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   166: aconst_null
    //   167: areturn
    //   168: astore_1
    //   169: aconst_null
    //   170: astore_0
    //   171: new 108	java/lang/StringBuilder
    //   174: dup
    //   175: ldc -124
    //   177: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   180: aload_1
    //   181: invokevirtual 133	java/io/IOException:toString	()Ljava/lang/String;
    //   184: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 123	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   193: aload_0
    //   194: ifnull -182 -> 12
    //   197: aload_0
    //   198: invokevirtual 106	java/io/FileInputStream:close	()V
    //   201: aconst_null
    //   202: areturn
    //   203: astore_0
    //   204: new 108	java/lang/StringBuilder
    //   207: dup
    //   208: ldc 110
    //   210: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   213: aload_0
    //   214: invokevirtual 116	java/lang/Exception:toString	()Ljava/lang/String;
    //   217: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 123	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   226: aconst_null
    //   227: areturn
    //   228: astore_0
    //   229: aconst_null
    //   230: astore_1
    //   231: aload_1
    //   232: ifnull +7 -> 239
    //   235: aload_1
    //   236: invokevirtual 106	java/io/FileInputStream:close	()V
    //   239: aload_0
    //   240: athrow
    //   241: astore_1
    //   242: new 108	java/lang/StringBuilder
    //   245: dup
    //   246: ldc 110
    //   248: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   251: aload_1
    //   252: invokevirtual 116	java/lang/Exception:toString	()Ljava/lang/String;
    //   255: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokestatic 123	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   264: goto -25 -> 239
    //   267: astore_0
    //   268: goto -37 -> 231
    //   271: astore_2
    //   272: aload_0
    //   273: astore_1
    //   274: aload_2
    //   275: astore_0
    //   276: goto -45 -> 231
    //   279: astore_1
    //   280: aload_2
    //   281: astore_0
    //   282: goto -111 -> 171
    //   285: astore_1
    //   286: goto -177 -> 109
    //   289: astore_0
    //   290: goto -226 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	paramFile	File
    //   24	42	1	localFileInputStream1	java.io.FileInputStream
    //   106	1	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   110	1	1	localFileInputStream2	java.io.FileInputStream
    //   168	13	1	localIOException1	IOException
    //   230	6	1	localObject1	Object
    //   241	11	1	localException	Exception
    //   273	1	1	localFile	File
    //   279	1	1	localIOException2	IOException
    //   285	1	1	localFileNotFoundException2	java.io.FileNotFoundException
    //   22	116	2	localFileInputStream3	java.io.FileInputStream
    //   271	10	2	localObject2	Object
    //   29	31	3	locala	a
    // Exception table:
    //   from	to	target	type
    //   30	34	36	java/lang/Exception
    //   14	23	61	com/whatsapp/r$c
    //   75	79	81	java/lang/Exception
    //   14	23	106	java/io/FileNotFoundException
    //   137	141	143	java/lang/Exception
    //   14	23	168	java/io/IOException
    //   197	201	203	java/lang/Exception
    //   14	23	228	finally
    //   235	239	241	java/lang/Exception
    //   25	30	267	finally
    //   66	71	267	finally
    //   111	133	267	finally
    //   171	193	271	finally
    //   25	30	279	java/io/IOException
    //   25	30	285	java/io/FileNotFoundException
    //   25	30	289	com/whatsapp/r$c
  }
  
  public static a a(InputStream paramInputStream)
  {
    byte[] arrayOfByte1 = new byte[e.length];
    byte[] arrayOfByte2 = new byte[32];
    byte[] arrayOfByte3 = new byte[16];
    byte[] arrayOfByte4 = new byte[16];
    byte[] arrayOfByte5 = new byte[arrayOfByte1.length + 1 + 32 + 16 + 16];
    paramInputStream.read(arrayOfByte5);
    System.arraycopy(arrayOfByte5, 0, arrayOfByte1, 0, e.length);
    int m = e.length + 0;
    if ((!Arrays.equals(arrayOfByte1, d)) && (!Arrays.equals(arrayOfByte1, c))) {
      throw new c();
    }
    int i1 = arrayOfByte5[m];
    int n = m + 1;
    m = 0;
    while (m < 3)
    {
      paramInputStream = new byte[][] { arrayOfByte2, arrayOfByte3, arrayOfByte4 }[m];
      System.arraycopy(arrayOfByte5, n, paramInputStream, 0, paramInputStream.length);
      n += paramInputStream.length;
      m += 1;
    }
    return new a(arrayOfByte1, String.valueOf(i1), arrayOfByte2, arrayOfByte3, arrayOfByte4);
  }
  
  public static String a(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes());
      paramString = c(localMessageDigest.digest());
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString) {}
    return null;
  }
  
  private static String a(boolean paramBoolean)
  {
    Object localObject1 = AccountManager.get(u.a().getApplicationContext());
    if (localObject1 != null)
    {
      localObject1 = ((AccountManager)localObject1).getAccountsByType("com.google");
      if (localObject1 != null)
      {
        int n = localObject1.length;
        int m = 0;
        while (m < n)
        {
          Object localObject2 = localObject1[m];
          if (((Account)localObject2).name != null)
          {
            if (paramBoolean)
            {
              Log.d("acctname/name " + ((Account)localObject2).name);
              return ((Account)localObject2).name;
            }
            m = ((Account)localObject2).name.indexOf('@');
            if (m > 0)
            {
              localObject1 = ((Account)localObject2).name.substring(0, m);
              Log.d("acctname/" + (String)localObject1);
              return (String)localObject1;
            }
            return ((Account)localObject2).name;
          }
          m += 1;
        }
      }
    }
    return "";
  }
  
  /* Error */
  public static SecretKey a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: arraylength
    //   2: newarray <illegal type>
    //   4: astore 5
    //   6: iconst_0
    //   7: istore 4
    //   9: iload 4
    //   11: aload_0
    //   12: arraylength
    //   13: if_icmpge +22 -> 35
    //   16: aload 5
    //   18: iload 4
    //   20: aload_0
    //   21: iload 4
    //   23: baload
    //   24: i2c
    //   25: castore
    //   26: iload 4
    //   28: iconst_1
    //   29: iadd
    //   30: istore 4
    //   32: goto -23 -> 9
    //   35: new 235	javax/crypto/spec/PBEKeySpec
    //   38: dup
    //   39: aload 5
    //   41: aload_1
    //   42: iload_2
    //   43: iload_3
    //   44: invokespecial 238	javax/crypto/spec/PBEKeySpec:<init>	([C[BII)V
    //   47: astore_0
    //   48: ldc -16
    //   50: invokestatic 245	javax/crypto/SecretKeyFactory:getInstance	(Ljava/lang/String;)Ljavax/crypto/SecretKeyFactory;
    //   53: astore_1
    //   54: aload_1
    //   55: aload_0
    //   56: invokevirtual 249	javax/crypto/SecretKeyFactory:generateSecret	(Ljava/security/spec/KeySpec;)Ljavax/crypto/SecretKey;
    //   59: astore_0
    //   60: aload_0
    //   61: areturn
    //   62: astore_0
    //   63: new 251	java/lang/AssertionError
    //   66: dup
    //   67: aload_0
    //   68: invokespecial 254	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   71: athrow
    //   72: astore_0
    //   73: new 251	java/lang/AssertionError
    //   76: dup
    //   77: aload_0
    //   78: invokespecial 254	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	paramArrayOfByte1	byte[]
    //   0	82	1	paramArrayOfByte2	byte[]
    //   0	82	2	paramInt1	int
    //   0	82	3	paramInt2	int
    //   7	24	4	m	int
    //   4	36	5	arrayOfChar	char[]
    // Exception table:
    //   from	to	target	type
    //   48	54	62	java/security/NoSuchAlgorithmException
    //   54	60	72	java/security/spec/InvalidKeySpecException
  }
  
  public static void a(OutputStream paramOutputStream, b paramb)
  {
    int n = 0;
    int m = Byte.parseByte(paramb.a.b);
    byte[] arrayOfByte1 = e;
    byte[] arrayOfByte4 = { m };
    byte[] arrayOfByte2 = paramb.a.c;
    byte[] arrayOfByte3 = paramb.a.d;
    paramb = paramb.a.e;
    while (n < 5)
    {
      paramOutputStream.write(new byte[][] { arrayOfByte1, arrayOfByte4, arrayOfByte2, arrayOfByte3, paramb }[n]);
      n += 1;
    }
  }
  
  private static void a(byte[] paramArrayOfByte, File paramFile)
  {
    try
    {
      paramFile = new ObjectOutputStream(new FileOutputStream(paramFile));
      a.d.a(paramFile);
    }
    finally
    {
      try
      {
        paramFile.writeObject(paramArrayOfByte);
        a.d.a(paramFile);
        return;
      }
      finally {}
      paramArrayOfByte = finally;
      paramFile = null;
    }
    throw paramArrayOfByte;
  }
  
  public static boolean a()
  {
    String str1;
    if (g != null)
    {
      str1 = g;
      if (str1.length() != 0) {
        return true;
      }
    }
    else
    {
      label28:
      String str2;
      label37:
      String str3;
      label46:
      String str4;
      label55:
      String str5;
      if (Build.MANUFACTURER == null)
      {
        str1 = "";
        if (Build.VERSION.RELEASE != null) {
          break label216;
        }
        str2 = "";
        if (Build.DISPLAY != null) {
          break label223;
        }
        str3 = "";
        if (Build.MODEL != null) {
          break label230;
        }
        str4 = "";
        str5 = od.c();
        Log.d("manufacturer " + str1);
        Log.d("release " + str2);
        Log.d("display " + str3);
        Log.d("model " + str4);
        Log.d("kernel_version " + str5);
        if (!str5.toLowerCase(Locale.US).contains("cyanogen")) {
          break label237;
        }
        str1 = "cyanogen";
      }
      for (;;)
      {
        Log.i("app/custom-rom " + str1);
        g = str1;
        break;
        str1 = Build.MANUFACTURER;
        break label28;
        label216:
        str2 = Build.VERSION.RELEASE;
        break label37;
        label223:
        str3 = Build.DISPLAY;
        break label46;
        label230:
        str4 = Build.MODEL;
        break label55;
        label237:
        if (str1.toLowerCase(Locale.US).contains("debug")) {
          str1 = "debug";
        } else if (str2.toLowerCase(Locale.US).contains("debug")) {
          str1 = "debug";
        } else if (str3.toLowerCase(Locale.US).contains("debug")) {
          str1 = "debug";
        } else if (str4.toLowerCase(Locale.US).contains("debug")) {
          str1 = "debug";
        } else if (str5.toLowerCase(Locale.US).contains("debug")) {
          str1 = "debug";
        } else if (str3.startsWith("Darky")) {
          str1 = "darky";
        } else if (str1.startsWith("XDAndroid")) {
          str1 = "xdandroid";
        } else if (str2.startsWith("FroydVillain")) {
          str1 = "froydvillain";
        } else if ((str2.startsWith("VillainROM")) || (str3.startsWith("VillainROM"))) {
          str1 = "villainrom";
        } else if (str2.startsWith("WildPuzzle")) {
          str1 = "wildpuzzle";
        } else if (str3.startsWith("MIUI")) {
          str1 = "miui";
        } else if (str3.startsWith("ITFUNZ")) {
          str1 = "itfunz";
        } else if (str3.startsWith("DebusROM")) {
          str1 = "debus";
        } else if (str3.startsWith("FreeX10")) {
          str1 = "freex10";
        } else if (str3.startsWith("Perception Build")) {
          str1 = "perception";
        } else if (str3.startsWith("Bionix")) {
          str1 = "bionix";
        } else if (str3.startsWith("Lite'ning Rom")) {
          str1 = "litening";
        } else if (str3.startsWith("GINGERVillain")) {
          str1 = "gingervillian";
        } else if (str3.startsWith("GingerReal")) {
          str1 = "gingerreal";
        } else if (str3.startsWith("R.U.R.1920")) {
          str1 = "rur1920";
        } else if (str4.startsWith("MoDaCo")) {
          str1 = "modaco";
        } else if (str3.startsWith("CriskeloROM")) {
          str1 = "criskelorom";
        } else if (str3.startsWith("LeeDrOiD")) {
          str1 = "leedroid";
        } else if (str3.startsWith("Dexter's FolioMod")) {
          str1 = "foliomod";
        } else if (str3.startsWith("Andro-ID")) {
          str1 = "andro-id";
        } else if (str3.startsWith("FroyoPlus")) {
          str1 = "froyoplus";
        } else if (str3.startsWith("PilotxRom")) {
          str1 = "pilotx";
        } else if (str3.startsWith("Achotjan")) {
          str1 = "achotjan";
        } else if (str5.contains("FuguMod")) {
          str1 = "fugu";
        } else if (str5.contains("fakeShmoo")) {
          str1 = "fakeshmoo";
        } else if (str5.contains("LorDmodNCTeam")) {
          str1 = "lordmod";
        } else if (str5.contains("-RCMIX")) {
          str1 = "rcmix";
        } else if (str3.contains("DamianGTO")) {
          str1 = "damiangto";
        } else {
          str1 = "";
        }
      }
    }
    return false;
  }
  
  private static boolean a(and paramand)
  {
    Object localObject = Build.PRODUCT;
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      return true;
      if (!((String)localObject).toLowerCase(Locale.US).contains("sdk"))
      {
        localObject = Build.MODEL;
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).toLowerCase(Locale.US).contains("sdk")))
        {
          localObject = Build.MANUFACTURER;
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).toLowerCase(Locale.US).contains("sdk")) && (paramand.e != null))
          {
            localObject = paramand.f;
            if (localObject != null) {
              try
              {
                localObject = Settings.Secure.getString((ContentResolver)localObject, "android_id");
                if ((!TextUtils.isEmpty((CharSequence)localObject)) && (paramand.c != null)) {
                  return false;
                }
              }
              catch (NullPointerException paramand) {}
            }
          }
        }
      }
    }
    return true;
  }
  
  public static boolean a(and paramand, atu paramatu)
  {
    if (h == null) {
      h = Boolean.valueOf(b(paramand, paramatu));
    }
    return h.booleanValue();
  }
  
  private static boolean a(File paramFile, byte[] paramArrayOfByte1, String paramString, byte[] paramArrayOfByte2)
  {
    try
    {
      byte[] arrayOfByte1 = a(4);
      byte[] arrayOfByte2 = a(16);
      paramString = new SecretKeySpec(a(paramString, arrayOfByte1), "AES/OFB/NoPadding");
      Object localObject = Cipher.getInstance("AES/OFB/NoPadding");
      ((Cipher)localObject).init(1, paramString, new IvParameterSpec(arrayOfByte2));
      paramArrayOfByte1 = ((Cipher)localObject).doFinal(paramArrayOfByte1);
      paramString = new byte[paramArrayOfByte2.length + arrayOfByte1.length + arrayOfByte2.length + paramArrayOfByte1.length];
      int m = 0;
      int n = 0;
      while (m < 4)
      {
        localObject = new byte[][] { paramArrayOfByte2, arrayOfByte1, arrayOfByte2, paramArrayOfByte1 }[m];
        System.arraycopy(localObject, 0, paramString, n, localObject.length);
        n += localObject.length;
        m += 1;
      }
      a(paramString, paramFile);
      boolean bool = Arrays.equals(paramString, b(paramFile));
      return bool;
    }
    catch (Exception paramArrayOfByte1)
    {
      Log.d("unable to write " + paramFile.toString(), paramArrayOfByte1);
    }
    return false;
  }
  
  public static boolean a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    File localFile = new File(u.a().getFilesDir(), "key");
    byte[] arrayOfByte1 = new byte[16];
    int m = Byte.parseByte(paramString);
    paramString = new byte[e.length + 1 + paramArrayOfByte1.length + paramArrayOfByte4.length + paramArrayOfByte3.length + 16 + paramArrayOfByte2.length];
    byte[] arrayOfByte2 = e;
    byte[] arrayOfByte4 = { m };
    int n = 0;
    int i1 = 0;
    while (n < 7)
    {
      byte[] arrayOfByte3 = new byte[][] { arrayOfByte2, arrayOfByte4, paramArrayOfByte1, paramArrayOfByte4, paramArrayOfByte3, arrayOfByte1, paramArrayOfByte2 }[n];
      System.arraycopy(arrayOfByte3, 0, paramString, i1, arrayOfByte3.length);
      i1 += arrayOfByte3.length;
      n += 1;
    }
    try
    {
      a(paramString, localFile);
      paramArrayOfByte1 = b(localFile);
      n();
      boolean bool = Arrays.equals(paramString, paramArrayOfByte1);
      return bool;
    }
    catch (Exception paramString)
    {
      Log.e("backupkey/set/unable-to-write " + paramString.toString());
    }
    return false;
  }
  
  public static boolean a(byte[] paramArrayOfByte, String paramString)
  {
    return a(t(), paramArrayOfByte, aut.q + paramString, b);
  }
  
  private static byte[] a(int paramInt)
  {
    try
    {
      byte[] arrayOfByte = new byte[paramInt];
      SecureRandom.getInstance("SHA1PRNG").nextBytes(arrayOfByte);
      return arrayOfByte;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new RuntimeException(localNoSuchAlgorithmException);
    }
  }
  
  /* Error */
  public static byte[] a(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload 4
    //   8: astore_3
    //   9: aload 5
    //   11: astore_2
    //   12: new 598	java/util/zip/ZipFile
    //   15: dup
    //   16: new 600	android/content/ContextWrapper
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 603	android/content/ContextWrapper:<init>	(Landroid/content/Context;)V
    //   24: invokevirtual 606	android/content/ContextWrapper:getPackageCodePath	()Ljava/lang/String;
    //   27: invokespecial 607	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   30: astore_0
    //   31: aload 4
    //   33: astore_3
    //   34: aload 5
    //   36: astore_2
    //   37: aload_0
    //   38: aload_0
    //   39: ldc_w 609
    //   42: invokevirtual 613	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   45: invokevirtual 617	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   48: astore_0
    //   49: aload_0
    //   50: astore_3
    //   51: aload_0
    //   52: astore_2
    //   53: ldc -90
    //   55: invokestatic 172	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   58: astore 4
    //   60: aload_0
    //   61: astore_3
    //   62: aload_0
    //   63: astore_2
    //   64: sipush 8192
    //   67: newarray <illegal type>
    //   69: astore 5
    //   71: aload_0
    //   72: astore_3
    //   73: aload_0
    //   74: astore_2
    //   75: aload_0
    //   76: aload 5
    //   78: invokevirtual 139	java/io/InputStream:read	([B)I
    //   81: istore_1
    //   82: iload_1
    //   83: ifle +61 -> 144
    //   86: aload_0
    //   87: astore_3
    //   88: aload_0
    //   89: astore_2
    //   90: aload 4
    //   92: aload 5
    //   94: iconst_0
    //   95: iload_1
    //   96: invokevirtual 620	java/security/MessageDigest:update	([BII)V
    //   99: goto -28 -> 71
    //   102: astore_0
    //   103: aload_3
    //   104: astore_2
    //   105: new 108	java/lang/StringBuilder
    //   108: dup
    //   109: ldc_w 622
    //   112: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   115: aload_0
    //   116: invokevirtual 116	java/lang/Exception:toString	()Ljava/lang/String;
    //   119: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 123	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   128: aload_3
    //   129: invokestatic 291	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   132: ldc_w 624
    //   135: ldc_w 626
    //   138: invokevirtual 629	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   141: astore_0
    //   142: aload_0
    //   143: areturn
    //   144: aload_0
    //   145: astore_3
    //   146: aload_0
    //   147: astore_2
    //   148: aload 4
    //   150: invokevirtual 183	java/security/MessageDigest:digest	()[B
    //   153: astore 4
    //   155: aload_0
    //   156: invokestatic 291	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   159: aload 4
    //   161: areturn
    //   162: astore_0
    //   163: aload_2
    //   164: invokestatic 291	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   167: aload_0
    //   168: athrow
    //   169: astore_0
    //   170: new 631	java/lang/Error
    //   173: dup
    //   174: aload_0
    //   175: invokespecial 632	java/lang/Error:<init>	(Ljava/lang/Throwable;)V
    //   178: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	paramContext	Context
    //   81	15	1	m	int
    //   11	153	2	localObject1	Object
    //   8	138	3	localObject2	Object
    //   4	156	4	localObject3	Object
    //   1	92	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   12	31	102	java/lang/Exception
    //   37	49	102	java/lang/Exception
    //   53	60	102	java/lang/Exception
    //   64	71	102	java/lang/Exception
    //   75	82	102	java/lang/Exception
    //   90	99	102	java/lang/Exception
    //   148	155	102	java/lang/Exception
    //   12	31	162	finally
    //   37	49	162	finally
    //   53	60	162	finally
    //   64	71	162	finally
    //   75	82	162	finally
    //   90	99	162	finally
    //   105	128	162	finally
    //   148	155	162	finally
    //   132	142	169	java/io/UnsupportedEncodingException
  }
  
  private static byte[] a(File paramFile, String paramString, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = b(paramFile);
    if (arrayOfByte != null) {
      try
      {
        if (arrayOfByte.length < paramArrayOfByte.length + 4 + 16 + 20) {
          throw new InvalidParameterException(paramFile.toString() + " size mismatch");
        }
      }
      catch (Exception paramString)
      {
        paramFile.delete();
        if ((paramString instanceof c))
        {
          throw ((c)paramString);
          Object localObject = new byte[paramArrayOfByte.length];
          System.arraycopy(arrayOfByte, 0, localObject, 0, paramArrayOfByte.length);
          int m = paramArrayOfByte.length + 0;
          if (!Arrays.equals((byte[])localObject, paramArrayOfByte)) {
            throw new c();
          }
          localObject = new byte[4];
          System.arraycopy(arrayOfByte, m, localObject, 0, 4);
          m += 4;
          paramArrayOfByte = new byte[16];
          System.arraycopy(arrayOfByte, m, paramArrayOfByte, 0, 16);
          m += 16;
          paramString = new SecretKeySpec(a(paramString, (byte[])localObject), "AES/OFB/NoPadding");
          localObject = Cipher.getInstance("AES/OFB/NoPadding");
          ((Cipher)localObject).init(2, paramString, new IvParameterSpec(paramArrayOfByte));
          paramString = ((Cipher)localObject).doFinal(arrayOfByte, m, arrayOfByte.length - m);
          return paramString;
        }
        throw new RuntimeException(paramString);
      }
    }
    return null;
  }
  
  private static byte[] a(String paramString, byte[] paramArrayOfByte)
  {
    return new SecretKeySpec(a(paramString.getBytes(), paramArrayOfByte, 16, 128).getEncoded(), "AES").getEncoded();
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, e, false);
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, boolean paramBoolean)
  {
    Object localObject3 = null;
    Object localObject1;
    Object localObject2;
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-256");
      if (localMessageDigest == null)
      {
        Log.e("calculateahash/digester is null");
        return null;
      }
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      for (;;)
      {
        Log.e("calculateahash/digester " + localNoSuchAlgorithmException.toString());
        localObject1 = null;
      }
      localObject2 = "";
      if (paramBoolean) {
        localObject2 = a(Arrays.equals(paramArrayOfByte2, c));
      }
      if (localObject2 == null) {}
    }
    for (;;)
    {
      try
      {
        paramArrayOfByte2 = ((String)localObject2).getBytes("UTF-8");
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException1)
      {
        paramArrayOfByte2 = (byte[])localObject3;
        Log.e("calculateahash/encoding/error " + localUnsupportedEncodingException1.toString());
        m = 0;
        continue;
      }
      try
      {
        m = paramArrayOfByte2.length;
        localObject2 = new byte[paramArrayOfByte1.length + m];
        if (m <= 0) {
          break label182;
        }
        System.arraycopy(paramArrayOfByte2, 0, localObject2, 0, paramArrayOfByte2.length);
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException2)
      {
        continue;
        m = 0;
        continue;
      }
      System.arraycopy(paramArrayOfByte1, 0, localObject2, m, paramArrayOfByte1.length);
      ((MessageDigest)localObject1).reset();
      ((MessageDigest)localObject1).update((byte[])localObject2);
      return ((MessageDigest)localObject1).digest();
      label182:
      paramArrayOfByte2 = null;
      int m = 0;
    }
  }
  
  public static String b(Context paramContext)
  {
    paramContext = d.j(paramContext);
    if ((paramContext == null) || (paramContext.length == 0)) {
      return null;
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-256");
      localMessageDigest.reset();
      int n = paramContext.length;
      int m = 0;
      while (m < n)
      {
        localMessageDigest.update(paramContext[m].toByteArray());
        m += 1;
      }
      return Base64.encodeToString(localMessageDigest.digest(), 2);
    }
    catch (NoSuchAlgorithmException paramContext)
    {
      Log.e(paramContext);
      return null;
    }
  }
  
  static boolean b()
  {
    try
    {
      Class.forName("org.acra.ACRA");
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return false;
  }
  
  /* Error */
  private static boolean b(and paramand, atu paramatu)
  {
    // Byte code:
    //   0: iconst_2
    //   1: istore_3
    //   2: getstatic 706	android/os/Build:TAGS	Ljava/lang/String;
    //   5: astore 6
    //   7: aload 6
    //   9: ifnull +16 -> 25
    //   12: aload 6
    //   14: ldc_w 708
    //   17: invokevirtual 341	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   20: ifeq +5 -> 25
    //   23: iconst_1
    //   24: ireturn
    //   25: new 82	java/io/File
    //   28: dup
    //   29: ldc_w 710
    //   32: invokespecial 711	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: invokevirtual 86	java/io/File:exists	()Z
    //   38: istore 5
    //   40: iload 5
    //   42: ifne -19 -> 23
    //   45: new 82	java/io/File
    //   48: dup
    //   49: ldc_w 713
    //   52: invokespecial 711	java/io/File:<init>	(Ljava/lang/String;)V
    //   55: astore 7
    //   57: new 82	java/io/File
    //   60: dup
    //   61: ldc_w 715
    //   64: invokespecial 711	java/io/File:<init>	(Ljava/lang/String;)V
    //   67: astore 6
    //   69: aload 7
    //   71: invokevirtual 718	java/io/File:canExecute	()Z
    //   74: istore 5
    //   76: iload 5
    //   78: ifeq +285 -> 363
    //   81: iconst_1
    //   82: istore_2
    //   83: aload 6
    //   85: invokevirtual 718	java/io/File:canExecute	()Z
    //   88: istore 5
    //   90: iload 5
    //   92: ifeq +276 -> 368
    //   95: iconst_1
    //   96: istore_3
    //   97: aload_0
    //   98: invokestatic 720	com/whatsapp/r:a	(Lcom/whatsapp/and;)Z
    //   101: istore 5
    //   103: aload_1
    //   104: ldc_w 722
    //   107: invokevirtual 727	com/whatsapp/atu:a	(Ljava/lang/String;)I
    //   110: ifeq +292 -> 402
    //   113: aconst_null
    //   114: astore_0
    //   115: aload_0
    //   116: ifnonnull +338 -> 454
    //   119: ldc_w 729
    //   122: astore_0
    //   123: new 108	java/lang/StringBuilder
    //   126: dup
    //   127: ldc_w 731
    //   130: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   133: astore_1
    //   134: aload 7
    //   136: invokevirtual 86	java/io/File:exists	()Z
    //   139: ifeq +335 -> 474
    //   142: iconst_1
    //   143: istore 4
    //   145: aload_1
    //   146: iload 4
    //   148: invokevirtual 734	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   151: astore_1
    //   152: aload 7
    //   154: invokevirtual 737	java/io/File:canRead	()Z
    //   157: ifeq +323 -> 480
    //   160: iconst_1
    //   161: istore 4
    //   163: aload_1
    //   164: iload 4
    //   166: invokevirtual 734	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   169: astore_1
    //   170: aload 7
    //   172: invokevirtual 740	java/io/File:canWrite	()Z
    //   175: ifeq +311 -> 486
    //   178: iconst_1
    //   179: istore 4
    //   181: aload_1
    //   182: iload 4
    //   184: invokevirtual 734	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   187: iload_2
    //   188: invokevirtual 734	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   191: astore 8
    //   193: iload 5
    //   195: ifeq +297 -> 492
    //   198: ldc_w 742
    //   201: astore_1
    //   202: aload 8
    //   204: aload_1
    //   205: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload_0
    //   209: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 345	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   218: new 108	java/lang/StringBuilder
    //   221: dup
    //   222: ldc_w 731
    //   225: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   228: astore_1
    //   229: aload 6
    //   231: invokevirtual 86	java/io/File:exists	()Z
    //   234: ifeq +264 -> 498
    //   237: iconst_1
    //   238: istore_2
    //   239: aload_1
    //   240: iload_2
    //   241: invokevirtual 734	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   244: astore_1
    //   245: aload 6
    //   247: invokevirtual 737	java/io/File:canRead	()Z
    //   250: ifeq +253 -> 503
    //   253: iconst_1
    //   254: istore_2
    //   255: aload_1
    //   256: iload_2
    //   257: invokevirtual 734	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   260: astore_1
    //   261: aload 6
    //   263: invokevirtual 740	java/io/File:canWrite	()Z
    //   266: ifeq +242 -> 508
    //   269: iconst_1
    //   270: istore_2
    //   271: aload_1
    //   272: iload_2
    //   273: invokevirtual 734	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   276: iload_3
    //   277: invokevirtual 734	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   280: astore 8
    //   282: iload 5
    //   284: ifeq +229 -> 513
    //   287: ldc_w 742
    //   290: astore_1
    //   291: aload 8
    //   293: aload_1
    //   294: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: aload_0
    //   298: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokestatic 345	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   307: aload 7
    //   309: invokevirtual 86	java/io/File:exists	()Z
    //   312: ifne -289 -> 23
    //   315: aload 6
    //   317: invokevirtual 86	java/io/File:exists	()Z
    //   320: ifne -297 -> 23
    //   323: new 96	java/io/FileInputStream
    //   326: dup
    //   327: aload 7
    //   329: invokespecial 100	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   332: astore_0
    //   333: aload_0
    //   334: invokestatic 291	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   337: aload_0
    //   338: ifnonnull -315 -> 23
    //   341: new 96	java/io/FileInputStream
    //   344: dup
    //   345: aload 6
    //   347: invokespecial 100	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   350: astore_1
    //   351: aload_1
    //   352: invokestatic 291	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   355: aload_1
    //   356: astore_0
    //   357: aload_0
    //   358: ifnonnull -335 -> 23
    //   361: iconst_0
    //   362: ireturn
    //   363: iconst_0
    //   364: istore_2
    //   365: goto -282 -> 83
    //   368: iconst_0
    //   369: istore_3
    //   370: goto -273 -> 97
    //   373: astore 8
    //   375: iconst_2
    //   376: istore_2
    //   377: new 108	java/lang/StringBuilder
    //   380: dup
    //   381: ldc_w 744
    //   384: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   387: getstatic 747	android/os/Build$VERSION:SDK_INT	I
    //   390: invokevirtual 734	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   393: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: invokestatic 345	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   399: goto -302 -> 97
    //   402: aload_0
    //   403: getfield 495	com/whatsapp/and:c	Landroid/telephony/TelephonyManager;
    //   406: astore_0
    //   407: aload_0
    //   408: ifnull +39 -> 447
    //   411: aload_0
    //   412: invokevirtual 752	android/telephony/TelephonyManager:getSubscriberId	()Ljava/lang/String;
    //   415: astore_0
    //   416: aload_0
    //   417: invokestatic 474	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   420: ifeq +10 -> 430
    //   423: getstatic 755	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   426: astore_0
    //   427: goto -312 -> 115
    //   430: aload_0
    //   431: ldc_w 757
    //   434: invokevirtual 341	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   437: ifeq +10 -> 447
    //   440: getstatic 755	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   443: astore_0
    //   444: goto -329 -> 115
    //   447: getstatic 760	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   450: astore_0
    //   451: goto -336 -> 115
    //   454: aload_0
    //   455: invokevirtual 508	java/lang/Boolean:booleanValue	()Z
    //   458: ifeq +10 -> 468
    //   461: ldc_w 762
    //   464: astore_0
    //   465: goto -342 -> 123
    //   468: ldc -26
    //   470: astore_0
    //   471: goto -348 -> 123
    //   474: iconst_0
    //   475: istore 4
    //   477: goto -332 -> 145
    //   480: iconst_0
    //   481: istore 4
    //   483: goto -320 -> 163
    //   486: iconst_0
    //   487: istore 4
    //   489: goto -308 -> 181
    //   492: ldc -26
    //   494: astore_1
    //   495: goto -293 -> 202
    //   498: iconst_0
    //   499: istore_2
    //   500: goto -261 -> 239
    //   503: iconst_0
    //   504: istore_2
    //   505: goto -250 -> 255
    //   508: iconst_0
    //   509: istore_2
    //   510: goto -239 -> 271
    //   513: ldc -26
    //   515: astore_1
    //   516: goto -225 -> 291
    //   519: astore_0
    //   520: aconst_null
    //   521: invokestatic 291	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   524: aconst_null
    //   525: astore_0
    //   526: goto -189 -> 337
    //   529: astore_0
    //   530: aconst_null
    //   531: invokestatic 291	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   534: aload_0
    //   535: athrow
    //   536: astore_1
    //   537: aload_0
    //   538: invokestatic 291	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   541: goto -184 -> 357
    //   544: astore_1
    //   545: aload_0
    //   546: invokestatic 291	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   549: aload_1
    //   550: athrow
    //   551: astore 8
    //   553: goto -176 -> 377
    //   556: astore 8
    //   558: iconst_2
    //   559: istore_2
    //   560: goto -463 -> 97
    //   563: astore 8
    //   565: goto -468 -> 97
    //   568: astore 6
    //   570: goto -525 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	573	0	paramand	and
    //   0	573	1	paramatu	atu
    //   82	478	2	m	int
    //   1	369	3	n	int
    //   143	345	4	i1	int
    //   38	245	5	bool	boolean
    //   5	341	6	localObject	Object
    //   568	1	6	localException1	Exception
    //   55	273	7	localFile	File
    //   191	101	8	localStringBuilder	StringBuilder
    //   373	1	8	localNoSuchMethodError1	NoSuchMethodError
    //   551	1	8	localNoSuchMethodError2	NoSuchMethodError
    //   556	1	8	localException2	Exception
    //   563	1	8	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   69	76	373	java/lang/NoSuchMethodError
    //   323	333	519	java/lang/Exception
    //   323	333	529	finally
    //   341	351	536	java/lang/Exception
    //   341	351	544	finally
    //   83	90	551	java/lang/NoSuchMethodError
    //   69	76	556	java/lang/Exception
    //   83	90	563	java/lang/Exception
    //   25	40	568	java/lang/Exception
  }
  
  public static boolean b(String paramString)
  {
    File localFile = t();
    if ((!localFile.exists()) || (localFile.length() <= 0L)) {}
    while (c(paramString) == null) {
      return false;
    }
    return true;
  }
  
  /* Error */
  private static byte[] b(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 86	java/io/File:exists	()Z
    //   4: ifeq +68 -> 72
    //   7: aload_0
    //   8: invokevirtual 765	java/io/File:length	()J
    //   11: lconst_0
    //   12: lcmp
    //   13: ifle +59 -> 72
    //   16: new 771	java/io/ObjectInputStream
    //   19: dup
    //   20: new 96	java/io/FileInputStream
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 100	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   28: invokespecial 774	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   31: astore_3
    //   32: aload_3
    //   33: invokevirtual 778	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   36: checkcast 154	[B
    //   39: astore_0
    //   40: aload_3
    //   41: invokevirtual 779	java/io/ObjectInputStream:close	()V
    //   44: aload_0
    //   45: areturn
    //   46: astore_0
    //   47: aload_0
    //   48: athrow
    //   49: astore_1
    //   50: aload_0
    //   51: astore_2
    //   52: aload_1
    //   53: astore_0
    //   54: aload_2
    //   55: ifnull +19 -> 74
    //   58: aload_3
    //   59: invokevirtual 779	java/io/ObjectInputStream:close	()V
    //   62: aload_0
    //   63: athrow
    //   64: astore_0
    //   65: ldc_w 781
    //   68: aload_0
    //   69: invokestatic 783	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   72: aconst_null
    //   73: areturn
    //   74: aload_3
    //   75: invokevirtual 779	java/io/ObjectInputStream:close	()V
    //   78: goto -16 -> 62
    //   81: astore_1
    //   82: goto -20 -> 62
    //   85: astore_0
    //   86: aconst_null
    //   87: astore_2
    //   88: goto -34 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	paramFile	File
    //   49	4	1	localObject	Object
    //   81	1	1	localThrowable	Throwable
    //   51	37	2	localFile	File
    //   31	44	3	localObjectInputStream	java.io.ObjectInputStream
    // Exception table:
    //   from	to	target	type
    //   32	40	46	java/lang/Throwable
    //   47	49	49	finally
    //   16	32	64	java/lang/Exception
    //   40	44	64	java/lang/Exception
    //   58	62	64	java/lang/Exception
    //   62	64	64	java/lang/Exception
    //   74	78	64	java/lang/Exception
    //   58	62	81	java/lang/Throwable
    //   32	40	85	finally
  }
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    if (f == null) {
      f = a(true);
    }
    Object localObject1 = f;
    try
    {
      localObject1 = MessageDigest.getInstance("MD5").digest(((String)localObject1).getBytes("UTF-8"));
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        int m = 0;
        while (m < paramArrayOfByte.length)
        {
          paramArrayOfByte[m] = ((byte)(paramArrayOfByte[m] ^ localObject1[(m % localObject1.length)]));
          m += 1;
        }
      }
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;) {}
    }
  }
  
  static int c()
  {
    AccountManager localAccountManager = AccountManager.get(u.a());
    int m = -1;
    if (localAccountManager != null) {}
    try
    {
      m = localAccountManager.getAccountsByType("com.google").length;
      return m;
    }
    catch (Exception localException) {}
    return -1;
  }
  
  public static String c(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int n = paramArrayOfByte.length;
    int m = 0;
    while (m < n)
    {
      int i1 = paramArrayOfByte[m];
      localStringBuilder.append(Character.forDigit(i1 >>> 4 & 0xF, 16));
      localStringBuilder.append(Character.forDigit(i1 & 0xF, 16));
      m += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static byte[] c(String paramString)
  {
    try
    {
      paramString = a(t(), aut.q + paramString, b);
      return paramString;
    }
    catch (c paramString)
    {
      Log.c("recovery token header mismatch", paramString);
    }
    return null;
  }
  
  static Boolean d()
  {
    try
    {
      boolean bool = Environment.getExternalStorageState().equals("mounted");
      return Boolean.valueOf(bool);
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static byte[] e()
  {
    return a(16);
  }
  
  static boolean f()
  {
    if (i != null) {
      return i.booleanValue();
    }
    try
    {
      if (new File("/system/lib/libc_malloc_debug_qemu.so").exists()) {}
      for (i = Boolean.valueOf(true);; i = Boolean.valueOf(false)) {
        return i.booleanValue();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        i = Boolean.valueOf(false);
      }
    }
  }
  
  static boolean g()
  {
    int m = 0;
    if (j != null) {
      return j.booleanValue();
    }
    try
    {
      bool = new File("/mnt/sdcard/bstfolder/InputMapper/com.bluestacks.appmart.cfg").exists();
      if (!bool) {
        break label81;
      }
      bool = true;
    }
    catch (Exception localException)
    {
      boolean bool;
      for (;;)
      {
        String[] arrayOfString;
        int n;
        bool = false;
      }
      localBoolean = Boolean.valueOf(bool);
      j = localBoolean;
      return localBoolean.booleanValue();
    }
    arrayOfString = a;
    n = arrayOfString.length;
    while (m < n)
    {
      String str = arrayOfString[m];
      PackageManager localPackageManager = u.a().getPackageManager();
      try
      {
        localPackageManager.getPackageInfo(str, 128);
        bool = true;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        Boolean localBoolean;
        for (;;) {}
      }
      m += 1;
    }
  }
  
  static boolean h()
  {
    boolean bool2 = true;
    if (k != null) {
      return k.booleanValue();
    }
    boolean bool1 = false;
    try
    {
      boolean bool3 = new File("/dev/com.genymotion.superuser.daemon").exists();
      if (bool3) {
        bool1 = true;
      }
    }
    catch (Exception localException)
    {
      Object localObject;
      for (;;) {}
    }
    localObject = u.a().getPackageManager();
    try
    {
      ((PackageManager)localObject).getPackageInfo("com.genymotion.superuser", 128);
      bool1 = bool2;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;) {}
    }
    localObject = Boolean.valueOf(bool1);
    k = (Boolean)localObject;
    return ((Boolean)localObject).booleanValue();
  }
  
  public static byte[] i()
  {
    try
    {
      Object localObject = KeyGenerator.getInstance("AES");
      ((KeyGenerator)localObject).init(160, SecureRandom.getInstance("SHA1PRNG"));
      localObject = ((KeyGenerator)localObject).generateKey().getEncoded();
      return (byte[])localObject;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }
  
  public static void j()
  {
    t().delete();
  }
  
  public static boolean k()
  {
    return t().exists();
  }
  
  public static boolean l()
  {
    return !u().exists();
  }
  
  public static boolean m()
  {
    return u().delete();
  }
  
  public static b n()
  {
    Object localObject = u();
    if (!((File)localObject).exists()) {
      Log.w("backupkey/getinfo/does-not-exist");
    }
    byte[] arrayOfByte1;
    do
    {
      return null;
      arrayOfByte1 = b((File)localObject);
    } while (arrayOfByte1 == null);
    if (arrayOfByte1.length < e.length + 1 + 32 + 16 + 32 + 16 + 32) {
      throw new InvalidParameterException(((File)localObject).toString() + " size mismatch");
    }
    localObject = new byte[e.length];
    System.arraycopy(arrayOfByte1, 0, localObject, 0, e.length);
    int m = e.length + 0;
    if (!Arrays.equals((byte[])localObject, e)) {
      throw new c();
    }
    int n = m + 1;
    m = arrayOfByte1[m];
    byte[] arrayOfByte2 = new byte[32];
    System.arraycopy(arrayOfByte1, n, arrayOfByte2, 0, 32);
    n += 32;
    byte[] arrayOfByte3 = new byte[16];
    System.arraycopy(arrayOfByte1, n, arrayOfByte3, 0, 16);
    n += 16;
    byte[] arrayOfByte4 = new byte[32];
    System.arraycopy(arrayOfByte1, n, arrayOfByte4, 0, 32);
    byte[] arrayOfByte5 = a(16);
    byte[] arrayOfByte6 = new byte[32];
    System.arraycopy(arrayOfByte1, n + 32 + 16, arrayOfByte6, 0, 32);
    return new b((byte[])localObject, String.valueOf(m), arrayOfByte2, arrayOfByte3, arrayOfByte4, arrayOfByte5, arrayOfByte6);
  }
  
  public static boolean o()
  {
    try
    {
      b localb = n();
      if ((localb == null) || (localb.a.d == null) || (localb.b == null)) {
        return false;
      }
    }
    catch (Exception localException)
    {
      Log.c("checkaccounthashvalidity/error", localException);
      return false;
    }
    return Arrays.equals(a(localException.a.d), localException.b);
  }
  
  public static int p()
  {
    if (l != 0) {
      return l;
    }
    try
    {
      Enumeration localEnumeration = new DexFile(u.a().getApplicationInfo().sourceDir).entries();
      while (localEnumeration.hasMoreElements())
      {
        localEnumeration.nextElement();
        l += 1;
      }
      return l;
    }
    catch (IOException localIOException)
    {
      Log.e(localIOException);
    }
  }
  
  public static String q()
  {
    localStringBuilder = new StringBuilder();
    int m = 15;
    try
    {
      Enumeration localEnumeration = new DexFile(u.a().getApplicationInfo().sourceDir).entries();
      while (localEnumeration.hasMoreElements())
      {
        m -= 1;
        if (m < 0) {
          break;
        }
        localStringBuilder.append((String)localEnumeration.nextElement());
        localStringBuilder.append(";");
      }
      return localStringBuilder.toString();
    }
    catch (IOException localIOException)
    {
      Log.e(localIOException);
    }
  }
  
  /* Error */
  public static boolean r()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: iconst_0
    //   4: istore_1
    //   5: invokestatic 896	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   8: ldc_w 898
    //   11: invokevirtual 902	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   14: astore 6
    //   16: new 904	java/io/BufferedInputStream
    //   19: dup
    //   20: aload 6
    //   22: invokevirtual 909	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   25: invokespecial 910	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   28: astore 5
    //   30: new 904	java/io/BufferedInputStream
    //   33: dup
    //   34: aload 6
    //   36: invokevirtual 913	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   39: invokespecial 910	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   42: astore_3
    //   43: aload 6
    //   45: invokevirtual 916	java/lang/Process:waitFor	()I
    //   48: pop
    //   49: aload_3
    //   50: invokevirtual 919	java/io/BufferedInputStream:available	()I
    //   53: istore_0
    //   54: aload_3
    //   55: iload_0
    //   56: newarray <illegal type>
    //   58: iconst_0
    //   59: iload_0
    //   60: invokevirtual 922	java/io/BufferedInputStream:read	([BII)I
    //   63: pop
    //   64: aload 5
    //   66: invokevirtual 919	java/io/BufferedInputStream:available	()I
    //   69: istore_0
    //   70: iload_0
    //   71: newarray <illegal type>
    //   73: astore 4
    //   75: aload 5
    //   77: aload 4
    //   79: iconst_0
    //   80: iload_0
    //   81: invokevirtual 922	java/io/BufferedInputStream:read	([BII)I
    //   84: pop
    //   85: new 31	java/lang/String
    //   88: dup
    //   89: aload 4
    //   91: invokespecial 923	java/lang/String:<init>	([B)V
    //   94: ldc_w 925
    //   97: invokevirtual 341	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   100: istore_2
    //   101: iload_2
    //   102: ifeq +16 -> 118
    //   105: aload 5
    //   107: invokevirtual 926	java/io/BufferedInputStream:close	()V
    //   110: aload_3
    //   111: invokevirtual 926	java/io/BufferedInputStream:close	()V
    //   114: iconst_1
    //   115: istore_1
    //   116: iload_1
    //   117: ireturn
    //   118: aload 5
    //   120: invokevirtual 926	java/io/BufferedInputStream:close	()V
    //   123: aload_3
    //   124: invokevirtual 926	java/io/BufferedInputStream:close	()V
    //   127: iconst_0
    //   128: ireturn
    //   129: astore_3
    //   130: iconst_0
    //   131: ireturn
    //   132: astore 5
    //   134: aconst_null
    //   135: astore_3
    //   136: aload 5
    //   138: invokestatic 685	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   141: aload 4
    //   143: ifnull +8 -> 151
    //   146: aload 4
    //   148: invokevirtual 926	java/io/BufferedInputStream:close	()V
    //   151: aload_3
    //   152: ifnull -36 -> 116
    //   155: aload_3
    //   156: invokevirtual 926	java/io/BufferedInputStream:close	()V
    //   159: iconst_0
    //   160: ireturn
    //   161: astore_3
    //   162: iconst_0
    //   163: ireturn
    //   164: astore 4
    //   166: aconst_null
    //   167: astore_3
    //   168: aconst_null
    //   169: astore 5
    //   171: aload 5
    //   173: ifnull +8 -> 181
    //   176: aload 5
    //   178: invokevirtual 926	java/io/BufferedInputStream:close	()V
    //   181: aload_3
    //   182: ifnull +7 -> 189
    //   185: aload_3
    //   186: invokevirtual 926	java/io/BufferedInputStream:close	()V
    //   189: aload 4
    //   191: athrow
    //   192: astore 4
    //   194: goto -84 -> 110
    //   197: astore_3
    //   198: goto -84 -> 114
    //   201: astore 4
    //   203: goto -80 -> 123
    //   206: astore 4
    //   208: goto -57 -> 151
    //   211: astore 5
    //   213: goto -32 -> 181
    //   216: astore_3
    //   217: goto -28 -> 189
    //   220: astore 4
    //   222: aconst_null
    //   223: astore_3
    //   224: goto -53 -> 171
    //   227: astore 4
    //   229: goto -58 -> 171
    //   232: astore 6
    //   234: aload 4
    //   236: astore 5
    //   238: aload 6
    //   240: astore 4
    //   242: goto -71 -> 171
    //   245: astore 6
    //   247: aconst_null
    //   248: astore_3
    //   249: aload 5
    //   251: astore 4
    //   253: aload 6
    //   255: astore 5
    //   257: goto -121 -> 136
    //   260: astore 6
    //   262: aload 5
    //   264: astore 4
    //   266: aload 6
    //   268: astore 5
    //   270: goto -134 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   53	28	0	m	int
    //   4	113	1	bool1	boolean
    //   100	2	2	bool2	boolean
    //   42	82	3	localBufferedInputStream1	java.io.BufferedInputStream
    //   129	1	3	localIOException1	IOException
    //   135	21	3	localObject1	Object
    //   161	1	3	localIOException2	IOException
    //   167	19	3	localObject2	Object
    //   197	1	3	localIOException3	IOException
    //   216	1	3	localIOException4	IOException
    //   223	26	3	localObject3	Object
    //   1	146	4	arrayOfByte	byte[]
    //   164	26	4	localObject4	Object
    //   192	1	4	localIOException5	IOException
    //   201	1	4	localIOException6	IOException
    //   206	1	4	localIOException7	IOException
    //   220	1	4	localObject5	Object
    //   227	8	4	localObject6	Object
    //   240	25	4	localObject7	Object
    //   28	91	5	localBufferedInputStream2	java.io.BufferedInputStream
    //   132	5	5	localException1	Exception
    //   169	8	5	localObject8	Object
    //   211	1	5	localIOException8	IOException
    //   236	33	5	localObject9	Object
    //   14	30	6	localProcess	Process
    //   232	7	6	localObject10	Object
    //   245	9	6	localException2	Exception
    //   260	7	6	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   123	127	129	java/io/IOException
    //   5	30	132	java/lang/Exception
    //   155	159	161	java/io/IOException
    //   5	30	164	finally
    //   105	110	192	java/io/IOException
    //   110	114	197	java/io/IOException
    //   118	123	201	java/io/IOException
    //   146	151	206	java/io/IOException
    //   176	181	211	java/io/IOException
    //   185	189	216	java/io/IOException
    //   30	43	220	finally
    //   43	101	227	finally
    //   136	141	232	finally
    //   30	43	245	java/lang/Exception
    //   43	101	260	java/lang/Exception
  }
  
  public static boolean s()
  {
    return "robolectric".equals(Build.FINGERPRINT);
  }
  
  private static File t()
  {
    return new File(u.a().getFilesDir(), "rc2");
  }
  
  private static File u()
  {
    return new File(u.a().getFilesDir(), "key");
  }
  
  public static final class a
  {
    public byte[] a;
    public String b;
    public byte[] c;
    public byte[] d;
    public byte[] e;
    
    public a(byte[] paramArrayOfByte1, String paramString, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
    {
      this.a = paramArrayOfByte1;
      this.b = paramString;
      this.c = paramArrayOfByte2;
      this.d = paramArrayOfByte3;
      this.e = paramArrayOfByte4;
    }
    
    public final String toString()
    {
      return "BackupCipher [cipherVersion=" + Arrays.toString(this.a) + " keyVersion=" + this.b + ", serverSalt=" + Arrays.toString(this.c) + ", googleIdSalt=" + Arrays.toString(this.d) + ", encryptionIv=" + Arrays.toString(this.e) + "]";
    }
  }
  
  public static final class b
  {
    public r.a a;
    public byte[] b;
    public byte[] c;
    
    public b(byte[] paramArrayOfByte1, String paramString, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6)
    {
      this.a = new r.a(paramArrayOfByte1, paramString, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte5);
      this.b = paramArrayOfByte4;
      this.c = paramArrayOfByte6;
    }
    
    public final String toString()
    {
      return "BackupKey [" + this.a.toString() + ", hashedGoogleId=" + Arrays.toString(this.b) + ", cipherKey=" + Arrays.toString(this.c) + "]";
    }
  }
  
  public static final class c
    extends Exception
  {}
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */