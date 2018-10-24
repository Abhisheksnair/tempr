package com.whatsapp.camera;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.n;
import android.support.v4.content.b;
import android.support.v4.view.o;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Toast;
import com.whatsapp.atu;
import com.whatsapp.gallerypicker.MediaManager;
import com.whatsapp.gallerypicker.MediaManager.MediaListParam;
import com.whatsapp.gallerypicker.MediaManager.a;
import com.whatsapp.gallerypicker.MediaPreviewActivity;
import com.whatsapp.gallerypicker.ab;
import com.whatsapp.gallerypicker.ae.a;
import com.whatsapp.gallerypicker.q;
import com.whatsapp.gallerypicker.r;
import com.whatsapp.gallerypicker.w;
import com.whatsapp.util.Log;
import com.whatsapp.util.az;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

public final class c
  extends w
{
  HashSet<Uri> a = new LinkedHashSet();
  private String ad;
  private BroadcastReceiver ae;
  private View af;
  private Toolbar ag;
  private Toolbar ah;
  private MenuItem ai;
  private HashMap<Uri, Byte> aj = new HashMap();
  private HashMap<Uri, File> ak = new HashMap();
  private HashMap<Uri, String> al = new HashMap();
  private HashMap<Uri, String> am = new HashMap();
  private HashMap<Uri, String> an = new HashMap();
  private HashMap<Uri, Integer> ao = new HashMap();
  private HashMap<Uri, Uri> ap = new HashMap();
  private HashMap<Uri, Rect> aq = new HashMap();
  private HashMap<Uri, Point> ar = new HashMap();
  private HashMap<Uri, Boolean> as = new HashMap();
  private final atu at = atu.a();
  
  private void T()
  {
    boolean bool = true;
    MenuItem localMenuItem;
    if (this.a.isEmpty())
    {
      this.ah.setTitle(2131297650);
      localMenuItem = this.ai;
      if (this.a.isEmpty()) {
        break label91;
      }
    }
    for (;;)
    {
      localMenuItem.setVisible(bool);
      return;
      this.ah.setTitle(String.format(m().getQuantityString(2131230773, this.a.size()), new Object[] { Integer.valueOf(this.a.size()) }));
      break;
      label91:
      bool = false;
    }
  }
  
  public static c a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("jid", paramString);
    paramString = new c();
    paramString.f(localBundle);
    return paramString;
  }
  
  private void a(q paramq)
  {
    if (paramq == null) {
      return;
    }
    if (a())
    {
      if (this.a.contains(paramq.a()))
      {
        this.a.remove(paramq.a());
        if (!this.a.isEmpty()) {
          break label136;
        }
        R();
      }
      for (;;)
      {
        this.e.c();
        return;
        if (this.a.size() < 30)
        {
          this.a.add(paramq.a());
          this.ak.put(paramq.a(), new File(paramq.b()));
          break;
        }
        Toast.makeText(l(), 2131297851, 0).show();
        break;
        label136:
        T();
      }
    }
    HashSet localHashSet = new HashSet();
    localHashSet.add(paramq.a());
    this.ak.put(paramq.a(), new File(paramq.b()));
    a(localHashSet);
  }
  
  public final void A()
  {
    Log.i("mediapickerfragment/destroy");
    super.A();
    int j = this.d.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.d.getChildAt(i);
      if ((localView instanceof ae.a)) {
        ((ae.a)localView).setImageDrawable(null);
      }
      i += 1;
    }
  }
  
  final void R()
  {
    this.ah.setVisibility(4);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(120L);
    this.ah.startAnimation(localAlphaAnimation);
    this.ag.setVisibility(0);
    this.a.clear();
    this.ak.clear();
    this.e.c();
  }
  
  public final View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return paramLayoutInflater.inflate(2130903100, paramViewGroup, false);
  }
  
  protected final r a(boolean paramBoolean)
  {
    if (l() == null) {
      return null;
    }
    if (!paramBoolean) {}
    for (MediaManager.MediaListParam localMediaListParam = MediaManager.a();; localMediaListParam = MediaManager.a(MediaManager.a.c, 5, null)) {
      return MediaManager.a(S(), this.at, localMediaListParam);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = (android.support.v7.app.c)l();
    switch (paramInt1)
    {
    }
    do
    {
      return;
      if (paramInt2 == -1)
      {
        if ((localObject instanceof ai.a))
        {
          ((ai.a)localObject).m().b();
          return;
        }
        ((android.support.v7.app.c)localObject).setResult(-1, paramIntent);
        ((android.support.v7.app.c)localObject).finish();
        return;
      }
      if (paramInt2 == 2)
      {
        ((android.support.v7.app.c)localObject).setResult(2);
        ((android.support.v7.app.c)localObject).finish();
        return;
      }
    } while (paramInt2 != 1);
    localObject = paramIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
    this.a.clear();
    if (localObject != null) {
      this.a.addAll((Collection)localObject);
    }
    if (!a()) {
      c();
    }
    T();
    this.aj = ((HashMap)paramIntent.getSerializableExtra("types"));
    if (this.aj == null) {
      this.aj = new HashMap();
    }
    this.ak = ((HashMap)paramIntent.getSerializableExtra("files"));
    if (this.ak == null) {
      this.ak = new HashMap();
    }
    this.al = ((HashMap)paramIntent.getSerializableExtra("captions"));
    if (this.al == null) {
      this.al = new HashMap();
    }
    this.am = ((HashMap)paramIntent.getSerializableExtra("mentions"));
    if (this.am == null) {
      this.am = new HashMap();
    }
    this.an = ((HashMap)paramIntent.getSerializableExtra("doodles"));
    if (this.an == null) {
      this.an = new HashMap();
    }
    this.ao = ((HashMap)paramIntent.getSerializableExtra("rotations"));
    if (this.ao == null) {
      this.ao = new HashMap();
    }
    this.ap = ((HashMap)paramIntent.getSerializableExtra("cropuris"));
    if (this.ap == null) {
      this.ap = new HashMap();
    }
    this.aq = ((HashMap)paramIntent.getSerializableExtra("croprects"));
    if (this.aq == null) {
      this.aq = new HashMap();
    }
    this.ar = ((HashMap)paramIntent.getSerializableExtra("trims"));
    if (this.ar == null) {
      this.ar = new HashMap();
    }
    this.as = ((HashMap)paramIntent.getSerializableExtra("send_as_gif"));
    if (this.as == null) {
      this.as = new HashMap();
    }
    this.e.c();
  }
  
  public final void a(View paramView, Bundle paramBundle)
  {
    super.a(paramView, paramBundle);
    this.ag = ((Toolbar)paramView.findViewById(2131755412));
    this.ag.setNavigationIcon(new az(b.a(k(), 2130840097)));
    o.a(this.ag.getMenu().add(0, 2131755074, 0, 2131297649).setIcon(2130840076), 2);
    this.ag.setOnMenuItemClickListener$486aeec7(new d(this));
    this.ag.setNavigationOnClickListener(e.a(this));
    this.ah = ((Toolbar)paramView.findViewById(2131755200));
    this.ai = this.ah.getMenu().add(0, 2131755074, 0, 2131297331);
    o.a(this.ai, 2);
    this.ah.setNavigationIcon(new az(b.a(k(), 2130840094)));
    this.ah.setOnMenuItemClickListener$486aeec7(new f(this));
    this.ah.setNavigationOnClickListener(g.a(this));
  }
  
  protected final void a(q paramq, ab paramab)
  {
    this.af = paramab;
    a(paramq);
  }
  
  final void a(HashSet<Uri> paramHashSet)
  {
    if ((paramHashSet == null) || (paramHashSet.isEmpty())) {
      return;
    }
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll(paramHashSet);
    paramHashSet = new Intent(k(), MediaPreviewActivity.class);
    paramHashSet.putExtra("android.intent.extra.STREAM", (Serializable)localObject);
    paramHashSet.putExtra("jid", this.ad);
    paramHashSet.putExtra("max_items", 30);
    paramHashSet.putExtra("types", this.aj);
    paramHashSet.putExtra("files", this.ak);
    paramHashSet.putExtra("captions", this.al);
    paramHashSet.putExtra("mentions", this.am);
    paramHashSet.putExtra("doodles", this.an);
    paramHashSet.putExtra("rotations", this.ao);
    paramHashSet.putExtra("cropuris", this.ap);
    paramHashSet.putExtra("croprects", this.aq);
    paramHashSet.putExtra("trims", this.ar);
    paramHashSet.putExtra("send_as_gif", this.as);
    paramHashSet.putExtra("quoted_message_row_id", l().getIntent().getLongExtra("quoted_message_row_id", 0L));
    paramHashSet.putExtra("number_from_url", l().getIntent().getBooleanExtra("number_from_url", false));
    paramHashSet.putExtra("picker_open_time", l().getIntent().getLongExtra("picker_open_time", 0L));
    paramHashSet.putExtra("origin", l().getIntent().getLongExtra("origin", 1L));
    if (this.af != null)
    {
      localObject = android.support.v4.app.c.a(this.af, this.af.getLeft(), this.af.getTop(), this.af.getWidth(), this.af.getHeight());
      l().a(this, paramHashSet, 1, ((android.support.v4.app.c)localObject).a());
      return;
    }
    startActivityForResult(paramHashSet, 1);
  }
  
  final boolean a()
  {
    return this.ah.getVisibility() == 0;
  }
  
  protected final ab b()
  {
    return new ae.a(l());
  }
  
  protected final boolean b(q paramq, ab paramab)
  {
    if (a()) {
      a(paramq);
    }
    for (;;)
    {
      return true;
      this.a.add(paramq.a());
      this.ak.put(paramq.a(), new File(paramq.b()));
      c();
      this.e.c();
    }
  }
  
  final void c()
  {
    this.ah.setVisibility(0);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(120L);
    this.ah.startAnimation(localAlphaAnimation);
    this.ag.setVisibility(4);
    T();
  }
  
  public final void d(Bundle paramBundle)
  {
    Log.i("mediapickerfragment/create");
    super.d(paramBundle);
    this.ad = i().getString("jid");
    a(false, MediaManager.a(S()));
  }
  
  protected final boolean d(int paramInt)
  {
    return this.a.contains(this.b.b(paramInt).a());
  }
  
  public final void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    if (this.a != null) {
      paramBundle.putParcelableArrayList("android.intent.extra.STREAM", new ArrayList(this.a));
    }
  }
  
  public final void y()
  {
    Log.i("mediapickerfragment/resume");
    super.y();
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.MEDIA_MOUNTED");
    localIntentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
    localIntentFilter.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
    localIntentFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
    localIntentFilter.addAction("android.intent.action.MEDIA_EJECT");
    localIntentFilter.addDataScheme("file");
    this.ae = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        paramAnonymousContext = paramAnonymousIntent.getAction();
        int i = -1;
        switch (paramAnonymousContext.hashCode())
        {
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            return;
            if (paramAnonymousContext.equals("android.intent.action.MEDIA_MOUNTED"))
            {
              i = 0;
              continue;
              if (paramAnonymousContext.equals("android.intent.action.MEDIA_UNMOUNTED"))
              {
                i = 1;
                continue;
                if (paramAnonymousContext.equals("android.intent.action.MEDIA_SCANNER_STARTED"))
                {
                  i = 2;
                  continue;
                  if (paramAnonymousContext.equals("android.intent.action.MEDIA_SCANNER_FINISHED"))
                  {
                    i = 3;
                    continue;
                    if (paramAnonymousContext.equals("android.intent.action.MEDIA_EJECT")) {
                      i = 4;
                    }
                  }
                }
              }
            }
            break;
          }
        }
        Log.i("mediapickerfragment/receivemediabroadcast/ACTION_MEDIA_MOUNTED");
        return;
        Log.i("mediapickerfragment/receivemediabroadcast/ACTION_MEDIA_UNMOUNTED");
        c.a(c.this);
        return;
        Log.i("mediapickerfragment/receivemediabroadcast/ACTION_MEDIA_SCANNER_STARTED");
        c.b(c.this);
        return;
        Log.i("mediapickerfragment/receivemediabroadcast/ACTION_MEDIA_SCANNER_FINISHED");
        c.c(c.this);
        return;
        Log.i("mediapickerfragment/receivemediabroadcast/ACTION_MEDIA_EJECT");
        c.d(c.this);
      }
    };
    l().registerReceiver(this.ae, localIntentFilter);
  }
  
  public final void z()
  {
    Log.i("mediapickerfragment/pause");
    super.z();
    if (this.ae != null)
    {
      l().unregisterReceiver(this.ae);
      this.ae = null;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/camera/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */