package com.whatsapp;

import a.a.a.a.a.a.d;
import a.a.a.a.d;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.b;
import android.support.v7.app.b.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import b.a.a.c;
import com.whatsapp.data.cs;
import com.whatsapp.g.j;
import com.whatsapp.location.bp;
import com.whatsapp.location.bp.c;
import com.whatsapp.util.at;
import com.whatsapp.util.l;
import java.util.ArrayList;
import java.util.List;

public class LiveLocationPrivacyActivity
  extends nh
{
  a n;
  final bp o = bp.a();
  private TextView p;
  private TextView q;
  private final di r = di.a();
  private final List<cs> s = new ArrayList();
  private final bp.c t = new bp.c()
  {
    public final void a(String paramAnonymousString)
    {
      LiveLocationPrivacyActivity.a(LiveLocationPrivacyActivity.this);
    }
    
    public final void b(String paramAnonymousString)
    {
      LiveLocationPrivacyActivity.a(LiveLocationPrivacyActivity.this);
    }
  };
  private di.e u;
  private View v;
  
  private void l()
  {
    this.s.clear();
    this.s.addAll(this.o.l());
    this.n.notifyDataSetChanged();
    if (this.s.isEmpty())
    {
      this.p.setVisibility(8);
      this.q.setVisibility(0);
      this.v.setVisibility(8);
      return;
    }
    this.p.setText(u.a.a(2131230757, this.s.size(), new Object[] { Integer.valueOf(this.s.size()) }));
    this.p.setVisibility(0);
    this.q.setVisibility(8);
    this.v.setVisibility(0);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903269);
    paramBundle = (android.support.v7.app.a)a.d.a(i());
    paramBundle.a(true);
    paramBundle.a(2131297805);
    this.u = this.r.b();
    this.n = new a((byte)0);
    paramBundle = (ListView)findViewById(2131755868);
    paramBundle.setAdapter(this.n);
    View localView = getLayoutInflater().inflate(2130903271, null, false);
    this.p = ((TextView)localView.findViewById(2131755177));
    paramBundle.addHeaderView(localView);
    paramBundle.setOnItemClickListener(um.a(this));
    localView = getLayoutInflater().inflate(2130903270, null, false);
    paramBundle.addFooterView(localView);
    this.q = ((TextView)localView.findViewById(2131755869));
    this.v = localView.findViewById(2131755627);
    this.v.setOnClickListener(new at()
    {
      public final void a(View paramAnonymousView)
      {
        d.a(LiveLocationPrivacyActivity.this, 0);
      }
    });
    l();
    this.o.a(this.t);
  }
  
  public Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    }
    b localb = new b.a(this).b(2131297111).a(true).b(2131296398, null).a(2131297109, un.a(this)).a();
    localb.requestWindowFeature(1);
    return localb;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.o.b(this.t);
  }
  
  final class a
    extends BaseAdapter
  {
    private a() {}
    
    public final cs a(int paramInt)
    {
      return (cs)LiveLocationPrivacyActivity.b(LiveLocationPrivacyActivity.this).get(paramInt);
    }
    
    public final int getCount()
    {
      return LiveLocationPrivacyActivity.b(LiveLocationPrivacyActivity.this).size();
    }
    
    public final long getItemId(int paramInt)
    {
      return ((cs)LiveLocationPrivacyActivity.b(LiveLocationPrivacyActivity.this).get(paramInt)).c;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = al.a(LiveLocationPrivacyActivity.this.aq, LiveLocationPrivacyActivity.this.getLayoutInflater(), 2130903272, paramViewGroup, false);
        paramViewGroup = new LiveLocationPrivacyActivity.b((byte)0);
        paramViewGroup.c = ((TextEmojiLabel)paramView.findViewById(2131755507));
        paramViewGroup.d = ((TextView)paramView.findViewById(2131755870));
        paramViewGroup.b = ((ImageView)paramView.findViewById(2131755801));
        paramViewGroup.e = paramView.findViewById(2131755385);
        paramView.setTag(paramViewGroup);
        paramView.setBackgroundResource(2130840501);
        if (paramInt != getCount() - 1) {
          break label139;
        }
        paramViewGroup.e.setVisibility(8);
      }
      cs localcs;
      for (;;)
      {
        localcs = a(paramInt);
        if (localcs != null) {
          break label150;
        }
        return paramView;
        paramViewGroup = (LiveLocationPrivacyActivity.b)paramView.getTag();
        break;
        label139:
        paramViewGroup.e.setVisibility(0);
      }
      label150:
      long l1 = ((j)c.a().a(j.class)).a();
      long l2 = LiveLocationPrivacyActivity.c(LiveLocationPrivacyActivity.this).e(localcs.t);
      paramViewGroup.a = localcs;
      String str = l.f(LiveLocationPrivacyActivity.this, l2 - l1);
      paramViewGroup.d.setText(str);
      paramViewGroup.c.setText(localcs.a(LiveLocationPrivacyActivity.this));
      LiveLocationPrivacyActivity.d(LiveLocationPrivacyActivity.this).a(paramViewGroup.a, paramViewGroup.b);
      return paramView;
    }
    
    public final boolean hasStableIds()
    {
      return true;
    }
  }
  
  static final class b
  {
    cs a;
    ImageView b;
    TextEmojiLabel c;
    TextView d;
    View e;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/LiveLocationPrivacyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */