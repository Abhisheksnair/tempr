package com.whatsapp.preference;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.whatsapp.aus;
import com.whatsapp.jr;

public class WaFontListPreference
  extends WaListPreference
{
  public static int a = 0;
  int b;
  private final aus c = aus.a();
  
  public WaFontListPreference(Context paramContext)
  {
    super(paramContext);
  }
  
  public WaFontListPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onDialogClosed(boolean paramBoolean)
  {
    super.onDialogClosed(paramBoolean);
    Object localObject = getEntryValues();
    if ((paramBoolean) && (this.b >= 0) && (localObject != null))
    {
      localObject = localObject[this.b].toString();
      if (callChangeListener(localObject)) {
        setValue((String)localObject);
      }
    }
  }
  
  protected void onPrepareDialogBuilder(AlertDialog.Builder paramBuilder)
  {
    super.onPrepareDialogBuilder(paramBuilder);
    BaseAdapter local1 = new BaseAdapter()
    {
      public final int getCount()
      {
        return this.a.length;
      }
      
      public final Object getItem(int paramAnonymousInt)
      {
        return this.b[paramAnonymousInt];
      }
      
      public final long getItemId(int paramAnonymousInt)
      {
        return paramAnonymousInt;
      }
      
      public final View getView(int paramAnonymousInt, View paramAnonymousView, ViewGroup paramAnonymousViewGroup)
      {
        int j = 0;
        paramAnonymousView = LayoutInflater.from(WaFontListPreference.this.getContext()).inflate(17367043, null, false);
        paramAnonymousViewGroup = (TextView)paramAnonymousView.findViewById(16908308);
        int i = j;
        switch (paramAnonymousInt)
        {
        default: 
          i = j;
        }
        for (;;)
        {
          paramAnonymousViewGroup.setTextSize(jr.a(WaFontListPreference.this.getContext().getResources(), WaFontListPreference.a(WaFontListPreference.this), i));
          paramAnonymousViewGroup.setText(this.a[paramAnonymousInt]);
          return paramAnonymousView;
          i = -1;
          continue;
          i = 1;
        }
      }
    };
    this.b = findIndexOfValue(getValue());
    paramBuilder.setSingleChoiceItems(local1, this.b, new a(this));
    paramBuilder.setPositiveButton(null, null);
  }
  
  public boolean persistString(String paramString)
  {
    a = Integer.parseInt(paramString);
    return super.persistString(paramString);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/preference/WaFontListPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */