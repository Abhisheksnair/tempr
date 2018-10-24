package com.whatsapp.e;

import a.a.a.a.d;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.whatsapp.u;
import com.whatsapp.util.Log;
import java.util.Date;

public final class c
{
  final SharedPreferences a = u.a().getSharedPreferences("com.whatsapp_preferences", 0);
  
  static String a(String paramString1, String paramString2, String paramString3)
  {
    return String.format("%s_%s_%s", new Object[] { paramString1, paramString2, paramString3 });
  }
  
  private static String b(String paramString1, String paramString2)
  {
    return String.format("%s_%s", new Object[] { paramString1, paramString2 });
  }
  
  public final a a(String paramString)
  {
    if (!this.a.contains(b("data_usage_received", paramString))) {
      return null;
    }
    return new a(this.a.getLong(b("data_usage_received", paramString), 0L), this.a.getLong(b("data_usage_sent", paramString), 0L));
  }
  
  public final a a(String paramString1, String paramString2)
  {
    return new a(this.a.getLong(a("data_usage_received_accumulated", paramString1, paramString2), 0L), this.a.getLong(a("data_usage_sent_accumulated", paramString1, paramString2), 0L));
  }
  
  public final void a()
  {
    this.a.edit().putString("data_usage_last_sync_date", d.a(new Date())).commit();
  }
  
  public final void a(SharedPreferences.Editor paramEditor, a parama, String paramString1, String paramString2)
  {
    a locala = a(paramString1, paramString2);
    parama = new a(locala.a + parama.a, locala.b + parama.b);
    paramEditor.putLong(a("data_usage_received_accumulated", paramString1, paramString2), parama.a).putLong(a("data_usage_sent_accumulated", paramString1, paramString2), parama.b);
  }
  
  public final void a(a parama, String paramString)
  {
    parama = this.a.edit().putLong(b("data_usage_received", paramString), parama.a).putLong(b("data_usage_sent", paramString), parama.b);
    try
    {
      parama.commit();
      return;
    }
    catch (ArrayIndexOutOfBoundsException parama)
    {
      Log.w("datausagestorage/unable to commit");
    }
  }
  
  public final boolean b()
  {
    return this.a.getBoolean("data_usage_logging_enabled", false);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/e/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */