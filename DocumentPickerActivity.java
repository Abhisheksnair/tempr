package com.whatsapp;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ah;
import android.support.v4.app.ah.a;
import android.support.v4.app.m;
import android.support.v4.content.d;
import android.support.v4.view.o;
import android.support.v4.view.o.e;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.b;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.emoji.c;
import com.whatsapp.protocol.j;
import com.whatsapp.util.Log;
import com.whatsapp.util.be;
import com.whatsapp.util.bg;
import com.whatsapp.util.l;
import com.whatsapp.util.p;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class DocumentPickerActivity
  extends nm
  implements ah.a<List<b>>
{
  a n;
  List<b> o;
  final List<b> p = new ArrayList();
  android.support.v7.view.b q;
  final android.support.v7.view.b.a r = new android.support.v7.view.b.a()
  {
    private MenuItem b;
    
    public final void a(android.support.v7.view.b paramAnonymousb)
    {
      DocumentPickerActivity.e(DocumentPickerActivity.this).clear();
      DocumentPickerActivity.i(DocumentPickerActivity.this);
      DocumentPickerActivity.h(DocumentPickerActivity.this).notifyDataSetChanged();
    }
    
    public final boolean a(android.support.v7.view.b paramAnonymousb, Menu paramAnonymousMenu)
    {
      this.b = paramAnonymousMenu.add(0, 2131755076, 0, 2131297656);
      o.a(this.b, 2);
      return true;
    }
    
    public final boolean a(android.support.v7.view.b paramAnonymousb, MenuItem paramAnonymousMenuItem)
    {
      if ((paramAnonymousMenuItem.getItemId() == 2131755076) && (!DocumentPickerActivity.e(DocumentPickerActivity.this).isEmpty())) {
        DocumentPickerActivity.a(DocumentPickerActivity.this, DocumentPickerActivity.e(DocumentPickerActivity.this));
      }
      return false;
    }
    
    public final boolean b(android.support.v7.view.b paramAnonymousb, Menu paramAnonymousMenu)
    {
      boolean bool = false;
      if (DocumentPickerActivity.e(DocumentPickerActivity.this).isEmpty()) {
        paramAnonymousb.a(2131297650);
      }
      for (;;)
      {
        paramAnonymousb = this.b;
        if (!DocumentPickerActivity.e(DocumentPickerActivity.this).isEmpty()) {
          bool = true;
        }
        paramAnonymousb.setVisible(bool);
        return true;
        paramAnonymousb.b(String.format(DocumentPickerActivity.this.getResources().getQuantityString(2131230773, DocumentPickerActivity.e(DocumentPickerActivity.this).size()), new Object[] { Integer.valueOf(DocumentPickerActivity.e(DocumentPickerActivity.this).size()) }));
      }
    }
  };
  private String s;
  private List<b> t;
  private MenuItem u;
  private ArrayList<String> v;
  private String w;
  private int x = 0;
  
  private void a(CharSequence paramCharSequence)
  {
    this.n.getFilter().filter(paramCharSequence);
  }
  
  public final d<List<b>> a(Bundle paramBundle)
  {
    return new d(this);
  }
  
  public final void a() {}
  
  public final void a(android.support.v7.view.b paramb)
  {
    super.a(paramb);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(android.support.v4.content.b.c(this, 2131623951));
    }
  }
  
  final void a(b paramb)
  {
    if (this.p.contains(paramb))
    {
      this.p.remove(paramb);
      if (this.p.isEmpty()) {
        this.q.c();
      }
    }
    for (;;)
    {
      this.n.notifyDataSetChanged();
      return;
      this.q.d();
      continue;
      if (this.p.size() >= 30)
      {
        pv.a(getBaseContext(), 2131297851, 0);
      }
      else
      {
        this.p.add(paramb);
        this.q.d();
      }
    }
  }
  
  final void a(Collection<b> paramCollection)
  {
    ArrayList localArrayList = new ArrayList();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      localArrayList.add(Uri.fromFile(((b)paramCollection.next()).a));
    }
    e.a(this.s, localArrayList).a(j_(), null);
  }
  
  public final void b(android.support.v7.view.b paramb)
  {
    super.b(paramb);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(android.support.v4.content.b.c(this, 2131624092));
    }
  }
  
  @TargetApi(19)
  final void l()
  {
    Intent localIntent = new Intent("android.intent.action.OPEN_DOCUMENT");
    localIntent.addCategory("android.intent.category.OPENABLE");
    localIntent.setType("*/*");
    localIntent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
    if (!aic.b())
    {
      List localList = aic.c();
      if (localList.contains("application/pdf"))
      {
        localList.add("application/vnd.google-apps.document");
        localList.add("application/vnd.google-apps.presentation");
        localList.add("application/vnd.google-apps.spreadsheet");
      }
      localIntent.putExtra("android.intent.extra.MIME_TYPES", (String[])localList.toArray(new String[localList.size()]));
    }
    try
    {
      startActivityForResult(localIntent, 1);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      Log.e("docpicker/pick-from-doc-provider " + localActivityNotFoundException.toString());
      pv.a(this, 2131296289, 0);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      ArrayList localArrayList;
      Object localObject1;
      do
      {
        return;
        if (paramInt2 != -1) {
          break;
        }
        localArrayList = new ArrayList();
        localObject1 = paramIntent.getClipData();
        if (localObject1 != null)
        {
          paramInt1 = 0;
          while (paramInt1 < ((ClipData)localObject1).getItemCount())
          {
            Object localObject2 = ((ClipData)localObject1).getItemAt(paramInt1);
            if (localObject2 != null)
            {
              localObject2 = ((ClipData.Item)localObject2).getUri();
              if (localObject2 != null) {
                localArrayList.add(localObject2);
              }
            }
            paramInt1 += 1;
          }
        }
        if (localArrayList.isEmpty())
        {
          paramIntent = paramIntent.getData();
          if (paramIntent != null) {
            localArrayList.add(paramIntent);
          }
        }
      } while (localArrayList.isEmpty());
      paramIntent = localArrayList.iterator();
      while (paramIntent.hasNext())
      {
        localObject1 = (Uri)paramIntent.next();
        try
        {
          grantUriPermission(au.b(), (Uri)localObject1, 1);
        }
        catch (SecurityException localSecurityException)
        {
          Log.w("contactpicker/permission " + localSecurityException);
        }
      }
      e.a(this.s, localArrayList).a(j_(), null);
      return;
    } while ((paramInt2 != 0) || ((this.t != null) && (!this.t.isEmpty())));
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Log.i("docpicker/create");
    super.onCreate(paramBundle);
    i().a(true);
    this.s = getIntent().getStringExtra("jid");
    this.x = getSharedPreferences("com.whatsapp_preferences", 0).getInt("document_picker_sort", this.x);
    setContentView(2130903208);
    this.n = new a((byte)0);
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramBundle = al.a(this.aq, getLayoutInflater(), 2130903209, null, false);
      W().addHeaderView(paramBundle);
    }
    a(this.n);
    W().setOnItemClickListener(ns.a(this));
    W().setOnItemLongClickListener(nt.a(this));
    h().a(this);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131820545, paramMenu);
    SearchView localSearchView = new SearchView(i().h());
    ((TextView)localSearchView.findViewById(2131755212)).setTextColor(android.support.v4.content.b.c(this, 2131624098));
    localSearchView.setQueryHint(getString(2131297635));
    localSearchView.setOnQueryTextListener(new SearchView.b()
    {
      public final boolean a(String paramAnonymousString)
      {
        return false;
      }
      
      public final boolean b(String paramAnonymousString)
      {
        DocumentPickerActivity.a(DocumentPickerActivity.this, paramAnonymousString);
        DocumentPickerActivity.a(DocumentPickerActivity.this, be.c(paramAnonymousString));
        DocumentPickerActivity.a(DocumentPickerActivity.this, DocumentPickerActivity.a(DocumentPickerActivity.this));
        return false;
      }
    });
    this.u = paramMenu.findItem(2131755072);
    MenuItem localMenuItem = this.u;
    if ((this.t != null) && (!this.t.isEmpty())) {}
    for (boolean bool = true;; bool = false)
    {
      localMenuItem.setVisible(bool);
      o.a(this.u, localSearchView);
      o.a(this.u, 10);
      o.a(this.u, new o.e()
      {
        public final boolean a(MenuItem paramAnonymousMenuItem)
        {
          return true;
        }
        
        public final boolean b(MenuItem paramAnonymousMenuItem)
        {
          DocumentPickerActivity.a(DocumentPickerActivity.this, null);
          DocumentPickerActivity.b(DocumentPickerActivity.this);
          return true;
        }
      });
      return super.onCreateOptionsMenu(paramMenu);
    }
  }
  
  public void onDestroy()
  {
    Log.i("docpicker/destroy");
    super.onDestroy();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131756281)
    {
      this.x = 0;
      getSharedPreferences("com.whatsapp_preferences", 0).edit().putInt("document_picker_sort", this.x).commit();
      invalidateOptionsMenu();
      a(this.w);
    }
    do
    {
      return true;
      if (paramMenuItem.getItemId() == 2131756282)
      {
        this.x = 1;
        getSharedPreferences("com.whatsapp_preferences", 0).edit().putInt("document_picker_sort", this.x).commit();
        invalidateOptionsMenu();
        a(this.w);
        return true;
      }
    } while (paramMenuItem.getItemId() != 16908332);
    finish();
    return true;
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    MenuItem localMenuItem = paramMenu.findItem(2131756281);
    paramMenu = paramMenu.findItem(2131756282);
    if (this.x == 0)
    {
      localMenuItem.setChecked(true);
      return true;
    }
    paramMenu.setChecked(true);
    return true;
  }
  
  final class a
    extends BaseAdapter
    implements Filterable
  {
    final DocumentPickerActivity.c a = new DocumentPickerActivity.c(DocumentPickerActivity.this, (byte)0);
    
    private a() {}
    
    public final int getCount()
    {
      if (DocumentPickerActivity.c(DocumentPickerActivity.this) == null) {
        return 0;
      }
      return DocumentPickerActivity.c(DocumentPickerActivity.this).size();
    }
    
    public final Filter getFilter()
    {
      return this.a;
    }
    
    public final Object getItem(int paramInt)
    {
      return null;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject;
      if (paramView != null)
      {
        localObject = (DocumentPickerActivity.f)paramView.getTag();
        paramViewGroup = paramView;
        paramView = (View)localObject;
      }
      for (;;)
      {
        localObject = (DocumentPickerActivity.b)DocumentPickerActivity.c(DocumentPickerActivity.this).get(paramInt);
        paramView.a.setImageDrawable(p.a(DocumentPickerActivity.this.getBaseContext(), ((DocumentPickerActivity.b)localObject).a));
        paramView.b.setText(bg.a(DocumentPickerActivity.this.getBaseContext(), ((DocumentPickerActivity.b)localObject).a.getName(), DocumentPickerActivity.d(DocumentPickerActivity.this)));
        paramView.c.setText(be.a(DocumentPickerActivity.this.getBaseContext(), ((DocumentPickerActivity.b)localObject).d));
        paramView.d.setText(l.b(DocumentPickerActivity.this.getBaseContext(), ((DocumentPickerActivity.b)localObject).c));
        if (!DocumentPickerActivity.e(DocumentPickerActivity.this).contains(localObject)) {
          break;
        }
        paramViewGroup.setBackgroundResource(2130837763);
        return paramViewGroup;
        paramViewGroup = al.a(DocumentPickerActivity.this.aq, DocumentPickerActivity.this.getLayoutInflater(), 2130903210, null, false);
        paramView = new DocumentPickerActivity.f(paramViewGroup);
        paramViewGroup.setTag(paramView);
      }
      paramViewGroup.setBackgroundResource(0);
      return paramViewGroup;
    }
    
    public final boolean isEmpty()
    {
      return false;
    }
  }
  
  static final class b
  {
    final File a;
    final String b;
    final long c;
    final long d;
    
    b(File paramFile)
    {
      this.a = paramFile;
      this.c = paramFile.lastModified();
      this.d = paramFile.length();
      this.b = paramFile.getName();
    }
    
    public final boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof b)) {
        return false;
      }
      return this.a.equals(((b)paramObject).a);
    }
  }
  
  final class c
    extends Filter
  {
    int a = 0;
    
    private c() {}
    
    protected final Filter.FilterResults performFiltering(CharSequence paramCharSequence)
    {
      if (paramCharSequence != null) {}
      for (paramCharSequence = be.c(paramCharSequence.toString());; paramCharSequence = null)
      {
        if (this.a != DocumentPickerActivity.f(DocumentPickerActivity.this))
        {
          this.a = DocumentPickerActivity.f(DocumentPickerActivity.this);
          DocumentPickerActivity.a(DocumentPickerActivity.g(DocumentPickerActivity.this), this.a);
        }
        Object localObject;
        if ((paramCharSequence != null) && (!paramCharSequence.isEmpty()))
        {
          localObject = new ArrayList();
          Iterator localIterator = DocumentPickerActivity.g(DocumentPickerActivity.this).iterator();
          while (localIterator.hasNext())
          {
            DocumentPickerActivity.b localb = (DocumentPickerActivity.b)localIterator.next();
            if (be.a(localb.b, paramCharSequence)) {
              ((List)localObject).add(localb);
            }
          }
        }
        for (paramCharSequence = (CharSequence)localObject;; paramCharSequence = DocumentPickerActivity.g(DocumentPickerActivity.this))
        {
          localObject = new Filter.FilterResults();
          ((Filter.FilterResults)localObject).values = paramCharSequence;
          ((Filter.FilterResults)localObject).count = paramCharSequence.size();
          return (Filter.FilterResults)localObject;
        }
      }
    }
    
    protected final void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
    {
      if (paramFilterResults != null) {
        DocumentPickerActivity.a(DocumentPickerActivity.this, (ArrayList)paramFilterResults.values);
      }
      DocumentPickerActivity.h(DocumentPickerActivity.this).notifyDataSetChanged();
      DocumentPickerActivity.b(DocumentPickerActivity.this);
    }
  }
  
  static final class d
    extends android.support.v4.content.a<List<DocumentPickerActivity.b>>
  {
    final aic o = aic.a();
    private List<DocumentPickerActivity.b> p;
    private final oz q = oz.a();
    private final File[] r = { new File(Environment.getExternalStorageDirectory(), "Download"), Environment.getExternalStorageDirectory(), this.q.g(), new File(Environment.getExternalStorageDirectory(), "Documents") };
    
    public d(Context paramContext)
    {
      super();
    }
    
    private void a(List<DocumentPickerActivity.b> paramList)
    {
      if (h()) {}
      do
      {
        return;
        this.p = paramList;
      } while (!g());
      super.b(paramList);
    }
    
    public final void e()
    {
      super.e();
    }
    
    protected final void i()
    {
      if (this.p != null) {
        a(this.p);
      }
      if ((n()) || (this.p == null)) {
        k();
      }
    }
    
    protected final void l()
    {
      j();
    }
    
    protected final void m()
    {
      super.m();
      j();
      this.p = null;
    }
  }
  
  public static final class e
    extends m
  {
    private final e aa = e.a();
    private final and ab = and.a();
    
    public static e a(String paramString, ArrayList<Uri> paramArrayList)
    {
      e locale = new e();
      Bundle localBundle = new Bundle();
      localBundle.putString("jid", paramString);
      localBundle.putParcelableArrayList("uri_list", paramArrayList);
      locale.f(localBundle);
      return locale;
    }
    
    private String a(Uri paramUri)
    {
      if ("file".equals(paramUri.getScheme())) {
        return paramUri.getLastPathSegment();
      }
      return p.a(this.ab, paramUri);
    }
    
    public final Dialog c(Bundle paramBundle)
    {
      Object localObject = this.aa.d(i().getString("jid"));
      paramBundle = ((cs)localObject).a(k());
      ArrayList localArrayList = i().getParcelableArrayList("uri_list");
      if ((j.b(((cs)localObject).t)) || (((cs)localObject).d()))
      {
        localObject = a((Uri)localArrayList.get(0));
        if ((localArrayList.size() == 1) && (!TextUtils.isEmpty((CharSequence)localObject))) {
          paramBundle = a(2131296945, new Object[] { localObject, paramBundle });
        }
      }
      for (;;)
      {
        return new android.support.v7.app.b.a(l()).b(c.a(paramBundle, k())).a(2131297656, nx.a(this, localArrayList)).b(2131296398, null).a();
        paramBundle = u.a.a(2131230751, localArrayList.size(), new Object[] { Integer.valueOf(localArrayList.size()), paramBundle });
        continue;
        localObject = a((Uri)localArrayList.get(0));
        if ((localArrayList.size() == 1) && (!TextUtils.isEmpty((CharSequence)localObject))) {
          paramBundle = a(2131296501, new Object[] { localObject, paramBundle });
        } else {
          paramBundle = u.a.a(2131230735, localArrayList.size(), new Object[] { Integer.valueOf(localArrayList.size()), paramBundle });
        }
      }
    }
  }
  
  static final class f
  {
    final ImageView a;
    final TextView b;
    final TextView c;
    final TextView d;
    
    public f(View paramView)
    {
      this.a = ((ImageView)paramView.findViewById(2131755176));
      this.b = ((TextView)paramView.findViewById(2131755177));
      this.c = ((TextView)paramView.findViewById(2131755709));
      this.d = ((TextView)paramView.findViewById(2131755328));
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/DocumentPickerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */