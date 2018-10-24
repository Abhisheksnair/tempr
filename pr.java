package com.whatsapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.whatsapp.util.Log;
import com.whatsapp.util.l;
import java.util.Date;
import java.util.TimeZone;

public final class pr
  extends pf
{
  private final ahc b = ahc.a();
  private final aus c = aus.a();
  
  public pr(Activity paramActivity1, Activity paramActivity2)
  {
    super(paramActivity1, 2130903106, true);
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = new Date();
    Log.w("conversations/clock-wrong-time " + paramBundle.toString());
    Date localDate = this.b.a;
    if (localDate != null) {}
    for (long l = localDate.getTime();; l = paramBundle.getTime())
    {
      paramBundle = this.a.getString(2131296440, new Object[] { l.f(u.a(), this.c, l), TimeZone.getDefault().getDisplayName() });
      ((TextView)findViewById(2131755454)).setText(paramBundle);
      findViewById(2131755455).setOnClickListener(ps.a(this.a));
      return;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/pr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */