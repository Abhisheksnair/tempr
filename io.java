package com.whatsapp;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.net.Uri.Builder;
import android.text.Html;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.style.URLSpan;
import com.whatsapp.protocol.j;

public final class io
  extends hy
{
  public io(Context paramContext, j paramj)
  {
    super(paramContext, paramj);
    paramj = (TextEmojiLabel)findViewById(2131755603);
    paramj.setLinkHandler(new th());
    paramj.setAutoLinkMask(0);
    paramj.setLinksClickable(false);
    paramj.setFocusable(false);
    paramj.setClickable(false);
    paramj.setLongClickable(false);
    paramContext = paramContext.getString(2131296607, new Object[] { aic.j().appendPath("general").appendPath("26000015").appendQueryParameter("lg", this.H.d()).appendQueryParameter("lc", this.H.c()).toString() });
    paramContext = Spannable.Factory.getInstance().newSpannable(Html.fromHtml(paramContext));
    URLSpan[] arrayOfURLSpan = (URLSpan[])paramContext.getSpans(0, paramContext.length(), URLSpan.class);
    int j = arrayOfURLSpan.length;
    int i = 0;
    while (i < j)
    {
      URLSpan localURLSpan = arrayOfURLSpan[i];
      int k = paramContext.getSpanStart(localURLSpan);
      int m = paramContext.getSpanEnd(localURLSpan);
      paramContext.removeSpan(localURLSpan);
      paramContext.setSpan(new ti(this.l, localURLSpan.getURL(), -16733289), k, m, 0);
      i += 1;
    }
    paramj.setText(paramContext);
    i = this.M.y();
    this.M.c().putInt("decryption_failure_views", i + 1).apply();
  }
  
  protected final boolean a()
  {
    return false;
  }
  
  protected final int getBubbleAlpha()
  {
    return 153;
  }
  
  protected final int getCenteredLayoutId()
  {
    return 2130903144;
  }
  
  protected final int getIncomingLayoutId()
  {
    return 2130903144;
  }
  
  protected final int getOutgoingLayoutId()
  {
    return 2130903145;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/io.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */