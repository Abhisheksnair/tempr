package com.whatsapp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v4.content.b;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.p;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.FrameLayout;
import com.whatsapp.data.cs;
import com.whatsapp.util.be;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class yv
  extends RecyclerView.a<c>
  implements Filterable
{
  final MentionPickerView.c c;
  List<cs> d;
  b e;
  final va f;
  private final int g;
  private List<cs> h = new ArrayList();
  private a i;
  private String j;
  private int k;
  private final int l;
  private int m;
  private int n = -1;
  private boolean o;
  private final pv p;
  private final di.e q;
  
  public yv(Context paramContext, pv parampv, va paramva, di paramdi, MentionPickerView.c paramc, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.p = parampv;
    this.f = paramva;
    this.q = paramdi.b();
    this.d = new ArrayList();
    this.c = paramc;
    this.j = "";
    if (paramBoolean1)
    {
      this.k = b.c(paramContext, 2131624081);
      this.m = b.c(paramContext, 2131624082);
    }
    for (this.g = b.c(paramContext, 2131624077);; this.g = b.c(paramContext, 2131624022))
    {
      this.l = ((int)paramContext.getResources().getDimension(2131362051));
      this.o = paramBoolean2;
      return;
      this.k = b.c(paramContext, 2131624047);
      this.m = b.c(paramContext, 2131624045);
    }
  }
  
  private CharSequence a(String paramString)
  {
    int i1 = paramString.toLowerCase().indexOf(this.j);
    Object localObject = paramString;
    if (this.j.length() > 0)
    {
      localObject = paramString;
      if (i1 >= 0)
      {
        localObject = new SpannableStringBuilder(paramString);
        ((SpannableStringBuilder)localObject).setSpan(new StyleSpan(1), i1, this.j.length() + i1, 33);
      }
    }
    return (CharSequence)localObject;
  }
  
  public final int a()
  {
    return this.h.size();
  }
  
  public final Filter getFilter()
  {
    if (this.i == null) {
      this.i = new a((byte)0);
    }
    return this.i;
  }
  
  final class a
    extends Filter
  {
    private a() {}
    
    protected final Filter.FilterResults performFiltering(CharSequence paramCharSequence)
    {
      Filter.FilterResults localFilterResults = new Filter.FilterResults();
      if (paramCharSequence == null)
      {
        localFilterResults.values = new ArrayList();
        localFilterResults.count = 0;
        return localFilterResults;
      }
      if (paramCharSequence.length() == 0)
      {
        localFilterResults.values = yv.c(yv.this);
        localFilterResults.count = yv.c(yv.this).size();
        return localFilterResults;
      }
      if (paramCharSequence.toString().startsWith(" "))
      {
        localFilterResults.values = new ArrayList();
        localFilterResults.count = 0;
        return localFilterResults;
      }
      if (paramCharSequence.length() - paramCharSequence.toString().replaceAll(" ", "").length() > 1)
      {
        localFilterResults.values = new ArrayList();
        localFilterResults.count = 0;
        return localFilterResults;
      }
      ArrayList localArrayList = new ArrayList();
      String str1 = paramCharSequence.toString().toLowerCase();
      paramCharSequence = be.c(paramCharSequence.toString());
      Iterator localIterator = yv.c(yv.this).iterator();
      label371:
      for (;;)
      {
        cs localcs;
        boolean bool;
        if (localIterator.hasNext())
        {
          localcs = (cs)localIterator.next();
          if (localcs.f()) {
            bool = be.a(localcs.j(), paramCharSequence);
          }
        }
        for (;;)
        {
          if (!bool) {
            break label371;
          }
          localArrayList.add(localcs);
          break;
          if (!TextUtils.isEmpty(localcs.e))
          {
            bool = be.a(localcs.e, paramCharSequence);
          }
          else if ((!TextUtils.isEmpty(localcs.q)) && (be.a(localcs.q, paramCharSequence)))
          {
            bool = true;
          }
          else
          {
            String str2 = localcs.t;
            int i = str2.indexOf('@');
            if (i > 0)
            {
              bool = str2.substring(0, i).contains(str1);
              continue;
              localFilterResults.values = localArrayList;
              localFilterResults.count = localArrayList.size();
              return localFilterResults;
            }
            else
            {
              bool = false;
            }
          }
        }
      }
    }
    
    protected final void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
    {
      int k = -1;
      yv.a(yv.this, (List)paramFilterResults.values);
      paramFilterResults = yv.d(yv.this);
      if (yv.e(yv.this) != null) {
        Collections.sort(paramFilterResults, yv.e(yv.this));
      }
      paramFilterResults = yv.this;
      Object localObject = yv.d(yv.this);
      int j = k;
      if (yv.e(yv.this) != null)
      {
        if (yv.b.a(yv.e(yv.this)) == null) {
          j = k;
        }
      }
      else
      {
        yv.a(paramFilterResults, j);
        paramFilterResults = yv.this;
        if (paramCharSequence == null) {
          break label205;
        }
      }
      label199:
      label205:
      for (paramCharSequence = paramCharSequence.toString().toLowerCase();; paramCharSequence = "")
      {
        yv.a(paramFilterResults, paramCharSequence);
        yv.this.c();
        return;
        Set localSet = yv.b.a(yv.e(yv.this));
        localObject = ((List)localObject).iterator();
        int i = -1;
        for (;;)
        {
          j = k;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          if (!localSet.contains(((cs)((Iterator)localObject).next()).t)) {
            break label199;
          }
          i += 1;
        }
        j = i;
        break;
      }
    }
  }
  
  final class b
    implements Comparator<cs>
  {
    private final GroupChatInfo.b b;
    private Set<String> c;
    
    public b(Context paramContext, va paramva)
    {
      this.b = new GroupChatInfo.b(paramContext, paramva);
    }
  }
  
  public final class c
    extends RecyclerView.p
  {
    public ThumbnailButton n;
    public TextEmojiLabel o;
    public TextEmojiLabel p;
    public FrameLayout q;
    public View r;
    private final int t;
    
    public c(FrameLayout paramFrameLayout)
    {
      super();
      if ((Build.VERSION.SDK_INT < 19) || ((Build.VERSION.SDK_INT < 21) && ("samsung".equalsIgnoreCase(Build.MANUFACTURER)))) {}
      for (int i = 1711315455;; i = 419430400)
      {
        this.t = i;
        this.q = paramFrameLayout;
        this.n = ((ThumbnailButton)paramFrameLayout.findViewById(2131755363));
        this.n.setEnabled(false);
        this.o = ((TextEmojiLabel)paramFrameLayout.findViewById(2131755397));
        this.p = ((TextEmojiLabel)paramFrameLayout.findViewById(2131755803));
        FrameLayout localFrameLayout = this.q;
        StateListDrawable localStateListDrawable = new StateListDrawable();
        ColorDrawable localColorDrawable = new ColorDrawable(this.t);
        localStateListDrawable.addState(new int[] { 16842919 }, localColorDrawable);
        localFrameLayout.setForeground(localStateListDrawable);
        this.r = paramFrameLayout.findViewById(2131755785);
        this.o.setTextColor(yv.a(yv.this));
        this.p.setTextColor(yv.b(yv.this));
        return;
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/yv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */