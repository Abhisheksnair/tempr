package com.whatsapp;

import a.a.a.a.d;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.support.v4.f.h;
import android.text.TextUtils;
import com.whatsapp.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;

public class aus
{
  @SuppressLint({"StaticFieldLeak"})
  private static volatile aus d;
  private static final String[] g = { "en", "hi", "bn", "pa", "te", "mr", "ta", "ur", "gu", "kn", "ml" };
  private static final String[] h = { "a", "ऄ", "অ", "ਐ", "అ", "ऄ", "அ", "ﺑ", "અ", "ಅ", "അ" };
  Locale a = Locale.getDefault();
  boolean b;
  final atv c;
  private final List<a> e = new ArrayList();
  private final Context f;
  
  private aus(Context paramContext, atv paramatv)
  {
    this.f = paramContext;
    this.c = paramatv;
  }
  
  public static aus a()
  {
    if (d == null) {}
    try
    {
      if (d == null) {
        d = new aus(u.a(), atv.a());
      }
      return d;
    }
    finally {}
  }
  
  private static boolean c(String paramString)
  {
    boolean bool2 = false;
    Paint localPaint = new Paint();
    localPaint.setTextSize(14.0F);
    localPaint.setColor(-16777216);
    localPaint.setTextAlign(Paint.Align.LEFT);
    float f1 = Math.abs(localPaint.ascent());
    Bitmap localBitmap = Bitmap.createBitmap((int)(localPaint.measureText(paramString) + 0.5F), (int)(localPaint.descent() + f1 + 0.5F), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawColor(-1);
    localCanvas.drawText(paramString, 0.0F, f1, localPaint);
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      int j;
      if (i < localBitmap.getWidth()) {
        j = 0;
      }
      while (j < localBitmap.getHeight())
      {
        if (localBitmap.getPixel(i, j) != -1)
        {
          bool1 = true;
          return bool1;
        }
        j += 1;
      }
      i += 1;
    }
  }
  
  public final void a(a parama)
  {
    this.e.add(parama);
  }
  
  public final void a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    Object localObject;
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = g;
      int j = localObject.length;
      i = 0;
      bool1 = bool2;
      if (i < j)
      {
        if (!localObject[i].equals(paramString)) {
          break label237;
        }
        bool1 = true;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder("whatsapplocale/saveandapplyforcedlanguage/language to save: ");
    if (TextUtils.isEmpty(paramString))
    {
      localObject = "device default";
      label70:
      Log.i((String)localObject);
      localObject = this.c;
      if (!bool1) {
        break label250;
      }
      ((atv)localObject).c().putString("forced_language", paramString).apply();
      label112:
      this.b = bool1;
      if (!this.b) {
        break label270;
      }
    }
    label237:
    label250:
    label270:
    for (this.a = new Locale(paramString, "IN");; this.a = Locale.getDefault())
    {
      Log.i("whatsapplocale/saveandapplyforcedlanguage/setting language " + this.a.getDisplayLanguage(Locale.US));
      f();
      com.whatsapp.fieldstats.l.a(this.f, 7, this.a.getLanguage());
      d.b(this.f, Boolean.valueOf(this.b));
      paramString = this.e.iterator();
      while (paramString.hasNext()) {
        ((a)paramString.next()).a();
      }
      i += 1;
      break;
      localObject = paramString;
      break label70;
      ((atv)localObject).c().remove("forced_language").apply();
      break label112;
    }
  }
  
  public final h<String[], String[]> b(String paramString)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Locale localLocale = Locale.getDefault();
    Object localObject = this.f.getResources().getString(2131296658);
    localArrayList1.add((String)localObject + " (" + localLocale.getDisplayLanguage(localLocale) + ")");
    localArrayList2.add(localLocale.getLanguage());
    HashSet localHashSet = new HashSet();
    int i;
    if (paramString.equals("IN"))
    {
      localHashSet.addAll(Arrays.asList(g));
      i = 0;
      label124:
      if (i >= g.length) {
        break label264;
      }
      if (localHashSet.contains(g[i])) {
        if (!"en".equals(g[i])) {
          break label259;
        }
      }
    }
    label259:
    for (localObject = "US";; localObject = paramString)
    {
      localObject = new Locale(g[i], (String)localObject);
      if ((!((Locale)localObject).equals(localLocale)) && (c(h[i])))
      {
        localArrayList1.add(((Locale)localObject).getDisplayLanguage((Locale)localObject));
        localArrayList2.add(((Locale)localObject).getLanguage());
      }
      i += 1;
      break label124;
      if (!paramString.equals("BD")) {
        break;
      }
      localHashSet.add("en");
      localHashSet.add("bn");
      break;
    }
    label264:
    return h.a((String[])localArrayList1.toArray(new String[localArrayList1.size()]), (String[])localArrayList2.toArray(new String[localArrayList2.size()]));
  }
  
  public final Locale b()
  {
    Locale localLocale2 = this.f.getResources().getConfiguration().locale;
    Locale localLocale1 = localLocale2;
    if (localLocale2 == null) {
      localLocale1 = Locale.getDefault();
    }
    return localLocale1;
  }
  
  public final void b(a parama)
  {
    this.e.remove(parama);
  }
  
  public final String c()
  {
    String str2 = b().getCountry();
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (Pattern.matches("[A-Z]{2}", str2)) {}
    }
    else
    {
      Log.i("verifynumber/requestcode/invalid-country " + str2);
      str1 = "ZZ";
    }
    return str1;
  }
  
  public final String d()
  {
    String str2 = b().getLanguage();
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (Pattern.matches("[a-z]{2}", str2)) {}
    }
    else
    {
      Log.i("verifynumber/requestcode/invalid-language " + str2);
      str1 = "zz";
    }
    return str1;
  }
  
  public final void e()
  {
    if (!this.b) {
      return;
    }
    f();
  }
  
  final void f()
  {
    Resources localResources = this.f.getResources();
    if (!localResources.getConfiguration().locale.equals(this.a))
    {
      Configuration localConfiguration = localResources.getConfiguration();
      localConfiguration.locale = this.a;
      localResources.updateConfiguration(localConfiguration, localResources.getDisplayMetrics());
      com.whatsapp.util.l.b();
    }
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/aus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */