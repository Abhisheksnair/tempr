package com.whatsapp;

import a.a.a.a.a.a.a;
import a.a.a.a.a.a.b;
import a.a.a.a.a.a.d;
import a.a.a.a.a.a.e;
import a.a.a.a.a.d;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.CommonDataKinds.StructuredPostal;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.p;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.whatsapp.data.e;
import com.whatsapp.protocol.j;
import com.whatsapp.util.Log;
import com.whatsapp.util.ba;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.text.Collator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ViewSharedContactArrayActivity
  extends nh
{
  private String n;
  private ArrayList<String> o;
  private ArrayList<String> p;
  private ArrayList<a.a.a.a.a.a> q = new ArrayList();
  private ArrayList<SparseArray<i>> r = new ArrayList();
  private boolean s;
  private a.a.a.a.a.a t = null;
  private final aoj u = aoj.a();
  private final e v = e.a();
  private final com.whatsapp.data.l w = com.whatsapp.data.l.a();
  private final ba x = ba.a();
  private final di.e y = di.a().b();
  private Pattern z;
  
  private a.a.a.a.a.a a(String paramString)
  {
    try
    {
      paramString = a.a.a.a.a.a.a(getApplicationContext(), e.a(), paramString);
      return paramString;
    }
    catch (d paramString)
    {
      Log.w(paramString);
      return null;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        Log.e(paramString);
      }
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;) {}
    }
  }
  
  public static Intent a(String paramString, Uri paramUri, j paramj, boolean paramBoolean, e parame, and paramand, Activity paramActivity)
  {
    a.a.a.a.a.a locala = new a.a.a.a.a.a(paramActivity, parame);
    parame = paramand.f;
    if (parame == null)
    {
      Log.w("conversation/actresult/read_contacts cr = null");
      parame = null;
      if (parame == null) {
        break label353;
      }
      if (!parame.moveToNext()) {
        break label348;
      }
      paramUri = parame.getString(parame.getColumnIndex("_id"));
      locala.c.a = parame.getString(parame.getColumnIndex("display_name"));
      locala.a(paramUri);
      if (Integer.parseInt(parame.getString(parame.getColumnIndex("has_phone_number"))) > 0) {
        locala.b(paramUri);
      }
      locala.c(paramUri);
      locala.d(paramUri);
      locala.e(paramUri);
      locala.f(paramUri);
      locala.g(paramUri);
      locala.h(paramUri);
      label159:
      parame.close();
    }
    for (;;)
    {
      parame = new a.a.a.a.a.c();
      try
      {
        parame = parame.a(paramActivity, locala);
        if (parame == null)
        {
          Log.e("conversation/actresult/vcard is null!");
          pv.a(paramActivity, 2131298052, 0);
          return null;
          parame = parame.query(paramUri, new String[] { "_id", "display_name", "has_phone_number" }, null, null, null);
        }
      }
      catch (d parame)
      {
        for (;;)
        {
          Log.e(parame);
          pv.a(paramActivity, 2131297221, 0);
          parame = null;
        }
        paramand = new Intent(paramActivity, ViewSharedContactArrayActivity.class);
        paramand.putExtra("edit_mode", true);
        paramand.putExtra("jid", paramString);
        paramand.putExtra("vcard", parame);
        paramand.putExtra("contact_id", paramUri);
        if (paramj != null) {}
      }
      for (long l = 0L;; l = paramj.Q)
      {
        paramand.putExtra("quoted_message_row_id", l);
        paramand.putExtra("has_number_from_url", paramBoolean);
        return paramand;
      }
      label348:
      paramUri = null;
      break label159;
      label353:
      paramUri = null;
    }
  }
  
  private i a(SparseArray<i> paramSparseArray, int paramInt)
  {
    i locali2 = (i)paramSparseArray.get(paramInt);
    i locali1 = locali2;
    if (locali2 == null)
    {
      locali1 = new i();
      paramSparseArray.put(paramInt, locali1);
    }
    return locali1;
  }
  
  private List<a.a.a.a.a> a(a.a.a.a.a.a parama, List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = ((List)parama.k.get(localObject2)).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        a.a.a.a.a locala = (a.a.a.a.a)((Iterator)localObject2).next();
        if (locala.a.equals("URL"))
        {
          Log.d(locala.toString());
          if (this.z == null) {
            this.z = Pattern.compile("(http|https)://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&amp;=]*)?");
          }
          if (this.z.matcher(locala.b).matches()) {
            localArrayList.add(locala);
          }
        }
      }
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject1 = (String)paramList.next();
      localObject1 = ((List)parama.k.get(localObject1)).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (a.a.a.a.a)((Iterator)localObject1).next();
        if (!((a.a.a.a.a)localObject2).a.equals("URL"))
        {
          Log.d(((a.a.a.a.a)localObject2).toString());
          localArrayList.add(localObject2);
        }
      }
    }
    return localArrayList;
  }
  
  private List<Object> a(List<a.a.a.a.a.a> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int k = 0;
    while (k < paramList.size())
    {
      Object localObject1 = (a.a.a.a.a.a)paramList.get(k);
      SparseArray localSparseArray = (SparseArray)this.r.get(k);
      localArrayList.add(new g((a.a.a.a.a.a)localObject1, (byte)0));
      Object localObject2 = new ArrayList();
      Object localObject3;
      Object localObject4;
      if (((a.a.a.a.a.a)localObject1).h != null)
      {
        localObject3 = ((a.a.a.a.a.a)localObject1).h.iterator();
        j = 0;
        for (;;)
        {
          i = j;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject4 = (a.e)((Iterator)localObject3).next();
          if (((a.e)localObject4).e == null)
          {
            ((List)localObject2).add(localObject4);
          }
          else
          {
            localArrayList.add(new c(localObject4, k, j, (byte)0));
            a(localSparseArray, j).b = localObject4;
            j += 1;
          }
        }
      }
      int i = 0;
      int j = i;
      if (((a.a.a.a.a.a)localObject1).i != null)
      {
        localObject3 = ((a.a.a.a.a.a)localObject1).i.iterator();
        for (;;)
        {
          j = i;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject4 = (a.b)((Iterator)localObject3).next();
          localArrayList.add(new c(localObject4, k, i, (byte)0));
          a(localSparseArray, i).b = localObject4;
          i += 1;
        }
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (a.e)((Iterator)localObject2).next();
        localArrayList.add(new c(localObject3, k, j, (byte)0));
        a(localSparseArray, j).b = localObject3;
        j += 1;
      }
      if (((a.a.a.a.a.a)localObject1).k != null)
      {
        localObject2 = new ArrayList(((a.a.a.a.a.a)localObject1).k.keySet());
        Collections.sort((List)localObject2);
        localObject1 = a((a.a.a.a.a.a)localObject1, (List)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (a.a.a.a.a)((Iterator)localObject1).next();
          localArrayList.add(new c(localObject2, k, j, (byte)0));
          a(localSparseArray, j).b = localObject2;
          j += 1;
        }
      }
      localArrayList.add(new e((byte)0));
      k += 1;
    }
    ((e)localArrayList.get(localArrayList.size() - 1)).a = true;
    return localArrayList;
  }
  
  private static String b(Class<?> paramClass, int paramInt)
  {
    try
    {
      paramClass = paramClass.getMethod("getTypeLabelResource", new Class[] { Integer.TYPE });
      paramClass = u.a().getString(((Integer)paramClass.invoke(null, new Object[] { Integer.valueOf(paramInt) })).intValue());
      return paramClass;
    }
    catch (Exception paramClass)
    {
      Log.e(paramClass);
    }
    return null;
  }
  
  public final void c(int paramInt)
  {
    if (paramInt == 2131296747) {
      finish();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while ((paramInt2 != -1) || (this.t == null));
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramIntent != null)
    {
      localObject1 = localObject2;
      if (paramIntent.getData() != null) {
        localObject1 = paramIntent.getData().getLastPathSegment();
      }
    }
    this.x.a(this.p, this.o, this.t.a(), (String)localObject1);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = i();
    if (paramBundle != null) {
      paramBundle.a(true);
    }
    setContentView(2130903396);
    this.s = getIntent().getBooleanExtra("edit_mode", true);
    this.n = getIntent().getStringExtra("jid");
    paramBundle = getIntent().getStringExtra("vcard");
    Iterator localIterator;
    if (!TextUtils.isEmpty(paramBundle))
    {
      paramBundle = Collections.singletonList(paramBundle);
      localIterator = paramBundle.iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label162;
      }
      a.a.a.a.a.a locala = a((String)localIterator.next());
      if (locala == null)
      {
        Log.w("viewsharedcontactarrayactivity/oncreate/parsing vcard gave null contact; skipping");
        continue;
        paramBundle = getIntent().getStringArrayListExtra("vcard_array");
        break;
      }
      this.q.add(locala);
      this.r.add(new SparseArray());
    }
    label162:
    Collections.sort(this.q, new a());
    if (this.q.isEmpty())
    {
      Log.w("viewsharedcontactarrayactivity/oncreate/no vcards to display");
      pv.a(this, 2131296747, 0);
      finish();
      return;
    }
    if (this.s)
    {
      findViewById(2131756174).setVisibility(0);
      i().a(u.a.a(2131230794, this.q.size()));
    }
    for (;;)
    {
      paramBundle = (RecyclerView)findViewById(2131756173);
      paramBundle.setAdapter(new b(a(this.q)));
      paramBundle.setLayoutManager(new LinearLayoutManager(this));
      ((ImageButton)findViewById(2131756174)).setOnClickListener(aqi.a(this));
      return;
      findViewById(2131756174).setVisibility(8);
      int i = paramBundle.size();
      i().a(u.a.a(2131230816, i, new Object[] { Integer.valueOf(i) }));
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.y.a();
  }
  
  final class a
    implements Comparator<a.a.a.a.a.a>
  {
    private final Collator b = Collator.getInstance();
    
    a()
    {
      this.b.setStrength(0);
      this.b.setDecomposition(1);
    }
  }
  
  public final class b
    extends RecyclerView.a<RecyclerView.p>
  {
    private List<Object> d;
    private final int e = 0;
    private final int f = 1;
    private final int g = 2;
    
    public b()
    {
      List localList;
      this.d = localList;
    }
    
    public final int a()
    {
      return this.d.size();
    }
    
    public final int a(int paramInt)
    {
      Object localObject = this.d.get(paramInt);
      if ((localObject instanceof ViewSharedContactArrayActivity.g)) {
        return 0;
      }
      if ((localObject instanceof ViewSharedContactArrayActivity.c)) {
        return 1;
      }
      if ((localObject instanceof ViewSharedContactArrayActivity.e)) {
        return 2;
      }
      return -1;
    }
    
    public final RecyclerView.p a(ViewGroup paramViewGroup, int paramInt)
    {
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext());
      switch (paramInt)
      {
      default: 
        return null;
      case 0: 
        paramViewGroup = al.a(ViewSharedContactArrayActivity.this.aq, paramViewGroup, 2130903347, null, true);
        return new ViewSharedContactArrayActivity.h(ViewSharedContactArrayActivity.this, paramViewGroup, (byte)0);
      case 1: 
        paramViewGroup = al.a(ViewSharedContactArrayActivity.this.aq, paramViewGroup, 2130903111, null, true);
        return new ViewSharedContactArrayActivity.d(ViewSharedContactArrayActivity.this, paramViewGroup, (byte)0);
      }
      paramViewGroup = al.a(ViewSharedContactArrayActivity.this.aq, paramViewGroup, 2130903109, null, true);
      return new ViewSharedContactArrayActivity.f(ViewSharedContactArrayActivity.this, paramViewGroup, (byte)0);
    }
    
    public final void a(RecyclerView.p paramp, int paramInt)
    {
      Object localObject1 = this.d.get(paramInt);
      label217:
      Object localObject4;
      switch (paramp.e())
      {
      default: 
      case 0: 
      case 1: 
        Object localObject3;
        label630:
        label641:
        label656:
        do
        {
          do
          {
            return;
            localObject2 = (ViewSharedContactArrayActivity.h)paramp;
            localObject3 = ((ViewSharedContactArrayActivity.g)localObject1).a;
            if (ViewSharedContactArrayActivity.f(ViewSharedContactArrayActivity.this))
            {
              ((ViewSharedContactArrayActivity.h)localObject2).r.setVisibility(8);
              ((ViewSharedContactArrayActivity.h)localObject2).n.setText(com.whatsapp.emoji.c.a(((a.a.a.a.a.a)localObject3).a(), u.a(), ((ViewSharedContactArrayActivity.h)localObject2).n.getPaint()));
              localObject1 = null;
              paramp = (RecyclerView.p)localObject1;
              if (((a.a.a.a.a.a)localObject3).j != null)
              {
                paramp = (RecyclerView.p)localObject1;
                if (((a.a.a.a.a.a)localObject3).j.size() > 0) {
                  paramp = ((a.d)((a.a.a.a.a.a)localObject3).j.get(0)).b;
                }
              }
              if (!TextUtils.isEmpty(paramp)) {
                break label217;
              }
              ((ViewSharedContactArrayActivity.h)localObject2).o.setVisibility(8);
            }
            for (;;)
            {
              ViewSharedContactArrayActivity.g(ViewSharedContactArrayActivity.this).a((a.a.a.a.a.a)localObject3, ((ViewSharedContactArrayActivity.h)localObject2).p);
              return;
              ((ViewSharedContactArrayActivity.h)localObject2).r.setVisibility(0);
              ((ViewSharedContactArrayActivity.h)localObject2).r.setOnClickListener(aqm.a(this, (a.a.a.a.a.a)localObject3));
              break;
              ((ViewSharedContactArrayActivity.h)localObject2).o.setText(paramp);
              ((ViewSharedContactArrayActivity.h)localObject2).o.setVisibility(0);
            }
            localObject2 = (ViewSharedContactArrayActivity.d)paramp;
            ViewSharedContactArrayActivity.a((ViewSharedContactArrayActivity.d)localObject2);
            ((ViewSharedContactArrayActivity.d)localObject2).q.setVisibility(0);
            paramp = (ViewSharedContactArrayActivity.c)localObject1;
            localObject3 = ViewSharedContactArrayActivity.a(ViewSharedContactArrayActivity.this, (SparseArray)ViewSharedContactArrayActivity.b(ViewSharedContactArrayActivity.this).get(paramp.b), paramp.c);
            ((ViewSharedContactArrayActivity.d)localObject2).u.setTag(localObject3);
            String str;
            if ((paramp.a instanceof a.e))
            {
              localObject1 = (a.e)paramp.a;
              ((ViewSharedContactArrayActivity.i)localObject3).b = localObject1;
              paramInt = 2130840065;
              if (ViewSharedContactArrayActivity.f(ViewSharedContactArrayActivity.this)) {
                paramInt = 2130840052;
              }
              localObject4 = ViewSharedContactArrayActivity.this;
              str = ((a.e)localObject1).b;
              if (((a.e)localObject1).a == 0) {}
              for (paramp = ((a.e)localObject1).c;; paramp = ViewSharedContactArrayActivity.a(ContactsContract.CommonDataKinds.Phone.class, ((a.e)localObject1).a))
              {
                ViewSharedContactArrayActivity.a((ViewSharedContactArrayActivity)localObject4, (ViewSharedContactArrayActivity.d)localObject2, str, paramp, paramInt, 1, ((ViewSharedContactArrayActivity.i)localObject3).a);
                if (ViewSharedContactArrayActivity.f(ViewSharedContactArrayActivity.this)) {
                  break label656;
                }
                if (((a.e)localObject1).e == null) {
                  break label641;
                }
                ((ViewSharedContactArrayActivity.d)localObject2).p.setOnClickListener(aqn.a(this, (a.e)localObject1));
                paramp = ((a.e)localObject1).e + "@s.whatsapp.net";
                paramp = ViewSharedContactArrayActivity.h(ViewSharedContactArrayActivity.this).d(paramp);
                ((ViewSharedContactArrayActivity.d)localObject2).r.setOnTouchListener(new agl(0.15F, 0.15F, 0.15F, 0.15F));
                ((ViewSharedContactArrayActivity.d)localObject2).r.setOnClickListener(aqo.a(this, paramp));
                if (aic.h()) {
                  a.d.b(((ViewSharedContactArrayActivity.d)localObject2).r.getDrawable(), ViewSharedContactArrayActivity.this.getResources().getColor(2131623985));
                }
                ((ViewSharedContactArrayActivity.d)localObject2).s.setOnTouchListener(new agl(0.15F, 0.15F, 0.15F, 0.15F));
                if (!br.b()) {
                  break label630;
                }
                ((ViewSharedContactArrayActivity.d)localObject2).s.setVisibility(0);
                ((ViewSharedContactArrayActivity.d)localObject2).s.setOnClickListener(aqp.a(this, paramp));
                if (!aic.h()) {
                  break;
                }
                a.d.b(((ViewSharedContactArrayActivity.d)localObject2).s.getDrawable(), ViewSharedContactArrayActivity.this.getResources().getColor(2131624128));
                return;
              }
              ((ViewSharedContactArrayActivity.d)localObject2).s.setVisibility(8);
              return;
              ViewSharedContactArrayActivity.b((ViewSharedContactArrayActivity.d)localObject2);
              ((ViewSharedContactArrayActivity.d)localObject2).q.setVisibility(4);
              return;
              ViewSharedContactArrayActivity.b((ViewSharedContactArrayActivity.d)localObject2);
              ((ViewSharedContactArrayActivity.d)localObject2).u.setClickable(true);
              return;
            }
            if (!(paramp.a instanceof a.b)) {
              break;
            }
            localObject1 = (a.b)paramp.a;
            ((ViewSharedContactArrayActivity.i)localObject3).b = localObject1;
            if (((a.b)localObject1).a == ContactsContract.CommonDataKinds.Email.class)
            {
              localObject4 = ViewSharedContactArrayActivity.this;
              str = ((a.b)localObject1).c;
              if (((a.b)localObject1).b == 0) {}
              for (paramp = ((a.b)localObject1).e;; paramp = ViewSharedContactArrayActivity.a(ContactsContract.CommonDataKinds.Email.class, ((a.b)localObject1).b))
              {
                ViewSharedContactArrayActivity.a((ViewSharedContactArrayActivity)localObject4, (ViewSharedContactArrayActivity.d)localObject2, str, paramp, 2130837762, 2, ((ViewSharedContactArrayActivity.i)localObject3).a);
                ViewSharedContactArrayActivity.b((ViewSharedContactArrayActivity.d)localObject2);
                ((ViewSharedContactArrayActivity.d)localObject2).q.setVisibility(0);
                ((ViewSharedContactArrayActivity.d)localObject2).u.setClickable(true);
                return;
              }
            }
          } while (((a.b)localObject1).a != ContactsContract.CommonDataKinds.StructuredPostal.class);
          localObject4 = ((a.b)localObject1).d;
          paramp = "null";
          if (localObject4 != null)
          {
            paramp = new StringBuilder();
            if ((((a.a)localObject4).a != null) && (((a.a)localObject4).a.length() > 0)) {
              paramp.append(a.a.a(((a.a)localObject4).a)).append('\n');
            }
            int i = 0;
            paramInt = i;
            if (((a.a)localObject4).b != null)
            {
              paramInt = i;
              if (((a.a)localObject4).b.length() > 0)
              {
                paramp.append(((a.a)localObject4).b);
                paramInt = 1;
              }
            }
            i = paramInt;
            if (((a.a)localObject4).c != null)
            {
              i = paramInt;
              if (((a.a)localObject4).c.length() > 0)
              {
                if (paramInt != 0) {
                  paramp.append(" ");
                }
                paramp.append(((a.a)localObject4).c);
                i = 1;
              }
            }
            paramInt = i;
            if (((a.a)localObject4).d != null)
            {
              paramInt = i;
              if (((a.a)localObject4).d.length() > 0)
              {
                if (i != 0) {
                  paramp.append(" ");
                }
                paramp.append(((a.a)localObject4).d);
                paramInt = 1;
              }
            }
            if ((((a.a)localObject4).e != null) && (((a.a)localObject4).e.length() > 0))
            {
              if (paramInt != 0) {
                paramp.append(" ");
              }
              paramp.append(((a.a)localObject4).e);
            }
            paramp = paramp.toString();
          }
          localObject4 = ViewSharedContactArrayActivity.this;
          if (((a.b)localObject1).b == 0) {}
          for (localObject1 = ((a.b)localObject1).e;; localObject1 = ViewSharedContactArrayActivity.a(ContactsContract.CommonDataKinds.StructuredPostal.class, ((a.b)localObject1).b))
          {
            ViewSharedContactArrayActivity.a((ViewSharedContactArrayActivity)localObject4, (ViewSharedContactArrayActivity.d)localObject2, paramp, (String)localObject1, 2130837761, 3, ((ViewSharedContactArrayActivity.i)localObject3).a);
            ViewSharedContactArrayActivity.b((ViewSharedContactArrayActivity.d)localObject2);
            ((ViewSharedContactArrayActivity.d)localObject2).q.setVisibility(0);
            ((ViewSharedContactArrayActivity.d)localObject2).u.setClickable(true);
            return;
          }
        } while (!(paramp.a instanceof a.a.a.a.a));
        localObject4 = (a.a.a.a.a)paramp.a;
        Log.d(((a.a.a.a.a)localObject4).toString());
        localObject1 = ((a.a.a.a.a)localObject4).b;
        paramp = (RecyclerView.p)localObject1;
        if (((a.a.a.a.a)localObject4).a.equals("BDAY")) {}
        for (;;)
        {
          try
          {
            if (!((String)localObject1).startsWith("--")) {
              continue;
            }
            paramp = "--MM-dd";
            paramInt = 1;
            l = new SimpleDateFormat(paramp, Locale.getDefault()).parse((String)localObject1).getTime();
            if (paramInt == 0) {
              continue;
            }
            paramp = com.whatsapp.util.l.c(l);
          }
          catch (ParseException paramp)
          {
            long l;
            paramp.printStackTrace();
            paramp = (RecyclerView.p)localObject1;
            continue;
            localObject1 = ViewSharedContactArrayActivity.this.getResources().getString(2131298132);
            continue;
            localObject1 = (String)a.a.a.a.a.a.b.get(((a.a.a.a.a)localObject4).a);
            continue;
          }
          if ((a.a.a.a.a.a.a.containsKey(((a.a.a.a.a)localObject4).a)) || (!((a.a.a.a.a)localObject4).a.equals("URL"))) {
            continue;
          }
          if (((a.a.a.a.a)localObject4).f.toArray().length <= 0) {
            continue;
          }
          localObject1 = (String)localObject4.f.toArray()[0];
          ViewSharedContactArrayActivity.a(ViewSharedContactArrayActivity.this, (ViewSharedContactArrayActivity.d)localObject2, paramp, (String)localObject1, 2130837761, 3, ((ViewSharedContactArrayActivity.i)localObject3).a);
          ((ViewSharedContactArrayActivity.i)localObject3).b = localObject4;
          ((ViewSharedContactArrayActivity.d)localObject2).q.setVisibility(4);
          ViewSharedContactArrayActivity.b((ViewSharedContactArrayActivity.d)localObject2);
          return;
          paramp = "yyyy-MM-dd";
          paramInt = 0;
          continue;
          paramp = com.whatsapp.util.l.b(l);
        }
      }
      paramp = (ViewSharedContactArrayActivity.f)paramp;
      localObject1 = (ViewSharedContactArrayActivity.e)localObject1;
      Object localObject2 = paramp.n;
      if ((((ViewSharedContactArrayActivity.e)localObject1).a) && (ViewSharedContactArrayActivity.f(ViewSharedContactArrayActivity.this)))
      {
        paramInt = 0;
        ((View)localObject2).setVisibility(paramInt);
        paramp = paramp.o;
        if ((!((ViewSharedContactArrayActivity.e)localObject1).a) || (!ViewSharedContactArrayActivity.f(ViewSharedContactArrayActivity.this))) {
          break label1471;
        }
      }
      label1471:
      for (paramInt = 8;; paramInt = 0)
      {
        paramp.setVisibility(paramInt);
        return;
        paramInt = 8;
        break;
      }
    }
  }
  
  final class c
  {
    final Object a;
    final int b;
    final int c;
    
    private c(Object paramObject, int paramInt1, int paramInt2)
    {
      this.a = paramObject;
      this.b = paramInt1;
      this.c = paramInt2;
    }
  }
  
  final class d
    extends RecyclerView.p
  {
    TextView n;
    TextView o;
    View p;
    ImageView q;
    ImageView r;
    ImageView s;
    CheckBox t;
    View u;
    
    private d(View paramView)
    {
      super();
      this.n = ((TextView)paramView.findViewById(2131755474));
      this.o = ((TextView)paramView.findViewById(2131755475));
      this.p = paramView.findViewById(2131755472);
      this.q = ((ImageView)paramView.findViewById(2131755473));
      this.r = ((ImageView)paramView.findViewById(2131755477));
      this.s = ((ImageView)paramView.findViewById(2131755478));
      this.t = ((CheckBox)paramView.findViewById(2131755476));
      this.u = paramView;
    }
  }
  
  final class e
  {
    boolean a = false;
    
    private e() {}
  }
  
  final class f
    extends RecyclerView.p
  {
    View n;
    View o;
    
    private f(View paramView)
    {
      super();
      this.n = paramView.findViewById(2131755465);
      this.o = paramView.findViewById(2131755466);
    }
  }
  
  final class g
  {
    final a.a.a.a.a.a a;
    
    private g(a.a.a.a.a.a parama)
    {
      this.a = parama;
    }
  }
  
  final class h
    extends RecyclerView.p
  {
    TextEmojiLabel n;
    TextView o;
    ImageView p;
    View q;
    Button r;
    
    private h(View paramView)
    {
      super();
      this.n = ((TextEmojiLabel)paramView.findViewById(2131755507));
      this.o = ((TextView)paramView.findViewById(2131755322));
      this.p = ((ImageView)paramView.findViewById(2131755173));
      this.r = ((Button)paramView.findViewById(2131755598));
      this.q = paramView;
    }
  }
  
  final class i
  {
    boolean a = true;
    Object b = null;
    
    public i() {}
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ViewSharedContactArrayActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */