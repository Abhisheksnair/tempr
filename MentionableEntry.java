package com.whatsapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.widget.AppBarLayout.b;
import android.support.v13.view.inputmethod.EditorInfoCompat;
import android.support.v13.view.inputmethod.InputConnectionCompat;
import android.support.v13.view.inputmethod.InputContentInfoCompat;
import android.support.v4.content.b;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.c;
import android.text.ClipboardManager;
import android.text.Editable;
import android.text.Editable.Factory;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.Filter;
import com.whatsapp.data.cs;
import com.whatsapp.f.c;
import com.whatsapp.f.d;
import com.whatsapp.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MentionableEntry
  extends kc
  implements MentionPickerView.b, MentionPickerView.c, c
{
  View a;
  MentionAnnotationSpan b;
  MentionPickerView c;
  a d;
  private boolean e;
  private boolean f;
  private int g;
  private int h;
  private int i;
  private Bundle j;
  private MentionPickerView.b k;
  private ViewGroup l;
  private AppBarLayout.b m;
  private String n;
  private String[] o;
  private final pv p;
  private final com.whatsapp.data.e q;
  private final rh r;
  private final com.whatsapp.f.e s;
  private TextWatcher t;
  
  public MentionableEntry(Context paramContext)
  {
    super(paramContext);
    if (isInEditMode())
    {
      paramContext = null;
      this.p = paramContext;
      if (!isInEditMode()) {
        break label80;
      }
      paramContext = null;
      label30:
      this.q = paramContext;
      if (!isInEditMode()) {
        break label87;
      }
    }
    label80:
    label87:
    for (paramContext = (Context)localObject;; paramContext = rh.a())
    {
      this.r = paramContext;
      this.s = new com.whatsapp.f.e();
      this.t = new TextWatcher()
      {
        public boolean a;
        private int c;
        private MentionableEntry.MentionSpan[] d;
        
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          int i = 0;
          if (this.c > 0)
          {
            MentionableEntry localMentionableEntry = MentionableEntry.this;
            MentionableEntry.MentionSpan[] arrayOfMentionSpan = this.d;
            MentionableEntry.MentionSpan localMentionSpan;
            if (!this.a)
            {
              arrayOfMentionSpan = (MentionableEntry.MentionSpan[])localMentionableEntry.getEditableText().getSpans(localMentionableEntry.getSelectionStart(), localMentionableEntry.getSelectionEnd(), MentionableEntry.MentionSpan.class);
              localMentionableEntry.a(localMentionableEntry.b);
              localMentionableEntry.b = null;
              j = arrayOfMentionSpan.length;
              while (i < j)
              {
                localMentionSpan = arrayOfMentionSpan[i];
                localMentionableEntry.a(localMentionSpan.c);
                localMentionableEntry.a(localMentionSpan);
                i += 1;
              }
            }
            int j = arrayOfMentionSpan.length;
            i = 0;
            while (i < j)
            {
              localMentionSpan = arrayOfMentionSpan[i];
              int k = paramAnonymousEditable.getSpanStart(localMentionSpan.c);
              int m = paramAnonymousEditable.getSpanEnd(localMentionSpan);
              if ((k != -1) && (m != -1))
              {
                localMentionableEntry.a(localMentionSpan.c);
                localMentionableEntry.a(localMentionSpan);
                paramAnonymousEditable.delete(k, m);
              }
              i += 1;
            }
          }
          MentionableEntry.a(MentionableEntry.this, paramAnonymousEditable);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          paramAnonymousInt1 = MentionableEntry.this.getSelectionEnd();
          this.d = ((MentionableEntry.MentionSpan[])MentionableEntry.this.getEditableText().getSpans(paramAnonymousInt1, paramAnonymousInt1, MentionableEntry.MentionSpan.class));
          if (MentionableEntry.this.getSelectionStart() == MentionableEntry.this.getSelectionEnd()) {}
          for (boolean bool = true;; bool = false)
          {
            this.a = bool;
            return;
          }
        }
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          this.c = paramAnonymousInt2;
        }
      };
      return;
      paramContext = pv.a();
      break;
      paramContext = com.whatsapp.data.e.a();
      break label30;
    }
  }
  
  public MentionableEntry(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (isInEditMode())
    {
      paramContext = null;
      this.p = paramContext;
      if (!isInEditMode()) {
        break label81;
      }
      paramContext = null;
      label31:
      this.q = paramContext;
      if (!isInEditMode()) {
        break label88;
      }
    }
    label81:
    label88:
    for (paramContext = (Context)localObject;; paramContext = rh.a())
    {
      this.r = paramContext;
      this.s = new com.whatsapp.f.e();
      this.t = new TextWatcher()
      {
        public boolean a;
        private int c;
        private MentionableEntry.MentionSpan[] d;
        
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          int i = 0;
          if (this.c > 0)
          {
            MentionableEntry localMentionableEntry = MentionableEntry.this;
            MentionableEntry.MentionSpan[] arrayOfMentionSpan = this.d;
            MentionableEntry.MentionSpan localMentionSpan;
            if (!this.a)
            {
              arrayOfMentionSpan = (MentionableEntry.MentionSpan[])localMentionableEntry.getEditableText().getSpans(localMentionableEntry.getSelectionStart(), localMentionableEntry.getSelectionEnd(), MentionableEntry.MentionSpan.class);
              localMentionableEntry.a(localMentionableEntry.b);
              localMentionableEntry.b = null;
              j = arrayOfMentionSpan.length;
              while (i < j)
              {
                localMentionSpan = arrayOfMentionSpan[i];
                localMentionableEntry.a(localMentionSpan.c);
                localMentionableEntry.a(localMentionSpan);
                i += 1;
              }
            }
            int j = arrayOfMentionSpan.length;
            i = 0;
            while (i < j)
            {
              localMentionSpan = arrayOfMentionSpan[i];
              int k = paramAnonymousEditable.getSpanStart(localMentionSpan.c);
              int m = paramAnonymousEditable.getSpanEnd(localMentionSpan);
              if ((k != -1) && (m != -1))
              {
                localMentionableEntry.a(localMentionSpan.c);
                localMentionableEntry.a(localMentionSpan);
                paramAnonymousEditable.delete(k, m);
              }
              i += 1;
            }
          }
          MentionableEntry.a(MentionableEntry.this, paramAnonymousEditable);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          paramAnonymousInt1 = MentionableEntry.this.getSelectionEnd();
          this.d = ((MentionableEntry.MentionSpan[])MentionableEntry.this.getEditableText().getSpans(paramAnonymousInt1, paramAnonymousInt1, MentionableEntry.MentionSpan.class));
          if (MentionableEntry.this.getSelectionStart() == MentionableEntry.this.getSelectionEnd()) {}
          for (boolean bool = true;; bool = false)
          {
            this.a = bool;
            return;
          }
        }
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          this.c = paramAnonymousInt2;
        }
      };
      return;
      paramContext = pv.a();
      break;
      paramContext = com.whatsapp.data.e.a();
      break label31;
    }
  }
  
  public MentionableEntry(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (isInEditMode())
    {
      paramContext = null;
      this.p = paramContext;
      if (!isInEditMode()) {
        break label84;
      }
      paramContext = null;
      label33:
      this.q = paramContext;
      if (!isInEditMode()) {
        break label91;
      }
    }
    label84:
    label91:
    for (paramContext = (Context)localObject;; paramContext = rh.a())
    {
      this.r = paramContext;
      this.s = new com.whatsapp.f.e();
      this.t = new TextWatcher()
      {
        public boolean a;
        private int c;
        private MentionableEntry.MentionSpan[] d;
        
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          int i = 0;
          if (this.c > 0)
          {
            MentionableEntry localMentionableEntry = MentionableEntry.this;
            MentionableEntry.MentionSpan[] arrayOfMentionSpan = this.d;
            MentionableEntry.MentionSpan localMentionSpan;
            if (!this.a)
            {
              arrayOfMentionSpan = (MentionableEntry.MentionSpan[])localMentionableEntry.getEditableText().getSpans(localMentionableEntry.getSelectionStart(), localMentionableEntry.getSelectionEnd(), MentionableEntry.MentionSpan.class);
              localMentionableEntry.a(localMentionableEntry.b);
              localMentionableEntry.b = null;
              j = arrayOfMentionSpan.length;
              while (i < j)
              {
                localMentionSpan = arrayOfMentionSpan[i];
                localMentionableEntry.a(localMentionSpan.c);
                localMentionableEntry.a(localMentionSpan);
                i += 1;
              }
            }
            int j = arrayOfMentionSpan.length;
            i = 0;
            while (i < j)
            {
              localMentionSpan = arrayOfMentionSpan[i];
              int k = paramAnonymousEditable.getSpanStart(localMentionSpan.c);
              int m = paramAnonymousEditable.getSpanEnd(localMentionSpan);
              if ((k != -1) && (m != -1))
              {
                localMentionableEntry.a(localMentionSpan.c);
                localMentionableEntry.a(localMentionSpan);
                paramAnonymousEditable.delete(k, m);
              }
              i += 1;
            }
          }
          MentionableEntry.a(MentionableEntry.this, paramAnonymousEditable);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          paramAnonymousInt1 = MentionableEntry.this.getSelectionEnd();
          this.d = ((MentionableEntry.MentionSpan[])MentionableEntry.this.getEditableText().getSpans(paramAnonymousInt1, paramAnonymousInt1, MentionableEntry.MentionSpan.class));
          if (MentionableEntry.this.getSelectionStart() == MentionableEntry.this.getSelectionEnd()) {}
          for (boolean bool = true;; bool = false)
          {
            this.a = bool;
            return;
          }
        }
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          this.c = paramAnonymousInt2;
        }
      };
      return;
      paramContext = pv.a();
      break;
      paramContext = com.whatsapp.data.e.a();
      break label33;
    }
  }
  
  private static int a(int paramInt, Editable paramEditable)
  {
    MentionSpan[] arrayOfMentionSpan = (MentionSpan[])paramEditable.getSpans(paramInt, paramInt, MentionSpan.class);
    int i4 = arrayOfMentionSpan.length;
    int i1 = 0;
    if (i1 < i4)
    {
      MentionSpan localMentionSpan = arrayOfMentionSpan[i1];
      int i2 = paramEditable.getSpanStart(localMentionSpan) - 1;
      int i3 = paramEditable.getSpanEnd(localMentionSpan);
      if (paramInt <= (i2 + i3) / 2) {}
      for (paramInt = i2;; paramInt = i3)
      {
        i1 += 1;
        break;
      }
    }
    return paramInt;
  }
  
  private int a(Editable paramEditable, int paramInt)
  {
    int i1 = paramEditable.toString().substring(paramInt, getSelectionEnd()).lastIndexOf("@");
    paramEditable = (MentionAnnotationSpan[])paramEditable.getSpans(i1, i1 + 1, MentionAnnotationSpan.class);
    int i2 = paramEditable.length;
    paramInt = 0;
    while (paramInt < i2)
    {
      if (paramEditable[paramInt].a) {
        return -1;
      }
      paramInt += 1;
    }
    return i1;
  }
  
  private SpannableStringBuilder a(String paramString, Collection<String> paramCollection1, Collection<String> paramCollection2)
  {
    if (this.f) {
      a(null);
    }
    a(this.b);
    this.b = null;
    paramString = new SpannableStringBuilder(paramString);
    a(paramString, paramCollection1, true);
    if (paramCollection2 != null) {
      a(paramString, paramCollection2, false);
    }
    return paramString;
  }
  
  private String a(int paramInt1, int paramInt2)
  {
    int i1 = 0;
    Editable localEditable = Editable.Factory.getInstance().newEditable(getText().subSequence(paramInt1, paramInt2));
    MentionSpan[] arrayOfMentionSpan = (MentionSpan[])localEditable.getSpans(0, localEditable.length(), MentionSpan.class);
    paramInt2 = arrayOfMentionSpan.length;
    paramInt1 = i1;
    while (paramInt1 < paramInt2)
    {
      MentionSpan localMentionSpan = arrayOfMentionSpan[paramInt1];
      localEditable.replace(localEditable.getSpanStart(localMentionSpan) - 1, localEditable.getSpanEnd(localMentionSpan), localMentionSpan.b);
      paramInt1 += 1;
    }
    return localEditable.toString();
  }
  
  private void a(Editable paramEditable)
  {
    int i1 = a(paramEditable, 0);
    MentionSpan[] arrayOfMentionSpan = (MentionSpan[])paramEditable.getSpans(i1 + 1, getSelectionEnd(), MentionSpan.class);
    int i2;
    if (arrayOfMentionSpan.length > 0)
    {
      int i4 = arrayOfMentionSpan.length;
      i1 = 0;
      int i3;
      for (i2 = 0; i1 < i4; i2 = i3)
      {
        MentionSpan localMentionSpan = arrayOfMentionSpan[i1];
        int i5 = paramEditable.getSpanEnd(localMentionSpan);
        i3 = i2;
        if (i5 > i2)
        {
          i3 = i2;
          if (i5 <= getSelectionEnd()) {
            i3 = paramEditable.getSpanEnd(localMentionSpan);
          }
        }
        i1 += 1;
      }
      i1 = a(paramEditable, i2);
    }
    if (i1 >= 0)
    {
      if (i1 != 0)
      {
        char c1 = paramEditable.charAt(i1 - 1);
        if ((!Character.isLetterOrDigit(c1)) && (c1 != '_')) {
          break label197;
        }
        i2 = 1;
        if (i2 != 0) {
          break label203;
        }
      }
      label197:
      label203:
      for (i2 = 1;; i2 = 0)
      {
        if (i2 == 0) {
          break label209;
        }
        a(paramEditable.toString().substring(i1 + 1, getSelectionEnd()));
        if (this.f) {
          b(paramEditable, i1);
        }
        return;
        i2 = 0;
        break;
      }
    }
    label209:
    a(this.b);
    a(null);
  }
  
  private void a(SpannableStringBuilder paramSpannableStringBuilder, Collection<String> paramCollection, boolean paramBoolean)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      String str3 = (String)paramCollection.next();
      String str1 = yr.a(this.q.d(str3));
      String str2 = yr.b(str3);
      int i1 = TextUtils.indexOf(paramSpannableStringBuilder, str2);
      if (i1 < 0) {
        Log.w("unable to set mention for " + str3 + " in " + paramSpannableStringBuilder);
      }
      while (i1 >= 0)
      {
        str3 = "@" + str1;
        paramSpannableStringBuilder.replace(i1, str2.length() + i1, str3);
        if (paramBoolean)
        {
          MentionAnnotationSpan localMentionAnnotationSpan = new MentionAnnotationSpan(this.h, true);
          paramSpannableStringBuilder.setSpan(localMentionAnnotationSpan, i1, i1 + 1, 33);
          paramSpannableStringBuilder.setSpan(new MentionSpan(this.i, str3, str2, localMentionAnnotationSpan), i1 + 1, i1 + 1 + str1.length(), 33);
        }
        i1 = TextUtils.indexOf(paramSpannableStringBuilder, str2, i1 + 1);
      }
    }
  }
  
  private void a(String paramString)
  {
    if (this.l == null) {}
    label308:
    do
    {
      return;
      if (paramString != null)
      {
        Object localObject1;
        Object localObject2;
        boolean bool1;
        boolean bool2;
        if (this.c == null)
        {
          localObject1 = LayoutInflater.from(getContext());
          this.c = ((MentionPickerView)al.a(this.p, (LayoutInflater)localObject1, 2130903297, this.l, false));
          this.l.addView(this.c);
          localObject1 = this.c;
          localObject2 = this.j;
          String str = ((Bundle)localObject2).getString("ARG_GID");
          bool1 = ((Bundle)localObject2).getBoolean("ARG_IS_DARK_THEME");
          bool2 = ((Bundle)localObject2).getBoolean("ARG_HIDE_END_DIVIDER");
          ((MentionPickerView)localObject1).b = str;
          ((MentionPickerView)localObject1).a = ((RecyclerView)((MentionPickerView)localObject1).findViewById(2131755943));
          ((MentionPickerView)localObject1).a.setLayoutManager(new LinearLayoutManager(((MentionPickerView)localObject1).getContext()));
          ((MentionPickerView)localObject1).setVisibility(8);
          if (bool1) {
            break label308;
          }
          ((MentionPickerView)localObject1).setBackgroundResource(2130840039);
        }
        for (;;)
        {
          ((MentionPickerView)localObject1).d = ((MentionPickerView)localObject1).g.c().t;
          ((MentionPickerView)localObject1).c = new yv(((MentionPickerView)localObject1).getContext(), ((MentionPickerView)localObject1).f, ((MentionPickerView)localObject1).g, ((MentionPickerView)localObject1).h, this, bool1, bool2);
          ((MentionPickerView)localObject1).a();
          localObject2 = new MentionPickerView.1((MentionPickerView)localObject1);
          ((MentionPickerView)localObject1).c.a((RecyclerView.c)localObject2);
          ((MentionPickerView)localObject1).a.setAdapter(((MentionPickerView)localObject1).c);
          if (this.a != null) {
            this.c.setAnchorWidthView(this.a);
          }
          this.c.setVisibilityChangeListener(this);
          localObject1 = this.c;
          if (!((MentionPickerView)localObject1).e) {
            break;
          }
          ((MentionPickerView)localObject1).c.getFilter().filter(paramString);
          return;
          ((MentionPickerView)localObject1).setBackgroundColor(b.c(((MentionPickerView)localObject1).getContext(), 2131624079));
        }
        new MentionPickerView.a((MentionPickerView)localObject1, ((MentionPickerView)localObject1).d, paramString, (byte)0).execute(new String[] { ((MentionPickerView)localObject1).b });
        return;
      }
    } while (this.c == null);
    this.c.c.getFilter().filter(null);
  }
  
  private void b(Editable paramEditable, int paramInt)
  {
    int i1 = paramInt + 1;
    if (((MentionAnnotationSpan[])paramEditable.getSpans(paramInt, i1, MentionAnnotationSpan.class)).length <= 0)
    {
      a(this.b);
      this.b = new MentionAnnotationSpan(this.h, false);
      paramEditable.setSpan(this.b, paramInt, i1, 33);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.e == paramBoolean) {
      return;
    }
    if (!this.e) {
      this.g = getInputType();
    }
    this.e = paramBoolean;
    if (paramBoolean) {}
    for (int i1 = 147457;; i1 = this.g)
    {
      setInputType(i1);
      i1 = getSelectionStart();
      int i2 = getSelectionEnd();
      if ((i1 == -1) || (i2 == -1)) {
        break;
      }
      setSelection(i1, i2);
      return;
    }
  }
  
  public final void a()
  {
    removeTextChangedListener(this.t);
    setText(null);
  }
  
  final void a(ForegroundColorSpan paramForegroundColorSpan)
  {
    if (paramForegroundColorSpan != null) {
      getText().removeSpan(paramForegroundColorSpan);
    }
  }
  
  public final void a(ViewGroup paramViewGroup, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.n = paramString;
    addTextChangedListener(this.t);
    this.i = b.c(getContext(), 2131624043);
    this.h = b.c(getContext(), 2131624076);
    a(getText());
    this.l = paramViewGroup;
    this.j = new Bundle();
    this.j.putString("ARG_GID", paramString);
    this.j.putBoolean("ARG_IS_DARK_THEME", paramBoolean1);
    this.j.putBoolean("ARG_HIDE_END_DIVIDER", paramBoolean2);
  }
  
  public final void a(cs paramcs)
  {
    Editable localEditable = getText();
    if (paramcs != null)
    {
      b(true);
      String str1 = yr.a(paramcs);
      int i2 = Math.min(a(localEditable, 0), getSelectionStart());
      int i1 = i2;
      if (i2 < 0) {
        i1 = getSelectionStart();
      }
      i2 = i1 + 1;
      String str2 = "@" + str1;
      a(this.b);
      this.b = null;
      localEditable.replace(i1, getSelectionEnd(), str2 + " ");
      MentionAnnotationSpan localMentionAnnotationSpan = new MentionAnnotationSpan(this.h, true);
      localEditable.setSpan(localMentionAnnotationSpan, i1, i2, 33);
      paramcs = new MentionSpan(this.i, str2, yr.b(paramcs.t), localMentionAnnotationSpan);
      localEditable.setSpan(paramcs, i2, str1.length() + i2, 33);
      setSelection(0);
      setSelection(localEditable.getSpanEnd(paramcs) + 1);
      a(null);
      b(false);
    }
  }
  
  public final void a(d paramd)
  {
    this.s.a(paramd);
  }
  
  public final void a(String paramString, Collection<String> paramCollection)
  {
    if ((paramCollection == null) || (paramCollection.isEmpty()))
    {
      setText(paramString);
      return;
    }
    setText(a(paramString, paramCollection, null));
  }
  
  public final void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    if (this.k != null) {
      this.k.a(paramBoolean);
    }
    if (paramBoolean)
    {
      int i1 = a(getEditableText(), 0);
      if (i1 >= 0)
      {
        b(getEditableText(), i1);
        return;
      }
    }
    a(this.b);
    this.b = null;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    this.s.a();
  }
  
  public boolean getIsMentionPickerVisible()
  {
    return this.f;
  }
  
  public ArrayList<String> getMentions()
  {
    int i1 = 0;
    HashSet localHashSet = new HashSet();
    MentionSpan[] arrayOfMentionSpan = (MentionSpan[])getText().getSpans(0, getText().length(), MentionSpan.class);
    int i2 = arrayOfMentionSpan.length;
    while (i1 < i2)
    {
      MentionSpan localMentionSpan = arrayOfMentionSpan[i1];
      localHashSet.add(localMentionSpan.b.substring(1, localMentionSpan.b.length()) + "@s.whatsapp.net");
      i1 += 1;
    }
    return new ArrayList(localHashSet);
  }
  
  public String getStringText()
  {
    return a(0, getText().length());
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    InputConnection localInputConnection2 = super.onCreateInputConnection(paramEditorInfo);
    InputConnection localInputConnection1 = localInputConnection2;
    if (Build.VERSION.SDK_INT >= 13)
    {
      localInputConnection1 = localInputConnection2;
      if (this.o != null)
      {
        localInputConnection1 = localInputConnection2;
        if (this.o.length > 0)
        {
          EditorInfoCompat.setContentMimeTypes(paramEditorInfo, this.o);
          Log.d("mentionable/entry/onCreateInputConnection: returning wrapper");
          localInputConnection1 = InputConnectionCompat.createWrapper(localInputConnection2, paramEditorInfo, yu.a(this));
        }
      }
    }
    return localInputConnection1;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (!TextUtils.isEmpty(SavedState.a(paramParcelable)))
    {
      int i1 = getSelectionStart();
      int i2 = getSelectionEnd();
      a(SavedState.b(paramParcelable), yr.a(SavedState.a(paramParcelable)));
      setSelection(i1, i2);
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    return new SavedState(super.onSaveInstanceState(), getStringText(), yr.a(getMentions()), (byte)0);
  }
  
  public void onSelectionChanged(int paramInt1, int paramInt2)
  {
    Editable localEditable = getEditableText();
    if (TextUtils.isEmpty(localEditable)) {
      return;
    }
    setSelection(a(paramInt1, localEditable), a(paramInt2, localEditable));
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    int i1 = getText().length();
    int i2;
    if (isFocused())
    {
      i1 = getSelectionStart();
      int i3 = getSelectionEnd();
      i2 = Math.max(0, Math.min(i1, i3));
      i1 = Math.max(0, Math.max(i1, i3));
    }
    for (;;)
    {
      if ((paramInt != 16908322) || (this.n == null))
      {
        if ((paramInt == 16908320) || (paramInt == 16908321))
        {
          localObject1 = getText().subSequence(i2, i1).toString();
          getContext().getSharedPreferences("com.whatsapp_preferences", 0).edit().putString("copied_message_without_mentions", a(i2, i1)).putString("copied_message", (String)localObject1).putString("copied_message_jids", yr.a(getMentions())).apply();
        }
        return super.onTextContextMenuItem(paramInt);
      }
      Object localObject1 = ((ClipboardManager)getContext().getSystemService("clipboard")).getText();
      Object localObject2 = getContext().getSharedPreferences("com.whatsapp_preferences", 0);
      Object localObject3 = ((SharedPreferences)localObject2).getString("copied_message", "");
      Object localObject4 = ((SharedPreferences)localObject2).getString("copied_message_jids", "");
      localObject2 = ((SharedPreferences)localObject2).getString("copied_message_without_mentions", "");
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!TextUtils.equals((CharSequence)localObject1, (CharSequence)localObject3)) || (TextUtils.isEmpty((CharSequence)localObject4)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
        return super.onTextContextMenuItem(paramInt);
      }
      localObject1 = yr.a((String)localObject4);
      localObject3 = new HashSet((Collection)localObject1);
      localObject1 = new HashSet((Collection)localObject1);
      if (this.n != null)
      {
        Object localObject5 = this.r.a(this.n).b();
        localObject4 = new HashSet();
        localObject5 = ((Collection)localObject5).iterator();
        while (((Iterator)localObject5).hasNext()) {
          ((HashSet)localObject4).add(((rf)((Iterator)localObject5).next()).a);
        }
        ((HashSet)localObject3).retainAll((Collection)localObject4);
        ((HashSet)localObject1).removeAll((Collection)localObject4);
      }
      for (;;)
      {
        localObject1 = a((String)localObject2, (Collection)localObject3, (Collection)localObject1);
        getText().replace(i2, i1, (CharSequence)localObject1);
        return true;
        localObject1 = null;
      }
      i2 = 0;
    }
  }
  
  public void setAcceptedMimeTypes(String[] paramArrayOfString)
  {
    this.o = paramArrayOfString;
  }
  
  public void setMentionChangeListener$798d3f85(AppBarLayout.b paramb)
  {
    this.m = paramb;
  }
  
  public void setMentionPickerVisibilityChangeListener(MentionPickerView.b paramb)
  {
    this.k = paramb;
  }
  
  public void setOnCommitContentListener(a parama)
  {
    this.d = parama;
  }
  
  public void setText(String paramString)
  {
    int i1 = 0;
    MentionSpan[] arrayOfMentionSpan = (MentionSpan[])getText().getSpans(0, getText().length(), MentionSpan.class);
    int i2 = arrayOfMentionSpan.length;
    while (i1 < i2)
    {
      MentionSpan localMentionSpan = arrayOfMentionSpan[i1];
      a(localMentionSpan.c);
      a(localMentionSpan);
      i1 += 1;
    }
    a(this.b);
    this.b = null;
    super.setText(paramString);
  }
  
  public static final class MentionAnnotationSpan
    extends ForegroundColorSpan
  {
    final boolean a;
    
    public MentionAnnotationSpan(int paramInt, boolean paramBoolean)
    {
      super();
      this.a = paramBoolean;
    }
  }
  
  public static final class MentionSpan
    extends ForegroundColorSpan
  {
    public final String a;
    public final String b;
    public final MentionableEntry.MentionAnnotationSpan c;
    
    public MentionSpan(int paramInt, String paramString1, String paramString2, MentionableEntry.MentionAnnotationSpan paramMentionAnnotationSpan)
    {
      super();
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramMentionAnnotationSpan;
    }
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
    private final String a;
    private final String b;
    
    private SavedState(Parcel paramParcel)
    {
      super();
      this.a = paramParcel.readString();
      this.b = paramParcel.readString();
    }
    
    private SavedState(Parcelable paramParcelable, String paramString1, String paramString2)
    {
      super();
      if (!TextUtils.isEmpty(paramString2))
      {
        this.a = paramString1;
        this.b = paramString2;
        return;
      }
      this.a = null;
      this.b = null;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.a);
      paramParcel.writeString(this.b);
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean a(InputContentInfoCompat paramInputContentInfoCompat, int paramInt);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/MentionableEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */