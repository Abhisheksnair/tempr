package com.whatsapp.doodle;

import a.a.a.a.d;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import com.whatsapp.doodle.a.e;
import com.whatsapp.doodle.a.e.a;
import com.whatsapp.emoji.c;
import com.whatsapp.pv;

public final class p
  extends Dialog
{
  String a;
  int b;
  int c;
  float d;
  float e = Float.MIN_VALUE;
  float f = Float.MIN_VALUE;
  b g;
  int h;
  boolean i;
  private final pv j = pv.a();
  
  p(Activity paramActivity, String paramString, int paramInt1, float paramFloat, int paramInt2)
  {
    super(paramActivity, 2131427568);
    this.a = paramString;
    this.b = paramInt1;
    this.d = paramFloat;
    this.c = paramInt2;
  }
  
  public final void dismiss()
  {
    if (this.i) {
      if (!this.j.d()) {
        break label83;
      }
    }
    label83:
    for (float f1 = 1.0F;; f1 = -1.0F)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, f1, 1, 0.0F, 1, 0.0F);
      localTranslateAnimation.setFillBefore(true);
      localTranslateAnimation.setStartOffset(330L);
      localTranslateAnimation.setDuration(180L);
      localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
      ((ColorPickerView)findViewById(2131755721)).startAnimation(localTranslateAnimation);
      super.dismiss();
      return;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(getLayoutInflater().inflate(2130903213, null, false));
    getWindow().setLayout(-1, -1);
    getWindow().setFlags(1024, 1024);
    getWindow().clearFlags(256);
    paramBundle = (ColorPickerView)findViewById(2131755721);
    if (this.h > 0) {
      paramBundle.setMaxHeight(this.h);
    }
    if (this.i) {
      if (!this.j.d()) {
        break label305;
      }
    }
    label305:
    for (float f1 = 1.0F;; f1 = -1.0F)
    {
      final Object localObject = new TranslateAnimation(1, f1, 1, 0.0F, 1, 0.0F, 1, 0.0F);
      ((Animation)localObject).setFillBefore(true);
      ((Animation)localObject).setStartOffset(330L);
      ((Animation)localObject).setDuration(180L);
      ((Animation)localObject).setInterpolator(new DecelerateInterpolator());
      paramBundle.startAnimation((Animation)localObject);
      paramBundle.setColor(this.b);
      localObject = (DoodleEditText)findViewById(2131755444);
      ((DoodleEditText)localObject).setTextColor(this.b);
      ((DoodleEditText)localObject).setText(this.a);
      ((DoodleEditText)localObject).setFontStyle(this.c);
      ((DoodleEditText)localObject).setSelection(this.a.length(), this.a.length());
      ((DoodleEditText)localObject).setOnEditorActionListener(q.a(this));
      ((DoodleEditText)localObject).setOnKeyPreImeListener$22c81f3f(new r(this, (DoodleEditText)localObject));
      ((DoodleEditText)localObject).addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          c.a(paramAnonymousEditable, p.this.getContext(), localObject.getPaint());
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      paramBundle.setListener(new ColorPickerView.a()
      {
        public final void a() {}
        
        public final void a(float paramAnonymousFloat, int paramAnonymousInt)
        {
          p.this.b = paramAnonymousInt;
          localObject.setTextColor(paramAnonymousInt);
          float f = (e.i.f - e.i.e) / 4.0F;
          if (paramAnonymousFloat < e.i.e + f) {
            p.this.c = 0;
          }
          for (;;)
          {
            localObject.setFontStyle(p.this.c);
            if (p.a(p.this) != null) {
              p.a(p.this).a.g.a(paramAnonymousInt);
            }
            return;
            if (paramAnonymousFloat < e.i.e + 2.0F * f) {
              p.this.c = 1;
            } else if (paramAnonymousFloat < f * 3.0F + e.i.e) {
              p.this.c = 2;
            } else {
              p.this.c = 3;
            }
          }
        }
      });
      paramBundle = new a();
      findViewById(2131755446).setOnClickListener(s.a(this, (DoodleEditText)localObject, paramBundle));
      findViewById(2131755446).setOnTouchListener(paramBundle);
      getWindow().setSoftInputMode(5);
      d.a(getContext(), false);
      return;
    }
  }
  
  final class a
    implements View.OnTouchListener
  {
    float a = Float.MIN_VALUE;
    float b = Float.MIN_VALUE;
    
    a() {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      this.a = paramMotionEvent.getX();
      this.b = paramMotionEvent.getY();
      return false;
    }
  }
  
  public static final class b
  {
    final a a;
    
    b(a parama)
    {
      this.a = parama;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/doodle/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */