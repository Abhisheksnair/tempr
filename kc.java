package com.whatsapp;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.support.v7.widget.n;
import android.text.Editable;
import android.text.Editable.Factory;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.whatsapp.util.Log;
import java.util.List;

public class kc
  extends n
{
  private static boolean b = false;
  private static final Editable.Factory j;
  private int a;
  private final pv c;
  private final and d;
  private a e;
  private TextPaint f;
  private String g;
  private String h;
  private float i;
  
  static
  {
    try
    {
      Layout.class.getDeclaredMethod("processToSupportEmoji", new Class[] { CharSequence.class, Integer.TYPE, Integer.TYPE });
      b = true;
      j = new Editable.Factory()
      {
        public final Editable newEditable(CharSequence paramAnonymousCharSequence)
        {
          return new kc.b(paramAnonymousCharSequence);
        }
      };
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;) {}
    }
    catch (SecurityException localSecurityException)
    {
      for (;;) {}
    }
  }
  
  public kc(Context paramContext)
  {
    super(paramContext);
    if (isInEditMode())
    {
      paramContext = null;
      this.c = paramContext;
      if (!isInEditMode()) {
        break label47;
      }
    }
    label47:
    for (paramContext = (Context)localObject;; paramContext = and.a())
    {
      this.d = paramContext;
      a();
      return;
      paramContext = pv.a();
      break;
    }
  }
  
  public kc(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (isInEditMode())
    {
      paramContext = null;
      this.c = paramContext;
      if (!isInEditMode()) {
        break label48;
      }
    }
    label48:
    for (paramContext = (Context)localObject;; paramContext = and.a())
    {
      this.d = paramContext;
      a();
      return;
      paramContext = pv.a();
      break;
    }
  }
  
  public kc(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (isInEditMode())
    {
      paramContext = null;
      this.c = paramContext;
      if (!isInEditMode()) {
        break label51;
      }
    }
    label51:
    for (paramContext = (Context)localObject;; paramContext = and.a())
    {
      this.d = paramContext;
      a();
      return;
      paramContext = pv.a();
      break;
    }
  }
  
  private void a()
  {
    if ((Build.VERSION.SDK_INT >= 11) || (b)) {
      setEditableFactory(j);
    }
    if (Build.VERSION.SDK_INT >= 11) {
      setCustomSelectionActionModeCallback(new ActionMode.Callback()
      {
        public final boolean onActionItemClicked(ActionMode paramAnonymousActionMode, MenuItem paramAnonymousMenuItem)
        {
          int j = kc.this.getSelectionStart();
          int k = kc.this.getSelectionEnd();
          int i;
          if (j > k) {
            i = k;
          }
          for (;;)
          {
            switch (paramAnonymousMenuItem.getItemId())
            {
            default: 
              return false;
            case 2131756291: 
              paramAnonymousActionMode = "*";
            }
            for (;;)
            {
              paramAnonymousMenuItem = kc.this.getText();
              while ((j > i) && (Character.isSpaceChar(paramAnonymousMenuItem.charAt(j - 1)))) {
                j -= 1;
              }
              paramAnonymousActionMode = "_";
              continue;
              paramAnonymousActionMode = "~";
              continue;
              paramAnonymousActionMode = "```";
            }
            if ((j < paramAnonymousMenuItem.length()) && (!Character.isSpaceChar(paramAnonymousMenuItem.charAt(j)))) {
              paramAnonymousMenuItem.insert(j, " ");
            }
            paramAnonymousMenuItem.insert(j, paramAnonymousActionMode);
            while ((i < j) && (Character.isSpaceChar(paramAnonymousMenuItem.charAt(i)))) {
              i += 1;
            }
            j = i;
            if (i > 0)
            {
              j = i;
              if (!Character.isSpaceChar(paramAnonymousMenuItem.charAt(i - 1)))
              {
                paramAnonymousMenuItem.insert(i, " ");
                j = i + 1;
              }
            }
            paramAnonymousMenuItem.insert(j, paramAnonymousActionMode);
            return true;
            i = j;
            j = k;
          }
        }
        
        @TargetApi(11)
        public final boolean onCreateActionMode(ActionMode paramAnonymousActionMode, Menu paramAnonymousMenu)
        {
          paramAnonymousActionMode = paramAnonymousActionMode.getMenuInflater();
          if (paramAnonymousActionMode != null) {
            paramAnonymousActionMode.inflate(2131820548, paramAnonymousMenu);
          }
          for (;;)
          {
            return true;
            Log.w("conversation-text-entry/action-mode-with-null-menu-inflater");
          }
        }
        
        public final void onDestroyActionMode(ActionMode paramAnonymousActionMode) {}
        
        public final boolean onPrepareActionMode(ActionMode paramAnonymousActionMode, Menu paramAnonymousMenu)
        {
          return false;
        }
      });
    }
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    InputConnection localInputConnection = super.onCreateInputConnection(paramEditorInfo);
    if (this.a != 0)
    {
      int k = paramEditorInfo.imeOptions & 0xFF;
      if ((this.a & k) != 0)
      {
        paramEditorInfo.imeOptions = (k ^ paramEditorInfo.imeOptions);
        paramEditorInfo.imeOptions |= this.a;
      }
      if ((paramEditorInfo.imeOptions & 0x40000000) != 0) {
        paramEditorInfo.imeOptions &= 0xBFFFFFFF;
      }
    }
    return localInputConnection;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((!TextUtils.isEmpty(this.h)) && (TextUtils.isEmpty(getText())))
    {
      if (this.c.d()) {
        paramCanvas.drawText(this.h, getPaddingLeft(), getPaddingTop() - this.i, this.f);
      }
    }
    else {
      return;
    }
    this.f.setTextAlign(Paint.Align.RIGHT);
    paramCanvas.drawText(this.h, getWidth() - getPaddingRight(), getPaddingTop() - this.i, this.f);
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    if ((Build.VERSION.SDK_INT >= 14) && (!TextUtils.isEmpty(this.g)) && (TextUtils.isEmpty(getText()))) {
      paramAccessibilityNodeInfo.setText(this.g);
    }
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.e != null) {
      this.e.a(paramInt, paramKeyEvent);
    }
    return super.onKeyPreIme(paramInt, paramKeyEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.g != null)
    {
      paramInt1 = getMeasuredWidth();
      paramInt2 = getPaddingLeft();
      int k = getPaddingRight();
      if (this.f == null)
      {
        this.f = new TextPaint(1);
        this.f.setColor(getHintTextColors().getDefaultColor());
        this.f.setTextSize(getTextSize());
        this.f.setTextAlign(Paint.Align.LEFT);
      }
      this.h = TextUtils.ellipsize(this.g, this.f, paramInt1 - paramInt2 - k, TextUtils.TruncateAt.END).toString();
      this.i = this.f.getFontMetrics().top;
    }
  }
  
  public void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    if ((!TextUtils.isEmpty(this.g)) && (TextUtils.isEmpty(getText()))) {
      paramAccessibilityEvent.getText().add(this.g);
    }
  }
  
  public void setHint(String paramString)
  {
    this.g = paramString;
    this.h = null;
    requestLayout();
  }
  
  public void setInputEnterAction(int paramInt)
  {
    this.a = paramInt;
    setRawInputType(180225);
    int k = 4;
    if (paramInt == 0) {
      k = 1073741828;
    }
    paramInt = k;
    if (Build.VERSION.SDK_INT >= 14)
    {
      ContentResolver localContentResolver = this.d.f;
      if (localContentResolver == null) {
        break label74;
      }
      paramInt = k;
      if (!"com.htc.android.htcime/.HTCIMEService".equals(Settings.Secure.getString(localContentResolver, "default_input_method"))) {}
    }
    for (paramInt = k | 0x10000000;; paramInt = k)
    {
      setImeOptions(paramInt);
      return;
      label74:
      Log.w("conversation-text-entry/set-input-enter-action cr=null");
    }
  }
  
  public void setInputEnterDone(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int k = 6;; k = 0)
    {
      setInputEnterAction(k);
      return;
    }
  }
  
  public void setInputEnterSend(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int k = 4;; k = 0)
    {
      setInputEnterAction(k);
      return;
    }
  }
  
  public void setOnKeyPreImeListener(a parama)
  {
    this.e = parama;
  }
  
  public static abstract interface a
  {
    public abstract boolean a(int paramInt, KeyEvent paramKeyEvent);
  }
  
  public static final class b
    extends SpannableStringBuilder
  {
    public b(CharSequence paramCharSequence)
    {
      super();
    }
    
    public final char charAt(int paramInt)
    {
      if (paramInt < 0) {}
      while (paramInt >= length()) {
        return ' ';
      }
      return super.charAt(paramInt);
    }
    
    public final void getChars(int paramInt1, int paramInt2, char[] paramArrayOfChar, int paramInt3)
    {
      if (paramInt2 < paramInt1) {}
      int i;
      do
      {
        return;
        i = length();
      } while ((paramInt1 > i) || (paramInt2 > i) || (paramInt1 < 0) || (paramInt2 < 0));
      super.getChars(paramInt1, paramInt2, paramArrayOfChar, paramInt3);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/kc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */