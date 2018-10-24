package com.whatsapp;

import a.a.a.a.a.a.d;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.content.b;
import android.support.v4.view.ab;
import android.support.v4.view.o;
import android.support.v7.app.a;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import b.a.a.c;
import com.whatsapp.data.cs;
import com.whatsapp.util.bh;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BlockList
  extends nm
{
  private ArrayList<cs> n = new ArrayList();
  private a o;
  private final com.whatsapp.data.e p = com.whatsapp.data.e.a();
  private final aq q = aq.a();
  private final di.e r = di.a().b();
  private final dh s = dh.a();
  private final dh.a t = new dh.a()
  {
    public final void a()
    {
      BlockList.a(BlockList.this);
    }
    
    protected final void a(String paramAnonymousString)
    {
      BlockList.a(BlockList.this);
    }
    
    public final void a(Collection<String> paramAnonymousCollection)
    {
      BlockList.a(BlockList.this);
    }
    
    public final void b(String paramAnonymousString)
    {
      BlockList.a(BlockList.this);
    }
    
    public final void c(String paramAnonymousString)
    {
      BlockList.a(BlockList.this);
    }
  };
  
  private void l()
  {
    TextView localTextView = (TextView)findViewById(2131755359);
    if (this.q.d())
    {
      localTextView.setText(bh.a(getResources().getString(2131296352), b.a(this, 2130840088), localTextView.getPaint()));
      return;
    }
    if (aat.a(getBaseContext())) {}
    for (int i = 2131297244;; i = 2131297243)
    {
      localTextView.setText(i);
      return;
    }
  }
  
  private void m()
  {
    this.n.clear();
    Iterator localIterator = this.q.e().keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.n.add(this.p.d(str));
    }
    Collections.sort(this.n, new ch(getApplicationContext()));
  }
  
  private void n()
  {
    m();
    this.o.notifyDataSetChanged();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 10)) {
      this.q.a(this, true, paramIntent.getStringExtra("contact"));
    }
  }
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    Object localObject = (AdapterView.AdapterContextMenuInfo)paramMenuItem.getMenuInfo();
    localObject = (cs)W().getItemAtPosition(((AdapterView.AdapterContextMenuInfo)localObject).position);
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onContextItemSelected(paramMenuItem);
    }
    this.q.a(this, false, ((cs)localObject).t);
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ((a)a.d.a(i())).a(true);
    setContentView(2130903089);
    m();
    l();
    this.o = new a(this, this.n);
    a(this.o);
    W().setEmptyView(findViewById(2131755358));
    registerForContextMenu(W());
    W().setOnItemClickListener(ao.a(this));
    this.s.registerObserver(this.t);
    c.a().a(this, false);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    Object localObject = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    localObject = (cs)W().getItemAtPosition(((AdapterView.AdapterContextMenuInfo)localObject).position);
    paramContextMenu.add(0, 0, 0, String.format(getString(2131296354), new Object[] { ((cs)localObject).a(this) }));
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    o.a(paramMenu.add(0, 0, 0, 2131297140).setIcon(2130840046), 2);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.r.a();
    this.s.unregisterObserver(this.t);
    c.a().a(this);
  }
  
  public void onEvent(com.whatsapp.g.e parame)
  {
    n();
    l();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return true;
    case 0: 
      paramMenuItem = new Intent(this, ContactPicker.class);
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.n.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(((cs)localIterator.next()).t).append(",");
      }
      paramMenuItem.putExtra("block_contact", true);
      paramMenuItem.putExtra("blocked_list", localStringBuilder.toString());
      startActivityForResult(paramMenuItem, 10);
      return true;
    }
    finish();
    return true;
  }
  
  final class a
    extends ArrayAdapter<cs>
  {
    a(int paramInt)
    {
      super(2130903124, localList);
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      cs localcs = (cs)getItem(paramInt);
      if (paramView == null)
      {
        paramView = al.a(BlockList.this.aq, BlockList.this.getLayoutInflater(), 2130903124, paramViewGroup, false);
        paramView.findViewById(2131755518).setVisibility(8);
        paramViewGroup = new BlockList.b(paramView);
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        di.e locale = BlockList.b(BlockList.this);
        ab.a(paramViewGroup.a, localcs.t);
        paramViewGroup.a.setOnClickListener(ap.a(paramViewGroup, localcs));
        locale.a(localcs, paramViewGroup.a);
        paramViewGroup.b.setContact(localcs);
        paramViewGroup.c.setText("‪" + cs.b(localcs.t) + "‬");
        return paramView;
        paramViewGroup = (BlockList.b)paramView.getTag();
      }
    }
  }
  
  static final class b
  {
    final ImageView a;
    final TextEmojiLabel b;
    final TextEmojiLabel c;
    
    b(View paramView)
    {
      this.a = ((ImageView)paramView.findViewById(2131755511));
      this.b = ((TextEmojiLabel)paramView.findViewById(2131755517));
      aoa.b(this.b);
      this.c = ((TextEmojiLabel)paramView.findViewById(2131755519));
      aoa.a(this.c);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/BlockList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */