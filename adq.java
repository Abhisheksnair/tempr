package com.whatsapp;

import android.content.Context;
import com.whatsapp.data.cs;
import com.whatsapp.data.d;
import java.text.Collator;
import java.util.Comparator;

public final class adq
  implements Comparator<cs>
{
  private final Context a;
  private final d b;
  private final Collator c;
  
  public adq(Context paramContext, d paramd)
  {
    this.a = paramContext;
    this.b = paramd;
    this.c = Collator.getInstance();
    this.c.setStrength(0);
    this.c.setDecomposition(1);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/adq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */