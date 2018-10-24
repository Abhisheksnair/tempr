package com.whatsapp;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.content.b;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.whatsapp.util.at;

public class About
  extends nh
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903067);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(b.c(this, 2131623943));
    }
    Object localObject = (TextView)findViewById(2131755219);
    String str = getString(2131298101);
    if (av.d()) {}
    for (paramBundle = au.f();; paramBundle = au.d())
    {
      ((TextView)localObject).setText(String.format(str, new Object[] { paramBundle }));
      paramBundle = (Button)findViewById(2131755221);
      localObject = new SpannableString(getText(2131298129));
      ((SpannableString)localObject).setSpan(new UnderlineSpan(), 0, ((SpannableString)localObject).length(), 0);
      paramBundle.setText((CharSequence)localObject);
      paramBundle.setOnClickListener(new at()
      {
        public final void a(View paramAnonymousView)
        {
          paramAnonymousView = new Intent(About.this, Licenses.class);
          About.this.startActivity(paramAnonymousView);
        }
      });
      return;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/About.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */