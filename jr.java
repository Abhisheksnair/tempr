package com.whatsapp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.content.b;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.whatsapp.data.e;
import com.whatsapp.emoji.c;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.protocol.m;
import com.whatsapp.util.aa;
import com.whatsapp.util.at;
import com.whatsapp.util.bg;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class jr
  extends hy
{
  private final TextEmojiLabel O = (TextEmojiLabel)findViewById(2131755603);
  private View P;
  private View Q;
  
  public jr(Context paramContext, j paramj)
  {
    super(paramContext, paramj);
    if (this.O == null) {
      throw new RuntimeException("messageTextView for conversationRow is null, rightLayout=" + paramj.e.b);
    }
    this.O.setLinkHandler(new th());
    this.O.setAutoLinkMask(0);
    this.O.setLinksClickable(false);
    this.O.setFocusable(false);
    this.O.setClickable(false);
    this.O.setLongClickable(false);
    p();
  }
  
  public static void a(View paramView, String paramString1, String paramString2, boolean paramBoolean, String paramString3, byte[] paramArrayOfByte, ArrayList<String> paramArrayList, int paramInt)
  {
    if (paramBoolean) {
      paramString2 = paramView.getContext().getResources().getString(2131296989);
    }
    paramView.findViewById(2131755224).setVisibility(8);
    TextView localTextView = (TextView)paramView.findViewById(2131755177);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject;
    label76:
    int i;
    if (paramString1 == null)
    {
      localObject = "";
      localStringBuilder = localStringBuilder.append((String)localObject);
      if (!TextUtils.isEmpty(paramString2)) {
        break label493;
      }
      localObject = "";
      localObject = new SpannableStringBuilder((String)localObject);
      if (!TextUtils.isEmpty(paramString1)) {
        ((SpannableStringBuilder)localObject).setSpan(new yq(), 0, paramString1.length(), 0);
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString2 = new ForegroundColorSpan(Integer.MIN_VALUE);
        if (paramString1 != null) {
          break label514;
        }
        i = 0;
        label144:
        ((SpannableStringBuilder)localObject).setSpan(paramString2, i, ((SpannableStringBuilder)localObject).length(), 0);
      }
      if (paramArrayList == null) {
        break label663;
      }
    }
    label227:
    label280:
    label346:
    label493:
    label514:
    label529:
    label591:
    label634:
    label644:
    label663:
    for (paramString1 = (SpannableStringBuilder)bg.a(paramView.getContext(), (CharSequence)localObject, paramArrayList, bg.b);; paramString1 = (String)localObject)
    {
      if (paramInt > 0) {
        paramString1 = new SpannableStringBuilder(paramView.getResources().getString(2131296917));
      }
      localTextView.setText(paramString1);
      paramString2 = (ThumbnailButton)paramView.findViewById(2131755327);
      float f;
      int j;
      if (paramBoolean)
      {
        f = -1.0F;
        paramString2.setRadius(f);
        paramString2.setContentDescription(null);
        if (paramInt <= 0) {
          break label529;
        }
        paramString2.setImageDrawable(paramString2.getResources().getDrawable(2130840308));
        paramString2.setBackgroundColor(201326592);
        paramString2.setContentDescription(paramView.getResources().getString(2131296917));
        paramString2.setVisibility(0);
        int k = paramView.getContext().getResources().getDimensionPixelSize(2131362036);
        i = paramView.getContext().getResources().getDimensionPixelSize(2131362035);
        if (!paramBoolean) {
          break label591;
        }
        k = k * 2 / 3;
        j = i * 2 / 3;
        i = paramView.getContext().getResources().getDimensionPixelSize(2131362034);
        paramString1 = ImageView.ScaleType.FIT_CENTER;
        paramString2.setScaleType(paramString1);
        paramString2.setPadding(i, i, i, i);
        paramString2.getLayoutParams().width = k;
        paramString2.getLayoutParams().height = j;
        paramArrayOfByte = (TextView)paramView.findViewById(2131756263);
        if (paramBoolean) {
          break label634;
        }
        paramString2 = null;
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString3)) {}
      }
      try
      {
        paramString1 = new URL(paramString3).getHost();
        if (!TextUtils.isEmpty(paramString1))
        {
          paramArrayOfByte.setText(paramString1);
          paramArrayOfByte.setVisibility(0);
        }
        for (;;)
        {
          paramString1 = paramView.findViewById(2131756264);
          paramString2 = (TextView)paramView.findViewById(2131756265);
          if (paramInt <= 0) {
            break label644;
          }
          paramString1.setVisibility(0);
          paramString2.setVisibility(0);
          paramString2.setText(Formatter.formatShortFileSize(paramView.getContext(), paramInt));
          return;
          localObject = paramString1;
          break;
          localObject = "\n" + paramString2;
          break label76;
          i = paramString1.length();
          break label144;
          f = 0.0F;
          break label227;
          paramString1 = null;
          if (paramArrayOfByte != null) {
            paramString1 = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
          }
          if ((paramString1 != null) && (paramString1.getHeight() != 0) && (paramString1.getWidth() != 0))
          {
            paramString2.setImageBitmap(paramString1);
            paramString2.setVisibility(0);
            break label280;
          }
          paramString2.setImageDrawable(null);
          paramString2.setVisibility(8);
          break label280;
          if (paramInt > 0)
          {
            paramString1 = ImageView.ScaleType.CENTER;
            j = i;
            i = 0;
            break label346;
          }
          paramString1 = ImageView.ScaleType.CENTER_CROP;
          j = i;
          i = 0;
          break label346;
          paramArrayOfByte.setVisibility(8);
          continue;
          paramArrayOfByte.setVisibility(8);
        }
        paramString1.setVisibility(8);
        paramString2.setVisibility(8);
        return;
      }
      catch (MalformedURLException paramString1)
      {
        for (;;)
        {
          paramString1 = paramString2;
        }
      }
    }
  }
  
  private void p()
  {
    String str = this.a.e();
    j localj = this.a;
    Object localObject5 = (ViewGroup)findViewById(2131755640);
    Object localObject3 = null;
    final Object localObject2;
    Object localObject1;
    boolean bool;
    label191:
    int i;
    if (m.a(localj))
    {
      localObject2 = aa.c(localj.e());
      if (localObject2 != null)
      {
        Object localObject4 = localj.p;
        localObject3 = localObject4;
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject4)) {
          break label623;
        }
        localObject1 = localObject2;
        if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!a(localj))) {
          break label712;
        }
        e();
        ((ViewGroup)localObject5).setVisibility(0);
        if (this.P == null)
        {
          this.P = al.a(this.l, LayoutInflater.from(getContext()), 2130903409, null, false);
          ((ViewGroup)localObject5).addView(this.P, -1, -2);
          this.P.setOnLongClickListener(this.u);
        }
        this.P.setOnClickListener(new at()
        {
          public final void a(View paramAnonymousView)
          {
            paramAnonymousView = jr.this.l;
            pv.a(jr.this.getContext(), Uri.parse(localObject2));
          }
        });
        if (TextUtils.isEmpty(AcceptInviteLinkActivity.a(Uri.parse((String)localObject2)))) {
          break label640;
        }
        bool = true;
        if (!bool) {
          break label659;
        }
        if (this.Q == null)
        {
          this.Q = al.a(this.l, LayoutInflater.from(getContext()), 2130903260, null, false);
          localObject3 = (TextView)this.Q.findViewById(2131755854);
          localObject4 = getContext();
          if (!localj.e.b) {
            break label645;
          }
          i = 2131624044;
          label261:
          ((TextView)localObject3).setTextColor(b.c((Context)localObject4, i));
          if (!localj.e.b) {
            break label652;
          }
          i = 2131298126;
          label287:
          ((TextView)localObject3).setText(i);
          aoa.b((TextView)localObject3);
          ((ViewGroup)findViewById(2131755602)).addView(this.Q, -1, -2);
        }
        this.Q.setOnClickListener(new at()
        {
          public final void a(View paramAnonymousView)
          {
            paramAnonymousView = jr.this.l;
            pv.a(jr.this.getContext(), Uri.parse(localObject2));
          }
        });
        label335:
        localObject3 = this.P;
        localObject4 = localj.z;
        localObject5 = localj.y;
        byte[] arrayOfByte = (byte[])localj.N;
        if (getRowsContainer() != null) {
          break label691;
        }
        localObject2 = null;
        label375:
        a((View)localObject3, (String)localObject4, (String)localObject5, bool, (String)localObject1, arrayOfByte, (ArrayList)localObject2, -1);
        localObject1 = (FrameLayout)this.P.findViewById(2131756260);
        localObject2 = getContext();
        if (!localj.e.b) {
          break label705;
        }
        i = 2130837647;
        label426:
        ((FrameLayout)localObject1).setForeground(b.a((Context)localObject2, i));
      }
    }
    for (;;)
    {
      a(str, this.O, this.a);
      this.O.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      this.O.clearAnimation();
      if (((str.length() == 1) && ((str.charAt(0) == 57378) || (str.charAt(0) == '❤'))) || ((str.length() == 2) && (str.charAt(0) == '❤') && (str.charAt(1) == 65039)))
      {
        this.O.setCompoundDrawablesWithIntrinsicBounds(2130840325, 0, 0, 0);
        localObject1 = new ScaleAnimation(0.85F, 0.8F, 0.85F, 0.8F, 1, 0.5F, 1, 0.5F);
        ((Animation)localObject1).setInterpolator(new DecelerateInterpolator());
        ((Animation)localObject1).setDuration(500L);
        ((Animation)localObject1).setRepeatMode(2);
        ((Animation)localObject1).setRepeatCount(-1);
        this.O.startAnimation((Animation)localObject1);
        this.O.setText("");
      }
      return;
      localObject1 = null;
      label623:
      localObject2 = localObject1;
      localObject1 = localObject3;
      break;
      localObject2 = null;
      localObject1 = null;
      break;
      label640:
      bool = false;
      break label191;
      label645:
      i = 2131624043;
      break label261;
      label652:
      i = 2131297077;
      break label287;
      label659:
      if (this.Q == null) {
        break label335;
      }
      ((ViewGroup)findViewById(2131755602)).removeView(this.Q);
      this.Q = null;
      break label335;
      label691:
      localObject2 = getRowsContainer().x();
      break label375;
      label705:
      i = 2130837639;
      break label426;
      label712:
      f();
      if (this.P != null)
      {
        ((ViewGroup)localObject5).removeView(this.P);
        this.P = null;
      }
      if (this.Q != null)
      {
        ((ViewGroup)findViewById(2131755602)).removeView(this.Q);
        this.Q = null;
      }
      ((ViewGroup)localObject5).setVisibility(8);
    }
  }
  
  public final void a(j paramj, boolean paramBoolean)
  {
    if (paramj != this.a) {}
    for (int i = 1;; i = 0)
    {
      super.a(paramj, paramBoolean);
      if ((paramBoolean) || (i != 0)) {
        p();
      }
      return;
    }
  }
  
  protected final boolean a()
  {
    return (!this.c) && (e.b(this.a.e.a));
  }
  
  protected int getCenteredLayoutId()
  {
    return 2130903167;
  }
  
  protected int getIncomingLayoutId()
  {
    return 2130903168;
  }
  
  protected int getOutgoingLayoutId()
  {
    return 2130903169;
  }
  
  public float getTextFontSize()
  {
    int i = c.b(this.a.e());
    if ((i > 0) && (i <= 3))
    {
      float f1 = a(getResources(), this.H);
      float f2 = Math.max(f1, 1.5F * Math.min(f1, getResources().getDisplayMetrics().density * f1 / getResources().getDisplayMetrics().scaledDensity));
      return (4 - i) * (f2 - f1) / 3.0F + f1;
    }
    return super.getTextFontSize();
  }
  
  public final void i()
  {
    p();
    super.i();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/jr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */