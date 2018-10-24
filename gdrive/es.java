package com.whatsapp.gdrive;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.m;
import android.support.v7.app.b.a;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class es
  extends m
{
  a aa;
  final AtomicBoolean ab = new AtomicBoolean(false);
  
  public final void a(Activity paramActivity)
  {
    super.a(paramActivity);
    try
    {
      this.aa = ((a)paramActivity);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new ClassCastException(paramActivity.toString() + " must implement SingleChoiceListListener");
    }
  }
  
  public final Dialog c(Bundle paramBundle)
  {
    paramBundle = i();
    if (!paramBundle.containsKey("dialog_id")) {
      throw new IllegalStateException("dialog_id should be provided.");
    }
    int j = paramBundle.getInt("dialog_id");
    this.ab.set(false);
    b.a locala = new b.a(l()).a(paramBundle.getString("title")).a(2131296398, null);
    if ((paramBundle.containsKey("items")) && (paramBundle.containsKey("multi_line_list_items_key"))) {
      throw new IllegalStateException("Cannot provide both items and multi_line_list_items_key");
    }
    if ((!paramBundle.containsKey("items")) && (!paramBundle.containsKey("multi_line_list_items_key"))) {
      throw new IllegalStateException("Must provide either items or multi_line_list_items_key");
    }
    final int k = paramBundle.getInt("selected_item_index", -1);
    if (paramBundle.containsKey("items")) {
      locala.a(paramBundle.getStringArray("items"), k, et.a(this, j, paramBundle));
    }
    for (;;)
    {
      return locala.a();
      if (paramBundle.containsKey("multi_line_list_items_key"))
      {
        ArrayList localArrayList = new ArrayList();
        final String[] arrayOfString1 = paramBundle.getStringArray("multi_line_list_items_key");
        if (arrayOfString1 == null) {
          throw new IllegalArgumentException("Must provide multi_line_list_items_key");
        }
        String[] arrayOfString2 = paramBundle.getStringArray("multi_line_list_item_values_key");
        final boolean[] arrayOfBoolean = paramBundle.getBooleanArray("list_item_enabled_key");
        String str = paramBundle.getString("disabled_item_toast_key");
        if ((arrayOfString2 != null) && (arrayOfString1.length != arrayOfString2.length)) {
          throw new IllegalArgumentException("keys.length = " + arrayOfString1.length + " ≠ " + arrayOfString2.length + " values.length");
        }
        int i = 0;
        if (i < arrayOfString1.length)
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("line1", arrayOfString1[i]);
          if (arrayOfString2 != null) {}
          for (paramBundle = arrayOfString2[i];; paramBundle = null)
          {
            localHashMap.put("line2", paramBundle);
            localArrayList.add(localHashMap);
            i += 1;
            break;
          }
        }
        locala.a(new SimpleAdapter(k(), localArrayList, new String[] { "line1", "line2" }, new int[] { 16908308, 16908309 }, arrayOfBoolean)
        {
          public final View getView(int paramAnonymousInt, View paramAnonymousView, ViewGroup paramAnonymousViewGroup)
          {
            paramAnonymousView = super.getView(paramAnonymousInt, paramAnonymousView, paramAnonymousViewGroup);
            paramAnonymousViewGroup = (TextView)paramAnonymousView.findViewById(16908308);
            TextView localTextView = (TextView)paramAnonymousView.findViewById(16908309);
            if (es.this.o())
            {
              if ((arrayOfBoolean != null) && (arrayOfBoolean[paramAnonymousInt] == 0))
              {
                paramAnonymousViewGroup.setTextColor(es.this.m().getColor(2131624042));
                localTextView.setTextColor(es.this.m().getColor(2131624042));
              }
            }
            else
            {
              if (!TextUtils.isEmpty(localTextView.getText())) {
                break label183;
              }
              localTextView.setVisibility(8);
            }
            for (;;)
            {
              if ((k < 0) || (!TextUtils.equals(arrayOfString1[k], paramAnonymousViewGroup.getText()))) {
                break label192;
              }
              ((RadioButton)paramAnonymousView.findViewById(2131755196)).setChecked(true);
              return paramAnonymousView;
              paramAnonymousViewGroup.setTextColor(es.this.m().getColor(2131623964));
              localTextView.setTextColor(es.this.m().getColor(2131623964));
              break;
              label183:
              localTextView.setVisibility(0);
            }
            label192:
            ((RadioButton)paramAnonymousView.findViewById(2131755196)).setChecked(false);
            return paramAnonymousView;
          }
        }, k, eu.a(this, arrayOfBoolean, j, arrayOfString1, str));
      }
    }
  }
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
    paramDialogInterface = i();
    if ((this.aa != null) && (!this.ab.get()) && (paramDialogInterface.containsKey("dialog_id"))) {
      this.aa.j(paramDialogInterface.getInt("dialog_id"));
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String[] paramArrayOfString);
    
    public abstract void j(int paramInt);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gdrive/es.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */