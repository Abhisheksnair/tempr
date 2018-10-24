package com.whatsapp;

import android.content.Context;
import com.whatsapp.data.cs;
import java.text.Collator;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ch
  implements Comparator<cs>
{
  private final Context a;
  private final Collator b;
  private final Map<String, String> c = new HashMap();
  
  public ch(Context paramContext)
  {
    this.a = paramContext;
    this.b = Collator.getInstance();
    this.b.setStrength(0);
    this.b.setDecomposition(1);
  }
  
  private String a(Context paramContext, cs paramcs)
  {
    Object localObject;
    if (paramcs == null) {
      localObject = null;
    }
    String str;
    do
    {
      return (String)localObject;
      if ((paramcs.r != null) && (paramcs.r.length() > 0)) {
        return paramcs.r;
      }
      str = (String)this.c.get(paramcs.t);
      localObject = str;
    } while (str != null);
    paramContext = paramcs.a(paramContext);
    this.c.put(paramcs.t, paramContext);
    return paramContext;
  }
  
  public int a(cs paramcs1, cs paramcs2)
  {
    String str1 = a(this.a, paramcs1);
    String str2 = a(this.a, paramcs2);
    if ((str1 == null) && (str2 == null)) {}
    int i;
    do
    {
      return 0;
      if (str1 == null) {
        return 1;
      }
      if (str2 == null) {
        return -1;
      }
      i = this.b.compare(str1, str2);
      if (i != 0) {
        break;
      }
    } while ((paramcs1.t == null) && (paramcs2.t == null));
    if (paramcs1.t == null) {
      return 1;
    }
    if (paramcs2.t == null) {
      return -1;
    }
    return paramcs1.t.compareTo(paramcs2.t);
    return i;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */