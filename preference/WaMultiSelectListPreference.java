package com.whatsapp.preference;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class WaMultiSelectListPreference
  extends WaListPreference
{
  public String a;
  public String b;
  private String c = "OV=I=XseparatorX=I=VO";
  private boolean[] d = new boolean[getEntries().length];
  
  public WaMultiSelectListPreference(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WaMultiSelectListPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private CharSequence a(List<CharSequence> paramList)
  {
    if ((paramList.isEmpty()) && (!TextUtils.isEmpty(this.a))) {
      return this.a;
    }
    ArrayList localArrayList = new ArrayList();
    CharSequence[] arrayOfCharSequence1 = getEntries();
    CharSequence[] arrayOfCharSequence2 = getEntryValues();
    if ((paramList.size() == arrayOfCharSequence2.length) && (!TextUtils.isEmpty(this.b))) {
      return this.b;
    }
    int k = arrayOfCharSequence2.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      if (paramList.contains(arrayOfCharSequence2[i])) {
        localArrayList.add((String)arrayOfCharSequence1[j]);
      }
      j += 1;
      i += 1;
    }
    return a(localArrayList, ", ");
  }
  
  private static String a(Iterable<?> paramIterable, String paramString)
  {
    if (paramIterable != null)
    {
      paramIterable = paramIterable.iterator();
      if (paramIterable.hasNext()) {}
    }
    else
    {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramIterable.next()));
    while (paramIterable.hasNext()) {
      localStringBuilder.append(paramString).append(paramIterable.next());
    }
    return localStringBuilder.toString();
  }
  
  private void a()
  {
    CharSequence[] arrayOfCharSequence = getEntryValues();
    Object localObject = a(getValue());
    if (localObject != null)
    {
      localObject = Arrays.asList((Object[])localObject);
      int i = 0;
      while (i < arrayOfCharSequence.length)
      {
        CharSequence localCharSequence = arrayOfCharSequence[i];
        this.d[i] = ((List)localObject).contains(localCharSequence);
        i += 1;
      }
    }
  }
  
  private void a(String paramString)
  {
    if (callChangeListener(a(paramString))) {
      setValue(paramString);
    }
  }
  
  private CharSequence[] a(CharSequence paramCharSequence)
  {
    if ((paramCharSequence == null) || ("".equals(paramCharSequence))) {
      return new CharSequence[0];
    }
    return ((String)paramCharSequence).split(this.c);
  }
  
  public final void a(CharSequence[] paramArrayOfCharSequence)
  {
    onSetInitialValue(false, paramArrayOfCharSequence);
  }
  
  protected void onDialogClosed(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = getEntryValues();
    if ((paramBoolean) && (localObject != null))
    {
      int i = 0;
      while (i < localObject.length)
      {
        if (this.d[i] == 1) {
          localArrayList.add((String)localObject[i]);
        }
        i += 1;
      }
      localObject = a(localArrayList, this.c);
      setSummary(a(localArrayList));
      a((String)localObject);
    }
  }
  
  protected Object onGetDefaultValue(TypedArray paramTypedArray, int paramInt)
  {
    return paramTypedArray.getTextArray(paramInt);
  }
  
  protected void onPrepareDialogBuilder(AlertDialog.Builder paramBuilder)
  {
    CharSequence[] arrayOfCharSequence = getEntries();
    Object localObject = getEntryValues();
    if ((arrayOfCharSequence == null) || (localObject == null) || (arrayOfCharSequence.length != localObject.length)) {
      throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array which are both the same length");
    }
    a();
    localObject = new DialogInterface.OnMultiChoiceClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        WaMultiSelectListPreference.a(WaMultiSelectListPreference.this)[paramAnonymousInt] = paramAnonymousBoolean;
      }
    };
    paramBuilder.setMultiChoiceItems(arrayOfCharSequence, this.d, (DialogInterface.OnMultiChoiceClickListener)localObject);
  }
  
  protected void onSetInitialValue(boolean paramBoolean, Object paramObject)
  {
    if (paramObject == null) {}
    for (paramObject = new CharSequence[0];; paramObject = (CharSequence[])paramObject)
    {
      String str = a(Arrays.asList((Object[])paramObject), this.c);
      paramObject = str;
      if (paramBoolean) {
        paramObject = getPersistedString(str);
      }
      setSummary(a(Arrays.asList(a((CharSequence)paramObject))));
      a((String)paramObject);
      return;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/preference/WaMultiSelectListPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */