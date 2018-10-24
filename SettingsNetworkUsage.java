package com.whatsapp;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import com.whatsapp.gdrive.GoogleDriveService;
import com.whatsapp.j.a.a;
import com.whatsapp.preference.WaDialogPreference;
import com.whatsapp.util.l;
import java.util.Timer;
import java.util.TimerTask;

public class SettingsNetworkUsage
  extends nn
{
  private Handler n;
  private Timer o = new Timer("refresh-network-usage");
  private TimerTask p;
  private final vv q = vv.a();
  
  private void a(PreferenceScreen paramPreferenceScreen, String paramString)
  {
    if (paramPreferenceScreen == null) {}
    do
    {
      return;
      paramString = findPreference(paramString);
    } while (paramString == null);
    paramPreferenceScreen.removePreference(paramString);
  }
  
  private void a(String paramString, int paramInt, long paramLong)
  {
    paramString = findPreference(paramString);
    if (paramString != null) {
      paramString.setSummary(String.format(u.a.a(paramInt, (int)paramLong), new Object[] { Long.valueOf(paramLong) }));
    }
  }
  
  private void a(String paramString, int paramInt, Object... paramVarArgs)
  {
    paramString = findPreference(paramString);
    if (paramString != null) {
      paramString.setSummary(String.format(getString(paramInt), paramVarArgs));
    }
  }
  
  private void a(String paramString, long paramLong)
  {
    double d = paramLong;
    int i = 0;
    while ((i < 3) && (d > 1024.0D))
    {
      d /= 1024.0D;
      i += 1;
    }
    switch (i)
    {
    default: 
      i = 2131297246;
    }
    for (;;)
    {
      a(paramString, i, new Object[] { Double.valueOf(d) });
      return;
      a(paramString, 2131230775, paramLong);
      return;
      i = 2131297247;
      continue;
      i = 2131297249;
    }
  }
  
  private void b()
  {
    Statistics.Data localData = Statistics.a;
    long l1;
    if (localData != null)
    {
      a("network_usage_messages_sent", 2131230776, localData.getTotalMessagesSent());
      a("network_usage_messages_received", 2131230776, localData.getTotalMessagesReceived());
      a("network_usage_media_bytes_sent", localData.getMediaBytesSent());
      a("network_usage_media_bytes_received", localData.getMediaBytesReceived());
      a("network_usage_message_bytes_sent", localData.getMessageBytesSent());
      a("network_usage_message_bytes_received", localData.getMessageBytesReceived());
      a("network_usage_statuses_sent", 2131230777, localData.getTotalStatusesSent());
      a("network_usage_statuses_received", 2131230777, localData.getTotalStatusesReceived());
      a("network_usage_status_bytes_sent", localData.getStatusBytesSent());
      a("network_usage_status_bytes_received", localData.getStatusBytesReceived());
      a("network_usage_voip_calls_sent", 2131230778, localData.getOutgoingVoipCalls());
      a("network_usage_voip_calls_received", 2131230778, localData.getIncomingVoipCalls());
      a("network_usage_voip_call_bytes_sent", localData.getVoipBytesSent());
      a("network_usage_voip_call_bytes_received", localData.getVoipBytesReceived());
      l1 = localData.getTotalBytesSentToGoogleDrive();
      long l2 = localData.getTotalBytesReceivedFromGoogleDrive();
      if ((!GoogleDriveService.c()) && (l1 <= 0L) && (l2 <= 0L)) {
        break label303;
      }
      a("google_drive_total_bytes_sent", l1);
      a("google_drive_total_bytes_received", l2);
    }
    for (;;)
    {
      a("network_usage_roaming_bytes_sent", localData.getRoamingBytesSent());
      a("network_usage_roaming_bytes_received", localData.getRoamingBytesReceived());
      a("network_usage_total_bytes_sent", localData.getTotalBytesSent());
      a("network_usage_total_bytes_received", localData.getTotalBytesReceived());
      l1 = localData.getLastReset();
      if (l1 == Long.MIN_VALUE) {
        break;
      }
      a("network_usage_reset", 2131297252, new Object[] { l.f(this, this.g, l1) });
      return;
      label303:
      a(getPreferenceScreen(), "google_drive_total_bytes_sent");
      a(getPreferenceScreen(), "google_drive_total_bytes_received");
    }
    a("network_usage_reset", 2131297252, new Object[] { getString(2131297272) });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    addPreferencesFromResource(2131099661);
    ((WaDialogPreference)findPreference("network_usage_reset")).a = aky.a(this);
    this.n = new Handler(Looper.myLooper());
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.o.cancel();
  }
  
  protected void onPause()
  {
    super.onPause();
    this.p.cancel();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.p = new TimerTask()
    {
      public final void run()
      {
        SettingsNetworkUsage.a(SettingsNetworkUsage.this).post(new akz(SettingsNetworkUsage.this));
      }
    };
    this.o.scheduleAtFixedRate(this.p, 0L, 1000L);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/SettingsNetworkUsage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */