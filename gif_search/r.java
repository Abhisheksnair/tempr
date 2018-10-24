package com.whatsapp.gif_search;

import a.a.a.a.a.a.d;
import com.whatsapp.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class r
{
  final List<j> a = new ArrayList();
  String b;
  boolean c;
  boolean d;
  private a e;
  
  public final int a()
  {
    return this.a.size();
  }
  
  public final void a(a parama)
  {
    this.e = parama;
    if ((parama != null) && (!this.a.isEmpty())) {
      parama.a(this);
    }
  }
  
  public final void a(String paramString, Collection<j> paramCollection, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("gif/search/updating result \"").append(paramString).append("\"");
    if (paramBoolean) {}
    for (String str = " failed";; str = "")
    {
      Log.d(str);
      a.d.b();
      this.d = paramBoolean;
      if (paramCollection != null) {
        this.a.addAll(paramCollection);
      }
      this.b = paramString;
      if (this.e != null) {
        this.e.a(this);
      }
      this.c = false;
      return;
    }
  }
  
  public abstract boolean a(String paramString);
  
  public static abstract interface a
  {
    public abstract void a(r paramr);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gif_search/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */