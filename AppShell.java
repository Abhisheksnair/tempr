package com.whatsapp;

import android.util.Log;
import com.facebook.buck.android.support.exopackage.ExopackageApplication;
import com.whatsapp.dalvik.DalvikInternals;

public class AppShell
  extends ExopackageApplication
{
  public static final boolean a = false;
  public static final boolean b = false;
  public static final boolean c = false;
  private static final String d = AppShell.class.getSimpleName();
  
  public AppShell()
  {
    super("com.whatsapp.AppWrapper", 0);
  }
  
  protected void onBaseContextAttached()
  {
    if (c) {
      Log.d(d, "Applying LinearAlloc fixes");
    }
    for (;;)
    {
      try
      {
        long l = DalvikInternals.b();
        Log.d(d, "getLinearAllocUsage() = " + DalvikInternals.getLinearAllocUsage(l));
        Log.d(d, "getLinearAllocSize() = " + DalvikInternals.getLinearAllocSize(l));
        Log.d(d, "Resizing LinearAlloc buffer");
        com.whatsapp.dalvik.a.c();
        i = com.whatsapp.dalvik.a.a();
        if (i != 0) {
          continue;
        }
        Log.d(d, "Resizing LinearAlloc buffer succeeded");
        Log.d(d, "getLinearAllocUsage() = " + DalvikInternals.getLinearAllocUsage(l));
        Log.d(d, "getLinearAllocSize() = " + DalvikInternals.getLinearAllocSize(l));
      }
      catch (Exception localException)
      {
        int i;
        Log.e(d, "Failed to resize LinearAlloc buffer", localException);
        continue;
      }
      if (!b) {
        break;
      }
      android.support.b.a.a(this);
      return;
      Log.e(d, "Resizing LinearAlloc buffer failed with error [" + i + "]. " + com.whatsapp.dalvik.a.b());
      continue;
      Log.d(d, "Skipping LinearAlloc fixes");
    }
    Log.d(d, "Skipping MultiDex install");
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/AppShell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */