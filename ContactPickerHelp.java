package com.whatsapp;

import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.a;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.whatsapp.contact.sync.n;
import com.whatsapp.contact.sync.v;
import com.whatsapp.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ContactPickerHelp
  extends nm
{
  TextView n;
  CheckBox o;
  b p;
  List<n> q;
  boolean r;
  final atv s = atv.a();
  private final pv t = pv.a();
  private final and u = and.a();
  
  public final void c(int paramInt)
  {
    if (paramInt == 2131296540) {
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Log.i("contacthelp/create");
    super.onCreate(paramBundle);
    i().a(true);
    setContentView(2130903120);
    ((Button)findViewById(2131755501)).setOnClickListener(eg.a(this));
    this.n = ((TextView)findViewById(2131755506));
    this.q = new ArrayList();
    this.p = new b(this, this.t, this.q);
    W().setAdapter(this.p);
    this.n.setVisibility(4);
    W().setVisibility(8);
    this.o = ((CheckBox)findViewById(2131755504));
    this.o.setChecked(this.s.b());
    this.o.setOnCheckedChangeListener(eh.a(this));
    findViewById(2131755503).setOnClickListener(ei.a(this));
    ((ScrollView)findViewById(2131755321)).post(ej.a(this));
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return false;
    }
    finish();
    return true;
  }
  
  final class a
    extends AsyncTask<Void, Void, Set<n>>
  {
    private a() {}
    
    protected final void onPreExecute()
    {
      ContactPickerHelp.this.g(2131297551);
      ContactPickerHelp.this.n.setVisibility(4);
      ContactPickerHelp.this.W().setVisibility(4);
      ContactPickerHelp.this.findViewById(2131755503).setVisibility(8);
      ContactPickerHelp.this.findViewById(2131755502).setVisibility(8);
      ContactPickerHelp.this.findViewById(2131755505).setVisibility(8);
    }
  }
  
  static final class b
    extends ArrayAdapter<n>
  {
    private final LayoutInflater a;
    private final List<n> b;
    private final pv c;
    
    public b(Context paramContext, pv parampv, List<n> paramList)
    {
      super(2130903121, paramList);
      this.a = LayoutInflater.from(paramContext);
      this.b = paramList;
      this.c = parampv;
    }
    
    public final boolean areAllItemsEnabled()
    {
      return false;
    }
    
    public final int getCount()
    {
      return Math.max(1, super.getCount());
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (this.b.isEmpty())
      {
        paramView = al.a(this.c, this.a, 2130903306, paramViewGroup, false);
        ((TextView)paramView.findViewById(2131755969)).setText(2131296546);
        paramView.setTag(Integer.valueOf(2));
        paramView.setClickable(false);
        return paramView;
      }
      View localView;
      if (paramView != null)
      {
        localView = paramView;
        if (((Integer)paramView.getTag()).intValue() == 1) {}
      }
      else
      {
        localView = al.a(this.c, this.a, 2130903121, paramViewGroup, false);
      }
      paramView = (TextView)localView.findViewById(2131755507);
      paramViewGroup = (TextView)localView.findViewById(2131755508);
      n localn = (n)getItem(paramInt);
      paramView.setText(localn.b);
      paramViewGroup.setText(localn.c);
      localView.setTag(Integer.valueOf(2));
      paramView = getContext().getResources();
      if (paramInt % 2 == 0) {}
      for (paramInt = 2131624107;; paramInt = 2131624108)
      {
        localView.setBackgroundColor(paramView.getColor(paramInt));
        return localView;
      }
    }
    
    public final int getViewTypeCount()
    {
      return 2;
    }
    
    public final boolean isEnabled(int paramInt)
    {
      return false;
    }
  }
  
  final class c
    extends AsyncTask<Void, Void, v>
  {
    private c() {}
    
    protected final void onPreExecute()
    {
      ContactPickerHelp.this.g(2131297592);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ContactPickerHelp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */