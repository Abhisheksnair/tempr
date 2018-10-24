package com.whatsapp.p;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.os.Build.VERSION;
import com.whatsapp.and;
import com.whatsapp.util.Log;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;

public final class a
{
  private static final FileFilter a = ;
  
  public static int a()
  {
    if (Build.VERSION.SDK_INT == 10) {
      return 1;
    }
    try
    {
      int i = new File("/sys/devices/system/cpu/").listFiles(a).length;
      return i;
    }
    catch (NullPointerException localNullPointerException)
    {
      return -1;
    }
    catch (SecurityException localSecurityException)
    {
      for (;;) {}
    }
  }
  
  private static int a(String paramString, FileInputStream paramFileInputStream)
  {
    byte[] arrayOfByte = new byte['Ѐ'];
    int m;
    int j;
    int i;
    try
    {
      m = paramFileInputStream.read(arrayOfByte);
      j = 0;
    }
    catch (NumberFormatException paramString)
    {
      int n;
      return -1;
    }
    catch (IOException paramString)
    {
      for (;;) {}
    }
    int k = i;
    if (j < m)
    {
      n = j - i;
      k = i;
      if (arrayOfByte[j] == paramString.charAt(n)) {
        if (n == paramString.length() - 1) {
          break label156;
        }
      }
    }
    for (;;)
    {
      i = Integer.parseInt(new String(arrayOfByte, j, i - j));
      return i;
      label156:
      do
      {
        j += 1;
        while ((j >= 1024) || (arrayOfByte[j] == 10))
        {
          return -1;
          j += 1;
          break;
          do
          {
            j = k + 1;
            while (j >= m) {}
            if (arrayOfByte[j] == 10) {
              break;
            }
            k = j;
          } while (j != 0);
          i = j;
          if (arrayOfByte[j] == 10) {
            i = j + 1;
          }
          j = i;
          break;
        }
      } while ((arrayOfByte[j] < 48) || (arrayOfByte[j] > 57));
      i = j + 1;
      while ((i < 1024) && (arrayOfByte[i] >= 48) && (arrayOfByte[i] <= 57)) {
        i += 1;
      }
    }
  }
  
  @TargetApi(16)
  public static long a(and paramand)
  {
    long l2 = -1L;
    if (Build.VERSION.SDK_INT >= 16)
    {
      ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
      paramand = paramand.b;
      if (paramand == null)
      {
        Log.w("deviceinfo/get-total-memory am=null");
        return -1L;
      }
      paramand.getMemoryInfo(localMemoryInfo);
      return localMemoryInfo.totalMem;
    }
    l1 = l2;
    try
    {
      paramand = new FileInputStream("/proc/meminfo");
      try
      {
        int i = a("MemTotal", paramand);
        l2 = i << 10;
        l1 = l2;
        paramand.close();
        return l2;
      }
      finally
      {
        l1 = l2;
        paramand.close();
        l1 = l2;
      }
      return l1;
    }
    catch (IOException paramand) {}
  }
  
  /* Error */
  private static boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_1
    //   3: invokevirtual 131	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   6: astore 5
    //   8: new 46	java/io/FileInputStream
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 104	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   16: astore_1
    //   17: aload_1
    //   18: astore_0
    //   19: new 133	java/io/BufferedReader
    //   22: dup
    //   23: new 135	java/io/InputStreamReader
    //   26: dup
    //   27: aload_1
    //   28: ldc -119
    //   30: invokespecial 140	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   33: invokespecial 143	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   36: astore 4
    //   38: aload_1
    //   39: astore_0
    //   40: aload 4
    //   42: invokevirtual 146	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   45: astore 6
    //   47: aload 6
    //   49: ifnull +92 -> 141
    //   52: aload_1
    //   53: astore_0
    //   54: aload 6
    //   56: invokevirtual 131	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   59: aload 5
    //   61: invokevirtual 150	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   64: istore_3
    //   65: iload_3
    //   66: ifeq -28 -> 38
    //   69: aload_1
    //   70: invokevirtual 111	java/io/FileInputStream:close	()V
    //   73: iconst_1
    //   74: istore_2
    //   75: iload_2
    //   76: ireturn
    //   77: astore_0
    //   78: aload_1
    //   79: astore_0
    //   80: ldc -104
    //   82: invokestatic 155	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   85: aload_1
    //   86: astore_0
    //   87: new 133	java/io/BufferedReader
    //   90: dup
    //   91: new 135	java/io/InputStreamReader
    //   94: dup
    //   95: aload_1
    //   96: invokespecial 158	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   99: invokespecial 143	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   102: astore 4
    //   104: goto -66 -> 38
    //   107: astore 4
    //   109: aload_1
    //   110: astore_0
    //   111: aload 4
    //   113: invokevirtual 161	java/lang/Exception:printStackTrace	()V
    //   116: aload_1
    //   117: ifnull -42 -> 75
    //   120: aload_1
    //   121: invokevirtual 111	java/io/FileInputStream:close	()V
    //   124: iconst_0
    //   125: ireturn
    //   126: astore_0
    //   127: aload_0
    //   128: invokevirtual 161	java/lang/Exception:printStackTrace	()V
    //   131: iconst_0
    //   132: ireturn
    //   133: astore_0
    //   134: aload_0
    //   135: invokevirtual 161	java/lang/Exception:printStackTrace	()V
    //   138: goto -65 -> 73
    //   141: aload_1
    //   142: invokevirtual 111	java/io/FileInputStream:close	()V
    //   145: iconst_0
    //   146: ireturn
    //   147: astore_0
    //   148: aload_0
    //   149: invokevirtual 161	java/lang/Exception:printStackTrace	()V
    //   152: iconst_0
    //   153: ireturn
    //   154: astore_1
    //   155: aconst_null
    //   156: astore_0
    //   157: aload_0
    //   158: ifnull +7 -> 165
    //   161: aload_0
    //   162: invokevirtual 111	java/io/FileInputStream:close	()V
    //   165: aload_1
    //   166: athrow
    //   167: astore_0
    //   168: aload_0
    //   169: invokevirtual 161	java/lang/Exception:printStackTrace	()V
    //   172: goto -7 -> 165
    //   175: astore_1
    //   176: goto -19 -> 157
    //   179: astore 4
    //   181: aconst_null
    //   182: astore_1
    //   183: goto -74 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	paramString1	String
    //   0	186	1	paramString2	String
    //   1	75	2	bool1	boolean
    //   64	2	3	bool2	boolean
    //   36	67	4	localBufferedReader	java.io.BufferedReader
    //   107	5	4	localException1	Exception
    //   179	1	4	localException2	Exception
    //   6	54	5	str1	String
    //   45	10	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   19	38	77	java/io/UnsupportedEncodingException
    //   19	38	107	java/lang/Exception
    //   40	47	107	java/lang/Exception
    //   54	65	107	java/lang/Exception
    //   80	85	107	java/lang/Exception
    //   87	104	107	java/lang/Exception
    //   120	124	126	java/lang/Exception
    //   69	73	133	java/lang/Exception
    //   141	145	147	java/lang/Exception
    //   8	17	154	finally
    //   161	165	167	java/lang/Exception
    //   19	38	175	finally
    //   40	47	175	finally
    //   54	65	175	finally
    //   80	85	175	finally
    //   87	104	175	finally
    //   111	116	175	finally
    //   8	17	179	java/lang/Exception
  }
  
  public static int b()
  {
    int k = 0;
    int i = -1;
    try
    {
      int j;
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        if (k < a())
        {
          localObject1 = new File("/sys/devices/system/cpu/cpu" + k + "/cpufreq/cpuinfo_max_freq");
          j = i;
          if (((File)localObject1).exists())
          {
            localObject2 = new byte[''];
            localObject1 = new FileInputStream((File)localObject1);
          }
        }
        else
        {
          for (;;)
          {
            try
            {
              ((FileInputStream)localObject1).read((byte[])localObject2);
              j = 0;
            }
            catch (NumberFormatException localNumberFormatException)
            {
              ((FileInputStream)localObject1).close();
              j = i;
            }
            finally
            {
              ((FileInputStream)localObject1).close();
            }
            localObject2 = Integer.valueOf(Integer.parseInt(new String((byte[])localObject2, 0, j)));
            j = i;
            if (((Integer)localObject2).intValue() > i) {
              j = ((Integer)localObject2).intValue();
            }
            ((FileInputStream)localObject1).close();
            break;
            j = i;
            if (i != -1) {
              return j;
            }
            localObject1 = new FileInputStream("/proc/cpuinfo");
            try
            {
              j = a("cpu MHz", (FileInputStream)localObject1);
              k = j * 1000;
              j = i;
              if (k > i) {
                j = k;
              }
              return j;
            }
            finally
            {
              ((FileInputStream)localObject1).close();
            }
            while ((localObject4[j] >= 48) && (localObject4[j] <= 57) && (j < 128)) {
              j += 1;
            }
          }
        }
        k += 1;
        i = j;
      }
      return j;
    }
    catch (IOException localIOException)
    {
      j = -1;
    }
  }
  
  public static boolean c()
  {
    try
    {
      if (a("/proc/cpuinfo", "smdk4"))
      {
        Log.i("Found SMDK4 in /proc/cpuinfo");
        return true;
      }
      if (a("/proc/cpuinfo", "exynos 4"))
      {
        Log.i("Found Exynos 4 in /proc/cpuinfo");
        return true;
      }
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    for (;;)
    {
      int i;
      try
      {
        File[] arrayOfFile = new File("/sys/devices/system").listFiles();
        if (arrayOfFile != null)
        {
          int j = arrayOfFile.length;
          i = 0;
          if (i < j)
          {
            if (!arrayOfFile[i].getName().toLowerCase(Locale.ENGLISH).contains("exynos4")) {
              break label100;
            }
            Log.i("Found exynos4 in /sys/devices/system");
            return true;
          }
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
      return false;
      label100:
      i += 1;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/p/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */