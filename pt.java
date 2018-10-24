package com.whatsapp;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import java.text.DateFormat;
import java.util.Date;

public final class pt
  extends pf
{
  private final ahc b = ahc.a();
  
  public pt(Activity paramActivity1, Activity paramActivity2)
  {
    super(paramActivity1, 2130903366, true);
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    DateFormat localDateFormat = DateFormat.getDateInstance(2);
    if ((av.g()) || (av.d())) {}
    for (paramBundle = this.a.getString(2131297873, new Object[] { localDateFormat.format(this.b.d()) });; paramBundle = this.a.getString(2131297874, new Object[] { localDateFormat.format(this.b.d()), this.a.getString(2131296368) }))
    {
      paramBundle = Html.fromHtml(paramBundle);
      ((TextView)findViewById(2131756090)).setText(paramBundle);
      ((TextView)findViewById(2131756091)).setText(Html.fromHtml(this.a.getString(2131297871, new Object[] { localDateFormat.format(new Date()) })));
      paramBundle = pu.a(this.a);
      findViewById(2131756092).setOnClickListener(paramBundle);
      findViewById(2131756089).setOnClickListener(paramBundle);
      return;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/pt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */