package com.whatsapp.registration;

import android.os.Build.VERSION;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.view.View;
import com.whatsapp.and;
import com.whatsapp.atu;
import com.whatsapp.util.Log;

public class bi
{
  private static volatile bi b;
  volatile boolean a;
  private a c;
  private final and d;
  private final atu e;
  private final PhoneStateListener f = new PhoneStateListener()
  {
    public final void onCallForwardingIndicatorChanged(boolean paramAnonymousBoolean)
    {
      Log.d("roamingmanager/cfi " + paramAnonymousBoolean);
    }
    
    public final void onCallStateChanged(int paramAnonymousInt, String paramAnonymousString)
    {
      Log.d("roamingmanager/call-state state=" + paramAnonymousInt + "/number=" + paramAnonymousString);
    }
    
    public final void onCellLocationChanged(CellLocation paramAnonymousCellLocation)
    {
      if (paramAnonymousCellLocation == null)
      {
        Log.d("roamingmanager/cell-location (null)");
        return;
      }
      Log.d("roamingmanager/cell-location " + paramAnonymousCellLocation);
    }
    
    public final void onDataActivity(int paramAnonymousInt)
    {
      Log.d("roamingmanager/data-activity " + paramAnonymousInt);
    }
    
    public final void onDataConnectionStateChanged(int paramAnonymousInt)
    {
      Log.d("roamingmanager/data-connection-state-changed " + paramAnonymousInt);
    }
    
    public final void onDataConnectionStateChanged(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      Log.d("roamingmanager/data-connection-state-changed state=" + paramAnonymousInt1 + "/network-type=" + paramAnonymousInt2);
    }
    
    public final void onMessageWaitingIndicatorChanged(boolean paramAnonymousBoolean)
    {
      Log.d("roamingmanager/message-waiting-indicator-changed " + paramAnonymousBoolean);
    }
    
    public final void onServiceStateChanged(ServiceState paramAnonymousServiceState)
    {
      if (paramAnonymousServiceState == null) {
        Log.d("roamingmanager/service-state (null)");
      }
      do
      {
        return;
        bi.a(bi.this, paramAnonymousServiceState.getRoaming());
        Log.d("roamingmanager/service-state " + paramAnonymousServiceState);
        Log.d("roamingmanager/service-state/is-manual-selection " + paramAnonymousServiceState.getIsManualSelection());
        Log.i("roamingmanager/service-state/operator-alpha-long " + paramAnonymousServiceState.getOperatorAlphaLong());
        Log.i("roamingmanager/service-state/operator-alpha-short " + paramAnonymousServiceState.getOperatorAlphaShort());
        Log.i("roamingmanager/service-state/operator-numeric " + paramAnonymousServiceState.getOperatorNumeric());
        Log.i("roamingmanager/service-state/roaming " + bi.a(bi.this));
        Log.i("roamingmanager/service-state/state " + paramAnonymousServiceState.getState());
      } while (bi.b(bi.this) == null);
      paramAnonymousServiceState = bi.b(bi.this);
      boolean bool = bi.a(bi.this);
      paramAnonymousServiceState = paramAnonymousServiceState.a.findViewById(2131756153);
      if (bool) {}
      for (int i = 0;; i = 8)
      {
        paramAnonymousServiceState.setVisibility(i);
        return;
      }
    }
    
    public final void onSignalStrengthChanged(int paramAnonymousInt)
    {
      Log.d("roamingmanager/signal-strength " + paramAnonymousInt);
    }
    
    public final void onSignalStrengthsChanged(SignalStrength paramAnonymousSignalStrength)
    {
      if (paramAnonymousSignalStrength == null)
      {
        Log.d("roamingmanager/signal-strengths (null)");
        return;
      }
      Log.d("roamingmanager/signal-strengths " + paramAnonymousSignalStrength.toString());
    }
  };
  
  private bi(and paramand, atu paramatu)
  {
    this.d = paramand;
    this.e = paramatu;
  }
  
  public static bi a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new bi(and.a(), atu.a());
      }
      return b;
    }
    finally {}
  }
  
  public final void a(a parama)
  {
    this.c = parama;
    int j = 227;
    if (this.e.a("android.permission.READ_PHONE_STATE") == 0) {
      j = 495;
    }
    int i = j;
    if (this.e.a("android.permission.ACCESS_COARSE_LOCATION") == 0)
    {
      j |= 0x10;
      i = j;
      if (Build.VERSION.SDK_INT >= 17) {
        i = j | 0x400;
      }
    }
    for (;;)
    {
      try
      {
        parama = this.d.c;
        if (parama == null)
        {
          Log.w("roamingmanager/register tm=null");
          return;
        }
        parama.listen(this.f, i);
        return;
      }
      catch (SecurityException parama)
      {
        Log.d("roamingmanager/unable to register phone listener" + i, parama);
        return;
      }
    }
  }
  
  public final void b()
  {
    TelephonyManager localTelephonyManager = this.d.c;
    if (localTelephonyManager == null) {
      Log.w("roamingmanager/register tm=null");
    }
    for (;;)
    {
      this.c = null;
      return;
      localTelephonyManager.listen(this.f, 0);
    }
  }
  
  public static final class a
  {
    final VerifySms a;
    
    a(VerifySms paramVerifySms)
    {
      this.a = paramVerifySms;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/registration/bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */