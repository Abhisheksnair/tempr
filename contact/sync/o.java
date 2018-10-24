package com.whatsapp.contact.sync;

import android.text.TextUtils;
import com.whatsapp.and;
import java.text.Collator;
import java.util.Comparator;

public final class o
  implements Comparator<n>
{
  private final and a;
  private final Collator b;
  
  public o(and paramand)
  {
    this.a = paramand;
    this.b = Collator.getInstance();
    this.b.setStrength(0);
    this.b.setDecomposition(1);
  }
  
  private String a(n paramn)
  {
    Object localObject;
    if (paramn == null) {
      localObject = null;
    }
    String str;
    do
    {
      return (String)localObject;
      str = paramn.a(this.a);
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    return paramn.b;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/contact/sync/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */