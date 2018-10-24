package com.whatsapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.whatsapp.util.Log;

public class CorruptInstallationActivity
  extends nh
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903073);
    paramBundle = (TextView)findViewById(2131755261);
    Object localObject2 = Html.fromHtml(getString(2131296592));
    Object localObject1 = new SpannableStringBuilder((CharSequence)localObject2);
    localObject2 = (URLSpan[])((Spanned)localObject2).getSpans(0, ((Spanned)localObject2).length(), URLSpan.class);
    if (localObject2 != null)
    {
      int j = localObject2.length;
      int i = 0;
      while (i < j)
      {
        Object localObject3 = localObject2[i];
        if ("contact-support".equals(((URLSpan)localObject3).getURL()))
        {
          Log.i("contact-support link found");
          int k = ((SpannableStringBuilder)localObject1).getSpanStart(localObject3);
          int m = ((SpannableStringBuilder)localObject1).getSpanEnd(localObject3);
          int n = ((SpannableStringBuilder)localObject1).getSpanFlags(localObject3);
          ((SpannableStringBuilder)localObject1).removeSpan(localObject3);
          localObject3 = new Intent(null, null, this, DescribeProblemActivity.class);
          ((Intent)localObject3).putExtra("com.whatsapp.DescribeProblemActivity.from", "corrupt-install");
          ((SpannableStringBuilder)localObject1).setSpan(new j((Intent)localObject3), k, m, n);
        }
        i += 1;
      }
    }
    paramBundle.setText((CharSequence)localObject1);
    paramBundle.setMovementMethod(LinkMovementMethod.getInstance());
    ((Button)findViewById(2131755257)).setOnClickListener(lw.a(this));
    ((Button)findViewById(2131755260)).setOnClickListener(lx.a(this));
    paramBundle = findViewById(2131755256);
    localObject1 = findViewById(2131755258);
    if (av.f())
    {
      localObject1 = (TextView)findViewById(2131755259);
      ((TextView)localObject1).setMovementMethod(LinkMovementMethod.getInstance());
      ((TextView)localObject1).setText(Html.fromHtml(String.format(getString(2131296594), new Object[] { "https://www.whatsapp.com" })));
      paramBundle.setVisibility(8);
      return;
    }
    ((View)localObject1).setVisibility(8);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/CorruptInstallationActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */