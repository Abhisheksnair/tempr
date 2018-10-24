package com.whatsapp;

import android.text.TextUtils;
import com.whatsapp.util.aa;
import com.whatsapp.util.bu;
import com.whatsapp.util.z;
import java.util.ArrayList;
import java.util.HashMap;

public final class aug
{
  private static z<String, auf> a = new z(16);
  private static HashMap<String, ArrayList<a>> b = new HashMap();
  
  public static auf a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (auf)a.get(paramString);
  }
  
  private static void a(pv parampv, String paramString, auf paramauf, boolean paramBoolean)
  {
    parampv.a(aui.a(paramBoolean, paramString, paramauf));
  }
  
  public static void a(pv parampv, String paramString, a parama)
  {
    if ((TextUtils.isEmpty(paramString)) || (aa.a(paramString))) {
      if (parama != null) {
        parama.a(null, true);
      }
    }
    do
    {
      return;
      localObject = a(paramString);
      if (localObject == null) {
        break;
      }
    } while (parama == null);
    parama.a((auf)localObject, true);
    return;
    Object localObject = (ArrayList)b.get(paramString);
    if (localObject != null)
    {
      ((ArrayList)localObject).add(parama);
      return;
    }
    localObject = new ArrayList(1);
    ((ArrayList)localObject).add(parama);
    b.put(paramString, localObject);
    bu.a(auh.a(new auf(paramString), parampv, paramString));
  }
  
  static abstract interface a
  {
    public abstract void a(auf paramauf, boolean paramBoolean);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/aug.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */