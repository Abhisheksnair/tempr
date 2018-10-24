package com.whatsapp.notification;

import android.content.Context;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.text.style.StyleSpan;
import com.whatsapp.Voip;
import com.whatsapp.and;
import com.whatsapp.aus;
import com.whatsapp.cc;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.emoji.c;
import com.whatsapp.ip;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.pv;
import com.whatsapp.rh;
import com.whatsapp.u;
import com.whatsapp.util.Log;
import com.whatsapp.util.be;
import com.whatsapp.util.p;
import com.whatsapp.va;
import com.whatsapp.yr;
import java.util.HashMap;

public final class m
{
  private static volatile m j;
  public HashMap<String, Long> a = new HashMap();
  final Context b;
  final pv c;
  final va d;
  final com.whatsapp.data.d e;
  final e f;
  final aus g;
  final cc h;
  final rh i;
  private final and k;
  
  private m(Context paramContext, pv parampv, va paramva, com.whatsapp.data.d paramd, e parame, and paramand, aus paramaus, cc paramcc, rh paramrh)
  {
    this.b = paramContext;
    this.c = parampv;
    this.d = paramva;
    this.e = paramd;
    this.f = parame;
    this.k = paramand;
    this.g = paramaus;
    this.h = paramcc;
    this.i = paramrh;
  }
  
  public static m a()
  {
    if (j == null) {}
    try
    {
      if (j == null) {
        j = new m(u.a(), pv.a(), va.a(), com.whatsapp.data.d.a(), e.a(), and.a(), aus.a(), cc.a(), rh.a());
      }
      return j;
    }
    finally {}
  }
  
  private static CharSequence a(CharSequence paramCharSequence)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramCharSequence);
    localSpannableStringBuilder.setSpan(new StyleSpan(1), 0, paramCharSequence.length(), 0);
    return localSpannableStringBuilder;
  }
  
  private static CharSequence a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    Object localObject = paramCharSequence;
    if (paramBoolean)
    {
      localObject = new SpannableStringBuilder(paramCharSequence);
      ((SpannableStringBuilder)localObject).setSpan(new StyleSpan(2), 0, paramCharSequence.length(), 0);
    }
    return (CharSequence)localObject;
  }
  
  public static String a(Context paramContext, j paramj)
  {
    Object localObject = "";
    StringBuilder localStringBuilder;
    switch (paramj.s)
    {
    case 6: 
    case 7: 
    default: 
      localObject = paramContext.getString(2131296580);
      return (String)localObject;
    case 1: 
      if (Build.VERSION.SDK_INT >= 16)
      {
        if (TextUtils.isEmpty(paramj.z)) {
          return "📷 " + paramContext.getString(2131296577);
        }
        return "📷 " + paramj.z;
      }
      if (TextUtils.isEmpty(paramj.z)) {
        return paramContext.getString(2131296577);
      }
      return "(" + paramContext.getString(2131296577) + ") " + paramj.z;
    case 2: 
      if (Build.VERSION.SDK_INT >= 16)
      {
        localStringBuilder = new StringBuilder();
        if (paramj.o == 1)
        {
          localObject = "🎤";
          localObject = (String)localObject + " ";
        }
      }
      else
      {
        localObject = new StringBuilder().append((String)localObject);
        if (paramj.o != 1) {
          break label334;
        }
      }
      for (m = 2131296585;; m = 2131296570)
      {
        paramContext = paramContext.getString(m);
        localObject = paramContext;
        if (paramj.w == 0) {
          break;
        }
        return paramContext + " (" + DateUtils.formatElapsedTime(paramj.w) + ")";
        localObject = "🎵";
        break label232;
      }
    case 13: 
      if (Build.VERSION.SDK_INT >= 16)
      {
        if (TextUtils.isEmpty(paramj.z)) {
          return "👾 " + paramContext.getString(2131296576);
        }
        return "👾 " + paramj.z;
      }
      if (TextUtils.isEmpty(paramj.z)) {
        return paramContext.getString(2131296576);
      }
      return "(" + paramContext.getString(2131296576) + ") " + paramj.z;
    case 3: 
      if (Build.VERSION.SDK_INT >= 16) {
        if (TextUtils.isEmpty(paramj.z)) {
          paramContext = "🎥 " + paramContext.getString(2131296581);
        }
      }
      for (;;)
      {
        localObject = paramContext;
        if (paramj.w == 0) {
          break;
        }
        return paramContext + " (" + DateUtils.formatElapsedTime(paramj.w) + ")";
        paramContext = "🎥 " + paramj.z;
        continue;
        if (TextUtils.isEmpty(paramj.z)) {
          paramContext = paramContext.getString(2131296581);
        } else {
          paramContext = "(" + paramContext.getString(2131296581) + ") " + paramj.z;
        }
      }
    case 9: 
      if (Build.VERSION.SDK_INT >= 16) {
        if (TextUtils.isEmpty(paramj.z)) {
          paramContext = "📄 " + paramContext.getString(2131296575);
        }
      }
      for (;;)
      {
        localObject = paramContext;
        if (paramj.x == 0) {
          break;
        }
        return paramContext + " (" + p.a(paramj) + ")";
        paramContext = "📄 " + paramj.z;
        continue;
        if (TextUtils.isEmpty(paramj.z)) {
          paramContext = paramContext.getString(2131296575);
        } else {
          paramContext = "(" + paramContext.getString(2131296575) + ") " + paramj.z;
        }
      }
    case 14: 
      if (Build.VERSION.SDK_INT >= 16) {
        localObject = "👤 ";
      }
      return (String)localObject + a.a.a.a.d.d(paramj);
    case 4: 
      if (Build.VERSION.SDK_INT >= 16) {
        localObject = "👤 ";
      }
      if (!TextUtils.isEmpty(paramj.y)) {
        return (String)localObject + paramj.y;
      }
      return (String)localObject + paramContext.getString(2131296572);
    case 5: 
      localStringBuilder = null;
      localObject = localStringBuilder;
      if (!TextUtils.isEmpty(paramj.y))
      {
        paramj = paramj.y.split("\n");
        localObject = localStringBuilder;
        if (paramj.length != 0) {
          localObject = paramj[0];
        }
      }
      if (Build.VERSION.SDK_INT >= 16)
      {
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return "📌 " + paramContext.getString(2131296579);
        }
        return "📌 " + (String)localObject;
      }
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return paramContext.getString(2131296579);
      }
      return "(" + paramContext.getString(2131296579) + ") " + (String)localObject;
    case 16: 
      if (Build.VERSION.SDK_INT >= 16)
      {
        if (TextUtils.isEmpty(paramj.z)) {
          return "📌 " + paramContext.getString(2131296578);
        }
        return "📌 " + paramj.z;
      }
      if (TextUtils.isEmpty(paramj.z)) {
        return paramContext.getString(2131296578);
      }
      return "(" + paramContext.getString(2131296578) + ") " + paramj.z;
    case 8: 
      return paramContext.getString(2131296571);
    case 10: 
      if (Voip.b(paramj)) {
        return paramContext.getString(2131296583);
      }
      return paramContext.getString(2131296587);
    case 11: 
      return paramContext.getString(2131296574);
    case 12: 
      label232:
      label334:
      return paramContext.getString(2131297321);
    }
    if (paramj.e.b) {}
    for (int m = 2131297624;; m = 2131297623) {
      return paramContext.getString(m);
    }
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramContext.getString(2131297818);
    }
    paramString = RingtoneManager.getRingtone(paramContext, Uri.parse(paramString));
    if (paramString == null) {
      return null;
    }
    return paramString.getTitle(paramContext);
  }
  
  private String a(String paramString)
  {
    if (paramString == null)
    {
      Log.w("notification/messagepreview/getname remote_resource null");
      return "";
    }
    return this.f.d(paramString).a(this.b);
  }
  
  private static String b(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() > 1024L) {
        str = paramString.subSequence(0, 1020) + "…";
      }
    }
    return str;
  }
  
  public final a a(j paramj, cs paramcs)
  {
    if (paramj == null) {
      return new a("", "");
    }
    if (paramj.s == 0)
    {
      localCharSequence = yr.a(this.b, this.f, be.a(this.b, this.k, c.a(b(paramj.e()))), paramj.P);
      if (!paramcs.d()) {
        return new a(paramcs.a(this.b), localCharSequence);
      }
      if (paramj.d == 6) {
        return new a(paramcs.a(this.b), ip.a(this.c, this.d, this.e, this.f, this.g, this.i, paramj));
      }
      if (paramj.f != null)
      {
        paramj = this.f.d(paramj.f).a(this.b);
        return new a(paramj + " @ " + paramcs.a(this.b), localCharSequence);
      }
      return new a(paramcs.a(this.b), localCharSequence);
    }
    CharSequence localCharSequence = yr.a(this.b, this.f, a(this.b, paramj), paramj.P);
    if ((!paramcs.d()) || (paramj.f == null)) {
      return new a(paramcs.a(this.b), localCharSequence);
    }
    paramj = this.f.d(paramj.f).a(this.b);
    return new a(paramj + " @ " + paramcs.a(this.b), localCharSequence);
  }
  
  public final CharSequence a(j paramj, cs paramcs, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if (paramj == null) {
      localObject = "";
    }
    for (;;)
    {
      return yr.a(this.b, this.f, (CharSequence)localObject, paramj.P);
      if (paramj.s == 0)
      {
        if (paramj.d == 6)
        {
          if (paramBoolean1) {
            localObject = paramcs.a(this.b) + ": " + ip.a(this.c, this.d, this.e, this.f, this.g, this.i, paramj);
          } else {
            localObject = ip.a(this.c, this.d, this.e, this.f, this.g, this.i, paramj);
          }
        }
        else
        {
          CharSequence localCharSequence = be.a(this.b, this.k, c.a(b(paramj.e())));
          if (paramcs.d())
          {
            if (paramBoolean1)
            {
              if (!paramj.e.b) {
                localObject = a(paramj.f) + " @ " + paramcs.a(this.b) + ": " + localCharSequence;
              } else {
                localObject = paramcs.a(this.b) + ": " + localCharSequence;
              }
            }
            else if (paramBoolean2)
            {
              if (!paramj.e.b) {
                localObject = TextUtils.concat(new CharSequence[] { a(c.a(a(paramj.f) + " ")), localCharSequence });
              } else {
                localObject = TextUtils.concat(new CharSequence[] { a(this.b.getString(2131298216) + " "), localCharSequence });
              }
            }
            else if (!paramj.e.b)
            {
              localObject = TextUtils.concat(new CharSequence[] { a(a(paramj.f) + ": "), localCharSequence });
            }
            else
            {
              Log.e("messagePreview/missing_rmt_src:" + Log.a(paramj));
              localObject = this.b.getString(2131296507) + ": " + localCharSequence;
            }
          }
          else if (paramBoolean1)
          {
            localObject = paramcs.a(this.b) + ": " + localCharSequence;
          }
          else
          {
            localObject = localCharSequence;
            if (paramBoolean2) {
              if (!paramj.e.b) {
                localObject = TextUtils.concat(new CharSequence[] { a(c.a(paramcs.a(this.b)) + " "), localCharSequence });
              } else {
                localObject = TextUtils.concat(new CharSequence[] { a(this.b.getString(2131298216) + " "), localCharSequence });
              }
            }
          }
        }
      }
      else
      {
        localObject = a(this.b, paramj);
        boolean bool;
        if (paramj.s == 12) {
          bool = true;
        }
        for (;;)
        {
          if (paramcs.d())
          {
            if (paramBoolean1)
            {
              if (!paramj.e.b)
              {
                localObject = a(paramj.f) + " @ " + paramcs.a(this.b) + ": " + a((CharSequence)localObject, bool);
                break;
                bool = false;
                continue;
              }
              localObject = paramcs.a(this.b) + ": " + a((CharSequence)localObject, bool);
              break;
            }
            if (paramBoolean2)
            {
              if (!paramj.e.b)
              {
                localObject = TextUtils.concat(new CharSequence[] { a(c.a(a(paramj.f) + " ")), a(c.a((String)localObject), bool) });
                break;
              }
              localObject = TextUtils.concat(new CharSequence[] { a(this.b.getString(2131298216) + " "), a(c.a((String)localObject), bool) });
              break;
            }
            localObject = TextUtils.concat(new CharSequence[] { a(a(paramj.f) + ": "), a((CharSequence)localObject, bool) });
            break;
          }
        }
        if (paramBoolean1) {
          localObject = paramcs.a(this.b) + ": " + a((CharSequence)localObject, bool);
        } else if (paramBoolean2)
        {
          if (!paramj.e.b) {
            localObject = TextUtils.concat(new CharSequence[] { a(c.a(paramcs.a(this.b) + " ")), a(c.a((String)localObject), bool) });
          } else {
            localObject = TextUtils.concat(new CharSequence[] { a(this.b.getString(2131298216) + " "), a(c.a((String)localObject), bool) });
          }
        }
        else {
          localObject = a((CharSequence)localObject, bool);
        }
      }
    }
  }
  
  public static final class a
  {
    final String a;
    final CharSequence b;
    
    public a(String paramString, CharSequence paramCharSequence)
    {
      this.a = c.a(paramString);
      this.b = paramCharSequence;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/notification/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */