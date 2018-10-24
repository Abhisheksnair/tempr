package com.whatsapp.gallerypicker;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.a;
import android.support.v4.view.o;
import android.support.v7.view.b.a;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import com.whatsapp.atu;
import com.whatsapp.nh;
import com.whatsapp.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

public final class ae
  extends w
{
  private int a;
  private boolean ad = true;
  private String ae;
  private int af = Integer.MAX_VALUE;
  private BroadcastReceiver ag = null;
  private HashSet<Uri> ah = new LinkedHashSet();
  private View ai;
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
  private android.support.v7.view.b au;
  private b.a av = new b.a()
  {
    private MenuItem b;
    
    public final void a(android.support.v7.view.b paramAnonymousb)
    {
      ae.a(ae.this).clear();
      ae.b(ae.this);
      ae.this.e.c();
      if (Build.VERSION.SDK_INT >= 21) {
        ae.this.l().getWindow().setStatusBarColor(android.support.v4.content.b.c(ae.this.l(), 17170444));
      }
    }
    
    public final boolean a(android.support.v7.view.b paramAnonymousb, Menu paramAnonymousMenu)
    {
      this.b = paramAnonymousMenu.add(0, 0, 0, 2131297331);
      o.a(this.b, 2);
      if (Build.VERSION.SDK_INT >= 21) {
        ae.this.l().getWindow().setStatusBarColor(android.support.v4.content.b.c(ae.this.l(), 2131624092));
      }
      return true;
    }
    
    public final boolean a(android.support.v7.view.b paramAnonymousb, MenuItem paramAnonymousMenuItem)
    {
      switch (paramAnonymousMenuItem.getItemId())
      {
      }
      for (;;)
      {
        return false;
        ae.a(ae.this, ae.a(ae.this));
      }
    }
    
    public final boolean b(android.support.v7.view.b paramAnonymousb, Menu paramAnonymousMenu)
    {
      boolean bool = false;
      if (ae.a(ae.this).isEmpty()) {
        paramAnonymousb.a(2131297650);
      }
      for (;;)
      {
        paramAnonymousb = this.b;
        if (!ae.a(ae.this).isEmpty()) {
          bool = true;
        }
        paramAnonymousb.setVisible(bool);
        return true;
        paramAnonymousb.b(String.format(ae.this.m().getQuantityString(2131230773, ae.a(ae.this).size()), new Object[] { Integer.valueOf(ae.a(ae.this).size()) }));
      }
    }
  };
  
  private void a(q paramq)
  {
    if (paramq == null) {
      return;
    }
    if (this.au != null)
    {
      if (this.ah.contains(paramq.a()))
      {
        this.ah.remove(paramq.a());
        if (!this.ah.isEmpty()) {
          break label141;
        }
        this.au.c();
      }
      for (;;)
      {
        this.e.c();
        return;
        if (this.ah.size() < this.af)
        {
          this.ah.add(paramq.a());
          this.ak.put(paramq.a(), new File(paramq.b()));
          break;
        }
        Toast.makeText(l(), 2131297851, 0).show();
        break;
        label141:
        this.au.d();
      }
    }
    HashSet localHashSet = new HashSet();
    localHashSet.add(paramq.a());
    this.ak.put(paramq.a(), new File(paramq.b()));
    a(localHashSet);
  }
  
  private void a(HashSet<Uri> paramHashSet)
  {
    if ((paramHashSet == null) || (paramHashSet.isEmpty())) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(paramHashSet);
    if (this.ad)
    {
      paramHashSet = new Intent(k(), MediaPreviewActivity.class);
      paramHashSet.putExtra("android.intent.extra.STREAM", localArrayList);
      paramHashSet.putExtra("jid", this.ae);
      paramHashSet.putExtra("max_items", this.af);
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
      if (this.ai != null)
      {
        localObject = android.support.v4.app.c.a(this.ai, this.ai.getLeft(), this.ai.getTop(), this.ai.getWidth(), this.ai.getHeight());
        a.a(l(), paramHashSet, 1, ((android.support.v4.app.c)localObject).a());
        return;
      }
      l().startActivityForResult(paramHashSet, 1);
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("bucket_uri", l().getIntent().getData());
    ((Intent)localObject).putParcelableArrayListExtra("android.intent.extra.STREAM", localArrayList);
    if (localArrayList.size() == 1) {}
    for (paramHashSet = (Uri)localArrayList.get(0);; paramHashSet = null)
    {
      ((Intent)localObject).setData(paramHashSet);
      l().setResult(-1, (Intent)localObject);
      l().finish();
      return;
    }
  }
  
  public final void A()
  {
    Log.i("mediapickerfragment/destroy");
    super.A();
    this.av = null;
    this.au = null;
    int j = this.d.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.d.getChildAt(i);
      if ((localView instanceof a)) {
        ((a)localView).setImageDrawable(null);
      }
      i += 1;
    }
  }
  
  protected final r a(boolean paramBoolean)
  {
    ContentResolver localContentResolver = null;
    Object localObject = l();
    if (localObject == null) {
      return null;
    }
    Uri localUri = ((Activity)localObject).getIntent().getData();
    if (localUri != null)
    {
      localObject = localUri.toString();
      if (!((String)localObject).startsWith(be.a.toString())) {
        break label96;
      }
      localContentResolver = S();
      if (localUri == null) {
        break label91;
      }
    }
    label91:
    for (localObject = localUri.getQueryParameter("bucketId");; localObject = null)
    {
      localObject = new be(localContentResolver, (String)localObject, this.a);
      return (r)localObject;
      localObject = "";
      break;
    }
    label96:
    if (!paramBoolean) {}
    MediaManager.a locala;
    int i;
    for (localObject = MediaManager.a();; localObject = MediaManager.a(locala, i, (String)localObject))
    {
      localObject = MediaManager.a(S(), this.at, (MediaManager.MediaListParam)localObject);
      break;
      locala = MediaManager.a.c;
      i = this.a;
      localObject = localContentResolver;
      if (localUri != null) {
        localObject = localUri.getQueryParameter("bucketId");
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    android.support.v7.app.c localc = (android.support.v7.app.c)l();
    switch (paramInt1)
    {
    }
    do
    {
      return;
      if (paramInt2 == -1)
      {
        localc.setResult(-1, paramIntent);
        localc.finish();
        return;
      }
      if (paramInt2 == 2)
      {
        localc.setResult(2);
        localc.finish();
        return;
      }
    } while (paramInt2 != 1);
    ArrayList localArrayList = paramIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
    this.ah.clear();
    if (localArrayList != null) {
      this.ah.addAll(localArrayList);
    }
    if (this.au == null) {
      this.au = localc.a(this.av);
    }
    for (;;)
    {
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
      return;
      this.au.d();
    }
  }
  
  public final void a(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    if (this.af > 1) {
      o.a(paramMenu.add(0, 2131755074, 0, 2131297649).setIcon(2130840076), 2);
    }
  }
  
  protected final void a(q paramq, ab paramab)
  {
    this.ai = paramab;
    a(paramq);
  }
  
  public final boolean a(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131755074)
    {
      this.au = ((android.support.v7.app.c)l()).a(this.av);
      this.e.c();
      return true;
    }
    return super.a(paramMenuItem);
  }
  
  public final ab b()
  {
    return new a(l());
  }
  
  protected final boolean b(q paramq, ab paramab)
  {
    if (this.af <= 1) {
      return false;
    }
    if (this.au != null) {
      a(paramq);
    }
    for (;;)
    {
      return true;
      this.ah.add(paramq.a());
      this.ak.put(paramq.a(), new File(paramq.b()));
      this.au = ((android.support.v7.app.c)l()).a(this.av);
      this.e.c();
    }
  }
  
  public final void d(Bundle paramBundle)
  {
    int j = 1;
    Log.i("mediapickerfragment/create");
    super.d(paramBundle);
    android.support.v7.app.c localc = (android.support.v7.app.c)l();
    Intent localIntent = localc.getIntent();
    this.af = localIntent.getIntExtra("max_items", Integer.MAX_VALUE);
    this.ad = localIntent.getBooleanExtra("preview", true);
    this.ae = localIntent.getStringExtra("jid");
    this.a = 7;
    nh localnh = (nh)l();
    Object localObject1 = localnh.getIntent();
    int i;
    if (localObject1 != null)
    {
      Object localObject2 = ((Intent)localObject1).resolveType(localnh);
      if (localObject2 != null)
      {
        if ((!((String)localObject2).equals("vnd.android.cursor.dir/image")) && (!((String)localObject2).equals("image/*"))) {
          break label362;
        }
        i = 1;
        if (i != 0)
        {
          this.a = 1;
          localnh.setTitle(2131297467);
        }
        i = j;
        if (!((String)localObject2).equals("vnd.android.cursor.dir/video"))
        {
          if (!((String)localObject2).equals("video/*")) {
            break label367;
          }
          i = j;
        }
        label174:
        if (i != 0)
        {
          this.a = 4;
          localnh.setTitle(2131297468);
        }
      }
      localObject2 = ((Intent)localObject1).getExtras();
      if (localObject2 == null) {
        break label372;
      }
      localObject1 = ((Bundle)localObject2).getString("window_title");
      label213:
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localnh.f((String)localObject1);
      }
      if (localObject2 != null) {
        this.a = (((Bundle)localObject2).getInt("include_media", this.a) & 0x7);
      }
    }
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getParcelableArrayList("android.intent.extra.STREAM");
      label263:
      if ((paramBundle != null) && (!paramBundle.isEmpty()))
      {
        this.ah.clear();
        this.ah.addAll(paramBundle);
        this.au = localc.a(this.av);
        this.e.c();
      }
      paramBundle = localIntent.getData();
      if (paramBundle == null) {
        break label389;
      }
    }
    label362:
    label367:
    label372:
    label389:
    for (paramBundle = paramBundle.toString();; paramBundle = "")
    {
      Log.i("mediapickerfragment/create/" + paramBundle);
      s();
      a(false, MediaManager.a(S()));
      return;
      i = 0;
      break;
      i = 0;
      break label174;
      localObject1 = null;
      break label213;
      paramBundle = localIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
      break label263;
    }
  }
  
  protected final boolean d(int paramInt)
  {
    return this.ah.contains(this.b.b(paramInt).a());
  }
  
  public final void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    if (this.ah != null) {
      paramBundle.putParcelableArrayList("android.intent.extra.STREAM", new ArrayList(this.ah));
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
    this.ag = new BroadcastReceiver()
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
        ae.this.a(true, false);
        return;
        Log.i("mediapickerfragment/receivemediabroadcast/ACTION_MEDIA_SCANNER_STARTED");
        ae.this.a(false, true);
        return;
        Log.i("mediapickerfragment/receivemediabroadcast/ACTION_MEDIA_SCANNER_FINISHED");
        ae.this.a(false, false);
        return;
        Log.i("mediapickerfragment/receivemediabroadcast/ACTION_MEDIA_EJECT");
        ae.this.a(true, false);
      }
    };
    l().registerReceiver(this.ag, localIntentFilter);
  }
  
  public final void z()
  {
    Log.i("mediapickerfragment/pause");
    super.z();
    if (this.ag != null)
    {
      l().unregisterReceiver(this.ag);
      this.ag = null;
    }
  }
  
  public static class a
    extends ab
  {
    private Drawable a;
    
    public a(Context paramContext)
    {
      super();
    }
    
    public final void a(Canvas paramCanvas)
    {
      super.a(paramCanvas);
      if (this.a != null)
      {
        int i = this.a.getIntrinsicHeight() / 4;
        this.a.setBounds(i, getHeight() - this.a.getIntrinsicHeight() - i, this.a.getIntrinsicWidth() + i, getHeight() - i);
        this.a.draw(paramCanvas);
      }
    }
    
    public void setMediaItem(q paramq)
    {
      super.setMediaItem(paramq);
      if (paramq != null)
      {
        if (((paramq instanceof at)) || ((paramq instanceof bf)))
        {
          this.a = android.support.v4.content.b.a(getContext(), 2130840345);
          return;
        }
        if (((paramq instanceof n)) || ((paramq instanceof bb)))
        {
          this.a = android.support.v4.content.b.a(getContext(), 2130840344);
          return;
        }
        this.a = null;
        return;
      }
      this.a = null;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gallerypicker/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */