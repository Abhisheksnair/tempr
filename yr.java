package com.whatsapp;

import android.content.Context;
import android.support.v4.content.b;
import android.support.v4.f.h;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.util.Log;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class yr
{
  private static final boolean a = Character.isDefined('⁨');
  private static final boolean b = Character.isDefined('⁩');
  private static final Pattern c = Pattern.compile("(@\\d+)");
  
  public static CharSequence a(Context paramContext, e parame, CharSequence paramCharSequence, List<String> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return paramCharSequence;
    }
    if ((paramCharSequence instanceof SpannableStringBuilder)) {}
    for (paramCharSequence = (SpannableStringBuilder)paramCharSequence;; paramCharSequence = new SpannableStringBuilder(paramCharSequence))
    {
      a(paramContext, parame, paramCharSequence, paramList, false, false);
      return paramCharSequence;
    }
  }
  
  public static String a(cs paramcs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject;
    if (a)
    {
      localObject = "⁨";
      localObject = localStringBuilder.append((String)localObject);
      if (!paramcs.f()) {
        break label65;
      }
      paramcs = paramcs.j();
      label35:
      localObject = ((StringBuilder)localObject).append(paramcs);
      if (!b) {
        break label112;
      }
    }
    label65:
    label112:
    for (paramcs = "⁩";; paramcs = "")
    {
      return paramcs;
      localObject = "";
      break;
      if (!TextUtils.isEmpty(paramcs.e))
      {
        paramcs = paramcs.e;
        break label35;
      }
      if (!TextUtils.isEmpty(paramcs.q))
      {
        paramcs = paramcs.q;
        break label35;
      }
      paramcs = cs.b(paramcs.t);
      break label35;
    }
  }
  
  public static String a(Collection<String> paramCollection)
  {
    if ((paramCollection == null) || (paramCollection.isEmpty())) {
      return null;
    }
    return TextUtils.join(",", paramCollection);
  }
  
  public static List<String> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return Arrays.asList(paramString.split(","));
  }
  
  public static void a(Context paramContext, e parame, SpannableStringBuilder paramSpannableStringBuilder, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j;
    if (paramBoolean1)
    {
      i = 2131624044;
      j = b.c(paramContext, i);
      if (!paramBoolean1) {
        break label51;
      }
    }
    label51:
    for (int i = 2131624075;; i = 2131624076)
    {
      a(parame, paramSpannableStringBuilder, paramList, j, b.c(paramContext, i), paramBoolean2, false);
      return;
      i = 2131624043;
      break;
    }
  }
  
  public static void a(e parame, SpannableStringBuilder paramSpannableStringBuilder, List<String> paramList, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {}
    for (ys localys = new ys(paramInt1, paramBoolean2, paramInt2);; localys = null)
    {
      a(parame, paramSpannableStringBuilder, paramList, localys);
      return;
    }
  }
  
  public static void a(e parame, SpannableStringBuilder paramSpannableStringBuilder, List<String> paramList, b paramb)
  {
    if ((paramList == null) || (paramList.isEmpty()) || (TextUtils.isEmpty(paramSpannableStringBuilder))) {}
    for (;;)
    {
      return;
      HashMap localHashMap = new HashMap();
      paramList = paramList.iterator();
      Object localObject1;
      Object localObject2;
      while (paramList.hasNext())
      {
        localObject1 = (String)paramList.next();
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = parame.d((String)localObject1);
          String str = "@" + a((cs)localObject2);
          localHashMap.put(b((String)localObject1), new h(str, localObject2));
        }
      }
      parame = c.matcher(paramSpannableStringBuilder);
      int i;
      for (int j = 0; parame.find(); j = i)
      {
        paramList = parame.group();
        i = j;
        if (localHashMap.keySet().contains(paramList))
        {
          int k = parame.start() + j;
          localObject1 = (h)localHashMap.get(paramList);
          localObject2 = (String)((h)localObject1).a;
          paramSpannableStringBuilder.replace(k, paramList.length() + k, (CharSequence)localObject2);
          j += ((String)localObject2).length() - paramList.length();
          i = j;
          if (paramb != null)
          {
            paramb.a(paramSpannableStringBuilder, k, k + ((String)localObject2).length(), (cs)((h)localObject1).b);
            i = j;
          }
        }
      }
    }
  }
  
  public static String b(cs paramcs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject;
    if (a)
    {
      localObject = "⁨";
      localObject = localStringBuilder.append((String)localObject);
      if (!paramcs.f()) {
        break label65;
      }
      paramcs = paramcs.j();
      label35:
      localObject = ((StringBuilder)localObject).append(paramcs);
      if (!b) {
        break label94;
      }
    }
    label65:
    label94:
    for (paramcs = "⁩";; paramcs = "")
    {
      return paramcs;
      localObject = "";
      break;
      if (!TextUtils.isEmpty(paramcs.e))
      {
        paramcs = paramcs.e;
        break label35;
      }
      paramcs = cs.b(paramcs.t);
      break label35;
    }
  }
  
  public static String b(String paramString)
  {
    int i = paramString.indexOf('@');
    return "@" + paramString.substring(0, i);
  }
  
  static final class a
    extends anx
  {
    private final va a = va.a();
    private final cs c;
    
    public a(int paramInt, cs paramcs)
    {
      super(1711315404);
      this.c = paramcs;
    }
    
    public final void a(View paramView)
    {
      if (this.a.a(this.c.t)) {
        return;
      }
      paramView = yr.a(paramView.getContext());
      if (paramView != null)
      {
        ContactInfo.a(this.c, paramView);
        return;
      }
      Log.e("mention/could-not-get-activity");
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, cs paramcs);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/yr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */