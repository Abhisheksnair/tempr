package com.whatsapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class aic
{
  public static String A;
  public static final HashSet<String> B;
  public static int C;
  public static int D;
  public static ArrayList<Long> E;
  public static int F;
  public static boolean G;
  public static boolean H;
  public static int I;
  public static int J;
  public static int K;
  public static int L;
  public static boolean M;
  public static boolean N;
  public static boolean O;
  public static boolean P;
  public static int Q;
  public static int R;
  public static int S;
  public static boolean T;
  public static boolean U;
  public static int V;
  public static boolean W;
  public static boolean X;
  public static boolean Y;
  public static boolean Z;
  public static final boolean a = ;
  public static boolean aa;
  public static boolean ab;
  public static boolean ac;
  public static boolean ad;
  public static boolean ae;
  public static int af;
  public static boolean ag;
  public static boolean ah;
  private static aic ai;
  public static final boolean b = av.d();
  public static final boolean c = av.d();
  public static final boolean d = av.d();
  public static final boolean e = av.d();
  public static final int f;
  public static final boolean g;
  public static final boolean h;
  public static final boolean i;
  public static final boolean j;
  public static final boolean k;
  public static final boolean l;
  public static final boolean m;
  public static int n;
  public static int o;
  public static int p;
  public static int q;
  public static int r;
  public static int s;
  public static int t;
  public static boolean u;
  public static int v;
  public static int w;
  public static int x;
  public static boolean y;
  public static int z;
  
  static
  {
    if (av.d()) {}
    for (int i1 = 2;; i1 = 0)
    {
      f = i1;
      g = av.d();
      h = av.d();
      i = av.d();
      j = av.d();
      k = av.d();
      l = av.d();
      m = av.d();
      o = 50;
      p = 9999;
      q = 25;
      r = 256;
      s = 16;
      t = 32;
      u = false;
      v = 1024;
      w = 80;
      x = 1600;
      y = false;
      z = -1;
      A = "csv,doc,docx,pdf,ppt,pptx,rtf,txt,xls,xlsx";
      B = new HashSet();
      C = 64;
      D = 4;
      F = 1209600;
      G = a;
      H = b;
      I = -1;
      J = 812;
      K = 32;
      L = 5000;
      M = true;
      N = true;
      O = false;
      P = c;
      Q = 50;
      R = 1280;
      S = 45;
      T = d;
      U = e;
      V = f;
      W = g;
      X = h;
      Y = i;
      Z = false;
      aa = false;
      ab = false;
      ac = false;
      ad = j;
      ae = k;
      af = 86400;
      ag = l;
      ah = m;
      return;
    }
  }
  
  private aic(SharedPreferences paramSharedPreferences)
  {
    n = paramSharedPreferences.getInt("server_props:last_version", 0);
    p = paramSharedPreferences.getInt("group_number_limit", p);
    o = paramSharedPreferences.getInt("participants_size_limit", o) - 1;
    q = paramSharedPreferences.getInt("subject_length_limit", q);
    s = paramSharedPreferences.getInt("media_limit_mb", s);
    t = paramSharedPreferences.getInt("media_limit_auto_download_mb", t);
    r = paramSharedPreferences.getInt("broadcast_list_size_limit", r);
    u = paramSharedPreferences.getBoolean("location_enabled", u);
    v = paramSharedPreferences.getInt("image_max_kbytes", v);
    w = paramSharedPreferences.getInt("image_quality", w);
    x = paramSharedPreferences.getInt("image_max_edge", x);
    y = paramSharedPreferences.getBoolean("force_long_connect", y);
    z = paramSharedPreferences.getInt("places_source", z);
    String str = paramSharedPreferences.getString("documents", A);
    A = str;
    if (!TextUtils.isEmpty(str)) {
      B.addAll(Arrays.asList(A.split(",")));
    }
    C = paramSharedPreferences.getInt("document_limit_mb", C);
    E = b(paramSharedPreferences.getString("tos_update", null));
    D = paramSharedPreferences.getInt("gdrive_max_concurrent_reads", D);
    F = paramSharedPreferences.getInt("heartbeat_interval_seconds", F);
    G = paramSharedPreferences.getBoolean("emoji_search", G);
    H = paramSharedPreferences.getBoolean("gif_search", H);
    I = paramSharedPreferences.getInt("gif_provider", I);
    J = paramSharedPreferences.getInt("max_keys", J);
    K = paramSharedPreferences.getInt("ping_timeout_s", K);
    L = paramSharedPreferences.getInt("video_max_bitrate", L);
    M = paramSharedPreferences.getBoolean("contact_array_enabled", M);
    N = paramSharedPreferences.getBoolean("contact_indexing_enabled", N);
    O = paramSharedPreferences.getBoolean("contact_indexing_ui_enabled", O);
    P = paramSharedPreferences.getBoolean("edit", P);
    Q = paramSharedPreferences.getInt("status_image_quality", Q);
    R = paramSharedPreferences.getInt("status_image_max_edge", R);
    S = paramSharedPreferences.getInt("status_video_max_duration", S);
    T = paramSharedPreferences.getBoolean("media_view_exoplayer", d);
    U = paramSharedPreferences.getBoolean("media_view_streaming", e);
    V = paramSharedPreferences.getInt("network_stack_to_use", f);
    W = paramSharedPreferences.getBoolean("p2p_pay", g);
    X = paramSharedPreferences.getBoolean("gcm_fg_service", h);
    Y = paramSharedPreferences.getBoolean("voip_redesign", i);
    Z = paramSharedPreferences.getBoolean("mms4_image", false);
    aa = paramSharedPreferences.getBoolean("mms4_audio", false);
    ab = paramSharedPreferences.getBoolean("mms4_ptt", false);
    ac = paramSharedPreferences.getBoolean("mms4_video", false);
    ad = paramSharedPreferences.getBoolean("mms4_gif", j);
    ae = paramSharedPreferences.getBoolean("mms4_doc", k);
    af = paramSharedPreferences.getInt("fieldstats_sis", 86400);
    ag = paramSharedPreferences.getBoolean("status_v3_text", l);
    ah = paramSharedPreferences.getBoolean("media_order", m);
    paramSharedPreferences = paramSharedPreferences.edit();
    paramSharedPreferences.remove("fb_crashlog");
    paramSharedPreferences.remove("status_v3");
    paramSharedPreferences.remove("video_calling");
    paramSharedPreferences.remove("two_factor_auth");
    paramSharedPreferences.remove("gif");
    paramSharedPreferences.remove("media_streaming");
    paramSharedPreferences.remove("use_bing_image_v6");
    paramSharedPreferences.remove("status_v2");
    paramSharedPreferences.remove("adm");
    paramSharedPreferences.remove("pinned_chats");
    paramSharedPreferences.remove("new_faq");
    paramSharedPreferences.remove("mms4_enabled");
    paramSharedPreferences.remove("video_call_input_box");
    paramSharedPreferences.apply();
  }
  
  public static int a(String paramString1, int paramInt, String paramString2, SharedPreferences.Editor paramEditor)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      paramEditor.remove(paramString1);
      return paramInt;
    }
    try
    {
      int i1 = Integer.parseInt(paramString2);
      paramEditor.putInt(paramString1, i1);
      return i1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      Log.w("invalid number format for server property; prefKey=" + paramString1 + "; value=" + paramString2);
      paramEditor.remove(paramString1);
    }
    return paramInt;
  }
  
  public static long a(int paramInt)
  {
    if (E.size() < paramInt)
    {
      Log.e("serverprops/gettosstage/index " + paramInt + " " + u.a().getSharedPreferences("com.whatsapp_preferences", 0).getString("tos_update", null) + " length:" + E.size());
      return 0L;
    }
    return ((Long)E.get(paramInt - 1)).longValue();
  }
  
  public static aic a()
  {
    if (ai == null) {}
    try
    {
      if (ai == null) {
        ai = new aic(u.a().getSharedPreferences("com.whatsapp_preferences", 0));
      }
      return ai;
    }
    finally {}
  }
  
  public static boolean a(String paramString)
  {
    int i1 = 1;
    if (b()) {
      return true;
    }
    if (paramString == null) {
      return false;
    }
    switch (paramString.hashCode())
    {
    default: 
      label120:
      i1 = -1;
    }
    for (;;)
    {
      switch (i1)
      {
      default: 
        return false;
        if (!paramString.equals("application/pdf")) {
          break label120;
        }
        i1 = 0;
        continue;
        if (!paramString.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document")) {
          break label120;
        }
        continue;
        if (!paramString.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
          break label120;
        }
        i1 = 2;
        continue;
        if (!paramString.equals("application/vnd.openxmlformats-officedocument.presentationml.presentation")) {
          break label120;
        }
        i1 = 3;
        continue;
        if (!paramString.equals("application/msword")) {
          break label120;
        }
        i1 = 4;
        continue;
        if (!paramString.equals("application/vnd.ms-excel")) {
          break label120;
        }
        i1 = 5;
        continue;
        if (!paramString.equals("application/vnd.ms-powerpoint")) {
          break label120;
        }
        i1 = 6;
        continue;
        if (!paramString.equals("text/plain")) {
          break label120;
        }
        i1 = 7;
        continue;
        if (!paramString.equals("text/rtf")) {
          break label120;
        }
        i1 = 8;
        continue;
        if (!paramString.equals("application/rtf")) {
          break label120;
        }
        i1 = 9;
        continue;
        if (!paramString.equals("text/csv")) {
          break label120;
        }
        i1 = 10;
      }
    }
    paramString = "pdf";
    for (;;)
    {
      return B.contains(paramString);
      paramString = "docx";
      continue;
      paramString = "xlsx";
      continue;
      paramString = "pptx";
      continue;
      paramString = "doc";
      continue;
      paramString = "xls";
      continue;
      paramString = "ppt";
      continue;
      paramString = "txt";
      continue;
      paramString = "rtf";
      continue;
      paramString = "rtf";
      continue;
      paramString = "csv";
    }
  }
  
  public static boolean a(String paramString1, boolean paramBoolean, String paramString2, SharedPreferences.Editor paramEditor)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      paramEditor.remove(paramString1);
      return paramBoolean;
    }
    try
    {
      if (Integer.parseInt(paramString2) != 0) {}
      for (boolean bool = true;; bool = false)
      {
        paramEditor.putBoolean(paramString1, bool);
        return bool;
      }
      return paramBoolean;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      Log.w("invalid number format for server property; prefKey=" + paramString1 + "; value=" + paramString2);
      paramEditor.remove(paramString1);
    }
  }
  
  public static ArrayList<Long> b(String paramString)
  {
    localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return localArrayList;
      String[] arrayOfString = paramString.split("-");
      try
      {
        int i2 = arrayOfString.length;
        int i1 = 0;
        while (i1 < i2)
        {
          localArrayList.add(Long.valueOf(Integer.parseInt(arrayOfString[i1]) * 3600000L));
          i1 += 1;
        }
        return localArrayList;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localArrayList.clear();
        Log.e("serverprops/onServerProperties/format error " + paramString);
      }
    }
  }
  
  public static boolean b()
  {
    return "*".equals(A);
  }
  
  public static List<String> c()
  {
    Object localObject;
    if (b())
    {
      localObject = Collections.singletonList("*/*");
      return (List<String>)localObject;
    }
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = MediaFileUtils.a;
    int i2 = arrayOfString.length;
    int i1 = 0;
    for (;;)
    {
      localObject = localArrayList;
      if (i1 >= i2) {
        break;
      }
      localObject = arrayOfString[i1];
      if (a((String)localObject)) {
        localArrayList.add(localObject);
      }
      i1 += 1;
    }
  }
  
  public static boolean c(String paramString)
  {
    int i1 = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i1)
      {
      default: 
        throw new IllegalArgumentException("Invalid file type");
        if (paramString.equals("image"))
        {
          i1 = 0;
          continue;
          if (paramString.equals("audio"))
          {
            i1 = 1;
            continue;
            if (paramString.equals("ptt"))
            {
              i1 = 2;
              continue;
              if (paramString.equals("video"))
              {
                i1 = 3;
                continue;
                if (paramString.equals("gif"))
                {
                  i1 = 4;
                  continue;
                  if (paramString.equals("document")) {
                    i1 = 5;
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    return Z;
    return aa;
    return ab;
    return ac;
    return ad;
    return ae;
  }
  
  public static boolean d()
  {
    return !E.isEmpty();
  }
  
  public static void e()
  {
    E.clear();
    u.a().getSharedPreferences("com.whatsapp_preferences", 0).edit().remove("tos_update").apply();
  }
  
  public static long f()
  {
    return S * 1000L;
  }
  
  public static boolean g()
  {
    return true;
  }
  
  public static boolean h()
  {
    return Y;
  }
  
  public static boolean i()
  {
    return (aa) || (ae) || (ab) || (ad) || (ac) || (Z);
  }
  
  public static Uri.Builder j()
  {
    Uri.Builder localBuilder = new Uri.Builder();
    localBuilder.scheme("https");
    localBuilder.authority("faq.whatsapp.com");
    return localBuilder;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/aic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */