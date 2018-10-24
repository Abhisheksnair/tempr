package com.whatsapp.notification.a;

import a.a.a.a.a.a.d;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.whatsapp.util.Log;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public abstract class f
{
  private static final f a = new a((byte)0);
  private static final f b = new a();
  private static f c;
  private static final f[] d = { new e(), new h(), new g(), new b(), new c(), new d(), b };
  
  public static f a(Context paramContext)
  {
    if (c != null) {
      return c;
    }
    if (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) {
      c = new h();
    }
    for (;;)
    {
      Log.i("badger/getbadger " + Arrays.asList(d).indexOf(c));
      return c;
      for (;;)
      {
        try
        {
          Object localObject = new Intent("android.intent.action.MAIN");
          ((Intent)localObject).addCategory("android.intent.category.HOME");
          paramContext = paramContext.getPackageManager().queryIntentActivities((Intent)localObject, 65536);
          if (paramContext == null) {
            continue;
          }
          paramContext = paramContext.iterator();
          if (paramContext.hasNext())
          {
            localObject = ((ResolveInfo)paramContext.next()).activityInfo.packageName;
            Log.i("badger/homepackage/" + (String)localObject);
            f[] arrayOff = d;
            int j = arrayOff.length;
            i = 0;
            if (i < j)
            {
              f localf = arrayOff[i];
              if (!localf.a().contains(localObject)) {
                continue;
              }
              c = localf;
            }
            localObject = c;
            if (localObject == null) {
              continue;
            }
          }
        }
        catch (Exception paramContext)
        {
          int i;
          Log.e("badger/getbadger " + paramContext.getMessage());
          continue;
          Log.i("badger/getbadger/notfound/disable");
          c = a;
        }
        if (c != null) {
          break;
        }
        if (Build.VERSION.SDK_INT < 21) {
          continue;
        }
        Log.i("badger/getbadger/notfound/default");
        c = b;
        break;
        i += 1;
        continue;
        Log.e("badger/nohome");
      }
    }
  }
  
  public static boolean a(f paramf)
  {
    return (paramf != null) && (paramf != a);
  }
  
  public abstract List<String> a();
  
  public abstract void a(int paramInt);
  
  static final class a
    extends f
  {
    public final List<String> a()
    {
      return null;
    }
    
    public final void a(int paramInt)
    {
      a.d.a(true, "should not call NoBadger");
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/notification/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */