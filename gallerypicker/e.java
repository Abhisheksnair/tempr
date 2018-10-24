package com.whatsapp.gallerypicker;

import a.a.a.a.d;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.MediaStore.Images.Media;
import android.support.v4.app.Fragment;
import android.support.v4.app.n;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.whatsapp.TextEmojiLabel;
import com.whatsapp.al;
import com.whatsapp.atu;
import com.whatsapp.pv;
import com.whatsapp.util.Log;
import com.whatsapp.util.p;
import java.text.Collator;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public final class e
  extends Fragment
{
  private static final boolean ah;
  private static final String am;
  private static final d[] an;
  private static final d[] ao;
  c a;
  private GridView aa;
  private boolean ab;
  private ao ac;
  private int ad;
  private Drawable ae;
  private int af;
  private int ag;
  private final com.whatsapp.c.a ai = com.whatsapp.c.a.a();
  private final pv aj = pv.a();
  private final atu ak = atu.a();
  private View al;
  boolean b;
  volatile boolean c = false;
  ArrayList<r> d = new ArrayList();
  private int e = 1;
  private Handler f = new Handler(Looper.getMainLooper());
  private Thread g;
  private BroadcastReceiver h;
  private ContentObserver i;
  
  static
  {
    if ((al.a) && (Build.VERSION.SDK_INT < 21)) {}
    for (boolean bool = true;; bool = false)
    {
      ah = bool;
      am = MediaManager.b;
      an = new d[] { new d(4, 1, MediaManager.b, 2131296816), new d(5, 4, MediaManager.b, 2131296817), new d(6, 2, MediaManager.b, 2131296816), new d(0, 1, null, 2131296309), new d(1, 4, null, 2131296311), new d(2, 2, null, 2131296308) };
      ao = new d[] { new d(7, 7, MediaManager.b, 2131296815), new d(3, 7, null, 2131296310), new d(1, 4, null, 2131296311) };
      return;
    }
  }
  
  private void R()
  {
    if (this.ac != null)
    {
      T();
      this.ac.a();
      this.ac = null;
      l().unregisterReceiver(this.h);
      U().unregisterContentObserver(this.i);
      int j = 0;
      while (j < this.aa.getChildCount())
      {
        Object localObject = this.aa.getChildAt(j);
        if ((localObject instanceof FrameLayout))
        {
          localObject = (FrameLayout)localObject;
          int k = 0;
          while (k < ((FrameLayout)localObject).getChildCount())
          {
            View localView = ((FrameLayout)localObject).getChildAt(k);
            if ((localView instanceof SquareImageView)) {
              ((SquareImageView)localView).setImageDrawable(null);
            }
            k += 1;
          }
        }
        j += 1;
      }
      this.a = null;
      this.aa.setAdapter(null);
    }
  }
  
  private void S()
  {
    this.c = false;
    this.g = new Thread("GalleryPicker Worker")
    {
      public final void run()
      {
        e.c(e.this);
      }
    };
    a.a().a(this.g);
    this.g.start();
  }
  
  private void T()
  {
    if (this.g != null)
    {
      a.a().a(this.g, U());
      this.c = true;
      try
      {
        this.g.join();
        this.g = null;
        this.f.removeMessages(0);
        Object localObject = this.a;
        ((c)localObject).a.clear();
        ((c)localObject).c = null;
        ((c)localObject).notifyDataSetChanged();
        localObject = this.d.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((r)((Iterator)localObject).next()).d();
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          Log.i("gallerypicker/join interrupted");
        }
        this.d.clear();
      }
    }
  }
  
  private ContentResolver U()
  {
    n localn = l();
    if (localn == null) {
      return null;
    }
    return localn.getContentResolver();
  }
  
  private r a(int paramInt, String paramString, ContentResolver paramContentResolver)
  {
    paramString = MediaManager.a(paramContentResolver, this.ak, MediaManager.a.c, paramInt, paramString);
    this.d.add(paramString);
    return paramString;
  }
  
  private void a(a parama)
  {
    Object localObject1;
    if (!this.ab)
    {
      localObject1 = MediaManager.a(U(), this.ak, MediaManager.a.c, this.e, null);
      if (!this.c) {
        break label52;
      }
      ((r)localObject1).d();
    }
    label52:
    label244:
    for (;;)
    {
      return;
      localObject1 = MediaManager.a(this.ak);
      break;
      Object localObject2 = new ArrayList(((r)localObject1).a().entrySet());
      Object localObject3 = Collator.getInstance();
      ((Collator)localObject3).setStrength(0);
      ((Collator)localObject3).setDecomposition(1);
      Collections.sort((List)localObject2, j.a((Collator)localObject3));
      ((r)localObject1).d();
      if (!this.c)
      {
        localObject1 = ((ArrayList)localObject2).iterator();
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label244;
          }
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          localObject3 = (String)((Map.Entry)localObject2).getKey();
          if (localObject3 != null)
          {
            if (this.c) {
              break;
            }
            if (!((String)localObject3).equals(am))
            {
              r localr = a(this.e, (String)localObject3, U());
              if (!localr.c()) {
                parama.a(new b(8, this.e, (String)localObject3, (String)((Map.Entry)localObject2).getValue(), localr.b(0), localr.b()));
              }
              localr.d();
            }
          }
        }
      }
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Log.i("gallerypicker/" + this.e + "/rebake unmounted:" + paramBoolean1 + " scanning:" + paramBoolean2 + " oldunmounted:" + this.ab + " oldscanning:" + this.b);
    if ((paramBoolean1 != this.ab) || (paramBoolean2 != this.b))
    {
      T();
      this.ab = paramBoolean1;
      this.b = paramBoolean2;
      if (this.ab) {
        b();
      }
    }
    else
    {
      return;
    }
    c();
    S();
  }
  
  private void b()
  {
    Object localObject;
    if (this.al == null)
    {
      localObject = (ViewGroup)x().findViewById(2131755712);
      l().getLayoutInflater().inflate(2130903235, (ViewGroup)localObject);
      this.al = ((ViewGroup)localObject).findViewById(2131755782);
      localObject = (TextView)this.al.findViewById(2131755783);
      if (this.e != 1) {
        break label85;
      }
      ((TextView)localObject).setText(2131297036);
    }
    for (;;)
    {
      this.al.setVisibility(0);
      return;
      label85:
      if (this.e == 2) {
        ((TextView)localObject).setText(2131297035);
      } else if (this.e == 4) {
        ((TextView)localObject).setText(2131297037);
      }
    }
  }
  
  private void b(a parama)
  {
    Cursor localCursor = U().query(Uri.parse("content://com.whatsapp.provider.media/buckets"), null, null, null, null);
    if (localCursor != null)
    {
      while (localCursor.moveToNext())
      {
        String str1 = localCursor.getString(0);
        String str2 = localCursor.getString(1);
        if (this.c) {
          break;
        }
        be localbe = new be(U(), str1, this.e);
        if (!localbe.c()) {
          parama.a(new b(9, this.e, str1, str2, localbe.b(0), localbe.b()));
        }
        localbe.d();
      }
      localCursor.close();
    }
  }
  
  private void c()
  {
    if (this.al != null) {
      this.al.setVisibility(8);
    }
  }
  
  public final void A()
  {
    Log.i("gallerypicker/" + this.e + "/destroy");
    super.A();
    R();
    this.ai.a.a(-1);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return paramLayoutInflater.inflate(2130903233, paramViewGroup, false);
  }
  
  public final void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    this.e = i().getInt("include");
    this.af = m().getColor(2131624032);
    this.ae = new ColorDrawable(this.af);
    this.ad = m().getDimensionPixelSize(2131361999);
    this.aa = ((GridView)x().findViewById(2131755781));
    if ((ah) && (!this.aj.d())) {
      this.aa.setHorizontalSpacing(0);
    }
    this.aa.setOnItemClickListener(f.a(this));
    this.aa.setOnCreateContextMenuListener(new g(this));
    this.h = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        e.a(e.this, paramAnonymousIntent);
      }
    };
    this.i = new ContentObserver(this.f)
    {
      public final void onChange(boolean paramAnonymousBoolean)
      {
        if (e.a(e.this) != null)
        {
          e.a(e.this, MediaManager.a(e.a(e.this)));
          return;
        }
        Log.i("gallerypicker/" + e.b(e.this) + " no content resolver");
      }
    };
    this.ag = (l().getWindowManager().getDefaultDisplay().getHeight() * l().getWindowManager().getDefaultDisplay().getWidth() / (this.ad * this.ad) + 1);
    this.a = new c(l().getLayoutInflater());
    this.aa.setAdapter(this.a);
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.MEDIA_MOUNTED");
    paramBundle.addAction("android.intent.action.MEDIA_UNMOUNTED");
    paramBundle.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
    paramBundle.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
    paramBundle.addAction("android.intent.action.MEDIA_EJECT");
    paramBundle.addDataScheme("file");
    l().registerReceiver(this.h, paramBundle);
    U().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.i);
    this.ac = new ao(this.ai, U(), this.f);
    this.ab = false;
    this.b = false;
    S();
  }
  
  final class a
  {
    final ArrayList<e.b> a = new ArrayList();
    private int c;
    private long d = SystemClock.uptimeMillis();
    
    private a() {}
    
    final void a(e.b paramb)
    {
      if (this.c < e.d(e.this)) {
        e.e(e.this).post(k.a(this, paramb));
      }
      for (;;)
      {
        this.c += 1;
        return;
        this.a.add(paramb);
        if (this.d + 1000L < SystemClock.uptimeMillis())
        {
          paramb = new ArrayList(this.a);
          this.a.clear();
          e.e(e.this).post(l.a(this, paramb));
          this.d = SystemClock.uptimeMillis();
        }
      }
    }
  }
  
  final class b
  {
    final int a;
    final int b;
    final String c;
    final String d;
    final q e;
    final int f;
    
    b(int paramInt1, int paramInt2, String paramString1, String paramString2, q paramq, int paramInt3)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramString1;
      this.d = paramString2;
      this.e = paramq;
      this.f = paramInt3;
    }
    
    public final String a()
    {
      return this.a + "-" + this.c + "-" + this.b;
    }
  }
  
  final class c
    extends BaseAdapter
  {
    final ArrayList<e.b> a = new ArrayList();
    final LayoutInflater b;
    View c;
    
    c(LayoutInflater paramLayoutInflater)
    {
      this.b = paramLayoutInflater;
    }
    
    public final int getCount()
    {
      return this.a.size();
    }
    
    public final Object getItem(int paramInt)
    {
      return Integer.valueOf(paramInt);
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      if (paramInt == 0) {
        return 0;
      }
      return 1;
    }
    
    public final View getView(int paramInt, final View paramView, ViewGroup paramViewGroup)
    {
      if ((paramInt == 0) && (this.c != null))
      {
        paramView = this.c;
        return paramView;
      }
      final Object localObject1 = (e.b)this.a.get(paramInt);
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramView = al.a(e.f(e.this), this.b, 2130903234);
        paramViewGroup = paramView;
        if (paramInt == 0)
        {
          this.c = paramView;
          paramViewGroup = paramView;
        }
      }
      if ((e.a()) && (!e.f(e.this).d())) {
        paramViewGroup.setPadding(e.this.m().getDimensionPixelSize(2131361998), 0, 0, 0);
      }
      paramView = (TextEmojiLabel)paramViewGroup.findViewById(2131755177);
      Object localObject2 = (ImageView)paramViewGroup.findViewById(2131755176);
      TextView localTextView = (TextView)paramViewGroup.findViewById(2131755398);
      final ImageView localImageView = (ImageView)paramViewGroup.findViewById(2131755587);
      localTextView.setText(NumberFormat.getInstance().format(((e.b)localObject1).f));
      paramView.a(((e.b)localObject1).d);
      switch (((e.b)localObject1).a)
      {
      case 3: 
      case 8: 
      default: 
        paramInt = 2130840018;
      }
      for (;;)
      {
        ((ImageView)localObject2).setImageResource(paramInt);
        localObject2 = (ao.a)localImageView.getTag();
        if (localObject2 != null)
        {
          paramView = paramViewGroup;
          if (((ao.a)localObject2).b().equals(((e.b)localObject1).a())) {
            break;
          }
        }
        e.g(e.this).a((ao.a)localObject2);
        paramView = ((e.b)localObject1).e;
        localObject1 = new ao.a()
        {
          public final Bitmap a()
          {
            Object localObject;
            if (localImageView.getTag() != this) {
              localObject = null;
            }
            Bitmap localBitmap;
            do
            {
              return (Bitmap)localObject;
              localBitmap = paramView.a(e.h(e.this));
              localObject = localBitmap;
            } while (localBitmap != null);
            return w.ab;
          }
          
          public final String b()
          {
            return localObject1.a();
          }
        };
        paramView = new ao.b()
        {
          public final void a()
          {
            localImageView.setBackgroundColor(e.i(e.this));
            localImageView.setImageDrawable(null);
          }
          
          public final void a(Bitmap paramAnonymousBitmap, boolean paramAnonymousBoolean)
          {
            if ((localImageView.getTag() == localObject1) && (e.this.l() != null))
            {
              if (paramAnonymousBitmap != w.ab) {
                break label265;
              }
              localImageView.setScaleType(ImageView.ScaleType.CENTER);
              localImageView.setBackgroundColor(e.i(e.this));
              if (d.c(paramView))
              {
                localImageView.setBackgroundColor(e.this.m().getColor(2131624084));
                localImageView.setImageResource(2130840022);
              }
            }
            else
            {
              return;
            }
            if (d.a(paramView))
            {
              localImageView.setBackgroundColor(e.i(e.this));
              localImageView.setImageResource(2130840204);
              return;
            }
            if (d.b(paramView))
            {
              localImageView.setBackgroundColor(e.i(e.this));
              localImageView.setImageResource(2130840205);
              return;
            }
            if (p.a(paramView.d()))
            {
              localImageView.setBackgroundColor(e.i(e.this));
              localImageView.setImageDrawable(p.a(e.this.l(), paramView.d()));
              return;
            }
            localImageView.setBackgroundColor(e.i(e.this));
            localImageView.setImageResource(0);
            return;
            label265:
            localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            localImageView.setBackgroundResource(0);
            if (!paramAnonymousBoolean)
            {
              paramAnonymousBitmap = new TransitionDrawable(new Drawable[] { e.j(e.this), new BitmapDrawable(e.this.m(), paramAnonymousBitmap) });
              paramAnonymousBitmap.setCrossFadeEnabled(true);
              paramAnonymousBitmap.startTransition(150);
              localImageView.setImageDrawable(paramAnonymousBitmap);
              return;
            }
            localImageView.setImageBitmap(paramAnonymousBitmap);
          }
        };
        localImageView.setTag(localObject1);
        e.g(e.this).a((ao.a)localObject1, paramView);
        return paramViewGroup;
        paramInt = 2130840018;
        continue;
        paramInt = 2130840017;
        continue;
        paramInt = 2130840019;
        continue;
        paramInt = 2130840020;
      }
    }
    
    public final int getViewTypeCount()
    {
      return 2;
    }
    
    public final boolean hasStableIds()
    {
      return true;
    }
  }
  
  static final class d
  {
    int a;
    int b;
    String c;
    int d;
    
    d(int paramInt1, int paramInt2, String paramString, int paramInt3)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramString;
      this.d = paramInt3;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gallerypicker/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */