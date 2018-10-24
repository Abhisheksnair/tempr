package com.whatsapp;

import a.a.a.a.a.a.d;
import a.a.a.a.d;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.a;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.whatsapp.fieldstats.events.p;
import com.whatsapp.util.Log;
import com.whatsapp.util.bu;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class SearchFAQ
  extends nm
{
  HashSet<String> n;
  int o;
  private String p;
  private String q;
  private String r;
  private ArrayList<Uri> s;
  private HashMap<Long, Long> t;
  private final od u = od.a();
  private final cc v = cc.a();
  private final vv w = vv.a();
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, ArrayList<Uri> paramArrayList, String paramString3, int paramInt, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<String> paramArrayList3)
  {
    paramContext = new Intent(paramContext, SearchFAQ.class);
    paramContext.putExtra("com.whatsapp.SearchFAQ.from", paramString1);
    paramContext.putExtra("com.whatsapp.SearchFAQ.problem", paramString2);
    paramContext.putExtra("com.whatsapp.SearchFAQ.status", paramString3);
    paramContext.putExtra("com.whatsapp.SearchFAQ.count", paramInt);
    paramContext.putStringArrayListExtra("com.whatsapp.SearchFAQ.titles", paramArrayList1);
    paramContext.putStringArrayListExtra("com.whatsapp.SearchFAQ.descriptions", paramArrayList2);
    paramContext.putStringArrayListExtra("com.whatsapp.SearchFAQ.urls", paramArrayList3);
    paramContext.putParcelableArrayListExtra("android.intent.extra.STREAM", paramArrayList);
    return paramContext;
  }
  
  private void a(b paramb)
  {
    this.n.add(paramb.c);
    Intent localIntent = new Intent(this, FaqItemActivity.class);
    localIntent.putExtra("title", paramb.a);
    localIntent.putExtra("content", paramb.b);
    localIntent.putExtra("url", paramb.c);
    localIntent.putExtra("article_id", Long.parseLong(paramb.c.substring(paramb.c.lastIndexOf('/') + 1)));
    startActivityForResult(localIntent, 1);
    overridePendingTransition(2130968602, 2130968603);
  }
  
  private void d(int paramInt)
  {
    p localp = new p();
    localp.a = Integer.valueOf(paramInt);
    localp.g = this.q;
    if (this.t.size() > 0)
    {
      ArrayList localArrayList = new ArrayList(this.t.entrySet());
      Collections.sort(localArrayList, ahm.a());
      Collections.reverse(localArrayList);
      localp.h = ((Long)((Map.Entry)localArrayList.get(0)).getKey());
      localp.o = Double.valueOf(((Long)((Map.Entry)localArrayList.get(0)).getValue()).longValue());
      if (localArrayList.size() > 1)
      {
        localp.i = ((Long)((Map.Entry)localArrayList.get(1)).getKey());
        localp.p = Double.valueOf(((Long)((Map.Entry)localArrayList.get(1)).getValue()).longValue());
        if (localArrayList.size() > 2)
        {
          localp.j = ((Long)((Map.Entry)localArrayList.get(2)).getKey());
          localp.q = Double.valueOf(((Long)((Map.Entry)localArrayList.get(2)).getValue()).longValue());
        }
      }
    }
    localp.r = Double.valueOf(m());
    localp.m = Double.valueOf(this.o);
    localp.n = Double.valueOf(this.n.size());
    bu.a(ahn.a(this, localp));
  }
  
  private long m()
  {
    Iterator localIterator = this.t.values().iterator();
    for (long l = 0L; localIterator.hasNext(); l = ((Long)localIterator.next()).longValue() + l) {}
    return l;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    long l1;
    long l2;
    if (paramInt1 == 1)
    {
      if (paramInt2 != -1) {
        break label167;
      }
      l1 = paramIntent.getLongExtra("total_time_spent", 0L);
      l2 = paramIntent.getLongExtra("article_id", -1L);
      if (!this.t.containsKey(Long.valueOf(l2))) {
        break label164;
      }
      l1 = ((Long)this.t.get(Long.valueOf(l2))).longValue() + l1;
    }
    label164:
    for (;;)
    {
      this.t.put(Long.valueOf(l2), Long.valueOf(l1));
      Log.d("search-faq/activity-result total time spent on last article opened is " + l1);
      Log.d("search-faq/activity-result total time spent per article is " + TextUtils.join(", ", this.t.entrySet()));
      Log.d("search-faq/activity-result total time spend on all articles is " + m());
      return;
    }
    label167:
    Log.d("search-faq/activity-result/result/" + paramInt2);
  }
  
  public void onBackPressed()
  {
    d(2);
    super.onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    i().a(true);
    setContentView(2130903348);
    this.n = new HashSet();
    if (paramBundle != null)
    {
      localObject1 = paramBundle.getStringArray("FaqItemsReadTitles");
      if (localObject1 != null) {
        Collections.addAll(this.n, (Object[])localObject1);
      }
      if (paramBundle.containsKey("timeSpentPerArticle")) {
        this.t = ((HashMap)paramBundle.getSerializable("timeSpentPerArticle"));
      }
    }
    paramBundle = getIntent();
    this.p = paramBundle.getStringExtra("com.whatsapp.SearchFAQ.from");
    this.q = paramBundle.getStringExtra("com.whatsapp.SearchFAQ.problem");
    this.r = paramBundle.getStringExtra("com.whatsapp.SearchFAQ.status");
    this.s = paramBundle.getParcelableArrayListExtra("android.intent.extra.STREAM");
    if (this.t == null) {
      this.t = new HashMap();
    }
    ((Button)findViewById(2131756066)).setOnClickListener(ahl.a(this));
    Object localObject1 = paramBundle.getStringArrayListExtra("com.whatsapp.SearchFAQ.titles");
    Object localObject2 = paramBundle.getStringArrayListExtra("com.whatsapp.SearchFAQ.descriptions");
    Object localObject3 = paramBundle.getStringArrayListExtra("com.whatsapp.SearchFAQ.urls");
    int j = paramBundle.getIntExtra("com.whatsapp.SearchFAQ.count", 0);
    this.o = j;
    paramBundle = new ArrayList();
    int i = 0;
    while (i < j)
    {
      Log.d("search-faq/result item=" + i + " title=" + (String)((ArrayList)localObject1).get(i) + " url=" + (String)((ArrayList)localObject3).get(i));
      paramBundle.add(new b((String)((ArrayList)localObject1).get(i), (String)((ArrayList)localObject2).get(i), (String)((ArrayList)localObject3).get(i)));
      i += 1;
    }
    localObject1 = new c(this, paramBundle);
    localObject2 = W();
    localObject3 = (LayoutInflater)getSystemService("layout_inflater");
    ((ListView)localObject2).addHeaderView(al.a(this.aq, (LayoutInflater)localObject3, 2130903349));
    a((ListAdapter)localObject1);
    registerForContextMenu((View)localObject2);
    if (paramBundle.size() == 1) {
      a((b)paramBundle.get(0));
    }
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    }
    ProgressDialog localProgressDialog = new ProgressDialog(this);
    localProgressDialog.setMessage(getString(2131297551));
    localProgressDialog.setIndeterminate(true);
    localProgressDialog.setCancelable(false);
    return localProgressDialog;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332) {
      d(2);
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      if ((this.n != null) && (this.n.size() > 0)) {
        paramBundle.putStringArray("FaqItemsReadTitles", (String[])this.n.toArray(new String[this.n.size()]));
      }
      if ((this.t != null) && (this.t.size() > 0)) {
        paramBundle.putSerializable("timeSpentPerArticle", this.t);
      }
    }
    super.onSaveInstanceState(paramBundle);
  }
  
  public final class a
    extends AsyncTask<Void, Void, Pair<String, File>>
  {
    private long b;
    private long c;
    private String d;
    private final vv.a e = new vv.a()
    {
      public final void a()
      {
        throw new IllegalStateException("must not be called");
      }
      
      public final void b()
      {
        SearchFAQ.a.a(SearchFAQ.a.this);
        Log.i("describeproblemactivity/externalstorage/avail external storage not calculated, state=" + SearchFAQ.a.b(SearchFAQ.a.this));
      }
      
      public final void c()
      {
        SearchFAQ.a.a(SearchFAQ.a.this);
        Log.i("describeproblemactivity/externalstorage/avail external storage not calculated, permission denied");
      }
      
      public final void d()
      {
        throw new IllegalStateException("must not be called");
      }
    };
    
    protected a() {}
    
    protected final void onPreExecute()
    {
      d.a(SearchFAQ.this, 1);
      SharedPreferences localSharedPreferences = SearchFAQ.this.getSharedPreferences("com.whatsapp_preferences", 0);
      Log.i("descprob/priv/last=" + SettingsPrivacy.a(localSharedPreferences.getInt("privacy_last_seen", 0)));
      Log.i("descprob/priv/pic=" + SettingsPrivacy.a(localSharedPreferences.getInt("privacy_profile_photo", 0)));
      Log.i("descprob/priv/status=" + SettingsPrivacy.a(localSharedPreferences.getInt("privacy_status", 0)));
      Log.i("descprob/priv/readreceipts=" + localSharedPreferences.getBoolean("read_receipts_enabled", true));
      SearchFAQ.a(SearchFAQ.this).g("descprob");
    }
  }
  
  final class b
  {
    public String a;
    public String b;
    public String c;
    
    public b(String paramString1, String paramString2, String paramString3)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramString3;
    }
  }
  
  final class c
    extends ArrayAdapter<SearchFAQ.b>
  {
    public c(int paramInt)
    {
      super(2130903350, localList);
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = new LinearLayout(getContext());
        paramViewGroup = (LayoutInflater)getContext().getSystemService("layout_inflater");
        al.a(SearchFAQ.this.aq, paramViewGroup, 2130903350, paramView, true);
        if (paramInt % 2 != 0) {
          break label112;
        }
      }
      label112:
      for (int i = -1;; i = -1184275)
      {
        paramView.setBackgroundColor(i);
        paramViewGroup = (SearchFAQ.b)a.d.a(getItem(paramInt));
        TextView localTextView = (TextView)paramView.findViewById(2131756067);
        localTextView.setText(paramViewGroup.a);
        localTextView.setOnClickListener(aho.a(this, paramViewGroup));
        return paramView;
        paramView = (LinearLayout)paramView;
        break;
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/SearchFAQ.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */