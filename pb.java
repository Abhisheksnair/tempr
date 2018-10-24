package com.whatsapp;

import a.a.a.a.a.a.d;
import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import android.os.SystemClock;
import com.whatsapp.data.cs;
import com.whatsapp.data.d;
import com.whatsapp.fieldstats.events.WamCall;
import com.whatsapp.fieldstats.events.ao;
import com.whatsapp.fieldstats.events.ap;
import com.whatsapp.fieldstats.events.at;
import com.whatsapp.fieldstats.events.aw;
import com.whatsapp.fieldstats.events.bc;
import com.whatsapp.fieldstats.events.bd;
import com.whatsapp.fieldstats.events.bf;
import com.whatsapp.fieldstats.events.bt;
import com.whatsapp.fieldstats.events.bu;
import com.whatsapp.fieldstats.events.bv;
import com.whatsapp.fieldstats.events.n;
import com.whatsapp.fieldstats.l;
import com.whatsapp.k.h;
import com.whatsapp.messaging.w;
import com.whatsapp.util.Log;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public final class pb
{
  public static WamCall a = null;
  private static final h b = new h(1000, 10000);
  
  public static int a(and paramand)
  {
    paramand = paramand.e;
    if (paramand == null) {
      Log.w("fieldstatshelper/get-active-network-code cm=null");
    }
    do
    {
      return -1;
      paramand = a(paramand.getActiveNetworkInfo());
    } while (paramand == null);
    return paramand.intValue();
  }
  
  public static Bundle a(Object paramObject)
  {
    Bundle localBundle = new Bundle();
    Field[] arrayOfField = paramObject.getClass().getDeclaredFields();
    int j = arrayOfField.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Object localObject = arrayOfField[i];
        int k = ((Field)localObject).getModifiers();
        if ((Modifier.isPublic(k)) && (!Modifier.isStatic(k)))
        {
          String str = ((Field)localObject).getName();
          try
          {
            localObject = ((Field)localObject).get(paramObject);
            if (localObject == null) {
              break label244;
            }
            if ((localObject instanceof Double)) {
              localBundle.putDouble(str, ((Double)localObject).doubleValue());
            } else if ((localObject instanceof Integer)) {
              localBundle.putInt(str, ((Integer)localObject).intValue());
            }
          }
          catch (IllegalAccessException paramObject)
          {
            throw new IllegalArgumentException((Throwable)paramObject);
          }
          if ((localObject instanceof Long)) {
            localBundle.putLong(str, ((Long)localObject).longValue());
          } else if ((localObject instanceof Boolean)) {
            localBundle.putBoolean(str, ((Boolean)localObject).booleanValue());
          } else if ((localObject instanceof String)) {
            localBundle.putString(str, (String)localObject);
          } else {
            a.d.a(false, "unexpected member " + str + " in fieldstats event, only Double, Integer, and String members are supported");
          }
        }
      }
      else
      {
        return localBundle;
      }
      label244:
      i += 1;
    }
  }
  
  public static WamCall a(and paramand, abu paramabu, auu paramauu, aat paramaat, atv paramatv, WamCall paramWamCall, String paramString1, Double paramDouble, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, String paramString2, String paramString3)
  {
    paramWamCall.peerUserId = a(paramString1);
    paramWamCall.callNetwork = Integer.valueOf(VoiceService.a(paramaat));
    paramand = paramand.e;
    if (paramand != null)
    {
      paramand = paramand.getActiveNetworkInfo();
      if (paramand != null) {
        paramWamCall.callNetworkSubtype = Long.valueOf(paramand.getSubtype());
      }
    }
    if (paramauu.a) {
      paramWamCall.xmppStatus = Integer.valueOf(3);
    }
    for (;;)
    {
      paramWamCall.builtinAecAvailable = Boolean.valueOf(Voip.j());
      paramWamCall.builtinAgcAvailable = Boolean.valueOf(Voip.k());
      paramWamCall.builtinNsAvailable = Boolean.valueOf(Voip.l());
      if (u.a().getSharedPreferences("com.whatsapp_preferences", 0) != null)
      {
        paramWamCall.builtinAecImplementor = paramatv.a.getString("aec_implementor", null);
        paramWamCall.builtinAecUuid = paramatv.a.getString("aec_uuid", null);
      }
      paramWamCall.callOfferElapsedT = paramDouble;
      paramWamCall.callFromUi = paramInteger1;
      paramWamCall.callWakeupSource = paramInteger3;
      paramWamCall.callPeerPlatform = paramString2;
      paramWamCall.callPeerAppVersion = paramString3;
      long l = paramabu.a(paramString1);
      if (l == 0L)
      {
        paramWamCall.peerXmppStatus = Integer.valueOf(4);
        label209:
        if (paramInteger2 != null) {
          paramWamCall.callAndroidAudioMode = Long.valueOf(paramInteger2.longValue());
        }
        paramWamCall.longConnect = Boolean.valueOf(aic.y);
      }
      try
      {
        paramWamCall.numberOfProcessors = Long.valueOf(Runtime.getRuntime().availableProcessors());
        paramWamCall.callAndrGcmFgEnabled = Boolean.valueOf(aic.X);
        a = paramWamCall;
        return paramWamCall;
        if (paramauu.b)
        {
          paramWamCall.xmppStatus = Integer.valueOf(2);
          continue;
        }
        paramWamCall.xmppStatus = Integer.valueOf(1);
        continue;
        if (l == 1L)
        {
          paramWamCall.peerXmppStatus = Integer.valueOf(3);
          break label209;
        }
        paramWamCall.peerXmppStatus = Integer.valueOf(1);
      }
      catch (Throwable paramand)
      {
        for (;;)
        {
          paramWamCall.numberOfProcessors = null;
        }
      }
    }
  }
  
  public static Integer a(NetworkInfo paramNetworkInfo)
  {
    if (paramNetworkInfo == null) {}
    int i;
    do
    {
      return null;
      i = paramNetworkInfo.getType();
      int j = paramNetworkInfo.getSubtype();
      if (i == 0)
      {
        switch (j)
        {
        default: 
          return Integer.valueOf(0);
        case 2: 
          return Integer.valueOf(100);
        case 1: 
          return Integer.valueOf(104);
        case 3: 
          return Integer.valueOf(102);
        case 8: 
          return Integer.valueOf(105);
        case 9: 
          return Integer.valueOf(106);
        case 10: 
          return Integer.valueOf(107);
        case 4: 
          return Integer.valueOf(108);
        case 5: 
        case 6: 
        case 12: 
          return Integer.valueOf(103);
        case 7: 
          return Integer.valueOf(109);
        case 13: 
          return Integer.valueOf(111);
        case 14: 
          return Integer.valueOf(110);
        case 11: 
          return Integer.valueOf(101);
        }
        return Integer.valueOf(112);
      }
    } while (i != 1);
    return Integer.valueOf(1);
  }
  
  private static Long a(String paramString)
  {
    String str;
    if (paramString == null)
    {
      Log.w("voip/phonenumber/jid/null");
      str = null;
    }
    while (str == null)
    {
      return null;
      int i = paramString.indexOf('@');
      if (i == -1) {
        str = null;
      } else {
        str = paramString.substring(0, i);
      }
    }
    try
    {
      long l = Long.parseLong(str);
      return Long.valueOf(l);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      Log.e("voip/phonenumber/error failed to parse " + paramString);
    }
    return null;
  }
  
  public static String a(bv parambv)
  {
    return "WamVideoPlay videoDuration= " + parambv.a + " videoSize=" + parambv.b + " videoPlayT=" + parambv.c + " videoAge=" + parambv.d + " videoPlayType=" + parambv.e + " videoInitialBufferingT=" + parambv.f + " videoPlayResult=" + parambv.g + " videoPlaySurface=" + parambv.h + " videoPlayOrigin=" + parambv.i;
  }
  
  public static void a(int paramInt)
  {
    a(paramInt, null);
  }
  
  static void a(int paramInt, Integer paramInteger)
  {
    bu localbu = new bu();
    localbu.a = Integer.valueOf(paramInt);
    if (paramInteger != null) {
      localbu.b = paramInteger;
    }
    l.a(u.a(), localbu);
  }
  
  public static void a(long paramLong)
  {
    if (b.a(1))
    {
      bt localbt = new bt();
      localbt.a = Integer.valueOf(3);
      localbt.c = Double.valueOf(paramLong);
      l.a(u.a(), localbt, b.b(1));
    }
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    at localat = new at();
    localat.a = Integer.valueOf(11);
    localat.k = Integer.valueOf(paramInt1);
    localat.n = Long.valueOf(paramInt3);
    localat.m = Long.valueOf(paramInt2);
    localat.b = Long.valueOf(1L);
    localat.c = Long.valueOf(1L);
    localat.e = Long.valueOf(0L);
    localat.d = Long.valueOf(0L);
    localat.f = Long.valueOf(0L);
    localat.g = Long.valueOf(0L);
    localat.h = Long.valueOf(0L);
    localat.i = Long.valueOf(0L);
    l.a(paramContext, localat);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, boolean paramBoolean, String paramString2, int paramInt5, int paramInt6, int paramInt7, long paramLong)
  {
    ao localao = new ao();
    localao.a = Integer.valueOf(paramInt1);
    localao.b = Integer.valueOf(paramInt2);
    localao.c = Integer.valueOf(paramInt3);
    localao.d = Integer.valueOf(paramInt4);
    localao.e = paramString1;
    localao.f = Boolean.valueOf(paramBoolean);
    localao.g = paramString2;
    localao.h = Double.valueOf(paramInt5);
    localao.i = Double.valueOf(paramInt6);
    localao.j = Double.valueOf(paramInt7);
    localao.k = Double.valueOf(paramLong);
    l.a(paramContext, localao);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, String paramString1, int paramInt4, boolean paramBoolean, String paramString2, int paramInt5, long paramLong)
  {
    bc localbc = new bc();
    localbc.a = Integer.valueOf(paramInt1);
    localbc.b = Integer.valueOf(paramInt2);
    localbc.c = Integer.valueOf(paramInt3);
    localbc.d = paramString1;
    localbc.e = Long.valueOf(paramInt4);
    localbc.f = Boolean.valueOf(paramBoolean);
    localbc.g = paramString2;
    localbc.h = Double.valueOf(paramInt5);
    localbc.i = Double.valueOf(paramLong);
    l.a(paramContext, localbc);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    bd localbd = new bd();
    localbd.a = Integer.valueOf(paramInt1);
    localbd.b = Integer.valueOf(paramInt2);
    localbd.d = Double.valueOf(paramLong2);
    localbd.c = Double.valueOf(paramLong1);
    l.b(paramContext, localbd);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, long paramLong, File paramFile)
  {
    if (paramFile == null) {
      return;
    }
    bv localbv = new bv();
    localbv.a = Long.valueOf(paramLong);
    localbv.d = Long.valueOf((System.currentTimeMillis() - paramFile.lastModified()) / 1000L);
    localbv.e = Integer.valueOf(paramInt1);
    localbv.h = Integer.valueOf(1);
    localbv.i = Integer.valueOf(paramInt2);
    localbv.b = Double.valueOf(paramFile.length());
    Log.d(a(localbv));
    l.a(paramContext, localbv);
  }
  
  static void a(Context paramContext, int paramInt, long paramLong)
  {
    a(paramContext, paramInt, paramLong, 0);
  }
  
  static void a(Context paramContext, int paramInt1, long paramLong, int paramInt2)
  {
    bf localbf = new bf();
    localbf.a = Integer.valueOf(paramInt1);
    localbf.c = Double.valueOf(paramLong);
    localbf.b = Integer.valueOf(paramInt2);
    l.a(paramContext, localbf);
  }
  
  public static void a(Context paramContext, and paramand)
  {
    paramand = paramand.b;
    if (paramand == null) {}
    do
    {
      return;
      paramand = paramand.getProcessMemoryInfo(new int[] { Process.myPid() });
    } while ((paramand == null) || (paramand.length == 0));
    paramand = paramand[0];
    aw localaw = new aw();
    localaw.a = Double.valueOf(paramand.getTotalPss());
    localaw.c = Double.valueOf(paramand.getTotalPrivateDirty());
    localaw.d = Double.valueOf(paramand.getTotalSharedDirty());
    localaw.f = Double.valueOf((SystemClock.uptimeMillis() - v.b()) / 1000.0D);
    l.a(paramContext, localaw);
  }
  
  public static void a(Context paramContext, and paramand, aat paramaat)
  {
    boolean bool2 = true;
    int i = paramaat.a(true);
    boolean bool1;
    if (i == 1)
    {
      bool1 = true;
      l.a(paramContext, 23, Boolean.valueOf(bool1));
      if (i != 3) {
        break label74;
      }
      bool1 = bool2;
      label37:
      l.a(paramContext, 37, Boolean.valueOf(bool1));
      i = a(paramand);
      if (i != -1) {
        break label80;
      }
    }
    label74:
    label80:
    for (paramand = null;; paramand = Integer.valueOf(i))
    {
      l.a(paramContext, 105, paramand);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label37;
    }
  }
  
  public static void a(Context paramContext, w paramw, WamCall paramWamCall, boolean paramBoolean)
  {
    if (paramWamCall == null) {}
    do
    {
      return;
      l.a(paramContext, paramWamCall);
    } while (!paramBoolean);
    paramw.c();
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    n localn = new n();
    localn.a = Boolean.valueOf(paramBoolean);
    l.a(paramContext, localn);
  }
  
  public static void a(Context paramContext, boolean paramBoolean, int paramInt, long paramLong)
  {
    ap localap = new ap();
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      localap.a = Integer.valueOf(i);
      localap.b = Long.valueOf(paramInt);
      localap.c = Double.valueOf(paramLong);
      if (!paramBoolean) {
        break;
      }
      l.b(paramContext, localap);
      return;
    }
    l.a(paramContext, localap);
  }
  
  public static void a(d paramd, lt paramlt)
  {
    paramlt = paramlt.j();
    int i1 = 0;
    int i2 = 0;
    int n = 0;
    int m = 0;
    int k = 0;
    int j = 0;
    int i = 0;
    if (i1 < paramlt.size())
    {
      String str = (String)paramlt.get(i1);
      int i3 = i2;
      int i4 = n;
      int i5 = m;
      int i6 = k;
      int i7 = j;
      int i8 = i;
      boolean bool;
      if (str != null)
      {
        bool = paramd.d(str);
        if (!qz.e(str)) {
          break label174;
        }
        if (!bool) {
          break label147;
        }
        i4 = n + 1;
        i8 = i;
        i7 = j;
        i6 = k;
        i5 = m;
        i3 = i2;
      }
      for (;;)
      {
        i1 += 1;
        i2 = i3;
        n = i4;
        m = i5;
        k = i6;
        j = i7;
        i = i8;
        break;
        label147:
        i7 = j + 1;
        i3 = i2;
        i4 = n;
        i5 = m;
        i6 = k;
        i8 = i;
        continue;
        label174:
        if (cs.e(str))
        {
          if (bool)
          {
            i3 = i2 + 1;
            i4 = n;
            i5 = m;
            i6 = k;
            i7 = j;
            i8 = i;
          }
          else
          {
            i6 = k + 1;
            i3 = i2;
            i4 = n;
            i5 = m;
            i7 = j;
            i8 = i;
          }
        }
        else if (bool)
        {
          i5 = m + 1;
          i3 = i2;
          i4 = n;
          i6 = k;
          i7 = j;
          i8 = i;
        }
        else
        {
          i8 = i + 1;
          i3 = i2;
          i4 = n;
          i5 = m;
          i6 = k;
          i7 = j;
        }
      }
    }
    l.a(u.a(), 269, Long.valueOf(i));
    l.a(u.a(), 273, Long.valueOf(j));
    l.a(u.a(), 271, Long.valueOf(k));
    l.a(u.a(), 331, Long.valueOf(m));
    l.a(u.a(), 335, Long.valueOf(n));
    l.a(u.a(), 333, Long.valueOf(i2));
  }
  
  static void a(oz paramoz)
  {
    Object localObject = paramoz.a((byte)0, 0, false);
    if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory())) {
      return;
    }
    try
    {
      localObject = a((File)localObject);
      l.a(u.a(), 243, Long.valueOf(localObject[0]));
      l.a(u.a(), 267, Long.valueOf(localObject[1]));
      paramoz = paramoz.a((byte)3, 0, false);
      if ((paramoz.exists()) && (paramoz.isDirectory()))
      {
        paramoz = a(paramoz);
        l.a(u.a(), 597, Long.valueOf(paramoz[0]));
        l.a(u.a(), 599, Long.valueOf(paramoz[1]));
        return;
      }
    }
    catch (StackOverflowError paramoz)
    {
      Log.e("fieldstathelpers/update-media-folder-fieldstats/error/stackoverflow");
      return;
      Log.e("fieldstathelpers/update-media-folder-fieldstats/error/video-folder-does-not-exist");
      return;
    }
    catch (OutOfMemoryError paramoz)
    {
      Log.e("fieldstathelpers/update-media-folder-fieldstats/error/outofmemory");
    }
  }
  
  public static void a(Object paramObject, Bundle paramBundle)
  {
    Field[] arrayOfField = paramObject.getClass().getDeclaredFields();
    int j = arrayOfField.length;
    int i = 0;
    while (i < j)
    {
      Field localField = arrayOfField[i];
      Object localObject = paramBundle.get(localField.getName());
      try
      {
        localField.set(paramObject, localObject);
        i += 1;
      }
      catch (IllegalAccessException paramObject)
      {
        throw new IllegalArgumentException((Throwable)paramObject);
      }
    }
  }
  
  private static long[] a(File paramFile)
  {
    long[] arrayOfLong = new long[2];
    long[] tmp5_4 = arrayOfLong;
    tmp5_4[0] = 0L;
    long[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0L;
    tmp9_5;
    if (paramFile == null) {
      return arrayOfLong;
    }
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      int i = 0;
      label37:
      if (i < j)
      {
        paramFile = arrayOfFile[i];
        if (!paramFile.isFile()) {
          break label80;
        }
        arrayOfLong[0] += paramFile.length();
        arrayOfLong[1] += 1L;
      }
      for (;;)
      {
        i += 1;
        break label37;
        break;
        label80:
        if (paramFile.isDirectory())
        {
          paramFile = a(paramFile);
          arrayOfLong[0] += paramFile[0];
          arrayOfLong[1] += paramFile[1];
        }
      }
    }
    Log.w("mediafoldersize listedFiles is null for folder " + paramFile);
    return arrayOfLong;
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      Log.d("videoplayorigin=" + paramInt + " not in range");
    case 5: 
      return 5;
    case 1: 
      return 1;
    case 2: 
      return 2;
    case 3: 
      return 3;
    }
    return 4;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/pb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */