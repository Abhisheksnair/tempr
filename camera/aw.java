package com.whatsapp.camera;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.m;
import android.support.v4.app.n;
import android.support.v4.content.b;
import android.support.v7.app.b.a;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.whatsapp.StatusPrivacyActivity;
import com.whatsapp.al;
import com.whatsapp.att;
import com.whatsapp.data.co;
import com.whatsapp.j.a.a;
import com.whatsapp.pv;
import com.whatsapp.u;

public class aw
  extends m
{
  final att aa = att.a();
  final co ab = co.a();
  private TextView ac;
  
  public static aw R()
  {
    return new aw();
  }
  
  private Spanned S()
  {
    Object localObject;
    switch (this.ab.f())
    {
    default: 
      throw new IllegalStateException("unknown status distribution mode");
    case 0: 
      localObject = a(2131296798);
    }
    for (;;)
    {
      localObject = new SpannableStringBuilder((CharSequence)localObject);
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(a(2131296423));
      localSpannableStringBuilder.setSpan(new ClickableSpan()
      {
        public final void onClick(View paramAnonymousView)
        {
          paramAnonymousView = new Intent(paramAnonymousView.getContext(), StatusPrivacyActivity.class);
          aw.this.startActivityForResult(paramAnonymousView, 0);
        }
        
        public final void updateDrawState(TextPaint paramAnonymousTextPaint)
        {
          paramAnonymousTextPaint.setColor(b.c(aw.this.k(), 2131623947));
        }
      }, 0, localSpannableStringBuilder.length(), 33);
      ((SpannableStringBuilder)localObject).append(" ");
      ((SpannableStringBuilder)localObject).append(localSpannableStringBuilder);
      return (Spanned)localObject;
      localObject = this.ab.h();
      if (localObject.length == 0)
      {
        localObject = a(2131296798);
      }
      else
      {
        localObject = u.a.a(2131230747, localObject.length, new Object[] { Integer.valueOf(localObject.length) });
        continue;
        localObject = this.ab.g();
        localObject = u.a.a(2131230748, localObject.length, new Object[] { Integer.valueOf(localObject.length) });
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 0) {
      this.ac.setText(S());
    }
  }
  
  public final Dialog c(Bundle paramBundle)
  {
    paramBundle = al.a(pv.a(), l().getLayoutInflater(), 2130903227, null, false);
    this.ac = ((TextView)paramBundle.findViewById(2131755444));
    this.ac.setText(S());
    this.ac.setMovementMethod(LinkMovementMethod.getInstance());
    return new b.a(l()).a(paramBundle).a(true).a(2131297656, ax.a(this)).b(2131296398, ay.a(this)).a();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/camera/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */