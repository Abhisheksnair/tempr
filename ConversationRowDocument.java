package com.whatsapp;

import a.a.a.a.d;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.m;
import android.support.v4.content.b;
import android.support.v7.app.b.a;
import android.support.v7.app.c;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.whatsapp.data.ad;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.util.MediaFileUtils;
import com.whatsapp.util.ag;
import com.whatsapp.util.ag.a;
import com.whatsapp.util.p;
import java.io.File;

public final class ConversationRowDocument
  extends jm
{
  private final ImageButton O = (ImageButton)findViewById(2131755580);
  private final View P = findViewById(2131755592);
  private final CircularProgressBar Q = (CircularProgressBar)findViewById(2131755606);
  private final ImageView R = (ImageView)findViewById(2131755176);
  private final TextEmojiLabel S;
  private final View aa;
  private final View ab;
  private final TextView ac;
  private final TextView ad;
  private final View ae;
  private final TextView af;
  private final ImageView ag;
  private final View ah;
  private final ag ai = ag.a();
  
  public ConversationRowDocument(Context paramContext, j paramj)
  {
    super(paramContext, paramj);
    this.Q.setMax(100);
    this.Q.setProgressBarColor(b.c(paramContext, 2131624069));
    this.Q.setProgressBarBackgroundColor(536870912);
    this.S = ((TextEmojiLabel)findViewById(2131755177));
    this.aa = findViewById(2131755340);
    this.ac = ((TextView)findViewById(2131755493));
    this.ab = findViewById(2131755607);
    this.ad = ((TextView)findViewById(2131755608));
    this.ae = findViewById(2131755609);
    this.af = ((TextView)findViewById(2131755610));
    this.ag = ((ImageView)findViewById(2131755604));
    this.ah = findViewById(2131755605);
    p();
  }
  
  private void p()
  {
    int i = 1;
    Object localObject = this.a.b();
    this.R.setImageDrawable(p.a(getContext(), this.a));
    if (TextUtils.isEmpty(this.a.z))
    {
      this.S.setText(2131298069);
      if (!this.a.f().d()) {
        break label341;
      }
      this.ai.a(this.a, this.ag, new ag.a()
      {
        public final int a()
        {
          return (int)(252.0F * aoa.a().a);
        }
        
        public final void a(View paramAnonymousView)
        {
          ConversationRowDocument.a(ConversationRowDocument.this).setImageDrawable(new ColorDrawable(-7829368));
          ConversationRowDocument.a(ConversationRowDocument.this).setVisibility(0);
          ConversationRowDocument.b(ConversationRowDocument.this).setVisibility(0);
        }
        
        public final void a(View paramAnonymousView, Bitmap paramAnonymousBitmap, j paramAnonymousj)
        {
          if (paramAnonymousBitmap != null)
          {
            ConversationRowDocument.a(ConversationRowDocument.this).setImageBitmap(paramAnonymousBitmap);
            ConversationRowDocument.a(ConversationRowDocument.this).setVisibility(0);
            ConversationRowDocument.b(ConversationRowDocument.this).setVisibility(0);
            return;
          }
          ConversationRowDocument.a(ConversationRowDocument.this).setTag(null);
          ConversationRowDocument.a(ConversationRowDocument.this).setVisibility(8);
          ConversationRowDocument.b(ConversationRowDocument.this).setVisibility(8);
        }
      });
      label86:
      if (!((MediaData)localObject).transferring) {
        break label381;
      }
      f();
      this.P.setVisibility(0);
      this.O.setImageResource(2130840293);
      this.O.setOnClickListener(this.V);
      if (!this.a.e.b) {
        break label370;
      }
      this.aa.setOnClickListener(this.W);
      label149:
      g();
      if (i == 0) {
        break label592;
      }
      this.ad.setVisibility(0);
      this.ae.setVisibility(0);
      this.ad.setText(Formatter.formatShortFileSize(u.a(), this.a.t));
      label193:
      if (this.a.x == 0) {
        break label613;
      }
      this.ac.setVisibility(0);
      this.ab.setVisibility(0);
      this.ac.setText(p.a(this.a));
    }
    for (;;)
    {
      String str = MediaFileUtils.b(this.a.r).toUpperCase();
      localObject = str;
      if (TextUtils.isEmpty(str))
      {
        localObject = str;
        if (!TextUtils.isEmpty(this.a.y)) {
          localObject = d.l(this.a.y).toUpperCase();
        }
      }
      this.af.setText(a((CharSequence)localObject));
      this.aa.setOnLongClickListener(this.u);
      this.aa.setOnTouchListener(this.t);
      return;
      this.S.setText(a(this.a.z));
      break;
      label341:
      this.ag.setTag(null);
      this.ag.setVisibility(8);
      this.ah.setVisibility(8);
      break label86;
      label370:
      this.aa.setOnClickListener(null);
      break label149;
      label381:
      if ((((MediaData)localObject).transferred) || ((this.a.E) && (this.a.e.b) && (!j.b(this.a.e.a))))
      {
        e();
        this.P.setVisibility(8);
        this.aa.setOnClickListener(this.W);
        i = 0;
        break label149;
      }
      f();
      this.P.setVisibility(0);
      if ((this.a.e.b) && (((MediaData)localObject).file != null))
      {
        this.O.setImageResource(2130840305);
        this.O.setContentDescription(getContext().getString(2131297619));
        this.O.setOnClickListener(this.U);
        this.aa.setOnClickListener(this.W);
        break label149;
      }
      this.O.setImageResource(2130840296);
      this.O.setContentDescription(getContext().getString(2131296368));
      this.O.setOnClickListener(this.T);
      this.aa.setOnClickListener(this.T);
      break label149;
      label592:
      this.ad.setVisibility(8);
      this.ae.setVisibility(8);
      break label193;
      label613:
      this.ac.setVisibility(8);
      this.ab.setVisibility(8);
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
    return false;
  }
  
  protected final void b()
  {
    Object localObject = this.a.b();
    if ((!this.a.e.b) && (!((MediaData)localObject).transferred)) {}
    do
    {
      return;
      if ((((MediaData)localObject).file != null) && (((MediaData)localObject).file.exists())) {
        break;
      }
      localObject = getContext();
    } while (!(localObject instanceof nh));
    this.l.a((nh)localObject);
    return;
    if (((MediaData)localObject).suspiciousContent == MediaData.SUSPICIOUS_CONTENT_YES_KEEP)
    {
      a.a(this.a.Q).a(((c)getContext()).j_(), null);
      return;
    }
    localObject = new Intent("android.intent.action.VIEW");
    ((Intent)localObject).setDataAndType(MediaProvider.a(this.a), this.a.r);
    ((Intent)localObject).setFlags(1);
    pv.a(getContext(), (Intent)localObject);
  }
  
  public final void g()
  {
    a(this.Q, this.a.b());
  }
  
  protected final int getCenteredLayoutId()
  {
    return 2130903147;
  }
  
  protected final int getIncomingLayoutId()
  {
    return 2130903147;
  }
  
  protected final int getOutgoingLayoutId()
  {
    return 2130903149;
  }
  
  public final void i()
  {
    p();
    super.i();
  }
  
  public static class DocumentPreviewView
    extends ImageView
  {
    public DocumentPreviewView(Context paramContext)
    {
      super();
      setScaleType(ImageView.ScaleType.MATRIX);
    }
    
    public DocumentPreviewView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      setScaleType(ImageView.ScaleType.MATRIX);
    }
    
    public DocumentPreviewView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
      setScaleType(ImageView.ScaleType.MATRIX);
    }
    
    protected boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      Matrix localMatrix;
      int i;
      int j;
      int k;
      int m;
      if (getDrawable() != null)
      {
        localMatrix = getImageMatrix();
        i = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
        j = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
        k = getDrawable().getIntrinsicWidth();
        m = getDrawable().getIntrinsicHeight();
        if (k * j <= m * i) {
          break label143;
        }
      }
      label143:
      for (float f = j / m;; f = i / k)
      {
        localMatrix.setRectToRect(new RectF(0.0F, 0.0F, k, j / f), new RectF(0.0F, 0.0F, i, j), Matrix.ScaleToFit.FILL);
        setImageMatrix(localMatrix);
        return super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
      }
    }
  }
  
  public static final class a
    extends m
  {
    final pv aa = pv.a();
    final ad ab = ad.a();
    final com.whatsapp.data.l ac = com.whatsapp.data.l.a();
    
    public static a a(long paramLong)
    {
      a locala = new a();
      Bundle localBundle = new Bundle();
      localBundle.putLong("message_id", paramLong);
      locala.f(localBundle);
      return locala;
    }
    
    public final Dialog c(Bundle paramBundle)
    {
      return new b.a(k()).b(a(2131298190)).a(2131297335, iv.a(this)).b(2131296398, null).a();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ConversationRowDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */