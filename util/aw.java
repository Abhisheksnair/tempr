package com.whatsapp.util;

import a.a.a.a.a.a.d;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import b.a.a.c;
import com.whatsapp.VoiceService;
import com.whatsapp.acz;

public final class aw
{
  final Sensor a;
  private final SensorManager b;
  private SensorEventListener c;
  
  public aw(Context paramContext)
  {
    this.b = ((SensorManager)paramContext.getSystemService("sensor"));
    this.a = this.b.getDefaultSensor(8);
  }
  
  public final void a(final a parama)
  {
    if (this.c != null)
    {
      this.b.unregisterListener(this.c, this.a);
      this.c = null;
    }
    if (parama != null)
    {
      this.c = new SensorEventListener()
      {
        private boolean c;
        
        public final void onAccuracyChanged(Sensor paramAnonymousSensor, int paramAnonymousInt) {}
        
        public final void onSensorChanged(SensorEvent paramAnonymousSensorEvent)
        {
          boolean bool2 = false;
          float f = paramAnonymousSensorEvent.values[0];
          boolean bool1 = bool2;
          if (f < 5.0F)
          {
            bool1 = bool2;
            if (f != aw.this.a.getMaximumRange()) {
              bool1 = true;
            }
          }
          if (bool1 != this.c)
          {
            this.c = bool1;
            paramAnonymousSensorEvent = parama.a;
            if (!bool1) {
              break label108;
            }
            Log.i("voip/ear-near");
            a.d.b();
            paramAnonymousSensorEvent.e = true;
            if ((paramAnonymousSensorEvent.b == null) || (Build.VERSION.SDK_INT < 21)) {
              c.a().b(new acz(true));
            }
          }
          return;
          label108:
          paramAnonymousSensorEvent.h();
        }
      };
      this.b.registerListener(this.c, this.a, 2);
    }
  }
  
  public static final class a
  {
    public final VoiceService a;
    
    public a(VoiceService paramVoiceService)
    {
      this.a = paramVoiceService;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */