package com.whatsapp.j.a;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Build.VERSION;
import com.whatsapp.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public final class a
{
  private Resources a;
  private Method b;
  private b c;
  private String d;
  
  public a(Resources paramResources)
  {
    this.a = paramResources;
    if (Build.VERSION.SDK_INT >= 11) {
      return;
    }
    try
    {
      this.b = paramResources.getAssets().getClass().getDeclaredMethod("getResourceBagText", new Class[] { Integer.TYPE, Integer.TYPE });
      this.b.setAccessible(true);
      return;
    }
    catch (SecurityException paramResources)
    {
      Log.e(paramResources);
      return;
    }
    catch (NoSuchMethodException paramResources)
    {
      for (;;) {}
    }
  }
  
  public final String a(int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      return this.a.getQuantityString(paramInt1, paramInt2);
    }
    if (this.b == null) {
      return this.a.getQuantityString(paramInt1, paramInt2);
    }
    Object localObject1 = this.a.getConfiguration().locale;
    if (!((Locale)localObject1).getLanguage().equals(this.d))
    {
      this.d = ((Locale)localObject1).getLanguage();
      this.c = b.a((Locale)localObject1);
    }
    if (this.c == null) {
      return this.a.getQuantityString(paramInt1, paramInt2);
    }
    try
    {
      Object localObject2 = this.b.invoke(this.a.getAssets(), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(b.b(this.c.a(paramInt2))) });
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.b.invoke(this.a.getAssets(), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(16777220) });
      }
      if (localObject1 == null) {
        throw new Resources.NotFoundException("Plural resource ID #0x" + Integer.toHexString(paramInt1) + " quantity=" + paramInt2 + " item=" + b.c(this.c.a(paramInt2)));
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new Resources.NotFoundException(localIllegalAccessException.getMessage());
      return localIllegalAccessException.toString();
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;) {}
    }
  }
  
  public final String a(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    return String.format(this.a.getConfiguration().locale, a(paramInt1, paramInt2), paramVarArgs);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/j/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */