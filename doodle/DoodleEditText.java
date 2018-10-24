package com.whatsapp.doodle;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.support.v4.view.ab;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import com.whatsapp.doodle.a.i;
import com.whatsapp.kc.a;

public class DoodleEditText
  extends EditText
{
  private kc.a a;
  private int b = 0;
  
  public DoodleEditText(Context paramContext)
  {
    super(paramContext);
    ab.d(this, 1);
  }
  
  public DoodleEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ab.d(this, 1);
  }
  
  public DoodleEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    ab.d(this, 1);
  }
  
  @TargetApi(21)
  public DoodleEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.b == 3)
    {
      setTextColor(-16777216);
      getPaint().setStrokeWidth(getTextSize() / 12.0F);
      getPaint().setStyle(Paint.Style.STROKE);
      super.onDraw(paramCanvas);
      setTextColor(-1);
      getPaint().setStrokeWidth(0.0F);
      getPaint().setStyle(Paint.Style.FILL);
    }
    super.onDraw(paramCanvas);
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.a != null) {
      this.a.a(paramInt, paramKeyEvent);
    }
    return super.onKeyPreIme(paramInt, paramKeyEvent);
  }
  
  public void setFontStyle(int paramInt)
  {
    if (this.b == paramInt) {
      return;
    }
    this.b = paramInt;
    if (paramInt == 3) {
      setTypeface(i.a(getContext()));
    }
    while (paramInt == 3) {
      if (Build.VERSION.SDK_INT >= 14)
      {
        setAllCaps(true);
        return;
        if (paramInt == 2) {
          setTypeface(i.b(getContext()));
        } else if (paramInt == 1) {
          setTypeface(Typeface.DEFAULT_BOLD);
        } else {
          setTypeface(Typeface.DEFAULT);
        }
      }
      else
      {
        setTransformationMethod(new TransformationMethod()
        {
          public final CharSequence getTransformation(CharSequence paramAnonymousCharSequence, View paramAnonymousView)
          {
            if (paramAnonymousCharSequence == null) {
              return null;
            }
            return paramAnonymousCharSequence.toString().toUpperCase();
          }
          
          public final void onFocusChanged(View paramAnonymousView, CharSequence paramAnonymousCharSequence, boolean paramAnonymousBoolean, int paramAnonymousInt, Rect paramAnonymousRect) {}
        });
        return;
      }
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      setAllCaps(false);
      return;
    }
    setTransformationMethod(null);
  }
  
  public void setOnKeyPreImeListener$22c81f3f(kc.a parama)
  {
    this.a = parama;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/doodle/DoodleEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */