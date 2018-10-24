package com.whatsapp.memory.a;

import a.a.a.a.d;
import android.app.Activity;
import android.os.Build.VERSION;
import com.whatsapp.util.Log;
import java.lang.ref.WeakReference;

public final class a
{
  public static a a;
  
  public static final class a
    implements Runnable
  {
    private final WeakReference<Activity> a;
    
    public a(Activity paramActivity)
    {
      this.a = new WeakReference(paramActivity);
    }
    
    public final void run()
    {
      Activity localActivity = (Activity)this.a.get();
      if (localActivity == null) {}
      for (;;)
      {
        return;
        StringBuilder localStringBuilder = new StringBuilder(Log.a()).append("\n");
        localStringBuilder.append("LeakFixer/Potential leak found, activity=" + localActivity.getClass().getName());
        localStringBuilder.append(Log.b());
        Log.i(localStringBuilder.toString());
        if (Build.VERSION.SDK_INT == 10) {}
        for (int i = 1; i != 0; i = 0)
        {
          d.c(localActivity);
          return;
        }
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/memory/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */