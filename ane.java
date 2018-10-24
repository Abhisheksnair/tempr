package com.whatsapp;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Process;
import android.text.TextUtils;
import com.whatsapp.util.Log;
import java.util.Iterator;
import java.util.List;

public class ane
{
  private static volatile ane b;
  final and a;
  
  private ane(and paramand)
  {
    this.a = paramand;
  }
  
  public static ane a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new ane(and.a());
      }
      return b;
    }
    finally {}
  }
  
  public static void a(List<ActivityManager.RunningAppProcessInfo> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      Log.i("app/proccesses/proc " + Process.myPid() + " " + paramList.size());
      Iterator localIterator = paramList.iterator();
      int i = 0;
      label146:
      Object localObject;
      while (localIterator.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
        int j;
        StringBuilder localStringBuilder;
        if ((localRunningAppProcessInfo.processName != null) && (localRunningAppProcessInfo.processName.startsWith("com.whatsapp")))
        {
          Log.i("app/processes/procinfo " + localRunningAppProcessInfo.processName + " " + localRunningAppProcessInfo.pid + " " + localRunningAppProcessInfo.importance);
          j = i + 1;
          i = j;
          if (localRunningAppProcessInfo.pid != Process.myPid()) {
            continue;
          }
          localStringBuilder = new StringBuilder("app/processes/proc/self ");
          if (localRunningAppProcessInfo.processName != null) {
            break label276;
          }
          localObject = "?";
          label181:
          localStringBuilder = localStringBuilder.append((String)localObject).append(" ").append(localRunningAppProcessInfo.importance).append(" ").append(localRunningAppProcessInfo.importanceReasonCode).append(" ");
          if (localRunningAppProcessInfo.importanceReasonComponent != null) {
            break label285;
          }
        }
        label276:
        label285:
        for (localObject = "?";; localObject = localRunningAppProcessInfo.importanceReasonComponent.flattenToString())
        {
          Log.i((String)localObject);
          i = j;
          break;
          Log.d("app/processes/procinfo/other " + localRunningAppProcessInfo.processName);
          j = i;
          break label146;
          localObject = localRunningAppProcessInfo.processName;
          break label181;
        }
      }
      if (i == 0)
      {
        Log.w("app/processes/allprocs");
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (ActivityManager.RunningAppProcessInfo)paramList.next();
          if (((ActivityManager.RunningAppProcessInfo)localObject).processName != null) {
            Log.w(((ActivityManager.RunningAppProcessInfo)localObject).processName + " (" + ((ActivityManager.RunningAppProcessInfo)localObject).pid + ")");
          }
        }
      }
    }
  }
  
  final void a(String paramString)
  {
    try
    {
      Object localObject = this.a.b;
      if (localObject == null)
      {
        Log.i("app/logprocess am=null");
        return;
      }
      localObject = ((ActivityManager)localObject).getRunningAppProcesses();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
          if (TextUtils.equals(localRunningAppProcessInfo.processName, paramString))
          {
            Log.i("app/logprocess/procinfo " + localRunningAppProcessInfo.processName + ' ' + localRunningAppProcessInfo.pid);
            return;
          }
        }
      }
    }
    catch (Exception paramString)
    {
      Log.c("app/logprocess/error", paramString);
    }
  }
  
  public final void b()
  {
    int j = 0;
    Object localObject1 = this.a.e;
    if (localObject1 == null)
    {
      Log.w("app/log-network-info cm=null");
      return;
    }
    localObject1 = ((ConnectivityManager)localObject1).getAllNetworkInfo();
    StringBuilder localStringBuilder = new StringBuilder("network/info");
    if (localObject1 != null)
    {
      int k = localObject1.length;
      int i = 0;
      while (i < k)
      {
        Object localObject2 = localObject1[i];
        if (((NetworkInfo)localObject2).getState() != NetworkInfo.State.UNKNOWN)
        {
          localStringBuilder.append("\n").append(((NetworkInfo)localObject2).toString()).append(", type: ").append(((NetworkInfo)localObject2).getType()).append(", subtype: ").append(((NetworkInfo)localObject2).getSubtype());
          j = 1;
        }
        i += 1;
      }
      if (j != 0)
      {
        Log.i(localStringBuilder.toString());
        return;
      }
      Log.i("app/log-network-info/all_network_states_unknown");
      return;
    }
    Log.e("app/log-network-info/unavailable");
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ane.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */