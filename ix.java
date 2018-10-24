package com.whatsapp;

import android.content.Context;
import android.net.Uri;
import android.text.Html;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.style.URLSpan;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;

public final class ix
  extends hy
{
  public ix(Context paramContext, j paramj)
  {
    super(paramContext, paramj);
    TextEmojiLabel localTextEmojiLabel = (TextEmojiLabel)findViewById(2131755603);
    localTextEmojiLabel.setLinkHandler(new th());
    localTextEmojiLabel.setAutoLinkMask(0);
    localTextEmojiLabel.setLinksClickable(false);
    localTextEmojiLabel.setFocusable(false);
    localTextEmojiLabel.setClickable(false);
    localTextEmojiLabel.setLongClickable(false);
    String str = aog.b().toString();
    if (paramj.e.b) {}
    for (int i = 2131296810;; i = 2131296809)
    {
      paramContext = paramContext.getString(i, new Object[] { str });
      paramContext = Spannable.Factory.getInstance().newSpannable(Html.fromHtml(paramContext));
      paramj = (URLSpan[])paramContext.getSpans(0, paramContext.length(), URLSpan.class);
      int j = paramj.length;
      i = 0;
      while (i < j)
      {
        str = paramj[i];
        int k = paramContext.getSpanStart(str);
        int m = paramContext.getSpanEnd(str);
        paramContext.removeSpan(str);
        paramContext.setSpan(new ti(this.l, str.getURL(), -16733289), k, m, 0);
        i += 1;
      }
    }
    localTextEmojiLabel.setText(paramContext);
  }
  
  protected final boolean a()
  {
    return false;
  }
  
  protected final int getBubbleAlpha()
  {
    return 191;
  }
  
  protected final int getCenteredLayoutId()
  {
    return 2130903170;
  }
  
  protected final int getIncomingLayoutId()
  {
    return 2130903170;
  }
  
  protected final int getOutgoingLayoutId()
  {
    return 2130903171;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ix.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */