package com.whatsapp.l;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class d
{
  final String a;
  final List<String> b;
  
  public d(String paramString, List<String> paramList)
  {
    this.a = paramString;
    this.b = Collections.unmodifiableList(new ArrayList(paramList));
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/l/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */