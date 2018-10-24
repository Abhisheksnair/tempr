package com.whatsapp.jobqueue.requirement;

import a.a.a.a.a.a.d;
import android.content.Context;
import com.whatsapp.util.Log;
import java.util.Arrays;
import java.util.Locale;
import org.whispersystems.jobqueue.a.b;
import org.whispersystems.jobqueue.requirements.Requirement;

public final class HsmMessagePackRequirement
  implements b, Requirement
{
  private static final long MAX_RESPONSE_AGE = 3600000L;
  private static final long serialVersionUID = 1L;
  private transient com.whatsapp.b.a a;
  public final String elementName;
  public Locale[] locales;
  public final String namespace;
  
  public HsmMessagePackRequirement(Locale[] paramArrayOfLocale, String paramString1, String paramString2)
  {
    this.locales = ((Locale[])a.d.a(paramArrayOfLocale));
    this.namespace = ((String)a.d.a(paramString1));
    this.elementName = ((String)a.d.a(paramString2));
  }
  
  public final void a(Context paramContext)
  {
    this.a = com.whatsapp.b.a.a();
  }
  
  public final boolean a()
  {
    long l = this.a.c(this.locales, this.namespace);
    if ((l > 0L) && (System.currentTimeMillis() - l < 3600000L))
    {
      Log.i("satisfying hsm pack requirement due to recent response" + new StringBuilder("; locales=").append(Arrays.toString(this.locales)).append("; namespace=").append(this.namespace).toString());
      return true;
    }
    return b();
  }
  
  public final boolean b()
  {
    com.whatsapp.proto.a locala = this.a.a(this.locales, this.namespace);
    return (locala != null) && (locala.f() > 0) && (com.whatsapp.b.a.a(locala, this.elementName) != null);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/jobqueue/requirement/HsmMessagePackRequirement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */